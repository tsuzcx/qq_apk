package com.tencent.mobileqq.config.business.qvip;

import androidx.annotation.Keep;
import java.io.Serializable;

@Keep
public class QVipGiftConfig
  implements Serializable
{
  private boolean enable;
  public String troopAioUrl = "https://h5.qzone.qq.com/v2/vip/qun-gift/aio-dialog?_wv=16781315&_wwv=13&themeMode={themeMode}&uin={uin}&troopUin={troopUin}";
  public String troopGiftUrl = "https://qun.qq.com/qunpay/gifts/index.html?troopUin=<$GC>&uin=<$UIN>&name=<$NICK>&from=<$FROM>&_wv=1031&_bid=2204&_wvSb=1&_nav_alpha=0";
  
  public boolean isEnable()
  {
    return this.enable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QVipGiftConfig
 * JD-Core Version:    0.7.0.1
 */