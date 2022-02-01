package com.tencent.ttpic.filter.aifilter;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.model.BaseFilterMaterial;
import com.tencent.ttpic.openapi.model.BridgeMaterial;
import com.tencent.ttpic.openapi.model.FilterMaterial;
import com.tencent.ttpic.openapi.model.FilterParam;
import com.tencent.ttpic.openapi.model.MaterialUtil;
import com.tencent.ttpic.openapi.model.MaterialUtil.FIELD;
import com.tencent.ttpic.util.Coffee;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class FilterChainParser
{
  private static final String POSTFIX_DAT = "dat";
  private static final String POSTFIX_JSON = "json";
  private static final String POSTFIX_TXT = "txt";
  private static final String POSTFIX_WMC = "wmc";
  private static final String POSTFIX_XML = "xml";
  public static final String RES_PREFIX_ASSETS = "assets://";
  private static final String TAG = FilterChainParser.class.getSimpleName();
  private static String sSignMD5;
  
  private static String byteArrayToHex(byte[] paramArrayOfByte)
  {
    int i = 0;
    char[] arrayOfChar1 = new char[16];
    char[] tmp10_8 = arrayOfChar1;
    tmp10_8[0] = 48;
    char[] tmp15_10 = tmp10_8;
    tmp15_10[1] = 49;
    char[] tmp20_15 = tmp15_10;
    tmp20_15[2] = 50;
    char[] tmp25_20 = tmp20_15;
    tmp25_20[3] = 51;
    char[] tmp30_25 = tmp25_20;
    tmp30_25[4] = 52;
    char[] tmp35_30 = tmp30_25;
    tmp35_30[5] = 53;
    char[] tmp40_35 = tmp35_30;
    tmp40_35[6] = 54;
    char[] tmp46_40 = tmp40_35;
    tmp46_40[7] = 55;
    char[] tmp52_46 = tmp46_40;
    tmp52_46[8] = 56;
    char[] tmp58_52 = tmp52_46;
    tmp58_52[9] = 57;
    char[] tmp64_58 = tmp58_52;
    tmp64_58[10] = 65;
    char[] tmp70_64 = tmp64_58;
    tmp70_64[11] = 66;
    char[] tmp76_70 = tmp70_64;
    tmp76_70[12] = 67;
    char[] tmp82_76 = tmp76_70;
    tmp82_76[13] = 68;
    char[] tmp88_82 = tmp82_76;
    tmp88_82[14] = 69;
    char[] tmp94_88 = tmp88_82;
    tmp94_88[15] = 70;
    tmp94_88;
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int k = paramArrayOfByte.length;
    int j = 0;
    while (i < k)
    {
      int m = paramArrayOfByte[i];
      int n = j + 1;
      arrayOfChar2[j] = arrayOfChar1[(m >>> 4 & 0xF)];
      j = n + 1;
      arrayOfChar2[n] = arrayOfChar1[(m & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar2);
  }
  
  public static String getRealPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!paramString.startsWith("assets://")) {
      return paramString;
    }
    return paramString.substring("assets://".length());
  }
  
  public static String getSignMD5(Context paramContext)
  {
    if (TextUtils.isEmpty(sSignMD5))
    {
      if (!AEOpenRenderConfig.DEBUG) {
        break label25;
      }
      sSignMD5 = Coffee.getDefaultSign();
    }
    for (;;)
    {
      return sSignMD5;
      try
      {
        label25:
        sSignMD5 = stringMD5(getSignature(paramContext));
      }
      catch (Exception paramContext)
      {
        sSignMD5 = Coffee.getDefaultSign();
      }
    }
  }
  
  private static String getSignature(Context paramContext)
  {
    Iterator localIterator = paramContext.getPackageManager().getInstalledPackages(64).iterator();
    while (localIterator.hasNext())
    {
      PackageInfo localPackageInfo = (PackageInfo)localIterator.next();
      if (localPackageInfo.packageName.equals(paramContext.getPackageName()))
      {
        LogUtils.v(TAG, "getSignature(), signature = %s", new Object[] { localPackageInfo.signatures[0].toCharsString() });
        return localPackageInfo.signatures[0].toCharsString();
      }
    }
    return "";
  }
  
  @NonNull
  private static BaseFilterMaterial parseBaseFilterMaterial(JSONObject paramJSONObject)
  {
    BaseFilterMaterial localBaseFilterMaterial = new BaseFilterMaterial();
    if (paramJSONObject == null) {
      return localBaseFilterMaterial;
    }
    localBaseFilterMaterial.name = paramJSONObject.optString(MaterialUtil.FIELD.ENUM.value);
    localBaseFilterMaterial.index = paramJSONObject.optInt(MaterialUtil.FIELD.INDEX.value);
    localBaseFilterMaterial.params = new ArrayList();
    JSONArray localJSONArray = paramJSONObject.optJSONArray(MaterialUtil.FIELD.PARAM.value);
    if (localJSONArray != null)
    {
      int i = 0;
      while (i < localJSONArray.length())
      {
        paramJSONObject = parseFilterParam(localJSONArray.optJSONObject(i));
        if (MaterialUtil.isValid(paramJSONObject)) {
          localBaseFilterMaterial.params.add(paramJSONObject);
        }
        i += 1;
      }
    }
    paramJSONObject = parseFilterParam(paramJSONObject.optJSONObject(MaterialUtil.FIELD.PARAM.value));
    if (MaterialUtil.isValid(paramJSONObject)) {
      localBaseFilterMaterial.params.add(paramJSONObject);
    }
    return localBaseFilterMaterial;
  }
  
  private static BridgeMaterial parseBridgeMaterial(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    BridgeMaterial localBridgeMaterial = new BridgeMaterial();
    localBridgeMaterial.output = paramJSONObject.optInt(MaterialUtil.FIELD.OUTPUT.value);
    localBridgeMaterial.input = paramJSONObject.optInt(MaterialUtil.FIELD.INPUT.value);
    localBridgeMaterial.index = paramJSONObject.optInt(MaterialUtil.FIELD.INDEX.value);
    return localBridgeMaterial;
  }
  
  public static JSONObject parseFile(String paramString1, String paramString2)
  {
    return parseFileProcess(paramString1, paramString2, false);
  }
  
  /* Error */
  private static JSONObject parseFileProcess(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 264	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   10: aload_0
    //   11: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: ldc_w 271
    //   17: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_1
    //   21: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc_w 273
    //   27: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 8
    //   32: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: astore_3
    //   39: new 264	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   46: aload_0
    //   47: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc_w 271
    //   53: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_1
    //   57: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc_w 273
    //   63: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc 20
    //   68: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: astore 6
    //   76: new 264	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   83: aload_0
    //   84: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc_w 271
    //   90: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_1
    //   94: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc_w 273
    //   100: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc 11
    //   105: invokevirtual 269	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 276	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: astore 7
    //   113: getstatic 35	com/tencent/ttpic/filter/aifilter/FilterChainParser:TAG	Ljava/lang/String;
    //   116: ldc_w 278
    //   119: iconst_1
    //   120: anewarray 4	java/lang/Object
    //   123: dup
    //   124: iconst_0
    //   125: aload_3
    //   126: aastore
    //   127: invokestatic 162	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   130: getstatic 284	com/tencent/ttpic/filter/aifilter/FilterChainParser$FileType:DAT	Lcom/tencent/ttpic/filter/aifilter/FilterChainParser$FileType;
    //   133: astore 4
    //   135: new 286	java/io/File
    //   138: dup
    //   139: aload_3
    //   140: invokespecial 289	java/io/File:<init>	(Ljava/lang/String;)V
    //   143: astore_0
    //   144: new 286	java/io/File
    //   147: dup
    //   148: aload 6
    //   150: invokespecial 289	java/io/File:<init>	(Ljava/lang/String;)V
    //   153: astore_1
    //   154: new 286	java/io/File
    //   157: dup
    //   158: aload 7
    //   160: invokespecial 289	java/io/File:<init>	(Ljava/lang/String;)V
    //   163: astore 8
    //   165: aload_0
    //   166: invokevirtual 292	java/io/File:exists	()Z
    //   169: ifeq +10 -> 179
    //   172: aload_0
    //   173: invokevirtual 295	java/io/File:isFile	()Z
    //   176: ifne +33 -> 209
    //   179: aload_1
    //   180: invokevirtual 292	java/io/File:exists	()Z
    //   183: ifeq +10 -> 193
    //   186: aload_1
    //   187: invokevirtual 295	java/io/File:isFile	()Z
    //   190: ifne +19 -> 209
    //   193: aload 8
    //   195: invokevirtual 292	java/io/File:exists	()Z
    //   198: ifeq +306 -> 504
    //   201: aload 8
    //   203: invokevirtual 295	java/io/File:isFile	()Z
    //   206: ifeq +298 -> 504
    //   209: getstatic 35	com/tencent/ttpic/filter/aifilter/FilterChainParser:TAG	Ljava/lang/String;
    //   212: ldc_w 297
    //   215: invokestatic 300	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: aload_0
    //   219: invokevirtual 292	java/io/File:exists	()Z
    //   222: ifeq +223 -> 445
    //   225: aload_0
    //   226: invokevirtual 295	java/io/File:isFile	()Z
    //   229: ifeq +216 -> 445
    //   232: new 302	java/io/FileInputStream
    //   235: dup
    //   236: aload_0
    //   237: invokespecial 305	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   240: astore_0
    //   241: aload 4
    //   243: astore_3
    //   244: aload_0
    //   245: astore_1
    //   246: aload_3
    //   247: getstatic 284	com/tencent/ttpic/filter/aifilter/FilterChainParser$FileType:DAT	Lcom/tencent/ttpic/filter/aifilter/FilterChainParser$FileType;
    //   250: if_acmpne +246 -> 496
    //   253: aload_0
    //   254: astore_1
    //   255: aload_0
    //   256: iconst_0
    //   257: invokestatic 311	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   260: invokestatic 313	com/tencent/ttpic/filter/aifilter/FilterChainParser:getSignMD5	(Landroid/content/Context;)Ljava/lang/String;
    //   263: invokestatic 317	com/tencent/ttpic/util/Coffee:drinkACupOfCoffee	(Ljava/io/InputStream;ZLjava/lang/String;)Ljava/io/InputStream;
    //   266: astore 4
    //   268: aload_0
    //   269: invokestatic 323	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   272: aload_0
    //   273: astore_1
    //   274: aload 4
    //   276: ifnull +868 -> 1144
    //   279: new 325	java/io/InputStreamReader
    //   282: dup
    //   283: aload 4
    //   285: invokespecial 327	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   288: astore 6
    //   290: new 329	java/io/BufferedReader
    //   293: dup
    //   294: aload 6
    //   296: sipush 1024
    //   299: invokespecial 332	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   302: astore 5
    //   304: aload_1
    //   305: astore 10
    //   307: aload 6
    //   309: astore 9
    //   311: aload 5
    //   313: astore 8
    //   315: aload 4
    //   317: astore 7
    //   319: new 334	java/lang/StringBuffer
    //   322: dup
    //   323: invokespecial 335	java/lang/StringBuffer:<init>	()V
    //   326: astore_0
    //   327: aload_1
    //   328: astore 10
    //   330: aload 6
    //   332: astore 9
    //   334: aload 5
    //   336: astore 8
    //   338: aload 4
    //   340: astore 7
    //   342: aload 5
    //   344: invokevirtual 338	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   347: astore 11
    //   349: aload 11
    //   351: ifnull +282 -> 633
    //   354: aload_1
    //   355: astore 10
    //   357: aload 6
    //   359: astore 9
    //   361: aload 5
    //   363: astore 8
    //   365: aload 4
    //   367: astore 7
    //   369: aload_0
    //   370: aload 11
    //   372: invokevirtual 341	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   375: pop
    //   376: goto -49 -> 327
    //   379: astore_3
    //   380: aload 5
    //   382: astore_0
    //   383: aload 6
    //   385: astore 5
    //   387: aload_1
    //   388: astore 10
    //   390: aload 5
    //   392: astore 9
    //   394: aload_0
    //   395: astore 8
    //   397: aload 4
    //   399: astore 7
    //   401: aload_3
    //   402: invokestatic 345	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   405: aload_0
    //   406: ifnull +7 -> 413
    //   409: aload_0
    //   410: invokevirtual 348	java/io/BufferedReader:close	()V
    //   413: aload 5
    //   415: ifnull +8 -> 423
    //   418: aload 5
    //   420: invokevirtual 349	java/io/InputStreamReader:close	()V
    //   423: aload 4
    //   425: ifnull +8 -> 433
    //   428: aload 4
    //   430: invokevirtual 352	java/io/InputStream:close	()V
    //   433: aload_1
    //   434: ifnull +7 -> 441
    //   437: aload_1
    //   438: invokevirtual 353	java/io/FileInputStream:close	()V
    //   441: aconst_null
    //   442: astore_3
    //   443: aload_3
    //   444: areturn
    //   445: aload_1
    //   446: invokevirtual 292	java/io/File:exists	()Z
    //   449: ifeq +28 -> 477
    //   452: aload_1
    //   453: invokevirtual 295	java/io/File:isFile	()Z
    //   456: ifeq +21 -> 477
    //   459: new 302	java/io/FileInputStream
    //   462: dup
    //   463: aload_1
    //   464: invokespecial 305	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   467: astore_0
    //   468: aload_0
    //   469: astore_1
    //   470: getstatic 356	com/tencent/ttpic/filter/aifilter/FilterChainParser$FileType:XML	Lcom/tencent/ttpic/filter/aifilter/FilterChainParser$FileType;
    //   473: astore_3
    //   474: goto -230 -> 244
    //   477: new 302	java/io/FileInputStream
    //   480: dup
    //   481: aload 8
    //   483: invokespecial 305	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   486: astore_0
    //   487: aload_0
    //   488: astore_1
    //   489: getstatic 359	com/tencent/ttpic/filter/aifilter/FilterChainParser$FileType:JSON	Lcom/tencent/ttpic/filter/aifilter/FilterChainParser$FileType;
    //   492: astore_3
    //   493: goto -249 -> 244
    //   496: aload_0
    //   497: astore 4
    //   499: aload_0
    //   500: astore_1
    //   501: goto -227 -> 274
    //   504: getstatic 35	com/tencent/ttpic/filter/aifilter/FilterChainParser:TAG	Ljava/lang/String;
    //   507: ldc_w 361
    //   510: invokestatic 300	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   513: invokestatic 311	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   516: invokevirtual 365	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   519: aload_3
    //   520: invokevirtual 371	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   523: astore 8
    //   525: aload 8
    //   527: iconst_0
    //   528: invokestatic 311	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   531: invokestatic 313	com/tencent/ttpic/filter/aifilter/FilterChainParser:getSignMD5	(Landroid/content/Context;)Ljava/lang/String;
    //   534: invokestatic 317	com/tencent/ttpic/util/Coffee:drinkACupOfCoffee	(Ljava/io/InputStream;ZLjava/lang/String;)Ljava/io/InputStream;
    //   537: astore_3
    //   538: aload_3
    //   539: astore_0
    //   540: aload_3
    //   541: astore_1
    //   542: aload 8
    //   544: invokestatic 323	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   547: aload_3
    //   548: astore_0
    //   549: aload 4
    //   551: astore_3
    //   552: aconst_null
    //   553: astore_1
    //   554: aload_0
    //   555: astore 4
    //   557: goto -283 -> 274
    //   560: astore_0
    //   561: aconst_null
    //   562: astore_1
    //   563: aload_1
    //   564: astore_3
    //   565: aload_1
    //   566: astore_0
    //   567: invokestatic 311	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   570: invokevirtual 365	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   573: aload 6
    //   575: invokevirtual 371	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   578: astore 4
    //   580: aload 4
    //   582: astore_3
    //   583: aload 4
    //   585: astore_0
    //   586: aload 4
    //   588: astore_1
    //   589: getstatic 356	com/tencent/ttpic/filter/aifilter/FilterChainParser$FileType:XML	Lcom/tencent/ttpic/filter/aifilter/FilterChainParser$FileType;
    //   592: astore 6
    //   594: aload 6
    //   596: astore_3
    //   597: aconst_null
    //   598: astore_1
    //   599: goto -325 -> 274
    //   602: astore_0
    //   603: aload_3
    //   604: astore_0
    //   605: aload_3
    //   606: astore_1
    //   607: invokestatic 311	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   610: invokevirtual 365	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   613: aload 7
    //   615: invokevirtual 371	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   618: astore_3
    //   619: getstatic 359	com/tencent/ttpic/filter/aifilter/FilterChainParser$FileType:JSON	Lcom/tencent/ttpic/filter/aifilter/FilterChainParser$FileType;
    //   622: astore_0
    //   623: aload_3
    //   624: astore 4
    //   626: aconst_null
    //   627: astore_1
    //   628: aload_0
    //   629: astore_3
    //   630: goto -356 -> 274
    //   633: aload_1
    //   634: astore 10
    //   636: aload 6
    //   638: astore 9
    //   640: aload 5
    //   642: astore 8
    //   644: aload 4
    //   646: astore 7
    //   648: aload_3
    //   649: getstatic 356	com/tencent/ttpic/filter/aifilter/FilterChainParser$FileType:XML	Lcom/tencent/ttpic/filter/aifilter/FilterChainParser$FileType;
    //   652: if_acmpne +159 -> 811
    //   655: aload_1
    //   656: astore 10
    //   658: aload 6
    //   660: astore 9
    //   662: aload 5
    //   664: astore 8
    //   666: aload 4
    //   668: astore 7
    //   670: new 373	fr/arnaudguyon/xmltojsonlib/XmlToJson$Builder
    //   673: dup
    //   674: aload_0
    //   675: invokevirtual 374	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   678: invokespecial 375	fr/arnaudguyon/xmltojsonlib/XmlToJson$Builder:<init>	(Ljava/lang/String;)V
    //   681: invokevirtual 379	fr/arnaudguyon/xmltojsonlib/XmlToJson$Builder:build	()Lfr/arnaudguyon/xmltojsonlib/XmlToJson;
    //   684: invokevirtual 382	fr/arnaudguyon/xmltojsonlib/XmlToJson:toString	()Ljava/lang/String;
    //   687: astore_0
    //   688: aload_1
    //   689: astore 10
    //   691: aload 6
    //   693: astore 9
    //   695: aload 5
    //   697: astore 8
    //   699: aload 4
    //   701: astore 7
    //   703: getstatic 35	com/tencent/ttpic/filter/aifilter/FilterChainParser:TAG	Ljava/lang/String;
    //   706: aload_0
    //   707: invokestatic 385	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   710: aload_1
    //   711: astore 10
    //   713: aload 6
    //   715: astore 9
    //   717: aload 5
    //   719: astore 8
    //   721: aload 4
    //   723: astore 7
    //   725: aload_0
    //   726: invokestatic 70	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   729: ifne +410 -> 1139
    //   732: aload_1
    //   733: astore 10
    //   735: aload 6
    //   737: astore 9
    //   739: aload 5
    //   741: astore 8
    //   743: aload 4
    //   745: astore 7
    //   747: new 387	org/json/JSONTokener
    //   750: dup
    //   751: aload_0
    //   752: invokespecial 388	org/json/JSONTokener:<init>	(Ljava/lang/String;)V
    //   755: invokevirtual 391	org/json/JSONTokener:nextValue	()Ljava/lang/Object;
    //   758: checkcast 181	org/json/JSONObject
    //   761: astore_0
    //   762: aload 5
    //   764: ifnull +8 -> 772
    //   767: aload 5
    //   769: invokevirtual 348	java/io/BufferedReader:close	()V
    //   772: aload 6
    //   774: ifnull +8 -> 782
    //   777: aload 6
    //   779: invokevirtual 349	java/io/InputStreamReader:close	()V
    //   782: aload 4
    //   784: ifnull +8 -> 792
    //   787: aload 4
    //   789: invokevirtual 352	java/io/InputStream:close	()V
    //   792: aload_0
    //   793: astore_3
    //   794: aload_1
    //   795: ifnull -352 -> 443
    //   798: aload_1
    //   799: invokevirtual 353	java/io/FileInputStream:close	()V
    //   802: aload_0
    //   803: areturn
    //   804: astore_1
    //   805: aload_1
    //   806: invokestatic 345	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   809: aload_0
    //   810: areturn
    //   811: aload_1
    //   812: astore 10
    //   814: aload 6
    //   816: astore 9
    //   818: aload 5
    //   820: astore 8
    //   822: aload 4
    //   824: astore 7
    //   826: aload_0
    //   827: invokevirtual 374	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   830: astore_0
    //   831: goto -143 -> 688
    //   834: astore_0
    //   835: aload_0
    //   836: invokestatic 345	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   839: aconst_null
    //   840: areturn
    //   841: astore_0
    //   842: aconst_null
    //   843: astore_1
    //   844: aconst_null
    //   845: astore_3
    //   846: aconst_null
    //   847: astore 4
    //   849: aload_3
    //   850: ifnull +7 -> 857
    //   853: aload_3
    //   854: invokevirtual 348	java/io/BufferedReader:close	()V
    //   857: aload_1
    //   858: ifnull +7 -> 865
    //   861: aload_1
    //   862: invokevirtual 349	java/io/InputStreamReader:close	()V
    //   865: aload 4
    //   867: ifnull +8 -> 875
    //   870: aload 4
    //   872: invokevirtual 352	java/io/InputStream:close	()V
    //   875: aload 5
    //   877: ifnull +8 -> 885
    //   880: aload 5
    //   882: invokevirtual 353	java/io/FileInputStream:close	()V
    //   885: aload_0
    //   886: athrow
    //   887: astore_1
    //   888: aload_1
    //   889: invokestatic 345	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   892: goto -7 -> 885
    //   895: astore 6
    //   897: aconst_null
    //   898: astore_1
    //   899: aconst_null
    //   900: astore_3
    //   901: aconst_null
    //   902: astore 4
    //   904: aload_0
    //   905: astore 5
    //   907: aload 6
    //   909: astore_0
    //   910: goto -61 -> 849
    //   913: astore 6
    //   915: aconst_null
    //   916: astore_1
    //   917: aconst_null
    //   918: astore_3
    //   919: aconst_null
    //   920: astore 4
    //   922: aload_0
    //   923: astore 5
    //   925: aload 6
    //   927: astore_0
    //   928: goto -79 -> 849
    //   931: astore 6
    //   933: aconst_null
    //   934: astore_1
    //   935: aconst_null
    //   936: astore_3
    //   937: aconst_null
    //   938: astore 4
    //   940: aload_0
    //   941: astore 5
    //   943: aload 6
    //   945: astore_0
    //   946: goto -97 -> 849
    //   949: astore 6
    //   951: aconst_null
    //   952: astore_3
    //   953: aconst_null
    //   954: astore_1
    //   955: aload_0
    //   956: astore 5
    //   958: aload 6
    //   960: astore_0
    //   961: goto -112 -> 849
    //   964: astore 6
    //   966: aconst_null
    //   967: astore_1
    //   968: aconst_null
    //   969: astore_3
    //   970: aload_0
    //   971: astore 4
    //   973: aload 6
    //   975: astore_0
    //   976: goto -127 -> 849
    //   979: astore_0
    //   980: aconst_null
    //   981: astore_1
    //   982: aconst_null
    //   983: astore 6
    //   985: aload_3
    //   986: astore 4
    //   988: aload 6
    //   990: astore_3
    //   991: goto -142 -> 849
    //   994: astore_0
    //   995: aconst_null
    //   996: astore 6
    //   998: aconst_null
    //   999: astore_3
    //   1000: aload_1
    //   1001: astore 5
    //   1003: aload 6
    //   1005: astore_1
    //   1006: goto -157 -> 849
    //   1009: astore_0
    //   1010: aconst_null
    //   1011: astore_3
    //   1012: aload_1
    //   1013: astore 5
    //   1015: aload 6
    //   1017: astore_1
    //   1018: goto -169 -> 849
    //   1021: astore_0
    //   1022: aload 10
    //   1024: astore 5
    //   1026: aload 9
    //   1028: astore_1
    //   1029: aload 8
    //   1031: astore_3
    //   1032: aload 7
    //   1034: astore 4
    //   1036: goto -187 -> 849
    //   1039: astore_3
    //   1040: aconst_null
    //   1041: astore_1
    //   1042: aconst_null
    //   1043: astore 5
    //   1045: aconst_null
    //   1046: astore_0
    //   1047: aconst_null
    //   1048: astore 4
    //   1050: goto -663 -> 387
    //   1053: astore_3
    //   1054: aconst_null
    //   1055: astore 5
    //   1057: aconst_null
    //   1058: astore_0
    //   1059: aconst_null
    //   1060: astore 4
    //   1062: goto -675 -> 387
    //   1065: astore_3
    //   1066: aconst_null
    //   1067: astore 6
    //   1069: aconst_null
    //   1070: astore 5
    //   1072: aload_0
    //   1073: astore_1
    //   1074: aload 6
    //   1076: astore_0
    //   1077: goto -690 -> 387
    //   1080: astore_3
    //   1081: aconst_null
    //   1082: astore 5
    //   1084: aconst_null
    //   1085: astore_0
    //   1086: aload_1
    //   1087: astore 4
    //   1089: aconst_null
    //   1090: astore_1
    //   1091: goto -704 -> 387
    //   1094: astore_1
    //   1095: aconst_null
    //   1096: astore 5
    //   1098: aconst_null
    //   1099: astore_0
    //   1100: aload_3
    //   1101: astore 4
    //   1103: aconst_null
    //   1104: astore 6
    //   1106: aload_1
    //   1107: astore_3
    //   1108: aload 6
    //   1110: astore_1
    //   1111: goto -724 -> 387
    //   1114: astore_3
    //   1115: aconst_null
    //   1116: astore 5
    //   1118: aconst_null
    //   1119: astore_0
    //   1120: goto -733 -> 387
    //   1123: astore_3
    //   1124: aconst_null
    //   1125: astore_0
    //   1126: aload 6
    //   1128: astore 5
    //   1130: goto -743 -> 387
    //   1133: astore_0
    //   1134: aload_3
    //   1135: astore_1
    //   1136: goto -573 -> 563
    //   1139: aconst_null
    //   1140: astore_0
    //   1141: goto -379 -> 762
    //   1144: aconst_null
    //   1145: astore 6
    //   1147: aconst_null
    //   1148: astore 5
    //   1150: aconst_null
    //   1151: astore_0
    //   1152: goto -390 -> 762
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1155	0	paramString1	String
    //   0	1155	1	paramString2	String
    //   0	1155	2	paramBoolean	boolean
    //   38	209	3	localObject1	Object
    //   379	23	3	localException1	Exception
    //   442	590	3	localObject2	Object
    //   1039	1	3	localException2	Exception
    //   1053	1	3	localException3	Exception
    //   1065	1	3	localException4	Exception
    //   1080	21	3	localException5	Exception
    //   1107	1	3	str1	String
    //   1114	1	3	localException6	Exception
    //   1123	12	3	localException7	Exception
    //   133	969	4	localObject3	Object
    //   1	1148	5	localObject4	Object
    //   74	741	6	localObject5	Object
    //   895	13	6	localObject6	Object
    //   913	13	6	localObject7	Object
    //   931	13	6	localObject8	Object
    //   949	10	6	localObject9	Object
    //   964	10	6	localObject10	Object
    //   983	163	6	localObject11	Object
    //   111	922	7	localObject12	Object
    //   163	867	8	localObject13	Object
    //   309	718	9	localObject14	Object
    //   305	718	10	str2	String
    //   347	24	11	str3	String
    // Exception table:
    //   from	to	target	type
    //   319	327	379	java/lang/Exception
    //   342	349	379	java/lang/Exception
    //   369	376	379	java/lang/Exception
    //   648	655	379	java/lang/Exception
    //   670	688	379	java/lang/Exception
    //   703	710	379	java/lang/Exception
    //   725	732	379	java/lang/Exception
    //   747	762	379	java/lang/Exception
    //   826	831	379	java/lang/Exception
    //   513	538	560	java/io/IOException
    //   567	580	602	java/io/IOException
    //   589	594	602	java/io/IOException
    //   767	772	804	java/io/IOException
    //   777	782	804	java/io/IOException
    //   787	792	804	java/io/IOException
    //   798	802	804	java/io/IOException
    //   409	413	834	java/io/IOException
    //   418	423	834	java/io/IOException
    //   428	433	834	java/io/IOException
    //   437	441	834	java/io/IOException
    //   135	179	841	finally
    //   179	193	841	finally
    //   193	209	841	finally
    //   209	241	841	finally
    //   445	468	841	finally
    //   477	487	841	finally
    //   504	513	841	finally
    //   513	538	841	finally
    //   853	857	887	java/io/IOException
    //   861	865	887	java/io/IOException
    //   870	875	887	java/io/IOException
    //   880	885	887	java/io/IOException
    //   470	474	895	finally
    //   489	493	913	finally
    //   246	253	931	finally
    //   255	268	931	finally
    //   268	272	949	finally
    //   542	547	964	finally
    //   567	580	964	finally
    //   589	594	964	finally
    //   607	619	964	finally
    //   619	623	979	finally
    //   279	290	994	finally
    //   290	304	1009	finally
    //   319	327	1021	finally
    //   342	349	1021	finally
    //   369	376	1021	finally
    //   401	405	1021	finally
    //   648	655	1021	finally
    //   670	688	1021	finally
    //   703	710	1021	finally
    //   725	732	1021	finally
    //   747	762	1021	finally
    //   826	831	1021	finally
    //   135	179	1039	java/lang/Exception
    //   179	193	1039	java/lang/Exception
    //   193	209	1039	java/lang/Exception
    //   209	241	1039	java/lang/Exception
    //   445	468	1039	java/lang/Exception
    //   477	487	1039	java/lang/Exception
    //   504	513	1039	java/lang/Exception
    //   513	538	1039	java/lang/Exception
    //   246	253	1053	java/lang/Exception
    //   255	268	1053	java/lang/Exception
    //   470	474	1053	java/lang/Exception
    //   489	493	1053	java/lang/Exception
    //   268	272	1065	java/lang/Exception
    //   542	547	1080	java/lang/Exception
    //   567	580	1080	java/lang/Exception
    //   589	594	1080	java/lang/Exception
    //   607	619	1080	java/lang/Exception
    //   619	623	1094	java/lang/Exception
    //   279	290	1114	java/lang/Exception
    //   290	304	1123	java/lang/Exception
    //   542	547	1133	java/io/IOException
  }
  
  public static FilterMaterial parseFilterMaterial(String paramString1, String paramString2)
  {
    int j = 0;
    Object localObject = parseFile(getRealPath(paramString1), paramString2);
    paramString2 = new FilterMaterial();
    paramString2.path = paramString1;
    if (localObject == null) {
      return paramString2;
    }
    paramString1 = ((JSONObject)localObject).optJSONObject(MaterialUtil.FIELD.FILTER.value);
    if (paramString1 != null)
    {
      paramString2.name = paramString1.optString(MaterialUtil.FIELD.NAME.value);
      paramString2.thumbnail = paramString1.optString(MaterialUtil.FIELD.THUMBNAIL.value);
      paramString2.strength = paramString1.optInt(MaterialUtil.FIELD.STRENGTH.value);
      paramString2.cpuLevel = paramString1.optString(MaterialUtil.FIELD.CPU_LEVEL.value);
      paramString2.type = MaterialUtil.getFilterType(paramString1.optString(MaterialUtil.FIELD.TYPE.value));
      paramString2.baseFilterMaterials = new ArrayList();
      localObject = paramString1.optJSONArray(MaterialUtil.FIELD.BASE_FILTER.value);
      int i;
      if (localObject != null)
      {
        i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          BaseFilterMaterial localBaseFilterMaterial = parseBaseFilterMaterial(((JSONArray)localObject).optJSONObject(i));
          if (MaterialUtil.isValid(localBaseFilterMaterial)) {
            paramString2.baseFilterMaterials.add(localBaseFilterMaterial);
          }
          i += 1;
        }
      }
      localObject = parseBaseFilterMaterial(paramString1.optJSONObject(MaterialUtil.FIELD.BASE_FILTER.value));
      if (MaterialUtil.isValid((BaseFilterMaterial)localObject)) {
        paramString2.baseFilterMaterials.add(localObject);
      }
      localObject = paramString1.optJSONArray(MaterialUtil.FIELD.BRIDGE.value);
      if (localObject != null)
      {
        i = j;
        while (i < ((JSONArray)localObject).length())
        {
          paramString1 = parseBridgeMaterial(((JSONArray)localObject).optJSONObject(i));
          if (paramString1 != null)
          {
            if (paramString2.bridgeMaterialMap.get(Integer.valueOf(paramString1.input)) == null) {
              paramString2.bridgeMaterialMap.put(Integer.valueOf(paramString1.input), new ArrayList());
            }
            ((List)paramString2.bridgeMaterialMap.get(Integer.valueOf(paramString1.input))).add(paramString1);
          }
          i += 1;
        }
      }
      paramString1 = parseBridgeMaterial(paramString1.optJSONObject(MaterialUtil.FIELD.BRIDGE.value));
      if (paramString1 != null)
      {
        if (paramString2.bridgeMaterialMap.get(Integer.valueOf(paramString1.input)) == null) {
          paramString2.bridgeMaterialMap.put(Integer.valueOf(paramString1.input), new ArrayList());
        }
        ((List)paramString2.bridgeMaterialMap.get(Integer.valueOf(paramString1.input))).add(paramString1);
      }
    }
    return paramString2;
  }
  
  @NonNull
  private static FilterParam parseFilterParam(JSONObject paramJSONObject)
  {
    FilterParam localFilterParam = new FilterParam();
    if (paramJSONObject == null) {
      return localFilterParam;
    }
    localFilterParam.name = paramJSONObject.optString(MaterialUtil.FIELD.NAME.value);
    localFilterParam.type = paramJSONObject.optString(MaterialUtil.FIELD.TYPE.value);
    localFilterParam.value = paramJSONObject.optString(MaterialUtil.FIELD.VALUE.value);
    return localFilterParam;
  }
  
  public static String stringMD5(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes());
      paramString = byteArrayToHex(localMessageDigest.digest());
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString) {}
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.aifilter.FilterChainParser
 * JD-Core Version:    0.7.0.1
 */