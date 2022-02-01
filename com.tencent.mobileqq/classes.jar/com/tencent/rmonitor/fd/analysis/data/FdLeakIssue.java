package com.tencent.rmonitor.fd.analysis.data;

import com.tencent.rmonitor.fd.data.FdCountable;
import java.io.Serializable;
import java.util.List;

public class FdLeakIssue
  implements Serializable
{
  private List<FdCountable> features;
  private final String issueType;
  
  public FdLeakIssue(String paramString)
  {
    this.issueType = paramString;
  }
  
  public List<FdCountable> getFeatures()
  {
    return this.features;
  }
  
  public String getIssueType()
  {
    return this.issueType;
  }
  
  public void setFeatures(List<FdCountable> paramList)
  {
    this.features = paramList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FdAnalyzeResult{fdIssueType='");
    localStringBuilder.append(this.issueType);
    localStringBuilder.append('\'');
    localStringBuilder.append("} ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.analysis.data.FdLeakIssue
 * JD-Core Version:    0.7.0.1
 */