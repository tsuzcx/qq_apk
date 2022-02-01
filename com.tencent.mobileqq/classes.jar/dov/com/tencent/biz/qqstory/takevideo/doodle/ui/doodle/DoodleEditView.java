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
import bmsl;
import bnfz;
import bngd;
import bngl;
import bngn;
import bngq;
import bniw;
import bnix;
import bniy;
import bniz;
import bnja;
import bnju;
import bnno;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.EditPicRawImage;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.ArrayList;
import java.util.List;
import xvv;

public class DoodleEditView
  extends DoodleView
  implements bnju
{
  private float jdField_a_of_type_Float;
  private bmsl jdField_a_of_type_Bmsl;
  public bngl a;
  private bnja jdField_a_of_type_Bnja;
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
  
  public bmsl a()
  {
    return this.jdField_a_of_type_Bmsl;
  }
  
  public bngl a()
  {
    return this.jdField_a_of_type_Bngl;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Bngl = new bngl(this);
    this.jdField_a_of_type_Bmsl = new bniw(this);
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
  
  public void a(bnno parambnno)
  {
    if (parambnno == null) {}
    ValueAnimator localValueAnimator1;
    do
    {
      return;
      ValueAnimator localValueAnimator2 = parambnno.jdField_a_of_type_AndroidAnimationValueAnimator;
      localValueAnimator1 = localValueAnimator2;
      if (localValueAnimator2 == null)
      {
        localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.7F, 1.0F, 0.7F, 1.0F });
        localValueAnimator1.setStartDelay(300L);
        localValueAnimator1.setDuration(2000L);
        localValueAnimator1.setRepeatMode(1);
        localValueAnimator1.setRepeatCount(-1);
        localValueAnimator1.setInterpolator(new LinearInterpolator());
        localValueAnimator1.addUpdateListener(new bniy(this, parambnno));
        localValueAnimator1.addListener(new bniz(this, parambnno));
        parambnno.jdField_a_of_type_AndroidAnimationValueAnimator = localValueAnimator1;
      }
    } while ((parambnno.jdField_a_of_type_AndroidAnimationValueAnimator.isStarted()) || (parambnno.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()));
    xvv.b("DoodleEditView", "breathScale start ");
    localValueAnimator1.start();
  }
  
  public void a(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    bnno localbnno;
    Object localObject2;
    Object localObject1;
    if ((paramBoolean) || ((!paramBoolean) && (getVisibility() == 0))) {
      if (this.jdField_a_of_type_Bngl.b())
      {
        localbnno = this.jdField_a_of_type_Bngl.a();
        localbnno.jdField_k_of_type_Boolean = false;
        if (!(localbnno instanceof bngd)) {
          break label220;
        }
        localObject2 = (bnfz)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(bnfz.jdField_a_of_type_JavaLangString);
        bngd localbngd = (bngd)localbnno;
        if (((bngd)localbnno).h != 1)
        {
          localObject1 = localObject2;
          if (((bngd)localbnno).h != 3) {}
        }
        else if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) {}
        }
        else
        {
          localObject1 = (bnfz)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("DynamicFaceLayer");
          ((bngd)localbnno).a.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
        }
        if (localObject1 != null) {
          ((bnfz)localObject1).jdField_a_of_type_JavaUtilList.add(localbngd);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
      this.jdField_a_of_type_Bngl.c();
      setVisibility(8);
      if (this.jdField_a_of_type_Bnja != null) {
        this.jdField_a_of_type_Bnja.a();
      }
      return;
      label220:
      if ((localbnno instanceof bngq))
      {
        if (((bngq)localbnno).a != null) {
          ((bngq)localbnno).a.a(-1, false);
        }
        localObject1 = (bngn)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(bngn.jdField_a_of_type_JavaLangString);
        if (localObject1 != null)
        {
          localObject2 = ((bngq)localbnno).a;
          if (localObject2 != null)
          {
            if ((!((DynamicTextItem)localObject2).e()) && (((DynamicTextItem)localObject2).d())) {
              ((DynamicTextItem)localObject2).a(true);
            }
            if (!((DynamicTextItem)localObject2).b()) {
              ((bngn)localObject1).jdField_a_of_type_JavaUtilArrayList.add((bngq)localbnno);
            }
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    bnno localbnno = this.jdField_a_of_type_Bngl.a();
    if (localbnno != null) {
      localbnno.d();
    }
    if (this.jdField_a_of_type_Bngl.b != null)
    {
      this.jdField_a_of_type_Bngl.b.d();
      this.jdField_a_of_type_Bngl.b = null;
    }
  }
  
  public void b(bnno parambnno)
  {
    if (parambnno == null) {}
    while ((parambnno.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (!parambnno.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
      return;
    }
    xvv.b("DoodleEditView", "cancelNailAnimator");
    parambnno.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setVisibility(4);
      return;
    }
    postDelayed(this.jdField_a_of_type_JavaLangRunnable, bngn.e);
  }
  
  public void c()
  {
    b(this.jdField_a_of_type_Bngl.a());
    super.c();
    this.jdField_a_of_type_Bngl.b();
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
  }
  
  public void d()
  {
    a(false);
  }
  
  public void e()
  {
    if ((a() == 1) && (this.jdField_a_of_type_Bngl.b()))
    {
      bnno localbnno = this.jdField_a_of_type_Bngl.a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(localbnno, 0);
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
    this.jdField_a_of_type_Bngl.d(paramCanvas);
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
      if ((paramMotionEvent.getAction() == 0) && (this.jdField_a_of_type_Bngl.b(paramMotionEvent))) {
        this.c = true;
      }
      boolean bool;
      if (this.c)
      {
        bool = this.jdField_a_of_type_Bngl.c(paramMotionEvent);
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
      if ((!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a()) && (this.jdField_a_of_type_Bngl.b()))
      {
        localObject = this.jdField_a_of_type_Bngl.a();
        if (((bnno)localObject).i == 1)
        {
          this.jdField_a_of_type_Bngl.b = ((bnno)localObject);
          if (((bnno)localObject).i == 1)
          {
            b((bnno)localObject);
            f5 = ((bnno)localObject).jdField_a_of_type_AndroidGraphicsPointF.x + ((bnno)localObject).s - ((bnno)localObject).u * ((bnno)localObject).q / 2.0F;
            f6 = ((bnno)localObject).jdField_a_of_type_AndroidGraphicsPointF.y + ((bnno)localObject).t - ((bnno)localObject).v * ((bnno)localObject).q / 2.0F;
            if ((!((bnno)localObject).g) || (!((bnno)localObject).h)) {
              break label392;
            }
            f1 = ((bnno)localObject).l + ((bnno)localObject).j - ((bnno)localObject).u / 2.0F;
            f2 = ((bnno)localObject).m + ((bnno)localObject).jdField_k_of_type_Float - ((bnno)localObject).v / 2.0F;
            f3 = f1 - f5;
            f4 = f2 - f6;
          }
        }
      }
      for (;;)
      {
        ((bnno)localObject).o = ((bnno)localObject).q;
        ((bnno)localObject).i = 2;
        DoodleLayout localDoodleLayout = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
        f5 = ((bnno)localObject).u;
        f6 = ((bnno)localObject).q;
        float f7 = ((bnno)localObject).v;
        localDoodleLayout.a(f1, f2, f5 * f6, ((bnno)localObject).q * f7, f3, f4);
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
  
  public void setDoodleEditViewListener(bnja parambnja)
  {
    this.jdField_a_of_type_Bnja = parambnja;
  }
  
  public void setFrom(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setOnLayerTouchListener()
  {
    this.jdField_a_of_type_Bngl.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_Bnjx);
    this.jdField_a_of_type_Bngl.a(new bnix(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView
 * JD-Core Version:    0.7.0.1
 */