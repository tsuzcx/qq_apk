package com.tencent.mobileqq.editor.composite.step;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaMuxer;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegFileUtils;
import com.tencent.mobileqq.videocodec.ffmpeg.FFmpegUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(18)
public class HwVideoMerge
{
  private static final boolean MERGE_SYS = false;
  private static final String TAG = "HwVideoMerge";
  private static Process mMergeProcess;
  private static Process mRecodeProcess;
  private MediaExtractor mAudioExtractor;
  private String mAudioFilePath;
  private int mHeight;
  private MediaMuxer mMuxerEngine;
  private HwVideoMerge.SampaleData mSampler = new HwVideoMerge.SampaleData(null);
  private MediaExtractor mVideoExtractor;
  private String mVideoFilePath;
  private int mWidth;
  
  public HwVideoMerge(String paramString1, String paramString2)
  {
    this.mVideoFilePath = paramString1;
    this.mAudioFilePath = paramString2;
  }
  
  private int checkNeedCreateMuxer()
  {
    this.mSampler.inputBuffer.position(0);
    if (this.mVideoExtractor.readSampleData(this.mSampler.inputBuffer, 0) <= 0)
    {
      releaseExtractor();
      return -5;
    }
    this.mSampler.inputBuffer.position(0);
    if (this.mAudioExtractor.readSampleData(this.mSampler.inputBuffer, 0) <= 0)
    {
      releaseExtractor();
      return -6;
    }
    return 0;
  }
  
  private boolean checkPath(String paramString)
  {
    return (paramString != null) && (!"".equals(paramString));
  }
  
  private final MediaExtractor createExtractor(String paramString)
  {
    if (checkPath(paramString))
    {
      MediaExtractor localMediaExtractor = new MediaExtractor();
      try
      {
        localMediaExtractor.setDataSource(paramString);
        int i = localMediaExtractor.getTrackCount();
        if (i != 1)
        {
          localMediaExtractor.release();
          try
          {
            StringBuilder localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("createExtractor:invalid media file:numTracks=");
            localStringBuilder1.append(i);
            localStringBuilder1.append(" path=");
            localStringBuilder1.append(paramString);
            printQLog(localStringBuilder1.toString(), null);
            return null;
          }
          catch (IOException localIOException1)
          {
            localMediaExtractor = null;
          }
        }
        else
        {
          return localMediaExtractor;
        }
      }
      catch (IOException localIOException2)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("createExtractor path:");
        localStringBuilder2.append(paramString);
        printQLog(localStringBuilder2.toString(), localIOException2);
        localMediaExtractor.release();
      }
    }
    return null;
  }
  
  public static boolean destroyRunningProcess()
  {
    printQLog("[@]  ffmpegProcess try destroy!", null);
    Process localProcess = mMergeProcess;
    boolean bool = true;
    int i;
    if ((localProcess != null) && (!FFmpegUtils.isProcessCompleted(localProcess)))
    {
      mMergeProcess.destroy();
      mMergeProcess = null;
      printQLog("[@]  ffmpegProcess, destroyMergeProcess!", null);
      i = 1;
    }
    else
    {
      i = 0;
    }
    localProcess = mRecodeProcess;
    int j;
    if ((localProcess != null) && (!FFmpegUtils.isProcessCompleted(localProcess)))
    {
      mRecodeProcess.destroy();
      mRecodeProcess = null;
      printQLog("[@]  ffmpegProcess, destroyRecodeProcess!", null);
      j = 1;
    }
    else
    {
      j = 0;
    }
    if (i == 0)
    {
      if (j != 0) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private static int ffmpegProcess(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    String str = FFmpegFileUtils.getFFmpeg(VideoEnvironment.getContext());
    Object localObject1 = new File(str);
    if (((File)localObject1).exists())
    {
      boolean bool = ((File)localObject1).setExecutable(true, true);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[@] ffmpegProcess [setExecutable] code=");
      localStringBuilder.append(bool);
      localStringBuilder.append(", len:");
      localStringBuilder.append(((File)localObject1).length());
      printQLog(localStringBuilder.toString(), null);
      getRotationDegree(paramString1, paramInt);
      localObject1 = new ArrayList();
      ((List)localObject1).add(str);
      ((List)localObject1).add("-d");
      ((List)localObject1).add("-y");
      ((List)localObject1).add("-loglevel");
      ((List)localObject1).add("quiet");
      ((List)localObject1).add("-i");
      ((List)localObject1).add(paramString1);
      ((List)localObject1).add("-i");
      ((List)localObject1).add(paramString2);
      ((List)localObject1).add("-vcodec");
      ((List)localObject1).add("copy");
      ((List)localObject1).add("-acodec");
      ((List)localObject1).add("copy");
      ((List)localObject1).add(paramString3);
      ((List)localObject1).add(FFmpegFileUtils.getAVCodecSoFilePath(VideoEnvironment.getContext()));
      paramString1 = new StringBuilder();
      paramString1.append("[@] ffmpegProcess ");
      paramString1.append(localObject1);
      printQLog(paramString1.toString(), null);
      paramString1 = new HwVideoMerge.LogStream(null);
      paramString2 = new ProcessBuilder(new String[0]);
      paramString2.redirectErrorStream(true);
      paramString2.command((List)localObject1);
      try
      {
        paramString2 = paramString2.start();
        mMergeProcess = paramString2;
        paramString1.mProcess = paramString2;
        paramString1.initStream();
        try
        {
          paramString2.waitFor();
        }
        catch (InterruptedException localInterruptedException)
        {
          printQLog("[@] IOException log:", localInterruptedException);
        }
        paramInt = paramString2.exitValue();
        if (paramInt != 0)
        {
          localObject2 = new File(paramString3);
          if (((File)localObject2).exists()) {
            ((File)localObject2).delete();
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[@] process.exitValue:errcode=");
          ((StringBuilder)localObject2).append(paramInt);
          printQLog(((StringBuilder)localObject2).toString(), null);
        }
        paramString3 = new File(paramString3);
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[@]  ffmpegProcess, outfile exists, ");
        ((StringBuilder)localObject2).append(paramString3.exists());
        printQLog(((StringBuilder)localObject2).toString(), null);
        paramString1.printStream();
        if (paramString2 != null)
        {
          paramString2.destroy();
          if (mMergeProcess != null) {
            mMergeProcess = null;
          }
        }
        return paramInt;
      }
      catch (IOException paramString1)
      {
        printQLog("[@] IOException log:", paramString1);
        return -11;
      }
    }
    return -12;
  }
  
  public static int ffmpegReCodec(String paramString1, String paramString2, int paramInt)
  {
    Object localObject1 = FFmpegFileUtils.getFFmpeg(VideoEnvironment.getContext());
    Object localObject2 = new File((String)localObject1);
    if (((File)localObject2).exists())
    {
      boolean bool = ((File)localObject2).setExecutable(true, true);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[@] ffmpegProcess [setExecutable] code=");
      ((StringBuilder)localObject2).append(bool);
      printQLog(((StringBuilder)localObject2).toString(), null);
      getRotationDegree(paramString1, paramInt);
      localObject2 = new ArrayList();
      ((List)localObject2).add(localObject1);
      ((List)localObject2).add("-d");
      ((List)localObject2).add("-y");
      ((List)localObject2).add("-loglevel");
      ((List)localObject2).add("quiet");
      ((List)localObject2).add("-i");
      ((List)localObject2).add(paramString1);
      ((List)localObject2).add("-profile:v");
      ((List)localObject2).add("baseline");
      ((List)localObject2).add("-video_track_timescale");
      ((List)localObject2).add("90000");
      ((List)localObject2).add(paramString2);
      ((List)localObject2).add(FFmpegFileUtils.getAVCodecSoFilePath(VideoEnvironment.getContext()));
      paramString1 = new HwVideoMerge.LogStream(null);
      localObject1 = new ProcessBuilder(new String[0]);
      ((ProcessBuilder)localObject1).redirectErrorStream(true);
      ((ProcessBuilder)localObject1).command((List)localObject2);
      try
      {
        localObject1 = ((ProcessBuilder)localObject1).start();
        mRecodeProcess = (Process)localObject1;
        paramString1.mProcess = ((Process)localObject1);
        paramString1.initStream();
        try
        {
          ((Process)localObject1).waitFor();
        }
        catch (InterruptedException localInterruptedException)
        {
          printQLog("[@] IOException log:", localInterruptedException);
        }
        paramInt = ((Process)localObject1).exitValue();
        if (paramInt != 0)
        {
          paramString2 = new File(paramString2);
          if (paramString2.exists()) {
            paramString2.delete();
          }
          paramString2 = new StringBuilder();
          paramString2.append("[@] process.exitValue:errcode=");
          paramString2.append(paramInt);
          printQLog(paramString2.toString(), null);
        }
        paramString1.printStream();
        ((Process)localObject1).destroy();
        if (mRecodeProcess != null) {
          mRecodeProcess = null;
        }
        return paramInt;
      }
      catch (IOException paramString1)
      {
        printQLog("[@] IOException log:", paramString1);
        return -11;
      }
    }
    return -12;
  }
  
  private boolean getAudioInputBuffer()
  {
    this.mSampler.inputBuffer.position(0);
    MediaExtractor localMediaExtractor = this.mAudioExtractor;
    if (localMediaExtractor == null) {
      return true;
    }
    int i = localMediaExtractor.readSampleData(this.mSampler.inputBuffer, 0);
    if (i <= 0) {
      return true;
    }
    this.mSampler.bufferInfo.presentationTimeUs = this.mAudioExtractor.getSampleTime();
    this.mSampler.bufferInfo.size = i;
    this.mSampler.bufferInfo.offset = 0;
    this.mSampler.bufferInfo.flags = this.mAudioExtractor.getSampleFlags();
    this.mAudioExtractor.advance();
    return false;
  }
  
  private static int getRotationDegree(String paramString, int paramInt)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = null;
      try
      {
        String str = localMediaMetadataRetriever.extractMetadata(24);
        paramString = str;
      }
      catch (Exception localException)
      {
        QLog.e("HwVideoMerge", 2, localException, new Object[0]);
      }
      localMediaMetadataRetriever.release();
      if (paramString == null) {
        return paramInt;
      }
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (IllegalArgumentException|NumberFormatException paramString) {}
    return paramInt;
  }
  
  private boolean getVideoInputBuffer()
  {
    this.mSampler.inputBuffer.position(0);
    MediaExtractor localMediaExtractor = this.mVideoExtractor;
    if (localMediaExtractor == null) {
      return true;
    }
    int i = localMediaExtractor.readSampleData(this.mSampler.inputBuffer, 0);
    if (i <= 0) {
      return true;
    }
    this.mSampler.bufferInfo.presentationTimeUs = this.mVideoExtractor.getSampleTime();
    this.mSampler.bufferInfo.size = i;
    this.mSampler.bufferInfo.offset = 0;
    this.mSampler.bufferInfo.flags = this.mVideoExtractor.getSampleFlags();
    this.mVideoExtractor.advance();
    return false;
  }
  
  public static final int merge(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    return mergeFFmpegMuxer(paramString1, paramString2, paramString3, paramInt);
  }
  
  public static final int mergeFFmpegMuxer(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    int j = new HwVideoMerge(paramString1, paramString2).initExtractor(null, paramInt);
    int i;
    if ((j != -2) && (j != -4) && (j != -6))
    {
      i = j;
      if (j == -9) {
        return ffmpegProcess(paramString1, paramString2, paramString3, paramInt);
      }
    }
    else
    {
      paramString1 = new File(paramString1);
      paramString2 = new File(paramString3);
      if (FileUtils.moveFile(paramString1.getAbsolutePath(), paramString2.getAbsolutePath())) {
        return 0;
      }
      i = -10;
    }
    return i;
  }
  
  public static final int mergeSysMuxer(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    paramString2 = new HwVideoMerge(paramString1, paramString2);
    int i = paramString2.initExtractor(paramString3, paramInt);
    if ((i != -2) && (i != -4) && (i != -6))
    {
      paramInt = i;
      if (i == 0)
      {
        paramString2.doWork();
        return i;
      }
    }
    else
    {
      if (new File(paramString1).renameTo(new File(paramString3))) {
        return 0;
      }
      paramInt = -10;
    }
    return paramInt;
  }
  
  private void overlapCopyVideoFirst()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      if ((bool2) && (i != 0)) {
        return;
      }
      boolean bool1 = bool2;
      if (!bool2)
      {
        bool2 = getVideoInputBuffer();
        bool1 = bool2;
        if (!bool2)
        {
          this.mMuxerEngine.writeSampleData(this.mSampler.videoTrack, this.mSampler.inputBuffer, this.mSampler.bufferInfo);
          bool1 = bool2;
        }
      }
      bool2 = bool1;
      if (i == 0)
      {
        boolean bool3 = getAudioInputBuffer();
        bool2 = bool1;
        i = bool3;
        if (!bool3)
        {
          this.mMuxerEngine.writeSampleData(this.mSampler.audioTrack, this.mSampler.inputBuffer, this.mSampler.bufferInfo);
          bool2 = bool1;
          i = bool3;
        }
      }
    }
  }
  
  private static void printQLog(String paramString, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null)
      {
        QLog.d("HwVideoMerge", 2, paramString, paramThrowable);
        return;
      }
      QLog.d("HwVideoMerge", 2, paramString);
    }
  }
  
  private void releaseExtractor()
  {
    MediaExtractor localMediaExtractor = this.mVideoExtractor;
    if (localMediaExtractor != null)
    {
      localMediaExtractor.release();
      this.mVideoExtractor = null;
    }
    localMediaExtractor = this.mAudioExtractor;
    if (localMediaExtractor != null)
    {
      localMediaExtractor.release();
      this.mAudioExtractor = null;
    }
  }
  
  public void doWork()
  {
    this.mMuxerEngine.start();
    overlapCopyVideoFirst();
    this.mMuxerEngine.stop();
    this.mMuxerEngine.release();
    this.mMuxerEngine = null;
    releaseExtractor();
  }
  
  public int initExtractor(String paramString, int paramInt)
  {
    this.mVideoExtractor = createExtractor(this.mVideoFilePath);
    if (this.mVideoExtractor == null) {
      return -1;
    }
    this.mAudioExtractor = createExtractor(this.mAudioFilePath);
    if (this.mAudioExtractor == null)
    {
      releaseExtractor();
      return -2;
    }
    MediaFormat localMediaFormat = this.mVideoExtractor.getTrackFormat(0);
    Object localObject = localMediaFormat.getString("mime");
    this.mWidth = localMediaFormat.getInteger("width");
    this.mHeight = localMediaFormat.getInteger("height");
    int i;
    if (((String)localObject).startsWith("video/"))
    {
      this.mVideoExtractor.selectTrack(0);
      localObject = this.mAudioExtractor.getTrackFormat(0);
      if (((MediaFormat)localObject).getString("mime").startsWith("audio/"))
      {
        this.mAudioExtractor.selectTrack(0);
        this.mSampler.init(this.mWidth, this.mHeight);
        i = checkNeedCreateMuxer();
        if (i != 0) {
          return i;
        }
        if (!checkPath(paramString))
        {
          releaseExtractor();
          return -9;
        }
      }
    }
    try
    {
      if (new File(paramString).exists())
      {
        releaseExtractor();
        return -8;
      }
      this.mMuxerEngine = new MediaMuxer(paramString, 0);
      paramInt = getRotationDegree(this.mVideoFilePath, paramInt);
      this.mMuxerEngine.setOrientationHint(paramInt);
      this.mSampler.videoTrack = this.mMuxerEngine.addTrack(localMediaFormat);
      this.mSampler.audioTrack = this.mMuxerEngine.addTrack((MediaFormat)localObject);
      return i;
    }
    catch (IOException paramString)
    {
      label271:
      break label271;
    }
    this.mMuxerEngine = null;
    releaseExtractor();
    return -7;
    releaseExtractor();
    return -4;
    releaseExtractor();
    return -3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.step.HwVideoMerge
 * JD-Core Version:    0.7.0.1
 */