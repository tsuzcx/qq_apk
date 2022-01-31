import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.qphone.base.util.QLog;

class qnp
  extends BroadcastReceiver
{
  private qnp(qnl paramqnl) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsFloatWindowManager", 2, "onReceive: action=" + paramContext);
    }
    if (paramContext.equals("tencent.av.v2q.StartVideoChat")) {
      this.a.f();
    }
    while ((!paramContext.equals("tencent.av.v2q.StopVideoChat")) || (qnl.c(this.a) != 1)) {
      return;
    }
    if (qnl.a(this.a).e()) {
      qnl.a(this.a).a(qnl.a(this.a), false);
    }
    for (;;)
    {
      qvo.a().a(true, "float window video");
      return;
      if (qnl.a(this.a).f()) {
        qnl.a(this.a).c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qnp
 * JD-Core Version:    0.7.0.1
 */