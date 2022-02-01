package com.tencent.mobileqq.conditionsearch.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import com.tencent.widget.VerticalGallery.OnSelectViewDataUpdateListener;

public class IphonePickerView
  extends LinearLayout
{
  public static int a = -7829368;
  private static int b = -12303292;
  private int c = 0;
  private Button d;
  private TextView e;
  private WheelView[] f;
  private IphonePickerView.InnerAdapter[] g;
  private IphonePickerView.IphonePickListener h;
  private IphonePickerView.PickerViewAdapter i;
  private AdapterView.OnItemSelectedListener j = new IphonePickerView.2(this);
  private VerticalGallery.OnSelectViewDataUpdateListener k = new IphonePickerView.3(this);
  
  public IphonePickerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public IphonePickerView(Context paramContext, AttributeSet paramAttributeSet)
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
      paramView.setTextColor(b);
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
    IphonePickerView.InnerAdapter localInnerAdapter = new IphonePickerView.InnerAdapter(this, paramInt, 25);
    this.f[paramInt] = paramWheelView;
    this.g[paramInt] = localInnerAdapter;
    paramWheelView.setAdapter(localInnerAdapter);
    paramWheelView.setOnItemSelectedListener(this.j);
    paramWheelView.setOnSelectViewDataUpdateListener(this.k);
    paramWheelView.setOnEndMovementListener(new IphonePickerView.EndMovementListener(this, paramInt));
  }
  
  public void a()
  {
    findViewById(2131447592).setVisibility(8);
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 0)
    {
      localObject = this.g;
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
  
  public void a(IphonePickerView.PickerViewAdapter paramPickerViewAdapter)
  {
    Object localObject1 = getContext().getResources();
    a = ((Resources)localObject1).getColor(2131168129);
    b = ((Resources)localObject1).getColor(2131168054);
    setBackgroundColor(((Resources)localObject1).getColor(2131168077));
    Object localObject2 = findViewById(2131447375);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131168144));
    }
    localObject2 = findViewById(2131447376);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131168144));
    }
    localObject2 = findViewById(2131437231);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131168143));
    }
    localObject2 = findViewById(2131437214);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131168143));
    }
    this.i = paramPickerViewAdapter;
    this.c = this.i.getColumnCount();
    int m = this.c;
    if ((m > 0) && (m <= 3))
    {
      this.f = new WheelView[m];
      this.g = new IphonePickerView.InnerAdapter[m];
      paramPickerViewAdapter = (WheelView)findViewById(2131431635);
      localObject1 = (WheelView)findViewById(2131435192);
      localObject2 = (WheelView)findViewById(2131438752);
      this.d = ((Button)findViewById(2131447373));
      this.e = ((TextView)findViewById(2131447416));
      Button localButton = this.d;
      if (localButton != null) {
        localButton.setOnClickListener(new IphonePickerView.1(this));
      }
      a(paramPickerViewAdapter, 0);
      if (this.c < 2)
      {
        ((WheelView)localObject1).setVisibility(8);
      }
      else
      {
        ((WheelView)localObject1).setVisibility(0);
        a((WheelView)localObject1, 1);
      }
      if (this.c < 3)
      {
        ((WheelView)localObject2).setVisibility(8);
        return;
      }
      ((WheelView)localObject2).setVisibility(0);
      a((WheelView)localObject2, 2);
      return;
    }
    paramPickerViewAdapter = new StringBuilder();
    paramPickerViewAdapter.append("Unsupportted column count ");
    paramPickerViewAdapter.append(this.c);
    throw new RuntimeException(paramPickerViewAdapter.toString());
  }
  
  public int b(int paramInt)
  {
    if (paramInt >= 0)
    {
      localObject = this.f;
      if (paramInt < localObject.length) {
        return localObject[paramInt].getSelectedItemPosition();
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Error column index ");
    ((StringBuilder)localObject).append(paramInt);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void setPickListener(IphonePickerView.IphonePickListener paramIphonePickListener)
  {
    this.h = paramIphonePickListener;
  }
  
  public void setSelection(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      localObject = this.f;
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
  
  public void setTips(int paramInt)
  {
    this.e.setText(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.widget.IphonePickerView
 * JD-Core Version:    0.7.0.1
 */