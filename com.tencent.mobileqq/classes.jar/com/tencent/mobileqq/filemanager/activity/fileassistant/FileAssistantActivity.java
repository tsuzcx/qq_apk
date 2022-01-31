package com.tencent.mobileqq.filemanager.activity.fileassistant;

import aekt;
import alpo;
import android.animation.ValueAnimator;
import android.content.Intent;
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
import aoox;
import aooy;
import aosw;
import aosx;
import aotv;
import aotw;
import apfg;
import aqks;
import aqkt;
import aqku;
import aqkv;
import aqkw;
import aqkx;
import aqky;
import aqkz;
import aqnl;
import aqns;
import aqpu;
import aqse;
import armz;
import arng;
import arnh;
import arni;
import avqr;
import axho;
import azmj;
import badt;
import bdee;
import bdiv;
import best;
import bhvq;
import bhvt;
import bioj;
import biqg;
import bkfl;
import bkfp;
import bkgd;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.contacts.view.HeaderScrollView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.data.search.FileSearchActivity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TdsReaderGlobal;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class FileAssistantActivity
  extends BaseFileAssistantActivity
  implements best
{
  public Handler a;
  ViewStub jdField_a_of_type_AndroidViewViewStub = null;
  aoox jdField_a_of_type_Aoox;
  private avqr jdField_a_of_type_Avqr = new aqkz(this);
  public bhvq a;
  private bkfp jdField_a_of_type_Bkfp;
  HeaderScrollView jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView;
  public QfileTabBarView a;
  RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  NavBarCommon jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon;
  BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private int[] jdField_a_of_type_ArrayOfInt = { 2131692730, 2131698680, 2131721420, 2131720731 };
  private ViewStub jdField_b_of_type_AndroidViewViewStub;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private aqnl jdField_b_of_type_Aqnl = new aqkx(this);
  RedTouch jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch;
  BusinessInfoCheckUpdate.AppInfo jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private int[] jdField_b_of_type_ArrayOfInt = { 2130843846, 2130843847, 2130843852, 2130843893 };
  TextView jdField_c_of_type_AndroidWidgetTextView;
  RedTouch jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch;
  public BusinessInfoCheckUpdate.AppInfo c;
  TextView d;
  TextView e;
  TextView f;
  private String g = alpo.a(2131704865);
  public boolean j = false;
  boolean k = false;
  private volatile boolean l;
  
  public FileAssistantActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView = null;
    this.jdField_a_of_type_AndroidOsHandler = new aqky(this, Looper.getMainLooper());
  }
  
  private void A()
  {
    QLog.i("FileAssistantActivity", 1, "fileRedTouch updateAllRedTouch");
    B();
    D();
    C();
  }
  
  private void B()
  {
    axho localaxho;
    if (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      localaxho = (axho)this.app.getManager(36);
      if (localaxho != null) {
        break label25;
      }
    }
    label25:
    do
    {
      return;
      this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = localaxho.a(1, "100160.100163");
      QLog.i("FileAssistantActivity", 1, "fileRedTouch updateDocsFileRedTouch info = " + this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    } while (this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo == null);
    localaxho.b(this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, null);
  }
  
  private void C()
  {
    axho localaxho;
    if (this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      localaxho = (axho)this.app.getManager(36);
      if (localaxho != null) {
        break label25;
      }
    }
    label25:
    do
    {
      return;
      this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = localaxho.a(1, "100160.100162");
      QLog.i("FileAssistantActivity", 1, "fileRedTouch updateWeiyunBackupRedTouch info = " + this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    } while (this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo == null);
    localaxho.b(this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, null);
  }
  
  private void D()
  {
    axho localaxho;
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      localaxho = (axho)this.app.getManager(36);
      if (localaxho != null) {
        break label25;
      }
    }
    label25:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = localaxho.a(1, "100160.100164");
      QLog.i("FileAssistantActivity", 1, "fileRedTouch updateWeiyunFileRedTouch info = " + this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    } while (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo == null);
    localaxho.b(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, null);
  }
  
  private void a(FileAssistantActivity paramFileAssistantActivity, String paramString, int paramInt)
  {
    MiniAppLauncher.startMiniApp(this, "mqqapi://miniapp/open?_ext=&_mappid=1107999468&_mvid=&_nq=&_path=&_q=&referer=2011&via=2011&_sig=31ba7125a22d3462e9dc4f8abff74d9e9c445cdd46e8ea446f39a839ebb110b4", 2011, null);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    QLog.i("FileAssistantActivity", 1, " fileRedTouch deleteRedTouch path = " + paramString);
    axho localaxho = (axho)this.app.getManager(36);
    if (paramAppInfo == null)
    {
      localaxho.b(paramString);
      return;
    }
    localaxho.a(paramAppInfo, null);
  }
  
  private void n()
  {
    this.e = ((TextView)findViewById(2131368477));
    this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(getApplicationContext(), this.e).a(53).c(10).a();
    this.e.setOnClickListener(this);
    azmj.b(this.app, "dc00898", "", "", "0X800906F", "0X800906F", 0, 0, "", "", "", "");
  }
  
  private void o()
  {
    aotv localaotv = aotw.a();
    if (localaotv != null)
    {
      this.e.setText(localaotv.jdField_a_of_type_JavaLangString);
      this.d.setText(localaotv.b);
      this.g = localaotv.c;
    }
  }
  
  private void p()
  {
    if ((this.jdField_a_of_type_Aoox == null) || (!this.jdField_a_of_type_Aoox.a()))
    {
      QLog.i("FileAssistantActivity", 1, "FileAssistantTips is switch off");
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_Aoox.a()))
    {
      QLog.i("FileAssistantActivity", 1, "FileAssistantTips not ready, textContent is null");
      return;
    }
    this.jdField_b_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131365907));
    this.jdField_b_of_type_AndroidViewViewStub.inflate();
    TextView localTextView1 = (TextView)findViewById(2131378983);
    TextView localTextView2 = (TextView)findViewById(2131378984);
    ImageView localImageView = (ImageView)findViewById(2131368925);
    localTextView1.setText(this.jdField_a_of_type_Aoox.a());
    localTextView2.setText(this.jdField_a_of_type_Aoox.b());
    localTextView2.setOnClickListener(this);
    localImageView.setOnClickListener(this);
    this.jdField_a_of_type_Aoox.a();
  }
  
  private void q()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.jdField_b_of_type_AndroidViewViewStub.getHeight(), 0 });
    localValueAnimator.setDuration(300L);
    localValueAnimator.addUpdateListener(new aqks(this));
    localValueAnimator.addListener(new aqkt(this));
    localValueAnimator.start();
  }
  
  private void r()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      if (this.jdField_a_of_type_ArrayOfInt[i] == 2131721420) {}
      bhvt localbhvt = new bhvt();
      localbhvt.jdField_a_of_type_Int = i;
      localbhvt.jdField_a_of_type_JavaLangString = getString(this.jdField_a_of_type_ArrayOfInt[i]);
      localbhvt.c = localbhvt.jdField_a_of_type_JavaLangString;
      if (i == 3)
      {
        aotv localaotv = aotw.a();
        if ((localaotv != null) && (!TextUtils.isEmpty(localaotv.d)))
        {
          localbhvt.jdField_a_of_type_JavaLangString = localaotv.d;
          localbhvt.c = localaotv.d;
        }
      }
      localbhvt.b = this.jdField_b_of_type_ArrayOfInt[i];
      localArrayList.add(localbhvt);
      i += 1;
    }
    this.jdField_a_of_type_Bhvq = bhvq.a(this, localArrayList, new aqku(this), null, aekt.a(210.0F, getResources()));
    this.jdField_a_of_type_Bhvq.setTouchInterceptor(new aqkv(this));
  }
  
  private void s()
  {
    this.app.a().a("0X800474E", 1);
    bioj.a(this, 2, null);
  }
  
  private void t()
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
      localIntent.putExtra("custom_title", getString(2131692501));
      startActivityForResult(localIntent, 101);
      if (this.j)
      {
        arng.a("0X8005538");
        return;
      }
      arng.a("0X800681E");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void u()
  {
    FileSearchActivity.a(this, "", new ArrayList(), false, 8);
  }
  
  private void v()
  {
    try
    {
      Intent localIntent = new Intent(getApplicationContext(), QQBrowserActivity.class);
      if (TextUtils.isEmpty(aosx.a().h())) {}
      for (String str1 = "https://docs.qq.com/desktop/m/index.html?_from=1";; str1 = aosx.a().h())
      {
        String str2 = badt.b(str1, "s_qq_myfile");
        localIntent.putExtra("tdsourcetag", "s_qq_myfile");
        localIntent.putExtra("big_brother_source_key", "biz_src_jc_file");
        if (this.k)
        {
          str2 = badt.b(str1, "s_qq_myfile_banner");
          localIntent.putExtra("tdsourcetag", "s_qq_myfile_banner");
          this.k = false;
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
  
  private void w()
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
  
  private void x()
  {
    this.jdField_a_of_type_Bkfp = new bkfp();
    PluginCommunicationHandler.getInstance().register(this.jdField_a_of_type_Bkfp);
    bkfl.a(this.app.getApplication());
  }
  
  private void y()
  {
    Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
    localIntent.putExtra("tab_tab_type", 3);
    localIntent.putExtra("from", "FileAssistant");
    startActivityForResult(localIntent, 101);
  }
  
  private void z()
  {
    this.l = false;
    if (this.app.a().a() == true)
    {
      this.app.a().c();
      return;
    }
    if (bdee.d(BaseApplication.getContext()))
    {
      Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
      localIntent.putExtra("tab_tab_type", 3);
      localIntent.putExtra("from", "FileAssistant");
      startActivityForResult(localIntent, 101);
      return;
    }
    armz.a(BaseApplication.getContext().getString(2131694764));
  }
  
  public ListView a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
    }
    return null;
  }
  
  public void a(View paramView, int paramInt)
  {
    if (paramInt == 5)
    {
      if (this.jdField_a_of_type_Bhvq == null) {
        r();
      }
      paramInt = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.getWidth();
      int i = this.jdField_a_of_type_Bhvq.getWidth();
      int m = getResources().getDimensionPixelSize(2131298643);
      this.jdField_a_of_type_Bhvq.showAsDropDown(this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon, paramInt - i - m, 0);
      azmj.b(this.app, "dc00898", "", "", "0X800A15E", "0X800A15E", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if (paramInt == 4)
      {
        i();
        this.rightViewText.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131692568));
        return;
      }
    } while (paramInt != 1);
    finish();
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
    if (this.jdField_a_of_type_AndroidViewViewStub != null) {
      this.jdField_a_of_type_AndroidViewViewStub.setVisibility(8);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null) && ((paramIntent.getBooleanExtra("foward_editbar", false) == true) || (paramIntent.getBooleanExtra("destroy_last_activity", false) == true)) && (paramInt2 == 4))
    {
      Intent localIntent = aekt.a(new Intent(this, SplashActivity.class), new int[] { 2 });
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      startActivity(localIntent);
      finish();
    }
    if (paramInt1 == 10001) {
      bkgd.a(this);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    int m = 0;
    super.doOnCreate(paramBundle);
    TdsReaderGlobal.a();
    setContentView(2131560619);
    ThreadManager.getFileThreadHandler().post(new FileAssistantActivity.1(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView = ((HeaderScrollView)findViewById(2131367609));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368521));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368529));
    this.d = ((TextView)findViewById(2131368582));
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(getApplicationContext(), this.d).a(53).c(10).a();
    n();
    this.f = ((TextView)findViewById(2131368478));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.f.setOnClickListener(this);
    findViewById(2131377389).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon = ((NavBarCommon)findViewById(2131375812));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131692568));
    if (Build.VERSION.SDK_INT >= 21) {}
    int[] arrayOfInt;
    for (paramBundle = getDrawable(2130843795);; paramBundle = getResources().getDrawable(2130843795))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setOnItemSelectListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setRightImage(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setRightImageDesc(alpo.a(2131704867));
      this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon).a(53).c(5).d(10).a();
      o();
      m();
      this.app.a().addObserver(this.jdField_b_of_type_Aqnl);
      x();
      A();
      this.app.registObserver(this.jdField_a_of_type_Avqr);
      if (bdiv.aS(this, this.app.getCurrentAccountUin()) == 1)
      {
        MiniAppController.preloadMiniProcess();
        if (QLog.isColorLevel()) {
          QLog.d("FileAssistantActivity", 2, "doOnCreate, preload mini app process");
        }
      }
      this.j = getIntent().getBooleanExtra("COMEFROMDESK", false);
      paramBundle = new arnh();
      paramBundle.b = "file_asst_in";
      paramBundle.jdField_a_of_type_Int = 11;
      arng.a(this.app.getCurrentAccountUin(), paramBundle);
      if (arni.a(this, getString(2131692504))) {
        break label547;
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
    paramBundle[(paramBundle.length - 1)] = 2131692546;
    this.jdField_a_of_type_ArrayOfInt = paramBundle;
    int i = m;
    while (i < this.jdField_b_of_type_ArrayOfInt.length)
    {
      arrayOfInt[i] = this.jdField_b_of_type_ArrayOfInt[i];
      i += 1;
    }
    arrayOfInt[(arrayOfInt.length - 1)] = 2130843848;
    this.jdField_b_of_type_ArrayOfInt = arrayOfInt;
    label547:
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    if (this.jdField_b_of_type_Aqnl != null) {
      this.app.a().deleteObserver(this.jdField_b_of_type_Aqnl);
    }
    this.app.unRegistObserver(this.jdField_a_of_type_Avqr);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.l = true;
    this.jdField_a_of_type_Bkfp.a(null);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.rightViewText.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131692568));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
    this.f.setText(2131691117);
    A();
    b();
  }
  
  public void j()
  {
    if (this.f != null)
    {
      if (f()) {
        this.f.setText(2131690648);
      }
    }
    else {
      return;
    }
    this.f.setText(2131691117);
  }
  
  protected void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView = ((QfileTabBarView)findViewById(2131366316));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setAttribution(1);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setHeaderScrollView(this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(3, getString(2131692768));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(4, getString(2131692770));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(20, this.g);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(5, getString(2131692774));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(6, getString(2131692771));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(7, getString(2131692769));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(3);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    int i = paramView.getId();
    if (i == 2131368478)
    {
      i();
      if (f())
      {
        this.f.setText(2131690648);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131692568));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
        this.rightViewText.setVisibility(8);
      }
    }
    label381:
    do
    {
      do
      {
        return;
        arng.a("0X8009C32");
        this.f.setText(2131691117);
        break;
        if (i == 2131368521)
        {
          if (!CheckPermission.isHasStoragePermission(this))
          {
            CheckPermission.requestSDCardPermission(this, new aqkw(this));
            return;
          }
          t();
          return;
        }
        if (i == 2131368529)
        {
          paramView = new Bundle();
          paramView.putBoolean("string_from", false);
          paramView.putBoolean("string_uin", false);
          paramView.putLong("device_din", 0L);
          paramView.putInt("sTitleID", 0);
          biqg.a(this, paramView, "com.qqdataline.mpfile.LiteMpFileMainActivity");
          if (this.j)
          {
            arng.a("0X8005539");
            return;
          }
          arng.a("0X800681F");
          return;
        }
        if (i == 2131368582)
        {
          i = bdiv.aS(this, this.app.getCurrentAccountUin());
          if (i == 1)
          {
            paramView = bdiv.u(this, this.app.getCurrentAccountUin());
            i = bdiv.aT(this, this.app.getCurrentAccountUin());
            if (TextUtils.isEmpty(paramView)) {}
          }
          for (;;)
          {
            try
            {
              a(this, paramView, i);
              if (!this.j) {
                break label381;
              }
              arng.a("0X800553A");
              a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, "100160.100164");
              return;
            }
            catch (MiniAppException paramView)
            {
              if (QLog.isColorLevel()) {
                QLog.e("FileAssistantActivity", 2, "fail to open weiyun mini app!");
              }
              z();
              continue;
            }
            QLog.w("FileAssistantActivity", 2, "can not to start WeiYun Mini app, apkgUrl = " + paramView + ", version = " + i);
            z();
            continue;
            QLog.w("FileAssistantActivity", 2, "can not to start WeiYun Mini app, weiYunGrayConfig = " + i);
            z();
            continue;
            arng.a("0X8006820");
          }
        }
        if (i == 2131368477)
        {
          arng.a("0X8009070");
          v();
          apfg.a(getAppInterface());
          a(this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, "100160.100163");
          return;
        }
        if (i == 2131368925)
        {
          this.jdField_a_of_type_Aoox.b();
          q();
          return;
        }
        if (i != 2131378984) {
          break label499;
        }
        this.jdField_a_of_type_Aoox.c();
        paramView = (aqpu)this.app.getManager(317);
      } while (paramView == null);
      paramView.a().a().a(this);
      q();
      return;
    } while (i != 2131377389);
    label499:
    arng.a("0X8009C33");
    u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity
 * JD-Core Version:    0.7.0.1
 */