package com.tencent.qapmsdk.base.reporter.authorization;

import android.content.SharedPreferences;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.reporter.uploaddata.QAPMUpload;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AsyncSPEditor;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/authorization/Authorization;", "Lcom/tencent/qapmsdk/base/reporter/uploaddata/QAPMUpload;", "url", "Ljava/net/URL;", "(Ljava/net/URL;)V", "appKey", "", "getAppKey", "()Ljava/lang/String;", "setAppKey", "(Ljava/lang/String;)V", "getToken", "", "local", "readTokenFromLocal", "readTokenFromServer", "request", "", "writeTokenToLocal", "token", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class Authorization
  extends QAPMUpload
{
  public static final Authorization.Companion Companion = new Authorization.Companion(null);
  private static final String TAG = "QAPM_base_Authorization";
  @NotNull
  private String appKey = "";
  
  public Authorization(@NotNull URL paramURL)
  {
    super(paramURL);
  }
  
  private final boolean readTokenFromLocal(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (BaseInfo.sharePreference == null) {
        return false;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject = BaseInfo.sharePreference;
        if (localObject == null) {
          break label75;
        }
        localObject = ((SharedPreferences)localObject).getString("token", "");
        if (localObject == null) {
          break label75;
        }
        BaseInfo.token = (String)localObject;
        int i = ((CharSequence)BaseInfo.token).length();
        if (i > 0) {
          return true;
        }
      }
      catch (Exception localException)
      {
        Logger.INSTANCE.exception("QAPM_base_Authorization", (Throwable)localException);
      }
      return false;
      label75:
      String str = "";
    }
  }
  
  /* Error */
  private final boolean readTokenFromServer(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: checkcast 85	java/lang/CharSequence
    //   4: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: istore_3
    //   8: iconst_0
    //   9: istore 6
    //   11: iconst_0
    //   12: istore 7
    //   14: iconst_0
    //   15: istore 5
    //   17: iload 7
    //   19: istore 4
    //   21: iload_3
    //   22: ifne +563 -> 585
    //   25: aload_0
    //   26: invokevirtual 112	com/tencent/qapmsdk/base/reporter/authorization/Authorization:getUrl	()Ljava/net/URL;
    //   29: invokevirtual 117	java/net/URL:toString	()Ljava/lang/String;
    //   32: astore_1
    //   33: aload_1
    //   34: ldc 119
    //   36: invokestatic 122	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   39: aload_1
    //   40: checkcast 85	java/lang/CharSequence
    //   43: invokeinterface 89 1 0
    //   48: ifne +8 -> 56
    //   51: iconst_1
    //   52: istore_2
    //   53: goto +5 -> 58
    //   56: iconst_0
    //   57: istore_2
    //   58: iload_2
    //   59: ifeq +5 -> 64
    //   62: iconst_0
    //   63: ireturn
    //   64: new 124	java/util/HashMap
    //   67: dup
    //   68: invokespecial 126	java/util/HashMap:<init>	()V
    //   71: astore_1
    //   72: aload_1
    //   73: checkcast 128	java/util/Map
    //   76: ldc 130
    //   78: ldc 132
    //   80: invokeinterface 136 3 0
    //   85: pop
    //   86: aload_0
    //   87: aload_1
    //   88: invokevirtual 140	com/tencent/qapmsdk/base/reporter/authorization/Authorization:connectionBuilder	(Ljava/util/HashMap;)Ljava/net/HttpURLConnection;
    //   91: astore 10
    //   93: iload 6
    //   95: istore_3
    //   96: aload 10
    //   98: ifnull +476 -> 574
    //   101: getstatic 144	com/tencent/qapmsdk/base/meta/BaseInfo:pubJson	Lorg/json/JSONObject;
    //   104: astore_1
    //   105: new 146	java/lang/StringBuffer
    //   108: dup
    //   109: sipush 1024
    //   112: invokespecial 149	java/lang/StringBuffer:<init>	(I)V
    //   115: astore 8
    //   117: aload_1
    //   118: invokevirtual 155	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   121: astore 9
    //   123: aload 9
    //   125: ldc 157
    //   127: invokestatic 122	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   130: aload 9
    //   132: invokeinterface 163 1 0
    //   137: ifeq +59 -> 196
    //   140: aload 9
    //   142: invokeinterface 167 1 0
    //   147: checkcast 169	java/lang/String
    //   150: astore 11
    //   152: aload 8
    //   154: ldc 171
    //   156: invokevirtual 175	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   159: pop
    //   160: aload 8
    //   162: aload 11
    //   164: invokevirtual 175	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   167: pop
    //   168: aload 8
    //   170: ldc 177
    //   172: invokevirtual 175	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   175: pop
    //   176: aload 8
    //   178: aload_1
    //   179: aload 11
    //   181: invokevirtual 180	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   184: ldc 182
    //   186: invokestatic 187	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   189: invokevirtual 175	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   192: pop
    //   193: goto -63 -> 130
    //   196: aload 8
    //   198: checkcast 85	java/lang/CharSequence
    //   201: invokeinterface 89 1 0
    //   206: ifne +382 -> 588
    //   209: iconst_1
    //   210: istore_2
    //   211: goto +3 -> 214
    //   214: iload_2
    //   215: ifeq +13 -> 228
    //   218: aload 8
    //   220: invokevirtual 188	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   223: astore 8
    //   225: goto +16 -> 241
    //   228: aload 8
    //   230: iconst_1
    //   231: aload 8
    //   233: invokevirtual 189	java/lang/StringBuffer:length	()I
    //   236: invokevirtual 193	java/lang/StringBuffer:substring	(II)Ljava/lang/String;
    //   239: astore 8
    //   241: new 195	java/io/DataOutputStream
    //   244: dup
    //   245: aload 10
    //   247: invokevirtual 201	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   250: invokespecial 204	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   253: checkcast 206	java/io/Closeable
    //   256: astore 11
    //   258: aconst_null
    //   259: checkcast 97	java/lang/Throwable
    //   262: astore 9
    //   264: aload 9
    //   266: astore_1
    //   267: aload 11
    //   269: checkcast 195	java/io/DataOutputStream
    //   272: astore 12
    //   274: aload 9
    //   276: astore_1
    //   277: aload 8
    //   279: ldc 208
    //   281: invokestatic 122	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   284: aload 9
    //   286: astore_1
    //   287: getstatic 214	kotlin/text/Charsets:UTF_8	Ljava/nio/charset/Charset;
    //   290: astore 13
    //   292: aload 8
    //   294: ifnull +196 -> 490
    //   297: aload 9
    //   299: astore_1
    //   300: aload 8
    //   302: aload 13
    //   304: invokevirtual 218	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   307: astore 8
    //   309: aload 9
    //   311: astore_1
    //   312: aload 8
    //   314: ldc 220
    //   316: invokestatic 122	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   319: aload 9
    //   321: astore_1
    //   322: aload 12
    //   324: aload 8
    //   326: invokevirtual 224	java/io/DataOutputStream:write	([B)V
    //   329: aload 9
    //   331: astore_1
    //   332: aload 12
    //   334: invokevirtual 227	java/io/DataOutputStream:flush	()V
    //   337: aload 9
    //   339: astore_1
    //   340: getstatic 232	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   343: astore 8
    //   345: aload 11
    //   347: aload 9
    //   349: invokestatic 238	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   352: iload 6
    //   354: istore_3
    //   355: aload 10
    //   357: invokevirtual 241	java/net/HttpURLConnection:getResponseCode	()I
    //   360: sipush 200
    //   363: if_icmpne +211 -> 574
    //   366: new 151	org/json/JSONObject
    //   369: dup
    //   370: getstatic 246	com/tencent/qapmsdk/common/util/FileUtil:Companion	Lcom/tencent/qapmsdk/common/util/FileUtil$Companion;
    //   373: new 248	java/io/BufferedInputStream
    //   376: dup
    //   377: aload 10
    //   379: invokevirtual 252	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   382: invokespecial 255	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   385: checkcast 257	java/io/InputStream
    //   388: sipush 8192
    //   391: invokevirtual 263	com/tencent/qapmsdk/common/util/FileUtil$Companion:readStream	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   394: invokespecial 265	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   397: ldc 75
    //   399: invokevirtual 180	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   402: astore_1
    //   403: aload_1
    //   404: ldc_w 267
    //   407: invokestatic 122	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   410: aload_1
    //   411: putstatic 83	com/tencent/qapmsdk/base/meta/BaseInfo:token	Ljava/lang/String;
    //   414: getstatic 95	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   417: astore_1
    //   418: new 269	java/lang/StringBuilder
    //   421: dup
    //   422: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   425: astore 8
    //   427: aload 8
    //   429: ldc_w 272
    //   432: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload 8
    //   438: aload_0
    //   439: invokevirtual 112	com/tencent/qapmsdk/base/reporter/authorization/Authorization:getUrl	()Ljava/net/URL;
    //   442: invokevirtual 278	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: aload 8
    //   448: ldc_w 280
    //   451: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: pop
    //   455: aload 8
    //   457: getstatic 83	com/tencent/qapmsdk/base/meta/BaseInfo:token	Ljava/lang/String;
    //   460: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: pop
    //   464: aload_1
    //   465: iconst_2
    //   466: anewarray 169	java/lang/String
    //   469: dup
    //   470: iconst_0
    //   471: ldc 40
    //   473: aastore
    //   474: dup
    //   475: iconst_1
    //   476: aload 8
    //   478: invokevirtual 281	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: aastore
    //   482: invokevirtual 285	com/tencent/qapmsdk/common/logger/Logger:i	([Ljava/lang/String;)V
    //   485: iconst_1
    //   486: istore_3
    //   487: goto +87 -> 574
    //   490: aload 9
    //   492: astore_1
    //   493: new 287	kotlin/TypeCastException
    //   496: dup
    //   497: ldc_w 289
    //   500: invokespecial 290	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   503: athrow
    //   504: astore 8
    //   506: goto +11 -> 517
    //   509: astore 8
    //   511: aload 8
    //   513: astore_1
    //   514: aload 8
    //   516: athrow
    //   517: aload 11
    //   519: aload_1
    //   520: invokestatic 238	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   523: aload 8
    //   525: athrow
    //   526: astore_1
    //   527: goto +35 -> 562
    //   530: astore_1
    //   531: getstatic 95	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   534: ldc 40
    //   536: aload_1
    //   537: checkcast 97	java/lang/Throwable
    //   540: invokevirtual 101	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   543: iload 7
    //   545: istore 4
    //   547: aload 10
    //   549: ifnull +36 -> 585
    //   552: iload 5
    //   554: istore_3
    //   555: aload 10
    //   557: invokevirtual 293	java/net/HttpURLConnection:disconnect	()V
    //   560: iload_3
    //   561: ireturn
    //   562: aload 10
    //   564: ifnull +8 -> 572
    //   567: aload 10
    //   569: invokevirtual 293	java/net/HttpURLConnection:disconnect	()V
    //   572: aload_1
    //   573: athrow
    //   574: iload_3
    //   575: istore 4
    //   577: aload 10
    //   579: ifnull +6 -> 585
    //   582: goto -27 -> 555
    //   585: iload 4
    //   587: ireturn
    //   588: iconst_0
    //   589: istore_2
    //   590: goto -376 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	593	0	this	Authorization
    //   0	593	1	paramString	String
    //   52	538	2	i	int
    //   7	568	3	bool1	boolean
    //   19	567	4	bool2	boolean
    //   15	538	5	bool3	boolean
    //   9	344	6	bool4	boolean
    //   12	532	7	bool5	boolean
    //   115	362	8	localObject1	Object
    //   504	1	8	localObject2	Object
    //   509	15	8	localThrowable	Throwable
    //   121	370	9	localObject3	Object
    //   91	487	10	localHttpURLConnection	java.net.HttpURLConnection
    //   150	368	11	localObject4	Object
    //   272	61	12	localDataOutputStream	java.io.DataOutputStream
    //   290	13	13	localCharset	java.nio.charset.Charset
    // Exception table:
    //   from	to	target	type
    //   267	274	504	finally
    //   277	284	504	finally
    //   287	292	504	finally
    //   300	309	504	finally
    //   312	319	504	finally
    //   322	329	504	finally
    //   332	337	504	finally
    //   340	345	504	finally
    //   493	504	504	finally
    //   514	517	504	finally
    //   267	274	509	java/lang/Throwable
    //   277	284	509	java/lang/Throwable
    //   287	292	509	java/lang/Throwable
    //   300	309	509	java/lang/Throwable
    //   312	319	509	java/lang/Throwable
    //   322	329	509	java/lang/Throwable
    //   332	337	509	java/lang/Throwable
    //   340	345	509	java/lang/Throwable
    //   493	504	509	java/lang/Throwable
    //   101	130	526	finally
    //   130	193	526	finally
    //   196	209	526	finally
    //   218	225	526	finally
    //   228	241	526	finally
    //   241	264	526	finally
    //   345	352	526	finally
    //   355	485	526	finally
    //   517	526	526	finally
    //   531	543	526	finally
    //   101	130	530	java/lang/Exception
    //   130	193	530	java/lang/Exception
    //   196	209	530	java/lang/Exception
    //   218	225	530	java/lang/Exception
    //   228	241	530	java/lang/Exception
    //   241	264	530	java/lang/Exception
    //   345	352	530	java/lang/Exception
    //   355	485	530	java/lang/Exception
    //   517	526	530	java/lang/Exception
  }
  
  private final void writeTokenToLocal(String paramString)
  {
    if (BaseInfo.sharePreference != null) {
      BaseInfo.editor.putString("token", paramString).apply();
    }
  }
  
  @NotNull
  public final String getAppKey()
  {
    return this.appKey;
  }
  
  public final boolean getToken(@NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appKey");
    if (!readTokenFromLocal(paramBoolean)) {
      try
      {
        if (!readTokenFromServer(paramString)) {
          return false;
        }
        writeTokenToLocal(BaseInfo.token);
      }
      catch (Exception paramString)
      {
        Logger.INSTANCE.exception("QAPM_base_Authorization", (Throwable)paramString);
        return false;
      }
    }
    return true;
  }
  
  public void request()
  {
    getToken(this.appKey, true);
  }
  
  public final void setAppKey(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.appKey = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.authorization.Authorization
 * JD-Core Version:    0.7.0.1
 */