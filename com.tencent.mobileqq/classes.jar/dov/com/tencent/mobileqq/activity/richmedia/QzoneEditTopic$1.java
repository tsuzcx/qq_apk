package dov.com.tencent.mobileqq.activity.richmedia;

import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.MusicDownloadListener;

class QzoneEditTopic$1
  extends MusicDownloadListener
{
  QzoneEditTopic$1(QzoneEditTopic paramQzoneEditTopic) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      QzoneEditTopic.a(this.a, true);
      QzoneEditTopic.a(this.a);
      return;
    }
    QLog.i("EditPicQzComment", 2, "download music fail" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.QzoneEditTopic.1
 * JD-Core Version:    0.7.0.1
 */