import android.graphics.Bitmap;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class lxg
  implements FaceDecoder.DecodeTaskCompletionListener
{
  public lxg(QQServiceForAV paramQQServiceForAV) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "onDecodeTaskCompleted");
    }
    new lxx(((QQAppInterface)this.a.a()).getApp().getApplicationContext()).a(new lxh(this, paramString, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lxg
 * JD-Core Version:    0.7.0.1
 */