package com.tencent.timi.game.userinfo.impl.db;

import com.tencent.timi.game.databasecore.impl.livedata.BaseDbLiveData;
import com.tencent.timi.game.databasecore.impl.livedata.IDBObserver;
import com.tencent.timi.game.databasecore.impl.livedata.LoadDataWrapper;
import com.tencent.timi.game.databasecore.impl.notify.DbNotifyListener;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.impl.AllUserInfoModel;
import com.tencent.timi.game.userinfo.impl.util.UserInfoDbUtil;
import com.tencent.timi.game.userinfo.impl.util.UserInfoUtil;

public class UserInfoLiveData
  extends BaseDbLiveData<AllUserInfoModel, IUserInfo>
{
  DbNotifyListener a = new UserInfoLiveData.3(this);
  private long b;
  private boolean c = false;
  
  public UserInfoLiveData(long paramLong)
  {
    this.b = paramLong;
    UserInfoLiveData.1 local1 = new UserInfoLiveData.1(this);
    UserInfoDbUtil.a.a(paramLong, local1);
  }
  
  public void a(int paramInt, String paramString)
  {
    paramString = new UserInfoLiveData.2(this, paramInt, paramString);
    UserInfoDbUtil.a.a(this.b, paramString);
  }
  
  protected void a(IDBObserver<AllUserInfoModel> paramIDBObserver)
  {
    UserInfoUtil.a.a(this.a);
  }
  
  public void a(IUserInfo paramIUserInfo, int paramInt)
  {
    LoadDataWrapper localLoadDataWrapper = (LoadDataWrapper)getValue();
    if (localLoadDataWrapper == null)
    {
      paramIUserInfo = new LoadDataWrapper(paramInt, paramIUserInfo);
    }
    else
    {
      localLoadDataWrapper.c = paramInt;
      localLoadDataWrapper.d = paramIUserInfo;
      paramIUserInfo = localLoadDataWrapper;
    }
    b(paramIUserInfo);
  }
  
  protected void b(IDBObserver<AllUserInfoModel> paramIDBObserver)
  {
    UserInfoUtil.a.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.db.UserInfoLiveData
 * JD-Core Version:    0.7.0.1
 */