import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.VideoData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastVideoViewCreator.VideoViewHolder.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class qzc
  implements ocf
{
  qzc(qzb paramqzb, VideoData paramVideoData) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString2)) && (TextUtils.equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataVideoData.jdField_b_of_type_JavaLangString, paramString1)))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataVideoData.jdField_a_of_type_JavaLangString = paramString2;
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataVideoData.jdField_a_of_type_Int = paramInt1;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataVideoData.jdField_b_of_type_Int = paramInt2;
      }
      ThreadManager.getUIHandler().post(new WebFastVideoViewCreator.VideoViewHolder.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qzc
 * JD-Core Version:    0.7.0.1
 */