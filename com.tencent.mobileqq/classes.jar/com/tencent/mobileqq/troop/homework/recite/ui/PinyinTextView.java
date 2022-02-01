package com.tencent.mobileqq.troop.homework.recite.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.homework.recite.data.ParagraphInfo;
import com.tencent.mobileqq.troop.homework.recite.data.WordInfo;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PinyinTextView
  extends TextView
{
  float jdField_a_of_type_Float = 0.0F;
  int jdField_a_of_type_Int = 1;
  private Paint.FontMetrics jdField_a_of_type_AndroidGraphicsPaint$FontMetrics;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint = new TextPaint(1);
  PinyinTextView.DrawContext jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$DrawContext = new PinyinTextView.DrawContext(this);
  ReciteDisplayView jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView;
  private final String jdField_a_of_type_JavaLangString = "shuang";
  protected List<WordInfo> a;
  float jdField_b_of_type_Float = 0.0F;
  public int b;
  private TextPaint jdField_b_of_type_AndroidTextTextPaint = new TextPaint(1);
  private final String jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131708163);
  float jdField_c_of_type_Float = 0.0F;
  private int jdField_c_of_type_Int = 20;
  float jdField_d_of_type_Float = 0.0F;
  private final int jdField_d_of_type_Int = 141;
  float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int = 1;
  float f;
  private float g = 8.0F;
  private float h = 35.0F;
  private float i = 3.0F;
  private float j = 15.0F;
  private float k = 8.0F;
  private float l = 0.0F;
  
  public PinyinTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PinyinTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_Int = 1;
    a();
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
    this.jdField_e_of_type_Int = paramInt;
    if (a()) {
      this.jdField_c_of_type_Int = 24;
    }
    this.i = DisplayUtils.a(getContext(), 10.0F);
    if (a()) {
      this.j = DisplayUtils.a(getContext(), 18.6F);
    }
    for (this.k = DisplayUtils.a(getContext(), 18.0F);; this.k = DisplayUtils.a(getContext(), 12.0F))
    {
      this.g = this.k;
      a();
      return;
      this.j = DisplayUtils.a(getContext(), 0.5F);
    }
  }
  
  public static boolean a(char paramChar)
  {
    return (paramChar == '\'') || (paramChar == ';') || (paramChar == ',') || (paramChar == '.') || (paramChar == '?') || (paramChar == '!') || (paramChar == '"') || (paramChar == '_') || (paramChar == '-') || (paramChar == ':') || (paramChar == '@') || (paramChar == '<') || (paramChar == '>') || (paramChar == '(') || (paramChar == ')');
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
  
  float a(int paramInt)
  {
    float f1 = paramInt;
    float f2;
    do
    {
      f2 = f1 - this.jdField_a_of_type_Float - this.j;
      f1 = f2;
    } while (f2 >= this.h * 2.0F);
    f1 = f2 + this.j;
    if (f1 < this.h) {
      return DisplayUtils.a(getContext(), f1 / 2.0F) + (this.jdField_a_of_type_Float + this.j);
    }
    return DisplayUtils.a(getContext(), f1 / 2.0F);
  }
  
  public float a(String paramString)
  {
    if ((paramString.equalsIgnoreCase("…")) || (paramString.equalsIgnoreCase("─"))) {
      return this.jdField_b_of_type_Float;
    }
    return this.jdField_a_of_type_Float;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(WordInfo.COLOR_DEFAULT);
    this.jdField_b_of_type_AndroidTextTextPaint.setColor(WordInfo.COLOR_DEFAULT_PINYIN);
    float f1 = getResources().getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidTextTextPaint.setStrokeWidth(f1 * 2.0F);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(DisplayUtils.a(getContext(), this.jdField_c_of_type_Int));
    this.jdField_b_of_type_AndroidTextTextPaint.setStrokeWidth(f1);
    this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(DisplayUtils.a(getContext(), this.jdField_c_of_type_Int) / 2.0F);
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidTextTextPaint.getTextBounds(this.jdField_b_of_type_JavaLangString, 0, this.jdField_b_of_type_JavaLangString.length(), localRect);
    if (localRect.width() > localRect.height()) {}
    for (f1 = localRect.width();; f1 = localRect.height())
    {
      this.jdField_a_of_type_Float = f1;
      if (a())
      {
        this.jdField_b_of_type_AndroidTextTextPaint.getTextBounds("shuang", 0, "shuang".length(), localRect);
        this.jdField_d_of_type_Float = localRect.width();
        this.jdField_c_of_type_Float = localRect.height();
      }
      this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics();
      this.jdField_b_of_type_Float = this.jdField_a_of_type_AndroidTextTextPaint.measureText("…");
      this.jdField_e_of_type_Float = getResources().getDisplayMetrics().density;
      return;
    }
  }
  
  public void a(int paramInt, PinyinTextView.DrawContext paramDrawContext)
  {
    boolean bool3 = false;
    if ((this.jdField_e_of_type_Int == 1) && (paramInt == 0)) {
      paramDrawContext.jdField_a_of_type_Float += 2.0F * (this.jdField_a_of_type_Float + this.j);
    }
    WordInfo localWordInfo2 = (WordInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    WordInfo localWordInfo1 = null;
    paramInt += 1;
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      localWordInfo1 = (WordInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    float f1 = paramDrawContext.jdField_a_of_type_Float;
    float f2 = a(localWordInfo2.text) + f1;
    float f3 = this.j;
    boolean bool1;
    boolean bool4;
    boolean bool2;
    if (localWordInfo1 == null)
    {
      f1 = this.jdField_a_of_type_Float;
      if (f1 + (f2 + f3) - this.j <= paramDrawContext.jdField_a_of_type_Int - this.l) {
        break label321;
      }
      bool1 = c(localWordInfo2.text);
      if (localWordInfo1 == null) {
        break label307;
      }
      bool3 = b(localWordInfo1.text);
      bool4 = a(localWordInfo2.text, localWordInfo1.text);
      bool2 = bool1;
      bool1 = bool4;
    }
    for (;;)
    {
      if ((f2 - this.j > paramDrawContext.jdField_a_of_type_Int - this.l) || (bool2) || (bool3) || (bool1))
      {
        f2 = this.l;
        if (!a()) {
          break label302;
        }
      }
      label302:
      for (f1 = this.jdField_a_of_type_Float * 0.0F;; f1 = 0.0F)
      {
        paramDrawContext.jdField_a_of_type_Float = (f1 + f2);
        paramDrawContext.jdField_b_of_type_Float = (paramDrawContext.jdField_b_of_type_Float + this.k + this.jdField_a_of_type_Float + this.jdField_c_of_type_Float + this.i);
        return;
        f1 = a(localWordInfo1.text);
        break;
      }
      label307:
      bool4 = false;
      bool2 = bool1;
      bool1 = bool4;
      continue;
      label321:
      bool1 = false;
      bool2 = false;
    }
  }
  
  boolean a()
  {
    return this.jdField_e_of_type_Int == 2;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return ((paramString1.equalsIgnoreCase("…")) && (paramString2.equalsIgnoreCase("…"))) || ((paramString1.equalsIgnoreCase("─")) && (paramString2.equalsIgnoreCase("─"))) || ((paramString1.equalsIgnoreCase("-")) && (paramString2.equalsIgnoreCase("-")));
  }
  
  public void b(int paramInt, PinyinTextView.DrawContext paramDrawContext)
  {
    WordInfo localWordInfo2 = (WordInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    WordInfo localWordInfo1 = null;
    paramInt += 1;
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      localWordInfo1 = (WordInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    paramDrawContext.jdField_a_of_type_Float = (paramDrawContext.jdField_a_of_type_Float + a(localWordInfo2.text) + this.j);
    if (((localWordInfo2.text.equalsIgnoreCase("…")) || (localWordInfo2.text.equalsIgnoreCase("─")) || (localWordInfo2.text.equalsIgnoreCase("-"))) && (localWordInfo1 != null) && (localWordInfo1.text.equalsIgnoreCase(localWordInfo2.text))) {
      paramDrawContext.jdField_a_of_type_Float = (paramDrawContext.jdField_a_of_type_Float - this.j - a(localWordInfo2.text) + this.jdField_b_of_type_Float);
    }
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      paramString = paramString.toCharArray();
      int m = 0;
      while (m < paramString.length)
      {
        int n = paramString[m];
        if ((n == 39) || (n == 59) || (n == 65292) || (n == 44) || (n == 12290) || (n == 46) || (n == 65311) || (n == 63) || (n == 65281) || (n == 33) || (n == 8221) || (n == 95) || (n == 65306) || (n == 58) || (n == 64) || (n == 183) || (n == 8212) || (n == 45) || (n == 8217) || (n == 12289) || (n == 65289) || (n == 41) || (n == 12299) || (n == 12297) || (n == 62) || (n == 65307) || (n == 126)) {
          return true;
        }
        m += 1;
      }
    }
  }
  
  public boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.equalsIgnoreCase("《")) && (!paramString.equalsIgnoreCase("（")) && (!paramString.equalsIgnoreCase("(")) && (!paramString.equalsIgnoreCase("〈")) && (!paramString.equalsIgnoreCase("<")) && (!paramString.equalsIgnoreCase("‘")) && (!paramString.equalsIgnoreCase("“"))) {
      return false;
    }
    return true;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    float f1 = 0.0F;
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      PinyinTextView.DrawContext.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$DrawContext);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$DrawContext.jdField_b_of_type_Float = (this.jdField_a_of_type_Float + this.k + this.jdField_c_of_type_Float + this.i);
      this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$DrawContext.jdField_a_of_type_Int = getWidth();
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$DrawContext;
      float f2 = this.l;
      if (a()) {
        f1 = 0.0F * this.jdField_a_of_type_Float;
      }
      ((PinyinTextView.DrawContext)localObject).jdField_a_of_type_Float = (f1 + f2);
      int m = 0;
      while (m < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject = (WordInfo)this.jdField_a_of_type_JavaUtilList.get(m);
        this.jdField_a_of_type_AndroidTextTextPaint.setColor(((WordInfo)localObject).color);
        this.jdField_b_of_type_AndroidTextTextPaint.setColor(((WordInfo)localObject).colorPinyin);
        a(m, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$DrawContext);
        if (!TextUtils.isEmpty(((WordInfo)localObject).text))
        {
          if ((((WordInfo)localObject).isNormalWord()) && (a()))
          {
            f2 = this.jdField_b_of_type_AndroidTextTextPaint.measureText(((WordInfo)localObject).pinyin2Display);
            f1 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$DrawContext.jdField_a_of_type_Float;
            f2 = (this.jdField_a_of_type_Float - f2) / 2.0F;
            paramCanvas.drawText(((WordInfo)localObject).pinyin2Display.substring(0, ((WordInfo)localObject).pinyin2Display.length()), f2 + f1, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$DrawContext.jdField_b_of_type_Float - this.jdField_a_of_type_Float - this.i, this.jdField_b_of_type_AndroidTextTextPaint);
          }
          paramCanvas.drawText(((WordInfo)localObject).text, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$DrawContext.jdField_a_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$DrawContext.jdField_b_of_type_Float, this.jdField_a_of_type_AndroidTextTextPaint);
          b(m, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$DrawContext);
          WordInfo localWordInfo = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.a();
          f1 = getTop() + this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$DrawContext.jdField_b_of_type_Float + this.jdField_c_of_type_Float + this.i + this.jdField_a_of_type_Float;
          int n = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.getBottom() * 2 / 3;
          if ((localWordInfo != null) && (localWordInfo.paragraphPos == ((WordInfo)localObject).paragraphPos) && (localWordInfo.wordPos == ((WordInfo)localObject).wordPos) && (this.f != f1) && (f1 > n))
          {
            this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.a(((WordInfo)localObject).paragraphPos, f1 - n);
            this.f = f1;
          }
        }
        m += 1;
      }
    }
    super.onDraw(paramCanvas);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int m = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    if (m == 1073741824) {}
    for (m = View.MeasureSpec.getSize(paramInt1);; m = 0)
    {
      if (n == 1073741824) {
        paramInt1 = View.MeasureSpec.getSize(paramInt2);
      }
      for (;;)
      {
        paramInt2 = paramInt1;
        if (paramInt1 < 141) {
          paramInt2 = 141;
        }
        setMeasuredDimension(m, paramInt2);
        return;
        if (n == -2147483648)
        {
          if ((this.jdField_a_of_type_AndroidTextTextPaint != null) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0)) {
            paramInt1 = (int)((this.jdField_a_of_type_JavaUtilList.size() / 10 + 1) * 2 * (this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics.bottom - this.jdField_a_of_type_AndroidGraphicsPaint$FontMetrics.top) + this.g);
          }
        }
        else if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0))
        {
          paramInt1 = Math.max(this.jdField_a_of_type_JavaUtilList.size(), this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.a(((WordInfo)this.jdField_a_of_type_JavaUtilList.get(0)).paragraphPos));
          float f2;
          if (!a())
          {
            this.l = a(m);
            PinyinTextView.DrawContext.a(this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$DrawContext);
            this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$DrawContext.jdField_a_of_type_Int = m;
            this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$DrawContext.jdField_b_of_type_Float = (this.jdField_a_of_type_Float + this.k + this.jdField_c_of_type_Float + this.i);
            localObject = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$DrawContext;
            f2 = this.l;
            if (!a()) {
              break label385;
            }
          }
          label385:
          for (float f1 = this.jdField_a_of_type_Float * 0.0F;; f1 = 0.0F)
          {
            ((PinyinTextView.DrawContext)localObject).jdField_a_of_type_Float = (f1 + f2);
            paramInt1 = 0;
            while (paramInt1 < this.jdField_a_of_type_JavaUtilList.size())
            {
              a(paramInt1, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$DrawContext);
              b(paramInt1, this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$DrawContext);
              paramInt1 += 1;
            }
            f1 = paramInt1;
            f2 = this.jdField_a_of_type_Float;
            f1 = (paramInt1 - 1) * this.j + f1 * f2;
            if (f1 < m)
            {
              this.l = ((m - f1) / 2.0F);
              break;
            }
            this.l = a(m);
            break;
          }
          Object localObject = this.jdField_a_of_type_AndroidTextTextPaint.getFontMetrics();
          f1 = this.jdField_a_of_type_ComTencentMobileqqTroopHomeworkReciteUiPinyinTextView$DrawContext.jdField_b_of_type_Float;
          paramInt1 = (int)(((Paint.FontMetrics)localObject).descent + f1);
          continue;
        }
        paramInt1 = 0;
      }
    }
  }
  
  public void setWordInfos(ParagraphInfo paramParagraphInfo, int paramInt, boolean paramBoolean)
  {
    if (paramParagraphInfo == null) {}
    String[] arrayOfString1;
    String[] arrayOfString2;
    do
    {
      return;
      if (paramParagraphInfo.wordList != null)
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        if (paramBoolean)
        {
          paramParagraphInfo = paramParagraphInfo.wordList.iterator();
          while (paramParagraphInfo.hasNext())
          {
            localWordInfo = (WordInfo)paramParagraphInfo.next();
            if (localWordInfo.wordPos <= paramInt) {
              this.jdField_a_of_type_JavaUtilList.add(localWordInfo);
            }
          }
        }
        this.jdField_a_of_type_JavaUtilList = new ArrayList(paramParagraphInfo.wordList);
        requestLayout();
        invalidate();
        return;
      }
      arrayOfString1 = paramParagraphInfo.generateOrGetPinyinWithTone();
      arrayOfString2 = paramParagraphInfo.generateOrGetContents();
    } while ((arrayOfString1 == null) || (arrayOfString2 == null));
    this.jdField_a_of_type_JavaUtilList.clear();
    int m = 0;
    try
    {
      if ((m >= arrayOfString2.length) || ((paramBoolean) && (m > paramInt)))
      {
        requestLayout();
        invalidate();
        return;
      }
    }
    catch (IndexOutOfBoundsException paramParagraphInfo)
    {
      QLog.e("ReciteDetect.PinyinTextView", 2, "pinyin len:" + arrayOfString1.length + "|" + arrayOfString1.toString() + ", hanzi len:" + arrayOfString2.length + "|" + arrayOfString2.toString());
      return;
    }
    String str = arrayOfString2[m];
    if (m < arrayOfString1.length) {}
    for (WordInfo localWordInfo = arrayOfString1[m];; localWordInfo = null)
    {
      if (a(str)) {}
      for (localWordInfo = new WordInfo(null, str);; localWordInfo = new WordInfo(localWordInfo, str))
      {
        localWordInfo.wordPos = m;
        localWordInfo.paragraphPos = paramParagraphInfo.paragraphPos;
        this.jdField_a_of_type_JavaUtilList.add(localWordInfo);
        m += 1;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.PinyinTextView
 * JD-Core Version:    0.7.0.1
 */