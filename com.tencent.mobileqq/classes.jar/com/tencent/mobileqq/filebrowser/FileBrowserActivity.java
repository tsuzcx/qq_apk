package com.tencent.mobileqq.filebrowser;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.filebrowser.presenter.ApkSimpleFilePresenter;
import com.tencent.mobileqq.filebrowser.presenter.AppStoreApkFilePresenter;
import com.tencent.mobileqq.filebrowser.presenter.DocExportFilePresenter;
import com.tencent.mobileqq.filebrowser.presenter.DocFilePresenter;
import com.tencent.mobileqq.filebrowser.presenter.FileBrowserPresenterBase;
import com.tencent.mobileqq.filebrowser.presenter.MusicFilePresenter;
import com.tencent.mobileqq.filebrowser.presenter.OnlineSimpleFilePresenter;
import com.tencent.mobileqq.filebrowser.presenter.PreviewSimpleFilePresenter;
import com.tencent.mobileqq.filebrowser.presenter.ZipFilePresenter;
import com.tencent.mobileqq.filebrowser.view.FileBrowserViewBase;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QBrowserUtils;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.theme.ThemeNavigationBarUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Observer;
import mqq.os.MqqHandler;

public class FileBrowserActivity
  extends QIphoneTitleBarActivity
  implements View.OnClickListener, IFileBrowserListener, IFileBrowserModel.OnEventListener
{
  private final Observer a = new FileBrowserActivity.1(this);
  private BaseQQAppInterface b;
  private IFileBrowserModel c;
  private IFileBrowserData d;
  private FileBrowserPresenterBase e;
  private FileBrowserViewBase f;
  private Bundle g;
  private String h;
  private int i;
  private int j = 0;
  private ImageView k;
  private ImageView l;
  private IColorNoteController m;
  private ShareActionSheet n;
  
  private void a(Intent paramIntent)
  {
    int i1 = paramIntent.getIntExtra("browseId", 0);
    if (i1 == 0) {
      return;
    }
    this.c = ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).getFileModel(i1);
    paramIntent = this.c;
    if (paramIntent == null) {
      return;
    }
    paramIntent.a(this);
    this.c.a(this);
    this.d = this.c.a();
  }
  
  private void a(ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    int i2 = n();
    if ((i2 != 0) && (r()))
    {
      int i1 = 70;
      if (i2 == 2) {
        i1 = 82;
      }
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = ShareActionSheetBuilder.ActionSheetItem.build(i1);
      localActionSheetItem.iconNeedBg = true;
      localActionSheetItem.argus = "";
      localActionSheetItem.listener = new FileBrowserActivity.6(this, i2);
      paramArrayList.add(0, localActionSheetItem);
    }
  }
  
  private void i()
  {
    m();
    this.b = ((BaseQQAppInterface)getAppRuntime());
    Intent localIntent = getIntent();
    this.g = localIntent.getBundleExtra("file_browser_extra_params");
    this.h = localIntent.getStringExtra("file_browser_extra_params_uin");
    this.i = localIntent.getIntExtra("file_enter_file_browser_type", 0);
    setContentViewNoTitle(2131627094);
    a(localIntent);
    Object localObject = this.c;
    if (localObject == null)
    {
      finish();
      return;
    }
    this.j = ((IFileBrowserModel)localObject).e();
    a(this.j);
    this.f = this.e.p();
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    d().addView(this.f.h(), (ViewGroup.LayoutParams)localObject);
    e();
    f();
    g();
    b();
    if (!QQFileManagerUtil.h())
    {
      localObject = new Intent(this, WebProcessReceiver.class);
      ((Intent)localObject).setAction("action_download_tbs");
      sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    }
    init(localIntent);
    if (Build.VERSION.SDK_INT <= 11) {
      removeWebViewLayerType();
    }
  }
  
  private void j()
  {
    TextView localTextView = (TextView)findViewById(2131436227);
    if (localTextView == null) {
      return;
    }
    localTextView.setTextSize(1, 19.0F);
    localTextView.setOnClickListener(this);
    Object localObject = this.e;
    if (localObject == null) {
      return;
    }
    localObject = ((FileBrowserPresenterBase)localObject).r();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.i("GeneralFileBrowserActivity", 1, "initTitleText:file name is empty.");
      return;
    }
    localTextView.post(new FileBrowserActivity.3(this, localTextView, (String)localObject));
  }
  
  private void k()
  {
    this.k = ((ImageView)findViewById(2131434928));
    QBrowserUtils.c(this.i);
    ((RelativeLayout)findViewById(2131434901)).setVisibility(8);
  }
  
  private void l()
  {
    Object localObject = this.c;
    if (localObject == null)
    {
      QLog.i("GeneralFileBrowserActivity", 1, "refreshFileView error: fileModel is null");
      return;
    }
    int i1 = ((IFileBrowserModel)localObject).e();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshFileView. currentType[");
      ((StringBuilder)localObject).append(this.j);
      ((StringBuilder)localObject).append("] fileType[");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append("]");
      QLog.i("GeneralFileBrowserActivity", 1, ((StringBuilder)localObject).toString());
    }
    if (this.j != i1)
    {
      localObject = this.e;
      if (localObject != null) {
        ((FileBrowserPresenterBase)localObject).j();
      }
      a(i1);
      this.f = this.e.p();
      this.j = i1;
    }
    else
    {
      this.e.a();
    }
    localObject = d();
    if (localObject != null)
    {
      ((ViewGroup)localObject).removeAllViews();
      ((ViewGroup)localObject).addView(this.f.h(), new ViewGroup.LayoutParams(-1, -1));
    }
    g();
    if (s())
    {
      this.l.setVisibility(0);
      return;
    }
    this.l.setVisibility(8);
  }
  
  private void m()
  {
    new GestureDetector(null, new FileBrowserActivity.4(this, getResources().getDisplayMetrics().widthPixels / 6)).setIsLongpressEnabled(false);
  }
  
  private int n()
  {
    int i3 = this.d.d();
    int i2 = 0;
    int i1 = i2;
    if (i3 != 0)
    {
      i1 = i2;
      if (i3 != 2)
      {
        if (i3 == 13) {
          return 0;
        }
        i1 = this.d.g();
        if (i1 == 16) {
          return 0;
        }
        if ((this.d.e() == 0) && ((i1 == 0) || (i1 == 3) || (i1 == 2))) {
          return 0;
        }
        if (FileUtil.b(this.d.c()))
        {
          if (p()) {
            return 2;
          }
          return 1;
        }
        if (TextUtils.isEmpty(this.d.h()))
        {
          i1 = i2;
          if (TextUtils.isEmpty(this.d.i())) {}
        }
        else
        {
          if (p()) {
            return 2;
          }
          i1 = 1;
        }
      }
    }
    return i1;
  }
  
  private boolean o()
  {
    IColorNoteController localIColorNoteController = this.m;
    if ((localIColorNoteController != null) && (!localIColorNoteController.isColorNoteExist()))
    {
      if (this.m.canAddColorNote())
      {
        this.m.insertColorNote();
        return true;
      }
      this.m.onCannotAdd();
    }
    return false;
  }
  
  private boolean p()
  {
    IColorNoteController localIColorNoteController = this.m;
    if (localIColorNoteController != null) {
      return localIColorNoteController.isColorNoteExist();
    }
    return false;
  }
  
  private void q()
  {
    IColorNoteController localIColorNoteController = this.m;
    if ((localIColorNoteController != null) && (localIColorNoteController.isColorNoteExist())) {
      this.m.deleteColorNote();
    }
  }
  
  private boolean r()
  {
    IColorNoteController localIColorNoteController = this.m;
    if (localIColorNoteController != null) {
      return localIColorNoteController.shouldDisplayColorNote();
    }
    return false;
  }
  
  private boolean s()
  {
    Object localObject1 = this.c.v();
    Object localObject2 = null;
    boolean bool2 = false;
    if (localObject1 != null)
    {
      if (localObject1.length == 1)
      {
        localObject2 = localObject1[0];
        localObject1 = null;
        break label55;
      }
      if (localObject1.length == 2)
      {
        localObject2 = localObject1[0];
        localObject1 = localObject1[1];
        break label55;
      }
    }
    localObject1 = null;
    label55:
    boolean bool1;
    if ((localObject2 == null) || (localObject2.isEmpty()))
    {
      bool1 = bool2;
      if (localObject1 != null)
      {
        bool1 = bool2;
        if (((ArrayList)localObject1).isEmpty()) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  private void t()
  {
    if (this.c == null) {
      return;
    }
    if (this.n == null)
    {
      localParam = new ShareActionSheetV2.Param();
      localParam.context = this;
      this.n = ShareActionSheetFactory.create(localParam);
    }
    this.n.setRowVisibility(0, 0, 0);
    Object localObject = this.c.v();
    ArrayList localArrayList = null;
    if (localObject != null)
    {
      if (localObject.length == 1)
      {
        localParam = localObject[0];
        break label96;
      }
      if (localObject.length == 2)
      {
        localParam = localObject[0];
        localArrayList = localObject[1];
        break label96;
      }
    }
    ShareActionSheetV2.Param localParam = null;
    label96:
    a(localArrayList);
    if (((localParam != null) && (!localParam.isEmpty())) || ((localArrayList != null) && (!localArrayList.isEmpty())))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.e.r());
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append(FileUtil.a(this.d.b()));
      ((StringBuilder)localObject).append(")");
      localObject = ((StringBuilder)localObject).toString();
      this.n.setActionSheetTitle((CharSequence)localObject);
      localObject = this.c.u();
      getIntent().putExtra("big_brother_source_key", "biz_src_jc_file");
      if (localObject == null) {
        this.n.setRowVisibility(8, 0, 0);
      } else {
        this.n.setIntentForStartForwardRecentActivity((Intent)localObject);
      }
      this.n.setActionSheetItems(localParam, localArrayList);
      this.n.setItemClickListenerV2(new FileBrowserActivity.7(this));
      this.n.show();
    }
  }
  
  private void u()
  {
    int i1 = QBrowserUtils.c(this.i);
    if (i1 == -1) {
      return;
    }
    ImageView localImageView = this.k;
    if (localImageView != null) {
      localImageView.setVisibility(8);
    }
    this.c.a(this, i1, this.h);
  }
  
  public void a()
  {
    if (isFinishing()) {
      return;
    }
    ThreadManager.getUIHandler().post(new FileBrowserActivity.2(this));
  }
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    case 6: 
    case 8: 
    default: 
      this.e = new DocFilePresenter(this.c, this);
      break;
    case 11: 
      this.e = new AppStoreApkFilePresenter(this.c, this);
      break;
    case 10: 
      this.e = new DocExportFilePresenter(this.c, this);
      break;
    case 9: 
      this.e = new OnlineSimpleFilePresenter(this.c, this);
      break;
    case 7: 
      this.e = new PreviewSimpleFilePresenter(this.c, this);
      break;
    case 5: 
      this.e = new ZipFilePresenter(this.c, this);
      break;
    case 4: 
      this.e = new MusicFilePresenter(this.c, this);
      break;
    case 3: 
      this.e = new ApkSimpleFilePresenter(this.c, this);
    }
    this.e.a(this.g);
    this.e.a(this);
    this.e.a();
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = findViewById(2131444900);
    if (paramBoolean)
    {
      localView.setVisibility(4);
      if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.mSystemBarComp != null))
      {
        this.mSystemBarComp.setStatusColor(0);
        this.mSystemBarComp.setStatusBarColor(0);
        if (ThemeUtil.isDefaultOrDIYTheme(false)) {
          this.mSystemBarComp.setStatusBarDrawable(null);
        }
      }
      LiuHaiUtils.h(this);
      getWindow().setFlags(1024, 1024);
      return;
    }
    localView.setVisibility(0);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.mSystemBarComp != null))
    {
      int i1 = getResources().getColor(2131168092);
      this.mSystemBarComp.setStatusColor(i1);
      this.mSystemBarComp.setStatusBarColor(i1);
      if (ThemeUtil.isDefaultOrDIYTheme(false)) {
        this.mSystemBarComp.setStatusBarDrawable(getResources().getDrawable(2130847834));
      }
    }
    LiuHaiUtils.g(this);
    getWindow().setFlags(0, 1024);
  }
  
  @TargetApi(14)
  public void b()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      Object localObject = getResources().getConfiguration().toString();
      int i1;
      if ((!((String)localObject).contains("hwMultiwindow-magic")) && (!((String)localObject).contains("hw-magic-windows"))) {
        i1 = 0;
      } else {
        i1 = 1;
      }
      if (i1 == 0)
      {
        localObject = (RelativeLayout)findViewById(2131445139);
        ((RelativeLayout)localObject).setFitsSystemWindows(true);
        ((RelativeLayout)localObject).setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
    }
  }
  
  public void c()
  {
    t();
  }
  
  public RelativeLayout d()
  {
    return (RelativeLayout)findViewById(2131433121);
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
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    FileBrowserPresenterBase localFileBrowserPresenterBase = this.e;
    if (localFileBrowserPresenterBase != null) {
      localFileBrowserPresenterBase.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    LiuHaiUtils.f(this);
    LiuHaiUtils.enableNotch(this);
    super.doOnCreate(paramBundle);
    i();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if ((QLog.isColorLevel()) && (!isFinishing())) {
      QLog.i("GeneralFileBrowserActivity", 2, "FileBrowserActivity is called doOnDestroy But not finished!");
    }
    if (this.m != null)
    {
      if (n() != 0) {
        this.m.addHistoryNote();
      }
      this.m.onDestroy();
    }
    Object localObject = this.c;
    if (localObject != null)
    {
      ((IFileBrowserModel)localObject).d();
      this.c = null;
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((FileBrowserPresenterBase)localObject).j();
      this.e = null;
    }
    if (this.f != null) {
      this.f = null;
    }
  }
  
  protected void doOnPause()
  {
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    Object localObject = this.c;
    if (localObject != null) {
      ((IFileBrowserModel)localObject).c();
    }
    localObject = this.e;
    if (localObject != null) {
      ((FileBrowserPresenterBase)localObject).m();
    }
    localObject = this.b;
    if (localObject != null) {
      ((IMessageFacade)((BaseQQAppInterface)localObject).getRuntimeService(IMessageFacade.class)).deleteObserver(this.a);
    }
    localObject = this.m;
    if (localObject != null) {
      ((IColorNoteController)localObject).onPause();
    }
  }
  
  protected void doOnResume()
  {
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    Object localObject = this.c;
    if (localObject != null) {
      ((IFileBrowserModel)localObject).b();
    }
    localObject = this.e;
    if (localObject != null) {
      ((FileBrowserPresenterBase)localObject).l();
    }
    localObject = this.b;
    if (localObject != null) {
      ((IMessageFacade)((BaseQQAppInterface)localObject).getRuntimeService(IMessageFacade.class)).addObserver(this.a);
    }
    localObject = this.m;
    if (localObject != null) {
      ((IColorNoteController)localObject).onResume();
    }
    super.doOnResume();
  }
  
  public void e()
  {
    ((TextView)findViewById(2131436239)).setVisibility(8);
    this.l = ((ImageView)findViewById(2131436194));
    this.l.setImageResource(2130841087);
    this.l.setVisibility(8);
    this.l.setContentDescription(getString(2131889379));
    this.l.setOnClickListener(this);
    ((TextView)findViewById(2131436180)).setOnClickListener(this);
    j();
    k();
    if (s())
    {
      this.l.setVisibility(0);
      return;
    }
    this.l.setVisibility(8);
  }
  
  void f()
  {
    this.m = ((IColorNoteController)QRoute.api(IColorNoteController.class));
    this.m.init(this, true, true);
    this.m.setServiceInfo(this.c.D());
    this.m.attachToActivity(this);
    this.m.setOnColorNoteAnimFinishListener(new FileBrowserActivity.5(this));
  }
  
  void g()
  {
    this.m.setServiceInfo(this.c.D());
    if (n() != 0)
    {
      this.m.enablePostTable();
      return;
    }
    this.m.disablePostTable();
  }
  
  public void h()
  {
    finish();
    overridePendingTransition(0, 0);
  }
  
  public void initNavigationBarColor()
  {
    ThemeNavigationBarUtil.a(getWindow(), -16777216);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    FileBrowserPresenterBase localFileBrowserPresenterBase = this.e;
    if (localFileBrowserPresenterBase != null) {
      localFileBrowserPresenterBase.o();
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131436194) {
      t();
    } else if (i1 == 2131436180) {
      onBackEvent();
    } else if (i1 == 2131434878) {
      u();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.FileBrowserActivity
 * JD-Core Version:    0.7.0.1
 */