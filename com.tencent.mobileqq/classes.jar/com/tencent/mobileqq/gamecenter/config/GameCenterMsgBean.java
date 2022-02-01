package com.tencent.mobileqq.gamecenter.config;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public class GameCenterMsgBean
{
  public int a;
  public String b = "https://fastest.gamecenter.qq.com/_fst_/speed_gamecenter_qq_com/_fst_/pushgame/v1/home/msg?_wv=18950115&_wwv=393&_fst_id=194";
  public String c = "https://speed.gamecenter.qq.com/pushgame/v1/gamemsg-setting?_wv=2&_wwv=134";
  public String d = "[游戏好友]";
  public int e = 0;
  public String f = "";
  public int g = 0;
  public String h = "";
  public int i = 0;
  public HashMap<String, ArrayList<String>> j = new HashMap();
  public boolean k;
  public HashMap<String, String> l = new HashMap();
  public String m;
  public String n;
  public boolean o;
  public JSONObject p;
  
  public static GameCenterMsgBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      QLog.i("GameCenterMsgBean", 1, "parse begins");
      GameCenterMsgBean localGameCenterMsgBean = new GameCenterMsgBean();
      int i1 = 0;
      int i2 = 0;
      while (i1 < paramArrayOfQConfItem.length)
      {
        Object localObject1 = paramArrayOfQConfItem[i1].b;
        try
        {
          Object localObject2 = new JSONObject((String)localObject1);
          if (((JSONObject)localObject2).has("show_enter"))
          {
            localGameCenterMsgBean.i = ((JSONObject)localObject2).optInt("show_enter");
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("parse msg_show_enter, msgBean.mMsgShowEnter:");
            ((StringBuilder)localObject1).append(localGameCenterMsgBean.i);
            QLog.i("GameCenterMsgBean", 1, ((StringBuilder)localObject1).toString());
          }
          else if (((JSONObject)localObject2).has("AioQuickReply"))
          {
            QLog.i("GameCenterMsgBean", 1, "parse AioQuickReply");
            c((JSONObject)localObject2, localGameCenterMsgBean);
          }
          else if (((JSONObject)localObject2).has("trace_url_keyword"))
          {
            Object localObject3 = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getApplication().getSharedPreferences("game_center_sp_mutiprocess", 4);
            localObject2 = ((JSONObject)localObject2).optJSONArray("trace_url_keyword");
            localObject3 = ((SharedPreferences)localObject3).edit();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("trace_url_keyword");
            localStringBuilder.append(b());
            ((SharedPreferences.Editor)localObject3).putString(localStringBuilder.toString(), ((JSONArray)localObject2).toString()).commit();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("[parse] trace url:");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.i("GameCenterMsgBean", 1, ((StringBuilder)localObject2).toString());
            i2 = 1;
          }
          else
          {
            a((JSONObject)localObject2, localGameCenterMsgBean);
            b((JSONObject)localObject2, localGameCenterMsgBean);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("[parse], mGraySwitch:");
            ((StringBuilder)localObject1).append(localGameCenterMsgBean.a);
            ((StringBuilder)localObject1).append(",url:");
            ((StringBuilder)localObject1).append(localGameCenterMsgBean.b);
            ((StringBuilder)localObject1).append(",settingUrl:");
            ((StringBuilder)localObject1).append(localGameCenterMsgBean.c);
            ((StringBuilder)localObject1).append(",playerInfo:");
            ((StringBuilder)localObject1).append(localGameCenterMsgBean.f);
            ((StringBuilder)localObject1).append(",mAIOGameEntrySwitch:");
            ((StringBuilder)localObject1).append(localGameCenterMsgBean.k);
            ((StringBuilder)localObject1).append(",mIsJumpGameProfileCard:");
            ((StringBuilder)localObject1).append(localGameCenterMsgBean.o);
            QLog.i("GameCenterMsgBean", 1, ((StringBuilder)localObject1).toString());
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("GameCenterMsgBean", 1, localThrowable.getMessage());
        }
        i1 += 1;
      }
      if (i2 == 0) {
        a();
      }
      QLog.i("GameCenterMsgBean", 1, "parse ends");
      return localGameCenterMsgBean;
    }
    a();
    return null;
  }
  
  public static void a()
  {
    Object localObject1 = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((AppInterface)localObject1).getApp().getSharedPreferences("game_center_sp_mutiprocess", 4);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("trace_url_keyword");
    ((StringBuilder)localObject2).append(b());
    localObject2 = ((StringBuilder)localObject2).toString();
    if (((SharedPreferences)localObject1).contains((String)localObject2))
    {
      QLog.i("GameCenterMsgBean", 1, "parse removeTraceKey");
      ((SharedPreferences)localObject1).edit().remove((String)localObject2).commit();
    }
  }
  
  private static void a(JSONObject paramJSONObject, GameCenterMsgBean paramGameCenterMsgBean)
  {
    try
    {
      if (paramJSONObject.has("play_buddy_tmp_chat_switch"))
      {
        paramGameCenterMsgBean.g = paramJSONObject.optInt("play_buddy_tmp_chat_switch");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("playBuddySwitch:");
        localStringBuilder.append(paramGameCenterMsgBean.g);
        QLog.i("GameCenterMsgBean", 1, localStringBuilder.toString());
        if (!paramJSONObject.has("miniAppName")) {
          return;
        }
        paramGameCenterMsgBean.h = paramJSONObject.optString("miniAppName");
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("miniAppName:");
        paramJSONObject.append(paramGameCenterMsgBean.h);
        QLog.i("GameCenterMsgBean", 1, paramJSONObject.toString());
        return;
      }
      if (paramJSONObject.has("gameMsgFuncSwitch")) {
        paramGameCenterMsgBean.a = paramJSONObject.optInt("gameMsgFuncSwitch");
      }
      if (paramJSONObject.has("gameMsgListUrl")) {
        paramGameCenterMsgBean.b = paramJSONObject.optString("gameMsgListUrl");
      }
      if (paramJSONObject.has("gameMsgSettingUrl")) {
        paramGameCenterMsgBean.c = paramJSONObject.optString("gameMsgSettingUrl");
      }
      if (paramJSONObject.has("gamePrefix")) {
        paramGameCenterMsgBean.d = paramJSONObject.optString("gamePrefix");
      }
      if (paramJSONObject.has("viewType")) {
        paramGameCenterMsgBean.e = paramJSONObject.optInt("viewType", 0);
      }
      if (paramJSONObject.has("playerInfoUrl"))
      {
        paramGameCenterMsgBean.f = paramJSONObject.optString("playerInfoUrl");
        return;
      }
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("GameCenterMsgBean", 1, paramJSONObject, new Object[0]);
    }
    return;
  }
  
  private static String b()
  {
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localAppInterface == null) {
      return "";
    }
    return localAppInterface.getCurrentAccountUin();
  }
  
  private static void b(JSONObject paramJSONObject, GameCenterMsgBean paramGameCenterMsgBean)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject;
        if (paramJSONObject.has("gameMsgAioInfo"))
        {
          localJSONObject = paramJSONObject.optJSONObject("gameMsgAioInfo");
          if (localJSONObject == null) {
            return;
          }
          localJSONObject = localJSONObject.optJSONObject("pageInfo");
          if (localJSONObject != null)
          {
            paramGameCenterMsgBean.m = localJSONObject.optString("hippyModuleName");
            paramGameCenterMsgBean.n = localJSONObject.optString("hippyParam");
          }
        }
        if (paramJSONObject.has("aioGameEntrySwitch"))
        {
          if (paramJSONObject.optInt("aioGameEntrySwitch") != 1) {
            break label177;
          }
          bool = true;
          paramGameCenterMsgBean.k = bool;
        }
        if (paramJSONObject.has("wangZheProfile"))
        {
          localJSONObject = paramJSONObject.optJSONObject("wangZheProfile");
          if (localJSONObject != null)
          {
            if (localJSONObject.optInt("needJump", 0) != 1) {
              break label182;
            }
            bool = true;
            paramGameCenterMsgBean.o = bool;
          }
        }
        if (paramJSONObject.has("greetingConfig"))
        {
          paramJSONObject = paramJSONObject.optJSONObject("greetingConfig");
          if (paramJSONObject != null)
          {
            paramGameCenterMsgBean.p = paramJSONObject.optJSONObject("default");
            return;
          }
        }
      }
      catch (Throwable paramJSONObject)
      {
        QLog.e("GameCenterMsgBean", 1, paramJSONObject, new Object[0]);
      }
      return;
      label177:
      boolean bool = false;
      continue;
      label182:
      bool = false;
    }
  }
  
  private static void c(JSONObject paramJSONObject, GameCenterMsgBean paramGameCenterMsgBean)
  {
    try
    {
      QLog.i("GameCenterMsgBean", 1, "[parseAioQuickReply]");
      Iterator localIterator;
      if ((paramGameCenterMsgBean != null) && (paramGameCenterMsgBean.j != null))
      {
        paramGameCenterMsgBean.j.clear();
        paramJSONObject = paramJSONObject.getJSONObject("AioQuickReply");
        localIterator = paramJSONObject.keys();
      }
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!TextUtils.isEmpty(str)) {
          if ("friend_verify_msg".equals(str))
          {
            d(paramJSONObject.getJSONObject("friend_verify_msg"), paramGameCenterMsgBean);
          }
          else
          {
            JSONArray localJSONArray = paramJSONObject.getJSONArray(str);
            ArrayList localArrayList = new ArrayList();
            int i1 = 0;
            while (i1 < localJSONArray.length())
            {
              localArrayList.add(localJSONArray.get(i1).toString());
              i1 += 1;
            }
            paramGameCenterMsgBean.j.put(str, localArrayList);
            continue;
            QLog.w("GameCenterMsgBean", 1, "param is null, return.");
            return;
          }
        }
      }
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("GameCenterMsgBean", 1, paramJSONObject.getMessage());
    }
  }
  
  private static void d(JSONObject paramJSONObject, GameCenterMsgBean paramGameCenterMsgBean)
  {
    if (paramGameCenterMsgBean != null) {
      try
      {
        if (paramGameCenterMsgBean.l == null) {
          return;
        }
        paramGameCenterMsgBean.l.clear();
        Iterator localIterator = paramJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          if (!TextUtils.isEmpty(str1))
          {
            String str2 = paramJSONObject.optString(str1);
            paramGameCenterMsgBean.l.put(str1, str2);
          }
        }
        return;
      }
      catch (Throwable paramJSONObject)
      {
        QLog.w("GameCenterMsgBean", 1, paramJSONObject.getMessage());
      }
    }
  }
  
  public void a(GameCenterMsgBean paramGameCenterMsgBean)
  {
    if (paramGameCenterMsgBean == null) {
      return;
    }
    this.a = paramGameCenterMsgBean.a;
    this.e = paramGameCenterMsgBean.e;
    this.k = paramGameCenterMsgBean.k;
    this.i = paramGameCenterMsgBean.i;
    this.k = paramGameCenterMsgBean.k;
    this.l = paramGameCenterMsgBean.l;
    this.j = paramGameCenterMsgBean.j;
    this.o = paramGameCenterMsgBean.o;
    this.p = paramGameCenterMsgBean.p;
    if (!TextUtils.isEmpty(paramGameCenterMsgBean.b)) {
      this.b = paramGameCenterMsgBean.b;
    }
    if (!TextUtils.isEmpty(paramGameCenterMsgBean.c)) {
      this.c = paramGameCenterMsgBean.c;
    }
    if (!TextUtils.isEmpty(paramGameCenterMsgBean.d)) {
      this.d = paramGameCenterMsgBean.d;
    }
    if (!TextUtils.isEmpty(paramGameCenterMsgBean.f)) {
      this.f = paramGameCenterMsgBean.f;
    }
    if (!TextUtils.isEmpty(paramGameCenterMsgBean.m)) {
      this.m = paramGameCenterMsgBean.m;
    }
    if (!TextUtils.isEmpty(paramGameCenterMsgBean.n)) {
      this.n = paramGameCenterMsgBean.n;
    }
    if (!TextUtils.isEmpty(paramGameCenterMsgBean.h)) {
      this.h = paramGameCenterMsgBean.h;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.config.GameCenterMsgBean
 * JD-Core Version:    0.7.0.1
 */