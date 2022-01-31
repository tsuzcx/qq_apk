package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class StatReportRequest
  extends JceStruct
{
  static ArrayList<StatItem> a = new ArrayList();
  public ArrayList<StatItem> data = null;
  
  static
  {
    StatItem localStatItem = new StatItem();
    a.add(localStatItem);
  }
  
  public StatReportRequest() {}
  
  public StatReportRequest(ArrayList<StatItem> paramArrayList)
  {
    this.data = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.data = ((ArrayList)paramJceInputStream.read(a, 0, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.data, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.StatReportRequest
 * JD-Core Version:    0.7.0.1
 */