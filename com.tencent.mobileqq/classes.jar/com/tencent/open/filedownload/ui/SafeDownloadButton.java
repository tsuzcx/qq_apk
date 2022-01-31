package com.tencent.open.filedownload.ui;

import alud;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import azqs;
import bflg;
import bfli;
import bflj;
import bflp;
import bfod;
import bfqm;
import bfqo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import mqq.os.MqqHandler;

public class SafeDownloadButton
  extends ApkFileDownloadButton
{
  private static final String jdField_a_of_type_JavaLangString = alud.a(2131713888);
  private static final String jdField_b_of_type_JavaLangString = alud.a(2131713891);
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  private bfqo jdField_b_of_type_Bfqo;
  private boolean jdField_b_of_type_Boolean;
  
  public SafeDownloadButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SafeDownloadButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SafeDownloadButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private String c()
  {
    try
    {
      String str = "tmast://download?downl_url=" + URLEncoder.encode(this.jdField_b_of_type_Bfqo.e, "UTF-8") + "&down_ticket=" + URLEncoder.encode(this.jdField_b_of_type_Bfqo.e, "UTF-8") + "&oplist=1;2&via=" + this.jdField_b_of_type_Bfqo.d;
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return "";
  }
  
  private void k()
  {
    if ((this.jdField_b_of_type_Bfqo == null) || (TextUtils.isEmpty(this.jdField_b_of_type_Bfqo.e))) {
      return;
    }
    bflg.b(bfli.a().a("200").k(this.jdField_b_of_type_Bfqo.jdField_a_of_type_JavaLangString).j(this.jdField_b_of_type_Bfqo.jdField_b_of_type_JavaLangString).l(this.jdField_b_of_type_Bfqo.c).m(this.jdField_b_of_type_Bfqo.d).a(this.jdField_b_of_type_Bfqo.h).b(this.jdField_b_of_type_Bfqo.f).g(this.jdField_b_of_type_Bfqo.e));
    QQAppInterface localQQAppInterface = ((BaseActivity)getContext()).app;
    if (this.jdField_a_of_type_Bfqo.h == null) {}
    for (String str = "";; str = this.jdField_a_of_type_Bfqo.h)
    {
      azqs.b(localQQAppInterface, "dc00898", "", "", "0X8009AC4", "0X8009AC4", 0, 0, "1", "", str, "");
      l();
      return;
    }
  }
  
  private void l()
  {
    String str = c();
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse(str));
    localIntent.addFlags(268435456);
    try
    {
      BaseApplication.getContext().startActivity(localIntent);
      bflp.b("SafeDownloadButton_", "goToYYBByTmast success! jumpUrl=" + str);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      bflp.e("SafeDownloadButton_", "ActivityNotFoundException e=" + localActivityNotFoundException.getMessage());
    }
  }
  
  private void m()
  {
    String str = c();
    Bundle localBundle = new Bundle();
    localBundle.putString("url", str);
    bfod.a(localBundle);
    bfod.b(localBundle);
    bflp.b("SafeDownloadButton_", "writeTmastCmd success! jumpUrl=" + str);
  }
  
  protected String a()
  {
    return alud.a(2131713893);
  }
  
  protected String a(int paramInt)
  {
    if (paramInt == 1) {
      return jdField_a_of_type_JavaLangString;
    }
    return jdField_b_of_type_JavaLangString;
  }
  
  protected void a(DownloadInfo paramDownloadInfo)
  {
    this.jdField_a_of_type_Boolean = true;
    m();
    super.a(paramDownloadInfo);
  }
  
  protected void a(String paramString)
  {
    if (TextUtils.equals(paramString, "com.tencent.android.qqdownloader"))
    {
      bflp.b("SafeDownloadButton_", alud.a(2131713890) + this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        ThreadManager.getUIHandler().post(new SafeDownloadButton.1(this));
      }
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface;
    if ((paramBoolean) && (("900".equals(paramString)) || ("400".equals(paramString))))
    {
      localQQAppInterface = ((BaseActivity)getContext()).app;
      if (this.jdField_a_of_type_Bfqo.h != null) {
        break label73;
      }
    }
    label73:
    for (paramString = "";; paramString = this.jdField_a_of_type_Bfqo.h)
    {
      azqs.b(localQQAppInterface, "dc00898", "", "", "0X8009AC4", "0X8009AC4", 0, 0, "2", "", paramString, "");
      return;
    }
  }
  
  protected String b(int paramInt)
  {
    if (paramInt == 4) {
      return alud.a(2131713892);
    }
    return alud.a(2131713889);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (bfqm.a())
    {
      this.jdField_a_of_type_Bfqo.jdField_b_of_type_Int = 1;
      g();
      k();
      return;
    }
    super.b(paramBoolean);
  }
  
  protected void e()
  {
    this.jdField_a_of_type_Boolean = true;
    m();
    super.e();
  }
  
  public void j()
  {
    long l = System.currentTimeMillis();
    bflp.b("SafeDownloadButton_", "onResume " + this.jdField_b_of_type_Boolean + ",currentTimestamp=" + l + ",mYYBInstallSuccessTimestamp= " + this.jdField_a_of_type_Long);
    if (this.jdField_b_of_type_Boolean)
    {
      if (l - this.jdField_a_of_type_Long < 5000L) {
        l();
      }
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void setOriApkInfo(bfqo parambfqo)
  {
    this.jdField_b_of_type_Bfqo = bfqo.a(parambfqo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.filedownload.ui.SafeDownloadButton
 * JD-Core Version:    0.7.0.1
 */