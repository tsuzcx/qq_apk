package com.tencent.widget;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.util.MQLruCache;
import android.util.AttributeSet;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class RecentDynamicAvatarView
  extends DynamicAvatarView
  implements IRecentImgv
{
  private static boolean r = false;
  protected float h = -1.0F;
  protected float i = -1.0F;
  protected float j = 0.0F;
  protected Paint k = null;
  protected Paint l = null;
  protected boolean m = false;
  protected boolean n = false;
  protected Rect o = null;
  protected long p = 5L;
  protected Bitmap q = null;
  
  static
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("isShow_setting", 4);
    if (localSharedPreferences != null) {
      r = localSharedPreferences.getBoolean("isShow", false);
    }
  }
  
  public RecentDynamicAvatarView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RecentDynamicAvatarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RecentDynamicAvatarView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected static Bitmap a(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    int i1;
    Object localObject;
    if (paramLong == 1L)
    {
      i1 = 2130852645;
      localObject = "StatusIcon_TroopPermanentBlockStatusBigIconKey";
    }
    else if (paramLong == 2L)
    {
      i1 = 2130852647;
      localObject = "StatusIcon_TroopTmpBlockStatusBigIcon";
    }
    else
    {
      i1 = -1;
      localObject = "";
    }
    Bitmap localBitmap1 = null;
    if (i1 < 0) {
      return null;
    }
    if (GlobalImageCache.a != null) {
      localBitmap1 = (Bitmap)GlobalImageCache.a.get(localObject);
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.b(BaseApplicationImpl.getApplication().getResources(), i1);
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
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l1);
      QLog.i("FixSizeImageView", 2, ((StringBuilder)localObject).toString());
    }
    return localBitmap2;
  }
  
  public static void setNeedRequestLayout(boolean paramBoolean)
  {
    r = paramBoolean;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    int i1;
    int i2;
    if (this.m)
    {
      if ((this.h == -1.0F) || (this.i == -1.0F))
      {
        i1 = getWidth() - getPaddingLeft() - getPaddingRight();
        this.h = (getPaddingLeft() + i1 * 0.5F);
        i2 = getHeight() - getPaddingTop() - getPaddingBottom();
        this.i = (getPaddingTop() + i2 * 0.5F);
        this.j = (Math.max(i1, i2) / 2);
      }
      if (this.k == null)
      {
        this.k = new Paint();
        this.k.setAntiAlias(true);
        this.k.setColor(Color.parseColor("#B2000000"));
      }
      paramCanvas.drawCircle(this.h, this.i, this.j, this.k);
    }
    if (this.n)
    {
      if (this.l == null)
      {
        this.l = new Paint();
        this.l.setAntiAlias(true);
        this.l.setFilterBitmap(true);
      }
      if (this.q != null)
      {
        if (this.o == null)
        {
          i1 = getWidth() - getPaddingRight();
          i2 = getHeight() - getPaddingBottom();
          this.o = new Rect(i1 - this.q.getWidth(), i2 - this.q.getHeight(), i1, i2);
        }
        paramCanvas.drawBitmap(this.q, null, this.o, this.l);
      }
    }
  }
  
  public void requestLayout()
  {
    if (r) {
      super.requestLayout();
    }
  }
  
  public void showTroopCreditStatus(long paramLong)
  {
    if (this.p == paramLong) {
      return;
    }
    this.p = paramLong;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showTroopCreditStatus:");
      localStringBuilder.append(paramLong);
      QLog.i("FixSizeImageView", 2, localStringBuilder.toString());
    }
    if ((paramLong != 2L) && (paramLong != 1L))
    {
      this.m = false;
      this.n = false;
      this.q = null;
    }
    else
    {
      this.m = true;
      this.n = true;
      this.q = a(paramLong);
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.RecentDynamicAvatarView
 * JD-Core Version:    0.7.0.1
 */