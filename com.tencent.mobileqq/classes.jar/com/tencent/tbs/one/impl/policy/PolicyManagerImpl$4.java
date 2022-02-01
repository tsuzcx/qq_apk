package com.tencent.tbs.one.impl.policy;

import android.content.Context;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.base.CancellableJob;
import com.tencent.tbs.one.impl.base.FileUtils;
import com.tencent.tbs.one.impl.common.DEPSConfig;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

class PolicyManagerImpl$4
  extends CancellableJob<InstallationResult<DEPSConfig>>
{
  PolicyManagerImpl$4(PolicyManagerImpl paramPolicyManagerImpl, Context paramContext, String paramString, File paramFile) {}
  
  public void run()
  {
    Object localObject4 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    try
    {
      InputStream localInputStream = FileUtils.openFile(this.val$callerContext, this.val$localRepository, "DEPS");
      localObject2 = localInputStream;
      localObject4 = localInputStream;
      localObject1 = localInputStream;
      DEPSConfig localDEPSConfig = DEPSConfig.parse(FileUtils.readAndCopyStream(localInputStream, "utf-8", this.val$outputFile));
      FileUtils.close(localInputStream);
      finish(InstallationResult.make(InstallationResult.Source.LOCAL, localDEPSConfig));
      return;
    }
    catch (IOException localIOException)
    {
      localObject1 = localObject2;
      fail(303, "Failed to copy local DEPS from " + this.val$localRepository + " to " + this.val$outputFile.getAbsolutePath(), localIOException);
      FileUtils.close(localObject2);
      return;
    }
    catch (TBSOneException localTBSOneException)
    {
      localObject1 = localIOException;
      fail(localTBSOneException.getErrorCode(), localTBSOneException.getMessage(), localTBSOneException.getCause());
      FileUtils.close(localIOException);
      return;
    }
    finally
    {
      FileUtils.close((Closeable)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.PolicyManagerImpl.4
 * JD-Core Version:    0.7.0.1
 */