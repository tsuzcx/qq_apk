package com.tencent.mobileqq.vas.theme.diy;

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
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import mqq.app.AppRuntime;

public class ThemeDiyStyleLogic$DarkBrightnessTask
  extends AsyncTask<Object, Object, Integer>
{
  Context jdField_a_of_type_AndroidContentContext;
  Bundle jdField_a_of_type_AndroidOsBundle;
  ThemeDIYData jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDIYData;
  ThemeDiyStyleLogic.StyleCallBack jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDiyStyleLogic$StyleCallBack;
  String jdField_a_of_type_JavaLangString;
  public AppRuntime a;
  String b;
  
  public ThemeDiyStyleLogic$DarkBrightnessTask(Context paramContext, AppRuntime paramAppRuntime, String paramString1, String paramString2, ThemeDIYData paramThemeDIYData, Bundle paramBundle, ThemeDiyStyleLogic.StyleCallBack paramStyleCallBack)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDIYData = paramThemeDIYData;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.b = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDiyStyleLogic$StyleCallBack = paramStyleCallBack;
    if ((paramThemeDIYData != null) && (paramThemeDIYData.jdField_b_of_type_ComTencentMobileqqVasThemeDiyResData != null)) {
      paramThemeDIYData.jdField_b_of_type_ComTencentMobileqqVasThemeDiyResData.jdField_b_of_type_Int = 4;
    }
  }
  
  protected Integer a(Object... paramVarArgs)
  {
    paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDIYData;
    Integer localInteger = Integer.valueOf(0);
    if (paramVarArgs == null) {
      return localInteger;
    }
    if (paramVarArgs.jdField_b_of_type_ComTencentMobileqqVasThemeDiyResData == null)
    {
      this.b = this.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel())
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("DoBrightnessTask.doInBackground, params = null, orgSrc = ");
        paramVarArgs.append(this.jdField_a_of_type_JavaLangString);
        QLog.e("ThemeDiyStyleLogic", 2, paramVarArgs.toString());
      }
      return Integer.valueOf(1);
    }
    paramVarArgs = new BitmapFactory.Options();
    paramVarArgs.inPreferredConfig = Bitmap.Config.RGB_565;
    Bitmap localBitmap = BitmapManager.a(this.jdField_a_of_type_JavaLangString, paramVarArgs);
    if (localBitmap == null) {
      return localInteger;
    }
    float f2 = 0.75F;
    int i = this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDIYData.c;
    i = localBitmap.getWidth();
    int k = localBitmap.getHeight();
    if (QLog.isColorLevel())
    {
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("DoBrightnessTask.doInBackground, orgSrc = ");
      paramVarArgs.append(this.jdField_a_of_type_JavaLangString);
      QLog.e("ThemeDiyStyleLogic", 2, paramVarArgs.toString());
    }
    float f1 = f2;
    int m = i;
    int j = k;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDIYData.jdField_b_of_type_ComTencentMobileqqVasThemeDiyResData.a != 0)
    {
      paramVarArgs = this.jdField_a_of_type_AndroidContentContext;
      f1 = f2;
      m = i;
      j = k;
      if ((paramVarArgs instanceof Activity))
      {
        paramVarArgs = (Activity)paramVarArgs;
        localObject = new Rect();
        paramVarArgs.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
        j = ((Rect)localObject).width() * 3 / 4;
        m = ((Rect)localObject).height() * 3 / 4;
        if (m * 1.0F / j >= k * 1.0F / i)
        {
          m = j * k / m;
          i = m;
          j = k;
          if (localBitmap != null)
          {
            i = m;
            j = k;
            if (m > localBitmap.getWidth())
            {
              i = localBitmap.getWidth();
              j = k;
            }
          }
        }
        else
        {
          j = m * i / j;
          if ((localBitmap != null) && (j > localBitmap.getHeight())) {
            j = localBitmap.getWidth();
          }
        }
        f1 = i * 1.0F / ((Rect)localObject).width();
        m = i;
      }
    }
    i = j;
    if (this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDIYData.d != 0)
    {
      i = j - (int)(DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 113.0F) * f1);
      DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 51.0F);
    }
    try
    {
      localObject = localBitmap.getConfig();
      paramVarArgs = (Object[])localObject;
      if (localObject == null) {
        paramVarArgs = Bitmap.Config.RGB_565;
      }
      paramVarArgs = Bitmap.createBitmap(m, i, paramVarArgs);
      localObject = new Canvas(paramVarArgs);
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      ((Canvas)localObject).drawBitmap(localBitmap, 0.0F, 0.0F, localPaint);
      localPaint.setColor(this.jdField_a_of_type_MqqAppAppRuntime.getApp().getResources().getColor(this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDIYData.jdField_b_of_type_Int));
      ((Canvas)localObject).drawRect(0.0F, 0.0F, m, i, localPaint);
      BaseImageUtil.a(paramVarArgs, new File(this.b));
      return Integer.valueOf(1);
    }
    catch (Exception paramVarArgs)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("DoBrightnessTask Error  ");
        ((StringBuilder)localObject).append(paramVarArgs.getMessage());
        QLog.e("ThemeDiyStyleLogic", 2, ((StringBuilder)localObject).toString());
        return localInteger;
      }
    }
    catch (IOException paramVarArgs)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("DoBrightnessTask ioError ");
        ((StringBuilder)localObject).append(paramVarArgs.getMessage());
        QLog.e("ThemeDiyStyleLogic", 2, ((StringBuilder)localObject).toString());
        return localInteger;
      }
    }
    catch (OutOfMemoryError paramVarArgs)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("DoBrightnessTask OOM ");
        ((StringBuilder)localObject).append(paramVarArgs.getMessage());
        QLog.e("ThemeDiyStyleLogic", 2, ((StringBuilder)localObject).toString());
      }
    }
    return localInteger;
  }
  
  protected void a(Integer paramInteger)
  {
    if (paramInteger.intValue() == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ThemeDiyStyleLogic", 2, "DoBrightnessTask.onPostExecute, result is ok");
      }
      paramInteger = this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDiyStyleLogic$StyleCallBack;
      if (paramInteger != null) {
        paramInteger.a(14, 4, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDIYData.jdField_b_of_type_ComTencentMobileqqVasThemeDiyResData);
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.e("ThemeDiyStyleLogic", 2, "DoBrightnessTask.onPostExecute, result is error");
      }
      paramInteger = this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDiyStyleLogic$StyleCallBack;
      if (paramInteger != null) {
        paramInteger.a(14, 8, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeDIYData.jdField_b_of_type_ComTencentMobileqqVasThemeDiyResData);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.diy.ThemeDiyStyleLogic.DarkBrightnessTask
 * JD-Core Version:    0.7.0.1
 */