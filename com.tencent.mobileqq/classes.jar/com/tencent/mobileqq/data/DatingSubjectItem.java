package com.tencent.mobileqq.data;

import java.io.Serializable;

public class DatingSubjectItem
  implements Serializable
{
  public int deadline;
  public String errMsg;
  public int id;
  public String name;
  
  public DatingSubjectItem(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    this.id = paramInt1;
    this.name = paramString1;
    this.deadline = paramInt2;
    this.errMsg = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.DatingSubjectItem
 * JD-Core Version:    0.7.0.1
 */