import android.app.Activity;
import android.os.Handler;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;

class mhe
  implements Runnable
{
  mhe(mhd parammhd, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "scroll " + this.jdField_a_of_type_Int + " to top");
    }
    View localView = this.jdField_a_of_type_Mhd.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(this.jdField_a_of_type_Int - this.jdField_a_of_type_Mhd.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition());
    if (localView != null)
    {
      ReadInJoyBaseAdapter.a(this.jdField_a_of_type_Mhd.a).removeMessages(1001);
      this.jdField_a_of_type_Mhd.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.smoothScrollBy(localView.getBottom() - AIOUtils.a(175.0F, this.jdField_a_of_type_Mhd.a.jdField_a_of_type_AndroidAppActivity.getResources()), 800);
      ReadInJoyBaseAdapter.d(this.jdField_a_of_type_Mhd.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mhe
 * JD-Core Version:    0.7.0.1
 */