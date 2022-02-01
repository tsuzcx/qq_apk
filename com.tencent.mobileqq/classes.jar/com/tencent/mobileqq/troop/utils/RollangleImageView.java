package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class RollangleImageView
  extends ImageView
{
  public static MQLruCache<String, Object> c = GlobalImageCache.a;
  public String a;
  public String b;
  RollangleImageView.MyUpdateImageAsyncTask d = null;
  boolean e = false;
  
  public RollangleImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RollangleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RollangleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static Bitmap a(String paramString)
  {
    Bitmap localBitmap = (Bitmap)c.get("troopfilerollangleimage://");
    Object localObject4 = (Bitmap)c.get("troopfilerollangleimageborder://");
    Object localObject3;
    Object localObject2;
    Object localObject5;
    if (localBitmap != null)
    {
      localObject3 = localBitmap;
      localObject2 = localObject4;
      if (localObject4 != null) {}
    }
    else
    {
      localObject5 = BaseApplication.getContext().getResources();
      localObject1 = localBitmap;
      if (localBitmap != null) {}
    }
    try
    {
      localObject1 = BitmapFactory.decodeResource((Resources)localObject5, 2130843548);
      c.put("troopfilerollangleimage://", localObject1);
      localObject3 = localObject1;
      localObject2 = localObject4;
      if (localObject4 != null) {
        break label140;
      }
      localObject2 = BitmapFactory.decodeResource((Resources)localObject5, 2130843547);
      c.put("troopfilerollangleimageborder://", localObject2);
      localObject3 = localObject1;
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;) {}
    }
    if (QLog.isColorLevel()) {
      QLog.e("RollangleImageView", 4, "decode maskBmp borderBmp OutOfMemoryError error");
    }
    return null;
    label140:
    Object localObject1 = ImageUtil.a(new BitmapFactory.Options(), paramString, 128);
    try
    {
      paramString = ImageUtil.a(paramString, (BitmapFactory.Options)localObject1);
      if (paramString == null) {
        return null;
      }
      i = paramString.getWidth();
      j = paramString.getHeight();
      k = Math.max(i, j);
      if (k <= 0) {
        return null;
      }
      localObject1 = new Rect(0, 0, k, k);
    }
    catch (OutOfMemoryError paramString)
    {
      int i;
      int j;
      int k;
      Rect localRect;
      label412:
      label428:
      break label428;
    }
    try
    {
      localBitmap = Bitmap.createBitmap(k, k, Bitmap.Config.ARGB_8888);
      localObject4 = new Canvas(localBitmap);
      localObject5 = new Paint();
      ((Paint)localObject5).setAntiAlias(true);
      ((Canvas)localObject4).drawBitmap((Bitmap)localObject3, new Rect(0, 0, ((Bitmap)localObject3).getWidth(), ((Bitmap)localObject3).getHeight()), (Rect)localObject1, (Paint)localObject5);
      localObject3 = new Rect();
      ((Rect)localObject3).left = ((k - i) / 2);
      ((Rect)localObject3).top = ((k - j) / 2);
      ((Rect)localObject3).right = (((Rect)localObject3).left + i);
      ((Rect)localObject3).bottom = (((Rect)localObject3).top + j);
      localRect = new Rect(0, 0, i, j);
      ((Paint)localObject5).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      ((Canvas)localObject4).drawBitmap(paramString, localRect, (Rect)localObject3, (Paint)localObject5);
      localObject3 = new Rect(0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight());
      ((Paint)localObject5).setXfermode(null);
      ((Canvas)localObject4).drawBitmap((Bitmap)localObject2, (Rect)localObject3, (Rect)localObject1, (Paint)localObject5);
      paramString.recycle();
      return localBitmap;
    }
    catch (OutOfMemoryError paramString)
    {
      break label412;
    }
    if (QLog.isColorLevel()) {
      QLog.e("RollangleImageView", 2, "generateRollAngleThumb, rollAngleBmp, OutOfMemoryError");
    }
    return null;
    if (QLog.isColorLevel()) {
      QLog.e("RollangleImageView", 4, "decode srcBmp OutOfMemoryError error");
    }
    return null;
  }
  
  private Bitmap b(boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(this.b))
    {
      if (paramBoolean) {
        return RollangleImageView.ImageCache.a().b(this.b, this);
      }
      return RollangleImageView.ImageCache.a().a(this.b, this);
    }
    return null;
  }
  
  public static void setSuspendLoad(boolean paramBoolean)
  {
    RollangleImageView.ImageCache.a().a(paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    RollangleImageView.MyUpdateImageAsyncTask localMyUpdateImageAsyncTask = this.d;
    if (localMyUpdateImageAsyncTask != null)
    {
      localMyUpdateImageAsyncTask.cancel(true);
      this.d = null;
    }
    this.d = new RollangleImageView.MyUpdateImageAsyncTask(this);
    this.d.execute(new Boolean[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void setParams(String paramString1, String paramString2)
  {
    if ((TroopFileUtils.a(paramString1, this.a)) && (TroopFileUtils.a(paramString2, this.b))) {
      return;
    }
    if (RollangleImageView.ImageCache.a().a)
    {
      setParamsOnScrolling(paramString1, paramString2);
      return;
    }
    this.a = paramString1;
    this.b = paramString2;
    a(true);
  }
  
  public void setParamsOnScrolling(String paramString1, String paramString2)
  {
    Bitmap localBitmap = RollangleImageView.ImageCache.a().a(paramString2, this);
    if (localBitmap == null)
    {
      setImageResource(FileManagerUtil.i(paramString1));
      return;
    }
    this.a = paramString1;
    this.b = paramString2;
    setImageBitmap(localBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.RollangleImageView
 * JD-Core Version:    0.7.0.1
 */