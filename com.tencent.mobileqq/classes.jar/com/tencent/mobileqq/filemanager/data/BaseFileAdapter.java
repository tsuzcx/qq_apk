package com.tencent.mobileqq.filemanager.data;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import com.tencent.mobileqq.widget.MotionViewSetter;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class BaseFileAdapter
  extends BaseAdapter
{
  private Context a;
  private View.OnClickListener b;
  private Object c;
  private MotionViewSetter d = null;
  
  public BaseFileAdapter(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    this.a = paramContext;
    this.b = paramOnClickListener;
  }
  
  public void a(MotionViewSetter paramMotionViewSetter)
  {
    this.d = paramMotionViewSetter;
  }
  
  public void a(Object paramObject)
  {
    this.c = paramObject;
  }
  
  public boolean a(int paramInt, View paramView, ShaderAnimLayout paramShaderAnimLayout, Button paramButton, Object paramObject)
  {
    if (paramShaderAnimLayout != null)
    {
      Object localObject = this.c;
      if ((localObject != null) && (localObject.equals(paramObject)))
      {
        paramShaderAnimLayout.a();
        paramShaderAnimLayout = this.d;
        if (paramShaderAnimLayout != null) {
          paramShaderAnimLayout.setMotionView(paramView, paramInt);
        }
        paramButton.setOnClickListener(this.b);
        paramButton.setTag(Integer.valueOf(paramInt));
        return true;
      }
      paramShaderAnimLayout.d();
      paramButton.setOnClickListener(null);
      paramButton.setTag(null);
    }
    return false;
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.BaseFileAdapter
 * JD-Core Version:    0.7.0.1
 */