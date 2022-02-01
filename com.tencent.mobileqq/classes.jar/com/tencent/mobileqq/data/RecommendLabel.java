package com.tencent.mobileqq.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecommendLabel
  implements Serializable
{
  public String bytes_name = null;
  public int edging_color;
  public int text_color;
  public int uint32_label_type;
  
  public static List<RecommendLabel> convertToRecommendLabel(List<? extends RecommendLabel> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return localArrayList;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add((RecommendLabel)paramList.next());
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.RecommendLabel
 * JD-Core Version:    0.7.0.1
 */