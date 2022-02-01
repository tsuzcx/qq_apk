package dov.com.qq.im.capture.text;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.capture.util.InfoStickerUtils;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper;
import java.util.List;

public class RelaxedAfternoon
  extends DynamicTextItem
{
  public static final int b;
  public static final int c;
  public static final int d;
  private float jdField_a_of_type_Float;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private InputFilter jdField_a_of_type_AndroidTextInputFilter = null;
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  TextDrawImplement jdField_a_of_type_DovComQqImCaptureTextTextDrawImplement;
  private String jdField_a_of_type_JavaLangString = "jenny";
  private float jdField_b_of_type_Float;
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private TextPaint jdField_b_of_type_AndroidTextTextPaint = new TextPaint();
  TextDrawImplement jdField_b_of_type_DovComQqImCaptureTextTextDrawImplement;
  private String jdField_b_of_type_JavaLangString = "05/09";
  TextDrawImplement jdField_c_of_type_DovComQqImCaptureTextTextDrawImplement;
  private String jdField_c_of_type_JavaLangString = "by";
  int e = 0;
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private int i;
  private int j;
  private int k = 0;
  private int l;
  private int m;
  
  static
  {
    Resources localResources = BaseApplicationImpl.getContext().getResources();
    jdField_b_of_type_Int = AIOUtils.a(18.0F, localResources);
    d = AIOUtils.a(6.0F, localResources);
    int n = DisplayUtil.a();
    jdField_c_of_type_Int = localResources.getDisplayMetrics().widthPixels - TextLayer.a - n * 2;
  }
  
  public RelaxedAfternoon(int paramInt, List<String> paramList, Typeface paramTypeface)
  {
    super(paramInt, paramList);
    this.jdField_b_of_type_AndroidTextTextPaint.setTypeface(Typeface.DEFAULT);
    this.jdField_b_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
    if (paramTypeface == null)
    {
      this.jdField_b_of_type_AndroidTextTextPaint.setTypeface(Typeface.defaultFromStyle(1));
      this.jdField_b_of_type_AndroidTextTextPaint.setAntiAlias(true);
      this.jdField_b_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.jdField_b_of_type_AndroidTextTextPaint.setTextSkewX(-0.15F);
      this.k = AIOUtils.a(41.0F, BaseApplicationImpl.getContext().getResources());
      this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(this.k);
      this.jdField_b_of_type_AndroidTextTextPaint.setColor(-1);
      this.jdField_b_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
      this.g = AIOUtils.a(34.0F, BaseApplicationImpl.getContext().getResources());
      this.h = AIOUtils.a(45.0F, BaseApplicationImpl.getContext().getResources());
      this.l = AIOUtils.a(4.0F, BaseApplicationImpl.getContext().getResources());
      this.m = AIOUtils.a(3.0F, BaseApplicationImpl.getContext().getResources());
      this.jdField_c_of_type_DovComQqImCaptureTextTextDrawImplement = new TextDrawImplement(0);
      this.jdField_c_of_type_DovComQqImCaptureTextTextDrawImplement.a(new PathDrawBackground(-1, this.l, this.m));
      this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSkewX(-0.15F);
      if (paramTypeface != null) {
        this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
      }
      this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.j = AIOUtils.a(19.0F, BaseApplicationImpl.getContext().getResources());
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.j);
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(-16777216);
      TextPaint localTextPaint = new TextPaint();
      if (paramTypeface != null) {
        localTextPaint.setTypeface(paramTypeface);
      }
      this.jdField_b_of_type_JavaLangString = InfoStickerUtils.a();
      localTextPaint.setAntiAlias(true);
      localTextPaint.setTextSkewX(-0.15F);
      localTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.i = AIOUtils.a(23.0F, BaseApplicationImpl.getContext().getResources());
      localTextPaint.setTextSize(this.i);
      localTextPaint.setColor(-1);
      this.jdField_b_of_type_DovComQqImCaptureTextTextDrawImplement = new TextDrawImplement(0);
      this.jdField_b_of_type_DovComQqImCaptureTextTextDrawImplement.a(new PathDrawBackground(-16777216, this.l, this.m));
      this.jdField_b_of_type_DovComQqImCaptureTextTextDrawImplement.a(this.jdField_b_of_type_JavaLangString, jdField_c_of_type_Int, this.i, localTextPaint);
      if (paramList != null) {
        break label566;
      }
    }
    label566:
    for (paramInt = 0;; paramInt = paramList.size())
    {
      int n = 0;
      while (n < paramInt)
      {
        a(n, (String)paramList.get(n));
        n += 1;
      }
      this.jdField_b_of_type_AndroidTextTextPaint.setTypeface(paramTypeface);
      break;
    }
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
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return 2;
  }
  
  public int a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = paramFloat1 / a();
    RectF localRectF1 = new RectF(this.jdField_b_of_type_AndroidGraphicsRectF.left * f1, this.jdField_b_of_type_AndroidGraphicsRectF.top * f1, this.jdField_b_of_type_AndroidGraphicsRectF.right * f1, this.jdField_b_of_type_AndroidGraphicsRectF.bottom * f1);
    RectF localRectF2 = new RectF(this.jdField_a_of_type_AndroidGraphicsRectF.left * f1, this.jdField_a_of_type_AndroidGraphicsRectF.top * f1, this.jdField_a_of_type_AndroidGraphicsRectF.right * f1, f1 * this.jdField_a_of_type_AndroidGraphicsRectF.bottom);
    PointF localPointF = new PointF(-paramFloat1 / 2.0F, -paramFloat2 / 2.0F);
    if (a(paramFloat3, paramFloat4, localRectF1, localPointF)) {
      return 1;
    }
    if (a(paramFloat3, paramFloat4, localRectF2, localPointF)) {
      return 0;
    }
    return -1;
  }
  
  public int a(MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2, @Nullable TextLayer.TextItem paramTextItem, GestureHelper paramGestureHelper)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (paramTextItem != null) {
      return paramGestureHelper.a(paramTextItem, f1, f2);
    }
    paramMotionEvent = new PointF((paramFloat1 - a()) / 2.0F, (paramFloat2 - b()) / 2.0F);
    if (a(f1, f2, this.jdField_b_of_type_AndroidGraphicsRectF, paramMotionEvent)) {
      return 1;
    }
    if (a(f1, f2, this.jdField_a_of_type_AndroidGraphicsRectF, paramMotionEvent)) {
      return 0;
    }
    return -1;
  }
  
  public InputFilter a()
  {
    if (this.jdField_a_of_type_AndroidTextInputFilter == null) {
      this.jdField_a_of_type_AndroidTextInputFilter = new RelaxedAfternoon.1(this, 20);
    }
    return this.jdField_a_of_type_AndroidTextInputFilter;
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((paramInt < 0) || (paramInt >= a())) {
      return;
    }
    super.a(paramInt, paramString);
    String str = super.b(paramInt);
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "　　";
    }
    this.f = AIOUtils.a(18.0F, BaseApplicationImpl.getContext().getResources());
    if (paramInt == 0)
    {
      paramString = " " + paramString;
      this.jdField_a_of_type_DovComQqImCaptureTextTextDrawImplement = new TextDrawImplement(0);
      this.jdField_a_of_type_DovComQqImCaptureTextTextDrawImplement.a(new PathDrawBackground(-16777216, this.l, this.m));
      this.jdField_a_of_type_DovComQqImCaptureTextTextDrawImplement.a(paramString, jdField_c_of_type_Int, this.k, this.jdField_b_of_type_AndroidTextTextPaint);
      this.jdField_a_of_type_Float = Math.max(this.jdField_a_of_type_DovComQqImCaptureTextTextDrawImplement.a(), this.jdField_b_of_type_DovComQqImCaptureTextTextDrawImplement.a());
      this.jdField_a_of_type_Float = Math.max(this.jdField_c_of_type_DovComQqImCaptureTextTextDrawImplement.a(), this.jdField_a_of_type_Float);
      this.jdField_b_of_type_Float = (this.jdField_a_of_type_DovComQqImCaptureTextTextDrawImplement.b() + this.g + this.jdField_b_of_type_DovComQqImCaptureTextTextDrawImplement.b() + this.h + this.jdField_c_of_type_DovComQqImCaptureTextTextDrawImplement.b());
      return;
    }
    if (paramString.length() > 18) {}
    for (this.jdField_a_of_type_JavaLangString = paramString.substring(0, 18);; this.jdField_a_of_type_JavaLangString = paramString)
    {
      this.jdField_c_of_type_DovComQqImCaptureTextTextDrawImplement.a(this.jdField_c_of_type_JavaLangString + "\n" + this.jdField_a_of_type_JavaLangString, jdField_c_of_type_Int, this.j, this.jdField_a_of_type_AndroidTextTextPaint);
      return;
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    this.e = 0;
    this.jdField_a_of_type_DovComQqImCaptureTextTextDrawImplement.a(paramCanvas, 0, this.e);
    this.e = ((int)(this.e + this.jdField_a_of_type_DovComQqImCaptureTextTextDrawImplement.b()));
    this.e += this.g;
    this.jdField_b_of_type_DovComQqImCaptureTextTextDrawImplement.a(paramCanvas, 0, this.e);
    this.e = ((int)(this.e + this.jdField_b_of_type_DovComQqImCaptureTextTextDrawImplement.b()));
    this.e += this.h;
    this.jdField_c_of_type_DovComQqImCaptureTextTextDrawImplement.a(paramCanvas, 0, this.e);
    if (super.b(1))
    {
      this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_c_of_type_DovComQqImCaptureTextTextDrawImplement.a(2, this.jdField_c_of_type_DovComQqImCaptureTextTextDrawImplement.a()));
      RectF localRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
      localRectF.top += this.e;
      localRectF = this.jdField_b_of_type_AndroidGraphicsRectF;
      localRectF.bottom += this.e;
      paramCanvas.drawRoundRect(this.jdField_b_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
    }
    this.e = ((int)(this.e + this.jdField_c_of_type_DovComQqImCaptureTextTextDrawImplement.b()));
    if (super.b(0))
    {
      this.jdField_b_of_type_AndroidGraphicsRectF.left = 0.0F;
      this.jdField_a_of_type_AndroidGraphicsRectF.top = 0.0F;
      this.jdField_a_of_type_AndroidGraphicsRectF.right = this.jdField_a_of_type_DovComQqImCaptureTextTextDrawImplement.a();
      this.jdField_a_of_type_AndroidGraphicsRectF.bottom = this.jdField_a_of_type_DovComQqImCaptureTextTextDrawImplement.b();
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    return this.jdField_b_of_type_Float;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.text.RelaxedAfternoon
 * JD-Core Version:    0.7.0.1
 */