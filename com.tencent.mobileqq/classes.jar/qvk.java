import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;
import mqq.manager.Manager;

public class qvk
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
  
  public qvk(QQAppInterface paramQQAppInterface)
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
    if ((TextUtils.isEmpty(paramString)) || (!vyi.b(paramString))) {}
    for (;;)
    {
      qvl localqvl = new qvl(this);
      aywa localaywa = new aywa();
      localaywa.jdField_a_of_type_Auoo = new qvm(this);
      ayvv localayvv = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      localqvl.addFilter(new Class[] { ayos.class });
      localayvv.a(localqvl);
      localaywa.i = paramString;
      localaywa.jdField_a_of_type_Boolean = true;
      localaywa.jdField_b_of_type_Int = 24;
      localaywa.jdField_c_of_type_Int = 54;
      localaywa.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      localaywa.jdField_c_of_type_JavaLangString = "0";
      localaywa.jdField_a_of_type_Long = (System.currentTimeMillis() + (Math.random() * 10000.0D));
      localayvv.a(localaywa);
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(localaywa.jdField_a_of_type_Long), paramBundle);
      this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(localaywa.jdField_a_of_type_Long), paramBundle);
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
 * Qualified Name:     qvk
 * JD-Core Version:    0.7.0.1
 */