package Protocol.MConch;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class d
  extends JceStruct
{
  public int bi = 0;
  public int bk = 0;
  public long bt = 0L;
  public long bu = 0L;
  public int bv = 0;
  
  public JceStruct newInit()
  {
    return new d();
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.bt = paramJceInputStream.read(this.bt, 0, false);
    this.bu = paramJceInputStream.read(this.bu, 1, false);
    this.bk = paramJceInputStream.read(this.bk, 2, false);
    this.bi = paramJceInputStream.read(this.bi, 3, false);
    this.bv = paramJceInputStream.read(this.bv, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.bt != 0L) {
      paramJceOutputStream.write(this.bt, 0);
    }
    if (this.bu != 0L) {
      paramJceOutputStream.write(this.bu, 1);
    }
    if (this.bk != 0) {
      paramJceOutputStream.write(this.bk, 2);
    }
    paramJceOutputStream.write(this.bi, 3);
    if (this.bv != 0) {
      paramJceOutputStream.write(this.bv, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     Protocol.MConch.d
 * JD-Core Version:    0.7.0.1
 */