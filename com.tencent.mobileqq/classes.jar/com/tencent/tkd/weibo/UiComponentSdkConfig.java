package com.tencent.tkd.weibo;

import com.tencent.tkd.weibo.data.IDataTransfer;
import com.tencent.tkd.weibo.framework.IEmoJiBridge;
import com.tencent.tkd.weibo.framework.IImageLoader;
import com.tencent.tkd.weibo.framework.ILogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/UiComponentSdkConfig;", "", "imageLoader", "Lcom/tencent/tkd/weibo/framework/IImageLoader;", "dataTransfer", "Lcom/tencent/tkd/weibo/data/IDataTransfer;", "logger", "Lcom/tencent/tkd/weibo/framework/ILogger;", "emoJiBridge", "Lcom/tencent/tkd/weibo/framework/IEmoJiBridge;", "(Lcom/tencent/tkd/weibo/framework/IImageLoader;Lcom/tencent/tkd/weibo/data/IDataTransfer;Lcom/tencent/tkd/weibo/framework/ILogger;Lcom/tencent/tkd/weibo/framework/IEmoJiBridge;)V", "getDataTransfer", "()Lcom/tencent/tkd/weibo/data/IDataTransfer;", "getEmoJiBridge", "()Lcom/tencent/tkd/weibo/framework/IEmoJiBridge;", "getImageLoader", "()Lcom/tencent/tkd/weibo/framework/IImageLoader;", "getLogger", "()Lcom/tencent/tkd/weibo/framework/ILogger;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class UiComponentSdkConfig
{
  @NotNull
  private final IDataTransfer jdField_a_of_type_ComTencentTkdWeiboDataIDataTransfer;
  @Nullable
  private final IEmoJiBridge jdField_a_of_type_ComTencentTkdWeiboFrameworkIEmoJiBridge;
  @NotNull
  private final IImageLoader jdField_a_of_type_ComTencentTkdWeiboFrameworkIImageLoader;
  @NotNull
  private final ILogger jdField_a_of_type_ComTencentTkdWeiboFrameworkILogger;
  
  public UiComponentSdkConfig(@NotNull IImageLoader paramIImageLoader, @NotNull IDataTransfer paramIDataTransfer, @NotNull ILogger paramILogger, @Nullable IEmoJiBridge paramIEmoJiBridge)
  {
    this.jdField_a_of_type_ComTencentTkdWeiboFrameworkIImageLoader = paramIImageLoader;
    this.jdField_a_of_type_ComTencentTkdWeiboDataIDataTransfer = paramIDataTransfer;
    this.jdField_a_of_type_ComTencentTkdWeiboFrameworkILogger = paramILogger;
    this.jdField_a_of_type_ComTencentTkdWeiboFrameworkIEmoJiBridge = paramIEmoJiBridge;
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
  
  @NotNull
  public final IImageLoader a()
  {
    return this.jdField_a_of_type_ComTencentTkdWeiboFrameworkIImageLoader;
  }
  
  @NotNull
  public final ILogger a()
  {
    return this.jdField_a_of_type_ComTencentTkdWeiboFrameworkILogger;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof UiComponentSdkConfig))
      {
        paramObject = (UiComponentSdkConfig)paramObject;
        if ((!Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdWeiboFrameworkIImageLoader, paramObject.jdField_a_of_type_ComTencentTkdWeiboFrameworkIImageLoader)) || (!Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdWeiboDataIDataTransfer, paramObject.jdField_a_of_type_ComTencentTkdWeiboDataIDataTransfer)) || (!Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdWeiboFrameworkILogger, paramObject.jdField_a_of_type_ComTencentTkdWeiboFrameworkILogger)) || (!Intrinsics.areEqual(this.jdField_a_of_type_ComTencentTkdWeiboFrameworkIEmoJiBridge, paramObject.jdField_a_of_type_ComTencentTkdWeiboFrameworkIEmoJiBridge))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    int m = 0;
    Object localObject = this.jdField_a_of_type_ComTencentTkdWeiboFrameworkIImageLoader;
    int i;
    int j;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.jdField_a_of_type_ComTencentTkdWeiboDataIDataTransfer;
      if (localObject == null) {
        break label95;
      }
      j = localObject.hashCode();
      label37:
      localObject = this.jdField_a_of_type_ComTencentTkdWeiboFrameworkILogger;
      if (localObject == null) {
        break label100;
      }
    }
    label95:
    label100:
    for (int k = localObject.hashCode();; k = 0)
    {
      localObject = this.jdField_a_of_type_ComTencentTkdWeiboFrameworkIEmoJiBridge;
      if (localObject != null) {
        m = localObject.hashCode();
      }
      return (k + (j + i * 31) * 31) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label37;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "UiComponentSdkConfig(imageLoader=" + this.jdField_a_of_type_ComTencentTkdWeiboFrameworkIImageLoader + ", dataTransfer=" + this.jdField_a_of_type_ComTencentTkdWeiboDataIDataTransfer + ", logger=" + this.jdField_a_of_type_ComTencentTkdWeiboFrameworkILogger + ", emoJiBridge=" + this.jdField_a_of_type_ComTencentTkdWeiboFrameworkIEmoJiBridge + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.UiComponentSdkConfig
 * JD-Core Version:    0.7.0.1
 */