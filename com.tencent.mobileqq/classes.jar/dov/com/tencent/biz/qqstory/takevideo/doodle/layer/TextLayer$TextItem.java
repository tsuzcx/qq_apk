package dov.com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import aofy;
import aofz;
import aoga;
import aogb;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.NormalTextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;
import java.util.Collections;

public class TextLayer$TextItem
  extends GestureHelper.ZoomItem
{
  public float a;
  public int a;
  Rect a;
  public DynamicTextItem a;
  public float b;
  public float c;
  public float d;
  public float e;
  public float f;
  public float g;
  public float h;
  public float i;
  
  public TextLayer$TextItem(TextLayer paramTextLayer)
  {
    this(paramTextLayer, new TextLayer.LayerParams(0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
    this.jdField_a_of_type_AndroidGraphicsPointF.set(paramTextLayer.jdField_a_of_type_AndroidGraphicsPointF);
    this.jdField_j_of_type_Int = UIUtils.a(BaseApplicationImpl.getContext(), 15.0F);
  }
  
  public TextLayer$TextItem(TextLayer paramTextLayer, @NonNull TextLayer.LayerParams paramLayerParams)
  {
    super(paramLayerParams.jdField_a_of_type_AndroidGraphicsPointF, paramLayerParams.jdField_a_of_type_Float, paramLayerParams.b, paramLayerParams.jdField_c_of_type_Float, paramLayerParams.d, paramLayerParams.jdField_e_of_type_Float, paramLayerParams.jdField_f_of_type_Float, true);
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = new NormalTextItem(0, Collections.singletonList("普通文字"));
    this.u = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a();
    this.v = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b();
    this.jdField_a_of_type_Float = TextLayer.jdField_a_of_type_Int;
    this.jdField_j_of_type_Int = UIUtils.a(BaseApplicationImpl.getContext(), 15.0F);
  }
  
  public TextLayer$TextItem(TextLayer paramTextLayer, @NonNull TextItem paramTextItem)
  {
    super(paramTextItem, 1.0F);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(paramTextItem.jdField_a_of_type_AndroidGraphicsRect);
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = paramTextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
    this.jdField_a_of_type_Float = paramTextItem.jdField_a_of_type_Float;
    this.b = paramTextItem.b;
    this.jdField_c_of_type_Float = paramTextItem.jdField_c_of_type_Float;
    this.d = paramTextItem.d;
    this.jdField_e_of_type_Float = paramTextItem.jdField_e_of_type_Float;
    this.jdField_f_of_type_Float = paramTextItem.jdField_f_of_type_Float;
    this.jdField_g_of_type_Float = paramTextItem.jdField_g_of_type_Float;
    this.h = paramTextItem.h;
    this.jdField_i_of_type_Float = paramTextItem.jdField_i_of_type_Float;
    this.jdField_j_of_type_Int = UIUtils.a(BaseApplicationImpl.getContext(), 15.0F);
    a(paramTextItem);
  }
  
  private void d()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localValueAnimator.setDuration(TextLayer.e);
    localValueAnimator.addUpdateListener(new aofy(this));
    localValueAnimator.start();
  }
  
  private void e()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    localValueAnimator.setDuration(TextLayer.e);
    localValueAnimator.addUpdateListener(new aofz(this));
    localValueAnimator.start();
  }
  
  protected void a()
  {
    this.d = this.s;
    this.jdField_e_of_type_Float = this.t;
    this.b = this.q;
    this.jdField_c_of_type_Float = this.r;
    this.jdField_f_of_type_Float = (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer.n - this.jdField_a_of_type_AndroidGraphicsPointF.x - this.d);
    this.jdField_g_of_type_Float = (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer.o - this.jdField_a_of_type_AndroidGraphicsPointF.y - this.jdField_e_of_type_Float);
    this.h = (1.0F - this.b);
    if (this.jdField_c_of_type_Float < 180.0F)
    {
      this.jdField_i_of_type_Float = (0.0F - this.jdField_c_of_type_Float);
      return;
    }
    this.jdField_i_of_type_Float = (360.0F - this.jdField_c_of_type_Float);
  }
  
  public void a(Canvas paramCanvas)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.a(TextLayer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer).a())) && (!this.jdField_j_of_type_Boolean)) {}
    int j;
    int k;
    do
    {
      return;
      DisplayUtil.a();
      if (this.jdField_e_of_type_Boolean) {
        paramCanvas.drawColor(Color.parseColor("#66000000"));
      }
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_j_of_type_Boolean))
      {
        if ((this.jdField_f_of_type_Boolean) && (this.jdField_g_of_type_Boolean))
        {
          float f1 = this.l;
          float f2 = this.jdField_j_of_type_Float;
          float f3 = this.m;
          float f4 = this.jdField_k_of_type_Float;
          float f5 = this.jdField_a_of_type_AndroidGraphicsPointF.x;
          float f6 = this.s;
          float f7 = this.jdField_a_of_type_AndroidGraphicsPointF.y;
          paramCanvas.drawLine(f2 + f1, f4 + f3, f6 + f5, this.t + f7, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer.jdField_a_of_type_AndroidGraphicsPaint);
          paramCanvas.save();
          paramCanvas.concat(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.b(this));
          j = (int)(this.u * this.q * this.w) + this.jdField_j_of_type_Int * 2;
          k = (int)(this.v * this.q * this.w) + this.jdField_j_of_type_Int * 2;
          paramCanvas.drawRect(new RectF(-j / 2, -k / 2, j / 2, k / 2), TextLayer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer));
          paramCanvas.restore();
        }
        if (this.jdField_f_of_type_Boolean) {
          paramCanvas.drawColor(Color.parseColor("#66000000"));
        }
      }
      paramCanvas.save();
      paramCanvas.concat(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(this));
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b(paramCanvas);
      paramCanvas.restore();
    } while (!this.jdField_j_of_type_Boolean);
    paramCanvas.save();
    label337:
    label359:
    label372:
    int m;
    if (this.jdField_k_of_type_Int == 0)
    {
      j = 2130842042;
      if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.a())
      {
        if (this.jdField_k_of_type_Int != 0) {
          break label454;
        }
        j = 2130842048;
      }
      if (this.jdField_k_of_type_Int != 1) {
        break label462;
      }
      k = 2130842038;
      if (this.jdField_k_of_type_Int != 2) {
        break label470;
      }
      m = 2130842045;
      label385:
      if (!this.jdField_k_of_type_Boolean) {
        break label478;
      }
      j = -1;
    }
    label454:
    label462:
    label470:
    label478:
    for (;;)
    {
      DisplayUtil.a(paramCanvas, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper, this, j, k, m);
      paramCanvas.restore();
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      DisplayUtil.b(paramCanvas, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper, this, 2130842051, 2130842051, 2130842050);
      return;
      j = 2130842041;
      break label337;
      j = 2130842046;
      break label359;
      k = 2130842037;
      break label372;
      m = 2130842044;
      break label385;
    }
  }
  
  public void b()
  {
    if (this.jdField_c_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_c_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F, 1.0F });
      this.jdField_c_of_type_AndroidAnimationValueAnimator.setDuration(200L);
      this.jdField_c_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_c_of_type_AndroidAnimationValueAnimator.addUpdateListener(new aoga(this));
      this.jdField_c_of_type_AndroidAnimationValueAnimator.addListener(new aogb(this));
    }
    if (!this.jdField_i_of_type_Boolean) {
      this.jdField_c_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  public void c()
  {
    if ((this.jdField_c_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_i_of_type_Boolean)) {
      this.jdField_c_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_AndroidGraphicsRect != null) {
      localStringBuilder.append("centerP x : ").append(this.jdField_a_of_type_AndroidGraphicsPointF.x).append(" y: ").append(this.jdField_a_of_type_AndroidGraphicsPointF.y);
    }
    localStringBuilder.append("textLeft: ").append(this.jdField_a_of_type_Float);
    localStringBuilder.append("mSaveScaleValue: ").append(this.b);
    localStringBuilder.append("mSaveRotateValue: ").append(this.jdField_c_of_type_Float);
    localStringBuilder.append("mSaveTranslateXValue: ").append(this.d);
    localStringBuilder.append("mDistanceX: ").append(this.jdField_f_of_type_Float);
    localStringBuilder.append("mDistanceY: ").append(this.jdField_g_of_type_Float);
    localStringBuilder.append("mDScale: ").append(this.h);
    localStringBuilder.append("mDRotate: ").append(this.jdField_i_of_type_Float);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem
 * JD-Core Version:    0.7.0.1
 */