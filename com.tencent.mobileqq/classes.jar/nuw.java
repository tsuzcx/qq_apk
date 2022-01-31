import android.os.Bundle;
import android.os.MessageQueue.IdleHandler;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emosm.Client;

public class nuw
  implements MessageQueue.IdleHandler
{
  public nuw(ReadInJoyArticleDetailActivity paramReadInJoyArticleDetailActivity) {}
  
  public boolean queueIdle()
  {
    if (!anvl.a().a())
    {
      anvl.a().a().doBindService(BaseApplicationImpl.getApplication());
      anvl.a().a(new nux(this));
      return false;
    }
    Bundle localBundle = anqp.a("ipc_kandian_hb_close_guid", "onPageStarted", 0, new Bundle());
    anvl.a().a(localBundle);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nuw
 * JD-Core Version:    0.7.0.1
 */