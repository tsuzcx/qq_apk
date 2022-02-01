package com.tencent.mobileqq.vas.config.business.qvip;

import androidx.annotation.Keep;
import java.io.Serializable;

@Keep
public class QVipTroopNickConfig
  implements Serializable
{
  private int enable = 1;
  
  public boolean isEnable()
  {
    return this.enable == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipTroopNickConfig
 * JD-Core Version:    0.7.0.1
 */