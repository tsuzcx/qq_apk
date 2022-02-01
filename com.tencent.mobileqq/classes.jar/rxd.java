import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;
import mqq.manager.Manager;

public class rxd
  implements Manager
{
  public static int a;
  public static int b;
  TroopMemberApiService jdField_a_of_type_ComTencentBizTroopTroopMemberApiService;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  HashMap<Long, Bundle> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = true;
  HashMap<Long, Bundle> b;
  
  static
  {
    jdField_b_of_type_Int = 1;
  }
  
  public rxd(QQAppInterface paramQQAppInterface)
  {
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(int paramInt) {}
  
  public void a(TroopMemberApiService paramTroopMemberApiService)
  {
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService == null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService = paramTroopMemberApiService;
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    if ((TextUtils.isEmpty(paramString)) || (!zom.b(paramString))) {}
    for (;;)
    {
      rxe localrxe = new rxe(this);
      beyg localbeyg = new beyg();
      localbeyg.jdField_a_of_type_Azrg = new rxf(this);
      beyb localbeyb = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localrxe.addFilter(new Class[] { berh.class });
      localbeyb.a(localrxe);
      localbeyg.i = paramString;
      localbeyg.jdField_a_of_type_Boolean = true;
      localbeyg.jdField_b_of_type_Int = 24;
      localbeyg.jdField_c_of_type_Int = 54;
      localbeyg.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      localbeyg.jdField_c_of_type_JavaLangString = "0";
      localbeyg.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
      localbeyb.a(localbeyg);
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localbeyg.jdField_a_of_type_Long), paramBundle);
      this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(localbeyg.jdField_a_of_type_Long), paramBundle);
      return;
      a(jdField_a_of_type_Int);
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService != null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rxd
 * JD-Core Version:    0.7.0.1
 */