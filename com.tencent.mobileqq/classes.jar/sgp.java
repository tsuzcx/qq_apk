import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshAnimView;
import com.tencent.mobileqq.widget.PullRefreshHeader;

public class sgp
  extends sgm
{
  private RefreshAnimView a;
  
  public sgp(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298598);
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Yst == null)
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131562506, paramViewGroup, false);
      paramViewGroup.findViewById(2131375536).getLayoutParams().width = -2;
      this.jdField_a_of_type_Yst = ((yst)paramViewGroup);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView = ((RefreshAnimView)((PullRefreshHeader)this.jdField_a_of_type_Yst).findViewById(2131375529));
    }
    return (View)this.jdField_a_of_type_Yst;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Yst == null) {
      return;
    }
    this.jdField_a_of_type_Yst.a(0L);
    this.jdField_a_of_type_Yst.aw_();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    super.a(paramInt, paramBoolean);
    if (this.jdField_a_of_type_Yst == null) {
      return;
    }
    if (paramInt == 100)
    {
      this.jdField_a_of_type_Yst.b(0L);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Yst.aw_();
      return;
    }
    this.jdField_a_of_type_Yst.c(0L);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a(paramInt / 100.0D);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Yst == null) {
      return;
    }
    this.jdField_a_of_type_Yst.a(0L);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewPullrefreshRefreshAnimView.b();
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_Yst == null) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sgp
 * JD-Core Version:    0.7.0.1
 */