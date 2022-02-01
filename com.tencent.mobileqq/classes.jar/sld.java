import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class sld
  implements sff, spd, spe
{
  private sld(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public List<ses> a(List<VideoInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((VideoInfo)paramList.next()));
    }
    return localArrayList;
  }
  
  public sle a(VideoInfo paramVideoInfo)
  {
    sle localsle = new sle(null);
    sle.a(localsle, paramVideoInfo);
    localsle.jdField_b_of_type_Long = 409409L;
    localsle.jdField_a_of_type_Int = 0;
    localsle.jdField_a_of_type_JavaLangString = paramVideoInfo.c;
    localsle.jdField_b_of_type_JavaLangString = paramVideoInfo.jdField_b_of_type_JavaLangString;
    localsle.c = paramVideoInfo.jdField_a_of_type_JavaLangString;
    localsle.jdField_a_of_type_Long = paramVideoInfo.jdField_b_of_type_Long;
    return localsle;
  }
  
  public void a()
  {
    VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Sfc.g(false);
    VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Sow.a(6);
  }
  
  public void a(ses paramses)
  {
    swu localswu = VideoFeedsRecommendFragment.a(this.a);
    if (((paramses instanceof sle)) && (localswu != null))
    {
      paramses = sle.a((sle)paramses);
      if (paramses != localswu.jdField_a_of_type_Skq.a) {
        break label64;
      }
      VideoFeedsRecommendFragment.a(this.a).a(localswu.jdField_a_of_type_Skq, false);
    }
    for (;;)
    {
      VideoFeedsRecommendFragment.a(this.a).d();
      return;
      label64:
      int i = localswu.c;
      VideoFeedsRecommendFragment.a(this.a).remove(i);
      VideoFeedsRecommendFragment.a(this.a).add(i, paramses);
      VideoFeedsRecommendFragment.a(this.a).notifyItemChanged(i);
    }
  }
  
  public void a(ses paramses1, ses paramses2, int paramInt, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean)
  {
    Object localObject = sle.a((sle)VideoFeedsRecommendFragment.a(this.a).a());
    VideoInfo localVideoInfo = VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Skq.a;
    if (VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Skq.a != localObject)
    {
      VideoFeedsRecommendFragment.a(this.a).add(VideoFeedsRecommendFragment.a(this.a).c, localObject);
      VideoFeedsRecommendFragment.a(this.a).notifyItemInserted(VideoFeedsRecommendFragment.a(this.a).c);
      localObject = VideoFeedsRecommendFragment.a(this.a);
      ((swu)localObject).b += 1;
      localObject = VideoFeedsRecommendFragment.a(this.a);
      ((swu)localObject).c += 1;
      VideoFeedsRecommendFragment.a(this.a).scrollToPosition(VideoFeedsRecommendFragment.a(this.a).c);
    }
    if (paramBoolean) {
      VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Skq, false);
    }
    olh.a(null, "", "0X8009505", "0X8009505", 0, 0, "", "0", "", new suu(null, null, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.g).a(409409).a().a(), false);
  }
  
  public void j()
  {
    VideoFeedsRecommendFragment.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sld
 * JD-Core Version:    0.7.0.1
 */