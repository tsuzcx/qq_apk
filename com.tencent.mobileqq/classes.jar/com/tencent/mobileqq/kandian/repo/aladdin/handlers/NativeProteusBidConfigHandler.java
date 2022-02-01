package com.tencent.mobileqq.kandian.repo.aladdin.handlers;

import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.AladdinParseUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJProteusCDNSp;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJProteusOfflineBidSp;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class NativeProteusBidConfigHandler
  extends SimpleConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onReceiveConfig] ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("NativeProteusBidConfigHandler", 1, ((StringBuilder)localObject).toString());
    Map localMap = AladdinParseUtils.a(paramString);
    Iterator localIterator = localMap.keySet().iterator();
    localObject = "";
    paramString = "";
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      String str1 = (String)localMap.get(str2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onReceiveConfig] key=");
      localStringBuilder.append(str2);
      localStringBuilder.append(", value=");
      localStringBuilder.append(str1);
      QLog.d("NativeProteusBidConfigHandler", 2, localStringBuilder.toString());
      if (TextUtils.equals(str2, "native_article"))
      {
        RIJProteusOfflineBidSp.a("native_proteus_offline_bid", str1);
        localObject = str1;
      }
      else if (TextUtils.equals(str2, "native_article_cdn_url"))
      {
        paramString = str1;
      }
    }
    RIJProteusCDNSp.a((String)localObject, paramString);
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    RIJProteusOfflineBidSp.a("native_proteus_offline_bid", "0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.handlers.NativeProteusBidConfigHandler
 * JD-Core Version:    0.7.0.1
 */