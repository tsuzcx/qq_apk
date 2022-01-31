package com.tencent.mobileqq.text;

import ahzm;
import ahzn;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.GetChars;
import android.text.Layout.Alignment;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.view.View;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.lovelanguage.LoveLanguageConfig;
import com.tencent.mobileqq.mtt.MttBrowerWrapper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;

public class QQText
  implements GetChars, Spannable, CharSequence, Cloneable
{
  public static Spannable.Factory a;
  private static String jdField_a_of_type_JavaLangString;
  public static final Pattern a;
  public static final boolean a;
  private static String jdField_b_of_type_JavaLangString;
  public static final Pattern b;
  public static final boolean b;
  static final Object[] jdField_b_of_type_ArrayOfJavaLangObject;
  static String jdField_c_of_type_JavaLangString = "((100)(00|10|11|50|60|86))|(11185)|(12110)|((123)(10|15|18|20|33|36|45|48|51|55|58|61|65|66|69|80|95|98))|((950)(00|01|03|05|06|08|09|10|11|13|15|16|18|19|22|28|29|30|33|50|51|52|53|55|56|57|58|59|61|63|66|70|71|77|78|80|88|90|95|98|99))|((951)(00|01|02|03|05|06|07|08|09|11|13|15|16|17|18|19|21|22|23|28|30|31|32|33|35|37|38|39|48|51|55|58|60|66|68|69|77|78|80|81|85|86|88|90|95|98|99))|((955)(00|01|02|05|08|09|10|11|12|15|16|18|19|22|28|33|55|56|58|59|61|65|66|67|68|69|77|80|85|86|88|89|90|91|95|96|98|99))|((957)(00|01|02|68|77|88|98|99))|((958)(03|08|10|11|15|16|21|22|25|26|27|28|29|30|32|38|39|55|56|59|65|66|68|82|87|88))|((959)(02|06|09|33|50|51|56|59|63|68|69|93|96|98|99))|((96011))|((961)(02|03|10|30|48|56|89|98))|(96315)|(96677)|(96678)|(96822)|(\\+[0-9]+[\\-]*)?(\\([0-9]+\\)[\\-]*)?([0-9][0-9\\-][0-9\\-]+[0-9])";
  public static final Pattern c;
  public static final String d;
  static final Pattern d;
  public static final Pattern e;
  public static final Pattern f;
  public int a;
  private MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  private int[] jdField_a_of_type_ArrayOfInt;
  public Object[] a;
  public int b;
  private int jdField_c_of_type_Int = -1;
  public String e;
  public String f;
  
  static
  {
    jdField_d_of_type_JavaLangString = Patterns.jdField_c_of_type_JavaUtilRegexPattern.pattern() + "|" + Patterns.jdField_d_of_type_JavaUtilRegexPattern.pattern() + "|" + "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+" + "|" + "\\d{5,15}" + "|" + jdField_c_of_type_JavaLangString;
    jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile(jdField_d_of_type_JavaLangString, 2);
    jdField_b_of_type_JavaUtilRegexPattern = Pattern.compile("\\d{5,15}");
    jdField_c_of_type_JavaUtilRegexPattern = Pattern.compile("\\d+");
    jdField_d_of_type_JavaUtilRegexPattern = Pattern.compile("((100)(00|10|11|50|60|86))|(11185)|(12110)|((123)(10|15|18|20|33|36|45|48|51|55|58|61|65|66|69|80|95|98))|((950)(00|01|03|05|06|08|09|10|11|13|15|16|18|19|22|28|29|30|33|50|51|52|53|55|56|57|58|59|61|63|66|70|71|77|78|80|88|90|95|98|99))|((951)(00|01|02|03|05|06|07|08|09|11|13|15|16|17|18|19|21|22|23|28|30|31|32|33|35|37|38|39|48|51|55|58|60|66|68|69|77|78|80|81|85|86|88|90|95|98|99))|((955)(00|01|02|05|08|09|10|11|12|15|16|18|19|22|28|33|55|56|58|59|61|65|66|67|68|69|77|80|85|86|88|89|90|91|95|96|98|99))|((957)(00|01|02|68|77|88|98|99))|((958)(03|08|10|11|15|16|21|22|25|26|27|28|29|30|32|38|39|55|56|59|65|66|68|82|87|88))|((959)(02|06|09|33|50|51|56|59|63|68|69|93|96|98|99))|((96011))|((961)(02|03|10|30|48|56|89|98))|(96315)|(96677)|(96678)|(96822)");
    jdField_e_of_type_JavaUtilRegexPattern = Pattern.compile(jdField_c_of_type_JavaLangString);
    jdField_f_of_type_JavaUtilRegexPattern = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
    jdField_b_of_type_ArrayOfJavaLangObject = new Object[0];
    jdField_a_of_type_AndroidTextSpannable$Factory = new ahzm();
    try
    {
      StaticLayout.class.getDeclaredMethod("generate2", new Class[] { CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, Float.TYPE, Float.TYPE, Boolean.TYPE, Boolean.TYPE });
      bool = true;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        boolean bool = false;
        continue;
        jdField_b_of_type_Boolean = false;
      }
    }
    if ((Build.MANUFACTURER.equals("motorola")) && (Build.VERSION.SDK_INT < 14))
    {
      jdField_b_of_type_Boolean = true;
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public QQText(CharSequence paramCharSequence, int paramInt)
  {
    this(paramCharSequence, paramInt, 32);
  }
  
  public QQText(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    this(paramCharSequence, 0, paramCharSequence.length(), paramInt1, paramInt2, -1);
  }
  
  public QQText(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected QQText(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    long l = SystemClock.uptimeMillis();
    jdField_a_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str;
    if (jdField_a_of_type_JavaLangString == null) {
      str = "";
    }
    for (;;)
    {
      jdField_a_of_type_JavaLangString = str;
      this.jdField_c_of_type_Int = paramInt5;
      paramInt5 = a(3);
      try
      {
        this.jdField_a_of_type_ArrayOfJavaLangObject = new Object[paramInt5];
        this.jdField_a_of_type_ArrayOfInt = new int[paramInt5 * 3];
        paramInt4 = (int)(paramInt4 * BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density + 0.5F);
        if (paramCharSequence == null)
        {
          this.jdField_f_of_type_JavaLangString = "";
          this.jdField_e_of_type_JavaLangString = "";
          return;
          str = jdField_a_of_type_JavaLangString;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          localOutOfMemoryError.printStackTrace();
        }
        this.jdField_e_of_type_JavaLangString = paramCharSequence.toString();
        this.jdField_f_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
        this.jdField_a_of_type_Int = paramInt3;
        if ((paramInt3 & 0x1) == 1) {
          break label169;
        }
      }
    }
    label169:
    Object localObject1;
    if ((paramInt3 & 0x6) > 0)
    {
      localObject1 = new StringBuilder(this.jdField_e_of_type_JavaLangString);
      paramInt4 = a(0, ((StringBuilder)localObject1).length(), paramInt3, paramInt4, (StringBuilder)localObject1);
      this.jdField_f_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
      if (!jdField_a_of_type_Boolean) {
        this.jdField_e_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      }
      if (paramInt4 < 10) {}
    }
    for (paramInt4 = 1;; paramInt4 = 0)
    {
      Object localObject2;
      if (paramInt4 != 0)
      {
        localObject1 = (QQText.EmoticonSpan[])getSpans(paramInt1, paramInt2, QQText.EmoticonSpan.class);
        if (localObject1 != null)
        {
          paramInt5 = localObject1.length;
          paramInt4 = 0;
          if (paramInt4 < paramInt5)
          {
            localObject2 = localObject1[paramInt4];
            if (((QQText.EmoticonSpan)localObject2).jdField_c_of_type_Int == 1) {
              ((QQText.EmoticonSpan)localObject2).jdField_a_of_type_Int &= 0x7FFFFFFF;
            }
            for (;;)
            {
              paramInt4 += 1;
              break;
              if (((QQText.EmoticonSpan)localObject2).jdField_c_of_type_Int == 2) {
                ((QQText.SmallEmojiSpan)localObject2).jdField_b_of_type_Boolean = false;
              }
            }
          }
        }
      }
      if (((paramInt3 & 0x8) == 8) && (this.jdField_f_of_type_JavaLangString != null)) {
        if ((jdField_a_of_type_JavaLangString.length() > 3) && (jdField_a_of_type_JavaLangString.charAt(jdField_a_of_type_JavaLangString.length() - 3) == '0') && (jdField_a_of_type_JavaLangString.charAt(jdField_a_of_type_JavaLangString.length() - 2) == '1'))
        {
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("length", this.jdField_f_of_type_JavaLangString.length() + "");
          localObject2 = StatisticCollector.a(BaseApplication.getContext());
          if (this.jdField_f_of_type_JavaLangString.length() >= 1000) {
            break label627;
          }
        }
      }
      label627:
      for (boolean bool = true;; bool = false)
      {
        ((StatisticCollector)localObject2).a(null, "qq_url_length_report", bool, 0L, 0L, (HashMap)localObject1, null);
        if (this.jdField_f_of_type_JavaLangString.length() < 1000) {
          a();
        }
        if (!(paramCharSequence instanceof Spanned)) {
          break;
        }
        localObject1 = (Spanned)paramCharSequence;
        localObject2 = ((Spanned)localObject1).getSpans(paramInt1, paramInt2, Object.class);
        paramInt3 = 0;
        while (paramInt3 < localObject2.length)
        {
          paramInt5 = ((Spanned)localObject1).getSpanStart(localObject2[paramInt3]);
          int i = ((Spanned)localObject1).getSpanEnd(localObject2[paramInt3]);
          int j = ((Spanned)localObject1).getSpanFlags(localObject2[paramInt3]);
          paramInt4 = paramInt5;
          if (paramInt5 < paramInt1) {
            paramInt4 = paramInt1;
          }
          paramInt5 = i;
          if (i > paramInt2) {
            paramInt5 = paramInt2;
          }
          setSpan(localObject2[paramInt3], paramInt4 - paramInt1, paramInt5 - paramInt1, j);
          paramInt3 += 1;
        }
      }
      if (SystemClock.uptimeMillis() - l <= 400L) {
        break;
      }
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("time", SystemClock.uptimeMillis() - l + "");
      if (QLog.isColorLevel()) {
        QLog.i("QQText", 2, SystemClock.uptimeMillis() - l + ", " + paramCharSequence.length() + ", " + this.jdField_b_of_type_Int);
      }
      ((HashMap)localObject1).put("length", paramCharSequence.length() + "");
      ((HashMap)localObject1).put("emoji", this.jdField_b_of_type_Int + "");
      StatisticCollector.a(BaseApplication.getContext()).a(null, "qqTextData", false, 0L, 0L, (HashMap)localObject1, null);
      return;
    }
  }
  
  public QQText(CharSequence paramCharSequence, int paramInt1, int paramInt2, MessageRecord paramMessageRecord)
  {
    this(paramCharSequence, 0, paramCharSequence.length(), paramInt1, paramInt2, -1);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
  }
  
  private static int a(int paramInt)
  {
    int j = paramInt * 4;
    paramInt = 4;
    for (;;)
    {
      int i = j;
      if (paramInt < 32)
      {
        if (j <= (1 << paramInt) - 12) {
          i = (1 << paramInt) - 12;
        }
      }
      else {
        return i / 4;
      }
      paramInt += 1;
    }
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, StringBuilder paramStringBuilder)
  {
    int i5 = paramStringBuilder.length();
    int j = 0;
    int i = 0;
    float f1 = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density;
    int i2 = (int)(22.0F * f1 + 0.5F);
    int i6 = (int)(f1 * 32.0F + 0.5F);
    int k = paramInt1;
    paramInt1 = i;
    int i7;
    boolean bool1;
    if (k < paramInt2)
    {
      i7 = paramStringBuilder.codePointAt(k);
      if ((paramInt3 & 0x4) == 4)
      {
        bool1 = true;
        label82:
        if ((i7 != 17) || (k >= i5 - 1)) {
          break label229;
        }
        i = paramStringBuilder.charAt(k + 1);
        if (i >= LoveLanguageConfig.jdField_a_of_type_ArrayOfInt.length + 30) {
          break label1253;
        }
        if (!jdField_a_of_type_Boolean) {
          break label207;
        }
        paramStringBuilder.replace(k, k + 2, "##");
        label142:
        a(new QQText.EmoticonSpan(this, i, paramInt4, 3), k, k + 4, 33);
        i = k + 3;
        k = j + 1;
        j = i;
        i = k;
        label187:
        if (i <= 512) {
          break label1237;
        }
      }
    }
    label207:
    label229:
    label1253:
    for (;;)
    {
      if (paramInt1 > 0) {}
      return paramInt1;
      bool1 = false;
      break label82;
      if (i != 10) {
        break label142;
      }
      paramStringBuilder.setCharAt(k + 1, 'ú');
      break label142;
      int m;
      if (((paramInt3 & 0x6) > 0) && (i7 == 20) && (k < i5 - 1))
      {
        m = paramStringBuilder.charAt(k + 1);
        if (m < EmotcationConstants.jdField_a_of_type_Int)
        {
          if (jdField_a_of_type_Boolean)
          {
            paramStringBuilder.replace(k, k + 2, "##");
            if (!bool1) {
              break label375;
            }
          }
          label375:
          for (i = 0x80000000 | m;; i = m)
          {
            a(new QQText.EmoticonSpan(this, i, paramInt4, 1), k, k + 2, 33);
            k += 1;
            i = j + 1;
            paramInt1 += 1;
            j = k;
            break;
            if (m != 10) {
              break label292;
            }
            paramStringBuilder.setCharAt(k + 1, 'ú');
            break label292;
          }
        }
        if ((m >= 255) && (k + 4 < i5))
        {
          char[] arrayOfChar = new char[4];
          arrayOfChar[0] = paramStringBuilder.charAt(k + 4);
          arrayOfChar[1] = paramStringBuilder.charAt(k + 3);
          arrayOfChar[2] = paramStringBuilder.charAt(k + 2);
          arrayOfChar[3] = paramStringBuilder.charAt(k + 1);
          i = 0;
          if (i < 3)
          {
            if (arrayOfChar[i] == 'ú') {
              arrayOfChar[i] = '\n';
            }
            for (;;)
            {
              i += 1;
              break;
              if (arrayOfChar[i] == 'þ') {
                arrayOfChar[i] = '\r';
              }
            }
          }
          boolean bool2;
          if (m == 511)
          {
            bool2 = true;
            a(new QQText.SmallEmojiSpan(this, arrayOfChar, paramInt4, bool1, bool2), k, k + 5, 33);
            i = 2;
            if (i >= 5) {
              break label635;
            }
            if (paramStringBuilder.charAt(k + i) != '\n') {
              break label604;
            }
            paramStringBuilder.setCharAt(k + i, 'ú');
          }
          for (;;)
          {
            i += 1;
            break label555;
            bool2 = false;
            break;
            if (paramStringBuilder.charAt(k + i) == '\r') {
              paramStringBuilder.setCharAt(k + i, 'þ');
            }
          }
          label635:
          k += 4;
          i = j + 1;
          paramInt1 += 1;
          j = k;
          break label187;
        }
        if (m != 250) {
          break label1253;
        }
        if (jdField_a_of_type_Boolean) {
          paramStringBuilder.replace(k, k + 2, "##");
        }
        if (bool1) {}
        for (i = -2147483638;; i = 10)
        {
          a(new QQText.EmoticonSpan(this, i, paramInt4, 1), k, k + 2, 33);
          k += 1;
          i = j + 1;
          paramInt1 += 1;
          j = k;
          break;
        }
      }
      int i3;
      int n;
      if ((paramInt3 & 0x1) == 1)
      {
        m = EmotcationConstants.a(i7);
        i = -1;
        i1 = 0;
        i3 = 0;
        if (i7 > 65535)
        {
          n = i3;
          if (i5 > k + 2)
          {
            i = paramStringBuilder.codePointAt(k + 2);
            n = i3;
          }
          if (EmotcationConstants.a(i)) {
            i1 = 1;
          }
          if ((m != -1) && (i1 == 0)) {
            break label1264;
          }
          i1 = EmotcationConstants.a(i7, i);
          if (i1 != -1) {
            break label1093;
          }
        }
      }
      label1127:
      label1264:
      for (int i1 = 1;; i1 = 0)
      {
        if (m != -1)
        {
          if (i1 != 0) {
            if ((i7 > 65535) && (i5 >= k + 2))
            {
              if (jdField_a_of_type_Boolean) {
                paramStringBuilder.replace(k, k + 2, "##");
              }
              i1 = 2;
              if ((i <= 65535) || (i5 < k + 2)) {
                break label1127;
              }
              if (jdField_a_of_type_Boolean) {
                paramStringBuilder.replace(k + 2, k + 4, "##");
              }
              i = i1 + 2;
              if (n == 0) {
                break label1250;
              }
              i += 1;
            }
          }
          for (;;)
          {
            if (paramInt4 == i6) {}
            for (n = i2;; n = paramInt4)
            {
              a(new QQText.EmoticonSpan(this, m, n, 0), k, k + i, 33);
              k += i - 1;
              i = j + 1;
              j = k;
              break;
              n = i3;
              if (i5 <= k + 1) {
                break label811;
              }
              int i4 = paramStringBuilder.codePointAt(k + 1);
              n = i3;
              i = i4;
              if (i4 != 65039) {
                break label811;
              }
              n = i3;
              i = i4;
              if (i5 <= k + 2) {
                break label811;
              }
              i = paramStringBuilder.codePointAt(k + 2);
              n = 1;
              break label811;
              m = i1;
              break label848;
              if (jdField_a_of_type_Boolean) {
                paramStringBuilder.replace(k, k + 1, "#");
              }
              i1 = 1;
              break label903;
              if (jdField_a_of_type_Boolean) {
                paramStringBuilder.replace(k + 2, k + 3, "#");
              }
              i = i1 + 1;
              break label949;
              if ((i7 > 65535) && (i5 >= k + 2))
              {
                if (jdField_a_of_type_Boolean) {
                  paramStringBuilder.replace(k, k + 2, "##");
                }
                i = 2;
                break label960;
              }
              if (jdField_a_of_type_Boolean) {
                paramStringBuilder.replace(k, k + 1, "#");
              }
              i = 1;
              break label960;
            }
            k = j + 1;
            j = i;
            break;
          }
        }
        i = j;
        j = k;
        break label187;
      }
    }
  }
  
  private static String a(int paramInt1, int paramInt2)
  {
    return "(" + paramInt1 + " ... " + paramInt2 + ")";
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    ActionSheet localActionSheet = ActionSheet.a(paramContext);
    if (paramInt == 0)
    {
      localActionSheet.a(String.format(paramContext.getString(2131435092), new Object[] { paramString }));
      localActionSheet.a(2131435075, 1);
      localActionSheet.a(2131435076, 1);
      localActionSheet.a(2131433015, 1);
      localActionSheet.a(2131433032, 1);
    }
    for (;;)
    {
      localActionSheet.c(2131432998);
      localActionSheet.a(new ahzn(paramInt, paramString, paramContext, localActionSheet));
      localActionSheet.show();
      return;
      if (paramInt == 1)
      {
        localActionSheet.a(String.format(paramContext.getString(2131435093), new Object[] { paramString }));
        localActionSheet.a(2131435075, 1);
        localActionSheet.a(2131435076, 1);
      }
      else
      {
        localActionSheet.a(String.format(paramContext.getString(2131435094), new Object[] { paramString }));
        localActionSheet.a(2131435077, 1);
        localActionSheet.a(2131435076, 1);
      }
    }
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      a(paramContext, paramString, i);
      return;
    }
  }
  
  private void a(Object paramObject, int paramInt1, int paramInt2)
  {
    SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])getSpans(paramInt1, paramInt2, SpanWatcher.class);
    int j = arrayOfSpanWatcher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSpanWatcher[i].onSpanAdded(this, paramObject, paramInt1, paramInt2);
      i += 1;
    }
  }
  
  private void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])getSpans(Math.min(paramInt1, paramInt3), Math.max(paramInt2, paramInt4), SpanWatcher.class);
    int j = arrayOfSpanWatcher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSpanWatcher[i].onSpanChanged(this, paramObject, paramInt1, paramInt2, paramInt3, paramInt4);
      i += 1;
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt2 < paramInt1) {
      throw new IndexOutOfBoundsException(paramString + " " + a(paramInt1, paramInt2) + " has end before start");
    }
    int i = length();
    if ((paramInt1 > i) || (paramInt2 > i)) {
      throw new IndexOutOfBoundsException(paramString + " " + a(paramInt1, paramInt2) + " ends beyond length " + i);
    }
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      throw new IndexOutOfBoundsException(paramString + " " + a(paramInt1, paramInt2) + " starts before 0");
    }
  }
  
  private static final boolean a()
  {
    StackTraceElement localStackTraceElement = new java.lang.Exception().getStackTrace()[2];
    return (("android.text.StaticLayout".equals(localStackTraceElement.getClassName())) && ("generate2".equals(localStackTraceElement.getMethodName()))) || (("android.text.Layout".equals(localStackTraceElement.getClassName())) && ("expandTab".equals(localStackTraceElement.getMethodName())));
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramString.length())
      {
        j = paramString.codePointAt(i);
        if (EmotcationConstants.jdField_a_of_type_AndroidUtilSparseIntArray.get(j, -1) < 0) {
          break label43;
        }
      }
      label43:
      for (int j = 1; j != 0; j = 0)
      {
        bool1 = true;
        return bool1;
      }
      i += 1;
    }
  }
  
  private void b(Object paramObject, int paramInt1, int paramInt2)
  {
    SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])getSpans(paramInt1, paramInt2, SpanWatcher.class);
    int j = arrayOfSpanWatcher.length;
    int i = 0;
    while (i < j)
    {
      arrayOfSpanWatcher[i].onSpanRemoved(this, paramObject, paramInt1, paramInt2);
      i += 1;
    }
  }
  
  private static void b(String paramString1, String paramString2)
  {
    if (jdField_b_of_type_JavaLangString == null) {
      return;
    }
    try
    {
      QQAppInterface localQQAppInterface1 = (QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(jdField_a_of_type_JavaLangString);
      if (paramString2 != null)
      {
        ReportController.b(localQQAppInterface1, "P_CliOper", "Grp_join", "", "send", "Clk_url", 0, 0, jdField_b_of_type_JavaLangString, "" + paramString1, "" + paramString2, "");
        return;
      }
    }
    catch (ClassCastException localClassCastException)
    {
      QQAppInterface localQQAppInterface2;
      for (;;)
      {
        localClassCastException.printStackTrace();
        localQQAppInterface2 = null;
      }
      ReportController.b(localQQAppInterface2, "P_CliOper", "Grp_join", "", "send", "Clk_item", 0, 0, jdField_b_of_type_JavaLangString, "" + paramString1, "" + paramString1, "");
      return;
    }
    catch (AccountNotMatchException paramString1) {}
  }
  
  public static boolean b(String paramString)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramString.length())
      {
        if (20 == paramString.codePointAt(i)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  SpannableString a()
  {
    SpannableString localSpannableString = new SpannableString(this.jdField_f_of_type_JavaLangString);
    TextUtils.copySpansFrom(this, 0, length(), Object.class, localSpannableString, 0);
    return localSpannableString;
  }
  
  public QQText a(String paramString, boolean paramBoolean, int... paramVarArgs)
  {
    QQText localQQText = new QQText("", 0);
    localQQText.jdField_c_of_type_Int = this.jdField_c_of_type_Int;
    localQQText.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    localQQText.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localQQText.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_ArrayOfInt.length];
    System.arraycopy(this.jdField_a_of_type_ArrayOfInt, 0, localQQText.jdField_a_of_type_ArrayOfInt, 0, this.jdField_a_of_type_ArrayOfInt.length);
    localQQText.jdField_a_of_type_ArrayOfJavaLangObject = new Object[this.jdField_a_of_type_ArrayOfJavaLangObject.length];
    System.arraycopy(this.jdField_a_of_type_ArrayOfJavaLangObject, 0, localQQText.jdField_a_of_type_ArrayOfJavaLangObject, 0, this.jdField_a_of_type_ArrayOfJavaLangObject.length);
    int i = 0;
    int j = 0;
    if (paramVarArgs.length >= 2)
    {
      i = paramVarArgs[0];
      j = (int)(paramVarArgs[1] * BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density + 0.5F);
    }
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder().append(paramString).append(this.jdField_f_of_type_JavaLangString);
      int m = paramString.length();
      int k = 0;
      while (k < localQQText.jdField_a_of_type_ArrayOfJavaLangObject.length)
      {
        this.jdField_a_of_type_ArrayOfInt[(k * 3 + 0)] += m;
        this.jdField_a_of_type_ArrayOfInt[(k * 3 + 1)] += m;
        k += 1;
      }
      if (i != 0) {
        localQQText.a(0, paramString.length(), i, j, localStringBuilder);
      }
      localQQText.jdField_e_of_type_JavaLangString = (paramString + this.jdField_e_of_type_JavaLangString);
      localQQText.jdField_f_of_type_JavaLangString = localStringBuilder.toString();
      if (paramVarArgs.length >= 3) {
        if (paramVarArgs[2] != 1) {
          break label433;
        }
      }
    }
    label433:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        localQQText.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      }
      return localQQText;
      localStringBuilder = new StringBuilder().append(paramString).append(this.jdField_f_of_type_JavaLangString);
      if (i != 0) {
        localQQText.a(this.jdField_f_of_type_JavaLangString.length(), this.jdField_f_of_type_JavaLangString.length() + paramString.length(), i, j, localStringBuilder);
      }
      this.jdField_e_of_type_JavaLangString += paramString;
      localQQText.jdField_f_of_type_JavaLangString = localStringBuilder.toString();
      break;
    }
  }
  
  public String a()
  {
    StringBuffer localStringBuffer = new StringBuffer(this.jdField_f_of_type_JavaLangString);
    int m = "[emoji]".length();
    int j = 0;
    int k = 0;
    if (j < this.jdField_b_of_type_Int)
    {
      Object localObject = this.jdField_a_of_type_ArrayOfJavaLangObject[j];
      int i = k;
      int n;
      if ((localObject instanceof QQText.EmoticonSpan))
      {
        i = this.jdField_a_of_type_ArrayOfInt[(j * 3 + 0)];
        n = this.jdField_a_of_type_ArrayOfInt[(j * 3 + 1)];
        localObject = (QQText.EmoticonSpan)localObject;
        switch (((QQText.EmoticonSpan)localObject).jdField_c_of_type_Int)
        {
        default: 
          i = k;
        }
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        localStringBuffer.replace(i + k, n + k, "[emoji]");
        i = k + (m - (n - i));
        continue;
        localObject = ((QQText.EmoticonSpan)localObject).a();
        localStringBuffer.replace(i + k, n + k, (String)localObject);
        i = k + (((String)localObject).length() - (n - i));
        continue;
        localObject = EmotcationConstants.jdField_a_of_type_ArrayOfJavaLangString[(localObject.jdField_a_of_type_Int & 0x7FFFFFFF)];
        localStringBuffer.replace(i + k, n + k, (String)localObject);
        i = k + (((String)localObject).length() - (n - i));
      }
    }
    return localStringBuffer.toString();
  }
  
  public void a()
  {
    if (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)) {}
    for (;;)
    {
      return;
      if (Patterns.jdField_b_of_type_JavaUtilRegexPattern.matcher(this.jdField_f_of_type_JavaLangString).find())
      {
        Matcher localMatcher1 = jdField_a_of_type_JavaUtilRegexPattern.matcher(this.jdField_f_of_type_JavaLangString);
        while (localMatcher1.find())
        {
          int i = localMatcher1.start();
          int j = localMatcher1.end();
          String str = this.jdField_f_of_type_JavaLangString.substring(i, j);
          if (Patterns.jdField_c_of_type_JavaUtilRegexPattern.matcher(str).find()) {
            a(new QQText.LinkSpan(this, str), i, j, 33);
          } else if (Patterns.jdField_d_of_type_JavaUtilRegexPattern.matcher(str).find()) {
            a(new QQText.LinkSpan(this, str), i, j, 33);
          } else if (jdField_c_of_type_JavaUtilRegexPattern.matcher(str).find())
          {
            if ((j - i >= 5) && (j - i <= 16))
            {
              Matcher localMatcher2 = jdField_d_of_type_JavaUtilRegexPattern.matcher(str);
              if ((j - i != 5) || (localMatcher2.find()))
              {
                char c1;
                if (i > 0)
                {
                  c1 = this.jdField_f_of_type_JavaLangString.charAt(i - 1);
                  if ((QLog.isColorLevel()) && (a(c1))) {}
                }
                else if (j < this.jdField_f_of_type_JavaLangString.length())
                {
                  c1 = this.jdField_f_of_type_JavaLangString.charAt(j);
                  if ((QLog.isColorLevel()) && (a(c1))) {}
                }
                else
                {
                  a(new QQText.LinkSpan(this, str), i, j, 33);
                }
              }
            }
          }
          else {
            a(new QQText.LinkSpan(this, str), i, j, 33);
          }
        }
      }
    }
  }
  
  public void a(View paramView, String paramString)
  {
    Object localObject = null;
    int i = paramString.lastIndexOf("#");
    if (i > 0) {
      localObject = paramString.substring(i);
    }
    paramString = URLUtil.guessUrl(paramString);
    if (localObject != null) {
      paramString = paramString + (String)localObject;
    }
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", "0X80061B1", "0X80061B1", 0, 0, "", "", "", "");
      if (TeamWorkUtils.a(paramString))
      {
        localObject = paramView.getContext();
        if (NetworkUtil.d(BaseApplication.getContext()))
        {
          localObject = new Bundle();
          ((Bundle)localObject).putString("url", paramString);
          TeamWorkDocEditBrowserActivity.a(paramView.getContext(), (Bundle)localObject, false);
          return;
        }
        QQToast.a((Context)localObject, ((Context)localObject).getResources().getString(2131432992), 0).b(((Context)localObject).getResources().getDimensionPixelSize(2131558448));
        return;
      }
      MttBrowerWrapper.a(paramView.getContext(), paramString, true, true, true, false, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      return;
    }
  }
  
  public void a(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_b_of_type_Int + 1 >= this.jdField_a_of_type_ArrayOfJavaLangObject.length)
    {
      int i = a(this.jdField_b_of_type_Int + 1);
      Object[] arrayOfObject = new Object[i];
      int[] arrayOfInt = new int[i * 3];
      System.arraycopy(this.jdField_a_of_type_ArrayOfJavaLangObject, 0, arrayOfObject, 0, this.jdField_b_of_type_Int);
      System.arraycopy(this.jdField_a_of_type_ArrayOfInt, 0, arrayOfInt, 0, this.jdField_b_of_type_Int * 3);
      this.jdField_a_of_type_ArrayOfJavaLangObject = arrayOfObject;
      this.jdField_a_of_type_ArrayOfInt = arrayOfInt;
    }
    this.jdField_a_of_type_ArrayOfJavaLangObject[this.jdField_b_of_type_Int] = paramObject;
    this.jdField_a_of_type_ArrayOfInt[(this.jdField_b_of_type_Int * 3 + 0)] = paramInt1;
    this.jdField_a_of_type_ArrayOfInt[(this.jdField_b_of_type_Int * 3 + 1)] = paramInt2;
    this.jdField_a_of_type_ArrayOfInt[(this.jdField_b_of_type_Int * 3 + 2)] = paramInt3;
    this.jdField_b_of_type_Int += 1;
  }
  
  public boolean a(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
  
  public String b()
  {
    char[] arrayOfChar = this.jdField_e_of_type_JavaLangString.toCharArray();
    int k = this.jdField_e_of_type_JavaLangString.length() - 1;
    int i = 0;
    while ((i <= k) && (arrayOfChar[i] <= ' ') && (arrayOfChar[i] != '\024')) {
      i += 1;
    }
    for (;;)
    {
      int j;
      if ((j >= i) && (arrayOfChar[j] <= ' ') && ((j == 0) || (arrayOfChar[(j - 1)] != '\024')))
      {
        j -= 1;
      }
      else
      {
        if ((i == 0) && (j == k)) {
          return this.jdField_e_of_type_JavaLangString;
        }
        return this.jdField_e_of_type_JavaLangString.substring(i, j + 1);
        j = k;
      }
    }
  }
  
  public final char charAt(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > length())) {
      return '\000';
    }
    return this.jdField_f_of_type_JavaLangString.charAt(paramInt);
  }
  
  public Object clone()
  {
    QQText localQQText = (QQText)super.clone();
    localQQText.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_ArrayOfInt.length];
    System.arraycopy(this.jdField_a_of_type_ArrayOfInt, 0, localQQText.jdField_a_of_type_ArrayOfInt, 0, this.jdField_a_of_type_ArrayOfInt.length);
    localQQText.jdField_a_of_type_ArrayOfJavaLangObject = new Object[this.jdField_a_of_type_ArrayOfJavaLangObject.length];
    System.arraycopy(this.jdField_a_of_type_ArrayOfJavaLangObject, 0, localQQText.jdField_a_of_type_ArrayOfJavaLangObject, 0, this.jdField_a_of_type_ArrayOfJavaLangObject.length);
    return localQQText;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof QQText)) {
      return this.jdField_e_of_type_JavaLangString.equals(((QQText)paramObject).jdField_e_of_type_JavaLangString);
    }
    return false;
  }
  
  public final void getChars(int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3)
  {
    int i = paramInt1;
    if (paramInt1 < 0) {
      i = 0;
    }
    int j = length();
    paramInt1 = paramInt2;
    if (paramInt2 > j) {
      paramInt1 = j;
    }
    this.jdField_f_of_type_JavaLangString.getChars(i, paramInt1, paramArrayOfChar, paramInt3);
  }
  
  public int getSpanEnd(Object paramObject)
  {
    int i = this.jdField_b_of_type_Int;
    Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    i -= 1;
    while (i >= 0)
    {
      if (arrayOfObject[i] == paramObject) {
        return arrayOfInt[(i * 3 + 1)];
      }
      i -= 1;
    }
    return -1;
  }
  
  public int getSpanFlags(Object paramObject)
  {
    int i = this.jdField_b_of_type_Int;
    Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    i -= 1;
    while (i >= 0)
    {
      if (arrayOfObject[i] == paramObject) {
        return arrayOfInt[(i * 3 + 2)];
      }
      i -= 1;
    }
    return 0;
  }
  
  public int getSpanStart(Object paramObject)
  {
    int i = this.jdField_b_of_type_Int;
    Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    i -= 1;
    while (i >= 0)
    {
      if (arrayOfObject[i] == paramObject) {
        return arrayOfInt[(i * 3 + 0)];
      }
      i -= 1;
    }
    return -1;
  }
  
  public Object[] getSpans(int paramInt1, int paramInt2, Class paramClass)
  {
    int m = this.jdField_b_of_type_Int;
    Object[] arrayOfObject2 = this.jdField_a_of_type_ArrayOfJavaLangObject;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    Object localObject = null;
    if (paramClass == null) {
      return null;
    }
    int j = 0;
    Object[] arrayOfObject1 = null;
    int i = 0;
    if (j < m)
    {
      if (!paramClass.isInstance(arrayOfObject2[j])) {}
      for (;;)
      {
        j += 1;
        break;
        int k = arrayOfInt[(j * 3 + 0)];
        int n = arrayOfInt[(j * 3 + 1)];
        if ((k <= paramInt2) && (n >= paramInt1) && ((k == n) || (paramInt1 == paramInt2) || ((k != paramInt2) && (n != paramInt1)))) {
          if (i == 0)
          {
            localObject = arrayOfObject2[j];
            i += 1;
          }
          else
          {
            if (i == 1)
            {
              arrayOfObject1 = (Object[])Array.newInstance(paramClass, m - j + 1);
              arrayOfObject1[0] = localObject;
            }
            n = 0xFF0000 & arrayOfInt[(j * 3 + 2)];
            if (n != 0)
            {
              k = 0;
              for (;;)
              {
                if ((k >= i) || (n > (getSpanFlags(arrayOfObject1[k]) & 0xFF0000)))
                {
                  System.arraycopy(arrayOfObject1, k, arrayOfObject1, k + 1, i - k);
                  arrayOfObject1[k] = arrayOfObject2[j];
                  i += 1;
                  break;
                }
                k += 1;
              }
            }
            arrayOfObject1[i] = arrayOfObject2[j];
            i += 1;
          }
        }
      }
    }
    if (i == 0) {
      return (Object[])Array.newInstance(paramClass, 0);
    }
    if (i == 1)
    {
      arrayOfObject1 = (Object[])Array.newInstance(paramClass, 1);
      if (arrayOfObject1 == null) {
        return (Object[])Array.newInstance(paramClass, 0);
      }
      arrayOfObject1[0] = localObject;
      return (Object[])arrayOfObject1;
    }
    if (i == arrayOfObject1.length) {
      return (Object[])arrayOfObject1;
    }
    paramClass = (Object[])Array.newInstance(paramClass, i);
    System.arraycopy(arrayOfObject1, 0, paramClass, 0, i);
    return (Object[])paramClass;
  }
  
  public final int length()
  {
    return this.jdField_f_of_type_JavaLangString.length();
  }
  
  public int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    int m = this.jdField_b_of_type_Int;
    Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    Object localObject = paramClass;
    if (paramClass == null) {
      localObject = Object.class;
    }
    int i = 0;
    int j;
    if (i < m)
    {
      int k = arrayOfInt[(i * 3 + 0)];
      j = arrayOfInt[(i * 3 + 1)];
      if ((k <= paramInt1) || (k >= paramInt2) || (!((Class)localObject).isInstance(arrayOfObject[i]))) {
        break label131;
      }
      paramInt2 = k;
    }
    label131:
    for (;;)
    {
      if ((j > paramInt1) && (j < paramInt2) && (((Class)localObject).isInstance(arrayOfObject[i]))) {
        paramInt2 = j;
      }
      for (;;)
      {
        i += 1;
        break;
        return paramInt2;
      }
    }
  }
  
  public void removeSpan(Object paramObject)
  {
    int j = this.jdField_b_of_type_Int;
    Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    int i = j - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if (arrayOfObject[i] == paramObject)
        {
          int k = arrayOfInt[(i * 3 + 0)];
          int m = arrayOfInt[(i * 3 + 1)];
          j -= i + 1;
          System.arraycopy(arrayOfObject, i + 1, arrayOfObject, i, j);
          System.arraycopy(arrayOfInt, (i + 1) * 3, arrayOfInt, i * 3, j * 3);
          this.jdField_b_of_type_Int -= 1;
          b(paramObject, k, m);
        }
      }
      else {
        return;
      }
      i -= 1;
    }
  }
  
  public void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    a("setSpan", paramInt1, paramInt2);
    if ((paramInt3 & 0x33) == 51)
    {
      char c1;
      if ((paramInt1 != 0) && (paramInt1 != length()))
      {
        c1 = charAt(paramInt1 - 1);
        if (c1 != '\n') {
          throw new RuntimeException("PARAGRAPH span must start at paragraph boundary (" + paramInt1 + " follows " + c1 + ")");
        }
      }
      if ((paramInt2 != 0) && (paramInt2 != length()))
      {
        c1 = charAt(paramInt2 - 1);
        if (c1 != '\n') {
          throw new RuntimeException("PARAGRAPH span must end at paragraph boundary (" + paramInt2 + " follows " + c1 + ")");
        }
      }
    }
    int j = this.jdField_b_of_type_Int;
    Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    int i = 0;
    if (i < j) {
      if (arrayOfObject[i] == paramObject)
      {
        j = arrayOfInt[(i * 3 + 0)];
        int k = arrayOfInt[(i * 3 + 1)];
        arrayOfInt[(i * 3 + 0)] = paramInt1;
        arrayOfInt[(i * 3 + 1)] = paramInt2;
        arrayOfInt[(i * 3 + 2)] = paramInt3;
        a(paramObject, j, k, paramInt1, paramInt2);
      }
    }
    do
    {
      return;
      i += 1;
      break;
      if (this.jdField_b_of_type_Int + 1 >= this.jdField_a_of_type_ArrayOfJavaLangObject.length)
      {
        i = a(this.jdField_b_of_type_Int + 1);
        arrayOfObject = new Object[i];
        arrayOfInt = new int[i * 3];
        System.arraycopy(this.jdField_a_of_type_ArrayOfJavaLangObject, 0, arrayOfObject, 0, this.jdField_b_of_type_Int);
        System.arraycopy(this.jdField_a_of_type_ArrayOfInt, 0, arrayOfInt, 0, this.jdField_b_of_type_Int * 3);
        this.jdField_a_of_type_ArrayOfJavaLangObject = arrayOfObject;
        this.jdField_a_of_type_ArrayOfInt = arrayOfInt;
      }
      this.jdField_a_of_type_ArrayOfJavaLangObject[this.jdField_b_of_type_Int] = paramObject;
      this.jdField_a_of_type_ArrayOfInt[(this.jdField_b_of_type_Int * 3 + 0)] = paramInt1;
      this.jdField_a_of_type_ArrayOfInt[(this.jdField_b_of_type_Int * 3 + 1)] = paramInt2;
      this.jdField_a_of_type_ArrayOfInt[(this.jdField_b_of_type_Int * 3 + 2)] = paramInt3;
      this.jdField_b_of_type_Int += 1;
    } while (!(this instanceof Spannable));
    a(paramObject, paramInt1, paramInt2);
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    label18:
    Object localObject;
    if (paramInt1 < 0)
    {
      paramInt1 = 0;
      int i = length();
      if (paramInt2 <= i) {
        break label47;
      }
      paramInt2 = i;
      if ((!jdField_a_of_type_Boolean) || (!a())) {
        break label50;
      }
      localObject = this.jdField_f_of_type_JavaLangString.subSequence(paramInt1, paramInt2);
    }
    label47:
    label50:
    do
    {
      return localObject;
      break;
      break label18;
      if ((Build.VERSION.SDK_INT < 26) || (paramInt1 != 0)) {
        break label73;
      }
      localObject = this;
    } while (paramInt2 == length());
    label73:
    return new QQText(this.jdField_f_of_type_JavaLangString, paramInt1, paramInt2, this.jdField_a_of_type_Int, 32, this.jdField_c_of_type_Int);
  }
  
  public String toString()
  {
    if ((jdField_a_of_type_Boolean) && (a())) {
      return this.jdField_f_of_type_JavaLangString;
    }
    return this.jdField_e_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.text.QQText
 * JD-Core Version:    0.7.0.1
 */