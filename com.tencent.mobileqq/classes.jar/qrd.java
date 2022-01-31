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

public class qrd
  implements qqn
{
  private qrd(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public void a(qql paramqql) {}
  
  public void a(qql paramqql, int paramInt) {}
  
  public void a(qql paramqql, int paramInt1, int paramInt2, String paramString) {}
  
  public void a(qql paramqql, boolean paramBoolean) {}
  
  public void b(qql paramqql)
  {
    if ((bbfj.h(this.a.getActivity())) && (bhvy.t(VideoFeedsRecommendFragment.a(this.a))))
    {
      int i = VideoFeedsRecommendFragment.a(this.a).c;
      int j = VideoFeedsRecommendFragment.a(this.a).c();
      Object localObject = VideoFeedsRecommendFragment.a(this.a).findViewHolderForLayoutPosition(i + j + 1);
      if ((localObject instanceof qmf))
      {
        localObject = (qmf)localObject;
        if (((qmf)localObject).jdField_a_of_type_Qql != null) {
          VideoFeedsRecommendFragment.a(this.a).b(((qmf)localObject).jdField_a_of_type_Qql);
        }
      }
    }
    if ((VideoFeedsRecommendFragment.a(this.a).c == 0) && (paramqql.a.jdField_a_of_type_Int == 0)) {
      VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Qth.a(3);
    }
    if (VideoFeedsRecommendFragment.h(this.a))
    {
      VideoFeedsRecommendFragment.e(this.a, false);
      qnl.a().h();
    }
  }
  
  public void c(qql paramqql)
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
          VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Qth.a(5);
          return;
        }
        if (VideoFeedsRecommendFragment.e(this.a))
        {
          if ((VideoFeedsRecommendFragment.a(this.a) != null) && (VideoFeedsRecommendFragment.a(this.a).a() != null))
          {
            VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Qql.a));
            VideoFeedsRecommendFragment.a(this.a).a();
            return;
          }
          VideoFeedsRecommendFragment.a(this.a).b();
        }
        if ((paramqql == null) || (paramqql.a == null) || (!paramqql.a.c) || (nmc.a(paramqql.a.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo).mShowAdButton)) {
          break;
        }
      } while ((VideoFeedsRecommendFragment.a(this.a) == null) || (VideoFeedsRecommendFragment.a(this.a).a() == null) || (VideoFeedsRecommendFragment.a(this.a) == null));
      VideoFeedsRecommendFragment.a(this.a).e();
      VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).a());
      return;
    } while ((VideoFeedsRecommendFragment.a(this.a).a(paramqql)) || (VideoFeedsRecommendFragment.a(this.a).c == VideoFeedsRecommendFragment.a(this.a).size() - 1) || ((!VideoFeedsRecommendFragment.g(this.a)) && (bbfj.b(VideoFeedsRecommendFragment.a(this.a).getApplication().getApplicationContext()))));
    if (VideoFeedsRecommendFragment.a(this.a).a())
    {
      VideoFeedsRecommendFragment.a(this.a, true);
      return;
    }
    if (bool)
    {
      VideoFeedsRecommendFragment.a(this.a).addOnLayoutChangeListener(new qre(this));
      return;
    }
    VideoFeedsRecommendFragment.a(this.a).a();
  }
  
  public void d(qql paramqql)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsAccessibilityHelper.a(VideoFeedsRecommendFragment.a(this.a).g, true);
    }
  }
  
  public void e(qql paramqql)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsAccessibilityHelper.a(VideoFeedsRecommendFragment.a(this.a).g, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qrd
 * JD-Core Version:    0.7.0.1
 */