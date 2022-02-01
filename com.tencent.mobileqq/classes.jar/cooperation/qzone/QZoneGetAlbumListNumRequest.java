package cooperation.qzone;

import NS_MOBILE_PHOTO.get_albumlist_num_req;
import NS_MOBILE_PHOTO.get_albumlist_num_rsp;
import com.qq.taf.jce.JceStruct;

public class QZoneGetAlbumListNumRequest
  extends QzoneExternalRequest
{
  public static final String CMD_STRING = "getAlbumListNum";
  private static final String CMD_STRING_BUFFER = "QzoneNewService.getAlbumListNum";
  public static final String KEY_GET_ALBUM_LIST_NUM = "getAlbumListNum";
  private static final String unikey = "getAlbumListNum";
  public JceStruct req;
  
  public QZoneGetAlbumListNumRequest(long paramLong, String paramString)
  {
    super.setRefer(paramString);
    super.setHostUin(paramLong);
    super.setLoginUserId(paramLong);
    paramString = new get_albumlist_num_req();
    paramString.uin = paramLong;
    this.req = paramString;
  }
  
  public static get_albumlist_num_rsp onResponse(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    paramArrayOfByte = (get_albumlist_num_rsp)QzoneExternalRequest.decode(paramArrayOfByte, "getAlbumListNum");
    if (paramArrayOfByte == null) {
      return null;
    }
    return paramArrayOfByte;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.getAlbumListNum";
  }
  
  public JceStruct getReq()
  {
    return this.req;
  }
  
  public String uniKey()
  {
    return "getAlbumListNum";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.QZoneGetAlbumListNumRequest
 * JD-Core Version:    0.7.0.1
 */