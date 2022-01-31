import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;

public class pcd
{
  private TroopMemberApiService jdField_a_of_type_ComTencentBizTroopTroopMemberApiService;
  private HashMap<String, pce> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public pcd(AppRuntime paramAppRuntime, TroopMemberApiService paramTroopMemberApiService)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService = paramTroopMemberApiService;
  }
  
  public void a()
  {
    QLog.d("ReadInJoySkinHelper", 1, "onDestroy");
    pzf localpzf = (pzf)this.jdField_a_of_type_MqqAppAppRuntime.getManager(261);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      localpzf.b((bbwt)((Map.Entry)localIterator.next()).getValue());
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
    String str = ((pzf)this.jdField_a_of_type_MqqAppAppRuntime.getManager(261)).a();
    if (!pyu.a(str)) {
      str = "";
    }
    for (;;)
    {
      boolean bool = bbkb.u(((AppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getApp().getApplicationContext(), ((AppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getCurrentAccountUin());
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
      QLog.d("readinjoy", 4, "MessengerService receive set skin cmd");
    }
    if ((this.jdField_a_of_type_MqqAppAppRuntime == null) || (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService == null)) {
      return;
    }
    Object localObject1 = (pzf)this.jdField_a_of_type_MqqAppAppRuntime.getManager(261);
    String str1 = paramBundle.getString("skinId");
    long l1 = paramBundle.getLong("skinSeq");
    Object localObject2 = paramBundle.getString("skinName");
    String str2 = paramBundle.getString("skinUrl");
    long l2 = paramBundle.getLong("startTime");
    long l3 = paramBundle.getLong("endTime");
    boolean bool;
    if (paramBundle.getInt("volumeIsOn") == 1)
    {
      bool = true;
      if ((!TextUtils.isEmpty(str1)) && (!str1.equals("null"))) {
        break label208;
      }
      str1 = "";
    }
    label208:
    for (localObject1 = ((pzf)localObject1).a(0, "", l1, (String)localObject2, str2, l2, l3, bool);; localObject1 = ((pzf)localObject1).a(1, str1, l1, (String)localObject2, str2, l2, l3, bool))
    {
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("seq", paramBundle.getInt("seq"));
      ((Bundle)localObject2).putInt("retCode", ((ErrorMessage)localObject1).errorCode);
      ((Bundle)localObject2).putString("skinId", str1);
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService.a(109, (Bundle)localObject2);
      return;
      bool = false;
      break;
    }
  }
  
  public void c(Bundle paramBundle)
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
      localObject = (pzf)this.jdField_a_of_type_MqqAppAppRuntime.getManager(261);
      str1 = paramBundle.getString("skinId");
      long l1 = paramBundle.getLong("skinSeq");
      String str2 = paramBundle.getString("skinName");
      String str3 = paramBundle.getString("skinUrl");
      long l2 = paramBundle.getLong("startTime");
      long l3 = paramBundle.getLong("endTime");
      pce localpce = new pce(this.jdField_a_of_type_MqqAppAppRuntime, str1, paramBundle, this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService);
      this.jdField_a_of_type_JavaUtilHashMap.put(str1, localpce);
      bool = ((pzf)localObject).a(str1, str2, str3, l1, l2, l3, localpce);
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
  
  public void d(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy", 4, "MessengerService receive cancel load skin cmd");
    }
    if ((this.jdField_a_of_type_MqqAppAppRuntime == null) || (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService == null)) {
      return;
    }
    Object localObject = (pzf)this.jdField_a_of_type_MqqAppAppRuntime.getManager(261);
    String str = paramBundle.getString("skinId");
    paramBundle.getString("skinUrl");
    boolean bool = ((pzf)localObject).a(str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pcd
 * JD-Core Version:    0.7.0.1
 */