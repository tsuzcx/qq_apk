package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ar.codeEngine.MiniCodeController;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.ControlerCallback;
import com.tencent.mobileqq.filemanager.core.FilePreViewControllerBase;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.colornote.DefaultFileColorNoteServiceInfo;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IThumbController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.filemanager.fileviewer.data.BaseVideoBiz;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public abstract class FileBrowserModelBase
{
  protected int a;
  public Activity a;
  public Bundle a;
  private MiniCodeController a;
  protected FilePreviewActivity.ControlerCallback a;
  protected FilePreViewControllerBase a;
  public IFileBrowser a;
  protected IDownloadController a;
  protected IThumbController a;
  protected IUploadController a;
  protected FileBrowserModelBase.OnMMApkSafeCheckListener a;
  public FileBrowserModelBase.OnThumbEventListener a;
  public FileBrowserModelBase.OnTransEventListener a;
  protected FileBrowserModelBase.OnZipEventListener a;
  protected ArrayList<ShareActionSheetBuilder.ActionSheetItem> a;
  protected HashMap<String, ArrayList<ShareActionSheetBuilder.ActionSheetItem>> a;
  protected int b;
  protected String f;
  
  public FileBrowserModelBase(Activity paramActivity)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.b = 0;
  }
  
  public abstract float a();
  
  public int a()
  {
    int i = 3;
    int j = e();
    if ((d() == 3) && (FileManagerUtil.c(d())) && (b() != 16))
    {
      switch (j)
      {
      case 3: 
      default: 
        i = 1;
      case 5: 
        return i;
      case 1: 
        return 4;
      case 2: 
        return 2;
      case 0: 
        return 6;
      }
      if (h()) {
        return 5;
      }
      return 1;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserModelBase", 2, "getCreateFileType error : this is a local file, but is invalid, may be can not find file path");
    }
    return 0;
  }
  
  public Intent a()
  {
    return null;
  }
  
  public IServiceInfo a()
  {
    return new DefaultFileColorNoteServiceInfo();
  }
  
  public abstract IDownloadController a();
  
  public abstract IThumbController a();
  
  public abstract IUploadController a();
  
  public BaseVideoBiz a()
  {
    return null;
  }
  
  public abstract TeamWorkFileImportInfo a();
  
  public String a()
  {
    return "";
  }
  
  public abstract List<FileBrowserModelBase.ImageFileInfo> a();
  
  protected abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt, FileBrowserModelBase.ImageFileInfo paramImageFileInfo);
  
  public abstract void a(int paramInt, String paramString);
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(IFileBrowser paramIFileBrowser)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser = paramIFileBrowser;
  }
  
  public void a(FileBrowserModelBase.OnMMApkSafeCheckListener paramOnMMApkSafeCheckListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnMMApkSafeCheckListener = paramOnMMApkSafeCheckListener;
  }
  
  public abstract void a(FileBrowserModelBase.OnPreviewVideoOnlineListener paramOnPreviewVideoOnlineListener);
  
  public void a(FileBrowserModelBase.OnThumbEventListener paramOnThumbEventListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener = paramOnThumbEventListener;
  }
  
  public void a(FileBrowserModelBase.OnTransEventListener paramOnTransEventListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener = paramOnTransEventListener;
  }
  
  public void a(FileBrowserModelBase.OnZipEventListener paramOnZipEventListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener = paramOnZipEventListener;
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem) {}
  
  public void a(String paramString, Bundle paramBundle) {}
  
  public void a(List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    if (paramList == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_JavaUtilHashMap == null) {
          this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        }
        localObject = e();
      } while (!FileUtils.b((String)localObject));
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject)) {
        break;
      }
      localObject = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
    } while ((localObject == null) || (((ArrayList)localObject).isEmpty()));
    paramList.addAll((Collection)localObject);
    return;
    QFileUtils.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject, new FileBrowserModelBase.1(this, (String)localObject));
  }
  
  public abstract void a(boolean paramBoolean);
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(FileBrowserModelBase.OnPreviewVideoOnlineListener paramOnPreviewVideoOnlineListener)
  {
    if (paramOnPreviewVideoOnlineListener != null) {
      paramOnPreviewVideoOnlineListener.av_();
    }
    return false;
  }
  
  public abstract ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a();
  
  public abstract int b();
  
  public abstract long b();
  
  public abstract String b();
  
  protected abstract void b();
  
  public abstract void b(int paramInt);
  
  public void b(List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      paramList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    }
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
  
  public abstract boolean b();
  
  public abstract ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] b();
  
  public int c()
  {
    if (this.jdField_a_of_type_Int < 0) {
      return 0;
    }
    return this.jdField_a_of_type_Int;
  }
  
  public abstract long c();
  
  public abstract String c();
  
  public abstract void c(int paramInt);
  
  public abstract boolean c();
  
  public abstract int d();
  
  public abstract long d();
  
  public abstract String d();
  
  protected abstract void d();
  
  public abstract void d(int paramInt);
  
  public abstract boolean d();
  
  public abstract int e();
  
  public String e()
  {
    return "";
  }
  
  public abstract void e();
  
  public void e(int paramInt)
  {
    this.b = paramInt;
  }
  
  public abstract boolean e();
  
  public abstract int f();
  
  public abstract String f();
  
  public abstract void f();
  
  protected void f(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 118: 
      ReportController.b(null, "dc00898", "", "", "0X800ADBC", "0X800ADBC", 0, 0, "", "", "", "");
      return;
    case 52: 
      ReportController.b(null, "dc00898", "", "", "0X800ADBD", "0X800ADBD", 0, 0, "", "", "", "");
      return;
    case 55: 
      ReportController.b(null, "dc00898", "", "", "0X800ADBE", "0X800ADBE", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800ADBF", "0X800ADBF", 0, 0, "", "", "", "");
  }
  
  public abstract boolean f();
  
  public abstract int g();
  
  public abstract String g();
  
  public abstract void g();
  
  public abstract boolean g();
  
  public abstract int h();
  
  public abstract String h();
  
  public abstract boolean h();
  
  public abstract int i();
  
  public String i()
  {
    return null;
  }
  
  public void i()
  {
    a();
    m();
  }
  
  public abstract boolean i();
  
  public int j()
  {
    return 0;
  }
  
  public String j()
  {
    return "";
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener = null;
    }
  }
  
  public abstract boolean j();
  
  public int k()
  {
    return 0;
  }
  
  public String k()
  {
    return "";
  }
  
  public void k_()
  {
    b();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener = null;
    }
    n();
  }
  
  public int l()
  {
    return this.b;
  }
  
  public String l()
  {
    return "";
  }
  
  public void l() {}
  
  public boolean l()
  {
    return this.b != 12;
  }
  
  public int m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a();
    }
    return 0;
  }
  
  public String m()
  {
    return "";
  }
  
  protected void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniCodeController != null) {
      return;
    }
    ThreadManagerV2.executeOnSubThread(new FileBrowserModelBase.3(this));
  }
  
  public String n()
  {
    return null;
  }
  
  protected void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniCodeController == null) {
      return;
    }
    ThreadManagerV2.executeOnSubThread(new FileBrowserModelBase.4(this));
  }
  
  public String o()
  {
    return "";
  }
  
  public String p()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
 * JD-Core Version:    0.7.0.1
 */