package com.tencent.widget;

import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class TCWNumberPicker
  extends LinearLayout
  implements View.OnClickListener, View.OnFocusChangeListener, View.OnLongClickListener
{
  public static final TCWNumberPicker.Formatter a = new TCWNumberPicker.1();
  private static final char[] p = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57 };
  private final Handler b;
  private final Runnable c = new TCWNumberPicker.AutoIncDecRunnable(this);
  private final EditText d;
  private final InputFilter e;
  private String[] f;
  private int g;
  private int h;
  private int i;
  private int j;
  private TCWNumberPicker.OnChangedListener k;
  private TCWNumberPicker.Formatter l;
  private long m = 300L;
  private boolean n;
  private boolean o;
  private TCWNumberPickerButton q;
  private TCWNumberPickerButton r;
  
  public TCWNumberPicker(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TCWNumberPicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TCWNumberPicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131625549, this, true);
    this.b = new Handler();
    paramContext = new TCWNumberPicker.NumberPickerInputFilter(this, null);
    this.e = new TCWNumberPicker.NumberRangeKeyListener(this, null);
    this.q = ((TCWNumberPickerButton)findViewById(2131435671));
    this.q.setOnClickListener(this);
    this.q.setOnLongClickListener(this);
    this.q.setNumberPicker(this);
    this.r = ((TCWNumberPickerButton)findViewById(2131431670));
    this.r.setOnClickListener(this);
    this.r.setOnLongClickListener(this);
    this.r.setNumberPicker(this);
    this.d = ((EditText)findViewById(2131447399));
    this.d.setOnFocusChangeListener(this);
    this.d.setFilters(new InputFilter[] { paramContext });
    this.d.setRawInputType(2);
    if (!isEnabled()) {
      setEnabled(false);
    }
  }
  
  private int a(String paramString)
  {
    if (this.f == null) {}
    try
    {
      i1 = Integer.parseInt(paramString);
      return i1;
    }
    catch (NumberFormatException paramString)
    {
      int i1;
      break label67;
    }
    i1 = 0;
    while (i1 < this.f.length)
    {
      paramString = paramString.toLowerCase();
      if (this.f[i1].toLowerCase().startsWith(paramString)) {
        return this.g + i1;
      }
      i1 += 1;
    }
    i1 = Integer.parseInt(paramString);
    return i1;
    label67:
    return this.g;
  }
  
  private String a(int paramInt)
  {
    TCWNumberPicker.Formatter localFormatter = this.l;
    if (localFormatter != null) {
      return localFormatter.a(paramInt);
    }
    return String.valueOf(paramInt);
  }
  
  private void a(View paramView)
  {
    paramView = String.valueOf(((TextView)paramView).getText());
    if ("".equals(paramView))
    {
      e();
      return;
    }
    a(paramView);
  }
  
  private void a(CharSequence paramCharSequence)
  {
    int i1 = a(paramCharSequence.toString());
    if ((i1 >= this.g) && (i1 <= this.h))
    {
      this.j = this.i;
      this.i = i1;
      d();
    }
    e();
  }
  
  private void a(Runnable paramRunnable)
  {
    if (this.n)
    {
      b(this.i + 1);
      this.b.postDelayed(paramRunnable, this.m);
      return;
    }
    if (this.o)
    {
      b(this.i - 1);
      this.b.postDelayed(paramRunnable, this.m);
    }
  }
  
  private void b(int paramInt)
  {
    int i2 = this.h;
    int i1;
    if (paramInt > i2)
    {
      i1 = this.g;
    }
    else
    {
      i1 = paramInt;
      if (paramInt < this.g) {
        i1 = i2;
      }
    }
    this.j = this.i;
    this.i = i1;
    d();
    e();
  }
  
  private void d()
  {
    TCWNumberPicker.OnChangedListener localOnChangedListener = this.k;
    if (localOnChangedListener != null) {
      localOnChangedListener.a(this, this.j, this.i);
    }
  }
  
  private void e()
  {
    Object localObject = this.f;
    if (localObject == null) {
      this.d.setText(a(this.i));
    } else {
      this.d.setText(localObject[(this.i - this.g)]);
    }
    localObject = this.d;
    ((EditText)localObject).setSelection(((EditText)localObject).getText().length());
  }
  
  public void a()
  {
    this.n = false;
  }
  
  public void b()
  {
    this.o = false;
  }
  
  public int getCurrent()
  {
    return this.i;
  }
  
  public void onClick(View paramView)
  {
    a(this.d);
    if (!this.d.hasFocus()) {
      this.d.requestFocus();
    }
    if (2131435671 == paramView.getId()) {
      b(this.i + 1);
    } else if (2131431670 == paramView.getId()) {
      b(this.i - 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean) {
      a(paramView);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    this.d.clearFocus();
    if (2131435671 == paramView.getId())
    {
      this.n = true;
      this.b.post(this.c);
      return true;
    }
    if (2131431670 == paramView.getId())
    {
      this.o = true;
      this.b.post(this.c);
    }
    return true;
  }
  
  public void setCurrent(int paramInt)
  {
    this.i = paramInt;
    e();
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.q.setEnabled(paramBoolean);
    this.r.setEnabled(paramBoolean);
    this.d.setEnabled(paramBoolean);
  }
  
  public void setFormatter(TCWNumberPicker.Formatter paramFormatter)
  {
    this.l = paramFormatter;
  }
  
  public void setOnChangeListener(TCWNumberPicker.OnChangedListener paramOnChangedListener)
  {
    this.k = paramOnChangedListener;
  }
  
  public void setRange(int paramInt1, int paramInt2)
  {
    this.g = paramInt1;
    this.h = paramInt2;
    this.i = paramInt1;
    e();
  }
  
  public void setRange(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    this.f = paramArrayOfString;
    this.g = paramInt1;
    this.h = paramInt2;
    this.i = paramInt1;
    e();
  }
  
  public void setSpeed(long paramLong)
  {
    this.m = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.TCWNumberPicker
 * JD-Core Version:    0.7.0.1
 */