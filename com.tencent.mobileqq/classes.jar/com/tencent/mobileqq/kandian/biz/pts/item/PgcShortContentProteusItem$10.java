package com.tencent.mobileqq.kandian.biz.pts.item;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.gifvideo.base.video.VideoView.OnProgressChangedListener;

class PgcShortContentProteusItem$10
  implements VideoView.OnProgressChangedListener
{
  PgcShortContentProteusItem$10(PgcShortContentProteusItem paramPgcShortContentProteusItem, ViewBase paramViewBase) {}
  
  public void a(long paramLong)
  {
    if ((this.a.getVisibility() == 0) && (paramLong >= 4000L)) {
      this.a.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.PgcShortContentProteusItem.10
 * JD-Core Version:    0.7.0.1
 */