package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.safestream.ISafeStream;
import cooperation.qwallet.safestream.QwSafeInputStream;
import cooperation.qwallet.safestream.QwSafeOutputStream;
import tencent.im.msg.im_msg_body.QQWalletAioBody;

public class QQWalletTransferMsg
  implements ISafeStream
{
  public QQWalletAioBodyReserve body;
  private int channelId;
  public QQWalletBaseMsgElem elem;
  public String listId;
  private int resend;
  public int templateId;
  
  public QQWalletTransferMsg()
  {
    this.body = new QQWalletAioBodyReserve();
    this.elem = new QQWalletBaseMsgElem();
  }
  
  public QQWalletTransferMsg(im_msg_body.QQWalletAioBody paramQQWalletAioBody, String paramString)
  {
    if ((paramQQWalletAioBody == null) || (TextUtils.isEmpty(paramString)))
    {
      this.body = new QQWalletAioBodyReserve();
      this.elem = new QQWalletBaseMsgElem();
      return;
    }
    if ((paramQQWalletAioBody.sint32_msgtype.has()) && (paramQQWalletAioBody.sint32_msgtype.get() == 16)) {
      this.elem = new QQWalletBaseMsgElem(paramQQWalletAioBody.receiver);
    }
    for (;;)
    {
      this.channelId = paramQQWalletAioBody.sint32_channelid.get();
      this.templateId = paramQQWalletAioBody.sint32_templateid.get();
      this.resend = paramQQWalletAioBody.uint32_resend.get();
      if (paramQQWalletAioBody.bytes_billno.has()) {
        this.listId = paramQQWalletAioBody.bytes_billno.get().toStringUtf8();
      }
      this.body = new QQWalletAioBodyReserve(paramQQWalletAioBody);
      return;
      long l = paramQQWalletAioBody.uint64_senduin.get();
      if ((l != 0L) && (paramString.compareTo("" + l) == 0)) {
        this.elem = new QQWalletBaseMsgElem(paramQQWalletAioBody.sender);
      } else {
        this.elem = new QQWalletBaseMsgElem(paramQQWalletAioBody.receiver);
      }
    }
  }
  
  public byte[] flushMsgData(int paramInt)
  {
    Object localObject3 = null;
    for (;;)
    {
      try
      {
        localObject1 = new QwSafeOutputStream();
        localObject2 = localObject1;
      }
      catch (Exception localException1)
      {
        try
        {
          writeHeader((QwSafeOutputStream)localObject1, paramInt);
          writeExternal((QwSafeOutputStream)localObject1);
          localObject2 = localObject1;
          localObject1 = localObject3;
          if (localObject2 != null) {
            localObject1 = localObject2.a();
          }
          return localObject1;
        }
        catch (Exception localException2)
        {
          Object localObject1;
          Object localObject2;
          break label42;
        }
        localException1 = localException1;
        localObject1 = null;
      }
      label42:
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.qqwalletmsg", 2, "QQWalletTransferMsg write Exception", localException1);
        localObject2 = localObject1;
      }
    }
  }
  
  public void readExternal(QwSafeInputStream paramQwSafeInputStream)
  {
    this.elem.background = paramQwSafeInputStream.a();
    this.elem.icon = paramQwSafeInputStream.a();
    this.elem.title = paramQwSafeInputStream.a();
    this.elem.subTitle = paramQwSafeInputStream.a();
    this.elem.content = paramQwSafeInputStream.a();
    this.elem.linkUrl = paramQwSafeInputStream.a();
    this.elem.blackStripe = paramQwSafeInputStream.a();
    this.elem.notice = paramQwSafeInputStream.a();
    this.channelId = paramQwSafeInputStream.a();
    this.templateId = paramQwSafeInputStream.a();
    this.resend = paramQwSafeInputStream.a();
    this.elem.titleColor = paramQwSafeInputStream.a(-1);
    this.elem.subtitleColor = paramQwSafeInputStream.a(-1);
    this.elem.actionsPriority = paramQwSafeInputStream.a();
    this.elem.jumpUrl = paramQwSafeInputStream.a();
    this.elem.nativeAndroid = paramQwSafeInputStream.a();
    this.elem.iconUrl = paramQwSafeInputStream.a();
    this.elem.contentColor = paramQwSafeInputStream.a(13487565);
    this.elem.contentBgColor = paramQwSafeInputStream.a(-1);
    this.elem.aioImageLeft = paramQwSafeInputStream.a();
    this.elem.aioImageRight = paramQwSafeInputStream.a();
    this.elem.cftImage = paramQwSafeInputStream.a();
    this.body.pfa_type = paramQwSafeInputStream.a();
    this.elem.readJsonParams(paramQwSafeInputStream.a());
    this.listId = paramQwSafeInputStream.a();
  }
  
  public void writeExternal(QwSafeOutputStream paramQwSafeOutputStream)
  {
    paramQwSafeOutputStream.a(this.elem.background);
    paramQwSafeOutputStream.a(this.elem.icon);
    paramQwSafeOutputStream.a(this.elem.title);
    paramQwSafeOutputStream.a(this.elem.subTitle);
    paramQwSafeOutputStream.a(this.elem.content);
    paramQwSafeOutputStream.a(this.elem.linkUrl);
    paramQwSafeOutputStream.a(this.elem.blackStripe);
    paramQwSafeOutputStream.a(this.elem.notice);
    paramQwSafeOutputStream.a(this.channelId);
    paramQwSafeOutputStream.a(this.templateId);
    paramQwSafeOutputStream.a(this.resend);
    paramQwSafeOutputStream.a(this.elem.titleColor);
    paramQwSafeOutputStream.a(this.elem.subtitleColor);
    paramQwSafeOutputStream.a(this.elem.actionsPriority);
    paramQwSafeOutputStream.a(this.elem.jumpUrl);
    paramQwSafeOutputStream.a(this.elem.nativeAndroid);
    paramQwSafeOutputStream.a(this.elem.iconUrl);
    paramQwSafeOutputStream.a(this.elem.contentColor);
    paramQwSafeOutputStream.a(this.elem.contentBgColor);
    paramQwSafeOutputStream.a(this.elem.aioImageLeft);
    paramQwSafeOutputStream.a(this.elem.aioImageRight);
    paramQwSafeOutputStream.a(this.elem.cftImage);
    paramQwSafeOutputStream.a(this.body.pfa_type);
    paramQwSafeOutputStream.a(this.elem.generateJsonParams());
    paramQwSafeOutputStream.a(this.listId);
  }
  
  public void writeHeader(QwSafeOutputStream paramQwSafeOutputStream, int paramInt)
  {
    paramQwSafeOutputStream.a(32);
    paramQwSafeOutputStream.a(1);
    paramQwSafeOutputStream.a(4);
    paramQwSafeOutputStream.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQWalletTransferMsg
 * JD-Core Version:    0.7.0.1
 */