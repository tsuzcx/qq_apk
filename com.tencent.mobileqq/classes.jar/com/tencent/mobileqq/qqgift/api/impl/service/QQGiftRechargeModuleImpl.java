package com.tencent.mobileqq.qqgift.api.impl.service;

import android.text.TextUtils;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftRechargeModule;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftRechargeModule.RechargeSource;
import com.tencent.mobileqq.qqgift.callback.IQQGiftRechargeCallback;
import com.tencent.mobileqq.qqgift.config.QQGiftConfig;
import com.tencent.mobileqq.qqgift.config.QQGiftRechargeConfig;
import com.tencent.mobileqq.qqgift.sdk.config.QQGiftSDKConfig;
import com.tencent.mobileqq.qqgift.webview.QQGiftHalfTranslucentBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class QQGiftRechargeModuleImpl
  implements IQQGiftRechargeModule
{
  private IQQGiftSDK a;
  private ConcurrentHashMap<Integer, IQQGiftRechargeCallback> b = new ConcurrentHashMap();
  private String c;
  
  private String a(String paramString)
  {
    try
    {
      localObject = URLEncoder.encode(paramString, "UTF-8");
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      label9:
      break label9;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("encode url param: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" failed.");
    QLog.e("QQGiftRechargeModuleImpl", 1, ((StringBuilder)localObject).toString());
    return "";
  }
  
  private static String a(String paramString1, String paramString2)
  {
    Object localObject = paramString1;
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject = paramString1;
      if (!TextUtils.isEmpty(paramString2))
      {
        if (paramString1.contains("?"))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append("&");
          ((StringBuilder)localObject).append(paramString2);
          return ((StringBuilder)localObject).toString();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append("?");
        ((StringBuilder)localObject).append(paramString2);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  private String a(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramMap == null) {
      return localStringBuilder.toString();
    }
    paramMap = paramMap.entrySet();
    int i = 0;
    int k = paramMap.size();
    paramMap = paramMap.iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      localStringBuilder.append(str);
      localStringBuilder.append("=");
      localStringBuilder.append(a((String)localObject));
      int j = i + 1;
      i = j;
      if (j < k)
      {
        localStringBuilder.append("&");
        i = j;
      }
    }
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    this.c = "";
  }
  
  public void a(@IQQGiftRechargeModule.RechargeSource int paramInt, IQQGiftRechargeCallback paramIQQGiftRechargeCallback)
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (!((IQQGiftSDK)localObject1).k()))
    {
      int i = paramIQQGiftRechargeCallback.hashCode();
      Object localObject2 = QQGiftConfig.a().rechargeUrl.replace("{qq_gift_app_id}", String.valueOf(this.a.c().a)).replace("{source}", String.valueOf(paramInt));
      localObject1 = localObject2;
      if (paramIQQGiftRechargeCallback != null) {
        localObject1 = a((String)localObject2, a(paramIQQGiftRechargeCallback.a()));
      }
      localObject1 = a((String)localObject1, c());
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onRecharge url:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("QQGiftRechargeModuleImpl", 2, ((StringBuilder)localObject2).toString());
      }
      QQGiftHalfTranslucentBrowserActivity.a(this.a.b().getApplicationContext(), (String)localObject1, i, this.a.c().a);
      localObject1 = this.b;
      if (localObject1 != null) {
        ((ConcurrentHashMap)localObject1).put(Integer.valueOf(i), paramIQQGiftRechargeCallback);
      }
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onRecharge sdk state error! sdk:");
      ((StringBuilder)localObject1).append(this.a);
      QLog.e("QQGiftRechargeModuleImpl", 1, ((StringBuilder)localObject1).toString());
      paramIQQGiftRechargeCallback.a(false, 99998, "sdk状态异常!");
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2, String paramString)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = (IQQGiftRechargeCallback)((ConcurrentHashMap)localObject).remove(Integer.valueOf(paramInt1));
      if (localObject != null) {
        ((IQQGiftRechargeCallback)localObject).a(paramBoolean, paramInt2, paramString);
      }
    }
  }
  
  public void a(IQQGiftSDK paramIQQGiftSDK)
  {
    this.a = paramIQQGiftSDK;
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap != null) {
      this.c = a(paramHashMap);
    }
  }
  
  public void b()
  {
    ConcurrentHashMap localConcurrentHashMap = this.b;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.clear();
    }
  }
  
  public String c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.api.impl.service.QQGiftRechargeModuleImpl
 * JD-Core Version:    0.7.0.1
 */