package com.tencent.mobileqq.qzonealbumreddot;

import NS_MOBILE_PHOTO.operation_red_touch_req;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QzoneExternalRequest;

public class QzoneAlbumRedTouchRequest
  extends QzoneExternalRequest
{
  public JceStruct a;
  
  public QzoneAlbumRedTouchRequest(long paramLong, operation_red_touch_req paramoperation_red_touch_req)
  {
    super.setHostUin(paramLong);
    super.setLoginUserId(paramLong);
    this.a = paramoperation_red_touch_req;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.asy_photo.OperationRedTouch";
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public String uniKey()
  {
    return "OperationRedTouch";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qzonealbumreddot.QzoneAlbumRedTouchRequest
 * JD-Core Version:    0.7.0.1
 */