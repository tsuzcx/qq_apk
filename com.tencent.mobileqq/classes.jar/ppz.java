import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ppz
{
  private static String jdField_a_of_type_JavaLangString = "DynamicItemViewHelper";
  private static int c = 2147483647;
  private final int jdField_a_of_type_Int = 141;
  private BaseTemplateFactory jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryBaseTemplateFactory;
  private final Map<String, Integer> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private pmc jdField_a_of_type_Pmc;
  private int b = 141;
  
  public static int a(TemplateBean paramTemplateBean)
  {
    if ((paramTemplateBean != null) && (paramTemplateBean.getViewBean() != null)) {}
    for (;;)
    {
      try
      {
        Object localObject = paramTemplateBean.getDataAttribute(null, "feeds_type");
        if (localObject != null)
        {
          localObject = localObject.toString();
          if (localObject == null)
          {
            QLog.d(jdField_a_of_type_JavaLangString, 1, "getReportType: " + paramTemplateBean);
            return -1024;
          }
        }
        else
        {
          localObject = (String)paramTemplateBean.getViewBean().getDynamicValue("report_feeds_type");
          continue;
        }
        i = Integer.valueOf((String)localObject).intValue();
        return i;
      }
      catch (Exception paramTemplateBean)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, paramTemplateBean, new Object[] { "getReportType" });
      }
      int i = -1024;
    }
  }
  
  private static ProteusItemView a(ProteusItemView paramProteusItemView, VafContext paramVafContext, TemplateBean paramTemplateBean)
  {
    Container localContainer = paramVafContext.getViewFactory().inflate(paramVafContext, paramTemplateBean);
    paramTemplateBean = paramProteusItemView;
    if (localContainer != null)
    {
      paramTemplateBean = paramProteusItemView;
      if (paramProteusItemView == null) {
        paramTemplateBean = new ProteusItemView(paramVafContext.getContext());
      }
      paramTemplateBean.a(localContainer);
    }
    return paramTemplateBean;
  }
  
  private TemplateBean a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getTemplateBean : " + paramBaseArticleInfo);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryBaseTemplateFactory == null) {
      paramBaseArticleInfo = null;
    }
    for (;;)
    {
      return paramBaseArticleInfo;
      try
      {
        if ((paramBaseArticleInfo.mProteusTemplateBean != null) && (!((sfq)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryBaseTemplateFactory).a(paramBaseArticleInfo.mProteusTemplateBean))) {
          return paramBaseArticleInfo.mProteusTemplateBean;
        }
        if (this.jdField_a_of_type_Pmc == null) {
          return null;
        }
        JSONObject localJSONObject = this.jdField_a_of_type_Pmc.a(140, paramBaseArticleInfo);
        localTemplateBean = this.jdField_a_of_type_Pmc.a(140, localJSONObject);
        try
        {
          paramBaseArticleInfo.mProteusTemplateBean = localTemplateBean;
          paramBaseArticleInfo = localTemplateBean;
          if (localTemplateBean != null)
          {
            paramBaseArticleInfo = localTemplateBean;
            if (localTemplateBean.getViewBean() != null)
            {
              paramBaseArticleInfo = localTemplateBean;
              if (localJSONObject != null)
              {
                paramBaseArticleInfo = localTemplateBean;
                if (localJSONObject.has("report_feeds_type"))
                {
                  localTemplateBean.getViewBean().putDynamicValue("report_feeds_type", localJSONObject.getString("report_feeds_type"));
                  return localTemplateBean;
                }
              }
            }
          }
        }
        catch (JSONException paramBaseArticleInfo) {}
      }
      catch (JSONException paramBaseArticleInfo)
      {
        for (;;)
        {
          TemplateBean localTemplateBean = null;
        }
      }
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, paramBaseArticleInfo, new Object[] { "getView" });
    return localTemplateBean;
  }
  
  private static void a(View paramView)
  {
    if (paramView != null)
    {
      paramView.setVisibility(8);
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.height = 0;
        paramView.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  private static void a(ProteusItemView paramProteusItemView)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "setGone");
    if (paramProteusItemView == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "setGone proteusItemView == null");
      return;
    }
    a(paramProteusItemView.a());
    a(paramProteusItemView);
  }
  
  private void a(String paramString)
  {
    if ((!this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) && (this.b < c - 1))
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(this.b));
      this.b += 1;
      QLog.d(jdField_a_of_type_JavaLangString, 2, "addViewType : " + paramString + " TYPE_DYNAMIC_END: " + this.b + "  TYPE_DYNAMIC_MAX_END : " + c);
    }
  }
  
  private void a(pgd parampgd, VafContext paramVafContext)
  {
    paramVafContext = parampgd.a();
    if (paramVafContext != null)
    {
      parampgd = paramVafContext.b(parampgd.g() + 1);
      if ((parampgd != null) && (parampgd.mProteusTemplateBean == null)) {
        parampgd.mProteusTemplateBean = a(parampgd);
      }
    }
  }
  
  public static boolean a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    while (paramArticleInfo.mFeedType != 29) {
      return false;
    }
    return true;
  }
  
  private static void b(ProteusItemView paramProteusItemView)
  {
    if (paramProteusItemView == null) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "setVisible proteusItemView == null");
    }
    do
    {
      return;
      Container localContainer = paramProteusItemView.a();
      if ((localContainer != null) && (localContainer.getVisibility() == 8))
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "container.getVisibility() == View.GONE");
        localContainer.setVisibility(0);
        aepi.a(jdField_a_of_type_JavaLangString, "", new IllegalArgumentException("container.getVisibility() == View.GONE"));
      }
    } while (paramProteusItemView.getVisibility() != 8);
    QLog.d(jdField_a_of_type_JavaLangString, 1, "proteusItemView.getVisibility() == View.GONE");
    paramProteusItemView.setVisibility(0);
    aepi.a(jdField_a_of_type_JavaLangString, "", new IllegalArgumentException("proteusItemView.getVisibility() == View.GONE"));
  }
  
  public int a()
  {
    if (c == 2147483647)
    {
      aepi.a(jdField_a_of_type_JavaLangString, "", new IllegalArgumentException(alud.a(2131703966)));
      return this.b - 140 + 1;
    }
    return c - 140 + 1;
  }
  
  public int a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return 140;
    }
    TemplateBean localTemplateBean = a(paramArticleInfo);
    Integer localInteger = null;
    if (localTemplateBean != null)
    {
      a(localTemplateBean.getStyleName());
      localInteger = (Integer)this.jdField_a_of_type_JavaUtilMap.get(localTemplateBean.getStyleName());
    }
    if (localInteger == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getType: templateBean : " + localTemplateBean + " data: " + paramArticleInfo.proteusItemsData);
      return 140;
    }
    if ((localInteger.intValue() < 140) || (localInteger.intValue() >= this.b))
    {
      aepi.a(jdField_a_of_type_JavaLangString, "", new IllegalArgumentException(alud.a(2131703967)));
      return 140;
    }
    return localInteger.intValue();
  }
  
  public ProteusItemView a(VafContext paramVafContext, int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject2 = null;
    biby.a("DynamicPTS.getView");
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        if (paramBaseArticleInfo != null)
        {
          localObject1 = localObject2;
          QLog.d(jdField_a_of_type_JavaLangString, 1, " " + paramBaseArticleInfo.mArticleID + ":" + paramBaseArticleInfo.proteusItemsData);
        }
        localObject1 = localObject2;
        localObject3 = a(paramBaseArticleInfo);
        localObject1 = localObject2;
        localObject2 = a(null, paramVafContext, (TemplateBean)localObject3);
        localObject1 = localObject2;
        long l2 = System.currentTimeMillis();
        localObject1 = localObject2;
        String str = jdField_a_of_type_JavaLangString;
        if (localObject3 == null) {
          continue;
        }
        localObject1 = localObject2;
        localObject3 = ((TemplateBean)localObject3).getStyleName();
        localObject1 = localObject2;
        srq.a(str, (String)localObject3, "DynamicPTS.getView", l2 - l1);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        Object localObject3;
        QLog.e(jdField_a_of_type_JavaLangString, 1, localException, new Object[] { "getView" });
        aepi.a(jdField_a_of_type_JavaLangString, "getView:", new IllegalArgumentException(paramBaseArticleInfo.proteusItemsData, localException));
        continue;
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new ProteusItemView(paramVafContext.getContext());
        a((ProteusItemView)localObject2);
      }
      if (paramInt == 140)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "getView gone : " + paramBaseArticleInfo);
        a((ProteusItemView)localObject2);
      }
      biby.a();
      return localObject2;
      localObject3 = "";
    }
  }
  
  /* Error */
  public ProteusItemView a(VafContext paramVafContext, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: ldc_w 345
    //   3: iconst_1
    //   4: invokestatic 348	sfq:a	(Ljava/lang/String;Z)Lsfq;
    //   7: astore_3
    //   8: aload_3
    //   9: ifnull +64 -> 73
    //   12: aload_3
    //   13: aload_2
    //   14: invokevirtual 352	sfq:getTemplateBean	(Lorg/json/JSONObject;)Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   17: astore_2
    //   18: aload_1
    //   19: invokevirtual 105	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext:getViewFactory	()Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/ViewFactory;
    //   22: aload_1
    //   23: aload_2
    //   24: invokevirtual 111	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/utils/ViewFactory:inflate	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;)Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;
    //   27: astore 4
    //   29: aload 4
    //   31: ifnull +70 -> 101
    //   34: new 113	com/tencent/biz/pubaccount/readinjoy/proteus/item/ProteusItemView
    //   37: dup
    //   38: aload_1
    //   39: invokevirtual 117	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext:getContext	()Landroid/content/Context;
    //   42: invokespecial 120	com/tencent/biz/pubaccount/readinjoy/proteus/item/ProteusItemView:<init>	(Landroid/content/Context;)V
    //   45: astore_3
    //   46: aload_3
    //   47: aload 4
    //   49: invokevirtual 123	com/tencent/biz/pubaccount/readinjoy/proteus/item/ProteusItemView:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;)V
    //   52: aload 4
    //   54: aconst_null
    //   55: aload_2
    //   56: invokestatic 357	opy:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;)V
    //   59: aload_3
    //   60: aload_2
    //   61: invokevirtual 361	com/tencent/biz/pubaccount/readinjoy/proteus/item/ProteusItemView:setTemplateBean	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;)V
    //   64: aload 4
    //   66: aload_1
    //   67: aload_2
    //   68: invokestatic 364	opy:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/container/Container;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;)V
    //   71: aload_3
    //   72: areturn
    //   73: aconst_null
    //   74: astore_2
    //   75: goto -57 -> 18
    //   78: astore_2
    //   79: aconst_null
    //   80: astore_1
    //   81: getstatic 19	ppz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   84: iconst_1
    //   85: aload_2
    //   86: iconst_0
    //   87: anewarray 4	java/lang/Object
    //   90: invokestatic 337	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   93: aload_1
    //   94: areturn
    //   95: astore_2
    //   96: aload_3
    //   97: astore_1
    //   98: goto -17 -> 81
    //   101: aconst_null
    //   102: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	ppz
    //   0	103	1	paramVafContext	VafContext
    //   0	103	2	paramJSONObject	JSONObject
    //   7	90	3	localObject	Object
    //   27	38	4	localContainer	Container
    // Exception table:
    //   from	to	target	type
    //   0	8	78	java/lang/Exception
    //   12	18	78	java/lang/Exception
    //   18	29	78	java/lang/Exception
    //   34	46	78	java/lang/Exception
    //   46	71	95	java/lang/Exception
  }
  
  public String a(BaseArticleInfo paramBaseArticleInfo)
  {
    paramBaseArticleInfo = a(paramBaseArticleInfo);
    if (paramBaseArticleInfo != null) {
      return paramBaseArticleInfo.getStyleName();
    }
    return "";
  }
  
  public void a(ProteusItemView paramProteusItemView, int paramInt1, BaseArticleInfo paramBaseArticleInfo, VafContext paramVafContext, bdbb parambdbb, rqj paramrqj, pgd parampgd, int paramInt2)
  {
    biby.a("DynamicPTS.bindData");
    long l1 = System.currentTimeMillis();
    Object localObject2 = paramProteusItemView.a();
    TemplateBean localTemplateBean = a(paramBaseArticleInfo);
    if (paramProteusItemView.a() == null)
    {
      biby.a();
      QLog.d(jdField_a_of_type_JavaLangString, 1, "proteusItemView.getContainer == null bindData : " + paramBaseArticleInfo + " adapterViewType : " + paramInt1);
      a(paramProteusItemView, paramVafContext, localTemplateBean);
      biby.a();
      return;
    }
    if (paramInt1 == 140)
    {
      a(paramProteusItemView);
      biby.a();
      return;
    }
    b(paramProteusItemView);
    if (pqb.a()) {
      pqb.a(jdField_a_of_type_JavaLangString, "[bindData] " + paramBaseArticleInfo + " adapterViewType: " + paramInt1);
    }
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (localTemplateBean != null)
      {
        localObject1 = localObject2;
        if (!localTemplateBean.equals(localObject2))
        {
          biby.a("DynamicPTS.bindData.reuseView");
          localObject1 = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean);
          if (localObject1 != null)
          {
            ((Container)localObject1).setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130841381));
            paramProteusItemView.d();
            paramProteusItemView.a((Container)localObject1);
            opy.a((Container)localObject1, null, localTemplateBean);
          }
          paramBaseArticleInfo.mProteusTemplateBean = localTemplateBean;
          localObject1 = null;
          biby.a();
        }
      }
    }
    localObject2 = paramProteusItemView.a();
    paramProteusItemView.setModel(parampgd, paramrqj.a());
    paramProteusItemView.setTemplateBean(localTemplateBean);
    if (localTemplateBean != null)
    {
      biby.a("DynamicPTS.bindData.compareWithOldTemplateBean");
      opy.a((Container)localObject2, (TemplateBean)localObject1, localTemplateBean);
      biby.a();
    }
    biby.a("DynamicPTS.bindData.bindView");
    this.jdField_a_of_type_Pmc.a(paramInt1, (Container)localObject2, parampgd, paramInt2);
    biby.a();
    opy.a(paramInt1, (Container)localObject2, paramVafContext, parambdbb, paramrqj, parampgd, paramBaseArticleInfo);
    a(parampgd, paramVafContext);
    opy.a((Container)localObject2, parampgd, localTemplateBean);
    long l2 = System.currentTimeMillis();
    paramBaseArticleInfo = jdField_a_of_type_JavaLangString;
    if (localTemplateBean != null) {}
    for (paramProteusItemView = localTemplateBean.getStyleName();; paramProteusItemView = "")
    {
      srq.a(paramBaseArticleInfo, paramProteusItemView, "DynamicPTS.bindData", l2 - l1);
      biby.a();
      return;
    }
  }
  
  public void a(VafContext paramVafContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryBaseTemplateFactory = paramVafContext.getTemplateFactory();
    this.jdField_a_of_type_Pmc = new pmc(paramVafContext);
    int j = paramVafContext.getTemplateFactory().size();
    if ((this.b < j + 141) && (j > 0) && (this.b < c))
    {
      paramVafContext = paramVafContext.getTemplateFactory().getNameTemplateMap().keySet();
      int i = this.b;
      paramVafContext = paramVafContext.iterator();
      if (paramVafContext.hasNext())
      {
        String str = (String)paramVafContext.next();
        if (this.jdField_a_of_type_JavaUtilMap.containsKey(str)) {
          break label247;
        }
        this.jdField_a_of_type_JavaUtilMap.put(str, Integer.valueOf(i));
        i += 1;
      }
    }
    label247:
    for (;;)
    {
      break;
      this.b = (j + 141);
      if (c == 2147483647) {
        c = this.b + 30;
      }
      if (this.b > c) {
        this.b = c;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 1, "init: templateCount : " + j + " TYPE_DYNAMIC_END : " + this.b + " max : " + c);
      if (c == 2147483647) {
        c = 241;
      }
      return;
    }
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt >= 140) && (paramInt < this.b);
  }
  
  public boolean b(ArticleInfo paramArticleInfo)
  {
    return (a(paramArticleInfo)) && (a(paramArticleInfo) == 140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ppz
 * JD-Core Version:    0.7.0.1
 */