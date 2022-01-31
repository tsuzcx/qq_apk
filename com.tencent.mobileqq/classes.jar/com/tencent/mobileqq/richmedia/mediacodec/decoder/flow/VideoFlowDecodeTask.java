package com.tencent.mobileqq.richmedia.mediacodec.decoder.flow;

import ahab;
import aham;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.os.Trace;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.HWDecodeListener;
import com.tencent.util.ThrowablesUtils;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;

@TargetApi(18)
public class VideoFlowDecodeTask
  implements Runnable
{
  int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private MediaCodec jdField_a_of_type_AndroidMediaMediaCodec;
  private MediaExtractor jdField_a_of_type_AndroidMediaMediaExtractor;
  private HWDecodeListener jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener;
  private final FlowDecodeConfig jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig;
  private FlowDecodeListener jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeListener;
  private FlowDecodeSurface jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeSurface;
  final Object jdField_a_of_type_JavaLangObject = new Object();
  private final String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList;
  private final AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(-1L);
  volatile boolean jdField_a_of_type_Boolean = false;
  private ByteBuffer[] jdField_a_of_type_ArrayOfJavaNioByteBuffer;
  int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private final FlowDecodeConfig jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig;
  private boolean jdField_b_of_type_Boolean;
  private ByteBuffer[] jdField_b_of_type_ArrayOfJavaNioByteBuffer;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e = 1;
  
  public VideoFlowDecodeTask(String paramString, HWDecodeListener paramHWDecodeListener, FlowDecodeListener paramFlowDecodeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener = paramHWDecodeListener;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Long = MediaUtil.a(paramString);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeListener = paramFlowDecodeListener;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig = new FlowDecodeConfig(paramString, 0, true, false, 0L, this.jdField_a_of_type_Long);
    this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig = new FlowDecodeConfig(paramString, 0, true, false, 0L, this.jdField_a_of_type_Long);
  }
  
  private aham a(long paramLong, List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aham localaham = (aham)paramList.next();
      if ((paramLong >= localaham.jdField_a_of_type_Long) && (paramLong < localaham.jdField_b_of_type_Long)) {
        return localaham;
      }
    }
    return null;
  }
  
  private static List a(String paramString)
  {
    paramString = MediaUtil.a(paramString);
    if ((paramString == null) || (paramString.size() < 2)) {
      return null;
    }
    SLog.c("FlowEdit_VideoFlowDecodeTask", "iFrameTimeStampList = " + new JSONArray(paramString));
    ArrayList localArrayList = new ArrayList(paramString.size() - 2);
    int i = 0;
    while (i < paramString.size() - 1)
    {
      localArrayList.add(new aham(i, ((Long)paramString.get(i)).longValue(), ((Long)paramString.get(i + 1)).longValue()));
      i += 1;
    }
    return localArrayList;
  }
  
  private void a()
  {
    int i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueInputBuffer(10000L);
    if (i < 0)
    {
      SLog.d("FlowEdit_VideoFlowDecodeTask", "queueSamplesToCodec. inIndex = " + i);
      return;
    }
    aham localaham = (aham)this.jdField_a_of_type_JavaUtilList.get(this.jdField_c_of_type_Int);
    ByteBuffer localByteBuffer = this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[i];
    localByteBuffer.clear();
    int j = this.jdField_a_of_type_AndroidMediaMediaExtractor.readSampleData(localByteBuffer, 0);
    long l = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
    if ((j < 0) || (l >= localaham.jdField_b_of_type_Long))
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, 0, 0L, 4);
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    aham.a(localaham);
    this.jdField_a_of_type_AndroidMediaMediaCodec.queueInputBuffer(i, 0, j, l, 0);
    this.jdField_a_of_type_AndroidMediaMediaExtractor.advance();
  }
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_AndroidMediaMediaCodec.flush();
    this.jdField_a_of_type_AndroidMediaMediaExtractor.seekTo(paramLong, 2);
    paramLong = this.jdField_a_of_type_AndroidMediaMediaExtractor.getSampleTime();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener.b(paramLong / 1000L);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void a(MediaCodec.BufferInfo paramBufferInfo, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramBufferInfo.size != 0)) {
      paramBoolean = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.releaseOutputBuffer(paramInt, paramBoolean);
      aham localaham = a(paramBufferInfo.presentationTimeUs, this.jdField_a_of_type_JavaUtilList);
      if ((paramBoolean) && (localaham != null))
      {
        ahab localahab = ahab.a();
        label71:
        float f;
        if (localahab != null)
        {
          if (aham.c(localaham) % this.e != 1) {
            break label260;
          }
          paramInt = 1;
          if ((!this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig.jdField_a_of_type_Boolean) && (paramInt != 0)) {
            break label284;
          }
          aham.a(localaham).add(localahab);
          Trace.beginSection("AVEditor:doRender");
          SystemClock.uptimeMillis();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeSurface.b();
          SystemClock.uptimeMillis();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeSurface.a(localahab, false);
          Trace.endSection();
          if (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig.jdField_a_of_type_Int != 3) {
            break label265;
          }
          localahab.a(this.jdField_d_of_type_Int, -paramBufferInfo.presentationTimeUs, SystemClock.uptimeMillis());
          label163:
          if (aham.a(localaham).size() % 7 == 6)
          {
            f = 1.0F;
            if (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig.jdField_a_of_type_Int != 1) {
              break label305;
            }
            f = 2.0F;
            label198:
            this.e = localaham.a(f);
            SLog.a("FlowEdit_VideoFlowDecodeTask", "update dropFrameRate = %d", Integer.valueOf(this.e));
          }
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener == null) {}
        }
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener.a(paramBufferInfo.presentationTimeUs * 1000L);
          aham.d(localaham);
          return;
          paramBoolean = false;
          continue;
          label260:
          paramInt = 0;
          break label71;
          label265:
          localahab.a(this.jdField_d_of_type_Int, paramBufferInfo.presentationTimeUs, SystemClock.uptimeMillis());
          break label163;
          label284:
          SystemClock.uptimeMillis();
          this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeSurface.b();
          localahab.b();
          break label163;
          label305:
          if (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig.jdField_a_of_type_Int != 2) {
            break label198;
          }
          f = 0.5F;
        }
        catch (InterruptedException paramBufferInfo)
        {
          for (;;)
          {
            SLog.c("FlowEdit_VideoFlowDecodeTask", "doRender.", paramBufferInfo);
            this.jdField_d_of_type_Boolean = true;
          }
        }
      }
    }
    SLog.e("FlowEdit_VideoFlowDecodeTask", "doRender. doRender is false");
  }
  
  private void b()
  {
    aham localaham = (aham)this.jdField_a_of_type_JavaUtilList.get(this.jdField_c_of_type_Int);
    int k = aham.a(localaham).size();
    int i;
    int j;
    if ((this.jdField_c_of_type_Boolean) && (k > 0))
    {
      i = 1;
      if ((this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig.jdField_a_of_type_Int != 0) && (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig.jdField_a_of_type_Int != 2))
      {
        j = i;
        if (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig.jdField_a_of_type_Int != 1) {}
      }
      else
      {
        if ((i == 0) && (k < 12)) {
          break label268;
        }
        j = 1;
      }
    }
    label268:
    for (;;)
    {
      label88:
      if (j != 0)
      {
        if ((this.jdField_c_of_type_Boolean) && (aham.b(localaham) != 0)) {
          SLog.d("FlowEdit_VideoFlowDecodeTask", "sendDecodedFrameSetIfNeeded. output done but decoding frame count (%d) is not 0", new Object[] { Integer.valueOf(aham.b(localaham)) });
        }
        SLog.c("FlowEdit_VideoFlowDecodeTask", "sendDecodedFrameSetIfNeeded. render segment " + this.jdField_c_of_type_Int + ", frame count = " + aham.a(localaham).size() + " to next");
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeListener.a(Collections.unmodifiableList(aham.a(localaham)));
        aham.a(localaham).clear();
        long l1 = SystemClock.uptimeMillis();
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeListener.a() >= 50)
          {
            try
            {
              Thread.sleep(100L);
            }
            catch (InterruptedException localInterruptedException)
            {
              SLog.c("FlowEdit_VideoFlowDecodeTask", localInterruptedException, "sleep interrupt", new Object[0]);
              this.jdField_d_of_type_Boolean = true;
            }
            continue;
            i = 0;
            break;
            j = 0;
            break label88;
          }
        }
        long l2 = this.jdField_b_of_type_Long;
        this.jdField_b_of_type_Long = (SystemClock.uptimeMillis() - l1 + l2);
      }
    }
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaCodec == null)
    {
      SLog.e("FlowEdit_VideoFlowDecodeTask", "Can't find video info!");
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener.e();
    }
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaCodec.start();
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getInputBuffers();
      this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
      return true;
    }
    catch (Throwable localThrowable)
    {
      if (Thread.interrupted())
      {
        SLog.c("FlowEdit_VideoFlowDecodeTask", "Thread is interrupted.", localThrowable);
        return false;
      }
      RuntimeException localRuntimeException = new RuntimeException(localThrowable);
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener.a(2, localRuntimeException);
        SLog.c("FlowEdit_VideoFlowDecodeTask", "decode start error", localThrowable);
        return false;
      }
      throw localRuntimeException;
    }
  }
  
  private void d(boolean paramBoolean)
  {
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    int i = this.jdField_a_of_type_AndroidMediaMediaCodec.dequeueOutputBuffer(localBufferInfo, 10000L);
    switch (i)
    {
    default: 
      if ((localBufferInfo.flags & 0x4) != 0) {
        this.jdField_c_of_type_Boolean = true;
      }
      break;
    }
    for (;;)
    {
      b();
      return;
      this.jdField_b_of_type_ArrayOfJavaNioByteBuffer = this.jdField_a_of_type_AndroidMediaMediaCodec.getOutputBuffers();
      return;
      SystemClock.uptimeMillis();
      a(localBufferInfo, i, paramBoolean);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 < 0L) || (paramLong2 < 0L)) {
      throw new IllegalArgumentException("both start time and end time should not less than 0");
    }
    if (paramLong2 < paramLong1) {
      throw new IllegalArgumentException("end time should not less than start time");
    }
    if (paramLong1 >= this.jdField_a_of_type_Long) {
      return;
    }
    if (paramLong2 > this.jdField_a_of_type_Long) {
      paramLong2 = this.jdField_a_of_type_Long;
    }
    for (;;)
    {
      long l = paramLong2;
      if (paramLong2 == 0L) {
        l = this.jdField_a_of_type_Long;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig.jdField_a_of_type_Long = paramLong1;
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig.jdField_b_of_type_Long = l;
      return;
    }
  }
  
  public void a(@NonNull FlowDecodeConfig paramFlowDecodeConfig)
  {
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramFlowDecodeConfig.jdField_a_of_type_JavaLangString)) {
      SLog.e("FlowEdit_VideoFlowDecodeTask", "DecodeRunnable does not support changing the file");
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext = paramFlowDecodeConfig.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig.jdField_a_of_type_AndroidOpenglEGLContext = paramFlowDecodeConfig.jdField_a_of_type_AndroidOpenglEGLContext;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig.jdField_c_of_type_Int = paramFlowDecodeConfig.jdField_c_of_type_Int;
    a(paramFlowDecodeConfig.jdField_c_of_type_Boolean);
    a(paramFlowDecodeConfig.jdField_a_of_type_Int);
    a(paramFlowDecodeConfig.jdField_a_of_type_Long, paramFlowDecodeConfig.jdField_b_of_type_Long);
    c(paramFlowDecodeConfig.jdField_b_of_type_Boolean);
    b(paramFlowDecodeConfig.jdField_a_of_type_Boolean);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  protected boolean a()
  {
    this.jdField_a_of_type_JavaUtilList = a(this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      SLog.e("FlowEdit_VideoFlowDecodeTask", "this video can not be played, check video");
      StoryReportor.b("video_edit", "split_video_fail", 0, 0, new String[] { Build.MANUFACTURER, Build.MODEL, String.valueOf(Build.VERSION.SDK_INT) });
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener.a(1, new IllegalStateException("this video can not be played reservedly, check video"));
      }
      return false;
    }
    for (;;)
    {
      try
      {
        i = MediaUtil.a(this.jdField_a_of_type_JavaLangString);
        Object localObject1;
        SLog.c("FlowEdit_VideoFlowDecodeTask", "initDecoder failed", localException1);
      }
      catch (Exception localException1)
      {
        try
        {
          j = MediaUtil.b(this.jdField_a_of_type_JavaLangString);
          if ((i > 0) && (j > 0)) {
            break;
          }
          localObject1 = "";
          if (this.jdField_a_of_type_JavaLangString != null)
          {
            localObject1 = new File(this.jdField_a_of_type_JavaLangString);
            if (!((File)localObject1).exists()) {
              break label218;
            }
            if (((File)localObject1).length() < 0L) {
              break label211;
            }
            localObject1 = "illegal file";
          }
          StoryReportor.b("video_edit", "getVideoWH_fail", 0, 0, new String[] { Build.MANUFACTURER, Build.MODEL, localObject1 });
          return false;
        }
        catch (Exception localException2)
        {
          int i;
          int j;
          Object localObject2;
          break label197;
        }
        localException1 = localException1;
        i = 0;
      }
      label197:
      j = 0;
      continue;
      label211:
      localObject2 = "file length is 0";
      continue;
      label218:
      localObject2 = "file does not exist";
    }
    if (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig.jdField_c_of_type_Int == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeSurface = new FlowDecodeOffScreenSurface(this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig.jdField_a_of_type_AndroidOpenglEGLContext, i, j);
      this.jdField_a_of_type_AndroidMediaMediaExtractor = new MediaExtractor();
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_AndroidMediaMediaExtractor.setDataSource(this.jdField_a_of_type_JavaLangString);
          i = 0;
          if (i >= this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackCount()) {
            break;
          }
          localObject2 = this.jdField_a_of_type_AndroidMediaMediaExtractor.getTrackFormat(i);
          localObject3 = ((MediaFormat)localObject2).getString("mime");
          if (!((String)localObject3).startsWith("video/")) {
            break label609;
          }
          this.jdField_a_of_type_AndroidMediaMediaExtractor.selectTrack(i);
          if (!this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig.jdField_c_of_type_Boolean) {
            ((MediaFormat)localObject2).setInteger("rotation-degrees", 0);
          }
          try
          {
            this.jdField_a_of_type_AndroidMediaMediaCodec = MediaCodec.createDecoderByType((String)localObject3);
            if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeSurface.a().isValid()) {
              break label545;
            }
            throw new RuntimeException("surface is not valid.");
          }
          catch (Throwable localThrowable)
          {
            if (!Thread.interrupted()) {
              break label566;
            }
          }
          SLog.c("FlowEdit_VideoFlowDecodeTask", "Thread is interrupted.", localThrowable);
          return false;
        }
        catch (IOException localIOException)
        {
          SLog.c("FlowEdit_VideoFlowDecodeTask", localIOException, "setDataSource failed", new Object[0]);
        }
        if (this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig.jdField_c_of_type_Int == 1) {
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeSurface = new FlowDecodeScreenSurface(this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig.jdField_a_of_type_JavaxMicroeditionKhronosEglEGLContext, i, j);
          }
          catch (FlowDecodeScreenSurfaceBase.FlowDecodeException localFlowDecodeException)
          {
            SLog.c("FlowEdit_VideoFlowDecodeTask", localFlowDecodeException, "create FlowDecodeScreenSurface failed", new Object[0]);
            if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener != null) {
              this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener.a(2, localFlowDecodeException);
            }
            CrashReport.handleCatchException(Thread.currentThread(), localFlowDecodeException, ThrowablesUtils.a(localFlowDecodeException), null);
            return false;
          }
        }
      }
      throw new IllegalStateException("Illegal decodeType in decodeConfig " + this.jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig);
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener.a(2, localIOException);
      return false;
      label545:
      this.jdField_a_of_type_AndroidMediaMediaCodec.configure(localIOException, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeSurface.a(), null, 0);
      return true;
      label566:
      Object localObject3 = new RuntimeException(localIOException);
      if (this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener.a(1, (Throwable)localObject3);
        SLog.c("FlowEdit_VideoFlowDecodeTask", "decode configure error", localIOException);
        return false;
      }
      throw ((Throwable)localObject3);
      label609:
      i += 1;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 70	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig;
    //   4: aload_0
    //   5: getfield 68	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig;
    //   8: invokevirtual 591	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/DecodeConfig;)Z
    //   11: pop
    //   12: aload_0
    //   13: iconst_0
    //   14: putfield 273	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_d_of_type_Int	I
    //   17: aload_0
    //   18: invokevirtual 593	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:a	()Z
    //   21: ifne +4 -> 25
    //   24: return
    //   25: aload_0
    //   26: invokespecial 595	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:b	()Z
    //   29: ifeq -5 -> 24
    //   32: iconst_0
    //   33: istore_1
    //   34: aload_0
    //   35: iconst_0
    //   36: putfield 596	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_Int	I
    //   39: aload_0
    //   40: aload_0
    //   41: getfield 169	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   44: invokeinterface 100 1 0
    //   49: iconst_1
    //   50: isub
    //   51: putfield 598	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_b_of_type_Int	I
    //   54: iconst_1
    //   55: istore 6
    //   57: invokestatic 368	java/lang/Thread:interrupted	()Z
    //   60: ifne +1135 -> 1195
    //   63: aload_0
    //   64: getfield 302	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_d_of_type_Boolean	Z
    //   67: ifne +1128 -> 1195
    //   70: aload_0
    //   71: getfield 70	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig;
    //   74: getfield 271	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig:jdField_a_of_type_Int	I
    //   77: istore 4
    //   79: aload_0
    //   80: getfield 70	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig;
    //   83: getfield 402	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig:jdField_a_of_type_Long	J
    //   86: aload_0
    //   87: getfield 68	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig;
    //   90: getfield 402	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig:jdField_a_of_type_Long	J
    //   93: lcmp
    //   94: ifne +21 -> 115
    //   97: aload_0
    //   98: getfield 70	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig;
    //   101: getfield 403	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig:jdField_b_of_type_Long	J
    //   104: aload_0
    //   105: getfield 68	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig;
    //   108: getfield 403	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig:jdField_b_of_type_Long	J
    //   111: lcmp
    //   112: ifeq +407 -> 519
    //   115: iconst_1
    //   116: istore_2
    //   117: aload_0
    //   118: getfield 70	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig;
    //   121: aload_0
    //   122: getfield 68	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig;
    //   125: invokevirtual 591	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/DecodeConfig;)Z
    //   128: istore 7
    //   130: aload_0
    //   131: getfield 70	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig;
    //   134: getfield 271	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig:jdField_a_of_type_Int	I
    //   137: istore 5
    //   139: iload 6
    //   141: ifne +7 -> 148
    //   144: iload_2
    //   145: ifeq +1241 -> 1386
    //   148: ldc 102
    //   150: ldc_w 600
    //   153: iload 6
    //   155: invokestatic 605	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   158: iload 7
    //   160: invokestatic 605	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   163: aload_0
    //   164: getfield 70	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig;
    //   167: invokestatic 608	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   170: aload_0
    //   171: getfield 70	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig;
    //   174: getfield 402	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig:jdField_a_of_type_Long	J
    //   177: lconst_0
    //   178: lcmp
    //   179: ifne +345 -> 524
    //   182: aload_0
    //   183: getfield 70	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig;
    //   186: getfield 403	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig:jdField_b_of_type_Long	J
    //   189: lconst_0
    //   190: lcmp
    //   191: ifne +333 -> 524
    //   194: aload_0
    //   195: iconst_0
    //   196: putfield 596	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_Int	I
    //   199: aload_0
    //   200: aload_0
    //   201: getfield 169	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   204: invokeinterface 100 1 0
    //   209: iconst_1
    //   210: isub
    //   211: putfield 598	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_b_of_type_Int	I
    //   214: ldc 102
    //   216: ldc_w 610
    //   219: aload_0
    //   220: getfield 169	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   223: aload_0
    //   224: getfield 596	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_Int	I
    //   227: invokeinterface 137 2 0
    //   232: checkcast 90	aham
    //   235: getfield 91	aham:jdField_a_of_type_Long	J
    //   238: invokestatic 613	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   241: aload_0
    //   242: getfield 169	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   245: aload_0
    //   246: getfield 598	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_b_of_type_Int	I
    //   249: invokeinterface 137 2 0
    //   254: checkcast 90	aham
    //   257: getfield 93	aham:jdField_b_of_type_Long	J
    //   260: invokestatic 613	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   263: aload_0
    //   264: getfield 596	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_Int	I
    //   267: invokestatic 286	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   270: aload_0
    //   271: getfield 598	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_b_of_type_Int	I
    //   274: invokestatic 286	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   277: invokestatic 616	com/tencent/biz/qqstory/support/logging/SLog:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   280: ldc 102
    //   282: ldc_w 618
    //   285: invokestatic 128	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: aload_0
    //   289: getfield 61	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeListener	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeListener;
    //   292: invokeinterface 620 1 0
    //   297: iconst_1
    //   298: istore_1
    //   299: iload 4
    //   301: iconst_3
    //   302: if_icmpne +9 -> 311
    //   305: iload 5
    //   307: iconst_3
    //   308: if_icmpne +15 -> 323
    //   311: iload 4
    //   313: iconst_3
    //   314: if_icmpeq +505 -> 819
    //   317: iload 5
    //   319: iconst_3
    //   320: if_icmpne +499 -> 819
    //   323: iconst_1
    //   324: istore_3
    //   325: iload 6
    //   327: ifne +9 -> 336
    //   330: iload_1
    //   331: istore_2
    //   332: iload_3
    //   333: ifeq +22 -> 355
    //   336: ldc 102
    //   338: ldc_w 622
    //   341: invokestatic 128	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: aload_0
    //   345: getfield 61	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeListener	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeListener;
    //   348: invokeinterface 625 1 0
    //   353: iconst_1
    //   354: istore_2
    //   355: iload 6
    //   357: ifne +9 -> 366
    //   360: iload_2
    //   361: istore_1
    //   362: iload_2
    //   363: ifeq +474 -> 837
    //   366: aload_0
    //   367: aload_0
    //   368: getfield 273	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_d_of_type_Int	I
    //   371: iconst_1
    //   372: iadd
    //   373: putfield 273	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_d_of_type_Int	I
    //   376: aload_0
    //   377: getfield 70	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig;
    //   380: getfield 271	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig:jdField_a_of_type_Int	I
    //   383: iconst_3
    //   384: if_icmpne +440 -> 824
    //   387: aload_0
    //   388: aload_0
    //   389: getfield 598	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_b_of_type_Int	I
    //   392: putfield 171	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_c_of_type_Int	I
    //   395: aload_0
    //   396: aload_0
    //   397: getfield 169	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   400: aload_0
    //   401: getfield 171	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_c_of_type_Int	I
    //   404: invokeinterface 137 2 0
    //   409: checkcast 90	aham
    //   412: getfield 91	aham:jdField_a_of_type_Long	J
    //   415: invokespecial 626	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:a	(J)V
    //   418: iconst_0
    //   419: istore_1
    //   420: iload_1
    //   421: aload_0
    //   422: getfield 169	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   425: invokeinterface 100 1 0
    //   430: if_icmpge +405 -> 835
    //   433: aload_0
    //   434: getfield 169	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   437: iload_1
    //   438: invokeinterface 137 2 0
    //   443: checkcast 90	aham
    //   446: invokestatic 244	aham:a	(Laham;)Ljava/util/List;
    //   449: invokeinterface 100 1 0
    //   454: ifle +42 -> 496
    //   457: ldc 102
    //   459: ldc_w 628
    //   462: iconst_1
    //   463: anewarray 4	java/lang/Object
    //   466: dup
    //   467: iconst_0
    //   468: aload_0
    //   469: getfield 169	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   472: iload_1
    //   473: invokeinterface 137 2 0
    //   478: checkcast 90	aham
    //   481: invokestatic 244	aham:a	(Laham;)Ljava/util/List;
    //   484: invokeinterface 100 1 0
    //   489: invokestatic 286	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   492: aastore
    //   493: invokestatic 313	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   496: aload_0
    //   497: getfield 169	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   500: iload_1
    //   501: invokeinterface 137 2 0
    //   506: checkcast 90	aham
    //   509: invokestatic 631	aham:a	(Laham;)V
    //   512: iload_1
    //   513: iconst_1
    //   514: iadd
    //   515: istore_1
    //   516: goto -96 -> 420
    //   519: iconst_0
    //   520: istore_2
    //   521: goto -404 -> 117
    //   524: aload_0
    //   525: getfield 70	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig;
    //   528: getfield 402	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig:jdField_a_of_type_Long	J
    //   531: lstore 8
    //   533: aload_0
    //   534: getfield 70	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig;
    //   537: getfield 403	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig:jdField_b_of_type_Long	J
    //   540: lstore 10
    //   542: aload_0
    //   543: getfield 169	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   546: invokeinterface 100 1 0
    //   551: istore_1
    //   552: iconst_0
    //   553: istore_3
    //   554: iload_1
    //   555: iconst_1
    //   556: isub
    //   557: istore_2
    //   558: iconst_0
    //   559: istore_1
    //   560: iload_1
    //   561: aload_0
    //   562: getfield 169	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   565: invokeinterface 100 1 0
    //   570: if_icmpge +80 -> 650
    //   573: lload 8
    //   575: ldc2_w 210
    //   578: lmul
    //   579: aload_0
    //   580: getfield 169	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   583: iload_1
    //   584: invokeinterface 137 2 0
    //   589: checkcast 90	aham
    //   592: getfield 91	aham:jdField_a_of_type_Long	J
    //   595: lsub
    //   596: invokestatic 637	java/lang/Math:abs	(J)J
    //   599: ldc2_w 153
    //   602: lcmp
    //   603: ifge +5 -> 608
    //   606: iload_1
    //   607: istore_3
    //   608: lload 10
    //   610: ldc2_w 210
    //   613: lmul
    //   614: aload_0
    //   615: getfield 169	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   618: iload_1
    //   619: invokeinterface 137 2 0
    //   624: checkcast 90	aham
    //   627: getfield 93	aham:jdField_b_of_type_Long	J
    //   630: lsub
    //   631: invokestatic 637	java/lang/Math:abs	(J)J
    //   634: ldc2_w 153
    //   637: lcmp
    //   638: ifge +5 -> 643
    //   641: iload_1
    //   642: istore_2
    //   643: iload_1
    //   644: iconst_1
    //   645: iadd
    //   646: istore_1
    //   647: goto -87 -> 560
    //   650: aload_0
    //   651: getfield 169	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   654: iload_3
    //   655: invokeinterface 137 2 0
    //   660: checkcast 90	aham
    //   663: getfield 91	aham:jdField_a_of_type_Long	J
    //   666: lstore 8
    //   668: aload_0
    //   669: getfield 169	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   672: iload_2
    //   673: invokeinterface 137 2 0
    //   678: checkcast 90	aham
    //   681: getfield 93	aham:jdField_b_of_type_Long	J
    //   684: lstore 10
    //   686: ldc 102
    //   688: ldc_w 639
    //   691: bipush 6
    //   693: anewarray 4	java/lang/Object
    //   696: dup
    //   697: iconst_0
    //   698: aload_0
    //   699: getfield 70	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig;
    //   702: getfield 402	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig:jdField_a_of_type_Long	J
    //   705: invokestatic 613	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   708: aastore
    //   709: dup
    //   710: iconst_1
    //   711: aload_0
    //   712: getfield 70	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig;
    //   715: getfield 403	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig:jdField_b_of_type_Long	J
    //   718: invokestatic 613	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   721: aastore
    //   722: dup
    //   723: iconst_2
    //   724: lload 8
    //   726: invokestatic 613	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   729: aastore
    //   730: dup
    //   731: iconst_3
    //   732: lload 10
    //   734: invokestatic 613	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   737: aastore
    //   738: dup
    //   739: iconst_4
    //   740: iload_3
    //   741: invokestatic 286	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   744: aastore
    //   745: dup
    //   746: iconst_5
    //   747: iload_2
    //   748: invokestatic 286	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   751: aastore
    //   752: invokestatic 641	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   755: iload_2
    //   756: iload_3
    //   757: if_icmple +33 -> 790
    //   760: iload_3
    //   761: iflt +29 -> 790
    //   764: iload_2
    //   765: aload_0
    //   766: getfield 169	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   769: invokeinterface 100 1 0
    //   774: if_icmpge +16 -> 790
    //   777: aload_0
    //   778: iload_3
    //   779: putfield 596	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_Int	I
    //   782: aload_0
    //   783: iload_2
    //   784: putfield 598	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_b_of_type_Int	I
    //   787: goto -507 -> 280
    //   790: ldc 102
    //   792: ldc_w 643
    //   795: iconst_2
    //   796: anewarray 4	java/lang/Object
    //   799: dup
    //   800: iconst_0
    //   801: iload_3
    //   802: invokestatic 286	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   805: aastore
    //   806: dup
    //   807: iconst_1
    //   808: iload_2
    //   809: invokestatic 286	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   812: aastore
    //   813: invokestatic 313	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   816: goto -536 -> 280
    //   819: iconst_0
    //   820: istore_3
    //   821: goto -496 -> 325
    //   824: aload_0
    //   825: aload_0
    //   826: getfield 596	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_Int	I
    //   829: putfield 171	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_c_of_type_Int	I
    //   832: goto -437 -> 395
    //   835: iconst_0
    //   836: istore_1
    //   837: aload_0
    //   838: getfield 196	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_b_of_type_Boolean	Z
    //   841: ifne +11 -> 852
    //   844: invokestatic 257	android/os/SystemClock:uptimeMillis	()J
    //   847: pop2
    //   848: aload_0
    //   849: invokespecial 645	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:a	()V
    //   852: aload_0
    //   853: getfield 217	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_c_of_type_Boolean	Z
    //   856: ifne +12 -> 868
    //   859: invokestatic 257	android/os/SystemClock:uptimeMillis	()J
    //   862: pop2
    //   863: aload_0
    //   864: iconst_1
    //   865: invokespecial 647	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:d	(Z)V
    //   868: aload_0
    //   869: getfield 217	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_c_of_type_Boolean	Z
    //   872: ifeq +273 -> 1145
    //   875: aload_0
    //   876: getfield 70	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig;
    //   879: getfield 271	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig:jdField_a_of_type_Int	I
    //   882: iconst_3
    //   883: if_icmpne +205 -> 1088
    //   886: aload_0
    //   887: aload_0
    //   888: getfield 171	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_c_of_type_Int	I
    //   891: iconst_1
    //   892: isub
    //   893: putfield 171	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_c_of_type_Int	I
    //   896: aload_0
    //   897: getfield 171	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_c_of_type_Int	I
    //   900: aload_0
    //   901: getfield 596	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_Int	I
    //   904: if_icmplt +197 -> 1101
    //   907: aload_0
    //   908: getfield 171	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_c_of_type_Int	I
    //   911: aload_0
    //   912: getfield 598	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_b_of_type_Int	I
    //   915: if_icmpgt +186 -> 1101
    //   918: aload_0
    //   919: getfield 169	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   922: aload_0
    //   923: getfield 171	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_c_of_type_Int	I
    //   926: invokeinterface 137 2 0
    //   931: checkcast 90	aham
    //   934: getfield 91	aham:jdField_a_of_type_Long	J
    //   937: lstore 8
    //   939: aload_0
    //   940: getfield 169	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   943: aload_0
    //   944: getfield 171	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_c_of_type_Int	I
    //   947: invokeinterface 137 2 0
    //   952: checkcast 90	aham
    //   955: getfield 93	aham:jdField_b_of_type_Long	J
    //   958: lstore 10
    //   960: ldc 102
    //   962: ldc_w 649
    //   965: aload_0
    //   966: getfield 171	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_c_of_type_Int	I
    //   969: invokestatic 286	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   972: lload 8
    //   974: invokestatic 613	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   977: lload 10
    //   979: invokestatic 613	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   982: invokestatic 651	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   985: aload_0
    //   986: lload 8
    //   988: invokespecial 626	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:a	(J)V
    //   991: aload_0
    //   992: getfield 44	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_Boolean	Z
    //   995: ifeq +22 -> 1017
    //   998: aload_0
    //   999: getfield 46	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   1002: astore 12
    //   1004: aload 12
    //   1006: monitorenter
    //   1007: aload_0
    //   1008: getfield 46	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   1011: invokevirtual 654	java/lang/Object:wait	()V
    //   1014: aload 12
    //   1016: monitorexit
    //   1017: iconst_0
    //   1018: istore 6
    //   1020: goto -963 -> 57
    //   1023: astore 12
    //   1025: invokestatic 368	java/lang/Thread:interrupted	()Z
    //   1028: ifeq +16 -> 1044
    //   1031: ldc 102
    //   1033: ldc_w 370
    //   1036: aload 12
    //   1038: invokestatic 300	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1041: goto -173 -> 868
    //   1044: new 372	java/lang/RuntimeException
    //   1047: dup
    //   1048: aload 12
    //   1050: invokespecial 375	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   1053: astore 13
    //   1055: aload_0
    //   1056: getfield 50	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/HWDecodeListener;
    //   1059: iconst_3
    //   1060: aload 13
    //   1062: invokeinterface 378 3 0
    //   1067: ldc 102
    //   1069: ldc_w 587
    //   1072: aload 12
    //   1074: invokestatic 300	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1077: aload_0
    //   1078: iconst_1
    //   1079: putfield 302	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_d_of_type_Boolean	Z
    //   1082: iconst_0
    //   1083: istore 6
    //   1085: goto -1028 -> 57
    //   1088: aload_0
    //   1089: aload_0
    //   1090: getfield 171	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_c_of_type_Int	I
    //   1093: iconst_1
    //   1094: iadd
    //   1095: putfield 171	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_c_of_type_Int	I
    //   1098: goto -202 -> 896
    //   1101: aload_0
    //   1102: getfield 70	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_b_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig;
    //   1105: getfield 429	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeConfig:jdField_b_of_type_Boolean	Z
    //   1108: ifeq +24 -> 1132
    //   1111: aload_0
    //   1112: getfield 50	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/HWDecodeListener;
    //   1115: ifnull +12 -> 1127
    //   1118: aload_0
    //   1119: getfield 50	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/HWDecodeListener;
    //   1122: invokeinterface 657 1 0
    //   1127: iconst_1
    //   1128: istore_1
    //   1129: goto -138 -> 991
    //   1132: ldc 102
    //   1134: ldc_w 659
    //   1137: invokestatic 128	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   1140: aload_0
    //   1141: iconst_1
    //   1142: putfield 302	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_d_of_type_Boolean	Z
    //   1145: goto -154 -> 991
    //   1148: astore 13
    //   1150: aload 12
    //   1152: monitorexit
    //   1153: aload 13
    //   1155: athrow
    //   1156: astore 12
    //   1158: ldc 102
    //   1160: new 104	java/lang/StringBuilder
    //   1163: dup
    //   1164: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   1167: ldc_w 661
    //   1170: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1173: aload 12
    //   1175: invokevirtual 662	java/lang/InterruptedException:toString	()Ljava/lang/String;
    //   1178: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1181: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1184: invokestatic 306	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1187: aload_0
    //   1188: iconst_1
    //   1189: putfield 302	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_d_of_type_Boolean	Z
    //   1192: goto -175 -> 1017
    //   1195: ldc 102
    //   1197: ldc_w 664
    //   1200: invokestatic 128	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   1203: iconst_0
    //   1204: istore_1
    //   1205: iload_1
    //   1206: aload_0
    //   1207: getfield 169	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1210: invokeinterface 100 1 0
    //   1215: if_icmpge +89 -> 1304
    //   1218: aload_0
    //   1219: getfield 169	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1222: iload_1
    //   1223: invokeinterface 137 2 0
    //   1228: checkcast 90	aham
    //   1231: invokestatic 244	aham:a	(Laham;)Ljava/util/List;
    //   1234: invokeinterface 100 1 0
    //   1239: ifle +42 -> 1281
    //   1242: ldc 102
    //   1244: ldc_w 666
    //   1247: iconst_1
    //   1248: anewarray 4	java/lang/Object
    //   1251: dup
    //   1252: iconst_0
    //   1253: aload_0
    //   1254: getfield 169	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1257: iload_1
    //   1258: invokeinterface 137 2 0
    //   1263: checkcast 90	aham
    //   1266: invokestatic 244	aham:a	(Laham;)Ljava/util/List;
    //   1269: invokeinterface 100 1 0
    //   1274: invokestatic 286	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1277: aastore
    //   1278: invokestatic 313	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1281: aload_0
    //   1282: getfield 169	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1285: iload_1
    //   1286: invokeinterface 137 2 0
    //   1291: checkcast 90	aham
    //   1294: invokestatic 668	aham:b	(Laham;)V
    //   1297: iload_1
    //   1298: iconst_1
    //   1299: iadd
    //   1300: istore_1
    //   1301: goto -96 -> 1205
    //   1304: invokestatic 669	ahab:a	()V
    //   1307: aload_0
    //   1308: getfield 152	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   1311: invokevirtual 672	android/media/MediaCodec:stop	()V
    //   1314: aload_0
    //   1315: getfield 152	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_AndroidMediaMediaCodec	Landroid/media/MediaCodec;
    //   1318: invokevirtual 675	android/media/MediaCodec:release	()V
    //   1321: aload_0
    //   1322: getfield 181	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_AndroidMediaMediaExtractor	Landroid/media/MediaExtractor;
    //   1325: invokevirtual 676	android/media/MediaExtractor:release	()V
    //   1328: aload_0
    //   1329: getfield 259	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderFlowFlowDecodeSurface	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/flow/FlowDecodeSurface;
    //   1332: invokeinterface 677 1 0
    //   1337: aload_0
    //   1338: getfield 50	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/HWDecodeListener;
    //   1341: ifnull -1317 -> 24
    //   1344: aload_0
    //   1345: getfield 217	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_c_of_type_Boolean	Z
    //   1348: ifeq +28 -> 1376
    //   1351: aload_0
    //   1352: getfield 50	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/HWDecodeListener;
    //   1355: invokeinterface 680 1 0
    //   1360: return
    //   1361: astore 12
    //   1363: ldc 102
    //   1365: aload 12
    //   1367: invokevirtual 681	java/lang/Exception:toString	()Ljava/lang/String;
    //   1370: invokestatic 306	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1373: goto -36 -> 1337
    //   1376: aload_0
    //   1377: getfield 50	com/tencent/mobileqq/richmedia/mediacodec/decoder/flow/VideoFlowDecodeTask:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecDecoderHWDecodeListener	Lcom/tencent/mobileqq/richmedia/mediacodec/decoder/HWDecodeListener;
    //   1380: invokeinterface 684 1 0
    //   1385: return
    //   1386: goto -1087 -> 299
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1389	0	this	VideoFlowDecodeTask
    //   33	1268	1	i	int
    //   116	693	2	j	int
    //   324	497	3	k	int
    //   77	238	4	m	int
    //   137	184	5	n	int
    //   55	1029	6	bool1	boolean
    //   128	31	7	bool2	boolean
    //   531	456	8	l1	long
    //   540	438	10	l2	long
    //   1023	128	12	localThrowable	Throwable
    //   1156	18	12	localInterruptedException	InterruptedException
    //   1361	5	12	localException	Exception
    //   1053	8	13	localRuntimeException	RuntimeException
    //   1148	6	13	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   837	852	1023	java/lang/Throwable
    //   852	868	1023	java/lang/Throwable
    //   1007	1017	1148	finally
    //   1150	1153	1148	finally
    //   998	1007	1156	java/lang/InterruptedException
    //   1153	1156	1156	java/lang/InterruptedException
    //   1205	1281	1361	java/lang/Exception
    //   1281	1297	1361	java/lang/Exception
    //   1304	1337	1361	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.VideoFlowDecodeTask
 * JD-Core Version:    0.7.0.1
 */