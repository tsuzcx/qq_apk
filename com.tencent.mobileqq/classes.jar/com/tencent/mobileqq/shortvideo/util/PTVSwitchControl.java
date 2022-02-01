package com.tencent.mobileqq.shortvideo.util;

import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.constants.CameraCompatibleConstants;
import com.tencent.mobileqq.qroute.QRoute;

public class PTVSwitchControl
{
  public static boolean a = false;
  
  static
  {
    if (((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProductManufacturer(CameraCompatibleConstants.B)) {
      a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.PTVSwitchControl
 * JD-Core Version:    0.7.0.1
 */