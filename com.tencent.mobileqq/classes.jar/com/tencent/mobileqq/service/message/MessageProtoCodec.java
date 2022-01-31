package com.tencent.mobileqq.service.message;

import IMMsgBodyPack.SlaveMasterMsg;
import OnlinePushPack.MsgInfo;
import ahxo;
import ahxp;
import ahxq;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.av.SharpReport_OffLine;
import com.tencent.av.VideoPackageUtils;
import com.tencent.av.core.AbstractNetChannel;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.GaInviteDialogActivity;
import com.tencent.av.hd_video_2.CmdS2CInviteReqBody;
import com.tencent.av.hd_video_2.MsgBody;
import com.tencent.av.service.QavWrapper;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.biz.qqstory.base.QQStoryFeedManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.NotifyPCActiveActivity;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.activity.contact.newfriend.CloneFriendPushHelper;
import com.tencent.mobileqq.activity.qwallet.QWalletPushManager;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.activity.qwallet.voice.VoiceRedPacketHelper;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.ApolloPushManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QIMNewFriendManager;
import com.tencent.mobileqq.app.QPayHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQGAudioMsgHandler;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.ShieldListHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activateFriends.MessageForActivateFriends;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.HotReactivePushMsg;
import com.tencent.mobileqq.app.message.OfflineFileMessageProcessor;
import com.tencent.mobileqq.app.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.message.SubAccountMessageProcessor;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.app.utils.DingdongPluginBizHandler;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.FunnyFaceMessage;
import com.tencent.mobileqq.data.FunnyFaceMessage.Bomb;
import com.tencent.mobileqq.data.FunnyFaceMessage.Turntable;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFunnyFace;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.MsgBoxInterFollowManager;
import com.tencent.mobileqq.data.PushRecommend;
import com.tencent.mobileqq.data.QIMFollwerAdd;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.data.QIMNotifyAddFriend.VideoInfo;
import com.tencent.mobileqq.data.ShakeWindowMsg;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.dating.DatingProxyManager;
import com.tencent.mobileqq.dating.widget.VoteEventMgr;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FMDataCache;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OnlineFileSessionInfo;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.now.enter.NowHongbaoPushManager;
import com.tencent.mobileqq.now.enter.pb.NowPushMsgList.MsgBody;
import com.tencent.mobileqq.now.enter.pb.NowPushMsgList.NowPushMsg;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.secspy.SecSpyFileManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgUtils;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.ActionMsgUtil.AppShareCookie;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.apollomsgextend.ApolloMsgExtend.AuthReserve;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.dingdong.DingdongPluginManager;
import cooperation.qlink.QlinkServiceManager;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import localpb.richMsg.MixedMsg.Elem;
import localpb.richMsg.MixedMsg.Msg;
import localpb.richMsg.RichMsg.PicRec;
import localpb.richMsg.RichMsg.PttRec;
import mqq.app.AccountNotMatchException;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import msf.msgcomm.msg_comm.PluginInfo;
import msf.msgsvc.msg_svc.AccostTmp;
import msf.msgsvc.msg_svc.AddressListTmp;
import msf.msgsvc.msg_svc.AuthTmp;
import msf.msgsvc.msg_svc.BsnsTmp;
import msf.msgsvc.msg_svc.BusinessWPATmp;
import msf.msgsvc.msg_svc.C2C;
import msf.msgsvc.msg_svc.CommTmp;
import msf.msgsvc.msg_svc.Dis;
import msf.msgsvc.msg_svc.DisTmp;
import msf.msgsvc.msg_svc.Grp;
import msf.msgsvc.msg_svc.GrpTmp;
import msf.msgsvc.msg_svc.NearByAssistantTmp;
import msf.msgsvc.msg_svc.NearByDatingTmp;
import msf.msgsvc.msg_svc.PbDeleteMsgReq;
import msf.msgsvc.msg_svc.PbDeleteMsgReq.MsgItem;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.PubGroupTmp;
import msf.msgsvc.msg_svc.PublicPlat;
import msf.msgsvc.msg_svc.QQQueryBusinessTmp;
import msf.msgsvc.msg_svc.RichStatusTmp;
import msf.msgsvc.msg_svc.RoutingHead;
import msf.msgsvc.msg_svc.Trans0x211;
import msf.msgsvc.msg_svc.TransMsg;
import msf.msgsvc.msg_svc.WPATmp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.apollo_push_msgInfo.STPushMsgElem;
import tencent.im.cs.head.ContentHead;
import tencent.im.cs.head.Head;
import tencent.im.cs.head.MsgHead;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.hummer.resv.source_msg.ResvAttr;
import tencent.im.msg.hummer.resv1.TextMsgExtPb.ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype11;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype14;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype16;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype19;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype2;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype20;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype23;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.ApolloActMsg;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.Face;
import tencent.im.msg.im_msg_body.FunFace;
import tencent.im.msg.im_msg_body.FunFace.Bomb;
import tencent.im.msg.im_msg_body.FunFace.Turntable;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.LightAppElem;
import tencent.im.msg.im_msg_body.MarketFace;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NearByMessageType;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.PubGroup;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.SecretFileMsg;
import tencent.im.msg.im_msg_body.ShakeWindow;
import tencent.im.msg.im_msg_body.SmallEmoji;
import tencent.im.msg.im_msg_body.SourceMsg;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.resv21.hummer_resv_21.FileImgInfo;
import tencent.im.msgrevoke.msgrevoke_userdef.UinTypeUserDef;
import tencent.im.msgsync.cmd0x100.Submsgtype0x8a.MsgInfo;
import tencent.im.msgsync.cmd0x100.Submsgtype0x8a.ReqBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x35.Submsgtype0x35.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x4e.Submsgtype0x4e.GroupBulletin;
import tencent.im.s2c.msgtype0x210.submsgtype0x4e.Submsgtype0x4e.GroupBulletin.Content;
import tencent.im.s2c.msgtype0x210.submsgtype0x4e.Submsgtype0x4e.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x67.submsgtype0x67.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6b.SubMsgType0x6b.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.AddQimFriendNotifyToQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.ForwardBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.MCardNotificationLike;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.PushLostDevFound;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.QimFriendNotifyToQQ;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.VideoInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.VipInfoNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.BirthdayNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.GeoGraphicNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MemorialDayNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.OneMemorialDayInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x7c.submsgtype0x7c.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x87.SubMsgType0x87.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x9b.SubMsgType0x9b.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.AddFriendSource;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.PersonMayKnow;
import tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.PushPeopleMayKnowV2;
import tencent.im.s2c.msgtype0x210.submsgtype0xb1.submsgtype0xb1.DealInviteInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xb1.submsgtype0xb1.InviteInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xb1.submsgtype0xb1.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xb1.submsgtype0xb1.UninviteInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xca.submsgtype0xca.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xcb.SubMsgType0xcb.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xe8.submsgtype0xe8.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x3.SubMsgType0x3.FailNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x3.SubMsgType0x3.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x3.SubMsgType0x3.ProgressNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9.MsgBody;

public class MessageProtoCodec
{
  private static HashMap a = new HashMap();
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 7: 
    case 9: 
    case 13: 
    case 20: 
    default: 
      return 0;
    case 3: 
      return 1000;
    case 6: 
      return 1005;
    case 8: 
      return 1008;
    case 10: 
      return 1006;
    case 5: 
      return 1004;
    case 11: 
      return 1009;
    case 12: 
      return 1001;
    case 23: 
      return 10002;
    case 26: 
      return 1033;
    case 27: 
      return 1034;
    case 25: 
      return 10004;
    case 4: 
      return 3000;
    case 2: 
      return 1;
    case 14: 
      return 1020;
    case 16: 
      return 1021;
    case 17: 
      return 1022;
    case 18: 
      return 1023;
    case 15: 
      return 1024;
    case 19: 
      return 1010;
    case 21: 
      return 1026;
    case 22: 
      return 7400;
    }
    return 1029;
  }
  
  public static int a(msg_comm.Msg paramMsg)
  {
    int i;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
      im_msg_body.Elem localElem;
      do
      {
        if (!paramMsg.hasNext()) {
          break;
        }
        localElem = (im_msg_body.Elem)paramMsg.next();
      } while ((!localElem.general_flags.has()) || (!((im_msg_body.GeneralFlags)localElem.general_flags.get()).uint32_bubble_diy_text_id.has()));
      j = ((im_msg_body.GeneralFlags)localElem.general_flags.get()).uint32_bubble_diy_text_id.get();
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_BubbleDiyTextID->" + j);
    return j;
    return 0;
  }
  
  public static int a(im_msg_body.RichText paramRichText, String paramString, ArrayList paramArrayList)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    int k = 0;
    if (k < str.length())
    {
      paramString = null;
      if (paramArrayList == null) {
        break label1025;
      }
      label45:
      if (i >= paramArrayList.size()) {
        break label1020;
      }
      paramString = (MessageForText.AtTroopMemberInfo)paramArrayList.get(i);
      if ((paramString == null) || (!paramString.isValid())) {}
    }
    label1025:
    for (;;)
    {
      int m;
      Object localObject;
      if ((paramString != null) && (paramString.startPos <= k))
      {
        m = j;
        if (localStringBuilder.length() > 0)
        {
          a(paramRichText, localStringBuilder.toString());
          localStringBuilder.delete(0, localStringBuilder.length());
          m = j + 1;
        }
        localObject = a(paramRichText, str.substring(paramString.startPos, paramString.startPos + paramString.textLen));
        short s = paramString.startPos;
        paramString.startPos = 0;
        a(paramString, (im_msg_body.Elem)localObject);
        paramString.startPos = s;
        localStringBuilder.delete(0, localStringBuilder.length());
        j = m + 1;
        m = paramString.textLen;
        i += 1;
        k += m - 1;
        k += 1;
        break;
        i += 1;
        break label45;
      }
      int n;
      label459:
      int[] arrayOfInt;
      if ((str.charAt(k) == '\024') && (k + 1 < str.length()))
      {
        n = j;
        if (localStringBuilder.length() > 0)
        {
          a(paramRichText, localStringBuilder.toString());
          localStringBuilder.delete(0, localStringBuilder.length());
          n = j + 1;
        }
        j = str.charAt(k + 1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "localeCode value:" + j + ",max len:" + MessageUtils.a.length);
        }
        if ((j >= 0) && (j < MessageUtils.a.length))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "---faceIndex:" + MessageUtils.a[j]);
          }
          paramString = new im_msg_body.Face();
          paramString.index.set(MessageUtils.a[j]);
          localObject = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject).face.set(paramString);
          paramRichText.elems.add((MessageMicro)localObject);
          j = n + 1;
          m = k + 1;
        }
        do
        {
          k = m;
          break;
          m = k;
          j = n;
        } while (k + 4 >= str.length());
        localObject = new char[4];
        localObject[3] = str.charAt(k + 1);
        localObject[2] = str.charAt(k + 2);
        localObject[1] = str.charAt(k + 3);
        localObject[0] = str.charAt(k + 4);
        j = 0;
        if (j < 4)
        {
          if (localObject[j] == 'ú') {
            localObject[j] = 10;
          }
          for (;;)
          {
            j += 1;
            break;
            if (localObject[j] == 'þ') {
              localObject[j] = 13;
            }
          }
        }
        arrayOfInt = EmosmUtils.a((char[])localObject);
        paramString = BaseApplicationImpl.getContext();
        if (Build.VERSION.SDK_INT > 10) {
          j = 4;
        }
      }
      label1008:
      label1015:
      for (paramString = paramString.getSharedPreferences("Last_Login", j).getString("uin", "");; paramString = null) {
        for (;;)
        {
          try
          {
            paramString = (AppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramString);
            if (paramString == null) {
              break label1008;
            }
            paramString = (EmoticonManager)paramString.getManager(13);
            if (paramString == null) {
              break label1015;
            }
            paramString = paramString.a(Integer.toString(arrayOfInt[0]), Integer.toString(arrayOfInt[1]));
            if (paramString == null) {
              break label1008;
            }
            paramString = paramString.character;
            j = arrayOfInt[0];
            m = arrayOfInt[1];
            localSmallEmoji = new im_msg_body.SmallEmoji();
            localSmallEmoji.packIdSum.set((j << 16) + m);
            if (localObject[3] == 'ÿ')
            {
              localSmallEmoji.imageType.set(1);
              localObject = new im_msg_body.Elem();
              ((im_msg_body.Elem)localObject).small_emoji.set(localSmallEmoji);
              paramRichText.elems.add((MessageMicro)localObject);
              localObject = new im_msg_body.Text();
              ((im_msg_body.Text)localObject).str.set(ByteStringMicro.copyFromUtf8(paramString));
              paramString = new im_msg_body.Elem();
              paramString.text.set((MessageMicro)localObject);
              paramRichText.elems.add(paramString);
              j = n + 1 + 1;
              m = k + 4;
              break label459;
              j = 0;
            }
          }
          catch (AccountNotMatchException paramString)
          {
            im_msg_body.SmallEmoji localSmallEmoji;
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "[AccountNotMatchException]," + paramString.getMessage());
            }
            paramString = null;
            continue;
            if (localObject[3] != 'ǿ') {
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "send apng epid = " + arrayOfInt[0] + " eid = " + arrayOfInt[1]);
            }
            localSmallEmoji.imageType.set(2);
            continue;
          }
          localStringBuilder.append(str.charAt(k));
          break;
          i = j;
          if (localStringBuilder.length() > 0)
          {
            a(paramRichText, localStringBuilder.toString());
            i = j + 1;
          }
          return i;
          paramString = "[小表情]";
        }
      }
      label1020:
      paramString = null;
    }
  }
  
  public static long a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_GroupSys");
    }
    long l2;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_GroupSys return null:hasBody:" + paramMsg.msg_body.has() + ",hasMsgContent" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has() + ",isReaded:" + paramBoolean1 + "syncOther:" + paramBoolean2);
      }
      l2 = 0L;
      return l2;
    }
    long l3 = Long.valueOf(paramMessageHandler.b.getCurrentAccountUin()).longValue();
    long l4 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
    int i = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_type.get();
    byte[] arrayOfByte = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
    if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {}
    for (long l1 = PkgTools.a(arrayOfByte, 0);; l1 = 0L)
    {
      Object localObject = (msg_comm.MsgHead)paramMsg.msg_head.get();
      if (localObject != null)
      {
        localObject = ((msg_comm.MsgHead)localObject).group_name.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler.sysnick", 2, "TroopCode:" + l1 + "TroopName:" + (String)localObject);
        }
        paramMessageHandler.c("" + l1, (String)localObject);
      }
      l2 = l1;
      if (paramBoolean1) {
        break;
      }
      l2 = l1;
      if (paramBoolean2) {
        break;
      }
      l2 = l1;
      if (paramBoolean3) {
        break;
      }
      paramMessageHandler.a().a(l3, i, arrayOfByte, l4, ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get(), ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get());
      return l1;
    }
  }
  
  public static long a(msg_comm.Msg paramMsg)
  {
    long l1 = -1L;
    long l2 = l1;
    if (paramMsg.msg_body.has())
    {
      if (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()) {
        l2 = l1;
      }
    }
    else {
      return l2;
    }
    paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
    label70:
    Object localObject;
    if (paramMsg.hasNext())
    {
      localObject = (im_msg_body.Elem)paramMsg.next();
      if ((((im_msg_body.Elem)localObject).elem_flags2.has()) && (((im_msg_body.Elem)localObject).elem_flags2.uint32_custom_font.has())) {
        l1 = ((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject).elem_flags2.get()).uint32_custom_font.get() & 0xFFFFFFFF;
      }
    }
    for (;;)
    {
      break label70;
      if (((im_msg_body.Elem)localObject).secret_file.has())
      {
        localObject = ((im_msg_body.Elem)localObject).secret_file;
        if ((((im_msg_body.SecretFileMsg)localObject).elem_flags2.has()) && (((im_msg_body.SecretFileMsg)localObject).elem_flags2.uint32_custom_font.has()))
        {
          l1 = ((im_msg_body.ElemFlags2)((im_msg_body.SecretFileMsg)localObject).elem_flags2.get()).uint32_custom_font.get() & 0xFFFFFFFF;
          continue;
          l2 = l1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_VipFontID: fontid = " + l1);
          return l1;
        }
      }
    }
  }
  
  public static Pair a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, String paramString1, String paramString2)
  {
    long l2 = -1L;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      return new Pair(Long.valueOf(0L), Long.valueOf(0L));
    }
    paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
    long l1 = -1L;
    Object localObject;
    if (paramMsg.hasNext())
    {
      localObject = (im_msg_body.Elem)paramMsg.next();
      if ((((im_msg_body.Elem)localObject).elem_flags2.has()) && (((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject).elem_flags2.get()).uint32_color_text_id.has())) {
        l1 = ((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject).elem_flags2.get()).uint32_color_text_id.get() & 0xFFFFFFFF;
      }
    }
    for (;;)
    {
      break;
      if (((im_msg_body.Elem)localObject).secret_file.has())
      {
        localObject = ((im_msg_body.Elem)localObject).secret_file;
        if ((((im_msg_body.SecretFileMsg)localObject).elem_flags2.has()) && (((im_msg_body.SecretFileMsg)localObject).elem_flags2.uint32_color_text_id.has()))
        {
          l1 = ((im_msg_body.ElemFlags2)((im_msg_body.SecretFileMsg)localObject).elem_flags2.get()).uint32_color_text_id.get() & 0xFFFFFFFF;
          continue;
          if (l1 == 4294967295L) {
            l2 = paramMessageHandler.b.a().a(paramString1, paramString2);
          }
          return new Pair(Long.valueOf(l1), Long.valueOf(l2));
        }
      }
    }
  }
  
  public static MessageRecord a(MessageHandler paramMessageHandler, byte[] paramArrayOfByte, msg_comm.Msg paramMsg)
  {
    SubMsgType0xcb.MsgBody localMsgBody = new SubMsgType0xcb.MsgBody();
    for (;;)
    {
      try
      {
        localMsgBody.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (MessageForNearbyLiveTip)MessageRecordFactory.a(-2053);
        if (localMsgBody.uint32_anchor_status.get() == 1)
        {
          bool = true;
          paramArrayOfByte.isLiving = bool;
          paramArrayOfByte.jumpingUrl = localMsgBody.bytes_jump_schema.get().toStringUtf8();
          paramArrayOfByte.msg = localMsgBody.bytes_live_wording.get().toStringUtf8();
          paramArrayOfByte.headUrl = localMsgBody.bytes_anchor_head_url.get().toStringUtf8();
          paramArrayOfByte.nickName = localMsgBody.bytes_anchor_nickname.get().toStringUtf8();
          paramArrayOfByte.liveEndWording = localMsgBody.bytes_live_end_wording.get().toStringUtf8();
          paramArrayOfByte.c2cMsgWording = localMsgBody.bytes_c2c_msg_wording.get().toStringUtf8();
          long l1 = paramMsg.msg_head.from_uin.get();
          int i = paramMsg.msg_head.msg_seq.get();
          long l2 = paramMsg.msg_head.msg_uid.get();
          int j = paramMsg.msg_head.msg_type.get();
          paramArrayOfByte.time = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
          paramArrayOfByte.msgseq = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
          paramArrayOfByte.shmsgseq = i;
          paramArrayOfByte.msgUid = l2;
          paramArrayOfByte.selfuin = paramMessageHandler.b.getCurrentAccountUin();
          paramArrayOfByte.istroop = 1001;
          paramArrayOfByte.senderuin = String.valueOf(AppConstants.l + l1);
          paramArrayOfByte.frienduin = String.valueOf(AppConstants.l + l1);
          paramArrayOfByte.getBytes();
          a(paramMessageHandler, l1, i, l2, j);
          if (QLog.isColorLevel())
          {
            paramMessageHandler = new StringBuilder();
            paramMessageHandler.append("status=").append(paramArrayOfByte.isLiving).append("jumpingUrl=").append(paramArrayOfByte.jumpingUrl).append("liveWording=").append(paramArrayOfByte.msg).append("headUrl").append(paramArrayOfByte.headUrl).append("nickName").append(paramArrayOfByte.nickName);
            QLog.i("Q.msg.MessageHandler", 2, paramMessageHandler.toString());
          }
          ReportController.b(null, "dc00899", "grp_lbs", "", "msg_box", "view_live_message", 0, 0, "", "", "", "");
          return paramArrayOfByte;
        }
      }
      catch (InvalidProtocolBufferMicroException paramMessageHandler)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.MessageHandler", 2, "decodeNearbyLiveTipMsg decode failed" + paramMessageHandler.toString());
        }
        return null;
      }
      boolean bool = false;
    }
  }
  
  public static MessageRecord a(List paramList, byte[] paramArrayOfByte, MessageInfo paramMessageInfo)
  {
    MixedMsg.Msg localMsg = new MixedMsg.Msg();
    JSONObject localJSONObject = new JSONObject();
    paramList = paramList.iterator();
    int i = 0;
    int k = 0;
    while (paramList.hasNext())
    {
      Object localObject1 = (MessageRecord)paramList.next();
      MixedMsg.Elem localElem = new MixedMsg.Elem();
      int j;
      if (((MessageRecord)localObject1).msgtype == -1000)
      {
        if (!TextUtils.isEmpty(((MessageRecord)localObject1).msg))
        {
          localElem.textMsg.set(((MessageRecord)localObject1).msg);
          j = i;
        }
      }
      else {
        for (;;)
        {
          Object localObject2;
          try
          {
            if (((MessageRecord)localObject1).atInfoList != null)
            {
              j = i;
              if (((MessageRecord)localObject1).atInfoList.size() > 0)
              {
                localObject2 = new JSONArray();
                localObject1 = ((MessageRecord)localObject1).atInfoList.iterator();
                j = 0;
                if (((Iterator)localObject1).hasNext())
                {
                  ((JSONArray)localObject2).put(j, ((MessageForText.AtTroopMemberInfo)((Iterator)localObject1).next()).toJsonObject());
                  j += 1;
                  continue;
                }
                localJSONObject.put("" + k, localObject2);
                j = 1;
              }
            }
            i = j;
          }
          catch (JSONException localJSONException)
          {
            QLog.e("Q.msg.MessageHandler", 1, "disc mixMsg create atInfos error:", localJSONException);
            continue;
          }
          localMsg.elems.get().add(localElem);
          k += 1;
          break;
          if (localJSONException.msgtype == -2000)
          {
            localObject2 = new RichMsg.PicRec();
            try
            {
              RichMsg.PicRec localPicRec = (RichMsg.PicRec)((RichMsg.PicRec)localObject2).mergeFrom(localJSONException.msgData);
              localElem.picMsg.set(localPicRec);
            }
            catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
            {
              for (;;)
              {
                localInvalidProtocolBufferMicroException.printStackTrace();
              }
            }
          }
          else if (localInvalidProtocolBufferMicroException.msgtype == -1049)
          {
            try
            {
              MessageForReplyText localMessageForReplyText = (MessageForReplyText)localInvalidProtocolBufferMicroException;
              localObject2 = MessagePkgUtils.a(localMessageForReplyText.mSourceMsgInfo);
              localElem.sourceMsgInfo.set(HexUtil.a((byte[])localObject2));
              if (!TextUtils.isEmpty(localMessageForReplyText.msg)) {
                localElem.textMsg.set(localMessageForReplyText.msg);
              }
            }
            catch (Exception localException)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, localException.getMessage());
              }
            }
          }
        }
      }
    }
    paramList = (MessageForMixedMsg)MessageRecordFactory.a(-1035);
    paramList.msgtype = -1035;
    paramList.msgData = localMsg.toByteArray();
    if ((paramMessageInfo != null) && (paramMessageInfo.jdField_a_of_type_Int == 3000)) {
      paramList.frienduin = paramMessageInfo.jdField_a_of_type_JavaLangString;
    }
    if (i != 0) {
      AtTroopMemberSpan.a(paramMessageInfo.jdField_a_of_type_Int, localJSONObject.toString(), paramList);
    }
    if (paramArrayOfByte != null) {
      paramList.saveExtInfoToExtStr("sens_msg_ctrl_info", HexUtil.a(paramArrayOfByte));
    }
    paramList.parse();
    return paramList;
  }
  
  public static MessageDecContent a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, long paramLong2, int paramInt)
  {
    im_msg_body.MsgBody localMsgBody = (im_msg_body.MsgBody)paramMsg.msg_body.get();
    int i = ((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.get();
    Long localLong1 = Long.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get());
    Long localLong2 = Long.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get());
    long l = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    short s = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    Object localObject = localLong1.toString();
    String str = paramMessageHandler.b.getCurrentAccountUin();
    if (i == 129)
    {
      paramMsg = (msg_comm.Msg)localObject;
      if (((String)localObject).equals(String.valueOf(localLong2)))
      {
        paramMsg = (msg_comm.Msg)localObject;
        if (((String)localObject).equals(str))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile recv  a 0x81 that is from self.");
          }
          return null;
        }
      }
    }
    else
    {
      if (!str.equals(String.valueOf(localLong1))) {
        break label238;
      }
      paramMsg = String.valueOf(localLong2);
    }
    switch (i)
    {
    }
    for (;;)
    {
      return null;
      label238:
      paramMsg = String.valueOf(localLong1);
      break;
      if (str.equalsIgnoreCase(String.valueOf(localLong1)))
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile 0x81 request is error.it is from self!!!");
        }
        return null;
      }
      if (paramBoolean2)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.MessageHandler", 2, "recv roam online msg, return null!");
        }
        return null;
      }
      localObject = paramMessageHandler.b.a().a(localMsgBody.msg_content.get().toByteArray());
      if (localObject != null)
      {
        if (!paramMessageHandler.b.a().a((OnlineFileSessionInfo)localObject))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile 0x81 request is error.");
          }
          return null;
        }
        if (!((OnlineFileSessionInfo)localObject).jdField_b_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile 0x81. requset is no mulitend olfile.");
          }
          return null;
        }
        paramMessageHandler.b.a().b(i, String.valueOf(paramLong1), paramMsg, l, s, paramBoolean1, 0, null, (OnlineFileSessionInfo)localObject, paramLong2, paramInt);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile decode 0x81 failed.");
        }
        return null;
        localObject = paramMessageHandler.b.a().a(localMsgBody.msg_content.get().toByteArray());
        if (localObject != null)
        {
          if (!paramMessageHandler.b.a().a((OnlineFileSessionInfo)localObject))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile 0x83  is error.");
            }
            return null;
          }
          paramMessageHandler.b.a().b(i, String.valueOf(paramLong1), paramMsg, l, s, paramBoolean1, 0, null, (OnlineFileSessionInfo)localObject, paramLong2, paramInt);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile decode 0x83 failed.");
          }
          return null;
          localObject = paramMessageHandler.b.a().b(localMsgBody.msg_content.get().toByteArray());
          if (localObject == null) {
            break label640;
          }
          if (!paramMessageHandler.b.a().a((OnlineFileSessionInfo)localObject))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile 0x85  is error.");
            }
            return null;
          }
          paramMessageHandler.b.a().b(i, String.valueOf(paramLong1), paramMsg, l, s, paramBoolean1, 0, null, (OnlineFileSessionInfo)localObject, paramLong2, paramInt);
        }
      }
    }
    label640:
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OnlineFile decode 0x85 failed.");
    }
    return null;
  }
  
  public static TempSessionInfo a(msg_comm.Msg paramMsg)
  {
    TempSessionInfo localTempSessionInfo = new TempSessionInfo();
    int i = -1;
    msg_comm.C2CTmpMsgHead localC2CTmpMsgHead = (msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get();
    int j;
    int k;
    if (!localC2CTmpMsgHead.c2c_type.has())
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "It doesn't has a c2cType.");
      }
      localTempSessionInfo.jdField_b_of_type_Int = localC2CTmpMsgHead.direction_flag.get();
      j = localC2CTmpMsgHead.c2c_type.get();
      k = localC2CTmpMsgHead.service_type.get();
      switch (k)
      {
      default: 
        label260:
        localTempSessionInfo.jdField_a_of_type_Int = i;
        localTempSessionInfo.jdField_a_of_type_Long = -1L;
        localTempSessionInfo.jdField_b_of_type_Long = -1L;
        switch (k)
        {
        }
        break;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        paramMsg = new StringBuilder("<---getC2CMsgPkgTempInfo: dump info:");
        paramMsg.append(" c2cType:").append(j).append(" serviceType:").append(k).append("direction_flag:").append(localTempSessionInfo.jdField_b_of_type_Int).append(" info:").append(localTempSessionInfo.toString());
        QLog.d("Q.msg.MessageHandler", 2, paramMsg.toString());
      }
      return localTempSessionInfo;
      if ((localC2CTmpMsgHead.service_type.has()) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.e("Q.msg.MessageHandler", 2, "Invalid service type, the pb data has no service type.");
      break;
      i = 1000;
      break label260;
      i = 1004;
      break label260;
      i = 1024;
      if ((!BmqqSegmentUtil.a(BaseApplicationImpl.getContext(), String.valueOf(paramMsg.msg_head.from_uin.get()))) && (!BmqqSegmentUtil.a(BaseApplicationImpl.getContext(), String.valueOf(paramMsg.msg_head.to_uin.get())))) {
        break label260;
      }
      i = 1025;
      break label260;
      i = 1005;
      break label260;
      i = 1008;
      break label260;
      i = 1006;
      break label260;
      i = 1009;
      break label260;
      i = 1001;
      break label260;
      i = 1020;
      break label260;
      i = 1021;
      break label260;
      i = 1022;
      break label260;
      i = 1023;
      break label260;
      i = 1010;
      break label260;
      i = 7400;
      break label260;
      i = 10002;
      break label260;
      i = 10004;
      break label260;
      i = 1029;
      break label260;
      i = 1032;
      break label260;
      localTempSessionInfo.jdField_a_of_type_Long = localC2CTmpMsgHead.group_code.get();
      localTempSessionInfo.jdField_b_of_type_Long = localC2CTmpMsgHead.group_uin.get();
      continue;
      localTempSessionInfo.jdField_a_of_type_Long = localC2CTmpMsgHead.group_code.get();
      localTempSessionInfo.jdField_b_of_type_Long = localC2CTmpMsgHead.group_code.get();
      continue;
      localTempSessionInfo.jdField_a_of_type_Long = localC2CTmpMsgHead.group_code.get();
      localTempSessionInfo.jdField_b_of_type_Long = localC2CTmpMsgHead.group_uin.get();
    }
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramString.length())
    {
      if ((paramString.charAt(i) == '\024') && (i + 1 < paramString.length()))
      {
        int k = paramString.charAt(i + 1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "localeCode value:" + k + ",max len:" + MessageUtils.a.length);
        }
        j = i;
        if (k >= 0)
        {
          j = i;
          if (k < MessageUtils.a.length)
          {
            j = MessageUtils.a[k];
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "---faceIndex:" + j);
            }
            localStringBuilder.append(paramString.charAt(i));
            localStringBuilder.append((char)(j / 128 + 65));
            localStringBuilder.append((char)(j % 128 + 65));
          }
        }
      }
      for (int j = i + 1;; j = i)
      {
        i = j + 1;
        break;
        localStringBuilder.append(paramString.charAt(i));
      }
    }
    return localStringBuilder.toString();
  }
  
  public static msg_svc.PbSendMsgReq a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, TransMsgContext paramTransMsgContext, long paramLong, int paramInt2)
  {
    if (paramTransMsgContext == null) {
      paramQQAppInterface = null;
    }
    label334:
    do
    {
      return paramQQAppInterface;
      int j = (short)(int)paramLong;
      int k = 0xFFFF & j;
      long l;
      msg_svc.RoutingHead localRoutingHead;
      if ((paramInt1 == 9) || (paramInt1 == 13))
      {
        l = 0x0 | paramTransMsgContext.jdField_a_of_type_ArrayOfByte.length << 16 | 0xA6;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<PbSendMsg><S>--->createPbSendMsgReq: routingType:" + paramInt1 + ",toUin:" + paramString + ",msgUid:" + l + ",msgSeq:" + paramLong + ",uint32Seq:" + k + ",shortSeq:" + j + ",randomNum:" + paramInt2 + ",msgContext:" + paramTransMsgContext);
        }
        paramQQAppInterface = paramQQAppInterface.a();
        localRoutingHead = new msg_svc.RoutingHead();
        int i = 0;
        switch (paramInt1)
        {
        default: 
          paramInt1 = i;
        }
      }
      for (;;)
      {
        if (paramInt1 != 0) {
          break label334;
        }
        return null;
        l = 0x0 | paramInt2;
        break;
        localObject = new msg_svc.TransMsg();
        ((msg_svc.TransMsg)localObject).c2c_cmd.set(paramTransMsgContext.jdField_a_of_type_Int);
        ((msg_svc.TransMsg)localObject).to_uin.set(Long.valueOf(paramString).longValue());
        localRoutingHead.trans_msg.set((MessageMicro)localObject);
        paramInt1 = 1;
        continue;
        localObject = new msg_svc.Trans0x211();
        ((msg_svc.Trans0x211)localObject).cc_cmd.set(paramTransMsgContext.jdField_a_of_type_Int);
        paramString = paramString.replace("+", "");
        ((msg_svc.Trans0x211)localObject).to_uin.set(CharacterUtil.a(paramString));
        localRoutingHead.trans_0x211.set((MessageMicro)localObject);
        paramInt1 = 1;
      }
      Object localObject = new msg_comm.ContentHead();
      ((msg_comm.ContentHead)localObject).pkg_num.set(1);
      ((msg_comm.ContentHead)localObject).div_seq.set(j);
      ((msg_comm.ContentHead)localObject).pkg_index.set(0);
      im_msg_body.MsgBody localMsgBody = new im_msg_body.MsgBody();
      localMsgBody.msg_content.set(ByteStringMicro.copyFrom(paramTransMsgContext.jdField_a_of_type_ArrayOfByte));
      paramString = new msg_svc.PbSendMsgReq();
      paramString.routing_head.set(localRoutingHead);
      paramString.content_head.set((MessageMicro)localObject);
      paramString.msg_body.set(localMsgBody);
      paramString.msg_seq.set(k);
      paramString.msg_rand.set(paramInt2);
      paramTransMsgContext = paramQQAppInterface.a();
      paramQQAppInterface = paramString;
    } while (paramTransMsgContext == null);
    paramString.sync_cookie.set(ByteStringMicro.copyFrom(paramTransMsgContext));
    return paramString;
  }
  
  public static msg_svc.PbSendMsgReq a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText, int paramInt)
  {
    int i = b(paramMessageRecord.istroop);
    if ((i == 9) || (i == 13)) {}
    int j;
    int k;
    MessageCache localMessageCache;
    msg_svc.RoutingHead localRoutingHead;
    do
    {
      return null;
      long l = paramMessageRecord.msgUid;
      j = (short)(int)paramMessageRecord.msgseq;
      k = MessageUtils.a(l);
      localMessageCache = paramQQAppInterface.a();
      localRoutingHead = new msg_svc.RoutingHead();
    } while (!a(paramQQAppInterface, paramMessageRecord, localRoutingHead));
    paramQQAppInterface = new msg_comm.ContentHead();
    paramQQAppInterface.pkg_num.set(paramMessageRecord.longMsgCount);
    paramQQAppInterface.div_seq.set(paramMessageRecord.longMsgId);
    paramQQAppInterface.pkg_index.set(paramMessageRecord.longMsgIndex);
    paramMessageRecord = new im_msg_body.MsgBody();
    paramMessageRecord.rich_text.set(paramRichText);
    paramRichText = new msg_svc.PbSendMsgReq();
    paramRichText.routing_head.set(localRoutingHead);
    paramRichText.content_head.set(paramQQAppInterface);
    paramRichText.msg_body.set(paramMessageRecord);
    paramRichText.msg_seq.set(j & 0xFFFF);
    paramRichText.msg_rand.set(k);
    if ((i != 2) && (i != 4) && (i != 21))
    {
      paramQQAppInterface = localMessageCache.a();
      if (paramQQAppInterface != null) {
        paramRichText.sync_cookie.set(ByteStringMicro.copyFrom(paramQQAppInterface));
      }
    }
    paramRichText.msg_via.set(paramInt);
    return paramRichText;
  }
  
  private static im_msg_body.Elem a(im_msg_body.RichText paramRichText, String paramString)
  {
    im_msg_body.Text localText = new im_msg_body.Text();
    localText.str.set(ByteStringMicro.copyFromUtf8(paramString));
    paramString = new im_msg_body.Elem();
    paramString.text.set(localText);
    paramRichText.elems.add(paramString);
    return paramString;
  }
  
  public static im_msg_body.RichText a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForRichText))) {
      return ((MessageForRichText)paramChatMessage).richText;
    }
    return null;
  }
  
  public static im_msg_body.RichText a(FunnyFaceMessage paramFunnyFaceMessage)
  {
    im_msg_body.FunFace localFunFace = new im_msg_body.FunFace();
    Object localObject;
    if (paramFunnyFaceMessage.faceId == 1)
    {
      localObject = new im_msg_body.FunFace.Turntable();
      Iterator localIterator = paramFunnyFaceMessage.turntable.uinList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((im_msg_body.FunFace.Turntable)localObject).rpt_uint64_uin_list.add(Long.valueOf(str));
      }
      ((im_msg_body.FunFace.Turntable)localObject).uint64_hit_uin.set(Long.valueOf(paramFunnyFaceMessage.turntable.hitUin).longValue());
      localFunFace.msg_turntable.set((MessageMicro)localObject);
    }
    for (;;)
    {
      paramFunnyFaceMessage = new im_msg_body.RichText();
      localObject = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject).fun_face.set(localFunFace);
      paramFunnyFaceMessage.elems.add((MessageMicro)localObject);
      return paramFunnyFaceMessage;
      if (paramFunnyFaceMessage.faceId == 2)
      {
        localObject = new im_msg_body.FunFace.Bomb();
        ((im_msg_body.FunFace.Bomb)localObject).bool_burst.set(paramFunnyFaceMessage.bomb.isBurst);
        localFunFace.msg_bomb.set((MessageMicro)localObject);
      }
    }
  }
  
  public static im_msg_body.RichText a(MarkFaceMessage paramMarkFaceMessage, String paramString, boolean paramBoolean)
  {
    Object localObject = new im_msg_body.MarketFace();
    if (paramMarkFaceMessage.sbufID != null) {
      ((im_msg_body.MarketFace)localObject).bytes_face_id.set(ByteStringMicro.copyFrom(paramMarkFaceMessage.sbufID));
    }
    if ((paramBoolean) && (paramString != null)) {
      ((im_msg_body.MarketFace)localObject).bytes_face_name.set(ByteStringMicro.copyFromUtf8(paramString));
    }
    if (paramMarkFaceMessage.sbfKey != null) {
      ((im_msg_body.MarketFace)localObject).bytes_key.set(ByteStringMicro.copyFrom(paramMarkFaceMessage.sbfKey));
    }
    ((im_msg_body.MarketFace)localObject).uint32_face_info.set(paramMarkFaceMessage.cFaceInfo);
    ((im_msg_body.MarketFace)localObject).uint32_item_type.set(paramMarkFaceMessage.dwMSGItemType);
    ((im_msg_body.MarketFace)localObject).uint32_sub_type.set(paramMarkFaceMessage.cSubType);
    ((im_msg_body.MarketFace)localObject).uint32_tab_id.set(paramMarkFaceMessage.dwTabID);
    ((im_msg_body.MarketFace)localObject).uint32_media_type.set(paramMarkFaceMessage.mediaType);
    ((im_msg_body.MarketFace)localObject).uint32_image_width.set(paramMarkFaceMessage.imageWidth);
    ((im_msg_body.MarketFace)localObject).uint32_image_height.set(paramMarkFaceMessage.imageHeight);
    if ((paramMarkFaceMessage.mobileparam != null) && (paramMarkFaceMessage.mobileparam.length > 0)) {
      ((im_msg_body.MarketFace)localObject).bytes_mobileparam.set(ByteStringMicro.copyFrom(paramMarkFaceMessage.mobileparam));
    }
    if ((paramMarkFaceMessage.resvAttr != null) && (paramMarkFaceMessage.resvAttr.length > 0)) {
      ((im_msg_body.MarketFace)localObject).bytes_pb_reserve.set(ByteStringMicro.copyFrom(paramMarkFaceMessage.resvAttr));
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "encodeMarketFace : mf epid = " + ((im_msg_body.MarketFace)localObject).uint32_tab_id.get() + " csubtype = " + ((im_msg_body.MarketFace)localObject).uint32_sub_type.get() + ";mediaType = " + ((im_msg_body.MarketFace)localObject).uint32_media_type.get());
    }
    paramMarkFaceMessage = new im_msg_body.Text();
    if (paramString != null) {
      paramMarkFaceMessage.str.set(ByteStringMicro.copyFromUtf8(paramString));
    }
    paramString = new im_msg_body.RichText();
    im_msg_body.Elem localElem = new im_msg_body.Elem();
    localElem.market_face.set((MessageMicro)localObject);
    paramString.elems.add(localElem);
    localObject = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject).text.set(paramMarkFaceMessage);
    paramString.elems.add((MessageMicro)localObject);
    return paramString;
  }
  
  public static im_msg_body.RichText a(MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo == null) || (paramMessageForApollo.mApolloMessage == null)) {
      return null;
    }
    return b(paramMessageForApollo);
  }
  
  public static im_msg_body.RichText a(MessageForFile paramMessageForFile)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((paramMessageForFile == null) || (localObject == null) || (paramMessageForFile.uniseq == -1L)) {
      return null;
    }
    localObject = ((QQAppInterface)localObject).a().a(paramMessageForFile.uniseq, paramMessageForFile.senderuin, paramMessageForFile.istroop);
    if (localObject == null) {
      return null;
    }
    paramMessageForFile = new im_msg_body.NotOnlineFile();
    if (!TextUtils.isEmpty(((FileManagerEntity)localObject).strFileMd5)) {
      paramMessageForFile.bytes_file_md5.set(ByteStringMicro.copyFromUtf8(((FileManagerEntity)localObject).strFileMd5));
    }
    if (!TextUtils.isEmpty(((FileManagerEntity)localObject).fileName)) {
      paramMessageForFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(((FileManagerEntity)localObject).fileName));
    }
    if (!TextUtils.isEmpty(((FileManagerEntity)localObject).Uuid)) {
      paramMessageForFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(((FileManagerEntity)localObject).Uuid));
    }
    paramMessageForFile.uint64_file_size.set(((FileManagerEntity)localObject).fileSize);
    paramMessageForFile.uint32_upload_time.set((int)(((FileManagerEntity)localObject).srvTime / 1000L));
    localObject = new im_msg_body.RichText();
    ((im_msg_body.RichText)localObject).not_online_file.set(paramMessageForFile);
    return localObject;
  }
  
  public static im_msg_body.RichText a(MessageForFunnyFace paramMessageForFunnyFace)
  {
    if ((paramMessageForFunnyFace == null) || (paramMessageForFunnyFace.mFunnyFaceMessage == null)) {
      return null;
    }
    return a(paramMessageForFunnyFace.mFunnyFaceMessage);
  }
  
  public static im_msg_body.RichText a(MessageForLongTextMsg paramMessageForLongTextMsg, boolean paramBoolean)
  {
    Object localObject2 = null;
    if (paramMessageForLongTextMsg == null) {
      localObject1 = localObject2;
    }
    do
    {
      do
      {
        do
        {
          return localObject1;
          if (!paramBoolean) {
            break;
          }
          localObject1 = localObject2;
        } while (paramMessageForLongTextMsg.structingMsg == null);
        localObject3 = paramMessageForLongTextMsg.structingMsg.getXmlBytes();
        localObject1 = localObject2;
      } while (localObject3 == null);
      localObject1 = new im_msg_body.RichMsg();
      ((im_msg_body.RichMsg)localObject1).bytes_template_1.set(ByteStringMicro.copyFrom((byte[])localObject3));
      ((im_msg_body.RichMsg)localObject1).uint32_service_id.set(paramMessageForLongTextMsg.structingMsg.mMsgServiceID);
      localObject2 = new im_msg_body.RichText();
      localObject3 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject3).rich_msg.set((MessageMicro)localObject1);
      ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject3);
      localObject1 = localObject2;
    } while (TextUtils.isEmpty(paramMessageForLongTextMsg.structingMsg.mCompatibleText));
    Object localObject1 = new im_msg_body.Elem();
    Object localObject3 = new im_msg_body.Text();
    ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFrom(paramMessageForLongTextMsg.structingMsg.mCompatibleText.getBytes()));
    ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject3);
    ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
    return localObject2;
    paramMessageForLongTextMsg = a(paramMessageForLongTextMsg.msg, paramMessageForLongTextMsg.atInfoList);
    localObject1 = new im_msg_body.GeneralFlags();
    ((im_msg_body.GeneralFlags)localObject1).long_text_flag.set(2);
    localObject2 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject2).general_flags.set((MessageMicro)localObject1);
    paramMessageForLongTextMsg.elems.add((MessageMicro)localObject2);
    return paramMessageForLongTextMsg;
  }
  
  public static im_msg_body.RichText a(MessageForMarketFace paramMessageForMarketFace)
  {
    if ((paramMessageForMarketFace == null) || (paramMessageForMarketFace.mMarkFaceMessage == null)) {
      return null;
    }
    if (TextUtils.isEmpty(paramMessageForMarketFace.mMarkFaceMessage.faceName)) {}
    for (String str = "[原创表情]";; str = "[" + paramMessageForMarketFace.mMarkFaceMessage.faceName + "]")
    {
      boolean bool = true;
      if (paramMessageForMarketFace.istroop == 3000) {
        bool = false;
      }
      return a(paramMessageForMarketFace.mMarkFaceMessage, str, bool);
    }
  }
  
  public static im_msg_body.RichText a(MessageForMixedMsg paramMessageForMixedMsg)
  {
    if (paramMessageForMixedMsg == null) {
      return null;
    }
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    int k = paramMessageForMixedMsg.msgElemList.size();
    int i = 0;
    if (i < k)
    {
      Object localObject = (MessageRecord)paramMessageForMixedMsg.msgElemList.get(i);
      int j;
      if ((localObject instanceof MessageForText))
      {
        localObject = a((MessageForText)localObject);
        if (localObject == null) {
          return null;
        }
        j = 0;
        while (j < ((im_msg_body.RichText)localObject).elems.size())
        {
          localRichText.elems.add(((im_msg_body.RichText)localObject).elems.get(j));
          j += 1;
        }
      }
      if ((localObject instanceof MessageForRichText))
      {
        localObject = ((MessageForPic)localObject).richText;
        if (localObject == null) {
          return null;
        }
        localRichText.elems.add(((im_msg_body.RichText)localObject).elems.get(0));
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof MessageForReplyText))
        {
          localObject = a((MessageForReplyText)localObject);
          if (localObject != null)
          {
            j = 0;
            while (j < ((im_msg_body.RichText)localObject).elems.size())
            {
              localRichText.elems.add(((im_msg_body.RichText)localObject).elems.get(j));
              j += 1;
            }
          }
        }
      }
    }
    return localRichText;
  }
  
  public static im_msg_body.RichText a(MessageForQQStoryComment paramMessageForQQStoryComment)
  {
    return a(paramMessageForQQStoryComment.msg, null);
  }
  
  public static im_msg_body.RichText a(MessageForReplyText paramMessageForReplyText)
  {
    localObject3 = paramMessageForReplyText.getExtInfoFromExtStr("sens_msg_source_msg_info");
    localObject1 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3)) {}
    try
    {
      localObject4 = HexUtil.a(MessagePkgUtils.a(paramMessageForReplyText.mSourceMsgInfo));
      localObject1 = localObject4;
      localObject3 = localObject4;
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        localObject3 = localObject4;
        paramMessageForReplyText.saveExtInfoToExtStr("sens_msg_source_msg_info", (String)localObject4);
        localObject1 = localObject4;
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        try
        {
          localObject1 = (MessageForReplyText.SourceMsgInfo)MessagePkgUtils.a(HexUtil.a((String)localObject1));
          if (localObject1 == null) {
            break label426;
          }
          localObject3 = new im_msg_body.SourceMsg();
          ((im_msg_body.SourceMsg)localObject3).uint32_orig_seqs.add(Integer.valueOf((int)((MessageForReplyText.SourceMsgInfo)localObject1).mSourceMsgSeq));
          Object localObject4 = a(((MessageForReplyText.SourceMsgInfo)localObject1).mSourceMsgText, null);
          ((im_msg_body.SourceMsg)localObject3).elems.set(((im_msg_body.RichText)localObject4).elems.get());
          if (!TextUtils.isEmpty(((MessageForReplyText.SourceMsgInfo)localObject1).mAnonymousNickName))
          {
            localObject4 = new im_msg_body.AnonymousGroupMsg();
            ((im_msg_body.AnonymousGroupMsg)localObject4).str_anon_nick.set(ByteStringMicro.copyFromUtf8(((MessageForReplyText.SourceMsgInfo)localObject1).mAnonymousNickName));
            im_msg_body.Elem localElem = new im_msg_body.Elem();
            localElem.anon_group_msg.set((MessageMicro)localObject4);
            ((im_msg_body.SourceMsg)localObject3).elems.add(localElem);
          }
          ((im_msg_body.SourceMsg)localObject3).uint64_sender_uin.set(((MessageForReplyText.SourceMsgInfo)localObject1).mSourceMsgSenderUin);
          ((im_msg_body.SourceMsg)localObject3).uint32_time.set(((MessageForReplyText.SourceMsgInfo)localObject1).mSourceMsgTime);
          ((im_msg_body.SourceMsg)localObject3).uint32_flag.set(((MessageForReplyText.SourceMsgInfo)localObject1).mSourceSummaryFlag);
          ((im_msg_body.SourceMsg)localObject3).uint32_type.set(((MessageForReplyText.SourceMsgInfo)localObject1).mType);
          if (((MessageForReplyText.SourceMsgInfo)localObject1).mRichMsg != null) {
            ((im_msg_body.SourceMsg)localObject3).bytes_richMsg.set(ByteStringMicro.copyFromUtf8(((MessageForReplyText.SourceMsgInfo)localObject1).mRichMsg));
          }
          if (((MessageForReplyText.SourceMsgInfo)localObject1).mRichMsg2 != null)
          {
            localObject4 = new source_msg.ResvAttr();
            ((source_msg.ResvAttr)localObject4).bytes_richMsg2.set(ByteStringMicro.copyFromUtf8(((MessageForReplyText.SourceMsgInfo)localObject1).mRichMsg2));
            ((im_msg_body.SourceMsg)localObject3).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((source_msg.ResvAttr)localObject4).toByteArray()));
          }
          localObject1 = a(paramMessageForReplyText.msg, paramMessageForReplyText.atInfoList, (im_msg_body.SourceMsg)localObject3);
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = a(paramMessageForReplyText.msg, paramMessageForReplyText.atInfoList);
          }
          return localObject3;
        }
        catch (Exception localException1)
        {
          if (!QLog.isColorLevel()) {
            break label426;
          }
          QLog.d("Q.msg.", 2, "getSourceMsgInfo exception:" + localException1.getMessage());
        }
        localException2 = localException2;
        localObject1 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.MessageHandler", 2, QLog.getStackTraceString(localException2));
          localObject1 = localObject3;
          continue;
          Object localObject2 = null;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.", 2, "getSourceMsgInfo data = " + (String)localObject1 + ", mSourceMsgInfo = " + paramMessageForReplyText.mSourceMsgInfo);
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
  }
  
  public static im_msg_body.RichText a(MessageForShakeWindow paramMessageForShakeWindow)
  {
    if ((paramMessageForShakeWindow == null) || (paramMessageForShakeWindow.mShakeWindowMsg == null)) {
      return null;
    }
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    im_msg_body.ShakeWindow localShakeWindow = new im_msg_body.ShakeWindow();
    localShakeWindow.uint32_type.set(paramMessageForShakeWindow.mShakeWindowMsg.mType);
    paramMessageForShakeWindow = new im_msg_body.Elem();
    paramMessageForShakeWindow.shake_window.set(localShakeWindow);
    localRichText.elems.add(paramMessageForShakeWindow);
    return localRichText;
  }
  
  public static im_msg_body.RichText a(MessageForStructing paramMessageForStructing)
  {
    if ((paramMessageForStructing == null) || (paramMessageForStructing.structingMsg == null)) {
      localObject1 = null;
    }
    Object localObject2;
    label318:
    do
    {
      return localObject1;
      if (paramMessageForStructing.richText != null) {
        return paramMessageForStructing.richText;
      }
      localObject2 = paramMessageForStructing.structingMsg.getXmlBytes();
      if (localObject2 == null) {
        return null;
      }
      if ((paramMessageForStructing.structingMsg.mMsgServiceID != 83) && (paramMessageForStructing.structingMsg.mMsgServiceID != 108) && (paramMessageForStructing.structingMsg.mMsgServiceID != 114))
      {
        localObject1 = localObject2;
        if (paramMessageForStructing.structingMsg.mMsgServiceID != 116) {}
      }
      else
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mMsgActionData))
        {
          localObject2 = paramMessageForStructing.structingMsg.mMsgActionData;
          paramMessageForStructing.structingMsg.mMsgActionData = a(paramMessageForStructing.structingMsg.mMsgActionData);
          localObject1 = paramMessageForStructing.structingMsg.getXmlBytes();
          paramMessageForStructing.structingMsg.mMsgActionData = ((String)localObject2);
        }
      }
      localObject3 = new im_msg_body.RichMsg();
      ((im_msg_body.RichMsg)localObject3).bytes_template_1.set(ByteStringMicro.copyFrom((byte[])localObject1));
      ((im_msg_body.RichMsg)localObject3).uint32_service_id.set(paramMessageForStructing.structingMsg.mMsgServiceID);
      if ((paramMessageForStructing.structingMsg instanceof AbsShareMsg))
      {
        localObject1 = ((AbsShareMsg)paramMessageForStructing.structingMsg).getStructMsgItemLists();
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label318;
            }
            localObject2 = (AbsStructMsgElement)((Iterator)localObject1).next();
            if ((localObject2 instanceof AbsStructMsgItem))
            {
              localObject2 = ((AbsStructMsgItem)localObject2).a;
              if (localObject2 != null)
              {
                localObject2 = ((List)localObject2).iterator();
                if (((Iterator)localObject2).hasNext())
                {
                  AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject2).next();
                  if (!(localAbsStructMsgElement instanceof StructMsgItemVideo)) {
                    break;
                  }
                  if (((StructMsgItemVideo)localAbsStructMsgElement).a()) {
                    ((im_msg_body.RichMsg)localObject3).uint32_flags.set(4);
                  } else {
                    ((im_msg_body.RichMsg)localObject3).uint32_flags.set(2);
                  }
                }
              }
            }
          }
        }
      }
      localObject2 = new im_msg_body.RichText();
      localObject1 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject1).rich_msg.set((MessageMicro)localObject3);
      ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
      if (TextUtils.isEmpty(paramMessageForStructing.structingMsg.mCompatibleText)) {
        paramMessageForStructing.structingMsg.mCompatibleText = paramMessageForStructing.structingMsg.mMsgUrl;
      }
      localObject1 = localObject2;
    } while (TextUtils.isEmpty(paramMessageForStructing.structingMsg.mCompatibleText));
    Object localObject1 = new im_msg_body.Elem();
    Object localObject3 = new im_msg_body.Text();
    ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFrom(paramMessageForStructing.structingMsg.mCompatibleText.getBytes()));
    ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject3);
    ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
    return localObject2;
  }
  
  public static im_msg_body.RichText a(MessageForText paramMessageForText)
  {
    return a(paramMessageForText.msg, paramMessageForText.atInfoList);
  }
  
  public static im_msg_body.RichText a(MessageForTroopStory paramMessageForTroopStory)
  {
    Object localObject2 = new im_msg_body.CommonElem();
    ((im_msg_body.CommonElem)localObject2).uint32_service_type.set(16);
    Object localObject1 = new hummer_commelem.MsgElemInfo_servtype16();
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).uid.set(paramMessageForTroopStory.uid);
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).unionID.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.unionId));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).storyID.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.storyId));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).md5.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.md5));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).thumbUrl.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.thumbUrl));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).doodleUrl.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.doodleUrl));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).videoWidth.set(paramMessageForTroopStory.videoWidth);
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).videoHeight.set(paramMessageForTroopStory.videoHeight);
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).sourceName.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.sourceName));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).sourceActionType.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.sourceActionType));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).sourceActionData.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.sourceActionData));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).ctr_version.set(paramMessageForTroopStory.ctrVersion);
    ((im_msg_body.CommonElem)localObject2).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype16)localObject1).toByteArray()));
    localObject1 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject1).common_elem.set((MessageMicro)localObject2);
    localObject2 = paramMessageForTroopStory.compatibleText;
    paramMessageForTroopStory = new im_msg_body.Text();
    paramMessageForTroopStory.str.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    localObject2 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject2).text.set(paramMessageForTroopStory);
    paramMessageForTroopStory = new im_msg_body.RichText();
    paramMessageForTroopStory.elems.add((MessageMicro)localObject1);
    paramMessageForTroopStory.elems.add((MessageMicro)localObject2);
    return paramMessageForTroopStory;
  }
  
  public static im_msg_body.RichText a(String paramString, ArrayList paramArrayList)
  {
    return a(paramString, paramArrayList, null);
  }
  
  public static im_msg_body.RichText a(String paramString, ArrayList paramArrayList, im_msg_body.SourceMsg paramSourceMsg)
  {
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    if (paramSourceMsg != null)
    {
      im_msg_body.Elem localElem = new im_msg_body.Elem();
      localElem.src_msg.set(paramSourceMsg);
      localRichText.elems.add(localElem);
    }
    paramSourceMsg = localRichText;
    if (a(localRichText, paramString, paramArrayList) <= 0) {
      paramSourceMsg = null;
    }
    return paramSourceMsg;
  }
  
  private static void a(long paramLong1, long paramLong2, int paramInt)
  {
    SharpReport_OffLine localSharpReport_OffLine = SharpReport_OffLine.a();
    localSharpReport_OffLine.a(0L, paramLong1, paramLong2);
    localSharpReport_OffLine.a(paramInt, 2, paramLong2);
  }
  
  public static void a(MessageHandler paramMessageHandler, long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramMessageHandler.b.getCurrentAccountUin(), "MessageSvc.PbDeleteMsg");
    msg_svc.PbDeleteMsgReq localPbDeleteMsgReq = new msg_svc.PbDeleteMsgReq();
    msg_svc.PbDeleteMsgReq.MsgItem localMsgItem = new msg_svc.PbDeleteMsgReq.MsgItem();
    localMsgItem.from_uin.set(paramLong1);
    localMsgItem.msg_seq.set(paramInt1);
    localMsgItem.msg_uid.set(paramLong2);
    paramLong2 = 0L;
    try
    {
      paramLong1 = Long.parseLong(paramMessageHandler.b.getCurrentAccountUin());
      localMsgItem.to_uin.set(paramLong1);
      localMsgItem.msg_type.set(paramInt2);
      localPbDeleteMsgReq.msgItems.add(localMsgItem);
      localToServiceMsg.putWupBuffer(localPbDeleteMsgReq.toByteArray());
      localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      paramMessageHandler.b.sendToService(localToServiceMsg);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramLong1 = paramLong2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.MessageHandler", 2, localException.getMessage());
          paramLong1 = paramLong2;
        }
      }
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramMessageHandler.b.getCurrentAccountUin(), "MessageSvc.PbDeleteMsg");
    msg_svc.PbDeleteMsgReq localPbDeleteMsgReq = new msg_svc.PbDeleteMsgReq();
    msg_svc.PbDeleteMsgReq.MsgItem localMsgItem = new msg_svc.PbDeleteMsgReq.MsgItem();
    localMsgItem.from_uin.set(paramLong1);
    localMsgItem.msg_seq.set(paramInt1);
    localMsgItem.msg_uid.set(paramLong2);
    paramLong2 = 0L;
    try
    {
      paramLong1 = Long.parseLong(paramMessageHandler.b.getCurrentAccountUin());
      localMsgItem.to_uin.set(paramLong1);
      localMsgItem.msg_type.set(paramInt2);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
        localMsgItem.sig.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
      localPbDeleteMsgReq.msgItems.add(localMsgItem);
      localToServiceMsg.putWupBuffer(localPbDeleteMsgReq.toByteArray());
      localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      paramMessageHandler.b.sendToService(localToServiceMsg);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramLong1 = paramLong2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.MessageHandler", 2, localException.getMessage());
          paramLong1 = paramLong2;
        }
      }
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, long paramLong, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())) {}
    int i;
    long l1;
    int j;
    Object localObject7;
    Object localObject4;
    Object localObject5;
    Object localObject6;
    Object localObject2;
    label1794:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            msg_comm.MsgType0x210 localMsgType0x210 = new msg_comm.MsgType0x210();
            try
            {
              localMsgType0x210 = (msg_comm.MsgType0x210)localMsgType0x210.mergeFrom(((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray());
              if (localMsgType0x210 == null)
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : msgType0x210 is null.");
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : failed.", localException1);
                }
                localObject1 = null;
              }
              if ((!((msg_comm.MsgType0x210)localObject1).sub_msg_type.has()) || (!((msg_comm.MsgType0x210)localObject1).msg_content.has()))
              {
                if (QLog.isColorLevel()) {
                  QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : msgType0x210 require more info: hasType:" + ((msg_comm.MsgType0x210)localObject1).sub_msg_type.has() + ",hasMsgContent:" + ((msg_comm.MsgType0x210)localObject1).msg_content.has());
                }
              }
              else
              {
                i = ((msg_comm.MsgType0x210)localObject1).sub_msg_type.get();
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : msgType0x210 type:" + i);
                }
                switch (i)
                {
                }
              }
            }
          }
          return;
          a(paramMessageHandler, paramMsg, paramBoolean1);
          return;
          ((ShieldListHandler)paramMessageHandler.b.a(18)).a(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
          a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
          return;
          a(paramMessageHandler, (msg_comm.MsgType0x210)localObject1);
          return;
          ((SttManager)paramMessageHandler.b.getManager(16)).a(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
          return;
          ((PublicAccountHandler)paramMessageHandler.b.a(11)).a(i, ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.troopgetnews..troop.notification_center", 2, "decodeC2CMsgPkg_MsgType0x210, receive troop news push");
          }
          ((TroopHandler)paramMessageHandler.b.a(20)).a(((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray());
          return;
          if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationHelper", 2, "get notice from decodeC2CMsgPkg_MsgType0x210");
          }
          Object localObject1 = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();
          a(paramMessageHandler.b, (byte[])localObject1);
          a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "processMsg0x210Sub0xb1");
          }
          localObject1 = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();
          a(paramMessageHandler.b, (byte[])localObject1, false);
          a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : subtype 0x51");
          }
          paramMessageHandler.a((msg_comm.MsgType0x210)localObject1, paramMsg);
          a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : subtype 0x66");
          }
          paramLong = paramMsg.msg_head.from_uin.get();
          i = paramMsg.msg_head.msg_seq.get();
          l1 = paramMsg.msg_head.msg_uid.get();
          j = paramMsg.msg_head.msg_type.get();
          a(paramMessageHandler, paramLong, i, l1, j);
          paramMessageHandler = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();
          QWalletPushManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramMessageHandler, paramLong, i, l1, j);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Push_PCActive_Notice_Decode", 2, "get notice from decodeC2CMsgPkg_MsgType0x210");
          }
          localObject7 = ((msg_comm.MsgType0x210)localObject1).msg_content.get().toByteArray();
          localObject1 = null;
          localObject4 = null;
          localObject5 = null;
          try
          {
            localObject6 = new SubMsgType0x6b.MsgBody();
            ((SubMsgType0x6b.MsgBody)localObject6).mergeFrom((byte[])localObject7);
            paramLong = ((SubMsgType0x6b.MsgBody)localObject6).uint64_to_uin.get();
            if (!SettingCloneUtil.readValue(BaseApplicationImpl.getApplication(), Long.toString(paramLong), null, "qqsetting_pcactive_key", false))
            {
              if (((SubMsgType0x6b.MsgBody)localObject6).bytes_tips_content.has()) {
                localObject1 = new String(((SubMsgType0x6b.MsgBody)localObject6).bytes_tips_content.get().toByteArray(), "utf-8");
              }
              if (((SubMsgType0x6b.MsgBody)localObject6).bytes_yes_text.has()) {
                localObject4 = new String(((SubMsgType0x6b.MsgBody)localObject6).bytes_yes_text.get().toByteArray(), "utf-8");
              }
              if (((SubMsgType0x6b.MsgBody)localObject6).bytes_no_text.has()) {
                localObject5 = new String(((SubMsgType0x6b.MsgBody)localObject6).bytes_no_text.get().toByteArray(), "utf-8");
              }
              BaseApplicationImpl.getApplication().setPCActiveNotice(Long.toString(paramLong), (String)localObject1, (String)localObject5, (String)localObject4);
              localObject6 = new Intent("mqq.intent.action.PCACTIVE_TIPS");
              ((Intent)localObject6).putExtra("uin", Long.toString(paramLong));
              ((Intent)localObject6).putExtra("Message", (String)localObject1);
              ((Intent)localObject6).putExtra("lButton", (String)localObject5);
              ((Intent)localObject6).putExtra("rButton", (String)localObject4);
              if (NotifyPCActiveActivity.a == null) {
                BaseApplicationImpl.getApplication().startActivity((Intent)localObject6);
              }
            }
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Push_PCActive_Notice_Decode", 2, "failed to get msg0x210.SubMsgType0x6b");
              }
            }
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Push_PCActive_Notice_Decode", 2, "failed to parse msg0x210.SubMsgType0x6b");
              }
            }
          }
          a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
          return;
          if (QLog.isColorLevel()) {
            QLog.d("msg0x210.SubMsgType0x6f", 2, "decodeTurnBrandTipsPush recv msg0x210.Submsgtype0x6f");
          }
          if (localUnsupportedEncodingException.msg_content != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("msg0x210.SubMsgType0x6f", 2, "decodeTurnBrandTipsPush msg_content is null");
        return;
        localObject2 = localUnsupportedEncodingException.msg_content.get().toByteArray();
        if (localObject2 != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("msg0x210.SubMsgType0x6f", 2, "decodeTurnBrandTipsPush msg_content.toByteArray is null");
      return;
      try
      {
        localObject4 = new SubMsgType0x6f.MsgBody();
        ((SubMsgType0x6f.MsgBody)localObject4).mergeFrom((byte[])localObject2);
        localObject2 = (SubMsgType0x6f.ForwardBody)((SubMsgType0x6f.MsgBody)localObject4).rpt_msg_mod_infos.get().get(0);
        i = -1;
        if (((SubMsgType0x6f.ForwardBody)localObject2).uint32_op_type.has()) {
          i = ((SubMsgType0x6f.ForwardBody)localObject2).uint32_op_type.get();
        }
        if ((i != 2001) || (!((SubMsgType0x6f.ForwardBody)localObject2).msg_mcard_notification_like.has())) {
          break;
        }
        localObject4 = (SubMsgType0x6f.MCardNotificationLike)((SubMsgType0x6f.ForwardBody)localObject2).msg_mcard_notification_like.get();
        localObject2 = "";
        paramLong = 0L;
        j = 0;
        i = 0;
        if (((SubMsgType0x6f.MCardNotificationLike)localObject4).str_wording.has()) {
          localObject2 = ((SubMsgType0x6f.MCardNotificationLike)localObject4).str_wording.get();
        }
        if (((SubMsgType0x6f.MCardNotificationLike)localObject4).uint32_counter_new.has()) {
          i = ((SubMsgType0x6f.MCardNotificationLike)localObject4).uint32_counter_new.get();
        }
        if (((SubMsgType0x6f.MCardNotificationLike)localObject4).uint64_from_uin.has()) {
          paramLong = ((SubMsgType0x6f.MCardNotificationLike)localObject4).uint64_from_uin.get();
        }
        if (((SubMsgType0x6f.MCardNotificationLike)localObject4).uint32_counter_total.has()) {
          j = ((SubMsgType0x6f.MCardNotificationLike)localObject4).uint32_counter_total.get();
        }
        if (QLog.isColorLevel()) {
          QLog.d("msg0x210.SubMsgType0x6f", 2, "card_notification_like : wording: " + (String)localObject2 + " totalCount: " + j + " newCount: " + i + " fromUin: " + paramLong);
        }
        localObject2 = (DatingProxyManager)paramMessageHandler.b.getManager(70);
        if (localObject2 != null) {
          ((DatingProxyManager)localObject2).a().a((SubMsgType0x6f.MCardNotificationLike)localObject4);
        }
        a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
        return;
      }
      catch (Exception paramMessageHandler) {}
    } while (!QLog.isColorLevel());
    QLog.d("TurnBrand", 2, "failed to get msg0x210.SubMsgType0x6f", paramMessageHandler);
    return;
    if ((i == 2002) && (((SubMsgType0x6f.ForwardBody)localObject2).msg_vip_info_notify.has()))
    {
      localObject4 = (SubMsgType0x6f.VipInfoNotify)((SubMsgType0x6f.ForwardBody)localObject2).msg_vip_info_notify.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "vip info notify: " + localObject4.toString());
      }
      paramLong = 0L;
      i = 0;
      if (((SubMsgType0x6f.VipInfoNotify)localObject4).uint64_uin.has()) {
        paramLong = ((SubMsgType0x6f.VipInfoNotify)localObject4).uint64_uin.get();
      }
      localObject2 = Long.toString(paramLong);
      if (((SubMsgType0x6f.VipInfoNotify)localObject4).uint32_vip_identify.has()) {
        i = ((SubMsgType0x6f.VipInfoNotify)localObject4).uint32_vip_identify.get();
      }
      if (!((SubMsgType0x6f.VipInfoNotify)localObject4).uint32_vip_level.has()) {
        break label6376;
      }
      j = ((SubMsgType0x6f.VipInfoNotify)localObject4).uint32_vip_level.get();
      label1999:
      if (!QLog.isColorLevel()) {
        break label6382;
      }
      QLog.d("Q.msg.MessageHandler", 2, "UIN " + (String)localObject2 + " vip info changed.");
      break label6382;
    }
    for (;;)
    {
      label4587:
      Object localObject3;
      for (;;)
      {
        for (;;)
        {
          long l2;
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "need pull vip info from svr. vipIdentiy=" + i + "; vipLevel=" + j);
            }
            localObject4 = ((TicketManager)paramMessageHandler.b.getManager(2)).getSkey((String)localObject2);
            ((VipInfoHandler)paramMessageHandler.b.a(27)).a((String)localObject4, (String)localObject2);
            break label1794;
            if ((i == 2003) && (((SubMsgType0x6f.ForwardBody)localObject2).msg_push_lost_dev_found.has()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("QFindBLE", 2, "offlinePush receive ...");
              }
              localObject2 = (SubMsgType0x6f.PushLostDevFound)((SubMsgType0x6f.ForwardBody)localObject2).msg_push_lost_dev_found.get();
              localObject4 = new Bundle();
              if (((SubMsgType0x6f.PushLostDevFound)localObject2).uint32_msg_type.has()) {
                ((Bundle)localObject4).putInt("msgtype", ((SubMsgType0x6f.PushLostDevFound)localObject2).uint32_msg_type.get());
              }
              if (((SubMsgType0x6f.PushLostDevFound)localObject2).uint32_dev_time.has()) {
                ((Bundle)localObject4).putInt("devtime", ((SubMsgType0x6f.PushLostDevFound)localObject2).uint32_dev_time.get());
              }
              if (((SubMsgType0x6f.PushLostDevFound)localObject2).uint64_din.has()) {
                ((Bundle)localObject4).putLong("din", ((SubMsgType0x6f.PushLostDevFound)localObject2).uint64_din.get());
              }
              ((SmartDeviceProxyMgr)paramMessageHandler.b.a(51)).a(111, (Bundle)localObject4);
              break label1794;
            }
            if ((i != 2011) || (!((SubMsgType0x6f.ForwardBody)localObject2).msg_mod_qim_friend_to_qq.has())) {
              break label1794;
            }
            localObject2 = (SubMsgType0x6f.QimFriendNotifyToQQ)((SubMsgType0x6f.ForwardBody)localObject2).msg_mod_qim_friend_to_qq.get();
            i = -1;
            if (((SubMsgType0x6f.QimFriendNotifyToQQ)localObject2).uint32_notify_type.has()) {
              i = ((SubMsgType0x6f.QimFriendNotifyToQQ)localObject2).uint32_notify_type.get();
            }
            if (QLog.isColorLevel()) {
              QLog.d("QIMNewNotifyPush_offLine", 2, "receive msg_add_notify_to_qq... " + i);
            }
            if (i == 1)
            {
              if (!((SubMsgType0x6f.QimFriendNotifyToQQ)localObject2).msg_add_notify_to_qq.has()) {
                break label1794;
              }
              localObject2 = ((SubMsgType0x6f.QimFriendNotifyToQQ)localObject2).msg_add_notify_to_qq;
              localObject4 = new QIMFollwerAdd();
              ((QIMFollwerAdd)localObject4).uin = ((SubMsgType0x6f.AddQimFriendNotifyToQQ)localObject2).uint64_uin.get();
              ((QIMFollwerAdd)localObject4).gender = ((SubMsgType0x6f.AddQimFriendNotifyToQQ)localObject2).uint32_gender.get();
              ((QIMFollwerAdd)localObject4).careSCount = ((SubMsgType0x6f.AddQimFriendNotifyToQQ)localObject2).uint64_cares_count.get();
              ((QIMFollwerAdd)localObject4).totalNum = ((SubMsgType0x6f.AddQimFriendNotifyToQQ)localObject2).uint64_storys_total_num.get();
              ((QIMFollwerAdd)localObject4).smartRemark = ((SubMsgType0x6f.AddQimFriendNotifyToQQ)localObject2).bytes_smart_remark.get().toStringUtf8();
              ((QIMFollwerAdd)localObject4).opType = ((SubMsgType0x6f.AddQimFriendNotifyToQQ)localObject2).uint32_op_type.get();
              ((QIMFollwerAdd)localObject4).fansCount = ((SubMsgType0x6f.AddQimFriendNotifyToQQ)localObject2).uint64_fans_count.get();
              ((QIMFollwerAdd)localObject4).longNick = RichStatus.parseStatus(((SubMsgType0x6f.AddQimFriendNotifyToQQ)localObject2).bytes_longnick.get().toByteArray()).getPlainText();
              ((QIMFollwerAdd)localObject4).upTime = MessageCache.a();
              ((QIMFollwerAdd)localObject4).source = ((SubMsgType0x6f.AddQimFriendNotifyToQQ)localObject2).bytes_src_wording.get().toStringUtf8();
              ((NewFriendManager)paramMessageHandler.b.getManager(33)).b((QIMFollwerAdd)localObject4);
              break label1794;
            }
            if ((i == 2) || (i != 3) || (!((SubMsgType0x6f.QimFriendNotifyToQQ)localObject2).msg_add_not_login_frd_notify_to_qq.has())) {
              break label1794;
            }
            localObject2 = (SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)((SubMsgType0x6f.QimFriendNotifyToQQ)localObject2).msg_add_not_login_frd_notify_to_qq.get();
            localObject4 = new QIMNotifyAddFriend();
            ((QIMNotifyAddFriend)localObject4).uin = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject2).uint64_uin.get();
            ((QIMNotifyAddFriend)localObject4).qqUin = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject2).uint64_qq_uin.get();
            ((QIMNotifyAddFriend)localObject4).nickName = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject2).bytes_nick.get().toStringUtf8();
            ((QIMNotifyAddFriend)localObject4).gender = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject2).uint32_gender.get();
            ((QIMNotifyAddFriend)localObject4).age = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject2).uint32_age.get();
            ((QIMNotifyAddFriend)localObject4).coverStory = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject2).bytes_coverstory.get().toStringUtf8();
            ((QIMNotifyAddFriend)localObject4).storyTotalNum = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject2).uint64_storys_total_num.get();
            ((QIMNotifyAddFriend)localObject4).wording = ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject2).bytes_wording.get().toStringUtf8();
            i = 0;
            while (i < ((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject2).rpt_msg_video_info.size())
            {
              localObject5 = (SubMsgType0x6f.VideoInfo)((SubMsgType0x6f.AddQimNotLoginFrdNotifyToQQ)localObject2).rpt_msg_video_info.get(i);
              localObject6 = new QIMNotifyAddFriend.VideoInfo();
              ((QIMNotifyAddFriend.VideoInfo)localObject6).coverUrl = ((SubMsgType0x6f.VideoInfo)localObject5).bytes_video_cover_url.get().toStringUtf8();
              ((QIMNotifyAddFriend.VideoInfo)localObject6).videoVid = ((SubMsgType0x6f.VideoInfo)localObject5).bytes_vid.get().toStringUtf8();
              ((QIMNotifyAddFriend)localObject4).videoInfos.add(localObject6);
              i += 1;
            }
            ((QIMNotifyAddFriend)localObject4).pushTime = MessageCache.a();
            if (QLog.isColorLevel()) {
              QLog.d("QIMNewNotifyPush_offLine", 2, "receive data= " + ((QIMNotifyAddFriend)localObject4).toString());
            }
            ((QIMNewFriendManager)paramMessageHandler.b.getManager(256)).a((QIMNotifyAddFriend)localObject4);
            break label1794;
            if (QLog.isColorLevel()) {
              QLog.d("TurnBrand", 2, "decode recv msg0x210.Submsgtype0x6e");
            }
            localObject2 = (RecommendTroopManagerImp)paramMessageHandler.b.getManager(21);
            if (localObject2 != null) {
              ((RecommendTroopManagerImp)localObject2).a();
            }
            a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
            return;
            if (QLog.isColorLevel()) {
              QLog.d("nearbyTroopPush", 2, "receive offline msgtype0x210.submsgtype0x67 group recmd msg");
            }
            localObject4 = new submsgtype0x67.MsgBody();
            try
            {
              ((submsgtype0x67.MsgBody)localObject4).mergeFrom(((msg_comm.MsgType0x210)localObject2).msg_content.get().toByteArray());
              if (((submsgtype0x67.MsgBody)localObject4).rpt_msg_grpinfo.has())
              {
                localObject2 = ((submsgtype0x67.MsgBody)localObject4).rpt_msg_grpinfo.get();
                localObject4 = (LBSHandler)paramMessageHandler.b.a(3);
                if (localObject4 != null) {
                  ((LBSHandler)localObject4).a((List)localObject2);
                }
              }
              a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
              return;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("nearbyTroopPush", 2, "receive offline msgtype0x210.submsgtype0x67 mergeFrom exception: " + localException2.toString());
                }
              }
            }
            ((QPayHandler)paramMessageHandler.b.a(47)).a(true);
            a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
            return;
            paramLong = paramMsg.msg_head.to_uin.get();
            l1 = paramMsg.msg_head.from_uin.get();
            j = paramMsg.msg_head.msg_seq.get();
            l2 = paramMsg.msg_head.msg_uid.get();
            int k = paramMsg.msg_head.msg_type.get();
            if (a(paramMessageHandler.b, localException2.msg_content.get().toByteArray(), l1, paramLong, j, k, i)) {
              paramMessageHandler.a().a("handleActivateFriendsPush2", true, 1, true, false);
            }
            a(paramMessageHandler, l1, j, l2, k);
            return;
            paramMsg.msg_head.from_uin.get();
            i = paramMsg.msg_head.msg_seq.get();
            paramMsg.msg_head.msg_uid.get();
            j = paramMsg.msg_head.msg_type.get();
            if (QLog.isDevelopLevel()) {
              QLog.d("Q.msg.MessageHandler", 4, "decodeC2CMsgPkg_MsgType0x210 receive 0x7c push message, seq = " + i + ", submsgtype:" + j);
            }
            paramMsg = new submsgtype0x7c.MsgBody();
            try
            {
              paramMsg.mergeFrom(localException2.msg_content.get().toByteArray());
              paramLong = paramMsg.uint64_uin.get();
              if (!paramMessageHandler.b.getCurrentAccountUin().equals(String.valueOf(paramLong))) {
                break;
              }
              ((SecSpyFileManager)paramMessageHandler.b.getManager(93)).a(paramMsg, 1);
              return;
            }
            catch (InvalidProtocolBufferMicroException paramMessageHandler) {}
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("Q.msg.MessageHandler", 2, "parse 0x7c push msg error", paramMessageHandler);
          return;
          try
          {
            localObject4 = new SubMsgType0x87.MsgBody();
            ((SubMsgType0x87.MsgBody)localObject4).mergeFrom(localException2.msg_content.get().toByteArray());
            if (((SubMsgType0x87.MsgBody)localObject4).rpt_msg_msg_notify.has()) {
              CloneFriendPushHelper.a(paramMessageHandler.b, (SubMsgType0x87.MsgBody)localObject4);
            }
            a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
            return;
          }
          catch (Exception localException3)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("Q.msg.MessageHandler", 2, "offline push parse 0x210 subtype 0x87 msg error", localException3);
              }
            }
          }
          if (paramBoolean2) {
            break;
          }
          paramMsg = new Submsgtype0x8a.ReqBody();
          try
          {
            paramMsg.mergeFrom(localException3.msg_content.get().toByteArray());
            a(paramMessageHandler.b, paramMsg, 0L, false);
            return;
          }
          catch (Exception paramMessageHandler) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b offline msg, prase reqBody error");
          return;
          localObject4 = new SubMsgType0x9b.MsgBody();
          DingdongPluginBizHandler localDingdongPluginBizHandler;
          try
          {
            ((SubMsgType0x9b.MsgBody)localObject4).mergeFrom(localException3.msg_content.get().toByteArray());
            localDingdongPluginBizHandler = (DingdongPluginBizHandler)paramMessageHandler.b.a(75);
            localObject5 = (DingdongPluginManager)paramMessageHandler.b.getManager(114);
            if (localDingdongPluginBizHandler != null) {
              localDingdongPluginBizHandler.a((SubMsgType0x9b.MsgBody)localObject4, true);
            }
            a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
            return;
          }
          catch (InvalidProtocolBufferMicroException paramMessageHandler)
          {
            paramMessageHandler.printStackTrace();
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "handleMsgType0x210SubMsgType0xaa receive 0xaa push message");
          }
          localObject4 = new SubMsgType0xaa.MsgBody();
          try
          {
            ((SubMsgType0xaa.MsgBody)localObject4).mergeFrom(localDingdongPluginBizHandler.msg_content.get().toByteArray());
            ((GamePartyManager)paramMessageHandler.b.getManager(155)).a((SubMsgType0xaa.MsgBody)localObject4, true);
            a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
            return;
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "handleMsgType0x210SubMsgType0xaa, prase msgBody error");
              }
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "handleMsgType0x210SubMsgType0xae receive 0xae push message");
          }
          localObject4 = new SubMsgType0xae.MsgBody();
          for (;;)
          {
            try
            {
              ((SubMsgType0xae.MsgBody)localObject4).mergeFrom(localException4.msg_content.get().toByteArray());
              if ((((SubMsgType0xae.MsgBody)localObject4).uint32_type.has()) && (((SubMsgType0xae.MsgBody)localObject4).uint32_type.get() == 2))
              {
                paramLong = ((SubMsgType0xae.MsgBody)localObject4).msg_persons_may_know.fixed32_timestamp.get();
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.MessageHandler", 2, "handlePushRecommend receive push time=" + paramLong);
                }
                localObject4 = ((SubMsgType0xae.MsgBody)localObject4).msg_persons_may_know.rpt_msg_friend_list.get();
                if ((localObject4 != null) && (((List)localObject4).size() > 0))
                {
                  ArrayList localArrayList = new ArrayList(((List)localObject4).size());
                  localObject4 = ((List)localObject4).iterator();
                  if (!((Iterator)localObject4).hasNext()) {
                    break label4587;
                  }
                  localObject5 = (SubMsgType0xae.PersonMayKnow)((Iterator)localObject4).next();
                  localObject6 = new PushRecommend();
                  if (((SubMsgType0xae.PersonMayKnow)localObject5).uint64_uin.has()) {
                    ((PushRecommend)localObject6).uin = Long.toString(((SubMsgType0xae.PersonMayKnow)localObject5).uint64_uin.get());
                  }
                  if (((SubMsgType0xae.PersonMayKnow)localObject5).bytes_name.has()) {
                    ((PushRecommend)localObject6).nick = new String(((SubMsgType0xae.PersonMayKnow)localObject5).bytes_name.get().toByteArray());
                  }
                  if (((SubMsgType0xae.PersonMayKnow)localObject5).uint32_age.has()) {
                    ((PushRecommend)localObject6).age = ((short)((SubMsgType0xae.PersonMayKnow)localObject5).uint32_age.get());
                  }
                  if (((SubMsgType0xae.PersonMayKnow)localObject5).uint32_sex.has()) {
                    ((PushRecommend)localObject6).gender = ((short)((SubMsgType0xae.PersonMayKnow)localObject5).uint32_sex.get());
                  }
                  if (((SubMsgType0xae.PersonMayKnow)localObject5).bytes_main_reason.has()) {
                    ((PushRecommend)localObject6).recommendReason = new String(((SubMsgType0xae.PersonMayKnow)localObject5).bytes_main_reason.get().toByteArray());
                  }
                  if (((SubMsgType0xae.PersonMayKnow)localObject5).bytes_alghrithm.has()) {
                    ((PushRecommend)localObject6).algBuffer = ((SubMsgType0xae.PersonMayKnow)localObject5).bytes_alghrithm.get().toByteArray();
                  }
                  if (((SubMsgType0xae.PersonMayKnow)localObject5).bytes_soure_reason.has()) {
                    ((PushRecommend)localObject6).sourceReason = new String(((SubMsgType0xae.PersonMayKnow)localObject5).bytes_soure_reason.get().toByteArray());
                  }
                  if (((SubMsgType0xae.PersonMayKnow)localObject5).uint32_source.has()) {
                    ((PushRecommend)localObject6).fromSource = ((SubMsgType0xae.PersonMayKnow)localObject5).uint32_source.get();
                  }
                  if (((SubMsgType0xae.PersonMayKnow)localObject5).msg_android_source.has())
                  {
                    localObject7 = (SubMsgType0xae.AddFriendSource)((SubMsgType0xae.PersonMayKnow)localObject5).msg_android_source.get();
                    if (localObject7 != null)
                    {
                      if (((SubMsgType0xae.AddFriendSource)localObject7).uint32_source.has()) {
                        ((PushRecommend)localObject6).sourceId = ((SubMsgType0xae.AddFriendSource)localObject7).uint32_source.get();
                      }
                      if (((SubMsgType0xae.AddFriendSource)localObject7).uint32_sub_source.has()) {
                        ((PushRecommend)localObject6).subSourceId = ((SubMsgType0xae.AddFriendSource)localObject7).uint32_sub_source.get();
                      }
                    }
                  }
                  if (((SubMsgType0xae.PersonMayKnow)localObject5).bytes_msg.has()) {
                    ((PushRecommend)localObject6).wzryVerifyStr = new String(((SubMsgType0xae.PersonMayKnow)localObject5).bytes_msg.get().toByteArray());
                  }
                  if (((SubMsgType0xae.PersonMayKnow)localObject5).uint32_game_source.has()) {
                    ((PushRecommend)localObject6).wzrySourceId = ((SubMsgType0xae.PersonMayKnow)localObject5).uint32_game_source.get();
                  }
                  if (((SubMsgType0xae.PersonMayKnow)localObject5).bytes_role_name.has()) {
                    ((PushRecommend)localObject6).wzryGameNick = new String(((SubMsgType0xae.PersonMayKnow)localObject5).bytes_role_name.get().toByteArray());
                  }
                  ((PushRecommend)localObject6).timestamp = paramLong;
                  localArrayList.add(localObject6);
                  continue;
                }
              }
              ((MayknowRecommendManager)paramMessageHandler.b.getManager(158)).a(localException5, paramLong);
            }
            catch (Exception localException5)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MayknowRecommendManager", 2, "recv 0x210_0xae, prase msgBody error");
              }
              a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
              return;
            }
            ((FriendListHandler)paramMessageHandler.b.a(1)).a(109, true, null);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "handleMsgType0x210SubMsgType0xb3 receive 0xaa push message");
          }
          paramMsg = ((OnLinePushMessageProcessor)paramMessageHandler.a("businessbase_processor")).a(localException5.msg_content.get().toByteArray());
          if (TextUtils.isEmpty(paramMsg)) {
            break;
          }
          paramBoolean1 = ((FriendsManager)paramMessageHandler.b.getManager(50)).b(paramMsg);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "handleMsgType0x210SubMsgType0xb3 isFriend=" + paramBoolean1 + ", uin=" + paramMsg);
          }
          if (paramBoolean1) {
            break;
          }
          QLog.d("Q.msg.MessageHandler", 1, "handleMsgType0x210SubMsgType0xb3 not friend, getDetail");
          ((FriendListHandler)paramMessageHandler.b.a(1)).a(paramMsg);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "handleMsgType0x210SubMsgType0xc5 receive 0xc5 push message");
          }
          ((OnLinePushMessageProcessor)paramMessageHandler.a("businessbase_processor")).a(localException5.msg_content.get().toByteArray(), paramMsg.msg_head.msg_time.get());
          a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "handleMsgType0x210SubMsgType0xee receive 0xee push message");
          }
          ((OnLinePushMessageProcessor)paramMessageHandler.a("businessbase_processor")).b(localException5.msg_content.get().toByteArray(), paramMsg.msg_head.msg_time.get());
          a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
          return;
          localObject4 = (OnLinePushMessageProcessor)paramMessageHandler.a("businessbase_processor");
          localObject5 = new MsgInfo();
          ((MsgInfo)localObject5).lFromUin = paramMsg.msg_head.from_uin.get();
          ((MsgInfo)localObject5).shMsgSeq = ((short)paramMsg.msg_head.msg_seq.get());
          ((MsgInfo)localObject5).uMsgTime = paramMsg.msg_head.msg_time.get();
          ((MsgInfo)localObject5).uRealMsgTime = paramMsg.msg_head.msg_time.get();
          ((MsgInfo)localObject5).lMsgUid = paramMsg.msg_head.msg_uid.get();
          ((MsgInfo)localObject5).shMsgType = ((short)paramMsg.msg_head.msg_type.get());
          ((OnLinePushMessageProcessor)localObject4).a(localException5.msg_content.get().toByteArray(), 2, (MsgInfo)localObject5);
          a(paramMessageHandler, ((MsgInfo)localObject5).lFromUin, ((MsgInfo)localObject5).shMsgSeq, ((MsgInfo)localObject5).lMsgUid, ((MsgInfo)localObject5).shMsgType);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("HotFriend_PushMessage", 2, "handleMsgType0x210SubMsgType0xc7  push message");
          }
          paramLong = paramMsg.msg_head.from_uin.get();
          i = paramMsg.msg_head.msg_seq.get();
          l1 = paramMsg.msg_head.msg_uid.get();
          j = paramMsg.msg_head.msg_type.get();
          paramMsg = new HotReactivePushMsg(paramLong, i, l1, j);
          ((OnLinePushMessageProcessor)paramMessageHandler.a("businessbase_processor")).a(localException5.msg_content.get().toByteArray(), paramMsg);
          a(paramMessageHandler, paramLong, i, l1, j);
          return;
          paramLong = paramMsg.msg_head.from_uin.get();
          i = paramMsg.msg_head.msg_seq.get();
          l1 = paramMsg.msg_head.msg_uid.get();
          j = paramMsg.msg_head.msg_type.get();
          if (QLog.isDevelopLevel()) {
            QLog.d("Q.msg.MessageHandler", 4, "decodeC2CMsgPkg_MsgType0x210 receive 0xca push message, seq = " + i + ", submsgtype:" + j);
          }
          paramMsg = new submsgtype0xca.MsgBody();
          try
          {
            paramMsg.mergeFrom(localException5.msg_content.get().toByteArray());
            l2 = paramMsg.uint64_uin.get();
            if ((!paramMessageHandler.b.getCurrentAccountUin().equals(String.valueOf(l2))) && (l2 != 0L)) {
              break;
            }
            ((ApolloManager)paramMessageHandler.b.getManager(152)).a(paramMsg, "offLine push");
            a(paramMessageHandler, paramLong, i, l1, j);
            return;
          }
          catch (InvalidProtocolBufferMicroException paramMessageHandler) {}
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.msg.MessageHandler", 2, "parse 0xca push msg error", paramMessageHandler);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.nearby.tag_nearby_live_tip", 4, "decodeC2CMsgPkg_MsgType0x210 receive 0xcb push message");
        }
        localObject3 = a(paramMessageHandler, localException5.msg_content.get().toByteArray(), paramMsg);
        if ((localObject3 == null) || (MessageHandlerUtils.a(paramMessageHandler.b, (MessageRecord)localObject3, true)) || (((MessageRecord)localObject3).msgtype != -2053)) {
          break;
        }
        paramMsg = (MessageForNearbyLiveTip)localObject3;
        if ((MessageForNearbyLiveTip.isHuayangTip(paramMsg.jumpingUrl)) && (!MessageForNearbyLiveTip.isSupportHuayangBusinessType(paramMsg.jumpingUrl)))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.nearby.tag_nearby_live_tip", 2, "decodeC2CMsgPkg_MsgType0x210 discard a not support huayang tips message, jumpUrl=" + paramMsg.jumpingUrl);
          return;
        }
        if (paramMsg.isLiving)
        {
          paramMessageHandler.b.a().a((MessageRecord)localObject3, paramMessageHandler.b.getCurrentAccountUin());
          return;
        }
        localObject4 = paramMessageHandler.b.a().a(paramMsg.frienduin, paramMsg.istroop);
        if (localObject4 != null)
        {
          paramMessageHandler.b.a().a(paramMsg.frienduin, paramMsg.istroop, ((MessageRecord)localObject4).uniseq, paramMsg.msgData);
          localObject3 = new ArrayList();
          ((ArrayList)localObject3).add(paramMsg);
          paramMessageHandler.b.a().c((List)localObject3);
          return;
        }
        paramMessageHandler.b.a().a((MessageRecord)localObject3, paramMessageHandler.b.getCurrentAccountUin());
        return;
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.MessageHandler", 2, "MessageProtoCodec,decodeC2CMsgPkg_MsgType0x210 receive 0xd7 push message");
        }
        paramLong = paramMsg.msg_head.from_uin.get();
        i = paramMsg.msg_head.msg_seq.get();
        l1 = paramMsg.msg_head.msg_uid.get();
        j = paramMsg.msg_head.msg_type.get();
        ((MsgBoxInterFollowManager)paramMessageHandler.b.getManager(201)).decode0xd7InteractAndFollowMsg(((msg_comm.MsgType0x210)localObject3).msg_content.get().toByteArray());
        a(paramMessageHandler, paramLong, i, l1, j);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.MessageHandler", 2, "MessageProtoCodec,decodeC2CMsgPkg_MsgType0x210 receive 0xdc push message");
        }
        localObject4 = (ApolloManager)paramMessageHandler.b.getManager(152);
        if (localObject4 != null) {
          ((ApolloManager)localObject4).a(((msg_comm.MsgType0x210)localObject3).msg_content.get().toByteArray());
        }
        a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
        return;
        QLog.d("ApolloPushManager", 1, "recv action push message 0x210_0xe8, [C2C.offline]");
        try
        {
          paramMsg = new submsgtype0xe8.MsgBody();
          paramMsg.mergeFrom(((msg_comm.MsgType0x210)localObject3).msg_content.get().toByteArray());
          if (!paramMsg.msg_item.has()) {
            break;
          }
          paramMsg = (apollo_push_msgInfo.STPushMsgElem)paramMsg.msg_item.get();
          if (paramMessageHandler.b == null) {
            break;
          }
          paramMessageHandler = (ApolloPushManager)paramMessageHandler.b.getManager(226);
          paramMessageHandler.a(0, paramMsg);
          paramMessageHandler.b(paramMsg);
          paramMessageHandler.a(paramMsg);
          return;
        }
        catch (Exception paramMessageHandler)
        {
          paramMessageHandler.printStackTrace();
          QLog.e("ApolloPushManager", 1, "[msg0x210.uSubMsgType == 0xe8], errInfo->" + paramMessageHandler.getMessage());
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_MsgType0x210 invoked. info: AIO Feed offline messageRecord: 0xf4");
      }
      paramLong = paramMsg.msg_head.from_uin.get();
      paramMsg = ((msg_comm.MsgType0x210)localObject3).msg_content.get().toByteArray();
      paramMessageHandler = (QQStoryFeedManager)paramMessageHandler.b.getManager(252);
      paramMessageHandler.a(paramMessageHandler.a(paramMsg, String.valueOf(paramLong)));
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_MsgType0x210 invoked. info: 0xfb");
      }
      try
      {
        localObject4 = new NowPushMsgList.MsgBody();
        ((NowPushMsgList.MsgBody)localObject4).mergeFrom(((msg_comm.MsgType0x210)localObject3).msg_content.get().toByteArray());
        localObject3 = ((NowPushMsgList.MsgBody)localObject4).rpt_now_push_msg.get().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (NowPushMsgList.NowPushMsg)((Iterator)localObject3).next();
          if (paramMessageHandler.b != null) {
            ((NowHongbaoPushManager)paramMessageHandler.b.getManager(265)).b((NowPushMsgList.NowPushMsg)localObject4);
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_MsgType0x210 0xfb " + ((NowPushMsgList.NowPushMsg)localObject4).uint32_switch.get() + "  uint32_task_id " + ((NowPushMsgList.NowPushMsg)localObject4).uint32_task_id.get() + "  uint32_type " + ((NowPushMsgList.NowPushMsg)localObject4).uint32_type.get() + "  uint64_start_time " + ((NowPushMsgList.NowPushMsg)localObject4).uint64_start_time.get() + "  uint64_end_time " + ((NowPushMsgList.NowPushMsg)localObject4).uint64_end_time.get() + " app=" + paramMessageHandler.b);
          }
        }
        a(paramMessageHandler, paramMsg.msg_head.from_uin.get(), paramMsg.msg_head.msg_seq.get(), paramMsg.msg_head.msg_uid.get(), paramMsg.msg_head.msg_type.get());
      }
      catch (Exception paramMessageHandler)
      {
        QLog.e("Q.msg.MessageHandler", 1, "[msg0x210.uSubMsgType == 0xfb], errInfo->" + paramMessageHandler.getMessage());
        return;
      }
      return;
      label6376:
      j = 0;
      break label1999;
      label6382:
      if (i == 0) {
        if (j == 0) {
          break label1794;
        }
      }
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, MsgInfo paramMsgInfo, SlaveMasterMsg paramSlaveMasterMsg)
  {
    Object localObject1 = new SubMsgType0x4.MsgBody();
    try
    {
      localObject2 = (SubMsgType0x4.MsgBody)((SubMsgType0x4.MsgBody)localObject1).mergeFrom(paramSlaveMasterMsg.vOrigMsg);
      if (!((SubMsgType0x4.MsgBody)localObject2).msg_not_online_file.has())
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : MsgBody has not NotOnlineFile");
        }
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramMessageHandler)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x4] failed", paramMessageHandler);
      return;
    }
    im_msg_body.NotOnlineFile localNotOnlineFile = (im_msg_body.NotOnlineFile)((SubMsgType0x4.MsgBody)localObject2).msg_not_online_file.get();
    localObject1 = null;
    if (((SubMsgType0x4.MsgBody)localObject2).file_image_info.has()) {
      localObject1 = (hummer_resv_21.FileImgInfo)((SubMsgType0x4.MsgBody)localObject2).file_image_info.get();
    }
    Object localObject2 = new ArrayList();
    msg_comm.Msg localMsg = new msg_comm.Msg();
    localMsg.msg_head.msg_uid.set(paramMsgInfo.lMsgUid);
    localMsg.msg_head.msg_time.set(paramMsgInfo.uRealMsgTime);
    localMsg.msg_head.from_uin.set(paramSlaveMasterMsg.lFromUin);
    localMsg.msg_head.msg_seq.set((int)paramSlaveMasterMsg.uSeq);
    paramMessageHandler.b.a().a(paramMessageHandler, (List)localObject2, localMsg, localNotOnlineFile, String.valueOf(paramSlaveMasterMsg.lToUin), true, false, -100L, -1, (hummer_resv_21.FileImgInfo)localObject1);
  }
  
  public static void a(MessageHandler paramMessageHandler, List paramList, int paramInt1, msg_comm.Msg paramMsg, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong2, boolean paramBoolean4, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder("<---decodeC2CMsgPkg_OfflineFile : ");
    localStringBuilder.append(" c2cCmd:").append(paramInt1).append(";friendUin:").append(paramLong1).append(";isReaded:").append(paramBoolean1).append(";isPullRoam:").append(paramBoolean2).append(";isSelfSender:").append(paramBoolean3).append(";\n");
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
    int i = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_OfflineFile return null:hasBody:" + paramMsg.msg_body.has() + "hasRichT:" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has());
      }
    }
    label899:
    label1114:
    for (;;)
    {
      return;
      Object localObject1 = (im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get();
      Object localObject2 = (im_msg_body.NotOnlineFile)((im_msg_body.RichText)localObject1).not_online_file.get();
      if (!((im_msg_body.RichText)localObject1).not_online_file.has())
      {
        localStringBuilder.append("hasNotOnlineFile:").append(((im_msg_body.RichText)localObject1).not_online_file.has()).append(";hasUUID:").append(((im_msg_body.NotOnlineFile)localObject2).bytes_file_uuid.has());
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
        }
      }
      else if ((paramInt1 == 169) || (paramInt1 == 243))
      {
        if (!paramBoolean4)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant>offlineFile come: c2cCmd[" + paramInt1 + "]");
          }
          paramMessageHandler.b.a().a(paramMessageHandler, paramList, paramMsg, (im_msg_body.NotOnlineFile)localObject2, String.valueOf(paramLong1), paramBoolean1, paramBoolean2, paramLong2, paramInt2, null);
        }
      }
      else
      {
        paramMsg = null;
        String str = new String(((im_msg_body.NotOnlineFile)localObject2).bytes_file_uuid.get().toStringUtf8() + l1);
        localObject1 = ((im_msg_body.NotOnlineFile)localObject2).bytes_file_uuid.get().toStringUtf8();
        localStringBuilder.append("     NotOnLineFile info : serverPath:").append((String)localObject1).append(";fileKey :").append(str).append(";");
        if (!paramMessageHandler.a().a(str))
        {
          str = ((im_msg_body.NotOnlineFile)localObject2).bytes_file_name.get().toStringUtf8();
          localStringBuilder.append("strFileName:").append(str).append(";");
          paramLong1 = ((im_msg_body.NotOnlineFile)localObject2).uint64_file_size.get();
          if ((paramInt1 == 241) || (MessageUtils.a(str, paramInt1)))
          {
            paramMessageHandler = new RichMsg.PicRec();
            paramMessageHandler.localPath.set((String)localObject1);
            paramMessageHandler.size.set(paramLong1);
            paramMessageHandler.type.set(1);
            paramMessageHandler.isRead.set(false);
            paramMessageHandler.uuid.set((String)localObject1);
            paramMessageHandler.serverStorageSource.set("ftn");
            paramMessageHandler.version.set(5);
            paramMessageHandler.isReport.set(0);
            paramMsg = (MessageForPic)MessageRecordFactory.a(-2000);
            paramMsg.msgtype = -2000;
            paramMsg.msgData = paramMessageHandler.toByteArray();
            paramMsg.parse();
            paramList.add(paramMsg);
            paramMsg = null;
            localStringBuilder.append("protocolStr:").append(paramMsg).append(";");
          }
        }
        for (;;)
        {
          if (!QLog.isColorLevel()) {
            break label1114;
          }
          QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
          return;
          if ((paramInt1 != 242) && (!MessageUtils.b(str, paramInt1))) {
            break;
          }
          if ((str != null) && (!str.equals("")))
          {
            if (!str.contains("_")) {}
            for (paramMsg = str.substring(0, str.length() - 4);; paramMsg = str.substring(str.lastIndexOf("_") + 1, str.length() - 4))
            {
              paramMsg = l2 + paramMsg;
              localStringBuilder.append("c2cCmd:0xf2;key:").append(paramMsg).append(";");
              if (paramBoolean4) {
                break label899;
              }
              if (!StreamDataManager.e(paramMsg)) {
                break;
              }
              localStringBuilder.append("DuplicateKey:").append(paramMsg).append(";");
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
              }
              StreamDataManager.d(paramMsg);
              return;
            }
            StreamDataManager.c(paramMsg);
          }
          for (;;)
          {
            paramMsg = TransfileUtile.a((String)localObject1, paramLong1, 2, false, (String)localObject1, null, "ftn");
            localObject2 = new RichMsg.PttRec();
            ((RichMsg.PttRec)localObject2).localPath.set((String)localObject1);
            ((RichMsg.PttRec)localObject2).size.set(paramLong1);
            ((RichMsg.PttRec)localObject2).type.set(2);
            ((RichMsg.PttRec)localObject2).uuid.set((String)localObject1);
            ((RichMsg.PttRec)localObject2).isRead.set(false);
            ((RichMsg.PttRec)localObject2).serverStorageSource.set("ftn");
            ((RichMsg.PttRec)localObject2).isReport.set(0);
            ((RichMsg.PttRec)localObject2).version.set(5);
            paramLong1 = System.currentTimeMillis() / 1000L;
            ((RichMsg.PttRec)localObject2).msgRecTime.set(paramLong1);
            ((RichMsg.PttRec)localObject2).msgTime.set(l1);
            localObject1 = (MessageForPtt)MessageRecordFactory.a(-2002);
            ((MessageForPtt)localObject1).msgtype = -2002;
            ((MessageForPtt)localObject1).msgData = ((RichMsg.PttRec)localObject2).toByteArray();
            ((MessageForPtt)localObject1).parse();
            paramList.add(localObject1);
            PttInfoCollector.a(paramMessageHandler.b, 1, false, 4);
            break;
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "offline ptt no filename");
            }
          }
          localStringBuilder.append("rcv a repeated offline file push msg");
        }
      }
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg)
  {
    long l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {}
    Object localObject5;
    im_msg_body.Ptt localPtt;
    do
    {
      return;
      localObject5 = (im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get();
      localPtt = (im_msg_body.Ptt)((im_msg_body.RichText)localObject5).ptt.get();
      if ((((im_msg_body.RichText)localObject5).ptt.has()) && (localPtt.uint32_file_type.has()) && ((localPtt.uint32_file_type.get() == 4) || (localPtt.uint32_file_type.get() == 6)) && (localPtt.bytes_file_uuid.has())) {
        break;
      }
    } while (!QLog.isColorLevel());
    paramMessageHandler = new StringBuilder("<---decodeC2CMsgPkg_PTT return null:");
    if (localPtt == null) {
      paramMessageHandler.append(" ptt is null.");
    }
    for (;;)
    {
      QLog.d("Q.msg.MessageHandler", 2, paramMessageHandler.toString());
      return;
      paramMessageHandler.append(" HasileType:").append(localPtt.uint32_file_type.has()).append(" fileType:").append(localPtt.uint32_file_type.get()).append(" hasUUID:").append(localPtt.bytes_file_uuid.has());
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "PTT_ROAM : decodeC2CMsgPkg_PTT. fileType : " + localPtt.uint32_file_type.get());
    }
    int i4;
    long l1;
    Object localObject4;
    int i;
    Object localObject1;
    int j;
    label353:
    int i2;
    int i7;
    int i8;
    Object localObject2;
    long l2;
    int i1;
    int i5;
    int i6;
    if (SttManager.a(paramMessageHandler.b))
    {
      i4 = 1;
      l1 = -1L;
      if (!localPtt.bytes_reserve.has()) {
        break label1572;
      }
      localObject4 = localPtt.bytes_reserve.get().toByteArray();
      if ((localObject4 == null) || (localObject4.length <= 1)) {
        break label1572;
      }
      i = localObject4[0];
      localObject1 = "";
      j = 0;
      i = 0;
      m = 0;
      k = 0;
      n = 1;
      if (n >= localObject4.length - 1) {
        break label861;
      }
      i2 = localObject4[n];
      n += 1;
      i7 = PkgTools.a((byte[])localObject4, n);
      i8 = n + 2;
      if (i2 != 3) {
        break label556;
      }
      localObject2 = new byte[i7];
      PkgTools.a((byte[])localObject2, 0, (byte[])localObject4, i8, i7);
      l2 = PkgTools.a((byte[])localObject2, 0);
      if (l2 > 0L) {
        l1 = l2;
      }
      localObject2 = localObject1;
      n = j;
      i1 = i;
      i5 = m;
      i6 = k;
      l2 = l1;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.MessageHandler", 2, "PTT_ROAM : TimeStamp in d0 :" + l1);
        l2 = l1;
        i6 = k;
        i5 = m;
        i1 = i;
        n = j;
        localObject2 = localObject1;
      }
    }
    for (;;)
    {
      i2 = i8 + i7;
      localObject1 = localObject2;
      j = n;
      i = i1;
      m = i5;
      k = i6;
      n = i2;
      l1 = l2;
      break label353;
      i4 = 0;
      break;
      label556:
      Object localObject6;
      int i3;
      if (i2 == 9)
      {
        localObject2 = new byte[i7];
        PkgTools.a((byte[])localObject2, 0, (byte[])localObject4, i8, i7);
        i5 = RecordParams.b(Utils.a(PkgTools.a((byte[])localObject2, 0)));
        localObject2 = localObject1;
        n = j;
        i1 = i;
        i6 = k;
        l2 = l1;
      }
      else if (i2 == 8)
      {
        localObject2 = new byte[i7];
        PkgTools.a((byte[])localObject2, 0, (byte[])localObject4, i8, i7);
        i6 = (int)PkgTools.a((byte[])localObject2, 0);
        localObject2 = localObject1;
        n = j;
        i1 = i;
        i5 = m;
        l2 = l1;
      }
      else
      {
        localObject2 = localObject1;
        n = j;
        i1 = i;
        i5 = m;
        i6 = k;
        l2 = l1;
        if (i2 == 10)
        {
          localObject2 = new byte[i7];
          PkgTools.a((byte[])localObject2, 0, (byte[])localObject4, i8, i7);
          localObject6 = new ptt_reserve.ReserveStruct();
          i2 = j;
          i3 = i;
        }
      }
      try
      {
        ((ptt_reserve.ReserveStruct)localObject6).mergeFrom((byte[])localObject2);
        i2 = j;
        i3 = i;
        i = ((ptt_reserve.ReserveStruct)localObject6).uint32_change_voice.get();
        i2 = j;
        i3 = i;
        j = ((ptt_reserve.ReserveStruct)localObject6).uint32_redpack_type.get();
        localObject2 = localObject1;
        n = j;
        i1 = i;
        i5 = m;
        i6 = k;
        l2 = l1;
        i2 = j;
        i3 = i;
        if (((ptt_reserve.ReserveStruct)localObject6).bytes_redpack_score_id.has())
        {
          i2 = j;
          i3 = i;
          localObject2 = ((ptt_reserve.ReserveStruct)localObject6).bytes_redpack_score_id.get().toStringUtf8();
          n = j;
          i1 = i;
          i5 = m;
          i6 = k;
          l2 = l1;
        }
      }
      catch (Exception localException)
      {
        label861:
        localObject3 = localObject1;
        n = i2;
        i1 = i3;
        i5 = m;
        i6 = k;
        l2 = l1;
      }
    }
    int n = m;
    int m = k;
    int k = n;
    for (;;)
    {
      if (localPtt.bytes_down_para.has())
      {
        localObject2 = localPtt.bytes_down_para.get();
        if (localObject2 == null) {}
      }
      label1501:
      label1528:
      Object localObject3;
      for (localObject2 = ((ByteStringMicro)localObject2).toStringUtf8();; localObject3 = "")
      {
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          n = 1;
          ReportController.b(paramMessageHandler.b, "CliOper", "", "", "0X80060E4", "0X80060E4", n, 0, "", "", "", "7.6.3");
          localObject6 = localPtt.bytes_file_uuid.get().toStringUtf8();
          localObject4 = localPtt.bytes_file_name.get().toStringUtf8();
          if (((String)localObject4).contains("_")) {
            break label1501;
          }
        }
        for (localObject4 = ((String)localObject4).substring(0, ((String)localObject4).length() - 4);; localObject4 = ((String)localObject4).substring(((String)localObject4).lastIndexOf("_") + 1, ((String)localObject4).length() - 4))
        {
          localObject4 = l3 + "_" + (String)localObject4;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_PTT isPttSuffix offfile key：" + (String)localObject4 + " fileUuid:" + (String)localObject6);
          }
          localObject4 = new RichMsg.PttRec();
          ((RichMsg.PttRec)localObject4).localPath.set((String)localObject6);
          ((RichMsg.PttRec)localObject4).size.set(localPtt.uint32_file_size.get());
          ((RichMsg.PttRec)localObject4).type.set(2);
          ((RichMsg.PttRec)localObject4).uuid.set((String)localObject6);
          ((RichMsg.PttRec)localObject4).isRead.set(false);
          ((RichMsg.PttRec)localObject4).serverStorageSource.set("pttcenter");
          ((RichMsg.PttRec)localObject4).isReport.set(0);
          ((RichMsg.PttRec)localObject4).version.set(5);
          ((RichMsg.PttRec)localObject4).pttFlag.set(i4);
          l2 = System.currentTimeMillis() / 1000L;
          long l4 = paramMsg.msg_head.msg_time.get();
          ((RichMsg.PttRec)localObject4).msgRecTime.set(l2);
          ((RichMsg.PttRec)localObject4).msgTime.set(l4);
          ((RichMsg.PttRec)localObject4).voiceType.set(m);
          ((RichMsg.PttRec)localObject4).voiceLength.set(k);
          ((RichMsg.PttRec)localObject4).voiceChangeFlag.set(i);
          ((RichMsg.PttRec)localObject4).redpack_type.set(j);
          if (QLog.isColorLevel()) {
            QLog.d("RecordParams", 2, "<---decodeC2CMsgPkg_PTT voiceType：" + m + " voiceLengh:" + k);
          }
          i = MessageUtils.a(paramMessageHandler.b, String.valueOf(l3));
          ((RichMsg.PttRec)localObject4).longPttVipFlag.set(i);
          ((RichMsg.PttRec)localObject4).directUrl.set((String)localObject2);
          localObject2 = MessageRecordFactory.a(-2002);
          ((MessageRecord)localObject2).msgtype = -2002;
          ((MessageRecord)localObject2).msgData = ((RichMsg.PttRec)localObject4).toByteArray();
          ((MessageRecord)localObject2).time = l1;
          ((MessageForPtt)localObject2).parse();
          paramList.add(localObject2);
          if (!((im_msg_body.RichText)localObject5).elems.has()) {
            break label1528;
          }
          paramList = ((im_msg_body.RichText)localObject5).elems.get().iterator();
          while (paramList.hasNext())
          {
            localObject4 = (im_msg_body.Elem)paramList.next();
            GoldMsgChatHelper.a((im_msg_body.Elem)localObject4, (MessageRecord)localObject2);
            if ((((im_msg_body.Elem)localObject4).common_elem.has()) && (21 == ((im_msg_body.Elem)localObject4).common_elem.uint32_service_type.get()))
            {
              localObject5 = new ArrayList();
              ((ArrayList)localObject5).add(localObject2);
              ConfessMsgUtil.a(paramMsg, (im_msg_body.Elem)localObject4, (List)localObject5, paramMessageHandler.b);
            }
          }
          n = 2;
          break;
        }
        VoiceRedPacketHelper.a((String)localObject1, (MessageRecord)localObject2);
        return;
        break;
      }
      label1572:
      localObject1 = "";
      j = 0;
      i = 0;
      k = 0;
      m = 0;
      l1 = -1L;
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    msg_comm.AppShareInfo localAppShareInfo = (msg_comm.AppShareInfo)paramMsg.appshare_info.get();
    long l1;
    Object localObject1;
    Object localObject2;
    if (paramMsg.appshare_info.has())
    {
      l1 = localAppShareInfo.appshare_id.get() & 0xFFFFFFFF;
      localObject1 = (msg_comm.PluginInfo)localAppShareInfo.appshare_resource.get();
      if ((!localAppShareInfo.appshare_resource.has()) || (localObject1 == null) || (paramBoolean)) {
        break label1890;
      }
      localObject1 = AppShareIDUtil.a((msg_comm.PluginInfo)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared appShareID:" + ((AppShareID)localObject1).toString());
      }
      localObject2 = (AppShareID)paramMessageHandler.a().a(AppShareID.class, "strPkgName=?", new String[] { ((AppShareID)localObject1).strPkgName });
      if (localObject2 == null)
      {
        paramMessageHandler.a().a((Entity)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared Persist DB appid = " + ((AppShareID)localObject1).strPkgName);
        }
        paramMessageHandler.b.a().a(((AppShareID)localObject1).strPkgName, (AppShareID)localObject1);
      }
    }
    label301:
    label569:
    label1878:
    label1887:
    label1890:
    for (int i = 1;; i = 0)
    {
      Object localObject3;
      boolean bool1;
      boolean bool2;
      boolean bool3;
      if ((paramMsg.msg_body.has()) && (((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()))
      {
        localObject1 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
        paramMsg = null;
        localObject2 = BaseApplication.getContext().getString(2131436299);
        Iterator localIterator = ((List)localObject1).iterator();
        paramBoolean = false;
        localObject3 = null;
        bool1 = false;
        if (localIterator.hasNext())
        {
          localObject1 = (im_msg_body.Elem)localIterator.next();
          bool2 = ((im_msg_body.Elem)localObject1).text.has();
          bool3 = ((im_msg_body.Elem)localObject1).not_online_image.has();
          if (!bool3) {
            break label1887;
          }
          paramBoolean = true;
        }
      }
      for (;;)
      {
        if (bool2) {
          bool1 = true;
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared hasText:" + bool2 + ",hasNotOnlineImage:" + bool3);
          }
          int j;
          Object localObject4;
          if (bool3)
          {
            localObject1 = (im_msg_body.NotOnlineImage)((im_msg_body.Elem)localObject1).not_online_image.get();
            j = ((im_msg_body.NotOnlineImage)localObject1).file_len.get();
            if (!((im_msg_body.NotOnlineImage)localObject1).download_path.has()) {
              break label1878;
            }
            localObject4 = ((im_msg_body.NotOnlineImage)localObject1).download_path.get().toStringUtf8();
            localObject1 = localObject4;
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared: serverPath:" + (String)localObject4);
            }
          }
          for (localObject1 = localObject4;; localObject1 = null)
          {
            if (localObject1 != null)
            {
              localObject3 = new RichMsg.PicRec();
              localObject4 = ((RichMsg.PicRec)localObject3).localPath;
              if (localObject1 != null)
              {
                localObject2 = localObject1;
                ((PBStringField)localObject4).set((String)localObject2);
                ((RichMsg.PicRec)localObject3).size.set(j);
                ((RichMsg.PicRec)localObject3).type.set(1);
                localObject4 = ((RichMsg.PicRec)localObject3).uuid;
                if (localObject1 == null) {
                  break label773;
                }
                localObject2 = localObject1;
                ((PBStringField)localObject4).set((String)localObject2);
                localObject2 = TransfileUtile.a((String)localObject1, j, 1, false, (String)localObject1);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared: content:" + (String)localObject2);
                }
              }
            }
            for (localObject1 = localObject3;; localObject1 = localObject3)
            {
              localObject3 = localObject1;
              for (;;)
              {
                break label301;
                if ((((AppShareID)localObject1).uiNewVer != ((AppShareID)localObject2).uiNewVer) || (Math.abs(((AppShareID)localObject2).updateTime - ((AppShareID)localObject1).updateTime) > 86400000L))
                {
                  paramMessageHandler.a().b((Entity)localObject2);
                  paramMessageHandler.a().a((Entity)localObject1);
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared Update DB appid = " + ((AppShareID)localObject1).strPkgName);
                  break;
                }
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared Not need update DB appid = " + ((AppShareID)localObject1).strPkgName);
                break;
                localObject2 = "";
                break label526;
                localObject2 = "";
                break label569;
                if (bool2)
                {
                  localObject1 = (im_msg_body.Text)((im_msg_body.Elem)localObject1).text.get();
                  paramMsg = ((im_msg_body.Text)localObject1).str.get().toStringUtf8();
                  if (QLog.isColorLevel())
                  {
                    QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared actionUrl:" + paramMsg + ",hasLink:" + ((im_msg_body.Text)localObject1).link.has() + ",str:" + ((im_msg_body.Text)localObject1).str.has() + ",strC:" + ((im_msg_body.Text)localObject1).str.get().toStringUtf8());
                    QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared : bytes:" + ((im_msg_body.Text)localObject1).str.get().size() + ",cont:" + ((im_msg_body.Text)localObject1).str.get() + ",content:" + Arrays.toString(((im_msg_body.Text)localObject1).str.get().toByteArray()));
                  }
                }
                else if (((im_msg_body.Elem)localObject1).custom_face.has())
                {
                  Object localObject6 = (im_msg_body.CustomFace)((im_msg_body.Elem)localObject1).custom_face.get();
                  localObject1 = ((im_msg_body.CustomFace)localObject6).str_file_path.get();
                  localObject2 = ((im_msg_body.CustomFace)localObject6).str_shortcut.get();
                  localObject3 = ((im_msg_body.CustomFace)localObject6).str_big_url.get();
                  localObject4 = ((im_msg_body.CustomFace)localObject6).str_orig_url.get();
                  String str = ((im_msg_body.CustomFace)localObject6).str_thumb_url.get();
                  ((im_msg_body.CustomFace)localObject6).str_400_url.get();
                  long l2 = ((im_msg_body.CustomFace)localObject6).uint32_file_id.get();
                  long l3 = ((im_msg_body.CustomFace)localObject6).uint32_file_type.get();
                  long l4 = ((im_msg_body.CustomFace)localObject6).uint32_server_ip.get();
                  long l5 = ((im_msg_body.CustomFace)localObject6).uint32_server_port.get();
                  long l6 = ((im_msg_body.CustomFace)localObject6).uint32_useful.get();
                  Object localObject7 = ((im_msg_body.CustomFace)localObject6).bytes_md5.get().toByteArray();
                  Object localObject5 = ((im_msg_body.CustomFace)localObject6).bytes_signature.get().toByteArray();
                  ((im_msg_body.CustomFace)localObject6).bytes_buffer.get().toByteArray();
                  localObject6 = ((im_msg_body.CustomFace)localObject6).bytes_flag.get().toByteArray();
                  localObject7 = HexUtil.a((byte[])localObject7);
                  localObject5 = HexUtil.a((byte[])localObject5);
                  localObject6 = HexUtil.a((byte[])localObject6);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgElems: decode CustomFace, dump customFace info: filePath:" + (String)localObject1 + ", shortCut:" + (String)localObject2 + ", fileID:" + (l2 & 0xFFFFFFFF) + ", fileType:" + (l3 & 0xFFFFFFFF) + ", serverIP:" + (l4 & 0xFFFFFFFF) + ", serverPort" + (l5 & 0xFFFFFFFF) + ", useful" + (l6 & 0xFFFFFFFF) + ",md5:" + (String)localObject7 + ",signature:" + (String)localObject5 + ",flag:" + (String)localObject6 + ",downURLBig:" + (String)localObject3 + ",downURLOri:" + (String)localObject4 + ",downURLThum:" + str);
                  }
                  localObject1 = "http://quntu.3g.qq.com/cgi/svr/chatimg/get?pic=" + (String)localObject1 + "&gid=" + paramLong1 + "&time=" + paramLong2 + "&msfid=" + paramMessageHandler.b.getCurrentAccountUin();
                  localObject3 = new RichMsg.PicRec();
                  localObject4 = ((RichMsg.PicRec)localObject3).localPath;
                  if (localObject1 != null)
                  {
                    localObject2 = localObject1;
                    ((PBStringField)localObject4).set((String)localObject2);
                    ((RichMsg.PicRec)localObject3).size.set(0L);
                    ((RichMsg.PicRec)localObject3).type.set(1);
                    localObject4 = ((RichMsg.PicRec)localObject3).uuid;
                    if (localObject1 == null) {
                      break label1528;
                    }
                  }
                  label1528:
                  for (localObject2 = localObject1;; localObject2 = "")
                  {
                    ((PBStringField)localObject4).set((String)localObject2);
                    localObject2 = TransfileUtile.a((String)localObject1, 0L, 1, false, (String)localObject1);
                    paramBoolean = true;
                    break;
                    localObject2 = "";
                    break label1455;
                  }
                  if ((paramBoolean) && (!bool1))
                  {
                    paramMsg = (MessageForPic)MessageRecordFactory.a(-2000);
                    paramMsg.msgtype = -2000;
                    paramMsg.msgData = ((RichMsg.PicRec)localObject3).toByteArray();
                    paramMsg.msg = ((String)localObject2);
                    paramMsg.parse();
                    paramList.add(paramMsg);
                  }
                  for (;;)
                  {
                    if (i == 0) {
                      paramMessageHandler.a(Long.valueOf(l1));
                    }
                    do
                    {
                      return;
                      if ((!paramBoolean) && (bool1))
                      {
                        paramMessageHandler = (MessageForText)MessageRecordFactory.a(-1000);
                        paramMessageHandler.msgtype = -1000;
                        paramMessageHandler.msg = paramMsg;
                        paramList.add(paramMessageHandler);
                        return;
                      }
                    } while (paramMsg == null);
                    localObject1 = paramMsg.trim();
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared: hasPicCnt:" + paramBoolean + ",hasTextCnt:" + bool1);
                    }
                    paramMessageHandler.d(String.valueOf(AppShareIDUtil.b(l1)));
                    paramMsg = ActionMsgUtil.a(localAppShareInfo.appshare_cookie.get().toByteArray());
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared: content:" + (String)localObject2 + ",opType:" + paramMsg.jdField_b_of_type_Int);
                    }
                    localObject1 = ActionMsgUtil.a((String)localObject2, (String)localObject1, l1, paramMsg.jdField_a_of_type_JavaLangString);
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.MessageHandler", 2, "<--decodeC2CMsgPkg_AppShared : content:" + (String)localObject2 + ",encodeMsg:" + (String)localObject1);
                    }
                    localObject2 = MessageRecordFactory.a(paramMsg.jdField_b_of_type_Int);
                    ((MessageRecord)localObject2).msgtype = paramMsg.jdField_b_of_type_Int;
                    ((MessageRecord)localObject2).msg = ((String)localObject1);
                    paramList.add(localObject2);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    label48:
    Object localObject;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()) || (!((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.has()))
    {
      return;
    }
    else
    {
      while (!paramMsg.content_head.has()) {
        if (QLog.isColorLevel())
        {
          QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMessagePackage: msg doesn't has the contentHead.");
          return;
        }
      }
      localObject = (msg_comm.ContentHead)paramMsg.content_head.get();
      if ((!((msg_comm.ContentHead)localObject).auto_reply.has()) || (((msg_comm.ContentHead)localObject).auto_reply.get() != 1)) {
        break label347;
      }
    }
    label347:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      localObject = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(128);
        localStringBuilder.append("<---decodeC2CMsgPkg_Buddy:elems size:").append(((List)localObject).size()).append(" isAutoReply:").append(paramBoolean2);
        QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
      }
      if (!paramBoolean2) {
        break label353;
      }
      if ((localObject == null) || (((List)localObject).size() <= 0)) {
        break label48;
      }
      paramMessageHandler = BaseApplication.getContext().getString(2131435135);
      paramMsg = ((List)localObject).iterator();
      if (!paramMsg.hasNext()) {
        break label48;
      }
      localObject = (im_msg_body.Elem)paramMsg.next();
      if (!((im_msg_body.Elem)localObject).text.has()) {
        break;
      }
      paramMsg = (im_msg_body.Text)((im_msg_body.Elem)localObject).text.get();
      if (paramBoolean1) {
        break label48;
      }
      paramMessageHandler = paramMessageHandler + " " + paramMsg.str.get().toStringUtf8();
      paramMsg = MessageRecordFactory.a(-10000);
      paramMsg.msgtype = -10000;
      paramMsg.msg = paramMessageHandler;
      paramList.add(paramMsg);
      return;
    }
    label353:
    a(paramMessageHandler, paramList, paramMsg, true, paramBoolean1, null);
  }
  
  public static void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong2, boolean paramBoolean4, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211");
    }
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())) {}
    int i;
    label461:
    label477:
    label634:
    long l1;
    label527:
    label572:
    label751:
    do
    {
      Object localObject2;
      do
      {
        do
        {
          for (;;)
          {
            return;
            try
            {
              localObject2 = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
              i = ((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.get();
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[" + i + "]");
              }
              switch (i)
              {
              case 5: 
              case 6: 
              case 10: 
              case 11: 
              case 12: 
              case 14: 
              case 15: 
              case 16: 
              default: 
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[" + i + "] is not implemented");
                return;
              }
            }
            catch (Exception paramMessageHandler) {}
            if (QLog.isColorLevel())
            {
              QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : failed.", paramMessageHandler);
              return;
              paramList = new SubMsgType0x3.MsgBody();
              int j;
              for (;;)
              {
                try
                {
                  paramList.mergeFrom((byte[])localObject2);
                  if (!paramList.msg_fail_notify.has()) {
                    break label572;
                  }
                  i = 0;
                  paramList = (SubMsgType0x3.FailNotify)paramList.msg_fail_notify.get();
                  if (!paramList.uint32_sessionid.has()) {
                    break label461;
                  }
                  j = paramList.uint32_sessionid.get();
                  if (!paramList.uint32_retCode.has()) {
                    break label477;
                  }
                  paramInt = paramList.uint32_retCode.get();
                  if (!paramList.bytes_reason.has()) {
                    break label527;
                  }
                  paramList = new String(paramList.bytes_reason.get().toStringUtf8());
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : FailNotify sessionId[" + j + "], retCode[" + paramInt + "], reason[" + paramList + "]");
                  }
                  paramMessageHandler.b.a().a(String.valueOf(paramLong1), j, paramInt, paramList);
                  return;
                }
                catch (InvalidProtocolBufferMicroException paramMessageHandler) {}
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x3] failed", paramMessageHandler);
                return;
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : failNotify has not sessionId");
                return;
                paramInt = i;
                if (QLog.isColorLevel())
                {
                  QLog.w("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + j + "], failNotify has not RetCode");
                  paramInt = i;
                  continue;
                  if (QLog.isColorLevel()) {
                    QLog.w("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + j + "], failNotify has not reason");
                  }
                  paramList = "";
                }
              }
              if (paramList.msg_progress_notify.has())
              {
                i = 0;
                paramList = (SubMsgType0x3.ProgressNotify)paramList.msg_progress_notify.get();
                if (paramList.uint32_sessionid.has())
                {
                  j = paramList.uint32_sessionid.get();
                  if (!paramList.uint32_progress.has()) {
                    break label751;
                  }
                  paramInt = paramList.uint32_progress.get();
                  if (!paramList.uint32_average_speed.has()) {
                    break label801;
                  }
                }
                for (i = paramList.uint32_average_speed.get();; i = 0)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : progressNotify sessionId[" + j + "], progress[" + paramInt + "], speed[" + i + "]");
                  }
                  paramMessageHandler.b.a().a(String.valueOf(paramLong1), j, paramInt, i);
                  return;
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : progressNotify has not sessionId");
                  return;
                  paramInt = i;
                  if (!QLog.isColorLevel()) {
                    break label634;
                  }
                  QLog.w("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + j + "], progressNotify has not Progress");
                  paramInt = i;
                  break label634;
                  if (QLog.isColorLevel()) {
                    QLog.w("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + j + "], progressNotify has not AverageSpeed");
                  }
                }
              }
              if (QLog.isColorLevel())
              {
                QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : progressNotify has neither failNotify not progressNotify");
                return;
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.MessageHandler", 2, "<FileAssistant>offlineFile come: cmd[0x211, 0x4]");
                }
                localObject1 = new SubMsgType0x4.MsgBody();
                SubMsgType0x4.MsgBody localMsgBody;
                try
                {
                  localMsgBody = (SubMsgType0x4.MsgBody)((SubMsgType0x4.MsgBody)localObject1).mergeFrom((byte[])localObject2);
                  if (localMsgBody.msg_not_online_file.has()) {
                    break label943;
                  }
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : MsgBody has not NotOnlineFile");
                  return;
                }
                catch (InvalidProtocolBufferMicroException paramMessageHandler) {}
                if (QLog.isColorLevel())
                {
                  QLog.e("Q.msg.MessageHandler", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x4] failed", paramMessageHandler);
                  return;
                  localObject2 = (im_msg_body.NotOnlineFile)localMsgBody.msg_not_online_file.get();
                  localObject1 = null;
                  if (localMsgBody.file_image_info.has()) {
                    localObject1 = (hummer_resv_21.FileImgInfo)localMsgBody.file_image_info.get();
                  }
                  if (paramBoolean4)
                  {
                    paramMessageHandler = new MessageRecord();
                    paramLong2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
                    l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
                    paramMessageHandler.msg = ((im_msg_body.NotOnlineFile)localObject2).bytes_file_name.get().toStringUtf8();
                    paramMessageHandler.senderuin = Long.toString(l1);
                    paramMessageHandler.msgtype = -2005;
                    paramMessageHandler.frienduin = Long.toString(paramLong1);
                    paramMessageHandler.time = paramLong2;
                    if (localObject1 != null)
                    {
                      paramMessageHandler.saveExtInfoToExtStr("file_pic_width", String.valueOf(((hummer_resv_21.FileImgInfo)localObject1).uint32_file_width.get()));
                      paramMessageHandler.saveExtInfoToExtStr("file_pic_heigth", String.valueOf(((hummer_resv_21.FileImgInfo)localObject1).uint32_file_height.get()));
                      QLog.i("Q.msg.MessageHandler", 1, "Insert ThumbSize toMsg height[" + ((hummer_resv_21.FileImgInfo)localObject1).uint32_file_width.get() + "], width[" + ((hummer_resv_21.FileImgInfo)localObject1).uint32_file_height.get() + "]");
                    }
                    paramList.add(paramMessageHandler);
                    return;
                  }
                  paramMessageHandler.b.a().a(paramMessageHandler, paramList, paramMsg, (im_msg_body.NotOnlineFile)localObject2, String.valueOf(paramLong1), paramBoolean1, paramBoolean2, paramLong2, paramInt, (hummer_resv_21.FileImgInfo)localObject1);
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MessageHandler", 2, "<dataline> message come: cmd[0x211, 0x7]");
                  }
                  paramList = new SubMsgType0x7.MsgBody();
                  try
                  {
                    paramList = (SubMsgType0x7.MsgBody)paramList.mergeFrom((byte[])localObject2);
                    if (!paramBoolean4)
                    {
                      ((DataLineHandler)paramMessageHandler.b.a(8)).a(paramMsg, paramList);
                      return;
                    }
                  }
                  catch (InvalidProtocolBufferMicroException paramMessageHandler) {}
                }
              }
            }
          }
        } while (!QLog.isColorLevel());
        QLog.e("Q.msg.MessageHandler", 2, "<dataline><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x7] failed", paramMessageHandler);
        return;
        paramLong1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
        paramInt = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
        paramLong2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
        l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
        paramList = null;
        if (((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.has()) {
          localObject1 = ((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get()).toByteArray();
        }
        try
        {
          paramMsg = ((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get()).sig.get().toByteArray();
          paramList = (List)localObject1;
          if (paramMsg != null)
          {
            FMDataCache.a(String.valueOf(paramLong1), paramMsg);
            paramList = (List)localObject1;
          }
        }
        catch (Exception paramList)
        {
          for (;;)
          {
            long l2;
            paramList = (List)localObject1;
          }
        }
        paramMessageHandler.b.a().a(paramLong1, paramInt, paramLong2, l1, paramList, (byte[])localObject2);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "<dataline printer> message come: cmd[0x211, 0x9]");
        }
        paramList = new C2CType0x211_SubC2CType0x9.MsgBody();
        try
        {
          paramList = (C2CType0x211_SubC2CType0x9.MsgBody)paramList.mergeFrom((byte[])localObject2);
          ((DataLineHandler)paramMessageHandler.b.a(8)).a(paramMsg, paramList);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramMessageHandler) {}
      } while (!QLog.isColorLevel());
      QLog.e("Q.msg.MessageHandler", 2, "<dataline><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x9] failed", paramMessageHandler);
      return;
      paramLong1 = paramMsg.msg_head.from_uin.get();
      paramLong2 = paramMsg.msg_head.to_uin.get();
      paramInt = paramMsg.msg_head.msg_seq.get();
      l1 = paramMsg.msg_head.msg_uid.get();
      i = paramMsg.msg_head.msg_type.get();
      l2 = paramMsg.msg_head.msg_time.get();
      ((SmartDeviceProxyMgr)paramMessageHandler.b.a(51)).a(paramLong1, paramLong2, paramInt, l1, i, "im_push.msg_push", (byte[])localObject2);
    } while (!QLog.isColorLevel());
    label801:
    label943:
    QLog.d("Q.msg.MessageHandler", 2, "device msg push, receive 0x11,0xd msg, fromuin2:" + paramLong1 + ",touin:" + paramLong2 + ", msg seq:" + paramInt + ",msg_uid:" + l1 + ",msg_time:" + l2 + ",msgtype:" + i);
  }
  
  /* Error */
  public static void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 355	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   4: invokevirtual 358	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7: checkcast 357	msf/msgcomm/msg_comm$MsgHead
    //   10: astore 12
    //   12: aload 12
    //   14: getfield 369	msf/msgcomm/msg_comm$MsgHead:msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   17: invokevirtual 87	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   20: sipush 529
    //   23: if_icmpne +65 -> 88
    //   26: aload 12
    //   28: getfield 721	msf/msgcomm/msg_comm$MsgHead:c2c_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   31: invokevirtual 87	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   34: bipush 6
    //   36: if_icmpne +52 -> 88
    //   39: iconst_1
    //   40: istore 6
    //   42: aload 12
    //   44: getfield 786	msf/msgcomm/msg_comm$MsgHead:c2c_tmp_msg_head	Lmsf/msgcomm/msg_comm$C2CTmpMsgHead;
    //   47: invokevirtual 3212	msf/msgcomm/msg_comm$C2CTmpMsgHead:has	()Z
    //   50: ifeq +37 -> 87
    //   53: aload_2
    //   54: getfield 25	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   57: invokevirtual 31	tencent/im/msg/im_msg_body$MsgBody:has	()Z
    //   60: ifeq +27 -> 87
    //   63: iload 6
    //   65: ifne +29 -> 94
    //   68: aload_2
    //   69: getfield 25	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   72: invokevirtual 35	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   75: checkcast 27	tencent/im/msg/im_msg_body$MsgBody
    //   78: getfield 39	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   81: invokevirtual 42	tencent/im/msg/im_msg_body$RichText:has	()Z
    //   84: ifne +10 -> 94
    //   87: return
    //   88: iconst_0
    //   89: istore 6
    //   91: goto -49 -> 42
    //   94: aload 12
    //   96: getfield 786	msf/msgcomm/msg_comm$MsgHead:c2c_tmp_msg_head	Lmsf/msgcomm/msg_comm$C2CTmpMsgHead;
    //   99: invokevirtual 789	msf/msgcomm/msg_comm$C2CTmpMsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   102: checkcast 788	msf/msgcomm/msg_comm$C2CTmpMsgHead
    //   105: astore 12
    //   107: aload 12
    //   109: getfield 792	msf/msgcomm/msg_comm$C2CTmpMsgHead:c2c_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   112: invokevirtual 87	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   115: istore 5
    //   117: aload 12
    //   119: getfield 802	msf/msgcomm/msg_comm$C2CTmpMsgHead:service_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   122: invokevirtual 87	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   125: istore 7
    //   127: aload 4
    //   129: getfield 3261	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:d	Z
    //   132: ifne +128 -> 260
    //   135: aload_3
    //   136: getfield 803	com/tencent/mobileqq/service/message/TempSessionInfo:jdField_a_of_type_Int	I
    //   139: sipush 1006
    //   142: if_icmpne +118 -> 260
    //   145: aload 12
    //   147: getfield 3264	msf/msgcomm/msg_comm$C2CTmpMsgHead:from_phone	Lcom/tencent/mobileqq/pb/PBStringField;
    //   150: invokevirtual 389	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   153: astore 13
    //   155: aload 12
    //   157: getfield 3264	msf/msgcomm/msg_comm$C2CTmpMsgHead:from_phone	Lcom/tencent/mobileqq/pb/PBStringField;
    //   160: invokevirtual 1794	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   163: ifeq +19 -> 182
    //   166: aload 13
    //   168: ifnull +14 -> 182
    //   171: aload 13
    //   173: ldc_w 3266
    //   176: invokevirtual 731	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   179: ifeq +43 -> 222
    //   182: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   185: ifeq -98 -> 87
    //   188: ldc 94
    //   190: iconst_2
    //   191: new 96	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   198: ldc_w 3268
    //   201: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload 12
    //   206: getfield 3264	msf/msgcomm/msg_comm$C2CTmpMsgHead:from_phone	Lcom/tencent/mobileqq/pb/PBStringField;
    //   209: invokevirtual 389	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   212: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: return
    //   222: aload_0
    //   223: getfield 336	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   226: aload 12
    //   228: getfield 3264	msf/msgcomm/msg_comm$C2CTmpMsgHead:from_phone	Lcom/tencent/mobileqq/pb/PBStringField;
    //   231: invokevirtual 389	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   234: new 96	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   241: aload 4
    //   243: getfield 3270	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   246: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   249: ldc 119
    //   251: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 3275	com/tencent/mobileqq/utils/ContactUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)V
    //   260: aload 4
    //   262: getfield 3261	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:d	Z
    //   265: ifne +1579 -> 1844
    //   268: aload 12
    //   270: getfield 3214	msf/msgcomm/msg_comm$C2CTmpMsgHead:sig	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   273: invokevirtual 316	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   276: ifeq +1568 -> 1844
    //   279: aload 12
    //   281: getfield 3214	msf/msgcomm/msg_comm$C2CTmpMsgHead:sig	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   284: invokevirtual 372	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   287: invokevirtual 376	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   290: astore 13
    //   292: aload 13
    //   294: astore 12
    //   296: invokestatic 2123	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   299: ifeq +49 -> 348
    //   302: ldc 94
    //   304: iconst_4
    //   305: new 96	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   312: ldc_w 3277
    //   315: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload 13
    //   320: invokestatic 689	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   323: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: ldc_w 3279
    //   329: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload 13
    //   334: arraylength
    //   335: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   338: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: aload 13
    //   346: astore 12
    //   348: aload 12
    //   350: ifnull +162 -> 512
    //   353: aload_3
    //   354: getfield 803	com/tencent/mobileqq/service/message/TempSessionInfo:jdField_a_of_type_Int	I
    //   357: lookupswitch	default:+155->512, 1001:+650->1007, 1005:+372->729, 1006:+511->868, 1008:+569->926, 1009:+627->984, 1010:+765->1122, 1021:+719->1076, 1022:+742->1099, 1023:+430->787, 1024:+488->845, 1025:+488->845, 1029:+811->1168, 1032:+834->1191, 1033:+834->1191, 1034:+834->1191, 7400:+788->1145, 10002:+673->1030, 10004:+696->1053
    //   513: istore 7
    //   515: iload 7
    //   517: istore 5
    //   519: aload_2
    //   520: getfield 3077	msf/msgcomm/msg_comm$Msg:content_head	Lmsf/msgcomm/msg_comm$ContentHead;
    //   523: invokevirtual 3078	msf/msgcomm/msg_comm$ContentHead:has	()Z
    //   526: ifeq +49 -> 575
    //   529: iload 7
    //   531: istore 5
    //   533: aload_2
    //   534: getfield 3077	msf/msgcomm/msg_comm$Msg:content_head	Lmsf/msgcomm/msg_comm$ContentHead;
    //   537: invokevirtual 3081	msf/msgcomm/msg_comm$ContentHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   540: checkcast 910	msf/msgcomm/msg_comm$ContentHead
    //   543: getfield 3084	msf/msgcomm/msg_comm$ContentHead:auto_reply	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   546: invokevirtual 84	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   549: ifeq +26 -> 575
    //   552: aload_2
    //   553: getfield 3077	msf/msgcomm/msg_comm$Msg:content_head	Lmsf/msgcomm/msg_comm$ContentHead;
    //   556: invokevirtual 3081	msf/msgcomm/msg_comm$ContentHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   559: checkcast 910	msf/msgcomm/msg_comm$ContentHead
    //   562: getfield 3084	msf/msgcomm/msg_comm$ContentHead:auto_reply	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   565: invokevirtual 87	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   568: iconst_1
    //   569: if_icmpne +653 -> 1222
    //   572: iconst_1
    //   573: istore 5
    //   575: aconst_null
    //   576: astore 12
    //   578: iload 6
    //   580: ifne +30 -> 610
    //   583: aload_2
    //   584: getfield 25	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   587: invokevirtual 35	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   590: checkcast 27	tencent/im/msg/im_msg_body$MsgBody
    //   593: getfield 39	tencent/im/msg/im_msg_body$MsgBody:rich_text	Ltencent/im/msg/im_msg_body$RichText;
    //   596: invokevirtual 43	tencent/im/msg/im_msg_body$RichText:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   599: checkcast 41	tencent/im/msg/im_msg_body$RichText
    //   602: getfield 47	tencent/im/msg/im_msg_body$RichText:elems	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   605: invokevirtual 52	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   608: astore 12
    //   610: iload 5
    //   612: ifeq +616 -> 1228
    //   615: aload 12
    //   617: ifnull -530 -> 87
    //   620: aload 12
    //   622: invokeinterface 1290 1 0
    //   627: ifle -540 -> 87
    //   630: aload 12
    //   632: iconst_0
    //   633: invokeinterface 1291 2 0
    //   638: checkcast 69	tencent/im/msg/im_msg_body$Elem
    //   641: getfield 294	tencent/im/msg/im_msg_body$Elem:text	Ltencent/im/msg/im_msg_body$Text;
    //   644: invokevirtual 2931	tencent/im/msg/im_msg_body$Text:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   647: checkcast 274	tencent/im/msg/im_msg_body$Text
    //   650: astore_0
    //   651: aload 4
    //   653: getfield 3280	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:jdField_b_of_type_Boolean	Z
    //   656: ifne -569 -> 87
    //   659: new 96	java/lang/StringBuilder
    //   662: dup
    //   663: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   666: invokestatic 2880	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   669: ldc_w 3090
    //   672: invokevirtual 2883	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   675: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: ldc_w 3092
    //   681: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: aload_0
    //   685: getfield 279	tencent/im/msg/im_msg_body$Text:str	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   688: invokevirtual 372	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   691: invokevirtual 492	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   694: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   700: astore_0
    //   701: sipush -10000
    //   704: invokestatic 477	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   707: astore_2
    //   708: aload_2
    //   709: sipush -10000
    //   712: putfield 613	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   715: aload_2
    //   716: aload_0
    //   717: putfield 614	com/tencent/mobileqq/data/MessageRecord:msg	Ljava/lang/String;
    //   720: aload_1
    //   721: aload_2
    //   722: invokeinterface 649 2 0
    //   727: pop
    //   728: return
    //   729: aload 12
    //   731: arraylength
    //   732: iconst_2
    //   733: iadd
    //   734: newarray byte
    //   736: astore 13
    //   738: aload 13
    //   740: iconst_0
    //   741: iload 5
    //   743: i2b
    //   744: bastore
    //   745: aload 13
    //   747: iconst_1
    //   748: iload 7
    //   750: i2b
    //   751: bastore
    //   752: aload 13
    //   754: iconst_2
    //   755: aload 12
    //   757: iconst_0
    //   758: aload 12
    //   760: arraylength
    //   761: invokestatic 2741	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   764: aload_0
    //   765: getfield 336	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   768: invokevirtual 866	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   771: aload 4
    //   773: getfield 3270	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   776: invokestatic 555	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   779: aload 13
    //   781: invokevirtual 3281	com/tencent/mobileqq/service/message/MessageCache:a	(Ljava/lang/String;[B)V
    //   784: goto -272 -> 512
    //   787: aload 12
    //   789: arraylength
    //   790: iconst_2
    //   791: iadd
    //   792: newarray byte
    //   794: astore 13
    //   796: aload 13
    //   798: iconst_0
    //   799: iload 5
    //   801: i2b
    //   802: bastore
    //   803: aload 13
    //   805: iconst_1
    //   806: iload 7
    //   808: i2b
    //   809: bastore
    //   810: aload 13
    //   812: iconst_2
    //   813: aload 12
    //   815: iconst_0
    //   816: aload 12
    //   818: arraylength
    //   819: invokestatic 2741	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   822: aload_0
    //   823: getfield 336	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   826: invokevirtual 866	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   829: aload 4
    //   831: getfield 3270	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   834: invokestatic 555	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   837: aload 13
    //   839: invokevirtual 3283	com/tencent/mobileqq/service/message/MessageCache:b	(Ljava/lang/String;[B)V
    //   842: goto -330 -> 512
    //   845: aload_0
    //   846: getfield 336	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   849: invokevirtual 866	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   852: aload 4
    //   854: getfield 3270	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   857: invokestatic 555	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   860: aload 12
    //   862: invokevirtual 3285	com/tencent/mobileqq/service/message/MessageCache:c	(Ljava/lang/String;[B)V
    //   865: goto -353 -> 512
    //   868: aload 12
    //   870: arraylength
    //   871: iconst_2
    //   872: iadd
    //   873: newarray byte
    //   875: astore 13
    //   877: aload 13
    //   879: iconst_0
    //   880: iload 5
    //   882: i2b
    //   883: bastore
    //   884: aload 13
    //   886: iconst_1
    //   887: iload 7
    //   889: i2b
    //   890: bastore
    //   891: aload 13
    //   893: iconst_2
    //   894: aload 12
    //   896: iconst_0
    //   897: aload 12
    //   899: arraylength
    //   900: invokestatic 2741	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   903: aload_0
    //   904: getfield 336	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   907: invokevirtual 866	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   910: aload 4
    //   912: getfield 3270	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   915: invokestatic 555	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   918: aload 13
    //   920: invokevirtual 3287	com/tencent/mobileqq/service/message/MessageCache:e	(Ljava/lang/String;[B)V
    //   923: goto -411 -> 512
    //   926: aload 12
    //   928: arraylength
    //   929: iconst_2
    //   930: iadd
    //   931: newarray byte
    //   933: astore 13
    //   935: aload 13
    //   937: iconst_0
    //   938: iload 5
    //   940: i2b
    //   941: bastore
    //   942: aload 13
    //   944: iconst_1
    //   945: iload 7
    //   947: i2b
    //   948: bastore
    //   949: aload 13
    //   951: iconst_2
    //   952: aload 12
    //   954: iconst_0
    //   955: aload 12
    //   957: arraylength
    //   958: invokestatic 2741	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   961: aload_0
    //   962: getfield 336	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   965: invokevirtual 866	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   968: aload 4
    //   970: getfield 3270	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   973: invokestatic 555	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   976: aload 13
    //   978: invokevirtual 3290	com/tencent/mobileqq/service/message/MessageCache:f	(Ljava/lang/String;[B)V
    //   981: goto -469 -> 512
    //   984: aload_0
    //   985: getfield 336	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   988: invokevirtual 866	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   991: aload 4
    //   993: getfield 3270	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   996: invokestatic 555	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   999: aload 12
    //   1001: invokevirtual 3293	com/tencent/mobileqq/service/message/MessageCache:g	(Ljava/lang/String;[B)V
    //   1004: goto -492 -> 512
    //   1007: aload_0
    //   1008: getfield 336	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1011: invokevirtual 866	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1014: aload 4
    //   1016: getfield 3270	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   1019: invokestatic 555	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1022: aload 12
    //   1024: invokevirtual 3296	com/tencent/mobileqq/service/message/MessageCache:h	(Ljava/lang/String;[B)V
    //   1027: goto -515 -> 512
    //   1030: aload_0
    //   1031: getfield 336	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1034: invokevirtual 866	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1037: aload 4
    //   1039: getfield 3270	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   1042: invokestatic 555	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1045: aload 12
    //   1047: invokevirtual 3298	com/tencent/mobileqq/service/message/MessageCache:i	(Ljava/lang/String;[B)V
    //   1050: goto -538 -> 512
    //   1053: aload_0
    //   1054: getfield 336	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1057: invokevirtual 866	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1060: aload 4
    //   1062: getfield 3270	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   1065: invokestatic 555	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1068: aload 12
    //   1070: invokevirtual 3301	com/tencent/mobileqq/service/message/MessageCache:j	(Ljava/lang/String;[B)V
    //   1073: goto -561 -> 512
    //   1076: aload_0
    //   1077: getfield 336	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1080: invokevirtual 866	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1083: aload 4
    //   1085: getfield 3270	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   1088: invokestatic 555	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1091: aload 12
    //   1093: invokevirtual 3304	com/tencent/mobileqq/service/message/MessageCache:n	(Ljava/lang/String;[B)V
    //   1096: goto -584 -> 512
    //   1099: aload_0
    //   1100: getfield 336	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1103: invokevirtual 866	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1106: aload 4
    //   1108: getfield 3270	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   1111: invokestatic 555	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1114: aload 12
    //   1116: invokevirtual 3307	com/tencent/mobileqq/service/message/MessageCache:p	(Ljava/lang/String;[B)V
    //   1119: goto -607 -> 512
    //   1122: aload_0
    //   1123: getfield 336	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1126: invokevirtual 866	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1129: aload 4
    //   1131: getfield 3270	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   1134: invokestatic 555	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1137: aload 12
    //   1139: invokevirtual 3310	com/tencent/mobileqq/service/message/MessageCache:m	(Ljava/lang/String;[B)V
    //   1142: goto -630 -> 512
    //   1145: aload_0
    //   1146: getfield 336	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1149: invokevirtual 866	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1152: aload 4
    //   1154: getfield 3270	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   1157: invokestatic 555	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1160: aload 12
    //   1162: invokevirtual 3313	com/tencent/mobileqq/service/message/MessageCache:k	(Ljava/lang/String;[B)V
    //   1165: goto -653 -> 512
    //   1168: aload_0
    //   1169: getfield 336	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1172: invokevirtual 866	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1175: aload 4
    //   1177: getfield 3270	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   1180: invokestatic 555	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1183: aload 12
    //   1185: invokevirtual 3315	com/tencent/mobileqq/service/message/MessageCache:l	(Ljava/lang/String;[B)V
    //   1188: goto -676 -> 512
    //   1191: aload_0
    //   1192: getfield 336	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1195: invokevirtual 866	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/service/message/MessageCache;
    //   1198: aload 4
    //   1200: getfield 3270	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   1203: invokestatic 555	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1206: aload 4
    //   1208: getfield 3316	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:jdField_a_of_type_Long	J
    //   1211: invokestatic 555	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1214: aload 12
    //   1216: invokevirtual 3319	com/tencent/mobileqq/service/message/MessageCache:a	(Ljava/lang/String;Ljava/lang/String;[B)V
    //   1219: goto -707 -> 512
    //   1222: iconst_0
    //   1223: istore 5
    //   1225: goto -650 -> 575
    //   1228: aload_3
    //   1229: ifnull -1142 -> 87
    //   1232: aload_2
    //   1233: getfield 355	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   1236: invokevirtual 358	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1239: checkcast 357	msf/msgcomm/msg_comm$MsgHead
    //   1242: getfield 369	msf/msgcomm/msg_comm$MsgHead:msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1245: invokevirtual 87	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1248: sipush 529
    //   1251: if_icmpne +546 -> 1797
    //   1254: aload_2
    //   1255: getfield 355	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   1258: invokevirtual 358	msf/msgcomm/msg_comm$MsgHead:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1261: checkcast 357	msf/msgcomm/msg_comm$MsgHead
    //   1264: getfield 721	msf/msgcomm/msg_comm$MsgHead:c2c_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1267: invokevirtual 87	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1270: bipush 6
    //   1272: if_icmpne +525 -> 1797
    //   1275: aload_2
    //   1276: getfield 25	msf/msgcomm/msg_comm$Msg:msg_body	Ltencent/im/msg/im_msg_body$MsgBody;
    //   1279: invokevirtual 35	tencent/im/msg/im_msg_body$MsgBody:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1282: checkcast 27	tencent/im/msg/im_msg_body$MsgBody
    //   1285: getfield 315	tencent/im/msg/im_msg_body$MsgBody:msg_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1288: invokevirtual 372	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1291: invokevirtual 376	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1294: astore_3
    //   1295: new 3321	tencent/im/msg/im_msg_body$TmpPtt
    //   1298: dup
    //   1299: invokespecial 3322	tencent/im/msg/im_msg_body$TmpPtt:<init>	()V
    //   1302: astore 4
    //   1304: aload 4
    //   1306: aload_3
    //   1307: invokevirtual 3323	tencent/im/msg/im_msg_body$TmpPtt:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1310: checkcast 3321	tencent/im/msg/im_msg_body$TmpPtt
    //   1313: astore_3
    //   1314: aload_3
    //   1315: ifnull -1228 -> 87
    //   1318: aload_3
    //   1319: getfield 3324	tencent/im/msg/im_msg_body$TmpPtt:uint32_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1322: invokevirtual 84	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1325: ifeq -1238 -> 87
    //   1328: aload_3
    //   1329: getfield 3324	tencent/im/msg/im_msg_body$TmpPtt:uint32_file_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1332: invokevirtual 87	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1335: iconst_4
    //   1336: if_icmpne -1249 -> 87
    //   1339: aload_3
    //   1340: getfield 3325	tencent/im/msg/im_msg_body$TmpPtt:bytes_file_uuid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1343: invokevirtual 316	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1346: ifeq -1259 -> 87
    //   1349: aload_3
    //   1350: getfield 3325	tencent/im/msg/im_msg_body$TmpPtt:bytes_file_uuid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1353: invokevirtual 372	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1356: invokevirtual 492	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1359: astore 12
    //   1361: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1364: ifeq +30 -> 1394
    //   1367: ldc 94
    //   1369: iconst_2
    //   1370: new 96	java/lang/StringBuilder
    //   1373: dup
    //   1374: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   1377: ldc_w 3327
    //   1380: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1383: aload 12
    //   1385: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1388: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1391: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1394: new 2669	localpb/richMsg/RichMsg$PttRec
    //   1397: dup
    //   1398: invokespecial 2670	localpb/richMsg/RichMsg$PttRec:<init>	()V
    //   1401: astore 4
    //   1403: aload 4
    //   1405: getfield 2671	localpb/richMsg/RichMsg$PttRec:localPath	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1408: aload_3
    //   1409: getfield 3325	tencent/im/msg/im_msg_body$TmpPtt:bytes_file_uuid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1412: invokevirtual 372	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1415: invokevirtual 492	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1418: invokevirtual 626	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   1421: aload 4
    //   1423: getfield 2672	localpb/richMsg/RichMsg$PttRec:size	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1426: aload_3
    //   1427: getfield 3328	tencent/im/msg/im_msg_body$TmpPtt:uint32_file_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1430: invokevirtual 87	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1433: i2l
    //   1434: invokevirtual 880	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   1437: aload 4
    //   1439: getfield 2673	localpb/richMsg/RichMsg$PttRec:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1442: iconst_2
    //   1443: invokevirtual 184	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1446: aload 4
    //   1448: getfield 2674	localpb/richMsg/RichMsg$PttRec:uuid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1451: aload 12
    //   1453: invokevirtual 626	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   1456: aload 4
    //   1458: getfield 2675	localpb/richMsg/RichMsg$PttRec:isRead	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   1461: iconst_0
    //   1462: invokevirtual 1051	com/tencent/mobileqq/pb/PBBoolField:set	(Z)V
    //   1465: aload 4
    //   1467: getfield 2676	localpb/richMsg/RichMsg$PttRec:serverStorageSource	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1470: ldc_w 2781
    //   1473: invokevirtual 626	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   1476: aload 4
    //   1478: getfield 2677	localpb/richMsg/RichMsg$PttRec:isReport	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1481: iconst_0
    //   1482: invokevirtual 2630	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   1485: aload 4
    //   1487: getfield 2678	localpb/richMsg/RichMsg$PttRec:version	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1490: iconst_5
    //   1491: invokevirtual 2630	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   1494: aload 4
    //   1496: getfield 2784	localpb/richMsg/RichMsg$PttRec:pttFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1499: iconst_0
    //   1500: invokevirtual 2630	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   1503: iconst_0
    //   1504: istore 6
    //   1506: iload 6
    //   1508: istore 5
    //   1510: aload_3
    //   1511: getfield 3331	tencent/im/msg/im_msg_body$TmpPtt:uint32_user_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1514: invokevirtual 84	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1517: ifeq +32 -> 1549
    //   1520: aload_3
    //   1521: getfield 3331	tencent/im/msg/im_msg_body$TmpPtt:uint32_user_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1524: invokevirtual 87	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1527: istore 7
    //   1529: iload 7
    //   1531: iconst_1
    //   1532: if_icmpeq +13 -> 1545
    //   1535: iload 6
    //   1537: istore 5
    //   1539: iload 7
    //   1541: iconst_2
    //   1542: if_icmpne +7 -> 1549
    //   1545: iload 7
    //   1547: istore 5
    //   1549: iconst_0
    //   1550: istore 7
    //   1552: iload 7
    //   1554: istore 6
    //   1556: aload_3
    //   1557: getfield 3332	tencent/im/msg/im_msg_body$TmpPtt:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1560: invokevirtual 316	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   1563: ifeq +38 -> 1601
    //   1566: new 2751	tencent/im/cs/ptt_reserve/ptt_reserve$ReserveStruct
    //   1569: dup
    //   1570: invokespecial 2752	tencent/im/cs/ptt_reserve/ptt_reserve$ReserveStruct:<init>	()V
    //   1573: astore 12
    //   1575: aload 12
    //   1577: aload_3
    //   1578: getfield 3332	tencent/im/msg/im_msg_body$TmpPtt:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1581: invokevirtual 372	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1584: invokevirtual 376	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1587: invokevirtual 2753	tencent/im/cs/ptt_reserve/ptt_reserve$ReserveStruct:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1590: pop
    //   1591: aload 12
    //   1593: getfield 2756	tencent/im/cs/ptt_reserve/ptt_reserve$ReserveStruct:uint32_change_voice	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1596: invokevirtual 87	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1599: istore 6
    //   1601: aload 4
    //   1603: getfield 2808	localpb/richMsg/RichMsg$PttRec:longPttVipFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1606: iload 5
    //   1608: invokevirtual 2630	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   1611: invokestatic 2683	java/lang/System:currentTimeMillis	()J
    //   1614: ldc2_w 1207
    //   1617: ldiv
    //   1618: lstore 8
    //   1620: aload_2
    //   1621: getfield 355	msf/msgcomm/msg_comm$Msg:msg_head	Lmsf/msgcomm/msg_comm$MsgHead;
    //   1624: getfield 408	msf/msgcomm/msg_comm$MsgHead:msg_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1627: invokevirtual 87	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1630: i2l
    //   1631: lstore 10
    //   1633: aload 4
    //   1635: getfield 2686	localpb/richMsg/RichMsg$PttRec:msgRecTime	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1638: lload 8
    //   1640: invokevirtual 880	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   1643: aload 4
    //   1645: getfield 2689	localpb/richMsg/RichMsg$PttRec:msgTime	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1648: lload 10
    //   1650: invokevirtual 880	com/tencent/mobileqq/pb/PBUInt64Field:set	(J)V
    //   1653: aload 4
    //   1655: getfield 2793	localpb/richMsg/RichMsg$PttRec:voiceChangeFlag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1658: iload 6
    //   1660: invokevirtual 184	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1663: aload 4
    //   1665: getfield 3335	localpb/richMsg/RichMsg$PttRec:busiType	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1668: aload_3
    //   1669: getfield 3338	tencent/im/msg/im_msg_body$TmpPtt:uint32_busi_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1672: invokevirtual 87	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1675: invokevirtual 184	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   1678: sipush -2002
    //   1681: invokestatic 477	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1684: astore 12
    //   1686: aload 12
    //   1688: sipush -2002
    //   1691: putfield 613	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   1694: aload 12
    //   1696: aload 4
    //   1698: invokevirtual 2693	localpb/richMsg/RichMsg$PttRec:toByteArray	()[B
    //   1701: putfield 661	com/tencent/mobileqq/data/MessageRecord:msgData	[B
    //   1704: aload 12
    //   1706: checkcast 2691	com/tencent/mobileqq/data/MessageForPtt
    //   1709: invokevirtual 2695	com/tencent/mobileqq/data/MessageForPtt:parse	()V
    //   1712: aload_3
    //   1713: getfield 3341	tencent/im/msg/im_msg_body$TmpPtt:uint64_msg_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1716: invokevirtual 1801	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   1719: ifeq +48 -> 1767
    //   1722: aload_3
    //   1723: getfield 3341	tencent/im/msg/im_msg_body$TmpPtt:uint64_msg_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1726: invokevirtual 366	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1729: lconst_0
    //   1730: lcmp
    //   1731: ifeq +36 -> 1767
    //   1734: aload 12
    //   1736: ldc_w 3343
    //   1739: new 96	java/lang/StringBuilder
    //   1742: dup
    //   1743: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   1746: aload_3
    //   1747: getfield 3341	tencent/im/msg/im_msg_body$TmpPtt:uint64_msg_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1750: invokevirtual 366	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1753: invokevirtual 396	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1756: ldc 119
    //   1758: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1761: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1764: invokevirtual 3189	com/tencent/mobileqq/data/MessageRecord:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   1767: aload_2
    //   1768: aload 12
    //   1770: aload_0
    //   1771: getfield 336	com/tencent/mobileqq/app/MessageHandler:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1774: invokestatic 3346	com/tencent/mobileqq/confess/ConfessMsgUtil:a	(Lmsf/msgcomm/msg_comm$Msg;Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   1777: aload_1
    //   1778: aload 12
    //   1780: invokeinterface 649 2 0
    //   1785: pop
    //   1786: return
    //   1787: astore_3
    //   1788: aload_3
    //   1789: invokevirtual 670	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   1792: aconst_null
    //   1793: astore_3
    //   1794: goto -480 -> 1314
    //   1797: new 698	com/tencent/mobileqq/troop/data/MessageInfo
    //   1800: dup
    //   1801: invokespecial 3347	com/tencent/mobileqq/troop/data/MessageInfo:<init>	()V
    //   1804: astore 12
    //   1806: aload 12
    //   1808: aload 4
    //   1810: getfield 3270	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:e	J
    //   1813: invokestatic 555	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1816: putfield 702	com/tencent/mobileqq/troop/data/MessageInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1819: aload_0
    //   1820: aload_1
    //   1821: aload_2
    //   1822: iconst_1
    //   1823: aload 4
    //   1825: getfield 3280	com/tencent/mobileqq/service/message/DecodeProtoPkgContext:jdField_b_of_type_Boolean	Z
    //   1828: aload 12
    //   1830: aload_3
    //   1831: invokestatic 3350	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/MessageHandler;Ljava/util/List;Lmsf/msgcomm/msg_comm$Msg;ZZLcom/tencent/mobileqq/troop/data/MessageInfo;Lcom/tencent/mobileqq/service/message/TempSessionInfo;)V
    //   1834: return
    //   1835: astore 12
    //   1837: iload 7
    //   1839: istore 6
    //   1841: goto -240 -> 1601
    //   1844: aconst_null
    //   1845: astore 12
    //   1847: goto -1499 -> 348
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1850	0	paramMessageHandler	MessageHandler
    //   0	1850	1	paramList	List
    //   0	1850	2	paramMsg	msg_comm.Msg
    //   0	1850	3	paramTempSessionInfo	TempSessionInfo
    //   0	1850	4	paramDecodeProtoPkgContext	DecodeProtoPkgContext
    //   115	1492	5	i	int
    //   40	1800	6	j	int
    //   125	1713	7	k	int
    //   1618	21	8	l1	long
    //   1631	18	10	l2	long
    //   10	1819	12	localObject1	Object
    //   1835	1	12	localException	Exception
    //   1845	1	12	localObject2	Object
    //   153	824	13	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   1304	1314	1787	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1575	1601	1835	java/lang/Exception
  }
  
  public static void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, MessageInfo paramMessageInfo)
  {
    a(paramMessageHandler, paramList, paramMsg, paramBoolean1, paramBoolean2, paramMessageInfo, null);
  }
  
  public static void a(MessageHandler paramMessageHandler, List paramList, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, MessageInfo paramMessageInfo, TempSessionInfo paramTempSessionInfo)
  {
    List localList = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("<---decodePBMsgElems: elems: ");
      if (localList != null) {
        break label88;
      }
    }
    label88:
    for (Object localObject1 = null;; localObject1 = Integer.valueOf(localList.size()))
    {
      QLog.d("Q.msg.MessageHandler", 2, localObject1);
      if ((localList != null) && (localList.size() > 0)) {
        break;
      }
      return;
    }
    localObject1 = new StringBuilder("<---decodePBMsgElems:");
    Object localObject2 = MessagePBDecoderConfig.a(localList);
    int i = MessagePBDecoderConfig.a((ArrayList)localObject2);
    if (QLog.isColorLevel()) {
      ((StringBuilder)localObject1).append("decodeElemType:").append(i).append(" ElemStrs:").append(((ArrayList)localObject2).toString()).append("\n");
    }
    MessagePBElemDecoder localMessagePBElemDecoder = new MessagePBElemDecoder();
    if (QLog.isColorLevel()) {
      QLog.d("flash", 2, "decodePBMsgElems decodeElemType=" + i);
    }
    switch (i)
    {
    }
    for (;;)
    {
      if (paramList.isEmpty()) {
        localMessagePBElemDecoder.g(localList, paramList, (StringBuilder)localObject1, paramMsg, paramMessageInfo);
      }
      if (paramList.isEmpty()) {
        localMessagePBElemDecoder.j(localList, paramList, (StringBuilder)localObject1, paramMsg, paramMessageInfo);
      }
      localMessagePBElemDecoder.a(localList, paramList);
      if (MessagePBDecoderConfig.a((ArrayList)localObject2)) {
        localMessagePBElemDecoder.a((ArrayList)localObject2, localList, paramList, (StringBuilder)localObject1, paramMsg, paramMessageInfo, paramTempSessionInfo);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject1).toString());
      return;
      localMessagePBElemDecoder.a(localList, paramList, (StringBuilder)localObject1, paramBoolean2);
      continue;
      localMessagePBElemDecoder.a(localList, paramList, (StringBuilder)localObject1, paramMsg);
      continue;
      localMessagePBElemDecoder.b(localList, paramList, (StringBuilder)localObject1, paramBoolean1);
      continue;
      localMessagePBElemDecoder.a(localList, paramList, (StringBuilder)localObject1, paramMsg);
      continue;
      localMessagePBElemDecoder.d(localList, paramList, (StringBuilder)localObject1, paramMsg, paramMessageInfo);
      continue;
      localMessagePBElemDecoder.b(localList, paramList, (StringBuilder)localObject1, paramMsg, paramMessageInfo);
      continue;
      localMessagePBElemDecoder.c(localList, paramList, (StringBuilder)localObject1, paramMsg, paramMessageInfo);
      continue;
      localMessagePBElemDecoder.e(localList, paramList, (StringBuilder)localObject1, paramMsg, paramMessageInfo);
      continue;
      localMessagePBElemDecoder.b(localList, paramList, (StringBuilder)localObject1);
      continue;
      localMessagePBElemDecoder.a(localList, paramList, (StringBuilder)localObject1);
      continue;
      localMessagePBElemDecoder.c(localList, paramList, (StringBuilder)localObject1);
      continue;
      localMessagePBElemDecoder.b(localList, paramList, (StringBuilder)localObject1, paramMsg);
      continue;
      localMessagePBElemDecoder.h(localList, paramList, (StringBuilder)localObject1, paramMsg, paramMessageInfo);
      continue;
      localMessagePBElemDecoder.c(localList, paramList, (StringBuilder)localObject1, paramMsg);
      continue;
      localMessagePBElemDecoder.f(localList, paramList, (StringBuilder)localObject1, paramMsg, paramMessageInfo);
      continue;
      localMessagePBElemDecoder.g(localList, paramList, (StringBuilder)localObject1);
      continue;
      localMessagePBElemDecoder.h(localList, paramList, (StringBuilder)localObject1);
      continue;
      localMessagePBElemDecoder.g(localList, paramList, (StringBuilder)localObject1, paramMsg, paramMessageInfo);
      continue;
      localMessagePBElemDecoder.a(localList, paramList, (StringBuilder)localObject1, paramMsg, paramMessageInfo, paramBoolean1);
      continue;
      localMessagePBElemDecoder.b(localList, paramList, (StringBuilder)localObject1, paramMsg, paramMessageInfo, paramBoolean1);
      continue;
      localMessagePBElemDecoder.i(localList, paramList, (StringBuilder)localObject1, paramMsg, paramMessageInfo);
      continue;
      localMessagePBElemDecoder.j(localList, paramList, (StringBuilder)localObject1, paramMsg, paramMessageInfo);
      continue;
      localMessagePBElemDecoder.a(localList, paramList, (StringBuilder)localObject1, paramMsg, paramBoolean1);
      continue;
      localMessagePBElemDecoder.b(localList, paramList, (StringBuilder)localObject1, paramMsg, paramBoolean1);
      continue;
      localMessagePBElemDecoder.d(localList, paramList, (StringBuilder)localObject1);
      continue;
      localMessagePBElemDecoder.e(localList, paramList, (StringBuilder)localObject1);
      continue;
      if (paramBoolean1)
      {
        if (paramMessageHandler.b.getLongAccountUin() == paramMsg.msg_head.to_uin.get()) {}
        for (paramMessageHandler = paramMsg.msg_head.from_uin.get() + "";; paramMessageHandler = paramMsg.msg_head.to_uin.get() + "")
        {
          localMessagePBElemDecoder.a(localList, paramList, (StringBuilder)localObject1, paramMsg, paramMessageHandler);
          break;
        }
      }
      if (paramMessageInfo != null) {}
      for (paramMessageHandler = paramMessageInfo.jdField_a_of_type_JavaLangString;; paramMessageHandler = paramMsg.msg_head.to_uin.get() + "") {
        break;
      }
      localMessagePBElemDecoder.f(localList, paramList, (StringBuilder)localObject1);
      continue;
      localMessagePBElemDecoder.d(localList, paramList, (StringBuilder)localObject1, paramMsg);
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_SharpVideo return null:hasBody:" + paramMsg.msg_body.has() + ",hasMsgContent" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has());
      }
    }
    long l1;
    long l4;
    long l2;
    byte[] arrayOfByte2;
    int i;
    for (;;)
    {
      return;
      l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
      long l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
      l4 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
      l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
      ((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get();
      Object localObject = l4 + "-" + l3;
      if (QLog.isColorLevel()) {
        QLog.d("shanezhaiSHARP", 2, "<---decodeC2CMsgPkg_SharpVideo :  key:" + (String)localObject);
      }
      if (paramMessageHandler.b.a().a(l2, (String)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("shanezhaiSHARP", 2, "msg has been pulled");
        }
      }
      else
      {
        l3 = MessageCache.a();
        l4 = Long.valueOf(paramMessageHandler.b.getCurrentAccountUin()).longValue();
        byte[] arrayOfByte1 = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
        long l5 = l3 - l1;
        arrayOfByte2 = new byte[4];
        byte[] arrayOfByte3 = new byte[4];
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, 4);
        System.arraycopy(arrayOfByte1, 4, arrayOfByte3, 0, 4);
        i = VideoPackageUtils.a(arrayOfByte2, 4);
        int j = arrayOfByte1.length - 8 - i;
        if (j >= 0)
        {
          arrayOfByte2 = new byte[j];
          System.arraycopy(arrayOfByte1, i + 8, arrayOfByte2, 0, j);
          bool = AbstractNetChannel.a(arrayOfByte2);
          if (((!paramDecodeProtoPkgContext.jdField_a_of_type_Boolean) && (!paramDecodeProtoPkgContext.f)) || ((paramDecodeProtoPkgContext.jdField_a_of_type_Long != paramDecodeProtoPkgContext.jdField_b_of_type_Long) || ((paramDecodeProtoPkgContext.jdField_a_of_type_Long == paramDecodeProtoPkgContext.jdField_b_of_type_Long) && (!bool))))
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_SharpVideo return null:,isReaded:" + paramDecodeProtoPkgContext.jdField_a_of_type_Boolean + "syncOther:" + paramDecodeProtoPkgContext.f + ",isSharpRequest" + bool);
            }
          }
          else
          {
            if (bool)
            {
              paramMessageHandler.b.a().a(l2, (String)localObject, l3);
              a(l4, l2, 215);
            }
            if ((!VcSystemInfo.c()) || (!VcSystemInfo.d()))
            {
              if (QLog.isColorLevel()) {
                QLog.d("shanezhaiSHARP", 2, "Discard video message cause device not support");
              }
              if (bool) {
                a(l4, l2, 212);
              }
            }
            else
            {
              if (l5 < 60L) {
                break label775;
              }
              if (bool)
              {
                paramDecodeProtoPkgContext = String.valueOf(l2);
                localObject = new hd_video_2.MsgBody();
              }
              try
              {
                ((hd_video_2.MsgBody)localObject).mergeFrom(arrayOfByte2);
                i = ((hd_video_2.MsgBody)localObject).msg_invite_body.uint32_new_business_flag.get();
                if (-1 == i)
                {
                  VideoMsgTools.a(paramMessageHandler.b, 0, 6, true, paramDecodeProtoPkgContext, String.valueOf(l4), false, null, false, new Object[] { paramMsg });
                  a(l4, l2, 208);
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("shanezhaiSHARP", 2, "Discard video message because of time out " + l5 + " s");
                }
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  localException.printStackTrace();
                  i = -1;
                }
              }
            }
          }
        }
      }
    }
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      VideoMsgTools.a(paramMessageHandler.b, 0, 6, bool, paramDecodeProtoPkgContext, String.valueOf(l2), false, null, false, new Object[] { paramMsg });
      break;
    }
    label775:
    if (bool) {
      a(l4, l2, 211);
    }
    if (QLog.isColorLevel()) {
      QLog.d("shanezhaiSHARP", 2, "===========handleSharpVideoMessageResp 1234========");
    }
    paramMessageHandler.a(l4, arrayOfByte2, l2, (int)l1, bool);
  }
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List paramList)
  {
    Object localObject2 = (im_msg_body.Ptt)((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).ptt.get();
    Object localObject6 = ((im_msg_body.Ptt)localObject2).bytes_file_name.get().toStringUtf8();
    Object localObject1 = null;
    int k;
    int i2;
    int j;
    boolean bool;
    long l2;
    long l3;
    long l4;
    long l5;
    long l6;
    Object localObject5;
    int m;
    label201:
    int i;
    long l1;
    if (((String)localObject6).endsWith(".amr"))
    {
      if (!SttManager.a(paramMessageHandler.b)) {
        break label1087;
      }
      k = 1;
      i2 = g(paramMsg);
      j = ((im_msg_body.Ptt)localObject2).uint32_file_type.get();
      bool = ((im_msg_body.Ptt)localObject2).bool_valid.get();
      l2 = ((im_msg_body.Ptt)localObject2).uint64_src_uin.get();
      l3 = ((im_msg_body.Ptt)localObject2).uint32_file_size.get();
      l4 = ((im_msg_body.Ptt)localObject2).uint32_file_id.get() & 0xFFFFFFFF;
      l5 = ((im_msg_body.Ptt)localObject2).uint32_server_ip.get();
      l6 = ((im_msg_body.Ptt)localObject2).uint32_server_port.get();
      localObject5 = ((im_msg_body.Ptt)localObject2).bytes_file_uuid.get().toByteArray();
      localObject1 = ((im_msg_body.Ptt)localObject2).bytes_file_md5.get().toByteArray();
      if (!((im_msg_body.Ptt)localObject2).uint32_format.has()) {
        break label1093;
      }
      m = ((im_msg_body.Ptt)localObject2).uint32_format.get();
      if (!((im_msg_body.Ptt)localObject2).uint32_time.has()) {
        break label1099;
      }
      i = ((im_msg_body.Ptt)localObject2).uint32_time.get();
      l1 = RecordParams.b(i);
      if (!((im_msg_body.Ptt)localObject2).bytes_down_para.has()) {
        break label2188;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SPD", 2, "receive ptt msg , bytes_down_para has ! " + ((im_msg_body.Ptt)localObject2).bytes_down_para.get());
      }
      localObject4 = ((im_msg_body.Ptt)localObject2).bytes_down_para.get();
      if (localObject4 == null) {
        break label2188;
      }
    }
    label2179:
    label2188:
    for (Object localObject4 = ((ByteStringMicro)localObject4).toStringUtf8();; localObject4 = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("SPD", 2, "receive ptt msg , url : " + (String)localObject4 + " srcuin " + l2 + "filename" + (String)localObject6);
      }
      if (QLog.isColorLevel()) {
        QLog.d("RecordParams", 2, "<---decodeGrpDisMsgPkg_PTT voiceType：" + m + " voiceLengh:" + l1);
      }
      Object localObject7 = HexUtil.a((byte[])localObject5);
      localObject5 = HexUtil.a((byte[])localObject1);
      if (((im_msg_body.Ptt)localObject2).bytes_group_file_key.has()) {}
      label1087:
      label1093:
      label1099:
      MessageRecord localMessageRecord;
      for (localObject1 = ((im_msg_body.Ptt)localObject2).bytes_group_file_key.get().toByteArray();; localMessageRecord = null) {
        for (;;)
        {
          int n;
          try
          {
            localObject1 = new String((byte[])localObject1, "utf-8");
            if (localObject5 != null) {
              break label2179;
            }
            localObject5 = "";
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder("<---decodeSinglePbMsg_GroupDis:");
              localStringBuilder.append(" pttType:").append(j).append(" isValid:").append(bool).append(" srcUin:").append(l2).append(" fileSize:").append(l3 & 0xFFFFFFFF).append(" fileID").append(l4).append(" serverIP:").append(l5 & 0xFFFFFFFF).append(" serverPort:").append(l6 & 0xFFFFFFFF).append(" fileName:").append((String)localObject6).append(" uuidStr:").append((String)localObject7).append(" md5Str:").append((String)localObject5).append(" GrpFileKey:").append((String)localObject1);
              QLog.d("Q.msg.MessageHandler", 2, localStringBuilder.toString());
            }
            n = 0;
            int i1 = 0;
            if (!((im_msg_body.Ptt)localObject2).bytes_pb_reserve.has()) {
              break label2167;
            }
            localObject7 = new ptt_reserve.ReserveStruct();
            j = i1;
            i = n;
            try
            {
              ((ptt_reserve.ReserveStruct)localObject7).mergeFrom(((im_msg_body.Ptt)localObject2).bytes_pb_reserve.get().toByteArray());
              j = i1;
              i = n;
              n = ((ptt_reserve.ReserveStruct)localObject7).uint32_change_voice.get();
              j = i1;
              i = n;
              i1 = ((ptt_reserve.ReserveStruct)localObject7).uint32_redpack_type.get();
              j = i1;
              i = n;
              if (!((ptt_reserve.ReserveStruct)localObject7).bytes_redpack_score_id.has()) {
                break label2160;
              }
              j = i1;
              i = n;
              localObject2 = ((ptt_reserve.ReserveStruct)localObject7).bytes_redpack_score_id.get().toStringUtf8();
              j = n;
              i = i1;
            }
            catch (Exception localException)
            {
              localObject3 = "";
              n = i;
              i = j;
              j = n;
              continue;
              localObject5 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
              localObject4 = new StringBuilder();
              if ((localObject5 != null) && (((List)localObject5).size() > 0)) {
                break label1209;
              }
              if (!QLog.isColorLevel()) {
                continue;
              }
              ((StringBuilder)localObject4).append("elems:null || elems.size() <= 0");
              QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject4).toString());
              return;
              if (!QLog.isColorLevel()) {
                break label1240;
              }
              ((StringBuilder)localObject4).append("elemsSize").append(((List)localObject5).size()).append("\n");
              i = 0;
              if (i >= ((List)localObject5).size()) {
                break label1755;
              }
              localObject6 = (im_msg_body.Elem)((List)localObject5).get(i);
              if (!((im_msg_body.Elem)localObject6).near_by_msg.has()) {
                break label1482;
              }
              if (!QLog.isColorLevel()) {
                break label1292;
              }
              ((StringBuilder)localObject4).append("elemType: near_by_msg;");
              paramList = ((im_msg_body.Elem)localObject6).near_by_msg;
              if ((!paramList.uint32_identify_type.has()) || (paramList.uint32_identify_type.get() != 1)) {
                break label1345;
              }
              localMessageRecord.saveExtInfoToExtStr("identify_flag", "true");
              if (!QLog.isColorLevel()) {
                break label1345;
              }
              ((StringBuilder)localObject4).append("has identify;");
              for (;;)
              {
                if ((((im_msg_body.Elem)localObject6).general_flags.has()) && (((im_msg_body.Elem)localObject6).general_flags.bytes_pb_reserve.has())) {
                  paramList = new generalflags.ResvAttr();
                }
                try
                {
                  paramList.mergeFrom(((im_msg_body.Elem)localObject6).general_flags.bytes_pb_reserve.get().toByteArray());
                  if (paramList.uint32_holiday_flag.has())
                  {
                    j = paramList.uint32_holiday_flag.get();
                    if (j == 1) {
                      localMessageRecord.saveExtInfoToExtStr(MessageConstants.jdField_c_of_type_JavaLangString, String.valueOf(j));
                    }
                    if (QLog.isColorLevel()) {
                      QLog.i("Q.msg.MessageHandler", 2, "decodeGrpDisMsgPkg_PTT uint32_holiday_flag = " + j);
                    }
                  }
                }
                catch (Exception paramList)
                {
                  for (;;)
                  {
                    paramList.printStackTrace();
                  }
                }
                GoldMsgChatHelper.a((im_msg_body.Elem)localObject6, localMessageRecord);
                i += 1;
                break;
                if (((im_msg_body.Elem)localObject6).pub_group.has())
                {
                  paramList = (im_msg_body.PubGroup)((im_msg_body.Elem)localObject6).pub_group.get();
                  if (paramList != null)
                  {
                    j = paramList.uint32_gender.get();
                    localObject3 = paramList.bytes_nickname.get().toStringUtf8();
                    localMessageRecord.saveExtInfoToExtStr("hotchat_gender", String.valueOf(j));
                    paramList = (List)localObject3;
                    if (localObject3 == null) {
                      paramList = "";
                    }
                    localMessageRecord.saveExtInfoToExtStr("hotchat_nick", paramList);
                    if (QLog.isColorLevel()) {
                      ((StringBuilder)localObject4).append("has pub_group;");
                    }
                  }
                }
                else if ((((im_msg_body.Elem)localObject6).general_flags.has()) && (((im_msg_body.GeneralFlags)((im_msg_body.Elem)localObject6).general_flags.get()).uint32_olympic_torch.has()))
                {
                  j = ((im_msg_body.Elem)localObject6).general_flags.uint32_olympic_torch.get();
                  if (QLog.isColorLevel()) {
                    ((StringBuilder)localObject4).append("has olympicTorch:").append(j).append(";");
                  }
                  if (j > 0) {
                    localMessageRecord.saveExtInfoToExtStr("olympic_torch_flg", j + "");
                  }
                }
                else if ((((im_msg_body.Elem)localObject6).common_elem.has()) && (13 == ((im_msg_body.Elem)localObject6).common_elem.uint32_service_type.get()))
                {
                  if (QLog.isColorLevel()) {
                    ((StringBuilder)localObject4).append("decodeGrpDisMsgPkg_PTT decode hummer_commelem == UpdateStrangerAvatar");
                  }
                  new MessagePBElemDecoder().a((List)localObject5, paramMsg, (StringBuilder)localObject4);
                }
              }
              i = 0;
              for (;;)
              {
                if (i < ((List)localObject5).size())
                {
                  paramList = (im_msg_body.Elem)((List)localObject5).get(i);
                  if (paramList.general_flags.bytes_pb_reserve.has()) {
                    localObject3 = new generalflags.ResvAttr();
                  }
                  try
                  {
                    ((generalflags.ResvAttr)localObject3).mergeFrom(paramList.general_flags.bytes_pb_reserve.get().toByteArray());
                    if (((generalflags.ResvAttr)localObject3).uint32_robot_msg_flag.has())
                    {
                      j = ((generalflags.ResvAttr)localObject3).uint32_robot_msg_flag.get();
                      localMessageRecord.mRobotFlag = j;
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.MessageHandler", 2, "handleGeneralSettingFlags uint32_robot_msg_flag = " + j);
                      }
                    }
                    i += 1;
                  }
                  catch (InvalidProtocolBufferMicroException paramList)
                  {
                    for (;;)
                    {
                      paramList.printStackTrace();
                    }
                  }
                }
              }
              bool = ((TroopRobotManager)paramMessageHandler.b.getManager(202)).a(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get());
              if ((localMessageRecord.mRobotFlag != 1) && (localMessageRecord.mRobotFlag != 2) && (!bool)) {
                break label2142;
              }
              paramMsg = ((List)localObject5).iterator();
              while (paramMsg.hasNext())
              {
                paramMessageHandler = (im_msg_body.Elem)paramMsg.next();
                if (paramMessageHandler.text.has())
                {
                  paramMessageHandler = (im_msg_body.Text)paramMessageHandler.text.get();
                  if (paramMessageHandler.attr_6_buf.has())
                  {
                    paramMessageHandler = paramMessageHandler.attr_6_buf.get();
                    if (paramMessageHandler != null) {}
                    for (paramMessageHandler = paramMessageHandler.toByteArray();; paramMessageHandler = null)
                    {
                      if ((paramMessageHandler == null) || (paramMessageHandler.length == 0)) {
                        break label2132;
                      }
                      k = PkgTools.a(paramMessageHandler, 0);
                      j = 2;
                      i = 0;
                      for (;;)
                      {
                        if ((i >= k) || (j >= 2048)) {
                          break label2127;
                        }
                        paramList = new MessageForText.AtTroopMemberInfo();
                        if (!paramList.readFrom(paramMessageHandler, j)) {
                          break;
                        }
                        j += paramList.length();
                        i = (short)(i + 1);
                        if (localMessageRecord.atInfoList == null) {
                          localMessageRecord.atInfoList = new ArrayList();
                        }
                        localMessageRecord.atInfoList.add(paramList);
                      }
                      break;
                    }
                  }
                }
              }
              ((MessageForPtt)localMessageRecord).parse();
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject4).toString());
              return;
            }
            TransfileUtile.a((String)localObject6, 0L, 2, false, (String)localObject6);
            localObject7 = new RichMsg.PttRec();
            ((RichMsg.PttRec)localObject7).localPath.set((String)localObject6);
            ((RichMsg.PttRec)localObject7).size.set(0L);
            ((RichMsg.PttRec)localObject7).type.set(2);
            ((RichMsg.PttRec)localObject7).uuid.set((String)localObject6);
            ((RichMsg.PttRec)localObject7).isRead.set(false);
            ((RichMsg.PttRec)localObject7).md5.set((String)localObject5);
            ((RichMsg.PttRec)localObject7).isReport.set(0);
            ((RichMsg.PttRec)localObject7).version.set(5);
            ((RichMsg.PttRec)localObject7).groupFileID.set(l4);
            ((RichMsg.PttRec)localObject7).pttFlag.set(k);
            ((RichMsg.PttRec)localObject7).longPttVipFlag.set(i2);
            if (localObject1 != null) {
              ((RichMsg.PttRec)localObject7).group_file_key.set((String)localObject1);
            }
            l2 = System.currentTimeMillis() / 1000L;
            l3 = paramMsg.msg_head.msg_time.get();
            ((RichMsg.PttRec)localObject7).msgRecTime.set(l2);
            ((RichMsg.PttRec)localObject7).msgTime.set(l3);
            ((RichMsg.PttRec)localObject7).voiceType.set(m);
            ((RichMsg.PttRec)localObject7).voiceLength.set(Utils.a(l1));
            ((RichMsg.PttRec)localObject7).voiceChangeFlag.set(j);
            ((RichMsg.PttRec)localObject7).directUrl.set((String)localObject4);
            ((RichMsg.PttRec)localObject7).redpack_type.set(i);
            localObject1 = MessageRecordFactory.a(-2002);
            ((MessageRecord)localObject1).msgtype = -2002;
            ((MessageRecord)localObject1).msgData = ((RichMsg.PttRec)localObject7).toByteArray();
            ((MessageForPtt)localObject1).parse();
            paramList.add(localObject1);
            localObject4 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
            new MessagePBElemDecoder().a((List)localObject4, paramList);
            VoiceRedPacketHelper.a((String)localObject2, (MessageRecord)localObject1);
            if (localObject1 == null)
            {
              return;
              k = 0;
              break;
              m = 0;
              break label201;
              i = 0;
            }
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            localMessageRecord = null;
            continue;
          }
          label1209:
          label1240:
          label1755:
          label2142:
          label2160:
          Object localObject3 = "";
          label1292:
          label1345:
          label1482:
          label2127:
          label2132:
          continue;
          label2167:
          localObject3 = "";
          i = 0;
          j = 0;
        }
      }
    }
  }
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_Dataline");
    }
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_Dataline: return isReaded4DataLine:" + paramBoolean);
      }
      return;
    }
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new ahxo(paramMessageHandler, paramMsg));
      return;
    }
    ((DataLineHandler)paramMessageHandler.b.a(8)).a(paramMsg);
  }
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
    long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    MessageCache.a();
    Long.valueOf(paramMessageHandler.b.getCurrentAccountUin()).longValue();
    byte[] arrayOfByte = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
    if (QLog.isColorLevel()) {
      QLog.d("shanezhai", 2, "recv MultiVideo offline msg !msgTime is:" + l1);
    }
    paramMessageHandler.b.a().a(arrayOfByte, paramMsg);
  }
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_AddFriend return null:hasBody:" + paramMsg.msg_body.has() + ",hasMsgContent" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has() + ",isReaded:" + paramBoolean1 + "syncOther:" + paramBoolean2);
      }
    }
    String str;
    do
    {
      do
      {
        return;
        long l1 = Long.valueOf(paramMessageHandler.b.getCurrentAccountUin()).longValue();
        long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
        short s = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_type.get();
        if ((!paramBoolean1) && (!paramBoolean2) && (!paramBoolean3)) {
          paramMessageHandler.a().a(l1, l2, s, -1006 - (s - 187), paramMsg, paramInt);
        }
        localObject = (msg_comm.MsgHead)paramMsg.msg_head.get();
      } while (localObject == null);
      paramMsg = "" + ((msg_comm.MsgHead)localObject).auth_uin.get();
      str = ((msg_comm.MsgHead)localObject).auth_nick.get();
      Object localObject = ((msg_comm.MsgHead)localObject).auth_remark.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler.sysnick", 2, "FriendSys auUin:" + paramMsg + "aunick:" + str + "auRemark:" + (String)localObject);
      }
      if ((!TextUtils.isEmpty(paramMsg)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler.sysremark", 2, "FriendSys saveremark");
        }
        paramMessageHandler.b(paramMsg, (String)localObject);
      }
    } while ((TextUtils.isEmpty(paramMsg)) || (TextUtils.isEmpty(str)));
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler.sysnick", 2, "FriendSys savenick");
    }
    paramMessageHandler.a(paramMsg, str);
  }
  
  public static void a(MessageHandler paramMessageHandler, msg_comm.MsgType0x210 paramMsgType0x210)
  {
    paramMessageHandler = paramMsgType0x210.msg_content.get().toByteArray();
    paramMsgType0x210 = new Submsgtype0x35.MsgBody();
    try
    {
      int i = ((Submsgtype0x35.MsgBody)paramMsgType0x210.mergeFrom(paramMessageHandler)).uint32_bubble_timestamp.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_MsgType0x210 bubble push timestamp=" + i);
      }
      return;
    }
    catch (Exception paramMessageHandler)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : fail to parse SubMsgType0x35.");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Submsgtype0x8a.ReqBody paramReqBody, long paramLong, boolean paramBoolean)
  {
    int i = 0;
    long l = 0L;
    Object localObject1 = (ArrayList)paramReqBody.msg_info.get();
    Object localObject2 = new msgrevoke_userdef.UinTypeUserDef();
    Object localObject3;
    try
    {
      ((msgrevoke_userdef.UinTypeUserDef)localObject2).mergeFrom(paramReqBody.bytes_reserved.get().toByteArray());
      int j = ((msgrevoke_userdef.UinTypeUserDef)localObject2).uint32_from_uin_type.get();
      if (j == 1)
      {
        i = 1000;
        l = ((msgrevoke_userdef.UinTypeUserDef)localObject2).uint64_from_group_code.get();
      }
      for (;;)
      {
        localObject2 = new ArrayList();
        paramReqBody = ((ArrayList)localObject1).iterator();
        while (paramReqBody.hasNext())
        {
          localObject1 = (Submsgtype0x8a.MsgInfo)paramReqBody.next();
          localObject3 = new RevokeMsgInfo();
          ((RevokeMsgInfo)localObject3).jdField_a_of_type_Int = i;
          ((RevokeMsgInfo)localObject3).jdField_b_of_type_JavaLangString = String.valueOf(((Submsgtype0x8a.MsgInfo)localObject1).uint64_from_uin.get());
          ((RevokeMsgInfo)localObject3).jdField_a_of_type_JavaLangString = String.valueOf(((Submsgtype0x8a.MsgInfo)localObject1).uint64_to_uin.get());
          ((RevokeMsgInfo)localObject3).jdField_c_of_type_JavaLangString = String.valueOf(l);
          ((RevokeMsgInfo)localObject3).jdField_a_of_type_Long = ((short)((Submsgtype0x8a.MsgInfo)localObject1).uint32_msg_seq.get());
          ((RevokeMsgInfo)localObject3).jdField_b_of_type_Long = ((Submsgtype0x8a.MsgInfo)localObject1).uint64_msg_uid.get();
          ((RevokeMsgInfo)localObject3).jdField_c_of_type_Long = ((Submsgtype0x8a.MsgInfo)localObject1).uint64_msg_time.get();
          ((RevokeMsgInfo)localObject3).jdField_b_of_type_Int = ((Submsgtype0x8a.MsgInfo)localObject1).uint32_div_seq.get();
          ((RevokeMsgInfo)localObject3).jdField_c_of_type_Int = ((Submsgtype0x8a.MsgInfo)localObject1).uint32_pkg_num.get();
          ((RevokeMsgInfo)localObject3).d = ((Submsgtype0x8a.MsgInfo)localObject1).uint32_pkg_index.get();
          ((ArrayList)localObject2).add(localObject3);
          if (QLog.isColorLevel()) {
            QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b msg," + ((RevokeMsgInfo)localObject3).toString());
          }
        }
        if (j == 2)
        {
          i = 1004;
          l = ((msgrevoke_userdef.UinTypeUserDef)localObject2).uint64_from_group_code.get();
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b msg, prase uintypeUserdef error");
      }
    }
    label765:
    for (;;)
    {
      if (!paramBoolean)
      {
        paramQQAppInterface.a().a((ArrayList)localObject2, false);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b subaccount msg");
      }
      if (!((ArrayList)localObject2).isEmpty())
      {
        String str1 = Long.toString(paramLong);
        String str2 = paramQQAppInterface.getCurrentAccountUin();
        SubAccountManager localSubAccountManager = (SubAccountManager)paramQQAppInterface.getManager(60);
        if (localSubAccountManager != null)
        {
          List localList = localSubAccountManager.a(str1);
          paramReqBody = null;
          localObject1 = null;
          Iterator localIterator1 = ((ArrayList)localObject2).iterator();
          if (localIterator1.hasNext())
          {
            localObject2 = (RevokeMsgInfo)localIterator1.next();
            Iterator localIterator2 = localList.iterator();
            while (localIterator2.hasNext())
            {
              localObject3 = (SubAccountMessage)localIterator2.next();
              if ((((RevokeMsgInfo)localObject2).jdField_a_of_type_Long == ((SubAccountMessage)localObject3).shmsgseq) && (((RevokeMsgInfo)localObject2).jdField_b_of_type_Long == ((SubAccountMessage)localObject3).msgUid))
              {
                localObject1 = localObject3;
                paramReqBody = (Submsgtype0x8a.ReqBody)localObject2;
              }
            }
          }
          for (;;)
          {
            break;
            if (paramReqBody == null) {
              break label765;
            }
            localObject2 = (SubAccountMessage)((SubAccountMessage)localObject1).deepCopyByReflect();
            ((SubAccountMessage)localObject2).msg = "对方".concat(BaseApplicationImpl.getApplication().getString(2131438102));
            ((SubAccountMessage)localObject2).unreadNum = Math.max(0, ((SubAccountMessage)localObject1).unreadNum - 1);
            ((SubAccountMessage)localObject2).time = paramReqBody.jdField_c_of_type_Long;
            ((SubAccountMessage)localObject2).needNotify = paramQQAppInterface.isBackground_Pause;
            ((SubAccountMessage)localObject2).mTimeString = TimeFormatterUtils.a(((SubAccountMessage)localObject2).time * 1000L, true, SubAccountControll.jdField_a_of_type_JavaLangString);
            ((SubAccountMessage)localObject2).mEmoRecentMsg = new QQText(((SubAccountMessage)localObject2).msg, 0);
            if (localSubAccountManager != null) {
              localSubAccountManager.a((SubAccountMessage)localObject2);
            }
            SubAccountControll.a(paramQQAppInterface, str1, 6);
            paramReqBody = ((SubAccountMessage)localObject2).convertToMessageRecord();
            paramReqBody.istroop = 7000;
            paramReqBody.frienduin = str1;
            paramQQAppInterface.a().c(paramReqBody.frienduin, paramReqBody.istroop, -1);
            localObject1 = new ArrayList();
            ((ArrayList)localObject1).add(paramReqBody);
            paramQQAppInterface.a().a((ArrayList)localObject1, str2, false, false, true);
            paramQQAppInterface.C();
            paramReqBody = new SubAccountBackProtocData();
            paramReqBody.jdField_b_of_type_JavaLangString = str2;
            paramReqBody.jdField_c_of_type_JavaLangString = str1;
            paramReqBody.jdField_c_of_type_Boolean = true;
            paramReqBody.d = true;
            paramReqBody.jdField_a_of_type_Int = 0;
            paramQQAppInterface.a().a().a(8003, true, paramReqBody);
            return;
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    Object localObject = new Submsgtype0x4e.MsgBody();
    for (;;)
    {
      int i;
      long l1;
      long l2;
      long l3;
      String str;
      int j;
      try
      {
        paramArrayOfByte = (Submsgtype0x4e.MsgBody)((Submsgtype0x4e.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        i = paramArrayOfByte.uint32_appid.get();
        l1 = paramArrayOfByte.uint64_group_id.get();
        l2 = paramArrayOfByte.uint64_group_code.get();
        if (paramArrayOfByte.msg_group_bulletin.has())
        {
          l3 = (int)MessageCache.a();
          localObject = paramArrayOfByte.msg_group_bulletin.rpt_msg_content.get();
          new ArrayList();
          paramArrayOfByte = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
          localObject = ((List)localObject).iterator();
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          Submsgtype0x4e.GroupBulletin.Content localContent = (Submsgtype0x4e.GroupBulletin.Content)((Iterator)localObject).next();
          l3 = localContent.uint64_uin.get();
          str = localContent.bytes_feedid.get().toStringUtf8();
          j = localContent.uint32_time.get();
          if (TroopNotificationHelper.b(str))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("TroopNotificationHelper", 2, "notice is loading");
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_MsgType0x210 : fail to parse SubMsgType0x4e.");
        }
      }
      if ((TroopNotificationCache)paramArrayOfByte.a(TroopNotificationCache.class, "troopUin=? and feedsId=?", new String[] { String.valueOf(l2), str }) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.MessageHandler", 2, "notice has exist!");
        }
      }
      else {
        TroopNotificationHelper.a(paramQQAppInterface, i, l1, l2, l3, str, j, "OidbSvc.0x852_35", (short)23, false, false);
      }
    }
    paramArrayOfByte.a();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    submsgtype0xb1.MsgBody localMsgBody = new submsgtype0xb1.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramArrayOfByte);
      long l1 = 2000L;
      if (!paramBoolean) {
        l1 = 10000L;
      }
      ThreadManager.getUIHandler().postDelayed(new ahxp(paramQQAppInterface, localMsgBody, paramBoolean), l1);
      long l2;
      if (localMsgBody.deal_info.has())
      {
        l1 = localMsgBody.deal_info.uint64_group_code.get();
        l2 = localMsgBody.deal_info.uint64_uin.get();
        paramArrayOfByte = localMsgBody.deal_info.str_id.get();
        int i = localMsgBody.deal_info.uint32_deal_result.get();
        if (paramQQAppInterface.getCurrentAccountUin().equals(l2 + ""))
        {
          Intent localIntent = new Intent("tencent.video.q2v.close_invite_msg_box_by_invite_id");
          localIntent.putExtra("groupId", l1);
          localIntent.putExtra("inviteId", paramArrayOfByte);
          paramQQAppInterface.getApp().sendBroadcast(localIntent);
        }
        if (i == 0) {
          paramQQAppInterface.a().a(l1, l2, paramArrayOfByte);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler.troopgroup_vedio.invite", 2, "recv 0x210_0xb1, msgBody.deal_info.has()==》troopUin：" + l1 + ", memUin:" + l2 + ", invitedId:" + paramArrayOfByte + ", dealResult:" + i);
        }
      }
      if (localMsgBody.univite_info.has())
      {
        l1 = localMsgBody.univite_info.uint64_group_code.get();
        l2 = localMsgBody.univite_info.uint64_uin.get();
        paramArrayOfByte = localMsgBody.univite_info.str_id.get();
        paramQQAppInterface.a().b(l1, l2, paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler.troopgroup_vedio.invite", 2, "recv 0x210_0xb1, msgBody.univite_info.has()==》troopUin：" + l1 + ", memUin:" + l2 + ", invitedId:" + paramArrayOfByte + ", dealResult:" + paramArrayOfByte);
        }
        if (!paramBoolean) {
          a.put(paramArrayOfByte, Long.valueOf(System.currentTimeMillis() / 1000L));
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.msg.MessageHandler", 2, "recv 0x210_0xb1, prase msgBody error");
    }
  }
  
  private static void a(MessageForText.AtTroopMemberInfo paramAtTroopMemberInfo, im_msg_body.Elem paramElem)
  {
    if (paramAtTroopMemberInfo != null)
    {
      byte[] arrayOfByte = new byte[13];
      PkgTools.a(arrayOfByte, 0, (short)1);
      paramAtTroopMemberInfo.writeTo(arrayOfByte, 2);
      paramElem.text.attr_6_buf.set(ByteStringMicro.copyFrom(arrayOfByte));
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, msg_svc.RoutingHead paramRoutingHead)
  {
    boolean bool = true;
    if (paramRoutingHead == null) {
      return false;
    }
    int i = b(paramMessageRecord.istroop);
    Object localObject1 = paramQQAppInterface.a();
    switch (i)
    {
    case 7: 
    case 9: 
    case 13: 
    default: 
      bool = false;
    }
    for (;;)
    {
      return bool;
      paramQQAppInterface = new msg_svc.C2C();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramRoutingHead.c2c.set(paramQQAppInterface);
      continue;
      paramQQAppInterface = new msg_svc.Grp();
      paramQQAppInterface.group_code.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramRoutingHead.grp.set(paramQQAppInterface);
      continue;
      paramQQAppInterface = new msg_svc.Grp();
      paramQQAppInterface.group_code.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramRoutingHead.grp.set(paramQQAppInterface);
      continue;
      if ((!TextUtils.isEmpty(paramMessageRecord.senderuin)) && (Long.valueOf(paramMessageRecord.senderuin).longValue() != 0L) && (!TextUtils.equals(paramMessageRecord.senderuin, paramMessageRecord.selfuin)) && (TextUtils.equals(paramMessageRecord.senderuin, paramMessageRecord.frienduin))) {}
      paramQQAppInterface = new msg_svc.GrpTmp();
      if (TextUtils.isEmpty(paramMessageRecord.senderuin))
      {
        paramQQAppInterface.group_uin.set(Long.valueOf(paramMessageRecord.selfuin).longValue());
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "createSendRichTextMsgReq, senderuin error, senderuin: " + paramMessageRecord.senderuin + " frienduin: " + paramMessageRecord.frienduin + " msgtype: " + paramMessageRecord.msgtype);
        }
      }
      for (;;)
      {
        paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
        paramRoutingHead.grp_tmp.set(paramQQAppInterface);
        break;
        paramQQAppInterface.group_uin.set(Long.valueOf(paramMessageRecord.senderuin).longValue());
      }
      paramQQAppInterface = new msg_svc.Dis();
      paramQQAppInterface.dis_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramRoutingHead.dis.set(paramQQAppInterface);
      continue;
      paramQQAppInterface = new msg_svc.DisTmp();
      paramQQAppInterface.dis_uin.set(Long.valueOf(paramMessageRecord.senderuin).longValue());
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramRoutingHead.dis_tmp.set(paramQQAppInterface);
      continue;
      paramQQAppInterface = ((MessageCache)localObject1).b(paramMessageRecord.frienduin);
      localObject1 = new msg_svc.WPATmp();
      ((msg_svc.WPATmp)localObject1).to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      if (paramQQAppInterface != null)
      {
        paramMessageRecord = new byte[paramQQAppInterface.length - 2];
        PkgTools.a(paramMessageRecord, 0, paramQQAppInterface, 2, paramQQAppInterface.length - 2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "wpa------>" + HexUtil.a(paramMessageRecord) + ",length:" + paramMessageRecord.length);
        }
        ((msg_svc.WPATmp)localObject1).sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
      }
      paramRoutingHead.wpa_tmp.set((MessageMicro)localObject1);
      continue;
      paramQQAppInterface = ((MessageCache)localObject1).c(paramMessageRecord.frienduin);
      localObject1 = new msg_svc.QQQueryBusinessTmp();
      ((msg_svc.QQQueryBusinessTmp)localObject1).to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      if (paramQQAppInterface != null)
      {
        paramMessageRecord = new byte[paramQQAppInterface.length - 2];
        PkgTools.a(paramMessageRecord, 0, paramQQAppInterface, 2, paramQQAppInterface.length - 2);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "wpa------>" + HexUtil.a(paramMessageRecord) + ",length:" + paramMessageRecord.length);
        }
        ((msg_svc.QQQueryBusinessTmp)localObject1).sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
      }
      paramRoutingHead.qq_querybusiness_tmp.set((MessageMicro)localObject1);
      continue;
      Object localObject2 = ((MessageCache)localObject1).d(paramMessageRecord.frienduin);
      paramQQAppInterface = new msg_svc.BusinessWPATmp();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      if (localObject2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "conversation------>sig:" + HexUtil.a((byte[])localObject2) + ",length:" + localObject2.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom((byte[])localObject2));
      }
      for (;;)
      {
        paramRoutingHead.business_wpa_tmp.set(paramQQAppInterface);
        break;
        paramMessageRecord = ((MessageCache)localObject1).e(paramMessageRecord.frienduin);
        if (paramMessageRecord != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MessageHandler", 2, "conversation------>sigt:" + HexUtil.a(paramMessageRecord) + ",length:" + paramMessageRecord.length);
          }
          paramQQAppInterface.sigt.set(ByteStringMicro.copyFrom(paramMessageRecord));
        }
      }
      paramQQAppInterface = new msg_svc.AddressListTmp();
      paramQQAppInterface.from_phone.set(paramMessageRecord.senderuin);
      paramQQAppInterface.to_phone.set(paramMessageRecord.frienduin);
      paramMessageRecord = ((MessageCache)localObject1).f(paramMessageRecord.frienduin);
      if (paramMessageRecord != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "sameState------>" + HexUtil.a(paramMessageRecord) + ",length:" + paramMessageRecord.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
      }
      paramRoutingHead.address_list.set(paramQQAppInterface);
      continue;
      paramQQAppInterface = ((MessageCache)localObject1).a(paramMessageRecord.frienduin);
      localObject1 = new msg_svc.PublicPlat();
      ((msg_svc.PublicPlat)localObject1).to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      if (paramQQAppInterface != null)
      {
        paramMessageRecord = new byte[paramQQAppInterface.length - 2];
        PkgTools.a(paramMessageRecord, 0, paramQQAppInterface, 2, paramQQAppInterface.length - 2);
        ((msg_svc.PublicPlat)localObject1).sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
      }
      paramRoutingHead.public_plat.set((MessageMicro)localObject1);
      continue;
      paramQQAppInterface = new msg_svc.RichStatusTmp();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramMessageRecord = ((MessageCache)localObject1).j(paramMessageRecord.frienduin);
      if (paramMessageRecord != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "sameState------>" + HexUtil.a(paramMessageRecord) + ",length:" + paramMessageRecord.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
      }
      paramRoutingHead.rich_status_tmp.set(paramQQAppInterface);
      continue;
      localObject2 = new msg_svc.AccostTmp();
      ((msg_svc.AccostTmp)localObject2).to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramQQAppInterface = paramQQAppInterface.a().a(paramMessageRecord.frienduin, 1001);
      ((msg_svc.AccostTmp)localObject2).reply.set(paramQQAppInterface.hasReply);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "LBSFriend------>reply=" + paramQQAppInterface.hasReply);
      }
      paramQQAppInterface = ((MessageCache)localObject1).m(paramMessageRecord.frienduin);
      if (paramQQAppInterface != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("fight_accost", 4, "发送附近人临时会消息 有keyLBSFriend------>" + HexUtil.a(paramQQAppInterface) + ",length:" + paramQQAppInterface.length);
        }
        ((msg_svc.AccostTmp)localObject2).sig.set(ByteStringMicro.copyFrom(paramQQAppInterface));
      }
      paramRoutingHead.accost_tmp.set((MessageMicro)localObject2);
      continue;
      localObject2 = new msg_svc.CommTmp();
      ((msg_svc.CommTmp)localObject2).to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      ((msg_svc.CommTmp)localObject2).c2c_type.set(1);
      ((msg_svc.CommTmp)localObject2).svr_type.set(149);
      paramQQAppInterface = paramQQAppInterface.a().a(paramMessageRecord.frienduin, 1001);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "TribeTmp------>reply=" + paramQQAppInterface.hasReply);
      }
      paramQQAppInterface = ((MessageCache)localObject1).k(paramMessageRecord.frienduin);
      if (paramQQAppInterface != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("fight_accost", 4, "发送兴趣部落临时会消息 有key------>" + HexUtil.a(paramQQAppInterface) + ",length:" + paramQQAppInterface.length);
        }
        ((msg_svc.CommTmp)localObject2).sig.set(ByteStringMicro.copyFrom(paramQQAppInterface));
      }
      paramRoutingHead.comm_tmp.set((MessageMicro)localObject2);
      continue;
      paramQQAppInterface = new msg_svc.CommTmp();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramQQAppInterface.c2c_type.set(1);
      paramQQAppInterface.svr_type.set(153);
      paramRoutingHead.comm_tmp.set(paramQQAppInterface);
      paramMessageRecord = ((MessageCache)localObject1).l(paramMessageRecord.frienduin);
      if (paramMessageRecord != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "movieTicket------>" + HexUtil.a(paramMessageRecord) + ",length:" + paramMessageRecord.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
      }
      paramRoutingHead.comm_tmp.set(paramQQAppInterface);
      continue;
      paramQQAppInterface = new msg_svc.PubGroupTmp();
      paramQQAppInterface.group_uin.set(Long.valueOf(paramMessageRecord.senderuin).longValue());
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramRoutingHead.pub_group_tmp.set(paramQQAppInterface);
      continue;
      paramQQAppInterface = new msg_svc.BsnsTmp();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramMessageRecord = ((MessageCache)localObject1).g(paramMessageRecord.frienduin);
      if (paramMessageRecord != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "circleGroup------>" + HexUtil.a(paramMessageRecord) + ",length:" + paramMessageRecord.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
      }
      paramRoutingHead.bsns_tmp.set(paramQQAppInterface);
      continue;
      paramQQAppInterface = new msg_svc.AuthTmp();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramMessageRecord = ((MessageCache)localObject1).i(paramMessageRecord.frienduin);
      if (paramMessageRecord != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler", 2, "friendValidation------>" + HexUtil.a(paramMessageRecord) + ",length:" + paramMessageRecord.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
      }
      paramRoutingHead.auth_tmp.set(paramQQAppInterface);
      continue;
      localObject2 = new msg_svc.NearByDatingTmp();
      ((msg_svc.NearByDatingTmp)localObject2).to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramQQAppInterface = paramQQAppInterface.a().a(paramMessageRecord.frienduin, 1010);
      ((msg_svc.NearByDatingTmp)localObject2).reply.set(paramQQAppInterface.hasReply);
      paramQQAppInterface = ((MessageCache)localObject1).q(paramMessageRecord.frienduin);
      if (paramQQAppInterface != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("nearby_dating", 4, "发送附近人约会临时会话消息 有keyNearbyDating------>" + HexUtil.a(paramQQAppInterface) + ",length:" + paramQQAppInterface.length);
        }
        ((msg_svc.NearByDatingTmp)localObject2).sig.set(ByteStringMicro.copyFrom(paramQQAppInterface));
      }
      paramRoutingHead.nearby_dating_tmp.set((MessageMicro)localObject2);
      continue;
      paramQQAppInterface = new msg_svc.NearByAssistantTmp();
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramMessageRecord = ((MessageCache)localObject1).p(paramMessageRecord.frienduin);
      if (paramMessageRecord != null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("nearby_assistant", 4, "发送附近人助手临时会话消息 有NearbyAssistantKey------>" + HexUtil.a(paramMessageRecord) + ",length:" + paramMessageRecord.length);
        }
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
      }
      paramRoutingHead.nearby_assistant_tmp.set(paramQQAppInterface);
      continue;
      paramQQAppInterface = new msg_svc.CommTmp();
      paramQQAppInterface.c2c_type.set(1);
      paramQQAppInterface.svr_type.set(144);
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramMessageRecord = ((MessageCache)localObject1).n(paramMessageRecord.frienduin);
      if (paramMessageRecord != null) {
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
      }
      paramRoutingHead.comm_tmp.set(paramQQAppInterface);
      continue;
      paramQQAppInterface = new msg_svc.CommTmp();
      paramQQAppInterface.c2c_type.set(1);
      paramQQAppInterface.svr_type.set(151);
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramMessageRecord = ((MessageCache)localObject1).o(paramMessageRecord.frienduin);
      if (paramMessageRecord != null) {
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
      }
      paramRoutingHead.comm_tmp.set(paramQQAppInterface);
      continue;
      paramQQAppInterface = new msg_svc.CommTmp();
      paramQQAppInterface.c2c_type.set(1);
      paramQQAppInterface.svr_type.set(156);
      paramQQAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
      paramMessageRecord = ((MessageCache)localObject1).a(paramMessageRecord.frienduin, paramMessageRecord.selfuin);
      if (paramMessageRecord != null) {
        paramQQAppInterface.sig.set(ByteStringMicro.copyFrom(paramMessageRecord));
      }
      paramRoutingHead.comm_tmp.set(paramQQAppInterface);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2 = paramQQAppInterface.a().b(AppConstants.Z, 0);
    Object localObject1 = new SubMsgType0x76.MsgBody();
    int j;
    int i;
    try
    {
      ((SubMsgType0x76.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
      j = ((SubMsgType0x76.MsgBody)localObject1).uint32_msg_type.get();
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder().append("receive push, msg type = ").append(j).append(", local msg count = ");
        if (localObject2 != null)
        {
          i = ((List)localObject2).size();
          QLog.d("ActivateFriends.Processor", 2, i);
        }
      }
      else
      {
        if (localObject2 == null) {
          break label254;
        }
        paramArrayOfByte = ((List)localObject2).iterator();
        for (;;)
        {
          label113:
          if (paramArrayOfByte.hasNext())
          {
            localObject2 = (MessageRecord)paramArrayOfByte.next();
            if ((localObject2 instanceof MessageForActivateFriends))
            {
              localObject2 = (MessageForActivateFriends)localObject2;
              if ((((MessageForActivateFriends)localObject2).getMsgBody() != null) && (((MessageForActivateFriends)localObject2).getMsgBody().uint32_msg_type.get() != j)) {
                continue;
              }
              paramQQAppInterface.a().b(AppConstants.Z, 0, ((MessageForActivateFriends)localObject2).uniseq);
              continue;
              return false;
            }
          }
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends", 2, "parse push got error.", paramQQAppInterface);
      }
    }
    label254:
    ActivateFriendsManager localActivateFriendsManager;
    label405:
    do
    {
      i = -1;
      break;
      if (!QLog.isColorLevel()) {
        break label113;
      }
      QLog.e("ActivateFriends.Processor", 2, "local data is error." + localObject2);
      break label113;
      paramArrayOfByte = MessageRecordFactory.a(-5003);
      paramArrayOfByte.selfuin = paramQQAppInterface.getCurrentAccountUin();
      paramArrayOfByte.frienduin = AppConstants.Z;
      paramArrayOfByte.istroop = 9002;
      paramArrayOfByte.senderuin = "";
      localObject2 = (FriendsManager)paramQQAppInterface.getManager(50);
      localActivateFriendsManager = (ActivateFriendsManager)paramQQAppInterface.getManager(84);
      if (j != 1) {
        break label584;
      }
      if (((SubMsgType0x76.MsgBody)localObject1).msg_geographic_notify.rpt_msg_one_friend.get().size() <= 0) {
        break label565;
      }
      localObject2 = (MessageForActivateFriends)paramArrayOfByte;
      ((MessageForActivateFriends)localObject2).msg = ActivateFriendsManager.a(paramQQAppInterface.getApp(), (SubMsgType0x76.MsgBody)localObject1);
      ((MessageForActivateFriends)localObject2).msgBody = ((SubMsgType0x76.MsgBody)localObject1);
      ((MessageForActivateFriends)localObject2).msgData = ((SubMsgType0x76.MsgBody)localObject1).toByteArray();
      break label812;
      ReportController.b(paramQQAppInterface, "CliOper", "", "", (String)localObject1, (String)localObject2, localActivateFriendsManager.jdField_a_of_type_Int, 0, "", "", "", "");
    } while (paramArrayOfByte == null);
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends", 2, "activiate_friends|rec msg  fromUin:" + paramLong1 + " toUin:" + paramLong2 + " seq:" + paramInt1);
    }
    paramArrayOfByte.saveExtInfoToExtStr("key_msg_ext_from_uin", String.valueOf(paramLong1));
    paramArrayOfByte.saveExtInfoToExtStr("key_msg_ext_to_uin", String.valueOf(paramLong2));
    paramArrayOfByte.saveExtInfoToExtStr("key_msg_ext_msg_seq", String.valueOf(paramInt1));
    paramArrayOfByte.saveExtInfoToExtStr("key_msg_ext_msg_type", String.valueOf(paramInt2));
    paramArrayOfByte.saveExtInfoToExtStr("key_msg_ext_msg_sub_type", String.valueOf(paramInt3));
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(paramArrayOfByte);
    paramQQAppInterface.a().a((ArrayList)localObject1, paramQQAppInterface.getCurrentAccountUin(), paramQQAppInterface.isBackground_Stop);
    localActivateFriendsManager.a(j);
    return true;
    label565:
    if (QLog.isColorLevel())
    {
      QLog.d("ActivateFriends", 2, "Geo friend list size = 0");
      break label849;
      label584:
      if (j == 2)
      {
        if (((SubMsgType0x76.MsgBody)localObject1).msg_birthday_notify.rpt_msg_one_friend.get().size() > 0)
        {
          localObject2 = (MessageForActivateFriends)paramArrayOfByte;
          ((MessageForActivateFriends)localObject2).msgBody = ((SubMsgType0x76.MsgBody)localObject1);
          ((MessageForActivateFriends)localObject2).msgData = ((SubMsgType0x76.MsgBody)localObject1).toByteArray();
          ((MessageForActivateFriends)localObject2).msg = ActivateFriendsManager.a(paramQQAppInterface.getApp(), (SubMsgType0x76.MsgBody)localObject1);
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break label854;
          }
          QLog.d("ActivateFriends", 2, "Birth friend list size = 0");
          break label854;
        }
      }
      else
      {
        if (j != 3) {
          break label864;
        }
        localObject2 = ((SubMsgType0x76.MsgBody)localObject1).msg_memorialday_notify.rpt_anniversary_info.get();
        if (((List)localObject2).size() > 0)
        {
          localObject2 = (SubMsgType0x76.OneMemorialDayInfo)((List)localObject2).get(0);
          MessageForActivateFriends localMessageForActivateFriends = (MessageForActivateFriends)paramArrayOfByte;
          localMessageForActivateFriends.msgBody = ((SubMsgType0x76.MsgBody)localObject1);
          localMessageForActivateFriends.msgData = ((SubMsgType0x76.MsgBody)localObject1).toByteArray();
          localMessageForActivateFriends.msg = ActivateFriendsManager.a(paramQQAppInterface.getApp(), (SubMsgType0x76.MsgBody)localObject1);
          ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8007AD4", "0X8007AD4", (int)((SubMsgType0x76.OneMemorialDayInfo)localObject2).uint32_type.get(), 0, "", "", "", "");
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break label859;
          }
          QLog.d("ActivateFriends", 2, "Memorial friend list size = 0");
          break label859;
        }
      }
    }
    label812:
    label849:
    label854:
    label859:
    label864:
    label869:
    label875:
    for (;;)
    {
      localObject2 = "0X8004E04";
      break;
      if ((j == 1) || (j == 2)) {
        if (j != 1) {
          break label869;
        }
      }
      for (localObject1 = "0X8004E03";; localObject1 = "0X8004E04")
      {
        if (j != 1) {
          break label875;
        }
        localObject2 = "0X8004E03";
        break;
        paramArrayOfByte = null;
        break label812;
        paramArrayOfByte = null;
        break label812;
        paramArrayOfByte = null;
        break label812;
        paramArrayOfByte = null;
        break label812;
        break label405;
      }
    }
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 1;
    case 1000: 
      return 3;
    case 10004: 
      return 25;
    case 1005: 
      return 6;
    case 1008: 
      return 8;
    case 1006: 
      return 10;
    case 1004: 
      return 5;
    case 1009: 
      return 11;
    case 3000: 
      return 4;
    case 1: 
      return 2;
    case 1001: 
      return 12;
    case 10002: 
      return 23;
    case 1033: 
      return 26;
    case 1034: 
      return 27;
    case 1020: 
      return 14;
    case 1021: 
      return 16;
    case 1022: 
      return 17;
    case 1023: 
      return 18;
    case 1024: 
    case 1025: 
      return 15;
    case 1010: 
      return 19;
    case 7400: 
      return 22;
    case 1026: 
      return 21;
    }
    return 24;
  }
  
  public static int b(msg_comm.Msg paramMsg)
  {
    int j;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      j = 0;
    }
    for (;;)
    {
      return j;
      Object localObject = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramMsg = (im_msg_body.Elem)((Iterator)localObject).next();
      } while ((!paramMsg.general_flags.has()) || (!((im_msg_body.GeneralFlags)paramMsg.general_flags.get()).bytes_pb_reserve.has()));
      localObject = new generalflags.ResvAttr();
      try
      {
        ((generalflags.ResvAttr)localObject).mergeFrom(paramMsg.general_flags.bytes_pb_reserve.get().toByteArray());
        if (!((generalflags.ResvAttr)localObject).uint32_req_font_effect_id.has()) {
          break label205;
        }
        i = ((generalflags.ResvAttr)localObject).uint32_req_font_effect_id.get();
        j = i;
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_FontEffectID->" + i);
            return i;
          }
        }
        catch (InvalidProtocolBufferMicroException paramMsg) {}
      }
      catch (InvalidProtocolBufferMicroException paramMsg)
      {
        for (;;)
        {
          int i = 0;
        }
      }
    }
    paramMsg.printStackTrace();
    return i;
    label205:
    return 0;
  }
  
  public static im_msg_body.RichText b(ChatMessage paramChatMessage)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramChatMessage == null) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      return localObject1;
      localObject1 = localObject2;
      if (!(paramChatMessage instanceof MessageForArkApp)) {
        continue;
      }
      paramChatMessage = (MessageForArkApp)paramChatMessage;
      localObject1 = localObject2;
      if (paramChatMessage == null) {
        continue;
      }
      localObject1 = localObject2;
      if (paramChatMessage.ark_app_message == null) {
        continue;
      }
      Object localObject3 = paramChatMessage.ark_app_message.toPbData();
      localObject1 = localObject2;
      if (localObject3 == null) {
        continue;
      }
      localObject1 = localObject2;
      if (localObject3.length == 0) {
        continue;
      }
      byte[] arrayOfByte = StructMsgUtils.b((byte[])localObject3);
      localObject1 = localObject2;
      if (arrayOfByte == null) {
        continue;
      }
      localObject1 = localObject2;
      if (arrayOfByte.length == 0) {
        continue;
      }
      localObject3 = new ByteArrayOutputStream();
      try
      {
        ((ByteArrayOutputStream)localObject3).write(1);
        ((ByteArrayOutputStream)localObject3).write(arrayOfByte);
        if (!TextUtils.isEmpty(paramChatMessage.resIDForLongMsg))
        {
          localObject1 = new im_msg_body.RichText();
          localObject2 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject2).general_flags.long_text_flag.set(1);
          ((im_msg_body.Elem)localObject2).general_flags.long_text_resid.set(ByteStringMicro.copyFromUtf8(paramChatMessage.resIDForLongMsg));
          ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject2);
          return localObject1;
        }
        if (paramChatMessage.ark_app_message.containStructMsg != null)
        {
          paramChatMessage = a((MessageForStructing)paramChatMessage.ark_app_message.containStructMsg);
          localObject1 = new im_msg_body.LightAppElem();
          ((im_msg_body.LightAppElem)localObject1).bytes_data.set(ByteStringMicro.copyFrom(((ByteArrayOutputStream)localObject3).toByteArray()));
          localObject2 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject2).light_app.set((MessageMicro)localObject1);
          localObject1 = paramChatMessage;
          if (paramChatMessage == null) {
            continue;
          }
          paramChatMessage.elems.add((MessageMicro)localObject2);
          return paramChatMessage;
        }
        localObject2 = new im_msg_body.RichText();
        if (paramChatMessage.ark_app_message.compatibleText != null) {
          localObject1 = paramChatMessage.ark_app_message.compatibleText;
        }
        for (;;)
        {
          paramChatMessage = (ChatMessage)localObject2;
          if (localObject1 == null) {
            break;
          }
          paramChatMessage = (ChatMessage)localObject2;
          if (((String)localObject1).length() <= 0) {
            break;
          }
          paramChatMessage = new im_msg_body.Text();
          paramChatMessage.str.set(ByteStringMicro.copyFromUtf8((String)localObject1));
          localObject1 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject1).text.set(paramChatMessage);
          ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
          paramChatMessage = (ChatMessage)localObject2;
          break;
          paramChatMessage = paramChatMessage.getSummery();
          if ((paramChatMessage == null) || (paramChatMessage.length() == 0)) {
            localObject1 = BaseApplication.getContext().getString(2131436165);
          } else {
            localObject1 = String.format(BaseApplication.getContext().getString(2131436166), new Object[] { paramChatMessage });
          }
        }
        return null;
      }
      catch (Exception paramChatMessage) {}
    }
  }
  
  public static im_msg_body.RichText b(MessageForApollo paramMessageForApollo)
  {
    Object localObject1 = new im_msg_body.ApolloActMsg();
    Object localObject3 = paramMessageForApollo.mApolloMessage;
    ((im_msg_body.ApolloActMsg)localObject1).uint32_action_id.set(((ApolloMessage)localObject3).id);
    ((im_msg_body.ApolloActMsg)localObject1).uint32_flag.set(((ApolloMessage)localObject3).flag);
    ((im_msg_body.ApolloActMsg)localObject1).uint32_peer_uin.set(Utils.a(((ApolloMessage)localObject3).peer_uin));
    ((im_msg_body.ApolloActMsg)localObject1).uint32_sender_ts.set(Utils.a(((ApolloMessage)localObject3).sender_ts));
    ((im_msg_body.ApolloActMsg)localObject1).uint32_peer_ts.set(Utils.a(((ApolloMessage)localObject3).peer_ts));
    ((im_msg_body.ApolloActMsg)localObject1).int32_sender_status.set(((ApolloMessage)localObject3).sender_status);
    ((im_msg_body.ApolloActMsg)localObject1).int32_peer_status.set(((ApolloMessage)localObject3).peer_status);
    Object localObject2 = new ApolloMsgExtend.AuthReserve();
    ((ApolloMsgExtend.AuthReserve)localObject2).diy_voice_id.set(paramMessageForApollo.audioId);
    ((ApolloMsgExtend.AuthReserve)localObject2).diy_voice_begin_ts.set((paramMessageForApollo.audioStartTime * 1000.0F));
    ((ApolloMsgExtend.AuthReserve)localObject2).game_id.set(paramMessageForApollo.gameId);
    ((ApolloMsgExtend.AuthReserve)localObject2).sub_type.set(paramMessageForApollo.msgType);
    ((ApolloMsgExtend.AuthReserve)localObject2).room_id.set(paramMessageForApollo.roomId);
    if (!TextUtils.isEmpty(paramMessageForApollo.gameName)) {
      ((ApolloMsgExtend.AuthReserve)localObject2).game_name.set(ByteStringMicro.copyFrom(paramMessageForApollo.gameName.getBytes()));
    }
    if (!TextUtils.isEmpty(paramMessageForApollo.gameExtendJson)) {
      ((ApolloMsgExtend.AuthReserve)localObject2).game_share_ark_json.set(ByteStringMicro.copyFrom(paramMessageForApollo.gameExtendJson.getBytes()));
    }
    ((ApolloMsgExtend.AuthReserve)localObject2).action_type.set(paramMessageForApollo.actionType);
    if (!TextUtils.isEmpty(paramMessageForApollo.extendJson)) {
      ((ApolloMsgExtend.AuthReserve)localObject2).extend_json.set(ByteStringMicro.copyFrom(paramMessageForApollo.extendJson.getBytes()));
    }
    localObject2 = ((ApolloMsgExtend.AuthReserve)localObject2).toByteArray();
    if ((localObject2 != null) && (localObject2.length > 0)) {
      ((im_msg_body.ApolloActMsg)localObject1).bytes_pb_reserve.set(ByteStringMicro.copyFrom((byte[])localObject2));
    }
    if (((ApolloMessage)localObject3).name != null) {
      ((im_msg_body.ApolloActMsg)localObject1).bytes_action_name.set(ByteStringMicro.copyFrom(((ApolloMessage)localObject3).name));
    }
    if (((ApolloMessage)localObject3).text != null) {
      ((im_msg_body.ApolloActMsg)localObject1).bytes_action_text.set(ByteStringMicro.copyFrom(((ApolloMessage)localObject3).text));
    }
    if (!TextUtils.isEmpty(paramMessageForApollo.inputText)) {
      ((im_msg_body.ApolloActMsg)localObject1).input_text.set(ByteStringMicro.copyFrom(paramMessageForApollo.inputText.getBytes()));
    }
    localObject2 = new im_msg_body.Text();
    paramMessageForApollo = "[动作消息]";
    if (((ApolloMessage)localObject3).name != null) {
      paramMessageForApollo = "[动作消息]" + new String(((ApolloMessage)localObject3).name);
    }
    ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFromUtf8(paramMessageForApollo));
    paramMessageForApollo = new im_msg_body.RichText();
    localObject3 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject3).apollo_msg.set((MessageMicro)localObject1);
    paramMessageForApollo.elems.add((MessageMicro)localObject3);
    localObject1 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject2);
    paramMessageForApollo.elems.add((MessageMicro)localObject1);
    return paramMessageForApollo;
  }
  
  public static void b(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_QCall return null:hasBody:" + paramMsg.msg_body.has() + ",hasMsgContent" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has());
      }
    }
    do
    {
      for (;;)
      {
        return;
        long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
        long l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
        long l4 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
        long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
        ((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get();
        Object localObject1 = l4 + "-" + l3;
        if (QLog.isColorLevel()) {
          QLog.d("decodeC2CMsgPkg_QCall", 2, "<---decodeC2CMsgPkg_QCall :  key:" + (String)localObject1);
        }
        if (paramMessageHandler.b.a().a(l2, (String)localObject1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("decodeC2CMsgPkg_QCall", 2, "msg has been pulled");
          }
        }
        else
        {
          l3 = MessageCache.a();
          l4 = Long.valueOf(paramMessageHandler.b.getCurrentAccountUin()).longValue();
          paramMsg = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
          localObject1 = new byte[4];
          Object localObject2 = new byte[4];
          System.arraycopy(paramMsg, 0, localObject1, 0, 4);
          System.arraycopy(paramMsg, 4, localObject2, 0, 4);
          int i = VideoPackageUtils.a((byte[])localObject1, 4);
          int j = VideoPackageUtils.a((byte[])localObject2, 4);
          if ((i <= 0) || (j <= 0))
          {
            if (QLog.isColorLevel()) {
              QLog.d("decodeC2CMsgPkg_QCall", 2, "invalid head length:" + i + " or body length:" + j);
            }
          }
          else
          {
            localObject1 = null;
            try
            {
              localObject2 = new head.Head();
              byte[] arrayOfByte = new byte[i];
              System.arraycopy(paramMsg, 8, arrayOfByte, 0, i);
              ((head.Head)localObject2).mergeFrom(arrayOfByte);
              int k = ((head.Head)localObject2).msg_msg_head.msg_content_head.uint32_type.get();
              int m = ((head.Head)localObject2).msg_msg_head.msg_content_head.uint32_subtype.get();
              if ((k == 562) && (m == 17))
              {
                localObject2 = new im_msg_body.MsgBody();
                arrayOfByte = new byte[j];
                System.arraycopy(paramMsg, i + 8, arrayOfByte, 0, j);
                ((im_msg_body.MsgBody)localObject2).mergeFrom(arrayOfByte);
                paramMsg = ((im_msg_body.MsgBody)localObject2).msg_content.get().toByteArray();
                if (paramMsg == null)
                {
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("decodeC2CMsgPkg_QCall", 2, "msg sharp content null, return;");
                }
              }
              else
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("decodeC2CMsgPkg_QCall", 2, "error msgType:" + k + ", or subType:" + m);
                return;
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                paramMsg = (msg_comm.Msg)localObject1;
                if (QLog.isColorLevel())
                {
                  QLog.d("decodeC2CMsgPkg_QCall", 2, "error when process qcall offline msg", localException);
                  paramMsg = (msg_comm.Msg)localObject1;
                }
              }
              boolean bool = AbstractNetChannel.a(paramMsg);
              if (((!paramDecodeProtoPkgContext.jdField_a_of_type_Boolean) && (!paramDecodeProtoPkgContext.f)) || ((paramDecodeProtoPkgContext.jdField_a_of_type_Long != paramDecodeProtoPkgContext.jdField_b_of_type_Long) || ((paramDecodeProtoPkgContext.jdField_a_of_type_Long == paramDecodeProtoPkgContext.jdField_b_of_type_Long) && (!bool))))
              {
                if (QLog.isColorLevel()) {
                  QLog.e("decodeC2CMsgPkg_QCall", 2, "<---decodeC2CMsgPkg_QCall return null:,isReaded:" + paramDecodeProtoPkgContext.jdField_a_of_type_Boolean + "syncOther:" + paramDecodeProtoPkgContext.f + ",isSharpRequest" + bool);
                }
              }
              else
              {
                paramDecodeProtoPkgContext = CharacterUtil.a(l2);
                localObject1 = CharacterUtil.a(l4);
                try
                {
                  new QavWrapper(BaseApplicationImpl.getContext()).a(new ahxq(paramMsg, l3 - l1, (String)localObject1, paramDecodeProtoPkgContext, paramMessageHandler, l4, l2, l1, bool));
                  return;
                }
                catch (Exception paramMessageHandler) {}
              }
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("decodeC2CMsgPkg_QCall", 2, "exception when process qcall offline msg", paramMessageHandler);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, submsgtype0xb1.InviteInfo paramInviteInfo, boolean paramBoolean)
  {
    submsgtype0xb1.InviteInfo localInviteInfo;
    long l1;
    if (paramInviteInfo.has())
    {
      localInviteInfo = (submsgtype0xb1.InviteInfo)paramInviteInfo.get();
      l1 = System.currentTimeMillis() / 1000L;
      if (l1 - localInviteInfo.uint32_expire_time.get() <= 900L) {
        break label110;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler.troopgroup_vedio.invite", 2, "邀请过期了=》troopUin:" + localInviteInfo.uint64_group_code.get() + "|uint32_expire_time:" + localInviteInfo.uint32_expire_time.get() + ", currentTime:" + l1);
      }
    }
    label110:
    Object localObject;
    do
    {
      do
      {
        long l2;
        do
        {
          return;
          if ((paramBoolean) || (!a.containsKey(localInviteInfo.str_id.get()))) {
            break;
          }
          l2 = ((Long)a.get(localInviteInfo.str_id.get())).longValue();
          if (l1 - l2 >= 10L) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("Q.msg.MessageHandler.troopgroup_vedio.invite", 2, "离线-上线的时候收到邀请的前10s内先收到了取消的邀请=》troopUin:" + localInviteInfo.uint64_group_code.get() + "|receiveUnInviteTime:" + l2 + ", currentTime:" + l1);
        return;
        paramBoolean = paramQQAppInterface.a().c(localInviteInfo.uint64_group_code.get());
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandler.troopgroup_vedio.invite", 2, "msgBody.invite_info.has()==》troopUin:" + localInviteInfo.uint64_group_code.get() + "|uint32_expire_time:" + localInviteInfo.uint32_expire_time.get() + ", currentTime:" + l1 + ", hasGroupVideo:" + paramBoolean);
        }
        localObject = (TroopManager)paramQQAppInterface.getManager(51);
      } while ((!paramBoolean) || (((TroopManager)localObject).d(localInviteInfo.uint64_group_code.get() + "", localInviteInfo.uint64_uin.get() + "")));
      paramBoolean = false;
      if (paramQQAppInterface.a().b() > 0L) {
        paramBoolean = true;
      }
      if (((TroopManager)localObject).b() != 2) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MessageHandler.troopgroup_vedio.invite", 2, "只允许同时存在两个邀请框");
    return;
    if (((TroopManager)localObject).b() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler.troopgroup_vedio.invite", 2, "hasGroupInviting");
      }
      paramInviteInfo = new Intent(paramQQAppInterface.getApp().getApplicationContext(), MultiIncomingCallsActivity.class);
      paramInviteInfo.putExtra("uinType", 1);
      paramInviteInfo.putExtra("peerUin", String.valueOf(localInviteInfo.uint64_uin.get()));
    }
    for (;;)
    {
      ((TroopManager)localObject).c(String.valueOf(localInviteInfo.uint64_group_code.get()), String.valueOf(localInviteInfo.uint64_uin.get()));
      if (((KeyguardManager)paramQQAppInterface.getApp().getApplicationContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode())
      {
        localObject = new Intent();
        ((Intent)localObject).setAction("tencent.video.v2q.ReceiveRequest");
        ((Intent)localObject).putExtra("revVideoRequest", true);
        ((Intent)localObject).setPackage(paramQQAppInterface.getApp().getPackageName());
        paramQQAppInterface.getApp().sendBroadcast((Intent)localObject);
      }
      paramInviteInfo.addFlags(268435456);
      paramInviteInfo.putExtra("relationType", 1);
      paramInviteInfo.putExtra("discussId", localInviteInfo.uint64_group_code.get());
      paramInviteInfo.putExtra("friendUin", localInviteInfo.uint64_uin.get());
      paramInviteInfo.putExtra("inviteId", localInviteInfo.str_id.get());
      paramInviteInfo.putExtra("hasGVideoJoined", paramBoolean);
      paramInviteInfo.putExtra("memberType", TroopMemberUtil.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), localInviteInfo.uint64_group_code.get() + ""));
      paramQQAppInterface.getApp().startActivity(paramInviteInfo);
      return;
      paramInviteInfo = new Intent(paramQQAppInterface.getApp().getApplicationContext(), GaInviteDialogActivity.class);
    }
  }
  
  public static int c(msg_comm.Msg paramMsg)
  {
    int j;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      j = 0;
    }
    for (;;)
    {
      return j;
      Object localObject = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramMsg = (im_msg_body.Elem)((Iterator)localObject).next();
      } while ((!paramMsg.general_flags.has()) || (!((im_msg_body.GeneralFlags)paramMsg.general_flags.get()).bytes_pb_reserve.has()));
      localObject = new generalflags.ResvAttr();
      try
      {
        ((generalflags.ResvAttr)localObject).mergeFrom(paramMsg.general_flags.bytes_pb_reserve.get().toByteArray());
        if (!((generalflags.ResvAttr)localObject).uint32_pendant_diy_id.has()) {
          break label205;
        }
        i = ((generalflags.ResvAttr)localObject).uint32_pendant_diy_id.get();
        j = i;
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_PendantDiyID->" + i);
            return i;
          }
        }
        catch (InvalidProtocolBufferMicroException paramMsg) {}
      }
      catch (InvalidProtocolBufferMicroException paramMsg)
      {
        for (;;)
        {
          int i = 0;
        }
      }
    }
    paramMsg.printStackTrace();
    return i;
    label205:
    return 0;
  }
  
  public static im_msg_body.RichText c(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null)
    {
      paramChatMessage = null;
      return paramChatMessage;
    }
    if (!(paramChatMessage instanceof MessageForArkApp)) {
      return null;
    }
    Object localObject1 = (MessageForArkApp)paramChatMessage;
    if ((localObject1 == null) || (((MessageForArkApp)localObject1).ark_app_message == null)) {
      return null;
    }
    Object localObject2 = ((MessageForArkApp)localObject1).ark_app_message.toPbData();
    if ((localObject2 == null) || (localObject2.length == 0)) {
      return null;
    }
    localObject2 = StructMsgUtils.b((byte[])localObject2);
    if ((localObject2 == null) || (localObject2.length == 0)) {
      return null;
    }
    Object localObject3 = new ByteArrayOutputStream();
    try
    {
      ((ByteArrayOutputStream)localObject3).write(1);
      ((ByteArrayOutputStream)localObject3).write((byte[])localObject2);
      if (!TextUtils.isEmpty(((MessageForArkApp)localObject1).resIDForLongMsg))
      {
        paramChatMessage = new im_msg_body.RichText();
        localObject2 = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject2).general_flags.long_text_flag.set(1);
        ((im_msg_body.Elem)localObject2).general_flags.long_text_resid.set(ByteStringMicro.copyFromUtf8(((MessageForArkApp)localObject1).resIDForLongMsg));
        paramChatMessage.elems.add((MessageMicro)localObject2);
        return paramChatMessage;
      }
    }
    catch (Exception paramChatMessage)
    {
      return null;
    }
    Object localObject4;
    if (((MessageForArkApp)localObject1).ark_app_message.containStructMsg != null)
    {
      localObject1 = a((MessageForStructing)((MessageForArkApp)localObject1).ark_app_message.containStructMsg);
      localObject4 = new hummer_commelem.MsgElemInfo_servtype20();
      ((hummer_commelem.MsgElemInfo_servtype20)localObject4).bytes_data.set(ByteStringMicro.copyFrom(((ByteArrayOutputStream)localObject3).toByteArray()));
      localObject2 = new im_msg_body.CommonElem();
      ((im_msg_body.CommonElem)localObject2).uint32_service_type.set(20);
      ((im_msg_body.CommonElem)localObject2).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype20)localObject4).toByteArray()));
      localObject3 = ((im_msg_body.CommonElem)localObject2).uint32_business_type;
      if (!"1".equals(paramChatMessage.getExtInfoFromExtStr(MessageConstants.e))) {
        break label445;
      }
    }
    label445:
    for (int i = 1;; i = 0)
    {
      ((PBUInt32Field)localObject3).set(i);
      localObject3 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject3).common_elem.set((MessageMicro)localObject2);
      paramChatMessage = (ChatMessage)localObject1;
      if (localObject1 == null) {
        break;
      }
      ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject3);
      return localObject1;
      localObject2 = new im_msg_body.RichText();
      if (((MessageForArkApp)localObject1).ark_app_message.compatibleText != null) {
        localObject1 = ((MessageForArkApp)localObject1).ark_app_message.compatibleText;
      }
      for (;;)
      {
        if ((localObject1 != null) && (((String)localObject1).length() > 0))
        {
          localObject4 = new im_msg_body.Text();
          ((im_msg_body.Text)localObject4).str.set(ByteStringMicro.copyFromUtf8((String)localObject1));
          localObject1 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject4);
          ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
        }
        localObject1 = localObject2;
        break;
        localObject1 = ((MessageForArkApp)localObject1).getSummery();
        if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
          localObject1 = BaseApplication.getContext().getString(2131436165);
        } else {
          localObject1 = String.format(BaseApplication.getContext().getString(2131436166), new Object[] { localObject1 });
        }
      }
    }
  }
  
  public static void c(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has()) || (paramDecodeProtoPkgContext.jdField_a_of_type_Boolean) || (paramDecodeProtoPkgContext.f)) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_Video return null:hasBody:" + paramMsg.msg_body.has() + ",hasMsgContent" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has() + ",isReaded:" + paramDecodeProtoPkgContext.jdField_a_of_type_Boolean + "syncOther:" + paramDecodeProtoPkgContext.f);
      }
    }
    long l1;
    long l2;
    long l3;
    Object localObject;
    label511:
    do
    {
      int i;
      HashMap localHashMap;
      do
      {
        do
        {
          long l4;
          do
          {
            do
            {
              return;
              l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
              l4 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
              long l5 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
              l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
              long l6 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get();
              l3 = Long.valueOf(paramMessageHandler.b.getCurrentAccountUin()).longValue();
              localObject = l2 + "-" + l6 + "-" + l5 + "-" + l4;
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MessageHandler", 2, "<---decodeC2CMsgPkg_Video :  key:" + (String)localObject);
              }
              localObject = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
              l4 = MessageCache.a() - l1;
              i = AbstractNetChannel.a((byte[])localObject);
              if ((VcSystemInfo.c()) && (VcSystemInfo.d())) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("svenxu", 2, "Discard video message cause device not support");
            return;
            if (l4 < 60L) {
              break;
            }
          } while ((i == 1) && (!QLog.isColorLevel()));
          QLog.d("svenxu", 2, "Discard video message because of time out " + l4 + " s");
          return;
          localHashMap = (HashMap)paramDecodeProtoPkgContext.a(1000);
          paramDecodeProtoPkgContext = (HashSet)paramDecodeProtoPkgContext.a(1001);
          if (i != 1) {
            break label511;
          }
          if (VcSystemInfo.c()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("shanezhaiSHARP", 2, "discard video push message because the sdk is lower");
        return;
      } while (localHashMap == null);
      localHashMap.put(Long.valueOf(l2), paramMsg);
      return;
      if (i != 3) {
        break;
      }
    } while (!VcSystemInfo.c());
    if (paramDecodeProtoPkgContext != null) {
      paramDecodeProtoPkgContext.add(Long.valueOf(l2));
    }
    paramMessageHandler.a(l3, (byte[])localObject, l2, (int)l1);
    return;
    paramMessageHandler.a(l3, (byte[])localObject, l2, (int)l1);
  }
  
  public static int d(msg_comm.Msg paramMsg)
  {
    int j;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      j = 0;
    }
    for (;;)
    {
      return j;
      Object localObject = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramMsg = (im_msg_body.Elem)((Iterator)localObject).next();
      } while ((!paramMsg.general_flags.has()) || (!((im_msg_body.GeneralFlags)paramMsg.general_flags.get()).bytes_pb_reserve.has()));
      localObject = new generalflags.ResvAttr();
      try
      {
        ((generalflags.ResvAttr)localObject).mergeFrom(paramMsg.general_flags.bytes_pb_reserve.get().toByteArray());
        if (!((generalflags.ResvAttr)localObject).uint32_face_id.has()) {
          break label210;
        }
        i = ((generalflags.ResvAttr)localObject).uint32_face_id.get();
        j = i;
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_FaceID->" + i);
            return i;
          }
        }
        catch (InvalidProtocolBufferMicroException paramMsg) {}
      }
      catch (InvalidProtocolBufferMicroException paramMsg)
      {
        for (;;)
        {
          int i = 0;
        }
      }
    }
    QLog.e("Q.msg.MessageHandler", 1, "", paramMsg);
    return i;
    label210:
    return 0;
  }
  
  public static im_msg_body.RichText d(ChatMessage paramChatMessage)
  {
    int i = 1;
    if (paramChatMessage == null) {
      return null;
    }
    if (!(paramChatMessage instanceof MessageForArkBabyqReply)) {
      return null;
    }
    Object localObject1 = (MessageForArkBabyqReply)paramChatMessage;
    paramChatMessage = ((MessageForArkBabyqReply)localObject1).toPbData();
    if ((paramChatMessage == null) || (paramChatMessage.length == 0)) {
      return null;
    }
    paramChatMessage = StructMsgUtils.b(paramChatMessage);
    if ((paramChatMessage == null) || (paramChatMessage.length == 0)) {
      return null;
    }
    Object localObject2 = new ByteArrayOutputStream();
    try
    {
      ((ByteArrayOutputStream)localObject2).write(1);
      ((ByteArrayOutputStream)localObject2).write(paramChatMessage);
      paramChatMessage = new im_msg_body.RichText();
      if (!TextUtils.isEmpty(((MessageForArkBabyqReply)localObject1).resIDForLongMsg))
      {
        localObject2 = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject2).general_flags.long_text_flag.set(1);
        ((im_msg_body.Elem)localObject2).general_flags.long_text_resid.set(ByteStringMicro.copyFromUtf8(((MessageForArkBabyqReply)localObject1).resIDForLongMsg));
        paramChatMessage.elems.add((MessageMicro)localObject2);
        return paramChatMessage;
      }
    }
    catch (Exception paramChatMessage)
    {
      return null;
    }
    Object localObject3 = new hummer_commelem.MsgElemInfo_servtype19();
    ((hummer_commelem.MsgElemInfo_servtype19)localObject3).bytes_data.set(ByteStringMicro.copyFrom(((ByteArrayOutputStream)localObject2).toByteArray()));
    localObject2 = new im_msg_body.CommonElem();
    ((im_msg_body.CommonElem)localObject2).uint32_service_type.set(19);
    ((im_msg_body.CommonElem)localObject2).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype19)localObject3).toByteArray()));
    localObject3 = ((im_msg_body.CommonElem)localObject2).uint32_business_type;
    if (((MessageForArkBabyqReply)localObject1).showAsBabyq) {}
    for (;;)
    {
      ((PBUInt32Field)localObject3).set(i);
      localObject3 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject3).common_elem.set((MessageMicro)localObject2);
      paramChatMessage.elems.add((MessageMicro)localObject3);
      localObject2 = ((MessageForArkBabyqReply)localObject1).babyqReplyText;
      if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
        break;
      }
      localObject1 = new im_msg_body.Text();
      ((im_msg_body.Text)localObject1).str.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localObject2 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject2).text.set((MessageMicro)localObject1);
      paramChatMessage.elems.add((MessageMicro)localObject2);
      break;
      i = 2;
    }
  }
  
  public static int e(msg_comm.Msg paramMsg)
  {
    int j;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      j = 0;
    }
    for (;;)
    {
      return j;
      Object localObject = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramMsg = (im_msg_body.Elem)((Iterator)localObject).next();
      } while ((!paramMsg.general_flags.has()) || (!((im_msg_body.GeneralFlags)paramMsg.general_flags.get()).bytes_pb_reserve.has()));
      localObject = new generalflags.ResvAttr();
      try
      {
        ((generalflags.ResvAttr)localObject).mergeFrom(paramMsg.general_flags.bytes_pb_reserve.get().toByteArray());
        if (!((generalflags.ResvAttr)localObject).uint32_love_language_flag.has()) {
          break label210;
        }
        i = ((generalflags.ResvAttr)localObject).uint32_love_language_flag.get();
        j = i;
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("Q.msg.MessageHandler", 2, "Love Language decodeC2CMsgPkg_loveLanguageFlag->" + i);
            return i;
          }
        }
        catch (InvalidProtocolBufferMicroException paramMsg) {}
      }
      catch (InvalidProtocolBufferMicroException paramMsg)
      {
        for (;;)
        {
          int i = 0;
        }
      }
    }
    QLog.e("Q.msg.MessageHandler", 1, "", paramMsg);
    return i;
    label210:
    return 0;
  }
  
  public static im_msg_body.RichText e(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    Object localObject2;
    do
    {
      do
      {
        do
        {
          do
          {
            return null;
          } while (!(paramChatMessage instanceof MessageForArkFlashChat));
          paramChatMessage = (MessageForArkFlashChat)paramChatMessage;
        } while ((paramChatMessage == null) || (paramChatMessage.ark_app_message == null));
        localObject1 = paramChatMessage.ark_app_message.toPbData();
      } while ((localObject1 == null) || (localObject1.length == 0));
      localObject2 = StructMsgUtils.b((byte[])localObject1);
    } while ((localObject2 == null) || (localObject2.length == 0));
    Object localObject1 = new ByteArrayOutputStream();
    try
    {
      ((ByteArrayOutputStream)localObject1).write(1);
      ((ByteArrayOutputStream)localObject1).write((byte[])localObject2);
      localObject2 = new hummer_commelem.MsgElemInfo_servtype14();
      ((hummer_commelem.MsgElemInfo_servtype14)localObject2).reserve_Info.set(ByteStringMicro.copyFrom(((ByteArrayOutputStream)localObject1).toByteArray()));
      ((hummer_commelem.MsgElemInfo_servtype14)localObject2).uint32_id.set(paramChatMessage.ark_app_message.appResId);
      localObject1 = new im_msg_body.CommonElem();
      ((im_msg_body.CommonElem)localObject1).uint32_business_type.set(0);
      ((im_msg_body.CommonElem)localObject1).uint32_service_type.set(14);
      ((im_msg_body.CommonElem)localObject1).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype14)localObject2).toByteArray()));
      localObject2 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject2).common_elem.set((MessageMicro)localObject1);
      paramChatMessage = a(MessageUtils.a(paramChatMessage.getSummery(), true, null), null);
      paramChatMessage.elems.add((MessageMicro)localObject2);
      return paramChatMessage;
    }
    catch (Exception paramChatMessage) {}
    return null;
  }
  
  public static int f(msg_comm.Msg paramMsg)
  {
    int i;
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
      im_msg_body.Elem localElem;
      do
      {
        if (!paramMsg.hasNext()) {
          break;
        }
        localElem = (im_msg_body.Elem)paramMsg.next();
      } while ((!localElem.general_flags.has()) || (!((im_msg_body.GeneralFlags)localElem.general_flags.get()).uint32_bubble_sub_id.has()));
      j = ((im_msg_body.GeneralFlags)localElem.general_flags.get()).uint32_bubble_sub_id.get();
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MessageHandler", 2, "decodeC2CMsgPkg_SubBubbleID->" + j);
    return j;
    return 0;
  }
  
  public static im_msg_body.RichText f(ChatMessage paramChatMessage)
  {
    Object localObject1 = null;
    if (!(paramChatMessage instanceof MessageForHiBoom)) {
      paramChatMessage = (ChatMessage)localObject1;
    }
    do
    {
      do
      {
        return paramChatMessage;
        localObject2 = (MessageForHiBoom)paramChatMessage;
        paramChatMessage = (ChatMessage)localObject1;
      } while (((MessageForHiBoom)localObject2).mHiBoomMessage == null);
      localObject1 = new hummer_commelem.MsgElemInfo_servtype14();
      ((hummer_commelem.MsgElemInfo_servtype14)localObject1).uint32_id.set(((MessageForHiBoom)localObject2).mHiBoomMessage.id);
      paramChatMessage = new im_msg_body.CommonElem();
      paramChatMessage.uint32_business_type.set(1);
      paramChatMessage.uint32_service_type.set(14);
      paramChatMessage.bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype14)localObject1).toByteArray()));
      im_msg_body.Elem localElem = new im_msg_body.Elem();
      localElem.common_elem.set(paramChatMessage);
      localObject1 = new im_msg_body.RichText();
      ((im_msg_body.RichText)localObject1).elems.add(localElem);
      localObject2 = ((MessageForHiBoom)localObject2).mHiBoomMessage.text;
      paramChatMessage = (ChatMessage)localObject1;
    } while (TextUtils.isEmpty((CharSequence)localObject2));
    paramChatMessage = new im_msg_body.Text();
    paramChatMessage.str.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    Object localObject2 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject2).text.set(paramChatMessage);
    ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject2);
    return localObject1;
  }
  
  public static int g(msg_comm.Msg paramMsg)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
      return 0;
    }
    paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
    while (paramMsg.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)paramMsg.next();
      if ((localElem.elem_flags2.has()) && (((im_msg_body.ElemFlags2)localElem.elem_flags2.get()).uint32_vip_status.has()))
      {
        int i = ((im_msg_body.ElemFlags2)localElem.elem_flags2.get()).uint32_vip_status.get();
        if (i == 1) {
          return 1;
        }
        if (i == 2) {
          return 2;
        }
      }
    }
    return 0;
  }
  
  public static im_msg_body.RichText g(ChatMessage paramChatMessage)
  {
    Object localObject1 = new im_msg_body.CommonElem();
    ((im_msg_body.CommonElem)localObject1).uint32_service_type.set(2);
    if ((paramChatMessage instanceof MessageForPoke))
    {
      localObject2 = new hummer_commelem.MsgElemInfo_servtype2();
      paramChatMessage = (MessageForPoke)paramChatMessage;
      int i = paramChatMessage.interactType;
      int j = paramChatMessage.doubleHitState;
      int k = paramChatMessage.strength;
      ((hummer_commelem.MsgElemInfo_servtype2)localObject2).uint32_poke_type.set(i);
      ((hummer_commelem.MsgElemInfo_servtype2)localObject2).uint32_double_hit.set(j);
      ((hummer_commelem.MsgElemInfo_servtype2)localObject2).uint32_vaspoke_id.set(paramChatMessage.subId);
      ((hummer_commelem.MsgElemInfo_servtype2)localObject2).bytes_vaspoke_name.set(ByteStringMicro.copyFromUtf8(paramChatMessage.name));
      ((hummer_commelem.MsgElemInfo_servtype2)localObject2).bytes_vaspoke_minver.set(ByteStringMicro.copyFromUtf8(paramChatMessage.minVersion));
      ((hummer_commelem.MsgElemInfo_servtype2)localObject2).uint32_poke_strength.set(k);
      ((im_msg_body.CommonElem)localObject1).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype2)localObject2).toByteArray()));
      ((im_msg_body.CommonElem)localObject1).uint32_business_type.set(i);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "getSendPokeMsgBody type:" + i + " ,doubleHitState:" + j);
      }
    }
    paramChatMessage = new im_msg_body.Elem();
    paramChatMessage.common_elem.set((MessageMicro)localObject1);
    Object localObject2 = new im_msg_body.Text();
    ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFromUtf8("[戳一戳]请使用最新版手机QQ体验新功能。"));
    localObject1 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject2);
    localObject2 = new im_msg_body.RichText();
    ((im_msg_body.RichText)localObject2).elems.add(paramChatMessage);
    ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("PokeMsg", 2, "getSendPokeMsgBody");
    }
    return localObject2;
  }
  
  public static im_msg_body.RichText h(ChatMessage paramChatMessage)
  {
    Object localObject3 = new im_msg_body.CommonElem();
    ((im_msg_body.CommonElem)localObject3).uint32_service_type.set(23);
    Object localObject2 = "表情泡泡";
    Object localObject1 = "";
    hummer_commelem.MsgElemInfo_servtype23 localMsgElemInfo_servtype23;
    int i;
    int j;
    PBBytesField localPBBytesField;
    if ((paramChatMessage instanceof MessageForPokeEmo))
    {
      localMsgElemInfo_servtype23 = new hummer_commelem.MsgElemInfo_servtype23();
      paramChatMessage = (MessageForPokeEmo)paramChatMessage;
      i = paramChatMessage.pokeemoId;
      j = paramChatMessage.pokeemoPressCount;
      paramChatMessage = paramChatMessage.summary;
      localObject2 = String.format("[%s]x%d", new Object[] { paramChatMessage, Integer.valueOf(j) });
      localMsgElemInfo_servtype23.uint32_face_type.set(i);
      localMsgElemInfo_servtype23.uint32_face_bubble_count.set(j);
      localPBBytesField = localMsgElemInfo_servtype23.bytes_face_summary;
      if (paramChatMessage != null) {
        break label353;
      }
    }
    label353:
    for (localObject1 = "";; localObject1 = paramChatMessage)
    {
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject1));
      ((im_msg_body.CommonElem)localObject3).bytes_pb_elem.set(ByteStringMicro.copyFrom(localMsgElemInfo_servtype23.toByteArray()));
      ((im_msg_body.CommonElem)localObject3).uint32_business_type.set(i);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "getSendPokeEmoMsgBody pokeemoId:" + i + " ,pokeemoPressCount:" + j);
      }
      localObject1 = localObject2;
      localObject2 = paramChatMessage;
      paramChatMessage = new im_msg_body.Elem();
      paramChatMessage.common_elem.set((MessageMicro)localObject3);
      localObject3 = String.format("[%s]请使用最新版手机QQ体验新功能。", new Object[] { localObject2 });
      localObject2 = new im_msg_body.Text();
      ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFromUtf8((String)localObject1));
      localObject1 = new TextMsgExtPb.ResvAttr();
      ((TextMsgExtPb.ResvAttr)localObject1).wording.set(ByteStringMicro.copyFromUtf8((String)localObject3));
      ((im_msg_body.Text)localObject2).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((TextMsgExtPb.ResvAttr)localObject1).toByteArray()));
      localObject1 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject2);
      localObject2 = new im_msg_body.RichText();
      ((im_msg_body.RichText)localObject2).elems.add(paramChatMessage);
      ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("PokeMsg", 2, "getSendPokeMsgBody");
      }
      return localObject2;
    }
  }
  
  public static im_msg_body.RichText i(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForScribble)))
    {
      Object localObject1 = (MessageForScribble)paramChatMessage;
      Object localObject2 = new im_msg_body.CommonElem();
      ((im_msg_body.CommonElem)localObject2).uint32_service_type.set(11);
      paramChatMessage = new im_msg_body.Elem();
      hummer_commelem.MsgElemInfo_servtype11 localMsgElemInfo_servtype11 = new hummer_commelem.MsgElemInfo_servtype11();
      localMsgElemInfo_servtype11.bytes_Doodle_url.set(ByteStringMicro.copyFromUtf8(((MessageForScribble)localObject1).combineFileUrl));
      localMsgElemInfo_servtype11.bytes_Doodle_md5.set(ByteStringMicro.copyFromUtf8(((MessageForScribble)localObject1).combineFileMd5));
      localMsgElemInfo_servtype11.uint32_doodleData_offset.set(((MessageForScribble)localObject1).offSet);
      localMsgElemInfo_servtype11.uint32_doodle_gif_id.set(((MessageForScribble)localObject1).gifId);
      ((im_msg_body.CommonElem)localObject2).uint32_business_type.set(1);
      ((im_msg_body.CommonElem)localObject2).bytes_pb_elem.set(ByteStringMicro.copyFrom(localMsgElemInfo_servtype11.toByteArray()));
      paramChatMessage.common_elem.set((MessageMicro)localObject2);
      localObject1 = new im_msg_body.Elem();
      localObject2 = new im_msg_body.Text();
      ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFromUtf8("[涂鸦]"));
      ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject2);
      ((im_msg_body.Elem)localObject1).text.setHasFlag(true);
      localObject2 = new im_msg_body.RichText();
      ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
      ((im_msg_body.RichText)localObject2).elems.add(paramChatMessage);
      if (QLog.isColorLevel()) {
        QLog.d("pap", 2, "getSendPapScribeMsgBody");
      }
      return localObject2;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageProtoCodec
 * JD-Core Version:    0.7.0.1
 */