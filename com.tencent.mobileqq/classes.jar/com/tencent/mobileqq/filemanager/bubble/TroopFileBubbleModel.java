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
  private MessageForTroopFile a;
  private boolean f = true;
  private boolean g = false;
  
  public TroopFileBubbleModel(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    super(paramQQAppInterface, paramContext, paramSessionInfo);
  }
  
  private void A()
  {
    Object localObject1 = this.b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.a.frienduin);
    ((StringBuilder)localObject2).append("");
    ReportController.b((AppRuntime)localObject1, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, ((StringBuilder)localObject2).toString(), "", "", "");
    localObject1 = x();
    if (((TroopFileStatusInfo)localObject1).e == 12)
    {
      localObject1 = String.format(this.c.getString(2131895103), new Object[] { TroopFileUtils.a(((TroopFileStatusInfo)localObject1).t) });
      TroopFileError.a(this.c, (String)localObject1, 1);
      return;
    }
    localObject2 = new Intent();
    switch (((TroopFileStatusInfo)localObject1).e)
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
      int i = FileManagerUtil.c(((TroopFileStatusInfo)localObject1).t);
      if ((i != 0) && (i != 2))
      {
        localObject2 = this.b;
        localContext = this.c;
        localObject3 = this.a;
        QFileUtils.a((QQAppInterface)localObject2, localContext, (ChatMessage)localObject3, (TroopFileStatusInfo)localObject1, ((MessageForTroopFile)localObject3).senderuin, this.a.lastTime, 3, false);
        return;
      }
      long l = Long.valueOf(this.d.b).longValue();
      localObject2 = this.b;
      Context localContext = this.c;
      Object localObject3 = this.d;
      MessageForTroopFile localMessageForTroopFile = this.a;
      QFileUtils.a((QQAppInterface)localObject2, localContext, (SessionInfo)localObject3, localMessageForTroopFile, l, (TroopFileStatusInfo)localObject1, localMessageForTroopFile.senderuin, this.a.lastTime, 3, 3, null, false, false);
      return;
    case 1: 
    case 2: 
    case 3: 
      ((Intent)localObject2).putExtra(TroopFileProxyActivity.b, this.a.frienduin);
      TroopFileProxyActivity.b((Activity)this.c, (Intent)localObject2, this.b.getCurrentAccountUin());
    }
  }
  
  private void B()
  {
    Object localObject = ((TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER)).f(this.d.b);
    String str = "1";
    if (localObject != null)
    {
      if ((((TroopInfo)localObject).troopowneruin != null) && (((TroopInfo)localObject).troopowneruin.equals(this.b.getCurrentAccountUin())))
      {
        localObject = "1";
        break label86;
      }
      if (((TroopInfo)localObject).Administrator != null) {
        ((TroopInfo)localObject).Administrator.equals(this.b.getCurrentAccountUin());
      }
    }
    localObject = "2";
    label86:
    if (FileManagerUtil.c(this.a.fileName) != 0) {
      for (;;)
      {
        if (FileManagerUtil.c(this.a.fileName) == 2) {
          str = "2";
        } else {
          str = "3";
        }
      }
    }
    ReportController.b(this.b, "dc00899", "Grp_files", "", "remove_file", "remove_clk", 0, 0, this.d.b, "", (String)localObject, str);
  }
  
  private void a(int paramInt, TroopFileStatusInfo paramTroopFileStatusInfo, ArrayList<Integer> paramArrayList)
  {
    if (this.a == null) {
      return;
    }
    long l = FileManagerUtil.v(paramTroopFileStatusInfo.t);
    paramArrayList.add(Integer.valueOf(9));
    paramArrayList.add(Integer.valueOf(10));
    if ((this.a.fileSize <= l) && (a(paramTroopFileStatusInfo, false))) {
      paramArrayList.add(Integer.valueOf(23));
    }
    paramArrayList.add(Integer.valueOf(22));
    if (z()) {
      paramArrayList.add(Integer.valueOf(15));
    }
    if (paramInt == 1) {
      paramArrayList.add(Integer.valueOf(21));
    }
    paramArrayList.add(Integer.valueOf(16));
    if (y()) {
      paramArrayList.add(Integer.valueOf(19));
    }
    paramArrayList.add(Integer.valueOf(18));
    paramArrayList.add(Integer.valueOf(11));
    paramArrayList.add(Integer.valueOf(12));
  }
  
  private void a(long paramLong, Activity paramActivity, UUID paramUUID)
  {
    paramUUID = new TroopFileBubbleModel.1(this, paramLong, paramUUID, paramActivity);
    DialogUtil.a(paramActivity, 230, this.c.getString(2131895056), this.c.getString(2131895084), 2131895054, 2131895071, paramUUID, paramUUID).show();
  }
  
  private void a(long paramLong, Activity paramActivity, UUID paramUUID, ChatMessage paramChatMessage)
  {
    paramUUID = new TroopFileBubbleModel.2(this, paramLong, paramUUID, paramChatMessage, paramActivity);
    DialogUtil.a(paramActivity, 230, this.c.getString(2131895060), this.c.getString(2131895085), 2131895058, 2131895073, paramUUID, paramUUID).show();
  }
  
  private void a(View paramView)
  {
    if ((this.a.isMultiMsg) && (!FileManagerUtil.a(this.a, this.b, this.c))) {
      return;
    }
    Object localObject = x();
    if (localObject == null)
    {
      QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
      return;
    }
    int i = ((TroopFileStatusInfo)localObject).e;
    if ((i != 0) && (i != 1) && (i != 2) && (i != 3))
    {
      if ((i != 4) && (i != 5))
      {
        localObject = this.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.a.frienduin);
        localStringBuilder.append("");
        ReportController.b((AppRuntime)localObject, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, localStringBuilder.toString(), "", "", "");
        localObject = this.b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.a.frienduin);
        localStringBuilder.append("");
        ReportController.b((AppRuntime)localObject, "dc00899", "Grp_files", "", "Grp_AIO", "clk_picBubble", 0, 0, localStringBuilder.toString(), "", "", "");
        PicItemBuilder.a(this.b, this.c, paramView, this.a, this.d, false, true, true, null);
      }
    }
    else
    {
      paramView = new Intent();
      paramView.putExtra(TroopFileProxyActivity.b, this.a.frienduin);
      TroopFileProxyActivity.b((Activity)this.c, paramView, this.b.getCurrentAccountUin());
    }
  }
  
  private void a(TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    FileManagerEntity localFileManagerEntity = FileManagerUtil.a(paramTroopFileStatusInfo);
    paramTroopFileStatusInfo = TroopFileManager.a(this.b, paramTroopFileStatusInfo.d).a(localFileManagerEntity.strTroopFilePath);
    if (paramTroopFileStatusInfo != null)
    {
      localFileManagerEntity.lastTime = paramTroopFileStatusInfo.j;
      localFileManagerEntity.selfUin = String.valueOf(paramTroopFileStatusInfo.g);
    }
    new QfavBuilder(3).a(this.b, (Activity)this.c, localFileManagerEntity, this.a, false);
    if (this.a.isMultiMsg) {
      ReportController.b(this.b, "dc00898", "", "", "0X8009D67", "0X8009D67", 8, 0, "8", "", "", "");
    }
  }
  
  private void a(TroopFileStatusInfo paramTroopFileStatusInfo, int paramInt)
  {
    if (paramInt == 0)
    {
      TroopFileError.a(this.c, this.c.getString(2131895389));
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
      localForwardFileInfo.a(paramTroopFileStatusInfo.k);
    }
    localForwardFileInfo.d(paramTroopFileStatusInfo.t);
    localForwardFileInfo.d(paramTroopFileStatusInfo.i);
    localForwardFileInfo.a(Long.parseLong(this.a.frienduin));
    if (paramTroopFileStatusInfo.a != null) {
      localForwardFileInfo.e(paramTroopFileStatusInfo.a.toString());
    }
    if (!TextUtils.isEmpty(paramTroopFileStatusInfo.m)) {
      localForwardFileInfo.f(paramTroopFileStatusInfo.m);
    } else if (!TextUtils.isEmpty(paramTroopFileStatusInfo.n)) {
      localForwardFileInfo.f(paramTroopFileStatusInfo.n);
    }
    localForwardFileInfo.d(1);
    localForwardFileInfo.a(1);
    localBundle.putParcelable("fileinfo", localForwardFileInfo);
    localBundle.putBoolean("not_forward", true);
    localObject = new Intent();
    ((Intent)localObject).putExtras(localBundle);
    ((Intent)localObject).putExtra("forward_text", paramTroopFileStatusInfo.t);
    ((Intent)localObject).putExtra("forward_from_troop_file", true);
    localBundle.putInt("forward_source_uin_type", this.d.a);
    ((Intent)localObject).putExtra("direct_send_if_dataline_forward", true);
    ((Intent)localObject).putExtra("forward _key_nojump", true);
    ((Intent)localObject).putExtra("sender_uin", this.a.senderuin);
    ((Intent)localObject).putExtra("last_time", this.a.lastTime);
    ForwardBaseOption.a((Activity)this.c, (Intent)localObject, 21);
    if (this.a.isMultiMsg) {
      ReportController.b(this.b, "dc00898", "", "", "0X8009D66", "0X8009D66", 8, 0, "8", "", "", "");
    }
    ReportController.b(this.b, "CliOper", "", "", "0X8004045", "0X8004045", 0, 0, "", "", "", "");
  }
  
  private void a(TroopFileTransferManager paramTroopFileTransferManager, TroopFileStatusInfo paramTroopFileStatusInfo, int paramInt)
  {
    if (paramInt == 0)
    {
      TroopFileError.a(this.c, this.c.getString(2131895389));
      return;
    }
    if ((paramTroopFileStatusInfo.e != 1) && (paramTroopFileStatusInfo.e != 0) && (paramTroopFileStatusInfo.e != 2) && (paramTroopFileStatusInfo.e != 3)) {
      return;
    }
    paramTroopFileTransferManager.b(paramTroopFileStatusInfo.a);
    a(paramTroopFileStatusInfo.d, (Activity)this.c, paramTroopFileStatusInfo.a, this.a);
  }
  
  private void a(ArrayList<Integer> paramArrayList)
  {
    paramArrayList.add(Integer.valueOf(3));
    paramArrayList.add(Integer.valueOf(10));
    if (z()) {
      paramArrayList.add(Integer.valueOf(15));
    }
    paramArrayList.add(Integer.valueOf(16));
  }
  
  private boolean a(MessageForTroopFile paramMessageForTroopFile)
  {
    TroopFileStatusInfo localTroopFileStatusInfo = TroopFileUtils.a(this.b, paramMessageForTroopFile);
    if (localTroopFileStatusInfo == null) {
      return true;
    }
    boolean bool;
    if ((paramMessageForTroopFile.lastTime != 0L) && (paramMessageForTroopFile.lastTime <= NetConnInfoCenter.getServerTime())) {
      bool = true;
    } else {
      bool = false;
    }
    if (localTroopFileStatusInfo.e == 12) {
      bool = true;
    }
    return bool;
  }
  
  private boolean a(TroopFileStatusInfo paramTroopFileStatusInfo, boolean paramBoolean)
  {
    if (this.f)
    {
      this.g = TencentDocConvertConfigProcessor.a().c();
      this.f = false;
    }
    long l1 = FileManagerUtil.v(paramTroopFileStatusInfo.t);
    String str2 = TencentDocImportFileInfoProcessor.a().d();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = ".doc|.docx|.xls|.xlsx|";
    }
    long l2 = FileManagerUtil.h(paramTroopFileStatusInfo.r);
    if ((this.g) && (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsSupport(paramTroopFileStatusInfo.r, paramTroopFileStatusInfo.t, str1)) && (l2 <= l1))
    {
      int i;
      if ((paramBoolean) && ((TextUtils.isEmpty(paramTroopFileStatusInfo.r)) || (!FileUtils.fileExistsAndNotEmpty(paramTroopFileStatusInfo.r)))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0)
      {
        ReportController.b(this.b, "dc00898", "", "", "0X8009060", "0X8009060", 0, 0, "", "", "", "");
        return true;
      }
    }
    return false;
  }
  
  private void b(int paramInt, TroopFileStatusInfo paramTroopFileStatusInfo, ArrayList<Integer> paramArrayList)
  {
    if (this.a == null) {
      return;
    }
    long l = FileManagerUtil.v(paramTroopFileStatusInfo.t);
    paramArrayList.add(Integer.valueOf(9));
    if ((this.a.fileSize <= l) && (a(paramTroopFileStatusInfo, false))) {
      paramArrayList.add(Integer.valueOf(23));
    }
    if (z()) {
      paramArrayList.add(Integer.valueOf(15));
    }
    paramArrayList.add(Integer.valueOf(22));
    paramArrayList.add(Integer.valueOf(10));
    paramArrayList.add(Integer.valueOf(18));
    paramArrayList.add(Integer.valueOf(11));
    paramArrayList.add(Integer.valueOf(12));
    if (paramInt == 1) {
      paramArrayList.add(Integer.valueOf(21));
    }
    paramArrayList.add(Integer.valueOf(16));
    if (y()) {
      paramArrayList.add(Integer.valueOf(19));
    }
  }
  
  private void b(View paramView)
  {
    if ((this.a.isMultiMsg) && (!FileManagerUtil.a(this.a, this.b, this.c))) {
      return;
    }
    TroopFileStatusInfo localTroopFileStatusInfo = x();
    if (localTroopFileStatusInfo == null)
    {
      QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
      return;
    }
    Object localObject1 = new TroopFileItemOperation(Long.parseLong(this.a.frienduin), this.b, (Activity)this.c);
    long l = Long.valueOf(this.a.frienduin).longValue();
    paramView = AnimationUtils.a(paramView);
    if (localTroopFileStatusInfo.e == 12)
    {
      paramView = String.format(this.c.getString(2131895103), new Object[] { TroopFileUtils.a(localTroopFileStatusInfo.t) });
      TroopFileError.a(this.c, paramView, 1);
      return;
    }
    if ((localTroopFileStatusInfo.e != 4) && (localTroopFileStatusInfo.e != 5))
    {
      if (localTroopFileStatusInfo.e == 13) {
        return;
      }
      if (((localTroopFileStatusInfo.e == 3) || (localTroopFileStatusInfo.e == 2)) && (!FileManagerUtil.b()))
      {
        ((TroopFileItemOperation)localObject1).a(localTroopFileStatusInfo.a);
        return;
      }
      localObject1 = this.b;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.a.frienduin);
      ((StringBuilder)localObject2).append("");
      ReportController.b((AppRuntime)localObject1, "P_CliOper", "Grp_files", "", "AIOchat", "Clk_filesbubble", 0, 0, ((StringBuilder)localObject2).toString(), "", "", "");
      localObject1 = this.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.a.frienduin);
      ((StringBuilder)localObject2).append("");
      ReportController.b((AppRuntime)localObject1, "dc00899", "Grp_files", "", "Grp_AIO", "clk_videoBubble", 0, 0, ((StringBuilder)localObject2).toString(), "", "", "");
      if (a(this.a))
      {
        paramView = String.format(this.c.getString(2131895103), new Object[] { TroopFileUtils.a(localTroopFileStatusInfo.t) });
        TroopFileError.a(this.c, paramView, 1);
        return;
      }
      localObject1 = this.b;
      localObject2 = this.c;
      SessionInfo localSessionInfo = this.d;
      MessageForTroopFile localMessageForTroopFile = this.a;
      QFileUtils.a((QQAppInterface)localObject1, (Context)localObject2, localSessionInfo, localMessageForTroopFile, l, localTroopFileStatusInfo, localMessageForTroopFile.senderuin, this.a.lastTime, 3, 3, paramView, false, false);
    }
  }
  
  private void b(TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    if (paramTroopFileStatusInfo == null) {
      return;
    }
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    localTeamWorkFileImportInfo.d = paramTroopFileStatusInfo.k;
    localTeamWorkFileImportInfo.c = paramTroopFileStatusInfo.t;
    localTeamWorkFileImportInfo.J = FileManagerUtil.c(paramTroopFileStatusInfo.t);
    localTeamWorkFileImportInfo.o = true;
    localTeamWorkFileImportInfo.n = 1;
    localTeamWorkFileImportInfo.K = this.a.fileSize;
    localTeamWorkFileImportInfo.g = paramTroopFileStatusInfo.r;
    localTeamWorkFileImportInfo.h = paramTroopFileStatusInfo.u;
    localTeamWorkFileImportInfo.j = this.d.c;
    localTeamWorkFileImportInfo.b = this.d.b;
    if (paramTroopFileStatusInfo.e != 12) {
      localTeamWorkFileImportInfo.m = true;
    }
    localTeamWorkFileImportInfo.a = 1;
    TeamWorkConvertUtils.a(localTeamWorkFileImportInfo, this.c, this.b, localTeamWorkFileImportInfo.n);
    ReportController.b(this.b, "dc00898", "", "", "0X8009061", "0X8009061", 0, 0, "", "", "", "");
    if (this.a.isMultiMsg) {
      ReportController.b(this.b, "dc00898", "", "", "0X8009D69", "0X8009D69", 0, 0, "", "", "", "");
    }
  }
  
  private void b(ArrayList<Integer> paramArrayList)
  {
    paramArrayList.add(Integer.valueOf(3));
    paramArrayList.add(Integer.valueOf(9));
    paramArrayList.add(Integer.valueOf(10));
    if (z()) {
      paramArrayList.add(Integer.valueOf(15));
    }
    paramArrayList.add(Integer.valueOf(22));
    paramArrayList.add(Integer.valueOf(16));
    if (y()) {
      paramArrayList.add(Integer.valueOf(19));
    }
  }
  
  private void c(int paramInt, TroopFileStatusInfo paramTroopFileStatusInfo, ArrayList<Integer> paramArrayList)
  {
    long l = FileManagerUtil.v(paramTroopFileStatusInfo.t);
    if (!FileUtil.d(paramTroopFileStatusInfo.k))
    {
      TroopFileTransferManager.a(this.b, Long.parseLong(this.a.frienduin)).o();
      return;
    }
    if ((!TextUtils.isEmpty(paramTroopFileStatusInfo.k)) && (FileUtils.isPicFile(paramTroopFileStatusInfo.k))) {
      paramArrayList.add(Integer.valueOf(14));
    }
    paramArrayList.add(Integer.valueOf(9));
    paramArrayList.add(Integer.valueOf(10));
    paramArrayList.add(Integer.valueOf(18));
    paramArrayList.add(Integer.valueOf(11));
    paramArrayList.add(Integer.valueOf(12));
    if ((this.a.fileSize <= l) && (a(paramTroopFileStatusInfo, false))) {
      paramArrayList.add(Integer.valueOf(23));
    }
    if (z()) {
      paramArrayList.add(Integer.valueOf(15));
    }
    paramArrayList.add(Integer.valueOf(22));
    if (paramInt == 1) {
      paramArrayList.add(Integer.valueOf(21));
    }
    paramArrayList.add(Integer.valueOf(16));
    if (y()) {
      paramArrayList.add(Integer.valueOf(19));
    }
  }
  
  private void c(ArrayList<Integer> paramArrayList)
  {
    paramArrayList.add(Integer.valueOf(9));
    paramArrayList.add(Integer.valueOf(10));
    if (z()) {
      paramArrayList.add(Integer.valueOf(15));
    }
    paramArrayList.add(Integer.valueOf(22));
    paramArrayList.add(Integer.valueOf(16));
    if (y()) {
      paramArrayList.add(Integer.valueOf(19));
    }
  }
  
  private void d(int paramInt, TroopFileStatusInfo paramTroopFileStatusInfo, ArrayList<Integer> paramArrayList)
  {
    paramArrayList.add(Integer.valueOf(9));
    if (y()) {
      paramArrayList.add(Integer.valueOf(19));
    }
  }
  
  private void e(int paramInt, TroopFileStatusInfo paramTroopFileStatusInfo, ArrayList<Integer> paramArrayList)
  {
    long l = FileManagerUtil.v(paramTroopFileStatusInfo.t);
    paramArrayList.add(Integer.valueOf(9));
    MessageForTroopFile localMessageForTroopFile = this.a;
    if ((localMessageForTroopFile != null) && (localMessageForTroopFile.fileSize <= l) && (a(paramTroopFileStatusInfo, false))) {
      paramArrayList.add(Integer.valueOf(23));
    }
    if (y()) {
      paramArrayList.add(Integer.valueOf(19));
    }
  }
  
  private void f(int paramInt, TroopFileStatusInfo paramTroopFileStatusInfo, ArrayList<Integer> paramArrayList)
  {
    long l = FileManagerUtil.v(paramTroopFileStatusInfo.t);
    paramArrayList.add(Integer.valueOf(9));
    MessageForTroopFile localMessageForTroopFile = this.a;
    if ((localMessageForTroopFile != null) && (localMessageForTroopFile.fileSize <= l) && (a(paramTroopFileStatusInfo, false))) {
      paramArrayList.add(Integer.valueOf(23));
    }
    if (y()) {
      paramArrayList.add(Integer.valueOf(19));
    }
  }
  
  private void g(int paramInt, TroopFileStatusInfo paramTroopFileStatusInfo, ArrayList<Integer> paramArrayList)
  {
    long l = FileManagerUtil.v(paramTroopFileStatusInfo.t);
    if (!FileUtil.d(paramTroopFileStatusInfo.k))
    {
      TroopFileTransferManager.a(this.b, Long.parseLong(this.a.frienduin)).o();
      return;
    }
    paramArrayList.add(Integer.valueOf(9));
    MessageForTroopFile localMessageForTroopFile = this.a;
    if ((localMessageForTroopFile != null) && (localMessageForTroopFile.fileSize <= l) && (a(paramTroopFileStatusInfo, false))) {
      paramArrayList.add(Integer.valueOf(23));
    }
    if (y()) {
      paramArrayList.add(Integer.valueOf(19));
    }
  }
  
  private boolean y()
  {
    return AIOUtils.a(5) == 1;
  }
  
  private boolean z()
  {
    return (this.a.extraflag != 32768) && (!this.b.getMsgCache().f(this.a));
  }
  
  public void a(int paramInt)
  {
    if (this.a == null) {
      return;
    }
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.b, Long.parseLong(this.a.frienduin));
    if (localTroopFileTransferManager == null) {
      return;
    }
    TroopFileStatusInfo localTroopFileStatusInfo = x();
    if (localTroopFileStatusInfo == null) {
      return;
    }
    int i = NetworkUtil.getSystemNetwork(this.c);
    TroopFileItemOperation localTroopFileItemOperation = new TroopFileItemOperation(Long.parseLong(this.a.frienduin), this.b, (Activity)this.c);
    switch (paramInt)
    {
    default: 
    case 2131446941: 
      b(localTroopFileStatusInfo);
      return;
    case 2131445242: 
      TroopFileUtils.b((Activity)this.c, this.b, this.a);
      return;
    case 2131445236: 
      FileManagerUtil.a((Activity)this.c, localTroopFileStatusInfo.k);
      return;
    case 2131444731: 
      if ((localTroopFileStatusInfo.e == 2) || (localTroopFileStatusInfo.e == 3))
      {
        localTroopFileItemOperation.a(localTroopFileStatusInfo.a);
        return;
      }
      break;
    case 2131439883: 
      if (i == 0)
      {
        TroopFileError.a(this.c, this.c.getString(2131895389));
        return;
      }
      ReportController.b(this.b, "CliOper", "", "", "Grp", "Up_pause_upload", 0, 0, "", this.a.frienduin, "", "");
      if ((localTroopFileStatusInfo.e != 0) && (localTroopFileStatusInfo.e != 1)) {
        return;
      }
      localTroopFileTransferManager.b(localTroopFileStatusInfo.a);
      return;
    case 2131439081: 
      ReportController.b(null, "dc00898", "", "", "0X8009F65", "0X8009F65", 3, 0, "", "", "", "");
      QFileUtils.a(this.b, this.c, this.d, this.a, localTroopFileStatusInfo.d, localTroopFileStatusInfo, this.a.senderuin, this.a.lastTime, 3, 3, null, true, false);
      return;
    case 2131438943: 
      B();
      return;
    case 2131433664: 
      ReportController.b(null, "dc00898", "", "", "0X800A60C", "0X800A60C", 0, 0, "", "", "", "");
      TroopFileUtils.a(this.c, this.b, this.a);
      return;
    case 2131433636: 
      a(localTroopFileStatusInfo, i);
      return;
    case 2131432813: 
      a(localTroopFileStatusInfo);
      return;
    case 2131430288: 
      a(localTroopFileTransferManager, localTroopFileStatusInfo, i);
      return;
    case 2131430284: 
      if ((localTroopFileStatusInfo.e != 8) && (localTroopFileStatusInfo.e != 9) && (localTroopFileStatusInfo.e != 10)) {
        return;
      }
      localTroopFileTransferManager.e(localTroopFileStatusInfo.a);
      a(localTroopFileStatusInfo.d, (Activity)this.c, localTroopFileStatusInfo.a);
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
      localObject = this.a;
      ((MessageForTroopFile)localObject).width = paramInt1;
      ((MessageForTroopFile)localObject).height = paramInt2;
    }
  }
  
  public void a(int paramInt, View paramView)
  {
    if (this.a == null) {
      return;
    }
    TroopFileStatusInfo localTroopFileStatusInfo = x();
    if (localTroopFileStatusInfo == null)
    {
      QLog.e("TroopFileBubbleModel", 1, "item click class but can not find.");
      return;
    }
    int i;
    switch (FileManagerUtil.c(localTroopFileStatusInfo.t))
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
    ReportController.b(this.b, "dc00898", "", "", "0X800A68A", "0X800A68A", i, 0, "4", "", "", "");
    if (paramInt == 1)
    {
      A();
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
    A();
  }
  
  protected void a(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForTroopFile))
    {
      QLog.e("TroopFileBubbleModel", 1, "setBubbleModelData. is not a MessageForTroopFile");
      return;
    }
    this.a = ((MessageForTroopFile)paramChatMessage);
  }
  
  public boolean a()
  {
    MessageForTroopFile localMessageForTroopFile = this.a;
    if (localMessageForTroopFile == null) {
      return false;
    }
    return localMessageForTroopFile.isSend();
  }
  
  public QFileBubblePauseHandler b()
  {
    return new TroopFileBubblePauseHandler(this.b, this.c);
  }
  
  public List<Integer> b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.a == null) {
      return localArrayList;
    }
    TroopFileStatusInfo localTroopFileStatusInfo = x();
    if (localTroopFileStatusInfo == null) {
      return localArrayList;
    }
    if (((QFileUtils.a(this.b)) || (FileUtil.b(localTroopFileStatusInfo.k))) && (localTroopFileStatusInfo.e != 12) && (FileManagerUtil.c(this.a.fileName) == 2)) {
      localArrayList.add(Integer.valueOf(13));
    }
    FileManagerUtil.v(localTroopFileStatusInfo.t);
    Boolean localBoolean2 = Boolean.valueOf(false);
    Boolean localBoolean1 = localBoolean2;
    switch (localTroopFileStatusInfo.e)
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
      ReportController.b(this.b, "CliOper", "", "", "Grp", "Up_press_files", 0, 0, "", this.a.frienduin, "", "");
    } else {
      ReportController.b(this.b, "CliOper", "", "", "Grp", "Down_press_files", 0, 0, "", this.a.frienduin, "", "");
    }
    localArrayList.add(Integer.valueOf(20));
    return localArrayList;
  }
  
  public QFileBubbleDownloadHandler c()
  {
    return new TroopFileBubbleDownloadHandler(this.b, this.c);
  }
  
  public List<Integer> c(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.a == null) {
      return localArrayList;
    }
    TroopFileStatusInfo localTroopFileStatusInfo = x();
    if (localTroopFileStatusInfo == null) {
      return localArrayList;
    }
    if (((QFileUtils.a(this.b)) || (FileUtil.b(localTroopFileStatusInfo.k))) && (localTroopFileStatusInfo != null) && (localTroopFileStatusInfo.e != 12) && (FileManagerUtil.c(localTroopFileStatusInfo.t) == 2)) {
      localArrayList.add(Integer.valueOf(13));
    }
    FileManagerUtil.v(localTroopFileStatusInfo.t);
    switch (localTroopFileStatusInfo.e)
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
      if (y())
      {
        localArrayList.add(Integer.valueOf(19));
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
  
  public int d()
  {
    MessageForTroopFile localMessageForTroopFile = this.a;
    if (localMessageForTroopFile == null) {
      return 0;
    }
    return localMessageForTroopFile.width;
  }
  
  public int e()
  {
    MessageForTroopFile localMessageForTroopFile = this.a;
    if (localMessageForTroopFile == null) {
      return 0;
    }
    return localMessageForTroopFile.height;
  }
  
  public String f()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return "";
    }
    if (!TextUtils.isEmpty(((MessageForTroopFile)localObject).fileName)) {
      return this.a.fileName;
    }
    localObject = x();
    if (localObject == null) {
      return "";
    }
    return ((TroopFileStatusInfo)localObject).t;
  }
  
  public long g()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return 0L;
    }
    if (((MessageForTroopFile)localObject).fileSize > 0L) {
      return this.a.fileSize;
    }
    localObject = x();
    if (localObject == null) {
      return 0L;
    }
    return ((TroopFileStatusInfo)localObject).i;
  }
  
  public String h()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = x();
    if (localTroopFileStatusInfo == null) {
      return "";
    }
    if (FileUtils.fileExistsAndNotEmpty(localTroopFileStatusInfo.n)) {
      return localTroopFileStatusInfo.n;
    }
    if (FileUtils.fileExistsAndNotEmpty(localTroopFileStatusInfo.m)) {
      return localTroopFileStatusInfo.m;
    }
    return "";
  }
  
  public int i()
  {
    Object localObject = this.a;
    int i = 0;
    if (localObject == null) {
      return 0;
    }
    localObject = x();
    if ((this.a.lastTime != 0L) && (this.a.lastTime <= NetConnInfoCenter.getServerTime())) {
      return 6;
    }
    if (((TroopFileStatusInfo)localObject).e == 12) {
      return 1;
    }
    switch (((TroopFileStatusInfo)localObject).e)
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
  
  public int j()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return -1;
    }
    boolean bool = ((MessageForTroopFile)localObject).isSend();
    if (this.a.isMultiMsg) {
      bool = FileManagerUtil.a(this.b, this.a);
    }
    int i = 0;
    localObject = x();
    int j = ((TroopFileStatusInfo)localObject).e;
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
                if (!FileUtils.fileExistsAndNotEmpty(((TroopFileStatusInfo)localObject).k)) {
                  return i;
                }
              }
              else
              {
                if (!FileUtils.fileExistsAndNotEmpty(((TroopFileStatusInfo)localObject).k)) {
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
        else if (!FileUtils.fileExistsAndNotEmpty(((TroopFileStatusInfo)localObject).k)) {
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
  
  public int k()
  {
    if (this.a == null) {
      return 0;
    }
    TroopFileStatusInfo localTroopFileStatusInfo = x();
    if (localTroopFileStatusInfo == null) {
      return 0;
    }
    return TroopFileUtils.a(localTroopFileStatusInfo.j, localTroopFileStatusInfo.i);
  }
  
  public void l()
  {
    if (this.e)
    {
      w();
      if (QLog.isColorLevel()) {
        QLog.i("TroopFileBubbleModel", 1, "fetchFileThumb.");
      }
      if (this.a == null) {
        return;
      }
      TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.b, Long.parseLong(this.a.frienduin));
      TroopFileStatusInfo localTroopFileStatusInfo = x();
      if (localTroopFileStatusInfo == null) {
        return;
      }
      boolean bool = FileUtil.b(localTroopFileStatusInfo.k);
      int j = 383;
      int i;
      if (bool)
      {
        i = j;
      }
      else
      {
        i = j;
        if (FilePicURLDrawlableHelper.b(this.a.width, this.a.height))
        {
          i = j;
          if (!FileUtil.b(localTroopFileStatusInfo.m)) {
            i = 640;
          }
        }
      }
      if (localTroopFileStatusInfo.e != 12)
      {
        if (localTroopFileStatusInfo.a != null)
        {
          localTroopFileTransferManager.a(localTroopFileStatusInfo.a, i);
          return;
        }
        localTroopFileTransferManager.a(localTroopFileStatusInfo.r, localTroopFileStatusInfo.t, localTroopFileStatusInfo.u, i);
      }
    }
  }
  
  public void m()
  {
    if (this.a == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.fileName);
    ((StringBuilder)localObject).append(this.a.url);
    localObject = ((StringBuilder)localObject).toString();
    if (!this.b.getFileManagerProxy().l((String)localObject))
    {
      ReportController.b(null, "dc00898", "", "", "0X800A685", "0X800A685", 0, 0, "", "", "", "");
      this.b.getFileManagerProxy().k((String)localObject);
    }
    this.b.getFileManagerEngine().f().a();
  }
  
  public boolean n()
  {
    MessageForTroopFile localMessageForTroopFile = this.a;
    boolean bool = false;
    if (localMessageForTroopFile == null) {
      return false;
    }
    if (x().e == 3) {
      bool = true;
    }
    return bool;
  }
  
  public void o()
  {
    if (this.a == null) {
      return;
    }
    Object localObject = x();
    if (localObject == null) {
      return;
    }
    if (((TroopFileStatusInfo)localObject).e == 3)
    {
      localObject = (Activity)this.c;
      Intent localIntent = new Intent();
      localIntent.putExtra(TroopFileProxyActivity.b, this.a.frienduin);
      TroopFileProxyActivity.b((Activity)localObject, localIntent, this.b.getCurrentAccountUin());
    }
  }
  
  public long p()
  {
    if (this.a == null) {
      return 0L;
    }
    if (x().e == 12) {
      return -1L;
    }
    long l = this.a.lastTime;
    if (l == 0L) {
      return 0L;
    }
    l -= MessageCache.c();
    if (l > 0L) {
      return l;
    }
    return -1L;
  }
  
  public int q()
  {
    TroopFileStatusInfo localTroopFileStatusInfo = x();
    if (localTroopFileStatusInfo == null) {
      return 0;
    }
    if (localTroopFileStatusInfo.G) {
      return 0;
    }
    if (QFileUtils.a(localTroopFileStatusInfo.o, localTroopFileStatusInfo.p, localTroopFileStatusInfo.i)) {
      return 1;
    }
    if (localTroopFileStatusInfo.H == 1) {
      return 1;
    }
    if (localTroopFileStatusInfo.H == 2) {
      return 2;
    }
    return super.q();
  }
  
  public boolean s()
  {
    if (this.a == null) {
      return false;
    }
    TroopFileStatusInfo localTroopFileStatusInfo = x();
    if (localTroopFileStatusInfo == null) {
      return false;
    }
    if (this.a.isMultiMsg) {
      return false;
    }
    int i = FileManagerUtil.c(localTroopFileStatusInfo.t);
    if ((i != 2) && (i != 0)) {
      return true;
    }
    return this.a.isSend() ^ true;
  }
  
  public String t()
  {
    return this.c.getString(2131894994);
  }
  
  public void u()
  {
    if (this.a == null) {
      return;
    }
    Activity localActivity = (Activity)this.c;
    Intent localIntent = new Intent();
    localIntent.putExtra(TroopFileProxyActivity.b, this.a.frienduin);
    TroopFileProxyActivity.a(localActivity, localIntent, this.b.getCurrentAccountUin());
  }
  
  @Nullable
  public TroopFileStatusInfo x()
  {
    return TroopFileUtils.a(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.TroopFileBubbleModel
 * JD-Core Version:    0.7.0.1
 */