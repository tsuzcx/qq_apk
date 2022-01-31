import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.qphone.base.util.QLog;

class qns
  extends BroadcastReceiver
{
  private qns(qno paramqno) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsFloatWindowManager", 2, "onReceive: action=" + paramContext);
    }
    if (paramContext.equals("tencent.av.v2q.StartVideoChat")) {
      this.a.f();
    }
    while ((!paramContext.equals("tencent.av.v2q.StopVideoChat")) || (qno.c(this.a) != 1)) {
      return;
    }
    if (qno.a(this.a).e()) {
      qno.a(this.a).a(qno.a(this.a), false);
    }
    for (;;)
    {
      qvr.a().a(true, "float window video");
      return;
      if (qno.a(this.a).f()) {
        qno.a(this.a).c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qns
 * JD-Core Version:    0.7.0.1
 */