package com.tencent.open.filedownload.ui;

import ajyc;
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
import bbcv;
import bbew;
import bbgg;
import bdgv;
import bdhk;
import bdhl;
import bdhm;
import bdhn;
import bdht;
import bdko;
import bdmt;
import bdmu;
import bdmv;
import bdmw;
import bdmx;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.open.downloadnew.DownloadInfo;
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
  private bdko jdField_a_of_type_Bdko = new bdmu(this);
  public bdmt a;
  private bdmx jdField_a_of_type_Bdmx;
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
    LayoutInflater.from(paramContext).inflate(2131559468, this);
    j();
    bdgv.a().a(this.jdField_a_of_type_Bdko);
  }
  
  private void b(DownloadInfo paramDownloadInfo)
  {
    if (AppNetConnInfo.isMobileConn())
    {
      bdmv localbdmv = new bdmv(this);
      paramDownloadInfo = new bdmw(this, paramDownloadInfo);
      bbcv.a(this.jdField_a_of_type_AndroidContentContext, 230, ajyc.a(2131700265), ajyc.a(2131700263), 2131690596, 2131691648, paramDownloadInfo, localbdmv).show();
      bdhk.a(bdhl.a().k(this.jdField_a_of_type_Bdmt.jdField_a_of_type_JavaLangString).j("5").l("0").m(this.jdField_a_of_type_Bdmt.d).a(this.jdField_a_of_type_Bdmt.h).b(this.jdField_a_of_type_Bdmt.f).g(this.jdField_a_of_type_Bdmt.e));
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
      localDownloadInfo.t = this.jdField_a_of_type_Bdmt.jdField_a_of_type_JavaLangString;
      localDownloadInfo.u = this.jdField_a_of_type_Bdmt.jdField_b_of_type_JavaLangString;
      localDownloadInfo.v = this.jdField_a_of_type_Bdmt.c;
      localDownloadInfo.h = this.jdField_a_of_type_Bdmt.d;
      localDownloadInfo.d = this.jdField_a_of_type_Bdmt.e;
      localDownloadInfo.e = this.jdField_a_of_type_Bdmt.f;
      localDownloadInfo.f = this.jdField_a_of_type_Bdmt.h;
      localDownloadInfo.g = ("_" + GlobalUtil.calcMD5AsString(this.jdField_a_of_type_Bdmt.e));
      localDownloadInfo.b = true;
      localDownloadInfo.m = this.jdField_a_of_type_JavaLangString;
      localDownloadInfo.a();
    }
    for (;;)
    {
      bdgv.a().b(localDownloadInfo);
      if (this.jdField_a_of_type_Bdmx != null) {
        this.jdField_a_of_type_Bdmx.b();
      }
      return;
      paramDownloadInfo.e = this.jdField_a_of_type_Bdmt.f;
      paramDownloadInfo.b = true;
      if ((paramDownloadInfo.a() == 4) && (new File(paramDownloadInfo.l).exists()))
      {
        this.jdField_a_of_type_Bdmt.jdField_b_of_type_Int = 4;
        this.jdField_a_of_type_Bdmt.jdField_a_of_type_Int = 100;
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131375411));
    this.b = ((TextView)findViewById(2131378526));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131372004));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363607));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378517));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(b(1));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c = ((TextView)findViewById(2131378518));
  }
  
  protected String a()
  {
    return ajyc.a(2131700266);
  }
  
  protected String a(int paramInt)
  {
    return "default";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bdmt.jdField_b_of_type_Int != 4) {
      bdgv.a().a(this.jdField_a_of_type_Bdmt.e);
    }
  }
  
  protected void a(DownloadInfo paramDownloadInfo)
  {
    bdgv.a().a(paramDownloadInfo);
  }
  
  protected void a(String paramString) {}
  
  protected void a(String paramString, boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean)
  {
    b();
    i();
    if (paramBoolean) {
      bdhk.b(bdhm.a().a("202").k(this.jdField_a_of_type_Bdmt.jdField_a_of_type_JavaLangString).j(this.jdField_a_of_type_Bdmt.jdField_b_of_type_JavaLangString).l(this.jdField_a_of_type_Bdmt.c).m(this.jdField_a_of_type_Bdmt.d).a(this.jdField_a_of_type_Bdmt.h).b(this.jdField_a_of_type_Bdmt.f).g(this.jdField_a_of_type_Bdmt.e));
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (this.jdField_a_of_type_Bdmx != null)) {
      this.jdField_a_of_type_Bdmx.d();
    }
    b(paramBoolean1);
  }
  
  public boolean a(DownloadInfo paramDownloadInfo, bdmt parambdmt)
  {
    if ((paramDownloadInfo == null) || (parambdmt == null)) {
      return false;
    }
    return TextUtils.equals(paramDownloadInfo.d, parambdmt.e);
  }
  
  protected String b()
  {
    if ((this.jdField_a_of_type_Bdmt.jdField_b_of_type_Int == 4) || (this.jdField_a_of_type_Bdmt.jdField_a_of_type_Int == 100)) {
      return b(4);
    }
    if (this.jdField_a_of_type_Bdmt.jdField_a_of_type_Long == 0L) {
      return a();
    }
    String str1 = bbew.a((float)(this.jdField_a_of_type_Bdmt.jdField_a_of_type_Long * this.jdField_a_of_type_Bdmt.jdField_a_of_type_Int / 100L), true, 2);
    String str2 = bbew.a((float)this.jdField_a_of_type_Bdmt.jdField_a_of_type_Long, true, 2);
    return a() + "(" + str1 + "/" + str2 + ")";
  }
  
  protected String b(int paramInt)
  {
    if (paramInt == 4) {
      return ajyc.a(2131700269);
    }
    return ajyc.a(2131700271);
  }
  
  public void b()
  {
    a();
    bdgv.a().b(this.jdField_a_of_type_Bdko);
  }
  
  protected void b(String paramString)
  {
    this.b.setText(paramString);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bdmt == null)
    {
      bdht.b("ApkFileDownloadButton_", "[onClick] mApkInfo == null!");
      return;
    }
    bdht.b("ApkFileDownloadButton_", "[onClick] state=" + this.jdField_a_of_type_Bdmt.jdField_b_of_type_Int);
    bdgv.a().a(this.jdField_a_of_type_Bdko);
    DownloadInfo localDownloadInfo = bdgv.a().b(this.jdField_a_of_type_Bdmt.e);
    if (localDownloadInfo != null)
    {
      this.jdField_a_of_type_Bdmt.jdField_b_of_type_Int = localDownloadInfo.a();
      if (TextUtils.isEmpty(localDownloadInfo.m)) {
        localDownloadInfo.m = this.jdField_a_of_type_JavaLangString;
      }
    }
    switch (this.jdField_a_of_type_Bdmt.jdField_b_of_type_Int)
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
          bdhk.b(bdhm.a().a(str).k(this.jdField_a_of_type_Bdmt.jdField_a_of_type_JavaLangString).j(this.jdField_a_of_type_Bdmt.jdField_b_of_type_JavaLangString).l(this.jdField_a_of_type_Bdmt.c).m(this.jdField_a_of_type_Bdmt.d).a(this.jdField_a_of_type_Bdmt.h).b(this.jdField_a_of_type_Bdmt.f).g(this.jdField_a_of_type_Bdmt.e));
        }
        a(str, paramBoolean);
        return;
        if ((localDownloadInfo == null) || (localDownloadInfo.a() != 4) || (!new File(localDownloadInfo.l).exists())) {
          break;
        }
        str = "305";
        this.jdField_a_of_type_Bdmt.jdField_b_of_type_Int = 4;
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
    if ((paramBoolean2) && (this.jdField_a_of_type_Bdmx != null)) {
      this.jdField_a_of_type_Bdmx.a();
    }
    a(paramBoolean1);
  }
  
  public void c()
  {
    bdgv.a().b(this.jdField_a_of_type_Bdko);
    this.jdField_a_of_type_Bdko = null;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Bdmt.jdField_b_of_type_Int = 1;
    g();
    i();
  }
  
  protected void e()
  {
    i();
    if (this.jdField_a_of_type_Bdmx != null) {
      this.jdField_a_of_type_Bdmx.c();
    }
  }
  
  protected void f()
  {
    this.c.setVisibility(8);
  }
  
  protected void g()
  {
    b(b());
    if (this.jdField_a_of_type_Bdmt.jdField_b_of_type_Int == 4) {
      this.jdField_a_of_type_Bdmt.jdField_a_of_type_Int = 100;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(b(this.jdField_a_of_type_Bdmt.jdField_b_of_type_Int));
    a(this.jdField_a_of_type_Bdmt.jdField_a_of_type_Int);
    int i = 1;
    if (this.jdField_a_of_type_Bdmt.jdField_b_of_type_Int == 4) {
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
      if (this.jdField_a_of_type_Bdmx != null) {
        this.jdField_a_of_type_Bdmx.a();
      }
      a(true);
    }
    while (paramView != this.jdField_a_of_type_AndroidWidgetTextView) {
      return;
    }
    if (this.jdField_a_of_type_Bdmx != null) {
      this.jdField_a_of_type_Bdmx.d();
    }
    b(true);
  }
  
  public void setApkInfo(bdmt parambdmt)
  {
    this.jdField_a_of_type_Bdmt = bdmt.a(parambdmt);
    g();
  }
  
  public void setEventCallback(bdmx parambdmx)
  {
    this.jdField_a_of_type_Bdmx = parambdmx;
  }
  
  public void setSource(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.filedownload.ui.ApkFileDownloadButton
 * JD-Core Version:    0.7.0.1
 */