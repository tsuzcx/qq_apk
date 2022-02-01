package cooperation.qzone;

import QzoneCombine.ClientOnlineNotfiyReq;
import com.qq.taf.jce.JceStruct;
import common.config.service.WupTool;

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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QzoneNewService.");
    localStringBuilder.append(uniKey());
    return localStringBuilder.toString();
  }
  
  protected byte[] getEncodedUniParameter()
  {
    return WupTool.a(this.req);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.ClientOnlineRequest
 * JD-Core Version:    0.7.0.1
 */