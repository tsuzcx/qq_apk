package dov.com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper;

public class VoteLayer
  extends BaseLayer
{
  protected int a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private VoteLayer.LayerEventListener jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$LayerEventListener;
  public VoteLayer.VoteItem a;
  private GestureHelper jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper;
  public boolean a;
  public int b;
  private Paint b;
  
  public VoteLayer(DoodleView paramDoodleView)
  {
    super(paramDoodleView);
    this.jdField_a_of_type_Int = 1;
    e();
  }
  
  private void e()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper = new GestureHelper();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(true);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(18.0F);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.b(0.5F);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#3DB8FF"));
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.jdField_b_of_type_AndroidGraphicsPaint.setPathEffect(new DashPathEffect(new float[] { 6.0F, 7.0F }, 1.0F));
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$LayerEventListener != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem != null) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$LayerEventListener.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem))) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem = null;
    }
  }
  
  @Nullable
  public VoteLayer.VoteItem a()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem;
  }
  
  public String a()
  {
    return "VoteLayer";
  }
  
  public void a()
  {
    b();
  }
  
  public void a(@NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem == null)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem = new VoteLayer.VoteItem(this, paramBitmap, new PointF(UIUtils.a(this.jdField_a_of_type_AndroidContentContext) / 2, UIUtils.b(this.jdField_a_of_type_AndroidContentContext) / 2), paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramBitmap.getWidth(), paramBitmap.getHeight(), true);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem.jdField_a_of_type_ArrayOfAndroidGraphicsRect = paramArrayOfRect;
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = 1;
      super.k();
      return;
      if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem.u = paramBitmap.getWidth();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem.v = paramBitmap.getHeight();
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem.jdField_a_of_type_ArrayOfAndroidGraphicsRect = paramArrayOfRect;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem.q = paramFloat1;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem.r = paramFloat2;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem.s = paramFloat3;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem.t = paramFloat4;
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      paramCanvas.save();
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem != null) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem.a(paramCanvas);
      }
      paramCanvas.restore();
    }
  }
  
  public void a(Canvas paramCanvas, float paramFloat) {}
  
  public void a(VoteLayer.LayerEventListener paramLayerEventListener)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$LayerEventListener = paramLayerEventListener;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem == null;
  }
  
  public boolean a(long paramLong)
  {
    return true;
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    int i = (int)paramMotionEvent.getY();
    int j = Math.abs(i - this.jdField_b_of_type_Int);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(paramMotionEvent, false);
      return true;
      this.jdField_b_of_type_Int = i;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem);
      continue;
      if (j > 5)
      {
        this.jdField_a_of_type_Boolean = true;
        continue;
        if (!this.jdField_a_of_type_Boolean) {
          g();
        }
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a();
        a(this, false);
        n();
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int = 1;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem != null)
    {
      if (!this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      }
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem = null;
    }
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$LayerEventListener != null) {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$LayerEventListener.a();
    }
    k();
  }
  
  public void b(Canvas paramCanvas)
  {
    a(paramCanvas, this.jdField_a_of_type_Float);
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Int != 1) {}
    do
    {
      return false;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUtilGestureHelper.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerVoteLayer$VoteItem, f1, f2, false))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoteLayer", 2, "accept inside x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY());
        }
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VoteLayer", 2, "accept outside x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY());
    return false;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = 2;
    k();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Int = 1;
    k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.VoteLayer
 * JD-Core Version:    0.7.0.1
 */