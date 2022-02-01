package com.tencent.mobileqq.qwallet.hb.emoji.impl;

import android.text.TextUtils;
import com.qwallet.temp.IQwTemp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.emoji.ConvertParam;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EmojiGifHelper$CompositeTask
  implements Runnable
{
  public boolean a = false;
  public ConvertParam b;
  public EmojiGifHelper.OnConvertListener c;
  public EmojiGifHelper.EmojiInfo d;
  
  EmojiGifHelper$CompositeTask(EmojiGifHelper paramEmojiGifHelper, ConvertParam paramConvertParam, EmojiGifHelper.OnConvertListener paramOnConvertListener)
  {
    this.b = paramConvertParam;
    this.c = paramOnConvertListener;
  }
  
  private String b()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(QWalletTools.a());
    ((StringBuilder)localObject1).append("Camera/");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("gif");
    localObject2 = new File(((StringBuilder)localObject2).toString());
    if ((((File)localObject2).exists()) && (!((File)localObject2).isDirectory())) {
      ((File)localObject2).delete();
    }
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdir();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("gif");
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((StringBuilder)localObject2).append(".gif");
    return ((StringBuilder)localObject2).toString();
  }
  
  public void a()
  {
    synchronized (this.d.e)
    {
      this.a = true;
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString, EmojiGifHelper.OnConvertListener arg3, ConvertParam paramConvertParam)
  {
    if (this.a) {
      return;
    }
    if (??? != null) {
      if ((paramBoolean) && (!TextUtils.isEmpty(paramString))) {
        ???.a(true, paramString);
      } else {
        ???.a(false, null);
      }
    }
    if (paramBoolean)
    {
      ??? = this.d;
      if (??? != null) {
        synchronized (???.e)
        {
          if (!this.a)
          {
            this.d.d = paramString;
            if (this.d.f) {
              EmojiGifHelper.a(this.this$0, this.d);
            }
          }
          return;
        }
      }
    }
  }
  
  public boolean a(ConvertParam paramConvertParam, String paramString)
  {
    boolean bool = false;
    try
    {
      int i = ((IQwTemp)QRoute.api(IQwTemp.class)).GifProcessor$convertVideoToGifForLocal(paramConvertParam.inPath, paramConvertParam.videoWidth, paramConvertParam.videoHeight, paramConvertParam.videoDuration, paramString, 7, 30, 100);
      if (QLog.isColorLevel())
      {
        paramConvertParam = new StringBuilder();
        paramConvertParam.append("Video2GifConverter: convert retCode=");
        paramConvertParam.append(i);
        QLog.i("EmojiGifHelper", 2, paramConvertParam.toString());
      }
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable paramConvertParam)
    {
      paramString = new StringBuilder();
      paramString.append("processNotExistVideoData: convert exception");
      paramString.append(paramConvertParam);
      QLog.e("EmojiGifHelper", 2, paramString.toString());
    }
    return false;
  }
  
  public void run()
  {
    if (this.a) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("begin convert gif, publishParam=");
      ((StringBuilder)localObject).append(this.b);
      QLog.i("EmojiGifHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = b();
    long l = System.currentTimeMillis();
    if (this.a) {
      return;
    }
    if (a(this.b, (String)localObject))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("convertVideoToGif finished cost:");
        localStringBuilder.append(System.currentTimeMillis() - l);
        QLog.i("EmojiGifHelper", 2, localStringBuilder.toString());
      }
      a(true, (String)localObject, this.c, this.b);
      return;
    }
    a(false, null, this.c, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.emoji.impl.EmojiGifHelper.CompositeTask
 * JD-Core Version:    0.7.0.1
 */