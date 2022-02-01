package mqq_qstar;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QStarInfoReq
  extends JceStruct
{
  public int cmd;
  public String mqqver = "";
  public String osver = "";
  public int platform;
  public int seq;
  public long touin;
  public long uin;
  public int ver;
  
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
    if (this.osver != null) {
      paramJceOutputStream.write(this.osver, 4);
    }
    if (this.mqqver != null) {
      paramJceOutputStream.write(this.mqqver, 5);
    }
    paramJceOutputStream.write(this.uin, 6);
    paramJceOutputStream.write(this.touin, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mqq_qstar.QStarInfoReq
 * JD-Core Version:    0.7.0.1
 */