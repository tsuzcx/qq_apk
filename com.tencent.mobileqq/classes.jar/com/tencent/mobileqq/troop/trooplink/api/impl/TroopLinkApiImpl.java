package com.tencent.mobileqq.troop.trooplink.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi.LinkParams;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class TroopLinkApiImpl
  implements ITroopLinkApi
{
  public static final String CONFIG_FILE_NAME = "troop_link_config.json";
  public static final String TAG = ".troop.trooplink";
  public static final HashMap<String, String> urlMaps = new HashMap();
  protected boolean isUpdateServer = false;
  protected Object mLock = new Object();
  
  static
  {
    urlMaps.put("troop_create", "https://admin.qun.qq.com/mcreatev3/info.html?_bid=206&_wv=2097155&cateid=<$CATEID>&subid=<$SUBID>&_nativeFrom=<$FROM>");
    urlMaps.put("troop_create_for_school", "https://admin.qun.qq.com/mcreatev4/classinfo?");
    urlMaps.put("troop_create_for_game", "https://admin.qun.qq.com/mcreatev3/info.html?_bid=206&_wv=2097155&cateid=<$CATEID>&subid=<$SUBID>&_nativeFrom=<$FROM>");
    urlMaps.put("troop_rank", "https://qun.qq.com/qqweb/m/qun/rank/rank.html?gc=<$GC>&uin=<$UIN>&from=<$FROM>&_wv=1031&_bid=2468");
    urlMaps.put("troop_level", "https://qinfo.clt.qq.com/qlevel/level.html?gc=<$GC>&type=<$TYPE>");
    urlMaps.put("troop_unique_title", "https://qun.qq.com/qqweb/m/qun/medal/index.html?_wv=16777223&_bid=2504&gc=<$GC>&uin=<$UIN>&from=<$FROM>");
    urlMaps.put("troop_create_notice", "https://web.qun.qq.com/mannounce/edit.html?_bid=148&_wv=1031&gc=<$GC>&title=<$TITLE>&content=<$CONTENT>&from=<$FROM>&school=1");
    urlMaps.put("troop_create_homework", "https://qun.qq.com/homework/features/sethomework.html?_wv=5123&_bid=2146#role=teacher&gid=<$GC>&content=<$CONTENT>&type=word&from=<$FROM>");
    urlMaps.put("troop_list_homework", "https://qun.qq.com/homework/features/v2/index.html?_wv=1027&_bid=3089&gc=<$GC>&from=<$FROM>");
    urlMaps.put("troop_homework_create_notice", "https://web.qun.qq.com/mannounce/schooledit.html?_bid=148&_wv=1031&from=<$FROM>&content=<$CONTENT>&gc=<$GC>");
    urlMaps.put("troop_bind_game", "https://imgcache.qq.com/gc/gamecenterV2/dist/index/qqbindGroup/index.html?_wvx=10&_wvxBclr=0xffffff&_wv=1027");
    urlMaps.put("troop_honor_page", "https://qun.qq.com/interactive/qunhonor?gc=<$GC>&_wv=3&&_wwv=128");
    urlMaps.put("troop_member_honor_page", "https://qun.qq.com/interactive/userhonor?uin=<$UIN>&gc=<$GC>&_wv=3&&_wwv=128");
    urlMaps.put("troop_honor_setting", "https://qinfo.clt.qq.com/qlevel/setting.html?_wv=4&_bid=125#gc=<$GC>&type=102&grayscale=<$GRAY>");
  }
  
  public TroopLinkApiImpl()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MobileQQ.sMobileQQ.getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("troop_link_config.json");
    ThreadManager.post(new TroopLinkApiImpl.1(this, localStringBuilder.toString()), 5, null, false);
  }
  
  private String getUrl(String paramString, ITroopLinkApi.LinkParams paramLinkParams)
  {
    String str = getUrl(paramString);
    paramString = str;
    if (!TextUtils.isEmpty(str))
    {
      paramString = str;
      if (paramLinkParams != null) {
        paramString = replaceParams(str, paramLinkParams);
      }
    }
    return paramString;
  }
  
  private String replace(String paramString, Bundle paramBundle)
  {
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramString = paramString.replace(str, (String)paramBundle.get(str));
    }
    return paramString;
  }
  
  public String getSmartManagerUrl(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return paramString1.replace("$GCODE$", paramString2).replace("$ROBOTUIN$", String.valueOf(paramLong1)).replace("$RPID$", String.valueOf(paramLong2));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getSmartManagerUrl, url: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", troopUin: ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", robotUin: ");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(", id: ");
    localStringBuilder.append(paramLong2);
    QLog.d("TroopManage", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    return "";
  }
  
  public String getTroopHonorSettingUrl(String paramString, boolean paramBoolean)
  {
    Object localObject = ITroopLinkApi.LinkParams.a().a(paramString);
    if (paramBoolean) {
      paramString = "1";
    } else {
      paramString = "0";
    }
    localObject = getUrl("troop_honor_setting", ((ITroopLinkApi.LinkParams)localObject).f(paramString));
    paramString = (String)localObject;
    if (SimpleUIUtil.a())
    {
      int i = SimpleUIUtil.d();
      if (i != 0)
      {
        paramString = String.format("%08x", new Object[] { Integer.valueOf(i) }).substring(2);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("&mode_color=");
        localStringBuilder.append(paramString);
        paramString = localStringBuilder.toString();
      }
      else
      {
        paramString = "&mode_color=000000";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
    }
    return paramString;
  }
  
  public String getTroopHonorUrl(String paramString, int paramInt)
  {
    Object localObject = getUrl("troop_honor_page", ITroopLinkApi.LinkParams.a().a(paramString));
    paramString = (String)localObject;
    if (SimpleUIUtil.a())
    {
      int i = SimpleUIUtil.d();
      if (i != 0)
      {
        paramString = String.format("%08x", new Object[] { Integer.valueOf(i) }).substring(2);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("&mode_color=");
        localStringBuilder.append(paramString);
        paramString = localStringBuilder.toString();
      }
      else
      {
        paramString = "&mode_color=000000";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("&dragon_gray");
    ((StringBuilder)localObject).append(paramInt);
    return ((StringBuilder)localObject).toString();
  }
  
  public String getTroopMemberHonorUrl(String paramString1, String paramString2)
  {
    return getUrl("troop_member_honor_page", ITroopLinkApi.LinkParams.a().b(paramString2).a(paramString1));
  }
  
  public String getTroopMemberLevelUrl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    paramString4 = getUrl("troop_unique_title", ITroopLinkApi.LinkParams.a().a(paramString1).b(paramString2).e(paramString3).d("3").c("aio"));
    paramString3 = paramString4;
    if (TextUtils.isEmpty(paramString4))
    {
      paramString3 = new StringBuilder();
      paramString3.append("https://web.qun.qq.com/cgi-bin/misc/dynamic_url?");
      paramString3.append("gc=");
      paramString3.append(paramString1);
      paramString3.append("&");
      paramString3.append("uin=");
      paramString3.append(paramString2);
      paramString3.append("&");
      paramString3.append("type=");
      paramString3.append(3);
      paramString3.append("&");
      paramString3.append("from=");
      paramString3.append("aio");
      paramString3.append("&");
      paramString3.append("_wv=");
      paramString3.append("16777223");
      paramString3.append("&_wwv=1");
      paramString3 = paramString3.toString();
    }
    return paramString3;
  }
  
  public String getUrl(String paramString)
  {
    synchronized (this.mLock)
    {
      paramString = (String)urlMaps.get(paramString);
      return paramString;
    }
  }
  
  public String getUrl(String paramString, Bundle paramBundle)
  {
    return replace(getUrl(paramString), paramBundle);
  }
  
  public String replaceParams(String paramString, ITroopLinkApi.LinkParams paramLinkParams)
  {
    String str1 = paramString;
    if (paramLinkParams.c != null) {
      str1 = paramString.replace("<$FROM>", paramLinkParams.c);
    }
    paramString = str1;
    if (paramLinkParams.a != null) {
      paramString = str1.replace("<$GC>", paramLinkParams.a);
    }
    str1 = paramString;
    if (paramLinkParams.e != null) {
      str1 = paramString.replace("<$NICK>", paramLinkParams.e);
    }
    paramString = str1;
    if (paramLinkParams.d != null) {
      paramString = str1.replace("<$TYPE>", paramLinkParams.d);
    }
    str1 = paramString;
    if (paramLinkParams.b != null) {
      str1 = paramString.replace("<$UIN>", paramLinkParams.b);
    }
    paramString = str1;
    if (paramLinkParams.f != null) {
      paramString = str1.replace("<$CATEID>", paramLinkParams.f);
    }
    str1 = paramString;
    if (paramLinkParams.g != null) {
      str1 = paramString.replace("<$SUBID>", paramLinkParams.g);
    }
    paramString = str1;
    if (paramLinkParams.j != null) {
      paramString = str1.replace("<$GRAY>", paramLinkParams.j);
    }
    str1 = paramString;
    String str2;
    if (paramLinkParams.h != null) {
      try
      {
        str1 = paramString.replace("<$TITLE>", URLEncoder.encode(paramLinkParams.h, "UTF-8").replaceAll("\\+", "%20"));
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        str2 = paramString;
      }
    }
    if (paramLinkParams.i != null) {
      try
      {
        paramString = str2.replace("<$CONTENT>", URLEncoder.encode(paramLinkParams.i, "UTF-8").replaceAll("\\+", "%20"));
        return paramString;
      }
      catch (UnsupportedEncodingException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return str2;
  }
  
  public boolean saveConfig(String paramString)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("config update:");
      ((StringBuilder)???).append(paramString);
      QLog.d(".troop.trooplink", 2, ((StringBuilder)???).toString());
    }
    try
    {
      Object localObject2 = new JSONObject(paramString);
      Iterator localIterator = ((JSONObject)localObject2).keys();
      synchronized (this.mLock)
      {
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = ((JSONObject)localObject2).getString(str1);
          urlMaps.put(str1, str2);
        }
        this.isUpdateServer = true;
        ??? = new StringBuilder();
        ((StringBuilder)???).append(MobileQQ.sMobileQQ.getFilesDir().getAbsolutePath());
        ((StringBuilder)???).append(File.separator);
        ((StringBuilder)???).append("troop_link_config.json");
        ??? = ((StringBuilder)???).toString();
        localObject2 = new File((String)???);
        if (((File)localObject2).exists()) {
          ((File)localObject2).delete();
        }
        ThreadManager.post(new TroopLinkApiImpl.2(this, (String)???, paramString), 5, null, false);
        return true;
      }
      return false;
    }
    catch (Exception paramString)
    {
      QLog.e(".troop.trooplink", 1, "parseConfig failed!", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.trooplink.api.impl.TroopLinkApiImpl
 * JD-Core Version:    0.7.0.1
 */