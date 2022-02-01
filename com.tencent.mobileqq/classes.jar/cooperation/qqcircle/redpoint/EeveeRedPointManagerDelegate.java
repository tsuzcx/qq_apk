package cooperation.qqcircle.redpoint;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.handler.QCircleHandler;
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
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.OnGetQQCircleNumRedMsgListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.eevee.QCircleEeveeMananger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import qqcircle.QQCircleCounter.OutLayerPointInfo;
import qqcircle.QQCircleCounter.RedPointInfo;
import qqcircle.QQCircleCounter.RedPointJumpInfo;

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
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("loadLocalNumRedPointInfoFromDataBase ");
        if (??? != null)
        {
          bool = true;
          ((StringBuilder)localObject2).append(bool);
          QLog.d("QCircleEeveeRedPointManagerDelegate", 1, ((StringBuilder)localObject2).toString());
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
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("loadLocalNumRedPointInfoFromDataBase ");
        if (??? != null)
        {
          bool = true;
          ((StringBuilder)localObject2).append(bool);
          QLog.d("QCircleEeveeRedPointManagerDelegate", 1, ((StringBuilder)localObject2).toString());
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
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("loadLocalSmallRedPointFromDataBase ");
    boolean bool;
    if (??? != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject2).append(bool);
    QLog.d("QCircleEeveeRedPointManagerDelegate", 1, ((StringBuilder)localObject2).toString());
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
      QLog.e("QCircleEeveeRedPointManagerDelegate", 1, "loadLocalSmallRedPointFromDataBase error! ", localInvalidProtocolBufferMicroException);
    }
  }
  
  private void saveRedPointToDataBase(int paramInt, QQCircleCounter.RedPointInfo paramRedPointInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("saveRedPointToDataBase redPointMainMsgType: ");
    localStringBuilder.append(paramInt);
    QLog.d("QCircleEeveeRedPointManagerDelegate", 1, localStringBuilder.toString());
    if (paramRedPointInfo != null) {
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
  }
  
  public void asyncGetNumRedPointInfoByAppid(String paramString, OnGetQQCircleNumRedMsgListener paramOnGetQQCircleNumRedMsgListener, boolean paramBoolean)
  {
    if (paramOnGetQQCircleNumRedMsgListener == null) {
      return;
    }
    Object localObject3 = getNumRedPointInfotByAppid(paramString);
    int i = 0;
    Object localObject2 = new ArrayList();
    Object localObject1 = localObject3;
    if (!EeveeRedpointUtil.isValidRedPointInfo(paramString, (QQCircleCounter.RedPointInfo)localObject3))
    {
      QLog.d("QCircleEeveeRedPointManagerDelegate", 1, "asyncGetNumRedPointInfoByAppid invalid red point info! ignore it.");
      localObject1 = null;
    }
    paramString = "";
    if (localObject1 != null)
    {
      i = ((QQCircleCounter.RedPointInfo)localObject1).redTotalNum.get();
      localObject2 = ((QQCircleCounter.RedPointInfo)localObject1).wording.get();
      paramString = ((QQCircleCounter.RedPointInfo)localObject1).redJumpInfo.jumpLink.get();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("redTotalNum=");
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append("word=");
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append("&jumpLink=");
      ((StringBuilder)localObject3).append(paramString);
      QLog.d("QCircleEeveeRedPointManagerDelegate", 1, ((StringBuilder)localObject3).toString());
      localObject3 = QCircleHostUtil.convertRedDisplayInfoToString(((QQCircleCounter.RedPointInfo)localObject1).rptRedInfo.get());
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
    else
    {
      localObject3 = "";
      localObject1 = paramString;
      paramString = (String)localObject3;
    }
    paramOnGetQQCircleNumRedMsgListener.onGet((List)localObject2, i, (String)localObject1, paramString);
  }
  
  public void clearPedPoint()
  {
    this.mCacheNumRedPointInfo = new QQCircleCounter.RedPointInfo();
    this.mCacheSmallRedPointInfo = new QQCircleCounter.RedPointInfo();
    this.mCacheOuterEntranceRedPointInfo = new QQCircleCounter.RedPointInfo();
    if (QCircleHandler.d() != null) {
      QCircleHandler.d().b();
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
    paramReportExtraInfo = new StringBuilder();
    paramReportExtraInfo.append("onNumRedPointClick appid: ");
    paramReportExtraInfo.append(paramString);
    QLog.d("QCircleEeveeRedPointManagerDelegate", 1, paramReportExtraInfo.toString());
  }
  
  public void onNumRedPointExposure(String paramString, ReportExtraInfo paramReportExtraInfo) {}
  
  public void onOuterEntranceRedPointClick(String paramString, ReportExtraInfo paramReportExtraInfo)
  {
    paramReportExtraInfo = new StringBuilder();
    paramReportExtraInfo.append("setOuterEntranceRedPointReaded appid: ");
    paramReportExtraInfo.append(paramString);
    QLog.d("QCircleEeveeRedPointManagerDelegate", 1, paramReportExtraInfo.toString());
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
      ??? = new StringBuilder();
      ((StringBuilder)???).append("on receive repoint. redPointMainMsgType: ");
      ((StringBuilder)???).append(localQCircleRedPointEvent.mRedPointMainMsgType);
      ??? = ((StringBuilder)???).toString();
      int i = 1;
      QLog.d("QCircleEeveeRedPointManagerDelegate", 1, (String)???);
      int j = localQCircleRedPointEvent.mRedPointMainMsgType;
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
        if ((i != 0) && (QCircleHandler.d() != null))
        {
          QCircleHandler.d().b();
          return;
        }
      }
    }
  }
  
  public void onSmallRedPointClick(String paramString, ReportExtraInfo paramReportExtraInfo)
  {
    paramReportExtraInfo = new StringBuilder();
    paramReportExtraInfo.append("onSmallRedPointClick appid: ");
    paramReportExtraInfo.append(paramString);
    QLog.d("QCircleEeveeRedPointManagerDelegate", 1, paramReportExtraInfo.toString());
  }
  
  public void onSmallRedPointExposure(String paramString, ReportExtraInfo paramReportExtraInfo) {}
  
  public void setNumRedPointReaded(String arg1)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setNumRedPointReaded appid: ");
    ((StringBuilder)localObject1).append(???);
    QLog.d("QCircleEeveeRedPointManagerDelegate", 1, ((StringBuilder)localObject1).toString());
    if (TextUtils.isEmpty(???)) {
      return;
    }
    localObject1 = getLocalNumRedPointInfo();
    if (localObject1 == null)
    {
      QLog.e("QCircleEeveeRedPointManagerDelegate", 1, "setNumRedPointReaded return. redPointInfo is null");
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setOuterEntranceRedPointReaded appid: ");
    ((StringBuilder)localObject).append(???);
    QLog.d("QCircleEeveeRedPointManagerDelegate", 1, ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(???)) {
      return;
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      localObject = getLocalOuterEntranceRedPointInfo();
      if (localObject == null)
      {
        QLog.e("QCircleEeveeRedPointManagerDelegate", 1, "setOuterEntranceRedPointReaded return. redPointInfo is null");
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
          int i = localInteger.intValue();
          if (i != 1)
          {
            if (i != 2)
            {
              if ((i == 3) || (i == 6)) {
                ((QQCircleCounter.RedPointInfo)localObject).wording.clear();
              }
            }
            else
            {
              ((QQCircleCounter.RedPointInfo)localObject).redTotalNum.clear();
              ((QQCircleCounter.RedPointInfo)localObject).wording.clear();
            }
          }
          else
          {
            ((QQCircleCounter.RedPointInfo)localObject).rptRedInfo.clear();
            ((QQCircleCounter.RedPointInfo)localObject).wording.clear();
          }
        }
        ((QQCircleCounter.RedPointInfo)localObject).outLayerInfo.combineRedTypes.set(l);
        paramList = new StringBuilder();
        paramList.append("[setOuterEntranceRedPointReaded] combineRedTypes: ");
        paramList.append(l);
        QLog.d("QCircleEeveeRedPointManagerDelegate", 1, paramList.toString());
        asyncSaveRedPointInfoToDataBase(106, (QQCircleCounter.RedPointInfo)localObject);
        return;
      }
    }
    QLog.d("QCircleEeveeRedPointManagerDelegate", 1, "[setOuterEntranceRedPointReaded] clearRedTypeList is empty!");
  }
  
  public void setSmallRedPointReaded(String arg1)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setSmallRedPointReaded appid: ");
    ((StringBuilder)localObject1).append(???);
    QLog.d("QCircleEeveeRedPointManagerDelegate", 1, ((StringBuilder)localObject1).toString());
    if (TextUtils.isEmpty(???)) {
      return;
    }
    localObject1 = getLocalSmallRedPointInfo();
    if (localObject1 == null)
    {
      QLog.e("QCircleEeveeRedPointManagerDelegate", 1, "setSmallRedPointReaded return. redPointInfo is null");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.redpoint.EeveeRedPointManagerDelegate
 * JD-Core Version:    0.7.0.1
 */