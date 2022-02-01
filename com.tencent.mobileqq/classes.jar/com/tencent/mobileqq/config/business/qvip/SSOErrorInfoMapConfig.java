package com.tencent.mobileqq.config.business.qvip;

import arlw;
import arlx;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;

public class SSOErrorInfoMapConfig
  implements Serializable
{
  public HashMap<String, arlw> mErrorMap = new HashMap();
  
  public String getErrorInfo(String paramString1, String paramString2)
  {
    if (this.mErrorMap.containsKey(paramString1))
    {
      paramString1 = (arlw)this.mErrorMap.get(paramString1);
      if (paramString1.a.containsKey(paramString2))
      {
        paramString1 = (arlx)paramString1.a.get(paramString2);
        paramString2 = Locale.getDefault().getCountry();
        String str = Locale.getDefault().getLanguage();
        paramString2 = str.toLowerCase() + "_" + paramString2.toLowerCase();
        if (paramString1.a.containsKey(paramString2)) {
          return (String)paramString1.a.get(paramString2);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.SSOErrorInfoMapConfig
 * JD-Core Version:    0.7.0.1
 */