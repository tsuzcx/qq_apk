package com.tencent.mobileqq.kandian.biz.pts.loaders;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class PTSEngineLoader$4
  implements Runnable
{
  PTSEngineLoader$4(PTSEngineLoader paramPTSEngineLoader) {}
  
  public void run()
  {
    if (!FileUtils.fileExists(PTSEngineLoader.d(this.this$0)))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir does not exist.");
      return;
    }
    if (!PTSOfflineUtil.a(PTSEngineLoader.d(this.this$0), "3980"))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir is not valid.");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(PTSEngineLoader.d(this.this$0));
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append("pts_config.json");
    if (!PTSOfflineUtil.b(((StringBuilder)localObject).toString()))
    {
      QLog.i("PTSEngineLoader", 1, "[handleDownloadPTSEngine], offline dir version is not valid.");
      return;
    }
    if (FileUtils.fileExists(PTSEngineLoader.e(this.this$0)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[handleDownloadPTSEngine], delete inner dir, dir = ");
      ((StringBuilder)localObject).append(PTSEngineLoader.e(this.this$0));
      QLog.i("PTSEngineLoader", 1, ((StringBuilder)localObject).toString());
      FileUtils.deleteDirectory(PTSEngineLoader.e(this.this$0));
    }
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PTSEngineLoader.d(this.this$0));
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append("libpts.so");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PTSEngineLoader.e(this.this$0));
      localStringBuilder.append("/");
      localStringBuilder.append("libpts.so");
      boolean bool1 = FileUtils.copyFile((String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PTSEngineLoader.d(this.this$0));
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append("pts_config.json");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(PTSEngineLoader.e(this.this$0));
      localStringBuilder.append("/");
      localStringBuilder.append("pts_config.json");
      boolean bool2 = FileUtils.copyFile((String)localObject, localStringBuilder.toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[handleDownloadPTSEngine], copySoSuccess = ");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(", copyConfigSuccess = ");
      ((StringBuilder)localObject).append(bool2);
      QLog.i("PTSEngineLoader", 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[handleDownloadPTSEngine], e = ");
      localStringBuilder.append(localException);
      QLog.e("PTSEngineLoader", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.PTSEngineLoader.4
 * JD-Core Version:    0.7.0.1
 */