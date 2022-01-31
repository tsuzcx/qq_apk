package com.tencent.mobileqq.widget.datepicker;

import ajya;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import bctc;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.security.InvalidParameterException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import vzl;

public class SimpleMonthView
  extends View
{
  protected static int a;
  protected static int b;
  protected static int c;
  protected static int d;
  protected static int e = 10;
  protected static int f;
  protected static int g;
  protected static int h;
  protected int A;
  protected int B = jdField_a_of_type_Int;
  protected int C;
  protected int D;
  int E = -16777216;
  int F = -15550475;
  int G = -1;
  int H = -4473925;
  int I = -394757;
  int J = 2131933173;
  int K;
  int L;
  int M;
  int N;
  int O;
  int P;
  int Q;
  private int R;
  private int S;
  private int T = 6;
  protected Paint a;
  final Time jdField_a_of_type_AndroidTextFormatTime = new Time(Time.getCurrentTimezone());
  private bctc jdField_a_of_type_Bctc;
  private CalendarDay jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay;
  protected Boolean a;
  private String jdField_a_of_type_JavaLangString;
  private DateFormatSymbols jdField_a_of_type_JavaTextDateFormatSymbols = new DateFormatSymbols();
  protected ArrayList<MessageRecord> a;
  private final Calendar jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
  protected boolean a;
  protected Paint b;
  private CalendarDay jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay;
  private final Boolean jdField_b_of_type_JavaLangBoolean;
  private String jdField_b_of_type_JavaLangString;
  private final Calendar jdField_b_of_type_JavaUtilCalendar = Calendar.getInstance();
  protected boolean b;
  protected Paint c;
  private boolean c;
  protected Paint d;
  protected int i;
  protected int j;
  protected int k;
  protected int l;
  protected int m;
  protected int n;
  protected int o;
  protected int p;
  protected int q = -1;
  protected int r = -1;
  protected int s = -1;
  protected int t = -1;
  protected int u = -1;
  protected int v = -1;
  protected int w = -1;
  protected int x = 1;
  protected int y = 7;
  protected int z = this.y;
  
  static
  {
    jdField_a_of_type_Int = 32;
    jdField_c_of_type_Int = 1;
  }
  
  public SimpleMonthView(Context paramContext, TypedArray paramTypedArray)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidTextFormatTime.setToNow();
    this.jdField_a_of_type_JavaLangString = "sans-serif";
    this.jdField_b_of_type_JavaLangString = "sans-serif";
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null))
    {
      this.E = -9004613;
      this.I = -16115667;
      this.H = -8947849;
    }
    this.j = paramTypedArray.getColor(1, this.E);
    this.k = paramTypedArray.getColor(3, this.F);
    this.l = paramTypedArray.getColor(2, this.E);
    this.m = paramTypedArray.getColor(4, this.E);
    this.o = paramTypedArray.getColor(5, this.E);
    this.p = paramTypedArray.getColor(6, this.F);
    this.n = paramTypedArray.getColor(7, this.G);
    this.K = vzl.a(paramContext, 16.0F);
    this.L = vzl.a(paramContext, 10.0F);
    this.M = vzl.a(paramContext, 50.0F);
    this.N = vzl.a(paramContext, 342.0F);
    this.O = vzl.a(paramContext, 12.5F);
    this.P = vzl.a(paramContext, 14.0F);
    this.Q = vzl.a(paramContext, 17.5F);
    jdField_d_of_type_Int = paramTypedArray.getDimensionPixelSize(15, this.K);
    h = paramTypedArray.getDimensionPixelSize(17, this.K);
    f = paramTypedArray.getDimensionPixelSize(16, this.L);
    g = paramTypedArray.getDimensionPixelOffset(12, this.M);
    jdField_b_of_type_Int = paramTypedArray.getDimensionPixelSize(14, this.Q);
    this.B = ((paramTypedArray.getDimensionPixelSize(0, this.N) - g) / 6);
    this.jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(paramTypedArray.getBoolean(10, true));
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramTypedArray.getBoolean(9, false));
    a();
  }
  
  private int a()
  {
    int i1 = b();
    int i2 = (this.z + i1) / this.y;
    if ((i1 + this.z) % this.y > 0) {}
    for (i1 = 1;; i1 = 0) {
      return i1 + i2;
    }
  }
  
  private String a()
  {
    long l1 = this.jdField_a_of_type_JavaUtilCalendar.getTimeInMillis();
    return DateUtils.formatDateRange(getContext(), l1, l1, 52);
  }
  
  private void a(CalendarDay paramCalendarDay)
  {
    int i1;
    MessageRecord localMessageRecord;
    if ((this.jdField_a_of_type_Bctc != null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && ((this.jdField_b_of_type_JavaLangBoolean.booleanValue()) || (paramCalendarDay.month != this.jdField_a_of_type_AndroidTextFormatTime.month) || (paramCalendarDay.year != this.jdField_a_of_type_AndroidTextFormatTime.year) || (paramCalendarDay.day >= this.jdField_a_of_type_AndroidTextFormatTime.monthDay)))
    {
      i1 = 0;
      if (i1 >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label136;
      }
      localMessageRecord = (MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (new CalendarDay(localMessageRecord.time * 1000L).day != paramCalendarDay.day) {
        break label129;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bctc.a(this, paramCalendarDay, localMessageRecord);
      return;
      label129:
      i1 += 1;
      break;
      label136:
      localMessageRecord = null;
    }
  }
  
  private boolean a(int paramInt, Time paramTime)
  {
    return (this.D < paramTime.year) || ((this.D == paramTime.year) && (this.A < paramTime.month)) || ((this.A == paramTime.month) && (paramInt < paramTime.monthDay));
  }
  
  private int b()
  {
    if (this.R < this.x) {}
    for (int i1 = this.R + this.y;; i1 = this.R) {
      return i1 - this.x;
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    int i1 = ((this.C - this.i * 2) / this.y - f) / 2;
    int i4 = h + this.P;
    paramCanvas.drawText(a(), i1, i4, this.jdField_c_of_type_AndroidGraphicsPaint);
    int i2 = this.C;
    int i3 = this.i;
    i4 = i4 + this.O + 6;
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-2171170);
    paramCanvas.drawLine(i1, i4, i3 * 2 + i2, i4, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  public CalendarDay a(float paramFloat1, float paramFloat2)
  {
    int i1 = this.i;
    if ((paramFloat1 < i1) || (paramFloat1 > this.C - this.i)) {}
    do
    {
      return null;
      int i2 = (int)(paramFloat2 - g) / this.B;
      i1 = (int)((paramFloat1 - i1) * this.y / (this.C - i1 - this.i)) - b() + 1 + i2 * this.y;
    } while ((this.A > 11) || (this.A < 0) || (CalendarDay.getDaysInMonth(this.D, this.A) < i1) || (i1 < 1));
    return new CalendarDay(this.D, this.A, i1);
  }
  
  protected void a()
  {
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint.setFakeBoldText(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setTextSize(h);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.k);
    this.jdField_c_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.LEFT);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_d_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_d_of_type_AndroidGraphicsPaint.setFakeBoldText(true);
    this.jdField_d_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_d_of_type_AndroidGraphicsPaint.setColor(this.p);
    this.jdField_d_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_d_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_d_of_type_AndroidGraphicsPaint.setTextSize(this.O);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(f);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.l);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(Typeface.create(this.jdField_a_of_type_JavaLangString, 0));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFakeBoldText(true);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setFakeBoldText(false);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(jdField_d_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
  }
  
  protected void a(Canvas paramCanvas)
  {
    int i2 = (this.B + jdField_d_of_type_Int) / 2 - jdField_c_of_type_Int + g;
    int i8 = (this.C - this.i * 2) / (this.y * 2);
    int i6 = b();
    int i1;
    int i4;
    label88:
    int i5;
    label91:
    label107:
    Object localObject;
    int i3;
    if ((this.D == this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.year) && (this.A == this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.month))
    {
      i1 = 1;
      if (i1 == 0) {
        break label622;
      }
      i4 = this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.day;
      i5 = 1;
      if (i5 > i4) {
        break label841;
      }
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        break label856;
      }
      i1 = 0;
      if (i1 >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
        break label856;
      }
      localObject = (MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if (new CalendarDay(((MessageRecord)localObject).time * 1000L).day != i5) {
        break label631;
      }
      if (!QLog.isColorLevel()) {
        break label850;
      }
      QLog.d("DatePickerView", 2, "hasMessage : " + this.D + "-" + (this.A + 1) + "-" + i5 + " , MessageRecord:" + localObject);
      i3 = 1;
    }
    for (;;)
    {
      int i9 = (i6 * 2 + 1) * i8 + this.i;
      label274:
      int i7;
      if (this.S == i5)
      {
        localObject = this.jdField_d_of_type_AndroidGraphicsPaint;
        if (this.jdField_c_of_type_Boolean)
        {
          i1 = this.J;
          ((Paint)localObject).setColor(i1);
          paramCanvas.drawCircle(i9, i2 - jdField_d_of_type_Int / 3, jdField_b_of_type_Int, this.jdField_d_of_type_AndroidGraphicsPaint);
        }
      }
      else
      {
        if (((this.A != this.s) || (this.q != i5) || (this.u != this.D)) && ((this.A != this.t) || (this.r != i5) || (this.v != this.D))) {
          break label646;
        }
        i7 = 1;
        label368:
        if (i7 != 0)
        {
          localObject = this.jdField_d_of_type_AndroidGraphicsPaint;
          if (i3 == 0) {
            break label652;
          }
          i1 = this.p;
          ((Paint)localObject).setColor(i1);
          if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
            break label668;
          }
          paramCanvas.drawRoundRect(new RectF(i9 - jdField_b_of_type_Int, i2 - jdField_d_of_type_Int / 3 - jdField_b_of_type_Int, jdField_b_of_type_Int + i9, i2 - jdField_d_of_type_Int / 3 + jdField_b_of_type_Int), 10.0F, 10.0F, this.jdField_d_of_type_AndroidGraphicsPaint);
        }
        label389:
        label462:
        if ((!this.jdField_a_of_type_Boolean) || (this.w != i5)) {
          break label731;
        }
        this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.j);
        if (i7 == 0) {
          break label710;
        }
        if (i3 == 0) {
          break label694;
        }
        i1 = this.p;
        label504:
        this.jdField_d_of_type_AndroidGraphicsPaint.setColor(i1);
        paramCanvas.drawText(ajya.a(2131714173), i9, jdField_b_of_type_Int + i2 + jdField_d_of_type_Int / 2, this.jdField_d_of_type_AndroidGraphicsPaint);
        label541:
        if (i7 == 0) {
          break label745;
        }
        this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.n);
        label557:
        paramCanvas.drawText(Integer.toString(i5), i9, i2, this.jdField_b_of_type_AndroidGraphicsPaint);
        i3 = i6 + 1;
        if (i3 != this.y) {
          break label842;
        }
        i3 = 0;
        i1 = this.B + i2;
      }
      for (i2 = i3;; i2 = i3)
      {
        i5 += 1;
        i6 = i2;
        i2 = i1;
        break label91;
        i1 = 0;
        break;
        label622:
        i4 = this.z;
        break label88;
        label631:
        i1 += 1;
        break label107;
        i1 = this.I;
        break label274;
        label646:
        i7 = 0;
        break label368;
        label652:
        i1 = this.p & 0xFFFFFF | 0x7F000000;
        break label389;
        label668:
        paramCanvas.drawCircle(i9, i2 - jdField_d_of_type_Int / 3, jdField_b_of_type_Int, this.jdField_d_of_type_AndroidGraphicsPaint);
        break label462;
        label694:
        i1 = this.p & 0xFFFFFF | 0x7F000000;
        break label504;
        label710:
        if (i3 != 0)
        {
          i1 = this.m;
          break label504;
        }
        i1 = this.H;
        break label504;
        label731:
        this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.m);
        break label541;
        label745:
        if (i3 == 0)
        {
          this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.H);
          break label557;
        }
        if ((this.jdField_b_of_type_JavaLangBoolean.booleanValue()) || (!a(i5, this.jdField_a_of_type_AndroidTextFormatTime)) || (this.jdField_a_of_type_AndroidTextFormatTime.month != this.A) || (this.jdField_a_of_type_AndroidTextFormatTime.year != this.D)) {
          break label557;
        }
        this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.o);
        this.jdField_b_of_type_AndroidGraphicsPaint.setTypeface(Typeface.defaultFromStyle(2));
        break label557;
        label841:
        return;
        label842:
        i1 = i2;
      }
      label850:
      i3 = 1;
      continue;
      label856:
      i3 = 0;
    }
  }
  
  public void b()
  {
    this.T = 6;
    requestLayout();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    b(paramCanvas);
    a(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), this.B * this.T + g + this.L);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.C = paramInt1;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      CalendarDay localCalendarDay = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (localCalendarDay != null)
      {
        this.jdField_c_of_type_Boolean = true;
        this.S = localCalendarDay.day;
        invalidate();
      }
    }
    for (;;)
    {
      if (paramMotionEvent.getAction() == 1)
      {
        paramMotionEvent = a(paramMotionEvent.getX(), paramMotionEvent.getY());
        if (paramMotionEvent != null) {
          a(paramMotionEvent);
        }
      }
      return true;
      if ((this.jdField_c_of_type_Boolean) && (paramMotionEvent.getAction() != 2))
      {
        this.jdField_c_of_type_Boolean = false;
        invalidate();
      }
    }
  }
  
  public void setMessageRecords(ArrayList<MessageRecord> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void setMonthParams(HashMap<String, Integer> paramHashMap)
  {
    int i1 = 0;
    if ((!paramHashMap.containsKey("month")) && (!paramHashMap.containsKey("year"))) {
      throw new InvalidParameterException("You must specify month and year for this view");
    }
    setTag(paramHashMap);
    if (paramHashMap.containsKey("height"))
    {
      this.B = ((Integer)paramHashMap.get("height")).intValue();
      if (this.B < e) {
        this.B = e;
      }
    }
    if (paramHashMap.containsKey("selected_begin_day")) {
      this.q = ((Integer)paramHashMap.get("selected_begin_day")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_day")) {
      this.r = ((Integer)paramHashMap.get("selected_last_day")).intValue();
    }
    if (paramHashMap.containsKey("selected_begin_month")) {
      this.s = ((Integer)paramHashMap.get("selected_begin_month")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_month")) {
      this.t = ((Integer)paramHashMap.get("selected_last_month")).intValue();
    }
    if (paramHashMap.containsKey("selected_begin_year")) {
      this.u = ((Integer)paramHashMap.get("selected_begin_year")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_year")) {
      this.v = ((Integer)paramHashMap.get("selected_last_year")).intValue();
    }
    this.A = ((Integer)paramHashMap.get("month")).intValue();
    this.D = ((Integer)paramHashMap.get("year")).intValue();
    this.jdField_a_of_type_Boolean = false;
    this.w = -1;
    this.jdField_a_of_type_JavaUtilCalendar.set(2, this.A);
    this.jdField_a_of_type_JavaUtilCalendar.set(1, this.D);
    this.jdField_a_of_type_JavaUtilCalendar.set(5, 1);
    this.R = this.jdField_a_of_type_JavaUtilCalendar.get(7);
    if (paramHashMap.containsKey("week_start")) {}
    int i2;
    for (this.x = ((Integer)paramHashMap.get("week_start")).intValue();; this.x = this.jdField_a_of_type_JavaUtilCalendar.getFirstDayOfWeek())
    {
      i2 = CalendarDay.getDaysInMonth(this.D, this.A);
      while (i1 < i2)
      {
        int i3 = i1 + 1;
        if ((this.D == this.jdField_a_of_type_AndroidTextFormatTime.year) && (this.A == this.jdField_a_of_type_AndroidTextFormatTime.month) && (i3 == this.jdField_a_of_type_AndroidTextFormatTime.monthDay))
        {
          this.jdField_a_of_type_Boolean = true;
          this.w = i3;
        }
        this.jdField_b_of_type_Boolean = a(i3, this.jdField_a_of_type_AndroidTextFormatTime);
        i1 += 1;
      }
    }
    i1 = i2;
    if (this.jdField_a_of_type_Boolean) {
      i1 = this.w;
    }
    this.z = i1;
    this.T = a();
  }
  
  public void setOnDayClickListener(bctc parambctc)
  {
    this.jdField_a_of_type_Bctc = parambctc;
  }
  
  public void setStartAndEndDate(CalendarDay paramCalendarDay1, CalendarDay paramCalendarDay2)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = paramCalendarDay1;
    this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay = paramCalendarDay2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.datepicker.SimpleMonthView
 * JD-Core Version:    0.7.0.1
 */