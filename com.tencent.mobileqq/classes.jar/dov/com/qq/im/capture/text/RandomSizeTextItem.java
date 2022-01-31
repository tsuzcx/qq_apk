package dov.com.qq.im.capture.text;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.DisplayMetrics;
import anwv;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomSizeTextItem
  extends DynamicTextItem
{
  private float jdField_a_of_type_Float;
  public int a;
  Context jdField_a_of_type_AndroidContentContext;
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private String jdField_a_of_type_JavaLangString = "";
  Random jdField_a_of_type_JavaUtilRandom = new Random();
  public int[] a;
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  StaticLayout jdField_b_of_type_AndroidTextStaticLayout;
  
  public RandomSizeTextItem(Context paramContext, int paramInt, List paramList, Typeface paramTypeface)
  {
    super(paramInt, paramList);
    this.jdField_a_of_type_ArrayOfInt = new int[] { 12, 20, 24 };
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = a(paramContext, 235.0F);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(AIOUtils.a(28.0F, paramContext.getResources()));
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().scaledDensity * paramFloat + 0.5F);
  }
  
  public float a()
  {
    if (this.jdField_b_of_type_AndroidTextStaticLayout != null) {
      return this.jdField_b_of_type_AndroidTextStaticLayout.getWidth();
    }
    return 0.0F;
  }
  
  public int a()
  {
    return 1;
  }
  
  public CharSequence a(String[] paramArrayOfString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("“");
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      ((StringBuilder)localObject).append(paramArrayOfString[i]);
      i += 1;
    }
    ((StringBuilder)localObject).append("”");
    paramArrayOfString = a(paramArrayOfString);
    paramArrayOfString.add(0, Integer.valueOf(48));
    paramArrayOfString.add(Integer.valueOf(48));
    localObject = new SpannableString(((StringBuilder)localObject).toString());
    j = ((SpannableString)localObject).length();
    i = 1;
    while (i < j - 1)
    {
      ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan(AIOUtils.a(((Integer)paramArrayOfString.get(i)).intValue(), this.jdField_a_of_type_AndroidContentContext.getResources())), i, i + 1, 33);
      i += 1;
    }
    return localObject;
  }
  
  public ArrayList a(String[] paramArrayOfString)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localArrayList2.add(Integer.valueOf(localObject[i]));
      i += 1;
    }
    Collections.shuffle(localArrayList2);
    int m = paramArrayOfString.length;
    j = 0;
    i = 0;
    while (j < m)
    {
      localObject = paramArrayOfString[j];
      Integer localInteger = (Integer)localArrayList2.get(i % localArrayList2.size());
      int n = ((String)localObject).length();
      int k = 0;
      if (k < n)
      {
        int i1 = ((String)localObject).charAt(k);
        if ((i1 == 8220) || (i1 == 8221)) {
          localArrayList1.add(Integer.valueOf(48));
        }
        for (;;)
        {
          k += 1;
          break;
          localArrayList1.add(localInteger);
        }
      }
      j += 1;
      i += 1;
    }
    return localArrayList1;
  }
  
  @TargetApi(18)
  public void a(int paramInt, String paramString)
  {
    float f2 = 0.0F;
    int i = 0;
    if ((TextUtils.equals(a(0), paramString)) && (this.jdField_b_of_type_AndroidTextStaticLayout != null)) {
      return;
    }
    super.a(paramInt, paramString);
    paramString = a(paramInt, new anwv(this));
    this.jdField_a_of_type_JavaLangString = paramString;
    if (0 == 0) {}
    for (paramString = a(paramString);; paramString = null)
    {
      paramString = a(paramString);
      this.jdField_b_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.jdField_a_of_type_AndroidTextTextPaint, this.jdField_a_of_type_Int, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false, null, 0, 3);
      int j = this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount();
      paramInt = i;
      float f1 = f2;
      if (j >= 3)
      {
        paramInt = this.jdField_b_of_type_AndroidTextStaticLayout.getLineEnd(2);
        paramString = paramString.subSequence(0, paramInt - 1) + "”";
        this.jdField_b_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.jdField_a_of_type_AndroidTextTextPaint, this.jdField_a_of_type_Int, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false, null, 0, 3);
        f1 = f2;
        paramInt = i;
      }
      while (paramInt < j)
      {
        f1 = Math.max(f1, this.jdField_b_of_type_AndroidTextStaticLayout.getLineWidth(paramInt));
        paramInt += 1;
      }
      this.jdField_a_of_type_Float = f1;
      return;
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_AndroidTextStaticLayout != null)
    {
      paramCanvas.save();
      paramCanvas.translate(0.0F, 0.0F);
      this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      if (b(0))
      {
        int i = AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        this.jdField_b_of_type_AndroidGraphicsRectF.left = i;
        this.jdField_b_of_type_AndroidGraphicsRectF.top = (-i);
        this.jdField_b_of_type_AndroidGraphicsRectF.right = (a() + i);
        RectF localRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
        float f = b();
        localRectF.bottom = (i + f);
        paramCanvas.drawRoundRect(this.jdField_b_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
      }
      paramCanvas.restore();
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String[] a(String paramString)
  {
    int i = 0;
    int j = 0;
    int k = paramString.length();
    String[] arrayOfString1;
    if (k <= 7)
    {
      arrayOfString2 = new String[k];
      i = j;
      for (;;)
      {
        arrayOfString1 = arrayOfString2;
        if (i >= k) {
          break;
        }
        arrayOfString2[i] = paramString.substring(i, i + 1);
        i += 1;
      }
    }
    String[] arrayOfString2 = new String[7];
    j = 0;
    for (;;)
    {
      arrayOfString1 = arrayOfString2;
      if (i >= 7) {
        break;
      }
      int m = this.jdField_a_of_type_JavaUtilRandom.nextInt(k - (7 - i) + 1) + 1;
      k -= m;
      arrayOfString2[i] = paramString.substring(j, j + m);
      j += m;
      i += 1;
    }
    return arrayOfString1;
  }
  
  public float b()
  {
    if (this.jdField_b_of_type_AndroidTextStaticLayout != null) {
      return this.jdField_b_of_type_AndroidTextStaticLayout.getHeight();
    }
    return 0.0F;
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (super.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.text.RandomSizeTextItem
 * JD-Core Version:    0.7.0.1
 */