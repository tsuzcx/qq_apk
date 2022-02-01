package com.tencent.rmonitor.fd.analysis.analyzers;

import com.tencent.rmonitor.fd.cluser.FdClusterItem;
import java.util.Map;

public class FdFileIoAnalyzer
  extends BaseFdAnalyzer<Map<Integer, FdClusterItem>>
{
  public String a()
  {
    return "files";
  }
  
  protected Map<String, Integer> a(Map<Integer, FdClusterItem> paramMap)
  {
    return ((FdClusterItem)paramMap.get(Integer.valueOf(5))).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.analysis.analyzers.FdFileIoAnalyzer
 * JD-Core Version:    0.7.0.1
 */