package com.tencent.mobileqq.qqgamepub.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.data.QGameBusEvent;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GamePubAccountHelper
{
  private static String jdField_a_of_type_JavaLangString;
  private static Map<String, List<Long>> jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
  private static String jdField_b_of_type_JavaLangString;
  private static Map<String, String> jdField_b_of_type_JavaUtilMap = new HashMap();
  private static String c;
  private static String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "https://w.gamecenter.qq.com/v1/cgi-bin/common/feeds";
    jdField_b_of_type_JavaLangString = "https://hao.gamecenter.qq.com/sgame-official-account/cgi-bin/first";
    c = "https://hao.gamecenter.qq.com/sgame-official-account/cgi-bin/get-game-priority-json";
    d = "4";
  }
  
  public static float a(int paramInt, float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 > 0.0F) && (paramFloat2 > 0.0F))
    {
      paramFloat1 = paramFloat2 / paramFloat1;
      if (paramFloat1 != 0.0F) {
        return paramInt / paramFloat1;
      }
    }
    return 0.0F;
  }
  
  public static long a(ArrayList<WadlResult> paramArrayList)
  {
    l2 = 0L;
    l1 = l2;
    if (paramArrayList != null)
    {
      l1 = l2;
      if (paramArrayList.size() > 0)
      {
        Iterator localIterator = paramArrayList.iterator();
        paramArrayList = "";
        l1 = 0L;
        Object localObject = "";
        int i = 0;
        while (localIterator.hasNext())
        {
          WadlResult localWadlResult = (WadlResult)localIterator.next();
          if ((localWadlResult.b == 6) && (localWadlResult.c > l1))
          {
            l1 = localWadlResult.c;
            paramArrayList = localWadlResult.a.jdField_a_of_type_JavaLangString;
            i = localWadlResult.a.e;
            localObject = localWadlResult.a.f;
          }
        }
        l1 = l2;
        if (!TextUtils.isEmpty(paramArrayList))
        {
          int j = GameCenterUtil.a((String)localObject);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("appVersionCode = ");
            ((StringBuilder)localObject).append(j);
            ((StringBuilder)localObject).append(" lastGameVer=");
            ((StringBuilder)localObject).append(i);
            QLog.d("QQGamePub_GamePubAccountHelper", 1, ((StringBuilder)localObject).toString());
          }
          if (j >= i) {
            l1 = l2;
          }
        }
      }
    }
    try
    {
      l1 = Long.parseLong(paramArrayList);
    }
    catch (NumberFormatException paramArrayList)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("getLastGameAppID gameAppId=");
      paramArrayList.append(l1);
      QLog.d("QQGamePub_GamePubAccountHelper", 1, paramArrayList.toString());
    }
    return l1;
  }
  
  public static WadlReportBuilder a(String paramString)
  {
    WadlReportBuilder localWadlReportBuilder = new WadlReportBuilder();
    localWadlReportBuilder.a("dc00087").h("769").e("1").f("160").a(24, paramString);
    return localWadlReportBuilder;
  }
  
  public static GmpEnterInfoRsp a()
  {
    Object localObject2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject2 != null)
    {
      SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences("game_center_sp", 0);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(((AppRuntime)localObject2).getAccount());
      ((StringBuilder)localObject1).append("sp_key_game_center_enter_status");
      ((StringBuilder)localObject1).append("_jumpUrl");
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(((AppRuntime)localObject2).getAccount());
      ((StringBuilder)localObject3).append("sp_key_game_center_enter_status");
      ((StringBuilder)localObject3).append("_bubbleId");
      localObject2 = ((StringBuilder)localObject3).toString();
      localObject3 = new GmpEnterInfoRsp();
      ((GmpEnterInfoRsp)localObject3).url = localSharedPreferences.getString((String)localObject1, "");
      ((GmpEnterInfoRsp)localObject3).bubble_id = localSharedPreferences.getString((String)localObject2, "");
      return localObject3;
    }
    return new GmpEnterInfoRsp();
  }
  
  public static String a()
  {
    return d;
  }
  
  public static String a(AppInterface paramAppInterface)
  {
    SharedPreferences localSharedPreferences = paramAppInterface.getApp().getSharedPreferences("game_center_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("msgPos_web");
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    return localSharedPreferences.getString(localStringBuilder.toString(), "");
  }
  
  public static String a(String paramString)
  {
    if (jdField_b_of_type_JavaUtilMap.containsKey(paramString)) {
      return (String)jdField_b_of_type_JavaUtilMap.get(paramString);
    }
    return "";
  }
  
  public static JSONArray a(List<QQGameMsgInfo> paramList)
  {
    localJSONArray = new JSONArray();
    if ((paramList != null) && (paramList.size() > 0)) {
      try
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)paramList.next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("msgID", localQQGameMsgInfo.paMsgid);
          localJSONObject.put("appID", localQQGameMsgInfo.gameAppId);
          localJSONObject.put("msgTime", localQQGameMsgInfo.msgTime);
          if (!TextUtils.isEmpty(localQQGameMsgInfo.sortedConfigs)) {
            localJSONObject.put("sorted_configs", localQQGameMsgInfo.sortedConfigs);
          }
          if (!TextUtils.isEmpty(localQQGameMsgInfo.extJson)) {
            localJSONObject.put("extJson", localQQGameMsgInfo.extJson);
          }
          localJSONArray.put(localJSONObject);
        }
        return localJSONArray;
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
      }
    }
  }
  
  public static JSONArray a(List<QQGameMsgInfo> paramList, long paramLong1, long paramLong2)
  {
    JSONArray localJSONArray = new JSONArray();
    int k = 0;
    int i;
    if ((paramList != null) && (paramList.size() > 0))
    {
      try
      {
        Iterator localIterator = paramList.iterator();
        int j;
        for (i = 0; localIterator.hasNext(); i = j)
        {
          QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)localIterator.next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("msgID", localQQGameMsgInfo.paMsgid);
          localJSONObject.put("appID", localQQGameMsgInfo.gameAppId);
          localJSONObject.put("msgType", localQQGameMsgInfo.msgType);
          if (localQQGameMsgInfo.msgType == 1)
          {
            localJSONObject.put("arkData", b(localQQGameMsgInfo));
          }
          else
          {
            j = localQQGameMsgInfo.msgType;
            if (j == 2) {
              localJSONObject.put("structData", a(localQQGameMsgInfo));
            } else if (localQQGameMsgInfo.msgType == 3) {
              localJSONObject.put("structData", a(localQQGameMsgInfo));
            }
          }
          localJSONObject.put("msgTime", localQQGameMsgInfo.msgTime);
          if (!TextUtils.isEmpty(localQQGameMsgInfo.sortedConfigs)) {
            localJSONObject.put("sorted_configs", localQQGameMsgInfo.sortedConfigs);
          }
          if (!TextUtils.isEmpty(localQQGameMsgInfo.extJson)) {
            localJSONObject.put("extJson", localQQGameMsgInfo.extJson);
          }
          localJSONObject.put("desc", localQQGameMsgInfo.desc);
          localJSONObject.put("icon", localQQGameMsgInfo.icon);
          localJSONObject.put("frienduin", localQQGameMsgInfo.frienduin);
          localJSONObject.put("uniseq", localQQGameMsgInfo.uniseq);
          localJSONObject.put("advId", localQQGameMsgInfo.advId);
          localJSONObject.put("triggerInfo", localQQGameMsgInfo.triggerInfo);
          boolean bool = a(localQQGameMsgInfo, paramLong1);
          j = i;
          if (!bool) {
            j = i + 1;
          }
          if (j <= paramLong2) {
            localJSONObject.put("isReaded", bool);
          } else {
            localJSONObject.put("isReaded", true);
          }
          localJSONArray.put(localJSONObject);
        }
        if (!QLog.isColorLevel()) {
          break label504;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getGameDataParamV2,infoList:");
      i = k;
      if (paramList != null) {
        i = paramList.size();
      }
      localStringBuilder.append(i);
      localStringBuilder.append(",lastRead:");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(",mUnreadMsgNum:");
      localStringBuilder.append(paramLong2);
      QLog.i("QQGamePub_GamePubAccountHelper", 2, localStringBuilder.toString());
    }
    label504:
    return localJSONArray;
  }
  
  public static JSONObject a(QQGameMsgInfo paramQQGameMsgInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("coverUrl", paramQQGameMsgInfo.coverUrl);
      localJSONObject.put("url", paramQQGameMsgInfo.url);
      localJSONObject.put("title", paramQQGameMsgInfo.title);
      localJSONObject.put("dateTitle", paramQQGameMsgInfo.dateTitle);
      localJSONObject.put("contentText", paramQQGameMsgInfo.contentText);
      localJSONObject.put("limitText", paramQQGameMsgInfo.limitText);
      localJSONObject.put("actionUrl", paramQQGameMsgInfo.actionUrl);
      return localJSONObject;
    }
    catch (JSONException paramQQGameMsgInfo)
    {
      paramQQGameMsgInfo.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static JSONObject a(String paramString)
  {
    try
    {
      if (jdField_a_of_type_JavaUtilMap.containsKey(paramString))
      {
        Object localObject = (List)jdField_a_of_type_JavaUtilMap.get(paramString);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("apiSendEnd", ((List)localObject).get(0));
        localJSONObject.put("sendPack", ((List)localObject).get(1));
        localJSONObject.put("resPack", ((List)localObject).get(2));
        localJSONObject.put("apiPackStart", ((List)localObject).get(3));
        long l = ((Long)((List)localObject).get(3)).longValue() - ((Long)((List)localObject).get(0)).longValue();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(l);
        localStringBuilder.append("");
        localJSONObject.put("costTime", localStringBuilder.toString());
        paramString = a(a()).c("206660").a(15, paramString);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(((List)localObject).get(0));
        localStringBuilder.append("");
        paramString = paramString.a(16, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(((List)localObject).get(1));
        localStringBuilder.append("");
        paramString = paramString.a(17, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(((List)localObject).get(2));
        localStringBuilder.append("");
        paramString = paramString.a(18, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(((List)localObject).get(3));
        localStringBuilder.append("");
        paramString = paramString.a(19, localStringBuilder.toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append("");
        paramString.a(20, ((StringBuilder)localObject).toString()).a();
        return localJSONObject;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static void a()
  {
    Object localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject1 != null)
    {
      SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences("game_center_sp", 0);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((AppRuntime)localObject1).getAccount());
      ((StringBuilder)localObject2).append("sp_key_game_center_enter_status");
      ((StringBuilder)localObject2).append("_jumpUrl");
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((AppRuntime)localObject1).getAccount());
      localStringBuilder.append("sp_key_game_center_enter_status");
      localStringBuilder.append("_bubbleId");
      localObject1 = localStringBuilder.toString();
      localSharedPreferences.edit().putString((String)localObject2, "").apply();
      localSharedPreferences.edit().putString((String)localObject1, "").apply();
    }
  }
  
  public static void a(int paramInt)
  {
    QGameBusEvent localQGameBusEvent = new QGameBusEvent(paramInt);
    SimpleEventBus.getInstance().dispatchEvent(localQGameBusEvent);
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    a(paramInt1, paramInt2, paramString1, paramString2, 1);
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3)
  {
    ThreadManagerV2.executeOnSubThread(new GamePubAccountHelper.2(paramString1, paramInt1, paramInt2, paramInt3, paramString2));
  }
  
  public static void a(int paramInt1, QQGameMsgInfo paramQQGameMsgInfo, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("publicAccountTianshuReport---> action=");
      ((StringBuilder)localObject).append(paramInt1);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("   position=");
      localStringBuilder.append(paramInt2);
      QLog.d("QQGamePub_GamePubAccountHelper", 1, new Object[] { localObject, localStringBuilder.toString() });
    }
    if (paramQQGameMsgInfo == null) {
      return;
    }
    if (paramInt1 == 117) {
      c(paramQQGameMsgInfo.frienduin, paramQQGameMsgInfo.uniseq);
    }
    if (!TextUtils.isEmpty(paramQQGameMsgInfo.advId)) {
      localObject = paramQQGameMsgInfo.advId;
    } else {
      localObject = "";
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    a(paramInt1, paramInt2, (String)localObject, paramQQGameMsgInfo.triggerInfo);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString)
  {
    SharedPreferences localSharedPreferences = paramAppInterface.getApp().getSharedPreferences("game_center_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("msgPos_web");
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    paramAppInterface = localStringBuilder.toString();
    localSharedPreferences.edit().putString(paramAppInterface, paramString).apply();
  }
  
  public static void a(GmpEnterInfoRsp paramGmpEnterInfoRsp)
  {
    Object localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject1 != null)
    {
      SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences("game_center_sp", 0);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((AppRuntime)localObject1).getAccount());
      ((StringBuilder)localObject2).append("sp_key_game_center_enter_status");
      ((StringBuilder)localObject2).append("_jumpUrl");
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((AppRuntime)localObject1).getAccount());
      localStringBuilder.append("sp_key_game_center_enter_status");
      localStringBuilder.append("_bubbleId");
      localObject1 = localStringBuilder.toString();
      localSharedPreferences.edit().putString((String)localObject2, paramGmpEnterInfoRsp.url).apply();
      localSharedPreferences.edit().putString((String)localObject1, paramGmpEnterInfoRsp.bubble_id).apply();
    }
  }
  
  public static void a(String paramString)
  {
    try
    {
      if (jdField_a_of_type_JavaUtilMap.containsKey(paramString))
      {
        List localList = (List)jdField_a_of_type_JavaUtilMap.get(paramString);
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("url=");
        localStringBuffer.append(paramString);
        localStringBuffer.append("|apiSendEnd:");
        localStringBuffer.append(localList.get(0));
        localStringBuffer.append("|sendPack:");
        localStringBuffer.append(localList.get(1));
        localStringBuffer.append("|resPack:");
        localStringBuffer.append(localList.get(2));
        localStringBuffer.append("|apiPackStart:");
        localStringBuffer.append(localList.get(3));
        paramString = new StringBuilder();
        paramString.append("|costTime=");
        paramString.append(((Long)localList.get(3)).longValue() - ((Long)localList.get(0)).longValue());
        localStringBuffer.append(paramString.toString());
        QLog.d("QQGamePub_GamePubAccountHelper", 1, localStringBuffer.toString());
        return;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    try
    {
      if ((paramString.startsWith(jdField_a_of_type_JavaLangString)) || (paramString.startsWith(jdField_b_of_type_JavaLangString)) || (paramString.startsWith(c)))
      {
        if (jdField_a_of_type_JavaUtilMap.containsKey(paramString))
        {
          ((List)jdField_a_of_type_JavaUtilMap.get(paramString)).add(Long.valueOf(paramLong));
          return;
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Long.valueOf(paramLong));
        jdField_a_of_type_JavaUtilMap.put(paramString, localArrayList);
        return;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      jdField_b_of_type_JavaUtilMap.put(paramString1, paramString2);
    }
  }
  
  private static boolean a(QQGameMsgInfo paramQQGameMsgInfo, long paramLong)
  {
    for (;;)
    {
      try
      {
        if (paramLong >= paramQQGameMsgInfo.msgTime)
        {
          bool = true;
          if (QLog.isDevelopLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("isMsgRead...lastRead:");
            localStringBuilder.append(paramLong);
            localStringBuilder.append(",msgTime:");
            localStringBuilder.append(paramQQGameMsgInfo.msgTime);
            localStringBuilder.append(",isRead:");
            localStringBuilder.append(bool);
            QLog.i("QQGamePub_GamePubAccountHelper", 4, localStringBuilder.toString());
          }
          return bool;
        }
      }
      catch (Throwable paramQQGameMsgInfo)
      {
        QLog.e("QQGamePub_GamePubAccountHelper", 1, paramQQGameMsgInfo, new Object[0]);
        return false;
      }
      boolean bool = false;
    }
  }
  
  public static boolean a(String paramString)
  {
    return "com.tencent.gamecenter.newvideo".equals(paramString);
  }
  
  public static WadlReportBuilder b(String paramString)
  {
    WadlReportBuilder localWadlReportBuilder = new WadlReportBuilder();
    localWadlReportBuilder.a("dc00087").a(24, paramString);
    return localWadlReportBuilder;
  }
  
  public static JSONObject b(QQGameMsgInfo paramQQGameMsgInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appName", paramQQGameMsgInfo.arkAppName);
      localJSONObject.put("appView", paramQQGameMsgInfo.arkAppView);
      localJSONObject.put("appMinVersion", paramQQGameMsgInfo.arkAppMinVersion);
      localJSONObject.put("appMetaList", paramQQGameMsgInfo.arkMetaList);
      localJSONObject.put("appConfig", paramQQGameMsgInfo.arkAppConfig);
      int i = (int)UIUtils.a(DisplayUtil.a(MobileQQ.getContext()).a, MobileQQ.getContext().getResources());
      int j = (int)a(i, paramQQGameMsgInfo.arkHeight, paramQQGameMsgInfo.arkWidth);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("msgInfo.arkHeight =");
      localStringBuilder.append(paramQQGameMsgInfo.arkHeight);
      localStringBuilder.append("/msgInfo.arkWidth=");
      localStringBuilder.append(paramQQGameMsgInfo.arkWidth);
      localStringBuilder.append("/getGameArkData targetWidth=/targetHeight=");
      localStringBuilder.append(j);
      QLog.e("QQGamePub_GamePubAccountHelper", 1, localStringBuilder.toString());
      localJSONObject.put("width", i);
      localJSONObject.put("height", j);
      return localJSONObject;
    }
    catch (JSONException paramQQGameMsgInfo)
    {
      paramQQGameMsgInfo.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static void b(String paramString)
  {
    d = paramString;
  }
  
  public static void b(String paramString, long paramLong)
  {
    try
    {
      if ((paramString.startsWith(jdField_a_of_type_JavaLangString)) || (paramString.startsWith(jdField_b_of_type_JavaLangString)) || (paramString.startsWith(c)))
      {
        if (jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
          jdField_a_of_type_JavaUtilMap.remove(paramString);
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Long.valueOf(paramLong));
        jdField_a_of_type_JavaUtilMap.put(paramString, localArrayList);
        return;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void c(String paramString, long paramLong)
  {
    ThreadManagerV2.executeOnSubThread(new GamePubAccountHelper.1(paramString, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper
 * JD-Core Version:    0.7.0.1
 */