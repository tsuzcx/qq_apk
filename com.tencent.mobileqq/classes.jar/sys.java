import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.app.RedTouchObserver;
import com.tencent.mobileqq.leba.header.LebaGridShowManager;
import com.tencent.qphone.base.util.QLog;

public class sys
  extends RedTouchObserver
{
  public sys(LebaListMgrActivity paramLebaListMgrActivity) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.lebatab.mgr", 4, "notifyLebaViewItemsReloaded");
    }
    if ((LebaListMgrActivity.a(this.a) == null) || (!this.a.isResume())) {
      return;
    }
    paramObject = LebaGridShowManager.a().c(this.a.app);
    this.a.runOnUiThread(new syt(this, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sys
 * JD-Core Version:    0.7.0.1
 */