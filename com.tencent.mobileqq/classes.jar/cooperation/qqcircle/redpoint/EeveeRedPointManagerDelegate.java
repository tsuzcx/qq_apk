package cooperation.qqcircle.redpoint;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.handler.QCircleHandler;
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
import com.tencent.mobileqq.qcircle.api.requests.QCircleRedPointEvent;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
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
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        ThreadManager.getSubThreadHandler().post(new EeveeRedPointManagerDelegate.4(this, paramInt, paramRedPointInfo));
        return;
      }
      saveRedPointToDataBase(paramInt, paramRedPointInfo);
    }
  }
  
  private void loadLocalNumRedPointInfoFromDataBase()
  {
    for (;;)
    {
      try
      {
        ??? = QCircleEeveeMananger.getInstance().getBizUndealMsgBuffer(102);
        int i = RFLog.USR;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("loadLocalNumRedPointInfoFromDataBase ");
        if (??? != null)
        {
          bool = true;
          ((StringBuilder)localObject2).append(bool);
          RFLog.d("QCircleEeveeRedPointManagerDelegate", i, ((StringBuilder)localObject2).toString());
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
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("loadLocalNumRedPointInfoFromDataBase ");
        if (??? != null)
        {
          bool = true;
          ((StringBuilder)localObject2).append(bool);
          RFLog.d("QCircleEeveeRedPointManagerDelegate", i, ((StringBuilder)localObject2).toString());
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
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("loadLocalSmallRedPointFromDataBase ");
    boolean bool;
    if (??? != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject2).append(bool);
    RFLog.d("QCircleEeveeRedPointManagerDelegate", i, ((StringBuilder)localObject2).toString());
    if (??? == null) {
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
    int i = RFLog.USR;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("saveRedPointToDataBase redPointMainMsgType: ");
    localStringBuilder.append(paramInt);
    RFLog.d("QCircleEeveeRedPointManagerDelegate", i, localStringBuilder.toString());
    if (paramRedPointInfo != null) {
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
  }
  
  public void asyncGetNumRedPointInfoByAppid(String paramString, OnGetQQCircleNumRedMsgListener paramOnGetQQCircleNumRedMsgListener, boolean paramBoolean)
  {
    if (paramOnGetQQCircleNumRedMsgListener == null) {
      return;
    }
    Object localObject = getNumRedPointInfotByAppid(paramString);
    int i = 0;
    paramBoolean = EeveeRedpointUtil.isValidRedPointInfo(paramString, (QQCircleCounter.RedPointInfo)localObject);
    Iterator localIterator = null;
    if (!paramBoolean)
    {
      RFLog.d("QCircleEeveeRedPointManagerDelegate", RFLog.USR, "asyncGetNumRedPointInfoByAppid invalid red point info! ignore it.");
      localObject = null;
    }
    paramString = localIterator;
    if (localObject != null)
    {
      int j = ((QQCircleCounter.RedPointInfo)localObject).redTotalNum.get();
      List localList = ((QQCircleCounter.RedPointInfo)localObject).rptRedInfo.get();
      i = j;
      paramString = localIterator;
      if (localList != null)
      {
        localObject = new ArrayList();
        localIterator = localList.iterator();
        for (;;)
        {
          i = j;
          paramString = (String)localObject;
          if (!localIterator.hasNext()) {
            break;
          }
          ((List)localObject).add(((QQCircleCounter.RedDisplayInfo)localIterator.next()).headImg.get());
        }
      }
    }
    paramOnGetQQCircleNumRedMsgListener.onGet(paramString, i);
  }
  
  public void clearPedPoint()
  {
    this.mCacheNumRedPointInfo = new QQCircleCounter.RedPointInfo();
    this.mCacheSmallRedPointInfo = new QQCircleCounter.RedPointInfo();
    this.mCacheOuterEntranceRedPointInfo = new QQCircleCounter.RedPointInfo();
    if (QCircleHandler.a() != null) {
      QCircleHandler.a().b();
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
    synchronized (this.mLock)
    {
      if (this.mCacheNumRedPointInfo != null)
      {
        QQCircleCounter.RedPointInfo localRedPointInfo = this.mCacheNumRedPointInfo;
        return localRedPointInfo;
      }
      if (Looper.getMainLooper() == Looper.myLooper()) {
        ThreadManager.getSubThreadHandler().post(new EeveeRedPointManagerDelegate.3(this));
      } else {
        loadLocalNumRedPointInfoFromDataBase();
      }
      return null;
    }
  }
  
  public QQCircleCounter.RedPointInfo getLocalOuterEntranceRedPointInfo()
  {
    synchronized (this.mLock)
    {
      if (this.mCacheOuterEntranceRedPointInfo != null)
      {
        QQCircleCounter.RedPointInfo localRedPointInfo = this.mCacheOuterEntranceRedPointInfo;
        return localRedPointInfo;
      }
      if (Looper.getMainLooper() == Looper.myLooper()) {
        ThreadManager.getSubThreadHandler().post(new EeveeRedPointManagerDelegate.2(this));
      } else {
        loadLocalOuterEntranceRedPointFromDataBase();
      }
      return null;
    }
  }
  
  public QQCircleCounter.RedPointInfo getLocalSmallRedPointInfo()
  {
    synchronized (this.mLock)
    {
      if (this.mCacheSmallRedPointInfo != null)
      {
        QQCircleCounter.RedPointInfo localRedPointInfo = this.mCacheSmallRedPointInfo;
        return localRedPointInfo;
      }
      if (Looper.getMainLooper() == Looper.myLooper()) {
        ThreadManager.getSubThreadHandler().post(new EeveeRedPointManagerDelegate.1(this));
      } else {
        loadLocalSmallRedPointFromDataBase();
      }
      return null;
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
    int i = RFLog.USR;
    paramReportExtraInfo = new StringBuilder();
    paramReportExtraInfo.append("onNumRedPointClick appid: ");
    paramReportExtraInfo.append(paramString);
    RFLog.d("QCircleEeveeRedPointManagerDelegate", i, paramReportExtraInfo.toString());
  }
  
  public void onNumRedPointExposure(String paramString, ReportExtraInfo paramReportExtraInfo) {}
  
  public void onOuterEntranceRedPointClick(String paramString, ReportExtraInfo paramReportExtraInfo)
  {
    int i = RFLog.USR;
    paramReportExtraInfo = new StringBuilder();
    paramReportExtraInfo.append("setOuterEntranceRedPointReaded appid: ");
    paramReportExtraInfo.append(paramString);
    RFLog.d("QCircleEeveeRedPointManagerDelegate", i, paramReportExtraInfo.toString());
  }
  
  public void onOuterEntranceRedPointExposure(String paramString, ReportExtraInfo paramReportExtraInfo) {}
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleRedPointEvent))
    {
      QCircleRedPointEvent localQCircleRedPointEvent = (QCircleRedPointEvent)paramSimpleBaseEvent;
      ??? = localQCircleRedPointEvent.mRedPointInfo;
      paramSimpleBaseEvent = (SimpleBaseEvent)???;
      if (??? == null) {
        paramSimpleBaseEvent = new QQCircleCounter.RedPointInfo();
      }
      int i = RFLog.USR;
      ??? = new StringBuilder();
      ((StringBuilder)???).append("on receive repoint. redPointMainMsgType: ");
      ((StringBuilder)???).append(localQCircleRedPointEvent.mRedPointMainMsgType);
      RFLog.d("QCircleEeveeRedPointManagerDelegate", i, ((StringBuilder)???).toString());
      int j = localQCircleRedPointEvent.mRedPointMainMsgType;
      i = 1;
      if (j != 101)
      {
        if (j != 102)
        {
          if (j != 106)
          {
            i = 0;
            break label180;
          }
          synchronized (this.mLock)
          {
            this.mCacheOuterEntranceRedPointInfo = paramSimpleBaseEvent;
          }
        }
        synchronized (this.mLock)
        {
          this.mCacheNumRedPointInfo = paramSimpleBaseEvent;
        }
      }
      synchronized (this.mLock)
      {
        this.mCacheSmallRedPointInfo = paramSimpleBaseEvent;
        label180:
        if ((i != 0) && (QCircleHandler.a() != null))
        {
          QCircleHandler.a().b();
          return;
        }
      }
    }
  }
  
  public void onSmallRedPointClick(String paramString, ReportExtraInfo paramReportExtraInfo)
  {
    int i = RFLog.USR;
    paramReportExtraInfo = new StringBuilder();
    paramReportExtraInfo.append("onSmallRedPointClick appid: ");
    paramReportExtraInfo.append(paramString);
    RFLog.d("QCircleEeveeRedPointManagerDelegate", i, paramReportExtraInfo.toString());
  }
  
  public void onSmallRedPointExposure(String paramString, ReportExtraInfo paramReportExtraInfo) {}
  
  public void setNumRedPointReaded(String arg1)
  {
    int i = RFLog.USR;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setNumRedPointReaded appid: ");
    ((StringBuilder)localObject1).append(???);
    RFLog.d("QCircleEeveeRedPointManagerDelegate", i, ((StringBuilder)localObject1).toString());
    if (TextUtils.isEmpty(???)) {
      return;
    }
    localObject1 = getLocalNumRedPointInfo();
    if (localObject1 == null)
    {
      RFLog.e("QCircleEeveeRedPointManagerDelegate", RFLog.USR, "setNumRedPointReaded return. redPointInfo is null");
      return;
    }
    EeveeRedpointUtil.saveLastReadedNumRedPointTimestamp(((QQCircleCounter.RedPointInfo)localObject1).lastVisitTime.get());
    synchronized (this.mLock)
    {
      ((QQCircleCounter.RedPointInfo)localObject1).clear();
      asyncSaveRedPointInfoToDataBase(102, (QQCircleCounter.RedPointInfo)localObject1);
      return;
    }
  }
  
  public void setOuterEntranceRedPointReaded(String arg1, List<Integer> paramList)
  {
    int i = RFLog.USR;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setOuterEntranceRedPointReaded appid: ");
    ((StringBuilder)localObject).append(???);
    RFLog.d("QCircleEeveeRedPointManagerDelegate", i, ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(???)) {
      return;
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      localObject = getLocalOuterEntranceRedPointInfo();
      if (localObject == null)
      {
        RFLog.e("QCircleEeveeRedPointManagerDelegate", RFLog.USR, "setOuterEntranceRedPointReaded return. redPointInfo is null");
        return;
      }
      long l = ((QQCircleCounter.RedPointInfo)localObject).outLayerInfo.combineRedTypes.get();
      synchronized (this.mLock)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Integer localInteger = (Integer)paramList.next();
          l &= (1 << localInteger.intValue() ^ 0xFFFFFFFF);
          i = localInteger.intValue();
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3)
              {
                if (i == 6) {
                  ((QQCircleCounter.RedPointInfo)localObject).pymkRedInfo.wording.clear();
                }
              }
              else {
                ((QQCircleCounter.RedPointInfo)localObject).allPushInfo.wording.clear();
              }
            }
            else {
              ((QQCircleCounter.RedPointInfo)localObject).redTotalNum.clear();
            }
          }
          else {
            ((QQCircleCounter.RedPointInfo)localObject).rptRedInfo.clear();
          }
        }
        ((QQCircleCounter.RedPointInfo)localObject).outLayerInfo.combineRedTypes.set(l);
        i = RFLog.USR;
        paramList = new StringBuilder();
        paramList.append("[setOuterEntranceRedPointReaded] combineRedTypes: ");
        paramList.append(l);
        RFLog.d("QCircleEeveeRedPointManagerDelegate", i, paramList.toString());
        asyncSaveRedPointInfoToDataBase(106, (QQCircleCounter.RedPointInfo)localObject);
        return;
      }
    }
    RFLog.d("QCircleEeveeRedPointManagerDelegate", RFLog.USR, "[setOuterEntranceRedPointReaded] clearRedTypeList is empty!");
  }
  
  public void setSmallRedPointReaded(String arg1)
  {
    int i = RFLog.USR;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setSmallRedPointReaded appid: ");
    ((StringBuilder)localObject1).append(???);
    RFLog.d("QCircleEeveeRedPointManagerDelegate", i, ((StringBuilder)localObject1).toString());
    if (TextUtils.isEmpty(???)) {
      return;
    }
    localObject1 = getLocalSmallRedPointInfo();
    if (localObject1 == null)
    {
      RFLog.e("QCircleEeveeRedPointManagerDelegate", RFLog.USR, "setSmallRedPointReaded return. redPointInfo is null");
      return;
    }
    EeveeRedpointUtil.saveLastReadedSmallRedPointTimestamp(((QQCircleCounter.RedPointInfo)localObject1).lastVisitTime.get());
    synchronized (this.mLock)
    {
      ((QQCircleCounter.RedPointInfo)localObject1).clear();
      asyncSaveRedPointInfoToDataBase(101, (QQCircleCounter.RedPointInfo)localObject1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.qqcircle.redpoint.EeveeRedPointManagerDelegate
 * JD-Core Version:    0.7.0.1
 */