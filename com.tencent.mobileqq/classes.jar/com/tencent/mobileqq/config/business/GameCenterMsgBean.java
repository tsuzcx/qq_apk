package com.tencent.mobileqq.config.business;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.mobileqq.gamecenter.protocol.GameCenterUnissoHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class GameCenterMsgBean
{
  public static final String a;
  public int a;
  public HashMap<String, ArrayList<String>> a;
  public boolean a;
  public int b;
  public String b;
  public HashMap<String, String> b;
  public int c;
  public String c;
  public int d;
  public String d;
  public String e = "";
  public String f;
  public String g;
  
  static
  {
    jdField_a_of_type_JavaLangString = GameCenterUnissoHandler.jdField_a_of_type_JavaLangString + "GameCenterMsgBean";
  }
  
  public GameCenterMsgBean()
  {
    this.jdField_b_of_type_JavaLangString = GameMsgUtil.jdField_b_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = GameMsgUtil.jdField_c_of_type_JavaLangString;
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static GameCenterMsgBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length <= 0))
    {
      a();
      return null;
    }
    QLog.i(jdField_a_of_type_JavaLangString, 1, "parse begins");
    GameCenterMsgBean localGameCenterMsgBean = new GameCenterMsgBean();
    int i = 0;
    int k;
    for (int j = 0;; j = k)
    {
      if (i < paramArrayOfQConfItem.length)
      {
        Object localObject = paramArrayOfQConfItem[i].jdField_a_of_type_JavaLangString;
        try
        {
          JSONObject localJSONObject = new JSONObject((String)localObject);
          if (localJSONObject.has("show_enter"))
          {
            localGameCenterMsgBean.jdField_d_of_type_Int = localJSONObject.optInt("show_enter");
            QLog.i(jdField_a_of_type_JavaLangString, 1, "parse msg_show_enter, msgBean.mMsgShowEnter:" + localGameCenterMsgBean.jdField_d_of_type_Int);
            k = j;
          }
          else if (localJSONObject.has("AioQuickReply"))
          {
            QLog.i(jdField_a_of_type_JavaLangString, 1, "parse AioQuickReply");
            a(localJSONObject, localGameCenterMsgBean);
            k = j;
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, localThrowable, new Object[0]);
          k = j;
        }
        JSONArray localJSONArray;
        if (localThrowable.has("trace_url_keyword"))
        {
          SharedPreferences localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("game_center_sp_mutiprocess", 4);
          localJSONArray = localThrowable.optJSONArray("trace_url_keyword");
          localSharedPreferences.edit().putString("trace_url_keyword" + a(), localJSONArray.toString()).commit();
          QLog.i(jdField_a_of_type_JavaLangString, 1, "[parse] trace url:" + (String)localObject);
          k = 1;
        }
        else if (localJSONArray.has("play_buddy_tmp_chat_switch"))
        {
          localGameCenterMsgBean.jdField_c_of_type_Int = localJSONArray.optInt("play_buddy_tmp_chat_switch");
          QLog.i(jdField_a_of_type_JavaLangString, 1, "playBuddySwitch:" + localGameCenterMsgBean.jdField_c_of_type_Int);
          k = j;
          if (localJSONArray.has("miniAppName"))
          {
            localGameCenterMsgBean.e = localJSONArray.optString("miniAppName");
            QLog.i(jdField_a_of_type_JavaLangString, 1, "miniAppName:" + localGameCenterMsgBean.e);
            k = j;
          }
        }
        else
        {
          if (localJSONArray.has("gameMsgFuncSwitch")) {
            localGameCenterMsgBean.jdField_a_of_type_Int = localJSONArray.optInt("gameMsgFuncSwitch");
          }
          if (localJSONArray.has("gameMsgListUrl")) {
            localGameCenterMsgBean.jdField_b_of_type_JavaLangString = localJSONArray.optString("gameMsgListUrl");
          }
          if (localJSONArray.has("gamePrefix")) {
            localGameCenterMsgBean.jdField_c_of_type_JavaLangString = localJSONArray.optString("gamePrefix");
          }
          if (localJSONArray.has("viewType")) {
            localGameCenterMsgBean.jdField_b_of_type_Int = localJSONArray.optInt("viewType", 0);
          }
          if (localJSONArray.has("playerInfoUrl")) {
            localGameCenterMsgBean.jdField_d_of_type_JavaLangString = localJSONArray.optString("playerInfoUrl");
          }
          if (localJSONArray.has("gameMsgAioInfo"))
          {
            localObject = localJSONArray.optJSONObject("gameMsgAioInfo");
            if (localObject != null)
            {
              localObject = ((JSONObject)localObject).optJSONObject("pageInfo");
              if (localObject != null)
              {
                localGameCenterMsgBean.f = ((JSONObject)localObject).optString("hippyModuleName");
                localGameCenterMsgBean.g = ((JSONObject)localObject).optString("hippyParam");
              }
            }
          }
          QLog.i(jdField_a_of_type_JavaLangString, 1, "[parse], mGraySwitch:" + localGameCenterMsgBean.jdField_a_of_type_Int + ",url:" + localGameCenterMsgBean.jdField_b_of_type_JavaLangString + ",playerInfo:" + localGameCenterMsgBean.jdField_d_of_type_JavaLangString + ",hippyBundleName:" + localGameCenterMsgBean.f);
          if (localJSONArray.has("aioGameEntrySwitch")) {
            if (localJSONArray.optInt("aioGameEntrySwitch") != 1) {
              break label733;
            }
          }
          label733:
          for (boolean bool = true;; bool = false)
          {
            localGameCenterMsgBean.jdField_a_of_type_Boolean = bool;
            QLog.i(jdField_a_of_type_JavaLangString, 1, "[parse], mGraySwitch:" + localGameCenterMsgBean.jdField_a_of_type_Int + ",url:" + localGameCenterMsgBean.jdField_b_of_type_JavaLangString + ",playerInfo:" + localGameCenterMsgBean.jdField_d_of_type_JavaLangString + ",mAIOGameEntrySwitch:" + localGameCenterMsgBean.jdField_a_of_type_Boolean);
            k = j;
            break;
          }
        }
      }
      else
      {
        if (j == 0) {
          a();
        }
        QLog.i(jdField_a_of_type_JavaLangString, 1, "parse ends");
        return localGameCenterMsgBean;
      }
      i += 1;
    }
  }
  
  private static String a()
  {
    String str2 = "";
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str1 = str2;
    if (localAppRuntime != null)
    {
      str1 = str2;
      if (localAppRuntime.getLongAccountUin() != 0L) {
        str1 = localAppRuntime.getAccount();
      }
    }
    return str1;
  }
  
  public static void a()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("game_center_sp_mutiprocess", 4);
    String str = "trace_url_keyword" + a();
    if (localSharedPreferences.contains(str))
    {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "parse removeTraceKey");
      localSharedPreferences.edit().remove(str).commit();
    }
  }
  
  private static void a(JSONObject paramJSONObject, GameCenterMsgBean paramGameCenterMsgBean)
  {
    for (;;)
    {
      String str;
      try
      {
        QLog.i(jdField_a_of_type_JavaLangString, 1, "[parseAioQuickReply]");
        if ((paramGameCenterMsgBean == null) || (paramGameCenterMsgBean.jdField_a_of_type_JavaUtilHashMap == null))
        {
          QLog.w(jdField_a_of_type_JavaLangString, 1, "param is null, return.");
          return;
        }
        paramGameCenterMsgBean.jdField_a_of_type_JavaUtilHashMap.clear();
        paramJSONObject = paramJSONObject.getJSONObject("AioQuickReply");
        Iterator localIterator = paramJSONObject.keys();
        if (!localIterator.hasNext()) {
          break;
        }
        str = (String)localIterator.next();
        if (TextUtils.isEmpty(str)) {
          continue;
        }
        if ("friend_verify_msg".equals(str))
        {
          b(paramJSONObject.getJSONObject("friend_verify_msg"), paramGameCenterMsgBean);
          continue;
        }
        localJSONArray = paramJSONObject.getJSONArray(str);
      }
      catch (Throwable paramJSONObject)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, paramJSONObject, new Object[0]);
        return;
      }
      JSONArray localJSONArray;
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < localJSONArray.length())
      {
        localArrayList.add(localJSONArray.get(i).toString());
        i += 1;
      }
      paramGameCenterMsgBean.jdField_a_of_type_JavaUtilHashMap.put(str, localArrayList);
    }
  }
  
  private static void b(JSONObject paramJSONObject, GameCenterMsgBean paramGameCenterMsgBean)
  {
    if (paramGameCenterMsgBean != null) {
      try
      {
        if (paramGameCenterMsgBean.jdField_b_of_type_JavaUtilHashMap == null) {
          return;
        }
        paramGameCenterMsgBean.jdField_b_of_type_JavaUtilHashMap.clear();
        Iterator localIterator = paramJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          if (!TextUtils.isEmpty(str1))
          {
            String str2 = paramJSONObject.optString(str1);
            paramGameCenterMsgBean.jdField_b_of_type_JavaUtilHashMap.put(str1, str2);
          }
        }
        return;
      }
      catch (Throwable paramJSONObject)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, paramJSONObject.getMessage());
      }
    }
  }
  
  public void a(GameCenterMsgBean paramGameCenterMsgBean)
  {
    if (paramGameCenterMsgBean == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = paramGameCenterMsgBean.jdField_a_of_type_Int;
      this.jdField_b_of_type_Int = paramGameCenterMsgBean.jdField_b_of_type_Int;
      this.jdField_a_of_type_Boolean = paramGameCenterMsgBean.jdField_a_of_type_Boolean;
      this.jdField_d_of_type_Int = paramGameCenterMsgBean.jdField_d_of_type_Int;
      this.jdField_a_of_type_Boolean = paramGameCenterMsgBean.jdField_a_of_type_Boolean;
      this.jdField_b_of_type_JavaUtilHashMap = paramGameCenterMsgBean.jdField_b_of_type_JavaUtilHashMap;
      this.jdField_a_of_type_JavaUtilHashMap = paramGameCenterMsgBean.jdField_a_of_type_JavaUtilHashMap;
      if (!TextUtils.isEmpty(paramGameCenterMsgBean.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = paramGameCenterMsgBean.jdField_b_of_type_JavaLangString;
      }
      if (!TextUtils.isEmpty(paramGameCenterMsgBean.jdField_c_of_type_JavaLangString)) {
        this.jdField_c_of_type_JavaLangString = paramGameCenterMsgBean.jdField_c_of_type_JavaLangString;
      }
      if (!TextUtils.isEmpty(paramGameCenterMsgBean.jdField_d_of_type_JavaLangString)) {
        this.jdField_d_of_type_JavaLangString = paramGameCenterMsgBean.jdField_d_of_type_JavaLangString;
      }
      if (!TextUtils.isEmpty(paramGameCenterMsgBean.f)) {
        this.f = paramGameCenterMsgBean.f;
      }
      if (!TextUtils.isEmpty(paramGameCenterMsgBean.g)) {
        this.g = paramGameCenterMsgBean.g;
      }
    } while (TextUtils.isEmpty(paramGameCenterMsgBean.e));
    this.e = paramGameCenterMsgBean.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.GameCenterMsgBean
 * JD-Core Version:    0.7.0.1
 */