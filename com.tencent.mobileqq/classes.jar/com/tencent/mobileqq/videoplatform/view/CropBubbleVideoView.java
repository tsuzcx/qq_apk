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
  private static final float[] DEFAULT_EDGE_CORDS = { 7.0F, 9.0F, 0.0F, 6.0F, 2.5F, 9.0F, 5.5F, 15.0F, 0.5F, 13.0F };
  private static final String TAG = "CropBubbleVideoView";
  private static final float ax;
  private static final float ay;
  private static final float bx;
  private static final float by;
  private static final float cx = arrayOfFloat[6];
  private static final float cy = arrayOfFloat[7];
  private static final float mx;
  private static final float my;
  private static final float nx = arrayOfFloat[8];
  private static final float ny = arrayOfFloat[9];
  private Path mCropPath;
  private boolean mDrawTri = true;
  public boolean mIsSend;
  private float mRectRadius = 15.0F;
  public float triWidth = Math.abs(bx - cx);
  
  static
  {
    float[] arrayOfFloat = DEFAULT_EDGE_CORDS;
    ax = arrayOfFloat[0];
    ay = arrayOfFloat[1];
    bx = arrayOfFloat[2];
    by = arrayOfFloat[3];
    mx = arrayOfFloat[4];
    my = arrayOfFloat[5];
  }
  
  public CropBubbleVideoView(Context paramContext, long paramLong, VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    super(paramContext, paramLong, paramVideoPlayParam, null, null, true);
    this.mIsSend = paramBoolean;
  }
  
  private void buildCropShape(boolean paramBoolean, int paramInt1, int paramInt2, Resources paramResources, float paramFloat)
  {
    Object localObject = this.mCropPath;
    if (localObject != null) {
      ((Path)localObject).reset();
    } else {
      this.mCropPath = new Path();
    }
    localObject = new RectF();
    float f1 = dp2px(this.triWidth, paramResources);
    if (this.mDrawTri)
    {
      if (paramBoolean) {
        ((RectF)localObject).set(0.0F, 0.0F, paramInt1 - f1, paramInt2);
      } else {
        ((RectF)localObject).set(f1, 0.0F, paramInt1, paramInt2);
      }
    }
    else {
      ((RectF)localObject).set(0.0F, 0.0F, paramInt1, paramInt2);
    }
    f1 = dp2px(by, paramResources);
    float[] arrayOfFloat = new float[8];
    Arrays.fill(arrayOfFloat, dp2px(paramFloat, paramResources));
    float f2;
    float f3;
    if (paramBoolean)
    {
      this.mCropPath.addRoundRect((RectF)localObject, arrayOfFloat, Path.Direction.CW);
      if (this.mDrawTri)
      {
        paramFloat = paramInt1 - dp2px(ax, paramResources);
        f2 = dp2px(ay, paramResources);
        this.mCropPath.moveTo(paramFloat, f2);
        paramFloat = paramInt1 - dp2px(bx, paramResources);
        f2 = paramInt1 - dp2px(mx, paramResources);
        f3 = dp2px(my, paramResources);
        this.mCropPath.quadTo(f2, f3, paramFloat, f1);
        paramFloat = paramInt1 - dp2px(cx, paramResources);
        f1 = dp2px(cy, paramResources);
        f2 = paramInt1 - dp2px(nx, paramResources);
        f3 = dp2px(ny, paramResources);
        this.mCropPath.quadTo(f2, f3, paramFloat, f1);
      }
    }
    else
    {
      this.mCropPath.addRoundRect((RectF)localObject, arrayOfFloat, Path.Direction.CCW);
      if (this.mDrawTri)
      {
        paramFloat = dp2px(ax, paramResources);
        f2 = dp2px(ay, paramResources);
        this.mCropPath.moveTo(paramFloat, f2);
        paramFloat = bx;
        f2 = dp2px(mx, paramResources);
        f3 = dp2px(my, paramResources);
        this.mCropPath.quadTo(f2, f3, paramFloat, f1);
        paramFloat = dp2px(cx, paramResources);
        f1 = dp2px(cy, paramResources);
        f2 = dp2px(nx, paramResources);
        f3 = dp2px(ny, paramResources);
        this.mCropPath.quadTo(f2, f3, paramFloat, f1);
      }
    }
    this.mCropPath.close();
  }
  
  public static int dp2px(float paramFloat, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int i = getWidth();
    int j = getHeight();
    Object localObject = this.mContext.getResources();
    buildCropShape(this.mIsSend, i, j, (Resources)localObject, this.mRectRadius);
    localObject = this.mCropPath;
    if (localObject != null) {
      paramCanvas.clipPath((Path)localObject);
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
  
  public void setDrawTri(boolean paramBoolean)
  {
    this.mDrawTri = paramBoolean;
  }
  
  public void setRadius(float paramFloat)
  {
    this.mRectRadius = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView
 * JD-Core Version:    0.7.0.1
 */