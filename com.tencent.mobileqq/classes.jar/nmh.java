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

public class nmh
  extends BaseAdapter
  implements behi
{
  private List<nmk> jdField_a_of_type_JavaUtilList;
  
  private nmh(ReadinjoySubscriptManagerActivity paramReadinjoySubscriptManagerActivity) {}
  
  private void a(nml paramnml, int paramInt, View paramView)
  {
    nmk localnmk = (nmk)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    nml.a(paramnml).setText(nmk.b(localnmk));
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)nml.a(paramnml).getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new RelativeLayout.LayoutParams(-2, -2);
    }
    nml.a(paramnml).setImageDrawable(ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity).a(1008, nmk.c(localnmk)));
    int i;
    if (ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity))
    {
      ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      localObject = nml.a(paramnml);
      if (!ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity)) {
        break label238;
      }
      i = 0;
      label121:
      ((View)localObject).setVisibility(i);
      nml.a(paramnml).setOnClickListener(new nmi(this, paramView));
      if (paramInt != getCount() - 1) {
        break label245;
      }
      nml.b(paramnml).setVisibility(8);
      label163:
      nml.a(paramnml).setOnClickListener(new nmj(this, localnmk));
      nml.a(paramnml, nmk.c(localnmk));
      if (!ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity)) {
        break label256;
      }
      nml.c(paramnml).setBackgroundResource(2131101149);
    }
    for (;;)
    {
      nml.c(paramnml).setPressed(false);
      return;
      ((RelativeLayout.LayoutParams)localObject).leftMargin = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity.getResources().getDimensionPixelSize(2131167489);
      break;
      label238:
      i = 8;
      break label121;
      label245:
      nml.b(paramnml).setVisibility(0);
      break label163;
      label256:
      nml.c(paramnml).setBackgroundResource(2130841186);
    }
  }
  
  public void a(List<nmk> paramList)
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
      paramView = new nml(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity, null);
      localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity.getLayoutInflater().inflate(2131494461, paramViewGroup, false);
      nml.a(paramView, localView.findViewById(2131299097));
      nml.b(paramView, localView.findViewById(2131299411));
      nml.a(paramView, (ImageView)localView.findViewById(2131310854));
      nml.a(paramView, (TextView)localView.findViewById(2131310860));
      nml.a(paramView, (Button)localView.findViewById(2131312785));
      nml.c(paramView, localView.findViewById(2131299701));
      localView.setTag(paramView);
      localView.setTag(-3, Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity.getResources().getDimensionPixelSize(2131167490)));
      paramViewGroup = paramView;
    }
    for (;;)
    {
      a(paramViewGroup, paramInt, localView);
      return localView;
      paramViewGroup = (nml)paramView.getTag();
      localView = paramView;
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (nmk)getItem((int)paramLong);
    if ((paramAdapterView == null) || (ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity))) {
      return;
    }
    paramView = new Intent(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity, AccountDetailActivity.class);
    paramView.putExtra("uin", nmk.c(paramAdapterView));
    paramView.putExtra("report_src_param_type", "");
    paramView.putExtra("report_src_param_name", "");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nmh
 * JD-Core Version:    0.7.0.1
 */