package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class RenameGroup
  extends JceStruct
{
  public byte cGroupId = 0;
  public byte cLen = 0;
  public String sGroupName = "";
  
  public RenameGroup() {}
  
  public RenameGroup(byte paramByte1, byte paramByte2, String paramString)
  {
    this.cGroupId = paramByte1;
    this.cLen = paramByte2;
    this.sGroupName = paramString;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cGroupId = paramJceInputStream.read(this.cGroupId, 0, true);
    this.cLen = paramJceInputStream.read(this.cLen, 1, true);
    this.sGroupName = paramJceInputStream.readString(2, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cGroupId, 0);
    paramJceOutputStream.write(this.cLen, 1);
    paramJceOutputStream.write(this.sGroupName, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     friendlist.RenameGroup
 * JD-Core Version:    0.7.0.1
 */