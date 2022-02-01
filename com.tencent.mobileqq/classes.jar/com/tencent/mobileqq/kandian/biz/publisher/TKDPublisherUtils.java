package com.tencent.mobileqq.kandian.biz.publisher;

import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.interfaces.IAccount;
import com.tencent.tkd.topicsdk.interfaces.IStorageConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/TKDPublisherUtils;", "", "()V", "accountConfig", "Lcom/tencent/tkd/topicsdk/interfaces/IAccount;", "getAccountConfig$kandian_feature_impl_release", "()Lcom/tencent/tkd/topicsdk/interfaces/IAccount;", "storageConfig", "Lcom/tencent/tkd/topicsdk/interfaces/IStorageConfig;", "getStorageConfig$kandian_feature_impl_release", "()Lcom/tencent/tkd/topicsdk/interfaces/IStorageConfig;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class TKDPublisherUtils
{
  public static final TKDPublisherUtils a = new TKDPublisherUtils();
  
  @NotNull
  public final IAccount a()
  {
    return TopicSDK.a.a().a().a();
  }
  
  @NotNull
  public final IStorageConfig a()
  {
    return TopicSDK.a.a().a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.TKDPublisherUtils
 * JD-Core Version:    0.7.0.1
 */