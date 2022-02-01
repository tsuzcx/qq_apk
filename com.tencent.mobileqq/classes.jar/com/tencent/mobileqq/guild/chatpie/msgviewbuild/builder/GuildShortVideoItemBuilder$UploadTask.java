package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

public class GuildShortVideoItemBuilder$UploadTask
  implements Runnable
{
  WeakReference<Context> a;
  WeakReference<QQAppInterface> b;
  MessageForShortVideo c;
  String d;
  long e = 0L;
  long f = 0L;
  WeakReference<GuildShortVideoItemBuilder> g;
  
  public GuildShortVideoItemBuilder$UploadTask(QQAppInterface paramQQAppInterface, Context paramContext, MessageForShortVideo paramMessageForShortVideo, String paramString, GuildShortVideoItemBuilder paramGuildShortVideoItemBuilder)
  {
    this.a = new WeakReference(paramContext);
    this.b = new WeakReference(paramQQAppInterface);
    this.g = new WeakReference(paramGuildShortVideoItemBuilder);
    this.c = paramMessageForShortVideo;
    this.d = paramString;
  }
  
  private void a(long paramLong)
  {
    GuildShortVideoItemBuilder localGuildShortVideoItemBuilder = (GuildShortVideoItemBuilder)this.g.get();
    if (localGuildShortVideoItemBuilder != null) {
      GuildShortVideoItemBuilder.a(localGuildShortVideoItemBuilder, paramLong);
    }
  }
  
  public void run()
  {
    if (this.c == null) {
      return;
    }
    this.e = System.currentTimeMillis();
    MessageForShortVideo localMessageForShortVideo = this.c;
    Object localObject1 = localMessageForShortVideo.videoFileName;
    Object localObject2 = (GuildShortVideoItemBuilder)this.g.get();
    if (FileUtils.fileExistsAndNotEmpty((String)localObject1))
    {
      if (QLog.isColorLevel()) {
        QLog.e("GuildShortVideoRealItemBuilder", 2, "mr.videoFileName is not null...");
      }
      a(localMessageForShortVideo.uniseq);
      return;
    }
    if (!FileUtils.fileExistsAndNotEmpty(this.d))
    {
      if (QLog.isColorLevel()) {
        QLog.e("GuildShortVideoRealItemBuilder", 2, "uploadTask file is null!");
      }
      a(localMessageForShortVideo.uniseq);
      return;
    }
    localObject1 = (QQAppInterface)this.b.get();
    if (localObject1 != null) {
      ((QQAppInterface)localObject1).getHwEngine().preConnect();
    }
    long l = new File(this.d).length();
    if (l == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GuildShortVideoRealItemBuilder", 2, "uploadTask file mVideoSize = 0");
      }
      a(localMessageForShortVideo.uniseq);
      return;
    }
    if (TextUtils.isEmpty(localMessageForShortVideo.md5))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("process videoMd5 is empty, videoMd5: ");
        ((StringBuilder)localObject1).append(localMessageForShortVideo.md5);
        QLog.e("GuildShortVideoRealItemBuilder", 2, ((StringBuilder)localObject1).toString());
      }
      a(localMessageForShortVideo.uniseq);
      return;
    }
    localMessageForShortVideo.videoFileSize = ((int)l);
    if (FileUtils.fileExistsAndNotEmpty(localMessageForShortVideo.mThumbFilePath))
    {
      localObject2 = SVUtils.a(localMessageForShortVideo.thumbMD5, "jpg");
      if (!((String)localObject2).equals(localMessageForShortVideo.mThumbFilePath))
      {
        if (!FileUtils.rename(localMessageForShortVideo.mThumbFilePath, (String)localObject2))
        {
          if (QLog.isColorLevel()) {
            QLog.e("GuildShortVideoRealItemBuilder", 2, "process mThumbFilePath error!");
          }
          a(localMessageForShortVideo.uniseq);
          return;
        }
        localMessageForShortVideo.mThumbFilePath = ((String)localObject2);
      }
    }
    if (localObject1 != null)
    {
      localObject2 = SVUtils.a(localMessageForShortVideo, "mp4");
      if (!this.d.equals(localObject2))
      {
        FileUtils.rename(this.d, (String)localObject2);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("onPostExecute destVideoPath ");
          ((StringBuilder)localObject3).append((String)localObject2);
          QLog.i("GuildShortVideoRealItemBuilder", 2, ((StringBuilder)localObject3).toString());
        }
      }
      localMessageForShortVideo.videoFileName = ((String)localObject2);
      localMessageForShortVideo.serial();
      int i;
      if ((localMessageForShortVideo instanceof MessageForDevLittleVideo)) {
        i = 4;
      } else {
        i = 2;
      }
      ((QQAppInterface)localObject1).getMessageFacade().a(localMessageForShortVideo.frienduin, localMessageForShortVideo.istroop, localMessageForShortVideo.uniseq, localMessageForShortVideo.msgData);
      localObject2 = SVBusiUtil.a(0, i);
      Object localObject3 = ShortVideoBusiManager.a(localMessageForShortVideo, (ShortVideoReq)localObject2);
      ((ShortVideoUploadInfo)localObject3).w = false;
      ((ShortVideoReq)localObject2).a((ShortVideoUploadInfo)localObject3);
      ShortVideoBusiManager.a((ShortVideoReq)localObject2, (QQAppInterface)localObject1);
      this.f = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[");
        ((StringBuilder)localObject2).append(localMessageForShortVideo.uniseq);
        ((StringBuilder)localObject2).append("]mMessageForShortVideo = ");
        ((StringBuilder)localObject2).append(localMessageForShortVideo);
        ((StringBuilder)localObject2).append("\n |- upload cost:");
        double d1 = this.f - this.e;
        Double.isNaN(d1);
        ((StringBuilder)localObject2).append(d1 / 1000.0D);
        QLog.i("GuildShortVideoRealItemBuilder", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = ((QQAppInterface)localObject1).getCurrentAccountUin();
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance((String)localObject1, "actShortVideoGenerateDuration", true, 0L, 0L, GuildShortVideoItemBuilder.h(), "");
      a(localMessageForShortVideo.uniseq);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("GuildShortVideoRealItemBuilder", 2, "QQAppInterface is null...");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildShortVideoItemBuilder.UploadTask
 * JD-Core Version:    0.7.0.1
 */