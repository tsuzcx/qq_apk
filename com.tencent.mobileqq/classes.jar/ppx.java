import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyProteusFamilyFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ppx
  implements View.OnClickListener
{
  public ppx(ReadInJoyProteusFamilyFragment paramReadInJoyProteusFamilyFragment, ImageView paramImageView) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyProteusFamilyFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyProteusFamilyFragment.getActivity(), this.jdField_a_of_type_AndroidWidgetImageView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ppx
 * JD-Core Version:    0.7.0.1
 */