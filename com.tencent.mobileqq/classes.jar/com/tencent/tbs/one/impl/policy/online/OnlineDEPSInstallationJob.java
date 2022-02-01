package com.tencent.tbs.one.impl.policy.online;

import android.content.Context;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.base.CancellableJob;
import com.tencent.tbs.one.impl.base.FileUtils;
import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.common.CommonUtils;
import com.tencent.tbs.one.impl.common.DEPSConfig;
import com.tencent.tbs.one.impl.net.HttpRequestJob;
import com.tencent.tbs.one.impl.net.HttpRequestJob.Client;
import com.tencent.tbs.one.impl.policy.InstallationResult;
import com.tencent.tbs.one.impl.policy.InstallationResult.Source;
import com.tencent.tbs.one.optional.TBSOneRuntimeExtension;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class OnlineDEPSInstallationJob
  extends CancellableJob<InstallationResult<DEPSConfig>>
  implements HttpRequestJob.Client
{
  private Context mCallerContext;
  private String mCategory;
  private int mInterceptedToken;
  private File mOutputFile;
  private HttpRequestJob mRequestJob;
  private String mUrl;
  
  public OnlineDEPSInstallationJob(Context paramContext, String paramString1, String paramString2, File paramFile)
  {
    this.mCallerContext = paramContext;
    this.mCategory = paramString1;
    this.mUrl = paramString2;
    this.mOutputFile = paramFile;
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
    String str1 = this.mUrl;
    String str2 = this.mCategory;
    File localFile = this.mOutputFile;
    Logging.i("[%s] Receiving DEPS response: [%d] %s", new Object[] { str2, Integer.valueOf(paramInt), paramMap });
    if ((paramInt != 200) || (paramInputStream == null))
    {
      fail(210, "Invalid DEPS response stream, url: " + str1 + ", statusCode: " + paramInt, null);
      return;
    }
    paramMap = CommonUtils.getRuntimeExtension(localContext, str2);
    if (paramMap != null)
    {
      paramInt = paramMap.shouldInterceptDEPSResponse(str2, null, paramInputStream, localFile, new OnlineDEPSInstallationJob.2(this, str2, localFile));
      if (paramInt != 0)
      {
        Logging.i("[%s] Intercepted DEPS download stream by runtime extension", new Object[] { str2 });
        this.mInterceptedToken = paramInt;
        return;
      }
    }
    try
    {
      paramMap = DEPSConfig.parse(FileUtils.readAndCopyStream(paramInputStream, "utf-8", localFile));
      finish(InstallationResult.make(InstallationResult.Source.ONLINE, paramMap));
      return;
    }
    catch (IOException paramMap)
    {
      fail(305, "Failed to download online DEPS from " + str1 + " to " + localFile.getAbsolutePath(), paramMap);
      return;
    }
    catch (TBSOneException paramMap)
    {
      fail(paramMap.getErrorCode(), paramMap.getMessage(), paramMap.getCause());
    }
  }
  
  public void run()
  {
    this.mRequestJob = new HttpRequestJob(this.mCallerContext, this.mUrl);
    this.mRequestJob.setClient(this);
    this.mRequestJob.start(new OnlineDEPSInstallationJob.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.online.OnlineDEPSInstallationJob
 * JD-Core Version:    0.7.0.1
 */