package cooperation.qzone;

import NS_MOBILE_NEWEST_FEEDS.newest_feeds_req;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public class QZoneConversationStatusRequest
  extends QZoneCommonRequest
{
  public static final String CMD_STRING = "QzoneNewService.getMsgNewestFeeds";
  public static final String UNI_KEY = "getMsgNewestFeeds";
  newest_feeds_req req = new newest_feeds_req();
  
  public QZoneConversationStatusRequest(long paramLong, Map<Long, Long> paramMap)
  {
    newest_feeds_req localnewest_feeds_req = this.req;
    localnewest_feeds_req.cmd = 4;
    localnewest_feeds_req.login_uin = paramLong;
    localnewest_feeds_req.strQua = QUA.getQUA3();
    this.req.mapUinTimes = new HashMap();
    this.req.mapUinTimes.putAll(paramMap);
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.getMsgNewestFeeds";
  }
  
  public JceStruct getReq()
  {
    return this.req;
  }
  
  public int getType()
  {
    return 1000;
  }
  
  public String toString()
  {
    return String.format("reqetuest ,cmd:%d,loginUin;%d,qua;%s,mapUintimes:%s ", new Object[] { Integer.valueOf(this.req.cmd), Long.valueOf(this.req.login_uin), this.req.strQua, String.valueOf(this.req.mapUinTimes) });
  }
  
  public String uniKey()
  {
    return "getMsgNewestFeeds";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneConversationStatusRequest
 * JD-Core Version:    0.7.0.1
 */