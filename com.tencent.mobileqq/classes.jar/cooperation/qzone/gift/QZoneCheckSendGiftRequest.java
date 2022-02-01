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
  public static String CMD = "getGiftSendUins";
  public static String PRE_CMD = "QzoneNewService.";
  public JceStruct req;
  
  public QZoneCheckSendGiftRequest(long paramLong, ArrayList<Long> paramArrayList, Map<String, String> paramMap)
  {
    super.setHostUin(paramLong);
    super.setLoginUserId(paramLong);
    this.req = new template_gift_get_send_status_req(paramLong, paramArrayList, paramMap);
  }
  
  public static template_gift_get_send_status_rsp onResponse(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    paramArrayOfByte = decode(paramArrayOfByte, CMD);
    if ((paramArrayOfByte instanceof template_gift_get_send_status_rsp)) {
      return (template_gift_get_send_status_rsp)paramArrayOfByte;
    }
    return null;
  }
  
  public String getCmdString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(PRE_CMD);
    localStringBuilder.append(CMD);
    return localStringBuilder.toString();
  }
  
  public JceStruct getReq()
  {
    return this.req;
  }
  
  public String uniKey()
  {
    return CMD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.gift.QZoneCheckSendGiftRequest
 * JD-Core Version:    0.7.0.1
 */