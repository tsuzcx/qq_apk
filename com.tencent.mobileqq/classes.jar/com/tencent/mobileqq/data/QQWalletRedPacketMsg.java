package com.tencent.mobileqq.data;

import android.text.TextUtils;
import bkwi;
import bkwj;
import bkwk;
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
  implements bkwi
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
        QLog.d("Q.msg.qqwalletmsg", 2, "QQWalletRedPacketMsg write Exception", localException1);
        localObject2 = localObject1;
      }
    }
  }
  
  public void readExternal(bkwj parambkwj)
  {
    this.elem = new QQWalletBaseMsgElem();
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
    this.redtype = parambkwj.a();
    this.redPacketId = parambkwj.a();
    this.authkey = parambkwj.a();
    this.isOpened = parambkwj.a();
    this.elem.titleColor = parambkwj.a();
    this.elem.subtitleColor = parambkwj.a();
    this.elem.actionsPriority = parambkwj.a();
    this.elem.jumpUrl = parambkwj.a();
    this.elem.nativeAndroid = parambkwj.a();
    this.elem.iconUrl = parambkwj.a();
    this.elem.contentColor = parambkwj.a(13487565);
    this.elem.contentBgColor = parambkwj.a(-1);
    this.elem.aioImageLeft = parambkwj.a();
    this.elem.aioImageRight = parambkwj.a();
    this.elem.cftImage = parambkwj.a();
    this.envelopeid = parambkwj.a(-1);
    this.envelopeName = parambkwj.a();
    this.conftype = parambkwj.a(-1);
    this.msgFrom = parambkwj.a(-1);
    this.redPacketIndex = parambkwj.a();
    this.redChannel = parambkwj.a();
    this.specifyUinList = ((List)parambkwj.a(new ArrayList()));
    this.elem.soundRecordDuration = parambkwj.a(12000);
    this.elem.resourceType = parambkwj.a();
    this.elem.skinId = parambkwj.a();
    this.elem.effectsId = parambkwj.a();
    this.elem.special_pop_id = parambkwj.a();
    this.elem.themeId = parambkwj.a();
    this.elem.hbFrom = parambkwj.a();
    this.elem.songId = parambkwj.a();
    this.elem.songFlag = parambkwj.a();
    this.body.feedId = parambkwj.a();
    this.elem.lastPinyin = parambkwj.a();
    this.body.subChannel = parambkwj.a();
    this.body.poemRule = parambkwj.a();
    this.body.makeHbExtend = parambkwj.a();
    if (QLog.isColorLevel()) {
      QLog.d("QQWalletRedPacketMsg", 2, "readExternal redtype=" + this.redtype + ", skinId=" + this.elem.skinId + ", effectsId=" + this.elem.effectsId + ", special_pop_id=" + this.elem.special_pop_id + ", themeId=" + this.elem.themeId);
    }
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
    parambkwk.a(this.redtype);
    parambkwk.a(this.redPacketId);
    parambkwk.a(this.authkey);
    parambkwk.a(this.isOpened);
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
    parambkwk.a(this.envelopeid);
    parambkwk.a(this.envelopeName);
    parambkwk.a(this.conftype);
    parambkwk.a(this.msgFrom);
    parambkwk.a(this.redPacketIndex);
    parambkwk.a(this.redChannel);
    parambkwk.a(this.specifyUinList);
    parambkwk.a(this.elem.soundRecordDuration);
    parambkwk.a(this.elem.resourceType);
    parambkwk.a(this.elem.skinId);
    parambkwk.a(this.elem.effectsId);
    parambkwk.a(this.elem.special_pop_id);
    parambkwk.a(this.elem.themeId);
    parambkwk.a(this.elem.hbFrom);
    parambkwk.a(this.elem.songId);
    parambkwk.a(this.elem.songFlag);
    parambkwk.a(this.body.feedId);
    parambkwk.a(this.elem.lastPinyin);
    parambkwk.a(this.body.subChannel);
    parambkwk.a(this.body.poemRule);
    parambkwk.a(this.body.makeHbExtend);
  }
  
  public void writeHeader(bkwk parambkwk, int paramInt)
  {
    parambkwk.a(32);
    parambkwk.a(2);
    parambkwk.a(2);
    parambkwk.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQWalletRedPacketMsg
 * JD-Core Version:    0.7.0.1
 */