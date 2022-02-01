package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class AnswerAddedFriendResp
  extends JceStruct
{
  static int cache_result;
  public String ErrorString = "";
  public long adduin = 0L;
  public short errorCode = 0;
  public byte myfriendgroupid = 0;
  public int result = 0;
  public long uin = 0L;
  
  public AnswerAddedFriendResp() {}
  
  public AnswerAddedFriendResp(long paramLong1, long paramLong2, byte paramByte, int paramInt, short paramShort, String paramString)
  {
    this.uin = paramLong1;
    this.adduin = paramLong2;
    this.myfriendgroupid = paramByte;
    this.result = paramInt;
    this.errorCode = paramShort;
    this.ErrorString = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.adduin = paramJceInputStream.read(this.adduin, 1, true);
    this.myfriendgroupid = paramJceInputStream.read(this.myfriendgroupid, 2, false);
    this.result = paramJceInputStream.read(this.result, 3, true);
    this.errorCode = paramJceInputStream.read(this.errorCode, 4, false);
    this.ErrorString = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.adduin, 1);
    paramJceOutputStream.write(this.myfriendgroupid, 2);
    paramJceOutputStream.write(this.result, 3);
    paramJceOutputStream.write(this.errorCode, 4);
    String str = this.ErrorString;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     friendlist.AnswerAddedFriendResp
 * JD-Core Version:    0.7.0.1
 */