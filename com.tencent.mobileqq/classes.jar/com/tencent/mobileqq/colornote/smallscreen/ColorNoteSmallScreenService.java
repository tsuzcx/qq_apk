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
  static boolean a = true;
  private static ServiceLifecycleCallbacks<IColorNoteServiceLifecycleCallback> u = new ServiceLifecycleCallbacks();
  boolean b = false;
  boolean c = true;
  boolean d = true;
  boolean e = true;
  boolean f = false;
  MqqHandler g;
  Runnable h = null;
  Runnable i = null;
  SkinnableServiceProcesser j;
  int k;
  int l;
  ColorNoteSmallScreenRelativeLayout m;
  ColorNoteSmallScreenToast n;
  LinearLayout o;
  ColorNoteSmallScreenFullToast p;
  View q;
  List<ColorNote> r = new ArrayList();
  boolean s = false;
  Application.ActivityLifecycleCallbacks t = new ColorNoteSmallScreenService.2(this);
  private ColorNoteListController v;
  private BroadcastReceiver w = new ColorNoteSmallScreenService.1(this);
  private UpcomingNotifyState x = new UpcomingNotifyState(new ColorNoteSmallScreenService.4(this));
  
  static
  {
    try
    {
      Iterator localIterator = ColorNoteServiceLifecycleInjectUtil.a.iterator();
      while (localIterator.hasNext())
      {
        Class localClass = (Class)localIterator.next();
        u.a((IServiceLifecycleCallback)localClass.newInstance());
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
    if ((!QQTheme.isNowThemeIsNight()) && (!paramBoolean))
    {
      if (paramInt <= 0)
      {
        this.m.setBackgroundResource(2130839426);
        return;
      }
      this.m.setBackgroundResource(2130839428);
      return;
    }
    if (paramInt <= 0)
    {
      this.m.setBackgroundResource(2130839423);
      return;
    }
    this.m.setBackgroundResource(2130839425);
  }
  
  private void a(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getIntExtra("key_upcoming_notify", -1) == 2))
    {
      this.x.a();
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
          this.x.a();
          b(paramIntent);
          paramIntent = (IColorNoteDataService)this.app.getRuntimeService(IColorNoteDataService.class, "all");
          this.m.a(paramIntent.getVisiableColorNotes());
          this.m.j();
        }
      }
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
    ColorNoteSmallScreenUtil.a(paramPoint.x + this.m.getToastWidth() / 2, paramPoint.y + this.m.getToastHeight() / 2);
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
    a = paramBoolean;
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
  
  private void b(Point paramPoint, boolean paramBoolean)
  {
    int i1 = paramPoint.x;
    int i2 = paramPoint.y;
    if (this.v == null) {
      this.v = new ColorNoteListController(this, this);
    }
    if (this.v.e())
    {
      this.v.a(n());
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
    Object localObject = this.v;
    AppRuntime localAppRuntime = this.app;
    if (i1 <= 0) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    ((ColorNoteListController)localObject).a(localAppRuntime, paramBoolean, i2, this.m.getToastHeight() + i2);
    localObject = this.v.a();
    try
    {
      this.n.f().addView((View)localObject, paramPoint);
      LiuHaiUtils.a(paramPoint);
      this.e = false;
      if (QLog.isDevelopLevel()) {
        QLog.w("ColorNoteSmallScreenService", 1, "showList");
      }
      h();
      this.x.b();
      return;
    }
    catch (Exception paramPoint)
    {
      QLog.e("ColorNoteSmallScreenService", 1, "[showList] error ", paramPoint);
    }
  }
  
  private void b(ColorNote paramColorNote)
  {
    if (paramColorNote != null)
    {
      if (paramColorNote.getServiceType() != 17235968) {
        return;
      }
      this.r.add(paramColorNote);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("add note: ");
        localStringBuilder.append(paramColorNote.toString());
        QLog.d("ColorNoteSmallScreenService", 2, localStringBuilder.toString());
      }
      if (AppSetting.e)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131917759));
        localStringBuilder.append(ColorNoteUtils.f(paramColorNote));
        paramColorNote = localStringBuilder.toString();
        AccessibilityUtils.a(this.q, paramColorNote);
      }
    }
  }
  
  private void k()
  {
    if (!this.s)
    {
      getApplication().registerActivityLifecycleCallbacks(this.t);
      this.s = true;
    }
  }
  
  private void l()
  {
    if (this.s)
    {
      getApplication().unregisterActivityLifecycleCallbacks(this.t);
      this.s = false;
    }
  }
  
  private boolean m()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("action_update_cn_smallscreen_state");
    localIntentFilter.addAction("mqq.intent.action.QQ_BACKGROUND");
    localIntentFilter.addAction("mqq.intent.action.QQ_FOREGROUND");
    try
    {
      registerReceiver(this.w, localIntentFilter);
      return true;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      try
      {
        QLog.e("ColorNoteSmallScreenService", 1, "previously registered, try again", localIllegalArgumentException);
        unregisterReceiver(this.w);
        registerReceiver(this.w, localIntentFilter);
        return true;
      }
      catch (Exception localException)
      {
        QLog.e("ColorNoteSmallScreenService", 1, "try again failed", localException);
      }
    }
    return false;
  }
  
  private List<ColorNote> n()
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
  
  private void o()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.o.getLayoutParams();
    localLayoutParams.rightMargin = 0;
    localLayoutParams.leftMargin = 0;
    this.m.setShouldMaxRootView(false);
    this.m.e();
    this.m.c();
    this.n.c();
  }
  
  private void p()
  {
    Object localObject = new ArrayList(j());
    if (((List)localObject).size() != 0)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        a((ColorNote)((Iterator)localObject).next());
      }
    }
    localObject = (IColorNoteDataService)this.app.getRuntimeService(IColorNoteDataService.class, "all");
    ((IColorNoteDataService)localObject).clearAllUpcomingMindFlag();
    this.m.a(((IColorNoteDataService)localObject).getVisiableColorNotes());
  }
  
  public int a(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout)
  {
    return this.n.e().x;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.w("ColorNoteSmallScreenService", 1, "onBackevent");
    }
    b();
  }
  
  public void a(Point paramPoint, int paramInt)
  {
    a(this.app, paramPoint, paramInt);
  }
  
  public void a(ColorNote paramColorNote)
  {
    Object localObject = this.r;
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
  
  public void a(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramColorNoteSmallScreenRelativeLayout = this.n;
    WindowManager.LayoutParams localLayoutParams = paramColorNoteSmallScreenRelativeLayout.e();
    localLayoutParams.x = paramInt1;
    localLayoutParams.y = paramInt2;
    localLayoutParams.width = (paramInt3 - paramInt1);
    localLayoutParams.height = (paramInt4 - paramInt2);
    localLayoutParams.windowAnimations = 0;
    paramColorNoteSmallScreenRelativeLayout.c();
  }
  
  public void a(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    Object localObject = this.n;
    paramColorNoteSmallScreenRelativeLayout = ((ColorNoteSmallScreenToast)localObject).e();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.o.getLayoutParams();
    float f1 = getResources().getDimensionPixelSize(2131299719);
    if (paramInt1 <= 0)
    {
      paramColorNoteSmallScreenRelativeLayout.x = paramInt1;
      paramColorNoteSmallScreenRelativeLayout.y = paramInt2;
      paramColorNoteSmallScreenRelativeLayout.width = (paramInt3 - paramInt1);
      paramColorNoteSmallScreenRelativeLayout.height = (paramInt4 - paramInt2);
      localLayoutParams.width = ((int)(f1 + paramInt5));
      ((ColorNoteSmallScreenToast)localObject).c();
      if (paramBoolean)
      {
        if (this.m.i()) {
          paramInt1 = getResources().getDimensionPixelSize(2131297033) / 2;
        }
        this.p.a(paramInt3 - this.l, paramInt2);
      }
    }
    else
    {
      paramColorNoteSmallScreenRelativeLayout.x = paramInt1;
      paramColorNoteSmallScreenRelativeLayout.y = paramInt2;
      paramColorNoteSmallScreenRelativeLayout.width = (paramInt3 - paramInt1);
      paramColorNoteSmallScreenRelativeLayout.height = (paramInt4 - paramInt2);
      localLayoutParams.width = ((int)(f1 * 2.0F));
      ((ColorNoteSmallScreenToast)localObject).c();
      if (paramBoolean) {
        this.p.a(this.l + paramInt1, paramInt2);
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
        ((StringBuilder)localObject).append(this.m.getMeasuredWidth());
        QLog.w("ColorNoteSmallScreenService", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public boolean a(Point paramPoint, boolean paramBoolean)
  {
    b(paramPoint, paramBoolean);
    this.x.b();
    ReportController.b(null, "dc00898", "", "", "0X800A6CB", "0X800A6CB", 0, 0, "", "", "", "");
    int i1;
    if (ColorNoteUtils.b(this.r)) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    ReportController.b(null, "dc00898", "", "", "0X800A6CB", "0X800A6CB", i1, 0, "", "", "", "");
    return true;
  }
  
  public int b(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout)
  {
    return this.n.e().y;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.w("ColorNoteSmallScreenService", 1, "onFullClick");
    }
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.o.getLayoutParams();
    localLayoutParams.rightMargin = 0;
    localLayoutParams.leftMargin = 0;
    if (this.m.g()) {
      localLayoutParams.rightMargin = DisplayUtil.a(getBaseContext(), 8.0F);
    } else {
      localLayoutParams.leftMargin = DisplayUtil.a(getBaseContext(), 8.0F);
    }
    this.m.setShouldMaxRootView(false);
    this.m.b();
    this.m.e();
    this.m.c();
    this.n.c();
  }
  
  public void c()
  {
    try
    {
      if (this.v != null)
      {
        this.v.a(false);
        this.n.f().removeViewImmediate(this.v.a());
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
    this.x.c();
    h();
  }
  
  public void c(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout) {}
  
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
    int i1 = 0;
    while (((Iterator)localObject2).hasNext())
    {
      ColorNote localColorNote = (ColorNote)((Iterator)localObject2).next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localColorNote.getServiceType());
      localStringBuilder.append("");
      ((ArrayList)localObject1).add(localStringBuilder.toString());
      localArrayList.add(localColorNote.getSubType());
      if (localColorNote.getServiceType() == 16973824) {
        i1 = 1;
      }
    }
    localObject2 = new Intent("key_delete_item_call");
    ((Intent)localObject2).putStringArrayListExtra("key_color_note_servicetype_list", (ArrayList)localObject1);
    ((Intent)localObject2).putStringArrayListExtra("key_color_note_suptype_list", localArrayList);
    ((IColorNoteHelper)this.app.getRuntimeService(IColorNoteHelper.class, "all")).deleteAllColorNote(this.app, null);
    ColorNoteSmallScreenUtil.b(this);
    QQToast.makeText(BaseApplication.getContext(), 0, "彩签已取消", 1).show();
    if (i1 != 0) {
      ((IQQPlayer)QRoute.api(IQQPlayer.class)).stopPlayMusic(this);
    }
    ((Intent)localObject2).putExtra("extra_can_add_colornote", localIColorNoteDataService.canAddColorNote());
    sendBroadcast((Intent)localObject2);
  }
  
  public boolean e()
  {
    if (QLog.isColorLevel()) {
      QLog.w("ColorNoteSmallScreenService", 1, "smallscreen longclick");
    }
    ReportController.b(null, "dc00898", "", "", "0X800A6C3", "0X800A6C3", 0, 0, "", "", "", "");
    this.p.a();
    return true;
  }
  
  public MqqHandler f()
  {
    if (this.g == null) {
      this.g = ThreadManager.getUIHandler();
    }
    return this.g;
  }
  
  public void g()
  {
    if (QLog.isDevelopLevel()) {
      QLog.w("ColorNoteSmallScreenService", 1, "onPostThemeChanged");
    }
    Object localObject = this.m.getCurPosition();
    boolean bool = ColorNoteSmallScreenRelativeLayout.getCustomNightMode();
    if ((!QQTheme.isNowThemeIsNight()) && (!bool))
    {
      if (((Point)localObject).x <= 0) {
        this.m.setBackgroundResource(2130839426);
      } else {
        this.m.setBackgroundResource(2130839428);
      }
    }
    else if (((Point)localObject).x <= 0) {
      this.m.setBackgroundResource(2130839423);
    } else {
      this.m.setBackgroundResource(2130839425);
    }
    localObject = this.v;
    if (localObject != null) {
      ((ColorNoteListController)localObject).d();
    }
  }
  
  void h()
  {
    if (!this.b)
    {
      boolean bool2 = ColorNoteSmallScreenPermissionUtil.a(this.app.getApp());
      boolean bool1;
      if (this.m.getVisibility() == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      int i1;
      if ((bool2) && (a) && (this.d) && (this.e)) {
        i1 = 1;
      } else {
        i1 = 0;
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
        ((StringBuilder)localObject1).append(a);
        ((StringBuilder)localObject1).append(", mIsAppOnForeground = ");
        ((StringBuilder)localObject1).append(this.d);
        ((StringBuilder)localObject1).append(", mIsNotInColorNoteList = ");
        ((StringBuilder)localObject1).append(this.e);
        ((StringBuilder)localObject1).append(", Toast Isvisiable = ");
        ((StringBuilder)localObject1).append(this.n.d());
        QLog.w("ColorNoteSmallScreenService", 1, ((StringBuilder)localObject1).toString());
        localObject1 = this.m.getCurPosition();
        localObject2 = new Rect();
        this.m.getWindowVisibleDisplayFrame((Rect)localObject2);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("mPosition[");
        ((StringBuilder)localObject3).append(localObject1);
        ((StringBuilder)localObject3).append("], mScreenWidth[");
        ((StringBuilder)localObject3).append(this.m.getScreenWidth());
        ((StringBuilder)localObject3).append("], mScreenHeight[");
        ((StringBuilder)localObject3).append(this.m.getScreenHeight());
        ((StringBuilder)localObject3).append("], mWindowWidth[");
        ((StringBuilder)localObject3).append(((Rect)localObject2).width());
        ((StringBuilder)localObject3).append("], mWindowHeight[");
        ((StringBuilder)localObject3).append(((Rect)localObject2).height());
        ((StringBuilder)localObject3).append("]");
        QLog.w("ColorNoteSmallScreenService", 1, ((StringBuilder)localObject3).toString());
      }
      if (i1 != 0)
      {
        if (!this.n.d()) {
          this.n.a();
        }
        localObject1 = (IColorNoteDataService)this.app.getRuntimeService(IColorNoteDataService.class, "all");
        localObject2 = ((IColorNoteDataService)localObject1).getVisiableColorNotes();
        this.k = ((List)localObject2).size();
        this.m.a((List)localObject2);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("mVisiableCurrCount = ");
          ((StringBuilder)localObject3).append(this.k);
          ((StringBuilder)localObject3).append(", sumcount = ");
          ((StringBuilder)localObject3).append(((IColorNoteDataService)localObject1).getCurrentColorNoteCount());
          QLog.w("ColorNoteSmallScreenService", 1, ((StringBuilder)localObject3).toString());
        }
        if (this.k > 0)
        {
          this.m.d();
          this.m.setVisibility(0);
        }
        else
        {
          this.m.setVisibility(8);
        }
        localObject1 = String.format(getResources().getString(2131887829), new Object[] { Integer.valueOf(this.k) });
        localObject2 = ColorNoteUtils.a((List)localObject2);
        localObject3 = this.q;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append((String)localObject2);
        ((View)localObject3).setContentDescription(localStringBuilder.toString());
        return;
      }
      if (bool1)
      {
        this.m.setVisibility(8);
        o();
      }
    }
  }
  
  public int i()
  {
    return this.x.d();
  }
  
  public List<ColorNote> j()
  {
    return this.r;
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
    boolean bool = m();
    k();
    if ((this.c) && (localException != null) && (bool))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteSmallScreenService", 2, "onCreate");
      }
      u.a(this);
      this.m = ((ColorNoteSmallScreenRelativeLayout)localException.inflate(2131624514, null));
      this.q = this.m.findViewById(2131433501);
      this.q.bringToFront();
      this.q.setOnTouchListener(new ColorNoteSmallScreenService.3(this));
      this.m.g();
      this.o = ((LinearLayout)this.m.findViewById(2131446099));
      this.n = new ColorNoteSmallScreenToast(this, this.m);
    }
    try
    {
      localObject2 = ((IColorNoteDataService)this.app.getRuntimeService(IColorNoteDataService.class, "all")).getVisiableColorNotes();
      this.k = ((List)localObject2).size();
      this.m.a((List)localObject2);
      localObject3 = ColorNoteUtils.a((List)localObject2);
      String str = String.format(getResources().getString(2131887829), new Object[] { Integer.valueOf(this.k) });
      View localView = this.q;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append((String)localObject3);
      localView.setContentDescription(localStringBuilder.toString());
      AccessibilityUtil.a(this.q, true);
      if (!ColorNoteUtils.b((List)localObject2)) {
        break label421;
      }
      this.x.a();
    }
    catch (RuntimeException localRuntimeException)
    {
      Object localObject2;
      label417:
      int i2;
      int i3;
      int i4;
      int i5;
      int i1;
      break label417;
    }
    ColorNoteSmallScreenUtil.b(this);
    label421:
    this.m.setFloatListener(this);
    this.m.setUpcomingController(this);
    a(this.n.e());
    localObject2 = ColorNoteSmallScreenUtil.a(this, this.app.getCurrentUin());
    i2 = ((SharedPreferences)localObject2).getInt("colornote_windows_x", -1);
    i3 = ((SharedPreferences)localObject2).getInt("colornote_windows_y", -1);
    i4 = ViewUtils.getScreenWidth();
    i5 = ViewUtils.getScreenHeight();
    this.l = Utils.a(8.0F, getResources());
    if (((i2 != -1) || (i3 != -1)) && (i2 <= i4))
    {
      i1 = i3;
      if (i3 <= i5) {}
    }
    else
    {
      i2 = ViewUtils.getScreenWidth() - getResources().getDimensionPixelSize(2131297033) + this.l;
      i1 = ViewUtils.getScreenHeight() / 2;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("setCurPosition position = [");
      ((StringBuilder)localObject2).append(i2);
      ((StringBuilder)localObject2).append(", ");
      ((StringBuilder)localObject2).append(i1);
      ((StringBuilder)localObject2).append("]");
      QLog.d("ColorNoteSmallScreenService", 2, ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("setCurPosition mScreenWidth = ");
      ((StringBuilder)localObject2).append(i4);
      QLog.d("ColorNoteSmallScreenService", 2, ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("setCurPosition mScreenHeight = ");
      ((StringBuilder)localObject2).append(i5);
      QLog.d("ColorNoteSmallScreenService", 2, ((StringBuilder)localObject2).toString());
    }
    this.m.setCurPosition(new Point(i2, i1));
    ColorNoteSmallScreenUtil.a(this.m.getToastWidth() / 2 + i2, i1 + this.m.getToastHeight() / 2);
    a(i2, ColorNoteSmallScreenRelativeLayout.getCustomNightMode());
    this.p = new ColorNoteSmallScreenFullToast(this, this);
    if (this.i == null) {
      this.i = new ColorNoteSmallScreenService.OnSelectMemberActivityIsResumeChangedRunnable(this);
    }
    this.j = new SkinnableServiceProcesser(this, this);
    this.b = false;
    this.d = ColorNoteSmallScreenUtil.c(this);
    h();
    if (this.h == null) {
      this.h = new ColorNoteSmallScreenService.OnOpChangedRunnable(this);
    }
    f().postDelayed(this.h, 1000L);
    this.m.f();
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
    this.b = true;
    try
    {
      unregisterReceiver(this.w);
      l();
    }
    catch (RuntimeException localRuntimeException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w("ColorNoteSmallScreenService", 1, "unregisterReceiver", localRuntimeException);
      }
    }
    SkinnableServiceProcesser localSkinnableServiceProcesser = this.j;
    if (localSkinnableServiceProcesser != null) {
      localSkinnableServiceProcesser.a();
    }
    if (this.m != null) {
      this.n.b();
    }
    if (this.h != null) {
      f().removeCallbacks(this.h);
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if ((paramIntent != null) && (paramIntent.getIntExtra("KEY_CMD_SHOW_LIST", 0) == 1) && (this.m != null))
    {
      a(paramIntent);
      b(this.m.getCurPosition(), paramIntent.getBooleanExtra("KEY_SHOW_LIST_LAND", true));
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