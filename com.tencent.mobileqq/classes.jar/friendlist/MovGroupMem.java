package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class MovGroupMem
  extends JceStruct
{
  public byte Ver;
  public byte cGroupid;
  public long dwUin;
  public short wReqLen;
  public short wReserveLen;
  
  public MovGroupMem() {}
  
  public MovGroupMem(byte paramByte1, short paramShort1, long paramLong, byte paramByte2, short paramShort2)
  {
    this.Ver = paramByte1;
    this.wReqLen = paramShort1;
    this.dwUin = paramLong;
    this.cGroupid = paramByte2;
    this.wReserveLen = paramShort2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.Ver = paramJceInputStream.read(this.Ver, 0, true);
    this.wReqLen = paramJceInputStream.read(this.wReqLen, 1, true);
    this.dwUin = paramJceInputStream.read(this.dwUin, 2, true);
    this.cGroupid = paramJceInputStream.read(this.cGroupid, 3, true);
    this.wReserveLen = paramJceInputStream.read(this.wReserveLen, 4, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.Ver, 0);
    paramJceOutputStream.write(this.wReqLen, 1);
    paramJceOutputStream.write(this.dwUin, 2);
    paramJceOutputStream.write(this.cGroupid, 3);
    paramJceOutputStream.write(this.wReserveLen, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom2.jar
 * Qualified Name:     friendlist.MovGroupMem
 * JD-Core Version:    0.7.0.1
 */