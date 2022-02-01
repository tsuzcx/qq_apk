package photo_share_struct;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class client_attr
  extends JceStruct
{
  static int cache_action = 0;
  static uin_attr cache_attr = new uin_attr();
  public int action = 0;
  public uin_attr attr = null;
  public long gender = 0L;
  public String qq_nick = "";
  public long uin = 0L;
  
  public client_attr() {}
  
  public client_attr(long paramLong1, uin_attr paramuin_attr, String paramString, int paramInt, long paramLong2)
  {
    this.uin = paramLong1;
    this.attr = paramuin_attr;
    this.qq_nick = paramString;
    this.action = paramInt;
    this.gender = paramLong2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uin = paramJceInputStream.read(this.uin, 0, false);
    this.attr = ((uin_attr)paramJceInputStream.read(cache_attr, 1, false));
    this.qq_nick = paramJceInputStream.readString(2, false);
    this.action = paramJceInputStream.read(this.action, 3, false);
    this.gender = paramJceInputStream.read(this.gender, 4, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uin, 0);
    Object localObject = this.attr;
    if (localObject != null) {
      paramJceOutputStream.write((JceStruct)localObject, 1);
    }
    localObject = this.qq_nick;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 2);
    }
    paramJceOutputStream.write(this.action, 3);
    paramJceOutputStream.write(this.gender, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     photo_share_struct.client_attr
 * JD-Core Version:    0.7.0.1
 */