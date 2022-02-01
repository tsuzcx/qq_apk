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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkConvertUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
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
import cooperation.troop.TroopFileProxyActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import mqq.app.AppRuntime;
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
    long l = FileManagerUtil.b(paramTroopFileStatusInfo.g);
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
    DialogUtil.a(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131697283), this.jdField_a_of_type_AndroidContentContext.getString(2131697311), 2131697281, 2131697298, paramUUID, paramUUID).show();
  }
  
  private void a(long paramLong, Activity paramActivity, UUID paramUUID, ChatMessage paramChatMessage)
  {
    paramUUID = new TroopFileBubbleModel.2(this, paramLong, paramUUID, paramChatMessage, paramActivity);
    DialogUtil.a(paramActivity, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131697287), this.jdField_a_of_type_AndroidContentContext.getString(2131697312), 2131697285, 2131697300, paramUUID, paramUUID).show();
  }
  
  private void a(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) && (!FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext))) {
      return;
    }
    Object localObject = a();
    if (localObject == null)
    {
      QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
      return;
    }
    int i = ((TroopFileStatusInfo)localObject).jdField_b_of_type_Int;
    if ((i != 0) && (i != 1) && (i != 2) && (i != 3))
    {
      if ((i != 4) && (i != 5))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
        localStringBuilder.append("");
        ReportController.b((AppRuntime)localObject, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, localStringBuilder.toString(), "", "", "");
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
        localStringBuilder.append("");
        ReportController.b((AppRuntime)localObject, "dc00899", "Grp_files", "", "Grp_AIO", "clk_picBubble", 0, 0, localStringBuilder.toString(), "", "", "");
        PicItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, false, true, true, null);
      }
    }
    else
    {
      paramView = new Intent();
      paramView.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
      TroopFileProxyActivity.b((Activity)this.jdField_a_of_type_AndroidContentContext, paramView, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
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
      TroopFileError.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131697616));
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
    } else if (!TextUtils.isEmpty(paramTroopFileStatusInfo.jdField_d_of_type_JavaLangString)) {
      localForwardFileInfo.f(paramTroopFileStatusInfo.jdField_d_of_type_JavaLangString);
    }
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
  }
  
  private void a(TroopFileTransferManager paramTroopFileTransferManager, TroopFileStatusInfo paramTroopFileStatusInfo, int paramInt)
  {
    if (paramInt == 0)
    {
      TroopFileError.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131697616));
      return;
    }
    if ((paramTroopFileStatusInfo.jdField_b_of_type_Int != 1) && (paramTroopFileStatusInfo.jdField_b_of_type_Int != 0) && (paramTroopFileStatusInfo.jdField_b_of_type_Int != 2) && (paramTroopFileStatusInfo.jdField_b_of_type_Int != 3)) {
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
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForTroopFile);
    if (localTroopFileStatusInfo == null) {
      return true;
    }
    boolean bool;
    if ((paramMessageForTroopFile.lastTime != 0L) && (paramMessageForTroopFile.lastTime <= NetConnInfoCenter.getServerTime())) {
      bool = true;
    } else {
      bool = false;
    }
    if (localTroopFileStatusInfo.jdField_b_of_type_Int == 12) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(TroopFileStatusInfo paramTroopFileStatusInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = TencentDocConvertConfigProcessor.a().c();
      this.jdField_a_of_type_Boolean = false;
    }
    long l1 = FileManagerUtil.b(paramTroopFileStatusInfo.g);
    String str2 = TencentDocImportFileInfoProcessor.a().c();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = ".doc|.docx|.xls|.xlsx|";
    }
    long l2 = FileManagerUtil.a(paramTroopFileStatusInfo.jdField_e_of_type_JavaLangString);
    if ((this.jdField_c_of_type_Boolean) && (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsSupport(paramTroopFileStatusInfo.jdField_e_of_type_JavaLangString, paramTroopFileStatusInfo.g, str1)) && (l2 <= l1))
    {
      int i;
      if ((paramBoolean) && ((TextUtils.isEmpty(paramTroopFileStatusInfo.jdField_e_of_type_JavaLangString)) || (!FileUtils.fileExistsAndNotEmpty(paramTroopFileStatusInfo.jdField_e_of_type_JavaLangString)))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
        return true;
      }
    }
    return false;
  }
  
  private void b(int paramInt, TroopFileStatusInfo paramTroopFileStatusInfo, ArrayList<Integer> paramArrayList)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return;
    }
    long l = FileManagerUtil.b(paramTroopFileStatusInfo.g);
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
    if (d()) {
      paramArrayList.add(Integer.valueOf(18));
    }
  }
  
  private void b(View paramView)
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
    Object localObject1 = new TroopFileItemOperation(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
    long l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin).longValue();
    paramView = AnimationUtils.a(paramView);
    if (localTroopFileStatusInfo.jdField_b_of_type_Int == 12)
    {
      paramView = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131697330), new Object[] { TroopFileUtils.a(localTroopFileStatusInfo.g) });
      TroopFileError.a(this.jdField_a_of_type_AndroidContentContext, paramView, 1);
      return;
    }
    if ((localTroopFileStatusInfo.jdField_b_of_type_Int != 4) && (localTroopFileStatusInfo.jdField_b_of_type_Int != 5))
    {
      if (localTroopFileStatusInfo.jdField_b_of_type_Int == 13) {
        return;
      }
      if (((localTroopFileStatusInfo.jdField_b_of_type_Int == 3) || (localTroopFileStatusInfo.jdField_b_of_type_Int == 2)) && (!FileManagerUtil.a()))
      {
        ((TroopFileItemOperation)localObject1).a(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
        return;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
      ((StringBuilder)localObject2).append("");
      ReportController.b((AppRuntime)localObject1, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, ((StringBuilder)localObject2).toString(), "", "", "");
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
      ((StringBuilder)localObject2).append("");
      ReportController.b((AppRuntime)localObject1, "dc00899", "Grp_files", "", "Grp_AIO", "clk_videoBubble", 0, 0, ((StringBuilder)localObject2).toString(), "", "", "");
      if (a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile))
      {
        paramView = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131697330), new Object[] { TroopFileUtils.a(localTroopFileStatusInfo.g) });
        TroopFileError.a(this.jdField_a_of_type_AndroidContentContext, paramView, 1);
        return;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject2 = this.jdField_a_of_type_AndroidContentContext;
      SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      MessageForTroopFile localMessageForTroopFile = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile;
      QFileUtils.a((QQAppInterface)localObject1, (Context)localObject2, localSessionInfo, localMessageForTroopFile, l, localTroopFileStatusInfo, localMessageForTroopFile.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime, 3, 3, paramView, false, false);
    }
  }
  
  private void b(TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    if (paramTroopFileStatusInfo == null) {
      return;
    }
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
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009D69", "0X8009D69", 0, 0, "", "", "", "");
    }
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
    long l = FileManagerUtil.b(paramTroopFileStatusInfo.g);
    if (!FileUtil.b(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString))
    {
      TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin)).b();
      return;
    }
    if ((!TextUtils.isEmpty(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString)) && (FileUtils.isPicFile(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString))) {
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
    if (d()) {
      paramArrayList.add(Integer.valueOf(18));
    }
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
    long l = FileManagerUtil.b(paramTroopFileStatusInfo.g);
    paramArrayList.add(Integer.valueOf(9));
    MessageForTroopFile localMessageForTroopFile = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile;
    if ((localMessageForTroopFile != null) && (localMessageForTroopFile.fileSize <= l) && (a(paramTroopFileStatusInfo, false))) {
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
    ((StringBuilder)localObject2).append("");
    ReportController.b((AppRuntime)localObject1, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, ((StringBuilder)localObject2).toString(), "", "", "");
    localObject1 = a();
    if (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int == 12)
    {
      localObject1 = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131697330), new Object[] { TroopFileUtils.a(((TroopFileStatusInfo)localObject1).g) });
      TroopFileError.a(this.jdField_a_of_type_AndroidContentContext, (String)localObject1, 1);
      return;
    }
    localObject2 = new Intent();
    switch (((TroopFileStatusInfo)localObject1).jdField_b_of_type_Int)
    {
    case 4: 
    case 5: 
    default: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      int i = FileManagerUtil.a(((TroopFileStatusInfo)localObject1).g);
      if ((i != 0) && (i != 2))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localContext = this.jdField_a_of_type_AndroidContentContext;
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile;
        QFileUtils.a((QQAppInterface)localObject2, localContext, (ChatMessage)localObject3, (TroopFileStatusInfo)localObject1, ((MessageForTroopFile)localObject3).senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime, 3, false);
        return;
      }
      long l = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      Context localContext = this.jdField_a_of_type_AndroidContentContext;
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      MessageForTroopFile localMessageForTroopFile = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile;
      QFileUtils.a((QQAppInterface)localObject2, localContext, (SessionInfo)localObject3, localMessageForTroopFile, l, (TroopFileStatusInfo)localObject1, localMessageForTroopFile.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime, 3, 3, null, false, false);
      return;
    case 1: 
    case 2: 
    case 3: 
      ((Intent)localObject2).putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
      TroopFileProxyActivity.b((Activity)this.jdField_a_of_type_AndroidContentContext, (Intent)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
  }
  
  private void f(int paramInt, TroopFileStatusInfo paramTroopFileStatusInfo, ArrayList<Integer> paramArrayList)
  {
    long l = FileManagerUtil.b(paramTroopFileStatusInfo.g);
    paramArrayList.add(Integer.valueOf(9));
    MessageForTroopFile localMessageForTroopFile = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile;
    if ((localMessageForTroopFile != null) && (localMessageForTroopFile.fileSize <= l) && (a(paramTroopFileStatusInfo, false))) {
      paramArrayList.add(Integer.valueOf(22));
    }
    if (d()) {
      paramArrayList.add(Integer.valueOf(18));
    }
  }
  
  private void g()
  {
    Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    String str = "1";
    if (localObject != null)
    {
      if ((((TroopInfo)localObject).troopowneruin != null) && (((TroopInfo)localObject).troopowneruin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
      {
        localObject = "1";
        break label89;
      }
      if (((TroopInfo)localObject).Administrator != null) {
        ((TroopInfo)localObject).Administrator.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
    }
    localObject = "2";
    label89:
    if (FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName) != 0) {
      for (;;)
      {
        if (FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName) == 2) {
          str = "2";
        } else {
          str = "3";
        }
      }
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_files", "", "remove_file", "remove_clk", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", (String)localObject, str);
  }
  
  private void g(int paramInt, TroopFileStatusInfo paramTroopFileStatusInfo, ArrayList<Integer> paramArrayList)
  {
    long l = FileManagerUtil.b(paramTroopFileStatusInfo.g);
    if (!FileUtil.b(paramTroopFileStatusInfo.jdField_a_of_type_JavaLangString))
    {
      TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin)).b();
      return;
    }
    paramArrayList.add(Integer.valueOf(9));
    MessageForTroopFile localMessageForTroopFile = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile;
    if ((localMessageForTroopFile != null) && (localMessageForTroopFile.fileSize <= l) && (a(paramTroopFileStatusInfo, false))) {
      paramArrayList.add(Integer.valueOf(22));
    }
    if (d()) {
      paramArrayList.add(Integer.valueOf(18));
    }
  }
  
  public int a()
  {
    MessageForTroopFile localMessageForTroopFile = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile;
    if (localMessageForTroopFile == null) {
      return 0;
    }
    return localMessageForTroopFile.width;
  }
  
  public long a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile;
    if (localObject == null) {
      return 0L;
    }
    if (((MessageForTroopFile)localObject).fileSize > 0L) {
      return this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileSize;
    }
    localObject = a();
    if (localObject == null) {
      return 0L;
    }
    return ((TroopFileStatusInfo)localObject).jdField_c_of_type_Long;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile;
    if (localObject == null) {
      return "";
    }
    if (!TextUtils.isEmpty(((MessageForTroopFile)localObject).fileName)) {
      return this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName;
    }
    localObject = a();
    if (localObject == null) {
      return "";
    }
    return ((TroopFileStatusInfo)localObject).g;
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
    if (((QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (FileUtil.a(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString))) && (localTroopFileStatusInfo.jdField_b_of_type_Int != 12) && (FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName) == 2)) {
      localArrayList.add(Integer.valueOf(13));
    }
    FileManagerUtil.b(localTroopFileStatusInfo.g);
    Boolean localBoolean2 = Boolean.valueOf(false);
    Boolean localBoolean1 = localBoolean2;
    switch (localTroopFileStatusInfo.jdField_b_of_type_Int)
    {
    default: 
      localBoolean1 = localBoolean2;
      break;
    case 12: 
      localArrayList.add(Integer.valueOf(16));
      localBoolean1 = localBoolean2;
      break;
    case 11: 
      c(paramInt, localTroopFileStatusInfo, localArrayList);
      localBoolean1 = localBoolean2;
      break;
    case 10: 
      a(localArrayList);
      localBoolean1 = localBoolean2;
      break;
    case 9: 
      b(localArrayList);
      localBoolean1 = localBoolean2;
      break;
    case 8: 
      c(localArrayList);
      localBoolean1 = localBoolean2;
      break;
    case 7: 
      a(paramInt, localTroopFileStatusInfo, localArrayList);
      localBoolean1 = localBoolean2;
      break;
    case 6: 
      b(paramInt, localTroopFileStatusInfo, localArrayList);
      localBoolean1 = Boolean.valueOf(true);
      break;
    case 5: 
      localArrayList.add(Integer.valueOf(16));
      localBoolean1 = localBoolean2;
      break;
    case 2: 
    case 3: 
      localArrayList.add(Integer.valueOf(8));
      localArrayList.add(Integer.valueOf(6));
      localBoolean1 = Boolean.valueOf(true);
      break;
    case 0: 
    case 1: 
      localArrayList.add(Integer.valueOf(7));
      localArrayList.add(Integer.valueOf(6));
      localBoolean1 = Boolean.valueOf(true);
    }
    if (localBoolean1.booleanValue()) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_press_files", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
    } else {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Down_press_files", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
    }
    localArrayList.add(Integer.valueOf(19));
    return localArrayList;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      e();
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileBubbleModel", 1, "fetchFileThumb.");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
        return;
      }
      TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin));
      TroopFileStatusInfo localTroopFileStatusInfo = a();
      if (localTroopFileStatusInfo == null) {
        return;
      }
      boolean bool = FileUtil.a(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString);
      int j = 383;
      int i;
      if (bool)
      {
        i = j;
      }
      else
      {
        i = j;
        if (FilePicURLDrawlableHelper.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.width, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.height))
        {
          i = j;
          if (!FileUtil.a(localTroopFileStatusInfo.jdField_c_of_type_JavaLangString)) {
            i = 640;
          }
        }
      }
      if (localTroopFileStatusInfo.jdField_b_of_type_Int != 12)
      {
        if (localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID != null)
        {
          localTroopFileTransferManager.a(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID, i);
          return;
        }
        localTroopFileTransferManager.a(localTroopFileStatusInfo.jdField_e_of_type_JavaLangString, localTroopFileStatusInfo.g, localTroopFileStatusInfo.h, i);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin));
    if (localTroopFileTransferManager == null) {
      return;
    }
    TroopFileStatusInfo localTroopFileStatusInfo = a();
    if (localTroopFileStatusInfo == null) {
      return;
    }
    int i = NetworkUtil.getSystemNetwork(this.jdField_a_of_type_AndroidContentContext);
    TroopFileItemOperation localTroopFileItemOperation = new TroopFileItemOperation(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext);
    switch (paramInt)
    {
    default: 
    case 2131378344: 
      b(localTroopFileStatusInfo);
      return;
    case 2131376894: 
      TroopFileUtils.b((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
      return;
    case 2131376890: 
      FileManagerUtil.a((Activity)this.jdField_a_of_type_AndroidContentContext, localTroopFileStatusInfo.jdField_a_of_type_JavaLangString);
      return;
    case 2131376490: 
      if ((localTroopFileStatusInfo.jdField_b_of_type_Int == 2) || (localTroopFileStatusInfo.jdField_b_of_type_Int == 3))
      {
        localTroopFileItemOperation.a(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
        return;
      }
      break;
    case 2131372365: 
      if (i == 0)
      {
        TroopFileError.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131697616));
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Grp", "Up_pause_upload", 0, 0, "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin, "", "");
      if ((localTroopFileStatusInfo.jdField_b_of_type_Int != 0) && (localTroopFileStatusInfo.jdField_b_of_type_Int != 1)) {
        return;
      }
      localTroopFileTransferManager.a(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
      return;
    case 2131371660: 
      ReportController.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 3, 0, "", "", "", "");
      QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile, localTroopFileStatusInfo.jdField_b_of_type_Long, localTroopFileStatusInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.senderuin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime, 3, 3, null, true, false);
      return;
    case 2131371562: 
      g();
      return;
    case 2131367208: 
      ReportController.b(null, "dc00898", "", "", "0X800A60C", "0X800A60C", 0, 0, "", "", "", "");
      TroopFileUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
      return;
    case 2131367180: 
      a(localTroopFileStatusInfo, i);
      return;
    case 2131366494: 
      a(localTroopFileStatusInfo);
      return;
    case 2131364271: 
      a(localTroopFileTransferManager, localTroopFileStatusInfo, i);
      return;
    case 2131364267: 
      if ((localTroopFileStatusInfo.jdField_b_of_type_Int != 8) && (localTroopFileStatusInfo.jdField_b_of_type_Int != 9) && (localTroopFileStatusInfo.jdField_b_of_type_Int != 10)) {
        return;
      }
      localTroopFileTransferManager.d(localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
      a(localTroopFileStatusInfo.jdField_b_of_type_Long, (Activity)this.jdField_a_of_type_AndroidContentContext, localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fixMediaWidthAndHeight ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(":");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.i("TroopFileBubbleModel", 1, ((StringBuilder)localObject).toString());
    }
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile;
      ((MessageForTroopFile)localObject).width = paramInt1;
      ((MessageForTroopFile)localObject).height = paramInt2;
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
    int i;
    switch (FileManagerUtil.a(localTroopFileStatusInfo.g))
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
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A68A", "0X800A68A", i, 0, "4", "", "", "");
    if (paramInt == 1)
    {
      f();
      return;
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
    MessageForTroopFile localMessageForTroopFile = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile;
    if (localMessageForTroopFile == null) {
      return false;
    }
    return localMessageForTroopFile.isSend();
  }
  
  public int b()
  {
    MessageForTroopFile localMessageForTroopFile = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile;
    if (localMessageForTroopFile == null) {
      return 0;
    }
    return localMessageForTroopFile.height;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return 0L;
    }
    if (a().jdField_b_of_type_Int == 12) {
      return -1L;
    }
    long l = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime;
    if (l == 0L) {
      return 0L;
    }
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
    if (FileUtils.fileExistsAndNotEmpty(localTroopFileStatusInfo.jdField_d_of_type_JavaLangString)) {
      return localTroopFileStatusInfo.jdField_d_of_type_JavaLangString;
    }
    if (FileUtils.fileExistsAndNotEmpty(localTroopFileStatusInfo.jdField_c_of_type_JavaLangString)) {
      return localTroopFileStatusInfo.jdField_c_of_type_JavaLangString;
    }
    return "";
  }
  
  public List<Integer> b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return localArrayList;
    }
    TroopFileStatusInfo localTroopFileStatusInfo = a();
    if (localTroopFileStatusInfo == null) {
      return localArrayList;
    }
    if (((QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (FileUtil.a(localTroopFileStatusInfo.jdField_a_of_type_JavaLangString))) && (localTroopFileStatusInfo != null) && (localTroopFileStatusInfo.jdField_b_of_type_Int != 12) && (FileManagerUtil.a(localTroopFileStatusInfo.g) == 2)) {
      localArrayList.add(Integer.valueOf(13));
    }
    FileManagerUtil.b(localTroopFileStatusInfo.g);
    switch (localTroopFileStatusInfo.jdField_b_of_type_Int)
    {
    default: 
      return localArrayList;
    case 11: 
      g(paramInt, localTroopFileStatusInfo, localArrayList);
      return localArrayList;
    case 9: 
      d(paramInt, localTroopFileStatusInfo, localArrayList);
      return localArrayList;
    case 8: 
      localArrayList.add(Integer.valueOf(9));
      if (d())
      {
        localArrayList.add(Integer.valueOf(18));
        return localArrayList;
      }
      break;
    case 7: 
      f(paramInt, localTroopFileStatusInfo, localArrayList);
      return localArrayList;
    case 6: 
      e(paramInt, localTroopFileStatusInfo, localArrayList);
    }
    return localArrayList;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.fileName);
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.url);
    localObject = ((StringBuilder)localObject).toString();
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a((String)localObject))
    {
      ReportController.b(null, "dc00898", "", "", "0X800A685", "0X800A685", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().a((String)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a();
  }
  
  public boolean b()
  {
    MessageForTroopFile localMessageForTroopFile = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile;
    boolean bool = false;
    if (localMessageForTroopFile == null) {
      return false;
    }
    if (a().jdField_b_of_type_Int == 3) {
      bool = true;
    }
    return bool;
  }
  
  public int c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile;
    int i = 0;
    if (localObject == null) {
      return 0;
    }
    localObject = a();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime != 0L) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.lastTime <= NetConnInfoCenter.getServerTime())) {
      return 6;
    }
    if (((TroopFileStatusInfo)localObject).jdField_b_of_type_Int == 12) {
      return 1;
    }
    switch (((TroopFileStatusInfo)localObject).jdField_b_of_type_Int)
    {
    case 4: 
    default: 
      return 0;
    case 6: 
    case 11: 
      return 5;
    case 3: 
    case 5: 
    case 10: 
      return 2;
    case 2: 
    case 9: 
      return 4;
    case 0: 
    case 1: 
    case 8: 
      i = 3;
    }
    return i;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return;
    }
    Object localObject = a();
    if (localObject == null) {
      return;
    }
    if (((TroopFileStatusInfo)localObject).jdField_b_of_type_Int == 3)
    {
      localObject = (Activity)this.jdField_a_of_type_AndroidContentContext;
      Intent localIntent = new Intent();
      localIntent.putExtra(TroopFileProxyActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.frienduin);
      TroopFileProxyActivity.b((Activity)localObject, localIntent, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return false;
    }
    TroopFileStatusInfo localTroopFileStatusInfo = a();
    if (localTroopFileStatusInfo == null) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) {
      return false;
    }
    int i = FileManagerUtil.a(localTroopFileStatusInfo.g);
    if ((i != 2) && (i != 0)) {
      return true;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isSend() ^ true;
  }
  
  public int d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile;
    if (localObject == null) {
      return -1;
    }
    boolean bool = ((MessageForTroopFile)localObject).isSend();
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile.isMultiMsg) {
      bool = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    }
    int i = 0;
    localObject = a();
    int j = ((TroopFileStatusInfo)localObject).jdField_b_of_type_Int;
    if ((j != 0) && (j != 1))
    {
      if (j != 3)
      {
        if (j != 6)
        {
          if (j != 8)
          {
            if (j != 10)
            {
              if (j != 11) {
                return 0;
              }
              if (bool)
              {
                if (!FileUtils.fileExistsAndNotEmpty(((TroopFileStatusInfo)localObject).jdField_a_of_type_JavaLangString)) {
                  return i;
                }
              }
              else
              {
                if (!FileUtils.fileExistsAndNotEmpty(((TroopFileStatusInfo)localObject).jdField_a_of_type_JavaLangString)) {
                  return i;
                }
                return 5;
              }
            }
            else
            {
              return 6;
            }
          }
          else {
            return 4;
          }
        }
        else if (!FileUtils.fileExistsAndNotEmpty(((TroopFileStatusInfo)localObject).jdField_a_of_type_JavaLangString)) {
          return i;
        }
        return 2;
      }
      else
      {
        return 3;
      }
    }
    else {
      i = 1;
    }
    return i;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_AndroidContentContext.getString(2131697221);
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
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
      return 0;
    }
    TroopFileStatusInfo localTroopFileStatusInfo = a();
    if (localTroopFileStatusInfo == null) {
      return 0;
    }
    return TroopFileUtils.a(localTroopFileStatusInfo.jdField_d_of_type_Long, localTroopFileStatusInfo.jdField_c_of_type_Long);
  }
  
  public int f()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = a();
    if (localTroopFileStatusInfo == null) {
      return 0;
    }
    if (localTroopFileStatusInfo.jdField_c_of_type_Boolean) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.TroopFileBubbleModel
 * JD-Core Version:    0.7.0.1
 */