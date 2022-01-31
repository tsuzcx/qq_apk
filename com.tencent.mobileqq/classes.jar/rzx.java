import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.3.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.viola.core.ViolaEnvironment;

public class rzx
  implements sac
{
  public rzx(ViolaBaseView paramViolaBaseView, boolean paramBoolean, long paramLong) {}
  
  public void a()
  {
    ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView, 5, this.jdField_a_of_type_Boolean);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView)))
    {
      if (!TextUtils.isEmpty(paramString))
      {
        ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView, paramString);
        if (this.jdField_a_of_type_Boolean)
        {
          ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView).addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_END_NET);
          ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView).addReportData(ViolaEnvironment.TIME_MAIN_JS_NET, Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long));
          ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView).sendEmptyMessageDelayed(3, 0L);
        }
        ThreadManager.post(new ViolaBaseView.3.1(this), 8, null, true);
      }
    }
    else {
      return;
    }
    ViolaBaseView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView, 10, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rzx
 * JD-Core Version:    0.7.0.1
 */