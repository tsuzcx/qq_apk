package dov.com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import dov.com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;

public class AtLayer$AtItem
  extends GestureHelper.ZoomItem
{
  public int a;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Rect jdField_a_of_type_AndroidGraphicsRect;
  RectF jdField_a_of_type_AndroidGraphicsRectF;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  StaticLayout jdField_a_of_type_AndroidTextStaticLayout;
  public String a;
  int jdField_b_of_type_Int;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  int c;
  
  public void a(Canvas paramCanvas, boolean paramBoolean)
  {
    SLog.c(AtLayer.jdField_a_of_type_JavaLangString, "AtItem draw start.");
    paramCanvas.save();
    paramCanvas.translate(-this.u / 2.0F, -this.v / 2.0F);
    NinePatch localNinePatch;
    if (this.jdField_a_of_type_Int == 0)
    {
      localNinePatch = new NinePatch(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsBitmap.getNinePatchChunk(), null);
      localNinePatch.draw(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRect);
      paramCanvas.restore();
      paramCanvas.save();
      float f2 = (this.v - this.jdField_a_of_type_AndroidGraphicsRectF.height()) / 2.0F;
      if (this.jdField_a_of_type_Int != 0) {
        break label343;
      }
      paramCanvas.translate(-this.u / 2.0F, -this.v / 2.0F);
      f1 = AIOUtils.a(10.0F, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer.jdField_a_of_type_AndroidContentContext.getResources());
      label136:
      paramCanvas.translate(f1, f2);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.translate(-this.u / 2.0F, -this.v / 2.0F);
      if (this.jdField_a_of_type_Int != 0) {
        break label381;
      }
    }
    label343:
    label381:
    for (float f1 = AIOUtils.a(36.0F, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer.jdField_a_of_type_AndroidContentContext.getResources());; f1 = AIOUtils.a(8.0F, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer.jdField_a_of_type_AndroidContentContext.getResources()))
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer.jdField_a_of_type_AndroidTextTextPaint.setTextSize(this.jdField_b_of_type_Int);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer.jdField_a_of_type_AndroidTextTextPaint.setColor(this.c);
      int i = (int)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer.jdField_a_of_type_AndroidTextTextPaint.measureText(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidTextStaticLayout = new StaticLayout(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer.jdField_a_of_type_AndroidTextTextPaint, i, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
      paramCanvas.translate(f1, (this.v - this.jdField_a_of_type_AndroidTextStaticLayout.getHeight()) / 2.0F);
      this.jdField_a_of_type_AndroidTextStaticLayout.draw(paramCanvas);
      paramCanvas.restore();
      SLog.c(AtLayer.jdField_a_of_type_JavaLangString, "AtItem draw end.");
      return;
      localNinePatch = new NinePatch(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_b_of_type_AndroidGraphicsBitmap.getNinePatchChunk(), null);
      break;
      paramCanvas.translate(this.u / 2.0F, -this.v / 2.0F);
      f1 = -AIOUtils.a(30.0F, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerAtLayer.jdField_a_of_type_AndroidContentContext.getResources());
      break label136;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.AtLayer.AtItem
 * JD-Core Version:    0.7.0.1
 */