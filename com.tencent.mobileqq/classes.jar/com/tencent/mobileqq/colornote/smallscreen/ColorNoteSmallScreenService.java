package com.tencent.mobileqq.colornote.smallscreen;

import aciy;
import alrz;
import alsb;
import alsm;
import alsn;
import also;
import alsp;
import alsq;
import altj;
import altu;
import alua;
import alub;
import alui;
import aluk;
import alum;
import alun;
import aluo;
import alup;
import aluq;
import alus;
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
import awqx;
import azve;
import azvv;
import baig;
import bajq;
import bbmy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppService;
import mqq.os.MqqHandler;

public class ColorNoteSmallScreenService
  extends AppService
  implements altu, alua, aluk, alus
{
  public static boolean a;
  public int a;
  private altj jdField_a_of_type_Altj;
  public alub a;
  alup jdField_a_of_type_Alup;
  Application.ActivityLifecycleCallbacks jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks = new alun(this);
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new alum(this);
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  public QQAppInterface a;
  ColorNoteSmallScreenFullToast jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenFullToast;
  public ColorNoteSmallScreenRelativeLayout a;
  SkinnableServiceProcesser jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenSkinnableServiceProcesser;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  int jdField_b_of_type_Int;
  public Runnable b;
  boolean jdField_b_of_type_Boolean = false;
  boolean c = true;
  public boolean d = true;
  public boolean e = true;
  public boolean f = false;
  boolean g = false;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public ColorNoteSmallScreenService()
  {
    this.jdField_b_of_type_JavaLangRunnable = null;
  }
  
  private void a(Point paramPoint, boolean paramBoolean)
  {
    int j;
    int i;
    label85:
    Object localObject;
    if (paramBoolean)
    {
      j = paramPoint.x;
      i = paramPoint.y;
      if (this.jdField_a_of_type_Altj == null) {
        this.jdField_a_of_type_Altj = new altj(this, this);
      }
      paramPoint = new WindowManager.LayoutParams();
      paramPoint.height = -1;
      paramPoint.width = -1;
      paramPoint.flags = 16777984;
      paramPoint.format = -3;
      paramPoint.windowAnimations = 0;
      if (Build.VERSION.SDK_INT < 26) {
        break label176;
      }
      paramPoint.type = 2038;
      localObject = this.jdField_a_of_type_Altj;
      if (j > 0) {
        break label186;
      }
    }
    label176:
    label186:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((altj)localObject).a(paramBoolean, i, this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.b() + i);
      localObject = this.jdField_a_of_type_Altj.a();
      this.jdField_a_of_type_Alup.a().addView((View)localObject, paramPoint);
      this.e = false;
      if (QLog.isDevelopLevel()) {
        QLog.w("ColorNoteSmallScreenService", 1, "showList");
      }
      f();
      return;
      j = paramPoint.y;
      i = paramPoint.x;
      break;
      paramPoint.type = 2002;
      break label85;
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
    aluq.a(paramPoint.x + this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a() / 2, paramPoint.y + this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.b() / 2);
    paramQQAppInterface = baig.a(this, paramQQAppInterface.c()).edit();
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
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    localLayoutParams.rightMargin = 0;
    localLayoutParams.leftMargin = 0;
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setShouldMaxRootView(false);
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.d();
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.b();
    this.jdField_a_of_type_Alup.b();
  }
  
  public int a(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout)
  {
    return this.jdField_a_of_type_Alup.a().x;
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
    try
    {
      if (this.jdField_a_of_type_Altj != null) {
        this.jdField_a_of_type_Alup.a().removeViewImmediate(this.jdField_a_of_type_Altj.a());
      }
      this.e = true;
      if (QLog.isDevelopLevel()) {
        QLog.w("ColorNoteSmallScreenService", 1, "onHideList");
      }
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
  
  public void a(Point paramPoint, int paramInt)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramPoint, paramInt);
  }
  
  public void a(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout) {}
  
  public void a(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramColorNoteSmallScreenRelativeLayout = this.jdField_a_of_type_Alup;
    WindowManager.LayoutParams localLayoutParams = paramColorNoteSmallScreenRelativeLayout.a();
    localLayoutParams.x = paramInt1;
    localLayoutParams.y = paramInt2;
    localLayoutParams.width = (paramInt3 - paramInt1);
    localLayoutParams.height = (paramInt4 - paramInt2);
    paramColorNoteSmallScreenRelativeLayout.b();
  }
  
  public void a(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    paramColorNoteSmallScreenRelativeLayout = this.jdField_a_of_type_Alup;
    WindowManager.LayoutParams localLayoutParams = paramColorNoteSmallScreenRelativeLayout.a();
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    float f1 = getResources().getDimensionPixelSize(2131167609);
    if (paramInt1 <= 0)
    {
      localLayoutParams.x = paramInt1;
      localLayoutParams.y = paramInt2;
      localLayoutParams.width = (paramInt3 - paramInt1 + paramInt5);
      localLayoutParams.height = (paramInt4 - paramInt2);
      localLayoutParams1.width = ((int)(paramInt5 + f1));
      paramColorNoteSmallScreenRelativeLayout.b();
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.c()) {
          paramInt5 = getResources().getDimensionPixelSize(2131165504) / 2;
        }
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenFullToast.a(paramInt3 + paramInt5 - this.jdField_b_of_type_Int, paramInt2);
      }
    }
    do
    {
      return;
      localLayoutParams.x = (paramInt1 + paramInt5);
      localLayoutParams.y = paramInt2;
      localLayoutParams.width = (paramInt3 - paramInt1 - paramInt5);
      localLayoutParams.height = (paramInt4 - paramInt2);
      localLayoutParams1.width = ((int)(f1 - paramInt5));
      paramColorNoteSmallScreenRelativeLayout.b();
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenFullToast.a(paramInt1 + paramInt5 + this.jdField_b_of_type_Int, paramInt2);
      }
    } while (!QLog.isDevelopLevel());
    QLog.w("ColorNoteSmallScreenService", 1, "longpress width = " + localLayoutParams.width + " left = " + paramInt1 + ", right = " + paramInt3 + "offset = " + paramInt5 + ", getMeasuredWidth = " + this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.getMeasuredWidth());
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.w("ColorNoteSmallScreenService", 1, "smallscreen longclick");
    }
    awqx.b(null, "dc00898", "", "", "0X800A6C3", "0X800A6C3", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenFullToast.a();
    return true;
  }
  
  public boolean a(Point paramPoint, boolean paramBoolean)
  {
    a(paramPoint, paramBoolean);
    awqx.b(null, "dc00898", "", "", "0X800A6CB", "0X800A6CB", 0, 0, "", "", "", "");
    return true;
  }
  
  public int b(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout)
  {
    return this.jdField_a_of_type_Alup.a().y;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.w("ColorNoteSmallScreenService", 1, "onBackevent");
    }
    c();
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
      localLayoutParams.rightMargin = azvv.a(getBaseContext(), 8.0F);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setShouldMaxRootView(false);
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.d();
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.b();
      this.jdField_a_of_type_Alup.b();
      return;
      localLayoutParams.leftMargin = azvv.a(getBaseContext(), 8.0F);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.w("ColorNoteSmallScreenService", 1, "onDelClick");
    }
    also localalso = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    awqx.b(null, "dc00898", "", "", "0X800A6C4", "0X800A6C4", 0, 0, localalso.a() + "", "", "", "");
    Object localObject = localalso.a(false);
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
        break label280;
      }
      i = 1;
    }
    label280:
    for (;;)
    {
      break;
      localObject = new Intent("key_delete_item_call");
      ((Intent)localObject).putStringArrayListExtra("key_color_note_servicetype_list", localArrayList1);
      ((Intent)localObject).putStringArrayListExtra("key_color_note_suptype_list", localArrayList2);
      alrz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
      aluq.a(this);
      bbmy.a(BaseApplication.getContext(), 0, "彩签已取消", 1).a();
      if (i != 0) {
        QQPlayerService.c(this);
      }
      ((Intent)localObject).putExtra("extra_can_add_colornote", localalso.a());
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
    if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
      if (localPoint.x <= 0) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130838974);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Altj != null) {
        this.jdField_a_of_type_Altj.b();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130838976);
      continue;
      if (localPoint.x <= 0) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130838977);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130838979);
      }
    }
  }
  
  public void f()
  {
    if (!this.jdField_b_of_type_Boolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break label493;
      }
    }
    label63:
    label458:
    label463:
    label475:
    label493:
    for (boolean bool1 = alui.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());; bool1 = false)
    {
      boolean bool2;
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.getVisibility() == 0)
      {
        bool2 = true;
        if ((!bool1) || (!jdField_a_of_type_Boolean) || (!this.d) || (!this.e)) {
          break label458;
        }
        i = 1;
        if (QLog.isColorLevel())
        {
          QLog.w("ColorNoteSmallScreenService", 1, "isColorNoteSmallScreenVisible = " + bool2 + ", isOpEnable = " + bool1 + ", mShouldShow = " + jdField_a_of_type_Boolean + ", mIsAppOnForeground = " + this.d + ", mIsNotInColorNoteList = " + this.e + ", Toast Isvisiable = " + this.jdField_a_of_type_Alup.b());
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a();
          localObject2 = new Rect();
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.getWindowVisibleDisplayFrame((Rect)localObject2);
          QLog.w("ColorNoteSmallScreenService", 1, "mPosition[" + localObject1 + "], mScreenWidth[" + this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.c() + "], mScreenHeight[" + this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.d() + "], mWindowWidth[" + ((Rect)localObject2).width() + "], mWindowHeight[" + ((Rect)localObject2).height() + "]");
        }
        if (i == 0) {
          break label475;
        }
        if (!this.jdField_a_of_type_Alup.b()) {
          this.jdField_a_of_type_Alup.a();
        }
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        Object localObject2 = ((also)localObject1).a();
        ((also)localObject1).a(false);
        this.jdField_a_of_type_Int = ((List)localObject2).size();
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a((List)localObject2);
        if (QLog.isColorLevel()) {
          QLog.w("ColorNoteSmallScreenService", 1, "mVisiableCurrCount = " + this.jdField_a_of_type_Int + ", sumcount = " + ((also)localObject1).a());
        }
        if (this.jdField_a_of_type_Int <= 0) {
          break label463;
        }
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.c();
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setContentDescription(String.format(getResources().getString(2131625287), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
      }
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
      i();
      return;
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    if ((this.app != null) && ((this.app instanceof QQAppInterface)))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.app);
      ((QQAppInterface)this.app).addObserver(new alsn());
    }
    try
    {
      LayoutInflater localLayoutInflater = (LayoutInflater)getSystemService("layout_inflater");
      this.c = alui.a(BaseApplicationImpl.getContext());
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_update_cn_smallscreen_state");
      localIntentFilter.addAction("mqq.intent.action.QQ_BACKGROUND");
      localIntentFilter.addAction("mqq.intent.action.QQ_FOREGROUND");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      g();
      if ((!this.c) || (localLayoutInflater == null))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ColorNoteSmallScreenService", 2, "onCreate mIsOpEnable " + this.c);
        }
        aluq.a(this);
        return;
        aluq.a(this);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ColorNoteSmallScreenService", 2, "onCreate e = " + localException);
        }
        Object localObject1 = null;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Object localObject2;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ColorNoteSmallScreenService", 2, "onCreate e = " + localOutOfMemoryError);
        }
        localObject2 = null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteSmallScreenService", 2, "onCreate");
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout = ((ColorNoteSmallScreenRelativeLayout)((LayoutInflater)localObject2).inflate(2131493257, null));
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.findViewById(2131300895);
      this.jdField_a_of_type_AndroidViewView.bringToFront();
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new aluo(this));
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a();
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.findViewById(2131310495));
      this.jdField_a_of_type_Alup = new alup(this, this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout);
      if (this.jdField_a_of_type_Alub == null) {
        this.jdField_a_of_type_Alub = new alub(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      try
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
        this.jdField_a_of_type_Int = ((List)localObject2).size();
        this.jdField_a_of_type_Alub.a((List)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a((List)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setFloatListener(this);
        a(this.jdField_a_of_type_Alup.a());
        localObject2 = baig.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
        j = ((SharedPreferences)localObject2).getInt("colornote_windows_x", -1);
        int k = ((SharedPreferences)localObject2).getInt("colornote_windows_y", -1);
        int m = bajq.a();
        int n = bajq.b();
        this.jdField_b_of_type_Int = aciy.a(8.0F, getResources());
        int i;
        if (((j != -1) || (k != -1)) && (j <= m))
        {
          i = k;
          if (k <= n) {}
        }
        else
        {
          i = bajq.a();
          j = getResources().getDimensionPixelSize(2131165504);
          j = this.jdField_b_of_type_Int + (i - j);
          i = bajq.b() / 2;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("ColorNoteSmallScreenService", 2, "setCurPosition position = [" + j + ", " + i + "]");
          QLog.d("ColorNoteSmallScreenService", 2, "setCurPosition mScreenWidth = " + m);
          QLog.d("ColorNoteSmallScreenService", 2, "setCurPosition mScreenHeight = " + n);
        }
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setCurPosition(new Point(j, i));
        aluq.a(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a() / 2 + j, i + this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.b() / 2);
        if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
          if (j <= 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130838974);
            this.jdField_a_of_type_AndroidViewView.setContentDescription(String.format(getResources().getString(2131625287), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }));
            azve.a(this.jdField_a_of_type_AndroidViewView, true);
            this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenFullToast = new ColorNoteSmallScreenFullToast(this, this);
            if (this.jdField_b_of_type_JavaLangRunnable == null) {
              this.jdField_b_of_type_JavaLangRunnable = new ColorNoteSmallScreenService.OnSelectMemberActivityIsResumeChangedRunnable(this);
            }
            this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenSkinnableServiceProcesser = new SkinnableServiceProcesser(this, this);
            this.jdField_b_of_type_Boolean = false;
            this.d = aluq.a(this);
            f();
            if (this.jdField_a_of_type_JavaLangRunnable == null) {
              this.jdField_a_of_type_JavaLangRunnable = new ColorNoteSmallScreenService.OnOpChangedRunnable(this);
            }
            a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
            this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.e();
            ((alsm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(168)).a();
            localObject2 = alsq.a();
            if ((localObject2 == null) || (!((alsp)localObject2).a())) {
              break label965;
            }
            alsb.a(true);
            return;
          }
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        for (;;)
        {
          int j;
          aluq.a(this);
          continue;
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130838976);
          continue;
          if (j <= 0) {
            this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130838977);
          } else {
            this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130838979);
          }
        }
        label965:
        alsb.a(false);
      }
    }
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
        this.jdField_a_of_type_Alup.a();
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
    if ((paramIntent != null) && (paramIntent.getIntExtra("KEY_CMD_SHOW_LIST", 0) == 1) && (this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout != null)) {
      a(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a(), paramIntent.getBooleanExtra("KEY_SHOW_LIST_LAND", true));
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenService
 * JD-Core Version:    0.7.0.1
 */