package com.tencent.mobileqq.data;

import android.text.TextUtils;
import bmhr;
import bmhs;
import bmht;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.msg.im_msg_body.QQWalletAioBody;

public class QQWalletRedPacketMsg
  implements bmhr
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
        QLog.d("Q.msg.qqwalletmsg", 2, "QQWalletRedPacketMsg write Exception", localException1);
        localObject2 = localObject1;
      }
    }
  }
  
  public void readExternal(bmhs parambmhs)
  {
    this.elem = new QQWalletBaseMsgElem();
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
    this.redtype = parambmhs.a();
    this.redPacketId = parambmhs.a();
    this.authkey = parambmhs.a();
    this.isOpened = parambmhs.a();
    this.elem.titleColor = parambmhs.a();
    this.elem.subtitleColor = parambmhs.a();
    this.elem.actionsPriority = parambmhs.a();
    this.elem.jumpUrl = parambmhs.a();
    this.elem.nativeAndroid = parambmhs.a();
    this.elem.iconUrl = parambmhs.a();
    this.elem.contentColor = parambmhs.a(13487565);
    this.elem.contentBgColor = parambmhs.a(-1);
    this.elem.aioImageLeft = parambmhs.a();
    this.elem.aioImageRight = parambmhs.a();
    this.elem.cftImage = parambmhs.a();
    this.envelopeid = parambmhs.a(-1);
    this.envelopeName = parambmhs.a();
    this.conftype = parambmhs.a(-1);
    this.msgFrom = parambmhs.a(-1);
    this.redPacketIndex = parambmhs.a();
    this.redChannel = parambmhs.a();
    this.specifyUinList = ((List)parambmhs.a(new ArrayList()));
    this.elem.soundRecordDuration = parambmhs.a(12000);
    this.elem.resourceType = parambmhs.a();
    this.elem.skinId = parambmhs.a();
    this.elem.effectsId = parambmhs.a();
    this.elem.special_pop_id = parambmhs.a();
    this.elem.themeId = parambmhs.a();
    this.elem.hbFrom = parambmhs.a();
    this.elem.songId = parambmhs.a();
    this.elem.songFlag = parambmhs.a();
    this.body.feedId = parambmhs.a();
    this.elem.lastPinyin = parambmhs.a();
    this.body.subChannel = parambmhs.a();
    this.body.poemRule = parambmhs.a();
    this.body.makeHbExtend = parambmhs.a();
    if (QLog.isColorLevel()) {
      QLog.d("QQWalletRedPacketMsg", 2, "readExternal redtype=" + this.redtype + ", skinId=" + this.elem.skinId + ", effectsId=" + this.elem.effectsId + ", special_pop_id=" + this.elem.special_pop_id + ", themeId=" + this.elem.themeId);
    }
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
    parambmht.a(this.redtype);
    parambmht.a(this.redPacketId);
    parambmht.a(this.authkey);
    parambmht.a(this.isOpened);
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
    parambmht.a(this.envelopeid);
    parambmht.a(this.envelopeName);
    parambmht.a(this.conftype);
    parambmht.a(this.msgFrom);
    parambmht.a(this.redPacketIndex);
    parambmht.a(this.redChannel);
    parambmht.a(this.specifyUinList);
    parambmht.a(this.elem.soundRecordDuration);
    parambmht.a(this.elem.resourceType);
    parambmht.a(this.elem.skinId);
    parambmht.a(this.elem.effectsId);
    parambmht.a(this.elem.special_pop_id);
    parambmht.a(this.elem.themeId);
    parambmht.a(this.elem.hbFrom);
    parambmht.a(this.elem.songId);
    parambmht.a(this.elem.songFlag);
    parambmht.a(this.body.feedId);
    parambmht.a(this.elem.lastPinyin);
    parambmht.a(this.body.subChannel);
    parambmht.a(this.body.poemRule);
    parambmht.a(this.body.makeHbExtend);
  }
  
  public void writeHeader(bmht parambmht, int paramInt)
  {
    parambmht.a(32);
    parambmht.a(2);
    parambmht.a(2);
    parambmht.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQWalletRedPacketMsg
 * JD-Core Version:    0.7.0.1
 */