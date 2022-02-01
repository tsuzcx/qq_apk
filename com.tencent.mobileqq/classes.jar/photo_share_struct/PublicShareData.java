package photo_share_struct;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class PublicShareData
  extends JceStruct
{
  public String cover = "";
  public String desc = "";
  public String h5url = "";
  public String schema = "";
  
  public PublicShareData() {}
  
  public PublicShareData(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.cover = paramString1;
    this.desc = paramString2;
    this.h5url = paramString3;
    this.schema = paramString4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cover = paramJceInputStream.readString(0, false);
    this.desc = paramJceInputStream.readString(1, false);
    this.h5url = paramJceInputStream.readString(2, false);
    this.schema = paramJceInputStream.readString(3, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    String str = this.cover;
    if (str != null) {
      paramJceOutputStream.write(str, 0);
    }
    str = this.desc;
    if (str != null) {
      paramJceOutputStream.write(str, 1);
    }
    str = this.h5url;
    if (str != null) {
      paramJceOutputStream.write(str, 2);
    }
    str = this.schema;
    if (str != null) {
      paramJceOutputStream.write(str, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     photo_share_struct.PublicShareData
 * JD-Core Version:    0.7.0.1
 */