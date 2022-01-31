import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xa4d.oidb_0xa4d.IMMRReq;
import tencent.im.oidb.cmd0xa4d.oidb_0xa4d.ReqBody;

public class je
  extends ajtd
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private jd jdField_a_of_type_Jd;
  
  public je(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ImmersionHandler", 2, "HapticMediaPlayer start request");
    }
    oidb_0xa4d.IMMRReq localIMMRReq = new oidb_0xa4d.IMMRReq();
    localIMMRReq.str_url.set(paramString);
    paramString = new oidb_0xa4d.ReqBody();
    paramString.msg_immr_req.set(localIMMRReq);
    mxi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new jf(false, this.jdField_a_of_type_Jd), paramString.toByteArray(), "OidbSvc.0xa4d", 2637, 1, null);
  }
  
  public void a(jd paramjd)
  {
    this.jdField_a_of_type_Jd = paramjd;
  }
  
  protected Class<? extends ajtg> observerClass()
  {
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     je
 * JD-Core Version:    0.7.0.1
 */