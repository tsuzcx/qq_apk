import com.tencent.biz.ProtoUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.AppInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import tencent.im.oidb.oidb_0xb61.GetAppinfoReq;
import tencent.im.oidb.oidb_0xb61.ReqBody;

public class rep
  extends JobSegment
{
  protected void a(JobContext paramJobContext, rem paramrem)
  {
    paramJobContext = BaseApplicationImpl.getApplication().getRuntime();
    if (paramJobContext == null)
    {
      notifyError(new ErrorMessage(-1, "DoraemonOpenAPI.permissionHelper.jobAppInfo|app is null"));
      return;
    }
    try
    {
      int i = Integer.parseInt(paramrem.a.jdField_a_of_type_JavaLangString);
      oidb_0xb61.ReqBody localReqBody = new oidb_0xb61.ReqBody();
      localReqBody.get_appinfo_req.setHasFlag(true);
      localReqBody.get_appinfo_req.appid.set(i);
      localReqBody.get_appinfo_req.app_type.set(paramrem.a.jdField_a_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.i("DoraemonOpenAPI.permissionHelper.jobAppInfo", 2, "send type=" + paramrem.a.jdField_a_of_type_Int + ", appid=" + paramrem.a.jdField_a_of_type_JavaLangString);
      }
      ProtoUtils.a(paramJobContext, new req(this, paramrem), localReqBody.toByteArray(), "OidbSvc.0xb61_1", 2913, 1, null, 0L);
      return;
    }
    catch (NumberFormatException paramJobContext)
    {
      notifyError(new ErrorMessage(-1, "DoraemonOpenAPI.permissionHelper.jobAppInfo|parse appid error"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rep
 * JD-Core Version:    0.7.0.1
 */