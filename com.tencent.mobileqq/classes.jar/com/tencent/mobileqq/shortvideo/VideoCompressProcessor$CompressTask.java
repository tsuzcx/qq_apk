package com.tencent.mobileqq.shortvideo;

import android.content.Context;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.shortvideo.ProgressiveUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.shortvideo.mediacodec.VideoConverterLog;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmedia.videocompress.VideoConverter;
import com.tencent.richmedia.videocompress.VideoConverter.Processor;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import com.tencent.util.UiThreadUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class VideoCompressProcessor$CompressTask
  extends AsyncTask<Void, Void, Integer>
{
  public MessageForShortVideo a;
  private long b;
  private VideoConverter c;
  private String d;
  private WeakReference<QQAppInterface> e;
  private VideoCompressProcessor.CompressUpdateListener f;
  private WeakReference<Context> g;
  private String h;
  private String i;
  private boolean j = false;
  private boolean k = false;
  
  public VideoCompressProcessor$CompressTask(QQAppInterface paramQQAppInterface, Context paramContext, MessageForShortVideo paramMessageForShortVideo, VideoCompressProcessor.CompressUpdateListener paramCompressUpdateListener)
  {
    this.e = new WeakReference(paramQQAppInterface);
    this.g = new WeakReference(paramContext);
    this.f = paramCompressUpdateListener;
    this.a = paramMessageForShortVideo;
    this.d = this.a.videoFileName;
    paramMessageForShortVideo.videoFileStatus = 998;
    try
    {
      paramMessageForShortVideo.serial();
      paramQQAppInterface.getMessageFacade().a(paramMessageForShortVideo.frienduin, paramMessageForShortVideo.istroop, paramMessageForShortVideo.uniseq, paramMessageForShortVideo.msgData);
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("VideoCompressProcessor", 1, "CompressTask Init", paramQQAppInterface);
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("CompressTask, step: messageForShortVideo info uniseq=");
      paramQQAppInterface.append(this.a.uniseq);
      paramQQAppInterface.append(", OriPath:");
      paramQQAppInterface.append(this.d);
      QLog.d("VideoCompressProcessor", 2, paramQQAppInterface.toString());
    }
  }
  
  private int a(String paramString1, String paramString2)
  {
    long l3 = System.currentTimeMillis();
    Object localObject1 = VideoCompressConfig.a((QQAppInterface)this.e.get());
    VideoCompressConfig.VideoInfo localVideoInfo = VideoCompressConfig.a(paramString1);
    VideoCompressProcessor.a(localVideoInfo);
    boolean bool = VideoCompressConfig.a(localVideoInfo, (VideoCompressConfig.ManageConfig)localObject1);
    this.k = bool;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("CompressTask, isNeedCompress = ");
      ((StringBuilder)localObject2).append(bool);
      QLog.d("VideoCompressProcessor", 1, ((StringBuilder)localObject2).toString());
    }
    if (this.f != null) {
      UiThreadUtil.a(new VideoCompressProcessor.CompressTask.1(this, bool));
    }
    int n = -1;
    if (!bool) {
      return -1;
    }
    localObject1 = VideoCompressConfig.a(localVideoInfo, (VideoCompressConfig.ManageConfig)localObject1, this.a.sendRawVideo);
    Object localObject2 = new VideoCompressProcessor.HWCompressProcessor(this.e, paramString1, paramString2, (VideoCompressConfig.CompressInfo)localObject1, new VideoCompressProcessor.CompressTask.2(this));
    this.c = new VideoConverter(new VideoConverterLog());
    this.c.setCompressMode(1);
    int m = this.c.startCompress((Context)this.g.get(), paramString1, (VideoConverter.Processor)localObject2, true);
    if ((m != 0) && (m != -1002))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "CompressTask, step: compress failed by MediaCodec");
      }
      localObject2 = this.f;
      if (localObject2 != null) {
        ((VideoCompressProcessor.CompressUpdateListener)localObject2).a(this.a, 1.0F);
      }
      m = n;
      if (QLog.isColorLevel())
      {
        QLog.d("VideoCompressProcessor", 2, "不支持硬件压缩，不管软件压缩成功或失败，均默认展示完整呼吸圈");
        m = n;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "CompressTask, step: compress completed by MediaCodec");
      }
      m = 0;
    }
    if (m != 0) {
      if (ShortVideoTrimmer.initVideoTrim((Context)this.g.get()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressProcessor", 2, "CompressTask, step: Try to compress by ShortVideoTrimmer.compressVideo");
        }
        localObject2 = new VideoConverterConfig();
        ((VideoConverterConfig)localObject2).isNeedCompress = true;
        ((VideoConverterConfig)localObject2).rotate = String.valueOf(localVideoInfo.d);
        ((VideoConverterConfig)localObject2).srcWidth = localVideoInfo.b;
        ((VideoConverterConfig)localObject2).srcHeight = localVideoInfo.c;
        ((VideoConverterConfig)localObject2).destWidth = ((VideoCompressConfig.CompressInfo)localObject1).a;
        ((VideoConverterConfig)localObject2).destHeight = ((VideoCompressConfig.CompressInfo)localObject1).b;
        ((VideoConverterConfig)localObject2).destQmax = 25;
        ((VideoConverterConfig)localObject2).videoFrameRate = ((int)((VideoCompressConfig.CompressInfo)localObject1).d);
        ((VideoConverterConfig)localObject2).videoBitRate = ((int)(((VideoCompressConfig.CompressInfo)localObject1).c / 1024L));
        m = ShortVideoTrimmer.compressVideo((Context)this.g.get(), paramString1, paramString2, (VideoConverterConfig)localObject2);
        if (m == 0)
        {
          QLog.d("VideoCompressProcessor", 1, "CompressTask, step:compress completed by ShortVideoTrimmer.compressVideo");
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("CompressTask, step:compress failed using ShortVideoTrimmer.compressVideo, ret = ");
          ((StringBuilder)localObject2).append(m);
          QLog.d("VideoCompressProcessor", 1, ((StringBuilder)localObject2).toString());
        }
      }
      else
      {
        this.i = this.a.videoFileName;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("CompressTask，step: ShortVideoTrimmer init failure, ignore compress, uniseq=");
        ((StringBuilder)localObject2).append(this.a.uniseq);
        QLog.e("VideoCompressProcessor", 2, ((StringBuilder)localObject2).toString());
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "initVideoTrimError", true, 0L, 0L, null, "", false);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("CompressTask，step: ShortVideoTrimmer compress retCode=");
      ((StringBuilder)localObject2).append(m);
      ((StringBuilder)localObject2).append(", uni=");
      ((StringBuilder)localObject2).append(this.a.uniseq);
      QLog.d("VideoCompressProcessor", 2, ((StringBuilder)localObject2).toString());
    }
    if (m != 0) {
      paramString2 = this.a.videoFileName;
    }
    this.i = paramString2;
    long l1 = new File(paramString1).length();
    long l2 = new File(this.i).length();
    l3 = System.currentTimeMillis() - l3;
    if (m == 0) {
      bool = true;
    } else {
      bool = false;
    }
    VideoCompressProcessor.a(bool, l3, localVideoInfo, (VideoCompressConfig.CompressInfo)localObject1, l2);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("CompressTask，step: ShortVideoTrimmer compress, cost:");
      paramString1.append(l3);
      paramString1.append("ms, fileSourceSize=");
      paramString1.append(l1);
      paramString1.append(", fileTargetSize=");
      paramString1.append(l2);
      paramString1.append(", uniseq=");
      paramString1.append(this.a.uniseq);
      QLog.d("VideoCompressProcessor", 2, paramString1.toString());
    }
    return m;
  }
  
  private String d()
  {
    Object localObject = this.a;
    if (localObject != null) {
      localObject = String.valueOf(((MessageForShortVideo)localObject).uniseq);
    } else {
      localObject = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uniseq = ");
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    paramVarArgs = this.g;
    if ((paramVarArgs != null) && (paramVarArgs.get() != null))
    {
      paramVarArgs = this.a;
      if (paramVarArgs != null)
      {
        if (!TextUtils.isEmpty(paramVarArgs.md5))
        {
          if (QLog.isColorLevel())
          {
            paramVarArgs = new StringBuilder();
            paramVarArgs.append("CompressTask, step: Md5 not null, Compressed has been done, uniseq=");
            paramVarArgs.append(this.a.uniseq);
            QLog.d("VideoCompressProcessor", 2, paramVarArgs.toString());
          }
          return Integer.valueOf(5);
        }
        if ((!TextUtils.isEmpty(this.a.videoFileName)) && (FileUtils.fileExistsAndNotEmpty(this.a.videoFileName)))
        {
          this.d = this.a.videoFileName;
          Object localObject2 = this.a.videoFileName;
          Object localObject1 = ShortVideoUtils.getShortVideoCompressPath((String)localObject2, "mp4");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            return Integer.valueOf(5);
          }
          boolean bool2;
          boolean bool1;
          if (this.a.sendRawVideo)
          {
            paramVarArgs = ShortVideoUtils.getShortVideoRawCompressPath((String)localObject2, "mp4");
            l1 = new File((String)localObject2).length();
            bool2 = false;
            if (l1 >= 104345600L) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            this.j = bool1;
            bool1 = bool2;
            if (Build.VERSION.SDK_INT >= 16) {
              bool1 = ShortVideoUtils.isH265FormatShortVideo(this.d);
            }
            if (bool1) {
              this.j = true;
            }
            localObject1 = paramVarArgs;
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("CompressTask, step: Compressed sendRawVideo, uniseq:");
              ((StringBuilder)localObject1).append(this.a.uniseq);
              ((StringBuilder)localObject1).append(", mRawCompress:");
              ((StringBuilder)localObject1).append(this.j);
              ((StringBuilder)localObject1).append(", output:");
              ((StringBuilder)localObject1).append(paramVarArgs);
              ((StringBuilder)localObject1).append(", isH265:");
              ((StringBuilder)localObject1).append(bool1);
              ((StringBuilder)localObject1).append(", size:");
              ((StringBuilder)localObject1).append(l1);
              QLog.d("VideoCompressProcessor", 2, ((StringBuilder)localObject1).toString());
              localObject1 = paramVarArgs;
            }
          }
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            return Integer.valueOf(5);
          }
          if ((this.a.sendRawVideo) && (!this.j))
          {
            this.i = this.a.videoFileName;
            if (QLog.isColorLevel())
            {
              paramVarArgs = new StringBuilder();
              paramVarArgs.append("CompressTask, step: Compressed sendRawVideo, uniseq:");
              paramVarArgs.append(this.a.uniseq);
              QLog.d("VideoCompressProcessor", 2, paramVarArgs.toString());
            }
            paramVarArgs = this.f;
            if (paramVarArgs != null) {
              paramVarArgs.a(this.a, 1.0F);
            }
          }
          else
          {
            if (!FileUtils.fileExistsAndNotEmpty((String)localObject1)) {
              break label568;
            }
            this.i = ((String)localObject1);
            paramVarArgs = new StringBuilder();
            paramVarArgs.append("CompressTask, step: Compressed file has exists, videoPath:");
            paramVarArgs.append((String)localObject1);
            paramVarArgs.append(", uniseq=");
            paramVarArgs.append(this.a.uniseq);
            QLog.d("VideoCompressProcessor", 1, paramVarArgs.toString());
            paramVarArgs = this.f;
            if (paramVarArgs != null) {
              paramVarArgs.a(this.a, 1.0F);
            }
          }
          break label763;
          label568:
          int m = a((String)localObject2, (String)localObject1);
          long l1 = new File((String)localObject2).length();
          long l2 = new File((String)localObject1).length();
          if (QLog.isColorLevel())
          {
            paramVarArgs = new StringBuilder();
            paramVarArgs.append("CompressTask，step: ShortVideoTrimmer Over fileSourceSize=");
            paramVarArgs.append(l1);
            paramVarArgs.append(", fileTargetSize=");
            paramVarArgs.append(l2);
            paramVarArgs.append(", uniseq=");
            paramVarArgs.append(this.a.uniseq);
            paramVarArgs.append(", videoInput=");
            paramVarArgs.append((String)localObject2);
            paramVarArgs.append(", mVideoPath=");
            paramVarArgs.append(this.i);
            QLog.d("VideoCompressProcessor", 2, paramVarArgs.toString());
          }
          if (m == 0)
          {
            if (l2 > l1)
            {
              FileUtils.deleteFile((String)localObject1);
              this.i = this.a.videoFileName;
            }
            else
            {
              this.i = ((String)localObject1);
            }
          }
          else {
            this.i = this.a.videoFileName;
          }
          label763:
          if (isCancelled()) {
            return Integer.valueOf(11);
          }
          if (QLog.isColorLevel())
          {
            paramVarArgs = new StringBuilder();
            paramVarArgs.append("CompressTask, step: after compress, mVideoPath = ");
            paramVarArgs.append(this.i);
            paramVarArgs.append(", videoInput = ");
            paramVarArgs.append((String)localObject2);
            paramVarArgs.append(", uniseq=");
            paramVarArgs.append(this.a.uniseq);
            QLog.d("VideoCompressProcessor", 2, paramVarArgs.toString());
          }
          if ((!TextUtils.isEmpty(this.i)) && (FileUtils.fileExistsAndNotEmpty(this.i)))
          {
            paramVarArgs = new File(this.i);
            if (ShortVideoUtils.isSupportProgressive(paramVarArgs))
            {
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("CompressTask, step: supportProgressive, uniseq=");
                ((StringBuilder)localObject1).append(this.a.uniseq);
                QLog.d("VideoCompressProcessor", 2, ((StringBuilder)localObject1).toString());
              }
              this.a.supportProgressive = true;
              localObject2 = paramVarArgs;
            }
            else
            {
              bool1 = ProgressiveUtils.a.get();
              localObject2 = paramVarArgs;
              if (bool1)
              {
                bool2 = ShortVideoUtils.moveMoovAtom(this.i, (String)localObject1);
                if (bool2)
                {
                  this.i = ((String)localObject1);
                  paramVarArgs = new File(this.i);
                }
                if (QLog.isColorLevel())
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("CompressTask, step: not supportProgressive => moveMoovAtom, result = ");
                  ((StringBuilder)localObject1).append(bool2);
                  ((StringBuilder)localObject1).append(", uniseq=");
                  ((StringBuilder)localObject1).append(this.a.uniseq);
                  ((StringBuilder)localObject1).append(", enableProgressive = ");
                  ((StringBuilder)localObject1).append(bool1);
                  QLog.d("VideoCompressProcessor", 2, ((StringBuilder)localObject1).toString());
                }
                this.a.supportProgressive = bool2;
                localObject2 = paramVarArgs;
              }
            }
            this.b = ((File)localObject2).length();
            try
            {
              this.h = HexUtil.bytes2HexStr(MD5.toMD5Byte(new FileInputStream((File)localObject2), this.b));
            }
            catch (Exception paramVarArgs)
            {
              if (QLog.isColorLevel()) {
                QLog.e("VideoCompressProcessor", 2, "", paramVarArgs);
              }
            }
            catch (FileNotFoundException paramVarArgs)
            {
              paramVarArgs.printStackTrace();
            }
            if (TextUtils.isEmpty(this.h))
            {
              if (QLog.isColorLevel())
              {
                paramVarArgs = new StringBuilder();
                paramVarArgs.append("CompressTask, step: after compress, mVideoMd5 is empty!!, uniseq=");
                paramVarArgs.append(this.a.uniseq);
                QLog.e("VideoCompressProcessor", 1, paramVarArgs.toString());
              }
              return Integer.valueOf(5);
            }
            paramVarArgs = this.a;
            paramVarArgs.md5 = this.h;
            paramVarArgs.videoFileSize = ((int)this.b);
            localObject1 = new File(this.i);
            paramVarArgs = SVUtils.a(this.a, "mp4");
            FileUtils.copyFile((File)localObject1, new File(paramVarArgs));
            if ((!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(this.i)) && (!this.d.equals(this.i))) {
              FileUtils.deleteFile((File)localObject1);
            }
            localObject1 = this.a;
            ((MessageForShortVideo)localObject1).videoFileName = paramVarArgs;
            ((MessageForShortVideo)localObject1).serial();
            return Integer.valueOf(1);
          }
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("CompressTask, step: after compress, mVideoPath not exists!!, path = ");
          paramVarArgs.append(this.i);
          paramVarArgs.append(", uniseq=");
          paramVarArgs.append(this.a.uniseq);
          QLog.e("VideoCompressProcessor", 2, paramVarArgs.toString());
          return Integer.valueOf(3);
        }
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("CompressTask, step: before compress, msg.videoFileName file not exists!! videoFileName=");
          paramVarArgs.append(this.a.videoFileName);
          QLog.e("VideoCompressProcessor", 2, paramVarArgs.toString());
        }
        return Integer.valueOf(3);
      }
    }
    return Integer.valueOf(7);
  }
  
  public void a(VideoCompressProcessor.CompressUpdateListener paramCompressUpdateListener)
  {
    if (paramCompressUpdateListener == null) {
      return;
    }
    this.f = paramCompressUpdateListener;
    if (AsyncTask.Status.FINISHED == getStatus())
    {
      paramCompressUpdateListener = this.f;
      if (paramCompressUpdateListener != null) {
        paramCompressUpdateListener.a(this.a, 1);
      }
    }
    else if (isCancelled())
    {
      paramCompressUpdateListener = this.f;
      if (paramCompressUpdateListener != null) {
        paramCompressUpdateListener.a(this.a, 3);
      }
    }
    else
    {
      paramCompressUpdateListener = this.f;
      if (paramCompressUpdateListener != null) {
        paramCompressUpdateListener.a(this.a, this.k);
      }
    }
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("CompressTask onPostExecute(): result = ");
    ((StringBuilder)localObject).append(paramInteger);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(d());
    QLog.d("VideoCompressProcessor", 1, ((StringBuilder)localObject).toString());
    localObject = this.f;
    int m = 2;
    if (localObject != null)
    {
      MessageForShortVideo localMessageForShortVideo = this.a;
      if (paramInteger.intValue() == 1) {
        m = 1;
      }
      ((VideoCompressProcessor.CompressUpdateListener)localObject).a(localMessageForShortVideo, m);
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPostExecute, mListener is null ,");
      ((StringBuilder)localObject).append(d());
      QLog.d("VideoCompressProcessor", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInteger.intValue() == 1)
    {
      ShortVideoItemBuilder.a(this.a, (QQAppInterface)this.e.get(), (Context)this.g.get());
      return;
    }
    ShortVideoItemBuilder.b(this.a, (QQAppInterface)this.e.get(), (Context)this.g.get());
  }
  
  public boolean a()
  {
    VideoConverter localVideoConverter = this.c;
    if (localVideoConverter != null) {
      return localVideoConverter.cancelCompress();
    }
    return false;
  }
  
  public long b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.d;
  }
  
  protected void onCancelled()
  {
    if (this.e.get() != null)
    {
      String str = this.a.md5;
      MessageForShortVideo localMessageForShortVideo = this.a;
      localMessageForShortVideo.videoFileStatus = 1004;
      if (!TextUtils.isEmpty(localMessageForShortVideo.md5)) {
        FileUtils.deleteFile(SVUtils.a(localMessageForShortVideo, "mp4"));
      }
      if (!TextUtils.isEmpty(this.d)) {
        localMessageForShortVideo.videoFileName = this.d;
      }
      localMessageForShortVideo.md5 = null;
      localMessageForShortVideo.serial();
      ((QQAppInterface)this.e.get()).getMessageFacade().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.istroop, localMessageForShortVideo.uniseq, localMessageForShortVideo.msgData);
      ((IOrderMediaMsgService)((QQAppInterface)this.e.get()).getRuntimeService(IOrderMediaMsgService.class)).removeMediaMsgByUniseq(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
      localObject = this.g;
      if ((localObject != null) && (((WeakReference)localObject).get() != null) && ((this.g.get() instanceof BaseActivity)))
      {
        localObject = ((BaseActivity)this.g.get()).getChatFragment();
        if (localObject != null)
        {
          localObject = ((ChatFragment)localObject).k();
          if (localObject != null) {
            ((BaseChatPie)localObject).a(false, false);
          }
        }
      }
      if (localMessageForShortVideo.sendRawVideo) {
        localObject = ShortVideoUtils.getShortVideoRawCompressPath(this.d, "mp4");
      } else {
        localObject = ShortVideoUtils.getShortVideoCompressPath(this.d, "mp4");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        FileUtils.deleteFile((String)localObject);
      }
      VideoCompressProcessor.a().a(this.a.uniseq);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("CompressTask onCancelled id:");
        ((StringBuilder)localObject).append(this.a.uniseq);
        ((StringBuilder)localObject).append(", videoFileName:");
        ((StringBuilder)localObject).append(localMessageForShortVideo.videoFileName);
        ((StringBuilder)localObject).append(", md5:");
        ((StringBuilder)localObject).append(str);
        QLog.i("VideoCompressProcessor", 2, ((StringBuilder)localObject).toString());
      }
    }
    Object localObject = this.f;
    if (localObject != null) {
      ((VideoCompressProcessor.CompressUpdateListener)localObject).a(this.a, 3);
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.VideoCompressProcessor.CompressTask
 * JD-Core Version:    0.7.0.1
 */