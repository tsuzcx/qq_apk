package com.tencent.mobileqq.kandian.biz.pts.loaders;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSReport;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class PTSJSCLoader$2
  implements Runnable
{
  PTSJSCLoader$2(PTSJSCLoader paramPTSJSCLoader, Runnable paramRunnable) {}
  
  public void run()
  {
    if (this.this$0.b())
    {
      QLog.i("PTSJSCLoader", 1, "[loadPTSJSC], jsc has loaded, no need to load again.");
      if (this.a != null) {
        ThreadManager.getFileThreadHandler().post(this.a);
      }
    }
    else
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(PTSJSCLoader.b(this.this$0));
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append("libjsc.so");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[loadPTSJSC], jscSoFullPath = ");
      localStringBuilder.append((String)localObject);
      QLog.i("PTSJSCLoader", 1, localStringBuilder.toString());
      try
      {
        if (FileUtils.fileExists((String)localObject))
        {
          System.load((String)localObject);
          PTSJSCLoader.a(this.this$0, true);
          QLog.i("PTSJSCLoader", 1, "[loadPTSJSC], load jsc so success");
          PTSReport.b("[loadPTSJSC] succeed", "1");
          if (this.a != null) {
            ThreadManager.getFileThreadHandler().post(this.a);
          }
        }
        else
        {
          QLog.i("PTSJSCLoader", 1, "[loadPTSJSC], jsc so does not exists.");
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[loadPTSJSC] error, t = ");
        localStringBuilder.append(localThrowable);
        QLog.e("PTSJSCLoader", 1, localStringBuilder.toString());
        PTSReport.a(localThrowable.toString(), "1");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.PTSJSCLoader.2
 * JD-Core Version:    0.7.0.1
 */