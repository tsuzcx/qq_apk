package com.tencent.mobileqq.kandian.biz.pts.item;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.data.ReadInJoyWechatSimpleVideoCell;
import com.tencent.mobileqq.kandian.biz.pts.util.AccountShowUtils;
import com.tencent.mobileqq.kandian.biz.pts.view.helper.BindViewHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import org.json.JSONObject;

public class WechatSimpleVideoProteusItem
  implements ProteusItem
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyWechatSimpleVideoCell.a(paramAbsBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    if (paramIReadInJoyModel != null)
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = paramIReadInJoyModel.a();
      if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.isAccountShown)) {
        AccountShowUtils.a(paramContainer, paramIReadInJoyModel);
      }
      if (paramContainer != null)
      {
        paramContainer = paramContainer.getVirtualView();
        if (paramContainer != null) {
          BindViewHelper.a(paramContainer, paramIReadInJoyModel.a());
        }
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.WechatSimpleVideoProteusItem
 * JD-Core Version:    0.7.0.1
 */