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

public class qfi
  implements qes
{
  private qfi(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public void a(qeq paramqeq) {}
  
  public void a(qeq paramqeq, int paramInt) {}
  
  public void a(qeq paramqeq, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(qeq paramqeq, boolean paramBoolean) {}
  
  public void b(qeq paramqeq)
  {
    if ((badq.h(this.a.getActivity())) && (bgmq.s(VideoFeedsRecommendFragment.a(this.a))))
    {
      int i = VideoFeedsRecommendFragment.a(this.a).c;
      int j = VideoFeedsRecommendFragment.a(this.a).c();
      Object localObject = VideoFeedsRecommendFragment.a(this.a).findViewHolderForLayoutPosition(i + j + 1);
      if ((localObject instanceof qag))
      {
        localObject = (qag)localObject;
        if (((qag)localObject).jdField_a_of_type_Qeq != null) {
          VideoFeedsRecommendFragment.a(this.a).b(((qag)localObject).jdField_a_of_type_Qeq);
        }
      }
    }
    if ((VideoFeedsRecommendFragment.a(this.a).c == 0) && (paramqeq.a.jdField_a_of_type_Int == 0)) {
      VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Qhf.a(3);
    }
    if (VideoFeedsRecommendFragment.h(this.a))
    {
      VideoFeedsRecommendFragment.e(this.a, false);
      qbq.a().h();
    }
  }
  
  public void c(qeq paramqeq)
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
          VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Qhf.a(5);
          return;
        }
        if (VideoFeedsRecommendFragment.e(this.a))
        {
          if ((VideoFeedsRecommendFragment.a(this.a) != null) && (VideoFeedsRecommendFragment.a(this.a).a() != null))
          {
            VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Qeq.a));
            VideoFeedsRecommendFragment.a(this.a).a();
            return;
          }
          VideoFeedsRecommendFragment.a(this.a).b();
        }
        if ((paramqeq == null) || (paramqeq.a == null) || (!paramqeq.a.c) || (nbe.a(paramqeq.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).mShowAdButton)) {
          break;
        }
      } while ((VideoFeedsRecommendFragment.a(this.a) == null) || (VideoFeedsRecommendFragment.a(this.a).a() == null) || (VideoFeedsRecommendFragment.a(this.a) == null));
      VideoFeedsRecommendFragment.a(this.a).e();
      VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).a());
      return;
    } while ((VideoFeedsRecommendFragment.a(this.a).a(paramqeq)) || (VideoFeedsRecommendFragment.a(this.a).c == VideoFeedsRecommendFragment.a(this.a).size() - 1) || ((!VideoFeedsRecommendFragment.g(this.a)) && (badq.b(VideoFeedsRecommendFragment.a(this.a).getApplication().getApplicationContext()))));
    if (VideoFeedsRecommendFragment.a(this.a).a())
    {
      VideoFeedsRecommendFragment.a(this.a, true);
      return;
    }
    if (bool)
    {
      VideoFeedsRecommendFragment.a(this.a).addOnLayoutChangeListener(new qfj(this));
      return;
    }
    VideoFeedsRecommendFragment.a(this.a).a();
  }
  
  public void d(qeq paramqeq)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsAccessibilityHelper.a(VideoFeedsRecommendFragment.a(this.a).e, true);
    }
  }
  
  public void e(qeq paramqeq)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsAccessibilityHelper.a(VideoFeedsRecommendFragment.a(this.a).e, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qfi
 * JD-Core Version:    0.7.0.1
 */