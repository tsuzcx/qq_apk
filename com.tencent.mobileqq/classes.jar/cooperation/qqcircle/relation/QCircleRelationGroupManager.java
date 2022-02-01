package cooperation.qqcircle.relation;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostConfig;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.relation.entitys.NewRelationInfo;
import cooperation.qqcircle.relation.entitys.QCircleFriendEntity;
import cooperation.qqcircle.relation.format.QCircleFriendFormat;
import cooperation.qqcircle.relation.request.IQCircleRelationModel;
import cooperation.qqcircle.relation.request.QCircleRelationModel;
import feedcloud.FeedCloudMeta.StRelationInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import qqcircle.QQCircleRelation.RelationBiz;

public class QCircleRelationGroupManager
{
  private static final int BIT_FLAG = 1;
  private static final int DEF_GROUP_FLAG = 0;
  public static final int FOLLOW_LOAD_SCENE = 1;
  private static volatile QCircleRelationGroupManager INSTANCE;
  public static final int INTERVAL_LOAD_SCENE = 0;
  public static final String TAG = "RFL-QCircleAtGroupManager";
  private EntityManager mEntityManager;
  private final List<QCircleFriendEntity> mFriendEntityList = new ArrayList();
  
  private void addFriendEntity(String paramString1, String paramString2)
  {
    QLog.d("RFL-QCircleAtGroupManager", 1, new Object[] { "[addFriendEntity] uin: ", paramString1, " | name: ", paramString2 });
    loadRelationGroupData(1);
  }
  
  private void asyncInitFriendCache()
  {
    ThreadManagerV2.excute(new QCircleRelationGroupManager.2(this), 32, null, true);
  }
  
  private QCircleFriendEntity buildFriendEntity(String paramString, NewRelationInfo paramNewRelationInfo)
  {
    if (paramNewRelationInfo != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      Object localObject = paramNewRelationInfo.getRelationInfo();
      if (localObject == null) {
        return null;
      }
      long l = Long.parseLong(((FeedCloudMeta.StRelationInfo)localObject).id.get());
      localObject = parseNickName((FeedCloudMeta.StRelationInfo)localObject);
      int i = paramNewRelationInfo.getGroupFlag();
      paramNewRelationInfo = new QCircleFriendEntity();
      paramNewRelationInfo.setUin(l);
      paramNewRelationInfo.setName((String)localObject);
      paramNewRelationInfo.setGroupName(paramString);
      paramNewRelationInfo.setGroupFlag(i);
      return paramNewRelationInfo;
    }
    return null;
  }
  
  private List<QCircleFriendEntity> convertFriendList(Map<String, List<NewRelationInfo>> paramMap)
  {
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject1 = (Map.Entry)paramMap.next();
        Object localObject2 = (List)((Map.Entry)localObject1).getValue();
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          localObject1 = (String)((Map.Entry)localObject1).getKey();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            QCircleFriendEntity localQCircleFriendEntity = buildFriendEntity((String)localObject1, (NewRelationInfo)((Iterator)localObject2).next());
            if (localQCircleFriendEntity != null) {
              localArrayList.add(localQCircleFriendEntity);
            }
          }
        }
      }
      return localArrayList;
    }
    QLog.w("RFL-QCircleAtGroupManager", 1, "[convertFriendList] current results not is null.");
    return null;
  }
  
  private void deleteFriendEntityToDB(QCircleFriendEntity paramQCircleFriendEntity)
  {
    ThreadManagerV2.excute(new QCircleRelationGroupManager.DeleteFriendDBTask(paramQCircleFriendEntity, getEntityManager()), 32, null, true);
  }
  
  private QCircleFriendEntity findFriendEntityList(long paramLong)
  {
    if (this.mFriendEntityList.isEmpty()) {
      return null;
    }
    Iterator localIterator = this.mFriendEntityList.iterator();
    while (localIterator.hasNext())
    {
      QCircleFriendEntity localQCircleFriendEntity = (QCircleFriendEntity)localIterator.next();
      if ((localQCircleFriendEntity != null) && (localQCircleFriendEntity.mUin == paramLong)) {
        return localQCircleFriendEntity;
      }
    }
    return null;
  }
  
  private EntityManager getEntityManager()
  {
    if (this.mEntityManager == null) {
      this.mEntityManager = QCircleServiceImpl.getEntityManager();
    }
    return this.mEntityManager;
  }
  
  private void handleAtRelationData(Map<String, List<NewRelationInfo>> paramMap, long paramLong)
  {
    paramMap = convertFriendList(paramMap);
    setCurrentFriendCache(paramMap);
    saveFriendListToDB(true, paramMap);
    paramLong *= 1000L;
    long l = System.currentTimeMillis();
    int i;
    if (paramMap == null) {
      i = 0;
    } else {
      i = paramMap.size();
    }
    QLog.d("RFL-QCircleAtGroupManager", 1, new Object[] { "[handleAtRelationData] friend list count: ", Integer.valueOf(i), " | currentLoadTime: ", Long.valueOf(l), " | loadTimeInterval: ", Long.valueOf(paramLong) });
    QCircleHostConfig.setRelationGroupTimeInterval(paramLong);
    QCircleHostConfig.setRelationGroupTime(l);
  }
  
  private void handleFollowSceneLoadData(Map<String, List<NewRelationInfo>> paramMap)
  {
    paramMap = convertFriendList(paramMap);
    if (paramMap == null)
    {
      QLog.d("RFL-QCircleAtGroupManager", 1, "[handleFollowSceneLoadData] temp friend list should not be null.");
      return;
    }
    QLog.d("RFL-QCircleAtGroupManager", 1, new Object[] { "[handleFollowSceneLoadData] rsp new follow, page data count: ", Integer.valueOf(paramMap.size()) });
    saveFriendListToDB(false, updateCurrentFriendCache(paramMap));
  }
  
  private boolean hasRelationDBWrite(int paramInt)
  {
    return (paramInt & 0x1) != 1;
  }
  
  public static QCircleRelationGroupManager instance()
  {
    if (INSTANCE == null) {
      try
      {
        if (INSTANCE == null) {
          INSTANCE = new QCircleRelationGroupManager();
        }
      }
      finally {}
    }
    return INSTANCE;
  }
  
  private String parseNickName(FeedCloudMeta.StRelationInfo paramStRelationInfo)
  {
    if (paramStRelationInfo == null) {
      return "";
    }
    QQCircleRelation.RelationBiz localRelationBiz = new QQCircleRelation.RelationBiz();
    try
    {
      localRelationBiz.mergeFrom(paramStRelationInfo.busiData.get().toByteArray());
      paramStRelationInfo = localRelationBiz.nick.get();
      return paramStRelationInfo;
    }
    catch (InvalidProtocolBufferMicroException paramStRelationInfo)
    {
      paramStRelationInfo.printStackTrace();
    }
    return "";
  }
  
  private void saveFriendListToDB(boolean paramBoolean, List<QCircleFriendEntity> paramList)
  {
    EntityManager localEntityManager = getEntityManager();
    if (localEntityManager == null)
    {
      QLog.w("RFL-QCircleAtGroupManager", 1, "[saveFriendListToDB] entity manager not is null.");
      return;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      QLog.d("RFL-QCircleAtGroupManager", 1, new Object[] { "[saveFriendListToDB] friends size: ", Integer.valueOf(paramList.size()), " | isClearDB: ", Boolean.valueOf(paramBoolean) });
      ThreadManagerV2.excute(new QCircleRelationGroupManager.SaveFriendToDBTask(paramBoolean, paramList, localEntityManager), 32, null, true);
      return;
    }
    QLog.w("RFL-QCircleAtGroupManager", 1, "[saveFriendListToDB] current save firends not is empty.");
  }
  
  private void setCurrentFriendCache(List<QCircleFriendEntity> paramList)
  {
    int i = 0;
    if (paramList != null) {
      i = paramList.size();
    }
    QLog.d("RFL-QCircleAtGroupManager", 1, new Object[] { "[setCurrentFriendCache] list size: ", Integer.valueOf(i) });
    this.mFriendEntityList.clear();
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.mFriendEntityList.addAll(paramList);
    }
  }
  
  private List<QCircleFriendEntity> updateCurrentFriendCache(List<QCircleFriendEntity> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null)
    {
      QLog.d("RFL-QCircleAtGroupManager", 1, "[updateCurrentFriendCache] list should not be null.");
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QCircleFriendEntity localQCircleFriendEntity1 = (QCircleFriendEntity)paramList.next();
      Iterator localIterator = this.mFriendEntityList.iterator();
      while (localIterator.hasNext())
      {
        QCircleFriendEntity localQCircleFriendEntity2 = (QCircleFriendEntity)localIterator.next();
        if (localQCircleFriendEntity1.mUin == localQCircleFriendEntity2.mUin)
        {
          i = 1;
          break label104;
        }
      }
      int i = 0;
      label104:
      if (i == 0)
      {
        QLog.d("RFL-QCircleAtGroupManager", 1, new Object[] { "[updateCurrentFriendCache] user uin: ", Long.valueOf(localQCircleFriendEntity1.mUin) });
        this.mFriendEntityList.add(localQCircleFriendEntity1);
        localArrayList.add(localQCircleFriendEntity1);
      }
    }
    return localArrayList;
  }
  
  private void updateCurrentFriendCache()
  {
    EntityManager localEntityManager = getEntityManager();
    if (localEntityManager == null)
    {
      QLog.w("RFL-QCircleAtGroupManager", 1, "[getFriendGroupMap] current entity manager not is null.");
      return;
    }
    setCurrentFriendCache(localEntityManager.query(QCircleFriendEntity.class));
  }
  
  public void deleteFriendEntity(String paramString)
  {
    long l;
    try
    {
      l = Long.parseLong(paramString);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("delete friend uin: ");
      localStringBuilder.append(paramString);
      QLog.w("RFL-QCircleAtGroupManager", 1, localStringBuilder.toString(), localNumberFormatException);
      l = 0L;
    }
    paramString = findFriendEntityList(l);
    int i;
    if (paramString == null) {
      i = 0;
    } else {
      i = paramString.getGroupFlag();
    }
    if (hasRelationDBWrite(i))
    {
      QLog.d("RFL-QCircleAtGroupManager", 1, new Object[] { "[run] current not delete uin: ", Long.valueOf(l), " | hasGroupFlagType == false." });
      return;
    }
    if (paramString != null)
    {
      this.mFriendEntityList.remove(paramString);
      deleteFriendEntityToDB(paramString);
      QLog.d("RFL-QCircleAtGroupManager", 1, new Object[] { "[deleteFriendEntity] delete uin: ", Long.valueOf(l) });
    }
  }
  
  public Map<String, List<Entity>> getFriendGroupMap()
  {
    Map localMap = QCircleFriendFormat.format(this.mFriendEntityList);
    if (!this.mFriendEntityList.isEmpty()) {
      return localMap;
    }
    asyncInitFriendCache();
    return localMap;
  }
  
  public void loadRelationGroup()
  {
    long l1 = QCircleHostConfig.getRelationGroupLoadTime();
    long l2 = QCircleHostConfig.getRelationLoadTimeInterval();
    long l3 = System.currentTimeMillis();
    QLog.d("RFL-QCircleAtGroupManager", 1, new Object[] { "[loadRelationGroup] oldRelationGroupLoadTime: ", Long.valueOf(l1), " | oldRelationLoadTimeInterval: ", Long.valueOf(l2), " | currentRelationLoadTime: ", Long.valueOf(l3) });
    if (l3 - l1 > l2)
    {
      loadRelationGroupData(0);
      return;
    }
    asyncInitFriendCache();
  }
  
  public void loadRelationGroupData(int paramInt)
  {
    QCircleRelationModel localQCircleRelationModel = new QCircleRelationModel();
    localQCircleRelationModel.setOnLoadAtRelationListener(new QCircleRelationGroupManager.1(this));
    localQCircleRelationModel.loadRelationData(paramInt);
  }
  
  public void releaseCache()
  {
    this.mFriendEntityList.clear();
    this.mEntityManager = null;
  }
  
  public void updateFollowFriendListToDB(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramBoolean)
      {
        addFriendEntity(paramString1, paramString2);
        return;
      }
      deleteFriendEntity(paramString1);
      return;
    }
    QLog.d("RFL-QCircleAtGroupManager", 1, "[updateFriendListToDB] uin or nick name not is empty.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.relation.QCircleRelationGroupManager
 * JD-Core Version:    0.7.0.1
 */