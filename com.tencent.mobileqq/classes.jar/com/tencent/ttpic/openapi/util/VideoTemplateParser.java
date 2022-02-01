package com.tencent.ttpic.openapi.util;

import android.text.TextUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.model.DoodleItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.model.VideoMaterial.FIELD;
import com.tencent.ttpic.util.DecryptListener;
import com.tencent.ttpic.util.GsonUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class VideoTemplateParser
{
  public static final String DELAYED_TIP = "delayTips";
  public static final String DOUBLE_POUBLE = "isDualPeople";
  public static final String ENABLE_FACE_DETECT = "enableFaceDetect";
  public static final String FACE_DETECT_TYPE = "faceDetectorType";
  public static final int FaceDetector_FaceU = 0;
  public static final int FaceDetector_Ulsee = 1;
  public static final String ITEM_LIST = "itemList";
  public static final String ITEM_TIPS = "itemTips";
  public static final String POSTFIX_DAT = "dat";
  private static final String POSTFIX_JSON = "json";
  private static final String TAG = "VideoTemplateParser";
  public static final DecryptListener decryptListener = new VideoTemplateParser.1();
  
  public static InputStream drinkACupOfCoffee(InputStream paramInputStream, DecryptListener paramDecryptListener)
  {
    byte[] arrayOfByte = IOUtils.toByteArray(paramInputStream);
    paramInputStream = arrayOfByte;
    if (paramDecryptListener != null) {
      paramInputStream = paramDecryptListener.decrypt(arrayOfByte);
    }
    return new ByteArrayInputStream(paramInputStream);
  }
  
  public static VideoMaterial parseDoodleMaterial(VideoMaterial paramVideoMaterial, JsonObject paramJsonObject)
  {
    if (paramJsonObject == null) {
      return paramVideoMaterial;
    }
    try
    {
      paramJsonObject = GsonUtils.optJsonObject(paramJsonObject, "doodleImage");
      if (paramJsonObject != null)
      {
        DoodleItem localDoodleItem = new DoodleItem();
        localDoodleItem.count = GsonUtils.optInt(paramJsonObject, "count");
        localDoodleItem.width = GsonUtils.optInt(paramJsonObject, "width");
        localDoodleItem.height = GsonUtils.optInt(paramJsonObject, "height");
        localDoodleItem.extraTypeWidth = GsonUtils.optInt(paramJsonObject, "extraTypeWidth");
        localDoodleItem.extarTypeHeight = GsonUtils.optInt(paramJsonObject, "extraTypeHeight");
        paramVideoMaterial.setDoodleItem(localDoodleItem);
      }
      return paramVideoMaterial;
    }
    catch (Throwable paramJsonObject)
    {
      for (;;)
      {
        paramJsonObject = paramJsonObject;
      }
    }
    finally {}
    LogUtils.w(TAG, "parseDoodleMaterial");
    return paramVideoMaterial;
    return paramVideoMaterial;
  }
  
  private static HashMap<String, String> parseFaceStyleItemPaths(JsonObject paramJsonObject, String paramString1, String paramString2)
  {
    paramJsonObject = GsonUtils.optJsonObject(paramJsonObject, paramString1);
    paramString1 = new HashMap();
    if (paramJsonObject != null)
    {
      Iterator localIterator = paramJsonObject.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = paramJsonObject.get(str1).toString();
        int i = str2.length();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2);
        localStringBuilder.append(File.separator);
        localStringBuilder.append(str2.substring(1, i - 1));
        paramString1.put(str1, localStringBuilder.toString());
      }
    }
    return paramString1;
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString)
  {
    return parseVideoMaterial(paramString, "params", true, decryptListener);
  }
  
  private static VideoMaterial parseVideoMaterial(String paramString, JsonObject paramJsonObject, DecryptListener paramDecryptListener)
  {
    return parseVideoMaterial(paramString, paramJsonObject, paramDecryptListener, null);
  }
  
  private static VideoMaterial parseVideoMaterial(String paramString, JsonObject paramJsonObject, DecryptListener paramDecryptListener, HashMap<String, Object> paramHashMap)
  {
    return VideoMaterial.loadLightAsset(paramString);
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString, DecryptListener paramDecryptListener)
  {
    return parseVideoMaterial(null, parseVideoMaterialString(paramString, paramDecryptListener), paramDecryptListener);
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString, DecryptListener paramDecryptListener, HashMap<String, Object> paramHashMap)
  {
    return parseVideoMaterial(null, parseVideoMaterialString(paramString, paramDecryptListener), paramDecryptListener, paramHashMap);
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString1, String paramString2, DecryptListener paramDecryptListener)
  {
    return parseVideoMaterial(paramString1, parseVideoMaterialString(paramString2, paramDecryptListener), paramDecryptListener);
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString1, String paramString2, DecryptListener paramDecryptListener, HashMap<String, Object> paramHashMap)
  {
    return parseVideoMaterial(paramString1, parseVideoMaterialString(paramString2, paramDecryptListener), paramDecryptListener, paramHashMap);
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString1, String paramString2, boolean paramBoolean, DecryptListener paramDecryptListener)
  {
    return parseVideoMaterial(paramString1, parseVideoMaterialFileAsJSONObject(paramString1, paramString2, paramBoolean, paramDecryptListener), paramDecryptListener);
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString1, String paramString2, boolean paramBoolean, DecryptListener paramDecryptListener, HashMap<String, Object> paramHashMap)
  {
    return parseVideoMaterial(paramString1, parseVideoMaterialFileAsJSONObject(paramString1, paramString2, paramBoolean, paramDecryptListener), paramDecryptListener, paramHashMap);
  }
  
  public static JsonObject parseVideoMaterialFileAsJSONObject(String paramString1, String paramString2, boolean paramBoolean, DecryptListener paramDecryptListener)
  {
    paramString1 = readMaterialFile(paramString1, paramString2, paramBoolean, paramDecryptListener);
    paramString2 = TAG;
    paramDecryptListener = new StringBuilder();
    paramDecryptListener.append("[parseVideoMaterialFileAsJSONObject] dataStr = ");
    paramDecryptListener.append(paramString1);
    LogUtils.i(paramString2, paramDecryptListener.toString());
    if (!TextUtils.isEmpty(paramString1)) {
      try
      {
        paramString1 = GsonUtils.json2JsonObject(paramString1);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return null;
  }
  
  public static VideoMaterial parseVideoMaterialForEdit(String paramString1, String paramString2, boolean paramBoolean, DecryptListener paramDecryptListener)
  {
    paramString2 = parseVideoMaterialFileAsJSONObject(paramString1, paramString2, paramBoolean, paramDecryptListener);
    paramString1 = parseVideoMaterial(paramString1, paramString2, paramDecryptListener);
    paramString1.setShaderType(GsonUtils.optInt(paramString2, VideoMaterial.FIELD.SHADER_TYPE.value));
    parseDoodleMaterial(paramString1, paramString2);
    return paramString1;
  }
  
  private static JsonObject parseVideoMaterialString(String paramString, DecryptListener paramDecryptListener)
  {
    String str = paramString.trim();
    paramString = str;
    try
    {
      if (str.charAt(0) != '{')
      {
        paramString = new BufferedReader(new InputStreamReader(drinkACupOfCoffee(new ByteArrayInputStream(str.getBytes(Charset.forName("UTF-8"))), paramDecryptListener)), 1024);
        paramDecryptListener = new StringBuilder();
        for (;;)
        {
          str = paramString.readLine();
          if (str == null) {
            break;
          }
          paramDecryptListener.append(str);
        }
        paramString = paramDecryptListener.toString();
      }
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = GsonUtils.json2JsonObject(paramString);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public static String readMaterialFile(String paramString1, String paramString2, boolean paramBoolean, DecryptListener paramDecryptListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 306	com/tencent/ttpic/baseutils/io/FileUtils:getRealPath	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore_0
    //   5: new 170	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   12: astore 4
    //   14: aload 4
    //   16: aload_0
    //   17: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload 4
    //   23: ldc_w 308
    //   26: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 4
    //   32: aload_1
    //   33: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 4
    //   39: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore 4
    //   44: new 170	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   51: astore 5
    //   53: aload 5
    //   55: aload_0
    //   56: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 5
    //   62: ldc_w 308
    //   65: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 5
    //   71: aload_1
    //   72: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 5
    //   78: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: astore 5
    //   83: iload_2
    //   84: ifeq +94 -> 178
    //   87: aload 4
    //   89: astore_0
    //   90: aload 4
    //   92: ldc 34
    //   94: invokevirtual 312	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   97: ifne +31 -> 128
    //   100: new 170	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   107: astore_0
    //   108: aload_0
    //   109: aload 4
    //   111: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_0
    //   116: ldc_w 314
    //   119: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_0
    //   124: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: astore_0
    //   128: aload_0
    //   129: astore 4
    //   131: aload 5
    //   133: astore_1
    //   134: aload 5
    //   136: ldc 31
    //   138: invokevirtual 312	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   141: ifne +125 -> 266
    //   144: new 170	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   151: astore_1
    //   152: aload_1
    //   153: aload 5
    //   155: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload_1
    //   160: ldc_w 316
    //   163: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload_1
    //   168: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: astore_1
    //   172: aload_0
    //   173: astore 4
    //   175: goto +91 -> 266
    //   178: aload 4
    //   180: astore_0
    //   181: aload 4
    //   183: ldc 31
    //   185: invokevirtual 312	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   188: ifne +31 -> 219
    //   191: new 170	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   198: astore_0
    //   199: aload_0
    //   200: aload 4
    //   202: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload_0
    //   207: ldc_w 316
    //   210: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload_0
    //   215: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: astore_0
    //   219: aload_0
    //   220: astore 4
    //   222: aload 5
    //   224: astore_1
    //   225: aload 5
    //   227: ldc 34
    //   229: invokevirtual 312	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   232: ifne +34 -> 266
    //   235: new 170	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   242: astore_1
    //   243: aload_1
    //   244: aload 5
    //   246: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_1
    //   251: ldc_w 314
    //   254: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload_1
    //   259: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: astore_1
    //   263: aload_0
    //   264: astore 4
    //   266: aconst_null
    //   267: astore 7
    //   269: new 177	java/io/File
    //   272: dup
    //   273: aload 4
    //   275: invokespecial 319	java/io/File:<init>	(Ljava/lang/String;)V
    //   278: astore_0
    //   279: new 177	java/io/File
    //   282: dup
    //   283: aload_1
    //   284: invokespecial 319	java/io/File:<init>	(Ljava/lang/String;)V
    //   287: astore 5
    //   289: aload_0
    //   290: invokevirtual 322	java/io/File:exists	()Z
    //   293: ifeq +10 -> 303
    //   296: aload_0
    //   297: invokevirtual 325	java/io/File:isFile	()Z
    //   300: ifne +19 -> 319
    //   303: aload 5
    //   305: invokevirtual 322	java/io/File:exists	()Z
    //   308: ifeq +182 -> 490
    //   311: aload 5
    //   313: invokevirtual 325	java/io/File:isFile	()Z
    //   316: ifeq +174 -> 490
    //   319: aload_0
    //   320: invokevirtual 322	java/io/File:exists	()Z
    //   323: ifeq +22 -> 345
    //   326: aload_0
    //   327: invokevirtual 325	java/io/File:isFile	()Z
    //   330: ifeq +15 -> 345
    //   333: new 327	java/io/FileInputStream
    //   336: dup
    //   337: aload_0
    //   338: invokespecial 330	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   341: astore_1
    //   342: goto +38 -> 380
    //   345: aload 5
    //   347: invokevirtual 322	java/io/File:exists	()Z
    //   350: ifeq +28 -> 378
    //   353: aload 5
    //   355: invokevirtual 325	java/io/File:isFile	()Z
    //   358: ifeq +20 -> 378
    //   361: new 327	java/io/FileInputStream
    //   364: dup
    //   365: aload 5
    //   367: invokespecial 330	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   370: astore_1
    //   371: iload_2
    //   372: iconst_1
    //   373: ixor
    //   374: istore_2
    //   375: goto +5 -> 380
    //   378: aconst_null
    //   379: astore_1
    //   380: iload_2
    //   381: ifne +104 -> 485
    //   384: aload_1
    //   385: aload_3
    //   386: invokestatic 289	com/tencent/ttpic/openapi/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   389: astore_0
    //   390: aload_1
    //   391: invokestatic 333	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   394: aload_1
    //   395: astore_3
    //   396: aload_0
    //   397: astore_1
    //   398: aload_3
    //   399: astore_0
    //   400: goto +266 -> 666
    //   403: astore_3
    //   404: aload_0
    //   405: astore 4
    //   407: aload_1
    //   408: astore_0
    //   409: aload 4
    //   411: astore_1
    //   412: aconst_null
    //   413: astore 4
    //   415: goto +498 -> 913
    //   418: astore 4
    //   420: aload_0
    //   421: astore_3
    //   422: aload_1
    //   423: astore_0
    //   424: aload 4
    //   426: astore_1
    //   427: aconst_null
    //   428: astore 6
    //   430: aload_1
    //   431: astore 5
    //   433: aconst_null
    //   434: astore 4
    //   436: aload 6
    //   438: astore_1
    //   439: goto +408 -> 847
    //   442: astore 5
    //   444: aconst_null
    //   445: astore 4
    //   447: aload 4
    //   449: astore_3
    //   450: aload_1
    //   451: astore_0
    //   452: aload_3
    //   453: astore_1
    //   454: aload 5
    //   456: astore_3
    //   457: goto +456 -> 913
    //   460: astore 6
    //   462: aconst_null
    //   463: astore 4
    //   465: aload 4
    //   467: astore_3
    //   468: aload_3
    //   469: astore 5
    //   471: aload_1
    //   472: astore_0
    //   473: aload_3
    //   474: astore_1
    //   475: aload 5
    //   477: astore_3
    //   478: aload 6
    //   480: astore 5
    //   482: goto +365 -> 847
    //   485: aload_1
    //   486: astore_0
    //   487: goto +179 -> 666
    //   490: invokestatic 339	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   493: invokevirtual 345	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   496: aload 4
    //   498: invokevirtual 351	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   501: astore 6
    //   503: aload 6
    //   505: astore_0
    //   506: iload_2
    //   507: ifne +21 -> 528
    //   510: aload 6
    //   512: aload_3
    //   513: invokestatic 289	com/tencent/ttpic/openapi/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   516: astore_0
    //   517: aload_0
    //   518: astore 5
    //   520: aload_0
    //   521: astore 4
    //   523: aload 6
    //   525: invokestatic 333	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   528: aconst_null
    //   529: astore_3
    //   530: aload_0
    //   531: astore_1
    //   532: aload_3
    //   533: astore_0
    //   534: goto +132 -> 666
    //   537: aconst_null
    //   538: astore_0
    //   539: aload_0
    //   540: astore 5
    //   542: aload_0
    //   543: astore 4
    //   545: invokestatic 339	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   548: invokevirtual 345	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   551: aload_1
    //   552: invokevirtual 351	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   555: astore 6
    //   557: aload 6
    //   559: astore_1
    //   560: iload_2
    //   561: iconst_1
    //   562: ixor
    //   563: ifne +60 -> 623
    //   566: aload_0
    //   567: astore 5
    //   569: aload_0
    //   570: astore 4
    //   572: aload 6
    //   574: aload_3
    //   575: invokestatic 289	com/tencent/ttpic/openapi/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   578: astore_1
    //   579: aload 6
    //   581: invokestatic 333	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   584: goto +39 -> 623
    //   587: astore_3
    //   588: aconst_null
    //   589: astore 4
    //   591: aload 4
    //   593: astore_0
    //   594: goto +319 -> 913
    //   597: astore 5
    //   599: aconst_null
    //   600: astore 4
    //   602: aload 4
    //   604: astore_0
    //   605: aload_1
    //   606: astore_3
    //   607: aload_0
    //   608: astore 6
    //   610: aload_0
    //   611: astore_1
    //   612: aload 6
    //   614: astore_0
    //   615: goto +232 -> 847
    //   618: aload_1
    //   619: astore_0
    //   620: goto +40 -> 660
    //   623: aconst_null
    //   624: astore_0
    //   625: goto +41 -> 666
    //   628: astore_3
    //   629: aconst_null
    //   630: astore_0
    //   631: aload_0
    //   632: astore 4
    //   634: aload 5
    //   636: astore_1
    //   637: goto +276 -> 913
    //   640: astore 5
    //   642: aconst_null
    //   643: astore_0
    //   644: aload_0
    //   645: astore 6
    //   647: aload 6
    //   649: astore_1
    //   650: aload 4
    //   652: astore_3
    //   653: aload 6
    //   655: astore 4
    //   657: goto +190 -> 847
    //   660: aconst_null
    //   661: astore_3
    //   662: aload_0
    //   663: astore_1
    //   664: aload_3
    //   665: astore_0
    //   666: aload_1
    //   667: ifnull +139 -> 806
    //   670: new 275	java/io/InputStreamReader
    //   673: dup
    //   674: aload_1
    //   675: invokespecial 292	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   678: astore 4
    //   680: new 273	java/io/BufferedReader
    //   683: dup
    //   684: aload 4
    //   686: sipush 1024
    //   689: invokespecial 295	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   692: astore_3
    //   693: new 170	java/lang/StringBuilder
    //   696: dup
    //   697: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   700: astore 5
    //   702: aload_3
    //   703: invokevirtual 298	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   706: astore 6
    //   708: aload 6
    //   710: ifnull +14 -> 724
    //   713: aload 5
    //   715: aload 6
    //   717: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: pop
    //   721: goto -19 -> 702
    //   724: aload 5
    //   726: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   729: astore 5
    //   731: aload_3
    //   732: invokevirtual 354	java/io/BufferedReader:close	()V
    //   735: aload 4
    //   737: invokevirtual 355	java/io/InputStreamReader:close	()V
    //   740: aload_1
    //   741: ifnull +7 -> 748
    //   744: aload_1
    //   745: invokevirtual 358	java/io/InputStream:close	()V
    //   748: aload_0
    //   749: ifnull +7 -> 756
    //   752: aload_0
    //   753: invokevirtual 359	java/io/FileInputStream:close	()V
    //   756: aload 5
    //   758: areturn
    //   759: astore 6
    //   761: aload_1
    //   762: astore 5
    //   764: aload_3
    //   765: astore_1
    //   766: goto +138 -> 904
    //   769: astore 6
    //   771: aload_1
    //   772: astore 5
    //   774: aload_3
    //   775: astore_1
    //   776: goto -301 -> 475
    //   779: astore_3
    //   780: goto +133 -> 913
    //   783: astore 5
    //   785: aload_1
    //   786: astore_3
    //   787: aconst_null
    //   788: astore_1
    //   789: goto +58 -> 847
    //   792: astore_3
    //   793: goto -381 -> 412
    //   796: astore 4
    //   798: aload_1
    //   799: astore_3
    //   800: aload 4
    //   802: astore_1
    //   803: goto -376 -> 427
    //   806: aload_1
    //   807: ifnull +178 -> 985
    //   810: aload_1
    //   811: invokevirtual 358	java/io/InputStream:close	()V
    //   814: goto +171 -> 985
    //   817: aload_0
    //   818: invokevirtual 359	java/io/FileInputStream:close	()V
    //   821: aconst_null
    //   822: areturn
    //   823: astore_3
    //   824: aconst_null
    //   825: astore_0
    //   826: aload_0
    //   827: astore 4
    //   829: aload 4
    //   831: astore_1
    //   832: goto +81 -> 913
    //   835: astore 5
    //   837: aconst_null
    //   838: astore_0
    //   839: aload_0
    //   840: astore 4
    //   842: aload 4
    //   844: astore_1
    //   845: aload_1
    //   846: astore_3
    //   847: getstatic 54	com/tencent/ttpic/openapi/util/VideoTemplateParser:TAG	Ljava/lang/String;
    //   850: aload 5
    //   852: invokevirtual 362	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   855: aload 5
    //   857: iconst_0
    //   858: anewarray 4	java/lang/Object
    //   861: invokestatic 366	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   864: aload_1
    //   865: ifnull +7 -> 872
    //   868: aload_1
    //   869: invokevirtual 354	java/io/BufferedReader:close	()V
    //   872: aload 4
    //   874: ifnull +8 -> 882
    //   877: aload 4
    //   879: invokevirtual 355	java/io/InputStreamReader:close	()V
    //   882: aload_3
    //   883: ifnull +7 -> 890
    //   886: aload_3
    //   887: invokevirtual 358	java/io/InputStream:close	()V
    //   890: aload_0
    //   891: ifnull +6 -> 897
    //   894: goto -77 -> 817
    //   897: aconst_null
    //   898: areturn
    //   899: astore 6
    //   901: aload_3
    //   902: astore 5
    //   904: aload_1
    //   905: astore 7
    //   907: aload 6
    //   909: astore_3
    //   910: aload 5
    //   912: astore_1
    //   913: aload 7
    //   915: ifnull +8 -> 923
    //   918: aload 7
    //   920: invokevirtual 354	java/io/BufferedReader:close	()V
    //   923: aload 4
    //   925: ifnull +8 -> 933
    //   928: aload 4
    //   930: invokevirtual 355	java/io/InputStreamReader:close	()V
    //   933: aload_1
    //   934: ifnull +7 -> 941
    //   937: aload_1
    //   938: invokevirtual 358	java/io/InputStream:close	()V
    //   941: aload_0
    //   942: ifnull +7 -> 949
    //   945: aload_0
    //   946: invokevirtual 359	java/io/FileInputStream:close	()V
    //   949: goto +5 -> 954
    //   952: aload_3
    //   953: athrow
    //   954: goto -2 -> 952
    //   957: astore_0
    //   958: goto -421 -> 537
    //   961: astore 4
    //   963: goto -424 -> 539
    //   966: astore_1
    //   967: goto -307 -> 660
    //   970: astore_0
    //   971: goto -353 -> 618
    //   974: astore_0
    //   975: aload 5
    //   977: areturn
    //   978: astore_0
    //   979: aconst_null
    //   980: areturn
    //   981: astore_0
    //   982: goto -33 -> 949
    //   985: aload_0
    //   986: ifnull -89 -> 897
    //   989: goto -172 -> 817
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	992	0	paramString1	String
    //   0	992	1	paramString2	String
    //   0	992	2	paramBoolean	boolean
    //   0	992	3	paramDecryptListener	DecryptListener
    //   12	402	4	localObject1	Object
    //   418	7	4	localException1	Exception
    //   434	302	4	localObject2	Object
    //   796	5	4	localException2	Exception
    //   827	102	4	str1	String
    //   961	1	4	localIOException	java.io.IOException
    //   51	381	5	localObject3	Object
    //   442	13	5	localObject4	Object
    //   469	99	5	localObject5	Object
    //   597	38	5	localException3	Exception
    //   640	1	5	localException4	Exception
    //   700	73	5	localObject6	Object
    //   783	1	5	localException5	Exception
    //   835	21	5	localException6	Exception
    //   902	74	5	localDecryptListener	DecryptListener
    //   428	9	6	localObject7	Object
    //   460	19	6	localException7	Exception
    //   501	215	6	localObject8	Object
    //   759	1	6	localObject9	Object
    //   769	1	6	localException8	Exception
    //   899	9	6	localObject10	Object
    //   267	652	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   390	394	403	finally
    //   390	394	418	java/lang/Exception
    //   384	390	442	finally
    //   384	390	460	java/lang/Exception
    //   579	584	587	finally
    //   579	584	597	java/lang/Exception
    //   523	528	628	finally
    //   545	557	628	finally
    //   572	579	628	finally
    //   523	528	640	java/lang/Exception
    //   545	557	640	java/lang/Exception
    //   572	579	640	java/lang/Exception
    //   693	702	759	finally
    //   702	708	759	finally
    //   713	721	759	finally
    //   724	731	759	finally
    //   693	702	769	java/lang/Exception
    //   702	708	769	java/lang/Exception
    //   713	721	769	java/lang/Exception
    //   724	731	769	java/lang/Exception
    //   680	693	779	finally
    //   680	693	783	java/lang/Exception
    //   670	680	792	finally
    //   670	680	796	java/lang/Exception
    //   269	303	823	finally
    //   303	319	823	finally
    //   319	342	823	finally
    //   345	371	823	finally
    //   490	503	823	finally
    //   510	517	823	finally
    //   269	303	835	java/lang/Exception
    //   303	319	835	java/lang/Exception
    //   319	342	835	java/lang/Exception
    //   345	371	835	java/lang/Exception
    //   490	503	835	java/lang/Exception
    //   510	517	835	java/lang/Exception
    //   847	864	899	finally
    //   490	503	957	java/io/IOException
    //   510	517	957	java/io/IOException
    //   523	528	961	java/io/IOException
    //   545	557	966	java/io/IOException
    //   572	579	966	java/io/IOException
    //   579	584	970	java/io/IOException
    //   731	740	974	java/io/IOException
    //   744	748	974	java/io/IOException
    //   752	756	974	java/io/IOException
    //   810	814	978	java/io/IOException
    //   817	821	978	java/io/IOException
    //   868	872	978	java/io/IOException
    //   877	882	978	java/io/IOException
    //   886	890	978	java/io/IOException
    //   918	923	981	java/io/IOException
    //   928	933	981	java/io/IOException
    //   937	941	981	java/io/IOException
    //   945	949	981	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.VideoTemplateParser
 * JD-Core Version:    0.7.0.1
 */