package com.tencent.mobileqq.kandian.biz.ugc.video;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.mediacodec.VideoConverterLog;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.VideoConverter;
import com.tencent.richmedia.videocompress.VideoConverter.Processor;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import java.io.File;
import java.util.HashMap;

public class VideoCompressTask
  extends AsyncTask<String, Void, Integer>
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  VideoCompressTask.VideoCompressTaskListener jdField_a_of_type_ComTencentMobileqqKandianBizUgcVideoVideoCompressTask$VideoCompressTaskListener;
  private Long jdField_a_of_type_JavaLangLong;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private Long jdField_b_of_type_JavaLangLong;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private Long jdField_c_of_type_JavaLangLong;
  private String jdField_c_of_type_JavaLangString;
  private Long jdField_d_of_type_JavaLangLong;
  private String jdField_d_of_type_JavaLangString;
  
  public VideoCompressTask(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, VideoCompressTask.VideoCompressTaskListener paramVideoCompressTaskListener)
  {
    Long localLong = Long.valueOf(0L);
    this.jdField_a_of_type_JavaLangLong = localLong;
    this.jdField_b_of_type_JavaLangLong = localLong;
    this.jdField_c_of_type_JavaLangLong = localLong;
    this.jdField_d_of_type_JavaLangLong = localLong;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcVideoVideoCompressTask$VideoCompressTaskListener = paramVideoCompressTaskListener;
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 <= paramInt2) {
      i = paramInt2;
    }
    paramInt2 = ReadInJoyConstants.jdField_a_of_type_Int;
    paramInt1 = ReadInJoyHelper.p(BaseApplicationImpl.getApplication().getRuntime());
    if (paramInt1 > 0) {
      paramInt2 = paramInt1;
    }
    paramInt1 = 960;
    if (i >= 1280) {
      paramInt1 = 1280;
    } else if (i < 960) {
      paramInt1 = 640;
    }
    return (int)(paramInt2 * 1.0F / 640.0F * paramInt1);
  }
  
  @NonNull
  private Integer a(String paramString, long paramLong)
  {
    int i = paramString.lastIndexOf(".");
    Object localObject = Integer.valueOf(-1);
    if (i == -1) {
      return localObject;
    }
    this.jdField_b_of_type_JavaLangString = ShortVideoUtils.getShortVideoCompressPath(paramString, paramString.substring(i + 1));
    HashMap localHashMap = a(paramString, this.jdField_a_of_type_AndroidContentContext);
    if (localHashMap == null)
    {
      QLog.e("ReadInJoyUploadVideoCompressTask", 1, "dealAfterInit return for compressResult is null.");
      return localObject;
    }
    i = Integer.parseInt((String)localHashMap.get("ret"));
    this.jdField_b_of_type_JavaLangString = ((String)localHashMap.get("outputPath"));
    this.jdField_a_of_type_Int = Integer.parseInt((String)localHashMap.get("outWidth"));
    this.jdField_b_of_type_Int = Integer.parseInt((String)localHashMap.get("outHeight"));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Before Compress file:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", after Compress file:");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
      QLog.d("ReadInJoyUploadVideoCompressTask", 2, ((StringBuilder)localObject).toString());
    }
    long l2 = System.currentTimeMillis();
    long l3 = new File(paramString).length();
    long l1 = 0L;
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      l1 = new File(this.jdField_b_of_type_JavaLangString).length();
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("CompressTask，step: ShortVideoTrimmer compress ret = ");
      paramString.append(i);
      paramString.append(", cost:");
      paramString.append(l2 - paramLong);
      paramString.append("ms, fileSourceSize=");
      paramString.append(l3);
      paramString.append(", fileTargetSize=");
      paramString.append(l1);
      QLog.d("ReadInJoyUploadVideoCompressTask", 2, paramString.toString());
    }
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(l3);
    this.jdField_b_of_type_JavaLangLong = Long.valueOf(l1);
    return Integer.valueOf(i);
  }
  
  @NonNull
  private Integer a(String paramString, File paramFile, VideoConverterConfig paramVideoConverterConfig)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", size:");
      localStringBuilder.append(paramFile.length());
      localStringBuilder.append(", no need compress");
      QLog.d("ReadInJoyUploadVideoCompressTask", 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    if (paramVideoConverterConfig != null) {
      a(paramString, paramVideoConverterConfig);
    }
    return Integer.valueOf(0);
  }
  
  private HashMap<String, String> a(String paramString, Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    String str = ShortVideoUtils.getShortVideoCompressPath(paramString, paramString.substring(paramString.lastIndexOf(".") + 1));
    VideoConverterConfig localVideoConverterConfig = ShortVideoTrimmer.getCompressConfig(paramString);
    if (localVideoConverterConfig == null)
    {
      QLog.e("ReadInJoyUploadVideoCompressTask", 1, "compressPosition, config = null");
      return null;
    }
    a(localVideoConverterConfig, paramString);
    boolean bool = localVideoConverterConfig.isNeedCompress;
    int j = 0;
    int i = 0;
    Object localObject1;
    if (bool)
    {
      if (Build.VERSION.SDK_INT >= 18)
      {
        MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
        localMediaMetadataRetriever.setDataSource(paramString);
        Object localObject2 = localMediaMetadataRetriever.extractMetadata(9);
        localMediaMetadataRetriever.release();
        long l;
        try
        {
          l = Long.parseLong((String)localObject2);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          QLog.e("ReadInJoyUploadVideoCompressTask", 1, "compressPosition", localNumberFormatException);
          l = 0L;
        }
        localObject1 = new VideoCompressTask.HWCompressProcessor(this, str, (int)(localVideoConverterConfig.srcBitrate * 1024L), (int)localVideoConverterConfig.srcFrameRate, 0L, l);
        localObject2 = new VideoConverter(new VideoConverterLog());
        ((VideoConverter)localObject2).setCompressMode(1);
        j = ((VideoConverter)localObject2).startCompress(paramContext, paramString, (VideoConverter.Processor)localObject1, true);
        if (j == 0)
        {
          if (QLog.isColorLevel())
          {
            QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, step: compress completed using MediaCodec");
            break label272;
          }
          break label272;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("CompressTask, step: compress failed using MediaCodec， compressRet:");
          ((StringBuilder)localObject1).append(j);
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, ((StringBuilder)localObject1).toString());
        }
      }
      i = -1;
      label272:
      localObject1 = str;
      j = i;
      if (i != 0)
      {
        localObject1 = str;
        j = i;
        if (!TextUtils.isEmpty(str))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, step: Try to compress using ShortVideoTrimmer.compressVideo");
          }
          j = ShortVideoTrimmer.compressVideo(paramContext, paramString, str, localVideoConverterConfig);
          localObject1 = str;
        }
      }
    }
    else
    {
      localObject1 = paramString;
    }
    localHashMap.put("outputPath", localObject1);
    localHashMap.put("ret", String.valueOf(j));
    if (a(localVideoConverterConfig, paramString))
    {
      localHashMap.put("outWidth", String.valueOf(localVideoConverterConfig.destHeight));
      localHashMap.put("outHeight", String.valueOf(localVideoConverterConfig.destWidth));
      return localHashMap;
    }
    localHashMap.put("outWidth", String.valueOf(localVideoConverterConfig.destWidth));
    localHashMap.put("outHeight", String.valueOf(localVideoConverterConfig.destHeight));
    return localHashMap;
  }
  
  private void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH);
    ((StringBuilder)localObject).append("shortvideo");
    localObject = new File(((StringBuilder)localObject).toString());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
  }
  
  private void a(int paramInt)
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    localHashMap.put("video_size_before_compression", this.jdField_a_of_type_JavaLangLong.toString());
    localHashMap.put("source_video_bitrate", this.jdField_c_of_type_JavaLangLong.toString());
    localHashMap.put("target_video_bitrate", this.jdField_d_of_type_JavaLangLong.toString());
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(this.jdField_a_of_type_AndroidContentContext);
    String str = RIJQQAppInterfaceUtil.a();
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localStatisticCollector.collectPerformance(str, "actReadInJoyDeliverVideoCompressVideo", bool, this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, 0L, localHashMap, "");
  }
  
  private static void a(VideoConverterConfig paramVideoConverterConfig, String paramString)
  {
    if ((paramVideoConverterConfig != null) && (paramVideoConverterConfig.isNeedCompress))
    {
      long l = new File(paramString).length();
      int i = a(paramVideoConverterConfig.srcWidth, paramVideoConverterConfig.srcHeight);
      if ((l <= 52428800L) && (i > 0) && (paramVideoConverterConfig.srcBitrate * 1024L / i < 1.3D))
      {
        paramVideoConverterConfig.isNeedCompress = false;
        if (QLog.isColorLevel())
        {
          paramVideoConverterConfig = new StringBuilder();
          paramVideoConverterConfig.append("CompressTask, fileSize:");
          paramVideoConverterConfig.append(l);
          paramVideoConverterConfig.append(", no need compress!");
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, paramVideoConverterConfig.toString());
        }
      }
    }
  }
  
  private void a(String paramString, VideoConverterConfig paramVideoConverterConfig)
  {
    boolean bool = "90".equals(paramVideoConverterConfig.rotate);
    int j = 1;
    int i = j;
    if (!bool) {
      if ("270".equals(paramVideoConverterConfig.rotate))
      {
        i = j;
      }
      else
      {
        if ("0".equals(paramVideoConverterConfig.rotate))
        {
          paramString = ShortVideoTrimmer.getVideoProperty(paramString);
          if ((paramString != null) && (paramString.length == 5))
          {
            i = j;
            if (paramString[3] == 90) {
              break label98;
            }
            if (paramString[3] == 270)
            {
              i = j;
              break label98;
            }
          }
        }
        i = 0;
      }
    }
    label98:
    if (i != 0)
    {
      this.jdField_a_of_type_Int = paramVideoConverterConfig.srcHeight;
      this.jdField_b_of_type_Int = paramVideoConverterConfig.srcWidth;
      return;
    }
    this.jdField_a_of_type_Int = paramVideoConverterConfig.srcWidth;
    this.jdField_b_of_type_Int = paramVideoConverterConfig.srcHeight;
  }
  
  private static boolean a(VideoConverterConfig paramVideoConverterConfig, String paramString)
  {
    boolean bool3 = "90".equals(paramVideoConverterConfig.rotate);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!bool3)
    {
      if ("270".equals(paramVideoConverterConfig.rotate)) {
        return true;
      }
      if ("0".equals(paramVideoConverterConfig.rotate))
      {
        paramVideoConverterConfig = ShortVideoTrimmer.getVideoProperty(paramString);
        if ((paramVideoConverterConfig != null) && (paramVideoConverterConfig.length == 5))
        {
          bool1 = bool2;
          if (paramVideoConverterConfig[3] == 90) {
            return bool1;
          }
          if (paramVideoConverterConfig[3] == 270) {
            return true;
          }
        }
      }
      bool1 = false;
    }
    return bool1;
  }
  
  private boolean a(boolean paramBoolean, VideoConverterConfig paramVideoConverterConfig)
  {
    int i = a(paramVideoConverterConfig.srcWidth, paramVideoConverterConfig.srcHeight);
    this.jdField_c_of_type_JavaLangLong = Long.valueOf(paramVideoConverterConfig.srcBitrate);
    long l = i;
    this.jdField_d_of_type_JavaLangLong = Long.valueOf(l);
    boolean bool = paramBoolean;
    if (i > 0)
    {
      bool = paramBoolean;
      if (paramVideoConverterConfig.srcBitrate * 1024L / l > 1.3D) {
        bool = true;
      }
    }
    return bool;
  }
  
  protected Integer a(String... paramVarArgs)
  {
    boolean bool1 = false;
    paramVarArgs = paramVarArgs[0];
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcVideoVideoCompressTask$VideoCompressTaskListener.a(0.0F);
    boolean bool2 = TextUtils.isEmpty(paramVarArgs);
    Integer localInteger = Integer.valueOf(-1);
    if ((!bool2) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      this.jdField_a_of_type_JavaLangString = paramVarArgs;
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      VideoConverterConfig localVideoConverterConfig = ShortVideoTrimmer.getCompressConfig(this.jdField_a_of_type_JavaLangString);
      if (localVideoConverterConfig != null) {
        bool1 = a(false, localVideoConverterConfig);
      }
      if ((localFile.exists()) && (localFile.length() <= 52428800L) && (!bool1)) {
        return a(paramVarArgs, localFile, localVideoConverterConfig);
      }
      a();
      long l = System.currentTimeMillis();
      if (ShortVideoTrimmer.initVideoTrim(this.jdField_a_of_type_AndroidContentContext)) {
        return a(paramVarArgs, l);
      }
      return localInteger;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyUploadVideoCompressTask", 2, "error params");
    }
    return localInteger;
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    if (isCancelled()) {
      return;
    }
    int i = paramInteger.intValue();
    int j = 1004;
    if (i != 0)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, not support shortvideo so");
        }
        paramInteger = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcVideoVideoCompressTask$VideoCompressTaskListener;
        i = j;
        if (paramInteger != null)
        {
          paramInteger.a(1, this.jdField_a_of_type_JavaLangLong.longValue(), this.jdField_b_of_type_JavaLangLong.longValue(), null, null, 0L);
          i = j;
        }
      }
      else if (!this.jdField_b_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, "CompressTask, shortvideo so not ready");
        }
        paramInteger = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcVideoVideoCompressTask$VideoCompressTaskListener;
        i = j;
        if (paramInteger != null)
        {
          paramInteger.a(2, this.jdField_a_of_type_JavaLangLong.longValue(), this.jdField_b_of_type_JavaLangLong.longValue(), null, null, 0L);
          i = j;
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("CompressTask, compress failed, errorCode:");
          localStringBuilder.append(paramInteger);
          QLog.d("ReadInJoyUploadVideoCompressTask", 2, localStringBuilder.toString());
        }
        paramInteger = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcVideoVideoCompressTask$VideoCompressTaskListener;
        i = j;
        if (paramInteger != null)
        {
          paramInteger.a(3, this.jdField_a_of_type_JavaLangLong.longValue(), this.jdField_b_of_type_JavaLangLong.longValue(), null, null, 0L);
          i = j;
        }
      }
    }
    else
    {
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        paramInteger = this.jdField_a_of_type_JavaLangString;
      } else {
        paramInteger = this.jdField_b_of_type_JavaLangString;
      }
      this.jdField_c_of_type_JavaLangString = paramInteger;
      paramInteger = MD5.getFileMd5(this.jdField_c_of_type_JavaLangString);
      if (paramInteger != null) {
        this.jdField_d_of_type_JavaLangString = new String(paramInteger);
      }
      long l = new File(this.jdField_c_of_type_JavaLangString).length();
      if (QLog.isColorLevel())
      {
        paramInteger = new StringBuilder();
        paramInteger.append("CompressTask, finalSize:");
        paramInteger.append(l);
        QLog.d("ReadInJoyUploadVideoCompressTask", 2, paramInteger.toString());
      }
      if (l > 314572800L)
      {
        paramInteger = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcVideoVideoCompressTask$VideoCompressTaskListener;
        if (paramInteger != null) {
          paramInteger.a(4, this.jdField_a_of_type_JavaLangLong.longValue(), this.jdField_b_of_type_JavaLangLong.longValue(), this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangLong.longValue());
        }
        i = 1005;
      }
      else
      {
        paramInteger = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcVideoVideoCompressTask$VideoCompressTaskListener;
        if (paramInteger != null) {
          paramInteger.a(0, this.jdField_a_of_type_JavaLangLong.longValue(), this.jdField_b_of_type_JavaLangLong.longValue(), this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, this.jdField_d_of_type_JavaLangLong.longValue());
        }
        i = 0;
      }
    }
    a(i);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.video.VideoCompressTask
 * JD-Core Version:    0.7.0.1
 */