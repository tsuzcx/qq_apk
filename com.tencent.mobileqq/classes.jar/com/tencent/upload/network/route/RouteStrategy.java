package com.tencent.upload.network.route;

import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.utils.Const.FailureCode;
import com.tencent.upload.utils.UploadLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RouteStrategy
  implements IUploadRouteStrategy
{
  protected final String TAG = "RouteStrategy[" + hashCode() + "]";
  @Deprecated
  protected boolean mCausedByApnChanged = false;
  protected List<Integer> mPorts;
  protected Iterator<Integer> mPortsIterator;
  protected RecentRouteRecord mRecentRouteRecord;
  protected List<UploadRoute> mRoutes;
  protected Iterator<UploadRoute> mRoutesIterator;
  private ServerRouteTable mServerRouteTable;
  protected String mUsedApn;
  @Deprecated
  protected List<RouteStrategy.UsedRouteInfo> mUsedRouteInfos = new ArrayList();
  
  public RouteStrategy(ServerRouteTable paramServerRouteTable)
  {
    this.mServerRouteTable = paramServerRouteTable;
  }
  
  private void doInitParams()
  {
    this.mRoutes = getServerRouteTable().getUploadRoutes();
    if ((this.mRoutes == null) || (this.mRoutes.size() == 0)) {
      throw new RuntimeException(this.TAG + " doInitParams, getUploadRoutes illegal");
    }
    this.mPorts = RouteFactory.getUploadRoutePorts();
    if ((this.mPorts == null) || (this.mPorts.size() == 0)) {
      throw new RuntimeException(this.TAG + " doInitParams, getUploadRoutePorts illegal");
    }
    this.mRoutesIterator = this.mRoutes.iterator();
    this.mPortsIterator = this.mPorts.iterator();
    StringBuffer localStringBuffer = new StringBuffer(this.mRoutes.size());
    Iterator localIterator = this.mRoutes.iterator();
    while (localIterator.hasNext())
    {
      UploadRoute localUploadRoute = (UploadRoute)localIterator.next();
      localStringBuffer.append(localUploadRoute.toString() + " ");
    }
    UploadLog.d("[iplist] " + this.TAG, " doInitParams, all Route List:" + localStringBuffer.toString() + ", all Port List:" + this.mPorts.toString());
  }
  
  private UploadRoute getAvailableRoute()
  {
    if ((!this.mRoutesIterator.hasNext()) || (!this.mPortsIterator.hasNext()))
    {
      UploadLog.d(this.TAG, " getAvailableRoute return null");
      return null;
    }
    UploadRoute localUploadRoute1 = (UploadRoute)this.mRoutesIterator.next();
    localUploadRoute1.setPort(((Integer)this.mPortsIterator.next()).intValue());
    UploadRoute localUploadRoute2 = getRecentRoute();
    if ((localUploadRoute2 != null) && (localUploadRoute2.isDuplicate(localUploadRoute1)))
    {
      UploadLog.d(this.TAG, " getAvailableRoute isDuplicate with recent, matchNextRouteFormRouteTable:" + localUploadRoute1.toString());
      return matchNextRouteFormRouteTable(localUploadRoute1);
    }
    UploadLog.d(this.TAG, " getAvailableRoute return:" + localUploadRoute1.toString());
    return localUploadRoute1;
  }
  
  private UploadRoute getRecentRoute()
  {
    if (this.mRecentRouteRecord == null) {}
    UploadRoute localUploadRoute;
    do
    {
      return null;
      localUploadRoute = this.mRecentRouteRecord.getRecentRoute();
    } while (localUploadRoute == null);
    UploadLog.d(this.TAG, " getRecentRoute: " + localUploadRoute.toString());
    return localUploadRoute;
  }
  
  private boolean isApnChanged()
  {
    boolean bool = true;
    if (this.mUsedApn == null) {
      if (UploadConfiguration.getCurrentApn() == null) {
        bool = false;
      }
    }
    while (this.mUsedApn.compareToIgnoreCase(UploadConfiguration.getCurrentApn()) != 0) {
      return bool;
    }
    return false;
  }
  
  private void loadRecentRouteRecord()
  {
    String str = UploadConfiguration.getRecentRouteApnKey();
    if (str == null)
    {
      UploadLog.d(this.TAG, " loadRecentRouteRecord, unknown key");
      return;
    }
    this.mRecentRouteRecord = new RecentRouteRecordStorage(getServerRouteTable()).getData(str);
  }
  
  private UploadRoute matchNextRouteFormRouteTable(UploadRoute paramUploadRoute)
  {
    UploadRoute localUploadRoute1 = null;
    UploadRoute localUploadRoute2 = null;
    if (paramUploadRoute == null)
    {
      paramUploadRoute = localUploadRoute2;
      if (this.mRoutesIterator.hasNext()) {
        paramUploadRoute = (UploadRoute)this.mRoutesIterator.next();
      }
      UploadLog.d(this.TAG, "matchNextRouteFormRouteTable: lastRoute == null now = " + paramUploadRoute);
      localUploadRoute1 = paramUploadRoute;
      return localUploadRoute1;
    }
    paramUploadRoute = paramUploadRoute.clone();
    UploadLog.d(this.TAG, "matchNextRouteFormRouteTable: currentRoute:" + paramUploadRoute);
    if (this.mPortsIterator.hasNext())
    {
      paramUploadRoute.setPort(((Integer)this.mPortsIterator.next()).intValue());
      UploadLog.d(this.TAG, "matchNextRouteFormRouteTable: to next port" + paramUploadRoute);
    }
    for (;;)
    {
      localUploadRoute2 = getRecentRoute();
      localUploadRoute1 = paramUploadRoute;
      if (localUploadRoute2 == null) {
        break;
      }
      localUploadRoute1 = paramUploadRoute;
      if (!localUploadRoute2.isDuplicate(paramUploadRoute)) {
        break;
      }
      UploadLog.d(this.TAG, "matchNextRouteFormRouteTable: isDuplicate with recent" + paramUploadRoute.toString());
      return matchNextRouteFormRouteTable(paramUploadRoute);
      if (this.mRoutesIterator.hasNext())
      {
        this.mPortsIterator = this.mPorts.iterator();
        if (this.mPortsIterator.hasNext())
        {
          paramUploadRoute = ((UploadRoute)this.mRoutesIterator.next()).clone();
          paramUploadRoute.setPort(((Integer)this.mPortsIterator.next()).intValue());
          UploadLog.d(this.TAG, "matchNextRouteFormRouteTable: to next ip" + paramUploadRoute);
        }
        else
        {
          UploadLog.w(this.TAG, "matchNextRouteFormRouteTable: to next ip, but no port. exception");
          paramUploadRoute = localUploadRoute1;
        }
      }
      else
      {
        UploadLog.d(this.TAG, "matchNextRouteFormRouteTable: finish, return null");
        paramUploadRoute = localUploadRoute1;
      }
    }
  }
  
  public ServerRouteTable getServerRouteTable()
  {
    return this.mServerRouteTable;
  }
  
  public UploadRoute next(UploadRoute paramUploadRoute, int paramInt)
  {
    if (paramUploadRoute == null)
    {
      UploadLog.d(this.TAG, " next: null, route == null");
      return null;
    }
    this.mUsedRouteInfos.add(new RouteStrategy.UsedRouteInfo(paramUploadRoute.clone(), paramInt));
    boolean bool2 = UploadConfiguration.isNetworkAvailable();
    if (!bool2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.mCausedByApnChanged = bool1;
      if (bool2) {
        break;
      }
      UploadLog.d(this.TAG, " next: null, !isNetworkAvailable");
      return null;
    }
    bool1 = isApnChanged();
    this.mCausedByApnChanged = bool1;
    if (bool1)
    {
      UploadLog.d(this.TAG, " next: null, isApnChanged:" + bool1);
      return null;
    }
    Object localObject1;
    if ((paramInt != 4) && (paramUploadRoute.getRouteCategory() == IUploadRouteStrategy.RouteCategoryType.RECENT))
    {
      localObject1 = getAvailableRoute();
      if (localObject1 != null)
      {
        UploadLog.d(this.TAG, " next: return" + localObject1);
        return localObject1;
      }
    }
    bool1 = UploadConfiguration.isWapSetting();
    UploadLog.d(this.TAG, " next start: " + Const.FailureCode.print(paramInt) + " failureCode:" + paramInt + " wap:" + bool1);
    Object localObject2;
    StringBuilder localStringBuilder;
    switch (paramInt)
    {
    case 5: 
    default: 
      localObject1 = null;
      localObject2 = this.TAG;
      localStringBuilder = new StringBuilder().append(" next return: ");
      if (localObject1 != null) {
        break;
      }
    }
    for (paramUploadRoute = "null";; paramUploadRoute = ((UploadRoute)localObject1).toString())
    {
      UploadLog.d((String)localObject2, paramUploadRoute);
      return localObject1;
      localObject1 = matchNextRouteFormRouteTable(paramUploadRoute);
      break;
      while (this.mPortsIterator.hasNext()) {
        this.mPortsIterator.next();
      }
      localObject2 = matchNextRouteFormRouteTable(paramUploadRoute);
      localObject1 = localObject2;
      if (localObject2 == null) {
        break;
      }
      ((UploadRoute)localObject2).setRouteCategory(paramUploadRoute.getRouteCategory());
      localObject1 = localObject2;
      break;
    }
  }
  
  public UploadRoute reset()
  {
    this.mCausedByApnChanged = false;
    doInitParams();
    if (isApnChanged())
    {
      this.mUsedApn = UploadConfiguration.getCurrentApn();
      loadRecentRouteRecord();
    }
    UploadRoute localUploadRoute = getRecentRoute();
    if (localUploadRoute != null)
    {
      UploadLog.d(this.TAG, " reset, return recentRoute: " + localUploadRoute.toString());
      return localUploadRoute;
    }
    localUploadRoute = getAvailableRoute();
    if (localUploadRoute != null)
    {
      UploadLog.d(this.TAG, " reset, return firstRoute:" + localUploadRoute);
      return localUploadRoute;
    }
    UploadLog.d(this.TAG, " reset, return null");
    return null;
  }
  
  public boolean save(UploadRoute paramUploadRoute)
  {
    boolean bool = true;
    String str = UploadConfiguration.getRecentRouteApnKey();
    if (str == null)
    {
      UploadLog.d(this.TAG, "save, unknown key");
      bool = false;
    }
    do
    {
      return bool;
      if ((str == null) || (str.length() <= 0)) {
        break;
      }
    } while (paramUploadRoute.getIp().endsWith(".com"));
    this.mRecentRouteRecord = UploadConfiguration.saveAsRecentIp(getServerRouteTable(), str, paramUploadRoute);
    UploadLog.d(this.TAG, " save: as recent:" + paramUploadRoute + " recentApnKey:" + str);
    return true;
    UploadLog.d(this.TAG, " save: apnKey isNullOrEmpty");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.network.route.RouteStrategy
 * JD-Core Version:    0.7.0.1
 */