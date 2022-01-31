package cooperation.qzone.gift;

import NS_MOBILE_TEMPLATE_GIFT.template_gift_get_send_status_req;
import NS_MOBILE_TEMPLATE_GIFT.template_gift_get_send_status_rsp;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;
import java.util.ArrayList;
import java.util.Map;

public class QZoneCheckSendGiftRequest
  extends QzoneExternalRequest
{
  public static String a;
  public static String b = "getGiftSendUins";
  public JceStruct a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "QzoneNewService.";
  }
  
  public QZoneCheckSendGiftRequest(long paramLong, ArrayList paramArrayList, Map paramMap)
  {
    super.setHostUin(paramLong);
    super.setLoginUserId(paramLong);
    this.jdField_a_of_type_ComQqTafJceJceStruct = new template_gift_get_send_status_req(paramLong, paramArrayList, paramMap);
  }
  
  public static template_gift_get_send_status_rsp a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    paramArrayOfByte = decode(paramArrayOfByte, b);
    if ((paramArrayOfByte instanceof template_gift_get_send_status_rsp)) {
      return (template_gift_get_send_status_rsp)paramArrayOfByte;
    }
    return null;
  }
  
  public String getCmdString()
  {
    return jdField_a_of_type_JavaLangString + b;
  }
  
  public JceStruct getReq()
  {
    return this.jdField_a_of_type_ComQqTafJceJceStruct;
  }
  
  public String uniKey()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.gift.QZoneCheckSendGiftRequest
 * JD-Core Version:    0.7.0.1
 */