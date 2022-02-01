package com.tencent.mobileqq.videoplatform.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import java.util.Arrays;

public class CropBubbleVideoView
  extends BaseVideoView
{
  private static final String TAG = "CropBubbleVideoView";
  float[] DEFAULT_EDGE_CORDS = { 7.0F, 9.0F, 0.0F, 6.0F, 2.5F, 9.0F, 5.5F, 15.0F, 0.5F, 13.0F };
  float ax = this.DEFAULT_EDGE_CORDS[0];
  float ay = this.DEFAULT_EDGE_CORDS[1];
  float bx = this.DEFAULT_EDGE_CORDS[2];
  float by = this.DEFAULT_EDGE_CORDS[3];
  float cx = this.DEFAULT_EDGE_CORDS[6];
  float cy = this.DEFAULT_EDGE_CORDS[7];
  private Path mCropPath;
  public boolean mIsSend;
  float mx = this.DEFAULT_EDGE_CORDS[4];
  float my = this.DEFAULT_EDGE_CORDS[5];
  float nx = this.DEFAULT_EDGE_CORDS[8];
  float ny = this.DEFAULT_EDGE_CORDS[9];
  public float triWidth = Math.abs(this.bx - this.cx);
  
  public CropBubbleVideoView(Context paramContext, long paramLong, VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    super(paramContext, paramLong, paramVideoPlayParam, null, null, true);
    this.mIsSend = paramBoolean;
  }
  
  private void buildCropShape(boolean paramBoolean, int paramInt1, int paramInt2, Resources paramResources, float paramFloat)
  {
    RectF localRectF;
    float f1;
    label53:
    float[] arrayOfFloat;
    float f2;
    float f3;
    if (this.mCropPath != null)
    {
      this.mCropPath.reset();
      localRectF = new RectF();
      f1 = dp2px(this.triWidth, paramResources);
      if (!paramBoolean) {
        break label292;
      }
      localRectF.set(0.0F, 0.0F, paramInt1 - f1, paramInt2);
      f1 = dp2px(this.by, paramResources);
      arrayOfFloat = new float[8];
      paramFloat = dp2px(paramFloat, paramResources);
      if (arrayOfFloat != null) {
        Arrays.fill(arrayOfFloat, paramFloat);
      }
      if (!paramBoolean) {
        break label307;
      }
      this.mCropPath.addRoundRect(localRectF, arrayOfFloat, Path.Direction.CW);
      paramFloat = paramInt1 - dp2px(this.ax, paramResources);
      f2 = dp2px(this.ay, paramResources);
      this.mCropPath.moveTo(paramFloat, f2);
      paramFloat = paramInt1 - dp2px(this.bx, paramResources);
      f2 = paramInt1 - dp2px(this.mx, paramResources);
      f3 = dp2px(this.my, paramResources);
      this.mCropPath.quadTo(f2, f3, paramFloat, f1);
      paramFloat = paramInt1 - dp2px(this.cx, paramResources);
      f1 = dp2px(this.cy, paramResources);
      f2 = paramInt1 - dp2px(this.nx, paramResources);
      f3 = dp2px(this.ny, paramResources);
      this.mCropPath.quadTo(f2, f3, paramFloat, f1);
    }
    for (;;)
    {
      this.mCropPath.close();
      return;
      this.mCropPath = new Path();
      break;
      label292:
      localRectF.set(f1, 0.0F, paramInt1, paramInt2);
      break label53;
      label307:
      this.mCropPath.addRoundRect(localRectF, arrayOfFloat, Path.Direction.CCW);
      paramFloat = dp2px(this.ax, paramResources);
      f2 = dp2px(this.ay, paramResources);
      this.mCropPath.moveTo(paramFloat, f2);
      paramFloat = this.bx;
      f2 = dp2px(this.mx, paramResources);
      f3 = dp2px(this.my, paramResources);
      this.mCropPath.quadTo(f2, f3, paramFloat, f1);
      paramFloat = dp2px(this.cx, paramResources);
      f1 = dp2px(this.cy, paramResources);
      f2 = dp2px(this.nx, paramResources);
      f3 = dp2px(this.ny, paramResources);
      this.mCropPath.quadTo(f2, f3, paramFloat, f1);
    }
  }
  
  public static int dp2px(float paramFloat, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int i = getWidth();
    int j = getHeight();
    Resources localResources = this.mContext.getResources();
    buildCropShape(this.mIsSend, i, j, localResources, 15.0F);
    if (this.mCropPath != null) {
      paramCanvas.clipPath(this.mCropPath);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public float getTriaWidth()
  {
    return this.triWidth;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (Build.VERSION.SDK_INT < 18)
    {
      setLayerType(1, null);
      return;
    }
    setLayerType(2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView
 * JD-Core Version:    0.7.0.1
 */