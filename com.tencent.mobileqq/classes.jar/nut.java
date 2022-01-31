import android.os.Bundle;
import android.os.MessageQueue.IdleHandler;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emosm.Client;

public class nut
  implements MessageQueue.IdleHandler
{
  public nut(ReadInJoyArticleDetailActivity paramReadInJoyArticleDetailActivity) {}
  
  public boolean queueIdle()
  {
    if (!anvq.a().a())
    {
      anvq.a().a().doBindService(BaseApplicationImpl.getApplication());
      anvq.a().a(new nuu(this));
      return false;
    }
    Bundle localBundle = anqu.a("ipc_kandian_hb_close_guid", "onPageStarted", 0, new Bundle());
    anvq.a().a(localBundle);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nut
 * JD-Core Version:    0.7.0.1
 */