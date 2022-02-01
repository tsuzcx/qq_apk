import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nwc
  implements View.OnClickListener
{
  public nwc(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nwc
 * JD-Core Version:    0.7.0.1
 */