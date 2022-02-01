package com.tencent.mobileqq.studyroom.upload;

import android.os.Message;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.studyroom.api.IStudyRoomPicUploadListener;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class StudyRoomPicUploader$StudyRoomPicHandler
  extends TransProcessorHandler
{
  private static volatile StudyRoomPicHandler a;
  private static volatile boolean b = false;
  private TransFileControllerImpl c;
  private ConcurrentHashMap<Long, IStudyRoomPicUploadListener> d = new ConcurrentHashMap();
  
  private StudyRoomPicUploader$StudyRoomPicHandler()
  {
    addFilter(new Class[] { BDHCommonUploadProcessor.class });
  }
  
  private void a(long paramLong)
  {
    this.d.remove(Long.valueOf(paramLong));
    if (this.d.isEmpty()) {
      a();
    }
  }
  
  private static StudyRoomPicHandler c()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new StudyRoomPicHandler();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StudyRoomPicHandler release sHandlerInit=");
      localStringBuilder.append(b);
      QLog.d("StudyRoomPicUploader", 2, localStringBuilder.toString());
      if ((this.c != null) && (b))
      {
        this.c.removeHandle(this);
        this.c = null;
        b = false;
      }
      return;
    }
    finally {}
  }
  
  public void a(long paramLong, IStudyRoomPicUploadListener paramIStudyRoomPicUploadListener)
  {
    this.d.put(Long.valueOf(paramLong), paramIStudyRoomPicUploadListener);
  }
  
  public void a(ITransFileController paramITransFileController)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StudyRoomPicHandler init sHandlerInit=");
      localStringBuilder.append(b);
      QLog.d("StudyRoomPicUploader", 2, localStringBuilder.toString());
      if (!b)
      {
        this.c = ((TransFileControllerImpl)paramITransFileController);
        this.c.addHandle(this);
        b = true;
      }
      return;
    }
    finally {}
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    Object localObject1;
    Object localObject2;
    if (localFileMsg != null)
    {
      if (localFileMsg.commandId != 80) {
        return;
      }
      localObject1 = this.d;
      if (localObject1 == null) {
        return;
      }
      localObject1 = (IStudyRoomPicUploadListener)((ConcurrentHashMap)localObject1).get(Long.valueOf(localFileMsg.uniseq));
      if (localObject1 == null)
      {
        QLog.d("StudyRoomPicUploader", 2, "uploadListener == null");
        this.d.remove(Long.valueOf(localFileMsg.uniseq));
        return;
      }
      int i = paramMessage.what;
      if (i != 1002)
      {
        if (i != 1003)
        {
          if (i != 1005) {
            return;
          }
          ((IStudyRoomPicUploadListener)localObject1).a(localFileMsg.errorCode, "上传发生错误");
          a(localFileMsg.uniseq);
          return;
        }
        paramMessage = new StringBuilder();
        paramMessage.append("STATUS_SEND_FINISHED file uniseq:");
        paramMessage.append(localFileMsg.uniseq);
        QLog.d("StudyRoomPicUploader", 2, paramMessage.toString());
        localObject2 = new Bdh_extinfo.UploadPicExtInfo();
      }
    }
    try
    {
      ((Bdh_extinfo.UploadPicExtInfo)localObject2).mergeFrom(localFileMsg.bdhExtendInfo, 0, localFileMsg.bdhExtendInfo.length);
      paramMessage = ((Bdh_extinfo.UploadPicExtInfo)localObject2).bytes_download_url.get().toStringUtf8();
      localObject2 = ((Bdh_extinfo.UploadPicExtInfo)localObject2).bytes_thumb_download_url.get().toStringUtf8();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("STATUS_SEND_FINISHED picUrl:");
      localStringBuilder.append(paramMessage);
      QLog.d("StudyRoomPicUploader", 2, localStringBuilder.toString());
      ((IStudyRoomPicUploadListener)localObject1).a(paramMessage, (String)localObject2);
    }
    catch (InvalidProtocolBufferMicroException paramMessage)
    {
      label266:
      break label266;
    }
    ((IStudyRoomPicUploadListener)localObject1).a(101, "解析上传结果错误");
    a(localFileMsg.uniseq);
    return;
    ((IStudyRoomPicUploadListener)localObject1).a((int)((float)localFileMsg.transferedSize * 100.0F / (float)localFileMsg.fileSize));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.upload.StudyRoomPicUploader.StudyRoomPicHandler
 * JD-Core Version:    0.7.0.1
 */