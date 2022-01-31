package com.tencent.mobileqq.filemanager.recreate;

import acwf;
import acwg;
import acwh;
import acwi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.core.FileVideoManager;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileModel
{
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private final String jdField_a_of_type_JavaLangString = "FileModel<FileAssistant>";
  
  public static FileModel a(MessageForFile paramMessageForFile)
  {
    try
    {
      QQAppInterface localQQAppInterface1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface1 == null) {
        throw new NullPointerException("newFileModel entity app null!");
      }
    }
    catch (Exception localException)
    {
      QQAppInterface localQQAppInterface2;
      for (;;)
      {
        localQQAppInterface2 = null;
      }
      return a(FileManagerUtil.a(localQQAppInterface2, paramMessageForFile));
    }
  }
  
  public static FileModel a(FileManagerEntity paramFileManagerEntity)
  {
    FileModel localFileModel = new FileModel();
    if ((paramFileManagerEntity == null) && (QLog.isDevelopLevel())) {
      throw new NullPointerException("newFileModel entity is null!");
    }
    localFileModel.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    return localFileModel;
  }
  
  public static FileModel a(String paramString)
  {
    try
    {
      paramString = a(FileManagerUtil.a(new FileInfo(paramString)));
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
      if (QLog.isDevelopLevel()) {
        throw new NullPointerException("check localPath");
      }
    }
    return null;
  }
  
  private void a(String paramString1, String paramString2)
  {
    QLog.i("FileModel<FileAssistant>" + paramString1, 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]" + paramString2);
  }
  
  private void b(Activity paramActivity)
  {
    FileVideoManager.a(paramActivity, new acwi(this, paramActivity));
  }
  
  private void c(Activity paramActivity)
  {
    Object localObject1 = null;
    try
    {
      localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label14:
      Object localObject3;
      break label14;
    }
    if (localObject1 == null)
    {
      QLog.e("FileModel<FileAssistant>", 1, "Start VideoActivity is not in QQ!");
      return;
    }
    localObject3 = new ForwardFileInfo();
    ((ForwardFileInfo)localObject3).b(10004);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) {}
    for (localObject2 = ((QQAppInterface)localObject1).getAccount();; localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin)
    {
      ((ForwardFileInfo)localObject3).d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType());
      ((ForwardFileInfo)localObject3).a(Long.valueOf(((String)localObject2).replace("+", "")).longValue());
      ((ForwardFileInfo)localObject3).c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
      ((ForwardFileInfo)localObject3).b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      ((ForwardFileInfo)localObject3).d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      ((ForwardFileInfo)localObject3).d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
      ((ForwardFileInfo)localObject3).b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid);
      ((ForwardFileInfo)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath());
      localObject2 = new Intent(paramActivity, FileBrowserActivity.class);
      ((Intent)localObject2).putExtra("fileinfo", (Parcelable)localObject3);
      if (FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName) != 0) {
        break label330;
      }
      localObject3 = ((QQAppInterface)localObject1).a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType);
      if ((localObject3 == null) || (((List)localObject3).size() == 0)) {
        break;
      }
      localObject1 = new ArrayList();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject3).next();
        if ((localChatMessage.msgtype == -2005) || (localChatMessage.msgtype == -2014)) {
          ((ArrayList)localObject1).add(String.valueOf(localChatMessage.uniseq));
        }
      }
    }
    ((Intent)localObject2).putStringArrayListExtra("Aio_Uinseq_ImageList", (ArrayList)localObject1);
    label330:
    ((Intent)localObject2).putExtra("selfSet_leftViewText", "返回");
    paramActivity.startActivityForResult((Intent)localObject2, 102);
    paramActivity.overridePendingTransition(2131034165, 2131034167);
  }
  
  public void a(Activity paramActivity)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 2)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 1)
      {
        if (!NetworkUtil.d(BaseApplicationImpl.getContext())) {
          FMToastUtil.a(2131437513);
        }
        acwg localacwg;
        do
        {
          return;
          if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 2) || (!a(true))) {
            break;
          }
          localacwg = new acwg(this, paramActivity);
        } while (!CUKingCardHelper.a(paramActivity, 2, new acwh(this, paramActivity), ""));
        FMDialogUtil.a(paramActivity, paramActivity.getString(2131428241), paramActivity.getString(2131428239), localacwg);
        return;
      }
      b(paramActivity);
      return;
    }
    c(paramActivity);
  }
  
  public void a(boolean paramBoolean, Context paramContext, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    if (!NetworkUtil.e(BaseApplicationImpl.getContext()))
    {
      FMToastUtil.a(2131437295);
      return;
    }
    boolean bool;
    if (!paramBoolean)
    {
      bool = true;
      label23:
      if (!a(bool)) {
        break label106;
      }
      Activity localActivity = (Activity)paramContext;
      if (!paramBoolean) {
        break label92;
      }
      i = 3;
      label45:
      if (!CUKingCardHelper.a(localActivity, i, new acwf(this, paramFMDialogInterface), "")) {
        break label96;
      }
      if (!paramBoolean) {
        break label98;
      }
    }
    label92:
    label96:
    label98:
    for (int i = 2131428237;; i = 2131428239)
    {
      FMDialogUtil.a(paramContext, 2131428241, i, paramFMDialogInterface);
      return;
      bool = false;
      break label23;
      i = 2;
      break label45;
      break;
    }
    label106:
    paramFMDialogInterface.a();
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (!NetworkUtil.d(BaseApplicationImpl.getContext())) {}
    long l2;
    long l1;
    do
    {
      do
      {
        return false;
        if (!FileManagerUtil.a())
        {
          a("FlowShow", " donot ShowFlowDialog! Wi-Fi");
          return false;
        }
        l2 = FMConfig.a();
        l1 = FMConfig.b();
        a("FlowShow", "fileSize " + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize + ",limit  " + l2);
      } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize < l2);
      if (paramBoolean)
      {
        a("FlowShow", "download model so Show!");
        return true;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType != 3) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType != 6))
      {
        a("FlowShow", "cloudeType " + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType + " is not local File donot show!");
        return false;
      }
      l2 = MessageCache.a();
      a("FlowShow", "last Succ " + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime + " now " + MessageCache.a() + " = " + (l2 - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime) + " limit[" + l1 + "]");
    } while (l2 - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime < l1);
    a("FlowShow", "Must show!");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.recreate.FileModel
 * JD-Core Version:    0.7.0.1
 */