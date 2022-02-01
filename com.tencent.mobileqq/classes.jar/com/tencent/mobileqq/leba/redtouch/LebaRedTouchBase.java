package com.tencent.mobileqq.leba.redtouch;

import android.content.Context;
import com.tencent.mobileqq.leba.LebaConstant;
import com.tencent.mobileqq.leba.business.LebaRedTouchBizProxy;
import com.tencent.mobileqq.leba.config.LebaConfigApi;
import com.tencent.mobileqq.leba.core.LebaShowListManager;
import com.tencent.mobileqq.leba.entity.LebaExposureInfo;
import com.tencent.mobileqq.leba.entity.UpdateRedTouchParam;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchServer;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import mqq.app.AppRuntime;

public abstract class LebaRedTouchBase
{
  protected HashSet<Long> a = new HashSet();
  protected Map<Long, LebaExposureInfo> b = new HashMap();
  protected LebaRedTouchBizProxy c = new LebaRedTouchBizProxy();
  protected boolean d = true;
  
  public LebaRedTouchBase()
  {
    a();
    b();
  }
  
  private void a(long paramLong, RedTouch paramRedTouch)
  {
    int i = LebaConstant.a(paramRedTouch);
    if (i != 0) {
      this.b.put(Long.valueOf(paramLong), new LebaExposureInfo(i, LebaConstant.b(paramRedTouch)));
    }
  }
  
  private void a(AppRuntime paramAppRuntime, long paramLong, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if ((!this.a.contains(Long.valueOf(paramLong))) && (paramAppInfo != null) && (paramAppInfo.iNewFlag.get() != 0))
    {
      this.a.add(Long.valueOf(paramLong));
      ((IRedTouchManager)paramAppRuntime.getRuntimeService(IRedTouchManager.class, "")).reportLevelOneRedInfo((int)paramLong, 30);
    }
  }
  
  public abstract BusinessInfoCheckUpdate.AppInfo a(AppRuntime paramAppRuntime, String paramString);
  
  public void a()
  {
    this.c.a();
  }
  
  public void a(UpdateRedTouchParam paramUpdateRedTouchParam)
  {
    AppRuntime localAppRuntime = paramUpdateRedTouchParam.a;
    Context localContext = paramUpdateRedTouchParam.b;
    RedTouch localRedTouch = paramUpdateRedTouchParam.c;
    long l = paramUpdateRedTouchParam.d;
    String str = paramUpdateRedTouchParam.e;
    int i = paramUpdateRedTouchParam.f;
    boolean bool = paramUpdateRedTouchParam.g;
    paramUpdateRedTouchParam = a(localAppRuntime, String.valueOf(l));
    a(localAppRuntime, l, paramUpdateRedTouchParam);
    if (this.d) {
      bool = this.c.a(localAppRuntime, localContext, l, localRedTouch, str, this.b, i, bool);
    } else {
      bool = false;
    }
    QLog.d("Q.lebatab.LebaRedTouchBase", 1, new Object[] { "updateRedTouch,resID=", Long.valueOf(l), ",resPkgName=", str, ",isHandledRedTouch=", Boolean.valueOf(bool), ",leba_red_touch_spcific_enable->mSpecificEnable=", Boolean.valueOf(this.d) });
    if (!bool)
    {
      a(localRedTouch, paramUpdateRedTouchParam);
      a(l, localRedTouch);
      this.c.a(localAppRuntime, str, paramUpdateRedTouchParam);
    }
  }
  
  public abstract void a(RedTouch paramRedTouch, BusinessInfoCheckUpdate.AppInfo paramAppInfo);
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (!this.a.isEmpty()) {
      try
      {
        LebaShowListManager.a |= 0x2;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onPause update");
        localStringBuilder.append(LebaShowListManager.a);
        QLog.i("Q.lebatab.LebaRedTouchBase", 1, localStringBuilder.toString());
        ((IRedTouchServer)paramAppRuntime.getRuntimeService(IRedTouchServer.class, "")).notifyUI(4, true, null);
      }
      catch (Exception paramAppRuntime)
      {
        QLog.i("Q.lebatab.LebaRedTouchBase", 1, "onPause", paramAppRuntime);
      }
    }
    this.a.clear();
    this.b.clear();
  }
  
  public void b()
  {
    this.d = new LebaConfigApi().a();
  }
  
  public Map<Long, LebaExposureInfo> c()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.redtouch.LebaRedTouchBase
 * JD-Core Version:    0.7.0.1
 */