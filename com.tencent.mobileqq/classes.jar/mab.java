import android.content.Intent;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class mab
  implements blar
{
  final WeakReference<QQServiceForAV> a;
  
  mab(QQServiceForAV paramQQServiceForAV)
  {
    this.a = new WeakReference(paramQQServiceForAV);
  }
  
  public void a(blao paramblao, long paramLong1, long paramLong2) {}
  
  public void a(blao paramblao, String paramString, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQServiceForAV", 2, "onAEResDownloadResult, package[" + paramblao.a + ", isDownloaded[" + paramBoolean + ", errorType[" + paramInt + "]");
    }
    paramString = (QQServiceForAV)this.a.get();
    if (paramString != null)
    {
      paramString = (QQAppInterface)paramString.a();
      Intent localIntent = new Intent("tencent.video.q2v.ptusoDownloadRet");
      localIntent.putExtra("packageIdx", paramblao.a);
      localIntent.putExtra("isDownloaded", paramBoolean);
      localIntent.putExtra("errorType", paramInt);
      paramString.getApp().sendBroadcast(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mab
 * JD-Core Version:    0.7.0.1
 */