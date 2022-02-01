package com.tencent.mobileqq.soload.biz.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LoadParam
  implements Serializable
{
  public static int CALL_TYPE_ASYNC = 0;
  public static int CALL_TYPE_ASYNC_BY_SYNC = 2;
  public static int CALL_TYPE_SYNC = 1;
  private static final long OVER_TIME_DEFAULT = 180000L;
  public int commonFlag = 0;
  public int mCallType = CALL_TYPE_ASYNC;
  public ClassLoader mClassLoader;
  public List<LoadParam.LoadItem> mLoadItems = new LinkedList();
  public volatile long mLoadTime;
  public long mReportSeq = 0L;
  
  public static int getItemSize(LoadParam paramLoadParam)
  {
    if (paramLoadParam != null)
    {
      paramLoadParam = paramLoadParam.mLoadItems;
      if (paramLoadParam != null) {
        return paramLoadParam.size();
      }
    }
    return 0;
  }
  
  public static String getReportStr(LoadParam paramLoadParam)
  {
    if (paramLoadParam != null)
    {
      Object localObject = paramLoadParam.mLoadItems;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = new StringBuilder("names=");
        int i = 1;
        paramLoadParam = paramLoadParam.mLoadItems.iterator();
        while (paramLoadParam.hasNext())
        {
          LoadParam.LoadItem localLoadItem = (LoadParam.LoadItem)paramLoadParam.next();
          if (i != 0) {
            i = 0;
          } else {
            ((StringBuilder)localObject).append("&");
          }
          ((StringBuilder)localObject).append(localLoadItem.name);
        }
        return ((StringBuilder)localObject).toString();
      }
    }
    return null;
  }
  
  public static boolean isCloseReport(LoadParam paramLoadParam)
  {
    boolean bool = false;
    if (paramLoadParam == null) {
      return false;
    }
    if ((paramLoadParam.commonFlag & 0x20) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isCloseRetry(LoadParam paramLoadParam)
  {
    boolean bool = false;
    if (paramLoadParam == null) {
      return false;
    }
    if ((paramLoadParam.commonFlag & 0x10) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isValid(LoadParam paramLoadParam)
  {
    return (paramLoadParam != null) && (paramLoadParam.isValid());
  }
  
  public void addItem(String paramString, LoadOptions paramLoadOptions)
  {
    paramString = new LoadParam.LoadItem(paramString, paramLoadOptions);
    this.mLoadItems.add(paramString);
    this.commonFlag |= paramString.lops.flag & 0x30;
  }
  
  public boolean isOverTime()
  {
    return Math.abs(NetConnInfoCenter.getServerTimeMillis() - this.mLoadTime) > 180000L;
  }
  
  public boolean isSame(LoadParam paramLoadParam)
  {
    if (paramLoadParam == null) {
      return false;
    }
    if (this.mCallType != paramLoadParam.mCallType) {
      return false;
    }
    if (paramLoadParam.mLoadItems.size() != this.mLoadItems.size()) {
      return false;
    }
    int i = 0;
    while (i < paramLoadParam.mLoadItems.size())
    {
      LoadParam.LoadItem localLoadItem = (LoadParam.LoadItem)paramLoadParam.mLoadItems.get(i);
      if (!((LoadParam.LoadItem)this.mLoadItems.get(i)).isSame(localLoadItem)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  boolean isValid()
  {
    Object localObject = this.mLoadItems;
    if (localObject != null)
    {
      if (((List)localObject).size() <= 0) {
        return false;
      }
      localObject = this.mLoadItems.iterator();
      while (((Iterator)localObject).hasNext())
      {
        LoadParam.LoadItem localLoadItem = (LoadParam.LoadItem)((Iterator)localObject).next();
        if ((localLoadItem == null) || (TextUtils.isEmpty(localLoadItem.name)) || (localLoadItem.lops == null)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LoadParam{mCallType=");
    localStringBuilder.append(this.mCallType);
    localStringBuilder.append("mLoadItems=");
    localStringBuilder.append(this.mLoadItems);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.biz.entity.LoadParam
 * JD-Core Version:    0.7.0.1
 */