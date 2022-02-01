package com.tencent.mobileqq.search.util;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.ChnSpelling;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import java.util.List;
import mqq.app.MobileQQ;

public class BaseSearchUtil
{
  public static int a()
  {
    int i = MobileQQ.sMobileQQ.getResources().getColor(2131166969);
    if (ThemeUtil.isNowThemeIsNight(MobileQQ.sMobileQQ.peekAppRuntime(), false, "")) {
      i = MobileQQ.sMobileQQ.getResources().getColor(2131166971);
    }
    return i;
  }
  
  public static CharSequence a(TextView paramTextView, String paramString1, String paramString2, boolean paramBoolean)
  {
    String str = paramString1.toLowerCase();
    int n = str.indexOf(paramString2);
    int j = paramString2.length();
    int m = 0;
    int i = n;
    int k = j;
    Object localObject = paramString2;
    if (n < 0)
    {
      paramString2 = paramString2.toLowerCase();
      n = str.indexOf(paramString2);
      i = n;
      k = j;
      localObject = paramString2;
      if (n < 0)
      {
        if (paramBoolean)
        {
          localObject = a(str, paramString2, 1);
          if (localObject[0] >= 0) {
            j = localObject[0];
          }
          for (i = localObject[1];; i = localObject[1])
          {
            k = i;
            i = j;
            localObject = paramString2;
            break label163;
            localObject = a(str, paramString2, 2);
            if (localObject[0] < 0) {
              break;
            }
            j = localObject[0];
          }
          return new SpannableStringBuilder(paramString1);
        }
        return new SpannableStringBuilder(paramString1);
      }
    }
    label163:
    j = paramTextView.getWidth();
    TextPaint localTextPaint = paramTextView.getPaint();
    float f1 = localTextPaint.measureText(paramString1);
    float f2 = j;
    if ((f1 > f2) && (i + k > 10))
    {
      do
      {
        n = i - m;
        paramTextView = str;
        j = m;
        paramString2 = paramString1;
        if (n <= 4) {
          break;
        }
        paramTextView = paramString1.substring(n);
        j = m + 1;
        m = j;
      } while (localTextPaint.measureText(paramTextView) + 70.0F <= f2);
      paramString1 = new StringBuilder();
      paramString1.append("…");
      paramString1.append(paramTextView);
      paramString2 = paramString1.toString();
      paramString1 = new StringBuilder();
      paramString1.append("…");
      paramString1.append(paramTextView);
      paramTextView = paramString1.toString();
    }
    else
    {
      paramString2 = paramString1;
      j = i;
      paramTextView = str;
    }
    paramString1 = new SpannableStringBuilder(paramString2);
    while (j >= 0)
    {
      paramString2 = new ForegroundColorSpan(a());
      i = k + j;
      paramString1.setSpan(paramString2, j, i, 17);
      j = paramTextView.indexOf((String)localObject, i);
      k = ((String)localObject).length();
    }
    return paramString1;
  }
  
  public static int[] a(ChnToSpell.ChnSpelling paramChnSpelling, String paramString)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp7_5 = arrayOfInt;
    tmp7_5[0] = -1;
    int[] tmp11_7 = tmp7_5;
    tmp11_7[1] = 0;
    tmp11_7;
    int j = paramChnSpelling.jdField_a_of_type_JavaLangString.indexOf(paramString);
    if (j < 0) {
      return arrayOfInt;
    }
    int i = 0;
    while (i < paramChnSpelling.jdField_a_of_type_JavaUtilList.size())
    {
      if (j == ((Integer)paramChnSpelling.jdField_a_of_type_JavaUtilList.get(i)).intValue())
      {
        arrayOfInt[0] = i;
        k = i + 1;
        while ((k < paramChnSpelling.jdField_a_of_type_JavaUtilList.size()) && (paramString.length() + j > ((Integer)paramChnSpelling.jdField_a_of_type_JavaUtilList.get(k)).intValue())) {
          k += 1;
        }
        arrayOfInt[1] = (k - i);
        return arrayOfInt;
      }
      int m = i;
      int k = j;
      if (j < ((Integer)paramChnSpelling.jdField_a_of_type_JavaUtilList.get(i)).intValue())
      {
        k = paramChnSpelling.jdField_a_of_type_JavaLangString.indexOf(paramString, ((Integer)paramChnSpelling.jdField_a_of_type_JavaUtilList.get(i)).intValue());
        if (k < 0) {
          return arrayOfInt;
        }
        m = i - 1;
      }
      i = m + 1;
      j = k;
    }
    return arrayOfInt;
  }
  
  public static int[] a(String paramString1, String paramString2, int paramInt)
  {
    return a(ChnToSpell.a(paramString1, paramInt), paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.BaseSearchUtil
 * JD-Core Version:    0.7.0.1
 */