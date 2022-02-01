package cooperation.qqcircle.utils;

import com.tencent.biz.qcircleshadow.local.requests.QCircleGetFollowListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.beans.Friend;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import vvv;

public class QCircleDoubleFollowUserHepler
{
  public static final long REQUEST_INTERNAL = 43200000L;
  public static final String TAG = "QCircleDoubleFollowUserHepler";
  private static QCircleDoubleFollowUserHepler sInstance;
  private EntityManager mEm;
  private List<Friend> mFriends = new ArrayList();
  private ArrayList<Friend> mFriends_temp = new ArrayList();
  
  private ArrayList<Entity> convertQQFriends(List<Friend> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Friend localFriend = (Friend)paramList.next();
      if (localFriend != null)
      {
        Friends localFriends = new Friends();
        localFriends.uin = String.valueOf(localFriend.mUin);
        localFriends.name = localFriend.mName;
        localFriends.remark = localFriend.mName;
        localArrayList.add(localFriends);
      }
    }
    if (localArrayList.size() > 0) {
      return localArrayList;
    }
    return null;
  }
  
  private ArrayList<RecentUser> convertRecentUser(List<Friend> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (Friend)localIterator.next();
      if (paramList != null)
      {
        if (QCircleCommonUtil.isFriend(String.valueOf(paramList.mUin))) {}
        for (paramList = new RecentUser(String.valueOf(paramList.mUin), 0);; paramList = new RecentUser(String.valueOf(paramList.mUin), 10008))
        {
          localArrayList.add(paramList);
          break;
        }
      }
    }
    if (localArrayList.size() > 0) {
      return localArrayList;
    }
    return null;
  }
  
  private void doGetFollowUser(String paramString, long paramLong)
  {
    VSNetworkHelper.getInstance().sendRequest(new QCircleGetFollowListRequest(paramString, paramLong), new QCircleDoubleFollowUserHepler.1(this));
  }
  
  private QQAppInterface getApp()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (localAppRuntime == null) {
      return null;
    }
    if (!(localAppRuntime instanceof QQAppInterface)) {
      return null;
    }
    return (QQAppInterface)localAppRuntime;
  }
  
  public static QCircleDoubleFollowUserHepler getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new QCircleDoubleFollowUserHepler();
      }
      return sInstance;
    }
    finally {}
  }
  
  public static void releaseInstance()
  {
    if (sInstance != null) {
      try
      {
        if (sInstance != null) {
          sInstance = null;
        }
        return;
      }
      finally {}
    }
  }
  
  public void doGetFollowUser()
  {
    if (System.currentTimeMillis() - vvv.a() > QzoneConfig.getQQCircleGetFollowUserInternal())
    {
      this.mFriends_temp.clear();
      doGetFollowUser(null, 0L);
    }
  }
  
  public ArrayList<Entity> getFollowUserList()
  {
    Object localObject2 = null;
    Object localObject1;
    if ((this.mFriends != null) && (this.mFriends.size() > 0)) {
      localObject1 = convertQQFriends(this.mFriends);
    }
    do
    {
      QQAppInterface localQQAppInterface;
      do
      {
        return localObject1;
        localQQAppInterface = getApp();
        localObject1 = localObject2;
      } while (localQQAppInterface == null);
      if (this.mEm == null) {
        this.mEm = localQQAppInterface.getEntityManagerFactory().createEntityManager();
      }
      this.mFriends = this.mEm.query(Friend.class);
      if (this.mFriends != null) {
        break;
      }
      this.mFriends = new ArrayList();
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.i("QCircleDoubleFollowUserHepler", 2, "there has no double friends");
    return null;
    return convertQQFriends(this.mFriends);
  }
  
  public ArrayList<RecentUser> getFollowUserListToRecentUser()
  {
    Object localObject2 = null;
    Object localObject1;
    if ((this.mFriends != null) && (this.mFriends.size() > 0)) {
      localObject1 = convertRecentUser(this.mFriends);
    }
    do
    {
      QQAppInterface localQQAppInterface;
      do
      {
        return localObject1;
        localQQAppInterface = getApp();
        localObject1 = localObject2;
      } while (localQQAppInterface == null);
      if (this.mEm == null) {
        this.mEm = localQQAppInterface.getEntityManagerFactory().createEntityManager();
      }
      this.mFriends = this.mEm.query(Friend.class);
      if (this.mFriends != null) {
        break;
      }
      this.mFriends = new ArrayList();
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.i("QCircleDoubleFollowUserHepler", 2, "there has no double friends");
    return null;
    return convertRecentUser(this.mFriends);
  }
  
  public void updateFollowUser(String paramString1, String paramString2, boolean paramBoolean)
  {
    long l;
    QQAppInterface localQQAppInterface;
    try
    {
      l = Long.parseLong(paramString1);
      localQQAppInterface = getApp();
      if (localQQAppInterface == null) {
        return;
      }
    }
    catch (Exception paramString1)
    {
      QLog.e("QCircleDoubleFollowUserHepler", 1, paramString1, new Object[0]);
      return;
    }
    Friend localFriend;
    if (!paramBoolean)
    {
      paramString2 = this.mFriends.iterator();
      do
      {
        if (!paramString2.hasNext()) {
          break;
        }
        localFriend = (Friend)paramString2.next();
      } while ((localFriend == null) || (localFriend.mUin != l));
      this.mFriends.remove(localFriend);
      if (this.mEm == null) {
        this.mEm = localQQAppInterface.getEntityManagerFactory().createEntityManager();
      }
      ThreadManagerV2.excute(new QCircleDoubleFollowUserHepler.3(this, paramString1), 32, null, true);
      return;
    }
    paramString1 = this.mFriends.iterator();
    while (paramString1.hasNext())
    {
      localFriend = (Friend)paramString1.next();
      if ((localFriend != null) && (localFriend.mUin == l)) {
        return;
      }
    }
    paramString1 = new Friend(l, paramString2);
    this.mFriends.add(paramString1);
    if (this.mEm == null) {
      this.mEm = localQQAppInterface.getEntityManagerFactory().createEntityManager();
    }
    ThreadManagerV2.excute(new QCircleDoubleFollowUserHepler.4(this, paramString1), 32, null, true);
  }
  
  public void updateFollowUserList(List<Friend> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCircleDoubleFollowUserHepler", 2, "updateRenameList");
    }
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {}
    do
    {
      return;
      if (this.mEm == null) {
        this.mEm = localQQAppInterface.getEntityManagerFactory().createEntityManager();
      }
    } while ((paramList == null) || (paramList.size() == 0));
    ThreadManagerV2.excute(new QCircleDoubleFollowUserHepler.2(this, paramList), 32, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.utils.QCircleDoubleFollowUserHepler
 * JD-Core Version:    0.7.0.1
 */