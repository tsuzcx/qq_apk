package cooperation.qqcircle.eevee;

import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
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
import com.tencent.mobileqq.qcircle.api.IQCircleColdBootService;
import com.tencent.mobileqq.qcircle.api.event.QCircleFlutterUpdateFuelEvent;
import com.tencent.mobileqq.qcircle.api.event.QCirclePublishButtonEvent;
import com.tencent.mobileqq.qcircle.api.event.QCirclePushToastEvent;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qcircle.api.global.QCircleTipsConfig;
import com.tencent.mobileqq.qcircle.api.helper.QCircleChatBoxHelper;
import com.tencent.mobileqq.qcircle.api.helper.QCircleEeveeAttachInfoHelper;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.api.requests.QCircleEeveeUndealMsgRequest;
import com.tencent.mobileqq.qcircle.api.requests.QCircleRedPointEvent;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.QCircleConfig;
import cooperation.qqcircle.beans.SingleUndealMsg;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import cooperation.qqcircle.report.QCircleLpReportDc010001.DataBuilder;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QUA;
import feedcloud.FeedCloudCommon.BytesEntry;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudEeveeBase.ClientInfo;
import feedcloud.FeedCloudEeveeBase.StEeveeAttachInfo;
import feedcloud.FeedCloudEeveeUndealmsg.BizUndealMsg;
import feedcloud.FeedCloudEeveeUndealmsg.FcUndealMsgsRsp;
import feedcloud.FeedCloudEeveeUndealmsg.IntervalControl;
import feedcloud.FeedCloudEeveeUndealmsg.SignalMsg;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import feedcloud.FeedCloudToastshowsvr.StGetToastDetailRsp;
import feedcloud.FeedCloudToastshowsvr.StShowControl;
import feedcloud.FeedCloudToastshowsvr.StShowTime;
import feedcloud.FeedCloudToastshowsvr.StToast;
import feedcloud.FeedCloudToastshowsvr.StToastContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import qqcircle.QQCircleBase.StPublishButtonAnimationInfo;
import qqcircle.QQCircleCounter.AttachInfo;
import qqcircle.QQCircleCounter.CountInfoRsp;
import qqcircle.QQCircleCounter.OutLayerPointInfo;
import qqcircle.QQCircleCounter.RedDisplayInfo;
import qqcircle.QQCircleCounter.RedPointInfo;
import qqcircle.QQCircleDitto.StCircleDittoDataNew;
import qqcircle.QQCircleDitto.StItemContainer;
import qqcircle.QQCircleDitto.StItemInfo;
import qqcircle.QQCircleEnvHub.GetUserFullEnvRsp;
import qqcircle.QQCircleEnvHub.UserLayerInfo;
import qqcircle.TaskCenterReader.EeveeMyFuel;

public class QCircleEeveeMananger
{
  private static final String TAG = "QCircleEeveeMananger";
  private static Object dbLock = new Object();
  public static long lastpollingTime = 0L;
  private static Object lock = new Object();
  private static volatile QCircleEeveeMananger mInstance;
  private Runnable getEeveeUndealMsgRunnable = new QCircleEeveeMananger.3(this);
  public long homeSwitchInterval = 45000L;
  private EntityManager mEm;
  private long mLastGetbySwitchHome = 0L;
  private long mLastGetbySwitchTab = 0L;
  public long pollingInterval = 60000L;
  public long sceneSwitchInterval = 5000L;
  private volatile MqqHandler undealCountHandler;
  
  QCircleEeveeMananger()
  {
    getmEm();
  }
  
  private List<FeedCloudEeveeBase.StEeveeAttachInfo> appendLightSDKVersion(@NonNull List<FeedCloudEeveeBase.StEeveeAttachInfo> paramList)
  {
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localStEeveeAttachInfo = (FeedCloudEeveeBase.StEeveeAttachInfo)((Iterator)localObject).next();
      if ((localStEeveeAttachInfo != null) && ("110_1100001_LightSDKVersion".equals(localStEeveeAttachInfo.key.get()))) {
        return paramList;
      }
    }
    FeedCloudEeveeBase.StEeveeAttachInfo localStEeveeAttachInfo = new FeedCloudEeveeBase.StEeveeAttachInfo();
    localStEeveeAttachInfo.key.set("110_1100001_LightSDKVersion");
    localStEeveeAttachInfo.tag.set(0);
    if (!TextUtils.isEmpty("2.6.0.23"))
    {
      localObject = "2.6.0.23".split("\\.");
      if (localObject.length > 3)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localObject[0]);
        localStringBuilder.append(".");
        localStringBuilder.append(localObject[1]);
        localStringBuilder.append(".");
        localStringBuilder.append(localObject[2]);
        localObject = localStringBuilder.toString();
        break label158;
      }
    }
    localObject = "2.2.6";
    label158:
    localStEeveeAttachInfo.value.set((String)localObject);
    paramList.add(localStEeveeAttachInfo);
    return paramList;
  }
  
  private String getAccount()
  {
    try
    {
      String str = ((IAccountRuntime)QRoute.api(IAccountRuntime.class)).getAccount();
      return str;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleEeveeMananger", 1, "", localException);
    }
    return "";
  }
  
  private List<FeedCloudEeveeBase.StEeveeAttachInfo> getEeeveeAttachInfo()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(QCircleEeveeAttachInfoHelper.getInstance().getEeveeAttachInfos());
    localArrayList.add(getPrivateMessageAttachInfo());
    appendLightSDKVersion(localArrayList);
    return localArrayList;
  }
  
  public static QCircleEeveeMananger getInstance()
  {
    if (mInstance == null) {
      synchronized (lock)
      {
        if (mInstance == null)
        {
          QLog.e("QCircleEeveeMananger", 1, "getInstance");
          mInstance = new QCircleEeveeMananger();
        }
      }
    }
    return mInstance;
  }
  
  private FeedCloudEeveeBase.StEeveeAttachInfo getPrivateMessageAttachInfo()
  {
    FeedCloudEeveeBase.StEeveeAttachInfo localStEeveeAttachInfo = new FeedCloudEeveeBase.StEeveeAttachInfo();
    Pair localPair = QCircleChatBoxHelper.getInstance().getUnReadMessages();
    if (localPair != null)
    {
      if (localPair.second == null) {
        return localStEeveeAttachInfo;
      }
      QQCircleCounter.AttachInfo localAttachInfo = new QQCircleCounter.AttachInfo();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPrivateMessageAttachInfo unReadMessages size =");
      localStringBuilder.append(((List)localPair.second).size());
      QLog.d("QCircleEeveeMananger", 1, localStringBuilder.toString());
      localAttachInfo.privateMsgList.set((List)localPair.second);
      localStEeveeAttachInfo.key.set("106_1060001_AttachInfo");
      localStEeveeAttachInfo.busiData.set(ByteStringMicro.copyFrom(localAttachInfo.toByteArray()));
    }
    return localStEeveeAttachInfo;
  }
  
  private MqqHandler getSubThreadHandler()
  {
    if (this.undealCountHandler == null) {
      try
      {
        if (this.undealCountHandler == null)
        {
          QLog.e("QCircleEeveeMananger", 1, "getSubThreadHandler");
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
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getmEm ");
          localStringBuilder.append(localException);
          QLog.e("QCircleEeveeMananger", 1, localStringBuilder.toString());
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
    switch (i)
    {
    case 109: 
    default: 
      return;
    case 110: 
      try
      {
        saveBizUndealMsgBuffer(i, (byte[])localObject1);
        LocalMultiProcConfig.putLong("qqcircle_get_photo_cluster_last_time", System.currentTimeMillis());
        return;
      }
      catch (Exception paramBizUndealMsg)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleBizUndealMsg error: mainType ");
        ((StringBuilder)localObject1).append(i);
        QLog.e("QCircleEeveeMananger", 1, ((StringBuilder)localObject1).toString(), paramBizUndealMsg);
        return;
      }
    case 108: 
      initUserEnv((byte[])localObject1);
      return;
    case 107: 
      if (localObject1 == null) {
        return;
      }
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
        QLog.d("QCircleEeveeMananger", 1, new Object[] { localObject2 });
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePublishButtonEvent(paramBizUndealMsg.toByteArray()));
        saveBizUndealMsgBuffer(i, (byte[])localObject1);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramBizUndealMsg)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleBizUndealMsg error: mainType ");
        ((StringBuilder)localObject1).append(i);
        QLog.e("QCircleEeveeMananger", 1, ((StringBuilder)localObject1).toString(), paramBizUndealMsg);
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
        QLog.d("QCircleEeveeMananger", 1, new Object[] { localObject2 });
        SimpleEventBus.getInstance().dispatchEvent(new QCirclePushToastEvent(paramBizUndealMsg.toByteArray()));
        saveBizUndealMsgBuffer(i, (byte[])localObject1);
        return;
      }
      catch (Exception paramBizUndealMsg)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleBizUndealMsg error: mainType ");
        ((StringBuilder)localObject1).append(i);
        QLog.e("QCircleEeveeMananger", 1, ((StringBuilder)localObject1).toString(), paramBizUndealMsg);
        return;
      }
    }
    try
    {
      localObject2 = new QQCircleCounter.CountInfoRsp();
      ((QQCircleCounter.CountInfoRsp)localObject2).mergeFrom((byte[])localObject1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleBizUndealMsg mainType ");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(((QQCircleCounter.CountInfoRsp)localObject2).rptRedPoint.size());
      QLog.d("QCircleEeveeMananger", 1, ((StringBuilder)localObject1).toString());
      localObject1 = EeveeRedpointUtil.getRedPointInfoByAppid("circle_entrance", (QQCircleCounter.CountInfoRsp)localObject2);
      StringBuilder localStringBuilder = new StringBuilder();
      if (localObject1 != null)
      {
        localStringBuilder.append("[handleBizUndealMsg] receive redpoint. appid: ");
        localStringBuilder.append(((QQCircleCounter.RedPointInfo)localObject1).appid.get());
        localStringBuilder.append(", redType: ");
        localStringBuilder.append(((QQCircleCounter.RedPointInfo)localObject1).redType.get());
        localStringBuilder.append(", redTotalNum: ");
        localStringBuilder.append(((QQCircleCounter.RedPointInfo)localObject1).redTotalNum.get());
        localStringBuilder.append(", wording");
        localStringBuilder.append(((QQCircleCounter.RedPointInfo)localObject1).wording.get());
        localStringBuilder.append(", combineRedTypes: ");
        localStringBuilder.append(((QQCircleCounter.RedPointInfo)localObject1).outLayerInfo.combineRedTypes.get());
        localStringBuilder.append(", tabType: ");
        localStringBuilder.append(((QQCircleCounter.RedPointInfo)localObject1).tabType.get());
        localStringBuilder.append(", extend: ");
        localStringBuilder.append(((QQCircleCounter.RedPointInfo)localObject1).extend.get());
        localStringBuilder.append(", msgId: ");
        localStringBuilder.append(paramBizUndealMsg.msgid.get());
        paramBizUndealMsg = ((QQCircleCounter.RedPointInfo)localObject1).rptRedInfo.get();
        if ((paramBizUndealMsg != null) && (paramBizUndealMsg.size() > 0))
        {
          localStringBuilder.append(", uinInfo: ");
          paramBizUndealMsg = paramBizUndealMsg.iterator();
          while (paramBizUndealMsg.hasNext())
          {
            QQCircleCounter.RedDisplayInfo localRedDisplayInfo = (QQCircleCounter.RedDisplayInfo)paramBizUndealMsg.next();
            localStringBuilder.append("(");
            localStringBuilder.append(localRedDisplayInfo.headImg.get());
            localStringBuilder.append(",");
            localStringBuilder.append(localRedDisplayInfo.num.get());
            localStringBuilder.append(")");
          }
        }
        QLog.d("QCircleEeveeMananger", 1, new Object[] { localStringBuilder });
        if (!EeveeRedpointUtil.isValidRedPointInfo("circle_entrance", (QQCircleCounter.RedPointInfo)localObject1))
        {
          QLog.d("QCircleEeveeMananger", 1, "[handleBizUndealMsg] invalid red point info! ignore it.");
          return;
        }
        if (i == 101)
        {
          paramBizUndealMsg = ((QQCircleCounter.CountInfoRsp)localObject2).extInfo.mapBytesInfo.get();
          if (paramBizUndealMsg != null)
          {
            paramBizUndealMsg = paramBizUndealMsg.iterator();
            while (paramBizUndealMsg.hasNext())
            {
              localObject2 = (FeedCloudCommon.BytesEntry)paramBizUndealMsg.next();
              if ((localObject2 != null) && (TextUtils.equals("follow_page_delay_second", ((FeedCloudCommon.BytesEntry)localObject2).key.get())) && (((FeedCloudCommon.BytesEntry)localObject2).value.get() != null))
              {
                localObject2 = ((FeedCloudCommon.BytesEntry)localObject2).value.get().toStringUtf8();
                try
                {
                  EeveeRedpointUtil.saveFollowTabClearRedDotDelayInSecond(Long.parseLong((String)localObject2));
                }
                catch (NumberFormatException localNumberFormatException)
                {
                  QLog.e("QCircleEeveeMananger", 1, "handleBizUndealMsg  saveFollowTabClearRedDotDelayInSecond error!", localNumberFormatException);
                }
              }
            }
          }
        }
        SimpleEventBus.getInstance().dispatchEvent(new QCircleRedPointEvent(i, (QQCircleCounter.RedPointInfo)localObject1));
        saveBizUndealMsgBuffer(i, ((QQCircleCounter.RedPointInfo)localObject1).toByteArray());
        return;
      }
      QLog.d("QCircleEeveeMananger", 1, "[handleBizUndealMsg] don't have qcircle entrance reddot!");
      return;
    }
    catch (Exception paramBizUndealMsg)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleBizUndealMsg error: mainType ");
      ((StringBuilder)localObject1).append(i);
      QLog.e("QCircleEeveeMananger", 1, ((StringBuilder)localObject1).toString(), paramBizUndealMsg);
    }
  }
  
  private void initUserEnv(byte[] paramArrayOfByte)
  {
    QLog.d("QCircleEeveeMananger", 1, "初始化用户配置信息");
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
    return (QCircleConfig.getInstance().isQQCircleShowLebaEntrance()) || (QCircleConfigHelper.a(((IStudyModeManager)QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()));
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
          QCircleLpReportDc010001.DataBuilder localDataBuilder = new QCircleLpReportDc010001.DataBuilder().setActionType(500);
          int i;
          if (paramInt == 1000) {
            i = 15;
          } else {
            i = 20;
          }
          QCircleLpReportDc010001.report(localDataBuilder.setSubActionType(i).setThrActionType(1).setEeveeMsgId(localBizUndealMsg.msgid.get()).setScene(paramInt));
        }
      }
      saveInterval(paramFcUndealMsgsRsp.intervalCtl);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("attachInfo size = ");
      ((StringBuilder)localObject).append(paramFcUndealMsgsRsp.attachInfo.get().size());
      QLog.i("QCircleEeveeMananger", 2, ((StringBuilder)localObject).toString());
      saveAttachInfo(paramFcUndealMsgsRsp.attachInfo.get());
    }
  }
  
  public static void releaseInstance()
  {
    QLog.e("QCircleEeveeMananger", 1, "releaseInstance");
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
    paramIntervalControl = new StringBuilder();
    paramIntervalControl.append("saveInterval pollingInterval= ");
    paramIntervalControl.append(i);
    paramIntervalControl.append("sceneSwitchInterval =");
    paramIntervalControl.append(j);
    paramIntervalControl.append("homeSwitchInterval");
    paramIntervalControl.append(k);
    QLog.e("QCircleEeveeMananger", 1, paramIntervalControl.toString());
  }
  
  private void scheduleEeveeTask()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scheduleEeveeTask pollingInterval= ");
      localStringBuilder.append(this.pollingInterval);
      QLog.e("QCircleEeveeMananger", 1, localStringBuilder.toString());
      getSubThreadHandler().removeCallbacks(this.getEeveeUndealMsgRunnable);
      getSubThreadHandler().postDelayed(this.getEeveeUndealMsgRunnable, this.pollingInterval);
      return;
    }
    finally {}
  }
  
  public void deleteAllRecomAutoTemplateData()
  {
    deleteBizUndealMsgBuffer(110);
  }
  
  public void deleteBizUndealMsgBuffer(int paramInt)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("deleteBizUndealMsgBuffer type=");
    ((StringBuilder)???).append(paramInt);
    QLog.e("QCircleEeveeMananger", 1, ((StringBuilder)???).toString());
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
  
  public void deleteOneRecomAutoTemplateData(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject2 = getBizUndealMsgBuffer(110);
    if (localObject2 != null) {}
    for (;;)
    {
      try
      {
        localObject1 = new FeedCloudRead.StGetFeedListRsp();
        ((FeedCloudRead.StGetFeedListRsp)localObject1).mergeFrom((byte[])localObject2);
        localObject2 = ((FeedCloudRead.StGetFeedListRsp)localObject1).vecFeed.get();
        if (((List)localObject2).size() == 0) {
          return;
        }
        QQCircleDitto.StCircleDittoDataNew localStCircleDittoDataNew = new QQCircleDitto.StCircleDittoDataNew();
        localStCircleDittoDataNew.mergeFrom(((FeedCloudMeta.StFeed)((List)localObject2).get(0)).dittoFeed.dittoDataNew.get().toByteArray());
        List localList = localStCircleDittoDataNew.itemContainter.items.get();
        if (localList == null) {
          return;
        }
        Iterator localIterator = localList.iterator();
        if (!localIterator.hasNext()) {
          break label251;
        }
        QQCircleDitto.StItemInfo localStItemInfo = (QQCircleDitto.StItemInfo)localIterator.next();
        if (!paramString.equals(localStItemInfo.id.get())) {
          continue;
        }
        localList.remove(localStItemInfo);
        i = 1;
        if (i != 0)
        {
          ((FeedCloudMeta.StFeed)((List)localObject2).get(0)).dittoFeed.dittoDataNew.set(ByteStringMicro.copyFrom(localStCircleDittoDataNew.toByteArray()));
          saveBizUndealMsgBuffer(110, ((FeedCloudRead.StGetFeedListRsp)localObject1).toByteArray());
          return;
        }
      }
      catch (Exception paramString)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("deleteRecomAutoTemplateData ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.e("QCircleEeveeMananger", 1, ((StringBuilder)localObject1).toString());
      }
      return;
      label251:
      int i = 0;
    }
  }
  
  public byte[] getBizUndealMsgBuffer(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getBizUndealMsgBuffer type=");
    ((StringBuilder)localObject).append(paramInt);
    QLog.e("QCircleEeveeMananger", 1, ((StringBuilder)localObject).toString());
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
      if (QLog.isColorLevel()) {
        QLog.i("QCircleEeveeMananger", 2, "handleFuelData");
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
        if (QLog.isColorLevel())
        {
          paramPBBytesField = new StringBuilder();
          paramPBBytesField.append("handleFuelData fuelcount:");
          paramPBBytesField.append(localEeveeMyFuel.myFuelValue.get());
          QLog.i("QCircleEeveeMananger", 2, paramPBBytesField.toString());
        }
        QCircleConfig.getInstance().saveFuleCount(localEeveeMyFuel.myFuelValue.get());
        QCircleHostConfig.savePushFuleCountTime(l);
        return;
      }
    }
    catch (Exception paramPBBytesField)
    {
      QLog.e("QCircleEeveeMananger", 1, paramPBBytesField, new Object[0]);
    }
  }
  
  public void handlePushData(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QCircleEeveeMananger", 1, "pushData == null");
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qcircle pushdata:");
      localStringBuilder.append(paramString);
      QLog.i("QCircleEeveeMananger", 2, localStringBuilder.toString());
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
        int i;
        long l;
        QLog.e("QCircleEeveeMananger", 1, paramString, new Object[0]);
      }
      paramString = paramString.optString("pushStr");
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        l = paramString.optLong("pushTime");
        if (l > QCircleHostConfig.getPushFuleCountTime())
        {
          i = paramString.optInt("myFuelValue");
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("handleFuelData fuelcount:");
            paramString.append(i);
            QLog.i("QCircleEeveeMananger", 2, paramString.toString());
          }
          QCircleConfig.getInstance().saveFuleCount(i);
          QCircleHostConfig.savePushFuleCountTime(l);
          SimpleEventBus.getInstance().dispatchEvent(new QCircleFlutterUpdateFuelEvent(getAccount(), i));
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
    Object localObject1;
    if ((!isQCircleShowEntrance()) || (!QCircleConfig.getInstance().isEeveeSysTemPolling()))
    {
      if (5 == paramInt)
      {
        ThreadManager.getSubThreadHandler().post(new QCircleEeveeMananger.1(this));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("visitScene = ");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append(" isQQCircleShow= ");
        ((StringBuilder)localObject1).append(isQCircleShowEntrance());
        ((StringBuilder)localObject1).append(" isEeveeSysTemPolling= ");
        ((StringBuilder)localObject1).append(QCircleConfig.getInstance().isEeveeSysTemPolling());
        QLog.e("QCircleEeveeMananger", 1, ((StringBuilder)localObject1).toString());
      }
    }
    else
    {
      if ((paramInt == 999) && (isBackGround()))
      {
        QLog.e("QCircleEeveeMananger", 1, "isBackgroundPause");
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
            if (QLog.isColorLevel())
            {
              paramString1 = new StringBuilder();
              paramString1.append("onSend.pollingInterval time is not enough");
              paramString1.append(this.pollingInterval);
              QLog.d("QCircleEeveeMananger", 2, paramString1.toString());
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
      ((IQCircleColdBootService)QRoute.api(IQCircleColdBootService.class)).prepare();
      Object localObject2 = new FeedCloudEeveeBase.ClientInfo();
      ((FeedCloudEeveeBase.ClientInfo)localObject2).clientAppVersion.set(QUA.getQUA3());
      int i;
      if (QCircleReportHelper.isQQCircleActive()) {
        i = 2;
      } else {
        i = 1;
      }
      localObject1 = new QCircleEeveeUndealMsgRequest((FeedCloudEeveeBase.ClientInfo)localObject2, paramInt, i, (FeedCloudEeveeUndealmsg.SignalMsg)localObject1, getEeeveeAttachInfo());
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
      QLog.e("QCircleEeveeMananger", 1, ((StringBuilder)localObject2).toString());
      VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject1, new QCircleEeveeMananger.2(this, paramInt, paramString2));
      scheduleEeveeTask();
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append(" isQQCircleShow= ");
    paramString1.append(isQCircleShowEntrance());
    paramString1.append(" isEeveeSysTemPolling= ");
    paramString1.append(QCircleConfig.getInstance().isEeveeSysTemPolling());
    QLog.e("QCircleEeveeMananger", 1, paramString1.toString());
  }
  
  public void saveBizUndealMsgBuffer(int paramInt, byte[] arg2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("saveBizUndealMsgBuffer type=");
    ((StringBuilder)localObject1).append(paramInt);
    QLog.e("QCircleEeveeMananger", 1, ((StringBuilder)localObject1).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.eevee.QCircleEeveeMananger
 * JD-Core Version:    0.7.0.1
 */