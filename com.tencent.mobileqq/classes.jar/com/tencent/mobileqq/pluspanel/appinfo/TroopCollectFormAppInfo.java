package com.tencent.mobileqq.pluspanel.appinfo;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelViewModel;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

public class TroopCollectFormAppInfo
  extends PlusPanelAppInfo
{
  @NotNull
  private HashMap<String, String> a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = paramString1.substring(paramString1.indexOf("?") + 1);
    localHashMap = new HashMap();
    try
    {
      String[] arrayOfString = paramString1.split("&");
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        paramString1 = arrayOfString[i].split("=");
        if (paramString1.length == 2)
        {
          Object localObject = paramString1[0];
          String str = URLDecoder.decode(paramString1[1]);
          if (!localObject.contains("extraData"))
          {
            paramString1 = str;
            if (!localObject.contains("path")) {}
          }
          else
          {
            paramString1 = new StringBuilder();
            paramString1.append("groupid=");
            paramString1.append(paramString2);
            paramString1.append("&groupname=");
            paramString1.append(paramString3);
            paramString1.append("&uinType=");
            paramString1.append(this.uinType);
            paramString1 = str.replace("$GCODE$", paramString1.toString());
          }
          localHashMap.put(localObject, paramString1);
        }
        i += 1;
      }
      return localHashMap;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("troopFormLog openTroopFormMiniAppInTroopAIO, ");
      paramString2.append(com.tencent.qphone.base.util.QLog.getStackTraceString(paramString1));
      com.tencent.qphone.base.util.QLog.e("TroopCollectFormAppInfo", 1, paramString2.toString());
    }
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("troopFormLog openTroopFormMiniAppInTroopAIO:url :");
    localStringBuilder.append(paramString1);
    com.tencent.TMG.utils.QLog.i("TroopCollectFormAppInfo", 1, localStringBuilder.toString());
    if (paramString1.startsWith("mqqapi://microapp/open?"))
    {
      paramString1 = a(paramString1, paramString2, paramString3);
      if (!TextUtils.isEmpty((CharSequence)paramString1.get("appid"))) {
        a(paramContext, paramString1);
      }
    }
    else
    {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramContext, paramString1, 2016, null);
    }
  }
  
  private void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    Object localObject4 = "";
    String str1 = (String)paramHashMap.get("appid");
    Object localObject1 = (String)paramHashMap.get("path");
    String str2 = (String)paramHashMap.get("extraData");
    Object localObject6 = (String)paramHashMap.get("envVersion");
    Object localObject5;
    try
    {
      boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
      if (!bool) {
        localObject1 = URLDecoder.decode(((String)localObject1).replaceAll("%(?![0-9a-fA-F]{2})", "%25").replaceAll("\\+", "%2B"), "UTF-8");
      } else {
        localObject1 = "";
      }
      Object localObject2 = localObject4;
      localObject5 = localObject4;
      try
      {
        if (!TextUtils.isEmpty(str2))
        {
          localObject5 = localObject4;
          localObject2 = URLDecoder.decode(str2, "UTF-8");
        }
        localObject4 = localObject6;
        localObject5 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject6))
        {
          localObject5 = localObject2;
          localObject4 = URLDecoder.decode((String)localObject6, "UTF-8");
        }
        localObject6 = localObject4;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        localObject4 = localObject1;
        localObject1 = localObject5;
      }
      localObject5 = new StringBuilder();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException2)
    {
      localObject1 = "";
    }
    ((StringBuilder)localObject5).append("troopFormLog openTroopFormMiniAppInTroopAIO, ");
    ((StringBuilder)localObject5).append(com.tencent.qphone.base.util.QLog.getStackTraceString(localUnsupportedEncodingException2));
    com.tencent.qphone.base.util.QLog.e("TroopCollectFormAppInfo", 1, ((StringBuilder)localObject5).toString());
    Object localObject3 = localObject1;
    localObject1 = localObject4;
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("troopFormLog openTroopFormMiniAppInTroopAIO:argumentMap :");
    ((StringBuilder)localObject4).append(paramHashMap.toString());
    com.tencent.TMG.utils.QLog.i("TroopCollectFormAppInfo", 1, ((StringBuilder)localObject4).toString());
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMiniAppById(paramContext, str1, (String)localObject1, localObject3, (String)localObject6, "", 2016, null);
  }
  
  public int defaultDrawableID()
  {
    return 2130845615;
  }
  
  public int getAppID()
  {
    if (isC2C()) {
      return 0;
    }
    return 1108961705;
  }
  
  public int getRedDotID()
  {
    if (isC2C()) {
      return 0;
    }
    return getAppID();
  }
  
  public String getTitle()
  {
    return BaseApplicationImpl.getContext().getString(2131887766);
  }
  
  public void onPlusPanelAppClick(PlusPanelViewModel paramPlusPanelViewModel, BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if (TextUtils.isEmpty(this.url)) {
      return;
    }
    a(paramBaseChatPie.aX(), this.url, paramSessionInfo.c, paramSessionInfo.e);
    ReportController.b(paramBaseChatPie.d, "dc00898", "", paramSessionInfo.b, "0X8009FCD", "0X8009FCD", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.appinfo.TroopCollectFormAppInfo
 * JD-Core Version:    0.7.0.1
 */