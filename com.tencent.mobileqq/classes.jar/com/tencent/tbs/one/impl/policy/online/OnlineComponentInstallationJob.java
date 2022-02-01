package com.tencent.tbs.one.impl.policy.online;

import android.content.Context;
import android.os.Bundle;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.base.CancellableJob;
import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.common.CommonUtils;
import com.tencent.tbs.one.impl.common.DEPSConfig.ComponentConfig;
import com.tencent.tbs.one.impl.common.PathService;
import com.tencent.tbs.one.impl.net.HttpRequestJob;
import com.tencent.tbs.one.impl.net.HttpRequestJob.Client;
import com.tencent.tbs.one.impl.policy.InstallationResult;
import com.tencent.tbs.one.impl.policy.InstallationResult.Source;
import com.tencent.tbs.one.impl.policy.InstallationUtils;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class OnlineComponentInstallationJob
  extends CancellableJob<InstallationResult<File>>
  implements HttpRequestJob.Client
{
  private File mBackupPath;
  private Context mCallerContext;
  private String mCategory;
  private DEPSConfig.ComponentConfig mComponentConfig;
  private long mContentLength = -1L;
  private int mInterceptedToken;
  private Bundle mOptions;
  private File mOutputDirectory;
  private HttpRequestJob mRequestJob;
  
  public OnlineComponentInstallationJob(Context paramContext, String paramString, DEPSConfig.ComponentConfig paramComponentConfig, File paramFile, Bundle paramBundle)
  {
    this.mCallerContext = paramContext;
    this.mCategory = paramString;
    this.mComponentConfig = paramComponentConfig;
    this.mOutputDirectory = paramFile;
    this.mOptions = paramBundle;
    this.mBackupPath = PathService.getSdcardBackupDirectory(this.mCallerContext, this.mCallerContext, paramString, paramComponentConfig.getName(), paramComponentConfig.getVersionCode());
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
  
  public void onResponseReceived(int paramInt, Map<String, List<String>> paramMap, InputStream paramInputStream)
  {
    Context localContext = this.mCallerContext;
    String str1 = this.mCategory;
    String str2 = this.mComponentConfig.getName();
    int i = this.mComponentConfig.getVersionCode();
    String str3 = this.mComponentConfig.getUrl();
    File localFile2 = this.mOutputDirectory;
    if ((this.mBackupPath != null) && (!this.mBackupPath.exists())) {
      this.mBackupPath.mkdirs();
    }
    if (this.mBackupPath == null) {}
    for (File localFile1 = null;; localFile1 = new File(this.mBackupPath, this.mComponentConfig.getName() + ".tbs"))
    {
      Logging.i("[%s] {%s} Receiving component response: [%d] %s", new Object[] { str1, str2, Integer.valueOf(paramInt), paramMap });
      if ((paramInt == 200) && (paramInputStream != null)) {
        break;
      }
      fail(215, "Invalid component response stream, url: " + str3 + ", statusCode: " + paramInt, null);
      return;
    }
    paramMap = (List)paramMap.get("Content-Length");
    if ((paramMap != null) && (paramMap.size() > 0)) {}
    for (;;)
    {
      try
      {
        this.mContentLength = Long.parseLong((String)paramMap.get(0));
        paramMap = CommonUtils.getRuntimeExtension(localContext, str1);
        if (paramMap == null) {
          break;
        }
        paramInt = paramMap.shouldInterceptComponentResponse(str1, str2, i, null, paramInputStream, localFile2, new OnlineComponentInstallationJob.2(this, str1, str2, localFile2));
        if (paramInt == 0) {
          break;
        }
        Logging.i("[%s] {%s} Intercepted component download stream by runtime extension", new Object[] { str1, str2 });
        this.mInterceptedToken = paramInt;
        return;
      }
      catch (Exception localException)
      {
        Logging.e("Failed to parse Content-Length header %s, url: %s", new Object[] { paramMap, str3, localException });
        continue;
      }
      Logging.i("No Content-Length header exists, url: %s", new Object[] { str3 });
    }
    paramMap = this.mComponentConfig.getMD5();
    long l = this.mContentLength;
    try
    {
      InstallationUtils.unzipFromDownloadStream(paramInputStream, paramMap, l, localFile2, localFile1, new OnlineComponentInstallationJob.3(this));
      InstallationUtils.extractFromInstallationPackage(localFile2, localFile2);
      InstallationUtils.verifyInstallationDirectory(localFile2, i);
      InstallationUtils.setDirectoryExcutableIfNeeded(PathService.getDataRootDirectory(this.mCallerContext));
      InstallationUtils.shareFile(localFile2);
      finish(InstallationResult.make(InstallationResult.Source.ONLINE, localFile2));
      return;
    }
    catch (TBSOneException paramMap)
    {
      fail(paramMap.getErrorCode(), paramMap.getMessage(), paramMap.getCause());
    }
  }
  
  public void run()
  {
    String str = this.mComponentConfig.getUrl();
    this.mRequestJob = new HttpRequestJob(this.mCallerContext, str);
    this.mRequestJob.setClient(this);
    this.mRequestJob.start(new OnlineComponentInstallationJob.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.online.OnlineComponentInstallationJob
 * JD-Core Version:    0.7.0.1
 */