package com.tencent.tkd.topicsdk.mvp;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/mvp/ListContract$IListPresenter;", "BEAN", "VIEW", "Lcom/tencent/tkd/topicsdk/mvp/ListContract$IListView;", "Lcom/tencent/tkd/topicsdk/mvp/BasePresenter;", "total", "", "getTotal", "()I", "loadFirstPage", "", "needCache", "", "(Ljava/lang/Boolean;)V", "loadNextPage", "refreshPage", "topicsdk-framework_release"}, k=1, mv={1, 1, 16})
public abstract interface ListContract$IListPresenter<BEAN, VIEW extends ListContract.IListView<BEAN>>
  extends BasePresenter<VIEW>
{
  public abstract void a(@Nullable Boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mvp.ListContract.IListPresenter
 * JD-Core Version:    0.7.0.1
 */