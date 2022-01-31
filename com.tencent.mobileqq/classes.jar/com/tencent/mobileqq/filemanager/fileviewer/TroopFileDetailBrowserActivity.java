package com.tencent.mobileqq.filemanager.fileviewer;

import adkm;
import android.content.Context;
import android.content.Intent;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public final class TroopFileDetailBrowserActivity
  extends FileBrowserActivity
  implements IFileBrowser
{
  protected FMObserver a;
  public ForwardFileInfo b;
  
  public TroopFileDetailBrowserActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new adkm(this);
  }
  
  private int a(Context paramContext)
  {
    if (!NetworkUtil.g(paramContext)) {
      return 2;
    }
    if (NetworkUtil.h(paramContext)) {
      return 0;
    }
    return 1;
  }
  
  protected boolean a(Intent paramIntent)
  {
    if (this.app != null) {
      this.app.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
    TroopFileViewerParamParser localTroopFileViewerParamParser = new TroopFileViewerParamParser(this.app);
    if (!localTroopFileViewerParamParser.a(paramIntent, this)) {}
    do
    {
      return false;
      this.b = ((ForwardFileInfo)super.getIntent().getParcelableExtra("fileinfo"));
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager = new FileBrowserManager(this, this, localTroopFileViewerParamParser.a(this));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewListener);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileBrowserManager.a(a(), new RelativeLayout.LayoutParams(-1, -1))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w("FileBrowserActivity<FileAssistant>", 2, "error. can not create a fileviewer from FileBrowserManager");
    return false;
    if (localTroopFileViewerParamParser.a() == 1) {
      ReportController.b(super.a(), "P_CliOper", "Grp_files", "", "in_mid", "pic_enter", 0, 0, this.b.a() + "", this.jdField_a_of_type_Int + "", a(getApplicationContext()) + "", FileManagerUtil.b(FileManagerUtil.a(this.b.d())));
    }
    for (;;)
    {
      return true;
      ReportController.b(super.a(), "P_CliOper", "Grp_files", "", "in_mid", "nonpic_enter", 0, 0, this.b.a() + "", this.jdField_a_of_type_Int + "", a(getApplicationContext()) + "", FileManagerUtil.b(FileManagerUtil.a(this.b.d())));
    }
  }
  
  public boolean b()
  {
    if ((getIntent() != null) && (getIntent().getIntExtra("from_type_troop", -1) == 3)) {
      return true;
    }
    return super.b();
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
    this.app.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity
 * JD-Core Version:    0.7.0.1
 */