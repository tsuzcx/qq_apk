package com.tencent.mobileqq.data;

import android.text.TextUtils;
import blqz;
import blra;
import blrb;
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
  implements blqz
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
        QLog.d("Q.msg.qqwalletmsg", 2, "QQWalletRedPacketMsg write Exception", localException1);
        localObject2 = localObject1;
      }
    }
  }
  
  public void readExternal(blra paramblra)
  {
    this.elem = new QQWalletBaseMsgElem();
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
    this.redtype = paramblra.a();
    this.redPacketId = paramblra.a();
    this.authkey = paramblra.a();
    this.isOpened = paramblra.a();
    this.elem.titleColor = paramblra.a();
    this.elem.subtitleColor = paramblra.a();
    this.elem.actionsPriority = paramblra.a();
    this.elem.jumpUrl = paramblra.a();
    this.elem.nativeAndroid = paramblra.a();
    this.elem.iconUrl = paramblra.a();
    this.elem.contentColor = paramblra.a(13487565);
    this.elem.contentBgColor = paramblra.a(-1);
    this.elem.aioImageLeft = paramblra.a();
    this.elem.aioImageRight = paramblra.a();
    this.elem.cftImage = paramblra.a();
    this.envelopeid = paramblra.a(-1);
    this.envelopeName = paramblra.a();
    this.conftype = paramblra.a(-1);
    this.msgFrom = paramblra.a(-1);
    this.redPacketIndex = paramblra.a();
    this.redChannel = paramblra.a();
    this.specifyUinList = ((List)paramblra.a(new ArrayList()));
    this.elem.soundRecordDuration = paramblra.a(12000);
    this.elem.resourceType = paramblra.a();
    this.elem.skinId = paramblra.a();
    this.elem.effectsId = paramblra.a();
    this.elem.special_pop_id = paramblra.a();
    this.elem.themeId = paramblra.a();
    this.elem.hbFrom = paramblra.a();
    this.elem.songId = paramblra.a();
    this.elem.songFlag = paramblra.a();
    this.body.feedId = paramblra.a();
    this.elem.lastPinyin = paramblra.a();
    this.body.subChannel = paramblra.a();
    this.body.poemRule = paramblra.a();
    this.body.makeHbExtend = paramblra.a();
    if (QLog.isColorLevel()) {
      QLog.d("QQWalletRedPacketMsg", 2, "readExternal redtype=" + this.redtype + ", skinId=" + this.elem.skinId + ", effectsId=" + this.elem.effectsId + ", special_pop_id=" + this.elem.special_pop_id + ", themeId=" + this.elem.themeId);
    }
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
    paramblrb.a(this.redtype);
    paramblrb.a(this.redPacketId);
    paramblrb.a(this.authkey);
    paramblrb.a(this.isOpened);
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
    paramblrb.a(this.envelopeid);
    paramblrb.a(this.envelopeName);
    paramblrb.a(this.conftype);
    paramblrb.a(this.msgFrom);
    paramblrb.a(this.redPacketIndex);
    paramblrb.a(this.redChannel);
    paramblrb.a(this.specifyUinList);
    paramblrb.a(this.elem.soundRecordDuration);
    paramblrb.a(this.elem.resourceType);
    paramblrb.a(this.elem.skinId);
    paramblrb.a(this.elem.effectsId);
    paramblrb.a(this.elem.special_pop_id);
    paramblrb.a(this.elem.themeId);
    paramblrb.a(this.elem.hbFrom);
    paramblrb.a(this.elem.songId);
    paramblrb.a(this.elem.songFlag);
    paramblrb.a(this.body.feedId);
    paramblrb.a(this.elem.lastPinyin);
    paramblrb.a(this.body.subChannel);
    paramblrb.a(this.body.poemRule);
    paramblrb.a(this.body.makeHbExtend);
  }
  
  public void writeHeader(blrb paramblrb, int paramInt)
  {
    paramblrb.a(32);
    paramblrb.a(2);
    paramblrb.a(2);
    paramblrb.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQWalletRedPacketMsg
 * JD-Core Version:    0.7.0.1
 */