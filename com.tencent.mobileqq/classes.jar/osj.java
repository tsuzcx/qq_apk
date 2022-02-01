import android.os.Bundle;
import android.os.MessageQueue.IdleHandler;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emosm.Client;

public class osj
  implements MessageQueue.IdleHandler
{
  public osj(ReadInJoyArticleDetailActivity paramReadInJoyArticleDetailActivity) {}
  
  public boolean queueIdle()
  {
    if (!ashz.a().a())
    {
      ashz.a().a().doBindService(BaseApplicationImpl.getApplication());
      ashz.a().a(new osk(this));
      return false;
    }
    Bundle localBundle = asdd.a("ipc_kandian_hb_close_guid", "onPageStarted", 0, new Bundle());
    ashz.a().a(localBundle);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     osj
 * JD-Core Version:    0.7.0.1
 */