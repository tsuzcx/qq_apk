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
import blsr;
import bmqg;
import bmqk;
import bmqq;
import bmqr;
import bmqu;
import bmqw;
import bmqz;
import bmre;
import bmrg;
import bmtj;
import bmtk;
import bmtl;
import bmtm;
import bmtn;
import bmuk;
import bmyj;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.EditPicRawImage;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.ArrayList;
import java.util.List;
import wxe;

public class DoodleEditView
  extends DoodleView
  implements bmuk
{
  private float jdField_a_of_type_Float;
  private blsr jdField_a_of_type_Blsr;
  public bmqu a;
  private bmtn jdField_a_of_type_Bmtn;
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
  
  public blsr a()
  {
    return this.jdField_a_of_type_Blsr;
  }
  
  public bmqu a()
  {
    return this.jdField_a_of_type_Bmqu;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Bmqu = new bmqu(this);
    this.jdField_a_of_type_Blsr = new bmtj(this);
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
  
  public void a(bmyj parambmyj)
  {
    if (parambmyj == null) {}
    ValueAnimator localValueAnimator1;
    do
    {
      return;
      ValueAnimator localValueAnimator2 = parambmyj.a;
      localValueAnimator1 = localValueAnimator2;
      if (localValueAnimator2 == null)
      {
        localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.7F, 1.0F, 0.7F, 1.0F });
        localValueAnimator1.setStartDelay(300L);
        localValueAnimator1.setDuration(2000L);
        localValueAnimator1.setRepeatMode(1);
        localValueAnimator1.setRepeatCount(-1);
        localValueAnimator1.setInterpolator(new LinearInterpolator());
        localValueAnimator1.addUpdateListener(new bmtl(this, parambmyj));
        localValueAnimator1.addListener(new bmtm(this, parambmyj));
        parambmyj.a = localValueAnimator1;
      }
    } while ((parambmyj.a.isStarted()) || (parambmyj.a.isRunning()));
    wxe.b("DoodleEditView", "breathScale start ");
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
    bmyj localbmyj = this.jdField_a_of_type_Bmqu.a();
    if (localbmyj != null) {
      localbmyj.d();
    }
    if (this.jdField_a_of_type_Bmqu.b != null)
    {
      this.jdField_a_of_type_Bmqu.b.d();
      this.jdField_a_of_type_Bmqu.b = null;
    }
  }
  
  public void b(bmyj parambmyj)
  {
    if (parambmyj == null) {}
    while ((parambmyj.a == null) || (!parambmyj.a.isRunning())) {
      return;
    }
    wxe.b("DoodleEditView", "cancelNailAnimator");
    parambmyj.a.cancel();
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    bmyj localbmyj;
    Object localObject2;
    Object localObject1;
    if ((paramBoolean) || ((!paramBoolean) && (getVisibility() == 0))) {
      if (this.jdField_a_of_type_Bmqu.b())
      {
        localbmyj = this.jdField_a_of_type_Bmqu.a();
        localbmyj.jdField_k_of_type_Boolean = false;
        if (!(localbmyj instanceof bmqk)) {
          break label220;
        }
        localObject2 = (bmqg)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(bmqg.jdField_a_of_type_JavaLangString);
        bmqk localbmqk = (bmqk)localbmyj;
        if (((bmqk)localbmyj).h != 1)
        {
          localObject1 = localObject2;
          if (((bmqk)localbmyj).h != 3) {}
        }
        else if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) {}
        }
        else
        {
          localObject1 = (bmqg)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("DynamicFaceLayer");
          ((bmqk)localbmyj).a.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
        }
        if (localObject1 != null) {
          ((bmqg)localObject1).jdField_a_of_type_JavaUtilList.add(localbmqk);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
      this.jdField_a_of_type_Bmqu.c();
      setVisibility(8);
      if (this.jdField_a_of_type_Bmtn != null) {
        this.jdField_a_of_type_Bmtn.a();
      }
      return;
      label220:
      if ((localbmyj instanceof bmqz))
      {
        if (((bmqz)localbmyj).a != null) {
          ((bmqz)localbmyj).a.a(-1, false);
        }
        localObject1 = (bmqw)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(bmqw.jdField_a_of_type_JavaLangString);
        if (localObject1 != null)
        {
          localObject2 = ((bmqz)localbmyj).a;
          if (localObject2 != null)
          {
            if ((!((DynamicTextItem)localObject2).e()) && (((DynamicTextItem)localObject2).d())) {
              ((DynamicTextItem)localObject2).a(true);
            }
            if (!((DynamicTextItem)localObject2).b()) {
              ((bmqw)localObject1).jdField_a_of_type_JavaUtilArrayList.add((bmqz)localbmyj);
            }
          }
        }
      }
      else if ((localbmyj instanceof bmqr))
      {
        localObject1 = (bmqq)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b.a("InteractPasterLayer");
        if (localObject1 != null)
        {
          ((bmqq)localObject1).a = ((bmrg)localbmyj);
          ((bmqq)localObject1).f();
        }
      }
      else if ((localbmyj instanceof bmrg))
      {
        localObject1 = (bmre)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b.a("VoteLayer");
        if (localObject1 != null)
        {
          ((bmre)localObject1).a = ((bmrg)localbmyj);
          ((bmre)localObject1).f();
        }
      }
    }
  }
  
  public void c()
  {
    b(this.jdField_a_of_type_Bmqu.a());
    super.c();
    this.jdField_a_of_type_Bmqu.b();
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
    postDelayed(this.jdField_a_of_type_JavaLangRunnable, bmqw.e);
  }
  
  public void d()
  {
    b(false);
  }
  
  public void e()
  {
    if ((a() == 1) && (this.jdField_a_of_type_Bmqu.b()))
    {
      bmyj localbmyj = this.jdField_a_of_type_Bmqu.a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(localbmyj, 0);
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
    this.jdField_a_of_type_Bmqu.d(paramCanvas);
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
      if ((paramMotionEvent.getAction() == 0) && (this.jdField_a_of_type_Bmqu.b(paramMotionEvent))) {
        this.c = true;
      }
      boolean bool;
      if (this.c)
      {
        bool = this.jdField_a_of_type_Bmqu.c(paramMotionEvent);
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
      if ((!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a()) && (this.jdField_a_of_type_Bmqu.b()))
      {
        localObject = this.jdField_a_of_type_Bmqu.a();
        if (((bmyj)localObject).i == 1)
        {
          this.jdField_a_of_type_Bmqu.b = ((bmyj)localObject);
          if (((bmyj)localObject).i == 1)
          {
            b((bmyj)localObject);
            f5 = ((bmyj)localObject).b.x + ((bmyj)localObject).s - ((bmyj)localObject).u * ((bmyj)localObject).q / 2.0F;
            f6 = ((bmyj)localObject).b.y + ((bmyj)localObject).t - ((bmyj)localObject).v * ((bmyj)localObject).q / 2.0F;
            if ((!((bmyj)localObject).g) || (!((bmyj)localObject).h)) {
              break label392;
            }
            f1 = ((bmyj)localObject).l + ((bmyj)localObject).j - ((bmyj)localObject).u / 2.0F;
            f2 = ((bmyj)localObject).m + ((bmyj)localObject).jdField_k_of_type_Float - ((bmyj)localObject).v / 2.0F;
            f3 = f1 - f5;
            f4 = f2 - f6;
          }
        }
      }
      for (;;)
      {
        ((bmyj)localObject).o = ((bmyj)localObject).q;
        ((bmyj)localObject).i = 2;
        DoodleLayout localDoodleLayout = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
        f5 = ((bmyj)localObject).u;
        f6 = ((bmyj)localObject).q;
        float f7 = ((bmyj)localObject).v;
        localDoodleLayout.a(f1, f2, f5 * f6, ((bmyj)localObject).q * f7, f3, f4);
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
  
  public void setDoodleEditViewListener(bmtn parambmtn)
  {
    this.jdField_a_of_type_Bmtn = parambmtn;
  }
  
  public void setFrom(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setOnLayerTouchListener()
  {
    this.jdField_a_of_type_Bmqu.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_Bmun);
    this.jdField_a_of_type_Bmqu.a(new bmtk(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView
 * JD-Core Version:    0.7.0.1
 */