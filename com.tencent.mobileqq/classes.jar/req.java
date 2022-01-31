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

class req
  extends ProtoUtils.TroopProtocolObserver
{
  req(rep paramrep, rem paramrem) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoraemonOpenAPI.permissionHelper.jobAppInfo", 2, "onResult type=" + this.jdField_a_of_type_Rem.a.jdField_a_of_type_Int + ", appid=" + this.jdField_a_of_type_Rem.a.jdField_a_of_type_JavaLangString + ", code=" + paramInt);
    }
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      rep.a(this.jdField_a_of_type_Rep, new ErrorMessage(paramInt, "DoraemonOpenAPI.permissionHelper.jobAppInfo|req error"));
      return;
    }
    paramBundle = new oidb_0xb61.RspBody();
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      if (!paramBundle.get_appinfo_rsp.appinfo.has())
      {
        rep.b(this.jdField_a_of_type_Rep, new ErrorMessage(-1, "DoraemonOpenAPI.permissionHelper.jobAppInfo|rsp invalid"));
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      rep.c(this.jdField_a_of_type_Rep, new ErrorMessage(-1, "DoraemonOpenAPI.permissionHelper.jobAppInfo|parse rsp error"));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoraemonOpenAPI.permissionHelper.jobAppInfo", 2, "receive app_name:" + paramBundle.get_appinfo_rsp.appinfo.app_name.get());
    }
    this.jdField_a_of_type_Rem.a.jdField_b_of_type_JavaLangString = paramBundle.get_appinfo_rsp.appinfo.app_name.get();
    this.jdField_a_of_type_Rem.a.jdField_b_of_type_Int = paramBundle.get_appinfo_rsp.appinfo.app_state.get();
    rep.a(this.jdField_a_of_type_Rep, this.jdField_a_of_type_Rem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     req
 * JD-Core Version:    0.7.0.1
 */