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

public class oaw
  extends BaseAdapter
  implements bhqp
{
  private List<oaz> jdField_a_of_type_JavaUtilList;
  
  private oaw(ReadinjoySubscriptManagerActivity paramReadinjoySubscriptManagerActivity) {}
  
  private void a(oba paramoba, int paramInt, View paramView)
  {
    oaz localoaz = (oaz)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    oba.a(paramoba).setText(oaz.b(localoaz));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)oba.a(paramoba).getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
    }
    oba.a(paramoba).setImageDrawable(ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity).a(1008, oaz.c(localoaz)));
    int i;
    if (ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity))
    {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      localObject = oba.a(paramoba);
      if (!ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity)) {
        break label238;
      }
      i = 0;
      label121:
      ((View)localObject).setVisibility(i);
      oba.a(paramoba).setOnClickListener(new oax(this, paramView));
      if (paramInt != getCount() - 1) {
        break label245;
      }
      oba.b(paramoba).setVisibility(8);
      label163:
      oba.a(paramoba).setOnClickListener(new oay(this, localoaz));
      oba.a(paramoba, oaz.c(localoaz));
      if (!ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity)) {
        break label256;
      }
      oba.c(paramoba).setBackgroundResource(2131166790);
    }
    for (;;)
    {
      oba.c(paramoba).setPressed(false);
      return;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity.getResources().getDimensionPixelSize(2131298609);
      break;
      label238:
      i = 8;
      break label121;
      label245:
      oba.b(paramoba).setVisibility(0);
      break label163;
      label256:
      oba.c(paramoba).setBackgroundResource(2130841380);
    }
  }
  
  public void a(List<oaz> paramList)
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
      paramView = new oba(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity, null);
      localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity.getLayoutInflater().inflate(2131560128, paramViewGroup, false);
      oba.a(paramView, localView.findViewById(2131364735));
      oba.b(paramView, localView.findViewById(2131365063));
      oba.a(paramView, (ImageView)localView.findViewById(2131377173));
      oba.a(paramView, (TextView)localView.findViewById(2131377179));
      oba.a(paramView, (Button)localView.findViewById(2131379231));
      oba.c(paramView, localView.findViewById(2131365353));
      localView.setTag(paramView);
      localView.setTag(-3, Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity.getResources().getDimensionPixelSize(2131298610)));
      paramViewGroup = paramView;
    }
    for (;;)
    {
      a(paramViewGroup, paramInt, localView);
      return localView;
      paramViewGroup = (oba)paramView.getTag();
      localView = paramView;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (oaz)getItem((int)paramLong);
    if ((paramAdapterView == null) || (ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity))) {
      return;
    }
    paramView = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity, AccountDetailActivity.class);
    paramView.putExtra("uin", oaz.c(paramAdapterView));
    paramView.putExtra("report_src_param_type", "");
    paramView.putExtra("report_src_param_name", "");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oaw
 * JD-Core Version:    0.7.0.1
 */