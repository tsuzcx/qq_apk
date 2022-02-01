package com.tencent.mobileqq.kandian.biz.ugc.camera.api.impl;

import android.content.Context;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.ugc.camera.api.IReadInJoyCameraCaptureSoManager;
import com.tencent.mobileqq.kandian.biz.ugc.camera.api.IReadInJoyCameraCaptureSoManagerFactory;
import com.tencent.mobileqq.kandian.biz.ugc.capture.ReadInJoyCameraCaptureSoManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/ugc/camera/api/impl/ReadInJoyCameraCaptureSoManagerFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/ugc/camera/api/IReadInJoyCameraCaptureSoManagerFactory;", "()V", "createManager", "Lcom/tencent/mobileqq/kandian/biz/ugc/camera/api/IReadInJoyCameraCaptureSoManager;", "context", "Landroid/content/Context;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyCameraCaptureSoManagerFactoryImpl
  implements IReadInJoyCameraCaptureSoManagerFactory
{
  @NotNull
  public IReadInJoyCameraCaptureSoManager createManager(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return (IReadInJoyCameraCaptureSoManager)new ReadInJoyCameraCaptureSoManager(RIJQQAppInterfaceUtil.b(), paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.camera.api.impl.ReadInJoyCameraCaptureSoManagerFactoryImpl
 * JD-Core Version:    0.7.0.1
 */