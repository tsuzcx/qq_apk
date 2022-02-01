package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.safestream.ISafeStream;
import cooperation.qwallet.safestream.QwSafeInputStream;
import cooperation.qwallet.safestream.QwSafeOutputStream;
import java.util.ArrayList;
import java.util.List;
import tencent.im.msg.im_msg_body.QQWalletAioBody;

public class QQWalletRedPacketMsg
  implements ISafeStream
{
  public String authkey;
  public QQWalletAioBodyReserve body;
  private int channelId;
  public int conftype;
  public QQWalletBaseMsgElem elem;
  public String envelopeName;
  public int envelopeid;
  public boolean isOpened;
  public int msgFrom;
  public int redChannel;
  public String redPacketId;
  public String redPacketIndex;
  public int redtype;
  private int resend;
  public List<Long> specifyUinList = new ArrayList();
  public int templateId;
  
  public QQWalletRedPacketMsg()
  {
    this.body = new QQWalletAioBodyReserve();
  }
  
  public QQWalletRedPacketMsg(im_msg_body.QQWalletAioBody paramQQWalletAioBody, String paramString)
  {
    if ((paramQQWalletAioBody == null) || (TextUtils.isEmpty(paramString)))
    {
      this.body = new QQWalletAioBodyReserve();
      return;
    }
    this.elem = new QQWalletBaseMsgElem(paramQQWalletAioBody.receiver);
    this.body = new QQWalletAioBodyReserve(paramQQWalletAioBody);
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
        QLog.d("Q.msg.qqwalletmsg", 2, "QQWalletRedPacketMsg write Exception", localException1);
        localObject2 = localObject1;
      }
    }
  }
  
  public void readExternal(QwSafeInputStream paramQwSafeInputStream)
  {
    this.elem = new QQWalletBaseMsgElem();
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
    this.redtype = paramQwSafeInputStream.a();
    this.redPacketId = paramQwSafeInputStream.a();
    this.authkey = paramQwSafeInputStream.a();
    this.isOpened = paramQwSafeInputStream.a();
    this.elem.titleColor = paramQwSafeInputStream.a();
    this.elem.subtitleColor = paramQwSafeInputStream.a();
    this.elem.actionsPriority = paramQwSafeInputStream.a();
    this.elem.jumpUrl = paramQwSafeInputStream.a();
    this.elem.nativeAndroid = paramQwSafeInputStream.a();
    this.elem.iconUrl = paramQwSafeInputStream.a();
    this.elem.contentColor = paramQwSafeInputStream.a(13487565);
    this.elem.contentBgColor = paramQwSafeInputStream.a(-1);
    this.elem.aioImageLeft = paramQwSafeInputStream.a();
    this.elem.aioImageRight = paramQwSafeInputStream.a();
    this.elem.cftImage = paramQwSafeInputStream.a();
    this.envelopeid = paramQwSafeInputStream.a(-1);
    this.envelopeName = paramQwSafeInputStream.a();
    this.conftype = paramQwSafeInputStream.a(-1);
    this.msgFrom = paramQwSafeInputStream.a(-1);
    this.redPacketIndex = paramQwSafeInputStream.a();
    this.redChannel = paramQwSafeInputStream.a();
    this.specifyUinList = ((List)paramQwSafeInputStream.a(new ArrayList()));
    this.elem.soundRecordDuration = paramQwSafeInputStream.a(12000);
    this.elem.resourceType = paramQwSafeInputStream.a();
    this.elem.skinId = paramQwSafeInputStream.a();
    this.elem.effectsId = paramQwSafeInputStream.a();
    this.elem.special_pop_id = paramQwSafeInputStream.a();
    this.elem.themeId = paramQwSafeInputStream.a();
    this.elem.hbFrom = paramQwSafeInputStream.a();
    this.elem.songId = paramQwSafeInputStream.a();
    this.elem.songFlag = paramQwSafeInputStream.a();
    this.body.feedId = paramQwSafeInputStream.a();
    this.elem.lastPinyin = paramQwSafeInputStream.a();
    this.body.subChannel = paramQwSafeInputStream.a();
    this.body.poemRule = paramQwSafeInputStream.a();
    this.body.makeHbExtend = paramQwSafeInputStream.a();
    if (QLog.isColorLevel()) {
      QLog.d("QQWalletRedPacketMsg", 2, "readExternal redtype=" + this.redtype + ", skinId=" + this.elem.skinId + ", effectsId=" + this.elem.effectsId + ", special_pop_id=" + this.elem.special_pop_id + ", themeId=" + this.elem.themeId);
    }
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
    paramQwSafeOutputStream.a(this.redtype);
    paramQwSafeOutputStream.a(this.redPacketId);
    paramQwSafeOutputStream.a(this.authkey);
    paramQwSafeOutputStream.a(this.isOpened);
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
    paramQwSafeOutputStream.a(this.envelopeid);
    paramQwSafeOutputStream.a(this.envelopeName);
    paramQwSafeOutputStream.a(this.conftype);
    paramQwSafeOutputStream.a(this.msgFrom);
    paramQwSafeOutputStream.a(this.redPacketIndex);
    paramQwSafeOutputStream.a(this.redChannel);
    paramQwSafeOutputStream.a(this.specifyUinList);
    paramQwSafeOutputStream.a(this.elem.soundRecordDuration);
    paramQwSafeOutputStream.a(this.elem.resourceType);
    paramQwSafeOutputStream.a(this.elem.skinId);
    paramQwSafeOutputStream.a(this.elem.effectsId);
    paramQwSafeOutputStream.a(this.elem.special_pop_id);
    paramQwSafeOutputStream.a(this.elem.themeId);
    paramQwSafeOutputStream.a(this.elem.hbFrom);
    paramQwSafeOutputStream.a(this.elem.songId);
    paramQwSafeOutputStream.a(this.elem.songFlag);
    paramQwSafeOutputStream.a(this.body.feedId);
    paramQwSafeOutputStream.a(this.elem.lastPinyin);
    paramQwSafeOutputStream.a(this.body.subChannel);
    paramQwSafeOutputStream.a(this.body.poemRule);
    paramQwSafeOutputStream.a(this.body.makeHbExtend);
  }
  
  public void writeHeader(QwSafeOutputStream paramQwSafeOutputStream, int paramInt)
  {
    paramQwSafeOutputStream.a(32);
    paramQwSafeOutputStream.a(2);
    paramQwSafeOutputStream.a(2);
    paramQwSafeOutputStream.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQWalletRedPacketMsg
 * JD-Core Version:    0.7.0.1
 */