import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyProcessMonitor;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.webprocess.WebProcessManager;

class syc
  implements Runnable
{
  syc(syb paramsyb) {}
  
  public void run()
  {
    WebProcessManager localWebProcessManager = (WebProcessManager)this.a.a.a.getManager(12);
    if ((localWebProcessManager != null) && (localWebProcessManager.d())) {
      localWebProcessManager.a(202, new syd(this));
    }
    this.a.a.n();
    this.a.a.a(1);
    if (NearbyUtils.b()) {
      NearbyUtils.a("Q.lebatab.", new Object[] { "preload nearby process/tool process" });
    }
    NearbyProcessMonitor.a(this.a.a.a.getAccount(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     syc
 * JD-Core Version:    0.7.0.1
 */