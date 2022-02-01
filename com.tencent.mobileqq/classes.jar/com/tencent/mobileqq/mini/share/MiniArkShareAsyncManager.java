package com.tencent.mobileqq.mini.share;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.webkit.URLUtil;
import aqcb;
import bizw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.mini.launch.CmdCallback;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;

public class MiniArkShareAsyncManager
{
  private static final String TAG = "MiniArkShareAsyncManage [miniappArkShare]";
  
  static void performChangeArkShareImageUrl(String paramString, CmdCallback paramCmdCallback)
  {
    if (TextUtils.isEmpty(paramString)) {
      try
      {
        paramCmdCallback.onCmdResult(true, new Bundle());
        return;
      }
      catch (RemoteException paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
    MiniAppCmdUtil.getInstance().changeShareImageUrl(paramString, new MiniArkShareAsyncManager.3(paramCmdCallback));
  }
  
  public static void performShareArkAsyncMessage(Bundle paramBundle, CmdCallback paramCmdCallback)
  {
    if (paramBundle == null)
    {
      if (paramCmdCallback != null) {}
      try
      {
        paramCmdCallback.onCmdResult(false, new Bundle());
        return;
      }
      catch (RemoteException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
    }
    String str3 = paramBundle.getString("forward_ark_app_name");
    String str2 = paramBundle.getString("sharePicturePath");
    int i;
    if ((!URLUtil.isHttpUrl(str2)) && (!URLUtil.isHttpsUrl(str2)))
    {
      i = 1;
      label63:
      if ((i == 0) || (str2 == null)) {
        break label263;
      }
    }
    label263:
    for (String str1 = ArkAppCenterUtil.CopyFileToCache(str3, str2);; str1 = str2)
    {
      Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject1 instanceof QQAppInterface))
      {
        localObject1 = (QQAppInterface)localObject1;
        Object localObject2 = (ArkAppCenter)((QQAppInterface)localObject1).getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER);
        if (localObject2 != null)
        {
          localObject2 = ((ArkAppCenter)localObject2).a();
          if (localObject2 != null) {
            ((aqcb)localObject2).a(str3, new MiniArkShareAsyncPreprocessor(paramBundle));
          }
        }
        if (i != 0)
        {
          paramBundle = ((QQAppInterface)localObject1).getEntityManagerFactory().createEntityManager();
          if (paramBundle != null)
          {
            paramBundle.persistOrReplace(new MiniProgramArkShareLocalImageEntity(str1, str2));
            if (QLog.isColorLevel()) {
              QLog.d("MiniArkShareAsyncManage [miniappArkShare]", 2, "performShareArkAsyncMessage: persist to database, arkPath:" + str1 + ",sharePicturePath:" + str2);
            }
          }
        }
      }
      if (paramCmdCallback == null) {
        break;
      }
      try
      {
        paramBundle = new Bundle();
        if (i != 0) {
          paramBundle.putString("arkPath", str1);
        }
        paramCmdCallback.onCmdResult(true, paramBundle);
        return;
      }
      catch (RemoteException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      i = 0;
      break label63;
    }
  }
  
  public static void performUploadArkShareImage(String paramString, CmdCallback paramCmdCallback)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        TransferRequest localTransferRequest = new TransferRequest();
        localTransferRequest.mIsUp = true;
        localTransferRequest.mLocalPath = paramString;
        localTransferRequest.mCommandId = 62;
        localTransferRequest.mUniseq = ((Math.random() * 1000000.0D));
        localTransferRequest.mPeerUin = "0";
        localTransferRequest.mSelfUin = String.valueOf(bizw.a().a());
        localTransferRequest.mFileType = 24;
        localTransferRequest.mRichTag = "miniAppArkShareUploadPicHit";
        paramString = new Bdh_extinfo.CommFileExtReq();
        paramString.uint32_action_type.set(0);
        paramString.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
        localTransferRequest.mExtentionInfo = paramString.toByteArray();
        paramString = new MiniArkShareAsyncTransProcessorHandler(ThreadManagerV2.getFileThreadLooper(), paramCmdCallback);
        paramString.addFilter(new Class[] { BDHCommonUploadProcessor.class });
        if (((QQAppInterface)localObject).getTransFileController() != null)
        {
          ((QQAppInterface)localObject).getTransFileController().addHandle(paramString);
          ((QQAppInterface)localObject).getTransFileController().transferAsync(localTransferRequest);
        }
      }
    }
    do
    {
      return;
      QLog.e("MiniArkShareAsyncManage [miniappArkShare]", 2, "performUploadArkShareImage empty local image path");
    } while (paramCmdCallback == null);
    try
    {
      paramCmdCallback.onCmdResult(false, new Bundle());
      return;
    }
    catch (RemoteException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void registerMiniArkShareMessageProcessorAfterProcessRestart()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (ArkAppCenter)((QQAppInterface)localObject).getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER);
      if (localObject != null)
      {
        localObject = ((ArkAppCenter)localObject).a();
        if (localObject != null)
        {
          ((aqcb)localObject).a("com.tencent.miniapp", new MiniArkShareAsyncPreprocessor(new Bundle()));
          QLog.d("MiniArkShareAsyncManage [miniappArkShare]", 2, "registerMiniArkShareMessageProcessorAfterProcessRestart");
        }
      }
    }
  }
  
  static void removeArkShareLocalImageDatabaseEntity(String paramString)
  {
    ThreadManagerV2.executeOnFileThread(new MiniArkShareAsyncManager.1(paramString));
  }
  
  public static void removeArkShareLocalTemporaryFile(String paramString)
  {
    ThreadManagerV2.executeOnFileThread(new MiniArkShareAsyncManager.2(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.share.MiniArkShareAsyncManager
 * JD-Core Version:    0.7.0.1
 */