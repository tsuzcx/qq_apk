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
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.biz.pts.item.DynamicProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.ProteusItemView;
import com.tencent.mobileqq.kandian.biz.pts.network.ReadInJoyPTSCostHelper;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.pts.PTSStyleManager;
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
  private static String a = "DynamicItemViewHelper";
  private static int b = 155;
  private static final Map<String, Integer> c = new ConcurrentHashMap();
  private static int e = 2147483647;
  private DynamicProteusItem d;
  private BaseTemplateFactory f;
  
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
    QLog.d(a, 1, "setGone");
    if (paramProteusItemView == null)
    {
      QLog.d(a, 1, "setGone proteusItemView == null");
      return;
    }
    a(paramProteusItemView.getContainer());
    a(paramProteusItemView);
  }
  
  private void a(IReadInJoyModel paramIReadInJoyModel, VafContext paramVafContext)
  {
    paramVafContext = (ReadInJoyBaseAdapter)paramIReadInJoyModel.u();
    if (paramVafContext != null)
    {
      paramIReadInJoyModel = paramVafContext.a(paramIReadInJoyModel.r() + 1);
      if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.mProteusTemplateBean == null)) {
        paramIReadInJoyModel.mProteusTemplateBean = e(paramIReadInJoyModel);
      }
    }
  }
  
  private void a(String paramString)
  {
    if (!c.containsKey(paramString))
    {
      int i = b;
      if (i < e - 1)
      {
        c.put(paramString, Integer.valueOf(i));
        b += 1;
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addViewType : ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" TYPE_DYNAMIC_END: ");
        localStringBuilder.append(b);
        localStringBuilder.append("  TYPE_DYNAMIC_MAX_END : ");
        localStringBuilder.append(e);
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
      QLog.d(a, 1, "setVisible proteusItemView == null");
      return;
    }
    Container localContainer = paramProteusItemView.getContainer();
    if ((localContainer != null) && (localContainer.getVisibility() == 8))
    {
      QLog.d(a, 1, "container.getVisibility() == View.GONE");
      localContainer.setVisibility(0);
      AIOUtils.a(a, "", new IllegalArgumentException("container.getVisibility() == View.GONE"));
    }
    if (paramProteusItemView.getVisibility() == 8)
    {
      QLog.d(a, 1, "proteusItemView.getVisibility() == View.GONE");
      paramProteusItemView.setVisibility(0);
      AIOUtils.a(a, "", new IllegalArgumentException("proteusItemView.getVisibility() == View.GONE"));
    }
  }
  
  public int a()
  {
    int j = e;
    int i = j;
    if (j == 2147483647)
    {
      AIOUtils.a(a, "", new IllegalArgumentException(HardCodeUtil.a(2131901681)));
      i = b;
    }
    return i - 154 + 1;
  }
  
  public ProteusItemView a(VafContext paramVafContext, int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    TraceUtils.traceBegin("DynamicPTS.getView");
    ProteusItemView localProteusItemView = null;
    Object localObject1 = localProteusItemView;
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        if (paramAbsBaseArticleInfo != null)
        {
          localObject1 = localProteusItemView;
          localObject3 = a;
          localObject1 = localProteusItemView;
          localObject4 = new StringBuilder();
          localObject1 = localProteusItemView;
          ((StringBuilder)localObject4).append(" ");
          localObject1 = localProteusItemView;
          ((StringBuilder)localObject4).append(paramAbsBaseArticleInfo.mArticleID);
          localObject1 = localProteusItemView;
          ((StringBuilder)localObject4).append(":");
          localObject1 = localProteusItemView;
          ((StringBuilder)localObject4).append(paramAbsBaseArticleInfo.proteusItemsData);
          localObject1 = localProteusItemView;
          QLog.d((String)localObject3, 1, ((StringBuilder)localObject4).toString());
        }
        localObject1 = localProteusItemView;
        localObject3 = e(paramAbsBaseArticleInfo);
        localObject1 = localProteusItemView;
        localProteusItemView = a(null, paramVafContext, (TemplateBean)localObject3);
        localObject1 = localProteusItemView;
        long l2 = System.currentTimeMillis();
        localObject1 = localProteusItemView;
        Object localObject4 = a;
        if (localObject3 == null) {
          break label321;
        }
        localObject1 = localProteusItemView;
        localObject3 = ((TemplateBean)localObject3).getStyleName();
        localObject1 = localProteusItemView;
        ReadInJoyPTSCostHelper.a((String)localObject4, (String)localObject3, "DynamicPTS.getView", l2 - l1);
        localObject1 = localProteusItemView;
      }
      catch (Exception localException)
      {
        QLog.e(a, 1, localException, new Object[] { "getView" });
        AIOUtils.a(a, "getView:", new IllegalArgumentException(paramAbsBaseArticleInfo.proteusItemsData, localException));
      }
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new ProteusItemView(paramVafContext.getContext());
        a((ProteusItemView)localObject2);
      }
      if (paramInt == 154)
      {
        paramVafContext = a;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getView gone : ");
        ((StringBuilder)localObject1).append(paramAbsBaseArticleInfo);
        QLog.e(paramVafContext, 1, ((StringBuilder)localObject1).toString());
        a((ProteusItemView)localObject2);
      }
      TraceUtils.traceEnd();
      return localObject2;
      label321:
      Object localObject3 = "";
    }
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
        QLog.e(a, 1, paramJSONObject, new Object[0]);
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
  
  public void a(VafContext paramVafContext)
  {
    this.f = paramVafContext.getTemplateFactory();
    this.d = new DynamicProteusItem(paramVafContext);
    int j = paramVafContext.getTemplateFactory().size();
    int i = b;
    int k = j + 155;
    if ((i < k) && (j > 0) && (i < e))
    {
      paramVafContext = paramVafContext.getTemplateFactory().getNameTemplateMap().keySet();
      i = b;
      paramVafContext = paramVafContext.iterator();
      while (paramVafContext.hasNext())
      {
        localObject = (String)paramVafContext.next();
        if (!c.containsKey(localObject))
        {
          c.put(localObject, Integer.valueOf(i));
          i += 1;
        }
      }
      b = k;
      if (e == 2147483647) {
        e = b + 30;
      }
      i = b;
      k = e;
      if (i > k) {
        b = k;
      }
      paramVafContext = a;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("init: templateCount : ");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(" TYPE_DYNAMIC_END : ");
      ((StringBuilder)localObject).append(b);
      ((StringBuilder)localObject).append(" max : ");
      ((StringBuilder)localObject).append(e);
      QLog.d(paramVafContext, 1, ((StringBuilder)localObject).toString());
    }
    if (e == 2147483647) {
      e = 255;
    }
  }
  
  public void a(ProteusItemView paramProteusItemView, int paramInt1, AbsBaseArticleInfo paramAbsBaseArticleInfo, VafContext paramVafContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    TraceUtils.traceBegin("DynamicPTS.bindData");
    long l1 = System.currentTimeMillis();
    Object localObject2 = paramProteusItemView.getTemplateBean();
    TemplateBean localTemplateBean = e(paramAbsBaseArticleInfo);
    if (paramProteusItemView.getContainer() == null)
    {
      TraceUtils.traceEnd();
      paramIFaceDecoder = a;
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
    if (paramInt1 == 154)
    {
      a(paramProteusItemView);
      TraceUtils.traceEnd();
      return;
    }
    b(paramProteusItemView);
    if (LogUtils.a())
    {
      localObject1 = a;
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
            ((Container)localObject1).setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130842690));
            paramProteusItemView.d();
            paramProteusItemView.a((Container)localObject1);
            ProteusSupportUtil.a((Container)localObject1, null, localTemplateBean);
          }
          paramAbsBaseArticleInfo.mProteusTemplateBean = localTemplateBean;
          TraceUtils.traceEnd();
          localObject1 = null;
        }
      }
    }
    localObject2 = paramProteusItemView.getContainer();
    paramProteusItemView.setModel(paramIReadInJoyModel, paramReadInJoyBaseAdapter.y().a());
    paramProteusItemView.setTemplateBean(localTemplateBean);
    if (localTemplateBean != null)
    {
      TraceUtils.traceBegin("DynamicPTS.bindData.compareWithOldTemplateBean");
      ProteusSupportUtil.a((Container)localObject2, (TemplateBean)localObject1, localTemplateBean);
      TraceUtils.traceEnd();
    }
    TraceUtils.traceBegin("DynamicPTS.bindData.bindView");
    this.d.a(paramInt1, (Container)localObject2, paramIReadInJoyModel, paramInt2);
    TraceUtils.traceEnd();
    ProteusSupportUtil.a(paramInt1, paramProteusItemView, paramVafContext, paramIFaceDecoder, paramReadInJoyBaseAdapter, paramIReadInJoyModel, paramAbsBaseArticleInfo);
    a(paramIReadInJoyModel, paramVafContext);
    ProteusSupportUtil.a((Container)localObject2, paramIReadInJoyModel, localTemplateBean);
    long l2 = System.currentTimeMillis();
    paramAbsBaseArticleInfo = a;
    if (localTemplateBean != null) {
      paramProteusItemView = localTemplateBean.getStyleName();
    } else {
      paramProteusItemView = "";
    }
    ReadInJoyPTSCostHelper.a(paramAbsBaseArticleInfo, paramProteusItemView, "DynamicPTS.bindData", l2 - l1);
    TraceUtils.traceEnd();
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt >= 154) && (paramInt < b);
  }
  
  public boolean b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool3 = a(paramAbsBaseArticleInfo);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (c(paramAbsBaseArticleInfo) == 154) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return 154;
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
        localObject = (Integer)c.get(str);
      }
    }
    if (localObject == null)
    {
      localObject = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getType: templateBean, data: ");
      localStringBuilder.append(paramAbsBaseArticleInfo.proteusItemsData);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
      return 154;
    }
    if ((((Integer)localObject).intValue() >= 154) && (((Integer)localObject).intValue() < b)) {
      return ((Integer)localObject).intValue();
    }
    AIOUtils.a(a, "", new IllegalArgumentException(HardCodeUtil.a(2131901682)));
    return 154;
  }
  
  public String d(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    paramAbsBaseArticleInfo = e(paramAbsBaseArticleInfo);
    if (paramAbsBaseArticleInfo != null) {
      return paramAbsBaseArticleInfo.getStyleName();
    }
    return "";
  }
  
  public TemplateBean e(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getTemplateBean : ");
      ((StringBuilder)localObject2).append(paramAbsBaseArticleInfo);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.f;
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
          if (!((TemplateFactory)this.f).a(paramAbsBaseArticleInfo.mProteusTemplateBean))
          {
            localObject1 = localTemplateBean;
            return paramAbsBaseArticleInfo.mProteusTemplateBean;
          }
        }
        localObject1 = localTemplateBean;
        if (this.d == null) {
          return null;
        }
        localObject1 = localTemplateBean;
        JSONObject localJSONObject = this.d.a(154, paramAbsBaseArticleInfo);
        localObject1 = localTemplateBean;
        localTemplateBean = this.d.a(154, localJSONObject);
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
        QLog.d(a, 1, paramAbsBaseArticleInfo, new Object[] { "getView" });
        localObject2 = localObject1;
      }
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.DynamicItemViewHelper
 * JD-Core Version:    0.7.0.1
 */