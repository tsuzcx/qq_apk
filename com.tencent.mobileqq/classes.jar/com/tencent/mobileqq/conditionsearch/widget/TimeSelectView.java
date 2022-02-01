package com.tencent.mobileqq.conditionsearch.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import com.tencent.widget.VerticalGallery.OnSelectViewDataUpdateListener;

public class TimeSelectView
  extends LinearLayout
{
  public static int a = -7829368;
  private static int c = -12303292;
  Vibrator b;
  private int d = 0;
  private Button e;
  private Button f;
  private Button g;
  private WheelView[] h;
  private TimeSelectView.InnerAdapter[] i;
  private TimeSelectView.IphonePickListener j;
  private TimeSelectView.PickerViewAdapter k;
  private boolean l;
  private AdapterView.OnItemSelectedListener m = new TimeSelectView.5(this);
  private VerticalGallery.OnSelectViewDataUpdateListener n = new TimeSelectView.6(this);
  
  public TimeSelectView(Context paramContext)
  {
    super(paramContext);
  }
  
  public TimeSelectView(Context paramContext, AttributeSet paramAttributeSet)
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
        paramView.setTextSize(20.0F);
        paramView.setTextColor(a);
        return;
      }
      paramView = (WheelTextView)paramView;
      paramView.setTextSize(20.0F);
      paramView.setTextColor(c);
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
    TimeSelectView.InnerAdapter localInnerAdapter = new TimeSelectView.InnerAdapter(this, paramInt, 25);
    this.h[paramInt] = paramWheelView;
    this.i[paramInt] = localInnerAdapter;
    paramWheelView.setAdapter(localInnerAdapter);
    paramWheelView.setOnItemSelectedListener(this.m);
    paramWheelView.setOnSelectViewDataUpdateListener(this.n);
    paramWheelView.setOnEndMovementListener(new TimeSelectView.EndMovementListener(this, paramInt));
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 0)
    {
      localObject = this.i;
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
  
  @SuppressLint({"ClickableViewAccessibility"})
  public void a(TimeSelectView.PickerViewAdapter paramPickerViewAdapter)
  {
    Object localObject1 = getContext().getResources();
    a = ((Resources)localObject1).getColor(2131168129);
    c = ((Resources)localObject1).getColor(2131168054);
    Object localObject2 = findViewById(2131447376);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131168148));
    }
    localObject2 = findViewById(2131437231);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131168148));
    }
    localObject2 = findViewById(2131437214);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131168148));
    }
    this.k = paramPickerViewAdapter;
    this.d = this.k.a();
    int i1 = this.d;
    if ((i1 > 0) && (i1 <= 2))
    {
      this.h = new WheelView[i1];
      this.i = new TimeSelectView.InnerAdapter[i1];
      this.b = ((Vibrator)getContext().getSystemService("vibrator"));
      paramPickerViewAdapter = (WheelView)findViewById(2131433215);
      localObject1 = (WheelView)findViewById(2131445486);
      this.e = ((Button)findViewById(2131447373));
      this.f = ((Button)findViewById(2131447372));
      this.g = ((Button)findViewById(2131447374));
      localObject2 = this.e;
      if (localObject2 != null)
      {
        ((Button)localObject2).setOnClickListener(new TimeSelectView.1(this));
        this.e.setOnTouchListener(new TimeSelectView.2(this));
      }
      localObject2 = this.f;
      if (localObject2 != null) {
        ((Button)localObject2).setOnClickListener(new TimeSelectView.3(this));
      }
      localObject2 = this.g;
      if (localObject2 != null) {
        ((Button)localObject2).setOnClickListener(new TimeSelectView.4(this));
      }
      a(paramPickerViewAdapter, 0);
      paramPickerViewAdapter.setNeedTranslateCenter(true);
      paramPickerViewAdapter.setNeedTranslateCenterToRight(true);
      if (this.d < 2)
      {
        ((WheelView)localObject1).setVisibility(8);
        return;
      }
      ((WheelView)localObject1).setVisibility(0);
      a((WheelView)localObject1, 1);
      ((WheelView)localObject1).setNeedTranslateCenter(true);
      return;
    }
    paramPickerViewAdapter = new StringBuilder();
    paramPickerViewAdapter.append("Unsupportted column count ");
    paramPickerViewAdapter.append(this.d);
    throw new RuntimeException(paramPickerViewAdapter.toString());
  }
  
  public int b(int paramInt)
  {
    if (paramInt >= 0)
    {
      localObject = this.h;
      if (paramInt < localObject.length) {
        return localObject[paramInt].getSelectedItemPosition();
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Error column index ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void setPickListener(TimeSelectView.IphonePickListener paramIphonePickListener)
  {
    this.j = paramIphonePickListener;
  }
  
  public void setSelection(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      localObject = this.h;
      if (paramInt1 < localObject.length)
      {
        this.l = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.widget.TimeSelectView
 * JD-Core Version:    0.7.0.1
 */