package com.tencent.mobileqq.redtouch;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.Client.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
  
  /* Error */
  private static BusinessInfoCheckUpdate.AppInfo getAppInfoByPath(AppInterface arg0, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +22 -> 30
    //   11: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +12 -> 26
    //   17: getstatic 72	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   20: iconst_2
    //   21: ldc 183
    //   23: invokestatic 187	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: aconst_null
    //   27: astore_0
    //   28: aload_0
    //   29: areturn
    //   30: new 189	java/io/File
    //   33: dup
    //   34: aload_0
    //   35: invokevirtual 195	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   38: invokevirtual 201	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   41: new 203	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   48: ldc 206
    //   50: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_0
    //   54: invokevirtual 213	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   57: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokespecial 219	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   66: astore_2
    //   67: aload_2
    //   68: invokevirtual 222	java/io/File:exists	()Z
    //   71: ifne +8 -> 79
    //   74: aload_2
    //   75: invokevirtual 225	java/io/File:createNewFile	()Z
    //   78: pop
    //   79: getstatic 79	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:lock	Ljava/lang/Object;
    //   82: astore_0
    //   83: aload_0
    //   84: monitorenter
    //   85: aload_2
    //   86: invokestatic 231	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;)[B
    //   89: astore_2
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_2
    //   93: ifnonnull +47 -> 140
    //   96: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +12 -> 111
    //   102: getstatic 72	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   105: iconst_2
    //   106: ldc 233
    //   108: invokestatic 187	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aconst_null
    //   112: areturn
    //   113: astore_0
    //   114: aload_0
    //   115: invokevirtual 236	java/io/IOException:printStackTrace	()V
    //   118: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   121: ifeq +12 -> 133
    //   124: getstatic 72	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   127: iconst_2
    //   128: ldc 238
    //   130: invokestatic 187	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   133: aconst_null
    //   134: areturn
    //   135: astore_1
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    //   140: new 240	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$TimeRspBody
    //   143: dup
    //   144: invokespecial 241	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$TimeRspBody:<init>	()V
    //   147: astore_0
    //   148: aload_0
    //   149: aload_2
    //   150: invokevirtual 245	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$TimeRspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   153: pop
    //   154: aload_0
    //   155: ifnull +13 -> 168
    //   158: aload_0
    //   159: getfield 249	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$TimeRspBody:rptMsgAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   162: invokevirtual 254	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   165: ifne +44 -> 209
    //   168: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq +13 -> 184
    //   174: getstatic 72	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   177: iconst_2
    //   178: ldc_w 256
    //   181: invokestatic 187	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aconst_null
    //   185: areturn
    //   186: astore_0
    //   187: aload_0
    //   188: invokevirtual 257	java/lang/Exception:printStackTrace	()V
    //   191: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +13 -> 207
    //   197: getstatic 72	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   200: iconst_2
    //   201: ldc_w 259
    //   204: invokestatic 187	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: aconst_null
    //   208: areturn
    //   209: aload_0
    //   210: getfield 249	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$TimeRspBody:rptMsgAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   213: invokevirtual 262	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   216: invokeinterface 266 1 0
    //   221: astore_0
    //   222: aload_0
    //   223: invokeinterface 271 1 0
    //   228: ifeq +86 -> 314
    //   231: aload_0
    //   232: invokeinterface 275 1 0
    //   237: checkcast 277	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo
    //   240: astore_2
    //   241: aload_2
    //   242: getfield 279	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   245: invokevirtual 129	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   248: aload_1
    //   249: invokevirtual 284	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   252: ifeq -30 -> 222
    //   255: aload_2
    //   256: astore_0
    //   257: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   260: ifeq -232 -> 28
    //   263: getstatic 72	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   266: iconst_2
    //   267: new 203	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   274: ldc_w 286
    //   277: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload_2
    //   281: getfield 279	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   284: invokevirtual 129	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   287: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: ldc_w 288
    //   293: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload_2
    //   297: getfield 292	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:iNewFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   300: invokevirtual 295	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   303: invokevirtual 298	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   306: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 187	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   312: aload_2
    //   313: areturn
    //   314: aconst_null
    //   315: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	1	paramString	String
    //   66	247	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   74	79	113	java/io/IOException
    //   85	92	135	finally
    //   136	138	135	finally
    //   148	154	186	java/lang/Exception
  }
  
  /* Error */
  private static List<BusinessInfoCheckUpdate.AppInfo> getAppInfoListByPath(AppInterface arg0, List<String> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +16 -> 17
    //   4: aload_1
    //   5: ifnull +12 -> 17
    //   8: aload_1
    //   9: invokeinterface 302 1 0
    //   14: ifeq +21 -> 35
    //   17: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +13 -> 33
    //   23: getstatic 72	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   26: iconst_2
    //   27: ldc_w 304
    //   30: invokestatic 187	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aconst_null
    //   34: areturn
    //   35: new 189	java/io/File
    //   38: dup
    //   39: aload_0
    //   40: invokevirtual 195	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   43: invokevirtual 201	mqq/app/MobileQQ:getFilesDir	()Ljava/io/File;
    //   46: new 203	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   53: ldc 206
    //   55: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: invokevirtual 213	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   62: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokespecial 219	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   71: astore_2
    //   72: aload_2
    //   73: invokevirtual 222	java/io/File:exists	()Z
    //   76: ifne +8 -> 84
    //   79: aload_2
    //   80: invokevirtual 225	java/io/File:createNewFile	()Z
    //   83: pop
    //   84: getstatic 79	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:lock	Ljava/lang/Object;
    //   87: astore_0
    //   88: aload_0
    //   89: monitorenter
    //   90: aload_2
    //   91: invokestatic 231	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;)[B
    //   94: astore_2
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_2
    //   98: ifnonnull +49 -> 147
    //   101: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   104: ifeq -71 -> 33
    //   107: getstatic 72	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   110: iconst_2
    //   111: ldc_w 306
    //   114: invokestatic 187	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: aconst_null
    //   118: areturn
    //   119: astore_0
    //   120: aload_0
    //   121: invokevirtual 236	java/io/IOException:printStackTrace	()V
    //   124: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq -94 -> 33
    //   130: getstatic 72	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   133: iconst_2
    //   134: ldc_w 308
    //   137: invokestatic 187	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: aconst_null
    //   141: areturn
    //   142: astore_1
    //   143: aload_0
    //   144: monitorexit
    //   145: aload_1
    //   146: athrow
    //   147: new 240	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$TimeRspBody
    //   150: dup
    //   151: invokespecial 241	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$TimeRspBody:<init>	()V
    //   154: astore_0
    //   155: aload_0
    //   156: aload_2
    //   157: invokevirtual 245	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$TimeRspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   160: pop
    //   161: aload_0
    //   162: ifnull +13 -> 175
    //   165: aload_0
    //   166: getfield 249	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$TimeRspBody:rptMsgAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   169: invokevirtual 254	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   172: ifne +44 -> 216
    //   175: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   178: ifeq -145 -> 33
    //   181: getstatic 72	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   184: iconst_2
    //   185: ldc_w 310
    //   188: invokestatic 187	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: aconst_null
    //   192: areturn
    //   193: astore_0
    //   194: aload_0
    //   195: invokevirtual 257	java/lang/Exception:printStackTrace	()V
    //   198: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq -168 -> 33
    //   204: getstatic 72	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   207: iconst_2
    //   208: ldc_w 312
    //   211: invokestatic 187	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: aconst_null
    //   215: areturn
    //   216: aload_0
    //   217: getfield 249	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$TimeRspBody:rptMsgAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   220: invokevirtual 262	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   223: astore_0
    //   224: new 143	java/util/ArrayList
    //   227: dup
    //   228: invokespecial 144	java/util/ArrayList:<init>	()V
    //   231: astore_2
    //   232: aload_1
    //   233: invokeinterface 266 1 0
    //   238: astore_1
    //   239: aload_1
    //   240: invokeinterface 271 1 0
    //   245: ifeq +127 -> 372
    //   248: aload_1
    //   249: invokeinterface 275 1 0
    //   254: checkcast 281	java/lang/String
    //   257: astore_3
    //   258: aload_0
    //   259: invokeinterface 266 1 0
    //   264: astore 4
    //   266: aload 4
    //   268: invokeinterface 271 1 0
    //   273: ifeq -34 -> 239
    //   276: aload 4
    //   278: invokeinterface 275 1 0
    //   283: checkcast 277	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo
    //   286: astore 5
    //   288: aload 5
    //   290: getfield 279	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   293: invokevirtual 129	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   296: aload_3
    //   297: invokevirtual 284	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   300: ifeq -34 -> 266
    //   303: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   306: ifeq +54 -> 360
    //   309: getstatic 72	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   312: iconst_2
    //   313: new 203	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   320: ldc_w 314
    //   323: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload 5
    //   328: getfield 279	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   331: invokevirtual 129	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   334: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: ldc_w 288
    //   340: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: aload 5
    //   345: getfield 292	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo:iNewFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   348: invokevirtual 295	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   351: invokevirtual 298	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   354: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 187	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   360: aload_2
    //   361: aload 5
    //   363: invokeinterface 165 2 0
    //   368: pop
    //   369: goto -130 -> 239
    //   372: aload_2
    //   373: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	1	paramList	List<String>
    //   71	302	2	localObject	Object
    //   257	40	3	str	String
    //   264	13	4	localIterator	Iterator
    //   286	76	5	localAppInfo	BusinessInfoCheckUpdate.AppInfo
    // Exception table:
    //   from	to	target	type
    //   79	84	119	java/io/IOException
    //   90	97	142	finally
    //   143	145	142	finally
    //   155	161	193	java/lang/Exception
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
          paramAppInterface = new RedTouchManager(paramAppInterface);
          i = paramInt;
          if (paramAppInterface != null)
          {
            paramAppInterface = paramAppInterface.a();
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
    }
    return i;
  }
  
  private static String getReportBufferString(String paramString)
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
            break label172;
          }
          i = ((JSONObject)localObject).getInt("stat");
          if (i != 1) {
            continue;
          }
          if (!((JSONObject)localObject).has("content")) {
            break label177;
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
      label172:
      int i = -1;
      continue;
      label177:
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
    BusinessInfoCheckUpdate.AppInfo localAppInfo = RedTouchUtils.a((RedAppInfo)paramBundle.getParcelable("redInfo"));
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
      paramBundle = new RedTouchManager(this.mRuntime.a()).a();
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
      super.sendRemoteReq(DataFactory.a("redTouch_getAppInfo_report", paramString, this.mOnRemoteResp.key, paramBundle), false, true);
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
        localJSONObject2.put("extend", localAppInfo.extend.get());
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
    //   0: new 93	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 94	org/json/JSONObject:<init>	()V
    //   7: astore 5
    //   9: aload_2
    //   10: ldc_w 372
    //   13: invokevirtual 376	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   16: checkcast 378	com/tencent/mobileqq/redtouch/RedAppInfo
    //   19: astore 8
    //   21: aload_2
    //   22: ldc 29
    //   24: invokevirtual 370	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore 9
    //   29: aload_2
    //   30: ldc_w 565
    //   33: invokevirtual 370	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore_2
    //   37: new 93	org/json/JSONObject
    //   40: dup
    //   41: aload_2
    //   42: invokespecial 343	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   45: astore 7
    //   47: aload_0
    //   48: getfield 405	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   51: invokevirtual 568	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   54: astore_2
    //   55: new 570	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportReqBody
    //   58: dup
    //   59: invokespecial 571	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportReqBody:<init>	()V
    //   62: astore 6
    //   64: aload 6
    //   66: getfield 575	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportReqBody:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   69: aload_0
    //   70: getfield 405	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   73: invokevirtual 410	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   76: invokevirtual 213	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   79: invokestatic 581	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   82: invokevirtual 587	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   85: aload 6
    //   87: getfield 590	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportReqBody:clientver	Lcom/tencent/mobileqq/pb/PBStringField;
    //   90: ldc_w 592
    //   93: invokevirtual 594	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   96: aload 6
    //   98: getfield 597	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportReqBody:platid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   101: bipush 109
    //   103: invokevirtual 600	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   106: aload_0
    //   107: getfield 405	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   110: invokevirtual 410	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   113: ldc_w 602
    //   116: ldc 151
    //   118: invokevirtual 606	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   121: checkcast 602	com/tencent/mobileqq/tianshu/api/IRedTouchManager
    //   124: astore 10
    //   126: aload 6
    //   128: getfield 609	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportReqBody:appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   131: aload 10
    //   133: aload 9
    //   135: invokeinterface 612 2 0
    //   140: invokevirtual 600	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   143: aload 6
    //   145: getfield 615	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportReqBody:platver	Lcom/tencent/mobileqq/pb/PBStringField;
    //   148: new 203	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   155: getstatic 620	android/os/Build$VERSION:SDK_INT	I
    //   158: invokevirtual 298	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   161: ldc 151
    //   163: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokevirtual 594	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   172: aload 8
    //   174: invokevirtual 622	com/tencent/mobileqq/redtouch/RedAppInfo:a	()Ljava/util/List;
    //   177: ifnull +16 -> 193
    //   180: aload 6
    //   182: getfield 625	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportReqBody:missionid	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   185: aload 8
    //   187: invokevirtual 622	com/tencent/mobileqq/redtouch/RedAppInfo:a	()Ljava/util/List;
    //   190: invokevirtual 628	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   193: new 143	java/util/ArrayList
    //   196: dup
    //   197: invokespecial 144	java/util/ArrayList:<init>	()V
    //   200: astore 8
    //   202: aload 7
    //   204: invokevirtual 326	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   207: astore 9
    //   209: aload 9
    //   211: invokeinterface 271 1 0
    //   216: ifeq +156 -> 372
    //   219: aload 9
    //   221: invokeinterface 275 1 0
    //   226: checkcast 281	java/lang/String
    //   229: astore 10
    //   231: new 630	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportStaticsData
    //   234: dup
    //   235: invokespecial 631	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportStaticsData:<init>	()V
    //   238: astore 11
    //   240: aload 11
    //   242: getfield 633	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportStaticsData:key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   245: aload 10
    //   247: invokevirtual 594	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   250: aload 11
    //   252: getfield 636	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportStaticsData:value	Lcom/tencent/mobileqq/pb/PBStringField;
    //   255: aload 7
    //   257: aload 10
    //   259: invokevirtual 359	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   262: invokevirtual 594	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   265: aload 8
    //   267: aload 11
    //   269: invokeinterface 165 2 0
    //   274: pop
    //   275: getstatic 642	java/lang/System:out	Ljava/io/PrintStream;
    //   278: new 203	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   285: ldc_w 644
    //   288: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload 11
    //   293: getfield 633	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportStaticsData:key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   296: invokevirtual 129	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   299: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: ldc_w 646
    //   305: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload 11
    //   310: getfield 636	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportStaticsData:value	Lcom/tencent/mobileqq/pb/PBStringField;
    //   313: invokevirtual 129	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   316: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokevirtual 651	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   325: goto -116 -> 209
    //   328: astore_2
    //   329: aload 5
    //   331: ldc_w 397
    //   334: iconst_m1
    //   335: invokevirtual 119	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   338: pop
    //   339: aload 5
    //   341: ldc 26
    //   343: ldc_w 653
    //   346: invokevirtual 132	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   349: pop
    //   350: aload_2
    //   351: invokevirtual 327	org/json/JSONException:printStackTrace	()V
    //   354: aload_0
    //   355: aload_1
    //   356: iconst_1
    //   357: anewarray 281	java/lang/String
    //   360: dup
    //   361: iconst_0
    //   362: aload 5
    //   364: invokevirtual 363	org/json/JSONObject:toString	()Ljava/lang/String;
    //   367: aastore
    //   368: invokevirtual 455	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   371: return
    //   372: new 93	org/json/JSONObject
    //   375: dup
    //   376: invokespecial 94	org/json/JSONObject:<init>	()V
    //   379: astore 7
    //   381: aload 7
    //   383: ifnull +13 -> 396
    //   386: aload 7
    //   388: ldc_w 655
    //   391: iconst_5
    //   392: invokevirtual 119	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   395: pop
    //   396: aload 6
    //   398: getfield 656	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportReqBody:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   401: aload 7
    //   403: invokevirtual 363	org/json/JSONObject:toString	()Ljava/lang/String;
    //   406: invokevirtual 594	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   409: aload 6
    //   411: getfield 659	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportReqBody:reportdata	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   414: aload 8
    //   416: invokevirtual 660	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
    //   419: new 662	com/tencent/qphone/base/remote/ToServiceMsg
    //   422: dup
    //   423: ldc_w 664
    //   426: aload_0
    //   427: getfield 405	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   430: invokevirtual 410	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   433: invokevirtual 213	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   436: ldc_w 666
    //   439: invokespecial 669	com/tencent/qphone/base/remote/ToServiceMsg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   442: astore 7
    //   444: aload 7
    //   446: aload 6
    //   448: invokevirtual 673	com/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$ReportReqBody:toByteArray	()[B
    //   451: invokevirtual 677	com/tencent/qphone/base/remote/ToServiceMsg:putWupBuffer	([B)V
    //   454: aload 7
    //   456: getfield 681	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   459: ldc_w 683
    //   462: iconst_1
    //   463: invokevirtual 687	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   466: aload 7
    //   468: invokevirtual 690	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   471: arraylength
    //   472: i2l
    //   473: lstore_3
    //   474: lload_3
    //   475: l2i
    //   476: iconst_4
    //   477: iadd
    //   478: newarray byte
    //   480: astore 6
    //   482: aload 6
    //   484: iconst_0
    //   485: ldc2_w 691
    //   488: lload_3
    //   489: ladd
    //   490: invokestatic 698	com/tencent/mobileqq/utils/httputils/PkgTools:DWord2Byte	([BIJ)V
    //   493: aload 6
    //   495: iconst_4
    //   496: aload 7
    //   498: invokevirtual 690	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   501: lload_3
    //   502: l2i
    //   503: invokestatic 702	com/tencent/mobileqq/utils/httputils/PkgTools:copyData	([BI[BI)V
    //   506: aload 7
    //   508: aload 6
    //   510: invokevirtual 677	com/tencent/qphone/base/remote/ToServiceMsg:putWupBuffer	([B)V
    //   513: new 704	mqq/app/NewIntent
    //   516: dup
    //   517: aload_2
    //   518: invokevirtual 709	android/app/Activity:getApplication	()Landroid/app/Application;
    //   521: ldc_w 711
    //   524: invokespecial 714	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   527: astore_2
    //   528: aload_2
    //   529: ldc_w 662
    //   532: invokevirtual 717	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   535: aload 7
    //   537: invokevirtual 721	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   540: pop
    //   541: aload_0
    //   542: getfield 405	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   545: invokevirtual 410	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   548: aload_2
    //   549: invokevirtual 725	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   552: aload 5
    //   554: ldc_w 397
    //   557: iconst_0
    //   558: invokevirtual 119	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   561: pop
    //   562: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   565: ifeq -211 -> 354
    //   568: getstatic 72	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   571: iconst_2
    //   572: new 203	java/lang/StringBuilder
    //   575: dup
    //   576: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   579: ldc_w 727
    //   582: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: aload 5
    //   587: invokevirtual 363	org/json/JSONObject:toString	()Ljava/lang/String;
    //   590: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   596: invokestatic 187	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   599: goto -245 -> 354
    //   602: astore_2
    //   603: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   606: ifeq -252 -> 354
    //   609: getstatic 72	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   612: iconst_2
    //   613: new 203	java/lang/StringBuilder
    //   616: dup
    //   617: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   620: ldc_w 727
    //   623: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: aload_2
    //   627: invokevirtual 728	java/lang/Exception:toString	()Ljava/lang/String;
    //   630: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   636: invokestatic 187	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   639: goto -285 -> 354
    //   642: astore 6
    //   644: aload 6
    //   646: invokevirtual 327	org/json/JSONException:printStackTrace	()V
    //   649: goto -299 -> 350
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	652	0	this	RedTouchWebviewHandler
    //   0	652	1	paramString	String
    //   0	652	2	paramBundle	Bundle
    //   473	29	3	l	long
    //   7	579	5	localJSONObject	JSONObject
    //   62	447	6	localObject1	Object
    //   642	3	6	localJSONException	JSONException
    //   45	491	7	localObject2	Object
    //   19	396	8	localObject3	Object
    //   27	193	9	localObject4	Object
    //   124	134	10	localObject5	Object
    //   238	71	11	localReportStaticsData	com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.ReportStaticsData
    // Exception table:
    //   from	to	target	type
    //   37	193	328	org/json/JSONException
    //   193	209	328	org/json/JSONException
    //   209	325	328	org/json/JSONException
    //   372	381	328	org/json/JSONException
    //   386	396	328	org/json/JSONException
    //   396	599	328	org/json/JSONException
    //   37	193	602	java/lang/Exception
    //   193	209	602	java/lang/Exception
    //   209	325	602	java/lang/Exception
    //   372	381	602	java/lang/Exception
    //   386	396	602	java/lang/Exception
    //   396	599	602	java/lang/Exception
    //   329	350	642	org/json/JSONException
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
        onReportRed(RedTouchUtils.a(localRedAppInfo), 1002);
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
    super.sendRemoteReq(DataFactory.a("myIndividuationRedInfo", null, 0, localBundle), false, true);
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
      new RedTouchManager(this.mRuntime.a()).c(paramAppInfo, localJSONObject.toString());
      return;
    }
    catch (JSONException paramAppInfo)
    {
      paramAppInfo.printStackTrace();
    }
  }
  
  public static HashMap<String, Object> parseGetAppInfo(AppInterface paramAppInterface, long paramLong, String paramString)
  {
    localObject2 = "";
    localObject1 = "callback";
    localObject8 = "";
    BusinessInfoCheckUpdate.AppInfo localAppInfo = null;
    localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    ArrayList localArrayList = new ArrayList();
    int n = -2;
    int i1 = 0;
    m = 0;
    j = i1;
    localObject3 = localAppInfo;
    localObject4 = localObject8;
    localObject5 = localObject1;
    localObject6 = localObject2;
    i = n;
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        j = i1;
        localObject3 = localAppInfo;
        localObject4 = localObject8;
        localObject5 = localObject1;
        localObject6 = localObject2;
        i = n;
        localObject1 = paramString.getString("callback");
        j = i1;
        localObject3 = localAppInfo;
        localObject4 = localObject8;
        localObject5 = localObject1;
        localObject6 = localObject2;
        i = n;
        localObject2 = paramString.getString("path");
        j = i1;
        localObject3 = localAppInfo;
        localObject4 = localObject8;
        localObject5 = localObject1;
        localObject6 = localObject2;
        i = n;
        if (paramString.has("serial"))
        {
          j = i1;
          localObject3 = localAppInfo;
          localObject4 = localObject8;
          localObject5 = localObject1;
          localObject6 = localObject2;
          i = n;
          paramString = paramString.getString("serial");
          j = i1;
          localObject3 = localAppInfo;
          localObject4 = paramString;
          localObject5 = localObject1;
          localObject6 = localObject2;
          i = n;
          localAppInfo = getAppInfoByPath(paramAppInterface, (String)localObject2);
          if (localAppInfo != null) {
            continue;
          }
          j = i1;
          localObject3 = localAppInfo;
          localObject4 = paramString;
          localObject5 = localObject1;
          localObject6 = localObject2;
          i = n;
          localJSONObject1.put("code", -3);
          j = i1;
          localObject3 = localAppInfo;
          localObject4 = paramString;
          localObject5 = localObject1;
          localObject6 = localObject2;
          i = n;
          localJSONObject1.put("errorMessage", "not red info");
          j = i1;
          localObject3 = localAppInfo;
          localObject4 = paramString;
          localObject5 = localObject1;
          localObject6 = localObject2;
          i = n;
          localJSONObject1.put("jsStartTime", paramLong);
          j = i1;
          localObject3 = localAppInfo;
          localObject4 = paramString;
          localObject5 = localObject1;
          localObject6 = localObject2;
          i = n;
          localJSONObject1.put("jsEndTime", System.currentTimeMillis());
          j = 0;
          i = -3;
          k = j;
          m = i;
          localObject8 = localAppInfo;
          localObject5 = paramString;
          localObject4 = localObject1;
          localObject6 = localObject2;
        }
      }
      catch (Exception localException2)
      {
        int i2;
        JSONArray localJSONArray;
        localObject2 = localObject6;
        localObject1 = localObject5;
        paramString = (String)localObject4;
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "getAppInfo error:" + localException2);
        }
        try
        {
          localJSONObject1.put("code", -1);
          localJSONObject1.put("errorMessage", "jsonexception");
          localJSONObject1.put("jsStart", paramLong);
          localJSONObject1.put("jsEnd", System.currentTimeMillis());
          m = -1;
          k = j;
          localObject8 = localObject3;
          localObject5 = paramString;
          localObject4 = localObject1;
          localObject6 = localObject2;
        }
        catch (JSONException localJSONException)
        {
          k = j;
          m = i;
          localObject8 = localObject3;
          localObject5 = paramString;
          localObject4 = localObject1;
          localObject6 = localObject2;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(TAG, 2, "getAppInfo error1:" + localJSONException);
        int k = j;
        m = i;
        localObject8 = localObject3;
        localObject5 = paramString;
        localObject4 = localObject1;
        localObject6 = localObject2;
        continue;
      }
      try
      {
        if (QLog.isColorLevel())
        {
          QLog.i(TAG, 2, "getAppInfo:" + localJSONObject1.toString());
          localObject6 = localObject2;
          localObject4 = localObject1;
          localObject5 = paramString;
          localObject8 = localAppInfo;
          m = i;
          k = j;
        }
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "getAppInfo:" + localJSONObject1.toString());
        }
        i = k;
        if (paramAppInterface != null)
        {
          paramAppInterface = new RedTouchManager(paramAppInterface);
          i = k;
          if (paramAppInterface != null)
          {
            paramAppInterface = paramAppInterface.a();
            i = k;
            if (!TextUtils.isEmpty(localObject6))
            {
              i = k;
              if (localObject6.equals(paramAppInterface)) {
                i = 1;
              }
            }
          }
        }
        if (localObject8 == null) {
          break label1813;
        }
        paramAppInterface = getReportBufferString(((BusinessInfoCheckUpdate.AppInfo)localObject8).buffer.get());
      }
      catch (Exception localException1)
      {
        localObject3 = localJSONException;
        Object localObject7 = localException1;
        continue;
        paramAppInterface = "";
        continue;
      }
      paramString = new Bundle();
      paramString.putString("ret", String.valueOf(m));
      paramString.putString("buffer", paramAppInterface);
      paramString.putString("red", String.valueOf(i));
      paramString.putStringArrayList("missions", localArrayList);
      paramString.putString("path", localObject6);
      paramString.putString("serial", (String)localObject5);
      paramString.putString("callback", (String)localObject4);
      paramAppInterface = new HashMap();
      paramAppInterface.put("callbackId", localObject4);
      paramAppInterface.put("req", paramString);
      paramAppInterface.put("jsonResult", localJSONObject1.toString());
      return paramAppInterface;
      paramString = "";
      continue;
      k = n;
      j = i1;
      localObject3 = localAppInfo;
      localObject4 = paramString;
      localObject5 = localObject1;
      localObject6 = localObject2;
      i = n;
      if (localAppInfo.red_display_info.get() != null)
      {
        j = i1;
        localObject3 = localAppInfo;
        localObject4 = paramString;
        localObject5 = localObject1;
        localObject6 = localObject2;
        i = n;
        localObject8 = localAppInfo.red_display_info.red_type_info.get();
        i2 = 0;
        n = 0;
        j = i1;
        localObject3 = localAppInfo;
        localObject4 = paramString;
        localObject5 = localObject1;
        localObject6 = localObject2;
        i = i2;
        localJSONObject1.put("code", 0);
        j = i1;
        localObject3 = localAppInfo;
        localObject4 = paramString;
        localObject5 = localObject1;
        localObject6 = localObject2;
        i = i2;
        localJSONObject2.put("appID", localAppInfo.uiAppId.get());
        j = i1;
        localObject3 = localAppInfo;
        localObject4 = paramString;
        localObject5 = localObject1;
        localObject6 = localObject2;
        i = i2;
        localJSONObject2.put("iNewFlag", localAppInfo.iNewFlag.get());
        j = i1;
        localObject3 = localAppInfo;
        localObject4 = paramString;
        localObject5 = localObject1;
        localObject6 = localObject2;
        i = i2;
        m = localAppInfo.iNewFlag.get();
        j = m;
        localObject3 = localAppInfo;
        localObject4 = paramString;
        localObject5 = localObject1;
        localObject6 = localObject2;
        i = i2;
        localJSONArray = new JSONArray();
        k = 0;
        j = m;
        localObject3 = localAppInfo;
        localObject4 = paramString;
        localObject5 = localObject1;
        localObject6 = localObject2;
        i = i2;
        if (k < localAppInfo.missions.size())
        {
          j = m;
          localObject3 = localAppInfo;
          localObject4 = paramString;
          localObject5 = localObject1;
          localObject6 = localObject2;
          i = i2;
          localJSONArray.put(localAppInfo.missions.get(k));
          j = m;
          localObject3 = localAppInfo;
          localObject4 = paramString;
          localObject5 = localObject1;
          localObject6 = localObject2;
          i = i2;
          localArrayList.add(localAppInfo.missions.get(k));
          k += 1;
          continue;
        }
        j = m;
        localObject3 = localAppInfo;
        localObject4 = paramString;
        localObject5 = localObject1;
        localObject6 = localObject2;
        i = i2;
        localJSONObject2.put("redInfo", buidRedJson((List)localObject8));
        j = m;
        localObject3 = localAppInfo;
        localObject4 = paramString;
        localObject5 = localObject1;
        localObject6 = localObject2;
        i = i2;
        localJSONObject2.put("missions", localJSONArray);
        j = m;
        localObject3 = localAppInfo;
        localObject4 = paramString;
        localObject5 = localObject1;
        localObject6 = localObject2;
        i = i2;
        localJSONObject2.put("type", localAppInfo.type.get());
        j = m;
        localObject3 = localAppInfo;
        localObject4 = paramString;
        localObject5 = localObject1;
        localObject6 = localObject2;
        i = i2;
        localJSONObject2.put("extend", localAppInfo.extend.get());
        j = m;
        localObject3 = localAppInfo;
        localObject4 = paramString;
        localObject5 = localObject1;
        localObject6 = localObject2;
        i = i2;
        localJSONObject2.put("buffer", localAppInfo.buffer.get());
        j = m;
        localObject3 = localAppInfo;
        localObject4 = paramString;
        localObject5 = localObject1;
        localObject6 = localObject2;
        i = i2;
        localJSONObject2.put("path", localAppInfo.path.get());
        j = m;
        localObject3 = localAppInfo;
        localObject4 = paramString;
        localObject5 = localObject1;
        localObject6 = localObject2;
        i = i2;
        localJSONObject2.put("appset", localAppInfo.appset.get());
        j = m;
        localObject3 = localAppInfo;
        localObject4 = paramString;
        localObject5 = localObject1;
        localObject6 = localObject2;
        i = i2;
        localJSONObject2.put("modify_ts", localAppInfo.modify_ts.get());
        j = m;
        localObject3 = localAppInfo;
        localObject4 = paramString;
        localObject5 = localObject1;
        localObject6 = localObject2;
        i = i2;
        localJSONObject2.put("num", localAppInfo.num.get());
        j = m;
        localObject3 = localAppInfo;
        localObject4 = paramString;
        localObject5 = localObject1;
        localObject6 = localObject2;
        i = i2;
        localJSONObject2.put("push_red_ts", localAppInfo.push_red_ts.get());
        j = m;
        localObject3 = localAppInfo;
        localObject4 = paramString;
        localObject5 = localObject1;
        localObject6 = localObject2;
        i = i2;
        localJSONObject1.put("data", localJSONObject2);
        j = m;
        localObject3 = localAppInfo;
        localObject4 = paramString;
        localObject5 = localObject1;
        localObject6 = localObject2;
        i = i2;
        localJSONObject1.put("jsStart", paramLong);
        j = m;
        localObject3 = localAppInfo;
        localObject4 = paramString;
        localObject5 = localObject1;
        localObject6 = localObject2;
        i = i2;
        localJSONObject1.put("jsEnd", System.currentTimeMillis());
        k = n;
      }
      j = m;
      i = k;
    }
  }
  
  public static HashMap<String, Object> parseGetAppInfoList(AppInterface paramAppInterface, long paramLong, String paramString)
  {
    Object localObject6 = "callback";
    Object localObject7 = "";
    List localList1 = null;
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray1 = new JSONArray();
    ArrayList localArrayList1 = new ArrayList();
    k = 0;
    int m = 0;
    i = 0;
    j = m;
    Object localObject3 = localList1;
    Object localObject1 = localObject7;
    Object localObject2 = localObject6;
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        j = m;
        localObject3 = localList1;
        localObject1 = localObject7;
        localObject2 = localObject6;
        localObject6 = paramString.getString("callback");
        j = m;
        localObject3 = localList1;
        localObject1 = localObject7;
        localObject2 = localObject6;
        localObject8 = paramString.getJSONArray("pathList");
        j = m;
        localObject3 = localList1;
        localObject1 = localObject7;
        localObject2 = localObject6;
        if (!paramString.has("serial")) {
          continue;
        }
        j = m;
        localObject3 = localList1;
        localObject1 = localObject7;
        localObject2 = localObject6;
        paramString = paramString.getString("serial");
        j = m;
        localObject3 = localList1;
        localObject1 = paramString;
        localObject2 = localObject6;
        localList1 = getAppInfoListByPath(paramAppInterface, buildPaths(null, (JSONArray)localObject8));
        if (localList1 != null)
        {
          j = m;
          localObject3 = localList1;
          localObject1 = paramString;
          localObject2 = localObject6;
          if (!localList1.isEmpty()) {
            continue;
          }
        }
        j = m;
        localObject3 = localList1;
        localObject1 = paramString;
        localObject2 = localObject6;
        localJSONObject1.put("code", -3);
        j = m;
        localObject3 = localList1;
        localObject1 = paramString;
        localObject2 = localObject6;
        localJSONObject1.put("errorMessage", "not find red info");
        j = m;
        localObject3 = localList1;
        localObject1 = paramString;
        localObject2 = localObject6;
        localJSONObject1.put("jsStartTime", paramLong);
        j = m;
        localObject3 = localList1;
        localObject1 = paramString;
        localObject2 = localObject6;
        localJSONObject1.put("jsEndTime", System.currentTimeMillis());
        j = -3;
        localObject1 = localObject6;
        localObject2 = localList1;
        if (QLog.isColorLevel()) {
          QLog.i(TAG, 2, "getAppInfoList:" + localJSONObject1.toString());
        }
        i = getReddot(paramAppInterface, (List)localObject2, i);
        if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
          continue;
        }
        localObject3 = (BusinessInfoCheckUpdate.AppInfo)((List)localObject2).get(0);
        if (!localArrayList1.isEmpty()) {
          continue;
        }
        paramAppInterface = new ArrayList();
        if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
          continue;
        }
        localObject2 = ((BusinessInfoCheckUpdate.AppInfo)((List)localObject2).get(0)).path.get();
        if (localObject3 == null) {
          continue;
        }
        localObject3 = getReportBufferString(((BusinessInfoCheckUpdate.AppInfo)localObject3).buffer.get());
      }
      catch (Exception localException2)
      {
        Object localObject8;
        JSONObject localJSONObject2;
        ArrayList localArrayList2;
        List localList2;
        JSONArray localJSONArray2;
        k = -2;
        i = j;
        paramString = (String)localObject5;
        Object localObject5 = localException2;
        continue;
        localObject5 = "";
        continue;
      }
      localObject6 = new Bundle();
      ((Bundle)localObject6).putString("ret", String.valueOf(j));
      ((Bundle)localObject6).putString("buffer", (String)localObject3);
      ((Bundle)localObject6).putString("red", String.valueOf(i));
      ((Bundle)localObject6).putStringArrayList("missions", paramAppInterface);
      ((Bundle)localObject6).putString("path", (String)localObject2);
      ((Bundle)localObject6).putString("serial", paramString);
      ((Bundle)localObject6).putString("callback", (String)localObject1);
      paramAppInterface = new HashMap();
      paramAppInterface.put("callbackId", localObject1);
      paramAppInterface.put("req", localObject6);
      paramAppInterface.put("jsonResult", localJSONObject1.toString());
      return paramAppInterface;
      paramString = "";
      continue;
      j = m;
      localObject3 = localList1;
      localObject1 = paramString;
      localObject2 = localObject6;
      localObject7 = localList1.iterator();
      i = k;
      j = i;
      localObject3 = localList1;
      localObject1 = paramString;
      localObject2 = localObject6;
      if (((Iterator)localObject7).hasNext())
      {
        j = i;
        localObject3 = localList1;
        localObject1 = paramString;
        localObject2 = localObject6;
        localObject8 = (BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject7).next();
        k = i;
        j = i;
        localObject3 = localList1;
        localObject1 = paramString;
        localObject2 = localObject6;
        if (((BusinessInfoCheckUpdate.AppInfo)localObject8).red_display_info.get() != null)
        {
          j = i;
          localObject3 = localList1;
          localObject1 = paramString;
          localObject2 = localObject6;
          localJSONObject2 = new JSONObject();
          j = i;
          localObject3 = localList1;
          localObject1 = paramString;
          localObject2 = localObject6;
          localArrayList2 = new ArrayList();
          j = i;
          localObject3 = localList1;
          localObject1 = paramString;
          localObject2 = localObject6;
          localList2 = ((BusinessInfoCheckUpdate.AppInfo)localObject8).red_display_info.red_type_info.get();
          j = i;
          localObject3 = localList1;
          localObject1 = paramString;
          localObject2 = localObject6;
          localJSONObject2.put("appID", ((BusinessInfoCheckUpdate.AppInfo)localObject8).uiAppId.get());
          j = i;
          localObject3 = localList1;
          localObject1 = paramString;
          localObject2 = localObject6;
          localJSONObject2.put("iNewFlag", ((BusinessInfoCheckUpdate.AppInfo)localObject8).iNewFlag.get());
          j = i;
          localObject3 = localList1;
          localObject1 = paramString;
          localObject2 = localObject6;
          k = ((BusinessInfoCheckUpdate.AppInfo)localObject8).iNewFlag.get();
          j = k;
          localObject3 = localList1;
          localObject1 = paramString;
          localObject2 = localObject6;
          localJSONArray2 = new JSONArray();
          i = 0;
          j = k;
          localObject3 = localList1;
          localObject1 = paramString;
          localObject2 = localObject6;
          if (i < ((BusinessInfoCheckUpdate.AppInfo)localObject8).missions.size())
          {
            j = k;
            localObject3 = localList1;
            localObject1 = paramString;
            localObject2 = localObject6;
            localJSONArray2.put(((BusinessInfoCheckUpdate.AppInfo)localObject8).missions.get(i));
            j = k;
            localObject3 = localList1;
            localObject1 = paramString;
            localObject2 = localObject6;
            localArrayList2.add(((BusinessInfoCheckUpdate.AppInfo)localObject8).missions.get(i));
            i += 1;
            continue;
          }
          j = k;
          localObject3 = localList1;
          localObject1 = paramString;
          localObject2 = localObject6;
          localArrayList1.add(localArrayList2);
          j = k;
          localObject3 = localList1;
          localObject1 = paramString;
          localObject2 = localObject6;
          localJSONObject2.put("redInfo", buildRedJson(localList2));
          j = k;
          localObject3 = localList1;
          localObject1 = paramString;
          localObject2 = localObject6;
          localJSONObject2.put("extend", ((BusinessInfoCheckUpdate.AppInfo)localObject8).extend.get());
          j = k;
          localObject3 = localList1;
          localObject1 = paramString;
          localObject2 = localObject6;
          localJSONObject2.put("missions", localJSONArray2);
          j = k;
          localObject3 = localList1;
          localObject1 = paramString;
          localObject2 = localObject6;
          localJSONObject2.put("type", ((BusinessInfoCheckUpdate.AppInfo)localObject8).type.get());
          j = k;
          localObject3 = localList1;
          localObject1 = paramString;
          localObject2 = localObject6;
          localJSONObject2.put("buffer", ((BusinessInfoCheckUpdate.AppInfo)localObject8).buffer.get());
          j = k;
          localObject3 = localList1;
          localObject1 = paramString;
          localObject2 = localObject6;
          localJSONObject2.put("path", ((BusinessInfoCheckUpdate.AppInfo)localObject8).path.get());
          j = k;
          localObject3 = localList1;
          localObject1 = paramString;
          localObject2 = localObject6;
          localJSONObject2.put("appset", ((BusinessInfoCheckUpdate.AppInfo)localObject8).appset.get());
          j = k;
          localObject3 = localList1;
          localObject1 = paramString;
          localObject2 = localObject6;
          localJSONObject2.put("modify_ts", ((BusinessInfoCheckUpdate.AppInfo)localObject8).modify_ts.get());
          j = k;
          localObject3 = localList1;
          localObject1 = paramString;
          localObject2 = localObject6;
          localJSONObject2.put("num", ((BusinessInfoCheckUpdate.AppInfo)localObject8).num.get());
          j = k;
          localObject3 = localList1;
          localObject1 = paramString;
          localObject2 = localObject6;
          localJSONObject2.put("push_red_ts", ((BusinessInfoCheckUpdate.AppInfo)localObject8).push_red_ts.get());
          j = k;
          localObject3 = localList1;
          localObject1 = paramString;
          localObject2 = localObject6;
          localJSONArray1.put(localJSONObject2);
        }
        i = k;
      }
      else
      {
        k = 0;
        j = 0;
        try
        {
          localJSONObject1.put("code", 0);
          localJSONObject1.put("data", localJSONArray1);
          localJSONObject1.put("jsStart", paramLong);
          localJSONObject1.put("jsEnd", System.currentTimeMillis());
        }
        catch (Exception localException1)
        {
          localObject2 = localObject6;
          localObject1 = paramString;
          paramString = localList1;
        }
        localException1.printStackTrace();
        try
        {
          localJSONObject1.put("code", -1);
          localJSONObject1.put("errorMessage", "jsonexception");
          localJSONObject1.put("jsStart", paramLong);
          localJSONObject1.put("jsEnd", System.currentTimeMillis());
          Object localObject4 = localObject2;
          j = -1;
          localObject2 = paramString;
          paramString = (String)localObject1;
          localObject1 = localObject4;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          localObject5 = localObject2;
          j = k;
          localObject2 = paramString;
          paramString = (String)localObject1;
          localObject1 = localObject5;
        }
        continue;
        localObject5 = null;
        continue;
        paramAppInterface = (ArrayList)localArrayList1.get(0);
        continue;
        localObject2 = "";
      }
    }
  }
  
  public static HashMap<String, Object> parseSetAppInfoParam(String paramString)
  {
    int i = 0;
    HashMap localHashMap = new HashMap();
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
      ((BusinessInfoCheckUpdate.AppInfo)localObject2).extend.set(((JSONObject)localObject3).getString("extend"));
      localObject1 = paramString;
      localObject3 = new Bundle();
      localObject1 = paramString;
      ((Bundle)localObject3).putParcelable("red", RedTouchUtils.a((BusinessInfoCheckUpdate.AppInfo)localObject2));
      localObject1 = paramString;
      localHashMap.put("callback", paramString);
      localObject1 = paramString;
      localHashMap.put("req", localObject3);
      localObject1 = paramString;
      localHashMap.put("code", Integer.valueOf(0));
      return localHashMap;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    try
    {
      localJSONObject.put("code", -1);
      localJSONObject.put("errorMessage", "missing appInfo or callback or appInfo json format error");
      localHashMap.put("callback", localObject1);
      localHashMap.put("code", Integer.valueOf(-1));
      localHashMap.put("errorJson", localJSONObject.toString());
      return localHashMap;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
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
      ThreadManager.post(new RedTouchWebviewHandler.1(this, l, paramString), 8, null, true);
    }
  }
  
  public void getAppInfoList(String paramString)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "getappinfolist js startime : " + l);
    }
    ThreadManager.post(new RedTouchWebviewHandler.2(this, l, paramString), 8, null, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchWebviewHandler
 * JD-Core Version:    0.7.0.1
 */