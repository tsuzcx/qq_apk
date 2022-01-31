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
import bjcd;
import bjzt;
import bjzx;
import bkad;
import bkae;
import bkah;
import bkaj;
import bkam;
import bkar;
import bkat;
import bkcw;
import bkcx;
import bkcy;
import bkcz;
import bkda;
import bkdx;
import bkhw;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.EditPicRawImage;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.ArrayList;
import java.util.List;
import veg;

public class DoodleEditView
  extends DoodleView
  implements bkdx
{
  private float jdField_a_of_type_Float;
  private bjcd jdField_a_of_type_Bjcd;
  public bkah a;
  private bkda jdField_a_of_type_Bkda;
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
  
  public bjcd a()
  {
    return this.jdField_a_of_type_Bjcd;
  }
  
  public bkah a()
  {
    return this.jdField_a_of_type_Bkah;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Bkah = new bkah(this);
    this.jdField_a_of_type_Bjcd = new bkcw(this);
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
  
  public void a(bkhw parambkhw)
  {
    if (parambkhw == null) {}
    ValueAnimator localValueAnimator1;
    do
    {
      return;
      ValueAnimator localValueAnimator2 = parambkhw.a;
      localValueAnimator1 = localValueAnimator2;
      if (localValueAnimator2 == null)
      {
        localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.7F, 1.0F, 0.7F, 1.0F });
        localValueAnimator1.setStartDelay(300L);
        localValueAnimator1.setDuration(2000L);
        localValueAnimator1.setRepeatMode(1);
        localValueAnimator1.setRepeatCount(-1);
        localValueAnimator1.setInterpolator(new LinearInterpolator());
        localValueAnimator1.addUpdateListener(new bkcy(this, parambkhw));
        localValueAnimator1.addListener(new bkcz(this, parambkhw));
        parambkhw.a = localValueAnimator1;
      }
    } while ((parambkhw.a.isStarted()) || (parambkhw.a.isRunning()));
    veg.b("DoodleEditView", "breathScale start ");
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
    bkhw localbkhw = this.jdField_a_of_type_Bkah.a();
    if (localbkhw != null) {
      localbkhw.d();
    }
    if (this.jdField_a_of_type_Bkah.b != null)
    {
      this.jdField_a_of_type_Bkah.b.d();
      this.jdField_a_of_type_Bkah.b = null;
    }
  }
  
  public void b(bkhw parambkhw)
  {
    if (parambkhw == null) {}
    while ((parambkhw.a == null) || (!parambkhw.a.isRunning())) {
      return;
    }
    veg.b("DoodleEditView", "cancelNailAnimator");
    parambkhw.a.cancel();
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    bkhw localbkhw;
    Object localObject2;
    Object localObject1;
    if ((paramBoolean) || ((!paramBoolean) && (getVisibility() == 0))) {
      if (this.jdField_a_of_type_Bkah.b())
      {
        localbkhw = this.jdField_a_of_type_Bkah.a();
        localbkhw.jdField_k_of_type_Boolean = false;
        if (!(localbkhw instanceof bjzx)) {
          break label220;
        }
        localObject2 = (bjzt)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(bjzt.jdField_a_of_type_JavaLangString);
        bjzx localbjzx = (bjzx)localbkhw;
        if (((bjzx)localbkhw).h != 1)
        {
          localObject1 = localObject2;
          if (((bjzx)localbkhw).h != 3) {}
        }
        else if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) {}
        }
        else
        {
          localObject1 = (bjzt)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("DynamicFaceLayer");
          ((bjzx)localbkhw).a.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
        }
        if (localObject1 != null) {
          ((bjzt)localObject1).jdField_a_of_type_JavaUtilList.add(localbjzx);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
      this.jdField_a_of_type_Bkah.c();
      setVisibility(8);
      if (this.jdField_a_of_type_Bkda != null) {
        this.jdField_a_of_type_Bkda.a();
      }
      return;
      label220:
      if ((localbkhw instanceof bkam))
      {
        if (((bkam)localbkhw).a != null) {
          ((bkam)localbkhw).a.a(-1, false);
        }
        localObject1 = (bkaj)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(bkaj.jdField_a_of_type_JavaLangString);
        if (localObject1 != null)
        {
          localObject2 = ((bkam)localbkhw).a;
          if (localObject2 != null)
          {
            if ((!((DynamicTextItem)localObject2).e()) && (((DynamicTextItem)localObject2).d())) {
              ((DynamicTextItem)localObject2).a(true);
            }
            if (!((DynamicTextItem)localObject2).b()) {
              ((bkaj)localObject1).jdField_a_of_type_JavaUtilArrayList.add((bkam)localbkhw);
            }
          }
        }
      }
      else if ((localbkhw instanceof bkae))
      {
        localObject1 = (bkad)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b.a("InteractPasterLayer");
        if (localObject1 != null)
        {
          ((bkad)localObject1).a = ((bkat)localbkhw);
          ((bkad)localObject1).f();
        }
      }
      else if ((localbkhw instanceof bkat))
      {
        localObject1 = (bkar)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b.a("VoteLayer");
        if (localObject1 != null)
        {
          ((bkar)localObject1).a = ((bkat)localbkhw);
          ((bkar)localObject1).f();
        }
      }
    }
  }
  
  public void c()
  {
    b(this.jdField_a_of_type_Bkah.a());
    super.c();
    this.jdField_a_of_type_Bkah.b();
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
    postDelayed(this.jdField_a_of_type_JavaLangRunnable, bkaj.e);
  }
  
  public void d()
  {
    b(false);
  }
  
  public void e()
  {
    if ((a() == 1) && (this.jdField_a_of_type_Bkah.b()))
    {
      bkhw localbkhw = this.jdField_a_of_type_Bkah.a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(localbkhw, 0);
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
    this.jdField_a_of_type_Bkah.d(paramCanvas);
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
      if ((paramMotionEvent.getAction() == 0) && (this.jdField_a_of_type_Bkah.b(paramMotionEvent))) {
        this.c = true;
      }
      boolean bool;
      if (this.c)
      {
        bool = this.jdField_a_of_type_Bkah.c(paramMotionEvent);
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
      if ((!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a()) && (this.jdField_a_of_type_Bkah.b()))
      {
        localObject = this.jdField_a_of_type_Bkah.a();
        if (((bkhw)localObject).i == 1)
        {
          this.jdField_a_of_type_Bkah.b = ((bkhw)localObject);
          if (((bkhw)localObject).i == 1)
          {
            b((bkhw)localObject);
            f5 = ((bkhw)localObject).b.x + ((bkhw)localObject).s - ((bkhw)localObject).u * ((bkhw)localObject).q / 2.0F;
            f6 = ((bkhw)localObject).b.y + ((bkhw)localObject).t - ((bkhw)localObject).v * ((bkhw)localObject).q / 2.0F;
            if ((!((bkhw)localObject).g) || (!((bkhw)localObject).h)) {
              break label392;
            }
            f1 = ((bkhw)localObject).l + ((bkhw)localObject).j - ((bkhw)localObject).u / 2.0F;
            f2 = ((bkhw)localObject).m + ((bkhw)localObject).jdField_k_of_type_Float - ((bkhw)localObject).v / 2.0F;
            f3 = f1 - f5;
            f4 = f2 - f6;
          }
        }
      }
      for (;;)
      {
        ((bkhw)localObject).o = ((bkhw)localObject).q;
        ((bkhw)localObject).i = 2;
        DoodleLayout localDoodleLayout = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
        f5 = ((bkhw)localObject).u;
        f6 = ((bkhw)localObject).q;
        float f7 = ((bkhw)localObject).v;
        localDoodleLayout.a(f1, f2, f5 * f6, ((bkhw)localObject).q * f7, f3, f4);
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
  
  public void setDoodleEditViewListener(bkda parambkda)
  {
    this.jdField_a_of_type_Bkda = parambkda;
  }
  
  public void setFrom(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setOnLayerTouchListener()
  {
    this.jdField_a_of_type_Bkah.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_Bkea);
    this.jdField_a_of_type_Bkah.a(new bkcx(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView
 * JD-Core Version:    0.7.0.1
 */