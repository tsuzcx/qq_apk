import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.download.AEResInfo;
import java.lang.ref.WeakReference;

public class lws
  implements blvp
{
  final WeakReference<QQAppInterface> a;
  
  public lws(QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramQQAppInterface);
  }
  
  public void onAEDownloadFinish(AEResInfo paramAEResInfo, String paramString, boolean paramBoolean, int paramInt)
  {
    int i = 0;
    boolean bool;
    if ((paramAEResInfo != null) && (AEResInfo.AE_RES_BASE_PACKAGE.index == paramAEResInfo.index))
    {
      bool = true;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("onAEResDownloadResult, package[");
        if (paramAEResInfo != null) {
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
      if (paramAEResInfo != null) {
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
        bbxj.a(this);
      }
      return;
      bool = false;
      break;
      label195:
      paramString = Integer.valueOf(paramAEResInfo.index);
      break label50;
      label206:
      i = paramAEResInfo.index;
      break label136;
      label215:
      if (QLog.isColorLevel()) {
        QLog.i("PtuResCheck", 2, "onAEDownloadFinish, no need notify video, app[" + paramString + "]");
      }
    }
  }
  
  public void onAEProgressUpdate(AEResInfo paramAEResInfo, long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder;
    if ((QLog.isDevelopLevel()) && ((paramLong1 == 0L) || (paramLong2 == paramLong1)))
    {
      localStringBuilder = new StringBuilder().append("onAEProgressUpdate, package[");
      if (paramAEResInfo != null) {
        break label61;
      }
    }
    label61:
    for (paramAEResInfo = "null";; paramAEResInfo = Integer.valueOf(paramAEResInfo.index))
    {
      QLog.i("PtuResCheck", 4, paramAEResInfo + "]");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lws
 * JD-Core Version:    0.7.0.1
 */