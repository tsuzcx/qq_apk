import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;

public class qjy
{
  private TroopMemberApiService jdField_a_of_type_ComTencentBizTroopTroopMemberApiService;
  private HashMap<String, qjz> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public qjy(AppRuntime paramAppRuntime, TroopMemberApiService paramTroopMemberApiService)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService = paramTroopMemberApiService;
  }
  
  public void a()
  {
    QLog.d("ReadInJoySkinHelper", 1, "onDestroy");
    rna localrna = (rna)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      localrna.b((bhyn)((Map.Entry)localIterator.next()).getValue());
    }
    this.jdField_a_of_type_MqqAppAppRuntime = null;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService = null;
  }
  
  public void a(Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_MqqAppAppRuntime == null) || (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService == null)) {}
    while (!(this.jdField_a_of_type_MqqAppAppRuntime instanceof AppInterface)) {
      return;
    }
    String str = ((rna)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a();
    if (!rmp.a(str)) {
      str = "";
    }
    for (;;)
    {
      boolean bool = bhhr.t(((AppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getApp().getApplicationContext(), ((AppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getCurrentAccountUin());
      Bundle localBundle = new Bundle();
      localBundle.putInt("seq", paramBundle.getInt("seq"));
      localBundle.putInt("retCode", 0);
      localBundle.putString("skinId", str);
      if (bool) {}
      for (int i = 1;; i = 0)
      {
        localBundle.putInt("volumeIsOn", i);
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(110, localBundle);
        return;
      }
    }
  }
  
  public void b(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "MessengerService receive load skin cmd");
    }
    if ((this.jdField_a_of_type_MqqAppAppRuntime == null) || (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("readinjoy", 4, "mApp == null || mService == null");
      }
    }
    String str1;
    boolean bool;
    do
    {
      return;
      localObject = (rna)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
      str1 = paramBundle.getString("skinId");
      long l1 = paramBundle.getLong("skinSeq");
      String str2 = paramBundle.getString("skinName");
      String str3 = paramBundle.getString("skinUrl");
      long l2 = paramBundle.getLong("startTime");
      long l3 = paramBundle.getLong("endTime");
      qjz localqjz = new qjz(this.jdField_a_of_type_MqqAppAppRuntime, str1, paramBundle, this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService);
      this.jdField_a_of_type_JavaUtilHashMap.put(str1, localqjz);
      bool = ((rna)localObject).a(str1, str2, str3, l1, l2, l3, localqjz);
      if (QLog.isColorLevel()) {
        QLog.d("readinjoy", 4, "downloadResult：" + bool);
      }
    } while (!bool);
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("seq", paramBundle.getInt("seq"));
    ((Bundle)localObject).putInt("retCode", 0);
    ((Bundle)localObject).putInt("rate", 100);
    ((Bundle)localObject).putString("skinId", str1);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(107, (Bundle)localObject);
  }
  
  public void c(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "MessengerService receive cancel load skin cmd");
    }
    if ((this.jdField_a_of_type_MqqAppAppRuntime == null) || (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService == null)) {
      return;
    }
    Object localObject = (rna)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER);
    String str = paramBundle.getString("skinId");
    paramBundle.getString("skinUrl");
    boolean bool = ((rna)localObject).a(str);
    localObject = new Bundle();
    ((Bundle)localObject).putInt("seq", paramBundle.getInt("seq"));
    if (bool) {}
    for (int i = 0;; i = -1)
    {
      ((Bundle)localObject).putInt("retCode", i);
      ((Bundle)localObject).putString("skinId", str);
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(108, (Bundle)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qjy
 * JD-Core Version:    0.7.0.1
 */