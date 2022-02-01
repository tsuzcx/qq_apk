package dov.com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AtLayer
  extends BaseLayer
{
  public static final String a;
  public int a;
  public Paint a;
  public TextPaint a;
  public AtLayer.AtItem a;
  private AtLayer.LayerEventListener jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$LayerEventListener;
  private GestureHelper jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper;
  public List<AtLayer.AtItem> a;
  public boolean a;
  public int b;
  public Paint b;
  private String b;
  public boolean b;
  private boolean d = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = AtLayer.class.getSimpleName();
  }
  
  public AtLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString;
    this.jdField_b_of_type_Boolean = false;
    c();
  }
  
  public AtLayer(DoodleView paramDoodleView, String paramString)
  {
    this(paramDoodleView);
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (a(paramMotionEvent.getX(0), paramMotionEvent.getY(0)))
    {
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem);
      this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem);
    }
  }
  
  private void a(AtLayer.AtItem paramAtItem, Canvas paramCanvas)
  {
    SLog.c(jdField_a_of_type_JavaLangString, "drawItem start.");
    if (paramAtItem == null) {
      return;
    }
    paramCanvas.save();
    paramCanvas.concat(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(paramAtItem));
    paramAtItem.a(paramCanvas, true);
    paramCanvas.restore();
    SLog.c(jdField_a_of_type_JavaLangString, "drawItem end.");
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      AtLayer.AtItem localAtItem = (AtLayer.AtItem)this.jdField_a_of_type_JavaUtilList.get(i);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(localAtItem, paramFloat1, paramFloat2, false))
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem = localAtItem;
        return true;
      }
      i -= 1;
    }
    return false;
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem = null;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a();
    k();
    d(false);
  }
  
  private void c()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper = new GestureHelper();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(true);
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint();
    this.jdField_a_of_type_AndroidTextTextPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidTextTextPaint.setTextAlign(Paint.Align.LEFT);
    this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidTextTextPaint.setTypeface(Typeface.DEFAULT);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16711936);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.i.setStrokeWidth(2.0F);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-65536);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem == null) {
      return;
    }
    SLog.b(jdField_a_of_type_JavaLangString, "before limit translate value. translateXValue = %f, translateYValue = %f.", Float.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem.s), Float.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem.t));
    float f5 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem.a.x + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem.s;
    float f4 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem.a.y + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem.t;
    float f1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem.s;
    float f3 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem.t;
    if (f5 - this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem.u / 2.0F < this.jdField_a_of_type_AndroidGraphicsRect.left) {
      f1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem.u / 2.0F - this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem.a.x;
    }
    float f2 = f1;
    if (f5 + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem.u / 2.0F > this.jdField_a_of_type_AndroidGraphicsRect.right) {
      f2 = this.jdField_a_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem.u / 2.0F - this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem.a.x;
    }
    f1 = f3;
    if (f4 - this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem.v / 2.0F < this.jdField_a_of_type_AndroidGraphicsRect.top) {
      f1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem.v / 2.0F - this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem.a.y;
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem.v / 2.0F + f4 > this.jdField_a_of_type_AndroidGraphicsRect.bottom) {
      f1 = this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem.v / 2.0F - this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem.a.y;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem.s = f2;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem.t = f1;
    SLog.b(jdField_a_of_type_JavaLangString, "after limit translate value. translateXValue = %f, translateYValue = %f.", Float.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem.s), Float.valueOf(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem.t));
  }
  
  private void e()
  {
    SLog.b(jdField_a_of_type_JavaLangString, "click the item:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem);
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$LayerEventListener != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem != null)) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$LayerEventListener.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem);
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaUtilList.size())
    {
      SLog.b(jdField_a_of_type_JavaLangString, "getDoodleCount:" + i);
      return i;
    }
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem = null;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a();
    SLog.b(jdField_a_of_type_JavaLangString, "clear over.");
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.d)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        a((AtLayer.AtItem)localIterator.next(), paramCanvas);
      }
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    paramCanvas.save();
    paramCanvas.scale(paramFloat, paramFloat);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      AtLayer.AtItem localAtItem = (AtLayer.AtItem)localIterator.next();
      paramCanvas.save();
      paramCanvas.concat(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(localAtItem));
      localAtItem.a(paramCanvas, false);
      paramCanvas.restore();
    }
    paramCanvas.restore();
  }
  
  public boolean a()
  {
    return a() == 0;
  }
  
  public boolean a(long paramLong)
  {
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getY();
    int k = (int)paramMotionEvent.getX();
    int j = Math.abs(k - this.jdField_b_of_type_Int);
    int m = Math.abs(i - this.jdField_a_of_type_Int);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(paramMotionEvent, false);
      d();
      return true;
      this.jdField_b_of_type_Int = k;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Boolean = false;
      a(paramMotionEvent);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem != null)
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem);
        continue;
        if (m > 5)
        {
          i = 1;
          label133:
          if (j <= 5) {
            break label159;
          }
        }
        label159:
        for (j = 1; (j | i) != 0; j = 0)
        {
          this.jdField_a_of_type_Boolean = true;
          break;
          i = 0;
          break label133;
        }
        if ((!this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer$AtItem instanceof AtLayer.AtItem))) {
          e();
        }
        b(paramMotionEvent);
      }
    }
  }
  
  public void b(Canvas paramCanvas)
  {
    a(paramCanvas, this.jdField_a_of_type_Float);
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    if (this.jdField_b_of_type_Boolean) {
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    while (i >= 0)
    {
      paramMotionEvent = (AtLayer.AtItem)this.jdField_a_of_type_JavaUtilList.get(i);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(paramMotionEvent, f1, f2, false)) {
        return true;
      }
      i -= 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.AtLayer
 * JD-Core Version:    0.7.0.1
 */