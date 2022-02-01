package com.tencent.mobileqq.data;

import android.text.TextUtils;
import bmhr;
import bmhs;
import bmht;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.QQWalletAioBody;

public class QQWalletTransferMsg
  implements bmhr
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
        localObject1 = new bmht();
        localObject2 = localObject1;
      }
      catch (Exception localException1)
      {
        try
        {
          writeHeader((bmht)localObject1, paramInt);
          writeExternal((bmht)localObject1);
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
  
  public void readExternal(bmhs parambmhs)
  {
    this.elem.background = parambmhs.a();
    this.elem.icon = parambmhs.a();
    this.elem.title = parambmhs.a();
    this.elem.subTitle = parambmhs.a();
    this.elem.content = parambmhs.a();
    this.elem.linkUrl = parambmhs.a();
    this.elem.blackStripe = parambmhs.a();
    this.elem.notice = parambmhs.a();
    this.channelId = parambmhs.a();
    this.templateId = parambmhs.a();
    this.resend = parambmhs.a();
    this.elem.titleColor = parambmhs.a(-1);
    this.elem.subtitleColor = parambmhs.a(-1);
    this.elem.actionsPriority = parambmhs.a();
    this.elem.jumpUrl = parambmhs.a();
    this.elem.nativeAndroid = parambmhs.a();
    this.elem.iconUrl = parambmhs.a();
    this.elem.contentColor = parambmhs.a(13487565);
    this.elem.contentBgColor = parambmhs.a(-1);
    this.elem.aioImageLeft = parambmhs.a();
    this.elem.aioImageRight = parambmhs.a();
    this.elem.cftImage = parambmhs.a();
    this.body.pfa_type = parambmhs.a();
    this.elem.readJsonParams(parambmhs.a());
    this.listId = parambmhs.a();
  }
  
  public void writeExternal(bmht parambmht)
  {
    parambmht.a(this.elem.background);
    parambmht.a(this.elem.icon);
    parambmht.a(this.elem.title);
    parambmht.a(this.elem.subTitle);
    parambmht.a(this.elem.content);
    parambmht.a(this.elem.linkUrl);
    parambmht.a(this.elem.blackStripe);
    parambmht.a(this.elem.notice);
    parambmht.a(this.channelId);
    parambmht.a(this.templateId);
    parambmht.a(this.resend);
    parambmht.a(this.elem.titleColor);
    parambmht.a(this.elem.subtitleColor);
    parambmht.a(this.elem.actionsPriority);
    parambmht.a(this.elem.jumpUrl);
    parambmht.a(this.elem.nativeAndroid);
    parambmht.a(this.elem.iconUrl);
    parambmht.a(this.elem.contentColor);
    parambmht.a(this.elem.contentBgColor);
    parambmht.a(this.elem.aioImageLeft);
    parambmht.a(this.elem.aioImageRight);
    parambmht.a(this.elem.cftImage);
    parambmht.a(this.body.pfa_type);
    parambmht.a(this.elem.generateJsonParams());
    parambmht.a(this.listId);
  }
  
  public void writeHeader(bmht parambmht, int paramInt)
  {
    parambmht.a(32);
    parambmht.a(1);
    parambmht.a(4);
    parambmht.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQWalletTransferMsg
 * JD-Core Version:    0.7.0.1
 */