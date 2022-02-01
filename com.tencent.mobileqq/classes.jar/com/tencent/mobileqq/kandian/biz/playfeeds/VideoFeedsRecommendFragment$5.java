package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.common.TKDHippy2NativeEventSimpleReceiver;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

class VideoFeedsRecommendFragment$5
  extends TKDHippy2NativeEventSimpleReceiver
{
  VideoFeedsRecommendFragment$5(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public void closeComment()
  {
    VideoFeedsRecommendFragment.e(this.a, true);
    this.a.c();
    VideoFeedsRecommendFragment.e(this.a, false);
  }
  
  public void onCreateComment(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6, String paramString7)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null)
    {
      paramString2 = VideoFeedsRecommendFragment.a(this.a).a();
      if ((paramString2 != null) && (paramString2.a != null) && (TextUtils.equals(paramString1, paramString2.a.innerUniqueID)) && (VideoFeedsRecommendFragment.a(this.a) != null))
      {
        paramString2.e += 1;
        if (VideoFeedsRecommendFragment.a(this.a) != null) {
          VideoFeedsRecommendFragment.a(this.a).a(paramString2);
        }
      }
    }
  }
  
  public void onDeleteComment(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null)
    {
      paramString2 = VideoFeedsRecommendFragment.a(this.a).a();
      if (paramString2 != null) {
        try
        {
          if ((paramString2.a != null) && (TextUtils.equals(paramString1, paramString2.a.innerUniqueID)) && (VideoFeedsRecommendFragment.a(this.a) != null))
          {
            paramString2.e -= Integer.parseInt(paramString4);
            if (VideoFeedsRecommendFragment.a(this.a) != null)
            {
              VideoFeedsRecommendFragment.a(this.a).a(paramString2);
              return;
            }
          }
        }
        catch (NumberFormatException paramString1)
        {
          QLog.e("VideoFeedsRecommendFragment", 1, paramString1.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendFragment.5
 * JD-Core Version:    0.7.0.1
 */