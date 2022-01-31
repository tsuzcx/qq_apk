package com.tencent.mobileqq.theme.diy;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class ThemeDiyStyleLogic$DarkBrightnessTask
  extends AsyncTask
{
  public QQAppInterface app;
  Bundle bundle;
  Context ctx;
  ThemeDIYData data;
  ThemeDiyStyleLogic.StyleCallBack dealPicCallBack;
  String orgSrc;
  String saveSrc;
  
  public ThemeDiyStyleLogic$DarkBrightnessTask(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ThemeDIYData paramThemeDIYData, Bundle paramBundle, ThemeDiyStyleLogic.StyleCallBack paramStyleCallBack)
  {
    this.ctx = paramContext;
    this.app = paramQQAppInterface;
    this.orgSrc = paramString1;
    this.data = paramThemeDIYData;
    this.bundle = paramBundle;
    this.saveSrc = paramString2;
    this.dealPicCallBack = paramStyleCallBack;
    if ((paramThemeDIYData != null) && (paramThemeDIYData.tryOnBgBigOrgRD != null)) {
      paramThemeDIYData.tryOnBgBigOrgRD.state = 4;
    }
  }
  
  protected Integer doInBackground(Object... paramVarArgs)
  {
    if (this.data == null) {
      return Integer.valueOf(0);
    }
    if ((this.data.tryOnBgBigOrgRD == null) || (!(this.ctx instanceof Activity)))
    {
      this.saveSrc = this.orgSrc;
      if (QLog.isColorLevel()) {
        QLog.e("ThemeDiyStyleLogic", 2, "DoBrightnessTask.doInBackground, params = null, orgSrc = " + this.orgSrc);
      }
      return Integer.valueOf(1);
    }
    paramVarArgs = new BitmapFactory.Options();
    paramVarArgs.inPreferredConfig = Bitmap.Config.RGB_565;
    Bitmap localBitmap = BitmapManager.a(this.orgSrc, paramVarArgs);
    if (localBitmap == null) {
      return Integer.valueOf(0);
    }
    int i1 = this.data.dealInt;
    int i = localBitmap.getWidth();
    int j = localBitmap.getHeight();
    if (QLog.isColorLevel()) {
      QLog.e("ThemeDiyStyleLogic", 2, "DoBrightnessTask.doInBackground, orgSrc = " + this.orgSrc);
    }
    paramVarArgs = (Activity)this.ctx;
    Object localObject;
    int k;
    int m;
    float f;
    if ((this.data.tryOnBgBigOrgRD.index != 0) && (paramVarArgs != null))
    {
      localObject = new Rect();
      paramVarArgs.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      k = ((Rect)localObject).width() * 3 / 4;
      m = ((Rect)localObject).height() * 3 / 4;
      if (1.0F * m / k >= 1.0F * j / i)
      {
        k = k * j / m;
        if (k <= localBitmap.getWidth()) {
          break label720;
        }
        k = localBitmap.getWidth();
        i = j;
        j = k;
        f = 1.0F * j / ((Rect)localObject).width();
        k = i;
        i = j;
        j = k;
        label316:
        if (this.data.position == 0) {
          break label705;
        }
        j -= (int)(DisplayUtils.a(this.ctx, 113.0F) * f);
        k = (int)(f * DisplayUtils.a(this.ctx, 51.0F));
      }
    }
    for (;;)
    {
      int n;
      try
      {
        localObject = localBitmap.getConfig();
        paramVarArgs = (Object[])localObject;
        if (localObject == null) {
          paramVarArgs = Bitmap.Config.RGB_565;
        }
        paramVarArgs = Bitmap.createBitmap(i, j, paramVarArgs);
        f = 0.01F * i1;
        m = 0;
      }
      catch (OutOfMemoryError paramVarArgs)
      {
        int i5;
        int i2;
        int i3;
        int i4;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ThemeDiyStyleLogic", 2, "DoBrightnessTask OOM " + paramVarArgs.getMessage());
        return Integer.valueOf(0);
        m += 1;
        break label736;
        ImageUtil.a(paramVarArgs, new File(this.saveSrc));
        return Integer.valueOf(1);
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
      if (n < j)
      {
        i5 = localBitmap.getPixel(m, n + k);
        if (i1 > 0)
        {
          i2 = Color.alpha(i5);
          i3 = Color.red(i5);
          i4 = Color.green(i5);
          i5 = Color.blue(i5);
          paramVarArgs.setPixel(m, n, Color.argb(i2, i3 + (int)((255 - i3) * f), i4 + (int)((255 - i4) * f), i5 + (int)((255 - i5) * f)));
          n += 1;
          continue;
          k = i * m / k;
          if (k <= localBitmap.getHeight()) {
            break label711;
          }
          k = localBitmap.getWidth();
          j = i;
          i = k;
          break;
        }
        paramVarArgs.setPixel(m, n, i5);
        continue;
      }
      label705:
      k = 0;
      continue;
      label711:
      j = i;
      i = k;
      break;
      label720:
      i = j;
      j = k;
      break;
      f = 0.75F;
      break label316;
      label736:
      if (m < i) {
        n = 0;
      }
    }
  }
  
  protected void onPostExecute(Integer paramInteger)
  {
    if (paramInteger.intValue() == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ThemeDiyStyleLogic", 2, "DoBrightnessTask.onPostExecute, result is ok");
      }
      this.dealPicCallBack.callback(14, 4, this.bundle, this.data.tryOnBgBigOrgRD);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ThemeDiyStyleLogic", 2, "DoBrightnessTask.onPostExecute, result is error");
    }
    this.dealPicCallBack.callback(14, 8, this.bundle, this.data.tryOnBgBigOrgRD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDiyStyleLogic.DarkBrightnessTask
 * JD-Core Version:    0.7.0.1
 */