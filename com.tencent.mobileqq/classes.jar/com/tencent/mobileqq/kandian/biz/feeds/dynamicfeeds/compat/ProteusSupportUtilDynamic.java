package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.compat;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.data.ProteusItemDataBuilder;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.biz.pts.item.GridProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.item.ProteusItemView;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ProteusSupportUtilDynamic
{
  private static final Map<Integer, ProteusItem> a = new HashMap();
  
  static
  {
    if (a.isEmpty())
    {
      a(0, new GridProteusItem());
      a(1, new GridProteusItem());
      a(2, new GridProteusItem());
    }
  }
  
  private static TemplateBean a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getTemplateBean : ");
      ((StringBuilder)localObject1).append(paramAbsBaseArticleInfo);
      ((StringBuilder)localObject1).append(" adapterViewType : ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("ProteusSupportUtilDynamic", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    try
    {
      ProteusItem localProteusItem = (ProteusItem)a.get(Integer.valueOf(paramInt));
      if (localProteusItem == null)
      {
        QLog.d("ProteusSupportUtilDynamic", 1, "getTemplateBean, proteusItem is null.");
        return null;
      }
      JSONObject localJSONObject = localProteusItem.a(paramInt, paramAbsBaseArticleInfo);
      paramAbsBaseArticleInfo = localProteusItem.a(paramInt, localJSONObject);
      localObject1 = paramAbsBaseArticleInfo;
      if (paramAbsBaseArticleInfo == null) {
        try
        {
          localObject1 = TemplateFactory.a(paramString, true);
          paramString = localObject2;
          if (localObject1 != null) {
            paramString = ((TemplateFactory)localObject1).getTemplateBean(localJSONObject);
          }
          localObject1 = paramString;
        }
        catch (Exception paramString)
        {
          break label156;
        }
        catch (JSONException paramString)
        {
          break label171;
        }
      }
      return localObject1;
    }
    catch (Exception paramString)
    {
      paramAbsBaseArticleInfo = (AbsBaseArticleInfo)localObject1;
      QLog.e("ProteusSupportUtilDynamic", 2, "getTemplateBean: ", paramString);
      return paramAbsBaseArticleInfo;
    }
    catch (JSONException paramString)
    {
      label156:
      paramAbsBaseArticleInfo = localObject3;
      label171:
      QLog.e("ProteusSupportUtilDynamic", 2, "getTemplateBean: fail to cast article info to jsonObject", paramString);
    }
    return paramAbsBaseArticleInfo;
  }
  
  private static TemplateBean a(VafContext paramVafContext, String paramString1, String paramString2)
  {
    QLog.d("ProteusSupportUtilDynamic", 2, new Object[] { "getTemplateBean, styleID = ", paramString1 });
    ProteusItemDataBuilder localProteusItemDataBuilder = new ProteusItemDataBuilder();
    TemplateFactory localTemplateFactory = (TemplateFactory)paramVafContext.getTemplateFactory();
    paramVafContext = localTemplateFactory;
    if (localTemplateFactory == null) {
      paramVafContext = TemplateFactory.a(paramString2, true);
    }
    if (paramVafContext != null) {
      try
      {
        paramVafContext = paramVafContext.getTemplateBean(localProteusItemDataBuilder.a(paramString1).a());
        return paramVafContext;
      }
      catch (JSONException paramVafContext)
      {
        QLog.e("ProteusSupportUtilDynamic", 1, new Object[] { "getTemplateBean failed, styleID = ", paramString1, ", e = ", paramVafContext });
      }
    }
    return null;
  }
  
  public static ProteusItemView a(VafContext paramVafContext, int paramInt, String paramString)
  {
    TraceUtils.traceBegin("ProteusSupportUtilDynamic.getView");
    paramString = a(paramVafContext, b(paramInt), paramString);
    paramString = paramVafContext.getViewFactory().inflate(paramVafContext, paramString);
    if (paramString != null)
    {
      paramString.setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130842690));
      paramVafContext = new ProteusItemView(paramVafContext.getContext());
      paramVafContext.a(paramString);
    }
    else
    {
      paramVafContext = null;
    }
    TraceUtils.traceEnd();
    return paramVafContext;
  }
  
  private static void a(int paramInt, ProteusItem paramProteusItem)
  {
    if (paramProteusItem != null)
    {
      a.put(Integer.valueOf(paramInt), paramProteusItem);
      return;
    }
    throw new NullPointerException();
  }
  
  public static void a(ProteusItemView paramProteusItemView, int paramInt1, AbsBaseArticleInfo paramAbsBaseArticleInfo, VafContext paramVafContext, int paramInt2, String paramString)
  {
    TraceUtils.traceBegin("ProteusSupportUtilDynamic.bindData");
    if ((paramProteusItemView != null) && (paramProteusItemView.getContainer() != null))
    {
      TemplateBean localTemplateBean = paramProteusItemView.getTemplateBean();
      paramString = a(paramInt1, paramAbsBaseArticleInfo, paramString);
      if ((localTemplateBean != null) && (paramString != null) && (!paramString.equals(localTemplateBean)))
      {
        Container localContainer = paramVafContext.getViewFactory().inflate(paramVafContext, paramString);
        if (localContainer != null)
        {
          localContainer.setBackgroundDrawable(paramVafContext.getContext().getResources().getDrawable(2130842690));
          paramProteusItemView.d();
          paramProteusItemView.a(localContainer);
        }
        paramAbsBaseArticleInfo.mProteusTemplateBean = paramString;
      }
      paramProteusItemView = paramProteusItemView.getContainer();
      paramProteusItemView.setTag(2131444313, paramString);
      TraceUtils.traceBegin("ProteusSupportUtilDynamic.bindDataImpl");
      if (paramString != null) {
        ProteusSupportUtil.a(paramProteusItemView, localTemplateBean, paramString);
      }
      TraceUtils.traceEnd();
      ProteusSupportUtil.a(paramProteusItemView, paramVafContext, paramString);
      TraceUtils.traceEnd();
      return;
    }
    TraceUtils.traceEnd();
    if (QLog.isColorLevel())
    {
      paramProteusItemView = new StringBuilder();
      paramProteusItemView.append("bindData : ");
      paramProteusItemView.append(paramAbsBaseArticleInfo);
      paramProteusItemView.append(" adapterViewType : ");
      paramProteusItemView.append(paramInt1);
      QLog.d("ProteusSupportUtilDynamic", 2, paramProteusItemView.toString());
    }
  }
  
  public static boolean a(int paramInt)
  {
    return a.containsKey(Integer.valueOf(paramInt));
  }
  
  private static String b(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1))
    {
      if (paramInt != 2) {
        return "ReadInjoy_small_cell";
      }
      return "ReadInjoy_large_cell";
    }
    return "ReadInjoy_small_cell";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.compat.ProteusSupportUtilDynamic
 * JD-Core Version:    0.7.0.1
 */