package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stLevelRankPair
  extends JceStruct
{
  public long dwLevel = 0L;
  public String strRank = "";
  
  public stLevelRankPair() {}
  
  public stLevelRankPair(long paramLong, String paramString)
  {
    this.dwLevel = paramLong;
    this.strRank = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwLevel = paramJceInputStream.read(this.dwLevel, 0, false);
    this.strRank = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwLevel, 0);
    String str = this.strRank;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     friendlist.stLevelRankPair
 * JD-Core Version:    0.7.0.1
 */