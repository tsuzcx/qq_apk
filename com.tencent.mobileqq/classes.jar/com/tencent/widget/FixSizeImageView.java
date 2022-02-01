package com.tencent.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.util.MQLruCache;
import android.util.AttributeSet;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class FixSizeImageView
  extends ThemeImageView
  implements IRecentImgv
{
  protected boolean isShowMask = false;
  protected boolean isShowTroopCreditStatusIcon = false;
  protected Paint mBmpPaint = null;
  protected float mContentCenterX = -1.0F;
  protected float mContentCenterY = -1.0F;
  protected float mContentRadius = 0.0F;
  protected Paint mMaskPaint = null;
  protected long mTroopCreditLevel = 5L;
  protected Bitmap mTroopCreditStatusBmp = null;
  protected Rect mTroopCreditStatusIconRect = null;
  
  public FixSizeImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FixSizeImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FixSizeImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected static Bitmap getTroopCreditStatusIcon(long paramLong)
  {
    long l = System.currentTimeMillis();
    int i;
    Object localObject;
    if (paramLong == 1L)
    {
      i = 2130852645;
      localObject = "StatusIcon_TroopPermanentBlockStatusBigIconKey";
    }
    else if (paramLong == 2L)
    {
      i = 2130852647;
      localObject = "StatusIcon_TroopTmpBlockStatusBigIcon";
    }
    else
    {
      i = -1;
      localObject = "";
    }
    Bitmap localBitmap1 = null;
    if (i < 0) {
      return null;
    }
    if (GlobalImageCache.a != null) {
      localBitmap1 = (Bitmap)GlobalImageCache.a.get(localObject);
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.b(BaseApplication.getContext().getResources(), i);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (GlobalImageCache.a != null)
        {
          GlobalImageCache.a.put(localObject, localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTroopCreditStatusIcon:");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
      QLog.i("FixSizeImageView", 2, ((StringBuilder)localObject).toString());
    }
    return localBitmap2;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if ((this.isShowMask) || (this.isShowTroopCreditStatusIcon)) {
      doExtraDraw(paramCanvas);
    }
  }
  
  protected void doExtraDraw(Canvas paramCanvas)
  {
    int i;
    int j;
    if (this.isShowMask)
    {
      if ((this.mContentCenterX == -1.0F) || (this.mContentCenterY == -1.0F))
      {
        i = getWidth() - getPaddingLeft() - getPaddingRight();
        this.mContentCenterX = (getPaddingLeft() + i * 0.5F);
        j = getHeight() - getPaddingTop() - getPaddingBottom();
        this.mContentCenterY = (getPaddingTop() + j * 0.5F);
        this.mContentRadius = (Math.max(i, j) / 2);
      }
      if (this.mMaskPaint == null)
      {
        this.mMaskPaint = new Paint();
        this.mMaskPaint.setAntiAlias(true);
        this.mMaskPaint.setColor(Color.parseColor("#B2000000"));
      }
      paramCanvas.drawCircle(this.mContentCenterX, this.mContentCenterY, this.mContentRadius, this.mMaskPaint);
    }
    if (this.isShowTroopCreditStatusIcon)
    {
      if (this.mBmpPaint == null)
      {
        this.mBmpPaint = new Paint();
        this.mBmpPaint.setAntiAlias(true);
        this.mBmpPaint.setFilterBitmap(true);
      }
      if (this.mTroopCreditStatusBmp != null)
      {
        if (this.mTroopCreditStatusIconRect == null)
        {
          i = getWidth() - getPaddingRight();
          j = getHeight() - getPaddingBottom();
          this.mTroopCreditStatusIconRect = new Rect(i - this.mTroopCreditStatusBmp.getWidth(), j - this.mTroopCreditStatusBmp.getHeight(), i, j);
        }
        paramCanvas.drawBitmap(this.mTroopCreditStatusBmp, null, this.mTroopCreditStatusIconRect, this.mBmpPaint);
      }
    }
  }
  
  protected void init()
  {
    this.themeImageWrapper = null;
  }
  
  public void requestLayout() {}
  
  public void showTroopCreditStatus(long paramLong)
  {
    if (this.mTroopCreditLevel == paramLong) {
      return;
    }
    this.mTroopCreditLevel = paramLong;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showTroopCreditStatus:");
      localStringBuilder.append(paramLong);
      QLog.i("FixSizeImageView", 2, localStringBuilder.toString());
    }
    if ((paramLong != 2L) && (paramLong != 1L))
    {
      this.isShowMask = false;
      this.isShowTroopCreditStatusIcon = false;
      this.mTroopCreditStatusBmp = null;
    }
    else
    {
      this.isShowMask = true;
      this.isShowTroopCreditStatusIcon = true;
      this.mTroopCreditStatusBmp = getTroopCreditStatusIcon(paramLong);
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.FixSizeImageView
 * JD-Core Version:    0.7.0.1
 */