package com.tencent.mobileqq.vas.config.business.qvip;

import androidx.annotation.Keep;
import java.io.Serializable;

@Deprecated
@Keep
public class QVipFeatureSwitchConfig
  implements Serializable
{
  private boolean troopNickEnable = true;
  
  public boolean isTroopNickEnable()
  {
    return this.troopNickEnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipFeatureSwitchConfig
 * JD-Core Version:    0.7.0.1
 */