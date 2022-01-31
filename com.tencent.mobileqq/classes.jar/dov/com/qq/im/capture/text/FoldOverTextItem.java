package dov.com.qq.im.capture.text;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import anwn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FoldOverTextItem
  extends DynamicTextItem
{
  private static Method jdField_a_of_type_JavaLangReflectMethod;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 5, 5, 5, 5 };
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = Color.parseColor("#ffa414");
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Shader jdField_a_of_type_AndroidGraphicsShader;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private String jdField_a_of_type_JavaLangString = "";
  private List jdField_a_of_type_JavaUtilList;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = Color.parseColor("#ff1a14");
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = Color.parseColor("#1f14ff");
  private float d;
  private float e;
  private float f;
  
  public FoldOverTextItem(int paramInt, @NonNull List paramList, Typeface paramTypeface, Bitmap paramBitmap)
  {
    super(paramInt, paramList);
    a(paramTypeface, paramBitmap);
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
  }
  
  private CharSequence a(String paramString)
  {
    int m = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    int k = 0;
    int i = 0;
    int j = 0;
    if (j < paramString.length())
    {
      if ((paramString.charAt(j) != '\n') && (paramString.charAt(j) != '\r') && (i < jdField_a_of_type_ArrayOfInt[k]))
      {
        localStringBuilder.append(paramString.charAt(j));
        i += 1;
      }
      int n;
      do
      {
        j += 1;
        break;
        localStringBuilder.append('\n');
        if ((paramString.charAt(j) == '\n') || (paramString.charAt(j) == '\r')) {
          break label230;
        }
        localStringBuilder.append(paramString.charAt(j));
        i = 1;
        n = k + 1;
        k = n;
      } while (n < jdField_a_of_type_ArrayOfInt.length);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    paramString = new SpannableString(localStringBuilder.toString());
    i = 0;
    float f1 = 0.0F;
    j = m;
    label179:
    if (i < paramString.length())
    {
      if ((paramString.charAt(i) == '\n') || (paramString.charAt(i) == '\r'))
      {
        this.jdField_a_of_type_JavaUtilList.add(Float.valueOf(f1));
        f1 = 0.0F;
      }
      for (;;)
      {
        i += 1;
        break label179;
        label230:
        i = 0;
        break;
        k = (int)(this.jdField_a_of_type_Float + j * this.jdField_b_of_type_Float);
        paramString.setSpan(new AbsoluteSizeAndLineSpaceSpan(k, 0.85F), i, i + 1, 17);
        f1 += k;
        j += 1;
      }
    }
    this.jdField_a_of_type_JavaUtilList.add(Float.valueOf(f1));
    return paramString;
  }
  
  private void a(Typeface paramTypeface, Bitmap paramBitmap)
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    this.e = (localResources.getDisplayMetrics().density * 2.0F);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Float = AIOUtils.a(25.0F, localResources);
    this.jdField_b_of_type_Float = AIOUtils.a(3.0F, localResources);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.f = AIOUtils.a(2.0F, localResources);
    if (paramTypeface != null) {
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
    }
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      if (jdField_a_of_type_JavaLangReflectMethod == null) {
        jdField_a_of_type_JavaLangReflectMethod = Paint.class.getDeclaredMethod("setLetterSpacing", new Class[] { Float.TYPE });
      }
      if (jdField_a_of_type_JavaLangReflectMethod != null) {
        jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_a_of_type_AndroidTextTextPaint, new Object[] { Float.valueOf(-0.09F) });
      }
    }
    catch (Exception paramTypeface)
    {
      label169:
      break label169;
    }
    if (paramBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      this.jdField_a_of_type_AndroidGraphicsShader = new BitmapShader(this.jdField_a_of_type_AndroidGraphicsBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
    }
  }
  
  public float a()
  {
    return this.jdField_a_of_type_AndroidTextStaticLayout.getWidth() + 3.0F * this.e;
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    paramString = a(paramInt, new anwn(this));
    this.jdField_a_of_type_JavaLangString = paramString;
    int i = 0;
    Object localObject = jdField_a_of_type_ArrayOfInt;
    int j = localObject.length;
    paramInt = 0;
    while (paramInt < j)
    {
      i += localObject[paramInt];
      paramInt += 1;
    }
    if (paramString.length() > i) {
      paramString = paramString.substring(0, i);
    }
    for (;;)
    {
      localObject = a(paramString);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      for (float f1 = 0.0F; localIterator.hasNext(); f1 = Math.max(((Float)localIterator.next()).floatValue(), f1)) {}
      this.jdField_a_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a((CharSequence)localObject, 0, ((CharSequence)localObject).length(), this.jdField_a_of_type_AndroidTextTextPaint, (int)f1, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false, null, 0, jdField_a_of_type_ArrayOfInt.length);
      localObject = paramString;
      if (this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount() == 4)
      {
        paramInt = this.jdField_a_of_type_AndroidTextStaticLayout.getLineEnd(3);
        localObject = paramString;
        if (paramInt > 0)
        {
          paramInt = Math.min(paramInt, paramString.length());
          localObject = paramString.substring(0, paramInt);
          if ((!((String)localObject).endsWith("\n")) && (!((String)localObject).endsWith("\r"))) {
            break label332;
          }
        }
      }
      label332:
      for (localObject = paramString.substring(0, paramInt - 1);; localObject = paramString.substring(0, paramInt))
      {
        paramString = a((String)localObject);
        this.jdField_a_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.jdField_a_of_type_AndroidTextTextPaint, (int)f1, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false, null, 0, jdField_a_of_type_ArrayOfInt.length);
        this.jdField_c_of_type_Float = 0.0F;
        i = this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount();
        paramInt = 0;
        while (paramInt < i)
        {
          this.jdField_c_of_type_Float = Math.max(this.jdField_a_of_type_AndroidTextStaticLayout.getLineWidth(paramInt), this.jdField_c_of_type_Float);
          paramInt += 1;
        }
      }
      this.d = (this.jdField_a_of_type_AndroidTextStaticLayout.getHeight() + 3.0F * this.e);
      this.jdField_c_of_type_Float += 2.0F * this.e;
      return;
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(this.e * 2.0F, 0.0F);
    paramCanvas.save();
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL);
    paramCanvas.translate(this.e * -2.0F, this.e * 3.0F);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-16777216);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidTextTextPaint.setStrokeWidth(2.0F);
    this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    paramCanvas.restore();
    paramCanvas.save();
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL);
    paramCanvas.translate(-this.e, 1.5F * this.e);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-16777216);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidTextTextPaint.setStrokeWidth(2.0F);
    this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    paramCanvas.restore();
    paramCanvas.save();
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL);
    paramCanvas.translate(0.0F, 0.0F);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    if (this.jdField_a_of_type_AndroidGraphicsShader != null)
    {
      this.jdField_a_of_type_AndroidTextTextPaint.setShader(this.jdField_a_of_type_AndroidGraphicsShader);
      this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      this.jdField_a_of_type_AndroidTextTextPaint.setShader(null);
    }
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-16777216);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidTextTextPaint.setStrokeWidth(2.0F);
    this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    if (b(0))
    {
      int j = this.jdField_a_of_type_AndroidTextStaticLayout.getLineCount();
      int i = 0;
      float f1 = 0.0F;
      while (i < j)
      {
        f1 = Math.max(f1, this.jdField_a_of_type_AndroidTextStaticLayout.getLineWidth(i));
        i += 1;
      }
      f1 = this.jdField_c_of_type_Float;
      float f2 = this.jdField_a_of_type_AndroidTextStaticLayout.getHeight();
      float f3 = this.jdField_a_of_type_AndroidTextStaticLayout.getWidth() / 2.0F;
      this.jdField_a_of_type_AndroidGraphicsRectF.left = (this.e * -2.0F + f3 - f1 / 2.0F - this.f);
      this.jdField_a_of_type_AndroidGraphicsRectF.top = (0.0F - this.f * 3.0F);
      this.jdField_a_of_type_AndroidGraphicsRectF.right = (f1 / 2.0F + f3 + this.f * 2.0F);
      this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (f2 + this.e * 3.0F + this.f * 2.0F);
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
    }
    paramCanvas.restore();
    paramCanvas.restore();
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    return this.d;
  }
  
  public boolean b()
  {
    return (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (super.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.text.FoldOverTextItem
 * JD-Core Version:    0.7.0.1
 */