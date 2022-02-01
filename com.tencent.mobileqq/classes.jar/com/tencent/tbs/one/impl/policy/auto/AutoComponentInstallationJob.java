package com.tencent.tbs.one.impl.policy.auto;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.base.CancellableJob;
import com.tencent.tbs.one.impl.base.FileUtils;
import com.tencent.tbs.one.impl.base.GlobalUtils;
import com.tencent.tbs.one.impl.base.JSONUtils;
import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.base.ThreadUtils;
import com.tencent.tbs.one.impl.common.CommonUtils;
import com.tencent.tbs.one.impl.common.Constants;
import com.tencent.tbs.one.impl.common.DEPSConfig.ComponentConfig;
import com.tencent.tbs.one.impl.common.PathService;
import com.tencent.tbs.one.impl.common.Statistics;
import com.tencent.tbs.one.impl.net.HttpRequestJob;
import com.tencent.tbs.one.impl.policy.InstallationResult;
import com.tencent.tbs.one.impl.policy.InstallationResult.Source;
import com.tencent.tbs.one.impl.policy.InstallationUtils;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AutoComponentInstallationJob
  extends CancellableJob<InstallationResult<File>>
{
  private static final int DOWNLOAD_PROGRESS_BASE = 40;
  private static final int EXTENSION_PROGRESS_BASE = 70;
  private static final int FUNCTION_ID = 1;
  private static final int PROTOCOL_VERSION = 1;
  private static final int TYPE_FULL = 0;
  private static final int TYPE_INCREMENTAL = 1;
  private File mBackupPath;
  private Context mCallerContext;
  private String mCategory;
  private DEPSConfig.ComponentConfig mComponentConfig;
  private long mContentLength = -1L;
  private int mInterceptedToken;
  private String mMD5;
  private String mName;
  private Bundle mOptions;
  private File mOutputDirectory;
  private HttpRequestJob mRequestJob;
  private int mRequestVersion;
  private JSONObject mResponse;
  private String[] mSharableApplicationPackages;
  private int mType;
  private String mUrl;
  
  public AutoComponentInstallationJob(Context paramContext, String paramString1, String paramString2, String[] paramArrayOfString, DEPSConfig.ComponentConfig paramComponentConfig, File paramFile, Bundle paramBundle)
  {
    this.mCallerContext = paramContext;
    this.mCategory = paramString1;
    this.mSharableApplicationPackages = paramArrayOfString;
    paramContext = paramComponentConfig.getUrl();
    if (TextUtils.isEmpty(paramContext)) {}
    for (;;)
    {
      this.mUrl = paramString2;
      this.mName = paramComponentConfig.getName();
      this.mRequestVersion = paramComponentConfig.getVersionCode();
      this.mOutputDirectory = paramFile;
      this.mOptions = paramBundle;
      this.mComponentConfig = paramComponentConfig;
      this.mBackupPath = PathService.getSdcardBackupDirectory(this.mCallerContext, this.mCallerContext, paramString1, paramComponentConfig.getName(), paramComponentConfig.getVersionCode());
      return;
      paramString2 = paramContext;
    }
  }
  
  private boolean copyFromSharableApplication(String paramString)
  {
    Object localObject = this.mCallerContext;
    String str1 = this.mCategory;
    String str2 = this.mName;
    int i = this.mRequestVersion;
    File localFile = this.mOutputDirectory;
    try
    {
      localObject = PathService.getComponentInstallationDirectory(PathService.getCategoryDirectory(PathService.getDataRootDirectory(((Context)localObject).createPackageContext(paramString, 2)), str1), str2, i);
      if ((((File)localObject).exists()) && (InstallationUtils.isArchiveComplete((File)localObject)))
      {
        FileUtils.recursivelyCopyFile((File)localObject, localFile);
        InstallationUtils.verifyInstallationDirectory(localFile, i);
        Logging.i("[%s] {%s} Finished copy component from %s", new Object[] { str1, str2, paramString });
        return true;
      }
    }
    catch (Exception localException)
    {
      Logging.i("[%s] {%s} Failed copy component from %s,exception is", new Object[] { str1, str2, paramString, localException.toString() });
      FileUtils.recursivelyDeleteFile(localFile);
    }
    return false;
  }
  
  private boolean copyFromSharableApplications()
  {
    if (this.mSharableApplicationPackages != null)
    {
      String[] arrayOfString = this.mSharableApplicationPackages;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (InstallationUtils.vertificateApp(this.mCallerContext, str))
        {
          if (copyFromSharableApplication(str)) {
            return true;
          }
        }
        else {
          Logging.i("copyFromSharableApplications,verify app %s failed", new Object[] { str });
        }
        i += 1;
      }
    }
    return false;
  }
  
  private void downloadInstallationPackage(String paramString, int paramInt)
  {
    Logging.i("[%s] {%s} Downloading component from %s", new Object[] { this.mCategory, this.mName, paramString });
    if (isUpdateJob()) {
      Statistics.reportAction(1015, this.mName);
    }
    for (;;)
    {
      this.mRequestJob = new HttpRequestJob(this.mCallerContext, paramString);
      if (!isIgnoreWifiNetwork()) {
        this.mRequestJob.setAllowWifiOnly(true);
      }
      this.mRequestJob.setClient(new AutoComponentInstallationJob.5(this, paramString, paramInt));
      this.mRequestJob.start(new AutoComponentInstallationJob.6(this));
      return;
      Statistics.reportAction(1005, this.mName);
    }
  }
  
  private boolean installFromSdcardIfExist()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    String[] arrayOfString;
    int j;
    int i;
    if (this.mSharableApplicationPackages != null)
    {
      arrayOfString = this.mSharableApplicationPackages;
      j = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < j)
      {
        if (installFromSdcardPkg(arrayOfString[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean installFromSdcardPkg(String paramString)
  {
    try
    {
      Object localObject = this.mCallerContext.createPackageContext(paramString, 2);
      if (localObject != null)
      {
        localObject = PathService.getSdcardBackupDirectory(this.mCallerContext, (Context)localObject, this.mCategory, this.mComponentConfig.getName(), this.mComponentConfig.getVersionCode());
        Logging.i("installFromSdcardPkg,backup dir=%s", new Object[] { localObject });
        if (localObject == null) {
          return false;
        }
        localObject = new File((File)localObject, this.mComponentConfig.getName() + ".tbs");
        if ((!((File)localObject).exists()) || (!((File)localObject).isFile()))
        {
          Logging.i("installFromSdcardPkg,pkgname=%s,backup file %s not exist", new Object[] { paramString, localObject });
          return false;
        }
        boolean bool = InstallationUtils.verifyPkgLegality((File)localObject);
        if (bool) {
          try
          {
            localObject = new FileInputStream((File)localObject);
            FileUtils.unzipStream((InputStream)localObject, this.mOutputDirectory, null);
            FileUtils.close((Closeable)localObject);
            InstallationUtils.extractFromInstallationPackage(this.mOutputDirectory, this.mOutputDirectory);
            InstallationUtils.verifyInstallationDirectory(this.mOutputDirectory, this.mComponentConfig.getVersionCode());
            return true;
          }
          catch (TBSOneException localTBSOneException)
          {
            Logging.i("installFromSdcardPkg failed,packageName=%s,exception=%s", new Object[] { paramString, Log.getStackTraceString(localTBSOneException) });
            return false;
          }
          catch (IOException localIOException)
          {
            label189:
            break label189;
          }
        }
      }
      return false;
    }
    catch (PackageManager.NameNotFoundException paramString) {}
    return false;
  }
  
  private boolean isIgnoreFrequencyLimit()
  {
    boolean bool = false;
    if (this.mOptions != null) {
      bool = this.mOptions.getBoolean("is_ignore_frequency_limitation", false);
    }
    return bool;
  }
  
  private boolean isIgnoreWifiNetwork()
  {
    boolean bool = false;
    if (this.mOptions != null) {
      bool = this.mOptions.getBoolean("is_ignore_wifi_state", false);
    }
    return bool;
  }
  
  private boolean isUpdateJob()
  {
    if (this.mOptions != null) {
      return this.mOptions.getInt("info_from", -1) == 1;
    }
    return false;
  }
  
  private void onDownloadResponseReceived(String paramString, int paramInt1, Map<String, List<String>> paramMap, InputStream paramInputStream, int paramInt2)
  {
    Context localContext = this.mCallerContext;
    String str1 = this.mCategory;
    String str2 = this.mName;
    int i = this.mRequestVersion;
    File localFile2 = this.mOutputDirectory;
    if (this.mBackupPath == null) {}
    for (File localFile1 = null;; localFile1 = new File(this.mBackupPath, this.mComponentConfig.getName() + ".tbs"))
    {
      Logging.i("[%s] {%s} Receiving component download response: [%d] %s", new Object[] { str1, str2, Integer.valueOf(paramInt1), paramMap });
      if ((paramInt1 == 200) && (paramInputStream != null)) {
        break;
      }
      fail(220, "Invalid component download stream, url: " + paramString + ", statusCode: " + paramInt1, null);
      return;
      if (!this.mBackupPath.exists()) {
        this.mBackupPath.mkdirs();
      }
    }
    if (this.mType == 1)
    {
      Logging.i("[%s] {%s} Asking runtime extension to intercept download stream", new Object[] { str1, str2 });
      try
      {
        paramString = CommonUtils.loadRuntimeExtensionSync(localContext, str1);
        paramMap = new HashMap();
        paramMap.put("localVersion", Integer.valueOf(paramInt2));
        paramMap.put("localVersionDirectory", PathService.getComponentInstallationDirectory(localContext, str1, str2, paramInt2).getAbsolutePath());
        paramMap.put("controlMessage", this.mResponse);
        paramInt1 = paramString.shouldInterceptComponentResponse(str1, str2, i, paramMap, paramInputStream, localFile2, new AutoComponentInstallationJob.7(this, str1, str2, localFile2, localContext, i));
        if (paramInt1 != 0)
        {
          Logging.i("[%s] {%s} Intercepted component download stream by runtime extension", new Object[] { str1, str2 });
          this.mInterceptedToken = paramInt1;
          return;
        }
      }
      catch (TBSOneException paramString)
      {
        fail(paramString.getErrorCode(), paramString.getMessage(), paramString.getCause());
        return;
      }
    }
    try
    {
      InstallationUtils.unzipFromDownloadStream(paramInputStream, this.mMD5, this.mContentLength, localFile2, localFile1, new AutoComponentInstallationJob.8(this));
      InstallationUtils.extractFromInstallationPackage(localFile2, localFile2);
      InstallationUtils.verifyInstallationDirectory(localFile2, i);
      InstallationUtils.setDirectoryExcutableIfNeeded(PathService.getDataRootDirectory(this.mCallerContext));
      InstallationUtils.shareFile(localFile2);
      paramString = InstallationResult.make(InstallationResult.Source.ONLINE, localFile2);
      paramString.extra = this.mResponse;
      finish(paramString);
      return;
    }
    catch (TBSOneException paramString)
    {
      fail(paramString.getErrorCode(), paramString.getMessage(), paramString.getCause());
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Logging.e("null pointer occured,e=%s", new Object[] { Log.getStackTraceString(paramString) });
      }
    }
  }
  
  private void onInformationResponseReceived(int paramInt1, Map<String, List<String>> paramMap, InputStream paramInputStream, int paramInt2)
  {
    Context localContext = this.mCallerContext;
    String str3 = this.mCategory;
    String str1 = this.mUrl;
    String str2 = this.mName;
    Logging.i("[%s] {%s} Receiving component information response: [%d] %s", new Object[] { str3, str2, Integer.valueOf(paramInt1), paramMap });
    if ((paramInt1 != 200) || (paramInputStream == null))
    {
      fail(216, "Invalid component information stream, url: " + str1 + ", statusCode: " + paramInt1, null);
      return;
    }
    try
    {
      paramMap = FileUtils.readStreamToString(paramInputStream, "utf-8");
      paramInt1 = paramInputStream.optInt("TYPE");
    }
    catch (IOException paramMap)
    {
      try
      {
        paramInputStream = new JSONObject(paramMap);
        Logging.i("[%s] {%s} Receiving component information data %s", new Object[] { str3, str2, paramInputStream });
        paramInt1 = paramInputStream.optInt("CODE", -1);
        if (paramInt1 == 0) {
          break label323;
        }
        paramMap = paramInputStream.optString("MSG");
        fail(219, "Failed to request component " + str2 + " information, url: " + str1 + ", response code: " + paramInt1 + ", message: " + paramMap, null);
        return;
      }
      catch (JSONException paramInputStream)
      {
        fail(218, "Failed to parse component " + str2 + " information " + paramMap + ", url: " + str1, paramInputStream);
        return;
      }
      paramMap = paramMap;
      fail(217, "Failed to read component " + str2 + " information, url: " + str1, paramMap);
      return;
    }
    label323:
    if (paramInt1 == 1) {
      CommonUtils.preloadRuntimeExtension(localContext, this.mCategory);
    }
    this.mType = paramInt1;
    this.mMD5 = paramInputStream.optString("MD5");
    this.mContentLength = paramInputStream.optLong("BYTE");
    this.mResponse = paramInputStream;
    downloadInstallationPackage(paramInputStream.optString("URL"), paramInt2);
  }
  
  private void requestInformation(Context paramContext, String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    JSONUtils.putQuietly(localJSONObject, "PROTV", Integer.valueOf(1));
    JSONUtils.putQuietly(localJSONObject, "FUNC", Integer.valueOf(1));
    JSONUtils.putQuietly(localJSONObject, "ABI", GlobalUtils.getCpuAbi(paramContext));
    JSONUtils.putQuietly(localJSONObject, "NAME", paramString2);
    JSONUtils.putQuietly(localJSONObject, "REQV", Integer.valueOf(paramInt1));
    JSONUtils.putQuietly(localJSONObject, "LOCV", Integer.valueOf(paramInt2));
    if (this.mOptions != null) {}
    for (boolean bool = this.mOptions.getBoolean("is_ignore_flow_control", false);; bool = false)
    {
      if (bool) {
        JSONUtils.putQuietly(localJSONObject, "FORCE", Integer.valueOf(1));
      }
      Logging.i("[%s] {%s} Requesting component info from %s, post data: %s", new Object[] { paramString1, paramString2, paramString3, localJSONObject });
      this.mRequestJob = new HttpRequestJob(paramContext, paramString3, "POST", null, localJSONObject.toString().getBytes(Constants.UTF8_CHARSET));
      this.mRequestJob.setClient(new AutoComponentInstallationJob.3(this, paramInt2));
      this.mRequestJob.start(new AutoComponentInstallationJob.4(this));
      return;
    }
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
    if (paramInt == 219)
    {
      if (isUpdateJob()) {
        Statistics.reportAction(1017, this.mName);
      }
    }
    else
    {
      if (!isUpdateJob()) {
        break label72;
      }
      Statistics.reportAction(1014, this.mName);
    }
    for (;;)
    {
      InstallationUtils.setLastFailedTimeMillis(this.mOutputDirectory, System.currentTimeMillis());
      super.fail(paramInt, paramString, paramThrowable);
      return;
      Statistics.reportAction(1007, this.mName);
      break;
      label72:
      Statistics.reportAction(1004, this.mName);
    }
  }
  
  public void run()
  {
    Context localContext = this.mCallerContext;
    String str1 = this.mCategory;
    String str2 = this.mName;
    int i = this.mRequestVersion;
    File localFile = this.mOutputDirectory;
    TBSOneRuntimeExtension localTBSOneRuntimeExtension = CommonUtils.getRuntimeExtension(localContext, str1);
    if (localTBSOneRuntimeExtension != null)
    {
      int j = localTBSOneRuntimeExtension.shouldOverrideInstallationJob(str1, str2, i, null, localFile, new AutoComponentInstallationJob.1(this, str1, str2, localFile));
      if (j != 0)
      {
        Logging.i("[%s] {%s} Intercepted component installation job by runtime extension", new Object[] { str1, str2 });
        this.mInterceptedToken = j;
        return;
      }
    }
    if (localFile.exists()) {
      FileUtils.recursivelyDeleteFile(localFile);
    }
    ThreadUtils.postOnBackgroundThread(new AutoComponentInstallationJob.2(this, localContext, localFile, str1, str2, i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.auto.AutoComponentInstallationJob
 * JD-Core Version:    0.7.0.1
 */