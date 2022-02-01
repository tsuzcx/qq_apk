package cooperation.qqcircle.redpoint;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.ReportExtraInfo;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.api.requests.QCircleRedPointEvent;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.OnGetQQCircleNumRedMsgListener;
import cooperation.qqcircle.eevee.QCircleEeveeMananger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import qqcircle.QQCircleCounter.AllPushPointInfo;
import qqcircle.QQCircleCounter.OutLayerPointInfo;
import qqcircle.QQCircleCounter.PymkRedPointInfo;
import qqcircle.QQCircleCounter.RedDisplayInfo;
import qqcircle.QQCircleCounter.RedPointInfo;

public class EeveeRedPointManagerDelegate
  implements SimpleEventReceiver, BaseRedPoinManagerDelegate
{
  private static final String TAG = "QCircleEeveeRedPointManagerDelegate";
  private AppRuntime mApp;
  private QQCircleCounter.RedPointInfo mCacheNumRedPointInfo;
  private QQCircleCounter.RedPointInfo mCacheOuterEntranceRedPointInfo;
  private QQCircleCounter.RedPointInfo mCacheSmallRedPointInfo;
  private final Object mLock = new Object();
  
  public EeveeRedPointManagerDelegate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    SimpleEventBus.getInstance().registerReceiver(this);
  }
  
  private void asyncSaveRedPointInfoToDataBase(int paramInt, QQCircleCounter.RedPointInfo paramRedPointInfo)
  {
    if (paramRedPointInfo != null)
    {
      if (Looper.getMainLooper() == Looper.myLooper()) {
        ThreadManager.getSubThreadHandler().post(new EeveeRedPointManagerDelegate.4(this, paramInt, paramRedPointInfo));
      }
    }
    else {
      return;
    }
    saveRedPointToDataBase(paramInt, paramRedPointInfo);
  }
  
  private void loadLocalNumRedPointInfoFromDataBase()
  {
    for (;;)
    {
      try
      {
        ??? = QCircleEeveeMananger.getInstance().getBizUndealMsgBuffer(102);
        int i = RFLog.USR;
        Object localObject2 = new StringBuilder().append("loadLocalNumRedPointInfoFromDataBase ");
        if (??? != null)
        {
          bool = true;
          RFLog.d("QCircleEeveeRedPointManagerDelegate", i, bool);
          if (??? == null) {
            return;
          }
          localObject2 = new QQCircleCounter.RedPointInfo();
          ((QQCircleCounter.RedPointInfo)localObject2).mergeFrom((byte[])???);
          synchronized (this.mLock)
          {
            this.mCacheNumRedPointInfo = ((QQCircleCounter.RedPointInfo)localObject2);
            return;
          }
        }
        boolean bool = false;
      }
      catch (Throwable localThrowable)
      {
        RFLog.e("QCircleEeveeRedPointManagerDelegate", RFLog.USR, new Object[] { "loadLocalNumRedPointInfoFromDataBase error! ", localThrowable });
        return;
      }
    }
  }
  
  private void loadLocalOuterEntranceRedPointFromDataBase()
  {
    for (;;)
    {
      try
      {
        ??? = QCircleEeveeMananger.getInstance().getBizUndealMsgBuffer(106);
        int i = RFLog.USR;
        Object localObject2 = new StringBuilder().append("loadLocalNumRedPointInfoFromDataBase ");
        if (??? != null)
        {
          bool = true;
          RFLog.d("QCircleEeveeRedPointManagerDelegate", i, bool);
          if (??? == null) {
            return;
          }
          localObject2 = new QQCircleCounter.RedPointInfo();
          ((QQCircleCounter.RedPointInfo)localObject2).mergeFrom((byte[])???);
          synchronized (this.mLock)
          {
            this.mCacheOuterEntranceRedPointInfo = ((QQCircleCounter.RedPointInfo)localObject2);
            return;
          }
        }
        boolean bool = false;
      }
      catch (Throwable localThrowable)
      {
        RFLog.e("QCircleEeveeRedPointManagerDelegate", RFLog.USR, new Object[] { "loadLocalNumRedPointInfoFromDataBase error! ", localThrowable });
        return;
      }
    }
  }
  
  private void loadLocalSmallRedPointFromDataBase()
  {
    ??? = QCircleEeveeMananger.getInstance().getBizUndealMsgBuffer(101);
    int i = RFLog.USR;
    Object localObject2 = new StringBuilder().append("loadLocalSmallRedPointFromDataBase ");
    if (??? != null) {}
    for (boolean bool = true;; bool = false)
    {
      RFLog.d("QCircleEeveeRedPointManagerDelegate", i, bool);
      if (??? != null) {
        break;
      }
      return;
    }
    try
    {
      localObject2 = new QQCircleCounter.RedPointInfo();
      ((QQCircleCounter.RedPointInfo)localObject2).mergeFrom((byte[])???);
      synchronized (this.mLock)
      {
        this.mCacheSmallRedPointInfo = ((QQCircleCounter.RedPointInfo)localObject2);
        return;
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      RFLog.e("QCircleEeveeRedPointManagerDelegate", RFLog.USR, new Object[] { "loadLocalSmallRedPointFromDataBase error! ", localInvalidProtocolBufferMicroException });
    }
  }
  
  private void saveRedPointToDataBase(int paramInt, QQCircleCounter.RedPointInfo paramRedPointInfo)
  {
    RFLog.d("QCircleEeveeRedPointManagerDelegate", RFLog.USR, "saveRedPointToDataBase redPointMainMsgType: " + paramInt);
    if (paramRedPointInfo != null) {}
    try
    {
      QCircleEeveeMananger.getInstance().saveBizUndealMsgBuffer(paramInt, paramRedPointInfo.toByteArray());
      return;
    }
    catch (Throwable paramRedPointInfo)
    {
      RFLog.e("QCircleEeveeRedPointManagerDelegate", RFLog.USR, new Object[] { "saveRedPointToDataBase error! ", paramRedPointInfo });
    }
  }
  
  public void asyncGetNumRedPointInfoByAppid(String paramString, OnGetQQCircleNumRedMsgListener paramOnGetQQCircleNumRedMsgListener, boolean paramBoolean)
  {
    Object localObject2 = null;
    if (paramOnGetQQCircleNumRedMsgListener == null) {
      return;
    }
    Object localObject1 = getNumRedPointInfotByAppid(paramString);
    int i = 0;
    if (!EeveeRedpointUtil.isValidRedPointInfo(paramString, (QQCircleCounter.RedPointInfo)localObject1)) {
      RFLog.d("QCircleEeveeRedPointManagerDelegate", RFLog.USR, "asyncGetNumRedPointInfoByAppid invalid red point info! ignore it.");
    }
    for (paramString = null;; paramString = (String)localObject1)
    {
      localObject1 = localObject2;
      if (paramString != null)
      {
        i = paramString.redTotalNum.get();
        paramString = paramString.rptRedInfo.get();
        if (paramString == null) {
          break label130;
        }
        localObject1 = new ArrayList();
        paramString = paramString.iterator();
        while (paramString.hasNext()) {
          ((List)localObject1).add(((QQCircleCounter.RedDisplayInfo)paramString.next()).headImg.get());
        }
      }
      for (;;)
      {
        paramOnGetQQCircleNumRedMsgListener.onGet((List)localObject1, i);
        return;
        label130:
        localObject1 = localObject2;
      }
    }
  }
  
  public void clearPedPoint()
  {
    this.mCacheNumRedPointInfo = new QQCircleCounter.RedPointInfo();
    this.mCacheSmallRedPointInfo = new QQCircleCounter.RedPointInfo();
    this.mCacheOuterEntranceRedPointInfo = new QQCircleCounter.RedPointInfo();
    QCircleServiceImpl.getQQService().updateRedDotInfo();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleRedPointEvent.class);
    return localArrayList;
  }
  
  public QQCircleCounter.RedPointInfo getLocalNumRedPointInfo()
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (this.mCacheNumRedPointInfo != null)
        {
          QQCircleCounter.RedPointInfo localRedPointInfo = this.mCacheNumRedPointInfo;
          return localRedPointInfo;
        }
        if (Looper.getMainLooper() == Looper.myLooper())
        {
          ThreadManager.getSubThreadHandler().post(new EeveeRedPointManagerDelegate.3(this));
          return null;
        }
      }
      loadLocalNumRedPointInfoFromDataBase();
    }
  }
  
  public QQCircleCounter.RedPointInfo getLocalOuterEntranceRedPointInfo()
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (this.mCacheOuterEntranceRedPointInfo != null)
        {
          QQCircleCounter.RedPointInfo localRedPointInfo = this.mCacheOuterEntranceRedPointInfo;
          return localRedPointInfo;
        }
        if (Looper.getMainLooper() == Looper.myLooper())
        {
          ThreadManager.getSubThreadHandler().post(new EeveeRedPointManagerDelegate.2(this));
          return null;
        }
      }
      loadLocalOuterEntranceRedPointFromDataBase();
    }
  }
  
  public QQCircleCounter.RedPointInfo getLocalSmallRedPointInfo()
  {
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (this.mCacheSmallRedPointInfo != null)
        {
          QQCircleCounter.RedPointInfo localRedPointInfo = this.mCacheSmallRedPointInfo;
          return localRedPointInfo;
        }
        if (Looper.getMainLooper() == Looper.myLooper())
        {
          ThreadManager.getSubThreadHandler().post(new EeveeRedPointManagerDelegate.1(this));
          return null;
        }
      }
      loadLocalSmallRedPointFromDataBase();
    }
  }
  
  public QQCircleCounter.RedPointInfo getNumRedPointInfotByAppid(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return getLocalNumRedPointInfo();
  }
  
  public QQCircleCounter.RedPointInfo getOuterEntranceRedPointInfoByAppid(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return getLocalOuterEntranceRedPointInfo();
  }
  
  public QQCircleCounter.RedPointInfo getSmallRedPointInfotByAppid(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return getLocalSmallRedPointInfo();
  }
  
  public void onDestroy()
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onNumRedPointClick(String paramString, ReportExtraInfo paramReportExtraInfo)
  {
    RFLog.d("QCircleEeveeRedPointManagerDelegate", RFLog.USR, "onNumRedPointClick appid: " + paramString);
  }
  
  public void onNumRedPointExposure(String paramString, ReportExtraInfo paramReportExtraInfo) {}
  
  public void onOuterEntranceRedPointClick(String paramString, ReportExtraInfo paramReportExtraInfo)
  {
    RFLog.d("QCircleEeveeRedPointManagerDelegate", RFLog.USR, "setOuterEntranceRedPointReaded appid: " + paramString);
  }
  
  public void onOuterEntranceRedPointExposure(String paramString, ReportExtraInfo paramReportExtraInfo) {}
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    int i;
    if ((paramSimpleBaseEvent instanceof QCircleRedPointEvent))
    {
      QCircleRedPointEvent localQCircleRedPointEvent = (QCircleRedPointEvent)paramSimpleBaseEvent;
      ??? = localQCircleRedPointEvent.mRedPointInfo;
      paramSimpleBaseEvent = (SimpleBaseEvent)???;
      if (??? == null) {
        paramSimpleBaseEvent = new QQCircleCounter.RedPointInfo();
      }
      RFLog.d("QCircleEeveeRedPointManagerDelegate", RFLog.USR, "on receive repoint. redPointMainMsgType: " + localQCircleRedPointEvent.mRedPointMainMsgType);
      switch (localQCircleRedPointEvent.mRedPointMainMsgType)
      {
      case 103: 
      case 104: 
      case 105: 
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      if (i != 0) {
        QCircleServiceImpl.getQQService().updateRedDotInfo();
      }
      return;
      synchronized (this.mLock)
      {
        this.mCacheSmallRedPointInfo = paramSimpleBaseEvent;
        i = 1;
      }
      synchronized (this.mLock)
      {
        this.mCacheNumRedPointInfo = paramSimpleBaseEvent;
        i = 1;
      }
      synchronized (this.mLock)
      {
        this.mCacheOuterEntranceRedPointInfo = paramSimpleBaseEvent;
        i = 1;
      }
    }
  }
  
  public void onSmallRedPointClick(String paramString, ReportExtraInfo paramReportExtraInfo)
  {
    RFLog.d("QCircleEeveeRedPointManagerDelegate", RFLog.USR, "onSmallRedPointClick appid: " + paramString);
  }
  
  public void onSmallRedPointExposure(String paramString, ReportExtraInfo paramReportExtraInfo) {}
  
  public void setNumRedPointReaded(String arg1)
  {
    RFLog.d("QCircleEeveeRedPointManagerDelegate", RFLog.USR, "setNumRedPointReaded appid: " + ???);
    if (TextUtils.isEmpty(???)) {
      return;
    }
    QQCircleCounter.RedPointInfo localRedPointInfo = getLocalNumRedPointInfo();
    if (localRedPointInfo == null)
    {
      RFLog.e("QCircleEeveeRedPointManagerDelegate", RFLog.USR, "setNumRedPointReaded return. redPointInfo is null");
      return;
    }
    EeveeRedpointUtil.saveLastReadedNumRedPointTimestamp(localRedPointInfo.lastVisitTime.get());
    synchronized (this.mLock)
    {
      localRedPointInfo.clear();
      asyncSaveRedPointInfoToDataBase(102, localRedPointInfo);
      return;
    }
  }
  
  public void setOuterEntranceRedPointReaded(String arg1, List<Integer> paramList)
  {
    RFLog.d("QCircleEeveeRedPointManagerDelegate", RFLog.USR, "setOuterEntranceRedPointReaded appid: " + ???);
    if (TextUtils.isEmpty(???)) {
      return;
    }
    if ((paramList == null) || (paramList.size() <= 0))
    {
      RFLog.d("QCircleEeveeRedPointManagerDelegate", RFLog.USR, "[setOuterEntranceRedPointReaded] clearRedTypeList is empty!");
      return;
    }
    QQCircleCounter.RedPointInfo localRedPointInfo = getLocalOuterEntranceRedPointInfo();
    if (localRedPointInfo == null)
    {
      RFLog.e("QCircleEeveeRedPointManagerDelegate", RFLog.USR, "setOuterEntranceRedPointReaded return. redPointInfo is null");
      return;
    }
    long l = localRedPointInfo.outLayerInfo.combineRedTypes.get();
    for (;;)
    {
      synchronized (this.mLock)
      {
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break label243;
        }
        Integer localInteger = (Integer)paramList.next();
        l &= (1 << localInteger.intValue() ^ 0xFFFFFFFF);
        switch (localInteger.intValue())
        {
        case 1: 
          localRedPointInfo.rptRedInfo.clear();
        }
      }
      localRedPointInfo.redTotalNum.clear();
      continue;
      localRedPointInfo.allPushInfo.wording.clear();
      continue;
      localRedPointInfo.pymkRedInfo.wording.clear();
      continue;
      label243:
      localRedPointInfo.outLayerInfo.combineRedTypes.set(l);
      RFLog.d("QCircleEeveeRedPointManagerDelegate", RFLog.USR, "[setOuterEntranceRedPointReaded] combineRedTypes: " + l);
      asyncSaveRedPointInfoToDataBase(106, localRedPointInfo);
      return;
    }
  }
  
  public void setSmallRedPointReaded(String arg1)
  {
    RFLog.d("QCircleEeveeRedPointManagerDelegate", RFLog.USR, "setSmallRedPointReaded appid: " + ???);
    if (TextUtils.isEmpty(???)) {
      return;
    }
    QQCircleCounter.RedPointInfo localRedPointInfo = getLocalSmallRedPointInfo();
    if (localRedPointInfo == null)
    {
      RFLog.e("QCircleEeveeRedPointManagerDelegate", RFLog.USR, "setSmallRedPointReaded return. redPointInfo is null");
      return;
    }
    EeveeRedpointUtil.saveLastReadedSmallRedPointTimestamp(localRedPointInfo.lastVisitTime.get());
    synchronized (this.mLock)
    {
      localRedPointInfo.clear();
      asyncSaveRedPointInfoToDataBase(101, localRedPointInfo);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.redpoint.EeveeRedPointManagerDelegate
 * JD-Core Version:    0.7.0.1
 */