package qqwifi.LBS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class Location
  extends JceStruct
{
  public String city = "";
  public String code = "";
  public String district = "";
  public String nation = "";
  public String province = "";
  public String street = "";
  public String town = "";
  public String village = "";
  
  public Location() {}
  
  public Location(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.nation = paramString1;
    this.province = paramString2;
    this.city = paramString3;
    this.district = paramString4;
    this.code = paramString5;
    this.town = paramString6;
    this.village = paramString7;
    this.street = paramString8;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.nation = paramJceInputStream.readString(0, true);
    this.province = paramJceInputStream.readString(1, true);
    this.city = paramJceInputStream.readString(2, true);
    this.district = paramJceInputStream.readString(3, true);
    this.code = paramJceInputStream.readString(4, true);
    this.town = paramJceInputStream.readString(5, true);
    this.village = paramJceInputStream.readString(6, true);
    this.street = paramJceInputStream.readString(7, true);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.nation, 0);
    paramJceOutputStream.write(this.province, 1);
    paramJceOutputStream.write(this.city, 2);
    paramJceOutputStream.write(this.district, 3);
    paramJceOutputStream.write(this.code, 4);
    paramJceOutputStream.write(this.town, 5);
    paramJceOutputStream.write(this.village, 6);
    paramJceOutputStream.write(this.street, 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqwifi.LBS.Location
 * JD-Core Version:    0.7.0.1
 */