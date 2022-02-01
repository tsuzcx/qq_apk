package com.tencent.mobileqq.kandian.biz.common;

import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;

public class DividerConfigUtils
{
  private static final int a = Utils.rp2px(10.0D);
  
  private static int a(TemplateBean paramTemplateBean)
  {
    if (paramTemplateBean == null)
    {
      QLog.i("DividerConfigUtils", 1, "templateBean TYPE_UNKNOWN == null");
      return -1;
    }
    if (paramTemplateBean.findViewById("id_separator_normal_bottom") != null) {
      return 1;
    }
    if (paramTemplateBean.findViewById("id_separator_special_bottom_space") != null) {
      return 2;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getViewType TYPE_UNKNOWN");
    localStringBuilder.append(paramTemplateBean);
    QLog.i("DividerConfigUtils", 1, localStringBuilder.toString());
    return -1;
  }
  
  private static int a(ViewBase paramViewBase, boolean paramBoolean)
  {
    if (paramViewBase == null) {
      return 0;
    }
    Layout.Params localParams = paramViewBase.getComLayoutParams();
    int i = localParams.mLayoutHeight;
    if (paramBoolean) {
      localParams.mLayoutHeight = a;
    } else {
      localParams.mLayoutHeight = 0;
    }
    paramViewBase.setComLayoutParams(localParams);
    return localParams.mLayoutHeight - i;
  }
  
  public static boolean a(Container paramContainer, IReadInJoyModel paramIReadInJoyModel)
  {
    int i = 0;
    if (paramContainer != null)
    {
      if (paramIReadInJoyModel == null) {
        return false;
      }
      Object localObject = (ReadInJoyBaseAdapter)paramIReadInJoyModel.a();
      if (localObject == null) {
        return false;
      }
      int j = paramIReadInJoyModel.g();
      AbsBaseArticleInfo localAbsBaseArticleInfo = ((ReadInJoyBaseAdapter)localObject).a(j);
      paramIReadInJoyModel = ((ReadInJoyBaseAdapter)localObject).a(j + 1);
      if (localAbsBaseArticleInfo != null)
      {
        if (paramIReadInJoyModel == null) {
          return false;
        }
        j = a(localAbsBaseArticleInfo.mProteusTemplateBean);
        if (j == -1) {
          return false;
        }
        int k = a(paramIReadInJoyModel.mProteusTemplateBean);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("topType:");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(" nextType:");
        ((StringBuilder)localObject).append(k);
        QLog.i("DividerConfigUtils", 1, ((StringBuilder)localObject).toString());
        if (k < 0)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("nextArticleInfo:");
          ((StringBuilder)localObject).append(paramIReadInJoyModel.mProteusTemplateBean);
          QLog.i("DividerConfigUtils", 1, ((StringBuilder)localObject).toString());
        }
        paramIReadInJoyModel = paramContainer.getVirtualView();
        if (j != 1)
        {
          if (j == 2)
          {
            localObject = paramIReadInJoyModel.findViewBaseByName("id_separator_special_bottom_space");
            if (k != 2) {
              i = a((ViewBase)localObject, false);
            } else {
              i = a((ViewBase)localObject, true);
            }
          }
        }
        else
        {
          localObject = paramIReadInJoyModel.findViewBaseByName("id_separator_normal_bottom");
          if (k != 2) {
            i = b((ViewBase)localObject, true);
          } else {
            i = b((ViewBase)localObject, false);
          }
        }
        localObject = paramIReadInJoyModel.getComLayoutParams();
        if (((Layout.Params)localObject).mLayoutHeight >= 0) {
          ((Layout.Params)localObject).mLayoutHeight += i;
        }
        paramIReadInJoyModel = paramIReadInJoyModel.getComLayoutParams();
        paramContainer.setLayoutParams(new RelativeLayout.LayoutParams(paramIReadInJoyModel.mLayoutWidth, paramIReadInJoyModel.mLayoutHeight));
        return true;
      }
    }
    return false;
  }
  
  private static int b(ViewBase paramViewBase, boolean paramBoolean)
  {
    if (paramViewBase == null) {
      return 0;
    }
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 4;
    }
    paramViewBase.setVisibility(i);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.DividerConfigUtils
 * JD-Core Version:    0.7.0.1
 */