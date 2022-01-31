import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView;
import com.tencent.widget.AbsListView;

public class sii
  implements bhpo
{
  private int jdField_a_of_type_Int = -1;
  private int b = -1;
  private int c;
  private int d;
  private int e;
  
  public sii(ReadInJoyDynamicGridView paramReadInJoyDynamicGridView) {}
  
  private void c()
  {
    if ((this.d > 0) && (this.e == 0))
    {
      if ((!ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView)) || (!ReadInJoyDynamicGridView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView))) {
        break label42;
      }
      ReadInJoyDynamicGridView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView);
    }
    label42:
    while (!ReadInJoyDynamicGridView.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView)) {
      return;
    }
    ReadInJoyDynamicGridView.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView);
  }
  
  public void a()
  {
    if ((this.c != this.jdField_a_of_type_Int) && (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView)) && (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView) != -1L))
    {
      ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView, ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView));
      ReadInJoyDynamicGridView.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView);
    }
  }
  
  public void b()
  {
    if ((this.c + this.d != this.jdField_a_of_type_Int + this.b) && (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView)) && (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView) != -1L))
    {
      ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView, ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView));
      ReadInJoyDynamicGridView.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    if (this.jdField_a_of_type_Int == -1)
    {
      i = this.c;
      this.jdField_a_of_type_Int = i;
      if (this.b != -1) {
        break label111;
      }
    }
    label111:
    for (int i = this.d;; i = this.b)
    {
      this.b = i;
      a();
      b();
      this.jdField_a_of_type_Int = this.c;
      this.b = this.d;
      if (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView) != null) {
        ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      return;
      i = this.jdField_a_of_type_Int;
      break;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.e = paramInt;
    ReadInJoyDynamicGridView.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView, paramInt);
    c();
    if (ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView) != null) {
      ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sii
 * JD-Core Version:    0.7.0.1
 */