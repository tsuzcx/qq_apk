package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;
import tencent.im.msg.im_msg_body.QQWalletAioBody;

public class QQWalletRedPacketMsg
{
  public String authkey;
  private int channelId;
  public int conftype;
  public QQWalletTransferMsgElem elem;
  public String envelopeName;
  public int envelopeid;
  public boolean isOpened;
  public int msgFrom;
  public int redChannel;
  public String redPacketId;
  public String redPacketIndex;
  public int redtype;
  private int resend;
  public List specifyUinList = new ArrayList();
  public int templateId;
  
  public QQWalletRedPacketMsg() {}
  
  public QQWalletRedPacketMsg(im_msg_body.QQWalletAioBody paramQQWalletAioBody, String paramString)
  {
    if ((paramQQWalletAioBody == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    this.elem = new QQWalletTransferMsgElem(paramQQWalletAioBody.receiver);
    this.channelId = paramQQWalletAioBody.sint32_channelid.get();
    this.templateId = paramQQWalletAioBody.sint32_templateid.get();
    this.resend = paramQQWalletAioBody.uint32_resend.get();
    this.redtype = paramQQWalletAioBody.sint32_redtype.get();
    this.redPacketId = paramQQWalletAioBody.bytes_billno.get().toStringUtf8();
    this.authkey = paramQQWalletAioBody.bytes_authkey.get().toStringUtf8();
    this.envelopeid = paramQQWalletAioBody.sint32_envelopeid.get();
    this.envelopeName = paramQQWalletAioBody.bytes_name.get().toStringUtf8();
    this.conftype = paramQQWalletAioBody.sint32_redtype.get();
    this.msgFrom = paramQQWalletAioBody.sint32_msg_from.get();
    this.redPacketIndex = paramQQWalletAioBody.string_index.get().toStringUtf8();
    paramString = paramQQWalletAioBody.uint64_grap_uin.get();
    if (paramString != null) {
      this.specifyUinList = paramString;
    }
    this.redChannel = paramQQWalletAioBody.uint32_redchannel.get();
  }
  
  private void readVersionUpgradeFiled(ObjectInput paramObjectInput)
  {
    try
    {
      this.elem.iconUrl = paramObjectInput.readUTF();
      this.elem.contentColor = paramObjectInput.readInt();
      this.elem.contentBgColor = paramObjectInput.readInt();
      this.elem.aioImageLeft = paramObjectInput.readUTF();
      this.elem.aioImageRight = paramObjectInput.readUTF();
      this.elem.cftImage = paramObjectInput.readUTF();
    }
    catch (IOException localException3)
    {
      try
      {
        this.envelopeid = paramObjectInput.readInt();
        this.envelopeName = paramObjectInput.readUTF();
        this.conftype = paramObjectInput.readInt();
      }
      catch (IOException localException3)
      {
        try
        {
          this.msgFrom = paramObjectInput.readInt();
        }
        catch (IOException localException3)
        {
          try
          {
            this.redPacketIndex = paramObjectInput.readUTF();
          }
          catch (IOException localException3)
          {
            try
            {
              this.redChannel = paramObjectInput.readInt();
              this.specifyUinList = ((List)paramObjectInput.readObject());
            }
            catch (Exception localException3)
            {
              try
              {
                this.elem.soundRecordDuration = paramObjectInput.readInt();
              }
              catch (Exception localException3)
              {
                try
                {
                  this.elem.resourceType = paramObjectInput.readInt();
                  this.elem.skinId = paramObjectInput.readInt();
                  this.elem.effectsId = paramObjectInput.readInt();
                  this.elem.special_pop_id = paramObjectInput.readInt();
                }
                catch (Exception localException3)
                {
                  try
                  {
                    for (;;)
                    {
                      this.elem.themeId = paramObjectInput.readInt();
                      try
                      {
                        this.elem.hbFrom = paramObjectInput.readInt();
                        return;
                      }
                      catch (Exception paramObjectInput)
                      {
                        this.elem.hbFrom = 0;
                      }
                      localIOException1 = localIOException1;
                      this.elem.iconUrl = "";
                      this.elem.contentColor = 13487565;
                      this.elem.contentBgColor = -1;
                      this.elem.aioImageLeft = "";
                      this.elem.aioImageRight = "";
                      this.elem.cftImage = "";
                      continue;
                      localIOException2 = localIOException2;
                      this.envelopeid = -1;
                      this.envelopeName = "";
                      this.conftype = -1;
                      continue;
                      localIOException3 = localIOException3;
                      this.msgFrom = -1;
                      continue;
                      localIOException4 = localIOException4;
                      this.redPacketIndex = "";
                      continue;
                      localException1 = localException1;
                      this.redChannel = 0;
                      this.specifyUinList = new ArrayList();
                      continue;
                      localException2 = localException2;
                      this.elem.soundRecordDuration = 12000;
                      continue;
                      localException3 = localException3;
                      this.elem.resourceType = 0;
                      this.elem.skinId = 0;
                      this.elem.effectsId = 0;
                      this.elem.special_pop_id = 0;
                    }
                  }
                  catch (Exception localException4)
                  {
                    for (;;)
                    {
                      this.elem.themeId = 0;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    this.elem = new QQWalletTransferMsgElem();
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
    this.redtype = paramObjectInput.readInt();
    this.redPacketId = paramObjectInput.readUTF();
    this.authkey = paramObjectInput.readUTF();
    this.isOpened = paramObjectInput.readBoolean();
    this.elem.titleColor = paramObjectInput.readInt();
    this.elem.subtitleColor = paramObjectInput.readInt();
    this.elem.actionsPriority = paramObjectInput.readUTF();
    this.elem.jumpUrl = paramObjectInput.readUTF();
    this.elem.nativeAndroid = paramObjectInput.readUTF();
    readVersionUpgradeFiled(paramObjectInput);
    if (QLog.isColorLevel()) {
      QLog.d("QQWalletRedPacketMsg", 2, "readExternal redtype=" + this.redtype + ", skinId=" + this.elem.skinId + ", effectsId=" + this.elem.effectsId + ", special_pop_id=" + this.elem.special_pop_id + ", themeId=" + this.elem.themeId);
    }
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
    paramObjectOutput.writeInt(this.redtype);
    paramObjectOutput.writeUTF(this.redPacketId);
    paramObjectOutput.writeUTF(this.authkey);
    paramObjectOutput.writeBoolean(this.isOpened);
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
    paramObjectOutput.writeInt(this.envelopeid);
    paramObjectOutput.writeUTF(this.envelopeName);
    paramObjectOutput.writeInt(this.conftype);
    paramObjectOutput.writeInt(this.msgFrom);
    paramObjectOutput.writeUTF(this.redPacketIndex);
    paramObjectOutput.writeInt(this.redChannel);
    paramObjectOutput.writeObject(this.specifyUinList);
    paramObjectOutput.writeInt(this.elem.soundRecordDuration);
    paramObjectOutput.writeInt(this.elem.resourceType);
    paramObjectOutput.writeInt(this.elem.skinId);
    paramObjectOutput.writeInt(this.elem.effectsId);
    paramObjectOutput.writeInt(this.elem.special_pop_id);
    paramObjectOutput.writeInt(this.elem.themeId);
    paramObjectOutput.writeInt(this.elem.hbFrom);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQWalletRedPacketMsg
 * JD-Core Version:    0.7.0.1
 */