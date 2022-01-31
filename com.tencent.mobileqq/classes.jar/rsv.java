import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyNinePicDeliverDynamicGridView;

public class rsv
  implements AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int = -1;
  private int b = -1;
  private int c;
  private int d;
  private int e;
  
  public rsv(ReadInJoyNinePicDeliverDynamicGridView paramReadInJoyNinePicDeliverDynamicGridView) {}
  
  private void c()
  {
    if ((this.d > 0) && (this.e == 0))
    {
      if ((!ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView)) || (!ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView))) {
        break label42;
      }
      ReadInJoyNinePicDeliverDynamicGridView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView);
    }
    label42:
    while (!ReadInJoyNinePicDeliverDynamicGridView.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView)) {
      return;
    }
    ReadInJoyNinePicDeliverDynamicGridView.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView);
  }
  
  public void a()
  {
    if ((this.c != this.jdField_a_of_type_Int) && (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView)) && (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView) != -1L))
    {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView, ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView));
      ReadInJoyNinePicDeliverDynamicGridView.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView);
    }
  }
  
  public void b()
  {
    if ((this.c + this.d != this.jdField_a_of_type_Int + this.b) && (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView)) && (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView) != -1L))
    {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView, ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView));
      ReadInJoyNinePicDeliverDynamicGridView.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView);
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
      if (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView) != null) {
        ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      return;
      i = this.jdField_a_of_type_Int;
      break;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.e = paramInt;
    ReadInJoyNinePicDeliverDynamicGridView.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView, paramInt);
    c();
    if (ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView) != null) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyNinePicDeliverDynamicGridView).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rsv
 * JD-Core Version:    0.7.0.1
 */