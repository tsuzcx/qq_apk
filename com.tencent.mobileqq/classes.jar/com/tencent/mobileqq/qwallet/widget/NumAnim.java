package com.tencent.mobileqq.qwallet.widget;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.SuperscriptSpan;
import android.util.SparseArray;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class NumAnim
  implements Runnable
{
  static DecimalFormat b = new DecimalFormat("0.00");
  static DecimalFormat c;
  SparseArray<Boolean> a = new SparseArray();
  NumAnim.Ruler d = new NumAnim.1(this);
  NumAnim.AnimListener e = null;
  final int f;
  final int g;
  final boolean h;
  long i = 0L;
  private final TextView j;
  private double[] k;
  private long l;
  private int m = 0;
  
  static
  {
    DecimalFormatSymbols localDecimalFormatSymbols = DecimalFormatSymbols.getInstance(Locale.US);
    localDecimalFormatSymbols.setDecimalSeparator('.');
    b.setDecimalFormatSymbols(localDecimalFormatSymbols);
    b.setRoundingMode(RoundingMode.DOWN);
    c = new DecimalFormat("0.0");
    localDecimalFormatSymbols = DecimalFormatSymbols.getInstance(Locale.US);
    localDecimalFormatSymbols.setDecimalSeparator('.');
    c.setDecimalFormatSymbols(localDecimalFormatSymbols);
    c.setRoundingMode(RoundingMode.DOWN);
  }
  
  public NumAnim(TextView paramTextView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.j = paramTextView;
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramBoolean;
  }
  
  public static double a(double paramDouble)
  {
    double d1 = paramDouble;
    if (paramDouble > 9999999999.0D) {
      d1 = 9999999999.0D;
    }
    return d1;
  }
  
  public static String a(double paramDouble, boolean paramBoolean)
  {
    int n;
    if ((paramBoolean) && (paramDouble >= 10000.0D)) {
      n = 1;
    } else {
      n = 0;
    }
    double d1;
    if (n != 0) {
      d1 = paramDouble / 10000.0D;
    } else {
      d1 = paramDouble;
    }
    Object localObject1;
    if ((paramDouble >= 1000000.0D) && (paramDouble < 10000000.0D))
    {
      localObject1 = c.format(d1);
    }
    else if (paramDouble >= 10000000.0D)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((int)d1);
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = b.format(d1);
    }
    Object localObject2 = localObject1;
    if (n != 0)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("万");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    return localObject2;
  }
  
  public void a()
  {
    TextView localTextView = this.j;
    if (localTextView == null) {
      return;
    }
    localTextView.removeCallbacks(this);
  }
  
  public void a(double paramDouble1, double paramDouble2, long paramLong)
  {
    if (QLog.isDevelopLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("start begin=");
      ((StringBuilder)localObject1).append(paramDouble1);
      ((StringBuilder)localObject1).append(",end=");
      ((StringBuilder)localObject1).append(paramDouble2);
      ((StringBuilder)localObject1).append(",ms=");
      ((StringBuilder)localObject1).append(paramLong);
      QLog.d("NumAnim", 4, ((StringBuilder)localObject1).toString());
    }
    this.i = System.currentTimeMillis();
    Object localObject1 = this.j;
    if (localObject1 == null) {
      return;
    }
    ((TextView)localObject1).removeCallbacks(this);
    double d1 = a(paramDouble1 * 100.0D);
    double d2 = a(paramDouble2 * 100.0D);
    int n;
    if (paramDouble1 < paramDouble2) {
      n = 1;
    } else {
      n = 0;
    }
    if (n != 0) {
      paramDouble1 = d2 - d1;
    } else {
      paramDouble1 = d1 - d2;
    }
    int i1 = (int)((float)(paramLong * 30L) / 1000.0F);
    if (paramDouble1 <= 30.0D) {
      i1 = (int)paramDouble1;
    }
    localObject1 = new double[i1 + 1];
    int i2 = 0;
    while (i2 < i1)
    {
      paramDouble2 = i1;
      Double.isNaN(paramDouble2);
      paramDouble2 = paramDouble1 / paramDouble2;
      double d3 = i2;
      Double.isNaN(d3);
      paramDouble2 *= d3;
      if (n != 0) {
        paramDouble2 += d1;
      } else {
        paramDouble2 = d1 - paramDouble2;
      }
      localObject1[i2] = (paramDouble2 / 100.0D);
      i2 += 1;
    }
    localObject1[i1] = (d2 / 100.0D);
    try
    {
      this.k = ((double[])localObject1);
      if (localObject1.length > 1) {
        n = localObject1.length - 1;
      } else {
        n = localObject1.length;
      }
      this.l = (paramLong / n);
      this.m = 0;
      this.j.post(this);
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.a.put(paramInt, Boolean.valueOf(paramBoolean));
  }
  
  public void a(NumAnim.Ruler paramRuler)
  {
    this.d = paramRuler;
  }
  
  public void run()
  {
    int n = this.m;
    Object localObject = this.k;
    if ((n < localObject.length) && (this.d != null))
    {
      this.m = (n + 1);
      double d1 = a(localObject[n]);
      localObject = this.d.getNumber(d1);
      if ((localObject != null) && (!TextUtils.isEmpty(((NumAnim.SpannableValue)localObject).a)))
      {
        SpannableString localSpannableString = new SpannableString(((NumAnim.SpannableValue)localObject).a);
        n = ((NumAnim.SpannableValue)localObject).c;
        int i1 = ((NumAnim.SpannableValue)localObject).b;
        int i2 = ((NumAnim.SpannableValue)localObject).a.length();
        if (i1 > 0)
        {
          localSpannableString.setSpan(new SuperscriptSpan(), 0, i1, 33);
          localSpannableString.setSpan(new RelativeSizeSpan(0.5F), 0, i1, 33);
          localSpannableString.setSpan(new AbsoluteSizeSpan(this.f, this.h), 0, i1, 33);
          if (((Boolean)this.a.get(1, Boolean.valueOf(false))).booleanValue()) {
            localSpannableString.setSpan(new StyleSpan(1), 0, i1, 33);
          }
        }
        localSpannableString.setSpan(new AbsoluteSizeSpan(this.g, this.h), i1, n, 33);
        if (n < i2)
        {
          localSpannableString.setSpan(new SuperscriptSpan(), n, i2, 33);
          localSpannableString.setSpan(new RelativeSizeSpan(0.5F), n, i2, 33);
          localSpannableString.setSpan(new AbsoluteSizeSpan(this.f, this.h), n, i2, 33);
          if (((Boolean)this.a.get(3, Boolean.valueOf(false))).booleanValue()) {
            localSpannableString.setSpan(new StyleSpan(1), n, i2, 33);
          }
        }
        this.j.setText(localSpannableString);
        this.j.removeCallbacks(this);
        this.j.postDelayed(this, this.l);
      }
    }
    if (this.m >= this.k.length)
    {
      this.j.removeCallbacks(this);
      localObject = this.e;
      if (localObject != null)
      {
        ((NumAnim.AnimListener)localObject).a();
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onFinished coast=");
          ((StringBuilder)localObject).append(System.currentTimeMillis() - this.i);
          QLog.d("NumAnim", 4, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.widget.NumAnim
 * JD-Core Version:    0.7.0.1
 */