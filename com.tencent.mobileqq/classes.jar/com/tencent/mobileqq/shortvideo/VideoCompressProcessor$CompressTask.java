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
  private long jdField_a_of_type_Long;
  public MessageForShortVideo a;
  private VideoCompressProcessor.CompressUpdateListener jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener;
  private VideoConverter jdField_a_of_type_ComTencentRichmediaVideocompressVideoConverter;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  private String jdField_b_of_type_JavaLangString;
  private WeakReference<Context> jdField_b_of_type_JavaLangRefWeakReference;
  private boolean jdField_b_of_type_Boolean = false;
  private String c;
  
  public VideoCompressProcessor$CompressTask(QQAppInterface paramQQAppInterface, Context paramContext, MessageForShortVideo paramMessageForShortVideo, VideoCompressProcessor.CompressUpdateListener paramCompressUpdateListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener = paramCompressUpdateListener;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
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
      paramQQAppInterface.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      paramQQAppInterface.append(", OriPath:");
      paramQQAppInterface.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("VideoCompressProcessor", 2, paramQQAppInterface.toString());
    }
  }
  
  private int a(String paramString1, String paramString2)
  {
    long l3 = System.currentTimeMillis();
    Object localObject1 = VideoCompressConfig.a((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    VideoCompressConfig.VideoInfo localVideoInfo = VideoCompressConfig.a(paramString1);
    VideoCompressProcessor.a(localVideoInfo);
    boolean bool = VideoCompressConfig.a(localVideoInfo, (VideoCompressConfig.ManageConfig)localObject1);
    this.jdField_b_of_type_Boolean = bool;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("CompressTask, isNeedCompress = ");
      ((StringBuilder)localObject2).append(bool);
      QLog.d("VideoCompressProcessor", 1, ((StringBuilder)localObject2).toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener != null) {
      UiThreadUtil.a(new VideoCompressProcessor.CompressTask.1(this, bool));
    }
    int j = -1;
    if (!bool) {
      return -1;
    }
    localObject1 = VideoCompressConfig.a(localVideoInfo, (VideoCompressConfig.ManageConfig)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.sendRawVideo);
    Object localObject2 = new VideoCompressProcessor.HWCompressProcessor(this.jdField_a_of_type_JavaLangRefWeakReference, paramString1, paramString2, (VideoCompressConfig.CompressInfo)localObject1, new VideoCompressProcessor.CompressTask.2(this));
    this.jdField_a_of_type_ComTencentRichmediaVideocompressVideoConverter = new VideoConverter(new VideoConverterLog());
    this.jdField_a_of_type_ComTencentRichmediaVideocompressVideoConverter.setCompressMode(1);
    int i = this.jdField_a_of_type_ComTencentRichmediaVideocompressVideoConverter.startCompress((Context)this.jdField_b_of_type_JavaLangRefWeakReference.get(), paramString1, (VideoConverter.Processor)localObject2, true);
    if ((i != 0) && (i != -1002))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "CompressTask, step: compress failed by MediaCodec");
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener;
      if (localObject2 != null) {
        ((VideoCompressProcessor.CompressUpdateListener)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 1.0F);
      }
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("VideoCompressProcessor", 2, "不支持硬件压缩，不管软件压缩成功或失败，均默认展示完整呼吸圈");
        i = j;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "CompressTask, step: compress completed by MediaCodec");
      }
      i = 0;
    }
    if (i != 0) {
      if (ShortVideoTrimmer.initVideoTrim((Context)this.jdField_b_of_type_JavaLangRefWeakReference.get()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressProcessor", 2, "CompressTask, step: Try to compress by ShortVideoTrimmer.compressVideo");
        }
        localObject2 = new VideoConverterConfig();
        ((VideoConverterConfig)localObject2).isNeedCompress = true;
        ((VideoConverterConfig)localObject2).rotate = String.valueOf(localVideoInfo.c);
        ((VideoConverterConfig)localObject2).srcWidth = localVideoInfo.jdField_a_of_type_Int;
        ((VideoConverterConfig)localObject2).srcHeight = localVideoInfo.jdField_b_of_type_Int;
        ((VideoConverterConfig)localObject2).destWidth = ((VideoCompressConfig.CompressInfo)localObject1).jdField_a_of_type_Int;
        ((VideoConverterConfig)localObject2).destHeight = ((VideoCompressConfig.CompressInfo)localObject1).jdField_b_of_type_Int;
        ((VideoConverterConfig)localObject2).destQmax = 25;
        ((VideoConverterConfig)localObject2).videoFrameRate = ((int)((VideoCompressConfig.CompressInfo)localObject1).jdField_b_of_type_Long);
        ((VideoConverterConfig)localObject2).videoBitRate = ((int)(((VideoCompressConfig.CompressInfo)localObject1).jdField_a_of_type_Long / 1024L));
        i = ShortVideoTrimmer.compressVideo((Context)this.jdField_b_of_type_JavaLangRefWeakReference.get(), paramString1, paramString2, (VideoConverterConfig)localObject2);
        if (i == 0)
        {
          QLog.d("VideoCompressProcessor", 1, "CompressTask, step:compress completed by ShortVideoTrimmer.compressVideo");
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("CompressTask, step:compress failed using ShortVideoTrimmer.compressVideo, ret = ");
          ((StringBuilder)localObject2).append(i);
          QLog.d("VideoCompressProcessor", 1, ((StringBuilder)localObject2).toString());
        }
      }
      else
      {
        this.c = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("CompressTask，step: ShortVideoTrimmer init failure, ignore compress, uniseq=");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
        QLog.e("VideoCompressProcessor", 2, ((StringBuilder)localObject2).toString());
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "initVideoTrimError", true, 0L, 0L, null, "", false);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("CompressTask，step: ShortVideoTrimmer compress retCode=");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(", uni=");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      QLog.d("VideoCompressProcessor", 2, ((StringBuilder)localObject2).toString());
    }
    if (i != 0) {
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
    }
    this.c = paramString2;
    long l1 = new File(paramString1).length();
    long l2 = new File(this.c).length();
    l3 = System.currentTimeMillis() - l3;
    if (i == 0) {
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
      paramString1.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      QLog.d("VideoCompressProcessor", 2, paramString1.toString());
    }
    return i;
  }
  
  private String b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
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
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    paramVarArgs = this.jdField_b_of_type_JavaLangRefWeakReference;
    if ((paramVarArgs != null) && (paramVarArgs.get() != null))
    {
      paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
      if (paramVarArgs != null)
      {
        if (!TextUtils.isEmpty(paramVarArgs.md5))
        {
          if (QLog.isColorLevel())
          {
            paramVarArgs = new StringBuilder();
            paramVarArgs.append("CompressTask, step: Md5 not null, Compressed has been done, uniseq=");
            paramVarArgs.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
            QLog.d("VideoCompressProcessor", 2, paramVarArgs.toString());
          }
          return Integer.valueOf(5);
        }
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName)) && (FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName)))
        {
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
          Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
          Object localObject1 = ShortVideoUtils.getShortVideoCompressPath((String)localObject2, "mp4");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            return Integer.valueOf(5);
          }
          boolean bool2;
          boolean bool1;
          if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.sendRawVideo)
          {
            paramVarArgs = ShortVideoUtils.getShortVideoRawCompressPath((String)localObject2, "mp4");
            l1 = new File((String)localObject2).length();
            bool2 = false;
            if (l1 >= 104345600L) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            this.jdField_a_of_type_Boolean = bool1;
            bool1 = bool2;
            if (Build.VERSION.SDK_INT >= 16) {
              bool1 = ShortVideoUtils.isH265FormatShortVideo(this.jdField_a_of_type_JavaLangString);
            }
            if (bool1) {
              this.jdField_a_of_type_Boolean = true;
            }
            localObject1 = paramVarArgs;
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("CompressTask, step: Compressed sendRawVideo, uniseq:");
              ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
              ((StringBuilder)localObject1).append(", mRawCompress:");
              ((StringBuilder)localObject1).append(this.jdField_a_of_type_Boolean);
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
          if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.sendRawVideo) && (!this.jdField_a_of_type_Boolean))
          {
            this.c = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
            if (QLog.isColorLevel())
            {
              paramVarArgs = new StringBuilder();
              paramVarArgs.append("CompressTask, step: Compressed sendRawVideo, uniseq:");
              paramVarArgs.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
              QLog.d("VideoCompressProcessor", 2, paramVarArgs.toString());
            }
            paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener;
            if (paramVarArgs != null) {
              paramVarArgs.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 1.0F);
            }
          }
          else
          {
            if (!FileUtils.fileExistsAndNotEmpty((String)localObject1)) {
              break label568;
            }
            this.c = ((String)localObject1);
            paramVarArgs = new StringBuilder();
            paramVarArgs.append("CompressTask, step: Compressed file has exists, videoPath:");
            paramVarArgs.append((String)localObject1);
            paramVarArgs.append(", uniseq=");
            paramVarArgs.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
            QLog.d("VideoCompressProcessor", 1, paramVarArgs.toString());
            paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener;
            if (paramVarArgs != null) {
              paramVarArgs.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 1.0F);
            }
          }
          break label763;
          label568:
          int i = a((String)localObject2, (String)localObject1);
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
            paramVarArgs.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
            paramVarArgs.append(", videoInput=");
            paramVarArgs.append((String)localObject2);
            paramVarArgs.append(", mVideoPath=");
            paramVarArgs.append(this.c);
            QLog.d("VideoCompressProcessor", 2, paramVarArgs.toString());
          }
          if (i == 0)
          {
            if (l2 > l1)
            {
              FileUtils.deleteFile((String)localObject1);
              this.c = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
            }
            else
            {
              this.c = ((String)localObject1);
            }
          }
          else {
            this.c = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
          }
          label763:
          if (isCancelled()) {
            return Integer.valueOf(11);
          }
          if (QLog.isColorLevel())
          {
            paramVarArgs = new StringBuilder();
            paramVarArgs.append("CompressTask, step: after compress, mVideoPath = ");
            paramVarArgs.append(this.c);
            paramVarArgs.append(", videoInput = ");
            paramVarArgs.append((String)localObject2);
            paramVarArgs.append(", uniseq=");
            paramVarArgs.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
            QLog.d("VideoCompressProcessor", 2, paramVarArgs.toString());
          }
          if ((!TextUtils.isEmpty(this.c)) && (FileUtils.fileExistsAndNotEmpty(this.c)))
          {
            paramVarArgs = new File(this.c);
            if (ShortVideoUtils.isSupportProgressive(paramVarArgs))
            {
              if (QLog.isColorLevel())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("CompressTask, step: supportProgressive, uniseq=");
                ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
                QLog.d("VideoCompressProcessor", 2, ((StringBuilder)localObject1).toString());
              }
              this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.supportProgressive = true;
              localObject2 = paramVarArgs;
            }
            else
            {
              bool1 = ProgressiveUtils.a.get();
              localObject2 = paramVarArgs;
              if (bool1)
              {
                bool2 = ShortVideoUtils.moveMoovAtom(this.c, (String)localObject1);
                if (bool2)
                {
                  this.c = ((String)localObject1);
                  paramVarArgs = new File(this.c);
                }
                if (QLog.isColorLevel())
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("CompressTask, step: not supportProgressive => moveMoovAtom, result = ");
                  ((StringBuilder)localObject1).append(bool2);
                  ((StringBuilder)localObject1).append(", uniseq=");
                  ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
                  ((StringBuilder)localObject1).append(", enableProgressive = ");
                  ((StringBuilder)localObject1).append(bool1);
                  QLog.d("VideoCompressProcessor", 2, ((StringBuilder)localObject1).toString());
                }
                this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.supportProgressive = bool2;
                localObject2 = paramVarArgs;
              }
            }
            this.jdField_a_of_type_Long = ((File)localObject2).length();
            try
            {
              this.jdField_b_of_type_JavaLangString = HexUtil.bytes2HexStr(MD5.toMD5Byte(new FileInputStream((File)localObject2), this.jdField_a_of_type_Long));
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
            if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
            {
              if (QLog.isColorLevel())
              {
                paramVarArgs = new StringBuilder();
                paramVarArgs.append("CompressTask, step: after compress, mVideoMd5 is empty!!, uniseq=");
                paramVarArgs.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
                QLog.e("VideoCompressProcessor", 1, paramVarArgs.toString());
              }
              return Integer.valueOf(5);
            }
            paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
            paramVarArgs.md5 = this.jdField_b_of_type_JavaLangString;
            paramVarArgs.videoFileSize = ((int)this.jdField_a_of_type_Long);
            localObject1 = new File(this.c);
            paramVarArgs = SVUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
            FileUtils.copyFile((File)localObject1, new File(paramVarArgs));
            if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.c)) && (!this.jdField_a_of_type_JavaLangString.equals(this.c))) {
              FileUtils.deleteFile((File)localObject1);
            }
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
            ((MessageForShortVideo)localObject1).videoFileName = paramVarArgs;
            ((MessageForShortVideo)localObject1).serial();
            return Integer.valueOf(1);
          }
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("CompressTask, step: after compress, mVideoPath not exists!!, path = ");
          paramVarArgs.append(this.c);
          paramVarArgs.append(", uniseq=");
          paramVarArgs.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
          QLog.e("VideoCompressProcessor", 2, paramVarArgs.toString());
          return Integer.valueOf(3);
        }
        if (QLog.isColorLevel())
        {
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("CompressTask, step: before compress, msg.videoFileName file not exists!! videoFileName=");
          paramVarArgs.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName);
          QLog.e("VideoCompressProcessor", 2, paramVarArgs.toString());
        }
        return Integer.valueOf(3);
      }
    }
    return Integer.valueOf(7);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(VideoCompressProcessor.CompressUpdateListener paramCompressUpdateListener)
  {
    if (paramCompressUpdateListener == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener = paramCompressUpdateListener;
    if (AsyncTask.Status.FINISHED == getStatus())
    {
      paramCompressUpdateListener = this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener;
      if (paramCompressUpdateListener != null) {
        paramCompressUpdateListener.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 1);
      }
    }
    else if (isCancelled())
    {
      paramCompressUpdateListener = this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener;
      if (paramCompressUpdateListener != null) {
        paramCompressUpdateListener.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 3);
      }
    }
    else
    {
      paramCompressUpdateListener = this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener;
      if (paramCompressUpdateListener != null) {
        paramCompressUpdateListener.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, this.jdField_b_of_type_Boolean);
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
    ((StringBuilder)localObject).append(b());
    QLog.d("VideoCompressProcessor", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener;
    int i = 2;
    if (localObject != null)
    {
      MessageForShortVideo localMessageForShortVideo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
      if (paramInteger.intValue() == 1) {
        i = 1;
      }
      ((VideoCompressProcessor.CompressUpdateListener)localObject).a(localMessageForShortVideo, i);
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPostExecute, mListener is null ,");
      ((StringBuilder)localObject).append(b());
      QLog.d("VideoCompressProcessor", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInteger.intValue() == 1)
    {
      ShortVideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (Context)this.jdField_b_of_type_JavaLangRefWeakReference.get());
      return;
    }
    ShortVideoItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (Context)this.jdField_b_of_type_JavaLangRefWeakReference.get());
  }
  
  public boolean a()
  {
    VideoConverter localVideoConverter = this.jdField_a_of_type_ComTencentRichmediaVideocompressVideoConverter;
    if (localVideoConverter != null) {
      return localVideoConverter.cancelCompress();
    }
    return false;
  }
  
  protected void onCancelled()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5;
      MessageForShortVideo localMessageForShortVideo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
      localMessageForShortVideo.videoFileStatus = 1004;
      if (!TextUtils.isEmpty(localMessageForShortVideo.md5)) {
        FileUtils.deleteFile(SVUtils.a(localMessageForShortVideo, "mp4"));
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        localMessageForShortVideo.videoFileName = this.jdField_a_of_type_JavaLangString;
      }
      localMessageForShortVideo.md5 = null;
      localMessageForShortVideo.serial();
      ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getMessageFacade().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.istroop, localMessageForShortVideo.uniseq, localMessageForShortVideo.msgData);
      ((IOrderMediaMsgService)((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getRuntimeService(IOrderMediaMsgService.class)).removeMediaMsgByUniseq(localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
      localObject = this.jdField_b_of_type_JavaLangRefWeakReference;
      if ((localObject != null) && (((WeakReference)localObject).get() != null) && ((this.jdField_b_of_type_JavaLangRefWeakReference.get() instanceof BaseActivity)))
      {
        localObject = ((BaseActivity)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getChatFragment();
        if (localObject != null)
        {
          localObject = ((ChatFragment)localObject).a();
          if (localObject != null) {
            ((BaseChatPie)localObject).a(false, false);
          }
        }
      }
      if (localMessageForShortVideo.sendRawVideo) {
        localObject = ShortVideoUtils.getShortVideoRawCompressPath(this.jdField_a_of_type_JavaLangString, "mp4");
      } else {
        localObject = ShortVideoUtils.getShortVideoCompressPath(this.jdField_a_of_type_JavaLangString, "mp4");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        FileUtils.deleteFile((String)localObject);
      }
      VideoCompressProcessor.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("CompressTask onCancelled id:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
        ((StringBuilder)localObject).append(", videoFileName:");
        ((StringBuilder)localObject).append(localMessageForShortVideo.videoFileName);
        ((StringBuilder)localObject).append(", md5:");
        ((StringBuilder)localObject).append(str);
        QLog.i("VideoCompressProcessor", 2, ((StringBuilder)localObject).toString());
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener;
    if (localObject != null) {
      ((VideoCompressProcessor.CompressUpdateListener)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 3);
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.VideoCompressProcessor.CompressTask
 * JD-Core Version:    0.7.0.1
 */