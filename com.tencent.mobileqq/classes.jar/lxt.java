import android.content.Intent;
import com.tencent.av.service.QQServiceForAV;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class lxt
  implements bnkw
{
  final WeakReference<QQServiceForAV> a;
  
  lxt(QQServiceForAV paramQQServiceForAV)
  {
    this.a = new WeakReference(paramQQServiceForAV);
  }
  
  public void onAEDownloadFinish(bnkt parambnkt, String paramString, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQServiceForAV", 2, "PTULibpagDownloadCallback onAEResDownloadResult, package[" + parambnkt.a + ", isDownloaded[" + paramBoolean + ", errorType[" + paramInt + "]");
    }
    paramString = (QQServiceForAV)this.a.get();
    if (paramString != null)
    {
      paramString = (QQAppInterface)paramString.a();
      Intent localIntent = new Intent("tencent.video.q2v.ptuLibpagDownloadRet");
      localIntent.putExtra("packageIdx", parambnkt.a);
      localIntent.putExtra("isDownloaded", paramBoolean);
      localIntent.putExtra("errorType", paramInt);
      paramString.getApp().sendBroadcast(localIntent);
    }
  }
  
  public void onAEProgressUpdate(bnkt parambnkt, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lxt
 * JD-Core Version:    0.7.0.1
 */