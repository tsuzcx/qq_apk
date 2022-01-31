package dov.com.qq.im.capture.text;

import amye;
import amyf;
import amyg;
import amyh;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SupernaturalTextItem
  extends DynamicTextItem
{
  private static Resources jdField_a_of_type_AndroidContentResResources;
  private static final String jdField_a_of_type_JavaLangString = SupernaturalTextItem.class.getSimpleName();
  private static final Pattern jdField_a_of_type_JavaUtilRegexPattern = Pattern.compile("[a-zA-Z0-9.^%&',;=?$\\x22]+|[^a-zA-Z0-9.^%&',;=?$\\x22]");
  private float jdField_a_of_type_Float;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private PinYinSpan.OnPinYinDrawListener jdField_a_of_type_DovComQqImCaptureTextPinYinSpan$OnPinYinDrawListener = new amye(this);
  private float jdField_b_of_type_Float;
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private StaticLayout jdField_b_of_type_AndroidTextStaticLayout;
  private TextPaint jdField_b_of_type_AndroidTextTextPaint;
  private float jdField_c_of_type_Float;
  private RectF jdField_c_of_type_AndroidGraphicsRectF = new RectF();
  private StaticLayout jdField_c_of_type_AndroidTextStaticLayout;
  private float d;
  private float e;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k;
  private float l;
  private float m;
  private float n;
  private float o;
  
  public SupernaturalTextItem(int paramInt, @NonNull List paramList, Typeface paramTypeface, Bitmap paramBitmap)
  {
    super(paramInt, paramList);
    if (jdField_a_of_type_AndroidContentResResources == null) {
      jdField_a_of_type_AndroidContentResResources = BaseApplicationImpl.getContext().getResources();
    }
    this.jdField_a_of_type_AndroidGraphicsTypeface = paramTypeface;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    d();
    int i1 = paramList.size();
    paramInt = 0;
    while (paramInt < i1)
    {
      a(paramInt, (String)paramList.get(paramInt));
      paramInt += 1;
    }
  }
  
  private int a(String paramString)
  {
    int i2 = 0;
    int i1 = 0;
    if (i2 < paramString.length())
    {
      if (SpellUtil.a(paramString.charAt(i2))) {
        i1 += 2;
      }
      for (;;)
      {
        i2 += 1;
        break;
        i1 += 1;
      }
    }
    return i1;
  }
  
  @NonNull
  private List a(@NonNull String paramString)
  {
    paramString = jdField_a_of_type_JavaUtilRegexPattern.matcher(paramString);
    ArrayList localArrayList = new ArrayList();
    while (paramString.find())
    {
      amyh localamyh = new amyh(this, null);
      localamyh.jdField_a_of_type_Int = paramString.start();
      localamyh.b = paramString.end();
      localamyh.jdField_a_of_type_JavaLangString = paramString.group();
      localArrayList.add(localamyh);
    }
    return localArrayList;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, RectF paramRectF, PointF paramPointF)
  {
    if ((paramRectF == null) || (paramPointF == null)) {}
    do
    {
      return false;
      paramRectF = new RectF(paramRectF.left + paramPointF.x, paramRectF.top + paramPointF.y, paramRectF.right + paramPointF.x, paramRectF.bottom + paramPointF.y);
    } while ((paramFloat1 <= paramRectF.left) || (paramFloat1 >= paramRectF.right) || (paramFloat2 <= paramRectF.top) || (paramFloat2 >= paramRectF.bottom));
    return true;
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(-1);
    if (this.jdField_a_of_type_AndroidGraphicsTypeface != null) {
      this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    }
    this.jdField_b_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_b_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidTextTextPaint.setColor(-1);
    if (this.jdField_a_of_type_AndroidGraphicsTypeface != null) {
      this.jdField_b_of_type_AndroidTextTextPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
    }
    this.jdField_a_of_type_Float = AIOUtils.a(84.0F, jdField_a_of_type_AndroidContentResResources);
    this.jdField_b_of_type_Float = AIOUtils.a(60.0F, jdField_a_of_type_AndroidContentResResources);
    this.jdField_c_of_type_Float = AIOUtils.a(30.0F, jdField_a_of_type_AndroidContentResResources);
    this.h = AIOUtils.a(14.5F, jdField_a_of_type_AndroidContentResResources);
    this.i = AIOUtils.a(9.0F, jdField_a_of_type_AndroidContentResResources);
    this.o = AIOUtils.a(2.5F, jdField_a_of_type_AndroidContentResResources);
    this.j = AIOUtils.a(16.5F, jdField_a_of_type_AndroidContentResResources);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float);
    this.d = this.jdField_a_of_type_AndroidTextTextPaint.measureText("怪谈,");
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_b_of_type_Float);
    this.e = this.jdField_a_of_type_AndroidTextTextPaint.measureText("通灵者之战,");
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_c_of_type_Float);
    this.f = this.jdField_a_of_type_AndroidTextTextPaint.measureText("通灵者之战通灵者之战");
    this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(this.h);
    this.g = this.jdField_b_of_type_AndroidTextTextPaint.measureText("看 不 看 得 见 ， 都 在 你 身 边");
  }
  
  public float a()
  {
    if ((this.m == 0.0F) && (this.jdField_b_of_type_AndroidTextStaticLayout != null)) {
      return this.jdField_b_of_type_AndroidTextStaticLayout.getWidth();
    }
    return this.m;
  }
  
  public int a()
  {
    return 2;
  }
  
  public int a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = paramFloat1 / a();
    RectF localRectF1 = new RectF(this.jdField_a_of_type_AndroidGraphicsRectF.left * f1, this.jdField_a_of_type_AndroidGraphicsRectF.top * f1, this.jdField_a_of_type_AndroidGraphicsRectF.right * f1, this.jdField_a_of_type_AndroidGraphicsRectF.bottom * f1);
    RectF localRectF2 = new RectF(this.jdField_c_of_type_AndroidGraphicsRectF.left * f1, this.jdField_c_of_type_AndroidGraphicsRectF.top * f1, this.jdField_c_of_type_AndroidGraphicsRectF.right * f1, f1 * this.jdField_c_of_type_AndroidGraphicsRectF.bottom);
    PointF localPointF = new PointF(-paramFloat1 / 2.0F, -paramFloat2 / 2.0F);
    if (a(paramFloat3, paramFloat4, localRectF1, localPointF)) {
      return 0;
    }
    if (a(paramFloat3, paramFloat4, localRectF2, localPointF)) {
      return 1;
    }
    return -1;
  }
  
  public int a(@NonNull MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2, @Nullable TextLayer.TextItem paramTextItem, GestureHelper paramGestureHelper)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (paramTextItem != null) {
      return paramGestureHelper.a(paramTextItem, f1, f2);
    }
    paramMotionEvent = new PointF((paramFloat1 - a()) / 2.0F, (paramFloat2 - b()) / 2.0F);
    if (a(f1, f2, this.jdField_a_of_type_AndroidGraphicsRectF, paramMotionEvent)) {
      return 0;
    }
    if (a(f1, f2, this.jdField_c_of_type_AndroidGraphicsRectF, paramMotionEvent)) {
      return 1;
    }
    return -1;
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt < 0) || (paramInt >= a())) {
      return;
    }
    super.a(paramInt, paramString);
    Object localObject = a(paramInt, new amyf(this));
    paramString = (String)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramString = "　　";
    }
    localObject = paramString;
    int i1;
    int i2;
    if (paramInt == 0)
    {
      i1 = a(paramString);
      if (this.jdField_a_of_type_AndroidGraphicsTypeface != null) {
        this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
      }
      if (i1 > 4) {
        break label375;
      }
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float);
      i1 = (int)this.d;
      this.jdField_b_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.jdField_a_of_type_AndroidTextTextPaint, i1, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false, null, 0, 4);
      localObject = paramString;
      if (this.jdField_b_of_type_AndroidTextStaticLayout.getLineCount() == 4)
      {
        i2 = Math.min(this.jdField_b_of_type_AndroidTextStaticLayout.getLineEnd(3), paramString.length());
        localObject = paramString;
        if (i2 > 0)
        {
          localObject = paramString.substring(0, i2);
          if ((!((String)localObject).endsWith("\n")) && (!((String)localObject).endsWith("\r"))) {
            break label424;
          }
        }
      }
    }
    label424:
    for (localObject = paramString.substring(0, i2 - 1);; localObject = paramString.substring(0, i2))
    {
      this.jdField_b_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a((CharSequence)localObject, 0, ((String)localObject).length(), this.jdField_a_of_type_AndroidTextTextPaint, i1, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false, null, 0, 4);
      this.k = a(this.jdField_b_of_type_AndroidTextStaticLayout);
      if (paramInt != 1) {
        break label616;
      }
      this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(this.h);
      if (this.jdField_a_of_type_AndroidGraphicsTypeface != null) {
        this.jdField_b_of_type_AndroidTextTextPaint.setTypeface(this.jdField_a_of_type_AndroidGraphicsTypeface);
      }
      if (((String)localObject).length() <= 1) {
        break label917;
      }
      paramString = new StringBuilder();
      i1 = ((String)localObject).length();
      paramString.append(((String)localObject).charAt(0));
      paramInt = 1;
      while (paramInt < i1)
      {
        char c1 = ((String)localObject).charAt(paramInt);
        if ((c1 == '\n') || (c1 == '\r')) {
          break;
        }
        paramString.append(" ");
        paramString.append(c1);
        paramInt += 1;
      }
      label375:
      if (i1 <= 10)
      {
        this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_b_of_type_Float);
        i1 = (int)this.e;
        break;
      }
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_c_of_type_Float);
      i1 = (int)this.f;
      break;
    }
    label912:
    label917:
    for (paramString = paramString.toString();; paramString = (String)localObject)
    {
      localObject = a(paramString);
      paramString = new SpannableString(paramString);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        amyh localamyh = (amyh)((Iterator)localObject).next();
        PinYinSpan localPinYinSpan = new PinYinSpan();
        localPinYinSpan.b(this.h);
        localPinYinSpan.a(this.i);
        localPinYinSpan.b(this.jdField_a_of_type_AndroidGraphicsTypeface);
        localPinYinSpan.a(this.jdField_a_of_type_AndroidGraphicsTypeface);
        localPinYinSpan.a((int)this.o);
        localPinYinSpan.a(this.jdField_a_of_type_DovComQqImCaptureTextPinYinSpan$OnPinYinDrawListener);
        paramString.setSpan(localPinYinSpan, localamyh.jdField_a_of_type_Int, localamyh.b, 33);
      }
      this.jdField_c_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a(paramString, 0, paramString.length(), this.jdField_b_of_type_AndroidTextTextPaint, (int)this.g, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false, null, 0, 1);
      this.l = a(this.jdField_c_of_type_AndroidTextStaticLayout);
      label616:
      this.m = Math.max(this.k, this.l);
      if (this.jdField_b_of_type_AndroidTextStaticLayout != null)
      {
        if (this.jdField_c_of_type_AndroidTextStaticLayout != null) {
          this.n = (this.jdField_b_of_type_AndroidTextStaticLayout.getHeight() + this.jdField_c_of_type_AndroidTextStaticLayout.getHeight() + this.j);
        }
      }
      else
      {
        if (this.jdField_b_of_type_AndroidTextStaticLayout != null)
        {
          this.jdField_a_of_type_AndroidGraphicsRectF.left = (this.m / 2.0F - this.k / 2.0F);
          this.jdField_a_of_type_AndroidGraphicsRectF.top = 0.0F;
          this.jdField_a_of_type_AndroidGraphicsRectF.right = (this.m / 2.0F + this.k / 2.0F);
          this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (this.jdField_a_of_type_AndroidGraphicsRectF.top + this.jdField_b_of_type_AndroidTextStaticLayout.getHeight());
        }
        if (this.jdField_c_of_type_AndroidTextStaticLayout == null) {
          break;
        }
        this.jdField_b_of_type_AndroidGraphicsRectF.left = (this.m / 2.0F - this.l / 2.0F);
        paramString = this.jdField_b_of_type_AndroidGraphicsRectF;
        if (this.jdField_b_of_type_AndroidTextStaticLayout == null) {
          break label912;
        }
      }
      for (paramInt = this.jdField_b_of_type_AndroidTextStaticLayout.getHeight();; paramInt = 0)
      {
        paramString.top = (paramInt + this.j);
        this.jdField_b_of_type_AndroidGraphicsRectF.right = (this.m / 2.0F + this.l / 2.0F);
        this.jdField_b_of_type_AndroidGraphicsRectF.bottom = (this.jdField_b_of_type_AndroidGraphicsRectF.top + this.jdField_c_of_type_AndroidTextStaticLayout.getHeight());
        this.jdField_c_of_type_AndroidGraphicsRectF.left = 0.0F;
        this.jdField_c_of_type_AndroidGraphicsRectF.top = this.jdField_b_of_type_AndroidGraphicsRectF.top;
        this.jdField_c_of_type_AndroidGraphicsRectF.right = this.m;
        this.jdField_c_of_type_AndroidGraphicsRectF.bottom = this.jdField_b_of_type_AndroidGraphicsRectF.bottom;
        return;
        this.n = this.jdField_b_of_type_AndroidTextStaticLayout.getHeight();
        break;
      }
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    float f1;
    float f3;
    float f2;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      f1 = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
      f3 = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
      f2 = this.m / 2.0F;
      float f4 = f1 / 2.0F;
      f1 = this.n / 2.0F - f3 / 2.0F;
      if (this.jdField_b_of_type_AndroidTextStaticLayout != null) {
        f1 = this.jdField_b_of_type_AndroidTextStaticLayout.getHeight() / 2.0F - f3 / 2.0F;
      }
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, f2 - f4, f1, this.jdField_a_of_type_AndroidTextTextPaint);
    }
    int i1;
    if (this.jdField_b_of_type_AndroidTextStaticLayout != null)
    {
      i1 = a(b(0));
      if (i1 > 4) {
        break label315;
      }
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Float);
    }
    for (;;)
    {
      f1 = this.jdField_b_of_type_AndroidTextStaticLayout.getWidth() / 2;
      f2 = this.m / 2.0F;
      paramCanvas.save();
      paramCanvas.translate(-(f1 - f2), 0.0F);
      this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      paramCanvas.restore();
      this.n = this.jdField_b_of_type_AndroidTextStaticLayout.getHeight();
      f1 = this.jdField_b_of_type_AndroidTextStaticLayout.getHeight() + this.j;
      if (this.jdField_c_of_type_AndroidTextStaticLayout != null)
      {
        f2 = this.jdField_c_of_type_AndroidTextStaticLayout.getWidth() / 2;
        f3 = this.m / 2.0F;
        paramCanvas.save();
        paramCanvas.translate(-(f2 - f3), f1);
        this.jdField_c_of_type_AndroidTextStaticLayout.draw(paramCanvas);
        paramCanvas.restore();
        this.n = (f1 + this.jdField_c_of_type_AndroidTextStaticLayout.getHeight());
      }
      if (b(0)) {
        paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
      }
      if (b(1)) {
        paramCanvas.drawRoundRect(this.jdField_b_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
      }
      return;
      label315:
      if (i1 <= 10) {
        this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_b_of_type_Float);
      } else {
        this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_c_of_type_Float);
      }
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    if ((this.n == 0.0F) && (this.jdField_b_of_type_AndroidTextStaticLayout != null))
    {
      if (this.jdField_c_of_type_AndroidTextStaticLayout != null) {
        return this.jdField_b_of_type_AndroidTextStaticLayout.getHeight() + this.jdField_c_of_type_AndroidTextStaticLayout.getHeight() + this.j;
      }
      return this.jdField_b_of_type_AndroidTextStaticLayout.getHeight() + this.j;
    }
    return this.n;
  }
  
  public boolean b()
  {
    boolean bool = false;
    String str1 = b(0);
    String str2 = a(1, new amyg(this));
    if (((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2))) || (super.b())) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.text.SupernaturalTextItem
 * JD-Core Version:    0.7.0.1
 */