package com.tencent.mobileqq.soload;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LoadParam
  implements Serializable
{
  public static int CALL_TYPE_ASYNC;
  public static int CALL_TYPE_ASYNC_BY_SYNC = 2;
  public static int CALL_TYPE_SYNC = 1;
  public int commonFlag;
  public int mCallType = CALL_TYPE_ASYNC;
  public List<LoadParam.LoadItem> mLoadItems = new LinkedList();
  public volatile long mLoadTime;
  public long mReportSeq = 0L;
  
  public static int getItemSize(LoadParam paramLoadParam)
  {
    if ((paramLoadParam == null) || (paramLoadParam.mLoadItems == null)) {
      return 0;
    }
    return paramLoadParam.mLoadItems.size();
  }
  
  public static String getReportStr(LoadParam paramLoadParam)
  {
    if ((paramLoadParam == null) || (paramLoadParam.mLoadItems == null) || (paramLoadParam.mLoadItems.size() <= 0)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("names=");
    paramLoadParam = paramLoadParam.mLoadItems.iterator();
    int i = 1;
    if (paramLoadParam.hasNext())
    {
      LoadParam.LoadItem localLoadItem = (LoadParam.LoadItem)paramLoadParam.next();
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append(localLoadItem.name);
        break;
        localStringBuilder.append("&");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static boolean isCloseReport(LoadParam paramLoadParam)
  {
    if (paramLoadParam == null) {}
    while ((paramLoadParam.commonFlag & 0x20) == 0) {
      return false;
    }
    return true;
  }
  
  public static boolean isCloseRetry(LoadParam paramLoadParam)
  {
    if (paramLoadParam == null) {}
    while ((paramLoadParam.commonFlag & 0x10) == 0) {
      return false;
    }
    return true;
  }
  
  public static boolean isValid(LoadParam paramLoadParam)
  {
    return (paramLoadParam != null) && (paramLoadParam.isValid());
  }
  
  public void addItem(String paramString, LoadOptions paramLoadOptions)
  {
    paramString = new LoadParam.LoadItem(paramString, paramLoadOptions);
    this.mLoadItems.add(paramString);
    int i = this.commonFlag;
    this.commonFlag = (paramString.lops.flag & 0x30 | i);
  }
  
  public boolean isOverTime()
  {
    return Math.abs(NetConnInfoCenter.getServerTimeMillis() - this.mLoadTime) > 180000L;
  }
  
  public boolean isSame(LoadParam paramLoadParam)
  {
    if (paramLoadParam == null) {}
    while ((this.mCallType != paramLoadParam.mCallType) || (paramLoadParam.mLoadItems.size() != this.mLoadItems.size())) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramLoadParam.mLoadItems.size()) {
        break label94;
      }
      LoadParam.LoadItem localLoadItem = (LoadParam.LoadItem)paramLoadParam.mLoadItems.get(i);
      if (!((LoadParam.LoadItem)this.mLoadItems.get(i)).isSame(localLoadItem)) {
        break;
      }
      i += 1;
    }
    label94:
    return true;
  }
  
  boolean isValid()
  {
    if ((this.mLoadItems == null) || (this.mLoadItems.size() <= 0)) {
      return false;
    }
    Iterator localIterator = this.mLoadItems.iterator();
    while (localIterator.hasNext())
    {
      LoadParam.LoadItem localLoadItem = (LoadParam.LoadItem)localIterator.next();
      if ((localLoadItem == null) || (TextUtils.isEmpty(localLoadItem.name)) || (localLoadItem.lops == null)) {
        return false;
      }
    }
    return true;
  }
  
  public String toString()
  {
    return "LoadParam{mCallType=" + this.mCallType + "mLoadItems=" + this.mLoadItems + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.LoadParam
 * JD-Core Version:    0.7.0.1
 */