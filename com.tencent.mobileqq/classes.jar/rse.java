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

public class rse
  implements rro
{
  private rse(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public void a(rrm paramrrm) {}
  
  public void a(rrm paramrrm, int paramInt) {}
  
  public void a(rrm paramrrm, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(rrm paramrrm, boolean paramBoolean)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsRecommendFragment.a(this.a).b();
    }
  }
  
  public void b(rrm paramrrm)
  {
    if ((ryi.a().a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Rrm.jdField_a_of_type_Rwf)) && (bnrf.v(VideoFeedsRecommendFragment.a(this.a))) && (paramrrm == VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Rrm))
    {
      int i = VideoFeedsRecommendFragment.a(this.a).c;
      int j = VideoFeedsRecommendFragment.a(this.a).c();
      Object localObject = VideoFeedsRecommendFragment.a(this.a).findViewHolderForLayoutPosition(i + j + 1);
      if ((localObject instanceof rol))
      {
        localObject = (rol)localObject;
        if (((rol)localObject).jdField_a_of_type_Rrm != null) {
          VideoFeedsRecommendFragment.a(this.a).b(((rol)localObject).jdField_a_of_type_Rrm);
        }
      }
    }
    if ((VideoFeedsRecommendFragment.a(this.a).c == 0) && (paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0)) {
      VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Rvo.a(3);
    }
    if ((VideoFeedsRecommendFragment.a(this.a) != null) && (paramrrm != null) && (VideoFeedsRecommendFragment.a(this.a).size() > 0) && (paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      if (paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c)
      {
        if (paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Tmf.a <= 0L) {
          paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Tmf.a = VideoFeedsRecommendFragment.a(this.a).a();
        }
        VideoFeedsRecommendFragment.a(this.a).f();
      }
    }
    else {
      return;
    }
    VideoFeedsRecommendFragment.a(this.a).a();
    paramrrm = paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;
    if ((paramrrm != null) && (paramrrm.equalsIgnoreCase(((VideoInfo)VideoFeedsRecommendFragment.a(this.a).get(0)).jdField_a_of_type_JavaLangString)))
    {
      VideoFeedsRecommendFragment.a(this.a).b(0);
      return;
    }
    VideoFeedsRecommendFragment.a(this.a).b(VideoFeedsRecommendFragment.a(this.a).c + 1);
  }
  
  public void b(rrm paramrrm, boolean paramBoolean) {}
  
  public void c(rrm paramrrm)
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
          VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Rvo.a(5);
          return;
        }
        if (VideoFeedsRecommendFragment.e(this.a))
        {
          if ((VideoFeedsRecommendFragment.a(this.a) != null) && (VideoFeedsRecommendFragment.a(this.a).a() != null))
          {
            VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Rrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo));
            VideoFeedsRecommendFragment.a(this.a).a();
            return;
          }
          VideoFeedsRecommendFragment.a(this.a).b();
        }
        if ((paramrrm == null) || (paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) || (nzq.a(paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).mShowAdButton)) {
          break;
        }
      } while ((VideoFeedsRecommendFragment.a(this.a) == null) || (VideoFeedsRecommendFragment.a(this.a).a() == null) || (VideoFeedsRecommendFragment.a(this.a) == null));
      VideoFeedsRecommendFragment.a(this.a).e();
      VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).a());
      return;
    } while ((VideoFeedsRecommendFragment.a(this.a).a(paramrrm)) || (VideoFeedsRecommendFragment.a(this.a).c == VideoFeedsRecommendFragment.a(this.a).size() - 1) || ((!VideoFeedsRecommendFragment.g(this.a)) && (bhnv.b(VideoFeedsRecommendFragment.a(this.a).getApplication().getApplicationContext()))));
    if (VideoFeedsRecommendFragment.a(this.a).a())
    {
      VideoFeedsRecommendFragment.a(this.a, true);
      return;
    }
    if (bool)
    {
      VideoFeedsRecommendFragment.a(this.a).addOnLayoutChangeListener(new rsf(this));
      return;
    }
    VideoFeedsRecommendFragment.a(this.a).a();
  }
  
  public void d(rrm paramrrm)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsAccessibilityHelper.a(VideoFeedsRecommendFragment.a(this.a).i, true);
    }
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsRecommendFragment.a(this.a).b();
    }
  }
  
  public void e(rrm paramrrm)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsAccessibilityHelper.a(VideoFeedsRecommendFragment.a(this.a).i, false);
    }
    if (paramrrm.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c)
    {
      VideoFeedsRecommendFragment.a(this.a).f();
      return;
    }
    VideoFeedsRecommendFragment.a(this.a).a();
  }
  
  public void f(rrm paramrrm) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rse
 * JD-Core Version:    0.7.0.1
 */