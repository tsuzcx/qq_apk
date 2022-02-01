package com.tencent.mobileqq.troop.redpoint;

import java.io.Serializable;

public class RedPointItem
  implements Serializable
{
  public int redId;
  public int unReadNum;
  
  public RedPointItem(int paramInt1, int paramInt2)
  {
    this.redId = paramInt1;
    this.unReadNum = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.RedPointItem
 * JD-Core Version:    0.7.0.1
 */