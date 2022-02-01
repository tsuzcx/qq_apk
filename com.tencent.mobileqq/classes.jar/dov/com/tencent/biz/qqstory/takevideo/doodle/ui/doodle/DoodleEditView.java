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
import boid;
import bovr;
import bovv;
import bowd;
import bowf;
import bowi;
import boyo;
import boyp;
import boyq;
import boyr;
import boys;
import bozm;
import bpdg;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.EditPicRawImage;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.ArrayList;
import java.util.List;
import ykq;

public class DoodleEditView
  extends DoodleView
  implements bozm
{
  private float jdField_a_of_type_Float;
  private boid jdField_a_of_type_Boid;
  public bowd a;
  private boys jdField_a_of_type_Boys;
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
  
  public boid a()
  {
    return this.jdField_a_of_type_Boid;
  }
  
  public bowd a()
  {
    return this.jdField_a_of_type_Bowd;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Bowd = new bowd(this);
    this.jdField_a_of_type_Boid = new boyo(this);
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
  
  public void a(bpdg parambpdg)
  {
    if (parambpdg == null) {}
    ValueAnimator localValueAnimator1;
    do
    {
      return;
      ValueAnimator localValueAnimator2 = parambpdg.jdField_a_of_type_AndroidAnimationValueAnimator;
      localValueAnimator1 = localValueAnimator2;
      if (localValueAnimator2 == null)
      {
        localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.7F, 1.0F, 0.7F, 1.0F });
        localValueAnimator1.setStartDelay(300L);
        localValueAnimator1.setDuration(2000L);
        localValueAnimator1.setRepeatMode(1);
        localValueAnimator1.setRepeatCount(-1);
        localValueAnimator1.setInterpolator(new LinearInterpolator());
        localValueAnimator1.addUpdateListener(new boyq(this, parambpdg));
        localValueAnimator1.addListener(new boyr(this, parambpdg));
        parambpdg.jdField_a_of_type_AndroidAnimationValueAnimator = localValueAnimator1;
      }
    } while ((parambpdg.jdField_a_of_type_AndroidAnimationValueAnimator.isStarted()) || (parambpdg.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()));
    ykq.b("DoodleEditView", "breathScale start ");
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
    bpdg localbpdg;
    Object localObject2;
    Object localObject1;
    if ((paramBoolean) || ((!paramBoolean) && (getVisibility() == 0))) {
      if (this.jdField_a_of_type_Bowd.b())
      {
        localbpdg = this.jdField_a_of_type_Bowd.a();
        localbpdg.jdField_k_of_type_Boolean = false;
        if (!(localbpdg instanceof bovv)) {
          break label220;
        }
        localObject2 = (bovr)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(bovr.jdField_a_of_type_JavaLangString);
        bovv localbovv = (bovv)localbpdg;
        if (((bovv)localbpdg).h != 1)
        {
          localObject1 = localObject2;
          if (((bovv)localbpdg).h != 3) {}
        }
        else if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) {}
        }
        else
        {
          localObject1 = (bovr)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("DynamicFaceLayer");
          ((bovv)localbpdg).a.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
        }
        if (localObject1 != null) {
          ((bovr)localObject1).jdField_a_of_type_JavaUtilList.add(localbovv);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
      this.jdField_a_of_type_Bowd.c();
      setVisibility(8);
      if (this.jdField_a_of_type_Boys != null) {
        this.jdField_a_of_type_Boys.a();
      }
      return;
      label220:
      if ((localbpdg instanceof bowi))
      {
        if (((bowi)localbpdg).a != null) {
          ((bowi)localbpdg).a.a(-1, false);
        }
        localObject1 = (bowf)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(bowf.jdField_a_of_type_JavaLangString);
        if (localObject1 != null)
        {
          localObject2 = ((bowi)localbpdg).a;
          if (localObject2 != null)
          {
            if ((!((DynamicTextItem)localObject2).e()) && (((DynamicTextItem)localObject2).d())) {
              ((DynamicTextItem)localObject2).a(true);
            }
            if (!((DynamicTextItem)localObject2).b()) {
              ((bowf)localObject1).jdField_a_of_type_JavaUtilArrayList.add((bowi)localbpdg);
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
    bpdg localbpdg = this.jdField_a_of_type_Bowd.a();
    if (localbpdg != null) {
      localbpdg.d();
    }
    if (this.jdField_a_of_type_Bowd.b != null)
    {
      this.jdField_a_of_type_Bowd.b.d();
      this.jdField_a_of_type_Bowd.b = null;
    }
  }
  
  public void b(bpdg parambpdg)
  {
    if (parambpdg == null) {}
    while ((parambpdg.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (!parambpdg.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
      return;
    }
    ykq.b("DoodleEditView", "cancelNailAnimator");
    parambpdg.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setVisibility(4);
      return;
    }
    postDelayed(this.jdField_a_of_type_JavaLangRunnable, bowf.e);
  }
  
  public void c()
  {
    b(this.jdField_a_of_type_Bowd.a());
    super.c();
    this.jdField_a_of_type_Bowd.b();
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
  }
  
  public void d()
  {
    a(false);
  }
  
  public void e()
  {
    if ((a() == 1) && (this.jdField_a_of_type_Bowd.b()))
    {
      bpdg localbpdg = this.jdField_a_of_type_Bowd.a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(localbpdg, 0);
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
    this.jdField_a_of_type_Bowd.d(paramCanvas);
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
      if ((paramMotionEvent.getAction() == 0) && (this.jdField_a_of_type_Bowd.b(paramMotionEvent))) {
        this.c = true;
      }
      boolean bool;
      if (this.c)
      {
        bool = this.jdField_a_of_type_Bowd.c(paramMotionEvent);
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
      if ((!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a()) && (this.jdField_a_of_type_Bowd.b()))
      {
        localObject = this.jdField_a_of_type_Bowd.a();
        if (((bpdg)localObject).i == 1)
        {
          this.jdField_a_of_type_Bowd.b = ((bpdg)localObject);
          if (((bpdg)localObject).i == 1)
          {
            b((bpdg)localObject);
            f5 = ((bpdg)localObject).jdField_a_of_type_AndroidGraphicsPointF.x + ((bpdg)localObject).s - ((bpdg)localObject).u * ((bpdg)localObject).q / 2.0F;
            f6 = ((bpdg)localObject).jdField_a_of_type_AndroidGraphicsPointF.y + ((bpdg)localObject).t - ((bpdg)localObject).v * ((bpdg)localObject).q / 2.0F;
            if ((!((bpdg)localObject).g) || (!((bpdg)localObject).h)) {
              break label392;
            }
            f1 = ((bpdg)localObject).l + ((bpdg)localObject).j - ((bpdg)localObject).u / 2.0F;
            f2 = ((bpdg)localObject).m + ((bpdg)localObject).jdField_k_of_type_Float - ((bpdg)localObject).v / 2.0F;
            f3 = f1 - f5;
            f4 = f2 - f6;
          }
        }
      }
      for (;;)
      {
        ((bpdg)localObject).o = ((bpdg)localObject).q;
        ((bpdg)localObject).i = 2;
        DoodleLayout localDoodleLayout = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
        f5 = ((bpdg)localObject).u;
        f6 = ((bpdg)localObject).q;
        float f7 = ((bpdg)localObject).v;
        localDoodleLayout.a(f1, f2, f5 * f6, ((bpdg)localObject).q * f7, f3, f4);
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
  
  public void setDoodleEditViewListener(boys paramboys)
  {
    this.jdField_a_of_type_Boys = paramboys;
  }
  
  public void setFrom(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setOnLayerTouchListener()
  {
    this.jdField_a_of_type_Bowd.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_Bozp);
    this.jdField_a_of_type_Bowd.a(new boyp(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView
 * JD-Core Version:    0.7.0.1
 */