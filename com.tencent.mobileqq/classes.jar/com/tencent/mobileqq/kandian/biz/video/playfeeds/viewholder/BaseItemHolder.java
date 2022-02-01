package com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.kandian.base.view.widget.VideoFeedsAlphaMaskView;
import com.tencent.mobileqq.kandian.biz.common.baseui.api.IResourceId;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAdapter;
import com.tencent.mobileqq.qroute.QRoute;

public class BaseItemHolder
  extends RecyclerView.ViewHolder
{
  public VideoFeedsAlphaMaskView W;
  public final int X;
  public int Y;
  public int Z;
  
  public BaseItemHolder(View paramView, int paramInt)
  {
    super(paramView);
    this.W = ((VideoFeedsAlphaMaskView)paramView.findViewById(((IResourceId)QRoute.api(IResourceId.class)).getCommonMaskView()));
    this.X = paramInt;
  }
  
  public void a(IVideoFeedsAdapter paramIVideoFeedsAdapter, LinearLayoutManager paramLinearLayoutManager, boolean paramBoolean)
  {
    paramIVideoFeedsAdapter = this.W;
    if (paramIVideoFeedsAdapter != null)
    {
      if (paramIVideoFeedsAdapter.getVisibility() != 0) {
        return;
      }
      int j = paramLinearLayoutManager.getOrientation();
      int i = 1;
      if (j != 1) {
        i = 0;
      }
      if (i != 0)
      {
        i = paramLinearLayoutManager.getDecoratedMeasuredHeight(this.itemView);
        j = Math.abs(paramLinearLayoutManager.getDecoratedTop(this.itemView) - (paramLinearLayoutManager.getHeight() / 2 - i / 2));
      }
      else
      {
        i = paramLinearLayoutManager.getDecoratedMeasuredWidth(this.itemView);
        j = Math.abs(paramLinearLayoutManager.getDecoratedLeft(this.itemView) - (paramLinearLayoutManager.getWidth() / 2 - i / 2));
      }
      float f = Math.min(Math.round(j / i * 100.0F) / 100.0F, 1.0F);
      this.W.setAlpha(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseItemHolder
 * JD-Core Version:    0.7.0.1
 */