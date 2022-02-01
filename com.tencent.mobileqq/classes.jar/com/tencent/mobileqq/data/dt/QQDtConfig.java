package com.tencent.mobileqq.data.dt;

import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ProcessUtil;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class QQDtConfig
  implements IDTParamProvider
{
  public static List<TunnelInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new TunnelInfo("LOGDEBUGKEY00001"));
    localArrayList.add(new TunnelInfo("00000R3FEU3ZKLWJ"));
    localArrayList.add(new TunnelInfo("0P000B1E6X38P6V3"));
    localArrayList.add(new TunnelInfo("0AND0NYZC34FOQCF"));
    localArrayList.add(new TunnelInfo("00000QG6YX3X0LZH"));
    return localArrayList;
  }
  
  private static void a(Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      String str = ProcessUtil.a();
      int i = AppSetting.a();
      paramMap.put("client_page_name", str);
      paramMap.put("client_process_name", BaseApplicationImpl.processName);
      paramMap.put("qq_appid", String.valueOf(i));
    }
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
    return null;
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
    Object localObject1 = null;
    Object localObject2 = BaseApplicationImpl.getApplication();
    if (localObject2 != null) {
      localObject1 = ((BaseApplicationImpl)localObject2).peekAppRuntime();
    }
    if (localObject1 == null) {
      localObject1 = "0";
    }
    do
    {
      return localObject1;
      localObject2 = ((AppRuntime)localObject1).getAccount();
      localObject1 = localObject2;
    } while (localObject2 != null);
    return "0";
  }
  
  public String getQQOpenID()
  {
    return null;
  }
  
  public String getSIMType()
  {
    int j = -1;
    Object localObject = BaseApplicationImpl.getApplication();
    int i = j;
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).peekAppRuntime();
      i = j;
      if (localObject != null) {
        i = CUKingCardHelper.a(((AppRuntime)localObject).getAccount());
      }
    }
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
  
  public void setNonRealtimePublicDynamicParams(Map<String, Object> paramMap)
  {
    a(paramMap);
  }
  
  public void setRealtimePublicDynamicParams(Map<String, Object> paramMap)
  {
    a(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.dt.QQDtConfig
 * JD-Core Version:    0.7.0.1
 */