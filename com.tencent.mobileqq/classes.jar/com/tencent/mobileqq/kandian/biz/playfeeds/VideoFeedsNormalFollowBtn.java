package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsFollowButton;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;

public class VideoFeedsNormalFollowBtn
  extends TextView
  implements IVideoFeedsFollowButton
{
  public VideoFeedsNormalFollowBtn(Context paramContext)
  {
    super(paramContext);
  }
  
  public VideoFeedsNormalFollowBtn(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VideoFeedsNormalFollowBtn(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setText(HardCodeUtil.a(2131913412));
      setBackgroundDrawable(VideoFeedsResourceLoader.a(getContext(), 2130844224));
      setCompoundDrawables(null, null, null, null);
      return;
    }
    setText(HardCodeUtil.a(2131899712));
    setBackgroundDrawable(VideoFeedsResourceLoader.a(getContext(), 2130844062));
  }
  
  public long getAnimDelayDuration()
  {
    return 3000L;
  }
  
  public View getView()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsNormalFollowBtn
 * JD-Core Version:    0.7.0.1
 */