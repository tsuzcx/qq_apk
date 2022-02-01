package com.tencent.rmonitor.fd.analysis.analyzers;

import com.tencent.rmonitor.fd.cluser.FdClusterItem;
import java.util.Map;

public class FdOtherAnalyzer
  extends BaseFdAnalyzer<Map<Integer, FdClusterItem>>
{
  public String a()
  {
    return "others";
  }
  
  protected Map<String, Integer> a(Map<Integer, FdClusterItem> paramMap)
  {
    return ((FdClusterItem)paramMap.get(Integer.valueOf(6))).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.analysis.analyzers.FdOtherAnalyzer
 * JD-Core Version:    0.7.0.1
 */