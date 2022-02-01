package com.tencent.mobileqq.filemanager.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.settings.FMSettingInterface.MoveFileCallback;
import com.tencent.mobileqq.filemanager.settings.QQFMSettings;
import java.util.List;

public class FMSettingsImpl
  implements IFMSettings
{
  private QQFMSettings fmSettings = new QQFMSettings();
  
  public void free()
  {
    this.fmSettings.b();
  }
  
  public long getDefalutStorgeFreeSpace()
  {
    return this.fmSettings.a();
  }
  
  public String getDefaultRecvPath()
  {
    return this.fmSettings.b();
  }
  
  public String getDefaultThumbPath()
  {
    return this.fmSettings.d();
  }
  
  public String getDefaultTmpPath()
  {
    return this.fmSettings.c();
  }
  
  public String getOtherRecvPath()
  {
    return this.fmSettings.a();
  }
  
  public void justDoIt(long paramLong, List<String> paramList, Activity paramActivity, FMSettingInterface.MoveFileCallback paramMoveFileCallback)
  {
    this.fmSettings.a(paramLong, paramList, paramActivity, paramMoveFileCallback);
  }
  
  public void refreshInfos()
  {
    this.fmSettings.a();
  }
  
  public void remove(String paramString)
  {
    this.fmSettings.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.FMSettingsImpl
 * JD-Core Version:    0.7.0.1
 */