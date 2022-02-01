package com.tencent.mobileqq.flashshow.request.feed;

import android.text.TextUtils;
import com.tencent.mobileqq.flashshow.request.FSBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.ArrayList;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;

public class FSPreloadFeedRequest
  extends FSBaseRequest
{
  protected FeedCloudRead.StGetFeedListReq mRequest = new FeedCloudRead.StGetFeedListReq();
  
  public FSPreloadFeedRequest(String paramString1, String paramString2)
  {
    this.mRequest.source.set(41);
    this.mRequest.from.set(0);
    if (!TextUtils.isEmpty(paramString1)) {
      this.mRequest.feedAttchInfo.set(paramString1);
    }
    a(paramString2);
    paramString1 = new QQCircleFeedBase.StFeedListBusiReqData();
    paramString1.pullSceneType.set(2);
    this.mRequest.busiReqData.set(ByteStringMicro.copyFrom(paramString1.toByteArray()));
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      FeedCloudCommon.Entry localEntry = new FeedCloudCommon.Entry();
      localEntry.key.set("BadgeExtInfo");
      localEntry.value.set(paramString);
      paramString = new FeedCloudCommon.StCommonExt();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localEntry);
      paramString.mapInfo.set(localArrayList);
      this.mRequest.extInfo.set(paramString);
    }
  }
  
  public FeedCloudRead.StGetFeedListRsp decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetFeedListRsp localStGetFeedListRsp = new FeedCloudRead.StGetFeedListRsp();
    try
    {
      localStGetFeedListRsp.mergeFrom(paramArrayOfByte);
      return localStGetFeedListRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetFeedListRsp;
  }
  
  public String getCmdName()
  {
    return "QflashSvr.trpc.qflash.commreader.ComReader.GetFeedListRecom";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.request.feed.FSPreloadFeedRequest
 * JD-Core Version:    0.7.0.1
 */