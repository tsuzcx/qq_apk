package com.tencent.mobileqq.gamecenter.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameNoticeCenter$GameNoticeInfoList
  extends CopyOnWriteArrayList<GameNoticeInfo>
{
  private EntityManager mEntityManager;
  
  public GameNoticeCenter$GameNoticeInfoList(GameNoticeCenter paramGameNoticeCenter, EntityManager paramEntityManager)
  {
    this.mEntityManager = paramEntityManager;
  }
  
  private final void a()
  {
    if (QLog.isColorLevel())
    {
      int i = 0;
      while (i < size())
      {
        QLog.d("GameNoticeCenter", 2, new Object[] { get(i) });
        i += 1;
      }
    }
  }
  
  public boolean add(GameNoticeInfo paramGameNoticeInfo)
  {
    boolean bool = super.add(paramGameNoticeInfo);
    if (bool) {
      this.mEntityManager.persist(paramGameNoticeInfo);
    }
    return bool;
  }
  
  public GameNoticeInfo getByAppId(String paramString)
  {
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      GameNoticeInfo localGameNoticeInfo = (GameNoticeInfo)localIterator.next();
      if ((!TextUtils.isEmpty(localGameNoticeInfo.appId)) && (localGameNoticeInfo.appId.equals(paramString))) {
        return localGameNoticeInfo;
      }
    }
    return null;
  }
  
  void initData()
  {
    try
    {
      ArrayList localArrayList = (ArrayList)this.mEntityManager.query(GameNoticeInfo.class);
      clear();
      if (localArrayList == null) {
        break label82;
      }
      localObject = localArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!((GameNoticeInfo)((Iterator)localObject).next()).isValid()) {
          ((Iterator)localObject).remove();
        }
      }
      addAll(localThrowable);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GameNoticeCenter", 1, "initData exception", localThrowable);
      return;
    }
    sort();
    label82:
    Object localObject = new StringBuilder().append("initData, restore size=");
    if (localThrowable != null) {}
    for (int i = localThrowable.size();; i = 0)
    {
      QLog.d("GameNoticeCenter", 1, i + ", remains size=" + size());
      a();
      this.this$0.b();
      return;
    }
  }
  
  public GameNoticeInfo remove(int paramInt)
  {
    GameNoticeInfo localGameNoticeInfo = (GameNoticeInfo)super.remove(paramInt);
    if (localGameNoticeInfo != null) {
      this.mEntityManager.remove(localGameNoticeInfo);
    }
    return localGameNoticeInfo;
  }
  
  public boolean remove(Object paramObject)
  {
    boolean bool = super.remove(paramObject);
    if ((bool) && ((paramObject instanceof Entity))) {
      this.mEntityManager.remove((Entity)paramObject);
    }
    return bool;
  }
  
  void sort()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this);
      Collections.sort(localArrayList, GameNoticeCenter.a());
      clear();
      addAll(localArrayList);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GameNoticeCenter", 1, "sort exception", localThrowable);
    }
  }
  
  public void updateDB(GameNoticeInfo paramGameNoticeInfo)
  {
    if (paramGameNoticeInfo.getStatus() == 1000) {
      this.mEntityManager.persistOrReplace(paramGameNoticeInfo);
    }
    while ((paramGameNoticeInfo.getStatus() != 1001) && (paramGameNoticeInfo.getStatus() != 1002)) {
      return;
    }
    this.mEntityManager.update(paramGameNoticeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.GameNoticeCenter.GameNoticeInfoList
 * JD-Core Version:    0.7.0.1
 */