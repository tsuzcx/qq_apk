package com.tencent.mobileqq.floatscr;

import adac;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasManager;
import com.tencent.mobileqq.vas.VasManager.CompleteListener;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class ColorScreenManager
  extends VasManager
{
  public static boolean a;
  protected Context a;
  protected AppInterface a;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public ColorScreenManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramAppInterface.getApp().getApplicationContext();
  }
  
  public int a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      String[] arrayOfString = paramString.split("\\.");
      localObject1 = localObject2;
      if (arrayOfString.length >= 3) {
        try
        {
          int i = Integer.parseInt(arrayOfString[2]);
          return i;
        }
        catch (NumberFormatException localNumberFormatException) {}
      }
    }
    QLog.e("ColorScreenManager", 1, "getColorScreenId failed from " + paramString, localNumberFormatException);
    return 0;
  }
  
  public ColorScreenConfig a(int paramInt)
  {
    ColorScreenConfig localColorScreenConfig = null;
    Object localObject = new File(a(paramInt), "unzip");
    if (!((File)localObject).exists())
    {
      localObject = localColorScreenConfig;
      if (QLog.isColorLevel())
      {
        QLog.d("ColorScreenManager", 1, "getLocalConfig unzipDir not exist");
        localObject = localColorScreenConfig;
      }
    }
    for (;;)
    {
      return localObject;
      File localFile2 = new File((File)localObject, "config.json");
      File localFile1 = new File((File)localObject, "fullscreen.json");
      if (!localFile2.exists())
      {
        QLog.e("ColorScreenManager", 1, "configFile do not exists.");
        return null;
      }
      if (!localFile1.exists())
      {
        QLog.e("ColorScreenManager", 1, "animFile do not exists.");
        return null;
      }
      localColorScreenConfig = new ColorScreenConfig();
      localColorScreenConfig.jdField_a_of_type_JavaLangString = localFile1.getAbsolutePath();
      localColorScreenConfig.jdField_b_of_type_JavaLangString = (((File)localObject).getAbsolutePath() + File.separator + "images");
      try
      {
        localObject = new JSONObject(FileUtils.a(localFile2));
        localColorScreenConfig.jdField_a_of_type_Int = (((JSONObject)localObject).optInt("repeatCount", localColorScreenConfig.jdField_a_of_type_Int) - 1);
        localColorScreenConfig.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("eastInTime", localColorScreenConfig.jdField_a_of_type_Long);
        localColorScreenConfig.jdField_b_of_type_Long = ((JSONObject)localObject).optLong("eastOutTime", localColorScreenConfig.jdField_b_of_type_Long);
        localObject = localColorScreenConfig;
        if (!QLog.isColorLevel()) {
          continue;
        }
        long l = IOUtil.getCRC32Value(localFile1);
        QLog.d("ColorScreenManager", 1, "getLocalConfig crc32: " + Long.toHexString(l));
        return localColorScreenConfig;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("ColorScreenManager", 1, "", localJSONException);
        }
      }
    }
  }
  
  public File a()
  {
    File localFile = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), "color_screen");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public File a(int paramInt)
  {
    File localFile = new File(a(), Integer.toString(paramInt));
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public void a(int paramInt)
  {
    String str = "colorScreen.android." + paramInt;
    VasQuickUpdateManager localVasQuickUpdateManager = (VasQuickUpdateManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(183);
    if (localVasQuickUpdateManager != null) {
      localVasQuickUpdateManager.a(22L, str, "ColorScreenManager");
    }
  }
  
  public void a(int paramInt, VasManager.CompleteListener paramCompleteListener)
  {
    ThreadManager.post(new adac(this, paramInt, paramCompleteListener), 5, null, false);
  }
  
  public void a(String paramString)
  {
    VasQuickUpdateEngine.safeDeleteFile(new File(a(), Integer.toString(a(paramString))));
  }
  
  public void a(String paramString, int paramInt)
  {
    int i = a(paramString);
    Object localObject1;
    if (i > 0)
    {
      if (paramInt == 0) {
        break label61;
      }
      localObject1 = "downloadError";
    }
    for (;;)
    {
      Object localObject2 = a(i);
      a(paramString, localObject2);
      if (localObject2 == null) {
        VasMonitorHandler.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "individual_v2_colorscreen_download", String.valueOf(paramInt), (String)localObject1, Integer.toString(i), null, null, 0.0F, 0.0F);
      }
      return;
      label61:
      localObject1 = a(i);
      localObject2 = new File((File)localObject1, "config.zip");
      if (!((File)localObject2).exists())
      {
        localObject1 = "zipFileMissing " + ((File)localObject2).getAbsolutePath();
      }
      else
      {
        localObject1 = ((File)localObject1).getAbsolutePath() + File.separator + "unzip";
        try
        {
          FileUtils.a(((File)localObject2).getAbsolutePath(), (String)localObject1, false);
          localObject1 = null;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localObject1 = "OutOfMemoryError " + ((File)localObject2).getAbsolutePath();
          QLog.e("ColorScreenManager", 1, "failed to unzip " + ((File)localObject2).getAbsolutePath(), localOutOfMemoryError);
        }
        catch (Throwable localThrowable)
        {
          localObject1 = "uncompressFail " + ((File)localObject2).getAbsolutePath();
          QLog.e("ColorScreenManager", 1, "failed to unzip " + ((File)localObject2).getAbsolutePath(), localThrowable);
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    int i = a(paramString);
    if (i > 0) {
      return new File(a(i), "config.zip").exists();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.floatscr.ColorScreenManager
 * JD-Core Version:    0.7.0.1
 */