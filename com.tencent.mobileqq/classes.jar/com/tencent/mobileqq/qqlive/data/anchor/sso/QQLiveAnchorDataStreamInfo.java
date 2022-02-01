package com.tencent.mobileqq.qqlive.data.anchor.sso;

public class QQLiveAnchorDataStreamInfo
{
  public String auxStreamId;
  public boolean isSelfInfo;
  public String mainStreamId;
  public long originRoomId;
  public long originUid;
  public long roomId;
  public long uid;
  
  public QQLiveAnchorDataStreamInfo() {}
  
  public QQLiveAnchorDataStreamInfo(QQLiveAnchorDataStreamInfo paramQQLiveAnchorDataStreamInfo)
  {
    if (paramQQLiveAnchorDataStreamInfo == null) {
      return;
    }
    this.uid = paramQQLiveAnchorDataStreamInfo.uid;
    this.roomId = paramQQLiveAnchorDataStreamInfo.roomId;
    this.mainStreamId = paramQQLiveAnchorDataStreamInfo.mainStreamId;
    this.auxStreamId = paramQQLiveAnchorDataStreamInfo.auxStreamId;
    this.isSelfInfo = paramQQLiveAnchorDataStreamInfo.isSelfInfo;
    this.originUid = paramQQLiveAnchorDataStreamInfo.originUid;
    this.originRoomId = paramQQLiveAnchorDataStreamInfo.originRoomId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataStreamInfo
 * JD-Core Version:    0.7.0.1
 */