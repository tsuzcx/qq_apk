package com.tencent.mobileqq.kandian.base.video.compress;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.mediacodec.VideoConverterLog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.VideoConverter;
import java.io.File;

public class VideoCompressTask
  extends AsyncTask<String, Void, Integer>
{
  private long jdField_a_of_type_Long = 0L;
  private Context jdField_a_of_type_AndroidContentContext;
  private VideoCompressTask.VideoCompressTaskListener jdField_a_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoCompressTask$VideoCompressTaskListener;
  private VideoMediaInfo jdField_a_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoMediaInfo;
  private VideoConverter jdField_a_of_type_ComTencentRichmediaVideocompressVideoConverter;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long = 0L;
  private VideoMediaInfo jdField_b_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoMediaInfo;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  public VideoCompressTask(Context paramContext, VideoCompressTask.VideoCompressTaskListener paramVideoCompressTaskListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoCompressTask$VideoCompressTaskListener = paramVideoCompressTaskListener;
  }
  
  private int a(Context paramContext, String paramString1, VideoMediaInfo paramVideoMediaInfo, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressTask", 2, "CompressTask, step: Try to compress using MediaCodec");
    }
    paramVideoMediaInfo = new VideoCompressTask.HWCompressProcessor(this, paramString2, (int)(paramVideoMediaInfo.jdField_b_of_type_Long * 1024L), (int)paramVideoMediaInfo.jdField_a_of_type_Long, 0L, paramVideoMediaInfo.c);
    this.jdField_a_of_type_ComTencentRichmediaVideocompressVideoConverter = new VideoConverter(new VideoConverterLog());
    this.jdField_a_of_type_ComTencentRichmediaVideocompressVideoConverter.setCompressMode(1);
    int i = this.jdField_a_of_type_ComTencentRichmediaVideocompressVideoConverter.startCompress(paramContext, paramString1, paramVideoMediaInfo, true);
    if ((i != 0) && (i != -1002))
    {
      if (i == -3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressTask", 2, "CompressTask, step: compress completed using MediaCodec, api not support");
        }
        return -2;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressTask", 2, "CompressTask, step: compress failed using MediaCodec");
      }
      return -4;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressTask", 2, "CompressTask, step: compress completed using MediaCodec");
    }
    return 0;
  }
  
  protected Integer a(String... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoCompressTask$VideoCompressTaskListener.a(0.0F);
    boolean bool = TextUtils.isEmpty(paramVarArgs);
    Integer localInteger = Integer.valueOf(-1);
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CompressTask failed, error params:");
      ((StringBuilder)localObject).append(paramVarArgs);
      QLog.d("VideoCompressTask", 1, ((StringBuilder)localObject).toString());
      return localInteger;
    }
    if (Build.VERSION.SDK_INT < 18)
    {
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("CompressTask failed, sdk version too low: ");
      paramVarArgs.append(Build.VERSION.SDK_INT);
      QLog.d("VideoCompressTask", 1, paramVarArgs.toString());
      return Integer.valueOf(-2);
    }
    this.jdField_a_of_type_JavaLangString = paramVarArgs;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoMediaInfo = VideoMediaInfo.a(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoMediaInfo == null)
    {
      QLog.e("VideoCompressTask", 1, "CompressTask failed, retrive mSourceMediaInfo failed! ");
      return Integer.valueOf(-3);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CompressTask, step: retrive mSourceMediaInfo = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoMediaInfo);
      QLog.d("VideoCompressTask", 2, ((StringBuilder)localObject).toString());
    }
    if (!VideoCompressUtil.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoMediaInfo))
    {
      QLog.e("VideoCompressTask", 1, "CompressTask failed, no need compress! ");
      return Integer.valueOf(-5);
    }
    long l1 = System.currentTimeMillis();
    Object localObject = new File(VideoCompressUtil.a());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    int i = this.jdField_a_of_type_JavaLangString.lastIndexOf(".");
    if (i == -1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CompressTask failed, error params:");
      ((StringBuilder)localObject).append(paramVarArgs);
      QLog.d("VideoCompressTask", 1, ((StringBuilder)localObject).toString());
      return localInteger;
    }
    this.jdField_b_of_type_JavaLangString = VideoCompressUtil.a(paramVarArgs, paramVarArgs.substring(i + 1));
    i = a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoMediaInfo, this.jdField_b_of_type_JavaLangString);
    if (i == 0) {
      this.jdField_b_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoMediaInfo = VideoMediaInfo.a(this.jdField_b_of_type_JavaLangString);
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("CompressTask run finish! compress ret = ");
      paramVarArgs.append(i);
      paramVarArgs.append(", cost:");
      paramVarArgs.append(l2 - l1);
      paramVarArgs.append("ms, mTargetMdeiaInfo=");
      paramVarArgs.append(this.jdField_b_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoMediaInfo);
      QLog.d("VideoCompressTask", 2, paramVarArgs.toString());
    }
    return Integer.valueOf(i);
  }
  
  public void a()
  {
    cancel(false);
    VideoConverter localVideoConverter = this.jdField_a_of_type_ComTencentRichmediaVideocompressVideoConverter;
    if (localVideoConverter != null) {
      localVideoConverter.cancelCompress();
    }
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    if (isCancelled()) {
      return;
    }
    int j = paramInteger.intValue();
    int i = 2;
    if (j != 0)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("CompressTask, compress failed, errorCode:");
        localStringBuilder.append(paramInteger);
        QLog.e("VideoCompressTask", 2, localStringBuilder.toString());
      }
      if (paramInteger.intValue() != -2) {
        if (paramInteger.intValue() == -3) {
          i = 3;
        } else if (paramInteger.intValue() == -5) {
          i = 1;
        } else {
          i = 4;
        }
      }
      paramInteger = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoCompressTask$VideoCompressTaskListener;
      if (paramInteger != null) {
        paramInteger.a(i, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoMediaInfo);
      }
    }
    else
    {
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        paramInteger = this.jdField_a_of_type_JavaLangString;
      } else {
        paramInteger = this.jdField_b_of_type_JavaLangString;
      }
      this.c = paramInteger;
      long l = new File(this.c).length();
      if (QLog.isColorLevel())
      {
        paramInteger = new StringBuilder();
        paramInteger.append("CompressTask, finalSize:");
        paramInteger.append(l);
        QLog.d("VideoCompressTask", 2, paramInteger.toString());
      }
      if (l > VideoCompressConfig.b())
      {
        paramInteger = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoCompressTask$VideoCompressTaskListener;
        if (paramInteger != null) {
          paramInteger.a(5, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoMediaInfo);
        }
      }
      else
      {
        paramInteger = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoCompressTask$VideoCompressTaskListener;
        if (paramInteger != null) {
          paramInteger.a(0, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoMediaInfo);
        }
      }
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.compress.VideoCompressTask
 * JD-Core Version:    0.7.0.1
 */