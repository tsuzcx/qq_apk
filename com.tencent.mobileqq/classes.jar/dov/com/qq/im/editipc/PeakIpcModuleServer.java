package dov.com.qq.im.editipc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.PicUploadInfo.RetryInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgManager;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoForwardInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor;
import com.tencent.mobileqq.transfile.ShortVideoForwardProcessor;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.capture.CaptureContext;
import eipc.EIPCResult;
import java.util.UUID;

public class PeakIpcModuleServer
  extends QIPCModule
{
  private static PeakIpcModuleServer a;
  
  private PeakIpcModuleServer(String paramString)
  {
    super(paramString);
  }
  
  /* Error */
  public static PeakIpcModuleServer a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 14	dov/com/qq/im/editipc/PeakIpcModuleServer:a	Ldov/com/qq/im/editipc/PeakIpcModuleServer;
    //   6: ifnonnull +27 -> 33
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 14	dov/com/qq/im/editipc/PeakIpcModuleServer:a	Ldov/com/qq/im/editipc/PeakIpcModuleServer;
    //   15: ifnonnull +15 -> 30
    //   18: new 2	dov/com/qq/im/editipc/PeakIpcModuleServer
    //   21: dup
    //   22: ldc 16
    //   24: invokespecial 17	dov/com/qq/im/editipc/PeakIpcModuleServer:<init>	(Ljava/lang/String;)V
    //   27: putstatic 14	dov/com/qq/im/editipc/PeakIpcModuleServer:a	Ldov/com/qq/im/editipc/PeakIpcModuleServer;
    //   30: ldc 2
    //   32: monitorexit
    //   33: getstatic 14	dov/com/qq/im/editipc/PeakIpcModuleServer:a	Ldov/com/qq/im/editipc/PeakIpcModuleServer;
    //   36: astore_0
    //   37: ldc 2
    //   39: monitorexit
    //   40: aload_0
    //   41: areturn
    //   42: astore_0
    //   43: ldc 2
    //   45: monitorexit
    //   46: aload_0
    //   47: athrow
    //   48: astore_0
    //   49: ldc 2
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   36	5	0	localPeakIpcModuleServer	PeakIpcModuleServer
    //   42	5	0	localObject1	Object
    //   48	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	30	42	finally
    //   30	33	42	finally
    //   43	46	42	finally
    //   3	12	48	finally
    //   33	37	48	finally
    //   46	48	48	finally
  }
  
  private void a(String paramString1, String paramString2)
  {
    AEQLog.b("PeakIpcModuleServer", "uploadVideo---videoFilePath=" + paramString1 + ", callbackClientName=" + paramString2);
    ITransFileController localITransFileController = (ITransFileController)CaptureContext.a().getRuntimeService(ITransFileController.class, "");
    paramString2 = new PeakIpcModuleServer.4(this, localITransFileController, paramString2);
    paramString2.addFilter(new Class[] { BDHCommonUploadProcessor.class });
    localITransFileController.addHandle(paramString2);
    paramString2 = new TransferRequest();
    paramString2.mIsUp = true;
    paramString2.mLocalPath = paramString1;
    paramString2.mFileType = 24;
    paramString2.mCommandId = 82;
    paramString2.mRichTag = "ae_camera_ark_video_upload_statistic_tag";
    paramString2.mPeerUin = "0";
    paramString2.mSelfUin = CaptureContext.a().getCurrentAccountUin();
    paramString1 = new Bdh_extinfo.CommFileExtReq();
    paramString1.uint32_action_type.set(0);
    paramString1.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString() + ".mp4"));
    paramString2.mExtentionInfo = paramString1.toByteArray();
    localITransFileController.transferAsync(paramString2);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PeakIpcModuleServer", 2, "[onCall]action= " + paramString);
    }
    Object localObject1 = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localObject1 instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PeakIpcModuleServer", 2, "[onCall] get app failed.");
      }
      return null;
    }
    Bundle localBundle = new Bundle();
    Object localObject2;
    boolean bool1;
    if ("action_start_send".equals(paramString))
    {
      paramBundle = (Intent)paramBundle.getParcelable("key_intent");
      if (paramBundle != null)
      {
        paramString = (QQAppInterface)localObject1;
        localObject1 = paramBundle.getStringExtra("thumbfile_send_path");
        localObject2 = paramBundle.getStringExtra("thumbfile_md5");
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
          ThreadManager.post(new PeakIpcModuleServer.1(this, (String)localObject2, (String)localObject1), 5, null, false);
        }
        localObject1 = ShortVideoBusiManager.a(3, 0);
        localObject2 = ShortVideoBusiManager.a(0, paramBundle, (ShortVideoReq)localObject1);
        ((ShortVideoForwardInfo)localObject2).d = true;
        ((ShortVideoReq)localObject1).a((ShortVideoForwardInfo)localObject2);
        ShortVideoBusiManager.a((ShortVideoReq)localObject1, paramString);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("sendVideo intent= ");
        if (paramBundle != null)
        {
          paramString = paramBundle.getExtras();
          QLog.d("PeakIpcModuleServer", 2, paramString);
        }
      }
      else
      {
        if (paramBundle == null) {
          break label268;
        }
      }
      label268:
      for (bool1 = true;; bool1 = false)
      {
        localBundle.putBoolean("key_result", bool1);
        paramString = EIPCResult.createSuccessResult(localBundle);
        callbackResult(paramInt, paramString);
        return null;
        paramString = "";
        break;
      }
    }
    int i;
    long l2;
    long l1;
    if ("action_cancel_send".equals(paramString))
    {
      localObject2 = paramBundle.getString("uin");
      i = paramBundle.getInt("uintype");
      l2 = paramBundle.getLong("key_uinsequence");
      paramBundle = (QQAppInterface)localObject1;
      localObject1 = paramBundle.getMessageFacade().a((String)localObject2, i, l2);
      paramString = ((ITransFileController)paramBundle.getRuntimeService(ITransFileController.class)).findProcessor((String)localObject2, l2);
      if (localObject1 != null)
      {
        l1 = ((MessageRecord)localObject1).uniseq;
        label363:
        if ((!(paramString instanceof ShortVideoForwardProcessor)) || (((ShortVideoForwardProcessor)paramString).isUploadSuccess)) {
          break label599;
        }
        ((ShortVideoForwardProcessor)paramString).pause();
        bool1 = true;
        paramString = "forwardVideo";
      }
    }
    for (;;)
    {
      label394:
      boolean bool3;
      if (bool1)
      {
        bool3 = ((ITransFileController)paramBundle.getRuntimeService(ITransFileController.class)).removeProcessor((String)localObject2 + l2);
        OrderMediaMsgManager.a(paramBundle, (String)localObject2, l2);
        bool2 = bool3;
        if (localObject1 != null) {
          ThreadManager.post(new PeakIpcModuleServer.2(this, paramBundle, (MessageRecord)localObject1), 8, null, true);
        }
      }
      for (boolean bool2 = bool3;; bool2 = false)
      {
        label599:
        Object localObject3;
        for (;;)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("PeakIpcModuleServer", 2, "cancelInfo, uinseq:" + (String)localObject2 + ", uinType:" + i + ", sequence:" + l2 + ", msgSequence" + l1 + ", cancel:" + bool1 + ", removeProcess:" + bool2 + ", tips:" + paramString);
            }
            localBundle.putBoolean("key_result", bool1);
            paramString = EIPCResult.createSuccessResult(localBundle);
            break;
            l1 = -1L;
            break label363;
            if (((paramString instanceof C2CPicUploadProcessor)) && (!((C2CPicUploadProcessor)paramString).uploadSuccess))
            {
              ((C2CPicUploadProcessor)paramString).pause();
              bool1 = true;
              paramString = "C2CPic";
              break label394;
            }
            if ((!(paramString instanceof GroupPicUploadProcessor)) || (((GroupPicUploadProcessor)paramString).uploadSuccess)) {
              break label2109;
            }
            ((GroupPicUploadProcessor)paramString).pause();
            bool1 = true;
            paramString = "GroupPic";
            break label394;
            if ("action_pic_start_send".equals(paramString))
            {
              paramBundle.setClassLoader(getClass().getClassLoader());
              paramString = paramBundle.getString("key_file_path");
              localObject2 = (SessionInfo)paramBundle.getParcelable("key_session");
              localObject3 = paramBundle.getString("widgetinfo", "");
              paramBundle = paramBundle.getString("key_camera_material_name", "");
              if (!TextUtils.isEmpty(paramString))
              {
                Intent localIntent = new Intent();
                localIntent.putExtra("key_story_photo_to_recent", true);
                if (!TextUtils.isEmpty((CharSequence)localObject3))
                {
                  localIntent.putExtra("widgetinfo", (String)localObject3);
                  localIntent.putExtra("key_camera_material_name", paramBundle);
                }
                ForwardUtils.a(localIntent, (SessionInfo)localObject2, paramString, (QQAppInterface)localObject1);
                localBundle.putBoolean("key_result", true);
              }
              for (bool1 = true;; bool1 = false)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("PeakIpcModuleServer", 2, "sendPic success:" + bool1 + ", photoPath：" + paramString);
                }
                paramString = EIPCResult.createSuccessResult(localBundle);
                break;
                localBundle.putBoolean("key_result", false);
              }
            }
            if ("action_re_send".equals(paramString))
            {
              paramString = paramBundle.getString("uin");
              i = paramBundle.getInt("uintype");
              l1 = paramBundle.getLong("key_uinsequence");
              paramBundle = (QQAppInterface)localObject1;
              paramString = paramBundle.getMessageFacade().a(paramString, i, l1);
              bool2 = false;
              if ((paramString instanceof MessageForShortVideo))
              {
                localObject1 = (MessageForShortVideo)paramString;
                if ((FileUtils.b(ShortVideoUtils.getShortVideoThumbPicPath(((MessageForShortVideo)localObject1).thumbMD5, "jpg"))) && (!TextUtils.isEmpty(((MessageForShortVideo)localObject1).videoFileName)) && (((MessageForShortVideo)localObject1).isStoryVideo))
                {
                  ((OrderMediaMsgManager)paramBundle.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a(((MessageForShortVideo)localObject1).frienduin, (MessageRecord)localObject1, ((MessageForShortVideo)localObject1).videoFileName);
                  localObject1 = ShortVideoBusiManager.a(4, 0);
                  localObject2 = ShortVideoBusiManager.a(0, paramString, (ShortVideoReq)localObject1);
                  ((ShortVideoForwardInfo)localObject2).d = true;
                  ((ShortVideoReq)localObject1).a((ShortVideoForwardInfo)localObject2);
                  ShortVideoBusiManager.a((ShortVideoReq)localObject1, paramBundle);
                  bool1 = true;
                  label1047:
                  if (QLog.isColorLevel())
                  {
                    paramBundle = new StringBuilder().append("reSend success:").append(bool1).append(", message：");
                    if (paramString == null) {
                      break label1475;
                    }
                  }
                }
              }
              label1475:
              for (paramString = paramString.toString();; paramString = "")
              {
                QLog.d("PeakIpcModuleServer", 2, paramString);
                localBundle.putBoolean("key_result", bool1);
                paramString = EIPCResult.createSuccessResult(localBundle);
                break;
                ((MessageForShortVideo)localObject1).videoFileStatus = 1005;
                bool1 = false;
                break label1047;
                bool1 = bool2;
                if (!(paramString instanceof MessageForPic)) {
                  break label1047;
                }
                localObject1 = (MessageForPic)paramString;
                bool1 = bool2;
                if (!FileUtils.b(((MessageForPic)localObject1).path)) {
                  break label1047;
                }
                bool1 = bool2;
                if (!((MessageForPic)localObject1).isStoryPhoto) {
                  break label1047;
                }
                ThreadManager.post(new PeakIpcModuleServer.3(this, paramBundle, (MessageForPic)localObject1), 5, null, false);
                if (((MessageForPic)localObject1).isSendFromLocal()) {
                  ((ITransFileController)paramBundle.getRuntimeService(ITransFileController.class)).removeProcessor(BaseTransFileController.makeKey(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).uniseq));
                }
                localObject2 = new PicUploadInfo.Builder();
                ((PicUploadInfo.Builder)localObject2).a(((MessageForPic)localObject1).path);
                ((PicUploadInfo.Builder)localObject2).d(5);
                ((PicUploadInfo.Builder)localObject2).d(((MessageForPic)localObject1).frienduin);
                if (((MessageForPic)localObject1).fileSizeFlag == 1) {
                  ((PicUploadInfo.Builder)localObject2).c(TranDbRecord.PicDbRecord.EXTRA_FLAG_SEND_RAW_PHOTO);
                }
                for (;;)
                {
                  ((PicUploadInfo.Builder)localObject2).e(((MessageForPic)localObject1).senderuin);
                  ((PicUploadInfo.Builder)localObject2).c(((MessageForPic)localObject1).selfuin);
                  ((PicUploadInfo.Builder)localObject2).e(((MessageForPic)localObject1).istroop);
                  ((PicUploadInfo.Builder)localObject2).l(((MessageForPic)localObject1).getConfessTopicId());
                  ((PicUploadInfo.Builder)localObject2).jdField_i_of_type_Int = ((MessageForPic)localObject1).extLong;
                  ((PicUploadInfo.Builder)localObject2).jdField_i_of_type_JavaLangString = ((MessageForPic)localObject1).extStr;
                  ((PicUploadInfo.Builder)localObject2).b(true);
                  localObject3 = new PicUploadInfo.RetryInfo();
                  ((PicUploadInfo.RetryInfo)localObject3).a = ((MessageForPic)localObject1).msgseq;
                  ((PicUploadInfo.RetryInfo)localObject3).b = ((MessageForPic)localObject1).shmsgseq;
                  ((PicUploadInfo.RetryInfo)localObject3).c = ((MessageForPic)localObject1).msgUid;
                  ((PicUploadInfo.Builder)localObject2).a((PicUploadInfo.RetryInfo)localObject3);
                  ((PicUploadInfo.Builder)localObject2).b(((MessageForPic)localObject1).uniseq);
                  ((OrderMediaMsgManager)paramBundle.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).uniseq);
                  paramBundle = PicBusiManager.a(4, 5);
                  paramBundle.a(((PicUploadInfo.Builder)localObject2).a());
                  paramBundle.a = ((MessageForPic)localObject1).picExtraData;
                  PicBusiManager.a(paramBundle);
                  bool1 = true;
                  break;
                  ((PicUploadInfo.Builder)localObject2).c(TranDbRecord.PicDbRecord.EXTRA_FLAG_SEND_PHOTO);
                }
              }
            }
            if ("action_get_troop_member_name".equals(paramString))
            {
              paramString = paramBundle.getString("troop_uin");
              paramBundle = paramBundle.getString("uin");
              try
              {
                localObject1 = (TroopManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.TROOP_MANAGER);
                paramString = ((TroopManager)localObject1).a(((TroopManager)localObject1).b(paramString), paramBundle);
                localBundle.putBoolean("key_result", true);
                localBundle.putString("uinname", paramString);
                paramString = EIPCResult.createSuccessResult(localBundle);
              }
              catch (Exception paramString)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("PeakIpcModuleServer", 2, "getTroopMemberName exception = " + paramString.getMessage());
                  }
                  paramString.printStackTrace();
                  paramString = "";
                }
              }
            }
          }
          if ("action_get_troop_info".equals(paramString))
          {
            paramString = paramBundle.getString("troop_uin");
            try
            {
              paramBundle = (TroopManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.TROOP_MANAGER);
              paramString = paramBundle.a(paramBundle.b(paramString), true);
              if (paramString != null)
              {
                localBundle.putBoolean("key_result", true);
                localBundle.putBoolean("troop_owner", paramString.isDisband());
                if ((paramString.isNewTroop()) && (!paramString.hasSetTroopHead())) {}
                for (bool1 = true;; bool1 = false)
                {
                  localBundle.putBoolean("troop_code", bool1);
                  paramString = EIPCResult.createSuccessResult(localBundle);
                  return paramString;
                }
              }
            }
            catch (Exception paramString)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PeakIpcModuleServer", 2, "ACTION_GET_TROOP_INFO exception = " + paramString.getMessage());
              }
              paramString.printStackTrace();
              paramString = null;
            }
          }
        }
        if ("action_get_name".equals(paramString))
        {
          paramString = paramBundle.getString("uin");
          try
          {
            paramString = ContactUtils.b((QQAppInterface)localObject1, paramString);
            localBundle.putBoolean("key_result", true);
            localBundle.putString("uinname", paramString);
            paramString = EIPCResult.createSuccessResult(localBundle);
            return paramString;
          }
          catch (Exception paramString)
          {
            if (QLog.isColorLevel()) {
              QLog.d("PeakIpcModuleServer", 2, "ACTION_GET_NAME exception = " + paramString.getMessage());
            }
            paramString.printStackTrace();
            paramString = null;
          }
          break;
        }
        if ("action_send_video_ark_msg".equals(paramString))
        {
          try
          {
            paramBundle.setClassLoader(SessionInfo.class.getClassLoader());
            paramString = (SessionInfo)paramBundle.getParcelable("key_session");
            localObject2 = paramBundle.getString("key_ark_msg_app_view");
            paramBundle = paramBundle.getString("key_ark_msg_meta_json");
            localObject3 = new ArkAppMessage();
            ((ArkAppMessage)localObject3).promptText = "promptTest";
            ((ArkAppMessage)localObject3).appMinVersion = "1.0.0.29";
            ((ArkAppMessage)localObject3).appName = "com.tencent.subscription";
            ((ArkAppMessage)localObject3).appView = ((String)localObject2);
            ((ArkAppMessage)localObject3).metaList = paramBundle;
            ChatActivityFacade.b((QQAppInterface)localObject1, paramString, (ArkAppMessage)localObject3);
            paramString = EIPCResult.createSuccessResult(localBundle);
            return paramString;
          }
          catch (Exception paramString)
          {
            if (QLog.isColorLevel()) {
              QLog.d("PeakIpcModuleServer", 2, "ACTION_SEND_VIDEO_ARK_MSG exception = " + paramString.getMessage());
            }
            paramString.printStackTrace();
            paramString = null;
          }
          break;
        }
        if ("action_upload_ark_video".equals(paramString)) {
          try
          {
            a(paramBundle.getString("key_upload_ark_video_path"), paramBundle.getString("key_upload_ark_video_callback_client_name"));
            paramString = EIPCResult.createSuccessResult(localBundle);
            return paramString;
          }
          catch (Exception paramString)
          {
            if (QLog.isColorLevel()) {
              QLog.d("PeakIpcModuleServer", 2, "ACTION_SEND_VIDEO_ARK_MSG exception = " + paramString.getMessage());
            }
            paramString.printStackTrace();
          }
        }
        paramString = null;
        break;
      }
      label2109:
      paramString = "";
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.editipc.PeakIpcModuleServer
 * JD-Core Version:    0.7.0.1
 */