package com.tencent.mobileqq.webview;

import android.os.Bundle;
import android.util.LruCache;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_0xbcb.CheckUrlRsp;
import tencent.im.oidb.oidb_0xbcb.RspBody;
import tencent.im.oidb.oidb_0xbcb.UrlCheckResult;

class UrlSecurityCheckManager$5
  extends ProtoUtils.TroopProtocolObserver
{
  UrlSecurityCheckManager$5(UrlSecurityCheckManager paramUrlSecurityCheckManager, UrlSecurityCheckManager.OnCheckResult paramOnCheckResult, int paramInt) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("urlSecMgr", 2, "receive 0xbcb_0 code=" + paramInt);
    }
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      if (!QLog.isColorLevel()) {
        break label662;
      }
      if (paramArrayOfByte == null) {
        break label656;
      }
    }
    for (;;)
    {
      Object localObject1;
      try
      {
        paramBundle = ((oidb_0xbcb.RspBody)new oidb_0xbcb.RspBody().mergeFrom(paramArrayOfByte)).wording.get();
        localObject1 = new StringBuilder().append("req error code=").append(paramInt);
        if (paramArrayOfByte == null)
        {
          paramArrayOfByte = ", data=null";
          QLog.i("urlSecMgr", 2, paramArrayOfByte);
          paramArrayOfByte = null;
          if (this.jdField_a_of_type_ComTencentMobileqqWebviewUrlSecurityCheckManager$OnCheckResult != null)
          {
            paramBundle = new Bundle();
            if ((this.jdField_a_of_type_Int == 1) && (paramArrayOfByte != null))
            {
              paramBundle.putInt("result", paramArrayOfByte.jdField_a_of_type_Int);
              paramBundle.putInt("jumpResult", paramArrayOfByte.jdField_b_of_type_Int);
              paramBundle.putString("jumpUrl", paramArrayOfByte.jdField_a_of_type_JavaLangString);
              paramBundle.putInt("level", paramArrayOfByte.c);
              paramBundle.putInt("subLevel", paramArrayOfByte.d);
              paramBundle.putInt("umrType", paramArrayOfByte.e);
              paramBundle.putInt("retFrom", paramArrayOfByte.f);
              paramBundle.putLong("operationBit", paramArrayOfByte.jdField_b_of_type_Long);
            }
            this.jdField_a_of_type_ComTencentMobileqqWebviewUrlSecurityCheckManager$OnCheckResult.a(paramBundle);
          }
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        paramBundle = "";
        continue;
        paramArrayOfByte = ", msg=" + paramBundle;
        continue;
      }
      oidb_0xbcb.RspBody localRspBody = new oidb_0xbcb.RspBody();
      for (;;)
      {
        try
        {
          localRspBody.mergeFrom(paramArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.i("urlSecMgr", 2, "parse 0xbcb_0 result msg=" + localRspBody.wording.get() + ", count=" + localRspBody.check_url_rsp.results.size());
          }
          l1 = NetConnInfoCenter.getServerTimeMillis();
          l2 = localRspBody.check_url_rsp.next_req_duration.get();
          int i = localRspBody.check_url_rsp.results.size();
          paramArrayOfByte = null;
          paramInt = 0;
          if (paramInt < i) {
            paramBundle = paramArrayOfByte;
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
        {
          long l1;
          long l2;
          Object localObject2;
          String str;
          paramBundle = null;
        }
        try
        {
          localObject2 = (oidb_0xbcb.UrlCheckResult)localRspBody.check_url_rsp.results.get(paramInt);
          paramBundle = paramArrayOfByte;
          str = ((oidb_0xbcb.UrlCheckResult)localObject2).url.get();
          paramBundle = paramArrayOfByte;
          localObject1 = new UrlSecurityCheckManager.CheckResult(null);
          paramBundle = paramArrayOfByte;
          ((UrlSecurityCheckManager.CheckResult)localObject1).jdField_a_of_type_Long = (l2 * 1000L + l1);
          paramBundle = paramArrayOfByte;
          ((UrlSecurityCheckManager.CheckResult)localObject1).jdField_a_of_type_Int = ((oidb_0xbcb.UrlCheckResult)localObject2).result.get();
          paramBundle = paramArrayOfByte;
          ((UrlSecurityCheckManager.CheckResult)localObject1).jdField_b_of_type_Int = ((oidb_0xbcb.UrlCheckResult)localObject2).jump_result.get();
          paramBundle = paramArrayOfByte;
          ((UrlSecurityCheckManager.CheckResult)localObject1).jdField_a_of_type_JavaLangString = ((oidb_0xbcb.UrlCheckResult)localObject2).jump_url.get();
          paramBundle = paramArrayOfByte;
          ((UrlSecurityCheckManager.CheckResult)localObject1).c = ((oidb_0xbcb.UrlCheckResult)localObject2).uint32_level.get();
          paramBundle = paramArrayOfByte;
          ((UrlSecurityCheckManager.CheckResult)localObject1).d = ((oidb_0xbcb.UrlCheckResult)localObject2).uint32_sub_level.get();
          paramBundle = paramArrayOfByte;
          ((UrlSecurityCheckManager.CheckResult)localObject1).e = ((oidb_0xbcb.UrlCheckResult)localObject2).uint32_umrtype.get();
          paramBundle = paramArrayOfByte;
          ((UrlSecurityCheckManager.CheckResult)localObject1).f = ((oidb_0xbcb.UrlCheckResult)localObject2).ret_from.get();
          paramBundle = paramArrayOfByte;
          ((UrlSecurityCheckManager.CheckResult)localObject1).jdField_b_of_type_Long = ((oidb_0xbcb.UrlCheckResult)localObject2).operation_bit.get();
          if (paramInt == 0) {
            paramArrayOfByte = (byte[])localObject1;
          }
          paramBundle = paramArrayOfByte;
          localObject2 = (UrlSecurityCheckManager.CheckResult)this.jdField_a_of_type_ComTencentMobileqqWebviewUrlSecurityCheckManager.a.get(str);
          if (localObject2 != null)
          {
            paramBundle = paramArrayOfByte;
            ((UrlSecurityCheckManager.CheckResult)localObject1).jdField_a_of_type_Boolean = ((UrlSecurityCheckManager.CheckResult)localObject2).jdField_a_of_type_Boolean;
          }
          paramBundle = paramArrayOfByte;
          this.jdField_a_of_type_ComTencentMobileqqWebviewUrlSecurityCheckManager.a.put(str, localObject1);
          paramInt += 1;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
        {
          label628:
          break label628;
        }
      }
      continue;
      paramArrayOfByte = paramBundle;
      if (QLog.isColorLevel())
      {
        QLog.i("urlSecMgr", 2, "parse error", localInvalidProtocolBufferMicroException1);
        paramArrayOfByte = paramBundle;
        continue;
        label656:
        paramBundle = "";
        continue;
        label662:
        paramArrayOfByte = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.UrlSecurityCheckManager.5
 * JD-Core Version:    0.7.0.1
 */