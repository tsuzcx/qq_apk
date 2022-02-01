package dov.com.tencent.biz.qqstory.takevideo.localmedia.demos;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Assert;
import dov.com.tencent.biz.qqstory.takevideo.localmedia.baoutils.media.VideoUtils;
import dov.com.tencent.biz.qqstory.takevideo.localmedia.opengl.CodecOutputSurface;
import dov.com.tencent.mobileqq.richmedia.mediacodec.utils.MediaUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.concurrent.TimeoutException;

@TargetApi(16)
public class MediaCodecThumbnailGenerator$CodecHandler
  extends Handler
{
  public MediaCodecThumbnailGenerator$CodecHandler(MediaCodecThumbnailGenerator paramMediaCodecThumbnailGenerator, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a(MediaCodecThumbnailGenerator.ThumbnailArgs paramThumbnailArgs)
  {
    int i = 0;
    MediaCodecThumbnailGenerator.ThumbnailTaskContext localThumbnailTaskContext = new MediaCodecThumbnailGenerator.ThumbnailTaskContext();
    localThumbnailTaskContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalmediaDemosMediaCodecThumbnailGenerator$ThumbnailArgs = paramThumbnailArgs;
    localThumbnailTaskContext.jdField_b_of_type_Long = (MediaUtil.a(paramThumbnailArgs.jdField_a_of_type_JavaLangString) * 1000L);
    for (;;)
    {
      MediaExtractor localMediaExtractor;
      int k;
      try
      {
        localObject1 = new File(paramThumbnailArgs.jdField_a_of_type_JavaLangString);
        if (!((File)localObject1).canRead()) {
          throw new FileNotFoundException("Unable to read " + localObject1);
        }
      }
      catch (Exception paramThumbnailArgs)
      {
        paramThumbnailArgs = paramThumbnailArgs;
        Log.e("MediaCodecThumbnailGen", "startCaptureThumbnails Error!", paramThumbnailArgs);
        if (!(paramThumbnailArgs instanceof IllegalArgumentException)) {
          break label548;
        }
        localThumbnailTaskContext.jdField_a_of_type_Int = 100;
        SLog.c("MediaCodecThumbnailGen", "Error when generate thumbnail", paramThumbnailArgs);
        obtainMessage(4, localThumbnailTaskContext).sendToTarget();
        return;
        localMediaExtractor = new MediaExtractor();
        localMediaExtractor.setDataSource(((File)localObject1).toString());
        k = VideoUtils.a(localMediaExtractor);
        if (k < 0) {
          throw new RuntimeException("No video track found in " + localObject1);
        }
      }
      finally {}
      localMediaExtractor.selectTrack(k);
      int j = paramThumbnailArgs.jdField_b_of_type_Int;
      Object localObject1 = new long[paramThumbnailArgs.d];
      long[] arrayOfLong = new long[paramThumbnailArgs.d];
      while (i < paramThumbnailArgs.d)
      {
        localMediaExtractor.seekTo(j * 1000L, 0);
        arrayOfLong[i] = (j * 1000L);
        localObject1[i] = localMediaExtractor.getSampleTime();
        j += paramThumbnailArgs.c;
        i += 1;
      }
      localMediaExtractor.seekTo(localObject1[0], 0);
      MediaFormat localMediaFormat = localMediaExtractor.getTrackFormat(k);
      boolean bool = localMediaFormat.containsKey("rotation-degrees");
      if (bool) {}
      try
      {
        localThumbnailTaskContext.jdField_b_of_type_Int = localMediaFormat.getInteger("rotation-degrees");
        label318:
        i = localMediaFormat.getInteger("height");
        j = localMediaFormat.getInteger("width");
        Log.d("MediaCodecThumbnailGen", "Video size is " + j + "x" + i);
        float f = paramThumbnailArgs.jdField_a_of_type_Int * 1.0F / Math.max(i, j);
        paramThumbnailArgs = new CodecOutputSurface((int)(j * f), (int)(i * f));
        Object localObject2 = MediaCodec.createDecoderByType(localMediaFormat.getString("mime"));
        ((MediaCodec)localObject2).configure(localMediaFormat, paramThumbnailArgs.a(), null, 0);
        ((MediaCodec)localObject2).start();
        localThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaExtractor = localMediaExtractor;
        localThumbnailTaskContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalmediaOpenglCodecOutputSurface = paramThumbnailArgs;
        localThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaCodec = ((MediaCodec)localObject2);
        localThumbnailTaskContext.c = k;
        localThumbnailTaskContext.jdField_a_of_type_Int = 0;
        localThumbnailTaskContext.d = 0;
        localThumbnailTaskContext.jdField_a_of_type_ArrayOfLong = ((long[])localObject1);
        localThumbnailTaskContext.jdField_b_of_type_ArrayOfLong = arrayOfLong;
        obtainMessage(2, localThumbnailTaskContext).sendToTarget();
        return;
        localObject2 = new MediaMetadataRetriever();
        ((MediaMetadataRetriever)localObject2).setDataSource(localThumbnailTaskContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalmediaDemosMediaCodecThumbnailGenerator$ThumbnailArgs.jdField_a_of_type_JavaLangString);
        String str = ((MediaMetadataRetriever)localObject2).extractMetadata(24);
        try
        {
          localThumbnailTaskContext.jdField_b_of_type_Int = Integer.parseInt(str);
          label540:
          ((MediaMetadataRetriever)localObject2).release();
          break label318;
          label548:
          if ((paramThumbnailArgs instanceof RuntimeException))
          {
            localThumbnailTaskContext.jdField_a_of_type_Int = 101;
            continue;
          }
          localThumbnailTaskContext.jdField_a_of_type_Int = -1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          break label540;
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        break label318;
      }
    }
  }
  
  private void a(MediaCodecThumbnailGenerator.ThumbnailTaskContext paramThumbnailTaskContext)
  {
    boolean bool2 = true;
    Log.e("MediaCodecThumbnailGen", "finishCapture");
    if (paramThumbnailTaskContext.jdField_a_of_type_Int != 0) {}
    for (boolean bool1 = false;; bool1 = true)
    {
      if (paramThumbnailTaskContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalmediaOpenglCodecOutputSurface != null)
      {
        paramThumbnailTaskContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalmediaOpenglCodecOutputSurface.a();
        paramThumbnailTaskContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalmediaOpenglCodecOutputSurface = null;
      }
      if (paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaCodec != null)
      {
        paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaCodec.stop();
        paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaCodec.release();
        paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaCodec = null;
      }
      if (paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaExtractor != null)
      {
        paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaExtractor.release();
        paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaExtractor = null;
      }
      MediaCodecThumbnailGenerator.ThumbnailResult localThumbnailResult = new MediaCodecThumbnailGenerator.ThumbnailResult();
      localThumbnailResult.jdField_a_of_type_JavaUtilList = Collections.unmodifiableList(paramThumbnailTaskContext.jdField_a_of_type_JavaUtilArrayList);
      localThumbnailResult.b = Collections.unmodifiableList(paramThumbnailTaskContext.jdField_b_of_type_JavaUtilArrayList);
      localThumbnailResult.jdField_a_of_type_Int = paramThumbnailTaskContext.jdField_a_of_type_Int;
      if (bool1) {
        if (paramThumbnailTaskContext.jdField_a_of_type_Boolean) {
          break label221;
        }
      }
      for (;;)
      {
        localThumbnailResult.jdField_a_of_type_Boolean = bool2;
        SLog.c("MediaCodecThumbnailGen", "hasBlackThumbnail = " + localThumbnailResult.jdField_a_of_type_Boolean);
        StoryReportor.a("actBlackThumbnailVideo", localThumbnailResult.jdField_a_of_type_Boolean, System.currentTimeMillis() - MediaCodecThumbnailGenerator.a(this.a), new String[0]);
        this.a.a.post(new MediaCodecThumbnailGenerator.CodecHandler.1(this, paramThumbnailTaskContext, bool1, localThumbnailResult));
        return;
        label221:
        bool2 = false;
      }
    }
  }
  
  private void a(MediaCodecThumbnailGenerator.ThumbnailTaskContext paramThumbnailTaskContext, boolean paramBoolean)
  {
    Object localObject1 = paramThumbnailTaskContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalmediaOpenglCodecOutputSurface;
    MediaCodecThumbnailGenerator.ThumbnailArgs localThumbnailArgs = paramThumbnailTaskContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalmediaDemosMediaCodecThumbnailGenerator$ThumbnailArgs;
    int k = paramThumbnailTaskContext.d;
    ArrayList localArrayList1 = paramThumbnailTaskContext.jdField_a_of_type_JavaUtilArrayList;
    ArrayList localArrayList2 = paramThumbnailTaskContext.jdField_b_of_type_JavaUtilArrayList;
    for (;;)
    {
      int j;
      try
      {
        ((CodecOutputSurface)localObject1).c();
        ((CodecOutputSurface)localObject1).d();
        ((CodecOutputSurface)localObject1).a(false);
        MediaCodecThumbnailGenerator.ThumbnailProgress localThumbnailProgress = new MediaCodecThumbnailGenerator.ThumbnailProgress();
        localObject1 = ((CodecOutputSurface)localObject1).a();
        if (localObject1 == null) {
          break label590;
        }
        j = paramThumbnailTaskContext.jdField_b_of_type_Int;
        if ((paramThumbnailTaskContext.jdField_b_of_type_Int % 180 > 0) && (((Bitmap)localObject1).getWidth() < ((Bitmap)localObject1).getHeight())) {
          break label593;
        }
        i = j;
        if (paramThumbnailTaskContext.jdField_b_of_type_Int % 180 == 0)
        {
          i = j;
          if (((Bitmap)localObject1).getWidth() > ((Bitmap)localObject1).getHeight()) {
            break label593;
          }
        }
        if (i > 0)
        {
          Object localObject2 = UIUtils.a((Bitmap)localObject1, i);
          ((Bitmap)localObject1).recycle();
          localObject1 = localObject2;
          localArrayList2.add(localObject1);
          if (!paramBoolean) {
            break label603;
          }
          localObject2 = new File(localThumbnailArgs.jdField_b_of_type_JavaLangString, String.format(Locale.getDefault(), a(k), new Object[0]));
          try
          {
            BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream((File)localObject2));
            float f2;
            float f1;
            localObject1 = paramThumbnailTaskContext.jdField_b_of_type_ArrayOfLong;
          }
          finally
          {
            try
            {
              ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 80, localBufferedOutputStream);
              if (localBufferedOutputStream == null) {}
            }
            finally
            {
              continue;
            }
            try
            {
              localBufferedOutputStream.close();
              localArrayList1.add(((File)localObject2).getAbsolutePath());
              localThumbnailProgress.jdField_a_of_type_JavaLangString = ((File)localObject2).getAbsolutePath();
              SLog.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() add: " + ((File)localObject2).getPath());
              localThumbnailProgress.jdField_a_of_type_Int = paramThumbnailTaskContext.d;
              localThumbnailProgress.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
              f2 = 0.0F;
              f1 = f2;
              if (localThumbnailArgs.jdField_b_of_type_Boolean)
              {
                f1 = f2;
                if (paramThumbnailTaskContext.d == 0)
                {
                  f1 = MediaCodecThumbnailGenerator.a((Bitmap)localObject1);
                  SLog.c("MediaCodecThumbnailGen", "blackRegionPrecent = " + f1);
                  localThumbnailProgress.jdField_a_of_type_Long = paramThumbnailTaskContext.jdField_b_of_type_ArrayOfLong[paramThumbnailTaskContext.d];
                }
              }
              if ((f1 >= 0.9F) && (localThumbnailProgress.jdField_a_of_type_Long <= 500000L) && (localThumbnailProgress.jdField_a_of_type_Long + 100000L <= paramThumbnailTaskContext.jdField_b_of_type_Long)) {
                continue;
              }
              localArrayList1.add(localThumbnailProgress.jdField_a_of_type_JavaLangString);
              localArrayList2.add(localObject1);
              if (f1 >= 0.9F) {
                break label606;
              }
              paramBoolean = true;
              paramThumbnailTaskContext.jdField_a_of_type_Boolean = paramBoolean;
              this.a.a.post(new MediaCodecThumbnailGenerator.CodecHandler.2(this, paramThumbnailTaskContext, localThumbnailProgress));
              paramThumbnailTaskContext.d += 1;
              obtainMessage(2, paramThumbnailTaskContext).sendToTarget();
              return;
            }
            catch (IOException localIOException)
            {
              SLog.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() error ", localIOException);
            }
            localObject3 = finally;
            localBufferedOutputStream = null;
            if (localBufferedOutputStream != null) {
              localBufferedOutputStream.close();
            }
          }
          i = paramThumbnailTaskContext.d;
          localObject1[i] += 50000L;
          obtainMessage(2, paramThumbnailTaskContext).sendToTarget();
          return;
        }
      }
      catch (TimeoutException localTimeoutException)
      {
        sendMessageDelayed(obtainMessage(3, paramThumbnailTaskContext), 100L);
        Log.e("MediaCodecThumbnailGen", "dumpThumbnailSurfaces() timeout delay 100ms");
        return;
      }
      continue;
      label590:
      continue;
      label593:
      int i = j + 90;
      continue;
      label603:
      continue;
      label606:
      paramBoolean = false;
    }
  }
  
  private void b(MediaCodecThumbnailGenerator.ThumbnailTaskContext paramThumbnailTaskContext)
  {
    MediaCodec localMediaCodec;
    long[] arrayOfLong2;
    int i2;
    long l1;
    MediaCodec.BufferInfo localBufferInfo;
    int j;
    int i;
    int k;
    int m;
    int n;
    long l2;
    try
    {
      MediaExtractor localMediaExtractor = paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaExtractor;
      localMediaCodec = paramThumbnailTaskContext.jdField_a_of_type_AndroidMediaMediaCodec;
      MediaCodecThumbnailGenerator.ThumbnailArgs localThumbnailArgs = paramThumbnailTaskContext.jdField_a_of_type_DovComTencentBizQqstoryTakevideoLocalmediaDemosMediaCodecThumbnailGenerator$ThumbnailArgs;
      long[] arrayOfLong1 = paramThumbnailTaskContext.jdField_a_of_type_ArrayOfLong;
      arrayOfLong2 = paramThumbnailTaskContext.jdField_b_of_type_ArrayOfLong;
      int i1 = paramThumbnailTaskContext.c;
      i2 = paramThumbnailTaskContext.d;
      l1 = localMediaExtractor.getSampleTime();
      ByteBuffer[] arrayOfByteBuffer = localMediaCodec.getInputBuffers();
      localBufferInfo = new MediaCodec.BufferInfo();
      j = 0;
      i = 0;
      k = 0;
      if ((i != 0) || (i2 >= localThumbnailArgs.d)) {
        break label724;
      }
      if ((paramThumbnailTaskContext.jdField_a_of_type_Long != arrayOfLong1[i2]) && (l1 < arrayOfLong1[i2]))
      {
        Log.e("MediaCodecThumbnailGen", "SeekTo: " + arrayOfLong1[i2]);
        localMediaExtractor.seekTo(arrayOfLong1[i2], 0);
        paramThumbnailTaskContext.jdField_a_of_type_Long = arrayOfLong1[i2];
        localMediaCodec.flush();
      }
      m = k;
      n = j;
      l2 = l1;
      if (k == 0)
      {
        m = localMediaCodec.dequeueInputBuffer(-1L);
        if (m < 0) {
          break label448;
        }
        n = localMediaExtractor.readSampleData(arrayOfByteBuffer[m], 0);
        if (n >= 0) {
          break label289;
        }
        localMediaCodec.queueInputBuffer(m, 0, 0, 0L, 4);
        m = 1;
        Log.d("MediaCodecThumbnailGen", "sent input EOS");
        k = j;
        j = m;
        break label729;
      }
      for (;;)
      {
        label246:
        k = m;
        j = n;
        l1 = l2;
        if (i != 0) {
          break;
        }
        j = localMediaCodec.dequeueOutputBuffer(localBufferInfo, 10000L);
        if (j != -1) {
          break label494;
        }
        Log.d("MediaCodecThumbnailGen", "no output from decoder available");
        break label743;
        label289:
        if (localMediaExtractor.getSampleTrackIndex() != i1) {
          Log.w("MediaCodecThumbnailGen", "WEIRD: got sample from track " + localMediaExtractor.getSampleTrackIndex() + ", expected " + i1);
        }
        localMediaCodec.queueInputBuffer(m, 0, n, localMediaExtractor.getSampleTime(), 0);
        Log.d("MediaCodecThumbnailGen", "submitted frame " + j + " to dec, size=" + n);
        l1 = localMediaExtractor.getSampleTime();
        Log.d("MediaCodecThumbnailGen", "extractor sample time = " + l1);
        localMediaExtractor.advance();
        m = j + 1;
        j = k;
        k = m;
        break label729;
        label448:
        Log.d("MediaCodecThumbnailGen", "input buffer not available");
        m = k;
        n = j;
        l2 = l1;
      }
      if (j != -3) {
        break label512;
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      QLog.e("MediaCodecThumbnailGen", 1, "decodeThumbnails fail", localIllegalStateException);
      obtainMessage(4, paramThumbnailTaskContext).sendToTarget();
      return;
    }
    label494:
    Log.d("MediaCodecThumbnailGen", "decoder output buffers changed");
    break label743;
    label512:
    if (j == -2)
    {
      MediaFormat localMediaFormat = localMediaCodec.getOutputFormat();
      Log.d("MediaCodecThumbnailGen", "decoder output format changed: " + localMediaFormat);
    }
    else if (j < 0)
    {
      Assert.a("unexpected result from decoder.dequeueOutputBuffer: " + j);
    }
    else
    {
      Log.d("MediaCodecThumbnailGen", "surface decoder given buffer " + j + " (size=" + localBufferInfo.size + ")");
      if ((localBufferInfo.flags & 0x4) != 0)
      {
        Log.d("MediaCodecThumbnailGen", "output EOS");
        i = 1;
        break label757;
      }
    }
    for (;;)
    {
      boolean bool;
      localMediaCodec.releaseOutputBuffer(j, bool);
      if (bool)
      {
        Log.d("MediaCodecThumbnailGen", "awaiting decode of time: " + l2);
        label724:
        for (i = 1;; i = 0)
        {
          if (i == 0)
          {
            obtainMessage(4, paramThumbnailTaskContext).sendToTarget();
            return;
          }
          obtainMessage(3, paramThumbnailTaskContext).sendToTarget();
          return;
          break;
        }
        label729:
        m = j;
        n = k;
        l2 = l1;
        break label246;
      }
      label743:
      k = m;
      j = n;
      l1 = l2;
      break;
      label757:
      if (l2 > arrayOfLong2[i2]) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public String a(int paramInt)
  {
    return String.format(Locale.getDefault(), "thumbnail-%d.jpg", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      Object localObject = (MediaCodecThumbnailGenerator.ThumbnailArgs)paramMessage.obj;
      SLog.c("MediaCodecThumbnailGen", "startCaptureThumbnails");
      a((MediaCodecThumbnailGenerator.ThumbnailArgs)localObject);
      continue;
      localObject = (MediaCodecThumbnailGenerator.ThumbnailTaskContext)paramMessage.obj;
      SLog.c("MediaCodecThumbnailGen", "decodeThumbnails");
      b((MediaCodecThumbnailGenerator.ThumbnailTaskContext)localObject);
      continue;
      localObject = (MediaCodecThumbnailGenerator.ThumbnailTaskContext)paramMessage.obj;
      SLog.c("MediaCodecThumbnailGen", "dumpThumbnailSurfaces");
      a((MediaCodecThumbnailGenerator.ThumbnailTaskContext)localObject, false);
      continue;
      localObject = (MediaCodecThumbnailGenerator.ThumbnailTaskContext)paramMessage.obj;
      SLog.c("MediaCodecThumbnailGen", "finishCapture");
      a((MediaCodecThumbnailGenerator.ThumbnailTaskContext)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.localmedia.demos.MediaCodecThumbnailGenerator.CodecHandler
 * JD-Core Version:    0.7.0.1
 */