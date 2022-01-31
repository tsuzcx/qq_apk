package com.tencent.mobileqq.filemanager.activity.fileassistant;

import aepi;
import alud;
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
import aotg;
import aoth;
import aoxf;
import aoxg;
import aoye;
import aoyf;
import apjp;
import aqpb;
import aqpc;
import aqpd;
import aqpe;
import aqpf;
import aqpg;
import aqph;
import aqpi;
import aqru;
import aqsb;
import aqud;
import aqwn;
import arri;
import arrp;
import arrq;
import arrr;
import avva;
import axlx;
import azqs;
import baic;
import bdin;
import bdne;
import bexc;
import bhzx;
import biaa;
import bisq;
import biun;
import bkjs;
import bkjw;
import bkkk;
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
  implements bexc
{
  public Handler a;
  ViewStub jdField_a_of_type_AndroidViewViewStub = null;
  aotg jdField_a_of_type_Aotg;
  private avva jdField_a_of_type_Avva = new aqpi(this);
  public bhzx a;
  private bkjw jdField_a_of_type_Bkjw;
  HeaderScrollView jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView;
  public QfileTabBarView a;
  RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  NavBarCommon jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon;
  BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private int[] jdField_a_of_type_ArrayOfInt = { 2131692732, 2131698692, 2131721433, 2131720743 };
  private ViewStub jdField_b_of_type_AndroidViewViewStub;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private aqru jdField_b_of_type_Aqru = new aqpg(this);
  RedTouch jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch;
  BusinessInfoCheckUpdate.AppInfo jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private int[] jdField_b_of_type_ArrayOfInt = { 2130843918, 2130843919, 2130843924, 2130843965 };
  TextView jdField_c_of_type_AndroidWidgetTextView;
  RedTouch jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch;
  public BusinessInfoCheckUpdate.AppInfo c;
  TextView d;
  TextView e;
  TextView f;
  private String g = alud.a(2131704877);
  public boolean j = false;
  boolean k = false;
  private volatile boolean l;
  
  public FileAssistantActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView = null;
    this.jdField_a_of_type_AndroidOsHandler = new aqph(this, Looper.getMainLooper());
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
    axlx localaxlx;
    if (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      localaxlx = (axlx)this.app.getManager(36);
      if (localaxlx != null) {
        break label25;
      }
    }
    label25:
    do
    {
      return;
      this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = localaxlx.a(1, "100160.100163");
      QLog.i("FileAssistantActivity", 1, "fileRedTouch updateDocsFileRedTouch info = " + this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    } while (this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo == null);
    localaxlx.b(this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, null);
  }
  
  private void C()
  {
    axlx localaxlx;
    if (this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      localaxlx = (axlx)this.app.getManager(36);
      if (localaxlx != null) {
        break label25;
      }
    }
    label25:
    do
    {
      return;
      this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = localaxlx.a(1, "100160.100162");
      QLog.i("FileAssistantActivity", 1, "fileRedTouch updateWeiyunBackupRedTouch info = " + this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    } while (this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo == null);
    localaxlx.b(this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, null);
  }
  
  private void D()
  {
    axlx localaxlx;
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      localaxlx = (axlx)this.app.getManager(36);
      if (localaxlx != null) {
        break label25;
      }
    }
    label25:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = localaxlx.a(1, "100160.100164");
      QLog.i("FileAssistantActivity", 1, "fileRedTouch updateWeiyunFileRedTouch info = " + this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    } while (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo == null);
    localaxlx.b(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, null);
  }
  
  private void a(FileAssistantActivity paramFileAssistantActivity, String paramString, int paramInt)
  {
    MiniAppLauncher.startMiniApp(this, "mqqapi://miniapp/open?_ext=&_mappid=1107999468&_mvid=&_nq=&_path=&_q=&referer=2011&via=2011&_sig=31ba7125a22d3462e9dc4f8abff74d9e9c445cdd46e8ea446f39a839ebb110b4", 2011, null);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    QLog.i("FileAssistantActivity", 1, " fileRedTouch deleteRedTouch path = " + paramString);
    axlx localaxlx = (axlx)this.app.getManager(36);
    if (paramAppInfo == null)
    {
      localaxlx.b(paramString);
      return;
    }
    localaxlx.a(paramAppInfo, null);
  }
  
  private void n()
  {
    this.e = ((TextView)findViewById(2131368488));
    this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(getApplicationContext(), this.e).a(53).c(10).a();
    this.e.setOnClickListener(this);
    azqs.b(this.app, "dc00898", "", "", "0X800906F", "0X800906F", 0, 0, "", "", "", "");
  }
  
  private void o()
  {
    aoye localaoye = aoyf.a();
    if (localaoye != null)
    {
      this.e.setText(localaoye.jdField_a_of_type_JavaLangString);
      this.d.setText(localaoye.b);
      this.g = localaoye.c;
    }
  }
  
  private void p()
  {
    if ((this.jdField_a_of_type_Aotg == null) || (!this.jdField_a_of_type_Aotg.a()))
    {
      QLog.i("FileAssistantActivity", 1, "FileAssistantTips is switch off");
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_Aotg.a()))
    {
      QLog.i("FileAssistantActivity", 1, "FileAssistantTips not ready, textContent is null");
      return;
    }
    this.jdField_b_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131365909));
    this.jdField_b_of_type_AndroidViewViewStub.inflate();
    TextView localTextView1 = (TextView)findViewById(2131379041);
    TextView localTextView2 = (TextView)findViewById(2131379042);
    ImageView localImageView = (ImageView)findViewById(2131368943);
    localTextView1.setText(this.jdField_a_of_type_Aotg.a());
    localTextView2.setText(this.jdField_a_of_type_Aotg.b());
    localTextView2.setOnClickListener(this);
    localImageView.setOnClickListener(this);
    this.jdField_a_of_type_Aotg.a();
  }
  
  private void q()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.jdField_b_of_type_AndroidViewViewStub.getHeight(), 0 });
    localValueAnimator.setDuration(300L);
    localValueAnimator.addUpdateListener(new aqpb(this));
    localValueAnimator.addListener(new aqpc(this));
    localValueAnimator.start();
  }
  
  private void r()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      if (this.jdField_a_of_type_ArrayOfInt[i] == 2131721433) {}
      biaa localbiaa = new biaa();
      localbiaa.jdField_a_of_type_Int = i;
      localbiaa.jdField_a_of_type_JavaLangString = getString(this.jdField_a_of_type_ArrayOfInt[i]);
      localbiaa.c = localbiaa.jdField_a_of_type_JavaLangString;
      if (i == 3)
      {
        aoye localaoye = aoyf.a();
        if ((localaoye != null) && (!TextUtils.isEmpty(localaoye.d)))
        {
          localbiaa.jdField_a_of_type_JavaLangString = localaoye.d;
          localbiaa.c = localaoye.d;
        }
      }
      localbiaa.b = this.jdField_b_of_type_ArrayOfInt[i];
      localArrayList.add(localbiaa);
      i += 1;
    }
    this.jdField_a_of_type_Bhzx = bhzx.a(this, localArrayList, new aqpd(this), null, aepi.a(210.0F, getResources()));
    this.jdField_a_of_type_Bhzx.setTouchInterceptor(new aqpe(this));
  }
  
  private void s()
  {
    this.app.a().a("0X800474E", 1);
    bisq.a(this, 2, null);
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
      localIntent.putExtra("custom_title", getString(2131692502));
      startActivityForResult(localIntent, 101);
      if (this.j)
      {
        arrp.a("0X8005538");
        return;
      }
      arrp.a("0X800681E");
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
      if (TextUtils.isEmpty(aoxg.a().h())) {}
      for (String str1 = "https://docs.qq.com/desktop/m/index.html?_from=1";; str1 = aoxg.a().h())
      {
        String str2 = baic.b(str1, "s_qq_myfile");
        localIntent.putExtra("tdsourcetag", "s_qq_myfile");
        localIntent.putExtra("big_brother_source_key", "biz_src_jc_file");
        if (this.k)
        {
          str2 = baic.b(str1, "s_qq_myfile_banner");
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
    this.jdField_a_of_type_Bkjw = new bkjw();
    PluginCommunicationHandler.getInstance().register(this.jdField_a_of_type_Bkjw);
    bkjs.a(this.app.getApplication());
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
    if (bdin.d(BaseApplication.getContext()))
    {
      Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
      localIntent.putExtra("tab_tab_type", 3);
      localIntent.putExtra("from", "FileAssistant");
      startActivityForResult(localIntent, 101);
      return;
    }
    arri.a(BaseApplication.getContext().getString(2131694766));
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
      if (this.jdField_a_of_type_Bhzx == null) {
        r();
      }
      paramInt = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.getWidth();
      int i = this.jdField_a_of_type_Bhzx.getWidth();
      int m = getResources().getDimensionPixelSize(2131298643);
      this.jdField_a_of_type_Bhzx.showAsDropDown(this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon, paramInt - i - m, 0);
      azqs.b(this.app, "dc00898", "", "", "0X800A15E", "0X800A15E", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if (paramInt == 4)
      {
        i();
        this.rightViewText.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131692569));
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
      Intent localIntent = aepi.a(new Intent(this, SplashActivity.class), new int[] { 2 });
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      startActivity(localIntent);
      finish();
    }
    if (paramInt1 == 10001) {
      bkkk.a(this);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    int m = 0;
    super.doOnCreate(paramBundle);
    TdsReaderGlobal.a();
    setContentView(2131560637);
    ThreadManager.getFileThreadHandler().post(new FileAssistantActivity.1(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView = ((HeaderScrollView)findViewById(2131367619));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368532));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368540));
    this.d = ((TextView)findViewById(2131368593));
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(getApplicationContext(), this.d).a(53).c(10).a();
    n();
    this.f = ((TextView)findViewById(2131368489));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.f.setOnClickListener(this);
    findViewById(2131377443).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon = ((NavBarCommon)findViewById(2131375863));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131692569));
    if (Build.VERSION.SDK_INT >= 21) {}
    int[] arrayOfInt;
    for (paramBundle = getDrawable(2130843867);; paramBundle = getResources().getDrawable(2130843867))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setOnItemSelectListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setRightImage(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setRightImageDesc(alud.a(2131704879));
      this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon).a(53).c(5).d(10).a();
      o();
      m();
      this.app.a().addObserver(this.jdField_b_of_type_Aqru);
      x();
      A();
      this.app.registObserver(this.jdField_a_of_type_Avva);
      if (bdne.aS(this, this.app.getCurrentAccountUin()) == 1)
      {
        MiniAppController.preloadMiniProcess();
        if (QLog.isColorLevel()) {
          QLog.d("FileAssistantActivity", 2, "doOnCreate, preload mini app process");
        }
      }
      this.j = getIntent().getBooleanExtra("COMEFROMDESK", false);
      paramBundle = new arrq();
      paramBundle.b = "file_asst_in";
      paramBundle.jdField_a_of_type_Int = 11;
      arrp.a(this.app.getCurrentAccountUin(), paramBundle);
      if (arrr.a(this, getString(2131692505))) {
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
    paramBundle[(paramBundle.length - 1)] = 2131692547;
    this.jdField_a_of_type_ArrayOfInt = paramBundle;
    int i = m;
    while (i < this.jdField_b_of_type_ArrayOfInt.length)
    {
      arrayOfInt[i] = this.jdField_b_of_type_ArrayOfInt[i];
      i += 1;
    }
    arrayOfInt[(arrayOfInt.length - 1)] = 2130843920;
    this.jdField_b_of_type_ArrayOfInt = arrayOfInt;
    label547:
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    if (this.jdField_b_of_type_Aqru != null) {
      this.app.a().deleteObserver(this.jdField_b_of_type_Aqru);
    }
    this.app.unRegistObserver(this.jdField_a_of_type_Avva);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.l = true;
    this.jdField_a_of_type_Bkjw.a(null);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.rightViewText.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131692569));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
    this.f.setText(2131691118);
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
    this.f.setText(2131691118);
  }
  
  protected void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView = ((QfileTabBarView)findViewById(2131366318));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setAttribution(1);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setHeaderScrollView(this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(3, getString(2131692770));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(4, getString(2131692772));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(20, this.g);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(5, getString(2131692776));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(6, getString(2131692773));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(7, getString(2131692771));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(3);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    int i = paramView.getId();
    if (i == 2131368489)
    {
      i();
      if (f())
      {
        this.f.setText(2131690648);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131692569));
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
        arrp.a("0X8009C32");
        this.f.setText(2131691118);
        break;
        if (i == 2131368532)
        {
          if (!CheckPermission.isHasStoragePermission(this))
          {
            CheckPermission.requestSDCardPermission(this, new aqpf(this));
            return;
          }
          t();
          return;
        }
        if (i == 2131368540)
        {
          paramView = new Bundle();
          paramView.putBoolean("string_from", false);
          paramView.putBoolean("string_uin", false);
          paramView.putLong("device_din", 0L);
          paramView.putInt("sTitleID", 0);
          biun.a(this, paramView, "com.qqdataline.mpfile.LiteMpFileMainActivity");
          if (this.j)
          {
            arrp.a("0X8005539");
            return;
          }
          arrp.a("0X800681F");
          return;
        }
        if (i == 2131368593)
        {
          i = bdne.aS(this, this.app.getCurrentAccountUin());
          if (i == 1)
          {
            paramView = bdne.u(this, this.app.getCurrentAccountUin());
            i = bdne.aT(this, this.app.getCurrentAccountUin());
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
              arrp.a("0X800553A");
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
            arrp.a("0X8006820");
          }
        }
        if (i == 2131368488)
        {
          arrp.a("0X8009070");
          v();
          apjp.a(getAppInterface());
          a(this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, "100160.100163");
          return;
        }
        if (i == 2131368943)
        {
          this.jdField_a_of_type_Aotg.b();
          q();
          return;
        }
        if (i != 2131379042) {
          break label499;
        }
        this.jdField_a_of_type_Aotg.c();
        paramView = (aqud)this.app.getManager(317);
      } while (paramView == null);
      paramView.a().a().a(this);
      q();
      return;
    } while (i != 2131377443);
    label499:
    arrp.a("0X8009C33");
    u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity
 * JD-Core Version:    0.7.0.1
 */