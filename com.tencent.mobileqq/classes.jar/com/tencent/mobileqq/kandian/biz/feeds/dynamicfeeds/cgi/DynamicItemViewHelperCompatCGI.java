package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.cgi;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.DynamicItemViewHelperCompatBase;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.ProteusSupportUtilBase;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.ReadInJoyDynamicChannelBaseFragment;
import com.tencent.mobileqq.kandian.biz.pts.data.DynamicChannelDataModel;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.biz.pts.item.ProteusItemView;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class DynamicItemViewHelperCompatCGI
  extends DynamicItemViewHelperCompatBase<DynamicChannelDataModel>
{
  public void a(VafContext paramVafContext, int paramInt)
  {
    super.a(paramVafContext, paramInt);
  }
  
  public void a(ProteusItemView paramProteusItemView, int paramInt1, DynamicChannelDataModel paramDynamicChannelDataModel, VafContext paramVafContext, int paramInt2)
  {
    TraceUtils.traceBegin("bindData");
    if ((paramProteusItemView != null) && (paramProteusItemView.getContainer() != null))
    {
      if (paramInt1 == c)
      {
        paramProteusItemView.setVisibility(8);
        return;
      }
      QLog.d("DynamicItemViewHelperCompatCGI", 1, new Object[] { "bindData, adapterViewType = ", Integer.valueOf(paramInt1), ", data = ", paramDynamicChannelDataModel });
      Object localObject = paramProteusItemView.getTemplateBean();
      TemplateBean localTemplateBean = c(paramDynamicChannelDataModel);
      paramDynamicChannelDataModel = (DynamicChannelDataModel)localObject;
      if (localObject != null)
      {
        paramDynamicChannelDataModel = (DynamicChannelDataModel)localObject;
        if (localTemplateBean != null)
        {
          paramDynamicChannelDataModel = (DynamicChannelDataModel)localObject;
          if (!localTemplateBean.equals(localObject))
          {
            paramDynamicChannelDataModel = paramVafContext.getViewFactory().inflate(paramVafContext, localTemplateBean);
            if (paramDynamicChannelDataModel != null)
            {
              paramDynamicChannelDataModel.setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130842690));
              paramProteusItemView.d();
              paramProteusItemView.a(paramDynamicChannelDataModel);
            }
            paramDynamicChannelDataModel = null;
          }
        }
      }
      localObject = paramProteusItemView.getContainer();
      paramProteusItemView.setTemplateBean(localTemplateBean);
      if (localTemplateBean != null) {
        ProteusSupportUtil.a((Container)localObject, paramDynamicChannelDataModel, localTemplateBean);
      }
      ProteusSupportUtil.a((Container)localObject, paramVafContext, localTemplateBean);
      TraceUtils.traceEnd();
      return;
    }
    TraceUtils.traceEnd();
    if (QLog.isColorLevel()) {
      QLog.d("DynamicItemViewHelperCompatCGI", 2, new Object[] { "bindData, adapterViewType = ", Integer.valueOf(paramInt1) });
    }
    if (paramProteusItemView != null) {
      paramProteusItemView.setVisibility(8);
    }
  }
  
  public boolean a(DynamicChannelDataModel paramDynamicChannelDataModel)
  {
    return (paramDynamicChannelDataModel != null) && (!TextUtils.isEmpty(paramDynamicChannelDataModel.styleID));
  }
  
  public int b(DynamicChannelDataModel paramDynamicChannelDataModel)
  {
    if (paramDynamicChannelDataModel == null) {
      return c;
    }
    paramDynamicChannelDataModel = (Integer)this.a.get(paramDynamicChannelDataModel.styleID);
    if (paramDynamicChannelDataModel == null)
    {
      QLog.d("DynamicItemViewHelperCompatCGI", 2, "getType, type is null");
      return c;
    }
    if ((paramDynamicChannelDataModel.intValue() >= c) && (paramDynamicChannelDataModel.intValue() < this.e)) {
      return paramDynamicChannelDataModel.intValue();
    }
    QLog.d("DynamicItemViewHelperCompatCGI", 2, "getType, type is out of range");
    return c;
  }
  
  protected TemplateBean c(DynamicChannelDataModel paramDynamicChannelDataModel)
  {
    TemplateBean localTemplateBean = null;
    if (paramDynamicChannelDataModel == null)
    {
      QLog.d("DynamicItemViewHelperCompatCGI", 1, "getTemplateBean, data is null.");
      return null;
    }
    QLog.d("DynamicItemViewHelperCompatCGI", 2, new Object[] { "styleID = ", paramDynamicChannelDataModel.styleID, ", channelID = ", Integer.valueOf(paramDynamicChannelDataModel.channelID) });
    if ((paramDynamicChannelDataModel.mTemplateBean != null) && (!((TemplateFactory)this.f.getTemplateFactory()).a(paramDynamicChannelDataModel.mTemplateBean))) {
      return paramDynamicChannelDataModel.mTemplateBean;
    }
    if (!TextUtils.isEmpty(paramDynamicChannelDataModel.proteusData))
    {
      JSONObject localJSONObject = ProteusSupportUtilBase.a(paramDynamicChannelDataModel.proteusData);
      localTemplateBean = ProteusSupportUtilBase.a(this.f, localJSONObject, ReadInJoyDynamicChannelBaseFragment.d(paramDynamicChannelDataModel.channelID));
      paramDynamicChannelDataModel.mTemplateBean = localTemplateBean;
      if ((localTemplateBean != null) && (localTemplateBean.getViewBean() != null) && (localJSONObject != null) && (localJSONObject.has("report_feeds_type"))) {
        try
        {
          localTemplateBean.getViewBean().putDynamicValue("report_feeds_type", localJSONObject.getString("report_feeds_type"));
        }
        catch (JSONException paramDynamicChannelDataModel)
        {
          QLog.d("DynamicItemViewHelperCompatCGI", 1, new Object[] { "getTemplateBean exception, ", paramDynamicChannelDataModel.toString() });
        }
      }
    }
    return localTemplateBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.cgi.DynamicItemViewHelperCompatCGI
 * JD-Core Version:    0.7.0.1
 */