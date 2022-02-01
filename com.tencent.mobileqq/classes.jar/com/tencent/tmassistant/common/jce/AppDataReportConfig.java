package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class AppDataReportConfig
  extends JceStruct
{
  static Map<String, AppExtInfoParam> cache_mapSpecialPkgs = new HashMap();
  public int frequency = 0;
  public Map<String, AppExtInfoParam> mapSpecialPkgs = null;
  
  static
  {
    AppExtInfoParam localAppExtInfoParam = new AppExtInfoParam();
    cache_mapSpecialPkgs.put("", localAppExtInfoParam);
  }
  
  public AppDataReportConfig() {}
  
  public AppDataReportConfig(int paramInt, Map<String, AppExtInfoParam> paramMap)
  {
    this.frequency = paramInt;
    this.mapSpecialPkgs = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.frequency = paramJceInputStream.read(this.frequency, 0, false);
    this.mapSpecialPkgs = ((Map)paramJceInputStream.read(cache_mapSpecialPkgs, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.frequency, 0);
    if (this.mapSpecialPkgs != null) {
      paramJceOutputStream.write(this.mapSpecialPkgs, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.AppDataReportConfig
 * JD-Core Version:    0.7.0.1
 */