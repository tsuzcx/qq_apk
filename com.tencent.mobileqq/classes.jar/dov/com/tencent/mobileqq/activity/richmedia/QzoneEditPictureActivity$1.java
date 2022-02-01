package dov.com.tencent.mobileqq.activity.richmedia;

import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;

class QzoneEditPictureActivity$1
  implements Runnable
{
  QzoneEditPictureActivity$1(QzoneEditPictureActivity paramQzoneEditPictureActivity) {}
  
  public void run()
  {
    com.tencent.sveffects.SvEffectSdkInitor.a = true;
    CaptureUtil.b();
    VideoFilterTools.a().a(this.this$0.a(), new QzoneEditPictureActivity.1.1(this), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.QzoneEditPictureActivity.1
 * JD-Core Version:    0.7.0.1
 */