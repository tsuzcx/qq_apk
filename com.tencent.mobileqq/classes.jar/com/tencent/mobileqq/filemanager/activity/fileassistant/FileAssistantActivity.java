package com.tencent.mobileqq.filemanager.activity.fileassistant;

import aciy;
import ajjy;
import amlc;
import amld;
import amlg;
import amlh;
import ammc;
import ammd;
import amxm;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import aoaw;
import aoax;
import aoay;
import aoaz;
import aoba;
import aobb;
import aobc;
import aobd;
import aodp;
import aodw;
import aoii;
import apbv;
import apcb;
import apci;
import apcj;
import apck;
import atdh;
import auqh;
import awqx;
import axfs;
import badq;
import baig;
import bbpw;
import bemi;
import beml;
import bffc;
import bfgz;
import bgtw;
import bgua;
import bguo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
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
import com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import cooperation.weiyun.AlbumBackupProxyActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class FileAssistantActivity
  extends BaseFileAssistantActivity
  implements bbpw
{
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  ViewStub jdField_a_of_type_AndroidViewViewStub = null;
  private atdh jdField_a_of_type_Atdh = new aobd(this);
  public bemi a;
  private bgua jdField_a_of_type_Bgua;
  HeaderScrollView jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView;
  public QfileTabBarView a;
  RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  NavBarCommon jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon;
  BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private int[] jdField_a_of_type_ArrayOfInt = { 2131627013, 2131632644, 2131654966, 2131654290 };
  private ViewStub jdField_b_of_type_AndroidViewViewStub;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private aodp jdField_b_of_type_Aodp = new aobb(this);
  RedTouch jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch;
  BusinessInfoCheckUpdate.AppInfo jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  private int[] jdField_b_of_type_ArrayOfInt = { 2130843402, 2130843403, 2130843408, 2130843449 };
  TextView jdField_c_of_type_AndroidWidgetTextView;
  RedTouch jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch;
  public BusinessInfoCheckUpdate.AppInfo c;
  TextView d;
  public int e;
  TextView e;
  public int f;
  TextView f;
  private String g = ajjy.a(2131638697);
  public boolean j = false;
  boolean k = false;
  private volatile boolean l;
  
  public FileAssistantActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView = null;
    this.jdField_a_of_type_AndroidOsHandler = new aobc(this, Looper.getMainLooper());
  }
  
  private void A()
  {
    auqh localauqh;
    if (this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      localauqh = (auqh)this.app.getManager(36);
      if (localauqh != null) {
        break label25;
      }
    }
    label25:
    do
    {
      return;
      this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = localauqh.a(1, "100160.100162");
      QLog.i("FileAssistantActivity", 1, "fileRedTouch updateWeiyunBackupRedTouch info = " + this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    } while (this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo == null);
    localauqh.b(this.jdField_c_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, null);
  }
  
  private void B()
  {
    auqh localauqh;
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      localauqh = (auqh)this.app.getManager(36);
      if (localauqh != null) {
        break label25;
      }
    }
    label25:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = localauqh.a(1, "100160.100164");
      QLog.i("FileAssistantActivity", 1, "fileRedTouch updateWeiyunFileRedTouch info = " + this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    } while (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo == null);
    localauqh.b(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, null);
  }
  
  private void a(URLImageView paramURLImageView)
  {
    ColorMatrix localColorMatrix = new ColorMatrix();
    localColorMatrix.set(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -10, 0.0F, 1.0F, 0.0F, 0.0F, -10, 0.0F, 0.0F, 1.0F, 0.0F, -10, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F });
    paramURLImageView.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
  }
  
  private void a(FileAssistantActivity paramFileAssistantActivity, String paramString, int paramInt)
  {
    MiniAppLauncher.startMiniApp(this, "mqqapi://miniapp/open?_ext=&_mappid=1107999468&_mvid=&_nq=&_path=&_q=&referer=2011&via=2011&_sig=31ba7125a22d3462e9dc4f8abff74d9e9c445cdd46e8ea446f39a839ebb110b4", 2011, null);
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    QLog.i("FileAssistantActivity", 1, " fileRedTouch deleteRedTouch path = " + paramString);
    auqh localauqh = (auqh)this.app.getManager(36);
    if (paramAppInfo == null)
    {
      localauqh.b(paramString);
      return;
    }
    localauqh.a(paramAppInfo, null);
  }
  
  private void a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5)
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131303688);
    TextView localTextView1 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131312244);
    TextView localTextView2 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131312245);
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131302886);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    localView.setOnClickListener(this);
    localView.setTag(paramString5);
    localTextView2.setText(paramString2);
    localTextView2.setOnClickListener(this);
    localTextView2.setTag(paramString4);
    localTextView1.setText(String.format(paramString1, new Object[] { Integer.valueOf(paramInt) }));
    awqx.b(this.app, "dc00898", "", "", paramString3, paramString3, 0, 0, "", "", "", "");
  }
  
  private String d()
  {
    Calendar localCalendar = Calendar.getInstance();
    return String.valueOf(localCalendar.get(1)) + localCalendar.get(2) + localCalendar.get(5);
  }
  
  private void n()
  {
    this.e = ((TextView)findViewById(2131302708));
    this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(getApplicationContext(), this.e).a(53).c(10).a();
    this.e.setOnClickListener(this);
    awqx.b(this.app, "dc00898", "", "", "0X800906F", "0X800906F", 0, 0, "", "", "", "");
  }
  
  private void o()
  {
    ammc localammc = ammd.a();
    if (localammc != null)
    {
      this.e.setText(localammc.jdField_a_of_type_JavaLangString);
      this.d.setText(localammc.b);
      this.g = localammc.c;
    }
  }
  
  private void p()
  {
    if (((apbv)this.app.getManager(281)).a())
    {
      apci.a("0X80093EE");
      this.jdField_b_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131311488));
      this.jdField_b_of_type_AndroidViewViewStub.inflate();
      View localView = findViewById(2131311449);
      localView.setOnClickListener(this);
      URLImageView localURLImageView = (URLImageView)findViewById(2131296271);
      String str = amld.a().e();
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLImageView.setImageDrawable(URLDrawable.getDrawable(new File(str), localURLDrawableOptions));
      localURLImageView.setOnTouchListener(new aoaw(this, localURLImageView, localView));
    }
  }
  
  private void q()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      beml localbeml = new beml();
      localbeml.jdField_a_of_type_Int = i;
      localbeml.jdField_a_of_type_JavaLangString = getString(this.jdField_a_of_type_ArrayOfInt[i]);
      localbeml.c = localbeml.jdField_a_of_type_JavaLangString;
      if (i == 3)
      {
        ammc localammc = ammd.a();
        if ((localammc != null) && (!TextUtils.isEmpty(localammc.d)))
        {
          localbeml.jdField_a_of_type_JavaLangString = localammc.d;
          localbeml.c = localammc.d;
        }
      }
      localbeml.b = this.jdField_b_of_type_ArrayOfInt[i];
      localArrayList.add(localbeml);
      i += 1;
    }
    this.jdField_a_of_type_Bemi = bemi.a(this, localArrayList, new aoax(this), null, aciy.a(210.0F, getResources()));
    this.jdField_a_of_type_Bemi.setTouchInterceptor(new aoay(this));
  }
  
  private void r()
  {
    this.app.a().a("0X800474E", 1);
    bffc.a(this, 2, null);
  }
  
  private void s()
  {
    FileSearchActivity.a(this, "", new ArrayList(), false, 8);
  }
  
  private void t()
  {
    try
    {
      Intent localIntent = new Intent(getApplicationContext(), QQBrowserActivity.class);
      if (TextUtils.isEmpty(amlh.a().h())) {}
      for (String str1 = "https://docs.qq.com/desktop/m/index.html?_from=1";; str1 = amlh.a().h())
      {
        String str2 = axfs.b(str1, "s_qq_myfile");
        localIntent.putExtra("tdsourcetag", "s_qq_myfile");
        localIntent.putExtra("big_brother_source_key", "biz_src_jc_file");
        if (this.k)
        {
          str2 = axfs.b(str1, "s_qq_myfile_banner");
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
  
  private void u()
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
  
  private void v()
  {
    this.jdField_a_of_type_Bgua = new bgua();
    PluginCommunicationHandler.getInstance().register(this.jdField_a_of_type_Bgua);
    bgtw.a(this.app.getApplication());
  }
  
  private void w()
  {
    Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
    localIntent.putExtra("tab_tab_type", 3);
    localIntent.putExtra("from", "FileAssistant");
    startActivityForResult(localIntent, 101);
  }
  
  private void x()
  {
    this.l = false;
    if (this.app.a().a() == true)
    {
      this.app.a().c();
      return;
    }
    if (badq.d(BaseApplication.getContext()))
    {
      Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
      localIntent.putExtra("tab_tab_type", 3);
      localIntent.putExtra("from", "FileAssistant");
      startActivityForResult(localIntent, 101);
      return;
    }
    apcb.a(BaseApplication.getContext().getString(2131628946));
  }
  
  private void y()
  {
    QLog.i("FileAssistantActivity", 1, "fileRedTouch updateAllRedTouch");
    z();
    B();
    A();
  }
  
  private void z()
  {
    auqh localauqh;
    if (this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      localauqh = (auqh)this.app.getManager(36);
      if (localauqh != null) {
        break label25;
      }
    }
    label25:
    do
    {
      return;
      this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo = localauqh.a(1, "100160.100163");
      QLog.i("FileAssistantActivity", 1, "fileRedTouch updateDocsFileRedTouch info = " + this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
      this.jdField_b_of_type_ComTencentMobileqqRedtouchRedTouch.a(this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo);
    } while (this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo == null);
    localauqh.b(this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, null);
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
      if (this.jdField_a_of_type_Bemi == null) {
        q();
      }
      paramInt = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.getWidth();
      int i = this.jdField_a_of_type_Bemi.getWidth();
      int m = getResources().getDimensionPixelSize(2131167522);
      this.jdField_a_of_type_Bemi.showAsDropDown(this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon, paramInt - i - m, 0);
      awqx.b(this.app, "dc00898", "", "", "0X800A15E", "0X800A15E", 0, 0, "", "", "", "");
    }
    do
    {
      return;
      if (paramInt == 4)
      {
        i();
        this.rightViewText.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131626878));
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
      Intent localIntent = aciy.a(new Intent(this, SplashActivity.class), new int[] { 2 });
      localIntent.putExtras(new Bundle(paramIntent.getExtras()));
      startActivity(localIntent);
      finish();
    }
    if (paramInt1 == 10001) {
      bguo.a(this);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    int m = 0;
    super.doOnCreate(paramBundle);
    TdsReaderGlobal.a();
    setContentView(2131494873);
    ThreadManager.getFileThreadHandler().post(new FileAssistantActivity.1(this));
    ThreadManager.getFileThreadHandler().post(new FileAssistantActivity.CheckAlbumRunnable(this, null));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView = ((HeaderScrollView)findViewById(2131301869));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302727));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302733));
    this.d = ((TextView)findViewById(2131302775));
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(getApplicationContext(), this.d).a(53).c(10).a();
    n();
    this.f = ((TextView)findViewById(2131302709));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.f.setOnClickListener(this);
    findViewById(2131311064).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon = ((NavBarCommon)findViewById(2131309578));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131626878));
    if (Build.VERSION.SDK_INT >= 21) {}
    int[] arrayOfInt;
    for (paramBundle = getDrawable(2130843353);; paramBundle = getResources().getDrawable(2130843353))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setOnItemSelectListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setRightImage(paramBundle);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setRightImageDesc(ajjy.a(2131638699));
      this.jdField_c_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon).a(53).c(5).d(10).a();
      o();
      m();
      this.app.a().addObserver(this.jdField_b_of_type_Aodp);
      v();
      p();
      y();
      this.app.registObserver(this.jdField_a_of_type_Atdh);
      if (baig.aR(this, this.app.getCurrentAccountUin()) == 1)
      {
        MiniAppController.preloadMiniProcess();
        if (QLog.isColorLevel()) {
          QLog.d("FileAssistantActivity", 2, "doOnCreate, preload mini app process");
        }
      }
      this.j = getIntent().getBooleanExtra("COMEFROMDESK", false);
      paramBundle = new apcj();
      paramBundle.b = "file_asst_in";
      paramBundle.jdField_a_of_type_Int = 11;
      apci.a(this.app.getCurrentAccountUin(), paramBundle);
      if (apck.a(this, getString(2131626826))) {
        break label567;
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
    paramBundle[(paramBundle.length - 1)] = 2131626856;
    this.jdField_a_of_type_ArrayOfInt = paramBundle;
    int i = m;
    while (i < this.jdField_b_of_type_ArrayOfInt.length)
    {
      arrayOfInt[i] = this.jdField_b_of_type_ArrayOfInt[i];
      i += 1;
    }
    arrayOfInt[(arrayOfInt.length - 1)] = 2130843404;
    this.jdField_b_of_type_ArrayOfInt = arrayOfInt;
    label567:
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    if (this.jdField_b_of_type_Aodp != null) {
      this.app.a().deleteObserver(this.jdField_b_of_type_Aodp);
    }
    this.app.unRegistObserver(this.jdField_a_of_type_Atdh);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    this.l = true;
    this.jdField_a_of_type_Bgua.a(null);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    this.rightViewText.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131626878));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
    this.f.setText(2131625492);
    y();
    b();
  }
  
  public void j()
  {
    if (this.f != null)
    {
      if (f()) {
        this.f.setText(2131625035);
      }
    }
    else {
      return;
    }
    this.f.setText(2131625492);
  }
  
  protected void m()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView = ((QfileTabBarView)findViewById(2131300626));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setAttribution(1);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setHeaderScrollView(this.jdField_a_of_type_ComTencentMobileqqActivityContactsViewHeaderScrollView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(3, getString(2131627050));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(4, getString(2131627052));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(20, this.g);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(5, getString(2131627056));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(6, getString(2131627053));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b(7, getString(2131627051));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(3);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    int i = paramView.getId();
    if (i == 2131302709)
    {
      i();
      if (f())
      {
        this.f.setText(2131625035);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getString(2131626878));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a();
        this.rightViewText.setVisibility(8);
      }
    }
    label467:
    do
    {
      do
      {
        return;
        apci.a("0X8009C32");
        this.f.setText(2131625492);
        break;
        Object localObject;
        if (i == 2131302727)
        {
          paramView = new Intent(getApplicationContext(), FMActivity.class);
          paramView.putExtra("tab_tab_type", 1);
          try
          {
            localObject = new Bundle();
            ((Bundle)localObject).putLong("category", 15);
            paramView.putExtra("bundle", (Bundle)localObject);
            paramView.putExtra("from", "FileAssistant");
            paramView.putExtra("custom_title", getString(2131626823));
            startActivityForResult(paramView, 101);
            if (this.j)
            {
              apci.a("0X8005538");
              return;
            }
          }
          catch (Exception paramView)
          {
            paramView.printStackTrace();
            return;
          }
          apci.a("0X800681E");
          return;
        }
        if (i == 2131302733)
        {
          paramView = new Bundle();
          paramView.putBoolean("string_from", false);
          paramView.putBoolean("string_uin", false);
          paramView.putLong("device_din", 0L);
          paramView.putInt("sTitleID", 0);
          bfgz.a(this, paramView, "com.qqdataline.mpfile.LiteMpFileMainActivity");
          if (this.j)
          {
            apci.a("0X8005539");
            return;
          }
          apci.a("0X800681F");
          return;
        }
        if (i == 2131302775)
        {
          i = baig.aR(this, this.app.getCurrentAccountUin());
          if (i == 1)
          {
            paramView = baig.t(this, this.app.getCurrentAccountUin());
            i = baig.aS(this, this.app.getCurrentAccountUin());
            if (TextUtils.isEmpty(paramView)) {}
          }
          for (;;)
          {
            try
            {
              a(this, paramView, i);
              if (!this.j) {
                break label467;
              }
              apci.a("0X800553A");
              a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, "100160.100164");
              return;
            }
            catch (MiniAppException paramView)
            {
              if (QLog.isColorLevel()) {
                QLog.e("FileAssistantActivity", 2, "fail to open weiyun mini app!");
              }
              x();
              continue;
            }
            QLog.w("FileAssistantActivity", 2, "can not to start WeiYun Mini app, apkgUrl = " + paramView + ", version = " + i);
            x();
            continue;
            QLog.w("FileAssistantActivity", 2, "can not to start WeiYun Mini app, weiYunGrayConfig = " + i);
            x();
            continue;
            apci.a("0X8006820");
          }
        }
        if (i == 2131302708)
        {
          apci.a("0X8009070");
          t();
          amxm.a(getAppInterface());
          a(this.jdField_b_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, "100160.100163");
          return;
        }
        if (i == 2131311449)
        {
          paramView = (apbv)this.app.getManager(281);
          amld.a().c();
          paramView = amld.a().d();
          this.k = true;
          if (!TextUtils.isEmpty(paramView))
          {
            apck.b(this, paramView);
            apci.a("0X80093EF");
            return;
          }
          QLog.e("FileAssistantActivity", 1, "unknow action!");
          return;
        }
        if (i == 2131311064)
        {
          apci.a("0X8009C33");
          s();
          return;
        }
        switch (i)
        {
        default: 
          return;
        case 2131302886: 
          if (this.jdField_a_of_type_AndroidViewView != null)
          {
            localObject = ValueAnimator.ofInt(new int[] { this.jdField_a_of_type_AndroidViewView.getHeight(), 0 });
            ((ValueAnimator)localObject).setDuration(300L);
            ((ValueAnimator)localObject).addUpdateListener(new aoaz(this));
            ((ValueAnimator)localObject).addListener(new aoba(this));
            ((ValueAnimator)localObject).start();
          }
          this.app.getPreferences().edit().putString("check_album_day", d()).apply();
          paramView = paramView.getTag();
        }
      } while (!(paramView instanceof String));
      paramView = (String)paramView;
      awqx.b(this.app, "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
      return;
      AlbumBackupProxyActivity.a(this, this.app.getCurrentAccountUin(), "source_qfile_assistant", 10001);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.app.getPreferences().edit().putString("check_album_day", d()).apply();
      paramView = paramView.getTag();
    } while (!(paramView instanceof String));
    paramView = (String)paramView;
    awqx.b(this.app, "dc00898", "", "", paramView, paramView, 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity
 * JD-Core Version:    0.7.0.1
 */