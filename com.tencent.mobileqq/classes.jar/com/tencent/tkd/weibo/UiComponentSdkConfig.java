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
  private final IImageLoader jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIImageLoader;
  @NotNull
  private final ILogger jdField_a_of_type_ComTencentTkdTopicsdkInterfacesILogger;
  @NotNull
  private final IDataTransfer jdField_a_of_type_ComTencentTkdWeiboDataIDataTransfer;
  @Nullable
  private final IEmoJiBridge jdField_a_of_type_ComTencentTkdWeiboFrameworkIEmoJiBridge;
  
  public UiComponentSdkConfig(@NotNull IImageLoader paramIImageLoader, @NotNull IDataTransfer paramIDataTransfer, @NotNull ILogger paramILogger, @Nullable IEmoJiBridge paramIEmoJiBridge)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIImageLoader = paramIImageLoader;
    this.jdField_a_of_type_ComTencentTkdWeiboDataIDataTransfer = paramIDataTransfer;
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesILogger = paramILogger;
    this.jdField_a_of_type_ComTencentTkdWeiboFrameworkIEmoJiBridge = paramIEmoJiBridge;
  }
  
  @NotNull
  public final IImageLoader a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIImageLoader;
  }
  
  @NotNull
  public final ILogger a()
  {
    return this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesILogger;
  }
  
  @NotNull
  public final IDataTransfer a()
  {
    return this.jdField_a_of_type_ComTencentTkdWeiboDataIDataTransfer;
  }
  
  @Nullable
  public final IEmoJiBridge a()
  {
    return this.jdField_a_of_type_ComTencentTkdWeiboFrameworkIEmoJiBridge;
  }
  
  public final void a()
  {
    this.jdField_a_of_type_ComTencentTkdWeiboDataIDataTransfer.a();
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof UiComponentSdkConfig))
      {
        paramObject = (UiComponentSdkConfig)paramObject;
        if ((Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIImageLoader, paramObject.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIImageLoader)) && (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdWeiboDataIDataTransfer, paramObject.jdField_a_of_type_ComTencentTkdWeiboDataIDataTransfer)) && (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesILogger, paramObject.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesILogger)) && (Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdWeiboFrameworkIEmoJiBridge, paramObject.jdField_a_of_type_ComTencentTkdWeiboFrameworkIEmoJiBridge))) {}
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
    Object localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIImageLoader;
    int m = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.jdField_a_of_type_ComTencentTkdWeiboDataIDataTransfer;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesILogger;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.jdField_a_of_type_ComTencentTkdWeiboFrameworkIEmoJiBridge;
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
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIImageLoader);
    localStringBuilder.append(", dataTransfer=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTkdWeiboDataIDataTransfer);
    localStringBuilder.append(", logger=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesILogger);
    localStringBuilder.append(", emoJiBridge=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTkdWeiboFrameworkIEmoJiBridge);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.UiComponentSdkConfig
 * JD-Core Version:    0.7.0.1
 */