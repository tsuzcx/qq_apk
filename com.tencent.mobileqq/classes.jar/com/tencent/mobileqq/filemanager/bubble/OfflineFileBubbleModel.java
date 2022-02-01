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
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
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
import com.tencent.mobileqq.filemanager.recreate.FileModel;
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
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqreader.QRLocalManager;
import java.util.ArrayList;
import java.util.List;

public class OfflineFileBubbleModel
  extends QFileBubbleModel
{
  public static boolean a;
  private MessageForFile jdField_a_of_type_ComTencentMobileqqDataMessageForFile;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private boolean c = true;
  private boolean d;
  
  static
  {
    jdField_a_of_type_Boolean = false;
  }
  
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
    int i = 1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg) && (!FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        return;
        localFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
        if (localFileManagerEntity == null)
        {
          QLog.e("OfflineFileBubbleModel", 1, "get Entity by Msg faild!");
          return;
        }
      } while (localFileManagerEntity.status == 16);
      if (QFileUtils.a(localFileManagerEntity)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("OfflineFileBubbleModel", 1, "onItemClick: file is forwarding or forward failed, can not open file browser.");
    return;
    if ((localFileManagerEntity.sendCloudUnsuccessful()) && (!FileUtil.b(localFileManagerEntity.getFilePath())))
    {
      FMToastUtil.a(HardCodeUtil.a(2131704604));
      return;
    }
    FileManagerReporter.FileAssistantReportData localFileAssistantReportData = new FileManagerReporter.FileAssistantReportData();
    localFileAssistantReportData.b = "file_viewer_in";
    localFileAssistantReportData.jdField_a_of_type_Int = 9;
    localFileAssistantReportData.c = FileUtil.a(localFileManagerEntity.fileName);
    localFileAssistantReportData.d = FileManagerUtil.a(localFileManagerEntity.getCloudType(), localFileManagerEntity.peerType);
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localFileAssistantReportData);
    FileManagerReporter.a("0X8004AE3");
    QLog.i("OfflineFileBubbleModel", 1, "handle item click: file peerType[" + localFileManagerEntity.peerType + "]");
    if (localFileManagerEntity.peerType == 0) {}
    for (;;)
    {
      paramView = AnimationUtils.a(paramView);
      QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, paramView, i, 10004, localFileManagerEntity, false, false);
      return;
      if (localFileManagerEntity.peerType == 3000) {
        i = 5;
      }
    }
  }
  
  private void a(FileManagerEntity paramFileManagerEntity)
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800644C", "0X800644C", 0, 0, "6", "", "", "");
    if (FileModel.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile).a(false))
    {
      if (FreeWifiHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, 5, new OfflineFileBubbleModel.5(this))) {
        FMDialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 2131692609, 2131692612, new OfflineFileBubbleModel.6(this));
      }
      return;
    }
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_AndroidContentContext);
  }
  
  private void a(FileManagerEntity paramFileManagerEntity, ArrayList<Integer> paramArrayList)
  {
    if (!QFileBubbleUtils.a(paramFileManagerEntity)) {}
    while ((paramFileManagerEntity.getCloudType() == 0) || (a(paramFileManagerEntity)) || (AIOUtils.a(5) != 1)) {
      return;
    }
    paramArrayList.add(Integer.valueOf(18));
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
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isSendFromLocal()) && (localFileManagerEntity.status == 2)) {
      localArrayList.add(Integer.valueOf(6));
    }
    for (;;)
    {
      localArrayList.add(Integer.valueOf(17));
      localArrayList.add(Integer.valueOf(16));
      localArrayList.add(Integer.valueOf(19));
      return localArrayList;
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
  }
  
  private void b(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg) && (!FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      return;
      localFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    } while ((localFileManagerEntity.status == 16) && (!FileManagerUtil.f(localFileManagerEntity)));
    paramView = AnimationUtils.a(paramView);
    QFileUtils.a(this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, false);
  }
  
  private void b(FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    ReportController.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 3, 0, "", "", "", "");
    int i = 0;
    if (paramFileManagerEntity.peerType == 0) {
      i = 1;
    }
    for (;;)
    {
      QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, null, i, 10004, paramFileManagerEntity, true, false);
      return;
      if (paramFileManagerEntity.peerType == 3000) {
        i = 5;
      } else {
        QLog.w("OfflineFileBubbleModel", 1, "entranceType is unknow ,peerType:" + paramFileManagerEntity.peerType);
      }
    }
  }
  
  private void b(FileManagerEntity paramFileManagerEntity, ArrayList<Integer> paramArrayList)
  {
    if (!QFileBubbleUtils.a(paramFileManagerEntity)) {}
    while ((paramFileManagerEntity.getCloudType() == 0) || (a(paramFileManagerEntity)) || (paramFileManagerEntity.sendCloudUnsuccessful())) {
      return;
    }
    paramArrayList.add(Integer.valueOf(9));
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
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isSendFromLocal()) && (localFileManagerEntity.status == 2)) {
      localArrayList.add(Integer.valueOf(6));
    }
    for (;;)
    {
      localArrayList.add(Integer.valueOf(16));
      localArrayList.add(Integer.valueOf(17));
      localArrayList.add(Integer.valueOf(19));
      return localArrayList;
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
  }
  
  private void c(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject = new FileManagerReporter.FileAssistantReportData();
    ((FileManagerReporter.FileAssistantReportData)localObject).b = "file_forward";
    ((FileManagerReporter.FileAssistantReportData)localObject).jdField_a_of_type_Int = 9;
    ((FileManagerReporter.FileAssistantReportData)localObject).jdField_a_of_type_Long = paramFileManagerEntity.fileSize;
    ((FileManagerReporter.FileAssistantReportData)localObject).c = FileUtil.a(paramFileManagerEntity.fileName);
    ((FileManagerReporter.FileAssistantReportData)localObject).d = FileManagerUtil.a(paramFileManagerEntity.getCloudType(), paramFileManagerEntity.peerType);
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject);
    localObject = new Bundle();
    ((Bundle)localObject).putInt("forward_type", 0);
    ((Bundle)localObject).putBoolean("not_forward", true);
    ((Bundle)localObject).putParcelable("fileinfo", ForwardFileOption.a(paramFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile));
    ((Bundle)localObject).putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    Intent localIntent = new Intent();
    localIntent.putExtras((Bundle)localObject);
    localIntent.putExtra("forward_text", HardCodeUtil.a(2131704540) + FileManagerUtil.d(paramFileManagerEntity.fileName) + HardCodeUtil.a(2131704541) + FileUtil.a(paramFileManagerEntity.fileSize) + "。");
    localIntent.putExtra("direct_send_if_dataline_forward", true);
    localIntent.putExtra("forward _key_nojump", true);
    localIntent.putExtra("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (!NetworkUtil.d(BaseApplication.getContext())) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131694510, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "6", "", "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 8, 0, "8", "", "", "");
      }
      return;
      ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, 21);
    }
  }
  
  private void c(FileManagerEntity paramFileManagerEntity, ArrayList<Integer> paramArrayList)
  {
    int i = 1;
    if (!QFileBubbleUtils.a(paramFileManagerEntity)) {}
    for (;;)
    {
      return;
      if (this.c)
      {
        this.d = TencentDocConvertConfigProcessor.a().c();
        this.c = false;
      }
      Object localObject = TencentDocImportFileInfoProcessor.a().c();
      long l = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.fileName);
      if ((this.d) && (TeamWorkUtils.a(paramFileManagerEntity.getFilePath(), paramFileManagerEntity.fileName, (String)localObject)))
      {
        if (paramFileManagerEntity.status != 16) {}
        while ((i != 0) && (paramFileManagerEntity.fileSize <= l))
        {
          paramArrayList.add(Integer.valueOf(22));
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
          return;
          if (!TextUtils.isEmpty(paramFileManagerEntity.getFilePath()))
          {
            localObject = new VFSFile(paramFileManagerEntity.getFilePath());
            if ((localObject != null) && (((VFSFile)localObject).exists())) {}
          }
          else
          {
            i = 0;
          }
        }
      }
    }
  }
  
  private void d(FileManagerEntity paramFileManagerEntity)
  {
    try
    {
      paramFileManagerEntity = TestStructMsg.a(TestStructMsg.a(paramFileManagerEntity.getFilePath()));
      if (paramFileManagerEntity != null)
      {
        SessionInfo localSessionInfo = new SessionInfo();
        localSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.frienduin;
        localSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.istroop;
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localSessionInfo, paramFileManagerEntity);
      }
      return;
    }
    catch (Exception paramFileManagerEntity)
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131704538), 1).a();
    }
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
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg) && (!FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {}
    Object localObject2;
    do
    {
      return;
      localObject2 = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
      if (QFileUtils.a((FileManagerEntity)localObject2)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("OfflineFileBubbleModel", 1, "onItemClick: file is forwarding or forward failed, can not open file browser.");
    return;
    Object localObject1 = new FileManagerReporter.FileAssistantReportData();
    ((FileManagerReporter.FileAssistantReportData)localObject1).b = "file_viewer_in";
    ((FileManagerReporter.FileAssistantReportData)localObject1).jdField_a_of_type_Int = 9;
    ((FileManagerReporter.FileAssistantReportData)localObject1).c = FileUtil.a(((FileManagerEntity)localObject2).fileName);
    ((FileManagerReporter.FileAssistantReportData)localObject1).d = FileManagerUtil.a(((FileManagerEntity)localObject2).getCloudType(), ((FileManagerEntity)localObject2).peerType);
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject1);
    FileManagerReporter.a("0X8004AE3");
    if (QRLocalManager.a().a((FileManagerEntity)localObject2))
    {
      QRLocalManager.a().a(this.jdField_a_of_type_AndroidContentContext, ((FileManagerEntity)localObject2).getFilePath(), true);
      return;
    }
    if ((((FileManagerEntity)localObject2).TroopUin != 0L) && (!TextUtils.isEmpty(((FileManagerEntity)localObject2).strTroopFileID)) && (!TextUtils.isEmpty(((FileManagerEntity)localObject2).strTroopFilePath)))
    {
      localObject1 = new ForwardFileInfo();
      ((ForwardFileInfo)localObject1).b(((FileManagerEntity)localObject2).nSessionId);
      ((ForwardFileInfo)localObject1).d(4);
      ((ForwardFileInfo)localObject1).b(10006);
      ((ForwardFileInfo)localObject1).a(((FileManagerEntity)localObject2).getFilePath());
      ((ForwardFileInfo)localObject1).d(((FileManagerEntity)localObject2).fileName);
      ((ForwardFileInfo)localObject1).d(((FileManagerEntity)localObject2).fileSize);
      ((ForwardFileInfo)localObject1).a(((FileManagerEntity)localObject2).TroopUin);
      localObject2 = (Activity)this.jdField_a_of_type_AndroidContentContext;
      Intent localIntent = new Intent((Context)localObject2, TroopFileDetailBrowserActivity.class);
      localIntent.putExtra("fileinfo", (Parcelable)localObject1);
      localIntent.putExtra("removemementity", true);
      localIntent.putExtra("forward_from_troop_file", true);
      localIntent.putExtra("not_forward", true);
      ((Activity)localObject2).startActivityForResult(localIntent, 102);
      return;
    }
    int i = 0;
    if (((FileManagerEntity)localObject2).peerType == 0) {
      i = 1;
    }
    for (;;)
    {
      localObject1 = new CommonFileBrowserParams(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (FileManagerEntity)localObject2, 10004);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("file_browser_extra_params_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      int j = QFileUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg, (Bundle)localObject2, i);
      ((CommonFileBrowserParams)localObject1).a((Bundle)localObject2);
      localObject1 = new FileBrowserCreator(this.jdField_a_of_type_AndroidContentContext, (IFileBrowserParams)localObject1);
      ((FileBrowserCreator)localObject1).a(i);
      QFileUtils.a(i, j, (FileBrowserCreator)localObject1);
      return;
      if (((FileManagerEntity)localObject2).peerType == 3000) {
        i = 5;
      }
    }
  }
  
  private void g()
  {
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
    if (localFileManagerEntity == null)
    {
      QLog.e("OfflineFileBubbleModel", 1, "fetchVideoFileThumb. can not find a FileManagerEntity");
      return;
    }
    if ((FileUtil.b(localFileManagerEntity.getFilePath())) && (FileManagerUtil.c(localFileManagerEntity)))
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
    if (FileUtil.b(localFileManagerEntity.getFilePath()))
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
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return 0;
    }
    return FilePicURLDrawlableHelper.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity).jdField_a_of_type_Int;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return 0L;
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
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
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return "";
    }
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
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
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)) {
        break label41;
      }
    }
    label41:
    int i;
    do
    {
      return;
      i = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      if (i == 2)
      {
        g();
        return;
      }
    } while (i != 0);
    h();
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        do
        {
          return;
          localFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
          switch (paramInt)
          {
          default: 
            return;
          case 2131364899: 
            ((IApolloUtil)QRoute.api(IApolloUtil.class)).replaceCmshow3dResource(localFileManagerEntity.getFilePath());
            return;
          case 2131371954: 
            long l1 = MessageCache.a();
            long l2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.time;
            if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.msgtype == -2005) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.istroop == 3000) && (l1 - l2 > 604800L))
            {
              FMToastUtil.a(HardCodeUtil.a(2131704542));
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80056B1", "0X80056B1", 0, 0, "6", "", "", "");
              return;
            }
            FileManagerReporter.a("0X8005E4B");
            return;
          case 2131365636: 
            ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(localFileManagerEntity);
          }
        } while (FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName) != 0);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "6", "", "", "");
        return;
        a(localFileManagerEntity);
        return;
        c(localFileManagerEntity);
        return;
        ReportController.b(null, "dc00898", "", "", "0X800A60C", "0X800A60C", 0, 0, "", "", "", "");
        if (!NetworkUtil.d(BaseApplication.getContext()))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131694510, 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
          return;
        }
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, this.jdField_a_of_type_AndroidContentContext);
        return;
        new QfavBuilder(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, localFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile, false);
      } while (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
      return;
      TeamWorkConvertUtils.a(localFileManagerEntity, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
    } while (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isMultiMsg);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D69", "0X8009D69", 0, 0, "", "", "", "");
    return;
    b(localFileManagerEntity);
    return;
    d(localFileManagerEntity);
    return;
    e(localFileManagerEntity);
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
    int i = 11;
    switch (FileManagerUtil.a(localFileManagerEntity.fileName))
    {
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A68B", "0X800A68B", i, 0, "4", "", "", "");
      if (paramInt != 1) {
        break;
      }
      f();
      return;
      i = 0;
      continue;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
      continue;
      i = 6;
      continue;
      i = 7;
      continue;
      i = 8;
      continue;
      i = 9;
      continue;
      i = 10;
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
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      QLog.e("OfflineFileBubbleModel", 1, "setBubbleModelData. can not find a FileManagerEntity");
      return;
    }
    FileManagerUtil.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile.isSend();
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    long l = 604800L;
    if (paramInt == 3000) {
      l = 1296000L;
    }
    paramLong = (MessageCache.a() * 1000L - paramLong) / 1000L;
    return (paramLong > 0L) && (paramLong > l);
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return 0;
    }
    return FilePicURLDrawlableHelper.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity).b;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {}
    long l;
    do
    {
      do
      {
        do
        {
          return 0L;
        } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 0);
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 16) {
          return -1L;
        }
      } while (FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath()));
      l = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.srvTime;
      l = (MessageCache.a() * 1000L - l) / 1000L;
    } while (l <= 0L);
    if (l > 604800L) {
      return -1L;
    }
    return 604800L - l;
  }
  
  public String b()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile == null) {
      localObject = "";
    }
    FileManagerEntity localFileManagerEntity;
    int i;
    do
    {
      String str;
      do
      {
        do
        {
          return localObject;
          localFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
          if (localFileManagerEntity == null) {
            return "";
          }
          localObject = localFileManagerEntity.strMiddleThumPath;
          i = FileManagerUtil.a(localFileManagerEntity.fileName);
          if (i != 0) {
            break;
          }
          str = localFileManagerEntity.strMiddleThumPath;
          localObject = str;
        } while (FileUtil.b(str));
        localObject = str;
      } while (!FileUtil.b(localFileManagerEntity.strLargeThumPath));
      if (FilePicURLDrawlableHelper.a(localFileManagerEntity))
      {
        ThreadManagerV2.executeOnSubThread(new OfflineFileBubbleModel.1(this, localFileManagerEntity));
        return str;
      }
      return localFileManagerEntity.strLargeThumPath;
    } while (i != 2);
    return localFileManagerEntity.strLargeThumPath;
  }
  
  public List<Integer> b(int paramInt)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile == null) {
      localObject = new ArrayList();
    }
    ArrayList localArrayList;
    do
    {
      FileManagerEntity localFileManagerEntity;
      do
      {
        return localObject;
        localFileManagerEntity = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
        localArrayList = new ArrayList();
        localObject = localArrayList;
      } while (!QFileBubbleUtils.a(localFileManagerEntity));
      localArrayList.add(Integer.valueOf(9));
      localObject = localArrayList;
    } while (AIOUtils.a(5) != 1);
    localArrayList.add(Integer.valueOf(18));
    return localArrayList;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(str))
    {
      ReportController.b(null, "dc00898", "", "", "0X800A686", "0X800A686", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(str);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a();
  }
  
  public boolean b()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              if (FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName) != 2) {
                break;
              }
            } while ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isSend()) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 0));
            return true;
            switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status)
            {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 9: 
            case 12: 
            case 13: 
            case 15: 
            default: 
              return false;
            }
          } while ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 0) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isSend() != true) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bOnceSuccess));
          return true;
        } while (13 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType);
        return false;
        if (10 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      } while (13 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType);
      return false;
    } while ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isSend()) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bOnceSuccess));
    return true;
  }
  
  public int c()
  {
    int j = 6;
    int k = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null)
    {
      j = 0;
      return j;
    }
    boolean bool = a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.srvTime);
    int i = k;
    switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status)
    {
    default: 
      i = k;
    }
    while (!bool)
    {
      return i;
      if (bool)
      {
        i = 6;
      }
      else
      {
        i = 1;
        continue;
        i = 1;
        continue;
        i = 3;
        continue;
        i = k;
        if (9 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType)
        {
          i = 3;
          continue;
          i = 2;
          continue;
          i = 4;
        }
      }
    }
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
    return this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131698225);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return;
    }
    String str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131692384);
    String str2 = this.jdField_a_of_type_AndroidContentContext.getString(2131692383);
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    localActionSheet.addButton(str1);
    localActionSheet.addCancelButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690800));
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
    switch (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status)
    {
    default: 
    case 1: 
    case 2: 
    case 14: 
    case 15: 
      do
      {
        do
        {
          do
          {
            return 0;
            if (!bool) {
              break;
            }
          } while (!FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath()));
          return 2;
        } while (!FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath()));
        return 5;
        if (bool) {
          return 1;
        }
        return 4;
      } while (9 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType);
      return 1;
    }
    if (bool)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bOnceSuccess) {
        return 6;
      }
      return 3;
    }
    return 6;
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return 0;
    }
    return (int)(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress * 100.0F);
  }
  
  public int f()
  {
    int j = 1;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      i = 0;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgWidth, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.imgHeight, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize));
      i = j;
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.thumbInvalidCode == 1);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.thumbInvalidCode == 2) {
      return 2;
    }
    return super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.OfflineFileBubbleModel
 * JD-Core Version:    0.7.0.1
 */