package com.tencent.mobileqq.nearby.now.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import asrh;
import com.tencent.widget.HorizontalListView;
import java.util.List;
import mjg;

public class TopicLabelListView
  extends LinearLayout
{
  private Context jdField_a_of_type_AndroidContentContext;
  private BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter = new asrh(this);
  private HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  private final String jdField_a_of_type_JavaLangString = "TopicLabelListView";
  private List<String> jdField_a_of_type_JavaUtilList;
  
  public TopicLabelListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public TopicLabelListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public TopicLabelListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = new HorizontalListView(paramContext);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth((int)mjg.a(paramContext, 5.0F));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_AndroidWidgetBaseAdapter);
    addView(this.jdField_a_of_type_ComTencentWidgetHorizontalListView, -1, -1);
  }
  
  public void setData(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.TopicLabelListView
 * JD-Core Version:    0.7.0.1
 */