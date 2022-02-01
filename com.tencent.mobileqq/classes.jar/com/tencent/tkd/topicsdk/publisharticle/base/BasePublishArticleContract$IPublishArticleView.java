package com.tencent.tkd.topicsdk.publisharticle.base;

import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/base/BasePublishArticleContract$IPublishArticleView;", "", "isContentModified", "", "()Z", "shouldShowSaveDraft", "getShouldShowSaveDraft", "changeBottomLayoutEnabled", "", "enablePic", "enableVideo", "getCurrentDisplayItems", "Ljava/util/ArrayList;", "Lcom/tencent/tkd/topicsdk/bean/DisplayItem;", "Lkotlin/collections/ArrayList;", "handlePublishErrCode", "errCode", "", "articleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "hasInternet", "onCoverDataUpdated", "data", "Lcom/tencent/tkd/topicsdk/coverselect/CoverSelectData;", "openCoverSelectPageForResult", "item", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "topicsdk_release"}, k=1, mv={1, 1, 16})
public abstract interface BasePublishArticleContract$IPublishArticleView
{
  public abstract void a(int paramInt, @NotNull PublishArticleInfo paramPublishArticleInfo);
  
  public abstract void a(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract boolean d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.base.BasePublishArticleContract.IPublishArticleView
 * JD-Core Version:    0.7.0.1
 */