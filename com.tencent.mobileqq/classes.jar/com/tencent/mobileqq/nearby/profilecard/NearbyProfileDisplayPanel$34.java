package com.tencent.mobileqq.nearby.profilecard;

import android.content.Intent;
import atpk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public class NearbyProfileDisplayPanel$34
  implements Runnable
{
  public NearbyProfileDisplayPanel$34(atpk paramatpk) {}
  
  public void run()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("COM_TENCENT_MOBILEQQ_NEARBY_PROFILE_ONRESUME");
    localIntent.setPackage("com.tencent.mobileqq");
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.34
 * JD-Core Version:    0.7.0.1
 */