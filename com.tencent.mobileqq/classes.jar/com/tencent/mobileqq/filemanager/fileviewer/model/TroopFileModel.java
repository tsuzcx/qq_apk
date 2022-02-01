package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.protocol.TroopFileGetFilePreviewObserver;
import com.tencent.biz.troop.file.protocol.TroopFileReqDownloadFileObserver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.util.DatalineDeviceChooseModel;
import com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TroopFileVideoOnlinePlayManager;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.fileviewer.colornote.DefaultFileColorNoteServiceInfo;
import com.tencent.mobileqq.filemanager.fileviewer.colornote.LocalFileColorNoteServiceInfo;
import com.tencent.mobileqq.filemanager.fileviewer.colornote.TroopFileColorNoteServiceInfo;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IDownloadController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IThumbController;
import com.tencent.mobileqq.filemanager.fileviewer.controller.IUploadController;
import com.tencent.mobileqq.filemanager.fileviewer.data.TroopImageInfo;
import com.tencent.mobileqq.filemanager.fileviewer.data.VideoForTroop;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanageraux.link.LinkUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.data.TroopFilePreviewController;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileError.TroopFileErrorObserver;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsVideo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class TroopFileModel
  extends DefaultFileModel
{
  private TroopFileGetFilePreviewObserver jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileGetFilePreviewObserver;
  private TroopFileReqDownloadFileObserver jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqDownloadFileObserver;
  private BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver;
  private FileBrowserModelBase.OnPreviewVideoOnlineListener jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnPreviewVideoOnlineListener;
  private TroopFileError.TroopFileErrorObserver jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver;
  private int c;
  private String g;
  private String h = "";
  
  public TroopFileModel(QQAppInterface paramQQAppInterface, Activity paramActivity, List<IFileViewerAdapter> paramList, int paramInt)
  {
    super(paramQQAppInterface, paramActivity);
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileModel<FileAssistant>", 1, "FileBrowserModel init: type = troop");
    }
    a(paramList, paramInt);
  }
  
  private void a(FileManagerEntity paramFileManagerEntity, TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    long l = paramFileManagerEntity.lastTime;
    Object localObject = paramFileManagerEntity.selfUin;
    boolean bool1 = paramFileManagerEntity.bSend;
    boolean bool2 = paramFileManagerEntity.isZipInnerFile;
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(paramTroopFileStatusInfo);
    paramFileManagerEntity.copyFrom(localFileManagerEntity);
    paramFileManagerEntity.lastTime = l;
    paramFileManagerEntity.selfUin = ((String)localObject);
    paramFileManagerEntity.bSend = bool1;
    paramFileManagerEntity.isZipInnerFile = bool2;
    if ((this.b == 3) && (e() == 2))
    {
      localObject = new SessionInfo();
      ((SessionInfo)localObject).a = 1;
      l = this.jdField_a_of_type_AndroidOsBundle.getLong("troopfile_shmsgseq");
      bool1 = this.jdField_a_of_type_AndroidOsBundle.getBoolean("is_multi_aio_msg", false);
      MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(String.valueOf(paramFileManagerEntity.TroopUin), 1, l, -2017);
      Rect localRect = (Rect)this.jdField_a_of_type_AndroidOsBundle.getParcelable("file_browser_params_thumb_bound");
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) && (localMessageRecord != null) && (!bool1))
      {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new TroopFileModel.8(this, localMessageRecord, (SessionInfo)localObject, paramFileManagerEntity, paramTroopFileStatusInfo, localFileManagerEntity, localRect), 100L);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new TroopFileModel.9(this, localMessageRecord), 300L);
      }
    }
    if (d() == 3)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.f();
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.w("TroopFileModel<FileAssistant>", 2, "file download finished, but file not exist.");
    }
  }
  
  private void a(TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new TroopFileModel.7(this, paramTroopFileStatusInfo));
  }
  
  private boolean a(int paramInt, FileBrowserModelBase.OnPreviewVideoOnlineListener paramOnPreviewVideoOnlineListener)
  {
    if ((paramInt != -133) && (paramInt != -132) && (paramInt != -134))
    {
      if ((paramInt != -103) && (paramInt != -301)) {
        return false;
      }
      if (QLog.isDevelopLevel())
      {
        paramOnPreviewVideoOnlineListener = new StringBuilder();
        paramOnPreviewVideoOnlineListener.append("file invalidate retCode = ");
        paramOnPreviewVideoOnlineListener.append(paramInt);
        QLog.i("TroopFileModel<FileAssistant>", 4, paramOnPreviewVideoOnlineListener.toString());
      }
      return true;
    }
    paramOnPreviewVideoOnlineListener.c();
    if (QLog.isDevelopLevel())
    {
      paramOnPreviewVideoOnlineListener = new StringBuilder();
      paramOnPreviewVideoOnlineListener.append("file invalidate retCode = ");
      paramOnPreviewVideoOnlineListener.append(paramInt);
      QLog.i("TroopFileModel<FileAssistant>", 4, paramOnPreviewVideoOnlineListener.toString());
    }
    return true;
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileGetFilePreviewObserver == null) {
      this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileGetFilePreviewObserver = new TroopFileModel.15(this);
    }
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqDownloadFileObserver == null) {
      this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqDownloadFileObserver = new TroopFileModel.16(this);
    }
  }
  
  public int a()
  {
    int j = e();
    int i = super.a();
    if ((this.b == 3) && (j == 2) && (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("is_multi_aio_msg", false))) {
      return 8;
    }
    if (i != 0) {
      return i;
    }
    if (j != 0)
    {
      if (j != 2)
      {
        if (j != 4) {
          if (j == 5) {}
        }
        while ((!FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter, false)) || (!FileManagerUtil.a(this.jdField_a_of_type_AndroidAppActivity, c(), c())))
        {
          return 7;
          if (FileUtils.fileExistsAndNotEmpty(d())) {
            break;
          }
          return 11;
        }
        return 5;
      }
      return 8;
    }
    i = 6;
    return i;
  }
  
  public Intent a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (localFileManagerEntity == null) {
      return null;
    }
    return QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity);
  }
  
  public IServiceInfo a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    TroopFileStatusInfo localTroopFileStatusInfo = a(localFileManagerEntity);
    if (localTroopFileStatusInfo == null)
    {
      QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file info is null.");
      return new DefaultFileColorNoteServiceInfo();
    }
    long l = localFileManagerEntity.TroopUin;
    if ((localTroopFileStatusInfo.b != 3) && (localTroopFileStatusInfo.b != 2) && (localTroopFileStatusInfo.b != 1)) {
      return new TroopFileColorNoteServiceInfo(l, localTroopFileStatusInfo);
    }
    if ((TextUtils.isEmpty(localTroopFileStatusInfo.e)) && (FileUtils.fileExistsAndNotEmpty(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString)))
    {
      QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file is upload.");
      return new LocalFileColorNoteServiceInfo(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString);
    }
    QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file is upload, but local file is not exist.");
    return new DefaultFileColorNoteServiceInfo();
  }
  
  public IDownloadController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIDownloadController == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIDownloadController = new TroopFileModel.6(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIDownloadController;
  }
  
  public IThumbController a()
  {
    return new TroopFileModel.3(this);
  }
  
  public IUploadController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIUploadController == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIUploadController = new TroopFileModel.5(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerControllerIUploadController;
  }
  
  public VideoForTroop a()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
    return new VideoForTroop(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopFileStatusInfo);
  }
  
  protected TroopFileStatusInfo a(FileManagerEntity paramFileManagerEntity)
  {
    return TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity);
  }
  
  public String a()
  {
    return "biz_src_jc_file";
  }
  
  public List<FileBrowserModelBase.ImageFileInfo> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new TroopImageInfo((IFileViewerAdapter)localIterator.next()));
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver != null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new TroopFileModel.4(this);
    if (QLog.isDevelopLevel()) {
      QLog.i("fobserver<FileAssistant>", 1, "add troopMngObserver");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver == null)
    {
      FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
      if (localFileManagerEntity != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = new TroopFileError.TroopFileErrorObserver(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity.TroopUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        TroopFileError.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
      }
    }
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
  
  public void a(FileBrowserModelBase.OnPreviewVideoOnlineListener paramOnPreviewVideoOnlineListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnPreviewVideoOnlineListener = paramOnPreviewVideoOnlineListener;
    q();
    p();
    ThreadManager.post(new TroopFileModel.14(this, paramOnPreviewVideoOnlineListener), 8, null, true);
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
    int k = paramActionSheetItem.action;
    int j = 1;
    int i;
    if (k == 73)
    {
      FileOperaterUtils.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, (FileManagerEntity)localObject1).onClick(null);
      i = j;
    }
    else if (k == 72)
    {
      int m = paramActionSheetItem.uinType;
      paramActionSheetItem = paramActionSheetItem.uin;
      i = j;
      if (!TextUtils.isEmpty(paramActionSheetItem))
      {
        QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject1, true, paramActionSheetItem, m);
        i = j;
      }
    }
    else if (k == 52)
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
      i = j;
      if (FileUtils.fileExistsAndNotEmpty(paramActionSheetItem))
      {
        ((IOCR)QRoute.api(IOCR.class)).startOcrPerformFragment(this.jdField_a_of_type_AndroidAppActivity, paramActionSheetItem, 1, -1002, null);
        i = j;
      }
    }
    else if (k == 132)
    {
      QbSdk.clearDefaultBrowser(this.jdField_a_of_type_AndroidAppActivity, d());
      FileManagerUtil.a(this.jdField_a_of_type_AndroidAppActivity, d());
      ReportController.b(null, "dc00898", "", "", "0X800AFCB", "0X800AFCB", 0, 0, "", "", "", "");
      i = j;
    }
    else if (k == 26)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
      DatalineDeviceChooseModel.a((FileManagerEntity)localObject1).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new TroopFileModel.12(this, (FileManagerEntity)localObject1));
      i = j;
    }
    else
    {
      i = 0;
      super.a(paramActionSheetItem);
    }
    if (i != 0) {
      f(k);
    }
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    ReportController.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected boolean a(FileManagerEntity paramFileManagerEntity)
  {
    long l = FileManagerUtil.b(paramFileManagerEntity.fileName);
    Object localObject1 = TencentDocImportFileInfoProcessor.a();
    Object localObject2 = TencentDocConvertConfigProcessor.a();
    boolean bool3 = false;
    boolean bool1;
    if (localObject2 == null) {
      bool1 = false;
    } else {
      bool1 = ((TencentDocConvertConfigBean)localObject2).d();
    }
    if (localObject1 == null) {
      localObject1 = "";
    } else {
      localObject1 = ((TencentDocImportFileInfoBean)localObject1).c();
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = ".doc|.docx|.xls|.xlsx|";
    }
    boolean bool2 = bool3;
    if (bool1)
    {
      bool2 = bool3;
      if (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsSupport(paramFileManagerEntity.getFilePath(), paramFileManagerEntity.fileName, (String)localObject2))
      {
        bool2 = bool3;
        if (paramFileManagerEntity.fileSize <= l) {
          bool2 = true;
        }
      }
    }
    return bool2;
  }
  
  public boolean a(FileBrowserModelBase.OnPreviewVideoOnlineListener paramOnPreviewVideoOnlineListener)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager == null) {
      return false;
    }
    TroopInfo localTroopInfo = localTroopManager.b(String.valueOf(localFileManagerEntity.TroopUin));
    if (localTroopInfo == null) {
      return false;
    }
    if (NetConnInfoCenter.getServerTimeMillis() <= localTroopInfo.mTroopFileVideoReqInterval)
    {
      if (localTroopInfo.mTroopFileVideoIsWhite != 0)
      {
        if (paramOnPreviewVideoOnlineListener != null) {
          paramOnPreviewVideoOnlineListener.am_();
        }
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "0", "", "", "");
        return true;
      }
      if (paramOnPreviewVideoOnlineListener != null) {
        paramOnPreviewVideoOnlineListener.an_();
      }
      if (TbsVideo.canUseYunbo(BaseApplicationImpl.getContext())) {
        paramOnPreviewVideoOnlineListener = "0";
      } else {
        paramOnPreviewVideoOnlineListener = "-1";
      }
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", paramOnPreviewVideoOnlineListener, "-1", "-1");
      return true;
    }
    TroopFileVideoOnlinePlayManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, new TroopFileModel.13(this, paramOnPreviewVideoOnlineListener, localTroopInfo, localTroopManager));
    return true;
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    int i = d();
    if ((i != 5) && (i != 4)) {
      return super.a();
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (localObject != null)
    {
      if (((FileManagerEntity)localObject).isZipInnerFile) {
        return null;
      }
      if (((FileManagerEntity)localObject).status == 16) {
        return null;
      }
      ArrayList localArrayList1 = c((FileManagerEntity)localObject);
      localObject = d((FileManagerEntity)localObject);
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      if ((localArrayList1 != null) && (!localArrayList1.isEmpty())) {
        localArrayList2.addAll(localArrayList1);
      }
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty())) {
        localArrayList3.addAll((Collection)localObject);
      }
      return new ArrayList[] { localArrayList2, localArrayList3 };
    }
    return null;
  }
  
  public int b()
  {
    int i = a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()).b;
    if ((i != 3) && (i != 2) && (i != 10))
    {
      if (i == 9) {
        return 3;
      }
      if ((i != 8) && (i != 1))
      {
        if (i == 4) {
          return 2;
        }
        if (i != 6)
        {
          if (i == 11) {
            return 1;
          }
          if (i == 12) {
            return 16;
          }
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("TroopFileModel getFileStatus : troopFileStatus[");
            localStringBuilder.append(i);
            localStringBuilder.append("] can not change troop file status to FMConstants status");
            QLog.i("TroopFileModel<FileAssistant>", 2, localStringBuilder.toString());
          }
          return super.b();
        }
        return 1;
      }
      return 2;
    }
    return 3;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().TroopUin;
    }
    return super.b();
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "del troopMngObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver != null) {
      TroopFileError.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = null;
    this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqDownloadFileObserver = null;
    this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileGetFilePreviewObserver = null;
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    String str;
    if (paramInt == 6)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
      if (localObject != null) {
        str = String.valueOf(((FileManagerEntity)localObject).TroopUin);
      } else {
        str = "";
      }
      if (localObject != null) {
        localObject = FileManagerUtil.b(((FileManagerEntity)localObject).nFileType);
      } else {
        localObject = "unknow";
      }
      ReportController.b(null, "dc00899", "Grp_files", "", "oper", "Clk_pre_video", 0, 0, str, "", (String)localObject, "1");
      return;
    }
    if (paramInt == 4)
    {
      if (TbsVideo.canUseYunbo(BaseApplicationImpl.getContext())) {
        str = "0";
      } else {
        str = "-1";
      }
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", str, "-1", "-1");
      return;
    }
    if (paramInt == 8) {
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "video_file_preview", 0, 0, "", "", "", "");
    }
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] b()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    String str = d();
    boolean bool = FileUtil.a(str);
    localArrayList1.add(QFileUtils.a(2, FileOperaterUtils.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, localFileManagerEntity)));
    localArrayList1.add(QFileUtils.a(26, null));
    if (!bool) {
      localArrayList1.add(QFileUtils.a(27, FileOperaterUtils.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, localFileManagerEntity)));
    } else {
      localArrayList1.add(QFileUtils.a(27, FileOperaterUtils.a(localFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, str)));
    }
    WXShareHelper localWXShareHelper = WXShareHelper.a();
    if ((bool) && (localWXShareHelper.a()) && (localWXShareHelper.d())) {
      localArrayList1.add(QFileUtils.a(9, FileOperaterUtils.b(this.jdField_a_of_type_AndroidAppActivity, str)));
    }
    if (bool) {
      localArrayList1.add(QFileUtils.a(64, new TroopFileModel.11(this)));
    }
    if (bool) {
      localArrayList2.add(QFileUtils.a(39, null));
    }
    if (FileManagerUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a())) {
      localArrayList1.add(QFileUtils.a(6, FileOperaterUtils.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, localFileManagerEntity)));
    }
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
  
  protected ArrayList<ShareActionSheetBuilder.ActionSheetItem> c(FileManagerEntity paramFileManagerEntity)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QFileUtils.a(2, FileOperaterUtils.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, paramFileManagerEntity)));
    localArrayList.add(QFileUtils.a(26, null));
    localArrayList.add(QFileUtils.a(27, FileOperaterUtils.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, paramFileManagerEntity)));
    return localArrayList;
  }
  
  protected ArrayList<ShareActionSheetBuilder.ActionSheetItem> d(FileManagerEntity paramFileManagerEntity)
  {
    ArrayList localArrayList = new ArrayList();
    int j = j();
    if ((j != 0) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.f()))
    {
      int i = 70;
      if ((j != 1) && (j == 2)) {
        i = 82;
      }
      localArrayList.add(QFileUtils.a(i, new TroopFileModel.10(this, j)));
    }
    String str = d();
    boolean bool = FileUtil.a(str);
    if ((FileManagerUtil.a(paramFileManagerEntity.fileName) == 0) && (bool)) {
      localArrayList.add(QFileUtils.a(39, null));
    }
    if (FileManagerUtil.d(paramFileManagerEntity)) {
      localArrayList.add(QFileUtils.a(6, FileOperaterUtils.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, paramFileManagerEntity)));
    }
    a(paramFileManagerEntity, localArrayList);
    if (a(paramFileManagerEntity))
    {
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = QFileUtils.a(119, FileOperaterUtils.a(paramFileManagerEntity, this.jdField_a_of_type_AndroidAppActivity));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
      localArrayList.add(localActionSheetItem);
    }
    if (LinkUtils.a(paramFileManagerEntity, bool))
    {
      localArrayList.add(QFileUtils.a(122, FileOperaterUtils.a(this.jdField_a_of_type_AndroidAppActivity, paramFileManagerEntity, str)));
      localArrayList.add(QFileUtils.a(123, FileOperaterUtils.b(this.jdField_a_of_type_AndroidAppActivity, paramFileManagerEntity, str)));
    }
    paramFileManagerEntity = a(paramFileManagerEntity);
    if ((paramFileManagerEntity != null) && (paramFileManagerEntity.jdField_a_of_type_JavaUtilUUID != null) && (e() == 0) && ((FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.jdField_c_of_type_JavaLangString)) || (bool))) {
      localArrayList.add(QFileUtils.a(52, null));
    }
    if ((bool) && (a(str)))
    {
      localArrayList.add(QFileUtils.a(132, null));
      ReportController.b(null, "dc00898", "", "", "0X800AFCC", "0X800AFCC", 0, 0, "", "", "", "");
    }
    return localArrayList;
  }
  
  public void d()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    TroopFileStatusInfo localTroopFileStatusInfo = a(localFileManagerEntity);
    if ((TextUtils.isEmpty(this.g)) && (localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID != null)) {
      this.g = localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID.toString();
    }
    boolean bool = FileManagerUtil.a(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString);
    TroopFileItemOperation localTroopFileItemOperation = new TroopFileItemOperation(localFileManagerEntity.TroopUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity);
    if ((localTroopFileStatusInfo.b != 10) && (localTroopFileStatusInfo.b != 9))
    {
      if ((localTroopFileStatusInfo.b != 7) && ((bool) || (localTroopFileStatusInfo.b != 6)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopFileModel<FileAssistant>", 2, "TroopFileModel doStartDownload : can not handle file info status,download error");
        }
      }
      else
      {
        if (localFileManagerEntity.isZipInnerFile) {
          localTroopFileItemOperation.a(localFileManagerEntity);
        } else {
          localTroopFileItemOperation.a(localFileManagerEntity.strTroopFilePath, localTroopFileStatusInfo.g, localTroopFileStatusInfo.jdField_c_of_type_Long, localTroopFileStatusInfo.h);
        }
        localFileManagerEntity.status = 2;
      }
    }
    else
    {
      if (localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID != null)
      {
        localTroopFileItemOperation.b(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
        localFileManagerEntity.status = 2;
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileModel<FileAssistant>", 2, "TroopFileModel doStartDownload : resumeDownload error, infoId is null");
      }
    }
  }
  
  public String f()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    StringBuilder localStringBuilder = new StringBuilder(FileUtil.a(c()));
    if ((104 == localFileManagerEntity.busId) && (localFileManagerEntity.lastTime > 0L))
    {
      localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131692346));
      localStringBuilder.append(TroopFileUtils.a(BaseApplicationImpl.getContext(), localFileManagerEntity.lastTime));
    }
    return localStringBuilder.toString();
  }
  
  public void g()
  {
    TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().TroopUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().strTroopFilePath, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().busId, new TroopFileModel.1(this));
    TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().TroopUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().busId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().strTroopFilePath, new TroopFileModel.2(this));
  }
  
  public int h()
  {
    int i = a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()).b;
    if ((i != 3) && (i != 2))
    {
      if (i == 1) {
        return 1;
      }
      return 2;
    }
    return 1;
  }
  
  public String i()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
    if (localTroopFileStatusInfo != null) {
      return localTroopFileStatusInfo.j;
    }
    return null;
  }
  
  public void i()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    super.i();
    if (d() == 4)
    {
      TroopFileStatusInfo localTroopFileStatusInfo = a(localFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(new TroopFilePreviewController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, localTroopFileStatusInfo));
    }
  }
  
  public int j()
  {
    int i = e();
    int j = 0;
    if ((i != 0) && (i != 2) && (i != 13)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return 0;
    }
    TroopFileStatusInfo localTroopFileStatusInfo = a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
    if (localTroopFileStatusInfo == null) {
      return 0;
    }
    if (((localTroopFileStatusInfo.b == 3) || (localTroopFileStatusInfo.b == 2) || (localTroopFileStatusInfo.b == 1)) && (TextUtils.isEmpty(localTroopFileStatusInfo.e)))
    {
      QLog.i("TroopFileModel<FileAssistant>", 1, "getColorLabelShowType: troop file is upload, can not add color note.");
      return 0;
    }
    if (TextUtils.isEmpty(localTroopFileStatusInfo.e))
    {
      i = j;
      if (!FileUtils.fileExistsAndNotEmpty(d())) {}
    }
    else
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.e())) {
        return 2;
      }
      i = 1;
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
  
  public String n()
  {
    if (a() == 2)
    {
      Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
      if (TextUtils.isEmpty(this.h))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((TroopFileStatusInfo)localObject).e);
        localStringBuilder.append("_");
        localStringBuilder.append(System.currentTimeMillis());
        this.h = localStringBuilder.toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getContextId: troop video file random contextId: ");
        ((StringBuilder)localObject).append(this.h);
        QLog.i("TroopFileModel<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      }
      return this.h;
    }
    return super.n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel
 * JD-Core Version:    0.7.0.1
 */