package com.tencent.mobileqq.qqexpand.flutter;

import com.peterlmeng.animate_image.renderer.IRenderWorkerFactory;
import com.peterlmeng.animate_image.renderer.RenderWorker;
import com.peterlmeng.animate_image.renderer.RenderWorkerFactory;
import com.peterlmeng.animate_image.renderer.RenderWorkerFactory.CreateRenderWorkerParams;
import com.tencent.mobileqq.qqexpand.flutter.apng.ApngDrawableWrapper;
import com.tencent.mobileqq.qqexpand.utils.ILog;
import com.tencent.mobileqq.qqexpand.utils.LogUtils;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/qqexpand/flutter/ExpandFlutterUtils$apngRenderFactory$1", "Lcom/peterlmeng/animate_image/renderer/IRenderWorkerFactory;", "create", "Lcom/peterlmeng/animate_image/renderer/RenderWorker;", "params", "Lcom/peterlmeng/animate_image/renderer/RenderWorkerFactory$CreateRenderWorkerParams;", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandFlutterUtils$apngRenderFactory$1
  implements IRenderWorkerFactory
{
  @NotNull
  public RenderWorker create(@Nullable RenderWorkerFactory.CreateRenderWorkerParams paramCreateRenderWorkerParams)
  {
    try
    {
      localObject = LogUtils.a;
      if (QLog.isDevelopLevel())
      {
        localObject = ((LogUtils)localObject).a();
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("vashDev IRenderWorkerFactory: create(");
        localStringBuilder1.append(paramCreateRenderWorkerParams);
        localStringBuilder1.append(')');
        ((ILog)localObject).a("ExpandFlutterUtils", 4, localStringBuilder1.toString());
      }
      localObject = RenderWorkerFactory.newCanvasConsumerAnimatorRenderWorker(paramCreateRenderWorkerParams, ApngDrawableWrapper.a);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "RenderWorkerFactory.newC…DrawableWrapper.sFactory)");
      return localObject;
    }
    catch (Exception localException)
    {
      Object localObject = LogUtils.a.a();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("vashDev IRenderWorkerFactory: create(");
      localStringBuilder2.append(paramCreateRenderWorkerParams);
      localStringBuilder2.append(") error!");
      paramCreateRenderWorkerParams = localStringBuilder2.toString();
      Throwable localThrowable = (Throwable)localException;
      ((ILog)localObject).a("ExpandFlutterUtils", 1, paramCreateRenderWorkerParams, localThrowable);
      throw localThrowable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.ExpandFlutterUtils.apngRenderFactory.1
 * JD-Core Version:    0.7.0.1
 */