package com.tencent.mobileqq.flashshow.helper;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.flashshow.api.data.FSRedPointData;
import com.tencent.mobileqq.flashshow.util.FSProtoUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import qflash.QFlashBadge.QFlashBadgeInfo;

public class FSTempRedPointHelper
{
  private static final String TAG = "FSTempRedPointHelper";
  private static volatile FSTempRedPointHelper mInstance;
  private final QFlashBadge.QFlashBadgeInfo mCacheBottomRedPointInfo = new QFlashBadge.QFlashBadgeInfo();
  private final List<QFlashBadge.QFlashBadgeInfo> mCacheTabRedPointInfos = new CopyOnWriteArrayList();
  private boolean mIsBottomRedPointValid;
  private final Object mLock = new Object();
  private Map<String, String> mTransSchemeMap = new HashMap();
  
  public static FSTempRedPointHelper getInstance()
  {
    if (mInstance == null) {
      try
      {
        if (mInstance == null) {
          mInstance = new FSTempRedPointHelper();
        }
      }
      finally {}
    }
    return mInstance;
  }
  
  private void saveTransScheme(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    String str = Uri.parse(paramString).getQueryParameter("sourcetype");
    if (TextUtils.isEmpty(str)) {
      return;
    }
    this.mTransSchemeMap.put(str, paramString);
  }
  
  public byte[] getBottomRedPointInfo()
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (this.mCacheBottomRedPointInfo != null)
        {
          byte[] arrayOfByte = this.mCacheBottomRedPointInfo.toByteArray();
          return arrayOfByte;
        }
      }
      Object localObject2 = null;
    }
  }
  
  public List<byte[]> getTabRedPointInfo()
  {
    synchronized (this.mLock)
    {
      List localList = FSProtoUtil.a(this.mCacheTabRedPointInfos);
      return localList;
    }
  }
  
  public String getTransScheme(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str = (String)this.mTransSchemeMap.get(paramString);
    this.mTransSchemeMap.put(paramString, "");
    return str;
  }
  
  public boolean isBottomRedPointValid()
  {
    return this.mIsBottomRedPointValid;
  }
  
  public void saveBottomRedPointInfo(FSRedPointData paramFSRedPointData)
  {
    Object localObject = this.mLock;
    if (paramFSRedPointData != null) {}
    try
    {
      if (paramFSRedPointData.getBadgeInfoByte() != null)
      {
        this.mIsBottomRedPointValid = true;
        this.mCacheBottomRedPointInfo.set(FSProtoUtil.a(paramFSRedPointData.getBadgeInfoByte()));
        saveTransScheme(paramFSRedPointData.getDisplayInfoJumpLink());
        return;
      }
      return;
    }
    finally {}
  }
  
  public void saveTabRedPointInfos(List<FSRedPointData> paramList)
  {
    synchronized (this.mLock)
    {
      this.mCacheTabRedPointInfos.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FSRedPointData localFSRedPointData = (FSRedPointData)paramList.next();
        if (localFSRedPointData.getBadgeInfoByte() != null) {
          this.mCacheTabRedPointInfos.add(FSProtoUtil.a(localFSRedPointData.getBadgeInfoByte()));
        }
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void setBottomRedPointValid(boolean paramBoolean)
  {
    this.mIsBottomRedPointValid = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.helper.FSTempRedPointHelper
 * JD-Core Version:    0.7.0.1
 */