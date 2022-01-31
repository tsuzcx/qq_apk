import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.app.BaseActivity;

public class mkp
  implements Runnable
{
  public mkp(ReadinjoyTabFrame paramReadinjoyTabFrame, GuideData paramGuideData, String paramString, int paramInt) {}
  
  public void run()
  {
    if (ReadinjoyTabFrame.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame) == null)
    {
      FrameLayout localFrameLayout = (FrameLayout)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame.a().findViewById(2131364934);
      ReadinjoyTabFrame.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame, new ReadInJoySkinGuideView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame.a, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData.id, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, new mkq(this, localFrameLayout), new mkr(this, localFrameLayout)));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame.a() == 0) {
        localFrameLayout.addView(ReadinjoyTabFrame.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame), -1, -1);
      }
    }
    else
    {
      return;
    }
    ReadinjoyTabFrame.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mkp
 * JD-Core Version:    0.7.0.1
 */