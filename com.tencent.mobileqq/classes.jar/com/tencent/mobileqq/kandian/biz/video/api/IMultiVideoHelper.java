package com.tencent.mobileqq.kandian.biz.video.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/IMultiVideoHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "start", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IMultiVideoHelper
  extends QRouteApi
{
  public abstract void start(@Nullable Context paramContext, @Nullable Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.IMultiVideoHelper
 * JD-Core Version:    0.7.0.1
 */