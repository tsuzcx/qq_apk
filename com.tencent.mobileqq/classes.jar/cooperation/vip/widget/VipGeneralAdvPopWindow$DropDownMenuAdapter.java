package cooperation.vip.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class VipGeneralAdvPopWindow$DropDownMenuAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public VipGeneralAdvPopWindow$DropDownMenuAdapter(VipGeneralAdvPopWindow paramVipGeneralAdvPopWindow, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private LayoutInflater a()
  {
    if (this.jdField_a_of_type_AndroidViewLayoutInflater == null) {
      this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    }
    return this.jdField_a_of_type_AndroidViewLayoutInflater;
  }
  
  private View a()
  {
    return a().inflate(2131563036, null);
  }
  
  private void a(VipGeneralAdvPopWindow.MenuData paramMenuData, VipGeneralAdvPopWindow.ViewHolder paramViewHolder)
  {
    paramMenuData = URLDrawable.getDrawable(paramMenuData.b, null);
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMenuData);
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_CooperationVipWidgetVipGeneralAdvPopWindow.a != null) {
      return this.jdField_a_of_type_CooperationVipWidgetVipGeneralAdvPopWindow.a.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_CooperationVipWidgetVipGeneralAdvPopWindow.a != null) {
      return this.jdField_a_of_type_CooperationVipWidgetVipGeneralAdvPopWindow.a.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if (this.jdField_a_of_type_CooperationVipWidgetVipGeneralAdvPopWindow.a != null) {
      return this.jdField_a_of_type_CooperationVipWidgetVipGeneralAdvPopWindow.a.size();
    }
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    VipGeneralAdvPopWindow.ViewHolder localViewHolder;
    if (paramView == null)
    {
      localViewHolder = new VipGeneralAdvPopWindow.ViewHolder(this.jdField_a_of_type_CooperationVipWidgetVipGeneralAdvPopWindow);
      paramView = a();
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370807));
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369951));
      localViewHolder.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131365987);
      paramView.setTag(localViewHolder);
    }
    else
    {
      localViewHolder = (VipGeneralAdvPopWindow.ViewHolder)paramView.getTag();
    }
    if (localViewHolder != null)
    {
      if (getCount() <= 1)
      {
        localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramView.setBackgroundResource(2130849572);
      }
      else if (paramInt <= 0)
      {
        localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramView.setBackgroundResource(2130849572);
      }
      else if (paramInt < getCount() - 1)
      {
        localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        paramView.setBackgroundResource(2130849571);
      }
      else
      {
        localViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
        paramView.setBackgroundResource(2130849570);
      }
      VipGeneralAdvPopWindow.MenuData localMenuData = (VipGeneralAdvPopWindow.MenuData)getItem(paramInt);
      if (localMenuData != null)
      {
        localViewHolder.jdField_a_of_type_CooperationVipWidgetVipGeneralAdvPopWindow$MenuData = localMenuData;
        localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localMenuData.a);
        if (TextUtils.isEmpty(localMenuData.b)) {
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        }
        a(localMenuData, localViewHolder);
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.widget.VipGeneralAdvPopWindow.DropDownMenuAdapter
 * JD-Core Version:    0.7.0.1
 */