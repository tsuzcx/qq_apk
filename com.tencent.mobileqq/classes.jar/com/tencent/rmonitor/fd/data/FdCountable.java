package com.tencent.rmonitor.fd.data;

import java.io.Serializable;

public class FdCountable
  implements Serializable
{
  private final int count;
  private final String item;
  
  public FdCountable(String paramString, int paramInt)
  {
    this.item = paramString;
    this.count = paramInt;
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  public String getItem()
  {
    return this.item;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.data.FdCountable
 * JD-Core Version:    0.7.0.1
 */