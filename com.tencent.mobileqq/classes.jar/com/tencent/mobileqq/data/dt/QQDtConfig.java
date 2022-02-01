package com.tencent.mobileqq.data.dt;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ProcessUtil;
import com.tencent.mobileqq.vip.CUKingCardUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public class QQDtConfig
  implements IDTParamProvider
{
  private static QQDtConfig c;
  private String a;
  private final CopyOnWriteArraySet<QQDtConfig.IDTCustomPublicParamsListener> b = new CopyOnWriteArraySet();
  
  public static QQDtConfig a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new QQDtConfig();
        }
      }
      finally {}
    }
    return c;
  }
  
  private static void a(Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      String str = ProcessUtil.a();
      int i = AppSetting.d();
      paramMap.put("client_page_name", str);
      paramMap.put("client_process_name", BaseApplicationImpl.processName);
      paramMap.put("qq_appid", String.valueOf(i));
    }
  }
  
  private void b(Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((QQDtConfig.IDTCustomPublicParamsListener)localIterator.next()).a(paramMap);
      }
    }
  }
  
  public void a(@NotNull QQDtConfig.IDTCustomPublicParamsListener paramIDTCustomPublicParamsListener)
  {
    this.b.add(paramIDTCustomPublicParamsListener);
  }
  
  public void b(@NotNull QQDtConfig.IDTCustomPublicParamsListener paramIDTCustomPublicParamsListener)
  {
    this.b.remove(paramIDTCustomPublicParamsListener);
  }
  
  public String getAccountID()
  {
    return null;
  }
  
  public String getActiveInfo()
  {
    return null;
  }
  
  public String getAdCode()
  {
    return null;
  }
  
  public String getCallFrom()
  {
    return null;
  }
  
  public String getCallScheme()
  {
    return null;
  }
  
  public String getFactoryChannelId()
  {
    return null;
  }
  
  public String getGuid()
  {
    if (TextUtils.isEmpty(this.a)) {
      this.a = BaseApplication.getContext().getSharedPreferences("sp_msf_common", 4).getString("msf_guid", "");
    }
    return this.a;
  }
  
  public String getMainLogin()
  {
    return null;
  }
  
  public String getModifyChannelId()
  {
    return null;
  }
  
  public String getOaid()
  {
    return null;
  }
  
  public String getOmgbzid()
  {
    return null;
  }
  
  public String getQQ()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null) {
      localObject = ((BaseApplicationImpl)localObject).peekAppRuntime();
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return "0";
    }
    String str = ((AppRuntime)localObject).getAccount();
    localObject = str;
    if (str == null) {
      localObject = "0";
    }
    return localObject;
  }
  
  public String getQQOpenID()
  {
    return null;
  }
  
  public String getSIMType()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).peekAppRuntime();
      if (localObject != null)
      {
        i = CUKingCardUtils.a(((AppRuntime)localObject).getAccount());
        break label30;
      }
    }
    int i = -1;
    label30:
    if (i == 1) {
      return "1";
    }
    return "3";
  }
  
  public int getStartType()
  {
    return 0;
  }
  
  public String getTid()
  {
    return null;
  }
  
  public String getWbOpenID()
  {
    return null;
  }
  
  public String getWxOpenID()
  {
    return null;
  }
  
  public String getWxUnionID()
  {
    return null;
  }
  
  public void setEventDynamicParams(String paramString, Map<String, Object> paramMap) {}
  
  public void setNonRealtimePublicDynamicParams(Map<String, Object> paramMap) {}
  
  public void setRealtimePublicDynamicParams(Map<String, Object> paramMap)
  {
    a(paramMap);
    b(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.dt.QQDtConfig
 * JD-Core Version:    0.7.0.1
 */