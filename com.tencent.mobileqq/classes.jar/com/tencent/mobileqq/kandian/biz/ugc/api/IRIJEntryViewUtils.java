package com.tencent.mobileqq.kandian.biz.ugc.api;

import android.os.Bundle;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/ugc/api/IRIJEntryViewUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "jumpUGCPublisherActivity", "", "from", "", "data", "Landroid/os/Bundle;", "callback", "", "parseMultiBiuStruct2Json", "Lorg/json/JSONObject;", "multiBiuStruct", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/kandian/repo/handler/BiuCommentInfo;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJEntryViewUtils
  extends QRouteApi
{
  public abstract void jumpUGCPublisherActivity(int paramInt, @NotNull Bundle paramBundle, @NotNull String paramString);
  
  @NotNull
  public abstract JSONObject parseMultiBiuStruct2Json(@NotNull ArrayList<BiuCommentInfo> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.api.IRIJEntryViewUtils
 * JD-Core Version:    0.7.0.1
 */