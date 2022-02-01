import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshAnimView;
import com.tencent.mobileqq.widget.PullRefreshHeader;

public class svy
  extends svv
{
  private RefreshAnimView a;
  
  public svy(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298693);
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Aayo == null)
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562797, paramViewGroup, false);
      paramViewGroup.findViewById(2131376444).getLayoutParams().width = -2;
      this.jdField_a_of_type_Aayo = ((aayo)paramViewGroup);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView = ((RefreshAnimView)((PullRefreshHeader)this.jdField_a_of_type_Aayo).findViewById(2131376436));
    }
    return (View)this.jdField_a_of_type_Aayo;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aayo == null) {
      return;
    }
    this.jdField_a_of_type_Aayo.a(0L);
    this.jdField_a_of_type_Aayo.aq_();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    super.a(paramInt, paramBoolean);
    if (this.jdField_a_of_type_Aayo == null) {
      return;
    }
    if (paramInt == 100)
    {
      this.jdField_a_of_type_Aayo.b(0L);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Aayo.aq_();
      return;
    }
    this.jdField_a_of_type_Aayo.c(0L);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a(paramInt / 100.0D);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Aayo == null) {
      return;
    }
    this.jdField_a_of_type_Aayo.a(0L);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.b();
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_Aayo == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a(paramBoolean, paramString);
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a(1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     svy
 * JD-Core Version:    0.7.0.1
 */