import android.os.Bundle;
import android.os.MessageQueue.IdleHandler;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emosm.Client;

public class okm
  implements MessageQueue.IdleHandler
{
  public okm(ReadInJoyArticleDetailActivity paramReadInJoyArticleDetailActivity) {}
  
  public boolean queueIdle()
  {
    if (!ardu.a().a())
    {
      ardu.a().a().doBindService(BaseApplicationImpl.getApplication());
      ardu.a().a(new okn(this));
      return false;
    }
    Bundle localBundle = aqyt.a("ipc_kandian_hb_close_guid", "onPageStarted", 0, new Bundle());
    ardu.a().a(localBundle);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okm
 * JD-Core Version:    0.7.0.1
 */