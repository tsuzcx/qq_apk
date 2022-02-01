package com.tencent.mobileqq.vip.diy.template;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.util.SquareRoundImageUtils;
import com.tencent.mobileqq.utils.ViewUtils;

public class ProfileTemplateBase$TemplateDecoderHandler
  implements DownloadParams.DecodeHandler
{
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private boolean jdField_a_of_type_Boolean;
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    paramBitmap.setDensity((int)ViewUtils.c());
    paramDownloadParams = SquareRoundImageUtils.a(paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, Bitmap.Config.ARGB_8888);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Int * 2);
    Path localPath = new Path();
    Canvas localCanvas = new Canvas(paramDownloadParams);
    localCanvas.save();
    int i = this.jdField_a_of_type_Int;
    localPath.moveTo(i, i);
    i = paramDownloadParams.getWidth();
    int j = this.jdField_a_of_type_Int;
    localPath.lineTo(i - j, j);
    localPath.lineTo(paramDownloadParams.getWidth() - this.jdField_a_of_type_Int, paramDownloadParams.getHeight() - this.jdField_a_of_type_Int);
    localPath.lineTo(this.jdField_a_of_type_Int, paramDownloadParams.getHeight() - this.jdField_a_of_type_Int);
    localPath.close();
    localPath.setFillType(Path.FillType.EVEN_ODD);
    localCanvas.clipPath(localPath);
    localCanvas.drawBitmap(paramBitmap, new Rect(0, (paramBitmap.getHeight() - paramBitmap.getWidth()) / 2, paramBitmap.getWidth(), (paramBitmap.getWidth() + paramBitmap.getHeight()) / 2), new Rect(0, 0, paramDownloadParams.getWidth(), paramDownloadParams.getHeight()), this.jdField_a_of_type_AndroidGraphicsPaint);
    localCanvas.restore();
    if (!this.jdField_a_of_type_Boolean) {
      localCanvas.drawPath(localPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    return paramDownloadParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.template.ProfileTemplateBase.TemplateDecoderHandler
 * JD-Core Version:    0.7.0.1
 */