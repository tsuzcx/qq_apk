package dov.com.tencent.mobileqq.shortvideo.mediadevice;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import azds;
import bdcs;
import bjsb;
import bnlx;
import bnme;
import bnmt;
import bnoj;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.maxvideo.MaxVideoConst;
import com.tencent.maxvideo.mediadevice.EncodeVideo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import wta;

public class EncodeThread
  implements MaxVideoConst, Runnable
{
  public int a;
  private long jdField_a_of_type_Long = -1L;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private PublishVideoEntry jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
  private EncodeVideo jdField_a_of_type_ComTencentMaxvideoMediadeviceEncodeVideo;
  public String a;
  protected boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = -1L;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = -1L;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = true;
  private long jdField_d_of_type_Long = -1L;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  
  public EncodeThread(Context paramContext, Handler paramHandler, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_ComTencentMaxvideoMediadeviceEncodeVideo = new EncodeVideo(this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.e = false;
  }
  
  private int a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (this.e) {
      azds.a(this.e);
    }
    int[] arrayOfInt = azds.a();
    azds.a(false);
    if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_c_of_type_Int != 0))
    {
      EncodeVideo localEncodeVideo = this.jdField_a_of_type_ComTencentMaxvideoMediadeviceEncodeVideo;
      EncodeVideo.setMosaicData(this.jdField_a_of_type_ArrayOfByte, this.jdField_c_of_type_Int);
    }
    long l1 = SystemClock.uptimeMillis();
    try
    {
      i = this.jdField_a_of_type_ComTencentMaxvideoMediadeviceEncodeVideo.startPartEncode(paramString1, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, paramString2, this.jdField_c_of_type_Long, this.jdField_d_of_type_Long, paramString3, paramString4, arrayOfInt);
      wta.b("take_video", "create_mp4_result", 0, i, new String[0]);
      if (i == 0)
      {
        long l2 = SystemClock.uptimeMillis();
        wta.b("take_video", "create_mp4_time", 0, 0, new String[] { "" + (l2 - l1) });
      }
      azds.J = 0;
      azds.C = 23;
      if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_c_of_type_Int != 0)) {
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
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    a(localMessage);
  }
  
  private void a(int paramInt, String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    localMessage.arg1 = paramInt;
    localMessage.getData().putString("maxvideo.file.mp4", paramString);
    localMessage.getData().putString("source_path", this.jdField_b_of_type_JavaLangString);
    localMessage.getData().putString("client_key", this.jdField_c_of_type_JavaLangString);
    if ((paramInt == 0) && (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry != null))
    {
      localMessage.getData().putString("key_background_music_path", this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath);
      localMessage.getData().putInt("key_background_music_offset", this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicOffset);
      localMessage.getData().putString("key_doodle_path", this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.doodlePath);
      localMessage.getData().putString("key_local_raw_video_dir", this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.mLocalRawVideoDir);
      localMessage.getData().putInt("key_video_width", this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoWidth);
      localMessage.getData().putInt("key_video_height", this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight);
    }
    a(localMessage);
  }
  
  private void a(Message paramMessage)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {}
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramMessage);
      return;
    }
    catch (Exception paramMessage) {}
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_Int = 0;
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Int = 5100;
      a(this.jdField_a_of_type_Int, null);
      bjsb.a(bnlx.jdField_a_of_type_Long + "", "qzone_video_record", "9", null);
      label65:
      return;
    }
    File localFile = new File(this.jdField_b_of_type_JavaLangString);
    if ((!localFile.exists()) || (!localFile.isDirectory()))
    {
      this.jdField_a_of_type_Int = 5100;
      a(this.jdField_a_of_type_Int, null);
      bjsb.a(bnlx.jdField_a_of_type_Long + "", "qzone_video_record", "9", null);
      return;
    }
    String[] arrayOfString = localFile.list();
    if (arrayOfString == null)
    {
      this.jdField_a_of_type_Int = 5101;
      if (QLog.isColorLevel()) {
        QLog.d("MaxVideo.Plugin", 2, "EncodeThread empty dir, mSourceDirString = " + this.jdField_b_of_type_JavaLangString);
      }
      a(this.jdField_a_of_type_Int, null);
      bjsb.a(bnlx.jdField_a_of_type_Long + "", "qzone_video_record", "9", null);
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
        localObject4 = this.jdField_b_of_type_JavaLangString + File.separator + str2;
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
          localObject3 = this.jdField_b_of_type_JavaLangString + File.separator + str2;
          localObject4 = localObject2;
        }
        else
        {
          localObject3 = localObject1;
          localObject4 = localObject2;
          if (str2.endsWith(".ini"))
          {
            str1 = this.jdField_b_of_type_JavaLangString + File.separator + str2;
            localObject3 = localObject1;
            localObject4 = localObject2;
          }
        }
      }
    }
    if ((!bdcs.a(localObject2)) || (!bdcs.a(localObject1)) || (!bdcs.a(str1)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MaxVideo.Plugin", 2, "EncodeThread empty file, mSourceDirString = " + this.jdField_b_of_type_JavaLangString + ",vfFilePath = " + localObject2 + ",afFilePath = " + localObject1 + ",manifestFilePath = " + str1);
      }
      this.jdField_a_of_type_Int = 5101;
      a(this.jdField_a_of_type_Int, null);
      bjsb.a(bnlx.jdField_a_of_type_Long + "", "qzone_video_record", "9", null);
      return;
    }
    if (this.f)
    {
      str1 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + Environment.DIRECTORY_DCIM + File.separator + "Camera";
      localObject3 = bnoj.a(localFile);
      localObject4 = new File(str1 + File.separator + "gif");
      if ((((File)localObject4).exists()) && (!((File)localObject4).isDirectory())) {
        ((File)localObject4).delete();
      }
      if (!((File)localObject4).exists()) {
        ((File)localObject4).mkdir();
      }
      str1 = str1 + File.separator + "gif" + File.separator + (String)localObject3 + ".gif";
      l1 = System.currentTimeMillis();
      i = bnmt.a(localObject2, localObject1, this.jdField_b_of_type_Int, str1);
      QLog.i("MaxVideo.Plugin", 1, "generateGifFromVFile cost=" + (System.currentTimeMillis() - l1) + " ret=" + i);
      this.jdField_a_of_type_JavaLangString = str1;
      if ((i == 0) && (this.jdField_c_of_type_Boolean)) {
        bdcs.a(this.jdField_b_of_type_JavaLangString);
      }
      if (i == 0) {}
      for (i = 0;; i = 5109)
      {
        this.jdField_a_of_type_Int = i;
        a(this.jdField_a_of_type_Int, str1);
        return;
      }
    }
    if (this.jdField_d_of_type_Boolean) {
      bdcs.d(localObject1);
    }
    try
    {
      bdcs.a(localObject1);
      localObject4 = this.jdField_a_of_type_JavaLangString;
      if (!TextUtils.isEmpty((CharSequence)localObject4)) {
        break label1665;
      }
      localObject3 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + Environment.DIRECTORY_DCIM + File.separator + "Camera";
      localObject4 = new File((String)localObject3);
      if ((!((File)localObject4).mkdirs()) && (!((File)localObject4).isDirectory()))
      {
        this.jdField_a_of_type_Int = 5102;
        a(this.jdField_a_of_type_Int, null);
        bjsb.a(bnlx.jdField_a_of_type_Long + "", "qzone_video_record", "10", null);
        return;
      }
    }
    catch (IOException localIOException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MaxVideo.Plugin", 2, "EncodeThread: createFile audiofile... ", localIOException);
      }
      this.jdField_a_of_type_Int = 5108;
      a(this.jdField_a_of_type_Int, null);
      return;
    }
    Object localObject4 = bnoj.a(localFile);
    Object localObject3 = (String)localObject3 + File.separator + (String)localObject4 + ".mp4";
    this.jdField_a_of_type_JavaLangString = ((String)localObject3);
    label1095:
    a();
    if (this.jdField_b_of_type_Boolean) {
      localObject4 = new bnme(localObject2, localIOException, this.jdField_b_of_type_JavaLangString);
    }
    for (;;)
    {
      try
      {
        i = ((bnme)localObject4).a();
        if (i == 0)
        {
          this.jdField_a_of_type_JavaLangString = ((bnme)localObject4).a();
          boolean bool = bdcs.b(this.jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d("MaxVideo.Plugin", 2, "EncodeThread hwEncode success, mTargetFilePath = " + this.jdField_a_of_type_JavaLangString + ", isExist = " + bool);
          }
          bjsb.a(bnlx.jdField_a_of_type_Long + "", "qzone_video_record", "record_hw_success", "0", null);
          if (QLog.isColorLevel()) {
            QLog.d("MaxVideo.Plugin", 2, "EncodeThread hwEncode serrcode = " + i);
          }
          int k = 0;
          j = i;
          i = k;
          if (QLog.isColorLevel()) {
            QLog.d("MaxVideo.Plugin", 2, "EncodeThread hwEncode start soft errcode = " + j + " mEnableHardEncode=" + this.jdField_b_of_type_Boolean);
          }
          if (j == -1)
          {
            if (!this.jdField_a_of_type_Boolean) {
              continue;
            }
            localObject4 = "";
            i = a(localObject2, (String)localObject4, str1, (String)localObject3);
            QLog.i("MaxVideo.Plugin", 1, "EncodeThread hwEncode start soft over ret = " + i);
            if (i != 0) {
              continue;
            }
            bjsb.a(bnlx.jdField_a_of_type_Long + "", "qzone_video_record", "record_sw_success", "0", null);
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
          bjsb.a(bnlx.jdField_a_of_type_Long + "", "qzone_video_record", "record_success", "0", null);
          switch (i)
          {
          default: 
            if (this.jdField_a_of_type_Int == 5103) {
              break label65;
            }
            a(this.jdField_a_of_type_Int, (String)localObject3);
            return;
            label1665:
            localFile = new File((String)localObject4).getParentFile();
            localObject3 = localObject4;
            if (localFile == null) {
              break label1095;
            }
            localObject3 = localObject4;
            if (localFile.exists()) {
              break label1095;
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
        bjsb.a(bnlx.jdField_a_of_type_Long + "", "qzone_video_record", "record_hw_success", "1", i + "_" + Build.MODEL);
        continue;
        localObject4 = localIOException;
        continue;
        bjsb.a(bnlx.jdField_a_of_type_Long + "", "qzone_video_record", "record_sw_success", "1", i + "_" + Build.MODEL);
        continue;
        bjsb.a(bnlx.jdField_a_of_type_Long + "", "qzone_video_record", "record_success", "1", i + "_" + Build.MODEL);
        continue;
        this.jdField_a_of_type_Int = 0;
        long l2 = System.currentTimeMillis();
        QLog.i("MaxVideo.Plugin", 1, "encode af vf to mp4, cost=" + (l2 - l1));
        if (!this.jdField_c_of_type_Boolean) {
          continue;
        }
        bdcs.a(this.jdField_b_of_type_JavaLangString);
        QLog.i("MaxVideo.Plugin", 1, "EncodeThread encode success delete cache... cost=" + (System.currentTimeMillis() - l2));
        continue;
        this.jdField_a_of_type_Int = 5104;
        continue;
        this.jdField_a_of_type_Int = 5105;
        continue;
        this.jdField_a_of_type_Int = 5106;
        continue;
        this.jdField_a_of_type_Int = 5107;
        continue;
        this.jdField_a_of_type_Int = 5103;
        continue;
      }
      i = 0;
      j = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread
 * JD-Core Version:    0.7.0.1
 */