package com.tencent.mobileqq.vas.util;

import MQQ.LhLogoResources;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;

final class PrettyAccountUtil$1
  implements Runnable
{
  public void run()
  {
    try
    {
      Iterator localIterator = PrettyAccountUtil.e().keySet().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        LhLogoResources localLhLogoResources = (LhLogoResources)PrettyAccountUtil.e().get(localInteger);
        if (localLhLogoResources == null) {
          return;
        }
        SharedPreferences.Editor localEditor = MobileQQ.getContext().getSharedPreferences("pretty_account_info", 0).edit();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("apngUrl");
        localStringBuilder.append(localInteger);
        localEditor = localEditor.putString(localStringBuilder.toString(), localLhLogoResources.apngUrl);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("backUrl");
        localStringBuilder.append(localInteger);
        localEditor = localEditor.putString(localStringBuilder.toString(), localLhLogoResources.backUrl);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("logoUrl");
        localStringBuilder.append(localInteger);
        localEditor = localEditor.putString(localStringBuilder.toString(), localLhLogoResources.logoUrl);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("normalColor");
        localStringBuilder.append(localInteger);
        localEditor = localEditor.putString(localStringBuilder.toString(), localLhLogoResources.normalColor);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("lightColor");
        localStringBuilder.append(localInteger);
        localEditor.putString(localStringBuilder.toString(), localLhLogoResources.lightColor).apply();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("PrettyAccountUtil", 1, "pretty_account update error:", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.util.PrettyAccountUtil.1
 * JD-Core Version:    0.7.0.1
 */