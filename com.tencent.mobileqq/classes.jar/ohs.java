import android.os.Bundle;
import android.os.MessageQueue.IdleHandler;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emosm.Client;

public class ohs
  implements MessageQueue.IdleHandler
{
  public ohs(ReadInJoyArticleDetailActivity paramReadInJoyArticleDetailActivity) {}
  
  public boolean queueIdle()
  {
    if (!arui.a().a())
    {
      arui.a().a().doBindService(BaseApplicationImpl.getApplication());
      arui.a().a(new oht(this));
      return false;
    }
    Bundle localBundle = arph.a("ipc_kandian_hb_close_guid", "onPageStarted", 0, new Bundle());
    arui.a().a(localBundle);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ohs
 * JD-Core Version:    0.7.0.1
 */