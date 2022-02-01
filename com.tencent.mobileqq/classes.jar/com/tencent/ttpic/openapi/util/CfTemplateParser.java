package com.tencent.ttpic.openapi.util;

import android.graphics.Color;
import android.text.TextUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.model.BaseFilterMaterial;
import com.tencent.ttpic.openapi.model.BridgeMaterial;
import com.tencent.ttpic.openapi.model.CosmeticsDataTemplate;
import com.tencent.ttpic.openapi.model.CosmeticsDataTemplate.CosmeticsParam;
import com.tencent.ttpic.openapi.model.CrazyFaceDataTemplate;
import com.tencent.ttpic.openapi.model.CrazyFaceDataTemplate.ImageLayer;
import com.tencent.ttpic.openapi.model.DistortionItem;
import com.tencent.ttpic.openapi.model.FaceEditParams;
import com.tencent.ttpic.openapi.model.FaceImageLayer;
import com.tencent.ttpic.openapi.model.FilterMaterial;
import com.tencent.ttpic.openapi.model.FilterParam;
import com.tencent.ttpic.openapi.model.MaterialUtil;
import com.tencent.ttpic.openapi.model.MaterialUtil.FIELD;
import com.tencent.ttpic.openapi.model.VideoMaterial.DISTORTION_ITEM_FILED;
import com.tencent.ttpic.util.DecryptListener;
import com.tencent.ttpic.util.GsonUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CfTemplateParser
{
  private static final String POSTFIX_DAT = "dat";
  private static final String POSTFIX_ORIG_JSON = "json";
  private static final String POSTFIX_ORIG_XML = "xml";
  public static final String POSTFIX_WMC = "wmc";
  private static final String TAG = "CfTemplateParser";
  
  private static InputStream drinkACupOfCoffee(InputStream paramInputStream)
  {
    byte[] arrayOfByte = IOUtils.toByteArray(paramInputStream);
    paramInputStream = arrayOfByte;
    if (CfConfig.getDecryptListener() != null) {
      paramInputStream = CfConfig.getDecryptListener().decrypt(arrayOfByte);
    }
    return new ByteArrayInputStream(paramInputStream);
  }
  
  private static BaseFilterMaterial parseBaseFilterMaterial(JsonObject paramJsonObject)
  {
    BaseFilterMaterial localBaseFilterMaterial = new BaseFilterMaterial();
    if (paramJsonObject == null) {
      return localBaseFilterMaterial;
    }
    localBaseFilterMaterial.name = GsonUtils.optString(paramJsonObject, MaterialUtil.FIELD.ENUM.value);
    localBaseFilterMaterial.index = GsonUtils.optInt(paramJsonObject, MaterialUtil.FIELD.INDEX.value);
    localBaseFilterMaterial.params = new ArrayList();
    JsonArray localJsonArray = GsonUtils.optJsonArray(paramJsonObject, MaterialUtil.FIELD.PARAM.value);
    if (localJsonArray != null)
    {
      int i = 0;
      while (i < localJsonArray.size())
      {
        paramJsonObject = parseFilterParam(GsonUtils.optJsonObject(localJsonArray, i));
        if (MaterialUtil.isValid(paramJsonObject)) {
          localBaseFilterMaterial.params.add(paramJsonObject);
        }
        i += 1;
      }
    }
    paramJsonObject = parseFilterParam(GsonUtils.optJsonObject(paramJsonObject, MaterialUtil.FIELD.PARAM.value));
    if (MaterialUtil.isValid(paramJsonObject)) {
      localBaseFilterMaterial.params.add(paramJsonObject);
    }
    return localBaseFilterMaterial;
  }
  
  private static BridgeMaterial parseBridgeMaterial(JsonObject paramJsonObject)
  {
    if (paramJsonObject == null) {
      return null;
    }
    BridgeMaterial localBridgeMaterial = new BridgeMaterial();
    localBridgeMaterial.output = GsonUtils.optInt(paramJsonObject, MaterialUtil.FIELD.OUTPUT.value);
    localBridgeMaterial.input = GsonUtils.optInt(paramJsonObject, MaterialUtil.FIELD.INPUT.value);
    localBridgeMaterial.index = GsonUtils.optInt(paramJsonObject, MaterialUtil.FIELD.INDEX.value);
    return localBridgeMaterial;
  }
  
  public static CosmeticsDataTemplate parseCosmetics(String paramString1, String paramString2)
  {
    paramString2 = parseFile(paramString1, paramString2);
    if (paramString2 == null) {
      return null;
    }
    Object localObject1 = GsonUtils.optJsonObject(paramString2, "cosmetics");
    if (localObject1 == null) {
      return null;
    }
    paramString2 = new CosmeticsDataTemplate();
    Object localObject2 = TAG;
    int i = 0;
    LogUtils.v((String)localObject2, "parsePaint(), rootJson = %s", new Object[] { localObject1 });
    paramString2.folder = paramString1;
    paramString1 = GsonUtils.optJsonArray((JsonObject)localObject1, "params");
    if (paramString1 != null)
    {
      localObject1 = new ArrayList();
      while (i < paramString1.size())
      {
        localObject2 = paramString1.get(i);
        if ((localObject2 instanceof JsonObject))
        {
          localObject2 = (JsonObject)localObject2;
          if ("COS_EYEBROW_ATTACH".equalsIgnoreCase(GsonUtils.optString((JsonObject)localObject2, "enum")))
          {
            localObject2 = parseEyebrowAttach((JsonObject)localObject2);
            if (localObject2 != null) {
              paramString2.eyebrowAttach.putAll((Map)localObject2);
            }
          }
          else
          {
            localObject2 = parseCosmeticsParam((JsonObject)localObject2);
            if (localObject2 != null) {
              ((ArrayList)localObject1).add(localObject2);
            }
          }
        }
        i += 1;
      }
      paramString2.cosmetic_param = ((ArrayList)localObject1);
    }
    return paramString2;
  }
  
  private static CosmeticsDataTemplate.CosmeticsParam parseCosmeticsParam(JsonObject paramJsonObject)
  {
    String str1 = GsonUtils.optString(paramJsonObject, "type", null);
    Object localObject = GsonUtils.optString(paramJsonObject, "enum", null);
    if ((str1 == null) && (localObject == null)) {
      return null;
    }
    CosmeticsDataTemplate.CosmeticsParam localCosmeticsParam = new CosmeticsDataTemplate.CosmeticsParam();
    localCosmeticsParam.cosEnum = ((String)localObject);
    int i;
    if ("image".equals(str1))
    {
      localCosmeticsParam.paramtype = 1;
      localCosmeticsParam.resname = GsonUtils.optString(paramJsonObject, "image", null);
      localCosmeticsParam.resname2 = GsonUtils.optString(paramJsonObject, "image2", null);
      localCosmeticsParam.index = GsonUtils.optInt(paramJsonObject, "index", 0);
      localCosmeticsParam.enumRssWidth = GsonUtils.optInt(paramJsonObject, "coswidth", 0);
    }
    else if ("auto".equals(str1))
    {
      localCosmeticsParam.paramtype = 2;
      localCosmeticsParam.enumId = GsonUtils.optString(paramJsonObject, "name", null);
    }
    else if ("color".equals(str1))
    {
      localCosmeticsParam.paramtype = 0;
      str1 = GsonUtils.optString(paramJsonObject, "color", null);
      if (str1 != null) {
        try
        {
          i = Color.parseColor(str1);
          localCosmeticsParam.red = ((i & 0xFF0000) >> 16);
          localCosmeticsParam.green = ((i & 0xFF00) >> 8);
          localCosmeticsParam.blue = (i & 0xFF);
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          localCosmeticsParam.red = -65536;
          localCosmeticsParam.green = -16711936;
          localCosmeticsParam.blue = -16776961;
        }
      }
      String str2 = GsonUtils.optString(paramJsonObject, "color2", null);
      if (str2 != null) {
        try
        {
          i = Color.parseColor(str2);
          localCosmeticsParam.red2 = ((i & 0xFF0000) >> 16);
          localCosmeticsParam.green2 = ((i & 0xFF00) >> 8);
          localCosmeticsParam.blue2 = (i & 0xFF);
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          localCosmeticsParam.red2 = -65536;
          localCosmeticsParam.green2 = -16711936;
          localCosmeticsParam.blue2 = -16776961;
        }
      }
    }
    else if ("palace".equals(localException2))
    {
      localCosmeticsParam.paramtype = 4;
      localCosmeticsParam.relicsUrl = GsonUtils.optString(paramJsonObject, "relicsUrl");
      localCosmeticsParam.relicsIcon = GsonUtils.optString(paramJsonObject, "relicsIcon");
      localCosmeticsParam.portraitIcon = GsonUtils.optString(paramJsonObject, "portraitIcon");
      LogUtils.v(TAG, "parseFile(), relicsUrl = %s, relicsIcon = %s, portraitIcon = %s", new Object[] { localCosmeticsParam.relicsUrl, localCosmeticsParam.relicsIcon, localCosmeticsParam.portraitIcon });
    }
    label631:
    try
    {
      localJsonArray = GsonUtils.optJsonArray(paramJsonObject, "cosparam");
      if (localJsonArray != null)
      {
        localCosmeticsParam.cosparam = new ArrayList();
        i = 0;
        while (i < localJsonArray.size())
        {
          localObject = localJsonArray.get(i);
          if (((localObject instanceof JsonPrimitive)) && (((JsonPrimitive)localObject).isString())) {
            localCosmeticsParam.cosparam.add(Integer.valueOf(Integer.parseInt(((JsonElement)localObject).getAsString())));
          }
          if (((localObject instanceof JsonPrimitive)) && (((JsonPrimitive)localObject).isNumber())) {
            localCosmeticsParam.cosparam.add(Integer.valueOf(((JsonElement)localObject).getAsInt()));
          }
          i += 1;
        }
      }
    }
    catch (Exception localException3)
    {
      JsonArray localJsonArray;
      label511:
      break label511;
    }
    try
    {
      localJsonArray = GsonUtils.optJsonArray(paramJsonObject, "cosindex");
      if (localJsonArray != null)
      {
        localCosmeticsParam.cosIndex = new ArrayList();
        i = 0;
        while (i < localJsonArray.size())
        {
          localObject = localJsonArray.get(i);
          if (((localObject instanceof JsonPrimitive)) && (((JsonPrimitive)localObject).isString())) {
            localCosmeticsParam.cosIndex.add(Integer.valueOf(Integer.parseInt(((JsonElement)localObject).getAsString())));
          }
          if (((localObject instanceof JsonPrimitive)) && (((JsonPrimitive)localObject).isNumber())) {
            localCosmeticsParam.cosIndex.add(Integer.valueOf(((JsonElement)localObject).getAsInt()));
          }
          i += 1;
        }
      }
    }
    catch (Exception localException4)
    {
      break label631;
    }
    localCosmeticsParam.enumAlpha = GsonUtils.optInt(paramJsonObject, "alpha", -1);
    localCosmeticsParam.enumAlpha2 = GsonUtils.optInt(paramJsonObject, "alpha2", -1);
    localCosmeticsParam.blend = GsonUtils.optInt(paramJsonObject, "blend", 0);
    localCosmeticsParam.blend2 = GsonUtils.optInt(paramJsonObject, "blend2", -1);
    return localCosmeticsParam;
  }
  
  public static CrazyFaceDataTemplate parseCrazyFace(String paramString1, String paramString2)
  {
    Object localObject = VideoTemplateParser.parseVideoMaterialFileAsJSONObject(paramString1, paramString2, true, new CfTemplateParser.1());
    if (localObject == null) {
      return null;
    }
    paramString2 = parseSimpleCrazyFaceJson((JsonObject)localObject, paramString1);
    if (paramString2 == null) {
      return null;
    }
    localObject = GsonUtils.optJsonObject((JsonObject)localObject, "pay");
    if (localObject != null)
    {
      localObject = GsonUtils.optString((JsonObject)localObject, "payPreviewImage");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append("/");
        localStringBuilder.append((String)localObject);
        paramString2.payPreviewImage = localStringBuilder.toString();
      }
    }
    return paramString2;
  }
  
  private static Map<String, ArrayList<CosmeticsDataTemplate.CosmeticsParam>> parseEyebrowAttach(JsonObject paramJsonObject)
  {
    HashMap localHashMap = new HashMap();
    GsonUtils.optString(paramJsonObject, "type");
    JsonArray localJsonArray1 = GsonUtils.optJsonArray(paramJsonObject, "cosparam");
    ArrayList localArrayList1 = new ArrayList();
    int j = 0;
    if (localJsonArray1 != null) {
      i = 0;
    }
    try
    {
      while (i < localJsonArray1.size())
      {
        localObject = localJsonArray1.get(i);
        if (((localObject instanceof JsonPrimitive)) && (((JsonPrimitive)localObject).isString())) {
          localArrayList1.add(Integer.valueOf(Integer.parseInt(((JsonElement)localObject).getAsString())));
        } else if (((localObject instanceof JsonPrimitive)) && (((JsonPrimitive)localObject).isNumber())) {
          localArrayList1.add(Integer.valueOf(((JsonElement)localObject).getAsInt()));
        }
        i += 1;
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      label138:
      JsonArray localJsonArray2;
      break label138;
    }
    localJsonArray1 = GsonUtils.optJsonArray(paramJsonObject, "key");
    localObject = GsonUtils.optJsonArray(paramJsonObject, "shape");
    localJsonArray2 = GsonUtils.optJsonArray(paramJsonObject, "strength");
    paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, "rsc");
    int i = j;
    while (i < localJsonArray1.size())
    {
      String str = GsonUtils.optString(localJsonArray1, i);
      if (!TextUtils.isEmpty(str))
      {
        ArrayList localArrayList2 = new ArrayList();
        CosmeticsDataTemplate.CosmeticsParam localCosmeticsParam = new CosmeticsDataTemplate.CosmeticsParam();
        localCosmeticsParam.cosEnum = "COS_EYEBROW";
        localCosmeticsParam.paramtype = 1;
        localCosmeticsParam.resname = GsonUtils.optString(paramJsonObject, i);
        if (!TextUtils.isEmpty(localCosmeticsParam.resname))
        {
          localCosmeticsParam.cosparam = new ArrayList();
          localCosmeticsParam.cosparam.addAll(localArrayList1);
          localCosmeticsParam.enumAlpha = GsonUtils.optInt(localJsonArray2, i, 50);
          localArrayList2.add(localCosmeticsParam);
          localCosmeticsParam = new CosmeticsDataTemplate.CosmeticsParam();
          localCosmeticsParam.cosEnum = "COS_BROWSHAPING";
          localCosmeticsParam.enumAlpha = GsonUtils.optInt((JsonArray)localObject, i, 30);
          localArrayList2.add(localCosmeticsParam);
          localHashMap.put(str, localArrayList2);
        }
      }
      i += 1;
    }
    return localHashMap;
  }
  
  private static void parseFaceImageLayer(FaceImageLayer paramFaceImageLayer, JsonObject paramJsonObject)
  {
    paramFaceImageLayer.width = GsonUtils.optDouble(paramJsonObject, "width");
    paramFaceImageLayer.height = GsonUtils.optDouble(paramJsonObject, "height");
    paramFaceImageLayer.x = GsonUtils.optDouble(paramJsonObject, "x");
    paramFaceImageLayer.y = GsonUtils.optDouble(paramJsonObject, "y");
    paramFaceImageLayer.type = GsonUtils.optInt(paramJsonObject, "type");
    paramFaceImageLayer.imagePath = GsonUtils.optString(paramJsonObject, "image");
    JsonArray localJsonArray = GsonUtils.optJsonArray(paramJsonObject, "imageFacePoint");
    int k = 0;
    int i;
    if (localJsonArray != null)
    {
      localArrayList = new ArrayList();
      i = 0;
      while (i < localJsonArray.size())
      {
        localArrayList.add(Double.valueOf(GsonUtils.optDouble(localJsonArray, i)));
        i += 1;
      }
      paramFaceImageLayer.imageFacePoint = localArrayList;
    }
    localJsonArray = GsonUtils.optJsonArray(paramJsonObject, "imageFaceColor");
    if (localJsonArray != null)
    {
      localArrayList = new ArrayList();
      i = 0;
      while (i < localJsonArray.size())
      {
        localArrayList.add(Double.valueOf(GsonUtils.optDouble(localJsonArray, i)));
        i += 1;
      }
      paramFaceImageLayer.imageFaceColor = localArrayList;
    }
    localJsonArray = GsonUtils.optJsonArray(paramJsonObject, "imageFaceColor2");
    if (localJsonArray != null)
    {
      localArrayList = new ArrayList();
      i = 0;
      while (i < localJsonArray.size())
      {
        localArrayList.add(Double.valueOf(GsonUtils.optDouble(localJsonArray, i)));
        i += 1;
      }
      paramFaceImageLayer.imageFaceColor2 = localArrayList;
    }
    localJsonArray = GsonUtils.optJsonArray(paramJsonObject, "faceColorRange");
    if (localJsonArray != null)
    {
      localArrayList = new ArrayList();
      i = 0;
      while (i < localJsonArray.size())
      {
        localArrayList.add(Double.valueOf(GsonUtils.optDouble(localJsonArray, i)));
        i += 1;
      }
      paramFaceImageLayer.faceColorRange = localArrayList;
    }
    paramFaceImageLayer.cosFunTemplateFile = GsonUtils.optString(paramJsonObject, "cosmetic");
    paramFaceImageLayer.blendAlpha = GsonUtils.optDouble(paramJsonObject, "blendAlpha", 0.5D);
    paramFaceImageLayer.distortionAlpha = GsonUtils.optDouble(paramJsonObject, "distortionAlpha", 0.5D);
    paramFaceImageLayer.faceTriangleID = GsonUtils.optInt(paramJsonObject, "faceTriangleID", 0);
    localJsonArray = GsonUtils.optJsonArray(paramJsonObject, "distortionList");
    Object localObject1;
    Object localObject2;
    if (localJsonArray != null)
    {
      localArrayList = new ArrayList();
      i = 0;
      while (i < localJsonArray.size())
      {
        localObject1 = localJsonArray.get(i);
        if ((localObject1 instanceof JsonObject))
        {
          localObject1 = (JsonObject)localObject1;
          localObject2 = new DistortionItem();
          ((DistortionItem)localObject2).position = GsonUtils.optInt((JsonObject)localObject1, VideoMaterial.DISTORTION_ITEM_FILED.POSITION.value);
          ((DistortionItem)localObject2).distortion = GsonUtils.optInt((JsonObject)localObject1, VideoMaterial.DISTORTION_ITEM_FILED.DISTORTION.value);
          ((DistortionItem)localObject2).direction = GsonUtils.optInt((JsonObject)localObject1, VideoMaterial.DISTORTION_ITEM_FILED.DIRECTION.value);
          ((DistortionItem)localObject2).radius = ((float)GsonUtils.optDouble((JsonObject)localObject1, VideoMaterial.DISTORTION_ITEM_FILED.RADIUS.value));
          ((DistortionItem)localObject2).strength = ((float)GsonUtils.optDouble((JsonObject)localObject1, VideoMaterial.DISTORTION_ITEM_FILED.STRENGH.value));
          ((DistortionItem)localObject2).x = GsonUtils.optInt((JsonObject)localObject1, VideoMaterial.DISTORTION_ITEM_FILED.X.value, 0);
          ((DistortionItem)localObject2).y = GsonUtils.optInt((JsonObject)localObject1, VideoMaterial.DISTORTION_ITEM_FILED.Y.value, 0);
          ((DistortionItem)localObject2).targetDx = GsonUtils.optInt((JsonObject)localObject1, VideoMaterial.DISTORTION_ITEM_FILED.TARGETDX.value, 0);
          ((DistortionItem)localObject2).targetDy = GsonUtils.optInt((JsonObject)localObject1, VideoMaterial.DISTORTION_ITEM_FILED.TARGETDY.value, 0);
          localArrayList.add(localObject2);
        }
        i += 1;
      }
      paramFaceImageLayer.distortionList = localArrayList;
    }
    paramFaceImageLayer.faceMaskImagePath = GsonUtils.optString(paramJsonObject, "faceMaskImage", null);
    localJsonArray = GsonUtils.optJsonArray(paramJsonObject, "faceMaskFacePoint");
    if (localJsonArray != null)
    {
      localArrayList = new ArrayList();
      i = 0;
      while (i < localJsonArray.size())
      {
        localArrayList.add(Double.valueOf(GsonUtils.optDouble(localJsonArray, i)));
        i += 1;
      }
      paramFaceImageLayer.faceMaskFacePoint = localArrayList;
    }
    localJsonArray = GsonUtils.optJsonArray(paramJsonObject, "faceTriangle");
    if (localJsonArray != null)
    {
      localArrayList = new ArrayList();
      i = 0;
      while (i < localJsonArray.size())
      {
        localArrayList.add(Integer.valueOf(GsonUtils.optInt(localJsonArray, i)));
        i += 1;
      }
      paramFaceImageLayer.faceTriangle = localArrayList;
    }
    localJsonArray = GsonUtils.optJsonArray(paramJsonObject, "extraFacePointsArray");
    ArrayList localArrayList = new ArrayList();
    if (localJsonArray != null)
    {
      i = 0;
      while (i < localJsonArray.size())
      {
        localObject1 = GsonUtils.optJsonArray(localJsonArray, i);
        localObject2 = new ArrayList();
        int j = 0;
        while (j < ((JsonArray)localObject1).size())
        {
          ((List)localObject2).add(Double.valueOf(GsonUtils.optDouble((JsonArray)localObject1, j)));
          j += 1;
        }
        localArrayList.add(localObject2);
        i += 1;
      }
    }
    paramFaceImageLayer.extraFacePointsArray = localArrayList;
    localJsonArray = GsonUtils.optJsonArray(paramJsonObject, "extraDistortionAlphaArray");
    localArrayList = new ArrayList();
    if (localJsonArray != null)
    {
      i = k;
      while (i < localJsonArray.size())
      {
        localArrayList.add(Double.valueOf(GsonUtils.optDouble(localJsonArray, i)));
        i += 1;
      }
    }
    paramFaceImageLayer.extraDistortionAlphaArray = localArrayList;
    paramFaceImageLayer.antiWrinkle = GsonUtils.optDouble(paramJsonObject, "antiWrinkle");
  }
  
  public static JsonObject parseFile(String paramString1, String paramString2)
  {
    return parseFileProcess(paramString1, paramString2);
  }
  
  /* Error */
  private static JsonObject parseFileProcess(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 388	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: pop
    //   14: aload_2
    //   15: ldc_w 395
    //   18: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_2
    //   23: aload_1
    //   24: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_2
    //   29: ldc_w 610
    //   32: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_2
    //   37: ldc 8
    //   39: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_2
    //   44: invokevirtual 398	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: astore_3
    //   48: new 388	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   55: astore_2
    //   56: aload_2
    //   57: aload_0
    //   58: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_2
    //   63: ldc_w 395
    //   66: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload_2
    //   71: aload_1
    //   72: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload_2
    //   77: ldc_w 610
    //   80: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_2
    //   85: ldc 14
    //   87: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_2
    //   92: invokevirtual 398	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: astore 7
    //   97: new 388	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 389	java/lang/StringBuilder:<init>	()V
    //   104: astore_2
    //   105: aload_2
    //   106: aload_0
    //   107: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_2
    //   112: ldc_w 395
    //   115: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload_2
    //   120: aload_1
    //   121: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload_2
    //   126: ldc_w 610
    //   129: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload_2
    //   134: ldc 11
    //   136: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload_2
    //   141: invokevirtual 398	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: astore 4
    //   146: getstatic 159	com/tencent/ttpic/openapi/util/CfTemplateParser:TAG	Ljava/lang/String;
    //   149: ldc_w 612
    //   152: iconst_1
    //   153: anewarray 4	java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: aload_3
    //   159: aastore
    //   160: invokestatic 167	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   163: getstatic 618	com/tencent/ttpic/openapi/model/FileType:DAT	Lcom/tencent/ttpic/openapi/model/FileType;
    //   166: astore_2
    //   167: aconst_null
    //   168: astore 10
    //   170: aconst_null
    //   171: astore 8
    //   173: aconst_null
    //   174: astore 6
    //   176: aconst_null
    //   177: astore 9
    //   179: aconst_null
    //   180: astore 5
    //   182: new 620	java/io/File
    //   185: dup
    //   186: aload_3
    //   187: invokespecial 623	java/io/File:<init>	(Ljava/lang/String;)V
    //   190: astore_0
    //   191: new 620	java/io/File
    //   194: dup
    //   195: aload 7
    //   197: invokespecial 623	java/io/File:<init>	(Ljava/lang/String;)V
    //   200: astore_1
    //   201: new 620	java/io/File
    //   204: dup
    //   205: aload 4
    //   207: invokespecial 623	java/io/File:<init>	(Ljava/lang/String;)V
    //   210: astore 11
    //   212: aload_0
    //   213: invokevirtual 626	java/io/File:exists	()Z
    //   216: ifeq +10 -> 226
    //   219: aload_0
    //   220: invokevirtual 629	java/io/File:isFile	()Z
    //   223: ifne +33 -> 256
    //   226: aload_1
    //   227: invokevirtual 626	java/io/File:exists	()Z
    //   230: ifeq +10 -> 240
    //   233: aload_1
    //   234: invokevirtual 629	java/io/File:isFile	()Z
    //   237: ifne +19 -> 256
    //   240: aload 11
    //   242: invokevirtual 626	java/io/File:exists	()Z
    //   245: ifeq +192 -> 437
    //   248: aload 11
    //   250: invokevirtual 629	java/io/File:isFile	()Z
    //   253: ifeq +184 -> 437
    //   256: getstatic 159	com/tencent/ttpic/openapi/util/CfTemplateParser:TAG	Ljava/lang/String;
    //   259: ldc_w 631
    //   262: invokestatic 634	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   265: aload_0
    //   266: invokevirtual 626	java/io/File:exists	()Z
    //   269: ifeq +22 -> 291
    //   272: aload_0
    //   273: invokevirtual 629	java/io/File:isFile	()Z
    //   276: ifeq +15 -> 291
    //   279: new 636	java/io/FileInputStream
    //   282: dup
    //   283: aload_0
    //   284: invokespecial 639	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   287: astore_0
    //   288: goto +55 -> 343
    //   291: aload_1
    //   292: invokevirtual 626	java/io/File:exists	()Z
    //   295: ifeq +30 -> 325
    //   298: aload_1
    //   299: invokevirtual 629	java/io/File:isFile	()Z
    //   302: ifeq +23 -> 325
    //   305: new 636	java/io/FileInputStream
    //   308: dup
    //   309: aload_1
    //   310: invokespecial 639	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   313: astore_0
    //   314: aload_0
    //   315: astore_1
    //   316: aload_0
    //   317: astore_3
    //   318: getstatic 642	com/tencent/ttpic/openapi/model/FileType:XML	Lcom/tencent/ttpic/openapi/model/FileType;
    //   321: astore_2
    //   322: goto +21 -> 343
    //   325: new 636	java/io/FileInputStream
    //   328: dup
    //   329: aload 11
    //   331: invokespecial 639	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   334: astore_0
    //   335: aload_0
    //   336: astore_1
    //   337: aload_0
    //   338: astore_3
    //   339: getstatic 645	com/tencent/ttpic/openapi/model/FileType:JSON	Lcom/tencent/ttpic/openapi/model/FileType;
    //   342: astore_2
    //   343: aload_0
    //   344: astore_1
    //   345: aload_0
    //   346: astore_3
    //   347: aload_2
    //   348: getstatic 618	com/tencent/ttpic/openapi/model/FileType:DAT	Lcom/tencent/ttpic/openapi/model/FileType;
    //   351: if_acmpne +56 -> 407
    //   354: aload_0
    //   355: astore_1
    //   356: aload_0
    //   357: astore_3
    //   358: aload_0
    //   359: invokestatic 647	com/tencent/ttpic/openapi/util/CfTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;)Ljava/io/InputStream;
    //   362: astore 4
    //   364: aload_0
    //   365: invokestatic 651	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   368: aload_0
    //   369: astore_1
    //   370: aload 4
    //   372: astore_0
    //   373: goto +133 -> 506
    //   376: astore_2
    //   377: aconst_null
    //   378: astore_1
    //   379: aload 4
    //   381: astore_3
    //   382: aload 6
    //   384: astore 5
    //   386: goto +599 -> 985
    //   389: astore_3
    //   390: aconst_null
    //   391: astore_1
    //   392: aload_1
    //   393: astore_2
    //   394: aload 4
    //   396: astore 5
    //   398: aload_3
    //   399: astore 4
    //   401: aload 5
    //   403: astore_3
    //   404: goto +512 -> 916
    //   407: aload_0
    //   408: astore_1
    //   409: goto +161 -> 570
    //   412: astore_2
    //   413: aload_1
    //   414: astore_0
    //   415: aconst_null
    //   416: astore_3
    //   417: aload_3
    //   418: astore_1
    //   419: aload 6
    //   421: astore 5
    //   423: goto +562 -> 985
    //   426: astore 4
    //   428: aload_3
    //   429: astore_0
    //   430: aconst_null
    //   431: astore_3
    //   432: aload_3
    //   433: astore_1
    //   434: goto +480 -> 914
    //   437: getstatic 159	com/tencent/ttpic/openapi/util/CfTemplateParser:TAG	Ljava/lang/String;
    //   440: ldc_w 653
    //   443: invokestatic 634	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   446: invokestatic 659	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   449: invokevirtual 665	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   452: aload_3
    //   453: invokevirtual 671	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   456: astore 11
    //   458: aload 11
    //   460: invokestatic 647	com/tencent/ttpic/openapi/util/CfTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;)Ljava/io/InputStream;
    //   463: astore_0
    //   464: aload_0
    //   465: astore_3
    //   466: aload_0
    //   467: astore_1
    //   468: aload 11
    //   470: invokestatic 651	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   473: aconst_null
    //   474: astore_1
    //   475: goto +95 -> 570
    //   478: aconst_null
    //   479: astore_0
    //   480: aload_0
    //   481: astore_3
    //   482: aload_0
    //   483: astore_1
    //   484: invokestatic 659	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   487: invokevirtual 665	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   490: aload 7
    //   492: invokevirtual 671	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   495: astore_2
    //   496: getstatic 642	com/tencent/ttpic/openapi/model/FileType:XML	Lcom/tencent/ttpic/openapi/model/FileType;
    //   499: astore_3
    //   500: aconst_null
    //   501: astore_1
    //   502: aload_2
    //   503: astore_0
    //   504: aload_3
    //   505: astore_2
    //   506: goto +64 -> 570
    //   509: astore_3
    //   510: aload_2
    //   511: astore 4
    //   513: goto +375 -> 888
    //   516: astore 4
    //   518: goto +390 -> 908
    //   521: aload_2
    //   522: astore_0
    //   523: goto +25 -> 548
    //   526: astore_0
    //   527: aload_3
    //   528: astore 4
    //   530: aload_0
    //   531: astore_3
    //   532: goto +356 -> 888
    //   535: astore 4
    //   537: aconst_null
    //   538: astore_0
    //   539: aload_0
    //   540: astore_2
    //   541: aload_1
    //   542: astore_3
    //   543: aload_2
    //   544: astore_1
    //   545: goto +371 -> 916
    //   548: aload_0
    //   549: astore_3
    //   550: aload_0
    //   551: astore_1
    //   552: invokestatic 659	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   555: invokevirtual 665	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   558: aload 4
    //   560: invokevirtual 671	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   563: astore_0
    //   564: getstatic 645	com/tencent/ttpic/openapi/model/FileType:JSON	Lcom/tencent/ttpic/openapi/model/FileType;
    //   567: astore_2
    //   568: aconst_null
    //   569: astore_1
    //   570: aload_0
    //   571: ifnull +224 -> 795
    //   574: new 673	java/io/InputStreamReader
    //   577: dup
    //   578: aload_0
    //   579: invokespecial 675	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   582: astore_3
    //   583: new 677	java/io/BufferedReader
    //   586: dup
    //   587: aload_3
    //   588: sipush 1024
    //   591: invokespecial 680	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   594: astore 4
    //   596: new 682	java/lang/StringBuffer
    //   599: dup
    //   600: invokespecial 683	java/lang/StringBuffer:<init>	()V
    //   603: astore 5
    //   605: aload 4
    //   607: invokevirtual 686	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   610: astore 6
    //   612: aload 6
    //   614: ifnull +14 -> 628
    //   617: aload 5
    //   619: aload 6
    //   621: invokevirtual 689	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   624: pop
    //   625: goto -20 -> 605
    //   628: aload_2
    //   629: getstatic 642	com/tencent/ttpic/openapi/model/FileType:XML	Lcom/tencent/ttpic/openapi/model/FileType;
    //   632: if_acmpne +26 -> 658
    //   635: new 691	fr/arnaudguyon/xmltojsonlib/XmlToJson$Builder
    //   638: dup
    //   639: aload 5
    //   641: invokevirtual 692	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   644: invokespecial 693	fr/arnaudguyon/xmltojsonlib/XmlToJson$Builder:<init>	(Ljava/lang/String;)V
    //   647: invokevirtual 697	fr/arnaudguyon/xmltojsonlib/XmlToJson$Builder:build	()Lfr/arnaudguyon/xmltojsonlib/XmlToJson;
    //   650: invokevirtual 700	fr/arnaudguyon/xmltojsonlib/XmlToJson:toString	()Ljava/lang/String;
    //   653: astore 7
    //   655: goto +10 -> 665
    //   658: aload 5
    //   660: invokevirtual 692	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   663: astore 7
    //   665: getstatic 159	com/tencent/ttpic/openapi/util/CfTemplateParser:TAG	Ljava/lang/String;
    //   668: aload 7
    //   670: invokestatic 703	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   673: aload 10
    //   675: astore_2
    //   676: aload_3
    //   677: astore 6
    //   679: aload 4
    //   681: astore 5
    //   683: aload 7
    //   685: invokestatic 386	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   688: ifne +117 -> 805
    //   691: aload 7
    //   693: invokestatic 707	com/tencent/ttpic/util/GsonUtils:json2JsonObject	(Ljava/lang/String;)Lcom/google/gson/JsonObject;
    //   696: astore_2
    //   697: aload_3
    //   698: astore 6
    //   700: aload 4
    //   702: astore 5
    //   704: goto +101 -> 805
    //   707: astore_2
    //   708: aload 4
    //   710: astore 5
    //   712: goto +45 -> 757
    //   715: astore 6
    //   717: aload_1
    //   718: astore 5
    //   720: aload_3
    //   721: astore_1
    //   722: aload 4
    //   724: astore_2
    //   725: aload_0
    //   726: astore_3
    //   727: aload 6
    //   729: astore_0
    //   730: goto +56 -> 786
    //   733: astore_2
    //   734: goto +23 -> 757
    //   737: astore 4
    //   739: aconst_null
    //   740: astore_2
    //   741: aload_1
    //   742: astore 5
    //   744: aload_3
    //   745: astore_1
    //   746: aload_0
    //   747: astore_3
    //   748: aload 4
    //   750: astore_0
    //   751: goto +35 -> 786
    //   754: astore_2
    //   755: aconst_null
    //   756: astore_3
    //   757: aload_0
    //   758: astore 4
    //   760: aload_1
    //   761: astore_0
    //   762: aload_3
    //   763: astore_1
    //   764: aload 4
    //   766: astore_3
    //   767: goto +218 -> 985
    //   770: astore_2
    //   771: aload_0
    //   772: astore_3
    //   773: aload_1
    //   774: astore 5
    //   776: aconst_null
    //   777: astore_1
    //   778: aconst_null
    //   779: astore 4
    //   781: aload_2
    //   782: astore_0
    //   783: aload 4
    //   785: astore_2
    //   786: aload_0
    //   787: astore 4
    //   789: aload 5
    //   791: astore_0
    //   792: goto +124 -> 916
    //   795: aconst_null
    //   796: astore 6
    //   798: aload 6
    //   800: astore 5
    //   802: aload 10
    //   804: astore_2
    //   805: aload 5
    //   807: ifnull +14 -> 821
    //   810: aload_2
    //   811: astore 4
    //   813: aload 5
    //   815: invokevirtual 710	java/io/BufferedReader:close	()V
    //   818: goto +3 -> 821
    //   821: aload 6
    //   823: ifnull +11 -> 834
    //   826: aload_2
    //   827: astore 4
    //   829: aload 6
    //   831: invokevirtual 711	java/io/InputStreamReader:close	()V
    //   834: aload_0
    //   835: ifnull +10 -> 845
    //   838: aload_2
    //   839: astore 4
    //   841: aload_0
    //   842: invokevirtual 714	java/io/InputStream:close	()V
    //   845: aload_2
    //   846: astore_3
    //   847: aload_1
    //   848: ifnull +127 -> 975
    //   851: aload_2
    //   852: astore 4
    //   854: aload_1
    //   855: invokevirtual 715	java/io/FileInputStream:close	()V
    //   858: aload_2
    //   859: areturn
    //   860: aload_0
    //   861: invokestatic 719	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   864: aload 4
    //   866: areturn
    //   867: astore_2
    //   868: aconst_null
    //   869: astore_1
    //   870: aload_1
    //   871: astore_3
    //   872: goto -115 -> 757
    //   875: astore_2
    //   876: aconst_null
    //   877: astore 5
    //   879: aload_0
    //   880: astore_3
    //   881: goto -105 -> 776
    //   884: astore_3
    //   885: aconst_null
    //   886: astore 4
    //   888: aconst_null
    //   889: astore_0
    //   890: aconst_null
    //   891: astore_1
    //   892: aload 6
    //   894: astore 5
    //   896: aload_3
    //   897: astore_2
    //   898: aload 4
    //   900: astore_3
    //   901: goto +84 -> 985
    //   904: astore 4
    //   906: aconst_null
    //   907: astore_2
    //   908: aconst_null
    //   909: astore_0
    //   910: aconst_null
    //   911: astore_1
    //   912: aload_2
    //   913: astore_3
    //   914: aload_1
    //   915: astore_2
    //   916: aload 4
    //   918: invokestatic 719	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   921: aload_2
    //   922: ifnull +11 -> 933
    //   925: aload 9
    //   927: astore 4
    //   929: aload_2
    //   930: invokevirtual 710	java/io/BufferedReader:close	()V
    //   933: aload_1
    //   934: ifnull +11 -> 945
    //   937: aload 9
    //   939: astore 4
    //   941: aload_1
    //   942: invokevirtual 711	java/io/InputStreamReader:close	()V
    //   945: aload_3
    //   946: ifnull +11 -> 957
    //   949: aload 9
    //   951: astore 4
    //   953: aload_3
    //   954: invokevirtual 714	java/io/InputStream:close	()V
    //   957: aload 8
    //   959: astore_3
    //   960: aload_0
    //   961: ifnull +14 -> 975
    //   964: aload 9
    //   966: astore 4
    //   968: aload_0
    //   969: invokevirtual 715	java/io/FileInputStream:close	()V
    //   972: aload 8
    //   974: astore_3
    //   975: aload_3
    //   976: areturn
    //   977: astore 4
    //   979: aload_2
    //   980: astore 5
    //   982: aload 4
    //   984: astore_2
    //   985: aload 5
    //   987: ifnull +11 -> 998
    //   990: aload 5
    //   992: invokevirtual 710	java/io/BufferedReader:close	()V
    //   995: goto +3 -> 998
    //   998: aload_1
    //   999: ifnull +7 -> 1006
    //   1002: aload_1
    //   1003: invokevirtual 711	java/io/InputStreamReader:close	()V
    //   1006: aload_3
    //   1007: ifnull +7 -> 1014
    //   1010: aload_3
    //   1011: invokevirtual 714	java/io/InputStream:close	()V
    //   1014: aload_0
    //   1015: ifnull +14 -> 1029
    //   1018: aload_0
    //   1019: invokevirtual 715	java/io/FileInputStream:close	()V
    //   1022: goto +7 -> 1029
    //   1025: aload_0
    //   1026: invokestatic 719	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   1029: goto +5 -> 1034
    //   1032: aload_2
    //   1033: athrow
    //   1034: goto -2 -> 1032
    //   1037: astore_0
    //   1038: goto -560 -> 478
    //   1041: astore_1
    //   1042: goto -562 -> 480
    //   1045: astore_1
    //   1046: goto -498 -> 548
    //   1049: astore_0
    //   1050: goto -529 -> 521
    //   1053: astore_0
    //   1054: goto -194 -> 860
    //   1057: astore_0
    //   1058: goto -33 -> 1025
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1061	0	paramString1	String
    //   0	1061	1	paramString2	String
    //   7	341	2	localObject1	Object
    //   376	1	2	localObject2	Object
    //   393	1	2	str1	String
    //   412	1	2	localObject3	Object
    //   495	202	2	localObject4	Object
    //   707	1	2	localObject5	Object
    //   724	1	2	localObject6	Object
    //   733	1	2	localObject7	Object
    //   740	1	2	localObject8	Object
    //   754	1	2	localObject9	Object
    //   770	12	2	localException1	Exception
    //   785	74	2	localObject10	Object
    //   867	1	2	localObject11	Object
    //   875	1	2	localException2	Exception
    //   897	136	2	localObject12	Object
    //   47	335	3	localObject13	Object
    //   389	10	3	localException3	Exception
    //   403	102	3	localObject14	Object
    //   509	19	3	localObject15	Object
    //   531	350	3	localObject16	Object
    //   884	13	3	localObject17	Object
    //   900	111	3	localObject18	Object
    //   144	256	4	localObject19	Object
    //   426	1	4	localException4	Exception
    //   511	1	4	localObject20	Object
    //   516	1	4	localException5	Exception
    //   528	1	4	localObject21	Object
    //   535	24	4	localException6	Exception
    //   594	129	4	localBufferedReader	java.io.BufferedReader
    //   737	12	4	localException7	Exception
    //   758	141	4	localObject22	Object
    //   904	13	4	localException8	Exception
    //   927	40	4	localObject23	Object
    //   977	6	4	localObject24	Object
    //   180	811	5	localObject25	Object
    //   174	525	6	localObject26	Object
    //   715	13	6	localException9	Exception
    //   796	97	6	localObject27	Object
    //   95	597	7	str2	String
    //   171	802	8	localObject28	Object
    //   177	788	9	localObject29	Object
    //   168	635	10	localObject30	Object
    //   210	259	11	localObject31	Object
    // Exception table:
    //   from	to	target	type
    //   364	368	376	finally
    //   364	368	389	java/lang/Exception
    //   318	322	412	finally
    //   339	343	412	finally
    //   347	354	412	finally
    //   358	364	412	finally
    //   318	322	426	java/lang/Exception
    //   339	343	426	java/lang/Exception
    //   347	354	426	java/lang/Exception
    //   358	364	426	java/lang/Exception
    //   496	500	509	finally
    //   496	500	516	java/lang/Exception
    //   468	473	526	finally
    //   484	496	526	finally
    //   552	564	526	finally
    //   468	473	535	java/lang/Exception
    //   484	496	535	java/lang/Exception
    //   552	564	535	java/lang/Exception
    //   596	605	707	finally
    //   605	612	707	finally
    //   617	625	707	finally
    //   628	655	707	finally
    //   658	665	707	finally
    //   665	673	707	finally
    //   683	697	707	finally
    //   596	605	715	java/lang/Exception
    //   605	612	715	java/lang/Exception
    //   617	625	715	java/lang/Exception
    //   628	655	715	java/lang/Exception
    //   658	665	715	java/lang/Exception
    //   665	673	715	java/lang/Exception
    //   683	697	715	java/lang/Exception
    //   583	596	733	finally
    //   583	596	737	java/lang/Exception
    //   574	583	754	finally
    //   574	583	770	java/lang/Exception
    //   564	568	867	finally
    //   564	568	875	java/lang/Exception
    //   182	226	884	finally
    //   226	240	884	finally
    //   240	256	884	finally
    //   256	288	884	finally
    //   291	314	884	finally
    //   325	335	884	finally
    //   437	446	884	finally
    //   446	464	884	finally
    //   182	226	904	java/lang/Exception
    //   226	240	904	java/lang/Exception
    //   240	256	904	java/lang/Exception
    //   256	288	904	java/lang/Exception
    //   291	314	904	java/lang/Exception
    //   325	335	904	java/lang/Exception
    //   437	446	904	java/lang/Exception
    //   446	464	904	java/lang/Exception
    //   916	921	977	finally
    //   446	464	1037	java/io/IOException
    //   468	473	1041	java/io/IOException
    //   484	496	1045	java/io/IOException
    //   496	500	1049	java/io/IOException
    //   813	818	1053	java/io/IOException
    //   829	834	1053	java/io/IOException
    //   841	845	1053	java/io/IOException
    //   854	858	1053	java/io/IOException
    //   929	933	1053	java/io/IOException
    //   941	945	1053	java/io/IOException
    //   953	957	1053	java/io/IOException
    //   968	972	1053	java/io/IOException
    //   990	995	1057	java/io/IOException
    //   1002	1006	1057	java/io/IOException
    //   1010	1014	1057	java/io/IOException
    //   1018	1022	1057	java/io/IOException
  }
  
  public static FilterMaterial parseFilterMaterial(String paramString1, String paramString2)
  {
    Object localObject = parseFile(FileUtils.getRealPath(paramString1), paramString2);
    paramString2 = new FilterMaterial();
    paramString2.path = paramString1;
    if (localObject == null) {
      return paramString2;
    }
    paramString1 = GsonUtils.optJsonObject((JsonObject)localObject, MaterialUtil.FIELD.FILTER.value);
    if (paramString1 != null)
    {
      paramString2.name = GsonUtils.optString(paramString1, MaterialUtil.FIELD.NAME.value);
      paramString2.thumbnail = GsonUtils.optString(paramString1, MaterialUtil.FIELD.THUMBNAIL.value);
      paramString2.strength = GsonUtils.optInt(paramString1, MaterialUtil.FIELD.STRENGTH.value);
      paramString2.cpuLevel = GsonUtils.optString(paramString1, MaterialUtil.FIELD.CPU_LEVEL.value);
      paramString2.type = MaterialUtil.getFilterType(GsonUtils.optString(paramString1, MaterialUtil.FIELD.TYPE.value));
      paramString2.baseFilterMaterials = new ArrayList();
      localObject = GsonUtils.optJsonArray(paramString1, MaterialUtil.FIELD.BASE_FILTER.value);
      int j = 0;
      int i;
      if (localObject != null)
      {
        i = 0;
        while (i < ((JsonArray)localObject).size())
        {
          BaseFilterMaterial localBaseFilterMaterial = parseBaseFilterMaterial(GsonUtils.optJsonObject((JsonArray)localObject, i));
          if (MaterialUtil.isValid(localBaseFilterMaterial)) {
            paramString2.baseFilterMaterials.add(localBaseFilterMaterial);
          }
          i += 1;
        }
      }
      localObject = parseBaseFilterMaterial(GsonUtils.optJsonObject(paramString1, MaterialUtil.FIELD.BASE_FILTER.value));
      if (MaterialUtil.isValid((BaseFilterMaterial)localObject)) {
        paramString2.baseFilterMaterials.add(localObject);
      }
      localObject = GsonUtils.optJsonArray(paramString1, MaterialUtil.FIELD.BRIDGE.value);
      if (localObject != null)
      {
        i = j;
        while (i < ((JsonArray)localObject).size())
        {
          paramString1 = parseBridgeMaterial(GsonUtils.optJsonObject((JsonArray)localObject, i));
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
      paramString1 = parseBridgeMaterial(GsonUtils.optJsonObject(paramString1, MaterialUtil.FIELD.BRIDGE.value));
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
  
  private static FilterParam parseFilterParam(JsonObject paramJsonObject)
  {
    FilterParam localFilterParam = new FilterParam();
    if (paramJsonObject == null) {
      return localFilterParam;
    }
    localFilterParam.name = GsonUtils.optString(paramJsonObject, MaterialUtil.FIELD.NAME.value);
    localFilterParam.type = GsonUtils.optString(paramJsonObject, MaterialUtil.FIELD.TYPE.value);
    localFilterParam.value = GsonUtils.optString(paramJsonObject, MaterialUtil.FIELD.VALUE.value);
    return localFilterParam;
  }
  
  public static CrazyFaceDataTemplate parseSimpleCrazyFaceJson(JsonObject paramJsonObject, String paramString)
  {
    CrazyFaceDataTemplate localCrazyFaceDataTemplate = new CrazyFaceDataTemplate();
    localCrazyFaceDataTemplate.folderPath = paramString;
    localCrazyFaceDataTemplate.minAppVersion = GsonUtils.optInt(paramJsonObject, "minAppVersion");
    paramString = GsonUtils.optJsonObject(paramJsonObject, "adv");
    if (paramString != null)
    {
      localCrazyFaceDataTemplate.advId = GsonUtils.optString(paramString, "advId");
      localCrazyFaceDataTemplate.advPicUrl = GsonUtils.optString(paramString, "picUrl");
      localCrazyFaceDataTemplate.advActionUrl = GsonUtils.optString(paramString, "actionUrl");
    }
    paramJsonObject = GsonUtils.optJsonObject(paramJsonObject, "canvas");
    if (paramJsonObject == null) {
      return null;
    }
    localCrazyFaceDataTemplate.width = GsonUtils.optInt(paramJsonObject, "width");
    localCrazyFaceDataTemplate.height = GsonUtils.optInt(paramJsonObject, "height");
    paramString = GsonUtils.optJsonObject(paramJsonObject, "foregroundImageLayer");
    Object localObject1;
    if (paramString != null)
    {
      localObject1 = new CrazyFaceDataTemplate.ImageLayer();
      ((CrazyFaceDataTemplate.ImageLayer)localObject1).width = GsonUtils.optDouble(paramString, "width");
      ((CrazyFaceDataTemplate.ImageLayer)localObject1).height = GsonUtils.optDouble(paramString, "height");
      ((CrazyFaceDataTemplate.ImageLayer)localObject1).x = GsonUtils.optDouble(paramString, "x", 0.0D);
      ((CrazyFaceDataTemplate.ImageLayer)localObject1).y = GsonUtils.optDouble(paramString, "y", 0.0D);
      ((CrazyFaceDataTemplate.ImageLayer)localObject1).type = GsonUtils.optInt(paramString, "type");
      ((CrazyFaceDataTemplate.ImageLayer)localObject1).imagePath = GsonUtils.optString(paramString, "image");
      ((CrazyFaceDataTemplate.ImageLayer)localObject1).stkType = GsonUtils.optInt(paramString, "stkType", 1);
      localCrazyFaceDataTemplate.foregroundLayer = ((CrazyFaceDataTemplate.ImageLayer)localObject1);
    }
    paramString = GsonUtils.optJsonObject(paramJsonObject, "backgroundImageLayer");
    if (paramString != null)
    {
      localObject1 = new CrazyFaceDataTemplate.ImageLayer();
      ((CrazyFaceDataTemplate.ImageLayer)localObject1).width = GsonUtils.optDouble(paramString, "width");
      ((CrazyFaceDataTemplate.ImageLayer)localObject1).height = GsonUtils.optDouble(paramString, "height");
      ((CrazyFaceDataTemplate.ImageLayer)localObject1).x = GsonUtils.optDouble(paramString, "x", 0.0D);
      ((CrazyFaceDataTemplate.ImageLayer)localObject1).y = GsonUtils.optDouble(paramString, "y", 0.0D);
      ((CrazyFaceDataTemplate.ImageLayer)localObject1).type = GsonUtils.optInt(paramString, "type");
      ((CrazyFaceDataTemplate.ImageLayer)localObject1).imagePath = GsonUtils.optString(paramString, "image");
      ((CrazyFaceDataTemplate.ImageLayer)localObject1).stkType = GsonUtils.optInt(paramString, "stkType", 1);
      localCrazyFaceDataTemplate.backgroundLayer = ((CrazyFaceDataTemplate.ImageLayer)localObject1);
    }
    paramString = GsonUtils.optJsonObject(paramJsonObject, "faceImageLayer");
    int j = 0;
    int i;
    if (paramString != null)
    {
      localObject1 = new FaceImageLayer();
      parseFaceImageLayer((FaceImageLayer)localObject1, paramString);
      localCrazyFaceDataTemplate.faceLayers.add(localObject1);
      localObject1 = GsonUtils.optString(paramString, "effectFilter", null);
      Object localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(localCrazyFaceDataTemplate.folderPath);
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append((String)localObject1);
        localCrazyFaceDataTemplate.effectFilter = parseFilterMaterial(((StringBuilder)localObject2).toString(), (String)localObject1);
      }
      localCrazyFaceDataTemplate.effectFilterOrder = GsonUtils.optInt(paramString, "effectFilterOrder");
      paramString = GsonUtils.optJsonArray(paramString, "faceEditParamList");
      localObject1 = new FaceEditParams();
      if (paramString != null)
      {
        i = 0;
        while (i < paramString.size())
        {
          localObject2 = GsonUtils.optJsonObject(paramString, i);
          if (localObject2 != null) {
            ((FaceEditParams)localObject1).updateFaceParam(GsonUtils.optString((JsonObject)localObject2, "key"), GsonUtils.optDouble((JsonObject)localObject2, "value"));
          }
          i += 1;
        }
      }
      localCrazyFaceDataTemplate.faceEditParams = ((FaceEditParams)localObject1);
    }
    paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, "additionFaceImageLayer");
    if (paramJsonObject != null)
    {
      i = j;
      while (i < paramJsonObject.size())
      {
        paramString = GsonUtils.optJsonObject(paramJsonObject, i);
        if (paramString != null)
        {
          localObject1 = new FaceImageLayer();
          parseFaceImageLayer((FaceImageLayer)localObject1, paramString);
          localCrazyFaceDataTemplate.faceLayers.add(localObject1);
        }
        i += 1;
      }
    }
    return localCrazyFaceDataTemplate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.CfTemplateParser
 * JD-Core Version:    0.7.0.1
 */