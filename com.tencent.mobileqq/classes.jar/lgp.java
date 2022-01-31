import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class lgp
  implements Runnable
{
  public lgp(ReadInJoyDeliverBiuActivity paramReadInJoyDeliverBiuActivity, ArrayList paramArrayList) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyBiuReadInJoyDeliverBiuActivity.app.getCurrentAccountUin();
    localObject = BaseApplicationImpl.getContext().getSharedPreferences("sp_public_account_with_cuin_" + (String)localObject, 4);
    if (localObject != null)
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        localHashSet.add(String.valueOf((Long)localIterator.next()));
      }
      ((SharedPreferences)localObject).edit().putStringSet("readinjoy_deliver_biu_guide_uin", localHashSet);
      ((SharedPreferences)localObject).edit().commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lgp
 * JD-Core Version:    0.7.0.1
 */