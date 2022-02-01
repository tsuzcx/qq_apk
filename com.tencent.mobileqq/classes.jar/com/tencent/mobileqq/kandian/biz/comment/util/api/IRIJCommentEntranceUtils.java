package com.tencent.mobileqq.kandian.biz.comment.util.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/util/api/IRIJCommentEntranceUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "startForResult", "", "activity", "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "requestCode", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJCommentEntranceUtils
  extends QRouteApi
{
  public abstract void startForResult(@NotNull Activity paramActivity, @NotNull Intent paramIntent, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentEntranceUtils
 * JD-Core Version:    0.7.0.1
 */