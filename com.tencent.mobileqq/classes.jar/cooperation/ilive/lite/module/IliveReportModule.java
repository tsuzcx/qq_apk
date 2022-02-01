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
  private static HashMap<Long, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static long jdField_c_of_type_Long;
  private static long jdField_d_of_type_Long;
  private long jdField_a_of_type_Long;
  private IliveLiteEventCenter.Observer jdField_a_of_type_CooperationIliveLiteEventIliveLiteEventCenter$Observer = new IliveReportModule.5(this);
  private IliveFloatWindowHelper.IPermissionCallback jdField_a_of_type_CooperationIliveLiteFloatwindowIliveFloatWindowHelper$IPermissionCallback = new IliveReportModule.6(this);
  private IliveRoomHeartController jdField_a_of_type_CooperationIliveLiteHeartIliveRoomHeartController = new IliveRoomHeartController();
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean e = true;
  
  private int a()
  {
    if ((this.roomBizContext != null) && (this.roomBizContext.getEnterRoomInfo() != null)) {
      return this.roomBizContext.getEnterRoomInfo().bootModulesIndex;
    }
    return 0;
  }
  
  private long a()
  {
    if ((this.roomBizContext != null) && (this.roomBizContext.getEnterRoomInfo() != null)) {
      return this.roomBizContext.getEnterRoomInfo().roomId;
    }
    return 0L;
  }
  
  private void a()
  {
    getEvent().observe(RoomCloseEvent.class, new IliveReportModule.1(this));
    getEvent().observe(PlayerStateEvent.class, new IliveReportModule.2(this));
  }
  
  private void a(long paramLong, int paramInt)
  {
    if (!jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong)))
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
    IliveLiteDataReport.jdField_a_of_type_Int = paramInt;
    IliveLiteDataReport.jdField_a_of_type_Long = paramLong;
    if (jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong)) != null) {
      l = ((Long)jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong))).longValue();
    } else {
      l = 0L;
    }
    jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong));
    long l = System.currentTimeMillis() - l;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onExitRoom from = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" stayTime = ");
    localStringBuilder.append(l);
    localStringBuilder.append(" roomId = ");
    localStringBuilder.append(paramLong);
    QLog.e("IliveReportModule", 1, localStringBuilder.toString());
    IliveLiteDataReport.a().a(paramLong, l, paramInt);
    this.jdField_a_of_type_CooperationIliveLiteHeartIliveRoomHeartController.a(paramInt);
    QLog.e("IliveReportModule", 1, "requestExitRoom");
    ThreadManager.getSubThreadHandler().post(new IliveReportModule.3(this, paramLong));
  }
  
  private void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleExitRoomHeartReport roomId = ");
    localStringBuilder.append(a());
    localStringBuilder.append("  isCurrent = ");
    localStringBuilder.append(a());
    localStringBuilder.append(" mHeartExitRoomReported = ");
    localStringBuilder.append(this.jdField_d_of_type_Boolean);
    QLog.e("IliveReportModule", 1, localStringBuilder.toString());
    if (this.jdField_d_of_type_Boolean)
    {
      QLog.i("IliveReportModule", 1, "handleExitRoomHeartReport has reportFinal");
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_CooperationIliveLiteHeartIliveRoomHeartController.a(paramBoolean, a());
  }
  
  private boolean a()
  {
    int j = a();
    IAudienceRoomPager localIAudienceRoomPager = getAudienceRoomPager();
    boolean bool = false;
    int i;
    if (localIAudienceRoomPager != null) {
      i = getAudienceRoomPager().getCurrentIndex();
    } else {
      i = 0;
    }
    if (j == i) {
      bool = true;
    }
    return bool;
  }
  
  private String b()
  {
    Object localObject1 = BusinessManager.a.a();
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
  
  private void b()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(a()), Long.valueOf(this.jdField_a_of_type_Long));
    this.jdField_c_of_type_Boolean = true;
    IliveLiteDataReport.a().b(a());
    IliveLiteDataReport.a().a(a(), IliveLiteDataReport.a());
    jdField_d_of_type_Long = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onActivityCreated sEnterRoomTime = ");
    localStringBuilder.append(IliveLiteDataReport.b);
    QLog.e("IliveReportModule", 1, localStringBuilder.toString());
    IliveLiteDataReport.b = 0;
    f();
    c();
  }
  
  private void c()
  {
    EnterRoomConfig localEnterRoomConfig = BusinessManager.a.a();
    if ((localEnterRoomConfig != null) && (localEnterRoomConfig.extData != null)) {
      IliveLiteMonitorUtil.d((String)RoomManager.a(localEnterRoomConfig.extData.getString("mqqschema")).get("first_click_time"));
    }
  }
  
  private void d()
  {
    getEvent().observe(ScrollBottomEvent.class, new IliveReportModule.4(this));
  }
  
  private void e()
  {
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSeeRoomVideoReport enterTime = ");
      ((StringBuilder)localObject).append(l1);
      QLog.i("IliveReportModule", 1, ((StringBuilder)localObject).toString());
      localObject = IliveLiteDataReport.a();
      long l2 = a();
      int i;
      if (this.jdField_c_of_type_Boolean) {
        i = 1;
      } else {
        i = 2;
      }
      ((IliveLiteDataReport)localObject).c(l2, l1, i);
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  private void f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initHeartReport roomId = ");
    localStringBuilder.append(a());
    QLog.e("IliveReportModule", 1, localStringBuilder.toString());
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_CooperationIliveLiteHeartIliveRoomHeartController.a(a());
  }
  
  private void g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestory isCurrent = ");
    localStringBuilder.append(a());
    QLog.e("IliveReportModule", 1, localStringBuilder.toString());
    if ((jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(a()))) && (a()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestory enter report exit , roomId = ");
      localStringBuilder.append(a());
      QLog.e("IliveReportModule", 1, localStringBuilder.toString());
      a(a(), 1001);
    }
  }
  
  private void h()
  {
    if (a())
    {
      LiveLiteRoomSwitchService.a();
      long l = System.currentTimeMillis() - jdField_d_of_type_Long;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityDestroyed stayTime = ");
      localStringBuilder.append(l);
      localStringBuilder.append(" sExitFrom = ");
      localStringBuilder.append(IliveLiteDataReport.jdField_a_of_type_Int);
      localStringBuilder.append(" times = ");
      localStringBuilder.append(IliveLiteDataReport.b);
      localStringBuilder.append(" roomId = ");
      localStringBuilder.append(IliveLiteDataReport.jdField_a_of_type_Long);
      QLog.e("IliveReportModule", 1, localStringBuilder.toString());
      IliveLiteDataReport.a().a(0L, l, IliveLiteDataReport.jdField_a_of_type_Int, IliveLiteDataReport.b);
    }
  }
  
  private void i()
  {
    if (getEvent() != null) {
      getEvent().post(new RoomCloseEvent((short)1004));
    }
  }
  
  public String a()
  {
    Object localObject1 = BusinessManager.a.a();
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
      ((JSONObject)localObject).put("session_id", b());
      localObject = ((JSONObject)localObject).toString();
      paramSwitchRoomInfo = (SwitchRoomInfo)localObject;
    }
    catch (Exception localException)
    {
      label76:
      break label76;
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
    this.jdField_a_of_type_CooperationIliveLiteHeartIliveRoomHeartController.a(true);
    paramLifecycleOwner = new StringBuilder();
    paramLifecycleOwner.append("onActivityPause mEnterPageTime = ");
    paramLifecycleOwner.append(this.jdField_a_of_type_Long);
    QLog.i("IliveReportModule", 1, paramLifecycleOwner.toString());
    if ((this.jdField_a_of_type_Long > 0L) && (a()))
    {
      long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      paramLifecycleOwner = new StringBuilder();
      paramLifecycleOwner.append("onLiveBackgroudReport time = ");
      paramLifecycleOwner.append(l);
      QLog.e("IliveReportModule", 1, paramLifecycleOwner.toString());
      IliveLiteDataReport.a().b(a(), l);
    }
  }
  
  public void onActivityResume(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityResume(paramLifecycleOwner);
    this.jdField_a_of_type_CooperationIliveLiteHeartIliveRoomHeartController.a(false);
    paramLifecycleOwner = new StringBuilder();
    paramLifecycleOwner.append("onActivityResume mOnBackgroundTime = ");
    paramLifecycleOwner.append(this.jdField_b_of_type_Long);
    QLog.i("IliveReportModule", 1, paramLifecycleOwner.toString());
    if ((this.jdField_b_of_type_Long > 0L) && (a()))
    {
      long l = System.currentTimeMillis() - this.jdField_b_of_type_Long;
      paramLifecycleOwner = new StringBuilder();
      paramLifecycleOwner.append("onLiveFontReport time = ");
      paramLifecycleOwner.append(l);
      QLog.e("IliveReportModule", 1, paramLifecycleOwner.toString());
      IliveLiteDataReport.a().a(a(), l);
    }
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    paramContext = new StringBuilder();
    paramContext.append("onCreate isCurrent = ");
    paramContext.append(a());
    paramContext.append(" from = ");
    paramContext.append(IliveLiteDataReport.a());
    QLog.e("IliveReportModule", 1, paramContext.toString());
    if (a()) {
      b();
    }
    IliveLiteEventCenter.a().a(this.jdField_a_of_type_CooperationIliveLiteEventIliveLiteEventCenter$Observer);
    a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.isUserVisibleHint) || ((a()) && (a() == 0))) {
      a(true);
    }
    this.jdField_a_of_type_CooperationIliveLiteHeartIliveRoomHeartController.a();
    g();
    IliveLiteEventCenter.a().b(this.jdField_a_of_type_CooperationIliveLiteEventIliveLiteEventCenter$Observer);
    h();
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    IliveLiteDataReport.b += 1;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onEnterRoom currentId = ");
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append(" enter = ");
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append(" mIsFirstFrame = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
    QLog.i("IliveReportModule", 1, ((StringBuilder)localObject).toString());
    if (a())
    {
      IliveAVCatonReportManager.a().b();
      jdField_c_of_type_Long = a();
      long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSsoEnterRoomReport time = ");
      ((StringBuilder)localObject).append(l1);
      QLog.i("IliveReportModule", 1, ((StringBuilder)localObject).toString());
      localObject = IliveLiteDataReport.a();
      long l2 = a();
      int i;
      if (this.jdField_c_of_type_Boolean) {
        i = 1;
      } else {
        i = 2;
      }
      ((IliveLiteDataReport)localObject).b(l2, l1, i);
      e();
    }
  }
  
  public void onFirstFrame()
  {
    super.onFirstFrame();
    this.jdField_a_of_type_Boolean = true;
    if (a()) {
      e();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFirstFrame isCurrent = ");
    localStringBuilder.append(a());
    QLog.i("IliveReportModule", 1, localStringBuilder.toString());
  }
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    super.onSwitchRoom(paramSwitchRoomInfo);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSwitchRoom currentId = ");
    localStringBuilder.append(a());
    localStringBuilder.append(" switchInfo =  ");
    localStringBuilder.append(paramSwitchRoomInfo.roomId);
    localStringBuilder.append(" lastRoomId = ");
    localStringBuilder.append(jdField_c_of_type_Long);
    QLog.i("IliveReportModule", 1, localStringBuilder.toString());
    int i = getAudienceRoomPager().getScrollDirection();
    if (i == 1) {
      IliveLiteDataReport.a().c(jdField_c_of_type_Long);
    } else if (i == 2) {
      IliveLiteDataReport.a().b(jdField_c_of_type_Long);
    }
    a(jdField_c_of_type_Long, 1002);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    f();
    jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(a()), Long.valueOf(this.jdField_a_of_type_Long));
    IliveLiteDataReport.a().b(a(paramSwitchRoomInfo));
    IliveLiteDataReport.a().e(a());
    d();
    paramSwitchRoomInfo = new StringBuilder();
    paramSwitchRoomInfo.append("onSwitchRoom direction = ");
    paramSwitchRoomInfo.append(i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveReportModule
 * JD-Core Version:    0.7.0.1
 */