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
  private String A = "";
  protected QQAppInterface a;
  protected List<IFileViewerAdapter> b;
  protected IFileViewerAdapter c;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  protected String h;
  private TeamWorkFileImportInfo z;
  
  public DefaultFileModel(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    super(paramActivity);
    this.a = paramQQAppInterface;
  }
  
  private void au()
  {
    int i = w();
    int j = B();
    Object localObject = this.c.r();
    if ((localObject != null) && (!TextUtils.isEmpty(((FileManagerEntity)localObject).WeiYunFileId)))
    {
      this.a.getFileManagerDataCenter().a(((IWeiyunApi)QRoute.api(IWeiyunApi.class)).getWeiYunFilePreviewController(this.a, this.c.j(), this.c.r().WeiYunDirKey));
    }
    else if (i == 2)
    {
      if (this.c.s() == null) {
        localObject = "";
      } else {
        localObject = this.c.s().b;
      }
      this.a.getFileManagerDataCenter().a(((IWeiyunApi)QRoute.api(IWeiyunApi.class)).getWeiYunFilePreviewController(this.a, this.c.j(), (String)localObject));
    }
    else if ((i != 1) && (i != 3))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserModelBase", 2, "loadZipFilesForOthers error. can not handle zip file");
      }
    }
    else if (j == 3000)
    {
      this.a.getFileManagerDataCenter().a(new DiscOfflinePreviewController(this.a, this.c.h(), this.c.i()));
    }
    else
    {
      this.a.getFileManagerDataCenter().a(new OfflinePreviewController(this.a, this.c.h(), this.c.j()));
    }
    if (this.l == null) {
      this.l = this.a.getFileManagerDataCenter().e();
    }
    if (this.m == null) {
      this.m = new DefaultFileModel.1(this, j);
    }
    if (this.l != null)
    {
      this.l.a(this.m);
      this.l.a();
    }
  }
  
  private QQAppInterface av()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void b(FileManagerEntity paramFileManagerEntity, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    int j = W();
    if ((j != 0) && (this.k != null) && (this.k.o()))
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
      localObject2 = ((TencentDocImportFileInfoBean)localObject2).d();
      boolean bool = ((TencentDocConvertConfigBean)localObject1).d();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = ".doc|.docx|.xls|.xlsx|";
      }
      long l = FileManagerUtil.v(paramFileManagerEntity.fileName);
      if ((bool) && (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsSupport(paramFileManagerEntity.getFilePath(), paramFileManagerEntity.fileName, (String)localObject1)) && (paramFileManagerEntity.fileSize <= l))
      {
        paramFileManagerEntity = QFileUtils.a(119, FileOperaterUtils.a(paramFileManagerEntity, this.i));
        ReportController.b(this.a, "dc00898", "", "", "0X8009062", "0X8009062", 0, 0, "", "", "", "");
        paramArrayList.add(paramFileManagerEntity);
      }
    }
  }
  
  private IFileViewerAdapter h()
  {
    if (this.j > this.b.size() - 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("index error, index[");
      localStringBuilder.append(this.j);
      localStringBuilder.append("], size[");
      localStringBuilder.append(this.b.size());
      localStringBuilder.append("]");
      QLog.e("FileBrowserModelBase", 1, localStringBuilder.toString());
      return (IFileViewerAdapter)this.b.get(0);
    }
    return (IFileViewerAdapter)this.b.get(this.j);
  }
  
  public String A()
  {
    FileManagerEntity localFileManagerEntity = this.c.r();
    if (localFileManagerEntity == null) {
      return "";
    }
    int i = FileManagerUtil.c(localFileManagerEntity.fileName);
    if (i == 0)
    {
      if (FileUtils.fileExistsAndNotEmpty(y())) {
        return y();
      }
    }
    else if ((i == 2) && (FileUtils.fileExistsAndNotEmpty(this.x))) {
      return this.x;
    }
    return super.A();
  }
  
  public int B()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.c;
    if (localIFileViewerAdapter != null) {
      return localIFileViewerAdapter.f();
    }
    return -1;
  }
  
  public long C()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.c;
    if (localIFileViewerAdapter != null) {
      return localIFileViewerAdapter.a();
    }
    return 0L;
  }
  
  public String D()
  {
    return FileUtil.a(x());
  }
  
  public String E()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.c;
    if (localIFileViewerAdapter != null) {
      return localIFileViewerAdapter.g();
    }
    return "";
  }
  
  public boolean F()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.c;
    if ((localIFileViewerAdapter != null) && (localIFileViewerAdapter.r() != null)) {
      return this.c.r().isFromProcessingForward2c2cOrDiscItem();
    }
    return false;
  }
  
  public boolean G()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.c;
    if ((localIFileViewerAdapter != null) && (localIFileViewerAdapter.r() != null)) {
      return FileManagerUtil.d(this.c.r());
    }
    return false;
  }
  
  public boolean H()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.c;
    if ((localIFileViewerAdapter != null) && (localIFileViewerAdapter.r() != null)) {
      return this.c.r().isZipInnerFile;
    }
    return false;
  }
  
  public String I()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.c;
    if (localIFileViewerAdapter != null) {
      return localIFileViewerAdapter.t();
    }
    return "";
  }
  
  public float J()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.c;
    if ((localIFileViewerAdapter != null) && (localIFileViewerAdapter.r() != null)) {
      return this.c.r().fProgress;
    }
    return 0.0F;
  }
  
  public boolean K()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.c;
    if ((localIFileViewerAdapter != null) && (localIFileViewerAdapter.r() != null)) {
      return this.c.r().isSend();
    }
    return false;
  }
  
  public int L()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.c;
    if (localIFileViewerAdapter != null) {
      return localIFileViewerAdapter.q();
    }
    return -1;
  }
  
  public void M()
  {
    String str;
    if (this.c.r().bSend) {
      str = this.a.getCurrentNickname();
    } else if (this.c.r().peerType == 3000) {
      str = ContactUtils.a(this.a, this.c.r().peerUin, this.c.r().selfUin);
    } else {
      str = this.c.r().peerNick;
    }
    Object localObject = new SimpleDateFormat("yyyy.MM.dd");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" 于");
    localStringBuilder.append(((SimpleDateFormat)localObject).format(new Date(this.c.r().srvTime)));
    localStringBuilder.append("上传");
    localObject = localStringBuilder.toString();
    if (this.n != null) {
      this.n.b(str, (String)localObject);
    }
    if (!NetworkUtil.isNetworkAvailable(this.i))
    {
      QQToast.makeText(this.i, 1, this.i.getString(2131889169), 1).show(ap());
      return;
    }
    au();
  }
  
  public boolean N()
  {
    int i = R();
    boolean bool2 = false;
    if ((i != 2) && (O() == 1)) {
      return false;
    }
    boolean bool1 = bool2;
    if (FileManagerUtil.b(this.a, this.c, true))
    {
      bool1 = bool2;
      if (FileManagerUtil.a(this.i, v(), x())) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public int O()
  {
    int i = L();
    if ((w() == 0) && (i != 10)) {
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
    if (!FileUtil.b(y()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileBrowserModelBase<FileAssistant>", 1, "file is send,but not has localfile,return download status!");
      }
      return 2;
    }
    label161:
    return 1;
  }
  
  public boolean P()
  {
    Object localObject = this.a;
    boolean bool2 = false;
    if (localObject == null) {
      return false;
    }
    int i = R();
    if ((i != 5) && (i != 2))
    {
      boolean bool1 = bool2;
      if (NetworkUtil.isNetSupportHw(BaseApplicationImpl.getContext()))
      {
        localObject = ((IQFileConfigManager)this.a.getRuntimeService(IQFileConfigManager.class, "")).getFileAutoDownloadConfig(HWTroopUtils.a(v()));
        long l = this.c.c();
        if ((!NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext())) || (l > ((DownloadFileConfig)localObject).a))
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
  
  public IThumbController Q()
  {
    if (this.r == null) {
      this.r = new DefaultFileModel.3(this);
    }
    return this.r;
  }
  
  public int R()
  {
    int i = b();
    String str = y();
    if ((i != 2) && (i != 14))
    {
      if (i == 16) {
        return 5;
      }
      if ((i != 0) && (i != 3))
      {
        if (FileUtil.b(str)) {
          return 2;
        }
        return 0;
      }
      return 6;
    }
    return 4;
  }
  
  public List<FileBrowserModelBase.ImageFileInfo> S()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(new DefaultImageInfo((IFileViewerAdapter)((Iterator)localObject).next()));
      }
    }
    return localArrayList;
  }
  
  public void T()
  {
    if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext()))
    {
      FMToastUtil.a(BaseApplicationImpl.getContext().getString(2131889577));
      return;
    }
    aj();
    i();
    if (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).supportTencentDocForPreview(y(), v(), x()))
    {
      if (U() == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileBrowserModelBase", 2, "previewBigFile getTeamWorkFileImportInfo() == null");
        }
        d(7);
      }
      ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).tryOpenWithTencentDoc(av(), this.i, "FileBrowserModelBase", U());
      ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(U(), null, "0X8009ECE");
      return;
    }
    Intent localIntent = new Intent(this.i, FilePreviewActivity.class);
    localIntent.putExtra("offline_file_type", 0);
    localIntent.putExtra("offline_file_name", v());
    localIntent.putExtra("offline_file_size", x());
    if (V())
    {
      localIntent.putExtra("offline_file_show_team_work_menu", true);
      localIntent.putExtra("key_team_work_file_import_info", this.z);
    }
    this.i.startActivity(localIntent);
    this.i.overridePendingTransition(2130772345, 2130772346);
  }
  
  public TeamWorkFileImportInfo U()
  {
    return this.z;
  }
  
  public boolean V()
  {
    Object localObject = this.c;
    if (localObject == null) {
      return false;
    }
    localObject = ((IFileViewerAdapter)localObject).r();
    this.z = new TeamWorkFileImportInfo();
    this.z.r = false;
    if (av() == null) {
      return false;
    }
    if ((localObject != null) && (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).supportTencentDocForEdit(y(), v(), x())))
    {
      if (!NetworkUtil.isNetSupport(BaseApplicationImpl.getContext())) {
        return false;
      }
      if ((TextUtils.isEmpty(((FileManagerEntity)localObject).Uuid)) && (TextUtils.isEmpty(((FileManagerEntity)localObject).strTroopFilePath)) && (TextUtils.isEmpty(((FileManagerEntity)localObject).getFilePath()))) {
        return false;
      }
      this.z.c = ((FileManagerEntity)localObject).fileName;
      this.z.K = ((FileManagerEntity)localObject).fileSize;
      this.z.d = ((FileManagerEntity)localObject).getFilePath();
      this.z.u = ((FileManagerEntity)localObject).nFileType;
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
      if (this.k != null) {
        this.z.o = this.k.g();
      }
      if (!TextUtils.isEmpty(((FileManagerEntity)localObject).peerUin))
      {
        this.z.a = ((FileManagerEntity)localObject).peerType;
        this.z.b = ((FileManagerEntity)localObject).peerUin;
        this.z.j = String.valueOf(((FileManagerEntity)localObject).TroopUin);
        this.z.h = ((FileManagerEntity)localObject).busId;
        this.z.g = ((FileManagerEntity)localObject).strTroopFilePath;
        this.z.e = ((FileManagerEntity)localObject).uniseq;
        if (((FileManagerEntity)localObject).status != 16) {
          this.z.m = true;
        }
      }
      return true;
    }
    return false;
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem> a(FileManagerEntity paramFileManagerEntity)
  {
    String str = y();
    boolean bool = FileUtil.b(str);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QFileUtils.a(2, FileOperaterUtils.a(this.k, paramFileManagerEntity, this.i)));
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
      localArrayList.add(QFileUtils.a(120, FileOperaterUtils.a(paramFileManagerEntity, this.i, true, new DefaultFileModel.4(this))));
      TenDocLogReportHelper.a(av(), "0X800A21C");
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
        localArrayList.add(QFileUtils.a(27, FileOperaterUtils.a(paramFileManagerEntity.nSessionId, this.k, str)));
      } else if (w() == 1) {
        localArrayList.add(QFileUtils.a(27, FileOperaterUtils.a(this.k, paramFileManagerEntity)));
      }
    }
    paramFileManagerEntity = WXShareHelper.a();
    if ((bool) && (paramFileManagerEntity.b()) && (paramFileManagerEntity.g())) {
      localArrayList.add(QFileUtils.a(9, FileOperaterUtils.b(this.i, str)));
    }
    if (ad()) {
      a(localArrayList, bool);
    }
    if (bool) {
      localArrayList.add(QFileUtils.a(64, FileOperaterUtils.a(this.i, str)));
    }
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    IFileViewerAdapter localIFileViewerAdapter = this.c;
    if (localIFileViewerAdapter != null) {
      localIFileViewerAdapter.r().status = paramInt;
    }
  }
  
  public void a(int paramInt, FileBrowserModelBase.ImageFileInfo paramImageFileInfo)
  {
    IFileViewerAdapter localIFileViewerAdapter = ((DefaultImageInfo)paramImageFileInfo).h();
    if (localIFileViewerAdapter == null)
    {
      FMToastUtil.b(BaseApplicationImpl.getContext().getString(2131889341));
      return;
    }
    if ((FileManagerUtil.d(localIFileViewerAdapter.r())) && (1 == localIFileViewerAdapter.m())) {
      FMToastUtil.b(BaseApplicationImpl.getContext().getString(2131889341));
    }
    if (localIFileViewerAdapter.l() == null)
    {
      localIFileViewerAdapter.a(1);
      paramImageFileInfo.a(1);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    paramString = this.c;
    if ((paramString != null) && (paramString.r() != null))
    {
      paramString = this.c.r();
      paramString.status = 16;
      paramString.mContext = "showed";
      this.a.getFileManagerDataCenter().c(paramString);
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
    this.q = paramOnTransEventListener;
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
    int i = paramActionSheetItem.action;
    f(i);
    if (i == 73)
    {
      FileOperaterUtils.a(this.k, (FileManagerEntity)localObject1, this.i).onClick(null);
      return;
    }
    if (i == 72)
    {
      i = paramActionSheetItem.uinType;
      paramActionSheetItem = paramActionSheetItem.uin;
      if (!TextUtils.isEmpty(paramActionSheetItem)) {
        QFileUtils.b(this.a, this.i, (FileManagerEntity)localObject1, true, paramActionSheetItem, i);
      }
    }
    else
    {
      if (i == 39)
      {
        if (!CheckPermission.isHasStoragePermission(this.i))
        {
          CheckPermission.requestSDCardPermission((AppActivity)this.i, new DefaultFileModel.6(this));
          return;
        }
        FileManagerUtil.a(this.i, y());
        return;
      }
      if (i == 52)
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
        if (FileUtils.fileExistsAndNotEmpty(paramActionSheetItem)) {
          ((IOCR)QRoute.api(IOCR.class)).startOcrPerformFragment(this.i, paramActionSheetItem, 1, -1004, null);
        }
      }
      else if (i == 55)
      {
        localObject1 = A();
        if (FileUtils.fileExistsAndNotEmpty((String)localObject1))
        {
          QFileUtils.a(this.i, (String)localObject1, paramActionSheetItem.argus, null, 1);
          ReportController.b(null, "dc00898", "", "", "0X800AD47", "0X800AD47", QFileBrowserUtils.a(this.t), 0, "", "", "", "");
        }
      }
      else if (i == 56)
      {
        localObject1 = A();
        if (FileUtils.fileExistsAndNotEmpty((String)localObject1))
        {
          QFileUtils.a(this.i, (String)localObject1, paramActionSheetItem.argus, null, 2);
          ReportController.b(null, "dc00898", "", "", "0X800AD48", "0X800AD48", QFileBrowserUtils.a(this.t), 0, "", "", "", "");
        }
      }
      else
      {
        if (i == 132)
        {
          QbSdk.clearDefaultBrowser(this.i, y());
          FileManagerUtil.a(this.i, y());
          ReportController.b(null, "dc00898", "", "", "0X800AFCB", "0X800AFCB", 0, 0, "", "", "", "");
          return;
        }
        if (i == 26)
        {
          ReportController.b(null, "dc00898", "", "", "0X800A60E", "0X800A60E", 0, 0, "", "", "", "");
          DatalineDeviceChooseModel.a((FileManagerEntity)localObject1).a(this.i, this.a, new DefaultFileModel.7(this, (FileManagerEntity)localObject1));
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
    ((StringBuilder)localObject).append(URLUtil.c(paramString4));
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
        ((StringBuilder)localObject).append(URLUtil.c(paramString4));
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
    paramString2.putString("version", DeviceInfoUtil.e());
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
    paramString3.put("CONTEXT", this.a.getApp().getApplicationContext());
    paramString1.a(paramString3);
  }
  
  protected void a(List<IFileViewerAdapter> paramList, int paramInt)
  {
    this.b = paramList;
    this.j = paramInt;
    this.c = h();
  }
  
  public void a(boolean paramBoolean)
  {
    IFileViewerAdapter localIFileViewerAdapter = this.c;
    if ((localIFileViewerAdapter != null) && (localIFileViewerAdapter.r() != null)) {
      this.c.r().bCannotPlay = true;
    }
  }
  
  protected void a(boolean paramBoolean, IFModel paramIFModel, long paramLong, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    paramIFModel.a(paramBoolean, this.i, paramFMDialogInterface);
  }
  
  protected boolean a(String paramString)
  {
    return QbSdk.isInDefaultBrowser(this.i, paramString);
  }
  
  protected boolean ad()
  {
    return false;
  }
  
  public void ae()
  {
    super.ae();
    c();
  }
  
  public void af()
  {
    if (this.l != null)
    {
      this.l.b();
      this.l = null;
    }
  }
  
  public String ag()
  {
    QQAppInterface localQQAppInterface = this.a;
    if (localQQAppInterface != null) {
      return localQQAppInterface.getCurrentAccountUin();
    }
    return super.ag();
  }
  
  public String ah()
  {
    StringBuilder localStringBuilder;
    if (a() == 2)
    {
      if ((TextUtils.isEmpty(this.A)) && (this.c != null))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.c.a());
        localStringBuilder.append("_");
        localStringBuilder.append(System.currentTimeMillis());
        this.A = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getContextId: default video file random contextId: ");
        localStringBuilder.append(this.A);
        QLog.i("FileBrowserModelBase", 1, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty(this.A)) {
        return this.A;
      }
    }
    if (this.c != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c.a());
      localStringBuilder.append("");
      return localStringBuilder.toString();
    }
    return super.ah();
  }
  
  protected boolean ai()
  {
    DataLineHandler localDataLineHandler = (DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    String str = v();
    return localDataLineHandler.h.c(str);
  }
  
  public void aj()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.c;
    if (localIFileViewerAdapter != null)
    {
      localIFileViewerAdapter.a(true);
      this.c.b(false);
    }
  }
  
  public int ak()
  {
    FileManagerEntity localFileManagerEntity = this.c.r();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.apkSafeLevel;
    }
    return 0;
  }
  
  public String al()
  {
    FileManagerEntity localFileManagerEntity = this.c.r();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.apkSafeMsg;
    }
    return "";
  }
  
  public String am()
  {
    FileManagerEntity localFileManagerEntity = this.c.r();
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.apkSafeDetailUrl;
    }
    return "";
  }
  
  public int b()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.c;
    if (localIFileViewerAdapter != null) {
      return localIFileViewerAdapter.n();
    }
    return -1;
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem> b(FileManagerEntity paramFileManagerEntity)
  {
    String str = y();
    boolean bool = FileUtil.b(str);
    ArrayList localArrayList = new ArrayList();
    b(paramFileManagerEntity, localArrayList);
    if ((paramFileManagerEntity != null) && (FileManagerUtil.c(paramFileManagerEntity.fileName) == 0) && (bool)) {
      localArrayList.add(QFileUtils.a(39, null));
    }
    if (FileManagerUtil.i(paramFileManagerEntity)) {
      localArrayList.add(QFileUtils.a(6, FileOperaterUtils.b(this.k, paramFileManagerEntity)));
    }
    a(paramFileManagerEntity, localArrayList);
    if (paramFileManagerEntity != null) {
      c(paramFileManagerEntity, localArrayList);
    }
    if (LinkUtils.a(paramFileManagerEntity, bool))
    {
      localArrayList.add(QFileUtils.a(122, FileOperaterUtils.a(this.i, paramFileManagerEntity, str)));
      localArrayList.add(QFileUtils.a(123, FileOperaterUtils.b(this.i, paramFileManagerEntity, str)));
    }
    if ((((IOCRService)this.a.getRuntimeService(IOCRService.class, "")).isSupportOcr(this.a.getCurrentAccountUin(), 1)) && (z() == 0) && (paramFileManagerEntity != null) && ((FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.strLargeThumPath)) || (FileUtils.fileExistsAndNotEmpty(str)))) {
      localArrayList.add(QFileUtils.a(52, null));
    }
    if (z() == 0) {
      b(localArrayList);
    }
    if (bool)
    {
      if (ai())
      {
        long l = 0L;
        if (paramFileManagerEntity != null) {
          l = paramFileManagerEntity.nSessionId;
        }
        localArrayList.add(QFileUtils.a(121, FileOperaterUtils.b(l, this.k, y())));
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
  
  public void c(int paramInt)
  {
    if (paramInt == this.j) {
      return;
    }
    this.j = paramInt;
    this.c = h();
    FileManagerEntity localFileManagerEntity = this.c.r();
    if ((localFileManagerEntity != null) && (localFileManagerEntity.isZipInnerFile) && (FileUtil.b(localFileManagerEntity.getFilePath()))) {
      localFileManagerEntity.status = 1;
    }
  }
  
  public void d(int paramInt)
  {
    if (this.c == null) {
      return;
    }
    boolean bool;
    if ((this.k != null) && (this.k.g())) {
      bool = true;
    } else {
      bool = false;
    }
    this.z = ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).generateTencentDocImportInfo(this.c.r(), bool);
    this.z.n = paramInt;
  }
  
  public void g()
  {
    super.g();
    if (this.l != null)
    {
      this.l.b();
      this.l = null;
    }
  }
  
  public void i()
  {
    FileManagerEntity localFileManagerEntity = this.c.r();
    if (w() == 2)
    {
      String str;
      if (this.c.r() == null)
      {
        if (this.c.s() == null) {
          str = "";
        } else {
          str = this.c.s().b;
        }
      }
      else {
        str = this.c.r().WeiYunDirKey;
      }
      this.a.getFileManagerDataCenter().a(((IWeiyunApi)QRoute.api(IWeiyunApi.class)).getWeiYunFilePreviewController(this.a, localFileManagerEntity.WeiYunFileId, str));
    }
  }
  
  public Intent k()
  {
    FileManagerEntity localFileManagerEntity = this.c.r();
    if (localFileManagerEntity == null) {
      return null;
    }
    return QFileUtils.b(this.a, this.i, localFileManagerEntity);
  }
  
  public String l()
  {
    return "biz_src_jc_file";
  }
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] m()
  {
    Object localObject3 = this.c.r();
    Object localObject4 = y();
    boolean bool = FileUtil.b((String)localObject4);
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
    ar();
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
  
  public ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] n()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FileManagerEntity localFileManagerEntity = this.c.r();
    String str = y();
    boolean bool = FileUtil.b(str);
    localArrayList1.add(QFileUtils.a(2, FileOperaterUtils.a(this.k, localFileManagerEntity, this.i)));
    localArrayList1.add(QFileUtils.a(26, null));
    if (!bool) {
      localArrayList1.add(QFileUtils.a(27, FileOperaterUtils.a(this.k, localFileManagerEntity)));
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
      localArrayList1.add(QFileUtils.a(64, new DefaultFileModel.5(this)));
    }
    if (bool) {
      localArrayList2.add(QFileUtils.a(39, null));
    }
    if (FileManagerUtil.i(this.c.r())) {
      localArrayList2.add(QFileUtils.a(6, FileOperaterUtils.b(this.k, localFileManagerEntity)));
    }
    a(localFileManagerEntity, localArrayList2);
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
  
  protected void o()
  {
    boolean bool = this.i instanceof FileBrowserActivity;
    Object localObject2 = null;
    Object localObject1;
    if (bool) {
      localObject1 = (IFileBrowser)this.i;
    } else {
      localObject1 = null;
    }
    FileManagerEntity localFileManagerEntity = this.c.r();
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
          if ((localObject1 != null) && (((IFileBrowser)localObject1).g()))
          {
            localObject1 = "0X8004BB9";
            break label173;
          }
          localObject1 = "0X8004BCF";
          break label173;
        }
      }
      if ((localObject1 != null) && (((IFileBrowser)localObject1).g()))
      {
        localObject1 = "0X8004BB7";
        break label173;
      }
      localObject1 = "0X8004BCD";
      break label173;
    }
    label149:
    if ((localObject1 != null) && (((IFileBrowser)localObject1).g())) {
      localObject1 = "0X8004BB8";
    } else {
      localObject1 = "0X8004BCE";
    }
    label173:
    if (localObject1 != null) {
      FileManagerReporter.a((String)localObject1);
    }
  }
  
  public void p()
  {
    FileManagerEntity localFileManagerEntity = this.c.r();
    if (localFileManagerEntity != null)
    {
      FileViewerFacade.a(this.a, this.i, localFileManagerEntity, null);
      return;
    }
    try
    {
      localFileManagerEntity = FileManagerUtil.a(new FileInfo(y()));
      FileViewerFacade.a(this.a, this.i, localFileManagerEntity, null);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
  }
  
  public boolean q()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.c;
    if (localIFileViewerAdapter != null) {
      return localIFileViewerAdapter.u();
    }
    return false;
  }
  
  public long r()
  {
    return 0L;
  }
  
  public boolean t()
  {
    return this.c == null;
  }
  
  public String u()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.c;
    if (localIFileViewerAdapter != null) {
      return localIFileViewerAdapter.i();
    }
    return "";
  }
  
  public String v()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.c;
    if (localIFileViewerAdapter != null) {
      return localIFileViewerAdapter.b();
    }
    return "";
  }
  
  public int w()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.c;
    if (localIFileViewerAdapter != null) {
      return localIFileViewerAdapter.m();
    }
    return -1;
  }
  
  public long x()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.c;
    if (localIFileViewerAdapter != null) {
      return localIFileViewerAdapter.c();
    }
    return 0L;
  }
  
  public String y()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.c;
    if (localIFileViewerAdapter != null) {
      return localIFileViewerAdapter.o();
    }
    return "";
  }
  
  public int z()
  {
    IFileViewerAdapter localIFileViewerAdapter = this.c;
    if (localIFileViewerAdapter != null) {
      return localIFileViewerAdapter.d();
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.DefaultFileModel
 * JD-Core Version:    0.7.0.1
 */