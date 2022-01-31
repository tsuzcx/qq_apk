package dov.com.qq.im.capture.text;

import amxx;
import amxy;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper;
import java.util.ArrayList;
import java.util.List;

public class JourneyTextItem
  extends DynamicTextItem
{
  private int jdField_a_of_type_Int = 16;
  private Resources jdField_a_of_type_AndroidContentResResources = BaseApplicationImpl.getContext().getResources();
  private NinePatch jdField_a_of_type_AndroidGraphicsNinePatch;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private String jdField_a_of_type_JavaLangString = "测试中";
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_b_of_type_Int = 8;
  private NinePatch jdField_b_of_type_AndroidGraphicsNinePatch;
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private StaticLayout jdField_b_of_type_AndroidTextStaticLayout;
  private TextPaint jdField_b_of_type_AndroidTextTextPaint;
  private int jdField_c_of_type_Int = -1;
  private RectF jdField_c_of_type_AndroidGraphicsRectF = new RectF();
  private TextPaint jdField_c_of_type_AndroidTextTextPaint;
  private int jdField_d_of_type_Int = 12;
  private RectF jdField_d_of_type_AndroidGraphicsRectF = new RectF();
  private int jdField_e_of_type_Int = 10;
  private RectF jdField_e_of_type_AndroidGraphicsRectF = new RectF();
  private int f = 15;
  private int g = 25;
  private int h = 20;
  private int i = 5;
  private int j = 3;
  private int k = -5;
  private int l;
  private int m;
  
  public JourneyTextItem(int paramInt, List paramList, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    super(paramInt, paramList);
    this.jdField_a_of_type_AndroidGraphicsNinePatch = new NinePatch(paramBitmap1, paramBitmap1.getNinePatchChunk(), null);
    this.jdField_b_of_type_AndroidGraphicsNinePatch = new NinePatch(paramBitmap2, paramBitmap2.getNinePatchChunk(), null);
    d();
    this.l = ((int)this.jdField_a_of_type_AndroidTextTextPaint.measureText("测"));
    this.m = ((int)(this.jdField_b_of_type_AndroidTextTextPaint.measureText("测") * 10.0F));
    if (paramList == null) {}
    for (paramInt = 0;; paramInt = paramList.size())
    {
      int n = 0;
      while (n < paramInt)
      {
        a(n, (String)paramList.get(n));
        QLog.i("JourneyTextItem", 2, "JourneyTextItem index: " + n + " text: " + (String)paramList.get(n));
        n += 1;
      }
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
  
  private void d()
  {
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.DEFAULT);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_c_of_type_Int);
    this.jdField_c_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_c_of_type_AndroidTextTextPaint.setTypeface(Typeface.DEFAULT);
    this.jdField_c_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidTextTextPaint.setTextSize(this.jdField_a_of_type_Int * 0.8F);
    this.jdField_c_of_type_AndroidTextTextPaint.setColor(this.jdField_c_of_type_Int);
    this.jdField_b_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_b_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidTextTextPaint.setColor(this.jdField_c_of_type_Int);
    this.jdField_b_of_type_AndroidTextTextPaint.setTextSize(this.jdField_b_of_type_Int);
  }
  
  public float a()
  {
    return (int)Math.max(this.jdField_a_of_type_AndroidGraphicsRectF.width(), this.jdField_b_of_type_AndroidGraphicsRectF.width());
  }
  
  public int a()
  {
    return 2;
  }
  
  public int a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = paramFloat1 / a();
    RectF localRectF1 = new RectF(this.jdField_a_of_type_AndroidGraphicsRectF.left * f1, this.jdField_a_of_type_AndroidGraphicsRectF.top * f1, this.jdField_a_of_type_AndroidGraphicsRectF.right * f1, this.jdField_a_of_type_AndroidGraphicsRectF.bottom * f1);
    RectF localRectF2 = new RectF(this.jdField_e_of_type_AndroidGraphicsRectF.left * f1, this.jdField_e_of_type_AndroidGraphicsRectF.top * f1, this.jdField_e_of_type_AndroidGraphicsRectF.right * f1, f1 * this.jdField_e_of_type_AndroidGraphicsRectF.bottom);
    PointF localPointF = new PointF(-paramFloat1 / 2.0F, -paramFloat2 / 2.0F);
    if (a(paramFloat3, paramFloat4, localRectF1, localPointF)) {
      return 0;
    }
    if (a(paramFloat3, paramFloat4, localRectF2, localPointF)) {
      return 1;
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
    if (a(f1, f2, this.jdField_a_of_type_AndroidGraphicsRectF, paramMotionEvent)) {
      return 0;
    }
    if (a(f1, f2, this.jdField_e_of_type_AndroidGraphicsRectF, paramMotionEvent)) {
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
    String str2 = a(paramInt, new amxx(this));
    if (QLog.isColorLevel()) {
      QLog.i("JourneyTextItem", 2, "setText index: " + paramInt + " text: " + str2);
    }
    String str1 = "";
    float f5;
    float f4;
    float f1;
    float f2;
    float f6;
    int n;
    label173:
    float f3;
    if (paramInt == 0)
    {
      paramString = TroopFileUtils.b(str2);
      this.jdField_a_of_type_JavaUtilList.clear();
      f5 = this.jdField_a_of_type_AndroidGraphicsRectF.width();
      f4 = this.jdField_a_of_type_AndroidGraphicsRectF.height();
      f1 = this.jdField_b_of_type_AndroidGraphicsRectF.width();
      this.jdField_b_of_type_AndroidGraphicsRectF.height();
      f2 = this.jdField_d_of_type_AndroidGraphicsRectF.width();
      f6 = this.jdField_d_of_type_AndroidGraphicsRectF.height();
      if (paramInt != 0) {
        break label965;
      }
      paramString = paramString.split("\n");
      int i2 = paramString.length;
      n = 0;
      paramInt = 0;
      int i1 = paramInt;
      if (n < i2)
      {
        str1 = paramString[n];
        if (str1.length() < 20) {
          break label707;
        }
        this.jdField_a_of_type_JavaUtilList.add(str1.substring(0, 5));
        this.jdField_a_of_type_JavaUtilList.add(str1.substring(5, 10));
        this.jdField_a_of_type_JavaUtilList.add(str1.substring(10, 15));
        this.jdField_a_of_type_JavaUtilList.add(str1.substring(15, 20));
        paramInt = 5;
        label274:
        if (this.jdField_a_of_type_JavaUtilList.size() < 5) {
          break label956;
        }
        this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList.subList(0, 4);
        i1 = paramInt;
      }
      paramInt = this.jdField_a_of_type_JavaUtilList.size();
      n = this.g;
      i2 = this.f;
      f5 = paramInt * this.jdField_a_of_type_Int + (n * 2 + (paramInt - 1) * i2);
      paramInt = this.h;
      n = this.jdField_e_of_type_Int;
      f4 = i1 * this.jdField_a_of_type_Int + (paramInt * 2 + (i1 - 1) * n);
      f3 = f1;
      f1 = f6;
      label387:
      paramInt = this.jdField_d_of_type_Int;
      if (f5 <= f3) {
        break label1031;
      }
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, f5, f4);
      this.jdField_d_of_type_AndroidGraphicsRectF.set((f5 - f2) * 0.5F, paramInt + f4 + this.j, f2 + (f5 - f2) * 0.5F, f4 + paramInt + f1 + this.j);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRectF.left + this.g * 0.8F, this.jdField_a_of_type_AndroidGraphicsRectF.top + this.h * 0.7F, this.jdField_a_of_type_AndroidGraphicsRectF.right - this.g * 0.8F, this.jdField_a_of_type_AndroidGraphicsRectF.bottom - this.h * 0.7F);
      this.jdField_e_of_type_AndroidGraphicsRectF.set(this.jdField_d_of_type_AndroidGraphicsRectF.left - this.g * 0.3F, this.jdField_d_of_type_AndroidGraphicsRectF.top - this.h * 0.2F, this.jdField_d_of_type_AndroidGraphicsRectF.right + this.g * 0.3F, this.jdField_d_of_type_AndroidGraphicsRectF.bottom + this.h * 0.2F);
      this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_e_of_type_AndroidGraphicsRectF.left, this.jdField_e_of_type_AndroidGraphicsRectF.bottom + this.k, f3 + this.jdField_e_of_type_AndroidGraphicsRectF.left, f1 + this.jdField_e_of_type_AndroidGraphicsRectF.bottom + this.k);
      return;
      this.jdField_a_of_type_JavaLangString = str2;
      paramString = str1;
      if (this.jdField_a_of_type_JavaLangString.length() < 20) {
        break;
      }
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.substring(0, 20);
      paramString = str1;
      break;
      label707:
      if (str1.length() > 15)
      {
        this.jdField_a_of_type_JavaUtilList.add(str1.substring(0, 5));
        this.jdField_a_of_type_JavaUtilList.add(str1.substring(5, 10));
        this.jdField_a_of_type_JavaUtilList.add(str1.substring(10, 15));
        this.jdField_a_of_type_JavaUtilList.add(str1.substring(15, str1.length()));
        paramInt = 5;
        break label274;
      }
      if (str1.length() > 10)
      {
        this.jdField_a_of_type_JavaUtilList.add(str1.substring(0, 5));
        this.jdField_a_of_type_JavaUtilList.add(str1.substring(5, 10));
        this.jdField_a_of_type_JavaUtilList.add(str1.substring(10, str1.length()));
        paramInt = 5;
        break label274;
      }
      if (str1.length() > 5)
      {
        this.jdField_a_of_type_JavaUtilList.add(str1.substring(0, 5));
        this.jdField_a_of_type_JavaUtilList.add(str1.substring(5, str1.length()));
        paramInt = 5;
        break label274;
      }
      this.jdField_a_of_type_JavaUtilList.add(str1.substring(0, str1.length()));
      paramInt = Math.max(paramInt, str1.length());
      break label274;
      label956:
      n += 1;
      break label173;
      label965:
      this.jdField_b_of_type_AndroidTextStaticLayout = StaticLayoutWithMaxLines.a(str2, 0, str2.length(), this.jdField_b_of_type_AndroidTextTextPaint, this.m, Layout.Alignment.ALIGN_NORMAL, 1.5F, 0.0F, false, null, 0, 2);
      f2 = this.jdField_b_of_type_AndroidTextStaticLayout.getLineWidth(0);
      f1 = this.jdField_b_of_type_AndroidTextStaticLayout.getHeight();
      f3 = this.i + f2;
      break label387;
      label1031:
      f6 = (f3 - f5) * 0.5F;
      this.jdField_a_of_type_AndroidGraphicsRectF.set(f6, 0.0F, f5 + f6, f4);
      this.jdField_d_of_type_AndroidGraphicsRectF.set((f3 - f2) * 0.5F, paramInt + f4 + this.j, f2 + (f3 - f2) * 0.5F, f4 + paramInt + f1 + this.j);
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (b(0)) {
      paramCanvas.drawRoundRect(this.jdField_c_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
    }
    if (b(1)) {
      paramCanvas.drawRoundRect(this.jdField_e_of_type_AndroidGraphicsRectF, 6.0F, 6.0F, a());
    }
    this.jdField_a_of_type_AndroidGraphicsNinePatch.draw(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRectF);
    this.jdField_b_of_type_AndroidGraphicsNinePatch.draw(paramCanvas, this.jdField_b_of_type_AndroidGraphicsRectF);
    int i1 = (int)(this.jdField_a_of_type_AndroidGraphicsRectF.left + this.g * 1.3D);
    int n = (int)(this.h + this.l * 0.8D);
    int i2 = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i2 >= 0)
    {
      String str = (String)this.jdField_a_of_type_JavaUtilList.get(i2);
      int i5 = str.length();
      int i4 = 0;
      int i3 = n;
      n = i4;
      while (n < i5)
      {
        paramCanvas.drawText(str.substring(n, n + 1), i1, i3, this.jdField_a_of_type_AndroidTextTextPaint);
        i3 += this.l + this.jdField_e_of_type_Int;
        n += 1;
      }
      i3 = this.l;
      i4 = this.f;
      n = (int)(this.h + this.l * 0.8D);
      i2 -= 1;
      i1 += i3 + i4;
    }
    paramCanvas.translate(this.jdField_d_of_type_AndroidGraphicsRectF.left, this.jdField_d_of_type_AndroidGraphicsRectF.top);
    if (this.jdField_b_of_type_AndroidTextStaticLayout != null) {
      this.jdField_b_of_type_AndroidTextStaticLayout.draw(paramCanvas);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public float b()
  {
    return this.jdField_b_of_type_AndroidGraphicsRectF.bottom - this.jdField_a_of_type_AndroidGraphicsRectF.top;
  }
  
  public boolean b()
  {
    boolean bool = false;
    String str1 = a(0, new amxy(this));
    String str2 = b(1);
    if (((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2))) || (super.b())) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.text.JourneyTextItem
 * JD-Core Version:    0.7.0.1
 */