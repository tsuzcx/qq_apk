package com.tencent.mobileqq.wink.request;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.wink.request.base.VSBaseRequest;
import java.util.ArrayList;
import qqcircle.QQCircleSmartMatchMusic.MusicInfoReq;
import qqcircle.QQCircleSmartMatchMusic.MusicInfoRsp;

public class QQWinkBatchGetMusicInfoRequest
  extends VSBaseRequest
{
  private final QQCircleSmartMatchMusic.MusicInfoReq req = new QQCircleSmartMatchMusic.MusicInfoReq();
  
  public QQWinkBatchGetMusicInfoRequest(ArrayList<String> paramArrayList)
  {
    this.req.musicMIDList.set(paramArrayList);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleSmartMatchMusic.MusicInfoRsp localMusicInfoRsp = new QQCircleSmartMatchMusic.MusicInfoRsp();
    try
    {
      localMusicInfoRsp.mergeFrom(paramArrayOfByte);
      return localMusicInfoRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localMusicInfoRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circlemusic.CircleSmartMatchMusic.GetMusicInfo";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.req.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.request.QQWinkBatchGetMusicInfoRequest
 * JD-Core Version:    0.7.0.1
 */