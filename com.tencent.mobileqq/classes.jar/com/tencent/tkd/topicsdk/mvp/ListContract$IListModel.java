package com.tencent.tkd.topicsdk.mvp;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function6;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/mvp/ListContract$IListModel;", "BEAN", "", "total", "", "getTotal", "()I", "hasNextPage", "", "loadFirstPage", "", "needCache", "callback", "Lkotlin/Function6;", "Lkotlin/ParameterName;", "name", "isSuccess", "", "list", "isCacheData", "errorCode", "", "errorMsg", "Lcom/tencent/tkd/topicsdk/mvp/FirstPageCallback;", "loadNextPage", "Lkotlin/Function4;", "allList", "Lcom/tencent/tkd/topicsdk/mvp/NextPageCallback;", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public abstract interface ListContract$IListModel<BEAN>
{
  public abstract void a(@NotNull Function4<? super Boolean, ? super List<? extends BEAN>, ? super Integer, ? super String, Unit> paramFunction4);
  
  public abstract void a(boolean paramBoolean, @NotNull Function6<? super Boolean, ? super List<? extends BEAN>, ? super Integer, ? super Boolean, ? super Integer, ? super String, Unit> paramFunction6);
  
  public abstract boolean a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mvp.ListContract.IListModel
 * JD-Core Version:    0.7.0.1
 */