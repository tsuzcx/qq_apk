package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetFriendsVideoAbiResp
  extends JceStruct
{
  static ArrayList<UserVideoAbi> cache_finfo;
  static int cache_result;
  public short errorCode;
  public ArrayList<UserVideoAbi> finfo;
  public int result;
  public long uin;
  
  public GetFriendsVideoAbiResp() {}
  
  public GetFriendsVideoAbiResp(long paramLong, ArrayList<UserVideoAbi> paramArrayList, int paramInt, short paramShort)
  {
    this.uin = paramLong;
    this.finfo = paramArrayList;
    this.result = paramInt;
    this.errorCode = paramShort;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    if (cache_finfo == null)
    {
      cache_finfo = new ArrayList();
      UserVideoAbi localUserVideoAbi = new UserVideoAbi();
      cache_finfo.add(localUserVideoAbi);
    }
    this.finfo = ((ArrayList)paramJceInputStream.read(cache_finfo, 1, true));
    this.result = paramJceInputStream.read(this.result, 2, true);
    this.errorCode = paramJceInputStream.read(this.errorCode, 3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.finfo, 1);
    paramJceOutputStream.write(this.result, 2);
    paramJceOutputStream.write(this.errorCode, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     friendlist.GetFriendsVideoAbiResp
 * JD-Core Version:    0.7.0.1
 */