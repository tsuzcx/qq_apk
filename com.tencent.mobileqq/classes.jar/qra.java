import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qra
  implements qju, qtr, qts
{
  private qra(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public List<qjl> a(List<VideoInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((VideoInfo)paramList.next()));
    }
    return localArrayList;
  }
  
  public qrb a(VideoInfo paramVideoInfo)
  {
    qrb localqrb = new qrb(null);
    qrb.a(localqrb, paramVideoInfo);
    localqrb.jdField_b_of_type_Long = 409409L;
    localqrb.jdField_a_of_type_Int = 0;
    localqrb.jdField_a_of_type_JavaLangString = paramVideoInfo.c;
    localqrb.jdField_b_of_type_JavaLangString = paramVideoInfo.jdField_b_of_type_JavaLangString;
    localqrb.c = paramVideoInfo.jdField_a_of_type_JavaLangString;
    localqrb.jdField_a_of_type_Long = paramVideoInfo.jdField_b_of_type_Long;
    return localqrb;
  }
  
  public void a()
  {
    VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Qjr.f(false);
    VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Qtk.a(6);
  }
  
  public void a(qjl paramqjl)
  {
    if ((paramqjl instanceof qrb))
    {
      paramqjl = qrb.a((qrb)paramqjl);
      if (paramqjl != VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Qqo.a) {
        break label54;
      }
      VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Qqo, false);
    }
    label54:
    int i;
    do
    {
      return;
      i = VideoFeedsRecommendFragment.a(this.a).c;
      VideoFeedsRecommendFragment.a(this.a).remove(i);
      VideoFeedsRecommendFragment.a(this.a).add(i, paramqjl);
    } while (!VideoFeedsRecommendFragment.a(this.a).jdField_b_of_type_Boolean);
    VideoFeedsRecommendFragment.a(this.a).notifyItemChanged(i);
  }
  
  public void a(qjl paramqjl1, qjl paramqjl2, int paramInt, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean)
  {
    Object localObject = qrb.a((qrb)VideoFeedsRecommendFragment.a(this.a).a());
    VideoInfo localVideoInfo = VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Qqo.a;
    if (VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Qqo.a != localObject)
    {
      VideoFeedsRecommendFragment.a(this.a).add(VideoFeedsRecommendFragment.a(this.a).c, localObject);
      VideoFeedsRecommendFragment.a(this.a).notifyItemInserted(VideoFeedsRecommendFragment.a(this.a).c);
      if (!VideoFeedsRecommendFragment.a(this.a).jdField_b_of_type_Boolean) {
        break label231;
      }
      localObject = VideoFeedsRecommendFragment.a(this.a);
    }
    label231:
    for (((qms)localObject).jdField_b_of_type_Int += 1;; VideoFeedsRecommendFragment.a(this.a).jdField_b_of_type_Int = 0)
    {
      localObject = VideoFeedsRecommendFragment.a(this.a);
      ((qms)localObject).c += 1;
      VideoFeedsRecommendFragment.a(this.a).scrollToPosition(VideoFeedsRecommendFragment.a(this.a).c);
      if (paramBoolean) {
        VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Qqo, false);
      }
      noo.a(null, "", "0X8009505", "0X8009505", 0, 0, "", "0", "", new qze(null, null, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.g).a(409409).a().a(), false);
      return;
    }
  }
  
  public void j()
  {
    VideoFeedsRecommendFragment.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qra
 * JD-Core Version:    0.7.0.1
 */