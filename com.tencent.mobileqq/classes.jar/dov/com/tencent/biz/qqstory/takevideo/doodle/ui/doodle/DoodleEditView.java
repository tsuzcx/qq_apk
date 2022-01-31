package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import blof;
import bmlu;
import bmly;
import bmme;
import bmmf;
import bmmi;
import bmmk;
import bmmn;
import bmms;
import bmmu;
import bmox;
import bmoy;
import bmoz;
import bmpa;
import bmpb;
import bmpy;
import bmtx;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.EditPicRawImage;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.ArrayList;
import java.util.List;
import wsv;

public class DoodleEditView
  extends DoodleView
  implements bmpy
{
  private float jdField_a_of_type_Float;
  private blof jdField_a_of_type_Blof;
  public bmmi a;
  private bmpb jdField_a_of_type_Bmpb;
  Runnable jdField_a_of_type_JavaLangRunnable = new DoodleEditView.5(this);
  private float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private int e;
  
  public DoodleEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public int a()
  {
    return this.e;
  }
  
  public blof a()
  {
    return this.jdField_a_of_type_Blof;
  }
  
  public bmmi a()
  {
    return this.jdField_a_of_type_Bmmi;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Bmmi = new bmmi(this);
    this.jdField_a_of_type_Blof = new bmox(this);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int j = getContext().getResources().getDisplayMetrics().widthPixels;
    int i = getContext().getResources().getDisplayMetrics().heightPixels;
    if (EditPicRawImage.a != 0) {
      i = EditPicRawImage.a;
    }
    if (j > paramInt1) {
      this.jdField_a_of_type_Float = ((j - paramInt1) / 2.0F);
    }
    if (i > paramInt2) {
      this.jdField_b_of_type_Float = ((i - paramInt2) / 2.0F);
    }
  }
  
  public void a(bmtx parambmtx)
  {
    if (parambmtx == null) {}
    ValueAnimator localValueAnimator1;
    do
    {
      return;
      ValueAnimator localValueAnimator2 = parambmtx.a;
      localValueAnimator1 = localValueAnimator2;
      if (localValueAnimator2 == null)
      {
        localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.7F, 1.0F, 0.7F, 1.0F });
        localValueAnimator1.setStartDelay(300L);
        localValueAnimator1.setDuration(2000L);
        localValueAnimator1.setRepeatMode(1);
        localValueAnimator1.setRepeatCount(-1);
        localValueAnimator1.setInterpolator(new LinearInterpolator());
        localValueAnimator1.addUpdateListener(new bmoz(this, parambmtx));
        localValueAnimator1.addListener(new bmpa(this, parambmtx));
        parambmtx.a = localValueAnimator1;
      }
    } while ((parambmtx.a.isStarted()) || (parambmtx.a.isRunning()));
    wsv.b("DoodleEditView", "breathScale start ");
    localValueAnimator1.start();
  }
  
  public void a(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    bmtx localbmtx = this.jdField_a_of_type_Bmmi.a();
    if (localbmtx != null) {
      localbmtx.d();
    }
    if (this.jdField_a_of_type_Bmmi.b != null)
    {
      this.jdField_a_of_type_Bmmi.b.d();
      this.jdField_a_of_type_Bmmi.b = null;
    }
  }
  
  public void b(bmtx parambmtx)
  {
    if (parambmtx == null) {}
    while ((parambmtx.a == null) || (!parambmtx.a.isRunning())) {
      return;
    }
    wsv.b("DoodleEditView", "cancelNailAnimator");
    parambmtx.a.cancel();
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    bmtx localbmtx;
    Object localObject2;
    Object localObject1;
    if ((paramBoolean) || ((!paramBoolean) && (getVisibility() == 0))) {
      if (this.jdField_a_of_type_Bmmi.b())
      {
        localbmtx = this.jdField_a_of_type_Bmmi.a();
        localbmtx.jdField_k_of_type_Boolean = false;
        if (!(localbmtx instanceof bmly)) {
          break label220;
        }
        localObject2 = (bmlu)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(bmlu.jdField_a_of_type_JavaLangString);
        bmly localbmly = (bmly)localbmtx;
        if (((bmly)localbmtx).h != 1)
        {
          localObject1 = localObject2;
          if (((bmly)localbmtx).h != 3) {}
        }
        else if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) {}
        }
        else
        {
          localObject1 = (bmlu)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("DynamicFaceLayer");
          ((bmly)localbmtx).a.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
        }
        if (localObject1 != null) {
          ((bmlu)localObject1).jdField_a_of_type_JavaUtilList.add(localbmly);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
      this.jdField_a_of_type_Bmmi.c();
      setVisibility(8);
      if (this.jdField_a_of_type_Bmpb != null) {
        this.jdField_a_of_type_Bmpb.a();
      }
      return;
      label220:
      if ((localbmtx instanceof bmmn))
      {
        if (((bmmn)localbmtx).a != null) {
          ((bmmn)localbmtx).a.a(-1, false);
        }
        localObject1 = (bmmk)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(bmmk.jdField_a_of_type_JavaLangString);
        if (localObject1 != null)
        {
          localObject2 = ((bmmn)localbmtx).a;
          if (localObject2 != null)
          {
            if ((!((DynamicTextItem)localObject2).e()) && (((DynamicTextItem)localObject2).d())) {
              ((DynamicTextItem)localObject2).a(true);
            }
            if (!((DynamicTextItem)localObject2).b()) {
              ((bmmk)localObject1).jdField_a_of_type_JavaUtilArrayList.add((bmmn)localbmtx);
            }
          }
        }
      }
      else if ((localbmtx instanceof bmmf))
      {
        localObject1 = (bmme)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b.a("InteractPasterLayer");
        if (localObject1 != null)
        {
          ((bmme)localObject1).a = ((bmmu)localbmtx);
          ((bmme)localObject1).f();
        }
      }
      else if ((localbmtx instanceof bmmu))
      {
        localObject1 = (bmms)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b.a("VoteLayer");
        if (localObject1 != null)
        {
          ((bmms)localObject1).a = ((bmmu)localbmtx);
          ((bmms)localObject1).f();
        }
      }
    }
  }
  
  public void c()
  {
    b(this.jdField_a_of_type_Bmmi.a());
    super.c();
    this.jdField_a_of_type_Bmmi.b();
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setVisibility(4);
      return;
    }
    postDelayed(this.jdField_a_of_type_JavaLangRunnable, bmmk.e);
  }
  
  public void d()
  {
    b(false);
  }
  
  public void e()
  {
    if ((a() == 1) && (this.jdField_a_of_type_Bmmi.b()))
    {
      bmtx localbmtx = this.jdField_a_of_type_Bmmi.a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(localbmtx, 0);
      postInvalidate();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    paramCanvas.save();
    if ((this.jdField_a_of_type_Float > 0.0F) || (this.jdField_b_of_type_Float > 0.0F)) {
      paramCanvas.translate(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
    }
    this.jdField_a_of_type_Bmmi.d(paramCanvas);
    paramCanvas.restore();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f4 = 0.0F;
    Object localObject;
    int i;
    if ((this.jdField_a_of_type_Float > 0.0F) || (this.jdField_b_of_type_Float > 0.0F))
    {
      localObject = MotionEvent.obtain(paramMotionEvent);
      ((MotionEvent)localObject).setLocation(paramMotionEvent.getX() - this.jdField_a_of_type_Float, paramMotionEvent.getY() - this.jdField_b_of_type_Float);
      i = 1;
      paramMotionEvent = (MotionEvent)localObject;
    }
    for (;;)
    {
      if ((paramMotionEvent.getAction() == 0) && (this.jdField_a_of_type_Bmmi.b(paramMotionEvent))) {
        this.c = true;
      }
      boolean bool;
      if (this.c)
      {
        bool = this.jdField_a_of_type_Bmmi.c(paramMotionEvent);
        invalidate();
        if (paramMotionEvent.getAction() == 1) {
          this.c = false;
        }
        if (i != 0) {
          paramMotionEvent.recycle();
        }
        return bool;
      }
      float f5;
      float f6;
      float f1;
      float f2;
      float f3;
      if ((!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a()) && (this.jdField_a_of_type_Bmmi.b()))
      {
        localObject = this.jdField_a_of_type_Bmmi.a();
        if (((bmtx)localObject).i == 1)
        {
          this.jdField_a_of_type_Bmmi.b = ((bmtx)localObject);
          if (((bmtx)localObject).i == 1)
          {
            b((bmtx)localObject);
            f5 = ((bmtx)localObject).b.x + ((bmtx)localObject).s - ((bmtx)localObject).u * ((bmtx)localObject).q / 2.0F;
            f6 = ((bmtx)localObject).b.y + ((bmtx)localObject).t - ((bmtx)localObject).v * ((bmtx)localObject).q / 2.0F;
            if ((!((bmtx)localObject).g) || (!((bmtx)localObject).h)) {
              break label392;
            }
            f1 = ((bmtx)localObject).l + ((bmtx)localObject).j - ((bmtx)localObject).u / 2.0F;
            f2 = ((bmtx)localObject).m + ((bmtx)localObject).jdField_k_of_type_Float - ((bmtx)localObject).v / 2.0F;
            f3 = f1 - f5;
            f4 = f2 - f6;
          }
        }
      }
      for (;;)
      {
        ((bmtx)localObject).o = ((bmtx)localObject).q;
        ((bmtx)localObject).i = 2;
        DoodleLayout localDoodleLayout = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
        f5 = ((bmtx)localObject).u;
        f6 = ((bmtx)localObject).q;
        float f7 = ((bmtx)localObject).v;
        localDoodleLayout.a(f1, f2, f5 * f6, ((bmtx)localObject).q * f7, f3, f4);
        d();
        bool = false;
        break;
        label392:
        f3 = 0.0F;
        f2 = f6;
        f1 = f5;
      }
      i = 0;
    }
  }
  
  public void setDoodleEditViewListener(bmpb parambmpb)
  {
    this.jdField_a_of_type_Bmpb = parambmpb;
  }
  
  public void setFrom(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setOnLayerTouchListener()
  {
    this.jdField_a_of_type_Bmmi.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_Bmqb);
    this.jdField_a_of_type_Bmmi.a(new bmoy(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView
 * JD-Core Version:    0.7.0.1
 */