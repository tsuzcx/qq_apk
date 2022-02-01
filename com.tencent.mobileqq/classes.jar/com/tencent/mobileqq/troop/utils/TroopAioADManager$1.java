package com.tencent.mobileqq.troop.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.data.TroopAioTopADInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.inner.cmdGroupAdGetAdInfo.GetTroopAioTopAD.AdInfo;
import tencent.im.oidb.inner.cmdGroupAdGetAdInfo.GetTroopAioTopAD.ExtAdInfo;
import tencent.im.oidb.inner.cmdGroupAdGetAdInfo.GetTroopAioTopAD.RspBody;

class TroopAioADManager$1
  extends ProtoUtils.TroopProtocolObserver
{
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopAioADManager", 2, "GroupAd.GetAdInfo | oidb_sso errorCode " + paramInt);
    }
    if (paramInt == 0) {
      paramBundle = new GetTroopAioTopAD.RspBody();
    }
    for (;;)
    {
      try
      {
        paramArrayOfByte = (GetTroopAioTopAD.RspBody)paramBundle.mergeFrom(paramArrayOfByte);
        if (paramArrayOfByte == null) {}
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        try
        {
          if (!paramArrayOfByte.uint32_res.has()) {
            break label689;
          }
          int i = paramArrayOfByte.uint32_res.get();
          paramInt = i;
          if (QLog.isColorLevel())
          {
            QLog.d("TroopAioADManager", 2, "GroupAd.GetAdInfo | RspBody.uint32_res " + i);
            paramInt = i;
          }
          if (paramInt == 0)
          {
            if (paramArrayOfByte.uint32_time_interval.has())
            {
              long l2 = paramArrayOfByte.uint32_time_interval.get();
              long l1 = l2;
              if (1000L * l2 > System.currentTimeMillis() + 86400000L) {
                l1 = System.currentTimeMillis() / 1000L + 86400L;
              }
              this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAioADManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("TROOP_AIO_AD_MANAGER_CONFIG" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAioADManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putLong(this.jdField_a_of_type_JavaLangString, l1);
              if (QLog.isColorLevel()) {
                QLog.d("TroopAioADManager", 2, "GroupAd.GetAdInfo | RspBody.uint32_time_interval " + l1);
              }
            }
            if (paramArrayOfByte.rpt_ad_info.has())
            {
              paramArrayOfByte = paramArrayOfByte.rpt_ad_info.get();
              if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
              {
                paramArrayOfByte = (GetTroopAioTopAD.AdInfo)paramArrayOfByte.get(0);
                paramBundle = new TroopAioTopADInfo();
                paramBundle.troopUin = this.jdField_a_of_type_JavaLangString;
                paramBundle.adId = paramArrayOfByte.uint32_ad_id.get();
                paramBundle.backgroundUrl = paramArrayOfByte.str_background_url.get();
                paramBundle.moreUrl = paramArrayOfByte.str_more_url.get();
                paramBundle.picUrl = paramArrayOfByte.str_pic_url.get();
                paramBundle.validTime = paramArrayOfByte.uint32_valid_interval.get();
                paramBundle.showType = paramArrayOfByte.ad_show_type.get();
                if (!paramArrayOfByte.msg_ext_adinfo.has()) {
                  continue;
                }
                paramBundle.strWord = paramArrayOfByte.msg_ext_adinfo.str_word.get();
                paramBundle.uiUrl = paramArrayOfByte.msg_ext_adinfo.str_ui_url.get();
                paramBundle.jumpUrl = paramArrayOfByte.msg_ext_adinfo.str_jmp_url.get();
                if ((QQStoryManager.i()) || (TextUtils.isEmpty(paramBundle.jumpUrl)) || (!paramBundle.jumpUrl.contains("qstory"))) {
                  continue;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("TroopAioADManager", 2, "GroupAd.GetAdInfo当前系统api：" + Build.VERSION.SDK_INT + ",低于14 | adInfo: " + paramBundle.toString());
                }
              }
            }
          }
          return;
        }
        catch (Exception paramArrayOfByte)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("TroopAioADManager", 2, "GroupAd.GetAdInfo | Exception: " + paramArrayOfByte.toString());
          return;
        }
        localInvalidProtocolBufferMicroException = localInvalidProtocolBufferMicroException;
        paramArrayOfByte = paramBundle;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TroopAioADManager", 2, "GroupAd.GetAdInfo | oidb_sso parseFrom byte: " + localInvalidProtocolBufferMicroException.toString());
        paramArrayOfByte = paramBundle;
        continue;
        if ((System.currentTimeMillis() < paramBundle.validTime * 1000L) && (HttpUtil.isValidUrl(paramBundle.uiUrl)))
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAioADManager.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_a_of_type_JavaLangString, paramBundle);
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAioADManager.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramBundle);
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopAioADManager.a();
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TroopAioADManager", 2, "GroupAd.GetAdInfo | adInfo: " + paramBundle.toString());
        return;
      }
      label689:
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopAioADManager.1
 * JD-Core Version:    0.7.0.1
 */