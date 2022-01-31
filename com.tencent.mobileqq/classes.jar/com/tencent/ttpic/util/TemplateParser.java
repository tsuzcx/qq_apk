package com.tencent.ttpic.util;

import android.text.TextUtils;
import com.tencent.ttpic.model.DistortionItem;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.util.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class TemplateParser
{
  public static final String POSTFIX_DAT = "dat";
  private static final String POSTFIX_JSON = "json";
  public static final String POSTFIX_ORIG = "xml";
  public static final boolean USE_ORIG = true;
  
  private static InputStream drinkACupOfCoffee(InputStream paramInputStream)
  {
    return new ByteArrayInputStream(Coffee.drink(IOUtils.toByteArray(paramInputStream)));
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString1, String paramString2)
  {
    VideoMaterial localVideoMaterial = new VideoMaterial();
    localVideoMaterial.setDataPath(paramString1);
    paramString2 = parseVideoMaterialFile(paramString1, paramString2);
    if (paramString2 == null) {
      return localVideoMaterial;
    }
    for (;;)
    {
      int i;
      try
      {
        localVideoMaterial.setMinAppVersion(paramString2.optInt(VideoMaterialUtil.FIELD.MIN_APP_VERSION.value));
        localVideoMaterial.setShaderType(paramString2.optInt(VideoMaterialUtil.FIELD.SHADER_TYPE.value));
        localVideoMaterial.setMaxFaceCount(paramString2.optInt(VideoMaterialUtil.FIELD.MAX_FACE_COUNT.value));
        localVideoMaterial.setFaceExchangeImage(paramString2.optString(VideoMaterialUtil.FIELD.FACE_EXCHANGE_IMAGE.value));
        localVideoMaterial.setImageFacePointsFileName(paramString2.optString(VideoMaterialUtil.FIELD.IMAGE_FACE_POINTS_FILE_NAME.value));
        localVideoMaterial.setBlendAlpha(paramString2.optDouble(VideoMaterialUtil.FIELD.BLEND_ALPHA.value));
        localVideoMaterial.setGrayScale(paramString2.optInt(VideoMaterialUtil.FIELD.GRAY_SCALE.value));
        localVideoMaterial.setFeatureType(paramString2.optInt(VideoMaterialUtil.FIELD.FEATURE_TYPE.value));
        Object localObject1 = new ArrayList();
        Object localObject2 = paramString2.optJSONArray(VideoMaterialUtil.FIELD.RESOURCE_LIST.value);
        if (localObject2 != null)
        {
          i = 0;
          if (i < ((JSONArray)localObject2).length())
          {
            ((List)localObject1).add(((JSONArray)localObject2).optString(i));
            i += 1;
            continue;
          }
          localVideoMaterial.setResourceList((List)localObject1);
        }
        localObject1 = new ArrayList();
        localObject2 = paramString2.optJSONArray(VideoMaterialUtil.FIELD.ITEM_LIST.value);
        JSONObject localJSONObject;
        if (localObject2 != null)
        {
          int j = 0;
          i = 0;
          if (j < ((JSONArray)localObject2).length())
          {
            localJSONObject = ((JSONArray)localObject2).getJSONObject(j);
            StickerItem localStickerItem = new StickerItem();
            localStickerItem.id = localJSONObject.optString("id");
            localStickerItem.name = localJSONObject.optString("name");
            localStickerItem.type = localJSONObject.optInt("type");
            localStickerItem.triggerType = localJSONObject.optInt("triggerType");
            if (VideoMaterialUtil.isActionTriggerType(localStickerItem.triggerType)) {
              localVideoMaterial.setTriggerType(localStickerItem.triggerType);
            }
            if (localJSONObject.optInt("alwaysTriggered") != 1) {
              break label1044;
            }
            bool = true;
            localStickerItem.alwaysTriggered = bool;
            localStickerItem.playCount = localJSONObject.optInt("playCount");
            localStickerItem.frameDuration = localJSONObject.optDouble("frameDuration");
            localStickerItem.frames = localJSONObject.optInt("frames");
            localStickerItem.width = localJSONObject.optInt("width");
            localStickerItem.height = localJSONObject.optInt("height");
            JSONArray localJSONArray = localJSONObject.optJSONArray("position");
            int k;
            if (localJSONArray != null)
            {
              localStickerItem.position = new double[localJSONArray.length()];
              k = 0;
              if (k < localJSONArray.length())
              {
                localStickerItem.position[k] = localJSONArray.getDouble(k);
                k += 1;
                continue;
              }
            }
            localStickerItem.audio = localJSONObject.optString("audio");
            if ((!TextUtils.isEmpty(localStickerItem.audio)) && (!TextUtils.isEmpty(paramString1)))
            {
              if (paramString1.startsWith("assets://camera/camera_video/video_")) {
                break label1050;
              }
              if (paramString1.contains("/files/olm/camera/video_"))
              {
                break label1050;
                localJSONArray = localJSONObject.optJSONArray("anchorPoint");
                if (localJSONArray != null)
                {
                  localStickerItem.anchorPoint = new int[localJSONArray.length()];
                  k = 0;
                  if (k < localJSONArray.length())
                  {
                    localStickerItem.anchorPoint[k] = localJSONArray.getInt(k);
                    k += 1;
                    continue;
                  }
                }
                localJSONArray = localJSONObject.optJSONArray("alignFacePoints");
                if (localJSONArray != null)
                {
                  localStickerItem.alignFacePoints = new int[localJSONArray.length()];
                  k = 0;
                  if (k < localJSONArray.length())
                  {
                    localStickerItem.alignFacePoints[k] = localJSONArray.getInt(k);
                    k += 1;
                    continue;
                  }
                }
                localJSONArray = localJSONObject.optJSONArray("scalePivots");
                if (localJSONArray != null)
                {
                  localStickerItem.scalePivots = new int[localJSONArray.length()];
                  k = 0;
                  if (k < localJSONArray.length())
                  {
                    localStickerItem.scalePivots[k] = localJSONArray.getInt(k);
                    k += 1;
                    continue;
                  }
                }
                localStickerItem.scaleFactor = localJSONObject.optInt("scaleFactor");
                ((List)localObject1).add(localStickerItem);
                j += 1;
              }
            }
          }
          else
          {
            localVideoMaterial.setItemList((List)localObject1);
            if (i <= 0) {
              break label1057;
            }
            bool = true;
            localVideoMaterial.setHasAudio(bool);
          }
        }
        else
        {
          paramString1 = new ArrayList();
          localObject1 = paramString2.optJSONArray(VideoMaterialUtil.FIELD.DISTORTION_LIST.value);
          if (localObject1 != null)
          {
            i = 0;
            if (i < ((JSONArray)localObject1).length())
            {
              localObject2 = new DistortionItem();
              localJSONObject = ((JSONArray)localObject1).getJSONObject(i);
              ((DistortionItem)localObject2).position = localJSONObject.optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.POSITION.value);
              ((DistortionItem)localObject2).distortion = localJSONObject.optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.DISTORTION.value);
              ((DistortionItem)localObject2).direction = localJSONObject.optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.DIRECTION.value);
              ((DistortionItem)localObject2).radius = ((float)localJSONObject.optDouble(VideoMaterialUtil.DISTORTION_ITEM_FILED.RADIUS.value));
              ((DistortionItem)localObject2).strength = ((float)localJSONObject.optDouble(VideoMaterialUtil.DISTORTION_ITEM_FILED.STRENGH.value));
              ((DistortionItem)localObject2).x = localJSONObject.optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.X.value);
              ((DistortionItem)localObject2).y = localJSONObject.optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.Y.value);
              paramString1.add(localObject2);
              i += 1;
              continue;
            }
            localVideoMaterial.setDistortionItemList(paramString1);
          }
          paramString1 = paramString2.optJSONArray(VideoMaterialUtil.FIELD.FACE_POINTS_LIST.value);
          paramString2 = new ArrayList();
          if (paramString1 == null) {
            break;
          }
          i = 0;
          if (i < paramString1.length())
          {
            paramString2.add(Float.valueOf((float)paramString1.optDouble(i)));
            i += 1;
            continue;
          }
          localVideoMaterial.setFacePoints(paramString2);
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      finally
      {
        return localVideoMaterial;
      }
      continue;
      label1044:
      boolean bool = false;
      continue;
      label1050:
      i += 1;
      continue;
      label1057:
      bool = false;
    }
  }
  
  /* Error */
  public static JSONObject parseVideoMaterialFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: invokestatic 355	com/tencent/ttpic/util/VideoUtil:getRealPath	(Ljava/lang/String;)Ljava/lang/String;
    //   9: astore_3
    //   10: new 357	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 358	java/lang/StringBuilder:<init>	()V
    //   17: aload_3
    //   18: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: ldc_w 364
    //   24: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_1
    //   28: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc_w 366
    //   34: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 11
    //   39: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 370	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: astore_0
    //   46: new 357	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 358	java/lang/StringBuilder:<init>	()V
    //   53: aload_3
    //   54: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc_w 364
    //   60: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_1
    //   64: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc_w 366
    //   70: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc 8
    //   75: invokevirtual 362	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 370	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: astore_3
    //   82: new 372	java/io/File
    //   85: dup
    //   86: aload_0
    //   87: invokespecial 374	java/io/File:<init>	(Ljava/lang/String;)V
    //   90: astore_1
    //   91: new 372	java/io/File
    //   94: dup
    //   95: aload_3
    //   96: invokespecial 374	java/io/File:<init>	(Ljava/lang/String;)V
    //   99: astore 5
    //   101: aload_1
    //   102: invokevirtual 378	java/io/File:exists	()Z
    //   105: ifeq +10 -> 115
    //   108: aload_1
    //   109: invokevirtual 381	java/io/File:isFile	()Z
    //   112: ifne +19 -> 131
    //   115: aload 5
    //   117: invokevirtual 378	java/io/File:exists	()Z
    //   120: ifeq +197 -> 317
    //   123: aload 5
    //   125: invokevirtual 381	java/io/File:isFile	()Z
    //   128: ifeq +189 -> 317
    //   131: aload_1
    //   132: invokevirtual 378	java/io/File:exists	()Z
    //   135: ifeq +140 -> 275
    //   138: aload_1
    //   139: invokevirtual 381	java/io/File:isFile	()Z
    //   142: ifeq +133 -> 275
    //   145: new 383	java/io/FileInputStream
    //   148: dup
    //   149: aload_1
    //   150: invokespecial 386	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   153: astore_0
    //   154: iload_2
    //   155: ifne +151 -> 306
    //   158: aload_0
    //   159: invokestatic 388	com/tencent/ttpic/util/TemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;)Ljava/io/InputStream;
    //   162: astore_1
    //   163: aload_0
    //   164: invokestatic 392	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   167: aload_1
    //   168: ifnull +528 -> 696
    //   171: new 394	java/io/InputStreamReader
    //   174: dup
    //   175: aload_1
    //   176: invokespecial 396	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   179: astore 5
    //   181: new 398	java/io/BufferedReader
    //   184: dup
    //   185: aload 5
    //   187: sipush 1024
    //   190: invokespecial 401	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   193: astore 6
    //   195: new 403	java/lang/StringBuffer
    //   198: dup
    //   199: invokespecial 404	java/lang/StringBuffer:<init>	()V
    //   202: astore_3
    //   203: aload 6
    //   205: invokevirtual 407	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   208: astore 4
    //   210: aload 4
    //   212: ifnull +163 -> 375
    //   215: aload_3
    //   216: aload 4
    //   218: invokevirtual 410	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   221: pop
    //   222: goto -19 -> 203
    //   225: astore_3
    //   226: aload_0
    //   227: astore 4
    //   229: aload 5
    //   231: astore_0
    //   232: aload_1
    //   233: astore_3
    //   234: aload 6
    //   236: astore_1
    //   237: aload_1
    //   238: ifnull +7 -> 245
    //   241: aload_1
    //   242: invokevirtual 413	java/io/BufferedReader:close	()V
    //   245: aload_0
    //   246: ifnull +7 -> 253
    //   249: aload_0
    //   250: invokevirtual 414	java/io/InputStreamReader:close	()V
    //   253: aload_3
    //   254: ifnull +7 -> 261
    //   257: aload_3
    //   258: invokevirtual 417	java/io/InputStream:close	()V
    //   261: aload 4
    //   263: ifnull +8 -> 271
    //   266: aload 4
    //   268: invokevirtual 418	java/io/FileInputStream:close	()V
    //   271: aconst_null
    //   272: astore_1
    //   273: aload_1
    //   274: areturn
    //   275: aload 5
    //   277: invokevirtual 378	java/io/File:exists	()Z
    //   280: ifeq +427 -> 707
    //   283: aload 5
    //   285: invokevirtual 381	java/io/File:isFile	()Z
    //   288: ifeq +419 -> 707
    //   291: new 383	java/io/FileInputStream
    //   294: dup
    //   295: aload 5
    //   297: invokespecial 386	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   300: astore_0
    //   301: iconst_0
    //   302: istore_2
    //   303: goto -149 -> 154
    //   306: aload_0
    //   307: astore_1
    //   308: aload_0
    //   309: astore_3
    //   310: aload_1
    //   311: astore_0
    //   312: aload_3
    //   313: astore_1
    //   314: goto -147 -> 167
    //   317: invokestatic 424	com/tencent/ttpic/util/VideoGlobalContext:getContext	()Landroid/content/Context;
    //   320: invokevirtual 430	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   323: aload_0
    //   324: invokevirtual 436	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   327: astore_1
    //   328: aconst_null
    //   329: astore_0
    //   330: goto -163 -> 167
    //   333: astore_0
    //   334: invokestatic 424	com/tencent/ttpic/util/VideoGlobalContext:getContext	()Landroid/content/Context;
    //   337: invokevirtual 430	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   340: aload_3
    //   341: invokevirtual 436	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   344: astore_1
    //   345: aload_1
    //   346: invokestatic 388	com/tencent/ttpic/util/TemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;)Ljava/io/InputStream;
    //   349: astore_0
    //   350: aload_1
    //   351: invokestatic 392	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   354: aconst_null
    //   355: astore_3
    //   356: aload_0
    //   357: astore_1
    //   358: aload_3
    //   359: astore_0
    //   360: goto -193 -> 167
    //   363: astore_0
    //   364: aconst_null
    //   365: astore_0
    //   366: aconst_null
    //   367: astore_3
    //   368: aload_0
    //   369: astore_1
    //   370: aload_3
    //   371: astore_0
    //   372: goto -205 -> 167
    //   375: aload_3
    //   376: invokevirtual 437	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   379: astore_3
    //   380: aload_3
    //   381: invokestatic 235	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   384: ifne +307 -> 691
    //   387: new 439	org/json/JSONTokener
    //   390: dup
    //   391: aload_3
    //   392: invokespecial 440	org/json/JSONTokener:<init>	(Ljava/lang/String;)V
    //   395: invokevirtual 444	org/json/JSONTokener:nextValue	()Ljava/lang/Object;
    //   398: checkcast 67	org/json/JSONObject
    //   401: astore_3
    //   402: aload 6
    //   404: ifnull +8 -> 412
    //   407: aload 6
    //   409: invokevirtual 413	java/io/BufferedReader:close	()V
    //   412: aload 5
    //   414: ifnull +8 -> 422
    //   417: aload 5
    //   419: invokevirtual 414	java/io/InputStreamReader:close	()V
    //   422: aload_1
    //   423: ifnull +7 -> 430
    //   426: aload_1
    //   427: invokevirtual 417	java/io/InputStream:close	()V
    //   430: aload_3
    //   431: astore_1
    //   432: aload_0
    //   433: ifnull -160 -> 273
    //   436: aload_0
    //   437: invokevirtual 418	java/io/FileInputStream:close	()V
    //   440: aload_3
    //   441: areturn
    //   442: astore_0
    //   443: aload_3
    //   444: areturn
    //   445: astore_0
    //   446: aconst_null
    //   447: areturn
    //   448: astore_0
    //   449: aconst_null
    //   450: astore 5
    //   452: aconst_null
    //   453: astore_3
    //   454: aconst_null
    //   455: astore_1
    //   456: aload_3
    //   457: ifnull +7 -> 464
    //   460: aload_3
    //   461: invokevirtual 413	java/io/BufferedReader:close	()V
    //   464: aload 5
    //   466: ifnull +8 -> 474
    //   469: aload 5
    //   471: invokevirtual 414	java/io/InputStreamReader:close	()V
    //   474: aload_1
    //   475: ifnull +7 -> 482
    //   478: aload_1
    //   479: invokevirtual 417	java/io/InputStream:close	()V
    //   482: aload 4
    //   484: ifnull +8 -> 492
    //   487: aload 4
    //   489: invokevirtual 418	java/io/FileInputStream:close	()V
    //   492: aload_0
    //   493: athrow
    //   494: astore_1
    //   495: goto -3 -> 492
    //   498: astore 6
    //   500: aconst_null
    //   501: astore 5
    //   503: aconst_null
    //   504: astore_3
    //   505: aconst_null
    //   506: astore_1
    //   507: aload_0
    //   508: astore 4
    //   510: aload 6
    //   512: astore_0
    //   513: goto -57 -> 456
    //   516: astore 5
    //   518: aconst_null
    //   519: astore_3
    //   520: aload_0
    //   521: astore 4
    //   523: aload 5
    //   525: astore_0
    //   526: aconst_null
    //   527: astore 5
    //   529: goto -73 -> 456
    //   532: astore 6
    //   534: aconst_null
    //   535: astore 5
    //   537: aconst_null
    //   538: astore_3
    //   539: aload_0
    //   540: astore_1
    //   541: aload 6
    //   543: astore_0
    //   544: goto -88 -> 456
    //   547: astore 6
    //   549: aconst_null
    //   550: astore 5
    //   552: aconst_null
    //   553: astore_3
    //   554: aload_0
    //   555: astore 4
    //   557: aload 6
    //   559: astore_0
    //   560: goto -104 -> 456
    //   563: astore 6
    //   565: aconst_null
    //   566: astore_3
    //   567: aload_0
    //   568: astore 4
    //   570: aload 6
    //   572: astore_0
    //   573: goto -117 -> 456
    //   576: astore_3
    //   577: aload_0
    //   578: astore 4
    //   580: aload_3
    //   581: astore_0
    //   582: aload 6
    //   584: astore_3
    //   585: goto -129 -> 456
    //   588: astore_0
    //   589: aconst_null
    //   590: astore 4
    //   592: aconst_null
    //   593: astore_0
    //   594: aconst_null
    //   595: astore_1
    //   596: aconst_null
    //   597: astore_3
    //   598: goto -361 -> 237
    //   601: astore_1
    //   602: aconst_null
    //   603: astore 5
    //   605: aconst_null
    //   606: astore_1
    //   607: aconst_null
    //   608: astore_3
    //   609: aload_0
    //   610: astore 4
    //   612: aload 5
    //   614: astore_0
    //   615: goto -378 -> 237
    //   618: astore_3
    //   619: aconst_null
    //   620: astore 5
    //   622: aload_1
    //   623: astore_3
    //   624: aconst_null
    //   625: astore_1
    //   626: aload_0
    //   627: astore 4
    //   629: aload_1
    //   630: astore_0
    //   631: aload 5
    //   633: astore_1
    //   634: goto -397 -> 237
    //   637: astore_1
    //   638: aconst_null
    //   639: astore 5
    //   641: aconst_null
    //   642: astore_1
    //   643: aload_0
    //   644: astore_3
    //   645: aconst_null
    //   646: astore 4
    //   648: aload 5
    //   650: astore_0
    //   651: goto -414 -> 237
    //   654: astore_3
    //   655: aconst_null
    //   656: astore 5
    //   658: aload_1
    //   659: astore_3
    //   660: aconst_null
    //   661: astore_1
    //   662: aload_0
    //   663: astore 4
    //   665: aload_1
    //   666: astore_0
    //   667: aload 5
    //   669: astore_1
    //   670: goto -433 -> 237
    //   673: astore_3
    //   674: aload_1
    //   675: astore_3
    //   676: aconst_null
    //   677: astore_1
    //   678: aload_0
    //   679: astore 4
    //   681: aload 5
    //   683: astore_0
    //   684: goto -447 -> 237
    //   687: astore_1
    //   688: goto -322 -> 366
    //   691: aconst_null
    //   692: astore_3
    //   693: goto -291 -> 402
    //   696: aconst_null
    //   697: astore 5
    //   699: aconst_null
    //   700: astore 6
    //   702: aconst_null
    //   703: astore_3
    //   704: goto -302 -> 402
    //   707: aconst_null
    //   708: astore_0
    //   709: goto -555 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	712	0	paramString1	String
    //   0	712	1	paramString2	String
    //   1	302	2	i	int
    //   9	207	3	localObject1	Object
    //   225	1	3	localException1	Exception
    //   233	334	3	localObject2	Object
    //   576	5	3	localObject3	Object
    //   584	25	3	localObject4	Object
    //   618	1	3	localException2	Exception
    //   623	22	3	str1	String
    //   654	1	3	localException3	Exception
    //   659	1	3	str2	String
    //   673	1	3	localException4	Exception
    //   675	29	3	str3	String
    //   3	677	4	str4	String
    //   99	403	5	localObject5	Object
    //   516	8	5	localObject6	Object
    //   527	171	5	localObject7	Object
    //   193	215	6	localBufferedReader	java.io.BufferedReader
    //   498	13	6	localObject8	Object
    //   532	10	6	localObject9	Object
    //   547	11	6	localObject10	Object
    //   563	20	6	localObject11	Object
    //   700	1	6	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   195	203	225	java/lang/Exception
    //   203	210	225	java/lang/Exception
    //   215	222	225	java/lang/Exception
    //   375	402	225	java/lang/Exception
    //   317	328	333	java/io/IOException
    //   334	350	363	java/io/IOException
    //   407	412	442	java/io/IOException
    //   417	422	442	java/io/IOException
    //   426	430	442	java/io/IOException
    //   436	440	442	java/io/IOException
    //   241	245	445	java/io/IOException
    //   249	253	445	java/io/IOException
    //   257	261	445	java/io/IOException
    //   266	271	445	java/io/IOException
    //   82	115	448	finally
    //   115	131	448	finally
    //   131	154	448	finally
    //   275	301	448	finally
    //   317	328	448	finally
    //   334	350	448	finally
    //   460	464	494	java/io/IOException
    //   469	474	494	java/io/IOException
    //   478	482	494	java/io/IOException
    //   487	492	494	java/io/IOException
    //   158	163	498	finally
    //   163	167	516	finally
    //   350	354	532	finally
    //   171	181	547	finally
    //   181	195	563	finally
    //   195	203	576	finally
    //   203	210	576	finally
    //   215	222	576	finally
    //   375	402	576	finally
    //   82	115	588	java/lang/Exception
    //   115	131	588	java/lang/Exception
    //   131	154	588	java/lang/Exception
    //   275	301	588	java/lang/Exception
    //   317	328	588	java/lang/Exception
    //   334	350	588	java/lang/Exception
    //   158	163	601	java/lang/Exception
    //   163	167	618	java/lang/Exception
    //   350	354	637	java/lang/Exception
    //   171	181	654	java/lang/Exception
    //   181	195	673	java/lang/Exception
    //   350	354	687	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.TemplateParser
 * JD-Core Version:    0.7.0.1
 */