package com.tencent.mobileqq.data;

import android.text.TextUtils;
import bmsb;
import bmsc;
import bmsd;
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
  implements bmsb
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
        QLog.d("Q.msg.qqwalletmsg", 2, "QQWalletRedPacketMsg write Exception", localException1);
        localObject2 = localObject1;
      }
    }
  }
  
  public void readExternal(bmsc parambmsc)
  {
    this.elem = new QQWalletBaseMsgElem();
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
    this.redtype = parambmsc.a();
    this.redPacketId = parambmsc.a();
    this.authkey = parambmsc.a();
    this.isOpened = parambmsc.a();
    this.elem.titleColor = parambmsc.a();
    this.elem.subtitleColor = parambmsc.a();
    this.elem.actionsPriority = parambmsc.a();
    this.elem.jumpUrl = parambmsc.a();
    this.elem.nativeAndroid = parambmsc.a();
    this.elem.iconUrl = parambmsc.a();
    this.elem.contentColor = parambmsc.a(13487565);
    this.elem.contentBgColor = parambmsc.a(-1);
    this.elem.aioImageLeft = parambmsc.a();
    this.elem.aioImageRight = parambmsc.a();
    this.elem.cftImage = parambmsc.a();
    this.envelopeid = parambmsc.a(-1);
    this.envelopeName = parambmsc.a();
    this.conftype = parambmsc.a(-1);
    this.msgFrom = parambmsc.a(-1);
    this.redPacketIndex = parambmsc.a();
    this.redChannel = parambmsc.a();
    this.specifyUinList = ((List)parambmsc.a(new ArrayList()));
    this.elem.soundRecordDuration = parambmsc.a(12000);
    this.elem.resourceType = parambmsc.a();
    this.elem.skinId = parambmsc.a();
    this.elem.effectsId = parambmsc.a();
    this.elem.special_pop_id = parambmsc.a();
    this.elem.themeId = parambmsc.a();
    this.elem.hbFrom = parambmsc.a();
    this.elem.songId = parambmsc.a();
    this.elem.songFlag = parambmsc.a();
    this.body.feedId = parambmsc.a();
    this.elem.lastPinyin = parambmsc.a();
    this.body.subChannel = parambmsc.a();
    this.body.poemRule = parambmsc.a();
    this.body.makeHbExtend = parambmsc.a();
    if (QLog.isColorLevel()) {
      QLog.d("QQWalletRedPacketMsg", 2, "readExternal redtype=" + this.redtype + ", skinId=" + this.elem.skinId + ", effectsId=" + this.elem.effectsId + ", special_pop_id=" + this.elem.special_pop_id + ", themeId=" + this.elem.themeId);
    }
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
    parambmsd.a(this.redtype);
    parambmsd.a(this.redPacketId);
    parambmsd.a(this.authkey);
    parambmsd.a(this.isOpened);
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
    parambmsd.a(this.envelopeid);
    parambmsd.a(this.envelopeName);
    parambmsd.a(this.conftype);
    parambmsd.a(this.msgFrom);
    parambmsd.a(this.redPacketIndex);
    parambmsd.a(this.redChannel);
    parambmsd.a(this.specifyUinList);
    parambmsd.a(this.elem.soundRecordDuration);
    parambmsd.a(this.elem.resourceType);
    parambmsd.a(this.elem.skinId);
    parambmsd.a(this.elem.effectsId);
    parambmsd.a(this.elem.special_pop_id);
    parambmsd.a(this.elem.themeId);
    parambmsd.a(this.elem.hbFrom);
    parambmsd.a(this.elem.songId);
    parambmsd.a(this.elem.songFlag);
    parambmsd.a(this.body.feedId);
    parambmsd.a(this.elem.lastPinyin);
    parambmsd.a(this.body.subChannel);
    parambmsd.a(this.body.poemRule);
    parambmsd.a(this.body.makeHbExtend);
  }
  
  public void writeHeader(bmsd parambmsd, int paramInt)
  {
    parambmsd.a(32);
    parambmsd.a(2);
    parambmsd.a(2);
    parambmsd.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQWalletRedPacketMsg
 * JD-Core Version:    0.7.0.1
 */