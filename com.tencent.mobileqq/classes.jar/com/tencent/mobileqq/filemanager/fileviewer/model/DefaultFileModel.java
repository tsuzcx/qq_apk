package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.dataline.data.PrinterManager;
import com.tencent.biz.troop.file.TroopFileProtocol.OnGetZipFileList;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.tendoc.TenDocDirectShareConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TenDocDirectShareConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoProcessor;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.filemanager.activity.fileviewer.base.FileViewerFacade;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FilePreViewControllerBase;
import com.tencent.mobileqq.filemanager.core.OfflinePreviewController;
import com.tencent.mobileqq.filemanager.data.DownloadFileConfig;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.util.DatalineDeviceChooseModel;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.QFileBrowserUtils;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IThumbController;
import com.tencent.mobileqq.filemanager.fileviewer.data.DefaultImageInfo;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanageraux.core.DiscOfflinePreviewController;
import com.tencent.mobileqq.filemanageraux.core.WeiYunPreviewController;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanageraux.link.LinkUtils;
import com.tencent.mobileqq.ocr.OCRManager;
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.util.URLUtil;
import cooperation.qqreader.QRLocalManager;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

public abstract class DefaultFileModel
  extends FileBrowserModelBase
{
  public QQAppInterface a;
  public IFileViewerAdapter a;
  private TeamWorkFileImportInfo a;
  protected String a;
  protected List<IFileViewerAdapter> a;
  protected String b;
  protected String c;
  protected String d;
  protected String e;
  private String g = "";
  
  public DefaultFileModel(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private IFileViewerAdapter a()
  {
    if (this.jdField_a_of_type_Int > this.jdField_a_of_type_JavaUtilList.size() - 1)
    {
      QLog.e("FileBrowserModelBase", 1, "index error, index[" + this.jdField_a_of_type_Int + "], size[" + this.jdField_a_of_type_JavaUtilList.size() + "]");
      return (IFileViewerAdapter)this.jdField_a_of_type_JavaUtilList.get(0);
    }
    return (IFileViewerAdapter)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
  }
  
  private void b(FileManagerEntity paramFileManagerEntity, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    int i = 70;
    int j = j();
    if ((j != 0) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.f())) {
      if (j != 1) {
        break label59;
      }
    }
    for (;;)
    {
      paramArrayList.add(QFileUtils.a(i, new DefaultFileModel.7(this, j)));
      return;
      label59:
      if (j == 2) {
        i = 82;
      }
    }
  }
  
  private void c(FileManagerEntity paramFileManagerEntity, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    Object localObject2 = TencentDocImportFileInfoProcessor.a();
    Object localObject1 = TencentDocConvertConfigProcessor.a();
    if ((localObject2 != null) && (localObject1 != null))
    {
      localObject2 = ((TencentDocImportFileInfoBean)localObject2).c();
      boolean bool = ((TencentDocConvertConfigBean)localObject1).d();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = TeamWorkUtils.jdField_a_of_type_JavaLangString;
      }
      long l = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.fileName);
      if ((bool) && (TeamWorkUtils.a(paramFileManagerEntity.getFilePath(), paramFileManagerEntity.fileName, (String)localObject1)) && (paramFileManagerEntity.fileSize <= l))
      {
        paramFileManagerEntity = QFileUtils.a(119, FileOperaterUtils.a(paramFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity));
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
        paramArrayList.add(paramFileManagerEntity);
      }
    }
  }
  
  private void o()
  {
    int i = d();
    int j = f();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if ((localObject != null) && (!TextUtils.isEmpty(((FileManagerEntity)localObject).WeiYunFileId))) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(new WeiYunPreviewController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.e(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().WeiYunDirKey));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$ControlerCallback == null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$ControlerCallback = new DefaultFileModel.1(this, j);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$ControlerCallback);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase.a();
      }
      return;
      if (i == 2)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a() == null) {}
        for (localObject = "";; localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().jdField_b_of_type_JavaLangString)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(new WeiYunPreviewController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.e(), (String)localObject));
          break;
        }
      }
      if ((i == 1) || (i == 3))
      {
        if (j == 3000) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(new DiscOfflinePreviewController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.d()));
        } else {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(new OfflinePreviewController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.e()));
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("FileBrowserModelBase", 2, "loadZipFilesForOthers error. can not handle zip file");
      }
    }
  }
  
  public float a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a() != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().fProgress;
    }
    return 0.0F;
  }
  
  public Intent a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (localFileManagerEntity == null) {
      return null;
    }
    return QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity);
  }
  
  public IThumbController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIThumbController == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIThumbController = new DefaultFileModel.3(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIThumbController;
  }
  
  public TeamWorkFileImportInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo;
  }
  
  public String a()
  {
    return "biz_src_jc_file";
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem> a(FileManagerEntity paramFileManagerEntity)
  {
    int j = 0;
    String str = d();
    boolean bool = FileUtil.b(str);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QFileUtils.a(2, FileOperaterUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, paramFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity)));
    localArrayList.add(QFileUtils.a(26, null));
    TenDocDirectShareConfigBean localTenDocDirectShareConfigBean = TenDocDirectShareConfigProcessor.a();
    int i;
    if ((localTenDocDirectShareConfigBean != null) && (paramFileManagerEntity != null) && (localTenDocDirectShareConfigBean.a().contains(FileUtil.a(paramFileManagerEntity.fileName).replace(".", "").toLowerCase())))
    {
      i = 1;
      if (i != 0)
      {
        localArrayList.add(QFileUtils.a(120, FileOperaterUtils.a(paramFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity, true)));
        TenDocLogReportHelper.a(a(), "0X800A21C");
      }
      if (QRLocalManager.a().b(paramFileManagerEntity)) {
        localArrayList.add(QFileUtils.a(118, null));
      }
      i = j;
      if (paramFileManagerEntity != null)
      {
        i = j;
        if (!TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId))
        {
          i = j;
          if (!TextUtils.isEmpty(paramFileManagerEntity.WeiYunDirKey)) {
            i = 1;
          }
        }
      }
      if (i == 0)
      {
        if (!bool) {
          break label298;
        }
        localArrayList.add(QFileUtils.a(27, FileOperaterUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, str)));
      }
    }
    for (;;)
    {
      paramFileManagerEntity = WXShareHelper.a();
      if ((bool) && (paramFileManagerEntity.a()) && (paramFileManagerEntity.d())) {
        localArrayList.add(QFileUtils.a(9, FileOperaterUtils.b(this.jdField_a_of_type_AndroidAppActivity, str)));
      }
      if (bool) {
        localArrayList.add(QFileUtils.a(64, FileOperaterUtils.a(this.jdField_a_of_type_AndroidAppActivity, str)));
      }
      return localArrayList;
      i = 0;
      break;
      label298:
      if (d() == 1) {
        localArrayList.add(QFileUtils.a(27, FileOperaterUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, paramFileManagerEntity)));
      }
    }
  }
  
  public List<FileBrowserModelBase.ImageFileInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new DefaultImageInfo((IFileViewerAdapter)localIterator.next()));
      }
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().status = paramInt;
    }
  }
  
  public void a(int paramInt, FileBrowserModelBase.ImageFileInfo paramImageFileInfo)
  {
    IFileViewerAdapter localIFileViewerAdapter = ((DefaultImageInfo)paramImageFileInfo).a();
    if (localIFileViewerAdapter == null) {
      FMToastUtil.b(BaseApplicationImpl.getContext().getString(2131692421));
    }
    do
    {
      return;
      if ((FileManagerUtil.b(localIFileViewerAdapter.a())) && (1 == localIFileViewerAdapter.c())) {
        FMToastUtil.b(BaseApplicationImpl.getContext().getString(2131692421));
      }
    } while (localIFileViewerAdapter.f() != null);
    localIFileViewerAdapter.a(1);
    paramImageFileInfo.a(1);
  }
  
  public void a(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserModelBase", 2, "onVideoPlayerError : file entity is null");
      }
      return;
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    paramString.status = 16;
    paramString.mContext = "showed";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(paramString);
  }
  
  protected void a(FileManagerEntity paramFileManagerEntity, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList) {}
  
  public void a(FileBrowserModelBase.OnPreviewVideoOnlineListener paramOnPreviewVideoOnlineListener) {}
  
  public void a(FileBrowserModelBase.OnTransEventListener paramOnTransEventListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener = paramOnTransEventListener;
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem == null) {}
    Object localObject1;
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            Object localObject2;
            do
            {
              do
              {
                return;
                localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
                localObject2 = d();
              } while ((localObject1 == null) && (TextUtils.isEmpty((CharSequence)localObject2)));
              i = paramActionSheetItem.action;
              f(i);
              if (i == 73)
              {
                FileOperaterUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, (FileManagerEntity)localObject1, this.jdField_a_of_type_AndroidAppActivity).onClick(null);
                return;
              }
              if (i != 72) {
                break;
              }
              i = paramActionSheetItem.uinType;
              paramActionSheetItem = paramActionSheetItem.uin;
            } while (TextUtils.isEmpty(paramActionSheetItem));
            QFileUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject1, true, paramActionSheetItem, i);
            return;
            if (i == 39)
            {
              if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_AndroidAppActivity))
              {
                CheckPermission.requestSDCardPermission((AppActivity)this.jdField_a_of_type_AndroidAppActivity, new DefaultFileModel.5(this));
                return;
              }
              FileManagerUtil.a(this.jdField_a_of_type_AndroidAppActivity, d());
              return;
            }
            if (i != 52) {
              break;
            }
            localObject1 = d();
            paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
            if (!FileUtils.b((String)localObject1))
            {
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
              paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
              if (localObject2 != null) {
                paramActionSheetItem = ((FileManagerEntity)localObject2).strLargeThumPath;
              }
            }
          } while (!FileUtils.b(paramActionSheetItem));
          OCRPerformFragment.a(this.jdField_a_of_type_AndroidAppActivity, paramActionSheetItem, 1, -1004, null);
          return;
          if (i != 55) {
            break;
          }
          localObject1 = e();
        } while (!FileUtils.b((String)localObject1));
        QFileUtils.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject1, paramActionSheetItem.argus, null, 1);
        ReportController.b(null, "dc00898", "", "", "0X800AD47", "0X800AD47", QFileBrowserUtils.a(this.jdField_b_of_type_Int), 0, "", "", "", "");
        return;
        if (i != 56) {
          break;
        }
        localObject1 = e();
      } while (!FileUtils.b((String)localObject1));
      QFileUtils.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject1, paramActionSheetItem.argus, null, 2);
      ReportController.b(null, "dc00898", "", "", "0X800AD48", "0X800AD48", QFileBrowserUtils.a(this.jdField_b_of_type_Int), 0, "", "", "", "");
      return;
      if (i == 118)
      {
        FileOperaterUtils.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, (FileManagerEntity)localObject1).onClick(null);
        return;
      }
      if (i == 132)
      {
        QbSdk.clearDefaultBrowser(this.jdField_a_of_type_AndroidAppActivity, d());
        FileManagerUtil.a(this.jdField_a_of_type_AndroidAppActivity, d());
        ReportController.b(null, "dc00898", "", "", "0X800AFCB", "0X800AFCB", 0, 0, "", "", "", "");
        return;
      }
    } while (i != 26);
    ReportController.b(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
    DatalineDeviceChooseModel.a((FileManagerEntity)localObject1).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new DefaultFileModel.6(this, (FileManagerEntity)localObject1));
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString6, short paramShort, String paramString7, TroopFileProtocol.OnGetZipFileList paramOnGetZipFileList)
  {
    String str1;
    String str2;
    if (paramBoolean)
    {
      str1 = "https://";
      str2 = str1 + paramString1 + ":" + paramShort + "/ftn_compress_list/rkey=" + paramString3 + "&filetype=" + paramInt + "&path=" + URLUtil.a(paramString4) + "&";
      if ((!QFileUtils.a()) || (TextUtils.isEmpty(paramString7))) {
        break label359;
      }
    }
    label359:
    for (paramString7 = str1 + paramString7 + "/ftn_compress_list/rkey=" + paramString3 + "&filetype=" + paramInt + "&path=" + URLUtil.a(paramString4) + "&";; paramString7 = str2)
    {
      if (paramFileManagerEntity.getCloudType() == 2) {}
      for (boolean bool = true;; bool = false)
      {
        paramString1 = new HttpWebCgiAsyncTask2(paramString7, "GET", new DefaultFileModel.2(this, new ArrayList(), paramString4, paramFileManagerEntity, bool, paramString5, paramBoolean, paramString6, paramString1, paramShort, paramString3, paramInt, paramString2, paramOnGetZipFileList), 1000, null);
        paramString2 = new Bundle();
        paramString2.putString("version", DeviceInfoUtil.c());
        paramString2.putString("Cookie", "FTN5K=" + paramString5);
        if (paramBoolean) {
          paramString2.putString("Referer", "https://" + paramString6);
        }
        paramString3 = new HashMap();
        paramString3.put("BUNDLE", paramString2);
        paramString3.put("CONTEXT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
        paramString1.a(paramString3);
        return;
        str1 = "http://";
        break;
      }
    }
  }
  
  protected void a(List<IFileViewerAdapter> paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter = a();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().bCannotPlay = true;
    }
  }
  
  public void a(boolean paramBoolean, FileModel paramFileModel, long paramLong, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    paramFileModel.a(paramBoolean, this.jdField_a_of_type_AndroidAppActivity, paramFMDialogInterface);
  }
  
  protected boolean a(String paramString)
  {
    return QbSdk.isInDefaultBrowser(this.jdField_a_of_type_AndroidAppActivity, paramString);
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    Object localObject2 = d();
    boolean bool = FileUtil.b((String)localObject2);
    if ((localObject1 == null) && (TextUtils.isEmpty((CharSequence)localObject2))) {}
    while ((b() == 16) || ((!bool) && (localObject1 != null) && (((FileManagerEntity)localObject1).isZipInnerFile))) {
      return null;
    }
    if ((localObject1 == null) && (bool)) {}
    for (;;)
    {
      try
      {
        localObject2 = FileManagerUtil.a(new FileInfo((String)localObject2));
        localObject1 = localObject2;
        if (localObject1 == null) {
          break;
        }
        localObject2 = a((FileManagerEntity)localObject1);
        localObject1 = b((FileManagerEntity)localObject1);
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty())) {
          localArrayList1.addAll((Collection)localObject2);
        }
        if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty())) {
          localArrayList2.addAll((Collection)localObject1);
        }
        return new ArrayList[] { localArrayList1, localArrayList2 };
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
      }
    }
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.d();
    }
    return -1;
  }
  
  public long b()
  {
    return 0L;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.d();
    }
    return "";
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem> b(FileManagerEntity paramFileManagerEntity)
  {
    String str = d();
    boolean bool = FileUtil.b(str);
    ArrayList localArrayList = new ArrayList();
    b(paramFileManagerEntity, localArrayList);
    if ((FileManagerUtil.a(paramFileManagerEntity.fileName) == 0) && (bool)) {
      localArrayList.add(QFileUtils.a(39, null));
    }
    if (FileManagerUtil.d(paramFileManagerEntity)) {
      localArrayList.add(QFileUtils.a(6, FileOperaterUtils.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, paramFileManagerEntity)));
    }
    a(paramFileManagerEntity, localArrayList);
    c(paramFileManagerEntity, localArrayList);
    if (LinkUtils.a(paramFileManagerEntity, bool))
    {
      localArrayList.add(QFileUtils.a(122, FileOperaterUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramFileManagerEntity, str)));
      localArrayList.add(QFileUtils.a(123, FileOperaterUtils.b(this.jdField_a_of_type_AndroidAppActivity, paramFileManagerEntity, str)));
    }
    if ((OCRManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1)) && (e() == 0) && ((FileUtils.b(paramFileManagerEntity.strLargeThumPath)) || (FileUtils.b(str)))) {
      localArrayList.add(QFileUtils.a(52, null));
    }
    if (e() == 0) {
      a(localArrayList);
    }
    if (bool)
    {
      if (k()) {
        localArrayList.add(QFileUtils.a(121, FileOperaterUtils.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, d())));
      }
      if (a(str))
      {
        localArrayList.add(QFileUtils.a(132, null));
        ReportController.b(null, "dc00898", "", "", "0X800AFCC", "0X800AFCC", 0, 0, "", "", "", "");
      }
    }
    return localArrayList;
  }
  
  public void b(int paramInt) {}
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    }
    return false;
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] b()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    String str = d();
    boolean bool = FileUtil.b(str);
    localArrayList1.add(QFileUtils.a(2, FileOperaterUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, localFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity)));
    localArrayList1.add(QFileUtils.a(26, null));
    if (!bool) {
      localArrayList1.add(QFileUtils.a(27, FileOperaterUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, localFileManagerEntity)));
    }
    for (;;)
    {
      WXShareHelper localWXShareHelper = WXShareHelper.a();
      if ((bool) && (localWXShareHelper.a()) && (localWXShareHelper.d())) {
        localArrayList1.add(QFileUtils.a(9, FileOperaterUtils.b(this.jdField_a_of_type_AndroidAppActivity, str)));
      }
      if (bool) {
        localArrayList1.add(QFileUtils.a(64, new DefaultFileModel.4(this)));
      }
      if (bool) {
        localArrayList2.add(QFileUtils.a(39, null));
      }
      if (FileManagerUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a())) {
        localArrayList2.add(QFileUtils.a(6, FileOperaterUtils.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, localFileManagerEntity)));
      }
      a(localFileManagerEntity, localArrayList2);
      if (LinkUtils.a(localFileManagerEntity, bool))
      {
        localArrayList2.add(QFileUtils.a(122, FileOperaterUtils.a(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str)));
        localArrayList2.add(QFileUtils.a(123, FileOperaterUtils.b(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, str)));
      }
      b(localArrayList2);
      if ((bool) && (a(str)))
      {
        localArrayList2.add(QFileUtils.a(132, null));
        ReportController.b(null, "dc00898", "", "", "0X800AFCC", "0X800AFCC", 0, 0, "", "", "", "");
      }
      return new ArrayList[] { localArrayList1, localArrayList2 };
      localArrayList1.add(QFileUtils.a(27, FileOperaterUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, str)));
    }
  }
  
  public long c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b();
    }
    return 0L;
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    }
    return "";
  }
  
  public void c(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_Int) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      return;
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter = a();
      localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    } while ((localFileManagerEntity == null) || (!localFileManagerEntity.isZipInnerFile) || (!FileUtil.b(localFileManagerEntity.getFilePath())));
    localFileManagerEntity.status = 1;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter == null;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c();
    }
    return -1;
  }
  
  public long d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    }
    return 0L;
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.g();
    }
    return "";
  }
  
  protected void d()
  {
    Object localObject2 = null;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof FileBrowserActivity)) {}
    for (IFileBrowser localIFileBrowser = (IFileBrowser)this.jdField_a_of_type_AndroidAppActivity;; localIFileBrowser = null)
    {
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
      if (localFileManagerEntity == null) {
        return;
      }
      Object localObject1 = localObject2;
      switch (localFileManagerEntity.nOpType)
      {
      default: 
        localObject1 = localObject2;
      }
      while (localObject1 != null)
      {
        FileManagerReporter.a((String)localObject1);
        return;
        if ((localIFileBrowser != null) && (localIFileBrowser.c()))
        {
          localObject1 = "0X8004BB7";
        }
        else
        {
          localObject1 = "0X8004BCD";
          continue;
          if ((localIFileBrowser != null) && (localIFileBrowser.c()))
          {
            localObject1 = "0X8004BB8";
          }
          else
          {
            localObject1 = "0X8004BCE";
            continue;
            if ((localIFileBrowser != null) && (localIFileBrowser.c())) {
              localObject1 = "0X8004BB9";
            } else {
              localObject1 = "0X8004BCF";
            }
          }
        }
      }
    }
  }
  
  public void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.c())) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = TeamWorkUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a(), bool);
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_d_of_type_Int = paramInt;
      return;
    }
  }
  
  public boolean d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a() != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().isFromProcessingForward2c2cOrDiscItem();
    }
    return false;
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    }
    return -1;
  }
  
  public String e()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (localFileManagerEntity == null) {
      return "";
    }
    int i = FileManagerUtil.a(localFileManagerEntity.fileName);
    if (i == 0)
    {
      if (FileUtils.b(d())) {
        return d();
      }
    }
    else if ((i == 2) && (FileUtils.b(this.f))) {
      return this.f;
    }
    return super.e();
  }
  
  public void e()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (localFileManagerEntity != null)
    {
      FileViewerFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, null);
      return;
    }
    try
    {
      localFileManagerEntity = FileManagerUtil.a(new FileInfo(d()));
      FileViewerFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity, null);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
  }
  
  public boolean e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a() != null)) {
      return FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
    }
    return false;
  }
  
  public int f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b();
    }
    return -1;
  }
  
  public String f()
  {
    return FileUtil.a(c());
  }
  
  public void f()
  {
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().bSend) {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    }
    for (;;)
    {
      Object localObject = new SimpleDateFormat("yyyy.MM.dd");
      localObject = " 于" + ((SimpleDateFormat)localObject).format(new Date(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().srvTime)) + "上传";
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener.b(str, (String)localObject);
      }
      if (NetworkUtil.g(this.jdField_a_of_type_AndroidAppActivity)) {
        break;
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, this.jdField_a_of_type_AndroidAppActivity.getString(2131692257), 1).b(m());
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().peerType == 3000) {
        str = ContactUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().selfUin);
      } else {
        str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().peerNick;
      }
    }
    o();
  }
  
  public boolean f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a() != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().isZipInnerFile;
    }
    return false;
  }
  
  public int g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.e();
    }
    return -1;
  }
  
  public String g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b();
    }
    return "";
  }
  
  public void g()
  {
    if (!NetworkUtil.d(BaseApplicationImpl.getContext()))
    {
      FMToastUtil.a(BaseApplicationImpl.getContext().getString(2131692602));
      return;
    }
    k();
    h();
    if (TeamWorkUtils.c(d(), c(), c()))
    {
      TeamWorkUtils.a(a(), this.jdField_a_of_type_AndroidAppActivity, "FileBrowserModelBase", a());
      TeamWorkUtils.a(a(), null, "0X8009ECE");
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, FilePreviewActivity.class);
    localIntent.putExtra("offline_file_type", 0);
    localIntent.putExtra("offline_file_name", c());
    localIntent.putExtra("offline_file_size", c());
    if (j())
    {
      localIntent.putExtra("offline_file_show_team_work_menu", true);
      localIntent.putExtra("key_team_work_file_import_info", this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo);
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130772237, 2130772238);
  }
  
  public boolean g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a() != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().isSend();
    }
    return false;
  }
  
  public int h()
  {
    int j = 2;
    int k = 1;
    int m = g();
    int i;
    if ((d() == 0) && (m != 10)) {
      i = 4;
    }
    do
    {
      return i;
      i = k;
      switch (m)
      {
      default: 
        if (QLog.isColorLevel()) {
          QLog.w("FileBrowserModelBase<FileAssistant>", 2, "error. a unknow transfer type:" + m);
        }
        i = 2;
      }
      do
      {
        return i;
        i = k;
      } while (FileUtil.b(d()));
      i = j;
    } while (!QLog.isColorLevel());
    QLog.i("FileBrowserModelBase<FileAssistant>", 1, "file is send,but not has localfile,return download status!");
    return 2;
  }
  
  public String h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.i();
    }
    return "";
  }
  
  public void h()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    String str;
    if (d() == 2)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a() != null) {
        break label88;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a() != null) {
        break label72;
      }
      str = "";
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(new WeiYunPreviewController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.WeiYunFileId, str));
      return;
      label72:
      str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().jdField_b_of_type_JavaLangString;
      continue;
      label88:
      str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().WeiYunDirKey;
    }
  }
  
  public boolean h()
  {
    boolean bool = true;
    if ((i() != 2) && (h() == 1)) {
      return false;
    }
    if ((FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter, true)) && (FileManagerUtil.a(this.jdField_a_of_type_AndroidAppActivity, c(), c()))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public int i()
  {
    int i = 2;
    int j = b();
    String str = d();
    if ((j == 2) || (j == 14)) {
      i = 4;
    }
    do
    {
      return i;
      if (j == 16) {
        return 5;
      }
      if ((j == 0) || (j == 3)) {
        return 6;
      }
    } while (FileUtil.b(str));
    return 0;
  }
  
  public void i()
  {
    super.i();
    a();
  }
  
  public boolean i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      int i;
      do
      {
        return false;
        i = i();
        if ((i != 5) && (i != 2)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("FileBrowserModelBase", 2, "can not auto download file : [fileStatus] = " + i);
      return false;
    } while (!NetworkUtil.e(BaseApplicationImpl.getContext()));
    DownloadFileConfig localDownloadFileConfig = ((IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).getFileAutoDownloadConfig(HWTroopUtils.a(c()));
    long l = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b();
    if (((NetworkUtil.h(BaseApplicationImpl.getContext())) && (l <= localDownloadFileConfig.jdField_a_of_type_Int)) || (l <= localDownloadFileConfig.c)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase = null;
    }
  }
  
  public boolean j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter == null) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      return false;
      localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_e_of_type_Boolean = false;
    } while ((a() == null) || (localFileManagerEntity == null) || (!TeamWorkUtils.d(d(), c(), c())) || (!NetworkUtil.d(BaseApplicationImpl.getContext())) || ((TextUtils.isEmpty(localFileManagerEntity.Uuid)) && (TextUtils.isEmpty(localFileManagerEntity.strTroopFilePath)) && (TextUtils.isEmpty(localFileManagerEntity.getFilePath()))));
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = localFileManagerEntity.fileName;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_d_of_type_Long = localFileManagerEntity.fileSize;
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.c = localFileManagerEntity.getFilePath();
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_e_of_type_Int = localFileManagerEntity.nFileType;
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserModelBase", 2, "file size:" + localFileManagerEntity.fileSize + " isTroopFile:" + TextUtils.isEmpty(localFileManagerEntity.strTroopFilePath) + " isOfflineFile:" + TextUtils.isEmpty(localFileManagerEntity.Uuid) + "isLocalFile: " + TextUtils.isEmpty(localFileManagerEntity.getFilePath()));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.c();
    }
    if (!TextUtils.isEmpty(localFileManagerEntity.peerUin))
    {
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Int = localFileManagerEntity.peerType;
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString = localFileManagerEntity.peerUin;
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_e_of_type_JavaLangString = String.valueOf(localFileManagerEntity.TroopUin);
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_b_of_type_Int = localFileManagerEntity.busId;
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString = localFileManagerEntity.strTroopFilePath;
      this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Long = localFileManagerEntity.uniseq;
      if (localFileManagerEntity.status != 16) {
        this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportInfo.jdField_a_of_type_Boolean = true;
      }
    }
    return true;
  }
  
  public int k()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.apkSafeLevel;
    }
    return 0;
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a(true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b(false);
    }
  }
  
  protected boolean k()
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    String str = c();
    return localDataLineHandler.a.a(str);
  }
  
  public void k_()
  {
    super.k_();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase = null;
    }
  }
  
  public String m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    }
    return super.m();
  }
  
  public String n()
  {
    if (a() == 2)
    {
      if ((TextUtils.isEmpty(this.g)) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null))
      {
        this.g = (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a() + "_" + System.currentTimeMillis());
        QLog.i("FileBrowserModelBase", 1, "getContextId: default video file random contextId: " + this.g);
      }
      if (!TextUtils.isEmpty(this.g)) {
        return this.g;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a() + "";
    }
    return super.n();
  }
  
  public String o()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.apkSafeMsg;
    }
    return "";
  }
  
  public String p()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.apkSafeDetailUrl;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.DefaultFileModel
 * JD-Core Version:    0.7.0.1
 */