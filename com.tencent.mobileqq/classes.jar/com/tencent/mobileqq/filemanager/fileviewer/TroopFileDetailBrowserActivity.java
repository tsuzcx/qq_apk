package com.tencent.mobileqq.filemanager.fileviewer;

import amys;
import amyt;
import amyv;
import android.content.Context;
import android.content.Intent;
import android.text.method.LinkMovementMethod;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aoun;
import aozg;
import apil;
import apkq;
import apkx;
import apky;
import apug;
import axqy;
import bbfj;
import bbxl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.qphone.base.util.QLog;

public final class TroopFileDetailBrowserActivity
  extends FileBrowserActivity
  implements apkq
{
  protected aoun a;
  public ForwardFileInfo b;
  
  public TroopFileDetailBrowserActivity()
  {
    this.jdField_a_of_type_Aoun = new apkx(this);
  }
  
  private int a(Context paramContext)
  {
    if (!bbfj.g(paramContext)) {
      return 2;
    }
    if (bbfj.h(paramContext)) {
      return 0;
    }
    return 1;
  }
  
  protected boolean a(Intent paramIntent)
  {
    if (this.app != null) {
      this.app.a().addObserver(this.jdField_a_of_type_Aoun);
    }
    apky localapky = new apky(this.app);
    if (!localapky.a(paramIntent, this)) {}
    do
    {
      return false;
      this.b = ((ForwardFileInfo)super.getIntent().getParcelableExtra("fileinfo"));
      if (this.jdField_a_of_type_Apil == null)
      {
        this.jdField_a_of_type_Apil = new apil(this, this, localapky.a(this));
        this.jdField_a_of_type_Apil.a(this.jdField_a_of_type_Apkr);
      }
      int i = paramIntent.getIntExtra("file_enter_file_browser_type", 0);
      paramIntent = paramIntent.getBundleExtra("file_browser_extra_params");
      if (this.jdField_a_of_type_Apil.a(a(), new RelativeLayout.LayoutParams(-1, -1), i, paramIntent)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("FileBrowserActivity<FileAssistant>", 2, "error. can not create a fileviewer from FileBrowserManager");
    return false;
    if (localapky.a() == 1) {
      axqy.b(super.a(), "P_CliOper", "Grp_files", "", "in_mid", "pic_enter", 0, 0, this.b.a() + "", this.jdField_a_of_type_Int + "", a(getApplicationContext()) + "", apug.b(apug.a(this.b.d())));
    }
    for (;;)
    {
      if (a(getBaseContext()) == 1)
      {
        paramIntent = (TextView)findViewById(2131367237);
        if ((paramIntent != null) && (amyv.c().c.a) && (!bbxl.a().b()))
        {
          paramIntent.setText(amyv.c().c.a(this, ""));
          paramIntent.setMovementMethod(LinkMovementMethod.getInstance());
          paramIntent.setVisibility(0);
        }
      }
      return true;
      axqy.b(super.a(), "P_CliOper", "Grp_files", "", "in_mid", "nonpic_enter", 0, 0, this.b.a() + "", this.jdField_a_of_type_Int + "", a(getApplicationContext()) + "", apug.b(apug.a(this.b.d())));
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
    this.app.a().deleteObserver(this.jdField_a_of_type_Aoun);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity
 * JD-Core Version:    0.7.0.1
 */