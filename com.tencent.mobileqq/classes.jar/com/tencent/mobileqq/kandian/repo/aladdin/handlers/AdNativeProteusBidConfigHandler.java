package com.tencent.mobileqq.kandian.repo.aladdin.handlers;

import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.AladdinParseUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJProteusOfflineBidSp;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AdNativeProteusBidConfigHandler
  extends SimpleConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onReceiveConfig] ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("AdNativeProteusBidConfigHandler", 1, ((StringBuilder)localObject).toString());
    paramString = AladdinParseUtils.a(paramString);
    localObject = paramString.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = (String)paramString.get(str1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onReceiveConfig] key=");
      localStringBuilder.append(str1);
      localStringBuilder.append(", value=");
      localStringBuilder.append(str2);
      QLog.d("AdNativeProteusBidConfigHandler", 2, localStringBuilder.toString());
      if (TextUtils.equals(str1, "commercialAdDetails_feeds")) {
        RIJProteusOfflineBidSp.a("ad_native_proteus_offline_bid", str2);
      }
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    RIJProteusOfflineBidSp.a("ad_native_proteus_offline_bid", "0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.handlers.AdNativeProteusBidConfigHandler
 * JD-Core Version:    0.7.0.1
 */