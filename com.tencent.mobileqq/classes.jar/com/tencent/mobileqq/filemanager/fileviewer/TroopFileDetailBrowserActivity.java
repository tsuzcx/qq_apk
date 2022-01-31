package com.tencent.mobileqq.filemanager.fileviewer;

import android.content.Context;
import android.content.Intent;
import android.text.method.LinkMovementMethod;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aopz;
import aoqa;
import aoqc;
import aqnl;
import aqse;
import arbg;
import ardn;
import ardv;
import ardw;
import arni;
import azmj;
import bdee;
import bdwm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.qphone.base.util.QLog;

public final class TroopFileDetailBrowserActivity
  extends FileBrowserActivity
  implements ardn
{
  protected aqnl a;
  public ForwardFileInfo b;
  
  public TroopFileDetailBrowserActivity()
  {
    this.jdField_a_of_type_Aqnl = new ardv(this);
  }
  
  private int a(Context paramContext)
  {
    if (!bdee.g(paramContext)) {
      return 2;
    }
    if (bdee.h(paramContext)) {
      return 0;
    }
    return 1;
  }
  
  protected boolean a(Intent paramIntent)
  {
    if (this.app != null) {
      this.app.a().addObserver(this.jdField_a_of_type_Aqnl);
    }
    ardw localardw = new ardw(this.app);
    if (!localardw.a(paramIntent, this)) {}
    do
    {
      return false;
      this.b = ((ForwardFileInfo)super.getIntent().getParcelableExtra("fileinfo"));
      if (this.jdField_a_of_type_Arbg == null)
      {
        this.jdField_a_of_type_Arbg = new arbg(this, this, localardw.a(this));
        this.jdField_a_of_type_Arbg.a(this.jdField_a_of_type_Ardo);
      }
      int i = paramIntent.getIntExtra("file_enter_file_browser_type", 0);
      paramIntent = paramIntent.getBundleExtra("file_browser_extra_params");
      if (this.jdField_a_of_type_Arbg.a(a(), new RelativeLayout.LayoutParams(-1, -1), i, paramIntent)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("FileBrowserActivity<FileAssistant>", 2, "error. can not create a fileviewer from FileBrowserManager");
    return false;
    if (localardw.a() == 1) {
      azmj.b(super.a(), "P_CliOper", "Grp_files", "", "in_mid", "pic_enter", 0, 0, this.b.a() + "", this.jdField_a_of_type_Int + "", a(getApplicationContext()) + "", arni.b(arni.a(this.b.d())));
    }
    for (;;)
    {
      if (a(getBaseContext()) == 1)
      {
        paramIntent = (TextView)findViewById(2131367367);
        if ((paramIntent != null) && (aoqc.c().c.a) && (!bdwm.a().b()))
        {
          paramIntent.setText(aoqc.c().c.a(this, ""));
          paramIntent.setMovementMethod(LinkMovementMethod.getInstance());
          paramIntent.setHighlightColor(17170445);
          paramIntent.setVisibility(0);
        }
      }
      return true;
      azmj.b(super.a(), "P_CliOper", "Grp_files", "", "in_mid", "nonpic_enter", 0, 0, this.b.a() + "", this.jdField_a_of_type_Int + "", a(getApplicationContext()) + "", arni.b(arni.a(this.b.d())));
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
    this.app.a().deleteObserver(this.jdField_a_of_type_Aqnl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity
 * JD-Core Version:    0.7.0.1
 */