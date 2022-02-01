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
import bolv;
import bphm;
import bphq;
import bphw;
import bphx;
import bpia;
import bpic;
import bpif;
import bpik;
import bpim;
import bpkp;
import bpkq;
import bpkr;
import bpks;
import bpkt;
import bplq;
import bppp;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.EditPicRawImage;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.ArrayList;
import java.util.List;
import yqp;

public class DoodleEditView
  extends DoodleView
  implements bplq
{
  private float jdField_a_of_type_Float;
  private bolv jdField_a_of_type_Bolv;
  public bpia a;
  private bpkt jdField_a_of_type_Bpkt;
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
  
  public bolv a()
  {
    return this.jdField_a_of_type_Bolv;
  }
  
  public bpia a()
  {
    return this.jdField_a_of_type_Bpia;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Bpia = new bpia(this);
    this.jdField_a_of_type_Bolv = new bpkp(this);
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
  
  public void a(bppp parambppp)
  {
    if (parambppp == null) {}
    ValueAnimator localValueAnimator1;
    do
    {
      return;
      ValueAnimator localValueAnimator2 = parambppp.a;
      localValueAnimator1 = localValueAnimator2;
      if (localValueAnimator2 == null)
      {
        localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.7F, 1.0F, 0.7F, 1.0F });
        localValueAnimator1.setStartDelay(300L);
        localValueAnimator1.setDuration(2000L);
        localValueAnimator1.setRepeatMode(1);
        localValueAnimator1.setRepeatCount(-1);
        localValueAnimator1.setInterpolator(new LinearInterpolator());
        localValueAnimator1.addUpdateListener(new bpkr(this, parambppp));
        localValueAnimator1.addListener(new bpks(this, parambppp));
        parambppp.a = localValueAnimator1;
      }
    } while ((parambppp.a.isStarted()) || (parambppp.a.isRunning()));
    yqp.b("DoodleEditView", "breathScale start ");
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
    bppp localbppp = this.jdField_a_of_type_Bpia.a();
    if (localbppp != null) {
      localbppp.d();
    }
    if (this.jdField_a_of_type_Bpia.b != null)
    {
      this.jdField_a_of_type_Bpia.b.d();
      this.jdField_a_of_type_Bpia.b = null;
    }
  }
  
  public void b(bppp parambppp)
  {
    if (parambppp == null) {}
    while ((parambppp.a == null) || (!parambppp.a.isRunning())) {
      return;
    }
    yqp.b("DoodleEditView", "cancelNailAnimator");
    parambppp.a.cancel();
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    bppp localbppp;
    Object localObject2;
    Object localObject1;
    if ((paramBoolean) || ((!paramBoolean) && (getVisibility() == 0))) {
      if (this.jdField_a_of_type_Bpia.b())
      {
        localbppp = this.jdField_a_of_type_Bpia.a();
        localbppp.jdField_k_of_type_Boolean = false;
        if (!(localbppp instanceof bphq)) {
          break label220;
        }
        localObject2 = (bphm)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(bphm.jdField_a_of_type_JavaLangString);
        bphq localbphq = (bphq)localbppp;
        if (((bphq)localbppp).h != 1)
        {
          localObject1 = localObject2;
          if (((bphq)localbppp).h != 3) {}
        }
        else if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) {}
        }
        else
        {
          localObject1 = (bphm)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("DynamicFaceLayer");
          ((bphq)localbppp).a.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
        }
        if (localObject1 != null) {
          ((bphm)localObject1).jdField_a_of_type_JavaUtilList.add(localbphq);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
      this.jdField_a_of_type_Bpia.c();
      setVisibility(8);
      if (this.jdField_a_of_type_Bpkt != null) {
        this.jdField_a_of_type_Bpkt.a();
      }
      return;
      label220:
      if ((localbppp instanceof bpif))
      {
        if (((bpif)localbppp).a != null) {
          ((bpif)localbppp).a.a(-1, false);
        }
        localObject1 = (bpic)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(bpic.jdField_a_of_type_JavaLangString);
        if (localObject1 != null)
        {
          localObject2 = ((bpif)localbppp).a;
          if (localObject2 != null)
          {
            if ((!((DynamicTextItem)localObject2).e()) && (((DynamicTextItem)localObject2).d())) {
              ((DynamicTextItem)localObject2).a(true);
            }
            if (!((DynamicTextItem)localObject2).b()) {
              ((bpic)localObject1).jdField_a_of_type_JavaUtilArrayList.add((bpif)localbppp);
            }
          }
        }
      }
      else if ((localbppp instanceof bphx))
      {
        localObject1 = (bphw)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b.a("InteractPasterLayer");
        if (localObject1 != null)
        {
          ((bphw)localObject1).a = ((bpim)localbppp);
          ((bphw)localObject1).f();
        }
      }
      else if ((localbppp instanceof bpim))
      {
        localObject1 = (bpik)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b.a("VoteLayer");
        if (localObject1 != null)
        {
          ((bpik)localObject1).a = ((bpim)localbppp);
          ((bpik)localObject1).f();
        }
      }
    }
  }
  
  public void c()
  {
    b(this.jdField_a_of_type_Bpia.a());
    super.c();
    this.jdField_a_of_type_Bpia.b();
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
    postDelayed(this.jdField_a_of_type_JavaLangRunnable, bpic.e);
  }
  
  public void d()
  {
    b(false);
  }
  
  public void e()
  {
    if ((a() == 1) && (this.jdField_a_of_type_Bpia.b()))
    {
      bppp localbppp = this.jdField_a_of_type_Bpia.a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(localbppp, 0);
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
    this.jdField_a_of_type_Bpia.d(paramCanvas);
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
      if ((paramMotionEvent.getAction() == 0) && (this.jdField_a_of_type_Bpia.b(paramMotionEvent))) {
        this.c = true;
      }
      boolean bool;
      if (this.c)
      {
        bool = this.jdField_a_of_type_Bpia.c(paramMotionEvent);
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
      if ((!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a()) && (this.jdField_a_of_type_Bpia.b()))
      {
        localObject = this.jdField_a_of_type_Bpia.a();
        if (((bppp)localObject).i == 1)
        {
          this.jdField_a_of_type_Bpia.b = ((bppp)localObject);
          if (((bppp)localObject).i == 1)
          {
            b((bppp)localObject);
            f5 = ((bppp)localObject).b.x + ((bppp)localObject).s - ((bppp)localObject).u * ((bppp)localObject).q / 2.0F;
            f6 = ((bppp)localObject).b.y + ((bppp)localObject).t - ((bppp)localObject).v * ((bppp)localObject).q / 2.0F;
            if ((!((bppp)localObject).g) || (!((bppp)localObject).h)) {
              break label392;
            }
            f1 = ((bppp)localObject).l + ((bppp)localObject).j - ((bppp)localObject).u / 2.0F;
            f2 = ((bppp)localObject).m + ((bppp)localObject).jdField_k_of_type_Float - ((bppp)localObject).v / 2.0F;
            f3 = f1 - f5;
            f4 = f2 - f6;
          }
        }
      }
      for (;;)
      {
        ((bppp)localObject).o = ((bppp)localObject).q;
        ((bppp)localObject).i = 2;
        DoodleLayout localDoodleLayout = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
        f5 = ((bppp)localObject).u;
        f6 = ((bppp)localObject).q;
        float f7 = ((bppp)localObject).v;
        localDoodleLayout.a(f1, f2, f5 * f6, ((bppp)localObject).q * f7, f3, f4);
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
  
  public void setDoodleEditViewListener(bpkt parambpkt)
  {
    this.jdField_a_of_type_Bpkt = parambpkt;
  }
  
  public void setFrom(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setOnLayerTouchListener()
  {
    this.jdField_a_of_type_Bpia.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_Bplt);
    this.jdField_a_of_type_Bpia.a(new bpkq(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView
 * JD-Core Version:    0.7.0.1
 */