package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;

public class ApolloActionPush
  extends Entity
{
  public int mActionId;
  public int mActionType;
  public int mAioType;
  public String mContent;
  @unique
  public long mId;
  public long mRcvUin;
  public long mSendUin;
  public long mSessionId;
  public int mWordShowType;
  
  public void print()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(300);
      localStringBuilder.append("actionId:").append(this.mActionId).append(",actionType:").append(this.mActionType).append(",sendUin:").append(this.mSendUin).append(",rcvUin:").append(this.mRcvUin).append(",sessionId:").append(this.mSessionId).append(",aioType:").append(this.mAioType).append(",wordShowpType:").append(this.mWordShowType).append(",content:").append(this.mContent).append(",mId:").append(this.mId);
      QLog.d("ApolloPushManager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.ApolloActionPush
 * JD-Core Version:    0.7.0.1
 */