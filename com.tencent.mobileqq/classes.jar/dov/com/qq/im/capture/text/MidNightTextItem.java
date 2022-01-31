package dov.com.qq.im.capture.text;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import anws;
import anwt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MidNightTextItem
  extends DynamicTextItem
{
  private static Resources jdField_a_of_type_AndroidContentResResources;
  private static final String jdField_a_of_type_JavaLangString = MidNightTextItem.class.getSimpleName();
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("[a-zA-Z0-9.^%&',;=?$\\x22]+|[^a-zA-Z0-9.^%&',;=?$\\x22]");
  private static final Pattern jdField_b_of_type_JavaUtilRegexPattern = Pattern.compile("[^a-zA-Z0-9\\u4e00-\\u9fa5]");
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private PinYinSpan.OnHanZiToPinYinListener jdField_a_of_type_DovComQqImCaptureTextPinYinSpan$OnHanZiToPinYinListener = new anws(this);
  private PinYinSpan jdField_a_of_type_DovComQqImCaptureTextPinYinSpan;
  private float jdField_b_of_type_Float;
  private Typeface jdField_b_of_type_AndroidGraphicsTypeface;
  private PinYinSpan jdField_b_of_type_DovComQqImCaptureTextPinYinSpan;
  private float jdField_c_of_type_Float;
  private PinYinSpan jdField_c_of_type_DovComQqImCaptureTextPinYinSpan;
  private float d;
  private float e;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k;
  
  public MidNightTextItem(int paramInt, @NonNull List paramList, Typeface paramTypeface1, Typeface paramTypeface2)
  {
    super(paramInt, paramList);
    if (jdField_a_of_type_AndroidContentResResources == null) {
      jdField_a_of_type_AndroidContentResResources = BaseApplicationImpl.getContext().getResources();
    }
    this.jdField_a_of_type_AndroidGraphicsTypeface = paramTypeface1;
    this.jdField_b_of_type_AndroidGraphicsTypeface = paramTypeface2;
    d();
    if (!paramList.isEmpty()) {
      a(0, (String)paramList.get(0));
    }
  }
  
  private StaticLayout a(@NonNull String paramString, @NonNull PinYinSpan paramPinYinSpan, int paramInt)
  {
    Object localObject = a(paramString);
    paramString = new SpannableString(paramString);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      anwt localanwt = (anwt)((Iterator)localObject).next();
      paramString.setSpan(paramPinYinSpan.clone(), localanwt.jdField_a_of_type_Int, localanwt.b, 33);
    }
    return StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.jdField_a_of_type_AndroidTextTextPaint, paramInt, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false, null, 0, 4);
  }
  
  private String a(@NonNull String paramString, float paramFloat, int paramInt)
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramFloat);
    Object localObject = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.jdField_a_of_type_AndroidTextTextPaint, paramInt, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false, null, 0, 4);
    int m = ((StaticLayout)localObject).getLineCount();
    if (m <= 1) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramInt = 0;
    while (paramInt < m)
    {
      String str = paramString.substring(((StaticLayout)localObject).getLineStart(paramInt), ((StaticLayout)localObject).getLineEnd(paramInt));
      localStringBuilder.append(str);
      if ((!str.endsWith("\n")) && (!str.endsWith("\r")) && (!str.isEmpty())) {
        localStringBuilder.append("\n");
      }
      paramInt += 1;
    }
    localObject = localStringBuilder.toString();
    paramString = (String)localObject;
    if (!((String)localObject).isEmpty()) {
      if (!((String)localObject).endsWith("\n"))
      {
        paramString = (String)localObject;
        if (!((String)localObject).endsWith("\r")) {}
      }
      else
      {
        paramString = ((String)localObject).substring(0, ((String)localObject).length() - 1);
      }
    }
    return paramString;
  }
  
  @NonNull
  private List a(@NonNull String paramString)
  {
    paramString = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
    ArrayList localArrayList = new ArrayList();
    while (paramString.find())
    {
      anwt localanwt = new anwt(this, null);
      localanwt.jdField_a_of_type_Int = paramString.start();
      localanwt.b = paramString.end();
      localanwt.jdField_a_of_type_JavaLangString = paramString.group();
      localArrayList.add(localanwt);
    }
    return localArrayList;
  }
  
  private boolean a(@NonNull String paramString, float paramFloat, int paramInt)
  {
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramFloat);
    return StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.jdField_a_of_type_AndroidTextTextPaint, paramInt, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false, null, 0, 4).getLineCount() > 1;
  }
  
  private void d()
  {
    int m = ScreenUtil.jdField_a_of_type_Int - AIOUtils.a(4.0F, jdField_a_of_type_AndroidContentResResources);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    this.jdField_a_of_type_Float = AIOUtils.a(52.0F, jdField_a_of_type_AndroidContentResResources);
    this.jdField_b_of_type_Float = AIOUtils.a(37.0F, jdField_a_of_type_AndroidContentResResources);
    this.jdField_c_of_type_Float = AIOUtils.a(29.0F, jdField_a_of_type_AndroidContentResResources);
    this.d = AIOUtils.a(12.0F, jdField_a_of_type_AndroidContentResResources);
    this.e = this.d;
    this.f = this.d;
    this.jdField_a_of_type_DovComQqImCaptureTextPinYinSpan = new PinYinSpan();
    this.jdField_a_of_type_DovComQqImCaptureTextPinYinSpan.b(this.jdField_a_of_type_AndroidGraphicsTypeface);
    this.jdField_a_of_type_DovComQqImCaptureTextPinYinSpan.a(this.jdField_b_of_type_AndroidGraphicsTypeface);
    this.jdField_a_of_type_DovComQqImCaptureTextPinYinSpan.a(this.d);
    this.jdField_a_of_type_DovComQqImCaptureTextPinYinSpan.b(this.jdField_a_of_type_Float);
    this.jdField_b_of_type_DovComQqImCaptureTextPinYinSpan = new PinYinSpan();
    this.jdField_b_of_type_DovComQqImCaptureTextPinYinSpan.b(this.jdField_a_of_type_AndroidGraphicsTypeface);
    this.jdField_b_of_type_DovComQqImCaptureTextPinYinSpan.a(this.jdField_b_of_type_AndroidGraphicsTypeface);
    this.jdField_b_of_type_DovComQqImCaptureTextPinYinSpan.a(this.e);
    this.jdField_b_of_type_DovComQqImCaptureTextPinYinSpan.b(this.jdField_b_of_type_Float);
    this.jdField_c_of_type_DovComQqImCaptureTextPinYinSpan = new PinYinSpan();
    this.jdField_c_of_type_DovComQqImCaptureTextPinYinSpan.b(this.jdField_a_of_type_AndroidGraphicsTypeface);
    this.jdField_c_of_type_DovComQqImCaptureTextPinYinSpan.a(this.jdField_b_of_type_AndroidGraphicsTypeface);
    this.jdField_c_of_type_DovComQqImCaptureTextPinYinSpan.a(this.f);
    this.jdField_c_of_type_DovComQqImCaptureTextPinYinSpan.b(this.jdField_c_of_type_Float);
    if (this.jdField_a_of_type_AndroidGraphicsTypeface != null) {
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    }
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float);
    this.g = Math.min(this.jdField_a_of_type_AndroidTextTextPaint.measureText("刚好五个字"), m);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_b_of_type_Float);
    this.h = Math.min(this.jdField_a_of_type_AndroidTextTextPaint.measureText("刚好五个字刚好十个字,"), m);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_c_of_type_Float);
    this.i = Math.min(this.jdField_a_of_type_AndroidTextTextPaint.measureText("刚好五个字刚好十个字,"), m);
    this.jdField_a_of_type_DovComQqImCaptureTextPinYinSpan.a(this.jdField_a_of_type_DovComQqImCaptureTextPinYinSpan$OnHanZiToPinYinListener);
    this.jdField_b_of_type_DovComQqImCaptureTextPinYinSpan.a(this.jdField_a_of_type_DovComQqImCaptureTextPinYinSpan$OnHanZiToPinYinListener);
    this.jdField_c_of_type_DovComQqImCaptureTextPinYinSpan.a(this.jdField_a_of_type_DovComQqImCaptureTextPinYinSpan$OnHanZiToPinYinListener);
    if (this.jdField_a_of_type_Int <= 0) {
      this.jdField_a_of_type_Int = AIOUtils.a(4.0F, jdField_a_of_type_AndroidContentResResources);
    }
  }
  
  public float a()
  {
    return this.j;
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    String str = b(paramInt);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "　　";
    }
    if (this.jdField_a_of_type_AndroidGraphicsTypeface != null) {
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    }
    if (!a(paramString, this.jdField_a_of_type_Float, (int)this.g))
    {
      this.jdField_a_of_type_AndroidTextStaticLayout = a(paramString, this.jdField_a_of_type_DovComQqImCaptureTextPinYinSpan, (int)this.g);
      paramInt = 0;
      if (paramInt == 0) {
        break label200;
      }
    }
    label200:
    for (float f1 = Math.min(a(this.jdField_a_of_type_AndroidTextStaticLayout), this.i);; f1 = a(this.jdField_a_of_type_AndroidTextStaticLayout))
    {
      this.j = f1;
      this.k = this.jdField_a_of_type_AndroidTextStaticLayout.getHeight();
      return;
      if (!a(paramString, this.jdField_b_of_type_Float, (int)this.h))
      {
        this.jdField_a_of_type_AndroidTextStaticLayout = a(paramString, this.jdField_b_of_type_DovComQqImCaptureTextPinYinSpan, (int)this.h);
        paramInt = 0;
        break;
      }
      this.jdField_a_of_type_AndroidTextStaticLayout = a(a(paramString, this.jdField_c_of_type_Float, (int)this.i), this.jdField_c_of_type_DovComQqImCaptureTextPinYinSpan, (int)this.i * 2);
      paramInt = 1;
      break;
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidTextStaticLayout != null)
    {
      float f1 = this.jdField_a_of_type_AndroidTextStaticLayout.getWidth() / 2.0F;
      float f2 = this.j / 2.0F;
      paramCanvas.save();
      paramCanvas.translate(-(f1 - f2), 0.0F);
      this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      paramCanvas.restore();
      if (b(0))
      {
        this.jdField_a_of_type_AndroidGraphicsRectF.left = 0.0F;
        this.jdField_a_of_type_AndroidGraphicsRectF.top = 0.0F;
        this.jdField_a_of_type_AndroidGraphicsRectF.right = this.j;
        this.jdField_a_of_type_AndroidGraphicsRectF.bottom = this.k;
        paramCanvas.save();
        paramCanvas.translate(0.0F, this.jdField_a_of_type_Int);
        paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
        paramCanvas.restore();
      }
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    return this.k + this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.text.MidNightTextItem
 * JD-Core Version:    0.7.0.1
 */