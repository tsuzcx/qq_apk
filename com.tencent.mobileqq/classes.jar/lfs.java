import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;

class lfs
  implements View.OnClickListener
{
  lfs(lfq paramlfq, lft paramlft) {}
  
  public void onClick(View paramView)
  {
    ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_Lfq.a, lft.c(this.jdField_a_of_type_Lft));
    PublicAccountReportUtils.a(null, "CliOper", "", lft.c(this.jdField_a_of_type_Lft), "0X80078A8", "0X80078A8", 0, 0, "", "", "", ReadInJoyUtils.c(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lfs
 * JD-Core Version:    0.7.0.1
 */