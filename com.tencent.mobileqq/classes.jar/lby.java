import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;

class lby
  extends Client.onRemoteRespObserver
{
  lby(lbx paramlbx) {}
  
  public void onBindedToClient()
  {
    ReadInJoyArticleDetailActivity.a(this.a.a);
  }
  
  public void onDisconnectWithService() {}
  
  public void onPushMsg(Bundle paramBundle) {}
  
  public void onResponse(Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lby
 * JD-Core Version:    0.7.0.1
 */