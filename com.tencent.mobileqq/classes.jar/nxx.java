import android.os.Bundle;
import android.os.MessageQueue.IdleHandler;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emosm.Client;

public class nxx
  implements MessageQueue.IdleHandler
{
  public nxx(ReadInJoyArticleDetailActivity paramReadInJoyArticleDetailActivity) {}
  
  public boolean queueIdle()
  {
    if (!apmy.a().a())
    {
      apmy.a().a().doBindService(BaseApplicationImpl.getApplication());
      apmy.a().a(new nxy(this));
      return false;
    }
    Bundle localBundle = apic.a("ipc_kandian_hb_close_guid", "onPageStarted", 0, new Bundle());
    apmy.a().a(localBundle);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nxx
 * JD-Core Version:    0.7.0.1
 */