import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusAnimationItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusRecommendItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class szv
  extends syj
{
  private SparseArray<tal> jdField_a_of_type_AndroidUtilSparseArray;
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private tal jdField_a_of_type_Tal;
  
  public szv(szu paramszu, View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    if ((paramView instanceof Container)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = ((Container)paramView);
    }
    a();
  }
  
  private String a(JSONObject paramJSONObject)
  {
    String str2 = "";
    String str1 = str2;
    if (paramJSONObject.opt("card_info") != null) {}
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("card_info");
      str1 = str2;
      if (paramJSONObject.opt("rowKey") != null) {
        str1 = paramJSONObject.getString("rowKey");
      }
      return str1;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return "";
  }
  
  private tal a()
  {
    return new tae(this);
  }
  
  private tal a(int paramInt)
  {
    tal localtal = (tal)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localtal != null) {
      return localtal;
    }
    return j();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Tal = null;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1012, a());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1023, b());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1002, c());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1001, d());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1158, e());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1154, f());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1157, g());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1170, h());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1038, h());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1040, i());
    j();
  }
  
  private void a(Context paramContext, ProteusItemData paramProteusItemData)
  {
    ViewFactory.findClickableViewListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), new szw(this, paramContext, paramProteusItemData));
  }
  
  private void a(View paramView, BaseData paramBaseData)
  {
    if ((paramView == null) || (paramBaseData == null)) {}
    for (;;)
    {
      return;
      try
      {
        ProteusItemData localProteusItemData = (ProteusItemData)paramBaseData;
        if (((ProteusItemData)paramBaseData).w == 1)
        {
          paramView.setOnLongClickListener(new tab(this, paramView, localProteusItemData));
          return;
        }
      }
      catch (Exception paramView)
      {
        QLog.d("WebProteusViewCreator", 1, "addLongClickListener error,msg:" + paramView.toString());
      }
    }
  }
  
  /* Error */
  private void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    // Byte code:
    //   0: aload_3
    //   1: getfield 176	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:c	Lorg/json/JSONObject;
    //   4: astore 4
    //   6: aload_1
    //   7: invokevirtual 181	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase:getEventAttachedData	()Ljava/lang/String;
    //   10: astore 6
    //   12: aload_0
    //   13: aload 4
    //   15: invokespecial 183	szv:a	(Lorg/json/JSONObject;)Ljava/lang/String;
    //   18: astore 5
    //   20: aload_0
    //   21: invokespecial 186	szv:a	()Z
    //   24: ifeq +17 -> 41
    //   27: aload_0
    //   28: aload_1
    //   29: aload_2
    //   30: aload_3
    //   31: aload 6
    //   33: aload 4
    //   35: aload 5
    //   37: invokespecial 189	szv:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;Landroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   40: return
    //   41: ldc 191
    //   43: aload 5
    //   45: ldc 193
    //   47: invokestatic 198	ogc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   50: invokestatic 201	ogc:a	(Ljava/lang/String;)V
    //   53: aload 4
    //   55: ldc 203
    //   57: invokevirtual 206	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   60: astore 6
    //   62: invokestatic 211	bisa:a	()Lbisa;
    //   65: aload 6
    //   67: invokevirtual 214	bisa:b	(Ljava/lang/String;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   70: astore 7
    //   72: aload 7
    //   74: ifnonnull +191 -> 265
    //   77: ldc 191
    //   79: aload 5
    //   81: ldc 216
    //   83: invokestatic 198	ogc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   86: invokestatic 201	ogc:a	(Ljava/lang/String;)V
    //   89: ldc 191
    //   91: aload 5
    //   93: ldc 218
    //   95: invokestatic 198	ogc:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   98: invokestatic 201	ogc:a	(Ljava/lang/String;)V
    //   101: new 220	com/tencent/open/downloadnew/DownloadInfo
    //   104: dup
    //   105: invokespecial 221	com/tencent/open/downloadnew/DownloadInfo:<init>	()V
    //   108: astore 5
    //   110: aload 5
    //   112: aload 6
    //   114: putfield 224	com/tencent/open/downloadnew/DownloadInfo:d	Ljava/lang/String;
    //   117: aload 5
    //   119: ldc 226
    //   121: putfield 229	com/tencent/open/downloadnew/DownloadInfo:m	Ljava/lang/String;
    //   124: aload 5
    //   126: ldc 231
    //   128: putfield 233	com/tencent/open/downloadnew/DownloadInfo:e	Ljava/lang/String;
    //   131: invokestatic 211	bisa:a	()Lbisa;
    //   134: aload 5
    //   136: invokevirtual 236	bisa:b	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   139: aload 4
    //   141: ldc 238
    //   143: invokevirtual 44	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   146: astore 5
    //   148: aload 5
    //   150: ldc 240
    //   152: ldc 242
    //   154: invokevirtual 245	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   157: pop
    //   158: aload 5
    //   160: ldc 247
    //   162: iconst_0
    //   163: invokevirtual 250	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   166: pop
    //   167: aload_0
    //   168: getfield 16	szv:jdField_a_of_type_Szu	Lszu;
    //   171: invokestatic 255	szu:a	(Lszu;)Landroid/widget/BaseAdapter;
    //   174: ifnull +13 -> 187
    //   177: aload_0
    //   178: getfield 16	szv:jdField_a_of_type_Szu	Lszu;
    //   181: invokestatic 255	szu:a	(Lszu;)Landroid/widget/BaseAdapter;
    //   184: invokevirtual 260	android/widget/BaseAdapter:notifyDataSetChanged	()V
    //   187: aload 4
    //   189: ldc_w 262
    //   192: invokevirtual 40	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   195: ifnull +28 -> 223
    //   198: aload 4
    //   200: ldc_w 262
    //   203: invokevirtual 206	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   206: astore 5
    //   208: aload_2
    //   209: ldc_w 264
    //   212: invokevirtual 269	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   215: checkcast 271	android/content/ClipboardManager
    //   218: aload 5
    //   220: invokevirtual 275	android/content/ClipboardManager:setText	(Ljava/lang/CharSequence;)V
    //   223: aload_3
    //   224: getfield 278	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:a	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   227: aload_1
    //   228: invokevirtual 281	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase:getName	()Ljava/lang/String;
    //   231: invokestatic 286	tcc:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;Ljava/lang/String;)Lorg/json/JSONObject;
    //   234: astore_2
    //   235: aload_3
    //   236: instanceof 288
    //   239: ifeq +71 -> 310
    //   242: aload_1
    //   243: invokevirtual 281	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase:getName	()Ljava/lang/String;
    //   246: aload_3
    //   247: checkcast 288	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusRecommendItemData
    //   250: aload_2
    //   251: invokestatic 291	tcc:a	(Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusRecommendItemData;Lorg/json/JSONObject;)V
    //   254: return
    //   255: astore 5
    //   257: aload 5
    //   259: invokevirtual 53	org/json/JSONException:printStackTrace	()V
    //   262: goto -75 -> 187
    //   265: aload_0
    //   266: aload 7
    //   268: aload 4
    //   270: aload 5
    //   272: aload 6
    //   274: invokespecial 294	szv:a	(Lcom/tencent/open/downloadnew/DownloadInfo;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V
    //   277: goto -90 -> 187
    //   280: astore_2
    //   281: ldc 151
    //   283: iconst_1
    //   284: new 153	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   291: ldc_w 296
    //   294: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload_2
    //   298: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 301	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: goto -84 -> 223
    //   310: aload_1
    //   311: invokevirtual 281	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase:getName	()Ljava/lang/String;
    //   314: aload 4
    //   316: aload_2
    //   317: invokestatic 304	tcc:a	(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    //   320: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	this	szv
    //   0	321	1	paramViewBase	ViewBase
    //   0	321	2	paramContext	Context
    //   0	321	3	paramProteusItemData	ProteusItemData
    //   4	311	4	localJSONObject	JSONObject
    //   18	201	5	localObject	java.lang.Object
    //   255	16	5	localJSONException	JSONException
    //   10	263	6	str	String
    //   70	197	7	localDownloadInfo	DownloadInfo
    // Exception table:
    //   from	to	target	type
    //   139	187	255	org/json/JSONException
    //   208	223	280	java/lang/Throwable
  }
  
  private void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData, String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    ogc.a(ogc.a("https://qbdsp.html5.qq.com/ug/stat?st=CgBOEgABiDILFgcxMDY5Mjc1IiAAAAA2JjkuMTQ2LjEzMy4xMzdfMTU4MzEzMzUwODgzMV8xNzc4NDA5ODA0Ql5cs0RZDIADnQAAGwwQASYGNDE5NzYzNgk2NjY2NjY2NjZGAFACbKgM&itemid=ARTICLE_ID&qq=USER_QQ&acttype=ACTION_TYPE", paramString2, "3"));
    ogc.a(ogc.a("https://qbdsp.html5.qq.com/ug/stat?st=CgBOEgABiDILFgcxMDY5Mjc1IiAAAAA2JjkuMTQ2LjEzMy4xMzdfMTU4MzEzMzUwODgzMV8xNzc4NDA5ODA0Ql5cs0RZDIADnQAAGwwQASYGNDE5NzYzNgk2NjY2NjY2NjZGAFACbKgM&itemid=ARTICLE_ID&qq=USER_QQ&acttype=ACTION_TYPE", paramString2, "7"));
    paramString2 = paramString1;
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = pha.a(paramString1, paramJSONObject);
      pha.d(paramContext, paramString2);
    }
    paramContext = tcc.a(paramProteusItemData.a, paramViewBase.getName());
    if ((paramProteusItemData instanceof ProteusRecommendItemData)) {
      tcc.a(paramViewBase.getName(), (ProteusRecommendItemData)paramProteusItemData, paramContext);
    }
    for (;;)
    {
      QLog.d("WebProteusViewCreator", 1, "onClick,schema=" + paramString2 + " viewID=" + paramViewBase.getName());
      return;
      tcc.a(paramViewBase.getName(), paramJSONObject, paramContext);
    }
  }
  
  private void a(DownloadInfo paramDownloadInfo, JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (paramDownloadInfo.a() == 4)
    {
      ogc.a(ogc.a("https://qbdsp.html5.qq.com/ug/stat?st=CgBOEgABiDILFgcxMDY5Mjc2IiAAAAA2JTkuMTQ2LjE0NC42MV8xNTgzMTMzNDQ0Njk1XzExNTYyNzY1MTNCXlyzBFkMgAOdAAAbDBABJgY0MTk3NjI2CTY2NjY2NjY2NkYAUAFsqAw%3D&itemid=ARTICLE_ID&qq=USER_QQ&acttype=ACTION_TYPE", paramString1, "20"));
      if (!bisa.a().a(paramDownloadInfo)) {
        bisa.a().b(paramDownloadInfo);
      }
    }
    for (;;)
    {
      return;
      if (a(paramDownloadInfo.a()))
      {
        bisa.a().a(paramString2);
        ogc.a(ogc.a("https://qbdsp.html5.qq.com/ug/stat?st=CgBOEgABiDILFgcxMDY5Mjc2IiAAAAA2JTkuMTQ2LjE0NC42MV8xNTgzMTMzNDQ0Njk1XzExNTYyNzY1MTNCXlyzBFkMgAOdAAAbDBABJgY0MTk3NjI2CTY2NjY2NjY2NkYAUAFsqAw%3D&itemid=ARTICLE_ID&qq=USER_QQ&acttype=ACTION_TYPE", paramString1, "22"));
        return;
      }
      ogc.a(ogc.a("https://qbdsp.html5.qq.com/ug/stat?st=CgBOEgABiDILFgcxMDY5Mjc2IiAAAAA2JTkuMTQ2LjE0NC42MV8xNTgzMTMzNDQ0Njk1XzExNTYyNzY1MTNCXlyzBFkMgAOdAAAbDBABJgY0MTk3NjI2CTY2NjY2NjY2NkYAUAFsqAw%3D&itemid=ARTICLE_ID&qq=USER_QQ&acttype=ACTION_TYPE", paramString1, "10"));
      bisa.a().b(paramDownloadInfo);
      try
      {
        paramJSONObject = paramJSONObject.getJSONObject("id_recommend_category_txt");
        paramJSONObject.put("text", "下载中..." + paramDownloadInfo.f + "%");
        paramJSONObject.put("label_ug_progress_progress", paramDownloadInfo.f);
        if (szu.a(this.jdField_a_of_type_Szu) != null)
        {
          szu.a(this.jdField_a_of_type_Szu).notifyDataSetChanged();
          return;
        }
      }
      catch (JSONException paramDownloadInfo)
      {
        paramDownloadInfo.printStackTrace();
      }
    }
  }
  
  private boolean a()
  {
    return !bgnw.a(BaseApplicationImpl.getContext(), "com.tencent.reading").equals("0");
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 30) || (paramInt == 10) || (paramInt == 20) || (paramInt == 1) || (paramInt == 2);
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    return (paramJSONObject != null) && (paramJSONObject.opt("id_recommend_category_txt") != null) && (paramJSONObject.opt("kd_ug_download_url") != null);
  }
  
  private tal b()
  {
    return new taf(this);
  }
  
  private void b(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    JSONObject localJSONObject = paramProteusItemData.c;
    String str2 = paramViewBase.getEventAttachedData();
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = pha.a(str2, localJSONObject);
      pha.d(paramContext, str1);
    }
    paramContext = tcc.a(paramProteusItemData.a, paramViewBase.getName());
    if ((paramProteusItemData instanceof ProteusRecommendItemData)) {
      tcc.a(paramViewBase.getName(), (ProteusRecommendItemData)paramProteusItemData, paramContext);
    }
    for (;;)
    {
      QLog.d("WebProteusViewCreator", 1, "[defaultUrlJump], schema = " + str1 + ", viewID = " + paramViewBase.getName());
      return;
      tcc.a(paramViewBase.getName(), localJSONObject, paramContext);
    }
  }
  
  private tal c()
  {
    return new tag(this);
  }
  
  private tal d()
  {
    return new tah(this);
  }
  
  private tal e()
  {
    return new tai(this);
  }
  
  private tal f()
  {
    return new taj(this);
  }
  
  private tal g()
  {
    return new tak(this);
  }
  
  private tal h()
  {
    return new szy(this);
  }
  
  private tal i()
  {
    return new szz(this);
  }
  
  private tal j()
  {
    if (this.jdField_a_of_type_Tal == null) {
      this.jdField_a_of_type_Tal = new taa(this);
    }
    return this.jdField_a_of_type_Tal;
  }
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer == null) || (paramBaseData2 == null)) {}
    for (;;)
    {
      return;
      if (!(paramBaseData2 instanceof ProteusItemData)) {
        continue;
      }
      paramBaseData1 = (ProteusItemData)paramBaseData2;
      TemplateBean localTemplateBean = paramBaseData1.a;
      if (localTemplateBean != null) {
        szu.a(this.jdField_a_of_type_Szu, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer);
      }
      try
      {
        localTemplateBean.bindData(paramBaseData1.c);
        pfr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramBaseData1.a.getViewBean());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData = paramBaseData1;
        label77:
        a(szu.a(this.jdField_a_of_type_Szu), paramBaseData1);
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, paramBaseData2);
        if (!(paramBaseData2 instanceof ProteusAnimationItemData)) {
          continue;
        }
        ((ProteusAnimationItemData)paramBaseData2).a(this.jdField_a_of_type_AndroidViewView);
        return;
      }
      catch (Exception localException)
      {
        break label77;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     szv
 * JD-Core Version:    0.7.0.1
 */