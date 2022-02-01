package cooperation.qzone;

import PUSHAPI.PushRsp;
import blpn;
import com.qq.taf.jce.JceStruct;

public class QZoneMsfPushAckRequest
  extends QzoneExternalRequest
{
  public static final String CMD_STRING = "wns.pushrsp";
  private static final String CMD_STRING_BUFFER = "wns.pushrsp";
  public static final int ERR_MSF_RESP_IS_NULL = 1000000;
  public static final int ERR_NO_NET = 1000006;
  private static final String unikey = "wns.pushrsp";
  private long flag;
  private long lastTimeStamp;
  private String mask;
  
  public QZoneMsfPushAckRequest(long paramLong1, long paramLong2, String paramString1, long paramLong3, String paramString2)
  {
    super.setHostUin(paramLong1);
    super.setLoginUserId(paramLong1);
    super.setRefer(paramString1);
    this.lastTimeStamp = paramLong2;
    this.flag = paramLong3;
    this.mask = paramString2;
    this.needCompress = false;
  }
  
  public String getCmdString()
  {
    return "wns.pushrsp";
  }
  
  protected byte[] getEncodedUniParameter()
  {
    PushRsp localPushRsp = new PushRsp();
    localPushRsp.ptime = this.lastTimeStamp;
    localPushRsp.is_bgd = 0;
    localPushRsp.sUID = "<JIEHEBAN>";
    localPushRsp.flag = this.flag;
    localPushRsp.Mark = this.mask;
    return blpn.a(localPushRsp);
  }
  
  public JceStruct getReq()
  {
    return null;
  }
  
  public String uniKey()
  {
    return "wns.pushrsp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneMsfPushAckRequest
 * JD-Core Version:    0.7.0.1
 */