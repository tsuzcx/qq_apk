package com.tencent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R.styleable;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TCWDatePicker
  extends FrameLayout
{
  private final java.text.DateFormat a = new SimpleDateFormat("MM/dd/yyyy");
  private final TCWNumberPicker b;
  private final TCWNumberPicker c;
  private final TCWNumberPicker d;
  private TCWDatePicker.OnDateChangedListener e;
  private Locale f;
  private Calendar g;
  private Calendar h;
  private Calendar i;
  private Calendar j;
  
  public TCWDatePicker(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TCWDatePicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TCWDatePicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setCurrentLocale(Locale.getDefault());
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131624672, this, true);
    Object localObject1 = new TCWDatePicker.1(this);
    this.b = ((TCWNumberPicker)findViewById(2131431631));
    this.b.setFormatter(TCWNumberPicker.a);
    this.b.setSpeed(100L);
    this.b.setOnChangeListener((TCWNumberPicker.OnChangedListener)localObject1);
    this.c = ((TCWNumberPicker)findViewById(2131438820));
    this.c.setFormatter(TCWNumberPicker.a);
    Object localObject2 = new DateFormatSymbols();
    this.c.setRange(1, 12, ((DateFormatSymbols)localObject2).getShortMonths());
    this.c.setSpeed(200L);
    this.c.setOnChangeListener((TCWNumberPicker.OnChangedListener)localObject1);
    this.d = ((TCWNumberPicker)findViewById(2131450356));
    this.d.setSpeed(100L);
    this.d.setOnChangeListener((TCWNumberPicker.OnChangedListener)localObject1);
    if (AppSetting.e)
    {
      localObject1 = (TCWNumberPickerButton)this.b.findViewById(2131435671);
      localObject2 = (TCWNumberPickerButton)this.b.findViewById(2131431670);
      ((TCWNumberPickerButton)localObject1).setContentDescription(getContext().getString(2131886208));
      ((TCWNumberPickerButton)localObject2).setContentDescription(getContext().getString(2131891823));
      localObject1 = (TCWNumberPickerButton)this.c.findViewById(2131435671);
      localObject2 = (TCWNumberPickerButton)this.c.findViewById(2131431670);
      ((TCWNumberPickerButton)localObject1).setContentDescription(getContext().getString(2131886234));
      ((TCWNumberPickerButton)localObject2).setContentDescription(getContext().getString(2131891824));
      localObject1 = (TCWNumberPickerButton)this.d.findViewById(2131435671);
      localObject2 = (TCWNumberPickerButton)this.d.findViewById(2131431670);
      ((TCWNumberPickerButton)localObject1).setContentDescription(getContext().getString(2131886269));
      ((TCWNumberPickerButton)localObject2).setContentDescription(getContext().getString(2131891825));
    }
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TCWDatePicker);
    paramInt = paramContext.getInt(3, 1900);
    int k = paramContext.getInt(0, 2100);
    paramAttributeSet = paramContext.getString(2);
    localObject1 = paramContext.getString(1);
    this.d.setRange(paramInt, k);
    paramContext.recycle();
    this.h.clear();
    if (!TextUtils.isEmpty(paramAttributeSet))
    {
      if (!a(paramAttributeSet, this.h)) {
        this.h.set(paramInt, 0, 1);
      }
    }
    else {
      this.h.set(paramInt, 0, 1);
    }
    setMinDate(this.h.getTimeInMillis());
    this.h.clear();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (!a((String)localObject1, this.h)) {
        this.h.set(k, 11, 31);
      }
    }
    else {
      this.h.set(k, 11, 31);
    }
    setMaxDate(this.h.getTimeInMillis());
    this.g.setTimeInMillis(System.currentTimeMillis());
    a(this.g.get(1), this.g.get(2), this.g.get(5), null);
    a();
    if (!isEnabled()) {
      setEnabled(false);
    }
  }
  
  private Calendar a(Calendar paramCalendar, Locale paramLocale)
  {
    if (paramCalendar == null) {
      return Calendar.getInstance(paramLocale);
    }
    long l = paramCalendar.getTimeInMillis();
    paramCalendar = Calendar.getInstance(paramLocale);
    paramCalendar.setTimeInMillis(l);
    return paramCalendar;
  }
  
  private void a()
  {
    char[] arrayOfChar = android.text.format.DateFormat.getDateFormatOrder(getContext());
    int k = 0;
    if ((arrayOfChar[0] == 'M') && (arrayOfChar[1] == 'd')) {
      return;
    }
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131439828);
    localLinearLayout.removeAllViews();
    int m = arrayOfChar.length;
    while (k < m)
    {
      int n = arrayOfChar[k];
      if (n == 100) {
        localLinearLayout.addView(this.b);
      } else if (n == 77) {
        localLinearLayout.addView(this.c);
      } else {
        localLinearLayout.addView(this.d);
      }
      k += 1;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.g.set(paramInt1, paramInt2, paramInt3);
    if (this.g.before(this.i))
    {
      this.g.setTimeInMillis(this.i.getTimeInMillis());
      return;
    }
    if (this.g.after(this.j)) {
      this.g.setTimeInMillis(this.j.getTimeInMillis());
    }
  }
  
  private boolean a(String paramString, Calendar paramCalendar)
  {
    try
    {
      paramCalendar.setTime(this.a.parse(paramString));
      return true;
    }
    catch (ParseException paramString)
    {
      label14:
      break label14;
    }
    return false;
  }
  
  private void b()
  {
    c();
    this.d.setCurrent(this.g.get(1));
    this.c.setCurrent(this.g.get(2) + 1);
  }
  
  private void c()
  {
    int k = this.g.getActualMaximum(5);
    this.b.setRange(1, k);
    this.b.setCurrent(this.g.get(5));
  }
  
  private void d()
  {
    TCWDatePicker.OnDateChangedListener localOnDateChangedListener = this.e;
    if (localOnDateChangedListener != null) {
      localOnDateChangedListener.a(this, getYear(), getMonth(), getDayOfMonth());
    }
  }
  
  private void setCurrentLocale(Locale paramLocale)
  {
    if (paramLocale.equals(this.f)) {
      return;
    }
    this.f = paramLocale;
    this.h = a(this.h, paramLocale);
    this.i = a(this.i, paramLocale);
    this.j = a(this.j, paramLocale);
    this.g = a(this.g, paramLocale);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, TCWDatePicker.OnDateChangedListener paramOnDateChangedListener)
  {
    a(paramInt1, paramInt2, paramInt3);
    this.e = paramOnDateChangedListener;
    b();
    d();
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  public int getDayOfMonth()
  {
    return this.g.get(5);
  }
  
  public int getMonth()
  {
    return this.g.get(2);
  }
  
  public int getYear()
  {
    return this.g.get(1);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (TCWDatePicker.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    a(TCWDatePicker.SavedState.a(paramParcelable), TCWDatePicker.SavedState.b(paramParcelable), TCWDatePicker.SavedState.c(paramParcelable));
    b();
    d();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    return new TCWDatePicker.SavedState(super.onSaveInstanceState(), getYear(), getMonth(), getDayOfMonth(), null);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.b.setEnabled(paramBoolean);
    this.c.setEnabled(paramBoolean);
    this.d.setEnabled(paramBoolean);
  }
  
  public void setMaxDate(long paramLong)
  {
    this.h.setTimeInMillis(paramLong);
    if ((this.h.get(1) == this.j.get(1)) && (this.h.get(6) != this.j.get(6))) {
      return;
    }
    this.j.setTimeInMillis(paramLong);
    if (this.g.after(this.j))
    {
      this.g.setTimeInMillis(this.j.getTimeInMillis());
      d();
    }
    b();
  }
  
  public void setMinDate(long paramLong)
  {
    this.h.setTimeInMillis(paramLong);
    if ((this.h.get(1) == this.i.get(1)) && (this.h.get(6) != this.i.get(6))) {
      return;
    }
    this.i.setTimeInMillis(paramLong);
    if (this.g.before(this.i))
    {
      this.g.setTimeInMillis(this.i.getTimeInMillis());
      d();
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.TCWDatePicker
 * JD-Core Version:    0.7.0.1
 */