import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;

public class moq
  implements Runnable
{
  public moq(ReadinjoyTabFrame paramReadinjoyTabFrame, ReadInJoyBaseFragment paramReadInJoyBaseFragment) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment.getActivity() != null) {
      StatisticCollector.a(BaseApplication.getContext()).a(null, "FragmentOnStartError", true, NetConnInfoCenter.getServerTimeMillis() - ReadinjoyTabFrame.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame), 0L, null, "", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     moq
 * JD-Core Version:    0.7.0.1
 */