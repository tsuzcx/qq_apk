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
  private int jdField_a_of_type_Int = 25;
  private Context jdField_a_of_type_AndroidContentContext;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = null;
  private int b;
  private int c;
  
  public NumberAdapter(Context paramContext, String[] paramArrayOfString, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = ((int)TypedValue.applyDimension(1, paramInt, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()));
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    paramContext = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.b = paramContext.getColor(2131167123);
    this.c = paramContext.getColor(2131167093);
  }
  
  public View a(int paramInt)
  {
    return getView(paramInt, null, null);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null) {
      return this.jdField_a_of_type_ArrayOfJavaLangString.length;
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramView == null)
    {
      localObject1 = new WheelTextView(this.jdField_a_of_type_AndroidContentContext);
      ((View)localObject1).setLayoutParams(new VerticalGallery.LayoutParams(-1, this.jdField_a_of_type_Int));
    }
    for (paramView = (WheelTextView)localObject1;; paramView = (View)localObject2)
    {
      String str = this.jdField_a_of_type_ArrayOfJavaLangString[paramInt];
      localObject2 = paramView;
      if (paramView == null) {
        localObject2 = (WheelTextView)localObject1;
      }
      ((WheelTextView)localObject2).setTextSize(20.0F);
      ((WheelTextView)localObject2).setTextColor(this.b);
      ((WheelTextView)localObject2).setGravity(17);
      ((WheelTextView)localObject2).setText(str);
      ((WheelTextView)localObject2).setBackgroundColor(this.c);
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
      return localObject1;
      localObject1 = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.remind.NumberAdapter
 * JD-Core Version:    0.7.0.1
 */