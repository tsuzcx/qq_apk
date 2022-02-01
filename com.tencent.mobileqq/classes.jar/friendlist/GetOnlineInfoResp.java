package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetOnlineInfoResp
  extends JceStruct
{
  static int cache_eIconType;
  static int cache_eNetworkType;
  static int cache_result;
  static byte[] cache_vecExtOnlineBusinessInfo;
  static byte[] cache_vecMusicInfo = (byte[])new byte[1];
  static byte[] cache_vecPoiInfo;
  public long dwInterval = 30L;
  public long dwStatus = 20L;
  public long dwUin = 0L;
  public int eIconType = 0;
  public int eNetworkType = 0;
  public short errorCode = 0;
  public int iBatteryStatus = 0;
  public long iTermType = 0L;
  public int result = 0;
  public String strCustomOnlineStatusDesc = "";
  public String strTermDesc = "";
  public long uAbiFlag = 0L;
  public long uExtOnlineStatus = 0L;
  public byte[] vecExtOnlineBusinessInfo = null;
  public byte[] vecMusicInfo = null;
  public byte[] vecPoiInfo = null;
  
  static
  {
    ((byte[])cache_vecMusicInfo)[0] = 0;
    cache_vecPoiInfo = (byte[])new byte[1];
    ((byte[])cache_vecPoiInfo)[0] = 0;
    cache_vecExtOnlineBusinessInfo = (byte[])new byte[1];
    ((byte[])cache_vecExtOnlineBusinessInfo)[0] = 0;
  }
  
  public GetOnlineInfoResp() {}
  
  public GetOnlineInfoResp(int paramInt1, short paramShort, long paramLong1, long paramLong2, long paramLong3, int paramInt2, int paramInt3, long paramLong4, long paramLong5, String paramString1, String paramString2, long paramLong6, int paramInt4, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    this.result = paramInt1;
    this.errorCode = paramShort;
    this.dwStatus = paramLong1;
    this.iTermType = paramLong2;
    this.uAbiFlag = paramLong3;
    this.eNetworkType = paramInt2;
    this.eIconType = paramInt3;
    this.dwInterval = paramLong4;
    this.dwUin = paramLong5;
    this.strTermDesc = paramString1;
    this.strCustomOnlineStatusDesc = paramString2;
    this.uExtOnlineStatus = paramLong6;
    this.iBatteryStatus = paramInt4;
    this.vecMusicInfo = paramArrayOfByte1;
    this.vecPoiInfo = paramArrayOfByte2;
    this.vecExtOnlineBusinessInfo = paramArrayOfByte3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.result = paramJceInputStream.read(this.result, 0, true);
    this.errorCode = paramJceInputStream.read(this.errorCode, 1, true);
    this.dwStatus = paramJceInputStream.read(this.dwStatus, 2, false);
    this.iTermType = paramJceInputStream.read(this.iTermType, 3, false);
    this.uAbiFlag = paramJceInputStream.read(this.uAbiFlag, 4, false);
    this.eNetworkType = paramJceInputStream.read(this.eNetworkType, 5, false);
    this.eIconType = paramJceInputStream.read(this.eIconType, 6, false);
    this.dwInterval = paramJceInputStream.read(this.dwInterval, 7, false);
    this.dwUin = paramJceInputStream.read(this.dwUin, 8, false);
    this.strTermDesc = paramJceInputStream.readString(9, false);
    this.strCustomOnlineStatusDesc = paramJceInputStream.readString(10, false);
    this.uExtOnlineStatus = paramJceInputStream.read(this.uExtOnlineStatus, 11, false);
    this.iBatteryStatus = paramJceInputStream.read(this.iBatteryStatus, 12, false);
    this.vecMusicInfo = ((byte[])paramJceInputStream.read(cache_vecMusicInfo, 13, false));
    this.vecPoiInfo = ((byte[])paramJceInputStream.read(cache_vecPoiInfo, 14, false));
    this.vecExtOnlineBusinessInfo = ((byte[])paramJceInputStream.read(cache_vecExtOnlineBusinessInfo, 15, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.result, 0);
    paramJceOutputStream.write(this.errorCode, 1);
    paramJceOutputStream.write(this.dwStatus, 2);
    paramJceOutputStream.write(this.iTermType, 3);
    paramJceOutputStream.write(this.uAbiFlag, 4);
    paramJceOutputStream.write(this.eNetworkType, 5);
    paramJceOutputStream.write(this.eIconType, 6);
    paramJceOutputStream.write(this.dwInterval, 7);
    paramJceOutputStream.write(this.dwUin, 8);
    Object localObject = this.strTermDesc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
    localObject = this.strCustomOnlineStatusDesc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 10);
    }
    paramJceOutputStream.write(this.uExtOnlineStatus, 11);
    paramJceOutputStream.write(this.iBatteryStatus, 12);
    localObject = this.vecMusicInfo;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 13);
    }
    localObject = this.vecPoiInfo;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 14);
    }
    localObject = this.vecExtOnlineBusinessInfo;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 15);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     friendlist.GetOnlineInfoResp
 * JD-Core Version:    0.7.0.1
 */