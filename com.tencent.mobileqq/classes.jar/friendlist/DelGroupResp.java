package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DelGroupResp
  extends JceStruct
{
  public byte cGroupid = 0;
  public long dwSequence = 0L;
  public long dwToUin = 0L;
  
  public DelGroupResp() {}
  
  public DelGroupResp(long paramLong1, long paramLong2, byte paramByte)
  {
    this.dwToUin = paramLong1;
    this.dwSequence = paramLong2;
    this.cGroupid = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwToUin = paramJceInputStream.read(this.dwToUin, 0, true);
    this.dwSequence = paramJceInputStream.read(this.dwSequence, 1, true);
    this.cGroupid = paramJceInputStream.read(this.cGroupid, 3, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwToUin, 0);
    paramJceOutputStream.write(this.dwSequence, 1);
    paramJceOutputStream.write(this.cGroupid, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     friendlist.DelGroupResp
 * JD-Core Version:    0.7.0.1
 */