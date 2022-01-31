import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qqx
  implements qjr, qto, qtp
{
  private qqx(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public List<qji> a(List<VideoInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((VideoInfo)paramList.next()));
    }
    return localArrayList;
  }
  
  public qqy a(VideoInfo paramVideoInfo)
  {
    qqy localqqy = new qqy(null);
    qqy.a(localqqy, paramVideoInfo);
    localqqy.jdField_b_of_type_Long = 409409L;
    localqqy.jdField_a_of_type_Int = 0;
    localqqy.jdField_a_of_type_JavaLangString = paramVideoInfo.c;
    localqqy.jdField_b_of_type_JavaLangString = paramVideoInfo.jdField_b_of_type_JavaLangString;
    localqqy.c = paramVideoInfo.jdField_a_of_type_JavaLangString;
    localqqy.jdField_a_of_type_Long = paramVideoInfo.jdField_b_of_type_Long;
    return localqqy;
  }
  
  public void a()
  {
    VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Qjo.f(false);
    VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Qth.a(6);
  }
  
  public void a(qji paramqji)
  {
    if ((paramqji instanceof qqy))
    {
      paramqji = qqy.a((qqy)paramqji);
      if (paramqji != VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Qql.a) {
        break label54;
      }
      VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Qql, false);
    }
    label54:
    int i;
    do
    {
      return;
      i = VideoFeedsRecommendFragment.a(this.a).c;
      VideoFeedsRecommendFragment.a(this.a).remove(i);
      VideoFeedsRecommendFragment.a(this.a).add(i, paramqji);
    } while (!VideoFeedsRecommendFragment.a(this.a).jdField_b_of_type_Boolean);
    VideoFeedsRecommendFragment.a(this.a).notifyItemChanged(i);
  }
  
  public void a(qji paramqji1, qji paramqji2, int paramInt, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean)
  {
    Object localObject = qqy.a((qqy)VideoFeedsRecommendFragment.a(this.a).a());
    VideoInfo localVideoInfo = VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Qql.a;
    if (VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Qql.a != localObject)
    {
      VideoFeedsRecommendFragment.a(this.a).add(VideoFeedsRecommendFragment.a(this.a).c, localObject);
      VideoFeedsRecommendFragment.a(this.a).notifyItemInserted(VideoFeedsRecommendFragment.a(this.a).c);
      if (!VideoFeedsRecommendFragment.a(this.a).jdField_b_of_type_Boolean) {
        break label231;
      }
      localObject = VideoFeedsRecommendFragment.a(this.a);
    }
    label231:
    for (((qmp)localObject).jdField_b_of_type_Int += 1;; VideoFeedsRecommendFragment.a(this.a).jdField_b_of_type_Int = 0)
    {
      localObject = VideoFeedsRecommendFragment.a(this.a);
      ((qmp)localObject).c += 1;
      VideoFeedsRecommendFragment.a(this.a).scrollToPosition(VideoFeedsRecommendFragment.a(this.a).c);
      if (paramBoolean) {
        VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Qql, false);
      }
      nol.a(null, "", "0X8009505", "0X8009505", 0, 0, "", "0", "", new qzb(null, null, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.g).a(409409).a().a(), false);
      return;
    }
  }
  
  public void j()
  {
    VideoFeedsRecommendFragment.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qqx
 * JD-Core Version:    0.7.0.1
 */