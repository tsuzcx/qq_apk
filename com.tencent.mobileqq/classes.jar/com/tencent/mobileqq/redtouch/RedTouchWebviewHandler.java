package com.tencent.mobileqq.redtouch;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import aser;
import asev;
import bbav;
import bbaz;
import bhmi;
import bioy;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RedTouchWebviewHandler
  extends VasWebviewJsPlugin
{
  private static final String ERRMSG_EXCEPTION = "exception";
  private static final String ERRMSG_FAILED = "failed";
  private static final String ERRMSG_NO_DATA = "data not prepared or cannot find the path, try again.";
  private static final String ERRMSG_SUCCESS = "success";
  public static final int INTVALUE_UNKNOWN = -1;
  public static final String KEY_CALLBACK = "callback";
  public static final String KEY_ERROR_MSG = "errorMessage";
  public static final String KEY_PATH = "path";
  public static final String KEY_RESULT = "ret";
  public static final String KEY_SRC_TYPE = "srcType";
  public static final String KEY_TYPE = "type";
  public static final int LEBA_ITEM_OFF = 0;
  public static final int LEBA_ITEM_ON = 1;
  public static final String METHOD_GET_LEBA_STATE = "getDynamicState";
  public static final String METHOD_SET_LEBA_STATE = "setDynamicState";
  private static final String OBJECT_NAME = "redpoint";
  public static final String PLUGIN_NAMESPACE = "redpoint";
  public static final String REDBUFFERJSON_2722 = "2722";
  public static final String REDBUFFERJSON_PARAM = "param";
  public static String TAG = "RedTouchWebviewHandler";
  public static final int VALUE_EXCEPTION = -1;
  public static final int VALUE_FAILED = 1;
  public static final int VALUE_SUCCESS = 0;
  private AppInterface browserApp;
  
  public RedTouchWebviewHandler()
  {
    this.mPluginNameSpace = "redpoint";
  }
  
  @NotNull
  private JSONObject buidRedJson(List<BusinessInfoCheckUpdate.RedTypeInfo> paramList)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramList != null)
    {
      int i = 0;
      while (i < paramList.size())
      {
        localJSONObject.put("red_type", ((BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(i)).red_type.get());
        localJSONObject.put("red_content", ((BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(i)).red_content.get());
        localJSONObject.put("red_desc", ((BusinessInfoCheckUpdate.RedTypeInfo)paramList.get(i)).red_desc.get());
        i += 1;
      }
    }
    return localJSONObject;
  }
  
  private List<String> buildPaths(List<String> paramList, JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      for (;;)
      {
        paramList = localArrayList;
        if (i >= paramJSONArray.length()) {
          break;
        }
        paramList = paramJSONArray.optString(i, "");
        if (!TextUtils.isEmpty(paramList)) {
          localArrayList.add(paramList);
        }
        i += 1;
      }
    }
    return paramList;
  }
  
  @NotNull
  private JSONObject buildRedJson(List<BusinessInfoCheckUpdate.RedTypeInfo> paramList)
  {
    return buidRedJson(paramList);
  }
  
  private BusinessInfoCheckUpdate.AppInfo getAppInfoByPath(String paramString)
  {
    if ((this.browserApp == null) || (TextUtils.isEmpty(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "getappinfo path or browserapp = null");
      }
      paramString = null;
    }
    Object localObject1;
    label146:
    do
    {
      return paramString;
      localObject1 = new File(this.browserApp.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_1_" + this.browserApp.getCurrentAccountUin());
      if (!((File)localObject1).exists()) {}
      try
      {
        ((File)localObject1).createNewFile();
        localObject2 = new BusinessInfoCheckUpdate.TimeRspBody();
      }
      catch (IOException paramString)
      {
        try
        {
          localObject1 = bhmi.a((File)localObject1);
          if (localObject1 != null) {
            break label146;
          }
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getappinfo body = null");
          }
          return null;
        }
        finally {}
        paramString = paramString;
        paramString.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "getappinfo create file exception ");
        }
        return null;
      }
      try
      {
        ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).mergeFrom((byte[])localObject1);
        if ((localObject2 == null) || (!((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgAppInfo.has()))
        {
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getappinfo localTimeRspBody null ");
          }
          return null;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "getappinfo mergeFrom exception ");
        }
        return null;
      }
      Object localObject2 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgAppInfo.get().iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject2).next();
      } while (!((BusinessInfoCheckUpdate.AppInfo)localObject1).path.get().equals(paramString));
      paramString = (String)localObject1;
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, "getappinfo path= " + ((BusinessInfoCheckUpdate.AppInfo)localObject1).path.get() + ";inewflag = " + ((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.get());
    return localObject1;
    return null;
  }
  
  private List<BusinessInfoCheckUpdate.AppInfo> getAppInfoListByPath(List<String> paramList)
  {
    if ((this.browserApp == null) || (paramList == null) || (paramList.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "getappinfolist paths is empty or browserapp = null");
      }
    }
    label152:
    do
    {
      for (;;)
      {
        return null;
        localObject1 = new File(this.browserApp.getApplication().getFilesDir(), "BusinessInfoCheckUpdateItem_new_1_" + this.browserApp.getCurrentAccountUin());
        if (!((File)localObject1).exists()) {}
        try
        {
          ((File)localObject1).createNewFile();
        }
        catch (IOException paramList)
        {
          try
          {
            localObject1 = bhmi.a((File)localObject1);
            if (localObject1 != null) {
              break label152;
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i(TAG, 2, "getappinfolist body = null");
            return null;
          }
          finally {}
          paramList = paramList;
          paramList.printStackTrace();
        }
        if (QLog.isColorLevel())
        {
          QLog.i(TAG, 2, "getappinfolist create file exception ");
          return null;
          localObject2 = new BusinessInfoCheckUpdate.TimeRspBody();
          try
          {
            ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).mergeFrom((byte[])localObject1);
            if ((localObject2 != null) && (((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgAppInfo.has())) {
              break label221;
            }
            if (QLog.isColorLevel())
            {
              QLog.i(TAG, 2, "getappinfolist localTimeRspBody null ");
              return null;
            }
          }
          catch (Exception paramList)
          {
            paramList.printStackTrace();
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i(TAG, 2, "getappinfolist mergeFrom exception ");
    return null;
    label221:
    Object localObject1 = ((BusinessInfoCheckUpdate.TimeRspBody)localObject2).rptMsgAppInfo.get();
    Object localObject2 = new ArrayList();
    paramList = paramList.iterator();
    for (;;)
    {
      if (!paramList.hasNext()) {
        return localObject2;
      }
      String str = (String)paramList.next();
      Iterator localIterator = ((List)localObject1).iterator();
      if (localIterator.hasNext())
      {
        BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)localIterator.next();
        if (!localAppInfo.path.get().equals(str)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "getappinfolist path= " + localAppInfo.path.get() + ";inewflag = " + localAppInfo.iNewFlag.get());
        }
        ((List)localObject2).add(localAppInfo);
      }
    }
    return localObject2;
  }
  
  private JSONObject getRedBufferJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = null;
    }
    for (;;)
    {
      return paramJSONObject;
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        JSONObject localJSONObject2 = paramJSONObject.getJSONObject("param");
        if (localJSONObject2 == null) {
          return null;
        }
        Iterator localIterator = localJSONObject2.keys();
        paramJSONObject = localJSONObject1;
        if (localIterator.hasNext())
        {
          paramJSONObject = localJSONObject2.getJSONObject((String)localIterator.next());
          return paramJSONObject;
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    return null;
  }
  
  private int getReddot(List<BusinessInfoCheckUpdate.AppInfo> paramList, int paramInt)
  {
    int i = paramInt;
    if (this.mRuntime != null)
    {
      i = paramInt;
      if (this.mRuntime.a() != null)
      {
        i = paramInt;
        if (paramList != null)
        {
          i = paramInt;
          if (!paramList.isEmpty())
          {
            Object localObject = new bbav(this.mRuntime.a());
            i = paramInt;
            if (localObject != null)
            {
              localObject = ((bbav)localObject).a();
              paramList = ((BusinessInfoCheckUpdate.AppInfo)paramList.get(0)).path.get();
              i = paramInt;
              if (!TextUtils.isEmpty(paramList))
              {
                i = paramInt;
                if (paramList.equals(localObject)) {
                  i = 1;
                }
              }
            }
          }
        }
      }
    }
    return i;
  }
  
  private String getReportBufferString(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    JSONArray localJSONArray;
    JSONObject localJSONObject1;
    for (;;)
    {
      try
      {
        localJSONArray = new JSONArray();
        localJSONObject1 = new JSONObject();
        paramString = new JSONObject(paramString);
        if (paramString.has("msg"))
        {
          paramString = paramString.getJSONObject("msg");
          if (paramString == null) {
            break;
          }
          Iterator localIterator = paramString.keys();
          if (!localIterator.hasNext()) {
            break;
          }
          JSONObject localJSONObject2 = new JSONObject();
          String str = (String)localIterator.next();
          localObject = paramString.getJSONObject(str);
          if (!((JSONObject)localObject).has("stat")) {
            break label174;
          }
          i = ((JSONObject)localObject).getInt("stat");
          if (i != 1) {
            continue;
          }
          if (!((JSONObject)localObject).has("content")) {
            break label179;
          }
          localObject = ((JSONObject)localObject).getString("content");
          localJSONObject2.put(str, localObject);
          localJSONArray.put(localJSONObject2);
          continue;
        }
        paramString = null;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return "";
      }
      continue;
      label174:
      int i = -1;
      continue;
      label179:
      Object localObject = "";
    }
    localJSONObject1.put("msg", localJSONArray);
    paramString = localJSONObject1.toString();
    return paramString;
  }
  
  private void handleGetAppinfo(String paramString, Bundle paramBundle)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    String str3 = paramBundle.getString("serial");
    BusinessInfoCheckUpdate.AppInfo localAppInfo = bbaz.a((RedAppInfo)paramBundle.getParcelable("redInfo"));
    j = -2;
    paramBundle = "";
    i = 0;
    String str2 = "";
    localArrayList = new ArrayList();
    localObject1 = str2;
    localObject2 = paramBundle;
    if (localAppInfo != null)
    {
      str1 = str2;
      localBundle = paramBundle;
    }
    for (;;)
    {
      try
      {
        localObject1 = localAppInfo.red_display_info.red_type_info.get();
        str1 = str2;
        localBundle = paramBundle;
        str2 = localAppInfo.path.get();
        str1 = str2;
        localBundle = paramBundle;
        if (localAppInfo.type.get() != -1) {
          continue;
        }
        m = -3;
        k = 0;
        str1 = str2;
        localBundle = paramBundle;
        localArrayList.add("");
        str1 = str2;
        localBundle = paramBundle;
        localJSONObject1.put("code", -3);
        str1 = str2;
        localBundle = paramBundle;
        localJSONObject1.put("errorMessage", "appInfo not found");
        localObject1 = str2;
        i = k;
        localObject2 = paramBundle;
        j = m;
        str1 = str2;
        localBundle = paramBundle;
        if (QLog.isColorLevel())
        {
          str1 = str2;
          localBundle = paramBundle;
          QLog.i(TAG, 2, "getAppInfo:" + localJSONObject1.toString());
          j = m;
          localObject2 = paramBundle;
          i = k;
          localObject1 = str2;
        }
      }
      catch (JSONException paramBundle)
      {
        int m;
        int k;
        paramBundle.printStackTrace();
        j = -4;
        i = 0;
        localArrayList.add("");
        localObject1 = str1;
        localObject2 = localBundle;
        continue;
      }
      paramBundle = new bbav(this.mRuntime.a()).a();
      k = i;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        k = i;
        if (((String)localObject1).equals(paramBundle)) {
          k = 1;
        }
      }
      paramBundle = new Bundle();
      paramBundle.putString("ret", String.valueOf(j));
      paramBundle.putString("buffer", (String)localObject2);
      paramBundle.putString("red", String.valueOf(k));
      paramBundle.putStringArrayList("missions", localArrayList);
      paramBundle.putString("path", (String)localObject1);
      paramBundle.putString("serial", str3);
      paramBundle.putString("callback", paramString);
      super.sendRemoteReq(asev.a("redTouch_getAppInfo_report", paramString, this.mOnRemoteResp.key, paramBundle), false, true);
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "getAppinfo response:" + localJSONObject1.toString());
      }
      callJs(paramString, new String[] { localJSONObject1.toString() });
      return;
      m = 0;
      str1 = str2;
      localBundle = paramBundle;
      localJSONObject1.put("code", 0);
      str1 = str2;
      localBundle = paramBundle;
      localJSONObject2.put("appID", localAppInfo.uiAppId.get());
      str1 = str2;
      localBundle = paramBundle;
      localJSONObject2.put("iNewFlag", localAppInfo.iNewFlag.get());
      str1 = str2;
      localBundle = paramBundle;
      k = localAppInfo.iNewFlag.get();
      str1 = str2;
      localBundle = paramBundle;
      localObject2 = new JSONArray();
      i = 0;
      str1 = str2;
      localBundle = paramBundle;
      if (i < localAppInfo.missions.size())
      {
        str1 = str2;
        localBundle = paramBundle;
        ((JSONArray)localObject2).put(localAppInfo.missions.get(i));
        str1 = str2;
        localBundle = paramBundle;
        localArrayList.add(localAppInfo.missions.get(i));
        i += 1;
      }
      else
      {
        str1 = str2;
        localBundle = paramBundle;
        localJSONObject2.put("redInfo", buidRedJson((List)localObject1));
        str1 = str2;
        localBundle = paramBundle;
        localJSONObject2.put("missions", localObject2);
        str1 = str2;
        localBundle = paramBundle;
        localJSONObject2.put("type", localAppInfo.type.get());
        str1 = str2;
        localBundle = paramBundle;
        localJSONObject2.put("buffer", localAppInfo.buffer.get());
        str1 = str2;
        localBundle = paramBundle;
        localJSONObject2.put("path", localAppInfo.path.get());
        str1 = str2;
        localBundle = paramBundle;
        localJSONObject2.put("appset", localAppInfo.appset.get());
        str1 = str2;
        localBundle = paramBundle;
        localJSONObject2.put("modify_ts", localAppInfo.modify_ts.get());
        str1 = str2;
        localBundle = paramBundle;
        localJSONObject2.put("num", localAppInfo.num.get());
        str1 = str2;
        localBundle = paramBundle;
        localJSONObject2.put("push_red_ts", localAppInfo.push_red_ts.get());
        str1 = str2;
        localBundle = paramBundle;
        localJSONObject1.put("data", localJSONObject2);
        str1 = str2;
        localBundle = paramBundle;
        paramBundle = getReportBufferString(localAppInfo.buffer.get());
      }
    }
  }
  
  private void handleGetRedpointShowInfo(String paramString, Bundle paramBundle)
  {
    int j = -1;
    localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2;
    if (paramBundle == null)
    {
      paramBundle = null;
      localJSONObject2 = new JSONObject();
    }
    for (;;)
    {
      try
      {
        localJSONObject1.put("code", 0);
        if (paramBundle == null) {
          continue;
        }
        j = paramBundle.getRedType();
        i = 1;
        localJSONObject2.put("hintType", j);
        localJSONObject2.put("number", 0);
        localJSONObject2.put("isShow", i);
        localJSONObject1.put("data", localJSONObject2);
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "getRedPointShowInfo:" + localJSONObject1.toString());
        }
      }
      catch (JSONException paramBundle)
      {
        int i;
        paramBundle.printStackTrace();
        try
        {
          localJSONObject1.put("code", -1);
          localJSONObject1.put("errorMessage", "missing callback");
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
        }
        continue;
      }
      callJs(paramString, new String[] { localJSONObject1.toString() });
      return;
      paramBundle = (RedTypeInfo)paramBundle.getSerializable("redInfo");
      break;
      i = 0;
    }
  }
  
  private void handleLebaItemGet(String paramString, Bundle paramBundle)
  {
    int i = 1;
    int j = -1;
    if (paramBundle == null) {}
    for (;;)
    {
      if (i == 0) {
        j = paramBundle.getInt("type", -1);
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "get leba item result: " + i + ", type: " + j);
      }
      paramBundle = new JSONObject();
      try
      {
        paramBundle.put("ret", i);
        paramBundle.put("type", j);
        if (i == 0) {
          paramBundle.put("errorMessage", "success");
        }
        for (;;)
        {
          callJs(paramString, new String[] { paramBundle.toString() });
          return;
          i = paramBundle.getInt("ret");
          break;
          paramBundle.put("errorMessage", "data not prepared or cannot find the path, try again.");
        }
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private void handleLebaItemSet(String paramString, Bundle paramBundle)
  {
    int i = 1;
    if (paramBundle == null) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "set leba item result: " + i);
      }
      paramBundle = new JSONObject();
      try
      {
        paramBundle.put("ret", i);
        if (i == 0) {
          paramBundle.put("errorMessage", "success");
        }
        for (;;)
        {
          callJs(paramString, new String[] { paramBundle.toString() });
          return;
          i = paramBundle.getInt("ret");
          break;
          paramBundle.put("errorMessage", "failed");
        }
        return;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private void handleRedInfoResponse(String paramString, Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str;
    do
    {
      do
      {
        do
        {
          return;
          paramBundle.setClassLoader(RedAppInfo.class.getClassLoader());
          str = paramBundle.getString("subCmd");
        } while (str == null);
        if ("redTouch_getIndividuationType".equals(str))
        {
          handlegetIndivationType(paramString, paramBundle);
          return;
        }
      } while ("redTouch_reportRedTouch".equals(str));
      if ("redTouch_reportBusinessRedTouch".equals(str))
      {
        handleReportRedtouch(paramString, paramBundle);
        return;
      }
      if ("redTouch_getAppInfo".equals(str))
      {
        handleGetAppinfo(paramString, paramBundle);
        return;
      }
    } while (!"redTouch_getRedPointShowInfo_path".equals(str));
    handlegetRedpointShowInfoPath(paramString, paramBundle);
  }
  
  /* Error */
  private void handleReportRedtouch(String paramString, Bundle paramBundle)
  {
    // Byte code:
    //   0: new 120	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 121	org/json/JSONObject:<init>	()V
    //   7: astore 5
    //   9: aload_2
    //   10: ldc_w 397
    //   13: invokevirtual 401	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   16: checkcast 403	com/tencent/mobileqq/redtouch/RedAppInfo
    //   19: astore 8
    //   21: aload_2
    //   22: ldc 29
    //   24: invokevirtual 395	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore 9
    //   29: aload_2
    //   30: ldc_w 575
    //   33: invokevirtual 395	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore_2
    //   37: new 120	org/json/JSONObject
    //   40: dup
    //   41: aload_2
    //   42: invokespecial 368	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   45: astore 7
    //   47: aload_0
    //   48: getfield 351	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mRuntime	Lbioy;
    //   51: invokevirtual 578	bioy:a	()Landroid/app/Activity;
    //   54: astore_2
    //   55: new 580	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody
    //   58: dup
    //   59: invokespecial 581	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:<init>	()V
    //   62: astore 6
    //   64: aload 6
    //   66: getfield 585	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   69: aload_0
    //   70: getfield 351	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mRuntime	Lbioy;
    //   73: invokevirtual 356	bioy:a	()Lcom/tencent/common/app/AppInterface;
    //   76: invokevirtual 235	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   79: invokestatic 591	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   82: invokevirtual 597	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   85: aload 6
    //   87: getfield 600	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:clientver	Lcom/tencent/mobileqq/pb/PBStringField;
    //   90: ldc_w 602
    //   93: invokevirtual 604	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   96: aload 6
    //   98: getfield 607	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:platid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   101: bipush 109
    //   103: invokevirtual 610	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   106: aload 6
    //   108: getfield 613	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   111: aload 9
    //   113: invokestatic 615	bbav:a	(Ljava/lang/String;)I
    //   116: invokevirtual 610	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   119: aload 6
    //   121: getfield 618	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:platver	Lcom/tencent/mobileqq/pb/PBStringField;
    //   124: new 225	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   131: getstatic 623	android/os/Build$VERSION:SDK_INT	I
    //   134: invokevirtual 320	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   137: ldc 176
    //   139: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokevirtual 604	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   148: aload 8
    //   150: invokevirtual 625	com/tencent/mobileqq/redtouch/RedAppInfo:a	()Ljava/util/List;
    //   153: ifnull +16 -> 169
    //   156: aload 6
    //   158: getfield 628	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:missionid	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   161: aload 8
    //   163: invokevirtual 625	com/tencent/mobileqq/redtouch/RedAppInfo:a	()Ljava/util/List;
    //   166: invokevirtual 631	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   169: new 168	java/util/ArrayList
    //   172: dup
    //   173: invokespecial 169	java/util/ArrayList:<init>	()V
    //   176: astore 8
    //   178: aload 7
    //   180: invokevirtual 346	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   183: astore 9
    //   185: aload 9
    //   187: invokeinterface 293 1 0
    //   192: ifeq +156 -> 348
    //   195: aload 9
    //   197: invokeinterface 297 1 0
    //   202: checkcast 303	java/lang/String
    //   205: astore 10
    //   207: new 633	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData
    //   210: dup
    //   211: invokespecial 634	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData:<init>	()V
    //   214: astore 11
    //   216: aload 11
    //   218: getfield 636	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData:key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   221: aload 10
    //   223: invokevirtual 604	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   226: aload 11
    //   228: getfield 639	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData:value	Lcom/tencent/mobileqq/pb/PBStringField;
    //   231: aload 7
    //   233: aload 10
    //   235: invokevirtual 384	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   238: invokevirtual 604	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   241: aload 8
    //   243: aload 11
    //   245: invokeinterface 190 2 0
    //   250: pop
    //   251: getstatic 645	java/lang/System:out	Ljava/io/PrintStream;
    //   254: new 225	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   261: ldc_w 647
    //   264: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload 11
    //   269: getfield 636	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData:key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   272: invokevirtual 156	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   275: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: ldc_w 649
    //   281: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: aload 11
    //   286: getfield 639	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData:value	Lcom/tencent/mobileqq/pb/PBStringField;
    //   289: invokevirtual 156	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   292: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokevirtual 654	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   301: goto -116 -> 185
    //   304: astore_2
    //   305: aload 5
    //   307: ldc_w 422
    //   310: iconst_m1
    //   311: invokevirtual 146	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   314: pop
    //   315: aload 5
    //   317: ldc 26
    //   319: ldc_w 656
    //   322: invokevirtual 159	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   325: pop
    //   326: aload_2
    //   327: invokevirtual 347	org/json/JSONException:printStackTrace	()V
    //   330: aload_0
    //   331: aload_1
    //   332: iconst_1
    //   333: anewarray 303	java/lang/String
    //   336: dup
    //   337: iconst_0
    //   338: aload 5
    //   340: invokevirtual 388	org/json/JSONObject:toString	()Ljava/lang/String;
    //   343: aastore
    //   344: invokevirtual 471	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   347: return
    //   348: new 120	org/json/JSONObject
    //   351: dup
    //   352: invokespecial 121	org/json/JSONObject:<init>	()V
    //   355: astore 7
    //   357: aload 7
    //   359: ifnull +13 -> 372
    //   362: aload 7
    //   364: ldc_w 658
    //   367: iconst_5
    //   368: invokevirtual 146	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   371: pop
    //   372: aload 6
    //   374: getfield 659	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   377: aload 7
    //   379: invokevirtual 388	org/json/JSONObject:toString	()Ljava/lang/String;
    //   382: invokevirtual 604	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   385: aload 6
    //   387: getfield 662	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:reportdata	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   390: aload 8
    //   392: invokevirtual 663	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
    //   395: new 665	com/tencent/qphone/base/remote/ToServiceMsg
    //   398: dup
    //   399: ldc_w 667
    //   402: aload_0
    //   403: getfield 351	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mRuntime	Lbioy;
    //   406: invokevirtual 356	bioy:a	()Lcom/tencent/common/app/AppInterface;
    //   409: invokevirtual 235	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   412: ldc_w 669
    //   415: invokespecial 672	com/tencent/qphone/base/remote/ToServiceMsg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   418: astore 7
    //   420: aload 7
    //   422: aload 6
    //   424: invokevirtual 676	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:toByteArray	()[B
    //   427: invokevirtual 680	com/tencent/qphone/base/remote/ToServiceMsg:putWupBuffer	([B)V
    //   430: aload 7
    //   432: getfield 684	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   435: ldc_w 686
    //   438: iconst_1
    //   439: invokevirtual 690	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   442: aload 7
    //   444: invokevirtual 693	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   447: arraylength
    //   448: i2l
    //   449: lstore_3
    //   450: lload_3
    //   451: l2i
    //   452: iconst_4
    //   453: iadd
    //   454: newarray byte
    //   456: astore 6
    //   458: aload 6
    //   460: iconst_0
    //   461: ldc2_w 694
    //   464: lload_3
    //   465: ladd
    //   466: invokestatic 700	bhvd:a	([BIJ)V
    //   469: aload 6
    //   471: iconst_4
    //   472: aload 7
    //   474: invokevirtual 693	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   477: lload_3
    //   478: l2i
    //   479: invokestatic 703	bhvd:a	([BI[BI)V
    //   482: aload 7
    //   484: aload 6
    //   486: invokevirtual 680	com/tencent/qphone/base/remote/ToServiceMsg:putWupBuffer	([B)V
    //   489: new 705	mqq/app/NewIntent
    //   492: dup
    //   493: aload_2
    //   494: invokevirtual 710	android/app/Activity:getApplication	()Landroid/app/Application;
    //   497: ldc_w 712
    //   500: invokespecial 715	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   503: astore_2
    //   504: aload_2
    //   505: ldc_w 665
    //   508: invokevirtual 718	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   511: aload 7
    //   513: invokevirtual 722	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   516: pop
    //   517: aload_0
    //   518: getfield 351	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mRuntime	Lbioy;
    //   521: invokevirtual 356	bioy:a	()Lcom/tencent/common/app/AppInterface;
    //   524: aload_2
    //   525: invokevirtual 726	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   528: aload 5
    //   530: ldc_w 422
    //   533: iconst_0
    //   534: invokevirtual 146	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   537: pop
    //   538: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   541: ifeq -211 -> 330
    //   544: getstatic 70	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   547: iconst_2
    //   548: new 225	java/lang/StringBuilder
    //   551: dup
    //   552: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   555: ldc_w 728
    //   558: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: aload 5
    //   563: invokevirtual 388	org/json/JSONObject:toString	()Ljava/lang/String;
    //   566: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   572: invokestatic 209	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   575: goto -245 -> 330
    //   578: astore_2
    //   579: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   582: ifeq -252 -> 330
    //   585: getstatic 70	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   588: iconst_2
    //   589: new 225	java/lang/StringBuilder
    //   592: dup
    //   593: invokespecial 226	java/lang/StringBuilder:<init>	()V
    //   596: ldc_w 728
    //   599: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: aload_2
    //   603: invokevirtual 729	java/lang/Exception:toString	()Ljava/lang/String;
    //   606: invokevirtual 232	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   612: invokestatic 209	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   615: goto -285 -> 330
    //   618: astore 6
    //   620: aload 6
    //   622: invokevirtual 347	org/json/JSONException:printStackTrace	()V
    //   625: goto -299 -> 326
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	628	0	this	RedTouchWebviewHandler
    //   0	628	1	paramString	String
    //   0	628	2	paramBundle	Bundle
    //   449	29	3	l	long
    //   7	555	5	localJSONObject	JSONObject
    //   62	423	6	localObject1	Object
    //   618	3	6	localJSONException	JSONException
    //   45	467	7	localObject2	Object
    //   19	372	8	localObject3	Object
    //   27	169	9	localObject4	Object
    //   205	29	10	str	String
    //   214	71	11	localReportStaticsData	com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportStaticsData
    // Exception table:
    //   from	to	target	type
    //   37	169	304	org/json/JSONException
    //   169	185	304	org/json/JSONException
    //   185	301	304	org/json/JSONException
    //   348	357	304	org/json/JSONException
    //   362	372	304	org/json/JSONException
    //   372	575	304	org/json/JSONException
    //   37	169	578	java/lang/Exception
    //   169	185	578	java/lang/Exception
    //   185	301	578	java/lang/Exception
    //   348	357	578	java/lang/Exception
    //   362	372	578	java/lang/Exception
    //   372	575	578	java/lang/Exception
    //   305	326	618	org/json/JSONException
  }
  
  private void handleSetAppInfo(String paramString, Bundle paramBundle)
  {
    int i;
    if (paramBundle == null)
    {
      i = -1;
      paramBundle = new JSONObject();
    }
    for (;;)
    {
      try
      {
        paramBundle.put("code", i);
        if (i != -3) {
          continue;
        }
        paramBundle.put("errorMessage", "appInfo not found");
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "setAppInfo:" + paramBundle.toString());
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
      }
      callJs(paramString, new String[] { paramBundle.toString() });
      return;
      i = paramBundle.getInt("iret");
      break;
      if (i == -4) {
        paramBundle.put("errorMessage", "failed to set appInfo");
      }
    }
  }
  
  private void handlegetIndivationType(String paramString, Bundle paramBundle)
  {
    String str1 = "0";
    localJSONObject1 = new JSONObject();
    localObject = str1;
    for (;;)
    {
      try
      {
        RedAppInfo localRedAppInfo = (RedAppInfo)paramBundle.getParcelable("redInfo");
        localObject = str1;
        String str2 = paramBundle.getString("path");
        paramBundle = str1;
        if (localRedAppInfo != null)
        {
          paramBundle = str1;
          localObject = str1;
          if (localRedAppInfo.b() != 0)
          {
            localObject = str1;
            JSONObject localJSONObject2 = getRedBufferJson(new JSONObject(localRedAppInfo.a()));
            paramBundle = str1;
            if (localJSONObject2 != null)
            {
              localObject = str1;
              if (!localJSONObject2.has("_red_ext_busi_")) {
                continue;
              }
              localObject = str1;
              paramBundle = localJSONObject2.getString("_red_ext_busi_");
            }
          }
        }
        localObject = paramBundle;
        localJSONObject1.put("result", paramBundle);
        localObject = paramBundle;
        onReportRed(bbaz.a(localRedAppInfo), 1002);
        localObject = paramBundle;
        ipcItemClick(str2);
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        try
        {
          localJSONObject1.put("result", localObject);
          callJs(paramString, new String[] { localJSONObject1.toString() });
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
        }
        continue;
      }
      callJs(paramString, new String[] { localJSONObject1.toString() });
      return;
      paramBundle = "0";
    }
  }
  
  private void handlegetRedpointShowInfoPath(String paramString, Bundle paramBundle)
  {
    RedAppInfo localRedAppInfo = (RedAppInfo)paramBundle.getParcelable("redInfo");
    paramBundle = new JSONObject();
    JSONObject localJSONObject = new JSONObject();
    if (localRedAppInfo == null) {}
    try
    {
      paramBundle.put("code", -1);
      paramBundle.put("errorMessage", "missing path");
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "getRedPointShowInfo:" + paramBundle.toString());
        }
        callJs(paramString, new String[] { paramBundle.toString() });
        return;
        if (localRedAppInfo.c() != -1) {
          break;
        }
        paramBundle.put("code", -3);
        paramBundle.put("errorMessage", "appInfo not found");
      }
    }
    catch (JSONException localJSONException1)
    {
      for (;;)
      {
        localJSONException1.printStackTrace();
        try
        {
          paramBundle.put("code", -1);
          paramBundle.put("errorMessage", "missing callback");
        }
        catch (JSONException localJSONException2)
        {
          localJSONException2.printStackTrace();
        }
        continue;
        paramBundle.put("code", 0);
        localJSONObject.put("hintType", localJSONException2.c());
        localJSONObject.put("number", localJSONException2.f());
        localJSONObject.put("isShow", localJSONException2.b());
        paramBundle.put("data", localJSONObject);
      }
    }
  }
  
  private void ipcItemClick(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("path", paramString);
    super.sendRemoteReq(asev.a("myIndividuationRedInfo", null, 0, localBundle), false, true);
  }
  
  private void onReportRed(BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt)
  {
    if ((paramAppInfo == null) || (paramAppInfo.iNewFlag.get() == 0)) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("service_type", 0);
      localJSONObject.put("act_id", paramInt);
      localJSONObject.put("obj_id", "");
      localJSONObject.put("pay_amt", 0);
      localJSONObject.put("service_id", 100005);
      new bbav(this.mRuntime.a()).c(paramAppInfo, localJSONObject.toString());
      return;
    }
    catch (JSONException paramAppInfo)
    {
      paramAppInfo.printStackTrace();
    }
  }
  
  public void getAppInfo(String paramString)
  {
    try
    {
      if (new JSONObject(paramString).has("pathList"))
      {
        getAppInfoList(paramString);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      long l = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "getappinfo js startime : " + l);
      }
      ThreadManager.post(new RedTouchWebviewHandler.1(this, paramString, l), 8, null, true);
    }
  }
  
  public void getAppInfoList(String paramString)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "getappinfolist js startime : " + l);
    }
    ThreadManager.post(new RedTouchWebviewHandler.2(this, paramString, l), 8, null, true);
  }
  
  public void getDynamicState(String paramString)
  {
    String str = null;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      if (localJSONObject1 == null) {
        return;
      }
    }
    catch (Exception localException1)
    {
      Object localObject;
      for (;;)
      {
        localException1.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "Failed to parse json string: " + paramString);
        }
        localObject = null;
      }
      paramString = str;
      try
      {
        str = localObject.getString("callback");
        paramString = str;
        Bundle localBundle = new Bundle();
        paramString = str;
        localBundle.putInt("path", bbav.a(localObject.getString("path")));
        paramString = str;
        sendRemoteReq(asev.a("leba_item_get", str, this.mOnRemoteResp.key, localBundle), false, false);
        return;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        try
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("ret", -1);
          localJSONObject2.put("errorMessage", "exception");
          callJs(paramString, new String[] { localJSONObject2.toString() });
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  public void getIndividuationType(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getString("callback");
      Bundle localBundle = new Bundle();
      localBundle.putString("path", "100005.100022");
      localBundle.putString("subCmd", "redTouch_getIndividuationType");
      super.sendRemoteReq(asev.a("redTouch_getRedInfo", paramString, this.mOnRemoteResp.key, localBundle), false, true);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void getRedPointShowInfo(String paramString)
  {
    localObject2 = "callback";
    localJSONObject = new JSONObject();
    Object localObject1 = localObject2;
    try
    {
      Object localObject3 = new JSONObject(paramString);
      localObject1 = localObject2;
      paramString = ((JSONObject)localObject3).getString("callback");
      localObject1 = paramString;
      int i;
      String str;
      if (!((JSONObject)localObject3).isNull("set"))
      {
        localObject1 = paramString;
        localObject2 = ((JSONObject)localObject3).getString("set");
        try
        {
          i = Integer.parseInt((String)localObject2);
          if ((i != 0) && (i != 1) && (i != 2))
          {
            localObject1 = paramString;
            localJSONObject.put("code", -3);
            localObject1 = paramString;
            localJSONObject.put("errorMessage", "redPoint showInfo not found");
            localObject1 = paramString;
            callJs(paramString, new String[] { localJSONObject.toString() });
            return;
          }
        }
        catch (Exception localException)
        {
          str = paramString;
          localJSONObject.put("code", -3);
          str = paramString;
          localJSONObject.put("errorMessage", "redPoint showInfo not found");
          str = paramString;
          callJs(paramString, new String[] { localJSONObject.toString() });
          return;
        }
      }
      try
      {
        localJSONObject.put("code", -1);
        localJSONObject.put("errorMessage", "missing callback");
        callJs(str, new String[] { localJSONObject.toString() });
        return;
        str = paramString;
        localObject2 = new Bundle();
        str = paramString;
        ((Bundle)localObject2).putInt("setId", i);
        str = paramString;
        super.sendRemoteReq(asev.a("redTouch_getRedPointShowInfo_set", paramString, this.mOnRemoteResp.key, (Bundle)localObject2), false, true);
        return;
        str = paramString;
        if (!((JSONObject)localObject3).isNull("path"))
        {
          str = paramString;
          localObject2 = ((JSONObject)localObject3).getString("path");
          str = paramString;
          localObject3 = new Bundle();
          str = paramString;
          ((Bundle)localObject3).putString("path", (String)localObject2);
          str = paramString;
          ((Bundle)localObject3).putString("subCmd", "redTouch_getRedPointShowInfo_path");
          str = paramString;
          super.sendRemoteReq(asev.a("redTouch_getRedInfo", paramString, this.mOnRemoteResp.key, (Bundle)localObject3), false, true);
          return;
        }
        str = paramString;
        localJSONObject.put("code", -1);
        str = paramString;
        localJSONObject.put("errorMessage", "missing set and path");
        str = paramString;
        callJs(paramString, new String[] { localJSONObject.toString() });
        return;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void getServerTime(String paramString)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString).getString("callback");
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          localJSONObject1.put("time", NetConnInfoCenter.getServerTimeMillis());
          localJSONObject2.put("data", localJSONObject1);
          localJSONObject2.put("code", 0);
          callJs(paramString, new String[] { localJSONObject2.toString() });
          return;
        }
        catch (Exception localException2)
        {
          break label80;
        }
        localException1 = localException1;
        paramString = "callback";
      }
      try
      {
        label80:
        localJSONObject2.put("code", -1);
        localJSONObject2.put("errorMessage", "missing callback");
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    int i = 0;
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase("redpoint"))) {
      return false;
    }
    paramJsBridgeListener = new ArrayList();
    while (i < paramVarArgs.length)
    {
      paramJsBridgeListener.add(paramVarArgs[i]);
      i += 1;
    }
    return call(paramString3, paramJsBridgeListener);
  }
  
  public void isEnterFromRedPoint(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString);
        paramString = ((JSONObject)localObject).getString("callback");
        try
        {
          localObject = ((JSONObject)localObject).getString("path");
          if (!new bbav(this.mRuntime.a()).a().equals(localObject))
          {
            localJSONObject.put("code", 0);
            localJSONObject.put("data", 0);
            localObject = paramString;
            if (QLog.isColorLevel())
            {
              QLog.i(TAG, 2, "isEnterFromRedPoint:" + localJSONObject.toString());
              localObject = paramString;
            }
            callJs((String)localObject, new String[] { localJSONObject.toString() });
            return;
          }
          localJSONObject.put("code", 0);
          localJSONObject.put("data", 1);
          continue;
          localException1.printStackTrace();
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        String str1;
        String str2;
        paramString = "callback";
        continue;
      }
      try
      {
        localJSONObject.put("code", -1);
        localJSONObject.put("errorMessage", "missing path or callback");
        str1 = paramString;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        str2 = paramString;
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.browserApp = this.mRuntime.a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onResponse(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    String str1;
    String str2;
    do
    {
      do
      {
        return;
      } while (paramBundle.getInt("respkey", 0) != this.mOnRemoteResp.key);
      str1 = paramBundle.getString("cmd");
      str2 = paramBundle.getString("callbackid");
      paramBundle = paramBundle.getBundle("response");
      if ("leba_item_set".equals(str1))
      {
        handleLebaItemSet(str2, paramBundle);
        return;
      }
      if ("leba_item_get".equals(str1))
      {
        handleLebaItemGet(str2, paramBundle);
        return;
      }
      if ("redTouch_setAppInfo".equals(str1))
      {
        handleSetAppInfo(str2, paramBundle);
        return;
      }
      if ("redTouch_getRedPointShowInfo_set".equals(str1))
      {
        handleGetRedpointShowInfo(str2, paramBundle);
        return;
      }
    } while (!"redTouch_getRedInfo".equals(str1));
    handleRedInfoResponse(str2, paramBundle);
  }
  
  public void reportBusinessRedTouch(String paramString)
  {
    String str2 = "callback";
    JSONObject localJSONObject1 = new JSONObject();
    String str1 = str2;
    try
    {
      JSONObject localJSONObject2 = new JSONObject(paramString);
      str1 = str2;
      paramString = localJSONObject2.getString("callback");
      str1 = paramString;
      localJSONObject2.remove("callback");
      str1 = paramString;
      str2 = localJSONObject2.getString("path");
      str1 = paramString;
      localJSONObject2.remove("path");
      str1 = paramString;
      Bundle localBundle = new Bundle();
      str1 = paramString;
      localBundle.putString("path", str2);
      str1 = paramString;
      localBundle.putString("json", localJSONObject2.toString());
      str1 = paramString;
      localBundle.putString("subCmd", "redTouch_reportBusinessRedTouch");
      str1 = paramString;
      super.sendRemoteReq(asev.a("redTouch_getRedInfo", paramString, this.mOnRemoteResp.key, localBundle), false, true);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    try
    {
      localJSONObject1.put("code", -1);
      localJSONObject1.put("errorMessage", "missing path or callback");
      callJs(str1, new String[] { localJSONObject1.toString() });
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void reportRedTouch(String paramString)
  {
    Object localObject2 = "callback";
    ArrayList localArrayList = new ArrayList();
    localJSONObject = new JSONObject();
    localObject1 = localObject2;
    try
    {
      localObject3 = new JSONObject(paramString);
      localObject1 = localObject2;
      paramString = ((JSONObject)localObject3).getString("callback");
      localObject1 = paramString;
      localObject2 = ((JSONObject)localObject3).getString("path");
      localObject1 = paramString;
      j = ((JSONObject)localObject3).getInt("isWithRedPoint");
      localObject1 = paramString;
      localObject3 = ((JSONObject)localObject3).optJSONArray("missions");
      if (localObject3 == null) {
        break label151;
      }
      localObject1 = paramString;
      if (((JSONArray)localObject3).length() <= 0) {
        break label151;
      }
      i = 0;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Object localObject3;
        int j;
        int i;
        String str;
        paramString.printStackTrace();
        try
        {
          localJSONObject.put("code", -1);
          localJSONObject.put("errorMessage", "missing path or callback or isWithRedPoint");
          callJs((String)localObject1, new String[] { localJSONObject.toString() });
          return;
        }
        catch (JSONException paramString)
        {
          for (;;)
          {
            paramString.printStackTrace();
          }
        }
        i += 1;
      }
    }
    localObject1 = paramString;
    if (i < ((JSONArray)localObject3).length())
    {
      localObject1 = paramString;
      str = ((JSONArray)localObject3).getString(i);
      localObject1 = paramString;
      if (!TextUtils.isEmpty(str))
      {
        localObject1 = paramString;
        localArrayList.add(str);
      }
    }
    else
    {
      label151:
      localObject1 = paramString;
      localObject3 = new Bundle();
      localObject1 = paramString;
      ((Bundle)localObject3).putString("path", (String)localObject2);
      localObject1 = paramString;
      ((Bundle)localObject3).putInt("isWithRedPoint", j);
      localObject1 = paramString;
      if (localArrayList.size() > 0)
      {
        localObject1 = paramString;
        ((Bundle)localObject3).putStringArrayList("missions", localArrayList);
      }
      localObject1 = paramString;
      ((Bundle)localObject3).putString("subCmd", "redTouch_reportRedTouch");
      localObject1 = paramString;
      super.sendRemoteReq(asev.a("redTouch_getRedInfo", paramString, this.mOnRemoteResp.key, (Bundle)localObject3), false, true);
      localObject1 = paramString;
      localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("code", 0);
        localObject1 = paramString;
        if (QLog.isColorLevel())
        {
          localObject1 = paramString;
          QLog.i(TAG, 2, "reportRedTouch:" + ((JSONObject)localObject2).toString());
        }
        localObject1 = paramString;
        callJs(paramString, new String[] { ((JSONObject)localObject2).toString() });
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject1 = paramString;
          QLog.e(TAG, 1, "reportRedTouch: Exception e = " + localException.getMessage());
          localObject1 = paramString;
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void setAppInfo(String paramString)
  {
    Object localObject2 = "callback";
    JSONObject localJSONObject = new JSONObject();
    new JSONObject();
    Object localObject1 = localObject2;
    try
    {
      Object localObject3 = new JSONObject(paramString);
      localObject1 = localObject2;
      paramString = ((JSONObject)localObject3).getString("callback");
      localObject1 = paramString;
      localObject3 = ((JSONObject)localObject3).getJSONObject("appInfo");
      localObject1 = paramString;
      localObject2 = new BusinessInfoCheckUpdate.AppInfo();
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).uiAppId.set(((JSONObject)localObject3).getInt("appID"));
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.set(((JSONObject)localObject3).getInt("iNewFlag"));
      localObject1 = paramString;
      JSONArray localJSONArray = ((JSONObject)localObject3).getJSONArray("missions");
      int i = 0;
      for (;;)
      {
        localObject1 = paramString;
        if (i >= localJSONArray.length()) {
          break;
        }
        localObject1 = paramString;
        ((BusinessInfoCheckUpdate.AppInfo)localObject2).missions.add(localJSONArray.getString(i));
        i += 1;
      }
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).type.set(((JSONObject)localObject3).getInt("type"));
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).buffer.set(((JSONObject)localObject3).getString("buffer"));
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).path.set(((JSONObject)localObject3).getString("path"));
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).appset.set(((JSONObject)localObject3).getInt("appset"));
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).modify_ts.set(((JSONObject)localObject3).getInt("modify_ts"));
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).num.set(((JSONObject)localObject3).getInt("num"));
      localObject1 = paramString;
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).push_red_ts.set(((JSONObject)localObject3).getInt("push_red_ts"));
      localObject1 = paramString;
      localObject3 = new Bundle();
      localObject1 = paramString;
      ((Bundle)localObject3).putParcelable("red", bbaz.a((BusinessInfoCheckUpdate.AppInfo)localObject2));
      localObject1 = paramString;
      super.sendRemoteReq(asev.a("redTouch_setAppInfo", paramString, this.mOnRemoteResp.key, (Bundle)localObject3), false, true);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    try
    {
      localJSONObject.put("code", -1);
      localJSONObject.put("errorMessage", "missing appInfo or callback or appInfo json format error");
      callJs((String)localObject1, new String[] { localJSONObject.toString() });
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void setDynamicState(String paramString)
  {
    String str = null;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      if (localJSONObject1 == null) {
        return;
      }
    }
    catch (Exception localException1)
    {
      Object localObject;
      for (;;)
      {
        localException1.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "Failed to parse json string: " + paramString);
        }
        localObject = null;
      }
      paramString = str;
      try
      {
        str = localObject.getString("callback");
        paramString = str;
        Bundle localBundle = new Bundle();
        paramString = str;
        localBundle.putInt("path", bbav.a(localObject.getString("path")));
        paramString = str;
        localBundle.putInt("type", localObject.getInt("type"));
        paramString = str;
        sendRemoteReq(asev.a("leba_item_set", str, this.mOnRemoteResp.key, localBundle), false, false);
        return;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        try
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("ret", -1);
          localJSONObject2.put("errorMessage", "exception");
          callJs(paramString, new String[] { localJSONObject2.toString() });
          return;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  public void startActivityForResult(Intent paramIntent, byte paramByte)
  {
    super.startActivityForResult(paramIntent, paramByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchWebviewHandler
 * JD-Core Version:    0.7.0.1
 */