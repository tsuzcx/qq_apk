package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AddFriendResp
  extends JceStruct
{
  static int cache_adduinsetting;
  static byte[] cache_name;
  static byte[] cache_name1;
  static int cache_result;
  static byte[] cache_sig = (byte[])new byte[1];
  static byte[] cache_verify;
  public String ErrorString = "";
  public long adduin = 0L;
  public int adduinsetting = 0;
  public short errorCode = 0;
  public byte myAllowFlag = 0;
  public byte myfriendgroupid = 0;
  public byte[] name = null;
  public byte[] name1 = null;
  public int result = 0;
  public byte[] sig = null;
  public long uin = 0L;
  public byte[] verify = null;
  
  static
  {
    ((byte[])cache_sig)[0] = 0;
    cache_name = (byte[])new byte[1];
    ((byte[])cache_name)[0] = 0;
    cache_name1 = (byte[])new byte[1];
    ((byte[])cache_name1)[0] = 0;
    cache_verify = (byte[])new byte[1];
    ((byte[])cache_verify)[0] = 0;
  }
  
  public AddFriendResp() {}
  
  public AddFriendResp(long paramLong1, long paramLong2, int paramInt1, byte paramByte1, byte paramByte2, int paramInt2, short paramShort, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    this.uin = paramLong1;
    this.adduin = paramLong2;
    this.adduinsetting = paramInt1;
    this.myAllowFlag = paramByte1;
    this.myfriendgroupid = paramByte2;
    this.result = paramInt2;
    this.errorCode = paramShort;
    this.ErrorString = paramString;
    this.sig = paramArrayOfByte1;
    this.name = paramArrayOfByte2;
    this.name1 = paramArrayOfByte3;
    this.verify = paramArrayOfByte4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.adduin = paramJceInputStream.read(this.adduin, 1, true);
    this.adduinsetting = paramJceInputStream.read(this.adduinsetting, 2, true);
    this.myAllowFlag = paramJceInputStream.read(this.myAllowFlag, 3, true);
    this.myfriendgroupid = paramJceInputStream.read(this.myfriendgroupid, 4, true);
    this.result = paramJceInputStream.read(this.result, 6, true);
    this.errorCode = paramJceInputStream.read(this.errorCode, 7, false);
    this.ErrorString = paramJceInputStream.readString(8, false);
    this.sig = ((byte[])paramJceInputStream.read(cache_sig, 9, false));
    this.name = ((byte[])paramJceInputStream.read(cache_name, 10, false));
    this.name1 = ((byte[])paramJceInputStream.read(cache_name1, 11, false));
    this.verify = ((byte[])paramJceInputStream.read(cache_verify, 12, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.adduin, 1);
    paramJceOutputStream.write(this.adduinsetting, 2);
    paramJceOutputStream.write(this.myAllowFlag, 3);
    paramJceOutputStream.write(this.myfriendgroupid, 4);
    paramJceOutputStream.write(this.result, 6);
    paramJceOutputStream.write(this.errorCode, 7);
    Object localObject = this.ErrorString;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    localObject = this.sig;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 9);
    }
    localObject = this.name;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 10);
    }
    localObject = this.name1;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 11);
    }
    localObject = this.verify;
    if (localObject != null) {
      paramJceOutputStream.write((byte[])localObject, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     friendlist.AddFriendResp
 * JD-Core Version:    0.7.0.1
 */