package com.tencent.mobileqq.kandian.repo.aladdin.sp;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.qphone.base.util.QLog;

public class RIJProteusCDNSp
{
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_key_readinjoy_cdn_url_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[updateCDNUrl], bid = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", cdn url = ");
    localStringBuilder.append(paramString2);
    QLog.i("RIJProteusCDNSp", 1, localStringBuilder.toString());
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      RIJSPUtils.a(a(paramString1), paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJProteusCDNSp
 * JD-Core Version:    0.7.0.1
 */