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
import java.util.List;

public class omc
  extends BaseAdapter
  implements bljm
{
  private List<omf> jdField_a_of_type_JavaUtilList;
  
  private omc(ReadinjoySubscriptManagerActivity paramReadinjoySubscriptManagerActivity) {}
  
  private void a(omg paramomg, int paramInt, View paramView)
  {
    omf localomf = (omf)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    omg.a(paramomg).setText(omf.b(localomf));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)omg.a(paramomg).getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
    }
    omg.a(paramomg).setImageDrawable(ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity).a(1008, omf.c(localomf)));
    int i;
    if (ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity))
    {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      localObject = omg.a(paramomg);
      if (!ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity)) {
        break label238;
      }
      i = 0;
      label121:
      ((View)localObject).setVisibility(i);
      omg.a(paramomg).setOnClickListener(new omd(this, paramView));
      if (paramInt != getCount() - 1) {
        break label245;
      }
      omg.b(paramomg).setVisibility(8);
      label163:
      omg.a(paramomg).setOnClickListener(new ome(this, localomf));
      omg.a(paramomg, omf.c(localomf));
      if (!ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity)) {
        break label256;
      }
      omg.c(paramomg).setBackgroundResource(2131166876);
    }
    for (;;)
    {
      omg.c(paramomg).setPressed(false);
      return;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity.getResources().getDimensionPixelSize(2131298704);
      break;
      label238:
      i = 8;
      break label121;
      label245:
      omg.b(paramomg).setVisibility(0);
      break label163;
      label256:
      omg.c(paramomg).setBackgroundResource(2130841693);
    }
  }
  
  public void a(List<omf> paramList)
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
      paramView = new omg(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity, null);
      localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity.getLayoutInflater().inflate(2131560281, paramViewGroup, false);
      omg.a(paramView, localView.findViewById(2131365008));
      omg.b(paramView, localView.findViewById(2131365346));
      omg.a(paramView, (ImageView)localView.findViewById(2131378193));
      omg.a(paramView, (TextView)localView.findViewById(2131378199));
      omg.a(paramView, (Button)localView.findViewById(2131380402));
      omg.c(paramView, localView.findViewById(2131365632));
      localView.setTag(paramView);
      localView.setTag(-3, Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity.getResources().getDimensionPixelSize(2131298705)));
    }
    for (;;)
    {
      a(paramView, paramInt, localView);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      omg localomg = (omg)paramView.getTag();
      localView = paramView;
      paramView = localomg;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (omf)getItem((int)paramLong);
    if ((paramAdapterView == null) || (ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity))) {
      return;
    }
    paramView = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity, AccountDetailActivity.class);
    paramView.putExtra("uin", omf.c(paramAdapterView));
    paramView.putExtra("report_src_param_type", "");
    paramView.putExtra("report_src_param_name", "");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     omc
 * JD-Core Version:    0.7.0.1
 */