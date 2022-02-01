package com.tencent.mobileqq.kandian.biz.pts.loaders;

import com.tencent.mobileqq.kandian.biz.pts.util.PTSReport;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class PTSEngineLoader$5
  implements Runnable
{
  PTSEngineLoader$5(PTSEngineLoader paramPTSEngineLoader) {}
  
  public void run()
  {
    if (this.this$0.d())
    {
      QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], has loaded, do not load again.");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(PTSEngineLoader.e(this.this$0));
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append("libpts.so");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[loadPTSEngineImpl], soFullPath = ");
    localStringBuilder.append((String)localObject);
    QLog.i("PTSEngineLoader", 1, localStringBuilder.toString());
    try
    {
      if (FileUtils.fileExists((String)localObject))
      {
        System.load((String)localObject);
        PTSEngineLoader.a(this.this$0, true);
        QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], load so success.");
        PTSReport.b("[loadPTSEngineImpl] pts succeed.", "2");
        return;
      }
      QLog.i("PTSEngineLoader", 1, "[loadPTSEngineImpl], pts so does not exists.");
      return;
    }
    catch (Throwable localThrowable)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[loadPTSEngineImpl] error, t = ");
      localStringBuilder.append(localThrowable);
      QLog.e("PTSEngineLoader", 1, localStringBuilder.toString());
      PTSReport.a(localThrowable.toString(), "2");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.PTSEngineLoader.5
 * JD-Core Version:    0.7.0.1
 */