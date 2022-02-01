package com.tencent.mobileqq.flashshow.request.feed;

import android.text.TextUtils;
import com.tencent.mobileqq.flashshow.bean.FSMainTabInfo;
import com.tencent.mobileqq.flashshow.helper.FSTempRedPointHelper;
import com.tencent.mobileqq.flashshow.request.FSBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetFeedListReq;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import java.util.ArrayList;
import qqcircle.QQCircleFeedBase.StFeedListBusiReqData;

public class FSTabFeedRequest
  extends FSBaseRequest
{
  protected QQCircleFeedBase.StFeedListBusiReqData mBusiReqData;
  protected FeedCloudRead.StGetFeedListReq mRequest;
  protected final FSMainTabInfo mTabInfo;
  
  private FSTabFeedRequest(FSMainTabInfo paramFSMainTabInfo, int paramInt)
  {
    this.mTabInfo = paramFSMainTabInfo;
    this.mRequest = new FeedCloudRead.StGetFeedListReq();
    this.mRequest.source.set(this.mTabInfo.b());
    this.mRequest.from.set(0);
    this.mRequest.listNum.set(10);
    a();
    this.mBusiReqData = new QQCircleFeedBase.StFeedListBusiReqData();
    this.mBusiReqData.tabAttachInfo.set(this.mTabInfo.c());
    this.mBusiReqData.pullSceneType.set(paramInt);
  }
  
  private void a()
  {
    Object localObject = FSTempRedPointHelper.getInstance().getTransScheme(String.valueOf(this.mTabInfo.b()));
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      FeedCloudCommon.Entry localEntry = new FeedCloudCommon.Entry();
      localEntry.key.set("BadgeExtInfo");
      localEntry.value.set((String)localObject);
      localObject = new FeedCloudCommon.StCommonExt();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localEntry);
      ((FeedCloudCommon.StCommonExt)localObject).mapInfo.set(localArrayList);
      this.mRequest.extInfo.set((MessageMicro)localObject);
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
    return this.mTabInfo.d();
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
  
  public int getRequestSource()
  {
    return this.mTabInfo.b();
  }
  
  public void setAttachInfo(String paramString)
  {
    this.mRequest.feedAttchInfo.set(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.request.feed.FSTabFeedRequest
 * JD-Core Version:    0.7.0.1
 */