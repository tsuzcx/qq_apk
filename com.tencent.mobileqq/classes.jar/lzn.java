import android.graphics.Bitmap;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class lzn
  implements bdbc
{
  public lzn(QQServiceForAV paramQQServiceForAV) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQServiceForAV", 2, "onDecodeTaskCompleted");
    }
    new maf(((QQAppInterface)this.a.a()).getApp().getApplicationContext()).a(new lzo(this, paramString, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lzn
 * JD-Core Version:    0.7.0.1
 */