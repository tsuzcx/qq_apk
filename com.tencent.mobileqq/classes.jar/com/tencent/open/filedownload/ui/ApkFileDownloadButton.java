package com.tencent.open.filedownload.ui;

import alpo;
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
import bdcd;
import bdef;
import bdfq;
import bfgi;
import bfgx;
import bfgy;
import bfgz;
import bfha;
import bfhg;
import bfka;
import bfmf;
import bfmg;
import bfmh;
import bfmi;
import bfmj;
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
  private bfka jdField_a_of_type_Bfka = new bfmg(this);
  public bfmf a;
  private bfmj jdField_a_of_type_Bfmj;
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
    LayoutInflater.from(paramContext).inflate(2131559520, this);
    j();
    bfgi.a().a(this.jdField_a_of_type_Bfka);
  }
  
  private void b(DownloadInfo paramDownloadInfo)
  {
    if (AppNetConnInfo.isMobileConn())
    {
      bfmh localbfmh = new bfmh(this);
      paramDownloadInfo = new bfmi(this, paramDownloadInfo);
      bdcd.a(this.jdField_a_of_type_AndroidContentContext, 230, alpo.a(2131700645), alpo.a(2131700643), 2131690648, 2131691703, paramDownloadInfo, localbfmh).show();
      bfgx.a(bfgy.a().k(this.jdField_a_of_type_Bfmf.jdField_a_of_type_JavaLangString).j("5").l("0").m(this.jdField_a_of_type_Bfmf.d).a(this.jdField_a_of_type_Bfmf.h).b(this.jdField_a_of_type_Bfmf.f).g(this.jdField_a_of_type_Bfmf.e));
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
      localDownloadInfo.t = this.jdField_a_of_type_Bfmf.jdField_a_of_type_JavaLangString;
      localDownloadInfo.u = this.jdField_a_of_type_Bfmf.jdField_b_of_type_JavaLangString;
      localDownloadInfo.v = this.jdField_a_of_type_Bfmf.c;
      localDownloadInfo.h = this.jdField_a_of_type_Bfmf.d;
      localDownloadInfo.d = this.jdField_a_of_type_Bfmf.e;
      localDownloadInfo.e = this.jdField_a_of_type_Bfmf.f;
      localDownloadInfo.f = this.jdField_a_of_type_Bfmf.h;
      localDownloadInfo.g = ("_" + GlobalUtil.calcMD5AsString(this.jdField_a_of_type_Bfmf.e));
      localDownloadInfo.b = true;
      localDownloadInfo.m = this.jdField_a_of_type_JavaLangString;
      localDownloadInfo.a();
    }
    for (;;)
    {
      bfgi.a().b(localDownloadInfo);
      if (this.jdField_a_of_type_Bfmj != null) {
        this.jdField_a_of_type_Bfmj.b();
      }
      return;
      paramDownloadInfo.e = this.jdField_a_of_type_Bfmf.f;
      paramDownloadInfo.b = true;
      if ((paramDownloadInfo.a() == 4) && (new File(paramDownloadInfo.l).exists()))
      {
        this.jdField_a_of_type_Bfmf.jdField_b_of_type_Int = 4;
        this.jdField_a_of_type_Bfmf.jdField_a_of_type_Int = 100;
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131375898));
    this.b = ((TextView)findViewById(2131379143));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131372321));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363652));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379134));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(b(1));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c = ((TextView)findViewById(2131379135));
  }
  
  protected String a()
  {
    return alpo.a(2131700646);
  }
  
  protected String a(int paramInt)
  {
    return "default";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bfmf.jdField_b_of_type_Int != 4) {
      bfgi.a().a(this.jdField_a_of_type_Bfmf.e);
    }
  }
  
  protected void a(DownloadInfo paramDownloadInfo)
  {
    bfgi.a().a(paramDownloadInfo);
  }
  
  protected void a(String paramString) {}
  
  protected void a(String paramString, boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean)
  {
    b();
    i();
    if (paramBoolean) {
      bfgx.b(bfgz.a().a("202").k(this.jdField_a_of_type_Bfmf.jdField_a_of_type_JavaLangString).j(this.jdField_a_of_type_Bfmf.jdField_b_of_type_JavaLangString).l(this.jdField_a_of_type_Bfmf.c).m(this.jdField_a_of_type_Bfmf.d).a(this.jdField_a_of_type_Bfmf.h).b(this.jdField_a_of_type_Bfmf.f).g(this.jdField_a_of_type_Bfmf.e));
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (this.jdField_a_of_type_Bfmj != null)) {
      this.jdField_a_of_type_Bfmj.d();
    }
    b(paramBoolean1);
  }
  
  public boolean a(DownloadInfo paramDownloadInfo, bfmf parambfmf)
  {
    if ((paramDownloadInfo == null) || (parambfmf == null)) {
      return false;
    }
    return TextUtils.equals(paramDownloadInfo.d, parambfmf.e);
  }
  
  protected String b()
  {
    if ((this.jdField_a_of_type_Bfmf.jdField_b_of_type_Int == 4) || (this.jdField_a_of_type_Bfmf.jdField_a_of_type_Int == 100)) {
      return b(4);
    }
    if (this.jdField_a_of_type_Bfmf.jdField_a_of_type_Long == 0L) {
      return a();
    }
    String str1 = bdef.a((float)(this.jdField_a_of_type_Bfmf.jdField_a_of_type_Long * this.jdField_a_of_type_Bfmf.jdField_a_of_type_Int / 100L), true, 2);
    String str2 = bdef.a((float)this.jdField_a_of_type_Bfmf.jdField_a_of_type_Long, true, 2);
    return a() + "(" + str1 + "/" + str2 + ")";
  }
  
  protected String b(int paramInt)
  {
    if (paramInt == 4) {
      return alpo.a(2131700649);
    }
    return alpo.a(2131700651);
  }
  
  public void b()
  {
    a();
    bfgi.a().b(this.jdField_a_of_type_Bfka);
  }
  
  protected void b(String paramString)
  {
    this.b.setText(paramString);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bfmf == null)
    {
      bfhg.b("ApkFileDownloadButton_", "[onClick] mApkInfo == null!");
      return;
    }
    bfhg.b("ApkFileDownloadButton_", "[onClick] state=" + this.jdField_a_of_type_Bfmf.jdField_b_of_type_Int);
    bfgi.a().a(this.jdField_a_of_type_Bfka);
    DownloadInfo localDownloadInfo = bfgi.a().b(this.jdField_a_of_type_Bfmf.e);
    if (localDownloadInfo != null)
    {
      this.jdField_a_of_type_Bfmf.jdField_b_of_type_Int = localDownloadInfo.a();
      if (TextUtils.isEmpty(localDownloadInfo.m)) {
        localDownloadInfo.m = this.jdField_a_of_type_JavaLangString;
      }
    }
    switch (this.jdField_a_of_type_Bfmf.jdField_b_of_type_Int)
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
          bfgx.b(bfgz.a().a(str).k(this.jdField_a_of_type_Bfmf.jdField_a_of_type_JavaLangString).j(this.jdField_a_of_type_Bfmf.jdField_b_of_type_JavaLangString).l(this.jdField_a_of_type_Bfmf.c).m(this.jdField_a_of_type_Bfmf.d).a(this.jdField_a_of_type_Bfmf.h).b(this.jdField_a_of_type_Bfmf.f).g(this.jdField_a_of_type_Bfmf.e));
        }
        a(str, paramBoolean);
        return;
        if ((localDownloadInfo == null) || (localDownloadInfo.a() != 4) || (!new File(localDownloadInfo.l).exists())) {
          break;
        }
        str = "305";
        this.jdField_a_of_type_Bfmf.jdField_b_of_type_Int = 4;
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
    if ((paramBoolean2) && (this.jdField_a_of_type_Bfmj != null)) {
      this.jdField_a_of_type_Bfmj.a();
    }
    a(paramBoolean1);
  }
  
  public void c()
  {
    bfgi.a().b(this.jdField_a_of_type_Bfka);
    this.jdField_a_of_type_Bfka = null;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Bfmf.jdField_b_of_type_Int = 1;
    g();
    i();
  }
  
  protected void e()
  {
    i();
    if (this.jdField_a_of_type_Bfmj != null) {
      this.jdField_a_of_type_Bfmj.c();
    }
  }
  
  protected void f()
  {
    this.c.setVisibility(8);
  }
  
  protected void g()
  {
    b(b());
    if (this.jdField_a_of_type_Bfmf.jdField_b_of_type_Int == 4) {
      this.jdField_a_of_type_Bfmf.jdField_a_of_type_Int = 100;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(b(this.jdField_a_of_type_Bfmf.jdField_b_of_type_Int));
    a(this.jdField_a_of_type_Bfmf.jdField_a_of_type_Int);
    int i = 1;
    if (this.jdField_a_of_type_Bfmf.jdField_b_of_type_Int == 4) {
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
      if (this.jdField_a_of_type_Bfmj != null) {
        this.jdField_a_of_type_Bfmj.a();
      }
      a(true);
    }
    while (paramView != this.jdField_a_of_type_AndroidWidgetTextView) {
      return;
    }
    if (this.jdField_a_of_type_Bfmj != null) {
      this.jdField_a_of_type_Bfmj.d();
    }
    b(true);
  }
  
  public void setApkInfo(bfmf parambfmf)
  {
    this.jdField_a_of_type_Bfmf = bfmf.a(parambfmf);
    g();
  }
  
  public void setEventCallback(bfmj parambfmj)
  {
    this.jdField_a_of_type_Bfmj = parambfmj;
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