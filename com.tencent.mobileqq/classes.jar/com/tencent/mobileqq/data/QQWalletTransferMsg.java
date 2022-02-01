package com.tencent.mobileqq.data;

import android.text.TextUtils;
import bmsb;
import bmsc;
import bmsd;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.QQWalletAioBody;

public class QQWalletTransferMsg
  implements bmsb
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
        localObject1 = new bmsd();
        localObject2 = localObject1;
      }
      catch (Exception localException1)
      {
        try
        {
          writeHeader((bmsd)localObject1, paramInt);
          writeExternal((bmsd)localObject1);
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
  
  public void readExternal(bmsc parambmsc)
  {
    this.elem.background = parambmsc.a();
    this.elem.icon = parambmsc.a();
    this.elem.title = parambmsc.a();
    this.elem.subTitle = parambmsc.a();
    this.elem.content = parambmsc.a();
    this.elem.linkUrl = parambmsc.a();
    this.elem.blackStripe = parambmsc.a();
    this.elem.notice = parambmsc.a();
    this.channelId = parambmsc.a();
    this.templateId = parambmsc.a();
    this.resend = parambmsc.a();
    this.elem.titleColor = parambmsc.a(-1);
    this.elem.subtitleColor = parambmsc.a(-1);
    this.elem.actionsPriority = parambmsc.a();
    this.elem.jumpUrl = parambmsc.a();
    this.elem.nativeAndroid = parambmsc.a();
    this.elem.iconUrl = parambmsc.a();
    this.elem.contentColor = parambmsc.a(13487565);
    this.elem.contentBgColor = parambmsc.a(-1);
    this.elem.aioImageLeft = parambmsc.a();
    this.elem.aioImageRight = parambmsc.a();
    this.elem.cftImage = parambmsc.a();
    this.body.pfa_type = parambmsc.a();
    this.elem.readJsonParams(parambmsc.a());
    this.listId = parambmsc.a();
  }
  
  public void writeExternal(bmsd parambmsd)
  {
    parambmsd.a(this.elem.background);
    parambmsd.a(this.elem.icon);
    parambmsd.a(this.elem.title);
    parambmsd.a(this.elem.subTitle);
    parambmsd.a(this.elem.content);
    parambmsd.a(this.elem.linkUrl);
    parambmsd.a(this.elem.blackStripe);
    parambmsd.a(this.elem.notice);
    parambmsd.a(this.channelId);
    parambmsd.a(this.templateId);
    parambmsd.a(this.resend);
    parambmsd.a(this.elem.titleColor);
    parambmsd.a(this.elem.subtitleColor);
    parambmsd.a(this.elem.actionsPriority);
    parambmsd.a(this.elem.jumpUrl);
    parambmsd.a(this.elem.nativeAndroid);
    parambmsd.a(this.elem.iconUrl);
    parambmsd.a(this.elem.contentColor);
    parambmsd.a(this.elem.contentBgColor);
    parambmsd.a(this.elem.aioImageLeft);
    parambmsd.a(this.elem.aioImageRight);
    parambmsd.a(this.elem.cftImage);
    parambmsd.a(this.body.pfa_type);
    parambmsd.a(this.elem.generateJsonParams());
    parambmsd.a(this.listId);
  }
  
  public void writeHeader(bmsd parambmsd, int paramInt)
  {
    parambmsd.a(32);
    parambmsd.a(1);
    parambmsd.a(4);
    parambmsd.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQWalletTransferMsg
 * JD-Core Version:    0.7.0.1
 */