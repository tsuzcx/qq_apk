package com.tencent.mobileqq.search.adapter;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateBaseItem.ImageInfo;
import com.tencent.mobileqq.search.business.net.model.NetSearchTemplateHorizontalBaseItem;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateHorizontalBaseView;
import com.tencent.mobileqq.search.business.net.view.NetSearchTemplateHorizontalOneView;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorSlidingContainerItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalOneItem;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.List;

public class SearchTemplateHorSlidingDataAdapter
  extends BaseAdapter
{
  public static final String a = "SearchTemplateHorSlidingDataAdapter";
  public float a;
  public int a;
  public long a;
  public NetSearchTemplateHorSlidingContainerItem a;
  public HorizontalListView a;
  public List<NetSearchTemplateHorizontalBaseItem> a;
  public float b;
  public int b;
  
  public SearchTemplateHorSlidingDataAdapter(NetSearchTemplateHorSlidingContainerItem paramNetSearchTemplateHorSlidingContainerItem, int paramInt, HorizontalListView paramHorizontalListView)
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateHorSlidingContainerItem = paramNetSearchTemplateHorSlidingContainerItem;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = paramHorizontalListView;
    paramHorizontalListView.setOnScrollListener(new SearchTemplateHorSlidingDataAdapter.1(this, paramHorizontalListView));
  }
  
  public NetSearchTemplateHorizontalBaseItem a(int paramInt)
  {
    return (NetSearchTemplateHorizontalBaseItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public List<NetSearchTemplateHorizontalBaseItem> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(List<NetSearchTemplateHorizontalBaseItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateHorSlidingContainerItem.m)) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt == this.jdField_a_of_type_JavaUtilList.size()) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateHorSlidingContainerItem.m))) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    View localView;
    Object localObject1;
    Object localObject2;
    if (i != 1)
    {
      if (i == 2)
      {
        localView = paramView;
        if (paramView == null) {
          localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559825, paramViewGroup, false);
        }
        localObject1 = new FrameLayout.LayoutParams(-1, (int)this.jdField_b_of_type_Float);
        ((FrameLayout.LayoutParams)localObject1).topMargin = DisplayUtil.a(paramViewGroup.getContext(), 6.0F);
        paramView = (LinearLayout)localView.findViewById(2131365132);
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = (ImageView)localView.findViewById(2131371488);
        localObject2 = (TextView)localView.findViewById(2131371513);
        if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
        {
          paramView.setBackgroundResource(2130839385);
          ((TextView)localObject2).setTextColor(Color.parseColor("#4A4A4A"));
          ((ImageView)localObject1).setImageResource(2130842429);
        }
        else
        {
          paramView.setBackgroundResource(2130839384);
          ((TextView)localObject2).setTextColor(Color.parseColor("#737373"));
          ((ImageView)localObject1).setImageResource(2130842428);
        }
        ((TextView)localObject2).setText(this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateHorSlidingContainerItem.jdField_a_of_type_JavaLangCharSequence);
        localView.setOnClickListener(new SearchTemplateHorSlidingDataAdapter.2(this, paramViewGroup));
        paramView = localView;
      }
    }
    else
    {
      localObject2 = (NetSearchTemplateHorizontalOneItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      ((NetSearchTemplateHorizontalOneItem)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateHorSlidingContainerItem.jdField_a_of_type_Int);
      if (paramView == null)
      {
        paramView = new NetSearchTemplateHorizontalOneView(paramViewGroup, 0);
        localView = paramView.a();
        localView.setTag(paramView);
        localObject1 = paramView;
        paramView = localView;
      }
      else
      {
        localObject1 = (NetSearchTemplateHorizontalOneView)paramView.getTag();
      }
      float f = this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateHorSlidingContainerItem.jdField_a_of_type_Int;
      f = (float)(DeviceInfoUtil.k() - DisplayUtil.a(paramView.getContext(), 13.5F)) / (f + 0.5F);
      if ((this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateHorSlidingContainerItem.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateHorSlidingContainerItem.jdField_a_of_type_Int == 6))
      {
        f = (float)((DeviceInfoUtil.k() - DisplayUtil.a(paramView.getContext(), 32.0F)) / 3L);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(10);
      }
      this.jdField_a_of_type_Float = (DisplayUtil.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getContext(), 3.0F) + f);
      switch (((NetSearchTemplateHorizontalOneItem)localObject2).jdField_a_of_type_ComTencentMobileqqSearchBusinessNetModelNetSearchTemplateBaseItem$ImageInfo.jdField_a_of_type_Int)
      {
      default: 
        this.jdField_b_of_type_Float = (136.0F * f / 220.0F);
        break;
      case 11: 
        this.jdField_b_of_type_Float = f;
        break;
      case 10: 
        this.jdField_b_of_type_Float = (228.0F * f / 162.0F);
        break;
      case 9: 
        this.jdField_b_of_type_Float = f;
        break;
      case 8: 
        this.jdField_b_of_type_Float = (136.0F * f / 220.0F);
      }
      ((NetSearchTemplateHorizontalOneView)localObject1).a().setLayoutParams(new LinearLayout.LayoutParams((int)f, -2));
      ((NetSearchTemplateHorizontalOneItem)localObject2).a((NetSearchTemplateHorizontalBaseView)localObject1);
      ((NetSearchTemplateHorizontalOneView)localObject1).a().measure(1073741824, 0);
      this.jdField_b_of_type_Int = Math.max(((NetSearchTemplateHorizontalOneView)localObject1).a().getMeasuredHeight(), this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLayoutParams().height = this.jdField_b_of_type_Int;
      this.jdField_a_of_type_Long = ((NetSearchTemplateHorizontalOneItem)localObject2).jdField_a_of_type_Long;
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.adapter.SearchTemplateHorSlidingDataAdapter
 * JD-Core Version:    0.7.0.1
 */