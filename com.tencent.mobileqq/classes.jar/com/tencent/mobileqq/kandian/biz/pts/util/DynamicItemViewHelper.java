package com.tencent.mobileqq.kandian.biz.pts.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder;
import com.tencent.mobileqq.kandian.biz.pts.api.IReadInJoyPTSCostHelper;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.biz.pts.item.DynamicProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.ProteusItemView;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.pts.PTSStyleManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class DynamicItemViewHelper
{
  private static int jdField_a_of_type_Int = 152;
  private static String jdField_a_of_type_JavaLangString = "DynamicItemViewHelper";
  private static final Map<String, Integer> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private static int b = 2147483647;
  private BaseTemplateFactory jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryBaseTemplateFactory;
  private DynamicProteusItem jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemDynamicProteusItem;
  
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
  
  private void a(IReadInJoyModel paramIReadInJoyModel, VafContext paramVafContext)
  {
    paramVafContext = (ReadInJoyBaseAdapter)paramIReadInJoyModel.a();
    if (paramVafContext != null)
    {
      paramIReadInJoyModel = paramVafContext.a(paramIReadInJoyModel.g() + 1);
      if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.mProteusTemplateBean == null)) {
        paramIReadInJoyModel.mProteusTemplateBean = a(paramIReadInJoyModel);
      }
    }
  }
  
  private void a(String paramString)
  {
    if (!jdField_a_of_type_JavaUtilMap.containsKey(paramString))
    {
      int i = jdField_a_of_type_Int;
      if (i < b - 1)
      {
        jdField_a_of_type_JavaUtilMap.put(paramString, Integer.valueOf(i));
        jdField_a_of_type_Int += 1;
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addViewType : ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" TYPE_DYNAMIC_END: ");
        localStringBuilder.append(jdField_a_of_type_Int);
        localStringBuilder.append("  TYPE_DYNAMIC_MAX_END : ");
        localStringBuilder.append(b);
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
  }
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool = false;
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    if (paramAbsBaseArticleInfo.mFeedType == 29) {
      bool = true;
    }
    return bool;
  }
  
  private static void b(ProteusItemView paramProteusItemView)
  {
    if (paramProteusItemView == null)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "setVisible proteusItemView == null");
      return;
    }
    Container localContainer = paramProteusItemView.a();
    if ((localContainer != null) && (localContainer.getVisibility() == 8))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "container.getVisibility() == View.GONE");
      localContainer.setVisibility(0);
      AIOUtils.a(jdField_a_of_type_JavaLangString, "", new IllegalArgumentException("container.getVisibility() == View.GONE"));
    }
    if (paramProteusItemView.getVisibility() == 8)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "proteusItemView.getVisibility() == View.GONE");
      paramProteusItemView.setVisibility(0);
      AIOUtils.a(jdField_a_of_type_JavaLangString, "", new IllegalArgumentException("proteusItemView.getVisibility() == View.GONE"));
    }
  }
  
  public int a()
  {
    int j = b;
    int i = j;
    if (j == 2147483647)
    {
      AIOUtils.a(jdField_a_of_type_JavaLangString, "", new IllegalArgumentException(HardCodeUtil.a(2131703735)));
      i = jdField_a_of_type_Int;
    }
    return i - 151 + 1;
  }
  
  public int a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return 151;
    }
    StringBuilder localStringBuilder = null;
    Object localObject = localStringBuilder;
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.proteusItemsData))
    {
      String str = PTSStyleManager.a(paramAbsBaseArticleInfo);
      localObject = localStringBuilder;
      if (!TextUtils.isEmpty(str))
      {
        a(str);
        localObject = (Integer)jdField_a_of_type_JavaUtilMap.get(str);
      }
    }
    if (localObject == null)
    {
      localObject = jdField_a_of_type_JavaLangString;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getType: templateBean, data: ");
      localStringBuilder.append(paramAbsBaseArticleInfo.proteusItemsData);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
      return 151;
    }
    if ((((Integer)localObject).intValue() >= 151) && (((Integer)localObject).intValue() < jdField_a_of_type_Int)) {
      return ((Integer)localObject).intValue();
    }
    AIOUtils.a(jdField_a_of_type_JavaLangString, "", new IllegalArgumentException(HardCodeUtil.a(2131703736)));
    return 151;
  }
  
  public TemplateBean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getTemplateBean : ");
      ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryBaseTemplateFactory;
    Object localObject2 = null;
    TemplateBean localTemplateBean = null;
    if (localObject1 != null)
    {
      if (paramAbsBaseArticleInfo == null) {
        return null;
      }
      localObject1 = localTemplateBean;
      try
      {
        if (paramAbsBaseArticleInfo.mProteusTemplateBean != null)
        {
          localObject1 = localTemplateBean;
          if (!((TemplateFactory)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryBaseTemplateFactory).a(paramAbsBaseArticleInfo.mProteusTemplateBean))
          {
            localObject1 = localTemplateBean;
            return paramAbsBaseArticleInfo.mProteusTemplateBean;
          }
        }
        localObject1 = localTemplateBean;
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemDynamicProteusItem == null) {
          return null;
        }
        localObject1 = localTemplateBean;
        JSONObject localJSONObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemDynamicProteusItem.a(151, paramAbsBaseArticleInfo);
        localObject1 = localTemplateBean;
        localTemplateBean = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemDynamicProteusItem.a(151, localJSONObject);
        localObject1 = localTemplateBean;
        paramAbsBaseArticleInfo.mProteusTemplateBean = localTemplateBean;
        localObject2 = localTemplateBean;
        if (localTemplateBean != null)
        {
          localObject1 = localTemplateBean;
          localObject2 = localTemplateBean;
          if (localTemplateBean.getViewBean() != null)
          {
            localObject2 = localTemplateBean;
            if (localJSONObject != null)
            {
              localObject1 = localTemplateBean;
              localObject2 = localTemplateBean;
              if (localJSONObject.has("report_feeds_type"))
              {
                localObject1 = localTemplateBean;
                localTemplateBean.getViewBean().putDynamicValue("report_feeds_type", localJSONObject.getString("report_feeds_type"));
                return localTemplateBean;
              }
            }
          }
        }
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, paramAbsBaseArticleInfo, new Object[] { "getView" });
        localObject2 = localObject1;
      }
    }
    return localObject2;
  }
  
  /* Error */
  public ProteusItemView a(VafContext paramVafContext, int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    // Byte code:
    //   0: ldc_w 279
    //   3: invokestatic 284	com/tencent/widget/TraceUtils:traceBegin	(Ljava/lang/String;)V
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 8
    //   12: invokestatic 290	java/lang/System:currentTimeMillis	()J
    //   15: lstore 4
    //   17: aload_3
    //   18: ifnull +66 -> 84
    //   21: getstatic 77	com/tencent/mobileqq/kandian/biz/pts/util/DynamicItemViewHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   24: astore 10
    //   26: new 137	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   33: astore 11
    //   35: aload 11
    //   37: ldc_w 292
    //   40: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 11
    //   46: aload_3
    //   47: getfield 296	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:mArticleID	J
    //   50: invokevirtual 299	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 11
    //   56: ldc_w 301
    //   59: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 11
    //   65: aload_3
    //   66: getfield 194	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:proteusItemsData	Ljava/lang/String;
    //   69: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 10
    //   75: iconst_1
    //   76: aload 11
    //   78: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 85	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: aload_0
    //   85: aload_3
    //   86: invokevirtual 116	com/tencent/mobileqq/kandian/biz/pts/util/DynamicItemViewHelper:a	(Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;)Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   89: astore 10
    //   91: aconst_null
    //   92: aload_1
    //   93: aload 10
    //   95: invokestatic 303	com/tencent/mobileqq/kandian/biz/pts/util/DynamicItemViewHelper:a	(Lcom/tencent/mobileqq/kandian/biz/pts/item/ProteusItemView;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext;Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;)Lcom/tencent/mobileqq/kandian/biz/pts/item/ProteusItemView;
    //   98: astore 9
    //   100: aload 9
    //   102: astore 8
    //   104: invokestatic 290	java/lang/System:currentTimeMillis	()J
    //   107: lstore 6
    //   109: aload 9
    //   111: astore 8
    //   113: ldc_w 305
    //   116: invokestatic 311	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   119: checkcast 305	com/tencent/mobileqq/kandian/biz/pts/api/IReadInJoyPTSCostHelper
    //   122: astore 11
    //   124: aload 9
    //   126: astore 8
    //   128: getstatic 77	com/tencent/mobileqq/kandian/biz/pts/util/DynamicItemViewHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   131: astore 12
    //   133: aload 10
    //   135: ifnull +189 -> 324
    //   138: aload 9
    //   140: astore 8
    //   142: aload 10
    //   144: invokevirtual 314	com/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean:getStyleName	()Ljava/lang/String;
    //   147: astore 10
    //   149: goto +3 -> 152
    //   152: aload 9
    //   154: astore 8
    //   156: aload 11
    //   158: aload 12
    //   160: aload 10
    //   162: ldc_w 279
    //   165: lload 6
    //   167: lload 4
    //   169: lsub
    //   170: l2d
    //   171: invokeinterface 318 6 0
    //   176: goto +64 -> 240
    //   179: astore 10
    //   181: aload 8
    //   183: astore 9
    //   185: goto +14 -> 199
    //   188: astore 8
    //   190: goto +5 -> 195
    //   193: astore 8
    //   195: aload 8
    //   197: astore 10
    //   199: getstatic 77	com/tencent/mobileqq/kandian/biz/pts/util/DynamicItemViewHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   202: iconst_1
    //   203: aload 10
    //   205: iconst_1
    //   206: anewarray 4	java/lang/Object
    //   209: dup
    //   210: iconst_0
    //   211: ldc_w 271
    //   214: aastore
    //   215: invokestatic 321	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   218: getstatic 77	com/tencent/mobileqq/kandian/biz/pts/util/DynamicItemViewHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   221: ldc_w 323
    //   224: new 173	java/lang/IllegalArgumentException
    //   227: dup
    //   228: aload_3
    //   229: getfield 194	com/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo:proteusItemsData	Ljava/lang/String;
    //   232: aload 10
    //   234: invokespecial 326	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   237: invokestatic 180	com/tencent/mobileqq/activity/aio/AIOUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/RuntimeException;)V
    //   240: aload 9
    //   242: astore 8
    //   244: aload 9
    //   246: ifnonnull +21 -> 267
    //   249: new 44	com/tencent/mobileqq/kandian/biz/pts/item/ProteusItemView
    //   252: dup
    //   253: aload_1
    //   254: invokevirtual 48	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/VafContext:getContext	()Landroid/content/Context;
    //   257: invokespecial 51	com/tencent/mobileqq/kandian/biz/pts/item/ProteusItemView:<init>	(Landroid/content/Context;)V
    //   260: astore 8
    //   262: aload 8
    //   264: invokestatic 328	com/tencent/mobileqq/kandian/biz/pts/util/DynamicItemViewHelper:a	(Lcom/tencent/mobileqq/kandian/biz/pts/item/ProteusItemView;)V
    //   267: iload_2
    //   268: sipush 151
    //   271: if_icmpne +47 -> 318
    //   274: getstatic 77	com/tencent/mobileqq/kandian/biz/pts/util/DynamicItemViewHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   277: astore_1
    //   278: new 137	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   285: astore 9
    //   287: aload 9
    //   289: ldc_w 330
    //   292: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload 9
    //   298: aload_3
    //   299: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload_1
    //   304: iconst_1
    //   305: aload 9
    //   307: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 332	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: aload 8
    //   315: invokestatic 328	com/tencent/mobileqq/kandian/biz/pts/util/DynamicItemViewHelper:a	(Lcom/tencent/mobileqq/kandian/biz/pts/item/ProteusItemView;)V
    //   318: invokestatic 335	com/tencent/widget/TraceUtils:traceEnd	()V
    //   321: aload 8
    //   323: areturn
    //   324: ldc 171
    //   326: astore 10
    //   328: goto -176 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	this	DynamicItemViewHelper
    //   0	331	1	paramVafContext	VafContext
    //   0	331	2	paramInt	int
    //   0	331	3	paramAbsBaseArticleInfo	AbsBaseArticleInfo
    //   15	153	4	l1	long
    //   107	59	6	l2	long
    //   10	172	8	localObject1	Object
    //   188	1	8	localException1	Exception
    //   193	3	8	localException2	Exception
    //   242	80	8	localObject2	Object
    //   7	299	9	localObject3	Object
    //   24	137	10	localObject4	Object
    //   179	1	10	localException3	Exception
    //   197	130	10	localObject5	Object
    //   33	124	11	localObject6	Object
    //   131	28	12	str	String
    // Exception table:
    //   from	to	target	type
    //   91	100	179	java/lang/Exception
    //   104	109	179	java/lang/Exception
    //   113	124	179	java/lang/Exception
    //   128	133	179	java/lang/Exception
    //   142	149	179	java/lang/Exception
    //   156	176	179	java/lang/Exception
    //   84	91	188	java/lang/Exception
    //   12	17	193	java/lang/Exception
    //   21	84	193	java/lang/Exception
  }
  
  public ProteusItemView a(VafContext paramVafContext, JSONObject paramJSONObject)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    for (;;)
    {
      try
      {
        Object localObject3 = TemplateFactory.a("default_feeds", true);
        if (localObject3 == null) {
          break label110;
        }
        paramJSONObject = ((TemplateFactory)localObject3).getTemplateBean(paramJSONObject);
        localObject3 = paramVafContext.getViewFactory().inflate(paramVafContext, paramJSONObject);
        if (localObject3 == null) {
          break label108;
        }
        localObject1 = new ProteusItemView(paramVafContext.getContext());
        try
        {
          ((ProteusItemView)localObject1).a((Container)localObject3);
          ProteusSupportUtil.a((Container)localObject3, null, paramJSONObject);
          ((ProteusItemView)localObject1).setTemplateBean(paramJSONObject);
          ProteusSupportUtil.a((Container)localObject3, paramVafContext, paramJSONObject);
          return localObject1;
        }
        catch (Exception paramJSONObject)
        {
          paramVafContext = (VafContext)localObject1;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 1, paramJSONObject, new Object[0]);
      }
      catch (Exception paramJSONObject)
      {
        paramVafContext = localObject2;
      }
      localObject1 = paramVafContext;
      label108:
      return localObject1;
      label110:
      paramJSONObject = null;
    }
  }
  
  public String a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramAbsBaseArticleInfo = a(paramAbsBaseArticleInfo);
    if (paramAbsBaseArticleInfo != null) {
      return paramAbsBaseArticleInfo.getStyleName();
    }
    return "";
  }
  
  public void a(VafContext paramVafContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusFactoryBaseTemplateFactory = paramVafContext.getTemplateFactory();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemDynamicProteusItem = new DynamicProteusItem(paramVafContext);
    int j = paramVafContext.getTemplateFactory().size();
    int i = jdField_a_of_type_Int;
    int k = j + 152;
    if ((i < k) && (j > 0) && (i < b))
    {
      paramVafContext = paramVafContext.getTemplateFactory().getNameTemplateMap().keySet();
      i = jdField_a_of_type_Int;
      paramVafContext = paramVafContext.iterator();
      while (paramVafContext.hasNext())
      {
        localObject = (String)paramVafContext.next();
        if (!jdField_a_of_type_JavaUtilMap.containsKey(localObject))
        {
          jdField_a_of_type_JavaUtilMap.put(localObject, Integer.valueOf(i));
          i += 1;
        }
      }
      jdField_a_of_type_Int = k;
      if (b == 2147483647) {
        b = jdField_a_of_type_Int + 30;
      }
      i = jdField_a_of_type_Int;
      k = b;
      if (i > k) {
        jdField_a_of_type_Int = k;
      }
      paramVafContext = jdField_a_of_type_JavaLangString;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("init: templateCount : ");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(" TYPE_DYNAMIC_END : ");
      ((StringBuilder)localObject).append(jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(" max : ");
      ((StringBuilder)localObject).append(b);
      QLog.d(paramVafContext, 1, ((StringBuilder)localObject).toString());
    }
    if (b == 2147483647) {
      b = 252;
    }
  }
  
  public void a(ProteusItemView paramProteusItemView, int paramInt1, AbsBaseArticleInfo paramAbsBaseArticleInfo, VafContext paramVafContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    TraceUtils.traceBegin("DynamicPTS.bindData");
    long l1 = System.currentTimeMillis();
    Object localObject2 = paramProteusItemView.a();
    TemplateBean localTemplateBean = a(paramAbsBaseArticleInfo);
    if (paramProteusItemView.a() == null)
    {
      TraceUtils.traceEnd();
      paramIFaceDecoder = jdField_a_of_type_JavaLangString;
      paramReadInJoyBaseAdapter = new StringBuilder();
      paramReadInJoyBaseAdapter.append("proteusItemView.getContainer == null bindData : ");
      paramReadInJoyBaseAdapter.append(paramAbsBaseArticleInfo);
      paramReadInJoyBaseAdapter.append(" adapterViewType : ");
      paramReadInJoyBaseAdapter.append(paramInt1);
      QLog.d(paramIFaceDecoder, 1, paramReadInJoyBaseAdapter.toString());
      a(paramProteusItemView, paramVafContext, localTemplateBean);
      TraceUtils.traceEnd();
      return;
    }
    if (paramInt1 == 151)
    {
      a(paramProteusItemView);
      TraceUtils.traceEnd();
      return;
    }
    b(paramProteusItemView);
    if (LogUtils.a())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[bindData] ");
      localStringBuilder.append(paramAbsBaseArticleInfo);
      localStringBuilder.append(" adapterViewType: ");
      localStringBuilder.append(paramInt1);
      LogUtils.a((String)localObject1, localStringBuilder.toString());
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
          TraceUtils.traceBegin("DynamicPTS.bindData.reuseView");
          localObject1 = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean);
          if (localObject1 != null)
          {
            ((Container)localObject1).setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130841773));
            paramProteusItemView.c();
            paramProteusItemView.a((Container)localObject1);
            ProteusSupportUtil.a((Container)localObject1, null, localTemplateBean);
          }
          paramAbsBaseArticleInfo.mProteusTemplateBean = localTemplateBean;
          TraceUtils.traceEnd();
          localObject1 = null;
        }
      }
    }
    localObject2 = paramProteusItemView.a();
    paramProteusItemView.setModel(paramIReadInJoyModel, paramReadInJoyBaseAdapter.a().a());
    paramProteusItemView.setTemplateBean(localTemplateBean);
    if (localTemplateBean != null)
    {
      TraceUtils.traceBegin("DynamicPTS.bindData.compareWithOldTemplateBean");
      ProteusSupportUtil.a((Container)localObject2, (TemplateBean)localObject1, localTemplateBean);
      TraceUtils.traceEnd();
    }
    TraceUtils.traceBegin("DynamicPTS.bindData.bindView");
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemDynamicProteusItem.a(paramInt1, (Container)localObject2, paramIReadInJoyModel, paramInt2);
    TraceUtils.traceEnd();
    ProteusSupportUtil.a(paramInt1, paramProteusItemView, paramVafContext, paramIFaceDecoder, paramReadInJoyBaseAdapter, paramIReadInJoyModel, paramAbsBaseArticleInfo);
    a(paramIReadInJoyModel, paramVafContext);
    ProteusSupportUtil.a((Container)localObject2, paramIReadInJoyModel, localTemplateBean);
    long l2 = System.currentTimeMillis();
    paramAbsBaseArticleInfo = (IReadInJoyPTSCostHelper)QRoute.api(IReadInJoyPTSCostHelper.class);
    paramVafContext = jdField_a_of_type_JavaLangString;
    if (localTemplateBean != null) {
      paramProteusItemView = localTemplateBean.getStyleName();
    } else {
      paramProteusItemView = "";
    }
    paramAbsBaseArticleInfo.printCost(paramVafContext, paramProteusItemView, "DynamicPTS.bindData", l2 - l1);
    TraceUtils.traceEnd();
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt >= 151) && (paramInt < jdField_a_of_type_Int);
  }
  
  public boolean b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool3 = a(paramAbsBaseArticleInfo);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (a(paramAbsBaseArticleInfo) == 151) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.DynamicItemViewHelper
 * JD-Core Version:    0.7.0.1
 */