package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class GetUserAddFriendSettingReq
  extends JceStruct
{
  static byte[] cache_name;
  static byte[] cache_name1;
  static int cache_sourceID;
  static int cache_sourceSubID;
  public byte[] name;
  public byte[] name1;
  public long queryuin;
  public int sourceID = 3999;
  public int sourceSubID = 0;
  public long uin;
  public long version;
  
  public GetUserAddFriendSettingReq() {}
  
  public GetUserAddFriendSettingReq(long paramLong1, long paramLong2, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, long paramLong3, byte[] paramArrayOfByte2)
  {
    this.uin = paramLong1;
    this.queryuin = paramLong2;
    this.sourceID = paramInt1;
    this.sourceSubID = paramInt2;
    this.name = paramArrayOfByte1;
    this.version = paramLong3;
    this.name1 = paramArrayOfByte2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.queryuin = paramJceInputStream.read(this.queryuin, 1, true);
    this.sourceID = paramJceInputStream.read(this.sourceID, 2, false);
    this.sourceSubID = paramJceInputStream.read(this.sourceSubID, 3, false);
    if (cache_name == null)
    {
      cache_name = (byte[])new byte[1];
      ((byte[])cache_name)[0] = 0;
    }
    this.name = ((byte[])paramJceInputStream.read(cache_name, 4, false));
    this.version = paramJceInputStream.read(this.version, 5, false);
    if (cache_name1 == null)
    {
      cache_name1 = (byte[])new byte[1];
      ((byte[])cache_name1)[0] = 0;
    }
    this.name1 = ((byte[])paramJceInputStream.read(cache_name1, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.queryuin, 1);
    paramJceOutputStream.write(this.sourceID, 2);
    paramJceOutputStream.write(this.sourceSubID, 3);
    if (this.name != null) {
      paramJceOutputStream.write(this.name, 4);
    }
    paramJceOutputStream.write(this.version, 5);
    if (this.name1 != null) {
      paramJceOutputStream.write(this.name1, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom2.jar
 * Qualified Name:     friendlist.GetUserAddFriendSettingReq
 * JD-Core Version:    0.7.0.1
 */