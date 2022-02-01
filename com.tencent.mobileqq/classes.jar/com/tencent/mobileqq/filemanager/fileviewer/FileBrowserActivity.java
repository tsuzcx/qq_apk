package com.tencent.mobileqq.filemanager.fileviewer;

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
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanageraux.fileviewer.FileView.TdsReaderGlobal;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class FileBrowserActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, IFileBrowser
{
  ForwardFileInfo a;
  protected IFileViewReport b = null;
  protected int c = 10000;
  protected FileBrowserManager d;
  IFileViewListener e = new FileBrowserActivity.5(this);
  boolean f = false;
  private String g;
  private TextView h;
  private TextView i;
  private ImageView j;
  private AvatarLayout k;
  private RelativeLayout l;
  private DynamicAvatarView m;
  private ForwardData n = null;
  private boolean o = false;
  private boolean p = false;
  private GestureDetector q = null;
  private boolean r;
  private String s;
  private int t;
  private FileBrowserMiniAIOHelper u;
  private long[] v = new long[5];
  private IColorNoteController w;
  private int x = -1;
  private BroadcastReceiver y = null;
  
  private void a(Object paramObject, String paramString, FileBrowserActivity.TypedObject... paramVarArgs)
  {
    if (paramObject == null) {
      return;
    }
    int i1 = 0;
    if (paramVarArgs == null) {}
    try
    {
      Class[] arrayOfClass = new Class[0];
      break label28;
      arrayOfClass = new Class[paramVarArgs.length];
      label28:
      Object[] arrayOfObject;
      if (paramVarArgs == null) {
        arrayOfObject = new Object[0];
      } else {
        arrayOfObject = new Object[paramVarArgs.length];
      }
      if (paramVarArgs != null)
      {
        int i2 = arrayOfClass.length;
        while (i1 < i2)
        {
          arrayOfClass[i1] = paramVarArgs[i1].b();
          arrayOfObject[i1] = paramVarArgs[i1].a();
          i1 += 1;
        }
      }
      paramString = paramObject.getClass().getDeclaredMethod(paramString, arrayOfClass);
      paramString.setAccessible(true);
      paramString.invoke(paramObject, arrayOfObject);
      return;
    }
    catch (Throwable paramObject) {}
  }
  
  private void m()
  {
    this.w = ((IColorNoteController)QRoute.api(IColorNoteController.class));
    this.w.init(this, true, true);
    this.w.setServiceInfo(this.d.h());
    this.w.attachToActivity(this);
    this.w.setOnColorNoteAnimFinishListener(new FileBrowserActivity.1(this));
    boolean bool = this.d.g();
    if (!bool) {
      this.w.disablePostTable();
    } else {
      this.w.enablePostTable();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initColorNoteController: checkShowFileColorNote[");
      localStringBuilder.append(bool);
      localStringBuilder.append("]");
      QLog.i("FileBrowserActivity<FileAssistant>", 2, localStringBuilder.toString());
    }
  }
  
  private void p()
  {
    Object localObject = this.w;
    if (localObject != null)
    {
      ((IColorNoteController)localObject).setServiceInfo(this.d.h());
      boolean bool = this.d.g();
      if (!bool) {
        this.w.disablePostTable();
      } else {
        this.w.enablePostTable();
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateColorNoteController: checkShowFileColorNote[");
        ((StringBuilder)localObject).append(bool);
        ((StringBuilder)localObject).append("]");
        QLog.i("FileBrowserActivity<FileAssistant>", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void q()
  {
    this.q = new GestureDetector(null, new FileBrowserActivity.2(this, getResources().getDisplayMetrics().widthPixels / 6));
    this.q.setIsLongpressEnabled(false);
  }
  
  private void r()
  {
    RelativeLayout localRelativeLayout = a();
    if (localRelativeLayout == null) {
      return;
    }
    a(localRelativeLayout.getParent(), "clearChildFocus", new FileBrowserActivity.TypedObject[] { new FileBrowserActivity.TypedObject(localRelativeLayout, View.class) });
  }
  
  private void s()
  {
    Object localObject = this.d;
    if (localObject == null) {
      return;
    }
    if (localObject != null)
    {
      localObject = ((FileBrowserManager)localObject).b();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.i("FileBrowserActivity<FileAssistant>", 1, "updateTitleBar,but file name is empty.");
        return;
      }
      this.h.post(new FileBrowserActivity.4(this, (String)localObject));
    }
    int i1 = QFileUtils.a(this.t);
    if ((!TextUtils.isEmpty(this.s)) && (i1 != -1) && (u()) && (this.d.a()))
    {
      this.u = new FileBrowserMiniAIOHelper(this.app, this.s);
      localObject = (ImageView)findViewById(2131434928);
      this.u.a((View)localObject);
      this.l.setVisibility(0);
      this.k.setVisibility(0);
      this.k.a(0, this.m, false);
      this.k.setOnClickListener(this);
      this.m.setImageDrawable(FaceDrawable.getFaceDrawable(this.app, QFileUtils.a(this.app, i1, this.s), this.s));
    }
    else
    {
      this.l.setVisibility(8);
      this.k.setVisibility(8);
    }
    if (this.d.j())
    {
      this.j.setVisibility(0);
      return;
    }
    this.j.setVisibility(8);
  }
  
  private void t()
  {
    if (!u()) {
      return;
    }
    if (TextUtils.isEmpty(this.s)) {
      return;
    }
    int i1 = this.t;
    if (i1 == 0) {
      return;
    }
    String str = this.s;
    i1 = QFileUtils.a(i1);
    if (i1 == -1) {
      return;
    }
    FileBrowserMiniAIOHelper localFileBrowserMiniAIOHelper = this.u;
    if (localFileBrowserMiniAIOHelper != null) {
      localFileBrowserMiniAIOHelper.a();
    }
    MiniChatActivity.a(this, i1, str, ContactUtils.a(this.app, str, i1));
  }
  
  private boolean u()
  {
    int i1 = this.t;
    if ((i1 != 1) && (i1 != 2) && (i1 != 5) && (i1 != 6) && (i1 != 3) && (i1 != 13)) {
      return i1 == 4;
    }
    return true;
  }
  
  private void v()
  {
    if (c())
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileBrowserActivity<FileAssistant>", 2, "registerQlinkFinishFMReceiver");
      }
      if (this.y == null)
      {
        this.y = new FileBrowserActivity.6(this);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.qlink.destory.fmactivity");
        this.app.getApp().registerReceiver(this.y, localIntentFilter);
      }
    }
  }
  
  private void w()
  {
    if (this.y != null)
    {
      this.app.getApp().unregisterReceiver(this.y);
      this.y = null;
    }
  }
  
  public RelativeLayout a()
  {
    return (RelativeLayout)findViewById(2131433121);
  }
  
  public void a(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131427501);
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    localRelativeLayout.setVisibility(i1);
  }
  
  @TargetApi(14)
  protected boolean a(Intent paramIntent)
  {
    Object localObject = new FileViewerParamParser(this.app);
    String str = this.g;
    if ((str != null) && (str.trim().length() != 0)) {
      ((FileViewerParamParser)localObject).a(this.g);
    }
    if (!((FileViewerParamParser)localObject).a(paramIntent)) {
      return false;
    }
    int i1 = paramIntent.getIntExtra("file_enter_file_browser_type", 0);
    if (this.d == null)
    {
      this.d = new FileBrowserManager(this, this, ((FileViewerParamParser)localObject).a(this));
      this.d.a(this.e);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("browse file use old fileBrowser, entrance ");
    ((StringBuilder)localObject).append(i1);
    QLog.d("fileBrowser", 1, ((StringBuilder)localObject).toString());
    paramIntent = paramIntent.getBundleExtra("file_browser_extra_params");
    if (!this.d.a(a(), new RelativeLayout.LayoutParams(-1, -1), i1, paramIntent))
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileBrowserActivity<FileAssistant>", 2, "error. can not create a fileviewer from FileBrowserManager");
      }
      return false;
    }
    if (this.d.d()) {
      setRequestedOrientation(1);
    }
    return true;
  }
  
  public void b()
  {
    if (isFinishing()) {
      return;
    }
    ThreadManager.getUIHandler().post(new FileBrowserActivity.3(this));
  }
  
  public boolean c()
  {
    Intent localIntent = getIntent();
    boolean bool = false;
    if ((localIntent.getBooleanExtra("from_qlink", false)) || (getIntent().getBooleanExtra("from_qlink_enter_recent", false))) {
      bool = true;
    }
    return bool;
  }
  
  public void d()
  {
    finish();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FileBrowserAct doOnActivityResult resultCode=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("mForwardType=");
      ((StringBuilder)localObject).append(this.c);
      QLog.d("forward", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt2 == 4)
    {
      if (this.n == null)
      {
        this.n = new ForwardData();
        this.n.a(getIntent());
      }
      if ((this.n.a()) && (paramIntent != null) && (paramIntent.getExtras() != null))
      {
        localObject = AIOUtils.a(new Intent(this, SplashActivity.class), new int[] { 2 });
        ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
        startActivity((Intent)localObject);
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
    Object localObject = this.d;
    if (localObject != null) {
      ((FileBrowserManager)localObject).a(paramInt1, paramInt2, paramIntent);
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    FileBrowserManager localFileBrowserManager = this.d;
    if (localFileBrowserManager != null)
    {
      localFileBrowserManager.a(paramConfiguration);
      if (this.d.d())
      {
        setRequestedOrientation(-1);
        this.f ^= true;
      }
    }
  }
  
  @TargetApi(14)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    LiuHaiUtils.enableNotch(this);
    TdsReaderGlobal.a();
    paramBundle = getIntent();
    this.t = paramBundle.getIntExtra("file_enter_file_browser_type", 0);
    Object localObject = ((IFMConfig)QRoute.api(IFMConfig.class)).getConfigValue(this.app.getApplication().getBaseContext(), "OnlinePreView", "RotateScreen", "FunctionalSwitch");
    if (localObject != null) {}
    try
    {
      i1 = Integer.parseInt((String)localObject);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      int i1;
      label77:
      break label77;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("FileBrowserActivity<FileAssistant>", 4, "can not format FMConfig value to integer");
    }
    i1 = 0;
    if (1 == i1) {
      setRequestedOrientation(-1);
    }
    this.a = ((ForwardFileInfo)paramBundle.getParcelableExtra("fileinfo"));
    this.g = paramBundle.getStringExtra("c2c_discussion_recentfile");
    this.s = paramBundle.getStringExtra("file_browser_extra_params_uin");
    localObject = this.a;
    if (localObject == null)
    {
      finish();
      return false;
    }
    this.c = ((ForwardFileInfo)localObject).c();
    if (10004 == this.c)
    {
      this.p = true;
      FileManagerReporter.a("0X8004BB3");
    }
    else
    {
      FileManagerReporter.a("0X8004BC8");
    }
    if (paramBundle.getBooleanExtra("_from_aio_", false)) {
      this.p = true;
    }
    if (paramBundle.getBooleanExtra("key_is_from_lite", false)) {
      this.r = true;
    }
    LiuHaiUtils.f(this);
    setContentViewNoTitle(2131627094);
    f();
    if (!a(paramBundle))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserActivity<FileAssistant>", 2, "create FileBrowserView failed");
      }
      finish();
      return false;
    }
    this.x = this.d.f();
    m();
    s();
    FileManagerReporter.a("0X8004C01");
    v();
    q();
    localObject = getResources().getConfiguration().toString();
    if ((!((String)localObject).contains("hwMultiwindow-magic")) && (!((String)localObject).contains("hw-magic-windows"))) {
      i1 = 0;
    } else {
      i1 = 1;
    }
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (i1 == 0))
    {
      localObject = (RelativeLayout)findViewById(2131445139);
      ((RelativeLayout)localObject).setFitsSystemWindows(true);
      ((RelativeLayout)localObject).setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    if (!FileManagerUtil.b())
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
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if ((QLog.isColorLevel()) && (!isFinishing())) {
      QLog.i("FileBrowserActivity<FileAssistant>", 2, "FileBrowserActivity is called doOnDestroy But not finished!");
    }
    r();
    w();
    if (this.w != null)
    {
      if (this.d.g()) {
        this.w.addHistoryNote();
      }
      this.w.onDestroy();
    }
    Object localObject = this.d;
    if (localObject != null) {
      ((FileBrowserManager)localObject).q();
    }
    localObject = this.u;
    if (localObject != null) {
      ((FileBrowserMiniAIOHelper)localObject).d();
    }
  }
  
  protected void doOnPause()
  {
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    Object localObject = this.d;
    if (localObject != null) {
      ((FileBrowserManager)localObject).o();
    }
    localObject = this.u;
    if (localObject != null) {
      ((FileBrowserMiniAIOHelper)localObject).c();
    }
    localObject = this.w;
    if (localObject != null) {
      ((IColorNoteController)localObject).onPause();
    }
  }
  
  protected void doOnResume()
  {
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    Object localObject = this.d;
    if (localObject != null) {
      ((FileBrowserManager)localObject).p();
    }
    localObject = this.u;
    if (localObject != null) {
      ((FileBrowserMiniAIOHelper)localObject).b();
    }
    localObject = this.w;
    if (localObject != null) {
      ((IColorNoteController)localObject).onResume();
    }
    super.doOnResume();
  }
  
  public boolean e()
  {
    return this.o;
  }
  
  public void f()
  {
    ((TextView)findViewById(2131436239)).setVisibility(8);
    this.j = ((ImageView)findViewById(2131436194));
    this.j.setImageResource(2130841087);
    this.j.setVisibility(8);
    this.j.setContentDescription(HardCodeUtil.a(2131902508));
    this.j.setOnClickListener(this);
    this.i = ((TextView)findViewById(2131436180));
    this.i.setOnClickListener(this);
    this.h = ((TextView)findViewById(2131436227));
    this.h.setTextSize(1, 19.0F);
    this.h.setOnClickListener(this);
    this.k = ((AvatarLayout)findViewById(2131434878));
    this.m = ((DynamicAvatarView)findViewById(2131429335));
    this.l = ((RelativeLayout)findViewById(2131434901));
  }
  
  public void finish()
  {
    IColorNoteController localIColorNoteController = this.w;
    if (localIColorNoteController != null)
    {
      localIColorNoteController.exitAnimation();
      return;
    }
    super.finish();
  }
  
  public boolean g()
  {
    return this.p;
  }
  
  public void h()
  {
    FileBrowserManager localFileBrowserManager = this.d;
    if (localFileBrowserManager == null)
    {
      QLog.e("FileBrowserActivity<FileAssistant>", 1, "updateMenu but mFileBrowserManager is null!");
      return;
    }
    localFileBrowserManager.l();
    if (this.d.j())
    {
      this.j.setVisibility(0);
      return;
    }
    this.j.setVisibility(8);
  }
  
  public void i()
  {
    FileBrowserManager localFileBrowserManager = this.d;
    if (localFileBrowserManager != null) {
      localFileBrowserManager.k();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean j()
  {
    IColorNoteController localIColorNoteController = this.w;
    if ((localIColorNoteController != null) && (!localIColorNoteController.isColorNoteExist()))
    {
      if (this.w.canAddColorNote())
      {
        this.w.insertColorNote();
        return true;
      }
      this.w.onCannotAdd();
    }
    return false;
  }
  
  public boolean k()
  {
    IColorNoteController localIColorNoteController = this.w;
    if (localIColorNoteController != null) {
      return localIColorNoteController.isColorNoteExist();
    }
    return false;
  }
  
  public boolean l()
  {
    return this.r;
  }
  
  public void n()
  {
    IColorNoteController localIColorNoteController = this.w;
    if ((localIColorNoteController != null) && (localIColorNoteController.isColorNoteExist())) {
      this.w.deleteColorNote();
    }
  }
  
  public boolean o()
  {
    IColorNoteController localIColorNoteController = this.w;
    if (localIColorNoteController != null) {
      return localIColorNoteController.shouldDisplayColorNote();
    }
    return false;
  }
  
  protected boolean onBackEvent()
  {
    boolean bool = super.onBackEvent();
    FileBrowserManager localFileBrowserManager = this.d;
    if (localFileBrowserManager != null) {
      localFileBrowserManager.n();
    }
    return bool;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131436227: 
      long[] arrayOfLong = this.v;
      System.arraycopy(arrayOfLong, 1, arrayOfLong, 0, arrayOfLong.length - 1);
      arrayOfLong = this.v;
      arrayOfLong[(arrayOfLong.length - 1)] = SystemClock.uptimeMillis();
      long l1 = this.v[0];
      SystemClock.uptimeMillis();
      break;
    case 2131436194: 
      this.d.k();
      break;
    case 2131436180: 
      onBackEvent();
      break;
    case 2131434878: 
      t();
    }
    EventCollector.getInstance().onViewClicked(paramView);
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