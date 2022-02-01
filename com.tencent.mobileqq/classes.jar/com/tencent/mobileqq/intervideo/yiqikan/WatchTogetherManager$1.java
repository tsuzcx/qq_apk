package com.tencent.mobileqq.intervideo.yiqikan;

import com.tencent.mobileqq.together.TogetherObserver;
import com.tencent.mobileqq.together.TogetherSession;
import com.tencent.qphone.base.util.QLog;

class WatchTogetherManager$1
  extends TogetherObserver
{
  WatchTogetherManager$1(WatchTogetherManager paramWatchTogetherManager) {}
  
  public void a(boolean paramBoolean, TogetherSession paramTogetherSession, int paramInt, String paramString)
  {
    if ((!paramBoolean) || (paramTogetherSession == null)) {}
    do
    {
      do
      {
        return;
        QLog.i("WatchTogetherManager", 1, "onGetPlayState  groupuin = " + paramTogetherSession.e);
      } while (!(paramTogetherSession instanceof WatchTogetherSession));
      paramString = WatchTogetherManager.a(this.a, (WatchTogetherSession)paramTogetherSession);
    } while (paramString == null);
    this.a.b(paramTogetherSession.e, paramString);
    paramInt = paramString.a;
    this.a.a("100", paramInt, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherManager.1
 * JD-Core Version:    0.7.0.1
 */