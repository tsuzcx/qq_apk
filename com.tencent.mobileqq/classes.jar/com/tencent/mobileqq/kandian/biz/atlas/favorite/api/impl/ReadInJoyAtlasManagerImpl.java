package com.tencent.mobileqq.kandian.biz.atlas.favorite.api.impl;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasManager;
import com.tencent.mobileqq.kandian.biz.atlas.favorite.api.IReadInJoyAtlasManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/atlas/favorite/api/impl/ReadInJoyAtlasManagerImpl;", "Lcom/tencent/mobileqq/kandian/biz/atlas/favorite/api/IReadInJoyAtlasManager;", "()V", "doFavorite", "", "activity", "Landroid/app/Activity;", "uin", "", "type", "", "rowkey", "title", "summary", "coverImage", "url", "extraData", "Landroid/os/Bundle;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyAtlasManagerImpl
  implements IReadInJoyAtlasManager
{
  public ReadInJoyAtlasManagerImpl()
  {
    ReadInJoyAtlasManager localReadInJoyAtlasManager = ReadInJoyAtlasManager.getInstance();
    Intrinsics.checkExpressionValueIsNotNull(localReadInJoyAtlasManager, "ReadInJoyAtlasManager.getInstance()");
    this.$$delegate_0 = localReadInJoyAtlasManager;
  }
  
  public void doFavorite(@Nullable Activity paramActivity, @Nullable String paramString1, int paramInt, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable String paramString5, @Nullable String paramString6, @Nullable Bundle paramBundle)
  {
    this.$$delegate_0.doFavorite(paramActivity, paramString1, paramInt, paramString2, paramString3, paramString4, paramString5, paramString6, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.favorite.api.impl.ReadInJoyAtlasManagerImpl
 * JD-Core Version:    0.7.0.1
 */