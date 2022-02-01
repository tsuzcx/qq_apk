package com.tencent.mobileqq.kandian.repo.ugc.srtutils;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

public abstract interface ReadInJoySrtHandler$IRuleManager
{
  public abstract String a(AbsBaseArticleInfo paramAbsBaseArticleInfo, TemplateBean paramTemplateBean, ViewBase paramViewBase);
  
  public abstract void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a(Object paramObject);
  
  public abstract boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.ugc.srtutils.ReadInJoySrtHandler.IRuleManager
 * JD-Core Version:    0.7.0.1
 */