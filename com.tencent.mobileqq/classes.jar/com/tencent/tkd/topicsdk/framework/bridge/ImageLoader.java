package com.tencent.tkd.topicsdk.framework.bridge;

import android.content.Context;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/bridge/ImageLoader;", "", "()V", "with", "Lcom/tencent/tkd/topicsdk/framework/ImageLoader;", "context", "Landroid/content/Context;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class ImageLoader
{
  public static final ImageLoader a = new ImageLoader();
  
  @NotNull
  public final com.tencent.tkd.topicsdk.framework.ImageLoader a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    return new com.tencent.tkd.topicsdk.framework.ImageLoader(paramContext, TopicSDK.a.a().a().a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.bridge.ImageLoader
 * JD-Core Version:    0.7.0.1
 */