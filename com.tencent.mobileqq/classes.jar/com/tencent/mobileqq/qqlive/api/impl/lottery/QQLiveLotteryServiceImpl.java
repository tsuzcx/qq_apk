package com.tencent.mobileqq.qqlive.api.impl.lottery;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.lottery.IQQLiveLotteryService;
import com.tencent.mobileqq.qqlive.callback.lottery.IQQLiveHideLotteryCallback;
import com.tencent.mobileqq.qqlive.callback.lottery.IQQLiveLotteryCallback;
import com.tencent.mobileqq.qqlive.config.QQLiveConfigBean;
import com.tencent.mobileqq.qqlive.config.QQLiveConfigProcessor;
import com.tencent.mobileqq.qqlive.sso.IQQLiveSsoModule;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqvalive.liveLotteryServer.liveLotteryServer.nano.GetLotteryPendantReq;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class QQLiveLotteryServiceImpl
  implements IQQLiveLotteryService
{
  public static final String LOTTERY_MODULE_NAME = "lottery_module";
  private static final String QQ_LIVE_GET_LOTTERY_METHOD = "GetLotteryPendant";
  private static final String QQ_LIVE_LOTTERY_CMD = "trpc.qlive.lottery_svr.Lottery";
  private static final String TAG = "IQQLiveLotteryModule";
  private CopyOnWriteArraySet<IQQLiveHideLotteryCallback> hideLotteryCallbacks = new CopyOnWriteArraySet();
  private IQQLiveSDK sdkImpl;
  
  private String getLotteryJumpUrl(String paramString1, long paramLong, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    paramString1 = QQLiveConfigProcessor.a().d.replace("{lotteryId}", paramString1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    paramString1 = paramString1.replace("{roomId}", localStringBuilder.toString()).replace("{programId}", paramString2).replace("{busId}", paramString3);
    paramString2 = paramMap.entrySet().iterator();
    while (paramString2.hasNext())
    {
      paramString3 = (Map.Entry)paramString2.next();
      paramMap = new StringBuilder();
      paramMap.append(paramString1);
      paramMap.append("&");
      paramMap.append((String)paramString3.getKey());
      paramMap.append("=");
      paramMap.append((String)paramString3.getValue());
      paramString1 = paramMap.toString();
    }
    return paramString1;
  }
  
  private boolean onGetLotteryFail(IQQLiveLotteryCallback paramIQQLiveLotteryCallback, QQLiveRspData paramQQLiveRspData)
  {
    if (paramIQQLiveLotteryCallback == null)
    {
      QLog.e("IQQLiveLotteryModule", 4, "setAnnounceCallback is null");
      return true;
    }
    if ((paramQQLiveRspData != null) && (paramQQLiveRspData.a() != null))
    {
      if (paramQQLiveRspData.c() != 0)
      {
        paramIQQLiveLotteryCallback.a(paramQQLiveRspData.c(), paramQQLiveRspData.e());
        return true;
      }
      return false;
    }
    paramIQQLiveLotteryCallback.a(-1L, "the data is null");
    return true;
  }
  
  public void destroy()
  {
    QLog.e("IQQLiveLotteryModule", 4, "IQQLiveLotteryModule destroy");
    CopyOnWriteArraySet localCopyOnWriteArraySet = this.hideLotteryCallbacks;
    if (localCopyOnWriteArraySet != null) {
      localCopyOnWriteArraySet.clear();
    }
  }
  
  public void getLotteryPendant(long paramLong1, long paramLong2, String paramString, Map<String, String> paramMap, IQQLiveLotteryCallback paramIQQLiveLotteryCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQQLiveLotteryModule", 4, "getLotteryPendant send");
    }
    if (this.sdkImpl != null)
    {
      GetLotteryPendantReq localGetLotteryPendantReq = new GetLotteryPendantReq();
      localGetLotteryPendantReq.a = paramLong1;
      localGetLotteryPendantReq.b = paramLong2;
      localGetLotteryPendantReq.c = paramString;
      IQQLiveSsoModule localIQQLiveSsoModule = (IQQLiveSsoModule)this.sdkImpl.getExtModule("sso_module");
      if (localIQQLiveSsoModule == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("IQQLiveLotteryModule", 4, "get IQQLiveLotteryModule null");
        }
        return;
      }
      localIQQLiveSsoModule.a("trpc.qlive.lottery_svr.Lottery", "GetLotteryPendant", GetLotteryPendantReq.toByteArray(localGetLotteryPendantReq), new QQLiveLotteryServiceImpl.1(this, paramIQQLiveLotteryCallback, paramLong1, paramString, paramMap));
    }
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    QLog.d("IQQLiveLotteryModule", 4, "IQQLiveLotteryModule init");
    this.sdkImpl = paramIQQLiveSDK;
  }
  
  public void notifyHideLotteryResult(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = this.hideLotteryCallbacks;
    if (localObject != null)
    {
      localObject = ((CopyOnWriteArraySet)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((IQQLiveHideLotteryCallback)((Iterator)localObject).next()).a(paramString1, paramString2, paramString3);
      }
    }
  }
  
  public void registerHideLottery(IQQLiveHideLotteryCallback paramIQQLiveHideLotteryCallback)
  {
    if (paramIQQLiveHideLotteryCallback != null) {
      this.hideLotteryCallbacks.add(paramIQQLiveHideLotteryCallback);
    }
  }
  
  public void reset()
  {
    QLog.d("IQQLiveLotteryModule", 4, "IQQLiveLotteryModule reset");
    CopyOnWriteArraySet localCopyOnWriteArraySet = this.hideLotteryCallbacks;
    if (localCopyOnWriteArraySet != null) {
      localCopyOnWriteArraySet.clear();
    }
  }
  
  public void unRegisterHideLottery(IQQLiveHideLotteryCallback paramIQQLiveHideLotteryCallback)
  {
    if (paramIQQLiveHideLotteryCallback != null) {
      this.hideLotteryCallbacks.remove(paramIQQLiveHideLotteryCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.lottery.QQLiveLotteryServiceImpl
 * JD-Core Version:    0.7.0.1
 */