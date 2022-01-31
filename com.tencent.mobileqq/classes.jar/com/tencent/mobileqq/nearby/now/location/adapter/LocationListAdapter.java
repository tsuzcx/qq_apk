package com.tencent.mobileqq.nearby.now.location.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;
import com.tencent.mobileqq.nearby.now.widget.CommonViewHolder;
import java.util.List;

public class LocationListAdapter
  extends SelectableAdapter
{
  public LocationListAdapter(Context paramContext, int paramInt, List paramList)
  {
    super(paramContext, paramInt, paramList);
  }
  
  protected int a(int paramInt)
  {
    return paramInt;
  }
  
  public CommonViewHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return super.a(paramViewGroup, paramInt);
  }
  
  protected void a(View paramView)
  {
    paramView.findViewById(2131365278).setVisibility(0);
  }
  
  protected void a(CommonViewHolder paramCommonViewHolder, int paramInt, LocationInfo paramLocationInfo)
  {
    if (paramLocationInfo.equals((LocationInfo)this.jdField_a_of_type_JavaLangObject))
    {
      this.jdField_a_of_type_AndroidViewView = paramCommonViewHolder.itemView;
      this.jdField_a_of_type_Int = paramInt;
      paramCommonViewHolder.a(2131365278).setVisibility(0);
      if (getItemViewType(paramInt) != this.b) {
        break label71;
      }
      super.a(paramCommonViewHolder, paramInt, paramLocationInfo);
    }
    label71:
    while ((paramLocationInfo.isCityEmpty()) && (paramLocationInfo.isNameEmpty()))
    {
      return;
      paramCommonViewHolder.a(2131365278).setVisibility(8);
      break;
    }
    paramCommonViewHolder.a(2131365277, paramLocationInfo.getNameOrCity());
    paramCommonViewHolder.a(2131365277, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(17170444));
  }
  
  public void a(CommonViewHolder paramCommonViewHolder, LocationInfo paramLocationInfo)
  {
    paramCommonViewHolder.a(2131365279, paramLocationInfo.getName());
    paramCommonViewHolder.a(2131365280, paramLocationInfo.getAddress());
  }
  
  protected int b(int paramInt)
  {
    LocationInfo localLocationInfo = (LocationInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if ((localLocationInfo != null) && ((localLocationInfo.isNameEmpty()) || (localLocationInfo.isCityEmpty()))) {
      return 2130969128;
    }
    return super.b(paramInt);
  }
  
  protected void b(View paramView)
  {
    paramView.findViewById(2131365278).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.location.adapter.LocationListAdapter
 * JD-Core Version:    0.7.0.1
 */