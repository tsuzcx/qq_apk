package com.tencent.mobileqq.qqlive.data.trtc;

public class QQLiveRoomParams$Builder
{
  private QQLiveRoomParams mRoomParam = new QQLiveRoomParams(null);
  
  public QQLiveRoomParams build()
  {
    return this.mRoomParam;
  }
  
  public Builder setBussinessInfo(String paramString)
  {
    QQLiveRoomParams.access$702(this.mRoomParam, paramString);
    return this;
  }
  
  public Builder setRoleType(int paramInt)
  {
    QQLiveRoomParams.access$402(this.mRoomParam, paramInt);
    return this;
  }
  
  public Builder setRoomId(long paramLong)
  {
    QQLiveRoomParams.access$202(this.mRoomParam, paramLong);
    return this;
  }
  
  public Builder setScene(int paramInt)
  {
    QQLiveRoomParams.access$802(this.mRoomParam, paramInt);
    return this;
  }
  
  public Builder setStreamId(String paramString)
  {
    QQLiveRoomParams.access$502(this.mRoomParam, paramString);
    return this;
  }
  
  public Builder setUserDefineRecordId(String paramString)
  {
    QQLiveRoomParams.access$602(this.mRoomParam, paramString);
    return this;
  }
  
  public Builder setUserId(String paramString)
  {
    QQLiveRoomParams.access$102(this.mRoomParam, paramString);
    return this;
  }
  
  public Builder setUserSig(String paramString)
  {
    QQLiveRoomParams.access$302(this.mRoomParam, paramString);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams.Builder
 * JD-Core Version:    0.7.0.1
 */