package cooperation.ilive.lite.module;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.commonpages.room.VerticalViewPager;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.pages.room.bizmodule.RoomBizModule;
import com.tencent.ilive.pages.room.events.RoomCloseEvent;
import com.tencent.ilive.pages.room.events.ScrollBottomEvent;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.event.IliveLiteEventCenter;
import cooperation.ilive.lite.event.IliveLiteEventCenter.Observer;
import cooperation.ilive.lite.heart.IliveRoomHeartController;
import cooperation.ilive.lite.report.IliveLiteDataReport;
import cooperation.ilive.lite.rommswitch.LiveLiteRoomSwitchService;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class IliveReportModule
  extends RoomBizModule
{
  private static HashMap<Long, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static long jdField_c_of_type_Long;
  private static long jdField_d_of_type_Long;
  private long jdField_a_of_type_Long;
  private IliveLiteEventCenter.Observer jdField_a_of_type_CooperationIliveLiteEventIliveLiteEventCenter$Observer = new IliveReportModule.4(this);
  private IliveRoomHeartController jdField_a_of_type_CooperationIliveLiteHeartIliveRoomHeartController = new IliveRoomHeartController();
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private boolean jdField_c_of_type_Boolean;
  private boolean jdField_d_of_type_Boolean = false;
  
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
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(a()), Long.valueOf(this.jdField_a_of_type_Long));
    this.jdField_c_of_type_Boolean = true;
    IliveLiteDataReport.a().a(a(), IliveLiteDataReport.a());
    jdField_d_of_type_Long = System.currentTimeMillis();
    QLog.e("IliveReportModule", 1, "onActivityCreated sEnterRoomTime = " + IliveLiteDataReport.b);
    IliveLiteDataReport.b = 0;
    d();
  }
  
  private void a(long paramLong, int paramInt)
  {
    if (!jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong)))
    {
      QLog.e("IliveReportModule", 1, "onExitRoom enter event has consume , roomid = " + paramLong + " from = " + paramInt);
      return;
    }
    IliveLiteDataReport.jdField_a_of_type_Int = paramInt;
    IliveLiteDataReport.jdField_a_of_type_Long = paramLong;
    if (jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong)) != null) {}
    for (long l = ((Long)jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong))).longValue();; l = 0L)
    {
      jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramLong));
      l = System.currentTimeMillis() - l;
      QLog.e("IliveReportModule", 1, "onExitRoom from = " + paramInt + " stayTime = " + l + " roomId = " + paramLong);
      IliveLiteDataReport.a().a(paramLong, l, paramInt);
      this.jdField_a_of_type_CooperationIliveLiteHeartIliveRoomHeartController.a(paramInt);
      QLog.e("IliveReportModule", 1, "requestExitRoom");
      ThreadManager.getSubThreadHandler().post(new IliveReportModule.2(this, paramLong));
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    QLog.e("IliveReportModule", 1, "handleExitRoomHeartReport roomId = " + a() + "  isCurrent = " + a() + " mHeartExitRoomReported = " + this.jdField_d_of_type_Boolean);
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
    boolean bool = false;
    int j = a();
    if (getAudienceRoomPager().getViewPager() != null) {}
    for (int i = getAudienceRoomPager().getViewPager().getCurrentItem();; i = 0)
    {
      if (j == i) {
        bool = true;
      }
      return bool;
    }
  }
  
  private void b()
  {
    getEvent().observe(ScrollBottomEvent.class, new IliveReportModule.3(this));
  }
  
  private void c()
  {
    long l1;
    IliveLiteDataReport localIliveLiteDataReport;
    long l2;
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      QLog.i("IliveReportModule", 1, "onSeeRoomVideoReport enterTime = " + l1);
      localIliveLiteDataReport = IliveLiteDataReport.a();
      l2 = a();
      if (!this.jdField_c_of_type_Boolean) {
        break label83;
      }
    }
    label83:
    for (int i = 1;; i = 2)
    {
      localIliveLiteDataReport.c(l2, l1, i);
      this.jdField_b_of_type_Boolean = true;
      return;
    }
  }
  
  private void d()
  {
    QLog.e("IliveReportModule", 1, "initHeartReport roomId = " + a());
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_CooperationIliveLiteHeartIliveRoomHeartController.a(a());
  }
  
  private void e()
  {
    QLog.e("IliveReportModule", 1, "onDestory isCurrent = " + a());
    if ((jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(a()))) && (a()))
    {
      QLog.e("IliveReportModule", 1, "onDestory enter report exit , roomId = " + a());
      a(a(), 1);
    }
  }
  
  private void f()
  {
    if (a())
    {
      LiveLiteRoomSwitchService.a();
      long l = System.currentTimeMillis() - jdField_d_of_type_Long;
      QLog.e("IliveReportModule", 1, "onActivityDestroyed stayTime = " + l + " sExitFrom = " + IliveLiteDataReport.jdField_a_of_type_Int + " times = " + IliveLiteDataReport.b + " roomId = " + IliveLiteDataReport.jdField_a_of_type_Long);
      IliveLiteDataReport.a().a(0L, l, IliveLiteDataReport.jdField_a_of_type_Int, IliveLiteDataReport.b);
    }
  }
  
  public boolean getAcceptReEnterRoom()
  {
    return true;
  }
  
  public void onActivityPause(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityPause(paramLifecycleOwner);
    this.jdField_a_of_type_CooperationIliveLiteHeartIliveRoomHeartController.a(true);
    QLog.i("IliveReportModule", 1, "onActivityPause mEnterPageTime = " + this.jdField_a_of_type_Long);
    if ((this.jdField_a_of_type_Long > 0L) && (a()))
    {
      long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      QLog.e("IliveReportModule", 1, "onLiveBackgroudReport time = " + l);
      IliveLiteDataReport.a().b(a(), l);
    }
  }
  
  public void onActivityResume(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityResume(paramLifecycleOwner);
    this.jdField_a_of_type_CooperationIliveLiteHeartIliveRoomHeartController.a(false);
    QLog.i("IliveReportModule", 1, "onActivityResume mOnBackgroundTime = " + this.jdField_b_of_type_Long);
    if ((this.jdField_b_of_type_Long > 0L) && (a()))
    {
      long l = System.currentTimeMillis() - this.jdField_b_of_type_Long;
      QLog.e("IliveReportModule", 1, "onLiveFontReport time = " + l);
      IliveLiteDataReport.a().a(a(), l);
    }
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    QLog.e("IliveReportModule", 1, "onCreate isCurrent = " + a() + " from = " + IliveLiteDataReport.a());
    if (a()) {
      a();
    }
    IliveLiteEventCenter.a().a(this.jdField_a_of_type_CooperationIliveLiteEventIliveLiteEventCenter$Observer);
    getEvent().observe(RoomCloseEvent.class, new IliveReportModule.1(this));
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.isUserVisibleHint) || ((a()) && (a() == 0))) {
      a(true);
    }
    this.jdField_a_of_type_CooperationIliveLiteHeartIliveRoomHeartController.a();
    e();
    IliveLiteEventCenter.a().b(this.jdField_a_of_type_CooperationIliveLiteEventIliveLiteEventCenter$Observer);
    f();
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    int i = 1;
    super.onEnterRoom(paramBoolean);
    IliveLiteDataReport.b += 1;
    QLog.i("IliveReportModule", 1, "onEnterRoom currentId = " + a() + " enter = " + a() + " mIsFirstFrame = " + this.jdField_a_of_type_Boolean);
    long l1;
    IliveLiteDataReport localIliveLiteDataReport;
    long l2;
    if (a())
    {
      jdField_c_of_type_Long = a();
      l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      QLog.i("IliveReportModule", 1, "onSsoEnterRoomReport time = " + l1);
      localIliveLiteDataReport = IliveLiteDataReport.a();
      l2 = a();
      if (!this.jdField_c_of_type_Boolean) {
        break label151;
      }
    }
    for (;;)
    {
      localIliveLiteDataReport.b(l2, l1, i);
      c();
      return;
      label151:
      i = 2;
    }
  }
  
  public void onFirstFrame()
  {
    super.onFirstFrame();
    this.jdField_a_of_type_Boolean = true;
    if (a()) {
      c();
    }
    QLog.i("IliveReportModule", 1, "onFirstFrame isCurrent = " + a());
  }
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    super.onSwitchRoom(paramSwitchRoomInfo);
    QLog.i("IliveReportModule", 1, "onSwitchRoom currentId = " + a() + " switchInfo =  " + paramSwitchRoomInfo.roomId + " lastRoomId = " + jdField_c_of_type_Long);
    int i = getAudienceRoomPager().getScrollDirection();
    if (i == 1) {
      IliveLiteDataReport.a().c(jdField_c_of_type_Long);
    }
    for (;;)
    {
      a(jdField_c_of_type_Long, 2);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      d();
      jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(a()), Long.valueOf(this.jdField_a_of_type_Long));
      IliveLiteDataReport.a().e(a());
      b();
      QLog.i("IliveReportModule", 1, "onSwitchRoom direction = " + i);
      return;
      if (i == 2) {
        IliveLiteDataReport.a().b(jdField_c_of_type_Long);
      }
    }
  }
  
  public void onVisibleToUser(boolean paramBoolean)
  {
    super.onVisibleToUser(paramBoolean);
    QLog.i("IliveReportModule", 1, "onVisibleToUser isVisibleToUser = " + paramBoolean);
    if (!paramBoolean) {
      a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveReportModule
 * JD-Core Version:    0.7.0.1
 */