package com.tencent.mobileqq.filemanager.data;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.widget.MotionViewSetter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class BaseLocalFileAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private MotionViewSetter jdField_a_of_type_ComTencentMobileqqWidgetMotionViewSetter = null;
  private Object jdField_a_of_type_JavaLangObject;
  
  public BaseLocalFileAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(MotionViewSetter paramMotionViewSetter)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetMotionViewSetter = paramMotionViewSetter;
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public int getCount()
  {
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.BaseLocalFileAdapter
 * JD-Core Version:    0.7.0.1
 */