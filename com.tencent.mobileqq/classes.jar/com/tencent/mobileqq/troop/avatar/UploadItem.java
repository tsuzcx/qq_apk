package com.tencent.mobileqq.troop.avatar;

import java.util.List;

public class UploadItem
{
  public int a;
  public long a;
  public String a;
  public List<String> a;
  public boolean a;
  public int b = 0;
  public String b;
  
  public String a(int paramInt)
  {
    List localList = this.a;
    if ((localList != null) && (localList.size() != 0))
    {
      if (paramInt < this.a.size()) {
        return (String)this.a.get(paramInt);
      }
      localList = this.a;
      return (String)localList.get(localList.size() - 1);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.avatar.UploadItem
 * JD-Core Version:    0.7.0.1
 */