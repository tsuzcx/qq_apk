package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class NewQqCenterConfig
  extends JceStruct
{
  static Map<String, String> cache_appNewsUrlMap;
  static ArrayList<String> cache_enterOldViaList = new ArrayList();
  public Map<String, String> appNewsUrlMap = null;
  public int detailSwitch = 0;
  public ArrayList<String> enterOldViaList = null;
  public int entranceSwitch = 0;
  
  static
  {
    cache_enterOldViaList.add("");
    cache_appNewsUrlMap = new HashMap();
    cache_appNewsUrlMap.put("", "");
  }
  
  public NewQqCenterConfig() {}
  
  public NewQqCenterConfig(int paramInt1, int paramInt2, ArrayList<String> paramArrayList, Map<String, String> paramMap)
  {
    this.detailSwitch = paramInt1;
    this.entranceSwitch = paramInt2;
    this.enterOldViaList = paramArrayList;
    this.appNewsUrlMap = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.detailSwitch = paramJceInputStream.read(this.detailSwitch, 0, true);
    this.entranceSwitch = paramJceInputStream.read(this.entranceSwitch, 1, true);
    this.enterOldViaList = ((ArrayList)paramJceInputStream.read(cache_enterOldViaList, 2, false));
    this.appNewsUrlMap = ((Map)paramJceInputStream.read(cache_appNewsUrlMap, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.detailSwitch, 0);
    paramJceOutputStream.write(this.entranceSwitch, 1);
    if (this.enterOldViaList != null) {
      paramJceOutputStream.write(this.enterOldViaList, 2);
    }
    if (this.appNewsUrlMap != null) {
      paramJceOutputStream.write(this.appNewsUrlMap, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.NewQqCenterConfig
 * JD-Core Version:    0.7.0.1
 */