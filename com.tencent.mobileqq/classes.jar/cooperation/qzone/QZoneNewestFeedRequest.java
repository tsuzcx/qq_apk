package cooperation.qzone;

import NS_MOBILE_AIONewestFeed.AIONewestFeedReq;
import NS_MOBILE_AIONewestFeed.AIONewestFeedRsp;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;

public class QZoneNewestFeedRequest
  extends QzoneExternalRequest
{
  public static final String CMD_STRING = "getAIONewestFeed";
  private static final String CMD_STRING_BUFFER = "QzoneNewService.getAIONewestFeed";
  public static final String KEY_NEWEST_FEEDS = "getAIONewestFeed";
  private static final String unikey = "getAIONewestFeed";
  public JceStruct req;
  
  public QZoneNewestFeedRequest(long paramLong1, ArrayList<Long> paramArrayList, long paramLong2, String paramString, int paramInt)
  {
    super.setRefer(paramString);
    super.setHostUin(paramLong1);
    super.setLoginUserId(paramLong1);
    paramString = new AIONewestFeedReq();
    paramString.uOpUin = paramLong1;
    paramString.uHostUin = paramArrayList;
    paramString.uLastTime = paramLong2;
    paramString.src = paramInt;
    this.req = paramString;
  }
  
  public static AIONewestFeedRsp onResponse(byte[] paramArrayOfByte, QQAppInterface paramQQAppInterface)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    paramArrayOfByte = (AIONewestFeedRsp)decode(paramArrayOfByte, "getAIONewestFeed");
    if (paramArrayOfByte == null) {
      return null;
    }
    return paramArrayOfByte;
  }
  
  public static AIONewestFeedRsp onResponse(byte[] paramArrayOfByte, QQAppInterface paramQQAppInterface, int[] paramArrayOfInt)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    paramArrayOfByte = (AIONewestFeedRsp)decode(paramArrayOfByte, "getAIONewestFeed", paramArrayOfInt);
    if (paramArrayOfByte == null) {
      return null;
    }
    return paramArrayOfByte;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.getAIONewestFeed";
  }
  
  public JceStruct getReq()
  {
    return this.req;
  }
  
  public String uniKey()
  {
    return "getAIONewestFeed";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.QZoneNewestFeedRequest
 * JD-Core Version:    0.7.0.1
 */