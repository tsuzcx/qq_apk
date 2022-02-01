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

public abstract class mvw
{
  private final int jdField_a_of_type_Int;
  protected AppInterface a;
  final String jdField_a_of_type_JavaLangString;
  
  protected mvw(AppInterface paramAppInterface, int paramInt, long paramLong)
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
  
  protected boolean a(String paramString, mvy parammvy)
  {
    long l = new File(paramString).length();
    String str = apiu.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (l == 0L)
    {
      parammvy.a(-10001, str, "", null);
      return false;
    }
    Object localObject = a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if ((localObject == null) || (localObject.length == 0))
    {
      parammvy.a(-10003, str, "", null);
      return false;
    }
    byte[] arrayOfByte = apiu.a(paramString);
    if ((arrayOfByte == null) || (arrayOfByte.length == 0))
    {
      parammvy.a(-10002, str, "", null);
      return false;
    }
    mvx localmvx = new mvx(this, str, l, arrayOfByte, parammvy);
    Bdh_extinfo.CommFileExtReq localCommFileExtReq = new Bdh_extinfo.CommFileExtReq();
    localCommFileExtReq.uint32_action_type.set(0);
    localCommFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
    localObject = new Transaction(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Int, paramString, 0, (byte[])localObject, arrayOfByte, localmvx, localCommFileExtReq.toByteArray());
    int i = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask((Transaction)localObject);
    if (i != 0) {
      parammvy.a(i, str, "", null);
    }
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "requestToUpload, localFile[" + paramString + "], sessionId[" + str + "]");
    return i == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mvw
 * JD-Core Version:    0.7.0.1
 */