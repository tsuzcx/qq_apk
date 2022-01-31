import com.tencent.biz.ProtoUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.AppInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import tencent.im.oidb.oidb_0xb60.GetPrivilegeReq;
import tencent.im.oidb.oidb_0xb60.ReqBody;

public class rbw
  extends JobSegment
{
  protected void a(JobContext paramJobContext, rbv paramrbv)
  {
    paramJobContext = BaseApplicationImpl.getApplication().getRuntime();
    if (paramJobContext == null)
    {
      notifyError(new ErrorMessage(-1, "DoraemonOpenAPI.permissionHelper.jobApiPermission|app is null"));
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "app is null");
      }
    }
    do
    {
      return;
      try
      {
        int i = Integer.parseInt(paramrbv.a.jdField_a_of_type_JavaLangString);
        oidb_0xb60.ReqBody localReqBody = new oidb_0xb60.ReqBody();
        localReqBody.get_privilege_req.setHasFlag(true);
        localReqBody.get_privilege_req.appid.set(i);
        localReqBody.get_privilege_req.app_type.set(paramrbv.a.jdField_a_of_type_Int);
        if (QLog.isColorLevel()) {
          QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "send type=" + paramrbv.a.jdField_a_of_type_Int + ", appid=" + paramrbv.a.jdField_a_of_type_JavaLangString);
        }
        ProtoUtils.a(paramJobContext, new rbx(this, paramrbv), localReqBody.toByteArray(), "OidbSvc.0xb60_1", 2912, 1, null, 0L);
        return;
      }
      catch (NumberFormatException paramJobContext)
      {
        notifyError(new ErrorMessage(-1, "DoraemonOpenAPI.permissionHelper.jobApiPermission|parse appid error"));
      }
    } while (!QLog.isColorLevel());
    QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 2, "parse appid error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     rbw
 * JD-Core Version:    0.7.0.1
 */