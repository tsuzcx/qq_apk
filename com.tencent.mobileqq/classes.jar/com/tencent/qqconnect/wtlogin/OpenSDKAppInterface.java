package com.tencent.qqconnect.wtlogin;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
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
import android.util.DisplayMetrics;
import antf;
import anzj;
import bdjy;
import bhgm;
import bhmq;
import bjzo;
import bkua;
import bkub;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.startup.step.Step;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import mqq.manager.WtloginManager;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;

public class OpenSDKAppInterface
  extends AppInterface
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private bjzo jdField_a_of_type_Bjzo;
  private BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  
  public OpenSDKAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
  }
  
  public long a(WtloginManager paramWtloginManager, String paramString)
  {
    if (paramWtloginManager == null) {
      return 0L;
    }
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    paramWtloginManager.getBasicUserInfo(paramString, localWloginSimpleInfo);
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
  
  public Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    float f2 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources().getDisplayMetrics().density;
    int i = paramBitmap.getWidth();
    float f1 = f2;
    if (i > 0)
    {
      f1 = f2;
      if (i < paramInt1 * f2) {
        f1 = i / paramInt1;
      }
    }
    paramInt1 = (int)(paramInt1 * f1);
    paramInt2 = (int)(f1 * paramInt2);
    return bhmq.a(paramBitmap, paramInt1, paramInt1, paramInt2);
  }
  
  public Bitmap a(String paramString)
  {
    long l = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSharedPreferences("ssoappicon", 0).getLong(paramString, 0L);
    if (l == 0L) {}
    while (System.currentTimeMillis() / 1000L - l > 172800L) {
      return null;
    }
    return bhgm.a(antf.ba + "appicon/" + paramString);
  }
  
  public Bitmap a(String paramString, int paramInt, boolean paramBoolean)
  {
    Bitmap localBitmap2 = bhgm.a(b(paramString));
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = bhgm.a(a(paramString));
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
  
  public bjzo a()
  {
    try
    {
      if (this.jdField_a_of_type_Bjzo == null) {
        this.jdField_a_of_type_Bjzo = new bjzo();
      }
      bjzo localbjzo = this.jdField_a_of_type_Bjzo;
      return localbjzo;
    }
    finally {}
  }
  
  public String a(String paramString)
  {
    String str = MD5.toMD5(paramString);
    str = MD5.toMD5(str + paramString);
    paramString = MD5.toMD5(str + paramString);
    return antf.bM + paramString + ".png";
  }
  
  public void a(Context paramContext, String paramString)
  {
    if (((paramContext instanceof Activity)) && (!((Activity)paramContext).isFinishing()))
    {
      paramContext = new AlertDialog.Builder(paramContext);
      paramContext.setMessage(paramString);
      paramContext.setNegativeButton(anzj.a(2131706736), new bkua(this));
      paramContext.show();
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getSharedPreferences("ssoappicon", 0).edit().putLong(paramString, System.currentTimeMillis() / 1000L).commit();
    File localFile = new File(antf.ba + "appicon/");
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
    return antf.bR + paramString + ".png";
  }
  
  public BaseApplication getApp()
  {
    return this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
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
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    bdjy.b(12, BaseApplicationImpl.sDirector, null).step();
    if (QLog.isColorLevel()) {
      QLog.i("OpenSDKAppInterface", 2, "onCreate: invoked.  savedInstanceState: " + paramBundle);
    }
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bkub(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("mqq.intent.action.ACCOUNT_KICKED");
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl != null) {
      this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.OpenSDKAppInterface
 * JD-Core Version:    0.7.0.1
 */