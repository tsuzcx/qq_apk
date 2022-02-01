package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.OfflinePreviewController;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
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
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.qroute.QRoute;
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
    int k = d();
    if (k == 0) {
      return 9;
    }
    String str = b();
    boolean bool = FileManagerUtil.a(d());
    int j = 1;
    if ((!bool) && (QFileAssistantUtils.a(str))) {
      return 1;
    }
    int i = super.a();
    if (i != 0) {
      return i;
    }
    int m = e();
    if (m != 0)
    {
      i = j;
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 4) {
            if (m == 5) {}
          }
          while ((!FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter, false)) || (!FileManagerUtil.a(this.jdField_a_of_type_AndroidAppActivity, c(), c())))
          {
            return 7;
            return 11;
          }
          return 5;
        }
        i = j;
        if (k != 2)
        {
          if (f()) {
            return 1;
          }
          return 2;
        }
      }
    }
    else
    {
      i = 6;
    }
    return i;
  }
  
  public IServiceInfo a()
  {
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    Object localObject1 = localObject3;
    Object localObject2;
    if (localObject3 == null) {
      try
      {
        localObject1 = FileManagerUtil.a(new FileInfo(d()));
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
        localObject2 = localObject3;
      }
    }
    if (localObject2 == null) {
      return new DefaultFileColorNoteServiceInfo();
    }
    if ((this.b == 14) && (this.jdField_a_of_type_AndroidOsBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("file_color_note_subType")))
    {
      int i = this.jdField_a_of_type_AndroidOsBundle.getInt("file_color_note_subType", -1);
      localObject3 = d();
      if ((i == 4) && (FileUtils.fileExistsAndNotEmpty((String)localObject3))) {
        return new FavFileColorNoteServiceInfo(localObject2.getFilePath());
      }
    }
    localObject3 = d();
    if ((TextUtils.isEmpty(localObject2.Uuid)) && (FileUtils.fileExistsAndNotEmpty((String)localObject3))) {
      return new LocalFileColorNoteServiceInfo(localObject2.getFilePath());
    }
    if (!TextUtils.isEmpty(localObject2.Uuid)) {
      return new OfflineFileColorNoteServiceInfo(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
    }
    if (!TextUtils.isEmpty(localObject2.WeiYunFileId)) {
      return new CloudFileColorNoteServiceInfo(localObject2);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unsuporrt peer type:");
    localStringBuilder.append(localFileManagerEntity.peerType);
    QLog.w("C2CFileModel<FileAssistant>", 1, localStringBuilder.toString());
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
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      return;
    }
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("file_location_pos_entrance_multiseq", false)) {
      return;
    }
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("FromChatHistoryTab", 0);
    if (i == 106) {
      return;
    }
    i = QFileUtils.c(this.b, i);
    if (i == 0) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("file_location_pos_entrance_type", i);
    paramArrayList.add(QFileUtils.a(54, FileOperaterUtils.a(this.jdField_a_of_type_AndroidAppActivity, localBundle, paramFileManagerEntity)));
    ReportController.b(null, "dc00898", "", "", "0X800B450", "0X800B450", i, 0, "", "", "", "");
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (localFileManagerEntity == null) {
      return;
    }
    int m = paramActionSheetItem.action;
    int k = 1;
    int j;
    if (m == 52)
    {
      int i = localFileManagerEntity.getCloudType();
      if (i == 2) {
        i = -1006;
      } else if (i == 1) {
        i = -1001;
      } else {
        i = -1004;
      }
      Object localObject = localFileManagerEntity.strFileMd5;
      paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramActionSheetItem = localFileManagerEntity.str10Md5;
      }
      String str = d();
      localObject = str;
      if (!FileUtils.fileExistsAndNotEmpty(str)) {
        localObject = localFileManagerEntity.strLargeThumPath;
      }
      j = k;
      if (FileUtils.fileExistsAndNotEmpty((String)localObject))
      {
        ((IOCR)QRoute.api(IOCR.class)).startOcrPerformFragment(this.jdField_a_of_type_AndroidAppActivity, (String)localObject, 1, i, paramActionSheetItem);
        j = k;
      }
    }
    else
    {
      j = 0;
      super.a(paramActionSheetItem);
    }
    if (j != 0) {
      f(m);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    int i = d();
    if ((i != 0) && (i != 11)) {
      return super.a();
    }
    return null;
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
  
  public void c()
  {
    super.c();
    if ((FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter, true)) && (FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter, true))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().e();
    }
  }
  
  public void d()
  {
    int i = i();
    int j = d();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (i == 6)
    {
      if (j == 0) {
        localQQAppInterface.getOnlineFileSessionCenter().b(d());
      } else {
        localQQAppInterface.getFileManagerEngine().a(d());
      }
    }
    else if (j == 0) {
      localQQAppInterface.getOnlineFileSessionCenter().a(d());
    } else {
      localQQAppInterface.getFileManagerEngine().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.d();
    }
  }
  
  public void g()
  {
    if ((FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter, true)) && (FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter, true)))
    {
      long l = d();
      if (d() == 2) {
        l = FileManagerUtil.a(c());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().b(l, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().WeiYunFileId);
    }
    super.g();
  }
  
  public int h()
  {
    if (g() == 51) {
      return 1;
    }
    return super.h();
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
  
  public void i()
  {
    super.i();
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (d() == 1)
    {
      if (f() == 3000)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(new DiscOfflinePreviewController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.Uuid, localFileManagerEntity.peerUin));
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(new OfflinePreviewController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.Uuid, localFileManagerEntity.fileIdCrc));
    }
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
    int j = 1;
    if ((i != 0) && (i != 2) && (i != 13)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return 0;
    }
    String str = d();
    boolean bool = FileUtil.a(str);
    FileManagerEntity localFileManagerEntity3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    FileManagerEntity localFileManagerEntity1 = localFileManagerEntity3;
    FileManagerEntity localFileManagerEntity2;
    if (bool)
    {
      localFileManagerEntity1 = localFileManagerEntity3;
      if (localFileManagerEntity3 == null) {
        try
        {
          localFileManagerEntity1 = FileManagerUtil.a(new FileInfo(str));
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          localFileNotFoundException.printStackTrace();
          localFileManagerEntity2 = localFileManagerEntity3;
        }
      }
    }
    if (localFileManagerEntity2 == null) {
      return 0;
    }
    if (localFileManagerEntity2.status == 16) {
      return 0;
    }
    if (g() == 0)
    {
      i = b();
      if ((i == 0) || (i == 3) || (i == 2)) {
        return 0;
      }
    }
    if ((TextUtils.isEmpty(localFileManagerEntity2.Uuid)) && (TextUtils.isEmpty(localFileManagerEntity2.WeiYunFileId)) && (!FileUtils.fileExistsAndNotEmpty(str))) {
      return 0;
    }
    i = j;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.e()) {
        i = 2;
      }
    }
    return i;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel
 * JD-Core Version:    0.7.0.1
 */