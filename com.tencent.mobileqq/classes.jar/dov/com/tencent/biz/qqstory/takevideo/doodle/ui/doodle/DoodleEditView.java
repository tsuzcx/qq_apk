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
import bjcu;
import bkak;
import bkao;
import bkau;
import bkav;
import bkay;
import bkba;
import bkbd;
import bkbi;
import bkbk;
import bkdn;
import bkdo;
import bkdp;
import bkdq;
import bkdr;
import bkeo;
import bkin;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.EditPicRawImage;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.ArrayList;
import java.util.List;
import ved;

public class DoodleEditView
  extends DoodleView
  implements bkeo
{
  private float jdField_a_of_type_Float;
  private bjcu jdField_a_of_type_Bjcu;
  public bkay a;
  private bkdr jdField_a_of_type_Bkdr;
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
  
  public bjcu a()
  {
    return this.jdField_a_of_type_Bjcu;
  }
  
  public bkay a()
  {
    return this.jdField_a_of_type_Bkay;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Bkay = new bkay(this);
    this.jdField_a_of_type_Bjcu = new bkdn(this);
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
  
  public void a(bkin parambkin)
  {
    if (parambkin == null) {}
    ValueAnimator localValueAnimator1;
    do
    {
      return;
      ValueAnimator localValueAnimator2 = parambkin.a;
      localValueAnimator1 = localValueAnimator2;
      if (localValueAnimator2 == null)
      {
        localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.7F, 1.0F, 0.7F, 1.0F });
        localValueAnimator1.setStartDelay(300L);
        localValueAnimator1.setDuration(2000L);
        localValueAnimator1.setRepeatMode(1);
        localValueAnimator1.setRepeatCount(-1);
        localValueAnimator1.setInterpolator(new LinearInterpolator());
        localValueAnimator1.addUpdateListener(new bkdp(this, parambkin));
        localValueAnimator1.addListener(new bkdq(this, parambkin));
        parambkin.a = localValueAnimator1;
      }
    } while ((parambkin.a.isStarted()) || (parambkin.a.isRunning()));
    ved.b("DoodleEditView", "breathScale start ");
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
    bkin localbkin = this.jdField_a_of_type_Bkay.a();
    if (localbkin != null) {
      localbkin.d();
    }
    if (this.jdField_a_of_type_Bkay.b != null)
    {
      this.jdField_a_of_type_Bkay.b.d();
      this.jdField_a_of_type_Bkay.b = null;
    }
  }
  
  public void b(bkin parambkin)
  {
    if (parambkin == null) {}
    while ((parambkin.a == null) || (!parambkin.a.isRunning())) {
      return;
    }
    ved.b("DoodleEditView", "cancelNailAnimator");
    parambkin.a.cancel();
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    bkin localbkin;
    Object localObject2;
    Object localObject1;
    if ((paramBoolean) || ((!paramBoolean) && (getVisibility() == 0))) {
      if (this.jdField_a_of_type_Bkay.b())
      {
        localbkin = this.jdField_a_of_type_Bkay.a();
        localbkin.jdField_k_of_type_Boolean = false;
        if (!(localbkin instanceof bkao)) {
          break label220;
        }
        localObject2 = (bkak)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(bkak.jdField_a_of_type_JavaLangString);
        bkao localbkao = (bkao)localbkin;
        if (((bkao)localbkin).h != 1)
        {
          localObject1 = localObject2;
          if (((bkao)localbkin).h != 3) {}
        }
        else if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) {}
        }
        else
        {
          localObject1 = (bkak)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("DynamicFaceLayer");
          ((bkao)localbkin).a.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
        }
        if (localObject1 != null) {
          ((bkak)localObject1).jdField_a_of_type_JavaUtilList.add(localbkao);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
      this.jdField_a_of_type_Bkay.c();
      setVisibility(8);
      if (this.jdField_a_of_type_Bkdr != null) {
        this.jdField_a_of_type_Bkdr.a();
      }
      return;
      label220:
      if ((localbkin instanceof bkbd))
      {
        if (((bkbd)localbkin).a != null) {
          ((bkbd)localbkin).a.a(-1, false);
        }
        localObject1 = (bkba)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(bkba.jdField_a_of_type_JavaLangString);
        if (localObject1 != null)
        {
          localObject2 = ((bkbd)localbkin).a;
          if (localObject2 != null)
          {
            if ((!((DynamicTextItem)localObject2).e()) && (((DynamicTextItem)localObject2).d())) {
              ((DynamicTextItem)localObject2).a(true);
            }
            if (!((DynamicTextItem)localObject2).b()) {
              ((bkba)localObject1).jdField_a_of_type_JavaUtilArrayList.add((bkbd)localbkin);
            }
          }
        }
      }
      else if ((localbkin instanceof bkav))
      {
        localObject1 = (bkau)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b.a("InteractPasterLayer");
        if (localObject1 != null)
        {
          ((bkau)localObject1).a = ((bkbk)localbkin);
          ((bkau)localObject1).f();
        }
      }
      else if ((localbkin instanceof bkbk))
      {
        localObject1 = (bkbi)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b.a("VoteLayer");
        if (localObject1 != null)
        {
          ((bkbi)localObject1).a = ((bkbk)localbkin);
          ((bkbi)localObject1).f();
        }
      }
    }
  }
  
  public void c()
  {
    b(this.jdField_a_of_type_Bkay.a());
    super.c();
    this.jdField_a_of_type_Bkay.b();
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
    postDelayed(this.jdField_a_of_type_JavaLangRunnable, bkba.e);
  }
  
  public void d()
  {
    b(false);
  }
  
  public void e()
  {
    if ((a() == 1) && (this.jdField_a_of_type_Bkay.b()))
    {
      bkin localbkin = this.jdField_a_of_type_Bkay.a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(localbkin, 0);
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
    this.jdField_a_of_type_Bkay.d(paramCanvas);
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
      if ((paramMotionEvent.getAction() == 0) && (this.jdField_a_of_type_Bkay.b(paramMotionEvent))) {
        this.c = true;
      }
      boolean bool;
      if (this.c)
      {
        bool = this.jdField_a_of_type_Bkay.c(paramMotionEvent);
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
      if ((!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a()) && (this.jdField_a_of_type_Bkay.b()))
      {
        localObject = this.jdField_a_of_type_Bkay.a();
        if (((bkin)localObject).i == 1)
        {
          this.jdField_a_of_type_Bkay.b = ((bkin)localObject);
          if (((bkin)localObject).i == 1)
          {
            b((bkin)localObject);
            f5 = ((bkin)localObject).b.x + ((bkin)localObject).s - ((bkin)localObject).u * ((bkin)localObject).q / 2.0F;
            f6 = ((bkin)localObject).b.y + ((bkin)localObject).t - ((bkin)localObject).v * ((bkin)localObject).q / 2.0F;
            if ((!((bkin)localObject).g) || (!((bkin)localObject).h)) {
              break label392;
            }
            f1 = ((bkin)localObject).l + ((bkin)localObject).j - ((bkin)localObject).u / 2.0F;
            f2 = ((bkin)localObject).m + ((bkin)localObject).jdField_k_of_type_Float - ((bkin)localObject).v / 2.0F;
            f3 = f1 - f5;
            f4 = f2 - f6;
          }
        }
      }
      for (;;)
      {
        ((bkin)localObject).o = ((bkin)localObject).q;
        ((bkin)localObject).i = 2;
        DoodleLayout localDoodleLayout = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
        f5 = ((bkin)localObject).u;
        f6 = ((bkin)localObject).q;
        float f7 = ((bkin)localObject).v;
        localDoodleLayout.a(f1, f2, f5 * f6, ((bkin)localObject).q * f7, f3, f4);
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
  
  public void setDoodleEditViewListener(bkdr parambkdr)
  {
    this.jdField_a_of_type_Bkdr = parambkdr;
  }
  
  public void setFrom(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setOnLayerTouchListener()
  {
    this.jdField_a_of_type_Bkay.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_Bker);
    this.jdField_a_of_type_Bkay.a(new bkdo(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView
 * JD-Core Version:    0.7.0.1
 */