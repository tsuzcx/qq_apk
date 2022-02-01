import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class rza
  implements rsq, scz, sda
{
  private rza(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public List<rsd> a(List<VideoInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((VideoInfo)paramList.next()));
    }
    return localArrayList;
  }
  
  public rzb a(VideoInfo paramVideoInfo)
  {
    rzb localrzb = new rzb(null);
    rzb.a(localrzb, paramVideoInfo);
    localrzb.jdField_b_of_type_Long = 409409L;
    localrzb.jdField_a_of_type_Int = 0;
    localrzb.jdField_a_of_type_JavaLangString = paramVideoInfo.c;
    localrzb.jdField_b_of_type_JavaLangString = paramVideoInfo.jdField_b_of_type_JavaLangString;
    localrzb.c = paramVideoInfo.jdField_a_of_type_JavaLangString;
    localrzb.jdField_a_of_type_Long = paramVideoInfo.jdField_b_of_type_Long;
    return localrzb;
  }
  
  public void a()
  {
    VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Rsn.g(false);
    VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Scs.a(6);
  }
  
  public void a(rsd paramrsd)
  {
    rvv localrvv = VideoFeedsRecommendFragment.a(this.a);
    if (((paramrsd instanceof rzb)) && (localrvv != null))
    {
      paramrsd = rzb.a((rzb)paramrsd);
      if (paramrsd != localrvv.jdField_a_of_type_Ryo.a) {
        break label64;
      }
      VideoFeedsRecommendFragment.a(this.a).a(localrvv.jdField_a_of_type_Ryo, false);
    }
    for (;;)
    {
      VideoFeedsRecommendFragment.a(this.a).d();
      return;
      label64:
      int i = localrvv.c;
      VideoFeedsRecommendFragment.a(this.a).remove(i);
      VideoFeedsRecommendFragment.a(this.a).add(i, paramrsd);
      VideoFeedsRecommendFragment.a(this.a).notifyItemChanged(i);
    }
  }
  
  public void a(rsd paramrsd1, rsd paramrsd2, int paramInt, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean)
  {
    Object localObject = rzb.a((rzb)VideoFeedsRecommendFragment.a(this.a).a());
    VideoInfo localVideoInfo = VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Ryo.a;
    if (VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Ryo.a != localObject)
    {
      VideoFeedsRecommendFragment.a(this.a).add(VideoFeedsRecommendFragment.a(this.a).c, localObject);
      VideoFeedsRecommendFragment.a(this.a).notifyItemInserted(VideoFeedsRecommendFragment.a(this.a).c);
      localObject = VideoFeedsRecommendFragment.a(this.a);
      ((rvv)localObject).b += 1;
      localObject = VideoFeedsRecommendFragment.a(this.a);
      ((rvv)localObject).c += 1;
      VideoFeedsRecommendFragment.a(this.a).scrollToPosition(VideoFeedsRecommendFragment.a(this.a).c);
    }
    if (paramBoolean) {
      VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Ryo, false);
    }
    odq.a(null, "", "0X8009505", "0X8009505", 0, 0, "", "0", "", new sie(null, null, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.g).a(409409).a().a(), false);
  }
  
  public void j()
  {
    VideoFeedsRecommendFragment.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rza
 * JD-Core Version:    0.7.0.1
 */