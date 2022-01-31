package com.tencent.mobileqq.richmedia;

import ahlh;
import ahli;
import ahlk;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.ShortVideoPresendStats;
import com.tencent.mobileqq.transfile.ShortVideoUploadABTest;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.VideoSliceInfo;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.os.MqqHandler;

public class VideoSendTaskManager
{
  private static VideoSendTaskManager jdField_a_of_type_ComTencentMobileqqRichmediaVideoSendTaskManager;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManager.getSubThreadLooper());
  
  private MessageForShortVideo a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    Object localObject = (SessionInfo)paramBundle.getParcelable("PhotoConst.SEND_SESSION_INFO");
    paramQQAppInterface = MessageRecordFactory.a(paramQQAppInterface, ((SessionInfo)localObject).jdField_a_of_type_JavaLangString, ((SessionInfo)localObject).jdField_b_of_type_JavaLangString, ((SessionInfo)localObject).jdField_a_of_type_Int);
    localObject = paramBundle.getString("video_thumb_path");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramQQAppInterface.mThumbFilePath = ((String)localObject);
      paramQQAppInterface.thumbWidth = paramBundle.getInt("video_thumb_width");
      paramQQAppInterface.thumbHeight = paramBundle.getInt("video_thumb_height");
      paramQQAppInterface.thumbMD5 = paramBundle.getString("video_thumb_md5");
    }
    paramQQAppInterface.lastModified = 0L;
    paramQQAppInterface.fileSource = "camera";
    paramQQAppInterface.extraflag = 32772;
    paramQQAppInterface.videoFileStatus = 999;
    paramQQAppInterface.videoFileFormat = 2;
    paramQQAppInterface.videoFileProgress = 0;
    int i;
    if ((paramQQAppInterface.istroop == 0) || (paramQQAppInterface.istroop == 1008))
    {
      paramQQAppInterface.fileType = 6;
      i = paramBundle.getInt("video_busi_type");
      if (paramQQAppInterface.istroop != 1008) {
        break label240;
      }
      paramQQAppInterface.busiType = 1007;
    }
    for (;;)
    {
      if (paramQQAppInterface.busiType != 2) {
        paramQQAppInterface.msg = "[视频]";
      }
      paramQQAppInterface.fromChatType = -1;
      paramQQAppInterface.toChatType = -1;
      paramQQAppInterface.uiOperatorFlag = 1;
      paramQQAppInterface.serial();
      paramQQAppInterface.mPreUpload = true;
      return paramQQAppInterface;
      if (paramQQAppInterface.istroop == 3000)
      {
        paramQQAppInterface.fileType = 17;
        break;
      }
      if (paramQQAppInterface.istroop != 1) {
        break;
      }
      paramQQAppInterface.fileType = 9;
      break;
      label240:
      if (2 == i)
      {
        paramQQAppInterface.busiType = 1;
      }
      else if (3 == i)
      {
        paramQQAppInterface.busiType = 2;
        paramQQAppInterface.msg = "[视频对讲]";
      }
      else
      {
        paramQQAppInterface.busiType = 0;
      }
    }
  }
  
  public static VideoSendTaskManager a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqRichmediaVideoSendTaskManager == null) {
        jdField_a_of_type_ComTencentMobileqqRichmediaVideoSendTaskManager = new VideoSendTaskManager();
      }
      VideoSendTaskManager localVideoSendTaskManager = jdField_a_of_type_ComTencentMobileqqRichmediaVideoSendTaskManager;
      return localVideoSendTaskManager;
    }
    finally {}
  }
  
  private TransferRequest a(UpCallBack paramUpCallBack)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack = paramUpCallBack;
    localTransferRequest.i = true;
    return localTransferRequest;
  }
  
  private void a(HashMap paramHashMap)
  {
    ThreadManager.post(new ahlh(this, paramHashMap), 5, null, true);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    TransferRequest localTransferRequest = (TransferRequest)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localTransferRequest == null) {}
    while (localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) {
      return;
    }
    ((SVIPHandler)paramQQAppInterface.a(13)).a(localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    paramQQAppInterface.a().a(localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, paramQQAppInterface.getCurrentAccountUin());
    LogTag.a(paramString, "addMsg", "[addMsg] is " + localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle)
  {
    TransFileController localTransFileController = paramQQAppInterface.a();
    TransferRequest localTransferRequest = a(new ahli(this, paramQQAppInterface, paramString));
    paramQQAppInterface = a(paramQQAppInterface, paramBundle);
    paramQQAppInterface.uniseq = Long.parseLong(paramString);
    localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramQQAppInterface;
    localTransferRequest.jdField_b_of_type_JavaLangString = paramQQAppInterface.selfuin;
    localTransferRequest.c = paramQQAppInterface.frienduin;
    localTransferRequest.jdField_a_of_type_Int = paramQQAppInterface.istroop;
    localTransferRequest.jdField_a_of_type_Long = paramQQAppInterface.uniseq;
    localTransferRequest.jdField_b_of_type_Int = paramQQAppInterface.fileType;
    localTransferRequest.j = paramQQAppInterface.mThumbFilePath;
    localTransferRequest.k = paramQQAppInterface.thumbMD5;
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.e = paramQQAppInterface.busiType;
    localTransFileController.a(localTransferRequest);
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localTransferRequest);
    LogTag.a(paramString, "segment", "[sendThumbTask] " + paramQQAppInterface.toString());
    LogTag.a(paramString, "segment", "[sendThumbTask] " + localTransferRequest.toString());
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, VideoSliceInfo paramVideoSliceInfo)
  {
    paramQQAppInterface = paramQQAppInterface.a();
    String str;
    long l;
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) && (paramVideoSliceInfo != null))
    {
      str = paramVideoSliceInfo.jdField_a_of_type_JavaLangString;
      if (TextUtils.isEmpty(str)) {
        break label103;
      }
      l = new File(str).length();
      if (l != 0L) {
        break label92;
      }
      if (QLog.isColorLevel()) {
        QLog.i("PreUploadVideo", 2, "[sendVideoTask]submit " + paramVideoSliceInfo.jdField_a_of_type_Int);
      }
    }
    label92:
    label103:
    do
    {
      return;
      paramVideoSliceInfo.jdField_b_of_type_JavaLangString = FileUtils.a(str, l);
      paramQQAppInterface = paramQQAppInterface.a(((TransferRequest)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).a());
    } while ((paramQQAppInterface == null) || (!ShortVideoUploadProcessor.class.isInstance(paramQQAppInterface)));
    ((ShortVideoUploadProcessor)paramQQAppInterface).a(paramVideoSliceInfo);
    if (!paramVideoSliceInfo.jdField_a_of_type_Boolean)
    {
      LogTag.a(paramString, "segment", "[sendVideoTask] Submit " + paramVideoSliceInfo.toString());
      return;
    }
    LogTag.a(paramString, "segment", "[sendVideoTask] All encode end");
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean, int paramInt)
  {
    TransferRequest localTransferRequest = (TransferRequest)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localTransferRequest == null) {}
    do
    {
      return;
      localObject = localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    } while (!MessageForShortVideo.class.isInstance(localObject));
    Object localObject = (MessageForShortVideo)localObject;
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uniseq", paramString);
    localHashMap.put("param_reason", String.valueOf(paramInt));
    localHashMap.put("param_needWait", String.valueOf(paramBoolean));
    localHashMap.put("param_frienduin", ((MessageForShortVideo)localObject).frienduin);
    localHashMap.put("param_busiType", String.valueOf(((MessageForShortVideo)localObject).busiType));
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = localHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (localHashMap.get(str) != null)
      {
        localStringBuilder.append("&");
        localStringBuilder.append(str);
        localStringBuilder.append("=");
        localStringBuilder.append((String)localHashMap.get(str));
      }
    }
    LogTag.a(String.valueOf(paramString), "report", "actPreUploadVideoCancel : " + localStringBuilder.toString());
    a(localHashMap);
    if (!paramBoolean)
    {
      ((MessageForShortVideo)localObject).mPreUpload = false;
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
    }
    paramQQAppInterface = paramQQAppInterface.a().a(localTransferRequest.a());
    if ((paramQQAppInterface != null) && (ShortVideoUploadProcessor.class.isInstance(paramQQAppInterface))) {
      ((ShortVideoUploadProcessor)paramQQAppInterface).a(paramBoolean, paramInt);
    }
    LogTag.a(paramString, "cancelPreUpload", "[cancelPreUpload] isNeedWait = " + paramBoolean + ", cancelReason = " + paramInt);
  }
  
  public void b(QQAppInterface paramQQAppInterface, String paramString, Bundle paramBundle)
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
      LogTag.a(paramString, "clicomp", "[videoMerged]No request found");
    }
    TransferRequest localTransferRequest;
    Object localObject;
    String str2;
    long l1;
    do
    {
      do
      {
        return;
        localTransferRequest = (TransferRequest)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        localObject = localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      } while (!MessageForShortVideo.class.isInstance(localObject));
      localObject = (MessageForShortVideo)localObject;
      str2 = paramBundle.getString("full_video_path");
      l1 = new File(str2).length();
      if (l1 != 0L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("PreUploadVideo", 2, "[videoMerged] videoSize = 0");
    return;
    String str3 = FileUtils.a(str2, l1);
    long l2 = SystemClock.uptimeMillis();
    try
    {
      ((MessageForShortVideo)localObject).mLocalMd5 = str3;
      String str1 = ShortVideoUtils.a((MessageForShortVideo)localObject, "mp4");
      ((MessageForShortVideo)localObject).videoFileTime = paramBundle.getInt("video_slices_total_time_length");
      ((MessageForShortVideo)localObject).videoFileName = str1;
      ((MessageForShortVideo)localObject).videoFileSize = ((int)l1);
      ((MessageForShortVideo)localObject).serial();
      if (QLog.isColorLevel()) {
        QLog.i("PreUploadVideo", 2, "[updateMsg] videoMerged serialcost:" + (SystemClock.uptimeMillis() - l2));
      }
      if (!str2.equals(str1))
      {
        FileUtils.c(str2, str1);
        LogTag.a(paramString, "clicomp", "[videoMerged] Rename merged video\nmergedVideoPath = " + str2 + ",destVideoPath = " + str1 + ", localMd5=" + str3);
      }
      l1 = paramBundle.getLong("video_merge_mp4_time_cost");
      if (ShortVideoUploadABTest.a()) {
        ShortVideoUploadABTest.a(paramQQAppInterface, ((MessageForShortVideo)localObject).uniseq, l1, str1);
      }
      ShortVideoPresendStats.a(paramQQAppInterface, ((MessageForShortVideo)localObject).uniseq, l1);
      paramQQAppInterface.a().a(((MessageForShortVideo)localObject).frienduin, ((MessageForShortVideo)localObject).istroop, ((MessageForShortVideo)localObject).uniseq, ((MessageForShortVideo)localObject).msgData);
      paramQQAppInterface.a().a(localObject);
      LogTag.a(paramString, "clicomp", "[videoMerged]" + localObject);
      paramQQAppInterface = paramQQAppInterface.a().a(localTransferRequest.a());
      if (ShortVideoUploadProcessor.class.isInstance(paramQQAppInterface)) {
        ((ShortVideoUploadProcessor)paramQQAppInterface).a(str1, ((MessageForShortVideo)localObject).videoFileTime);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.post(new ahlk(this, paramString));
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.VideoSendTaskManager
 * JD-Core Version:    0.7.0.1
 */