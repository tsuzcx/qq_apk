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
  private Context a;
  private Object b;
  private MotionViewSetter c = null;
  
  public BaseLocalFileAdapter(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public void a(MotionViewSetter paramMotionViewSetter)
  {
    this.c = paramMotionViewSetter;
  }
  
  public void a(Object paramObject)
  {
    this.b = paramObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.BaseLocalFileAdapter
 * JD-Core Version:    0.7.0.1
 */