import android.os.Bundle;
import android.os.MessageQueue.IdleHandler;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;

public class lbx
  implements MessageQueue.IdleHandler
{
  public lbx(ReadInJoyArticleDetailActivity paramReadInJoyArticleDetailActivity) {}
  
  public boolean queueIdle()
  {
    if (!WebIPCOperator.a().a())
    {
      WebIPCOperator.a().a().doBindService(BaseApplicationImpl.getApplication());
      WebIPCOperator.a().a(new lby(this));
      return false;
    }
    Bundle localBundle = DataFactory.a("ipc_kandian_hb_close_guid", "onPageStarted", 0, new Bundle());
    WebIPCOperator.a().a(localBundle);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lbx
 * JD-Core Version:    0.7.0.1
 */