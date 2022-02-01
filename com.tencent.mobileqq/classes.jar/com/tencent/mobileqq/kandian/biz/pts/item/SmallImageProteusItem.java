package com.tencent.mobileqq.kandian.biz.pts.item;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.data.ReadInJoySmallImgCell;
import com.tencent.mobileqq.kandian.biz.pts.util.AccountShowUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import org.json.JSONObject;

public class SmallImageProteusItem
  implements ProteusItem
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoySmallImgCell.a(paramAbsBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramIReadInJoyModel.a();
    if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.isAccountShown)) {
      AccountShowUtils.a(paramContainer, paramIReadInJoyModel);
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    if ((paramViewBase != null) && (!TextUtils.isEmpty(paramViewBase.getClickEvnet())) && (paramViewBase.getClickEvnet().startsWith("search_word_click_")))
    {
      paramViewBase.setOnClickListener(new SmallImageProteusItem.1(this, paramIReadInJoyModel, paramContainer));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.SmallImageProteusItem
 * JD-Core Version:    0.7.0.1
 */