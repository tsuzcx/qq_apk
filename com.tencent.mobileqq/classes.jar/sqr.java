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

class sqr
  extends spi
{
  private SparseArray<srh> jdField_a_of_type_AndroidUtilSparseArray;
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private srh jdField_a_of_type_Srh;
  
  public sqr(sqq paramsqq, View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    if ((paramView instanceof Container)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = ((Container)paramView);
    }
    b();
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
  
  private srh a()
  {
    return new sra(this);
  }
  
  private srh a(int paramInt)
  {
    srh localsrh = (srh)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localsrh != null) {
      return localsrh;
    }
    return j();
  }
  
  private void a(Context paramContext, ProteusItemData paramProteusItemData)
  {
    ViewFactory.findClickableViewListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), new sqs(this, paramContext, paramProteusItemData));
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
        if (((ProteusItemData)paramBaseData).u == 1)
        {
          paramView.setOnLongClickListener(new sqx(this, paramView, localProteusItemData));
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
    //   1: getfield 146	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:c	Lorg/json/JSONObject;
    //   4: astore 4
    //   6: aload_1
    //   7: invokevirtual 151	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase:getEventAttachedData	()Ljava/lang/String;
    //   10: astore 6
    //   12: aload_0
    //   13: aload 4
    //   15: invokespecial 153	sqr:a	(Lorg/json/JSONObject;)Ljava/lang/String;
    //   18: astore 5
    //   20: aload_0
    //   21: invokespecial 156	sqr:a	()Z
    //   24: ifeq +17 -> 41
    //   27: aload_0
    //   28: aload_1
    //   29: aload_2
    //   30: aload_3
    //   31: aload 6
    //   33: aload 4
    //   35: aload 5
    //   37: invokespecial 159	sqr:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;Landroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   40: return
    //   41: ldc 161
    //   43: aload 5
    //   45: ldc 163
    //   47: invokestatic 168	ohk:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   50: invokestatic 171	ohk:a	(Ljava/lang/String;)V
    //   53: aload 4
    //   55: ldc 173
    //   57: invokevirtual 176	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   60: astore 6
    //   62: invokestatic 181	bjsz:a	()Lbjsz;
    //   65: aload 6
    //   67: invokevirtual 184	bjsz:b	(Ljava/lang/String;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   70: astore 7
    //   72: aload 7
    //   74: ifnonnull +188 -> 262
    //   77: ldc 161
    //   79: aload 5
    //   81: ldc 186
    //   83: invokestatic 168	ohk:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   86: invokestatic 171	ohk:a	(Ljava/lang/String;)V
    //   89: ldc 161
    //   91: aload 5
    //   93: ldc 188
    //   95: invokestatic 168	ohk:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   98: invokestatic 171	ohk:a	(Ljava/lang/String;)V
    //   101: new 190	com/tencent/open/downloadnew/DownloadInfo
    //   104: dup
    //   105: invokespecial 191	com/tencent/open/downloadnew/DownloadInfo:<init>	()V
    //   108: astore 5
    //   110: aload 5
    //   112: aload 6
    //   114: putfield 194	com/tencent/open/downloadnew/DownloadInfo:d	Ljava/lang/String;
    //   117: aload 5
    //   119: ldc 196
    //   121: putfield 199	com/tencent/open/downloadnew/DownloadInfo:m	Ljava/lang/String;
    //   124: aload 5
    //   126: ldc 201
    //   128: putfield 204	com/tencent/open/downloadnew/DownloadInfo:e	Ljava/lang/String;
    //   131: invokestatic 181	bjsz:a	()Lbjsz;
    //   134: aload 5
    //   136: invokevirtual 207	bjsz:b	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   139: aload 4
    //   141: ldc 209
    //   143: invokevirtual 45	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   146: astore 5
    //   148: aload 5
    //   150: ldc 211
    //   152: ldc 213
    //   154: invokevirtual 217	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   157: pop
    //   158: aload 5
    //   160: ldc 219
    //   162: iconst_0
    //   163: invokevirtual 222	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   166: pop
    //   167: aload_0
    //   168: getfield 16	sqr:jdField_a_of_type_Sqq	Lsqq;
    //   171: invokestatic 227	sqq:a	(Lsqq;)Landroid/widget/BaseAdapter;
    //   174: ifnull +13 -> 187
    //   177: aload_0
    //   178: getfield 16	sqr:jdField_a_of_type_Sqq	Lsqq;
    //   181: invokestatic 227	sqq:a	(Lsqq;)Landroid/widget/BaseAdapter;
    //   184: invokevirtual 232	android/widget/BaseAdapter:notifyDataSetChanged	()V
    //   187: aload 4
    //   189: ldc 234
    //   191: invokevirtual 41	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   194: ifnull +26 -> 220
    //   197: aload 4
    //   199: ldc 234
    //   201: invokevirtual 176	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   204: astore 5
    //   206: aload_2
    //   207: ldc 236
    //   209: invokevirtual 241	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   212: checkcast 243	android/content/ClipboardManager
    //   215: aload 5
    //   217: invokevirtual 247	android/content/ClipboardManager:setText	(Ljava/lang/CharSequence;)V
    //   220: aload_3
    //   221: getfield 250	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:a	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   224: aload_1
    //   225: invokevirtual 253	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase:getName	()Ljava/lang/String;
    //   228: invokestatic 258	ssy:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;Ljava/lang/String;)Lorg/json/JSONObject;
    //   231: astore_2
    //   232: aload_3
    //   233: instanceof 260
    //   236: ifeq +71 -> 307
    //   239: aload_1
    //   240: invokevirtual 253	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase:getName	()Ljava/lang/String;
    //   243: aload_3
    //   244: checkcast 260	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusRecommendItemData
    //   247: aload_2
    //   248: invokestatic 263	ssy:a	(Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusRecommendItemData;Lorg/json/JSONObject;)V
    //   251: return
    //   252: astore 5
    //   254: aload 5
    //   256: invokevirtual 54	org/json/JSONException:printStackTrace	()V
    //   259: goto -72 -> 187
    //   262: aload_0
    //   263: aload 7
    //   265: aload 4
    //   267: aload 5
    //   269: aload 6
    //   271: invokespecial 266	sqr:a	(Lcom/tencent/open/downloadnew/DownloadInfo;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V
    //   274: goto -87 -> 187
    //   277: astore_2
    //   278: ldc 118
    //   280: iconst_1
    //   281: new 120	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   288: ldc_w 268
    //   291: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: aload_2
    //   295: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 273	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   304: goto -84 -> 220
    //   307: aload_1
    //   308: invokevirtual 253	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase:getName	()Ljava/lang/String;
    //   311: aload 4
    //   313: aload_2
    //   314: invokestatic 276	ssy:a	(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    //   317: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	this	sqr
    //   0	318	1	paramViewBase	ViewBase
    //   0	318	2	paramContext	Context
    //   0	318	3	paramProteusItemData	ProteusItemData
    //   4	308	4	localJSONObject	JSONObject
    //   18	198	5	localObject	java.lang.Object
    //   252	16	5	localJSONException	JSONException
    //   10	260	6	str	String
    //   70	194	7	localDownloadInfo	DownloadInfo
    // Exception table:
    //   from	to	target	type
    //   139	187	252	org/json/JSONException
    //   206	220	277	java/lang/Throwable
  }
  
  private void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData, String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    ohk.a(ohk.a("https://qbdsp.html5.qq.com/ug/stat?st=CgBOEgABiDILFgcxMDY5Mjc1IiAAAAA2JjkuMTQ2LjEzMy4xMzdfMTU4MzEzMzUwODgzMV8xNzc4NDA5ODA0Ql5cs0RZDIADnQAAGwwQASYGNDE5NzYzNgk2NjY2NjY2NjZGAFACbKgM&itemid=ARTICLE_ID&qq=USER_QQ&acttype=ACTION_TYPE", paramString2, "3"));
    ohk.a(ohk.a("https://qbdsp.html5.qq.com/ug/stat?st=CgBOEgABiDILFgcxMDY5Mjc1IiAAAAA2JjkuMTQ2LjEzMy4xMzdfMTU4MzEzMzUwODgzMV8xNzc4NDA5ODA0Ql5cs0RZDIADnQAAGwwQASYGNDE5NzYzNgk2NjY2NjY2NjZGAFACbKgM&itemid=ARTICLE_ID&qq=USER_QQ&acttype=ACTION_TYPE", paramString2, "7"));
    paramString2 = paramString1;
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString2 = ozs.a(paramString1, paramJSONObject);
      ozs.d(paramContext, paramString2);
    }
    paramContext = ssy.a(paramProteusItemData.a, paramViewBase.getName());
    if ((paramProteusItemData instanceof ProteusRecommendItemData)) {
      ssy.a(paramViewBase.getName(), (ProteusRecommendItemData)paramProteusItemData, paramContext);
    }
    for (;;)
    {
      QLog.d("WebProteusViewCreator", 1, "onClick,schema=" + paramString2 + " viewID=" + paramViewBase.getName());
      return;
      ssy.a(paramViewBase.getName(), paramJSONObject, paramContext);
    }
  }
  
  private void a(DownloadInfo paramDownloadInfo, JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (paramDownloadInfo.a() == 4)
    {
      ohk.a(ohk.a("https://qbdsp.html5.qq.com/ug/stat?st=CgBOEgABiDILFgcxMDY5Mjc2IiAAAAA2JTkuMTQ2LjE0NC42MV8xNTgzMTMzNDQ0Njk1XzExNTYyNzY1MTNCXlyzBFkMgAOdAAAbDBABJgY0MTk3NjI2CTY2NjY2NjY2NkYAUAFsqAw%3D&itemid=ARTICLE_ID&qq=USER_QQ&acttype=ACTION_TYPE", paramString1, "20"));
      if (!bjsz.a().a(paramDownloadInfo)) {
        bjsz.a().b(paramDownloadInfo);
      }
    }
    for (;;)
    {
      return;
      if (a(paramDownloadInfo.a()))
      {
        bjsz.a().a(paramString2);
        ohk.a(ohk.a("https://qbdsp.html5.qq.com/ug/stat?st=CgBOEgABiDILFgcxMDY5Mjc2IiAAAAA2JTkuMTQ2LjE0NC42MV8xNTgzMTMzNDQ0Njk1XzExNTYyNzY1MTNCXlyzBFkMgAOdAAAbDBABJgY0MTk3NjI2CTY2NjY2NjY2NkYAUAFsqAw%3D&itemid=ARTICLE_ID&qq=USER_QQ&acttype=ACTION_TYPE", paramString1, "22"));
        return;
      }
      ohk.a(ohk.a("https://qbdsp.html5.qq.com/ug/stat?st=CgBOEgABiDILFgcxMDY5Mjc2IiAAAAA2JTkuMTQ2LjE0NC42MV8xNTgzMTMzNDQ0Njk1XzExNTYyNzY1MTNCXlyzBFkMgAOdAAAbDBABJgY0MTk3NjI2CTY2NjY2NjY2NkYAUAFsqAw%3D&itemid=ARTICLE_ID&qq=USER_QQ&acttype=ACTION_TYPE", paramString1, "10"));
      bjsz.a().b(paramDownloadInfo);
      try
      {
        paramJSONObject = paramJSONObject.getJSONObject("id_recommend_category_txt");
        paramJSONObject.put("text", "下载中..." + paramDownloadInfo.f + "%");
        paramJSONObject.put("label_ug_progress_progress", paramDownloadInfo.f);
        if (sqq.a(this.jdField_a_of_type_Sqq) != null)
        {
          sqq.a(this.jdField_a_of_type_Sqq).notifyDataSetChanged();
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
    return !bhny.a(BaseApplicationImpl.getContext(), "com.tencent.reading").equals("0");
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 30) || (paramInt == 10) || (paramInt == 20) || (paramInt == 1) || (paramInt == 2);
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    return (paramJSONObject != null) && (paramJSONObject.opt("id_recommend_category_txt") != null) && (paramJSONObject.opt("kd_ug_download_url") != null);
  }
  
  private srh b()
  {
    return new srb(this);
  }
  
  private void b()
  {
    this.jdField_a_of_type_Srh = null;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1012, a());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1023, b());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1002, c());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1001, d());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1157, e());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1153, f());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1156, g());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1169, h());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1038, h());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1040, i());
    j();
  }
  
  private void b(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    JSONObject localJSONObject = paramProteusItemData.c;
    String str2 = paramViewBase.getEventAttachedData();
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = ozs.a(str2, localJSONObject);
      ozs.d(paramContext, str1);
    }
    paramContext = ssy.a(paramProteusItemData.a, paramViewBase.getName());
    if ((paramProteusItemData instanceof ProteusRecommendItemData)) {
      ssy.a(paramViewBase.getName(), (ProteusRecommendItemData)paramProteusItemData, paramContext);
    }
    for (;;)
    {
      QLog.d("WebProteusViewCreator", 1, "[defaultUrlJump], schema = " + str1 + ", viewID = " + paramViewBase.getName());
      return;
      ssy.a(paramViewBase.getName(), localJSONObject, paramContext);
    }
  }
  
  private srh c()
  {
    return new src(this);
  }
  
  private srh d()
  {
    return new srd(this);
  }
  
  private srh e()
  {
    return new sre(this);
  }
  
  private srh f()
  {
    return new srf(this);
  }
  
  private srh g()
  {
    return new srg(this);
  }
  
  private srh h()
  {
    return new squ(this);
  }
  
  private srh i()
  {
    return new sqv(this);
  }
  
  private srh j()
  {
    if (this.jdField_a_of_type_Srh == null) {
      this.jdField_a_of_type_Srh = new sqw(this);
    }
    return this.jdField_a_of_type_Srh;
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
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
        sqq.a(this.jdField_a_of_type_Sqq, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer);
      }
      try
      {
        localTemplateBean.bindData(paramBaseData1.c);
        oyj.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramBaseData1.a.getViewBean());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData = paramBaseData1;
        label77:
        a(sqq.a(this.jdField_a_of_type_Sqq), paramBaseData1);
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
 * Qualified Name:     sqr
 * JD-Core Version:    0.7.0.1
 */