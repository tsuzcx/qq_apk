package com.tencent.mobileqq.data;

import android.text.TextUtils;
import blqz;
import blra;
import blrb;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.QQWalletAioBody;

public class QQWalletTransferMsg
  implements blqz
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
        localObject1 = new blrb();
        localObject2 = localObject1;
      }
      catch (Exception localException1)
      {
        try
        {
          writeHeader((blrb)localObject1, paramInt);
          writeExternal((blrb)localObject1);
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
  
  public void readExternal(blra paramblra)
  {
    this.elem.background = paramblra.a();
    this.elem.icon = paramblra.a();
    this.elem.title = paramblra.a();
    this.elem.subTitle = paramblra.a();
    this.elem.content = paramblra.a();
    this.elem.linkUrl = paramblra.a();
    this.elem.blackStripe = paramblra.a();
    this.elem.notice = paramblra.a();
    this.channelId = paramblra.a();
    this.templateId = paramblra.a();
    this.resend = paramblra.a();
    this.elem.titleColor = paramblra.a(-1);
    this.elem.subtitleColor = paramblra.a(-1);
    this.elem.actionsPriority = paramblra.a();
    this.elem.jumpUrl = paramblra.a();
    this.elem.nativeAndroid = paramblra.a();
    this.elem.iconUrl = paramblra.a();
    this.elem.contentColor = paramblra.a(13487565);
    this.elem.contentBgColor = paramblra.a(-1);
    this.elem.aioImageLeft = paramblra.a();
    this.elem.aioImageRight = paramblra.a();
    this.elem.cftImage = paramblra.a();
    this.body.pfa_type = paramblra.a();
    this.elem.readJsonParams(paramblra.a());
    this.listId = paramblra.a();
  }
  
  public void writeExternal(blrb paramblrb)
  {
    paramblrb.a(this.elem.background);
    paramblrb.a(this.elem.icon);
    paramblrb.a(this.elem.title);
    paramblrb.a(this.elem.subTitle);
    paramblrb.a(this.elem.content);
    paramblrb.a(this.elem.linkUrl);
    paramblrb.a(this.elem.blackStripe);
    paramblrb.a(this.elem.notice);
    paramblrb.a(this.channelId);
    paramblrb.a(this.templateId);
    paramblrb.a(this.resend);
    paramblrb.a(this.elem.titleColor);
    paramblrb.a(this.elem.subtitleColor);
    paramblrb.a(this.elem.actionsPriority);
    paramblrb.a(this.elem.jumpUrl);
    paramblrb.a(this.elem.nativeAndroid);
    paramblrb.a(this.elem.iconUrl);
    paramblrb.a(this.elem.contentColor);
    paramblrb.a(this.elem.contentBgColor);
    paramblrb.a(this.elem.aioImageLeft);
    paramblrb.a(this.elem.aioImageRight);
    paramblrb.a(this.elem.cftImage);
    paramblrb.a(this.body.pfa_type);
    paramblrb.a(this.elem.generateJsonParams());
    paramblrb.a(this.listId);
  }
  
  public void writeHeader(blrb paramblrb, int paramInt)
  {
    paramblrb.a(32);
    paramblrb.a(1);
    paramblrb.a(4);
    paramblrb.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQWalletTransferMsg
 * JD-Core Version:    0.7.0.1
 */