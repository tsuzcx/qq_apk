package com.tencent.mobileqq.troop.utils;

import ajpz;
import ajqa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class TroopLinkManager
{
  public static TroopLinkManager a;
  public static final HashMap a;
  public Object a;
  public boolean a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("troop_create", "https://admin.qun.qq.com/mcreatev3/info.html?_bid=206&_wv=2097155&cateid=<$CATEID>&subid=<$SUBID>&_nativeFrom=<$FROM>");
    jdField_a_of_type_JavaUtilHashMap.put("troop_create_for_school", "https://admin.qun.qq.com/mcreatev3/school_new.html?_bid=206&_wv=18875395&_wwv=18875393&_nativeFrom=<$FROM>");
    jdField_a_of_type_JavaUtilHashMap.put("troop_create_for_game", "https://admin.qun.qq.com/mcreatev3/info.html?_bid=206&_wv=2097155&cateid=<$CATEID>&subid=<$SUBID>&_nativeFrom=<$FROM>");
    jdField_a_of_type_JavaUtilHashMap.put("troop_gift", "https://qun.qq.com/qunpay/gifts/index.html?troopUin=<$GC>&uin=<$UIN>&name=<$NICK>&from=<$FROM>&_wv=1031&_bid=2204&_wvSb=1&_nav_alpha=0");
    jdField_a_of_type_JavaUtilHashMap.put("troop_rank", "https://qun.qq.com/qqweb/m/qun/rank/rank.html?gc=<$GC>&uin=<$UIN>&from=<$FROM>&_wv=1031&_bid=2468");
    jdField_a_of_type_JavaUtilHashMap.put("troop_level", "http://qinfo.clt.qq.com/qlevel/level.html?gc=<$GC>&type=<$TYPE>");
    jdField_a_of_type_JavaUtilHashMap.put("troop_level_setting", "http://qinfo.clt.qq.com/qlevel/setting.html?_wv=4&_bid=125#gc=<$GC>&type=<$TYPE>");
    jdField_a_of_type_JavaUtilHashMap.put("troop_unique_title", "https://qun.qq.com/qqweb/m/qun/medal/index.html?_wv=16777223&_bid=2504&gc=<$GC>&uin=<$UIN>&from=<$FROM>");
    jdField_a_of_type_JavaUtilHashMap.put("troop_create_notice", "https://web.qun.qq.com/mannounce/edit.html?_bid=148&_wv=1031&gc=<$GC>&title=<$TITLE>&content=<$CONTENT>&from=<$FROM>&school=1");
    jdField_a_of_type_JavaUtilHashMap.put("troop_create_homework", "https://qun.qq.com/homework/features/sethomework.html?_wv=5123&_bid=2146#role=teacher&gid=<$GC>&content=<$CONTENT>&type=word&from=<$FROM>");
    jdField_a_of_type_JavaUtilHashMap.put("troop_list_homework", "https://qun.qq.com/homework/features/v2/index.html?_wv=1027&_bid=3089&gc=<$GC>&from=<$FROM>");
    jdField_a_of_type_JavaUtilHashMap.put("troop_homework_create_notice", "https://web.qun.qq.com/mannounce/schooledit.html?_bid=148&_wv=1031&from=<$FROM>&content=<$CONTENT>&gc=<$GC>");
    jdField_a_of_type_JavaUtilHashMap.put("troop_bind_game", "https://imgcache.qq.com/gc/gamecenterV2/dist/index/qqbindGroup/index.html?_wvx=10&_wvxBclr=0xffffff&_wv=1027");
  }
  
  private TroopLinkManager()
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_Boolean = false;
    ThreadManager.post(new ajpz(this, BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath() + File.separator + "troop_link_config.json"), 5, null, false);
  }
  
  public static TroopLinkManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopLinkManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopLinkManager == null) {
        jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopLinkManager = new TroopLinkManager();
      }
      return jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopLinkManager;
    }
    finally {}
  }
  
  public String a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      paramString = (String)jdField_a_of_type_JavaUtilHashMap.get(paramString);
      return paramString;
    }
  }
  
  public String a(String paramString, TroopLinkManager.LinkParams paramLinkParams)
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
    String str3 = str1;
    if (paramLinkParams.f != null) {
      str3 = str1.replace("<$CATEID>", paramLinkParams.f);
    }
    paramString = str3;
    if (paramLinkParams.g != null) {
      paramString = str3.replace("<$SUBID>", paramLinkParams.g);
    }
    str1 = paramString;
    if (paramLinkParams.h != null) {}
    try
    {
      str1 = paramString.replace("<$TITLE>", URLEncoder.encode(paramLinkParams.h, "UTF-8").replaceAll("\\+", "%20"));
      paramString = str1;
      if (paramLinkParams.i == null) {}
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      String str2;
      for (;;)
      {
        try
        {
          paramString = str1.replace("<$CONTENT>", URLEncoder.encode(paramLinkParams.i, "UTF-8").replaceAll("\\+", "%20"));
          return paramString;
        }
        catch (UnsupportedEncodingException paramString)
        {
          paramString.printStackTrace();
        }
        localUnsupportedEncodingException = localUnsupportedEncodingException;
        localUnsupportedEncodingException.printStackTrace();
        str2 = paramString;
      }
      return str2;
    }
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.trooplink", 2, "config update:" + paramString);
    }
    try
    {
      localObject2 = new JSONObject(paramString);
      Iterator localIterator = ((JSONObject)localObject2).keys();
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = ((JSONObject)localObject2).getString(str1);
          jdField_a_of_type_JavaUtilHashMap.put(str1, str2);
        }
      }
      this.jdField_a_of_type_Boolean = true;
    }
    catch (Exception paramString)
    {
      QLog.e(".troop.trooplink", 1, "parseConfig failed!", paramString);
      return false;
    }
    ??? = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath() + File.separator + "troop_link_config.json";
    Object localObject2 = new File((String)???);
    if (((File)localObject2).exists()) {
      ((File)localObject2).delete();
    }
    ThreadManager.post(new ajqa(this, (String)???, paramString), 5, null, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopLinkManager
 * JD-Core Version:    0.7.0.1
 */