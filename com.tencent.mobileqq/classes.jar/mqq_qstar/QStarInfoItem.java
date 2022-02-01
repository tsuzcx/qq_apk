package mqq_qstar;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class QStarInfoItem
  extends JceStruct
{
  public String headurl = "";
  public int level = 0;
  public String levelurl = "";
  public String name = "";
  public long starid = 0L;
  public int totalexp = 0;
  
  public QStarInfoItem() {}
  
  public QStarInfoItem(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    this.starid = paramLong;
    this.name = paramString1;
    this.level = paramInt1;
    this.totalexp = paramInt2;
    this.headurl = paramString2;
    this.levelurl = paramString3;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.starid = paramJceInputStream.read(this.starid, 0, false);
    this.name = paramJceInputStream.readString(1, false);
    this.level = paramJceInputStream.read(this.level, 2, false);
    this.totalexp = paramJceInputStream.read(this.totalexp, 3, false);
    this.headurl = paramJceInputStream.readString(4, false);
    this.levelurl = paramJceInputStream.readString(5, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.starid, 0);
    String str = this.name;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    paramJceOutputStream.write(this.level, 2);
    paramJceOutputStream.write(this.totalexp, 3);
    str = this.headurl;
    if (str != null) {
      paramJceOutputStream.write(str, 4);
    }
    str = this.levelurl;
    if (str != null) {
      paramJceOutputStream.write(str, 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     mqq_qstar.QStarInfoItem
 * JD-Core Version:    0.7.0.1
 */