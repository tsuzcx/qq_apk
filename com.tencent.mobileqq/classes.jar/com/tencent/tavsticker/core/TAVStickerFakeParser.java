package com.tencent.tavsticker.core;

import android.text.TextUtils;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavsticker.model.TAVStickerLayerInfo;
import com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerImageEffect;
import com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerTimeEffect;
import com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerUserData;
import com.tencent.tavsticker.model.TAVStickerLayerType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@Deprecated
public class TAVStickerFakeParser
{
  private static final String DURATION_TIME = "duration";
  private static final String ID = "id";
  private static final String IMAGE_EFFECTS = "imageEffects";
  private static final String JSON_FILE_NAME = "template.json";
  private static final String LAYER = "layer";
  private static final String LOOP = "loop";
  private static final String NAME = "name";
  private static final String SPEED = "speed";
  private static final String START_TIME = "start";
  private static final String TIME_EFFECTS = "timeEffects";
  private static final String USER_DATA = "userData";
  private static final String USER_DATA_TAG = "#userData";
  
  /* Error */
  public static List<TAVStickerLayerInfo> fakeDataFromJson()
  {
    // Byte code:
    //   0: invokestatic 57	com/tencent/tavsticker/TAVStickerHelper:getContext	()Landroid/content/Context;
    //   3: invokevirtual 63	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   6: ldc 18
    //   8: invokevirtual 69	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   11: astore_1
    //   12: aload_1
    //   13: astore_0
    //   14: aload_1
    //   15: invokevirtual 75	java/io/InputStream:available	()I
    //   18: newarray byte
    //   20: astore_2
    //   21: aload_1
    //   22: astore_0
    //   23: aload_1
    //   24: aload_2
    //   25: invokevirtual 79	java/io/InputStream:read	([B)I
    //   28: pop
    //   29: aload_1
    //   30: astore_0
    //   31: new 81	java/lang/String
    //   34: dup
    //   35: aload_2
    //   36: ldc 83
    //   38: invokespecial 86	java/lang/String:<init>	([BLjava/lang/String;)V
    //   41: invokestatic 90	com/tencent/tavsticker/core/TAVStickerFakeParser:parse	(Ljava/lang/String;)Ljava/util/List;
    //   44: astore_2
    //   45: aload_1
    //   46: ifnull +14 -> 60
    //   49: aload_1
    //   50: invokevirtual 93	java/io/InputStream:close	()V
    //   53: aload_2
    //   54: areturn
    //   55: astore_0
    //   56: aload_0
    //   57: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   60: aload_2
    //   61: areturn
    //   62: astore_2
    //   63: goto +12 -> 75
    //   66: astore_0
    //   67: aconst_null
    //   68: astore_1
    //   69: goto +34 -> 103
    //   72: astore_2
    //   73: aconst_null
    //   74: astore_1
    //   75: aload_1
    //   76: astore_0
    //   77: aload_2
    //   78: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   81: aload_1
    //   82: ifnull +14 -> 96
    //   85: aload_1
    //   86: invokevirtual 93	java/io/InputStream:close	()V
    //   89: aconst_null
    //   90: areturn
    //   91: astore_0
    //   92: aload_0
    //   93: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   96: aconst_null
    //   97: areturn
    //   98: astore_2
    //   99: aload_0
    //   100: astore_1
    //   101: aload_2
    //   102: astore_0
    //   103: aload_1
    //   104: ifnull +15 -> 119
    //   107: aload_1
    //   108: invokevirtual 93	java/io/InputStream:close	()V
    //   111: goto +8 -> 119
    //   114: astore_1
    //   115: aload_1
    //   116: invokevirtual 96	java/lang/Exception:printStackTrace	()V
    //   119: aload_0
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   13	18	0	localObject1	Object
    //   55	2	0	localException1	java.lang.Exception
    //   66	1	0	localObject2	Object
    //   76	1	0	localObject3	Object
    //   91	9	0	localException2	java.lang.Exception
    //   102	18	0	localObject4	Object
    //   11	97	1	localObject5	Object
    //   114	2	1	localException3	java.lang.Exception
    //   20	41	2	localObject6	Object
    //   62	1	2	localException4	java.lang.Exception
    //   72	6	2	localException5	java.lang.Exception
    //   98	4	2	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   49	53	55	java/lang/Exception
    //   14	21	62	java/lang/Exception
    //   23	29	62	java/lang/Exception
    //   31	45	62	java/lang/Exception
    //   0	12	66	finally
    //   0	12	72	java/lang/Exception
    //   85	89	91	java/lang/Exception
    //   14	21	98	finally
    //   23	29	98	finally
    //   31	45	98	finally
    //   77	81	98	finally
    //   107	111	114	java/lang/Exception
  }
  
  private static List<TAVStickerLayerInfo> parse(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new JSONArray(paramString);
      int j = paramString.length();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < j)
      {
        Object localObject1 = paramString.optJSONObject(i).optJSONObject("layer");
        Object localObject4 = ((JSONObject)localObject1).opt("timeEffects");
        Object localObject2 = ((JSONObject)localObject1).opt("imageEffects");
        Object localObject3 = ((JSONObject)localObject1).opt("userData");
        localObject1 = CMTimeRange.CMTimeRangeInvalid;
        localObject4 = parseTimeEffects(localObject4);
        localObject2 = parseImageEffects(localObject2);
        localObject3 = parseUserDataList(localObject3);
        localArrayList.add(new TAVStickerLayerInfo(0, TAVStickerLayerType.Image, (CMTimeRange)localObject1, (List)localObject4, (List)localObject2, (List)localObject3));
        i += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  private static List<TAVStickerLayerInfo.TAVStickerImageEffect> parseImageEffects(Object paramObject)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    float f1;
    float f2;
    if ((paramObject instanceof JSONObject))
    {
      localObject1 = (JSONObject)paramObject;
      f1 = (float)((JSONObject)localObject1).optDouble("start", 0.0D);
      f2 = (float)((JSONObject)localObject1).optDouble("duration", 0.0D);
      paramObject = ((JSONObject)localObject1).optString("id", "");
      localObject1 = ((JSONObject)localObject1).optString("name", "");
      localArrayList.add(new TAVStickerLayerInfo.TAVStickerImageEffect(new CMTimeRange(new CMTime(f1), new CMTime(f2)), paramObject, (String)localObject1));
      return localArrayList;
    }
    if ((paramObject instanceof JSONArray))
    {
      paramObject = (JSONArray)paramObject;
      int j = paramObject.length();
      int i = 0;
      while (i < j)
      {
        Object localObject2 = paramObject.optJSONObject(i);
        f1 = (float)((JSONObject)localObject2).optDouble("start", 0.0D);
        f2 = (float)((JSONObject)localObject2).optDouble("duration", 0.0D);
        localObject1 = ((JSONObject)localObject2).optString("id", "");
        localObject2 = ((JSONObject)localObject2).optString("name", "");
        localArrayList.add(new TAVStickerLayerInfo.TAVStickerImageEffect(new CMTimeRange(new CMTime(f1), new CMTime(f2)), (String)localObject1, (String)localObject2));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private static List<TAVStickerLayerInfo.TAVStickerTimeEffect> parseTimeEffects(Object paramObject)
  {
    ArrayList localArrayList = new ArrayList();
    float f1;
    float f2;
    if ((paramObject instanceof JSONObject))
    {
      paramObject = (JSONObject)paramObject;
      f1 = (float)paramObject.optDouble("start", 0.0D);
      f2 = (float)paramObject.optDouble("duration", 0.0D);
      localArrayList.add(new TAVStickerLayerInfo.TAVStickerTimeEffect(new CMTimeRange(new CMTime(f1), new CMTime(f2)), CMTimeRange.CMTimeRangeInvalid, false));
      return localArrayList;
    }
    if ((paramObject instanceof JSONArray))
    {
      paramObject = (JSONArray)paramObject;
      int j = paramObject.length();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = paramObject.optJSONObject(i);
        f1 = (float)localJSONObject.optDouble("start", 0.0D);
        f2 = (float)localJSONObject.optDouble("duration", 0.0D);
        localArrayList.add(new TAVStickerLayerInfo.TAVStickerTimeEffect(new CMTimeRange(new CMTime(f1), new CMTime(f2)), CMTimeRange.CMTimeRangeInvalid, false));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private static List<TAVStickerLayerInfo.TAVStickerUserData> parseUserDataList(Object paramObject)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    Object localObject2;
    if ((paramObject instanceof JSONObject))
    {
      paramObject = (JSONObject)paramObject;
      localObject1 = CMTimeRange.CMTimeRangeInvalid;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("#userData\r");
      ((StringBuilder)localObject2).append(paramObject.toString());
      localArrayList.add(new TAVStickerLayerInfo.TAVStickerUserData((CMTimeRange)localObject1, ((StringBuilder)localObject2).toString()));
      return localArrayList;
    }
    if ((paramObject instanceof JSONArray))
    {
      paramObject = (JSONArray)paramObject;
      int j = paramObject.length();
      int i = 0;
      while (i < j)
      {
        localObject1 = paramObject.optJSONObject(i);
        localObject2 = CMTimeRange.CMTimeRangeInvalid;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("#userData\r");
        localStringBuilder.append(((JSONObject)localObject1).toString());
        localArrayList.add(new TAVStickerLayerInfo.TAVStickerUserData((CMTimeRange)localObject2, localStringBuilder.toString()));
        i += 1;
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerFakeParser
 * JD-Core Version:    0.7.0.1
 */