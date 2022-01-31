import UserGrowth.stSimpleGetFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import java.util.ArrayList;
import mqq.util.WeakReference;

class smb
  implements sju
{
  smb(slz paramslz, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(stSimpleGetFeedListRsp paramstSimpleGetFeedListRsp)
  {
    sne.d("WSRecommendFragmentPresenter", "onReadCacheCompleted");
    if ((paramstSimpleGetFeedListRsp != null) && (paramstSimpleGetFeedListRsp.feeds != null) && (paramstSimpleGetFeedListRsp.feeds.size() > 0))
    {
      slz.a(this.jdField_a_of_type_Slz, true);
      if (!slz.a(this.jdField_a_of_type_Slz)) {
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
        } while (slz.a(this.jdField_a_of_type_Slz) == null);
        localWSRecommendFragment = (WSRecommendFragment)slz.a(this.jdField_a_of_type_Slz).get();
      } while (localWSRecommendFragment == null);
      localWSRecommendFragment.a(paramstSimpleGetFeedListRsp, this.jdField_a_of_type_Boolean, this.b);
    } while ((this.jdField_a_of_type_Boolean) || (slz.a(this.jdField_a_of_type_Slz)));
    sne.d("WSRecommendFragmentPresenter", "showTopLoading");
    localWSRecommendFragment.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     smb
 * JD-Core Version:    0.7.0.1
 */