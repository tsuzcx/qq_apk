package com.tencent.mobileqq.kandian.glue.businesshandler.api;

import android.util.SparseArray;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.glue.businesshandler.HandlerTask;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/businesshandler/api/IHandlerFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "buildBusinessHandlers", "Landroid/util/SparseArray;", "Lcom/tencent/mobileqq/kandian/glue/businesshandler/api/IBaseHandler;", "listViewGroup", "Landroid/view/ViewGroup;", "createHandler", "handlerID", "", "invokeHandlerMethod", "", "handlerMap", "handlerJob", "Lcom/tencent/mobileqq/kandian/glue/businesshandler/HandlerTask;", "invokeHandlerMethodWithReturn", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IHandlerFactory
  extends QRouteApi
{
  @Nullable
  public abstract SparseArray<IBaseHandler> buildBusinessHandlers(@NotNull ViewGroup paramViewGroup);
  
  @Nullable
  public abstract IBaseHandler createHandler(int paramInt);
  
  public abstract void invokeHandlerMethod(@NotNull SparseArray<IBaseHandler> paramSparseArray, @Nullable HandlerTask paramHandlerTask);
  
  @Nullable
  public abstract Object invokeHandlerMethodWithReturn(@NotNull SparseArray<IBaseHandler> paramSparseArray, @Nullable HandlerTask paramHandlerTask);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.api.IHandlerFactory
 * JD-Core Version:    0.7.0.1
 */