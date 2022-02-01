package com.tencent.mobileqq.kandian.biz.pts.item;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.data.ReadInjoyTripleImgCell;
import com.tencent.mobileqq.kandian.biz.pts.util.AccountShowUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import org.json.JSONObject;

public class TripleProteusItem
  implements ProteusItem
{
  public static String a = "search_word_title";
  public static String[] b = { "search_word_click_1", "search_word_click_2", "search_word_click_3", "search_word_click_4" };
  public static String[] c = { "search_word_show_1", "search_word_show_2", "search_word_show_3", "search_word_show_4" };
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInjoyTripleImgCell.a(paramAbsBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramIReadInJoyModel.k();
    if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.isAccountShown)) {
      AccountShowUtils.a(paramContainer, paramIReadInJoyModel);
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    if ((paramViewBase != null) && (!TextUtils.isEmpty(paramViewBase.getClickEvnet())) && (paramViewBase.getClickEvnet().startsWith("search_word_click_")))
    {
      paramViewBase.setOnClickListener(new TripleProteusItem.1(this, paramIReadInJoyModel, paramContainer));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.TripleProteusItem
 * JD-Core Version:    0.7.0.1
 */