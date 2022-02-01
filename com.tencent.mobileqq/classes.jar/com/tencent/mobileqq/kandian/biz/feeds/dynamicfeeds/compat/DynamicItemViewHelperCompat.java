package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.compat;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.DynamicItemViewHelperCompatBase;
import com.tencent.mobileqq.kandian.biz.pts.item.DynamicProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.ProteusItemView;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class DynamicItemViewHelperCompat
  extends DynamicItemViewHelperCompatBase<AbsBaseArticleInfo>
{
  private DynamicProteusItem g;
  
  public void a(VafContext paramVafContext, int paramInt)
  {
    super.a(paramVafContext, paramInt);
    this.g = new DynamicProteusItem(paramVafContext);
  }
  
  public void a(ProteusItemView paramProteusItemView, int paramInt1, AbsBaseArticleInfo paramAbsBaseArticleInfo, VafContext paramVafContext, int paramInt2)
  {
    TraceUtils.traceBegin("bindData");
    if ((paramProteusItemView != null) && (paramProteusItemView.getContainer() != null))
    {
      if (paramInt1 == c)
      {
        paramProteusItemView.setVisibility(8);
        return;
      }
      QLog.d("DynamicItemViewHelperCompat", 1, new Object[] { "bindData, adapterViewType = ", Integer.valueOf(paramInt1), ", articleInfo = ", paramAbsBaseArticleInfo });
      TemplateBean localTemplateBean1 = paramProteusItemView.getTemplateBean();
      TemplateBean localTemplateBean2 = c(paramAbsBaseArticleInfo);
      Object localObject = localTemplateBean1;
      if (localTemplateBean1 != null)
      {
        localObject = localTemplateBean1;
        if (localTemplateBean2 != null)
        {
          localObject = localTemplateBean1;
          if (!localTemplateBean2.equals(localTemplateBean1))
          {
            localObject = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean2);
            if (localObject != null)
            {
              ((Container)localObject).setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130842690));
              paramProteusItemView.d();
              paramProteusItemView.a((Container)localObject);
            }
            paramAbsBaseArticleInfo.mProteusTemplateBean = localTemplateBean2;
            localObject = null;
          }
        }
      }
      paramAbsBaseArticleInfo = paramProteusItemView.getContainer();
      paramProteusItemView.setTemplateBean(localTemplateBean2);
      if (localTemplateBean2 != null) {
        ProteusSupportUtil.a(paramAbsBaseArticleInfo, (TemplateBean)localObject, localTemplateBean2);
      }
      ProteusSupportUtil.a(paramAbsBaseArticleInfo, paramVafContext, localTemplateBean2);
      TraceUtils.traceEnd();
      return;
    }
    TraceUtils.traceEnd();
    if (QLog.isColorLevel()) {
      QLog.d("DynamicItemViewHelperCompat", 2, new Object[] { "bindData, adapterViewType = ", Integer.valueOf(paramInt1), ", articleInfo = ", paramAbsBaseArticleInfo });
    }
    if (paramProteusItemView != null) {
      paramProteusItemView.setVisibility(8);
    }
  }
  
  public boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
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
  
  public int b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return c;
    }
    TemplateBean localTemplateBean = c(paramAbsBaseArticleInfo);
    Object localObject = null;
    if (localTemplateBean != null) {
      localObject = (Integer)this.a.get(localTemplateBean.getStyleName());
    }
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getType: templateBean : ");
      ((StringBuilder)localObject).append(localTemplateBean);
      ((StringBuilder)localObject).append(" data: ");
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.proteusItemsData);
      QLog.d("DynamicItemViewHelperCompat", 2, ((StringBuilder)localObject).toString());
      return c;
    }
    if ((((Integer)localObject).intValue() >= c) && (((Integer)localObject).intValue() < this.e)) {
      return ((Integer)localObject).intValue();
    }
    AIOUtils.a("DynamicItemViewHelperCompat", "", new IllegalArgumentException(HardCodeUtil.a(2131901680)));
    return c;
  }
  
  protected TemplateBean c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    int i = c;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTemplateBean : ");
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo);
      QLog.d("DynamicItemViewHelperCompat", 2, ((StringBuilder)localObject).toString());
    }
    TemplateBean localTemplateBean = null;
    Object localObject = localTemplateBean;
    try
    {
      if (this.g == null) {
        return null;
      }
      localObject = localTemplateBean;
      JSONObject localJSONObject = this.g.a(i, paramAbsBaseArticleInfo);
      localObject = localTemplateBean;
      localTemplateBean = this.g.a(i, localJSONObject);
      localObject = localTemplateBean;
      paramAbsBaseArticleInfo.mProteusTemplateBean = localTemplateBean;
      paramAbsBaseArticleInfo = localTemplateBean;
      if (localTemplateBean != null)
      {
        localObject = localTemplateBean;
        paramAbsBaseArticleInfo = localTemplateBean;
        if (localTemplateBean.getViewBean() != null)
        {
          paramAbsBaseArticleInfo = localTemplateBean;
          if (localJSONObject != null)
          {
            localObject = localTemplateBean;
            paramAbsBaseArticleInfo = localTemplateBean;
            if (localJSONObject.has("report_feeds_type"))
            {
              localObject = localTemplateBean;
              localTemplateBean.getViewBean().putDynamicValue("report_feeds_type", localJSONObject.getString("report_feeds_type"));
              return localTemplateBean;
            }
          }
        }
      }
    }
    catch (JSONException paramAbsBaseArticleInfo)
    {
      QLog.d("DynamicItemViewHelperCompat", 1, paramAbsBaseArticleInfo, new Object[] { "getView" });
      paramAbsBaseArticleInfo = (AbsBaseArticleInfo)localObject;
    }
    return paramAbsBaseArticleInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.compat.DynamicItemViewHelperCompat
 * JD-Core Version:    0.7.0.1
 */