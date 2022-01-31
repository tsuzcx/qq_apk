import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.BaseTabbar;
import com.tencent.biz.pubaccount.readinjoy.view.BaseTabbar.OnTabChangeListener;

public class mfg
  implements View.OnClickListener
{
  long jdField_a_of_type_Long = 0L;
  
  public mfg(BaseTabbar paramBaseTabbar, int paramInt) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 300L)
    {
      this.jdField_a_of_type_Long = 0L;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBaseTabbar.a != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBaseTabbar.a.a(this.jdField_a_of_type_Int);
      }
      return;
    }
    this.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBaseTabbar.setSelectedTab(this.jdField_a_of_type_Int, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mfg
 * JD-Core Version:    0.7.0.1
 */