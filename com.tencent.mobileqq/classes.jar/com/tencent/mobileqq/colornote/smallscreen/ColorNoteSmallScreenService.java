package com.tencent.mobileqq.colornote.smallscreen;

import android.app.Application;
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
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.ColorNoteRecentView;
import com.tencent.mobileqq.colornote.api.IColorNoteDataService;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNoteRecentConfBean;
import com.tencent.mobileqq.colornote.data.ColorNoteRecentConfigProcessor;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.mobileqq.colornote.data.IColorNoteHelper;
import com.tencent.mobileqq.colornote.list.ColorNoteListController;
import com.tencent.mobileqq.colornote.list.OnListHideListener;
import com.tencent.mobileqq.music.api.IQQPlayer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.AccessibilityUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.AppService;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class ColorNoteSmallScreenService
  extends AppService
  implements OnListHideListener, ColorNoteSmallScreenFullToast.IColorNoteSmallScreenFullToastListener, ColorNoteSmallScreenRelativeLayout.FloatListener, IUpcomingController, SkinnableServiceProcesser.Callback
{
  private static ServiceLifecycleCallbacks<IColorNoteServiceLifecycleCallback> jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenServiceLifecycleCallbacks = new ServiceLifecycleCallbacks();
  static boolean jdField_a_of_type_Boolean = true;
  int jdField_a_of_type_Int;
  Application.ActivityLifecycleCallbacks jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks = new ColorNoteSmallScreenService.2(this);
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ColorNoteSmallScreenService.1(this);
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ColorNoteListController jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController;
  ColorNoteSmallScreenFullToast jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenFullToast;
  ColorNoteSmallScreenRelativeLayout jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout;
  ColorNoteSmallScreenToast jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenToast;
  SkinnableServiceProcesser jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenSkinnableServiceProcesser;
  private UpcomingNotifyState jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenUpcomingNotifyState = new UpcomingNotifyState(new ColorNoteSmallScreenService.4(this));
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
  
  static
  {
    try
    {
      Iterator localIterator = ColorNoteServiceLifecycleInjectUtil.a.iterator();
      while (localIterator.hasNext())
      {
        Class localClass = (Class)localIterator.next();
        jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenServiceLifecycleCallbacks.a((IServiceLifecycleCallback)localClass.newInstance());
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ColorNoteSmallScreenService", 1, "[static]", localException);
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if ((!QQTheme.a()) && (!paramBoolean))
    {
      if (paramInt <= 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839254);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839256);
      return;
    }
    if (paramInt <= 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839251);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839253);
  }
  
  private void a(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getIntExtra("key_upcoming_notify", -1) == 2))
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenUpcomingNotifyState.a();
      ReportController.b(null, "dc00898", "", "", "0X800AE85", "0X800AE85", 0, 0, "", "", "", "");
    }
  }
  
  private void a(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if ((paramIntent != null) && (paramIntent.getIntExtra("key_upcoming_notify", -1) == 2))
    {
      paramIntent = paramIntent.getSerializableExtra("key_upcoming_color_note");
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleOtherCommand() is called. colorNote = ");
        localStringBuilder.append(paramIntent);
        QLog.d("ColorNoteSmallScreenService", 2, localStringBuilder.toString());
      }
      if ((paramIntent instanceof ColorNote))
      {
        paramIntent = (ColorNote)paramIntent;
        if (paramIntent.getServiceType() == 17235968)
        {
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenUpcomingNotifyState.a();
          b(paramIntent);
          paramIntent = (IColorNoteDataService)this.app.getRuntimeService(IColorNoteDataService.class, "all");
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a(paramIntent.getVisiableColorNotes());
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.g();
        }
      }
    }
  }
  
  private void a(Point paramPoint, boolean paramBoolean)
  {
    int j;
    int i;
    if (paramBoolean)
    {
      j = paramPoint.x;
      i = paramPoint.y;
    }
    else
    {
      j = paramPoint.y;
      i = paramPoint.x;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController == null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController = new ColorNoteListController(this, this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController.a(b());
      return;
    }
    paramPoint = new WindowManager.LayoutParams();
    paramPoint.height = -1;
    paramPoint.width = -1;
    paramPoint.flags = 16777984;
    paramPoint.format = -3;
    paramPoint.windowAnimations = 0;
    if (Build.VERSION.SDK_INT >= 26) {
      paramPoint.type = 2038;
    } else {
      paramPoint.type = 2002;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController;
    AppRuntime localAppRuntime = this.app;
    if (j <= 0) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    ((ColorNoteListController)localObject).a(localAppRuntime, paramBoolean, i, this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.b() + i);
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
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenUpcomingNotifyState.b();
      return;
    }
    catch (Exception paramPoint)
    {
      QLog.e("ColorNoteSmallScreenService", 1, "[showList] error ", paramPoint);
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
  
  private void a(AppRuntime paramAppRuntime, Point paramPoint, int paramInt)
  {
    if (paramAppRuntime == null) {
      return;
    }
    ColorNoteSmallScreenUtil.a(paramPoint.x + this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a() / 2, paramPoint.y + this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.b() / 2);
    paramAppRuntime = ColorNoteSmallScreenUtil.a(this, paramAppRuntime.getCurrentUin()).edit();
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramAppRuntime.putBoolean("colornote_windows_land", bool);
    paramAppRuntime.putInt("colornote_windows_x", paramPoint.x);
    paramAppRuntime.putInt("colornote_windows_y", paramPoint.y);
    paramAppRuntime.apply();
    paramAppRuntime = new Intent();
    paramAppRuntime.setAction("key_float_window_position");
    paramAppRuntime.putExtra("key_float_window_position_x", paramPoint.x);
    paramAppRuntime.putExtra("key_float_window_position_y", paramPoint.y);
    sendBroadcast(paramAppRuntime);
  }
  
  public static void a(boolean paramBoolean, int paramInt)
  {
    jdField_a_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("from: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", should show: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("ColorNoteSmallScreenService", 2, localStringBuilder.toString());
    }
  }
  
  private List<ColorNote> b()
  {
    Object localObject2 = ((IColorNoteDataService)this.app.getRuntimeService(IColorNoteDataService.class, "all")).getVisiableColorNotes();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = null;
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new ArrayList();
    }
    return localObject2;
  }
  
  private void b(ColorNote paramColorNote)
  {
    if (paramColorNote != null)
    {
      if (paramColorNote.getServiceType() != 17235968) {
        return;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramColorNote);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("add note: ");
        localStringBuilder.append(paramColorNote.toString());
        QLog.d("ColorNoteSmallScreenService", 2, localStringBuilder.toString());
      }
      if (AppSetting.d)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131720130));
        localStringBuilder.append(ColorNoteUtils.a(paramColorNote));
        paramColorNote = localStringBuilder.toString();
        AccessibilityUtils.a(this.jdField_a_of_type_AndroidViewView, paramColorNote);
      }
    }
  }
  
  private boolean b()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_update_cn_smallscreen_state");
    localIntentFilter.addAction("mqq.intent.action.QQ_BACKGROUND");
    localIntentFilter.addAction("mqq.intent.action.QQ_FOREGROUND");
    try
    {
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return true;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      try
      {
        QLog.e("ColorNoteSmallScreenService", 1, "previously registered, try again", localIllegalArgumentException);
        unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
        return true;
      }
      catch (Exception localException)
      {
        QLog.e("ColorNoteSmallScreenService", 1, "try again failed", localException);
      }
    }
    return false;
  }
  
  private void g()
  {
    if (!this.g)
    {
      getApplication().registerActivityLifecycleCallbacks(this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
      this.g = true;
    }
  }
  
  private void h()
  {
    if (this.g)
    {
      getApplication().unregisterActivityLifecycleCallbacks(this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
      this.g = false;
    }
  }
  
  private void i()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.rightMargin = 0;
    localLayoutParams.leftMargin = 0;
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setShouldMaxRootView(false);
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.e();
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.c();
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenToast.b();
  }
  
  private void j()
  {
    Object localObject = new ArrayList(a());
    if (((List)localObject).size() != 0)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a((ColorNote)((Iterator)localObject).next());
      }
    }
    localObject = (IColorNoteDataService)this.app.getRuntimeService(IColorNoteDataService.class, "all");
    ((IColorNoteDataService)localObject).clearAllUpcomingMindFlag();
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a(((IColorNoteDataService)localObject).getVisiableColorNotes());
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenUpcomingNotifyState.a();
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
    a(this.app, paramPoint, paramInt);
  }
  
  public void a(ColorNote paramColorNote)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      ((List)localObject).remove(paramColorNote);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("remove note: ");
        ((StringBuilder)localObject).append(paramColorNote.toString());
        QLog.d("ColorNoteSmallScreenService", 2, ((StringBuilder)localObject).toString());
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenToast;
    paramColorNoteSmallScreenRelativeLayout = ((ColorNoteSmallScreenToast)localObject).a();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    float f1 = getResources().getDimensionPixelSize(2131298993);
    if (paramInt1 <= 0)
    {
      paramColorNoteSmallScreenRelativeLayout.x = paramInt1;
      paramColorNoteSmallScreenRelativeLayout.y = paramInt2;
      paramColorNoteSmallScreenRelativeLayout.width = (paramInt3 - paramInt1);
      paramColorNoteSmallScreenRelativeLayout.height = (paramInt4 - paramInt2);
      localLayoutParams.width = ((int)(f1 + paramInt5));
      ((ColorNoteSmallScreenToast)localObject).b();
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.c()) {
          paramInt1 = getResources().getDimensionPixelSize(2131296702) / 2;
        }
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenFullToast.a(paramInt3 - this.jdField_b_of_type_Int, paramInt2);
      }
    }
    else
    {
      paramColorNoteSmallScreenRelativeLayout.x = paramInt1;
      paramColorNoteSmallScreenRelativeLayout.y = paramInt2;
      paramColorNoteSmallScreenRelativeLayout.width = (paramInt3 - paramInt1);
      paramColorNoteSmallScreenRelativeLayout.height = (paramInt4 - paramInt2);
      localLayoutParams.width = ((int)(f1 * 2.0F));
      ((ColorNoteSmallScreenToast)localObject).b();
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenFullToast.a(this.jdField_b_of_type_Int + paramInt1, paramInt2);
      }
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("longpress width = ");
        ((StringBuilder)localObject).append(paramColorNoteSmallScreenRelativeLayout.width);
        ((StringBuilder)localObject).append(" left = ");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(", right = ");
        ((StringBuilder)localObject).append(paramInt3);
        ((StringBuilder)localObject).append("offset = ");
        ((StringBuilder)localObject).append(paramInt5);
        ((StringBuilder)localObject).append(", getMeasuredWidth = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.getMeasuredWidth());
        QLog.w("ColorNoteSmallScreenService", 1, ((StringBuilder)localObject).toString());
      }
    }
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
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenUpcomingNotifyState.b();
    ReportController.b(null, "dc00898", "", "", "0X800A6CB", "0X800A6CB", 0, 0, "", "", "", "");
    int i;
    if (ColorNoteUtils.a(this.jdField_a_of_type_JavaUtilList)) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A6CB", "0X800A6CB", i, 0, "", "", "", "");
    return true;
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
    }
    catch (RuntimeException localRuntimeException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ColorNoteSmallScreenService", 2, localRuntimeException, new Object[0]);
      }
    }
    this.e = true;
    if (QLog.isDevelopLevel()) {
      QLog.w("ColorNoteSmallScreenService", 1, "onHideList");
    }
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenUpcomingNotifyState.c();
    f();
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
    } else {
      localLayoutParams.leftMargin = DisplayUtil.a(getBaseContext(), 8.0F);
    }
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setShouldMaxRootView(false);
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.b();
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.e();
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.c();
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenToast.b();
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.w("ColorNoteSmallScreenService", 1, "onDelClick");
    }
    IColorNoteDataService localIColorNoteDataService = (IColorNoteDataService)this.app.getRuntimeService(IColorNoteDataService.class, "all");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(localIColorNoteDataService.getCurrentColorNoteCount());
    ((StringBuilder)localObject1).append("");
    ReportController.b(null, "dc00898", "", "", "0X800A6C4", "0X800A6C4", 0, 0, ((StringBuilder)localObject1).toString(), "", "", "");
    Object localObject2 = localIColorNoteDataService.getColorNotes(false);
    localObject1 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    int i = 0;
    while (((Iterator)localObject2).hasNext())
    {
      ColorNote localColorNote = (ColorNote)((Iterator)localObject2).next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localColorNote.getServiceType());
      localStringBuilder.append("");
      ((ArrayList)localObject1).add(localStringBuilder.toString());
      localArrayList.add(localColorNote.getSubType());
      if (localColorNote.getServiceType() == 16973824) {
        i = 1;
      }
    }
    localObject2 = new Intent("key_delete_item_call");
    ((Intent)localObject2).putStringArrayListExtra("key_color_note_servicetype_list", (ArrayList)localObject1);
    ((Intent)localObject2).putStringArrayListExtra("key_color_note_suptype_list", localArrayList);
    ((IColorNoteHelper)this.app.getRuntimeService(IColorNoteHelper.class, "all")).deleteAllColorNote(this.app, null);
    ColorNoteSmallScreenUtil.b(this);
    QQToast.a(BaseApplication.getContext(), 0, "彩签已取消", 1).a();
    if (i != 0) {
      ((IQQPlayer)QRoute.api(IQQPlayer.class)).stopPlayMusic(this);
    }
    ((Intent)localObject2).putExtra("extra_can_add_colornote", localIColorNoteDataService.canAddColorNote());
    sendBroadcast((Intent)localObject2);
  }
  
  public void e()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("ColorNoteSmallScreenService", 1, "onPostThemeChanged");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a();
    boolean bool = ColorNoteSmallScreenRelativeLayout.d();
    if ((!QQTheme.a()) && (!bool))
    {
      if (((Point)localObject).x <= 0) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839254);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839256);
      }
    }
    else if (((Point)localObject).x <= 0) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839251);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839253);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteListColorNoteListController;
    if (localObject != null) {
      ((ColorNoteListController)localObject).c();
    }
  }
  
  void f()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      boolean bool2 = ColorNoteSmallScreenPermissionUtil.a(this.app.getApp());
      boolean bool1;
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.getVisibility() == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      int i;
      if ((bool2) && (jdField_a_of_type_Boolean) && (this.d) && (this.e)) {
        i = 1;
      } else {
        i = 0;
      }
      Object localObject1;
      Object localObject2;
      Object localObject3;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("isColorNoteSmallScreenVisible = ");
        ((StringBuilder)localObject1).append(bool1);
        ((StringBuilder)localObject1).append(", isOpEnable = ");
        ((StringBuilder)localObject1).append(bool2);
        ((StringBuilder)localObject1).append(", mShouldShow = ");
        ((StringBuilder)localObject1).append(jdField_a_of_type_Boolean);
        ((StringBuilder)localObject1).append(", mIsAppOnForeground = ");
        ((StringBuilder)localObject1).append(this.d);
        ((StringBuilder)localObject1).append(", mIsNotInColorNoteList = ");
        ((StringBuilder)localObject1).append(this.e);
        ((StringBuilder)localObject1).append(", Toast Isvisiable = ");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenToast.b());
        QLog.w("ColorNoteSmallScreenService", 1, ((StringBuilder)localObject1).toString());
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a();
        localObject2 = new Rect();
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.getWindowVisibleDisplayFrame((Rect)localObject2);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("mPosition[");
        ((StringBuilder)localObject3).append(localObject1);
        ((StringBuilder)localObject3).append("], mScreenWidth[");
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.c());
        ((StringBuilder)localObject3).append("], mScreenHeight[");
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.d());
        ((StringBuilder)localObject3).append("], mWindowWidth[");
        ((StringBuilder)localObject3).append(((Rect)localObject2).width());
        ((StringBuilder)localObject3).append("], mWindowHeight[");
        ((StringBuilder)localObject3).append(((Rect)localObject2).height());
        ((StringBuilder)localObject3).append("]");
        QLog.w("ColorNoteSmallScreenService", 1, ((StringBuilder)localObject3).toString());
      }
      if (i != 0)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenToast.b()) {
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenToast.a();
        }
        localObject1 = (IColorNoteDataService)this.app.getRuntimeService(IColorNoteDataService.class, "all");
        localObject2 = ((IColorNoteDataService)localObject1).getVisiableColorNotes();
        this.jdField_a_of_type_Int = ((List)localObject2).size();
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a((List)localObject2);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("mVisiableCurrCount = ");
          ((StringBuilder)localObject3).append(this.jdField_a_of_type_Int);
          ((StringBuilder)localObject3).append(", sumcount = ");
          ((StringBuilder)localObject3).append(((IColorNoteDataService)localObject1).getCurrentColorNoteCount());
          QLog.w("ColorNoteSmallScreenService", 1, ((StringBuilder)localObject3).toString());
        }
        if (this.jdField_a_of_type_Int > 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.d();
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setVisibility(0);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setVisibility(8);
        }
        localObject1 = String.format(getResources().getString(2131690890), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
        localObject2 = ColorNoteUtils.a((List)localObject2);
        localObject3 = this.jdField_a_of_type_AndroidViewView;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append((String)localObject2);
        ((View)localObject3).setContentDescription(localStringBuilder.toString());
        return;
      }
      if (bool1)
      {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setVisibility(8);
        i();
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    Object localObject3;
    try
    {
      LayoutInflater localLayoutInflater = (LayoutInflater)getSystemService("layout_inflater");
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("onCreate e = ");
        ((StringBuilder)localObject3).append(localOutOfMemoryError);
        QLog.e("ColorNoteSmallScreenService", 2, ((StringBuilder)localObject3).toString());
      }
      Object localObject1 = null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("onCreate e = ");
          ((StringBuilder)localObject3).append(localException);
          QLog.e("ColorNoteSmallScreenService", 2, ((StringBuilder)localObject3).toString());
        }
      }
    }
    this.c = ColorNoteSmallScreenPermissionUtil.a(MobileQQ.getContext());
    boolean bool = b();
    g();
    if ((this.c) && (localException != null) && (bool))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteSmallScreenService", 2, "onCreate");
      }
      jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenServiceLifecycleCallbacks.a(this);
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout = ((ColorNoteSmallScreenRelativeLayout)localException.inflate(2131558892, null));
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.findViewById(2131367052);
      this.jdField_a_of_type_AndroidViewView.bringToFront();
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new ColorNoteSmallScreenService.3(this));
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a();
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.findViewById(2131377674));
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenToast = new ColorNoteSmallScreenToast(this, this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout);
    }
    try
    {
      localObject2 = ((IColorNoteDataService)this.app.getRuntimeService(IColorNoteDataService.class, "all")).getVisiableColorNotes();
      this.jdField_a_of_type_Int = ((List)localObject2).size();
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a((List)localObject2);
      localObject3 = ColorNoteUtils.a((List)localObject2);
      String str = String.format(getResources().getString(2131690890), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      View localView = this.jdField_a_of_type_AndroidViewView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append((String)localObject3);
      localView.setContentDescription(localStringBuilder.toString());
      AccessibilityUtil.a(this.jdField_a_of_type_AndroidViewView, true);
      if (!ColorNoteUtils.a((List)localObject2)) {
        break label421;
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenUpcomingNotifyState.a();
    }
    catch (RuntimeException localRuntimeException)
    {
      Object localObject2;
      label417:
      int j;
      int k;
      int m;
      int n;
      int i;
      break label417;
    }
    ColorNoteSmallScreenUtil.b(this);
    label421:
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setFloatListener(this);
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setUpcomingController(this);
    a(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenToast.a());
    localObject2 = ColorNoteSmallScreenUtil.a(this, this.app.getCurrentUin());
    j = ((SharedPreferences)localObject2).getInt("colornote_windows_x", -1);
    k = ((SharedPreferences)localObject2).getInt("colornote_windows_y", -1);
    m = ViewUtils.a();
    n = ViewUtils.b();
    this.jdField_b_of_type_Int = Utils.a(8.0F, getResources());
    if (((j != -1) || (k != -1)) && (j <= m))
    {
      i = k;
      if (k <= n) {}
    }
    else
    {
      j = ViewUtils.a() - getResources().getDimensionPixelSize(2131296702) + this.jdField_b_of_type_Int;
      i = ViewUtils.b() / 2;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("setCurPosition position = [");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append(", ");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("]");
      QLog.d("ColorNoteSmallScreenService", 2, ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("setCurPosition mScreenWidth = ");
      ((StringBuilder)localObject2).append(m);
      QLog.d("ColorNoteSmallScreenService", 2, ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("setCurPosition mScreenHeight = ");
      ((StringBuilder)localObject2).append(n);
      QLog.d("ColorNoteSmallScreenService", 2, ((StringBuilder)localObject2).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setCurPosition(new Point(j, i));
    ColorNoteSmallScreenUtil.a(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a() / 2 + j, i + this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.b() / 2);
    a(j, ColorNoteSmallScreenRelativeLayout.d());
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenFullToast = new ColorNoteSmallScreenFullToast(this, this);
    if (this.jdField_b_of_type_JavaLangRunnable == null) {
      this.jdField_b_of_type_JavaLangRunnable = new ColorNoteSmallScreenService.OnSelectMemberActivityIsResumeChangedRunnable(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenSkinnableServiceProcesser = new SkinnableServiceProcesser(this, this);
    this.jdField_b_of_type_Boolean = false;
    this.d = ColorNoteSmallScreenUtil.a(this);
    f();
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new ColorNoteSmallScreenService.OnOpChangedRunnable(this);
    }
    a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.f();
    localObject2 = ColorNoteRecentConfigProcessor.a();
    if ((localObject2 != null) && (((ColorNoteRecentConfBean)localObject2).a()))
    {
      ColorNoteRecentView.a(this.app, true);
      return;
    }
    ColorNoteRecentView.a(this.app, false);
    return;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onCreate mIsOpEnable ");
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append(", broadcast: ");
      ((StringBuilder)localObject2).append(bool);
      QLog.e("ColorNoteSmallScreenService", 2, ((StringBuilder)localObject2).toString());
    }
    ColorNoteSmallScreenUtil.b(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_b_of_type_Boolean = true;
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      h();
    }
    catch (RuntimeException localRuntimeException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("ColorNoteSmallScreenService", 1, "unregisterReceiver", localRuntimeException);
      }
    }
    SkinnableServiceProcesser localSkinnableServiceProcesser = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenSkinnableServiceProcesser;
    if (localSkinnableServiceProcesser != null) {
      localSkinnableServiceProcesser.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenToast.a();
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenService
 * JD-Core Version:    0.7.0.1
 */