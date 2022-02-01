package com.tencent.mobileqq.emosm.api.impl;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.api.IEmoticonFromGroupDBManagerService;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;

public class EmoticonFromGroupDBManagerServiceImpl
  implements IEmoticonFromGroupDBManagerService<EmoticonFromGroupEntity>
{
  protected static final int ENABLE_WRITE_TO_DB = 1;
  public static final String TAG = "EmoticonFromGroup_DBManager";
  protected Handler.Callback callback = new EmoticonFromGroupDBManagerServiceImpl.1(this);
  protected ConcurrentHashMap<String, EmoticonFromGroupEntity> emoFromGroupDBCache = new ConcurrentHashMap(600);
  protected ConcurrentHashMap<String, EmoticonFromGroupEntity> emoFromGroupDBCacheAdded = new ConcurrentHashMap(20);
  protected BaseQQAppInterface mApp;
  protected List<EmoticonFromGroupEntity> mCacheDataForShow;
  public boolean mCanWriteDataToDB = false;
  protected volatile int mCountOfSpare = 0;
  EntityManager mEntityManager;
  protected boolean mHasPostStartRunnable = false;
  public volatile boolean mIsSortAndSync = false;
  public volatile int syncDBTag = 0;
  List<URLDrawable> uploadDrawableList = new ArrayList(20);
  
  protected EmoticonFromGroupEntity addBaseInfoToEmoticonFromGroupEntity(MessageRecord paramMessageRecord)
  {
    return ((IEmosmService)QRoute.api(IEmosmService.class)).addBaseInfoToEmoticonFromGroupEntity(this.mApp, paramMessageRecord);
  }
  
  public void addEmoToCacheFromMsg(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    if (paramEmoticonFromGroupEntity == null) {
      return;
    }
    if ((!this.emoFromGroupDBCache.isEmpty()) && (this.emoFromGroupDBCache.containsKey(paramEmoticonFromGroupEntity.md5)))
    {
      EmoticonFromGroupEntity localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)this.emoFromGroupDBCache.get(paramEmoticonFromGroupEntity.md5);
      if (localEmoticonFromGroupEntity != null)
      {
        if (paramEmoticonFromGroupEntity.timestamp > localEmoticonFromGroupEntity.timestamp)
        {
          localEmoticonFromGroupEntity.replaceEntity(paramEmoticonFromGroupEntity);
          this.emoFromGroupDBCacheAdded.put(localEmoticonFromGroupEntity.md5, localEmoticonFromGroupEntity);
        }
      }
      else {
        this.emoFromGroupDBCache.remove(paramEmoticonFromGroupEntity.md5);
      }
    }
    else
    {
      this.emoFromGroupDBCache.put(paramEmoticonFromGroupEntity.md5, paramEmoticonFromGroupEntity);
      this.emoFromGroupDBCacheAdded.put(paramEmoticonFromGroupEntity.md5, paramEmoticonFromGroupEntity);
    }
    if (((this.emoFromGroupDBCache.size() >= 600) || (this.emoFromGroupDBCacheAdded.size() >= 300)) && (QLog.isColorLevel())) {
      QLog.e("EmoticonFromGroup_DBManager", 1, "add2cache over max limit.");
    }
  }
  
  protected void copyBaseInfoFromMixedToPic(MessageForPic paramMessageForPic, MessageRecord paramMessageRecord)
  {
    ((IEmosmService)QRoute.api(IEmosmService.class)).copyBaseInfoFromMixedToPic(paramMessageForPic, paramMessageRecord);
  }
  
  public void decreaseCountOfSpare()
  {
    this.mCountOfSpare -= 1;
  }
  
  public void deleteCacheAndDB(MessageRecord paramMessageRecord)
  {
    Object localObject1;
    if ((paramMessageRecord instanceof MessageForPic))
    {
      localObject1 = this.emoFromGroupDBCache;
      paramMessageRecord = (MessageForPic)paramMessageRecord;
      if (((ConcurrentHashMap)localObject1).containsKey(paramMessageRecord.md5)) {
        update2DB((EmoticonFromGroupEntity)this.emoFromGroupDBCache.remove(paramMessageRecord.md5), 2);
      }
    }
    else if (isMessageForMixedMsg(paramMessageRecord))
    {
      Object localObject2 = getMsgElemListForMessageForMixedMsg(paramMessageRecord);
      localObject1 = new ArrayList(20);
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (MessageRecord)((Iterator)localObject2).next();
        if ((localObject3 instanceof MessageForPic))
        {
          localObject3 = (MessageForPic)localObject3;
          copyBaseInfoFromMixedToPic((MessageForPic)localObject3, paramMessageRecord);
          localObject3 = addBaseInfoToEmoticonFromGroupEntity((MessageRecord)localObject3);
          localObject3 = (EmoticonFromGroupEntity)this.emoFromGroupDBCache.remove(((EmoticonFromGroupEntity)localObject3).md5);
          if (localObject3 != null) {
            ((List)localObject1).add(localObject3);
          }
        }
      }
      if (!((List)localObject1).isEmpty()) {
        update2DB((List)localObject1, 2);
      }
    }
  }
  
  public void deleteDataFromCache(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    if (paramEmoticonFromGroupEntity != null)
    {
      if (this.emoFromGroupDBCache.containsKey(paramEmoticonFromGroupEntity.md5)) {
        this.emoFromGroupDBCache.remove(paramEmoticonFromGroupEntity.md5);
      }
      if (this.emoFromGroupDBCacheAdded.containsKey(paramEmoticonFromGroupEntity.md5)) {
        this.emoFromGroupDBCacheAdded.remove(paramEmoticonFromGroupEntity.md5);
      }
    }
  }
  
  public void deleteDataFromCache(List<EmoticonFromGroupEntity> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        EmoticonFromGroupEntity localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)paramList.next();
        if (this.emoFromGroupDBCache.containsKey(localEmoticonFromGroupEntity.md5)) {
          this.emoFromGroupDBCache.remove(localEmoticonFromGroupEntity.md5);
        }
        if (this.emoFromGroupDBCacheAdded.containsKey(localEmoticonFromGroupEntity.md5)) {
          this.emoFromGroupDBCacheAdded.remove(localEmoticonFromGroupEntity.md5);
        }
      }
    }
  }
  
  public void enableWrite2DBAfterTenSec()
  {
    if (!this.mHasPostStartRunnable)
    {
      this.mHasPostStartRunnable = true;
      getHandler().sendEmptyMessageDelayed(1, 10000L);
    }
  }
  
  public int getAddedEmoCacheDataSize()
  {
    return this.emoFromGroupDBCacheAdded.size();
  }
  
  public int getCountOfSpare()
  {
    return this.mCountOfSpare;
  }
  
  public int getDBCacheSize()
  {
    return this.emoFromGroupDBCache.size();
  }
  
  public List<EmoticonFromGroupEntity> getDBDatas()
  {
    EntityManager localEntityManager = this.mEntityManager;
    if (localEntityManager == null) {
      return null;
    }
    return localEntityManager.query(EmoticonFromGroupEntity.class);
  }
  
  public List<EmoticonFromGroupEntity> getEmoDataForShow()
  {
    this.mCacheDataForShow.clear();
    List localList = sortAndSyncData();
    if (localList != null) {
      if (localList.size() > 300)
      {
        localList = localList.subList(0, 300);
        this.mCacheDataForShow.addAll(localList);
      }
      else
      {
        this.mCacheDataForShow.addAll(localList);
      }
    }
    return this.mCacheDataForShow;
  }
  
  public List<EmoticonFromGroupEntity> getEmoDataShowing()
  {
    return this.mCacheDataForShow;
  }
  
  protected Handler getHandler()
  {
    return new Handler(ThreadManager.getSubThreadLooper(), this.callback);
  }
  
  protected List<MessageRecord> getMsgElemListForMessageForMixedMsg(MessageRecord paramMessageRecord)
  {
    return ((IEmosmService)QRoute.api(IEmosmService.class)).getMsgElemListForMessageForMixedMsg(paramMessageRecord);
  }
  
  public List<URLDrawable> getUploadDrawableList()
  {
    return this.uploadDrawableList;
  }
  
  protected boolean isMessageForMixedMsg(MessageRecord paramMessageRecord)
  {
    return ((IEmosmService)QRoute.api(IEmosmService.class)).isMessageForMixedMsg(paramMessageRecord);
  }
  
  protected boolean isNoMainThread()
  {
    return Looper.myLooper() != Looper.getMainLooper();
  }
  
  public void loadDB()
  {
    if (this.syncDBTag == 0)
    {
      this.syncDBTag = 1;
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonFromGroup_DBManager", 2, "load db start.");
      }
      Object localObject = getDBDatas();
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonFromGroup_DBManager", 2, "load db mid.");
      }
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          replaceDBToCache((EmoticonFromGroupEntity)((Iterator)localObject).next());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonFromGroup_DBManager", 2, "load db end.");
      }
      this.syncDBTag = 2;
    }
  }
  
  protected boolean needSortAndSyncData()
  {
    return this.emoFromGroupDBCache.size() >= 400;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((BaseQQAppInterface)paramAppRuntime);
    this.mEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
    this.mCacheDataForShow = new CopyOnWriteArrayList();
  }
  
  public void onDestroy()
  {
    if (!this.emoFromGroupDBCacheAdded.isEmpty())
    {
      localObject = new ArrayList(this.emoFromGroupDBCacheAdded.values());
      this.emoFromGroupDBCacheAdded.clear();
      update2DB((List)localObject, 1);
    }
    this.emoFromGroupDBCache.clear();
    Object localObject = this.mEntityManager;
    if (localObject != null) {
      ((EntityManager)localObject).close();
    }
    this.mCacheDataForShow.clear();
  }
  
  public void replaceDBToCache(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    if (paramEmoticonFromGroupEntity == null) {
      return;
    }
    if ((!this.emoFromGroupDBCache.isEmpty()) && (this.emoFromGroupDBCache.containsKey(paramEmoticonFromGroupEntity.md5)))
    {
      EmoticonFromGroupEntity localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)this.emoFromGroupDBCache.get(paramEmoticonFromGroupEntity.md5);
      if (localEmoticonFromGroupEntity != null)
      {
        if (paramEmoticonFromGroupEntity.timestamp < localEmoticonFromGroupEntity.timestamp) {
          paramEmoticonFromGroupEntity.replaceEntity(localEmoticonFromGroupEntity);
        }
      }
      else {
        this.emoFromGroupDBCache.remove(paramEmoticonFromGroupEntity.md5);
      }
      this.emoFromGroupDBCache.put(paramEmoticonFromGroupEntity.md5, paramEmoticonFromGroupEntity);
    }
    else
    {
      this.emoFromGroupDBCache.put(paramEmoticonFromGroupEntity.md5, paramEmoticonFromGroupEntity);
    }
    if (((this.emoFromGroupDBCache.size() >= 600) || (this.emoFromGroupDBCacheAdded.size() >= 300)) && (QLog.isColorLevel())) {
      QLog.e("EmoticonFromGroup_DBManager", 1, "replaceDBToCache over max limit.");
    }
  }
  
  public void setCountOfSpare(int paramInt)
  {
    this.mCountOfSpare = paramInt;
  }
  
  protected List<EmoticonFromGroupEntity> sortAndSyncData()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonFromGroup_DBManager", 2, "sortAndSyncData start.");
    }
    ArrayList localArrayList1 = new ArrayList(this.emoFromGroupDBCache.values());
    Collections.sort(localArrayList1);
    if (this.mCanWriteDataToDB)
    {
      ArrayList localArrayList2 = new ArrayList(100);
      int j = localArrayList1.size();
      int i = 300;
      if (j > 300)
      {
        while (i < j)
        {
          String str = ((EmoticonFromGroupEntity)localArrayList1.get(i)).md5;
          EmoticonFromGroupEntity localEmoticonFromGroupEntity = (EmoticonFromGroupEntity)this.emoFromGroupDBCache.remove(str);
          if (this.emoFromGroupDBCacheAdded.containsKey(str)) {
            this.emoFromGroupDBCacheAdded.remove(str);
          }
          if (localEmoticonFromGroupEntity != null) {
            localArrayList2.add(localEmoticonFromGroupEntity);
          }
          i += 1;
        }
        update2DB(localArrayList2, 2);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonFromGroup_DBManager", 2, "sortAndSyncData end.");
    }
    return localArrayList1;
  }
  
  public void update2DB(EmoticonFromGroupEntity paramEmoticonFromGroupEntity, int paramInt)
  {
    if (paramEmoticonFromGroupEntity == null) {
      return;
    }
    paramEmoticonFromGroupEntity = new EmoticonFromGroupDBManagerServiceImpl.2(this, paramInt, paramEmoticonFromGroupEntity);
    if (isNoMainThread())
    {
      paramEmoticonFromGroupEntity.run();
      return;
    }
    ThreadManager.post(paramEmoticonFromGroupEntity, 5, null, true);
  }
  
  public void update2DB(List<EmoticonFromGroupEntity> paramList, int paramInt)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = new EmoticonFromGroupDBManagerServiceImpl.3(this, paramInt, paramList);
      if (isNoMainThread())
      {
        paramList.run();
        return;
      }
      ThreadManager.post(paramList, 5, null, true);
    }
  }
  
  public void updateDBCache(MessageRecord paramMessageRecord)
  {
    long l = Calendar.getInstance().getTimeInMillis();
    if ((paramMessageRecord instanceof MessageForPic))
    {
      updateDBCachePerPic(addBaseInfoToEmoticonFromGroupEntity(paramMessageRecord));
    }
    else if (isMessageForMixedMsg(paramMessageRecord))
    {
      Iterator localIterator = getMsgElemListForMessageForMixedMsg(paramMessageRecord).iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (MessageRecord)localIterator.next();
        if ((localObject instanceof MessageForPic))
        {
          localObject = (MessageForPic)localObject;
          copyBaseInfoFromMixedToPic((MessageForPic)localObject, paramMessageRecord);
          updateDBCachePerPic(addBaseInfoToEmoticonFromGroupEntity((MessageRecord)localObject));
        }
      }
    }
    if (!this.mIsSortAndSync)
    {
      this.mIsSortAndSync = true;
      if (needSortAndSyncData())
      {
        if (QLog.isColorLevel()) {
          QLog.i("EmoticonFromGroup_DBManager", 2, "clean data start.");
        }
        sortAndSyncData();
        if (QLog.isColorLevel()) {
          QLog.i("EmoticonFromGroup_DBManager", 2, "clean data end.");
        }
      }
      this.mIsSortAndSync = false;
    }
    if (QLog.isColorLevel())
    {
      paramMessageRecord = new StringBuilder();
      paramMessageRecord.append("EmoticonFromGroup deal with per msg time = [");
      paramMessageRecord.append(Calendar.getInstance().getTimeInMillis() - l);
      paramMessageRecord.append("]");
      QLog.d("StressTesting.Emoticon.EmoticonFromGroup", 2, paramMessageRecord.toString());
    }
  }
  
  protected void updateDBCachePerPic(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    if ((paramEmoticonFromGroupEntity != null) && (paramEmoticonFromGroupEntity.md5 != null) && (!paramEmoticonFromGroupEntity.md5.equals("")) && (paramEmoticonFromGroupEntity.thumbURL != null) && (!paramEmoticonFromGroupEntity.thumbURL.equals("")) && (paramEmoticonFromGroupEntity.bigURL != null))
    {
      if (paramEmoticonFromGroupEntity.bigURL.equals("")) {
        return;
      }
      addEmoToCacheFromMsg(paramEmoticonFromGroupEntity);
      int i = this.syncDBTag;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            return;
          }
          if ((this.mCanWriteDataToDB) && (this.emoFromGroupDBCacheAdded.size() >= 10))
          {
            paramEmoticonFromGroupEntity = new ArrayList(this.emoFromGroupDBCacheAdded.values());
            this.emoFromGroupDBCacheAdded.clear();
            update2DB(paramEmoticonFromGroupEntity, 1);
          }
        }
      }
      else {
        loadDB();
      }
    }
  }
  
  public boolean updateEntity(Entity paramEntity)
  {
    int i = paramEntity.getStatus();
    boolean bool = false;
    if (i == 1000)
    {
      this.mEntityManager.persistOrReplace(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
      return bool;
    }
    if ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return false;
    }
    return this.mEntityManager.update(paramEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoticonFromGroupDBManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */