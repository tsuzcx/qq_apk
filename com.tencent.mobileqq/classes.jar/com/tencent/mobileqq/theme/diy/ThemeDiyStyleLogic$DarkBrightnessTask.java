package com.tencent.mobileqq.theme.diy;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import bdbx;
import bfpx;
import bfvh;
import bfvo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class ThemeDiyStyleLogic$DarkBrightnessTask
  extends AsyncTask<Object, Object, Integer>
{
  public QQAppInterface app;
  Bundle bundle;
  Context ctx;
  ThemeDIYData data;
  bdbx dealPicCallBack;
  String orgSrc;
  String saveSrc;
  
  public ThemeDiyStyleLogic$DarkBrightnessTask(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ThemeDIYData paramThemeDIYData, Bundle paramBundle, bdbx parambdbx)
  {
    this.ctx = paramContext;
    this.app = paramQQAppInterface;
    this.orgSrc = paramString1;
    this.data = paramThemeDIYData;
    this.bundle = paramBundle;
    this.saveSrc = paramString2;
    this.dealPicCallBack = parambdbx;
    if ((paramThemeDIYData != null) && (paramThemeDIYData.tryOnBgBigOrgRD != null)) {
      paramThemeDIYData.tryOnBgBigOrgRD.state = 4;
    }
  }
  
  protected Integer doInBackground(Object... paramVarArgs)
  {
    if (this.data == null) {
      return Integer.valueOf(0);
    }
    if (this.data.tryOnBgBigOrgRD == null)
    {
      this.saveSrc = this.orgSrc;
      if (QLog.isColorLevel()) {
        QLog.e("ThemeDiyStyleLogic", 2, "DoBrightnessTask.doInBackground, params = null, orgSrc = " + this.orgSrc);
      }
      return Integer.valueOf(1);
    }
    paramVarArgs = new BitmapFactory.Options();
    paramVarArgs.inPreferredConfig = Bitmap.Config.RGB_565;
    Bitmap localBitmap = bfpx.a(this.orgSrc, paramVarArgs);
    if (localBitmap == null) {
      return Integer.valueOf(0);
    }
    float f = 0.75F;
    int i = this.data.dealInt;
    int j = localBitmap.getWidth();
    i = localBitmap.getHeight();
    if (QLog.isColorLevel()) {
      QLog.e("ThemeDiyStyleLogic", 2, "DoBrightnessTask.doInBackground, orgSrc = " + this.orgSrc);
    }
    Object localObject;
    int k;
    int m;
    if ((this.data.tryOnBgBigOrgRD.index != 0) && ((this.ctx instanceof Activity)))
    {
      paramVarArgs = (Activity)this.ctx;
      localObject = new Rect();
      paramVarArgs.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      k = ((Rect)localObject).width() * 3 / 4;
      m = ((Rect)localObject).height() * 3 / 4;
      if (m * 1.0F / k >= i * 1.0F / j)
      {
        j = k * i / m;
        if ((localBitmap == null) || (j <= localBitmap.getWidth())) {
          break label620;
        }
        j = localBitmap.getWidth();
        f = j * 1.0F / ((Rect)localObject).width();
      }
    }
    for (;;)
    {
      if (this.data.position != 0)
      {
        k = (int)(bfvh.a(this.ctx, 113.0F) * f);
        m = (int)(f * bfvh.a(this.ctx, 51.0F));
        i -= k;
      }
      for (;;)
      {
        try
        {
          localObject = localBitmap.getConfig();
          paramVarArgs = (Object[])localObject;
          if (localObject == null) {
            paramVarArgs = Bitmap.Config.RGB_565;
          }
          paramVarArgs = Bitmap.createBitmap(j, i, paramVarArgs);
          localObject = new Canvas(paramVarArgs);
          Paint localPaint = new Paint();
          localPaint.setAntiAlias(true);
          ((Canvas)localObject).drawBitmap(localBitmap, 0.0F, 0.0F, localPaint);
          localPaint.setColor(this.app.getApp().getResources().getColor(this.data.orgMarkColor));
          ((Canvas)localObject).drawRect(0.0F, 0.0F, j, i, localPaint);
          bfvo.a(paramVarArgs, new File(this.saveSrc));
          return Integer.valueOf(1);
        }
        catch (OutOfMemoryError paramVarArgs)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("ThemeDiyStyleLogic", 2, "DoBrightnessTask OOM " + paramVarArgs.getMessage());
          return Integer.valueOf(0);
        }
        catch (IOException paramVarArgs)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("ThemeDiyStyleLogic", 2, "DoBrightnessTask ioError " + paramVarArgs.getMessage());
          continue;
        }
        catch (Exception paramVarArgs)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("ThemeDiyStyleLogic", 2, "DoBrightnessTask Error  " + paramVarArgs.getMessage());
          continue;
        }
        i = j * m / k;
        if ((localBitmap == null) || (i <= localBitmap.getHeight())) {
          break label617;
        }
        i = localBitmap.getWidth();
        break;
      }
      label617:
      break;
      label620:
      break;
    }
  }
  
  protected void onPostExecute(Integer paramInteger)
  {
    if (paramInteger.intValue() == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ThemeDiyStyleLogic", 2, "DoBrightnessTask.onPostExecute, result is ok");
      }
      if (this.dealPicCallBack != null) {
        this.dealPicCallBack.callback(14, 4, this.bundle, this.data.tryOnBgBigOrgRD);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.e("ThemeDiyStyleLogic", 2, "DoBrightnessTask.onPostExecute, result is error");
      }
    } while (this.dealPicCallBack == null);
    this.dealPicCallBack.callback(14, 8, this.bundle, this.data.tryOnBgBigOrgRD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDiyStyleLogic.DarkBrightnessTask
 * JD-Core Version:    0.7.0.1
 */