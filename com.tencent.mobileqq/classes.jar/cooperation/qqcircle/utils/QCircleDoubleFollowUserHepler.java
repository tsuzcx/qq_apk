package cooperation.qqcircle.utils;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.api.requests.QCircleGetFollowListRequest;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostConfig;
import cooperation.qqcircle.QCircleConfig;
import cooperation.qqcircle.beans.Friend;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
  
  private void doGetFollowUser(String paramString, long paramLong)
  {
    VSNetworkHelper.getInstance().sendRequest(new QCircleGetFollowListRequest(paramString, paramLong), new QCircleDoubleFollowUserHepler.1(this));
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
    if (System.currentTimeMillis() - QCircleHostConfig.getGetFollowUserTime() > QCircleConfig.getQQCircleGetFollowUserInternal())
    {
      this.mFriends_temp.clear();
      doGetFollowUser(null, 0L);
    }
  }
  
  public ArrayList<Entity> getFollowUserList()
  {
    if ((this.mFriends != null) && (this.mFriends.size() > 0)) {
      return convertQQFriends(this.mFriends);
    }
    if (this.mEm == null) {
      this.mEm = QCircleServiceImpl.getEntityManager();
    }
    this.mFriends = this.mEm.query(Friend.class);
    if (this.mFriends == null)
    {
      this.mFriends = new ArrayList();
      if (RFLog.isColorLevel()) {
        RFLog.i("QCircleDoubleFollowUserHepler", RFLog.CLR, "there has no double friends");
      }
      return null;
    }
    return convertQQFriends(this.mFriends);
  }
  
  public void updateFollowUser(String paramString1, String paramString2, boolean paramBoolean)
  {
    long l;
    Friend localFriend;
    try
    {
      l = Long.parseLong(paramString1);
      if (!paramBoolean)
      {
        paramString2 = this.mFriends.iterator();
        while (paramString2.hasNext())
        {
          localFriend = (Friend)paramString2.next();
          if ((localFriend != null) && (localFriend.mUin == l))
          {
            this.mFriends.remove(localFriend);
            if (this.mEm == null) {
              this.mEm = QCircleServiceImpl.getEntityManager();
            }
            ThreadManagerV2.excute(new QCircleDoubleFollowUserHepler.3(this, paramString1), 32, null, true);
          }
        }
        return;
      }
    }
    catch (Exception paramString1)
    {
      RFLog.e("QCircleDoubleFollowUserHepler", RFLog.USR, new Object[] { paramString1 });
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
      this.mEm = QCircleServiceImpl.getEntityManager();
    }
    ThreadManagerV2.excute(new QCircleDoubleFollowUserHepler.4(this, paramString1), 32, null, true);
  }
  
  public void updateFollowUserList(List<Friend> paramList)
  {
    if (RFLog.isColorLevel()) {
      RFLog.d("QCircleDoubleFollowUserHepler", RFLog.CLR, "updateRenameList");
    }
    if (this.mEm == null) {
      this.mEm = QCircleServiceImpl.getEntityManager();
    }
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    ThreadManagerV2.excute(new QCircleDoubleFollowUserHepler.2(this, paramList), 32, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.utils.QCircleDoubleFollowUserHepler
 * JD-Core Version:    0.7.0.1
 */