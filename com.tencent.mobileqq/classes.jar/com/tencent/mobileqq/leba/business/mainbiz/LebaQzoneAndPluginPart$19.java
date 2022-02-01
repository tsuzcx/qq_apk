package com.tencent.mobileqq.leba.business.mainbiz;

import android.os.Bundle;
import com.tencent.mobileqq.nearby.NearbyEnterUpdateObserver;
import com.tencent.qphone.base.util.QLog;

class LebaQzoneAndPluginPart$19
  extends NearbyEnterUpdateObserver
{
  LebaQzoneAndPluginPart$19(LebaQzoneAndPluginPart paramLebaQzoneAndPluginPart) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    QLog.i("LebaBusinessPartImpl", 1, "NearbyEnterUpdateObserver onReceive");
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mainbiz.LebaQzoneAndPluginPart.19
 * JD-Core Version:    0.7.0.1
 */