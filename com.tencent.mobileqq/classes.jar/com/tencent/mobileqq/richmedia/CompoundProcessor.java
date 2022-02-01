package com.tencent.mobileqq.richmedia;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwOutputNotify;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.mobileqq.utils.LogTag;

public class CompoundProcessor
  implements SVHwOutputNotify
{
  SessionInfo a;
  int b;
  String c;
  volatile boolean d;
  volatile boolean e;
  boolean f;
  String g;
  int h;
  int i;
  
  public String a(String paramString)
  {
    CodecParam.mRecordFrames = this.i;
    CodecParam.mRecordTime = this.h;
    Object localObject = new EncodeThread(null, new CompoundProcessor.EncodeHandler(Looper.getMainLooper()), paramString, null, null);
    ((EncodeThread)localObject).run();
    localObject = ((EncodeThread)localObject).mTargetFilePath;
    String str = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[peak] videoFileDir = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",videoPath = ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(",CodecParam.mRecordFrames = ");
    localStringBuilder.append(CodecParam.mRecordFrames);
    localStringBuilder.append(",CodecParam.mRecordTime = ");
    localStringBuilder.append(CodecParam.mRecordTime);
    LogTag.a(str, "CompoundProcessor.compressYUV2MP4", localStringBuilder.toString());
    return localObject;
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = RichmediaClient.a();
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("vidoe_record_uniseq", this.c);
    ((Bundle)localObject2).putInt("roll_back_reason", paramInt2);
    if (paramInt1 == 1) {
      ((RichmediaClient)localObject1).b().a(this.c);
    }
    ((RichmediaClient)localObject1).a(101, paramInt1, (Bundle)localObject2);
    localObject1 = this.c;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[peak] cancelType  = ");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append(",cancleReason = ");
    ((StringBuilder)localObject2).append(paramInt2);
    LogTag.a((String)localObject1, "CompoundProcessor.cancelPreupload", ((StringBuilder)localObject2).toString());
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1 = RichmediaClient.a();
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("video_slice_path", paramString);
    ((Bundle)localObject2).putInt("video_slice_index", paramInt1);
    ((Bundle)localObject2).putInt("video_slice_width", paramInt2);
    ((Bundle)localObject2).putInt("video_slice_height", paramInt3);
    ((Bundle)localObject2).putString("vidoe_record_uniseq", this.c);
    ((Bundle)localObject2).putParcelable("PhotoConst.SEND_SESSION_INFO", this.a);
    ((RichmediaClient)localObject1).a(100, -1, (Bundle)localObject2);
    localObject1 = this.c;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("CompoundProcessor.svSegmentOK [peak] index = ");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append(",path = ");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(",width = ");
    ((StringBuilder)localObject2).append(paramInt2);
    ((StringBuilder)localObject2).append(",height = ");
    ((StringBuilder)localObject2).append(paramInt3);
    LogTag.a((String)localObject1, "segment", ((StringBuilder)localObject2).toString());
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    try
    {
      this.e = true;
      Object localObject1 = RichmediaClient.a();
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putString("vidoe_record_uniseq", this.c);
      ((Bundle)localObject2).putString("video_thumb_path", paramString1);
      ((Bundle)localObject2).putInt("video_thumb_width", paramInt1);
      ((Bundle)localObject2).putInt("video_thumb_height", paramInt2);
      ((Bundle)localObject2).putInt("video_busi_type", this.b);
      ((Bundle)localObject2).putString("video_thumb_md5", paramString2);
      ((Bundle)localObject2).putParcelable("PhotoConst.SEND_SESSION_INFO", this.a);
      ((RichmediaClient)localObject1).a(104, -1, (Bundle)localObject2);
      localObject1 = this.c;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[peak] path = ");
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(",width = ");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(",height = ");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append(",md5 = ");
      ((StringBuilder)localObject2).append(paramString2);
      LogTag.a((String)localObject1, "CompoundProcessor.svThumbOK", ((StringBuilder)localObject2).toString());
      return;
    }
    finally {}
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    this.f = true;
    Object localObject1 = RichmediaClient.a();
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("vidoe_record_uniseq", this.c);
    ((Bundle)localObject2).putString("full_video_path", paramString);
    ((Bundle)localObject2).putInt("video_slices_total_time_length", paramInt);
    ((Bundle)localObject2).putLong("video_merge_mp4_time_cost", paramLong);
    ((RichmediaClient)localObject1).a(103, -1, (Bundle)localObject2);
    localObject1 = this.c;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("CompoundProcessor.svMergeOK[peak] path = ");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(",totalTime = ");
    ((StringBuilder)localObject2).append(paramInt);
    LogTag.a((String)localObject1, "clicomp", ((StringBuilder)localObject2).toString());
  }
  
  public void b()
  {
    RichmediaClient localRichmediaClient = RichmediaClient.a();
    Bundle localBundle = new Bundle();
    localBundle.putString("vidoe_record_uniseq", this.c);
    localRichmediaClient.a(102, -1, localBundle);
    LogTag.a(this.c, "CompoundProcessor.svEncodeEnd ", "[peak]all encode end");
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    try
    {
      String str = this.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[peak] code = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",subcode = ");
      localStringBuilder.append(paramInt2);
      LogTag.a(str, "CompoundProcessor.svErrorOcured", localStringBuilder.toString());
      if (!this.d)
      {
        a(1, 120);
        LogTag.a(this.c, "CompoundProcessor.svErrorOcured", "[peak] error before sendClicke,rollback ");
      }
      else
      {
        if ((paramInt1 <= -1) && (paramInt1 >= -23))
        {
          a(2, 122);
          LogTag.a(this.c, "CompoundProcessor.svErrorOcured", "[peak] encode error after sendClicke,rollback ,cancel submitted slices ");
        }
        if (!this.f) {
          ThreadManager.post(new CompoundProcessor.1(this), 8, null, true);
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.CompoundProcessor
 * JD-Core Version:    0.7.0.1
 */