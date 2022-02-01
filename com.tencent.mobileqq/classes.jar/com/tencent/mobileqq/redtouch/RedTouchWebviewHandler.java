package com.tencent.mobileqq.redtouch;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import ascz;
import asdd;
import bbbq;
import bbbt;
import bifw;
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
    //   86: invokestatic 231	com/tencent/mobileqq/utils/FileUtils:fileToBytes	(Ljava/io/File;)[B
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
    //   140: new 240	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$TimeRspBody
    //   143: dup
    //   144: invokespecial 241	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$TimeRspBody:<init>	()V
    //   147: astore_0
    //   148: aload_0
    //   149: aload_2
    //   150: invokevirtual 245	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$TimeRspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   153: pop
    //   154: aload_0
    //   155: ifnull +13 -> 168
    //   158: aload_0
    //   159: getfield 249	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$TimeRspBody:rptMsgAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
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
    //   210: getfield 249	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$TimeRspBody:rptMsgAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   213: invokevirtual 262	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   216: invokeinterface 266 1 0
    //   221: astore_0
    //   222: aload_0
    //   223: invokeinterface 271 1 0
    //   228: ifeq +86 -> 314
    //   231: aload_0
    //   232: invokeinterface 275 1 0
    //   237: checkcast 277	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo
    //   240: astore_2
    //   241: aload_2
    //   242: getfield 279	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:path	Lcom/tencent/mobileqq/pb/PBStringField;
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
    //   281: getfield 279	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   284: invokevirtual 129	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   287: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: ldc_w 288
    //   293: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload_2
    //   297: getfield 292	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:iNewFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
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
    //   91: invokestatic 231	com/tencent/mobileqq/utils/FileUtils:fileToBytes	(Ljava/io/File;)[B
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
    //   147: new 240	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$TimeRspBody
    //   150: dup
    //   151: invokespecial 241	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$TimeRspBody:<init>	()V
    //   154: astore_0
    //   155: aload_0
    //   156: aload_2
    //   157: invokevirtual 245	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$TimeRspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   160: pop
    //   161: aload_0
    //   162: ifnull +13 -> 175
    //   165: aload_0
    //   166: getfield 249	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$TimeRspBody:rptMsgAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
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
    //   217: getfield 249	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$TimeRspBody:rptMsgAppInfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
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
    //   283: checkcast 277	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo
    //   286: astore 5
    //   288: aload 5
    //   290: getfield 279	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:path	Lcom/tencent/mobileqq/pb/PBStringField;
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
    //   328: getfield 279	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:path	Lcom/tencent/mobileqq/pb/PBStringField;
    //   331: invokevirtual 129	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   334: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: ldc_w 288
    //   340: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: aload 5
    //   345: getfield 292	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:iNewFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
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
          paramAppInterface = new bbbq(paramAppInterface);
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
    BusinessInfoCheckUpdate.AppInfo localAppInfo = bbbt.a((RedAppInfo)paramBundle.getParcelable("redInfo"));
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
      paramBundle = new bbbq(this.mRuntime.a()).a();
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
      super.sendRemoteReq(asdd.a("redTouch_getAppInfo_report", paramString, this.mOnRemoteResp.key, paramBundle), false, true);
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
    //   10: ldc_w 373
    //   13: invokevirtual 377	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   16: checkcast 379	com/tencent/mobileqq/redtouch/RedAppInfo
    //   19: astore 8
    //   21: aload_2
    //   22: ldc 29
    //   24: invokevirtual 371	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore 9
    //   29: aload_2
    //   30: ldc_w 566
    //   33: invokevirtual 371	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore_2
    //   37: new 93	org/json/JSONObject
    //   40: dup
    //   41: aload_2
    //   42: invokespecial 344	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   45: astore 7
    //   47: aload_0
    //   48: getfield 406	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mRuntime	Lbifw;
    //   51: invokevirtual 569	bifw:a	()Landroid/app/Activity;
    //   54: astore_2
    //   55: new 571	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody
    //   58: dup
    //   59: invokespecial 572	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:<init>	()V
    //   62: astore 6
    //   64: aload 6
    //   66: getfield 576	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   69: aload_0
    //   70: getfield 406	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mRuntime	Lbifw;
    //   73: invokevirtual 411	bifw:a	()Lcom/tencent/common/app/AppInterface;
    //   76: invokevirtual 213	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   79: invokestatic 582	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   82: invokevirtual 588	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   85: aload 6
    //   87: getfield 591	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:clientver	Lcom/tencent/mobileqq/pb/PBStringField;
    //   90: ldc_w 593
    //   93: invokevirtual 595	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   96: aload 6
    //   98: getfield 598	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:platid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   101: bipush 109
    //   103: invokevirtual 601	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   106: aload 6
    //   108: getfield 604	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   111: aload 9
    //   113: invokestatic 606	bbbq:a	(Ljava/lang/String;)I
    //   116: invokevirtual 601	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   119: aload 6
    //   121: getfield 609	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:platver	Lcom/tencent/mobileqq/pb/PBStringField;
    //   124: new 203	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   131: getstatic 614	android/os/Build$VERSION:SDK_INT	I
    //   134: invokevirtual 298	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   137: ldc 151
    //   139: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokevirtual 595	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   148: aload 8
    //   150: invokevirtual 616	com/tencent/mobileqq/redtouch/RedAppInfo:a	()Ljava/util/List;
    //   153: ifnull +16 -> 169
    //   156: aload 6
    //   158: getfield 619	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:missionid	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   161: aload 8
    //   163: invokevirtual 616	com/tencent/mobileqq/redtouch/RedAppInfo:a	()Ljava/util/List;
    //   166: invokevirtual 622	com/tencent/mobileqq/pb/PBRepeatField:set	(Ljava/util/List;)V
    //   169: new 143	java/util/ArrayList
    //   172: dup
    //   173: invokespecial 144	java/util/ArrayList:<init>	()V
    //   176: astore 8
    //   178: aload 7
    //   180: invokevirtual 326	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   183: astore 9
    //   185: aload 9
    //   187: invokeinterface 271 1 0
    //   192: ifeq +156 -> 348
    //   195: aload 9
    //   197: invokeinterface 275 1 0
    //   202: checkcast 281	java/lang/String
    //   205: astore 10
    //   207: new 624	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData
    //   210: dup
    //   211: invokespecial 625	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData:<init>	()V
    //   214: astore 11
    //   216: aload 11
    //   218: getfield 627	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData:key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   221: aload 10
    //   223: invokevirtual 595	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   226: aload 11
    //   228: getfield 630	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData:value	Lcom/tencent/mobileqq/pb/PBStringField;
    //   231: aload 7
    //   233: aload 10
    //   235: invokevirtual 360	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   238: invokevirtual 595	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   241: aload 8
    //   243: aload 11
    //   245: invokeinterface 165 2 0
    //   250: pop
    //   251: getstatic 636	java/lang/System:out	Ljava/io/PrintStream;
    //   254: new 203	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   261: ldc_w 638
    //   264: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload 11
    //   269: getfield 627	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData:key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   272: invokevirtual 129	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   275: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: ldc_w 640
    //   281: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: aload 11
    //   286: getfield 630	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportStaticsData:value	Lcom/tencent/mobileqq/pb/PBStringField;
    //   289: invokevirtual 129	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   292: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokevirtual 645	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   301: goto -116 -> 185
    //   304: astore_2
    //   305: aload 5
    //   307: ldc_w 398
    //   310: iconst_m1
    //   311: invokevirtual 119	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   314: pop
    //   315: aload 5
    //   317: ldc 26
    //   319: ldc_w 647
    //   322: invokevirtual 132	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   325: pop
    //   326: aload_2
    //   327: invokevirtual 327	org/json/JSONException:printStackTrace	()V
    //   330: aload_0
    //   331: aload_1
    //   332: iconst_1
    //   333: anewarray 281	java/lang/String
    //   336: dup
    //   337: iconst_0
    //   338: aload 5
    //   340: invokevirtual 364	org/json/JSONObject:toString	()Ljava/lang/String;
    //   343: aastore
    //   344: invokevirtual 456	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   347: return
    //   348: new 93	org/json/JSONObject
    //   351: dup
    //   352: invokespecial 94	org/json/JSONObject:<init>	()V
    //   355: astore 7
    //   357: aload 7
    //   359: ifnull +13 -> 372
    //   362: aload 7
    //   364: ldc_w 649
    //   367: iconst_5
    //   368: invokevirtual 119	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   371: pop
    //   372: aload 6
    //   374: getfield 650	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:buffer	Lcom/tencent/mobileqq/pb/PBStringField;
    //   377: aload 7
    //   379: invokevirtual 364	org/json/JSONObject:toString	()Ljava/lang/String;
    //   382: invokevirtual 595	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   385: aload 6
    //   387: getfield 653	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:reportdata	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   390: aload 8
    //   392: invokevirtual 654	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
    //   395: new 656	com/tencent/qphone/base/remote/ToServiceMsg
    //   398: dup
    //   399: ldc_w 658
    //   402: aload_0
    //   403: getfield 406	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mRuntime	Lbifw;
    //   406: invokevirtual 411	bifw:a	()Lcom/tencent/common/app/AppInterface;
    //   409: invokevirtual 213	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   412: ldc_w 660
    //   415: invokespecial 663	com/tencent/qphone/base/remote/ToServiceMsg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   418: astore 7
    //   420: aload 7
    //   422: aload 6
    //   424: invokevirtual 667	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$ReportReqBody:toByteArray	()[B
    //   427: invokevirtual 671	com/tencent/qphone/base/remote/ToServiceMsg:putWupBuffer	([B)V
    //   430: aload 7
    //   432: getfield 675	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   435: ldc_w 677
    //   438: iconst_1
    //   439: invokevirtual 681	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   442: aload 7
    //   444: invokevirtual 684	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
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
    //   461: ldc2_w 685
    //   464: lload_3
    //   465: ladd
    //   466: invokestatic 692	com/tencent/mobileqq/utils/httputils/PkgTools:DWord2Byte	([BIJ)V
    //   469: aload 6
    //   471: iconst_4
    //   472: aload 7
    //   474: invokevirtual 684	com/tencent/qphone/base/remote/ToServiceMsg:getWupBuffer	()[B
    //   477: lload_3
    //   478: l2i
    //   479: invokestatic 696	com/tencent/mobileqq/utils/httputils/PkgTools:copyData	([BI[BI)V
    //   482: aload 7
    //   484: aload 6
    //   486: invokevirtual 671	com/tencent/qphone/base/remote/ToServiceMsg:putWupBuffer	([B)V
    //   489: new 698	mqq/app/NewIntent
    //   492: dup
    //   493: aload_2
    //   494: invokevirtual 703	android/app/Activity:getApplication	()Landroid/app/Application;
    //   497: ldc_w 705
    //   500: invokespecial 708	mqq/app/NewIntent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   503: astore_2
    //   504: aload_2
    //   505: ldc_w 656
    //   508: invokevirtual 711	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   511: aload 7
    //   513: invokevirtual 715	mqq/app/NewIntent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   516: pop
    //   517: aload_0
    //   518: getfield 406	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:mRuntime	Lbifw;
    //   521: invokevirtual 411	bifw:a	()Lcom/tencent/common/app/AppInterface;
    //   524: aload_2
    //   525: invokevirtual 719	com/tencent/common/app/AppInterface:startServlet	(Lmqq/app/NewIntent;)V
    //   528: aload 5
    //   530: ldc_w 398
    //   533: iconst_0
    //   534: invokevirtual 119	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   537: pop
    //   538: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   541: ifeq -211 -> 330
    //   544: getstatic 72	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   547: iconst_2
    //   548: new 203	java/lang/StringBuilder
    //   551: dup
    //   552: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   555: ldc_w 721
    //   558: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: aload 5
    //   563: invokevirtual 364	org/json/JSONObject:toString	()Ljava/lang/String;
    //   566: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   572: invokestatic 187	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   575: goto -245 -> 330
    //   578: astore_2
    //   579: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   582: ifeq -252 -> 330
    //   585: getstatic 72	com/tencent/mobileqq/redtouch/RedTouchWebviewHandler:TAG	Ljava/lang/String;
    //   588: iconst_2
    //   589: new 203	java/lang/StringBuilder
    //   592: dup
    //   593: invokespecial 204	java/lang/StringBuilder:<init>	()V
    //   596: ldc_w 721
    //   599: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: aload_2
    //   603: invokevirtual 722	java/lang/Exception:toString	()Ljava/lang/String;
    //   606: invokevirtual 210	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   612: invokestatic 187	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   615: goto -285 -> 330
    //   618: astore 6
    //   620: aload 6
    //   622: invokevirtual 327	org/json/JSONException:printStackTrace	()V
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
        onReportRed(bbbt.a(localRedAppInfo), 1002);
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
    super.sendRemoteReq(asdd.a("myIndividuationRedInfo", null, 0, localBundle), false, true);
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
      new bbbq(this.mRuntime.a()).c(paramAppInfo, localJSONObject.toString());
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
          paramAppInterface = new bbbq(paramAppInterface);
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
      ((Bundle)localObject3).putParcelable("red", bbbt.a((BusinessInfoCheckUpdate.AppInfo)localObject2));
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
        localBundle.putInt("path", bbbq.a(localObject.getString("path")));
        paramString = str;
        sendRemoteReq(asdd.a("leba_item_get", str, this.mOnRemoteResp.key, localBundle), false, false);
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
      super.sendRemoteReq(asdd.a("redTouch_getRedInfo", paramString, this.mOnRemoteResp.key, localBundle), false, true);
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
        super.sendRemoteReq(asdd.a("redTouch_getRedPointShowInfo_set", paramString, this.mOnRemoteResp.key, (Bundle)localObject2), false, true);
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
          super.sendRemoteReq(asdd.a("redTouch_getRedInfo", paramString, this.mOnRemoteResp.key, (Bundle)localObject3), false, true);
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
          if (!new bbbq(this.mRuntime.a()).a().equals(localObject))
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
      super.sendRemoteReq(asdd.a("redTouch_getRedInfo", paramString, this.mOnRemoteResp.key, localBundle), false, true);
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
      super.sendRemoteReq(asdd.a("redTouch_getRedInfo", paramString, this.mOnRemoteResp.key, (Bundle)localObject3), false, true);
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
      super.sendRemoteReq(asdd.a("redTouch_setAppInfo", paramString, this.mOnRemoteResp.key, (Bundle)localObject), false, true);
      return;
    }
    callJs(paramString, new String[] { (String)((HashMap)localObject).get("errorJson") });
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
        localBundle.putInt("path", bbbq.a(localObject.getString("path")));
        paramString = str;
        localBundle.putInt("type", localObject.getInt("type"));
        paramString = str;
        sendRemoteReq(asdd.a("leba_item_set", str, this.mOnRemoteResp.key, localBundle), false, false);
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