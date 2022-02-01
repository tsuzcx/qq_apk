import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class tcn
  implements View.OnClickListener
{
  public tcn(ViolaFragment paramViolaFragment, Bundle paramBundle, ViewGroup paramViewGroup) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.mViolaUiDelegate.d();
    ViolaFragment.access$000(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_AndroidViewViewGroup);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tcn
 * JD-Core Version:    0.7.0.1
 */