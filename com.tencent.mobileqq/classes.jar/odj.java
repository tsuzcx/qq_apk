import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class odj
  implements View.OnClickListener
{
  public odj(AccountDetailActivity paramAccountDetailActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     odj
 * JD-Core Version:    0.7.0.1
 */