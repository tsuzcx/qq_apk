package com.tencent.mobileqq.qqguildsdk.engine;

import com.tencent.gprosdk.GProGuildUserSimpleProfile;
import com.tencent.mobileqq.qqguildsdk.manager.UserListMgr;
import com.tencent.mobileqq.qqguildsdk.wrapper.callback.ILoadSimpleProfilesCallback;
import java.util.List;

class GPSManagerEngine$1
  implements ILoadSimpleProfilesCallback
{
  GPSManagerEngine$1(GPSManagerEngine paramGPSManagerEngine) {}
  
  public void a(int paramInt, List<GProGuildUserSimpleProfile> paramList)
  {
    if (paramInt == 0) {
      this.a.e().a(paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine.1
 * JD-Core Version:    0.7.0.1
 */