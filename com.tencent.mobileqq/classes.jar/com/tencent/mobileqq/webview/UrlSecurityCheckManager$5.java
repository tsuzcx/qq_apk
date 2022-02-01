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
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("receive 0xbcb_0 code=");
      paramBundle.append(paramInt);
      QLog.i("urlSecMgr", 2, paramBundle.toString());
    }
    UrlSecurityCheckManager.CheckResult localCheckResult = null;
    paramBundle = null;
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      localObject1 = new oidb_0xbcb.RspBody();
      try
      {
        ((oidb_0xbcb.RspBody)localObject1).mergeFrom(paramArrayOfByte);
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("parse 0xbcb_0 result msg=");
          paramArrayOfByte.append(((oidb_0xbcb.RspBody)localObject1).wording.get());
          paramArrayOfByte.append(", count=");
          paramArrayOfByte.append(((oidb_0xbcb.RspBody)localObject1).check_url_rsp.results.size());
          QLog.i("urlSecMgr", 2, paramArrayOfByte.toString());
        }
        long l1 = NetConnInfoCenter.getServerTimeMillis();
        long l2 = ((oidb_0xbcb.RspBody)localObject1).check_url_rsp.next_req_duration.get();
        paramInt = 0;
        int i = ((oidb_0xbcb.RspBody)localObject1).check_url_rsp.results.size();
        paramArrayOfByte = null;
        for (;;)
        {
          if (paramInt < i)
          {
            paramBundle = paramArrayOfByte;
            try
            {
              Object localObject2 = (oidb_0xbcb.UrlCheckResult)((oidb_0xbcb.RspBody)localObject1).check_url_rsp.results.get(paramInt);
              paramBundle = paramArrayOfByte;
              String str = ((oidb_0xbcb.UrlCheckResult)localObject2).url.get();
              paramBundle = paramArrayOfByte;
              localCheckResult = new UrlSecurityCheckManager.CheckResult(null);
              paramBundle = paramArrayOfByte;
              localCheckResult.jdField_a_of_type_Long = (l1 + l2 * 1000L);
              paramBundle = paramArrayOfByte;
              localCheckResult.jdField_a_of_type_Int = ((oidb_0xbcb.UrlCheckResult)localObject2).result.get();
              paramBundle = paramArrayOfByte;
              localCheckResult.jdField_b_of_type_Int = ((oidb_0xbcb.UrlCheckResult)localObject2).jump_result.get();
              paramBundle = paramArrayOfByte;
              localCheckResult.jdField_a_of_type_JavaLangString = ((oidb_0xbcb.UrlCheckResult)localObject2).jump_url.get();
              paramBundle = paramArrayOfByte;
              localCheckResult.c = ((oidb_0xbcb.UrlCheckResult)localObject2).uint32_level.get();
              paramBundle = paramArrayOfByte;
              localCheckResult.d = ((oidb_0xbcb.UrlCheckResult)localObject2).uint32_sub_level.get();
              paramBundle = paramArrayOfByte;
              localCheckResult.e = ((oidb_0xbcb.UrlCheckResult)localObject2).uint32_umrtype.get();
              paramBundle = paramArrayOfByte;
              localCheckResult.f = ((oidb_0xbcb.UrlCheckResult)localObject2).ret_from.get();
              paramBundle = paramArrayOfByte;
              localCheckResult.jdField_b_of_type_Long = ((oidb_0xbcb.UrlCheckResult)localObject2).operation_bit.get();
              if (paramInt == 0) {
                paramArrayOfByte = localCheckResult;
              }
              paramBundle = paramArrayOfByte;
              localObject2 = (UrlSecurityCheckManager.CheckResult)this.jdField_a_of_type_ComTencentMobileqqWebviewUrlSecurityCheckManager.a.get(str);
              if (localObject2 != null)
              {
                paramBundle = paramArrayOfByte;
                localCheckResult.jdField_a_of_type_Boolean = ((UrlSecurityCheckManager.CheckResult)localObject2).jdField_a_of_type_Boolean;
              }
              paramBundle = paramArrayOfByte;
              this.jdField_a_of_type_ComTencentMobileqqWebviewUrlSecurityCheckManager.a.put(str, localCheckResult);
              paramInt += 1;
            }
            catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
            {
              paramArrayOfByte = paramBundle;
              break label440;
            }
          }
        }
        paramBundle = paramArrayOfByte;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
      {
        paramArrayOfByte = paramBundle;
        label440:
        paramBundle = paramArrayOfByte;
        if (!QLog.isColorLevel()) {
          break label584;
        }
      }
      QLog.i("urlSecMgr", 2, "parse error", localInvalidProtocolBufferMicroException2);
      paramBundle = paramArrayOfByte;
    }
    else
    {
      paramBundle = localInvalidProtocolBufferMicroException2;
      if ((QLog.isColorLevel()) && (paramArrayOfByte == null)) {}
    }
    try
    {
      paramBundle = ((oidb_0xbcb.RspBody)new oidb_0xbcb.RspBody().mergeFrom(paramArrayOfByte)).wording.get();
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      label500:
      break label500;
    }
    paramBundle = "";
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("req error code=");
    ((StringBuilder)localObject1).append(paramInt);
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = ", data=null";
    }
    else
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append(", msg=");
      paramArrayOfByte.append(paramBundle);
      paramArrayOfByte = paramArrayOfByte.toString();
    }
    ((StringBuilder)localObject1).append(paramArrayOfByte);
    QLog.i("urlSecMgr", 2, ((StringBuilder)localObject1).toString());
    paramBundle = localInvalidProtocolBufferMicroException2;
    label584:
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewUrlSecurityCheckManager$OnCheckResult != null)
    {
      paramArrayOfByte = new Bundle();
      if ((this.jdField_a_of_type_Int == 1) && (paramBundle != null))
      {
        paramArrayOfByte.putInt("result", paramBundle.jdField_a_of_type_Int);
        paramArrayOfByte.putInt("jumpResult", paramBundle.jdField_b_of_type_Int);
        paramArrayOfByte.putString("jumpUrl", paramBundle.jdField_a_of_type_JavaLangString);
        paramArrayOfByte.putInt("level", paramBundle.c);
        paramArrayOfByte.putInt("subLevel", paramBundle.d);
        paramArrayOfByte.putInt("umrType", paramBundle.e);
        paramArrayOfByte.putInt("retFrom", paramBundle.f);
        paramArrayOfByte.putLong("operationBit", paramBundle.jdField_b_of_type_Long);
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewUrlSecurityCheckManager$OnCheckResult.a(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.UrlSecurityCheckManager.5
 * JD-Core Version:    0.7.0.1
 */