import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class sbc
  implements ruu, ser, ses
{
  private sbc(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public List<ruh> a(List<VideoInfo> paramList)
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
  
  public sbd a(VideoInfo paramVideoInfo)
  {
    sbd localsbd = new sbd(null);
    sbd.a(localsbd, paramVideoInfo);
    localsbd.jdField_b_of_type_Long = 409409L;
    localsbd.jdField_a_of_type_Int = 0;
    localsbd.jdField_a_of_type_JavaLangString = paramVideoInfo.c;
    localsbd.jdField_b_of_type_JavaLangString = paramVideoInfo.jdField_b_of_type_JavaLangString;
    localsbd.c = paramVideoInfo.jdField_a_of_type_JavaLangString;
    localsbd.jdField_a_of_type_Long = paramVideoInfo.jdField_b_of_type_Long;
    return localsbd;
  }
  
  public void a()
  {
    VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Rur.g(false);
    VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Sek.a(6);
  }
  
  public void a(ruh paramruh)
  {
    if ((paramruh instanceof sbd))
    {
      paramruh = sbd.a((sbd)paramruh);
      if (paramruh != VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Sar.a) {
        break label64;
      }
      VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Sar, false);
    }
    for (;;)
    {
      VideoFeedsRecommendFragment.a(this.a).d();
      return;
      label64:
      int i = VideoFeedsRecommendFragment.a(this.a).c;
      VideoFeedsRecommendFragment.a(this.a).remove(i);
      VideoFeedsRecommendFragment.a(this.a).add(i, paramruh);
      VideoFeedsRecommendFragment.a(this.a).notifyItemChanged(i);
    }
  }
  
  public void a(ruh paramruh1, ruh paramruh2, int paramInt, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean)
  {
    Object localObject = sbd.a((sbd)VideoFeedsRecommendFragment.a(this.a).a());
    VideoInfo localVideoInfo = VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Sar.a;
    if (VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Sar.a != localObject)
    {
      VideoFeedsRecommendFragment.a(this.a).add(VideoFeedsRecommendFragment.a(this.a).c, localObject);
      VideoFeedsRecommendFragment.a(this.a).notifyItemInserted(VideoFeedsRecommendFragment.a(this.a).c);
      localObject = VideoFeedsRecommendFragment.a(this.a);
      ((rxy)localObject).b += 1;
      localObject = VideoFeedsRecommendFragment.a(this.a);
      ((rxy)localObject).c += 1;
      VideoFeedsRecommendFragment.a(this.a).scrollToPosition(VideoFeedsRecommendFragment.a(this.a).c);
    }
    if (paramBoolean) {
      VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Sar, false);
    }
    oat.a(null, "", "0X8009505", "0X8009505", 0, 0, "", "0", "", new skc(null, null, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.g).a(409409).a().a(), false);
  }
  
  public void j()
  {
    VideoFeedsRecommendFragment.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sbc
 * JD-Core Version:    0.7.0.1
 */