package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.OfflinePreviewController;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.colornote.CloudFileColorNoteServiceInfo;
import com.tencent.mobileqq.filemanager.fileviewer.colornote.DefaultFileColorNoteServiceInfo;
import com.tencent.mobileqq.filemanager.fileviewer.colornote.FavFileColorNoteServiceInfo;
import com.tencent.mobileqq.filemanager.fileviewer.colornote.LocalFileColorNoteServiceInfo;
import com.tencent.mobileqq.filemanager.fileviewer.colornote.OfflineFileColorNoteServiceInfo;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.filemanager.fileviewer.data.BaseVideoBiz;
import com.tencent.mobileqq.filemanager.fileviewer.data.VideoForC2C;
import com.tencent.mobileqq.filemanager.fileviewer.data.VideoForDisc;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanageraux.core.DiscOfflinePreviewController;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class C2CFileModel
  extends DefaultFileModel
{
  private FMObserver a;
  
  public C2CFileModel(QQAppInterface paramQQAppInterface, Activity paramActivity, List<IFileViewerAdapter> paramList, int paramInt)
  {
    super(paramQQAppInterface, paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("C2CFileModel<FileAssistant>", 1, "FileBrowserModel init: type = c2c");
    }
    a(paramList, paramInt);
  }
  
  public int a()
  {
    int j = 2;
    int i = 1;
    int k = d();
    if (k == 0) {
      i = 9;
    }
    String str;
    do
    {
      return i;
      str = b();
    } while ((!FileManagerUtil.b(d())) && (QFileAssistantUtils.a(str)));
    i = super.a();
    if (i != 0) {
      return i;
    }
    switch (e())
    {
    case 3: 
    default: 
      i = 7;
    }
    for (;;)
    {
      return i;
      if (k != 2)
      {
        i = j;
        if (!f()) {}
      }
      else
      {
        i = 1;
        continue;
        if ((FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter, false)) && (FileManagerUtil.a(this.jdField_a_of_type_AndroidAppActivity, c(), c())))
        {
          i = 5;
        }
        else
        {
          i = 7;
          continue;
          i = 6;
          continue;
          i = 1;
          continue;
          i = 11;
        }
      }
    }
  }
  
  public Intent a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (localFileManagerEntity == null) {
      return null;
    }
    return QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity);
  }
  
  public IServiceInfo a()
  {
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    Object localObject1 = localObject3;
    if (localObject3 == null) {}
    try
    {
      localObject1 = FileManagerUtil.a(new FileInfo(d()));
      if (localObject1 == null) {
        return new DefaultFileColorNoteServiceInfo();
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Object localObject2;
      for (;;)
      {
        localFileNotFoundException.printStackTrace();
        localObject2 = localObject3;
      }
      if ((this.b == 14) && (this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("file_color_note_subType")))
      {
        int i = this.jdField_a_of_type_AndroidOsBundle.getInt("file_color_note_subType", -1);
        localObject3 = d();
        if ((i == 4) && (FileUtils.b((String)localObject3))) {
          return new FavFileColorNoteServiceInfo(localObject2.getFilePath());
        }
      }
      localObject3 = d();
      if ((TextUtils.isEmpty(localObject2.Uuid)) && (FileUtils.b((String)localObject3))) {
        return new LocalFileColorNoteServiceInfo(localObject2.getFilePath());
      }
      if (!TextUtils.isEmpty(localObject2.Uuid)) {
        return new OfflineFileColorNoteServiceInfo(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
      }
      if (!TextUtils.isEmpty(localObject2.WeiYunFileId)) {
        return new CloudFileColorNoteServiceInfo(localObject2);
      }
    }
    return new DefaultFileColorNoteServiceInfo();
  }
  
  public IDownloadController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIDownloadController == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIDownloadController = new C2CFileModel.1(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIDownloadController;
  }
  
  public IUploadController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIUploadController == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIUploadController = new C2CFileModel.2(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIUploadController;
  }
  
  public BaseVideoBiz a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (localFileManagerEntity == null) {
      return null;
    }
    if (localFileManagerEntity.peerType == 0) {
      return new VideoForC2C(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
    }
    if (localFileManagerEntity.peerType == 3000) {
      return new VideoForDisc(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
    }
    QLog.w("C2CFileModel<FileAssistant>", 1, "unsuporrt peer type:" + localFileManagerEntity.peerType);
    return null;
  }
  
  public String a()
  {
    return "biz_src_jc_file";
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new C2CFileModel.C2CFileObserver(this, null);
    if (QLog.isDevelopLevel()) {
      QLog.i("fobserver<FileAssistant>", 1, "add fmObserver");
    }
    ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getFileManagerNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    if (this.jdField_a_of_type_AndroidOsBundle == null) {}
    int i;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_AndroidOsBundle.getBoolean("file_location_pos_entrance_multiseq", false));
        i = this.jdField_a_of_type_AndroidOsBundle.getInt("FromChatHistoryTab", 0);
      } while (i == 106);
      i = QFileUtils.c(this.b, i);
    } while (i == 0);
    Bundle localBundle = new Bundle();
    localBundle.putInt("file_location_pos_entrance_type", i);
    paramArrayList.add(QFileUtils.a(54, FileOperaterUtils.a(this.jdField_a_of_type_AndroidAppActivity, localBundle, paramFileManagerEntity)));
    ReportController.b(null, "dc00898", "", "", "0X800B450", "0X800B450", i, 0, "", "", "", "");
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem == null) {}
    label155:
    for (;;)
    {
      return;
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
      if (localFileManagerEntity != null)
      {
        int j = paramActionSheetItem.action;
        int i;
        if (j == 52)
        {
          i = localFileManagerEntity.getCloudType();
          if (i == 2)
          {
            i = -1006;
            Object localObject = localFileManagerEntity.strFileMd5;
            paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject;
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              paramActionSheetItem = localFileManagerEntity.str10Md5;
            }
            String str = d();
            localObject = str;
            if (!FileUtils.b(str)) {
              localObject = localFileManagerEntity.strLargeThumPath;
            }
            if (FileUtils.b((String)localObject)) {
              OCRPerformFragment.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject, 1, i, paramActionSheetItem);
            }
            i = 1;
          }
        }
        for (;;)
        {
          if (i == 0) {
            break label155;
          }
          f(j);
          return;
          if (i == 1)
          {
            i = -1001;
            break;
          }
          i = -1004;
          break;
          i = 0;
          super.a(paramActionSheetItem);
        }
      }
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    int i = d();
    if ((i == 0) || (i == 11)) {
      return null;
    }
    return super.a();
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "del fmObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getFileManagerNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a() == null) {}
  }
  
  public void f()
  {
    if ((FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter, true)) && (FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter, true)))
    {
      long l = d();
      if (d() == 2) {
        l = FileManagerUtil.a(c());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b(l, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().WeiYunFileId);
    }
    super.f();
  }
  
  public int h()
  {
    if (g() == 51) {
      return 1;
    }
    return super.h();
  }
  
  public void h()
  {
    super.h();
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (d() == 1)
    {
      if (f() == 3000) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(new DiscOfflinePreviewController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.Uuid, localFileManagerEntity.peerUin));
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(new OfflinePreviewController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.Uuid, localFileManagerEntity.fileIdCrc));
  }
  
  public int i()
  {
    int i = super.i();
    if (g() == 10) {
      i = 6;
    }
    return i;
  }
  
  public String i()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (localFileManagerEntity == null) {
      return null;
    }
    return localFileManagerEntity.mExcitingSpeed;
  }
  
  public boolean i()
  {
    int i = g();
    if ((d() == 0) && ((i == 11) || (i == 12) || (i == 13))) {
      return false;
    }
    return super.i();
  }
  
  public int j()
  {
    int i = e();
    if ((i != 0) && (i != 2) && (i != 13)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        return 0;
      }
      String str = d();
      boolean bool = FileUtil.b(str);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
      if ((bool) && (localObject == null)) {}
      for (;;)
      {
        try
        {
          FileManagerEntity localFileManagerEntity = FileManagerUtil.a(new FileInfo(str));
          localObject = localFileManagerEntity;
          if ((localObject == null) || (((FileManagerEntity)localObject).status == 16)) {
            break;
          }
          if (g() == 0)
          {
            i = b();
            if ((i == 0) || (i == 3) || (i == 2)) {
              break;
            }
          }
          if ((TextUtils.isEmpty(((FileManagerEntity)localObject).Uuid)) && (TextUtils.isEmpty(((FileManagerEntity)localObject).WeiYunFileId)) && (!FileUtils.b(str))) {
            break;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser == null) || (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.e())) {
            break label173;
          }
          return 2;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          localFileNotFoundException.printStackTrace();
        }
      }
      label173:
      return 1;
    }
  }
  
  public String j()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.yybApkPackageName;
    }
    return "";
  }
  
  public String k()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.yybApkName;
    }
    return "";
  }
  
  public void k_()
  {
    super.k_();
    if ((FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter, true)) && (FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter, true))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().f();
    }
  }
  
  public String l()
  {
    if (e() == 5)
    {
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
      if (localFileManagerEntity != null) {
        return localFileManagerEntity.yybApkIconUrl;
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel
 * JD-Core Version:    0.7.0.1
 */