package com.tencent.mobileqq.kandian.biz.ugc.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.diandian.entryview.RIJEntryViewUtils;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJEntryViewUtils;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/ugc/api/impl/RIJEntryViewUtilsImpl;", "Lcom/tencent/mobileqq/kandian/biz/ugc/api/IRIJEntryViewUtils;", "()V", "jumpUGCPublisherActivity", "", "from", "", "data", "Landroid/os/Bundle;", "callback", "", "parseMultiBiuStruct2Json", "Lorg/json/JSONObject;", "multiBiuStruct", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJEntryViewUtilsImpl
  implements IRIJEntryViewUtils
{
  public void jumpUGCPublisherActivity(int paramInt, @NotNull Bundle paramBundle, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "data");
    Intrinsics.checkParameterIsNotNull(paramString, "callback");
    RIJEntryViewUtils.a(RIJEntryViewUtils.a, paramInt, paramBundle, paramString, null, 8, null);
  }
  
  @NotNull
  public JSONObject parseMultiBiuStruct2Json(@NotNull ArrayList<BiuCommentInfo> paramArrayList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "multiBiuStruct");
    return RIJEntryViewUtils.a(paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.api.impl.RIJEntryViewUtilsImpl
 * JD-Core Version:    0.7.0.1
 */