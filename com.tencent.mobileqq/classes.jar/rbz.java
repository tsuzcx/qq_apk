import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.Doraemon.AppInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_0xb61.GetAppinfoRsp;
import tencent.im.oidb.oidb_0xb61.RspBody;
import tencent.im.oidb.qqconnect.Appinfo;

class rbz
  extends ProtoUtils.TroopProtocolObserver
{
  rbz(rby paramrby, rbv paramrbv) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.permissionHelper.jobAppInfo", 2, "onResult type=" + this.jdField_a_of_type_Rbv.a.jdField_a_of_type_Int + ", appid=" + this.jdField_a_of_type_Rbv.a.jdField_a_of_type_JavaLangString + ", code=" + paramInt);
    }
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      rby.a(this.jdField_a_of_type_Rby, new ErrorMessage(paramInt, "DoraemonOpenAPI.permissionHelper.jobAppInfo|req error"));
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.permissionHelper.jobAppInfo", 2, "req error");
      }
    }
    do
    {
      for (;;)
      {
        return;
        paramBundle = new oidb_0xb61.RspBody();
        try
        {
          paramBundle.mergeFrom(paramArrayOfByte);
          if (paramBundle.get_appinfo_rsp.appinfo.has()) {
            break label200;
          }
          rby.b(this.jdField_a_of_type_Rby, new ErrorMessage(-1, "DoraemonOpenAPI.permissionHelper.jobAppInfo|rsp invalid"));
          if (QLog.isColorLevel())
          {
            QLog.i("DoraemonOpenAPI.permissionHelper.jobAppInfo", 2, "rsp invalid");
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramArrayOfByte)
        {
          rby.c(this.jdField_a_of_type_Rby, new ErrorMessage(-1, "DoraemonOpenAPI.permissionHelper.jobAppInfo|parse rsp error"));
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("DoraemonOpenAPI.permissionHelper.jobAppInfo", 2, "parse rsp error", paramArrayOfByte);
    return;
    label200:
    if (QLog.isColorLevel()) {
      QLog.d("DoraemonOpenAPI.permissionHelper.jobAppInfo", 2, "receive app_name:" + paramBundle.get_appinfo_rsp.appinfo.app_name.get());
    }
    this.jdField_a_of_type_Rbv.a.jdField_b_of_type_JavaLangString = paramBundle.get_appinfo_rsp.appinfo.app_name.get();
    this.jdField_a_of_type_Rbv.a.jdField_b_of_type_Int = paramBundle.get_appinfo_rsp.appinfo.app_state.get();
    rby.a(this.jdField_a_of_type_Rby, this.jdField_a_of_type_Rbv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     rbz
 * JD-Core Version:    0.7.0.1
 */