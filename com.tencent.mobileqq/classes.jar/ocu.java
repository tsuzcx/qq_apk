import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PhoneInfo;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ReqAdvertisePara;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ReqBody;
import tencent.im.oidb.cmd0x885.oidb_0x885.AdReqInfo;

public class ocu
  extends alpd
{
  public static long a = 1800L;
  
  public ocu(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void a()
  {
    oidb_0x6cf.ReqBody localReqBody = new oidb_0x6cf.ReqBody();
    oidb_0x6cf.ReqAdvertisePara localReqAdvertisePara = new oidb_0x6cf.ReqAdvertisePara();
    oidb_0x885.AdReqInfo localAdReqInfo = new oidb_0x885.AdReqInfo();
    if ((this.app != null) && (this.app.getLongAccountUin() != 0L)) {
      localReqBody.uint64_uin.set(this.app.getLongAccountUin());
    }
    try
    {
      localAdReqInfo.int32_req_type.set(3);
      localReqAdvertisePara.msg_ad_req_info.set(localAdReqInfo);
      localReqAdvertisePara.msg_phone_info.set(ods.a());
      localReqBody.req_advertise_para.set(localReqAdvertisePara);
      mzy.a(this.app, new ocv(this), localReqBody.toByteArray(), "OidbSvc.0x6cf", 1743, 0, new Bundle(), 6000L);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AdMaterialHandler", 2, "Exception error" + QLog.getStackTraceString(localException));
        }
      }
    }
  }
  
  protected Class<? extends alpg> observerClass()
  {
    return ocw.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ocu
 * JD-Core Version:    0.7.0.1
 */