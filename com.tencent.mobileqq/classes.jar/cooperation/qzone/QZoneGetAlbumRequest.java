package cooperation.qzone;

import NS_MOBILE_PHOTO.get_album_req;
import NS_MOBILE_PHOTO.get_album_rsp;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.util.ProtocolUtils;

public class QZoneGetAlbumRequest
  extends QzoneExternalRequest
{
  private static final String CMD_STRING = "queryAlbum";
  private static final String PRE_CMD = "QzoneNewService.";
  private static final String TAG = "QZoneQueryAlbumRequest";
  public JceStruct req;
  
  public QZoneGetAlbumRequest(get_album_req paramget_album_req)
  {
    this.req = paramget_album_req;
  }
  
  public QZoneGetAlbumRequest(String paramString, int paramInt, long paramLong)
  {
    this(paramString, paramInt, paramLong, false, false, "");
  }
  
  public QZoneGetAlbumRequest(String paramString1, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2, String paramString2)
  {
    get_album_req localget_album_req = new get_album_req();
    localget_album_req.albumid = paramString1;
    localget_album_req.type = paramInt;
    localget_album_req.owner_uin = paramLong;
    localget_album_req.is_get_url_key = paramBoolean1;
    localget_album_req.is_from_public_url = paramBoolean2;
    localget_album_req.share_key = paramString2;
    this.req = localget_album_req;
  }
  
  public static get_album_rsp onResponse(byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    paramArrayOfByte = ProtocolUtils.decode(paramArrayOfByte, "queryAlbum", paramArrayOfInt);
    if ((paramArrayOfByte instanceof get_album_rsp)) {
      return (get_album_rsp)paramArrayOfByte;
    }
    return null;
  }
  
  public String getCmdString()
  {
    return "QzoneNewService.queryAlbum";
  }
  
  public JceStruct getReq()
  {
    return this.req;
  }
  
  public String uniKey()
  {
    return "queryAlbum";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.QZoneGetAlbumRequest
 * JD-Core Version:    0.7.0.1
 */