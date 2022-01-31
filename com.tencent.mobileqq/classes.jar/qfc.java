import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qfc
  implements pxv, qhm, qhn
{
  private qfc(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public List<pxn> a(List<VideoInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((VideoInfo)paramList.next()));
    }
    return localArrayList;
  }
  
  public qfd a(VideoInfo paramVideoInfo)
  {
    qfd localqfd = new qfd(null);
    qfd.a(localqfd, paramVideoInfo);
    localqfd.jdField_b_of_type_Long = 409409L;
    localqfd.jdField_a_of_type_Int = 0;
    localqfd.jdField_a_of_type_JavaLangString = paramVideoInfo.c;
    localqfd.jdField_b_of_type_JavaLangString = paramVideoInfo.jdField_b_of_type_JavaLangString;
    localqfd.c = paramVideoInfo.jdField_a_of_type_JavaLangString;
    localqfd.jdField_a_of_type_Long = paramVideoInfo.jdField_b_of_type_Long;
    return localqfd;
  }
  
  public void a()
  {
    VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Pxs.f(false);
    VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Qhf.a(6);
  }
  
  public void a(pxn parampxn)
  {
    if ((parampxn instanceof qfd))
    {
      parampxn = qfd.a((qfd)parampxn);
      if (parampxn != VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Qeq.a) {
        break label54;
      }
      VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Qeq, false);
    }
    label54:
    int i;
    do
    {
      return;
      i = VideoFeedsRecommendFragment.a(this.a).c;
      VideoFeedsRecommendFragment.a(this.a).remove(i);
      VideoFeedsRecommendFragment.a(this.a).add(i, parampxn);
    } while (!VideoFeedsRecommendFragment.a(this.a).jdField_b_of_type_Boolean);
    VideoFeedsRecommendFragment.a(this.a).notifyItemChanged(i);
  }
  
  public void a(pxn parampxn1, pxn parampxn2, int paramInt, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean)
  {
    Object localObject = qfd.a((qfd)VideoFeedsRecommendFragment.a(this.a).a());
    VideoInfo localVideoInfo = VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Qeq.a;
    if (VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Qeq.a != localObject)
    {
      VideoFeedsRecommendFragment.a(this.a).add(VideoFeedsRecommendFragment.a(this.a).c, localObject);
      VideoFeedsRecommendFragment.a(this.a).notifyItemInserted(VideoFeedsRecommendFragment.a(this.a).c);
      if (!VideoFeedsRecommendFragment.a(this.a).jdField_b_of_type_Boolean) {
        break label231;
      }
      localObject = VideoFeedsRecommendFragment.a(this.a);
    }
    label231:
    for (((qaq)localObject).jdField_b_of_type_Int += 1;; VideoFeedsRecommendFragment.a(this.a).jdField_b_of_type_Int = 0)
    {
      localObject = VideoFeedsRecommendFragment.a(this.a);
      ((qaq)localObject).c += 1;
      VideoFeedsRecommendFragment.a(this.a).scrollToPosition(VideoFeedsRecommendFragment.a(this.a).c);
      if (paramBoolean) {
        VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).jdField_a_of_type_Qeq, false);
      }
      ndn.a(null, "", "0X8009505", "0X8009505", 0, 0, "", "0", "", new qmv(null, null, localVideoInfo.jdField_a_of_type_JavaLangString, localVideoInfo.g).a(409409).a().a(), false);
      return;
    }
  }
  
  public void j()
  {
    VideoFeedsRecommendFragment.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qfc
 * JD-Core Version:    0.7.0.1
 */