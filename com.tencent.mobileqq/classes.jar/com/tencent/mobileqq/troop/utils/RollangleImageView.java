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
import arni;
import bcgy;
import bchb;
import bcjk;
import bdda;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class RollangleImageView
  extends ImageView
{
  public static MQLruCache<String, Object> a;
  bchb jdField_a_of_type_Bchb = null;
  public String a;
  boolean jdField_a_of_type_Boolean = false;
  public String b;
  
  static
  {
    jdField_a_of_type_AndroidSupportV4UtilMQLruCache = BaseApplicationImpl.sImageCache;
  }
  
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
    Bitmap localBitmap = (Bitmap)jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get("troopfilerollangleimage://");
    Object localObject4 = (Bitmap)jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get("troopfilerollangleimageborder://");
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
      localObject1 = BitmapFactory.decodeResource((Resources)localObject5, 2130842138);
      jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put("troopfilerollangleimage://", localObject1);
      localObject3 = localObject1;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        localObject2 = BitmapFactory.decodeResource((Resources)localObject5, 2130842137);
        jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put("troopfilerollangleimageborder://", localObject2);
        localObject3 = localObject1;
      }
      localObject1 = bdda.a(new BitmapFactory.Options(), paramString, 128);
      i = paramString.getWidth();
    }
    catch (OutOfMemoryError paramString)
    {
      try
      {
        paramString = bdda.a(paramString, (BitmapFactory.Options)localObject1);
        if (paramString != null) {
          break label181;
        }
        return null;
      }
      catch (OutOfMemoryError paramString)
      {
        if (!QLog.isColorLevel()) {
          break label179;
        }
        QLog.e("RollangleImageView", 4, "decode srcBmp OutOfMemoryError error");
        return null;
      }
      paramString = paramString;
      if (QLog.isColorLevel()) {
        QLog.e("RollangleImageView", 4, "decode maskBmp borderBmp OutOfMemoryError error");
      }
      return null;
    }
    label179:
    label181:
    int i;
    int j = paramString.getHeight();
    int k = Math.max(i, j);
    if (k <= 0) {
      return null;
    }
    Object localObject1 = new Rect(0, 0, k, k);
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
      Rect localRect = new Rect(0, 0, i, j);
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
      if (QLog.isColorLevel()) {
        QLog.e("RollangleImageView", 2, "generateRollAngleThumb, rollAngleBmp, OutOfMemoryError");
      }
    }
    return null;
  }
  
  private Bitmap a(boolean paramBoolean)
  {
    Bitmap localBitmap = null;
    if (!TextUtils.isEmpty(this.b))
    {
      if (paramBoolean) {
        localBitmap = bcgy.a().b(this.b, this);
      }
    }
    else {
      return localBitmap;
    }
    return bcgy.a().a(this.b, this);
  }
  
  public static void setSuspendLoad(boolean paramBoolean)
  {
    bcgy.a().a(paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bchb != null)
    {
      this.jdField_a_of_type_Bchb.cancel(true);
      this.jdField_a_of_type_Bchb = null;
    }
    this.jdField_a_of_type_Bchb = new bchb(this);
    this.jdField_a_of_type_Bchb.execute(new Boolean[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void setParams(String paramString1, String paramString2)
  {
    if ((bcjk.a(paramString1, this.jdField_a_of_type_JavaLangString)) && (bcjk.a(paramString2, this.b))) {
      return;
    }
    if (bcgy.a().jdField_a_of_type_Boolean)
    {
      setParamsOnScrolling(paramString1, paramString2);
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    a(true);
  }
  
  public void setParamsOnScrolling(String paramString1, String paramString2)
  {
    Bitmap localBitmap = bcgy.a().a(paramString2, this);
    if (localBitmap == null)
    {
      setImageResource(arni.b(paramString1));
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    setImageBitmap(localBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.RollangleImageView
 * JD-Core Version:    0.7.0.1
 */