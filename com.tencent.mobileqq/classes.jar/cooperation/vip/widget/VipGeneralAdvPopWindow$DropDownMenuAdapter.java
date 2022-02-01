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
    return a().inflate(2131563212, null);
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
    View localView;
    if (paramView == null)
    {
      paramView = new VipGeneralAdvPopWindow.ViewHolder(this.jdField_a_of_type_CooperationVipWidgetVipGeneralAdvPopWindow);
      localView = a();
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371182));
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131370283));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131366070);
      localView.setTag(paramView);
      if (paramView != null) {
        break label107;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      Object localObject = (VipGeneralAdvPopWindow.ViewHolder)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label107:
      if (getCount() <= 1)
      {
        paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
        localView.setBackgroundResource(2130849675);
      }
      for (;;)
      {
        localObject = (VipGeneralAdvPopWindow.MenuData)getItem(paramInt);
        if (localObject != null) {
          break label218;
        }
        break;
        if (paramInt <= 0)
        {
          paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
          localView.setBackgroundResource(2130849675);
        }
        else if (paramInt < getCount() - 1)
        {
          paramView.jdField_a_of_type_AndroidViewView.setVisibility(0);
          localView.setBackgroundResource(2130849674);
        }
        else
        {
          paramView.jdField_a_of_type_AndroidViewView.setVisibility(8);
          localView.setBackgroundResource(2130849673);
        }
      }
      label218:
      paramView.jdField_a_of_type_CooperationVipWidgetVipGeneralAdvPopWindow$MenuData = ((VipGeneralAdvPopWindow.MenuData)localObject);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((VipGeneralAdvPopWindow.MenuData)localObject).a);
      if (TextUtils.isEmpty(((VipGeneralAdvPopWindow.MenuData)localObject).b)) {
        paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      a((VipGeneralAdvPopWindow.MenuData)localObject, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.widget.VipGeneralAdvPopWindow.DropDownMenuAdapter
 * JD-Core Version:    0.7.0.1
 */