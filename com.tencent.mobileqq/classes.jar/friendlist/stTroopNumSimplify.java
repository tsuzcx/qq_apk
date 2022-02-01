package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stTroopNumSimplify
  extends JceStruct
{
  public long GroupCode = 0L;
  public long dwGroupFlagExt = 0L;
  public long dwGroupInfoExtSeq = 0L;
  public long dwGroupInfoSeq = 0L;
  public long dwGroupRankSeq = 0L;
  
  public stTroopNumSimplify() {}
  
  public stTroopNumSimplify(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    this.GroupCode = paramLong1;
    this.dwGroupInfoSeq = paramLong2;
    this.dwGroupFlagExt = paramLong3;
    this.dwGroupRankSeq = paramLong4;
    this.dwGroupInfoExtSeq = paramLong5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.GroupCode = paramJceInputStream.read(this.GroupCode, 0, true);
    this.dwGroupInfoSeq = paramJceInputStream.read(this.dwGroupInfoSeq, 1, false);
    this.dwGroupFlagExt = paramJceInputStream.read(this.dwGroupFlagExt, 2, false);
    this.dwGroupRankSeq = paramJceInputStream.read(this.dwGroupRankSeq, 3, false);
    this.dwGroupInfoExtSeq = paramJceInputStream.read(this.dwGroupInfoExtSeq, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.GroupCode, 0);
    paramJceOutputStream.write(this.dwGroupInfoSeq, 1);
    paramJceOutputStream.write(this.dwGroupFlagExt, 2);
    paramJceOutputStream.write(this.dwGroupRankSeq, 3);
    paramJceOutputStream.write(this.dwGroupInfoExtSeq, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     friendlist.stTroopNumSimplify
 * JD-Core Version:    0.7.0.1
 */