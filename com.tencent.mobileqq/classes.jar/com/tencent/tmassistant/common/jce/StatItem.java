package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class StatItem
  extends JceStruct
{
  static ArrayList<String> cache_records = new ArrayList();
  public ArrayList<String> records = null;
  public int type = 0;
  
  static
  {
    cache_records.add("");
  }
  
  public StatItem() {}
  
  public StatItem(int paramInt, ArrayList<String> paramArrayList)
  {
    this.type = paramInt;
    this.records = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.type = paramJceInputStream.read(this.type, 0, true);
    this.records = ((ArrayList)paramJceInputStream.read(cache_records, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.type, 0);
    paramJceOutputStream.write(this.records, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.StatItem
 * JD-Core Version:    0.7.0.1
 */