import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshAnimView;
import com.tencent.viola.ui.view.VRefreshLayout;
import com.tencent.viola.ui.view.VRefreshLayout.onRefreshStateChangeListener;

class snj
  implements VRefreshLayout.onRefreshStateChangeListener
{
  snj(sni paramsni, RefreshAnimView paramRefreshAnimView, VRefreshLayout paramVRefreshLayout) {}
  
  public void onRefreshMove(int paramInt)
  {
    int i = this.jdField_a_of_type_ComTencentViolaUiViewVRefreshLayout.getHeaderHeight();
    if ((paramInt <= i) && (!sni.a(this.jdField_a_of_type_Sni)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a(paramInt / i);
    }
  }
  
  public void onStateEnd()
  {
    sni.a(this.jdField_a_of_type_Sni, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a(1000L);
  }
  
  public void onStateFinish(boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a(paramBoolean, paramString);
  }
  
  public void onStateIdel()
  {
    sni.a(this.jdField_a_of_type_Sni, false);
  }
  
  public void onStatePulling() {}
  
  public void onStateRefreshing()
  {
    sni.a(this.jdField_a_of_type_Sni, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     snj
 * JD-Core Version:    0.7.0.1
 */