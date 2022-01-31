package com.tencent.qqconnect.wtlogin;

import alwk;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.startup.step.Step;
import com.tencent.mobileqq.startup.step.Step.AmStepFactory;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

public class OpenSDKAppInterface
  extends AppInterface
{
  private BaseApplicationImpl a;
  
  public OpenSDKAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    this.a = paramBaseApplicationImpl;
  }
  
  public long a(WtloginManager paramWtloginManager, String paramString)
  {
    if (paramWtloginManager == null) {
      return 0L;
    }
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    paramWtloginManager.GetBasicUserInfo(paramString, localWloginSimpleInfo);
    return localWloginSimpleInfo._uin;
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    RectF localRectF = new RectF(localRect);
    localPaint.setAntiAlias(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-65536);
    localCanvas.drawRoundRect(localRectF, 4.0F, 4.0F, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
    return localBitmap;
  }
  
  public Bitmap a(String paramString, int paramInt, boolean paramBoolean)
  {
    Bitmap localBitmap2 = BitmapManager.a(b(paramString));
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = BitmapManager.a(a(paramString));
    }
    if (localBitmap1 == null) {
      paramString = null;
    }
    do
    {
      return paramString;
      paramString = new Matrix();
      paramString.reset();
      float f = paramInt / localBitmap1.getWidth();
      paramString.postScale(f, f);
      localBitmap1 = Bitmap.createBitmap(localBitmap1, 0, 0, localBitmap1.getWidth(), localBitmap1.getHeight(), paramString, false);
      paramString = localBitmap1;
    } while (!paramBoolean);
    return a(localBitmap1);
  }
  
  public String a(String paramString)
  {
    String str = MD5.toMD5(paramString);
    str = MD5.toMD5(str + paramString);
    paramString = MD5.toMD5(str + paramString);
    return AppConstants.bm + paramString + ".png";
  }
  
  public void a(Context paramContext, String paramString)
  {
    if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing()))
    {
      paramContext = new AlertDialog.Builder(paramContext);
      paramContext.setMessage(paramString);
      paramContext.setNegativeButton("确定", new alwk(this));
      paramContext.show();
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    this.a.getSharedPreferences("ssoappicon", 0).edit().putLong(paramString, System.currentTimeMillis() / 1000L).commit();
    File localFile = new File(AppConstants.aJ + "appicon/");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    paramString = new File(localFile, paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
    try
    {
      paramString = new FileOutputStream(paramString);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 90, paramString);
      paramString.flush();
      paramString.close();
      return;
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public String b(String paramString)
  {
    String str = MD5.toMD5(paramString);
    str = MD5.toMD5(str + paramString);
    paramString = MD5.toMD5(str + paramString);
    return AppConstants.bD + paramString + ".png";
  }
  
  public BaseApplication getApp()
  {
    return this.a;
  }
  
  public int getAppid()
  {
    return 0;
  }
  
  public String getCurrentAccountUin()
  {
    return null;
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    return null;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Step.AmStepFactory.b(10, BaseApplicationImpl.sDirector, null).c();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.OpenSDKAppInterface
 * JD-Core Version:    0.7.0.1
 */