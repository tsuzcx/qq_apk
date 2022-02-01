package dov.com.qq.im.story;

import com.tencent.av.ui.funchat.record.AudioFileDecoder.Callback;
import com.tencent.qphone.base.util.QLog;

final class QIMAudioUtil$1
  implements AudioFileDecoder.Callback
{
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMAudioUtil", 1, "convertMp3ToPcm onError " + paramInt);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMAudioUtil", 1, "convertMp3ToPcm onStart " + paramString);
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMAudioUtil", 1, "convertMp3ToPcm onFinish " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.story.QIMAudioUtil.1
 * JD-Core Version:    0.7.0.1
 */