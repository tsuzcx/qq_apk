package dov.com.qq.im.capture.adapter;

import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.capture.view.QIMCommonLoadingProgress;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.IPtvTemplateDownloadListener;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import mqq.os.MqqHandler;

class QIMPtvTemplateAdapter$2
  implements PtvTemplateManager.IPtvTemplateDownloadListener
{
  QIMPtvTemplateAdapter$2(QIMPtvTemplateAdapter paramQIMPtvTemplateAdapter) {}
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, int paramInt)
  {
    ThreadManager.getUIHandler().post(new QIMPtvTemplateAdapter.2.3(this, paramPtvTemplateInfo, paramInt));
  }
  
  public void a(PtvTemplateManager.PtvTemplateInfo paramPtvTemplateInfo, boolean paramBoolean)
  {
    if (paramPtvTemplateInfo.usable) {
      QIMCommonLoadingProgress.a(paramPtvTemplateInfo).b();
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new QIMPtvTemplateAdapter.2.1(this, paramPtvTemplateInfo, paramBoolean));
      if (!paramBoolean)
      {
        FlowCameraMqqAction.a("", "0X80075BB", "", "", "", "");
        ThreadManager.getUIHandler().post(new QIMPtvTemplateAdapter.2.2(this));
      }
      return;
      QIMCommonLoadingProgress.a(paramPtvTemplateInfo).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.2
 * JD-Core Version:    0.7.0.1
 */