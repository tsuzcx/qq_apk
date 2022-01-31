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
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.List;

public class lfq
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private List jdField_a_of_type_JavaUtilList;
  
  private lfq(ReadinjoySubscriptManagerActivity paramReadinjoySubscriptManagerActivity) {}
  
  private void a(lfu paramlfu, int paramInt, View paramView)
  {
    lft locallft = (lft)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    lfu.a(paramlfu).setText(lft.b(locallft));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)lfu.a(paramlfu).getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
    }
    lfu.a(paramlfu).setImageDrawable(ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity).a(1008, lft.c(locallft)));
    int i;
    if (ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity))
    {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      localObject = lfu.a(paramlfu);
      if (!ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity)) {
        break label238;
      }
      i = 0;
      label121:
      ((View)localObject).setVisibility(i);
      lfu.a(paramlfu).setOnClickListener(new lfr(this, paramView));
      if (paramInt != getCount() - 1) {
        break label245;
      }
      lfu.b(paramlfu).setVisibility(8);
      label163:
      lfu.a(paramlfu).setOnClickListener(new lfs(this, locallft));
      lfu.a(paramlfu, lft.c(locallft));
      if (!ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity)) {
        break label256;
      }
      lfu.c(paramlfu).setBackgroundResource(2131493470);
    }
    for (;;)
    {
      lfu.c(paramlfu).setPressed(false);
      return;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity.getResources().getDimensionPixelSize(2131560140);
      break;
      label238:
      i = 8;
      break label121;
      label245:
      lfu.b(paramlfu).setVisibility(0);
      break label163;
      label256:
      lfu.c(paramlfu).setBackgroundResource(2130839723);
    }
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (lft)getItem((int)paramLong);
    if ((paramAdapterView == null) || (ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity))) {
      return;
    }
    paramView = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity, AccountDetailActivity.class);
    paramView.putExtra("uin", lft.c(paramAdapterView));
    paramView.putExtra("report_src_param_type", "");
    paramView.putExtra("report_src_param_name", "");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity.startActivity(paramView);
  }
  
  public void a(List paramList)
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
      paramView = new lfu(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity, null);
      localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity.getLayoutInflater().inflate(2130969655, paramViewGroup, false);
      lfu.a(paramView, localView.findViewById(2131362841));
      lfu.b(paramView, localView.findViewById(2131362740));
      lfu.a(paramView, (ImageView)localView.findViewById(2131367343));
      lfu.a(paramView, (TextView)localView.findViewById(2131367344));
      lfu.a(paramView, (Button)localView.findViewById(2131367345));
      lfu.c(paramView, localView.findViewById(2131363630));
      localView.setTag(paramView);
      localView.setTag(-3, Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity.getResources().getDimensionPixelSize(2131560141)));
      paramViewGroup = paramView;
    }
    for (;;)
    {
      a(paramViewGroup, paramInt, localView);
      return localView;
      paramViewGroup = (lfu)paramView.getTag();
      localView = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lfq
 * JD-Core Version:    0.7.0.1
 */