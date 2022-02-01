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
import bpnq;
import bqjh;
import bqjl;
import bqjr;
import bqjs;
import bqjv;
import bqjx;
import bqka;
import bqkf;
import bqkh;
import bqmk;
import bqml;
import bqmm;
import bqmn;
import bqmo;
import bqnl;
import bqrk;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.EditPicRawImage;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.ArrayList;
import java.util.List;
import yuk;

public class DoodleEditView
  extends DoodleView
  implements bqnl
{
  private float jdField_a_of_type_Float;
  private bpnq jdField_a_of_type_Bpnq;
  public bqjv a;
  private bqmo jdField_a_of_type_Bqmo;
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
  
  public bpnq a()
  {
    return this.jdField_a_of_type_Bpnq;
  }
  
  public bqjv a()
  {
    return this.jdField_a_of_type_Bqjv;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Bqjv = new bqjv(this);
    this.jdField_a_of_type_Bpnq = new bqmk(this);
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
  
  public void a(bqrk parambqrk)
  {
    if (parambqrk == null) {}
    ValueAnimator localValueAnimator1;
    do
    {
      return;
      ValueAnimator localValueAnimator2 = parambqrk.a;
      localValueAnimator1 = localValueAnimator2;
      if (localValueAnimator2 == null)
      {
        localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.7F, 1.0F, 0.7F, 1.0F });
        localValueAnimator1.setStartDelay(300L);
        localValueAnimator1.setDuration(2000L);
        localValueAnimator1.setRepeatMode(1);
        localValueAnimator1.setRepeatCount(-1);
        localValueAnimator1.setInterpolator(new LinearInterpolator());
        localValueAnimator1.addUpdateListener(new bqmm(this, parambqrk));
        localValueAnimator1.addListener(new bqmn(this, parambqrk));
        parambqrk.a = localValueAnimator1;
      }
    } while ((parambqrk.a.isStarted()) || (parambqrk.a.isRunning()));
    yuk.b("DoodleEditView", "breathScale start ");
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
    bqrk localbqrk = this.jdField_a_of_type_Bqjv.a();
    if (localbqrk != null) {
      localbqrk.d();
    }
    if (this.jdField_a_of_type_Bqjv.b != null)
    {
      this.jdField_a_of_type_Bqjv.b.d();
      this.jdField_a_of_type_Bqjv.b = null;
    }
  }
  
  public void b(bqrk parambqrk)
  {
    if (parambqrk == null) {}
    while ((parambqrk.a == null) || (!parambqrk.a.isRunning())) {
      return;
    }
    yuk.b("DoodleEditView", "cancelNailAnimator");
    parambqrk.a.cancel();
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    bqrk localbqrk;
    Object localObject2;
    Object localObject1;
    if ((paramBoolean) || ((!paramBoolean) && (getVisibility() == 0))) {
      if (this.jdField_a_of_type_Bqjv.b())
      {
        localbqrk = this.jdField_a_of_type_Bqjv.a();
        localbqrk.jdField_k_of_type_Boolean = false;
        if (!(localbqrk instanceof bqjl)) {
          break label220;
        }
        localObject2 = (bqjh)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(bqjh.jdField_a_of_type_JavaLangString);
        bqjl localbqjl = (bqjl)localbqrk;
        if (((bqjl)localbqrk).h != 1)
        {
          localObject1 = localObject2;
          if (((bqjl)localbqrk).h != 3) {}
        }
        else if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) {}
        }
        else
        {
          localObject1 = (bqjh)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("DynamicFaceLayer");
          ((bqjl)localbqrk).a.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
        }
        if (localObject1 != null) {
          ((bqjh)localObject1).jdField_a_of_type_JavaUtilList.add(localbqjl);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
      this.jdField_a_of_type_Bqjv.c();
      setVisibility(8);
      if (this.jdField_a_of_type_Bqmo != null) {
        this.jdField_a_of_type_Bqmo.a();
      }
      return;
      label220:
      if ((localbqrk instanceof bqka))
      {
        if (((bqka)localbqrk).a != null) {
          ((bqka)localbqrk).a.a(-1, false);
        }
        localObject1 = (bqjx)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(bqjx.jdField_a_of_type_JavaLangString);
        if (localObject1 != null)
        {
          localObject2 = ((bqka)localbqrk).a;
          if (localObject2 != null)
          {
            if ((!((DynamicTextItem)localObject2).e()) && (((DynamicTextItem)localObject2).d())) {
              ((DynamicTextItem)localObject2).a(true);
            }
            if (!((DynamicTextItem)localObject2).b()) {
              ((bqjx)localObject1).jdField_a_of_type_JavaUtilArrayList.add((bqka)localbqrk);
            }
          }
        }
      }
      else if ((localbqrk instanceof bqjs))
      {
        localObject1 = (bqjr)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b.a("InteractPasterLayer");
        if (localObject1 != null)
        {
          ((bqjr)localObject1).a = ((bqkh)localbqrk);
          ((bqjr)localObject1).f();
        }
      }
      else if ((localbqrk instanceof bqkh))
      {
        localObject1 = (bqkf)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b.a("VoteLayer");
        if (localObject1 != null)
        {
          ((bqkf)localObject1).a = ((bqkh)localbqrk);
          ((bqkf)localObject1).f();
        }
      }
    }
  }
  
  public void c()
  {
    b(this.jdField_a_of_type_Bqjv.a());
    super.c();
    this.jdField_a_of_type_Bqjv.b();
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
    postDelayed(this.jdField_a_of_type_JavaLangRunnable, bqjx.e);
  }
  
  public void d()
  {
    b(false);
  }
  
  public void e()
  {
    if ((a() == 1) && (this.jdField_a_of_type_Bqjv.b()))
    {
      bqrk localbqrk = this.jdField_a_of_type_Bqjv.a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(localbqrk, 0);
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
    this.jdField_a_of_type_Bqjv.d(paramCanvas);
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
      if ((paramMotionEvent.getAction() == 0) && (this.jdField_a_of_type_Bqjv.b(paramMotionEvent))) {
        this.c = true;
      }
      boolean bool;
      if (this.c)
      {
        bool = this.jdField_a_of_type_Bqjv.c(paramMotionEvent);
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
      if ((!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a()) && (this.jdField_a_of_type_Bqjv.b()))
      {
        localObject = this.jdField_a_of_type_Bqjv.a();
        if (((bqrk)localObject).i == 1)
        {
          this.jdField_a_of_type_Bqjv.b = ((bqrk)localObject);
          if (((bqrk)localObject).i == 1)
          {
            b((bqrk)localObject);
            f5 = ((bqrk)localObject).b.x + ((bqrk)localObject).s - ((bqrk)localObject).u * ((bqrk)localObject).q / 2.0F;
            f6 = ((bqrk)localObject).b.y + ((bqrk)localObject).t - ((bqrk)localObject).v * ((bqrk)localObject).q / 2.0F;
            if ((!((bqrk)localObject).g) || (!((bqrk)localObject).h)) {
              break label392;
            }
            f1 = ((bqrk)localObject).l + ((bqrk)localObject).j - ((bqrk)localObject).u / 2.0F;
            f2 = ((bqrk)localObject).m + ((bqrk)localObject).jdField_k_of_type_Float - ((bqrk)localObject).v / 2.0F;
            f3 = f1 - f5;
            f4 = f2 - f6;
          }
        }
      }
      for (;;)
      {
        ((bqrk)localObject).o = ((bqrk)localObject).q;
        ((bqrk)localObject).i = 2;
        DoodleLayout localDoodleLayout = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
        f5 = ((bqrk)localObject).u;
        f6 = ((bqrk)localObject).q;
        float f7 = ((bqrk)localObject).v;
        localDoodleLayout.a(f1, f2, f5 * f6, ((bqrk)localObject).q * f7, f3, f4);
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
  
  public void setDoodleEditViewListener(bqmo parambqmo)
  {
    this.jdField_a_of_type_Bqmo = parambqmo;
  }
  
  public void setFrom(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setOnLayerTouchListener()
  {
    this.jdField_a_of_type_Bqjv.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_Bqno);
    this.jdField_a_of_type_Bqjv.a(new bqml(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView
 * JD-Core Version:    0.7.0.1
 */