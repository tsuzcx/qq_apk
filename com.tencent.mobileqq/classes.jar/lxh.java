import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class lxh
  implements bori
{
  final WeakReference<QQAppInterface> a;
  
  public lxh(QQAppInterface paramQQAppInterface)
  {
    this.a = new WeakReference(paramQQAppInterface);
  }
  
  public void a(borf paramborf, long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder;
    if ((QLog.isDevelopLevel()) && ((paramLong1 == 0L) || (paramLong2 == paramLong1)))
    {
      localStringBuilder = new StringBuilder().append("onAEProgressUpdate, package[");
      if (paramborf != null) {
        break label61;
      }
    }
    label61:
    for (paramborf = "null";; paramborf = Integer.valueOf(paramborf.a))
    {
      QLog.i("PtuResCheck", 4, paramborf + "]");
      return;
    }
  }
  
  public void a(borf paramborf, String paramString, boolean paramBoolean, int paramInt)
  {
    int i = 0;
    boolean bool;
    if ((paramborf != null) && (borf.b.a == paramborf.a))
    {
      bool = true;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("onAEResDownloadResult, package[");
        if (paramborf != null) {
          break label195;
        }
        paramString = "null";
        label50:
        QLog.i("PtuResCheck", 2, paramString + ", isDownloaded[" + paramBoolean + "], errorType[" + paramInt + "], isBaseRes[" + bool + "]");
      }
      paramString = (QQAppInterface)this.a.get();
      if ((paramString == null) || (!paramString.d())) {
        break label215;
      }
      Object localObject = new Intent("tencent.video.q2v.ptusoDownloadRet");
      if (paramborf != null) {
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
        bdek.a(this);
      }
      return;
      bool = false;
      break;
      label195:
      paramString = Integer.valueOf(paramborf.a);
      break label50;
      label206:
      i = paramborf.a;
      break label136;
      label215:
      if (QLog.isColorLevel()) {
        QLog.i("PtuResCheck", 2, "onAEDownloadFinish, no need notify video, app[" + paramString + "]");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lxh
 * JD-Core Version:    0.7.0.1
 */