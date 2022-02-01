package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DynamicChannelConfig
{
  private HashMap<String, String> a = new HashMap();
  private List<DynamicChannelConfig.HeadData> b = new ArrayList();
  private HashMap<String, String> c = new HashMap();
  
  public int a()
  {
    return this.b.size();
  }
  
  public DynamicChannelConfig.HeadData a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.b.size())) {
      return (DynamicChannelConfig.HeadData)this.b.get(paramInt);
    }
    return null;
  }
  
  public String a(int paramInt, String paramString)
  {
    DynamicChannelConfig.HeadData localHeadData = a(paramInt);
    if ((localHeadData != null) && (!TextUtils.isEmpty(paramString)))
    {
      if ("style_ID".equalsIgnoreCase(paramString)) {
        return localHeadData.a;
      }
      return (String)localHeadData.c.get(paramString);
    }
    return "";
  }
  
  public String a(String paramString)
  {
    return (String)this.a.get(paramString);
  }
  
  public String b(String paramString)
  {
    return (String)this.c.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.DynamicChannelConfig
 * JD-Core Version:    0.7.0.1
 */