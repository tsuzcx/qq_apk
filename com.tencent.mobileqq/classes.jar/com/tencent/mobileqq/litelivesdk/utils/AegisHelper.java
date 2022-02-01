package com.tencent.mobileqq.litelivesdk.utils;

import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.livesdk.accountengine.UserEngine;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import java.util.HashMap;
import java.util.Map;

public class AegisHelper
{
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, "4");
  }
  
  private static void a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = ((LoginServiceInterface)BizEngineMgr.getInstance().getUserEngine().getService(LoginServiceInterface.class)).getLoginInfo();
    long l;
    if (localObject != null) {
      l = ((LoginInfo)localObject).uid;
    } else {
      l = 0L;
    }
    localObject = new HashMap();
    ((Map)localObject).put("id", "6243");
    ((Map)localObject).put("uin", String.valueOf(l));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sessionId-");
    localStringBuilder.append(System.currentTimeMillis());
    ((Map)localObject).put("sessionId", localStringBuilder.toString());
    if (BusinessManager.a.b() != null) {
      ((Map)localObject).put("version", BusinessManager.a.b().b);
    }
    ((Map)localObject).put("level[0]", paramString3);
    ((Map)localObject).put("from", paramString2);
    ((Map)localObject).put("msg[0]", paramString1);
    ((Map)localObject).put("count", String.valueOf(1));
    paramString1 = new HashMap();
    paramString1.put("Cookie", CookieHelper.a());
    paramString1.put("Referer", "https://now.qq.com");
    ((HttpInterface)BizEngineMgr.getInstance().getLiveEngine().getService(HttpInterface.class)).post("https://aegis.qq.com/collect", paramString1, (Map)localObject, new AegisHelper.1());
  }
  
  public static void b(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, "2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.utils.AegisHelper
 * JD-Core Version:    0.7.0.1
 */