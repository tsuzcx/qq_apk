import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.app.RedTouchObserver;
import com.tencent.mobileqq.leba.header.LebaGridShowManager;
import com.tencent.qphone.base.util.QLog;

public class tdl
  extends RedTouchObserver
{
  public tdl(LebaListMgrActivity paramLebaListMgrActivity) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.lebatab.mgr", 4, "notifyLebaViewItemsReloaded");
    }
    if ((LebaListMgrActivity.a(this.a) == null) || (!this.a.isResume())) {
      return;
    }
    paramObject = LebaGridShowManager.a().c(this.a.app);
    this.a.runOnUiThread(new tdm(this, paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tdl
 * JD-Core Version:    0.7.0.1
 */