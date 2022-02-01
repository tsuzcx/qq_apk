package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class FriendListSubSrvRspCode
  extends JceStruct
{
  public short wGetIntimateInfoRspCode = 0;
  public short wGetMutualMarkRspCode = 0;
  
  public FriendListSubSrvRspCode() {}
  
  public FriendListSubSrvRspCode(short paramShort1, short paramShort2)
  {
    this.wGetMutualMarkRspCode = paramShort1;
    this.wGetIntimateInfoRspCode = paramShort2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.wGetMutualMarkRspCode = paramJceInputStream.read(this.wGetMutualMarkRspCode, 0, false);
    this.wGetIntimateInfoRspCode = paramJceInputStream.read(this.wGetIntimateInfoRspCode, 1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.wGetMutualMarkRspCode, 0);
    paramJceOutputStream.write(this.wGetIntimateInfoRspCode, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     friendlist.FriendListSubSrvRspCode
 * JD-Core Version:    0.7.0.1
 */