package photo_share_struct;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class uin_nick_info
  extends JceStruct
{
  public String nick = "";
  public long uin = 0L;
  
  public uin_nick_info() {}
  
  public uin_nick_info(long paramLong, String paramString)
  {
    this.uin = paramLong;
    this.nick = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.nick = paramJceInputStream.readString(1, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    if (this.nick != null) {
      paramJceOutputStream.write(this.nick, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     photo_share_struct.uin_nick_info
 * JD-Core Version:    0.7.0.1
 */