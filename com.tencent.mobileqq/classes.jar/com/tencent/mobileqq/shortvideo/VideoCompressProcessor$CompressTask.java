package com.tencent.mobileqq.shortvideo;

import android.content.Context;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.shortvideo.ProgressiveUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgManager;
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
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "CompressTask, step: messageForShortVideo info uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq + ", OriPath:" + this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        QLog.e("VideoCompressProcessor", 1, "CompressTask Init", paramQQAppInterface);
      }
    }
  }
  
  private int a(String paramString1, String paramString2)
  {
    int j = -1;
    long l3 = System.currentTimeMillis();
    Object localObject1 = VideoCompressConfig.a((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    VideoCompressConfig.VideoInfo localVideoInfo = VideoCompressConfig.a(paramString1);
    VideoCompressProcessor.a(localVideoInfo);
    boolean bool = VideoCompressConfig.a(localVideoInfo, (VideoCompressConfig.ManageConfig)localObject1);
    this.jdField_b_of_type_Boolean = bool;
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressProcessor", 1, "CompressTask, isNeedCompress = " + bool);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener != null) {
      UiThreadUtil.a(new VideoCompressProcessor.CompressTask.1(this, bool));
    }
    if (!bool) {
      return j;
    }
    localObject1 = VideoCompressConfig.a(localVideoInfo, (VideoCompressConfig.ManageConfig)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.sendRawVideo);
    Object localObject2 = new VideoCompressProcessor.HWCompressProcessor(this.jdField_a_of_type_JavaLangRefWeakReference, paramString1, paramString2, (VideoCompressConfig.CompressInfo)localObject1, new VideoCompressProcessor.CompressTask.2(this));
    this.jdField_a_of_type_ComTencentRichmediaVideocompressVideoConverter = new VideoConverter(new VideoConverterLog());
    this.jdField_a_of_type_ComTencentRichmediaVideocompressVideoConverter.setCompressMode(1);
    int i = this.jdField_a_of_type_ComTencentRichmediaVideocompressVideoConverter.startCompress((Context)this.jdField_b_of_type_JavaLangRefWeakReference.get(), paramString1, (VideoConverter.Processor)localObject2, true);
    label225:
    long l1;
    label391:
    label443:
    long l2;
    if ((i == 0) || (i == -1002))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "CompressTask, step: compress completed by MediaCodec");
      }
      i = 0;
      if (i == 0) {
        break label730;
      }
      if (!ShortVideoTrimmer.initVideoTrim((Context)this.jdField_b_of_type_JavaLangRefWeakReference.get())) {
        break label666;
      }
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
      if (i != 0) {
        break label637;
      }
      QLog.d("VideoCompressProcessor", 1, "CompressTask, step:compress completed by ShortVideoTrimmer.compressVideo");
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "CompressTask，step: ShortVideoTrimmer compress retCode=" + i + ", uni=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      }
      if (i != 0) {
        break label733;
      }
      this.c = paramString2;
      l1 = new File(paramString1).length();
      l2 = new File(this.c).length();
      l3 = System.currentTimeMillis() - l3;
      if (i != 0) {
        break label744;
      }
    }
    label666:
    label730:
    label733:
    label744:
    for (bool = true;; bool = false)
    {
      VideoCompressProcessor.a(bool, l3, localVideoInfo, (VideoCompressConfig.CompressInfo)localObject1, l2);
      j = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("VideoCompressProcessor", 2, "CompressTask，step: ShortVideoTrimmer compress, cost:" + l3 + "ms, fileSourceSize=" + l1 + ", fileTargetSize=" + l2 + ", uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      return i;
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "CompressTask, step: compress failed by MediaCodec");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 1.0F);
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "不支持硬件压缩，不管软件压缩成功或失败，均默认展示完整呼吸圈");
      }
      i = -1;
      break label225;
      label637:
      QLog.d("VideoCompressProcessor", 1, "CompressTask, step:compress failed using ShortVideoTrimmer.compressVideo, ret = " + i);
      break label391;
      this.c = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
      QLog.e("VideoCompressProcessor", 2, "CompressTask，step: ShortVideoTrimmer init failure, ignore compress, uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "initVideoTrimError", true, 0L, 0L, null, "", false);
      break label391;
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
      break label443;
    }
  }
  
  private String b()
  {
    String str = "";
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) {
      str = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    return "uniseq = " + str;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    boolean bool2 = false;
    if ((this.jdField_b_of_type_JavaLangRefWeakReference == null) || (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
      return Integer.valueOf(7);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "CompressTask, step: Md5 not null, Compressed has been done, uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      }
      return Integer.valueOf(5);
    }
    if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName)) || (!FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("VideoCompressProcessor", 2, "CompressTask, step: before compress, msg.videoFileName file not exists!! videoFileName=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName);
      }
      return Integer.valueOf(3);
    }
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
    String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
    paramVarArgs = ShortVideoUtils.getShortVideoCompressPath(str, "mp4");
    if (TextUtils.isEmpty(paramVarArgs)) {
      return Integer.valueOf(5);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.sendRawVideo)
    {
      paramVarArgs = ShortVideoUtils.getShortVideoRawCompressPath(str, "mp4");
      l1 = new File(str).length();
      if (l1 < 104345600L) {
        break label368;
      }
    }
    label368:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 16) {
        bool1 = ShortVideoUtils.isH265FormatShortVideo(this.jdField_a_of_type_JavaLangString);
      }
      if (bool1) {
        this.jdField_a_of_type_Boolean = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "CompressTask, step: Compressed sendRawVideo, uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq + ", mRawCompress:" + this.jdField_a_of_type_Boolean + ", output:" + paramVarArgs + ", isH265:" + bool1 + ", size:" + l1);
      }
      if (!TextUtils.isEmpty(paramVarArgs)) {
        break;
      }
      return Integer.valueOf(5);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.sendRawVideo) && (!this.jdField_a_of_type_Boolean))
    {
      this.c = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "CompressTask, step: Compressed sendRawVideo, uniseq:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 1.0F);
      }
    }
    while (isCancelled())
    {
      return Integer.valueOf(11);
      if (FileUtils.b(paramVarArgs))
      {
        this.c = paramVarArgs;
        QLog.d("VideoCompressProcessor", 1, "CompressTask, step: Compressed file has exists, videoPath:" + paramVarArgs + ", uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 1.0F);
        }
      }
      else
      {
        if (a(str, paramVarArgs) == 0) {}
        for (;;)
        {
          this.c = paramVarArgs;
          break;
          paramVarArgs = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
        }
      }
    }
    if (TextUtils.isEmpty(this.c)) {
      this.c = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
    }
    long l1 = new File(str).length();
    long l2 = new File(this.c).length();
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressProcessor", 2, "CompressTask，step: ShortVideoTrimmer Over fileSourceSize=" + l1 + ", fileTargetSize=" + l2 + ", uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq + ", videoInput=" + str + ", mVideoPath=" + this.c);
    }
    if (l2 > l1) {
      this.c = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressProcessor", 2, "CompressTask, step: after compress, mVideoPath = " + this.c + ", videoInput = " + str + ", uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    if ((TextUtils.isEmpty(this.c)) || (!FileUtils.b(this.c)))
    {
      QLog.e("VideoCompressProcessor", 2, "CompressTask, step: after compress, mVideoPath not exists!!, path = " + this.c + ", uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      return Integer.valueOf(3);
    }
    paramVarArgs = new File(this.c);
    if (ShortVideoUtils.isSupportProgressive(paramVarArgs))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "CompressTask, step: supportProgressive, uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.supportProgressive = true;
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = paramVarArgs.length();
      try
      {
        this.jdField_b_of_type_JavaLangString = HexUtil.bytes2HexStr(MD5.toMD5Byte(new FileInputStream(paramVarArgs), this.jdField_a_of_type_Long));
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
        {
          if (QLog.isColorLevel()) {
            QLog.e("VideoCompressProcessor", 1, "CompressTask, step: after compress, mVideoMd5 is empty!!, uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
          }
          return Integer.valueOf(5);
          bool1 = ProgressiveUtils.a.get();
          bool2 = ShortVideoUtils.moveMoovAtom(this.c);
          if (QLog.isColorLevel()) {
            QLog.d("VideoCompressProcessor", 2, "CompressTask, step: not supportProgressive => moveMoovAtom, result = " + bool2 + ", uniseq=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq + ", enableProgressive = " + bool1);
          }
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.supportProgressive = bool2;
        }
      }
      catch (FileNotFoundException paramVarArgs)
      {
        for (;;)
        {
          paramVarArgs.printStackTrace();
        }
      }
      catch (Exception paramVarArgs)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("VideoCompressProcessor", 2, "", paramVarArgs);
          }
        }
        if (this.jdField_a_of_type_Long < 104345600L)
        {
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5 = this.jdField_b_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize = ((int)this.jdField_a_of_type_Long);
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileName = this.c;
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.serial();
          FileUtils.a(new File(this.c), new File(ShortVideoUtils.getShortVideoSavePath(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4")));
        }
      }
    }
    return Integer.valueOf(1);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(VideoCompressProcessor.CompressUpdateListener paramCompressUpdateListener)
  {
    if (paramCompressUpdateListener == null) {}
    do
    {
      do
      {
        do
        {
          return;
          this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener = paramCompressUpdateListener;
          if (AsyncTask.Status.FINISHED != getStatus()) {
            break;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener == null);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 1);
        return;
        if (!isCancelled()) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener == null);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 3);
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener == null);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, this.jdField_b_of_type_Boolean);
  }
  
  protected void a(Integer paramInteger)
  {
    int i = 2;
    super.onPostExecute(paramInteger);
    QLog.d("VideoCompressProcessor", 1, "CompressTask onPostExecute(): result = " + paramInteger + ", " + b());
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener != null)
    {
      VideoCompressProcessor.CompressUpdateListener localCompressUpdateListener = this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener;
      MessageForShortVideo localMessageForShortVideo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
      if (paramInteger.intValue() == 1) {
        i = 1;
      }
      localCompressUpdateListener.a(localMessageForShortVideo, i);
    }
    while (paramInteger.intValue() == 1)
    {
      ShortVideoItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (Context)this.jdField_b_of_type_JavaLangRefWeakReference.get());
      return;
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressProcessor", 2, "onPostExecute, mListener is null ," + b());
      }
    }
    ShortVideoItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), (Context)this.jdField_b_of_type_JavaLangRefWeakReference.get());
  }
  
  public boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentRichmediaVideocompressVideoConverter != null) {
      bool = this.jdField_a_of_type_ComTencentRichmediaVideocompressVideoConverter.cancelCompress();
    }
    return bool;
  }
  
  protected void onCancelled()
  {
    String str;
    MessageForShortVideo localMessageForShortVideo;
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.md5;
      localMessageForShortVideo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
      localMessageForShortVideo.videoFileStatus = 1004;
      if (!TextUtils.isEmpty(localMessageForShortVideo.md5)) {
        FileUtils.e(ShortVideoUtils.getShortVideoSavePath(localMessageForShortVideo, "mp4"));
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        localMessageForShortVideo.videoFileName = this.jdField_a_of_type_JavaLangString;
      }
      localMessageForShortVideo.md5 = null;
      localMessageForShortVideo.serial();
      ((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getMessageFacade().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.istroop, localMessageForShortVideo.uniseq, localMessageForShortVideo.msgData);
      OrderMediaMsgManager.a((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), localMessageForShortVideo.frienduin, localMessageForShortVideo.uniseq);
      if ((this.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null) && ((this.jdField_b_of_type_JavaLangRefWeakReference.get() instanceof FragmentActivity)))
      {
        localObject = ((FragmentActivity)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getChatFragment();
        if (localObject != null)
        {
          localObject = ((ChatFragment)localObject).a();
          if (localObject != null) {
            ((BaseChatPie)localObject).c(false, false);
          }
        }
      }
      if (!localMessageForShortVideo.sendRawVideo) {
        break label320;
      }
    }
    label320:
    for (Object localObject = ShortVideoUtils.getShortVideoRawCompressPath(this.jdField_a_of_type_JavaLangString, "mp4");; localObject = ShortVideoUtils.getShortVideoCompressPath(this.jdField_a_of_type_JavaLangString, "mp4"))
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        FileUtils.e((String)localObject);
      }
      VideoCompressProcessor.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      if (QLog.isColorLevel()) {
        QLog.i("VideoCompressProcessor", 2, "CompressTask onCancelled id:" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq + ", videoFileName:" + localMessageForShortVideo.videoFileName + ", md5:" + str);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoVideoCompressProcessor$CompressUpdateListener.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 3);
      }
      return;
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.VideoCompressProcessor.CompressTask
 * JD-Core Version:    0.7.0.1
 */