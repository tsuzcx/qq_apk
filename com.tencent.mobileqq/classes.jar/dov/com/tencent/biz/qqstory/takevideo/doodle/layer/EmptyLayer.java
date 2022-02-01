package dov.com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.graphics.Canvas;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public final class EmptyLayer
  extends BaseLayer
{
  public static final String a = EmptyLayer.class.getSimpleName();
  
  public EmptyLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
  }
  
  public String a()
  {
    return a;
  }
  
  public void a() {}
  
  public void a(Canvas paramCanvas) {}
  
  public void a(Canvas paramCanvas, float paramFloat) {}
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(long paramLong)
  {
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void b(Canvas paramCanvas) {}
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    SLog.b(a, "EmptyLayer handle touch event.");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.EmptyLayer
 * JD-Core Version:    0.7.0.1
 */