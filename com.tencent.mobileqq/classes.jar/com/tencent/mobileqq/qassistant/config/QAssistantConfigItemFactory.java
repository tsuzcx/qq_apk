package com.tencent.mobileqq.qassistant.config;

import com.tencent.mobileqq.utils.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QAssistantConfigItemFactory
{
  private static final HashMap<Integer, String> a = new HashMap();
  
  static
  {
    a.put(Integer.valueOf(100), "openreadinjoy");
    a.put(Integer.valueOf(101), "scan");
    a.put(Integer.valueOf(102), "qassistantnearby");
    a.put(Integer.valueOf(103), "qsettings");
    a.put(Integer.valueOf(104), "searchpage");
    a.put(Integer.valueOf(105), "ecchat");
    a.put(Integer.valueOf(106), "weishi");
    a.put(Integer.valueOf(107), "qinterest");
    a.put(Integer.valueOf(108), "confessmsg");
    a.put(Integer.valueOf(109), "qqgame");
    a.put(Integer.valueOf(110), "conversation");
    a.put(Integer.valueOf(111), "contact");
    a.put(Integer.valueOf(112), "leba");
    a.put(Integer.valueOf(113), "qzone");
    a.put(Integer.valueOf(114), "wezone");
  }
  
  public static QAssistantConfigItem a(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return new QAssistantConfigItem();
    }
    Object localObject;
    if ((!paramString.equalsIgnoreCase("qinterest")) && (!paramString.equalsIgnoreCase("qqgame")))
    {
      if ((!paramString.equalsIgnoreCase("conversation")) && (!paramString.equalsIgnoreCase("contact")) && (!paramString.equalsIgnoreCase("leba"))) {
        localObject = new QAssistantConfigItem();
      } else {
        localObject = new QAssistantConfigMainItem();
      }
    }
    else {
      localObject = new QAssistantConfigWebItem();
    }
    ((QAssistantConfigItem)localObject).g = paramString;
    return localObject;
  }
  
  public static String a(int paramInt)
  {
    return (String)a.get(Integer.valueOf(paramInt));
  }
  
  public static List<QAssistantConfigItem> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(b("openreadinjoy"));
    localArrayList.add(b("scan"));
    localArrayList.add(b("qassistantnearby"));
    localArrayList.add(b("qsettings"));
    localArrayList.add(b("searchpage"));
    localArrayList.add(b("ecchat"));
    localArrayList.add(b("weishi"));
    localArrayList.add(b("qinterest"));
    localArrayList.add(b("confessmsg"));
    localArrayList.add(b("qqgame"));
    localArrayList.add(b("conversation"));
    localArrayList.add(b("contact"));
    localArrayList.add(b("leba"));
    localArrayList.add(b("qzone"));
    localArrayList.add(b("wezone"));
    return localArrayList;
  }
  
  public static QAssistantConfigItem b(String paramString)
  {
    if (paramString.equalsIgnoreCase("openreadinjoy"))
    {
      paramString = new QAssistantConfigWebItem();
      paramString.a = "Open_看点页面跳转——Server版";
      paramString.c = "readinjoy";
      paramString.d = "open";
      paramString.f = true;
      paramString.g = "openreadinjoy";
      paramString.i.put("target", "2001");
      paramString.i.put("from", "1");
      return paramString;
    }
    if (paramString.equalsIgnoreCase("scan"))
    {
      paramString = new QAssistantConfigItem();
      paramString.a = "Open_扫一扫页面跳转——Server版";
      paramString.c = "scanforqassistant";
      paramString.d = "gotoScannerTorchActivity";
      paramString.f = true;
      paramString.g = "scan";
      return paramString;
    }
    if (paramString.equalsIgnoreCase("qassistantnearby"))
    {
      paramString = new QAssistantConfigItem();
      paramString.a = "Open_附近的人页面跳转——Server版";
      paramString.c = "nearbyforqassistant";
      paramString.d = "open";
      paramString.f = true;
      paramString.g = "qassistantnearby";
      return paramString;
    }
    if (paramString.equalsIgnoreCase("qsettings"))
    {
      paramString = new QAssistantConfigItem();
      paramString.a = "Open_设置页面跳转——Server版";
      paramString.c = "settingsforqassistant";
      paramString.d = "open";
      paramString.f = true;
      paramString.g = "qsettings";
      return paramString;
    }
    if (paramString.equalsIgnoreCase("searchpage"))
    {
      paramString = new QAssistantConfigItem();
      paramString.a = "Open_搜索页面跳转——Server版";
      paramString.c = "searchforqassistant";
      paramString.d = "open";
      paramString.f = true;
      paramString.g = "searchpage";
      return paramString;
    }
    if (paramString.equalsIgnoreCase("ecchat"))
    {
      paramString = new QAssistantConfigItem();
      paramString.a = "Open_扩列页面跳转——Server版";
      paramString.c = "qechatforqassistant";
      paramString.d = "open";
      paramString.f = true;
      paramString.g = "ecchat";
      return paramString;
    }
    if (paramString.equalsIgnoreCase("weishi"))
    {
      paramString = new QAssistantConfigItem();
      paramString.a = "Open_扩列页面跳转——Server版";
      paramString.c = "weishiforqassistant";
      paramString.d = "open";
      paramString.f = true;
      paramString.g = "weishi";
      return paramString;
    }
    if (paramString.equalsIgnoreCase("qinterest"))
    {
      paramString = new QAssistantConfigWebItem();
      paramString.a = "Open_兴趣部落页面跳转——Scheme版";
      paramString.f = true;
      paramString.g = "qinterest";
      return paramString;
    }
    if (paramString.equalsIgnoreCase("confessmsg"))
    {
      paramString = new QAssistantConfigItem();
      paramString.a = "Open_坦白说页面跳转——Server版";
      paramString.c = "confiessmsgforqassistant";
      paramString.d = "open";
      paramString.f = true;
      paramString.g = "confessmsg";
      return paramString;
    }
    if (paramString.equalsIgnoreCase("qqgame"))
    {
      paramString = new QAssistantConfigWebItem();
      paramString.a = "Open_游戏中心页面跳转——Scheme版";
      paramString.f = true;
      paramString.g = "qqgame";
      return paramString;
    }
    if (paramString.equalsIgnoreCase("conversation"))
    {
      paramString = new QAssistantConfigMainItem();
      paramString.a = "Open_主界面tab_消息列表";
      paramString.f = true;
      paramString.g = "conversation";
      return paramString;
    }
    if (paramString.equalsIgnoreCase("contact"))
    {
      paramString = new QAssistantConfigMainItem();
      paramString.a = "Open_主界面tab_联系人";
      paramString.f = true;
      paramString.g = "contact";
      return paramString;
    }
    if (paramString.equalsIgnoreCase("leba"))
    {
      paramString = new QAssistantConfigMainItem();
      paramString.a = "Open_主界面tab_动态";
      paramString.f = true;
      paramString.g = "leba";
      return paramString;
    }
    if (paramString.equalsIgnoreCase("qzone"))
    {
      paramString = new QAssistantConfigItem();
      paramString.a = "Open_好友动态跳转";
      paramString.f = true;
      paramString.g = "qzone";
      paramString.c = "qzoneforqassistant";
      return paramString;
    }
    if (paramString.equalsIgnoreCase("wezone"))
    {
      paramString = new QAssistantConfigItem();
      paramString.a = "Open_小世界跳转";
      paramString.f = true;
      paramString.g = "wezone";
      paramString.c = "weqzoneforqassistant";
      return paramString;
    }
    return new QAssistantConfigWebItem();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.config.QAssistantConfigItemFactory
 * JD-Core Version:    0.7.0.1
 */