import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.qphone.base.util.QLog;

class rct
  extends BroadcastReceiver
{
  private rct(rcp paramrcp) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsFloatWindowManager", 2, "onReceive: action=" + paramContext);
    }
    if (paramContext.equals("tencent.av.v2q.StartVideoChat")) {
      this.a.f();
    }
    while ((!paramContext.equals("tencent.av.v2q.StopVideoChat")) || (rcp.c(this.a) != 1)) {
      return;
    }
    if (rcp.a(this.a).e()) {
      rcp.a(this.a).a(rcp.a(this.a), false);
    }
    for (;;)
    {
      rlf.a().a(true, "float window video");
      return;
      if (rcp.a(this.a).f()) {
        rcp.a(this.a).c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rct
 * JD-Core Version:    0.7.0.1
 */