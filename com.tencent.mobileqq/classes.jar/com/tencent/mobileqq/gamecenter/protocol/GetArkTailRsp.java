package com.tencent.mobileqq.gamecenter.protocol;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetArkTailRsp
  extends JceStruct
{
  static ArrayList<String> cache_icon_list = new ArrayList();
  public String desc = "";
  public String icon = "";
  public ArrayList<String> icon_list;
  public String jump_url = "";
  public int num;
  public int style;
  public int sub_type;
  public String title = "";
  public int type;
  public int value;
  
  static
  {
    cache_icon_list.add("");
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.style = paramJceInputStream.read(this.style, 0, false);
    this.type = paramJceInputStream.read(this.type, 1, false);
    this.sub_type = paramJceInputStream.read(this.sub_type, 2, false);
    this.icon = paramJceInputStream.readString(3, false);
    this.title = paramJceInputStream.readString(4, false);
    this.num = paramJceInputStream.read(this.num, 5, false);
    this.value = paramJceInputStream.read(this.value, 6, false);
    this.icon_list = ((ArrayList)paramJceInputStream.read(cache_icon_list, 7, false));
    this.desc = paramJceInputStream.readString(8, false);
    this.jump_url = paramJceInputStream.readString(9, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.style, 0);
    paramJceOutputStream.write(this.type, 1);
    paramJceOutputStream.write(this.sub_type, 2);
    if (this.icon != null) {
      paramJceOutputStream.write(this.icon, 3);
    }
    if (this.title != null) {
      paramJceOutputStream.write(this.title, 4);
    }
    paramJceOutputStream.write(this.num, 5);
    paramJceOutputStream.write(this.value, 6);
    if (this.icon_list != null) {
      paramJceOutputStream.write(this.icon_list, 7);
    }
    if (this.desc != null) {
      paramJceOutputStream.write(this.desc, 8);
    }
    if (this.jump_url != null) {
      paramJceOutputStream.write(this.jump_url, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.protocol.GetArkTailRsp
 * JD-Core Version:    0.7.0.1
 */