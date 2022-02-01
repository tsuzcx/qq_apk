package com.tencent.qapmsdk.base.reporter.config;

import android.content.SharedPreferences;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.config.PluginCombination.Companion;
import com.tencent.qapmsdk.base.config.SDKConfig;
import com.tencent.qapmsdk.base.config.SDKConfig.Companion;
import com.tencent.qapmsdk.base.dbpersist.BaseTable;
import com.tencent.qapmsdk.base.dbpersist.DBHandler;
import com.tencent.qapmsdk.base.dbpersist.DBHelper;
import com.tencent.qapmsdk.base.dbpersist.table.ConfigsTable;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.base.reporter.uploaddata.QAPMUpload;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AsyncSPEditor;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/config/ConfigApply;", "Lcom/tencent/qapmsdk/base/reporter/uploaddata/QAPMUpload;", "url", "Ljava/net/URL;", "(Ljava/net/URL;)V", "configMd5", "", "serviceSwitch", "", "getServiceSwitch", "()I", "setServiceSwitch", "(I)V", "userMode", "getUserMode", "setUserMode", "flushConfigSp", "", "hit", "getHit", "getLastMode", "loadConfigs", "loadLocalConfigs", "pId", "version", "loadServiceConfigs", "Lcom/tencent/qapmsdk/base/reporter/config/ConfigApply$LoadConfigMode;", "parseConfig", "json", "Lorg/json/JSONObject;", "request", "Companion", "LoadConfigMode", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class ConfigApply
  extends QAPMUpload
{
  public static final ConfigApply.Companion Companion = new ConfigApply.Companion(null);
  private static final int STATUS_UPDATE_CONFIG = 1000;
  private static final String TAG = "QAPM_base_ConfigApply";
  private String configMd5 = "";
  private int serviceSwitch = PluginCombination.Companion.getModeStable();
  private int userMode;
  
  public ConfigApply(@NotNull URL paramURL)
  {
    super(paramURL);
  }
  
  private final void flushConfigSp(int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseInfo.sharePreference;
    if (localSharedPreferences != null)
    {
      if ((paramInt == 0) && (this.serviceSwitch > 0)) {
        BaseInfo.editor.putLong("config_hit_over_time", System.currentTimeMillis() + 2592000000L).putInt("config_hit", 1);
      }
      AsyncSPEditor localAsyncSPEditor = BaseInfo.editor;
      paramInt = this.serviceSwitch;
      localAsyncSPEditor.putInt("config_last_mode", localSharedPreferences.getInt("config_last_mode", 0) | paramInt);
    }
  }
  
  private final int getHit()
  {
    long l = System.currentTimeMillis();
    SharedPreferences localSharedPreferences = BaseInfo.sharePreference;
    if (localSharedPreferences != null)
    {
      if (localSharedPreferences.getLong("config_hit_over_time", 0L) < l) {
        BaseInfo.editor.putLong("config_hit_over_time", l + 2592000000L).putInt("config_hit", 0);
      }
      return localSharedPreferences.getInt("config_hit", 0);
    }
    return 0;
  }
  
  private final int getLastMode()
  {
    SharedPreferences localSharedPreferences = BaseInfo.sharePreference;
    int i;
    if (localSharedPreferences != null) {
      i = localSharedPreferences.getInt("config_last_day", 0);
    } else {
      i = 0;
    }
    int j = Calendar.getInstance().get(6);
    if (i != 0)
    {
      if (i != j)
      {
        BaseInfo.editor.putInt("config_last_day", j).putInt("config_last_mode", 0).apply();
        return 0;
      }
      localSharedPreferences = BaseInfo.sharePreference;
      if (localSharedPreferences != null) {
        return localSharedPreferences.getInt("config_last_mode", 0);
      }
    }
    else
    {
      BaseInfo.editor.putInt("config_last_day", j).apply();
    }
    return 0;
  }
  
  private final void loadLocalConfigs(int paramInt, String paramString)
  {
    Object localObject = BaseInfo.dbHelper;
    if (localObject != null)
    {
      localObject = ((DBHelper)localObject).getDbHandler();
      if (localObject != null) {
        ((DBHandler)localObject).search((BaseTable)new ConfigsTable(paramInt, paramString), (Function0)ConfigApply.loadLocalConfigs.1.INSTANCE);
      }
    }
    paramString = BaseInfo.sharePreference;
    float f = 0.0F;
    if (paramString != null) {
      f = paramString.getFloat("config_user_sample_ratio", 0.0F);
    }
    int i = 0;
    if (f > 0) {
      SDKConfig.Companion.setUSER_SAMPLE_RATIO(f);
    }
    paramString = BaseInfo.sharePreference;
    if (paramString != null) {
      paramInt = paramString.getInt("config_max_austerity_report_number", 0);
    } else {
      paramInt = 0;
    }
    if (paramInt >= 0) {
      SDKConfig.Companion.setMAX_AUSTERITY_REPORT_NUM(paramInt);
    }
    paramString = BaseInfo.sharePreference;
    if (paramString != null) {
      paramInt = paramString.getInt("config_max_loose_report_number", 0);
    } else {
      paramInt = 0;
    }
    if (paramInt >= 0) {
      SDKConfig.Companion.setMAX_LOOSE_REPORT_NUM(paramInt);
    }
    paramString = BaseInfo.sharePreference;
    paramInt = i;
    if (paramString != null) {
      paramInt = paramString.getInt("config_version_type", 0);
    }
    if (paramInt > 0) {
      SDKConfig.Companion.setVER_TYPE(paramInt);
    }
    paramString = BaseInfo.sharePreference;
    paramInt = 2;
    if (paramString != null) {
      paramInt = paramString.getInt("config_resource_type", 2);
    }
    if (paramInt >= 0) {
      SDKConfig.RES_TYPE = paramInt;
    }
  }
  
  /* Error */
  private final ConfigApply.LoadConfigMode loadServiceConfigs(int paramInt)
  {
    // Byte code:
    //   0: getstatic 229	com/tencent/qapmsdk/base/reporter/config/ConfigApply$LoadConfigMode:NO_AUTHORITY	Lcom/tencent/qapmsdk/base/reporter/config/ConfigApply$LoadConfigMode;
    //   3: astore 6
    //   5: getstatic 232	com/tencent/qapmsdk/base/meta/BaseInfo:token	Ljava/lang/String;
    //   8: checkcast 234	java/lang/CharSequence
    //   11: invokestatic 240	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +25 -> 39
    //   17: getstatic 245	com/tencent/qapmsdk/base/reporter/proxy/AuthorizationProxy:INSTANCE	Lcom/tencent/qapmsdk/base/reporter/proxy/AuthorizationProxy;
    //   20: invokevirtual 249	com/tencent/qapmsdk/base/reporter/proxy/AuthorizationProxy:getAuthorization	()Lcom/tencent/qapmsdk/base/reporter/authorization/Authorization;
    //   23: getstatic 253	com/tencent/qapmsdk/base/meta/BaseInfo:userMeta	Lcom/tencent/qapmsdk/base/meta/UserMeta;
    //   26: getfield 258	com/tencent/qapmsdk/base/meta/UserMeta:appKey	Ljava/lang/String;
    //   29: iconst_1
    //   30: invokevirtual 264	com/tencent/qapmsdk/base/reporter/authorization/Authorization:getToken	(Ljava/lang/String;Z)Z
    //   33: ifne +6 -> 39
    //   36: aload 6
    //   38: areturn
    //   39: new 266	java/util/HashMap
    //   42: dup
    //   43: invokespecial 268	java/util/HashMap:<init>	()V
    //   46: astore_3
    //   47: aload_3
    //   48: checkcast 270	java/util/Map
    //   51: astore 4
    //   53: aload 4
    //   55: ldc_w 272
    //   58: ldc_w 274
    //   61: invokeinterface 278 3 0
    //   66: pop
    //   67: aload 4
    //   69: ldc_w 280
    //   72: ldc_w 282
    //   75: invokeinterface 278 3 0
    //   80: pop
    //   81: aload 4
    //   83: ldc_w 284
    //   86: getstatic 232	com/tencent/qapmsdk/base/meta/BaseInfo:token	Ljava/lang/String;
    //   89: invokeinterface 278 3 0
    //   94: pop
    //   95: aload_0
    //   96: aload_3
    //   97: invokevirtual 288	com/tencent/qapmsdk/base/reporter/config/ConfigApply:connectionBuilder	(Ljava/util/HashMap;)Ljava/net/HttpURLConnection;
    //   100: astore 8
    //   102: aload 6
    //   104: astore 5
    //   106: aload 8
    //   108: ifnull +994 -> 1102
    //   111: aload 6
    //   113: astore_3
    //   114: aload 6
    //   116: astore 4
    //   118: aload_0
    //   119: invokespecial 290	com/tencent/qapmsdk/base/reporter/config/ConfigApply:getHit	()I
    //   122: istore_2
    //   123: aload 6
    //   125: astore_3
    //   126: aload 6
    //   128: astore 4
    //   130: new 292	org/json/JSONObject
    //   133: dup
    //   134: getstatic 253	com/tencent/qapmsdk/base/meta/BaseInfo:userMeta	Lcom/tencent/qapmsdk/base/meta/UserMeta;
    //   137: aconst_null
    //   138: aconst_null
    //   139: aconst_null
    //   140: iconst_0
    //   141: aconst_null
    //   142: aconst_null
    //   143: aconst_null
    //   144: aconst_null
    //   145: aconst_null
    //   146: aconst_null
    //   147: aconst_null
    //   148: aconst_null
    //   149: aconst_null
    //   150: sipush 8191
    //   153: aconst_null
    //   154: invokestatic 296	com/tencent/qapmsdk/base/meta/UserMeta:copy$default	(Lcom/tencent/qapmsdk/base/meta/UserMeta;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Object;)Lcom/tencent/qapmsdk/base/meta/UserMeta;
    //   157: invokevirtual 300	com/tencent/qapmsdk/base/meta/UserMeta:toJSON	()Ljava/lang/String;
    //   160: invokespecial 303	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   163: astore 10
    //   165: aload 6
    //   167: astore_3
    //   168: aload 6
    //   170: astore 4
    //   172: aload 10
    //   174: ldc_w 305
    //   177: iload_1
    //   178: invokevirtual 308	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   181: pop
    //   182: aload 6
    //   184: astore_3
    //   185: aload 6
    //   187: astore 4
    //   189: aload 10
    //   191: ldc_w 310
    //   194: aload_0
    //   195: invokespecial 312	com/tencent/qapmsdk/base/reporter/config/ConfigApply:getLastMode	()I
    //   198: invokevirtual 308	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   201: pop
    //   202: aload 6
    //   204: astore_3
    //   205: aload 6
    //   207: astore 4
    //   209: aload 10
    //   211: ldc_w 314
    //   214: aload 10
    //   216: ldc_w 316
    //   219: invokevirtual 319	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   222: invokevirtual 324	java/lang/Object:toString	()Ljava/lang/String;
    //   225: invokevirtual 327	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   228: pop
    //   229: aload 6
    //   231: astore_3
    //   232: aload 6
    //   234: astore 4
    //   236: aload 10
    //   238: ldc_w 328
    //   241: iload_2
    //   242: invokevirtual 308	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   245: pop
    //   246: aload 6
    //   248: astore_3
    //   249: aload 6
    //   251: astore 4
    //   253: aload 10
    //   255: ldc_w 316
    //   258: invokevirtual 331	org/json/JSONObject:remove	(Ljava/lang/String;)Ljava/lang/Object;
    //   261: pop
    //   262: aload 6
    //   264: astore_3
    //   265: aload 6
    //   267: astore 4
    //   269: aload_0
    //   270: getfield 79	com/tencent/qapmsdk/base/reporter/config/ConfigApply:configMd5	Ljava/lang/String;
    //   273: checkcast 234	java/lang/CharSequence
    //   276: invokeinterface 334 1 0
    //   281: ifle +839 -> 1120
    //   284: iconst_1
    //   285: istore_1
    //   286: goto +3 -> 289
    //   289: iload_1
    //   290: ifeq +23 -> 313
    //   293: aload 6
    //   295: astore_3
    //   296: aload 6
    //   298: astore 4
    //   300: aload 10
    //   302: ldc_w 336
    //   305: aload_0
    //   306: getfield 79	com/tencent/qapmsdk/base/reporter/config/ConfigApply:configMd5	Ljava/lang/String;
    //   309: invokevirtual 327	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   312: pop
    //   313: aload 6
    //   315: astore_3
    //   316: aload 6
    //   318: astore 4
    //   320: getstatic 341	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   323: astore 5
    //   325: aload 6
    //   327: astore_3
    //   328: aload 6
    //   330: astore 4
    //   332: aload 10
    //   334: invokevirtual 342	org/json/JSONObject:toString	()Ljava/lang/String;
    //   337: astore 7
    //   339: aload 6
    //   341: astore_3
    //   342: aload 6
    //   344: astore 4
    //   346: aload 7
    //   348: ldc_w 344
    //   351: invokestatic 347	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   354: aload 6
    //   356: astore_3
    //   357: aload 6
    //   359: astore 4
    //   361: aload 5
    //   363: iconst_2
    //   364: anewarray 349	java/lang/String
    //   367: dup
    //   368: iconst_0
    //   369: ldc 55
    //   371: aastore
    //   372: dup
    //   373: iconst_1
    //   374: aload 7
    //   376: aastore
    //   377: invokevirtual 353	com/tencent/qapmsdk/common/logger/Logger:i	([Ljava/lang/String;)V
    //   380: aload 6
    //   382: astore_3
    //   383: aload 6
    //   385: astore 4
    //   387: new 355	java/util/zip/GZIPOutputStream
    //   390: dup
    //   391: new 357	java/io/DataOutputStream
    //   394: dup
    //   395: aload 8
    //   397: invokevirtual 363	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   400: invokespecial 366	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   403: checkcast 368	java/io/OutputStream
    //   406: invokespecial 369	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   409: checkcast 371	java/io/Closeable
    //   412: astore 9
    //   414: aload 6
    //   416: astore_3
    //   417: aload 6
    //   419: astore 4
    //   421: aconst_null
    //   422: checkcast 224	java/lang/Throwable
    //   425: astore 7
    //   427: aload 7
    //   429: astore 5
    //   431: aload 9
    //   433: checkcast 355	java/util/zip/GZIPOutputStream
    //   436: astore_3
    //   437: aload 7
    //   439: astore 5
    //   441: aload 10
    //   443: invokevirtual 342	org/json/JSONObject:toString	()Ljava/lang/String;
    //   446: astore 4
    //   448: aload 7
    //   450: astore 5
    //   452: aload 4
    //   454: ldc_w 344
    //   457: invokestatic 347	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   460: aload 7
    //   462: astore 5
    //   464: ldc_w 373
    //   467: invokestatic 379	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   470: astore 10
    //   472: aload 7
    //   474: astore 5
    //   476: aload 10
    //   478: ldc_w 381
    //   481: invokestatic 347	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   484: aload 4
    //   486: ifnull +495 -> 981
    //   489: aload 7
    //   491: astore 5
    //   493: aload 4
    //   495: aload 10
    //   497: invokevirtual 385	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   500: astore 4
    //   502: aload 7
    //   504: astore 5
    //   506: aload 4
    //   508: ldc_w 387
    //   511: invokestatic 347	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   514: aload 7
    //   516: astore 5
    //   518: aload_3
    //   519: aload 4
    //   521: invokevirtual 391	java/util/zip/GZIPOutputStream:write	([B)V
    //   524: aload 7
    //   526: astore 5
    //   528: aload_3
    //   529: invokevirtual 394	java/util/zip/GZIPOutputStream:finish	()V
    //   532: aload 7
    //   534: astore 5
    //   536: getstatic 399	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   539: astore_3
    //   540: aload 6
    //   542: astore_3
    //   543: aload 6
    //   545: astore 4
    //   547: aload 9
    //   549: aload 7
    //   551: invokestatic 405	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   554: aload 6
    //   556: astore_3
    //   557: aload 6
    //   559: astore 4
    //   561: new 407	java/io/BufferedInputStream
    //   564: dup
    //   565: aload 8
    //   567: invokevirtual 411	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   570: invokespecial 414	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   573: checkcast 371	java/io/Closeable
    //   576: astore 9
    //   578: aload 6
    //   580: astore_3
    //   581: aload 6
    //   583: astore 4
    //   585: aconst_null
    //   586: checkcast 224	java/lang/Throwable
    //   589: astore 7
    //   591: aload 7
    //   593: astore 5
    //   595: aload 9
    //   597: checkcast 407	java/io/BufferedInputStream
    //   600: astore_3
    //   601: aload 7
    //   603: astore 5
    //   605: getstatic 419	com/tencent/qapmsdk/common/util/FileUtil:Companion	Lcom/tencent/qapmsdk/common/util/FileUtil$Companion;
    //   608: aload_3
    //   609: checkcast 421	java/io/InputStream
    //   612: sipush 8192
    //   615: invokevirtual 427	com/tencent/qapmsdk/common/util/FileUtil$Companion:readStream	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   618: astore 10
    //   620: aload 7
    //   622: astore 5
    //   624: getstatic 341	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   627: iconst_2
    //   628: anewarray 349	java/lang/String
    //   631: dup
    //   632: iconst_0
    //   633: ldc 55
    //   635: aastore
    //   636: dup
    //   637: iconst_1
    //   638: aload 10
    //   640: aastore
    //   641: invokevirtual 353	com/tencent/qapmsdk/common/logger/Logger:i	([Ljava/lang/String;)V
    //   644: aload 7
    //   646: astore 5
    //   648: getstatic 399	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   651: astore_3
    //   652: aload 6
    //   654: astore_3
    //   655: aload 6
    //   657: astore 4
    //   659: aload 9
    //   661: aload 7
    //   663: invokestatic 405	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   666: aload 6
    //   668: astore_3
    //   669: aload 6
    //   671: astore 4
    //   673: new 292	org/json/JSONObject
    //   676: dup
    //   677: aload 10
    //   679: invokespecial 303	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   682: astore 5
    //   684: aload 6
    //   686: astore_3
    //   687: aload 6
    //   689: astore 4
    //   691: aload_0
    //   692: aload 5
    //   694: ldc_w 429
    //   697: invokevirtual 432	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   700: putfield 91	com/tencent/qapmsdk/base/reporter/config/ConfigApply:serviceSwitch	I
    //   703: aload 6
    //   705: astore_3
    //   706: aload 6
    //   708: astore 4
    //   710: aload 5
    //   712: ldc_w 434
    //   715: invokevirtual 432	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   718: sipush 1000
    //   721: if_icmpne +185 -> 906
    //   724: aload 6
    //   726: astore_3
    //   727: aload 6
    //   729: astore 4
    //   731: aload 5
    //   733: ldc_w 436
    //   736: invokevirtual 440	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   739: astore 7
    //   741: aload 6
    //   743: astore_3
    //   744: aload 6
    //   746: astore 4
    //   748: aload 7
    //   750: ldc_w 442
    //   753: invokestatic 347	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   756: aload 6
    //   758: astore_3
    //   759: aload 6
    //   761: astore 4
    //   763: aload_0
    //   764: aload 7
    //   766: invokespecial 445	com/tencent/qapmsdk/base/reporter/config/ConfigApply:parseConfig	(Lorg/json/JSONObject;)V
    //   769: aload 6
    //   771: astore_3
    //   772: aload 6
    //   774: astore 4
    //   776: aload 5
    //   778: ldc_w 447
    //   781: invokevirtual 451	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   784: astore 5
    //   786: aload 6
    //   788: astore_3
    //   789: aload 6
    //   791: astore 4
    //   793: aload 5
    //   795: ldc_w 453
    //   798: invokestatic 347	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   801: aload 6
    //   803: astore_3
    //   804: aload 6
    //   806: astore 4
    //   808: aload_0
    //   809: aload 5
    //   811: putfield 79	com/tencent/qapmsdk/base/reporter/config/ConfigApply:configMd5	Ljava/lang/String;
    //   814: aload 6
    //   816: astore_3
    //   817: aload 6
    //   819: astore 4
    //   821: getstatic 156	com/tencent/qapmsdk/base/meta/BaseInfo:dbHelper	Lcom/tencent/qapmsdk/base/dbpersist/DBHelper;
    //   824: astore 5
    //   826: aload 5
    //   828: ifnull +63 -> 891
    //   831: aload 6
    //   833: astore_3
    //   834: aload 6
    //   836: astore 4
    //   838: aload 5
    //   840: invokevirtual 162	com/tencent/qapmsdk/base/dbpersist/DBHelper:getDbHandler	()Lcom/tencent/qapmsdk/base/dbpersist/DBHandler;
    //   843: astore 5
    //   845: aload 5
    //   847: ifnull +44 -> 891
    //   850: aload 6
    //   852: astore_3
    //   853: aload 6
    //   855: astore 4
    //   857: aload 5
    //   859: new 164	com/tencent/qapmsdk/base/dbpersist/table/ConfigsTable
    //   862: dup
    //   863: getstatic 253	com/tencent/qapmsdk/base/meta/BaseInfo:userMeta	Lcom/tencent/qapmsdk/base/meta/UserMeta;
    //   866: getfield 456	com/tencent/qapmsdk/base/meta/UserMeta:appId	I
    //   869: getstatic 253	com/tencent/qapmsdk/base/meta/BaseInfo:userMeta	Lcom/tencent/qapmsdk/base/meta/UserMeta;
    //   872: getfield 458	com/tencent/qapmsdk/base/meta/UserMeta:version	Ljava/lang/String;
    //   875: invokespecial 166	com/tencent/qapmsdk/base/dbpersist/table/ConfigsTable:<init>	(ILjava/lang/String;)V
    //   878: checkcast 168	com/tencent/qapmsdk/base/dbpersist/BaseTable
    //   881: getstatic 463	com/tencent/qapmsdk/base/reporter/config/ConfigApply$loadServiceConfigs$1$3:INSTANCE	Lcom/tencent/qapmsdk/base/reporter/config/ConfigApply$loadServiceConfigs$1$3;
    //   884: checkcast 176	kotlin/jvm/functions/Function0
    //   887: invokevirtual 467	com/tencent/qapmsdk/base/dbpersist/DBHandler:insert	(Lcom/tencent/qapmsdk/base/dbpersist/BaseTable;Lkotlin/jvm/functions/Function0;)I
    //   890: pop
    //   891: aload 6
    //   893: astore_3
    //   894: aload 6
    //   896: astore 4
    //   898: getstatic 470	com/tencent/qapmsdk/base/reporter/config/ConfigApply$LoadConfigMode:FROM_SERVICE	Lcom/tencent/qapmsdk/base/reporter/config/ConfigApply$LoadConfigMode;
    //   901: astore 5
    //   903: goto +15 -> 918
    //   906: aload 6
    //   908: astore_3
    //   909: aload 6
    //   911: astore 4
    //   913: getstatic 473	com/tencent/qapmsdk/base/reporter/config/ConfigApply$LoadConfigMode:FROM_LOCAL	Lcom/tencent/qapmsdk/base/reporter/config/ConfigApply$LoadConfigMode;
    //   916: astore 5
    //   918: aload 5
    //   920: astore_3
    //   921: aload 5
    //   923: astore 4
    //   925: aload_0
    //   926: iload_2
    //   927: invokespecial 475	com/tencent/qapmsdk/base/reporter/config/ConfigApply:flushConfigSp	(I)V
    //   930: aload 5
    //   932: astore_3
    //   933: aload 5
    //   935: astore 4
    //   937: getstatic 102	com/tencent/qapmsdk/base/meta/BaseInfo:editor	Lcom/tencent/qapmsdk/common/util/AsyncSPEditor;
    //   940: invokevirtual 151	com/tencent/qapmsdk/common/util/AsyncSPEditor:apply	()V
    //   943: goto +159 -> 1102
    //   946: astore 7
    //   948: goto +9 -> 957
    //   951: astore_3
    //   952: aload_3
    //   953: astore 5
    //   955: aload_3
    //   956: athrow
    //   957: aload 6
    //   959: astore_3
    //   960: aload 6
    //   962: astore 4
    //   964: aload 9
    //   966: aload 5
    //   968: invokestatic 405	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   971: aload 6
    //   973: astore_3
    //   974: aload 6
    //   976: astore 4
    //   978: aload 7
    //   980: athrow
    //   981: aload 7
    //   983: astore 5
    //   985: new 477	kotlin/TypeCastException
    //   988: dup
    //   989: ldc_w 479
    //   992: invokespecial 480	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   995: athrow
    //   996: astore 7
    //   998: goto +9 -> 1007
    //   1001: astore_3
    //   1002: aload_3
    //   1003: astore 5
    //   1005: aload_3
    //   1006: athrow
    //   1007: aload 6
    //   1009: astore_3
    //   1010: aload 6
    //   1012: astore 4
    //   1014: aload 9
    //   1016: aload 5
    //   1018: invokestatic 405	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   1021: aload 6
    //   1023: astore_3
    //   1024: aload 6
    //   1026: astore 4
    //   1028: aload 7
    //   1030: athrow
    //   1031: astore_3
    //   1032: goto +58 -> 1090
    //   1035: astore 4
    //   1037: getstatic 341	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   1040: ldc 55
    //   1042: aload 4
    //   1044: invokevirtual 484	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1047: aload_3
    //   1048: astore 6
    //   1050: aload 8
    //   1052: ifnull +65 -> 1117
    //   1055: aload 8
    //   1057: invokevirtual 487	java/net/HttpURLConnection:disconnect	()V
    //   1060: aload_3
    //   1061: areturn
    //   1062: astore_3
    //   1063: getstatic 341	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   1066: ldc 55
    //   1068: aload_3
    //   1069: checkcast 224	java/lang/Throwable
    //   1072: invokevirtual 484	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1075: aload 4
    //   1077: astore 6
    //   1079: aload 8
    //   1081: ifnull +36 -> 1117
    //   1084: aload 4
    //   1086: astore_3
    //   1087: goto -32 -> 1055
    //   1090: aload 8
    //   1092: ifnull +8 -> 1100
    //   1095: aload 8
    //   1097: invokevirtual 487	java/net/HttpURLConnection:disconnect	()V
    //   1100: aload_3
    //   1101: athrow
    //   1102: aload 5
    //   1104: astore 6
    //   1106: aload 8
    //   1108: ifnull +9 -> 1117
    //   1111: aload 5
    //   1113: astore_3
    //   1114: goto -59 -> 1055
    //   1117: aload 6
    //   1119: areturn
    //   1120: iconst_0
    //   1121: istore_1
    //   1122: goto -833 -> 289
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1125	0	this	ConfigApply
    //   0	1125	1	paramInt	int
    //   122	805	2	i	int
    //   46	887	3	localObject1	Object
    //   951	5	3	localThrowable1	Throwable
    //   959	15	3	localObject2	Object
    //   1001	5	3	localThrowable2	Throwable
    //   1009	15	3	localObject3	Object
    //   1031	30	3	localLoadConfigMode	ConfigApply.LoadConfigMode
    //   1062	7	3	localJSONException	org.json.JSONException
    //   1086	28	3	localObject4	Object
    //   51	976	4	localObject5	Object
    //   1035	50	4	localThrowable3	Throwable
    //   104	1008	5	localObject6	Object
    //   3	1115	6	localObject7	Object
    //   337	428	7	localObject8	Object
    //   946	36	7	localObject9	Object
    //   996	33	7	localObject10	Object
    //   100	1007	8	localHttpURLConnection	java.net.HttpURLConnection
    //   412	603	9	localCloseable	java.io.Closeable
    //   163	515	10	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   595	601	946	finally
    //   605	620	946	finally
    //   624	644	946	finally
    //   648	652	946	finally
    //   955	957	946	finally
    //   595	601	951	java/lang/Throwable
    //   605	620	951	java/lang/Throwable
    //   624	644	951	java/lang/Throwable
    //   648	652	951	java/lang/Throwable
    //   431	437	996	finally
    //   441	448	996	finally
    //   452	460	996	finally
    //   464	472	996	finally
    //   476	484	996	finally
    //   493	502	996	finally
    //   506	514	996	finally
    //   518	524	996	finally
    //   528	532	996	finally
    //   536	540	996	finally
    //   985	996	996	finally
    //   1005	1007	996	finally
    //   431	437	1001	java/lang/Throwable
    //   441	448	1001	java/lang/Throwable
    //   452	460	1001	java/lang/Throwable
    //   464	472	1001	java/lang/Throwable
    //   476	484	1001	java/lang/Throwable
    //   493	502	1001	java/lang/Throwable
    //   506	514	1001	java/lang/Throwable
    //   518	524	1001	java/lang/Throwable
    //   528	532	1001	java/lang/Throwable
    //   536	540	1001	java/lang/Throwable
    //   985	996	1001	java/lang/Throwable
    //   118	123	1031	finally
    //   130	165	1031	finally
    //   172	182	1031	finally
    //   189	202	1031	finally
    //   209	229	1031	finally
    //   236	246	1031	finally
    //   253	262	1031	finally
    //   269	284	1031	finally
    //   300	313	1031	finally
    //   320	325	1031	finally
    //   332	339	1031	finally
    //   346	354	1031	finally
    //   361	380	1031	finally
    //   387	414	1031	finally
    //   421	427	1031	finally
    //   547	554	1031	finally
    //   561	578	1031	finally
    //   585	591	1031	finally
    //   659	666	1031	finally
    //   673	684	1031	finally
    //   691	703	1031	finally
    //   710	724	1031	finally
    //   731	741	1031	finally
    //   748	756	1031	finally
    //   763	769	1031	finally
    //   776	786	1031	finally
    //   793	801	1031	finally
    //   808	814	1031	finally
    //   821	826	1031	finally
    //   838	845	1031	finally
    //   857	891	1031	finally
    //   898	903	1031	finally
    //   913	918	1031	finally
    //   925	930	1031	finally
    //   937	943	1031	finally
    //   964	971	1031	finally
    //   978	981	1031	finally
    //   1014	1021	1031	finally
    //   1028	1031	1031	finally
    //   1037	1047	1031	finally
    //   1063	1075	1031	finally
    //   118	123	1035	java/lang/Throwable
    //   130	165	1035	java/lang/Throwable
    //   172	182	1035	java/lang/Throwable
    //   189	202	1035	java/lang/Throwable
    //   209	229	1035	java/lang/Throwable
    //   236	246	1035	java/lang/Throwable
    //   253	262	1035	java/lang/Throwable
    //   269	284	1035	java/lang/Throwable
    //   300	313	1035	java/lang/Throwable
    //   320	325	1035	java/lang/Throwable
    //   332	339	1035	java/lang/Throwable
    //   346	354	1035	java/lang/Throwable
    //   361	380	1035	java/lang/Throwable
    //   387	414	1035	java/lang/Throwable
    //   421	427	1035	java/lang/Throwable
    //   547	554	1035	java/lang/Throwable
    //   561	578	1035	java/lang/Throwable
    //   585	591	1035	java/lang/Throwable
    //   659	666	1035	java/lang/Throwable
    //   673	684	1035	java/lang/Throwable
    //   691	703	1035	java/lang/Throwable
    //   710	724	1035	java/lang/Throwable
    //   731	741	1035	java/lang/Throwable
    //   748	756	1035	java/lang/Throwable
    //   763	769	1035	java/lang/Throwable
    //   776	786	1035	java/lang/Throwable
    //   793	801	1035	java/lang/Throwable
    //   808	814	1035	java/lang/Throwable
    //   821	826	1035	java/lang/Throwable
    //   838	845	1035	java/lang/Throwable
    //   857	891	1035	java/lang/Throwable
    //   898	903	1035	java/lang/Throwable
    //   913	918	1035	java/lang/Throwable
    //   925	930	1035	java/lang/Throwable
    //   937	943	1035	java/lang/Throwable
    //   964	971	1035	java/lang/Throwable
    //   978	981	1035	java/lang/Throwable
    //   1014	1021	1035	java/lang/Throwable
    //   1028	1031	1035	java/lang/Throwable
    //   118	123	1062	org/json/JSONException
    //   130	165	1062	org/json/JSONException
    //   172	182	1062	org/json/JSONException
    //   189	202	1062	org/json/JSONException
    //   209	229	1062	org/json/JSONException
    //   236	246	1062	org/json/JSONException
    //   253	262	1062	org/json/JSONException
    //   269	284	1062	org/json/JSONException
    //   300	313	1062	org/json/JSONException
    //   320	325	1062	org/json/JSONException
    //   332	339	1062	org/json/JSONException
    //   346	354	1062	org/json/JSONException
    //   361	380	1062	org/json/JSONException
    //   387	414	1062	org/json/JSONException
    //   421	427	1062	org/json/JSONException
    //   547	554	1062	org/json/JSONException
    //   561	578	1062	org/json/JSONException
    //   585	591	1062	org/json/JSONException
    //   659	666	1062	org/json/JSONException
    //   673	684	1062	org/json/JSONException
    //   691	703	1062	org/json/JSONException
    //   710	724	1062	org/json/JSONException
    //   731	741	1062	org/json/JSONException
    //   748	756	1062	org/json/JSONException
    //   763	769	1062	org/json/JSONException
    //   776	786	1062	org/json/JSONException
    //   793	801	1062	org/json/JSONException
    //   808	814	1062	org/json/JSONException
    //   821	826	1062	org/json/JSONException
    //   838	845	1062	org/json/JSONException
    //   857	891	1062	org/json/JSONException
    //   898	903	1062	org/json/JSONException
    //   913	918	1062	org/json/JSONException
    //   925	930	1062	org/json/JSONException
    //   937	943	1062	org/json/JSONException
    //   964	971	1062	org/json/JSONException
    //   978	981	1062	org/json/JSONException
    //   1014	1021	1062	org/json/JSONException
    //   1028	1031	1062	org/json/JSONException
  }
  
  private final void parseConfig(JSONObject paramJSONObject)
  {
    Object localObject1 = Logger.INSTANCE;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("parseConfig json: ");
    ((StringBuilder)localObject2).append(paramJSONObject);
    ((Logger)localObject1).i(new String[] { "QAPM_base_ConfigApply", ((StringBuilder)localObject2).toString() });
    if (paramJSONObject.getInt("pid") == BaseInfo.userMeta.appId)
    {
      localObject1 = paramJSONObject.keys();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "json.keys()");
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        int i;
        if (localObject2 != null)
        {
          i = ((String)localObject2).hashCode();
          if (i != 3476)
          {
            if (i != 3477)
            {
              if (i != 3650)
              {
                if (i != 3774)
                {
                  if ((i == 116116) && (((String)localObject2).equals("usr")))
                  {
                    SDKConfig.Companion.setUSER_SAMPLE_RATIO((float)paramJSONObject.getDouble((String)localObject2));
                    BaseInfo.editor.putFloat("config_user_sample_ratio", SDKConfig.Companion.getUSER_SAMPLE_RATIO());
                  }
                }
                else if (((String)localObject2).equals("vt"))
                {
                  SDKConfig.Companion.setVER_TYPE(paramJSONObject.getInt((String)localObject2));
                  BaseInfo.editor.putInt("config_version_type", SDKConfig.Companion.getVER_TYPE());
                }
              }
              else if (((String)localObject2).equals("rt"))
              {
                SDKConfig.RES_TYPE = paramJSONObject.getInt((String)localObject2);
                BaseInfo.editor.putInt("config_resource_type", SDKConfig.RES_TYPE);
              }
            }
            else if (((String)localObject2).equals("mb"))
            {
              SDKConfig.Companion.setMAX_LOOSE_REPORT_NUM(paramJSONObject.getInt((String)localObject2));
              BaseInfo.editor.putInt("config_max_loose_report_number", SDKConfig.Companion.getMAX_LOOSE_REPORT_NUM());
            }
          }
          else if (((String)localObject2).equals("ma"))
          {
            SDKConfig.Companion.setMAX_AUSTERITY_REPORT_NUM(paramJSONObject.getInt((String)localObject2));
            BaseInfo.editor.putInt("config_max_austerity_report_number", SDKConfig.Companion.getMAX_AUSTERITY_REPORT_NUM());
            continue;
          }
        }
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "it");
        if (StringsKt.startsWith$default((String)localObject2, "p_", false, 2, null))
        {
          int k = Integer.parseInt(StringsKt.replace$default((String)localObject2, "p_", "", false, 4, null));
          localObject2 = paramJSONObject.getString((String)localObject2);
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "json.getString(it)");
          localObject2 = (CharSequence)localObject2;
          Object localObject3 = (Iterable)new Regex(",").split((CharSequence)localObject2, 0);
          localObject2 = new ArrayList();
          localObject3 = ((Iterable)localObject3).iterator();
          i = 0;
          while (((Iterator)localObject3).hasNext())
          {
            Object localObject4 = ((Iterator)localObject3).next();
            if (i != 0)
            {
              ((ArrayList)localObject2).add(localObject4);
            }
            else
            {
              int j;
              if (((CharSequence)localObject4).length() == 0) {
                j = 1;
              } else {
                j = 0;
              }
              if (j == 0)
              {
                ((ArrayList)localObject2).add(localObject4);
                i = 1;
              }
            }
          }
          localObject2 = (List)localObject2;
          if (((List)localObject2).size() >= 4) {
            PluginController.INSTANCE.resetPlugin(k, Integer.parseInt((String)((List)localObject2).get(0)), Integer.parseInt((String)((List)localObject2).get(1)), Float.parseFloat((String)((List)localObject2).get(2)), Integer.parseInt((String)((List)localObject2).get(3)));
          }
        }
      }
    }
    BaseInfo.editor.apply();
  }
  
  public final int getServiceSwitch()
  {
    return this.serviceSwitch;
  }
  
  public final int getUserMode()
  {
    return this.userMode;
  }
  
  public final void loadConfigs(int paramInt)
  {
    PluginController.INSTANCE.resetReportNum();
    for (;;)
    {
      try
      {
        Object localObject = BaseInfo.sharePreference;
        if (localObject != null)
        {
          localObject = ((SharedPreferences)localObject).getString("config_data", "");
          if (localObject != null)
          {
            this.configMd5 = ((String)localObject);
            localObject = loadServiceConfigs(paramInt);
            paramInt = ConfigApply.WhenMappings.$EnumSwitchMapping$0[localObject.ordinal()];
            if (paramInt != 1)
            {
              if (paramInt != 2)
              {
                if (paramInt != 3) {
                  return;
                }
                BaseInfo.editor.putString("config_data", this.configMd5).apply();
                return;
              }
              loadLocalConfigs(BaseInfo.userMeta.appId, BaseInfo.userMeta.version);
              return;
            }
            this.serviceSwitch = 0;
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        this.serviceSwitch = 0;
        Logger.INSTANCE.exception("QAPM_base_ConfigApply", localThrowable);
        return;
      }
      String str = "";
    }
  }
  
  public void request()
  {
    loadConfigs(this.userMode);
  }
  
  public final void setServiceSwitch(int paramInt)
  {
    this.serviceSwitch = paramInt;
  }
  
  public final void setUserMode(int paramInt)
  {
    this.userMode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.config.ConfigApply
 * JD-Core Version:    0.7.0.1
 */