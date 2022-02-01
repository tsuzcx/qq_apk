package com.tencent.mobileqq.service.message.codec.decoder.msgType0x210;

import android.os.Bundle;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QIMNewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QIMFollwerAdd;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.data.QIMNotifyAddFriend.VideoInfo;
import com.tencent.mobileqq.dating.DatingProxyManager;
import com.tencent.mobileqq.dating.widget.VoteEventMgr;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.manager.TicketManager;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.AddQimFriendNotifyToQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.ForwardBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.MCardNotificationLike;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.PushLostDevFound;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.QimFriendNotifyToQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.VideoInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.VipInfoNotify;

public class TurnBrandTipsDecoder
  implements SubTypeDecoder
{
  private void a(MessageHandler paramMessageHandler, SubMsgType0x6f.ForwardBody paramForwardBody)
  {
    paramForwardBody = (SubMsgType0x6f.QimFriendNotifyToQQ)paramForwardBody.msg_mod_qim_friend_to_qq.get();
    int i;
    if (paramForwardBody.uint32_notify_type.has()) {
      i = paramForwardBody.uint32_notify_type.get();
    } else {
      i = -1;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("receive msg_add_notify_to_qq... ");
      ((StringBuilder)localObject).append(i);
      QLog.d("QIMNewNotifyPush_offLine", 2, ((StringBuilder)localObject).toString());
    }
    if (i == 1)
    {
      if (paramForwardBody.msg_add_notify_to_qq.has())
      {
        paramForwardBody = paramForwardBody.msg_add_notify_to_qq;
        localObject = new QIMFollwerAdd();
        ((QIMFollwerAdd)localObject).uin = paramForwardBody.uint64_uin.get();
        ((QIMFollwerAdd)localObject).gender = paramForwardBody.uint32_gender.get();
        ((QIMFollwerAdd)localObject).careSCount = paramForwardBody.uint64_cares_count.get();
        ((QIMFollwerAdd)localObject).totalNum = paramForwardBody.uint64_storys_total_num.get();
        ((QIMFollwerAdd)localObject).smartRemark = paramForwardBody.bytes_smart_remark.get().toStringUtf8();
        ((QIMFollwerAdd)localObject).opType = paramForwardBody.uint32_op_type.get();
        ((QIMFollwerAdd)localObject).fansCount = paramForwardBody.uint64_fans_count.get();
        ((QIMFollwerAdd)localObject).longNick = RichStatus.parseStatus(paramForwardBody.bytes_longnick.get().toByteArray()).getPlainText();
        ((QIMFollwerAdd)localObject).upTime = MessageCache.a();
        ((QIMFollwerAdd)localObject).source = paramForwardBody.bytes_src_wording.get().toStringUtf8();
        ((INewFriendService)paramMessageHandler.a.getRuntimeService(INewFriendService.class)).handleQIMNewFollower((QIMFollwerAdd)localObject);
      }
    }
    else
    {
      if (i == 2) {
        return;
      }
      if ((i == 3) && (paramForwardBody.msg_add_not_login_frd_notify_to_qq.has()))
      {
        localObject = (SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)paramForwardBody.msg_add_not_login_frd_notify_to_qq.get();
        paramForwardBody = new QIMNotifyAddFriend();
        paramForwardBody.uin = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject).uint64_uin.get();
        paramForwardBody.qqUin = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject).uint64_qq_uin.get();
        paramForwardBody.nickName = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject).bytes_nick.get().toStringUtf8();
        paramForwardBody.gender = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject).uint32_gender.get();
        paramForwardBody.age = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject).uint32_age.get();
        paramForwardBody.coverStory = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject).bytes_coverstory.get().toStringUtf8();
        paramForwardBody.storyTotalNum = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject).uint64_storys_total_num.get();
        paramForwardBody.wording = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject).bytes_wording.get().toStringUtf8();
        i = 0;
        while (i < ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject).rpt_msg_video_info.size())
        {
          SubMsgType0x6f.VideoInfo localVideoInfo = (SubMsgType0x6f.VideoInfo)((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject).rpt_msg_video_info.get(i);
          QIMNotifyAddFriend.VideoInfo localVideoInfo1 = new QIMNotifyAddFriend.VideoInfo();
          localVideoInfo1.coverUrl = localVideoInfo.bytes_video_cover_url.get().toStringUtf8();
          localVideoInfo1.videoVid = localVideoInfo.bytes_vid.get().toStringUtf8();
          paramForwardBody.videoInfos.add(localVideoInfo1);
          i += 1;
        }
        paramForwardBody.pushTime = MessageCache.a();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("receive data= ");
          ((StringBuilder)localObject).append(paramForwardBody.toString());
          QLog.d("QIMNewNotifyPush_offLine", 2, ((StringBuilder)localObject).toString());
        }
        ((QIMNewFriendManager)paramMessageHandler.a.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).a(paramForwardBody);
      }
    }
  }
  
  private void b(MessageHandler paramMessageHandler, SubMsgType0x6f.ForwardBody paramForwardBody)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFindBLE", 2, "offlinePush receive ...");
    }
    paramForwardBody = (SubMsgType0x6f.PushLostDevFound)paramForwardBody.msg_push_lost_dev_found.get();
    Bundle localBundle = new Bundle();
    if (paramForwardBody.uint32_msg_type.has()) {
      localBundle.putInt("msgtype", paramForwardBody.uint32_msg_type.get());
    }
    if (paramForwardBody.uint32_dev_time.has()) {
      localBundle.putInt("devtime", paramForwardBody.uint32_dev_time.get());
    }
    if (paramForwardBody.uint64_din.has()) {
      localBundle.putLong("din", paramForwardBody.uint64_din.get());
    }
    ((SmartDeviceProxyMgr)paramMessageHandler.a.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(111, localBundle);
  }
  
  private void c(MessageHandler paramMessageHandler, SubMsgType0x6f.ForwardBody paramForwardBody)
  {
    Object localObject = (SubMsgType0x6f.VipInfoNotify)paramForwardBody.msg_vip_info_notify.get();
    if (QLog.isColorLevel())
    {
      paramForwardBody = new StringBuilder();
      paramForwardBody.append("vip info notify: ");
      paramForwardBody.append(localObject.toString());
      QLog.d("TurnBrandTipsDecoder", 2, paramForwardBody.toString());
    }
    long l = 0L;
    if (((SubMsgType0x6f.VipInfoNotify)localObject).uint64_uin.has()) {
      l = ((SubMsgType0x6f.VipInfoNotify)localObject).uint64_uin.get();
    }
    paramForwardBody = Long.toString(l);
    boolean bool = ((SubMsgType0x6f.VipInfoNotify)localObject).uint32_vip_identify.has();
    int j = 0;
    int i;
    if (bool) {
      i = ((SubMsgType0x6f.VipInfoNotify)localObject).uint32_vip_identify.get();
    } else {
      i = 0;
    }
    if (((SubMsgType0x6f.VipInfoNotify)localObject).uint32_vip_level.has()) {
      j = ((SubMsgType0x6f.VipInfoNotify)localObject).uint32_vip_level.get();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("UIN ");
      ((StringBuilder)localObject).append(paramForwardBody);
      ((StringBuilder)localObject).append(" vip info changed.");
      QLog.d("TurnBrandTipsDecoder", 2, ((StringBuilder)localObject).toString());
    }
    if ((i != 0) || (j != 0))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("need pull vip info from svr. vipIdentiy=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("; vipLevel=");
        ((StringBuilder)localObject).append(j);
        QLog.d("TurnBrandTipsDecoder", 2, ((StringBuilder)localObject).toString());
      }
      localObject = ((TicketManager)paramMessageHandler.a.getManager(2)).getSkey(paramForwardBody);
      ((VipInfoHandler)paramMessageHandler.a.getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).a((String)localObject, paramForwardBody);
    }
  }
  
  private void d(MessageHandler paramMessageHandler, SubMsgType0x6f.ForwardBody paramForwardBody)
  {
    SubMsgType0x6f.MCardNotificationLike localMCardNotificationLike = (SubMsgType0x6f.MCardNotificationLike)paramForwardBody.msg_mcard_notification_like.get();
    if (localMCardNotificationLike.str_wording.has()) {
      paramForwardBody = localMCardNotificationLike.str_wording.get();
    } else {
      paramForwardBody = "";
    }
    boolean bool = localMCardNotificationLike.uint32_counter_new.has();
    int j = 0;
    int i;
    if (bool) {
      i = localMCardNotificationLike.uint32_counter_new.get();
    } else {
      i = 0;
    }
    long l;
    if (localMCardNotificationLike.uint64_from_uin.has()) {
      l = localMCardNotificationLike.uint64_from_uin.get();
    } else {
      l = 0L;
    }
    if (localMCardNotificationLike.uint32_counter_total.has()) {
      j = localMCardNotificationLike.uint32_counter_total.get();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("card_notification_like : wording: ");
      localStringBuilder.append(paramForwardBody);
      localStringBuilder.append(" totalCount: ");
      localStringBuilder.append(j);
      localStringBuilder.append(" newCount: ");
      localStringBuilder.append(i);
      localStringBuilder.append(" fromUin: ");
      localStringBuilder.append(l);
      QLog.d("msg0x210.SubMsgType0x6f", 2, localStringBuilder.toString());
    }
    paramMessageHandler = (DatingProxyManager)paramMessageHandler.a.getManager(QQManagerFactory.DATING_PROXY_MANAGER);
    if (paramMessageHandler != null) {
      paramMessageHandler.a().a(localMCardNotificationLike);
    }
  }
  
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext, MessageHandler paramMessageHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("msg0x210.SubMsgType0x6f", 2, "decodeTurnBrandTipsPush recv msg0x210.Submsgtype0x6f");
    }
    if (paramMsgType0x210.msg_content == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("msg0x210.SubMsgType0x6f", 2, "decodeTurnBrandTipsPush msg_content is null");
      }
      return;
    }
    paramMsgType0x210 = paramMsgType0x210.msg_content.get().toByteArray();
    if (paramMsgType0x210 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("msg0x210.SubMsgType0x6f", 2, "decodeTurnBrandTipsPush msg_content.toByteArray is null");
      }
      return;
    }
    try
    {
      paramList = new SubMsgType0x6f.MsgBody();
      paramList.mergeFrom(paramMsgType0x210);
      paramMsgType0x210 = (SubMsgType0x6f.ForwardBody)paramList.rpt_msg_mod_infos.get().get(0);
      int i = -1;
      if (paramMsgType0x210.uint32_op_type.has()) {
        i = paramMsgType0x210.uint32_op_type.get();
      }
      if ((i == 2001) && (paramMsgType0x210.msg_mcard_notification_like.has())) {
        d(paramMessageHandler, paramMsgType0x210);
      } else if ((i == 2002) && (paramMsgType0x210.msg_vip_info_notify.has())) {
        c(paramMessageHandler, paramMsgType0x210);
      } else if ((i == 2003) && (paramMsgType0x210.msg_push_lost_dev_found.has())) {
        b(paramMessageHandler, paramMsgType0x210);
      } else if ((i == 2011) && (paramMsgType0x210.msg_mod_qim_friend_to_qq.has())) {
        a(paramMessageHandler, paramMsgType0x210);
      }
      MessageProtoCodec.a(paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get(), paramMessageHandler.a());
      return;
    }
    catch (Exception paramMsgType0x210)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TurnBrand", 2, "failed to get msg0x210.SubMsgType0x6f", paramMsgType0x210);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.TurnBrandTipsDecoder
 * JD-Core Version:    0.7.0.1
 */