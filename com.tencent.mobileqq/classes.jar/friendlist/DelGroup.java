package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class DelGroup
  extends JceStruct
{
  public byte cGroupId;
  
  public DelGroup() {}
  
  public DelGroup(byte paramByte)
  {
    this.cGroupId = paramByte;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cGroupId = paramJceInputStream.read(this.cGroupId, 0, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cGroupId, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom2.jar
 * Qualified Name:     friendlist.DelGroup
 * JD-Core Version:    0.7.0.1
 */