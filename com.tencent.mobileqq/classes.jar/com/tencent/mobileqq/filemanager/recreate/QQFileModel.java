package com.tencent.mobileqq.filemanager.recreate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;

public class QQFileModel
  implements IFModel
{
  private FileManagerEntity a;
  
  public static QQFileModel a(MessageForFile paramMessageForFile)
  {
    try
    {
      localBaseQQAppInterface = QQFileManagerUtilImpl.a();
    }
    catch (Exception localException)
    {
      BaseQQAppInterface localBaseQQAppInterface;
      label7:
      break label7;
    }
    localBaseQQAppInterface = null;
    if (localBaseQQAppInterface != null) {
      return a(QQFileManagerUtilImpl.a(localBaseQQAppInterface, paramMessageForFile));
    }
    throw new NullPointerException("newFileModel entity app null!");
  }
  
  public static QQFileModel a(FileManagerEntity paramFileManagerEntity)
  {
    QQFileModel localQQFileModel = new QQFileModel();
    if ((paramFileManagerEntity == null) && (QLog.isDevelopLevel())) {
      throw new NullPointerException("newFileModel entity is null!");
    }
    localQQFileModel.a = paramFileManagerEntity;
    return localQQFileModel;
  }
  
  public static QQFileModel a(String paramString)
  {
    try
    {
      paramString = a(QQFileManagerUtilImpl.a(new FileInfo(paramString)));
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
      if (!QLog.isDevelopLevel()) {
        return null;
      }
      throw new NullPointerException("check localPath");
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FileModel<FileAssistant>");
    localStringBuilder.append(paramString1);
    paramString1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.a.nSessionId);
    localStringBuilder.append("]");
    localStringBuilder.append(paramString2);
    QLog.i(paramString1, 1, localStringBuilder.toString());
  }
  
  private boolean a(Activity paramActivity, int paramInt)
  {
    return ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).checkFileWithFreeWifiHelper(paramActivity, paramInt, new QQFileModel.2(this));
  }
  
  private boolean a(Activity paramActivity, BaseQQAppInterface paramBaseQQAppInterface)
  {
    return ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).checkStatusToResume(paramActivity, paramBaseQQAppInterface, this.a);
  }
  
  private boolean a(boolean paramBoolean, Activity paramActivity, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    return ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).checkWifiWithFreeWifiHelper(paramBoolean, paramActivity, paramFMDialogInterface);
  }
  
  private void b(Activity paramActivity, int paramInt)
  {
    try
    {
      localBaseQQAppInterface = QQFileManagerUtilImpl.a();
    }
    catch (Exception localException)
    {
      BaseQQAppInterface localBaseQQAppInterface;
      label7:
      break label7;
    }
    localBaseQQAppInterface = null;
    if (localBaseQQAppInterface == null)
    {
      QLog.e("FileModel<FileAssistant>", 1, "Start VideoActivity is not in QQ!");
      return;
    }
    if (a(paramActivity, localBaseQQAppInterface)) {
      return;
    }
    b(paramActivity, paramInt, 10004);
  }
  
  private void b(Activity paramActivity, int paramInt1, int paramInt2)
  {
    try
    {
      localObject = QQFileManagerUtilImpl.a();
    }
    catch (Exception localException)
    {
      Object localObject;
      label8:
      ForwardFileInfo localForwardFileInfo;
      break label8;
    }
    localObject = null;
    if (localObject == null)
    {
      QLog.e("FileModel<FileAssistant>", 1, "Start VideoActivity is not in QQ!");
      return;
    }
    localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(paramInt2);
    if (this.a.bSend) {
      localObject = ((BaseQQAppInterface)localObject).getAccount();
    } else {
      localObject = this.a.peerUin;
    }
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
    localObject = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getIntentForFileBrowserActivity(paramActivity);
    ((Intent)localObject).putExtra("fileinfo", localForwardFileInfo);
    ((Intent)localObject).putExtra("file_enter_file_browser_type", paramInt1);
    ((Intent)localObject).putExtra("selfSet_leftViewText", HardCodeUtil.a(2131704663));
    paramActivity.startActivityForResult((Intent)localObject, 102);
    paramActivity.overridePendingTransition(2130772065, 2130772067);
  }
  
  private boolean b(Activity paramActivity, int paramInt)
  {
    return ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).checkFileWithCUKingCardHelper(paramActivity, paramInt, new QQFileModel.3(this));
  }
  
  private boolean b(boolean paramBoolean, Activity paramActivity, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    return ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).checkWifiWithCUKingCardHelper(paramBoolean, paramActivity, paramFMDialogInterface);
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    if (this.a.nFileType == 2)
    {
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        FMToastUtil.a(2131694709);
        return;
      }
      if ((this.a.getCloudType() == 1) && (QQFileManagerUtilImpl.a()) && (this.a.status != 2) && (this.a.fileSize > 1048576L))
      {
        QQFileModel.1 local1 = new QQFileModel.1(this, paramActivity, paramInt);
        boolean bool2 = b(paramActivity, paramInt);
        boolean bool1 = bool2;
        if (bool2) {
          bool1 = a(paramActivity, paramInt);
        }
        if (bool1) {
          FMDialogUtil.a(paramActivity, paramActivity.getString(2131692561), paramActivity.getString(2131692563), local1);
        }
        return;
      }
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
    if (!NetworkUtil.isNetSupportHw(BaseApplication.getContext()))
    {
      FMToastUtil.a(2131693191);
      return;
    }
    if (a(paramBoolean ^ true))
    {
      Activity localActivity = (Activity)paramContext;
      boolean bool2 = b(paramBoolean, localActivity, paramFMDialogInterface);
      boolean bool1 = bool2;
      if (bool2) {
        bool1 = a(paramBoolean, localActivity, paramFMDialogInterface);
      }
      if (bool1)
      {
        int i;
        if (paramBoolean) {
          i = 2131692566;
        } else {
          i = 2131692563;
        }
        FMDialogUtil.a(paramContext, 2131692561, i, paramFMDialogInterface);
      }
    }
    else
    {
      paramFMDialogInterface.a();
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      return false;
    }
    if (!QQFileManagerUtilImpl.a())
    {
      a("FlowShow", " donot ShowFlowDialog! Wi-Fi");
      return false;
    }
    long l2 = ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize();
    long l1 = ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogTime();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fileSize ");
    localStringBuilder.append(this.a.fileSize);
    localStringBuilder.append(",limit  ");
    localStringBuilder.append(l2);
    a("FlowShow", localStringBuilder.toString());
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
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("cloudeType ");
      localStringBuilder.append(this.a.cloudType);
      localStringBuilder.append(" is not local File donot show!");
      a("FlowShow", localStringBuilder.toString());
      return false;
    }
    l2 = MessageCache.a();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("last Succ ");
    localStringBuilder.append(this.a.lastSuccessTime);
    localStringBuilder.append(" now ");
    localStringBuilder.append(MessageCache.a());
    localStringBuilder.append(" = ");
    localStringBuilder.append(l2 - this.a.lastSuccessTime);
    localStringBuilder.append(" limit[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    a("FlowShow", localStringBuilder.toString());
    if (l2 - this.a.lastSuccessTime < l1) {
      return false;
    }
    a("FlowShow", "Must show!");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.recreate.QQFileModel
 * JD-Core Version:    0.7.0.1
 */