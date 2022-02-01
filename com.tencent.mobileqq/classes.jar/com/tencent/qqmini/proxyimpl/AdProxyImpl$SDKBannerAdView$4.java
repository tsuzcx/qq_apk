package com.tencent.qqmini.proxyimpl;

import android.text.TextUtils;
import bkwb;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.qqmini.sdk.launcher.core.model.MiniAdPosInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.IGetAdPosInfo;

public class AdProxyImpl$SDKBannerAdView$4
  implements Runnable
{
  public AdProxyImpl$SDKBannerAdView$4(bkwb parambkwb, String paramString) {}
  
  public void run()
  {
    String str1 = this.jdField_a_of_type_JavaLangString;
    Object localObject = str1;
    if (this.jdField_a_of_type_Bkwb.a != null)
    {
      localObject = this.jdField_a_of_type_Bkwb.a.getPosInfo();
      String str2 = bkwb.a(this.jdField_a_of_type_Bkwb, (MiniAdPosInfo)localObject);
      localObject = str1;
      if (!TextUtils.isEmpty(str2)) {
        localObject = str1 + "&" + str2;
      }
    }
    GameActivity.reportAdByHttp((String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKBannerAdView.4
 * JD-Core Version:    0.7.0.1
 */