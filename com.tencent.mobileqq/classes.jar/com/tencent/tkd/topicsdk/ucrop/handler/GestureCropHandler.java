package com.tencent.tkd.topicsdk.ucrop.handler;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.tencent.tkd.topicsdk.ucrop.util.RotationGestureDetector;
import com.tencent.tkd.topicsdk.ucrop.view.IGestureCropView;

public class GestureCropHandler
  extends CropHandler
{
  private ScaleGestureDetector j;
  private RotationGestureDetector k;
  private GestureDetector l;
  private float m;
  private float n;
  private boolean o = true;
  private boolean p = true;
  private int q = 5;
  
  public GestureCropHandler(IGestureCropView paramIGestureCropView)
  {
    super(paramIGestureCropView);
    l();
  }
  
  private void l()
  {
    Context localContext = k().getView().getContext();
    this.l = new GestureDetector(localContext, new GestureCropHandler.GestureListener(this, null), null, true);
    this.j = new ScaleGestureDetector(localContext, new GestureCropHandler.ScaleListener(this, null));
    this.k = new RotationGestureDetector(new GestureCropHandler.RotateListener(this, null));
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 0) {
      c();
    }
    if (paramMotionEvent.getPointerCount() > 1)
    {
      this.m = ((paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F);
      this.n = ((paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F);
    }
    this.l.onTouchEvent(paramMotionEvent);
    if (this.p) {
      this.j.onTouchEvent(paramMotionEvent);
    }
    if (this.o) {
      this.k.a(paramMotionEvent);
    }
    if ((paramMotionEvent.getAction() & 0xFF) == 1) {
      d();
    }
    return true;
  }
  
  public void b(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  protected float g()
  {
    return h() * (float)Math.pow(a() / b(), 1.0F / this.q);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.handler.GestureCropHandler
 * JD-Core Version:    0.7.0.1
 */