package com.tencent.mobileqq.campuscircle;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CampusCircleManager$CampusTopicReq
  implements Serializable, Cloneable
{
  public static final int SATE_SENDING_PUBLISHINFO = 3;
  public static final int SATE_SEND_CANCEL = 6;
  public static final int SATE_SEND_FAIL = 5;
  public static final int SATE_SEND_NONE = 0;
  public static final int SATE_SEND_START = 1;
  public static final int SATE_SEND_SUC = 4;
  public static final int SATE_UPLOADING_PIC = 2;
  public int anonymousFlag;
  public String content = "";
  public int currSendState = 0;
  public int feedType;
  public long key = System.currentTimeMillis() + (Math.random() * 10000.0D);
  public int lastSendState = 0;
  public List picInfos = new ArrayList();
  public int publicityTopicId;
  public int retryCnt = -1;
  public String uin = "";
  
  public boolean checkEqual(CampusTopicReq paramCampusTopicReq)
  {
    boolean bool2 = false;
    int i;
    if ((paramCampusTopicReq != null) && (this.uin.equals(paramCampusTopicReq.uin)) && (this.feedType == paramCampusTopicReq.feedType) && (this.content.equals(paramCampusTopicReq.content)) && (this.anonymousFlag == paramCampusTopicReq.anonymousFlag) && (this.picInfos.size() == paramCampusTopicReq.picInfos.size()))
    {
      i = 0;
      if (i >= this.picInfos.size()) {
        break label232;
      }
      CampusCircleManager.PicInfo localPicInfo1 = (CampusCircleManager.PicInfo)this.picInfos.get(i);
      CampusCircleManager.PicInfo localPicInfo2 = (CampusCircleManager.PicInfo)paramCampusTopicReq.picInfos.get(i);
      bool1 = bool2;
      if (!TextUtils.isEmpty(localPicInfo1.path))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(localPicInfo2.path)) {
          if (localPicInfo1.path.equals(localPicInfo2.path)) {
            break label217;
          }
        }
      }
    }
    label217:
    label232:
    for (boolean bool1 = bool2;; bool1 = true)
    {
      bool2 = bool1;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CampusCircleManager", 2, "CampusTopicReq.checkEqual, result=" + bool2 + ",checkPicInfosEqual" + bool1);
        }
        return bool2;
        i += 1;
        break;
        bool2 = false;
        bool1 = true;
      }
    }
  }
  
  protected Object clone()
  {
    return (CampusTopicReq)super.clone();
  }
  
  public String getStringLog(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\nCampusTopicReq");
    localStringBuilder.append("\n |-").append("key:").append(this.key);
    localStringBuilder.append("\n |-").append("currSendState:").append(this.currSendState);
    localStringBuilder.append("\n |-").append("lastSendState:").append(this.lastSendState);
    localStringBuilder.append("\n |-").append("uin:").append(this.uin);
    localStringBuilder.append("\n |-").append("feedType:").append(this.feedType);
    localStringBuilder.append("\n |-").append("retryCnt:").append(this.retryCnt);
    localStringBuilder.append("\n |-").append("anonymousFlag:").append(this.anonymousFlag);
    localStringBuilder.append("\n |-").append("picInfos:").append(this.picInfos.size());
    if (paramBoolean)
    {
      Iterator localIterator = this.picInfos.iterator();
      while (localIterator.hasNext()) {
        ((CampusCircleManager.PicInfo)localIterator.next()).toString();
      }
    }
    return localStringBuilder.toString();
  }
  
  public boolean isPicsUrlReady()
  {
    Iterator localIterator = this.picInfos.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!TextUtils.isEmpty(((CampusCircleManager.PicInfo)localIterator.next()).url));
    for (boolean bool = false;; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleManager", 2, "CampusTopicReq.isPicsUrlReady, isDone=" + bool);
      }
      return bool;
    }
  }
  
  public void updatePicInfo(String paramString1, String paramString2)
  {
    int j = 0;
    int i = j;
    if (!TextUtils.isEmpty(paramString1))
    {
      i = j;
      if (!TextUtils.isEmpty(paramString2))
      {
        Iterator localIterator = this.picInfos.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          CampusCircleManager.PicInfo localPicInfo = (CampusCircleManager.PicInfo)localIterator.next();
          if (!paramString2.equals(localPicInfo.md5)) {
            break label133;
          }
          localPicInfo.url = paramString1;
          i += 1;
        }
      }
    }
    label133:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("CampusCircleManager", 2, "CampusTopicReq.updatePicInfo, md5=" + paramString2 + ",url=" + paramString1 + ",updateCnt=" + i);
      }
      return;
    }
  }
  
  public void updateState(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CampusCircleManager", 2, "CampusTopicReq.updateState, key=" + this.key + ",currSendState=" + this.currSendState + ",currSendState=" + this.currSendState);
    }
    this.lastSendState = this.currSendState;
    this.currSendState = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.CampusCircleManager.CampusTopicReq
 * JD-Core Version:    0.7.0.1
 */