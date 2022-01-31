import android.text.Html;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FusionBiuInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusAnimationItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class rmq
{
  public static float a()
  {
    Object localObject = a();
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        localObject = ((JSONObject)localObject).getString(String.valueOf(4));
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          f1 = Float.valueOf((String)localObject).floatValue();
          float f2 = f1;
          if (f1 == -1.0F) {
            f2 = 3.3F;
          }
          return f2;
        }
      }
      catch (Exception localException)
      {
        QLog.d("FastWebPTSDataConverter", 1, "getTextBottomAdWeight error! msg=" + localException);
      }
      float f1 = -1.0F;
    }
  }
  
  public static float a(SparseArray<Float> paramSparseArray)
  {
    return a(paramSparseArray, 1, 2.0F);
  }
  
  private static float a(SparseArray<Float> paramSparseArray, int paramInt, float paramFloat)
  {
    Object localObject = paramSparseArray;
    if (paramSparseArray == null) {
      localObject = a();
    }
    float f = ((Float)((SparseArray)localObject).get(paramInt, Float.valueOf(-1.0F))).floatValue();
    QLog.d("FastWebPTSDataConverter", 1, "getWeight! moduleType=" + paramInt + "  defaultWeight=" + paramFloat);
    if (-1.0F == f) {
      return paramFloat;
    }
    return f;
  }
  
  public static float a(BaseData paramBaseData, boolean paramBoolean)
  {
    if (paramBaseData == null) {
      return -1000.0F;
    }
    if (paramBaseData.jdField_b_of_type_Float <= 0.0F) {
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (paramBaseData.jdField_b_of_type_Float = c(null);; paramBaseData.jdField_b_of_type_Float = a()) {
      return paramBaseData.jdField_b_of_type_Float;
    }
  }
  
  private static int a(JSONObject paramJSONObject, rnq paramrnq)
  {
    int j = -1;
    int i = j;
    if (paramJSONObject != null)
    {
      i = j;
      if (paramrnq == null) {}
    }
    try
    {
      paramrnq.jdField_a_of_type_Int = Integer.valueOf(paramJSONObject.getString("moduleType")).intValue();
      paramrnq.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
      i = paramrnq.jdField_a_of_type_Int;
      return i;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("FastWebPTSDataConverter", 1, "updateModuleBean,error! msg" + paramJSONObject);
    }
    return -1;
  }
  
  public static SparseArray<Float> a()
  {
    localSparseArray = new SparseArray();
    try
    {
      JSONObject localJSONObject = a();
      if (localJSONObject != null)
      {
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = localJSONObject.getString(str1);
          try
          {
            localSparseArray.append(Integer.valueOf(str1).intValue(), Float.valueOf(str2));
          }
          catch (Exception localException2)
          {
            QLog.d("FastWebPTSDataConverter", 1, "getModuleWeight error!! msg" + localException2);
          }
        }
      }
      return localSparseArray;
    }
    catch (Exception localException1)
    {
      QLog.d("FastWebPTSDataConverter", 1, "getModuleWeight error! msg" + localException1);
    }
  }
  
  public static ProteusItemData a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (paramFastWebArticleInfo.b())
      {
        if (rmc.a().b()) {
          localJSONObject.put("style_ID", "Readinjoy_article_likebiu_fusion_cell");
        }
        for (;;)
        {
          if (!paramFastWebArticleInfo.jdField_a_of_type_Boolean) {
            break label231;
          }
          Object localObject = "NativeArticleLikeEnable";
          localJSONObject.put("like_normalstate_image", localObject);
          if (!paramFastWebArticleInfo.a()) {
            break;
          }
          localObject = "NativeArticleCollectionEnable";
          localJSONObject.put("collect_normalstate_image", localObject);
          if (paramFastWebArticleInfo.b > 0L)
          {
            localJSONObject.put("comment_count", bhvh.a(paramFastWebArticleInfo.b, 99990000L, "9999万+", rmp.a));
            localJSONObject.put("count_txt_color", "#FFFFFF");
            localJSONObject.put("count_bg_color", "#FF4222");
          }
          localObject = (rnq)paramFastWebArticleInfo.jdField_a_of_type_AndroidUtilSparseArray.get(999);
          if (localObject != null) {
            a(localJSONObject, ((rnq)localObject).jdField_a_of_type_OrgJsonJSONObject);
          }
          return a(localJSONObject, paramArticleInfo, paramFastWebArticleInfo);
          localJSONObject.put("style_ID", "ReadInjoy_article_operate_cell");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("FastWebPTSDataConverter", 1, "createOperateAreaData error! msg=" + localException);
        continue;
        if (rmc.a().b())
        {
          localJSONObject.put("style_ID", "ReadInjoy_article_forbid_comment_like_biu_fusion_operate_cell");
        }
        else
        {
          localJSONObject.put("style_ID", "ReadInjoy_article_forbid_comment_operate_cell");
          continue;
          String str = "NativeArticleCollectionDisable";
          continue;
          label231:
          str = "NativeArticleLikeDisable";
        }
      }
    }
  }
  
  /* Error */
  public static ProteusItemData a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, int paramInt3, SparseArray<Float> paramSparseArray)
  {
    // Byte code:
    //   0: new 19	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 156	org/json/JSONObject:<init>	()V
    //   7: astore 11
    //   9: aload_2
    //   10: invokestatic 29	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +133 -> 146
    //   16: aload_3
    //   17: aload 6
    //   19: aload 7
    //   21: aload 8
    //   23: invokestatic 244	rne:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   26: astore_2
    //   27: aload 11
    //   29: aload_2
    //   30: aload_3
    //   31: iload 4
    //   33: iload 5
    //   35: aload 6
    //   37: aload 7
    //   39: aload 8
    //   41: iload 9
    //   43: invokestatic 247	rne:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   46: aload 11
    //   48: aload_0
    //   49: aload_1
    //   50: invokestatic 226	rmq:a	(Lorg/json/JSONObject;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo;)Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   53: astore_0
    //   54: aload_0
    //   55: iconst_1
    //   56: putfield 252	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:t	I
    //   59: aload_0
    //   60: aload 10
    //   62: invokestatic 254	rmq:a	(Landroid/util/SparseArray;)F
    //   65: putfield 255	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:jdField_b_of_type_Float	F
    //   68: aload_0
    //   69: iconst_3
    //   70: putfield 258	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:s	I
    //   73: aload_3
    //   74: invokestatic 29	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   77: ifne +27 -> 104
    //   80: aload 8
    //   82: invokestatic 29	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   85: ifne +19 -> 104
    //   88: aload 6
    //   90: invokestatic 29	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   93: ifne +11 -> 104
    //   96: aload 7
    //   98: invokestatic 29	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   101: ifeq +8 -> 109
    //   104: aload_0
    //   105: iconst_0
    //   106: putfield 261	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:f	Z
    //   109: aload_0
    //   110: areturn
    //   111: astore_1
    //   112: aconst_null
    //   113: astore_0
    //   114: ldc 41
    //   116: iconst_1
    //   117: new 43	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   124: ldc_w 263
    //   127: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_1
    //   131: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: aload_0
    //   141: areturn
    //   142: astore_1
    //   143: goto -29 -> 114
    //   146: goto -119 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramArticleInfo	ArticleInfo
    //   0	149	1	paramFastWebArticleInfo	FastWebArticleInfo
    //   0	149	2	paramString1	String
    //   0	149	3	paramString2	String
    //   0	149	4	paramInt1	int
    //   0	149	5	paramInt2	int
    //   0	149	6	paramString3	String
    //   0	149	7	paramString4	String
    //   0	149	8	paramString5	String
    //   0	149	9	paramInt3	int
    //   0	149	10	paramSparseArray	SparseArray<Float>
    //   7	40	11	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   9	27	111	java/lang/Exception
    //   27	54	111	java/lang/Exception
    //   54	104	142	java/lang/Exception
    //   104	109	142	java/lang/Exception
  }
  
  /* Error */
  public static ProteusItemData a(ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, String paramString1, String paramString2, String paramString3, SparseArray<Float> paramSparseArray)
  {
    // Byte code:
    //   0: new 19	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 156	org/json/JSONObject:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: aload_3
    //   12: aload 4
    //   14: aload_2
    //   15: invokestatic 270	rmo:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   18: istore 6
    //   20: aload 7
    //   22: aload_0
    //   23: aload_1
    //   24: invokestatic 226	rmq:a	(Lorg/json/JSONObject;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo;)Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   27: astore_0
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 252	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:t	I
    //   33: aload_0
    //   34: aload 5
    //   36: invokestatic 254	rmq:a	(Landroid/util/SparseArray;)F
    //   39: putfield 255	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:jdField_b_of_type_Float	F
    //   42: aload_0
    //   43: iconst_2
    //   44: putfield 258	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:s	I
    //   47: aload_0
    //   48: iload 6
    //   50: putfield 261	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:f	Z
    //   53: aload_0
    //   54: areturn
    //   55: astore_1
    //   56: aconst_null
    //   57: astore_0
    //   58: ldc 41
    //   60: iconst_1
    //   61: new 43	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 272
    //   71: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_1
    //   75: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: aload_0
    //   85: areturn
    //   86: astore_1
    //   87: goto -29 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramArticleInfo	ArticleInfo
    //   0	90	1	paramFastWebArticleInfo	FastWebArticleInfo
    //   0	90	2	paramString1	String
    //   0	90	3	paramString2	String
    //   0	90	4	paramString3	String
    //   0	90	5	paramSparseArray	SparseArray<Float>
    //   18	31	6	bool	boolean
    //   7	14	7	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   9	28	55	java/lang/Exception
    //   28	53	86	java/lang/Exception
  }
  
  /* Error */
  public static ProteusItemData a(String paramString, CharSequence paramCharSequence, int paramInt1, int paramInt2, SparseArray<Float> paramSparseArray)
  {
    // Byte code:
    //   0: new 19	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 156	org/json/JSONObject:<init>	()V
    //   7: astore 5
    //   9: iload_3
    //   10: tableswitch	default:+22 -> 32, 2:+109->119, 3:+102->112
    //   33: aconst_null
    //   34: ldc2_w 19225
    //   37: iconst_2
    //   38: ldc 168
    //   40: aload_0
    //   41: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   44: pop
    //   45: aload 5
    //   47: ldc_w 278
    //   50: iload_2
    //   51: invokestatic 17	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   54: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   57: pop
    //   58: aload 5
    //   60: ldc_w 280
    //   63: aload_1
    //   64: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   67: pop
    //   68: aload 5
    //   70: ldc_w 282
    //   73: invokestatic 285	rmr:a	()F
    //   76: invokestatic 288	java/lang/Float:toString	(F)Ljava/lang/String;
    //   79: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   82: pop
    //   83: aload 5
    //   85: aconst_null
    //   86: aconst_null
    //   87: invokestatic 226	rmq:a	(Lorg/json/JSONObject;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo;)Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   90: astore_0
    //   91: aload_0
    //   92: aload 4
    //   94: invokestatic 254	rmq:a	(Landroid/util/SparseArray;)F
    //   97: putfield 255	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:jdField_b_of_type_Float	F
    //   100: aload_0
    //   101: iconst_1
    //   102: putfield 252	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:t	I
    //   105: aload_0
    //   106: iconst_1
    //   107: putfield 258	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:s	I
    //   110: aload_0
    //   111: areturn
    //   112: ldc_w 290
    //   115: astore_0
    //   116: goto -80 -> 36
    //   119: ldc_w 292
    //   122: astore_0
    //   123: goto -87 -> 36
    //   126: astore_1
    //   127: aconst_null
    //   128: astore_0
    //   129: ldc 41
    //   131: iconst_1
    //   132: new 43	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   139: ldc_w 294
    //   142: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_1
    //   146: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: aload_0
    //   156: areturn
    //   157: astore_1
    //   158: goto -29 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramString	String
    //   0	161	1	paramCharSequence	CharSequence
    //   0	161	2	paramInt1	int
    //   0	161	3	paramInt2	int
    //   0	161	4	paramSparseArray	SparseArray<Float>
    //   7	77	5	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   36	91	126	java/lang/Exception
    //   91	110	157	java/lang/Exception
  }
  
  public static ProteusItemData a(String paramString1, String paramString2, SparseArray<Float> paramSparseArray)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("style_ID", "ReadInjoy_article_link_text_cell");
      localJSONObject.put("id_attribute_text", Html.fromHtml(paramString1));
      localJSONObject.put("jump_url", paramString2);
      localJSONObject.put("attribute_text_size", rmr.a());
      paramString1 = a(localJSONObject, null, null);
      QLog.d("FastWebPTSDataConverter", 1, "createArticleLinkData error! msg=" + paramString2);
    }
    catch (Exception paramString2)
    {
      try
      {
        paramString1.jdField_b_of_type_Float = a(paramSparseArray);
        paramString1.t = 1;
        paramString1.s = 1;
        return paramString1;
      }
      catch (Exception paramString2)
      {
        break label81;
      }
      paramString2 = paramString2;
      paramString1 = null;
    }
    label81:
    return paramString1;
  }
  
  public static ProteusItemData a(JSONObject paramJSONObject, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    ProteusItemData localProteusItemData = new ProteusItemData(26);
    a(localProteusItemData, paramJSONObject, paramArticleInfo, paramFastWebArticleInfo);
    return localProteusItemData;
  }
  
  private static JSONObject a()
  {
    Object localObject1 = Aladdin.getConfig(242).getString("module_type_weight", "");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        QLog.d("FastWebPTSDataConverter", 1, "getAladdinWeightConfig! msg" + localObject1);
        return localObject1;
      }
      catch (Exception localException)
      {
        localObject2 = null;
        continue;
      }
      Object localObject2 = null;
    }
  }
  
  private static void a(ProteusItemData paramProteusItemData, JSONObject paramJSONObject, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    try
    {
      paramProteusItemData.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
      paramProteusItemData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo = paramFastWebArticleInfo;
      paramProteusItemData.jdField_b_of_type_OrgJsonJSONObject = paramJSONObject;
      paramProteusItemData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean = ProteusParser.getTemplateBean(rpu.a("native_article", true), paramJSONObject);
      return;
    }
    catch (Exception paramProteusItemData)
    {
      QLog.d("FastWebPTSDataConverter", 1, "createCommonDynamicItem error! msg=" + paramProteusItemData);
    }
  }
  
  public static void a(String paramString, SparseArray<rnq> paramSparseArray)
  {
    if ((paramString != null) && (paramSparseArray != null)) {
      try
      {
        rnq localrnq = new rnq();
        JSONArray localJSONArray = new JSONArray(paramString);
        int i = 0;
        while (i < localJSONArray.length())
        {
          Object localObject = localJSONArray.get(i);
          if ((localObject instanceof JSONObject))
          {
            int j = a((JSONObject)localObject, localrnq);
            if (-1 != j) {
              paramSparseArray.append(j, localrnq);
            }
          }
          i += 1;
        }
        QLog.d("FastWebPTSDataConverter", 1, "parsePTSData! msg" + paramString);
      }
      catch (Exception paramSparseArray)
      {
        QLog.d("FastWebPTSDataConverter", 1, "parsePTSData,error! msg" + paramSparseArray);
      }
    }
  }
  
  public static void a(List<BaseData> paramList, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, ItemShowDispatcher paramItemShowDispatcher, SparseArray<Float> paramSparseArray)
  {
    if (a(paramList)) {}
    while (!rmc.a().b()) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("style_ID", "Readinjoy_article_interaction_float_view_cell");
      paramArticleInfo = new ProteusAnimationItemData(a(localJSONObject, paramArticleInfo, paramFastWebArticleInfo));
      paramArticleInfo.jdField_b_of_type_Float = (d(paramSparseArray) + 1.0E-004F);
      paramArticleInfo.t = 2;
      rnm.a(paramList, paramArticleInfo, paramItemShowDispatcher);
      return;
    }
    catch (Exception paramList)
    {
      QLog.e("FastWebPTSDataConverter", 1, "insertAnimationItem error! msg=" + paramList);
    }
  }
  
  private static void a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if ((paramJSONObject1 == null) || (paramJSONObject2 == null)) {
      return;
    }
    Iterator localIterator = paramJSONObject2.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        paramJSONObject1.put(str, paramJSONObject2.getString(str));
      }
      catch (Exception localException) {}
    }
    QLog.d("FastWebPTSDataConverter", 1, "mergeJSONData! oriData=" + paramJSONObject1 + " mergeData=" + paramJSONObject2);
  }
  
  private static boolean a(List<BaseData> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((BaseData)paramList.next() instanceof ProteusAnimationItemData)) {
        return true;
      }
    }
    return false;
  }
  
  public static float b(SparseArray<Float> paramSparseArray)
  {
    return a(paramSparseArray, 3, 3.7F);
  }
  
  public static void b(List<BaseData> paramList, ArticleInfo paramArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, ItemShowDispatcher paramItemShowDispatcher, SparseArray<Float> paramSparseArray)
  {
    Object localObject3 = null;
    rnq localrnq = null;
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = localObject3;
    try
    {
      if (!rmc.a().b()) {
        break label355;
      }
      localObject2 = localObject3;
      localJSONObject.put("style_ID", "Readinjoy_article_interaction_fusion_biu_cell");
      localObject2 = localObject3;
      if (paramArticleInfo.fusionBiuInfo != null)
      {
        localObject2 = localObject3;
        if (!paramArticleInfo.fusionBiuInfo.b) {
          break label304;
        }
        localObject2 = localObject3;
        localJSONObject.put("biu_normalstate_image", "NativeArticleHasBiu");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        label304:
        QLog.d("FastWebPTSDataConverter", 1, "insertDislikeData error! msg=" + localException);
        continue;
        label355:
        localObject2 = localObject3;
        localJSONObject.put("style_ID", "Readinjoy_article_compact_interaction_cell");
        continue;
        localObject2 = localObject3;
        localJSONObject.put("interaction_like_count", "喜欢");
      }
      a(localObject2, localJSONObject, paramArticleInfo, paramFastWebArticleInfo);
      return;
    }
    localObject2 = localObject3;
    if (paramFastWebArticleInfo.jdField_a_of_type_Boolean) {}
    String str;
    for (localObject1 = "NativeArticleLikeEnable";; str = "NativeArticleLikeDisable")
    {
      localObject2 = localObject3;
      if (paramFastWebArticleInfo.jdField_a_of_type_Int > 0)
      {
        localObject2 = localObject3;
        localJSONObject.put("interaction_like_count", rmn.a(paramFastWebArticleInfo.jdField_a_of_type_Int));
        localObject2 = localObject3;
        localJSONObject.put("like_normalstate_image", localObject1);
        localObject2 = localObject3;
        Iterator localIterator = paramList.iterator();
        do
        {
          do
          {
            localObject1 = localrnq;
            localObject2 = localObject3;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject2 = localObject3;
            localObject1 = (BaseData)localIterator.next();
            localObject2 = localObject3;
          } while (!(localObject1 instanceof ProteusItemData));
          localObject2 = localObject3;
          localObject1 = (ProteusItemData)localObject1;
          localObject2 = localObject3;
        } while (((ProteusItemData)localObject1).t != 2);
        localObject2 = localObject1;
        localrnq = (rnq)paramFastWebArticleInfo.jdField_a_of_type_AndroidUtilSparseArray.get(2);
        localObject2 = localObject1;
        if (localrnq != null)
        {
          localObject2 = localObject1;
          a(localJSONObject, localrnq.jdField_a_of_type_OrgJsonJSONObject);
          localObject2 = localObject1;
        }
        if (localObject2 != null) {
          continue;
        }
        paramArticleInfo = a(localJSONObject, paramArticleInfo, paramFastWebArticleInfo);
        paramArticleInfo.jdField_b_of_type_Float = d(paramSparseArray);
        paramArticleInfo.t = 2;
        rnm.a(paramList, paramArticleInfo, paramItemShowDispatcher);
        return;
        localObject2 = localObject3;
        localJSONObject.put("biu_normalstate_image", "NativeArticleBiu");
        break;
      }
    }
  }
  
  public static float c(SparseArray<Float> paramSparseArray)
  {
    return a(paramSparseArray, 5, 7.0F);
  }
  
  public static float d(SparseArray<Float> paramSparseArray)
  {
    return a(paramSparseArray, 2, 3.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rmq
 * JD-Core Version:    0.7.0.1
 */