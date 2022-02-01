package com.tencent.mobileqq.filemanager.fileviewer;

import Override;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anvx;
import aqnr;
import atpj;
import atsy;
import atsz;
import atta;
import attb;
import attc;
import attd;
import atth;
import atut;
import atuv;
import atuw;
import atux;
import audy;
import auea;
import aufd;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanageraux.fileviewer.FileView.TdsReaderGlobal;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.lang.reflect.Method;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class FileBrowserActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, atuw
{
  protected int a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aqnr jdField_a_of_type_Aqnr;
  public attd a;
  private atth jdField_a_of_type_Atth;
  private atuv jdField_a_of_type_Atuv;
  atux jdField_a_of_type_Atux = new atta(this);
  private DynamicAvatarView jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView;
  ForwardFileInfo jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo;
  private AvatarLayout jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  private long[] jdField_a_of_type_ArrayOfLong = new long[5];
  private int jdField_b_of_type_Int;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public FileBrowserActivity()
  {
    this.jdField_a_of_type_Int = 10000;
  }
  
  private void a(Object paramObject, String paramString, attc... paramVarArgs)
  {
    int i = 0;
    if (paramObject == null) {
      return;
    }
    if (paramVarArgs == null) {}
    try
    {
      Class[] arrayOfClass = new Class[0];
      if (paramVarArgs == null) {}
      for (Object[] arrayOfObject = new Object[0];; arrayOfObject = new Object[paramVarArgs.length])
      {
        if (paramVarArgs == null) {
          break label97;
        }
        int j = arrayOfClass.length;
        while (i < j)
        {
          arrayOfClass[i] = paramVarArgs[i].a();
          arrayOfObject[i] = paramVarArgs[i].a();
          i += 1;
        }
        arrayOfClass = new Class[paramVarArgs.length];
        break;
      }
      label97:
      paramString = paramObject.getClass().getDeclaredMethod(paramString, arrayOfClass);
      paramString.setAccessible(true);
      paramString.invoke(paramObject, arrayOfObject);
      return;
    }
    catch (Throwable paramObject) {}
  }
  
  private void f()
  {
    this.jdField_a_of_type_Aqnr = new aqnr(this, true, true);
    this.jdField_a_of_type_Aqnr.a(this.jdField_a_of_type_Attd.a());
    this.jdField_a_of_type_Aqnr.a(this);
    this.jdField_a_of_type_Aqnr.a(new atsy(this));
    boolean bool = this.jdField_a_of_type_Attd.d();
    if (!bool) {
      this.jdField_a_of_type_Aqnr.g();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserActivity<FileAssistant>", 2, "initColorNoteController: checkShowFileColorNote[" + bool + "]");
      }
      return;
      this.jdField_a_of_type_Aqnr.h();
    }
  }
  
  private void h()
  {
    boolean bool;
    if (this.jdField_a_of_type_Aqnr != null)
    {
      this.jdField_a_of_type_Aqnr.a(this.jdField_a_of_type_Attd.a());
      bool = this.jdField_a_of_type_Attd.d();
      if (bool) {
        break label77;
      }
      this.jdField_a_of_type_Aqnr.g();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserActivity<FileAssistant>", 2, "updateColorNoteController: checkShowFileColorNote[" + bool + "]");
      }
      return;
      label77:
      this.jdField_a_of_type_Aqnr.h();
    }
  }
  
  private boolean h()
  {
    return (this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 2) || (this.jdField_b_of_type_Int == 5) || (this.jdField_b_of_type_Int == 6) || (this.jdField_b_of_type_Int == 3) || (this.jdField_b_of_type_Int == 13) || (this.jdField_b_of_type_Int == 4);
  }
  
  private void i()
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(null, new atsz(this, getResources().getDisplayMetrics().widthPixels / 6));
    this.jdField_a_of_type_AndroidViewGestureDetector.setIsLongpressEnabled(false);
  }
  
  private void j()
  {
    RelativeLayout localRelativeLayout = a();
    if (localRelativeLayout == null) {
      return;
    }
    a(localRelativeLayout.getParent(), "clearChildFocus", new attc[] { new attc(localRelativeLayout, View.class) });
  }
  
  private void k()
  {
    Object localObject;
    if (this.jdField_a_of_type_Attd != null)
    {
      localObject = this.jdField_a_of_type_Attd.a();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.i("FileBrowserActivity<FileAssistant>", 1, "updateTitleBar,but file name is empty.");
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.post(new FileBrowserActivity.4(this, (String)localObject));
    }
    int i = aufd.a(this.jdField_b_of_type_Int);
    if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (i != -1) && (h()) && (this.jdField_a_of_type_Attd.a()))
    {
      this.jdField_a_of_type_Atth = new atth(this.app, this.jdField_b_of_type_JavaLangString);
      localObject = (ImageView)findViewById(2131368105);
      this.jdField_a_of_type_Atth.a((View)localObject);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView, false);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, aufd.a(this.app, i, this.jdField_b_of_type_JavaLangString), this.jdField_b_of_type_JavaLangString));
    }
    while (this.jdField_a_of_type_Attd.f())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void l()
  {
    if (!h()) {}
    String str;
    int i;
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (this.jdField_b_of_type_Int == 0));
      str = this.jdField_b_of_type_JavaLangString;
      i = aufd.a(this.jdField_b_of_type_Int);
    } while (i == -1);
    if (this.jdField_a_of_type_Atth != null) {
      this.jdField_a_of_type_Atth.a();
    }
    MiniChatActivity.a(this, i, str, ContactUtils.getNickName(this.app, str, i));
  }
  
  private void m()
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileBrowserActivity<FileAssistant>", 2, "registerQlinkFinishFMReceiver");
      }
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null)
      {
        this.jdField_a_of_type_AndroidContentBroadcastReceiver = new attb(this);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.qlink.destory.fmactivity");
        this.app.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      }
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      this.app.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  public int a()
  {
    return getTitleBarHeight();
  }
  
  public RelativeLayout a()
  {
    return (RelativeLayout)findViewById(2131366760);
  }
  
  public QQAppInterface a()
  {
    return this.app;
  }
  
  public ForwardFileInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo;
  }
  
  public void a()
  {
    if (isFinishing()) {
      return;
    }
    ThreadManager.getUIHandler().post(new FileBrowserActivity.3(this));
  }
  
  public void a(int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131361941);
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      return;
    }
  }
  
  public boolean a()
  {
    boolean bool = false;
    if ((getIntent().getBooleanExtra("from_qlink", false)) || (getIntent().getBooleanExtra("from_qlink_enter_recent", false))) {
      bool = true;
    }
    return bool;
  }
  
  @TargetApi(14)
  protected boolean a(Intent paramIntent)
  {
    atut localatut = new atut(this.app);
    if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.trim().length() != 0)) {
      localatut.a(this.jdField_a_of_type_JavaLangString);
    }
    if (!localatut.a(paramIntent)) {}
    do
    {
      return false;
      int i = paramIntent.getIntExtra("file_enter_file_browser_type", 0);
      if (this.jdField_a_of_type_Attd == null)
      {
        this.jdField_a_of_type_Attd = new attd(this, this, localatut.a(this));
        this.jdField_a_of_type_Attd.a(this.jdField_a_of_type_Atux);
      }
      paramIntent = paramIntent.getBundleExtra("file_browser_extra_params");
      if (this.jdField_a_of_type_Attd.a(a(), new RelativeLayout.LayoutParams(-1, -1), i, paramIntent)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("FileBrowserActivity<FileAssistant>", 2, "error. can not create a fileviewer from FileBrowserManager");
    return false;
    if (this.jdField_a_of_type_Attd.b()) {
      setRequestedOrientation(1);
    }
    return true;
  }
  
  public void b()
  {
    finish();
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Attd == null)
    {
      QLog.e("FileBrowserActivity<FileAssistant>", 1, "updateMenu but mFileBrowserManager is null!");
      return;
    }
    this.jdField_a_of_type_Attd.b();
    if (this.jdField_a_of_type_Attd.f())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Attd != null) {
      this.jdField_a_of_type_Attd.a();
    }
  }
  
  public boolean d()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Aqnr != null)
    {
      bool1 = bool2;
      if (!this.jdField_a_of_type_Aqnr.c())
      {
        if (!this.jdField_a_of_type_Aqnr.b()) {
          break label44;
        }
        this.jdField_a_of_type_Aqnr.e();
        bool1 = true;
      }
    }
    return bool1;
    label44:
    this.jdField_a_of_type_Aqnr.i();
    return false;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "FileBrowserAct doOnActivityResult resultCode=" + paramInt2 + "mForwardType=" + this.jdField_a_of_type_Int);
    }
    if (paramInt2 == 4)
    {
      if (this.jdField_a_of_type_Atuv == null)
      {
        this.jdField_a_of_type_Atuv = new atuv();
        this.jdField_a_of_type_Atuv.a(getIntent());
      }
      if ((this.jdField_a_of_type_Atuv.a()) && (paramIntent != null) && (paramIntent.getExtras() != null))
      {
        Intent localIntent = AIOUtils.setOpenAIOIntent(new Intent(this, SplashActivity.class), new int[] { 2 });
        localIntent.putExtras(new Bundle(paramIntent.getExtras()));
        startActivity(localIntent);
      }
      setResult(4, paramIntent);
      finish();
      return;
    }
    if (paramInt1 == 14002)
    {
      QLog.d("FileBrowserActivity<FileAssistant>", 2, "FileBrowserAct finish for doc mini program ");
      finish();
      return;
    }
    if (this.jdField_a_of_type_Attd != null) {
      this.jdField_a_of_type_Attd.a(paramInt1, paramInt2, paramIntent);
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if (this.jdField_a_of_type_Attd != null)
    {
      this.jdField_a_of_type_Attd.a(paramConfiguration);
      if (this.jdField_a_of_type_Attd.b())
      {
        setRequestedOrientation(-1);
        if (this.jdField_a_of_type_Boolean) {
          break label50;
        }
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  @TargetApi(14)
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    LiuHaiUtils.enableNotch(this);
    TdsReaderGlobal.a();
    paramBundle = getIntent();
    this.jdField_b_of_type_Int = paramBundle.getIntExtra("file_enter_file_browser_type", 0);
    String str = atpj.a(this.app.getApplication().getBaseContext(), "OnlinePreView", "RotateScreen", "FunctionalSwitch");
    if (str != null) {}
    Object localObject;
    try
    {
      i = Integer.parseInt(str);
      if (1 == i) {
        setRequestedOrientation(-1);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo = ((ForwardFileInfo)paramBundle.getParcelableExtra("fileinfo"));
      this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("c2c_discussion_recentfile");
      this.jdField_b_of_type_JavaLangString = paramBundle.getStringExtra("file_browser_extra_params_uin");
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo == null)
      {
        finish();
        return false;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("FileBrowserActivity<FileAssistant>", 4, "can not format FMConfig value to integer");
        }
        i = 0;
      }
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo.b();
      if (10004 == this.jdField_a_of_type_Int)
      {
        this.jdField_c_of_type_Boolean = true;
        audy.a("0X8004BB3");
      }
      for (;;)
      {
        if (paramBundle.getBooleanExtra("_from_aio_", false)) {
          this.jdField_c_of_type_Boolean = true;
        }
        if (paramBundle.getBooleanExtra("key_is_from_lite", false)) {
          this.d = true;
        }
        LiuHaiUtils.a(this);
        setContentViewNoTitle(2131560870);
        e();
        if (a(paramBundle)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.i("FileBrowserActivity<FileAssistant>", 2, "create FileBrowserView failed");
        }
        finish();
        return false;
        audy.a("0X8004BC8");
      }
      this.jdField_c_of_type_Int = this.jdField_a_of_type_Attd.a();
      f();
      k();
      audy.a("0X8004C01");
      m();
      i();
      localObject = getResources().getConfiguration().toString();
      if (((String)localObject).contains("hwMultiwindow-magic")) {
        break label324;
      }
    }
    if (((String)localObject).contains("hw-magic-windows")) {}
    label324:
    for (int i = 1;; i = 0)
    {
      if ((ImmersiveUtils.isSupporImmersive() == 1) && (i == 0))
      {
        localObject = (RelativeLayout)findViewById(2131376948);
        ((RelativeLayout)localObject).setFitsSystemWindows(true);
        ((RelativeLayout)localObject).setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
      if (!auea.a())
      {
        localObject = new Intent(this, WebProcessReceiver.class);
        ((Intent)localObject).setAction("action_download_tbs");
        sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
      }
      init(paramBundle);
      if (Build.VERSION.SDK_INT <= 11) {
        removeWebViewLayerType();
      }
      return true;
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if ((QLog.isColorLevel()) && (!isFinishing())) {
      QLog.i("FileBrowserActivity<FileAssistant>", 2, "FileBrowserActivity is called doOnDestroy But not finished!");
    }
    j();
    n();
    if (this.jdField_a_of_type_Aqnr != null)
    {
      if (this.jdField_a_of_type_Attd.d()) {
        this.jdField_a_of_type_Aqnr.p();
      }
      this.jdField_a_of_type_Aqnr.c();
    }
    if (this.jdField_a_of_type_Attd != null) {
      this.jdField_a_of_type_Attd.f();
    }
    if (this.jdField_a_of_type_Atth != null) {
      this.jdField_a_of_type_Atth.d();
    }
  }
  
  public void doOnPause()
  {
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    if (this.jdField_a_of_type_Attd != null) {
      this.jdField_a_of_type_Attd.d();
    }
    if (this.jdField_a_of_type_Atth != null) {
      this.jdField_a_of_type_Atth.c();
    }
    if (this.jdField_a_of_type_Aqnr != null) {
      this.jdField_a_of_type_Aqnr.b();
    }
  }
  
  public void doOnResume()
  {
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    if (this.jdField_a_of_type_Attd != null) {
      this.jdField_a_of_type_Attd.e();
    }
    if (this.jdField_a_of_type_Atth != null) {
      this.jdField_a_of_type_Atth.b();
    }
    if (this.jdField_a_of_type_Aqnr != null) {
      this.jdField_a_of_type_Aqnr.a();
    }
    super.doOnResume();
  }
  
  public void e()
  {
    ((TextView)findViewById(2131369290)).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369245));
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840365);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131703968));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369231));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369278));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 19.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)findViewById(2131368063));
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView = ((DynamicAvatarView)findViewById(2131363426));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131368079));
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_Aqnr != null) {
      return this.jdField_a_of_type_Aqnr.c();
    }
    return false;
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_Aqnr != null) {
      return this.jdField_a_of_type_Aqnr.a();
    }
    return false;
  }
  
  public void finish()
  {
    if (this.jdField_a_of_type_Aqnr != null)
    {
      this.jdField_a_of_type_Aqnr.d();
      return;
    }
    super.finish();
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_Aqnr != null) && (this.jdField_a_of_type_Aqnr.c())) {
      this.jdField_a_of_type_Aqnr.f();
    }
  }
  
  public boolean g()
  {
    return this.d;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    if (this.jdField_a_of_type_Attd != null) {
      this.jdField_a_of_type_Attd.c();
    }
    return bool;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Attd.a();
      continue;
      onBackEvent();
      continue;
      l();
      continue;
      System.arraycopy(this.jdField_a_of_type_ArrayOfLong, 1, this.jdField_a_of_type_ArrayOfLong, 0, this.jdField_a_of_type_ArrayOfLong.length - 1);
      this.jdField_a_of_type_ArrayOfLong[(this.jdField_a_of_type_ArrayOfLong.length - 1)] = SystemClock.uptimeMillis();
      if ((this.jdField_a_of_type_ArrayOfLong[0] >= SystemClock.uptimeMillis() - 1500L) && (this.jdField_a_of_type_Attd != null)) {
        this.jdField_a_of_type_Attd.g();
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity
 * JD-Core Version:    0.7.0.1
 */