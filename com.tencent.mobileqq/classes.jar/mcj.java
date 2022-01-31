import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.utils.ContactUtils;

public class mcj
  extends FriendListObserver
{
  public mcj(VideoFeedsPlayActivity paramVideoFeedsPlayActivity, String paramString) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      VideoFeedsPlayActivity.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayActivity, ContactUtils.b(VideoFeedsPlayActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayActivity), this.jdField_a_of_type_JavaLangString, true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mcj
 * JD-Core Version:    0.7.0.1
 */