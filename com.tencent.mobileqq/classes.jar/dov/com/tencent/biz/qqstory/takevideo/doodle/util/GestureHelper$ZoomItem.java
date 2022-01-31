package dov.com.tencent.biz.qqstory.takevideo.doodle.util;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.os.Build;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.DoodleItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.TrackingItem;

public abstract class GestureHelper$ZoomItem
  extends TrackingItem
  implements DoodleItem
{
  public PointF a;
  public SegmentKeeper a;
  public ValueAnimator c;
  public boolean h = true;
  public boolean i;
  public int j;
  public boolean j;
  public int k;
  public boolean k;
  public float q = 1.0F;
  public float r;
  public float s;
  public float t;
  public float u;
  public float v;
  public float w = 1.0F;
  
  public GestureHelper$ZoomItem()
  {
    this.jdField_k_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper();
  }
  
  public GestureHelper$ZoomItem(@NonNull PointF paramPointF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
  {
    this.jdField_k_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper();
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(paramPointF.x, paramPointF.y);
    this.q = paramFloat1;
    this.r = paramFloat2;
    this.s = paramFloat3;
    this.t = paramFloat4;
    this.u = paramFloat5;
    this.v = paramFloat6;
    this.h = paramBoolean;
    this.jdField_k_of_type_Boolean = Build.MODEL.equals("MI 5C");
  }
  
  public GestureHelper$ZoomItem(ZoomItem paramZoomItem, float paramFloat)
  {
    this.jdField_k_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper();
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(paramZoomItem.jdField_a_of_type_AndroidGraphicsPointF.x * paramFloat, paramZoomItem.jdField_a_of_type_AndroidGraphicsPointF.y * paramFloat);
    paramZoomItem.q *= paramFloat;
    this.r = paramZoomItem.r;
    paramZoomItem.s *= paramFloat;
    paramZoomItem.t *= paramFloat;
    this.u = paramZoomItem.u;
    this.v = paramZoomItem.v;
    this.h = paramZoomItem.h;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.a(paramZoomItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper);
  }
  
  public void a(Canvas paramCanvas) {}
  
  public boolean d()
  {
    return !this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem
 * JD-Core Version:    0.7.0.1
 */