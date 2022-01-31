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
import aohd;
import aohe;
import aohf;
import aohg;
import aohh;
import aoih;
import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.qq.im.capture.data.IFaceSelectedListener;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.InteractPasterLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.InteractPasterLayer.InteractItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextFaceEditLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.VoteLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.VoteLayer.VoteItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;
import java.util.ArrayList;
import java.util.List;

public class DoodleEditView
  extends DoodleView
  implements aoih
{
  private float jdField_a_of_type_Float;
  private IFaceSelectedListener jdField_a_of_type_DovComQqImCaptureDataIFaceSelectedListener;
  public TextFaceEditLayer a;
  private DoodleEditView.DoodleEditViewListener jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView$DoodleEditViewListener;
  Runnable jdField_a_of_type_JavaLangRunnable = new aohh(this);
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
  
  public IFaceSelectedListener a()
  {
    return this.jdField_a_of_type_DovComQqImCaptureDataIFaceSelectedListener;
  }
  
  public TextFaceEditLayer a()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer = new TextFaceEditLayer(this);
    this.jdField_a_of_type_DovComQqImCaptureDataIFaceSelectedListener = new aohd(this);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = getContext().getResources().getDisplayMetrics().widthPixels;
    int j = getContext().getResources().getDisplayMetrics().heightPixels;
    if (i > paramInt1) {
      this.jdField_a_of_type_Float = ((i - paramInt1) / 2.0F);
    }
    if (j > paramInt2) {
      this.jdField_b_of_type_Float = ((j - paramInt2) / 2.0F);
    }
  }
  
  public void a(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
  }
  
  public void a(GestureHelper.ZoomItem paramZoomItem)
  {
    if (paramZoomItem == null) {}
    ValueAnimator localValueAnimator1;
    do
    {
      return;
      ValueAnimator localValueAnimator2 = paramZoomItem.jdField_a_of_type_AndroidAnimationValueAnimator;
      localValueAnimator1 = localValueAnimator2;
      if (localValueAnimator2 == null)
      {
        localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.7F, 1.0F, 0.7F, 1.0F });
        localValueAnimator1.setStartDelay(300L);
        localValueAnimator1.setDuration(2000L);
        localValueAnimator1.setRepeatMode(1);
        localValueAnimator1.setRepeatCount(-1);
        localValueAnimator1.setInterpolator(new LinearInterpolator());
        localValueAnimator1.addUpdateListener(new aohf(this, paramZoomItem));
        localValueAnimator1.addListener(new aohg(this, paramZoomItem));
        paramZoomItem.jdField_a_of_type_AndroidAnimationValueAnimator = localValueAnimator1;
      }
    } while ((paramZoomItem.jdField_a_of_type_AndroidAnimationValueAnimator.isStarted()) || (paramZoomItem.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()));
    SLog.b("DoodleEditView", "breathScale start ");
    localValueAnimator1.start();
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
    GestureHelper.ZoomItem localZoomItem = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.a();
    if (localZoomItem != null) {
      localZoomItem.f();
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.b != null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.b.f();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.b = null;
    }
  }
  
  public void b(GestureHelper.ZoomItem paramZoomItem)
  {
    if (paramZoomItem == null) {}
    while ((paramZoomItem.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (!paramZoomItem.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
      return;
    }
    SLog.b("DoodleEditView", "cancelNailAnimator");
    paramZoomItem.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (a() == 1) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.q();
    }
    GestureHelper.ZoomItem localZoomItem;
    Object localObject2;
    Object localObject1;
    if ((paramBoolean) || ((!paramBoolean) && (getVisibility() == 0))) {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.b())
      {
        localZoomItem = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.a();
        localZoomItem.jdField_j_of_type_Boolean = false;
        if (!(localZoomItem instanceof FaceLayer.FaceItem)) {
          break label235;
        }
        localObject2 = (FaceLayer)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(FaceLayer.jdField_a_of_type_JavaLangString);
        FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)localZoomItem;
        if (((FaceLayer.FaceItem)localZoomItem).h != 1)
        {
          localObject1 = localObject2;
          if (((FaceLayer.FaceItem)localZoomItem).h != 3) {}
        }
        else if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams != null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoParams.b()) {}
        }
        else
        {
          localObject1 = (FaceLayer)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("DynamicFaceLayer");
          ((FaceLayer.FaceItem)localZoomItem).a.setCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView);
        }
        if (localObject1 != null) {
          ((FaceLayer)localObject1).jdField_a_of_type_JavaUtilList.add(localFaceItem);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.b();
      setVisibility(8);
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView$DoodleEditViewListener != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView$DoodleEditViewListener.a();
      }
      return;
      label235:
      if ((localZoomItem instanceof TextLayer.TextItem))
      {
        if (((TextLayer.TextItem)localZoomItem).a != null) {
          ((TextLayer.TextItem)localZoomItem).a.a(-1, false);
        }
        localObject1 = (TextLayer)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(TextLayer.jdField_a_of_type_JavaLangString);
        if (localObject1 != null)
        {
          localObject2 = ((TextLayer.TextItem)localZoomItem).a;
          if (localObject2 != null)
          {
            if ((!((DynamicTextItem)localObject2).e()) && (((DynamicTextItem)localObject2).d())) {
              ((DynamicTextItem)localObject2).a(true);
            }
            if (!((DynamicTextItem)localObject2).b()) {
              ((TextLayer)localObject1).jdField_a_of_type_JavaUtilArrayList.add((TextLayer.TextItem)localZoomItem);
            }
          }
        }
      }
      else if ((localZoomItem instanceof InteractPasterLayer.InteractItem))
      {
        localObject1 = (InteractPasterLayer)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b.a("InteractPasterLayer");
        if (localObject1 != null)
        {
          ((InteractPasterLayer)localObject1).a = ((VoteLayer.VoteItem)localZoomItem);
          ((InteractPasterLayer)localObject1).d();
        }
      }
      else if ((localZoomItem instanceof VoteLayer.VoteItem))
      {
        localObject1 = (VoteLayer)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b.a("VoteLayer");
        if (localObject1 != null)
        {
          ((VoteLayer)localObject1).a = ((VoteLayer.VoteItem)localZoomItem);
          ((VoteLayer)localObject1).d();
        }
      }
    }
  }
  
  public void c()
  {
    b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.a());
    super.c();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.f();
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
    postDelayed(this.jdField_a_of_type_JavaLangRunnable, TextLayer.e);
  }
  
  public void d()
  {
    b(false);
  }
  
  public void e()
  {
    if ((a() == 1) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.b()))
    {
      GestureHelper.ZoomItem localZoomItem = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.a();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.setTrackerState(localZoomItem, 0);
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
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.d(paramCanvas);
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
      if ((paramMotionEvent.getAction() == 0) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.b(paramMotionEvent))) {
        this.c = true;
      }
      boolean bool;
      if (this.c)
      {
        bool = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.c(paramMotionEvent);
        if ((paramMotionEvent.getAction() == 0) && (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a()) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.b())) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.q();
        }
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
      if ((!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a()) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.b()))
      {
        localObject = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.a();
        if (((GestureHelper.ZoomItem)localObject).i == 1)
        {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.b = ((GestureHelper.ZoomItem)localObject);
          if (((GestureHelper.ZoomItem)localObject).i == 1)
          {
            b((GestureHelper.ZoomItem)localObject);
            f5 = ((GestureHelper.ZoomItem)localObject).jdField_a_of_type_AndroidGraphicsPointF.x + ((GestureHelper.ZoomItem)localObject).s - ((GestureHelper.ZoomItem)localObject).u * ((GestureHelper.ZoomItem)localObject).q / 2.0F;
            f6 = ((GestureHelper.ZoomItem)localObject).jdField_a_of_type_AndroidGraphicsPointF.y + ((GestureHelper.ZoomItem)localObject).t - ((GestureHelper.ZoomItem)localObject).v * ((GestureHelper.ZoomItem)localObject).q / 2.0F;
            if ((!((GestureHelper.ZoomItem)localObject).f) || (!((GestureHelper.ZoomItem)localObject).g)) {
              break label426;
            }
            f1 = ((GestureHelper.ZoomItem)localObject).l + ((GestureHelper.ZoomItem)localObject).jdField_j_of_type_Float - ((GestureHelper.ZoomItem)localObject).u / 2.0F;
            f2 = ((GestureHelper.ZoomItem)localObject).m + ((GestureHelper.ZoomItem)localObject).k - ((GestureHelper.ZoomItem)localObject).v / 2.0F;
            f3 = f1 - f5;
            f4 = f2 - f6;
          }
        }
      }
      for (;;)
      {
        ((GestureHelper.ZoomItem)localObject).o = ((GestureHelper.ZoomItem)localObject).q;
        ((GestureHelper.ZoomItem)localObject).i = 2;
        DoodleLayout localDoodleLayout = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout;
        f5 = ((GestureHelper.ZoomItem)localObject).u;
        f6 = ((GestureHelper.ZoomItem)localObject).q;
        float f7 = ((GestureHelper.ZoomItem)localObject).v;
        localDoodleLayout.a(f1, f2, f5 * f6, ((GestureHelper.ZoomItem)localObject).q * f7, f3, f4);
        d();
        bool = false;
        break;
        label426:
        f3 = 0.0F;
        f2 = f6;
        f1 = f5;
      }
      i = 0;
    }
  }
  
  public void setDoodleEditViewListener(DoodleEditView.DoodleEditViewListener paramDoodleEditViewListener)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView$DoodleEditViewListener = paramDoodleEditViewListener;
  }
  
  public void setFrom(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setOnLayerTouchListener()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_Aoij);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.a(new aohe(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView
 * JD-Core Version:    0.7.0.1
 */