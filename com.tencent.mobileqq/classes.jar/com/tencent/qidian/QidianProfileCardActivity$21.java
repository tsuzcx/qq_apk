package com.tencent.qidian;

import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qidian.data.QidianCorpInfo;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qidian.data.QidianProfileUiInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class QidianProfileCardActivity$21
  extends QidianBusinessObserver
{
  QidianProfileCardActivity$21(QidianProfileCardActivity paramQidianProfileCardActivity) {}
  
  protected void b(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    super.b(paramBoolean, paramHashMap);
    this.a.a();
    if ((paramBoolean) && (paramHashMap != null))
    {
      int j = 0;
      int i = j;
      if (paramHashMap.containsKey("external"))
      {
        i = j;
        if (paramHashMap.get("external") != null)
        {
          QidianExternalInfo localQidianExternalInfo = (QidianExternalInfo)paramHashMap.get("external");
          if (!this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin.equals(localQidianExternalInfo.uin))
          {
            if (QLog.isColorLevel()) {
              QLog.d("QidianProfileCardActivity", 2, "onGetQidianMasterInfo not current uin");
            }
            return;
          }
          i = j;
          if (!localQidianExternalInfo.equals(this.a.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo))
          {
            this.a.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo = localQidianExternalInfo;
            i = 1;
          }
        }
      }
      j = i;
      if (paramHashMap.containsKey("ConfigGroupInfo"))
      {
        j = i;
        if (paramHashMap.get("ConfigGroupInfo") != null)
        {
          paramHashMap = (QidianProfileUiInfo)paramHashMap.get("ConfigGroupInfo");
          j = i;
          if (!paramHashMap.equals(QidianProfileCardActivity.a(this.a)))
          {
            QidianProfileCardActivity.a(this.a, paramHashMap);
            j = 1;
          }
        }
      }
      if (j != 0)
      {
        this.a.c(6);
        this.a.b();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QidianProfileCardActivity", 2, "onGetQidianMasterInfo not change");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("QidianProfileCardActivity", 2, "onGetQidianMasterInfo fail");
    }
  }
  
  protected void d(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    super.d(paramBoolean, paramHashMap);
    this.a.a();
    if ((paramBoolean) && (paramHashMap != null) && (paramHashMap.containsKey("external")) && (paramHashMap.get("external") != null) && (paramHashMap.containsKey("corp")) && (paramHashMap.get("corp") != null) && (paramHashMap.containsKey("ConfigGroupInfo")) && (paramHashMap.get("ConfigGroupInfo") != null))
    {
      QidianExternalInfo localQidianExternalInfo = (QidianExternalInfo)paramHashMap.get("external");
      QidianCorpInfo localQidianCorpInfo = (QidianCorpInfo)paramHashMap.get("corp");
      paramHashMap = (QidianProfileUiInfo)paramHashMap.get("ConfigGroupInfo");
      if (this.a.jdField_a_of_type_ComTencentMobileqqProfilecardDataProfileCardInfo.allInOne.uin.equals(localQidianExternalInfo.uin))
      {
        int i;
        if ((localQidianExternalInfo.equals(this.a.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo)) && (localQidianCorpInfo.equals(QidianProfileCardActivity.a(this.a))) && (paramHashMap.equals(QidianProfileCardActivity.a(this.a)))) {
          i = 0;
        } else {
          i = 1;
        }
        if (i != 0)
        {
          QidianProfileCardActivity localQidianProfileCardActivity = this.a;
          localQidianProfileCardActivity.jdField_a_of_type_ComTencentQidianDataQidianExternalInfo = localQidianExternalInfo;
          QidianProfileCardActivity.a(localQidianProfileCardActivity, localQidianCorpInfo);
          QidianProfileCardActivity.a(this.a, paramHashMap);
          this.a.c(1);
          this.a.b();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QidianProfileCardActivity", 2, "onGetQidianUserDetailInfo not change");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("QidianProfileCardActivity", 2, "onGetQidianUserDetailInfo not current uin");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("QidianProfileCardActivity", 2, "onGetQidianUserDetailInfo fail");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.21
 * JD-Core Version:    0.7.0.1
 */