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
import com.tencent.mobileqq.ocr.OCRPerformFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
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
    if (d() == 3) {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.f();
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("TroopFileModel<FileAssistant>", 2, "file download finished, but file not exist.");
  }
  
  private void a(TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new TroopFileModel.7(this, paramTroopFileStatusInfo));
  }
  
  private boolean a(int paramInt, FileBrowserModelBase.OnPreviewVideoOnlineListener paramOnPreviewVideoOnlineListener)
  {
    if ((paramInt == -133) || (paramInt == -132) || (paramInt == -134))
    {
      paramOnPreviewVideoOnlineListener.c();
      if (QLog.isDevelopLevel()) {
        QLog.i("TroopFileModel<FileAssistant>", 4, "file invalidate retCode = " + paramInt);
      }
    }
    do
    {
      return true;
      if ((paramInt != -103) && (paramInt != -301)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("TroopFileModel<FileAssistant>", 4, "file invalidate retCode = " + paramInt);
    return true;
    return false;
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileGetFilePreviewObserver == null) {
      this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileGetFilePreviewObserver = new TroopFileModel.15(this);
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqDownloadFileObserver == null) {
      this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqDownloadFileObserver = new TroopFileModel.16(this);
    }
  }
  
  public int a()
  {
    int j = 7;
    int m = e();
    int k = super.a();
    if ((this.b == 3) && (m == 2) && (!this.jdField_a_of_type_AndroidOsBundle.getBoolean("is_multi_aio_msg", false))) {
      return 8;
    }
    if (k != 0) {
      return k;
    }
    int i = j;
    switch (m)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      return i;
      i = 6;
      continue;
      i = j;
      if (FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter, false))
      {
        i = j;
        if (FileManagerUtil.a(this.jdField_a_of_type_AndroidAppActivity, c(), c()))
        {
          i = 5;
          continue;
          i = 8;
          continue;
          if (!FileUtils.b(d())) {
            i = 11;
          } else {
            i = k;
          }
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
    if ((localTroopFileStatusInfo.b == 3) || (localTroopFileStatusInfo.b == 2) || (localTroopFileStatusInfo.b == 1))
    {
      if ((TextUtils.isEmpty(localTroopFileStatusInfo.e)) && (FileUtils.b(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString)))
      {
        QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file is upload.");
        return new LocalFileColorNoteServiceInfo(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString);
      }
      QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file is upload, but local file is not exist.");
      return new DefaultFileColorNoteServiceInfo();
    }
    return new TroopFileColorNoteServiceInfo(l, localTroopFileStatusInfo);
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver != null) {}
    QQAppInterface localQQAppInterface;
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new TroopFileModel.4(this);
        if (QLog.isDevelopLevel()) {
          QLog.i("fobserver<FileAssistant>", 1, "add troopBusinessObserver");
        }
        localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver != null);
      localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    } while (localFileManagerEntity == null);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver = new TroopFileError.TroopFileErrorObserver(this.jdField_a_of_type_AndroidAppActivity, localFileManagerEntity.TroopUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    TroopFileError.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileError$TroopFileErrorObserver);
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
  
  public void a(FileBrowserModelBase.OnPreviewVideoOnlineListener paramOnPreviewVideoOnlineListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnPreviewVideoOnlineListener = paramOnPreviewVideoOnlineListener;
    p();
    o();
    ThreadManager.post(new TroopFileModel.14(this, paramOnPreviewVideoOnlineListener), 8, null, true);
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem == null) {}
    for (;;)
    {
      return;
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
      Object localObject2 = d();
      if ((localObject1 != null) || (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        int j = paramActionSheetItem.action;
        int i;
        if (j == 73)
        {
          FileOperaterUtils.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, (FileManagerEntity)localObject1).onClick(null);
          i = 1;
        }
        while (i != 0)
        {
          f(j);
          return;
          if (j == 72)
          {
            i = paramActionSheetItem.uinType;
            paramActionSheetItem = paramActionSheetItem.uin;
            if (!TextUtils.isEmpty(paramActionSheetItem)) {
              QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, (FileManagerEntity)localObject1, true, paramActionSheetItem, i);
            }
            i = 1;
          }
          else if (j == 52)
          {
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
            if (FileUtils.b(paramActionSheetItem)) {
              OCRPerformFragment.a(this.jdField_a_of_type_AndroidAppActivity, paramActionSheetItem, 1, -1002, null);
            }
            i = 1;
          }
          else if (j == 132)
          {
            QbSdk.clearDefaultBrowser(this.jdField_a_of_type_AndroidAppActivity, d());
            FileManagerUtil.a(this.jdField_a_of_type_AndroidAppActivity, d());
            ReportController.b(null, "dc00898", "", "", "0X800AFCB", "0X800AFCB", 0, 0, "", "", "", "");
            i = 1;
          }
          else if (j == 26)
          {
            ReportController.b(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
            DatalineDeviceChooseModel.a((FileManagerEntity)localObject1).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new TroopFileModel.12(this, (FileManagerEntity)localObject1));
            i = 1;
          }
          else
          {
            i = 0;
            super.a(paramActionSheetItem);
          }
        }
      }
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
    long l = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.fileName);
    Object localObject1 = TencentDocImportFileInfoProcessor.a();
    Object localObject2 = TencentDocConvertConfigProcessor.a();
    boolean bool;
    if (localObject2 == null)
    {
      bool = false;
      if (localObject1 != null) {
        break label98;
      }
    }
    label98:
    for (localObject1 = "";; localObject1 = ((TencentDocImportFileInfoBean)localObject1).c())
    {
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = TeamWorkUtils.jdField_a_of_type_JavaLangString;
      }
      if ((!bool) || (!TeamWorkUtils.a(paramFileManagerEntity.getFilePath(), paramFileManagerEntity.fileName, (String)localObject2)) || (paramFileManagerEntity.fileSize > l)) {
        break label108;
      }
      return true;
      bool = ((TencentDocConvertConfigBean)localObject2).d();
      break;
    }
    label108:
    return false;
  }
  
  public boolean a(FileBrowserModelBase.OnPreviewVideoOnlineListener paramOnPreviewVideoOnlineListener)
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager == null) {}
    TroopInfo localTroopInfo;
    do
    {
      return false;
      localTroopInfo = localTroopManager.b(String.valueOf(localFileManagerEntity.TroopUin));
    } while (localTroopInfo == null);
    if (NetConnInfoCenter.getServerTimeMillis() <= localTroopInfo.mTroopFileVideoReqInterval)
    {
      if (localTroopInfo.mTroopFileVideoIsWhite != 0)
      {
        if (paramOnPreviewVideoOnlineListener != null) {
          paramOnPreviewVideoOnlineListener.au_();
        }
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "0", "", "", "");
        return true;
      }
      if (paramOnPreviewVideoOnlineListener != null) {
        paramOnPreviewVideoOnlineListener.av_();
      }
      if (TbsVideo.canUseYunbo(BaseApplicationImpl.getContext())) {}
      for (paramOnPreviewVideoOnlineListener = "0";; paramOnPreviewVideoOnlineListener = "-1")
      {
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", paramOnPreviewVideoOnlineListener, "-1", "-1");
        break;
      }
    }
    TroopFileVideoOnlinePlayManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, new TroopFileModel.13(this, paramOnPreviewVideoOnlineListener, localTroopInfo, localTroopManager));
    return true;
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList1 = null;
    int i = d();
    if ((i != 5) && (i != 4)) {
      localObject1 = super.a();
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
          localObject1 = localArrayList1;
        } while (localObject2 == null);
        localObject1 = localArrayList1;
      } while (((FileManagerEntity)localObject2).isZipInnerFile);
      localObject1 = localArrayList1;
    } while (((FileManagerEntity)localObject2).status == 16);
    Object localObject1 = c((FileManagerEntity)localObject2);
    localArrayList1 = d((FileManagerEntity)localObject2);
    Object localObject2 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty())) {
      ((ArrayList)localObject2).addAll((Collection)localObject1);
    }
    if ((localArrayList1 != null) && (!localArrayList1.isEmpty())) {
      localArrayList2.addAll(localArrayList1);
    }
    return new ArrayList[] { localObject2, localArrayList2 };
  }
  
  public int b()
  {
    int j = 1;
    int k = a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()).b;
    int i;
    if ((k == 3) || (k == 2) || (k == 10) || (k == 9)) {
      i = 3;
    }
    do
    {
      do
      {
        return i;
        if ((k == 8) || (k == 1) || (k == 4)) {
          return 2;
        }
        i = j;
      } while (k == 6);
      i = j;
    } while (k == 11);
    if (k == 12) {
      return 16;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileModel<FileAssistant>", 2, "TroopFileModel getFileStatus : troopFileStatus[" + k + "] can not change troop file status to FMConstants status");
    }
    return super.b();
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
        QLog.i("fobserver<FileAssistant>", 1, "del troopBusinessObserver");
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
    Object localObject;
    String str;
    if (paramInt == 6)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
      if (localObject != null)
      {
        str = String.valueOf(((FileManagerEntity)localObject).TroopUin);
        if (localObject == null) {
          break label79;
        }
        localObject = FileManagerUtil.b(((FileManagerEntity)localObject).nFileType);
        label45:
        ReportController.b(null, "dc00899", "Grp_files", "", "oper", "Clk_pre_video", 0, 0, str, "", (String)localObject, "1");
      }
    }
    label79:
    do
    {
      return;
      str = "";
      break;
      localObject = "unknow";
      break label45;
      if (paramInt == 4)
      {
        if (TbsVideo.canUseYunbo(BaseApplicationImpl.getContext())) {}
        for (str = "0";; str = "-1")
        {
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", str, "-1", "-1");
          return;
        }
      }
    } while (paramInt != 8);
    ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "video_file_preview", 0, 0, "", "", "", "");
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] b()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    String str = d();
    boolean bool = FileUtil.b(str);
    localArrayList1.add(QFileUtils.a(2, FileOperaterUtils.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, localFileManagerEntity)));
    localArrayList1.add(QFileUtils.a(26, null));
    if (!bool) {
      localArrayList1.add(QFileUtils.a(27, FileOperaterUtils.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, localFileManagerEntity)));
    }
    for (;;)
    {
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
      localArrayList1.add(QFileUtils.a(27, FileOperaterUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, str)));
    }
  }
  
  protected ArrayList<ShareActionSheetBuilder.ActionSheetItem> c(FileManagerEntity paramFileManagerEntity)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QFileUtils.a(2, FileOperaterUtils.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, paramFileManagerEntity)));
    localArrayList.add(QFileUtils.a(26, null));
    localArrayList.add(QFileUtils.a(27, FileOperaterUtils.e(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser, paramFileManagerEntity)));
    return localArrayList;
  }
  
  protected ArrayList<ShareActionSheetBuilder.ActionSheetItem> d(FileManagerEntity paramFileManagerEntity)
  {
    ArrayList localArrayList = new ArrayList();
    int j = j();
    int i;
    if ((j != 0) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.f()))
    {
      i = 70;
      if (j != 1) {
        break label360;
      }
      i = 70;
    }
    for (;;)
    {
      localArrayList.add(QFileUtils.a(i, new TroopFileModel.10(this, j)));
      String str = d();
      boolean bool = FileUtil.b(str);
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
      if ((paramFileManagerEntity != null) && (paramFileManagerEntity.jdField_a_of_type_JavaUtilUUID != null) && (e() == 0) && ((FileUtils.b(paramFileManagerEntity.c)) || (bool))) {
        localArrayList.add(QFileUtils.a(52, null));
      }
      if ((bool) && (a(str)))
      {
        localArrayList.add(QFileUtils.a(132, null));
        ReportController.b(null, "dc00898", "", "", "0X800AFCC", "0X800AFCC", 0, 0, "", "", "", "");
      }
      return localArrayList;
      label360:
      if (j == 2) {
        i = 82;
      }
    }
  }
  
  public String f()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    StringBuilder localStringBuilder = new StringBuilder(FileUtil.a(c()));
    if ((104 == localFileManagerEntity.busId) && (localFileManagerEntity.lastTime > 0L))
    {
      localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131692414));
      localStringBuilder.append(TroopFileUtils.a(BaseApplicationImpl.getContext(), localFileManagerEntity.lastTime));
    }
    return localStringBuilder.toString();
  }
  
  public void f()
  {
    TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().TroopUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().strTroopFilePath, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().busId, new TroopFileModel.1(this));
    TroopFileProtocol.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().TroopUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().busId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a().strTroopFilePath, new TroopFileModel.2(this));
  }
  
  public int h()
  {
    int i = 2;
    int j = a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a()).b;
    if ((j == 3) || (j == 2) || (j == 1)) {
      i = 1;
    }
    return i;
  }
  
  public void h()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    super.h();
    if (d() == 4)
    {
      TroopFileStatusInfo localTroopFileStatusInfo = a(localFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(new TroopFilePreviewController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localFileManagerEntity.TroopUin, localTroopFileStatusInfo));
    }
  }
  
  public String i()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
    if (localTroopFileStatusInfo != null) {
      return localTroopFileStatusInfo.j;
    }
    return null;
  }
  
  public int j()
  {
    int i = e();
    if ((i != 0) && (i != 2) && (i != 13)) {}
    for (i = 1;; i = 0)
    {
      if (i == 0) {}
      TroopFileStatusInfo localTroopFileStatusInfo;
      do
      {
        do
        {
          return 0;
          localTroopFileStatusInfo = a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
        } while (localTroopFileStatusInfo == null);
        if (((localTroopFileStatusInfo.b == 3) || (localTroopFileStatusInfo.b == 2) || (localTroopFileStatusInfo.b == 1)) && (TextUtils.isEmpty(localTroopFileStatusInfo.e)))
        {
          QLog.i("TroopFileModel<FileAssistant>", 1, "getColorLabelShowType: troop file is upload, can not add color note.");
          return 0;
        }
      } while ((TextUtils.isEmpty(localTroopFileStatusInfo.e)) && (!FileUtils.b(d())));
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.e())) {
        return 2;
      }
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
      TroopFileStatusInfo localTroopFileStatusInfo = a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a());
      if (TextUtils.isEmpty(this.h))
      {
        this.h = (localTroopFileStatusInfo.e + "_" + System.currentTimeMillis());
        QLog.i("TroopFileModel<FileAssistant>", 1, "getContextId: troop video file random contextId: " + this.h);
      }
      return this.h;
    }
    return super.n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel
 * JD-Core Version:    0.7.0.1
 */