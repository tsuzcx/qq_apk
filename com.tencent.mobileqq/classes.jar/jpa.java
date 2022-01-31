import android.graphics.Bitmap;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.av.service.QavWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class jpa
  implements FaceDecoder.DecodeTaskCompletionListener
{
  public jpa(QQServiceForAV paramQQServiceForAV) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "onDecodeTaskCompleted");
    }
    new QavWrapper(((QQAppInterface)this.a.a()).getApp().getApplicationContext()).a(new jpb(this, paramString, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jpa
 * JD-Core Version:    0.7.0.1
 */