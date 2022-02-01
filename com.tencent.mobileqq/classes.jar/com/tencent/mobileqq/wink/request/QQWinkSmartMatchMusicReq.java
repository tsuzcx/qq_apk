package com.tencent.mobileqq.wink.request;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.wink.request.base.VSBaseRequest;
import com.tencent.open.business.base.MobileInfoUtil;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleSmartMatchMusic.SmartMatchMusicReq;
import qqcircle.QQCircleSmartMatchMusic.SmartMatchMusicRsp;

public class QQWinkSmartMatchMusicReq
  extends VSBaseRequest
{
  private final QQCircleSmartMatchMusic.SmartMatchMusicReq mReq = new QQCircleSmartMatchMusic.SmartMatchMusicReq();
  
  public QQWinkSmartMatchMusicReq(List<byte[]> paramList, SosoLocation paramSosoLocation, QQWinkSmartMatchMusicReq.VideoType paramVideoType, QQWinkSmartMatchMusicReq.CameraType paramCameraType, LocalMediaInfo paramLocalMediaInfo, String paramString, QQWinkSmartMatchMusicReq.DataType paramDataType)
  {
    if (paramSosoLocation != null)
    {
      this.mReq.fLat.set(paramSosoLocation.mLat02);
      this.mReq.fLon.set(paramSosoLocation.mLon02);
    }
    this.mReq.dataType.set(QQWinkSmartMatchMusicReq.DataType.access$000(paramDataType));
    this.mReq.videoType.set(QQWinkSmartMatchMusicReq.VideoType.access$100(paramVideoType));
    this.mReq.cameraType.set(QQWinkSmartMatchMusicReq.CameraType.access$200(paramCameraType));
    if ((paramVideoType == QQWinkSmartMatchMusicReq.VideoType.LocalFile) && (paramLocalMediaInfo != null))
    {
      paramSosoLocation = this.mReq.videoLat;
      double d = paramLocalMediaInfo.latitude;
      Double.isNaN(d);
      paramSosoLocation.set(d / 1000000.0D);
      paramSosoLocation = this.mReq.videoLon;
      d = paramLocalMediaInfo.longitude;
      Double.isNaN(d);
      paramSosoLocation.set(d / 1000000.0D);
      this.mReq.videoTime.set(paramLocalMediaInfo.addedDate);
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramSosoLocation = (byte[])paramList.next();
        this.mReq.vecPicBuffer.add(ByteStringMicro.copyFrom(paramSosoLocation));
      }
    }
    this.mReq.wording.set(paramString);
    paramList = new FeedCloudCommon.Entry();
    paramList.key.set("wifi_mac");
    paramList.value.set(MobileInfoUtil.getLocalMacAddress());
    this.mReq.extInfo.mapInfo.add(paramList);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleSmartMatchMusic.SmartMatchMusicRsp localSmartMatchMusicRsp = new QQCircleSmartMatchMusic.SmartMatchMusicRsp();
    try
    {
      localSmartMatchMusicRsp.mergeFrom(paramArrayOfByte);
      return localSmartMatchMusicRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localSmartMatchMusicRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circlemusic.CircleSmartMatchMusic.GetSmartMatchMusic";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.request.QQWinkSmartMatchMusicReq
 * JD-Core Version:    0.7.0.1
 */