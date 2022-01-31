import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoyMsgManagerActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;

public class lff
  implements View.OnClickListener
{
  public lff(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onClick(View paramView)
  {
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80078A6", "0X80078A6", 0, 0, "", "", "", ReadInJoyUtils.c(), false);
    paramView = new Intent(this.a, ReadinjoyMsgManagerActivity.class);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lff
 * JD-Core Version:    0.7.0.1
 */