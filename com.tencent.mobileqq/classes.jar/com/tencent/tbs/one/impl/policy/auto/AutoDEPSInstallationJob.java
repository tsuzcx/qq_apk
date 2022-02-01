package com.tencent.tbs.one.impl.policy.auto;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.base.CancellableJob;
import com.tencent.tbs.one.impl.base.FileUtils;
import com.tencent.tbs.one.impl.base.GlobalUtils;
import com.tencent.tbs.one.impl.base.JSONUtils;
import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.common.CommonUtils;
import com.tencent.tbs.one.impl.common.Constants;
import com.tencent.tbs.one.impl.common.DEPSConfig;
import com.tencent.tbs.one.impl.common.PathService;
import com.tencent.tbs.one.impl.common.Statistics;
import com.tencent.tbs.one.impl.net.HttpRequestJob;
import com.tencent.tbs.one.impl.net.HttpRequestJob.Client;
import com.tencent.tbs.one.impl.policy.InstallationResult;
import com.tencent.tbs.one.impl.policy.InstallationResult.Source;
import com.tencent.tbs.one.impl.policy.InstallationUtils;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;
import com.tencent.tbs.sdk.BuildConfig;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AutoDEPSInstallationJob
  extends CancellableJob<InstallationResult<DEPSConfig>>
  implements HttpRequestJob.Client
{
  private static final int FUNCTION_ID = 0;
  private static final int PROTOCOL_VERSION = 1;
  private static final String TBS_METADATA = "com.tencent.mm.BuildInfo.CLIENT_VERSION";
  private Context mCallerContext;
  private String mCategory;
  private int mInterceptedToken;
  private Bundle mOptions;
  private File mOutputFile;
  private int mRequestDEPSVersion;
  private HttpRequestJob mRequestJob;
  private String[] mSharableApplicationPackages;
  private String mUrl;
  
  public AutoDEPSInstallationJob(Context paramContext, String paramString1, String paramString2, String[] paramArrayOfString, int paramInt, File paramFile, Bundle paramBundle)
  {
    this.mCallerContext = paramContext;
    this.mCategory = paramString1;
    this.mUrl = paramString2;
    this.mSharableApplicationPackages = paramArrayOfString;
    this.mRequestDEPSVersion = paramInt;
    this.mOutputFile = paramFile;
    this.mOptions = paramBundle;
  }
  
  private int getInUseDEPSVersion(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences(String.format("com.tencent.tbs.one.%s.prefs", new Object[] { paramString }), 4).getInt("in_use_deps_version", -1);
  }
  
  private boolean isNeedIgnoreFrequencyLimit()
  {
    boolean bool = false;
    if (this.mOptions != null) {
      bool = this.mOptions.getBoolean("is_ignore_frequency_limitation", false);
    }
    return bool;
  }
  
  public void cancel()
  {
    super.cancel();
    if (this.mRequestJob != null) {
      this.mRequestJob.cancel();
    }
    if (this.mInterceptedToken != 0)
    {
      TBSOneRuntimeExtension localTBSOneRuntimeExtension = CommonUtils.getRuntimeExtension(this.mCallerContext, this.mCategory);
      if (localTBSOneRuntimeExtension != null) {
        localTBSOneRuntimeExtension.cancel(this.mInterceptedToken);
      }
    }
  }
  
  public void fail(int paramInt, String paramString, Throwable paramThrowable)
  {
    InstallationUtils.setLastFailedTimeMillis(this.mOutputFile, System.currentTimeMillis());
    super.fail(paramInt, paramString, paramThrowable);
  }
  
  public JSONObject getComponentSDKVersions()
  {
    try
    {
      JSONObject localJSONObject = JSONUtils.convertMapToJSONObject(BuildConfig.COMPONENT_SDK_VERSIONS);
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      Logging.e("[%s] Failed to get component sdk versions", new Object[] { this.mCategory, localThrowable });
    }
    return new JSONObject();
  }
  
  public JSONArray getHostDEPSVersions()
  {
    JSONArray localJSONArray = new JSONArray();
    Context localContext = this.mCallerContext;
    String str1 = this.mCategory;
    String[] arrayOfString = this.mSharableApplicationPackages;
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      int i = 0;
      if (i < j)
      {
        String str2 = arrayOfString[i];
        if (str2.equals(localContext.getPackageName())) {}
        for (;;)
        {
          i += 1;
          break;
          try
          {
            int k = getInUseDEPSVersion(localContext.createPackageContext(str2, 2), str1);
            if (k != -1) {
              localJSONArray.put(k);
            }
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
        }
      }
    }
    return localJSONArray;
  }
  
  public JSONObject getLocalComponentVersions()
  {
    File[] arrayOfFile = PathService.getComponentsDirectory(PathService.getCategoryDirectory(PathService.getDataRootDirectory(this.mCallerContext), this.mCategory)).listFiles();
    JSONObject localJSONObject = new JSONObject();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        JSONUtils.putQuietly(localJSONObject, localFile.getName(), Integer.valueOf(InstallationUtils.getLocalComponentVersion(localFile)));
        i += 1;
      }
    }
    return localJSONObject;
  }
  
  public void onResponseReceived(int paramInt, Map<String, List<String>> paramMap, InputStream paramInputStream)
  {
    Context localContext = this.mCallerContext;
    String str = this.mCategory;
    Object localObject = this.mUrl;
    File localFile = this.mOutputFile;
    Logging.i("[%s] Receiving DEPS response: [%d] %s", new Object[] { str, Integer.valueOf(paramInt), paramMap });
    if ((paramInt != 200) || (paramInputStream == null))
    {
      fail(210, "Invalid DEPS response stream, url: " + (String)localObject + ", statusCode: " + paramInt, null);
      return;
    }
    paramMap = CommonUtils.getRuntimeExtension(localContext, str);
    if (paramMap != null)
    {
      paramInt = paramMap.shouldInterceptDEPSResponse(str, null, paramInputStream, localFile, new AutoDEPSInstallationJob.3(this, str, localFile));
      if (paramInt != 0)
      {
        Logging.i("[%s] Intercepted DEPS response stream by runtime extension", new Object[] { str });
        this.mInterceptedToken = paramInt;
        return;
      }
    }
    try
    {
      paramInputStream = FileUtils.readStreamToString(paramInputStream, "utf-8");
      paramInputStream = paramMap.optString("DEPS");
    }
    catch (IOException paramMap)
    {
      try
      {
        paramMap = new JSONObject(paramInputStream);
        Logging.i("[%s] Receiving DEPS data %s", new Object[] { str, paramMap });
        paramInt = paramMap.optInt("CODE", -1);
        if (paramInt == 0) {
          break label337;
        }
        paramMap = paramMap.optString("MSG");
        fail(213, "Failed to request DEPS, url: " + (String)localObject + ", response code: " + paramInt + ", message: " + paramMap, null);
        return;
      }
      catch (JSONException paramMap)
      {
        fail(212, "Failed to parse DEPS response " + paramInputStream + ", url: " + (String)localObject, paramMap);
        return;
      }
      paramMap = paramMap;
      fail(211, "Failed to read DEPS response, url:" + (String)localObject, paramMap);
      return;
    }
    try
    {
      label337:
      localObject = DEPSConfig.parse(paramInputStream);
      FileUtils.writeFile(paramInputStream, "utf-8", localFile);
      paramInputStream = InstallationResult.make(InstallationResult.Source.ONLINE, localObject);
      paramInputStream.extra = paramMap;
      finish(paramInputStream);
      return;
    }
    catch (TBSOneException paramMap)
    {
      fail(paramMap.getErrorCode(), paramMap.getMessage(), paramMap.getCause());
      return;
    }
    catch (IOException paramMap)
    {
      fail(305, "Failed to save online DEPS to " + localFile.getAbsolutePath(), paramMap);
    }
  }
  
  public void run()
  {
    Context localContext = this.mCallerContext;
    String str1 = this.mCategory;
    String str2 = this.mUrl;
    Object localObject1 = this.mOutputFile;
    Object localObject2 = CommonUtils.getRuntimeExtension(localContext, str1);
    if (localObject2 != null)
    {
      int i = ((TBSOneRuntimeExtension)localObject2).shouldOverrideInstallationJob(str1, "DEPS", -1, null, (File)localObject1, new AutoDEPSInstallationJob.1(this, str1, (File)localObject1));
      if (i != 0)
      {
        Logging.i("[%s] Intercepted DEPS installation job by runtime extension", new Object[] { str1 });
        this.mInterceptedToken = i;
        return;
      }
    }
    if (!isNeedIgnoreFrequencyLimit())
    {
      long l = InstallationUtils.getLastFailedTimeMillis((File)localObject1);
      if (System.currentTimeMillis() - l < 86400000L)
      {
        super.fail(209, "Too many DEPS requests, last request time: " + GlobalUtils.formatDateTime(l), null);
        return;
      }
      InstallationUtils.clearLastFailedTimeMillis((File)localObject1);
    }
    Statistics.reportAction(1001);
    JSONObject localJSONObject = new JSONObject();
    JSONUtils.putQuietly(localJSONObject, "ONEV", Integer.valueOf(1));
    JSONUtils.putQuietly(localJSONObject, "DEPSV", Integer.valueOf(getInUseDEPSVersion(localContext, str1)));
    JSONUtils.putQuietly(localJSONObject, "HSTV", getHostDEPSVersions());
    JSONUtils.putQuietly(localJSONObject, "SDKV", getComponentSDKVersions());
    JSONUtils.putQuietly(localJSONObject, "LOCV", getLocalComponentVersions());
    if (this.mRequestDEPSVersion != -1) {
      JSONUtils.putQuietly(localJSONObject, "REQV", Integer.valueOf(this.mRequestDEPSVersion));
    }
    JSONUtils.putQuietly(localJSONObject, "PROTV", Integer.valueOf(1));
    JSONUtils.putQuietly(localJSONObject, "FUNC", Integer.valueOf(0));
    String str3 = localContext.getPackageName();
    JSONUtils.putQuietly(localJSONObject, "PN", str3);
    localObject2 = localContext.getPackageManager();
    try
    {
      localObject1 = ((PackageManager)localObject2).getPackageInfo(str3, 0);
      JSONUtils.putQuietly(localJSONObject, "PPVN", ((PackageInfo)localObject1).versionName);
      JSONUtils.putQuietly(localJSONObject, "PPVC", Integer.valueOf(((PackageInfo)localObject1).versionCode));
      localObject1 = null;
    }
    catch (PackageManager.NameNotFoundException localException1)
    {
      try
      {
        localObject2 = ((PackageManager)localObject2).getApplicationInfo(str3, 128);
        localObject1 = localObject2;
        if (localObject1 != null)
        {
          JSONUtils.putQuietly(localJSONObject, "TAPI", Integer.valueOf(((ApplicationInfo)localObject1).targetSdkVersion));
          if (((ApplicationInfo)localObject1).metaData != null)
          {
            localObject1 = ((ApplicationInfo)localObject1).metaData.get("com.tencent.mm.BuildInfo.CLIENT_VERSION");
            if (localObject1 == null) {}
          }
        }
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            JSONUtils.putQuietly(localJSONObject, "META", Integer.toHexString(Integer.parseInt(String.valueOf(localObject1))));
            JSONUtils.putQuietly(localJSONObject, "BVR", Build.VERSION.RELEASE);
            JSONUtils.putQuietly(localJSONObject, "ABI", GlobalUtils.getCpuAbi(localContext));
            JSONUtils.putQuietly(localJSONObject, "IMEI", GlobalUtils.getImei(localContext));
            JSONUtils.putQuietly(localJSONObject, "GUID", "");
            JSONUtils.putQuietly(localJSONObject, "ADRID", GlobalUtils.getAndroidID(localContext));
            JSONUtils.putQuietly(localJSONObject, "UA", GlobalUtils.getDefaultUserAgent(localContext));
            Logging.i("[%s] Requesting DEPS from %s, post data: %s", new Object[] { str1, str2, localJSONObject });
            this.mRequestJob = new HttpRequestJob(localContext, str2, "POST", null, localJSONObject.toString().getBytes(Constants.UTF8_CHARSET));
            this.mRequestJob.setClient(this);
            this.mRequestJob.start(new AutoDEPSInstallationJob.2(this));
            return;
            localNameNotFoundException = localNameNotFoundException;
            Logging.e("Failed to get package info for %s", new Object[] { str3, localNameNotFoundException });
          }
          localException1 = localException1;
          Logging.e("Failed to get application info for %s", new Object[] { str3, localException1 });
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Logging.e("Failed to parse meta data %s", new Object[] { localNameNotFoundException, localException2 });
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.auto.AutoDEPSInstallationJob
 * JD-Core Version:    0.7.0.1
 */