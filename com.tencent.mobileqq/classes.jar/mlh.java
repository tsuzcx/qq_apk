import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoStatusListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;

public class mlh
  implements VideoPlayManager.VideoStatusListener
{
  public mlh(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter) {}
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    this.a.a(paramVideoPlayParam);
    if (paramVideoPlayParam != null)
    {
      paramVideoPlayParam = paramVideoPlayParam.a;
      if ((paramVideoPlayParam != null) && (paramVideoPlayParam.mChannelID == 56L) && (AdvertisementInfo.isAdvertisementInfo(paramVideoPlayParam))) {
        NativeAdUtils.a(null, this.a.a, NativeAdUtils.f, NativeAdUtils.l, (AdvertisementInfo)paramVideoPlayParam, null, 0L, NativeAdUtils.a(ReadInJoyBaseAdapter.h, paramVideoPlayParam.mVideoDuration, ReadInJoyBaseAdapter.i, 1, ReadInJoyBaseAdapter.f, ReadInJoyBaseAdapter.g, paramVideoPlayParam.mVideoDuration, NativeAdUtils.t));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mlh
 * JD-Core Version:    0.7.0.1
 */