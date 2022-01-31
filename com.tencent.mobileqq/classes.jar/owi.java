import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.apiproxy.QQMusicService;
import com.tencent.biz.huanjiplugin.HuanjiPluginInfo;
import com.tencent.biz.huanjiplugin.HuanjiPluginProxy;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager;
import com.tencent.biz.pubaccount.NativeAd.preload.NativeAdPreloadManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.plugin.ReadInJoySkinHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUploadManager;
import com.tencent.biz.pubaccount.util.PAH5Manager;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.Doraemon.DoraemonBridge;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity.SendVideoTaskV2;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.HotchatSCHelper;
import com.tencent.mobileqq.app.HotchatSCHelper.OnShowNoteListener;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.config.struct.LebaViewItem;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager;
import com.tencent.mobileqq.intervideo.huayang.HuayangDowanloadHelper;
import com.tencent.mobileqq.intervideo.huayang.HuayangOpenHelper;
import com.tencent.mobileqq.intervideo.now.NowProxy;
import com.tencent.mobileqq.intervideo.od.ODProxy;
import com.tencent.mobileqq.lightReply.LightReplyEmojs;
import com.tencent.mobileqq.lightReply.LightReplyMenuManager;
import com.tencent.mobileqq.nearby.FaceScoreUtils;
import com.tencent.mobileqq.nearby.NearbyConstants;
import com.tencent.mobileqq.nearby.NearbyVideoUtils;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.now.enter.widget.NowAnswerPreloadManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectManager;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.NearbyVideoChatManager;
import com.tencent.mobileqq.troop.utils.TroopAppMgr;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.TroopRewardMgr;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import cooperation.troop.TroopPluginManager;
import cooperation.troop_homework.model.HWTroopFileStatusInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class owi
  extends Handler
{
  public owi(TroopMemberApiService paramTroopMemberApiService) {}
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject4 = TroopMemberApiService.c(this.a);
    if ((localObject4 instanceof QQAppInterface))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler = ((BizTroopHandler)((QQAppInterface)localObject4).a(22));
      this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler = ((LBSHandler)((QQAppInterface)localObject4).a(3));
      this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)((QQAppInterface)localObject4).a(20));
    }
    if ((paramMessage == null) || (localObject4 == null) || (!(localObject4 instanceof QQAppInterface))) {}
    Object localObject3;
    do
    {
      return;
      localObject3 = paramMessage.getData();
    } while (localObject3 == null);
    label608:
    Object localObject1;
    Object localObject5;
    int i;
    int j;
    long l1;
    Object localObject6;
    boolean bool;
    long l2;
    int k;
    Object localObject7;
    switch (paramMessage.what)
    {
    case 3: 
    case 4: 
    case 5: 
    case 10: 
    case 14: 
    case 23: 
    case 24: 
    case 25: 
    case 26: 
    case 33: 
    case 40: 
    case 43: 
    case 48: 
    case 49: 
    case 50: 
    case 57: 
    case 63: 
    case 64: 
    case 65: 
    case 66: 
    case 69: 
    case 84: 
    case 91: 
    case 115: 
    default: 
    case 1: 
    case 2: 
    case 6: 
    case 7: 
    case 8: 
    case 34: 
    case 41: 
    case 76: 
    case 74: 
    case 71: 
    case 38: 
    case 35: 
    case 36: 
    case 37: 
    case 9: 
    case 29: 
    case 11: 
    case 12: 
    case 39: 
    case 13: 
    case 28: 
    case 120: 
    case 61: 
    case 30: 
    case 108: 
    case 31: 
    case 82: 
    case 15: 
    case 16: 
    case 18: 
    case 17: 
      for (;;)
      {
        super.handleMessage(paramMessage);
        return;
        this.a.jdField_b_of_type_AndroidOsMessenger = paramMessage.replyTo;
        if (paramMessage.obj != null)
        {
          localObject1 = ((Bundle)paramMessage.obj).getString("processName");
          if (localObject1 != null)
          {
            this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject1, paramMessage.replyTo);
            continue;
            this.a.jdField_b_of_type_AndroidOsMessenger = null;
            if (paramMessage.obj != null)
            {
              localObject1 = ((Bundle)paramMessage.obj).getString("processName");
              if (localObject1 != null)
              {
                this.a.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject1);
                continue;
                this.a.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy = new QQMapActivityProxy(((AppRuntime)localObject4).getAccount());
                continue;
                localObject1 = ((Bundle)localObject3).getString("gcode");
                localObject3 = ((Bundle)localObject3).getString("anId");
                localObject5 = AnonymousChatHelper.a().a((String)localObject1, (String)localObject3);
                if ((!TextUtils.isEmpty((CharSequence)localObject5)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
                {
                  this.a.a((String)localObject1, (String)localObject3, ((AppRuntime)localObject4).getAccount(), (String)localObject5);
                  if (QLog.isDevelopLevel())
                  {
                    QLog.i("com.tencent.biz.troop.TroopMemberApiService", 4, "anonymous report.");
                    continue;
                    this.a.a().a((AppRuntime)localObject4, (Bundle)localObject3);
                    continue;
                    localObject1 = ((Bundle)localObject3).getString("troopUin");
                    if (this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler != null)
                    {
                      this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.b((String)localObject1);
                      continue;
                      localObject1 = ((Bundle)localObject3).getString("troopUin");
                      localObject3 = ((Bundle)localObject3).getString("troopCode");
                      if (this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler != null) {
                        this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(true, (String)localObject1, (String)localObject3, 0);
                      }
                      if (QLog.isColorLevel())
                      {
                        QLog.d("TroopMemberApiService", 2, "MSG_ON_GET_TROOP_MEM_LIST troopuin: " + (String)localObject3);
                        continue;
                        localObject1 = ((Bundle)localObject3).getString("path");
                        this.a.jdField_a_of_type_JavaLangString = ((Bundle)localObject3).getString("photoPath");
                        this.a.jdField_c_of_type_Int = ((Bundle)localObject3).getInt("seq", -1);
                        NearbyVideoUtils.a((QQAppInterface)localObject4, (String)localObject1, this.a.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
                        continue;
                        localObject5 = ((Bundle)localObject3).getByteArray("xmlData");
                        localObject1 = ((Bundle)localObject3).getString("friendUin");
                        i = ((Bundle)localObject3).getInt("directionFlag");
                        j = ((Bundle)localObject3).getInt("from");
                        if ((localObject4 instanceof QQAppInterface))
                        {
                          localObject3 = (QQAppInterface)localObject4;
                          if (!FaceScoreUtils.a((AppInterface)localObject3, (String)localObject1))
                          {
                            l1 = MessageCache.a();
                            localObject4 = ((QQAppInterface)localObject3).getCurrentAccountUin();
                            localObject5 = StructMsgFactory.a((byte[])localObject5, -1);
                            ((AbsStructMsg)localObject5).mMsgServiceID = 98;
                            localObject6 = (MessageForStructing)MessageRecordFactory.a(-2011);
                            ((MessageForStructing)localObject6).init((String)localObject4, (String)localObject1, (String)localObject1, "MarketTrans", l1, -2011, j, l1);
                            ((MessageForStructing)localObject6).structingMsg = ((AbsStructMsg)localObject5);
                            ((MessageForStructing)localObject6).msgData = ((MessageForStructing)localObject6).structingMsg.getBytes();
                            ((MessageForStructing)localObject6).isread = true;
                            FaceScoreUtils.a((AppInterface)localObject3, (String)localObject1);
                            FaceScoreUtils.a((MessageRecord)localObject6, "isFaceScoreBubbleMsg", true);
                            FaceScoreUtils.a((MessageRecord)localObject6, "isFaceScoreSecondMember", true);
                            FaceScoreUtils.a.add(localObject1);
                            if (i == 1) {}
                            for (bool = true;; bool = false)
                            {
                              MsgProxyUtils.a((MessageRecord)localObject6, bool);
                              ((QQAppInterface)localObject3).a().a((MessageRecord)localObject6, ((MessageForStructing)localObject6).selfuin);
                              if (!QLog.isColorLevel()) {
                                break;
                              }
                              QLog.d("Q..troop.faceScore", 2, "TroopMemberApiService.IncomingHandler.handlerMessage(). insert faceScore obj message., msg = " + localObject6);
                              break;
                            }
                            localObject1 = ((Bundle)localObject3).getString("troopUin");
                            localObject5 = ((Bundle)localObject3).getString("memUin");
                            i = ((Bundle)localObject3).getInt("serviceType");
                            localObject3 = (HotChatHandler)((QQAppInterface)localObject4).a(35);
                            if (localObject3 != null)
                            {
                              localObject6 = new ArrayList();
                              ((List)localObject6).add(Long.valueOf(Long.parseLong((String)localObject5)));
                              ((HotChatHandler)localObject3).a((QQAppInterface)localObject4, (String)localObject1, (List)localObject6, i);
                              continue;
                              l1 = ((Bundle)localObject3).getLong("dwGroupCode");
                              l2 = ((Bundle)localObject3).getLong("cGroupOption");
                              long l3 = ((Bundle)localObject3).getLong("dwGroupClass");
                              localObject1 = ((Bundle)localObject3).getString("strGroupName");
                              i = ((Bundle)localObject3).getInt("wGroupFace");
                              localObject4 = ((Bundle)localObject3).getString("strGroupMemo");
                              localObject5 = ((Bundle)localObject3).getString("strFingerMemo");
                              j = ((Bundle)localObject3).getInt("nFlag");
                              if (this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler != null)
                              {
                                this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(l1, l2, l3, (String)localObject1, i, (String)localObject4, (String)localObject5, j);
                                continue;
                                localObject1 = ((Bundle)localObject3).getString("troopUin");
                                if (this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler != null)
                                {
                                  this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.l((String)localObject1);
                                  continue;
                                  localObject1 = ((Bundle)localObject3).getString("troopUin");
                                  bool = ((Bundle)localObject3).getBoolean("isChecked");
                                  if (this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler != null)
                                  {
                                    this.a.jdField_a_of_type_ComTencentMobileqqAppBizTroopHandler.a((String)localObject1, bool);
                                    continue;
                                    localObject1 = ((Bundle)localObject3).getString("troopUin");
                                    byte b = ((Bundle)localObject3).getByte("cIsGetGroupAlbum");
                                    l1 = ((Bundle)localObject3).getLong("dwTimeStamp");
                                    i = ((Bundle)localObject3).getInt("cStatOption");
                                    if (this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler != null)
                                    {
                                      this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a((String)localObject1, Byte.valueOf(b).byteValue(), l1, i);
                                      continue;
                                      if (this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler != null)
                                      {
                                        localObject1 = ((Bundle)localObject3).getString("methord_name");
                                        int m;
                                        if ("getGroupInArea".equals(localObject1))
                                        {
                                          localObject1 = ((Bundle)localObject3).getString("areaName");
                                          i = ((Bundle)localObject3).getInt("lat");
                                          j = ((Bundle)localObject3).getInt("lon");
                                          k = ((Bundle)localObject3).getInt("startIndex");
                                          m = ((Bundle)localObject3).getInt("count");
                                          int n = ((Bundle)localObject3).getInt("iFilterId");
                                          this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a((String)localObject1, i, j, k, m, n);
                                        }
                                        else if ("getNearbyTroops".equals(localObject1))
                                        {
                                          bool = ((Bundle)localObject3).getBoolean("isFirst");
                                          i = ((Bundle)localObject3).getInt("lat");
                                          j = ((Bundle)localObject3).getInt("lon");
                                          k = ((Bundle)localObject3).getInt("sortType");
                                          localObject1 = ((Bundle)localObject3).getString("strGroupArea");
                                          m = ((Bundle)localObject3).getInt("iFilterId");
                                          this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(bool, i, j, k, (String)localObject1, m);
                                        }
                                        else if ("getAreaList".equals(localObject1))
                                        {
                                          i = ((Bundle)localObject3).getInt("lat");
                                          j = ((Bundle)localObject3).getInt("lon");
                                          k = ((Bundle)localObject3).getInt("radius");
                                          bool = ((Bundle)localObject3).getBoolean("isClickable");
                                          this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(i, j, k, bool);
                                        }
                                        else if ("getNewNearbyTroop".equals(localObject1))
                                        {
                                          i = ((Bundle)localObject3).getInt("lat");
                                          j = ((Bundle)localObject3).getInt("lon");
                                          this.a.jdField_a_of_type_ComTencentMobileqqAppLBSHandler.a(i, j);
                                          continue;
                                          localObject1 = ((Bundle)localObject3).getString("troopUin");
                                          localObject5 = ((Bundle)localObject3).getString("memberUin");
                                          i = ((Bundle)localObject3).getInt("titleId");
                                          localObject3 = (TroopManager)((AppRuntime)localObject4).getManager(51);
                                          if ((localObject3 != null) && (i > 0))
                                          {
                                            ((TroopManager)localObject3).a((String)localObject1, (String)localObject5, null, i, null, null, -100, -100, -100, -100L, (byte)-100, -100L, -100.0D);
                                            continue;
                                            localObject1 = new Bundle();
                                            ((Bundle)localObject1).putInt("seq", ((Bundle)localObject3).getInt("seq", -1));
                                            localObject3 = ((Bundle)localObject3).getStringArray("paths");
                                            if (((localObject4 instanceof QQAppInterface)) && (localObject3 != null) && (localObject3.length > 0))
                                            {
                                              localObject4 = (RedTouchManager)((AppRuntime)localObject4).getManager(35);
                                              if (localObject4 != null)
                                              {
                                                localObject5 = new int[localObject3.length];
                                                localObject6 = new int[localObject3.length];
                                                i = 0;
                                                if (i < localObject6.length)
                                                {
                                                  localObject7 = ((RedTouchManager)localObject4).a(localObject3[i]);
                                                  if (localObject7 != null)
                                                  {
                                                    localObject5[i] = ((BusinessInfoCheckUpdate.AppInfo)localObject7).iNewFlag.get();
                                                    localObject6[i] = ((BusinessInfoCheckUpdate.AppInfo)localObject7).type.get();
                                                  }
                                                  for (;;)
                                                  {
                                                    i += 1;
                                                    break;
                                                    localObject5[i] = 0;
                                                    localObject6[i] = -1;
                                                  }
                                                }
                                                ((Bundle)localObject1).putIntArray("iNewFlags", (int[])localObject5);
                                                ((Bundle)localObject1).putIntArray("types", (int[])localObject6);
                                              }
                                            }
                                            this.a.a(11, (Bundle)localObject1);
                                            continue;
                                            new Bundle().putInt("seq", ((Bundle)localObject3).getInt("seq", -1));
                                            localObject1 = ((Bundle)localObject3).getString("path");
                                            if ((localObject4 instanceof QQAppInterface))
                                            {
                                              localObject3 = (RedTouchManager)((AppRuntime)localObject4).getManager(35);
                                              if (localObject3 != null)
                                              {
                                                ((RedTouchManager)localObject3).b((String)localObject1);
                                                continue;
                                                localObject1 = ((Bundle)localObject3).getString("troopUin");
                                                localObject3 = ((Bundle)localObject3).getString("processName");
                                                localObject4 = (TroopHandler)((QQAppInterface)localObject4).a(20);
                                                if (localObject4 != null)
                                                {
                                                  ((TroopHandler)localObject4).b((String)localObject1, (String)localObject3);
                                                  continue;
                                                  localObject1 = new Bundle();
                                                  ((Bundle)localObject1).putString("method", "changeAnonymousNick");
                                                  ((Bundle)localObject1).putInt("seq", ((Bundle)localObject3).getInt("seq", -1));
                                                  localObject4 = ((Bundle)localObject3).getString("troopUin");
                                                  l1 = ((Bundle)localObject3).getLong("bubbleId");
                                                  i = ((Bundle)localObject3).getInt("headId");
                                                  localObject5 = ((Bundle)localObject3).getString("nickName");
                                                  j = ((Bundle)localObject3).getInt("expireTime");
                                                  localObject3 = ((Bundle)localObject3).getString("rankColor");
                                                  if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty((CharSequence)localObject5)))
                                                  {
                                                    AnonymousChatHelper.a().a((String)localObject4, l1, i, (String)localObject5, j, "", (String)localObject3);
                                                    ((Bundle)localObject1).putBoolean("result", true);
                                                  }
                                                  for (;;)
                                                  {
                                                    this.a.a(13, (Bundle)localObject1);
                                                    break;
                                                    ((Bundle)localObject1).putBoolean("result", false);
                                                  }
                                                  localObject1 = (TroopHandler)((QQAppInterface)localObject4).a(20);
                                                  i = ((Bundle)localObject3).getInt("appid");
                                                  localObject4 = ((Bundle)localObject3).getString("token");
                                                  ((TroopHandler)localObject1).a(i, ((Bundle)localObject3).getString("openGroupId"), (String)localObject4, ((Bundle)localObject3).getString("url"), ((Bundle)localObject3).getInt("seq"));
                                                  continue;
                                                  i = ((Bundle)localObject3).getInt("seq");
                                                  if (this.a.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonBridge == null) {
                                                    this.a.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonBridge = new DoraemonBridge((AppRuntime)localObject4, this.a);
                                                  }
                                                  this.a.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonBridge.a(120, (Bundle)localObject3, i);
                                                  continue;
                                                  localObject1 = (TroopHandler)((QQAppInterface)localObject4).a(20);
                                                  i = ((Bundle)localObject3).getInt("appid");
                                                  localObject4 = ((Bundle)localObject3).getString("token");
                                                  ((TroopHandler)localObject1).a(i, ((Bundle)localObject3).getString("openId"), (String)localObject4, ((Bundle)localObject3).getInt("seq"));
                                                  continue;
                                                  bool = ((Bundle)localObject3).getBoolean("isTroopAppListChanged");
                                                  localObject1 = (TroopAppMgr)((AppRuntime)localObject4).getManager(108);
                                                  if (localObject1 != null)
                                                  {
                                                    ((TroopAppMgr)localObject1).a(bool);
                                                    continue;
                                                    bool = ((Bundle)localObject3).getBoolean("isTroopProfileAppListChanged");
                                                    localObject1 = ((Bundle)localObject3).getString("profileAppListChangedTroopUin");
                                                    localObject3 = (TroopAppMgr)((AppRuntime)localObject4).getManager(108);
                                                    if (localObject3 != null)
                                                    {
                                                      ((TroopAppMgr)localObject3).a(bool, (String)localObject1);
                                                      continue;
                                                      localObject5 = ((Bundle)localObject3).getString("troopUin");
                                                      localObject1 = ((Bundle)localObject3).getString("opn");
                                                      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject5))) {
                                                        if (((String)localObject1).equals("g_homework"))
                                                        {
                                                          l1 = Long.parseLong((String)localObject5);
                                                          localObject1 = "";
                                                          if (TroopFileUtils.a((QQAppInterface)localObject4, l1)) {
                                                            localObject1 = "role=teacher&";
                                                          }
                                                          localObject3 = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
                                                          ((Intent)localObject3).putExtra("url", "http://qun.qq.com/homework/features/index.html?_wv=1027&_bid=2146#" + (String)localObject1 + "gid=" + (String)localObject5 + "&src=0");
                                                          ((Intent)localObject3).setFlags(268435456);
                                                          this.a.startActivity((Intent)localObject3);
                                                        }
                                                        else if (((String)localObject1).equals("g_troop_reward"))
                                                        {
                                                          TroopRewardMgr.a((QQAppInterface)localObject4, this.a, (String)localObject5, true);
                                                          continue;
                                                          ((Bundle)localObject3).putBoolean("isSuccess", true);
                                                          ((Bundle)localObject3).putString("data", TroopBarPublishActivity.G);
                                                          this.a.a(82, (Bundle)localObject3);
                                                          continue;
                                                          this.a.a((Bundle)localObject3);
                                                          continue;
                                                          if (!TroopMemberApiService.a((AppRuntime)localObject4, new owj(this, (Bundle)localObject3)))
                                                          {
                                                            this.a.a(16, (Bundle)localObject3);
                                                            continue;
                                                            l1 = ((Bundle)localObject3).getLong("uiResId");
                                                            localObject1 = LebaShowListManager.a().a(l1);
                                                            if ((localObject1 != null) && (((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo != null))
                                                            {
                                                              ((Bundle)localObject3).putString("packageName", ((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strPkgName);
                                                              ((Bundle)localObject3).putString("imageUrl", ((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResURL);
                                                              ((Bundle)localObject3).putString("name", ((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.strResName);
                                                              if (((LebaViewItem)localObject1).jdField_a_of_type_Byte == 0)
                                                              {
                                                                bool = true;
                                                                ((Bundle)localObject3).putBoolean("isOpen", bool);
                                                                ((Bundle)localObject3).putInt("type", ((LebaViewItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataResourcePluginInfo.lebaSearchResultType);
                                                                ((Bundle)localObject3).putBoolean("has", true);
                                                              }
                                                            }
                                                            for (;;)
                                                            {
                                                              this.a.a(18, (Bundle)localObject3);
                                                              break;
                                                              bool = false;
                                                              break label3133;
                                                              ((Bundle)localObject3).putBoolean("has", false);
                                                            }
                                                            LebaShowListManager.jdField_a_of_type_Int |= 0x1;
                                                            bool = ((Bundle)localObject3).getBoolean("isChecked");
                                                            l1 = ((Bundle)localObject3).getLong("uiResId");
                                                            ((Bundle)localObject3).putBoolean("result", TroopMemberApiService.a(this.a, l1, bool));
                                                            this.a.a(17, (Bundle)localObject3);
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
                  }
                }
              }
            }
          }
        }
      }
    case 19: 
      label3133:
      localObject5 = ((Bundle)localObject3).getString("troopUin");
      localObject7 = ((Bundle)localObject3).getString("troopName");
      k = ((Bundle)localObject3).getInt("troopTypeId");
      localObject6 = (TroopManager)((AppRuntime)localObject4).getManager(51);
      if (localObject6 != null)
      {
        localObject1 = ((TroopManager)localObject6).a((String)localObject5);
        if (localObject1 == null)
        {
          localObject1 = new TroopInfo();
          ((TroopInfo)localObject1).troopuin = ((String)localObject5);
          ((TroopInfo)localObject1).troopname = ((String)localObject7);
          ((TroopInfo)localObject1).Administrator = ((QQAppInterface)localObject4).getCurrentAccountUin();
          ((TroopInfo)localObject1).dwAdditionalFlag = 1L;
          ((TroopManager)localObject6).b((TroopInfo)localObject1);
        }
      }
      break;
    }
    for (;;)
    {
      String str1;
      for (;;)
      {
        localObject7 = (TroopHandler)((QQAppInterface)localObject4).a(20);
        if (localObject7 != null) {
          ((TroopHandler)localObject7).a((String)localObject5, (byte)0, 0L, -1);
        }
        j = 1;
        if (k == 32L) {
          i = 0;
        }
        for (;;)
        {
          if (i != 0)
          {
            localObject7 = (TroopCreateLogic)((AppRuntime)localObject4).getManager(31);
            if (localObject7 != null) {
              ((TroopCreateLogic)localObject7).a((QQAppInterface)localObject4, (String)localObject5);
            }
          }
          if ((localObject6 != null) && (localObject1 != null)) {
            ((TroopManager)localObject6).d((TroopInfo)localObject1);
          }
          if (!(localObject4 instanceof QQAppInterface)) {
            break;
          }
          this.a.a(19, (Bundle)localObject3);
          break;
          i = j;
          if (k == 25)
          {
            i = j;
            if (((AppRuntime)localObject4).getPreferences() != null)
            {
              i = j;
              if (((AppRuntime)localObject4).getPreferences().getBoolean("key_game_troop_bind_config_switch", false)) {
                i = 0;
              }
            }
          }
        }
        if ((!(localObject4 instanceof QQAppInterface)) || (localObject3 == null)) {
          break;
        }
        l1 = ((Bundle)localObject3).getLong("troopCode");
        localObject1 = ((Bundle)localObject3).getString("filePath");
        localObject5 = ((Bundle)localObject3).getString("fileName");
        l2 = ((Bundle)localObject3).getLong("fileSize");
        i = ((Bundle)localObject3).getInt("busid");
        localObject1 = TroopFileUtils.a((QQAppInterface)localObject4, l1, null, (String)localObject1, (String)localObject5, l2, i);
        localObject5 = new Bundle();
        ((Bundle)localObject5).putInt("seq", ((Bundle)localObject3).getInt("seq", -1));
        if (!TextUtils.isEmpty(((Bundle)localObject3).getString("callback"))) {
          ((Bundle)localObject5).putString("callback", ((Bundle)localObject3).getString("callback"));
        }
        ((Bundle)localObject5).putString("method", "getFileInfo");
        TroopMemberApiService.a(this.a, (QQAppInterface)localObject4, l1, HWTroopFileStatusInfo.parse((TroopFileStatusInfo)localObject1), (Bundle)localObject5);
        break;
        if ((!(localObject4 instanceof QQAppInterface)) || (localObject3 == null)) {
          break;
        }
        if (this.a.jdField_a_of_type_ComTencentBizPubaccountUtilPAH5Manager == null) {
          this.a.jdField_a_of_type_ComTencentBizPubaccountUtilPAH5Manager = new PAH5Manager(this.a, (QQAppInterface)localObject4);
        }
        if (((Bundle)localObject3).getBoolean("is_pic_or_voice"))
        {
          this.a.jdField_a_of_type_ComTencentBizPubaccountUtilPAH5Manager.a((Bundle)localObject3);
          break;
        }
        this.a.jdField_a_of_type_ComTencentBizPubaccountUtilPAH5Manager.c((Bundle)localObject3);
        break;
        if ((!(localObject4 instanceof QQAppInterface)) || (localObject3 == null)) {
          break;
        }
        if (this.a.jdField_a_of_type_ComTencentBizPubaccountUtilPAH5Manager == null) {
          this.a.jdField_a_of_type_ComTencentBizPubaccountUtilPAH5Manager = new PAH5Manager(this.a, (QQAppInterface)localObject4);
        }
        if (((Bundle)localObject3).getBoolean("is_pic_or_voice"))
        {
          this.a.jdField_a_of_type_ComTencentBizPubaccountUtilPAH5Manager.b((Bundle)localObject3);
          break;
        }
        this.a.jdField_a_of_type_ComTencentBizPubaccountUtilPAH5Manager.d((Bundle)localObject3);
        break;
        if (this.a.jdField_a_of_type_ComTencentBizPubaccountUtilPAH5Manager == null) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentBizPubaccountUtilPAH5Manager.a();
        break;
        this.a.d = ((Bundle)localObject3).getInt("appId");
        this.a.e = ((Bundle)localObject3).getInt("seq");
        if (this.a.d == 0) {
          break;
        }
        localObject1 = (TroopAppMgr)((AppRuntime)localObject4).getManager(108);
        if (localObject1 == null) {
          break;
        }
        localObject3 = new ArrayList();
        if ((((TroopAppMgr)localObject1).a(0)) && (!((TroopAppMgr)localObject1).b(0)))
        {
          localObject4 = ((TroopAppMgr)localObject1).a(false, 0);
          if ((localObject4 != null) && (!((List)localObject4).isEmpty()))
          {
            localObject4 = ((List)localObject4).iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (TroopAIOAppInfo)((Iterator)localObject4).next();
              ((ArrayList)localObject3).add(Integer.valueOf(((TroopAIOAppInfo)localObject5).appid));
              if (((TroopAIOAppInfo)localObject5).appid == this.a.d)
              {
                QQToast.a(BaseApplication.getContext(), 2, 2131433190, 0).b(this.a.getResources().getDimensionPixelSize(2131558448));
                return;
              }
            }
          }
          ((ArrayList)localObject3).add(Integer.valueOf(this.a.d));
          localObject4 = new ArrayList();
          ((ArrayList)localObject4).add(Integer.valueOf(this.a.d));
          ((TroopAppMgr)localObject1).a((ArrayList)localObject3, (ArrayList)localObject4);
          break;
        }
        this.a.jdField_a_of_type_Boolean = true;
        ((TroopAppMgr)localObject1).a(true, 0);
        break;
        l1 = ((Bundle)localObject3).getLong("roomid", 0L);
        localObject1 = ((Bundle)localObject3).getString("roomname");
        localObject5 = ((Bundle)localObject3).getString("userdata");
        localObject6 = ((Bundle)localObject3).getString("vasname");
        i = ((Bundle)localObject3).getInt("fromid", 0);
        ((ODProxy)((QQAppInterface)localObject4).getManager(107)).a(this.a, l1, (String)localObject1, (String)localObject6, (String)localObject5, i);
        break;
        localObject1 = ((Bundle)localObject3).getString("appType");
        localObject5 = ((Bundle)localObject3).getString("openType");
        localObject6 = ((Bundle)localObject3).getString("uri");
        localObject7 = ((Bundle)localObject3).getString("action");
        str1 = ((Bundle)localObject3).getString("pluginPackageName");
        localObject3 = ((Bundle)localObject3).getString("pluginParams");
        HuayangOpenHelper.a((QQAppInterface)localObject4, (String)localObject1, (String)localObject5, (String)localObject6, "web", (String)localObject7, str1, (String)localObject3);
        break;
        localObject1 = ((Bundle)localObject3).getString("pluginPackageName");
        localObject3 = ((Bundle)localObject3).getString("appType");
        HuayangDowanloadHelper.a(((QQAppInterface)localObject4).getApp(), (String)localObject1, (String)localObject3).a();
        break;
        try
        {
          l1 = ((Bundle)localObject3).getLong("troopPubAccountUin");
          localObject1 = ((Bundle)localObject3).getLongArray("troopUinList");
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            break;
          }
          localObject3 = (TroopManager)((AppRuntime)localObject4).getManager(51);
          i = 0;
          while (i < localObject1.length)
          {
            localObject4 = ((TroopManager)localObject3).a(localObject1[i] + "");
            if (localObject4 != null) {
              ((TroopInfo)localObject4).associatePubAccount = l1;
            }
            ((TroopManager)localObject3).b((TroopInfo)localObject4);
            i += 1;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        catch (Exception localException) {}
      }
      QLog.e("AccountDetailActivity.bindTroop", 2, "updateTroopBindedPubAccount:" + localException.toString());
      break label608;
      Object localObject2 = ((Bundle)localObject3).getString("troopUin");
      localObject3 = (TroopManager)((AppRuntime)localObject4).getManager(51);
      if (localObject3 == null) {
        break label608;
      }
      localObject2 = ((TroopManager)localObject3).a((String)localObject2);
      if (localObject2 == null) {
        break label608;
      }
      ((TroopInfo)localObject2).troopPrivilegeFlag |= 0x800;
      ((TroopManager)localObject3).b((TroopInfo)localObject2);
      break label608;
      localObject2 = ((Bundle)localObject3).getString("troopUin");
      localObject4 = (TroopManager)((AppRuntime)localObject4).getManager(51);
      if (localObject4 != null)
      {
        localObject2 = ((TroopManager)localObject4).a((String)localObject2);
        if ((localObject2 != null) && (((TroopInfo)localObject2).hasOrgs())) {
          bool = true;
        }
      }
      for (;;)
      {
        ((Bundle)localObject3).putBoolean("hasOrgs", bool);
        this.a.a(46, (Bundle)localObject3);
        break label608;
        bool = false;
        continue;
        localObject2 = ((Bundle)localObject3).getString("localFilePath");
        localObject3 = ((Bundle)localObject3).getString("fileDisPlayName");
        HWTroopUtils.a(this.a, (String)localObject2, (String)localObject3);
        break label608;
        localObject2 = ((Bundle)localObject3).getString("troopUin");
        i = ((Bundle)localObject3).getInt("rewardMoney");
        localObject5 = ((Bundle)localObject3).getString("rewardContent");
        localObject6 = ((Bundle)localObject3).getString("mediaPath");
        j = ((Bundle)localObject3).getInt("rewardType");
        TroopRewardMgr.jdField_a_of_type_Int = ((Bundle)localObject3).getInt("imageMaxWidthPixels", 1080);
        TroopRewardMgr.b = ((Bundle)localObject3).getInt("imageMaxHeightPixels", 1920);
        ((TroopRewardMgr)((AppRuntime)localObject4).getManager(151)).a((String)localObject2, i, (String)localObject5, (String)localObject6, j);
        break label608;
        l1 = ((Bundle)localObject3).getLong("troopUin");
        i = ((Bundle)localObject3).getInt("flag");
        this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a(l1, i);
        break label608;
        localObject2 = (QQAppInterface)localObject4;
        ((Bundle)localObject3).putInt("fontSize", QQAppInterface.b);
        this.a.a(52, (Bundle)localObject3);
        break label608;
        i = ((Bundle)localObject3).getInt("fontSize", 1);
        localObject2 = (QQAppInterface)localObject4;
        QQAppInterface.b = i;
        ThreadManager.executeOnSubThread(new owl(this, i));
        break label608;
        localObject2 = ((Bundle)localObject3).getString("troopUin");
        localObject5 = ((Bundle)localObject3).getString("rewardId");
        localObject4 = ((TroopRewardMgr)((AppRuntime)localObject4).getManager(151)).a((String)localObject2, (String)localObject5);
        localObject2 = "";
        if (localObject4 != null) {
          localObject2 = ((MessageForTroopReward)localObject4).mediaPath;
        }
        ((Bundle)localObject3).putString("videoPath", (String)localObject2);
        this.a.a(55, (Bundle)localObject3);
        break label608;
        localObject2 = ((Bundle)localObject3).getString("troopUin");
        localObject5 = ((Bundle)localObject3).getString("largeImageFile");
        localObject6 = ((Bundle)localObject3).getString("fileName");
        l1 = ((Bundle)localObject3).getLong("progressTotal");
        i = ((Bundle)localObject3).getInt("busId");
        TroopFileTransferManager.a((QQAppInterface)localObject4, Long.parseLong((String)localObject2)).a((String)localObject5, (String)localObject6, l1, i);
        break label608;
        localObject2 = ((Bundle)localObject3).getString("troopUin");
        localObject5 = ((Bundle)localObject3).getString("filePath");
        localObject6 = ((Bundle)localObject3).getString("fileName");
        i = ((Bundle)localObject3).getInt("size");
        j = ((Bundle)localObject3).getInt("busId");
        TroopFileTransferManager.a((QQAppInterface)localObject4, Long.parseLong((String)localObject2)).a((String)localObject5, (String)localObject6, j, i);
        break label608;
        localObject2 = (TroopPluginManager)((AppRuntime)localObject4).getManager(118);
        localObject4 = ((Bundle)localObject3).getString("troopUin");
        i = ((Bundle)localObject3).getInt("seq");
        localObject3 = ((Bundle)localObject3).getString("processName");
        if (localObject2 == null) {
          break label608;
        }
        ((TroopPluginManager)localObject2).a("troop_manage_plugin.apk", new owm(this, (String)localObject4, i, (String)localObject3));
        break label608;
        localObject5 = (TroopTopicMgr)((AppRuntime)localObject4).getManager(97);
        i = ((Bundle)localObject3).getInt("seq");
        localObject2 = ((Bundle)localObject3).getString("troopUin");
        l1 = ((Bundle)localObject3).getLong("msgseq");
        j = ((Bundle)localObject3).getInt("reqType");
        str1 = ((Bundle)localObject3).getString("comment");
        if (!(localObject4 instanceof QQAppInterface)) {
          break label608;
        }
        localObject4 = (QQAppInterface)localObject4;
        localObject3 = ReplyTextItemBuilder.a((QQAppInterface)localObject4, (String)localObject2, 1, l1);
        if (localObject3 != null)
        {
          if (j == 0)
          {
            if (AnonymousChatHelper.a().a((String)localObject2)) {
              break label608;
            }
            ((TroopTopicMgr)localObject5).a((ChatMessage)localObject3, 2, new own(this, j, i));
            break label608;
          }
          if ((localObject3 == null) || (!(localObject3 instanceof MessageForStructing))) {
            break label608;
          }
          MessageForStructing localMessageForStructing = (MessageForStructing)localObject3;
          localObject6 = new ChatActivityFacade.SendMsgParams();
          ((ChatActivityFacade.SendMsgParams)localObject6).a = new MessageForReplyText.SourceMsgInfo();
          ((ChatActivityFacade.SendMsgParams)localObject6).a.mSourceMsgSenderUin = Long.parseLong(localMessageForStructing.senderuin);
          ((ChatActivityFacade.SendMsgParams)localObject6).a.mSourceMsgSeq = localMessageForStructing.shmsgseq;
          ((ChatActivityFacade.SendMsgParams)localObject6).a.mSourceMsgTime = ((int)localMessageForStructing.time);
          ((ChatActivityFacade.SendMsgParams)localObject6).a.mSourceSummaryFlag = 1;
          ((ChatActivityFacade.SendMsgParams)localObject6).a.mType = 1;
          ((ChatActivityFacade.SendMsgParams)localObject6).a.mSourceMsgText = localMessageForStructing.structingMsg.mMsgBrief;
          if ((!TextUtils.isEmpty(((ChatActivityFacade.SendMsgParams)localObject6).a.mSourceMsgText)) && (((ChatActivityFacade.SendMsgParams)localObject6).a.mSourceMsgText.length() > BaseChatPie.l))
          {
            ((ChatActivityFacade.SendMsgParams)localObject6).a.mSourceMsgText = ((ChatActivityFacade.SendMsgParams)localObject6).a.mSourceMsgText.substring(0, BaseChatPie.l);
            ((ChatActivityFacade.SendMsgParams)localObject6).a.mSourceSummaryFlag = 0;
          }
          String str3 = ContactUtils.e((QQAppInterface)localObject4, ((MessageRecord)localObject3).frienduin, localMessageForStructing.senderuin);
          String str2 = TroopTopicMgr.a((MessageRecord)localObject3);
          ((ChatActivityFacade.SendMsgParams)localObject6).a.mRichMsg = str2;
          localObject7 = new ArrayList();
          MessageForText.AtTroopMemberInfo localAtTroopMemberInfo = new MessageForText.AtTroopMemberInfo();
          localAtTroopMemberInfo.startPos = 0;
          localAtTroopMemberInfo.textLen = ((short)(str3.length() + 1));
          localAtTroopMemberInfo.uin = Long.parseLong(localMessageForStructing.senderuin);
          ((ArrayList)localObject7).add(localAtTroopMemberInfo);
          str1 = "@" + str3 + " " + str1;
          if (!AnonymousChatHelper.a().a((String)localObject2)) {
            ((TroopTopicMgr)localObject5).a(TroopTopicMgr.a((QQAppInterface)localObject4, (String)localObject2, (ChatActivityFacade.SendMsgParams)localObject6, str1, 3), localMessageForStructing.shmsgseq, str1, str2, (ArrayList)localObject7, Long.parseLong(((MessageRecord)localObject3).frienduin) + 10000000000L, "0", null, 2, new owo(this, j, i));
          }
          while (QLog.isColorLevel())
          {
            QLog.d("com.tencent.biz.troop.TroopMemberApiService", 2, "commend: 评论ok, send uniseq = " + ((MessageRecord)localObject3).shmsgseq + ", msg = " + str1);
            break;
            ((ChatActivityFacade.SendMsgParams)localObject6).a.mType = 0;
            localObject5 = new SessionInfo();
            ((SessionInfo)localObject5).jdField_a_of_type_Int = 1;
            ((SessionInfo)localObject5).jdField_a_of_type_JavaLangString = ((String)localObject2);
            ((SessionInfo)localObject5).b = ((String)localObject2);
            ((SessionInfo)localObject5).jdField_c_of_type_Int = 0;
            ChatActivityFacade.a((QQAppInterface)localObject4, BaseApplication.getContext(), (SessionInfo)localObject5, str1, (ArrayList)localObject7, (ChatActivityFacade.SendMsgParams)localObject6);
            localObject2 = new Bundle();
            ((Bundle)localObject2).putInt("reqType", j);
            ((Bundle)localObject2).putInt("seq", i);
            ((Bundle)localObject2).putInt("errorCode", 0);
            this.a.a(60, (Bundle)localObject2);
          }
        }
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("reqType", j);
        ((Bundle)localObject2).putInt("seq", i);
        ((Bundle)localObject2).putInt("errorCode", -1);
        this.a.a(60, (Bundle)localObject2);
        break label608;
        localObject2 = ((Bundle)localObject3).getString("appid");
        localObject3 = ((Bundle)localObject3).getString("pkgname");
        this.a.a((String)localObject3, (String)localObject2);
        break label608;
        localObject2 = ((Bundle)localObject3).getString("hashName");
        ((Bundle)localObject3).putByteArray("decryptResult", PreloadManager.a().b((String)localObject2));
        this.a.a(67, (Bundle)localObject3);
        break label608;
        localObject2 = ((Bundle)localObject3).getString("troopUin");
        i = ((Bundle)localObject3).getInt("statOption");
        localObject3 = ((Bundle)localObject3).getString("authKey");
        this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a((String)localObject2, "", i, (String)localObject3, null, null);
        break label608;
        localObject2 = ((Bundle)localObject3).getString("groupCode");
        localObject5 = ((Bundle)localObject3).getString("groupMemberUin");
        i = ((Bundle)localObject3).getInt("seq");
        ThreadManager.post(new owp(this, (TroopManager)((AppRuntime)localObject4).getManager(51), (String)localObject2, (String)localObject5, (Bundle)localObject3, i), 8, null, true);
        break label608;
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("seq", ((Bundle)localObject3).getInt("seq", -1));
        localObject3 = ((DownloaderFactory)((AppRuntime)localObject4).getManager(46)).a(1);
        localObject4 = new File(NearbyConstants.jdField_a_of_type_JavaLangString + File.separator + "nearby_heart.mp4");
        if (!((File)localObject4).exists()) {
          ((File)localObject4).mkdirs();
        }
        for (;;)
        {
          ((DownloaderInterface)localObject3).a(new DownloadTask("http://pub.idqqimg.com/pc/misc/nearby/nearby_heart.gif", (File)localObject4), new owq(this, (Bundle)localObject2), new Bundle());
          break;
          ((File)localObject4).delete();
        }
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("seq", ((Bundle)localObject3).getInt("seq", -1));
        bool = false;
        if ((localObject4 instanceof QQAppInterface))
        {
          localObject3 = (QQAppInterface)localObject4;
          if ((!((QQAppInterface)localObject3).c()) || (((QQAppInterface)localObject3).a().j())) {
            break label6342;
          }
        }
        label6342:
        for (bool = true;; bool = false)
        {
          ((Bundle)localObject2).putBoolean("isOtherTypeChatting", bool);
          this.a.a(85, (Bundle)localObject2);
          break;
        }
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("seq", ((Bundle)localObject3).getInt("seq", -1));
        if ((localObject4 instanceof QQAppInterface))
        {
          localObject4 = (NearbyVideoChatManager)((AppRuntime)localObject4).getManager(223);
          if (localObject4 != null)
          {
            localObject3 = ((NearbyVideoChatManager)localObject4).a();
            localObject4 = ((NearbyVideoChatManager)localObject4).b();
            ((Bundle)localObject2).putString("nearbyVideoConfig", (String)localObject3);
            ((Bundle)localObject2).putString("title", (String)localObject4);
          }
        }
        this.a.a(77, (Bundle)localObject2);
        break label608;
        if (!(localObject4 instanceof QQAppInterface)) {
          break label608;
        }
        bool = PtvFilterSoLoad.a((QQAppInterface)localObject4, BaseApplicationImpl.getContext());
        if (!QLog.isColorLevel()) {
          break label608;
        }
        QLog.e("TroopMemberApiService", 2, "isPtvFilterDownloadOK:" + bool);
        break label608;
        localObject2 = ((Bundle)localObject3).getString("packageName");
        localObject5 = ((Bundle)localObject3).getString("pluginId");
        localObject6 = ((Bundle)localObject3).getString("versionCode");
        HuanjiPluginProxy.a().a((String)localObject2, (String)localObject5, (String)localObject6);
        HuanjiPluginProxy.a().a((QQAppInterface)localObject4);
        ((Bundle)localObject3).putInt("state", HuanjiPluginInfo.jdField_a_of_type_Int);
        ((Bundle)localObject3).putString("version", HuanjiPluginInfo.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject3).putLong("size", HuanjiPluginInfo.jdField_a_of_type_Long);
        this.a.a(79, (Bundle)localObject3);
        break label608;
        localObject2 = ((Bundle)localObject3).getString("via");
        localObject4 = ((Bundle)localObject3).getString("startParam");
        i = ((Bundle)localObject3).getInt("action");
        HuanjiPluginProxy.a().a((String)localObject2, i, (String)localObject4, new owr(this, (Bundle)localObject3, i));
        break label608;
        ((Bundle)localObject3).putInt("currentFragment", SplashActivity.jdField_a_of_type_Int);
        this.a.a(81, (Bundle)localObject3);
        break label608;
        localObject2 = (VideoUploadManager)((AppRuntime)localObject4).getManager(225);
        ((VideoUploadManager)localObject2).a(this.a);
        ((VideoUploadManager)localObject2).a(((Bundle)localObject3).getString("videoPath"), (Bundle)localObject3);
        break label608;
        i = ((Bundle)localObject3).getInt("subCmd");
        localObject2 = (TroopEnterEffectManager)((QQAppInterface)localObject4).getManager(230);
        switch (i)
        {
        }
        for (;;)
        {
          this.a.a(88, (Bundle)localObject3);
          break;
          ((TroopEnterEffectManager)localObject2).a(((Bundle)localObject3).getInt("effectId"), ((Bundle)localObject3).getString("effectName"), ((Bundle)localObject3).getInt("svipLevel"), ((Bundle)localObject3).getInt("svipType"));
          continue;
          localObject4 = ((Bundle)localObject3).getStringArrayList("statusList");
          if (localObject4 != null) {
            ((TroopEnterEffectManager)localObject2).a((ArrayList)localObject4);
          }
        }
        localObject2 = ((Bundle)localObject3).getString("troopUin");
        localObject4 = ((Bundle)localObject3).getString("path");
        i = ((Bundle)localObject3).getInt("msgTailType", 0);
        localObject5 = new Intent();
        ((Intent)localObject5).putExtra("send_in_background", true);
        ((Intent)localObject5).putExtra("file_send_path", (String)localObject4);
        ((Intent)localObject5).putExtra("file_send_size", new File((String)localObject4).length());
        ((Intent)localObject5).putExtra("file_send_duration", ShortVideoUtils.b((String)localObject4));
        ((Intent)localObject5).putExtra("uin", (String)localObject2);
        ((Intent)localObject5).putExtra("uintype", 1);
        ((Intent)localObject5).putExtra("file_source", "album_flow");
        ((Intent)localObject5).putExtra("short_video_msg_tail_type", i);
        new SendVideoActivity.SendVideoTaskV2((Intent)localObject5).execute(new Void[0]);
        this.a.a(88, (Bundle)localObject3);
        break label608;
        localObject2 = (NowProxy)((AppRuntime)localObject4).getManager(181);
        l1 = ((Bundle)localObject3).getLong("roomId");
        localObject3 = new Bundle();
        ((Bundle)localObject3).putInt("jumpType", 1);
        ((NowProxy)localObject2).a(null, l1, (Bundle)localObject3);
        break label608;
        localObject2 = (NowProxy)((AppRuntime)localObject4).getManager(181);
        ((NowProxy)localObject2).a((Bundle)localObject3);
        ((NowProxy)localObject2).a(TroopMemberApiService.a(this.a));
        break label608;
        ((NowProxy)((AppRuntime)localObject4).getManager(181)).a(BaseApplication.getContext());
        break label608;
        ((NowProxy)((AppRuntime)localObject4).getManager(181)).a(TroopMemberApiService.a(this.a));
        break label608;
        if (this.a.jdField_b_of_type_Boolean) {
          break;
        }
        this.a.jdField_b_of_type_Boolean = true;
        bool = NetworkUtil.g(null);
        VideoEnvironment.a("TroopMemberApiService", "startDownloadConfig netUsable=" + bool, null);
        if (bool)
        {
          VideoEnvironment.a("TroopMemberApiService", "短视频配置下载中...", null);
          ShortVideoResourceManager.a((QQAppInterface)localObject4, new ows(this, (AppRuntime)localObject4, (Bundle)localObject3));
          break label608;
        }
        ((Bundle)localObject3).putInt("result", -1);
        this.a.a(94, (Bundle)localObject3);
        break label608;
        i = ((Bundle)localObject3).getInt("isGroupCode");
        localObject2 = ((Bundle)localObject3).getString("roomId");
        localObject5 = ((Bundle)localObject3).getString("action");
        localObject6 = ((Bundle)localObject3).getString("fromId");
        localObject7 = ((Bundle)localObject3).getString("backType");
        str1 = ((Bundle)localObject3).getString("openType");
        localObject3 = ((Bundle)localObject3).getString("extra");
        ((GroupVideoManager)((AppRuntime)localObject4).getManager(235)).a(this.a, (String)localObject2, ((QQAppInterface)localObject4).getCurrentAccountUin(), i, (String)localObject5, (String)localObject6, (String)localObject7, str1, (String)localObject3);
        break label608;
        localObject2 = ((Bundle)localObject3).getString("uin");
        i = ((Bundle)localObject3).getInt("index");
        localObject2 = AdvertisementRecentUserManager.a().a((String)localObject2);
        if (localObject2 == null) {
          break label608;
        }
        localObject3 = (AdvertisementVideoPreloadManager)((AppRuntime)localObject4).getManager(237);
        if (localObject3 == null) {
          break label608;
        }
        ((AdvertisementVideoPreloadManager)localObject3).a((AdvertisementItem)localObject2, i);
        break label608;
        localObject2 = ((Bundle)localObject3).getString("troopCode");
        localObject5 = ((Bundle)localObject3).getString("uin");
        localObject3 = ((Bundle)localObject3).getString("nick");
        localObject4 = (HotChatHandler)((QQAppInterface)localObject4).a(35);
        if (localObject4 == null) {
          break label608;
        }
        ((HotChatHandler)localObject4).a((String)localObject2, (String)localObject5, (String)localObject3);
        break label608;
        localObject2 = ((Bundle)localObject3).getString("troopCode");
        localObject3 = ((Bundle)localObject3).getString("uin");
        localObject4 = (HotChatHandler)((QQAppInterface)localObject4).a(35);
        if (localObject4 == null) {
          break label608;
        }
        ((HotChatHandler)localObject4).a((String)localObject2, (String)localObject3);
        break label608;
        localObject2 = ((Bundle)localObject3).getString("troopCode");
        localObject3 = (HotChatHandler)((QQAppInterface)localObject4).a(35);
        if (localObject3 == null) {
          break label608;
        }
        ((HotChatHandler)localObject3).a((String)localObject2);
        break label608;
        localObject2 = ((Bundle)localObject3).getString("troopCode");
        localObject5 = ((Bundle)localObject3).getString("uin");
        localObject3 = ((Bundle)localObject3).getString("nick");
        localObject4 = (HotChatHandler)((QQAppInterface)localObject4).a(35);
        if (localObject4 == null) {
          break label608;
        }
        ((HotChatHandler)localObject4).b((String)localObject2, (String)localObject5, (String)localObject3);
        break label608;
        localObject2 = ((Bundle)localObject3).getString("troopCode");
        localObject3 = ((Bundle)localObject3).getString("uin");
        localObject4 = (HotChatHandler)((QQAppInterface)localObject4).a(35);
        if (localObject4 == null) {
          break label608;
        }
        ((HotChatHandler)localObject4).b((String)localObject2, (String)localObject3);
        break label608;
        ((Bundle)localObject3).getString("troopCode");
        localObject2 = ((Bundle)localObject3).getString("rid");
        localObject3 = new owk(this, (Bundle)localObject3);
        this.a.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper = new HotchatSCHelper((QQAppInterface)localObject4, (HotchatSCHelper.OnShowNoteListener)localObject3, (String)localObject2);
        this.a.jdField_a_of_type_ComTencentMobileqqAppHotchatSCHelper.b(10000L);
        break label608;
        this.a.f = ((Bundle)localObject3).getInt("seq", -1);
        localObject2 = ((Bundle)localObject3).getStringArrayList("tinyIdList");
        localObject3 = (HotChatHandler)((QQAppInterface)localObject4).a(35);
        if (localObject3 == null) {
          break label608;
        }
        ((HotChatHandler)localObject3).a((ArrayList)localObject2);
        break label608;
        localObject2 = ((Bundle)localObject3).getString("schoolName");
        i = ((Bundle)localObject3).getInt("isValid");
        localObject3 = (NearbyCardHandler)((QQAppInterface)localObject4).a(60);
        if (localObject3 == null) {
          break label608;
        }
        ((NearbyCardHandler)localObject3).a((String)localObject2, i);
        break label608;
        localObject2 = ((Bundle)localObject3).getStringArrayList("preloadList");
        localObject3 = (NativeAdPreloadManager)((AppRuntime)localObject4).getManager(247);
        if (localObject3 == null) {
          break label608;
        }
        ((NativeAdPreloadManager)localObject3).a((ArrayList)localObject2);
        break label608;
        localObject2 = (NativeAdPreloadManager)((AppRuntime)localObject4).getManager(247);
        if (localObject2 == null) {
          break label608;
        }
        ((NativeAdPreloadManager)localObject2).a();
        break label608;
        localObject2 = BaseActivity.sTopActivity;
        if (((localObject2 instanceof SplashActivity)) || ((localObject2 instanceof ChatActivity))) {}
        for (localObject2 = ((FragmentActivity)localObject2).getChatFragment(); localObject2 != null; localObject2 = null)
        {
          localObject2 = ((ChatFragment)localObject2).a();
          if (localObject2 == null) {
            break;
          }
          i = ((Bundle)localObject3).getInt("istroop");
          localObject4 = ((Bundle)localObject3).getString("frienduin");
          l1 = ((Bundle)localObject3).getLong("shmsgseq");
          j = ((Bundle)localObject3).getInt("subMsgId");
          localObject3 = (LightReplyEmojs)((Bundle)localObject3).getSerializable("clickData");
          ((BaseChatPie)localObject2).a(BaseApplication.getContext(), i, (String)localObject4, l1, j, (LightReplyEmojs)localObject3);
          break;
          localObject2 = LightReplyMenuManager.a();
          if ((localObject2 == null) || (((LightReplyMenuManager)localObject2).a != null)) {
            break;
          }
          ((LightReplyMenuManager)localObject2).c();
          break;
          i = ((Bundle)localObject3).getInt("topicId");
          j = ((Bundle)localObject3).getInt("followInfo");
          if (ReadInJoyLogicEngine.a().a(i, j)) {
            break;
          }
          ReadInJoyLogicEngine.a().b(i, j);
          break;
          ((Bundle)localObject3).putInt("readinjoy_to_wx_config", ReadInJoyHelper.u((AppRuntime)localObject4));
          this.a.a(116, (Bundle)localObject3);
          break;
          if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPluginReadInJoySkinHelper == null) {
            this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPluginReadInJoySkinHelper = new ReadInJoySkinHelper((AppRuntime)localObject4, this.a);
          }
          this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPluginReadInJoySkinHelper.b((Bundle)localObject3);
          break;
          if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPluginReadInJoySkinHelper == null) {
            this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPluginReadInJoySkinHelper = new ReadInJoySkinHelper((AppRuntime)localObject4, this.a);
          }
          this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPluginReadInJoySkinHelper.c((Bundle)localObject3);
          break;
          if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPluginReadInJoySkinHelper == null) {
            this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPluginReadInJoySkinHelper = new ReadInJoySkinHelper((AppRuntime)localObject4, this.a);
          }
          this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPluginReadInJoySkinHelper.d((Bundle)localObject3);
          break;
          if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPluginReadInJoySkinHelper == null) {
            this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPluginReadInJoySkinHelper = new ReadInJoySkinHelper((AppRuntime)localObject4, this.a);
          }
          this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPluginReadInJoySkinHelper.a((Bundle)localObject3);
          break;
          this.a.jdField_c_of_type_JavaLangString = ((Bundle)localObject3).getString("callback");
          this.a.g = ((Bundle)localObject3).getInt("seq");
          localObject2 = ((Bundle)localObject3).getString("troopUin");
          localObject3 = ((Bundle)localObject3).getString("chatType");
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && ("group".equals(localObject3)))
          {
            if (this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler == null) {
              break;
            }
            this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.a((String)localObject2, false, "TroopMemberApiService114", true);
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("TroopMemberApiService", 2, "notifyTroopCreate error. troopCode=" + (String)localObject2 + ", chatType=" + (String)localObject3);
          }
          localObject2 = new Bundle();
          ((Bundle)localObject2).putBoolean("isSuccess", false);
          ((Bundle)localObject2).putInt("seq", this.a.g);
          ((Bundle)localObject2).putString("callback", this.a.jdField_c_of_type_JavaLangString);
          this.a.a(115, (Bundle)localObject2);
          break;
          localObject2 = new Intent(((QQAppInterface)localObject4).getApp().getApplicationContext(), SplashActivity.class);
          ((Intent)localObject2).putExtras((Bundle)localObject3);
          localObject2 = AIOUtils.a((Intent)localObject2, null);
          localObject3 = ForwardUtils.a((Intent)localObject2);
          ForwardUtils.a((QQAppInterface)localObject4, ((QQAppInterface)localObject4).getApp().getApplicationContext(), (SessionInfo)localObject3, (Intent)localObject2);
          break;
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberApiService", 2, "MSG_HOMEWORK_TROOP_CLEAR_RED_POINT");
          }
          localObject2 = ((Bundle)localObject3).getString("troopUin");
          localObject3 = ((Bundle)localObject3).getString("type");
          if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!String.valueOf(1104445552).equals(localObject3)) || (HWTroopUtils.a((QQAppInterface)localObject4, (String)localObject2) == 0)) {
            break;
          }
          HWTroopUtils.a((QQAppInterface)localObject4, (String)localObject2);
          break;
          QLog.i("NowAnser_TAG", 4, "TroopMemberApiService----Recive Tool Process Now AnswerH5Page Created");
          NowAnswerPreloadManager.a(true);
          break;
        }
        bool = false;
      }
      continue;
      localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     owi
 * JD-Core Version:    0.7.0.1
 */