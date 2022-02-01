package com.tencent.mobileqq.filemanager.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoProcessor;
import com.tencent.mobileqq.filemanager.activity.fileassistant.IBaseTabViewEvent;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.IClickListenerVer51;
import com.tencent.mobileqq.filemanager.util.IReportVer51;
import com.tencent.mobileqq.filemanager.util.ImplDataReportHandleVer51;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.TeamWorkConstants;
import com.tencent.mobileqq.teamwork.TencentDocConfig;
import com.tencent.mobileqq.teamwork.api.ISeparateForwardProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public abstract class BaseFileAssistantActivity
  extends QIphoneTitleBarActivity
  implements View.OnClickListener
{
  public String A = "";
  public int B = 20971520;
  public long C = -1L;
  boolean D = true;
  FMObserver E = new BaseFileAssistantActivity.3(this);
  private boolean F = true;
  private boolean G = false;
  private boolean H = false;
  private String I;
  private String J;
  private int K;
  private int L;
  private int M;
  private boolean N;
  private boolean O;
  private int P;
  private IReportVer51 Q;
  private IClickListenerVer51 R;
  private int S = 0;
  private ISeparateForwardProxy T;
  protected SendBottomBar a = null;
  protected QfileEditBottomBar b = null;
  public RelativeLayout c = null;
  public TextView d = null;
  public boolean e = false;
  public boolean f = false;
  protected String g;
  protected int h = -1;
  protected boolean i = false;
  protected boolean j = false;
  protected boolean k = false;
  public boolean l = false;
  public boolean m = false;
  public String n;
  public String o;
  public BaseQQAppInterface p;
  protected boolean q = false;
  protected int r = -1;
  protected long s = 0L;
  protected String t = null;
  protected String u = null;
  protected ArrayList<FileInfo> v;
  protected int w = 0;
  public boolean x = false;
  protected boolean y = false;
  public boolean z = false;
  
  private void N()
  {
    o();
  }
  
  private void O()
  {
    if (this.a == null) {
      this.a = ((SendBottomBar)findViewById(2131445569));
    }
    if (this.b == null) {
      this.b = ((QfileEditBottomBar)findViewById(2131432306));
    }
    this.b.setVisibility(8);
    this.a.setVisibility(8);
    if (q())
    {
      l();
      this.a.a();
      this.a.setVisibility(0);
      return;
    }
    if (C())
    {
      l();
      this.b.a();
      this.b.setVisibility(0);
    }
  }
  
  private void P()
  {
    if (this.c == null) {
      this.c = ((RelativeLayout)findViewById(2131440352));
    }
    if ((!q()) && (!C())) {
      this.c.setVisibility(8);
    } else {
      this.c.setVisibility(0);
    }
    b(D());
  }
  
  public IReportVer51 A()
  {
    return this.Q;
  }
  
  public void B()
  {
    this.a.a();
    this.b.a();
    long l1 = FMDataCache.e();
    if ((!this.x) && (this.h != 8) && (!QQFileManagerUtil.c(this)) && (D()))
    {
      if (FMDataCache.e() == 0L)
      {
        m();
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131889321));
      localStringBuilder.append(l1);
      localStringBuilder.append(HardCodeUtil.a(2131889320));
      setTitle(localStringBuilder.toString());
    }
  }
  
  public boolean C()
  {
    return this.H;
  }
  
  public boolean D()
  {
    return (q()) || (C());
  }
  
  public int E()
  {
    return this.h;
  }
  
  public boolean F()
  {
    return (this.i) || (this.k);
  }
  
  public boolean G()
  {
    return this.j;
  }
  
  public int H()
  {
    return this.w;
  }
  
  public boolean I()
  {
    return this.a.f();
  }
  
  public boolean J()
  {
    return (this.S & 0x2) == 2;
  }
  
  public boolean K()
  {
    return (this.S & 0x1) == 1;
  }
  
  public int L()
  {
    return -1;
  }
  
  public int[] M()
  {
    return null;
  }
  
  public SendBottomBar a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    super.setContentViewNoTitle(2131627061);
    ((RelativeLayout)findViewById(2131429334)).addView(((LayoutInflater)getSystemService("layout_inflater")).inflate(paramInt, null));
    this.rightViewText = ((TextView)findViewById(2131445516));
    k();
    z();
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.d.setOnClickListener(paramOnClickListener);
    this.d.setVisibility(0);
  }
  
  public void a(IBaseTabViewEvent paramIBaseTabViewEvent) {}
  
  public void a(IClickListenerVer51 paramIClickListenerVer51)
  {
    z();
    this.R = paramIClickListenerVer51;
    this.a.setClickListener(paramIClickListenerVer51);
    this.b.setClickListener(paramIClickListenerVer51);
  }
  
  public void a(ArrayList<FileManagerEntity> paramArrayList) {}
  
  public void a(Set<FileInfo> paramSet) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      startTitleProgress();
      return;
    }
    stopTitleProgress();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.a.setEditBtnVisible(paramBoolean1);
    this.b.setEditBtnVisible(paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }
  
  protected void b() {}
  
  public void b(int paramInt)
  {
    this.K = paramInt;
  }
  
  public void b(ArrayList<FileManagerEntity> paramArrayList) {}
  
  public void b(boolean paramBoolean) {}
  
  public void c()
  {
    k();
  }
  
  public void c(int paramInt)
  {
    this.L = paramInt;
  }
  
  public void c(ArrayList<WeiYunFileInfo> paramArrayList) {}
  
  protected void c(boolean paramBoolean)
  {
    this.F = paramBoolean;
  }
  
  public void d(int paramInt) {}
  
  protected void d(boolean paramBoolean)
  {
    this.G = paramBoolean;
  }
  
  protected boolean d()
  {
    return this.D;
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
    this.a.a();
    if ((paramInt2 == -1) && (paramInt1 == 109)) {
      this.T.onFowardActivityResult(paramIntent);
    }
    if (paramInt2 == 4)
    {
      if ((this.O) && (paramIntent != null) && (paramIntent.getExtras() != null)) {
        ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).startChatAndSendMsg(this, paramIntent.getExtras());
      }
      setResult(4, paramIntent);
      finish();
      return;
    }
    if ((paramInt2 == -1) && (paramInt1 != 103) && (paramInt1 != 12289))
    {
      setResult(-1, paramIntent);
      finish();
      return;
    }
    if (paramInt2 == 5)
    {
      setResult(5, null);
      finish();
      return;
    }
    if (paramInt2 == 10)
    {
      setResult(10, paramIntent);
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.p = ((BaseQQAppInterface)getAppRuntime());
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).addObserver(this.E);
    paramBundle = getIntent();
    d(paramBundle.getBooleanExtra("selectMode", q()));
    c(paramBundle.getBooleanExtra("enableDelete", q() ^ true));
    this.I = paramBundle.getStringExtra("targetUin");
    this.J = paramBundle.getStringExtra("srcDiscGroup");
    this.K = paramBundle.getIntExtra("peerType", 0);
    this.O = paramBundle.getBooleanExtra("rootEntrace", true);
    this.L = paramBundle.getIntExtra("busiType", 0);
    this.P = paramBundle.getIntExtra("enterfrom", 0);
    this.M = paramBundle.getIntExtra("sendprepare", -100);
    this.N = paramBundle.getBooleanExtra("apautocreate", false);
    this.x = paramBundle.getBooleanExtra("STRING_SingleSelect", false);
    this.k = paramBundle.getBooleanExtra("qlinkselect", false);
    this.q = paramBundle.getBooleanExtra("only_show_local_tab", false);
    this.r = paramBundle.getIntExtra("max_select_count", -1);
    this.s = paramBundle.getLongExtra("max_select_size", 0L);
    this.u = paramBundle.getStringExtra("send_btn_custom_text");
    this.v = paramBundle.getParcelableArrayListExtra("default_select_file_info_list");
    this.t = paramBundle.getStringExtra("custom_title");
    this.w = paramBundle.getIntExtra("approval_attachment_customid", 0);
    this.y = paramBundle.getBooleanExtra("select_file_support_send_docs_file", false);
    this.z = paramBundle.getBooleanExtra(TeamWorkConstants.f, false);
    this.A = paramBundle.getStringExtra(TeamWorkConstants.g);
    this.C = paramBundle.getLongExtra("qrlogin_appid", -1L);
    this.e = paramBundle.getBooleanExtra("isTroopFile", false);
    this.f = paramBundle.getBooleanExtra("isOverSpace", false);
    paramBundle.putExtra("uintype", 0);
    this.T = ((ISeparateForwardProxy)QRoute.api(ISeparateForwardProxy.class));
    this.T.createSeparateForward(this, 109);
    this.T.onCreate();
    if ("FileAssistant".equalsIgnoreCase(getIntent().getStringExtra("from"))) {
      j(true);
    }
    if (-1 == this.r)
    {
      int i1;
      if (this.k) {
        i1 = 100;
      } else {
        i1 = 20;
      }
      this.r = i1;
    }
    if (this.z)
    {
      FMDataCache.a(1);
      TencentDocConfig.a().b();
      long l2 = TencentDocImportFileInfoProcessor.a().b();
      long l1 = l2;
      if (l2 == 0L) {
        l1 = 20971520L;
      }
      this.s = l1;
    }
    else
    {
      FMDataCache.a(this.r);
    }
    FMDataCache.a(this.s);
    paramBundle = this.v;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext()) {
        FMDataCache.b((FileInfo)paramBundle.next());
      }
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append(">>>>>");
      paramBundle.append(getClass().getSimpleName());
      paramBundle.append("<<<<< doOnCreate ");
      QLog.d("File.Selector.BaseFileAssistantActivity", 2, paramBundle.toString());
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(">>>>>");
      ((StringBuilder)localObject).append(getClass().getSimpleName());
      ((StringBuilder)localObject).append("<<<<< doOnDestroy ");
      QLog.d("File.Selector.BaseFileAssistantActivity", 2, ((StringBuilder)localObject).toString());
    }
    this.T.onDestroy();
    if (this.E != null) {
      ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).deleteObserver(this.E);
    }
    Object localObject = this.a;
    if (localObject != null) {
      ((SendBottomBar)localObject).i();
    }
    localObject = this.b;
    if (localObject != null) {
      ((QfileEditBottomBar)localObject).c();
    }
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  protected void doOnResume()
  {
    this.D = true;
    B();
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    this.a.j();
    super.doOnResume();
  }
  
  public void e()
  {
    this.rightViewText.setVisibility(0);
  }
  
  public void e(boolean paramBoolean)
  {
    SendBottomBar localSendBottomBar = this.a;
    if (localSendBottomBar != null) {
      localSendBottomBar.setSelectAllOrCancelAll(paramBoolean);
    }
  }
  
  public void f()
  {
    this.rightViewText.setVisibility(8);
  }
  
  public void f(boolean paramBoolean)
  {
    this.H = paramBoolean;
  }
  
  public void finish()
  {
    super.finish();
    if (this.O)
    {
      if (u() == 1) {
        ((IQQFileEngine)this.p.getRuntimeService(IQQFileEngine.class)).exitQlinkLocalFileBrowser();
      }
      if (D()) {
        FMDataCache.d();
      }
    }
  }
  
  protected void g()
  {
    this.D = false;
    new Handler().postDelayed(new BaseFileAssistantActivity.1(this), 1500L);
  }
  
  public void g(boolean paramBoolean)
  {
    this.a.setCheckAllEnable(paramBoolean);
  }
  
  public BaseQQAppInterface h()
  {
    return (BaseQQAppInterface)getAppRuntime();
  }
  
  public void h(boolean paramBoolean)
  {
    if (!this.y)
    {
      QLog.i("File.Selector.BaseFileAssistantActivity", 1, "biz not support docs send!");
      return;
    }
    this.a.setDocsCheck(paramBoolean);
  }
  
  public ListView i()
  {
    return null;
  }
  
  public void i(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.S |= 0x1;
      return;
    }
    this.S &= 0xFFFFFFFE;
  }
  
  public ISeparateForwardProxy j()
  {
    return this.T;
  }
  
  public void j(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.S |= 0x2;
      return;
    }
    this.S &= 0xFFFFFFFD;
  }
  
  protected void k()
  {
    if (this.d == null)
    {
      this.d = ((TextView)findViewById(2131445377));
      l();
    }
    N();
    if (getIntent().getIntExtra("localSdCardfile", -1) == 1408041716) {
      f();
    }
    O();
    P();
  }
  
  public void l()
  {
    this.d.setVisibility(8);
  }
  
  public void m()
  {
    setTitle(this.g);
    if ((this.h == 1) && (!D())) {
      this.d.setVisibility(0);
    }
  }
  
  protected void n()
  {
    if (D())
    {
      FMDataCache.d();
      f(false);
      if (q())
      {
        setResult(5);
        finish();
        return;
      }
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(2131889267);
      this.b.setVisibility(8);
      setTitle(this.g);
      c();
      b();
      if (this.h == 1) {
        this.d.setVisibility(0);
      }
      b(false);
      return;
    }
    if (this.R != null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("File.Selector.BaseFileAssistantActivity", 2, "onRightEditClick");
      }
      this.R.f();
    }
    FMDataCache.d();
    f(true);
    this.rightViewText.setVisibility(0);
    this.rightViewText.setText(2131889250);
    this.b.setVisibility(0);
    c();
    this.d.setVisibility(8);
    b(true);
  }
  
  public void o()
  {
    if (D())
    {
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(getString(2131889250));
    }
    else
    {
      this.rightViewText.setVisibility(0);
      this.rightViewText.setText(2131889267);
    }
    this.rightViewText.setOnClickListener(new BaseFileAssistantActivity.2(this));
  }
  
  public void onClick(View paramView) {}
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public boolean p()
  {
    return this.F;
  }
  
  public boolean q()
  {
    return this.G;
  }
  
  public String r()
  {
    return this.I;
  }
  
  public String s()
  {
    return this.J;
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(2131627061);
    ((RelativeLayout)findViewById(2131429334)).addView(((LayoutInflater)getSystemService("layout_inflater")).inflate(paramInt, null));
    k();
    z();
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    paramIntent.putExtra("selectMode", q());
    paramIntent.putExtra("enableDelete", p());
    paramIntent.putExtra("targetUin", this.I);
    paramIntent.putExtra("srcDiscGroup", this.J);
    paramIntent.putExtra("peerType", this.K);
    paramIntent.putExtra("busiType", this.L);
    paramIntent.putExtra("enterfrom", this.P);
    paramIntent.putExtra("sendprepare", this.M);
    paramIntent.putExtra("apautocreate", this.N);
    paramIntent.putExtra("qlinkselect", this.k);
    paramIntent.putExtra("max_select_size", this.s);
    paramIntent.putExtra("max_select_count", this.r);
    paramIntent.putExtra("send_btn_custom_text", this.u);
    paramIntent.putExtra("custom_title", this.t);
    paramIntent.putExtra("rootEntrace", false);
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  public int t()
  {
    return this.K;
  }
  
  public int u()
  {
    return this.L;
  }
  
  public int v()
  {
    return this.P;
  }
  
  public int w()
  {
    return this.M;
  }
  
  public boolean x()
  {
    return this.N;
  }
  
  public String y()
  {
    return this.u;
  }
  
  public void z()
  {
    if (this.Q == null) {
      this.Q = new ImplDataReportHandleVer51();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity
 * JD-Core Version:    0.7.0.1
 */