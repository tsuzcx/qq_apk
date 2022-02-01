package cooperation.qzone;

import QzoneCombine.ClientOnlineNotfiyReq;
import bkec;
import com.qq.taf.jce.JceStruct;

public class ClientOnlineRequest
  extends QzoneExternalRequest
{
  ClientOnlineNotfiyReq req;
  
  public ClientOnlineRequest(long paramLong, byte[] paramArrayOfByte)
  {
    this.needCompress = false;
    this.req = new ClientOnlineNotfiyReq(paramArrayOfByte, paramLong);
  }
  
  public String getCmdString()
  {
    return "QzoneNewService." + uniKey();
  }
  
  protected byte[] getEncodedUniParameter()
  {
    return bkec.a(this.req);
  }
  
  public JceStruct getReq()
  {
    return this.req;
  }
  
  public String uniKey()
  {
    return "MqqOnlineNtf";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.ClientOnlineRequest
 * JD-Core Version:    0.7.0.1
 */