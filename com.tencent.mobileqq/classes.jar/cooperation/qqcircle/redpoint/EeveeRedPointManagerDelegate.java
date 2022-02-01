package cooperation.qqcircle.redpoint;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.local.requests.QCircleRedPointEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.chat.QCircleHandler;
import cooperation.qqcircle.eevee.QCircleEeveeMananger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import qqcircle.QQCircleCounter.AllPushPointInfo;
import qqcircle.QQCircleCounter.OutLayerPointInfo;
import qqcircle.QQCircleCounter.PymkRedPointInfo;
import qqcircle.QQCircleCounter.RedDisplayInfo;
import qqcircle.QQCircleCounter.RedPointInfo;

public class EeveeRedPointManagerDelegate
  implements SimpleEventReceiver, IQCircleRedPointManagerDelegate
{
  private static final String TAG = "QCircleEeveeRedPointManagerDelegate";
  private QQAppInterface mApp;
  private QQCircleCounter.RedPointInfo mCacheNumRedPointInfo;
  private QQCircleCounter.RedPointInfo mCacheOuterEntranceRedPointInfo;
  private QQCircleCounter.RedPointInfo mCacheSmallRedPointInfo;
  private final Object mLock = new Object();
  
  public EeveeRedPointManagerDelegate(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
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
        Object localObject2 = new StringBuilder().append("loadLocalNumRedPointInfoFromDataBase ");
        if (??? != null)
        {
          bool = true;
          QLog.d("QCircleEeveeRedPointManagerDelegate", 1, bool);
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
        QLog.e("QCircleEeveeRedPointManagerDelegate", 1, "loadLocalNumRedPointInfoFromDataBase error! ", localThrowable);
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
        Object localObject2 = new StringBuilder().append("loadLocalNumRedPointInfoFromDataBase ");
        if (??? != null)
        {
          bool = true;
          QLog.d("QCircleEeveeRedPointManagerDelegate", 1, bool);
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
        QLog.e("QCircleEeveeRedPointManagerDelegate", 1, "loadLocalNumRedPointInfoFromDataBase error! ", localThrowable);
        return;
      }
    }
  }
  
  private void loadLocalSmallRedPointFromDataBase()
  {
    ??? = QCircleEeveeMananger.getInstance().getBizUndealMsgBuffer(101);
    Object localObject2 = new StringBuilder().append("loadLocalSmallRedPointFromDataBase ");
    if (??? != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QCircleEeveeRedPointManagerDelegate", 1, bool);
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
      QLog.e("QCircleEeveeRedPointManagerDelegate", 1, "loadLocalSmallRedPointFromDataBase error! ", localInvalidProtocolBufferMicroException);
    }
  }
  
  private void saveRedPointToDataBase(int paramInt, QQCircleCounter.RedPointInfo paramRedPointInfo)
  {
    QLog.d("QCircleEeveeRedPointManagerDelegate", 1, "saveRedPointToDataBase redPointMainMsgType: " + paramInt);
    if (paramRedPointInfo != null) {}
    try
    {
      QCircleEeveeMananger.getInstance().saveBizUndealMsgBuffer(paramInt, paramRedPointInfo.toByteArray());
      return;
    }
    catch (Throwable paramRedPointInfo)
    {
      QLog.e("QCircleEeveeRedPointManagerDelegate", 1, "saveRedPointToDataBase error! ", paramRedPointInfo);
    }
  }
  
  public void asyncGetNumRedPointInfoByAppid(String paramString, QCircleRedPointManager.OnGetQQCircleNumRedMsgListener paramOnGetQQCircleNumRedMsgListener, boolean paramBoolean)
  {
    if (paramOnGetQQCircleNumRedMsgListener == null) {
      return;
    }
    Object localObject = getNumRedPointInfotByAppid(paramString);
    int i = 0;
    Iterator localIterator = null;
    paramString = localIterator;
    if (localObject != null)
    {
      i = ((QQCircleCounter.RedPointInfo)localObject).redTotalNum.get();
      localObject = ((QQCircleCounter.RedPointInfo)localObject).rptRedInfo.get();
      if (localObject == null) {
        break label114;
      }
      paramString = new ArrayList();
      localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext()) {
        paramString.add(((QQCircleCounter.RedDisplayInfo)localIterator.next()).headImg.get());
      }
    }
    for (;;)
    {
      paramOnGetQQCircleNumRedMsgListener.onGet(paramString, i);
      return;
      label114:
      paramString = localIterator;
    }
  }
  
  public void clearPedPoint()
  {
    this.mCacheNumRedPointInfo = new QQCircleCounter.RedPointInfo();
    this.mCacheSmallRedPointInfo = new QQCircleCounter.RedPointInfo();
    this.mCacheOuterEntranceRedPointInfo = new QQCircleCounter.RedPointInfo();
    QQAppInterface localQQAppInterface = this.mApp;
    if (localQQAppInterface != null) {
      ((QCircleHandler)localQQAppInterface.getBusinessHandler(183)).updateRedPoint();
    }
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
    this.mApp = null;
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onNumRedPointClick(String paramString, ReportExtraInfo paramReportExtraInfo)
  {
    QLog.d("QCircleEeveeRedPointManagerDelegate", 1, "onNumRedPointClick appid: " + paramString);
  }
  
  public void onNumRedPointExposure(String paramString, ReportExtraInfo paramReportExtraInfo) {}
  
  public void onOuterEntranceRedPointClick(String paramString, ReportExtraInfo paramReportExtraInfo)
  {
    QLog.d("QCircleEeveeRedPointManagerDelegate", 1, "setOuterEntranceRedPointReaded appid: " + paramString);
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
      QLog.d("QCircleEeveeRedPointManagerDelegate", 1, "on receive repoint. redPointMainMsgType: " + localQCircleRedPointEvent.mRedPointMainMsgType);
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
      if ((i != 0) && (QCircleRedPointManager.isQQCircleCurrentUseEeveeRedPoint()))
      {
        paramSimpleBaseEvent = this.mApp;
        if (paramSimpleBaseEvent != null) {
          ((QCircleHandler)paramSimpleBaseEvent.getBusinessHandler(183)).updateRedPoint();
        }
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
    QLog.d("QCircleEeveeRedPointManagerDelegate", 1, "onSmallRedPointClick appid: " + paramString);
  }
  
  public void onSmallRedPointExposure(String paramString, ReportExtraInfo paramReportExtraInfo) {}
  
  public void setNumRedPointReaded(String arg1)
  {
    QLog.d("QCircleEeveeRedPointManagerDelegate", 1, "setNumRedPointReaded appid: " + ???);
    if (TextUtils.isEmpty(???)) {
      return;
    }
    QQCircleCounter.RedPointInfo localRedPointInfo = getLocalNumRedPointInfo();
    if (localRedPointInfo == null)
    {
      QLog.e("QCircleEeveeRedPointManagerDelegate", 1, "setNumRedPointReaded return. redPointInfo is null");
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
    QLog.d("QCircleEeveeRedPointManagerDelegate", 1, "setOuterEntranceRedPointReaded appid: " + ???);
    if (TextUtils.isEmpty(???)) {
      return;
    }
    if ((paramList == null) || (paramList.size() <= 0))
    {
      QLog.d("QCircleEeveeRedPointManagerDelegate", 1, "[setOuterEntranceRedPointReaded] clearRedTypeList is empty!");
      return;
    }
    QQCircleCounter.RedPointInfo localRedPointInfo = getLocalOuterEntranceRedPointInfo();
    if (localRedPointInfo == null)
    {
      QLog.e("QCircleEeveeRedPointManagerDelegate", 1, "setOuterEntranceRedPointReaded return. redPointInfo is null");
      return;
    }
    long l = localRedPointInfo.outLayerInfo.combineRedTypes.get();
    for (;;)
    {
      synchronized (this.mLock)
      {
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break label235;
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
      label235:
      localRedPointInfo.outLayerInfo.combineRedTypes.set(l);
      QLog.d("QCircleEeveeRedPointManagerDelegate", 1, "[setOuterEntranceRedPointReaded] combineRedTypes: " + l);
      asyncSaveRedPointInfoToDataBase(106, localRedPointInfo);
      return;
    }
  }
  
  public void setSmallRedPointReaded(String arg1)
  {
    QLog.d("QCircleEeveeRedPointManagerDelegate", 1, "setSmallRedPointReaded appid: " + ???);
    if (TextUtils.isEmpty(???)) {
      return;
    }
    QQCircleCounter.RedPointInfo localRedPointInfo = getLocalSmallRedPointInfo();
    if (localRedPointInfo == null)
    {
      QLog.e("QCircleEeveeRedPointManagerDelegate", 1, "setSmallRedPointReaded return. redPointInfo is null");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.redpoint.EeveeRedPointManagerDelegate
 * JD-Core Version:    0.7.0.1
 */