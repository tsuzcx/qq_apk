package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import anzj;
import bhga;
import bqth;
import bqti;
import bqtj;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zoc;
import zqb;

public class VideoCoverSegmentRangeView
  extends View
  implements bqtj
{
  private float jdField_a_of_type_Float = 8.0F;
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private bqti jdField_a_of_type_Bqti;
  private WeakReference<bqth> jdField_a_of_type_JavaLangRefWeakReference;
  private List<Bitmap> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = 4.0F;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private boolean jdField_b_of_type_Boolean = true;
  private float jdField_c_of_type_Float = 10.0F;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = -1L;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int = 7;
  private long jdField_d_of_type_Long = -1L;
  private float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private float jdField_f_of_type_Float;
  private int jdField_f_of_type_Int;
  private int g;
  
  public VideoCoverSegmentRangeView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public VideoCoverSegmentRangeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private static float a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0.0F;
    }
    return paramResources.getDisplayMetrics().density * paramFloat;
  }
  
  private float a(long paramLong)
  {
    long l;
    if (paramLong < 0L) {
      l = 0L;
    }
    for (;;)
    {
      paramLong = l;
      if (this.jdField_a_of_type_Boolean) {
        paramLong = this.jdField_a_of_type_Long - l;
      }
      return (float)((float)((getWidth() - this.jdField_b_of_type_Int) * paramLong) * 1.0F / (float)this.jdField_a_of_type_Long);
      l = paramLong;
      if (paramLong > this.jdField_a_of_type_Long) {
        l = this.jdField_a_of_type_Long;
      }
    }
  }
  
  public static float a(Context paramContext, float paramFloat)
  {
    if (paramContext == null) {
      return paramFloat;
    }
    return a(paramFloat / 2.0F, paramContext.getResources());
  }
  
  private int a(float paramFloat)
  {
    if ((paramFloat > this.jdField_d_of_type_Float - this.jdField_c_of_type_Float) && (paramFloat < this.jdField_e_of_type_Float + this.jdField_c_of_type_Float)) {
      return 0;
    }
    return 1;
  }
  
  private long a(float paramFloat)
  {
    long l2 = ((float)this.jdField_a_of_type_Long * paramFloat / (getWidth() - this.jdField_b_of_type_Int));
    long l1 = l2;
    if (this.jdField_a_of_type_Boolean)
    {
      l2 = this.jdField_a_of_type_Long - l2;
      if (l2 < 0L) {
        return 0L;
      }
      l1 = l2;
      if (l2 > this.jdField_a_of_type_Long) {
        return this.jdField_a_of_type_Long;
      }
    }
    return l1;
  }
  
  private void a(long paramLong)
  {
    try
    {
      int i = (int)(paramLong / 1000L + 1L);
      bhga.a(this, String.format(anzj.a(2131714910), new Object[] { Integer.valueOf(i) }));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_Float = ((int)a(paramContext, this.jdField_a_of_type_Float));
    this.jdField_b_of_type_Float = ((int)a(paramContext, this.jdField_b_of_type_Float));
    this.jdField_c_of_type_Float = a(paramContext, this.jdField_c_of_type_Float);
  }
  
  private void a(Canvas paramCanvas)
  {
    if ((paramCanvas == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {}
    do
    {
      return;
      i = getWidth();
      j = getHeight();
    } while ((i <= this.jdField_a_of_type_Float + this.jdField_a_of_type_Float) || (j <= this.jdField_a_of_type_Float + this.jdField_a_of_type_Float) || (i <= this.jdField_a_of_type_Float + this.jdField_a_of_type_Float) || (j <= this.jdField_a_of_type_Float + this.jdField_a_of_type_Float));
    paramCanvas.save();
    Object localObject = new Path();
    ((Path)localObject).moveTo(this.jdField_a_of_type_Float, 0.0F);
    ((Path)localObject).lineTo(i - this.jdField_a_of_type_Float, 0.0F);
    ((Path)localObject).quadTo(i, 0.0F, i, this.jdField_a_of_type_Float);
    ((Path)localObject).lineTo(i, j - this.jdField_a_of_type_Float);
    ((Path)localObject).quadTo(i, j, i - this.jdField_a_of_type_Float, j);
    ((Path)localObject).lineTo(this.jdField_a_of_type_Float, j);
    ((Path)localObject).quadTo(0.0F, j, 0.0F, j - this.jdField_a_of_type_Float);
    ((Path)localObject).lineTo(0.0F, this.jdField_a_of_type_Float);
    ((Path)localObject).quadTo(0.0F, 0.0F, this.jdField_a_of_type_Float, 0.0F);
    paramCanvas.clipPath((Path)localObject);
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      for (i = 0; ((Iterator)localObject).hasNext(); i = this.jdField_b_of_type_Int + i) {
        paramCanvas.drawBitmap((Bitmap)((Iterator)localObject).next(), i, 0.0F, null);
      }
    }
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    int j = 0;
    while (i >= 0)
    {
      paramCanvas.drawBitmap((Bitmap)this.jdField_a_of_type_JavaUtilList.get(i), j, 0.0F, null);
      j += this.jdField_b_of_type_Int;
      i -= 1;
    }
    paramCanvas.restore();
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    float f1;
    if (this.jdField_a_of_type_Int == 0)
    {
      f1 = paramMotionEvent.getX() - this.jdField_f_of_type_Float;
      this.jdField_f_of_type_Float = paramMotionEvent.getX();
      this.jdField_d_of_type_Float += f1;
    }
    for (this.jdField_e_of_type_Float = (f1 + this.jdField_e_of_type_Float);; this.jdField_e_of_type_Float = (this.jdField_d_of_type_Float + this.jdField_b_of_type_Int + this.jdField_b_of_type_Float))
    {
      if (this.jdField_d_of_type_Float <= 0.0F)
      {
        this.jdField_d_of_type_Float = 0.0F;
        this.jdField_e_of_type_Float = (this.jdField_b_of_type_Int + this.jdField_b_of_type_Float);
      }
      if (this.jdField_e_of_type_Float + this.jdField_b_of_type_Float >= getWidth())
      {
        this.jdField_e_of_type_Float = (getWidth() - this.jdField_b_of_type_Float);
        this.jdField_d_of_type_Float = (this.jdField_e_of_type_Float - (this.jdField_b_of_type_Int + this.jdField_b_of_type_Float));
      }
      paramMotionEvent = null;
      if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
        paramMotionEvent = (bqth)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      }
      if (paramMotionEvent != null)
      {
        this.jdField_d_of_type_Long = (a(this.jdField_d_of_type_Float) + this.jdField_b_of_type_Long);
        paramMotionEvent.a(this.jdField_d_of_type_Long);
      }
      return;
      this.jdField_d_of_type_Float = (paramMotionEvent.getX() - (this.jdField_b_of_type_Int >> 1));
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    if (this.jdField_a_of_type_Bqti != null)
    {
      this.jdField_a_of_type_Bqti.c();
      this.jdField_a_of_type_Bqti = null;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_c_of_type_Long = 0L;
  }
  
  public void a(int paramInt, Bitmap paramBitmap)
  {
    if ((this.jdField_b_of_type_Int == 0) || (this.jdField_c_of_type_Int == 0))
    {
      QLog.d("SegmentRangeView", 2, "onLoadFrame, width:" + this.jdField_b_of_type_Int + "  height:" + this.jdField_c_of_type_Int);
      return;
    }
    if (paramBitmap == null)
    {
      QLog.d("SegmentRangeView", 2, "onLoadFrame, bitmap is null");
      return;
    }
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap.getHeight() != this.g) {
      localBitmap = zoc.a(paramBitmap, paramBitmap.getWidth(), this.g, true);
    }
    this.jdField_a_of_type_JavaUtilList.add(localBitmap);
    invalidate();
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, bqth parambqth, boolean paramBoolean2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambqth);
    this.jdField_a_of_type_Long = (paramLong2 - paramLong1);
    this.jdField_b_of_type_Long = paramLong1;
    this.jdField_b_of_type_Boolean = paramBoolean1;
    paramBoolean1 = zqb.a(paramInt2, paramInt3, paramInt1);
    if ((paramBoolean1) && (paramBoolean2)) {}
    for (int i = paramInt1 + 90;; i = paramInt1)
    {
      if (paramInt1 % 180 != 0) {
        this.jdField_e_of_type_Int = paramInt3;
      }
      for (this.jdField_f_of_type_Int = paramInt2;; this.jdField_f_of_type_Int = paramInt3)
      {
        this.jdField_a_of_type_Bqti = new bqti(getContext(), paramBoolean2, paramBoolean1);
        this.jdField_a_of_type_Bqti.a(paramString, paramLong1, paramLong2, i, this);
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(2130706432);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
        this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
        this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
        this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-15550475);
        this.jdField_d_of_type_Float = 0.0F;
        this.jdField_e_of_type_Float = 0.0F;
        return;
        this.jdField_e_of_type_Int = paramInt2;
      }
    }
  }
  
  public void a(List<Long> paramList)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      bqth localbqth = (bqth)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localbqth != null) {
        localbqth.a(paramList);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      invalidate();
    }
  }
  
  public void b() {}
  
  public void c()
  {
    if (this.jdField_d_of_type_Int != this.jdField_a_of_type_JavaUtilList.size())
    {
      QLog.d("SegmentRangeView", 2, "onLaadEnd, frame num error!!, target:" + this.jdField_d_of_type_Int + "  real:" + this.jdField_a_of_type_JavaUtilList.size());
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
        int i = this.jdField_d_of_type_Int - this.jdField_a_of_type_JavaUtilList.size();
        while (i > 0)
        {
          this.jdField_a_of_type_JavaUtilList.add(localBitmap);
          i -= 1;
        }
      }
    }
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(paramCanvas);
    paramCanvas.drawRect(0.0F, 0.0F, this.jdField_d_of_type_Float, getHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.jdField_e_of_type_Float + this.jdField_b_of_type_Float, 0.0F, getWidth(), getHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.jdField_d_of_type_Float, 0.0F, this.jdField_e_of_type_Float, this.jdField_b_of_type_Float, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.jdField_d_of_type_Float, getHeight() - this.jdField_b_of_type_Float, this.jdField_e_of_type_Float, getHeight(), this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.jdField_d_of_type_Float, 0.0F, this.jdField_d_of_type_Float + this.jdField_b_of_type_Float, getHeight(), this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.jdField_e_of_type_Float, 0.0F, this.jdField_e_of_type_Float + this.jdField_b_of_type_Float, getHeight(), this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SegmentRangeView", 2, "onsizechanged, will reload frame: " + paramInt1 + "-" + paramInt2);
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label174;
      }
      this.jdField_d_of_type_Int = 7;
      this.jdField_b_of_type_Int = (paramInt1 / this.jdField_d_of_type_Int + 1);
      this.jdField_c_of_type_Int = ((int)(this.jdField_f_of_type_Int / this.jdField_e_of_type_Int * this.jdField_b_of_type_Int));
    }
    for (this.g = paramInt2;; this.g = paramInt2)
    {
      if (this.jdField_a_of_type_Bqti != null)
      {
        this.jdField_a_of_type_Bqti.b();
        this.jdField_a_of_type_Bqti.a(this.jdField_d_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int);
      }
      if (this.jdField_c_of_type_Long != -1L)
      {
        setCoverFrameTime(this.jdField_c_of_type_Long);
        this.jdField_c_of_type_Long = -1L;
      }
      return;
      label174:
      this.jdField_d_of_type_Int = 7;
      this.jdField_b_of_type_Int = (paramInt1 / this.jdField_d_of_type_Int + 1);
      this.jdField_c_of_type_Int = paramInt2;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    switch (paramMotionEvent.getAction())
    {
    default: 
      bool = false;
    case 0: 
    case 2: 
      do
      {
        return bool;
        float f1 = paramMotionEvent.getX();
        this.jdField_f_of_type_Float = f1;
        this.jdField_a_of_type_Int = a(f1);
      } while (this.jdField_a_of_type_Int != 0);
      a(paramMotionEvent);
      invalidate();
      return true;
    case 1: 
      if (this.jdField_a_of_type_Int == 1)
      {
        a(paramMotionEvent);
        invalidate();
        a(this.jdField_d_of_type_Long);
      }
      for (;;)
      {
        this.jdField_a_of_type_Int = -1;
        return true;
        if (this.jdField_a_of_type_Int == 0) {
          a(this.jdField_d_of_type_Long);
        }
      }
    }
    this.jdField_a_of_type_Int = -1;
    return true;
  }
  
  public void setCoverFrameTime(long paramLong)
  {
    if (getWidth() == 0)
    {
      this.jdField_c_of_type_Long = paramLong;
      return;
    }
    this.jdField_d_of_type_Float = a(paramLong - this.jdField_b_of_type_Long);
    this.jdField_e_of_type_Float = (this.jdField_d_of_type_Float + this.jdField_b_of_type_Int + this.jdField_b_of_type_Float);
    this.jdField_d_of_type_Long = paramLong;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoCoverSegmentRangeView
 * JD-Core Version:    0.7.0.1
 */