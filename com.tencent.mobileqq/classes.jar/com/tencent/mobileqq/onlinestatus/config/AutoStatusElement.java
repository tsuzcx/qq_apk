package com.tencent.mobileqq.onlinestatus.config;

import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class AutoStatusElement
{
  public List<AutoStatusItem> a = null;
  public OnlineStatusItem b = null;
  public String c = "";
  public List<WeatherUrl> d = null;
  public OnlineStatusItem e = null;
  
  public AutoStatusElement() {}
  
  public AutoStatusElement(List<AutoStatusItem> paramList, OnlineStatusItem paramOnlineStatusItem1, List<WeatherUrl> paramList1, String paramString, OnlineStatusItem paramOnlineStatusItem2)
  {
    this.a = paramList;
    this.b = paramOnlineStatusItem1;
    this.d = paramList1;
    this.c = paramString;
    this.e = paramOnlineStatusItem2;
  }
  
  public List<AutoStatusItem> a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.a;
    if (localObject == null) {
      return localArrayList;
    }
    if (paramBoolean)
    {
      localArrayList.addAll((Collection)localObject);
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      AutoStatusItem localAutoStatusItem = (AutoStatusItem)((Iterator)localObject).next();
      if (!localAutoStatusItem.r) {
        localArrayList.add(localAutoStatusItem);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.config.AutoStatusElement
 * JD-Core Version:    0.7.0.1
 */