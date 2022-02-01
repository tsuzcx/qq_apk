package com.tencent.mobileqq.troop.avatar;

import java.util.List;

public class UploadItem
{
  public String a;
  public List<String> b;
  public boolean c;
  public int d;
  public int e = 0;
  public long f;
  public String g;
  
  public String a(int paramInt)
  {
    List localList = this.b;
    if ((localList != null) && (localList.size() != 0))
    {
      if (paramInt < this.b.size()) {
        return (String)this.b.get(paramInt);
      }
      localList = this.b;
      return (String)localList.get(localList.size() - 1);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.UploadItem
 * JD-Core Version:    0.7.0.1
 */