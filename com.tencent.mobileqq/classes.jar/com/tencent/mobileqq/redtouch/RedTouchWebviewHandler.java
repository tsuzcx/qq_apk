package com.tencent.mobileqq.redtouch;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.compatible.TempServlet;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.ReportReqBody;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.ReportStaticsData;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.TimeRspBody;
import com.tencent.mobileqq.tianshu.utils.RedTouchUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
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
  private static Object lock = new Object();
  private AppInterface browserApp;
  
  public RedTouchWebviewHandler()
  {
    this.mPluginNameSpace = "redpoint";
  }
  
  @NotNull
  private static JSONObject buidRedJson(List<BusinessInfoCheckUpdate.RedTypeInfo> paramList)
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
  
  private static List<String> buildPaths(List<String> paramList, JSONArray paramJSONArray)
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
  private static JSONObject buildRedJson(List<BusinessInfoCheckUpdate.RedTypeInfo> paramList)
  {
    return buidRedJson(paramList);
  }
  
  private static BusinessInfoCheckUpdate.AppInfo getAppInfoByPath(AppInterface arg0, String paramString)
  {
    if ((??? != null) && (!TextUtils.isEmpty(paramString)))
    {
      Object localObject = ???.getApplication().getFilesDir();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("BusinessInfoCheckUpdateItem_new_1_");
      localStringBuilder.append(???.getCurrentAccountUin());
      localObject = new File((File)localObject, localStringBuilder.toString());
      if (!((File)localObject).exists()) {
        try
        {
          ((File)localObject).createNewFile();
        }
        catch (IOException ???)
        {
          ???.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getappinfo create file exception ");
          }
          return null;
        }
      }
      synchronized (lock)
      {
        localObject = FileUtils.fileToBytes((File)localObject);
        if (localObject == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getappinfo body = null");
          }
          return null;
        }
        ??? = new BusinessInfoCheckUpdate.TimeRspBody();
        try
        {
          ???.mergeFrom((byte[])localObject);
          if (!???.rptMsgAppInfo.has())
          {
            if (QLog.isColorLevel()) {
              QLog.i(TAG, 2, "getappinfo localTimeRspBody null ");
            }
            return null;
          }
          localObject = ???.rptMsgAppInfo.get().iterator();
          while (((Iterator)localObject).hasNext())
          {
            ??? = (BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject).next();
            if (???.path.get().equals(paramString))
            {
              if (QLog.isColorLevel())
              {
                paramString = TAG;
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("getappinfo path= ");
                ((StringBuilder)localObject).append(???.path.get());
                ((StringBuilder)localObject).append(";inewflag = ");
                ((StringBuilder)localObject).append(???.iNewFlag.get());
                QLog.i(paramString, 2, ((StringBuilder)localObject).toString());
              }
              return ???;
            }
          }
          return null;
        }
        catch (Exception ???)
        {
          ???.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getappinfo mergeFrom exception ");
          }
          return null;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "getappinfo path or browserapp = null");
    }
    return null;
  }
  
  private static List<BusinessInfoCheckUpdate.AppInfo> getAppInfoListByPath(AppInterface arg0, List<String> paramList)
  {
    if ((??? != null) && (paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject1 = ???.getApplication().getFilesDir();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("BusinessInfoCheckUpdateItem_new_1_");
      ((StringBuilder)localObject2).append(???.getCurrentAccountUin());
      localObject1 = new File((File)localObject1, ((StringBuilder)localObject2).toString());
      if (!((File)localObject1).exists()) {
        try
        {
          ((File)localObject1).createNewFile();
        }
        catch (IOException ???)
        {
          ???.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getappinfolist create file exception ");
          }
          return null;
        }
      }
      synchronized (lock)
      {
        localObject1 = FileUtils.fileToBytes((File)localObject1);
        if (localObject1 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getappinfolist body = null");
          }
          return null;
        }
        ??? = new BusinessInfoCheckUpdate.TimeRspBody();
        try
        {
          ???.mergeFrom((byte[])localObject1);
          if (!???.rptMsgAppInfo.has())
          {
            if (QLog.isColorLevel()) {
              QLog.i(TAG, 2, "getappinfolist localTimeRspBody null ");
            }
            return null;
          }
          ??? = ???.rptMsgAppInfo.get();
          localObject1 = new ArrayList();
          paramList = paramList.iterator();
          for (;;)
          {
            if (!paramList.hasNext()) {
              break label353;
            }
            String str = (String)paramList.next();
            Object localObject3 = ???.iterator();
            if (((Iterator)localObject3).hasNext())
            {
              localObject2 = (BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject3).next();
              if (!((BusinessInfoCheckUpdate.AppInfo)localObject2).path.get().equals(str)) {
                break;
              }
              if (QLog.isColorLevel())
              {
                str = TAG;
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("getappinfolist path= ");
                ((StringBuilder)localObject3).append(((BusinessInfoCheckUpdate.AppInfo)localObject2).path.get());
                ((StringBuilder)localObject3).append(";inewflag = ");
                ((StringBuilder)localObject3).append(((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get());
                QLog.i(str, 2, ((StringBuilder)localObject3).toString());
              }
              ((List)localObject1).add(localObject2);
            }
          }
          label353:
          return localObject1;
        }
        catch (Exception ???)
        {
          ???.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getappinfolist mergeFrom exception ");
          }
          return null;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "getappinfolist paths is empty or browserapp = null");
    }
    return null;
  }
  
  private JSONObject getRedBufferJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = paramJSONObject.getJSONObject("param");
      if (localJSONObject2 == null) {
        return null;
      }
      Iterator localIterator = localJSONObject2.keys();
      paramJSONObject = localJSONObject1;
      if (localIterator.hasNext()) {
        paramJSONObject = localJSONObject2.getJSONObject((String)localIterator.next());
      }
      return paramJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
  
  private static int getReddot(AppInterface paramAppInterface, List<BusinessInfoCheckUpdate.AppInfo> paramList, int paramInt)
  {
    int i = paramInt;
    if (paramAppInterface != null)
    {
      i = paramInt;
      if (paramList != null)
      {
        i = paramInt;
        if (!paramList.isEmpty())
        {
          paramAppInterface = RedTouchUtil.a(paramAppInterface);
          paramList = ((BusinessInfoCheckUpdate.AppInfo)paramList.get(0)).path.get();
          i = paramInt;
          if (!TextUtils.isEmpty(paramList))
          {
            i = paramInt;
            if (paramList.equals(paramAppInterface)) {
              i = 1;
            }
          }
        }
      }
    }
    return i;
  }
  
  private static String getReportBufferString(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = new JSONArray();
        JSONObject localJSONObject1 = new JSONObject();
        paramString = new JSONObject(paramString);
        if (paramString.has("msg"))
        {
          paramString = paramString.getJSONObject("msg");
          if (paramString != null)
          {
            Iterator localIterator = paramString.keys();
            if (localIterator.hasNext())
            {
              JSONObject localJSONObject2 = new JSONObject();
              String str = (String)localIterator.next();
              localObject = paramString.getJSONObject(str);
              if (!((JSONObject)localObject).has("stat")) {
                break label199;
              }
              i = ((JSONObject)localObject).getInt("stat");
              if (i != 1) {
                continue;
              }
              if (!((JSONObject)localObject).has("content")) {
                break label204;
              }
              localObject = ((JSONObject)localObject).getString("content");
              localJSONObject2.put(str, localObject);
              localJSONArray.put(localJSONObject2);
              continue;
            }
          }
          localJSONObject1.put("msg", localJSONArray);
          paramString = localJSONObject1.toString();
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return "";
      }
      paramString = null;
      continue;
      label199:
      int i = -1;
      continue;
      label204:
      Object localObject = "";
    }
  }
  
  /* Error */
  private void handleGetAppinfo(String paramString, Bundle paramBundle)
  {
    // Byte code:
    //   0: new 91	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 92	org/json/JSONObject:<init>	()V
    //   7: astore 10
    //   9: new 91	org/json/JSONObject
    //   12: dup
    //   13: invokespecial 92	org/json/JSONObject:<init>	()V
    //   16: astore 8
    //   18: aload_2
    //   19: ldc_w 366
    //   22: invokevirtual 369	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   25: astore 11
    //   27: aload_2
    //   28: ldc_w 371
    //   31: invokevirtual 375	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   34: checkcast 377	com/tencent/mobileqq/redtouch/RedAppInfo
    //   37: invokestatic 382	com/tencent/mobileqq/redtouch/RedTouchUtils:a	(Lcom/tencent/mobileqq/redtouch/RedAppInfo;)Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;
    //   40: astore 9
    //   42: new 141	java/util/ArrayList
    //   45: dup
    //   46: invokespecial 142	java/util/ArrayList:<init>	()V
    //   49: astore 12
    //   51: aload 9
    //   53: ifnull +531 -> 584
    //   56: aload 9
    //   58: getfield 386	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:red_display_info	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedDisplayInfo;
    //   61: getfield 391	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedDisplayInfo:red_type_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   64: invokevirtual 257	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   67: astore 13
    //   69: aload 9
    //   71: getfield 274	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   74: invokevirtual 127	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   77: astore_2
    //   78: aload 9
    //   80: getfield 393	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   83: invokevirtual 113	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   86: istore_3
    //   87: aload_2
    //   88: astore 7
    //   90: iload_3
    //   91: iconst_m1
    //   92: if_icmpne +46 -> 138
    //   95: aload 12
    //   97: ldc 149
    //   99: invokevirtual 394	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   102: pop
    //   103: bipush 253
    //   105: istore 4
    //   107: aload 10
    //   109: ldc_w 396
    //   112: bipush 253
    //   114: invokevirtual 117	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   117: pop
    //   118: aload 10
    //   120: ldc 26
    //   122: ldc_w 398
    //   125: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   128: pop
    //   129: ldc 149
    //   131: astore_2
    //   132: iconst_0
    //   133: istore 5
    //   135: goto +306 -> 441
    //   138: aload 10
    //   140: ldc_w 396
    //   143: iconst_0
    //   144: invokevirtual 117	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   147: pop
    //   148: aload 8
    //   150: ldc_w 400
    //   153: aload 9
    //   155: getfield 403	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:uiAppId	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   158: invokevirtual 113	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   161: invokevirtual 117	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   164: pop
    //   165: aload 8
    //   167: ldc_w 404
    //   170: aload 9
    //   172: getfield 287	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:iNewFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   175: invokevirtual 290	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   178: invokevirtual 117	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   181: pop
    //   182: aload 9
    //   184: getfield 287	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:iNewFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   187: invokevirtual 290	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   190: istore 5
    //   192: new 144	org/json/JSONArray
    //   195: dup
    //   196: invokespecial 339	org/json/JSONArray:<init>	()V
    //   199: astore 14
    //   201: iconst_0
    //   202: istore_3
    //   203: iload_3
    //   204: aload 9
    //   206: getfield 408	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   209: invokevirtual 411	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   212: if_icmpge +40 -> 252
    //   215: aload 14
    //   217: aload 9
    //   219: getfield 408	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   222: iload_3
    //   223: invokevirtual 412	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   226: invokevirtual 361	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   229: pop
    //   230: aload 12
    //   232: aload 9
    //   234: getfield 408	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   237: iload_3
    //   238: invokevirtual 412	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   241: invokevirtual 394	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   244: pop
    //   245: iload_3
    //   246: iconst_1
    //   247: iadd
    //   248: istore_3
    //   249: goto -46 -> 203
    //   252: aload 8
    //   254: ldc_w 371
    //   257: aload 13
    //   259: invokestatic 167	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:buidRedJson	(Ljava/util/List;)Lorg/json/JSONObject;
    //   262: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   265: pop
    //   266: aload 8
    //   268: ldc_w 413
    //   271: aload 14
    //   273: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   276: pop
    //   277: aload 8
    //   279: ldc 38
    //   281: aload 9
    //   283: getfield 393	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   286: invokevirtual 113	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   289: invokevirtual 117	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   292: pop
    //   293: aload 8
    //   295: ldc_w 415
    //   298: aload 9
    //   300: getfield 417	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:extend	Lcom/tencent/mobileqq/pb/PBStringField;
    //   303: invokevirtual 127	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   306: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   309: pop
    //   310: aload 8
    //   312: ldc_w 419
    //   315: aload 9
    //   317: getfield 421	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   320: invokevirtual 127	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   323: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   326: pop
    //   327: aload 8
    //   329: ldc 29
    //   331: aload 9
    //   333: getfield 274	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   336: invokevirtual 127	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   339: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   342: pop
    //   343: aload 8
    //   345: ldc_w 423
    //   348: aload 9
    //   350: getfield 425	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:appset	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   353: invokevirtual 290	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   356: invokevirtual 117	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   359: pop
    //   360: aload 8
    //   362: ldc_w 427
    //   365: aload 9
    //   367: getfield 429	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:modify_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   370: invokevirtual 113	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   373: invokevirtual 117	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   376: pop
    //   377: aload 8
    //   379: ldc_w 431
    //   382: aload 9
    //   384: getfield 433	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:num	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   387: invokevirtual 290	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   390: invokevirtual 117	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   393: pop
    //   394: aload 8
    //   396: ldc_w 435
    //   399: aload 9
    //   401: getfield 437	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:push_red_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   404: invokevirtual 113	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   407: invokevirtual 117	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   410: pop
    //   411: aload 10
    //   413: ldc_w 439
    //   416: aload 8
    //   418: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   421: pop
    //   422: aload 9
    //   424: getfield 421	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   427: invokevirtual 127	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   430: invokestatic 441	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:getReportBufferString	(Ljava/lang/String;)Ljava/lang/String;
    //   433: astore 8
    //   435: aload 8
    //   437: astore_2
    //   438: iconst_0
    //   439: istore 4
    //   441: iload 4
    //   443: istore 6
    //   445: aload_2
    //   446: astore 9
    //   448: iload 5
    //   450: istore_3
    //   451: aload 7
    //   453: astore 8
    //   455: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   458: ifeq +140 -> 598
    //   461: getstatic 222	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   464: astore 8
    //   466: new 187	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   473: astore 9
    //   475: aload 9
    //   477: ldc_w 443
    //   480: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload 9
    //   486: aload 10
    //   488: invokevirtual 362	org/json/JSONObject:toString	()Ljava/lang/String;
    //   491: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: pop
    //   495: aload 8
    //   497: iconst_2
    //   498: aload 9
    //   500: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: invokestatic 228	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   506: iload 4
    //   508: istore 6
    //   510: aload_2
    //   511: astore 9
    //   513: iload 5
    //   515: istore_3
    //   516: aload 7
    //   518: astore 8
    //   520: goto +78 -> 598
    //   523: astore 8
    //   525: goto +27 -> 552
    //   528: astore 8
    //   530: goto +5 -> 535
    //   533: astore 8
    //   535: aload_2
    //   536: astore 7
    //   538: ldc 149
    //   540: astore_2
    //   541: goto +11 -> 552
    //   544: astore 8
    //   546: ldc 149
    //   548: astore_2
    //   549: aload_2
    //   550: astore 7
    //   552: aload 8
    //   554: invokevirtual 327	org/json/JSONException:printStackTrace	()V
    //   557: aload 12
    //   559: ldc 149
    //   561: invokevirtual 394	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   564: pop
    //   565: aload_2
    //   566: astore 8
    //   568: aload 7
    //   570: astore_2
    //   571: bipush 252
    //   573: istore 4
    //   575: iconst_0
    //   576: istore_3
    //   577: aload 8
    //   579: astore 7
    //   581: goto +28 -> 609
    //   584: bipush 254
    //   586: istore 6
    //   588: ldc 149
    //   590: astore 9
    //   592: aload 9
    //   594: astore 8
    //   596: iconst_0
    //   597: istore_3
    //   598: aload 9
    //   600: astore 7
    //   602: iload 6
    //   604: istore 4
    //   606: aload 8
    //   608: astore_2
    //   609: aload_0
    //   610: getfield 447	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   613: invokevirtual 453	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:b	()Lcom/tencent/common/app/AppInterface;
    //   616: invokestatic 335	com/tencent/mobileqq/tianshu/utils/RedTouchUtil:a	(Lcom/tencent/common/app/AppInterface;)Ljava/lang/String;
    //   619: astore 8
    //   621: iload_3
    //   622: istore 5
    //   624: aload_2
    //   625: invokestatic 159	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   628: ifne +18 -> 646
    //   631: iload_3
    //   632: istore 5
    //   634: aload_2
    //   635: aload 8
    //   637: invokevirtual 279	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   640: ifeq +6 -> 646
    //   643: iconst_1
    //   644: istore 5
    //   646: new 368	android/os/Bundle
    //   649: dup
    //   650: invokespecial 454	android/os/Bundle:<init>	()V
    //   653: astore 8
    //   655: aload 8
    //   657: ldc 32
    //   659: iload 4
    //   661: invokestatic 458	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   664: invokevirtual 462	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   667: aload 8
    //   669: ldc_w 419
    //   672: aload 7
    //   674: invokevirtual 462	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   677: aload 8
    //   679: ldc_w 464
    //   682: iload 5
    //   684: invokestatic 458	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   687: invokevirtual 462	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   690: aload 8
    //   692: ldc_w 413
    //   695: aload 12
    //   697: invokevirtual 468	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   700: aload 8
    //   702: ldc 29
    //   704: aload_2
    //   705: invokevirtual 462	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   708: aload 8
    //   710: ldc_w 366
    //   713: aload 11
    //   715: invokevirtual 462	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   718: aload 8
    //   720: ldc 23
    //   722: aload_1
    //   723: invokevirtual 462	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   726: aload_0
    //   727: ldc_w 470
    //   730: aload_1
    //   731: aload_0
    //   732: getfield 474	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mOnRemoteResp	Lcom/tencent/mobileqq/emosm/OnRemoteRespObserver;
    //   735: getfield 479	com/tencent/mobileqq/emosm/OnRemoteRespObserver:key	I
    //   738: aload 8
    //   740: invokestatic 484	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   743: iconst_0
    //   744: iconst_1
    //   745: invokespecial 488	com/tencent/mobileqq/vaswebviewplugin/VasWebviewJsPlugin:sendRemoteReq	(Landroid/os/Bundle;ZZ)V
    //   748: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   751: ifeq +46 -> 797
    //   754: getstatic 222	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   757: astore_2
    //   758: new 187	java/lang/StringBuilder
    //   761: dup
    //   762: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   765: astore 7
    //   767: aload 7
    //   769: ldc_w 490
    //   772: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: pop
    //   776: aload 7
    //   778: aload 10
    //   780: invokevirtual 362	org/json/JSONObject:toString	()Ljava/lang/String;
    //   783: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: pop
    //   787: aload_2
    //   788: iconst_2
    //   789: aload 7
    //   791: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   794: invokestatic 228	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   797: aload_0
    //   798: aload_1
    //   799: iconst_1
    //   800: anewarray 276	java/lang/String
    //   803: dup
    //   804: iconst_0
    //   805: aload 10
    //   807: invokevirtual 362	org/json/JSONObject:toString	()Ljava/lang/String;
    //   810: aastore
    //   811: invokevirtual 494	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   814: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	815	0	this	RedTouchWebviewHandler
    //   0	815	1	paramString	String
    //   0	815	2	paramBundle	Bundle
    //   86	546	3	i	int
    //   105	555	4	j	int
    //   133	550	5	k	int
    //   443	160	6	m	int
    //   88	702	7	localObject1	Object
    //   16	503	8	localObject2	Object
    //   523	1	8	localJSONException1	JSONException
    //   528	1	8	localJSONException2	JSONException
    //   533	1	8	localJSONException3	JSONException
    //   544	9	8	localJSONException4	JSONException
    //   566	173	8	localObject3	Object
    //   40	559	9	localObject4	Object
    //   7	799	10	localJSONObject	JSONObject
    //   25	689	11	str	String
    //   49	647	12	localArrayList	ArrayList
    //   67	191	13	localList	List
    //   199	73	14	localJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   455	506	523	org/json/JSONException
    //   95	103	528	org/json/JSONException
    //   107	129	528	org/json/JSONException
    //   138	201	528	org/json/JSONException
    //   203	245	528	org/json/JSONException
    //   252	435	528	org/json/JSONException
    //   78	87	533	org/json/JSONException
    //   56	78	544	org/json/JSONException
  }
  
  private void handleGetRedpointShowInfo(String paramString, Bundle paramBundle)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramBundle == null) {
      paramBundle = null;
    } else {
      paramBundle = (RedTypeInfo)paramBundle.getSerializable("redInfo");
    }
    Object localObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("code", 0);
        if (paramBundle == null) {
          break label209;
        }
        j = paramBundle.getRedType();
        i = 1;
        ((JSONObject)localObject).put("hintType", j);
        ((JSONObject)localObject).put("number", 0);
        ((JSONObject)localObject).put("isShow", i);
        localJSONObject.put("data", localObject);
        if (QLog.isColorLevel())
        {
          paramBundle = TAG;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getRedPointShowInfo:");
          ((StringBuilder)localObject).append(localJSONObject.toString());
          QLog.i(paramBundle, 2, ((StringBuilder)localObject).toString());
        }
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        try
        {
          localJSONObject.put("code", -1);
          localJSONObject.put("errorMessage", "missing callback");
        }
        catch (JSONException paramBundle)
        {
          paramBundle.printStackTrace();
        }
      }
      callJs(paramString, new String[] { localJSONObject.toString() });
      return;
      label209:
      int j = -1;
      int i = 0;
    }
  }
  
  private void handleLebaItemGet(String paramString, Bundle paramBundle)
  {
    int i;
    if (paramBundle == null) {
      i = 1;
    } else {
      i = paramBundle.getInt("ret");
    }
    int j = -1;
    if (i == 0) {
      j = paramBundle.getInt("type", -1);
    }
    if (QLog.isColorLevel())
    {
      paramBundle = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get leba item result: ");
      localStringBuilder.append(i);
      localStringBuilder.append(", type: ");
      localStringBuilder.append(j);
      QLog.d(paramBundle, 2, localStringBuilder.toString());
    }
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("ret", i);
      paramBundle.put("type", j);
      if (i == 0) {
        paramBundle.put("errorMessage", "success");
      } else {
        paramBundle.put("errorMessage", "data not prepared or cannot find the path, try again.");
      }
      callJs(paramString, new String[] { paramBundle.toString() });
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void handleLebaItemSet(String paramString, Bundle paramBundle)
  {
    int i;
    if (paramBundle == null) {
      i = 1;
    } else {
      i = paramBundle.getInt("ret");
    }
    if (QLog.isColorLevel())
    {
      paramBundle = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("set leba item result: ");
      localStringBuilder.append(i);
      QLog.d(paramBundle, 2, localStringBuilder.toString());
    }
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("ret", i);
      if (i == 0) {
        paramBundle.put("errorMessage", "success");
      } else {
        paramBundle.put("errorMessage", "failed");
      }
      callJs(paramString, new String[] { paramBundle.toString() });
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void handleRedInfoResponse(String paramString, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    paramBundle.setClassLoader(RedAppInfo.class.getClassLoader());
    String str = paramBundle.getString("subCmd");
    if (str != null)
    {
      if ("redTouch_getIndividuationType".equals(str))
      {
        handlegetIndivationType(paramString, paramBundle);
        return;
      }
      if ("redTouch_reportRedTouch".equals(str)) {
        return;
      }
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
      if ("redTouch_getRedPointShowInfo_path".equals(str)) {
        handlegetRedpointShowInfoPath(paramString, paramBundle);
      }
    }
  }
  
  private void handleReportRedtouch(String paramString, Bundle paramBundle)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject3 = (RedAppInfo)paramBundle.getParcelable("redInfo");
    Object localObject4 = paramBundle.getString("path");
    paramBundle = paramBundle.getString("json");
    try
    {
      localObject2 = new JSONObject(paramBundle);
      paramBundle = this.mRuntime.d();
      localObject1 = new BusinessInfoCheckUpdate.ReportReqBody();
      ((BusinessInfoCheckUpdate.ReportReqBody)localObject1).uin.set(Long.parseLong(this.mRuntime.b().getCurrentAccountUin()));
      ((BusinessInfoCheckUpdate.ReportReqBody)localObject1).clientver.set("8.8.17.5770");
      ((BusinessInfoCheckUpdate.ReportReqBody)localObject1).platid.set(109);
      Object localObject5 = (IRedTouchManager)this.mRuntime.b().getRuntimeService(IRedTouchManager.class, "");
      ((BusinessInfoCheckUpdate.ReportReqBody)localObject1).appid.set(((IRedTouchManager)localObject5).getAppIdByPath((String)localObject4));
      localObject4 = ((BusinessInfoCheckUpdate.ReportReqBody)localObject1).platver;
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(Build.VERSION.SDK_INT);
      ((StringBuilder)localObject5).append("");
      ((PBStringField)localObject4).set(((StringBuilder)localObject5).toString());
      if (((RedAppInfo)localObject3).g() != null) {
        ((BusinessInfoCheckUpdate.ReportReqBody)localObject1).missionid.set(((RedAppInfo)localObject3).g());
      }
      localObject3 = new ArrayList();
      localObject4 = ((JSONObject)localObject2).keys();
      while (((Iterator)localObject4).hasNext())
      {
        Object localObject6 = (String)((Iterator)localObject4).next();
        localObject5 = new BusinessInfoCheckUpdate.ReportStaticsData();
        ((BusinessInfoCheckUpdate.ReportStaticsData)localObject5).key.set((String)localObject6);
        ((BusinessInfoCheckUpdate.ReportStaticsData)localObject5).value.set(((JSONObject)localObject2).getString((String)localObject6));
        ((List)localObject3).add(localObject5);
        localObject6 = System.out;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("key:");
        localStringBuilder.append(((BusinessInfoCheckUpdate.ReportStaticsData)localObject5).key.get());
        localStringBuilder.append("value:");
        localStringBuilder.append(((BusinessInfoCheckUpdate.ReportStaticsData)localObject5).value.get());
        ((PrintStream)localObject6).println(localStringBuilder.toString());
      }
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("cmd", 5);
      ((BusinessInfoCheckUpdate.ReportReqBody)localObject1).buffer.set(((JSONObject)localObject2).toString());
      ((BusinessInfoCheckUpdate.ReportReqBody)localObject1).reportdata.set((List)localObject3);
      localObject2 = new ToServiceMsg("mobileqq.service", this.mRuntime.b().getCurrentAccountUin(), "RedTouchSvc.ClientReport");
      ((ToServiceMsg)localObject2).putWupBuffer(((BusinessInfoCheckUpdate.ReportReqBody)localObject1).toByteArray());
      ((ToServiceMsg)localObject2).extraData.putBoolean("req_pb_protocol_flag", true);
      long l = ((ToServiceMsg)localObject2).getWupBuffer().length;
      int i = (int)l;
      localObject1 = new byte[i + 4];
      PkgTools.dWord2Byte((byte[])localObject1, 0, l + 4L);
      PkgTools.copyData((byte[])localObject1, 4, ((ToServiceMsg)localObject2).getWupBuffer(), i);
      ((ToServiceMsg)localObject2).putWupBuffer((byte[])localObject1);
      paramBundle = new NewIntent(paramBundle.getApplication(), TempServlet.class);
      paramBundle.putExtra(ToServiceMsg.class.getSimpleName(), (Parcelable)localObject2);
      this.mRuntime.b().startServlet(paramBundle);
      localJSONObject.put("code", 0);
      if (QLog.isColorLevel())
      {
        paramBundle = TAG;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("reportBusinessRedTouch:");
        ((StringBuilder)localObject1).append(localJSONObject.toString());
        QLog.i(paramBundle, 2, ((StringBuilder)localObject1).toString());
      }
    }
    catch (Exception paramBundle)
    {
      Object localObject2;
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("reportBusinessRedTouch:");
        ((StringBuilder)localObject2).append(paramBundle.toString());
        QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
    }
    catch (JSONException paramBundle)
    {
      try
      {
        localJSONObject.put("code", -1);
        localJSONObject.put("errorMessage", "missing path or callback");
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      paramBundle.printStackTrace();
    }
    callJs(paramString, new String[] { localJSONObject.toString() });
  }
  
  private void handleSetAppInfo(String paramString, Bundle paramBundle)
  {
    int i;
    if (paramBundle == null) {
      i = -1;
    } else {
      i = paramBundle.getInt("iret");
    }
    paramBundle = new JSONObject();
    try
    {
      paramBundle.put("code", i);
      if (i == -3) {
        paramBundle.put("errorMessage", "appInfo not found");
      } else if (i == -4) {
        paramBundle.put("errorMessage", "failed to set appInfo");
      }
      if (QLog.isColorLevel())
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setAppInfo:");
        localStringBuilder.append(paramBundle.toString());
        QLog.i(str, 2, localStringBuilder.toString());
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    callJs(paramString, new String[] { paramBundle.toString() });
  }
  
  private void handlegetIndivationType(String paramString, Bundle paramBundle)
  {
    String str1 = "0";
    JSONObject localJSONObject = new JSONObject();
    Object localObject1 = str1;
    try
    {
      Object localObject2 = (RedAppInfo)paramBundle.getParcelable("redInfo");
      localObject1 = str1;
      String str2 = paramBundle.getString("path");
      paramBundle = str1;
      if (localObject2 != null)
      {
        paramBundle = str1;
        localObject1 = str1;
        if (((RedAppInfo)localObject2).b() != 0)
        {
          localObject1 = str1;
          localObject2 = getRedBufferJson(new JSONObject(((RedAppInfo)localObject2).d()));
          paramBundle = str1;
          if (localObject2 != null)
          {
            paramBundle = str1;
            localObject1 = str1;
            if (((JSONObject)localObject2).has("_red_ext_busi_"))
            {
              localObject1 = str1;
              paramBundle = ((JSONObject)localObject2).getString("_red_ext_busi_");
            }
          }
        }
      }
      localObject1 = paramBundle;
      localJSONObject.put("result", paramBundle);
      localObject1 = paramBundle;
      ipcItemClick(str2);
    }
    catch (JSONException paramBundle)
    {
      paramBundle.printStackTrace();
      try
      {
        localJSONObject.put("result", localObject1);
        callJs(paramString, new String[] { localJSONObject.toString() });
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
    callJs(paramString, new String[] { localJSONObject.toString() });
  }
  
  private void handlegetRedpointShowInfoPath(String paramString, Bundle paramBundle)
  {
    Object localObject1 = (RedAppInfo)paramBundle.getParcelable("redInfo");
    paramBundle = new JSONObject();
    Object localObject2 = new JSONObject();
    if (localObject1 == null) {}
    try
    {
      paramBundle.put("code", -1);
      paramBundle.put("errorMessage", "missing path");
      break label143;
      if (((RedAppInfo)localObject1).c() == -1)
      {
        paramBundle.put("code", -3);
        paramBundle.put("errorMessage", "appInfo not found");
      }
      else
      {
        paramBundle.put("code", 0);
        ((JSONObject)localObject2).put("hintType", ((RedAppInfo)localObject1).c());
        ((JSONObject)localObject2).put("number", ((RedAppInfo)localObject1).i());
        ((JSONObject)localObject2).put("isShow", ((RedAppInfo)localObject1).b());
        paramBundle.put("data", localObject2);
      }
      label143:
      if (QLog.isColorLevel())
      {
        localObject1 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getRedPointShowInfo:");
        ((StringBuilder)localObject2).append(paramBundle.toString());
        QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
    }
    catch (JSONException localJSONException1)
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
    }
    callJs(paramString, new String[] { paramBundle.toString() });
  }
  
  private void ipcItemClick(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("path", paramString);
    super.sendRemoteReq(DataFactory.a("myIndividuationRedInfo", null, 0, localBundle), false, true);
  }
  
  /* Error */
  public static HashMap<String, Object> parseGetAppInfo(AppInterface paramAppInterface, long paramLong, String paramString)
  {
    // Byte code:
    //   0: new 91	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 92	org/json/JSONObject:<init>	()V
    //   7: astore 17
    //   9: new 91	org/json/JSONObject
    //   12: dup
    //   13: invokespecial 92	org/json/JSONObject:<init>	()V
    //   16: astore 16
    //   18: new 141	java/util/ArrayList
    //   21: dup
    //   22: invokespecial 142	java/util/ArrayList:<init>	()V
    //   25: astore 18
    //   27: aconst_null
    //   28: astore 13
    //   30: aconst_null
    //   31: astore 14
    //   33: bipush 254
    //   35: istore 5
    //   37: new 91	org/json/JSONObject
    //   40: dup
    //   41: aload_3
    //   42: invokespecial 342	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   45: astore 12
    //   47: aload 12
    //   49: ldc 23
    //   51: invokevirtual 358	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   54: astore_3
    //   55: aload 12
    //   57: ldc 29
    //   59: invokevirtual 358	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   62: astore 11
    //   64: aload 12
    //   66: ldc_w 366
    //   69: invokevirtual 347	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   72: istore 10
    //   74: iload 10
    //   76: ifeq +46 -> 122
    //   79: aload 12
    //   81: ldc_w 366
    //   84: invokevirtual 358	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   87: astore 12
    //   89: aload 12
    //   91: astore 13
    //   93: goto +33 -> 126
    //   96: astore 14
    //   98: ldc 149
    //   100: astore 15
    //   102: bipush 254
    //   104: istore 5
    //   106: iconst_0
    //   107: istore 4
    //   109: aload_3
    //   110: astore 12
    //   112: aload 13
    //   114: astore_3
    //   115: aload 15
    //   117: astore 13
    //   119: goto +760 -> 879
    //   122: ldc 149
    //   124: astore 13
    //   126: aload_0
    //   127: aload 11
    //   129: invokestatic 764	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:getAppInfoByPath	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;)Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;
    //   132: astore 12
    //   134: aload 12
    //   136: ifnonnull +86 -> 222
    //   139: aload 17
    //   141: ldc_w 396
    //   144: bipush 253
    //   146: invokevirtual 117	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   149: pop
    //   150: aload 17
    //   152: ldc 26
    //   154: ldc_w 766
    //   157: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   160: pop
    //   161: aload 17
    //   163: ldc_w 768
    //   166: lload_1
    //   167: invokevirtual 771	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   170: pop
    //   171: aload 17
    //   173: ldc_w 773
    //   176: invokestatic 777	java/lang/System:currentTimeMillis	()J
    //   179: invokevirtual 771	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   182: pop
    //   183: bipush 253
    //   185: istore 5
    //   187: goto +489 -> 676
    //   190: astore 14
    //   192: goto +5 -> 197
    //   195: astore 14
    //   197: aload_3
    //   198: astore 16
    //   200: aload 11
    //   202: astore 15
    //   204: aload 14
    //   206: astore_3
    //   207: aload 16
    //   209: astore 11
    //   211: aload 12
    //   213: astore 14
    //   215: aload 15
    //   217: astore 12
    //   219: goto +631 -> 850
    //   222: aload 12
    //   224: getfield 386	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:red_display_info	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedDisplayInfo;
    //   227: invokevirtual 780	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedDisplayInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   230: astore 14
    //   232: aload 14
    //   234: ifnull +442 -> 676
    //   237: aload 12
    //   239: getfield 386	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:red_display_info	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedDisplayInfo;
    //   242: getfield 391	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedDisplayInfo:red_type_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   245: invokevirtual 257	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   248: astore 14
    //   250: aload 17
    //   252: ldc_w 396
    //   255: iconst_0
    //   256: invokevirtual 117	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   259: pop
    //   260: aload 11
    //   262: astore 15
    //   264: aload 16
    //   266: ldc_w 400
    //   269: aload 12
    //   271: getfield 403	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:uiAppId	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   274: invokevirtual 113	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   277: invokevirtual 117	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   280: pop
    //   281: aload 16
    //   283: ldc_w 404
    //   286: aload 12
    //   288: getfield 287	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:iNewFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   291: invokevirtual 290	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   294: invokevirtual 117	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   297: pop
    //   298: aload 12
    //   300: getfield 287	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:iNewFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   303: invokevirtual 290	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   306: istore 5
    //   308: new 144	org/json/JSONArray
    //   311: dup
    //   312: invokespecial 339	org/json/JSONArray:<init>	()V
    //   315: astore 19
    //   317: iload 5
    //   319: istore 4
    //   321: iconst_0
    //   322: istore 6
    //   324: aload 12
    //   326: getfield 408	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   329: invokevirtual 411	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   332: istore 7
    //   334: iload 6
    //   336: iload 7
    //   338: if_icmpge +49 -> 387
    //   341: aload 19
    //   343: aload 12
    //   345: getfield 408	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   348: iload 6
    //   350: invokevirtual 412	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   353: invokevirtual 361	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   356: pop
    //   357: aload 18
    //   359: aload 12
    //   361: getfield 408	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   364: iload 6
    //   366: invokevirtual 412	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   369: invokevirtual 394	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   372: pop
    //   373: iload 6
    //   375: iconst_1
    //   376: iadd
    //   377: istore 6
    //   379: goto -55 -> 324
    //   382: astore 14
    //   384: goto +225 -> 609
    //   387: aload 16
    //   389: ldc_w 371
    //   392: aload 14
    //   394: invokestatic 167	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:buidRedJson	(Ljava/util/List;)Lorg/json/JSONObject;
    //   397: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   400: pop
    //   401: aload 16
    //   403: ldc_w 413
    //   406: aload 19
    //   408: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   411: pop
    //   412: aload 16
    //   414: ldc 38
    //   416: aload 12
    //   418: getfield 393	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   421: invokevirtual 113	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   424: invokevirtual 117	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   427: pop
    //   428: aload 16
    //   430: ldc_w 415
    //   433: aload 12
    //   435: getfield 417	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:extend	Lcom/tencent/mobileqq/pb/PBStringField;
    //   438: invokevirtual 127	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   441: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   444: pop
    //   445: aload 16
    //   447: ldc_w 419
    //   450: aload 12
    //   452: getfield 421	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   455: invokevirtual 127	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   458: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   461: pop
    //   462: aload 16
    //   464: ldc 29
    //   466: aload 12
    //   468: getfield 274	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   471: invokevirtual 127	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   474: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   477: pop
    //   478: aload 16
    //   480: ldc_w 423
    //   483: aload 12
    //   485: getfield 425	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:appset	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   488: invokevirtual 290	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   491: invokevirtual 117	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   494: pop
    //   495: aload 16
    //   497: ldc_w 427
    //   500: aload 12
    //   502: getfield 429	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:modify_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   505: invokevirtual 113	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   508: invokevirtual 117	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   511: pop
    //   512: aload 16
    //   514: ldc_w 431
    //   517: aload 12
    //   519: getfield 433	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:num	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   522: invokevirtual 290	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   525: invokevirtual 117	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   528: pop
    //   529: aload 16
    //   531: ldc_w 435
    //   534: aload 12
    //   536: getfield 437	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:push_red_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   539: invokevirtual 113	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   542: invokevirtual 117	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   545: pop
    //   546: aload 17
    //   548: ldc_w 439
    //   551: aload 16
    //   553: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   556: pop
    //   557: aload 17
    //   559: ldc_w 782
    //   562: lload_1
    //   563: invokevirtual 771	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   566: pop
    //   567: invokestatic 777	java/lang/System:currentTimeMillis	()J
    //   570: lstore 8
    //   572: aload 17
    //   574: ldc_w 784
    //   577: lload 8
    //   579: invokevirtual 771	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   582: pop
    //   583: iconst_0
    //   584: istore 5
    //   586: goto +93 -> 679
    //   589: astore 11
    //   591: goto +10 -> 601
    //   594: astore 11
    //   596: goto +5 -> 601
    //   599: astore 11
    //   601: iload 5
    //   603: istore 4
    //   605: aload 11
    //   607: astore 14
    //   609: aload 12
    //   611: astore 11
    //   613: iconst_0
    //   614: istore 5
    //   616: aload_3
    //   617: astore 12
    //   619: aload 11
    //   621: astore_3
    //   622: aload 15
    //   624: astore 11
    //   626: goto +253 -> 879
    //   629: astore 14
    //   631: goto +5 -> 636
    //   634: astore 14
    //   636: aload 12
    //   638: astore 15
    //   640: iconst_0
    //   641: istore 5
    //   643: aload_3
    //   644: astore 12
    //   646: aload 11
    //   648: astore 16
    //   650: goto +219 -> 869
    //   653: astore 14
    //   655: aload 11
    //   657: astore 15
    //   659: aload_3
    //   660: astore 11
    //   662: aload 14
    //   664: astore_3
    //   665: aload 12
    //   667: astore 14
    //   669: aload 15
    //   671: astore 12
    //   673: goto +177 -> 850
    //   676: iconst_0
    //   677: istore 4
    //   679: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   682: ifeq +56 -> 738
    //   685: getstatic 222	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   688: astore 14
    //   690: new 187	java/lang/StringBuilder
    //   693: dup
    //   694: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   697: astore 15
    //   699: aload 15
    //   701: ldc_w 443
    //   704: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: pop
    //   708: aload 15
    //   710: aload 17
    //   712: invokevirtual 362	org/json/JSONObject:toString	()Ljava/lang/String;
    //   715: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: pop
    //   719: aload 14
    //   721: iconst_2
    //   722: aload 15
    //   724: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   727: invokestatic 228	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   730: goto +8 -> 738
    //   733: astore 14
    //   735: goto +8 -> 743
    //   738: goto +315 -> 1053
    //   741: astore 14
    //   743: aload 12
    //   745: astore 15
    //   747: aload_3
    //   748: astore 12
    //   750: aload 15
    //   752: astore_3
    //   753: goto +126 -> 879
    //   756: astore 14
    //   758: aload 11
    //   760: astore 15
    //   762: aload_3
    //   763: astore 11
    //   765: aload 14
    //   767: astore_3
    //   768: aload 12
    //   770: astore 14
    //   772: aload 15
    //   774: astore 12
    //   776: goto +74 -> 850
    //   779: astore 15
    //   781: aload 11
    //   783: astore 12
    //   785: aload_3
    //   786: astore 11
    //   788: aload 15
    //   790: astore_3
    //   791: goto +59 -> 850
    //   794: astore 15
    //   796: aload 11
    //   798: astore 12
    //   800: aload_3
    //   801: astore 11
    //   803: ldc 149
    //   805: astore 13
    //   807: aload 15
    //   809: astore_3
    //   810: goto +40 -> 850
    //   813: astore 15
    //   815: aload_3
    //   816: astore 11
    //   818: ldc 149
    //   820: astore 13
    //   822: aload 13
    //   824: astore 12
    //   826: aload 15
    //   828: astore_3
    //   829: goto +21 -> 850
    //   832: astore_3
    //   833: goto +5 -> 838
    //   836: astore 11
    //   838: ldc 149
    //   840: astore 13
    //   842: aload 13
    //   844: astore 12
    //   846: ldc 23
    //   848: astore 11
    //   850: bipush 254
    //   852: istore 5
    //   854: aload 12
    //   856: astore 16
    //   858: aload 14
    //   860: astore 15
    //   862: aload 11
    //   864: astore 12
    //   866: aload_3
    //   867: astore 14
    //   869: iconst_0
    //   870: istore 4
    //   872: aload 16
    //   874: astore 11
    //   876: aload 15
    //   878: astore_3
    //   879: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   882: ifeq +48 -> 930
    //   885: getstatic 222	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   888: astore 15
    //   890: new 187	java/lang/StringBuilder
    //   893: dup
    //   894: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   897: astore 16
    //   899: aload 16
    //   901: ldc_w 786
    //   904: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: pop
    //   908: aload 16
    //   910: aload 14
    //   912: invokevirtual 789	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   915: pop
    //   916: aload 15
    //   918: iconst_2
    //   919: aload 16
    //   921: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   924: invokestatic 228	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   927: goto +3 -> 930
    //   930: aload 17
    //   932: ldc_w 396
    //   935: iconst_m1
    //   936: invokevirtual 117	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   939: pop
    //   940: aload 17
    //   942: ldc 26
    //   944: ldc_w 791
    //   947: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   950: pop
    //   951: aload 17
    //   953: ldc_w 782
    //   956: lload_1
    //   957: invokevirtual 771	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   960: pop
    //   961: aload 17
    //   963: ldc_w 784
    //   966: invokestatic 777	java/lang/System:currentTimeMillis	()J
    //   969: invokevirtual 771	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   972: pop
    //   973: aload_3
    //   974: astore 14
    //   976: iconst_m1
    //   977: istore 5
    //   979: aload 12
    //   981: astore_3
    //   982: aload 13
    //   984: astore 12
    //   986: aload 14
    //   988: astore 13
    //   990: goto +75 -> 1065
    //   993: astore 14
    //   995: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   998: ifeq +45 -> 1043
    //   1001: getstatic 222	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   1004: astore 15
    //   1006: new 187	java/lang/StringBuilder
    //   1009: dup
    //   1010: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   1013: astore 16
    //   1015: aload 16
    //   1017: ldc_w 793
    //   1020: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1023: pop
    //   1024: aload 16
    //   1026: aload 14
    //   1028: invokevirtual 789	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1031: pop
    //   1032: aload 15
    //   1034: iconst_2
    //   1035: aload 16
    //   1037: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1040: invokestatic 228	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1043: aload 12
    //   1045: astore 14
    //   1047: aload_3
    //   1048: astore 12
    //   1050: aload 14
    //   1052: astore_3
    //   1053: aload 13
    //   1055: astore 14
    //   1057: aload 12
    //   1059: astore 13
    //   1061: aload 14
    //   1063: astore 12
    //   1065: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1068: ifeq +48 -> 1116
    //   1071: getstatic 222	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   1074: astore 14
    //   1076: new 187	java/lang/StringBuilder
    //   1079: dup
    //   1080: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   1083: astore 15
    //   1085: aload 15
    //   1087: ldc_w 443
    //   1090: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1093: pop
    //   1094: aload 15
    //   1096: aload 17
    //   1098: invokevirtual 362	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1101: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1104: pop
    //   1105: aload 14
    //   1107: iconst_2
    //   1108: aload 15
    //   1110: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1113: invokestatic 228	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1116: iload 4
    //   1118: istore 6
    //   1120: aload_0
    //   1121: ifnull +36 -> 1157
    //   1124: aload_0
    //   1125: invokestatic 335	com/tencent/mobileqq/tianshu/utils/RedTouchUtil:a	(Lcom/tencent/common/app/AppInterface;)Ljava/lang/String;
    //   1128: astore_0
    //   1129: iload 4
    //   1131: istore 6
    //   1133: aload 11
    //   1135: invokestatic 159	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1138: ifne +19 -> 1157
    //   1141: iload 4
    //   1143: istore 6
    //   1145: aload 11
    //   1147: aload_0
    //   1148: invokevirtual 279	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1151: ifeq +6 -> 1157
    //   1154: iconst_1
    //   1155: istore 6
    //   1157: aload 13
    //   1159: ifnull +18 -> 1177
    //   1162: aload 13
    //   1164: getfield 421	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1167: invokevirtual 127	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1170: invokestatic 441	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:getReportBufferString	(Ljava/lang/String;)Ljava/lang/String;
    //   1173: astore_0
    //   1174: goto +6 -> 1180
    //   1177: ldc 149
    //   1179: astore_0
    //   1180: new 368	android/os/Bundle
    //   1183: dup
    //   1184: invokespecial 454	android/os/Bundle:<init>	()V
    //   1187: astore 13
    //   1189: aload 13
    //   1191: ldc 32
    //   1193: iload 5
    //   1195: invokestatic 458	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1198: invokevirtual 462	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1201: aload 13
    //   1203: ldc_w 419
    //   1206: aload_0
    //   1207: invokevirtual 462	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1210: aload 13
    //   1212: ldc_w 464
    //   1215: iload 6
    //   1217: invokestatic 458	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1220: invokevirtual 462	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1223: aload 13
    //   1225: ldc_w 413
    //   1228: aload 18
    //   1230: invokevirtual 468	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1233: aload 13
    //   1235: ldc 29
    //   1237: aload 11
    //   1239: invokevirtual 462	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1242: aload 13
    //   1244: ldc_w 366
    //   1247: aload 12
    //   1249: invokevirtual 462	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1252: aload 13
    //   1254: ldc 23
    //   1256: aload_3
    //   1257: invokevirtual 462	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1260: new 795	java/util/HashMap
    //   1263: dup
    //   1264: invokespecial 796	java/util/HashMap:<init>	()V
    //   1267: astore_0
    //   1268: aload_0
    //   1269: ldc_w 798
    //   1272: aload_3
    //   1273: invokevirtual 801	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1276: pop
    //   1277: aload_0
    //   1278: ldc_w 803
    //   1281: aload 13
    //   1283: invokevirtual 801	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1286: pop
    //   1287: aload_0
    //   1288: ldc_w 805
    //   1291: aload 17
    //   1293: invokevirtual 362	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1296: invokevirtual 801	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1299: pop
    //   1300: aload_0
    //   1301: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1302	0	paramAppInterface	AppInterface
    //   0	1302	1	paramLong	long
    //   0	1302	3	paramString	String
    //   107	571	4	i	int
    //   35	607	5	j	int
    //   322	56	6	k	int
    //   332	7	7	m	int
    //   570	8	8	l	long
    //   72	3	10	bool	boolean
    //   62	199	11	localObject1	Object
    //   589	1	11	localException1	Exception
    //   594	1	11	localException2	Exception
    //   599	7	11	localException3	Exception
    //   611	206	11	localObject2	Object
    //   45	780	12	localObject3	Object
    //   28	795	13	localObject4	Object
    //   31	1	14	localObject5	Object
    //   96	1	14	localException4	Exception
    //   190	1	14	localException5	Exception
    //   195	10	14	localException6	Exception
    //   213	36	14	localObject6	Object
    //   382	11	14	localException7	Exception
    //   607	1	14	localObject7	Object
    //   629	1	14	localException8	Exception
    //   634	1	14	localException9	Exception
    //   653	10	14	localException10	Exception
    //   667	53	14	localObject8	Object
    //   733	1	14	localException11	Exception
    //   741	1	14	localException12	Exception
    //   756	10	14	localException13	Exception
    //   770	1	14	localObject9	Object
    //   100	673	15	localObject10	Object
    //   779	10	15	localException14	Exception
    //   794	14	15	localException15	Exception
    //   813	14	15	localException16	Exception
    //   16	633	16	localObject11	Object
    //   7	704	17	localJSONObject	JSONObject
    //   25	333	18	localArrayList	ArrayList
    //   315	92	19	localJSONArray	JSONArray
    // Exception table:
    //   from	to	target	type
    //   79	89	96	java/lang/Exception
    //   171	183	190	java/lang/Exception
    //   139	171	195	java/lang/Exception
    //   341	373	382	java/lang/Exception
    //   572	583	589	java/lang/Exception
    //   324	334	594	java/lang/Exception
    //   387	572	594	java/lang/Exception
    //   308	317	599	java/lang/Exception
    //   264	308	629	java/lang/Exception
    //   250	260	634	java/lang/Exception
    //   237	250	653	java/lang/Exception
    //   699	730	733	java/lang/Exception
    //   679	699	741	java/lang/Exception
    //   222	232	756	java/lang/Exception
    //   126	134	779	java/lang/Exception
    //   64	74	794	java/lang/Exception
    //   55	64	813	java/lang/Exception
    //   37	55	832	java/lang/Exception
    //   930	973	993	org/json/JSONException
  }
  
  /* Error */
  public static HashMap<String, Object> parseGetAppInfoList(AppInterface paramAppInterface, long paramLong, String paramString)
  {
    // Byte code:
    //   0: lload_1
    //   1: lstore 7
    //   3: ldc_w 784
    //   6: astore 16
    //   8: ldc_w 366
    //   11: astore 14
    //   13: ldc 23
    //   15: astore 12
    //   17: new 91	org/json/JSONObject
    //   20: dup
    //   21: invokespecial 92	org/json/JSONObject:<init>	()V
    //   24: astore 18
    //   26: new 144	org/json/JSONArray
    //   29: dup
    //   30: invokespecial 339	org/json/JSONArray:<init>	()V
    //   33: astore 20
    //   35: new 141	java/util/ArrayList
    //   38: dup
    //   39: invokespecial 142	java/util/ArrayList:<init>	()V
    //   42: astore 19
    //   44: new 91	org/json/JSONObject
    //   47: dup
    //   48: aload_3
    //   49: invokespecial 342	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   52: astore 10
    //   54: aload 10
    //   56: ldc 23
    //   58: invokevirtual 358	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   61: astore_3
    //   62: aload 10
    //   64: ldc_w 809
    //   67: invokevirtual 813	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   70: astore 11
    //   72: aload 10
    //   74: ldc_w 366
    //   77: invokevirtual 347	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   80: istore 9
    //   82: iload 9
    //   84: ifeq +25 -> 109
    //   87: aload 10
    //   89: ldc_w 366
    //   92: invokevirtual 358	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   95: astore 10
    //   97: goto +16 -> 113
    //   100: astore 13
    //   102: ldc 149
    //   104: astore 14
    //   106: goto +826 -> 932
    //   109: ldc 149
    //   111: astore 10
    //   113: aload_0
    //   114: aconst_null
    //   115: aload 11
    //   117: invokestatic 815	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:buildPaths	(Ljava/util/List;Lorg/json/JSONArray;)Ljava/util/List;
    //   120: invokestatic 817	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:getAppInfoListByPath	(Lcom/tencent/common/app/AppInterface;Ljava/util/List;)Ljava/util/List;
    //   123: astore 11
    //   125: aload 11
    //   127: astore 13
    //   129: bipush 253
    //   131: istore 5
    //   133: aload 13
    //   135: ifnull +676 -> 811
    //   138: aload 13
    //   140: invokeinterface 302 1 0
    //   145: ifeq +6 -> 151
    //   148: goto +663 -> 811
    //   151: aload 13
    //   153: invokeinterface 261 1 0
    //   158: astore 15
    //   160: iconst_0
    //   161: istore 4
    //   163: aload 16
    //   165: astore 11
    //   167: aload 15
    //   169: invokeinterface 266 1 0
    //   174: istore 9
    //   176: iload 9
    //   178: ifeq +460 -> 638
    //   181: aload 15
    //   183: invokeinterface 270 1 0
    //   188: astore 16
    //   190: aload 16
    //   192: checkcast 272	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo
    //   195: astore 16
    //   197: aload 16
    //   199: getfield 386	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:red_display_info	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedDisplayInfo;
    //   202: invokevirtual 780	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedDisplayInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   205: ifnull +420 -> 625
    //   208: new 91	org/json/JSONObject
    //   211: dup
    //   212: invokespecial 92	org/json/JSONObject:<init>	()V
    //   215: astore 17
    //   217: new 141	java/util/ArrayList
    //   220: dup
    //   221: invokespecial 142	java/util/ArrayList:<init>	()V
    //   224: astore 21
    //   226: aload 16
    //   228: getfield 386	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:red_display_info	Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedDisplayInfo;
    //   231: getfield 391	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedDisplayInfo:red_type_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   234: invokevirtual 257	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   237: astore 22
    //   239: iload 4
    //   241: istore 5
    //   243: aload 17
    //   245: ldc_w 400
    //   248: aload 16
    //   250: getfield 403	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:uiAppId	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   253: invokevirtual 113	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   256: invokevirtual 117	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   259: pop
    //   260: iload 4
    //   262: istore 5
    //   264: aload 17
    //   266: ldc_w 404
    //   269: aload 16
    //   271: getfield 287	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:iNewFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   274: invokevirtual 290	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   277: invokevirtual 117	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   280: pop
    //   281: iload 4
    //   283: istore 5
    //   285: aload 16
    //   287: getfield 287	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:iNewFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   290: invokevirtual 290	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   293: istore 4
    //   295: new 144	org/json/JSONArray
    //   298: dup
    //   299: invokespecial 339	org/json/JSONArray:<init>	()V
    //   302: astore 23
    //   304: iconst_0
    //   305: istore 6
    //   307: iload 4
    //   309: istore 5
    //   311: iload 6
    //   313: aload 16
    //   315: getfield 408	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   318: invokevirtual 411	com/tencent/mobileqq/pb/PBRepeatField:size	()I
    //   321: if_icmpge +52 -> 373
    //   324: iload 4
    //   326: istore 5
    //   328: aload 23
    //   330: aload 16
    //   332: getfield 408	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   335: iload 6
    //   337: invokevirtual 412	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   340: invokevirtual 361	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   343: pop
    //   344: iload 4
    //   346: istore 5
    //   348: aload 21
    //   350: aload 16
    //   352: getfield 408	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:missions	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   355: iload 6
    //   357: invokevirtual 412	com/tencent/mobileqq/pb/PBRepeatField:get	(I)Ljava/lang/Object;
    //   360: invokevirtual 394	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   363: pop
    //   364: iload 6
    //   366: iconst_1
    //   367: iadd
    //   368: istore 6
    //   370: goto -63 -> 307
    //   373: iload 4
    //   375: istore 5
    //   377: aload 19
    //   379: aload 21
    //   381: invokeinterface 163 2 0
    //   386: pop
    //   387: iload 4
    //   389: istore 5
    //   391: aload 17
    //   393: ldc_w 371
    //   396: aload 22
    //   398: invokestatic 819	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:buildRedJson	(Ljava/util/List;)Lorg/json/JSONObject;
    //   401: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   404: pop
    //   405: iload 4
    //   407: istore 5
    //   409: aload 17
    //   411: ldc_w 415
    //   414: aload 16
    //   416: getfield 417	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:extend	Lcom/tencent/mobileqq/pb/PBStringField;
    //   419: invokevirtual 127	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   422: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   425: pop
    //   426: iload 4
    //   428: istore 5
    //   430: aload 17
    //   432: ldc_w 413
    //   435: aload 23
    //   437: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   440: pop
    //   441: iload 4
    //   443: istore 5
    //   445: aload 17
    //   447: ldc 38
    //   449: aload 16
    //   451: getfield 393	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   454: invokevirtual 113	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   457: invokevirtual 117	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   460: pop
    //   461: iload 4
    //   463: istore 5
    //   465: aload 17
    //   467: ldc_w 419
    //   470: aload 16
    //   472: getfield 421	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   475: invokevirtual 127	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   478: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   481: pop
    //   482: iload 4
    //   484: istore 5
    //   486: aload 17
    //   488: ldc 29
    //   490: aload 16
    //   492: getfield 274	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   495: invokevirtual 127	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   498: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   501: pop
    //   502: iload 4
    //   504: istore 5
    //   506: aload 17
    //   508: ldc_w 423
    //   511: aload 16
    //   513: getfield 425	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:appset	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   516: invokevirtual 290	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   519: invokevirtual 117	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   522: pop
    //   523: iload 4
    //   525: istore 5
    //   527: aload 17
    //   529: ldc_w 427
    //   532: aload 16
    //   534: getfield 429	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:modify_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   537: invokevirtual 113	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   540: invokevirtual 117	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   543: pop
    //   544: iload 4
    //   546: istore 5
    //   548: aload 17
    //   550: ldc_w 431
    //   553: aload 16
    //   555: getfield 433	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:num	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   558: invokevirtual 290	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   561: invokevirtual 117	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   564: pop
    //   565: iload 4
    //   567: istore 5
    //   569: aload 17
    //   571: ldc_w 435
    //   574: aload 16
    //   576: getfield 437	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:push_red_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   579: invokevirtual 113	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   582: invokevirtual 117	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   585: pop
    //   586: iload 4
    //   588: istore 5
    //   590: aload 20
    //   592: aload 17
    //   594: invokevirtual 361	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   597: pop
    //   598: goto +27 -> 625
    //   601: astore 15
    //   603: goto +9 -> 612
    //   606: astore 15
    //   608: iload 5
    //   610: istore 4
    //   612: goto +126 -> 738
    //   615: astore 15
    //   617: goto +18 -> 635
    //   620: astore 15
    //   622: goto +13 -> 635
    //   625: goto -458 -> 167
    //   628: astore 15
    //   630: goto +5 -> 635
    //   633: astore 15
    //   635: goto +103 -> 738
    //   638: aload 13
    //   640: astore 17
    //   642: aload 14
    //   644: astore 16
    //   646: aload 18
    //   648: ldc_w 396
    //   651: iconst_0
    //   652: invokevirtual 117	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   655: pop
    //   656: aload 18
    //   658: ldc_w 439
    //   661: aload 20
    //   663: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   666: pop
    //   667: aload 18
    //   669: ldc_w 782
    //   672: lload_1
    //   673: invokevirtual 771	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   676: pop
    //   677: invokestatic 777	java/lang/System:currentTimeMillis	()J
    //   680: lstore 7
    //   682: aload 18
    //   684: aload 11
    //   686: lload 7
    //   688: invokevirtual 771	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   691: pop
    //   692: iconst_0
    //   693: istore 5
    //   695: goto +177 -> 872
    //   698: astore 13
    //   700: goto +10 -> 710
    //   703: astore 13
    //   705: goto +5 -> 710
    //   708: astore 13
    //   710: iconst_0
    //   711: istore 5
    //   713: aload 11
    //   715: astore 15
    //   717: aload 10
    //   719: astore 14
    //   721: aload 17
    //   723: astore 11
    //   725: aload 12
    //   727: astore 10
    //   729: aload 16
    //   731: astore 12
    //   733: goto +223 -> 956
    //   736: astore 15
    //   738: aload 14
    //   740: astore 16
    //   742: aload 13
    //   744: astore 17
    //   746: bipush 254
    //   748: istore 5
    //   750: aload 15
    //   752: astore 13
    //   754: aload 11
    //   756: astore 15
    //   758: aload 10
    //   760: astore 14
    //   762: aload 17
    //   764: astore 11
    //   766: aload 12
    //   768: astore 10
    //   770: aload 16
    //   772: astore 12
    //   774: goto +182 -> 956
    //   777: astore 13
    //   779: ldc_w 366
    //   782: astore 12
    //   784: ldc 23
    //   786: astore 16
    //   788: ldc_w 784
    //   791: astore 15
    //   793: bipush 254
    //   795: istore 5
    //   797: iconst_0
    //   798: istore 4
    //   800: aload 10
    //   802: astore 14
    //   804: aload 16
    //   806: astore 10
    //   808: goto +148 -> 956
    //   811: ldc_w 366
    //   814: astore 16
    //   816: ldc 23
    //   818: astore 12
    //   820: aload 18
    //   822: ldc_w 396
    //   825: bipush 253
    //   827: invokevirtual 117	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   830: pop
    //   831: aload 18
    //   833: ldc 26
    //   835: ldc_w 821
    //   838: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   841: pop
    //   842: aload 18
    //   844: ldc_w 768
    //   847: lload 7
    //   849: invokevirtual 771	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   852: pop
    //   853: aload 18
    //   855: ldc_w 773
    //   858: invokestatic 777	java/lang/System:currentTimeMillis	()J
    //   861: invokevirtual 771	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   864: pop
    //   865: iconst_0
    //   866: istore 4
    //   868: aload 13
    //   870: astore 17
    //   872: aload 10
    //   874: astore 14
    //   876: aload 17
    //   878: astore 11
    //   880: aload 12
    //   882: astore 10
    //   884: aload 16
    //   886: astore 12
    //   888: goto +136 -> 1024
    //   891: astore 13
    //   893: goto +5 -> 898
    //   896: astore 13
    //   898: goto -119 -> 779
    //   901: astore 13
    //   903: aload 10
    //   905: astore 14
    //   907: goto +25 -> 932
    //   910: astore 13
    //   912: ldc 149
    //   914: astore 14
    //   916: goto +16 -> 932
    //   919: astore 13
    //   921: goto +4 -> 925
    //   924: astore_3
    //   925: ldc 149
    //   927: astore 14
    //   929: ldc 23
    //   931: astore_3
    //   932: ldc_w 366
    //   935: astore 12
    //   937: ldc 23
    //   939: astore 10
    //   941: ldc_w 784
    //   944: astore 15
    //   946: bipush 254
    //   948: istore 5
    //   950: iconst_0
    //   951: istore 4
    //   953: aconst_null
    //   954: astore 11
    //   956: aload 13
    //   958: invokevirtual 294	java/lang/Exception:printStackTrace	()V
    //   961: aload 18
    //   963: ldc_w 396
    //   966: iconst_m1
    //   967: invokevirtual 117	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   970: pop
    //   971: aload 18
    //   973: ldc 26
    //   975: ldc_w 791
    //   978: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   981: pop
    //   982: aload 18
    //   984: ldc_w 782
    //   987: lload_1
    //   988: invokevirtual 771	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   991: pop
    //   992: aload 18
    //   994: aload 15
    //   996: invokestatic 777	java/lang/System:currentTimeMillis	()J
    //   999: invokevirtual 771	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1002: pop
    //   1003: iconst_m1
    //   1004: istore 5
    //   1006: aload 11
    //   1008: astore 13
    //   1010: aload 14
    //   1012: astore 11
    //   1014: goto +18 -> 1032
    //   1017: astore 13
    //   1019: aload 13
    //   1021: invokevirtual 327	org/json/JSONException:printStackTrace	()V
    //   1024: aload 11
    //   1026: astore 13
    //   1028: aload 14
    //   1030: astore 11
    //   1032: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1035: ifeq +48 -> 1083
    //   1038: getstatic 222	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   1041: astore 14
    //   1043: new 187	java/lang/StringBuilder
    //   1046: dup
    //   1047: invokespecial 188	java/lang/StringBuilder:<init>	()V
    //   1050: astore 15
    //   1052: aload 15
    //   1054: ldc_w 823
    //   1057: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1060: pop
    //   1061: aload 15
    //   1063: aload 18
    //   1065: invokevirtual 362	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1068: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1071: pop
    //   1072: aload 14
    //   1074: iconst_2
    //   1075: aload 15
    //   1077: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1080: invokestatic 228	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1083: aload_0
    //   1084: aload 13
    //   1086: iload 4
    //   1088: invokestatic 825	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:getReddot	(Lcom/tencent/common/app/AppInterface;Ljava/util/List;I)I
    //   1091: istore 4
    //   1093: aload 13
    //   1095: ifnull +29 -> 1124
    //   1098: aload 13
    //   1100: invokeinterface 302 1 0
    //   1105: ifne +19 -> 1124
    //   1108: aload 13
    //   1110: iconst_0
    //   1111: invokeinterface 104 2 0
    //   1116: checkcast 272	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo
    //   1119: astore 14
    //   1121: goto +6 -> 1127
    //   1124: aconst_null
    //   1125: astore 14
    //   1127: aload 19
    //   1129: invokeinterface 302 1 0
    //   1134: ifeq +14 -> 1148
    //   1137: new 141	java/util/ArrayList
    //   1140: dup
    //   1141: invokespecial 142	java/util/ArrayList:<init>	()V
    //   1144: astore_0
    //   1145: goto +15 -> 1160
    //   1148: aload 19
    //   1150: iconst_0
    //   1151: invokeinterface 104 2 0
    //   1156: checkcast 141	java/util/ArrayList
    //   1159: astore_0
    //   1160: aload 13
    //   1162: ifnull +35 -> 1197
    //   1165: aload 13
    //   1167: invokeinterface 302 1 0
    //   1172: ifne +25 -> 1197
    //   1175: aload 13
    //   1177: iconst_0
    //   1178: invokeinterface 104 2 0
    //   1183: checkcast 272	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo
    //   1186: getfield 274	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1189: invokevirtual 127	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1192: astore 13
    //   1194: goto +7 -> 1201
    //   1197: ldc 149
    //   1199: astore 13
    //   1201: aload 14
    //   1203: ifnull +19 -> 1222
    //   1206: aload 14
    //   1208: getfield 421	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1211: invokevirtual 127	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1214: invokestatic 441	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:getReportBufferString	(Ljava/lang/String;)Ljava/lang/String;
    //   1217: astore 14
    //   1219: goto +7 -> 1226
    //   1222: ldc 149
    //   1224: astore 14
    //   1226: new 368	android/os/Bundle
    //   1229: dup
    //   1230: invokespecial 454	android/os/Bundle:<init>	()V
    //   1233: astore 15
    //   1235: aload 15
    //   1237: ldc 32
    //   1239: iload 5
    //   1241: invokestatic 458	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1244: invokevirtual 462	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1247: aload 15
    //   1249: ldc_w 419
    //   1252: aload 14
    //   1254: invokevirtual 462	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1257: aload 15
    //   1259: ldc_w 464
    //   1262: iload 4
    //   1264: invokestatic 458	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1267: invokevirtual 462	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1270: aload 15
    //   1272: ldc_w 413
    //   1275: aload_0
    //   1276: invokevirtual 468	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   1279: aload 15
    //   1281: ldc 29
    //   1283: aload 13
    //   1285: invokevirtual 462	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1288: aload 15
    //   1290: aload 12
    //   1292: aload 11
    //   1294: invokevirtual 462	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1297: aload 15
    //   1299: aload 10
    //   1301: aload_3
    //   1302: invokevirtual 462	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1305: new 795	java/util/HashMap
    //   1308: dup
    //   1309: invokespecial 796	java/util/HashMap:<init>	()V
    //   1312: astore_0
    //   1313: aload_0
    //   1314: ldc_w 798
    //   1317: aload_3
    //   1318: invokevirtual 801	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1321: pop
    //   1322: aload_0
    //   1323: ldc_w 803
    //   1326: aload 15
    //   1328: invokevirtual 801	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1331: pop
    //   1332: aload_0
    //   1333: ldc_w 805
    //   1336: aload 18
    //   1338: invokevirtual 362	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1341: invokevirtual 801	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1344: pop
    //   1345: aload_0
    //   1346: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1347	0	paramAppInterface	AppInterface
    //   0	1347	1	paramLong	long
    //   0	1347	3	paramString	String
    //   161	706	4	i	int
    //   131	665	5	j	int
    //   305	64	6	k	int
    //   1	847	7	l	long
    //   80	97	9	bool	boolean
    //   52	852	10	localObject1	Object
    //   70	809	11	localObject2	Object
    //   15	872	12	localObject3	Object
    //   100	1	13	localException1	Exception
    //   127	512	13	localObject4	Object
    //   698	1	13	localException2	Exception
    //   703	1	13	localException3	Exception
    //   708	35	13	localException4	Exception
    //   752	1	13	localObject5	Object
    //   777	92	13	localException5	Exception
    //   891	1	13	localException6	Exception
    //   896	1	13	localException7	Exception
    //   901	1	13	localException8	Exception
    //   910	1	13	localException9	Exception
    //   919	1	13	localException10	Exception
    //   11	904	14	localObject6	Object
    //   158	24	15	localIterator	Iterator
    //   601	1	15	localException11	Exception
    //   606	1	15	localException12	Exception
    //   615	1	15	localException13	Exception
    //   620	1	15	localException14	Exception
    //   628	1	15	localException15	Exception
    //   633	1	15	localException16	Exception
    //   715	1	15	localObject7	Object
    //   736	15	15	localException17	Exception
    //   756	36	15	localObject8	Object
    //   6	879	16	localObject9	Object
    //   215	662	17	localObject10	Object
    //   24	830	18	localJSONObject	JSONObject
    //   42	336	19	localArrayList1	ArrayList
    //   33	629	20	localJSONArray1	JSONArray
    //   224	156	21	localArrayList2	ArrayList
    //   237	160	22	localList	List
    //   302	134	23	localJSONArray2	JSONArray
    // Exception table:
    //   from	to	target	type
    //   87	97	100	java/lang/Exception
    //   295	304	601	java/lang/Exception
    //   243	260	606	java/lang/Exception
    //   264	281	606	java/lang/Exception
    //   285	295	606	java/lang/Exception
    //   311	324	606	java/lang/Exception
    //   328	344	606	java/lang/Exception
    //   348	364	606	java/lang/Exception
    //   377	387	606	java/lang/Exception
    //   391	405	606	java/lang/Exception
    //   409	426	606	java/lang/Exception
    //   430	441	606	java/lang/Exception
    //   445	461	606	java/lang/Exception
    //   465	482	606	java/lang/Exception
    //   486	502	606	java/lang/Exception
    //   506	523	606	java/lang/Exception
    //   527	544	606	java/lang/Exception
    //   548	565	606	java/lang/Exception
    //   569	586	606	java/lang/Exception
    //   590	598	606	java/lang/Exception
    //   226	239	615	java/lang/Exception
    //   217	226	620	java/lang/Exception
    //   190	217	628	java/lang/Exception
    //   181	190	633	java/lang/Exception
    //   682	692	698	java/lang/Exception
    //   667	682	703	java/lang/Exception
    //   646	667	708	java/lang/Exception
    //   167	176	736	java/lang/Exception
    //   138	148	777	java/lang/Exception
    //   151	160	777	java/lang/Exception
    //   831	865	891	java/lang/Exception
    //   820	831	896	java/lang/Exception
    //   113	125	901	java/lang/Exception
    //   62	82	910	java/lang/Exception
    //   44	62	919	java/lang/Exception
    //   961	1003	1017	org/json/JSONException
  }
  
  public static HashMap<String, Object> parseSetAppInfoParam(String paramString)
  {
    HashMap localHashMap = new HashMap();
    JSONObject localJSONObject = new JSONObject();
    new JSONObject();
    try
    {
      Object localObject1 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject1).getString("callback");
      try
      {
        Object localObject2 = ((JSONObject)localObject1).getJSONObject("appInfo");
        localObject1 = new BusinessInfoCheckUpdate.AppInfo();
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).uiAppId.set(((JSONObject)localObject2).getInt("appID"));
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.set(((JSONObject)localObject2).getInt("iNewFlag"));
        JSONArray localJSONArray = ((JSONObject)localObject2).getJSONArray("missions");
        int i = 0;
        while (i < localJSONArray.length())
        {
          ((BusinessInfoCheckUpdate.AppInfo)localObject1).missions.add(localJSONArray.getString(i));
          i += 1;
        }
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).type.set(((JSONObject)localObject2).getInt("type"));
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.set(((JSONObject)localObject2).getString("buffer"));
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).path.set(((JSONObject)localObject2).getString("path"));
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).appset.set(((JSONObject)localObject2).getInt("appset"));
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).modify_ts.set(((JSONObject)localObject2).getInt("modify_ts"));
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).num.set(((JSONObject)localObject2).getInt("num"));
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).push_red_ts.set(((JSONObject)localObject2).getInt("push_red_ts"));
        ((BusinessInfoCheckUpdate.AppInfo)localObject1).extend.set(((JSONObject)localObject2).getString("extend"));
        localObject2 = new Bundle();
        ((Bundle)localObject2).putParcelable("red", RedTouchUtils.a((BusinessInfoCheckUpdate.AppInfo)localObject1));
        localHashMap.put("callback", paramString);
        localHashMap.put("req", localObject2);
        localHashMap.put("code", Integer.valueOf(0));
        return localHashMap;
      }
      catch (Exception localException1) {}
      localException2.printStackTrace();
    }
    catch (Exception localException2)
    {
      paramString = "callback";
    }
    try
    {
      localJSONObject.put("code", -1);
      localJSONObject.put("errorMessage", "missing appInfo or callback or appInfo json format error");
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    localHashMap.put("callback", paramString);
    localHashMap.put("code", Integer.valueOf(-1));
    localHashMap.put("errorJson", localJSONObject.toString());
    return localHashMap;
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
      label23:
      long l;
      String str;
      StringBuilder localStringBuilder;
      break label23;
    }
    l = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      str = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getappinfo js startime : ");
      localStringBuilder.append(l);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    ThreadManager.post(new RedTouchWebviewHandler.1(this, l, paramString), 8, null, true);
  }
  
  public void getAppInfoList(String paramString)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getappinfolist js startime : ");
      localStringBuilder.append(l);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    ThreadManager.post(new RedTouchWebviewHandler.2(this, l, paramString), 8, null, true);
  }
  
  public void getDynamicState(String paramString)
  {
    String str2 = null;
    String str1;
    Object localObject;
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      if (QLog.isColorLevel())
      {
        str1 = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Failed to parse json string: ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d(str1, 2, ((StringBuilder)localObject).toString());
      }
      str1 = null;
    }
    if (str1 == null) {
      return;
    }
    paramString = str2;
    try
    {
      str2 = str1.getString("callback");
      paramString = str2;
      localObject = new Bundle();
      paramString = str2;
      ((Bundle)localObject).putInt("path", RedTouchUtil.a(str1.getString("path")));
      paramString = str2;
      sendRemoteReq(DataFactory.a("leba_item_get", str2, this.mOnRemoteResp.key, (Bundle)localObject), false, false);
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
  
  public void getRedPointShowInfo(String paramString)
  {
    Object localObject2 = "callback";
    localJSONObject = new JSONObject();
    localObject1 = localObject2;
    try
    {
      localObject3 = new JSONObject(paramString);
      localObject1 = localObject2;
      paramString = ((JSONObject)localObject3).getString("callback");
      localObject1 = paramString;
      if (!((JSONObject)localObject3).isNull("set"))
      {
        localObject1 = paramString;
        localObject2 = ((JSONObject)localObject3).getString("set");
      }
    }
    catch (Exception paramString)
    {
      Object localObject3;
      int i;
      label175:
      paramString.printStackTrace();
      try
      {
        localJSONObject.put("code", -1);
        localJSONObject.put("errorMessage", "missing callback");
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      callJs((String)localObject1, new String[] { localJSONObject.toString() });
      return;
    }
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
      localObject1 = paramString;
      localObject2 = new Bundle();
      localObject1 = paramString;
      ((Bundle)localObject2).putInt("setId", i);
      localObject1 = paramString;
      super.sendRemoteReq(DataFactory.a("redTouch_getRedPointShowInfo_set", paramString, this.mOnRemoteResp.key, (Bundle)localObject2), false, true);
      return;
    }
    catch (Exception localException)
    {
      break label175;
    }
    localObject1 = paramString;
    localJSONObject.put("code", -3);
    localObject1 = paramString;
    localJSONObject.put("errorMessage", "redPoint showInfo not found");
    localObject1 = paramString;
    callJs(paramString, new String[] { localJSONObject.toString() });
    return;
    localObject1 = paramString;
    if (!((JSONObject)localObject3).isNull("path"))
    {
      localObject1 = paramString;
      localObject2 = ((JSONObject)localObject3).getString("path");
      localObject1 = paramString;
      localObject3 = new Bundle();
      localObject1 = paramString;
      ((Bundle)localObject3).putString("path", (String)localObject2);
      localObject1 = paramString;
      ((Bundle)localObject3).putString("subCmd", "redTouch_getRedPointShowInfo_path");
      localObject1 = paramString;
      super.sendRemoteReq(DataFactory.a("redTouch_getRedInfo", paramString, this.mOnRemoteResp.key, (Bundle)localObject3), false, true);
      return;
    }
    localObject1 = paramString;
    localJSONObject.put("code", -1);
    localObject1 = paramString;
    localJSONObject.put("errorMessage", "missing set and path");
    localObject1 = paramString;
    callJs(paramString, new String[] { localJSONObject.toString() });
  }
  
  public void getServerTime(String paramString)
  {
    String str = "callback";
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      paramString = new JSONObject(paramString).getString("callback");
      str = paramString;
      localJSONObject2.put("time", NetConnInfoCenter.getServerTimeMillis());
      str = paramString;
      localJSONObject1.put("data", localJSONObject2);
      str = paramString;
      localJSONObject1.put("code", 0);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      try
      {
        localJSONObject1.put("code", -1);
        localJSONObject1.put("errorMessage", "missing callback");
        paramString = str;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        paramString = str;
      }
    }
    callJs(paramString, new String[] { localJSONObject1.toString() });
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = false;
    int i = 0;
    if (paramString2 != null)
    {
      if (!paramString2.equalsIgnoreCase("redpoint")) {
        return false;
      }
      paramJsBridgeListener = new ArrayList();
      while (i < paramVarArgs.length)
      {
        paramJsBridgeListener.add(paramVarArgs[i]);
        i += 1;
      }
      bool = call(paramString3, paramJsBridgeListener);
    }
    return bool;
  }
  
  public void isEnterFromRedPoint(String paramString)
  {
    Object localObject2 = "callback";
    JSONObject localJSONObject = new JSONObject();
    Object localObject1 = localObject2;
    try
    {
      Object localObject3 = new JSONObject(paramString);
      localObject1 = localObject2;
      paramString = ((JSONObject)localObject3).getString("callback");
      localObject1 = paramString;
      localObject2 = ((JSONObject)localObject3).getString("path");
      localObject1 = paramString;
      boolean bool = RedTouchUtil.a(this.mRuntime.b()).equals(localObject2);
      if (!bool)
      {
        localObject1 = paramString;
        localJSONObject.put("code", 0);
        localObject1 = paramString;
        localJSONObject.put("data", 0);
      }
      else
      {
        localObject1 = paramString;
        localJSONObject.put("code", 0);
        localObject1 = paramString;
        localJSONObject.put("data", 1);
      }
      localObject1 = paramString;
      localObject2 = paramString;
      if (QLog.isColorLevel())
      {
        localObject1 = paramString;
        localObject2 = TAG;
        localObject1 = paramString;
        localObject3 = new StringBuilder();
        localObject1 = paramString;
        ((StringBuilder)localObject3).append("isEnterFromRedPoint:");
        localObject1 = paramString;
        ((StringBuilder)localObject3).append(localJSONObject.toString());
        localObject1 = paramString;
        QLog.i((String)localObject2, 2, ((StringBuilder)localObject3).toString());
        localObject2 = paramString;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      try
      {
        localJSONObject.put("code", -1);
        localJSONObject.put("errorMessage", "missing path or callback");
        localObject2 = localObject1;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        localObject2 = localObject1;
      }
    }
    callJs((String)localObject2, new String[] { localJSONObject.toString() });
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.browserApp = this.mRuntime.b();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onResponse(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    if (paramBundle.getInt("respkey", 0) == this.mOnRemoteResp.key)
    {
      String str1 = paramBundle.getString("cmd");
      String str2 = paramBundle.getString("callbackid");
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
      if ("redTouch_getRedInfo".equals(str1)) {
        handleRedInfoResponse(str2, paramBundle);
      }
    }
  }
  
  public void reportBusinessRedTouch(String paramString)
  {
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      paramString = localJSONObject1.getString("callback");
      try
      {
        localJSONObject1.remove("callback");
        String str = localJSONObject1.getString("path");
        localJSONObject1.remove("path");
        Bundle localBundle = new Bundle();
        localBundle.putString("path", str);
        localBundle.putString("json", localJSONObject1.toString());
        localBundle.putString("subCmd", "redTouch_reportBusinessRedTouch");
        super.sendRemoteReq(DataFactory.a("redTouch_getRedInfo", paramString, this.mOnRemoteResp.key, localBundle), false, true);
        return;
      }
      catch (Exception localException1) {}
      localException2.printStackTrace();
    }
    catch (Exception localException2)
    {
      paramString = "callback";
    }
    try
    {
      localJSONObject2.put("code", -1);
      localJSONObject2.put("errorMessage", "missing path or callback");
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    callJs(paramString, new String[] { localJSONObject2.toString() });
  }
  
  public void reportRedTouch(String paramString)
  {
    Object localObject2 = "callback";
    ArrayList localArrayList = new ArrayList();
    JSONObject localJSONObject = new JSONObject();
    Object localObject1 = localObject2;
    for (;;)
    {
      int i;
      try
      {
        Object localObject3 = new JSONObject(paramString);
        localObject1 = localObject2;
        paramString = ((JSONObject)localObject3).getString("callback");
        localObject1 = paramString;
        localObject2 = ((JSONObject)localObject3).getString("path");
        localObject1 = paramString;
        int j = ((JSONObject)localObject3).getInt("isWithRedPoint");
        localObject1 = paramString;
        localObject3 = ((JSONObject)localObject3).optJSONArray("missions");
        Object localObject4;
        if (localObject3 != null)
        {
          localObject1 = paramString;
          if (((JSONArray)localObject3).length() > 0)
          {
            i = 0;
            localObject1 = paramString;
            if (i < ((JSONArray)localObject3).length())
            {
              localObject1 = paramString;
              localObject4 = ((JSONArray)localObject3).getString(i);
              localObject1 = paramString;
              if (TextUtils.isEmpty((CharSequence)localObject4)) {
                break label488;
              }
              localObject1 = paramString;
              localArrayList.add(localObject4);
              break label488;
            }
          }
        }
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
        }
        catch (Exception localException)
        {
          localObject1 = paramString;
          localObject3 = TAG;
          localObject1 = paramString;
          localObject4 = new StringBuilder();
          localObject1 = paramString;
          ((StringBuilder)localObject4).append("reportRedTouch: Exception e = ");
          localObject1 = paramString;
          ((StringBuilder)localObject4).append(localException.getMessage());
          localObject1 = paramString;
          QLog.e((String)localObject3, 1, ((StringBuilder)localObject4).toString());
          localObject1 = paramString;
          localException.printStackTrace();
        }
        localObject1 = paramString;
        if (QLog.isColorLevel())
        {
          localObject1 = paramString;
          String str = TAG;
          localObject1 = paramString;
          localObject3 = new StringBuilder();
          localObject1 = paramString;
          ((StringBuilder)localObject3).append("reportRedTouch:");
          localObject1 = paramString;
          ((StringBuilder)localObject3).append(((JSONObject)localObject2).toString());
          localObject1 = paramString;
          QLog.i(str, 2, ((StringBuilder)localObject3).toString());
        }
        localObject1 = paramString;
        callJs(paramString, new String[] { ((JSONObject)localObject2).toString() });
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        try
        {
          localJSONObject.put("code", -1);
          localJSONObject.put("errorMessage", "missing path or callback or isWithRedPoint");
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
        callJs((String)localObject1, new String[] { localJSONObject.toString() });
        return;
      }
      label488:
      i += 1;
    }
  }
  
  public void setAppInfo(String paramString)
  {
    Object localObject = parseSetAppInfoParam(paramString);
    int i = ((Integer)((HashMap)localObject).get("code")).intValue();
    paramString = (String)((HashMap)localObject).get("callback");
    if (i == 0)
    {
      localObject = (Bundle)((HashMap)localObject).get("req");
      super.sendRemoteReq(DataFactory.a("redTouch_setAppInfo", paramString, this.mOnRemoteResp.key, (Bundle)localObject), false, true);
      return;
    }
    callJs(paramString, new String[] { (String)((HashMap)localObject).get("errorJson") });
  }
  
  public void startActivityForResult(Intent paramIntent, byte paramByte)
  {
    super.startActivityForResult(paramIntent, paramByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchWebviewHandler
 * JD-Core Version:    0.7.0.1
 */