package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class stUinInfo
  extends JceStruct
{
  public byte cGender;
  public long dwFlag;
  public long dwuin;
  public String sEmail = "";
  public String sName = "";
  public String sPhone = "";
  public String sRemark = "";
  
  public stUinInfo() {}
  
  public stUinInfo(long paramLong1, long paramLong2, String paramString1, byte paramByte, String paramString2, String paramString3, String paramString4)
  {
    this.dwuin = paramLong1;
    this.dwFlag = paramLong2;
    this.sName = paramString1;
    this.cGender = paramByte;
    this.sPhone = paramString2;
    this.sEmail = paramString3;
    this.sRemark = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.dwuin = paramJceInputStream.read(this.dwuin, 0, true);
    this.dwFlag = paramJceInputStream.read(this.dwFlag, 1, true);
    this.sName = paramJceInputStream.readString(2, true);
    this.cGender = paramJceInputStream.read(this.cGender, 3, true);
    this.sPhone = paramJceInputStream.readString(4, true);
    this.sEmail = paramJceInputStream.readString(5, true);
    this.sRemark = paramJceInputStream.readString(6, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.dwuin, 0);
    paramJceOutputStream.write(this.dwFlag, 1);
    paramJceOutputStream.write(this.sName, 2);
    paramJceOutputStream.write(this.cGender, 3);
    paramJceOutputStream.write(this.sPhone, 4);
    paramJceOutputStream.write(this.sEmail, 5);
    paramJceOutputStream.write(this.sRemark, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\acom2.jar
 * Qualified Name:     friendlist.stUinInfo
 * JD-Core Version:    0.7.0.1
 */