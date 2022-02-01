package com.tencent.tmassistant.common.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class GetHalleyUrlRsp
  extends JceStruct
{
  static Map<String, ArrayList<String>> cache_resultMap = new HashMap();
  public Map<String, ArrayList<String>> resultMap = null;
  public int ret = 0;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("");
    cache_resultMap.put("", localArrayList);
  }
  
  public GetHalleyUrlRsp() {}
  
  public GetHalleyUrlRsp(int paramInt, Map<String, ArrayList<String>> paramMap)
  {
    this.ret = paramInt;
    this.resultMap = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.resultMap = ((Map)paramJceInputStream.read(cache_resultMap, 1, true));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.resultMap, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistant.common.jce.GetHalleyUrlRsp
 * JD-Core Version:    0.7.0.1
 */