package com.tencent.mobileqq.intervideo.yiqikan;

import com.tencent.mobileqq.together.TogetherObserver;
import com.tencent.mobileqq.together.TogetherSession;
import com.tencent.qphone.base.util.QLog;

class WatchTogetherManager$1
  extends TogetherObserver
{
  WatchTogetherManager$1(WatchTogetherManager paramWatchTogetherManager) {}
  
  protected void a(boolean paramBoolean, TogetherSession paramTogetherSession, int paramInt, String paramString)
  {
    if (paramBoolean)
    {
      if (paramTogetherSession == null) {
        return;
      }
      paramString = new StringBuilder();
      paramString.append("onGetPlayState  groupuin = ");
      paramString.append(paramTogetherSession.n);
      QLog.i("WatchTogetherManager", 1, paramString.toString());
      if ((paramTogetherSession instanceof WatchTogetherSession))
      {
        paramString = WatchTogetherManager.a(this.a, (WatchTogetherSession)paramTogetherSession);
        if (paramString != null)
        {
          this.a.b(paramTogetherSession.n, paramString);
          paramInt = paramString.c;
          this.a.a("100", paramInt, null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherManager.1
 * JD-Core Version:    0.7.0.1
 */