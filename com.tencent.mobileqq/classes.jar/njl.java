import android.os.Bundle;
import android.os.MessageQueue.IdleHandler;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emosm.Client;

public class njl
  implements MessageQueue.IdleHandler
{
  public njl(ReadInJoyArticleDetailActivity paramReadInJoyArticleDetailActivity) {}
  
  public boolean queueIdle()
  {
    if (!anfc.a().a())
    {
      anfc.a().a().doBindService(BaseApplicationImpl.getApplication());
      anfc.a().a(new njm(this));
      return false;
    }
    Bundle localBundle = anah.a("ipc_kandian_hb_close_guid", "onPageStarted", 0, new Bundle());
    anfc.a().a(localBundle);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     njl
 * JD-Core Version:    0.7.0.1
 */