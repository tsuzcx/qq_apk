package com.tencent.mobileqq.filemanager.bubble;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoProcessor;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.IFileBrowserParam;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.aioitem.OfflineFileBubbleDownloadHandler;
import com.tencent.mobileqq.filemanager.aioitem.OfflineFileBubblePauseHandler;
import com.tencent.mobileqq.filemanager.aioitem.QFileBubbleDownloadHandler;
import com.tencent.mobileqq.filemanager.aioitem.QFileBubblePauseHandler;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.fileviewer.open.CommonFileBrowserParams;
import com.tencent.mobileqq.filemanager.fileviewer.open.FileBrowserCreator;
import com.tencent.mobileqq.filemanager.fileviewer.open.IFileBrowserParams;
import com.tencent.mobileqq.filemanager.openbrowser.FileBrowserParam;
import com.tencent.mobileqq.filemanager.openbrowser.FileModelAdapter;
import com.tencent.mobileqq.filemanager.recreate.FileModel;
import com.tencent.mobileqq.filemanager.recreate.IFModel;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper.AIOImgInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.TestStructMsg;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qqfav.QfavBuilder;
import java.util.ArrayList;
import java.util.List;

public class OfflineFileBubbleModel
  extends QFileBubbleModel
{
  public static boolean a = false;
  private MessageForFile f;
  private FileManagerEntity g;
  private boolean h = true;
  private boolean i;
  
  public OfflineFileBubbleModel(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
  }
  
  private void A()
  {
    if ((this.f.isMultiMsg) && (!FileManagerUtil.a(this.f, this.b, this.c))) {
      return;
    }
    Object localObject1 = FileManagerUtil.a(this.b, this.f);
    if (!QFileUtils.a((FileManagerEntity)localObject1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OfflineFileBubbleModel", 1, "onItemClick: file is forwarding or forward failed, can not open file browser.");
      }
      return;
    }
    Object localObject2 = new FileManagerReporter.FileAssistantReportData();
    ((FileManagerReporter.FileAssistantReportData)localObject2).b = "file_viewer_in";
    ((FileManagerReporter.FileAssistantReportData)localObject2).c = 9;
    ((FileManagerReporter.FileAssistantReportData)localObject2).d = FileUtil.a(((FileManagerEntity)localObject1).fileName);
    ((FileManagerReporter.FileAssistantReportData)localObject2).f = FileManagerUtil.b(((FileManagerEntity)localObject1).getCloudType(), ((FileManagerEntity)localObject1).peerType);
    FileManagerReporter.a(this.b.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject2);
    FileManagerReporter.a("0X8004AE3");
    if ((((FileManagerEntity)localObject1).TroopUin != 0L) && (!TextUtils.isEmpty(((FileManagerEntity)localObject1).strTroopFileID)) && (!TextUtils.isEmpty(((FileManagerEntity)localObject1).strTroopFilePath)))
    {
      localObject2 = new ForwardFileInfo();
      ((ForwardFileInfo)localObject2).b(((FileManagerEntity)localObject1).nSessionId);
      ((ForwardFileInfo)localObject2).d(4);
      ((ForwardFileInfo)localObject2).b(10006);
      ((ForwardFileInfo)localObject2).a(((FileManagerEntity)localObject1).getFilePath());
      ((ForwardFileInfo)localObject2).d(((FileManagerEntity)localObject1).fileName);
      ((ForwardFileInfo)localObject2).d(((FileManagerEntity)localObject1).fileSize);
      ((ForwardFileInfo)localObject2).a(((FileManagerEntity)localObject1).TroopUin);
      localObject1 = (Activity)this.c;
      Intent localIntent = new Intent((Context)localObject1, TroopFileDetailBrowserActivity.class);
      localIntent.putExtra("fileinfo", (Parcelable)localObject2);
      localIntent.putExtra("removemementity", true);
      localIntent.putExtra("forward_from_troop_file", true);
      localIntent.putExtra("not_forward", true);
      ((Activity)localObject1).startActivityForResult(localIntent, 102);
      return;
    }
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("file_browser_extra_params_uin", this.d.b);
    int j = 0;
    if (((FileManagerEntity)localObject1).peerType == 0) {
      j = 1;
    } else if (((FileManagerEntity)localObject1).peerType == 3000) {
      j = 5;
    }
    int k = QFileUtils.a(this.c, this.f.isMultiMsg, (Bundle)localObject2, j);
    if ((((FileManagerEntity)localObject1).nFileType != 0) && (((FileManagerEntity)localObject1).nFileType != 2))
    {
      localObject1 = new FileModelAdapter(this.b, (FileManagerEntity)localObject1);
      ((IFileBrowserModel)localObject1).a((Bundle)localObject2);
      localObject2 = new FileBrowserParam().a(j);
      if ((k != 1) && ((k != 3) || (j != 1)))
      {
        ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).browserFile(this.c, (IFileBrowserModel)localObject1, (IFileBrowserParam)localObject2);
        return;
      }
      ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).browserFile((Activity)this.c, 38, (IFileBrowserModel)localObject1, (IFileBrowserParam)localObject2);
      return;
    }
    localObject1 = new CommonFileBrowserParams(this.b, this.c, (FileManagerEntity)localObject1, 10004);
    ((CommonFileBrowserParams)localObject1).a((Bundle)localObject2);
    localObject1 = new FileBrowserCreator(this.c, (IFileBrowserParams)localObject1);
    ((FileBrowserCreator)localObject1).a(j);
    QFileUtils.a(j, k, (FileBrowserCreator)localObject1);
  }
  
  private void B()
  {
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.b, this.f);
    if (localFileManagerEntity == null)
    {
      QLog.e("OfflineFileBubbleModel", 1, "fetchVideoFileThumb. can not find a FileManagerEntity");
      return;
    }
    if ((FileUtil.b(localFileManagerEntity.getFilePath())) && (FileManagerUtil.f(localFileManagerEntity)))
    {
      ThreadManager.executeOnSubThread(new OfflineFileBubbleModel.3(this, localFileManagerEntity));
      return;
    }
    if (this.g.peerType == 3000)
    {
      this.b.getFileManagerEngine().c(localFileManagerEntity);
      return;
    }
    this.b.getFileManagerEngine().b(localFileManagerEntity);
  }
  
  private void C()
  {
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.b, this.f);
    if (localFileManagerEntity == null)
    {
      QLog.e("OfflineFileBubbleModel", 1, "fetchImageFileThumb. can not find a FileManagerEntity");
      return;
    }
    if (FileUtil.b(localFileManagerEntity.getFilePath()))
    {
      ThreadManager.executeOnSubThread(new OfflineFileBubbleModel.4(this, localFileManagerEntity));
      return;
    }
    if (FilePicURLDrawlableHelper.i(localFileManagerEntity))
    {
      this.b.getFileManagerEngine().a(localFileManagerEntity, 7);
      return;
    }
    this.b.getFileManagerEngine().a(localFileManagerEntity, 5);
  }
  
  private void a(View paramView)
  {
    if ((this.f.isMultiMsg) && (!FileManagerUtil.a(this.f, this.b, this.c))) {
      return;
    }
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.b, this.f);
    if (localFileManagerEntity == null)
    {
      QLog.e("OfflineFileBubbleModel", 1, "get Entity by Msg faild!");
      return;
    }
    if (localFileManagerEntity.status == 16) {
      return;
    }
    if (!QFileUtils.a(localFileManagerEntity))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OfflineFileBubbleModel", 1, "onItemClick: file is forwarding or forward failed, can not open file browser.");
      }
      return;
    }
    if ((localFileManagerEntity.sendCloudUnsuccessful()) && (!FileUtil.b(localFileManagerEntity.getFilePath())))
    {
      FMToastUtil.a(HardCodeUtil.a(2131902587));
      return;
    }
    Object localObject = new FileManagerReporter.FileAssistantReportData();
    ((FileManagerReporter.FileAssistantReportData)localObject).b = "file_viewer_in";
    ((FileManagerReporter.FileAssistantReportData)localObject).c = 9;
    ((FileManagerReporter.FileAssistantReportData)localObject).d = FileUtil.a(localFileManagerEntity.fileName);
    ((FileManagerReporter.FileAssistantReportData)localObject).f = FileManagerUtil.b(localFileManagerEntity.getCloudType(), localFileManagerEntity.peerType);
    FileManagerReporter.a(this.b.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject);
    FileManagerReporter.a("0X8004AE3");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handle item click: file peerType[");
    ((StringBuilder)localObject).append(localFileManagerEntity.peerType);
    ((StringBuilder)localObject).append("]");
    QLog.i("OfflineFileBubbleModel", 1, ((StringBuilder)localObject).toString());
    if (localFileManagerEntity.peerType == 0) {}
    while (localFileManagerEntity.peerType != 3000)
    {
      j = 1;
      break;
    }
    int j = 5;
    paramView = AnimationUtils.a(paramView);
    QFileUtils.a(this.b, this.c, this.d, this.f, paramView, j, 10004, localFileManagerEntity, false, false);
  }
  
  private void a(FileManagerEntity paramFileManagerEntity)
  {
    ReportController.b(this.b, "CliOper", "", "", "0X800644C", "0X800644C", 0, 0, "6", "", "", "");
    if (FileModel.a(this.f).a(false))
    {
      if (FreeWifiHelper.a((Activity)this.c, 5, new OfflineFileBubbleModel.5(this))) {
        FMDialogUtil.a(this.c, 2131889584, 2131889587, new OfflineFileBubbleModel.6(this));
      }
    }
    else {
      FileManagerUtil.a(this.b, this.f, this.c);
    }
  }
  
  private void a(FileManagerEntity paramFileManagerEntity, ArrayList<Integer> paramArrayList)
  {
    if (!QFileBubbleUtils.a(paramFileManagerEntity)) {
      return;
    }
    if ((paramFileManagerEntity.getCloudType() != 0) && (!f(paramFileManagerEntity)) && (AIOUtils.a(5) == 1)) {
      paramArrayList.add(Integer.valueOf(19));
    }
  }
  
  private void b(View paramView)
  {
    if ((this.f.isMultiMsg) && (!FileManagerUtil.a(this.f, this.b, this.c))) {
      return;
    }
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.b, this.f);
    if ((localFileManagerEntity.status == 16) && (!FileManagerUtil.m(localFileManagerEntity))) {
      return;
    }
    paramView = AnimationUtils.a(paramView);
    QFileUtils.a(this.c, paramView, this.f, this.d, false, false);
  }
  
  private void b(FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity = FileManagerUtil.a(this.b, this.f);
    ReportController.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 3, 0, "", "", "", "");
    int j;
    if (paramFileManagerEntity.peerType == 0)
    {
      j = 1;
    }
    else if (paramFileManagerEntity.peerType == 3000)
    {
      j = 5;
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("entranceType is unknow ,peerType:");
      localStringBuilder.append(paramFileManagerEntity.peerType);
      QLog.w("OfflineFileBubbleModel", 1, localStringBuilder.toString());
      j = 0;
    }
    QFileUtils.a(this.b, this.c, this.d, this.f, null, j, 10004, paramFileManagerEntity, true, false);
  }
  
  private void b(FileManagerEntity paramFileManagerEntity, ArrayList<Integer> paramArrayList)
  {
    if (!QFileBubbleUtils.a(paramFileManagerEntity)) {
      return;
    }
    if ((paramFileManagerEntity.getCloudType() != 0) && (!f(paramFileManagerEntity)) && (!paramFileManagerEntity.sendCloudUnsuccessful())) {
      paramArrayList.add(Integer.valueOf(9));
    }
  }
  
  private void c(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject1 = new FileManagerReporter.FileAssistantReportData();
    ((FileManagerReporter.FileAssistantReportData)localObject1).b = "file_forward";
    ((FileManagerReporter.FileAssistantReportData)localObject1).c = 9;
    ((FileManagerReporter.FileAssistantReportData)localObject1).e = paramFileManagerEntity.fileSize;
    ((FileManagerReporter.FileAssistantReportData)localObject1).d = FileUtil.a(paramFileManagerEntity.fileName);
    ((FileManagerReporter.FileAssistantReportData)localObject1).f = FileManagerUtil.b(paramFileManagerEntity.getCloudType(), paramFileManagerEntity.peerType);
    FileManagerReporter.a(this.b.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject1);
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("forward_type", 0);
    ((Bundle)localObject2).putBoolean("not_forward", true);
    ((Bundle)localObject2).putParcelable("fileinfo", ForwardFileOption.a(paramFileManagerEntity, this.f));
    ((Bundle)localObject2).putInt("forward_source_uin_type", this.d.a);
    localObject1 = new Intent();
    ((Intent)localObject1).putExtras((Bundle)localObject2);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131902524));
    ((StringBuilder)localObject2).append(FileManagerUtil.j(paramFileManagerEntity.fileName));
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131902525));
    ((StringBuilder)localObject2).append(FileUtil.a(paramFileManagerEntity.fileSize));
    ((StringBuilder)localObject2).append("。");
    ((Intent)localObject1).putExtra("forward_text", ((StringBuilder)localObject2).toString());
    ((Intent)localObject1).putExtra("direct_send_if_dataline_forward", true);
    ((Intent)localObject1).putExtra("forward _key_nojump", true);
    ((Intent)localObject1).putExtra("forward_source_uin_type", this.d.a);
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      QQToast.makeText(this.c, 2131892157, 1).show(this.c.getResources().getDimensionPixelSize(2131299920));
    } else {
      ForwardBaseOption.a((Activity)this.c, (Intent)localObject1, 21);
    }
    ReportController.b(this.b, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "6", "", "", "");
    if (this.f.isMultiMsg) {
      ReportController.b(this.b, "dc00898", "", "", "0X8009D66", "0X8009D66", 8, 0, "8", "", "", "");
    }
  }
  
  private void c(FileManagerEntity paramFileManagerEntity, ArrayList<Integer> paramArrayList)
  {
    if (!QFileBubbleUtils.a(paramFileManagerEntity)) {
      return;
    }
    if (this.h)
    {
      this.i = TencentDocConvertConfigProcessor.a().c();
      this.h = false;
    }
    String str = TencentDocImportFileInfoProcessor.a().d();
    long l = FileManagerUtil.v(paramFileManagerEntity.fileName);
    if ((this.i) && (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsSupport(paramFileManagerEntity.getFilePath(), paramFileManagerEntity.fileName, str)))
    {
      int k = paramFileManagerEntity.status;
      int j = 1;
      if ((k == 16) && ((TextUtils.isEmpty(paramFileManagerEntity.getFilePath())) || (!new VFSFile(paramFileManagerEntity.getFilePath()).exists()))) {
        j = 0;
      }
      if ((j != 0) && (paramFileManagerEntity.fileSize <= l))
      {
        paramArrayList.add(Integer.valueOf(23));
        ReportController.b(this.b, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void d(FileManagerEntity paramFileManagerEntity)
  {
    try
    {
      paramFileManagerEntity = TestStructMsg.a(TestStructMsg.b(paramFileManagerEntity.getFilePath()));
      if (paramFileManagerEntity == null) {
        break label73;
      }
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.b = this.f.frienduin;
      localSessionInfo.a = this.f.istroop;
      ChatActivityFacade.a(this.b, localSessionInfo, paramFileManagerEntity);
      return;
    }
    catch (Exception paramFileManagerEntity)
    {
      label55:
      label73:
      break label55;
    }
    QQToast.makeText(this.c, HardCodeUtil.a(2131902522), 1).show();
  }
  
  private void d(FileManagerEntity paramFileManagerEntity, ArrayList<Integer> paramArrayList)
  {
    if ((16 != paramFileManagerEntity.status) && (paramFileManagerEntity.getCloudType() != 0) && (!f(paramFileManagerEntity))) {
      paramArrayList.add(Integer.valueOf(25));
    }
  }
  
  private void e(FileManagerEntity paramFileManagerEntity) {}
  
  private boolean f(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramFileManagerEntity != null) {
      if (paramFileManagerEntity.nOpType != 24)
      {
        bool1 = bool2;
        if (paramFileManagerEntity.nOpType != 25) {}
      }
      else if (paramFileManagerEntity.status != 2)
      {
        bool1 = bool2;
        if (paramFileManagerEntity.status != 0) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private List<Integer> x()
  {
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.b, this.f);
    ArrayList localArrayList = new ArrayList();
    if (localFileManagerEntity == null) {
      return localArrayList;
    }
    a(localFileManagerEntity, localArrayList);
    b(localFileManagerEntity, localArrayList);
    c(localFileManagerEntity, localArrayList);
    if (QFileBubbleUtils.a(localFileManagerEntity))
    {
      localArrayList.add(Integer.valueOf(10));
      localArrayList.add(Integer.valueOf(12));
    }
    if (localFileManagerEntity.status == 1) {
      localArrayList.add(Integer.valueOf(15));
    }
    if (QFileBubbleUtils.a(localFileManagerEntity, this.f.frienduin)) {
      localArrayList.add(Integer.valueOf(21));
    }
    localArrayList.add(Integer.valueOf(16));
    localArrayList.add(Integer.valueOf(17));
    localArrayList.add(Integer.valueOf(20));
    if ((localFileManagerEntity.getCloudType() != 0) && (!f(localFileManagerEntity)) && (!localFileManagerEntity.sendCloudUnsuccessful())) {
      localArrayList.add(Integer.valueOf(22));
    }
    d(localFileManagerEntity, localArrayList);
    return localArrayList;
  }
  
  private List<Integer> y()
  {
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.b, this.f);
    ArrayList localArrayList = new ArrayList();
    if (localFileManagerEntity == null) {
      return localArrayList;
    }
    if ((this.f.isSendFromLocal()) && (localFileManagerEntity.status == 2))
    {
      localArrayList.add(Integer.valueOf(6));
    }
    else
    {
      if (QFileBubbleUtils.a(localFileManagerEntity))
      {
        localArrayList.add(Integer.valueOf(10));
        localArrayList.add(Integer.valueOf(9));
        localArrayList.add(Integer.valueOf(12));
        localArrayList.add(Integer.valueOf(19));
      }
      if (localFileManagerEntity.status == 1) {
        localArrayList.add(Integer.valueOf(15));
      }
    }
    localArrayList.add(Integer.valueOf(17));
    localArrayList.add(Integer.valueOf(16));
    localArrayList.add(Integer.valueOf(20));
    return localArrayList;
  }
  
  private List<Integer> z()
  {
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.b, this.f);
    ArrayList localArrayList = new ArrayList();
    if (localFileManagerEntity == null) {
      return localArrayList;
    }
    if (QFileBubbleUtils.a(localFileManagerEntity)) {
      localArrayList.add(Integer.valueOf(13));
    }
    if ((this.f.isSendFromLocal()) && (localFileManagerEntity.status == 2))
    {
      localArrayList.add(Integer.valueOf(6));
    }
    else
    {
      if (QFileBubbleUtils.a(localFileManagerEntity))
      {
        localArrayList.add(Integer.valueOf(9));
        localArrayList.add(Integer.valueOf(10));
        localArrayList.add(Integer.valueOf(19));
        localArrayList.add(Integer.valueOf(12));
      }
      if (localFileManagerEntity.status == 1) {
        localArrayList.add(Integer.valueOf(15));
      }
    }
    localArrayList.add(Integer.valueOf(16));
    localArrayList.add(Integer.valueOf(17));
    localArrayList.add(Integer.valueOf(20));
    return localArrayList;
  }
  
  public void a(int paramInt)
  {
    if (this.f != null)
    {
      if (this.g == null) {
        return;
      }
      FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.b, this.f);
      switch (paramInt)
      {
      default: 
      case 2131449130: 
        e(localFileManagerEntity);
        return;
      case 2131446941: 
        TeamWorkConvertUtils.a(localFileManagerEntity, this.c, this.b, 1);
        ReportController.b(this.b, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
        if (this.f.isMultiMsg)
        {
          ReportController.b(this.b, "dc00898", "", "", "0X8009D69", "0X8009D69", 0, 0, "", "", "", "");
          return;
        }
        break;
      case 2131445607: 
        d(localFileManagerEntity);
        return;
      case 2131445242: 
        a(localFileManagerEntity);
        return;
      case 2131439081: 
        b(localFileManagerEntity);
        return;
      case 2131438943: 
        long l1 = MessageCache.c();
        long l2 = this.f.time;
        if ((this.f.msgtype == -2005) && (this.f.istroop == 3000) && (l1 - l2 > 604800L))
        {
          FMToastUtil.a(HardCodeUtil.a(2131902526));
          ReportController.b(this.b, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "6", "", "", "");
          return;
        }
        FileManagerReporter.a("0X8005E4B");
        return;
      case 2131433664: 
        ReportController.b(null, "dc00898", "", "", "0X800A60C", "0X800A60C", 0, 0, "", "", "", "");
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          QQToast.makeText(this.c, 2131892157, 1).show(this.c.getResources().getDimensionPixelSize(2131299920));
          return;
        }
        FileManagerUtil.b(this.b, this.f, this.c);
        return;
      case 2131433636: 
        c(localFileManagerEntity);
        return;
      case 2131432813: 
        new QfavBuilder(3).a(this.b, (Activity)this.c, localFileManagerEntity, this.f, false);
        if (this.f.isMultiMsg)
        {
          ReportController.b(this.b, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
          return;
        }
        break;
      case 2131431695: 
        ChatActivityFacade.b(this.c, this.b, this.f);
        this.b.getFileManagerDataCenter().e(localFileManagerEntity);
        if (FileManagerUtil.c(this.g.fileName) == 0)
        {
          ReportController.b(this.b, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "6", "", "", "");
          return;
        }
        break;
      case 2131430893: 
        ((IApolloUtil)QRoute.api(IApolloUtil.class)).replaceCmshow3dResource(localFileManagerEntity.getFilePath());
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.f != null) && (this.g == null)) {}
  }
  
  public void a(int paramInt, View paramView)
  {
    if (this.f == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.b, this.f);
    if (localFileManagerEntity == null)
    {
      QLog.e("OfflineFileBubbleModel", 1, "get Entity by Msg faild!");
      return;
    }
    int j;
    switch (FileManagerUtil.c(localFileManagerEntity.fileName))
    {
    default: 
      j = 11;
      break;
    case 10: 
      j = 10;
      break;
    case 9: 
      j = 9;
      break;
    case 8: 
      j = 8;
      break;
    case 7: 
      j = 7;
      break;
    case 6: 
      j = 6;
      break;
    case 5: 
      j = 5;
      break;
    case 4: 
      j = 4;
      break;
    case 3: 
      j = 3;
      break;
    case 2: 
      j = 2;
      break;
    case 1: 
      j = 1;
      break;
    case 0: 
      j = 0;
    }
    ReportController.b(this.b, "dc00898", "", "", "0X800A68B", "0X800A68B", j, 0, "4", "", "", "");
    if (paramInt == 1)
    {
      A();
      return;
    }
    if (paramInt == 2)
    {
      b(paramView);
      return;
    }
    if (paramInt == 3)
    {
      a(paramView);
      return;
    }
    A();
  }
  
  protected void a(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForFile))
    {
      QLog.e("OfflineFileBubbleModel", 1, "setBubbleModelData. is not a MessageForFile");
      return;
    }
    this.f = ((MessageForFile)paramChatMessage);
    this.g = FileManagerUtil.a(this.b, this.f);
    paramChatMessage = this.g;
    if (paramChatMessage == null)
    {
      QLog.e("OfflineFileBubbleModel", 1, "setBubbleModelData. can not find a FileManagerEntity");
      return;
    }
    FileManagerUtil.e(paramChatMessage);
  }
  
  public boolean a()
  {
    MessageForFile localMessageForFile = this.f;
    if (localMessageForFile == null) {
      return false;
    }
    return localMessageForFile.isSend();
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    long l;
    if (paramInt == 3000) {
      l = 1296000L;
    } else {
      l = 604800L;
    }
    paramLong = (MessageCache.c() * 1000L - paramLong) / 1000L;
    return (paramLong > 0L) && (paramLong > l);
  }
  
  public QFileBubblePauseHandler b()
  {
    return new OfflineFileBubblePauseHandler(this.b, this.c);
  }
  
  public List<Integer> b(int paramInt)
  {
    if (this.f == null) {
      return new ArrayList();
    }
    FileManagerUtil.a(this.b, this.f);
    if (paramInt == 1) {
      return x();
    }
    if (paramInt == 2) {
      return y();
    }
    if (paramInt == 3) {
      return z();
    }
    return new ArrayList();
  }
  
  public QFileBubbleDownloadHandler c()
  {
    return new OfflineFileBubbleDownloadHandler(this.b, this.c);
  }
  
  public List<Integer> c(int paramInt)
  {
    if (this.f == null) {
      return new ArrayList();
    }
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.b, this.f);
    ArrayList localArrayList = new ArrayList();
    if (QFileBubbleUtils.a(localFileManagerEntity))
    {
      localArrayList.add(Integer.valueOf(9));
      if (AIOUtils.a(5) == 1) {
        localArrayList.add(Integer.valueOf(19));
      }
    }
    return localArrayList;
  }
  
  public int d()
  {
    FileManagerEntity localFileManagerEntity = this.g;
    if (localFileManagerEntity == null) {
      return 0;
    }
    return FilePicURLDrawlableHelper.h(localFileManagerEntity).a;
  }
  
  public int e()
  {
    FileManagerEntity localFileManagerEntity = this.g;
    if (localFileManagerEntity == null) {
      return 0;
    }
    return FilePicURLDrawlableHelper.h(localFileManagerEntity).b;
  }
  
  public String f()
  {
    FileManagerEntity localFileManagerEntity = this.g;
    if (localFileManagerEntity == null) {
      return "";
    }
    return localFileManagerEntity.fileName;
  }
  
  public long g()
  {
    FileManagerEntity localFileManagerEntity = this.g;
    if (localFileManagerEntity == null) {
      return 0L;
    }
    return localFileManagerEntity.fileSize;
  }
  
  public String h()
  {
    if (this.f == null) {
      return "";
    }
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.b, this.f);
    if (localFileManagerEntity == null) {
      return "";
    }
    Object localObject = localFileManagerEntity.strMiddleThumPath;
    int j = FileManagerUtil.c(localFileManagerEntity.fileName);
    if (j == 0)
    {
      String str = localFileManagerEntity.strMiddleThumPath;
      localObject = str;
      if (!FileUtil.b(str))
      {
        localObject = str;
        if (FileUtil.b(localFileManagerEntity.strLargeThumPath))
        {
          if (FilePicURLDrawlableHelper.i(localFileManagerEntity))
          {
            ThreadManagerV2.executeOnSubThread(new OfflineFileBubbleModel.1(this, localFileManagerEntity));
            return str;
          }
          return localFileManagerEntity.strLargeThumPath;
        }
      }
    }
    else if (j == 2)
    {
      localObject = localFileManagerEntity.strLargeThumPath;
    }
    return localObject;
  }
  
  public int i()
  {
    FileManagerEntity localFileManagerEntity = this.g;
    int j = 0;
    if (localFileManagerEntity == null) {
      return 0;
    }
    boolean bool = a(localFileManagerEntity.peerType, this.g.srvTime);
    int k = this.g.status;
    if (k != 0)
    {
      if (k != 2)
      {
        if (k != 3)
        {
          switch (k)
          {
          default: 
            switch (k)
            {
            default: 
              break;
            case 16: 
              if (bool) {
                j = 6;
              }
              break;
            case 14: 
            case 15: 
              if (9 != this.g.nOpType) {
                break label161;
              }
            }
            break;
          }
          j = 1;
        }
        else
        {
          j = 4;
        }
      }
      else {
        j = 3;
      }
    }
    else {
      j = 2;
    }
    label161:
    k = j;
    if (bool)
    {
      k = j;
      if (!FileManagerUtil.n(this.g.getFilePath())) {
        k = 6;
      }
    }
    return k;
  }
  
  public int j()
  {
    if (this.g == null) {
      return -1;
    }
    boolean bool = this.f.isSend();
    if (this.f.isMultiMsg) {
      bool = FileManagerUtil.a(this.b, this.f);
    }
    int j = 0;
    int k = this.g.status;
    if (k != 0)
    {
      if (k != 1)
      {
        if (k != 2)
        {
          if ((k != 14) && (k != 15)) {
            return 0;
          }
          if (9 != this.g.nOpType) {
            return j;
          }
        }
        else
        {
          if (!bool) {
            break label98;
          }
        }
        return 1;
        label98:
        return 4;
      }
      else if (bool)
      {
        if (FileUtils.fileExistsAndNotEmpty(this.g.getFilePath())) {
          return 2;
        }
      }
      else if (FileUtils.fileExistsAndNotEmpty(this.g.getFilePath()))
      {
        return 5;
      }
    }
    else
    {
      if ((bool) && (!this.g.bOnceSuccess)) {
        return 3;
      }
      j = 6;
    }
    return j;
  }
  
  public int k()
  {
    FileManagerEntity localFileManagerEntity = this.g;
    if (localFileManagerEntity == null) {
      return 0;
    }
    return (int)(localFileManagerEntity.fProgress * 100.0F);
  }
  
  public void l()
  {
    if (this.e)
    {
      w();
      if (QLog.isColorLevel()) {
        QLog.i("OfflineFileBubbleModel", 1, "fetchFileThumb.");
      }
      if (this.f != null)
      {
        FileManagerEntity localFileManagerEntity = this.g;
        if (localFileManagerEntity == null) {
          return;
        }
        int j = FileManagerUtil.c(localFileManagerEntity.fileName);
        if (j == 2)
        {
          B();
          return;
        }
        if (j == 0) {
          C();
        }
      }
    }
  }
  
  public void m()
  {
    if (this.f != null)
    {
      if (this.g == null) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.g.fileName);
      ((StringBuilder)localObject).append(this.g.nSessionId);
      localObject = ((StringBuilder)localObject).toString();
      if (!this.b.getFileManagerProxy().l((String)localObject))
      {
        ReportController.b(null, "dc00898", "", "", "0X800A686", "0X800A686", 0, 0, "", "", "", "");
        this.b.getFileManagerProxy().k((String)localObject);
      }
      this.b.getFileManagerEngine().f().a();
    }
  }
  
  public boolean n()
  {
    FileManagerEntity localFileManagerEntity = this.g;
    if (localFileManagerEntity == null) {
      return false;
    }
    if (FileManagerUtil.c(localFileManagerEntity.fileName) == 2)
    {
      if ((!this.g.isSend()) || (this.g.status != 0)) {}
    }
    else {
      label163:
      do
      {
        for (;;)
        {
          return true;
          j = this.g.status;
          if (j == 0) {
            break label163;
          }
          if (j == 14) {
            break;
          }
          if (j != 16)
          {
            if ((j != 5) && (j != 6) && (j != 7) && (j != 8))
            {
              if ((j != 10) && (j != 11)) {
                return false;
              }
              if (10 != this.g.nOpType) {
                break label197;
              }
            }
            else
            {
              j = this.g.nOpType;
              return false;
            }
          }
          else {
            if ((!this.g.isSend()) || (this.g.bOnceSuccess)) {
              break label197;
            }
          }
        }
        int j = this.g.nOpType;
        return false;
      } while ((this.g.status == 0) && (this.g.isSend() == true) && (!this.g.bOnceSuccess));
    }
    label197:
    return false;
  }
  
  public void o()
  {
    if (this.g == null) {
      return;
    }
    String str1 = this.c.getString(2131889299);
    String str2 = this.c.getString(2131889298);
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.c, null);
    localActionSheet.addButton(str1);
    localActionSheet.addCancelButton(this.c.getString(2131887648));
    localActionSheet.setMainTitle(str2);
    localActionSheet.setOnButtonClickListener(new OfflineFileBubbleModel.2(this, localActionSheet));
    localActionSheet.show();
  }
  
  public long p()
  {
    FileManagerEntity localFileManagerEntity = this.g;
    if (localFileManagerEntity == null) {
      return 0L;
    }
    if (localFileManagerEntity.getCloudType() == 0) {
      return 0L;
    }
    if (this.g.status == 16) {
      return -1L;
    }
    if (FileUtils.fileExistsAndNotEmpty(this.g.getFilePath())) {
      return 0L;
    }
    long l = this.g.srvTime;
    l = (MessageCache.c() * 1000L - l) / 1000L;
    if (l > 0L)
    {
      if (l > 604800L) {
        return -1L;
      }
      return 604800L - l;
    }
    return 0L;
  }
  
  public int q()
  {
    FileManagerEntity localFileManagerEntity = this.g;
    if (localFileManagerEntity == null) {
      return 0;
    }
    if (QFileUtils.a(localFileManagerEntity.imgWidth, this.g.imgHeight, this.g.fileSize)) {
      return 1;
    }
    if (this.g.thumbInvalidCode == 1) {
      return 1;
    }
    if (this.g.thumbInvalidCode == 2) {
      return 2;
    }
    return super.q();
  }
  
  public String r()
  {
    if (!QFileAssistantUtils.a(this.g.peerUin)) {
      return super.r();
    }
    if (i() != 0) {
      return super.r();
    }
    int j = j();
    if ((j != 5) && (j != 2)) {
      return super.r();
    }
    if (!TextUtils.isEmpty(this.g.Uuid)) {
      return super.r();
    }
    return this.c.getResources().getString(2131896190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.OfflineFileBubbleModel
 * JD-Core Version:    0.7.0.1
 */