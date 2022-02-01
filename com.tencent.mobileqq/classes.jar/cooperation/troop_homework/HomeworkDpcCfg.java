package cooperation.troop_homework;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class HomeworkDpcCfg
{
  private static HomeworkDpcCfg jdField_a_of_type_CooperationTroop_homeworkHomeworkDpcCfg;
  private static final String jdField_a_of_type_JavaLangString = DPCNames.homeworkCfg.name();
  private int jdField_a_of_type_Int = 22;
  private DPCObserver jdField_a_of_type_ComTencentMobileqqDpcDPCObserver = new HomeworkDpcCfg.1(this);
  
  private HomeworkDpcCfg()
  {
    ((IDPCApi)QRoute.api(IDPCApi.class)).addObserver(this.jdField_a_of_type_ComTencentMobileqqDpcDPCObserver);
    a();
  }
  
  public static HomeworkDpcCfg a()
  {
    if (jdField_a_of_type_CooperationTroop_homeworkHomeworkDpcCfg == null) {}
    try
    {
      if (jdField_a_of_type_CooperationTroop_homeworkHomeworkDpcCfg == null) {
        jdField_a_of_type_CooperationTroop_homeworkHomeworkDpcCfg = new HomeworkDpcCfg();
      }
      return jdField_a_of_type_CooperationTroop_homeworkHomeworkDpcCfg;
    }
    finally {}
  }
  
  public void a()
  {
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(jdField_a_of_type_JavaLangString);
    String[] arrayOfString;
    if (!TextUtils.isEmpty(str))
    {
      arrayOfString = str.split("\\|");
      if (arrayOfString.length < 1) {}
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Int = Integer.valueOf(arrayOfString[0]).intValue();
        if (QLog.isColorLevel()) {
          QLog.d("HomeworkDpcCfg", 2, String.format("loadConfig, mUseNewApiLevel: %s, dpc=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), str }));
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.d("HomeworkDpcCfg", 1, "loadConfig exception :" + localException.getMessage());
        this.jdField_a_of_type_Int = 22;
        continue;
      }
      this.jdField_a_of_type_Int = 22;
    }
  }
  
  public boolean a()
  {
    QLog.d("HomeworkDpcCfg", 1, String.format("hwUseNewAPI thisVer=%d cfgVer=%d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(this.jdField_a_of_type_Int) }));
    return Build.VERSION.SDK_INT <= this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.troop_homework.HomeworkDpcCfg
 * JD-Core Version:    0.7.0.1
 */