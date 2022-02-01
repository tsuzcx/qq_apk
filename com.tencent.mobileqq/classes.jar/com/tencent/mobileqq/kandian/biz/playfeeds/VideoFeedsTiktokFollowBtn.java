package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsFollowButton;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;

public class VideoFeedsTiktokFollowBtn
  extends ImageView
  implements IVideoFeedsFollowButton
{
  public VideoFeedsTiktokFollowBtn(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoFeedsTiktokFollowBtn(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoFeedsTiktokFollowBtn(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public long a()
  {
    return 0L;
  }
  
  public View a()
  {
    return this;
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsTiktokFollowBtn
 * JD-Core Version:    0.7.0.1
 */