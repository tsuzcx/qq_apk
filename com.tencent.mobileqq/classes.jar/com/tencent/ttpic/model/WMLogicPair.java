package com.tencent.ttpic.model;

public class WMLogicPair
  implements Comparable<WMLogicPair>
{
  public String key;
  public String value;
  
  public WMLogicPair(String paramString1, String paramString2)
  {
    this.key = paramString1;
    this.value = paramString2;
  }
  
  public int compareTo(WMLogicPair paramWMLogicPair)
  {
    if (Integer.parseInt(this.key) > Integer.parseInt(paramWMLogicPair.key)) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.model.WMLogicPair
 * JD-Core Version:    0.7.0.1
 */