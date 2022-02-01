package com.tencent.mobileqq.filemanager.fileviewer;

import Override;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import android.widget.RelativeLayout.LayoutParams;
import atfq;
import atlh;
import attd;
import atuw;
import atve;
import atvf;
import auea;
import bdla;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public final class TroopFileDetailBrowserActivity
  extends FileBrowserActivity
  implements atuw
{
  protected atfq a;
  public ForwardFileInfo b;
  
  public TroopFileDetailBrowserActivity()
  {
    this.jdField_a_of_type_Atfq = new atve(this);
  }
  
  private int a(Context paramContext)
  {
    if (!NetworkUtil.isNetworkAvailable(paramContext)) {
      return 2;
    }
    if (NetworkUtil.isWifiConnected(paramContext)) {
      return 0;
    }
    return 1;
  }
  
  protected boolean a(Intent paramIntent)
  {
    if (this.app != null) {
      this.app.getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_Atfq);
    }
    atvf localatvf = new atvf(this.app);
    if (!localatvf.a(paramIntent, this)) {}
    do
    {
      return false;
      this.b = ((ForwardFileInfo)super.getIntent().getParcelableExtra("fileinfo"));
      if (this.jdField_a_of_type_Attd == null)
      {
        this.jdField_a_of_type_Attd = new attd(this, this, localatvf.a(this));
        this.jdField_a_of_type_Attd.a(this.jdField_a_of_type_Atux);
      }
      int i = paramIntent.getIntExtra("file_enter_file_browser_type", 0);
      paramIntent = paramIntent.getBundleExtra("file_browser_extra_params");
      if (this.jdField_a_of_type_Attd.a(a(), new RelativeLayout.LayoutParams(-1, -1), i, paramIntent)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("FileBrowserActivity<FileAssistant>", 2, "error. can not create a fileviewer from FileBrowserManager");
    return false;
    if (localatvf.a() == 1) {
      bdla.b(super.a(), "P_CliOper", "Grp_files", "", "in_mid", "pic_enter", 0, 0, this.b.a() + "", this.jdField_a_of_type_Int + "", a(getApplicationContext()) + "", auea.b(auea.a(this.b.d())));
    }
    for (;;)
    {
      return true;
      bdla.b(super.a(), "P_CliOper", "Grp_files", "", "in_mid", "nonpic_enter", 0, 0, this.b.a() + "", this.jdField_a_of_type_Int + "", a(getApplicationContext()) + "", auea.b(auea.a(this.b.d())));
    }
  }
  
  public boolean c()
  {
    if ((getIntent() != null) && (getIntent().getIntExtra("from_type_troop", -1) == 3)) {
      return true;
    }
    return super.c();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
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
    this.app.getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_Atfq);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity
 * JD-Core Version:    0.7.0.1
 */