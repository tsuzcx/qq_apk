package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class ModifyGroupCardReq
  extends JceStruct
{
  static ArrayList cache_vecUinInfo;
  public long dwGroupCode;
  public long dwNewSeq;
  public long dwZero;
  public ArrayList vecUinInfo;
  
  public ModifyGroupCardReq() {}
  
  public ModifyGroupCardReq(long paramLong1, long paramLong2, long paramLong3, ArrayList paramArrayList)
  {
    this.dwZero = paramLong1;
    this.dwGroupCode = paramLong2;
    this.dwNewSeq = paramLong3;
    this.vecUinInfo = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwZero = paramJceInputStream.read(this.dwZero, 0, true);
    this.dwGroupCode = paramJceInputStream.read(this.dwGroupCode, 1, true);
    this.dwNewSeq = paramJceInputStream.read(this.dwNewSeq, 2, true);
    if (cache_vecUinInfo == null)
    {
      cache_vecUinInfo = new ArrayList();
      stUinInfo localstUinInfo = new stUinInfo();
      cache_vecUinInfo.add(localstUinInfo);
    }
    this.vecUinInfo = ((ArrayList)paramJceInputStream.read(cache_vecUinInfo, 3, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwZero, 0);
    paramJceOutputStream.write(this.dwGroupCode, 1);
    paramJceOutputStream.write(this.dwNewSeq, 2);
    paramJceOutputStream.write(this.vecUinInfo, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     friendlist.ModifyGroupCardReq
 * JD-Core Version:    0.7.0.1
 */