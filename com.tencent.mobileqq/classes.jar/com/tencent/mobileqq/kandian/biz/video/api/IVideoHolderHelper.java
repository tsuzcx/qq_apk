package com.tencent.mobileqq.kandian.biz.video.api;

import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoHolderHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "isShortVideoItemHolder", "", "holder", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/viewholder/VideoItemHolder;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVideoHolderHelper
  extends QRouteApi
{
  public abstract boolean isShortVideoItemHolder(@Nullable VideoItemHolder paramVideoItemHolder);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.api.IVideoHolderHelper
 * JD-Core Version:    0.7.0.1
 */