package com.tencent.mobileqq.fts.operator;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fts.FTSConstants;
import com.tencent.mobileqq.fts.data.troop.FTSTroopSync;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class FTSTroopUpgrader
  implements FTSConstants, FTSUpgrader
{
  FTSSyncHandler jdField_a_of_type_ComTencentMobileqqFtsOperatorFTSSyncHandler;
  FTSTroopOperator jdField_a_of_type_ComTencentMobileqqFtsOperatorFTSTroopOperator;
  AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  FTSTroopUpgrader(AppRuntime paramAppRuntime, FTSTroopOperator paramFTSTroopOperator)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqFtsOperatorFTSTroopOperator = paramFTSTroopOperator;
    this.jdField_a_of_type_ComTencentMobileqqFtsOperatorFTSSyncHandler = this.jdField_a_of_type_ComTencentMobileqqFtsOperatorFTSTroopOperator.jdField_a_of_type_ComTencentMobileqqFtsOperatorFTSSyncHandler;
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramAppRuntime.getApplication().getSharedPreferences("fts_sp_file", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fts_troop_upgrade_flag");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean);
    localEditor.commit();
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    SharedPreferences localSharedPreferences = paramAppRuntime.getApplication().getSharedPreferences("fts_sp_file", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fts_troop_upgrade_flag");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  public void a() {}
  
  public boolean a()
  {
    return !a(this.jdField_a_of_type_MqqAppAppRuntime);
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_MqqAppAppRuntime.getEntityManagerFactory().createEntityManager().drop(FTSTroopSync.class.getSimpleName());
    Object localObject = ((ITroopInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopInfoService.class, "")).getUiTroopList();
    ArrayList localArrayList = new ArrayList(((ArrayList)localObject).size());
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopInfo localTroopInfo = (TroopInfo)((Iterator)localObject).next();
      try
      {
        localArrayList.add(new FTSTroopSync(5, Long.parseLong(localTroopInfo.troopuin)));
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startUpgrade exception : ");
        localStringBuilder.append(localException.toString());
        QLog.e("FTSTroopUpgrader", 2, localStringBuilder.toString());
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFtsOperatorFTSTroopOperator.a(localArrayList))
    {
      a(this.jdField_a_of_type_MqqAppAppRuntime, true);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.operator.FTSTroopUpgrader
 * JD-Core Version:    0.7.0.1
 */