package com.tencent.mobileqq.fts.operator;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import com.tencent.mobileqq.fts.api.IFTSDBRuntimeService;
import com.tencent.mobileqq.fts.data.troop.FTSTroopTime;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopManagerService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

class FTSTroopOperator$1
  implements Runnable
{
  FTSTroopOperator$1(FTSTroopOperator paramFTSTroopOperator) {}
  
  public void run()
  {
    if (!FTSTroopOperator.a(this.this$0))
    {
      FTSTroopOperator.a(this.this$0);
      if (FTSTroopOperator.b(this.this$0) >= 5)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.troop.operator", 2, "checkTroopTimeStamp failed");
        }
      }
      else {
        this.this$0.jdField_a_of_type_ComTencentMobileqqFtsOperatorFTSSyncHandler.postDelayed(this, 5000L);
      }
    }
    else
    {
      this.this$0.b();
      Object localObject = this.this$0.jdField_a_of_type_MqqAppAppRuntime.getEntityManagerFactory().createEntityManager();
      ArrayList localArrayList = FTSTroopOperator.a(this.this$0).getUiTroopList();
      List localList = ((EntityManager)localObject).query(FTSTroopTime.class, FTSTroopTime.class.getSimpleName(), false, null, null, null, null, null, null);
      ((EntityManager)localObject).close();
      FTSTroopOperator.a(this.this$0, localArrayList, localList);
      ((ITroopManagerService)this.this$0.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopManagerService.class, "")).getTroopsMemberList();
      localObject = this.this$0.jdField_a_of_type_MqqAppAppRuntime.getApp().getSharedPreferences(this.this$0.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), 0);
      int i = ((SharedPreferences)localObject).getInt("is_first_upgrade_to_500", 0);
      if (i == 0)
      {
        ((SharedPreferences)localObject).edit().putInt("is_first_upgrade_to_500", 1).commit();
        if (FTSTroopOperator.a(this.this$0) == null) {
          FTSTroopOperator.a(this.this$0, new FTSTroopOperator.1.1(this));
        }
        this.this$0.jdField_a_of_type_ComTencentMobileqqFtsOperatorFTSSyncHandler.postDelayed(FTSTroopOperator.a(this.this$0), 86400000L);
      }
      else
      {
        if (i == 1) {
          ((SharedPreferences)localObject).edit().putInt("is_first_upgrade_to_500", 2).commit();
        }
        if (FTSTroopOperator.a(this.this$0) != null)
        {
          this.this$0.jdField_a_of_type_ComTencentMobileqqFtsOperatorFTSSyncHandler.removeCallbacks(FTSTroopOperator.a(this.this$0));
          FTSTroopOperator.a(this.this$0, null);
        }
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqFtsOperatorFTSSyncHandler.obtainMessage(1, this.this$0).sendToTarget();
      localObject = (IFTSDBRuntimeService)this.this$0.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IFTSDBRuntimeService.class, "");
      this.this$0.jdField_a_of_type_ComTencentMobileqqFtsOperatorFTSSyncHandler.obtainMessage(1, ((IFTSDBRuntimeService)localObject).getOperator(4)).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.operator.FTSTroopOperator.1
 * JD-Core Version:    0.7.0.1
 */