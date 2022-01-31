package com.tencent.mobileqq.redtouch;

import agrs;
import agru;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
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
  
  private void IPCItemClick(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("path", paramString);
    super.sendRemoteReq(DataFactory.a("myIndividuationRedInfo", null, 0, localBundle), false, true);
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
    label145:
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
          localObject1 = FileUtils.a((File)localObject1);
          if (localObject1 != null) {
            break label145;
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
  
  private List getAppInfoListByPath(List paramList)
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
            localObject1 = FileUtils.a((File)localObject1);
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
            break label176;
          }
          i = ((JSONObject)localObject).getInt("stat");
          if (i != 1) {
            continue;
          }
          if (!((JSONObject)localObject).has("content")) {
            break label181;
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
      label176:
      int i = -1;
      continue;
      label181:
      Object localObject = "";
    }
    localJSONObject1.put("msg", localJSONArray);
    paramString = localJSONObject1.toString();
    return paramString;
  }
  
  /* Error */
  private void handleRedInfoResponse(String paramString, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc_w 332
    //   4: invokevirtual 338	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   7: invokevirtual 342	android/os/Bundle:setClassLoader	(Ljava/lang/ClassLoader;)V
    //   10: aload_2
    //   11: ldc_w 344
    //   14: invokevirtual 345	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   17: astore 8
    //   19: aload 8
    //   21: ifnull +191 -> 212
    //   24: ldc_w 347
    //   27: aload 8
    //   29: invokevirtual 246	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   32: ifeq +232 -> 264
    //   35: ldc_w 349
    //   38: astore 9
    //   40: new 288	org/json/JSONObject
    //   43: dup
    //   44: invokespecial 289	org/json/JSONObject:<init>	()V
    //   47: astore 10
    //   49: aload 9
    //   51: astore 8
    //   53: aload_2
    //   54: ldc_w 351
    //   57: invokevirtual 355	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   60: checkcast 332	com/tencent/mobileqq/redtouch/RedAppInfo
    //   63: astore 11
    //   65: aload 9
    //   67: astore 8
    //   69: aload_2
    //   70: ldc 29
    //   72: invokevirtual 345	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   75: astore 12
    //   77: aload 9
    //   79: astore_2
    //   80: aload 11
    //   82: ifnull +76 -> 158
    //   85: aload 9
    //   87: astore_2
    //   88: aload 9
    //   90: astore 8
    //   92: aload 11
    //   94: invokevirtual 358	com/tencent/mobileqq/redtouch/RedAppInfo:b	()I
    //   97: ifeq +61 -> 158
    //   100: aload 9
    //   102: astore 8
    //   104: aload_0
    //   105: new 288	org/json/JSONObject
    //   108: dup
    //   109: aload 11
    //   111: invokevirtual 360	com/tencent/mobileqq/redtouch/RedAppInfo:a	()Ljava/lang/String;
    //   114: invokespecial 304	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   117: invokespecial 362	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:getRedBufferJson	(Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   120: astore 13
    //   122: aload 9
    //   124: astore_2
    //   125: aload 13
    //   127: ifnull +31 -> 158
    //   130: aload 9
    //   132: astore 8
    //   134: aload 13
    //   136: ldc_w 364
    //   139: invokevirtual 309	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   142: ifeq +71 -> 213
    //   145: aload 9
    //   147: astore 8
    //   149: aload 13
    //   151: ldc_w 364
    //   154: invokevirtual 320	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   157: astore_2
    //   158: aload_2
    //   159: astore 8
    //   161: aload 10
    //   163: ldc_w 366
    //   166: aload_2
    //   167: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   170: pop
    //   171: aload_2
    //   172: astore 8
    //   174: aload_0
    //   175: aload 11
    //   177: invokestatic 371	com/tencent/mobileqq/redtouch/RedTouchUtils:a	(Lcom/tencent/mobileqq/redtouch/RedAppInfo;)Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   180: sipush 1002
    //   183: invokespecial 375	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:onReportRed	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;I)V
    //   186: aload_2
    //   187: astore 8
    //   189: aload_0
    //   190: aload 12
    //   192: invokespecial 377	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:IPCItemClick	(Ljava/lang/String;)V
    //   195: aload_0
    //   196: aload_1
    //   197: iconst_1
    //   198: anewarray 242	java/lang/String
    //   201: dup
    //   202: iconst_0
    //   203: aload 10
    //   205: invokevirtual 328	org/json/JSONObject:toString	()Ljava/lang/String;
    //   208: aastore
    //   209: invokevirtual 381	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   212: return
    //   213: ldc_w 349
    //   216: astore_2
    //   217: goto -59 -> 158
    //   220: astore_2
    //   221: aload_2
    //   222: invokevirtual 297	org/json/JSONException:printStackTrace	()V
    //   225: aload 10
    //   227: ldc_w 366
    //   230: aload 8
    //   232: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   235: pop
    //   236: aload_0
    //   237: aload_1
    //   238: iconst_1
    //   239: anewarray 242	java/lang/String
    //   242: dup
    //   243: iconst_0
    //   244: aload 10
    //   246: invokevirtual 328	org/json/JSONObject:toString	()Ljava/lang/String;
    //   249: aastore
    //   250: invokevirtual 381	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   253: goto -58 -> 195
    //   256: astore_2
    //   257: aload_2
    //   258: invokevirtual 297	org/json/JSONException:printStackTrace	()V
    //   261: goto -66 -> 195
    //   264: ldc_w 383
    //   267: aload 8
    //   269: invokevirtual 246	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   272: ifne -60 -> 212
    //   275: ldc_w 385
    //   278: aload 8
    //   280: invokevirtual 246	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   283: ifeq +596 -> 879
    //   286: new 288	org/json/JSONObject
    //   289: dup
    //   290: invokespecial 289	org/json/JSONObject:<init>	()V
    //   293: astore 8
    //   295: aload_2
    //   296: ldc_w 351
    //   299: invokevirtual 355	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   302: checkcast 332	com/tencent/mobileqq/redtouch/RedAppInfo
    //   305: astore 11
    //   307: aload_2
    //   308: ldc 29
    //   310: invokevirtual 345	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   313: astore 12
    //   315: aload_2
    //   316: ldc_w 387
    //   319: invokevirtual 345	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   322: astore_2
    //   323: new 288	org/json/JSONObject
    //   326: dup
    //   327: aload_2
    //   328: invokespecial 304	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   331: astore 10
    //   333: aload_0
    //   334: getfield 391	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   337: invokevirtual 396	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   340: astore_2
    //   341: new 398	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody
    //   344: dup
    //   345: invokespecial 399	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:<init>	()V
    //   348: astore 9
    //   350: aload 9
    //   352: getfield 403	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   355: aload_0
    //   356: getfield 391	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   359: invokevirtual 406	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   362: invokevirtual 167	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   365: invokestatic 412	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   368: invokevirtual 418	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   371: aload 9
    //   373: getfield 421	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:clientver	Lcom/tencent/mobileqq/pb/PBStringField;
    //   376: ldc_w 423
    //   379: invokevirtual 425	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   382: aload 9
    //   384: getfield 429	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:platid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   387: bipush 109
    //   389: invokevirtual 434	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   392: aload 9
    //   394: getfield 437	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   397: aload 12
    //   399: invokestatic 441	com/tencent/mobileqq/redtouch/RedTouchManager:a	(Ljava/lang/String;)I
    //   402: invokevirtual 434	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   405: aload 9
    //   407: getfield 444	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:platver	Lcom/tencent/mobileqq/pb/PBStringField;
    //   410: new 156	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   417: getstatic 449	android/os/Build$VERSION:SDK_INT	I
    //   420: invokevirtual 262	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   423: ldc_w 299
    //   426: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   432: invokevirtual 425	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   435: aload 11
    //   437: invokevirtual 451	com/tencent/mobileqq/redtouch/RedAppInfo:a	()Ljava/util/List;
    //   440: ifnull +16 -> 456
    //   443: aload 9
    //   445: getfield 455	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:missionid	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   448: aload 11
    //   450: invokevirtual 451	com/tencent/mobileqq/redtouch/RedAppInfo:a	()Ljava/util/List;
    //   453: invokevirtual 460	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   456: new 276	java/util/ArrayList
    //   459: dup
    //   460: invokespecial 277	java/util/ArrayList:<init>	()V
    //   463: astore 11
    //   465: aload 10
    //   467: invokevirtual 296	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   470: astore 12
    //   472: aload 12
    //   474: invokeinterface 227 1 0
    //   479: ifeq +156 -> 635
    //   482: aload 12
    //   484: invokeinterface 231 1 0
    //   489: checkcast 242	java/lang/String
    //   492: astore 13
    //   494: new 462	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData
    //   497: dup
    //   498: invokespecial 463	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData:<init>	()V
    //   501: astore 14
    //   503: aload 14
    //   505: getfield 466	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData:key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   508: aload 13
    //   510: invokevirtual 425	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   513: aload 14
    //   515: getfield 469	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData:value	Lcom/tencent/mobileqq/pb/PBStringField;
    //   518: aload 10
    //   520: aload 13
    //   522: invokevirtual 320	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   525: invokevirtual 425	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   528: aload 11
    //   530: aload 14
    //   532: invokeinterface 282 2 0
    //   537: pop
    //   538: getstatic 475	java/lang/System:out	Ljava/io/PrintStream;
    //   541: new 156	java/lang/StringBuilder
    //   544: dup
    //   545: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   548: ldc_w 477
    //   551: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: aload 14
    //   556: getfield 466	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData:key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   559: invokevirtual 240	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   562: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: ldc_w 479
    //   568: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: aload 14
    //   573: getfield 469	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData:value	Lcom/tencent/mobileqq/pb/PBStringField;
    //   576: invokevirtual 240	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   579: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   585: invokevirtual 484	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   588: goto -116 -> 472
    //   591: astore_2
    //   592: aload 8
    //   594: ldc_w 486
    //   597: iconst_m1
    //   598: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   601: pop
    //   602: aload 8
    //   604: ldc 26
    //   606: ldc_w 491
    //   609: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   612: pop
    //   613: aload_2
    //   614: invokevirtual 297	org/json/JSONException:printStackTrace	()V
    //   617: aload_0
    //   618: aload_1
    //   619: iconst_1
    //   620: anewarray 242	java/lang/String
    //   623: dup
    //   624: iconst_0
    //   625: aload 8
    //   627: invokevirtual 328	org/json/JSONObject:toString	()Ljava/lang/String;
    //   630: aastore
    //   631: invokevirtual 381	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   634: return
    //   635: new 288	org/json/JSONObject
    //   638: dup
    //   639: invokespecial 289	org/json/JSONObject:<init>	()V
    //   642: astore 10
    //   644: aload 10
    //   646: ifnull +13 -> 659
    //   649: aload 10
    //   651: ldc_w 493
    //   654: iconst_5
    //   655: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   658: pop
    //   659: aload 9
    //   661: getfield 496	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   664: aload 10
    //   666: invokevirtual 328	org/json/JSONObject:toString	()Ljava/lang/String;
    //   669: invokevirtual 425	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   672: aload 9
    //   674: getfield 499	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:reportdata	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   677: aload 11
    //   679: invokevirtual 500	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
    //   682: new 502	com/tencent/qphone/base/remote/ToServiceMsg
    //   685: dup
    //   686: ldc_w 504
    //   689: aload_0
    //   690: getfield 391	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   693: invokevirtual 406	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   696: invokevirtual 167	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   699: ldc_w 506
    //   702: invokespecial 509	com/tencent/qphone/base/remote/ToServiceMsg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   705: astore 10
    //   707: aload 10
    //   709: aload 9
    //   711: invokevirtual 513	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:toByteArray	()[B
    //   714: invokevirtual 517	com/tencent/qphone/base/remote/ToServiceMsg:putWupBuffer	([B)V
    //   717: aload 10
    //   719: getfield 521	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   722: ldc_w 523
    //   725: iconst_1
    //   726: invokevirtual 527	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   729: aload 10
    //   731: invokevirtual 530	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   734: arraylength
    //   735: i2l
    //   736: lstore 6
    //   738: lload 6
    //   740: l2i
    //   741: iconst_4
    //   742: iadd
    //   743: newarray byte
    //   745: astore 9
    //   747: aload 9
    //   749: iconst_0
    //   750: ldc2_w 531
    //   753: lload 6
    //   755: ladd
    //   756: invokestatic 537	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BIJ)V
    //   759: aload 9
    //   761: iconst_4
    //   762: aload 10
    //   764: invokevirtual 530	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   767: lload 6
    //   769: l2i
    //   770: invokestatic 540	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BI)V
    //   773: aload 10
    //   775: aload 9
    //   777: invokevirtual 517	com/tencent/qphone/base/remote/ToServiceMsg:putWupBuffer	([B)V
    //   780: new 542	mqq/app/NewIntent
    //   783: dup
    //   784: aload_2
    //   785: invokevirtual 547	android/app/Activity:getApplication	()Landroid/app/Application;
    //   788: ldc_w 549
    //   791: invokespecial 552	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   794: astore_2
    //   795: aload_2
    //   796: ldc_w 502
    //   799: invokevirtual 555	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   802: aload 10
    //   804: invokevirtual 559	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   807: pop
    //   808: aload_0
    //   809: getfield 391	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   812: invokevirtual 406	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   815: aload_2
    //   816: invokevirtual 563	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   819: aload 8
    //   821: ldc_w 486
    //   824: iconst_0
    //   825: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   828: pop
    //   829: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   832: ifeq -215 -> 617
    //   835: getstatic 70	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   838: iconst_2
    //   839: new 156	java/lang/StringBuilder
    //   842: dup
    //   843: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   846: ldc_w 565
    //   849: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: aload 8
    //   854: invokevirtual 328	org/json/JSONObject:toString	()Ljava/lang/String;
    //   857: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   863: invokestatic 140	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   866: goto -249 -> 617
    //   869: astore 9
    //   871: aload 9
    //   873: invokevirtual 297	org/json/JSONException:printStackTrace	()V
    //   876: goto -263 -> 613
    //   879: ldc_w 567
    //   882: aload 8
    //   884: invokevirtual 246	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   887: ifeq +914 -> 1801
    //   890: new 288	org/json/JSONObject
    //   893: dup
    //   894: invokespecial 289	org/json/JSONObject:<init>	()V
    //   897: astore 12
    //   899: new 288	org/json/JSONObject
    //   902: dup
    //   903: invokespecial 289	org/json/JSONObject:<init>	()V
    //   906: astore 11
    //   908: aload_2
    //   909: ldc_w 569
    //   912: invokevirtual 345	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   915: astore 13
    //   917: aload_2
    //   918: ldc_w 351
    //   921: invokevirtual 355	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   924: checkcast 332	com/tencent/mobileqq/redtouch/RedAppInfo
    //   927: invokestatic 371	com/tencent/mobileqq/redtouch/RedTouchUtils:a	(Lcom/tencent/mobileqq/redtouch/RedAppInfo;)Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   930: astore 15
    //   932: bipush 254
    //   934: istore 4
    //   936: ldc_w 299
    //   939: astore_2
    //   940: iconst_0
    //   941: istore_3
    //   942: ldc_w 299
    //   945: astore 10
    //   947: new 276	java/util/ArrayList
    //   950: dup
    //   951: invokespecial 277	java/util/ArrayList:<init>	()V
    //   954: astore 14
    //   956: aload 10
    //   958: astore 8
    //   960: aload_2
    //   961: astore 9
    //   963: aload 15
    //   965: ifnull +137 -> 1102
    //   968: aload 15
    //   970: getfield 573	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:red_display_info	Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedDisplayInfo;
    //   973: getfield 578	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedDisplayInfo:red_type_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   976: invokevirtual 216	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   979: astore 16
    //   981: aload 15
    //   983: getfield 236	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   986: invokevirtual 240	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   989: astore 9
    //   991: aload_2
    //   992: astore 8
    //   994: aload 15
    //   996: getfield 580	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   999: invokevirtual 581	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1002: iconst_m1
    //   1003: if_icmpne +292 -> 1295
    //   1006: bipush 253
    //   1008: istore 4
    //   1010: iconst_0
    //   1011: istore_3
    //   1012: aload_2
    //   1013: astore 8
    //   1015: aload 14
    //   1017: ldc_w 299
    //   1020: invokevirtual 582	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1023: pop
    //   1024: aload_2
    //   1025: astore 8
    //   1027: aload 12
    //   1029: ldc_w 486
    //   1032: bipush 253
    //   1034: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1037: pop
    //   1038: aload_2
    //   1039: astore 8
    //   1041: aload 12
    //   1043: ldc 26
    //   1045: ldc_w 584
    //   1048: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1051: pop
    //   1052: aload_2
    //   1053: astore 8
    //   1055: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1058: ifeq +37 -> 1095
    //   1061: aload_2
    //   1062: astore 8
    //   1064: getstatic 70	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   1067: iconst_2
    //   1068: new 156	java/lang/StringBuilder
    //   1071: dup
    //   1072: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   1075: ldc_w 586
    //   1078: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1081: aload 12
    //   1083: invokevirtual 328	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1086: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1089: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1092: invokestatic 140	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1095: aload 9
    //   1097: astore 8
    //   1099: aload_2
    //   1100: astore 9
    //   1102: new 439	com/tencent/mobileqq/redtouch/RedTouchManager
    //   1105: dup
    //   1106: aload_0
    //   1107: getfield 391	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1110: invokevirtual 406	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   1113: invokespecial 589	com/tencent/mobileqq/redtouch/RedTouchManager:<init>	(Lcom/tencent/common/app/AppInterface;)V
    //   1116: invokevirtual 590	com/tencent/mobileqq/redtouch/RedTouchManager:a	()Ljava/lang/String;
    //   1119: astore_2
    //   1120: iload_3
    //   1121: istore 5
    //   1123: aload 8
    //   1125: invokestatic 128	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1128: ifne +18 -> 1146
    //   1131: iload_3
    //   1132: istore 5
    //   1134: aload 8
    //   1136: aload_2
    //   1137: invokevirtual 246	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1140: ifeq +6 -> 1146
    //   1143: iconst_1
    //   1144: istore 5
    //   1146: new 81	android/os/Bundle
    //   1149: dup
    //   1150: invokespecial 82	android/os/Bundle:<init>	()V
    //   1153: astore_2
    //   1154: aload_2
    //   1155: ldc 32
    //   1157: iload 4
    //   1159: invokestatic 594	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1162: invokevirtual 86	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1165: aload_2
    //   1166: ldc_w 595
    //   1169: aload 9
    //   1171: invokevirtual 86	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1174: aload_2
    //   1175: ldc_w 597
    //   1178: iload 5
    //   1180: invokestatic 594	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1183: invokevirtual 86	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1186: aload_2
    //   1187: ldc_w 599
    //   1190: aload 14
    //   1192: invokevirtual 603	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1195: aload_2
    //   1196: ldc 29
    //   1198: aload 8
    //   1200: invokevirtual 86	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1203: aload_2
    //   1204: ldc_w 569
    //   1207: aload 13
    //   1209: invokevirtual 86	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1212: aload_2
    //   1213: ldc 23
    //   1215: aload_1
    //   1216: invokevirtual 86	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1219: aload_0
    //   1220: ldc_w 605
    //   1223: aload_1
    //   1224: aload_0
    //   1225: getfield 609	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   1228: getfield 613	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   1231: aload_2
    //   1232: invokestatic 94	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   1235: iconst_0
    //   1236: iconst_1
    //   1237: invokespecial 98	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   1240: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1243: ifeq +34 -> 1277
    //   1246: getstatic 70	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   1249: iconst_2
    //   1250: new 156	java/lang/StringBuilder
    //   1253: dup
    //   1254: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   1257: ldc_w 615
    //   1260: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1263: aload 12
    //   1265: invokevirtual 328	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1268: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1271: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1274: invokestatic 140	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1277: aload_0
    //   1278: aload_1
    //   1279: iconst_1
    //   1280: anewarray 242	java/lang/String
    //   1283: dup
    //   1284: iconst_0
    //   1285: aload 12
    //   1287: invokevirtual 328	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1290: aastore
    //   1291: invokevirtual 381	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1294: return
    //   1295: aload_2
    //   1296: astore 8
    //   1298: aload 12
    //   1300: ldc_w 486
    //   1303: iconst_0
    //   1304: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1307: pop
    //   1308: aload_2
    //   1309: astore 8
    //   1311: aload 11
    //   1313: ldc_w 617
    //   1316: aload 15
    //   1318: getfield 620	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:uiAppId	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1321: invokevirtual 581	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1324: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1327: pop
    //   1328: aload_2
    //   1329: astore 8
    //   1331: aload 11
    //   1333: ldc_w 621
    //   1336: aload 15
    //   1338: getfield 254	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:iNewFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1341: invokevirtual 259	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1344: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1347: pop
    //   1348: aload_2
    //   1349: astore 8
    //   1351: aload 15
    //   1353: getfield 254	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:iNewFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1356: invokevirtual 259	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1359: istore 4
    //   1361: aload_2
    //   1362: astore 8
    //   1364: new 301	org/json/JSONArray
    //   1367: dup
    //   1368: invokespecial 302	org/json/JSONArray:<init>	()V
    //   1371: astore 10
    //   1373: iconst_0
    //   1374: istore_3
    //   1375: aload_2
    //   1376: astore 8
    //   1378: iload_3
    //   1379: aload 15
    //   1381: getfield 623	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1384: invokevirtual 626	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   1387: if_icmpge +46 -> 1433
    //   1390: aload_2
    //   1391: astore 8
    //   1393: aload 10
    //   1395: aload 15
    //   1397: getfield 623	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1400: iload_3
    //   1401: invokevirtual 629	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   1404: invokevirtual 327	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   1407: pop
    //   1408: aload_2
    //   1409: astore 8
    //   1411: aload 14
    //   1413: aload 15
    //   1415: getfield 623	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1418: iload_3
    //   1419: invokevirtual 629	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   1422: invokevirtual 582	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1425: pop
    //   1426: iload_3
    //   1427: iconst_1
    //   1428: iadd
    //   1429: istore_3
    //   1430: goto -55 -> 1375
    //   1433: aload_2
    //   1434: astore 8
    //   1436: new 288	org/json/JSONObject
    //   1439: dup
    //   1440: invokespecial 289	org/json/JSONObject:<init>	()V
    //   1443: astore 17
    //   1445: aload 16
    //   1447: ifnull +113 -> 1560
    //   1450: iconst_0
    //   1451: istore_3
    //   1452: aload_2
    //   1453: astore 8
    //   1455: iload_3
    //   1456: aload 16
    //   1458: invokeinterface 630 1 0
    //   1463: if_icmpge +97 -> 1560
    //   1466: aload_2
    //   1467: astore 8
    //   1469: aload 17
    //   1471: ldc_w 632
    //   1474: aload 16
    //   1476: iload_3
    //   1477: invokeinterface 633 2 0
    //   1482: checkcast 635	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   1485: getfield 637	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1488: invokevirtual 581	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1491: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1494: pop
    //   1495: aload_2
    //   1496: astore 8
    //   1498: aload 17
    //   1500: ldc_w 639
    //   1503: aload 16
    //   1505: iload_3
    //   1506: invokeinterface 633 2 0
    //   1511: checkcast 635	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   1514: getfield 641	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1517: invokevirtual 240	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1520: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1523: pop
    //   1524: aload_2
    //   1525: astore 8
    //   1527: aload 17
    //   1529: ldc_w 643
    //   1532: aload 16
    //   1534: iload_3
    //   1535: invokeinterface 633 2 0
    //   1540: checkcast 635	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   1543: getfield 645	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1546: invokevirtual 240	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1549: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1552: pop
    //   1553: iload_3
    //   1554: iconst_1
    //   1555: iadd
    //   1556: istore_3
    //   1557: goto -105 -> 1452
    //   1560: aload_2
    //   1561: astore 8
    //   1563: aload 11
    //   1565: ldc_w 351
    //   1568: aload 17
    //   1570: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1573: pop
    //   1574: aload_2
    //   1575: astore 8
    //   1577: aload 11
    //   1579: ldc_w 599
    //   1582: aload 10
    //   1584: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1587: pop
    //   1588: aload_2
    //   1589: astore 8
    //   1591: aload 11
    //   1593: ldc 38
    //   1595: aload 15
    //   1597: getfield 580	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1600: invokevirtual 581	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1603: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1606: pop
    //   1607: aload_2
    //   1608: astore 8
    //   1610: aload 11
    //   1612: ldc_w 595
    //   1615: aload 15
    //   1617: getfield 646	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1620: invokevirtual 240	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1623: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1626: pop
    //   1627: aload_2
    //   1628: astore 8
    //   1630: aload 11
    //   1632: ldc 29
    //   1634: aload 15
    //   1636: getfield 236	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1639: invokevirtual 240	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1642: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1645: pop
    //   1646: aload_2
    //   1647: astore 8
    //   1649: aload 11
    //   1651: ldc_w 648
    //   1654: aload 15
    //   1656: getfield 650	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:appset	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1659: invokevirtual 259	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1662: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1665: pop
    //   1666: aload_2
    //   1667: astore 8
    //   1669: aload 11
    //   1671: ldc_w 652
    //   1674: aload 15
    //   1676: getfield 654	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:modify_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1679: invokevirtual 581	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1682: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1685: pop
    //   1686: aload_2
    //   1687: astore 8
    //   1689: aload 11
    //   1691: ldc_w 656
    //   1694: aload 15
    //   1696: getfield 658	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:num	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1699: invokevirtual 259	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1702: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1705: pop
    //   1706: aload_2
    //   1707: astore 8
    //   1709: aload 11
    //   1711: ldc_w 660
    //   1714: aload 15
    //   1716: getfield 662	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:push_red_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1719: invokevirtual 581	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1722: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1725: pop
    //   1726: aload_2
    //   1727: astore 8
    //   1729: aload 12
    //   1731: ldc_w 664
    //   1734: aload 11
    //   1736: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1739: pop
    //   1740: aload_2
    //   1741: astore 8
    //   1743: aload_0
    //   1744: aload 15
    //   1746: getfield 646	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1749: invokevirtual 240	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1752: invokespecial 110	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:getReportBufferString	(Ljava/lang/String;)Ljava/lang/String;
    //   1755: astore_2
    //   1756: iload 4
    //   1758: istore_3
    //   1759: iconst_0
    //   1760: istore 4
    //   1762: goto -710 -> 1052
    //   1765: astore 11
    //   1767: aload 10
    //   1769: astore 9
    //   1771: aload 11
    //   1773: invokevirtual 297	org/json/JSONException:printStackTrace	()V
    //   1776: bipush 252
    //   1778: istore 4
    //   1780: iconst_0
    //   1781: istore_3
    //   1782: aload 14
    //   1784: ldc_w 299
    //   1787: invokevirtual 582	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1790: pop
    //   1791: aload 9
    //   1793: astore 8
    //   1795: aload_2
    //   1796: astore 9
    //   1798: goto -696 -> 1102
    //   1801: ldc_w 666
    //   1804: aload 8
    //   1806: invokevirtual 246	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1809: ifeq -1597 -> 212
    //   1812: aload_2
    //   1813: ldc_w 351
    //   1816: invokevirtual 355	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   1819: checkcast 332	com/tencent/mobileqq/redtouch/RedAppInfo
    //   1822: astore 8
    //   1824: new 288	org/json/JSONObject
    //   1827: dup
    //   1828: invokespecial 289	org/json/JSONObject:<init>	()V
    //   1831: astore_2
    //   1832: new 288	org/json/JSONObject
    //   1835: dup
    //   1836: invokespecial 289	org/json/JSONObject:<init>	()V
    //   1839: astore 9
    //   1841: aload 8
    //   1843: ifnonnull +75 -> 1918
    //   1846: aload_2
    //   1847: ldc_w 486
    //   1850: iconst_m1
    //   1851: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1854: pop
    //   1855: aload_2
    //   1856: ldc 26
    //   1858: ldc_w 668
    //   1861: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1864: pop
    //   1865: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1868: ifeq +33 -> 1901
    //   1871: getstatic 70	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   1874: iconst_2
    //   1875: new 156	java/lang/StringBuilder
    //   1878: dup
    //   1879: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   1882: ldc_w 670
    //   1885: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1888: aload_2
    //   1889: invokevirtual 328	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1892: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1895: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1898: invokestatic 140	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1901: aload_0
    //   1902: aload_1
    //   1903: iconst_1
    //   1904: anewarray 242	java/lang/String
    //   1907: dup
    //   1908: iconst_0
    //   1909: aload_2
    //   1910: invokevirtual 328	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1913: aastore
    //   1914: invokevirtual 381	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1917: return
    //   1918: aload 8
    //   1920: invokevirtual 673	com/tencent/mobileqq/redtouch/RedAppInfo:c	()I
    //   1923: iconst_m1
    //   1924: if_icmpne +65 -> 1989
    //   1927: aload_2
    //   1928: ldc_w 486
    //   1931: bipush 253
    //   1933: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1936: pop
    //   1937: aload_2
    //   1938: ldc 26
    //   1940: ldc_w 584
    //   1943: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1946: pop
    //   1947: goto -82 -> 1865
    //   1950: astore 8
    //   1952: aload 8
    //   1954: invokevirtual 297	org/json/JSONException:printStackTrace	()V
    //   1957: aload_2
    //   1958: ldc_w 486
    //   1961: iconst_m1
    //   1962: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1965: pop
    //   1966: aload_2
    //   1967: ldc 26
    //   1969: ldc_w 675
    //   1972: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1975: pop
    //   1976: goto -75 -> 1901
    //   1979: astore 8
    //   1981: aload 8
    //   1983: invokevirtual 297	org/json/JSONException:printStackTrace	()V
    //   1986: goto -85 -> 1901
    //   1989: aload_2
    //   1990: ldc_w 486
    //   1993: iconst_0
    //   1994: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1997: pop
    //   1998: aload 9
    //   2000: ldc_w 677
    //   2003: aload 8
    //   2005: invokevirtual 673	com/tencent/mobileqq/redtouch/RedAppInfo:c	()I
    //   2008: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2011: pop
    //   2012: aload 9
    //   2014: ldc_w 679
    //   2017: aload 8
    //   2019: invokevirtual 682	com/tencent/mobileqq/redtouch/RedAppInfo:f	()I
    //   2022: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2025: pop
    //   2026: aload 9
    //   2028: ldc_w 684
    //   2031: aload 8
    //   2033: invokevirtual 358	com/tencent/mobileqq/redtouch/RedAppInfo:b	()I
    //   2036: invokevirtual 489	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2039: pop
    //   2040: aload_2
    //   2041: ldc_w 664
    //   2044: aload 9
    //   2046: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2049: pop
    //   2050: goto -185 -> 1865
    //   2053: astore 11
    //   2055: aload 8
    //   2057: astore_2
    //   2058: goto -287 -> 1771
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2061	0	this	RedTouchWebviewHandler
    //   0	2061	1	paramString	String
    //   0	2061	2	paramBundle	Bundle
    //   941	841	3	i	int
    //   934	845	4	j	int
    //   1121	58	5	k	int
    //   736	32	6	l	long
    //   17	1902	8	localObject1	Object
    //   1950	3	8	localJSONException1	JSONException
    //   1979	77	8	localJSONException2	JSONException
    //   38	738	9	localObject2	Object
    //   869	3	9	localJSONException3	JSONException
    //   961	1084	9	localObject3	Object
    //   47	1721	10	localObject4	Object
    //   63	1672	11	localObject5	Object
    //   1765	7	11	localJSONException4	JSONException
    //   2053	1	11	localJSONException5	JSONException
    //   75	1655	12	localObject6	Object
    //   120	1088	13	localObject7	Object
    //   501	1282	14	localObject8	Object
    //   930	815	15	localAppInfo	BusinessInfoCheckUpdate.AppInfo
    //   979	554	16	localList	List
    //   1443	126	17	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   53	65	220	org/json/JSONException
    //   69	77	220	org/json/JSONException
    //   92	100	220	org/json/JSONException
    //   104	122	220	org/json/JSONException
    //   134	145	220	org/json/JSONException
    //   149	158	220	org/json/JSONException
    //   161	171	220	org/json/JSONException
    //   174	186	220	org/json/JSONException
    //   189	195	220	org/json/JSONException
    //   225	253	256	org/json/JSONException
    //   323	456	591	org/json/JSONException
    //   456	472	591	org/json/JSONException
    //   472	588	591	org/json/JSONException
    //   635	644	591	org/json/JSONException
    //   649	659	591	org/json/JSONException
    //   659	866	591	org/json/JSONException
    //   592	613	869	org/json/JSONException
    //   968	991	1765	org/json/JSONException
    //   1846	1865	1950	org/json/JSONException
    //   1865	1901	1950	org/json/JSONException
    //   1918	1947	1950	org/json/JSONException
    //   1989	2050	1950	org/json/JSONException
    //   1957	1976	1979	org/json/JSONException
    //   994	1006	2053	org/json/JSONException
    //   1015	1024	2053	org/json/JSONException
    //   1027	1038	2053	org/json/JSONException
    //   1041	1052	2053	org/json/JSONException
    //   1055	1061	2053	org/json/JSONException
    //   1064	1095	2053	org/json/JSONException
    //   1298	1308	2053	org/json/JSONException
    //   1311	1328	2053	org/json/JSONException
    //   1331	1348	2053	org/json/JSONException
    //   1351	1361	2053	org/json/JSONException
    //   1364	1373	2053	org/json/JSONException
    //   1378	1390	2053	org/json/JSONException
    //   1393	1408	2053	org/json/JSONException
    //   1411	1426	2053	org/json/JSONException
    //   1436	1445	2053	org/json/JSONException
    //   1455	1466	2053	org/json/JSONException
    //   1469	1495	2053	org/json/JSONException
    //   1498	1524	2053	org/json/JSONException
    //   1527	1553	2053	org/json/JSONException
    //   1563	1574	2053	org/json/JSONException
    //   1577	1588	2053	org/json/JSONException
    //   1591	1607	2053	org/json/JSONException
    //   1610	1627	2053	org/json/JSONException
    //   1630	1646	2053	org/json/JSONException
    //   1649	1666	2053	org/json/JSONException
    //   1669	1686	2053	org/json/JSONException
    //   1689	1706	2053	org/json/JSONException
    //   1709	1726	2053	org/json/JSONException
    //   1729	1740	2053	org/json/JSONException
    //   1743	1756	2053	org/json/JSONException
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
      new RedTouchManager(this.mRuntime.a()).b(paramAppInfo, localJSONObject.toString());
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
      ThreadManager.post(new agrs(this, paramString, l), 8, null, true);
    }
  }
  
  public void getAppInfoList(String paramString)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "getappinfolist js startime : " + l);
    }
    ThreadManager.post(new agru(this, paramString, l), 8, null, true);
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
        localBundle.putInt("path", RedTouchManager.a(localObject.getString("path")));
        paramString = str;
        sendRemoteReq(DataFactory.a("leba_item_get", str, this.mOnRemoteResp.key, localBundle), false, false);
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
      super.sendRemoteReq(DataFactory.a("redTouch_getRedInfo", paramString, this.mOnRemoteResp.key, localBundle), false, true);
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
        super.sendRemoteReq(DataFactory.a("redTouch_getRedPointShowInfo_set", paramString, this.mOnRemoteResp.key, (Bundle)localObject2), false, true);
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
          super.sendRemoteReq(DataFactory.a("redTouch_getRedInfo", paramString, this.mOnRemoteResp.key, (Bundle)localObject3), false, true);
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
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
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
          if (!new RedTouchManager(this.mRuntime.a()).a().equals(localObject))
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
  
  protected void onCreate()
  {
    super.onCreate();
    this.browserApp = this.mRuntime.a();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    int j = -1;
    int i = 1;
    if (paramBundle == null) {}
    String str1;
    Object localObject;
    label169:
    label210:
    do
    {
      do
      {
        return;
      } while (paramBundle.getInt("respkey", 0) != this.mOnRemoteResp.key);
      String str2 = paramBundle.getString("cmd");
      str1 = paramBundle.getString("callbackid");
      localObject = paramBundle.getBundle("response");
      if ("leba_item_set".equals(str2))
      {
        if (localObject == null)
        {
          i = 1;
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "set leba item result: " + i);
          }
          paramBundle = new JSONObject();
        }
        for (;;)
        {
          try
          {
            paramBundle.put("ret", i);
            if (i != 0) {
              break label169;
            }
            paramBundle.put("errorMessage", "success");
            callJs(str1, new String[] { paramBundle.toString() });
            return;
          }
          catch (JSONException paramBundle)
          {
            paramBundle.printStackTrace();
            return;
          }
          i = ((Bundle)localObject).getInt("ret");
          break;
          paramBundle.put("errorMessage", "failed");
        }
      }
      if ("leba_item_get".equals(str2))
      {
        if (localObject == null)
        {
          if (i != 0) {
            break label325;
          }
          j = ((Bundle)localObject).getInt("type", -1);
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "get leba item result: " + i + ", type: " + j);
          }
          paramBundle = new JSONObject();
        }
        for (;;)
        {
          try
          {
            paramBundle.put("ret", i);
            paramBundle.put("type", j);
            if (i != 0) {
              break label330;
            }
            paramBundle.put("errorMessage", "success");
            callJs(str1, new String[] { paramBundle.toString() });
            return;
          }
          catch (JSONException paramBundle)
          {
            paramBundle.printStackTrace();
            return;
          }
          i = ((Bundle)localObject).getInt("ret");
          break;
          j = -1;
          break label210;
          paramBundle.put("errorMessage", "data not prepared or cannot find the path, try again.");
        }
      }
      if ("redTouch_setAppInfo".equals(str2))
      {
        i = ((Bundle)localObject).getInt("iret");
        paramBundle = new JSONObject();
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
          catch (JSONException localJSONException1)
          {
            localJSONException1.printStackTrace();
            continue;
          }
          callJs(str1, new String[] { paramBundle.toString() });
          return;
          if (i == -4) {
            paramBundle.put("errorMessage", "failed to set appInfo");
          }
        }
      }
      if ("redTouch_getRedPointShowInfo_set".equals(localJSONException1))
      {
        paramBundle = new JSONObject();
        RedTypeInfo localRedTypeInfo = (RedTypeInfo)((Bundle)localObject).getSerializable("redInfo");
        localObject = new JSONObject();
        for (;;)
        {
          try
          {
            paramBundle.put("code", 0);
            if (localRedTypeInfo == null) {
              continue;
            }
            j = localRedTypeInfo.getRed_type();
            i = 1;
            ((JSONObject)localObject).put("hintType", j);
            ((JSONObject)localObject).put("number", 0);
            ((JSONObject)localObject).put("isShow", i);
            paramBundle.put("data", localObject);
            if (QLog.isColorLevel()) {
              QLog.i(TAG, 2, "getRedPointShowInfo:" + paramBundle.toString());
            }
          }
          catch (JSONException localJSONException2)
          {
            localJSONException2.printStackTrace();
            try
            {
              paramBundle.put("code", -1);
              paramBundle.put("errorMessage", "missing callback");
            }
            catch (JSONException localJSONException3)
            {
              localJSONException3.printStackTrace();
            }
            continue;
          }
          callJs(str1, new String[] { paramBundle.toString() });
          return;
          i = 0;
        }
      }
    } while (!"redTouch_getRedInfo".equals(localJSONException3));
    label325:
    label330:
    handleRedInfoResponse(str1, (Bundle)localObject);
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
      super.sendRemoteReq(DataFactory.a("redTouch_getRedInfo", paramString, this.mOnRemoteResp.key, localBundle), false, true);
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
      super.sendRemoteReq(DataFactory.a("redTouch_getRedInfo", paramString, this.mOnRemoteResp.key, (Bundle)localObject3), false, true);
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
      ((Bundle)localObject3).putParcelable("red", RedTouchUtils.a((BusinessInfoCheckUpdate.AppInfo)localObject2));
      localObject1 = paramString;
      super.sendRemoteReq(DataFactory.a("redTouch_setAppInfo", paramString, this.mOnRemoteResp.key, (Bundle)localObject3), false, true);
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
        localBundle.putInt("path", RedTouchManager.a(localObject.getString("path")));
        paramString = str;
        localBundle.putInt("type", localObject.getInt("type"));
        paramString = str;
        sendRemoteReq(DataFactory.a("leba_item_set", str, this.mOnRemoteResp.key, localBundle), false, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchWebviewHandler
 * JD-Core Version:    0.7.0.1
 */