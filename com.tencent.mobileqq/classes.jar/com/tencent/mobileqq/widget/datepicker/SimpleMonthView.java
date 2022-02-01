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
  protected int A = -1;
  protected int B = -1;
  protected int C = -1;
  protected int D = 1;
  protected int E = 7;
  protected int F = this.E;
  protected int G;
  protected Boolean H;
  protected int I = a;
  protected int J;
  protected int K;
  protected ArrayList<MessageRecord> L;
  final Time M = new Time(Time.getCurrentTimezone());
  int N = -16777216;
  int O = -15550475;
  int P = -1;
  int Q = -4473925;
  int R = -394757;
  int S = 2131933173;
  int T;
  int U;
  int V;
  int W;
  int Z;
  int aa;
  int ab;
  private String ac;
  private String ad;
  private int ae = 0;
  private final Calendar af = Calendar.getInstance();
  private final Calendar ag = Calendar.getInstance();
  private final Boolean ah;
  private CalendarDay ai;
  private CalendarDay aj;
  private int ak = 0;
  private boolean al = false;
  private int am = 6;
  private DateFormatSymbols an = new DateFormatSymbols();
  private SimpleMonthView.OnDayClickListener ao;
  protected int i = 0;
  protected Paint j;
  protected Paint k;
  protected Paint l;
  protected Paint m;
  protected int n;
  protected int o;
  protected int p;
  protected int q;
  protected int r;
  protected int s;
  protected int t;
  protected boolean u = false;
  protected boolean v = false;
  protected int w = -1;
  protected int x = -1;
  protected int y = -1;
  protected int z = -1;
  
  public SimpleMonthView(Context paramContext, TypedArray paramTypedArray)
  {
    super(paramContext);
    this.M.setToNow();
    this.ac = "sans-serif";
    this.ad = "sans-serif";
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.j(), false, null))
    {
      this.N = -9004613;
      this.R = -16115667;
      this.Q = -8947849;
    }
    this.n = paramTypedArray.getColor(1, this.N);
    this.o = paramTypedArray.getColor(3, this.O);
    this.p = paramTypedArray.getColor(2, this.N);
    this.q = paramTypedArray.getColor(4, this.N);
    this.s = paramTypedArray.getColor(5, this.N);
    this.t = paramTypedArray.getColor(6, this.O);
    this.r = paramTypedArray.getColor(7, this.P);
    this.T = UIUtils.a(paramContext, 16.0F);
    this.U = UIUtils.a(paramContext, 10.0F);
    this.V = UIUtils.a(paramContext, 50.0F);
    this.W = UIUtils.a(paramContext, 342.0F);
    this.Z = UIUtils.a(paramContext, 12.5F);
    this.aa = UIUtils.a(paramContext, 14.0F);
    this.ab = UIUtils.a(paramContext, 17.5F);
    d = paramTypedArray.getDimensionPixelSize(15, this.T);
    h = paramTypedArray.getDimensionPixelSize(17, this.T);
    f = paramTypedArray.getDimensionPixelSize(16, this.U);
    g = paramTypedArray.getDimensionPixelOffset(12, this.V);
    b = paramTypedArray.getDimensionPixelSize(14, this.ab);
    this.I = ((paramTypedArray.getDimensionPixelSize(0, this.W) - g) / 6);
    this.ah = Boolean.valueOf(paramTypedArray.getBoolean(10, true));
    this.H = Boolean.valueOf(paramTypedArray.getBoolean(9, false));
    a();
  }
  
  private void a(CalendarDay paramCalendarDay)
  {
    if ((this.ao != null) && (this.L != null) && ((this.ah.booleanValue()) || (paramCalendarDay.month != this.M.month) || (paramCalendarDay.year != this.M.year) || (paramCalendarDay.day >= this.M.monthDay)))
    {
      Object localObject2 = null;
      int i1 = 0;
      Object localObject1;
      for (;;)
      {
        localObject1 = localObject2;
        if (i1 >= this.L.size()) {
          break;
        }
        localObject1 = (MessageRecord)this.L.get(i1);
        if (new CalendarDay(((MessageRecord)localObject1).time * 1000L).day == paramCalendarDay.day) {
          break;
        }
        i1 += 1;
      }
      this.ao.a(this, paramCalendarDay, localObject1);
    }
  }
  
  private boolean a(int paramInt, Time paramTime)
  {
    return (this.K < paramTime.year) || ((this.K == paramTime.year) && (this.G < paramTime.month)) || ((this.G == paramTime.month) && (paramInt < paramTime.monthDay));
  }
  
  private void b(Canvas paramCanvas)
  {
    int i2 = ((this.J - this.i * 2) / this.E - f) / 2;
    int i1 = h + this.aa;
    String str = getMonthAndYearString();
    float f1 = i2;
    paramCanvas.drawText(str, f1, i1, this.l);
    i2 = this.J;
    int i3 = this.i;
    int i4 = this.Z;
    this.k.setColor(-2171170);
    float f2 = i1 + i4 + 6;
    paramCanvas.drawLine(f1, f2, i2 + i3 * 2, f2, this.k);
  }
  
  private int c()
  {
    int i1 = d();
    int i3 = this.F;
    int i4 = this.E;
    int i2 = (i1 + i3) / i4;
    if ((i1 + i3) % i4 > 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    return i2 + i1;
  }
  
  private int d()
  {
    int i2 = this.ae;
    int i1 = i2;
    if (i2 < this.D) {
      i1 = i2 + this.E;
    }
    return i1 - this.D;
  }
  
  private String getMonthAndYearString()
  {
    long l1 = this.af.getTimeInMillis();
    return DateUtils.formatDateRange(getContext(), l1, l1, 52);
  }
  
  public CalendarDay a(float paramFloat1, float paramFloat2)
  {
    int i1 = this.i;
    float f1 = i1;
    if (paramFloat1 >= f1)
    {
      int i2 = this.J;
      if (paramFloat1 > i2 - i1) {
        return null;
      }
      int i3 = (int)(paramFloat2 - g) / this.I;
      i1 = (int)((paramFloat1 - f1) * this.E / (i2 - i1 - i1)) - d() + 1 + i3 * this.E;
      i2 = this.G;
      if ((i2 <= 11) && (i2 >= 0) && (CalendarDay.getDaysInMonth(this.K, i2) >= i1))
      {
        if (i1 < 1) {
          return null;
        }
        return new CalendarDay(this.K, this.G, i1);
      }
    }
    return null;
  }
  
  protected void a()
  {
    this.l = new Paint();
    this.l.setFakeBoldText(true);
    this.l.setAntiAlias(true);
    this.l.setTextSize(h);
    this.l.setColor(this.o);
    this.l.setTextAlign(Paint.Align.LEFT);
    this.l.setStyle(Paint.Style.FILL);
    this.m = new Paint();
    this.m.setFakeBoldText(true);
    this.m.setAntiAlias(true);
    this.m.setColor(this.t);
    this.m.setTextAlign(Paint.Align.CENTER);
    this.m.setStyle(Paint.Style.FILL);
    this.m.setTextSize(this.Z);
    this.j = new Paint();
    this.j.setAntiAlias(true);
    this.j.setTextSize(f);
    this.j.setColor(this.p);
    this.j.setTypeface(Typeface.create(this.ac, 0));
    this.j.setStyle(Paint.Style.FILL);
    this.j.setTextAlign(Paint.Align.CENTER);
    this.j.setFakeBoldText(true);
    this.k = new Paint();
    this.k.setFakeBoldText(false);
    this.k.setAntiAlias(true);
    this.k.setTextSize(d);
    this.k.setStyle(Paint.Style.FILL);
    this.k.setTextAlign(Paint.Align.CENTER);
  }
  
  protected void a(Canvas paramCanvas)
  {
    int i3 = (this.I + d) / 2;
    int i4 = c;
    int i6 = g;
    int i8 = (this.J - this.i * 2) / (this.E * 2);
    int i5 = d();
    int i1;
    if ((this.K == this.aj.year) && (this.G == this.aj.month)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if (i1 != 0) {
      i2 = this.aj.day;
    } else {
      i2 = this.F;
    }
    i4 = i3 - i4 + i6;
    i3 = 1;
    while (i3 <= i2)
    {
      Object localObject;
      if (this.L != null)
      {
        i1 = 0;
        while (i1 < this.L.size())
        {
          localObject = (MessageRecord)this.L.get(i1);
          if (new CalendarDay(((MessageRecord)localObject).time * 1000L).day == i3)
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("hasMessage : ");
              localStringBuilder.append(this.K);
              localStringBuilder.append("-");
              localStringBuilder.append(this.G + 1);
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
      if (this.ak == i3)
      {
        localObject = this.m;
        if (this.al) {
          i1 = this.S;
        } else {
          i1 = this.R;
        }
        ((Paint)localObject).setColor(i1);
        paramCanvas.drawCircle(i9, i4 - d / 3, b, this.m);
      }
      int i7;
      if (((this.G == this.y) && (this.w == i3) && (this.A == this.K)) || ((this.G == this.z) && (this.x == i3) && (this.B == this.K))) {
        i7 = 1;
      } else {
        i7 = 0;
      }
      if (i7 != 0)
      {
        localObject = this.m;
        if (i6 != 0) {
          i1 = this.t;
        } else {
          i1 = this.t & 0xFFFFFF | 0x7F000000;
        }
        ((Paint)localObject).setColor(i1);
        if (this.H.booleanValue())
        {
          i1 = b;
          float f1 = i9 - i1;
          int i10 = d;
          paramCanvas.drawRoundRect(new RectF(f1, i4 - i10 / 3 - i1, i9 + i1, i4 - i10 / 3 + i1), 10.0F, 10.0F, this.m);
        }
        else
        {
          paramCanvas.drawCircle(i9, i4 - d / 3, b, this.m);
        }
      }
      if ((this.u) && (this.C == i3))
      {
        this.k.setColor(this.n);
        if (i7 != 0)
        {
          if (i6 != 0) {
            i1 = this.t;
          } else {
            i1 = this.t & 0xFFFFFF | 0x7F000000;
          }
        }
        else if (i6 != 0) {
          i1 = this.q;
        } else {
          i1 = this.Q;
        }
        this.m.setColor(i1);
        paramCanvas.drawText(HardCodeUtil.a(2131911569), i9, b + i4 + d / 2, this.m);
      }
      else
      {
        this.k.setColor(this.q);
      }
      if (i7 != 0) {
        this.k.setColor(this.r);
      }
      for (;;)
      {
        break;
        if (i6 == 0)
        {
          this.k.setColor(this.Q);
        }
        else if ((!this.ah.booleanValue()) && (a(i3, this.M)) && (this.M.month == this.G) && (this.M.year == this.K))
        {
          this.k.setColor(this.s);
          this.k.setTypeface(Typeface.defaultFromStyle(2));
        }
      }
      paramCanvas.drawText(Integer.toString(i3), i9, i4, this.k);
      i5 += 1;
      i1 = i5;
      i6 = i4;
      if (i5 == this.E)
      {
        i6 = i4 + this.I;
        i1 = 0;
      }
      i3 += 1;
      i5 = i1;
      i4 = i6;
    }
  }
  
  public void b()
  {
    this.am = 6;
    requestLayout();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    b(paramCanvas);
    a(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), this.I * this.am + g + this.U);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.J = paramInt1;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      CalendarDay localCalendarDay = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      if (localCalendarDay != null)
      {
        this.al = true;
        this.ak = localCalendarDay.day;
        invalidate();
      }
    }
    else if ((this.al) && (paramMotionEvent.getAction() != 2))
    {
      this.al = false;
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
    this.L = paramArrayList;
  }
  
  public void setMonthParams(HashMap<String, Integer> paramHashMap)
  {
    if ((!paramHashMap.containsKey("month")) && (!paramHashMap.containsKey("year"))) {
      throw new InvalidParameterException("You must specify month and year for this view");
    }
    setTag(paramHashMap);
    if (paramHashMap.containsKey("height"))
    {
      this.I = ((Integer)paramHashMap.get("height")).intValue();
      i1 = this.I;
      i2 = e;
      if (i1 < i2) {
        this.I = i2;
      }
    }
    if (paramHashMap.containsKey("selected_begin_day")) {
      this.w = ((Integer)paramHashMap.get("selected_begin_day")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_day")) {
      this.x = ((Integer)paramHashMap.get("selected_last_day")).intValue();
    }
    if (paramHashMap.containsKey("selected_begin_month")) {
      this.y = ((Integer)paramHashMap.get("selected_begin_month")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_month")) {
      this.z = ((Integer)paramHashMap.get("selected_last_month")).intValue();
    }
    if (paramHashMap.containsKey("selected_begin_year")) {
      this.A = ((Integer)paramHashMap.get("selected_begin_year")).intValue();
    }
    if (paramHashMap.containsKey("selected_last_year")) {
      this.B = ((Integer)paramHashMap.get("selected_last_year")).intValue();
    }
    this.G = ((Integer)paramHashMap.get("month")).intValue();
    this.K = ((Integer)paramHashMap.get("year")).intValue();
    int i1 = 0;
    this.u = false;
    this.C = -1;
    this.af.set(2, this.G);
    this.af.set(1, this.K);
    this.af.set(5, 1);
    this.ae = this.af.get(7);
    if (paramHashMap.containsKey("week_start")) {
      this.D = ((Integer)paramHashMap.get("week_start")).intValue();
    } else {
      this.D = this.af.getFirstDayOfWeek();
    }
    int i2 = CalendarDay.getDaysInMonth(this.K, this.G);
    while (i1 < i2)
    {
      i1 += 1;
      if ((this.K == this.M.year) && (this.G == this.M.month) && (i1 == this.M.monthDay))
      {
        this.u = true;
        this.C = i1;
      }
      this.v = a(i1, this.M);
    }
    i1 = i2;
    if (this.u) {
      i1 = this.C;
    }
    this.F = i1;
    this.am = c();
  }
  
  public void setOnDayClickListener(SimpleMonthView.OnDayClickListener paramOnDayClickListener)
  {
    this.ao = paramOnDayClickListener;
  }
  
  public void setStartAndEndDate(CalendarDay paramCalendarDay1, CalendarDay paramCalendarDay2)
  {
    this.ai = paramCalendarDay1;
    this.aj = paramCalendarDay2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.datepicker.SimpleMonthView
 * JD-Core Version:    0.7.0.1
 */