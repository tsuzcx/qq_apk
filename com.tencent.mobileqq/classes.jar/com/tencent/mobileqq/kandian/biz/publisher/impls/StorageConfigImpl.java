package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.publisher.TKDPublisherUtils;
import com.tencent.tkd.topicsdk.framework.AppContext;
import com.tencent.tkd.topicsdk.interfaces.IAccount;
import com.tencent.tkd.topicsdk.interfaces.IStorageConfig;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/StorageConfigImpl;", "Lcom/tencent/tkd/topicsdk/interfaces/IStorageConfig;", "()V", "getBaseDir", "", "getBaseSDCardDir", "getFileProviderAuthority", "getPublishTempDir", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class StorageConfigImpl
  implements IStorageConfig
{
  @NotNull
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    File localFile = AppContext.a.a().getFilesDir();
    Intrinsics.checkExpressionValueIsNotNull(localFile, "AppContext.instance.filesDir");
    localStringBuilder.append(localFile.getAbsolutePath());
    localStringBuilder.append("/Tencent/TKPublisher/");
    localStringBuilder.append(TKDPublisherUtils.a.a().a());
    localStringBuilder.append('/');
    return localStringBuilder.toString();
  }
  
  @NotNull
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    File localFile = AppContext.a.a().getFilesDir();
    Intrinsics.checkExpressionValueIsNotNull(localFile, "AppContext.instance.filesDir");
    localStringBuilder.append(localFile.getAbsolutePath());
    localStringBuilder.append("/Tencent/TKPublisher/temp/");
    localStringBuilder.append(TKDPublisherUtils.a.a().a());
    localStringBuilder.append('/');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.StorageConfigImpl
 * JD-Core Version:    0.7.0.1
 */