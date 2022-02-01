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
  private Paint a;
  private int b;
  private boolean c;
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    paramBitmap.setDensity((int)ViewUtils.getDensityDpi());
    paramDownloadParams = SquareRoundImageUtils.a(paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, Bitmap.Config.ARGB_8888);
    this.a.setStrokeWidth(this.b * 2);
    Path localPath = new Path();
    Canvas localCanvas = new Canvas(paramDownloadParams);
    localCanvas.save();
    int i = this.b;
    localPath.moveTo(i, i);
    i = paramDownloadParams.getWidth();
    int j = this.b;
    localPath.lineTo(i - j, j);
    localPath.lineTo(paramDownloadParams.getWidth() - this.b, paramDownloadParams.getHeight() - this.b);
    localPath.lineTo(this.b, paramDownloadParams.getHeight() - this.b);
    localPath.close();
    localPath.setFillType(Path.FillType.EVEN_ODD);
    localCanvas.clipPath(localPath);
    localCanvas.drawBitmap(paramBitmap, new Rect(0, (paramBitmap.getHeight() - paramBitmap.getWidth()) / 2, paramBitmap.getWidth(), (paramBitmap.getWidth() + paramBitmap.getHeight()) / 2), new Rect(0, 0, paramDownloadParams.getWidth(), paramDownloadParams.getHeight()), this.a);
    localCanvas.restore();
    if (!this.c) {
      localCanvas.drawPath(localPath, this.a);
    }
    return paramDownloadParams;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.template.ProfileTemplateBase.TemplateDecoderHandler
 * JD-Core Version:    0.7.0.1
 */