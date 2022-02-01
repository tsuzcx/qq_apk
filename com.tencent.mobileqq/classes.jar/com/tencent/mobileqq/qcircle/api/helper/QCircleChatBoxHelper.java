package com.tencent.mobileqq.qcircle.api.helper;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.identity.Proto2JsonUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQCircleConfigApi;
import com.tencent.mobileqq.qcircle.api.event.QCircleRedInfoEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import qqcircle.QQCircleCounter.PrivateMessage;

public class QCircleChatBoxHelper
{
  private static final String LINK_KEY = "&";
  private static final String TAG = "QCircleChatBoxHelper";
  private static volatile QCircleChatBoxHelper sInstance;
  private final ArrayList<String> mOnlyShowBubbleUinList = QzoneConfig.getQQCircleOnlyShowBubbleUins();
  private volatile Pair<Integer, List<QQCircleCounter.PrivateMessage>> mUnReadInfo;
  private volatile int mUnReadNum;
  private final List<QQCircleCounter.PrivateMessage> mUnReadUinList = new LinkedList();
  
  public QCircleChatBoxHelper()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mOnlyShowBubbleUinList:");
    localStringBuilder.append(this.mOnlyShowBubbleUinList.toString());
    QLog.d("QCircleChatBoxHelper", 1, localStringBuilder.toString());
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
  
  private void loadUnReadInfoFromSp()
  {
    this.mUnReadInfo = new Pair(Integer.valueOf(0), new LinkedList());
    try
    {
      Object localObject = ((IQCircleConfigApi)QRoute.api(IQCircleConfigApi.class)).getQCircleSp();
      if (localObject != null)
      {
        localObject = ((SharedPreferences)localObject).getString("key_qcircle_unread_message_infos", "");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split("&");
          if (localObject.length > 1)
          {
            this.mUnReadNum = Integer.parseInt(localObject[0]);
            localObject = Arrays.asList((Object[])localObject).subList(1, localObject.length).iterator();
            while (((Iterator)localObject).hasNext())
            {
              String str = (String)((Iterator)localObject).next();
              QQCircleCounter.PrivateMessage localPrivateMessage = new QQCircleCounter.PrivateMessage();
              if (Proto2JsonUtil.a(str, localPrivateMessage)) {
                this.mUnReadUinList.add(localPrivateMessage);
              }
            }
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getUnReadMessages from sp:Num");
          ((StringBuilder)localObject).append(this.mUnReadInfo.first);
          QLog.d("QCircleChatBoxHelper", 1, ((StringBuilder)localObject).toString());
          this.mUnReadInfo = new Pair(Integer.valueOf(this.mUnReadNum), this.mUnReadUinList);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("QCircleChatBoxHelper", 1, localException.getMessage());
    }
  }
  
  public static void releaseInstance()
  {
    QLog.e("QCircleChatBoxHelper", 1, "releaseInstance");
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
  
  private void storeUnReadInfo(int paramInt, List<QQCircleCounter.PrivateMessage> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QQCircleCounter.PrivateMessage localPrivateMessage = (QQCircleCounter.PrivateMessage)paramList.next();
      localStringBuilder.append("&");
      localStringBuilder.append(Proto2JsonUtil.a(localPrivateMessage));
    }
    paramList = ((IQCircleConfigApi)QRoute.api(IQCircleConfigApi.class)).getQCircleSp();
    if (paramList != null)
    {
      paramList.edit().putString("key_qcircle_unread_message_infos", localStringBuilder.toString()).apply();
      paramList = new StringBuilder();
      paramList.append("saveUnReadInfo unReadNum:");
      paramList.append(paramInt);
      QLog.d("QCircleChatBoxHelper", 1, paramList.toString());
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
      QLog.d("QCircleChatBoxHelper", 1, "clearUnReadInfo");
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
      this.mUnReadInfo = getUnReadMessages();
    }
    int i = ((List)this.mUnReadInfo.second).size();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getUnReadChatNum unReadNum:");
    localStringBuilder.append(i);
    QLog.d("QCircleChatBoxHelper", 1, localStringBuilder.toString());
    return i;
  }
  
  public Pair<Integer, List<QQCircleCounter.PrivateMessage>> getUnReadMessages()
  {
    try
    {
      if (this.mUnReadInfo != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getUnReadMessages not null return readInfoNum:");
        ((StringBuilder)localObject1).append(this.mUnReadInfo.first);
        QLog.d("QCircleChatBoxHelper", 1, ((StringBuilder)localObject1).toString());
        localObject1 = this.mUnReadInfo;
        return localObject1;
      }
      loadUnReadInfoFromSp();
      Object localObject1 = this.mUnReadInfo;
      return localObject1;
    }
    finally {}
  }
  
  public void insertUnReadMessage(QQCircleCounter.PrivateMessage paramPrivateMessage)
  {
    if (paramPrivateMessage == null) {
      return;
    }
    try
    {
      boolean bool = TextUtils.isEmpty(paramPrivateMessage.uID.get());
      if (bool) {
        return;
      }
      this.mUnReadNum += 1;
      this.mUnReadUinList.add(paramPrivateMessage);
      updateUnReadInfo();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("insertUnReadMessage uin:");
      localStringBuilder.append(paramPrivateMessage.uID.get());
      localStringBuilder.append(",allUnReadNum:");
      localStringBuilder.append(this.mUnReadNum);
      QLog.d("QCircleChatBoxHelper", 1, localStringBuilder.toString());
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.helper.QCircleChatBoxHelper
 * JD-Core Version:    0.7.0.1
 */