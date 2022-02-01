package com.tencent.mobileqq.qqguildsdk.engine;

import android.text.TextUtils;
import com.tencent.mobileqq.qqguildsdk.callback.IKickChannelMemberCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProResultInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.manager.AudioChannelMgr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class GPSAsynManagerEngine$23
  implements IKickChannelMemberCallback
{
  GPSAsynManagerEngine$23(GPSAsynManagerEngine paramGPSAsynManagerEngine, String paramString, IKickChannelMemberCallback paramIKickChannelMemberCallback) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult, List<IGProResultInfo> paramList)
  {
    if (paramInt == 0)
    {
      ArrayList localArrayList = new ArrayList();
      if ((paramList != null) && (paramList.size() > 0))
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          IGProResultInfo localIGProResultInfo = (IGProResultInfo)localIterator.next();
          if ((localIGProResultInfo.b() == 0) && (!TextUtils.isEmpty(localIGProResultInfo.a()))) {
            localArrayList.add(localIGProResultInfo.a());
          }
        }
      }
      this.c.g().b(this.a, localArrayList);
    }
    this.b.a(paramInt, paramString, paramIGProSecurityResult, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.engine.GPSAsynManagerEngine.23
 * JD-Core Version:    0.7.0.1
 */