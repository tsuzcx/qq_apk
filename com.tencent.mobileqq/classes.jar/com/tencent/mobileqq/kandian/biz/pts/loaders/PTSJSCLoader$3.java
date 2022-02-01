package com.tencent.mobileqq.kandian.biz.pts.loaders;

import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class PTSJSCLoader$3
  implements Runnable
{
  PTSJSCLoader$3(PTSJSCLoader paramPTSJSCLoader) {}
  
  public void run()
  {
    PTSJSCLoader.3.1 local1 = new PTSJSCLoader.3.1(this);
    try
    {
      HtmlOffline.b();
    }
    catch (Throwable localThrowable2)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[updatePTSJSC], t = ");
      localStringBuilder2.append(localThrowable2);
      QLog.e("PTSJSCLoader", 1, localStringBuilder2.toString());
    }
    try
    {
      HtmlOffline.b("4044", BaseApplicationImpl.getApplication().getRuntime(), local1, true, 0, true);
      return;
    }
    catch (Throwable localThrowable1)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("[updatePTSJSC], t = ");
      localStringBuilder1.append(localThrowable1);
      QLog.i("PTSJSCLoader", 1, localStringBuilder1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.PTSJSCLoader.3
 * JD-Core Version:    0.7.0.1
 */