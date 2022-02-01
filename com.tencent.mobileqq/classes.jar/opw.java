import android.support.annotation.Nullable;
import com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInJoyArticleBottomVideoView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import java.lang.ref.WeakReference;

public class opw
{
  int jdField_a_of_type_Int;
  AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  WeakReference<ReadInJoyArticleBottomVideoView> jdField_a_of_type_JavaLangRefWeakReference;
  
  opw(AdvertisementInfo paramAdvertisementInfo, int paramInt, ReadInJoyArticleBottomVideoView paramReadInJoyArticleBottomVideoView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramReadInJoyArticleBottomVideoView);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof opw))
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Int == ((opw)paramObject).jdField_a_of_type_Int) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.hashCode() + this.jdField_a_of_type_Int;
    }
    return super.hashCode() + this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     opw
 * JD-Core Version:    0.7.0.1
 */