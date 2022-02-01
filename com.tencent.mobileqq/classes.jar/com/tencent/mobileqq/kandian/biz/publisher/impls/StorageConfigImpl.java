package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.content.Context;
import com.tencent.mobileqq.app.AppConstants;
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
    return "com.tencent.mobileqq.fileProvider";
  }
  
  @NotNull
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    File localFile = AppContext.a.a().getFilesDir();
    Intrinsics.checkExpressionValueIsNotNull(localFile, "AppContext.instance.filesDir");
    return localFile.getAbsolutePath() + "/Tencent/TKPublisher/" + TKDPublisherUtils.a.a().a() + '/';
  }
  
  @NotNull
  public String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    File localFile = AppContext.a.a().getFilesDir();
    Intrinsics.checkExpressionValueIsNotNull(localFile, "AppContext.instance.filesDir");
    return localFile.getAbsolutePath() + "/Tencent/TKPublisher/temp/" + TKDPublisherUtils.a.a().a() + '/';
  }
  
  @NotNull
  public String d()
  {
    return AppConstants.SDCARD_PATH + "/TKDPublisher/" + TKDPublisherUtils.a.a().a() + '/';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.StorageConfigImpl
 * JD-Core Version:    0.7.0.1
 */