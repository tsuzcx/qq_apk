import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshAnimView;
import com.tencent.viola.ui.view.VRefreshLayout;
import com.tencent.viola.ui.view.VRefreshLayout.onRefreshStateChangeListener;

class rww
  implements VRefreshLayout.onRefreshStateChangeListener
{
  rww(rwv paramrwv, RefreshAnimView paramRefreshAnimView, VRefreshLayout paramVRefreshLayout) {}
  
  public void onRefreshMove(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentViolaUiViewVRefreshLayout.getHeaderHeight();
    if ((paramInt <= i) && (!rwv.a(this.jdField_a_of_type_Rwv)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a(paramInt / i);
    }
  }
  
  public void onStateEnd()
  {
    rwv.a(this.jdField_a_of_type_Rwv, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a(1000L);
  }
  
  public void onStateFinish(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a(paramBoolean, paramString);
  }
  
  public void onStateIdel()
  {
    rwv.a(this.jdField_a_of_type_Rwv, false);
  }
  
  public void onStatePulling() {}
  
  public void onStateRefreshing()
  {
    rwv.a(this.jdField_a_of_type_Rwv, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rww
 * JD-Core Version:    0.7.0.1
 */