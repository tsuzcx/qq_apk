import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rry
  implements rlq, rvv, rvw
{
  private rry(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public List<rld> a(List<VideoInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((VideoInfo)paramList.next()));
    }
    return localArrayList;
  }
  
  public rrz a(VideoInfo paramVideoInfo)
  {
    rrz localrrz = new rrz(null);
    rrz.a(localrrz, paramVideoInfo);
    localrrz.jdField_b_of_type_Long = 409409L;
    localrrz.jdField_a_of_type_Int = 0;
    localrrz.jdField_a_of_type_JavaLangString = paramVideoInfo.c;
    localrrz.jdField_b_of_type_JavaLangString = paramVideoInfo.jdField_b_of_type_JavaLangString;
    localrrz.c = paramVideoInfo.jdField_a_of_type_JavaLangString;
    localrrz.jdField_a_of_type_Long = paramVideoInfo.jdField_b_of_type_Long;
    return localrrz;
  }
  
  public void a()
  {
    VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Rln.g(false);
    VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Rvo.a(6);
  }
  
  public void a(rld paramrld)
  {
    if ((paramrld instanceof rrz))
    {
      paramrld = rrz.a((rrz)paramrld);
      if (paramrld != VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Rrm.a) {
        break label64;
      }
      VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Rrm, false);
    }
    for (;;)
    {
      VideoFeedsRecommendFragment.a(this.a).d();
      return;
      label64:
      int i = VideoFeedsRecommendFragment.a(this.a).c;
      VideoFeedsRecommendFragment.a(this.a).remove(i);
      VideoFeedsRecommendFragment.a(this.a).add(i, paramrld);
      VideoFeedsRecommendFragment.a(this.a).notifyItemChanged(i);
    }
  }
  
  public void a(rld paramrld1, rld paramrld2, int paramInt, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean)
  {
    Object localObject = rrz.a((rrz)VideoFeedsRecommendFragment.a(this.a).a());
    VideoInfo localVideoInfo = VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Rrm.a;
    if (VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Rrm.a != localObject)
    {
      VideoFeedsRecommendFragment.a(this.a).add(VideoFeedsRecommendFragment.a(this.a).c, localObject);
      VideoFeedsRecommendFragment.a(this.a).notifyItemInserted(VideoFeedsRecommendFragment.a(this.a).c);
      localObject = VideoFeedsRecommendFragment.a(this.a);
      ((rot)localObject).b += 1;
      localObject = VideoFeedsRecommendFragment.a(this.a);
      ((rot)localObject).c += 1;
      VideoFeedsRecommendFragment.a(this.a).scrollToPosition(VideoFeedsRecommendFragment.a(this.a).c);
    }
    if (paramBoolean) {
      VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Rrm, false);
    }
    ocd.a(null, "", "0X8009505", "0X8009505", 0, 0, "", "0", "", new sbg(null, null, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.g).a(409409).a().a(), false);
  }
  
  public void j()
  {
    VideoFeedsRecommendFragment.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rry
 * JD-Core Version:    0.7.0.1
 */