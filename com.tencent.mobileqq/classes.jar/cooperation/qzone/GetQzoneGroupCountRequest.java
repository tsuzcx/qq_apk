package cooperation.qzone;

import NS_GROUP_COUNT.mobile_group_count_req;
import NS_GROUP_COUNT.mobile_group_count_rsp;
import com.qq.taf.jce.JceStruct;
import java.util.Map;

public class GetQzoneGroupCountRequest
  extends QzoneExternalRequest
{
  public static final String CMD_STRING = "Feeds.getgroupcount";
  private static final String unikey = "getgroupcount";
  private mobile_group_count_req req;
  
  public GetQzoneGroupCountRequest(long paramLong1, long paramLong2, Map<String, String> paramMap)
  {
    super.setHostUin(paramLong1);
    super.setLoginUserId(paramLong1);
    this.needCompress = false;
    this.req = new mobile_group_count_req(paramLong2, paramMap);
  }
  
  public static mobile_group_count_rsp onResponse(byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    paramArrayOfByte = (mobile_group_count_rsp)decode(paramArrayOfByte, "getgroupcount", paramArrayOfInt);
    if (paramArrayOfByte == null) {
      return null;
    }
    return paramArrayOfByte;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.Feeds.getgroupcount";
  }
  
  public JceStruct getReq()
  {
    return this.req;
  }
  
  public String uniKey()
  {
    return "getgroupcount";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.GetQzoneGroupCountRequest
 * JD-Core Version:    0.7.0.1
 */