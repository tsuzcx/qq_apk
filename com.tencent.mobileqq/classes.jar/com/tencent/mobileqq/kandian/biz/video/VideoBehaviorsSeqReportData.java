package com.tencent.mobileqq.kandian.biz.video;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class VideoBehaviorsSeqReportData
{
  public int a;
  public boolean b;
  public ArrayList<Integer> c;
  
  private String a(ArrayList<Integer> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayList.size() * 2);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Integer localInteger = (Integer)paramArrayList.next();
      if (localInteger != null) {
        localStringBuilder.append(localInteger);
      }
      if (paramArrayList.hasNext()) {
        localStringBuilder.append(",");
      }
    }
    return localStringBuilder.toString();
  }
  
  public boolean a()
  {
    ArrayList localArrayList = this.c;
    if (localArrayList != null) {
      return localArrayList.isEmpty();
    }
    return true;
  }
  
  public void b()
  {
    this.a = -1;
    this.b = false;
    this.c.clear();
  }
  
  public HashMap<String, String> c()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_sceneType", String.valueOf(this.a));
    localHashMap.put("param_indexList", a(this.c));
    localHashMap.put("param_isAutoPlay", String.valueOf(this.b));
    return localHashMap;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("mSceneType: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mIsAutoPlay: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mIndexList: ");
    localStringBuilder.append(a(this.c));
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoBehaviorsSeqReportData
 * JD-Core Version:    0.7.0.1
 */