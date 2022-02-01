import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class lxf
  implements bnkw
{
  final WeakReference<QQAppInterface> a;
  
  public lxf(QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramQQAppInterface);
  }
  
  public void onAEDownloadFinish(bnkt parambnkt, String paramString, boolean paramBoolean, int paramInt)
  {
    int i = 0;
    boolean bool;
    if ((parambnkt != null) && (bnkt.b.a == parambnkt.a))
    {
      bool = true;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("onAEResDownloadResult, package[");
        if (parambnkt != null) {
          break label195;
        }
        paramString = "null";
        label50:
        QLog.i("PtuResCheck", 2, paramString + ", isDownloaded[" + paramBoolean + "], errorType[" + paramInt + "], isBaseRes[" + bool + "]");
      }
      paramString = (QQAppInterface)this.a.get();
      if ((paramString == null) || (!paramString.isVideoChatting())) {
        break label215;
      }
      Object localObject = new Intent("tencent.video.q2v.ptusoDownloadRet");
      if (parambnkt != null) {
        break label206;
      }
      label136:
      ((Intent)localObject).putExtra("packageIdx", i);
      ((Intent)localObject).putExtra("isDownloaded", paramBoolean);
      ((Intent)localObject).putExtra("errorType", paramInt);
      paramString.getApp().sendBroadcast((Intent)localObject);
    }
    for (;;)
    {
      if ((bool) && (paramBoolean)) {
        bdee.a(this);
      }
      return;
      bool = false;
      break;
      label195:
      paramString = Integer.valueOf(parambnkt.a);
      break label50;
      label206:
      i = parambnkt.a;
      break label136;
      label215:
      if (QLog.isColorLevel()) {
        QLog.i("PtuResCheck", 2, "onAEDownloadFinish, no need notify video, app[" + paramString + "]");
      }
    }
  }
  
  public void onAEProgressUpdate(bnkt parambnkt, long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder;
    if ((QLog.isDevelopLevel()) && ((paramLong1 == 0L) || (paramLong2 == paramLong1)))
    {
      localStringBuilder = new StringBuilder().append("onAEProgressUpdate, package[");
      if (parambnkt != null) {
        break label61;
      }
    }
    label61:
    for (parambnkt = "null";; parambnkt = Integer.valueOf(parambnkt.a))
    {
      QLog.i("PtuResCheck", 4, parambnkt + "]");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lxf
 * JD-Core Version:    0.7.0.1
 */