import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshAnimView;
import com.tencent.viola.ui.view.VRefreshLayout;
import com.tencent.viola.ui.view.VRefreshLayout.onRefreshStateChangeListener;

class rke
  implements VRefreshLayout.onRefreshStateChangeListener
{
  rke(rkd paramrkd, RefreshAnimView paramRefreshAnimView, VRefreshLayout paramVRefreshLayout) {}
  
  public void onRefreshMove(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentViolaUiViewVRefreshLayout.getHeaderHeight();
    if ((paramInt <= i) && (!rkd.a(this.jdField_a_of_type_Rkd)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a(paramInt / i);
    }
  }
  
  public void onStateEnd()
  {
    rkd.a(this.jdField_a_of_type_Rkd, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a(1000L);
  }
  
  public void onStateFinish(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a(paramBoolean, paramString);
  }
  
  public void onStateIdel()
  {
    rkd.a(this.jdField_a_of_type_Rkd, false);
  }
  
  public void onStatePulling() {}
  
  public void onStateRefreshing()
  {
    rkd.a(this.jdField_a_of_type_Rkd, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rke
 * JD-Core Version:    0.7.0.1
 */