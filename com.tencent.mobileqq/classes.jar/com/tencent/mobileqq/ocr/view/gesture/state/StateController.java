package com.tencent.mobileqq.ocr.view.gesture.state;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.mobileqq.ocr.view.gesture.Settings;
import com.tencent.mobileqq.ocr.view.gesture.utils.GravityUtils;

public class StateController
{
  private static final State a = new State();
  private static final Rect b = new Rect();
  private static final RectF c = new RectF();
  private static final Point d = new Point();
  private static final PointF e = new PointF();
  private final Settings f;
  private final ScaleBounds g;
  private final MoveBounds h;
  private boolean i = true;
  private float j;
  
  public StateController(Settings paramSettings)
  {
    this.f = paramSettings;
    this.g = new ScaleBounds(paramSettings);
    this.h = new MoveBounds(paramSettings);
  }
  
  private float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    if (paramFloat5 == 1.0F) {
      return paramFloat1;
    }
    float f1 = paramFloat3 / paramFloat5;
    if ((paramFloat1 < paramFloat3) && (paramFloat1 < paramFloat2)) {
      paramFloat3 = (paramFloat3 - paramFloat1) / (paramFloat3 - f1);
    } else if ((paramFloat1 > paramFloat4) && (paramFloat1 > paramFloat2)) {
      paramFloat3 = (paramFloat1 - paramFloat4) / (paramFloat5 * paramFloat4 - paramFloat4);
    } else {
      paramFloat3 = 0.0F;
    }
    if (paramFloat3 == 0.0F) {
      return paramFloat1;
    }
    return paramFloat1 + (float)Math.sqrt(paramFloat3) * (paramFloat2 - paramFloat1);
  }
  
  private float b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    if (paramFloat5 == 0.0F) {
      return paramFloat1;
    }
    float f1 = (paramFloat1 + paramFloat2) * 0.5F;
    if ((f1 < paramFloat3) && (paramFloat1 < paramFloat2)) {
      paramFloat3 = (paramFloat3 - f1) / paramFloat5;
    } else if ((f1 > paramFloat4) && (paramFloat1 > paramFloat2)) {
      paramFloat3 = (f1 - paramFloat4) / paramFloat5;
    } else {
      paramFloat3 = 0.0F;
    }
    if (paramFloat3 == 0.0F) {
      return paramFloat1;
    }
    paramFloat4 = paramFloat3;
    if (paramFloat3 > 1.0F) {
      paramFloat4 = 1.0F;
    }
    return paramFloat1 - (float)Math.sqrt(paramFloat4) * (paramFloat1 - paramFloat2);
  }
  
  public State a(State paramState, float paramFloat1, float paramFloat2)
  {
    this.g.a(paramState);
    float f3 = this.g.c();
    float f1;
    if (this.f.k() > 0.0F) {
      f1 = this.f.k();
    } else {
      f1 = this.g.b();
    }
    float f2 = f3;
    if (paramState.d() < (f3 + f1) * 0.5F) {
      f2 = f1;
    }
    paramState = paramState.f();
    paramState.b(f2, paramFloat1, paramFloat2);
    return paramState;
  }
  
  public State a(State paramState1, State paramState2, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a.a(paramState1);
    if (b(a, paramState2, paramFloat1, paramFloat2, paramBoolean1, paramBoolean2, paramBoolean3)) {
      return a.f();
    }
    return null;
  }
  
  public void a(State paramState, RectF paramRectF)
  {
    this.h.a(paramState).a(paramRectF);
  }
  
  public boolean a(State paramState)
  {
    this.i = true;
    return b(paramState);
  }
  
  public boolean b(State paramState)
  {
    boolean bool2 = this.i;
    boolean bool1 = false;
    if (bool2)
    {
      paramState.a(0.0F, 0.0F, this.g.a(paramState).c(), 0.0F);
      GravityUtils.a(paramState, this.f, b);
      paramState.b(b.left, b.top);
      if ((!this.f.C()) || (!this.f.D())) {
        bool1 = true;
      }
      this.i = bool1;
      return this.i ^ true;
    }
    b(paramState, paramState, (0.0F / 0.0F), (0.0F / 0.0F), false, false, true);
    return false;
  }
  
  public boolean b(State paramState1, State paramState2, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!this.f.z()) {
      return false;
    }
    float f1;
    float f2;
    if ((!Float.isNaN(paramFloat1)) && (!Float.isNaN(paramFloat2)))
    {
      f1 = paramFloat1;
      f2 = paramFloat2;
    }
    else
    {
      GravityUtils.a(this.f, d);
      f1 = d.x;
      f2 = d.y;
    }
    if ((paramBoolean3) && (this.f.w()))
    {
      paramFloat1 = Math.round(paramState1.e() / 90.0F) * 90.0F;
      if (!State.c(paramFloat1, paramState1.e()))
      {
        paramState1.d(paramFloat1, f1, f2);
        paramBoolean3 = true;
        break label127;
      }
    }
    paramBoolean3 = false;
    label127:
    this.g.a(paramState1);
    float f5 = this.g.a();
    float f4 = this.g.b();
    if (paramBoolean2) {
      paramFloat1 = this.f.l();
    } else {
      paramFloat1 = 1.0F;
    }
    float f3 = this.g.a(paramState1.d(), paramFloat1);
    paramFloat2 = f3;
    if (paramState2 != null) {
      paramFloat2 = a(f3, paramState2.d(), f5, f4, paramFloat1);
    }
    if (!State.c(paramFloat2, paramState1.d()))
    {
      paramState1.b(paramFloat2, f1, f2);
      paramBoolean3 = true;
    }
    if (paramBoolean1) {
      f1 = this.f.m();
    } else {
      f1 = 0.0F;
    }
    if (paramBoolean1) {
      f2 = this.f.n();
    } else {
      f2 = 0.0F;
    }
    this.h.a(paramState1);
    this.h.a(paramState1.b(), paramState1.c(), f1, f2, e);
    f4 = e.x;
    f3 = e.y;
    if (paramFloat2 < f5)
    {
      paramFloat1 = (float)Math.sqrt((paramFloat2 * paramFloat1 / f5 - 1.0F) / (paramFloat1 - 1.0F));
      this.h.a(f4, f3, e);
      paramFloat2 = e.x;
      f5 = e.y;
      paramFloat2 += (f4 - paramFloat2) * paramFloat1;
      paramFloat1 = f5 + paramFloat1 * (f3 - f5);
    }
    else
    {
      paramFloat2 = f4;
      paramFloat1 = f3;
    }
    f4 = paramFloat2;
    f3 = paramFloat1;
    if (paramState2 != null)
    {
      this.h.a(c);
      f4 = b(paramFloat2, paramState2.b(), c.left, c.right, f1);
      f3 = b(paramFloat1, paramState2.c(), c.top, c.bottom, f2);
    }
    if ((State.c(f4, paramState1.b())) && (State.c(f3, paramState1.c()))) {
      return paramBoolean3;
    }
    paramState1.b(f4, f3);
    return true;
  }
  
  public void c(State paramState)
  {
    if (this.j > 0.0F) {
      paramState.a(paramState.b(), paramState.c(), paramState.d() * this.j, paramState.e());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.state.StateController
 * JD-Core Version:    0.7.0.1
 */