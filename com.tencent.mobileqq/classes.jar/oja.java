import android.os.Bundle;
import android.os.MessageQueue.IdleHandler;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emosm.Client;

public class oja
  implements MessageQueue.IdleHandler
{
  public oja(ReadInJoyArticleDetailActivity paramReadInJoyArticleDetailActivity) {}
  
  public boolean queueIdle()
  {
    if (!asjw.a().a())
    {
      asjw.a().a().doBindService(BaseApplicationImpl.getApplication());
      asjw.a().a(new ojb(this));
      return false;
    }
    Bundle localBundle = asev.a("ipc_kandian_hb_close_guid", "onPageStarted", 0, new Bundle());
    asjw.a().a(localBundle);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oja
 * JD-Core Version:    0.7.0.1
 */