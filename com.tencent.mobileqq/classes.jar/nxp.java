import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity;
import com.tencent.widget.AdapterView;
import java.util.List;

public class nxp
  extends BaseAdapter
  implements bfpt
{
  private List<nxs> jdField_a_of_type_JavaUtilList;
  
  private nxp(ReadinjoySubscriptManagerActivity paramReadinjoySubscriptManagerActivity) {}
  
  private void a(nxt paramnxt, int paramInt, View paramView)
  {
    nxs localnxs = (nxs)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    nxt.a(paramnxt).setText(nxs.b(localnxs));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)nxt.a(paramnxt).getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
    }
    nxt.a(paramnxt).setImageDrawable(ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity).a(1008, nxs.c(localnxs)));
    int i;
    if (ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity))
    {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      localObject = nxt.a(paramnxt);
      if (!ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity)) {
        break label238;
      }
      i = 0;
      label121:
      ((View)localObject).setVisibility(i);
      nxt.a(paramnxt).setOnClickListener(new nxq(this, paramView));
      if (paramInt != getCount() - 1) {
        break label245;
      }
      nxt.b(paramnxt).setVisibility(8);
      label163:
      nxt.a(paramnxt).setOnClickListener(new nxr(this, localnxs));
      nxt.a(paramnxt, nxs.c(localnxs));
      if (!ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity)) {
        break label256;
      }
      nxt.c(paramnxt).setBackgroundResource(2131166743);
    }
    for (;;)
    {
      nxt.c(paramnxt).setPressed(false);
      return;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity.getResources().getDimensionPixelSize(2131298582);
      break;
      label238:
      i = 8;
      break label121;
      label245:
      nxt.b(paramnxt).setVisibility(0);
      break label163;
      label256:
      nxt.c(paramnxt).setBackgroundResource(2130841262);
    }
  }
  
  public void a(List<nxs> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      paramView = new nxt(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity, null);
      localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity.getLayoutInflater().inflate(2131560027, paramViewGroup, false);
      nxt.a(paramView, localView.findViewById(2131364656));
      nxt.b(paramView, localView.findViewById(2131364978));
      nxt.a(paramView, (ImageView)localView.findViewById(2131376663));
      nxt.a(paramView, (TextView)localView.findViewById(2131376669));
      nxt.a(paramView, (Button)localView.findViewById(2131378614));
      nxt.c(paramView, localView.findViewById(2131365268));
      localView.setTag(paramView);
      localView.setTag(-3, Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity.getResources().getDimensionPixelSize(2131298583)));
      paramViewGroup = paramView;
    }
    for (;;)
    {
      a(paramViewGroup, paramInt, localView);
      return localView;
      paramViewGroup = (nxt)paramView.getTag();
      localView = paramView;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (nxs)getItem((int)paramLong);
    if ((paramAdapterView == null) || (ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity))) {
      return;
    }
    paramView = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity, AccountDetailActivity.class);
    paramView.putExtra("uin", nxs.c(paramAdapterView));
    paramView.putExtra("report_src_param_type", "");
    paramView.putExtra("report_src_param_name", "");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nxp
 * JD-Core Version:    0.7.0.1
 */