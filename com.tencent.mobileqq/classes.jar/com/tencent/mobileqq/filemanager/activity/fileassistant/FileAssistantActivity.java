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
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.tendoc.TencentDocMyFileNameBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocMyFileNameProcessor;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.api.IFileAssistantExt;
import com.tencent.mobileqq.filemanager.api.IFileAssistantTipsConfig;
import com.tencent.mobileqq.filemanager.api.IFileAssistantTipsConfig.IBaseJump;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.widget.HeaderScrollView;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.CommonUtils;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.weiyun.WeiyunRemoteCommand;
import com.tencent.mobileqq.weiyun.api.IWeiyunApi;
import com.tencent.mobileqq.weiyun.api.IWeiyunHelper;
import com.tencent.mobileqq.weiyun.utils.PreferenceUtils;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Set;
import mqq.os.MqqHandler;

public class FileAssistantActivity
  extends BaseFileAssistantActivity
  implements OnItemSelectListener
{
  QfileTabBarView F = null;
  NavBarCommon G;
  boolean H = false;
  boolean I = false;
  TextView J;
  TextView K;
  TextView L;
  TextView M;
  RedTouch N;
  RedTouch O;
  RedTouch P;
  BusinessInfoCheckUpdate.AppInfo Q;
  BusinessInfoCheckUpdate.AppInfo R;
  BusinessInfoCheckUpdate.AppInfo S;
  IFileAssistantTipsConfig T;
  HeaderScrollView U;
  TextView V;
  ViewStub W = null;
  Handler X = new FileAssistantActivity.6(this, Looper.getMainLooper());
  private IFileAssistantExt Y;
  private WeiyunRemoteCommand Z;
  private volatile boolean aa = false;
  private int[] ab = { 2131889562, 2131896326, 2131918013, 2131917164 };
  private int[] ac = { 2130845688, 2130845689, 2130845694, 2130845739 };
  private ViewStub ad;
  private String ae = HardCodeUtil.a(2131896086);
  private FMObserver af = new FileAssistantActivity.5(this);
  
  private void O()
  {
    this.M = ((TextView)findViewById(2131435980));
    this.O = new RedTouch(getApplicationContext(), this.M).c(53).b(10.0F).a();
    this.M.setOnClickListener(this);
    ReportController.b(getAppRuntime(), "dc00898", "", "", "0X800906F", "0X800906F", 0, 0, "", "", "", "");
  }
  
  private void P()
  {
    TencentDocMyFileNameBean localTencentDocMyFileNameBean = TencentDocMyFileNameProcessor.a();
    if (localTencentDocMyFileNameBean != null)
    {
      this.M.setText(localTencentDocMyFileNameBean.a);
      this.L.setText(localTencentDocMyFileNameBean.b);
      this.ae = localTencentDocMyFileNameBean.c;
    }
  }
  
  private void Q()
  {
    Object localObject = this.T;
    if ((localObject != null) && (((IFileAssistantTipsConfig)localObject).a()))
    {
      if (TextUtils.isEmpty(this.T.b()))
      {
        QLog.i("FileAssistantActivity", 1, "FileAssistantTips not ready, textContent is null");
        return;
      }
      this.ad = ((ViewStub)findViewById(2131432711));
      this.ad.inflate();
      localObject = (TextView)findViewById(2131448811);
      TextView localTextView = (TextView)findViewById(2131448812);
      ImageView localImageView = (ImageView)findViewById(2131436616);
      ((TextView)localObject).setText(this.T.b());
      localTextView.setText(this.T.c());
      localTextView.setOnClickListener(this);
      localImageView.setOnClickListener(this);
      this.T.e();
      return;
    }
    QLog.i("FileAssistantActivity", 1, "FileAssistantTips is switch off");
  }
  
  private void R()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.ad.getHeight(), 0 });
    localValueAnimator.setDuration(300L);
    localValueAnimator.addUpdateListener(new FileAssistantActivity.2(this));
    localValueAnimator.addListener(new FileAssistantActivity.3(this));
    localValueAnimator.start();
  }
  
  private void S()
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
      localIntent.putExtra("custom_title", getString(2131889280));
      startActivityForResult(localIntent, 101);
      if (this.H)
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
  
  private void T()
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
  
  private void U()
  {
    this.Z = new WeiyunRemoteCommand();
    PluginCommunicationHandler.getInstance().register(this.Z);
    ((IWeiyunHelper)QRoute.api(IWeiyunHelper.class)).notifyEnterFileAssit(this.p.getApplication());
  }
  
  private void V()
  {
    Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
    localIntent.putExtra("tab_tab_type", 3);
    localIntent.putExtra("from", "FileAssistant");
    startActivityForResult(localIntent, 101);
  }
  
  private void W()
  {
    this.aa = false;
    if (((IQQFileEngine)this.p.getRuntimeService(IQQFileEngine.class)).hasQueriedVerifyPassword() == true)
    {
      ((IQQFileEngine)this.p.getRuntimeService(IQQFileEngine.class)).queryNeedVerifyPwd();
      return;
    }
    if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      Intent localIntent = new Intent(getApplicationContext(), FMActivity.class);
      localIntent.putExtra("tab_tab_type", 3);
      localIntent.putExtra("from", "FileAssistant");
      startActivityForResult(localIntent, 101);
      return;
    }
    FMToastUtil.a(BaseApplication.getContext().getString(2131896111));
  }
  
  private void X()
  {
    QLog.i("FileAssistantActivity", 1, "fileRedTouch updateAllRedTouch");
    Y();
    aa();
    Z();
  }
  
  private void Y()
  {
    if (this.O != null)
    {
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.p.getRuntimeService(IRedTouchManager.class, "");
      if (localIRedTouchManager == null) {
        return;
      }
      this.R = localIRedTouchManager.getAppInfo(1, "100160.100163");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fileRedTouch updateDocsFileRedTouch info = ");
      ((StringBuilder)localObject).append(this.R);
      QLog.i("FileAssistantActivity", 1, ((StringBuilder)localObject).toString());
      this.O.a(this.R);
      localObject = this.R;
      if (localObject != null) {
        localIRedTouchManager.onRedTouchItemExposure((BusinessInfoCheckUpdate.AppInfo)localObject, null);
      }
    }
  }
  
  private void Z()
  {
    if (this.P != null)
    {
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.p.getRuntimeService(IRedTouchManager.class, "");
      if (localIRedTouchManager == null) {
        return;
      }
      this.S = localIRedTouchManager.getAppInfo(1, "100160.100162");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fileRedTouch updateWeiyunBackupRedTouch info = ");
      ((StringBuilder)localObject).append(this.S);
      QLog.i("FileAssistantActivity", 1, ((StringBuilder)localObject).toString());
      this.P.a(this.S);
      localObject = this.S;
      if (localObject != null) {
        localIRedTouchManager.onRedTouchItemExposure((BusinessInfoCheckUpdate.AppInfo)localObject, null);
      }
    }
  }
  
  private void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" fileRedTouch deleteRedTouch path = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("FileAssistantActivity", 1, ((StringBuilder)localObject).toString());
    localObject = (IRedTouchManager)this.p.getRuntimeService(IRedTouchManager.class, "");
    if (paramAppInfo == null)
    {
      ((IRedTouchManager)localObject).onRedTouchItemClick(paramString);
      return;
    }
    ((IRedTouchManager)localObject).onRedTouchItemClick(paramAppInfo, null);
  }
  
  private void aa()
  {
    if (this.N != null)
    {
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.p.getRuntimeService(IRedTouchManager.class, "");
      if (localIRedTouchManager == null) {
        return;
      }
      this.Q = localIRedTouchManager.getAppInfo(1, "100160.100164");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fileRedTouch updateWeiyunFileRedTouch info = ");
      ((StringBuilder)localObject).append(this.Q);
      QLog.i("FileAssistantActivity", 1, ((StringBuilder)localObject).toString());
      this.N.a(this.Q);
      localObject = this.Q;
      if (localObject != null) {
        localIRedTouchManager.onRedTouchItemExposure((BusinessInfoCheckUpdate.AppInfo)localObject, null);
      }
    }
  }
  
  protected void N()
  {
    this.F = ((QfileTabBarView)findViewById(2131433119));
    this.F.setAttribution(1);
    this.F.d();
    this.F.setHeaderScrollView(this.U);
    this.F.setTabTitleList(new String[] { getString(2131889600), getString(2131889602), this.ae, getString(2131889610), getString(2131889604), getString(2131889601) });
    this.F.b(3, getString(2131889600));
    this.F.b(4, getString(2131889602));
    this.F.b(20, this.ae);
    this.F.b(5, getString(2131889610));
    this.F.b(6, getString(2131889604));
    this.F.b(7, getString(2131889601));
    this.F.setSelectedTab(3);
  }
  
  public void a(Set<FileInfo> paramSet)
  {
    this.F.a(paramSet);
  }
  
  public void b(ArrayList<FileManagerEntity> paramArrayList)
  {
    this.F.b(paramArrayList);
  }
  
  public void c()
  {
    super.c();
    this.F.c();
  }
  
  public void c(ArrayList<WeiYunFileInfo> paramArrayList)
  {
    this.F.c(paramArrayList);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    ViewStub localViewStub = this.W;
    if (localViewStub != null) {
      localViewStub.setVisibility(8);
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null) && ((paramIntent.getBooleanExtra("foward_editbar", false) == true) || (paramIntent.getBooleanExtra("destroy_last_activity", false) == true)) && (paramInt2 == 4))
    {
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).openAIO(this, paramIntent);
      finish();
    }
    if (paramInt1 == 10001) {
      ((IWeiyunApi)QRoute.api(IWeiyunApi.class)).initPwdRecord(this);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.Y = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).createFileAssistantExt();
    setContentView(2131627031);
    ThreadManager.getFileThreadHandler().post(new FileAssistantActivity.1(this));
    this.U = ((HeaderScrollView)findViewById(2131434992));
    this.J = ((TextView)findViewById(2131436067));
    this.K = ((TextView)findViewById(2131436078));
    this.L = ((TextView)findViewById(2131436148));
    this.N = new RedTouch(getApplicationContext(), this.L).c(53).b(10.0F).a();
    O();
    this.V = ((TextView)findViewById(2131435981));
    this.J.setOnClickListener(this);
    this.K.setOnClickListener(this);
    this.L.setOnClickListener(this);
    this.V.setOnClickListener(this);
    findViewById(2131446823).setOnClickListener(this);
    this.G = ((NavBarCommon)findViewById(2131444897));
    this.G.setTitle(getString(2131889351));
    if (Build.VERSION.SDK_INT >= 21) {
      paramBundle = getDrawable(2130845634);
    } else {
      paramBundle = getResources().getDrawable(2130845634);
    }
    this.G.setOnItemSelectListener(this);
    this.G.setRightImage(paramBundle);
    this.G.setRightImageDesc(HardCodeUtil.a(2131896064));
    this.P = new RedTouch(getApplicationContext(), this.G).c(53).b(5.0F).c(10.0F).a();
    P();
    this.Y.a(this, this.U);
    N();
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).addObserver(this.af);
    U();
    X();
    this.Y.a(this.p, this.X);
    if (PreferenceUtils.a(this, this.p.getCurrentAccountUin()) == 1)
    {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).preloadMiniProcess();
      if (QLog.isColorLevel()) {
        QLog.d("FileAssistantActivity", 2, "doOnCreate, preload mini app process");
      }
    }
    paramBundle = getIntent();
    int j = 0;
    this.H = paramBundle.getBooleanExtra("COMEFROMDESK", false);
    paramBundle = new FileManagerReporter.FileAssistantReportData();
    paramBundle.b = "file_asst_in";
    paramBundle.c = 11;
    FileManagerReporter.a(this.p.getCurrentAccountUin(), paramBundle);
    if (!((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).hasShortCut(this, new String[] { getString(2131889351) }))
    {
      int[] arrayOfInt1 = new int[this.ab.length + 1];
      paramBundle = new int[this.ac.length + 1];
      int i = 0;
      for (;;)
      {
        int[] arrayOfInt2 = this.ab;
        if (i >= arrayOfInt2.length) {
          break;
        }
        arrayOfInt1[i] = arrayOfInt2[i];
        i += 1;
      }
      arrayOfInt1[(arrayOfInt1.length - 1)] = 2131889324;
      this.ab = arrayOfInt1;
      i = j;
      for (;;)
      {
        arrayOfInt1 = this.ac;
        if (i >= arrayOfInt1.length) {
          break;
        }
        paramBundle[i] = arrayOfInt1[i];
        i += 1;
      }
      paramBundle[(paramBundle.length - 1)] = 2130845690;
      this.ac = paramBundle;
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.F.e();
    if (this.af != null) {
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).deleteObserver(this.af);
    }
    this.Y.a(this.p);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.aa = true;
    this.Z.a(null);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.rightViewText.setVisibility(8);
    this.G.setTitle(getString(2131889351));
    this.F.c();
    this.V.setText(2131896065);
    X();
    c();
  }
  
  public ListView i()
  {
    QfileTabBarView localQfileTabBarView = this.F;
    if (localQfileTabBarView != null) {
      return localQfileTabBarView.getListView();
    }
    return null;
  }
  
  public void o()
  {
    if (this.V != null)
    {
      if (D())
      {
        this.V.setText(2131887648);
        return;
      }
      this.V.setText(2131896065);
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    int i = paramView.getId();
    if (i == 2131435981)
    {
      n();
      if (D())
      {
        this.V.setText(2131887648);
      }
      else
      {
        FileManagerReporter.a("0X8009C32");
        this.V.setText(2131896065);
      }
      this.G.setTitle(getString(2131889351));
      this.F.c();
      this.rightViewText.setVisibility(8);
    }
    else if (i == 2131436067)
    {
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).checkPermission(this, new FileAssistantActivity.4(this));
    }
    else if (i == 2131436078)
    {
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).openPCFile(this);
      if (this.H) {
        FileManagerReporter.a("0X8005539");
      } else {
        FileManagerReporter.a("0X800681F");
      }
    }
    else
    {
      Object localObject;
      if (i == 2131436148)
      {
        i = PreferenceUtils.a(this, this.p.getCurrentAccountUin());
        if (i == 1)
        {
          localObject = PreferenceUtils.b(this, this.p.getCurrentAccountUin());
          i = PreferenceUtils.c(this, this.p.getCurrentAccountUin());
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            ((IWeiyunApi)QRoute.api(IWeiyunApi.class)).startWeiYunMiniApp(this, (String)localObject, i, null);
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("can not to start WeiYun Mini app, apkgUrl = ");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append(", version = ");
            localStringBuilder.append(i);
            QLog.w("FileAssistantActivity", 2, localStringBuilder.toString());
            W();
          }
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("can not to start WeiYun Mini app, weiYunGrayConfig = ");
          ((StringBuilder)localObject).append(i);
          QLog.w("FileAssistantActivity", 2, ((StringBuilder)localObject).toString());
          W();
        }
        if (this.H) {
          FileManagerReporter.a("0X800553A");
        } else {
          FileManagerReporter.a("0X8006820");
        }
        a(this.Q, "100160.100164");
      }
      else if (i == 2131435980)
      {
        FileManagerReporter.a("0X8009070");
        ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).gotoTIMTeamworkFileUrl(this, this.I);
        CommonUtils.a(this.p);
        a(this.R, "100160.100163");
      }
      else if (i == 2131436616)
      {
        this.T.f();
        R();
      }
      else if (i == 2131448812)
      {
        this.T.g();
        localObject = ((IQFileConfigManager)this.p.getRuntimeService(IQFileConfigManager.class, "")).getFileAssistantTipsConfig().d();
        if (localObject != null) {
          ((IFileAssistantTipsConfig.IBaseJump)localObject).a(this);
        }
        R();
      }
      else if (i == 2131446823)
      {
        FileManagerReporter.a("0X8009C33");
        ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).startSeach(this);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
      this.Y.a(this, this.S, this.H, this.p, this.ab, this.ac);
      paramInt = this.G.getWidth();
      int i = this.Y.a();
      int j = getResources().getDimensionPixelSize(2131299620);
      this.Y.a(this.G, paramInt - i - j, 0);
      ReportController.b(getAppRuntime(), "dc00898", "", "", "0X800A15E", "0X800A15E", 0, 0, "", "", "", "");
      return;
    }
    if (paramInt == 4)
    {
      n();
      this.rightViewText.setVisibility(8);
      this.G.setTitle(getString(2131889351));
      return;
    }
    if (paramInt == 1) {
      finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity
 * JD-Core Version:    0.7.0.1
 */