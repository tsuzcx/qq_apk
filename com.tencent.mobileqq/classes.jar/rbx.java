import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.Doraemon.AppInfo;
import com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.oidb_0xb60.GetPrivilegeRsp;
import tencent.im.oidb.oidb_0xb60.RspBody;

class rbx
  extends ProtoUtils.TroopProtocolObserver
{
  rbx(rbw paramrbw, rbv paramrbv) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "onResult type=" + this.jdField_a_of_type_Rbv.jdField_a_of_type_ComTencentMobileqqDoraemonAppInfo.jdField_a_of_type_Int + ", appid=" + this.jdField_a_of_type_Rbv.jdField_a_of_type_ComTencentMobileqqDoraemonAppInfo.jdField_a_of_type_JavaLangString + ", code=" + paramInt);
    }
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      rbw.a(this.jdField_a_of_type_Rbw, new ErrorMessage(paramInt, "DoraemonOpenAPI.permissionHelper.jobApiPermission|req error"));
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "req error");
      }
    }
    do
    {
      for (;;)
      {
        return;
        paramBundle = new oidb_0xb60.RspBody();
        try
        {
          paramBundle.mergeFrom(paramArrayOfByte);
          if ((paramBundle.get_privilege_rsp.api_groups.has()) && (paramBundle.get_privilege_rsp.next_req_duration.has())) {
            break label213;
          }
          rbw.b(this.jdField_a_of_type_Rbw, new ErrorMessage(-1, "DoraemonOpenAPI.permissionHelper.jobApiPermission|rsp invalid"));
          if (QLog.isColorLevel())
          {
            QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "rsp invalid");
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          rbw.c(this.jdField_a_of_type_Rbw, new ErrorMessage(-1, "DoraemonOpenAPI.permissionHelper.jobApiPermission|parse rsp error"));
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "parse rsp error", paramArrayOfByte);
    return;
    label213:
    if (QLog.isColorLevel()) {
      QLog.d("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "receive api_groups:" + paramBundle.get_privilege_rsp.api_groups.get() + ", api_names:" + paramBundle.get_privilege_rsp.api_names.get());
    }
    paramArrayOfByte = DefaultDoraemonAppInfoHelper.a();
    paramArrayOfByte.a(paramBundle.get_privilege_rsp.api_groups.get(), this.jdField_a_of_type_Rbv.jdField_a_of_type_ComTencentMobileqqDoraemonAppInfo.jdField_a_of_type_JavaUtilSet);
    if (paramBundle.get_privilege_rsp.api_names.size() > 0)
    {
      Iterator localIterator = paramBundle.get_privilege_rsp.api_names.get().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (DefaultDoraemonAppInfoHelper.a(paramArrayOfByte, str)) {
          this.jdField_a_of_type_Rbv.jdField_a_of_type_ComTencentMobileqqDoraemonAppInfo.jdField_a_of_type_JavaUtilSet.add(str);
        }
      }
    }
    this.jdField_a_of_type_Rbv.jdField_a_of_type_Long = (NetConnInfoCenter.getServerTimeMillis() + paramBundle.get_privilege_rsp.next_req_duration.get() * 1000L);
    rbw.a(this.jdField_a_of_type_Rbw, this.jdField_a_of_type_Rbv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     rbx
 * JD-Core Version:    0.7.0.1
 */