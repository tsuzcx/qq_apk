package com.tencent.mobileqq.mybusiness;

import MyCarrier.Carrier;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class MyBusinessObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean, Carrier paramCarrier, int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder().append("----->onCarrierQuery success = ").append(paramBoolean).append(", carrier = ");
      if (paramCarrier == null) {
        break label63;
      }
    }
    label63:
    for (paramCarrier = paramCarrier.toString();; paramCarrier = "null")
    {
      QLog.d("MyBusinessManager", 4, paramCarrier + ", refreshTime = " + paramInt);
      return;
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 1) {
      a(paramBoolean, (Carrier)paramBundle.getSerializable("result"), paramBundle.getInt("refreshTime"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.mybusiness.MyBusinessObserver
 * JD-Core Version:    0.7.0.1
 */