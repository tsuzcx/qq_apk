package dov.com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer.OnLayerTouchListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.StoryGuideLineView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;

public class TextFaceEditLayer
  extends BaseLayer
  implements Drawable.Callback
{
  public static final String a;
  public int a;
  public TextFaceEditLayer.LayerListener a;
  public GestureHelper.ZoomItem a;
  public GestureHelper a;
  public boolean a;
  public GestureHelper.ZoomItem b;
  
  static
  {
    jdField_a_of_type_JavaLangString = TextFaceEditLayer.class.getSimpleName();
  }
  
  public TextFaceEditLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper = new GestureHelper();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(true);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(6.0F);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.b(0.2F);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem, f1, f2)) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_k_of_type_Int = 0;
    }
    do
    {
      return;
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.e(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem, f1, f2))
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_k_of_type_Int = 1;
        return;
      }
    } while (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem, f1, f2));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_k_of_type_Int = 2;
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem, paramFloat1, paramFloat2, true);
  }
  
  private void b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem, f1, f2)) {
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer$LayerListener != null)
      {
        if (!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem instanceof TextLayer.TextItem)) {
          break label77;
        }
        paramMotionEvent = ((TextLayer.TextItem)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem).a;
        if (paramMotionEvent != null) {
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer$LayerListener.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem, paramMotionEvent.b(), 2);
        }
      }
    }
    label77:
    DynamicTextItem localDynamicTextItem;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer$LayerListener.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem, 0, 0);
              return;
              if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.e(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem, f1, f2)) {
                break;
              }
            } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer$LayerListener == null);
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer$LayerListener.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem);
            return;
            if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem, f1, f2)) {
              break;
            }
          } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer$LayerListener == null);
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer$LayerListener.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem);
          return;
          if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.c(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem, f1, f2)) {
            break;
          }
          if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.g) {
            this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.g = true;
          }
        } while (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer$LayerListener == null);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer$LayerListener.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem, 0, 0);
        return;
      } while ((!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem, f1, f2, true)) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer$LayerListener == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem == null));
      if (!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem instanceof TextLayer.TextItem)) {
        break;
      }
      localDynamicTextItem = ((TextLayer.TextItem)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem).a;
    } while (localDynamicTextItem == null);
    if ((localDynamicTextItem.a()) && (localDynamicTextItem.f()))
    {
      int i = localDynamicTextItem.a(paramMotionEvent, c(), d(), (TextLayer.TextItem)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper);
      localDynamicTextItem.b(i);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer$LayerListener.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem, i, 3, f1, f2);
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer$LayerListener.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem, localDynamicTextItem.b(), 0, f1, f2);
    return;
    SLog.b(jdField_a_of_type_JavaLangString, "click the item:" + this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer$LayerListener.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem, 0, 0, f1, f2);
  }
  
  private void d()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(false, 0.0F, 0.0F, 0.0F, null, false, 1);
  }
  
  private void d(GestureHelper.ZoomItem paramZoomItem)
  {
    boolean bool1 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(paramZoomItem, StoryGuideLineView.jdField_a_of_type_Int, true);
    boolean bool2 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(paramZoomItem, StoryGuideLineView.b, false);
    boolean bool3 = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.b(paramZoomItem, StoryGuideLineView.d, false);
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer$LayerListener != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer$LayerListener.a(bool1, bool2, false, bool3, paramZoomItem.l);
    }
    if (paramZoomItem != null)
    {
      if (paramZoomItem.jdField_k_of_type_Boolean) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(paramZoomItem.l, paramZoomItem.r, paramZoomItem.s, paramZoomItem.t, paramZoomItem.jdField_a_of_type_AndroidGraphicsPointF, paramZoomItem.m, 2);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a(paramZoomItem.l, paramZoomItem.r, paramZoomItem.s, paramZoomItem.t, paramZoomItem.jdField_a_of_type_AndroidGraphicsPointF, paramZoomItem.m, 1);
  }
  
  public GestureHelper.ZoomItem a()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem = null;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a();
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem == null) {
      return;
    }
    paramCanvas.save();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.a(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(Canvas paramCanvas, float paramFloat)
  {
    throw new IllegalStateException("TextFaceEditLayer should not save");
  }
  
  public void a(TextFaceEditLayer.LayerListener paramLayerListener)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer$LayerListener = paramLayerListener;
  }
  
  public void a(GestureHelper.ZoomItem paramZoomItem)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem = paramZoomItem;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem == null) {}
    do
    {
      return;
      TextLayer.c(true);
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem instanceof TextLayer.TextItem))
      {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(6.0F);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.b(0.2F);
        return;
      }
    } while ((!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem instanceof FaceLayer.FaceItem)) && (!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem instanceof FaceLayer.FaceAndTextItem)));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(18.0F);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.b(0.2F);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(long paramLong)
  {
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void b(Canvas paramCanvas)
  {
    throw new IllegalStateException("TextFaceEditLayer should not save");
  }
  
  public void b(GestureHelper.ZoomItem paramZoomItem)
  {
    if (paramZoomItem == null) {}
    while ((paramZoomItem.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (!paramZoomItem.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
      return;
    }
    SLog.b(jdField_a_of_type_JavaLangString, "cancelNailAnimator");
    paramZoomItem.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem != null;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem, f1, f2, true))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "accept inside x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY());
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "accept outside x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY());
    }
    return false;
  }
  
  public void c()
  {
    b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem = null;
    TextLayer.c(false);
    k();
  }
  
  public void c(GestureHelper.ZoomItem paramZoomItem)
  {
    if (paramZoomItem == null) {
      return;
    }
    paramZoomItem.jdField_k_of_type_Boolean = true;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem != null) {
      paramZoomItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.lockData(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.isDataLocked());
    }
    if (((paramZoomItem instanceof FaceLayer.FaceItem)) && ((((FaceLayer.FaceItem)paramZoomItem).h == 1) || (((FaceLayer.FaceItem)paramZoomItem).h == 3))) {
      ((FaceLayer.FaceItem)paramZoomItem).a.setCallback(this);
    }
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem = paramZoomItem;
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    int i = 0;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer$OnLayerTouchListener != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerBaseBaseLayer$OnLayerTouchListener.a(this, paramMotionEvent);
    }
    int j = (int)paramMotionEvent.getY();
    int k = Math.abs(j - this.jdField_a_of_type_Int);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      i = 1;
      label74:
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(paramMotionEvent, true);
      if (i == 0) {
        d();
      }
      break;
    }
    while ((!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem instanceof FaceLayer.FaceItem)) && (!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem instanceof TextLayer.TextItem)))
    {
      return true;
      this.jdField_a_of_type_Int = j;
      this.jdField_a_of_type_Boolean = false;
      a(paramMotionEvent.getX(0), paramMotionEvent.getY(0));
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem);
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem != null) {
        a(paramMotionEvent);
      }
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem == null) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.e != true) || (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.g) || (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
        break;
      }
      SLog.b(jdField_a_of_type_JavaLangString, "cancelNailAnimator");
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      i = 1;
      break label74;
      if (k > 10) {
        this.jdField_a_of_type_Boolean = true;
      }
      i = 1;
      break label74;
      if (!this.jdField_a_of_type_Boolean) {
        b(paramMotionEvent);
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.jdField_k_of_type_Int = -1;
      }
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem.e = false;
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a();
      break label74;
    }
    d(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper$ZoomItem);
    return true;
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    k();
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextFaceEditLayer
 * JD-Core Version:    0.7.0.1
 */