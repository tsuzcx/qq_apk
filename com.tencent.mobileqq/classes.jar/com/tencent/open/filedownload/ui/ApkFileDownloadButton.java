package com.tencent.open.filedownload.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anzj;
import bhdm;
import bhlq;
import bhpc;
import bjsz;
import bjto;
import bjtp;
import bjtq;
import bjtr;
import bjtx;
import bjyu;
import bjyv;
import bjyw;
import bjyx;
import bjyy;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.io.File;
import mqq.os.MqqHandler;

public class ApkFileDownloadButton
  extends RelativeLayout
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 1;
  private Context jdField_a_of_type_AndroidContentContext;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  protected RelativeLayout a;
  protected TextView a;
  public bjyu a;
  private bjyy jdField_a_of_type_Bjyy;
  private DownloadListener jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener = new bjyv(this);
  private String jdField_a_of_type_JavaLangString = "";
  private TextView b;
  private TextView c;
  
  public ApkFileDownloadButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ApkFileDownloadButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ApkFileDownloadButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(float paramFloat)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    if (paramFloat < 0.0F) {
      paramFloat = f2;
    }
    for (;;)
    {
      if (paramFloat > 1.0F) {
        paramFloat = f1;
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramFloat * 100.0F));
        return;
      }
    }
  }
  
  private void a(int paramInt)
  {
    a(paramInt * 1.0F / 100.0F);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    LayoutInflater.from(paramContext).inflate(2131559661, this);
    j();
    bjsz.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
  }
  
  private void b(DownloadInfo paramDownloadInfo)
  {
    if (AppNetConnInfo.isMobileConn())
    {
      bjyw localbjyw = new bjyw(this);
      paramDownloadInfo = new bjyx(this, paramDownloadInfo);
      bhlq.a(this.jdField_a_of_type_AndroidContentContext, 230, anzj.a(2131699190), anzj.a(2131699188), 2131690580, 2131691443, paramDownloadInfo, localbjyw).show();
      bjto.a(bjtp.a().k(this.jdField_a_of_type_Bjyu.jdField_a_of_type_JavaLangString).j("5").l("0").m(this.jdField_a_of_type_Bjyu.d).a(this.jdField_a_of_type_Bjyu.h).b(this.jdField_a_of_type_Bjyu.f).g(this.jdField_a_of_type_Bjyu.e));
      return;
    }
    h();
    c(paramDownloadInfo);
  }
  
  private void c(DownloadInfo paramDownloadInfo)
  {
    DownloadInfo localDownloadInfo;
    if (paramDownloadInfo == null)
    {
      localDownloadInfo = new DownloadInfo();
      localDownloadInfo.t = this.jdField_a_of_type_Bjyu.jdField_a_of_type_JavaLangString;
      localDownloadInfo.u = this.jdField_a_of_type_Bjyu.jdField_b_of_type_JavaLangString;
      localDownloadInfo.v = this.jdField_a_of_type_Bjyu.c;
      localDownloadInfo.h = this.jdField_a_of_type_Bjyu.d;
      localDownloadInfo.d = this.jdField_a_of_type_Bjyu.e;
      localDownloadInfo.e = this.jdField_a_of_type_Bjyu.f;
      localDownloadInfo.f = this.jdField_a_of_type_Bjyu.h;
      localDownloadInfo.g = ("_" + GlobalUtil.calcMD5AsString(this.jdField_a_of_type_Bjyu.e));
      localDownloadInfo.b = true;
      localDownloadInfo.m = this.jdField_a_of_type_JavaLangString;
      localDownloadInfo.a();
    }
    for (;;)
    {
      bjsz.a().b(localDownloadInfo);
      if (this.jdField_a_of_type_Bjyy != null) {
        this.jdField_a_of_type_Bjyy.b();
      }
      return;
      paramDownloadInfo.e = this.jdField_a_of_type_Bjyu.f;
      paramDownloadInfo.b = true;
      if ((paramDownloadInfo.a() == 4) && (new File(paramDownloadInfo.l).exists()))
      {
        this.jdField_a_of_type_Bjyu.jdField_b_of_type_Int = 4;
        this.jdField_a_of_type_Bjyu.jdField_a_of_type_Int = 100;
        g();
      }
      localDownloadInfo = paramDownloadInfo;
      if (TextUtils.isEmpty(paramDownloadInfo.m))
      {
        paramDownloadInfo.m = this.jdField_a_of_type_JavaLangString;
        localDownloadInfo = paramDownloadInfo;
      }
    }
  }
  
  private void j()
  {
    setClickable(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376831));
    this.b = ((TextView)findViewById(2131380311));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131373048));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363881));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380302));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(b(1));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c = ((TextView)findViewById(2131380303));
  }
  
  protected String a()
  {
    return anzj.a(2131699191);
  }
  
  protected String a(int paramInt)
  {
    return "default";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bjyu.jdField_b_of_type_Int != 4) {
      bjsz.a().a(this.jdField_a_of_type_Bjyu.e);
    }
  }
  
  protected void a(DownloadInfo paramDownloadInfo)
  {
    bjsz.a().a(paramDownloadInfo);
  }
  
  protected void a(String paramString) {}
  
  protected void a(String paramString, boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean)
  {
    b();
    i();
    if (paramBoolean) {
      bjto.b(bjtq.a().a("202").k(this.jdField_a_of_type_Bjyu.jdField_a_of_type_JavaLangString).j(this.jdField_a_of_type_Bjyu.jdField_b_of_type_JavaLangString).l(this.jdField_a_of_type_Bjyu.c).m(this.jdField_a_of_type_Bjyu.d).a(this.jdField_a_of_type_Bjyu.h).b(this.jdField_a_of_type_Bjyu.f).g(this.jdField_a_of_type_Bjyu.e));
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (this.jdField_a_of_type_Bjyy != null)) {
      this.jdField_a_of_type_Bjyy.d();
    }
    b(paramBoolean1);
  }
  
  public boolean a(DownloadInfo paramDownloadInfo, bjyu parambjyu)
  {
    if ((paramDownloadInfo == null) || (parambjyu == null)) {
      return false;
    }
    return TextUtils.equals(paramDownloadInfo.d, parambjyu.e);
  }
  
  protected String b()
  {
    if ((this.jdField_a_of_type_Bjyu.jdField_b_of_type_Int == 4) || (this.jdField_a_of_type_Bjyu.jdField_a_of_type_Int == 100)) {
      return b(4);
    }
    if (this.jdField_a_of_type_Bjyu.jdField_a_of_type_Long == 0L) {
      return a();
    }
    String str1 = bhdm.a((float)(this.jdField_a_of_type_Bjyu.jdField_a_of_type_Long * this.jdField_a_of_type_Bjyu.jdField_a_of_type_Int / 100L), true, 2);
    String str2 = bhdm.a((float)this.jdField_a_of_type_Bjyu.jdField_a_of_type_Long, true, 2);
    return a() + "(" + str1 + "/" + str2 + ")";
  }
  
  protected String b(int paramInt)
  {
    if (paramInt == 4) {
      return anzj.a(2131699194);
    }
    return anzj.a(2131699196);
  }
  
  public void b()
  {
    a();
    bjsz.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
  }
  
  protected void b(String paramString)
  {
    this.b.setText(paramString);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bjyu == null)
    {
      bjtx.b("ApkFileDownloadButton_", "[onClick] mApkInfo == null!");
      return;
    }
    bjtx.b("ApkFileDownloadButton_", "[onClick] state=" + this.jdField_a_of_type_Bjyu.jdField_b_of_type_Int);
    bjsz.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
    DownloadInfo localDownloadInfo = bjsz.a().b(this.jdField_a_of_type_Bjyu.e);
    if (localDownloadInfo != null)
    {
      this.jdField_a_of_type_Bjyu.jdField_b_of_type_Int = localDownloadInfo.a();
      if (TextUtils.isEmpty(localDownloadInfo.m)) {
        localDownloadInfo.m = this.jdField_a_of_type_JavaLangString;
      }
    }
    switch (this.jdField_a_of_type_Bjyu.jdField_b_of_type_Int)
    {
    default: 
      if ((localDownloadInfo != null) && ((localDownloadInfo.a() != 4) || (new File(localDownloadInfo.l).exists()))) {
        break;
      }
    }
    for (String str = "900";; str = "400")
    {
      b(localDownloadInfo);
      for (;;)
      {
        if (paramBoolean) {
          bjto.b(bjtq.a().a(str).k(this.jdField_a_of_type_Bjyu.jdField_a_of_type_JavaLangString).j(this.jdField_a_of_type_Bjyu.jdField_b_of_type_JavaLangString).l(this.jdField_a_of_type_Bjyu.c).m(this.jdField_a_of_type_Bjyu.d).a(this.jdField_a_of_type_Bjyu.h).b(this.jdField_a_of_type_Bjyu.f).g(this.jdField_a_of_type_Bjyu.e));
        }
        a(str, paramBoolean);
        return;
        if ((localDownloadInfo == null) || (localDownloadInfo.a() != 4) || (!new File(localDownloadInfo.l).exists())) {
          break;
        }
        str = "305";
        this.jdField_a_of_type_Bjyu.jdField_b_of_type_Int = 4;
        g();
        i();
        a(localDownloadInfo);
      }
      if ((localDownloadInfo == null) || ((localDownloadInfo.a() == 4) && (!new File(localDownloadInfo.l).exists()))) {}
      for (str = "900";; str = "400")
      {
        b(localDownloadInfo);
        break;
      }
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (this.jdField_a_of_type_Bjyy != null)) {
      this.jdField_a_of_type_Bjyy.a();
    }
    a(paramBoolean1);
  }
  
  public void c()
  {
    bjsz.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener = null;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Bjyu.jdField_b_of_type_Int = 1;
    g();
    i();
  }
  
  protected void e()
  {
    i();
    if (this.jdField_a_of_type_Bjyy != null) {
      this.jdField_a_of_type_Bjyy.c();
    }
  }
  
  protected void f()
  {
    this.c.setVisibility(8);
  }
  
  protected void g()
  {
    b(b());
    if (this.jdField_a_of_type_Bjyu.jdField_b_of_type_Int == 4) {
      this.jdField_a_of_type_Bjyu.jdField_a_of_type_Int = 100;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(b(this.jdField_a_of_type_Bjyu.jdField_b_of_type_Int));
    a(this.jdField_a_of_type_Bjyu.jdField_a_of_type_Int);
    int i = 1;
    if (this.jdField_a_of_type_Bjyu.jdField_b_of_type_Int == 4) {
      i = 3;
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
      i = 2;
    }
    this.c.setText(a(i));
  }
  
  public void h()
  {
    ThreadManager.getUIHandler().post(new ApkFileDownloadButton.2(this));
  }
  
  protected void i()
  {
    ThreadManager.getUIHandler().post(new ApkFileDownloadButton.3(this));
  }
  
  public final void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      if (this.jdField_a_of_type_Bjyy != null) {
        this.jdField_a_of_type_Bjyy.a();
      }
      a(true);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.jdField_a_of_type_AndroidWidgetTextView)
      {
        if (this.jdField_a_of_type_Bjyy != null) {
          this.jdField_a_of_type_Bjyy.d();
        }
        b(true);
      }
    }
  }
  
  public void setApkInfo(bjyu parambjyu)
  {
    this.jdField_a_of_type_Bjyu = bjyu.a(parambjyu);
    g();
  }
  
  public void setEventCallback(bjyy parambjyy)
  {
    this.jdField_a_of_type_Bjyy = parambjyy;
  }
  
  public void setSource(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.filedownload.ui.ApkFileDownloadButton
 * JD-Core Version:    0.7.0.1
 */