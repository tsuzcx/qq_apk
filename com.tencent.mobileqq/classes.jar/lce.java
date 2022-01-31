import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SharedPreferencesHandler;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Set;

public class lce
  implements Runnable
{
  public lce(EcShopAssistantManager paramEcShopAssistantManager) {}
  
  public void run()
  {
    synchronized (this.a.b)
    {
      Object[] arrayOfObject = this.a.jdField_a_of_type_JavaUtilSet.toArray();
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        SharedPreferencesHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit(), "ec_shop_assist_new_unread_list", arrayOfObject).commit();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lce
 * JD-Core Version:    0.7.0.1
 */