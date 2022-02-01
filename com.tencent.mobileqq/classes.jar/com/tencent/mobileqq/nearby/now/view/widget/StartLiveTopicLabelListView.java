package com.tencent.mobileqq.nearby.now.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.mobileqq.nearby.now.IResourceUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.HorizontalListView;
import java.util.List;

public class StartLiveTopicLabelListView
  extends LinearLayout
{
  private int jdField_a_of_type_Int = ((IResourceUtil)QRoute.api(IResourceUtil.class)).getQQNearbyNowBgStartLiveNormalGap();
  private Context jdField_a_of_type_AndroidContentContext;
  private BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter = new StartLiveTopicLabelListView.1(this);
  private StartLiveTopicLabelListView.IAddTopicClickListener jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetStartLiveTopicLabelListView$IAddTopicClickListener;
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private final String jdField_a_of_type_JavaLangString = "TopicLabelListView";
  private List<String> jdField_a_of_type_JavaUtilList;
  private int b = -1;
  private int c = ((IResourceUtil)QRoute.api(IResourceUtil.class)).getQQNearbyNowBgStartLiveGap();
  private int d = -1;
  
  public StartLiveTopicLabelListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public StartLiveTopicLabelListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public StartLiveTopicLabelListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = new HorizontalListView(paramContext);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth((int)((IUIToolsApi)QRoute.api(IUIToolsApi.class)).dp2px(paramContext, 5.0F));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_AndroidWidgetBaseAdapter);
    addView(this.jdField_a_of_type_ComTencentWidgetHorizontalListView, -1, -1);
  }
  
  public void setData(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
  
  public void setItemAddLabelResId(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setItemAddLabelTextColor(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setItemResId(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setItemTextColor(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.StartLiveTopicLabelListView
 * JD-Core Version:    0.7.0.1
 */