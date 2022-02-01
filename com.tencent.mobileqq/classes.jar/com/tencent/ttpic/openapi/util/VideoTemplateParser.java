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
  private static final String TAG = VideoTemplateParser.class.getSimpleName();
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
    if (paramJsonObject == null) {}
    for (;;)
    {
      return paramVideoMaterial;
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
          return paramVideoMaterial;
        }
      }
      catch (Throwable paramJsonObject)
      {
        paramJsonObject = paramJsonObject;
        LogUtils.w(TAG, "parseDoodleMaterial");
        return paramVideoMaterial;
      }
      finally {}
    }
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
        paramString1.put(str1, paramString2 + File.separator + str2.substring(1, i - 1));
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
    LogUtils.i(TAG, "[parseVideoMaterialFileAsJSONObject] dataStr = " + paramString1);
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
    do
    {
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
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    } while (TextUtils.isEmpty(paramString));
    paramString = GsonUtils.json2JsonObject(paramString);
    return paramString;
  }
  
  /* Error */
  public static String readMaterialFile(String paramString1, String paramString2, boolean paramBoolean, DecryptListener paramDecryptListener)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: invokestatic 309	com/tencent/ttpic/baseutils/io/FileUtils:getRealPath	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore_0
    //   11: new 173	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   18: aload_0
    //   19: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc_w 311
    //   25: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_1
    //   29: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: astore 5
    //   37: new 173	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   44: aload_0
    //   45: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc_w 311
    //   51: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_1
    //   55: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore 7
    //   63: iload_2
    //   64: ifeq +353 -> 417
    //   67: aload 5
    //   69: astore_0
    //   70: aload 5
    //   72: ldc 34
    //   74: invokevirtual 315	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   77: ifne +25 -> 102
    //   80: new 173	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   87: aload 5
    //   89: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc_w 317
    //   95: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: astore_0
    //   102: aload_0
    //   103: astore_1
    //   104: aload 7
    //   106: ldc 31
    //   108: invokevirtual 315	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   111: ifne +884 -> 995
    //   114: new 173	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   121: aload 7
    //   123: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc_w 319
    //   129: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: astore_1
    //   136: new 180	java/io/File
    //   139: dup
    //   140: aload_0
    //   141: invokespecial 322	java/io/File:<init>	(Ljava/lang/String;)V
    //   144: astore 5
    //   146: new 180	java/io/File
    //   149: dup
    //   150: aload_1
    //   151: invokespecial 322	java/io/File:<init>	(Ljava/lang/String;)V
    //   154: astore 7
    //   156: aload 5
    //   158: invokevirtual 325	java/io/File:exists	()Z
    //   161: ifeq +11 -> 172
    //   164: aload 5
    //   166: invokevirtual 328	java/io/File:isFile	()Z
    //   169: ifne +19 -> 188
    //   172: aload 7
    //   174: invokevirtual 325	java/io/File:exists	()Z
    //   177: ifeq +357 -> 534
    //   180: aload 7
    //   182: invokevirtual 328	java/io/File:isFile	()Z
    //   185: ifeq +349 -> 534
    //   188: aload 5
    //   190: invokevirtual 325	java/io/File:exists	()Z
    //   193: ifeq +296 -> 489
    //   196: aload 5
    //   198: invokevirtual 328	java/io/File:isFile	()Z
    //   201: ifeq +288 -> 489
    //   204: new 330	java/io/FileInputStream
    //   207: dup
    //   208: aload 5
    //   210: invokespecial 333	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   213: astore_1
    //   214: iload_2
    //   215: ifne +314 -> 529
    //   218: aload_1
    //   219: aload_3
    //   220: invokestatic 292	com/tencent/ttpic/openapi/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   223: astore_0
    //   224: aload_1
    //   225: astore 5
    //   227: aload_0
    //   228: astore 8
    //   230: aload_1
    //   231: astore_3
    //   232: aload_0
    //   233: astore 7
    //   235: aload_1
    //   236: invokestatic 336	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   239: aload_0
    //   240: ifnull +454 -> 694
    //   243: aload_1
    //   244: astore 5
    //   246: aload_0
    //   247: astore 8
    //   249: aload_1
    //   250: astore_3
    //   251: aload_0
    //   252: astore 7
    //   254: new 278	java/io/InputStreamReader
    //   257: dup
    //   258: aload_0
    //   259: invokespecial 295	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   262: astore 6
    //   264: new 276	java/io/BufferedReader
    //   267: dup
    //   268: aload 6
    //   270: sipush 1024
    //   273: invokespecial 298	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   276: astore_3
    //   277: aload_1
    //   278: astore 10
    //   280: aload 6
    //   282: astore 9
    //   284: aload_3
    //   285: astore 8
    //   287: aload_0
    //   288: astore 7
    //   290: new 173	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   297: astore 5
    //   299: aload_1
    //   300: astore 10
    //   302: aload 6
    //   304: astore 9
    //   306: aload_3
    //   307: astore 8
    //   309: aload_0
    //   310: astore 7
    //   312: aload_3
    //   313: invokevirtual 301	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   316: astore 11
    //   318: aload 11
    //   320: ifnull +310 -> 630
    //   323: aload_1
    //   324: astore 10
    //   326: aload 6
    //   328: astore 9
    //   330: aload_3
    //   331: astore 8
    //   333: aload_0
    //   334: astore 7
    //   336: aload 5
    //   338: aload 11
    //   340: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: goto -45 -> 299
    //   347: astore 5
    //   349: aload_1
    //   350: astore 10
    //   352: aload 6
    //   354: astore 9
    //   356: aload_3
    //   357: astore 8
    //   359: aload_0
    //   360: astore 7
    //   362: getstatic 47	com/tencent/ttpic/openapi/util/VideoTemplateParser:TAG	Ljava/lang/String;
    //   365: aload 5
    //   367: invokevirtual 339	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   370: aload 5
    //   372: iconst_0
    //   373: anewarray 4	java/lang/Object
    //   376: invokestatic 343	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   379: aload_3
    //   380: ifnull +7 -> 387
    //   383: aload_3
    //   384: invokevirtual 346	java/io/BufferedReader:close	()V
    //   387: aload 6
    //   389: ifnull +8 -> 397
    //   392: aload 6
    //   394: invokevirtual 347	java/io/InputStreamReader:close	()V
    //   397: aload_0
    //   398: ifnull +7 -> 405
    //   401: aload_0
    //   402: invokevirtual 350	java/io/InputStream:close	()V
    //   405: aload_1
    //   406: ifnull +7 -> 413
    //   409: aload_1
    //   410: invokevirtual 351	java/io/FileInputStream:close	()V
    //   413: aconst_null
    //   414: astore_0
    //   415: aload_0
    //   416: areturn
    //   417: aload 5
    //   419: astore_0
    //   420: aload 5
    //   422: ldc 31
    //   424: invokevirtual 315	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   427: ifne +25 -> 452
    //   430: new 173	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   437: aload 5
    //   439: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: ldc_w 319
    //   445: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: astore_0
    //   452: aload_0
    //   453: astore_1
    //   454: aload 7
    //   456: ldc 34
    //   458: invokevirtual 315	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   461: ifne +534 -> 995
    //   464: new 173	java/lang/StringBuilder
    //   467: dup
    //   468: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   471: aload 7
    //   473: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: ldc_w 317
    //   479: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   485: astore_1
    //   486: goto -350 -> 136
    //   489: aload 7
    //   491: invokevirtual 325	java/io/File:exists	()Z
    //   494: ifeq +496 -> 990
    //   497: aload 7
    //   499: invokevirtual 328	java/io/File:isFile	()Z
    //   502: ifeq +488 -> 990
    //   505: new 330	java/io/FileInputStream
    //   508: dup
    //   509: aload 7
    //   511: invokespecial 333	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   514: astore_1
    //   515: iload_2
    //   516: ifne +8 -> 524
    //   519: iconst_1
    //   520: istore_2
    //   521: goto -307 -> 214
    //   524: iconst_0
    //   525: istore_2
    //   526: goto -5 -> 521
    //   529: aload_1
    //   530: astore_0
    //   531: goto -292 -> 239
    //   534: invokestatic 357	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   537: invokevirtual 363	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   540: aload_0
    //   541: invokevirtual 369	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   544: astore 5
    //   546: iload_2
    //   547: ifne +20 -> 567
    //   550: aload 5
    //   552: aload_3
    //   553: invokestatic 292	com/tencent/ttpic/openapi/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   556: astore_0
    //   557: aload 5
    //   559: invokestatic 336	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   562: aconst_null
    //   563: astore_1
    //   564: goto -325 -> 239
    //   567: aload 5
    //   569: astore_0
    //   570: goto -8 -> 562
    //   573: astore_0
    //   574: aconst_null
    //   575: astore_0
    //   576: invokestatic 357	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   579: invokevirtual 363	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   582: aload_1
    //   583: invokevirtual 369	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   586: astore_1
    //   587: iload_2
    //   588: ifne +25 -> 613
    //   591: iload 4
    //   593: ifne +26 -> 619
    //   596: aload_1
    //   597: aload_3
    //   598: invokestatic 292	com/tencent/ttpic/openapi/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   601: astore_3
    //   602: aload_3
    //   603: astore_0
    //   604: aload_1
    //   605: invokestatic 336	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   608: aconst_null
    //   609: astore_1
    //   610: goto -371 -> 239
    //   613: iconst_0
    //   614: istore 4
    //   616: goto -25 -> 591
    //   619: aload_1
    //   620: astore_0
    //   621: goto -13 -> 608
    //   624: astore_1
    //   625: aconst_null
    //   626: astore_1
    //   627: goto -388 -> 239
    //   630: aload_1
    //   631: astore 10
    //   633: aload 6
    //   635: astore 9
    //   637: aload_3
    //   638: astore 8
    //   640: aload_0
    //   641: astore 7
    //   643: aload 5
    //   645: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: astore 5
    //   650: aload_3
    //   651: ifnull +7 -> 658
    //   654: aload_3
    //   655: invokevirtual 346	java/io/BufferedReader:close	()V
    //   658: aload 6
    //   660: ifnull +8 -> 668
    //   663: aload 6
    //   665: invokevirtual 347	java/io/InputStreamReader:close	()V
    //   668: aload_0
    //   669: ifnull +7 -> 676
    //   672: aload_0
    //   673: invokevirtual 350	java/io/InputStream:close	()V
    //   676: aload 5
    //   678: astore_0
    //   679: aload_1
    //   680: ifnull -265 -> 415
    //   683: aload_1
    //   684: invokevirtual 351	java/io/FileInputStream:close	()V
    //   687: aload 5
    //   689: areturn
    //   690: astore_0
    //   691: aload 5
    //   693: areturn
    //   694: iconst_0
    //   695: ifeq +11 -> 706
    //   698: new 371	java/lang/NullPointerException
    //   701: dup
    //   702: invokespecial 372	java/lang/NullPointerException:<init>	()V
    //   705: athrow
    //   706: iconst_0
    //   707: ifeq +11 -> 718
    //   710: new 371	java/lang/NullPointerException
    //   713: dup
    //   714: invokespecial 372	java/lang/NullPointerException:<init>	()V
    //   717: athrow
    //   718: aload_0
    //   719: ifnull +7 -> 726
    //   722: aload_0
    //   723: invokevirtual 350	java/io/InputStream:close	()V
    //   726: aload_1
    //   727: ifnull -314 -> 413
    //   730: aload_1
    //   731: invokevirtual 351	java/io/FileInputStream:close	()V
    //   734: goto -321 -> 413
    //   737: astore_0
    //   738: goto -325 -> 413
    //   741: astore_1
    //   742: aconst_null
    //   743: astore_3
    //   744: aconst_null
    //   745: astore 5
    //   747: aconst_null
    //   748: astore_0
    //   749: aload 5
    //   751: ifnull +8 -> 759
    //   754: aload 5
    //   756: invokevirtual 346	java/io/BufferedReader:close	()V
    //   759: aload_3
    //   760: ifnull +7 -> 767
    //   763: aload_3
    //   764: invokevirtual 347	java/io/InputStreamReader:close	()V
    //   767: aload_0
    //   768: ifnull +7 -> 775
    //   771: aload_0
    //   772: invokevirtual 350	java/io/InputStream:close	()V
    //   775: aload 6
    //   777: ifnull +8 -> 785
    //   780: aload 6
    //   782: invokevirtual 351	java/io/FileInputStream:close	()V
    //   785: aload_1
    //   786: athrow
    //   787: astore_0
    //   788: goto -3 -> 785
    //   791: astore 7
    //   793: aconst_null
    //   794: astore_3
    //   795: aconst_null
    //   796: astore 5
    //   798: aconst_null
    //   799: astore_0
    //   800: aload_1
    //   801: astore 6
    //   803: aload 7
    //   805: astore_1
    //   806: goto -57 -> 749
    //   809: astore_1
    //   810: aconst_null
    //   811: astore_3
    //   812: aconst_null
    //   813: astore_0
    //   814: aload 5
    //   816: astore 6
    //   818: aload_0
    //   819: astore 5
    //   821: aload 8
    //   823: astore_0
    //   824: goto -75 -> 749
    //   827: astore_1
    //   828: aconst_null
    //   829: astore_3
    //   830: aconst_null
    //   831: astore 5
    //   833: goto -84 -> 749
    //   836: astore_1
    //   837: aconst_null
    //   838: astore_3
    //   839: aconst_null
    //   840: astore 5
    //   842: goto -93 -> 749
    //   845: astore_1
    //   846: aconst_null
    //   847: astore_3
    //   848: aconst_null
    //   849: astore 5
    //   851: goto -102 -> 749
    //   854: astore_3
    //   855: aconst_null
    //   856: astore 5
    //   858: aload_1
    //   859: astore 7
    //   861: aload_3
    //   862: astore_1
    //   863: aload 6
    //   865: astore_3
    //   866: aload 7
    //   868: astore 6
    //   870: goto -121 -> 749
    //   873: astore_1
    //   874: aload 10
    //   876: astore 6
    //   878: aload 9
    //   880: astore_3
    //   881: aload 8
    //   883: astore 5
    //   885: aload 7
    //   887: astore_0
    //   888: goto -139 -> 749
    //   891: astore_0
    //   892: goto -479 -> 413
    //   895: astore 5
    //   897: aconst_null
    //   898: astore_1
    //   899: aconst_null
    //   900: astore 6
    //   902: aconst_null
    //   903: astore_3
    //   904: aconst_null
    //   905: astore_0
    //   906: goto -557 -> 349
    //   909: astore 5
    //   911: aconst_null
    //   912: astore 6
    //   914: aconst_null
    //   915: astore_3
    //   916: aconst_null
    //   917: astore_0
    //   918: goto -569 -> 349
    //   921: astore 5
    //   923: aconst_null
    //   924: astore 6
    //   926: aconst_null
    //   927: astore_0
    //   928: aload_3
    //   929: astore_1
    //   930: aload_0
    //   931: astore_3
    //   932: aload 7
    //   934: astore_0
    //   935: goto -586 -> 349
    //   938: astore 5
    //   940: aconst_null
    //   941: astore 6
    //   943: aconst_null
    //   944: astore_3
    //   945: aconst_null
    //   946: astore_1
    //   947: goto -598 -> 349
    //   950: astore 5
    //   952: aconst_null
    //   953: astore_1
    //   954: aconst_null
    //   955: astore 6
    //   957: aconst_null
    //   958: astore_3
    //   959: goto -610 -> 349
    //   962: astore 5
    //   964: aconst_null
    //   965: astore 6
    //   967: aconst_null
    //   968: astore_3
    //   969: aconst_null
    //   970: astore_1
    //   971: goto -622 -> 349
    //   974: astore 5
    //   976: aconst_null
    //   977: astore_3
    //   978: goto -629 -> 349
    //   981: astore_1
    //   982: goto -357 -> 625
    //   985: astore 5
    //   987: goto -411 -> 576
    //   990: aconst_null
    //   991: astore_1
    //   992: goto -778 -> 214
    //   995: aload_1
    //   996: astore_0
    //   997: aload 7
    //   999: astore_1
    //   1000: goto -864 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1003	0	paramString1	String
    //   0	1003	1	paramString2	String
    //   0	1003	2	paramBoolean	boolean
    //   0	1003	3	paramDecryptListener	DecryptListener
    //   1	614	4	i	int
    //   35	302	5	localObject1	Object
    //   347	91	5	localException1	Exception
    //   544	340	5	localObject2	Object
    //   895	1	5	localException2	Exception
    //   909	1	5	localException3	Exception
    //   921	1	5	localException4	Exception
    //   938	1	5	localException5	Exception
    //   950	1	5	localException6	Exception
    //   962	1	5	localException7	Exception
    //   974	1	5	localException8	Exception
    //   985	1	5	localIOException	java.io.IOException
    //   4	962	6	localObject3	Object
    //   61	581	7	localObject4	Object
    //   791	13	7	localObject5	Object
    //   859	139	7	str1	String
    //   228	654	8	localObject6	Object
    //   282	597	9	localObject7	Object
    //   278	597	10	str2	String
    //   316	23	11	str3	String
    // Exception table:
    //   from	to	target	type
    //   290	299	347	java/lang/Exception
    //   312	318	347	java/lang/Exception
    //   336	344	347	java/lang/Exception
    //   643	650	347	java/lang/Exception
    //   534	546	573	java/io/IOException
    //   550	557	573	java/io/IOException
    //   576	587	624	java/io/IOException
    //   596	602	624	java/io/IOException
    //   654	658	690	java/io/IOException
    //   663	668	690	java/io/IOException
    //   672	676	690	java/io/IOException
    //   683	687	690	java/io/IOException
    //   698	706	737	java/io/IOException
    //   710	718	737	java/io/IOException
    //   722	726	737	java/io/IOException
    //   730	734	737	java/io/IOException
    //   136	172	741	finally
    //   172	188	741	finally
    //   188	214	741	finally
    //   489	515	741	finally
    //   534	546	741	finally
    //   550	557	741	finally
    //   754	759	787	java/io/IOException
    //   763	767	787	java/io/IOException
    //   771	775	787	java/io/IOException
    //   780	785	787	java/io/IOException
    //   218	224	791	finally
    //   235	239	809	finally
    //   254	264	809	finally
    //   557	562	827	finally
    //   576	587	836	finally
    //   596	602	836	finally
    //   604	608	845	finally
    //   264	277	854	finally
    //   290	299	873	finally
    //   312	318	873	finally
    //   336	344	873	finally
    //   362	379	873	finally
    //   643	650	873	finally
    //   383	387	891	java/io/IOException
    //   392	397	891	java/io/IOException
    //   401	405	891	java/io/IOException
    //   409	413	891	java/io/IOException
    //   136	172	895	java/lang/Exception
    //   172	188	895	java/lang/Exception
    //   188	214	895	java/lang/Exception
    //   489	515	895	java/lang/Exception
    //   534	546	895	java/lang/Exception
    //   550	557	895	java/lang/Exception
    //   218	224	909	java/lang/Exception
    //   235	239	921	java/lang/Exception
    //   254	264	921	java/lang/Exception
    //   557	562	938	java/lang/Exception
    //   576	587	950	java/lang/Exception
    //   596	602	950	java/lang/Exception
    //   604	608	962	java/lang/Exception
    //   264	277	974	java/lang/Exception
    //   604	608	981	java/io/IOException
    //   557	562	985	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.VideoTemplateParser
 * JD-Core Version:    0.7.0.1
 */