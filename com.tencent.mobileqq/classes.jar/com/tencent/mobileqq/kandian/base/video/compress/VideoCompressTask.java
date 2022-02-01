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
  private VideoMediaInfo a;
  private VideoMediaInfo b;
  private Context c;
  private String d;
  private String e;
  private String f;
  private long g = 0L;
  private long h = 0L;
  private VideoCompressTask.VideoCompressTaskListener i;
  private VideoConverter j;
  
  public VideoCompressTask(Context paramContext, VideoCompressTask.VideoCompressTaskListener paramVideoCompressTaskListener)
  {
    this.c = paramContext;
    this.i = paramVideoCompressTaskListener;
  }
  
  private int a(Context paramContext, String paramString1, VideoMediaInfo paramVideoMediaInfo, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressTask", 2, "CompressTask, step: Try to compress using MediaCodec");
    }
    paramVideoMediaInfo = new VideoCompressTask.HWCompressProcessor(this, paramString2, (int)(paramVideoMediaInfo.d * 1024L), (int)paramVideoMediaInfo.c, 0L, paramVideoMediaInfo.f);
    this.j = new VideoConverter(new VideoConverterLog());
    this.j.setCompressMode(1);
    int k = this.j.startCompress(paramContext, paramString1, paramVideoMediaInfo, true);
    if ((k != 0) && (k != -1002))
    {
      if (k == -3)
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
    this.i.a(0.0F);
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
    this.d = paramVarArgs;
    this.a = VideoMediaInfo.a(this.d);
    if (this.a == null)
    {
      QLog.e("VideoCompressTask", 1, "CompressTask failed, retrive mSourceMediaInfo failed! ");
      return Integer.valueOf(-3);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CompressTask, step: retrive mSourceMediaInfo = ");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("VideoCompressTask", 2, ((StringBuilder)localObject).toString());
    }
    if (!VideoCompressUtil.a(this.a))
    {
      QLog.e("VideoCompressTask", 1, "CompressTask failed, no need compress! ");
      return Integer.valueOf(-5);
    }
    long l1 = System.currentTimeMillis();
    Object localObject = new File(VideoCompressUtil.a());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    int k = this.d.lastIndexOf(".");
    if (k == -1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CompressTask failed, error params:");
      ((StringBuilder)localObject).append(paramVarArgs);
      QLog.d("VideoCompressTask", 1, ((StringBuilder)localObject).toString());
      return localInteger;
    }
    this.e = VideoCompressUtil.a(paramVarArgs, paramVarArgs.substring(k + 1));
    k = a(this.c, this.d, this.a, this.e);
    if (k == 0) {
      this.b = VideoMediaInfo.a(this.e);
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("CompressTask run finish! compress ret = ");
      paramVarArgs.append(k);
      paramVarArgs.append(", cost:");
      paramVarArgs.append(l2 - l1);
      paramVarArgs.append("ms, mTargetMdeiaInfo=");
      paramVarArgs.append(this.b);
      QLog.d("VideoCompressTask", 2, paramVarArgs.toString());
    }
    return Integer.valueOf(k);
  }
  
  public void a()
  {
    cancel(false);
    VideoConverter localVideoConverter = this.j;
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
    int m = paramInteger.intValue();
    int k = 2;
    if (m != 0)
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
          k = 3;
        } else if (paramInteger.intValue() == -5) {
          k = 1;
        } else {
          k = 4;
        }
      }
      paramInteger = this.i;
      if (paramInteger != null) {
        paramInteger.a(k, this.d, this.a);
      }
    }
    else
    {
      this.h = System.currentTimeMillis();
      if (TextUtils.isEmpty(this.e)) {
        paramInteger = this.d;
      } else {
        paramInteger = this.e;
      }
      this.f = paramInteger;
      long l = new File(this.f).length();
      if (QLog.isColorLevel())
      {
        paramInteger = new StringBuilder();
        paramInteger.append("CompressTask, finalSize:");
        paramInteger.append(l);
        QLog.d("VideoCompressTask", 2, paramInteger.toString());
      }
      if (l > VideoCompressConfig.b())
      {
        paramInteger = this.i;
        if (paramInteger != null) {
          paramInteger.a(5, this.e, this.b);
        }
      }
      else
      {
        paramInteger = this.i;
        if (paramInteger != null) {
          paramInteger.a(0, this.e, this.b);
        }
      }
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.g = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.compress.VideoCompressTask
 * JD-Core Version:    0.7.0.1
 */