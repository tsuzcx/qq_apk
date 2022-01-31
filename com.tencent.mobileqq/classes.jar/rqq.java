import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshAnimView;
import com.tencent.mobileqq.widget.PullRefreshHeader;

public class rqq
  extends rqn
{
  private RefreshAnimView a;
  
  public rqq(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298572);
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Xea == null)
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562307, paramViewGroup, false);
      paramViewGroup.findViewById(2131375055).getLayoutParams().width = -2;
      this.jdField_a_of_type_Xea = ((xea)paramViewGroup);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView = ((RefreshAnimView)((PullRefreshHeader)this.jdField_a_of_type_Xea).findViewById(2131375048));
    }
    return (View)this.jdField_a_of_type_Xea;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Xea == null) {
      return;
    }
    this.jdField_a_of_type_Xea.a(0L);
    this.jdField_a_of_type_Xea.ao_();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    super.a(paramInt, paramBoolean);
    if (this.jdField_a_of_type_Xea == null) {
      return;
    }
    if (paramInt == 100)
    {
      this.jdField_a_of_type_Xea.b(0L);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Xea.ao_();
      return;
    }
    this.jdField_a_of_type_Xea.c(0L);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a(paramInt / 100.0D);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Xea == null) {
      return;
    }
    this.jdField_a_of_type_Xea.a(0L);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.b();
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_Xea == null) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rqq
 * JD-Core Version:    0.7.0.1
 */