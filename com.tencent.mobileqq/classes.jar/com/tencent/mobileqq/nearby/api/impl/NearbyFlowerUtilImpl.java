package com.tencent.mobileqq.nearby.api.impl;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.nearby.api.INearbyFlowerMessage;
import com.tencent.mobileqq.nearby.api.INearbyFlowerUtil;
import com.tencent.mobileqq.nearby.api.NearbyFlowerUtil;
import com.tencent.mobileqq.vip.DownloaderInterface;
import java.util.HashMap;
import java.util.List;

public class NearbyFlowerUtilImpl
  implements INearbyFlowerUtil
{
  public void checkAllPackageStatus(HashMap<String, Integer> paramHashMap)
  {
    NearbyFlowerUtil.a(paramHashMap);
  }
  
  public boolean checkPackageValid(String paramString)
  {
    return NearbyFlowerUtil.c(paramString);
  }
  
  public List<String> getAnimationFrames(String paramString)
  {
    return NearbyFlowerUtil.d(paramString);
  }
  
  public String getDownloadUrl(Object paramObject)
  {
    return NearbyFlowerUtil.a((INearbyFlowerMessage)paramObject);
  }
  
  public DownloaderInterface getDownloader(Object paramObject)
  {
    return NearbyFlowerUtil.a((QQAppInterface)paramObject);
  }
  
  public int getFlowerCount(Object paramObject)
  {
    return NearbyFlowerUtil.b((MessageForStructing)paramObject);
  }
  
  public String getFlowerMsgVersion(Object paramObject)
  {
    return NearbyFlowerMessageImpl.getFlowerMsgVersion((MessageForStructing)paramObject);
  }
  
  public String getGlamourIcon(Context paramContext)
  {
    return NearbyFlowerUtil.a(paramContext);
  }
  
  public int[] getGlamourLevelColors(Context paramContext)
  {
    return NearbyFlowerUtil.b(paramContext);
  }
  
  public String getPackageDownloadPath(String paramString)
  {
    return NearbyFlowerUtil.f(paramString);
  }
  
  public String getPackageStoreFolder(String paramString)
  {
    return NearbyFlowerUtil.e(paramString);
  }
  
  public String getSummaryText(Object paramObject)
  {
    return NearbyFlowerUtil.a((MessageForStructing)paramObject);
  }
  
  public int getTitleBarHeight(Context paramContext)
  {
    return NearbyFlowerUtil.c(paramContext);
  }
  
  public boolean isNearbyFlowerMsg(MessageRecord paramMessageRecord)
  {
    return NearbyFlowerUtil.a(paramMessageRecord);
  }
  
  public Object loadActionData(String paramString)
  {
    return NearbyFlowerUtil.g(paramString);
  }
  
  public void setGlamourIcon(String paramString)
  {
    NearbyFlowerUtil.a(paramString);
  }
  
  public void setGlamourLevelColors(String paramString)
  {
    NearbyFlowerUtil.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.impl.NearbyFlowerUtilImpl
 * JD-Core Version:    0.7.0.1
 */