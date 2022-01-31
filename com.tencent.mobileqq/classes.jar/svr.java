import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class svr
  extends GameCenterObserver
{
  public svr(LebaListMgrActivity paramLebaListMgrActivity) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.lebatab.mgr", 2, "onGameCenterMsgReceive. notifyData.");
    }
    if ((this.a.isResume()) && (paramBoolean1) && (paramInt != 2) && (LebaListMgrActivity.a(this.a) != null))
    {
      List localList = LebaShowListManager.a().a();
      this.a.runOnUiThread(new svs(this, localList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     svr
 * JD-Core Version:    0.7.0.1
 */