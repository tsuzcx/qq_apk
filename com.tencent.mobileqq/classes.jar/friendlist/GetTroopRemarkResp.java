package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetTroopRemarkResp
  extends JceStruct
{
  static int cache_result;
  static ArrayList<stTroopRemarkInfo> cache_vecTroopRemark;
  public long GroupCode;
  public long GroupUin;
  public long NextUin;
  public long Seq;
  public short errorCode;
  public int result;
  public long uin;
  public ArrayList<stTroopRemarkInfo> vecTroopRemark;
  
  public GetTroopRemarkResp() {}
  
  public GetTroopRemarkResp(long paramLong1, long paramLong2, long paramLong3, long paramLong4, ArrayList<stTroopRemarkInfo> paramArrayList, long paramLong5, int paramInt, short paramShort)
  {
    this.uin = paramLong1;
    this.GroupCode = paramLong2;
    this.GroupUin = paramLong3;
    this.Seq = paramLong4;
    this.vecTroopRemark = paramArrayList;
    this.NextUin = paramLong5;
    this.result = paramInt;
    this.errorCode = paramShort;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, true);
    this.GroupCode = paramJceInputStream.read(this.GroupCode, 1, true);
    this.GroupUin = paramJceInputStream.read(this.GroupUin, 2, true);
    this.Seq = paramJceInputStream.read(this.Seq, 3, true);
    if (cache_vecTroopRemark == null)
    {
      cache_vecTroopRemark = new ArrayList();
      stTroopRemarkInfo localstTroopRemarkInfo = new stTroopRemarkInfo();
      cache_vecTroopRemark.add(localstTroopRemarkInfo);
    }
    this.vecTroopRemark = ((ArrayList)paramJceInputStream.read(cache_vecTroopRemark, 4, true));
    this.NextUin = paramJceInputStream.read(this.NextUin, 5, true);
    this.result = paramJceInputStream.read(this.result, 6, true);
    this.errorCode = paramJceInputStream.read(this.errorCode, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    paramJceOutputStream.write(this.GroupCode, 1);
    paramJceOutputStream.write(this.GroupUin, 2);
    paramJceOutputStream.write(this.Seq, 3);
    paramJceOutputStream.write(this.vecTroopRemark, 4);
    paramJceOutputStream.write(this.NextUin, 5);
    paramJceOutputStream.write(this.result, 6);
    paramJceOutputStream.write(this.errorCode, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     friendlist.GetTroopRemarkResp
 * JD-Core Version:    0.7.0.1
 */