package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.filemanager.core.ControlerCallback;
import com.tencent.mobileqq.filemanager.core.FilePreViewControllerBase;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.colornote.DefaultFileColorNoteServiceInfo;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IThumbController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.filemanager.fileviewer.data.BaseVideoBiz;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
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
  protected Activity a;
  protected Bundle a;
  protected ControlerCallback a;
  protected FilePreViewControllerBase a;
  protected IFileBrowser a;
  protected IDownloadController a;
  protected IThumbController a;
  protected IUploadController a;
  protected FileBrowserModelBase.OnMMApkSafeCheckListener a;
  protected FileBrowserModelBase.OnThumbEventListener a;
  protected FileBrowserModelBase.OnTransEventListener a;
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
    int i = e();
    if ((d() == 3) && (QQFileManagerUtil.b(d())) && (b() != 16))
    {
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 4) {
              if (i == 5) {}
            }
            while (!h())
            {
              return 1;
              return 3;
            }
            return 5;
          }
          return 2;
        }
        return 4;
      }
      return 6;
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
    if (paramList == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    Object localObject = e();
    if (FileUtils.fileExistsAndNotEmpty((String)localObject)) {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject))
      {
        localObject = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
        if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
          paramList.addAll((Collection)localObject);
        }
      }
      else
      {
        QFileUtils.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject, new FileBrowserModelBase.1(this, (String)localObject));
      }
    }
  }
  
  public abstract void a(boolean paramBoolean);
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(FileBrowserModelBase.OnPreviewVideoOnlineListener paramOnPreviewVideoOnlineListener)
  {
    if (paramOnPreviewVideoOnlineListener != null) {
      paramOnPreviewVideoOnlineListener.an_();
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
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (!localArrayList.isEmpty())) {
      paramList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    }
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
  
  public abstract boolean b();
  
  public abstract ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] b();
  
  public int c()
  {
    int j = this.jdField_a_of_type_Int;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    return i;
  }
  
  public abstract long c();
  
  public abstract String c();
  
  public void c()
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
    o();
  }
  
  public abstract void c(int paramInt);
  
  public abstract boolean c();
  
  public abstract int d();
  
  public abstract long d();
  
  public abstract String d();
  
  public abstract void d(int paramInt);
  
  public abstract boolean d();
  
  public abstract int e();
  
  public String e()
  {
    return "";
  }
  
  protected abstract void e();
  
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
    if (paramInt != 52)
    {
      if (paramInt != 118)
      {
        if (paramInt != 55)
        {
          if (paramInt != 56) {
            return;
          }
          ReportController.b(null, "dc00898", "", "", "0X800ADBF", "0X800ADBF", 0, 0, "", "", "", "");
          return;
        }
        ReportController.b(null, "dc00898", "", "", "0X800ADBE", "0X800ADBE", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(null, "dc00898", "", "", "0X800ADBC", "0X800ADBC", 0, 0, "", "", "", "");
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800ADBD", "0X800ADBD", 0, 0, "", "", "", "");
  }
  
  public abstract boolean f();
  
  public abstract int g();
  
  public abstract String g();
  
  public abstract void g();
  
  public abstract boolean g();
  
  public abstract int h();
  
  public abstract String h();
  
  public abstract void h();
  
  public abstract boolean h();
  
  public abstract int i();
  
  public String i()
  {
    return null;
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
    a();
    n();
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
  
  public void k()
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
  
  public int l()
  {
    return this.b;
  }
  
  public String l()
  {
    return "";
  }
  
  public boolean l()
  {
    return this.b != 12;
  }
  
  public int m()
  {
    return this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299168);
  }
  
  public String m()
  {
    return "";
  }
  
  public void m() {}
  
  public String n()
  {
    return null;
  }
  
  protected void n()
  {
    ThreadManagerV2.executeOnSubThread(new FileBrowserModelBase.3(this));
  }
  
  public String o()
  {
    return "";
  }
  
  protected void o()
  {
    ThreadManagerV2.executeOnSubThread(new FileBrowserModelBase.4(this));
  }
  
  public String p()
  {
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase
 * JD-Core Version:    0.7.0.1
 */