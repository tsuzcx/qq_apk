package dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base;

import android.animation.ValueAnimator;
import com.tencent.mobileqq.richmedia.capture.data.TrackerStickerParam.MotionInfo;
import java.util.HashMap;
import java.util.Map;

public abstract class TrackingItem
{
  public ValueAnimator a;
  public Map<Long, TrackerStickerParam.MotionInfo> a;
  public ValueAnimator b = null;
  public boolean d = false;
  public boolean e = false;
  public boolean f = false;
  public boolean g = false;
  public boolean h = false;
  public int i = 0;
  public float j = 0.0F;
  public float k = 0.0F;
  public float l = 0.0F;
  public float m = 0.0F;
  public float n = 1.0F;
  public float o = 1.0F;
  public float p = 1.0F;
  
  public TrackingItem()
  {
    this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public void a(TrackingItem paramTrackingItem)
  {
    if (paramTrackingItem != null)
    {
      this.d = paramTrackingItem.d;
      this.j = paramTrackingItem.j;
      this.k = paramTrackingItem.k;
      this.l = paramTrackingItem.l;
      this.m = paramTrackingItem.m;
      this.e = paramTrackingItem.e;
      this.g = paramTrackingItem.g;
      this.h = paramTrackingItem.h;
      this.o = paramTrackingItem.o;
      this.i = paramTrackingItem.i;
    }
  }
  
  public boolean a()
  {
    return this.i == 0;
  }
  
  public boolean b()
  {
    return this.i == 3;
  }
  
  public void c(boolean paramBoolean)
  {
    this.d = false;
  }
  
  public void d()
  {
    this.g = false;
    this.h = false;
    this.j = 0.0F;
    this.k = 0.0F;
    this.l = 0.0F;
    this.m = 0.0F;
    this.o = 1.0F;
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.i = 0;
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    e();
  }
  
  public void e()
  {
    if ((this.b != null) && (this.b.isRunning())) {
      this.b.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.TrackingItem
 * JD-Core Version:    0.7.0.1
 */