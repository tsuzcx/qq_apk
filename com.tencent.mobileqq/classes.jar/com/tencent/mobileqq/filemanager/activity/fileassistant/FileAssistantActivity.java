package com.tencent.mobileqq.filemanager.activity.fileassistant;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contacts.base.HeaderScrollView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocMyFileNameBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocMyFileNameProcessor;
import com.tencent.mobileqq.doc.jsp.VoiceInputHelper;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.api.IFileAssistantTipsConfig;
import com.tencent.mobileqq.filemanager.api.IFileAssistantTipsConfig.IBaseJump;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.FileSearchActivity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanageraux.fileviewer.FileView.TdsReaderGlobal;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qqdataline.QQProxyForDataline;
import cooperation.vip.manager.FileBannerTianshuManger;
import cooperation.weiyun.WeiyunHelper;
import cooperation.weiyun.WeiyunRemoteCommand;
import cooperation.weiyun.sdk.api.WeiyunApi;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class FileAssistantActivity
  extends BaseFileAssistantActivity
  implements OnItemSelectListener
{
  Handler jdField_a_of_type_AndroidOsHandler = new FileAssistantActivity.8(this, Looper.getMainLooper());
  ViewStub jdField_a_of_type_AndroidViewViewStub = null;
  HeaderScrollView jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView;
  IFileAssistantTipsConfig jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantTipsConfig;
  QfileTabBarView jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView = null;
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new FileAssistantActivity.9(this);
  BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
  RedTouch jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
  NavBarCommon jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon;
  PopupMenuDialog jdField_a_of_type_ComTencentWidgetPopupMenuDialog;
  private FileBannerTianshuManger jdField_a_of_type_CooperationVipManagerFileBannerTianshuManger;
  private WeiyunRemoteCommand jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand;
  private int[] jdField_a_of_type_ArrayOfInt = { 2131692587, 2131698337, 2131720655, 2131719869 };
  private ViewStub jdField_b_of_type_AndroidViewViewStub;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private FMObserver jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new FileAssistantActivity.7(this);
  BusinessInfoCheckUpdate.AppInfo jdField_b_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
  RedTouch jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch;
  private int[] jdField_b_of_type_ArrayOfInt = { 2130844465, 2130844466, 2130844471, 2130844515 };
  TextView jdField_c_of_type_AndroidWidgetTextView;
  BusinessInfoCheckUpdate.AppInfo jdField_c_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo;
  RedTouch jdField_c_of_type_ComTencentMobileqqTianshuUiRedTouch;
  TextView d;
  TextView e;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  private String jdField_f_of_type_JavaLangString = HardCodeUtil.a(2131704510);
  boolean l = false;
  boolean m = false;
  private volatile boolean n = false;
  
  private void A()
  {
    this.n = false;
    if (this.app.getFileManagerEngine().a() == true)
    {
      this.app.getFileManagerEngine().c();
      return;
    }
    if (NetworkUtil.d(BaseApplication.getContext()))
    {
      Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
      localIntent.putExtra("tab_tab_type", 3);
      localIntent.putExtra("from", "FileAssistant");
      startActivityForResult(localIntent, 101);
      return;
    }
    FMToastUtil.a(BaseApplication.getContext().getString(2131694457));
  }
  
  private void B()
  {
    QLog.i("FileAssistantActivity", 1, "fileRedTouch updateAllRedTouch");
    C();
    E();
    D();
  }
  
  private void C()
  {
    RedTouchManager localRedTouchManager;
    if (this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch != null)
    {
      localRedTouchManager = (RedTouchManager)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
      if (localRedTouchManager != null) {
        break label26;
      }
    }
    label26:
    do
    {
      return;
      this.jdField_b_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo = localRedTouchManager.a(1, "100160.100163");
      QLog.i("FileAssistantActivity", 1, "fileRedTouch updateDocsFileRedTouch info = " + this.jdField_b_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
      this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch.a(this.jdField_b_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
    } while (this.jdField_b_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo == null);
    localRedTouchManager.b(this.jdField_b_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo, null);
  }
  
  private void D()
  {
    RedTouchManager localRedTouchManager;
    if (this.jdField_c_of_type_ComTencentMobileqqTianshuUiRedTouch != null)
    {
      localRedTouchManager = (RedTouchManager)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
      if (localRedTouchManager != null) {
        break label26;
      }
    }
    label26:
    do
    {
      return;
      this.jdField_c_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo = localRedTouchManager.a(1, "100160.100162");
      QLog.i("FileAssistantActivity", 1, "fileRedTouch updateWeiyunBackupRedTouch info = " + this.jdField_c_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
      this.jdField_c_of_type_ComTencentMobileqqTianshuUiRedTouch.a(this.jdField_c_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
    } while (this.jdField_c_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo == null);
    localRedTouchManager.b(this.jdField_c_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo, null);
  }
  
  private void E()
  {
    RedTouchManager localRedTouchManager;
    if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null)
    {
      localRedTouchManager = (RedTouchManager)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
      if (localRedTouchManager != null) {
        break label26;
      }
    }
    label26:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo = localRedTouchManager.a(1, "100160.100164");
      QLog.i("FileAssistantActivity", 1, "fileRedTouch updateWeiyunFileRedTouch info = " + this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a(this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo);
    } while (this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo == null);
    localRedTouchManager.b(this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo, null);
  }
  
  private void a(FileAssistantActivity paramFileAssistantActivity, String paramString, int paramInt)
  {
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this, "mqqapi://miniapp/open?_ext=&_mappid=1107999468&_mvid=&_nq=&_path=&_q=&referer=2011&via=2011&_sig=31ba7125a22d3462e9dc4f8abff74d9e9c445cdd46e8ea446f39a839ebb110b4", 2011, null);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    QLog.i("FileAssistantActivity", 1, " fileRedTouch deleteRedTouch path = " + paramString);
    RedTouchManager localRedTouchManager = (RedTouchManager)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
    if (paramAppInfo == null)
    {
      localRedTouchManager.b(paramString);
      return;
    }
    localRedTouchManager.a(paramAppInfo, null);
  }
  
  private void n()
  {
    this.e = ((TextView)findViewById(2131369289));
    this.jdField_b_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(getApplicationContext(), this.e).b(53).d(10).a();
    this.e.setOnClickListener(this);
    ReportController.b(this.app, "dc00898", "", "", "0X800906F", "0X800906F", 0, 0, "", "", "", "");
  }
  
  private void o()
  {
    TencentDocMyFileNameBean localTencentDocMyFileNameBean = TencentDocMyFileNameProcessor.a();
    if (localTencentDocMyFileNameBean != null)
    {
      this.e.setText(localTencentDocMyFileNameBean.jdField_a_of_type_JavaLangString);
      this.d.setText(localTencentDocMyFileNameBean.b);
      this.jdField_f_of_type_JavaLangString = localTencentDocMyFileNameBean.c;
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_CooperationVipManagerFileBannerTianshuManger = new FileBannerTianshuManger(this, this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView, 1);
    this.jdField_a_of_type_CooperationVipManagerFileBannerTianshuManger.a();
  }
  
  private void q()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantTipsConfig == null) || (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantTipsConfig.a()))
    {
      QLog.i("FileAssistantActivity", 1, "FileAssistantTips is switch off");
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantTipsConfig.a()))
    {
      QLog.i("FileAssistantActivity", 1, "FileAssistantTips not ready, textContent is null");
      return;
    }
    this.jdField_b_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131366517));
    this.jdField_b_of_type_AndroidViewViewStub.inflate();
    TextView localTextView1 = (TextView)findViewById(2131380648);
    TextView localTextView2 = (TextView)findViewById(2131380649);
    ImageView localImageView = (ImageView)findViewById(2131369841);
    localTextView1.setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantTipsConfig.a());
    localTextView2.setText(this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantTipsConfig.b());
    localTextView2.setOnClickListener(this);
    localImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantTipsConfig.a();
  }
  
  private void r()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.jdField_b_of_type_AndroidViewViewStub.getHeight(), 0 });
    localValueAnimator.setDuration(300L);
    localValueAnimator.addUpdateListener(new FileAssistantActivity.2(this));
    localValueAnimator.addListener(new FileAssistantActivity.3(this));
    localValueAnimator.start();
  }
  
  private void s()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      if (this.jdField_a_of_type_ArrayOfInt[i] == 2131720655) {}
      PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.jdField_a_of_type_Int = i;
      localMenuItem.jdField_a_of_type_JavaLangString = getString(this.jdField_a_of_type_ArrayOfInt[i]);
      localMenuItem.c = localMenuItem.jdField_a_of_type_JavaLangString;
      if (i == 3)
      {
        TencentDocMyFileNameBean localTencentDocMyFileNameBean = TencentDocMyFileNameProcessor.a();
        if ((localTencentDocMyFileNameBean != null) && (!TextUtils.isEmpty(localTencentDocMyFileNameBean.d)))
        {
          localMenuItem.jdField_a_of_type_JavaLangString = localTencentDocMyFileNameBean.d;
          localMenuItem.c = localTencentDocMyFileNameBean.d;
        }
      }
      localMenuItem.b = this.jdField_b_of_type_ArrayOfInt[i];
      localArrayList.add(localMenuItem);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog = PopupMenuDialog.a(this, localArrayList, new FileAssistantActivity.4(this), null, AIOUtils.a(210.0F, getResources()));
    this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.setTouchInterceptor(new FileAssistantActivity.5(this));
  }
  
  private void t()
  {
    this.app.getQQProxyForQlink().a("0X800474E", 1);
    QQProxyForQlink.a(this, 2, null);
  }
  
  private void u()
  {
    Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
    localIntent.putExtra("tab_tab_type", 1);
    localIntent.putExtra("qfile_entrance_type_key", 8);
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("category", 15);
      localIntent.putExtra("bundle", localBundle);
      localIntent.putExtra("from", "FileAssistant");
      localIntent.putExtra("custom_title", getString(2131692362));
      startActivityForResult(localIntent, 101);
      if (this.l)
      {
        FileManagerReporter.a("0X8005538");
        return;
      }
      FileManagerReporter.a("0X800681E");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void v()
  {
    FileSearchActivity.a(this, "", new ArrayList(), false, 8);
  }
  
  private void w()
  {
    try
    {
      Intent localIntent = new Intent(getApplicationContext(), QQBrowserActivity.class);
      if (TextUtils.isEmpty(TencentDocConvertConfigProcessor.a().h())) {}
      for (String str1 = "https://docs.qq.com/desktop/m/index.html?_from=1";; str1 = TencentDocConvertConfigProcessor.a().h())
      {
        String str2 = TeamWorkUtils.b(str1, "s_qq_myfile");
        localIntent.putExtra("tdsourcetag", "s_qq_myfile");
        localIntent.putExtra("big_brother_source_key", "biz_src_jc_file");
        if (this.m)
        {
          str2 = TeamWorkUtils.b(str1, "s_qq_myfile_banner");
          localIntent.putExtra("tdsourcetag", "s_qq_myfile_banner");
          this.m = false;
        }
        localIntent.putExtra("fragment_class", TeamWorkDocsListFragment.class.getCanonicalName());
        if (TeamWorkDocEditBrowserActivity.a(this, str2, localIntent.getStringExtra("tdsourcetag"))) {
          break;
        }
        startActivity(localIntent.putExtra("url", str2));
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.i("FileAssistantActivity", 1, localException.toString());
    }
  }
  
  private void x()
  {
    try
    {
      Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putLong("category", 14L);
      localIntent.putExtra("bundle", localBundle);
      localIntent.putExtra("tab_tab_type", 3);
      localIntent.putExtra("from", "FileAssistant");
      startActivityForResult(localIntent, 101);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void y()
  {
    this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand = new WeiyunRemoteCommand();
    PluginCommunicationHandler.getInstance().register(this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand);
    WeiyunHelper.a(this.app.getApplication());
  }
  
  private void z()
  {
    Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
    localIntent.putExtra("tab_tab_type", 3);
    localIntent.putExtra("from", "FileAssistant");
    startActivityForResult(localIntent, 101);
  }
  
  public ListView a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
    }
    return null;
  }
  
  public void a(Set<FileInfo> paramSet)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(paramSet);
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
  }
  
  public void b(ArrayList<FileManagerEntity> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(paramArrayList);
  }
  
  public void c(ArrayList<WeiYunFileInfo> paramArrayList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.c(paramArrayList);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    if (this.jdField_a_of_type_AndroidViewViewStub != null) {
      this.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null) && ((paramIntent.getBooleanExtra("foward_editbar", false) == true) || (paramIntent.getBooleanExtra("destroy_last_activity", false) == true)) && (paramInt2 == 4))
    {
      Intent localIntent = AIOUtils.a(new Intent(this, SplashActivity.class), new int[] { 2 });
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      startActivity(localIntent);
      finish();
    }
    if (paramInt1 == 10001) {
      WeiyunApi.a(this);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    int j = 0;
    super.doOnCreate(paramBundle);
    TdsReaderGlobal.a();
    setContentView(2131560899);
    ThreadManager.getFileThreadHandler().post(new FileAssistantActivity.1(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView = ((HeaderScrollView)findViewById(2131368385));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369372));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369380));
    this.d = ((TextView)findViewById(2131369447));
    this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(getApplicationContext(), this.d).b(53).d(10).a();
    n();
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369290));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetTextView.setOnClickListener(this);
    findViewById(2131378916).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon = ((NavBarCommon)findViewById(2131377159));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131692430));
    if (Build.VERSION.SDK_INT >= 21) {}
    int[] arrayOfInt;
    for (paramBundle = getDrawable(2130844411);; paramBundle = getResources().getDrawable(2130844411))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setOnItemSelectListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setRightImage(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setRightImageDesc(HardCodeUtil.a(2131704512));
      this.jdField_c_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon).b(53).d(5).e(10).a();
      o();
      p();
      m();
      this.app.getFileManagerNotifyCenter().addObserver(this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
      y();
      B();
      this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      if (SharedPreUtils.aT(this, this.app.getCurrentAccountUin()) == 1)
      {
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).preloadMiniProcess();
        if (QLog.isColorLevel()) {
          QLog.d("FileAssistantActivity", 2, "doOnCreate, preload mini app process");
        }
      }
      this.l = getIntent().getBooleanExtra("COMEFROMDESK", false);
      paramBundle = new FileManagerReporter.FileAssistantReportData();
      paramBundle.b = "file_asst_in";
      paramBundle.jdField_a_of_type_Int = 11;
      FileManagerReporter.a(this.app.getCurrentAccountUin(), paramBundle);
      if (FileManagerUtil.a(this, getString(2131692365))) {
        break label561;
      }
      paramBundle = new int[this.jdField_a_of_type_ArrayOfInt.length + 1];
      arrayOfInt = new int[this.jdField_b_of_type_ArrayOfInt.length + 1];
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        paramBundle[i] = this.jdField_a_of_type_ArrayOfInt[i];
        i += 1;
      }
    }
    paramBundle[(paramBundle.length - 1)] = 2131692408;
    this.jdField_a_of_type_ArrayOfInt = paramBundle;
    int i = j;
    while (i < this.jdField_b_of_type_ArrayOfInt.length)
    {
      arrayOfInt[i] = this.jdField_b_of_type_ArrayOfInt[i];
      i += 1;
    }
    arrayOfInt[(arrayOfInt.length - 1)] = 2130844467;
    this.jdField_b_of_type_ArrayOfInt = arrayOfInt;
    label561:
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.c();
    if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.app.getFileManagerNotifyCenter().deleteObserver(this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.n = true;
    this.jdField_a_of_type_CooperationWeiyunWeiyunRemoteCommand.a(null);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.rightViewText.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131692430));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
    this.jdField_f_of_type_AndroidWidgetTextView.setText(2131691168);
    B();
    b();
  }
  
  public void j()
  {
    if (this.jdField_f_of_type_AndroidWidgetTextView != null)
    {
      if (f()) {
        this.jdField_f_of_type_AndroidWidgetTextView.setText(2131690800);
      }
    }
    else {
      return;
    }
    this.jdField_f_of_type_AndroidWidgetTextView.setText(2131691168);
  }
  
  protected void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView = ((QfileTabBarView)findViewById(2131366935));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setAttribution(1);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setHeaderScrollView(this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseHeaderScrollView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(3, getString(2131692625));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(4, getString(2131692627));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(20, this.jdField_f_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(5, getString(2131692631));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(6, getString(2131692628));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(7, getString(2131692626));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(3);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    int i = paramView.getId();
    if (i == 2131369290)
    {
      i();
      if (f())
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setText(2131690800);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131692430));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
        this.rightViewText.setVisibility(8);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      FileManagerReporter.a("0X8009C32");
      this.jdField_f_of_type_AndroidWidgetTextView.setText(2131691168);
      break;
      if (i == 2131369372)
      {
        if (!CheckPermission.isHasStoragePermission(this)) {
          CheckPermission.requestSDCardPermission(this, new FileAssistantActivity.6(this));
        } else {
          u();
        }
      }
      else
      {
        Object localObject;
        if (i == 2131369380)
        {
          localObject = new Bundle();
          ((Bundle)localObject).putBoolean("string_from", false);
          ((Bundle)localObject).putBoolean("string_uin", false);
          ((Bundle)localObject).putLong("device_din", 0L);
          ((Bundle)localObject).putInt("sTitleID", 0);
          QQProxyForDataline.a(this, (Bundle)localObject, "com.qqdataline.mpfile.LiteMpFileMainActivity");
          if (this.l) {
            FileManagerReporter.a("0X8005539");
          } else {
            FileManagerReporter.a("0X800681F");
          }
        }
        else
        {
          if (i == 2131369447)
          {
            i = SharedPreUtils.aT(this, this.app.getCurrentAccountUin());
            if (i == 1)
            {
              localObject = SharedPreUtils.t(this, this.app.getCurrentAccountUin());
              i = SharedPreUtils.aU(this, this.app.getCurrentAccountUin());
              if (TextUtils.isEmpty((CharSequence)localObject)) {}
            }
            for (;;)
            {
              try
              {
                a(this, (String)localObject, i);
                if (!this.l) {
                  break label398;
                }
                FileManagerReporter.a("0X800553A");
                a(this.jdField_a_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo, "100160.100164");
              }
              catch (MiniAppException localMiniAppException)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("FileAssistantActivity", 2, "fail to open weiyun mini app!");
                }
                A();
                continue;
              }
              QLog.w("FileAssistantActivity", 2, "can not to start WeiYun Mini app, apkgUrl = " + localMiniAppException + ", version = " + i);
              A();
              continue;
              QLog.w("FileAssistantActivity", 2, "can not to start WeiYun Mini app, weiYunGrayConfig = " + i);
              A();
              continue;
              label398:
              FileManagerReporter.a("0X8006820");
            }
          }
          if (i == 2131369289)
          {
            FileManagerReporter.a("0X8009070");
            w();
            VoiceInputHelper.a(getAppInterface());
            a(this.jdField_b_of_type_ComTencentMobileqqTianshuPbBusinessInfoCheckUpdate$AppInfo, "100160.100163");
          }
          else if (i == 2131369841)
          {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantTipsConfig.b();
            r();
          }
          else if (i == 2131380649)
          {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerApiIFileAssistantTipsConfig.c();
            IFileAssistantTipsConfig.IBaseJump localIBaseJump = ((IQFileConfigManager)this.app.getRuntimeService(IQFileConfigManager.class, "")).getFileAssistantTipsConfig().a();
            if (localIBaseJump != null) {
              localIBaseJump.a(this);
            }
            r();
          }
          else if (i == 2131378916)
          {
            FileManagerReporter.a("0X8009C33");
            v();
          }
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (paramInt == 5)
    {
      if (this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog == null) {
        s();
      }
      paramInt = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.getWidth();
      int i = this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.getWidth();
      int j = getResources().getDimensionPixelSize(2131298894);
      this.jdField_a_of_type_ComTencentWidgetPopupMenuDialog.showAsDropDown(this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon, paramInt - i - j, 0);
      ReportController.b(this.app, "dc00898", "", "", "0X800A15E", "0X800A15E", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if (paramInt == 4)
      {
        i();
        this.rightViewText.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131692430));
        return;
      }
    } while (paramInt != 1);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity
 * JD-Core Version:    0.7.0.1
 */