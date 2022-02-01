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
import com.tencent.mobileqq.filemanager.recreate.IFModel;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanageraux.core.DiscOfflinePreviewController;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanageraux.link.LinkUtils;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.startup.step.CheckPermission;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.tencentdocreport.TenDocLogReportHelper;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.weiyun.api.IWeiyunApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.util.URLUtil;
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
  protected QQAppInterface a;
  protected IFileViewerAdapter a;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("index error, index[");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("], size[");
      localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.size());
      localStringBuilder.append("]");
      QLog.e("FileBrowserModelBase", 1, localStringBuilder.toString());
      return (IFileViewerAdapter)this.jdField_a_of_type_JavaUtilList.get(0);
    }
    return (IFileViewerAdapter)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int);
  }
  
  private void b(FileManagerEntity paramFileManagerEntity, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    int j = j();
    if ((j != 0) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.f()))
    {
      int i = 70;
      if ((j != 1) && (j == 2)) {
        i = 82;
      }
      paramArrayList.add(QFileUtils.a(i, new DefaultFileModel.8(this, j)));
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
        localObject1 = ".doc|.docx|.xls|.xlsx|";
      }
      long l = FileManagerUtil.b(paramFileManagerEntity.fileName);
      if ((bool) && (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsSupport(paramFileManagerEntity.getFilePath(), paramFileManagerEntity.fileName, (String)localObject1)) && (paramFileManagerEntity.fileSize <= l))
      {
        paramFileManagerEntity = QFileUtils.a(119, FileOperaterUtils.a(paramFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity));
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
        paramArrayList.add(paramFileManagerEntity);
      }
    }
  }
  
  private void d()
  {
    int i = d();
    int j = f();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if ((localObject != null) && (!TextUtils.isEmpty(((FileManagerEntity)localObject).WeiYunFileId)))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(((IWeiyunApi)QRoute.api(IWeiyunApi.class)).getWeiYunFilePreviewController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.e(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().WeiYunDirKey));
    }
    else if (i == 2)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a() == null) {
        localObject = "";
      } else {
        localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().jdField_b_of_type_JavaLangString;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(((IWeiyunApi)QRoute.api(IWeiyunApi.class)).getWeiYunFilePreviewController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.e(), (String)localObject));
    }
    else if ((i != 1) && (i != 3))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserModelBase", 2, "loadZipFilesForOthers error. can not handle zip file");
      }
    }
    else if (j == 3000)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(new DiscOfflinePreviewController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.d()));
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(new OfflinePreviewController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.c(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.e()));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreControlerCallback == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreControlerCallback = new DefaultFileModel.1(this, j);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreControlerCallback);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase.a();
    }
  }
  
  public float a()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
    if ((localIFileViewerAdapter != null) && (localIFileViewerAdapter.a() != null)) {
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
    return this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo;
  }
  
  public String a()
  {
    return "biz_src_jc_file";
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem> a(FileManagerEntity paramFileManagerEntity)
  {
    String str = d();
    boolean bool = FileUtil.a(str);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QFileUtils.a(2, FileOperaterUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, paramFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity)));
    localArrayList.add(QFileUtils.a(26, null));
    TenDocDirectShareConfigBean localTenDocDirectShareConfigBean = TenDocDirectShareConfigProcessor.a();
    int j = 0;
    if ((localTenDocDirectShareConfigBean != null) && (paramFileManagerEntity != null) && (localTenDocDirectShareConfigBean.a().contains(FileUtil.a(paramFileManagerEntity.fileName).replace(".", "").toLowerCase()))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localArrayList.add(QFileUtils.a(120, FileOperaterUtils.a(paramFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity, true, new DefaultFileModel.4(this))));
      TenDocLogReportHelper.a(a(), "0X800A21C");
    }
    int i = j;
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
    if (i == 0) {
      if (bool) {
        localArrayList.add(QFileUtils.a(27, FileOperaterUtils.a(paramFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, str)));
      } else if (d() == 1) {
        localArrayList.add(QFileUtils.a(27, FileOperaterUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, paramFileManagerEntity)));
      }
    }
    paramFileManagerEntity = WXShareHelper.a();
    if ((bool) && (paramFileManagerEntity.a()) && (paramFileManagerEntity.d())) {
      localArrayList.add(QFileUtils.a(9, FileOperaterUtils.b(this.jdField_a_of_type_AndroidAppActivity, str)));
    }
    if (bool) {
      localArrayList.add(QFileUtils.a(64, FileOperaterUtils.a(this.jdField_a_of_type_AndroidAppActivity, str)));
    }
    return localArrayList;
  }
  
  public List<FileBrowserModelBase.ImageFileInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(new DefaultImageInfo((IFileViewerAdapter)((Iterator)localObject).next()));
      }
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    IFileViewerAdapter localIFileViewerAdapter = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
    if (localIFileViewerAdapter != null) {
      localIFileViewerAdapter.a().status = paramInt;
    }
  }
  
  public void a(int paramInt, FileBrowserModelBase.ImageFileInfo paramImageFileInfo)
  {
    IFileViewerAdapter localIFileViewerAdapter = ((DefaultImageInfo)paramImageFileInfo).a();
    if (localIFileViewerAdapter == null)
    {
      FMToastUtil.b(BaseApplicationImpl.getContext().getString(2131692353));
      return;
    }
    if ((FileManagerUtil.b(localIFileViewerAdapter.a())) && (1 == localIFileViewerAdapter.c())) {
      FMToastUtil.b(BaseApplicationImpl.getContext().getString(2131692353));
    }
    if (localIFileViewerAdapter.f() == null)
    {
      localIFileViewerAdapter.a(1);
      paramImageFileInfo.a(1);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
    if ((paramString != null) && (paramString.a() != null))
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
      paramString.status = 16;
      paramString.mContext = "showed";
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(paramString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserModelBase", 2, "onVideoPlayerError : file entity is null");
    }
  }
  
  protected void a(FileManagerEntity paramFileManagerEntity, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList) {}
  
  public void a(FileBrowserModelBase.OnPreviewVideoOnlineListener paramOnPreviewVideoOnlineListener) {}
  
  public void a(FileBrowserModelBase.OnTransEventListener paramOnTransEventListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener = paramOnTransEventListener;
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    Object localObject2 = d();
    if ((localObject1 == null) && (TextUtils.isEmpty((CharSequence)localObject2))) {
      return;
    }
    int i = paramActionSheetItem.action;
    f(i);
    if (i == 73)
    {
      FileOperaterUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, (FileManagerEntity)localObject1, this.jdField_a_of_type_AndroidAppActivity).onClick(null);
      return;
    }
    if (i == 72)
    {
      i = paramActionSheetItem.uinType;
      paramActionSheetItem = paramActionSheetItem.uin;
      if (!TextUtils.isEmpty(paramActionSheetItem)) {
        QFileUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject1, true, paramActionSheetItem, i);
      }
    }
    else
    {
      if (i == 39)
      {
        if (!CheckPermission.isHasStoragePermission(this.jdField_a_of_type_AndroidAppActivity))
        {
          CheckPermission.requestSDCardPermission((AppActivity)this.jdField_a_of_type_AndroidAppActivity, new DefaultFileModel.6(this));
          return;
        }
        FileManagerUtil.a(this.jdField_a_of_type_AndroidAppActivity, d());
        return;
      }
      if (i == 52)
      {
        localObject1 = d();
        paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
        if (!FileUtils.fileExistsAndNotEmpty((String)localObject1))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
          paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
          if (localObject2 != null) {
            paramActionSheetItem = ((FileManagerEntity)localObject2).strLargeThumPath;
          }
        }
        if (FileUtils.fileExistsAndNotEmpty(paramActionSheetItem)) {
          ((IOCR)QRoute.api(IOCR.class)).startOcrPerformFragment(this.jdField_a_of_type_AndroidAppActivity, paramActionSheetItem, 1, -1004, null);
        }
      }
      else if (i == 55)
      {
        localObject1 = e();
        if (FileUtils.fileExistsAndNotEmpty((String)localObject1))
        {
          QFileUtils.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject1, paramActionSheetItem.argus, null, 1);
          ReportController.b(null, "dc00898", "", "", "0X800AD47", "0X800AD47", QFileBrowserUtils.a(this.jdField_b_of_type_Int), 0, "", "", "", "");
        }
      }
      else if (i == 56)
      {
        localObject1 = e();
        if (FileUtils.fileExistsAndNotEmpty((String)localObject1))
        {
          QFileUtils.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject1, paramActionSheetItem.argus, null, 2);
          ReportController.b(null, "dc00898", "", "", "0X800AD48", "0X800AD48", QFileBrowserUtils.a(this.jdField_b_of_type_Int), 0, "", "", "", "");
        }
      }
      else
      {
        if (i == 132)
        {
          QbSdk.clearDefaultBrowser(this.jdField_a_of_type_AndroidAppActivity, d());
          FileManagerUtil.a(this.jdField_a_of_type_AndroidAppActivity, d());
          ReportController.b(null, "dc00898", "", "", "0X800AFCB", "0X800AFCB", 0, 0, "", "", "", "");
          return;
        }
        if (i == 26)
        {
          ReportController.b(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
          DatalineDeviceChooseModel.a((FileManagerEntity)localObject1).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new DefaultFileModel.7(this, (FileManagerEntity)localObject1));
        }
      }
    }
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5, FileManagerEntity paramFileManagerEntity, boolean paramBoolean, String paramString6, short paramShort, String paramString7, TroopFileProtocol.OnGetZipFileList paramOnGetZipFileList)
  {
    String str1;
    if (paramBoolean) {
      str1 = "https://";
    } else {
      str1 = "http://";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(paramShort);
    ((StringBuilder)localObject).append("/ftn_compress_list/rkey=");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append("&filetype=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("&path=");
    ((StringBuilder)localObject).append(URLUtil.a(paramString4));
    ((StringBuilder)localObject).append("&");
    String str2 = ((StringBuilder)localObject).toString();
    localObject = str2;
    if (QFileUtils.a())
    {
      localObject = str2;
      if (!TextUtils.isEmpty(paramString7))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str1);
        ((StringBuilder)localObject).append(paramString7);
        ((StringBuilder)localObject).append("/ftn_compress_list/rkey=");
        ((StringBuilder)localObject).append(paramString3);
        ((StringBuilder)localObject).append("&filetype=");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("&path=");
        ((StringBuilder)localObject).append(URLUtil.a(paramString4));
        ((StringBuilder)localObject).append("&");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    boolean bool;
    if (paramFileManagerEntity.getCloudType() == 2) {
      bool = true;
    } else {
      bool = false;
    }
    paramString1 = new HttpWebCgiAsyncTask2((String)localObject, "GET", new DefaultFileModel.2(this, new ArrayList(), paramString4, paramFileManagerEntity, bool, paramString5, paramBoolean, paramString6, paramString1, paramShort, paramString3, paramInt, paramString2, paramOnGetZipFileList), 1000, null);
    paramString2 = new Bundle();
    paramString2.putString("version", DeviceInfoUtil.c());
    paramString3 = new StringBuilder();
    paramString3.append("FTN5K=");
    paramString3.append(paramString5);
    paramString2.putString("Cookie", paramString3.toString());
    if (paramBoolean)
    {
      paramString3 = new StringBuilder();
      paramString3.append("https://");
      paramString3.append(paramString6);
      paramString2.putString("Referer", paramString3.toString());
    }
    paramString3 = new HashMap();
    paramString3.put("BUNDLE", paramString2);
    paramString3.put("CONTEXT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
    paramString1.a(paramString3);
  }
  
  protected void a(List<IFileViewerAdapter> paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter = a();
  }
  
  public void a(boolean paramBoolean)
  {
    IFileViewerAdapter localIFileViewerAdapter = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
    if ((localIFileViewerAdapter != null) && (localIFileViewerAdapter.a() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().bCannotPlay = true;
    }
  }
  
  protected void a(boolean paramBoolean, IFModel paramIFModel, long paramLong, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    paramIFModel.a(paramBoolean, this.jdField_a_of_type_AndroidAppActivity, paramFMDialogInterface);
  }
  
  protected boolean a(String paramString)
  {
    return QbSdk.isInDefaultBrowser(this.jdField_a_of_type_AndroidAppActivity, paramString);
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    Object localObject4 = d();
    boolean bool = FileUtil.a((String)localObject4);
    if ((localObject3 == null) && (TextUtils.isEmpty((CharSequence)localObject4))) {
      return null;
    }
    if (b() == 16) {
      return null;
    }
    if ((!bool) && (localObject3 != null) && (((FileManagerEntity)localObject3).isZipInnerFile)) {
      return null;
    }
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      localObject1 = localObject3;
      if (bool) {
        try
        {
          localObject1 = FileManagerUtil.a(new FileInfo((String)localObject4));
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          localFileNotFoundException.printStackTrace();
          localObject2 = localObject3;
        }
      }
    }
    if (localObject2 == null) {
      return null;
    }
    localObject3 = a((FileManagerEntity)localObject2);
    Object localObject2 = b((FileManagerEntity)localObject2);
    localObject4 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    if ((localObject3 != null) && (!((ArrayList)localObject3).isEmpty())) {
      ((ArrayList)localObject4).addAll((Collection)localObject3);
    }
    if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty())) {
      localArrayList.addAll((Collection)localObject2);
    }
    return new ArrayList[] { localObject4, localArrayList };
  }
  
  public int b()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
    if (localIFileViewerAdapter != null) {
      return localIFileViewerAdapter.d();
    }
    return -1;
  }
  
  public long b()
  {
    return 0L;
  }
  
  public String b()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
    if (localIFileViewerAdapter != null) {
      return localIFileViewerAdapter.d();
    }
    return "";
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem> b(FileManagerEntity paramFileManagerEntity)
  {
    String str = d();
    boolean bool = FileUtil.a(str);
    ArrayList localArrayList = new ArrayList();
    b(paramFileManagerEntity, localArrayList);
    if ((paramFileManagerEntity != null) && (FileManagerUtil.a(paramFileManagerEntity.fileName) == 0) && (bool)) {
      localArrayList.add(QFileUtils.a(39, null));
    }
    if (FileManagerUtil.d(paramFileManagerEntity)) {
      localArrayList.add(QFileUtils.a(6, FileOperaterUtils.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, paramFileManagerEntity)));
    }
    a(paramFileManagerEntity, localArrayList);
    if (paramFileManagerEntity != null) {
      c(paramFileManagerEntity, localArrayList);
    }
    if (LinkUtils.a(paramFileManagerEntity, bool))
    {
      localArrayList.add(QFileUtils.a(122, FileOperaterUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramFileManagerEntity, str)));
      localArrayList.add(QFileUtils.a(123, FileOperaterUtils.b(this.jdField_a_of_type_AndroidAppActivity, paramFileManagerEntity, str)));
    }
    if ((((IOCRService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IOCRService.class, "")).isSupportOcr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1)) && (e() == 0) && (paramFileManagerEntity != null) && ((FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.strLargeThumPath)) || (FileUtils.fileExistsAndNotEmpty(str)))) {
      localArrayList.add(QFileUtils.a(52, null));
    }
    if (e() == 0) {
      a(localArrayList);
    }
    if (bool)
    {
      if (k())
      {
        long l = 0L;
        if (paramFileManagerEntity != null) {
          l = paramFileManagerEntity.nSessionId;
        }
        localArrayList.add(QFileUtils.a(121, FileOperaterUtils.b(l, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, d())));
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
    IFileViewerAdapter localIFileViewerAdapter = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
    if (localIFileViewerAdapter != null) {
      return localIFileViewerAdapter.b();
    }
    return false;
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] b()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    String str = d();
    boolean bool = FileUtil.a(str);
    localArrayList1.add(QFileUtils.a(2, FileOperaterUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, localFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity)));
    localArrayList1.add(QFileUtils.a(26, null));
    if (!bool) {
      localArrayList1.add(QFileUtils.a(27, FileOperaterUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, localFileManagerEntity)));
    } else {
      localArrayList1.add(QFileUtils.a(27, FileOperaterUtils.a(localFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, str)));
    }
    WXShareHelper localWXShareHelper = WXShareHelper.a();
    if ((bool) && (localWXShareHelper.a()) && (localWXShareHelper.d())) {
      localArrayList1.add(QFileUtils.a(9, FileOperaterUtils.b(this.jdField_a_of_type_AndroidAppActivity, str)));
    }
    if (bool) {
      localArrayList1.add(QFileUtils.a(64, new DefaultFileModel.5(this)));
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
  }
  
  public long c()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
    if (localIFileViewerAdapter != null) {
      return localIFileViewerAdapter.b();
    }
    return 0L;
  }
  
  public String c()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
    if (localIFileViewerAdapter != null) {
      return localIFileViewerAdapter.a();
    }
    return "";
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase = null;
    }
  }
  
  public void c(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_Int) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter = a();
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if ((localFileManagerEntity != null) && (localFileManagerEntity.isZipInnerFile) && (FileUtil.a(localFileManagerEntity.getFilePath()))) {
      localFileManagerEntity.status = 1;
    }
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter == null;
  }
  
  public int d()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
    if (localIFileViewerAdapter != null) {
      return localIFileViewerAdapter.c();
    }
    return -1;
  }
  
  public long d()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
    if (localIFileViewerAdapter != null) {
      return localIFileViewerAdapter.a();
    }
    return 0L;
  }
  
  public String d()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
    if (localIFileViewerAdapter != null) {
      return localIFileViewerAdapter.g();
    }
    return "";
  }
  
  public void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter == null) {
      return;
    }
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.c())) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).generateTencentDocImportInfo(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a(), bool);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_d_of_type_Int = paramInt;
  }
  
  public boolean d()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
    if ((localIFileViewerAdapter != null) && (localIFileViewerAdapter.a() != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().isFromProcessingForward2c2cOrDiscItem();
    }
    return false;
  }
  
  public int e()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
    if (localIFileViewerAdapter != null) {
      return localIFileViewerAdapter.a();
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
      if (FileUtils.fileExistsAndNotEmpty(d())) {
        return d();
      }
    }
    else if ((i == 2) && (FileUtils.fileExistsAndNotEmpty(this.f))) {
      return this.f;
    }
    return super.e();
  }
  
  protected void e()
  {
    boolean bool = this.jdField_a_of_type_AndroidAppActivity instanceof FileBrowserActivity;
    Object localObject2 = null;
    Object localObject1;
    if (bool) {
      localObject1 = (IFileBrowser)this.jdField_a_of_type_AndroidAppActivity;
    } else {
      localObject1 = null;
    }
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (localFileManagerEntity == null) {
      return;
    }
    int i = localFileManagerEntity.nOpType;
    if (i != 0)
    {
      if ((i != 1) && (i != 5))
      {
        if (i == 6) {
          break label149;
        }
        if (i != 8)
        {
          if ((i != 9) && (i != 12))
          {
            localObject1 = localObject2;
            break label173;
          }
          if ((localObject1 != null) && (((IFileBrowser)localObject1).c()))
          {
            localObject1 = "0X8004BB9";
            break label173;
          }
          localObject1 = "0X8004BCF";
          break label173;
        }
      }
      if ((localObject1 != null) && (((IFileBrowser)localObject1).c()))
      {
        localObject1 = "0X8004BB7";
        break label173;
      }
      localObject1 = "0X8004BCD";
      break label173;
    }
    label149:
    if ((localObject1 != null) && (((IFileBrowser)localObject1).c())) {
      localObject1 = "0X8004BB8";
    } else {
      localObject1 = "0X8004BCE";
    }
    label173:
    if (localObject1 != null) {
      FileManagerReporter.a((String)localObject1);
    }
  }
  
  public boolean e()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
    if ((localIFileViewerAdapter != null) && (localIFileViewerAdapter.a() != null)) {
      return FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
    }
    return false;
  }
  
  public int f()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
    if (localIFileViewerAdapter != null) {
      return localIFileViewerAdapter.b();
    }
    return -1;
  }
  
  public String f()
  {
    return FileUtil.a(c());
  }
  
  public void f()
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
  
  public boolean f()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
    if ((localIFileViewerAdapter != null) && (localIFileViewerAdapter.a() != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().isZipInnerFile;
    }
    return false;
  }
  
  public int g()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
    if (localIFileViewerAdapter != null) {
      return localIFileViewerAdapter.e();
    }
    return -1;
  }
  
  public String g()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
    if (localIFileViewerAdapter != null) {
      return localIFileViewerAdapter.b();
    }
    return "";
  }
  
  public void g()
  {
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().bSend) {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    } else if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().peerType == 3000) {
      str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().selfUin);
    } else {
      str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().peerNick;
    }
    Object localObject = new SimpleDateFormat("yyyy.MM.dd");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" 于");
    localStringBuilder.append(((SimpleDateFormat)localObject).format(new Date(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().srvTime)));
    localStringBuilder.append("上传");
    localObject = localStringBuilder.toString();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnZipEventListener.b(str, (String)localObject);
    }
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity))
    {
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, this.jdField_a_of_type_AndroidAppActivity.getString(2131692183), 1).b(m());
      return;
    }
    d();
  }
  
  public boolean g()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
    if ((localIFileViewerAdapter != null) && (localIFileViewerAdapter.a() != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().isSend();
    }
    return false;
  }
  
  public int h()
  {
    int i = g();
    if ((d() == 0) && (i != 10)) {
      return 4;
    }
    if (i != 0)
    {
      if ((i == 35) || (i == 3)) {
        break label161;
      }
      if (i != 4)
      {
        if (i == 6) {
          break label161;
        }
        if ((i != 7) && (i != 28))
        {
          if (i == 29) {
            break label161;
          }
          switch (i)
          {
          default: 
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("error. a unknow transfer type:");
              localStringBuilder.append(i);
              QLog.w("FileBrowserModelBase<FileAssistant>", 2, localStringBuilder.toString());
            }
            return 2;
          }
        }
      }
    }
    if (!FileUtil.a(d()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserModelBase<FileAssistant>", 1, "file is send,but not has localfile,return download status!");
      }
      return 2;
    }
    label161:
    return 1;
  }
  
  public String h()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
    if (localIFileViewerAdapter != null) {
      return localIFileViewerAdapter.i();
    }
    return "";
  }
  
  public void h()
  {
    if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
    {
      FMToastUtil.a(BaseApplicationImpl.getContext().getString(2131692554));
      return;
    }
    l();
    i();
    if (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).supportTencentDocForPreview(d(), c(), c()))
    {
      if (a() == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileBrowserModelBase", 2, "previewBigFile getTeamWorkFileImportInfo() == null");
        }
        d(7);
      }
      ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).tryOpenWithTencentDoc(a(), this.jdField_a_of_type_AndroidAppActivity, "FileBrowserModelBase", a());
      ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(a(), null, "0X8009ECE");
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, FilePreviewActivity.class);
    localIntent.putExtra("offline_file_type", 0);
    localIntent.putExtra("offline_file_name", c());
    localIntent.putExtra("offline_file_size", c());
    if (j())
    {
      localIntent.putExtra("offline_file_show_team_work_menu", true);
      localIntent.putExtra("key_team_work_file_import_info", this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo);
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    this.jdField_a_of_type_AndroidAppActivity.overridePendingTransition(2130772266, 2130772267);
  }
  
  public boolean h()
  {
    int i = i();
    boolean bool2 = false;
    if ((i != 2) && (h() == 1)) {
      return false;
    }
    boolean bool1 = bool2;
    if (FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter, true))
    {
      bool1 = bool2;
      if (FileManagerUtil.a(this.jdField_a_of_type_AndroidAppActivity, c(), c())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int i()
  {
    int i = b();
    String str = d();
    if ((i != 2) && (i != 14))
    {
      if (i == 16) {
        return 5;
      }
      if ((i != 0) && (i != 3))
      {
        if (FileUtil.a(str)) {
          return 2;
        }
        return 0;
      }
      return 6;
    }
    return 4;
  }
  
  public void i()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (d() == 2)
    {
      String str;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a() == null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a() == null) {
          str = "";
        } else {
          str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().jdField_b_of_type_JavaLangString;
        }
      }
      else {
        str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().WeiYunDirKey;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(((IWeiyunApi)QRoute.api(IWeiyunApi.class)).getWeiYunFilePreviewController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.WeiYunFileId, str));
    }
  }
  
  public boolean i()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    int i = i();
    if ((i != 5) && (i != 2))
    {
      boolean bool1 = bool2;
      if (NetworkUtil.isNetSupportHw(BaseApplicationImpl.getContext()))
      {
        localObject = ((IQFileConfigManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQFileConfigManager.class, "")).getFileAutoDownloadConfig(HWTroopUtils.a(c()));
        long l = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b();
        if ((!NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext())) || (l > ((DownloadFileConfig)localObject).jdField_a_of_type_Int))
        {
          bool1 = bool2;
          if (l > ((DownloadFileConfig)localObject).c) {}
        }
        else
        {
          bool1 = true;
        }
      }
      return bool1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("can not auto download file : [fileStatus] = ");
      ((StringBuilder)localObject).append(i);
      QLog.i("FileBrowserModelBase", 2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public void j()
  {
    super.j();
    a();
  }
  
  public boolean j()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
    if (localObject == null) {
      return false;
    }
    localObject = ((IFileViewerAdapter)localObject).a();
    this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_e_of_type_Boolean = false;
    if (a() == null) {
      return false;
    }
    if ((localObject != null) && (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).supportTencentDocForEdit(d(), c(), c())))
    {
      if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext())) {
        return false;
      }
      if ((TextUtils.isEmpty(((FileManagerEntity)localObject).Uuid)) && (TextUtils.isEmpty(((FileManagerEntity)localObject).strTroopFilePath)) && (TextUtils.isEmpty(((FileManagerEntity)localObject).getFilePath()))) {
        return false;
      }
      this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = ((FileManagerEntity)localObject).fileName;
      this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_d_of_type_Long = ((FileManagerEntity)localObject).fileSize;
      this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.c = ((FileManagerEntity)localObject).getFilePath();
      this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_e_of_type_Int = ((FileManagerEntity)localObject).nFileType;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("file size:");
        localStringBuilder.append(((FileManagerEntity)localObject).fileSize);
        localStringBuilder.append(" isTroopFile:");
        localStringBuilder.append(TextUtils.isEmpty(((FileManagerEntity)localObject).strTroopFilePath));
        localStringBuilder.append(" isOfflineFile:");
        localStringBuilder.append(TextUtils.isEmpty(((FileManagerEntity)localObject).Uuid));
        localStringBuilder.append("isLocalFile: ");
        localStringBuilder.append(TextUtils.isEmpty(((FileManagerEntity)localObject).getFilePath()));
        QLog.i("FileBrowserModelBase", 2, localStringBuilder.toString());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) {
        this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.c();
      }
      if (!TextUtils.isEmpty(((FileManagerEntity)localObject).peerUin))
      {
        this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_Int = ((FileManagerEntity)localObject).peerType;
        this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString = ((FileManagerEntity)localObject).peerUin;
        this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_e_of_type_JavaLangString = String.valueOf(((FileManagerEntity)localObject).TroopUin);
        this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_b_of_type_Int = ((FileManagerEntity)localObject).busId;
        this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString = ((FileManagerEntity)localObject).strTroopFilePath;
        this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_Long = ((FileManagerEntity)localObject).uniseq;
        if (((FileManagerEntity)localObject).status != 16) {
          this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.jdField_a_of_type_Boolean = true;
        }
      }
      return true;
    }
    return false;
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
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreFilePreViewControllerBase = null;
    }
  }
  
  protected boolean k()
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    String str = c();
    return localDataLineHandler.a.a(str);
  }
  
  public void l()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter;
    if (localIFileViewerAdapter != null)
    {
      localIFileViewerAdapter.a(true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.b(false);
    }
  }
  
  public String m()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null) {
      return localQQAppInterface.getCurrentAccountUin();
    }
    return super.m();
  }
  
  public String n()
  {
    StringBuilder localStringBuilder;
    if (a() == 2)
    {
      if ((TextUtils.isEmpty(this.g)) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
        localStringBuilder.append("_");
        localStringBuilder.append(System.currentTimeMillis());
        this.g = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getContextId: default video file random contextId: ");
        localStringBuilder.append(this.g);
        QLog.i("FileBrowserModelBase", 1, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty(this.g)) {
        return this.g;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
      localStringBuilder.append("");
      return localStringBuilder.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.DefaultFileModel
 * JD-Core Version:    0.7.0.1
 */