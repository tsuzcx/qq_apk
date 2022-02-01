package com.tencent.mobileqq.qqlive.api.impl.anchor;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.IQQLiveAnchorPageService;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveGetAnchorPageUrlCallback;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveGetPuinAndOpenidCallback;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorPuinAndOpenid;
import com.tencent.mobileqq.qqlive.sso.IQQLiveSsoModule;
import com.tencent.mobileqq.qqlive.sso.QQLiveBusinessObserver;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.anchor.fans.server.nano.GetPuinAndOpenidByUidReq;
import com.tencent.qqlive.anchor.fans.server.nano.GetPuinAndOpenidByUidRsp;

public class QQLiveAnchorPageServiceImpl
  extends QQLiveBusinessObserver
  implements IQQLiveAnchorPageService
{
  private static final int MSG_NOTIFY_TYPE_GET_PUIN_OPENID = 520;
  private static final String QQ_LIVE_FANS_GROUP_CMD = "trpc.qlive.anchor_fans_group_server.AnchorFansGroupServer";
  private static final String QQ_LIVE_GET_PUIN_OPENID_METHOD = "GetPuinAndOpenidByUid";
  private static final String TAG = "QQLiveFansServiceImpl";
  private IQQLiveGetPuinAndOpenidCallback mGetPUinAndOpenidCallback;
  private IQQLiveSDK sdkImpl;
  
  private boolean onGetPuinAndOpenidFailed(QQLiveRspData paramQQLiveRspData)
  {
    if (this.mGetPUinAndOpenidCallback == null)
    {
      QLog.e("QQLiveFansServiceImpl", 4, "checkFollowCallback is null");
      return true;
    }
    if ((paramQQLiveRspData != null) && (paramQQLiveRspData.a() != null))
    {
      if (paramQQLiveRspData.c() != 0)
      {
        this.mGetPUinAndOpenidCallback.onFail(paramQQLiveRspData.c(), paramQQLiveRspData.e());
        return true;
      }
      return false;
    }
    this.mGetPUinAndOpenidCallback.onFail(-1, "the data is null");
    return true;
  }
  
  private void resetCallback()
  {
    this.mGetPUinAndOpenidCallback = null;
  }
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveFansServiceImpl", 4, "QQLiveFansServiceImpl destroy");
    }
    resetCallback();
  }
  
  public void getAnchorPageUrl(long paramLong, IQQLiveGetAnchorPageUrlCallback paramIQQLiveGetAnchorPageUrlCallback)
  {
    getPuinAndOpenidByUid(paramLong, new QQLiveAnchorPageServiceImpl.1(this, paramLong, paramIQQLiveGetAnchorPageUrlCallback));
  }
  
  public void getPuinAndOpenidByUid(long paramLong, IQQLiveGetPuinAndOpenidCallback paramIQQLiveGetPuinAndOpenidCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveFansServiceImpl", 4, "[getPuinAndOpenidByUid]");
    }
    this.mGetPUinAndOpenidCallback = paramIQQLiveGetPuinAndOpenidCallback;
    if (this.sdkImpl != null)
    {
      paramIQQLiveGetPuinAndOpenidCallback = new GetPuinAndOpenidByUidReq();
      paramIQQLiveGetPuinAndOpenidCallback.a = paramLong;
      IQQLiveSsoModule localIQQLiveSsoModule = (IQQLiveSsoModule)this.sdkImpl.getExtModule("sso_module");
      if (localIQQLiveSsoModule == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQLiveFansServiceImpl", 4, "get IQQLiveSsoModule null");
        }
        return;
      }
      localIQQLiveSsoModule.a("trpc.qlive.anchor_fans_group_server.AnchorFansGroupServer", "GetPuinAndOpenidByUid", GetPuinAndOpenidByUidReq.toByteArray(paramIQQLiveGetPuinAndOpenidCallback), 520, this);
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
      if (paramInt != 520) {
        return;
      }
      if (onGetPuinAndOpenidFailed(paramQQLiveRspData))
      {
        QLog.e("QQLiveFansServiceImpl", 4, "onGetPuinAndOpenidFailed fail");
        return;
      }
      try
      {
        paramQQLiveRspData = GetPuinAndOpenidByUidRsp.a(paramQQLiveRspData.a());
        localObject = new QQLiveAnchorPuinAndOpenid();
        ((QQLiveAnchorPuinAndOpenid)localObject).pgcPuin = paramQQLiveRspData.a;
        ((QQLiveAnchorPuinAndOpenid)localObject).pgcOpenid = paramQQLiveRspData.b;
        this.mGetPUinAndOpenidCallback.onSuccess((QQLiveAnchorPuinAndOpenid)localObject);
        if (QLog.isColorLevel())
        {
          QLog.i("QQLiveFansServiceImpl", 2, "onGetPuinAndOpenid Success");
          return;
        }
      }
      catch (Exception paramQQLiveRspData)
      {
        this.mGetPUinAndOpenidCallback.onFail(-1, "GetPUinAndOpenidByUidRsp parse fail");
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("GetPUinAndOpenidByUidRsp error:");
        ((StringBuilder)localObject).append(paramQQLiveRspData.getMessage());
        QLog.e("QQLiveFansServiceImpl", 4, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void reset()
  {
    resetCallback();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.anchor.QQLiveAnchorPageServiceImpl
 * JD-Core Version:    0.7.0.1
 */