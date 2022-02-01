package com.tencent.mobileqq.qcircle.api.requests;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudRead.GroupReqItem;
import feedcloud.FeedCloudRead.StGetRelationGroupListReq;
import feedcloud.FeedCloudRead.StGetRelationGroupListRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class QCircleRelationGroupRequest
  extends QCircleBaseRequest
{
  public static final String ATTACH_INFO = "attachInfo";
  private static final int DEF_LOAD_COUNT = 1000;
  public static final String GROUP_ID = "gid";
  private FeedCloudRead.StGetRelationGroupListReq mRequest = new FeedCloudRead.StGetRelationGroupListReq();
  
  public QCircleRelationGroupRequest(int paramInt, List<Map<String, Object>> paramList)
  {
    paramList = convertGroupReqItems(paramList);
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.mRequest.reqItems.set(paramList);
    }
    this.mRequest.scene.set(paramInt);
    this.mRequest.count.set(1000L);
  }
  
  private List<FeedCloudRead.GroupReqItem> convertGroupReqItems(List<Map<String, Object>> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return localArrayList;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject1 = (Map)paramList.next();
        FeedCloudRead.GroupReqItem localGroupReqItem = new FeedCloudRead.GroupReqItem();
        Object localObject2 = ((Map)localObject1).get("gid");
        if ((localObject2 instanceof String)) {
          localGroupReqItem.gid.set(localObject2.toString());
        }
        localObject1 = ((Map)localObject1).get("attachInfo");
        if ((localObject1 instanceof String)) {
          localGroupReqItem.attachInfo.set(localObject1.toString());
        }
        localArrayList.add(localGroupReqItem);
      }
    }
    return localArrayList;
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    FeedCloudRead.StGetRelationGroupListRsp localStGetRelationGroupListRsp = new FeedCloudRead.StGetRelationGroupListRsp();
    try
    {
      localStGetRelationGroupListRsp.mergeFrom(paramArrayOfByte);
      return localStGetRelationGroupListRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localStGetRelationGroupListRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.feedcloud.commreader.ComReader.GetRelationGroupList";
  }
  
  protected byte[] getRequestByteData()
  {
    FeedCloudRead.StGetRelationGroupListReq localStGetRelationGroupListReq = this.mRequest;
    if (localStGetRelationGroupListReq == null) {
      return new byte[0];
    }
    return localStGetRelationGroupListReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.requests.QCircleRelationGroupRequest
 * JD-Core Version:    0.7.0.1
 */