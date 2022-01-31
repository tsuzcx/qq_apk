import com.tencent.mobileqq.activity.LebaListMgrActivity;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import java.util.List;

public class svo
  implements Runnable
{
  public svo(LebaListMgrActivity paramLebaListMgrActivity) {}
  
  public void run()
  {
    LebaShowListManager.a().a(this.a, this.a.app);
    List localList = LebaShowListManager.a().a();
    this.a.runOnUiThread(new svp(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     svo
 * JD-Core Version:    0.7.0.1
 */