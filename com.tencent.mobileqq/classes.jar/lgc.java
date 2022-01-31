import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;

class lgc
  implements View.OnClickListener
{
  lgc(lga paramlga, lgd paramlgd) {}
  
  public void onClick(View paramView)
  {
    ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_Lga.a, lgd.c(this.jdField_a_of_type_Lgd));
    PublicAccountReportUtils.a(null, "CliOper", "", lgd.c(this.jdField_a_of_type_Lgd), "0X80078A8", "0X80078A8", 0, 0, "", "", "", ReadInJoyUtils.c(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lgc
 * JD-Core Version:    0.7.0.1
 */