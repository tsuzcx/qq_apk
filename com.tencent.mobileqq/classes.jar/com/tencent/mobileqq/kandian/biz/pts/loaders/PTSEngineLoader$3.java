package com.tencent.mobileqq.kandian.biz.pts.loaders;

import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

class PTSEngineLoader$3
  implements Runnable
{
  PTSEngineLoader$3(PTSEngineLoader paramPTSEngineLoader) {}
  
  public void run()
  {
    PTSEngineLoader.3.1 local1 = new PTSEngineLoader.3.1(this);
    try
    {
      HtmlOffline.a();
    }
    catch (Throwable localThrowable2)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[updatePTSEngine], t = ");
      localStringBuilder2.append(localThrowable2);
      QLog.e("PTSEngineLoader", 1, localStringBuilder2.toString());
    }
    try
    {
      HtmlOffline.b("3980", BaseApplicationImpl.getApplication().getRuntime(), local1, true, 0, true);
      return;
    }
    catch (Throwable localThrowable1)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("[updatePTSEngine], t = ");
      localStringBuilder1.append(localThrowable1);
      QLog.i("PTSEngineLoader", 1, localStringBuilder1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.loaders.PTSEngineLoader.3
 * JD-Core Version:    0.7.0.1
 */