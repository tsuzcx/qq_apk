package com.tencent.mobileqq.vas.config.business.qvip;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;

public class SSOErrorInfoMapConfig
  implements Serializable
{
  public HashMap<String, SSOErrorInfoMapConfig.ErrorInfoMap> mErrorMap = new HashMap();
  
  public String getErrorInfo(String paramString1, String paramString2)
  {
    if (this.mErrorMap.containsKey(paramString1))
    {
      paramString1 = (SSOErrorInfoMapConfig.ErrorInfoMap)this.mErrorMap.get(paramString1);
      if (paramString1.a.containsKey(paramString2))
      {
        paramString1 = (SSOErrorInfoMapConfig.LocaleInfoMap)paramString1.a.get(paramString2);
        paramString2 = Locale.getDefault().getCountry();
        String str = Locale.getDefault().getLanguage();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str.toLowerCase());
        localStringBuilder.append("_");
        localStringBuilder.append(paramString2.toLowerCase());
        paramString2 = localStringBuilder.toString();
        if (paramString1.a.containsKey(paramString2)) {
          return (String)paramString1.a.get(paramString2);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.SSOErrorInfoMapConfig
 * JD-Core Version:    0.7.0.1
 */