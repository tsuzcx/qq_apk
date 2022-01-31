import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.leba.header.LebaGridShowManager;
import java.util.List;

public class syn
  implements Runnable
{
  public syn(LebaListMgrActivity paramLebaListMgrActivity) {}
  
  public void run()
  {
    LebaShowListManager.a().a(this.a, this.a.app);
    List localList = LebaGridShowManager.a().c(this.a.app);
    this.a.runOnUiThread(new syo(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     syn
 * JD-Core Version:    0.7.0.1
 */