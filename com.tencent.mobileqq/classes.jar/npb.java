import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class npb
  implements View.OnClickListener
{
  public npb(EqqAccountDetailActivity paramEqqAccountDetailActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null)
    {
      Intent localIntent = new Intent(this.a, ChatHistory.class);
      localIntent.putExtra("uin", EqqAccountDetailActivity.i(this.a));
      localIntent.putExtra("uintype", 1024);
      this.a.startActivity(localIntent);
      oat.a(EqqAccountDetailActivity.i(this.a), "P_CliOper", "Pb_account_lifeservice", EqqAccountDetailActivity.j(this.a), "0X8005A29", "0X8005A29", 0, 0, "", "", "", "", false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     npb
 * JD-Core Version:    0.7.0.1
 */