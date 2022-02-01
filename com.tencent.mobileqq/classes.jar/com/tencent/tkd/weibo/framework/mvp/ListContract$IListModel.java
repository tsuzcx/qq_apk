package com.tencent.tkd.weibo.framework.mvp;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function6;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/framework/mvp/ListContract$IListModel;", "BEAN", "", "total", "", "getTotal", "()I", "hasNextPage", "", "loadFirstPage", "", "needCache", "callback", "Lkotlin/Function6;", "Lkotlin/ParameterName;", "name", "isSuccess", "", "list", "isCacheData", "errorCode", "", "errorMsg", "Lcom/tencent/tkd/weibo/framework/mvp/FirstPageCallback;", "loadNextPage", "Lkotlin/Function4;", "allList", "Lcom/tencent/tkd/weibo/framework/mvp/NextPageCallback;", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public abstract interface ListContract$IListModel<BEAN>
{
  public abstract void a(@NotNull Function4<? super Boolean, ? super List<? extends BEAN>, ? super Integer, ? super String, Unit> paramFunction4);
  
  public abstract void a(boolean paramBoolean, @NotNull Function6<? super Boolean, ? super List<? extends BEAN>, ? super Integer, ? super Boolean, ? super Integer, ? super String, Unit> paramFunction6);
  
  public abstract boolean a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.framework.mvp.ListContract.IListModel
 * JD-Core Version:    0.7.0.1
 */