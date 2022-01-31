import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.qphone.base.util.QLog;

class qbu
  extends BroadcastReceiver
{
  private qbu(qbq paramqbq) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsFloatWindowManager", 2, "onReceive: action=" + paramContext);
    }
    if (paramContext.equals("tencent.av.v2q.StartVideoChat")) {
      this.a.f();
    }
    while ((!paramContext.equals("tencent.av.v2q.StopVideoChat")) || (qbq.c(this.a) != 1)) {
      return;
    }
    if (qbq.a(this.a).d()) {
      qbq.a(this.a).a(qbq.a(this.a), false);
    }
    for (;;)
    {
      qjm.a().a(true, "float window video");
      return;
      if (qbq.a(this.a).e()) {
        qbq.a(this.a).c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qbu
 * JD-Core Version:    0.7.0.1
 */