package com.tencent.mobileqq.filemanager.bubble;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoBean;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoProcessor;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.aioitem.QFileBubbleDownloadHandler;
import com.tencent.mobileqq.filemanager.aioitem.QFileBubblePauseHandler;
import com.tencent.mobileqq.filemanager.aioitem.TroopFileBubbleDownloadHandler;
import com.tencent.mobileqq.filemanager.aioitem.TroopFileBubblePauseHandler;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqreader.QRLocalManager;
import cooperation.troop.TroopFileProxyActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.jetbrains.annotations.Nullable;

public class TroopFileBubbleModel
  extends QFileBubbleModel
{
  private MessageForTroopFile jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile;
  private boolean jdField_a_of_type_Boolean = true;
  private boolean c;
  
  public TroopFileBubbleModel(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void a(int paramInt, TroopFileStatusInfo paramTroopFileStatusInfo, ArrayList<Integer> paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return;
    }
    long l = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopFileStatusInfo.g);
    paramArrayList.add(Integer.valueOf(9));
    paramArrayList.add(Integer.valueOf(10));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(paramTroopFileStatusInfo, false))) {
      paramArrayList.add(Integer.valueOf(22));
    }
    paramArrayList.add(Integer.valueOf(21));
    if (e()) {
      paramArrayList.add(Integer.valueOf(15));
    }
    if (paramInt == 1) {
      paramArrayList.add(Integer.valueOf(20));
    }
    paramArrayList.add(Integer.valueOf(16));
    if (d()) {
      paramArrayList.add(Integer.valueOf(18));
    }
    paramArrayList.add(Integer.valueOf(11));
    paramArrayList.add(Integer.valueOf(12));
  }
  
  private void a(long paramLong, Activity paramActivity, UUID paramUUID)
  {
    paramUUID = new TroopFileBubbleModel.1(this, paramLong, paramUUID, paramActivity);
    DialogUtil.a(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131697264), this.jdField_a_of_type_AndroidContentContext.getString(2131697292), 2131697262, 2131697279, paramUUID, paramUUID).show();
  }
  
  private void a(long paramLong, Activity paramActivity, UUID paramUUID, ChatMessage paramChatMessage)
  {
    paramUUID = new TroopFileBubbleModel.2(this, paramLong, paramUUID, paramChatMessage, paramActivity);
    DialogUtil.a(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131697268), this.jdField_a_of_type_AndroidContentContext.getString(2131697293), 2131697266, 2131697281, paramUUID, paramUUID).show();
  }
  
  private void a(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) && (!FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {
      return;
    }
    TroopFileStatusInfo localTroopFileStatusInfo = a();
    if (localTroopFileStatusInfo == null)
    {
      QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
      return;
    }
    switch (localTroopFileStatusInfo.jdField_b_of_type_Int)
    {
    case 4: 
    case 5: 
    default: 
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "Grp_AIO", "clk_picBubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
      PicItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, true, true, null);
      return;
    }
    paramView = new Intent();
    paramView.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    TroopFileProxyActivity.b((Activity)this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  private void a(TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(paramTroopFileStatusInfo);
    paramTroopFileStatusInfo = TroopFileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopFileStatusInfo.jdField_b_of_type_Long).a(localFileManagerEntity.strTroopFilePath);
    if (paramTroopFileStatusInfo != null)
    {
      localFileManagerEntity.lastTime = paramTroopFileStatusInfo.c;
      localFileManagerEntity.selfUin = String.valueOf(paramTroopFileStatusInfo.jdField_b_of_type_Long);
    }
    new QfavBuilder(3).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, localFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, false);
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
    }
  }
  
  private void a(TroopFileStatusInfo paramTroopFileStatusInfo, int paramInt)
  {
    if (paramInt == 0)
    {
      TroopFileError.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131697610));
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 0);
    Object localObject = FileManagerUtil.a(paramTroopFileStatusInfo);
    ((FileManagerEntity)localObject).status = 2;
    ((FileManagerEntity)localObject).nOpType = 24;
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(((FileManagerEntity)localObject).nSessionId);
    localForwardFileInfo.b(10006);
    if (!TextUtils.isEmpty(((FileManagerEntity)localObject).getFilePath())) {
      localForwardFileInfo.a(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString);
    }
    localForwardFileInfo.d(paramTroopFileStatusInfo.g);
    localForwardFileInfo.d(paramTroopFileStatusInfo.jdField_c_of_type_Long);
    localForwardFileInfo.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin));
    if (paramTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID != null) {
      localForwardFileInfo.e(paramTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID.toString());
    }
    if (!TextUtils.isEmpty(paramTroopFileStatusInfo.jdField_c_of_type_JavaLangString)) {
      localForwardFileInfo.f(paramTroopFileStatusInfo.jdField_c_of_type_JavaLangString);
    }
    for (;;)
    {
      localForwardFileInfo.d(1);
      localForwardFileInfo.a(1);
      localBundle.putParcelable("fileinfo", localForwardFileInfo);
      localBundle.putBoolean("not_forward", true);
      localObject = new Intent();
      ((Intent)localObject).putExtras(localBundle);
      ((Intent)localObject).putExtra("forward_text", paramTroopFileStatusInfo.g);
      ((Intent)localObject).putExtra("forward_from_troop_file", true);
      localBundle.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      ((Intent)localObject).putExtra("direct_send_if_dataline_forward", true);
      ((Intent)localObject).putExtra("forward _key_nojump", true);
      ((Intent)localObject).putExtra("sender_uin", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin);
      ((Intent)localObject).putExtra("last_time", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime);
      ForwardBaseOption.a((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject, 21);
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D66", "0X8009D66", 8, 0, "8", "", "", "");
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
      return;
      if (!TextUtils.isEmpty(paramTroopFileStatusInfo.jdField_d_of_type_JavaLangString)) {
        localForwardFileInfo.f(paramTroopFileStatusInfo.jdField_d_of_type_JavaLangString);
      }
    }
  }
  
  private void a(TroopFileTransferManager paramTroopFileTransferManager, TroopFileStatusInfo paramTroopFileStatusInfo, int paramInt)
  {
    if (paramInt == 0) {
      TroopFileError.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131697610));
    }
    while ((paramTroopFileStatusInfo.jdField_b_of_type_Int != 1) && (paramTroopFileStatusInfo.jdField_b_of_type_Int != 0) && (paramTroopFileStatusInfo.jdField_b_of_type_Int != 2) && (paramTroopFileStatusInfo.jdField_b_of_type_Int != 3)) {
      return;
    }
    paramTroopFileTransferManager.a(paramTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
    a(paramTroopFileStatusInfo.jdField_b_of_type_Long, (Activity)this.jdField_a_of_type_AndroidContentContext, paramTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
  }
  
  private void a(ArrayList<Integer> paramArrayList)
  {
    paramArrayList.add(Integer.valueOf(3));
    paramArrayList.add(Integer.valueOf(10));
    if (e()) {
      paramArrayList.add(Integer.valueOf(15));
    }
    paramArrayList.add(Integer.valueOf(16));
  }
  
  private boolean a(MessageForTroopFile paramMessageForTroopFile)
  {
    boolean bool2 = false;
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForTroopFile);
    if (localTroopFileStatusInfo == null) {}
    boolean bool1;
    do
    {
      return true;
      bool1 = bool2;
      if (paramMessageForTroopFile.lastTime != 0L)
      {
        bool1 = bool2;
        if (paramMessageForTroopFile.lastTime <= NetConnInfoCenter.getServerTime()) {
          bool1 = true;
        }
      }
    } while (localTroopFileStatusInfo.jdField_b_of_type_Int == 12);
    return bool1;
  }
  
  private boolean a(TroopFileStatusInfo paramTroopFileStatusInfo, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = TencentDocConvertConfigProcessor.a().c();
      this.jdField_a_of_type_Boolean = false;
    }
    long l1 = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopFileStatusInfo.g);
    String str2 = TencentDocImportFileInfoProcessor.a().c();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = TeamWorkUtils.jdField_a_of_type_JavaLangString;
    }
    long l2 = FileManagerUtil.a(paramTroopFileStatusInfo.jdField_e_of_type_JavaLangString);
    boolean bool1 = bool2;
    int i;
    if (this.jdField_c_of_type_Boolean)
    {
      bool1 = bool2;
      if (TeamWorkUtils.a(paramTroopFileStatusInfo.jdField_e_of_type_JavaLangString, paramTroopFileStatusInfo.g, str1))
      {
        bool1 = bool2;
        if (l2 <= l1)
        {
          if (!paramBoolean) {
            break label189;
          }
          if (TextUtils.isEmpty(paramTroopFileStatusInfo.jdField_e_of_type_JavaLangString)) {
            break label184;
          }
          if (FileUtils.b(paramTroopFileStatusInfo.jdField_e_of_type_JavaLangString)) {
            break label189;
          }
          i = 0;
        }
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i != 0)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
        bool1 = true;
      }
      return bool1;
      label184:
      i = 0;
      continue;
      label189:
      i = 1;
    }
  }
  
  private void b(int paramInt, TroopFileStatusInfo paramTroopFileStatusInfo, ArrayList<Integer> paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    do
    {
      return;
      long l = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopFileStatusInfo.g);
      paramArrayList.add(Integer.valueOf(9));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(paramTroopFileStatusInfo, false))) {
        paramArrayList.add(Integer.valueOf(22));
      }
      if (e()) {
        paramArrayList.add(Integer.valueOf(15));
      }
      paramArrayList.add(Integer.valueOf(21));
      paramArrayList.add(Integer.valueOf(10));
      paramArrayList.add(Integer.valueOf(11));
      paramArrayList.add(Integer.valueOf(12));
      if (paramInt == 1) {
        paramArrayList.add(Integer.valueOf(20));
      }
      paramArrayList.add(Integer.valueOf(16));
    } while (!d());
    paramArrayList.add(Integer.valueOf(18));
  }
  
  private void b(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) && (!FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {}
    TroopFileStatusInfo localTroopFileStatusInfo;
    TroopFileItemOperation localTroopFileItemOperation;
    long l;
    do
    {
      return;
      localTroopFileStatusInfo = a();
      if (localTroopFileStatusInfo == null)
      {
        QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
        return;
      }
      localTroopFileItemOperation = new TroopFileItemOperation(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
      l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin).longValue();
      paramView = AnimationUtils.a(paramView);
      if (localTroopFileStatusInfo.jdField_b_of_type_Int == 12)
      {
        paramView = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131697311), new Object[] { TroopFileUtils.a(localTroopFileStatusInfo.g) });
        TroopFileError.a(this.jdField_a_of_type_AndroidContentContext, paramView, 1);
        return;
      }
    } while ((localTroopFileStatusInfo.jdField_b_of_type_Int == 4) || (localTroopFileStatusInfo.jdField_b_of_type_Int == 5) || (localTroopFileStatusInfo.jdField_b_of_type_Int == 13));
    if (((localTroopFileStatusInfo.jdField_b_of_type_Int == 3) || (localTroopFileStatusInfo.jdField_b_of_type_Int == 2)) && (!FileManagerUtil.a()))
    {
      localTroopFileItemOperation.a(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "Grp_AIO", "clk_videoBubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
    if (a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile))
    {
      paramView = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131697311), new Object[] { TroopFileUtils.a(localTroopFileStatusInfo.g) });
      TroopFileError.a(this.jdField_a_of_type_AndroidContentContext, paramView, 1);
      return;
    }
    QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, l, localTroopFileStatusInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime, 3, 3, paramView, false, false);
  }
  
  private void b(TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    if (paramTroopFileStatusInfo == null) {}
    do
    {
      return;
      TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
      localTeamWorkFileImportInfo.jdField_c_of_type_JavaLangString = paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString;
      localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = paramTroopFileStatusInfo.g;
      localTeamWorkFileImportInfo.j = FileManagerUtil.a(paramTroopFileStatusInfo.g);
      localTeamWorkFileImportInfo.jdField_b_of_type_Boolean = true;
      localTeamWorkFileImportInfo.jdField_d_of_type_Int = 1;
      localTeamWorkFileImportInfo.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize;
      localTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString = paramTroopFileStatusInfo.jdField_e_of_type_JavaLangString;
      localTeamWorkFileImportInfo.jdField_b_of_type_Int = paramTroopFileStatusInfo.h;
      localTeamWorkFileImportInfo.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
      localTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (paramTroopFileStatusInfo.jdField_b_of_type_Int != 12) {
        localTeamWorkFileImportInfo.jdField_a_of_type_Boolean = true;
      }
      localTeamWorkFileImportInfo.jdField_a_of_type_Int = 1;
      TeamWorkConvertUtils.a(localTeamWorkFileImportInfo, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTeamWorkFileImportInfo.jdField_d_of_type_Int);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
    } while (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D69", "0X8009D69", 0, 0, "", "", "", "");
  }
  
  private void b(ArrayList<Integer> paramArrayList)
  {
    paramArrayList.add(Integer.valueOf(3));
    paramArrayList.add(Integer.valueOf(9));
    paramArrayList.add(Integer.valueOf(10));
    if (e()) {
      paramArrayList.add(Integer.valueOf(15));
    }
    paramArrayList.add(Integer.valueOf(21));
    paramArrayList.add(Integer.valueOf(16));
    if (d()) {
      paramArrayList.add(Integer.valueOf(18));
    }
  }
  
  private void c(int paramInt, TroopFileStatusInfo paramTroopFileStatusInfo, ArrayList<Integer> paramArrayList)
  {
    long l = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopFileStatusInfo.g);
    if (!FileUtil.a(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString)) {
      TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin)).b();
    }
    do
    {
      return;
      if ((!TextUtils.isEmpty(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString)) && (FileUtils.f(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString))) {
        paramArrayList.add(Integer.valueOf(14));
      }
      paramArrayList.add(Integer.valueOf(9));
      paramArrayList.add(Integer.valueOf(10));
      paramArrayList.add(Integer.valueOf(11));
      paramArrayList.add(Integer.valueOf(12));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(paramTroopFileStatusInfo, false))) {
        paramArrayList.add(Integer.valueOf(22));
      }
      if (e()) {
        paramArrayList.add(Integer.valueOf(15));
      }
      paramArrayList.add(Integer.valueOf(21));
      if (paramInt == 1) {
        paramArrayList.add(Integer.valueOf(20));
      }
      paramArrayList.add(Integer.valueOf(16));
    } while (!d());
    paramArrayList.add(Integer.valueOf(18));
  }
  
  private void c(ArrayList<Integer> paramArrayList)
  {
    paramArrayList.add(Integer.valueOf(9));
    paramArrayList.add(Integer.valueOf(10));
    if (e()) {
      paramArrayList.add(Integer.valueOf(15));
    }
    paramArrayList.add(Integer.valueOf(21));
    paramArrayList.add(Integer.valueOf(16));
    if (d()) {
      paramArrayList.add(Integer.valueOf(18));
    }
  }
  
  private void d(int paramInt, TroopFileStatusInfo paramTroopFileStatusInfo, ArrayList<Integer> paramArrayList)
  {
    paramArrayList.add(Integer.valueOf(9));
    if (d()) {
      paramArrayList.add(Integer.valueOf(18));
    }
  }
  
  private boolean d()
  {
    return AIOUtils.a(5) == 1;
  }
  
  private void e(int paramInt, TroopFileStatusInfo paramTroopFileStatusInfo, ArrayList<Integer> paramArrayList)
  {
    long l = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopFileStatusInfo.g);
    paramArrayList.add(Integer.valueOf(9));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(paramTroopFileStatusInfo, false))) {
      paramArrayList.add(Integer.valueOf(22));
    }
    if (d()) {
      paramArrayList.add(Integer.valueOf(18));
    }
  }
  
  private boolean e()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile));
  }
  
  private void f()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin + "", "", "", "");
    Object localObject = a();
    if (((TroopFileStatusInfo)localObject).jdField_b_of_type_Int == 12)
    {
      localObject = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131697311), new Object[] { TroopFileUtils.a(((TroopFileStatusInfo)localObject).g) });
      TroopFileError.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject, 1);
      return;
    }
    Intent localIntent = new Intent();
    if (QRLocalManager.a().a(((TroopFileStatusInfo)localObject).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize))
    {
      QRLocalManager.a().a(this.jdField_a_of_type_AndroidContentContext, ((TroopFileStatusInfo)localObject).jdField_a_of_type_JavaLangString, true);
      return;
    }
    switch (((TroopFileStatusInfo)localObject).jdField_b_of_type_Int)
    {
    case 0: 
    case 4: 
    case 5: 
    default: 
      return;
    case 1: 
    case 2: 
    case 3: 
      localIntent.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
      TroopFileProxyActivity.b((Activity)this.jdField_a_of_type_AndroidContentContext, localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      return;
    }
    long l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
    QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, l, (TroopFileStatusInfo)localObject, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime, 3, 3, null, false, false);
  }
  
  private void f(int paramInt, TroopFileStatusInfo paramTroopFileStatusInfo, ArrayList<Integer> paramArrayList)
  {
    long l = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopFileStatusInfo.g);
    paramArrayList.add(Integer.valueOf(9));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(paramTroopFileStatusInfo, false))) {
      paramArrayList.add(Integer.valueOf(22));
    }
    if (d()) {
      paramArrayList.add(Integer.valueOf(18));
    }
  }
  
  private void g()
  {
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    String str2 = "2";
    String str1 = str2;
    if (localTroopInfo != null)
    {
      if ((localTroopInfo.troopowneruin != null) && (localTroopInfo.troopowneruin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        str1 = "1";
      }
    }
    else
    {
      if (FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName) != 0) {
        break label147;
      }
      str2 = "1";
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "remove_file", "remove_clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", str1, str2);
      return;
      str1 = str2;
      if (localTroopInfo.Administrator == null) {
        break;
      }
      str1 = str2;
      if (!localTroopInfo.Administrator.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break;
      }
      str1 = "2";
      break;
      label147:
      if (FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName) == 2) {
        str2 = "2";
      } else {
        str2 = "3";
      }
    }
  }
  
  private void g(int paramInt, TroopFileStatusInfo paramTroopFileStatusInfo, ArrayList<Integer> paramArrayList)
  {
    long l = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopFileStatusInfo.g);
    if (!FileUtil.a(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString)) {
      TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin)).b();
    }
    do
    {
      return;
      paramArrayList.add(Integer.valueOf(9));
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize <= l) && (a(paramTroopFileStatusInfo, false))) {
        paramArrayList.add(Integer.valueOf(22));
      }
    } while (!d());
    paramArrayList.add(Integer.valueOf(18));
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.width;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    TroopFileStatusInfo localTroopFileStatusInfo;
    do
    {
      return 0L;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize > 0L) {
        return this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize;
      }
      localTroopFileStatusInfo = a();
    } while (localTroopFileStatusInfo == null);
    return localTroopFileStatusInfo.jdField_c_of_type_Long;
  }
  
  public QFileBubbleDownloadHandler a()
  {
    return new TroopFileBubbleDownloadHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
  }
  
  public QFileBubblePauseHandler a()
  {
    return new TroopFileBubblePauseHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
  }
  
  @Nullable
  public TroopFileStatusInfo a()
  {
    return TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return "";
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName;
    }
    TroopFileStatusInfo localTroopFileStatusInfo = a();
    if (localTroopFileStatusInfo == null) {
      return "";
    }
    return localTroopFileStatusInfo.g;
  }
  
  public List<Integer> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return localArrayList;
    }
    TroopFileStatusInfo localTroopFileStatusInfo = a();
    if (localTroopFileStatusInfo == null) {
      return localArrayList;
    }
    if (((QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (FileUtil.b(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString))) && (localTroopFileStatusInfo.jdField_b_of_type_Int != 12) && (FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName) == 2)) {
      localArrayList.add(Integer.valueOf(13));
    }
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopFileStatusInfo.g);
    Boolean localBoolean2 = Boolean.valueOf(false);
    Boolean localBoolean1 = localBoolean2;
    switch (localTroopFileStatusInfo.jdField_b_of_type_Int)
    {
    default: 
      localBoolean1 = localBoolean2;
    case 4: 
      if (localBoolean1.booleanValue()) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_press_files", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
      }
      break;
    }
    for (;;)
    {
      localArrayList.add(Integer.valueOf(19));
      return localArrayList;
      localArrayList.add(Integer.valueOf(7));
      localArrayList.add(Integer.valueOf(6));
      localBoolean1 = Boolean.valueOf(true);
      break;
      localArrayList.add(Integer.valueOf(8));
      localArrayList.add(Integer.valueOf(6));
      localBoolean1 = Boolean.valueOf(true);
      break;
      c(localArrayList);
      localBoolean1 = localBoolean2;
      break;
      b(localArrayList);
      localBoolean1 = localBoolean2;
      break;
      a(localArrayList);
      localBoolean1 = localBoolean2;
      break;
      b(paramInt, localTroopFileStatusInfo, localArrayList);
      localBoolean1 = Boolean.valueOf(true);
      break;
      c(paramInt, localTroopFileStatusInfo, localArrayList);
      localBoolean1 = localBoolean2;
      break;
      a(paramInt, localTroopFileStatusInfo, localArrayList);
      localBoolean1 = localBoolean2;
      break;
      localArrayList.add(Integer.valueOf(16));
      localBoolean1 = localBoolean2;
      break;
      localArrayList.add(Integer.valueOf(16));
      localBoolean1 = localBoolean2;
      break;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_press_files", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
    }
  }
  
  public void a()
  {
    int j = 383;
    if (this.jdField_b_of_type_Boolean)
    {
      e();
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileBubbleModel", 1, "fetchFileThumb.");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile != null) {
        break label38;
      }
    }
    label38:
    TroopFileTransferManager localTroopFileTransferManager;
    TroopFileStatusInfo localTroopFileStatusInfo;
    int i;
    for (;;)
    {
      return;
      localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin));
      localTroopFileStatusInfo = a();
      if (localTroopFileStatusInfo != null)
      {
        if (FileUtil.b(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString)) {
          i = j;
        }
        while (localTroopFileStatusInfo.jdField_b_of_type_Int != 12)
        {
          if (localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID == null) {
            break label152;
          }
          localTroopFileTransferManager.a(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID, i);
          return;
          i = j;
          if (FilePicURLDrawlableHelper.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.width, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.height))
          {
            i = j;
            if (!FileUtil.b(localTroopFileStatusInfo.jdField_c_of_type_JavaLangString)) {
              i = 640;
            }
          }
        }
      }
    }
    label152:
    localTroopFileTransferManager.a(localTroopFileStatusInfo.jdField_e_of_type_JavaLangString, localTroopFileStatusInfo.g, localTroopFileStatusInfo.h, i);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    TroopFileTransferManager localTroopFileTransferManager;
    TroopFileStatusInfo localTroopFileStatusInfo;
    int i;
    TroopFileItemOperation localTroopFileItemOperation;
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
              return;
              localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin));
            } while (localTroopFileTransferManager == null);
            localTroopFileStatusInfo = a();
          } while (localTroopFileStatusInfo == null);
          i = NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext);
          localTroopFileItemOperation = new TroopFileItemOperation(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
          switch (paramInt)
          {
          default: 
            return;
          }
        } while ((localTroopFileStatusInfo.jdField_b_of_type_Int != 8) && (localTroopFileStatusInfo.jdField_b_of_type_Int != 9) && (localTroopFileStatusInfo.jdField_b_of_type_Int != 10));
        localTroopFileTransferManager.d(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
        a(localTroopFileStatusInfo.jdField_b_of_type_Long, (Activity)this.jdField_a_of_type_AndroidContentContext, localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
        return;
        if (i == 0)
        {
          TroopFileError.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131697610));
          return;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_pause_upload", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
      } while ((localTroopFileStatusInfo.jdField_b_of_type_Int != 0) && (localTroopFileStatusInfo.jdField_b_of_type_Int != 1));
      localTroopFileTransferManager.a(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
      return;
    } while ((localTroopFileStatusInfo.jdField_b_of_type_Int != 2) && (localTroopFileStatusInfo.jdField_b_of_type_Int != 3));
    localTroopFileItemOperation.a(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
    return;
    a(localTroopFileTransferManager, localTroopFileStatusInfo, i);
    return;
    a(localTroopFileStatusInfo, i);
    return;
    TroopFileUtils.b((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    return;
    FileManagerUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, localTroopFileStatusInfo.jdField_a_of_type_JavaLangString);
    return;
    ReportController.b(null, "dc00898", "", "", "0X800A60C", "0X800A60C", 0, 0, "", "", "", "");
    TroopFileUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    return;
    a(localTroopFileStatusInfo);
    return;
    g();
    return;
    b(localTroopFileStatusInfo);
    return;
    ReportController.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 3, 0, "", "", "", "");
    QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, localTroopFileStatusInfo.jdField_b_of_type_Long, localTroopFileStatusInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime, 3, 3, null, true, false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if (QLog.isColorLevel()) {
      QLog.i("TroopFileBubbleModel", 1, "fixMediaWidthAndHeight " + paramInt1 + ":" + paramInt2);
    }
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.width = paramInt1;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.height = paramInt2;
    }
  }
  
  public void a(int paramInt, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return;
    }
    TroopFileStatusInfo localTroopFileStatusInfo = a();
    if (localTroopFileStatusInfo == null)
    {
      QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
      return;
    }
    int i = 11;
    switch (FileManagerUtil.a(localTroopFileStatusInfo.g))
    {
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A68A", "0X800A68A", i, 0, "4", "", "", "");
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
      a(paramView);
      return;
    }
    if (paramInt == 3)
    {
      b(paramView);
      return;
    }
    f();
  }
  
  protected void a(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForTroopFile))
    {
      QLog.e("TroopFileBubbleModel", 1, "setBubbleModelData. is not a MessageForTroopFile");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile = ((MessageForTroopFile)paramChatMessage);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isSend();
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.height;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    long l;
    do
    {
      return 0L;
      if (a().jdField_b_of_type_Int == 12) {
        return -1L;
      }
      l = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime;
    } while (l == 0L);
    l -= MessageCache.a();
    if (l > 0L) {
      return l;
    }
    return -1L;
  }
  
  public String b()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = a();
    if (localTroopFileStatusInfo == null) {
      return "";
    }
    if (FileUtils.b(localTroopFileStatusInfo.jdField_d_of_type_JavaLangString)) {
      return localTroopFileStatusInfo.jdField_d_of_type_JavaLangString;
    }
    if (FileUtils.b(localTroopFileStatusInfo.jdField_c_of_type_JavaLangString)) {
      return localTroopFileStatusInfo.jdField_c_of_type_JavaLangString;
    }
    return "";
  }
  
  public List<Integer> b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    TroopFileStatusInfo localTroopFileStatusInfo;
    do
    {
      do
      {
        return localArrayList;
        localTroopFileStatusInfo = a();
      } while (localTroopFileStatusInfo == null);
      if (((QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (FileUtil.b(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString))) && (localTroopFileStatusInfo != null) && (localTroopFileStatusInfo.jdField_b_of_type_Int != 12) && (FileManagerUtil.a(localTroopFileStatusInfo.g) == 2)) {
        localArrayList.add(Integer.valueOf(13));
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localTroopFileStatusInfo.g);
      switch (localTroopFileStatusInfo.jdField_b_of_type_Int)
      {
      case 0: 
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 10: 
      case 12: 
      default: 
        return localArrayList;
      case 6: 
        e(paramInt, localTroopFileStatusInfo, localArrayList);
        return localArrayList;
      case 8: 
        localArrayList.add(Integer.valueOf(9));
      }
    } while (!d());
    localArrayList.add(Integer.valueOf(18));
    return localArrayList;
    d(paramInt, localTroopFileStatusInfo, localArrayList);
    return localArrayList;
    g(paramInt, localTroopFileStatusInfo, localArrayList);
    return localArrayList;
    f(paramInt, localTroopFileStatusInfo, localArrayList);
    return localArrayList;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.url;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(str))
    {
      ReportController.b(null, "dc00898", "", "", "0X800A685", "0X800A685", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a(str);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a();
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    while (a().jdField_b_of_type_Int != 3) {
      return false;
    }
    return true;
  }
  
  public int c()
  {
    int i = 3;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return 0;
    }
    TroopFileStatusInfo localTroopFileStatusInfo = a();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime != 0L) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime <= NetConnInfoCenter.getServerTime())) {
      return 6;
    }
    if (localTroopFileStatusInfo.jdField_b_of_type_Int == 12) {
      return 1;
    }
    switch (localTroopFileStatusInfo.jdField_b_of_type_Int)
    {
    case 4: 
    default: 
      i = 0;
    }
    for (;;)
    {
      return i;
      i = 0;
      continue;
      i = 2;
      continue;
      i = 4;
      continue;
      i = 5;
      continue;
      i = 2;
      continue;
      i = 2;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    do
    {
      return;
      localObject = a();
    } while ((localObject == null) || (((TroopFileStatusInfo)localObject).jdField_b_of_type_Int != 3));
    Object localObject = (Activity)this.jdField_a_of_type_AndroidContentContext;
    Intent localIntent = new Intent();
    localIntent.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    TroopFileProxyActivity.b((Activity)localObject, localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public boolean c()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    TroopFileStatusInfo localTroopFileStatusInfo;
    do
    {
      return false;
      localTroopFileStatusInfo = a();
    } while ((localTroopFileStatusInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg));
    int i = FileManagerUtil.a(localTroopFileStatusInfo.g);
    if ((i == 2) || (i == 0))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isSend()) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
    return true;
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return -1;
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isSend();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) {
      bool = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    }
    TroopFileStatusInfo localTroopFileStatusInfo = a();
    switch (localTroopFileStatusInfo.jdField_b_of_type_Int)
    {
    case 2: 
    case 4: 
    case 5: 
    case 7: 
    case 9: 
    default: 
    case 0: 
    case 1: 
    case 6: 
    case 8: 
    case 11: 
      do
      {
        do
        {
          do
          {
            return 0;
            return 1;
          } while (!FileUtils.b(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString));
          return 2;
          return 4;
          if (!bool) {
            break;
          }
        } while (!FileUtils.b(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString));
        return 2;
      } while (!FileUtils.b(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString));
      return 5;
    case 3: 
      return 3;
    }
    return 6;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_AndroidContentContext.getString(2131697202);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return;
    }
    Activity localActivity = (Activity)this.jdField_a_of_type_AndroidContentContext;
    Intent localIntent = new Intent();
    localIntent.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    TroopFileProxyActivity.a(localActivity, localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {}
    TroopFileStatusInfo localTroopFileStatusInfo;
    do
    {
      return 0;
      localTroopFileStatusInfo = a();
    } while (localTroopFileStatusInfo == null);
    return TroopFileUtils.a(localTroopFileStatusInfo.jdField_d_of_type_Long, localTroopFileStatusInfo.jdField_c_of_type_Long);
  }
  
  public int f()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = a();
    if (localTroopFileStatusInfo == null) {}
    while (localTroopFileStatusInfo.jdField_c_of_type_Boolean) {
      return 0;
    }
    if (QFileUtils.a(localTroopFileStatusInfo.jdField_e_of_type_Int, localTroopFileStatusInfo.f, localTroopFileStatusInfo.jdField_c_of_type_Long)) {
      return 1;
    }
    if (localTroopFileStatusInfo.j == 1) {
      return 1;
    }
    if (localTroopFileStatusInfo.j == 2) {
      return 2;
    }
    return super.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.TroopFileBubbleModel
 * JD-Core Version:    0.7.0.1
 */