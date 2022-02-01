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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.List;

public class ovk
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private List<ovn> jdField_a_of_type_JavaUtilList;
  
  private ovk(ReadinjoySubscriptManagerActivity paramReadinjoySubscriptManagerActivity) {}
  
  private void a(ovo paramovo, int paramInt, View paramView)
  {
    ovn localovn = (ovn)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    ovo.a(paramovo).setText(ovn.b(localovn));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)ovo.a(paramovo).getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
    }
    ovo.a(paramovo).setImageDrawable(ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity).a(1008, ovn.c(localovn)));
    int i;
    if (ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity))
    {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      localObject = ovo.a(paramovo);
      if (!ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity)) {
        break label238;
      }
      i = 0;
      label121:
      ((View)localObject).setVisibility(i);
      ovo.a(paramovo).setOnClickListener(new ovl(this, paramView));
      if (paramInt != getCount() - 1) {
        break label245;
      }
      ovo.b(paramovo).setVisibility(8);
      label163:
      ovo.a(paramovo).setOnClickListener(new ovm(this, localovn));
      ovo.a(paramovo, ovn.c(localovn));
      if (!ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity)) {
        break label256;
      }
      ovo.c(paramovo).setBackgroundResource(2131166909);
    }
    for (;;)
    {
      ovo.c(paramovo).setPressed(false);
      return;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity.getResources().getDimensionPixelSize(2131298773);
      break;
      label238:
      i = 8;
      break label121;
      label245:
      ovo.b(paramovo).setVisibility(0);
      break label163;
      label256:
      ovo.c(paramovo).setBackgroundResource(2130841743);
    }
  }
  
  public void a(List<ovn> paramList)
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
      paramView = new ovo(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity, null);
      localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity.getLayoutInflater().inflate(2131560334, paramViewGroup, false);
      ovo.a(paramView, localView.findViewById(2131365119));
      ovo.b(paramView, localView.findViewById(2131365469));
      ovo.a(paramView, (ImageView)localView.findViewById(2131378251));
      ovo.a(paramView, (TextView)localView.findViewById(2131378257));
      ovo.a(paramView, (Button)localView.findViewById(2131380461));
      ovo.c(paramView, localView.findViewById(2131365759));
      localView.setTag(paramView);
      localView.setTag(-3, Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity.getResources().getDimensionPixelSize(2131298774)));
    }
    for (;;)
    {
      a(paramView, paramInt, localView);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      ovo localovo = (ovo)paramView.getTag();
      localView = paramView;
      paramView = localovo;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (ovn)getItem((int)paramLong);
    if ((paramAdapterView == null) || (ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity))) {
      return;
    }
    paramView = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity, AccountDetailActivity.class);
    paramView.putExtra("uin", ovn.c(paramAdapterView));
    paramView.putExtra("report_src_param_type", "");
    paramView.putExtra("report_src_param_name", "");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ovk
 * JD-Core Version:    0.7.0.1
 */