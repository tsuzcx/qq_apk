package com.tencent.mobileqq.wifi;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.wifisdk.TMSDKCustomConfig.IToast;

final class FreeWifiHelper$9
  implements TMSDKCustomConfig.IToast
{
  public void showToast(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      QQToast.makeText(paramContext, paramCharSequence, paramInt).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wifi.FreeWifiHelper.9
 * JD-Core Version:    0.7.0.1
 */