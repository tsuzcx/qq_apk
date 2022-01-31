import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class rgl
  implements rfu
{
  private rgl(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public void a(rfs paramrfs) {}
  
  public void a(rfs paramrfs, int paramInt) {}
  
  public void a(rfs paramrfs, int paramInt1, int paramInt2, String paramString)
  {
    if ((VideoFeedsRecommendFragment.a(this.a) != null) && (!paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c)) {
      VideoFeedsRecommendFragment.a(this.a).d();
    }
  }
  
  public void a(rfs paramrfs, boolean paramBoolean)
  {
    if ((VideoFeedsRecommendFragment.a(this.a) != null) && (!paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c)) {
      VideoFeedsRecommendFragment.a(this.a).d();
    }
  }
  
  public void b(rfs paramrfs)
  {
    if ((rmd.a().a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Rfs.jdField_a_of_type_Rjn)) && (bkbq.u(VideoFeedsRecommendFragment.a(this.a))))
    {
      int i = VideoFeedsRecommendFragment.a(this.a).c;
      int j = VideoFeedsRecommendFragment.a(this.a).c();
      Object localObject = VideoFeedsRecommendFragment.a(this.a).findViewHolderForLayoutPosition(i + j + 1);
      if ((localObject instanceof rbn))
      {
        localObject = (rbn)localObject;
        if (((rbn)localObject).jdField_a_of_type_Rfs != null) {
          VideoFeedsRecommendFragment.a(this.a).b(((rbn)localObject).jdField_a_of_type_Rfs);
        }
      }
    }
    if ((VideoFeedsRecommendFragment.a(this.a).c == 0) && (paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0)) {
      VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Riw.a(3);
    }
    if (VideoFeedsRecommendFragment.h(this.a))
    {
      VideoFeedsRecommendFragment.e(this.a, false);
      rcp.a().h();
    }
    if ((VideoFeedsRecommendFragment.a(this.a) != null) && (!paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c)) {
      VideoFeedsRecommendFragment.a(this.a).a(paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, VideoFeedsRecommendFragment.a(this.a).b());
    }
  }
  
  public void b(rfs paramrfs, boolean paramBoolean)
  {
    if ((VideoFeedsRecommendFragment.a(this.a) != null) && (!paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) && (paramBoolean)) {
      VideoFeedsRecommendFragment.a(this.a).a(paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, VideoFeedsRecommendFragment.a(this.a).b());
    }
  }
  
  public void c(rfs paramrfs)
  {
    boolean bool;
    if (VideoFeedsRecommendFragment.a(this.a) != null)
    {
      bool = VideoFeedsRecommendFragment.a(this.a).c();
      VideoFeedsPlayActivity.a("video play completion!, in weishi mode! interrupted weishi ad");
      if (!bool) {}
    }
    do
    {
      do
      {
        return;
        VideoFeedsPlayActivity.a("video play completion!, move to next position");
        bool = VideoFeedsRecommendFragment.e(this.a);
        if (VideoFeedsRecommendFragment.b(this.a))
        {
          if (bool)
          {
            VideoFeedsRecommendFragment.a(this.a).b();
            return;
          }
          VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Riw.a(5);
          return;
        }
        if (VideoFeedsRecommendFragment.e(this.a))
        {
          if ((VideoFeedsRecommendFragment.a(this.a) != null) && (VideoFeedsRecommendFragment.a(this.a).a() != null))
          {
            VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Rfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo));
            VideoFeedsRecommendFragment.a(this.a).a();
            return;
          }
          VideoFeedsRecommendFragment.a(this.a).b();
        }
        if ((paramrfs == null) || (paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) || (noy.a(paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).mShowAdButton)) {
          break;
        }
      } while ((VideoFeedsRecommendFragment.a(this.a) == null) || (VideoFeedsRecommendFragment.a(this.a).a() == null) || (VideoFeedsRecommendFragment.a(this.a) == null));
      VideoFeedsRecommendFragment.a(this.a).e();
      VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).a());
      return;
    } while ((VideoFeedsRecommendFragment.a(this.a).a(paramrfs)) || (VideoFeedsRecommendFragment.a(this.a).c == VideoFeedsRecommendFragment.a(this.a).size() - 1) || ((!VideoFeedsRecommendFragment.g(this.a)) && (bdin.b(VideoFeedsRecommendFragment.a(this.a).getApplication().getApplicationContext()))));
    if (VideoFeedsRecommendFragment.a(this.a).a())
    {
      VideoFeedsRecommendFragment.a(this.a, true);
      return;
    }
    if (bool)
    {
      VideoFeedsRecommendFragment.a(this.a).addOnLayoutChangeListener(new rgm(this));
      return;
    }
    VideoFeedsRecommendFragment.a(this.a).a();
  }
  
  public void d(rfs paramrfs)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsAccessibilityHelper.a(VideoFeedsRecommendFragment.a(this.a).g, true);
    }
    if ((VideoFeedsRecommendFragment.a(this.a) != null) && (!paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c)) {
      VideoFeedsRecommendFragment.a(this.a).d();
    }
  }
  
  public void e(rfs paramrfs)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsAccessibilityHelper.a(VideoFeedsRecommendFragment.a(this.a).g, false);
    }
    if ((VideoFeedsRecommendFragment.a(this.a) != null) && (!paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c)) {
      VideoFeedsRecommendFragment.a(this.a).a(paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, VideoFeedsRecommendFragment.a(this.a).b());
    }
  }
  
  public void f(rfs paramrfs)
  {
    if ((VideoFeedsRecommendFragment.a(this.a) != null) && (!paramrfs.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c)) {
      VideoFeedsRecommendFragment.a(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rgl
 * JD-Core Version:    0.7.0.1
 */