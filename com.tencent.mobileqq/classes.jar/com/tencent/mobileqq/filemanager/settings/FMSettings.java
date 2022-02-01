package com.tencent.mobileqq.filemanager.settings;

import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.qroute.QRoute;

public class FMSettings
{
  public static IFMSettings a()
  {
    return (IFMSettings)QRoute.api(IFMSettings.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.FMSettings
 * JD-Core Version:    0.7.0.1
 */