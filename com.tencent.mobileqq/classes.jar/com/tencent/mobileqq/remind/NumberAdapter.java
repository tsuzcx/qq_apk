package com.tencent.mobileqq.remind;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.VerticalGallery.LayoutParams;

public class NumberAdapter
  extends BaseAdapter
{
  private Context a;
  private int b = 25;
  private String[] c = null;
  private int d;
  private int e;
  
  public NumberAdapter(Context paramContext, String[] paramArrayOfString, int paramInt)
  {
    this.a = paramContext;
    this.b = ((int)TypedValue.applyDimension(1, paramInt, this.a.getResources().getDisplayMetrics()));
    this.c = paramArrayOfString;
    paramContext = this.a.getResources();
    this.d = paramContext.getColor(2131168129);
    this.e = paramContext.getColor(2131168094);
  }
  
  public View a(int paramInt)
  {
    return getView(paramInt, null, null);
  }
  
  public int getCount()
  {
    String[] arrayOfString = this.c;
    if (arrayOfString != null) {
      return arrayOfString.length;
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject1;
    if (paramView == null)
    {
      localObject1 = new WheelTextView(this.a);
      ((View)localObject1).setLayoutParams(new VerticalGallery.LayoutParams(-1, this.b));
      paramView = (WheelTextView)localObject1;
    }
    else
    {
      localObject2 = null;
      localObject1 = paramView;
      paramView = (View)localObject2;
    }
    String str = this.c[paramInt];
    Object localObject2 = paramView;
    if (paramView == null) {
      localObject2 = (WheelTextView)localObject1;
    }
    ((WheelTextView)localObject2).setTextSize(20.0F);
    ((WheelTextView)localObject2).setTextColor(this.d);
    ((WheelTextView)localObject2).setGravity(17);
    ((WheelTextView)localObject2).setText(str);
    ((WheelTextView)localObject2).setBackgroundColor(this.e);
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.remind.NumberAdapter
 * JD-Core Version:    0.7.0.1
 */