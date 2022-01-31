import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class lgq
  implements Runnable
{
  public lgq(ReadInJoyDeliverBiuActivity paramReadInJoyDeliverBiuActivity, String paramString) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuReadInJoyDeliverBiuActivity.app.getCurrentAccountUin();
    localObject = BaseApplicationImpl.getContext().getSharedPreferences("sp_public_account_with_cuin_" + (String)localObject, 4);
    if (localObject != null)
    {
      ((SharedPreferences)localObject).edit().putString("readinjoy_deliver_biu_guide_time", this.jdField_a_of_type_JavaLangString);
      ((SharedPreferences)localObject).edit().commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lgq
 * JD-Core Version:    0.7.0.1
 */