package mqq_qstar;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QStarInfoReq
  extends JceStruct
{
  public int cmd = 0;
  public String mqqver = "";
  public String osver = "";
  public int platform = 0;
  public int seq = 0;
  public long touin = 0L;
  public long uin = 0L;
  public int ver = 0;
  
  public QStarInfoReq() {}
  
  public QStarInfoReq(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    this.ver = paramInt1;
    this.seq = paramInt2;
    this.cmd = paramInt3;
    this.platform = paramInt4;
    this.osver = paramString1;
    this.mqqver = paramString2;
    this.uin = paramLong1;
    this.touin = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ver = paramJceInputStream.read(this.ver, 0, false);
    this.seq = paramJceInputStream.read(this.seq, 1, false);
    this.cmd = paramJceInputStream.read(this.cmd, 2, false);
    this.platform = paramJceInputStream.read(this.platform, 3, false);
    this.osver = paramJceInputStream.readString(4, false);
    this.mqqver = paramJceInputStream.readString(5, false);
    this.uin = paramJceInputStream.read(this.uin, 6, false);
    this.touin = paramJceInputStream.read(this.touin, 7, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ver, 0);
    paramJceOutputStream.write(this.seq, 1);
    paramJceOutputStream.write(this.cmd, 2);
    paramJceOutputStream.write(this.platform, 3);
    String str = this.osver;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    str = this.mqqver;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
    paramJceOutputStream.write(this.uin, 6);
    paramJceOutputStream.write(this.touin, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mqq_qstar.QStarInfoReq
 * JD-Core Version:    0.7.0.1
 */