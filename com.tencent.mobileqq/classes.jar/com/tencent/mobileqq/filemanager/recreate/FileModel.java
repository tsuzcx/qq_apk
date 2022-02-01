package com.tencent.mobileqq.filemanager.recreate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;

public class FileModel
{
  private FileManagerEntity a;
  
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
    localFileModel.a = paramFileManagerEntity;
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
    QLog.i("FileModel<FileAssistant>" + paramString1, 1, "Id[" + this.a.nSessionId + "]" + paramString2);
  }
  
  private void b(Activity paramActivity, int paramInt)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface == null)
      {
        QLog.e("FileModel<FileAssistant>", 1, "Start VideoActivity is not in QQ!");
        return;
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      for (;;)
      {
        localObject = null;
      }
      if (((this.a.status == 0) || (this.a.status == 3)) && (((paramActivity instanceof ChatActivity)) || ((paramActivity instanceof SplashActivity))) && (!this.a.bSend))
      {
        localObject.getFileManagerEngine().a(this.a.nSessionId);
        return;
      }
      b(paramActivity, paramInt, 10004);
    }
  }
  
  private void b(Activity paramActivity, int paramInt1, int paramInt2)
  {
    ForwardFileInfo localForwardFileInfo;
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface == null)
      {
        QLog.e("FileModel<FileAssistant>", 1, "Start VideoActivity is not in QQ!");
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject = null;
      }
      localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.b(paramInt2);
      if (!this.a.bSend) {}
    }
    for (Object localObject = ((QQAppInterface)localObject).getAccount();; localObject = this.a.peerUin)
    {
      localForwardFileInfo.d(this.a.getCloudType());
      if (localObject != null) {
        localForwardFileInfo.a(Long.valueOf(((String)localObject).replace("+", "")).longValue());
      }
      localForwardFileInfo.c(this.a.uniseq);
      localForwardFileInfo.b(this.a.nSessionId);
      localForwardFileInfo.d(this.a.fileName);
      localForwardFileInfo.d(this.a.fileSize);
      localForwardFileInfo.b(this.a.Uuid);
      localForwardFileInfo.a(this.a.getFilePath());
      localObject = new Intent(paramActivity, FileBrowserActivity.class);
      ((Intent)localObject).putExtra("fileinfo", localForwardFileInfo);
      ((Intent)localObject).putExtra("file_enter_file_browser_type", paramInt1);
      ((Intent)localObject).putExtra("selfSet_leftViewText", HardCodeUtil.a(2131704583));
      paramActivity.startActivityForResult((Intent)localObject, 102);
      paramActivity.overridePendingTransition(2130772043, 2130772045);
      return;
    }
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    if (this.a.nFileType == 2)
    {
      if (!NetworkUtil.d(BaseApplicationImpl.getContext())) {
        FMToastUtil.a(2131694730);
      }
      FileModel.3 local3;
      boolean bool1;
      do
      {
        return;
        if ((this.a.getCloudType() != 1) || (!FileManagerUtil.a()) || (this.a.status == 2) || (this.a.fileSize <= 1048576L)) {
          break;
        }
        local3 = new FileModel.3(this, paramActivity, paramInt);
        boolean bool2 = CUKingCardHelper.a(paramActivity, 2, new FileModel.4(this, paramActivity, paramInt), "");
        bool1 = bool2;
        if (bool2) {
          bool1 = FreeWifiHelper.a(paramActivity, 3, new FileModel.5(this, paramActivity, paramInt));
        }
      } while (!bool1);
      FMDialogUtil.a(paramActivity, paramActivity.getString(2131692609), paramActivity.getString(2131692611), local3);
      return;
      b(paramActivity, paramInt);
      return;
    }
    b(paramActivity, paramInt, 10004);
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    b(paramActivity, paramInt2, paramInt1);
  }
  
  public void a(boolean paramBoolean, Context paramContext, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    int j = 2;
    if (!NetworkUtil.e(BaseApplicationImpl.getContext())) {
      FMToastUtil.a(2131693237);
    }
    boolean bool1;
    label48:
    label91:
    do
    {
      return;
      if (paramBoolean) {
        break;
      }
      bool1 = true;
      if (!a(bool1)) {
        break label160;
      }
      Activity localActivity = (Activity)paramContext;
      if (!paramBoolean) {
        break label140;
      }
      i = 3;
      boolean bool2 = CUKingCardHelper.a(localActivity, i, new FileModel.1(this, paramFMDialogInterface), "");
      bool1 = bool2;
      if (bool2)
      {
        localActivity = (Activity)paramContext;
        if (!paramBoolean) {
          break label146;
        }
        i = j;
        bool1 = FreeWifiHelper.a(localActivity, i, new FileModel.2(this, paramFMDialogInterface));
      }
    } while (!bool1);
    if (paramBoolean) {}
    for (int i = 2131692614;; i = 2131692611)
    {
      FMDialogUtil.a(paramContext, 2131692609, i, paramFMDialogInterface);
      return;
      bool1 = false;
      break;
      label140:
      i = 2;
      break label48;
      label146:
      i = 1;
      break label91;
    }
    label160:
    paramFMDialogInterface.a();
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (!NetworkUtil.d(BaseApplicationImpl.getContext())) {
      return false;
    }
    if (!FileManagerUtil.a())
    {
      a("FlowShow", " donot ShowFlowDialog! Wi-Fi");
      return false;
    }
    long l2 = ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize();
    long l1 = ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogTime();
    a("FlowShow", "fileSize " + this.a.fileSize + ",limit  " + l2);
    if (this.a.fileSize < l2) {
      return false;
    }
    if (paramBoolean)
    {
      a("FlowShow", "download model so Show!");
      return true;
    }
    if ((this.a.cloudType != 3) && (this.a.cloudType != 6))
    {
      a("FlowShow", "cloudeType " + this.a.cloudType + " is not local File donot show!");
      return false;
    }
    l2 = MessageCache.a();
    a("FlowShow", "last Succ " + this.a.lastSuccessTime + " now " + MessageCache.a() + " = " + (l2 - this.a.lastSuccessTime) + " limit[" + l1 + "]");
    if (l2 - this.a.lastSuccessTime < l1) {
      return false;
    }
    a("FlowShow", "Must show!");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.recreate.FileModel
 * JD-Core Version:    0.7.0.1
 */