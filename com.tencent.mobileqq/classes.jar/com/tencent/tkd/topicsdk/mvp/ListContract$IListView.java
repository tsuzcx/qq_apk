package com.tencent.tkd.topicsdk.mvp;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/mvp/ListContract$IListView;", "BEAN", "", "getDividerHeight", "", "getEmptyText", "", "setCenterEmpty", "", "setCenterError", "errorCode", "errorMsg", "setCenterHide", "setCenterLoading", "setFooterError", "setFooterHasMore", "setFooterHide", "setFooterLoading", "setFooterNoMore", "setHeaderError", "setHeaderLoading", "setHeaderSuccess", "setListData", "allList", "", "isAppend", "", "setTotal", "total", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public abstract interface ListContract$IListView<BEAN>
{
  @NotNull
  public abstract String getEmptyText();
  
  public abstract void setCenterEmpty();
  
  public abstract void setCenterError(int paramInt, @Nullable String paramString);
  
  public abstract void setCenterHide();
  
  public abstract void setCenterLoading();
  
  public abstract void setFooterError(int paramInt, @Nullable String paramString);
  
  public abstract void setFooterHasMore();
  
  public abstract void setFooterHide();
  
  public abstract void setFooterLoading();
  
  public abstract void setFooterNoMore();
  
  public abstract void setHeaderError(int paramInt, @Nullable String paramString);
  
  public abstract void setHeaderLoading();
  
  public abstract void setHeaderSuccess();
  
  public abstract void setListData(@NotNull List<? extends BEAN> paramList, boolean paramBoolean);
  
  public abstract void setTotal(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mvp.ListContract.IListView
 * JD-Core Version:    0.7.0.1
 */