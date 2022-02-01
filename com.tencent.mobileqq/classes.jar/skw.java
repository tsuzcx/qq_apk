import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment.5.1;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment.5.2;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment.5.3;
import com.tencent.hippy.qq.module.tkd.TKDBiuModule.ParamsFetcher;
import com.tencent.hippy.qq.utils.tkd.TKDCommentDispatcher.HippyCommentEvent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class skw
  implements TKDCommentDispatcher.HippyCommentEvent
{
  public skw(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public void biuComment(@NotNull TKDBiuModule.ParamsFetcher paramParamsFetcher) {}
  
  public void closeComment()
  {
    ThreadManager.getUIHandler().post(new VideoFeedsRecommendFragment.5.1(this));
  }
  
  public void jScloseComment() {}
  
  public void onClickLike(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4) {}
  
  public void onCommentViewLayout() {}
  
  public void onCreateComment(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, @NotNull String paramString6)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null)
    {
      paramString2 = VideoFeedsRecommendFragment.a(this.a).a();
      if ((paramString2 != null) && (paramString2.a != null) && (TextUtils.equals(paramString1, paramString2.a.innerUniqueID)) && (VideoFeedsRecommendFragment.a(this.a) != null))
      {
        paramString2.e += 1;
        ThreadManager.getUIHandler().post(new VideoFeedsRecommendFragment.5.2(this, paramString2));
      }
    }
  }
  
  public void onDeleteComment(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null)
    {
      paramString2 = VideoFeedsRecommendFragment.a(this.a).a();
      if (paramString2 == null) {}
    }
    try
    {
      if ((paramString2.a != null) && (TextUtils.equals(paramString1, paramString2.a.innerUniqueID)) && (VideoFeedsRecommendFragment.a(this.a) != null))
      {
        paramString2.e -= Integer.parseInt(paramString4);
        ThreadManager.getUIHandler().post(new VideoFeedsRecommendFragment.5.3(this, paramString2));
      }
      return;
    }
    catch (NumberFormatException paramString1)
    {
      QLog.e("VideoFeedsRecommendFragment", 1, paramString1.getMessage());
    }
  }
  
  public void onFontScaleChange(double paramDouble) {}
  
  public void onSubCommentClose() {}
  
  public void onSubCommentOpen() {}
  
  public void openComment() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     skw
 * JD-Core Version:    0.7.0.1
 */