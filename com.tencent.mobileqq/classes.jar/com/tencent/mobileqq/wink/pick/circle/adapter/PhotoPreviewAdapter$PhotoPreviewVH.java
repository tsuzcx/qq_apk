package com.tencent.mobileqq.wink.pick.circle.adapter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.wink.pick.circle.widget.MultiTouchImageView;
import com.tencent.mobileqq.wink.pick.circle.widget.WinkCircleVideoPreviewItemView;

public class PhotoPreviewAdapter$PhotoPreviewVH
  extends RecyclerView.ViewHolder
{
  public MultiTouchImageView a;
  public WinkCircleVideoPreviewItemView b;
  
  public PhotoPreviewAdapter$PhotoPreviewVH(View paramView)
  {
    super(paramView);
    this.a = ((MultiTouchImageView)paramView.findViewById(2131440185));
    if ((paramView instanceof WinkCircleVideoPreviewItemView)) {
      this.b = ((WinkCircleVideoPreviewItemView)paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.adapter.PhotoPreviewAdapter.PhotoPreviewVH
 * JD-Core Version:    0.7.0.1
 */