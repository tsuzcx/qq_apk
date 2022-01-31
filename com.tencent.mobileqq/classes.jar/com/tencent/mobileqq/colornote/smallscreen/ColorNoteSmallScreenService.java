package com.tencent.mobileqq.colornote.smallscreen;

import aepi;
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
import aoca;
import aocd;
import aocm;
import aocn;
import aoco;
import aocp;
import aocq;
import aocr;
import aodl;
import aodw;
import aoeu;
import aoev;
import aofa;
import aofg;
import aofi;
import aofj;
import aofk;
import aofl;
import aofm;
import aofo;
import azqs;
import bczz;
import bdaq;
import bdne;
import bdoo;
import bnle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppService;
import mqq.os.MqqHandler;

public class ColorNoteSmallScreenService
  extends AppService
  implements aodw, aoeu, aofg, aofo
{
  public static boolean a;
  public int a;
  Application.ActivityLifecycleCallbacks jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks = new aofj(this);
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aofi(this);
  View jdField_a_of_type_AndroidViewView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private aodl jdField_a_of_type_Aodl;
  public aoev a;
  aofl jdField_a_of_type_Aofl;
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
      if (this.jdField_a_of_type_Aodl == null) {
        this.jdField_a_of_type_Aodl = new aodl(this, this);
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
      localObject = this.jdField_a_of_type_Aodl;
      if (j > 0) {
        break label191;
      }
    }
    label181:
    label191:
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((aodl)localObject).a(paramBoolean, i, this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.b() + i);
      localObject = this.jdField_a_of_type_Aodl.a();
      bnle.a(paramPoint);
      this.jdField_a_of_type_Aofl.a().addView((View)localObject, paramPoint);
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
    if (paramQQAppInterface == null) {
      return;
    }
    aofm.a(paramPoint.x + this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a() / 2, paramPoint.y + this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.b() / 2);
    paramQQAppInterface = bdne.a(this, paramQQAppInterface.c()).edit();
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
    this.jdField_a_of_type_Aofl.b();
  }
  
  public int a(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout)
  {
    return this.jdField_a_of_type_Aofl.a().x;
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
      if (this.jdField_a_of_type_Aodl != null) {
        this.jdField_a_of_type_Aofl.a().removeViewImmediate(this.jdField_a_of_type_Aodl.a());
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
    paramColorNoteSmallScreenRelativeLayout = this.jdField_a_of_type_Aofl;
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
    paramColorNoteSmallScreenRelativeLayout = this.jdField_a_of_type_Aofl;
    WindowManager.LayoutParams localLayoutParams = paramColorNoteSmallScreenRelativeLayout.a();
    LinearLayout.LayoutParams localLayoutParams1 = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
    float f1 = getResources().getDimensionPixelSize(2131298736);
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
          paramInt1 = getResources().getDimensionPixelSize(2131296592) / 2;
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
    azqs.b(null, "dc00898", "", "", "0X800A6C3", "0X800A6C3", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenFullToast.a();
    return true;
  }
  
  public boolean a(Point paramPoint, boolean paramBoolean)
  {
    a(paramPoint, paramBoolean);
    azqs.b(null, "dc00898", "", "", "0X800A6CB", "0X800A6CB", 0, 0, "", "", "", "");
    return true;
  }
  
  public int b(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout)
  {
    return this.jdField_a_of_type_Aofl.a().y;
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
      localLayoutParams.rightMargin = bdaq.a(getBaseContext(), 8.0F);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setShouldMaxRootView(false);
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.b();
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.e();
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.c();
      this.jdField_a_of_type_Aofl.b();
      return;
      localLayoutParams.leftMargin = bdaq.a(getBaseContext(), 8.0F);
    }
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.w("ColorNoteSmallScreenService", 1, "onDelClick");
    }
    aoco localaoco = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    azqs.b(null, "dc00898", "", "", "0X800A6C4", "0X800A6C4", 0, 0, localaoco.a() + "", "", "", "");
    Object localObject = localaoco.a(false);
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
      aoca.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
      aofm.b(this);
      QQToast.a(BaseApplication.getContext(), 0, "彩签已取消", 1).a();
      if (i != 0) {
        QQPlayerService.c(this);
      }
      ((Intent)localObject).putExtra("extra_can_add_colornote", localaoco.a());
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
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839083);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Aodl != null) {
        this.jdField_a_of_type_Aodl.b();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839085);
      continue;
      if (localPoint.x <= 0) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839086);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839088);
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
    for (boolean bool1 = aofa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());; bool1 = false)
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
          QLog.w("ColorNoteSmallScreenService", 1, "isColorNoteSmallScreenVisible = " + bool2 + ", isOpEnable = " + bool1 + ", mShouldShow = " + jdField_a_of_type_Boolean + ", mIsAppOnForeground = " + this.d + ", mIsNotInColorNoteList = " + this.e + ", Toast Isvisiable = " + this.jdField_a_of_type_Aofl.b());
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a();
          localObject2 = new Rect();
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.getWindowVisibleDisplayFrame((Rect)localObject2);
          QLog.w("ColorNoteSmallScreenService", 1, "mPosition[" + localObject1 + "], mScreenWidth[" + this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.c() + "], mScreenHeight[" + this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.d() + "], mWindowWidth[" + ((Rect)localObject2).width() + "], mWindowHeight[" + ((Rect)localObject2).height() + "]");
        }
        if (i == 0) {
          break label504;
        }
        if (!this.jdField_a_of_type_Aofl.b()) {
          this.jdField_a_of_type_Aofl.a();
        }
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        Object localObject1 = ((aoco)localObject2).a();
        ((aoco)localObject2).a(false);
        this.jdField_a_of_type_Int = ((List)localObject1).size();
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a((List)localObject1);
        if (QLog.isColorLevel()) {
          QLog.w("ColorNoteSmallScreenService", 1, "mVisiableCurrCount = " + this.jdField_a_of_type_Int + ", sumcount = " + ((aoco)localObject2).a());
        }
        if (this.jdField_a_of_type_Int <= 0) {
          break label492;
        }
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.d();
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setVisibility(0);
        localObject2 = String.format(getResources().getString(2131690903), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
        localObject1 = aocr.a((List)localObject1);
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
      ((QQAppInterface)this.app).addObserver(new aocn());
    }
    try
    {
      LayoutInflater localLayoutInflater = (LayoutInflater)getSystemService("layout_inflater");
      this.c = aofa.a(BaseApplicationImpl.getContext());
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
        aofm.b(this);
        return;
        aofm.b(this);
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
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout = ((ColorNoteSmallScreenRelativeLayout)((LayoutInflater)localObject2).inflate(2131558850, null));
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.findViewById(2131366618);
      this.jdField_a_of_type_AndroidViewView.bringToFront();
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new aofk(this));
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a();
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.findViewById(2131376846));
      this.jdField_a_of_type_Aofl = new aofl(this, this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout);
      if (this.jdField_a_of_type_Aoev == null) {
        this.jdField_a_of_type_Aoev = new aoev(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      Object localObject2 = "";
      try
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a();
        this.jdField_a_of_type_Int = ((List)localObject3).size();
        this.jdField_a_of_type_Aoev.a((List)localObject3);
        this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a((List)localObject3);
        localObject3 = aocr.a((List)localObject3);
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
          aofm.b(this);
          continue;
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839085);
          continue;
          if (j <= 0) {
            this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839086);
          } else {
            this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839088);
          }
        }
        aocd.a(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setFloatListener(this);
      a(this.jdField_a_of_type_Aofl.a());
      Object localObject3 = bdne.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      j = ((SharedPreferences)localObject3).getInt("colornote_windows_x", -1);
      k = ((SharedPreferences)localObject3).getInt("colornote_windows_y", -1);
      m = bdoo.a();
      n = bdoo.b();
      this.jdField_b_of_type_Int = aepi.a(8.0F, getResources());
      if (((j != -1) || (k != -1)) && (j <= m))
      {
        i = k;
        if (k <= n) {}
      }
      else
      {
        i = bdoo.a();
        j = getResources().getDimensionPixelSize(2131296592);
        j = this.jdField_b_of_type_Int + (i - j);
        i = bdoo.b() / 2;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("ColorNoteSmallScreenService", 2, "setCurPosition position = [" + j + ", " + i + "]");
        QLog.d("ColorNoteSmallScreenService", 2, "setCurPosition mScreenWidth = " + m);
        QLog.d("ColorNoteSmallScreenService", 2, "setCurPosition mScreenHeight = " + n);
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setCurPosition(new Point(j, i));
      aofm.a(this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.a() / 2 + j, i + this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.b() / 2);
      bool = ColorNoteSmallScreenRelativeLayout.d();
      if ((ThemeUtil.isNowThemeIsNight(null, false, null)) || (bool)) {
        if (j <= 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.setBackgroundResource(2130839083);
          localObject3 = String.format(getResources().getString(2131690903), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
          this.jdField_a_of_type_AndroidViewView.setContentDescription((String)localObject3 + (String)localObject2);
          bczz.a(this.jdField_a_of_type_AndroidViewView, true);
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenFullToast = new ColorNoteSmallScreenFullToast(this, this);
          if (this.jdField_b_of_type_JavaLangRunnable == null) {
            this.jdField_b_of_type_JavaLangRunnable = new ColorNoteSmallScreenService.OnSelectMemberActivityIsResumeChangedRunnable(this);
          }
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenSkinnableServiceProcesser = new SkinnableServiceProcesser(this, this);
          this.jdField_b_of_type_Boolean = false;
          this.d = aofm.a(this);
          f();
          if (this.jdField_a_of_type_JavaLangRunnable == null) {
            this.jdField_a_of_type_JavaLangRunnable = new ColorNoteSmallScreenService.OnOpChangedRunnable(this);
          }
          a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
          this.jdField_a_of_type_ComTencentMobileqqColornoteSmallscreenColorNoteSmallScreenRelativeLayout.f();
          ((aocm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(168)).a();
          localObject2 = aocq.a();
          if ((localObject2 == null) || (!((aocp)localObject2).a())) {
            break label1013;
          }
          aocd.a(true);
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
        this.jdField_a_of_type_Aofl.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenService
 * JD-Core Version:    0.7.0.1
 */