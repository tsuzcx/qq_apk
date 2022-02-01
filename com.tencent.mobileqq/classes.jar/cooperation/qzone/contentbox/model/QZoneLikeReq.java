package cooperation.qzone.contentbox.model;

import NS_MOBILE_OPERATION.operation_like_req;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.QZoneCommonRequest;

public class QZoneLikeReq
  extends QZoneCommonRequest
{
  public static final int ACTION_LIKE = 0;
  public static final int ACTION_UNLIKE = 1;
  private static final String CMD = "like";
  public JceStruct req;
  private int type;
  
  public QZoneLikeReq(Long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    operation_like_req localoperation_like_req = new operation_like_req();
    localoperation_like_req.uin = paramLong.longValue();
    localoperation_like_req.action = paramInt1;
    localoperation_like_req.appid = paramInt2;
    localoperation_like_req.curkey = paramString1;
    localoperation_like_req.unikey = paramString2;
    this.req = localoperation_like_req;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.like";
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
    return "like";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.contentbox.model.QZoneLikeReq
 * JD-Core Version:    0.7.0.1
 */