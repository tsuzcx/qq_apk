package com.tencent.mobileqq.filemanager.fileviewer;

import amyl;
import amym;
import amyo;
import android.content.Context;
import android.content.Intent;
import android.text.method.LinkMovementMethod;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aouj;
import aozc;
import apih;
import apkm;
import apkt;
import apku;
import apue;
import axqw;
import bbev;
import bbwx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.qphone.base.util.QLog;

public final class TroopFileDetailBrowserActivity
  extends FileBrowserActivity
  implements apkm
{
  protected aouj a;
  public ForwardFileInfo b;
  
  public TroopFileDetailBrowserActivity()
  {
    this.jdField_a_of_type_Aouj = new apkt(this);
  }
  
  private int a(Context paramContext)
  {
    if (!bbev.g(paramContext)) {
      return 2;
    }
    if (bbev.h(paramContext)) {
      return 0;
    }
    return 1;
  }
  
  protected boolean a(Intent paramIntent)
  {
    if (this.app != null) {
      this.app.a().addObserver(this.jdField_a_of_type_Aouj);
    }
    apku localapku = new apku(this.app);
    if (!localapku.a(paramIntent, this)) {}
    do
    {
      return false;
      this.b = ((ForwardFileInfo)super.getIntent().getParcelableExtra("fileinfo"));
      if (this.jdField_a_of_type_Apih == null)
      {
        this.jdField_a_of_type_Apih = new apih(this, this, localapku.a(this));
        this.jdField_a_of_type_Apih.a(this.jdField_a_of_type_Apkn);
      }
      int i = paramIntent.getIntExtra("file_enter_file_browser_type", 0);
      paramIntent = paramIntent.getBundleExtra("file_browser_extra_params");
      if (this.jdField_a_of_type_Apih.a(a(), new RelativeLayout.LayoutParams(-1, -1), i, paramIntent)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("FileBrowserActivity<FileAssistant>", 2, "error. can not create a fileviewer from FileBrowserManager");
    return false;
    if (localapku.a() == 1) {
      axqw.b(super.a(), "P_CliOper", "Grp_files", "", "in_mid", "pic_enter", 0, 0, this.b.a() + "", this.jdField_a_of_type_Int + "", a(getApplicationContext()) + "", apue.b(apue.a(this.b.d())));
    }
    for (;;)
    {
      if (a(getBaseContext()) == 1)
      {
        paramIntent = (TextView)findViewById(2131367237);
        if ((paramIntent != null) && (amyo.c().c.a) && (!bbwx.a().b()))
        {
          paramIntent.setText(amyo.c().c.a(this, ""));
          paramIntent.setMovementMethod(LinkMovementMethod.getInstance());
          paramIntent.setVisibility(0);
        }
      }
      return true;
      axqw.b(super.a(), "P_CliOper", "Grp_files", "", "in_mid", "nonpic_enter", 0, 0, this.b.a() + "", this.jdField_a_of_type_Int + "", a(getApplicationContext()) + "", apue.b(apue.a(this.b.d())));
    }
  }
  
  public boolean b()
  {
    if ((getIntent() != null) && (getIntent().getIntExtra("from_type_troop", -1) == 3)) {
      return true;
    }
    return super.b();
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt2 == -1) && (paramInt1 == 10099) && (paramIntent != null) && (paramIntent.getBooleanExtra("isNeedFinish", false)))
    {
      finish();
      return;
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.a().deleteObserver(this.jdField_a_of_type_Aouj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity
 * JD-Core Version:    0.7.0.1
 */