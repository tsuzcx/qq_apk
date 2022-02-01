package com.tencent.mobileqq.widget.datepicker;

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
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.security.InvalidParameterException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class SimpleMonthView
  extends View
{
  protected static int a = 32;
  protected static int b = 0;
  protected static int c = 1;
  protected static int d = 0;
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
  private int R = 0;
  private int S = 0;
  private int T = 6;
  protected Paint a;
  final Time jdField_a_of_type_AndroidTextFormatTime = new Time(Time.getCurrentTimezone());
  private CalendarDay jdField_a_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay;
  private SimpleMonthView.OnDayClickListener jdField_a_of_type_ComTencentMobileqqWidgetDatepickerSimpleMonthView$OnDayClickListener;
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
  protected int i = 0;
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
  
  public SimpleMonthView(Context paramContext, TypedArray paramTypedArray)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
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
    this.K = UIUtils.a(paramContext, 16.0F);
    this.L = UIUtils.a(paramContext, 10.0F);
    this.M = UIUtils.a(paramContext, 50.0F);
    this.N = UIUtils.a(paramContext, 342.0F);
    this.O = UIUtils.a(paramContext, 12.5F);
    this.P = UIUtils.a(paramContext, 14.0F);
    this.Q = UIUtils.a(paramContext, 17.5F);
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
    int i3 = this.z;
    int i4 = this.y;
    int i2 = (i1 + i3) / i4;
    if ((i1 + i3) % i4 > 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    return i2 + i1;
  }
  
  private String a()
  {
    long l1 = this.jdField_a_of_type_JavaUtilCalendar.getTimeInMillis();
    return DateUtils.formatDateRange(getContext(), l1, l1, 52);
  }
  
  private void a(CalendarDay paramCalendarDay)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerSimpleMonthView$OnDayClickListener != null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && ((this.jdField_b_of_type_JavaLangBoolean.booleanValue()) || (paramCalendarDay.month != this.jdField_a_of_type_AndroidTextFormatTime.month) || (paramCalendarDay.year != this.jdField_a_of_type_AndroidTextFormatTime.year) || (paramCalendarDay.day >= this.jdField_a_of_type_AndroidTextFormatTime.monthDay)))
    {
      Object localObject2 = null;
      int i1 = 0;
      Object localObject1;
      for (;;)
      {
        localObject1 = localObject2;
        if (i1 >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break;
        }
        localObject1 = (MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
        if (new CalendarDay(((MessageRecord)localObject1).time * 1000L).day == paramCalendarDay.day) {
          break;
        }
        i1 += 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerSimpleMonthView$OnDayClickListener.a(this, paramCalendarDay, localObject1);
    }
  }
  
  private boolean a(int paramInt, Time paramTime)
  {
    return (this.D < paramTime.year) || ((this.D == paramTime.year) && (this.A < paramTime.month)) || ((this.A == paramTime.month) && (paramInt < paramTime.monthDay));
  }
  
  private int b()
  {
    int i2 = this.R;
    int i1 = i2;
    if (i2 < this.x) {
      i1 = i2 + this.y;
    }
    return i1 - this.x;
  }
  
  private void b(Canvas paramCanvas)
  {
    int i2 = ((this.C - this.i * 2) / this.y - f) / 2;
    int i1 = h + this.P;
    String str = a();
    float f1 = i2;
    paramCanvas.drawText(str, f1, i1, this.jdField_c_of_type_AndroidGraphicsPaint);
    i2 = this.C;
    int i3 = this.i;
    int i4 = this.O;
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-2171170);
    float f2 = i1 + i4 + 6;
    paramCanvas.drawLine(f1, f2, i2 + i3 * 2, f2, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  public CalendarDay a(float paramFloat1, float paramFloat2)
  {
    int i1 = this.i;
    float f1 = i1;
    if (paramFloat1 >= f1)
    {
      int i2 = this.C;
      if (paramFloat1 > i2 - i1) {
        return null;
      }
      int i3 = (int)(paramFloat2 - g) / this.B;
      i1 = (int)((paramFloat1 - f1) * this.y / (i2 - i1 - i1)) - b() + 1 + i3 * this.y;
      i2 = this.A;
      if ((i2 <= 11) && (i2 >= 0) && (CalendarDay.getDaysInMonth(this.D, i2) >= i1))
      {
        if (i1 < 1) {
          return null;
        }
        return new CalendarDay(this.D, this.A, i1);
      }
    }
    return null;
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
    int i3 = (this.B + jdField_d_of_type_Int) / 2;
    int i4 = jdField_c_of_type_Int;
    int i6 = g;
    int i8 = (this.C - this.i * 2) / (this.y * 2);
    int i5 = b();
    int i1;
    if ((this.D == this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.year) && (this.A == this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.month)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if (i1 != 0) {
      i2 = this.jdField_b_of_type_ComTencentMobileqqWidgetDatepickerCalendarDay.day;
    } else {
      i2 = this.z;
    }
    i4 = i3 - i4 + i6;
    i3 = 1;
    while (i3 <= i2)
    {
      Object localObject;
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        i1 = 0;
        while (i1 < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localObject = (MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
          if (new CalendarDay(((MessageRecord)localObject).time * 1000L).day == i3)
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("hasMessage : ");
              localStringBuilder.append(this.D);
              localStringBuilder.append("-");
              localStringBuilder.append(this.A + 1);
              localStringBuilder.append("-");
              localStringBuilder.append(i3);
              localStringBuilder.append(" , MessageRecord:");
              localStringBuilder.append(localObject);
              QLog.d("DatePickerView", 2, localStringBuilder.toString());
            }
            i6 = 1;
            break label299;
          }
          i1 += 1;
        }
      }
      i6 = 0;
      label299:
      int i9 = (i5 * 2 + 1) * i8 + this.i;
      if (this.S == i3)
      {
        localObject = this.jdField_d_of_type_AndroidGraphicsPaint;
        if (this.jdField_c_of_type_Boolean) {
          i1 = this.J;
        } else {
          i1 = this.I;
        }
        ((Paint)localObject).setColor(i1);
        paramCanvas.drawCircle(i9, i4 - jdField_d_of_type_Int / 3, jdField_b_of_type_Int, this.jdField_d_of_type_AndroidGraphicsPaint);
      }
      int i7;
      if (((this.A == this.s) && (this.q == i3) && (this.u == this.D)) || ((this.A == this.t) && (this.r == i3) && (this.v == this.D))) {
        i7 = 1;
      } else {
        i7 = 0;
      }
      if (i7 != 0)
      {
        localObject = this.jdField_d_of_type_AndroidGraphicsPaint;
        if (i6 != 0) {
          i1 = this.p;
        } else {
          i1 = this.p & 0xFFFFFF | 0x7F000000;
        }
        ((Paint)localObject).setColor(i1);
        if (this.jdField_a_of_type_JavaLangBoolean.booleanValue())
        {
          i1 = jdField_b_of_type_Int;
          float f1 = i9 - i1;
          int i10 = jdField_d_of_type_Int;
          paramCanvas.drawRoundRect(new RectF(f1, i4 - i10 / 3 - i1, i9 + i1, i4 - i10 / 3 + i1), 10.0F, 10.0F, this.jdField_d_of_type_AndroidGraphicsPaint);
        }
        else
        {
          paramCanvas.drawCircle(i9, i4 - jdField_d_of_type_Int / 3, jdField_b_of_type_Int, this.jdField_d_of_type_AndroidGraphicsPaint);
        }
      }
      if ((this.jdField_a_of_type_Boolean) && (this.w == i3))
      {
        this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.j);
        if (i7 != 0)
        {
          if (i6 != 0) {
            i1 = this.p;
          } else {
            i1 = this.p & 0xFFFFFF | 0x7F000000;
          }
        }
        else if (i6 != 0) {
          i1 = this.m;
        } else {
          i1 = this.H;
        }
        this.jdField_d_of_type_AndroidGraphicsPaint.setColor(i1);
        paramCanvas.drawText(HardCodeUtil.a(2131714038), i9, jdField_b_of_type_Int + i4 + jdField_d_of_type_Int / 2, this.jdField_d_of_type_AndroidGraphicsPaint);
      }
      else
      {
        this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.m);
      }
      if (i7 != 0) {
        this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.n);
      }
      for (;;)
      {
        break;
        if (i6 == 0)
        {
          this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.H);
        }
        else if ((!this.jdField_b_of_type_JavaLangBoolean.booleanValue()) && (a(i3, this.jdField_a_of_type_AndroidTextFormatTime)) && (this.jdField_a_of_type_AndroidTextFormatTime.month == this.A) && (this.jdField_a_of_type_AndroidTextFormatTime.year == this.D))
        {
          this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.o);
          this.jdField_b_of_type_AndroidGraphicsPaint.setTypeface(Typeface.defaultFromStyle(2));
        }
      }
      paramCanvas.drawText(Integer.toString(i3), i9, i4, this.jdField_b_of_type_AndroidGraphicsPaint);
      i5 += 1;
      i1 = i5;
      i6 = i4;
      if (i5 == this.y)
      {
        i6 = i4 + this.B;
        i1 = 0;
      }
      i3 += 1;
      i5 = i1;
      i4 = i6;
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
    else if ((this.jdField_c_of_type_Boolean) && (paramMotionEvent.getAction() != 2))
    {
      this.jdField_c_of_type_Boolean = false;
      invalidate();
    }
    if (paramMotionEvent.getAction() == 1)
    {
      paramMotionEvent = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (paramMotionEvent != null) {
        a(paramMotionEvent);
      }
    }
    return true;
  }
  
  public void setMessageRecords(ArrayList<MessageRecord> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void setMonthParams(HashMap<String, Integer> paramHashMap)
  {
    if ((!paramHashMap.containsKey("month")) && (!paramHashMap.containsKey("year"))) {
      throw new InvalidParameterException("You must specify month and year for this view");
    }
    setTag(paramHashMap);
    if (paramHashMap.containsKey("height"))
    {
      this.B = ((Integer)paramHashMap.get("height")).intValue();
      i1 = this.B;
      i2 = e;
      if (i1 < i2) {
        this.B = i2;
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
    int i1 = 0;
    this.jdField_a_of_type_Boolean = false;
    this.w = -1;
    this.jdField_a_of_type_JavaUtilCalendar.set(2, this.A);
    this.jdField_a_of_type_JavaUtilCalendar.set(1, this.D);
    this.jdField_a_of_type_JavaUtilCalendar.set(5, 1);
    this.R = this.jdField_a_of_type_JavaUtilCalendar.get(7);
    if (paramHashMap.containsKey("week_start")) {
      this.x = ((Integer)paramHashMap.get("week_start")).intValue();
    } else {
      this.x = this.jdField_a_of_type_JavaUtilCalendar.getFirstDayOfWeek();
    }
    int i2 = CalendarDay.getDaysInMonth(this.D, this.A);
    while (i1 < i2)
    {
      i1 += 1;
      if ((this.D == this.jdField_a_of_type_AndroidTextFormatTime.year) && (this.A == this.jdField_a_of_type_AndroidTextFormatTime.month) && (i1 == this.jdField_a_of_type_AndroidTextFormatTime.monthDay))
      {
        this.jdField_a_of_type_Boolean = true;
        this.w = i1;
      }
      this.jdField_b_of_type_Boolean = a(i1, this.jdField_a_of_type_AndroidTextFormatTime);
    }
    i1 = i2;
    if (this.jdField_a_of_type_Boolean) {
      i1 = this.w;
    }
    this.z = i1;
    this.T = a();
  }
  
  public void setOnDayClickListener(SimpleMonthView.OnDayClickListener paramOnDayClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetDatepickerSimpleMonthView$OnDayClickListener = paramOnDayClickListener;
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