package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import com.tencent.widget.VerticalGallery.OnSelectViewDataUpdateListener;

public class WheelPickerLayout
  extends LinearLayout
{
  private WheelPickerLayout.ViewStyle a;
  private int b = 0;
  private WheelView[] c;
  private WheelPickerLayout.InnerAdapter[] d;
  private WheelPickerLayout.WheelPickListener e;
  private WheelPickerLayout.PickerViewAdapter f;
  private AdapterView.OnItemSelectedListener g = new WheelPickerLayout.1(this);
  private VerticalGallery.OnSelectViewDataUpdateListener h = new WheelPickerLayout.2(this);
  
  public WheelPickerLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public WheelPickerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(View paramView, int paramInt)
  {
    if ((paramView instanceof WheelTextView))
    {
      if (paramInt == 0)
      {
        paramView = (WheelTextView)paramView;
        paramView.setTextSize(1, this.a.b);
        paramView.setTextColor(this.a.c);
        return;
      }
      paramView = (WheelTextView)paramView;
      paramView.setTextSize(1, this.a.e);
      paramView.setTextColor(this.a.f);
    }
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof WheelTextView))
    {
      paramView = (WheelTextView)paramView;
      paramView.setContentDescription(new StringBuilder(paramView.getText()));
    }
  }
  
  private void a(WheelView paramWheelView, int paramInt)
  {
    paramWheelView.setTag(Integer.valueOf(paramInt));
    WheelPickerLayout.InnerAdapter localInnerAdapter = new WheelPickerLayout.InnerAdapter(this, paramInt, this.a.a);
    this.c[paramInt] = paramWheelView;
    this.d[paramInt] = localInnerAdapter;
    paramWheelView.setAdapter(localInnerAdapter);
    paramWheelView.setOnItemSelectedListener(this.g);
    paramWheelView.setOnSelectViewDataUpdateListener(this.h);
    paramWheelView.setOnEndMovementListener(new WheelPickerLayout.EndMovementListener(this, paramInt));
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 0)
    {
      localObject = this.d;
      if (paramInt < localObject.length)
      {
        localObject[paramInt].notifyDataSetChanged();
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Error column index ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void a(WheelPickerLayout.PickerViewAdapter paramPickerViewAdapter, WheelPickerLayout.ViewStyle paramViewStyle)
  {
    this.a = paramViewStyle;
    if (paramViewStyle != null)
    {
      this.f = paramPickerViewAdapter;
      this.b = getChildCount();
      int i = this.b;
      if (i > 0)
      {
        this.c = new WheelView[i];
        this.d = new WheelPickerLayout.InnerAdapter[i];
        i = 0;
        while (i < this.b)
        {
          a((WheelView)getChildAt(i), i);
          i += 1;
        }
        return;
      }
      paramPickerViewAdapter = new StringBuilder();
      paramPickerViewAdapter.append("Unsupportted column count ");
      paramPickerViewAdapter.append(this.b);
      throw new RuntimeException(paramPickerViewAdapter.toString());
    }
    paramPickerViewAdapter = new RuntimeException("ViewStyle can not be null!");
    for (;;)
    {
      throw paramPickerViewAdapter;
    }
  }
  
  public int b(int paramInt)
  {
    if (paramInt >= 0)
    {
      localObject = this.c;
      if (paramInt < localObject.length) {
        return localObject[paramInt].getSelectedItemPosition();
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Error column index ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void setPickListener(WheelPickerLayout.WheelPickListener paramWheelPickListener)
  {
    this.e = paramWheelPickListener;
  }
  
  public void setSelection(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      localObject = this.c;
      if (paramInt1 < localObject.length)
      {
        localObject[paramInt1].setSelection(paramInt2, true);
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Error column index ");
    ((StringBuilder)localObject).append(paramInt1);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.WheelPickerLayout
 * JD-Core Version:    0.7.0.1
 */