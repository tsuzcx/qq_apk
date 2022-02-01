package com.tencent.mobileqq.gamecenter.web;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QQGameWebViewJsPlugin
  extends WebViewPlugin
{
  public static String a = "qqgame_api";
  protected String b;
  
  public QQGameWebViewJsPlugin()
  {
    this.mPluginNameSpace = a;
  }
  
  private Context a()
  {
    for (Activity localActivity = this.mRuntime.a(); (localActivity instanceof BasePluginActivity); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  private void a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("code", "-1");
      localJSONObject.put("msg", "error, parameters wrong...");
      label26:
      QLog.i("QQGameWebViewJsPlugin", 2, "errorCallBack: " + localJSONObject);
      a(this.b, localJSONObject.toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      break label26;
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      try
      {
        localObject3 = paramIntent.getParcelableArrayListExtra("result_set");
        if ((localObject3 == null) || (((ArrayList)localObject3).size() == 0))
        {
          a();
          return;
        }
      }
      catch (Exception paramIntent)
      {
        a();
        return;
      }
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      Object localObject1 = paramIntent.getStringExtra("group_uin");
      Object localObject2 = paramIntent.getStringExtra("group_name");
      int i = paramIntent.getIntExtra("group_type", 0);
      int j = paramIntent.getIntExtra("group_member_type", 0);
      if (localObject1 != null)
      {
        localArrayList1.add(localObject1);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localArrayList2.add(localObject1);
        localArrayList3.add(Integer.valueOf(i));
        localArrayList4.add(Integer.valueOf(j));
      }
      localObject1 = new ArrayList();
      localObject2 = new ArrayList();
      ArrayList localArrayList5 = new ArrayList();
      ArrayList localArrayList6 = new ArrayList();
      Object localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject3).next();
        ((List)localObject1).add(localResultRecord.uin);
        ((List)localObject2).add(localResultRecord.name);
        localArrayList5.add(Integer.valueOf(i));
        localArrayList6.add(localResultRecord.gameLevelIcon);
      }
      paramIntent = a(paramIntent, (List)localObject1, (List)localObject2, localArrayList5, localArrayList6, localArrayList1, localArrayList2, localArrayList4, localArrayList3);
      QLog.i("QQGameWebViewJsPlugin", 2, "doChooseFriendResult: " + paramIntent);
      if (QLog.isColorLevel()) {
        QLog.i("QQGameWebViewJsPlugin", 2, "doChooseFriendResult: " + paramIntent);
      }
    } while (paramIntent == null);
    a(this.b, paramIntent.toString());
  }
  
  private void a(String paramString)
  {
    Context localContext = a();
    if ((localContext == null) || (TextUtils.isEmpty(paramString))) {
      a();
    }
    int i1;
    ArrayList localArrayList;
    int n;
    int m;
    int k;
    int j;
    String str1;
    boolean bool;
    int i7;
    int i8;
    String str2;
    for (;;)
    {
      return;
      localObject1 = null;
      i1 = 0;
      localArrayList = new ArrayList();
      n = 0;
      m = 0;
      k = 0;
      j = 0;
      int i = 0;
      try
      {
        paramString = new JSONObject(paramString);
        this.b = paramString.optString("callback");
        str1 = paramString.optString("title");
        bool = Boolean.parseBoolean(paramString.optString("isMulti", "false"));
        i7 = paramString.optInt("limitNum");
        i8 = paramString.optInt("business_type");
        str2 = paramString.optString("gameappid");
        Object localObject2 = paramString.optJSONObject("from_group");
        paramString = (String)localObject1;
        if (localObject2 != null)
        {
          localObject1 = ((JSONObject)localObject2).optString("group_uin");
          int i3 = ((JSONObject)localObject2).optInt("group_type");
          int i4 = ((JSONObject)localObject2).optInt("enable_select_all");
          int i5 = ((JSONObject)localObject2).optInt("enable_show_myself");
          int i6 = ((JSONObject)localObject2).optInt("enable_filter_robot");
          if (1 == i8) {
            i = ((JSONObject)localObject2).optInt("game_req_info_flag");
          }
          localObject2 = ((JSONObject)localObject2).optJSONArray("group_members");
          j = i;
          k = i6;
          m = i5;
          n = i4;
          i1 = i3;
          paramString = (String)localObject1;
          if (localObject2 != null)
          {
            int i2 = 0;
            for (;;)
            {
              j = i;
              k = i6;
              m = i5;
              n = i4;
              i1 = i3;
              paramString = (String)localObject1;
              if (i2 >= ((JSONArray)localObject2).length()) {
                break;
              }
              paramString = ((JSONArray)localObject2).optString(i2);
              if (!TextUtils.isEmpty(paramString)) {
                localArrayList.add(paramString);
              }
              i2 += 1;
            }
          }
        }
        if (!bool) {}
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        a();
        return;
      }
    }
    if (i7 < 0)
    {
      a();
      return;
    }
    Object localObject1 = new Intent(localContext, SelectMemberActivity.class);
    ((Intent)localObject1).putExtra("param_donot_need_contacts", true);
    ((Intent)localObject1).putExtra("param_min", 1);
    if (i7 > 0) {
      ((Intent)localObject1).putExtra("param_max", i7);
    }
    ((Intent)localObject1).putExtra("param_title", str1);
    ((Intent)localObject1).putExtra("param_entrance", 43);
    ((Intent)localObject1).putExtra("GAME_H5_SELECT_BUSINESS_TYPE", i8);
    ((Intent)localObject1).putExtra("GAME_H5_SELECT_GAME_APPID", str2);
    ((Intent)localObject1).addFlags(67108864);
    if ((!TextUtils.isEmpty(paramString)) && ((i1 == 4) || (i1 == 8)))
    {
      ((Intent)localObject1).putExtra("param_overload_tips_include_default_count", true);
      ((Intent)localObject1).putExtra("group_uin", paramString);
      if (n != 0)
      {
        bool = true;
        ((Intent)localObject1).putExtra("param_enable_all_select", bool);
        if (m == 0) {
          break label603;
        }
        bool = true;
        label481:
        ((Intent)localObject1).putExtra("param_show_myself", bool);
        if (k == 0) {
          break label609;
        }
        bool = true;
        label500:
        ((Intent)localObject1).putExtra("filer_robot", bool);
        if (localArrayList.size() > 0)
        {
          if (localArrayList.size() > i7) {
            localArrayList.subList(i7, localArrayList.size()).clear();
          }
          ((Intent)localObject1).putExtra("param_uins_selected_friends", localArrayList);
        }
        if (i1 != 4) {
          break label615;
        }
        ((Intent)localObject1).putExtra("param_only_troop_member", true);
        if (1 == i8) {
          ((Intent)localObject1).putExtra("game_req_info_flag", j);
        }
      }
    }
    for (;;)
    {
      super.startActivityForResult((Intent)localObject1, (byte)33);
      return;
      bool = false;
      break;
      label603:
      bool = false;
      break label481;
      label609:
      bool = false;
      break label500;
      label615:
      ((Intent)localObject1).putExtra("param_only_discussion_member", true);
      continue;
      ((Intent)localObject1).putExtra("param_only_friends", true);
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    QLog.i("QQGameWebViewJsPlugin", 2, "doCallback: " + paramString1 + " js: " + paramString2);
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      super.callJs(paramString1, new String[] { paramString2 });
    }
  }
  
  protected JSONObject a(Intent paramIntent, List<String> paramList1, List<String> paramList2, List<Integer> paramList3, List<String> paramList4, List<String> paramList5, List<String> paramList6, List<Integer> paramList7, List<Integer> paramList8)
  {
    JSONObject localJSONObject1;
    JSONArray localJSONArray;
    int i;
    String str2;
    try
    {
      localJSONObject1 = new JSONObject();
      localJSONArray = new JSONArray();
      if ((paramList1 != null) && (paramList2 != null))
      {
        i = 0;
        if ((i < paramList1.size()) && (i < paramList2.size()))
        {
          paramIntent = "";
          String str1 = "";
          if (!TextUtils.isEmpty((CharSequence)paramList1.get(i))) {
            paramIntent = (String)paramList1.get(i);
          }
          if (!TextUtils.isEmpty((CharSequence)paramList2.get(i))) {
            str1 = (String)paramList2.get(i);
          }
          if ((paramList4 == null) || (paramList4.size() - 1 < i) || (TextUtils.isEmpty((CharSequence)paramList4.get(i)))) {
            break label616;
          }
          str2 = (String)paramList4.get(i);
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("uin", paramIntent);
          localJSONObject2.put("name", str1);
          localJSONObject2.put("levelIcon", str2);
          if ((paramList3 != null) && (paramList3.size() > i)) {
            localJSONObject2.put("type", paramList3.get(i));
          }
          for (;;)
          {
            localJSONArray.put(localJSONObject2);
            i += 1;
            break;
            localJSONObject2.put("type", 1);
          }
        }
      }
      if (paramList5 == null) {
        break label611;
      }
    }
    catch (JSONException paramIntent)
    {
      paramIntent.printStackTrace();
      return null;
    }
    label312:
    int k;
    if ((paramList6 != null) && (paramList7 != null) && (paramList8 != null))
    {
      paramList2 = new JSONArray();
      i = 0;
      if ((i >= paramList5.size()) || (i >= paramList6.size()) || (i >= paramList7.size()) || (i >= paramList8.size())) {
        break label648;
      }
      paramIntent = "";
      paramList1 = "";
      int j = 0;
      if (!TextUtils.isEmpty((CharSequence)paramList5.get(i))) {
        paramIntent = (String)paramList5.get(i);
      }
      if (!TextUtils.isEmpty((CharSequence)paramList6.get(i))) {
        paramList1 = (String)paramList6.get(i);
      }
      if (paramList7.get(i) != null) {
        j = ((Integer)paramList7.get(i)).intValue();
      }
      if (paramList8.get(i) != null)
      {
        k = ((Integer)paramList8.get(i)).intValue();
        break label623;
        label492:
        paramList3 = new JSONObject();
        paramList3.put("uin", paramIntent);
        paramList3.put("name", paramList1);
        paramList3.put("type", k);
        paramList3.put("count", j);
        paramList2.put(paramList3);
        break label639;
      }
    }
    for (;;)
    {
      localJSONObject1.put("friends", localJSONArray);
      if ((paramIntent != null) && (paramIntent.length() > 0)) {
        localJSONObject1.put("groups", paramIntent);
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQGameWebViewJsPlugin", 2, localJSONObject1.toString());
      }
      return localJSONObject1;
      k = 0;
      break label623;
      label611:
      paramIntent = null;
      continue;
      label616:
      str2 = "";
      break;
      label623:
      if ((k == 4) || (k == 8)) {
        break label492;
      }
      label639:
      i += 1;
      break label312;
      label648:
      paramIntent = paramList2;
    }
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 8589934621L;
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    super.handleEvent(paramString, paramLong, paramMap);
    if (paramLong == 8589934621L)
    {
      paramString = new JSONObject();
      if (paramMap != null) {}
      for (;;)
      {
        try
        {
          localInteger = (Integer)paramMap.get("action");
          if ((localInteger.intValue() != 1) && (localInteger.intValue() != 2) && (localInteger.intValue() != 3)) {
            continue;
          }
          paramString.put("action", localInteger);
          if (paramMap.containsKey("height")) {
            paramString.put("height", paramMap.get("height"));
          }
          if (paramMap.containsKey("index")) {
            paramString.put("index", paramMap.get("index"));
          }
          if (paramMap.containsKey("gameData")) {
            paramString.put("gameData", paramMap.get("gameData"));
          }
        }
        catch (ClassCastException paramMap)
        {
          Integer localInteger;
          paramMap.printStackTrace();
          continue;
        }
        catch (JSONException paramMap)
        {
          paramMap.printStackTrace();
          continue;
        }
        dispatchJsEvent("gameFeedsEvent", paramString, null);
        return true;
        if (localInteger.intValue() == 4)
        {
          paramString.put("action", localInteger);
          paramString.put("perfData", paramMap.get("perfData"));
        }
      }
    }
    if (paramLong == 8589934625L) {
      dispatchJsEvent("gameFeedsPause", new JSONObject(), null);
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (a.equals(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGameWebViewJsPlugin", 1, "pkgName:" + paramString2 + " method:" + paramString3);
      }
      if ("notifyWebLoaded".equals(paramString3))
      {
        paramJsBridgeListener = new Intent("action_qgame_jaspi_webloaded");
        paramJsBridgeListener.setPackage(BaseApplicationImpl.getApplication().getPackageName());
        BaseApplicationImpl.getApplication().sendBroadcast(paramJsBridgeListener);
        return true;
      }
      if ("playVideo".equals(paramString3))
      {
        paramJsBridgeListener = new Intent("action_qgame_h5_video_play");
        paramJsBridgeListener.setPackage(BaseApplicationImpl.getApplication().getPackageName());
        BaseApplicationImpl.getApplication().sendBroadcast(paramJsBridgeListener);
        return true;
      }
      if ("videoPause".equals(paramString3))
      {
        paramJsBridgeListener = new Intent("action_qgame_h5_video_pause");
        paramJsBridgeListener.setPackage(BaseApplicationImpl.getApplication().getPackageName());
        BaseApplicationImpl.getApplication().sendBroadcast(paramJsBridgeListener);
        return true;
      }
      if ("getFriendInfo".equals(paramString3))
      {
        if (paramVarArgs.length <= 0)
        {
          a(null);
          return true;
        }
        a(paramVarArgs[0]);
        return true;
      }
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("QQGameWebViewJsPlugin", 2, "onActivityResult requestCode = " + paramByte + " resultCode = " + paramInt);
    }
    if (paramInt == -1) {
      if (paramByte == 33) {
        a(paramIntent);
      }
    }
    while (paramByte != 33) {
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameWebViewJsPlugin
 * JD-Core Version:    0.7.0.1
 */