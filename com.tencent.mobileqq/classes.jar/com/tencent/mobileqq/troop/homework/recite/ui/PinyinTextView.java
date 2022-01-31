package com.tencent.mobileqq.troop.homework.recite.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.FontMetrics;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.tencent.mobileqq.troop.homework.recite.data.ParagraphInfo;
import com.tencent.mobileqq.troop.homework.recite.data.WordInfo;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class PinyinTextView
  extends TextView
{
  private static final String jdField_a_of_type_JavaLangString = PinyinTextView.class.getSimpleName();
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int = 1;
  private Paint.FontMetrics jdField_a_of_type_AndroidGraphicsPaint$FontMetrics;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint(1);
  ReciteDisplayView jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView;
  protected List a;
  private int[] jdField_a_of_type_ArrayOfInt = { Color.parseColor("#424245"), Color.parseColor("#FF7474"), -7829368 };
  float jdField_b_of_type_Float = 0.0F;
  public int b;
  private TextPaint jdField_b_of_type_AndroidTextTextPaint = new TextPaint(1);
  private final String jdField_b_of_type_JavaLangString = "shuang";
  float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = 20;
  private final String jdField_c_of_type_JavaLangString = "爽";
  float jdField_d_of_type_Float;
  private final int jdField_d_of_type_Int = 141;
  private float jdField_e_of_type_Float = 8.0F;
  private final int jdField_e_of_type_Int = 60;
  private float jdField_f_of_type_Float = 50.0F;
  private final int jdField_f_of_type_Int = 100;
  private float jdField_g_of_type_Float = 3.0F;
  private int jdField_g_of_type_Int = 1;
  private float h = 15.0F;
  private float i = 8.0F;
  private float j;
  
  public PinyinTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PinyinTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PinyinTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = 1;
    a();
  }
  
  public PinyinTextView(ReciteDisplayView paramReciteDisplayView, Context paramContext, int paramInt)
  {
    this(paramContext, null);
    this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView = paramReciteDisplayView;
    this.jdField_g_of_type_Int = paramInt;
    if (this.jdField_g_of_type_Int == 2) {
      this.jdField_c_of_type_Int = 30;
    }
    this.jdField_g_of_type_Float = DisplayUtils.a(getContext(), this.jdField_g_of_type_Float);
    this.h = DisplayUtils.a(getContext(), this.jdField_c_of_type_Int / 2);
    this.i = DisplayUtils.a(getContext(), this.jdField_c_of_type_Int * 2 / 3);
    this.jdField_e_of_type_Float = this.i;
  }
  
  public static boolean a(char paramChar)
  {
    return (paramChar == '\'') || (paramChar == ';') || (paramChar == ',') || (paramChar == '.') || (paramChar == '?') || (paramChar == '!') || (paramChar == '"') || (paramChar == '_') || (paramChar == '-') || (paramChar == ':') || (paramChar == '@');
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    boolean bool;
    do
    {
      do
      {
        return false;
        paramString = paramString.toCharArray();
      } while (paramString.length >= 0);
      char c1 = paramString[0];
      bool = a(c1);
      paramString = Character.UnicodeBlock.of(c1);
      if ((bool) || (paramString == Character.UnicodeBlock.GENERAL_PUNCTUATION) || (paramString == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION) || (paramString == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) || (paramString == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS)) {
        return true;
      }
    } while ((Build.VERSION.SDK_INT < 19) || ((!bool) && (paramString != Character.UnicodeBlock.VERTICAL_FORMS)));
    return true;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_a_of_type_ArrayOfInt[0]);
    this.jdField_b_of_type_AndroidTextTextPaint.setColor(this.jdField_a_of_type_ArrayOfInt[0]);
    float f1 = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidTextTextPaint.setStrokeWidth(f1 * 2.0F);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(DisplayUtils.a(getContext(), this.jdField_c_of_type_Int));
    this.jdField_b_of_type_AndroidTextTextPaint.setStrokeWidth(f1);
    this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(DisplayUtils.a(getContext(), this.jdField_c_of_type_Int) / 2.0F);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_AndroidTextTextPaint.measureText("爽");
    if (this.jdField_g_of_type_Int == 2) {
      this.jdField_b_of_type_Float = this.jdField_b_of_type_AndroidTextTextPaint.measureText("shuang");
    }
    this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics();
    this.jdField_c_of_type_Float = getResources().getDisplayMetrics().density;
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      paramString = paramString.toCharArray();
      int k = 0;
      while (k < paramString.length)
      {
        int m = paramString[k];
        if ((m == 39) || (m == 59) || (m == 65292) || (m == 12290) || (m == 65311) || (m == 65281) || (m == 8220) || (m == 8221) || (m == 95) || (m == 45) || (m == 65306) || (m == 64)) {
          return true;
        }
        k += 1;
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    float f2 = this.j;
    float f1;
    int k;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      f1 = this.jdField_a_of_type_Float;
      f1 = this.i + f1;
      k = 0;
      if (k < this.jdField_a_of_type_JavaUtilList.size())
      {
        if ((this.jdField_g_of_type_Int != 1) || (k != 0)) {
          break label580;
        }
        f2 += 2.0F * (this.jdField_a_of_type_Float + this.h);
      }
    }
    label568:
    label580:
    for (;;)
    {
      WordInfo localWordInfo = (WordInfo)this.jdField_a_of_type_JavaUtilList.get(k);
      int m = localWordInfo.color;
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(m);
      this.jdField_b_of_type_AndroidTextTextPaint.setColor(m);
      Object localObject = localWordInfo.pinyin2Display;
      String str = localWordInfo.text;
      float f4 = f1;
      float f5 = f2;
      int n;
      float f3;
      if (!TextUtils.isEmpty(str))
      {
        n = getWidth();
        f3 = f2 + this.jdField_a_of_type_Float;
        if (str.equalsIgnoreCase("《")) {
          break label568;
        }
      }
      for (m = 1;; m = 0)
      {
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (this.h + f3 + this.jdField_a_of_type_Float > n - this.j)
        {
          int i1 = k + 1;
          bool1 = bool2;
          if (i1 < this.jdField_a_of_type_JavaUtilList.size()) {
            bool1 = b(((WordInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).text);
          }
        }
        if ((f3 <= n - this.j) && (m != 0))
        {
          f3 = f1;
          if (!bool1) {}
        }
        else
        {
          f2 = this.j;
          f3 = this.i;
          f4 = this.jdField_a_of_type_Float;
          f5 = this.jdField_b_of_type_Float;
          f3 = this.jdField_g_of_type_Float + (f3 + f1 + f4 + f5);
          this.jdField_b_of_type_Int += 1;
        }
        if ((localWordInfo.isNormalWord()) && (this.jdField_g_of_type_Int == 2))
        {
          f1 = this.jdField_b_of_type_AndroidTextTextPaint.measureText((String)localObject);
          f1 = (this.jdField_a_of_type_Float - f1) / 2.0F;
          paramCanvas.drawText(((String)localObject).substring(0, ((String)localObject).length()), f1 + f2, f3 - this.jdField_a_of_type_Float - this.jdField_g_of_type_Float, this.jdField_b_of_type_AndroidTextTextPaint);
        }
        paramCanvas.drawText(str, f2, f3, this.jdField_a_of_type_AndroidTextTextPaint);
        f1 = this.jdField_a_of_type_Float;
        f1 = this.h + (f1 + f2);
        localObject = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.a();
        f2 = getTop() + f3;
        f4 = f3;
        f5 = f1;
        if (this.jdField_d_of_type_Float != f2)
        {
          f4 = f3;
          f5 = f1;
          if (localObject != null)
          {
            f4 = f3;
            f5 = f1;
            if (((WordInfo)localObject).paragraphPos == localWordInfo.paragraphPos)
            {
              f4 = f3;
              f5 = f1;
              if (((WordInfo)localObject).wordPos == localWordInfo.wordPos)
              {
                f4 = f3;
                f5 = f1;
                if (f2 > this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.getBottom())
                {
                  this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.a(f2);
                  this.jdField_d_of_type_Float = f2;
                  f5 = f1;
                  f4 = f3;
                }
              }
            }
          }
        }
        k += 1;
        f2 = f5;
        f1 = f4;
        break;
      }
      super.onDraw(paramCanvas);
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = 0;
    int k = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    if (k == 1073741824) {}
    label572:
    for (k = View.MeasureSpec.getSize(paramInt1);; k = 0)
    {
      if (n == 1073741824) {
        paramInt1 = View.MeasureSpec.getSize(paramInt2);
      }
      do
      {
        do
        {
          for (;;)
          {
            paramInt2 = paramInt1;
            if (paramInt1 < 141) {
              paramInt2 = 141;
            }
            setMeasuredDimension(k, paramInt2);
            return;
            if (n != -2147483648) {
              break;
            }
            paramInt1 = m;
            if (this.jdField_a_of_type_AndroidTextTextPaint != null)
            {
              paramInt1 = m;
              if (this.jdField_a_of_type_JavaUtilList != null)
              {
                paramInt1 = m;
                if (this.jdField_a_of_type_JavaUtilList.size() != 0) {
                  paramInt1 = (int)((this.jdField_a_of_type_JavaUtilList.size() / 10 + 1) * 2 * (this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics.bottom - this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics.top) + this.jdField_e_of_type_Float);
                }
              }
            }
          }
          paramInt1 = m;
        } while (this.jdField_a_of_type_JavaUtilList == null);
        paramInt1 = m;
      } while (this.jdField_a_of_type_JavaUtilList.size() == 0);
      paramInt1 = Math.max(this.jdField_a_of_type_JavaUtilList.size(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.a(((WordInfo)this.jdField_a_of_type_JavaUtilList.get(0)).paragraphPos));
      label226:
      float f3;
      float f1;
      float f2;
      if (this.jdField_g_of_type_Int != 2)
      {
        this.j = this.jdField_f_of_type_Float;
        f3 = this.jdField_a_of_type_Float + this.i;
        f1 = f3;
        paramInt1 = 0;
        f2 = 0.0F;
        label245:
        if (paramInt1 >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label572;
        }
        if ((this.jdField_g_of_type_Int != 1) || (paramInt1 != 0)) {
          break label601;
        }
        f2 += 2.0F * (this.jdField_a_of_type_Float + this.h);
      }
      label336:
      label598:
      label601:
      for (;;)
      {
        float f4 = f2 + this.jdField_a_of_type_Float;
        WordInfo localWordInfo = (WordInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt1);
        float f5;
        if ((!TextUtils.isEmpty(localWordInfo.text)) && (!localWordInfo.text.equalsIgnoreCase("《")))
        {
          paramInt2 = 1;
          boolean bool2 = false;
          boolean bool1 = bool2;
          if (this.h + f4 + this.jdField_a_of_type_Float > k - 2.0F * this.j)
          {
            m = paramInt1 + 1;
            bool1 = bool2;
            if (m < this.jdField_a_of_type_JavaUtilList.size()) {
              bool1 = b(((WordInfo)this.jdField_a_of_type_JavaUtilList.get(m)).text);
            }
          }
          if ((f4 <= k - 2.0F * this.j) && (paramInt2 != 0) && (!bool1)) {
            break label598;
          }
          f4 = this.i;
          f5 = this.jdField_a_of_type_Float;
          float f6 = this.jdField_b_of_type_Float;
          float f7 = this.jdField_g_of_type_Float;
          f2 = 0.0F;
          f1 = f7 + (f4 + f1 + f5 + f6);
        }
        for (;;)
        {
          f4 = this.jdField_a_of_type_Float;
          f5 = this.h;
          paramInt1 += 1;
          f2 = f5 + (f2 + f4);
          break label245;
          f1 = paramInt1;
          f2 = this.jdField_a_of_type_Float;
          f1 = (paramInt1 - 1) * this.h + f1 * f2;
          if (f1 < k)
          {
            this.j = ((k - f1) / 2.0F);
            break label226;
          }
          this.j = this.jdField_f_of_type_Float;
          break label226;
          paramInt2 = 0;
          break label336;
          paramInt1 = (int)(f1 - f3 + 2.0F * this.jdField_a_of_type_Float + this.jdField_g_of_type_Float + this.jdField_b_of_type_Float);
          break;
        }
      }
    }
  }
  
  public void setWordInfos(ParagraphInfo paramParagraphInfo)
  {
    if (paramParagraphInfo == null) {}
    String[] arrayOfString1;
    String[] arrayOfString2;
    do
    {
      return;
      if (paramParagraphInfo.wordList != null)
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList(paramParagraphInfo.wordList);
        requestLayout();
        invalidate();
        return;
      }
      arrayOfString1 = paramParagraphInfo.generateOrgetDisplayPinyins();
      arrayOfString2 = paramParagraphInfo.generateOrGetContents();
    } while ((arrayOfString1 == null) || (arrayOfString2 == null));
    this.jdField_a_of_type_JavaUtilList.clear();
    int k = 0;
    for (;;)
    {
      try
      {
        if (k < arrayOfString2.length)
        {
          String str = arrayOfString2[k];
          if (k >= arrayOfString1.length) {
            break label219;
          }
          paramParagraphInfo = arrayOfString1[k];
          if (a(str))
          {
            paramParagraphInfo = new WordInfo(null, str);
            this.jdField_a_of_type_JavaUtilList.add(paramParagraphInfo);
            k += 1;
            continue;
          }
          paramParagraphInfo = new WordInfo(paramParagraphInfo, str);
          continue;
        }
        requestLayout();
      }
      catch (IndexOutOfBoundsException paramParagraphInfo)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "pinyin len:" + arrayOfString1.length + "|" + arrayOfString1.toString() + ", hanzi len:" + arrayOfString2.length + "|" + arrayOfString2.toString());
        return;
      }
      invalidate();
      return;
      label219:
      paramParagraphInfo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.PinyinTextView
 * JD-Core Version:    0.7.0.1
 */