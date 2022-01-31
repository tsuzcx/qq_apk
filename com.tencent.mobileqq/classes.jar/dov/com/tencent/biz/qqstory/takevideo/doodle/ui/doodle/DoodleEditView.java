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
import bhhl;
import biiy;
import bijc;
import biji;
import bijj;
import bijm;
import bijo;
import bijr;
import bijw;
import bijy;
import bimb;
import bimc;
import bimd;
import bime;
import bimf;
import binc;
import birb;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.EditPicRawImage;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.ArrayList;
import java.util.List;
import urk;

public class DoodleEditView
  extends DoodleView
  implements binc
{
  private float jdField_a_of_type_Float;
  private bhhl jdField_a_of_type_Bhhl;
  public bijm a;
  private bimf jdField_a_of_type_Bimf;
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
  
  public bhhl a()
  {
    return this.jdField_a_of_type_Bhhl;
  }
  
  public bijm a()
  {
    return this.jdField_a_of_type_Bijm;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Bijm = new bijm(this);
    this.jdField_a_of_type_Bhhl = new bimb(this);
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
  
  public void a(birb parambirb)
  {
    if (parambirb == null) {}
    ValueAnimator localValueAnimator1;
    do
    {
      return;
      ValueAnimator localValueAnimator2 = parambirb.a;
      localValueAnimator1 = localValueAnimator2;
      if (localValueAnimator2 == null)
      {
        localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.7F, 1.0F, 0.7F, 1.0F });
        localValueAnimator1.setStartDelay(300L);
        localValueAnimator1.setDuration(2000L);
        localValueAnimator1.setRepeatMode(1);
        localValueAnimator1.setRepeatCount(-1);
        localValueAnimator1.setInterpolator(new LinearInterpolator());
        localValueAnimator1.addUpdateListener(new bimd(this, parambirb));
        localValueAnimator1.addListener(new bime(this, parambirb));
        parambirb.a = localValueAnimator1;
      }
    } while ((parambirb.a.isStarted()) || (parambirb.a.isRunning()));
    urk.b("DoodleEditView", "breathScale start ");
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
    birb localbirb = this.jdField_a_of_type_Bijm.a();
    if (localbirb != null) {
      localbirb.d();
    }
    if (this.jdField_a_of_type_Bijm.b != null)
    {
      this.jdField_a_of_type_Bijm.b.d();
      this.jdField_a_of_type_Bijm.b = null;
    }
  }
  
  public void b(birb parambirb)
  {
    if (parambirb == null) {}
    while ((parambirb.a == null) || (!parambirb.a.isRunning())) {
      return;
    }
    urk.b("DoodleEditView", "cancelNailAnimator");
    parambirb.a.cancel();
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    birb localbirb;
    Object localObject2;
    Object localObject1;
    if ((paramBoolean) || ((!paramBoolean) && (getVisibility() == 0))) {
      if (this.jdField_a_of_type_Bijm.b())
      {
        localbirb = this.jdField_a_of_type_Bijm.a();
        localbirb.jdField_k_of_type_Boolean = false;
        if (!(localbirb instanceof bijc)) {
          break label220;
        }
        localObject2 = (biiy)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(biiy.jdField_a_of_type_JavaLangString);
        bijc localbijc = (bijc)localbirb;
        if (((bijc)localbirb).h != 1)
        {
          localObject1 = localObject2;
          if (((bijc)localbirb).h != 3) {}
        }
        else if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) {}
        }
        else
        {
          localObject1 = (biiy)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("DynamicFaceLayer");
          ((bijc)localbirb).a.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
        }
        if (localObject1 != null) {
          ((biiy)localObject1).jdField_a_of_type_JavaUtilList.add(localbijc);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
      this.jdField_a_of_type_Bijm.c();
      setVisibility(8);
      if (this.jdField_a_of_type_Bimf != null) {
        this.jdField_a_of_type_Bimf.a();
      }
      return;
      label220:
      if ((localbirb instanceof bijr))
      {
        if (((bijr)localbirb).a != null) {
          ((bijr)localbirb).a.a(-1, false);
        }
        localObject1 = (bijo)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(bijo.jdField_a_of_type_JavaLangString);
        if (localObject1 != null)
        {
          localObject2 = ((bijr)localbirb).a;
          if (localObject2 != null)
          {
            if ((!((DynamicTextItem)localObject2).e()) && (((DynamicTextItem)localObject2).d())) {
              ((DynamicTextItem)localObject2).a(true);
            }
            if (!((DynamicTextItem)localObject2).b()) {
              ((bijo)localObject1).jdField_a_of_type_JavaUtilArrayList.add((bijr)localbirb);
            }
          }
        }
      }
      else if ((localbirb instanceof bijj))
      {
        localObject1 = (biji)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b.a("InteractPasterLayer");
        if (localObject1 != null)
        {
          ((biji)localObject1).a = ((bijy)localbirb);
          ((biji)localObject1).f();
        }
      }
      else if ((localbirb instanceof bijy))
      {
        localObject1 = (bijw)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b.a("VoteLayer");
        if (localObject1 != null)
        {
          ((bijw)localObject1).a = ((bijy)localbirb);
          ((bijw)localObject1).f();
        }
      }
    }
  }
  
  public void c()
  {
    b(this.jdField_a_of_type_Bijm.a());
    super.c();
    this.jdField_a_of_type_Bijm.b();
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
    postDelayed(this.jdField_a_of_type_JavaLangRunnable, bijo.e);
  }
  
  public void d()
  {
    b(false);
  }
  
  public void e()
  {
    if ((a() == 1) && (this.jdField_a_of_type_Bijm.b()))
    {
      birb localbirb = this.jdField_a_of_type_Bijm.a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(localbirb, 0);
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
    this.jdField_a_of_type_Bijm.d(paramCanvas);
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
      if ((paramMotionEvent.getAction() == 0) && (this.jdField_a_of_type_Bijm.b(paramMotionEvent))) {
        this.c = true;
      }
      boolean bool;
      if (this.c)
      {
        bool = this.jdField_a_of_type_Bijm.c(paramMotionEvent);
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
      if ((!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a()) && (this.jdField_a_of_type_Bijm.b()))
      {
        localObject = this.jdField_a_of_type_Bijm.a();
        if (((birb)localObject).i == 1)
        {
          this.jdField_a_of_type_Bijm.b = ((birb)localObject);
          if (((birb)localObject).i == 1)
          {
            b((birb)localObject);
            f5 = ((birb)localObject).b.x + ((birb)localObject).s - ((birb)localObject).u * ((birb)localObject).q / 2.0F;
            f6 = ((birb)localObject).b.y + ((birb)localObject).t - ((birb)localObject).v * ((birb)localObject).q / 2.0F;
            if ((!((birb)localObject).g) || (!((birb)localObject).h)) {
              break label392;
            }
            f1 = ((birb)localObject).l + ((birb)localObject).j - ((birb)localObject).u / 2.0F;
            f2 = ((birb)localObject).m + ((birb)localObject).jdField_k_of_type_Float - ((birb)localObject).v / 2.0F;
            f3 = f1 - f5;
            f4 = f2 - f6;
          }
        }
      }
      for (;;)
      {
        ((birb)localObject).o = ((birb)localObject).q;
        ((birb)localObject).i = 2;
        DoodleLayout localDoodleLayout = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
        f5 = ((birb)localObject).u;
        f6 = ((birb)localObject).q;
        float f7 = ((birb)localObject).v;
        localDoodleLayout.a(f1, f2, f5 * f6, ((birb)localObject).q * f7, f3, f4);
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
  
  public void setDoodleEditViewListener(bimf parambimf)
  {
    this.jdField_a_of_type_Bimf = parambimf;
  }
  
  public void setFrom(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setOnLayerTouchListener()
  {
    this.jdField_a_of_type_Bijm.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_Binf);
    this.jdField_a_of_type_Bijm.a(new bimc(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView
 * JD-Core Version:    0.7.0.1
 */