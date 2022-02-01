package com.tencent.mobileqq.kandian.glue.businesshandler;

import android.util.SparseArray;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdHandlerService;
import com.tencent.mobileqq.kandian.biz.framework.handlers.DailyHandler;
import com.tencent.mobileqq.kandian.biz.framework.handlers.FrameworkHandler;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IBaseHandler;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IBusinessHandlerID;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/businesshandler/HandlerFactory;", "", "()V", "buildBusinessHandlers", "Landroid/util/SparseArray;", "Lcom/tencent/mobileqq/kandian/glue/businesshandler/api/IBaseHandler;", "listViewGroup", "Landroid/view/ViewGroup;", "createHandler", "handlerID", "", "invokeHandlerMethod", "", "handlerMap", "handlerJob", "Lcom/tencent/mobileqq/kandian/glue/businesshandler/HandlerTask;", "invokeHandlerMethodWithReturn", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class HandlerFactory
{
  public static final HandlerFactory a = new HandlerFactory();
  
  @JvmStatic
  @NotNull
  public static final SparseArray<IBaseHandler> a(@NotNull ViewGroup paramViewGroup)
  {
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "listViewGroup");
    SparseArray localSparseArray = new SparseArray();
    Object localObject = IBusinessHandlerID.a;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "IBusinessHandlerID.ALL_BUSINESS_IDS");
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      int k = IBusinessHandlerID.a[i];
      localObject = a(k);
      if (localObject == null)
      {
        QLog.d("HandlerFactoryImpl", 2, new Object[] { "create handler fail, id : ", Integer.valueOf(k) });
      }
      else
      {
        ((IBaseHandler)localObject).a(paramViewGroup);
        localSparseArray.put(k, localObject);
      }
      i += 1;
    }
    return localSparseArray;
  }
  
  @JvmStatic
  @Nullable
  public static final IBaseHandler a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return null;
          }
          return (IBaseHandler)new DailyHandler();
        }
        return (IBaseHandler)new FrameworkHandler();
      }
      return ((IRIJAdHandlerService)QRoute.api(IRIJAdHandlerService.class)).createAdHandler();
    }
    return (IBaseHandler)new VideoHandler();
  }
  
  @JvmStatic
  @Nullable
  public static final Object a(@NotNull SparseArray<IBaseHandler> paramSparseArray, @Nullable HandlerTask paramHandlerTask)
  {
    Intrinsics.checkParameterIsNotNull(paramSparseArray, "handlerMap");
    if (paramHandlerTask == null) {
      return null;
    }
    int i = 0;
    int j = paramSparseArray.size();
    Object localObject2;
    for (Object localObject1 = null; i < j; localObject1 = localObject2)
    {
      paramHandlerTask.a((IBaseHandler)paramSparseArray.valueAt(i));
      localObject2 = localObject1;
      if (paramHandlerTask.g != null)
      {
        if (localObject1 != null) {
          break;
        }
        localObject2 = paramHandlerTask.g;
        localObject1 = paramSparseArray.valueAt(i);
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        ((IBaseHandler)localObject1).s();
        paramHandlerTask.g = null;
      }
      i += 1;
    }
    return localObject1;
  }
  
  @JvmStatic
  public static final void b(@NotNull SparseArray<IBaseHandler> paramSparseArray, @Nullable HandlerTask paramHandlerTask)
  {
    Intrinsics.checkParameterIsNotNull(paramSparseArray, "handlerMap");
    if (paramHandlerTask == null) {
      return;
    }
    int i = 0;
    int j = paramSparseArray.size();
    while (i < j)
    {
      paramHandlerTask.a((IBaseHandler)paramSparseArray.valueAt(i));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.HandlerFactory
 * JD-Core Version:    0.7.0.1
 */