package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetSimpleOnlineFriendInfoResp
  extends JceStruct
{
  static int cache_result;
  static ArrayList cache_vecFriendInfo;
  public byte cShowPcIcon;
  public short errorCode;
  public byte intervalTimeMin;
  public int result;
  public short shClickInterval = 30;
  public long uin;
  public ArrayList vecFriendInfo;
  
  public GetSimpleOnlineFriendInfoResp() {}
  
  public GetSimpleOnlineFriendInfoResp(long paramLong, ArrayList paramArrayList, int paramInt, short paramShort1, byte paramByte1, byte paramByte2, short paramShort2)
  {
    this.uin = paramLong;
    this.vecFriendInfo = paramArrayList;
    this.result = paramInt;
    this.errorCode = paramShort1;
    this.intervalTimeMin = paramByte1;
    this.cShowPcIcon = paramByte2;
    this.shClickInterval = paramShort2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    if (cache_vecFriendInfo == null)
    {
      cache_vecFriendInfo = new ArrayList();
      SimpleOnlineFriendInfo localSimpleOnlineFriendInfo = new SimpleOnlineFriendInfo();
      cache_vecFriendInfo.add(localSimpleOnlineFriendInfo);
    }
    this.vecFriendInfo = ((ArrayList)paramJceInputStream.read(cache_vecFriendInfo, 1, true));
    this.result = paramJceInputStream.read(this.result, 2, true);
    this.errorCode = paramJceInputStream.read(this.errorCode, 3, false);
    this.intervalTimeMin = paramJceInputStream.read(this.intervalTimeMin, 4, false);
    this.cShowPcIcon = paramJceInputStream.read(this.cShowPcIcon, 5, false);
    this.shClickInterval = paramJceInputStream.read(this.shClickInterval, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.vecFriendInfo, 1);
    paramJceOutputStream.write(this.result, 2);
    paramJceOutputStream.write(this.errorCode, 3);
    paramJceOutputStream.write(this.intervalTimeMin, 4);
    paramJceOutputStream.write(this.cShowPcIcon, 5);
    paramJceOutputStream.write(this.shClickInterval, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom2.jar
 * Qualified Name:     friendlist.GetSimpleOnlineFriendInfoResp
 * JD-Core Version:    0.7.0.1
 */