package com.tencent.mobileqq.shortvideo.mediadevice;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.maxvideo.MaxVideoConst;
import com.tencent.maxvideo.mediadevice.EncodeVideo;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.shortvideo.common.GloableValue;
import com.tencent.mobileqq.shortvideo.hwcodec.HwEncodeHelper;
import com.tencent.mobileqq.shortvideo.util.VidUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.QZoneFilePath;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.io.File;
import java.io.IOException;

public class EncodeThread
  implements MaxVideoConst, Runnable
{
  public static final String KEY_BACKGROUND_MUSIC_OFFSET = "key_background_music_offset";
  public static final String KEY_BACKGROUND_MUSIC_PATH = "key_background_music_path";
  public static final String KEY_DOODLE_PATH = "key_doodle_path";
  public static final String KEY_LOCAL_RAW_VIDEO_DIR = "key_local_raw_video_dir";
  public static final String KEY_VIDEO_HEIGHT = "key_video_height";
  public static final String KEY_VIDEO_WIDTH = "key_video_width";
  public int errorCode;
  private long mAudioEncodeEndTime = -1L;
  private long mAudioEncodeStartTime = -1L;
  private boolean mEnableBaselineMp4Encode;
  private boolean mEnableClearAudioData = false;
  private boolean mEnableDeleteCache = true;
  private boolean mEnableHardEncode;
  private PublishVideoEntry mEntry;
  private boolean mGenerateGif;
  private Handler mHandler;
  private byte[] mMosaicMask = null;
  private int mMosaicSize = 0;
  protected boolean mMuteVoice;
  private int mOrientationDegree;
  private String mSourceDirString;
  public String mTargetFilePath;
  private long mVideoEncodeEndFrame = -1L;
  private long mVideoEncodeStartFrame = -1L;
  private String targetKey;
  private EncodeVideo videoEncode;
  
  public EncodeThread(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3)
  {
    this.mHandler = paramHandler;
    this.mSourceDirString = paramString1;
    this.targetKey = paramString3;
    this.videoEncode = new EncodeVideo(this.mHandler);
    this.mTargetFilePath = paramString2;
    this.mEnableHardEncode = true;
    this.mEnableDeleteCache = true;
    this.mEnableClearAudioData = false;
    this.mEnableBaselineMp4Encode = false;
  }
  
  public EncodeThread(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3, PublishVideoEntry paramPublishVideoEntry)
  {
    this(paramContext, paramHandler, paramString1, paramString2, paramString3);
    this.mEntry = paramPublishVideoEntry;
  }
  
  public static void cancelCurrentEncoder()
  {
    try
    {
      EncodeVideo.cancelCurrentEncoder();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  private void doNotify(Message paramMessage)
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null) {}
    try
    {
      localHandler.sendMessage(paramMessage);
      return;
    }
    catch (Exception paramMessage) {}
  }
  
  private void notifyEncodeBegin()
  {
    if (this.mHandler == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    doNotify(localMessage);
  }
  
  private void notifyEncodeEnd(int paramInt, String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    localMessage.arg1 = paramInt;
    localMessage.getData().putString("maxvideo.file.mp4", paramString);
    localMessage.getData().putString("source_path", this.mSourceDirString);
    localMessage.getData().putString("client_key", this.targetKey);
    if ((paramInt == 0) && (this.mEntry != null))
    {
      localMessage.getData().putString("key_background_music_path", this.mEntry.backgroundMusicPath);
      localMessage.getData().putInt("key_background_music_offset", this.mEntry.backgroundMusicOffset);
      localMessage.getData().putString("key_doodle_path", this.mEntry.doodlePath);
      localMessage.getData().putString("key_local_raw_video_dir", this.mEntry.mLocalRawVideoDir);
      localMessage.getData().putInt("key_video_width", this.mEntry.videoWidth);
      localMessage.getData().putInt("key_video_height", this.mEntry.videoHeight);
    }
    doNotify(localMessage);
  }
  
  private int startEncode(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    boolean bool = this.mEnableBaselineMp4Encode;
    if (bool) {
      CodecParam.setEnableBaseLineMp4Flag(bool);
    }
    int[] arrayOfInt = CodecParam.getConfigParam();
    CodecParam.setEnableBaseLineMp4Flag(false);
    Object localObject = this.mMosaicMask;
    if (localObject != null)
    {
      i = this.mMosaicSize;
      if (i != 0)
      {
        EncodeVideo localEncodeVideo = this.videoEncode;
        EncodeVideo.setMosaicData((byte[])localObject, i);
      }
    }
    long l1 = SystemClock.uptimeMillis();
    long l2;
    try
    {
      localObject = this.videoEncode;
      l2 = this.mVideoEncodeStartFrame;
      long l3 = this.mVideoEncodeEndFrame;
      long l4 = this.mAudioEncodeStartTime;
      long l5 = this.mAudioEncodeEndTime;
      try
      {
        i = ((EncodeVideo)localObject).startPartEncode(paramString1, l2, l3, paramString2, l4, l5, paramString3, paramString4, arrayOfInt);
      }
      catch (UnsatisfiedLinkError paramString1) {}
      if (!QLog.isColorLevel()) {
        break label140;
      }
    }
    catch (UnsatisfiedLinkError paramString1) {}
    QLog.e("startPartEncode", 2, "exception:", paramString1);
    label140:
    int i = -200;
    StoryReportor.b("take_video", "create_mp4_result", 0, i, new String[0]);
    if (i == 0)
    {
      l2 = SystemClock.uptimeMillis();
      paramString1 = new StringBuilder();
      paramString1.append("");
      paramString1.append(l2 - l1);
      StoryReportor.b("take_video", "create_mp4_time", 0, 0, new String[] { paramString1.toString() });
    }
    CodecParam.mSaveMode = 0;
    CodecParam.mCRFValue = 23;
    if ((this.mMosaicMask != null) && (this.mMosaicSize != 0)) {
      EncodeVideo.setMosaicData(null, 0);
    }
    return i;
  }
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    this.errorCode = 0;
    Object localObject1;
    if (TextUtils.isEmpty(this.mSourceDirString))
    {
      this.errorCode = 5100;
      notifyEncodeEnd(this.errorCode, null);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(GloableValue.c);
      ((StringBuilder)localObject1).append("");
      QzoneVideoBeaconReport.reportVideoEvent(((StringBuilder)localObject1).toString(), "qzone_video_record", "9", null);
      return;
    }
    Object localObject7 = new File(this.mSourceDirString);
    if ((((File)localObject7).exists()) && (((File)localObject7).isDirectory()))
    {
      String[] arrayOfString = ((File)localObject7).list();
      if (arrayOfString == null)
      {
        this.errorCode = 5101;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("EncodeThread empty dir, mSourceDirString = ");
          ((StringBuilder)localObject1).append(this.mSourceDirString);
          QLog.d("MaxVideo.Plugin", 2, ((StringBuilder)localObject1).toString());
        }
        notifyEncodeEnd(this.errorCode, null);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(GloableValue.c);
        ((StringBuilder)localObject1).append("");
        QzoneVideoBeaconReport.reportVideoEvent(((StringBuilder)localObject1).toString(), "qzone_video_record", "9", null);
        return;
      }
      int j = arrayOfString.length;
      Object localObject3 = null;
      localObject1 = localObject3;
      Object localObject4 = localObject1;
      int i = 0;
      Object localObject5;
      Object localObject6;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (str.endsWith(".vf"))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(this.mSourceDirString);
          ((StringBuilder)localObject3).append(File.separator);
          ((StringBuilder)localObject3).append(str);
          localObject5 = ((StringBuilder)localObject3).toString();
          localObject6 = localObject1;
        }
        else if (str.endsWith(".af"))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.mSourceDirString);
          ((StringBuilder)localObject1).append(File.separator);
          ((StringBuilder)localObject1).append(str);
          localObject6 = ((StringBuilder)localObject1).toString();
          localObject5 = localObject3;
        }
        else
        {
          localObject5 = localObject3;
          localObject6 = localObject1;
          if (str.endsWith(".ini"))
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(this.mSourceDirString);
            ((StringBuilder)localObject4).append(File.separator);
            ((StringBuilder)localObject4).append(str);
            localObject4 = ((StringBuilder)localObject4).toString();
            localObject6 = localObject1;
            localObject5 = localObject3;
          }
        }
        i += 1;
        localObject3 = localObject5;
        localObject1 = localObject6;
      }
      if ((FileUtils.fileExists((String)localObject3)) && (FileUtils.fileExists((String)localObject1)) && (FileUtils.fileExists((String)localObject4)))
      {
        if (this.mGenerateGif)
        {
          localObject4 = QZoneFilePath.DCIM_CAMERA_PATH;
          localObject5 = VidUtil.getVidFromSourceDirFile((File)localObject7);
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append((String)localObject4);
          ((StringBuilder)localObject6).append(File.separator);
          ((StringBuilder)localObject6).append("gif");
          localObject6 = new File(((StringBuilder)localObject6).toString());
          if ((((File)localObject6).exists()) && (!((File)localObject6).isDirectory())) {
            ((File)localObject6).delete();
          }
          if (!((File)localObject6).exists()) {
            ((File)localObject6).mkdir();
          }
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append((String)localObject4);
          ((StringBuilder)localObject6).append(File.separator);
          ((StringBuilder)localObject6).append("gif");
          ((StringBuilder)localObject6).append(File.separator);
          ((StringBuilder)localObject6).append((String)localObject5);
          ((StringBuilder)localObject6).append(".gif");
          localObject4 = ((StringBuilder)localObject6).toString();
          l1 = System.currentTimeMillis();
          i = GifProcessor.generateGifFromVFile((String)localObject3, (String)localObject1, this.mOrientationDegree, (String)localObject4);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("generateGifFromVFile cost=");
          ((StringBuilder)localObject1).append(System.currentTimeMillis() - l1);
          ((StringBuilder)localObject1).append(" ret=");
          ((StringBuilder)localObject1).append(i);
          QLog.i("MaxVideo.Plugin", 1, ((StringBuilder)localObject1).toString());
          this.mTargetFilePath = ((String)localObject4);
          if ((i == 0) && (this.mEnableDeleteCache)) {
            FileUtils.deleteDirectory(this.mSourceDirString);
          }
          if (i == 0) {
            i = 0;
          } else {
            i = 5109;
          }
          this.errorCode = i;
          notifyEncodeEnd(this.errorCode, (String)localObject4);
          return;
        }
        if (this.mEnableClearAudioData)
        {
          FileUtils.deleteFile((String)localObject1);
          try
          {
            FileUtils.createFile((String)localObject1);
          }
          catch (IOException localIOException)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MaxVideo.Plugin", 2, "EncodeThread: createFile audiofile... ", localIOException);
            }
            this.errorCode = 5108;
            notifyEncodeEnd(this.errorCode, null);
            return;
          }
        }
        localObject6 = this.mTargetFilePath;
        if (TextUtils.isEmpty((CharSequence)localObject6))
        {
          localObject5 = QZoneFilePath.DCIM_CAMERA_PATH;
          localObject6 = new File((String)localObject5);
          if ((!((File)localObject6).mkdirs()) && (!((File)localObject6).isDirectory()))
          {
            this.errorCode = 5102;
            notifyEncodeEnd(this.errorCode, null);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(GloableValue.c);
            ((StringBuilder)localObject2).append("");
            QzoneVideoBeaconReport.reportVideoEvent(((StringBuilder)localObject2).toString(), "qzone_video_record", "10", null);
            return;
          }
          localObject6 = VidUtil.getVidFromSourceDirFile((File)localObject7);
          localObject7 = new StringBuilder();
          ((StringBuilder)localObject7).append((String)localObject5);
          ((StringBuilder)localObject7).append(File.separator);
          ((StringBuilder)localObject7).append((String)localObject6);
          ((StringBuilder)localObject7).append(".mp4");
          localObject5 = ((StringBuilder)localObject7).toString();
          this.mTargetFilePath = ((String)localObject5);
        }
        else
        {
          localObject7 = new File((String)localObject6).getParentFile();
          localObject5 = localObject6;
          if (localObject7 != null)
          {
            localObject5 = localObject6;
            if (!((File)localObject7).exists())
            {
              ((File)localObject7).mkdirs();
              localObject5 = localObject6;
            }
          }
        }
        notifyEncodeBegin();
        StringBuilder localStringBuilder;
        if (this.mEnableHardEncode)
        {
          localObject6 = new HwEncodeHelper((String)localObject3, (String)localObject2, this.mSourceDirString);
          try
          {
            i = ((HwEncodeHelper)localObject6).c();
          }
          catch (NoSuchMethodError localNoSuchMethodError)
          {
            localNoSuchMethodError.printStackTrace();
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
          {
            localUnsatisfiedLinkError.printStackTrace();
          }
          i = -1;
          if (i == 0)
          {
            this.mTargetFilePath = ((HwEncodeHelper)localObject6).d();
            boolean bool = FileUtils.fileExistsAndNotEmpty(this.mTargetFilePath);
            if (QLog.isColorLevel())
            {
              localObject6 = new StringBuilder();
              ((StringBuilder)localObject6).append("EncodeThread hwEncode success, mTargetFilePath = ");
              ((StringBuilder)localObject6).append(this.mTargetFilePath);
              ((StringBuilder)localObject6).append(", isExist = ");
              ((StringBuilder)localObject6).append(bool);
              QLog.d("MaxVideo.Plugin", 2, ((StringBuilder)localObject6).toString());
            }
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append(GloableValue.c);
            ((StringBuilder)localObject6).append("");
            QzoneVideoBeaconReport.reportVideoEvent(((StringBuilder)localObject6).toString(), "qzone_video_record", "record_hw_success", "0", null);
          }
          else
          {
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append(GloableValue.c);
            ((StringBuilder)localObject6).append("");
            localObject6 = ((StringBuilder)localObject6).toString();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(i);
            localStringBuilder.append("_");
            localStringBuilder.append(Build.MODEL);
            QzoneVideoBeaconReport.reportVideoEvent((String)localObject6, "qzone_video_record", "record_hw_success", "1", localStringBuilder.toString());
          }
          j = i;
          if (QLog.isColorLevel())
          {
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append("EncodeThread hwEncode serrcode = ");
            ((StringBuilder)localObject6).append(i);
            QLog.d("MaxVideo.Plugin", 2, ((StringBuilder)localObject6).toString());
            j = i;
          }
        }
        else
        {
          j = -1;
        }
        if (QLog.isColorLevel())
        {
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("EncodeThread hwEncode start soft errcode = ");
          ((StringBuilder)localObject6).append(j);
          ((StringBuilder)localObject6).append(" mEnableHardEncode=");
          ((StringBuilder)localObject6).append(this.mEnableHardEncode);
          QLog.d("MaxVideo.Plugin", 2, ((StringBuilder)localObject6).toString());
        }
        if (j == -1)
        {
          if (this.mMuteVoice) {
            localObject6 = "";
          } else {
            localObject6 = localObject2;
          }
          i = startEncode((String)localObject3, (String)localObject6, (String)localObject4, (String)localObject5);
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("EncodeThread hwEncode start soft over ret = ");
          ((StringBuilder)localObject6).append(i);
          QLog.i("MaxVideo.Plugin", 1, ((StringBuilder)localObject6).toString());
          if (i == 0)
          {
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append(GloableValue.c);
            ((StringBuilder)localObject6).append("");
            QzoneVideoBeaconReport.reportVideoEvent(((StringBuilder)localObject6).toString(), "qzone_video_record", "record_sw_success", "0", null);
          }
          else
          {
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append(GloableValue.c);
            ((StringBuilder)localObject6).append("");
            localObject6 = ((StringBuilder)localObject6).toString();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(i);
            localStringBuilder.append("_");
            localStringBuilder.append(Build.MODEL);
            QzoneVideoBeaconReport.reportVideoEvent((String)localObject6, "qzone_video_record", "record_sw_success", "1", localStringBuilder.toString());
          }
        }
        else
        {
          i = 0;
        }
        if (QLog.isColorLevel())
        {
          localObject6 = new StringBuilder();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("vfFilePath is ");
          localStringBuilder.append((String)localObject3);
          ((StringBuilder)localObject6).append(localStringBuilder.toString());
          ((StringBuilder)localObject6).append('\n');
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("afFilePath is ");
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject6).append(((StringBuilder)localObject3).toString());
          ((StringBuilder)localObject6).append('\n');
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("manifestFilePath is ");
          ((StringBuilder)localObject2).append((String)localObject4);
          ((StringBuilder)localObject6).append(((StringBuilder)localObject2).toString());
          ((StringBuilder)localObject6).append('\n');
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("targetFile is ");
          ((StringBuilder)localObject2).append((String)localObject5);
          ((StringBuilder)localObject6).append(((StringBuilder)localObject2).toString());
          QLog.i("MaxVideo.Plugin", 2, ((StringBuilder)localObject6).toString());
        }
        if (i == 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(GloableValue.c);
          ((StringBuilder)localObject2).append("");
          QzoneVideoBeaconReport.reportVideoEvent(((StringBuilder)localObject2).toString(), "qzone_video_record", "record_success", "0", null);
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(GloableValue.c);
          ((StringBuilder)localObject2).append("");
          localObject2 = ((StringBuilder)localObject2).toString();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(i);
          ((StringBuilder)localObject3).append("_");
          ((StringBuilder)localObject3).append(Build.MODEL);
          QzoneVideoBeaconReport.reportVideoEvent((String)localObject2, "qzone_video_record", "record_success", "1", ((StringBuilder)localObject3).toString());
        }
        if (i != -1)
        {
          if (i != 0)
          {
            if (i != 1)
            {
              if (i != 2)
              {
                if (i != 3)
                {
                  if (i == 4) {
                    this.errorCode = 5107;
                  }
                }
                else {
                  this.errorCode = 5106;
                }
              }
              else {
                this.errorCode = 5103;
              }
            }
            else {
              this.errorCode = 5105;
            }
          }
          else
          {
            this.errorCode = 0;
            long l2 = System.currentTimeMillis();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("encode af vf to mp4, cost=");
            ((StringBuilder)localObject2).append(l2 - l1);
            QLog.i("MaxVideo.Plugin", 1, ((StringBuilder)localObject2).toString());
            if (this.mEnableDeleteCache)
            {
              FileUtils.deleteDirectory(this.mSourceDirString);
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("EncodeThread encode success delete cache... cost=");
              ((StringBuilder)localObject2).append(System.currentTimeMillis() - l2);
              QLog.i("MaxVideo.Plugin", 1, ((StringBuilder)localObject2).toString());
            }
          }
        }
        else {
          this.errorCode = 5104;
        }
        i = this.errorCode;
        if (i != 5103) {
          notifyEncodeEnd(i, (String)localObject5);
        }
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("EncodeThread empty file, mSourceDirString = ");
        ((StringBuilder)localObject5).append(this.mSourceDirString);
        ((StringBuilder)localObject5).append(",vfFilePath = ");
        ((StringBuilder)localObject5).append((String)localObject3);
        ((StringBuilder)localObject5).append(",afFilePath = ");
        ((StringBuilder)localObject5).append((String)localObject2);
        ((StringBuilder)localObject5).append(",manifestFilePath = ");
        ((StringBuilder)localObject5).append((String)localObject4);
        QLog.d("MaxVideo.Plugin", 2, ((StringBuilder)localObject5).toString());
      }
      this.errorCode = 5101;
      notifyEncodeEnd(this.errorCode, null);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(GloableValue.c);
      ((StringBuilder)localObject2).append("");
      QzoneVideoBeaconReport.reportVideoEvent(((StringBuilder)localObject2).toString(), "qzone_video_record", "9", null);
      return;
    }
    this.errorCode = 5100;
    notifyEncodeEnd(this.errorCode, null);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(GloableValue.c);
    ((StringBuilder)localObject2).append("");
    QzoneVideoBeaconReport.reportVideoEvent(((StringBuilder)localObject2).toString(), "qzone_video_record", "9", null);
  }
  
  public void setEnableBaselineMp4Encode(boolean paramBoolean)
  {
    this.mEnableBaselineMp4Encode = paramBoolean;
  }
  
  public void setEnableClearAudioData(boolean paramBoolean)
  {
    this.mEnableClearAudioData = paramBoolean;
  }
  
  public void setEnableDeleteCache(boolean paramBoolean)
  {
    this.mEnableDeleteCache = paramBoolean;
  }
  
  public void setEnableHardEncode(boolean paramBoolean)
  {
    this.mEnableHardEncode = paramBoolean;
  }
  
  public void setGenerateGif(boolean paramBoolean)
  {
    this.mGenerateGif = paramBoolean;
  }
  
  public void setMosaicMask(byte[] paramArrayOfByte, int paramInt)
  {
    this.mMosaicMask = paramArrayOfByte;
    this.mMosaicSize = paramInt;
  }
  
  public void setMuteVoice(boolean paramBoolean)
  {
    this.mMuteVoice = paramBoolean;
  }
  
  public void setOrientationDegree(int paramInt)
  {
    this.mOrientationDegree = paramInt;
  }
  
  public void setPartEncodeInfo(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    this.mVideoEncodeStartFrame = paramLong1;
    this.mVideoEncodeEndFrame = paramLong2;
    this.mAudioEncodeStartTime = paramLong3;
    this.mAudioEncodeEndTime = paramLong4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread
 * JD-Core Version:    0.7.0.1
 */