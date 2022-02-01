package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMultiMsgProxy;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import tencent.im.msg.im_msg_body.RichText;

class MultiForwardVideoUpCallback
  implements UpCallBack
{
  final int a;
  ShortVideoResult b;
  private final MultiForwardShortVideoTask c;
  
  MultiForwardVideoUpCallback(MultiForwardShortVideoTask paramMultiForwardShortVideoTask, int paramInt)
  {
    this.c = paramMultiForwardShortVideoTask;
    this.a = paramInt;
    this.b = ((ShortVideoResult)paramMultiForwardShortVideoTask.c.get(this.a));
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return (MessageForShortVideo)((ShortVideoForwardInfo)this.c.b.get(this.a)).v;
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)((ShortVideoForwardInfo)this.c.b.get(this.a)).v;
    localMessageForShortVideo.videoFileStatus = 1003;
    localMessageForShortVideo.md5 = paramSendResult.g;
    localMessageForShortVideo.uuid = paramSendResult.f;
    localMessageForShortVideo.thumbFileSize = ((int)paramSendResult.i);
    localMessageForShortVideo.videoAttr = paramSendResult.j;
    localMessageForShortVideo.videoKandianType = paramSendResult.k;
    localMessageForShortVideo.serial();
    ((IMultiMsgProxy)QRoute.api(IMultiMsgProxy.class)).updateMultiMsg(this.c.a.a, localMessageForShortVideo);
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    synchronized (this.c.c)
    {
      if (paramSendResult.a == 0)
      {
        a(paramSendResult);
        this.b.a = 0;
        if (QLog.isColorLevel()) {
          QLog.d("BaseShortVideoOprerator", 2, "onsend success!");
        }
      }
      else
      {
        this.b.a = -1;
        this.b.b = new PicInfoInterface.ErrInfo();
        this.b.b.b = paramSendResult.c;
        this.b.b.c = paramSendResult.b;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onsend fail! err:");
          localStringBuilder.append(paramSendResult.c);
          QLog.d("BaseShortVideoOprerator", 2, localStringBuilder.toString());
        }
      }
      int i = this.c.c();
      if (i == 0) {
        this.c.a.a(3, 0, this.c.c);
      } else if (this.c.d == this.c.b.size() - i) {
        this.c.a();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.MultiForwardVideoUpCallback
 * JD-Core Version:    0.7.0.1
 */