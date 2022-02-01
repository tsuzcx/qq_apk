package com.tencent.ttpic.openapi.util;

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
  private static final String TAG = CfTemplateParser.class.getSimpleName();
  
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
    LogUtils.v(TAG, "parsePaint(), rootJson = %s", new Object[] { localObject1 });
    paramString2.folder = paramString1;
    paramString1 = GsonUtils.optJsonArray((JsonObject)localObject1, "params");
    if (paramString1 != null)
    {
      localObject1 = new ArrayList();
      int i = 0;
      if (i < paramString1.size())
      {
        Object localObject2 = paramString1.get(i);
        if (!(localObject2 instanceof JsonObject)) {}
        for (;;)
        {
          i += 1;
          break;
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
      }
      paramString2.cosmetic_param = ((ArrayList)localObject1);
    }
    return paramString2;
  }
  
  /* Error */
  private static CosmeticsDataTemplate.CosmeticsParam parseCosmeticsParam(JsonObject paramJsonObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 218
    //   3: aconst_null
    //   4: invokestatic 221	com/tencent/ttpic/util/GsonUtils:optString	(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   7: astore_3
    //   8: aload_0
    //   9: ldc 185
    //   11: aconst_null
    //   12: invokestatic 221	com/tencent/ttpic/util/GsonUtils:optString	(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   15: astore 4
    //   17: aload_3
    //   18: ifnonnull +10 -> 28
    //   21: aload 4
    //   23: ifnonnull +5 -> 28
    //   26: aconst_null
    //   27: areturn
    //   28: new 223	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam
    //   31: dup
    //   32: invokespecial 224	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:<init>	()V
    //   35: astore_2
    //   36: aload_2
    //   37: aload 4
    //   39: putfield 227	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:cosEnum	Ljava/lang/String;
    //   42: ldc 229
    //   44: aload_3
    //   45: invokevirtual 232	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   48: ifeq +171 -> 219
    //   51: aload_2
    //   52: iconst_1
    //   53: putfield 235	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:paramtype	I
    //   56: aload_2
    //   57: aload_0
    //   58: ldc 229
    //   60: aconst_null
    //   61: invokestatic 221	com/tencent/ttpic/util/GsonUtils:optString	(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   64: putfield 238	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:resname	Ljava/lang/String;
    //   67: aload_2
    //   68: aload_0
    //   69: ldc 240
    //   71: aconst_null
    //   72: invokestatic 221	com/tencent/ttpic/util/GsonUtils:optString	(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   75: putfield 243	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:resname2	Ljava/lang/String;
    //   78: aload_2
    //   79: aload_0
    //   80: ldc 244
    //   82: iconst_0
    //   83: invokestatic 247	com/tencent/ttpic/util/GsonUtils:optInt	(Lcom/google/gson/JsonObject;Ljava/lang/String;I)I
    //   86: putfield 248	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:index	I
    //   89: aload_2
    //   90: aload_0
    //   91: ldc 250
    //   93: iconst_0
    //   94: invokestatic 247	com/tencent/ttpic/util/GsonUtils:optInt	(Lcom/google/gson/JsonObject;Ljava/lang/String;I)I
    //   97: putfield 253	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:enumRssWidth	I
    //   100: aload_0
    //   101: ldc 255
    //   103: invokestatic 105	com/tencent/ttpic/util/GsonUtils:optJsonArray	(Lcom/google/gson/JsonObject;Ljava/lang/String;)Lcom/google/gson/JsonArray;
    //   106: astore_3
    //   107: aload_3
    //   108: ifnull +405 -> 513
    //   111: aload_2
    //   112: new 93	java/util/ArrayList
    //   115: dup
    //   116: invokespecial 94	java/util/ArrayList:<init>	()V
    //   119: putfield 257	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:cosparam	Ljava/util/ArrayList;
    //   122: iconst_0
    //   123: istore_1
    //   124: iload_1
    //   125: aload_3
    //   126: invokevirtual 111	com/google/gson/JsonArray:size	()I
    //   129: if_icmpge +384 -> 513
    //   132: aload_3
    //   133: iload_1
    //   134: invokevirtual 179	com/google/gson/JsonArray:get	(I)Lcom/google/gson/JsonElement;
    //   137: astore 4
    //   139: aload 4
    //   141: instanceof 259
    //   144: ifeq +33 -> 177
    //   147: aload 4
    //   149: checkcast 259	com/google/gson/JsonPrimitive
    //   152: invokevirtual 263	com/google/gson/JsonPrimitive:isString	()Z
    //   155: ifeq +22 -> 177
    //   158: aload_2
    //   159: getfield 257	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:cosparam	Ljava/util/ArrayList;
    //   162: aload 4
    //   164: invokevirtual 268	com/google/gson/JsonElement:getAsString	()Ljava/lang/String;
    //   167: invokestatic 274	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   170: invokestatic 278	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   173: invokevirtual 210	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   176: pop
    //   177: aload 4
    //   179: instanceof 259
    //   182: ifeq +30 -> 212
    //   185: aload 4
    //   187: checkcast 259	com/google/gson/JsonPrimitive
    //   190: invokevirtual 281	com/google/gson/JsonPrimitive:isNumber	()Z
    //   193: ifeq +19 -> 212
    //   196: aload_2
    //   197: getfield 257	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:cosparam	Ljava/util/ArrayList;
    //   200: aload 4
    //   202: invokevirtual 284	com/google/gson/JsonElement:getAsInt	()I
    //   205: invokestatic 278	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   208: invokevirtual 210	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   211: pop
    //   212: iload_1
    //   213: iconst_1
    //   214: iadd
    //   215: istore_1
    //   216: goto -92 -> 124
    //   219: ldc_w 286
    //   222: aload_3
    //   223: invokevirtual 232	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   226: ifeq +23 -> 249
    //   229: aload_2
    //   230: iconst_2
    //   231: putfield 235	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:paramtype	I
    //   234: aload_2
    //   235: aload_0
    //   236: ldc_w 287
    //   239: aconst_null
    //   240: invokestatic 221	com/tencent/ttpic/util/GsonUtils:optString	(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   243: putfield 290	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:enumId	Ljava/lang/String;
    //   246: goto -146 -> 100
    //   249: ldc_w 292
    //   252: aload_3
    //   253: invokevirtual 232	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   256: ifeq +171 -> 427
    //   259: aload_2
    //   260: iconst_0
    //   261: putfield 235	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:paramtype	I
    //   264: aload_0
    //   265: ldc_w 292
    //   268: aconst_null
    //   269: invokestatic 221	com/tencent/ttpic/util/GsonUtils:optString	(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   272: astore_3
    //   273: aload_3
    //   274: ifnull +41 -> 315
    //   277: aload_3
    //   278: invokestatic 297	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   281: istore_1
    //   282: aload_2
    //   283: ldc_w 298
    //   286: iload_1
    //   287: iand
    //   288: bipush 16
    //   290: ishr
    //   291: putfield 301	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:red	I
    //   294: aload_2
    //   295: ldc_w 302
    //   298: iload_1
    //   299: iand
    //   300: bipush 8
    //   302: ishr
    //   303: putfield 305	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:green	I
    //   306: aload_2
    //   307: iload_1
    //   308: sipush 255
    //   311: iand
    //   312: putfield 308	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:blue	I
    //   315: aload_0
    //   316: ldc_w 310
    //   319: aconst_null
    //   320: invokestatic 221	com/tencent/ttpic/util/GsonUtils:optString	(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   323: astore_3
    //   324: aload_3
    //   325: ifnull -225 -> 100
    //   328: aload_3
    //   329: invokestatic 297	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   332: istore_1
    //   333: aload_2
    //   334: ldc_w 298
    //   337: iload_1
    //   338: iand
    //   339: bipush 16
    //   341: ishr
    //   342: putfield 313	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:red2	I
    //   345: aload_2
    //   346: ldc_w 302
    //   349: iload_1
    //   350: iand
    //   351: bipush 8
    //   353: ishr
    //   354: putfield 316	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:green2	I
    //   357: aload_2
    //   358: iload_1
    //   359: sipush 255
    //   362: iand
    //   363: putfield 319	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:blue2	I
    //   366: goto -266 -> 100
    //   369: astore_3
    //   370: aload_3
    //   371: invokevirtual 322	java/lang/Exception:printStackTrace	()V
    //   374: aload_2
    //   375: ldc_w 323
    //   378: putfield 313	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:red2	I
    //   381: aload_2
    //   382: ldc_w 324
    //   385: putfield 316	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:green2	I
    //   388: aload_2
    //   389: ldc_w 325
    //   392: putfield 319	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:blue2	I
    //   395: goto -295 -> 100
    //   398: astore_3
    //   399: aload_3
    //   400: invokevirtual 322	java/lang/Exception:printStackTrace	()V
    //   403: aload_2
    //   404: ldc_w 323
    //   407: putfield 301	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:red	I
    //   410: aload_2
    //   411: ldc_w 324
    //   414: putfield 305	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:green	I
    //   417: aload_2
    //   418: ldc_w 325
    //   421: putfield 308	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:blue	I
    //   424: goto -109 -> 315
    //   427: ldc_w 327
    //   430: aload_3
    //   431: invokevirtual 232	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   434: ifeq -334 -> 100
    //   437: aload_2
    //   438: iconst_4
    //   439: putfield 235	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:paramtype	I
    //   442: aload_2
    //   443: aload_0
    //   444: ldc_w 329
    //   447: invokestatic 77	com/tencent/ttpic/util/GsonUtils:optString	(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
    //   450: putfield 331	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:relicsUrl	Ljava/lang/String;
    //   453: aload_2
    //   454: aload_0
    //   455: ldc_w 333
    //   458: invokestatic 77	com/tencent/ttpic/util/GsonUtils:optString	(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
    //   461: putfield 335	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:relicsIcon	Ljava/lang/String;
    //   464: aload_2
    //   465: aload_0
    //   466: ldc_w 337
    //   469: invokestatic 77	com/tencent/ttpic/util/GsonUtils:optString	(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;
    //   472: putfield 339	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:portraitIcon	Ljava/lang/String;
    //   475: getstatic 28	com/tencent/ttpic/openapi/util/CfTemplateParser:TAG	Ljava/lang/String;
    //   478: ldc_w 341
    //   481: iconst_3
    //   482: anewarray 4	java/lang/Object
    //   485: dup
    //   486: iconst_0
    //   487: aload_2
    //   488: getfield 331	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:relicsUrl	Ljava/lang/String;
    //   491: aastore
    //   492: dup
    //   493: iconst_1
    //   494: aload_2
    //   495: getfield 335	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:relicsIcon	Ljava/lang/String;
    //   498: aastore
    //   499: dup
    //   500: iconst_2
    //   501: aload_2
    //   502: getfield 339	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:portraitIcon	Ljava/lang/String;
    //   505: aastore
    //   506: invokestatic 171	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   509: goto -409 -> 100
    //   512: astore_3
    //   513: aload_0
    //   514: ldc_w 343
    //   517: invokestatic 105	com/tencent/ttpic/util/GsonUtils:optJsonArray	(Lcom/google/gson/JsonObject;Ljava/lang/String;)Lcom/google/gson/JsonArray;
    //   520: astore_3
    //   521: aload_3
    //   522: ifnull +112 -> 634
    //   525: aload_2
    //   526: new 93	java/util/ArrayList
    //   529: dup
    //   530: invokespecial 94	java/util/ArrayList:<init>	()V
    //   533: putfield 346	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:cosIndex	Ljava/util/ArrayList;
    //   536: iconst_0
    //   537: istore_1
    //   538: iload_1
    //   539: aload_3
    //   540: invokevirtual 111	com/google/gson/JsonArray:size	()I
    //   543: if_icmpge +91 -> 634
    //   546: aload_3
    //   547: iload_1
    //   548: invokevirtual 179	com/google/gson/JsonArray:get	(I)Lcom/google/gson/JsonElement;
    //   551: astore 4
    //   553: aload 4
    //   555: instanceof 259
    //   558: ifeq +33 -> 591
    //   561: aload 4
    //   563: checkcast 259	com/google/gson/JsonPrimitive
    //   566: invokevirtual 263	com/google/gson/JsonPrimitive:isString	()Z
    //   569: ifeq +22 -> 591
    //   572: aload_2
    //   573: getfield 346	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:cosIndex	Ljava/util/ArrayList;
    //   576: aload 4
    //   578: invokevirtual 268	com/google/gson/JsonElement:getAsString	()Ljava/lang/String;
    //   581: invokestatic 274	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   584: invokestatic 278	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   587: invokevirtual 210	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   590: pop
    //   591: aload 4
    //   593: instanceof 259
    //   596: ifeq +30 -> 626
    //   599: aload 4
    //   601: checkcast 259	com/google/gson/JsonPrimitive
    //   604: invokevirtual 281	com/google/gson/JsonPrimitive:isNumber	()Z
    //   607: ifeq +19 -> 626
    //   610: aload_2
    //   611: getfield 346	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:cosIndex	Ljava/util/ArrayList;
    //   614: aload 4
    //   616: invokevirtual 284	com/google/gson/JsonElement:getAsInt	()I
    //   619: invokestatic 278	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   622: invokevirtual 210	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   625: pop
    //   626: iload_1
    //   627: iconst_1
    //   628: iadd
    //   629: istore_1
    //   630: goto -92 -> 538
    //   633: astore_3
    //   634: aload_2
    //   635: aload_0
    //   636: ldc_w 348
    //   639: iconst_m1
    //   640: invokestatic 247	com/tencent/ttpic/util/GsonUtils:optInt	(Lcom/google/gson/JsonObject;Ljava/lang/String;I)I
    //   643: putfield 351	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:enumAlpha	I
    //   646: aload_2
    //   647: aload_0
    //   648: ldc_w 353
    //   651: iconst_m1
    //   652: invokestatic 247	com/tencent/ttpic/util/GsonUtils:optInt	(Lcom/google/gson/JsonObject;Ljava/lang/String;I)I
    //   655: putfield 356	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:enumAlpha2	I
    //   658: aload_2
    //   659: aload_0
    //   660: ldc_w 358
    //   663: iconst_0
    //   664: invokestatic 247	com/tencent/ttpic/util/GsonUtils:optInt	(Lcom/google/gson/JsonObject;Ljava/lang/String;I)I
    //   667: putfield 360	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:blend	I
    //   670: aload_2
    //   671: aload_0
    //   672: ldc_w 362
    //   675: iconst_m1
    //   676: invokestatic 247	com/tencent/ttpic/util/GsonUtils:optInt	(Lcom/google/gson/JsonObject;Ljava/lang/String;I)I
    //   679: putfield 364	com/tencent/ttpic/openapi/model/CosmeticsDataTemplate$CosmeticsParam:blend2	I
    //   682: aload_2
    //   683: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	684	0	paramJsonObject	JsonObject
    //   123	507	1	i	int
    //   35	648	2	localCosmeticsParam	CosmeticsDataTemplate.CosmeticsParam
    //   7	322	3	localObject1	Object
    //   369	2	3	localException1	Exception
    //   398	33	3	localException2	Exception
    //   512	1	3	localException3	Exception
    //   520	27	3	localJsonArray	JsonArray
    //   633	1	3	localException4	Exception
    //   15	600	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   328	366	369	java/lang/Exception
    //   277	315	398	java/lang/Exception
    //   100	107	512	java/lang/Exception
    //   111	122	512	java/lang/Exception
    //   124	177	512	java/lang/Exception
    //   177	212	512	java/lang/Exception
    //   513	521	633	java/lang/Exception
    //   525	536	633	java/lang/Exception
    //   538	591	633	java/lang/Exception
    //   591	626	633	java/lang/Exception
  }
  
  public static CrazyFaceDataTemplate parseCrazyFace(String paramString1, String paramString2)
  {
    Object localObject = VideoTemplateParser.parseVideoMaterialFileAsJSONObject(paramString1, paramString2, true, new CfTemplateParser.1());
    if (localObject == null) {}
    do
    {
      return null;
      paramString2 = parseSimpleCrazyFaceJson((JsonObject)localObject, paramString1);
    } while (paramString2 == null);
    localObject = GsonUtils.optJsonObject((JsonObject)localObject, "pay");
    if (localObject != null)
    {
      localObject = GsonUtils.optString((JsonObject)localObject, "payPreviewImage");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramString2.payPreviewImage = (paramString1 + "/" + (String)localObject);
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
    int i;
    if (localJsonArray1 != null) {
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i < localJsonArray1.size())
        {
          localObject = localJsonArray1.get(i);
          if (((localObject instanceof JsonPrimitive)) && (((JsonPrimitive)localObject).isString())) {
            localArrayList1.add(Integer.valueOf(Integer.parseInt(((JsonElement)localObject).getAsString())));
          } else if (((localObject instanceof JsonPrimitive)) && (((JsonPrimitive)localObject).isNumber())) {
            localArrayList1.add(Integer.valueOf(((JsonElement)localObject).getAsInt()));
          }
        }
      }
      catch (Exception localException) {}
      JsonArray localJsonArray2 = GsonUtils.optJsonArray(paramJsonObject, "key");
      Object localObject = GsonUtils.optJsonArray(paramJsonObject, "shape");
      JsonArray localJsonArray3 = GsonUtils.optJsonArray(paramJsonObject, "strength");
      paramJsonObject = GsonUtils.optJsonArray(paramJsonObject, "rsc");
      i = 0;
      if (i < localJsonArray2.size())
      {
        String str = GsonUtils.optString(localJsonArray2, i);
        if (TextUtils.isEmpty(str)) {}
        for (;;)
        {
          i += 1;
          break;
          ArrayList localArrayList2 = new ArrayList();
          CosmeticsDataTemplate.CosmeticsParam localCosmeticsParam = new CosmeticsDataTemplate.CosmeticsParam();
          localCosmeticsParam.cosEnum = "COS_EYEBROW";
          localCosmeticsParam.paramtype = 1;
          localCosmeticsParam.resname = GsonUtils.optString(paramJsonObject, i);
          if (!TextUtils.isEmpty(localCosmeticsParam.resname))
          {
            localCosmeticsParam.cosparam = new ArrayList();
            localCosmeticsParam.cosparam.addAll(localArrayList1);
            localCosmeticsParam.enumAlpha = GsonUtils.optInt(localJsonArray3, i, 50);
            localArrayList2.add(localCosmeticsParam);
            localCosmeticsParam = new CosmeticsDataTemplate.CosmeticsParam();
            localCosmeticsParam.cosEnum = "COS_BROWSHAPING";
            localCosmeticsParam.enumAlpha = GsonUtils.optInt((JsonArray)localObject, i, 30);
            localArrayList2.add(localCosmeticsParam);
            localHashMap.put(str, localArrayList2);
          }
        }
      }
      return localHashMap;
      i += 1;
    }
  }
  
  private static void parseFaceImageLayer(FaceImageLayer paramFaceImageLayer, JsonObject paramJsonObject)
  {
    int k = 0;
    paramFaceImageLayer.width = GsonUtils.optDouble(paramJsonObject, "width");
    paramFaceImageLayer.height = GsonUtils.optDouble(paramJsonObject, "height");
    paramFaceImageLayer.x = GsonUtils.optDouble(paramJsonObject, "x");
    paramFaceImageLayer.y = GsonUtils.optDouble(paramJsonObject, "y");
    paramFaceImageLayer.type = GsonUtils.optInt(paramJsonObject, "type");
    paramFaceImageLayer.imagePath = GsonUtils.optString(paramJsonObject, "image");
    JsonArray localJsonArray = GsonUtils.optJsonArray(paramJsonObject, "imageFacePoint");
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
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 12
    //   6: new 391	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   13: aload_0
    //   14: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc_w 398
    //   20: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc_w 613
    //   30: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 8
    //   35: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: astore_2
    //   42: new 391	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   49: aload_0
    //   50: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc_w 398
    //   56: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_1
    //   60: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: ldc_w 613
    //   66: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc 14
    //   71: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: astore 4
    //   79: new 391	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 392	java/lang/StringBuilder:<init>	()V
    //   86: aload_0
    //   87: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc_w 398
    //   93: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_1
    //   97: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: ldc_w 613
    //   103: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc 11
    //   108: invokevirtual 396	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: astore 5
    //   116: getstatic 28	com/tencent/ttpic/openapi/util/CfTemplateParser:TAG	Ljava/lang/String;
    //   119: ldc_w 615
    //   122: iconst_1
    //   123: anewarray 4	java/lang/Object
    //   126: dup
    //   127: iconst_0
    //   128: aload_2
    //   129: aastore
    //   130: invokestatic 171	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: getstatic 621	com/tencent/ttpic/openapi/model/FileType:DAT	Lcom/tencent/ttpic/openapi/model/FileType;
    //   136: astore_3
    //   137: new 623	java/io/File
    //   140: dup
    //   141: aload_2
    //   142: invokespecial 626	java/io/File:<init>	(Ljava/lang/String;)V
    //   145: astore_0
    //   146: new 623	java/io/File
    //   149: dup
    //   150: aload 4
    //   152: invokespecial 626	java/io/File:<init>	(Ljava/lang/String;)V
    //   155: astore_1
    //   156: new 623	java/io/File
    //   159: dup
    //   160: aload 5
    //   162: invokespecial 626	java/io/File:<init>	(Ljava/lang/String;)V
    //   165: astore 6
    //   167: aload_0
    //   168: invokevirtual 629	java/io/File:exists	()Z
    //   171: ifeq +10 -> 181
    //   174: aload_0
    //   175: invokevirtual 632	java/io/File:isFile	()Z
    //   178: ifne +33 -> 211
    //   181: aload_1
    //   182: invokevirtual 629	java/io/File:exists	()Z
    //   185: ifeq +10 -> 195
    //   188: aload_1
    //   189: invokevirtual 632	java/io/File:isFile	()Z
    //   192: ifne +19 -> 211
    //   195: aload 6
    //   197: invokevirtual 629	java/io/File:exists	()Z
    //   200: ifeq +296 -> 496
    //   203: aload 6
    //   205: invokevirtual 632	java/io/File:isFile	()Z
    //   208: ifeq +288 -> 496
    //   211: getstatic 28	com/tencent/ttpic/openapi/util/CfTemplateParser:TAG	Ljava/lang/String;
    //   214: ldc_w 634
    //   217: invokestatic 637	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: aload_0
    //   221: invokevirtual 629	java/io/File:exists	()Z
    //   224: ifeq +207 -> 431
    //   227: aload_0
    //   228: invokevirtual 632	java/io/File:isFile	()Z
    //   231: ifeq +200 -> 431
    //   234: new 639	java/io/FileInputStream
    //   237: dup
    //   238: aload_0
    //   239: invokespecial 642	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   242: astore_0
    //   243: aload_3
    //   244: astore_2
    //   245: aload_0
    //   246: astore 4
    //   248: aload_0
    //   249: astore_1
    //   250: aload_2
    //   251: getstatic 621	com/tencent/ttpic/openapi/model/FileType:DAT	Lcom/tencent/ttpic/openapi/model/FileType;
    //   254: if_acmpne +234 -> 488
    //   257: aload_0
    //   258: astore 4
    //   260: aload_0
    //   261: astore_1
    //   262: aload_0
    //   263: invokestatic 644	com/tencent/ttpic/openapi/util/CfTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;)Ljava/io/InputStream;
    //   266: astore_3
    //   267: aload_0
    //   268: invokestatic 648	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   271: aload_3
    //   272: astore_1
    //   273: aload_0
    //   274: astore 4
    //   276: aload_1
    //   277: ifnull +798 -> 1075
    //   280: new 650	java/io/InputStreamReader
    //   283: dup
    //   284: aload_1
    //   285: invokespecial 652	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   288: astore_3
    //   289: new 654	java/io/BufferedReader
    //   292: dup
    //   293: aload_3
    //   294: sipush 1024
    //   297: invokespecial 657	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   300: astore_0
    //   301: aload 4
    //   303: astore 8
    //   305: aload_3
    //   306: astore 7
    //   308: aload_0
    //   309: astore 6
    //   311: aload_1
    //   312: astore 5
    //   314: new 659	java/lang/StringBuffer
    //   317: dup
    //   318: invokespecial 660	java/lang/StringBuffer:<init>	()V
    //   321: astore 10
    //   323: aload 4
    //   325: astore 8
    //   327: aload_3
    //   328: astore 7
    //   330: aload_0
    //   331: astore 6
    //   333: aload_1
    //   334: astore 5
    //   336: aload_0
    //   337: invokevirtual 663	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   340: astore 11
    //   342: aload 11
    //   344: ifnull +270 -> 614
    //   347: aload 4
    //   349: astore 8
    //   351: aload_3
    //   352: astore 7
    //   354: aload_0
    //   355: astore 6
    //   357: aload_1
    //   358: astore 5
    //   360: aload 10
    //   362: aload 11
    //   364: invokevirtual 666	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   367: pop
    //   368: goto -45 -> 323
    //   371: astore_2
    //   372: aload 4
    //   374: astore 8
    //   376: aload_3
    //   377: astore 7
    //   379: aload_0
    //   380: astore 6
    //   382: aload_1
    //   383: astore 5
    //   385: aload_2
    //   386: invokestatic 670	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   389: aload_0
    //   390: ifnull +7 -> 397
    //   393: aload_0
    //   394: invokevirtual 673	java/io/BufferedReader:close	()V
    //   397: aload_3
    //   398: ifnull +7 -> 405
    //   401: aload_3
    //   402: invokevirtual 674	java/io/InputStreamReader:close	()V
    //   405: aload_1
    //   406: ifnull +7 -> 413
    //   409: aload_1
    //   410: invokevirtual 677	java/io/InputStream:close	()V
    //   413: aload 12
    //   415: astore_0
    //   416: aload 4
    //   418: ifnull +11 -> 429
    //   421: aload 4
    //   423: invokevirtual 678	java/io/FileInputStream:close	()V
    //   426: aload 12
    //   428: astore_0
    //   429: aload_0
    //   430: areturn
    //   431: aload_1
    //   432: invokevirtual 629	java/io/File:exists	()Z
    //   435: ifeq +31 -> 466
    //   438: aload_1
    //   439: invokevirtual 632	java/io/File:isFile	()Z
    //   442: ifeq +24 -> 466
    //   445: new 639	java/io/FileInputStream
    //   448: dup
    //   449: aload_1
    //   450: invokespecial 642	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   453: astore_0
    //   454: aload_0
    //   455: astore 4
    //   457: aload_0
    //   458: astore_1
    //   459: getstatic 681	com/tencent/ttpic/openapi/model/FileType:XML	Lcom/tencent/ttpic/openapi/model/FileType;
    //   462: astore_2
    //   463: goto -218 -> 245
    //   466: new 639	java/io/FileInputStream
    //   469: dup
    //   470: aload 6
    //   472: invokespecial 642	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   475: astore_0
    //   476: aload_0
    //   477: astore 4
    //   479: aload_0
    //   480: astore_1
    //   481: getstatic 684	com/tencent/ttpic/openapi/model/FileType:JSON	Lcom/tencent/ttpic/openapi/model/FileType;
    //   484: astore_2
    //   485: goto -240 -> 245
    //   488: aload_0
    //   489: astore_1
    //   490: aload_0
    //   491: astore 4
    //   493: goto -217 -> 276
    //   496: getstatic 28	com/tencent/ttpic/openapi/util/CfTemplateParser:TAG	Ljava/lang/String;
    //   499: ldc_w 686
    //   502: invokestatic 637	com/tencent/ttpic/baseutils/log/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   505: invokestatic 692	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   508: invokevirtual 698	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   511: aload_2
    //   512: invokevirtual 704	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   515: astore 6
    //   517: aload 6
    //   519: invokestatic 644	com/tencent/ttpic/openapi/util/CfTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;)Ljava/io/InputStream;
    //   522: astore_2
    //   523: aload_2
    //   524: astore_0
    //   525: aload_2
    //   526: astore_1
    //   527: aload 6
    //   529: invokestatic 648	com/tencent/ttpic/baseutils/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   532: aload_2
    //   533: astore_1
    //   534: aload_3
    //   535: astore_2
    //   536: aconst_null
    //   537: astore 4
    //   539: goto -263 -> 276
    //   542: astore_0
    //   543: aconst_null
    //   544: astore_1
    //   545: aload_1
    //   546: astore_2
    //   547: aload_1
    //   548: astore_0
    //   549: invokestatic 692	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   552: invokevirtual 698	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   555: aload 4
    //   557: invokevirtual 704	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   560: astore_3
    //   561: aload_3
    //   562: astore_2
    //   563: aload_3
    //   564: astore_0
    //   565: aload_3
    //   566: astore_1
    //   567: getstatic 681	com/tencent/ttpic/openapi/model/FileType:XML	Lcom/tencent/ttpic/openapi/model/FileType;
    //   570: astore 4
    //   572: aload_3
    //   573: astore_1
    //   574: aload 4
    //   576: astore_2
    //   577: aconst_null
    //   578: astore 4
    //   580: goto -304 -> 276
    //   583: astore_0
    //   584: aload_2
    //   585: astore_0
    //   586: aload_2
    //   587: astore_1
    //   588: invokestatic 692	com/tencent/aekit/api/standard/AEModule:getContext	()Landroid/content/Context;
    //   591: invokevirtual 698	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   594: aload 5
    //   596: invokevirtual 704	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   599: astore_2
    //   600: getstatic 684	com/tencent/ttpic/openapi/model/FileType:JSON	Lcom/tencent/ttpic/openapi/model/FileType;
    //   603: astore_0
    //   604: aload_2
    //   605: astore_1
    //   606: aconst_null
    //   607: astore 4
    //   609: aload_0
    //   610: astore_2
    //   611: goto -335 -> 276
    //   614: aload 4
    //   616: astore 8
    //   618: aload_3
    //   619: astore 7
    //   621: aload_0
    //   622: astore 6
    //   624: aload_1
    //   625: astore 5
    //   627: aload_2
    //   628: getstatic 681	com/tencent/ttpic/openapi/model/FileType:XML	Lcom/tencent/ttpic/openapi/model/FileType;
    //   631: if_acmpne +161 -> 792
    //   634: aload 4
    //   636: astore 8
    //   638: aload_3
    //   639: astore 7
    //   641: aload_0
    //   642: astore 6
    //   644: aload_1
    //   645: astore 5
    //   647: new 706	fr/arnaudguyon/xmltojsonlib/XmlToJson$Builder
    //   650: dup
    //   651: aload 10
    //   653: invokevirtual 707	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   656: invokespecial 708	fr/arnaudguyon/xmltojsonlib/XmlToJson$Builder:<init>	(Ljava/lang/String;)V
    //   659: invokevirtual 712	fr/arnaudguyon/xmltojsonlib/XmlToJson$Builder:build	()Lfr/arnaudguyon/xmltojsonlib/XmlToJson;
    //   662: invokevirtual 715	fr/arnaudguyon/xmltojsonlib/XmlToJson:toString	()Ljava/lang/String;
    //   665: astore 10
    //   667: aload 4
    //   669: astore 8
    //   671: aload_3
    //   672: astore 7
    //   674: aload_0
    //   675: astore 6
    //   677: aload_1
    //   678: astore 5
    //   680: getstatic 28	com/tencent/ttpic/openapi/util/CfTemplateParser:TAG	Ljava/lang/String;
    //   683: aload 10
    //   685: invokestatic 718	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   688: aload 9
    //   690: astore_2
    //   691: aload_3
    //   692: astore 9
    //   694: aload_0
    //   695: astore 11
    //   697: aload 4
    //   699: astore 8
    //   701: aload_3
    //   702: astore 7
    //   704: aload_0
    //   705: astore 6
    //   707: aload_1
    //   708: astore 5
    //   710: aload 10
    //   712: invokestatic 389	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   715: ifne +28 -> 743
    //   718: aload 4
    //   720: astore 8
    //   722: aload_3
    //   723: astore 7
    //   725: aload_0
    //   726: astore 6
    //   728: aload_1
    //   729: astore 5
    //   731: aload 10
    //   733: invokestatic 722	com/tencent/ttpic/util/GsonUtils:json2JsonObject	(Ljava/lang/String;)Lcom/google/gson/JsonObject;
    //   736: astore_2
    //   737: aload_0
    //   738: astore 11
    //   740: aload_3
    //   741: astore 9
    //   743: aload 11
    //   745: ifnull +8 -> 753
    //   748: aload 11
    //   750: invokevirtual 673	java/io/BufferedReader:close	()V
    //   753: aload 9
    //   755: ifnull +8 -> 763
    //   758: aload 9
    //   760: invokevirtual 674	java/io/InputStreamReader:close	()V
    //   763: aload_1
    //   764: ifnull +7 -> 771
    //   767: aload_1
    //   768: invokevirtual 677	java/io/InputStream:close	()V
    //   771: aload_2
    //   772: astore_0
    //   773: aload 4
    //   775: ifnull -346 -> 429
    //   778: aload 4
    //   780: invokevirtual 678	java/io/FileInputStream:close	()V
    //   783: aload_2
    //   784: areturn
    //   785: astore_0
    //   786: aload_0
    //   787: invokestatic 670	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   790: aload_2
    //   791: areturn
    //   792: aload 4
    //   794: astore 8
    //   796: aload_3
    //   797: astore 7
    //   799: aload_0
    //   800: astore 6
    //   802: aload_1
    //   803: astore 5
    //   805: aload 10
    //   807: invokevirtual 707	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   810: astore 10
    //   812: goto -145 -> 667
    //   815: astore_0
    //   816: aload_0
    //   817: invokestatic 670	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   820: aconst_null
    //   821: areturn
    //   822: astore_2
    //   823: aconst_null
    //   824: astore 4
    //   826: aconst_null
    //   827: astore_0
    //   828: aconst_null
    //   829: astore_3
    //   830: aconst_null
    //   831: astore_1
    //   832: aload_3
    //   833: ifnull +7 -> 840
    //   836: aload_3
    //   837: invokevirtual 673	java/io/BufferedReader:close	()V
    //   840: aload_0
    //   841: ifnull +7 -> 848
    //   844: aload_0
    //   845: invokevirtual 674	java/io/InputStreamReader:close	()V
    //   848: aload_1
    //   849: ifnull +7 -> 856
    //   852: aload_1
    //   853: invokevirtual 677	java/io/InputStream:close	()V
    //   856: aload 4
    //   858: ifnull +8 -> 866
    //   861: aload 4
    //   863: invokevirtual 678	java/io/FileInputStream:close	()V
    //   866: aload_2
    //   867: athrow
    //   868: astore_0
    //   869: aload_0
    //   870: invokestatic 670	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   873: goto -7 -> 866
    //   876: astore_2
    //   877: aconst_null
    //   878: astore_0
    //   879: aconst_null
    //   880: astore_3
    //   881: aconst_null
    //   882: astore_1
    //   883: goto -51 -> 832
    //   886: astore_2
    //   887: aconst_null
    //   888: astore 5
    //   890: aload_3
    //   891: astore_1
    //   892: aconst_null
    //   893: astore_3
    //   894: aload_0
    //   895: astore 4
    //   897: aload_3
    //   898: astore_0
    //   899: aload 5
    //   901: astore_3
    //   902: goto -70 -> 832
    //   905: astore_2
    //   906: aconst_null
    //   907: astore 5
    //   909: aconst_null
    //   910: astore_3
    //   911: aload_0
    //   912: astore_1
    //   913: aconst_null
    //   914: astore 4
    //   916: aload 5
    //   918: astore_0
    //   919: goto -87 -> 832
    //   922: astore 5
    //   924: aconst_null
    //   925: astore_0
    //   926: aconst_null
    //   927: astore_3
    //   928: aload_2
    //   929: astore_1
    //   930: aconst_null
    //   931: astore 4
    //   933: aload 5
    //   935: astore_2
    //   936: goto -104 -> 832
    //   939: astore_2
    //   940: aconst_null
    //   941: astore_0
    //   942: aconst_null
    //   943: astore_3
    //   944: goto -112 -> 832
    //   947: astore_2
    //   948: aconst_null
    //   949: astore 5
    //   951: aload_3
    //   952: astore_0
    //   953: aload 5
    //   955: astore_3
    //   956: goto -124 -> 832
    //   959: astore_2
    //   960: aload 8
    //   962: astore 4
    //   964: aload 7
    //   966: astore_0
    //   967: aload 6
    //   969: astore_3
    //   970: aload 5
    //   972: astore_1
    //   973: goto -141 -> 832
    //   976: astore_2
    //   977: aconst_null
    //   978: astore 4
    //   980: aconst_null
    //   981: astore_3
    //   982: aconst_null
    //   983: astore_0
    //   984: aconst_null
    //   985: astore_1
    //   986: goto -614 -> 372
    //   989: astore_2
    //   990: aconst_null
    //   991: astore_3
    //   992: aconst_null
    //   993: astore_0
    //   994: aconst_null
    //   995: astore 5
    //   997: aload_1
    //   998: astore 4
    //   1000: aload 5
    //   1002: astore_1
    //   1003: goto -631 -> 372
    //   1006: astore_2
    //   1007: aconst_null
    //   1008: astore 5
    //   1010: aload_3
    //   1011: astore_1
    //   1012: aconst_null
    //   1013: astore_3
    //   1014: aload_0
    //   1015: astore 4
    //   1017: aload 5
    //   1019: astore_0
    //   1020: goto -648 -> 372
    //   1023: astore_2
    //   1024: aconst_null
    //   1025: astore_3
    //   1026: aconst_null
    //   1027: astore_0
    //   1028: aconst_null
    //   1029: astore 4
    //   1031: goto -659 -> 372
    //   1034: astore 4
    //   1036: aconst_null
    //   1037: astore_3
    //   1038: aconst_null
    //   1039: astore_0
    //   1040: aload_2
    //   1041: astore_1
    //   1042: aconst_null
    //   1043: astore 5
    //   1045: aload 4
    //   1047: astore_2
    //   1048: aload 5
    //   1050: astore 4
    //   1052: goto -680 -> 372
    //   1055: astore_2
    //   1056: aconst_null
    //   1057: astore_3
    //   1058: aconst_null
    //   1059: astore_0
    //   1060: goto -688 -> 372
    //   1063: astore_2
    //   1064: aconst_null
    //   1065: astore_0
    //   1066: goto -694 -> 372
    //   1069: astore_0
    //   1070: aload_2
    //   1071: astore_1
    //   1072: goto -527 -> 545
    //   1075: aconst_null
    //   1076: astore_0
    //   1077: aconst_null
    //   1078: astore 11
    //   1080: aload 9
    //   1082: astore_2
    //   1083: aload_0
    //   1084: astore 9
    //   1086: goto -343 -> 743
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1089	0	paramString1	String
    //   0	1089	1	paramString2	String
    //   41	210	2	localObject1	Object
    //   371	15	2	localException1	Exception
    //   462	329	2	localObject2	Object
    //   822	45	2	localObject3	Object
    //   876	1	2	localObject4	Object
    //   886	1	2	localObject5	Object
    //   905	24	2	localObject6	Object
    //   935	1	2	localObject7	Object
    //   939	1	2	localObject8	Object
    //   947	1	2	localObject9	Object
    //   959	1	2	localObject10	Object
    //   976	1	2	localException2	Exception
    //   989	1	2	localException3	Exception
    //   1006	1	2	localException4	Exception
    //   1023	18	2	localException5	Exception
    //   1047	1	2	localObject11	Object
    //   1055	1	2	localException6	Exception
    //   1063	8	2	localException7	Exception
    //   1082	1	2	localObject12	Object
    //   136	922	3	localObject13	Object
    //   77	953	4	localObject14	Object
    //   1034	12	4	localException8	Exception
    //   1050	1	4	localObject15	Object
    //   114	803	5	str1	String
    //   922	12	5	localObject16	Object
    //   949	100	5	localObject17	Object
    //   165	803	6	localObject18	Object
    //   306	659	7	localObject19	Object
    //   303	658	8	localObject20	Object
    //   1	1084	9	localObject21	Object
    //   321	490	10	localObject22	Object
    //   340	739	11	str2	String
    //   4	423	12	localObject23	Object
    // Exception table:
    //   from	to	target	type
    //   314	323	371	java/lang/Exception
    //   336	342	371	java/lang/Exception
    //   360	368	371	java/lang/Exception
    //   627	634	371	java/lang/Exception
    //   647	667	371	java/lang/Exception
    //   680	688	371	java/lang/Exception
    //   710	718	371	java/lang/Exception
    //   731	737	371	java/lang/Exception
    //   805	812	371	java/lang/Exception
    //   505	523	542	java/io/IOException
    //   549	561	583	java/io/IOException
    //   567	572	583	java/io/IOException
    //   748	753	785	java/io/IOException
    //   758	763	785	java/io/IOException
    //   767	771	785	java/io/IOException
    //   778	783	785	java/io/IOException
    //   393	397	815	java/io/IOException
    //   401	405	815	java/io/IOException
    //   409	413	815	java/io/IOException
    //   421	426	815	java/io/IOException
    //   137	181	822	finally
    //   181	195	822	finally
    //   195	211	822	finally
    //   211	243	822	finally
    //   431	454	822	finally
    //   466	476	822	finally
    //   496	505	822	finally
    //   505	523	822	finally
    //   836	840	868	java/io/IOException
    //   844	848	868	java/io/IOException
    //   852	856	868	java/io/IOException
    //   861	866	868	java/io/IOException
    //   250	257	876	finally
    //   262	267	876	finally
    //   459	463	876	finally
    //   481	485	876	finally
    //   267	271	886	finally
    //   527	532	905	finally
    //   549	561	905	finally
    //   567	572	905	finally
    //   588	600	905	finally
    //   600	604	922	finally
    //   280	289	939	finally
    //   289	301	947	finally
    //   314	323	959	finally
    //   336	342	959	finally
    //   360	368	959	finally
    //   385	389	959	finally
    //   627	634	959	finally
    //   647	667	959	finally
    //   680	688	959	finally
    //   710	718	959	finally
    //   731	737	959	finally
    //   805	812	959	finally
    //   137	181	976	java/lang/Exception
    //   181	195	976	java/lang/Exception
    //   195	211	976	java/lang/Exception
    //   211	243	976	java/lang/Exception
    //   431	454	976	java/lang/Exception
    //   466	476	976	java/lang/Exception
    //   496	505	976	java/lang/Exception
    //   505	523	976	java/lang/Exception
    //   250	257	989	java/lang/Exception
    //   262	267	989	java/lang/Exception
    //   459	463	989	java/lang/Exception
    //   481	485	989	java/lang/Exception
    //   267	271	1006	java/lang/Exception
    //   527	532	1023	java/lang/Exception
    //   549	561	1023	java/lang/Exception
    //   567	572	1023	java/lang/Exception
    //   588	600	1023	java/lang/Exception
    //   600	604	1034	java/lang/Exception
    //   280	289	1055	java/lang/Exception
    //   289	301	1063	java/lang/Exception
    //   527	532	1069	java/io/IOException
  }
  
  public static FilterMaterial parseFilterMaterial(String paramString1, String paramString2)
  {
    int j = 0;
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
    int j = 0;
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
    Object localObject;
    if (paramString != null)
    {
      localObject = new CrazyFaceDataTemplate.ImageLayer();
      ((CrazyFaceDataTemplate.ImageLayer)localObject).width = GsonUtils.optDouble(paramString, "width");
      ((CrazyFaceDataTemplate.ImageLayer)localObject).height = GsonUtils.optDouble(paramString, "height");
      ((CrazyFaceDataTemplate.ImageLayer)localObject).x = GsonUtils.optDouble(paramString, "x", 0.0D);
      ((CrazyFaceDataTemplate.ImageLayer)localObject).y = GsonUtils.optDouble(paramString, "y", 0.0D);
      ((CrazyFaceDataTemplate.ImageLayer)localObject).type = GsonUtils.optInt(paramString, "type");
      ((CrazyFaceDataTemplate.ImageLayer)localObject).imagePath = GsonUtils.optString(paramString, "image");
      ((CrazyFaceDataTemplate.ImageLayer)localObject).stkType = GsonUtils.optInt(paramString, "stkType", 1);
      localCrazyFaceDataTemplate.foregroundLayer = ((CrazyFaceDataTemplate.ImageLayer)localObject);
    }
    paramString = GsonUtils.optJsonObject(paramJsonObject, "backgroundImageLayer");
    if (paramString != null)
    {
      localObject = new CrazyFaceDataTemplate.ImageLayer();
      ((CrazyFaceDataTemplate.ImageLayer)localObject).width = GsonUtils.optDouble(paramString, "width");
      ((CrazyFaceDataTemplate.ImageLayer)localObject).height = GsonUtils.optDouble(paramString, "height");
      ((CrazyFaceDataTemplate.ImageLayer)localObject).x = GsonUtils.optDouble(paramString, "x", 0.0D);
      ((CrazyFaceDataTemplate.ImageLayer)localObject).y = GsonUtils.optDouble(paramString, "y", 0.0D);
      ((CrazyFaceDataTemplate.ImageLayer)localObject).type = GsonUtils.optInt(paramString, "type");
      ((CrazyFaceDataTemplate.ImageLayer)localObject).imagePath = GsonUtils.optString(paramString, "image");
      ((CrazyFaceDataTemplate.ImageLayer)localObject).stkType = GsonUtils.optInt(paramString, "stkType", 1);
      localCrazyFaceDataTemplate.backgroundLayer = ((CrazyFaceDataTemplate.ImageLayer)localObject);
    }
    paramString = GsonUtils.optJsonObject(paramJsonObject, "faceImageLayer");
    int i;
    if (paramString != null)
    {
      localObject = new FaceImageLayer();
      parseFaceImageLayer((FaceImageLayer)localObject, paramString);
      localCrazyFaceDataTemplate.faceLayers.add(localObject);
      localObject = GsonUtils.optString(paramString, "effectFilter", null);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localCrazyFaceDataTemplate.effectFilter = parseFilterMaterial(localCrazyFaceDataTemplate.folderPath + File.separator + (String)localObject, (String)localObject);
      }
      localCrazyFaceDataTemplate.effectFilterOrder = GsonUtils.optInt(paramString, "effectFilterOrder");
      paramString = GsonUtils.optJsonArray(paramString, "faceEditParamList");
      localObject = new FaceEditParams();
      if (paramString != null)
      {
        i = 0;
        while (i < paramString.size())
        {
          JsonObject localJsonObject = GsonUtils.optJsonObject(paramString, i);
          if (localJsonObject != null) {
            ((FaceEditParams)localObject).updateFaceParam(GsonUtils.optString(localJsonObject, "key"), GsonUtils.optDouble(localJsonObject, "value"));
          }
          i += 1;
        }
      }
      localCrazyFaceDataTemplate.faceEditParams = ((FaceEditParams)localObject);
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
          localObject = new FaceImageLayer();
          parseFaceImageLayer((FaceImageLayer)localObject, paramString);
          localCrazyFaceDataTemplate.faceLayers.add(localObject);
        }
        i += 1;
      }
    }
    return localCrazyFaceDataTemplate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.CfTemplateParser
 * JD-Core Version:    0.7.0.1
 */