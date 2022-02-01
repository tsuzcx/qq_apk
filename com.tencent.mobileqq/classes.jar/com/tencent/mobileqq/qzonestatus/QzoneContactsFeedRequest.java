package com.tencent.mobileqq.qzonestatus;

import NS_MOBILE_NEWEST_FEEDS.newest_feeds_req;
import NS_MOBILE_NEWEST_FEEDS.newest_feeds_rsp;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;

public class QzoneContactsFeedRequest
  extends QzoneExternalRequest
{
  public JceStruct a;
  
  public QzoneContactsFeedRequest(newest_feeds_req paramnewest_feeds_req)
  {
    super.setHostUin(paramnewest_feeds_req.login_uin);
    super.setLoginUserId(paramnewest_feeds_req.login_uin);
    this.a = paramnewest_feeds_req;
  }
  
  public static newest_feeds_rsp a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    paramArrayOfByte = (newest_feeds_rsp)decode(paramArrayOfByte, "getAIONewestFeeds");
    if (paramArrayOfByte == null) {
      return null;
    }
    return paramArrayOfByte;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.getAIONewestFeeds";
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public String uniKey()
  {
    return "getAIONewestFeeds";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qzonestatus.QzoneContactsFeedRequest
 * JD-Core Version:    0.7.0.1
 */