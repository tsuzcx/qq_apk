import android.content.Context;
import com.tencent.biz.pubaccount.Advertisement.view.AdProgressButton;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleBase;

public class kxi
  implements Runnable
{
  public kxi(AdModuleBase paramAdModuleBase) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton != null)
    {
      this.a.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130838504);
      this.a.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(this.a.jdField_a_of_type_AndroidContentContext.getText(2131438676));
      this.a.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-1);
      this.a.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(0);
      this.a.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setClickable(true);
    }
    this.a.c = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kxi
 * JD-Core Version:    0.7.0.1
 */