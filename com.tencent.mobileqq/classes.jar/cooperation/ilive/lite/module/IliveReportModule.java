package cooperation.ilive.lite.module;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ilive.EnterRoomConfig;
import com.tencent.ilive.audiencepages.room.events.PlayerStateEvent;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.pages.room.bizmodule.RoomBizModule;
import com.tencent.ilive.pages.room.events.RoomCloseEvent;
import com.tencent.ilive.pages.room.events.ScrollBottomEvent;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.mobileqq.litelivesdk.framework.room.RoomManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.IliveLiteMonitorUtil;
import cooperation.ilive.lite.IliveMetricsReportUtil;
import cooperation.ilive.lite.event.IliveLiteEventCenter;
import cooperation.ilive.lite.event.IliveLiteEventCenter.Observer;
import cooperation.ilive.lite.floatwindow.IliveFloatWindowHelper.IPermissionCallback;
import cooperation.ilive.lite.heart.IliveRoomHeartController;
import cooperation.ilive.lite.report.IliveAVCatonReportManager;
import cooperation.ilive.lite.report.IliveLiteDataReport;
import cooperation.ilive.lite.rommswitch.LiveLiteRoomSwitchService;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class IliveReportModule
  extends RoomBizModule
{
  private static long f;
  private static HashMap<Long, Long> g = new HashMap();
  private static long h;
  private boolean a;
  private boolean b;
  private long c;
  private long d;
  private boolean e;
  private IliveRoomHeartController i = new IliveRoomHeartController();
  private boolean j = false;
  private boolean k = true;
  private String l;
  private IliveLiteEventCenter.Observer m = new IliveReportModule.5(this);
  private IliveFloatWindowHelper.IPermissionCallback n = new IliveReportModule.6(this);
  
  private void a(long paramLong, int paramInt)
  {
    if (!g.containsKey(Long.valueOf(paramLong)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onExitRoom enter event has consume , roomid = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" from = ");
      localStringBuilder.append(paramInt);
      QLog.e("IliveReportModule", 1, localStringBuilder.toString());
      return;
    }
    paramInt -= 1000;
    IliveLiteDataReport.a = paramInt;
    IliveLiteDataReport.b = paramLong;
    if (g.get(Long.valueOf(paramLong)) != null) {
      l1 = ((Long)g.get(Long.valueOf(paramLong))).longValue();
    } else {
      l1 = 0L;
    }
    g.remove(Long.valueOf(paramLong));
    long l1 = System.currentTimeMillis() - l1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onExitRoom from = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" stayTime = ");
    localStringBuilder.append(l1);
    localStringBuilder.append(" roomId = ");
    localStringBuilder.append(paramLong);
    QLog.e("IliveReportModule", 1, localStringBuilder.toString());
    IliveLiteDataReport.a().a(paramLong, l1, paramInt);
    this.i.a(paramInt);
    QLog.e("IliveReportModule", 1, "requestExitRoom");
    ThreadManager.getSubThreadHandler().post(new IliveReportModule.3(this, paramLong));
  }
  
  private void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleExitRoomHeartReport roomId = ");
    localStringBuilder.append(j());
    localStringBuilder.append("  isCurrent = ");
    localStringBuilder.append(h());
    localStringBuilder.append(" mHeartExitRoomReported = ");
    localStringBuilder.append(this.j);
    QLog.e("IliveReportModule", 1, localStringBuilder.toString());
    if (this.j)
    {
      QLog.i("IliveReportModule", 1, "handleExitRoomHeartReport has reportFinal");
      return;
    }
    this.j = true;
    this.i.a(paramBoolean, j());
  }
  
  private void b()
  {
    getEvent().observe(RoomCloseEvent.class, new IliveReportModule.1(this));
    getEvent().observe(PlayerStateEvent.class, new IliveReportModule.2(this));
  }
  
  private void c()
  {
    this.c = System.currentTimeMillis();
    g.put(Long.valueOf(j()), Long.valueOf(this.c));
    this.e = true;
    IliveLiteDataReport.a().b(a());
    IliveLiteDataReport.a().a(j(), IliveLiteDataReport.g());
    h = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onActivityCreated sEnterRoomTime = ");
    localStringBuilder.append(IliveLiteDataReport.c);
    QLog.e("IliveReportModule", 1, localStringBuilder.toString());
    IliveLiteDataReport.c = 0;
    k();
    IliveMetricsReportUtil.a();
    d();
    IliveAVCatonReportManager.b().a(true, j());
  }
  
  private void d()
  {
    EnterRoomConfig localEnterRoomConfig = BusinessManager.a.c();
    if ((localEnterRoomConfig != null) && (localEnterRoomConfig.extData != null)) {
      IliveLiteMonitorUtil.d((String)RoomManager.a(localEnterRoomConfig.extData.getString("mqqschema")).get("first_click_time"));
    }
  }
  
  private String e()
  {
    Object localObject1 = BusinessManager.a.c();
    if ((localObject1 != null) && (((EnterRoomConfig)localObject1).extData != null)) {
      localObject1 = ((EnterRoomConfig)localObject1).extData.getString("session_id", "");
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getSessionId = ");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.i("IliveReportModule", 2, ((StringBuilder)localObject1).toString());
    }
    return localObject2;
  }
  
  private void f()
  {
    getEvent().observe(ScrollBottomEvent.class, new IliveReportModule.4(this));
  }
  
  private void g()
  {
    if ((!this.b) && (this.a))
    {
      long l1 = System.currentTimeMillis() - this.c;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSeeRoomVideoReport enterTime = ");
      ((StringBuilder)localObject).append(l1);
      QLog.i("IliveReportModule", 1, ((StringBuilder)localObject).toString());
      localObject = IliveLiteDataReport.a();
      long l2 = j();
      int i1;
      if (this.e) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      ((IliveLiteDataReport)localObject).c(l2, l1, i1);
      this.b = true;
    }
  }
  
  private boolean h()
  {
    int i2 = i();
    IAudienceRoomPager localIAudienceRoomPager = getAudienceRoomPager();
    boolean bool = false;
    int i1;
    if (localIAudienceRoomPager != null) {
      i1 = getAudienceRoomPager().getCurrentIndex();
    } else {
      i1 = 0;
    }
    if (i2 == i1) {
      bool = true;
    }
    return bool;
  }
  
  private int i()
  {
    if ((this.roomBizContext != null) && (this.roomBizContext.getEnterRoomInfo() != null)) {
      return this.roomBizContext.getEnterRoomInfo().bootModulesIndex;
    }
    return 0;
  }
  
  private long j()
  {
    if ((this.roomBizContext != null) && (this.roomBizContext.getEnterRoomInfo() != null)) {
      return this.roomBizContext.getEnterRoomInfo().roomId;
    }
    return 0L;
  }
  
  private void k()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initHeartReport roomId = ");
    localStringBuilder.append(j());
    QLog.e("IliveReportModule", 1, localStringBuilder.toString());
    this.j = false;
    this.i.a(j());
  }
  
  private void l()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestory isCurrent = ");
    localStringBuilder.append(h());
    QLog.e("IliveReportModule", 1, localStringBuilder.toString());
    if ((g.containsKey(Long.valueOf(j()))) && (h()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestory enter report exit , roomId = ");
      localStringBuilder.append(j());
      QLog.e("IliveReportModule", 1, localStringBuilder.toString());
      a(j(), 1001);
    }
  }
  
  private void m()
  {
    if (h())
    {
      LiveLiteRoomSwitchService.a();
      long l1 = System.currentTimeMillis() - h;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityDestroyed stayTime = ");
      localStringBuilder.append(l1);
      localStringBuilder.append(" sExitFrom = ");
      localStringBuilder.append(IliveLiteDataReport.a);
      localStringBuilder.append(" times = ");
      localStringBuilder.append(IliveLiteDataReport.c);
      localStringBuilder.append(" roomId = ");
      localStringBuilder.append(IliveLiteDataReport.b);
      QLog.e("IliveReportModule", 1, localStringBuilder.toString());
      IliveLiteDataReport.a().a(0L, l1, IliveLiteDataReport.a, IliveLiteDataReport.c);
    }
  }
  
  private void n()
  {
    if (getEvent() != null) {
      getEvent().post(new RoomCloseEvent((short)1004));
    }
  }
  
  public String a()
  {
    Object localObject1 = BusinessManager.a.c();
    if ((localObject1 != null) && (((EnterRoomConfig)localObject1).extData != null)) {
      localObject1 = ((EnterRoomConfig)localObject1).extData.getString("trace_info", "");
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getEnterRecomInfo = ");
      ((StringBuilder)localObject1).append((String)localObject2);
      QLog.i("IliveReportModule", 2, ((StringBuilder)localObject1).toString());
    }
    return localObject2;
  }
  
  public String a(SwitchRoomInfo paramSwitchRoomInfo)
  {
    if (paramSwitchRoomInfo == null) {
      return "";
    }
    Object localObject = paramSwitchRoomInfo.extData;
    paramSwitchRoomInfo = null;
    if (localObject != null) {
      paramSwitchRoomInfo = ((Bundle)localObject).getString("trace_info", "");
    }
    try
    {
      localObject = new JSONObject();
      if (!TextUtils.isEmpty(paramSwitchRoomInfo)) {
        localObject = new JSONObject(Uri.decode(paramSwitchRoomInfo));
      }
      if (!((JSONObject)localObject).has("session_id")) {
        ((JSONObject)localObject).put("session_id", e());
      }
      localObject = ((JSONObject)localObject).toString();
      paramSwitchRoomInfo = (SwitchRoomInfo)localObject;
    }
    catch (Exception localException)
    {
      label89:
      break label89;
    }
    QLog.e("IliveReportModule", 1, "");
    localObject = paramSwitchRoomInfo;
    if (paramSwitchRoomInfo == null) {
      localObject = "";
    }
    if (QLog.isColorLevel())
    {
      paramSwitchRoomInfo = new StringBuilder();
      paramSwitchRoomInfo.append("getCurrentRecomInfo = ");
      paramSwitchRoomInfo.append((String)localObject);
      QLog.i("IliveReportModule", 2, paramSwitchRoomInfo.toString());
    }
    return localObject;
  }
  
  public boolean getAcceptReEnterRoom()
  {
    return true;
  }
  
  public void onActivityPause(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityPause(paramLifecycleOwner);
    this.i.a(true);
    paramLifecycleOwner = new StringBuilder();
    paramLifecycleOwner.append("onActivityPause mEnterPageTime = ");
    paramLifecycleOwner.append(this.c);
    QLog.i("IliveReportModule", 1, paramLifecycleOwner.toString());
    if ((this.c > 0L) && (h()))
    {
      long l1 = System.currentTimeMillis() - this.c;
      this.d = System.currentTimeMillis();
      paramLifecycleOwner = new StringBuilder();
      paramLifecycleOwner.append("onLiveBackgroudReport time = ");
      paramLifecycleOwner.append(l1);
      QLog.e("IliveReportModule", 1, paramLifecycleOwner.toString());
      IliveLiteDataReport.a().b(j(), l1);
    }
  }
  
  public void onActivityResume(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityResume(paramLifecycleOwner);
    this.i.a(false);
    paramLifecycleOwner = new StringBuilder();
    paramLifecycleOwner.append("onActivityResume mOnBackgroundTime = ");
    paramLifecycleOwner.append(this.d);
    QLog.i("IliveReportModule", 1, paramLifecycleOwner.toString());
    if ((this.d > 0L) && (h()))
    {
      long l1 = System.currentTimeMillis() - this.d;
      paramLifecycleOwner = new StringBuilder();
      paramLifecycleOwner.append("onLiveFontReport time = ");
      paramLifecycleOwner.append(l1);
      QLog.e("IliveReportModule", 1, paramLifecycleOwner.toString());
      IliveLiteDataReport.a().a(j(), l1);
    }
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    paramContext = new StringBuilder();
    paramContext.append("onCreate isCurrent = ");
    paramContext.append(h());
    paramContext.append(" from = ");
    paramContext.append(IliveLiteDataReport.g());
    QLog.e("IliveReportModule", 1, paramContext.toString());
    if (h()) {
      c();
    }
    IliveLiteEventCenter.a().a(this.m);
    b();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.isUserVisibleHint) || ((h()) && (i() == 0))) {
      a(true);
    }
    this.i.a();
    l();
    IliveLiteEventCenter.a().b(this.m);
    m();
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    IliveLiteDataReport.c += 1;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onEnterRoom currentId = ");
    ((StringBuilder)localObject).append(j());
    ((StringBuilder)localObject).append(" enter = ");
    ((StringBuilder)localObject).append(h());
    ((StringBuilder)localObject).append(" mIsFirstFrame = ");
    ((StringBuilder)localObject).append(this.a);
    QLog.i("IliveReportModule", 1, ((StringBuilder)localObject).toString());
    if (h())
    {
      f = j();
      long l1 = System.currentTimeMillis() - this.c;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSsoEnterRoomReport time = ");
      ((StringBuilder)localObject).append(l1);
      QLog.i("IliveReportModule", 1, ((StringBuilder)localObject).toString());
      localObject = IliveLiteDataReport.a();
      long l2 = j();
      int i1;
      if (this.e) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      ((IliveLiteDataReport)localObject).b(l2, l1, i1);
      g();
    }
  }
  
  public void onFirstFrame()
  {
    super.onFirstFrame();
    this.a = true;
    if (h()) {
      g();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFirstFrame isCurrent = ");
    localStringBuilder.append(h());
    QLog.i("IliveReportModule", 1, localStringBuilder.toString());
  }
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    super.onSwitchRoom(paramSwitchRoomInfo);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSwitchRoom currentId = ");
    localStringBuilder.append(j());
    localStringBuilder.append(" switchInfo =  ");
    localStringBuilder.append(paramSwitchRoomInfo.roomId);
    localStringBuilder.append(" lastRoomId = ");
    localStringBuilder.append(f);
    QLog.i("IliveReportModule", 1, localStringBuilder.toString());
    int i1 = getAudienceRoomPager().getScrollDirection();
    if (i1 == 1) {
      IliveLiteDataReport.a().c(f);
    } else if (i1 == 2) {
      IliveLiteDataReport.a().b(f);
    }
    IliveAVCatonReportManager.b().a(false, j());
    a(f, 1002);
    this.c = System.currentTimeMillis();
    k();
    g.put(Long.valueOf(j()), Long.valueOf(this.c));
    IliveLiteDataReport.a().b(a(paramSwitchRoomInfo));
    IliveLiteDataReport.a().e(j());
    f();
    paramSwitchRoomInfo = new StringBuilder();
    paramSwitchRoomInfo.append("onSwitchRoom direction = ");
    paramSwitchRoomInfo.append(i1);
    QLog.i("IliveReportModule", 1, paramSwitchRoomInfo.toString());
  }
  
  public void onVisibleToUser(boolean paramBoolean)
  {
    super.onVisibleToUser(paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onVisibleToUser isVisibleToUser = ");
    localStringBuilder.append(paramBoolean);
    QLog.i("IliveReportModule", 1, localStringBuilder.toString());
    if (!paramBoolean) {
      a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveReportModule
 * JD-Core Version:    0.7.0.1
 */