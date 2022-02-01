package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import bqtf;
import bqti;
import bqtj;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zqb;

public class SegmentRangeView
  extends View
  implements bqtj
{
  private float jdField_a_of_type_Float = 8.0F;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private bqti jdField_a_of_type_Bqti;
  private WeakReference<bqtf> jdField_a_of_type_JavaLangRefWeakReference;
  private List<Bitmap> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = 20.0F;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private List<Pair<Long, Long>> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float = 72.0F;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float = 3.0F;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = true;
  private float jdField_e_of_type_Float = 30.0F;
  private int jdField_e_of_type_Int;
  private float f;
  private float g;
  private float h;
  private final float i = 0.6F;
  
  public SegmentRangeView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public SegmentRangeView(Context paramContext, AttributeSet paramAttributeSet)
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
      if (this.jdField_c_of_type_Boolean) {
        paramLong = this.jdField_a_of_type_Long - l;
      }
      return (float)((float)paramLong * (getWidth() - this.jdField_b_of_type_Float * 2.0F) * 1.0F / (float)this.jdField_a_of_type_Long + this.jdField_b_of_type_Float);
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
    Math.abs(this.g - this.f);
    if ((paramFloat > this.f - this.jdField_b_of_type_Float - this.jdField_e_of_type_Float) && (paramFloat < this.f + this.jdField_e_of_type_Float))
    {
      if ((paramFloat <= this.g - this.jdField_e_of_type_Float) || (paramFloat >= this.g + this.jdField_b_of_type_Float + this.jdField_e_of_type_Float) || (Math.abs(paramFloat - this.f) < Math.abs(paramFloat - this.g))) {
        return 0;
      }
      return 1;
    }
    if ((paramFloat > this.g - this.jdField_e_of_type_Float) && (paramFloat < this.g + this.jdField_b_of_type_Float + this.jdField_e_of_type_Float)) {
      return 1;
    }
    return -1;
  }
  
  private long a(float paramFloat)
  {
    long l2 = ((float)this.jdField_a_of_type_Long * (paramFloat - this.jdField_b_of_type_Float) * 1.0F / (getWidth() - this.jdField_b_of_type_Float * 2.0F));
    long l1 = l2;
    if (this.jdField_c_of_type_Boolean)
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
  
  private void a(Context paramContext)
  {
    this.jdField_b_of_type_Float = ((int)a(paramContext, this.jdField_b_of_type_Float));
    this.jdField_c_of_type_Float = ((int)a(paramContext, this.jdField_c_of_type_Float));
    this.jdField_a_of_type_Float = ((int)a(paramContext, this.jdField_a_of_type_Float));
    this.jdField_d_of_type_Float = ((int)a(paramContext, this.jdField_d_of_type_Float));
    this.jdField_e_of_type_Float = a(paramContext, this.jdField_e_of_type_Float);
  }
  
  private void a(Canvas paramCanvas)
  {
    if ((paramCanvas == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {}
    do
    {
      return;
      j = getWidth();
      k = getHeight();
    } while ((j <= this.jdField_a_of_type_Float + this.jdField_a_of_type_Float) || (k <= this.jdField_a_of_type_Float + this.jdField_a_of_type_Float) || (j <= this.jdField_a_of_type_Float + this.jdField_a_of_type_Float) || (k <= this.jdField_a_of_type_Float + this.jdField_a_of_type_Float));
    paramCanvas.save();
    Object localObject = new Path();
    ((Path)localObject).moveTo(this.jdField_a_of_type_Float, 0.0F);
    ((Path)localObject).lineTo(j - this.jdField_a_of_type_Float, 0.0F);
    ((Path)localObject).quadTo(j, 0.0F, j, this.jdField_a_of_type_Float);
    ((Path)localObject).lineTo(j, k - this.jdField_a_of_type_Float);
    ((Path)localObject).quadTo(j, k, j - this.jdField_a_of_type_Float, k);
    ((Path)localObject).lineTo(this.jdField_a_of_type_Float, k);
    ((Path)localObject).quadTo(0.0F, k, 0.0F, k - this.jdField_a_of_type_Float);
    ((Path)localObject).lineTo(0.0F, this.jdField_a_of_type_Float);
    ((Path)localObject).quadTo(0.0F, 0.0F, this.jdField_a_of_type_Float, 0.0F);
    paramCanvas.clipPath((Path)localObject);
    if (!this.jdField_c_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      for (j = 0; ((Iterator)localObject).hasNext(); j = this.jdField_a_of_type_Int + j) {
        paramCanvas.drawBitmap((Bitmap)((Iterator)localObject).next(), j, 0.0F, null);
      }
    }
    int j = this.jdField_a_of_type_JavaUtilList.size() - 1;
    int k = 0;
    while (j >= 0)
    {
      paramCanvas.drawBitmap((Bitmap)this.jdField_a_of_type_JavaUtilList.get(j), k, 0.0F, null);
      k += this.jdField_a_of_type_Int;
      j -= 1;
    }
    paramCanvas.restore();
  }
  
  public Bitmap a(int paramInt)
  {
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(getContext().getResources(), paramInt, null);
      return localBitmap;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
    return null;
  }
  
  public final List<Pair<Long, Long>> a()
  {
    if (this.f >= this.g) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    long l1 = a(this.f);
    long l2 = a(this.g);
    long l3;
    if ((l1 > l2) && (this.jdField_c_of_type_Boolean))
    {
      l3 = l2;
      l2 = l1;
    }
    for (;;)
    {
      localArrayList.add(new Pair(Long.valueOf(l3), Long.valueOf(l2)));
      return localArrayList;
      QLog.e("SegmentRangeView", 2, "geRanges, start:" + l1 + " end:" + l2);
      l3 = l1;
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
    this.jdField_b_of_type_JavaUtilList = null;
  }
  
  public void a(int paramInt, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_Int == 0) || (this.jdField_b_of_type_Int == 0))
    {
      QLog.d("SegmentRangeView", 2, "onLoadFrame, width:" + this.jdField_a_of_type_Int + "  height:" + this.jdField_b_of_type_Int);
      return;
    }
    if (paramBitmap == null)
    {
      QLog.d("SegmentRangeView", 2, "onLoadFrame, bitmap is null");
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramBitmap);
    invalidate();
  }
  
  public void a(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, bqtf parambqtf, boolean paramBoolean2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambqtf);
    this.jdField_a_of_type_Long = (paramLong2 - paramLong1);
    this.jdField_b_of_type_Long = paramLong1;
    this.jdField_d_of_type_Boolean = paramBoolean1;
    boolean bool = zqb.a(paramInt2, paramInt3, paramInt1);
    if (paramBoolean1)
    {
      this.jdField_d_of_type_Int = paramInt2;
      this.jdField_e_of_type_Int = paramInt3;
      paramInt1 = 0;
      this.jdField_a_of_type_Bqti = new bqti(getContext(), paramBoolean2, bool);
      this.jdField_a_of_type_Bqti.a(paramString, paramLong1, paramLong2, paramInt1, this);
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(2130706432);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
      this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-15550475);
      this.f = this.jdField_b_of_type_Float;
      this.g = this.f;
      this.jdField_a_of_type_AndroidGraphicsBitmap = a(2130844647);
      this.jdField_b_of_type_AndroidGraphicsBitmap = a(2130844649);
      return;
    }
    if ((bool) && (paramBoolean2)) {}
    for (int j = paramInt1 + 90;; j = paramInt1)
    {
      if (paramInt1 % 180 > 0)
      {
        this.jdField_d_of_type_Int = paramInt3;
        this.jdField_e_of_type_Int = paramInt2;
        paramInt1 = j;
        break;
      }
      this.jdField_d_of_type_Int = paramInt2;
      this.jdField_e_of_type_Int = paramInt3;
      paramInt1 = j;
      break;
    }
  }
  
  public void a(List<Long> paramList)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      bqtf localbqtf = (bqtf)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localbqtf != null) {
        localbqtf.a(paramList);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean != paramBoolean)
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      invalidate();
    }
  }
  
  public void b() {}
  
  public void c()
  {
    if (this.jdField_c_of_type_Int != this.jdField_a_of_type_JavaUtilList.size())
    {
      QLog.d("SegmentRangeView", 2, "onLaadEnd, frame num error!!, target:" + this.jdField_c_of_type_Int + "  real:" + this.jdField_a_of_type_JavaUtilList.size());
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
        int j = this.jdField_c_of_type_Int - this.jdField_a_of_type_JavaUtilList.size();
        while (j > 0)
        {
          this.jdField_a_of_type_JavaUtilList.add(localBitmap);
          j -= 1;
        }
      }
    }
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(paramCanvas);
    paramCanvas.drawRect(this.f, 0.0F, this.g, getHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.f, 0.0F, this.g, this.jdField_d_of_type_Float, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.f, getHeight() - this.jdField_d_of_type_Float, this.g, getHeight(), this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, (int)(this.f - this.jdField_b_of_type_Float), 0.0F, null);
    paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, (int)this.g, 0.0F, null);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SegmentRangeView", 2, "onsizechanged, will reload frame: " + paramInt1 + "-" + paramInt2);
      }
      if (this.jdField_d_of_type_Boolean)
      {
        f1 = this.jdField_d_of_type_Int * 1.0F / this.jdField_e_of_type_Int;
        this.jdField_a_of_type_Int = ((int)(f1 * paramInt2));
        this.jdField_b_of_type_Int = paramInt2;
        if (this.jdField_a_of_type_Int != 0) {
          break label114;
        }
      }
    }
    label114:
    while (this.jdField_b_of_type_JavaUtilList == null)
    {
      do
      {
        for (;;)
        {
          return;
          float f1 = 0.6F;
        }
        this.jdField_c_of_type_Int = (paramInt1 / this.jdField_a_of_type_Int);
        if (this.jdField_c_of_type_Int * this.jdField_a_of_type_Int != paramInt1) {
          this.jdField_c_of_type_Int += 1;
        }
      } while (this.jdField_c_of_type_Int == 0);
      if (this.jdField_a_of_type_Bqti != null)
      {
        this.jdField_a_of_type_Bqti.b();
        this.jdField_a_of_type_Bqti.a(this.jdField_c_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
    }
    List localList = this.jdField_b_of_type_JavaUtilList;
    this.jdField_b_of_type_JavaUtilList = null;
    setRanges(localList);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1;
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      f1 = paramMotionEvent.getX();
      this.h = f1;
      int j = a(f1);
      if (j == 0)
      {
        this.jdField_a_of_type_Boolean = true;
        return true;
      }
      if (j == 1)
      {
        this.jdField_b_of_type_Boolean = true;
        return true;
      }
      return true;
    case 2: 
      f1 = paramMotionEvent.getX() - this.h;
      if (this.jdField_a_of_type_Boolean)
      {
        this.h = paramMotionEvent.getX();
        this.f = (f1 + this.f);
        if (this.f <= this.jdField_b_of_type_Float) {
          this.f = this.jdField_b_of_type_Float;
        }
        if (this.f > this.g - getWidth() * 0.1F) {
          this.f = (this.g - getWidth() * 0.1F);
        }
        if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
          break label457;
        }
      }
      break;
    }
    label455:
    label457:
    for (paramMotionEvent = (bqtf)this.jdField_a_of_type_JavaLangRefWeakReference.get();; paramMotionEvent = null)
    {
      if (paramMotionEvent != null)
      {
        if (this.jdField_c_of_type_Boolean) {
          break label223;
        }
        paramMotionEvent.a(a(this.f));
      }
      for (;;)
      {
        label217:
        invalidate();
        return true;
        label223:
        paramMotionEvent.b(a(this.f));
        continue;
        if (this.jdField_b_of_type_Boolean)
        {
          this.h = paramMotionEvent.getX();
          this.g = (f1 + this.g);
          if (this.g + this.jdField_b_of_type_Float >= getWidth()) {
            this.g = (getWidth() - this.jdField_b_of_type_Float);
          }
          if (this.f + getWidth() * 0.1F > this.g) {
            this.g = (this.f + getWidth() * 0.1F);
          }
          if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
          for (paramMotionEvent = (bqtf)this.jdField_a_of_type_JavaLangRefWeakReference.get();; paramMotionEvent = null)
          {
            if (paramMotionEvent == null) {
              break label455;
            }
            if (!this.jdField_c_of_type_Boolean)
            {
              paramMotionEvent.b(a(this.g));
              break label217;
            }
            paramMotionEvent.a(a(this.g));
            break label217;
            if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
              break;
            }
            this.jdField_a_of_type_Boolean = false;
            this.jdField_b_of_type_Boolean = false;
            return true;
            if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
              break;
            }
            this.jdField_a_of_type_Boolean = false;
            this.jdField_b_of_type_Boolean = false;
            return true;
          }
        }
      }
    }
  }
  
  public void setRanges(List<Pair<Long, Long>> paramList)
  {
    if (getWidth() == 0)
    {
      this.jdField_b_of_type_JavaUtilList = paramList;
      if (this.jdField_b_of_type_JavaUtilList == null) {
        this.jdField_b_of_type_JavaUtilList = new ArrayList();
      }
      return;
    }
    float f1;
    float f2;
    if ((paramList == null) || (paramList.size() == 0))
    {
      f1 = a(0L);
      f2 = a(this.jdField_a_of_type_Long);
      if (!this.jdField_c_of_type_Boolean)
      {
        this.f = f1;
        this.g = f2;
      }
    }
    for (;;)
    {
      invalidate();
      return;
      this.f = f2;
      this.g = f1;
      continue;
      this.f = a(((Long)((Pair)paramList.get(0)).first).longValue());
      this.g = a(((Long)((Pair)paramList.get(0)).second).longValue());
      if ((this.g < this.f) && (this.jdField_c_of_type_Boolean))
      {
        f1 = this.g;
        this.g = this.f;
        this.f = f1;
      }
      else
      {
        QLog.e("SegmentRangeView", 2, "setRanges error, left:" + this.f + " right:" + this.g);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.SegmentRangeView
 * JD-Core Version:    0.7.0.1
 */