import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.appinpush.AppInPushNotification;
import com.tencent.biz.pubaccount.readinjoy.view.appinpush.DropDownAppInPushNotification;

public class mkd
  implements View.OnClickListener
{
  public mkd(DropDownAppInPushNotification paramDropDownAppInPushNotification) {}
  
  public void onClick(View paramView)
  {
    AppInPushNotification.a(8);
    this.a.a(true, false);
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewAppinpushAppInPushNotification$OnClickListener != null) {
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new mke(this), 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mkd
 * JD-Core Version:    0.7.0.1
 */