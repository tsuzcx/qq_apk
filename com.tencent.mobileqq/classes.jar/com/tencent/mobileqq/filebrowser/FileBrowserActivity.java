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
  private int jdField_a_of_type_Int;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private BaseQQAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
  private IColorNoteController jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
  private IFileBrowserData jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData;
  private IFileBrowserModel jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel;
  private FileBrowserPresenterBase jdField_a_of_type_ComTencentMobileqqFilebrowserPresenterFileBrowserPresenterBase;
  private FileBrowserViewBase jdField_a_of_type_ComTencentMobileqqFilebrowserViewFileBrowserViewBase;
  private ShareActionSheet jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet;
  private String jdField_a_of_type_JavaLangString;
  private final Observer jdField_a_of_type_JavaUtilObserver = new FileBrowserActivity.1(this);
  private int jdField_b_of_type_Int = 0;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  
  private int a()
  {
    int k = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a();
    int j = 0;
    int i = j;
    if (k != 0)
    {
      i = j;
      if (k != 2)
      {
        if (k == 13) {
          return 0;
        }
        i = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.d();
        if (i == 16) {
          return 0;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b() == 0) && ((i == 0) || (i == 3) || (i == 2))) {
          return 0;
        }
        if (FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.b()))
        {
          if (b()) {
            return 2;
          }
          return 1;
        }
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.c()))
        {
          i = j;
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.d())) {}
        }
        else
        {
          if (b()) {
            return 2;
          }
          i = 1;
        }
      }
    }
    return i;
  }
  
  private void a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("browseId", 0);
    if (i == 0) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel = ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).getFileModel(i);
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel;
    if (paramIntent == null) {
      return;
    }
    paramIntent.a(this);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a(this);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a();
  }
  
  private void a(ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    int j = a();
    if ((j != 0) && (c()))
    {
      int i = 70;
      if (j == 2) {
        i = 82;
      }
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = ShareActionSheetBuilder.ActionSheetItem.build(i);
      localActionSheetItem.iconNeedBg = true;
      localActionSheetItem.argus = "";
      localActionSheetItem.listener = new FileBrowserActivity.6(this, j);
      paramArrayList.add(0, localActionSheetItem);
    }
  }
  
  private boolean a()
  {
    IColorNoteController localIColorNoteController = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if ((localIColorNoteController != null) && (!localIColorNoteController.isColorNoteExist()))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.canAddColorNote())
      {
        this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.insertColorNote();
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.onCannotAdd();
    }
    return false;
  }
  
  private boolean b()
  {
    IColorNoteController localIColorNoteController = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if (localIColorNoteController != null) {
      return localIColorNoteController.isColorNoteExist();
    }
    return false;
  }
  
  private boolean c()
  {
    IColorNoteController localIColorNoteController = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if (localIColorNoteController != null) {
      return localIColorNoteController.shouldDisplayColorNote();
    }
    return false;
  }
  
  private boolean d()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a();
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
  
  private void h()
  {
    l();
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = ((BaseQQAppInterface)getAppRuntime());
    Intent localIntent = getIntent();
    this.jdField_a_of_type_AndroidOsBundle = localIntent.getBundleExtra("file_browser_extra_params");
    this.jdField_a_of_type_JavaLangString = localIntent.getStringExtra("file_browser_extra_params_uin");
    this.jdField_a_of_type_Int = localIntent.getIntExtra("file_enter_file_browser_type", 0);
    setContentViewNoTitle(2131560836);
    a(localIntent);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel;
    if (localObject == null)
    {
      finish();
      return;
    }
    this.jdField_b_of_type_Int = ((IFileBrowserModel)localObject).a();
    a(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewFileBrowserViewBase = this.jdField_a_of_type_ComTencentMobileqqFilebrowserPresenterFileBrowserPresenterBase.a();
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    a().addView(this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewFileBrowserViewBase.b(), (ViewGroup.LayoutParams)localObject);
    d();
    e();
    f();
    b();
    if (!QQFileManagerUtil.a())
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
  
  private void i()
  {
    TextView localTextView = (TextView)findViewById(2131369249);
    if (localTextView == null) {
      return;
    }
    localTextView.setTextSize(1, 19.0F);
    localTextView.setOnClickListener(this);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilebrowserPresenterFileBrowserPresenterBase;
    if (localObject == null) {
      return;
    }
    localObject = ((FileBrowserPresenterBase)localObject).a();
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.i("GeneralFileBrowserActivity", 1, "initTitleText:file name is empty.");
      return;
    }
    localTextView.post(new FileBrowserActivity.3(this, localTextView, (String)localObject));
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368077));
    QBrowserUtils.c(this.jdField_a_of_type_Int);
    ((RelativeLayout)findViewById(2131368051)).setVisibility(8);
  }
  
  private void k()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel;
    if (localObject == null)
    {
      QLog.i("GeneralFileBrowserActivity", 1, "refreshFileView error: fileModel is null");
      return;
    }
    int i = ((IFileBrowserModel)localObject).a();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshFileView. currentType[");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append("] fileType[");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("]");
      QLog.i("GeneralFileBrowserActivity", 1, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_b_of_type_Int != i)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilebrowserPresenterFileBrowserPresenterBase;
      if (localObject != null) {
        ((FileBrowserPresenterBase)localObject).i();
      }
      a(i);
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewFileBrowserViewBase = this.jdField_a_of_type_ComTencentMobileqqFilebrowserPresenterFileBrowserPresenterBase.a();
      this.jdField_b_of_type_Int = i;
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserPresenterFileBrowserPresenterBase.a();
    }
    localObject = a();
    if (localObject != null)
    {
      ((ViewGroup)localObject).removeAllViews();
      ((ViewGroup)localObject).addView(this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewFileBrowserViewBase.b(), new ViewGroup.LayoutParams(-1, -1));
    }
    f();
    if (d())
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void l()
  {
    new GestureDetector(null, new FileBrowserActivity.4(this, getResources().getDisplayMetrics().widthPixels / 6)).setIsLongpressEnabled(false);
  }
  
  private void m()
  {
    IColorNoteController localIColorNoteController = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if ((localIColorNoteController != null) && (localIColorNoteController.isColorNoteExist())) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.deleteColorNote();
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet == null)
    {
      localParam = new ShareActionSheetV2.Param();
      localParam.context = this;
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ShareActionSheetFactory.create(localParam);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(0, 0, 0);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a();
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
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilebrowserPresenterFileBrowserPresenterBase.a());
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append(FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData.a()));
      ((StringBuilder)localObject).append(")");
      localObject = ((StringBuilder)localObject).toString();
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetTitle((CharSequence)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a();
      getIntent().putExtra("big_brother_source_key", "biz_src_jc_file");
      if (localObject == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setRowVisibility(8, 0, 0);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity((Intent)localObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems(localParam, localArrayList);
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new FileBrowserActivity.7(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
    }
  }
  
  private void o()
  {
    int i = QBrowserUtils.c(this.jdField_a_of_type_Int);
    if (i == -1) {
      return;
    }
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localImageView != null) {
      localImageView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a(this, i, this.jdField_a_of_type_JavaLangString);
  }
  
  public RelativeLayout a()
  {
    return (RelativeLayout)findViewById(2131366799);
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
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserPresenterFileBrowserPresenterBase = new DocFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel, this);
      break;
    case 11: 
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserPresenterFileBrowserPresenterBase = new AppStoreApkFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel, this);
      break;
    case 10: 
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserPresenterFileBrowserPresenterBase = new DocExportFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel, this);
      break;
    case 9: 
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserPresenterFileBrowserPresenterBase = new OnlineSimpleFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel, this);
      break;
    case 7: 
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserPresenterFileBrowserPresenterBase = new PreviewSimpleFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel, this);
      break;
    case 5: 
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserPresenterFileBrowserPresenterBase = new ZipFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel, this);
      break;
    case 4: 
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserPresenterFileBrowserPresenterBase = new MusicFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel, this);
      break;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserPresenterFileBrowserPresenterBase = new ApkSimpleFilePresenter(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel, this);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserPresenterFileBrowserPresenterBase.a(this.jdField_a_of_type_AndroidOsBundle);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserPresenterFileBrowserPresenterBase.a(this);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserPresenterFileBrowserPresenterBase.a();
  }
  
  public void a(boolean paramBoolean)
  {
    View localView = findViewById(2131376639);
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
      LiuHaiUtils.c(this);
      getWindow().setFlags(1024, 1024);
      return;
    }
    localView.setVisibility(0);
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (this.mSystemBarComp != null))
    {
      int i = getResources().getColor(2131167114);
      this.mSystemBarComp.setStatusColor(i);
      this.mSystemBarComp.setStatusBarColor(i);
      if (ThemeUtil.isDefaultOrDIYTheme(false)) {
        this.mSystemBarComp.setStatusBarDrawable(getResources().getDrawable(2130846361));
      }
    }
    LiuHaiUtils.b(this);
    getWindow().setFlags(0, 1024);
  }
  
  @TargetApi(14)
  public void b()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      Object localObject = getResources().getConfiguration().toString();
      int i;
      if ((!((String)localObject).contains("hwMultiwindow-magic")) && (!((String)localObject).contains("hw-magic-windows"))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0)
      {
        localObject = (RelativeLayout)findViewById(2131376810);
        ((RelativeLayout)localObject).setFitsSystemWindows(true);
        ((RelativeLayout)localObject).setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      }
    }
  }
  
  public void c()
  {
    n();
  }
  
  public void d()
  {
    ((TextView)findViewById(2131369261)).setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369216));
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840347);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131692391));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    ((TextView)findViewById(2131369202)).setOnClickListener(this);
    i();
    j();
    if (d())
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
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
    FileBrowserPresenterBase localFileBrowserPresenterBase = this.jdField_a_of_type_ComTencentMobileqqFilebrowserPresenterFileBrowserPresenterBase;
    if (localFileBrowserPresenterBase != null) {
      localFileBrowserPresenterBase.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    LiuHaiUtils.a(this);
    LiuHaiUtils.enableNotch(this);
    super.doOnCreate(paramBundle);
    h();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if ((QLog.isColorLevel()) && (!isFinishing())) {
      QLog.i("GeneralFileBrowserActivity", 2, "FileBrowserActivity is called doOnDestroy But not finished!");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController != null)
    {
      if (a() != 0) {
        this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.addHistoryNote();
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.onDestroy();
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel;
    if (localObject != null)
    {
      ((IFileBrowserModel)localObject).c();
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilebrowserPresenterFileBrowserPresenterBase;
    if (localObject != null)
    {
      ((FileBrowserPresenterBase)localObject).i();
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserPresenterFileBrowserPresenterBase = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewFileBrowserViewBase != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilebrowserViewFileBrowserViewBase = null;
    }
  }
  
  protected void doOnPause()
  {
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel;
    if (localObject != null) {
      ((IFileBrowserModel)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilebrowserPresenterFileBrowserPresenterBase;
    if (localObject != null) {
      ((FileBrowserPresenterBase)localObject).m();
    }
    localObject = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
    if (localObject != null) {
      ((IMessageFacade)((BaseQQAppInterface)localObject).getRuntimeService(IMessageFacade.class)).deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if (localObject != null) {
      ((IColorNoteController)localObject).onPause();
    }
  }
  
  protected void doOnResume()
  {
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel;
    if (localObject != null) {
      ((IFileBrowserModel)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilebrowserPresenterFileBrowserPresenterBase;
    if (localObject != null) {
      ((FileBrowserPresenterBase)localObject).l();
    }
    localObject = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
    if (localObject != null) {
      ((IMessageFacade)((BaseQQAppInterface)localObject).getRuntimeService(IMessageFacade.class)).addObserver(this.jdField_a_of_type_JavaUtilObserver);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController;
    if (localObject != null) {
      ((IColorNoteController)localObject).onResume();
    }
    super.doOnResume();
  }
  
  void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController = ((IColorNoteController)QRoute.api(IColorNoteController.class));
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.init(this, true, true);
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.setServiceInfo(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a());
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.attachToActivity(this);
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.setOnColorNoteAnimFinishListener(new FileBrowserActivity.5(this));
  }
  
  void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.setServiceInfo(this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel.a());
    if (a() != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.enablePostTable();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqColornoteApiIColorNoteController.disablePostTable();
  }
  
  public void g()
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
    FileBrowserPresenterBase localFileBrowserPresenterBase = this.jdField_a_of_type_ComTencentMobileqqFilebrowserPresenterFileBrowserPresenterBase;
    if (localFileBrowserPresenterBase != null) {
      localFileBrowserPresenterBase.o();
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131369216) {
      n();
    } else if (i == 2131369202) {
      onBackEvent();
    } else if (i == 2131368033) {
      o();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.FileBrowserActivity
 * JD-Core Version:    0.7.0.1
 */