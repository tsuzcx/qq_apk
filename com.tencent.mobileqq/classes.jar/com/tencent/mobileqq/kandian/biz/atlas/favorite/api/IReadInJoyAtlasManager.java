package com.tencent.mobileqq.kandian.biz.atlas.favorite.api;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/atlas/favorite/api/IReadInJoyAtlasManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "doFavorite", "", "activity", "Landroid/app/Activity;", "uin", "", "type", "", "rowkey", "title", "summary", "coverImage", "url", "extraData", "Landroid/os/Bundle;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyAtlasManager
  extends QRouteApi
{
  public abstract void doFavorite(@Nullable Activity paramActivity, @Nullable String paramString1, int paramInt, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, @Nullable String paramString5, @Nullable String paramString6, @Nullable Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.favorite.api.IReadInJoyAtlasManager
 * JD-Core Version:    0.7.0.1
 */