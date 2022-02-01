import android.database.DataSetObserver;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat.TabLayoutOnPageChangeListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;

public class szv
  extends DataSetObserver
{
  private boolean jdField_a_of_type_Boolean;
  
  public szv(TabLayoutCompat paramTabLayoutCompat) {}
  
  void a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.a != null) && (TabLayoutCompat.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat) != null))
    {
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.a.getCurrentItem();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.b() == i) {
        TabLayoutCompat.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat).b(i, 300);
      }
    }
    if (TabLayoutCompat.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat) != null) {
      TabLayoutCompat.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat).a();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onChanged()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.b();
      return;
    }
    a();
  }
  
  public void onInvalidated()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.b();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     szv
 * JD-Core Version:    0.7.0.1
 */