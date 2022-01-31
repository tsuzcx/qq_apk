import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetail.activity.EqqAccountDetailActivity;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.mobileqq.activity.ChatHistory;

public class koj
  implements View.OnClickListener
{
  public koj(EqqAccountDetailActivity paramEqqAccountDetailActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null)
    {
      paramView = new Intent(this.a, ChatHistory.class);
      paramView.putExtra("uin", EqqAccountDetailActivity.i(this.a));
      paramView.putExtra("uintype", 1024);
      this.a.startActivity(paramView);
      PublicAccountReportUtils.a(EqqAccountDetailActivity.i(this.a), "P_CliOper", "Pb_account_lifeservice", EqqAccountDetailActivity.j(this.a), "0X8005A29", "0X8005A29", 0, 0, "", "", "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     koj
 * JD-Core Version:    0.7.0.1
 */