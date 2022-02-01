package com.tencent.mobileqq.vip;

import android.text.TextUtils;
import com.tencent.util.QQDeviceInfo;
import dualsim.common.IPhoneInfoBridge;

class KCWraperV2$1$2
  implements IPhoneInfoBridge
{
  KCWraperV2$1$2(KCWraperV2.1 param1) {}
  
  public String a(String paramString)
  {
    if ("imei".equals(paramString)) {
      return QQDeviceInfo.getIMEI("a4bd32");
    }
    if ("imsi".equals(paramString)) {
      return QQDeviceInfo.getIMSI("a4bd32");
    }
    return "";
  }
  
  public boolean isAllow(String paramString)
  {
    return !TextUtils.isEmpty(a(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.KCWraperV2.1.2
 * JD-Core Version:    0.7.0.1
 */