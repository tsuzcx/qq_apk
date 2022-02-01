package com.tencent.mobileqq.qqlive.api.impl.anchor;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.IQQLiveAnchorFansService;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorFansGroupCallback;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorFansGroupItem;
import com.tencent.mobileqq.qqlive.sso.IQQLiveSsoModule;
import com.tencent.mobileqq.qqlive.sso.QQLiveBusinessObserver;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.anchor.fans.server.nano.FansGroupItem;
import com.tencent.qqlive.anchor.fans.server.nano.GetAnchorFansGroupListReq;
import com.tencent.qqlive.anchor.fans.server.nano.GetAnchorFansGroupListRsp;
import java.util.ArrayList;
import java.util.List;

public class QQLiveAnchorFansServiceImpl
  extends QQLiveBusinessObserver
  implements IQQLiveAnchorFansService
{
  private static final int MSG_NOTIFY_TYPE_FANS_GROUP_LIST = 521;
  private static final String QQ_LIVE_FANS_GROUP_CMD = "trpc.qlive.anchor_fans_group_server.AnchorFansGroupServer";
  private static final String QQ_LIVE_GET_FANS_GROUP_LIST_METHOD = "GetAnchorFansGroupList";
  private static final String TAG = "QQLiveFansServiceImpl";
  private IQQLiveAnchorFansGroupCallback mAnchorFansGroupCallback;
  private IQQLiveSDK sdkImpl;
  
  private boolean onGetAnchorFansGroupListFail(QQLiveRspData paramQQLiveRspData)
  {
    if (this.mAnchorFansGroupCallback == null)
    {
      QLog.e("QQLiveFansServiceImpl", 4, "checkFollowCallback is null");
      return true;
    }
    if ((paramQQLiveRspData != null) && (paramQQLiveRspData.a() != null))
    {
      if (paramQQLiveRspData.c() != 0)
      {
        this.mAnchorFansGroupCallback.a(paramQQLiveRspData.c(), paramQQLiveRspData.e());
        return true;
      }
      return false;
    }
    this.mAnchorFansGroupCallback.a(-1, "the data is null");
    return true;
  }
  
  private void resetCallback()
  {
    this.mAnchorFansGroupCallback = null;
  }
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveFansServiceImpl", 4, "QQLiveFansServiceImpl destroy");
    }
    resetCallback();
  }
  
  public void getAnchorFansGroupList(long paramLong, IQQLiveAnchorFansGroupCallback paramIQQLiveAnchorFansGroupCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveFansServiceImpl", 4, "[getAnchorFansGroupList]");
    }
    this.mAnchorFansGroupCallback = paramIQQLiveAnchorFansGroupCallback;
    if (this.sdkImpl != null)
    {
      paramIQQLiveAnchorFansGroupCallback = new GetAnchorFansGroupListReq();
      paramIQQLiveAnchorFansGroupCallback.a = paramLong;
      IQQLiveSsoModule localIQQLiveSsoModule = (IQQLiveSsoModule)this.sdkImpl.getExtModule("sso_module");
      if (localIQQLiveSsoModule == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQLiveFansServiceImpl", 4, "get IQQLiveSsoModule null");
        }
        return;
      }
      localIQQLiveSsoModule.a("trpc.qlive.anchor_fans_group_server.AnchorFansGroupServer", "GetAnchorFansGroupList", GetAnchorFansGroupListReq.toByteArray(paramIQQLiveAnchorFansGroupCallback), 521, this);
    }
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    this.sdkImpl = paramIQQLiveSDK;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, QQLiveRspData paramQQLiveRspData)
  {
    if (paramBoolean)
    {
      if (paramInt != 521) {
        return;
      }
      if (onGetAnchorFansGroupListFail(paramQQLiveRspData))
      {
        QLog.e("QQLiveFansServiceImpl", 4, "onGetAnchorFansGroupListFail fail");
        return;
      }
      try
      {
        paramQQLiveRspData = GetAnchorFansGroupListRsp.a(paramQQLiveRspData.a()).a;
        localObject1 = new ArrayList();
        int i = paramQQLiveRspData.length;
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = paramQQLiveRspData[paramInt];
          QQLiveAnchorFansGroupItem localQQLiveAnchorFansGroupItem = new QQLiveAnchorFansGroupItem();
          localQQLiveAnchorFansGroupItem.groupId = localObject2.a;
          localQQLiveAnchorFansGroupItem.name = localObject2.b;
          localQQLiveAnchorFansGroupItem.memberNum = localObject2.c;
          localQQLiveAnchorFansGroupItem.isMember = localObject2.d;
          localQQLiveAnchorFansGroupItem.auth = localObject2.e;
          localQQLiveAnchorFansGroupItem.groupCardSchema = QQLiveAnchorFansGroupItem.fillGroupCardSchema(localQQLiveAnchorFansGroupItem.groupId, localQQLiveAnchorFansGroupItem.auth);
          ((List)localObject1).add(localQQLiveAnchorFansGroupItem);
          paramInt += 1;
        }
        this.mAnchorFansGroupCallback.a((List)localObject1);
        if (QLog.isColorLevel())
        {
          QLog.i("QQLiveFansServiceImpl", 2, "onGetAnchorFansGroupList Success");
          return;
        }
      }
      catch (Exception paramQQLiveRspData)
      {
        this.mAnchorFansGroupCallback.a(-1, "GetPUinAndOpenidByUidRsp parse fail");
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("GetPUinAndOpenidByUidRsp error:");
        ((StringBuilder)localObject1).append(paramQQLiveRspData.getMessage());
        QLog.e("QQLiveFansServiceImpl", 4, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public void reset()
  {
    resetCallback();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.anchor.QQLiveAnchorFansServiceImpl
 * JD-Core Version:    0.7.0.1
 */