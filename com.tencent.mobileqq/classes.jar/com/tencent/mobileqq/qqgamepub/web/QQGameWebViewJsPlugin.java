package com.tencent.mobileqq.qqgamepub.web;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
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
    return ((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).getCurrentContext(this.mRuntime);
  }
  
  private JSONArray a(List<String> paramList1, List<String> paramList2, List<Integer> paramList3, List<Integer> paramList4, JSONArray paramJSONArray)
  {
    Object localObject = paramJSONArray;
    if (paramList1 != null)
    {
      localObject = paramJSONArray;
      if (paramList2 != null)
      {
        localObject = paramJSONArray;
        if (paramList3 != null)
        {
          localObject = paramJSONArray;
          if (paramList4 != null)
          {
            JSONArray localJSONArray = new JSONArray();
            int i = 0;
            for (;;)
            {
              localObject = localJSONArray;
              if (i >= paramList1.size()) {
                break;
              }
              localObject = localJSONArray;
              if (i >= paramList2.size()) {
                break;
              }
              localObject = localJSONArray;
              if (i >= paramList3.size()) {
                break;
              }
              localObject = localJSONArray;
              if (i >= paramList4.size()) {
                break;
              }
              boolean bool = TextUtils.isEmpty((CharSequence)paramList1.get(i));
              localObject = "";
              if (!bool) {
                paramJSONArray = (String)paramList1.get(i);
              } else {
                paramJSONArray = "";
              }
              if (!TextUtils.isEmpty((CharSequence)paramList2.get(i))) {
                localObject = (String)paramList2.get(i);
              }
              int j;
              if (paramList3.get(i) != null) {
                j = ((Integer)paramList3.get(i)).intValue();
              } else {
                j = 0;
              }
              int k;
              if (paramList4.get(i) != null) {
                k = ((Integer)paramList4.get(i)).intValue();
              } else {
                k = 0;
              }
              if ((k == 4) || (k == 8))
              {
                JSONObject localJSONObject = new JSONObject();
                localJSONObject.put("uin", paramJSONArray);
                localJSONObject.put("name", localObject);
                localJSONObject.put("type", k);
                localJSONObject.put("count", j);
                localJSONArray.put(localJSONObject);
              }
              i += 1;
            }
          }
        }
      }
    }
    return localObject;
  }
  
  private void a(String paramString)
  {
    Context localContext = a();
    JSONArray localJSONArray;
    ArrayList localArrayList;
    if ((localContext != null) && (!TextUtils.isEmpty(paramString)))
    {
      localJSONArray = null;
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        this.b = paramString.optString("callback");
        String str1 = paramString.optString("title");
        boolean bool = Boolean.parseBoolean(paramString.optString("isMulti", "false"));
        int i2 = paramString.optInt("limitNum");
        int i3 = paramString.optInt("business_type");
        String str2 = paramString.optString("gameappid");
        Object localObject = paramString.optJSONObject("from_group");
        int k;
        int m;
        int n;
        int j;
        if (localObject != null)
        {
          paramString = ((JSONObject)localObject).optString("group_uin");
          int i1 = ((JSONObject)localObject).optInt("group_type");
          k = ((JSONObject)localObject).optInt("enable_select_all");
          m = ((JSONObject)localObject).optInt("enable_show_myself");
          n = ((JSONObject)localObject).optInt("enable_filter_robot");
          if (1 != i3) {
            break label311;
          }
          i = ((JSONObject)localObject).optInt("game_req_info_flag");
          localJSONArray = ((JSONObject)localObject).optJSONArray("group_members");
          if (localJSONArray != null)
          {
            j = 0;
            if (j < localJSONArray.length())
            {
              localObject = localJSONArray.optString(j);
              if (!TextUtils.isEmpty((CharSequence)localObject)) {
                localArrayList.add(localObject);
              }
              j += 1;
              continue;
            }
          }
          j = i1;
        }
        else
        {
          j = 0;
          k = 0;
          m = 0;
          n = 0;
          i = 0;
          paramString = localJSONArray;
        }
        if (bool)
        {
          if (i2 < 0)
          {
            b();
            return;
          }
          super.startActivityForResult(a(localContext, str1, i3, i2, paramString, j, localArrayList, k, m, n, i, str2), (byte)33);
        }
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        b();
        return;
      }
      b();
      return;
      label311:
      int i = 0;
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doCallback: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" js: ");
    localStringBuilder.append(paramString2);
    QLog.i("QQGamePub_QQGameWebViewJsPlugin", 2, localStringBuilder.toString());
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      super.callJs(paramString1, new String[] { paramString2 });
    }
  }
  
  private void b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("code", "-1");
      localJSONObject.put("msg", "error, parameters wrong...");
      label26:
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("errorCallBack: ");
      localStringBuilder.append(localJSONObject);
      QLog.i("QQGamePub_QQGameWebViewJsPlugin", 2, localStringBuilder.toString());
      a(this.b, localJSONObject.toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      break label26;
    }
  }
  
  private void b(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    try
    {
      ArrayList localArrayList = a(paramIntent);
      if ((localArrayList != null) && (localArrayList.size() != 0))
      {
        paramIntent = a(paramIntent, localArrayList);
        if (paramIntent == null) {
          break label58;
        }
        a(this.b, paramIntent.toString());
        return;
      }
      b();
      return;
    }
    catch (Exception paramIntent)
    {
      label54:
      label58:
      break label54;
    }
    b();
  }
  
  private void b(List<String> paramList1, List<String> paramList2, List<Integer> paramList, List<String> paramList3, JSONArray paramJSONArray)
  {
    if ((paramList1 != null) && (paramList2 != null))
    {
      int i = 0;
      while ((i < paramList1.size()) && (i < paramList2.size()))
      {
        boolean bool = TextUtils.isEmpty((CharSequence)paramList1.get(i));
        Object localObject2 = "";
        String str1;
        if (!bool) {
          str1 = (String)paramList1.get(i);
        } else {
          str1 = "";
        }
        String str2;
        if (!TextUtils.isEmpty((CharSequence)paramList2.get(i))) {
          str2 = (String)paramList2.get(i);
        } else {
          str2 = "";
        }
        Object localObject1 = localObject2;
        if (paramList3 != null)
        {
          localObject1 = localObject2;
          if (paramList3.size() - 1 >= i)
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty((CharSequence)paramList3.get(i))) {
              localObject1 = (String)paramList3.get(i);
            }
          }
        }
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("uin", str1);
        ((JSONObject)localObject2).put("name", str2);
        ((JSONObject)localObject2).put("levelIcon", localObject1);
        if ((paramList != null) && (paramList.size() > i)) {
          ((JSONObject)localObject2).put("type", paramList.get(i));
        } else {
          ((JSONObject)localObject2).put("type", 1);
        }
        paramJSONArray.put(localObject2);
        i += 1;
      }
    }
  }
  
  public Intent a(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3, ArrayList<String> paramArrayList, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString3)
  {
    paramContext = ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).getStartSelectMemberActivityIntentForJsPlugin(paramContext);
    paramContext.putExtra("param_donot_need_contacts", true);
    paramContext.putExtra("param_min", 1);
    if (paramInt2 > 0) {
      paramContext.putExtra("param_max", paramInt2);
    }
    paramContext.putExtra("param_title", paramString1);
    paramContext.putExtra("param_entrance", 43);
    paramContext.putExtra("GAME_H5_SELECT_BUSINESS_TYPE", paramInt1);
    paramContext.putExtra("GAME_H5_SELECT_GAME_APPID", paramString3);
    paramContext.addFlags(67108864);
    if ((!TextUtils.isEmpty(paramString2)) && ((paramInt3 == 4) || (paramInt3 == 8)))
    {
      paramContext.putExtra("param_overload_tips_include_default_count", true);
      paramContext.putExtra("group_uin", paramString2);
      boolean bool2 = false;
      if (paramInt4 != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramContext.putExtra("param_enable_all_select", bool1);
      if (paramInt5 != 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramContext.putExtra("param_show_myself", bool1);
      boolean bool1 = bool2;
      if (paramInt6 != 0) {
        bool1 = true;
      }
      paramContext.putExtra("filer_robot", bool1);
      if (paramArrayList.size() > 0)
      {
        if (paramArrayList.size() > paramInt2) {
          paramArrayList.subList(paramInt2, paramArrayList.size()).clear();
        }
        paramContext.putExtra("param_uins_selected_friends", paramArrayList);
      }
      if (paramInt3 == 4)
      {
        paramContext.putExtra("param_only_troop_member", true);
        if (1 == paramInt1)
        {
          paramContext.putExtra("game_req_info_flag", paramInt7);
          return paramContext;
        }
      }
      else
      {
        paramContext.putExtra("param_only_discussion_member", true);
        return paramContext;
      }
    }
    else
    {
      paramContext.putExtra("param_only_friends", true);
    }
    return paramContext;
  }
  
  public ArrayList<ResultRecord> a(Intent paramIntent)
  {
    return paramIntent.getParcelableArrayListExtra("result_set");
  }
  
  public JSONObject a(Intent paramIntent, ArrayList<ResultRecord> paramArrayList)
  {
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
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      ResultRecord localResultRecord = (ResultRecord)paramArrayList.next();
      ((List)localObject1).add(localResultRecord.uin);
      ((List)localObject2).add(localResultRecord.name);
      localArrayList5.add(Integer.valueOf(i));
      localArrayList6.add(localResultRecord.gameLevelIcon);
    }
    paramIntent = a(paramIntent, (List)localObject1, (List)localObject2, localArrayList5, localArrayList6, localArrayList1, localArrayList2, localArrayList4, localArrayList3);
    paramArrayList = new StringBuilder();
    paramArrayList.append("doChooseFriendResult: ");
    paramArrayList.append(paramIntent);
    QLog.i("QQGamePub_QQGameWebViewJsPlugin", 2, paramArrayList.toString());
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("doChooseFriendResult: ");
      paramArrayList.append(paramIntent);
      QLog.i("QQGamePub_QQGameWebViewJsPlugin", 2, paramArrayList.toString());
    }
    return paramIntent;
  }
  
  protected JSONObject a(Intent paramIntent, List<String> paramList1, List<String> paramList2, List<Integer> paramList3, List<String> paramList4, List<String> paramList5, List<String> paramList6, List<Integer> paramList7, List<Integer> paramList8)
  {
    try
    {
      paramIntent = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      b(paramList1, paramList2, paramList3, paramList4, localJSONArray);
      paramList1 = a(paramList5, paramList6, paramList7, paramList8, null);
      paramIntent.put("friends", localJSONArray);
      if ((paramList1 != null) && (paramList1.length() > 0)) {
        paramIntent.put("groups", paramList1);
      }
      if (QLog.isColorLevel()) {
        QLog.i("QQGamePub_QQGameWebViewJsPlugin", 2, paramIntent.toString());
      }
      return paramIntent;
    }
    catch (JSONException paramIntent)
    {
      paramIntent.printStackTrace();
    }
    return null;
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 8589934621L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    super.handleEvent(paramString, paramLong, paramMap);
    if (paramLong == 8589934621L)
    {
      paramString = new JSONObject();
      if (paramMap != null)
      {
        try
        {
          Integer localInteger = (Integer)paramMap.get("action");
          if ((localInteger.intValue() != 1) && (localInteger.intValue() != 2) && (localInteger.intValue() != 3))
          {
            if (localInteger.intValue() == 4)
            {
              paramString.put("action", localInteger);
              paramString.put("perfData", paramMap.get("perfData"));
            }
          }
          else
          {
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
        }
        catch (JSONException paramMap) {}catch (ClassCastException paramMap)
        {
          break label239;
        }
        paramMap.printStackTrace();
        break label244;
        label239:
        paramMap.printStackTrace();
      }
      label244:
      dispatchJsEvent("gameFeedsEvent", paramString, null);
      return true;
    }
    if (paramLong == 8589934625L) {
      dispatchJsEvent("gameFeedsPause", new JSONObject(), null);
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (a.equals(paramString2))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pkgName:");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(" method:");
        localStringBuilder.append(paramString3);
        QLog.d("QQGamePub_QQGameWebViewJsPlugin", 1, localStringBuilder.toString());
      }
      if ("notifyWebLoaded".equals(paramString3))
      {
        paramJsBridgeListener = new Intent("action_qgame_jaspi_webloaded");
        paramJsBridgeListener.setPackage(MobileQQ.sMobileQQ.getPackageName());
        MobileQQ.sMobileQQ.sendBroadcast(paramJsBridgeListener);
        return true;
      }
      if ("playVideo".equals(paramString3))
      {
        paramJsBridgeListener = new Intent("action_qgame_h5_video_play");
        paramJsBridgeListener.setPackage(MobileQQ.sMobileQQ.getPackageName());
        MobileQQ.sMobileQQ.sendBroadcast(paramJsBridgeListener);
        return true;
      }
      if ("videoPause".equals(paramString3))
      {
        paramJsBridgeListener = new Intent("action_qgame_h5_video_pause");
        paramJsBridgeListener.setPackage(MobileQQ.sMobileQQ.getPackageName());
        MobileQQ.sMobileQQ.sendBroadcast(paramJsBridgeListener);
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityResult requestCode = ");
      localStringBuilder.append(paramByte);
      localStringBuilder.append(" resultCode = ");
      localStringBuilder.append(paramInt);
      QLog.i("QQGamePub_QQGameWebViewJsPlugin", 2, localStringBuilder.toString());
    }
    if (paramInt == -1)
    {
      if (paramByte == 33) {
        b(paramIntent);
      }
    }
    else if (paramByte == 33) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.web.QQGameWebViewJsPlugin
 * JD-Core Version:    0.7.0.1
 */