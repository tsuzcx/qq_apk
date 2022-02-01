package com.tencent.mobileqq.colornote.smallscreen;

import android.app.Application.ActivityLifecycleCallbacks;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.upcoming.UpComingMsgManager;
import com.tencent.mobileqq.activity.aio.upcoming.UpcomingNotifyState;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.ColorNoteHelper;
import com.tencent.mobileqq.colornote.ColorNoteRecentView;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteHandler;
import com.tencent.mobileqq.colornote.data.ColorNoteObserver;
import com.tencent.mobileqq.colornote.data.ColorNoteProxy;
import com.tencent.mobileqq.colornote.data.ColorNoteRecentConfBean;
import com.tencent.mobileqq.colornote.data.ColorNoteRecentConfigProcessor;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.colornote.list.ColorNoteListController;
import com.tencent.mobileqq.colornote.list.OnListHideListener;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.miniapp.MiniAppColorNoteData;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.AccessibilityUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.util.LiuHaiUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.AppService;
import mqq.os.MqqHandler;

public class ColorNoteSmallScreenService
  extends AppService
  implements OnListHideListener, ColorNoteSmallScreenFullToast.IColorNoteSmallScreenFullToastListener, ColorNoteSmallScreenRelativeLayout.FloatListener, IUpcomingController, SkinnableServiceProcesser.Callback
{
  static boolean jdField_a_of_type_Boolean = true;
  int jdField_a_of_type_Int;
  Application.ActivityLifecycleCallbacks jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks = new ColorNoteSmallScreenService.2(this);
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ColorNoteSmallScreenService.1(this);
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private UpcomingNotifyState jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingUpcomingNotifyState = new UpcomingNotifyState(new ColorNoteSmallScreenService.4(this));
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ColorNoteListController jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController;
  ColorNoteSmallScreenFullToast jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenFullToast;
  ColorNoteSmallScreenRelativeLayout jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout;
  ColorNoteSmallScreenToast jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenToast;
  SkinnableServiceProcesser jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenSkinnableServiceProcesser;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  List<ColorNote> jdField_a_of_type_JavaUtilList = new ArrayList();
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  int jdField_b_of_type_Int;
  Runnable jdField_b_of_type_JavaLangRunnable = null;
  boolean jdField_b_of_type_Boolean = false;
  boolean c = true;
  boolean d = true;
  boolean e = true;
  boolean f = false;
  boolean g = false;
  
  private MiniAppInfo a(ColorNote paramColorNote)
  {
    Object localObject = paramColorNote.getSubType();
    if ((((String)localObject).contains("###")) && (((String)localObject).split("###").length == 2))
    {
      paramColorNote = paramColorNote.getReserve();
      localObject = Parcel.obtain();
      ((Parcel)localObject).unmarshall(paramColorNote, 0, paramColorNote.length);
      ((Parcel)localObject).setDataPosition(0);
      return ((MiniAppColorNoteData)MiniAppColorNoteData.CREATOR.createFromParcel((Parcel)localObject)).a;
    }
    return null;
  }
  
  private List<ColorNote> a(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = null;
    if (paramQQAppInterface == null) {
      paramQQAppInterface = (QQAppInterface)localObject1;
    }
    for (;;)
    {
      localObject1 = paramQQAppInterface;
      if (paramQQAppInterface == null) {
        localObject1 = new ArrayList();
      }
      return localObject1;
      Object localObject2 = paramQQAppInterface.getProxyManager();
      paramQQAppInterface = (QQAppInterface)localObject1;
      if (localObject2 != null)
      {
        localObject2 = ((ProxyManager)localObject2).a();
        paramQQAppInterface = (QQAppInterface)localObject1;
        if (localObject2 != null)
        {
          localObject2 = ((ColorNoteProxy)localObject2).a();
          paramQQAppInterface = (QQAppInterface)localObject1;
          if (localObject2 != null) {
            paramQQAppInterface = (QQAppInterface)localObject2;
          }
        }
      }
    }
  }
  
  private void a(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getIntExtra("key_upcoming_notify", -1) == 2))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingUpcomingNotifyState.a();
      ReportController.b(null, "dc00898", "", "", "0X800AE85", "0X800AE85", 0, 0, "", "", "", "");
    }
  }
  
  private void a(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if ((paramIntent != null) && (paramIntent.getIntExtra("key_upcoming_notify", -1) == 2))
    {
      paramIntent = paramIntent.getSerializableExtra("key_upcoming_color_note");
      if (QLog.isDevelopLevel()) {
        QLog.d("ColorNoteSmallScreenService", 2, "handleOtherCommand() is called. colorNote = " + paramIntent);
      }
      if ((paramIntent instanceof ColorNote))
      {
        paramIntent = (ColorNote)paramIntent;
        if (paramIntent.getServiceType() == 17235968)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingUpcomingNotifyState.a();
          b(paramIntent);
          paramIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a(paramIntent.a());
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.g();
        }
      }
    }
  }
  
  private void a(Point paramPoint, boolean paramBoolean)
  {
    int j;
    if (paramBoolean) {
      j = paramPoint.x;
    }
    for (int i = paramPoint.y;; i = paramPoint.x)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController == null) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController = new ColorNoteListController(this, this);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController.a()) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController.a(a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      return;
      j = paramPoint.y;
    }
    paramPoint = new WindowManager.LayoutParams();
    paramPoint.height = -1;
    paramPoint.width = -1;
    paramPoint.flags = 16777984;
    paramPoint.format = -3;
    paramPoint.windowAnimations = 0;
    Object localObject;
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramPoint.type = 2038;
      localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController;
      if (j > 0) {
        break label230;
      }
    }
    label230:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((ColorNoteListController)localObject).a(paramBoolean, i, this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.b() + i);
      localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController.a();
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenToast.a().addView((View)localObject, paramPoint);
        LiuHaiUtils.a(paramPoint);
        this.e = false;
        if (QLog.isDevelopLevel()) {
          QLog.w("ColorNoteSmallScreenService", 1, "showList");
        }
        f();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingUpcomingNotifyState.b();
        i();
        return;
      }
      catch (Exception paramPoint)
      {
        QLog.e("ColorNoteSmallScreenService", 1, "[showList] error ", paramPoint);
      }
      paramPoint.type = 2002;
      break;
    }
  }
  
  static void a(WindowManager.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.flags = 16909064;
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramLayoutParams.type = 2038;
      return;
    }
    paramLayoutParams.type = 2002;
  }
  
  private void a(QQAppInterface paramQQAppInterface, Point paramPoint, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    ColorNoteSmallScreenUtil.a(paramPoint.x + this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a() / 2, paramPoint.y + this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.b() / 2);
    paramQQAppInterface = SharedPreUtils.a(this, paramQQAppInterface.getCurrentUin()).edit();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramQQAppInterface.putBoolean("colornote_windows_land", bool);
      paramQQAppInterface.putInt("colornote_windows_x", paramPoint.x);
      paramQQAppInterface.putInt("colornote_windows_y", paramPoint.y);
      paramQQAppInterface.apply();
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setAction("key_float_window_position");
      paramQQAppInterface.putExtra("key_float_window_position_x", paramPoint.x);
      paramQQAppInterface.putExtra("key_float_window_position_y", paramPoint.y);
      sendBroadcast(paramQQAppInterface);
      return;
    }
  }
  
  private void a(List<ColorNote> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      QLog.e("ColorNoteSmallScreenService", 1, "note size 0");
    }
    do
    {
      return;
      UpComingMsgManager localUpComingMsgManager = (UpComingMsgManager)this.app.getManager(QQManagerFactory.UPCOMING_MSG_PRE_MANAGER);
      if (localUpComingMsgManager != null)
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext()) {
          localUpComingMsgManager.a((ColorNote)localIterator.next());
        }
      }
      QLog.e("ColorNoteSmallScreenService", 1, "manager not init");
    } while (!ColorNoteUtils.a(paramList));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingUpcomingNotifyState.a();
  }
  
  public static void a(boolean paramBoolean, int paramInt)
  {
    jdField_a_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteSmallScreenService", 2, "from: " + paramInt + ", should show: " + paramBoolean);
    }
  }
  
  private void b(ColorNote paramColorNote)
  {
    if ((paramColorNote == null) || (paramColorNote.getServiceType() != 17235968)) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilList.add(paramColorNote);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteSmallScreenService", 2, "add note: " + paramColorNote.toString());
      }
    } while (!AppSetting.d);
    paramColorNote = HardCodeUtil.a(2131720391) + ColorNoteUtils.a(paramColorNote);
    AccessibilityUtils.a(this.jdField_a_of_type_AndroidViewView, paramColorNote);
  }
  
  private void g()
  {
    if (!this.g)
    {
      BaseApplicationImpl.getApplication().registerActivityLifecycleCallbacks(this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
      this.g = true;
    }
  }
  
  private void h()
  {
    if (this.g)
    {
      BaseApplicationImpl.getApplication().unregisterActivityLifecycleCallbacks(this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
      this.g = false;
    }
  }
  
  private void i()
  {
    List localList = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    int i = 0;
    for (;;)
    {
      MiniAppInfo localMiniAppInfo;
      IMiniAppService localIMiniAppService;
      try
      {
        if (i < localList.size())
        {
          ColorNote localColorNote = (ColorNote)localList.get(i);
          if (ColorNoteUtils.a(localColorNote.getServiceType()) != 16842752) {
            break label177;
          }
          localMiniAppInfo = a(localColorNote);
          localIMiniAppService = (IMiniAppService)QRoute.api(IMiniAppService.class);
          if (!ColorNoteUtils.b(localColorNote)) {
            break label131;
          }
          if (localMiniAppInfo != null) {
            localIMiniAppService.report4239AsyncBySdkMiniAppInfo(localMiniAppInfo, "addRecentColorSign", "recentColorSign_enter", "expo", null);
          } else {
            localIMiniAppService.report4239Async("addRecentColorSign", "recentColorSign_enter", "expo", null, null, null);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ColorNoteSmallScreenService", 1, "reportColorNoteShow get a throwable", localThrowable);
      }
      return;
      label131:
      if (localMiniAppInfo != null) {
        localIMiniAppService.report4239AsyncBySdkMiniAppInfo(localMiniAppInfo, "addColorSign", "colorSign_enter", "expo", null);
      } else {
        localIMiniAppService.report4239Async("addColorSign", "colorSign_enter", "expo", null, null, null);
      }
      label177:
      i += 1;
    }
  }
  
  private void j()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.rightMargin = 0;
    localLayoutParams.leftMargin = 0;
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setShouldMaxRootView(false);
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.e();
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.c();
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenToast.b();
  }
  
  private void k()
  {
    Object localObject = new ArrayList(a());
    if (((List)localObject).size() != 0)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a((ColorNote)((Iterator)localObject).next());
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    if (localObject != null)
    {
      ((ColorNoteProxy)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a(((ColorNoteProxy)localObject).a());
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingUpcomingNotifyState.a();
  }
  
  public int a(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout)
  {
    return this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenToast.a().x;
  }
  
  public List<ColorNote> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public MqqHandler a()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler == null) {
      this.jdField_a_of_type_MqqOsMqqHandler = ThreadManager.getUIHandler();
    }
    return this.jdField_a_of_type_MqqOsMqqHandler;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.w("ColorNoteSmallScreenService", 1, "onBackevent");
    }
    c();
  }
  
  public void a(Point paramPoint, int paramInt)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPoint, paramInt);
  }
  
  public void a(ColorNote paramColorNote)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramColorNote);
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteSmallScreenService", 2, "remove note: " + paramColorNote.toString());
      }
    }
  }
  
  public void a(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout) {}
  
  public void a(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramColorNoteSmallScreenRelativeLayout = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenToast;
    WindowManager.LayoutParams localLayoutParams = paramColorNoteSmallScreenRelativeLayout.a();
    localLayoutParams.x = paramInt1;
    localLayoutParams.y = paramInt2;
    localLayoutParams.width = (paramInt3 - paramInt1);
    localLayoutParams.height = (paramInt4 - paramInt2);
    localLayoutParams.windowAnimations = 0;
    paramColorNoteSmallScreenRelativeLayout.b();
  }
  
  public void a(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    paramColorNoteSmallScreenRelativeLayout = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenToast;
    WindowManager.LayoutParams localLayoutParams = paramColorNoteSmallScreenRelativeLayout.a();
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    float f1 = getResources().getDimensionPixelSize(2131298988);
    if (paramInt1 <= 0)
    {
      localLayoutParams.x = paramInt1;
      localLayoutParams.y = paramInt2;
      localLayoutParams.width = (paramInt3 - paramInt1);
      localLayoutParams.height = (paramInt4 - paramInt2);
      localLayoutParams1.width = ((int)(paramInt5 + f1));
      paramColorNoteSmallScreenRelativeLayout.b();
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.c()) {
          paramInt1 = getResources().getDimensionPixelSize(2131296722) / 2;
        }
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenFullToast.a(paramInt3 - this.jdField_b_of_type_Int, paramInt2);
      }
    }
    do
    {
      return;
      localLayoutParams.x = paramInt1;
      localLayoutParams.y = paramInt2;
      localLayoutParams.width = (paramInt3 - paramInt1);
      localLayoutParams.height = (paramInt4 - paramInt2);
      localLayoutParams1.width = ((int)(f1 * 2.0F));
      paramColorNoteSmallScreenRelativeLayout.b();
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenFullToast.a(this.jdField_b_of_type_Int + paramInt1, paramInt2);
      }
    } while (!QLog.isDevelopLevel());
    QLog.w("ColorNoteSmallScreenService", 1, "longpress width = " + localLayoutParams.width + " left = " + paramInt1 + ", right = " + paramInt3 + "offset = " + paramInt5 + ", getMeasuredWidth = " + this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.getMeasuredWidth());
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.w("ColorNoteSmallScreenService", 1, "smallscreen longclick");
    }
    ReportController.b(null, "dc00898", "", "", "0X800A6C3", "0X800A6C3", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenFullToast.a();
    return true;
  }
  
  public boolean a(Point paramPoint, boolean paramBoolean)
  {
    a(paramPoint, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingUpcomingNotifyState.b();
    ReportController.b(null, "dc00898", "", "", "0X800A6CB", "0X800A6CB", 0, 0, "", "", "", "");
    if (ColorNoteUtils.a(this.jdField_a_of_type_JavaUtilList)) {}
    for (int i = 1;; i = 2)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A6CB", "0X800A6CB", i, 0, "", "", "", "");
      return true;
    }
  }
  
  public int b(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout)
  {
    return this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenToast.a().y;
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController.a(false);
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenToast.a().removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController.a());
      }
      this.e = true;
      if (QLog.isDevelopLevel()) {
        QLog.w("ColorNoteSmallScreenService", 1, "onHideList");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioUpcomingUpcomingNotifyState.c();
      f();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ColorNoteSmallScreenService", 2, localRuntimeException, new Object[0]);
        }
      }
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.w("ColorNoteSmallScreenService", 1, "onFullClick");
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.rightMargin = 0;
    localLayoutParams.leftMargin = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a()) {
      localLayoutParams.rightMargin = DisplayUtil.a(getBaseContext(), 8.0F);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setShouldMaxRootView(false);
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.b();
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.e();
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.c();
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenToast.b();
      return;
      localLayoutParams.leftMargin = DisplayUtil.a(getBaseContext(), 8.0F);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.w("ColorNoteSmallScreenService", 1, "onDelClick");
    }
    ColorNoteProxy localColorNoteProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    ReportController.b(null, "dc00898", "", "", "0X800A6C4", "0X800A6C4", 0, 0, localColorNoteProxy.a() + "", "", "", "");
    Object localObject = localColorNoteProxy.a(false);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localObject = ((List)localObject).iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext())
    {
      ColorNote localColorNote = (ColorNote)((Iterator)localObject).next();
      localArrayList1.add(localColorNote.getServiceType() + "");
      localArrayList2.add(localColorNote.getSubType());
      if (localColorNote.getServiceType() != 16973824) {
        break label272;
      }
      i = 1;
    }
    label272:
    for (;;)
    {
      break;
      localObject = new Intent("key_delete_item_call");
      ((Intent)localObject).putStringArrayListExtra("key_color_note_servicetype_list", localArrayList1);
      ((Intent)localObject).putStringArrayListExtra("key_color_note_suptype_list", localArrayList2);
      ColorNoteHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
      ColorNoteSmallScreenUtil.b(this);
      QQToast.a(BaseApplication.getContext(), 0, "彩签已取消", 1).a();
      if (i != 0) {
        QQPlayerService.c(this);
      }
      ((Intent)localObject).putExtra("extra_can_add_colornote", localColorNoteProxy.a());
      sendBroadcast((Intent)localObject);
      return;
    }
  }
  
  public void e()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("ColorNoteSmallScreenService", 1, "onPostThemeChanged");
    }
    Point localPoint = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a();
    boolean bool = ColorNoteSmallScreenRelativeLayout.d();
    if ((ThemeUtil.isNowThemeIsNight(null, false, null)) || (bool)) {
      if (localPoint.x <= 0) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839394);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController != null) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController.c();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839396);
      continue;
      if (localPoint.x <= 0) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839397);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839399);
      }
    }
  }
  
  void f()
  {
    if (!this.jdField_b_of_type_Boolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break label522;
      }
    }
    label522:
    for (boolean bool1 = ColorNoteSmallScreenPermissionUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());; bool1 = false)
    {
      boolean bool2;
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.getVisibility() == 0)
      {
        bool2 = true;
        if ((!bool1) || (!jdField_a_of_type_Boolean) || (!this.d) || (!this.e)) {
          break label487;
        }
        i = 1;
        label63:
        if (QLog.isColorLevel())
        {
          QLog.w("ColorNoteSmallScreenService", 1, "isColorNoteSmallScreenVisible = " + bool2 + ", isOpEnable = " + bool1 + ", mShouldShow = " + jdField_a_of_type_Boolean + ", mIsAppOnForeground = " + this.d + ", mIsNotInColorNoteList = " + this.e + ", Toast Isvisiable = " + this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenToast.b());
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a();
          localObject2 = new Rect();
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.getWindowVisibleDisplayFrame((Rect)localObject2);
          QLog.w("ColorNoteSmallScreenService", 1, "mPosition[" + localObject1 + "], mScreenWidth[" + this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.c() + "], mScreenHeight[" + this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.d() + "], mWindowWidth[" + ((Rect)localObject2).width() + "], mWindowHeight[" + ((Rect)localObject2).height() + "]");
        }
        if (i == 0) {
          break label504;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenToast.b()) {
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenToast.a();
        }
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
        Object localObject1 = ((ColorNoteProxy)localObject2).a();
        ((ColorNoteProxy)localObject2).a(false);
        this.jdField_a_of_type_Int = ((List)localObject1).size();
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a((List)localObject1);
        if (QLog.isColorLevel()) {
          QLog.w("ColorNoteSmallScreenService", 1, "mVisiableCurrCount = " + this.jdField_a_of_type_Int + ", sumcount = " + ((ColorNoteProxy)localObject2).a());
        }
        if (this.jdField_a_of_type_Int <= 0) {
          break label492;
        }
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.d();
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setVisibility(0);
        localObject2 = String.format(getResources().getString(2131690970), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
        localObject1 = ColorNoteUtils.a((List)localObject1);
        this.jdField_a_of_type_AndroidViewView.setContentDescription((String)localObject2 + (String)localObject1);
      }
      label487:
      label492:
      label504:
      while (!bool2) {
        for (;;)
        {
          return;
          bool2 = false;
          break;
          i = 0;
          break label63;
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setVisibility(8);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setVisibility(8);
      j();
      return;
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    if ((this.app != null) && ((this.app instanceof QQAppInterface)))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.app);
      ((QQAppInterface)this.app).addObserver(new ColorNoteObserver());
    }
    IntentFilter localIntentFilter;
    try
    {
      LayoutInflater localLayoutInflater = (LayoutInflater)getSystemService("layout_inflater");
      this.c = ColorNoteSmallScreenPermissionUtil.a(BaseApplicationImpl.getContext());
      localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_update_cn_smallscreen_state");
      localIntentFilter.addAction("mqq.intent.action.QQ_BACKGROUND");
      localIntentFilter.addAction("mqq.intent.action.QQ_FOREGROUND");
      try
      {
        registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
        bool = true;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          try
          {
            Object localObject1;
            QLog.e("ColorNoteSmallScreenService", 1, "previously registered, try again", localIllegalArgumentException);
            unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
            registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
            bool = true;
          }
          catch (Exception localException2)
          {
            QLog.e("ColorNoteSmallScreenService", 1, "try again failed", localException2);
            bool = false;
          }
        }
        if (!QLog.isColorLevel()) {
          break label349;
        }
        QLog.d("ColorNoteSmallScreenService", 2, "onCreate");
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout = ((ColorNoteSmallScreenRelativeLayout)((LayoutInflater)localObject2).inflate(2131558997, null));
        this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.findViewById(2131367269);
        this.jdField_a_of_type_AndroidViewView.bringToFront();
        this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new ColorNoteSmallScreenService.3(this));
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a();
        this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.findViewById(2131378261));
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenToast = new ColorNoteSmallScreenToast(this, this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout);
        Object localObject3 = "";
        Object localObject2 = localObject3;
        try
        {
          List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a();
          localObject2 = localObject3;
          this.jdField_a_of_type_Int = localList.size();
          localObject2 = localObject3;
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a(localList);
          localObject2 = localObject3;
          localObject3 = ColorNoteUtils.a(localList);
          localObject2 = localObject3;
          a(localList);
          localObject2 = localObject3;
        }
        catch (RuntimeException localRuntimeException)
        {
          for (;;)
          {
            int j;
            int k;
            int m;
            int n;
            int i;
            ColorNoteSmallScreenUtil.b(this);
            continue;
            this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839396);
            continue;
            if (j <= 0) {
              this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839397);
            } else {
              this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839399);
            }
          }
          ColorNoteRecentView.a(false);
        }
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setFloatListener(this);
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setUpcomingController(this);
        a(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenToast.a());
        localObject3 = SharedPreUtils.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        j = ((SharedPreferences)localObject3).getInt("colornote_windows_x", -1);
        k = ((SharedPreferences)localObject3).getInt("colornote_windows_y", -1);
        m = ViewUtils.a();
        n = ViewUtils.b();
        this.jdField_b_of_type_Int = AIOUtils.a(8.0F, getResources());
        if (((j == -1) && (k == -1)) || (j > m)) {
          break label629;
        }
        i = k;
        if (k <= n) {
          break label659;
        }
        i = ViewUtils.a();
        j = getResources().getDimensionPixelSize(2131296722);
        j = this.jdField_b_of_type_Int + (i - j);
        i = ViewUtils.b() / 2;
        if (!QLog.isColorLevel()) {
          break label761;
        }
        QLog.d("ColorNoteSmallScreenService", 2, "setCurPosition position = [" + j + ", " + i + "]");
        QLog.d("ColorNoteSmallScreenService", 2, "setCurPosition mScreenWidth = " + m);
        QLog.d("ColorNoteSmallScreenService", 2, "setCurPosition mScreenHeight = " + n);
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setCurPosition(new Point(j, i));
        ColorNoteSmallScreenUtil.a(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a() / 2 + j, i + this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.b() / 2);
        boolean bool = ColorNoteSmallScreenRelativeLayout.d();
        if ((!ThemeUtil.isNowThemeIsNight(null, false, null)) && (!bool)) {
          break label1063;
        }
        if (j > 0) {
          break label1050;
        }
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839394);
        localObject3 = String.format(getResources().getString(2131690970), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
        this.jdField_a_of_type_AndroidViewView.setContentDescription((String)localObject3 + (String)localObject2);
        AccessibilityUtil.a(this.jdField_a_of_type_AndroidViewView, true);
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenFullToast = new ColorNoteSmallScreenFullToast(this, this);
        if (this.jdField_b_of_type_JavaLangRunnable != null) {
          break label931;
        }
        this.jdField_b_of_type_JavaLangRunnable = new ColorNoteSmallScreenService.OnSelectMemberActivityIsResumeChangedRunnable(this);
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenSkinnableServiceProcesser = new SkinnableServiceProcesser(this, this);
        this.jdField_b_of_type_Boolean = false;
        this.d = ColorNoteSmallScreenUtil.a(this);
        f();
        if (this.jdField_a_of_type_JavaLangRunnable != null) {
          break label980;
        }
        this.jdField_a_of_type_JavaLangRunnable = new ColorNoteSmallScreenService.OnOpChangedRunnable(this);
        a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.f();
        ((ColorNoteHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.COLOR_NOTE_HANDLER)).a();
        localObject2 = ColorNoteRecentConfigProcessor.a();
        if ((localObject2 == null) || (!((ColorNoteRecentConfBean)localObject2).a())) {
          break label1093;
        }
        ColorNoteRecentView.a(true);
        return;
      }
      g();
      if ((!this.c) || (localLayoutInflater == null) || (!bool))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ColorNoteSmallScreenService", 2, "onCreate mIsOpEnable " + this.c + ", broadcast: " + bool);
        }
        ColorNoteSmallScreenUtil.b(this);
        return;
        ColorNoteSmallScreenUtil.b(this);
        return;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ColorNoteSmallScreenService", 2, "onCreate e = " + localException1);
        }
        localObject1 = null;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ColorNoteSmallScreenService", 2, "onCreate e = " + localOutOfMemoryError);
        }
        localObject2 = null;
      }
    }
    label349:
    label629:
    label761:
    return;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_b_of_type_Boolean = true;
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      h();
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenSkinnableServiceProcesser != null) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenSkinnableServiceProcesser.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenToast.a();
      }
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w("ColorNoteSmallScreenService", 1, "unregisterReceiver", localRuntimeException);
        }
      }
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if ((paramIntent != null) && (paramIntent.getIntExtra("KEY_CMD_SHOW_LIST", 0) == 1) && (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout != null))
    {
      a(paramIntent);
      a(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a(), paramIntent.getBooleanExtra("KEY_SHOW_LIST_LAND", true));
    }
    a(paramIntent, paramInt1, paramInt2);
    super.onStartCommand(paramIntent, paramInt1, paramInt2);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenService
 * JD-Core Version:    0.7.0.1
 */