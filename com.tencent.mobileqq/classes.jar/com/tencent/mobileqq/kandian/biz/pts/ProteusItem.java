package com.tencent.mobileqq.kandian.biz.pts;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import org.json.JSONObject;

public abstract interface ProteusItem
{
  public abstract TemplateBean a(int paramInt, JSONObject paramJSONObject);
  
  public abstract JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2);
  
  public abstract boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.ProteusItem
 * JD-Core Version:    0.7.0.1
 */