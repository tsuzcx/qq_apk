package com.tencent.tkd.weibo;

import com.tencent.tkd.topicsdk.interfaces.IImageLoader;
import com.tencent.tkd.topicsdk.interfaces.ILogger;
import com.tencent.tkd.weibo.data.IDataTransfer;
import com.tencent.tkd.weibo.framework.IEmoJiBridge;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/UiComponentSdkConfig;", "", "imageLoader", "Lcom/tencent/tkd/topicsdk/interfaces/IImageLoader;", "dataTransfer", "Lcom/tencent/tkd/weibo/data/IDataTransfer;", "logger", "Lcom/tencent/tkd/topicsdk/interfaces/ILogger;", "emoJiBridge", "Lcom/tencent/tkd/weibo/framework/IEmoJiBridge;", "(Lcom/tencent/tkd/topicsdk/interfaces/IImageLoader;Lcom/tencent/tkd/weibo/data/IDataTransfer;Lcom/tencent/tkd/topicsdk/interfaces/ILogger;Lcom/tencent/tkd/weibo/framework/IEmoJiBridge;)V", "getDataTransfer", "()Lcom/tencent/tkd/weibo/data/IDataTransfer;", "getEmoJiBridge", "()Lcom/tencent/tkd/weibo/framework/IEmoJiBridge;", "getImageLoader", "()Lcom/tencent/tkd/topicsdk/interfaces/IImageLoader;", "getLogger", "()Lcom/tencent/tkd/topicsdk/interfaces/ILogger;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "release", "", "toString", "", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class UiComponentSdkConfig
{
  @NotNull
  private final IImageLoader a;
  @NotNull
  private final IDataTransfer b;
  @NotNull
  private final ILogger c;
  @Nullable
  private final IEmoJiBridge d;
  
  public UiComponentSdkConfig(@NotNull IImageLoader paramIImageLoader, @NotNull IDataTransfer paramIDataTransfer, @NotNull ILogger paramILogger, @Nullable IEmoJiBridge paramIEmoJiBridge)
  {
    this.a = paramIImageLoader;
    this.b = paramIDataTransfer;
    this.c = paramILogger;
    this.d = paramIEmoJiBridge;
  }
  
  public final void a()
  {
    this.b.a();
  }
  
  @NotNull
  public final IImageLoader b()
  {
    return this.a;
  }
  
  @NotNull
  public final IDataTransfer c()
  {
    return this.b;
  }
  
  @NotNull
  public final ILogger d()
  {
    return this.c;
  }
  
  @Nullable
  public final IEmoJiBridge e()
  {
    return this.d;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof UiComponentSdkConfig))
      {
        paramObject = (UiComponentSdkConfig)paramObject;
        if ((Intrinsics.areEqual(this.a, paramObject.a)) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    int m = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.b;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.c;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.d;
    if (localObject != null) {
      m = localObject.hashCode();
    }
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UiComponentSdkConfig(imageLoader=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", dataTransfer=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", logger=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", emoJiBridge=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.weibo.UiComponentSdkConfig
 * JD-Core Version:    0.7.0.1
 */