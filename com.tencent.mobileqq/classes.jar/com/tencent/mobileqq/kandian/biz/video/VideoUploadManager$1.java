package com.tencent.mobileqq.kandian.biz.video;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.qqstory.network.pb.qqstory_bhd_upload_pic.RspStoryVideo;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import java.util.HashMap;

class VideoUploadManager$1
  extends TransProcessorHandler
{
  VideoUploadManager$1(VideoUploadManager paramVideoUploadManager) {}
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = (FileMsg)paramMessage.obj;
    qqstory_bhd_upload_pic.RspStoryVideo localRspStoryVideo;
    if (localObject != null)
    {
      if ((((FileMsg)localObject).fileType != 24) && (((FileMsg)localObject).fileType != 32)) {
        return;
      }
      if ((((FileMsg)localObject).fileType == 24) && (((FileMsg)localObject).commandId != 54)) {
        return;
      }
      int i = paramMessage.what;
      if ((i != 2001) && (i != 2003)) {
        switch (i)
        {
        default: 
          return;
        case 1003: 
          paramMessage = (Bundle)this.a.f.remove(Long.valueOf(((FileMsg)localObject).uniseq));
          paramMessage.putLong("uniseq", ((FileMsg)localObject).uniseq);
          paramMessage.putString("pic_server_id", ((FileMsg)localObject).fileUrl);
          localRspStoryVideo = new qqstory_bhd_upload_pic.RspStoryVideo();
        }
      }
    }
    try
    {
      localRspStoryVideo.mergeFrom(((FileMsg)localObject).bdhExtendInfo);
      if (localRspStoryVideo.retcode.get() == 0)
      {
        localObject = localRspStoryVideo.cdn_url.get().toStringUtf8();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramMessage.putString("cdn_url", (String)localObject);
        }
      }
      label202:
      this.a.d.a(83, paramMessage);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      break label202;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoUploadManager.1
 * JD-Core Version:    0.7.0.1
 */