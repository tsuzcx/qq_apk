package com.tencent.mobileqq.colornote.smallscreen;

import actn;
import amgs;
import amgu;
import amhd;
import amhe;
import amhf;
import amhg;
import amhh;
import amhi;
import amic;
import amin;
import amjl;
import amjm;
import amju;
import amka;
import amkc;
import amkd;
import amke;
import amkf;
import amkg;
import amki;
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
import axqw;
import bawi;
import bawz;
import bbjn;
import bbkx;
import bcpw;
import bkur;
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
  implements amin, amjl, amka, amki
{
  public static boolean a;
  public int a;
  private amic jdField_a_of_type_Amic;
  public amjm a;
  amkf jdField_a_of_type_Amkf;
  Application.ActivityLifecycleCallbacks jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks = new amkd(this);
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new amkc(this);
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
      if (this.jdField_a_of_type_Amic == null) {
        this.jdField_a_of_type_Amic = new amic(this, this);
      }
      paramPoint = new WindowManager.LayoutParams();
      paramPoint.height = -1;
      paramPoint.width = -1;
      paramPoint.flags = 16777984;
      paramPoint.format = -3;
      paramPoint.windowAnimations = 0;
      if (Build.VERSION.SDK_INT < 26) {
        break label181;
      }
      paramPoint.type = 2038;
      localObject = this.jdField_a_of_type_Amic;
      if (j > 0) {
        break label191;
      }
    }
    label181:
    label191:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((amic)localObject).a(paramBoolean, i, this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.b() + i);
      localObject = this.jdField_a_of_type_Amic.a();
      bkur.a(paramPoint);
      this.jdField_a_of_type_Amkf.a().addView((View)localObject, paramPoint);
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
    amkg.a(paramPoint.x + this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a() / 2, paramPoint.y + this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.b() / 2);
    paramQQAppInterface = bbjn.a(this, paramQQAppInterface.c()).edit();
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
  
  public static void a(boolean paramBoolean, int paramInt)
  {
    jdField_a_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("ColorNoteSmallScreenService", 2, "from: " + paramInt + ", should show: " + paramBoolean);
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
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.e();
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.c();
    this.jdField_a_of_type_Amkf.b();
  }
  
  public int a(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout)
  {
    return this.jdField_a_of_type_Amkf.a().x;
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
      if (this.jdField_a_of_type_Amic != null) {
        this.jdField_a_of_type_Amkf.a().removeViewImmediate(this.jdField_a_of_type_Amic.a());
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
    paramColorNoteSmallScreenRelativeLayout = this.jdField_a_of_type_Amkf;
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
    paramColorNoteSmallScreenRelativeLayout = this.jdField_a_of_type_Amkf;
    WindowManager.LayoutParams localLayoutParams = paramColorNoteSmallScreenRelativeLayout.a();
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    float f1 = getResources().getDimensionPixelSize(2131298708);
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
          paramInt1 = getResources().getDimensionPixelSize(2131296576) / 2;
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
    axqw.b(null, "dc00898", "", "", "0X800A6C3", "0X800A6C3", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenFullToast.a();
    return true;
  }
  
  public boolean a(Point paramPoint, boolean paramBoolean)
  {
    a(paramPoint, paramBoolean);
    axqw.b(null, "dc00898", "", "", "0X800A6CB", "0X800A6CB", 0, 0, "", "", "", "");
    return true;
  }
  
  public int b(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout)
  {
    return this.jdField_a_of_type_Amkf.a().y;
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
      localLayoutParams.rightMargin = bawz.a(getBaseContext(), 8.0F);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setShouldMaxRootView(false);
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.b();
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.e();
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.c();
      this.jdField_a_of_type_Amkf.b();
      return;
      localLayoutParams.leftMargin = bawz.a(getBaseContext(), 8.0F);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.w("ColorNoteSmallScreenService", 1, "onDelClick");
    }
    amhf localamhf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    axqw.b(null, "dc00898", "", "", "0X800A6C4", "0X800A6C4", 0, 0, localamhf.a() + "", "", "", "");
    Object localObject = localamhf.a(false);
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
      amgs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
      amkg.b(this);
      bcpw.a(BaseApplication.getContext(), 0, "彩签已取消", 1).a();
      if (i != 0) {
        QQPlayerService.c(this);
      }
      ((Intent)localObject).putExtra("extra_can_add_colornote", localamhf.a());
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
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839002);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Amic != null) {
        this.jdField_a_of_type_Amic.b();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839004);
      continue;
      if (localPoint.x <= 0) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839005);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839007);
      }
    }
  }
  
  public void f()
  {
    if (!this.jdField_b_of_type_Boolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break label522;
      }
    }
    label522:
    for (boolean bool1 = amju.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());; bool1 = false)
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
          QLog.w("ColorNoteSmallScreenService", 1, "isColorNoteSmallScreenVisible = " + bool2 + ", isOpEnable = " + bool1 + ", mShouldShow = " + jdField_a_of_type_Boolean + ", mIsAppOnForeground = " + this.d + ", mIsNotInColorNoteList = " + this.e + ", Toast Isvisiable = " + this.jdField_a_of_type_Amkf.b());
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a();
          localObject2 = new Rect();
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.getWindowVisibleDisplayFrame((Rect)localObject2);
          QLog.w("ColorNoteSmallScreenService", 1, "mPosition[" + localObject1 + "], mScreenWidth[" + this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.c() + "], mScreenHeight[" + this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.d() + "], mWindowWidth[" + ((Rect)localObject2).width() + "], mWindowHeight[" + ((Rect)localObject2).height() + "]");
        }
        if (i == 0) {
          break label504;
        }
        if (!this.jdField_a_of_type_Amkf.b()) {
          this.jdField_a_of_type_Amkf.a();
        }
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        Object localObject1 = ((amhf)localObject2).a();
        ((amhf)localObject2).a(false);
        this.jdField_a_of_type_Int = ((List)localObject1).size();
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a((List)localObject1);
        if (QLog.isColorLevel()) {
          QLog.w("ColorNoteSmallScreenService", 1, "mVisiableCurrCount = " + this.jdField_a_of_type_Int + ", sumcount = " + ((amhf)localObject2).a());
        }
        if (this.jdField_a_of_type_Int <= 0) {
          break label492;
        }
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.d();
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setVisibility(0);
        localObject2 = String.format(getResources().getString(2131690850), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
        localObject1 = amhi.a((List)localObject1);
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
      ((QQAppInterface)this.app).addObserver(new amhe());
    }
    try
    {
      LayoutInflater localLayoutInflater = (LayoutInflater)getSystemService("layout_inflater");
      this.c = amju.a(BaseApplicationImpl.getContext());
      localObject3 = new IntentFilter();
      ((IntentFilter)localObject3).addAction("action_update_cn_smallscreen_state");
      ((IntentFilter)localObject3).addAction("mqq.intent.action.QQ_BACKGROUND");
      ((IntentFilter)localObject3).addAction("mqq.intent.action.QQ_FOREGROUND");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject3);
      g();
      if ((!this.c) || (localLayoutInflater == null))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ColorNoteSmallScreenService", 2, "onCreate mIsOpEnable " + this.c);
        }
        amkg.b(this);
        return;
        amkg.b(this);
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
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout = ((ColorNoteSmallScreenRelativeLayout)((LayoutInflater)localObject2).inflate(2131558815, null));
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.findViewById(2131366504);
      this.jdField_a_of_type_AndroidViewView.bringToFront();
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new amke(this));
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a();
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.findViewById(2131376287));
      this.jdField_a_of_type_Amkf = new amkf(this, this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout);
      if (this.jdField_a_of_type_Amjm == null) {
        this.jdField_a_of_type_Amjm = new amjm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      Object localObject2 = "";
      try
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
        this.jdField_a_of_type_Int = ((List)localObject3).size();
        this.jdField_a_of_type_Amjm.a((List)localObject3);
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a((List)localObject3);
        localObject3 = amhi.a((List)localObject3);
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
          boolean bool;
          amkg.b(this);
          continue;
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839004);
          continue;
          if (j <= 0) {
            this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839005);
          } else {
            this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839007);
          }
        }
        amgu.a(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setFloatListener(this);
      a(this.jdField_a_of_type_Amkf.a());
      Object localObject3 = bbjn.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      j = ((SharedPreferences)localObject3).getInt("colornote_windows_x", -1);
      k = ((SharedPreferences)localObject3).getInt("colornote_windows_y", -1);
      m = bbkx.a();
      n = bbkx.b();
      this.jdField_b_of_type_Int = actn.a(8.0F, getResources());
      if (((j != -1) || (k != -1)) && (j <= m))
      {
        i = k;
        if (k <= n) {}
      }
      else
      {
        i = bbkx.a();
        j = getResources().getDimensionPixelSize(2131296576);
        j = this.jdField_b_of_type_Int + (i - j);
        i = bbkx.b() / 2;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("ColorNoteSmallScreenService", 2, "setCurPosition position = [" + j + ", " + i + "]");
        QLog.d("ColorNoteSmallScreenService", 2, "setCurPosition mScreenWidth = " + m);
        QLog.d("ColorNoteSmallScreenService", 2, "setCurPosition mScreenHeight = " + n);
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setCurPosition(new Point(j, i));
      amkg.a(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a() / 2 + j, i + this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.b() / 2);
      bool = ColorNoteSmallScreenRelativeLayout.d();
      if ((ThemeUtil.isNowThemeIsNight(null, false, null)) || (bool)) {
        if (j <= 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839002);
          localObject3 = String.format(getResources().getString(2131690850), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
          this.jdField_a_of_type_AndroidViewView.setContentDescription((String)localObject3 + (String)localObject2);
          bawi.a(this.jdField_a_of_type_AndroidViewView, true);
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenFullToast = new ColorNoteSmallScreenFullToast(this, this);
          if (this.jdField_b_of_type_JavaLangRunnable == null) {
            this.jdField_b_of_type_JavaLangRunnable = new ColorNoteSmallScreenService.OnSelectMemberActivityIsResumeChangedRunnable(this);
          }
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenSkinnableServiceProcesser = new SkinnableServiceProcesser(this, this);
          this.jdField_b_of_type_Boolean = false;
          this.d = amkg.a(this);
          f();
          if (this.jdField_a_of_type_JavaLangRunnable == null) {
            this.jdField_a_of_type_JavaLangRunnable = new ColorNoteSmallScreenService.OnOpChangedRunnable(this);
          }
          a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.f();
          ((amhd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(168)).a();
          localObject2 = amhh.a();
          if ((localObject2 == null) || (!((amhg)localObject2).a())) {
            break label1013;
          }
          amgu.a(true);
          return;
        }
      }
    }
    label1013:
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
        this.jdField_a_of_type_Amkf.a();
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