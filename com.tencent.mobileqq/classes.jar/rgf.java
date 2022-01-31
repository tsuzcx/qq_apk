import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rgf
  implements qyy, rjd, rje
{
  private rgf(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public List<qyp> a(List<VideoInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoInfo localVideoInfo = (VideoInfo)paramList.next();
      localArrayList.add(a(localVideoInfo));
      if (VideoFeedsRecommendFragment.a(this.a) != null) {
        VideoFeedsRecommendFragment.a(this.a).b(localVideoInfo);
      }
    }
    return localArrayList;
  }
  
  public rgg a(VideoInfo paramVideoInfo)
  {
    rgg localrgg = new rgg(null);
    rgg.a(localrgg, paramVideoInfo);
    localrgg.jdField_b_of_type_Long = 409409L;
    localrgg.jdField_a_of_type_Int = 0;
    localrgg.jdField_a_of_type_JavaLangString = paramVideoInfo.c;
    localrgg.jdField_b_of_type_JavaLangString = paramVideoInfo.jdField_b_of_type_JavaLangString;
    localrgg.c = paramVideoInfo.jdField_a_of_type_JavaLangString;
    localrgg.jdField_a_of_type_Long = paramVideoInfo.jdField_b_of_type_Long;
    return localrgg;
  }
  
  public void a()
  {
    VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Qyv.f(false);
    VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Riw.a(6);
  }
  
  public void a(qyp paramqyp)
  {
    if ((paramqyp instanceof rgg))
    {
      paramqyp = rgg.a((rgg)paramqyp);
      if (paramqyp != VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Rfs.a) {
        break label54;
      }
      VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Rfs, false);
    }
    label54:
    int i;
    do
    {
      return;
      i = VideoFeedsRecommendFragment.a(this.a).c;
      VideoFeedsRecommendFragment.a(this.a).remove(i);
      VideoFeedsRecommendFragment.a(this.a).add(i, paramqyp);
    } while (!VideoFeedsRecommendFragment.a(this.a).jdField_b_of_type_Boolean);
    VideoFeedsRecommendFragment.a(this.a).notifyItemChanged(i);
  }
  
  public void a(qyp paramqyp1, qyp paramqyp2, int paramInt, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean)
  {
    Object localObject = rgg.a((rgg)VideoFeedsRecommendFragment.a(this.a).a());
    VideoInfo localVideoInfo = VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Rfs.a;
    if (VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Rfs.a != localObject)
    {
      VideoFeedsRecommendFragment.a(this.a).add(VideoFeedsRecommendFragment.a(this.a).c, localObject);
      VideoFeedsRecommendFragment.a(this.a).notifyItemInserted(VideoFeedsRecommendFragment.a(this.a).c);
      if (!VideoFeedsRecommendFragment.a(this.a).jdField_b_of_type_Boolean) {
        break label231;
      }
      localObject = VideoFeedsRecommendFragment.a(this.a);
    }
    label231:
    for (((rbt)localObject).jdField_b_of_type_Int += 1;; VideoFeedsRecommendFragment.a(this.a).jdField_b_of_type_Int = 0)
    {
      localObject = VideoFeedsRecommendFragment.a(this.a);
      ((rbt)localObject).c += 1;
      VideoFeedsRecommendFragment.a(this.a).scrollToPosition(VideoFeedsRecommendFragment.a(this.a).c);
      if (paramBoolean) {
        VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Rfs, false);
      }
      nrt.a(null, "", "0X8009505", "0X8009505", 0, 0, "", "0", "", new ron(null, null, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.g).a(409409).a().a(), false);
      return;
    }
  }
  
  public void j()
  {
    VideoFeedsRecommendFragment.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rgf
 * JD-Core Version:    0.7.0.1
 */