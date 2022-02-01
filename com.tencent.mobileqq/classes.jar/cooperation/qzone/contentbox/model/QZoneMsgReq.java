package cooperation.qzone.contentbox.model;

import NS_QZONE_MQMSG.QzoneMessageBoxRsp;
import NS_QZONE_MQMSG.QzoneMessageReq;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneCommonRequest;
import java.util.HashMap;
import java.util.Map;

public class QZoneMsgReq
  extends QZoneCommonRequest
{
  private static final String CMD = "GetNewMQmsg";
  public JceStruct req;
  private int type;
  
  public QZoneMsgReq(long paramLong1, String paramString, long paramLong2, int paramInt)
  {
    QzoneMessageReq localQzoneMessageReq = new QzoneMessageReq();
    localQzoneMessageReq.uin = paramLong1;
    localQzoneMessageReq.trace_info = paramString;
    localQzoneMessageReq.num = paramLong2;
    localQzoneMessageReq.ext = new HashMap();
    localQzoneMessageReq.ext.put("qua", QUA.getQUA3());
    localQzoneMessageReq.scence = paramInt;
    this.req = localQzoneMessageReq;
  }
  
  public static QZoneMsgEntityNew onResponse(byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    paramArrayOfByte = decode(paramArrayOfByte, "GetNewMQmsg", paramArrayOfInt);
    if ((paramArrayOfByte instanceof QzoneMessageBoxRsp)) {
      return QZoneMsgEntityNew.readFrom((QzoneMessageBoxRsp)paramArrayOfByte);
    }
    return null;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.GetNewMQmsg";
  }
  
  public JceStruct getReq()
  {
    return this.req;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public String uniKey()
  {
    return "GetNewMQmsg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.model.QZoneMsgReq
 * JD-Core Version:    0.7.0.1
 */