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
  private TCWDatePicker.OnDateChangedListener jdField_a_of_type_ComTencentWidgetTCWDatePicker$OnDateChangedListener;
  private final TCWNumberPicker jdField_a_of_type_ComTencentWidgetTCWNumberPicker;
  private final java.text.DateFormat jdField_a_of_type_JavaTextDateFormat = new SimpleDateFormat("MM/dd/yyyy");
  private Calendar jdField_a_of_type_JavaUtilCalendar;
  private Locale jdField_a_of_type_JavaUtilLocale;
  private final TCWNumberPicker jdField_b_of_type_ComTencentWidgetTCWNumberPicker;
  private Calendar jdField_b_of_type_JavaUtilCalendar;
  private final TCWNumberPicker jdField_c_of_type_ComTencentWidgetTCWNumberPicker;
  private Calendar jdField_c_of_type_JavaUtilCalendar;
  private Calendar d;
  
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
    a(Locale.getDefault());
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131559038, this, true);
    Object localObject1 = new TCWDatePicker.1(this);
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker = ((TCWNumberPicker)findViewById(2131365427));
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker.setFormatter(TCWNumberPicker.a);
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker.setSpeed(100L);
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker.setOnChangeListener((TCWNumberPicker.OnChangedListener)localObject1);
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPicker = ((TCWNumberPicker)findViewById(2131371454));
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPicker.setFormatter(TCWNumberPicker.a);
    Object localObject2 = new DateFormatSymbols();
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPicker.setRange(1, 12, ((DateFormatSymbols)localObject2).getShortMonths());
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPicker.setSpeed(200L);
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPicker.setOnChangeListener((TCWNumberPicker.OnChangedListener)localObject1);
    this.jdField_c_of_type_ComTencentWidgetTCWNumberPicker = ((TCWNumberPicker)findViewById(2131381304));
    this.jdField_c_of_type_ComTencentWidgetTCWNumberPicker.setSpeed(100L);
    this.jdField_c_of_type_ComTencentWidgetTCWNumberPicker.setOnChangeListener((TCWNumberPicker.OnChangedListener)localObject1);
    if (AppSetting.d)
    {
      localObject1 = (TCWNumberPickerButton)this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker.findViewById(2131368754);
      localObject2 = (TCWNumberPickerButton)this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker.findViewById(2131365457);
      ((TCWNumberPickerButton)localObject1).setContentDescription(getContext().getString(2131689598));
      ((TCWNumberPickerButton)localObject2).setContentDescription(getContext().getString(2131694186));
      localObject1 = (TCWNumberPickerButton)this.jdField_b_of_type_ComTencentWidgetTCWNumberPicker.findViewById(2131368754);
      localObject2 = (TCWNumberPickerButton)this.jdField_b_of_type_ComTencentWidgetTCWNumberPicker.findViewById(2131365457);
      ((TCWNumberPickerButton)localObject1).setContentDescription(getContext().getString(2131689623));
      ((TCWNumberPickerButton)localObject2).setContentDescription(getContext().getString(2131694187));
      localObject1 = (TCWNumberPickerButton)this.jdField_c_of_type_ComTencentWidgetTCWNumberPicker.findViewById(2131368754);
      localObject2 = (TCWNumberPickerButton)this.jdField_c_of_type_ComTencentWidgetTCWNumberPicker.findViewById(2131365457);
      ((TCWNumberPickerButton)localObject1).setContentDescription(getContext().getString(2131689658));
      ((TCWNumberPickerButton)localObject2).setContentDescription(getContext().getString(2131694188));
    }
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TCWDatePicker);
    paramInt = paramContext.getInt(3, 1900);
    int i = paramContext.getInt(0, 2100);
    paramAttributeSet = paramContext.getString(2);
    localObject1 = paramContext.getString(1);
    this.jdField_c_of_type_ComTencentWidgetTCWNumberPicker.setRange(paramInt, i);
    paramContext.recycle();
    this.jdField_b_of_type_JavaUtilCalendar.clear();
    if (!TextUtils.isEmpty(paramAttributeSet))
    {
      if (!a(paramAttributeSet, this.jdField_b_of_type_JavaUtilCalendar)) {
        this.jdField_b_of_type_JavaUtilCalendar.set(paramInt, 0, 1);
      }
    }
    else {
      this.jdField_b_of_type_JavaUtilCalendar.set(paramInt, 0, 1);
    }
    setMinDate(this.jdField_b_of_type_JavaUtilCalendar.getTimeInMillis());
    this.jdField_b_of_type_JavaUtilCalendar.clear();
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (!a((String)localObject1, this.jdField_b_of_type_JavaUtilCalendar)) {
        this.jdField_b_of_type_JavaUtilCalendar.set(i, 11, 31);
      }
    }
    else {
      this.jdField_b_of_type_JavaUtilCalendar.set(i, 11, 31);
    }
    setMaxDate(this.jdField_b_of_type_JavaUtilCalendar.getTimeInMillis());
    this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(System.currentTimeMillis());
    a(this.jdField_a_of_type_JavaUtilCalendar.get(1), this.jdField_a_of_type_JavaUtilCalendar.get(2), this.jdField_a_of_type_JavaUtilCalendar.get(5), null);
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
    int i = 0;
    if ((arrayOfChar[0] == 'M') && (arrayOfChar[1] == 'd')) {
      return;
    }
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131372316);
    localLinearLayout.removeAllViews();
    int j = arrayOfChar.length;
    while (i < j)
    {
      int k = arrayOfChar[i];
      if (k == 100) {
        localLinearLayout.addView(this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker);
      } else if (k == 77) {
        localLinearLayout.addView(this.jdField_b_of_type_ComTencentWidgetTCWNumberPicker);
      } else {
        localLinearLayout.addView(this.jdField_c_of_type_ComTencentWidgetTCWNumberPicker);
      }
      i += 1;
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaUtilCalendar.set(paramInt1, paramInt2, paramInt3);
    if (this.jdField_a_of_type_JavaUtilCalendar.before(this.jdField_c_of_type_JavaUtilCalendar))
    {
      this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(this.jdField_c_of_type_JavaUtilCalendar.getTimeInMillis());
      return;
    }
    if (this.jdField_a_of_type_JavaUtilCalendar.after(this.d)) {
      this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(this.d.getTimeInMillis());
    }
  }
  
  private void a(Locale paramLocale)
  {
    if (paramLocale.equals(this.jdField_a_of_type_JavaUtilLocale)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilLocale = paramLocale;
    this.jdField_b_of_type_JavaUtilCalendar = a(this.jdField_b_of_type_JavaUtilCalendar, paramLocale);
    this.jdField_c_of_type_JavaUtilCalendar = a(this.jdField_c_of_type_JavaUtilCalendar, paramLocale);
    this.d = a(this.d, paramLocale);
    this.jdField_a_of_type_JavaUtilCalendar = a(this.jdField_a_of_type_JavaUtilCalendar, paramLocale);
  }
  
  private boolean a(String paramString, Calendar paramCalendar)
  {
    try
    {
      paramCalendar.setTime(this.jdField_a_of_type_JavaTextDateFormat.parse(paramString));
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
    this.jdField_c_of_type_ComTencentWidgetTCWNumberPicker.setCurrent(this.jdField_a_of_type_JavaUtilCalendar.get(1));
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPicker.setCurrent(this.jdField_a_of_type_JavaUtilCalendar.get(2) + 1);
  }
  
  private void c()
  {
    int i = this.jdField_a_of_type_JavaUtilCalendar.getActualMaximum(5);
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker.setRange(1, i);
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker.setCurrent(this.jdField_a_of_type_JavaUtilCalendar.get(5));
  }
  
  private void d()
  {
    TCWDatePicker.OnDateChangedListener localOnDateChangedListener = this.jdField_a_of_type_ComTencentWidgetTCWDatePicker$OnDateChangedListener;
    if (localOnDateChangedListener != null) {
      localOnDateChangedListener.a(this, a(), b(), c());
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilCalendar.get(1);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, TCWDatePicker.OnDateChangedListener paramOnDateChangedListener)
  {
    a(paramInt1, paramInt2, paramInt3);
    this.jdField_a_of_type_ComTencentWidgetTCWDatePicker$OnDateChangedListener = paramOnDateChangedListener;
    b();
    d();
  }
  
  public int b()
  {
    return this.jdField_a_of_type_JavaUtilCalendar.get(2);
  }
  
  public int c()
  {
    return this.jdField_a_of_type_JavaUtilCalendar.get(5);
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
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
    return new TCWDatePicker.SavedState(super.onSaveInstanceState(), a(), b(), c(), null);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.jdField_a_of_type_ComTencentWidgetTCWNumberPicker.setEnabled(paramBoolean);
    this.jdField_b_of_type_ComTencentWidgetTCWNumberPicker.setEnabled(paramBoolean);
    this.jdField_c_of_type_ComTencentWidgetTCWNumberPicker.setEnabled(paramBoolean);
  }
  
  public void setMaxDate(long paramLong)
  {
    this.jdField_b_of_type_JavaUtilCalendar.setTimeInMillis(paramLong);
    if ((this.jdField_b_of_type_JavaUtilCalendar.get(1) == this.d.get(1)) && (this.jdField_b_of_type_JavaUtilCalendar.get(6) != this.d.get(6))) {
      return;
    }
    this.d.setTimeInMillis(paramLong);
    if (this.jdField_a_of_type_JavaUtilCalendar.after(this.d))
    {
      this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(this.d.getTimeInMillis());
      d();
    }
    b();
  }
  
  public void setMinDate(long paramLong)
  {
    this.jdField_b_of_type_JavaUtilCalendar.setTimeInMillis(paramLong);
    if ((this.jdField_b_of_type_JavaUtilCalendar.get(1) == this.jdField_c_of_type_JavaUtilCalendar.get(1)) && (this.jdField_b_of_type_JavaUtilCalendar.get(6) != this.jdField_c_of_type_JavaUtilCalendar.get(6))) {
      return;
    }
    this.jdField_c_of_type_JavaUtilCalendar.setTimeInMillis(paramLong);
    if (this.jdField_a_of_type_JavaUtilCalendar.before(this.jdField_c_of_type_JavaUtilCalendar))
    {
      this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(this.jdField_c_of_type_JavaUtilCalendar.getTimeInMillis());
      d();
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.TCWDatePicker
 * JD-Core Version:    0.7.0.1
 */