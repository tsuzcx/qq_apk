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
import com.tencent.mobileqq.search.model.NetSearchTemplateBaseItem.ImageInfo;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorSlidingContainerItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalBaseItem;
import com.tencent.mobileqq.search.model.NetSearchTemplateHorizontalOneItem;
import com.tencent.mobileqq.search.view.NetSearchTemplateHorizontalBaseView;
import com.tencent.mobileqq.search.view.NetSearchTemplateHorizontalOneView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.List;

public class SearchTemplateHorSlidingDataAdapter
  extends BaseAdapter
{
  public static final String a;
  public float a;
  public int a;
  public long a;
  public NetSearchTemplateHorSlidingContainerItem a;
  public HorizontalListView a;
  public List<NetSearchTemplateHorizontalBaseItem> a;
  public float b;
  public int b;
  
  static
  {
    jdField_a_of_type_JavaLangString = SearchTemplateHorSlidingDataAdapter.class.getSimpleName();
  }
  
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
    switch (getItemViewType(paramInt))
    {
    default: 
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    case 1: 
      localObject2 = (NetSearchTemplateHorizontalOneItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      label86:
      float f;
      if (paramView == null)
      {
        localObject1 = new NetSearchTemplateHorizontalOneView(paramViewGroup, 0);
        paramView = ((NetSearchTemplateHorizontalOneView)localObject1).a();
        paramView.setTag(localObject1);
        f = this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateHorSlidingContainerItem.jdField_a_of_type_Int;
        f = (float)(DeviceInfoUtil.k() - DisplayUtil.a(paramView.getContext(), 13.5F)) / (f + 0.5F);
        if (this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateHorSlidingContainerItem.jdField_a_of_type_Int == 5)
        {
          f = (float)((DeviceInfoUtil.k() - DisplayUtil.a(paramView.getContext(), 32.0F)) / 3L);
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth(10);
        }
        this.jdField_a_of_type_Float = (DisplayUtil.a(this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getContext(), 3.0F) + f);
        switch (((NetSearchTemplateHorizontalOneItem)localObject2).jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateBaseItem$ImageInfo.jdField_a_of_type_Int)
        {
        default: 
          this.jdField_b_of_type_Float = (f * 136.0F / 220.0F);
        }
      }
      for (;;)
      {
        ((NetSearchTemplateHorizontalOneView)localObject1).a().setLayoutParams(new LinearLayout.LayoutParams((int)f, -2));
        ((NetSearchTemplateHorizontalOneItem)localObject2).a((NetSearchTemplateHorizontalBaseView)localObject1);
        ((NetSearchTemplateHorizontalOneView)localObject1).a().measure(1073741824, 0);
        this.jdField_b_of_type_Int = Math.max(((NetSearchTemplateHorizontalOneView)localObject1).a().getMeasuredHeight(), this.jdField_b_of_type_Int);
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLayoutParams().height = this.jdField_b_of_type_Int;
        this.jdField_a_of_type_Long = ((NetSearchTemplateHorizontalOneItem)localObject2).jdField_a_of_type_Long;
        break;
        localObject1 = (NetSearchTemplateHorizontalOneView)paramView.getTag();
        break label86;
        this.jdField_b_of_type_Float = (f * 136.0F / 220.0F);
        continue;
        this.jdField_b_of_type_Float = f;
        continue;
        this.jdField_b_of_type_Float = (228.0F * f / 162.0F);
        continue;
        this.jdField_b_of_type_Float = f;
      }
    }
    Object localObject1 = paramView;
    if (paramView == null) {
      localObject1 = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131559954, paramViewGroup, false);
    }
    Object localObject2 = new FrameLayout.LayoutParams(-1, (int)this.jdField_b_of_type_Float);
    ((FrameLayout.LayoutParams)localObject2).topMargin = DisplayUtil.a(paramViewGroup.getContext(), 6.0F);
    paramView = (LinearLayout)((View)localObject1).findViewById(2131365255);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject2 = (ImageView)((View)localObject1).findViewById(2131371866);
    TextView localTextView = (TextView)((View)localObject1).findViewById(2131371892);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramView.setBackgroundResource(2130839529);
      localTextView.setTextColor(Color.parseColor("#4A4A4A"));
      ((ImageView)localObject2).setImageResource(2130842530);
    }
    for (;;)
    {
      localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqSearchModelNetSearchTemplateHorSlidingContainerItem.jdField_a_of_type_JavaLangCharSequence);
      ((View)localObject1).setOnClickListener(new SearchTemplateHorSlidingDataAdapter.2(this, paramViewGroup));
      paramView = (View)localObject1;
      break;
      paramView.setBackgroundResource(2130839528);
      localTextView.setTextColor(Color.parseColor("#737373"));
      ((ImageView)localObject2).setImageResource(2130842529);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.adapter.SearchTemplateHorSlidingDataAdapter
 * JD-Core Version:    0.7.0.1
 */