package dov.com.tencent.mobileqq.richmedia;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import aoks;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.utils.LogTag;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import dov.com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import dov.com.tencent.mobileqq.shortvideo.hwcodec.SVHwOutputNotify;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.RecordManager;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class CompoundProcessor
  implements SVHwOutputNotify
{
  int jdField_a_of_type_Int;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  SVHwEncoder jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder;
  public String a;
  volatile boolean jdField_a_of_type_Boolean;
  public int b;
  public String b;
  volatile boolean b;
  int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean;
  
  CompoundProcessor(SVHwEncoder paramSVHwEncoder, SessionInfo paramSessionInfo, int paramInt)
  {
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder = paramSVHwEncoder;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = Long.toString((int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt()));
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(String paramString)
  {
    CodecParam.z = this.jdField_c_of_type_Int;
    CodecParam.y = this.jdField_b_of_type_Int;
    Object localObject = new EncodeThread(null, new aoks(Looper.getMainLooper()), paramString, null, null);
    ((EncodeThread)localObject).run();
    localObject = ((EncodeThread)localObject).jdField_a_of_type_JavaLangString;
    LogTag.a(this.jdField_a_of_type_JavaLangString, "CompoundProcessor.compressYUV2MP4", "[peak] videoFileDir = " + paramString + ",videoPath = " + (String)localObject + ",CodecParam.mRecordFrames = " + CodecParam.z + ",CodecParam.mRecordTime = " + CodecParam.y);
    return localObject;
  }
  
  public void a()
  {
    LogTag.a(this.jdField_a_of_type_JavaLangString, "CompoundProcessor.cancelEncode", "[peak]  CompoundProcessor");
    RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
    if (localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
      localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadevicePreviewContext.mEncodeRef.getAndSet(null);
    }
    if (localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture != null) {
      localRMVideoStateMgr.jdField_a_of_type_DovComTencentMobileqqShortvideoMediadeviceAudioCapture.a.getAndSet(null);
    }
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder.c();
  }
  
  public void a(int paramInt)
  {
    try
    {
      LogTag.a(this.jdField_a_of_type_JavaLangString, "CompoundProcessor.rollBack", "[peak] delReason = " + paramInt);
      a(1, paramInt);
      a();
      return;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    RichmediaClient localRichmediaClient = RichmediaClient.a();
    Bundle localBundle = new Bundle();
    localBundle.putString("vidoe_record_uniseq", this.jdField_a_of_type_JavaLangString);
    localBundle.putInt("roll_back_reason", paramInt2);
    if (paramInt1 == 1) {
      localRichmediaClient.a().a(this.jdField_a_of_type_JavaLangString);
    }
    localRichmediaClient.a(101, paramInt1, localBundle);
    LogTag.a(this.jdField_a_of_type_JavaLangString, "CompoundProcessor.cancelPreupload", "[peak] cancelType  = " + paramInt1 + ",cancleReason = " + paramInt2);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    RichmediaClient localRichmediaClient = RichmediaClient.a();
    Bundle localBundle = new Bundle();
    localBundle.putString("video_slice_path", paramString);
    localBundle.putInt("video_slice_index", paramInt1);
    localBundle.putInt("video_slice_width", paramInt2);
    localBundle.putInt("video_slice_height", paramInt3);
    localBundle.putString("vidoe_record_uniseq", this.jdField_a_of_type_JavaLangString);
    localBundle.putParcelable("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    localRichmediaClient.a(100, -1, localBundle);
    LogTag.a(this.jdField_a_of_type_JavaLangString, "segment", "CompoundProcessor.svSegmentOK [peak] index = " + paramInt1 + ",path = " + paramString + ",width = " + paramInt2 + ",height = " + paramInt3);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    a(paramString, paramInt1, paramInt2, paramLong, paramInt3, false);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, long paramLong, int paramInt3, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Boolean)
        {
          LogTag.a(this.jdField_a_of_type_JavaLangString, "CompoundProcessor.notifySendBtnClicked", "already notified ,return ");
          return;
        }
        this.jdField_a_of_type_Boolean = true;
        this.jdField_b_of_type_JavaLangString = paramString;
        this.jdField_b_of_type_Int = paramInt1;
        this.jdField_c_of_type_Int = paramInt2;
        if (!this.jdField_b_of_type_Boolean)
        {
          a(121);
          LogTag.a(this.jdField_a_of_type_JavaLangString, "CompoundProcessor.notifySendBtnClicked", "[peak] Thumb not ready,rollback ");
          paramString = RichmediaClient.a();
          localBundle = new Bundle();
          localBundle.putString("vidoe_record_uniseq", this.jdField_a_of_type_JavaLangString);
          localBundle.putInt("ab_test_video_duration", paramInt1);
          localBundle.putLong("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
          localBundle.putLong("video_record_touch_up_time", paramLong);
          localBundle.putInt("video_record_touch_up_times", paramInt3);
          paramString.a(106, -1, localBundle);
          return;
        }
      }
      finally {}
      RecordManager.a().a().recordSubmit();
      paramString = RichmediaClient.a();
      Bundle localBundle = new Bundle();
      localBundle.putString("vidoe_record_uniseq", this.jdField_a_of_type_JavaLangString);
      localBundle.putBoolean("video_full_slice_sync_to_story", paramBoolean);
      paramString.a(105, -1, localBundle);
      LogTag.a(this.jdField_a_of_type_JavaLangString, "CompoundProcessor.notifySendBtnClicked ", "[peak] thumb existed");
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    try
    {
      this.jdField_b_of_type_Boolean = true;
      RichmediaClient localRichmediaClient = RichmediaClient.a();
      Bundle localBundle = new Bundle();
      localBundle.putString("vidoe_record_uniseq", this.jdField_a_of_type_JavaLangString);
      localBundle.putString("video_thumb_path", paramString1);
      localBundle.putInt("video_thumb_width", paramInt1);
      localBundle.putInt("video_thumb_height", paramInt2);
      localBundle.putInt("video_busi_type", this.jdField_a_of_type_Int);
      localBundle.putString("video_thumb_md5", paramString2);
      localBundle.putParcelable("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      localRichmediaClient.a(104, -1, localBundle);
      LogTag.a(this.jdField_a_of_type_JavaLangString, "CompoundProcessor.svThumbOK", "[peak] path = " + paramString1 + ",width = " + paramInt1 + ",height = " + paramInt2 + ",md5 = " + paramString2);
      return;
    }
    finally {}
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    this.jdField_c_of_type_Boolean = true;
    RichmediaClient localRichmediaClient = RichmediaClient.a();
    Bundle localBundle = new Bundle();
    localBundle.putString("vidoe_record_uniseq", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("full_video_path", paramString);
    localBundle.putInt("video_slices_total_time_length", paramInt);
    localBundle.putLong("video_merge_mp4_time_cost", paramLong);
    localRichmediaClient.a(103, -1, localBundle);
    LogTag.a(this.jdField_a_of_type_JavaLangString, "clicomp", "CompoundProcessor.svMergeOK[peak] path = " + paramString + ",totalTime = " + paramInt);
  }
  
  public void b() {}
  
  public void b(int paramInt) {}
  
  /* Error */
  public void b(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 68	dov/com/tencent/mobileqq/richmedia/CompoundProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   6: ldc_w 321
    //   9: new 99	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 323
    //   19: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: iload_1
    //   23: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: ldc_w 325
    //   29: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: iload_2
    //   33: invokevirtual 113	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 122	com/tencent/mobileqq/utils/LogTag:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_0
    //   43: getfield 235	dov/com/tencent/mobileqq/richmedia/CompoundProcessor:jdField_a_of_type_Boolean	Z
    //   46: ifne +26 -> 72
    //   49: aload_0
    //   50: iconst_1
    //   51: bipush 120
    //   53: invokevirtual 165	dov/com/tencent/mobileqq/richmedia/CompoundProcessor:a	(II)V
    //   56: aload_0
    //   57: getfield 68	dov/com/tencent/mobileqq/richmedia/CompoundProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   60: ldc_w 321
    //   63: ldc_w 327
    //   66: invokestatic 122	com/tencent/mobileqq/utils/LogTag:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_0
    //   70: monitorexit
    //   71: return
    //   72: iload_1
    //   73: iconst_m1
    //   74: if_icmpgt +29 -> 103
    //   77: iload_1
    //   78: bipush 233
    //   80: if_icmplt +23 -> 103
    //   83: aload_0
    //   84: iconst_2
    //   85: bipush 122
    //   87: invokevirtual 165	dov/com/tencent/mobileqq/richmedia/CompoundProcessor:a	(II)V
    //   90: aload_0
    //   91: getfield 68	dov/com/tencent/mobileqq/richmedia/CompoundProcessor:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   94: ldc_w 321
    //   97: ldc_w 329
    //   100: invokestatic 122	com/tencent/mobileqq/utils/LogTag:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload_0
    //   104: getfield 307	dov/com/tencent/mobileqq/richmedia/CompoundProcessor:jdField_c_of_type_Boolean	Z
    //   107: ifne -38 -> 69
    //   110: new 331	aokr
    //   113: dup
    //   114: aload_0
    //   115: invokespecial 334	aokr:<init>	(Ldov/com/tencent/mobileqq/richmedia/CompoundProcessor;)V
    //   118: bipush 8
    //   120: aconst_null
    //   121: iconst_1
    //   122: invokestatic 340	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   125: goto -56 -> 69
    //   128: astore_3
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_3
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	CompoundProcessor
    //   0	133	1	paramInt1	int
    //   0	133	2	paramInt2	int
    //   128	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	69	128	finally
    //   69	71	128	finally
    //   83	103	128	finally
    //   103	125	128	finally
    //   129	131	128	finally
  }
  
  public void c()
  {
    RichmediaClient localRichmediaClient = RichmediaClient.a();
    Bundle localBundle = new Bundle();
    localBundle.putString("vidoe_record_uniseq", this.jdField_a_of_type_JavaLangString);
    localRichmediaClient.a(102, -1, localBundle);
    LogTag.a(this.jdField_a_of_type_JavaLangString, "CompoundProcessor.svEncodeEnd ", "[peak]all encode end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.CompoundProcessor
 * JD-Core Version:    0.7.0.1
 */