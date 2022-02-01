package cooperation.qqcircle.eevee;

import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qcircle.api.event.QCirclePublishButtonEvent;
import com.tencent.mobileqq.qcircle.api.event.QCirclePushToastEvent;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qcircle.api.global.QCircleTipsConfig;
import com.tencent.mobileqq.qcircle.api.helper.QCircleEeveeAttachInfoHelper;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.api.requests.QCircleEeveeUndealMsgRequest;
import com.tencent.mobileqq.qcircle.api.requests.QCircleRedPointEvent;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostConfig;
import cooperation.qqcircle.QCircleConfig;
import cooperation.qqcircle.beans.SingleUndealMsg;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qzone.QUA;
import feedcloud.FeedCloudCommon.BytesEntry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudEeveeBase.ClientInfo;
import feedcloud.FeedCloudEeveeBase.StEeveeAttachInfo;
import feedcloud.FeedCloudEeveeUndealmsg.BizUndealMsg;
import feedcloud.FeedCloudEeveeUndealmsg.FcUndealMsgsRsp;
import feedcloud.FeedCloudEeveeUndealmsg.IntervalControl;
import feedcloud.FeedCloudEeveeUndealmsg.SignalMsg;
import feedcloud.FeedCloudToastshowsvr.StGetToastDetailRsp;
import feedcloud.FeedCloudToastshowsvr.StShowControl;
import feedcloud.FeedCloudToastshowsvr.StShowTime;
import feedcloud.FeedCloudToastshowsvr.StToast;
import feedcloud.FeedCloudToastshowsvr.StToastContent;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import qqcircle.QQCircleBase.StPublishButtonAnimationInfo;
import qqcircle.QQCircleCounter.AllPushPointInfo;
import qqcircle.QQCircleCounter.CountInfoRsp;
import qqcircle.QQCircleCounter.OutLayerPointInfo;
import qqcircle.QQCircleCounter.RedDisplayInfo;
import qqcircle.QQCircleCounter.RedPointInfo;
import qqcircle.QQCircleEnvHub.GetUserFullEnvRsp;
import qqcircle.QQCircleEnvHub.UserLayerInfo;
import qqcircle.TaskCenterReader.EeveeMyFuel;

public class QCircleEeveeMananger
{
  private static final String TAG = "QCircleEeveeMananger";
  private static Object dbLock = new Object();
  public static long lastpollingTime = 0L;
  private static Object lock = new Object();
  private static QCircleEeveeMananger mInstance;
  private Runnable getEeveeUndealMsgRunnable = new QCircleEeveeMananger.3(this);
  public long homeSwitchInterval = 45000L;
  private EntityManager mEm;
  private long mLastGetbySwitchHome = 0L;
  private long mLastGetbySwitchTab = 0L;
  public long pollingInterval = 60000L;
  public long sceneSwitchInterval = 5000L;
  private MqqHandler undealCountHandler;
  
  QCircleEeveeMananger()
  {
    getmEm();
  }
  
  public static QCircleEeveeMananger getInstance()
  {
    if (mInstance == null) {
      synchronized (lock)
      {
        if (mInstance == null)
        {
          RFLog.e("QCircleEeveeMananger", RFLog.USR, "getInstance");
          mInstance = new QCircleEeveeMananger();
        }
      }
    }
    return mInstance;
  }
  
  private MqqHandler getSubThreadHandler()
  {
    if (this.undealCountHandler == null) {
      try
      {
        if (this.undealCountHandler == null)
        {
          RFLog.e("QCircleEeveeMananger", RFLog.USR, "getSubThreadHandler");
          HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("eevee_timer", 0);
          localHandlerThread.start();
          this.undealCountHandler = new MqqHandler(localHandlerThread.getLooper());
        }
      }
      finally {}
    }
    return this.undealCountHandler;
  }
  
  private EntityManager getmEm()
  {
    try
    {
      if (this.mEm != null)
      {
        localObject1 = this.mEm;
        return localObject1;
      }
      Object localObject1 = mInstance;
      if (localObject1 != null) {
        try
        {
          this.mEm = QCircleServiceImpl.getEntityManager();
          localObject1 = this.mEm;
          return localObject1;
        }
        catch (Exception localException)
        {
          int i = RFLog.USR;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getmEm ");
          localStringBuilder.append(localException);
          RFLog.e("QCircleEeveeMananger", i, localStringBuilder.toString());
          return null;
        }
      }
      return null;
    }
    finally {}
  }
  
  private void handleBizUndealMsg(FeedCloudEeveeUndealmsg.BizUndealMsg paramBizUndealMsg)
  {
    int i = paramBizUndealMsg.mainType.get();
    Object localObject1 = paramBizUndealMsg.bufferData.get();
    if (localObject1 != null) {
      localObject1 = ((ByteStringMicro)localObject1).toByteArray();
    } else {
      localObject1 = null;
    }
    Object localObject2;
    int j;
    switch (i)
    {
    default: 
      return;
    case 108: 
      initUserEnv((byte[])localObject1);
      return;
    case 107: 
      try
      {
        paramBizUndealMsg = new QQCircleBase.StPublishButtonAnimationInfo();
        paramBizUndealMsg.mergeFrom((byte[])localObject1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[handleBizUndealMsg] receive publish button conf.");
        ((StringBuilder)localObject2).append(" isShowAnimation: ");
        ((StringBuilder)localObject2).append(paramBizUndealMsg.isShowAnimation.get());
        ((StringBuilder)localObject2).append(", hashIcon: ");
        ((StringBuilder)localObject2).append(paramBizUndealMsg.hashIcon.get());
        ((StringBuilder)localObject2).append(", hashTag: ");
        ((StringBuilder)localObject2).append(paramBizUndealMsg.hashTag.get());
        ((StringBuilder)localObject2).append(", words: ");
        ((StringBuilder)localObject2).append(paramBizUndealMsg.words.get());
        ((StringBuilder)localObject2).append(", backImg: ");
        ((StringBuilder)localObject2).append(paramBizUndealMsg.backImg.get());
        ((StringBuilder)localObject2).append(", operatorIcon: ");
        ((StringBuilder)localObject2).append(paramBizUndealMsg.operatorIcon.get());
        ((StringBuilder)localObject2).append(", jumpUrl: ");
        ((StringBuilder)localObject2).append(paramBizUndealMsg.jumpUrl.get());
        ((StringBuilder)localObject2).append(", animationStartupTime: ");
        ((StringBuilder)localObject2).append(paramBizUndealMsg.animationStartupTime.get());
        ((StringBuilder)localObject2).append(", animationShowTime: ");
        ((StringBuilder)localObject2).append(paramBizUndealMsg.animationShowTime.get());
        ((StringBuilder)localObject2).append(", reportExt: ");
        ((StringBuilder)localObject2).append(paramBizUndealMsg.reportExt.get());
        RFLog.d("QCircleEeveeMananger", RFLog.USR, new Object[] { localObject2 });
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePublishButtonEvent(paramBizUndealMsg.toByteArray()));
        saveBizUndealMsgBuffer(i, (byte[])localObject1);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramBizUndealMsg)
      {
        j = RFLog.USR;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleBizUndealMsg error: mainType ");
        ((StringBuilder)localObject1).append(i);
        RFLog.e("QCircleEeveeMananger", j, new Object[] { ((StringBuilder)localObject1).toString(), paramBizUndealMsg });
        return;
      }
    case 104: 
      handleFuelData(paramBizUndealMsg.bufferData);
      saveBizUndealMsgBuffer(i, (byte[])localObject1);
      return;
    case 103: 
      try
      {
        paramBizUndealMsg = new FeedCloudToastshowsvr.StGetToastDetailRsp();
        paramBizUndealMsg.mergeFrom((byte[])localObject1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[handleBizUndealMsg] receive toast. showPageType: ");
        ((StringBuilder)localObject2).append(paramBizUndealMsg.toastInfo.showControl.showPageType.get());
        ((StringBuilder)localObject2).append(", showTimeType: ");
        ((StringBuilder)localObject2).append(paramBizUndealMsg.toastInfo.showControl.showTime.showTimeType.get());
        ((StringBuilder)localObject2).append(", showTime: ");
        ((StringBuilder)localObject2).append(paramBizUndealMsg.toastInfo.showControl.showTime.value.get());
        ((StringBuilder)localObject2).append(", showDuration: ");
        ((StringBuilder)localObject2).append(paramBizUndealMsg.toastInfo.showControl.showTime.showDuration.get());
        ((StringBuilder)localObject2).append(", title: ");
        ((StringBuilder)localObject2).append(paramBizUndealMsg.toastInfo.toastContent.title.get());
        ((StringBuilder)localObject2).append(", content: ");
        ((StringBuilder)localObject2).append(paramBizUndealMsg.toastInfo.toastContent.content.get());
        RFLog.d("QCircleEeveeMananger", RFLog.USR, new Object[] { localObject2 });
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePushToastEvent(paramBizUndealMsg.toByteArray()));
        saveBizUndealMsgBuffer(i, (byte[])localObject1);
        return;
      }
      catch (Exception paramBizUndealMsg)
      {
        j = RFLog.USR;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleBizUndealMsg error: mainType ");
        ((StringBuilder)localObject1).append(i);
        RFLog.e("QCircleEeveeMananger", j, new Object[] { ((StringBuilder)localObject1).toString(), paramBizUndealMsg });
        return;
      }
    }
    try
    {
      localObject2 = new QQCircleCounter.CountInfoRsp();
      ((QQCircleCounter.CountInfoRsp)localObject2).mergeFrom((byte[])localObject1);
      j = RFLog.USR;
      paramBizUndealMsg = new StringBuilder();
      paramBizUndealMsg.append("handleBizUndealMsg mainType ");
      paramBizUndealMsg.append(i);
      paramBizUndealMsg.append(", ");
      paramBizUndealMsg.append(((QQCircleCounter.CountInfoRsp)localObject2).rptRedPoint.size());
      RFLog.d("QCircleEeveeMananger", j, paramBizUndealMsg.toString());
      paramBizUndealMsg = EeveeRedpointUtil.getRedPointInfoByAppid("circle_entrance", (QQCircleCounter.CountInfoRsp)localObject2);
      localObject1 = new StringBuilder();
      if (paramBizUndealMsg != null)
      {
        ((StringBuilder)localObject1).append("[handleBizUndealMsg] receive redpoint. appid: ");
        ((StringBuilder)localObject1).append(paramBizUndealMsg.appid.get());
        ((StringBuilder)localObject1).append(", redType: ");
        ((StringBuilder)localObject1).append(paramBizUndealMsg.redType.get());
        ((StringBuilder)localObject1).append(", redTotalNum: ");
        ((StringBuilder)localObject1).append(paramBizUndealMsg.redTotalNum.get());
        ((StringBuilder)localObject1).append(", wording");
        ((StringBuilder)localObject1).append(paramBizUndealMsg.allPushInfo.wording.get());
        ((StringBuilder)localObject1).append(", combineRedTypes: ");
        ((StringBuilder)localObject1).append(paramBizUndealMsg.outLayerInfo.combineRedTypes.get());
        ((StringBuilder)localObject1).append(", tabType: ");
        ((StringBuilder)localObject1).append(paramBizUndealMsg.tabType.get());
        ((StringBuilder)localObject1).append(", extend: ");
        ((StringBuilder)localObject1).append(paramBizUndealMsg.extend.get());
        Object localObject3 = paramBizUndealMsg.rptRedInfo.get();
        if ((localObject3 != null) && (((List)localObject3).size() > 0))
        {
          ((StringBuilder)localObject1).append(", uinInfo: ");
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            QQCircleCounter.RedDisplayInfo localRedDisplayInfo = (QQCircleCounter.RedDisplayInfo)((Iterator)localObject3).next();
            ((StringBuilder)localObject1).append("(");
            ((StringBuilder)localObject1).append(localRedDisplayInfo.headImg.get());
            ((StringBuilder)localObject1).append(",");
            ((StringBuilder)localObject1).append(localRedDisplayInfo.num.get());
            ((StringBuilder)localObject1).append(")");
          }
        }
        RFLog.d("QCircleEeveeMananger", RFLog.USR, new Object[] { localObject1 });
        if (!EeveeRedpointUtil.isValidRedPointInfo("circle_entrance", paramBizUndealMsg))
        {
          RFLog.d("QCircleEeveeMananger", RFLog.USR, "[handleBizUndealMsg] invalid red point info! ignore it.");
          return;
        }
        if (i == 101)
        {
          localObject1 = ((QQCircleCounter.CountInfoRsp)localObject2).extInfo.mapBytesInfo.get();
          if (localObject1 != null)
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (FeedCloudCommon.BytesEntry)((Iterator)localObject1).next();
              if ((localObject2 != null) && (TextUtils.equals("follow_page_delay_second", ((FeedCloudCommon.BytesEntry)localObject2).key.get())) && (((FeedCloudCommon.BytesEntry)localObject2).value.get() != null))
              {
                localObject2 = ((FeedCloudCommon.BytesEntry)localObject2).value.get().toStringUtf8();
                try
                {
                  EeveeRedpointUtil.saveFollowTabClearRedDotDelayInSecond(Long.parseLong((String)localObject2));
                }
                catch (NumberFormatException localNumberFormatException)
                {
                  RFLog.e("QCircleEeveeMananger", RFLog.USR, new Object[] { "handleBizUndealMsg  saveFollowTabClearRedDotDelayInSecond error!", localNumberFormatException });
                }
              }
            }
          }
        }
        SimpleEventBus.getInstance().dispatchEvent(new QCircleRedPointEvent(i, paramBizUndealMsg));
        saveBizUndealMsgBuffer(i, paramBizUndealMsg.toByteArray());
        return;
      }
      RFLog.d("QCircleEeveeMananger", RFLog.USR, "[handleBizUndealMsg] don't have qcircle entrance reddot!");
      return;
    }
    catch (Exception paramBizUndealMsg)
    {
      j = RFLog.USR;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleBizUndealMsg error: mainType ");
      ((StringBuilder)localObject1).append(i);
      RFLog.e("QCircleEeveeMananger", j, new Object[] { ((StringBuilder)localObject1).toString(), paramBizUndealMsg });
    }
  }
  
  private void initUserEnv(byte[] paramArrayOfByte)
  {
    RFLog.d("QCircleEeveeMananger", RFLog.USR, "初始化用户配置信息");
    try
    {
      QQCircleEnvHub.GetUserFullEnvRsp localGetUserFullEnvRsp = new QQCircleEnvHub.GetUserFullEnvRsp();
      localGetUserFullEnvRsp.mergeFrom(paramArrayOfByte);
      QCircleTipsConfig.getInstance().initTipsConfig(localGetUserFullEnvRsp);
      QCircleHostGlobalInfo.setIsLostUser(localGetUserFullEnvRsp.userLayerInfo.isHaveLostUser.get());
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  private boolean isQCircleShowEntrance()
  {
    return (QCircleConfig.getInstance().isQQCircleShowLebaEntrance()) || (QCircleConfig.isShowQQCircleMainTabEntrance());
  }
  
  private void onResponse(FeedCloudEeveeUndealmsg.FcUndealMsgsRsp paramFcUndealMsgsRsp, int paramInt)
  {
    if (paramFcUndealMsgsRsp != null)
    {
      Object localObject = paramFcUndealMsgsRsp.msgs.get();
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          FeedCloudEeveeUndealmsg.BizUndealMsg localBizUndealMsg = (FeedCloudEeveeUndealmsg.BizUndealMsg)((Iterator)localObject).next();
          handleBizUndealMsg(localBizUndealMsg);
          if (paramInt == 1000) {
            QCircleLpReportDc010001.report(500, 15, 1, null, null, null, localBizUndealMsg.msgid.get(), paramInt);
          } else {
            QCircleLpReportDc010001.report(500, 20, 1, null, null, null, localBizUndealMsg.msgid.get(), paramInt);
          }
        }
      }
      saveInterval(paramFcUndealMsgsRsp.intervalCtl);
      paramInt = RFLog.CLR;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("attachInfo size = ");
      ((StringBuilder)localObject).append(paramFcUndealMsgsRsp.attachInfo.get().size());
      RFLog.i("QCircleEeveeMananger", paramInt, ((StringBuilder)localObject).toString());
      saveAttachInfo(paramFcUndealMsgsRsp.attachInfo.get());
    }
  }
  
  public static void releaseInstance()
  {
    RFLog.e("QCircleEeveeMananger", RFLog.USR, "releaseInstance");
    if (mInstance != null) {
      synchronized (lock)
      {
        if (mInstance != null)
        {
          if (mInstance.undealCountHandler != null)
          {
            mInstance.undealCountHandler.removeCallbacks(mInstance.getEeveeUndealMsgRunnable);
            mInstance.undealCountHandler.getLooper().quit();
          }
          mInstance.mEm = null;
          mInstance.undealCountHandler = null;
          mInstance = null;
        }
        return;
      }
    }
  }
  
  private void saveAttachInfo(List<FeedCloudEeveeBase.StEeveeAttachInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      QCircleHostGlobalInfo.setEeveeAttachInfos(paramList);
      QCircleEeveeAttachInfoHelper.getInstance().setEeveeAttachInfos(paramList);
    }
  }
  
  private void saveInterval(FeedCloudEeveeUndealmsg.IntervalControl paramIntervalControl)
  {
    if (paramIntervalControl == null) {
      return;
    }
    int i = paramIntervalControl.pollingInterval.get();
    if (i > 0) {
      this.pollingInterval = (i * 1000L);
    }
    int j = paramIntervalControl.sceneSwitchInterval.get();
    if (j > 0) {
      this.sceneSwitchInterval = (j * 1000L);
    }
    int k = paramIntervalControl.homeSwitchInterval.get();
    if (k > 0) {
      this.homeSwitchInterval = (k * 1000L);
    }
    int m = RFLog.USR;
    paramIntervalControl = new StringBuilder();
    paramIntervalControl.append("saveInterval pollingInterval= ");
    paramIntervalControl.append(i);
    paramIntervalControl.append("sceneSwitchInterval =");
    paramIntervalControl.append(j);
    paramIntervalControl.append("homeSwitchInterval");
    paramIntervalControl.append(k);
    RFLog.e("QCircleEeveeMananger", m, paramIntervalControl.toString());
  }
  
  private void scheduleEeveeTask()
  {
    try
    {
      int i = RFLog.USR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scheduleEeveeTask pollingInterval= ");
      localStringBuilder.append(this.pollingInterval);
      RFLog.e("QCircleEeveeMananger", i, localStringBuilder.toString());
      getSubThreadHandler().removeCallbacks(this.getEeveeUndealMsgRunnable);
      getSubThreadHandler().postDelayed(this.getEeveeUndealMsgRunnable, this.pollingInterval);
      return;
    }
    finally {}
  }
  
  public void deleteBizUndealMsgBuffer(int paramInt)
  {
    int i = RFLog.USR;
    ??? = new StringBuilder();
    ((StringBuilder)???).append("deleteBizUndealMsgBuffer type=");
    ((StringBuilder)???).append(paramInt);
    RFLog.e("QCircleEeveeMananger", i, ((StringBuilder)???).toString());
    if (getmEm() != null) {
      synchronized (dbLock)
      {
        EntityManager localEntityManager = getmEm();
        String str = SingleUndealMsg.class.getSimpleName();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt);
        localStringBuilder.append("");
        localEntityManager.delete(str, "mType = ?", new String[] { localStringBuilder.toString() });
        return;
      }
    }
  }
  
  public byte[] getBizUndealMsgBuffer(int paramInt)
  {
    int i = RFLog.USR;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getBizUndealMsgBuffer type=");
    ((StringBuilder)localObject).append(paramInt);
    RFLog.e("QCircleEeveeMananger", i, ((StringBuilder)localObject).toString());
    if (getmEm() != null)
    {
      localObject = getmEm();
      String str = SingleUndealMsg.class.getSimpleName();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("");
      localObject = ((EntityManager)localObject).query(SingleUndealMsg.class, str, true, "mType = ?", new String[] { localStringBuilder.toString() }, null, null, null, null);
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        return ((SingleUndealMsg)((List)localObject).get(0)).mBizBufferData;
      }
    }
    return null;
  }
  
  public void handleFuelData(PBBytesField paramPBBytesField)
  {
    try
    {
      if (RFLog.isColorLevel()) {
        RFLog.i("QCircleEeveeMananger", RFLog.CLR, "handleFuelData");
      }
      TaskCenterReader.EeveeMyFuel localEeveeMyFuel = null;
      ByteStringMicro localByteStringMicro = paramPBBytesField.get();
      paramPBBytesField = localEeveeMyFuel;
      if (localByteStringMicro != null) {
        paramPBBytesField = localByteStringMicro.toByteArray();
      }
      localEeveeMyFuel = new TaskCenterReader.EeveeMyFuel();
      localEeveeMyFuel.mergeFrom(paramPBBytesField);
      long l = localEeveeMyFuel.pushTime.get();
      if (l > QCircleHostConfig.getPushFuleCountTime())
      {
        if (RFLog.isColorLevel())
        {
          int i = RFLog.CLR;
          paramPBBytesField = new StringBuilder();
          paramPBBytesField.append("handleFuelData fuelcount:");
          paramPBBytesField.append(localEeveeMyFuel.myFuelValue.get());
          RFLog.i("QCircleEeveeMananger", i, paramPBBytesField.toString());
        }
        QCircleConfig.getInstance().saveFuleCount(localEeveeMyFuel.myFuelValue.get());
        QCircleHostConfig.savePushFuleCountTime(l);
        return;
      }
    }
    catch (Exception paramPBBytesField)
    {
      RFLog.e("QCircleEeveeMananger", RFLog.USR, new Object[] { paramPBBytesField });
    }
  }
  
  public void handlePushData(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      RFLog.e("QCircleEeveeMananger", RFLog.USR, "pushData == null");
      return;
    }
    int i;
    if (RFLog.isColorLevel())
    {
      i = RFLog.CLR;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qcircle pushdata:");
      localStringBuilder.append(paramString);
      RFLog.i("QCircleEeveeMananger", i, localStringBuilder.toString());
    }
    int j;
    do
    {
      try
      {
        paramString = new JSONObject(paramString);
        i = paramString.optInt("msgMainType");
        j = paramString.optInt("msgSubType");
        if (i == 104) {
          continue;
        }
        return;
      }
      catch (Exception paramString)
      {
        long l;
        RFLog.e("QCircleEeveeMananger", RFLog.USR, new Object[] { paramString });
      }
      paramString = paramString.optString("pushStr");
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        l = paramString.optLong("pushTime");
        if (l > QCircleHostConfig.getPushFuleCountTime())
        {
          i = paramString.optInt("myFuelValue");
          if (RFLog.isColorLevel())
          {
            j = RFLog.CLR;
            paramString = new StringBuilder();
            paramString.append("handleFuelData fuelcount:");
            paramString.append(i);
            RFLog.i("QCircleEeveeMananger", j, paramString.toString());
          }
          QCircleConfig.getInstance().saveFuleCount(i);
          QCircleHostConfig.savePushFuleCountTime(l);
          return;
        }
      }
      return;
    } while (j == 1040001);
  }
  
  public boolean isBackGround()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null).isBackgroundPause;
  }
  
  public void onSend(int paramInt, String paramString1, String paramString2)
  {
    int i;
    Object localObject1;
    if ((!isQCircleShowEntrance()) || (!QCircleConfig.getInstance().isEeveeSysTemPolling()))
    {
      if (5 == paramInt)
      {
        ThreadManager.getSubThreadHandler().post(new QCircleEeveeMananger.1(this));
        i = RFLog.USR;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("visitScene = ");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append(" isQQCircleShow= ");
        ((StringBuilder)localObject1).append(isQCircleShowEntrance());
        ((StringBuilder)localObject1).append(" isEeveeSysTemPolling= ");
        ((StringBuilder)localObject1).append(QCircleConfig.getInstance().isEeveeSysTemPolling());
        RFLog.e("QCircleEeveeMananger", i, ((StringBuilder)localObject1).toString());
      }
    }
    else
    {
      if ((paramInt == 999) && (isBackGround()))
      {
        RFLog.e("QCircleEeveeMananger", RFLog.USR, "isBackgroundPause");
        scheduleEeveeTask();
        return;
      }
      localObject1 = new FeedCloudEeveeUndealmsg.SignalMsg();
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          break;
        case 1001: 
          handlePushData(paramString1);
          return;
        case 1000: 
          if (!TextUtils.isEmpty(paramString1)) {
            ((FeedCloudEeveeUndealmsg.SignalMsg)localObject1).signalBuff.set(ByteStringMicro.copyFromUtf8(paramString1));
          }
          if (!TextUtils.isEmpty(paramString2)) {
            ((FeedCloudEeveeUndealmsg.SignalMsg)localObject1).msgid.set(paramString2);
          }
          break;
        case 999: 
          if (System.currentTimeMillis() - lastpollingTime < this.pollingInterval)
          {
            if (RFLog.isColorLevel())
            {
              paramInt = RFLog.CLR;
              paramString1 = new StringBuilder();
              paramString1.append("onSend.pollingInterval time is not enough");
              paramString1.append(this.pollingInterval);
              RFLog.d("QCircleEeveeMananger", paramInt, paramString1.toString());
            }
            scheduleEeveeTask();
            return;
          }
          lastpollingTime = System.currentTimeMillis();
        }
        break;
      case 3: 
        if (System.currentTimeMillis() - this.mLastGetbySwitchTab < this.sceneSwitchInterval) {
          return;
        }
        this.mLastGetbySwitchTab = System.currentTimeMillis();
        break;
      case 2: 
        if (System.currentTimeMillis() - this.mLastGetbySwitchHome < this.homeSwitchInterval) {
          return;
        }
        this.mLastGetbySwitchHome = System.currentTimeMillis();
      }
      Object localObject2 = new FeedCloudEeveeBase.ClientInfo();
      ((FeedCloudEeveeBase.ClientInfo)localObject2).clientAppVersion.set(QUA.getQUA3());
      if (QCircleReportHelper.isQQCircleActive()) {
        i = 2;
      } else {
        i = 1;
      }
      localObject1 = new QCircleEeveeUndealMsgRequest((FeedCloudEeveeBase.ClientInfo)localObject2, paramInt, i, (FeedCloudEeveeUndealmsg.SignalMsg)localObject1, QCircleEeveeAttachInfoHelper.getInstance().getEeveeAttachInfos());
      i = RFLog.USR;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("request traceid");
      ((StringBuilder)localObject2).append(((QCircleEeveeUndealMsgRequest)localObject1).getTraceId());
      ((StringBuilder)localObject2).append("visitScene= ");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(" extinfo =");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(" msgId = ");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append(" isQQCircleActive() = ");
      ((StringBuilder)localObject2).append(QCircleReportHelper.isQQCircleActive());
      RFLog.e("QCircleEeveeMananger", i, ((StringBuilder)localObject2).toString());
      VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject1, new QCircleEeveeMananger.2(this, paramInt, paramString2));
      scheduleEeveeTask();
      return;
    }
    paramInt = RFLog.USR;
    paramString1 = new StringBuilder();
    paramString1.append(" isQQCircleShow= ");
    paramString1.append(isQCircleShowEntrance());
    paramString1.append(" isEeveeSysTemPolling= ");
    paramString1.append(QCircleConfig.getInstance().isEeveeSysTemPolling());
    RFLog.e("QCircleEeveeMananger", paramInt, paramString1.toString());
  }
  
  public void saveBizUndealMsgBuffer(int paramInt, byte[] arg2)
  {
    int i = RFLog.USR;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("saveBizUndealMsgBuffer type=");
    ((StringBuilder)localObject1).append(paramInt);
    RFLog.e("QCircleEeveeMananger", i, ((StringBuilder)localObject1).toString());
    localObject1 = new SingleUndealMsg(paramInt, ???);
    if (getmEm() != null) {
      synchronized (dbLock)
      {
        EntityManager localEntityManager = getmEm();
        String str = SingleUndealMsg.class.getSimpleName();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((SingleUndealMsg)localObject1).mType);
        localStringBuilder.append("");
        localEntityManager.delete(str, "mType = ?", new String[] { localStringBuilder.toString() });
        getmEm().persistOrReplace((Entity)localObject1);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.eevee.QCircleEeveeMananger
 * JD-Core Version:    0.7.0.1
 */