package com.tencent.mobileqq.gamecenter.data;

import android.os.Handler;
import android.text.TextUtils;
import atmo;
import atmp;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class GameNoticeCenter$GameNoticeInfoList
  extends ArrayList<GameNoticeInfo>
{
  private atmp mEntityManager;
  
  public GameNoticeCenter$GameNoticeInfoList(GameNoticeCenter paramGameNoticeCenter, atmp paramatmp)
  {
    this.mEntityManager = paramatmp;
  }
  
  private void a()
  {
    Object localObject2 = (ArrayList)this.mEntityManager.a(GameNoticeInfo.class);
    QLog.e("GameNoticeCenter", 1, "restoreDataFromDB, restore: " + localObject2);
    synchronized (GameNoticeCenter.a(this.this$0))
    {
      clear();
      if (localObject2 != null)
      {
        addAll((Collection)localObject2);
        Collections.sort(this, GameNoticeCenter.a());
        localObject2 = listIterator();
        while (((Iterator)localObject2).hasNext()) {
          if (!((GameNoticeInfo)((Iterator)localObject2).next()).isValid()) {
            ((Iterator)localObject2).remove();
          }
        }
      }
    }
    QLog.e("GameNoticeCenter", 1, new Object[] { "restoreDataFromDB, remains: ", Integer.valueOf(size()) });
    b();
    ThreadManagerV2.getUIHandlerV2().post(new GameNoticeCenter.GameNoticeInfoList.2(this));
  }
  
  private final void b()
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
    Iterator localIterator = GameNoticeCenter.a(this.this$0).iterator();
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
    ThreadManagerV2.executeOnFileThread(new GameNoticeCenter.GameNoticeInfoList.1(this));
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
    if ((bool) && ((paramObject instanceof atmo))) {
      this.mEntityManager.b((atmo)paramObject);
    }
    return bool;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.GameNoticeCenter.GameNoticeInfoList
 * JD-Core Version:    0.7.0.1
 */