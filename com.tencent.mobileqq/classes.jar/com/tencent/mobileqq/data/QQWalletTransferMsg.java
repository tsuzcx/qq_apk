package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import tencent.im.msg.im_msg_body.QQWalletAioBody;

public class QQWalletTransferMsg
{
  public QQWalletAioBodys body;
  private int channelId;
  public QQWalletTransferMsgElem elem;
  public String listId;
  private int resend;
  public int templateId;
  
  public QQWalletTransferMsg()
  {
    this.body = new QQWalletAioBodys();
    this.elem = new QQWalletTransferMsgElem();
  }
  
  public QQWalletTransferMsg(im_msg_body.QQWalletAioBody paramQQWalletAioBody, String paramString)
  {
    if ((paramQQWalletAioBody == null) || (TextUtils.isEmpty(paramString)))
    {
      this.body = new QQWalletAioBodys();
      this.elem = new QQWalletTransferMsgElem();
      return;
    }
    if ((paramQQWalletAioBody.sint32_msgtype.has()) && (paramQQWalletAioBody.sint32_msgtype.get() == 16)) {
      this.elem = new QQWalletTransferMsgElem(paramQQWalletAioBody.receiver);
    }
    for (;;)
    {
      this.channelId = paramQQWalletAioBody.sint32_channelid.get();
      this.templateId = paramQQWalletAioBody.sint32_templateid.get();
      this.resend = paramQQWalletAioBody.uint32_resend.get();
      if (paramQQWalletAioBody.bytes_billno.has()) {
        this.listId = paramQQWalletAioBody.bytes_billno.get().toStringUtf8();
      }
      this.body = new QQWalletAioBodys(paramQQWalletAioBody);
      return;
      long l = paramQQWalletAioBody.uint64_senduin.get();
      if ((l != 0L) && (paramString.compareTo("" + l) == 0)) {
        this.elem = new QQWalletTransferMsgElem(paramQQWalletAioBody.sender);
      } else {
        this.elem = new QQWalletTransferMsgElem(paramQQWalletAioBody.receiver);
      }
    }
  }
  
  public void readExternal(int paramInt, ObjectInput paramObjectInput)
  {
    this.elem.background = paramObjectInput.readInt();
    this.elem.icon = paramObjectInput.readInt();
    this.elem.title = paramObjectInput.readUTF();
    this.elem.subTitle = paramObjectInput.readUTF();
    this.elem.content = paramObjectInput.readUTF();
    this.elem.linkUrl = paramObjectInput.readUTF();
    this.elem.blackStripe = paramObjectInput.readUTF();
    this.elem.notice = paramObjectInput.readUTF();
    this.channelId = paramObjectInput.readInt();
    this.templateId = paramObjectInput.readInt();
    this.resend = paramObjectInput.readInt();
    if (paramInt == 1)
    {
      this.elem.titleColor = -1;
      this.elem.subtitleColor = -1;
      this.elem.actionsPriority = "";
      this.elem.jumpUrl = "";
      this.elem.nativeAndroid = "";
      this.elem.iconUrl = "";
      this.elem.contentColor = 13487565;
      this.elem.contentBgColor = -1;
      this.elem.aioImageLeft = "";
      this.elem.aioImageRight = "";
      this.elem.cftImage = "";
    }
    do
    {
      return;
      if (paramInt == 2)
      {
        this.elem.titleColor = paramObjectInput.readInt();
        this.elem.subtitleColor = paramObjectInput.readInt();
        this.elem.actionsPriority = paramObjectInput.readUTF();
        this.elem.jumpUrl = paramObjectInput.readUTF();
        this.elem.nativeAndroid = paramObjectInput.readUTF();
        this.elem.iconUrl = "";
        this.elem.contentColor = 13487565;
        this.elem.contentBgColor = -1;
        this.elem.aioImageLeft = "";
        this.elem.aioImageRight = "";
        this.elem.cftImage = "";
        return;
      }
      if (paramInt == 3)
      {
        this.elem.titleColor = paramObjectInput.readInt();
        this.elem.subtitleColor = paramObjectInput.readInt();
        this.elem.actionsPriority = paramObjectInput.readUTF();
        this.elem.jumpUrl = paramObjectInput.readUTF();
        this.elem.nativeAndroid = paramObjectInput.readUTF();
        this.elem.iconUrl = paramObjectInput.readUTF();
        this.elem.contentColor = paramObjectInput.readInt();
        this.elem.contentBgColor = paramObjectInput.readInt();
        this.elem.aioImageLeft = paramObjectInput.readUTF();
        this.elem.aioImageRight = paramObjectInput.readUTF();
        this.elem.cftImage = paramObjectInput.readUTF();
        return;
      }
    } while (paramInt != 4);
    try
    {
      this.elem.titleColor = paramObjectInput.readInt();
      this.elem.subtitleColor = paramObjectInput.readInt();
      this.elem.actionsPriority = paramObjectInput.readUTF();
      this.elem.jumpUrl = paramObjectInput.readUTF();
      this.elem.nativeAndroid = paramObjectInput.readUTF();
      this.elem.iconUrl = paramObjectInput.readUTF();
      this.elem.contentColor = paramObjectInput.readInt();
      this.elem.contentBgColor = paramObjectInput.readInt();
      this.elem.aioImageLeft = paramObjectInput.readUTF();
      this.elem.aioImageRight = paramObjectInput.readUTF();
      this.elem.cftImage = paramObjectInput.readUTF();
      this.body.pfa_type = paramObjectInput.readInt();
      this.elem.readJsonParams(paramObjectInput.readUTF());
      this.listId = paramObjectInput.readUTF();
      return;
    }
    catch (Exception paramObjectInput) {}
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(this.elem.background);
    paramObjectOutput.writeInt(this.elem.icon);
    paramObjectOutput.writeUTF(this.elem.title);
    paramObjectOutput.writeUTF(this.elem.subTitle);
    paramObjectOutput.writeUTF(this.elem.content);
    paramObjectOutput.writeUTF(this.elem.linkUrl);
    paramObjectOutput.writeUTF(this.elem.blackStripe);
    paramObjectOutput.writeUTF(this.elem.notice);
    paramObjectOutput.writeInt(this.channelId);
    paramObjectOutput.writeInt(this.templateId);
    paramObjectOutput.writeInt(this.resend);
    paramObjectOutput.writeInt(this.elem.titleColor);
    paramObjectOutput.writeInt(this.elem.subtitleColor);
    paramObjectOutput.writeUTF(this.elem.actionsPriority);
    paramObjectOutput.writeUTF(this.elem.jumpUrl);
    paramObjectOutput.writeUTF(this.elem.nativeAndroid);
    paramObjectOutput.writeUTF(this.elem.iconUrl);
    paramObjectOutput.writeInt(this.elem.contentColor);
    paramObjectOutput.writeInt(this.elem.contentBgColor);
    paramObjectOutput.writeUTF(this.elem.aioImageLeft);
    paramObjectOutput.writeUTF(this.elem.aioImageRight);
    paramObjectOutput.writeUTF(this.elem.cftImage);
    paramObjectOutput.writeInt(this.body.pfa_type);
    paramObjectOutput.writeUTF(this.elem.generateJsonParams());
    if (this.listId == null) {}
    for (String str = "";; str = this.listId)
    {
      paramObjectOutput.writeUTF(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQWalletTransferMsg
 * JD-Core Version:    0.7.0.1
 */