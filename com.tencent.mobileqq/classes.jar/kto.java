import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;

public class kto
  implements View.OnClickListener
{
  public kto(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    PublicAccountAdvertisementActivity.g(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementActivityPublicAccountAdvertisementActivity);
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kto
 * JD-Core Version:    0.7.0.1
 */