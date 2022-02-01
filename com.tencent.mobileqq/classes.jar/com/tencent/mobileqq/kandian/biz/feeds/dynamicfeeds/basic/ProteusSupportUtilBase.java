package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.mobileqq.kandian.biz.pts.data.ProteusItemDataBuilder;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.biz.pts.item.ProteusItemView;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class ProteusSupportUtilBase
{
  public static TemplateBean a(VafContext paramVafContext, JSONObject paramJSONObject, String paramString)
  {
    QLog.d("ProteusSupportUtilBase", 2, new Object[] { "getTemplateBean, data = ", paramJSONObject, ", serviceID = ", paramString });
    TemplateFactory localTemplateFactory = (TemplateFactory)paramVafContext.getTemplateFactory();
    paramVafContext = localTemplateFactory;
    if (localTemplateFactory == null) {
      paramVafContext = TemplateFactory.a(paramString, true);
    }
    if (paramVafContext != null) {
      try
      {
        paramVafContext = paramVafContext.getTemplateBean(paramJSONObject);
        return paramVafContext;
      }
      catch (JSONException paramVafContext)
      {
        QLog.e("ProteusSupportUtilBase", 1, new Object[] { "getTemplateBean failed, data = ", paramJSONObject, ", serviceID = ", paramString, ", e = ", paramVafContext });
      }
    }
    return null;
  }
  
  public static ProteusItemView a(VafContext paramVafContext, String paramString1, String paramString2)
  {
    paramString1 = b(paramVafContext, paramString2, paramString1);
    paramString1 = paramVafContext.getViewFactory().inflate(paramVafContext, paramString1);
    if (paramString1 != null)
    {
      paramString1.setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130842690));
      paramVafContext = new ProteusItemView(paramVafContext.getContext());
      paramVafContext.a(paramString1);
      return paramVafContext;
    }
    return null;
  }
  
  public static ProteusItemView a(VafContext paramVafContext, String paramString, JSONObject paramJSONObject)
  {
    paramString = a(paramVafContext, paramJSONObject, paramString);
    paramString = paramVafContext.getViewFactory().inflate(paramVafContext, paramString);
    if (paramString != null)
    {
      paramString.setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130842690));
      paramVafContext = new ProteusItemView(paramVafContext.getContext());
      paramVafContext.a(paramString);
      return paramVafContext;
    }
    return null;
  }
  
  public static JSONObject a(String paramString)
  {
    localJSONObject = new JSONObject();
    if (TextUtils.isEmpty(paramString)) {
      return localJSONObject;
    }
    QLog.d("ProteusSupportUtilBase", 2, new Object[] { "getProteusDynamicData data = ", paramString });
    try
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = paramString.opt(str);
        if (localObject != null) {
          localJSONObject.put(str, localObject);
        }
      }
      return localJSONObject;
    }
    catch (JSONException paramString)
    {
      QLog.d("ProteusSupportUtilBase", 2, "getProteusDynamicData e = ", paramString);
    }
  }
  
  public static void a(ProteusItemView paramProteusItemView, VafContext paramVafContext, String paramString1, String paramString2)
  {
    if ((paramProteusItemView != null) && (paramProteusItemView.getContainer() != null))
    {
      TemplateBean localTemplateBean = paramProteusItemView.getTemplateBean();
      paramString1 = a(paramVafContext, a(paramString2), paramString1);
      if ((localTemplateBean != null) && (paramString1 != null) && (!paramString1.equals(localTemplateBean)))
      {
        paramString2 = paramVafContext.getViewFactory().inflate(paramVafContext, paramString1);
        if (paramString2 != null)
        {
          paramString2.setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130842690));
          paramProteusItemView.d();
          paramProteusItemView.a(paramString2);
        }
      }
      paramProteusItemView = paramProteusItemView.getContainer();
      paramProteusItemView.setTag(2131444313, paramString1);
      if (paramString1 != null) {
        ProteusSupportUtil.a(paramProteusItemView, localTemplateBean, paramString1);
      }
      ProteusSupportUtil.a(paramProteusItemView, paramVafContext, paramString1);
      return;
    }
    QLog.d("ProteusSupportUtilBase", 1, new Object[] { "bindData proteusItemVIew is null, data = ", paramString2 });
  }
  
  public static TemplateBean b(VafContext paramVafContext, String paramString1, String paramString2)
  {
    QLog.d("ProteusSupportUtilBase", 2, new Object[] { "getTemplateBean, styleID = ", paramString1, ", serviceID = ", paramString2 });
    TemplateFactory localTemplateFactory = (TemplateFactory)paramVafContext.getTemplateFactory();
    paramVafContext = localTemplateFactory;
    if (localTemplateFactory == null) {
      paramVafContext = TemplateFactory.a(paramString2, true);
    }
    if (paramVafContext != null) {
      try
      {
        paramVafContext = paramVafContext.getTemplateBean(new ProteusItemDataBuilder().a(paramString1).a());
        return paramVafContext;
      }
      catch (JSONException paramVafContext)
      {
        QLog.e("ProteusSupportUtilBase", 1, new Object[] { "getTemplateBean failed, styleID = ", paramString1, ", serviceID = ", paramString2, ", e = ", paramVafContext });
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.ProteusSupportUtilBase
 * JD-Core Version:    0.7.0.1
 */