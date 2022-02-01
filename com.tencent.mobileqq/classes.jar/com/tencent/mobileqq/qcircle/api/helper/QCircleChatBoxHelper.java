package com.tencent.mobileqq.qcircle.api.helper;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.IQCircleConfigApi;
import com.tencent.mobileqq.qcircle.api.event.QCircleRedInfoEvent;
import com.tencent.mobileqq.qroute.QRoute;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class QCircleChatBoxHelper
{
  private static final String LINK_KEY = "&";
  private static final String TAG = "QCircleChatBoxHelper";
  private static volatile QCircleChatBoxHelper sInstance;
  private final ArrayList<String> mOnlyShowBubbleUinList = QzoneConfig.getQQCircleOnlyShowBubbleUins();
  private volatile Pair<Integer, List<String>> mUnReadInfo;
  private volatile int mUnReadNum;
  private final List<String> mUnReadUinList = new LinkedList();
  
  public QCircleChatBoxHelper()
  {
    int i = RFLog.USR;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mOnlyShowBubbleUinList:");
    localStringBuilder.append(this.mOnlyShowBubbleUinList.toString());
    RFLog.d("QCircleChatBoxHelper", i, localStringBuilder.toString());
  }
  
  public static QCircleChatBoxHelper getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new QCircleChatBoxHelper();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private boolean isOnlyShowBubbleUin(String paramString)
  {
    ArrayList localArrayList = this.mOnlyShowBubbleUinList;
    return (localArrayList != null) && (localArrayList.contains(paramString));
  }
  
  private void loadUnReadInfoFromSp()
  {
    this.mUnReadInfo = new Pair(Integer.valueOf(0), new LinkedList());
    try
    {
      Object localObject = ((IQCircleConfigApi)QRoute.api(IQCircleConfigApi.class)).getQCircleSp();
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).getString("qcircle_unread_message_info", "");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split("&");
          if (localObject.length > 1)
          {
            this.mUnReadNum = Integer.parseInt(localObject[0]);
            this.mUnReadUinList.addAll(Arrays.asList((Object[])localObject).subList(1, localObject.length));
          }
          int i = RFLog.USR;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getUnReadInfo from sp:Num");
          ((StringBuilder)localObject).append(this.mUnReadInfo.first);
          RFLog.d("QCircleChatBoxHelper", i, ((StringBuilder)localObject).toString());
          this.mUnReadInfo = new Pair(Integer.valueOf(this.mUnReadNum), this.mUnReadUinList);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      RFLog.e("QCircleChatBoxHelper", RFLog.USR, localException.getMessage());
    }
  }
  
  public static void releaseInstance()
  {
    RFLog.e("QCircleChatBoxHelper", RFLog.USR, "releaseInstance");
    if (sInstance != null) {
      try
      {
        if (sInstance != null) {
          sInstance = null;
        }
        return;
      }
      finally {}
    }
  }
  
  private void storeUnReadInfo(int paramInt, List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      localStringBuilder.append("&");
      localStringBuilder.append(str);
    }
    paramList = ((IQCircleConfigApi)QRoute.api(IQCircleConfigApi.class)).getQCircleSp();
    if (paramList != null)
    {
      paramList.edit().putString("qcircle_unread_message_info", localStringBuilder.toString()).apply();
      int i = RFLog.USR;
      paramList = new StringBuilder();
      paramList.append("saveUnReadInfo unReadNum:");
      paramList.append(paramInt);
      RFLog.d("QCircleChatBoxHelper", i, paramList.toString());
    }
  }
  
  private void updateUnReadInfo()
  {
    this.mUnReadInfo = new Pair(Integer.valueOf(this.mUnReadNum), this.mUnReadUinList);
    storeUnReadInfo(this.mUnReadNum, this.mUnReadUinList);
  }
  
  public void clearUnReadInfo()
  {
    try
    {
      RFLog.d("QCircleChatBoxHelper", RFLog.USR, "clearUnReadInfo");
      this.mUnReadNum = 0;
      this.mUnReadUinList.clear();
      updateUnReadInfo();
      SimpleEventBus.getInstance().dispatchEvent(new QCircleRedInfoEvent("QCircleChatBoxHelper clearUnReadInfo", true));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getUnReadChatNum()
  {
    if (this.mUnReadInfo == null) {
      this.mUnReadInfo = getUnReadInfo();
    }
    Object localObject = (List)this.mUnReadInfo.second;
    int i = ((List)localObject).size();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (isOnlyShowBubbleUin((String)((Iterator)localObject).next())) {
        i -= 1;
      }
    }
    int j = RFLog.USR;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getUnReadChatNum unReadNum:");
    ((StringBuilder)localObject).append(i);
    RFLog.d("QCircleChatBoxHelper", j, ((StringBuilder)localObject).toString());
    return i;
  }
  
  public Pair<Integer, List<String>> getUnReadInfo()
  {
    try
    {
      if (this.mUnReadInfo != null)
      {
        int i = RFLog.USR;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getUnReadInfo not null return readInfoNum:");
        ((StringBuilder)localObject1).append(this.mUnReadInfo.first);
        RFLog.d("QCircleChatBoxHelper", i, ((StringBuilder)localObject1).toString());
        localObject1 = this.mUnReadInfo;
        return localObject1;
      }
      loadUnReadInfoFromSp();
      Object localObject1 = this.mUnReadInfo;
      return localObject1;
    }
    finally {}
  }
  
  public void insertUnReadMessage(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      this.mUnReadNum += 1;
      this.mUnReadUinList.add(paramString);
      updateUnReadInfo();
      int i = RFLog.USR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("insertUnReadMessage uin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",allUnReadNum:");
      localStringBuilder.append(this.mUnReadNum);
      RFLog.d("QCircleChatBoxHelper", i, localStringBuilder.toString());
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.helper.QCircleChatBoxHelper
 * JD-Core Version:    0.7.0.1
 */