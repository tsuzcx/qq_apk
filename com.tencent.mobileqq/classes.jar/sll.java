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

public class sll
  implements sks
{
  private sll(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public void a(skq paramskq)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsAccessibilityHelper.a(VideoFeedsRecommendFragment.a(this.a).g, false);
    }
    if (paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c)
    {
      VideoFeedsRecommendFragment.a(this.a).f();
      return;
    }
    VideoFeedsRecommendFragment.a(this.a).a();
  }
  
  public void a(skq paramskq, int paramInt) {}
  
  public void a(skq paramskq, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(skq paramskq, boolean paramBoolean)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsRecommendFragment.a(this.a).b();
    }
  }
  
  public void b(skq paramskq)
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
        bool = VideoFeedsRecommendFragment.d(this.a);
        if (VideoFeedsRecommendFragment.a(this.a))
        {
          if (bool)
          {
            VideoFeedsRecommendFragment.a(this.a).b();
            return;
          }
          VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Sow.a(5);
          return;
        }
        if (VideoFeedsRecommendFragment.d(this.a))
        {
          if ((VideoFeedsRecommendFragment.a(this.a) != null) && (VideoFeedsRecommendFragment.a(this.a).a() != null))
          {
            VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Skq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo));
            VideoFeedsRecommendFragment.a(this.a).a();
            return;
          }
          VideoFeedsRecommendFragment.a(this.a).b();
        }
        if ((paramskq == null) || (paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (!paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) || (ois.a(paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).mShowAdButton)) {
          break;
        }
      } while ((VideoFeedsRecommendFragment.a(this.a) == null) || (VideoFeedsRecommendFragment.a(this.a).a() == null) || (VideoFeedsRecommendFragment.a(this.a) == null));
      VideoFeedsRecommendFragment.a(this.a).e();
      VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).a());
      return;
    } while ((VideoFeedsRecommendFragment.a(this.a).a(paramskq)) || (VideoFeedsRecommendFragment.a(this.a).c == VideoFeedsRecommendFragment.a(this.a).size() - 1) || ((!VideoFeedsRecommendFragment.f(this.a)) && (NetworkUtil.isMobileNetWork(VideoFeedsRecommendFragment.a(this.a).getApplication().getApplicationContext()))));
    if (VideoFeedsRecommendFragment.a(this.a).b())
    {
      VideoFeedsRecommendFragment.a(this.a, true);
      return;
    }
    if (bool)
    {
      VideoFeedsRecommendFragment.a(this.a).addOnLayoutChangeListener(new slm(this));
      return;
    }
    VideoFeedsRecommendFragment.a(this.a).a();
  }
  
  public void b(skq paramskq, boolean paramBoolean) {}
  
  public void c(skq paramskq)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsAccessibilityHelper.a(VideoFeedsRecommendFragment.a(this.a).g, true);
    }
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsRecommendFragment.a(this.a).b();
    }
  }
  
  public void d(skq paramskq)
  {
    Object localObject;
    if ((srr.a().a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Skq.jdField_a_of_type_Spn)) && (bmhv.w(VideoFeedsRecommendFragment.a(this.a))) && (paramskq == VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Skq))
    {
      int i = VideoFeedsRecommendFragment.a(this.a).c;
      int j = VideoFeedsRecommendFragment.a(this.a).c();
      localObject = VideoFeedsRecommendFragment.a(this.a).findViewHolderForLayoutPosition(i + j + 1);
      if ((localObject instanceof swm))
      {
        localObject = (swm)localObject;
        if (((swm)localObject).jdField_a_of_type_Skq != null) {
          VideoFeedsRecommendFragment.a(this.a).b(((swm)localObject).jdField_a_of_type_Skq);
        }
      }
    }
    if ((VideoFeedsRecommendFragment.a(this.a).c == 0) && (paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Int == 0)) {
      VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Sow.a(3);
    }
    if ((VideoFeedsRecommendFragment.a(this.a) != null) && (paramskq != null) && (VideoFeedsRecommendFragment.a(this.a).size() > 0) && (paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null))
    {
      if (!paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.c) {
        break label287;
      }
      if (paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Ugg.a <= 0L) {
        paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_Ugg.a = VideoFeedsRecommendFragment.a(this.a).a();
      }
      VideoFeedsRecommendFragment.a(this.a).f();
    }
    for (;;)
    {
      if ((VideoFeedsRecommendFragment.a(this.a) != null) && (paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)) {
        VideoFeedsRecommendFragment.a(this.a).a(paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString);
      }
      return;
      label287:
      VideoFeedsRecommendFragment.a(this.a).a();
      localObject = paramskq.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.jdField_a_of_type_JavaLangString;
      if ((localObject != null) && (((String)localObject).equalsIgnoreCase(((VideoInfo)VideoFeedsRecommendFragment.a(this.a).get(0)).jdField_a_of_type_JavaLangString))) {
        VideoFeedsRecommendFragment.a(this.a).b(0);
      } else {
        VideoFeedsRecommendFragment.a(this.a).b(VideoFeedsRecommendFragment.a(this.a).c + 1);
      }
    }
  }
  
  public void e(skq paramskq) {}
  
  public void f(skq paramskq) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sll
 * JD-Core Version:    0.7.0.1
 */