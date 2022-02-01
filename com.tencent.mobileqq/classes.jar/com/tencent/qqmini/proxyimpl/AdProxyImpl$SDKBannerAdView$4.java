package com.tencent.qqmini.proxyimpl;

import android.text.TextUtils;
import bkmy;
import com.tencent.qqmini.sdk.launcher.core.model.MiniAdPosInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.IGetAdPosInfo;

public class AdProxyImpl$SDKBannerAdView$4
  implements Runnable
{
  public AdProxyImpl$SDKBannerAdView$4(bkmy parambkmy, String paramString) {}
  
  public void run()
  {
    String str1 = this.jdField_a_of_type_JavaLangString;
    Object localObject = str1;
    if (this.jdField_a_of_type_Bkmy.a != null)
    {
      localObject = this.jdField_a_of_type_Bkmy.a.getPosInfo();
      String str2 = bkmy.a(this.jdField_a_of_type_Bkmy, (MiniAdPosInfo)localObject);
      localObject = str1;
      if (!TextUtils.isEmpty(str2)) {
        localObject = str1 + "&" + str2;
      }
    }
    AdProxyImpl.a((String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.SDKBannerAdView.4
 * JD-Core Version:    0.7.0.1
 */