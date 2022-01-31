import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xa4d.oidb_0xa4d.IMMRReq;
import tencent.im.oidb.cmd0xa4d.oidb_0xa4d.ReqBody;

public class hl
  extends ajfb
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private hk jdField_a_of_type_Hk;
  
  public hl(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public void a(hk paramhk)
  {
    this.jdField_a_of_type_Hk = paramhk;
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
    mmj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new hm(false, this.jdField_a_of_type_Hk), paramString.toByteArray(), "OidbSvc.0xa4d", 2637, 1, null);
  }
  
  protected Class<? extends ajfe> observerClass()
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
 * Qualified Name:     hl
 * JD-Core Version:    0.7.0.1
 */