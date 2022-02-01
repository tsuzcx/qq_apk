import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.ArrayList;
import mqq.app.MobileQQ;

public class rzi
  implements ryq
{
  private rzi(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public void a(ryo paramryo)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsAccessibilityHelper.a(VideoFeedsRecommendFragment.a(this.a).i, false);
    }
    if (paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c)
    {
      VideoFeedsRecommendFragment.a(this.a).f();
      return;
    }
    VideoFeedsRecommendFragment.a(this.a).a();
  }
  
  public void a(ryo paramryo, int paramInt) {}
  
  public void a(ryo paramryo, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(ryo paramryo, boolean paramBoolean)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsRecommendFragment.a(this.a).b();
    }
  }
  
  public void b(ryo paramryo)
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
          VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Scs.a(5);
          return;
        }
        if (VideoFeedsRecommendFragment.e(this.a))
        {
          if ((VideoFeedsRecommendFragment.a(this.a) != null) && (VideoFeedsRecommendFragment.a(this.a).a() != null))
          {
            VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Ryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo));
            VideoFeedsRecommendFragment.a(this.a).a();
            return;
          }
          VideoFeedsRecommendFragment.a(this.a).b();
        }
        if ((paramryo == null) || (paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) || (obb.a(paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).mShowAdButton)) {
          break;
        }
      } while ((VideoFeedsRecommendFragment.a(this.a) == null) || (VideoFeedsRecommendFragment.a(this.a).a() == null) || (VideoFeedsRecommendFragment.a(this.a) == null));
      VideoFeedsRecommendFragment.a(this.a).e();
      VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).a());
      return;
    } while ((VideoFeedsRecommendFragment.a(this.a).a(paramryo)) || (VideoFeedsRecommendFragment.a(this.a).c == VideoFeedsRecommendFragment.a(this.a).size() - 1) || ((!VideoFeedsRecommendFragment.g(this.a)) && (NetworkUtil.isMobileNetWork(VideoFeedsRecommendFragment.a(this.a).getApplication().getApplicationContext()))));
    if (VideoFeedsRecommendFragment.a(this.a).a())
    {
      VideoFeedsRecommendFragment.a(this.a, true);
      return;
    }
    if (bool)
    {
      VideoFeedsRecommendFragment.a(this.a).addOnLayoutChangeListener(new rzj(this));
      return;
    }
    VideoFeedsRecommendFragment.a(this.a).a();
  }
  
  public void b(ryo paramryo, boolean paramBoolean) {}
  
  public void c(ryo paramryo)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsAccessibilityHelper.a(VideoFeedsRecommendFragment.a(this.a).i, true);
    }
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsRecommendFragment.a(this.a).b();
    }
  }
  
  public void d(ryo paramryo)
  {
    if ((sfm.a().a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Ryo.jdField_a_of_type_Sdj)) && (bkwm.w(VideoFeedsRecommendFragment.a(this.a))) && (paramryo == VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Ryo))
    {
      int i = VideoFeedsRecommendFragment.a(this.a).c;
      int j = VideoFeedsRecommendFragment.a(this.a).c();
      Object localObject = VideoFeedsRecommendFragment.a(this.a).findViewHolderForLayoutPosition(i + j + 1);
      if ((localObject instanceof rvn))
      {
        localObject = (rvn)localObject;
        if (((rvn)localObject).jdField_a_of_type_Ryo != null) {
          VideoFeedsRecommendFragment.a(this.a).b(((rvn)localObject).jdField_a_of_type_Ryo);
        }
      }
    }
    if ((VideoFeedsRecommendFragment.a(this.a).c == 0) && (paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0)) {
      VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Scs.a(3);
    }
    if ((VideoFeedsRecommendFragment.a(this.a) != null) && (paramryo != null) && (VideoFeedsRecommendFragment.a(this.a).size() > 0) && (paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      if (paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c)
      {
        if (paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Trv.a <= 0L) {
          paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Trv.a = VideoFeedsRecommendFragment.a(this.a).a();
        }
        VideoFeedsRecommendFragment.a(this.a).f();
      }
    }
    else {
      return;
    }
    VideoFeedsRecommendFragment.a(this.a).a();
    paramryo = paramryo.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;
    if ((paramryo != null) && (paramryo.equalsIgnoreCase(((VideoInfo)VideoFeedsRecommendFragment.a(this.a).get(0)).jdField_a_of_type_JavaLangString)))
    {
      VideoFeedsRecommendFragment.a(this.a).b(0);
      return;
    }
    VideoFeedsRecommendFragment.a(this.a).b(VideoFeedsRecommendFragment.a(this.a).c + 1);
  }
  
  public void e(ryo paramryo) {}
  
  public void f(ryo paramryo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rzi
 * JD-Core Version:    0.7.0.1
 */