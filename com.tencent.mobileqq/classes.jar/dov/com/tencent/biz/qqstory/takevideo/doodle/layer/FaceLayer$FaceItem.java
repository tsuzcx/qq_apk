package dov.com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.animation.LinearInterpolator;
import anxc;
import anxd;
import anxe;
import anxf;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.paster.QIMInformationPasterManager;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.InformationFaceConstant;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.InfoStickerDrawable;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;
import dov.com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class FaceLayer$FaceItem
  extends GestureHelper.ZoomItem
{
  public long a;
  public Bitmap a;
  public RectF a;
  public Drawable a;
  public TroopBarPOI a;
  public boolean b;
  public final String d;
  public int e;
  public final String e;
  public int f;
  public final String f;
  public int g;
  public String g;
  public int h;
  
  public FaceLayer$FaceItem(FaceLayer paramFaceLayer, @NonNull Drawable paramDrawable, @NonNull FaceLayer.LayerParams paramLayerParams, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    super(paramLayerParams.jdField_a_of_type_AndroidGraphicsPointF, paramLayerParams.jdField_a_of_type_Float, paramLayerParams.jdField_b_of_type_Float, paramLayerParams.c, paramLayerParams.d, paramLayerParams.jdField_a_of_type_Int, paramLayerParams.jdField_b_of_type_Int, true);
    this.jdField_e_of_type_Int = 1;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.d = paramString1;
    this.jdField_e_of_type_JavaLangString = paramString2;
    this.jdField_f_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(paramDrawable.getBounds());
    this.jdField_b_of_type_Boolean = false;
    this.h = paramInt;
  }
  
  public FaceLayer$FaceItem(FaceLayer paramFaceLayer, @NonNull Drawable paramDrawable, @NonNull FaceLayer.LayerParams paramLayerParams, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    this(paramFaceLayer, paramDrawable, paramLayerParams, paramString1, paramString2, paramString3, paramInt1);
    this.jdField_f_of_type_Int = paramInt2;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI != null) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI.a();
    }
    return "";
  }
  
  public void a(Canvas paramCanvas)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.a(FaceLayer.c(this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer).a())) && (!this.jdField_j_of_type_Boolean)) {}
    int i;
    int j;
    do
    {
      return;
      float f2 = this.u;
      float f1 = this.v;
      if (f2 * this.q < 200.0F) {
        f2 = 200.0F / this.q;
      }
      if (this.q * f1 < 200.0F) {
        f1 = 200.0F / this.q;
      }
      if ((this.jdField_c_of_type_Boolean) && (this.jdField_j_of_type_Boolean))
      {
        if ((this.jdField_f_of_type_Boolean) && (this.jdField_g_of_type_Boolean))
        {
          f1 = this.l;
          f2 = this.jdField_j_of_type_Float;
          float f3 = this.m;
          float f4 = this.jdField_k_of_type_Float;
          float f5 = this.jdField_a_of_type_AndroidGraphicsPointF.x;
          float f6 = this.s;
          float f7 = this.jdField_a_of_type_AndroidGraphicsPointF.y;
          paramCanvas.drawLine(f2 + f1, f4 + f3, f6 + f5, this.t + f7, this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.e);
          paramCanvas.save();
          paramCanvas.concat(this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.b(this));
          i = (int)(this.u * this.q * this.w) + this.jdField_j_of_type_Int * 2;
          j = (int)(this.v * this.q * this.w) + this.jdField_j_of_type_Int * 2;
          paramCanvas.drawRect(new RectF(-i / 2, -j / 2, i / 2, j / 2), this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.f);
          paramCanvas.restore();
        }
        if (this.jdField_f_of_type_Boolean) {
          paramCanvas.drawColor(Color.parseColor("#66000000"));
        }
      }
      paramCanvas.save();
      paramCanvas.concat(this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(this));
      paramCanvas.translate(-this.u / 2.0F, -this.v / 2.0F);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramCanvas.restore();
    } while (!this.jdField_j_of_type_Boolean);
    paramCanvas.save();
    label384:
    label405:
    label417:
    int k;
    if (this.jdField_k_of_type_Int == 0)
    {
      i = 2130842009;
      if (!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.a())
      {
        if (this.jdField_k_of_type_Int != 0) {
          break label494;
        }
        i = 2130842017;
      }
      if (this.jdField_k_of_type_Int != 1) {
        break label501;
      }
      j = 2130842007;
      if (this.jdField_k_of_type_Int != 2) {
        break label508;
      }
      k = 2130842014;
      label429:
      if (!this.jdField_k_of_type_Boolean) {
        break label515;
      }
      i = -1;
    }
    label515:
    for (;;)
    {
      DisplayUtil.a(paramCanvas, this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper, this, i, j, k);
      paramCanvas.restore();
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      DisplayUtil.b(paramCanvas, this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper, this, 2130842020, 2130842020, 2130842019);
      return;
      i = 2130842008;
      break label384;
      label494:
      i = 2130842015;
      break label405;
      label501:
      j = 2130842006;
      break label417;
      label508:
      k = 2130842013;
      break label429;
    }
  }
  
  public void a(Canvas paramCanvas, boolean paramBoolean)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.a(FaceLayer.d(this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer).a())) && (!this.jdField_j_of_type_Boolean)) {
      return;
    }
    float f2 = this.u;
    float f1 = this.v;
    if (f2 * this.q < 200.0F) {
      f2 = 200.0F / this.q;
    }
    if (this.q * f1 < 200.0F) {
      f1 = 200.0F / this.q;
    }
    if (this.jdField_e_of_type_Boolean) {
      paramCanvas.drawColor(Color.parseColor("#66000000"));
    }
    paramCanvas.save();
    paramCanvas.translate(-this.u / 2.0F, -this.v / 2.0F);
    if ((this.jdField_e_of_type_Boolean) && (this.h == 0))
    {
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = FaceLayer.a(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap.extractAlpha(this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.g, null), null, new Rect((int)-this.p, (int)-this.p, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() + (int)this.p, this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() + (int)this.p), this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.g);
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public void a(TroopBarPOI paramTroopBarPOI)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarPOI = paramTroopBarPOI;
    if (paramTroopBarPOI != null)
    {
      a(paramTroopBarPOI.a());
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
    }
    a(null);
    this.jdField_a_of_type_Long = -1L;
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      if (!(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof InfoStickerDrawable)) {
        break label220;
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = InformationFaceConstant.a((InfoStickerDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidContentContext, paramString);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        this.jdField_g_of_type_JavaLangString = ((InfoStickerDrawable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).c();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
      float f1 = this.jdField_a_of_type_AndroidGraphicsPointF.x - this.q * this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() / 2.0F + this.s;
      if (f1 < ScreenUtil.a(23.0F)) {
        this.jdField_a_of_type_AndroidGraphicsPointF.x = (this.jdField_a_of_type_AndroidGraphicsPointF.x - f1 + ScreenUtil.a(23.0F));
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(FaceLayer.e(this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer));
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds());
      this.u = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
      this.v = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
      ((QIMInformationPasterManager)QIMManager.a().c(12)).a(paramString);
      return;
      label220:
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof BitmapDrawable)) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = InformationFaceConstant.a(this.jdField_g_of_type_JavaLangString, this.jdField_b_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer.jdField_a_of_type_AndroidContentContext, paramString);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    if (this.jdField_c_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_c_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.85F, 1.0F });
      this.jdField_c_of_type_AndroidAnimationValueAnimator.setDuration(200L);
      this.jdField_c_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_c_of_type_AndroidAnimationValueAnimator.addUpdateListener(new anxc(this));
      this.jdField_c_of_type_AndroidAnimationValueAnimator.addListener(new anxd(this));
    }
    if (!this.i) {
      this.jdField_c_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  public void c()
  {
    if ((this.jdField_c_of_type_AndroidAnimationValueAnimator != null) && (this.i)) {
      this.jdField_c_of_type_AndroidAnimationValueAnimator.cancel();
    }
  }
  
  public void d()
  {
    a(new anxe(this), new anxf(this));
  }
  
  public void e()
  {
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceItem
 * JD-Core Version:    0.7.0.1
 */