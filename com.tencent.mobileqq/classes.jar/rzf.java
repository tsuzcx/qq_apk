import UserGrowth.stSimpleGetFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import java.util.ArrayList;
import mqq.util.WeakReference;

class rzf
  implements rwy
{
  rzf(rzd paramrzd, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(stSimpleGetFeedListRsp paramstSimpleGetFeedListRsp)
  {
    sai.d("WSRecommendFragmentPresenter", "onReadCacheCompleted");
    if ((paramstSimpleGetFeedListRsp != null) && (paramstSimpleGetFeedListRsp.feeds != null) && (paramstSimpleGetFeedListRsp.feeds.size() > 0))
    {
      rzd.a(this.jdField_a_of_type_Rzd, true);
      if (!rzd.a(this.jdField_a_of_type_Rzd)) {
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
        } while (rzd.a(this.jdField_a_of_type_Rzd) == null);
        localWSRecommendFragment = (WSRecommendFragment)rzd.a(this.jdField_a_of_type_Rzd).get();
      } while (localWSRecommendFragment == null);
      localWSRecommendFragment.a(paramstSimpleGetFeedListRsp, this.jdField_a_of_type_Boolean, this.b);
    } while ((this.jdField_a_of_type_Boolean) || (rzd.a(this.jdField_a_of_type_Rzd)));
    sai.d("WSRecommendFragmentPresenter", "showTopLoading");
    localWSRecommendFragment.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rzf
 * JD-Core Version:    0.7.0.1
 */