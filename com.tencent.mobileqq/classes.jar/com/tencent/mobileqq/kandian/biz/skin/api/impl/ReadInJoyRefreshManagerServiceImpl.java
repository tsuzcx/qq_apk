package com.tencent.mobileqq.kandian.biz.skin.api.impl;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoyRefreshManager;
import com.tencent.mobileqq.kandian.biz.skin.api.IReadInJoyRefreshManagerService;
import com.tencent.mobileqq.kandian.biz.skin.entity.SkinData;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/skin/api/impl/ReadInJoyRefreshManagerServiceImpl;", "Lcom/tencent/mobileqq/kandian/biz/skin/api/IReadInJoyRefreshManagerService;", "()V", "getRefreshData", "Lcom/tencent/mobileqq/kandian/biz/skin/entity/SkinData;", "ctx", "Landroid/content/Context;", "source", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyRefreshManagerServiceImpl
  implements IReadInJoyRefreshManagerService
{
  @Nullable
  public SkinData getRefreshData(@Nullable Context paramContext, int paramInt)
  {
    return (SkinData)ReadInJoyRefreshManager.b(paramContext, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.api.impl.ReadInJoyRefreshManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */