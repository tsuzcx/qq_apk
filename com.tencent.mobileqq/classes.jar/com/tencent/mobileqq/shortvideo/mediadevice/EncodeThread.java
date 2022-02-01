package com.tencent.mobileqq.shortvideo.mediadevice;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import bczp;
import bdag;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.maxvideo.MaxVideoConst;
import com.tencent.maxvideo.mediadevice.EncodeVideo;
import com.tencent.mobileqq.shortvideo.util.VidUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.cache.QZoneFilePath;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.io.File;
import java.io.IOException;
import wcn;
import ykv;

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
  private boolean mEnableClearAudioData;
  private boolean mEnableDeleteCache = true;
  private boolean mEnableHardEncode;
  private PublishVideoEntry mEntry;
  private boolean mGenerateGif;
  private Handler mHandler;
  private byte[] mMosaicMask;
  private int mMosaicSize;
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
    if (this.mHandler != null) {}
    try
    {
      this.mHandler.sendMessage(paramMessage);
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
    if (this.mEnableBaselineMp4Encode) {
      CodecParam.setEnableBaseLineMp4Flag(this.mEnableBaselineMp4Encode);
    }
    int[] arrayOfInt = CodecParam.getConfigParam();
    CodecParam.setEnableBaseLineMp4Flag(false);
    if ((this.mMosaicMask != null) && (this.mMosaicSize != 0))
    {
      EncodeVideo localEncodeVideo = this.videoEncode;
      EncodeVideo.setMosaicData(this.mMosaicMask, this.mMosaicSize);
    }
    long l1 = SystemClock.uptimeMillis();
    try
    {
      i = this.videoEncode.startPartEncode(paramString1, this.mVideoEncodeStartFrame, this.mVideoEncodeEndFrame, paramString2, this.mAudioEncodeStartTime, this.mAudioEncodeEndTime, paramString3, paramString4, arrayOfInt);
      ykv.b("take_video", "create_mp4_result", 0, i, new String[0]);
      if (i == 0)
      {
        long l2 = SystemClock.uptimeMillis();
        ykv.b("take_video", "create_mp4_time", 0, 0, new String[] { "" + (l2 - l1) });
        wcn.a(paramString4, this.mEntry);
      }
      CodecParam.mSaveMode = 0;
      CodecParam.mCRFValue = 23;
      if ((this.mMosaicMask != null) && (this.mMosaicSize != 0)) {
        EncodeVideo.setMosaicData(null, 0);
      }
      return i;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      for (;;)
      {
        int j = -200;
        int i = j;
        if (QLog.isColorLevel())
        {
          QLog.e("startPartEncode", 2, "exception:", paramString1);
          i = j;
        }
      }
    }
  }
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    this.errorCode = 0;
    if (TextUtils.isEmpty(this.mSourceDirString))
    {
      this.errorCode = 5100;
      notifyEncodeEnd(this.errorCode, null);
      QzoneVideoBeaconReport.reportVideoEvent(bczp.a + "", "qzone_video_record", "9", null);
      label67:
      return;
    }
    File localFile = new File(this.mSourceDirString);
    if ((!localFile.exists()) || (!localFile.isDirectory()))
    {
      this.errorCode = 5100;
      notifyEncodeEnd(this.errorCode, null);
      QzoneVideoBeaconReport.reportVideoEvent(bczp.a + "", "qzone_video_record", "9", null);
      return;
    }
    String[] arrayOfString = localFile.list();
    if (arrayOfString == null)
    {
      this.errorCode = 5101;
      if (QLog.isColorLevel()) {
        QLog.d("MaxVideo.Plugin", 2, "EncodeThread empty dir, mSourceDirString = " + this.mSourceDirString);
      }
      notifyEncodeEnd(this.errorCode, null);
      QzoneVideoBeaconReport.reportVideoEvent(bczp.a + "", "qzone_video_record", "9", null);
      return;
    }
    int j = arrayOfString.length;
    String str1 = null;
    Object localObject1 = null;
    Object localObject2 = null;
    int i = 0;
    if (i < j)
    {
      String str2 = arrayOfString[i];
      if (str2.endsWith(".vf"))
      {
        localObject4 = this.mSourceDirString + File.separator + str2;
        localObject3 = localObject1;
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject3;
        localObject2 = localObject4;
        break;
        if (str2.endsWith(".af"))
        {
          localObject3 = this.mSourceDirString + File.separator + str2;
          localObject4 = localObject2;
        }
        else
        {
          localObject3 = localObject1;
          localObject4 = localObject2;
          if (str2.endsWith(".ini"))
          {
            str1 = this.mSourceDirString + File.separator + str2;
            localObject3 = localObject1;
            localObject4 = localObject2;
          }
        }
      }
    }
    if ((!FileUtils.fileExists(localObject2)) || (!FileUtils.fileExists(localObject1)) || (!FileUtils.fileExists(str1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MaxVideo.Plugin", 2, "EncodeThread empty file, mSourceDirString = " + this.mSourceDirString + ",vfFilePath = " + localObject2 + ",afFilePath = " + localObject1 + ",manifestFilePath = " + str1);
      }
      this.errorCode = 5101;
      notifyEncodeEnd(this.errorCode, null);
      QzoneVideoBeaconReport.reportVideoEvent(bczp.a + "", "qzone_video_record", "9", null);
      return;
    }
    if (this.mGenerateGif)
    {
      str1 = QZoneFilePath.DCIM_CAMERA_PATH;
      localObject3 = VidUtil.getVidFromSourceDirFile(localFile);
      localObject4 = new File(str1 + File.separator + "gif");
      if ((((File)localObject4).exists()) && (!((File)localObject4).isDirectory())) {
        ((File)localObject4).delete();
      }
      if (!((File)localObject4).exists()) {
        ((File)localObject4).mkdir();
      }
      str1 = str1 + File.separator + "gif" + File.separator + (String)localObject3 + ".gif";
      l1 = System.currentTimeMillis();
      i = GifProcessor.generateGifFromVFile(localObject2, localObject1, this.mOrientationDegree, str1);
      QLog.i("MaxVideo.Plugin", 1, "generateGifFromVFile cost=" + (System.currentTimeMillis() - l1) + " ret=" + i);
      this.mTargetFilePath = str1;
      if ((i == 0) && (this.mEnableDeleteCache)) {
        FileUtils.deleteDirectory(this.mSourceDirString);
      }
      if (i == 0) {}
      for (i = 0;; i = 5109)
      {
        this.errorCode = i;
        notifyEncodeEnd(this.errorCode, str1);
        return;
      }
    }
    if (this.mEnableClearAudioData) {
      FileUtils.deleteFile(localObject1);
    }
    try
    {
      FileUtils.createFile(localObject1);
      localObject4 = this.mTargetFilePath;
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {
        break label1597;
      }
      localObject3 = QZoneFilePath.DCIM_CAMERA_PATH;
      localObject4 = new File((String)localObject3);
      if ((!((File)localObject4).mkdirs()) && (!((File)localObject4).isDirectory()))
      {
        this.errorCode = 5102;
        notifyEncodeEnd(this.errorCode, null);
        QzoneVideoBeaconReport.reportVideoEvent(bczp.a + "", "qzone_video_record", "10", null);
        return;
      }
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
    Object localObject4 = VidUtil.getVidFromSourceDirFile(localFile);
    Object localObject3 = (String)localObject3 + File.separator + (String)localObject4 + ".mp4";
    this.mTargetFilePath = ((String)localObject3);
    label1024:
    notifyEncodeBegin();
    if (this.mEnableHardEncode) {
      localObject4 = new bdag(localObject2, localIOException, this.mSourceDirString);
    }
    for (;;)
    {
      try
      {
        i = ((bdag)localObject4).a();
        if (i == 0)
        {
          this.mTargetFilePath = ((bdag)localObject4).a();
          boolean bool = FileUtils.fileExistsAndNotEmpty(this.mTargetFilePath);
          if (QLog.isColorLevel()) {
            QLog.d("MaxVideo.Plugin", 2, "EncodeThread hwEncode success, mTargetFilePath = " + this.mTargetFilePath + ", isExist = " + bool);
          }
          QzoneVideoBeaconReport.reportVideoEvent(bczp.a + "", "qzone_video_record", "record_hw_success", "0", null);
          if (QLog.isColorLevel()) {
            QLog.d("MaxVideo.Plugin", 2, "EncodeThread hwEncode serrcode = " + i);
          }
          int k = 0;
          j = i;
          i = k;
          if (QLog.isColorLevel()) {
            QLog.d("MaxVideo.Plugin", 2, "EncodeThread hwEncode start soft errcode = " + j + " mEnableHardEncode=" + this.mEnableHardEncode);
          }
          if (j == -1)
          {
            if (!this.mMuteVoice) {
              continue;
            }
            localObject4 = "";
            i = startEncode(localObject2, (String)localObject4, str1, (String)localObject3);
            QLog.i("MaxVideo.Plugin", 1, "EncodeThread hwEncode start soft over ret = " + i);
            if (i != 0) {
              continue;
            }
            QzoneVideoBeaconReport.reportVideoEvent(bczp.a + "", "qzone_video_record", "record_sw_success", "0", null);
          }
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("vfFilePath is " + localObject2);
            ((StringBuilder)localObject4).append('\n');
            ((StringBuilder)localObject4).append("afFilePath is " + localIOException);
            ((StringBuilder)localObject4).append('\n');
            ((StringBuilder)localObject4).append("manifestFilePath is " + str1);
            ((StringBuilder)localObject4).append('\n');
            ((StringBuilder)localObject4).append("targetFile is " + (String)localObject3);
            QLog.i("MaxVideo.Plugin", 2, ((StringBuilder)localObject4).toString());
          }
          if (i != 0) {
            continue;
          }
          QzoneVideoBeaconReport.reportVideoEvent(bczp.a + "", "qzone_video_record", "record_success", "0", null);
          switch (i)
          {
          default: 
            if (this.errorCode == 5103) {
              break label67;
            }
            notifyEncodeEnd(this.errorCode, (String)localObject3);
            return;
            label1597:
            localFile = new File((String)localObject4).getParentFile();
            localObject3 = localObject4;
            if (localFile == null) {
              break label1024;
            }
            localObject3 = localObject4;
            if (localFile.exists()) {
              break label1024;
            }
            localFile.mkdirs();
            localObject3 = localObject4;
          }
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        localUnsatisfiedLinkError.printStackTrace();
        i = -1;
        continue;
      }
      catch (NoSuchMethodError localNoSuchMethodError)
      {
        localNoSuchMethodError.printStackTrace();
        i = -1;
        continue;
        QzoneVideoBeaconReport.reportVideoEvent(bczp.a + "", "qzone_video_record", "record_hw_success", "1", i + "_" + Build.MODEL);
        continue;
        localObject4 = localIOException;
        continue;
        QzoneVideoBeaconReport.reportVideoEvent(bczp.a + "", "qzone_video_record", "record_sw_success", "1", i + "_" + Build.MODEL);
        continue;
        QzoneVideoBeaconReport.reportVideoEvent(bczp.a + "", "qzone_video_record", "record_success", "1", i + "_" + Build.MODEL);
        continue;
        this.errorCode = 0;
        long l2 = System.currentTimeMillis();
        QLog.i("MaxVideo.Plugin", 1, "encode af vf to mp4, cost=" + (l2 - l1));
        if (!this.mEnableDeleteCache) {
          continue;
        }
        FileUtils.deleteDirectory(this.mSourceDirString);
        QLog.i("MaxVideo.Plugin", 1, "EncodeThread encode success delete cache... cost=" + (System.currentTimeMillis() - l2));
        continue;
        this.errorCode = 5104;
        continue;
        this.errorCode = 5105;
        continue;
        this.errorCode = 5106;
        continue;
        this.errorCode = 5107;
        continue;
        this.errorCode = 5103;
        continue;
      }
      i = 0;
      j = -1;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread
 * JD-Core Version:    0.7.0.1
 */