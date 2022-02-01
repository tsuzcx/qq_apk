package com.tencent.mobileqq.filemanager.openbrowser;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.widget.BaseAdapter;
import com.tencent.biz.troop.file.ZipFilesListAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.filebrowser.IFileBrowserData;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel.OnEventListener;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel.OnMMApkSafeCheckListener;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel.OnThumbEventListener;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel.OnTransEventListener;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel.OnZipEventListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter.EntityFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.FileViewAdapter.TroopFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel;
import com.tencent.mobileqq.filemanager.fileviewer.model.DatalineFileModel;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnMMApkSafeCheckListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnThumbEventListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnTransEventListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.OnZipEventListener;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanageraux.fileviewer.model.DocsExportFileModel;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;

public class FileModelAdapter
  extends FileBrowserModelDefault
{
  private int jdField_a_of_type_Int;
  protected Activity a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private ZipFilesListAdapter jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IFileBrowserData jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData;
  private IFileBrowserModel.OnEventListener jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel$OnEventListener;
  private IFileBrowserModel.OnMMApkSafeCheckListener jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel$OnMMApkSafeCheckListener;
  private IFileBrowserModel.OnThumbEventListener jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel$OnThumbEventListener;
  private IFileBrowserModel.OnTransEventListener jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel$OnTransEventListener;
  private IFileBrowserModel.OnZipEventListener jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel$OnZipEventListener;
  private final IFileBrowser jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser = new FileModelAdapter.2(this);
  private IFileViewerAdapter jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
  private final FileBrowserModelBase.OnMMApkSafeCheckListener jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnMMApkSafeCheckListener = new FileModelAdapter.1(this);
  private final FileBrowserModelBase.OnThumbEventListener jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener = new FileModelAdapter.4(this);
  private final FileBrowserModelBase.OnTransEventListener jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener = new FileModelAdapter.3(this);
  private final FileBrowserModelBase.OnZipEventListener jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener = new FileModelAdapter.5(this);
  private FileBrowserModelBase jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public FileModelAdapter(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.getCloudType() != 9)
    {
      int i = paramFileManagerEntity.peerType;
      if (i != 6000)
      {
        if (i != 9501) {
          a(paramQQAppInterface, paramFileManagerEntity, 1);
        }
      }
      else {
        a(paramQQAppInterface, paramFileManagerEntity, 3);
      }
    }
    else
    {
      a(paramQQAppInterface, paramFileManagerEntity, 4);
    }
  }
  
  public FileModelAdapter(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    a(paramQQAppInterface, paramFileManagerEntity, paramInt);
  }
  
  private void a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt != 1) {
      if (paramInt != 2)
      {
        if ((paramInt != 3) && (paramInt != 4))
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter = null;
          this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData = null;
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter = new TroopFileViewerAdapter(paramQQAppInterface, paramFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData = new TroopFileBrowserData(paramQQAppInterface, paramFileManagerEntity);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter = new EntityFileViewerAdapter(paramQQAppInterface, paramFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData = new EntityFileBrowserData(paramQQAppInterface, paramFileManagerEntity);
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  public float a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a() != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().fProgress;
    }
    return 0.0F;
  }
  
  public int a()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase != null) {
      return localFileBrowserModelBase.a();
    }
    return 0;
  }
  
  public Intent a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (localFileManagerEntity == null) {
      return null;
    }
    return QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity);
  }
  
  public BaseAdapter a()
  {
    return this.jdField_a_of_type_ComTencentBizTroopFileZipFilesListAdapter;
  }
  
  public IServiceInfo a()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase == null) {
      return null;
    }
    return localFileBrowserModelBase.a();
  }
  
  public IFileBrowserData a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserData;
  }
  
  public TeamWorkFileImportInfo a()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase == null) {
      return null;
    }
    return localFileBrowserModelBase.a();
  }
  
  public String a()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface == null) {
      return "";
    }
    return localQQAppInterface.getCurrentAccountUin();
  }
  
  public void a()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase != null) {
      localFileBrowserModelBase.j();
    }
  }
  
  public void a(int paramInt)
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase == null) {
      return;
    }
    localFileBrowserModelBase.d(paramInt);
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter);
    int i = this.jdField_a_of_type_Int;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase = null;
          } else {
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase = new DocsExportFileModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramActivity, localArrayList, 0);
          }
        }
        else {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase = new DatalineFileModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramActivity, localArrayList, 0);
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase = new TroopFileModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramActivity, localArrayList, 0);
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase = new C2CFileModel(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramActivity, localArrayList, 0);
    }
    paramActivity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (paramActivity != null)
    {
      paramActivity.a(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(IFileBrowserModel.OnEventListener paramOnEventListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel$OnEventListener = paramOnEventListener;
  }
  
  public void a(IFileBrowserModel.OnMMApkSafeCheckListener paramOnMMApkSafeCheckListener)
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel$OnMMApkSafeCheckListener = paramOnMMApkSafeCheckListener;
    localFileBrowserModelBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnMMApkSafeCheckListener);
  }
  
  public void a(IFileBrowserModel.OnThumbEventListener paramOnThumbEventListener)
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel$OnThumbEventListener = paramOnThumbEventListener;
    localFileBrowserModelBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnThumbEventListener);
  }
  
  public void a(IFileBrowserModel.OnTransEventListener paramOnTransEventListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel$OnTransEventListener = paramOnTransEventListener;
  }
  
  public void a(IFileBrowserModel.OnZipEventListener paramOnZipEventListener)
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel$OnZipEventListener = paramOnZipEventListener;
    localFileBrowserModelBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener);
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase == null) {
      return;
    }
    localFileBrowserModelBase.a(paramActionSheetItem);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a() != null) {
      return FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
    }
    return false;
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase == null) {
      return null;
    }
    return localFileBrowserModelBase.a();
  }
  
  public int b()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase != null) {
      return localFileBrowserModelBase.h();
    }
    return 2;
  }
  
  public String b()
  {
    return FileUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b());
  }
  
  public void b()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase != null) {
      localFileBrowserModelBase.k();
    }
  }
  
  public boolean b()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase == null) {
      return false;
    }
    return localFileBrowserModelBase.i();
  }
  
  public int c()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase != null) {
      return localFileBrowserModelBase.i();
    }
    return 0;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.i();
  }
  
  public void c()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase != null) {
      localFileBrowserModelBase.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilebrowserIFileBrowserModel$OnTransEventListener = null;
    k();
  }
  
  public boolean c()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase == null) {
      return false;
    }
    return localFileBrowserModelBase.f();
  }
  
  public String d()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (localFileManagerEntity == null) {
      return null;
    }
    return localFileManagerEntity.mExcitingSpeed;
  }
  
  public void d()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase == null) {
      return;
    }
    localFileBrowserModelBase.a().a();
  }
  
  public boolean d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a() != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().isFromProcessingForward2c2cOrDiscItem();
    }
    return false;
  }
  
  public String e()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase == null) {
      return "";
    }
    return localFileBrowserModelBase.l();
  }
  
  public void e()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase == null) {
      return;
    }
    localFileBrowserModelBase.a().b();
  }
  
  public boolean e()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase == null) {
      return false;
    }
    return localFileBrowserModelBase.a();
  }
  
  public String f()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase == null) {
      return "";
    }
    return localFileBrowserModelBase.j();
  }
  
  public void f()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase == null) {
      return;
    }
    localFileBrowserModelBase.a().a();
  }
  
  public boolean f()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase == null) {
      return false;
    }
    return localFileBrowserModelBase.j();
  }
  
  public String g()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase == null) {
      return "";
    }
    return localFileBrowserModelBase.k();
  }
  
  public void g()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase == null) {
      return;
    }
    localFileBrowserModelBase.a().b();
  }
  
  public void h()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase == null) {
      return;
    }
    localFileBrowserModelBase.f();
  }
  
  public void i()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase == null) {
      return;
    }
    localFileBrowserModelBase.h();
  }
  
  public void j()
  {
    FileBrowserModelBase localFileBrowserModelBase = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase;
    if (localFileBrowserModelBase == null) {
      return;
    }
    localFileBrowserModelBase.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.openbrowser.FileModelAdapter
 * JD-Core Version:    0.7.0.1
 */