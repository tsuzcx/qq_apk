package com.tencent.tbs.one.impl.policy;

import android.content.Context;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.base.CancellableJob;
import com.tencent.tbs.one.impl.base.FileUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

class PolicyManagerImpl$5
  extends CancellableJob<InstallationResult<File>>
{
  PolicyManagerImpl$5(PolicyManagerImpl paramPolicyManagerImpl, Context paramContext, String paramString1, String paramString2, File paramFile, int paramInt) {}
  
  public void run()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      InputStream localInputStream = FileUtils.openFile(this.val$callerContext, this.val$localRepository, this.val$path);
      localObject1 = localInputStream;
      localObject3 = localInputStream;
      FileUtils.unzipStream(localInputStream, this.val$outputDirectory, null);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      localObject3 = localObject1;
      fail(313, "Failed to unzip local component from " + this.val$path + " to " + this.val$outputDirectory.getAbsolutePath() + ", localRepository: " + this.val$localRepository, localIOException);
      return;
    }
    finally
    {
      FileUtils.close(localObject3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.PolicyManagerImpl.5
 * JD-Core Version:    0.7.0.1
 */