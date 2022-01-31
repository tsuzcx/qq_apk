package cooperation.qzone;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_req;
import com.qq.taf.jce.JceStruct;

public class QZoneGetPhotoWallRequest
  extends QzoneExternalRequest
{
  public JceStruct a;
  
  public QZoneGetPhotoWallRequest(long paramLong1, long paramLong2, String paramString)
  {
    super.setHostUin(paramLong1);
    super.setLoginUserId(paramLong2);
    mobile_sub_get_photo_wall_req localmobile_sub_get_photo_wall_req = new mobile_sub_get_photo_wall_req();
    localmobile_sub_get_photo_wall_req.uin = paramLong1;
    localmobile_sub_get_photo_wall_req.attachInfo = paramString;
    this.a = localmobile_sub_get_photo_wall_req;
  }
  
  public static JceStruct a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    return decode(paramArrayOfByte, "getPhotoWall");
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.getPhotoWall";
  }
  
  public JceStruct getReq()
  {
    return this.a;
  }
  
  public String uniKey()
  {
    return "getPhotoWall";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.QZoneGetPhotoWallRequest
 * JD-Core Version:    0.7.0.1
 */