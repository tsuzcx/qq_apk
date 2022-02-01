package com.tencent.rmonitor.fd.analysis.data;

import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.fd.data.FdBaseResult;
import com.tencent.rmonitor.fd.data.FdCountable;
import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FdLeakIssueResult
  extends FdBaseResult
  implements Serializable
{
  public static final String TAG = "FdLeakResult";
  private final Map<String, List<FdCountable>> fdAnalyzeResult = new HashMap();
  private final int fdCount;
  private List<FdLeakDumpResult> fdDumpList;
  private final int fdType;
  
  public FdLeakIssueResult(int paramInt1, int paramInt2)
  {
    this.fdType = paramInt1;
    this.fdCount = paramInt2;
  }
  
  private void a(String paramString, List<FdCountable> paramList, JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FdCountable localFdCountable = (FdCountable)paramList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put(localFdCountable.getItem(), localFdCountable.getCount());
        localJSONArray.put(localJSONObject);
      }
      paramJSONObject.put(paramString, localJSONArray);
      return;
    }
    catch (JSONException paramString)
    {
      paramList = Logger.b;
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("toJsonString failed: ");
      paramJSONObject.append(paramString.getMessage());
      paramList.e(new String[] { "FdLeakResult", paramJSONObject.toString() });
    }
  }
  
  public void addAnalyzeData(String paramString, List<FdCountable> paramList)
  {
    this.fdAnalyzeResult.put(paramString, paramList);
  }
  
  public Map<String, List<FdCountable>> getFdAnalyzeResult()
  {
    return this.fdAnalyzeResult;
  }
  
  public int getFdCount()
  {
    return this.fdCount;
  }
  
  public List<FdLeakDumpResult> getFdDumpList()
  {
    return this.fdDumpList;
  }
  
  public int getFdType()
  {
    return this.fdType;
  }
  
  public void setFdDumpList(List<FdLeakDumpResult> paramList)
  {
    this.fdDumpList = paramList;
  }
  
  public JSONObject toJsonObject()
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = this.fdAnalyzeResult.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      List localList = (List)this.fdAnalyzeResult.get(str);
      if (localList != null) {
        a(str, localList, localJSONObject);
      }
    }
    return localJSONObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FdLeakIssueResult{fdType=");
    localStringBuilder.append(this.fdType);
    localStringBuilder.append(", fdCount=");
    localStringBuilder.append(this.fdCount);
    localStringBuilder.append(", fdAnalyzeResult=");
    localStringBuilder.append(toJsonObject());
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.analysis.data.FdLeakIssueResult
 * JD-Core Version:    0.7.0.1
 */