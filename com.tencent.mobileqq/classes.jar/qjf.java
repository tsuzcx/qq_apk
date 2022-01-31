import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;
import mqq.manager.Manager;

public class qjf
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
  
  public qjf(QQAppInterface paramQQAppInterface)
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
    if ((TextUtils.isEmpty(paramString)) || (!vlm.b(paramString))) {}
    for (;;)
    {
      qjg localqjg = new qjg(this);
      axvt localaxvt = new axvt();
      localaxvt.jdField_a_of_type_Atqq = new qjh(this);
      axvo localaxvo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localqjg.addFilter(new Class[] { axom.class });
      localaxvo.a(localqjg);
      localaxvt.i = paramString;
      localaxvt.jdField_a_of_type_Boolean = true;
      localaxvt.jdField_b_of_type_Int = 24;
      localaxvt.jdField_c_of_type_Int = 54;
      localaxvt.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      localaxvt.jdField_c_of_type_JavaLangString = "0";
      localaxvt.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
      localaxvo.a(localaxvt);
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localaxvt.jdField_a_of_type_Long), paramBundle);
      this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(localaxvt.jdField_a_of_type_Long), paramBundle);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qjf
 * JD-Core Version:    0.7.0.1
 */