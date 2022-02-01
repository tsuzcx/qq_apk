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
  private MessageForFile jdField_a_of_type_ComTencentMobileqqDataMessageForFile;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private boolean c = true;
  private boolean d;
  
  public OfflineFileBubbleModel(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
  }
  
  private List<Integer> a()
  {
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
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
    if (QFileBubbleUtils.a(localFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.frienduin)) {
      localArrayList.add(Integer.valueOf(20));
    }
    localArrayList.add(Integer.valueOf(16));
    localArrayList.add(Integer.valueOf(17));
    localArrayList.add(Integer.valueOf(19));
    if ((localFileManagerEntity.getCloudType() != 0) && (!a(localFileManagerEntity)) && (!localFileManagerEntity.sendCloudUnsuccessful())) {
      localArrayList.add(Integer.valueOf(21));
    }
    d(localFileManagerEntity, localArrayList);
    return localArrayList;
  }
  
  private void a(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg) && (!FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {
      return;
    }
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
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
    if ((localFileManagerEntity.sendCloudUnsuccessful()) && (!FileUtil.a(localFileManagerEntity.getFilePath())))
    {
      FMToastUtil.a(HardCodeUtil.a(2131704684));
      return;
    }
    Object localObject = new FileManagerReporter.FileAssistantReportData();
    ((FileManagerReporter.FileAssistantReportData)localObject).b = "file_viewer_in";
    ((FileManagerReporter.FileAssistantReportData)localObject).jdField_a_of_type_Int = 9;
    ((FileManagerReporter.FileAssistantReportData)localObject).c = FileUtil.a(localFileManagerEntity.fileName);
    ((FileManagerReporter.FileAssistantReportData)localObject).d = FileManagerUtil.a(localFileManagerEntity.getCloudType(), localFileManagerEntity.peerType);
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject);
    FileManagerReporter.a("0X8004AE3");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handle item click: file peerType[");
    ((StringBuilder)localObject).append(localFileManagerEntity.peerType);
    ((StringBuilder)localObject).append("]");
    QLog.i("OfflineFileBubbleModel", 1, ((StringBuilder)localObject).toString());
    if (localFileManagerEntity.peerType == 0) {}
    while (localFileManagerEntity.peerType != 3000)
    {
      i = 1;
      break;
    }
    int i = 5;
    paramView = AnimationUtils.a(paramView);
    QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, paramView, i, 10004, localFileManagerEntity, false, false);
  }
  
  private void a(FileManagerEntity paramFileManagerEntity)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644C", "0X800644C", 0, 0, "6", "", "", "");
    if (FileModel.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile).a(false))
    {
      if (FreeWifiHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, 5, new OfflineFileBubbleModel.5(this))) {
        FMDialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131692561, 2131692564, new OfflineFileBubbleModel.6(this));
      }
    }
    else {
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_AndroidContentContext);
    }
  }
  
  private void a(FileManagerEntity paramFileManagerEntity, ArrayList<Integer> paramArrayList)
  {
    if (!QFileBubbleUtils.a(paramFileManagerEntity)) {
      return;
    }
    if ((paramFileManagerEntity.getCloudType() != 0) && (!a(paramFileManagerEntity)) && (AIOUtils.a(5) == 1)) {
      paramArrayList.add(Integer.valueOf(18));
    }
  }
  
  private boolean a(FileManagerEntity paramFileManagerEntity)
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
  
  private List<Integer> b()
  {
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    ArrayList localArrayList = new ArrayList();
    if (localFileManagerEntity == null) {
      return localArrayList;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isSendFromLocal()) && (localFileManagerEntity.status == 2))
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
        localArrayList.add(Integer.valueOf(18));
      }
      if (localFileManagerEntity.status == 1) {
        localArrayList.add(Integer.valueOf(15));
      }
    }
    localArrayList.add(Integer.valueOf(17));
    localArrayList.add(Integer.valueOf(16));
    localArrayList.add(Integer.valueOf(19));
    return localArrayList;
  }
  
  private void b(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg) && (!FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {
      return;
    }
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    if ((localFileManagerEntity.status == 16) && (!FileManagerUtil.f(localFileManagerEntity))) {
      return;
    }
    paramView = AnimationUtils.a(paramView);
    QFileUtils.a(this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, false);
  }
  
  private void b(FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    ReportController.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 3, 0, "", "", "", "");
    int i;
    if (paramFileManagerEntity.peerType == 0)
    {
      i = 1;
    }
    else if (paramFileManagerEntity.peerType == 3000)
    {
      i = 5;
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("entranceType is unknow ,peerType:");
      localStringBuilder.append(paramFileManagerEntity.peerType);
      QLog.w("OfflineFileBubbleModel", 1, localStringBuilder.toString());
      i = 0;
    }
    QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, null, i, 10004, paramFileManagerEntity, true, false);
  }
  
  private void b(FileManagerEntity paramFileManagerEntity, ArrayList<Integer> paramArrayList)
  {
    if (!QFileBubbleUtils.a(paramFileManagerEntity)) {
      return;
    }
    if ((paramFileManagerEntity.getCloudType() != 0) && (!a(paramFileManagerEntity)) && (!paramFileManagerEntity.sendCloudUnsuccessful())) {
      paramArrayList.add(Integer.valueOf(9));
    }
  }
  
  private List<Integer> c()
  {
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    ArrayList localArrayList = new ArrayList();
    if (localFileManagerEntity == null) {
      return localArrayList;
    }
    if (QFileBubbleUtils.a(localFileManagerEntity)) {
      localArrayList.add(Integer.valueOf(13));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isSendFromLocal()) && (localFileManagerEntity.status == 2))
    {
      localArrayList.add(Integer.valueOf(6));
    }
    else
    {
      if (QFileBubbleUtils.a(localFileManagerEntity))
      {
        localArrayList.add(Integer.valueOf(9));
        localArrayList.add(Integer.valueOf(10));
        localArrayList.add(Integer.valueOf(18));
        localArrayList.add(Integer.valueOf(12));
      }
      if (localFileManagerEntity.status == 1) {
        localArrayList.add(Integer.valueOf(15));
      }
    }
    localArrayList.add(Integer.valueOf(16));
    localArrayList.add(Integer.valueOf(17));
    localArrayList.add(Integer.valueOf(19));
    return localArrayList;
  }
  
  private void c(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject1 = new FileManagerReporter.FileAssistantReportData();
    ((FileManagerReporter.FileAssistantReportData)localObject1).b = "file_forward";
    ((FileManagerReporter.FileAssistantReportData)localObject1).jdField_a_of_type_Int = 9;
    ((FileManagerReporter.FileAssistantReportData)localObject1).jdField_a_of_type_Long = paramFileManagerEntity.fileSize;
    ((FileManagerReporter.FileAssistantReportData)localObject1).c = FileUtil.a(paramFileManagerEntity.fileName);
    ((FileManagerReporter.FileAssistantReportData)localObject1).d = FileManagerUtil.a(paramFileManagerEntity.getCloudType(), paramFileManagerEntity.peerType);
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject1);
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("forward_type", 0);
    ((Bundle)localObject2).putBoolean("not_forward", true);
    ((Bundle)localObject2).putParcelable("fileinfo", ForwardFileOption.a(paramFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile));
    ((Bundle)localObject2).putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    localObject1 = new Intent();
    ((Intent)localObject1).putExtras((Bundle)localObject2);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131704620));
    ((StringBuilder)localObject2).append(FileManagerUtil.c(paramFileManagerEntity.fileName));
    ((StringBuilder)localObject2).append(HardCodeUtil.a(2131704621));
    ((StringBuilder)localObject2).append(FileUtil.a(paramFileManagerEntity.fileSize));
    ((StringBuilder)localObject2).append("。");
    ((Intent)localObject1).putExtra("forward_text", ((StringBuilder)localObject2).toString());
    ((Intent)localObject1).putExtra("direct_send_if_dataline_forward", true);
    ((Intent)localObject1).putExtra("forward _key_nojump", true);
    ((Intent)localObject1).putExtra("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131694475, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
    } else {
      ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject1, 21);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "6", "", "", "");
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 8, 0, "8", "", "", "");
    }
  }
  
  private void c(FileManagerEntity paramFileManagerEntity, ArrayList<Integer> paramArrayList)
  {
    if (!QFileBubbleUtils.a(paramFileManagerEntity)) {
      return;
    }
    if (this.c)
    {
      this.d = TencentDocConvertConfigProcessor.a().c();
      this.c = false;
    }
    String str = TencentDocImportFileInfoProcessor.a().c();
    long l = FileManagerUtil.b(paramFileManagerEntity.fileName);
    if ((this.d) && (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsSupport(paramFileManagerEntity.getFilePath(), paramFileManagerEntity.fileName, str)))
    {
      int j = paramFileManagerEntity.status;
      int i = 1;
      if ((j == 16) && ((TextUtils.isEmpty(paramFileManagerEntity.getFilePath())) || (!new VFSFile(paramFileManagerEntity.getFilePath()).exists()))) {
        i = 0;
      }
      if ((i != 0) && (paramFileManagerEntity.fileSize <= l))
      {
        paramArrayList.add(Integer.valueOf(22));
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void d(FileManagerEntity paramFileManagerEntity)
  {
    try
    {
      paramFileManagerEntity = TestStructMsg.a(TestStructMsg.a(paramFileManagerEntity.getFilePath()));
      if (paramFileManagerEntity == null) {
        break label73;
      }
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.frienduin;
      localSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.istroop;
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, paramFileManagerEntity);
      return;
    }
    catch (Exception paramFileManagerEntity)
    {
      label55:
      label73:
      break label55;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131704618), 1).a();
  }
  
  private void d(FileManagerEntity paramFileManagerEntity, ArrayList<Integer> paramArrayList)
  {
    if ((16 != paramFileManagerEntity.status) && (paramFileManagerEntity.getCloudType() != 0) && (!a(paramFileManagerEntity))) {
      paramArrayList.add(Integer.valueOf(24));
    }
  }
  
  private void e(FileManagerEntity paramFileManagerEntity) {}
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg) && (!FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {
      return;
    }
    Object localObject1 = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    if (!QFileUtils.a((FileManagerEntity)localObject1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OfflineFileBubbleModel", 1, "onItemClick: file is forwarding or forward failed, can not open file browser.");
      }
      return;
    }
    Object localObject2 = new FileManagerReporter.FileAssistantReportData();
    ((FileManagerReporter.FileAssistantReportData)localObject2).b = "file_viewer_in";
    ((FileManagerReporter.FileAssistantReportData)localObject2).jdField_a_of_type_Int = 9;
    ((FileManagerReporter.FileAssistantReportData)localObject2).c = FileUtil.a(((FileManagerEntity)localObject1).fileName);
    ((FileManagerReporter.FileAssistantReportData)localObject2).d = FileManagerUtil.a(((FileManagerEntity)localObject1).getCloudType(), ((FileManagerEntity)localObject1).peerType);
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject2);
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
      localObject1 = (Activity)this.jdField_a_of_type_AndroidContentContext;
      Intent localIntent = new Intent((Context)localObject1, TroopFileDetailBrowserActivity.class);
      localIntent.putExtra("fileinfo", (Parcelable)localObject2);
      localIntent.putExtra("removemementity", true);
      localIntent.putExtra("forward_from_troop_file", true);
      localIntent.putExtra("not_forward", true);
      ((Activity)localObject1).startActivityForResult(localIntent, 102);
      return;
    }
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("file_browser_extra_params_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    int i = 0;
    if (((FileManagerEntity)localObject1).peerType == 0) {
      i = 1;
    } else if (((FileManagerEntity)localObject1).peerType == 3000) {
      i = 5;
    }
    int j = QFileUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg, (Bundle)localObject2, i);
    if ((((FileManagerEntity)localObject1).nFileType != 0) && (((FileManagerEntity)localObject1).nFileType != 2))
    {
      localObject1 = new FileModelAdapter(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FileManagerEntity)localObject1);
      ((IFileBrowserModel)localObject1).a((Bundle)localObject2);
      localObject2 = new FileBrowserParam().a(i);
      if ((j != 1) && ((j != 3) || (i != 1)))
      {
        ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).browserFile(this.jdField_a_of_type_AndroidContentContext, (IFileBrowserModel)localObject1, (IFileBrowserParam)localObject2);
        return;
      }
      ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).browserFile((Activity)this.jdField_a_of_type_AndroidContentContext, 38, (IFileBrowserModel)localObject1, (IFileBrowserParam)localObject2);
      return;
    }
    localObject1 = new CommonFileBrowserParams(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (FileManagerEntity)localObject1, 10004);
    ((CommonFileBrowserParams)localObject1).a((Bundle)localObject2);
    localObject1 = new FileBrowserCreator(this.jdField_a_of_type_AndroidContentContext, (IFileBrowserParams)localObject1);
    ((FileBrowserCreator)localObject1).a(i);
    QFileUtils.a(i, j, (FileBrowserCreator)localObject1);
  }
  
  private void g()
  {
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    if (localFileManagerEntity == null)
    {
      QLog.e("OfflineFileBubbleModel", 1, "fetchVideoFileThumb. can not find a FileManagerEntity");
      return;
    }
    if ((FileUtil.a(localFileManagerEntity.getFilePath())) && (FileManagerUtil.c(localFileManagerEntity)))
    {
      ThreadManager.executeOnSubThread(new OfflineFileBubbleModel.3(this, localFileManagerEntity));
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().b(localFileManagerEntity);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(localFileManagerEntity);
  }
  
  private void h()
  {
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    if (localFileManagerEntity == null)
    {
      QLog.e("OfflineFileBubbleModel", 1, "fetchImageFileThumb. can not find a FileManagerEntity");
      return;
    }
    if (FileUtil.a(localFileManagerEntity.getFilePath()))
    {
      ThreadManager.executeOnSubThread(new OfflineFileBubbleModel.4(this, localFileManagerEntity));
      return;
    }
    if (FilePicURLDrawlableHelper.a(localFileManagerEntity))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(localFileManagerEntity, 7);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a(localFileManagerEntity, 5);
  }
  
  public int a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null) {
      return 0;
    }
    return FilePicURLDrawlableHelper.a(localFileManagerEntity).jdField_a_of_type_Int;
  }
  
  public long a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null) {
      return 0L;
    }
    return localFileManagerEntity.fileSize;
  }
  
  public QFileBubbleDownloadHandler a()
  {
    return new OfflineFileBubbleDownloadHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
  }
  
  public QFileBubblePauseHandler a()
  {
    return new OfflineFileBubblePauseHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
  }
  
  public String a()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null) {
      return "";
    }
    return localFileManagerEntity.fileName;
  }
  
  public List<Integer> a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile == null) {
      return new ArrayList();
    }
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    if (paramInt == 1) {
      return a();
    }
    if (paramInt == 2) {
      return b();
    }
    if (paramInt == 3) {
      return c();
    }
    return new ArrayList();
  }
  
  public void a()
  {
    if (this.b)
    {
      e();
      if (QLog.isColorLevel()) {
        QLog.i("OfflineFileBubbleModel", 1, "fetchFileThumb.");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile != null)
      {
        FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
        if (localFileManagerEntity == null) {
          return;
        }
        int i = FileManagerUtil.a(localFileManagerEntity.fileName);
        if (i == 2)
        {
          g();
          return;
        }
        if (i == 0) {
          h();
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
        return;
      }
      FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
      switch (paramInt)
      {
      default: 
      case 2131380212: 
        e(localFileManagerEntity);
        return;
      case 2131378344: 
        TeamWorkConvertUtils.a(localFileManagerEntity, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D69", "0X8009D69", 0, 0, "", "", "", "");
          return;
        }
        break;
      case 2131377224: 
        d(localFileManagerEntity);
        return;
      case 2131376894: 
        a(localFileManagerEntity);
        return;
      case 2131371660: 
        b(localFileManagerEntity);
        return;
      case 2131371562: 
        long l1 = MessageCache.a();
        long l2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.time;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.msgtype == -2005) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.istroop == 3000) && (l1 - l2 > 604800L))
        {
          FMToastUtil.a(HardCodeUtil.a(2131704622));
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "6", "", "", "");
          return;
        }
        FileManagerReporter.a("0X8005E4B");
        return;
      case 2131367208: 
        ReportController.b(null, "dc00898", "", "", "0X800A60C", "0X800A60C", 0, 0, "", "", "", "");
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131694475, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
          return;
        }
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_AndroidContentContext);
        return;
      case 2131367180: 
        c(localFileManagerEntity);
        return;
      case 2131366494: 
        new QfavBuilder(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, localFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, false);
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
          return;
        }
        break;
      case 2131365480: 
        ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity);
        if (FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName) == 0)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "6", "", "", "");
          return;
        }
        break;
      case 2131364785: 
        ((IApolloUtil)QRoute.api(IApolloUtil.class)).replaceCmshow3dResource(localFileManagerEntity.getFilePath());
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)) {}
  }
  
  public void a(int paramInt, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    if (localFileManagerEntity == null)
    {
      QLog.e("OfflineFileBubbleModel", 1, "get Entity by Msg faild!");
      return;
    }
    int i;
    switch (FileManagerUtil.a(localFileManagerEntity.fileName))
    {
    default: 
      i = 11;
      break;
    case 10: 
      i = 10;
      break;
    case 9: 
      i = 9;
      break;
    case 8: 
      i = 8;
      break;
    case 7: 
      i = 7;
      break;
    case 6: 
      i = 6;
      break;
    case 5: 
      i = 5;
      break;
    case 4: 
      i = 4;
      break;
    case 3: 
      i = 3;
      break;
    case 2: 
      i = 2;
      break;
    case 1: 
      i = 1;
      break;
    case 0: 
      i = 0;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A68B", "0X800A68B", i, 0, "4", "", "", "");
    if (paramInt == 1)
    {
      f();
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
    f();
  }
  
  protected void a(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForFile))
    {
      QLog.e("OfflineFileBubbleModel", 1, "setBubbleModelData. is not a MessageForFile");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile = ((MessageForFile)paramChatMessage);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (paramChatMessage == null)
    {
      QLog.e("OfflineFileBubbleModel", 1, "setBubbleModelData. can not find a FileManagerEntity");
      return;
    }
    FileManagerUtil.b(paramChatMessage);
  }
  
  public boolean a()
  {
    MessageForFile localMessageForFile = this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile;
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
    paramLong = (MessageCache.a() * 1000L - paramLong) / 1000L;
    return (paramLong > 0L) && (paramLong > l);
  }
  
  public int b()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null) {
      return 0;
    }
    return FilePicURLDrawlableHelper.a(localFileManagerEntity).b;
  }
  
  public long b()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null) {
      return 0L;
    }
    if (localFileManagerEntity.getCloudType() == 0) {
      return 0L;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 16) {
      return -1L;
    }
    if (FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath())) {
      return 0L;
    }
    long l = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.srvTime;
    l = (MessageCache.a() * 1000L - l) / 1000L;
    if (l > 0L)
    {
      if (l > 604800L) {
        return -1L;
      }
      return 604800L - l;
    }
    return 0L;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile == null) {
      return "";
    }
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    if (localFileManagerEntity == null) {
      return "";
    }
    Object localObject = localFileManagerEntity.strMiddleThumPath;
    int i = FileManagerUtil.a(localFileManagerEntity.fileName);
    if (i == 0)
    {
      String str = localFileManagerEntity.strMiddleThumPath;
      localObject = str;
      if (!FileUtil.a(str))
      {
        localObject = str;
        if (FileUtil.a(localFileManagerEntity.strLargeThumPath))
        {
          if (FilePicURLDrawlableHelper.a(localFileManagerEntity))
          {
            ThreadManagerV2.executeOnSubThread(new OfflineFileBubbleModel.1(this, localFileManagerEntity));
            return str;
          }
          return localFileManagerEntity.strLargeThumPath;
        }
      }
    }
    else if (i == 2)
    {
      localObject = localFileManagerEntity.strLargeThumPath;
    }
    return localObject;
  }
  
  public List<Integer> b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile == null) {
      return new ArrayList();
    }
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    ArrayList localArrayList = new ArrayList();
    if (QFileBubbleUtils.a(localFileManagerEntity))
    {
      localArrayList.add(Integer.valueOf(9));
      if (AIOUtils.a(5) == 1) {
        localArrayList.add(Integer.valueOf(18));
      }
    }
    return localArrayList;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      localObject = ((StringBuilder)localObject).toString();
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a((String)localObject))
      {
        ReportController.b(null, "dc00898", "", "", "0X800A686", "0X800A686", 0, 0, "", "", "", "");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a((String)localObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a();
    }
  }
  
  public boolean b()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null) {
      return false;
    }
    if (FileManagerUtil.a(localFileManagerEntity.fileName) == 2)
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isSend()) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 0)) {}
    }
    else {
      label163:
      do
      {
        for (;;)
        {
          return true;
          i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status;
          if (i == 0) {
            break label163;
          }
          if (i == 14) {
            break;
          }
          if (i != 16)
          {
            if ((i != 5) && (i != 6) && (i != 7) && (i != 8))
            {
              if ((i != 10) && (i != 11)) {
                return false;
              }
              if (10 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType) {
                break label197;
              }
            }
            else
            {
              i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType;
              return false;
            }
          }
          else {
            if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isSend()) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bOnceSuccess)) {
              break label197;
            }
          }
        }
        int i = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType;
        return false;
      } while ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 0) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isSend() == true) && (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bOnceSuccess));
    }
    label197:
    return false;
  }
  
  public int c()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    int i = 0;
    if (localFileManagerEntity == null) {
      return 0;
    }
    boolean bool = a(localFileManagerEntity.peerType, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.srvTime);
    int j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status;
    if (j != 0)
    {
      if (j != 2)
      {
        if (j != 3)
        {
          switch (j)
          {
          default: 
            switch (j)
            {
            default: 
              break;
            case 16: 
              if (bool) {
                i = 6;
              }
              break;
            case 14: 
            case 15: 
              if (9 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType) {
                break label161;
              }
            }
            break;
          }
          i = 1;
        }
        else
        {
          i = 4;
        }
      }
      else {
        i = 3;
      }
    }
    else {
      i = 2;
    }
    label161:
    if (bool) {
      i = 6;
    }
    return i;
  }
  
  public String c()
  {
    if (!QFileAssistantUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin)) {
      return super.c();
    }
    if (c() != 0) {
      return super.c();
    }
    int i = d();
    if ((i != 5) && (i != 2)) {
      return super.c();
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid)) {
      return super.c();
    }
    return this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698289);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return;
    }
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692311);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131692310);
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    localActionSheet.addButton(str1);
    localActionSheet.addCancelButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690728));
    localActionSheet.setMainTitle(str2);
    localActionSheet.setOnButtonClickListener(new OfflineFileBubbleModel.2(this, localActionSheet));
    localActionSheet.show();
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return -1;
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isSend();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg) {
      bool = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    }
    int i = 0;
    int j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status;
    if (j != 0)
    {
      if (j != 1)
      {
        if (j != 2)
        {
          if ((j != 14) && (j != 15)) {
            return 0;
          }
          if (9 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType) {
            return i;
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
        if (FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath())) {
          return 2;
        }
      }
      else if (FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath()))
      {
        return 5;
      }
    }
    else
    {
      if ((bool) && (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bOnceSuccess)) {
        return 3;
      }
      i = 6;
    }
    return i;
  }
  
  public int e()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null) {
      return 0;
    }
    return (int)(localFileManagerEntity.fProgress * 100.0F);
  }
  
  public int f()
  {
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localFileManagerEntity == null) {
      return 0;
    }
    if (QFileUtils.a(localFileManagerEntity.imgWidth, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgHeight, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize)) {
      return 1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.thumbInvalidCode == 1) {
      return 1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.thumbInvalidCode == 2) {
      return 2;
    }
    return super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.OfflineFileBubbleModel
 * JD-Core Version:    0.7.0.1
 */