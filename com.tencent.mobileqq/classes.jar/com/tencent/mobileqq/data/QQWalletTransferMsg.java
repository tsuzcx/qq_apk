package com.tencent.mobileqq.data;

import android.text.TextUtils;
import bkwi;
import bkwj;
import bkwk;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.QQWalletAioBody;

public class QQWalletTransferMsg
  implements bkwi
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
        localObject1 = new bkwk();
        localObject2 = localObject1;
      }
      catch (Exception localException1)
      {
        try
        {
          writeHeader((bkwk)localObject1, paramInt);
          writeExternal((bkwk)localObject1);
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
  
  public void readExternal(bkwj parambkwj)
  {
    this.elem.background = parambkwj.a();
    this.elem.icon = parambkwj.a();
    this.elem.title = parambkwj.a();
    this.elem.subTitle = parambkwj.a();
    this.elem.content = parambkwj.a();
    this.elem.linkUrl = parambkwj.a();
    this.elem.blackStripe = parambkwj.a();
    this.elem.notice = parambkwj.a();
    this.channelId = parambkwj.a();
    this.templateId = parambkwj.a();
    this.resend = parambkwj.a();
    this.elem.titleColor = parambkwj.a(-1);
    this.elem.subtitleColor = parambkwj.a(-1);
    this.elem.actionsPriority = parambkwj.a();
    this.elem.jumpUrl = parambkwj.a();
    this.elem.nativeAndroid = parambkwj.a();
    this.elem.iconUrl = parambkwj.a();
    this.elem.contentColor = parambkwj.a(13487565);
    this.elem.contentBgColor = parambkwj.a(-1);
    this.elem.aioImageLeft = parambkwj.a();
    this.elem.aioImageRight = parambkwj.a();
    this.elem.cftImage = parambkwj.a();
    this.body.pfa_type = parambkwj.a();
    this.elem.readJsonParams(parambkwj.a());
    this.listId = parambkwj.a();
  }
  
  public void writeExternal(bkwk parambkwk)
  {
    parambkwk.a(this.elem.background);
    parambkwk.a(this.elem.icon);
    parambkwk.a(this.elem.title);
    parambkwk.a(this.elem.subTitle);
    parambkwk.a(this.elem.content);
    parambkwk.a(this.elem.linkUrl);
    parambkwk.a(this.elem.blackStripe);
    parambkwk.a(this.elem.notice);
    parambkwk.a(this.channelId);
    parambkwk.a(this.templateId);
    parambkwk.a(this.resend);
    parambkwk.a(this.elem.titleColor);
    parambkwk.a(this.elem.subtitleColor);
    parambkwk.a(this.elem.actionsPriority);
    parambkwk.a(this.elem.jumpUrl);
    parambkwk.a(this.elem.nativeAndroid);
    parambkwk.a(this.elem.iconUrl);
    parambkwk.a(this.elem.contentColor);
    parambkwk.a(this.elem.contentBgColor);
    parambkwk.a(this.elem.aioImageLeft);
    parambkwk.a(this.elem.aioImageRight);
    parambkwk.a(this.elem.cftImage);
    parambkwk.a(this.body.pfa_type);
    parambkwk.a(this.elem.generateJsonParams());
    parambkwk.a(this.listId);
  }
  
  public void writeHeader(bkwk parambkwk, int paramInt)
  {
    parambkwk.a(32);
    parambkwk.a(1);
    parambkwk.a(4);
    parambkwk.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQWalletTransferMsg
 * JD-Core Version:    0.7.0.1
 */