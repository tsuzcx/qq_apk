package com.tencent.mobileqq.qqgamepub.data;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

public final class GetArkTailRsp
  extends JceStruct
{
  static ArrayList<String> cache_icon_list = new ArrayList();
  public String desc = "";
  public String icon = "";
  public ArrayList<String> icon_list = null;
  public String jump_url = "";
  public int num = 0;
  public int style = 0;
  public int sub_type = 0;
  public String title = "";
  public int type = 0;
  public int value = 0;
  
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
    Object localObject = this.icon;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 3);
    }
    localObject = this.title;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 4);
    }
    paramJceOutputStream.write(this.num, 5);
    paramJceOutputStream.write(this.value, 6);
    localObject = this.icon_list;
    if (localObject != null) {
      paramJceOutputStream.write((Collection)localObject, 7);
    }
    localObject = this.desc;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 8);
    }
    localObject = this.jump_url;
    if (localObject != null) {
      paramJceOutputStream.write((String)localObject, 9);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.data.GetArkTailRsp
 * JD-Core Version:    0.7.0.1
 */