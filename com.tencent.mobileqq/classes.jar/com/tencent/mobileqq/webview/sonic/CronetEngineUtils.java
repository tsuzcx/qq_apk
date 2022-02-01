package com.tencent.mobileqq.webview.sonic;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.UrlRequest;
import com.tencent.smtt.export.external.interfaces.UrlRequest.Builder;
import com.tencent.smtt.export.external.interfaces.UrlRequest.Callback;
import com.tencent.smtt.sdk.UrlRequestBuilderImpl;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CronetEngineUtils
{
  private static final String TAG = "SonicSdkImpl_CronetEngineUtils";
  private static volatile CronetEngineUtils sInstance;
  Executor executor = Executors.newSingleThreadExecutor();
  
  public static CronetEngineUtils getsInstance()
  {
    if (sInstance == null) {
      sInstance = new CronetEngineUtils();
    }
    return sInstance;
  }
  
  public boolean startWithURL(String paramString, UrlRequest.Callback paramCallback, HashMap<String, String> paramHashMap)
  {
    try
    {
      paramString = new UrlRequestBuilderImpl(paramString, paramCallback, this.executor);
      if ((paramHashMap != null) && (!paramHashMap.isEmpty()))
      {
        paramCallback = paramHashMap.entrySet().iterator();
        while (paramCallback.hasNext())
        {
          paramHashMap = (Map.Entry)paramCallback.next();
          String str1 = (String)paramHashMap.getKey();
          String str2 = (String)paramHashMap.getValue();
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
          {
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("set Quic header, key: ");
              localStringBuilder.append(str1);
              localStringBuilder.append(", value: ");
              localStringBuilder.append(str2);
              QLog.d("SonicSdkImpl_CronetEngineUtils", 1, localStringBuilder.toString());
            }
            paramString.addHeader((String)paramHashMap.getKey(), (String)paramHashMap.getValue());
          }
        }
      }
      paramString = paramString.build();
      if (paramString != null)
      {
        paramString.start();
        return true;
      }
      QLog.e("SonicSdkImpl_CronetEngineUtils", 1, "builderWrapper.build() is null!");
    }
    catch (Throwable paramString)
    {
      QLog.e("SonicSdkImpl_CronetEngineUtils", 1, "startWithURL encount exception!", paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.sonic.CronetEngineUtils
 * JD-Core Version:    0.7.0.1
 */