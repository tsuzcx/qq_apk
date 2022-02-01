package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.config.extension.BizTroopCustomizedProcessorRegister;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectData;
import com.tencent.mobileqq.troop.unreadmsg.TroopUnreadMsgInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum;

public class TroopOnlinePushHandlerProcessorConfig
{
  private static TroopOnlinePushHandlerProcessorConfig jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopOnlinePushHandlerProcessorConfig;
  private static ArrayList<AbsTroopOnlinePushHandlerProcessor> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private TroopOnlinePushHandlerProcessorConfig()
  {
    a();
  }
  
  public static TroopOnlinePushHandlerProcessorConfig a()
  {
    if (jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopOnlinePushHandlerProcessorConfig == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopOnlinePushHandlerProcessorConfig == null) {
          jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopOnlinePushHandlerProcessorConfig = new TroopOnlinePushHandlerProcessorConfig();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqTroopApiConfigTroopOnlinePushHandlerProcessorConfig;
  }
  
  private static void a()
  {
    if (BizTroopCustomizedProcessorRegister.f != null)
    {
      Iterator localIterator = BizTroopCustomizedProcessorRegister.f.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Class)localIterator.next();
        try
        {
          localObject = (AbsTroopOnlinePushHandlerProcessor)((Class)localObject).newInstance();
          jdField_a_of_type_JavaUtilArrayList.add(localObject);
        }
        catch (Throwable localThrowable)
        {
          QLog.i("TroopRedDotHandlerProcessorConfig", 1, "Init Fail", localThrowable);
        }
      }
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, TroopEnterEffectData paramTroopEnterEffectData)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopOnlinePushHandlerProcessor)localIterator.next()).a(paramAppInterface, paramTroopEnterEffectData);
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, TroopUnreadMsgInfo paramTroopUnreadMsgInfo)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopOnlinePushHandlerProcessor)localIterator.next()).a(paramAppInterface, paramTroopUnreadMsgInfo);
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, TroopUnreadMsgInfo paramTroopUnreadMsgInfo, submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum paramSubCmd0x1UpdateAppUnreadNum, long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopOnlinePushHandlerProcessor)localIterator.next()).a(paramAppInterface, paramTroopUnreadMsgInfo, paramSubCmd0x1UpdateAppUnreadNum, paramArrayOfLong, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void a(AppInterface paramAppInterface, String paramString)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((AbsTroopOnlinePushHandlerProcessor)localIterator.next()).a(paramAppInterface, paramString);
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, String paramString1, String paramString2, TroopInfo paramTroopInfo)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((AbsTroopOnlinePushHandlerProcessor)localIterator.next()).a(paramAppInterface, paramString1, paramString2, paramTroopInfo);
      }
    }
  }
  
  public void a(@NonNull AppInterface paramAppInterface, String paramString1, String paramString2, @NonNull TroopInfo paramTroopInfo, @NonNull ArrayList<String> paramArrayList)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((AbsTroopOnlinePushHandlerProcessor)localIterator.next()).a(paramAppInterface, paramString1, paramString2, paramTroopInfo, paramArrayList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.config.TroopOnlinePushHandlerProcessorConfig
 * JD-Core Version:    0.7.0.1
 */