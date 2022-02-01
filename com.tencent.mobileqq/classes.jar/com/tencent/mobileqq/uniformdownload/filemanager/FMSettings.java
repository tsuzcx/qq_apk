package com.tencent.mobileqq.uniformdownload.filemanager;

import com.tencent.mobileqq.app.AppConstants;

public class FMSettings
{
  public static FMSettings a()
  {
    return FMSettings.FMSettingHolder.a();
  }
  
  public String a()
  {
    return AppConstants.SDCARD_FILE_SAVE_PATH;
  }
  
  public String b()
  {
    return AppConstants.SDCARD_FILE_SAVE_TMP_PATH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.filemanager.FMSettings
 * JD-Core Version:    0.7.0.1
 */