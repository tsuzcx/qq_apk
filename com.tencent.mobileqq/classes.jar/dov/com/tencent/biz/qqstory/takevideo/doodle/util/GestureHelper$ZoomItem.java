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
  public int[] a;
  public ValueAnimator c = null;
  public boolean i = true;
  public int j;
  public boolean j;
  public int k = -1;
  public boolean k;
  public int l;
  public boolean l;
  public int m;
  public boolean m;
  public boolean n = false;
  public float q = 1.0F;
  public float r = 0.0F;
  public float s = 0.0F;
  public float t = 0.0F;
  public float u;
  public float v;
  public float w = 1.0F;
  
  public GestureHelper$ZoomItem()
  {
    this.jdField_j_of_type_Boolean = false;
    this.jdField_j_of_type_Int = 0;
    this.jdField_l_of_type_Int = -1;
    this.jdField_m_of_type_Int = -1;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper();
  }
  
  public GestureHelper$ZoomItem(@NonNull PointF paramPointF, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = false;
    this.jdField_j_of_type_Int = 0;
    this.jdField_l_of_type_Int = -1;
    this.jdField_m_of_type_Int = -1;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper();
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(paramPointF.x, paramPointF.y);
    this.q = paramFloat1;
    this.r = paramFloat2;
    this.s = paramFloat3;
    this.t = paramFloat4;
    this.u = paramFloat5;
    this.v = paramFloat6;
    this.i = paramBoolean;
    this.n = Build.MODEL.equals("MI 5C");
  }
  
  public GestureHelper$ZoomItem(ZoomItem paramZoomItem, float paramFloat)
  {
    this.jdField_j_of_type_Boolean = false;
    this.jdField_j_of_type_Int = 0;
    this.jdField_l_of_type_Int = -1;
    this.jdField_m_of_type_Int = -1;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper();
    this.jdField_a_of_type_AndroidGraphicsPointF = new PointF(paramZoomItem.jdField_a_of_type_AndroidGraphicsPointF.x * paramFloat, paramZoomItem.jdField_a_of_type_AndroidGraphicsPointF.y * paramFloat);
    paramZoomItem.q *= paramFloat;
    this.r = paramZoomItem.r;
    paramZoomItem.s *= paramFloat;
    paramZoomItem.t *= paramFloat;
    this.u = paramZoomItem.u;
    this.v = paramZoomItem.v;
    this.i = paramZoomItem.i;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.set(paramZoomItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper);
  }
  
  public void a(Canvas paramCanvas) {}
  
  public boolean c()
  {
    return !this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem
 * JD-Core Version:    0.7.0.1
 */