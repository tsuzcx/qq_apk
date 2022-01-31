import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class lnh
  extends MqqHandler
{
  WeakReference<AVNotifyCenter> a;
  
  public lnh(Looper paramLooper, AVNotifyCenter paramAVNotifyCenter)
  {
    super(paramLooper);
    this.a = new WeakReference(paramAVNotifyCenter);
  }
  
  public void handleMessage(Message paramMessage)
  {
    AVNotifyCenter localAVNotifyCenter = (AVNotifyCenter)this.a.get();
    if (localAVNotifyCenter == null) {}
    while (!localAVNotifyCenter.i()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("AVNotifyCenter", 1, "handleMessage, msg[" + paramMessage.what + "]");
    }
    if ((paramMessage.what >= 10003) && (paramMessage.what <= 10009))
    {
      localIntent = new Intent("tencent.video.q2v.MultiVideo");
      localIntent.putExtra("type", 35);
      localIntent.setPackage(localAVNotifyCenter.a.getApp().getPackageName());
      localAVNotifyCenter.a.getApp().sendBroadcast(localIntent);
    }
    switch (paramMessage.what)
    {
    case 10006: 
    case 10007: 
    case 10008: 
    case 10009: 
    default: 
      return;
    case 10002: 
      localAVNotifyCenter.b();
      return;
    case 10003: 
      localIntent = new Intent("tencent.video.q2v.MultiVideo");
      localIntent.putExtra("type", 26);
      localIntent.putExtra("discussId", ((Long)paramMessage.obj).longValue());
      localIntent.putExtra("memberUin", localAVNotifyCenter.a.getCurrentAccountUin());
      localIntent.setPackage(localAVNotifyCenter.a.getApp().getPackageName());
      localAVNotifyCenter.a.getApp().sendBroadcast(localIntent);
      return;
    case 10004: 
      paramMessage = (Object[])paramMessage.obj;
      localIntent = new Intent("tencent.video.q2v.MultiVideo");
      localIntent.putExtra("type", 24);
      localIntent.putExtra("discussId", ((Long)paramMessage[0]).longValue());
      localIntent.putExtra("cmdUin", (String)paramMessage[1]);
      localIntent.putExtra("uins", (String[])paramMessage[2]);
      localIntent.setPackage(localAVNotifyCenter.a.getApp().getPackageName());
      localAVNotifyCenter.a.getApp().sendBroadcast(localIntent);
      return;
    case 10005: 
      paramMessage = (Object[])paramMessage.obj;
      localIntent = new Intent("tencent.video.q2v.MultiVideo");
      localIntent.putExtra("type", 31);
      localIntent.putExtra("discussId", ((Long)paramMessage[0]).longValue());
      localIntent.putExtra("cmdUin", (String)paramMessage[1]);
      localIntent.putExtra("uins", (String[])paramMessage[2]);
      localIntent.setPackage(localAVNotifyCenter.a.getApp().getPackageName());
      localAVNotifyCenter.a.getApp().sendBroadcast(localIntent);
      return;
    case 10010: 
      localAVNotifyCenter.c(((Boolean)paramMessage.obj).booleanValue());
      return;
    }
    Intent localIntent = new Intent("tencent.video.q2v.MultiVideo");
    localIntent.putExtra("type", 34);
    localIntent.putExtra("relationId", ((Long)paramMessage.obj).longValue());
    localIntent.setPackage(localAVNotifyCenter.a.getApp().getPackageName());
    localAVNotifyCenter.a.getApp().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     lnh
 * JD-Core Version:    0.7.0.1
 */