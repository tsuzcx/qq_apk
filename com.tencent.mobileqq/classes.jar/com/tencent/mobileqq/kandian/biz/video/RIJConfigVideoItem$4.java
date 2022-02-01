package com.tencent.mobileqq.kandian.biz.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.biz.video.viewholder.BigImgVideoColumnItemViewHolder;

final class RIJConfigVideoItem$4
  implements View.OnClickListener
{
  RIJConfigVideoItem$4(String paramString, BigImgVideoColumnItemViewHolder paramBigImgVideoColumnItemViewHolder) {}
  
  public void onClick(View paramView)
  {
    PublicAccountReportUtils.a(null, "", "0X8009BE2", "0X8009BE2", 0, 0, "", "", "", this.a, false);
    VideoHandler.c(this.b.Q);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.RIJConfigVideoItem.4
 * JD-Core Version:    0.7.0.1
 */