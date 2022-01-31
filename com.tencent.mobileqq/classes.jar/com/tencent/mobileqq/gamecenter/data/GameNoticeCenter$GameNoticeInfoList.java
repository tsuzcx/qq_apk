package com.tencent.mobileqq.gamecenter.data;

import android.text.TextUtils;
import awge;
import awgf;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameNoticeCenter$GameNoticeInfoList
  extends CopyOnWriteArrayList<GameNoticeInfo>
{
  private awgf mEntityManager;
  
  public GameNoticeCenter$GameNoticeInfoList(GameNoticeCenter paramGameNoticeCenter, awgf paramawgf)
  {
    this.mEntityManager = paramawgf;
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
      this.mEntityManager.a(paramGameNoticeInfo);
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
    ArrayList localArrayList = (ArrayList)this.mEntityManager.a(GameNoticeInfo.class);
    clear();
    if (localArrayList != null)
    {
      addAll(localArrayList);
      sort();
      localObject = listIterator();
      while (((Iterator)localObject).hasNext()) {
        if (!((GameNoticeInfo)((Iterator)localObject).next()).isValid()) {
          ((Iterator)localObject).remove();
        }
      }
    }
    Object localObject = new StringBuilder().append("initData, restore size=");
    if (localArrayList != null) {}
    for (int i = localArrayList.size();; i = 0)
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
      this.mEntityManager.b(localGameNoticeInfo);
    }
    return localGameNoticeInfo;
  }
  
  public boolean remove(Object paramObject)
  {
    boolean bool = super.remove(paramObject);
    if ((bool) && ((paramObject instanceof awge))) {
      this.mEntityManager.b((awge)paramObject);
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
      QLog.e("GameNoticeCenter", 1, "initData exception", localThrowable);
    }
  }
  
  public void updateDB(GameNoticeInfo paramGameNoticeInfo)
  {
    if (paramGameNoticeInfo.getStatus() == 1000) {
      this.mEntityManager.b(paramGameNoticeInfo);
    }
    while ((paramGameNoticeInfo.getStatus() != 1001) && (paramGameNoticeInfo.getStatus() != 1002)) {
      return;
    }
    this.mEntityManager.a(paramGameNoticeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.GameNoticeCenter.GameNoticeInfoList
 * JD-Core Version:    0.7.0.1
 */