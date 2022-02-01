package com.tencent.mobileqq.filemanager.fileviewer;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.MotionEvent;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public final class TroopFileDetailBrowserActivity
  extends FileBrowserActivity
  implements IFileBrowser
{
  protected ForwardFileInfo g;
  protected FMObserver h = new TroopFileDetailBrowserActivity.1(this);
  
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
      this.app.getFileManagerNotifyCenter().addObserver(this.h);
    }
    Object localObject1 = new TroopFileViewerParamParser(this.app);
    if (!((TroopFileViewerParamParser)localObject1).a(paramIntent, this)) {
      return false;
    }
    this.g = ((ForwardFileInfo)super.getIntent().getParcelableExtra("fileinfo"));
    if (this.d == null)
    {
      this.d = new FileBrowserManager(this, this, ((TroopFileViewerParamParser)localObject1).a(this));
      this.d.a(this.e);
    }
    int i = paramIntent.getIntExtra("file_enter_file_browser_type", 0);
    paramIntent = paramIntent.getBundleExtra("file_browser_extra_params");
    if (!this.d.a(a(), new RelativeLayout.LayoutParams(-1, -1), i, paramIntent))
    {
      if (QLog.isColorLevel()) {
        QLog.w("FileBrowserActivity<FileAssistant>", 2, "error. can not create a fileviewer from FileBrowserManager");
      }
      return false;
    }
    if (((TroopFileViewerParamParser)localObject1).a() == 1)
    {
      paramIntent = this.app;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.g.b());
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.c);
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(a(getApplicationContext()));
      localStringBuilder.append("");
      ReportController.b(paramIntent, "P_CliOper", "Grp_files", "", "in_mid", "pic_enter", 0, 0, (String)localObject1, (String)localObject2, localStringBuilder.toString(), FileManagerUtil.b(FileManagerUtil.c(this.g.i())));
      return true;
    }
    paramIntent = this.app;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.g.b());
    ((StringBuilder)localObject1).append("");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.c);
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(getApplicationContext()));
    localStringBuilder.append("");
    ReportController.b(paramIntent, "P_CliOper", "Grp_files", "", "in_mid", "nonpic_enter", 0, 0, (String)localObject1, (String)localObject2, localStringBuilder.toString(), FileManagerUtil.b(FileManagerUtil.c(this.g.i())));
    return true;
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
    if ((paramInt2 == -1) && (paramInt1 == 10099) && (paramIntent != null) && (paramIntent.getBooleanExtra("isNeedFinish", false)))
    {
      finish();
      return;
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.getFileManagerNotifyCenter().deleteObserver(this.h);
  }
  
  public boolean g()
  {
    if ((getIntent() != null) && (getIntent().getIntExtra("from_type_troop", -1) == 3)) {
      return true;
    }
    return super.g();
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