import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySelfActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class leb
  implements View.OnClickListener
{
  public leb(ReadInJoySelfActivity paramReadInJoySelfActivity, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      paramView = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoySelfActivity.getActivity(), QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoySelfActivity.getActivity().startActivity(paramView);
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80092FF", "0X80092FF", 0, 0, "", "", "", ReadInJoyUtils.b(this.b), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     leb
 * JD-Core Version:    0.7.0.1
 */