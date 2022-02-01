package com.tencent.open.filedownload.ui;

import amtj;
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
import bfmy;
import bfur;
import bhyo;
import bhzd;
import bhze;
import bhzf;
import bhzg;
import bhzm;
import biec;
import bied;
import biee;
import bief;
import bieg;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
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
  public biec a;
  private bieg jdField_a_of_type_Bieg;
  private DownloadListener jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener = new bied(this);
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
    LayoutInflater.from(paramContext).inflate(2131559663, this);
    j();
    bhyo.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
  }
  
  private void b(DownloadInfo paramDownloadInfo)
  {
    if (AppNetConnInfo.isMobileConn())
    {
      biee localbiee = new biee(this);
      paramDownloadInfo = new bief(this, paramDownloadInfo);
      bfur.a(this.jdField_a_of_type_AndroidContentContext, 230, amtj.a(2131699425), amtj.a(2131699423), 2131690620, 2131691483, paramDownloadInfo, localbiee).show();
      bhzd.a(bhze.a().k(this.jdField_a_of_type_Biec.jdField_a_of_type_JavaLangString).j("5").l("0").m(this.jdField_a_of_type_Biec.d).a(this.jdField_a_of_type_Biec.h).b(this.jdField_a_of_type_Biec.f).g(this.jdField_a_of_type_Biec.e));
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
      localDownloadInfo.t = this.jdField_a_of_type_Biec.jdField_a_of_type_JavaLangString;
      localDownloadInfo.u = this.jdField_a_of_type_Biec.jdField_b_of_type_JavaLangString;
      localDownloadInfo.v = this.jdField_a_of_type_Biec.c;
      localDownloadInfo.h = this.jdField_a_of_type_Biec.d;
      localDownloadInfo.d = this.jdField_a_of_type_Biec.e;
      localDownloadInfo.e = this.jdField_a_of_type_Biec.f;
      localDownloadInfo.f = this.jdField_a_of_type_Biec.h;
      localDownloadInfo.g = ("_" + GlobalUtil.calcMD5AsString(this.jdField_a_of_type_Biec.e));
      localDownloadInfo.b = true;
      localDownloadInfo.m = this.jdField_a_of_type_JavaLangString;
      localDownloadInfo.a();
    }
    for (;;)
    {
      bhyo.a().b(localDownloadInfo);
      if (this.jdField_a_of_type_Bieg != null) {
        this.jdField_a_of_type_Bieg.b();
      }
      return;
      paramDownloadInfo.e = this.jdField_a_of_type_Biec.f;
      paramDownloadInfo.b = true;
      if ((paramDownloadInfo.a() == 4) && (new File(paramDownloadInfo.l).exists()))
      {
        this.jdField_a_of_type_Biec.jdField_b_of_type_Int = 4;
        this.jdField_a_of_type_Biec.jdField_a_of_type_Int = 100;
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376595));
    this.b = ((TextView)findViewById(2131380037));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131373018));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363907));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380028));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(b(1));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.c = ((TextView)findViewById(2131380029));
  }
  
  protected String a()
  {
    return amtj.a(2131699426);
  }
  
  protected String a(int paramInt)
  {
    return "default";
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Biec.jdField_b_of_type_Int != 4) {
      bhyo.a().a(this.jdField_a_of_type_Biec.e);
    }
  }
  
  protected void a(DownloadInfo paramDownloadInfo)
  {
    bhyo.a().a(paramDownloadInfo);
  }
  
  protected void a(String paramString) {}
  
  protected void a(String paramString, boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean)
  {
    b();
    i();
    if (paramBoolean) {
      bhzd.b(bhzf.a().a("202").k(this.jdField_a_of_type_Biec.jdField_a_of_type_JavaLangString).j(this.jdField_a_of_type_Biec.jdField_b_of_type_JavaLangString).l(this.jdField_a_of_type_Biec.c).m(this.jdField_a_of_type_Biec.d).a(this.jdField_a_of_type_Biec.h).b(this.jdField_a_of_type_Biec.f).g(this.jdField_a_of_type_Biec.e));
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (this.jdField_a_of_type_Bieg != null)) {
      this.jdField_a_of_type_Bieg.d();
    }
    b(paramBoolean1);
  }
  
  public boolean a(DownloadInfo paramDownloadInfo, biec parambiec)
  {
    if ((paramDownloadInfo == null) || (parambiec == null)) {
      return false;
    }
    return TextUtils.equals(paramDownloadInfo.d, parambiec.e);
  }
  
  protected String b()
  {
    if ((this.jdField_a_of_type_Biec.jdField_b_of_type_Int == 4) || (this.jdField_a_of_type_Biec.jdField_a_of_type_Int == 100)) {
      return b(4);
    }
    if (this.jdField_a_of_type_Biec.jdField_a_of_type_Long == 0L) {
      return a();
    }
    String str1 = bfmy.a((float)(this.jdField_a_of_type_Biec.jdField_a_of_type_Long * this.jdField_a_of_type_Biec.jdField_a_of_type_Int / 100L), true, 2);
    String str2 = bfmy.a((float)this.jdField_a_of_type_Biec.jdField_a_of_type_Long, true, 2);
    return a() + "(" + str1 + "/" + str2 + ")";
  }
  
  protected String b(int paramInt)
  {
    if (paramInt == 4) {
      return amtj.a(2131699429);
    }
    return amtj.a(2131699431);
  }
  
  public void b()
  {
    a();
    bhyo.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
  }
  
  protected void b(String paramString)
  {
    this.b.setText(paramString);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Biec == null)
    {
      bhzm.b("ApkFileDownloadButton_", "[onClick] mApkInfo == null!");
      return;
    }
    bhzm.b("ApkFileDownloadButton_", "[onClick] state=" + this.jdField_a_of_type_Biec.jdField_b_of_type_Int);
    bhyo.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
    DownloadInfo localDownloadInfo = bhyo.a().b(this.jdField_a_of_type_Biec.e);
    if (localDownloadInfo != null)
    {
      this.jdField_a_of_type_Biec.jdField_b_of_type_Int = localDownloadInfo.a();
      if (TextUtils.isEmpty(localDownloadInfo.m)) {
        localDownloadInfo.m = this.jdField_a_of_type_JavaLangString;
      }
    }
    switch (this.jdField_a_of_type_Biec.jdField_b_of_type_Int)
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
          bhzd.b(bhzf.a().a(str).k(this.jdField_a_of_type_Biec.jdField_a_of_type_JavaLangString).j(this.jdField_a_of_type_Biec.jdField_b_of_type_JavaLangString).l(this.jdField_a_of_type_Biec.c).m(this.jdField_a_of_type_Biec.d).a(this.jdField_a_of_type_Biec.h).b(this.jdField_a_of_type_Biec.f).g(this.jdField_a_of_type_Biec.e));
        }
        a(str, paramBoolean);
        return;
        if ((localDownloadInfo == null) || (localDownloadInfo.a() != 4) || (!new File(localDownloadInfo.l).exists())) {
          break;
        }
        str = "305";
        this.jdField_a_of_type_Biec.jdField_b_of_type_Int = 4;
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
    if ((paramBoolean2) && (this.jdField_a_of_type_Bieg != null)) {
      this.jdField_a_of_type_Bieg.a();
    }
    a(paramBoolean1);
  }
  
  public void c()
  {
    bhyo.a().b(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
    this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener = null;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Biec.jdField_b_of_type_Int = 1;
    g();
    i();
  }
  
  protected void e()
  {
    i();
    if (this.jdField_a_of_type_Bieg != null) {
      this.jdField_a_of_type_Bieg.c();
    }
  }
  
  protected void f()
  {
    this.c.setVisibility(8);
  }
  
  protected void g()
  {
    b(b());
    if (this.jdField_a_of_type_Biec.jdField_b_of_type_Int == 4) {
      this.jdField_a_of_type_Biec.jdField_a_of_type_Int = 100;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(b(this.jdField_a_of_type_Biec.jdField_b_of_type_Int));
    a(this.jdField_a_of_type_Biec.jdField_a_of_type_Int);
    int i = 1;
    if (this.jdField_a_of_type_Biec.jdField_b_of_type_Int == 4) {
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
      if (this.jdField_a_of_type_Bieg != null) {
        this.jdField_a_of_type_Bieg.a();
      }
      a(true);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.jdField_a_of_type_AndroidWidgetTextView)
      {
        if (this.jdField_a_of_type_Bieg != null) {
          this.jdField_a_of_type_Bieg.d();
        }
        b(true);
      }
    }
  }
  
  public void setApkInfo(biec parambiec)
  {
    this.jdField_a_of_type_Biec = biec.a(parambiec);
    g();
  }
  
  public void setEventCallback(bieg parambieg)
  {
    this.jdField_a_of_type_Bieg = parambieg;
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