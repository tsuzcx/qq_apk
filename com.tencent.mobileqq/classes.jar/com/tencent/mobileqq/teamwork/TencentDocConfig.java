package com.tencent.mobileqq.teamwork;

import android.text.TextUtils;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoProcessor;
import java.util.HashMap;

public class TencentDocConfig
{
  private static volatile TencentDocConfig b;
  public String a = "doc|.docx|.xls|.xlsx";
  
  public static TencentDocConfig a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new TencentDocConfig();
        }
      }
      finally {}
    }
    return b;
  }
  
  public static HashMap<String, String> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramString = paramString.split("&");
    if ((paramString != null) && (paramString.length > 0))
    {
      int i = 0;
      while (i < paramString.length)
      {
        String[] arrayOfString = paramString[i].split("_");
        if ((arrayOfString != null) && (arrayOfString.length == 2) && (!TextUtils.isEmpty(arrayOfString[0])) && (!TextUtils.isEmpty(arrayOfString[1]))) {
          localHashMap.put(arrayOfString[0], arrayOfString[1]);
        }
        i += 1;
      }
    }
    return localHashMap;
  }
  
  public void b()
  {
    String str = TencentDocImportFileInfoProcessor.a().d();
    if (!TextUtils.isEmpty(str)) {
      this.a = str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TencentDocConfig
 * JD-Core Version:    0.7.0.1
 */