package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

class NearbyProfileDisplayPanel$39
  implements Runnable
{
  NearbyProfileDisplayPanel$39(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("COM_TENCENT_MOBILEQQ_NEARBY_PROFILE_ONPAUSE");
    localIntent.setPackage("com.tencent.mobileqq");
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.39
 * JD-Core Version:    0.7.0.1
 */