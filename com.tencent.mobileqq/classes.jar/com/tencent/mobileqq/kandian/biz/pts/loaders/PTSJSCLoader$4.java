package com.tencent.mobileqq.kandian.biz.pts.loaders;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class PTSJSCLoader$4
  implements Runnable
{
  PTSJSCLoader$4(PTSJSCLoader paramPTSJSCLoader) {}
  
  public void run()
  {
    if (!FileUtils.fileExists(PTSJSCLoader.b(this.this$0)))
    {
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJSC], offline dir does not exist.");
      return;
    }
    if (!PTSOfflineUtil.a(PTSJSCLoader.b(this.this$0), "4044"))
    {
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJSC], offline dir is not valid.");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(PTSJSCLoader.b(this.this$0));
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append("pts_jsc_config.json");
    if (!PTSOfflineUtil.a(((StringBuilder)localObject).toString()))
    {
      QLog.i("PTSJSCLoader", 1, "[handleDownloadPTSJC], offline version is not valid.");
      return;
    }
    if (FileUtils.fileExists(PTSJSCLoader.a(this.this$0)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[handleDownloadPTSJC], delete inner dir, dir = ");
      ((StringBuilder)localObject).append(PTSJSCLoader.a(this.this$0));
      QLog.i("PTSJSCLoader", 1, ((StringBuilder)localObject).toString());
      FileUtils.deleteDirectory(PTSJSCLoader.a(this.this$0));
    }
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PTSJSCLoader.b(this.this$0));
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append("libjsc.so");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PTSJSCLoader.a(this.this$0));
      localStringBuilder.append("/");
      localStringBuilder.append("libjsc.so");
      boolean bool1 = FileUtils.copyFile((String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PTSJSCLoader.b(this.this$0));
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append("pts_jsc_config.json");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PTSJSCLoader.a(this.this$0));
      localStringBuilder.append("/");
      localStringBuilder.append("pts_jsc_config.json");
      boolean bool2 = FileUtils.copyFile((String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[handleDownloadPTSJSC], copyJSCSoSuccess = ");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(", copyConfigSuccess = ");
      ((StringBuilder)localObject).append(bool2);
      QLog.i("PTSJSCLoader", 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[handleDownloadPTSJSC], e = ");
      localStringBuilder.append(localException);
      QLog.e("PTSJSCLoader", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.PTSJSCLoader.4
 * JD-Core Version:    0.7.0.1
 */