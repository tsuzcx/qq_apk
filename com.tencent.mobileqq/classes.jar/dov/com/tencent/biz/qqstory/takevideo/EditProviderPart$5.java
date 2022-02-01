package dov.com.tencent.biz.qqstory.takevideo;

import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.MusicDownloadListener;

class EditProviderPart$5
  extends MusicDownloadListener
{
  EditProviderPart$5(EditProviderPart paramEditProviderPart) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditProviderPart", 2, "EditProviderPart onFinish key=" + paramString + " result=" + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditProviderPart.5
 * JD-Core Version:    0.7.0.1
 */