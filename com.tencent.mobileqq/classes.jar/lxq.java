import android.content.Intent;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class lxq
  implements birb
{
  final WeakReference<QQServiceForAV> a;
  
  lxq(QQServiceForAV paramQQServiceForAV)
  {
    this.a = new WeakReference(paramQQServiceForAV);
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2) {}
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQServiceForAV", 2, "PTULibpagDownloadCallback onAEResDownloadResult, package[" + paramInt1 + ", isDownloaded[" + paramBoolean + ", errorType[" + paramInt2 + "]");
    }
    Object localObject = (QQServiceForAV)this.a.get();
    if (localObject != null)
    {
      localObject = (QQAppInterface)((QQServiceForAV)localObject).a();
      Intent localIntent = new Intent("tencent.video.q2v.ptuLibpagDownloadRet");
      localIntent.putExtra("packageIdx", paramInt1);
      localIntent.putExtra("isDownloaded", paramBoolean);
      localIntent.putExtra("errorType", paramInt2);
      ((QQAppInterface)localObject).getApp().sendBroadcast(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lxq
 * JD-Core Version:    0.7.0.1
 */