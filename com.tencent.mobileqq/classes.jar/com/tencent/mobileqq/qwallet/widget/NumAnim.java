package com.tencent.mobileqq.qwallet.widget;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
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
  static DecimalFormat jdField_a_of_type_JavaTextDecimalFormat = new DecimalFormat("0.00");
  static DecimalFormat jdField_b_of_type_JavaTextDecimalFormat;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  SparseArray<Boolean> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  NumAnim.AnimListener jdField_a_of_type_ComTencentMobileqqQwalletWidgetNumAnim$AnimListener = null;
  NumAnim.Ruler jdField_a_of_type_ComTencentMobileqqQwalletWidgetNumAnim$Ruler = new NumAnim.1(this);
  final boolean jdField_a_of_type_Boolean;
  private double[] jdField_a_of_type_ArrayOfDouble;
  int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  boolean jdField_b_of_type_Boolean;
  final int c;
  private int d = 0;
  
  static
  {
    DecimalFormatSymbols localDecimalFormatSymbols = DecimalFormatSymbols.getInstance(Locale.US);
    localDecimalFormatSymbols.setDecimalSeparator('.');
    jdField_a_of_type_JavaTextDecimalFormat.setDecimalFormatSymbols(localDecimalFormatSymbols);
    jdField_a_of_type_JavaTextDecimalFormat.setRoundingMode(RoundingMode.DOWN);
    jdField_b_of_type_JavaTextDecimalFormat = new DecimalFormat("0.0");
    localDecimalFormatSymbols = DecimalFormatSymbols.getInstance(Locale.US);
    localDecimalFormatSymbols.setDecimalSeparator('.');
    jdField_b_of_type_JavaTextDecimalFormat.setDecimalFormatSymbols(localDecimalFormatSymbols);
    jdField_b_of_type_JavaTextDecimalFormat.setRoundingMode(RoundingMode.DOWN);
  }
  
  public NumAnim(TextView paramTextView, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    this.c = paramInt3;
    this.jdField_b_of_type_Boolean = paramBoolean1;
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
    int i;
    if ((paramBoolean) && (paramDouble >= 10000.0D)) {
      i = 1;
    } else {
      i = 0;
    }
    double d1;
    if (i != 0) {
      d1 = paramDouble / 10000.0D;
    } else {
      d1 = paramDouble;
    }
    Object localObject1;
    if ((paramDouble >= 1000000.0D) && (paramDouble < 10000000.0D))
    {
      localObject1 = jdField_b_of_type_JavaTextDecimalFormat.format(d1);
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
      localObject1 = jdField_a_of_type_JavaTextDecimalFormat.format(d1);
    }
    Object localObject2 = localObject1;
    if (i != 0)
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
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
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
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject1 == null) {
      return;
    }
    ((TextView)localObject1).removeCallbacks(this);
    double d1 = a(paramDouble1 * 100.0D);
    double d2 = a(paramDouble2 * 100.0D);
    int i;
    if (paramDouble1 < paramDouble2) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramDouble1 = d2 - d1;
    } else {
      paramDouble1 = d1 - d2;
    }
    int j = (int)((float)(paramLong * 30L) / 1000.0F);
    if (paramDouble1 <= 30.0D) {
      j = (int)paramDouble1;
    }
    localObject1 = new double[j + 1];
    int k = 0;
    while (k < j)
    {
      paramDouble2 = j;
      Double.isNaN(paramDouble2);
      paramDouble2 = paramDouble1 / paramDouble2;
      double d3 = k;
      Double.isNaN(d3);
      paramDouble2 *= d3;
      if (i != 0) {
        paramDouble2 += d1;
      } else {
        paramDouble2 = d1 - paramDouble2;
      }
      localObject1[k] = (paramDouble2 / 100.0D);
      k += 1;
    }
    localObject1[j] = (d2 / 100.0D);
    try
    {
      this.jdField_a_of_type_ArrayOfDouble = ((double[])localObject1);
      if (localObject1.length > 1) {
        i = localObject1.length - 1;
      } else {
        i = localObject1.length;
      }
      this.jdField_b_of_type_Long = (paramLong / i);
      this.d = 0;
      this.jdField_a_of_type_AndroidWidgetTextView.post(this);
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
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, Boolean.valueOf(paramBoolean));
  }
  
  public void a(NumAnim.AnimListener paramAnimListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQwalletWidgetNumAnim$AnimListener = paramAnimListener;
  }
  
  public void a(NumAnim.Ruler paramRuler)
  {
    this.jdField_a_of_type_ComTencentMobileqqQwalletWidgetNumAnim$Ruler = paramRuler;
  }
  
  public void run()
  {
    int i = this.d;
    Object localObject = this.jdField_a_of_type_ArrayOfDouble;
    if ((i < localObject.length) && (this.jdField_a_of_type_ComTencentMobileqqQwalletWidgetNumAnim$Ruler != null))
    {
      this.d = (i + 1);
      double d1 = a(localObject[i]);
      localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletWidgetNumAnim$Ruler.getNumber(d1);
      if ((localObject != null) && (!TextUtils.isEmpty(((NumAnim.SpannableValue)localObject).jdField_a_of_type_JavaLangString)))
      {
        SpannableString localSpannableString = new SpannableString(((NumAnim.SpannableValue)localObject).jdField_a_of_type_JavaLangString);
        int j = ((NumAnim.SpannableValue)localObject).jdField_a_of_type_JavaLangString.length();
        if (((NumAnim.SpannableValue)localObject).jdField_a_of_type_Int > 0)
        {
          localSpannableString.setSpan(new SuperscriptSpan(), 0, ((NumAnim.SpannableValue)localObject).jdField_a_of_type_Int, 33);
          localSpannableString.setSpan(new RelativeSizeSpan(0.5F), 0, ((NumAnim.SpannableValue)localObject).jdField_a_of_type_Int, 33);
          localSpannableString.setSpan(new AbsoluteSizeSpan(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean), 0, ((NumAnim.SpannableValue)localObject).jdField_a_of_type_Int, 33);
          if (((Boolean)this.jdField_a_of_type_AndroidUtilSparseArray.get(1, Boolean.valueOf(false))).booleanValue()) {
            localSpannableString.setSpan(new StyleSpan(1), 0, ((NumAnim.SpannableValue)localObject).jdField_a_of_type_Int, 33);
          }
        }
        if ((this.jdField_b_of_type_Boolean) && (((NumAnim.SpannableValue)localObject).jdField_b_of_type_Int > 2)) {
          this.jdField_b_of_type_Int -= 8;
        }
        AbsoluteSizeSpan localAbsoluteSizeSpan = new AbsoluteSizeSpan(this.jdField_b_of_type_Int, this.jdField_a_of_type_Boolean);
        int k = ((NumAnim.SpannableValue)localObject).jdField_a_of_type_Int;
        if (((NumAnim.SpannableValue)localObject).jdField_b_of_type_Int > -1) {
          i = ((NumAnim.SpannableValue)localObject).jdField_b_of_type_Int;
        } else {
          i = ((NumAnim.SpannableValue)localObject).c;
        }
        localSpannableString.setSpan(localAbsoluteSizeSpan, k, i, 33);
        i = Math.min(((NumAnim.SpannableValue)localObject).jdField_b_of_type_Int, ((NumAnim.SpannableValue)localObject).c);
        if ((i > -1) && (i < j))
        {
          k = this.c;
          if (k == 1) {
            localSpannableString.setSpan(new SuperscriptSpan(), i, j, 33);
          } else if (k == 2) {
            localSpannableString.setSpan(new SubscriptSpan(), i, j, 33);
          }
        }
        if ((((NumAnim.SpannableValue)localObject).jdField_b_of_type_Int > -1) && (((NumAnim.SpannableValue)localObject).jdField_b_of_type_Int < j))
        {
          if (((NumAnim.SpannableValue)localObject).c > ((NumAnim.SpannableValue)localObject).jdField_b_of_type_Int)
          {
            localSpannableString.setSpan(new AbsoluteSizeSpan(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean), ((NumAnim.SpannableValue)localObject).jdField_b_of_type_Int, ((NumAnim.SpannableValue)localObject).c, 33);
            localSpannableString.setSpan(new AbsoluteSizeSpan(this.jdField_a_of_type_Int - 2, this.jdField_a_of_type_Boolean), ((NumAnim.SpannableValue)localObject).c, j, 33);
          }
          else
          {
            localSpannableString.setSpan(new AbsoluteSizeSpan(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean), ((NumAnim.SpannableValue)localObject).jdField_b_of_type_Int, j, 33);
          }
          if (((Boolean)this.jdField_a_of_type_AndroidUtilSparseArray.get(3, Boolean.valueOf(false))).booleanValue()) {
            localSpannableString.setSpan(new StyleSpan(1), ((NumAnim.SpannableValue)localObject).jdField_b_of_type_Int, j, 33);
          }
        }
        else if ((((NumAnim.SpannableValue)localObject).c > -1) && (((NumAnim.SpannableValue)localObject).c < j))
        {
          localSpannableString.setSpan(new AbsoluteSizeSpan(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean), ((NumAnim.SpannableValue)localObject).c, j, 33);
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(localSpannableString);
        this.jdField_a_of_type_AndroidWidgetTextView.removeCallbacks(this);
        this.jdField_a_of_type_AndroidWidgetTextView.postDelayed(this, this.jdField_b_of_type_Long);
      }
    }
    if (this.d >= this.jdField_a_of_type_ArrayOfDouble.length)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.removeCallbacks(this);
      localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletWidgetNumAnim$AnimListener;
      if (localObject != null)
      {
        ((NumAnim.AnimListener)localObject).a();
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onFinished coast=");
          ((StringBuilder)localObject).append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
          QLog.d("NumAnim", 4, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.widget.NumAnim
 * JD-Core Version:    0.7.0.1
 */