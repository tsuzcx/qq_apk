package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class DataLineMsgSet
  implements Cloneable
{
  public static String TAG = "dataline.DataLineMsgSet";
  private int groupId = 0;
  private int groupType = 0;
  public boolean isReportPause = false;
  private ArrayList<DataLineMsgRecord> mComeList = new ArrayList();
  private long mFirstArriveTime = 0L;
  private DataLineMsgRecord mFirstCome = null;
  private boolean mIsNewCome = false;
  private boolean mIsPaused = false;
  private long mLastArriveTime = 0L;
  private DataLineMsgRecord[] mSet = null;
  public long mUpdateMutiViewTick = 0L;
  public long mUpdateProcessTick = 0L;
  private long nFirstId = 0L;
  private long nLastId = 0L;
  
  public DataLineMsgSet(int paramInt)
  {
    this.groupId = paramInt;
  }
  
  public static boolean isCanReciveOrResend(DataLineMsgRecord paramDataLineMsgRecord)
  {
    if ((paramDataLineMsgRecord.issuc) && (paramDataLineMsgRecord.fileMsgStatus != 1L))
    {
      if (paramDataLineMsgRecord.fileMsgStatus == 2L) {
        return true;
      }
      return (paramDataLineMsgRecord.progress == 1.0F) && (paramDataLineMsgRecord.issuc) && ((TextUtils.isEmpty(paramDataLineMsgRecord.path)) || (!FileUtil.b(paramDataLineMsgRecord.path)));
    }
    return true;
  }
  
  public static boolean isCanceled(DataLineMsgRecord paramDataLineMsgRecord)
  {
    return (paramDataLineMsgRecord != null) && (paramDataLineMsgRecord.fileMsgStatus == 2L);
  }
  
  public static boolean isCompleted(DataLineMsgRecord paramDataLineMsgRecord)
  {
    return (paramDataLineMsgRecord != null) && (paramDataLineMsgRecord.issuc) && (paramDataLineMsgRecord.progress == 1.0F) && (paramDataLineMsgRecord.fileMsgStatus == 0L);
  }
  
  public static boolean isFileType(DataLineMsgRecord paramDataLineMsgRecord)
  {
    return (paramDataLineMsgRecord.msgtype == -2000) || (paramDataLineMsgRecord.msgtype == -2005) || (paramDataLineMsgRecord.msgtype == -2009) || (paramDataLineMsgRecord.msgtype == -2335);
  }
  
  public static boolean isSingle(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (paramInt2 != 0)
    {
      if (paramInt1 != 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static boolean isSingle(DataLineMsgRecord paramDataLineMsgRecord)
  {
    return (paramDataLineMsgRecord.groupId == 0) || (paramDataLineMsgRecord.msgtype == -2005) || (paramDataLineMsgRecord.msgtype == -2009);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof DataLineMsgSet)) {
      return false;
    }
    paramObject = (DataLineMsgSet)paramObject;
    if (paramObject.getTotalCount() != getTotalCount()) {
      return false;
    }
    if (paramObject.isSingle())
    {
      if (paramObject.mSet[0].sessionid != this.mSet[0].sessionid) {
        return false;
      }
    }
    else if (paramObject.getGroupId() != getGroupId()) {
      return false;
    }
    return true;
  }
  
  public DataLineMsgRecord getAt(int paramInt)
  {
    return this.mSet[paramInt];
  }
  
  public int getComeCount()
  {
    DataLineMsgRecord[] arrayOfDataLineMsgRecord = this.mSet;
    int m = arrayOfDataLineMsgRecord.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (arrayOfDataLineMsgRecord[i] != null) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public int getCompletedCount()
  {
    DataLineMsgRecord[] arrayOfDataLineMsgRecord = this.mSet;
    int m = arrayOfDataLineMsgRecord.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      DataLineMsgRecord localDataLineMsgRecord = arrayOfDataLineMsgRecord[i];
      k = j;
      if (localDataLineMsgRecord != null)
      {
        k = j;
        if (localDataLineMsgRecord.issuc)
        {
          k = j;
          if (localDataLineMsgRecord.progress == 1.0F) {
            k = j + 1;
          }
        }
      }
      i += 1;
    }
    return j;
  }
  
  public String getFileNames()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      localObject = this.mSet;
      if (i >= localObject.length - 1) {
        break;
      }
      localObject = localObject[i];
      if (localObject != null)
      {
        localStringBuilder.append(((DataLineMsgRecord)localObject).filename);
        localStringBuilder.append("、");
      }
      i += 1;
    }
    Object localObject = localObject[(localObject.length - 1)];
    if (localObject != null) {
      localStringBuilder.append(((DataLineMsgRecord)localObject).filename);
    }
    return localStringBuilder.toString();
  }
  
  public long getFileTotalSize()
  {
    DataLineMsgRecord[] arrayOfDataLineMsgRecord = this.mSet;
    int j = arrayOfDataLineMsgRecord.length;
    long l1 = 0L;
    int i = 0;
    while (i < j)
    {
      DataLineMsgRecord localDataLineMsgRecord = arrayOfDataLineMsgRecord[i];
      long l2 = l1;
      if (localDataLineMsgRecord != null) {
        l2 = l1 + localDataLineMsgRecord.filesize;
      }
      i += 1;
      l1 = l2;
    }
    return l1;
  }
  
  public long getFirstId()
  {
    return this.nFirstId;
  }
  
  public DataLineMsgRecord getFirstItem()
  {
    DataLineMsgRecord[] arrayOfDataLineMsgRecord = this.mSet;
    int j = arrayOfDataLineMsgRecord.length;
    int i = 0;
    while (i < j)
    {
      DataLineMsgRecord localDataLineMsgRecord = arrayOfDataLineMsgRecord[i];
      if (localDataLineMsgRecord != null) {
        return localDataLineMsgRecord;
      }
      i += 1;
    }
    return null;
  }
  
  public int getGroupId()
  {
    return this.groupId;
  }
  
  public int getGroupType()
  {
    return this.groupType;
  }
  
  public DataLineMsgRecord getItemBySessionId(long paramLong)
  {
    DataLineMsgRecord[] arrayOfDataLineMsgRecord = this.mSet;
    int j = arrayOfDataLineMsgRecord.length;
    int i = 0;
    while (i < j)
    {
      DataLineMsgRecord localDataLineMsgRecord = arrayOfDataLineMsgRecord[i];
      if ((localDataLineMsgRecord != null) && (localDataLineMsgRecord.sessionid == paramLong)) {
        return localDataLineMsgRecord;
      }
      i += 1;
    }
    return null;
  }
  
  public long getLastId()
  {
    return this.nLastId;
  }
  
  public DataLineMsgRecord getLastItem()
  {
    int i = this.mSet.length - 1;
    while (i >= 0)
    {
      DataLineMsgRecord localDataLineMsgRecord = this.mSet[i];
      if (localDataLineMsgRecord != null) {
        return localDataLineMsgRecord;
      }
      i -= 1;
    }
    return null;
  }
  
  public long getMsgId()
  {
    return this.mFirstCome.msgId;
  }
  
  public int getOpType()
  {
    return this.mFirstCome.nOpType;
  }
  
  public long getTime()
  {
    return this.mFirstArriveTime;
  }
  
  public int getTotalCount()
  {
    return this.mSet.length;
  }
  
  public float getTotalProcess()
  {
    DataLineMsgRecord[] arrayOfDataLineMsgRecord = this.mSet;
    int j = arrayOfDataLineMsgRecord.length;
    int i = 0;
    float f2;
    for (float f1 = 0.0F; i < j; f1 = f2)
    {
      DataLineMsgRecord localDataLineMsgRecord = arrayOfDataLineMsgRecord[i];
      f2 = f1;
      if (localDataLineMsgRecord != null)
      {
        f2 = f1;
        if (localDataLineMsgRecord.issuc)
        {
          f2 = f1;
          if (localDataLineMsgRecord.fileMsgStatus == 0L) {
            f2 = f1 + localDataLineMsgRecord.progress;
          }
        }
      }
      i += 1;
    }
    if (getTotalCount() == 0) {
      return 0.0F;
    }
    return f1 / getTotalCount();
  }
  
  public boolean hasFailed()
  {
    DataLineMsgRecord[] arrayOfDataLineMsgRecord = this.mSet;
    int j = arrayOfDataLineMsgRecord.length;
    int i = 0;
    while (i < j)
    {
      DataLineMsgRecord localDataLineMsgRecord = arrayOfDataLineMsgRecord[i];
      if ((localDataLineMsgRecord == null) && (isTimeOut())) {
        return true;
      }
      if ((localDataLineMsgRecord != null) && (!localDataLineMsgRecord.issuc) && (localDataLineMsgRecord.fileMsgStatus != 1L)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean hasSendingOrRecving()
  {
    DataLineMsgRecord[] arrayOfDataLineMsgRecord = this.mSet;
    int j = arrayOfDataLineMsgRecord.length;
    int i = 0;
    while (i < j)
    {
      DataLineMsgRecord localDataLineMsgRecord = arrayOfDataLineMsgRecord[i];
      if ((localDataLineMsgRecord != null) && (localDataLineMsgRecord.issuc) && (localDataLineMsgRecord.progress != 1.0F) && (localDataLineMsgRecord.fileMsgStatus != 1L) && (localDataLineMsgRecord.fileMsgStatus != 2L)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean hasWaiting()
  {
    DataLineMsgRecord[] arrayOfDataLineMsgRecord = this.mSet;
    int j = arrayOfDataLineMsgRecord.length;
    int i = 0;
    while (i < j)
    {
      if ((arrayOfDataLineMsgRecord[i] == null) && (!isTimeOut())) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean isAllCompleted()
  {
    DataLineMsgRecord[] arrayOfDataLineMsgRecord = this.mSet;
    int j = arrayOfDataLineMsgRecord.length;
    boolean bool2 = false;
    int i = 0;
    while (i < j)
    {
      DataLineMsgRecord localDataLineMsgRecord = arrayOfDataLineMsgRecord[i];
      bool1 = bool2;
      if (localDataLineMsgRecord == null) {
        return bool1;
      }
      if ((localDataLineMsgRecord.issuc) && (localDataLineMsgRecord.progress != 1.0F)) {
        return false;
      }
      i += 1;
    }
    boolean bool1 = true;
    return bool1;
  }
  
  public boolean isCanReciveOrResend()
  {
    Iterator localIterator = values().iterator();
    while (localIterator.hasNext())
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)localIterator.next();
      if ((!localDataLineMsgRecord.issuc) || (localDataLineMsgRecord.fileMsgStatus == 1L) || (localDataLineMsgRecord.fileMsgStatus == 2L)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isCanceled()
  {
    DataLineMsgRecord[] arrayOfDataLineMsgRecord = this.mSet;
    int k = arrayOfDataLineMsgRecord.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      DataLineMsgRecord localDataLineMsgRecord = arrayOfDataLineMsgRecord[i];
      if (isCanceled(localDataLineMsgRecord)) {
        j += 1;
      } else if (((localDataLineMsgRecord == null) || (localDataLineMsgRecord.fileMsgStatus != 1L)) && (!isCompleted(localDataLineMsgRecord))) {
        return false;
      }
      i += 1;
    }
    return j > 0;
  }
  
  public boolean isFileComing()
  {
    DataLineMsgRecord[] arrayOfDataLineMsgRecord = this.mSet;
    int j = arrayOfDataLineMsgRecord.length;
    int i = 0;
    while (i < j)
    {
      DataLineMsgRecord localDataLineMsgRecord = arrayOfDataLineMsgRecord[i];
      if ((localDataLineMsgRecord == null) && (isTimeOut())) {
        return false;
      }
      if ((localDataLineMsgRecord != null) && (localDataLineMsgRecord.fileMsgStatus != 1L)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public boolean isFileType()
  {
    int i = this.groupType;
    return (i == -2000) || (i == -2005) || (i == -2009) || (i == -2335);
  }
  
  public boolean isPaused()
  {
    return this.mIsPaused;
  }
  
  public boolean isSendFromLocal()
  {
    return this.mFirstCome.isSendFromLocal();
  }
  
  public boolean isSingle()
  {
    if (this.groupId != 0)
    {
      int i = this.groupType;
      if ((i != -2005) && (i != -2009)) {
        return false;
      }
    }
    return true;
  }
  
  public boolean isTimeOut()
  {
    return MessageCache.a() - this.mLastArriveTime > 90L;
  }
  
  public void printlog()
  {
    try
    {
      boolean bool = QLog.isColorLevel();
      if (!bool) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("状态汇总: groupId[");
      localStringBuilder.append(this.groupId);
      localStringBuilder.append("]; size[");
      localStringBuilder.append(getTotalCount());
      localStringBuilder.append("]; isTimeOut[");
      localStringBuilder.append(isTimeOut());
      localStringBuilder.append("]; mLastArriveTime[");
      localStringBuilder.append(this.mLastArriveTime);
      localStringBuilder.append("]; ");
      arrayOfDataLineMsgRecord = this.mSet;
      k = arrayOfDataLineMsgRecord.length;
      i = 0;
      j = 0;
    }
    finally
    {
      for (;;)
      {
        StringBuilder localStringBuilder;
        DataLineMsgRecord[] arrayOfDataLineMsgRecord;
        int k;
        int i;
        int j;
        DataLineMsgRecord localDataLineMsgRecord;
        for (;;)
        {
          throw localObject;
        }
        j += 1;
        i += 1;
      }
    }
    if (i < k)
    {
      localDataLineMsgRecord = arrayOfDataLineMsgRecord[i];
      if (localDataLineMsgRecord == null)
      {
        localStringBuilder.append("{index[");
        localStringBuilder.append(j);
        localStringBuilder.append("]; 未有session}; ");
      }
      else
      {
        localStringBuilder.append("{index[");
        localStringBuilder.append(j);
        localStringBuilder.append("/");
        localStringBuilder.append(localDataLineMsgRecord.groupIndex);
        localStringBuilder.append("]; sessionid[");
        localStringBuilder.append(localDataLineMsgRecord.sessionid);
        localStringBuilder.append("]; issuc[");
        localStringBuilder.append(localDataLineMsgRecord.issuc);
        localStringBuilder.append("]; progress[");
        localStringBuilder.append(localDataLineMsgRecord.progress);
        localStringBuilder.append("]; fileMsgStatus[");
        localStringBuilder.append(localDataLineMsgRecord.fileMsgStatus);
        localStringBuilder.append("]; time[");
        localStringBuilder.append(localDataLineMsgRecord.time);
        localStringBuilder.append("]}; ");
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, localStringBuilder.toString());
      }
      return;
    }
  }
  
  public DataLineMsgRecord put(Integer paramInteger, DataLineMsgRecord paramDataLineMsgRecord)
  {
    try
    {
      if ((this.nLastId == 0L) || (paramDataLineMsgRecord.msgId > this.nLastId)) {
        this.nLastId = paramDataLineMsgRecord.msgId;
      }
      if ((this.nFirstId == 0L) || (paramDataLineMsgRecord.msgId < this.nFirstId)) {
        this.nFirstId = paramDataLineMsgRecord.msgId;
      }
      if ((this.mFirstArriveTime == 0L) || (this.mFirstArriveTime > paramDataLineMsgRecord.time))
      {
        this.mFirstArriveTime = paramDataLineMsgRecord.time;
        this.mFirstCome = paramDataLineMsgRecord;
      }
      if ((this.mLastArriveTime == 0L) || (this.mLastArriveTime < paramDataLineMsgRecord.time)) {
        this.mLastArriveTime = paramDataLineMsgRecord.time;
      }
      if (this.groupType == 0) {
        this.groupType = paramDataLineMsgRecord.msgtype;
      } else if ((this.groupType == -2000) && ((paramDataLineMsgRecord.msgtype == -2005) || (paramDataLineMsgRecord.msgtype == -2009))) {
        this.groupType = -2005;
      }
      this.mIsNewCome = true;
      paramInteger = null;
      if (isSingle(paramDataLineMsgRecord))
      {
        if (this.mSet == null) {
          this.mSet = new DataLineMsgRecord[1];
        }
        paramInteger = this.mSet[0];
        this.mSet[0] = paramDataLineMsgRecord;
      }
      else
      {
        if (this.mSet == null) {
          this.mSet = new DataLineMsgRecord[paramDataLineMsgRecord.groupSize];
        }
        if (paramDataLineMsgRecord.groupIndex < paramDataLineMsgRecord.groupSize)
        {
          DataLineMsgRecord localDataLineMsgRecord = this.mSet[paramDataLineMsgRecord.groupIndex];
          this.mSet[paramDataLineMsgRecord.groupIndex] = paramDataLineMsgRecord;
          paramInteger = localDataLineMsgRecord;
          if (QLog.isColorLevel())
          {
            paramInteger = TAG;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("插入Session[");
            localStringBuilder.append(paramDataLineMsgRecord.sessionid);
            localStringBuilder.append("], groupIndex[");
            localStringBuilder.append(paramDataLineMsgRecord.groupIndex);
            localStringBuilder.append("], fileMsgStatus[");
            localStringBuilder.append(paramDataLineMsgRecord.fileMsgStatus);
            localStringBuilder.append("], time[");
            localStringBuilder.append(paramDataLineMsgRecord.time);
            localStringBuilder.append("], mLastArriveTime[");
            localStringBuilder.append(this.mLastArriveTime);
            localStringBuilder.append("]");
            QLog.d(paramInteger, 2, localStringBuilder.toString());
            paramInteger = localDataLineMsgRecord;
          }
        }
      }
      return paramInteger;
    }
    finally {}
  }
  
  public void setPaused(boolean paramBoolean)
  {
    try
    {
      this.mIsPaused = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setTimeOut()
  {
    this.mLastArriveTime = (MessageCache.a() - 95L);
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("设置timeOut, mLastArriveTime[");
      localStringBuilder.append(this.mLastArriveTime);
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
  
  public ArrayList<DataLineMsgRecord> values()
  {
    try
    {
      if (!this.mIsNewCome) {
        break label59;
      }
      i = 0;
      this.mIsNewCome = false;
      this.mComeList.clear();
      localObject1 = this.mSet;
      j = localObject1.length;
    }
    finally
    {
      for (;;)
      {
        int i;
        Object localObject1;
        int j;
        Object localObject3;
        for (;;)
        {
          label59:
          throw localObject2;
        }
        i += 1;
      }
    }
    if (i < j)
    {
      localObject3 = localObject1[i];
      if (localObject3 != null) {
        this.mComeList.add(localObject3);
      }
    }
    else
    {
      localObject1 = this.mComeList;
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.DataLineMsgSet
 * JD-Core Version:    0.7.0.1
 */