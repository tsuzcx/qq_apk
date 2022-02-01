package com.tencent.mobileqq.filemanager.core;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileIPv6StrateyController$IPListInfo
{
  public int a = 0;
  public List<FileIPv6StrateyController.IPInfo> b = new ArrayList();
  
  public boolean a()
  {
    List localList = this.b;
    return (localList == null) || (localList.size() == 0);
  }
  
  public String toString()
  {
    if (a())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("TPType:");
      ((StringBuilder)localObject1).append(this.a);
      ((StringBuilder)localObject1).append("IPList:");
      return ((StringBuilder)localObject1).toString();
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TPType:");
    ((StringBuilder)localObject1).append(this.a);
    ((StringBuilder)localObject1).append("IPList:");
    localObject1 = ((StringBuilder)localObject1).toString();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (FileIPv6StrateyController.IPInfo)localIterator.next();
      if (localObject2 != null)
      {
        if (!TextUtils.isEmpty(((FileIPv6StrateyController.IPInfo)localObject2).a))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(((FileIPv6StrateyController.IPInfo)localObject2).a);
          localStringBuilder.append(":");
          localStringBuilder.append(((FileIPv6StrateyController.IPInfo)localObject2).b);
          localStringBuilder.append(" ");
          localObject2 = localStringBuilder.toString();
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(":");
          localStringBuilder.append(((FileIPv6StrateyController.IPInfo)localObject2).b);
          localStringBuilder.append(" ");
          localObject2 = localStringBuilder.toString();
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append((String)localObject2);
        localObject1 = localStringBuilder.toString();
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.IPListInfo
 * JD-Core Version:    0.7.0.1
 */