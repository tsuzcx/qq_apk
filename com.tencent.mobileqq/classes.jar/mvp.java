import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.UUID;

public abstract class mvp
{
  private final int jdField_a_of_type_Int;
  protected AppInterface a;
  final String jdField_a_of_type_JavaLangString;
  
  protected mvp(AppInterface paramAppInterface, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = ("FileUpload_" + paramInt + "_" + paramLong);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    if (paramAppInterface != null) {
      paramAppInterface.getHwEngine().preConnect();
    }
  }
  
  public static byte[] a(String paramString, AppInterface paramAppInterface)
  {
    try
    {
      String str = paramAppInterface.getCurrentAccountUin();
      if (SessionInfo.getInstance(str).getHttpconn_sig_session() != null)
      {
        int i = SessionInfo.getInstance(str).getHttpconn_sig_session().length;
        paramString = new byte[i];
        System.arraycopy(SessionInfo.getInstance(str).getHttpconn_sig_session(), 0, paramString, 0, i);
        return paramString;
      }
      HwServlet.getConfig(paramAppInterface, str);
      QLog.w(paramString, 1, "getSig, fail");
      return null;
    }
    finally {}
  }
  
  protected boolean a(String paramString, mvr parammvr)
  {
    long l = new File(paramString).length();
    String str = apmf.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (l == 0L)
    {
      parammvr.a(-10001, str, "", null);
      return false;
    }
    Object localObject = a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if ((localObject == null) || (localObject.length == 0))
    {
      parammvr.a(-10003, str, "", null);
      return false;
    }
    byte[] arrayOfByte = apmf.a(paramString);
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
    {
      parammvr.a(-10002, str, "", null);
      return false;
    }
    mvq localmvq = new mvq(this, str, l, arrayOfByte, parammvr);
    Bdh_extinfo.CommFileExtReq localCommFileExtReq = new Bdh_extinfo.CommFileExtReq();
    localCommFileExtReq.uint32_action_type.set(0);
    localCommFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
    localObject = new Transaction(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Int, paramString, 0, (byte[])localObject, arrayOfByte, localmvq, localCommFileExtReq.toByteArray());
    int i = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask((Transaction)localObject);
    if (i != 0) {
      parammvr.a(i, str, "", null);
    }
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestToUpload, localFile[" + paramString + "], sessionId[" + str + "]");
    return i == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mvp
 * JD-Core Version:    0.7.0.1
 */