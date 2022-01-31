import UserGrowth.stSimpleGetFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import java.util.ArrayList;
import mqq.util.WeakReference;

class sly
  implements sjr
{
  sly(slw paramslw, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(stSimpleGetFeedListRsp paramstSimpleGetFeedListRsp)
  {
    snb.d("WSRecommendFragmentPresenter", "onReadCacheCompleted");
    if ((paramstSimpleGetFeedListRsp != null) && (paramstSimpleGetFeedListRsp.feeds != null) && (paramstSimpleGetFeedListRsp.feeds.size() > 0))
    {
      slw.a(this.jdField_a_of_type_Slw, true);
      if (!slw.a(this.jdField_a_of_type_Slw)) {
        break label48;
      }
    }
    label48:
    WSRecommendFragment localWSRecommendFragment;
    do
    {
      do
      {
        do
        {
          return;
          paramstSimpleGetFeedListRsp = paramstSimpleGetFeedListRsp.feeds;
        } while (slw.a(this.jdField_a_of_type_Slw) == null);
        localWSRecommendFragment = (WSRecommendFragment)slw.a(this.jdField_a_of_type_Slw).get();
      } while (localWSRecommendFragment == null);
      localWSRecommendFragment.a(paramstSimpleGetFeedListRsp, this.jdField_a_of_type_Boolean, this.b);
    } while ((this.jdField_a_of_type_Boolean) || (slw.a(this.jdField_a_of_type_Slw)));
    snb.d("WSRecommendFragmentPresenter", "showTopLoading");
    localWSRecommendFragment.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sly
 * JD-Core Version:    0.7.0.1
 */