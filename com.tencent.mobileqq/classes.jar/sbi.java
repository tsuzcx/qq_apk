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

public class sbi
  implements sat
{
  private sbi(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public void a(sar paramsar) {}
  
  public void a(sar paramsar, int paramInt) {}
  
  public void a(sar paramsar, int paramInt1, int paramInt2, String paramString)
  {
    if ((VideoFeedsRecommendFragment.a(this.a) != null) && (!paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c)) {
      VideoFeedsRecommendFragment.a(this.a).d();
    }
  }
  
  public void a(sar paramsar, boolean paramBoolean)
  {
    if ((VideoFeedsRecommendFragment.a(this.a) != null) && (!paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c)) {
      VideoFeedsRecommendFragment.a(this.a).d();
    }
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsRecommendFragment.a(this.a).b();
    }
  }
  
  public void b(sar paramsar)
  {
    if ((she.a().a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Sar.jdField_a_of_type_Sfb)) && (bmqa.v(VideoFeedsRecommendFragment.a(this.a))) && (paramsar == VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Sar))
    {
      int i = VideoFeedsRecommendFragment.a(this.a).c;
      int j = VideoFeedsRecommendFragment.a(this.a).c();
      Object localObject = VideoFeedsRecommendFragment.a(this.a).findViewHolderForLayoutPosition(i + j + 1);
      if ((localObject instanceof rxq))
      {
        localObject = (rxq)localObject;
        if (((rxq)localObject).jdField_a_of_type_Sar != null) {
          VideoFeedsRecommendFragment.a(this.a).b(((rxq)localObject).jdField_a_of_type_Sar);
        }
      }
    }
    if ((VideoFeedsRecommendFragment.a(this.a).c == 0) && (paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0)) {
      VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Sek.a(3);
    }
    if ((VideoFeedsRecommendFragment.a(this.a) != null) && (!paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c)) {
      VideoFeedsRecommendFragment.a(this.a).a(paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, VideoFeedsRecommendFragment.a(this.a).b());
    }
    if ((VideoFeedsRecommendFragment.a(this.a) != null) && (paramsar != null) && (VideoFeedsRecommendFragment.a(this.a).size() > 0) && (paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      if (paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c)
      {
        if (paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Omx.a <= 0L) {
          paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Omx.a = VideoFeedsRecommendFragment.a(this.a).a();
        }
        VideoFeedsRecommendFragment.a(this.a).f();
      }
    }
    else {
      return;
    }
    VideoFeedsRecommendFragment.a(this.a).a();
    paramsar = paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;
    if ((paramsar != null) && (paramsar.equalsIgnoreCase(((VideoInfo)VideoFeedsRecommendFragment.a(this.a).get(0)).jdField_a_of_type_JavaLangString)))
    {
      VideoFeedsRecommendFragment.a(this.a).b(0);
      return;
    }
    VideoFeedsRecommendFragment.a(this.a).b(VideoFeedsRecommendFragment.a(this.a).c + 1);
  }
  
  public void b(sar paramsar, boolean paramBoolean)
  {
    if ((VideoFeedsRecommendFragment.a(this.a) != null) && (!paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) && (paramBoolean)) {
      VideoFeedsRecommendFragment.a(this.a).a(paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, VideoFeedsRecommendFragment.a(this.a).b());
    }
  }
  
  public void c(sar paramsar)
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
          VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Sek.a(5);
          return;
        }
        if (VideoFeedsRecommendFragment.e(this.a))
        {
          if ((VideoFeedsRecommendFragment.a(this.a) != null) && (VideoFeedsRecommendFragment.a(this.a).a() != null))
          {
            VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Sar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo));
            VideoFeedsRecommendFragment.a(this.a).a();
            return;
          }
          VideoFeedsRecommendFragment.a(this.a).b();
        }
        if ((paramsar == null) || (paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) || (nxw.a(paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).mShowAdButton)) {
          break;
        }
      } while ((VideoFeedsRecommendFragment.a(this.a) == null) || (VideoFeedsRecommendFragment.a(this.a).a() == null) || (VideoFeedsRecommendFragment.a(this.a) == null));
      VideoFeedsRecommendFragment.a(this.a).e();
      VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).a());
      return;
    } while ((VideoFeedsRecommendFragment.a(this.a).a(paramsar)) || (VideoFeedsRecommendFragment.a(this.a).c == VideoFeedsRecommendFragment.a(this.a).size() - 1) || ((!VideoFeedsRecommendFragment.g(this.a)) && (bgnt.b(VideoFeedsRecommendFragment.a(this.a).getApplication().getApplicationContext()))));
    if (VideoFeedsRecommendFragment.a(this.a).a())
    {
      VideoFeedsRecommendFragment.a(this.a, true);
      return;
    }
    if (bool)
    {
      VideoFeedsRecommendFragment.a(this.a).addOnLayoutChangeListener(new sbj(this));
      return;
    }
    VideoFeedsRecommendFragment.a(this.a).a();
  }
  
  public void d(sar paramsar)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsAccessibilityHelper.a(VideoFeedsRecommendFragment.a(this.a).i, true);
    }
    if ((VideoFeedsRecommendFragment.a(this.a) != null) && (!paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c)) {
      VideoFeedsRecommendFragment.a(this.a).d();
    }
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsRecommendFragment.a(this.a).b();
    }
  }
  
  public void e(sar paramsar)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsAccessibilityHelper.a(VideoFeedsRecommendFragment.a(this.a).i, false);
    }
    if ((VideoFeedsRecommendFragment.a(this.a) != null) && (!paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c)) {
      VideoFeedsRecommendFragment.a(this.a).a(paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g, VideoFeedsRecommendFragment.a(this.a).b());
    }
    if (paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c)
    {
      VideoFeedsRecommendFragment.a(this.a).f();
      return;
    }
    VideoFeedsRecommendFragment.a(this.a).a();
  }
  
  public void f(sar paramsar)
  {
    if ((VideoFeedsRecommendFragment.a(this.a) != null) && (!paramsar.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c)) {
      VideoFeedsRecommendFragment.a(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sbi
 * JD-Core Version:    0.7.0.1
 */