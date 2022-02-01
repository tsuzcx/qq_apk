import android.text.Html;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.event.ItemShowDispatcher;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParser;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class tba
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
  
  private static int a(JSONObject paramJSONObject, tcb paramtcb)
  {
    int j = -1;
    int i = j;
    if (paramJSONObject != null)
    {
      i = j;
      if (paramtcb == null) {}
    }
    try
    {
      paramtcb.jdField_a_of_type_Int = Integer.valueOf(paramJSONObject.getString("moduleType")).intValue();
      paramtcb.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
      i = paramtcb.jdField_a_of_type_Int;
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
    if (paramFastWebArticleInfo == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    boolean bool = ova.a();
    QLog.d("FastWebPTSDataConverter", 1, "createOperateAreaData | isCommentBiuMixStyle " + bool);
    if (bool) {
      b(localJSONObject, paramFastWebArticleInfo);
    }
    for (;;)
    {
      tcb localtcb = (tcb)paramFastWebArticleInfo.jdField_a_of_type_AndroidUtilSparseArray.get(999);
      if (localtcb != null) {
        a(localJSONObject, localtcb.jdField_a_of_type_OrgJsonJSONObject);
      }
      return a(localJSONObject, paramArticleInfo, paramFastWebArticleInfo);
      a(localJSONObject, paramFastWebArticleInfo);
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
    //   13: ifeq +132 -> 145
    //   16: aload_3
    //   17: aload 6
    //   19: aload 7
    //   21: aload 8
    //   23: invokestatic 190	tbp:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
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
    //   43: invokestatic 193	tbp:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   46: aload 11
    //   48: aload_0
    //   49: aload_1
    //   50: invokestatic 182	tba:a	(Lorg/json/JSONObject;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo;)Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   53: astore_0
    //   54: aload_0
    //   55: iconst_1
    //   56: putfield 198	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:x	I
    //   59: aload_0
    //   60: aload 10
    //   62: invokestatic 200	tba:a	(Landroid/util/SparseArray;)F
    //   65: putfield 201	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:jdField_b_of_type_Float	F
    //   68: aload_0
    //   69: iconst_3
    //   70: putfield 204	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:w	I
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
    //   106: putfield 208	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:g	Z
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
    //   124: ldc 210
    //   126: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_1
    //   130: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: aload_0
    //   140: areturn
    //   141: astore_1
    //   142: goto -28 -> 114
    //   145: goto -118 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	paramArticleInfo	ArticleInfo
    //   0	148	1	paramFastWebArticleInfo	FastWebArticleInfo
    //   0	148	2	paramString1	String
    //   0	148	3	paramString2	String
    //   0	148	4	paramInt1	int
    //   0	148	5	paramInt2	int
    //   0	148	6	paramString3	String
    //   0	148	7	paramString4	String
    //   0	148	8	paramString5	String
    //   0	148	9	paramInt3	int
    //   0	148	10	paramSparseArray	SparseArray<Float>
    //   7	40	11	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   9	27	111	java/lang/Exception
    //   27	54	111	java/lang/Exception
    //   54	104	141	java/lang/Exception
    //   104	109	141	java/lang/Exception
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
    //   15: iconst_4
    //   16: aconst_null
    //   17: iconst_1
    //   18: invokestatic 217	tyc:a	(Ljava/lang/String;ILjava/lang/Object;Z)Ljava/net/URL;
    //   21: invokevirtual 220	java/net/URL:toString	()Ljava/lang/String;
    //   24: invokestatic 225	tay:a	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   27: istore 6
    //   29: aload 7
    //   31: aload_0
    //   32: aload_1
    //   33: invokestatic 182	tba:a	(Lorg/json/JSONObject;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo;)Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   36: astore_0
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield 198	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:x	I
    //   42: aload_0
    //   43: aload 5
    //   45: invokestatic 200	tba:a	(Landroid/util/SparseArray;)F
    //   48: putfield 201	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:jdField_b_of_type_Float	F
    //   51: aload_0
    //   52: iconst_2
    //   53: putfield 204	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:w	I
    //   56: aload_0
    //   57: iload 6
    //   59: putfield 208	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:g	Z
    //   62: aload_0
    //   63: areturn
    //   64: astore_1
    //   65: aconst_null
    //   66: astore_0
    //   67: ldc 41
    //   69: iconst_1
    //   70: new 43	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   77: ldc 227
    //   79: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_1
    //   83: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: aload_0
    //   93: areturn
    //   94: astore_1
    //   95: goto -28 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramArticleInfo	ArticleInfo
    //   0	98	1	paramFastWebArticleInfo	FastWebArticleInfo
    //   0	98	2	paramString1	String
    //   0	98	3	paramString2	String
    //   0	98	4	paramString3	String
    //   0	98	5	paramSparseArray	SparseArray<Float>
    //   27	31	6	bool	boolean
    //   7	23	7	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   9	37	64	java/lang/Exception
    //   37	62	94	java/lang/Exception
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
    //   10: tableswitch	default:+22 -> 32, 2:+104->114, 3:+98->108
    //   33: <illegal opcode>
    //   34: astore_0
    //   35: aload 5
    //   37: ldc 233
    //   39: aload_0
    //   40: invokevirtual 237	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   43: pop
    //   44: aload 5
    //   46: ldc 239
    //   48: iload_2
    //   49: invokestatic 17	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   52: invokevirtual 237	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   55: pop
    //   56: aload 5
    //   58: ldc 241
    //   60: aload_1
    //   61: invokevirtual 237	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   64: pop
    //   65: aload 5
    //   67: ldc 243
    //   69: invokestatic 246	tbb:a	()F
    //   72: invokestatic 249	java/lang/Float:toString	(F)Ljava/lang/String;
    //   75: invokevirtual 237	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   78: pop
    //   79: aload 5
    //   81: aconst_null
    //   82: aconst_null
    //   83: invokestatic 182	tba:a	(Lorg/json/JSONObject;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/util/FastWebArticleInfo;)Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;
    //   86: astore_0
    //   87: aload_0
    //   88: aload 4
    //   90: invokestatic 200	tba:a	(Landroid/util/SparseArray;)F
    //   93: putfield 201	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:jdField_b_of_type_Float	F
    //   96: aload_0
    //   97: iconst_1
    //   98: putfield 198	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:x	I
    //   101: aload_0
    //   102: iconst_1
    //   103: putfield 204	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:w	I
    //   106: aload_0
    //   107: areturn
    //   108: ldc 251
    //   110: astore_0
    //   111: goto -76 -> 35
    //   114: ldc 253
    //   116: astore_0
    //   117: goto -82 -> 35
    //   120: astore_1
    //   121: aconst_null
    //   122: astore_0
    //   123: ldc 41
    //   125: iconst_1
    //   126: new 43	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   133: ldc 255
    //   135: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_1
    //   139: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 66	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   148: aload_0
    //   149: areturn
    //   150: astore_1
    //   151: goto -28 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramString	String
    //   0	154	1	paramCharSequence	CharSequence
    //   0	154	2	paramInt1	int
    //   0	154	3	paramInt2	int
    //   0	154	4	paramSparseArray	SparseArray<Float>
    //   7	73	5	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   35	87	120	java/lang/Exception
    //   87	106	150	java/lang/Exception
  }
  
  public static ProteusItemData a(String paramString1, String paramString2, SparseArray<Float> paramSparseArray)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("style_ID", "ReadInjoy_article_link_text_cell");
      localJSONObject.put("id_attribute_text", Html.fromHtml(paramString1));
      localJSONObject.put("jump_url", paramString2);
      localJSONObject.put("attribute_text_size", tbb.a());
      paramString1 = a(localJSONObject, null, null);
      QLog.d("FastWebPTSDataConverter", 1, "createArticleLinkData error! msg=" + paramString2);
    }
    catch (Exception paramString2)
    {
      try
      {
        paramString1.jdField_b_of_type_Float = a(paramSparseArray);
        paramString1.x = 1;
        paramString1.w = 1;
        return paramString1;
      }
      catch (Exception paramString2)
      {
        break label79;
      }
      paramString2 = paramString2;
      paramString1 = null;
    }
    label79:
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
      paramProteusItemData.c = paramJSONObject;
      paramProteusItemData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean = ProteusParser.getTemplateBean(teh.a("native_article", true), paramJSONObject);
      return;
    }
    catch (Exception paramProteusItemData)
    {
      QLog.d("FastWebPTSDataConverter", 1, "createCommonDynamicItem error! msg=" + paramProteusItemData);
    }
  }
  
  public static void a(String paramString, SparseArray<tcb> paramSparseArray)
  {
    if ((paramString != null) && (paramSparseArray != null)) {
      try
      {
        tcb localtcb = new tcb();
        JSONArray localJSONArray = new JSONArray(paramString);
        int i = 0;
        while (i < localJSONArray.length())
        {
          Object localObject = localJSONArray.get(i);
          if ((localObject instanceof JSONObject))
          {
            int j = a((JSONObject)localObject, localtcb);
            if (-1 != j) {
              paramSparseArray.append(j, localtcb);
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
    Object localObject3 = null;
    tcb localtcb = null;
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = localObject3;
    for (;;)
    {
      try
      {
        localJSONObject.put("style_ID", "Readinjoy_article_compact_interaction_cell");
        localObject2 = localObject3;
        if (!paramFastWebArticleInfo.jdField_a_of_type_Boolean) {
          continue;
        }
        localObject1 = "NativeArticleLikeEnable";
        localObject2 = localObject3;
        if (paramFastWebArticleInfo.jdField_a_of_type_Int <= 0) {
          continue;
        }
        localObject2 = localObject3;
        localJSONObject.put("interaction_like_count", tax.a(paramFastWebArticleInfo.jdField_a_of_type_Int));
        localObject2 = localObject3;
        localJSONObject.put("like_normalstate_image", localObject1);
        localObject2 = localObject3;
        Iterator localIterator = paramList.iterator();
        localObject1 = localtcb;
        localObject2 = localObject3;
        if (localIterator.hasNext())
        {
          localObject2 = localObject3;
          localObject1 = (BaseData)localIterator.next();
          localObject2 = localObject3;
          if (!(localObject1 instanceof ProteusItemData)) {
            continue;
          }
          localObject2 = localObject3;
          localObject1 = (ProteusItemData)localObject1;
          localObject2 = localObject3;
          if (((ProteusItemData)localObject1).x != 2) {
            continue;
          }
        }
        localObject2 = localObject1;
        localtcb = (tcb)paramFastWebArticleInfo.jdField_a_of_type_AndroidUtilSparseArray.get(2);
        localObject2 = localObject1;
        if (localtcb != null)
        {
          localObject2 = localObject1;
          a(localJSONObject, localtcb.jdField_a_of_type_OrgJsonJSONObject);
          localObject2 = localObject1;
        }
      }
      catch (Exception localException)
      {
        Object localObject1;
        QLog.d("FastWebPTSDataConverter", 1, "insertDislikeData error! msg=" + localException);
        continue;
        a(localObject2, localJSONObject, paramArticleInfo, paramFastWebArticleInfo);
      }
      if (localObject2 != null) {
        continue;
      }
      paramArticleInfo = a(localJSONObject, paramArticleInfo, paramFastWebArticleInfo);
      paramArticleInfo.jdField_b_of_type_Float = d(paramSparseArray);
      paramArticleInfo.x = 2;
      tbx.a(paramList, paramArticleInfo, paramItemShowDispatcher);
      return;
      localObject1 = "NativeArticleLikeDisable";
      continue;
      localObject2 = localObject3;
      localJSONObject.put("interaction_like_count", "喜欢");
    }
  }
  
  private static void a(JSONObject paramJSONObject, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramJSONObject == null) || (paramFastWebArticleInfo == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        if (paramFastWebArticleInfo.b())
        {
          paramJSONObject.put("style_ID", "ReadInjoy_article_operate_cell");
          if (!paramFastWebArticleInfo.jdField_a_of_type_Boolean) {
            break label202;
          }
          str = "NativeArticleLikeEnable";
          paramJSONObject.put("like_normalstate_image", str);
          if (!paramFastWebArticleInfo.a()) {
            break label195;
          }
          str = "NativeArticleCollectionEnable";
          paramJSONObject.put("collect_normalstate_image", str);
          if (paramFastWebArticleInfo.b > 0L)
          {
            paramJSONObject.put("comment_count", bmqa.a(paramFastWebArticleInfo.b, 99990000L, "9999万+", taz.a));
            paramJSONObject.put("count_txt_color", "#FFFFFF");
            paramJSONObject.put("count_bg_color", "#FF4222");
          }
          QLog.d("FastWebPTSDataConverter", 2, "buildNormalCommentBiuOperationData | dynamicData :" + paramJSONObject.toString());
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        QLog.d("FastWebPTSDataConverter", 1, "createOperateAreaData error! msg=" + paramJSONObject.getMessage());
        return;
      }
      paramJSONObject.put("style_ID", "ReadInjoy_article_forbid_comment_operate_cell");
      continue;
      label195:
      String str = "NativeArticleCollectionDisable";
      continue;
      label202:
      str = "NativeArticleLikeDisable";
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
  
  public static float b(SparseArray<Float> paramSparseArray)
  {
    return a(paramSparseArray, 3, 3.7F);
  }
  
  private static void b(JSONObject paramJSONObject, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if ((paramJSONObject == null) || (paramFastWebArticleInfo == null)) {
      return;
    }
    try
    {
      if (paramFastWebArticleInfo.b())
      {
        paramJSONObject.put("style_ID", "ReadInjoy_article_operate_cell");
        paramJSONObject.put("biu_text", ova.a());
        if (!paramFastWebArticleInfo.jdField_a_of_type_Boolean) {
          break label269;
        }
        str = "NativeArticleLikeEnable";
        label48:
        if (paramFastWebArticleInfo.jdField_a_of_type_Int > 0)
        {
          paramJSONObject.put("like_count", tax.a(paramFastWebArticleInfo.jdField_a_of_type_Int));
          paramJSONObject.put("like_count_txt_color", "#262626");
        }
        paramJSONObject.put("like_normalstate_image", str);
        if (paramFastWebArticleInfo.c > 0L)
        {
          paramJSONObject.put("biu_count", bmqa.a(paramFastWebArticleInfo.c, 99990000L, "9999万+", "Biu"));
          paramJSONObject.put("biu_count_txt_color", "#262626");
        }
        if (paramFastWebArticleInfo.b > 0L)
        {
          paramJSONObject.put("comment_count", bmqa.a(paramFastWebArticleInfo.b, 99990000L, "9999万+", taz.a));
          paramJSONObject.put("count_txt_color", "#FF4222");
        }
        QLog.d("FastWebPTSDataConverter", 2, "buildNewCommentBiuOperationData | dynamicData : " + paramJSONObject.toString());
        return;
      }
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("FastWebPTSDataConverter", 1, "createOperateAreaData error! msg=" + paramJSONObject);
      return;
    }
    if (paramFastWebArticleInfo.a()) {}
    for (String str = "NativeArticleCollectionEnable";; str = "NativeArticleCollectionDisable")
    {
      paramJSONObject.put("collect_normalstate_image", str);
      paramJSONObject.put("style_ID", "ReadInjoy_article_forbid_comment_operate_cell");
      break;
      label269:
      str = "NativeArticleLikeDisable";
      break label48;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tba
 * JD-Core Version:    0.7.0.1
 */