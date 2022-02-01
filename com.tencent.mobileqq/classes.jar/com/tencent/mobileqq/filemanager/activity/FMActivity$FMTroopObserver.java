package com.tencent.mobileqq.filemanager.activity;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class FMActivity$FMTroopObserver
  extends TroopObserver
{
  boolean jdField_a_of_type_Boolean = false;
  
  FMActivity$FMTroopObserver(FMActivity paramFMActivity) {}
  
  protected void onOIDB0X899_0_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    int i = 0;
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_f_of_type_JavaLangString == null) {
      return;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(150);
      ((StringBuilder)localObject1).append("onOIDB0X899_0_Ret");
      ((StringBuilder)localObject1).append("| isSuccess = ");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append("| troopuin = ");
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append("| nFlag = ");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append("| strErorMsg = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.i("FMActivity<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramInt1 == 2) && (paramBoolean))
    {
      localObject1 = (ITroopInfoService)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a.getRuntimeService(ITroopInfoService.class, "");
      paramString = ((ITroopInfoService)localObject1).findTroopInfo(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_f_of_type_JavaLangString);
      if (paramString == null) {
        return;
      }
      if (StringUtil.a(paramString.troopowneruin)) {
        return;
      }
      paramString.Administrator = "";
      if (paramList == null) {
        paramInt1 = 0;
      } else {
        paramInt1 = paramList.size();
      }
      paramInt2 = 0;
      while (paramInt2 < paramInt1)
      {
        Object localObject2 = (oidb_0x899.memberlist)paramList.get(paramInt2);
        if ((localObject2 != null) && (((oidb_0x899.memberlist)localObject2).uint64_member_uin.has()))
        {
          localObject2 = String.valueOf(((oidb_0x899.memberlist)localObject2).uint64_member_uin.get());
          if ((localObject2 != null) && (!"".equals(((String)localObject2).trim())) && (!paramString.troopowneruin.equals(((String)localObject2).trim())))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramString.Administrator);
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append("|");
            paramString.Administrator = localStringBuilder.toString();
          }
        }
        paramInt2 += 1;
      }
      ((ITroopInfoService)localObject1).saveTroopInfo(paramString);
      if (QLog.isColorLevel()) {
        QLog.i("FMActivity<FileAssistant>", 2, paramString.Administrator);
      }
      paramInt1 = i;
      if ((paramString.troopPrivilegeFlag & 0x2) != 2L) {
        paramInt1 = 1;
      }
      paramList = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a.getCurrentAccountUin();
      if ((!paramString.isTroopAdmin(paramList)) && (!paramString.isTroopOwner(paramList)) && (paramInt1 == 0))
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_f_of_type_JavaLangString;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_f_of_type_Boolean) {
          paramList = "0";
        } else {
          paramList = "1";
        }
        ReportController.b(paramString, "P_CliOper", "Grp_files", "", "power", "nopower_upload", 0, 0, (String)localObject1, paramList, "", "");
        FMActivity.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMActivity.FMTroopObserver
 * JD-Core Version:    0.7.0.1
 */