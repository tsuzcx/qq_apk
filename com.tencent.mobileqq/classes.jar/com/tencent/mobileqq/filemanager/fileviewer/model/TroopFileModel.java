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
  private String A;
  private int B;
  private FileBrowserModelBase.OnPreviewVideoOnlineListener C;
  private TroopFileReqDownloadFileObserver D;
  private TroopFileGetFilePreviewObserver E;
  private TroopFileError.TroopFileErrorObserver F;
  private String G = "";
  private BizTroopObserver z;
  
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
    if ((this.t == 3) && (z() == 2))
    {
      localObject = new SessionInfo();
      ((SessionInfo)localObject).a = 1;
      l = this.u.getLong("troopfile_shmsgseq");
      bool1 = this.u.getBoolean("is_multi_aio_msg", false);
      MessageRecord localMessageRecord = this.a.getMessageFacade().c(String.valueOf(paramFileManagerEntity.TroopUin), 1, l, -2017);
      Rect localRect = (Rect)this.u.getParcelable("file_browser_params_thumb_bound");
      if ((this.k != null) && (localMessageRecord != null) && (!bool1))
      {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new TroopFileModel.8(this, localMessageRecord, (SessionInfo)localObject, paramFileManagerEntity, paramTroopFileStatusInfo, localFileManagerEntity, localRect), 100L);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new TroopFileModel.9(this, localMessageRecord), 300L);
      }
    }
    if (w() == 3)
    {
      if (this.q != null) {
        this.q.f();
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.w("TroopFileModel<FileAssistant>", 2, "file download finished, but file not exist.");
    }
  }
  
  private void a(TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    this.i.runOnUiThread(new TroopFileModel.7(this, paramTroopFileStatusInfo));
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
    paramOnPreviewVideoOnlineListener.cq_();
    if (QLog.isDevelopLevel())
    {
      paramOnPreviewVideoOnlineListener = new StringBuilder();
      paramOnPreviewVideoOnlineListener.append("file invalidate retCode = ");
      paramOnPreviewVideoOnlineListener.append(paramInt);
      QLog.i("TroopFileModel<FileAssistant>", 4, paramOnPreviewVideoOnlineListener.toString());
    }
    return true;
  }
  
  private void av()
  {
    if (this.E == null) {
      this.E = new TroopFileModel.15(this);
    }
  }
  
  private void aw()
  {
    if (this.D == null) {
      this.D = new TroopFileModel.16(this);
    }
  }
  
  public String D()
  {
    FileManagerEntity localFileManagerEntity = this.c.r();
    StringBuilder localStringBuilder = new StringBuilder(FileUtil.a(x()));
    if ((104 == localFileManagerEntity.busId) && (localFileManagerEntity.lastTime > 0L))
    {
      localStringBuilder.append(BaseApplicationImpl.getContext().getString(2131889334));
      localStringBuilder.append(TroopFileUtils.a(BaseApplicationImpl.getContext(), localFileManagerEntity.lastTime));
    }
    return localStringBuilder.toString();
  }
  
  public void M()
  {
    TroopFileProtocol.a(this.a, this.c.r().TroopUin, this.c.r().strTroopFilePath, this.c.r().busId, new TroopFileModel.1(this));
    TroopFileProtocol.a(this.a, this.c.r().TroopUin, this.c.r().busId, this.c.r().strTroopFilePath, new TroopFileModel.2(this));
  }
  
  public int O()
  {
    int i = e(this.c.r()).e;
    if ((i != 3) && (i != 2))
    {
      if (i == 1) {
        return 1;
      }
      return 2;
    }
    return 1;
  }
  
  public IThumbController Q()
  {
    return new TroopFileModel.3(this);
  }
  
  public List<FileBrowserModelBase.ImageFileInfo> S()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.b != null)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new TroopImageInfo((IFileViewerAdapter)localIterator.next()));
      }
    }
    return localArrayList;
  }
  
  public int W()
  {
    int i = z();
    int j = 0;
    if ((i != 0) && (i != 2) && (i != 13)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return 0;
    }
    TroopFileStatusInfo localTroopFileStatusInfo = e(this.c.r());
    if (localTroopFileStatusInfo == null) {
      return 0;
    }
    if (((localTroopFileStatusInfo.e == 3) || (localTroopFileStatusInfo.e == 2) || (localTroopFileStatusInfo.e == 1)) && (TextUtils.isEmpty(localTroopFileStatusInfo.r)))
    {
      QLog.i("TroopFileModel<FileAssistant>", 1, "getColorLabelShowType: troop file is upload, can not add color note.");
      return 0;
    }
    if (TextUtils.isEmpty(localTroopFileStatusInfo.r))
    {
      i = j;
      if (!FileUtils.fileExistsAndNotEmpty(y())) {}
    }
    else
    {
      if ((this.k != null) && (this.k.k())) {
        return 2;
      }
      i = 1;
    }
    return i;
  }
  
  public IServiceInfo X()
  {
    FileManagerEntity localFileManagerEntity = this.c.r();
    TroopFileStatusInfo localTroopFileStatusInfo = e(localFileManagerEntity);
    if (localTroopFileStatusInfo == null)
    {
      QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file info is null.");
      return new DefaultFileColorNoteServiceInfo();
    }
    long l = localFileManagerEntity.TroopUin;
    if ((localTroopFileStatusInfo.e != 3) && (localTroopFileStatusInfo.e != 2) && (localTroopFileStatusInfo.e != 1)) {
      return new TroopFileColorNoteServiceInfo(l, localTroopFileStatusInfo);
    }
    if ((TextUtils.isEmpty(localTroopFileStatusInfo.r)) && (FileUtils.fileExistsAndNotEmpty(localTroopFileStatusInfo.k)))
    {
      QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file is upload.");
      return new LocalFileColorNoteServiceInfo(localTroopFileStatusInfo.k);
    }
    QLog.i("TroopFileModel<FileAssistant>", 1, "getFileColorNoteInfo: troop file is upload, but local file is not exist.");
    return new DefaultFileColorNoteServiceInfo();
  }
  
  public String Y()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = e(this.c.r());
    if (localTroopFileStatusInfo != null) {
      return localTroopFileStatusInfo.z;
    }
    return null;
  }
  
  public boolean Z()
  {
    return true;
  }
  
  public int a()
  {
    int j = z();
    int i = super.a();
    if ((this.t == 3) && (j == 2) && (!this.u.getBoolean("is_multi_aio_msg", false))) {
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
        while ((!FileManagerUtil.b(this.a, this.c, false)) || (!FileManagerUtil.a(this.i, v(), x())))
        {
          return 7;
          if (FileUtils.fileExistsAndNotEmpty(y())) {
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
  
  public void a(FileManagerEntity paramFileManagerEntity, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    if (this.u == null) {
      return;
    }
    if (this.u.getBoolean("file_location_pos_entrance_multiseq", false)) {
      return;
    }
    int i = this.u.getInt("FromChatHistoryTab", 0);
    if (i == 106) {
      return;
    }
    i = QFileUtils.c(this.t, i);
    if (i == 0) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("file_location_pos_entrance_type", i);
    paramArrayList.add(QFileUtils.a(54, FileOperaterUtils.a(this.i, localBundle, paramFileManagerEntity)));
    ReportController.b(null, "dc00898", "", "", "0X800B450", "0X800B450", i, 0, "", "", "", "");
  }
  
  public void a(FileBrowserModelBase.OnPreviewVideoOnlineListener paramOnPreviewVideoOnlineListener)
  {
    this.C = paramOnPreviewVideoOnlineListener;
    aw();
    av();
    ThreadManager.post(new TroopFileModel.14(this, paramOnPreviewVideoOnlineListener), 8, null, true);
  }
  
  public void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    Object localObject1 = this.c.r();
    Object localObject2 = y();
    if ((localObject1 == null) && (TextUtils.isEmpty((CharSequence)localObject2))) {
      return;
    }
    int k = paramActionSheetItem.action;
    int j = 1;
    int i;
    if (k == 73)
    {
      FileOperaterUtils.c(this.k, (FileManagerEntity)localObject1).onClick(null);
      i = j;
    }
    else if (k == 72)
    {
      int m = paramActionSheetItem.uinType;
      paramActionSheetItem = paramActionSheetItem.uin;
      i = j;
      if (!TextUtils.isEmpty(paramActionSheetItem))
      {
        QFileUtils.a(this.a, this.i, (FileManagerEntity)localObject1, true, paramActionSheetItem, m);
        i = j;
      }
    }
    else if (k == 52)
    {
      localObject1 = y();
      paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
      if (!FileUtils.fileExistsAndNotEmpty((String)localObject1))
      {
        localObject2 = this.c.r();
        paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
        if (localObject2 != null) {
          paramActionSheetItem = ((FileManagerEntity)localObject2).strLargeThumPath;
        }
      }
      i = j;
      if (FileUtils.fileExistsAndNotEmpty(paramActionSheetItem))
      {
        ((IOCR)QRoute.api(IOCR.class)).startOcrPerformFragment(this.i, paramActionSheetItem, 1, -1002, null);
        i = j;
      }
    }
    else if (k == 132)
    {
      QbSdk.clearDefaultBrowser(this.i, y());
      FileManagerUtil.a(this.i, y());
      ReportController.b(null, "dc00898", "", "", "0X800AFCB", "0X800AFCB", 0, 0, "", "", "", "");
      i = j;
    }
    else if (k == 26)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
      DatalineDeviceChooseModel.a((FileManagerEntity)localObject1).a(this.i, this.a, new TroopFileModel.12(this, (FileManagerEntity)localObject1));
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
  
  public String aa()
  {
    FileManagerEntity localFileManagerEntity = this.c.r();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.yybApkPackageName;
    }
    return "";
  }
  
  public String ab()
  {
    FileManagerEntity localFileManagerEntity = this.c.r();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.yybApkName;
    }
    return "";
  }
  
  public String ac()
  {
    if (z() == 5)
    {
      FileManagerEntity localFileManagerEntity = this.c.r();
      if (localFileManagerEntity != null) {
        return localFileManagerEntity.yybApkIconUrl;
      }
    }
    return "";
  }
  
  protected boolean ad()
  {
    return true;
  }
  
  public String ah()
  {
    if (a() == 2)
    {
      Object localObject = e(this.c.r());
      if (TextUtils.isEmpty(this.G))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((TroopFileStatusInfo)localObject).r);
        localStringBuilder.append("_");
        localStringBuilder.append(System.currentTimeMillis());
        this.G = localStringBuilder.toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getContextId: troop video file random contextId: ");
        ((StringBuilder)localObject).append(this.G);
        QLog.i("TroopFileModel<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      }
      return this.G;
    }
    return super.ah();
  }
  
  public VideoForTroop au()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = e(this.c.r());
    return new VideoForTroop(this.a, localTroopFileStatusInfo);
  }
  
  public int b()
  {
    int i = e(this.c.r()).e;
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
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    String str;
    if (paramInt == 6)
    {
      Object localObject = this.c.r();
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
  
  public boolean b(FileBrowserModelBase.OnPreviewVideoOnlineListener paramOnPreviewVideoOnlineListener)
  {
    FileManagerEntity localFileManagerEntity = this.c.r();
    TroopManager localTroopManager = (TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager == null) {
      return false;
    }
    TroopInfo localTroopInfo = localTroopManager.f(String.valueOf(localFileManagerEntity.TroopUin));
    if (localTroopInfo == null) {
      return false;
    }
    if (NetConnInfoCenter.getServerTimeMillis() <= localTroopInfo.mTroopFileVideoReqInterval)
    {
      if (localTroopInfo.mTroopFileVideoIsWhite != 0)
      {
        if (paramOnPreviewVideoOnlineListener != null) {
          paramOnPreviewVideoOnlineListener.co_();
        }
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "0", "", "", "");
        return true;
      }
      if (paramOnPreviewVideoOnlineListener != null) {
        paramOnPreviewVideoOnlineListener.cp_();
      }
      if (TbsVideo.canUseYunbo(BaseApplicationImpl.getContext())) {
        paramOnPreviewVideoOnlineListener = "0";
      } else {
        paramOnPreviewVideoOnlineListener = "-1";
      }
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "troop_troopfile_video_cloudPlay", "online_play_show", 0, 0, "-1", paramOnPreviewVideoOnlineListener, "-1", "-1");
      return true;
    }
    TroopFileVideoOnlinePlayManager.a(this.a, localFileManagerEntity.TroopUin, new TroopFileModel.13(this, paramOnPreviewVideoOnlineListener, localTroopInfo, localTroopManager));
    return true;
  }
  
  protected ArrayList<ShareActionSheetBuilder.ActionSheetItem> c(FileManagerEntity paramFileManagerEntity)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QFileUtils.a(2, FileOperaterUtils.c(this.k, paramFileManagerEntity)));
    localArrayList.add(QFileUtils.a(26, null));
    localArrayList.add(QFileUtils.a(27, FileOperaterUtils.d(this.k, paramFileManagerEntity)));
    return localArrayList;
  }
  
  protected void c()
  {
    if (this.z != null) {
      return;
    }
    this.z = new TroopFileModel.4(this);
    if (QLog.isDevelopLevel()) {
      QLog.i("fobserver<FileAssistant>", 1, "add troopMngObserver");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    localQQAppInterface.addObserver(this.z);
    if (this.F == null)
    {
      FileManagerEntity localFileManagerEntity = this.c.r();
      if (localFileManagerEntity != null)
      {
        this.F = new TroopFileError.TroopFileErrorObserver(this.i, localFileManagerEntity.TroopUin, this.a);
        TroopFileError.a(localQQAppInterface, this.F);
      }
    }
  }
  
  protected ArrayList<ShareActionSheetBuilder.ActionSheetItem> d(FileManagerEntity paramFileManagerEntity)
  {
    ArrayList localArrayList = new ArrayList();
    int j = W();
    if ((j != 0) && (this.k != null) && (this.k.o()))
    {
      int i = 70;
      if ((j != 1) && (j == 2)) {
        i = 82;
      }
      localArrayList.add(QFileUtils.a(i, new TroopFileModel.10(this, j)));
    }
    String str = y();
    boolean bool = FileUtil.b(str);
    if ((FileManagerUtil.c(paramFileManagerEntity.fileName) == 0) && (bool)) {
      localArrayList.add(QFileUtils.a(39, null));
    }
    if (FileManagerUtil.i(paramFileManagerEntity)) {
      localArrayList.add(QFileUtils.a(6, FileOperaterUtils.b(this.k, paramFileManagerEntity)));
    }
    a(paramFileManagerEntity, localArrayList);
    if (f(paramFileManagerEntity))
    {
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = QFileUtils.a(119, FileOperaterUtils.a(paramFileManagerEntity, this.i));
      ReportController.b(this.a, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
      localArrayList.add(localActionSheetItem);
    }
    if (LinkUtils.a(paramFileManagerEntity, bool))
    {
      localArrayList.add(QFileUtils.a(122, FileOperaterUtils.a(this.i, paramFileManagerEntity, str)));
      localArrayList.add(QFileUtils.a(123, FileOperaterUtils.b(this.i, paramFileManagerEntity, str)));
    }
    paramFileManagerEntity = e(paramFileManagerEntity);
    if ((paramFileManagerEntity != null) && (paramFileManagerEntity.a != null) && (z() == 0) && ((FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.m)) || (bool))) {
      localArrayList.add(QFileUtils.a(52, null));
    }
    if ((bool) && (a(str)))
    {
      localArrayList.add(QFileUtils.a(132, null));
      ReportController.b(null, "dc00898", "", "", "0X800AFCC", "0X800AFCC", 0, 0, "", "", "", "");
    }
    return localArrayList;
  }
  
  protected void d()
  {
    if (this.z != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("fobserver<FileAssistant>", 1, "del troopMngObserver");
      }
      ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).removeObserver(this.z);
    }
    if (this.F != null) {
      TroopFileError.b(this.a, this.F);
    }
    this.z = null;
    this.F = null;
    this.D = null;
    this.E = null;
  }
  
  public IUploadController e()
  {
    if (this.p == null) {
      this.p = new TroopFileModel.5(this);
    }
    return this.p;
  }
  
  protected TroopFileStatusInfo e(FileManagerEntity paramFileManagerEntity)
  {
    return TroopFileUtils.a(this.a, paramFileManagerEntity);
  }
  
  public IDownloadController f()
  {
    if (this.o == null) {
      this.o = new TroopFileModel.6(this);
    }
    return this.o;
  }
  
  protected boolean f(FileManagerEntity paramFileManagerEntity)
  {
    long l = FileManagerUtil.v(paramFileManagerEntity.fileName);
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
      localObject1 = ((TencentDocImportFileInfoBean)localObject1).d();
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
  
  public void h()
  {
    FileManagerEntity localFileManagerEntity = this.c.r();
    TroopFileStatusInfo localTroopFileStatusInfo = e(localFileManagerEntity);
    if ((TextUtils.isEmpty(this.A)) && (localTroopFileStatusInfo.a != null)) {
      this.A = localTroopFileStatusInfo.a.toString();
    }
    boolean bool = FileManagerUtil.n(localTroopFileStatusInfo.k);
    TroopFileItemOperation localTroopFileItemOperation = new TroopFileItemOperation(localFileManagerEntity.TroopUin, this.a, this.i);
    if ((localTroopFileStatusInfo.e != 10) && (localTroopFileStatusInfo.e != 9))
    {
      if ((localTroopFileStatusInfo.e != 7) && ((bool) || (localTroopFileStatusInfo.e != 6)))
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
          localTroopFileItemOperation.a(localFileManagerEntity.strTroopFilePath, localTroopFileStatusInfo.t, localTroopFileStatusInfo.i, localTroopFileStatusInfo.u);
        }
        localFileManagerEntity.status = 2;
      }
    }
    else
    {
      if (localTroopFileStatusInfo.a != null)
      {
        localTroopFileItemOperation.b(localTroopFileStatusInfo.a);
        localFileManagerEntity.status = 2;
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileModel<FileAssistant>", 2, "TroopFileModel doStartDownload : resumeDownload error, infoId is null");
      }
    }
  }
  
  public void i()
  {
    FileManagerEntity localFileManagerEntity = this.c.r();
    super.i();
    if (w() == 4)
    {
      TroopFileStatusInfo localTroopFileStatusInfo = e(localFileManagerEntity);
      this.a.getFileManagerDataCenter().a(new TroopFilePreviewController(this.a, localFileManagerEntity.TroopUin, localTroopFileStatusInfo));
    }
  }
  
  public Intent k()
  {
    FileManagerEntity localFileManagerEntity = this.c.r();
    if (localFileManagerEntity == null) {
      return null;
    }
    return QFileUtils.a(this.a, localFileManagerEntity);
  }
  
  public String l()
  {
    return "biz_src_jc_file";
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] m()
  {
    int i = w();
    if ((i != 5) && (i != 4)) {
      return super.m();
    }
    Object localObject = this.c.r();
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
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] n()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FileManagerEntity localFileManagerEntity = this.c.r();
    String str = y();
    boolean bool = FileUtil.b(str);
    localArrayList1.add(QFileUtils.a(2, FileOperaterUtils.c(this.k, localFileManagerEntity)));
    localArrayList1.add(QFileUtils.a(26, null));
    if (!bool) {
      localArrayList1.add(QFileUtils.a(27, FileOperaterUtils.d(this.k, localFileManagerEntity)));
    } else {
      localArrayList1.add(QFileUtils.a(27, FileOperaterUtils.a(localFileManagerEntity.nSessionId, this.k, str)));
    }
    WXShareHelper localWXShareHelper = WXShareHelper.a();
    if ((bool) && (localWXShareHelper.b()) && (localWXShareHelper.g())) {
      localArrayList1.add(QFileUtils.a(9, FileOperaterUtils.b(this.i, str)));
    }
    if (ad()) {
      a(localArrayList1, bool);
    }
    if (bool) {
      localArrayList1.add(QFileUtils.a(64, new TroopFileModel.11(this)));
    }
    if (bool) {
      localArrayList2.add(QFileUtils.a(39, null));
    }
    if (FileManagerUtil.i(this.c.r())) {
      localArrayList1.add(QFileUtils.a(6, FileOperaterUtils.b(this.k, localFileManagerEntity)));
    }
    if (LinkUtils.a(localFileManagerEntity, bool))
    {
      localArrayList2.add(QFileUtils.a(122, FileOperaterUtils.a(this.i, localFileManagerEntity, str)));
      localArrayList2.add(QFileUtils.a(123, FileOperaterUtils.b(this.i, localFileManagerEntity, str)));
    }
    c(localArrayList2);
    if ((bool) && (a(str)))
    {
      localArrayList2.add(QFileUtils.a(132, null));
      ReportController.b(null, "dc00898", "", "", "0X800AFCC", "0X800AFCC", 0, 0, "", "", "", "");
    }
    return new ArrayList[] { localArrayList1, localArrayList2 };
  }
  
  public long r()
  {
    if (this.c != null) {
      return this.c.r().TroopUin;
    }
    return super.r();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel
 * JD-Core Version:    0.7.0.1
 */