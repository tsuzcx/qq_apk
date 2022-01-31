package com.tencent.mobileqq.lovelanguage;

import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class LoveLanguageHandler
  extends BusinessHandler
{
  public LoveLanguageHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected Class a()
  {
    return null;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    while (!"OidbSvc.0x4ff_9".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x4ff_9");
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        bool3 = bool1;
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramToServiceMsg == null) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        if (!bool1) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        if (!paramToServiceMsg.bytes_bodybuffer.has()) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        if (paramToServiceMsg.bytes_bodybuffer.get() == null) {
          continue;
        }
        bool1 = true;
        bool2 = bool1;
        bool3 = bool1;
        paramToServiceMsg = (CardHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
        bool2 = bool1;
        if (paramToServiceMsg != null)
        {
          bool2 = bool1;
          bool3 = bool1;
          paramToServiceMsg.g();
          bool2 = bool1;
        }
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        bool3 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        bool3 = bool2;
        QLog.d("LoveLanguageHandler", 2, "love language handleSetLoveLanguageMark ex", paramToServiceMsg);
        return;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("LoveLanguageHandler", 2, "love language handleSetLoveLanguageMark result=" + bool3);
      }
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.lovelanguage.LoveLanguageHandler
 * JD-Core Version:    0.7.0.1
 */