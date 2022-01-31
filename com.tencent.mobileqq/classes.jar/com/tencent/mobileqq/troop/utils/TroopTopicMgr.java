package com.tencent.mobileqq.troop.utils;

import ajqs;
import ajqt;
import ajqu;
import ajqw;
import ajqx;
import ajqy;
import ajqz;
import ajra;
import ajrb;
import ajrc;
import ajrd;
import ajre;
import ajrh;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.activity.AbsPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.mobileqq.troop.data.TroopTopicDetailInfo;
import com.tencent.mobileqq.troop.data.TroopTopicDetailInfoManager;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AccountNotMatchException;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body.RichText;

public class TroopTopicMgr
  implements Manager
{
  public static String a;
  public int a;
  protected Handler a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  public TroopTopicDetailInfoManager a;
  protected TroopTopicMgr.PlusProgressRunable a;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap(5);
  public ConcurrentHashMap a;
  public boolean a;
  public long[] a;
  public String[] a;
  protected ConcurrentHashMap b;
  public long[] b;
  protected ConcurrentHashMap c = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = "https://buluo.qq.com/cgi-bin/sbar/post/publishable";
  }
  
  public TroopTopicMgr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopTopicDetailInfoManager = null;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopTopicDetailInfoManager = new TroopTopicDetailInfoManager(this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager);
    b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_TroopTopic", 0).getString("ShareCommentWhiteList", "{}"));
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, String paramString1, ChatActivityFacade.SendMsgParams paramSendMsgParams, String paramString2, int paramInt)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1049);
    localMessageRecord.selfuin = paramQQAppInterface.getCurrentAccountUin();
    localMessageRecord.frienduin = paramString1;
    localMessageRecord.senderuin = paramQQAppInterface.getCurrentAccountUin();
    localMessageRecord.msg = paramString2;
    localMessageRecord.msgtype = -1049;
    localMessageRecord.isread = true;
    localMessageRecord.issend = 1;
    localMessageRecord.istroop = 1;
    localMessageRecord.msgUid = MessageUtils.a(MessageUtils.a());
    paramString1 = paramQQAppInterface.a().a(localMessageRecord.senderuin, 1);
    if ((paramString1 != null) && (!paramString1.isEmpty())) {
      localMessageRecord.shmsgseq = ((ChatMessage)paramString1.get(paramString1.size() - 1)).shmsgseq;
    }
    for (;;)
    {
      localMessageRecord.time = MessageCache.a();
      paramString1 = (MessageForReplyText)localMessageRecord;
      if (paramInt == 2)
      {
        paramSendMsgParams.a.mSourceMsgText = ("[话题评论]" + paramSendMsgParams.a.mSourceMsgText);
        label179:
        paramString1.mSourceMsgInfo = new MessageForReplyText.SourceMsgInfo(paramSendMsgParams.a);
        paramString1.mSourceMsgInfo.mSourceSummaryFlag = 1;
        paramString1.sb = paramString2;
      }
      try
      {
        localMessageRecord.saveExtInfoToExtStr("sens_msg_source_msg_info", HexUtil.a(MessagePkgUtils.a(paramString1.mSourceMsgInfo)));
        if (localMessageRecord.isSend()) {
          ((SVIPHandler)paramQQAppInterface.a(13)).a(localMessageRecord);
        }
        return localMessageRecord;
        localMessageRecord.shmsgseq = Math.abs(new Random().nextInt());
        continue;
        if (paramInt != 3) {
          break label179;
        }
        paramSendMsgParams.a.mType = 1;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(".troop.troop_topic.TroopTopicMgr", 2, QLog.getStackTraceString(paramString1));
          }
        }
      }
    }
  }
  
  public static String a(MessageRecord paramMessageRecord)
  {
    int j = 0;
    JSONObject localJSONObject = new JSONObject();
    label314:
    label319:
    for (;;)
    {
      try
      {
        if ((paramMessageRecord instanceof MessageForStructing))
        {
          localObject = (MessageForStructing)paramMessageRecord;
          if ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg))
          {
            localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
            localJSONObject.put("url", ((AbsShareMsg)localObject).mMsgUrl);
            if (!(localObject instanceof StructMsgForAudioShare)) {
              continue;
            }
            localJSONObject.put("cover", ((AbsShareMsg)localObject).mContentCover);
            localJSONObject.put("title", ((AbsShareMsg)localObject).mContentTitle);
            localJSONObject.put("summary", ((AbsShareMsg)localObject).mContentSummary);
            localJSONObject.put("uin", Long.parseLong(paramMessageRecord.senderuin));
          }
        }
      }
      catch (JSONException paramMessageRecord)
      {
        Object localObject;
        AbsStructMsgElement localAbsStructMsgElement;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(".troop.troop_topic.TroopTopicMgr", 2, "getPostFromMessage JSONException:" + paramMessageRecord.getMessage());
        continue;
        if (!(localAbsStructMsgElement instanceof StructMsgItemSummary)) {
          break label314;
        }
        localJSONObject.put("summary", ((StructMsgItemSummary)localAbsStructMsgElement).b());
        break label314;
        i += 1;
        continue;
      }
      return localJSONObject.toString();
      int i = 0;
      if (i < ((AbsShareMsg)localObject).getItemCount())
      {
        localAbsStructMsgElement = ((AbsShareMsg)localObject).getItemByIndex(i);
        if ((localAbsStructMsgElement instanceof StructMsgItemLayout2))
        {
          localObject = (StructMsgItemLayout2)localAbsStructMsgElement;
          i = j;
          if (i >= ((StructMsgItemLayout2)localObject).a.size()) {
            break label319;
          }
          localAbsStructMsgElement = (AbsStructMsgElement)((StructMsgItemLayout2)localObject).a.get(i);
          if ((localAbsStructMsgElement instanceof StructMsgItemCover))
          {
            localJSONObject.put("cover", ((StructMsgItemCover)localAbsStructMsgElement).u);
            break label314;
          }
          if ((localAbsStructMsgElement instanceof StructMsgItemTitle))
          {
            localJSONObject.put("title", ((StructMsgItemTitle)localAbsStructMsgElement).b());
            break label314;
          }
        }
        i += 1;
      }
    }
  }
  
  private String a(String paramString, long paramLong)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + paramString + "_" + paramLong;
  }
  
  private JSONObject a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_topic", 2, "TroopTopicMgr parsePublishableJson jsonObject is null");
      }
    }
    for (;;)
    {
      return null;
      int i = -1;
      try
      {
        if (paramJSONObject.has("retcode")) {
          i = paramJSONObject.getInt("retcode");
        }
        if (QLog.isColorLevel()) {
          QLog.d(".troop.troop_topic", 2, "TroopTopicMgr parsePublishableJson retCode is " + i);
        }
        if (i == 0)
        {
          JSONObject localJSONObject = paramJSONObject.optJSONObject("result");
          if (localJSONObject != null)
          {
            paramJSONObject = localJSONObject.optString("bid");
            i = localJSONObject.optInt("group_type");
            localJSONObject = localJSONObject.optJSONObject("publish_condition");
            if (localJSONObject != null)
            {
              localJSONObject.put("bid", paramJSONObject);
              localJSONObject.put("groupType", i);
              localJSONObject.put("CgiPublishableTime", System.currentTimeMillis() / 1000L);
              localJSONObject.put("groupUin", paramString);
              return localJSONObject;
            }
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.d(".troop.troop_topic", 2, "TroopTopicMgr parsePublishableJson Exception.", paramJSONObject);
      }
    }
    return null;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr$PlusProgressRunable != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr$PlusProgressRunable);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr$PlusProgressRunable = null;
    }
  }
  
  public static void a(AppInterface paramAppInterface, MessageForTroopTopic paramMessageForTroopTopic)
  {
    if (QLog.isColorLevel()) {
      QLog.i(".troop.troop_topic.TroopTopicMgr", 2, "sendSSORequest cmd=MQUpdateSvc_com_qq_buluo.web.sbar_like");
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("pid", paramMessageForTroopTopic.pid);
      localJSONObject.put("bid", paramMessageForTroopTopic.bid);
      localJSONObject.put("like", 1);
      paramMessageForTroopTopic = new NewIntent(BaseApplicationImpl.getContext(), ProtoServlet.class);
      paramMessageForTroopTopic.putExtra("cmd", "MQUpdateSvc_com_qq_buluo.web.sbar_like");
      WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
      localWebSsoRequestBody.type.set(0);
      localWebSsoRequestBody.data.set(localJSONObject.toString());
      paramMessageForTroopTopic.putExtra("data", localWebSsoRequestBody.toByteArray());
      paramMessageForTroopTopic.setObserver(new ajrd());
      paramAppInterface.startServlet(paramMessageForTroopTopic);
      return;
    }
    catch (Exception paramAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i(".troop.troop_topic.TroopTopicMgr", 2, QLog.getStackTraceString(paramAppInterface));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, MessageRecord paramMessageRecord, String paramString3, ArrayList paramArrayList)
  {
    if ((paramLong < 0L) || (TextUtils.isEmpty(paramString1))) {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.troop_topic.TroopTopicMgr", 2, "error: bid = " + paramLong + ", pid = " + paramString1);
      }
    }
    do
    {
      return;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("bid", paramLong);
        localJSONObject.put("pid", paramString1);
        if (!TextUtils.isEmpty(paramString2)) {
          localJSONObject.put("ref_cid", paramString2);
        }
        localJSONObject.put("cfrom", 1);
        String str = paramString3;
        if ((paramMessageRecord instanceof MessageForReplyText))
        {
          MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramMessageRecord;
          localMessageForReplyText.mGroupPostElemInfo = new TroopTopicMgr.GroupPostElemInfo(1, paramLong, paramString1, paramString2);
          localMessageForReplyText.atInfoList = paramArrayList;
          paramString1 = MessageProtoCodec.a(localMessageForReplyText);
          if (paramString1 != null) {
            localJSONObject.put("comment_richtext", Base64Util.encodeToString(paramString1.toByteArray(), 0));
          }
          str = paramString3;
          if (paramArrayList != null)
          {
            str = paramString3;
            if (paramArrayList.size() > 0)
            {
              paramString1 = (MessageForText.AtTroopMemberInfo)paramArrayList.get(0);
              str = paramString3;
              if (paramString1.uin == localMessageForReplyText.mSourceMsgInfo.mSourceMsgSenderUin)
              {
                int i = paramString1.startPos;
                str = paramString3.substring(paramString1.textLen + i + 1);
              }
            }
          }
        }
        localJSONObject.put("comment", TroopBarPublishUtils.a(new QQText(str, 13).a(), null, null));
        localJSONObject.put("msgRand", MessageUtils.a(paramMessageRecord.msgUid));
        localJSONObject.put("oriMsgSeq", String.valueOf(paramMessageRecord.shmsgseq));
        localJSONObject.put("version", "7.6.3.3565");
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, "commendTopic msgRand = " + MessageUtils.a(paramMessageRecord.msgUid) + ", msgUid = " + paramMessageRecord.msgUid);
        }
        paramString1 = new NewIntent(BaseApplicationImpl.getContext(), ProtoServlet.class);
        paramString1.putExtra("cmd", "MQUpdateSvc_com_qq_buluo.web.sbar_comment");
        paramString2 = new WebSsoBody.WebSsoRequestBody();
        paramString2.type.set(0);
        paramString2.data.set(localJSONObject.toString());
        paramString1.putExtra("data", paramString2.toByteArray());
        paramString1.setObserver(new ajrb(paramQQAppInterface, paramMessageRecord));
        paramQQAppInterface.startServlet(paramString1);
        return;
      }
      catch (Exception paramQQAppInterface) {}
    } while (!QLog.isColorLevel());
    QLog.i(".troop.troop_topic.TroopTopicMgr", 2, QLog.getStackTraceString(paramQQAppInterface));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramQQAppInterface.a().d(paramMessageRecord);
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.a();
    localQQMessageFacade.a(paramMessageRecord, paramQQAppInterface.getCurrentAccountUin());
    localQQMessageFacade.a(paramMessageRecord);
    if (QLog.isColorLevel()) {
      QLog.i(".troop.troop_topic.TroopTopicMgr", 1, "Inser msg to AIO, msgInfo: mrUinseq[" + String.valueOf(paramMessageRecord.uniseq) + "], selfuin[" + FileManagerUtil.e(paramMessageRecord.selfuin) + "], frienduin[" + FileManagerUtil.e(paramMessageRecord.frienduin) + "], senderuin[" + FileManagerUtil.e(paramMessageRecord.senderuin) + "], issend[" + String.valueOf(paramMessageRecord.issend) + "], istroop[" + String.valueOf(paramMessageRecord.istroop) + "], shmsgseq[" + String.valueOf(paramMessageRecord.shmsgseq) + "], msgUid[" + String.valueOf(paramMessageRecord.msgUid) + "], time[" + String.valueOf(paramMessageRecord.time) + "], vipBubbleID[" + String.valueOf(-1) + "]");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, MessageForReplyText paramMessageForReplyText, boolean paramBoolean)
  {
    String str;
    if ((paramMessageForReplyText != null) && (paramMessageForReplyText.mGroupPostElemInfo != null))
    {
      str = paramMessageForReplyText.frienduin;
      if (!paramBoolean) {
        break label53;
      }
    }
    label53:
    for (paramMessageForReplyText = "1";; paramMessageForReplyText = "2")
    {
      ReportController.b(paramQQAppInterface, "dc00899", "Grp_talk", "", paramString1, paramString2, 0, 0, str, paramMessageForReplyText, "", "");
      return;
    }
  }
  
  public static void a(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2, WeakReference paramWeakReference, String paramString)
  {
    PicReq localPicReq;
    int i;
    switch (paramInt2)
    {
    case 3: 
    default: 
      return;
    case 2: 
      localPicReq = PicBusiManager.a(6, 1536, 1);
      i = 1;
    }
    for (;;)
    {
      try
      {
        localPicReq.a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
        String str = AbsDownloader.d(URLDrawableHelper.a(paramMessageForPic, i, null).toString().toString());
        localPicReq.a(new ajqw(paramWeakReference, paramLong, paramInt1, paramInt2, paramMessageForPic.size, str));
        PicBusiManager.a(localPicReq, (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(paramString));
        return;
      }
      catch (AccountNotMatchException paramMessageForPic) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(".troop.troop_topic.TroopTopicMgr", 2, "no appRuntime");
      return;
      localPicReq = PicBusiManager.a(7, 1);
      i = 131075;
      continue;
      localPicReq = PicBusiManager.a(5, 1);
      i = 65537;
    }
  }
  
  private void a(MessageForTroopTopic paramMessageForTroopTopic, TroopTopicDetailInfo paramTroopTopicDetailInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i(".troop.troop_topic.TroopTopicMgr", 2, "sendSSORequest cmd=MQUpdateSvc_com_qq_buluo.web.sbar_aio_content");
    }
    WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
    localWebSsoRequestBody.type.set(0);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("bid", paramMessageForTroopTopic.bid);
      ((JSONObject)localObject).put("pid", paramMessageForTroopTopic.pid);
      localWebSsoRequestBody.data.set(((JSONObject)localObject).toString());
      localObject = new NewIntent(BaseApplicationImpl.getContext(), ProtoServlet.class);
      ((NewIntent)localObject).putExtra("timeout", 5000L);
      ((NewIntent)localObject).putExtra("cmd", "MQUpdateSvc_com_qq_buluo.web.sbar_aio_content");
      ((NewIntent)localObject).putExtra("data", localWebSsoRequestBody.toByteArray());
      ((NewIntent)localObject).setObserver(new ajqu(this, paramTroopTopicDetailInfo, paramMessageForTroopTopic));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet((NewIntent)localObject);
      return;
    }
    catch (JSONException paramMessageForTroopTopic)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(".troop.troop_topic.TroopTopicMgr", 2, paramMessageForTroopTopic.toString());
    }
  }
  
  private void a(MessageRecord paramMessageRecord, TroopTopicDetailInfo paramTroopTopicDetailInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i(".troop.troop_topic.TroopTopicMgr", 2, "sendSSORequest cmd=MQUpdateSvc_com_qq_buluo.web.sbar_post_extinfo");
    }
    WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
    localWebSsoRequestBody.type.set(0);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if ((paramMessageRecord instanceof MessageForTroopTopic))
        {
          MessageForTroopTopic localMessageForTroopTopic = (MessageForTroopTopic)paramMessageRecord;
          localJSONObject.put("bid", localMessageForTroopTopic.bid);
          localJSONObject.put("pid", localMessageForTroopTopic.pid);
          localWebSsoRequestBody.data.set(localJSONObject.toString());
          ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ajre(this, paramTroopTopicDetailInfo, paramMessageRecord), localWebSsoRequestBody.toByteArray(), "MQUpdateSvc_com_qq_buluo.web.sbar_post_extinfo");
          return;
        }
      }
      catch (JSONException paramMessageRecord)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(".troop.troop_topic.TroopTopicMgr", 2, paramMessageRecord.toString());
      }
      localJSONObject.put("type", 1);
      localJSONObject.put("msgseq", paramMessageRecord.shmsgseq);
      localJSONObject.put("bid", Long.parseLong(paramMessageRecord.frienduin) + 10000000000L);
    }
  }
  
  public static final boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Editable paramEditable, MessageRecord paramMessageRecord, ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    Object localObject1;
    Object localObject2;
    ArrayList localArrayList;
    Object localObject3;
    String str;
    if (paramMessageRecord != null)
    {
      if ((paramMessageRecord instanceof MessageForTroopTopic))
      {
        localObject1 = (MessageForTroopTopic)paramMessageRecord;
        localObject2 = new ArrayList();
        paramEditable = AtTroopMemberSpan.a(paramEditable, (ArrayList)localObject2);
        paramSessionInfo = a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSendMsgParams, paramEditable, 1);
        a(paramQQAppInterface, paramSessionInfo);
        a(paramQQAppInterface, ((MessageForTroopTopic)localObject1).bid, ((MessageForTroopTopic)localObject1).pid, null, paramSessionInfo, paramEditable, (ArrayList)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d(".troop.troop_topic.TroopTopicMgr", 2, "commend: 评论ok, send uniseq = " + paramSessionInfo.uniseq + ", msg = " + paramEditable);
        }
        ReportController.b(paramQQAppInterface, "dc00899", "Grp_talk", "", "obj", "aio_reply", 0, 0, paramMessageRecord.frienduin + "", "1", "", "");
        return true;
      }
      if (paramSendMsgParams.a.mType == 1)
      {
        localArrayList = new ArrayList();
        paramSendMsgParams.a.mType = 1;
        localObject2 = "";
        localObject1 = null;
        localObject3 = "0";
        str = AtTroopMemberSpan.a(paramEditable, localArrayList);
        if ((paramMessageRecord instanceof MessageForStructing))
        {
          localObject2 = a(paramMessageRecord);
          paramSendMsgParams.a.mRichMsg = ((String)localObject2);
          paramEditable = "0";
          localObject1 = null;
        }
      }
    }
    for (;;)
    {
      paramSessionInfo = a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSendMsgParams, str, 3);
      a(paramQQAppInterface, paramSessionInfo);
      ((TroopTopicMgr)paramQQAppInterface.getManager(97)).a(paramSessionInfo, paramMessageRecord.shmsgseq, str, (String)localObject2, localArrayList, Long.parseLong(paramMessageRecord.frienduin) + 10000000000L, paramEditable, (String)localObject1, 1, new ajrc());
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_topic.TroopTopicMgr", 2, "commend: 评论ok, send uniseq = " + paramMessageRecord.shmsgseq + ", msg = " + str);
      }
      return true;
      if ((paramMessageRecord instanceof MessageForReplyText))
      {
        MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramMessageRecord;
        if (localMessageForReplyText.mSourceMsgInfo == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e(".troop.troop_topic.TroopTopicMgr.troop.troop_topic", 2, "troopTopicCommend,mfrt.mSourceMsgInfo == null");
          }
          return false;
        }
        paramEditable = (Editable)localObject1;
        if (localMessageForReplyText.mGroupPostElemInfo != null)
        {
          paramEditable = (Editable)localObject1;
          if (!TextUtils.isEmpty(localMessageForReplyText.mGroupPostElemInfo.cid)) {
            paramEditable = localMessageForReplyText.mGroupPostElemInfo.cid;
          }
        }
        localObject1 = localObject3;
        if (localMessageForReplyText.mGroupPostElemInfo != null)
        {
          localObject1 = localObject3;
          if (!TextUtils.isEmpty(localMessageForReplyText.mGroupPostElemInfo.pid)) {
            localObject1 = localMessageForReplyText.mGroupPostElemInfo.pid;
          }
        }
        paramSendMsgParams.a.mRichMsg = localMessageForReplyText.mSourceMsgInfo.mRichMsg;
        localObject3 = paramEditable;
        paramEditable = (Editable)localObject1;
        localObject1 = localObject3;
        continue;
        if ((paramMessageRecord instanceof MessageForReplyText))
        {
          localObject1 = (MessageForReplyText)paramMessageRecord;
          if (((MessageForReplyText)localObject1).mGroupPostElemInfo != null)
          {
            localObject2 = new ArrayList();
            paramEditable = AtTroopMemberSpan.a(paramEditable, (ArrayList)localObject2);
            paramSessionInfo = a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString, paramSendMsgParams, paramEditable, 2);
            a(paramQQAppInterface, paramSessionInfo);
            a(paramQQAppInterface, ((MessageForReplyText)localObject1).mGroupPostElemInfo.bid, ((MessageForReplyText)localObject1).mGroupPostElemInfo.pid, ((MessageForReplyText)localObject1).mGroupPostElemInfo.cid, paramSessionInfo, paramEditable, (ArrayList)localObject2);
            if (QLog.isColorLevel()) {
              QLog.d(".troop.troop_topic.TroopTopicMgr", 2, "commend: 二级评论ok, send uniseq = " + paramSessionInfo.uniseq + ", msg = " + paramEditable);
            }
            ReportController.b(paramQQAppInterface, "dc00899", "Grp_talk", "", "obj", "aio_reply", 0, 0, paramMessageRecord.frienduin + "", "2", "", "");
            return true;
          }
        }
        return false;
      }
      else
      {
        paramEditable = "0";
        localObject1 = null;
      }
    }
  }
  
  public TroopTopicDetailInfo a(ChatMessage paramChatMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.i(".troop.troop_topic.TroopTopicMgr", 2, "getTroopShareInfoFromCache");
    }
    paramChatMessage = a(paramChatMessage.frienduin, paramChatMessage.shmsgseq);
    if (paramChatMessage != null) {
      return (TroopTopicDetailInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramChatMessage);
    }
    return null;
  }
  
  public TroopTopicDetailInfo a(MessageForTroopTopic paramMessageForTroopTopic)
  {
    if (QLog.isColorLevel()) {
      QLog.i(".troop.troop_topic.TroopTopicMgr", 2, "getTroopTopicDetailInfo");
    }
    Object localObject = a(paramMessageForTroopTopic.frienduin, paramMessageForTroopTopic.shmsgseq);
    localObject = (TroopTopicDetailInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
    if ((localObject != null) && (((TroopTopicDetailInfo)localObject).detailInfoData != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.troop_topic.TroopTopicMgr", 2, "getTroopTopicDetailInfo has cache");
      }
      if (((TroopTopicDetailInfo)localObject).detailStructMsg == null) {
        ((TroopTopicDetailInfo)localObject).detailStructMsg = StructMsgFactory.a(((TroopTopicDetailInfo)localObject).detailInfoData, 0);
      }
      if (((TroopTopicDetailInfo)localObject).detailStructMsg != null) {
        return localObject;
      }
      if (QLog.isColorLevel()) {
        QLog.i(".troop.troop_topic.TroopTopicMgr", 2, "getTroopTopicDetailInfo parse xml error");
      }
    }
    ThreadManager.post(new ajqt(this, (TroopTopicDetailInfo)localObject, paramMessageForTroopTopic), 8, null, false);
    return null;
  }
  
  public JSONObject a(JSONObject paramJSONObject, ChatMessage paramChatMessage, String paramString, int paramInt)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject != null) {
      try
      {
        localJSONObject = new JSONObject(paramJSONObject.toString());
        if ((paramChatMessage instanceof MessageForText)) {
          localJSONObject.put("content", ((MessageForText)paramChatMessage).sb);
        }
        for (;;)
        {
          if (localJSONObject == null) {
            break label171;
          }
          localJSONObject.put("topicFrom", String.valueOf(paramInt));
          break label171;
          if (!(paramChatMessage instanceof MessageForLongMsg)) {
            break;
          }
          localJSONObject.put("content", ((MessageForLongMsg)paramChatMessage).sb);
        }
      }
      catch (JSONException paramChatMessage)
      {
        for (;;)
        {
          localJSONObject = paramJSONObject;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(".troop.troop_topic.TroopTopicMgr", 2, QLog.getStackTraceString(paramChatMessage));
          return paramJSONObject;
          if ((paramChatMessage instanceof MessageForPic))
          {
            if (!TextUtils.isEmpty(paramString)) {
              localJSONObject.put("image_list", AbsPublishActivity.a(null, paramString));
            }
          }
          else if ((paramChatMessage instanceof MessageForReplyText)) {
            localJSONObject.put("content", ((MessageForReplyText)paramChatMessage).sb);
          }
        }
      }
    }
    label171:
    return localJSONObject;
  }
  
  public void a(BaseChatPie paramBaseChatPie, String paramString, int paramInt)
  {
    a(paramBaseChatPie, paramString, null, null, paramInt);
  }
  
  public void a(BaseChatPie paramBaseChatPie, String paramString1, ChatMessage paramChatMessage, String paramString2, int paramInt)
  {
    TroopChatPie localTroopChatPie;
    if ((paramBaseChatPie != null) && ((paramBaseChatPie instanceof TroopChatPie)) && (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      localTroopChatPie = (TroopChatPie)paramBaseChatPie;
      paramBaseChatPie = (JSONObject)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
      if (paramBaseChatPie != null)
      {
        long l = paramBaseChatPie.optLong("CgiPublishableTime", 0L);
        if (System.currentTimeMillis() / 1000L - l < 5L) {
          a(localTroopChatPie, a(paramBaseChatPie, paramChatMessage, paramString2, paramInt).toString());
        }
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr$PlusProgressRunable = new TroopTopicMgr.PlusProgressRunable(localTroopChatPie);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopTopicMgr$PlusProgressRunable, 500L);
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    paramBaseChatPie = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    if (paramBaseChatPie != null) {}
    for (paramBaseChatPie = paramBaseChatPie.getSkey(str);; paramBaseChatPie = null)
    {
      HashMap localHashMap = new HashMap();
      Bundle localBundle = new Bundle();
      localBundle.putString("group_type", "2");
      localBundle.putString("group_uin", paramString1);
      localBundle.putString("version", DeviceInfoUtil.d());
      localBundle.putString("Cookie", "uin=" + str + ";skey=" + paramBaseChatPie);
      localBundle.putString("Referer", "https://buluo.qq.com");
      localHashMap.put("BUNDLE", localBundle);
      localHashMap.put("CONTEXT", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext());
      new HttpWebCgiAsyncTask2(jdField_a_of_type_JavaLangString, "POST", new ajqs(this, localTroopChatPie, paramString1, paramChatMessage, paramString2, paramInt), 1000, null).a(localHashMap);
      return;
    }
  }
  
  public void a(TroopChatPie paramTroopChatPie, String paramString)
  {
    Intent localIntent = new Intent(paramTroopChatPie.a, TroopBarPublishActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putString("options", paramString);
    localIntent.putExtras(localBundle);
    paramTroopChatPie.a.startActivityForResult(localIntent, 11001);
    paramTroopChatPie.a.overridePendingTransition(2131034134, 2131034131);
  }
  
  public void a(ChatMessage paramChatMessage, int paramInt, TroopTopicMgr.DoLikeCallback paramDoLikeCallback)
  {
    WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
    localWebSsoRequestBody.type.set(0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("like", 1);
      localJSONObject.put("type", 1);
      localJSONObject.put("lfrom", paramInt);
      localJSONObject.put("msgseq", paramChatMessage.shmsgseq);
      localJSONObject.put("pid", "0");
      localJSONObject.put("bid", Long.parseLong(paramChatMessage.frienduin) + 10000000000L);
      localJSONObject.put("post", a(paramChatMessage));
      localWebSsoRequestBody.data.set(localJSONObject.toString());
      ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ajqz(this, paramDoLikeCallback), localWebSsoRequestBody.toByteArray(), "MQUpdateSvc_com_qq_buluo.web.sbar_like");
      return;
    }
    catch (JSONException paramChatMessage)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(".troop.troop_topic.TroopTopicMgr", 2, paramChatMessage.toString());
    }
  }
  
  public void a(MessageForTroopTopic paramMessageForTroopTopic)
  {
    if (paramMessageForTroopTopic == null) {}
    for (;;)
    {
      return;
      Vector localVector;
      if (this.c.containsKey(paramMessageForTroopTopic.frienduin)) {
        localVector = (Vector)this.c.get(paramMessageForTroopTopic.frienduin);
      }
      while (!localVector.contains(paramMessageForTroopTopic))
      {
        localVector.add(paramMessageForTroopTopic);
        return;
        localVector = new Vector();
        this.c.put(paramMessageForTroopTopic.frienduin, localVector);
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.i(".troop.troop_topic.TroopTopicMgr.troop.troop_topic", 2, "syncTroopTopicMsg");
    }
    a(paramMessageRecord, a(paramMessageRecord.frienduin, paramMessageRecord.shmsgseq));
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong1, String paramString1, String paramString2, ArrayList paramArrayList, long paramLong2, String paramString3, String paramString4, int paramInt, TroopTopicMgr.WriteCommentCallback paramWriteCommentCallback)
  {
    WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
    localWebSsoRequestBody.type.set(0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        localJSONObject.put("type", 1);
        localJSONObject.put("post", paramString2);
      }
      localJSONObject.put("msgseq", paramLong1);
      localJSONObject.put("bid", paramLong2);
      localJSONObject.put("pid", paramString3);
      if (!TextUtils.isEmpty(paramString4)) {
        localJSONObject.put("ref_cid", paramString4);
      }
      localJSONObject.put("cfrom", paramInt);
      paramString2 = paramString1;
      if ((paramMessageRecord instanceof MessageForReplyText))
      {
        MessageForReplyText localMessageForReplyText = (MessageForReplyText)paramMessageRecord;
        localMessageForReplyText.mGroupPostElemInfo = new TroopTopicMgr.GroupPostElemInfo(1, paramLong2, paramString3, paramString4);
        localMessageForReplyText.atInfoList = paramArrayList;
        paramString2 = MessageProtoCodec.a(localMessageForReplyText);
        if (paramString2 != null) {
          localJSONObject.put("comment_richtext", Base64Util.encodeToString(paramString2.toByteArray(), 0));
        }
        paramString2 = paramString1;
        if (paramArrayList != null)
        {
          paramString2 = paramString1;
          if (paramArrayList.size() > 0)
          {
            paramArrayList = (MessageForText.AtTroopMemberInfo)paramArrayList.get(0);
            paramString2 = paramString1;
            if (paramArrayList.uin == localMessageForReplyText.mSourceMsgInfo.mSourceMsgSenderUin)
            {
              paramInt = paramArrayList.startPos;
              paramString2 = paramString1.substring(paramArrayList.textLen + paramInt + 1);
            }
          }
        }
      }
      localJSONObject.put("comment", TroopBarPublishUtils.a(new QQText(paramString2, 13).a(), null, null));
      localJSONObject.put("msgRand", MessageUtils.a(paramMessageRecord.msgUid));
      localJSONObject.put("oriMsgSeq", String.valueOf(paramMessageRecord.shmsgseq));
      localJSONObject.put("version", "7.6.3.3565");
      localWebSsoRequestBody.data.set(localJSONObject.toString());
      ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ajqy(this, paramWriteCommentCallback, paramMessageRecord), localWebSsoRequestBody.toByteArray(), "MQUpdateSvc_com_qq_buluo.web.sbar_comment");
      return;
    }
    catch (JSONException paramMessageRecord)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(".troop.troop_topic.TroopTopicMgr", 2, paramMessageRecord.toString());
    }
  }
  
  public void a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    String str = a(paramMessageRecord.frienduin, paramMessageRecord.shmsgseq);
    TroopTopicDetailInfo localTroopTopicDetailInfo;
    boolean bool;
    if (!paramBoolean)
    {
      localTroopTopicDetailInfo = (TroopTopicDetailInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      if (localTroopTopicDetailInfo != null) {
        if ((paramMessageRecord instanceof MessageForTroopTopic))
        {
          MessageForTroopTopic localMessageForTroopTopic = (MessageForTroopTopic)paramMessageRecord;
          if (localMessageForTroopTopic.pVersion < localTroopTopicDetailInfo.pVersion)
          {
            if (QLog.isColorLevel()) {
              QLog.i(".troop.troop_topic.TroopTopicMgr", 2, "syncTopicExtInfo cache hit, need update. message.frienduin:" + paramMessageRecord.frienduin + " message.shmsgseq:" + paramMessageRecord.shmsgseq + " detailInfo.msgSeq:" + localTroopTopicDetailInfo.msgSeq + " message.pVerion:" + localMessageForTroopTopic.pVersion + " detailInfo.pVersion:" + localTroopTopicDetailInfo.pVersion);
            }
            bool = true;
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Long.valueOf(NetConnInfoCenter.getServerTime()));
      if ((paramBoolean) || (bool))
      {
        if (QLog.isColorLevel()) {
          QLog.i(".troop.troop_topic.TroopTopicMgr", 2, "syncTopicExtInfo update, forceUpdate=" + paramBoolean + " needUpdate=" + bool);
        }
        a(paramMessageRecord, localTroopTopicDetailInfo);
        do
        {
          do
          {
            return;
          } while (!QLog.isColorLevel());
          QLog.i(".troop.troop_topic.TroopTopicMgr", 2, "syncTopicExtInfo cache hit, no update");
          return;
          if (localTroopTopicDetailInfo.pVersion != localTroopTopicDetailInfo.mOldVersion)
          {
            if (QLog.isColorLevel()) {
              QLog.i(".troop.troop_topic.TroopTopicMgr", 2, "syncTopicExtInfo cache hit 2, need update. message.frienduin:" + paramMessageRecord.frienduin + " detailInfo.msgSeq:" + localTroopTopicDetailInfo.msgSeq + " detailInfo.pVersion:" + localTroopTopicDetailInfo.pVersion);
            }
            bool = true;
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i(".troop.troop_topic.TroopTopicMgr", 2, "syncTopicExtInfo cache hit, no update 2");
        return;
      }
      ThreadManager.post(new ajra(this, paramMessageRecord), 8, null, true);
      return;
      bool = false;
      continue;
      bool = false;
      localTroopTopicDetailInfo = null;
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!this.c.containsKey(paramString)) {
      return;
    }
    Iterator localIterator = ((Vector)this.c.get(paramString)).iterator();
    while (localIterator.hasNext()) {
      ((MessageForTroopTopic)localIterator.next()).isExpand = false;
    }
    this.c.remove(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_topic.TroopTopicMgr", 2, "configURL = " + paramString);
    }
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = new File(AppConstants.ba);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      localObject = AppConstants.ba + "troopsharecommentwhitelist.tmp";
      paramString = new DownloadTask(paramString, new File((String)localObject));
      paramString.b = 3;
      Bundle localBundle = new Bundle();
      localBundle.putString("filePath", (String)localObject);
      ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(1).a(paramString, new ajqx(this, paramInt), localBundle);
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    ThreadManager.post(new ajrh(this, paramString, paramLong1, paramLong2), 8, null, false);
  }
  
  public boolean a(long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (this.jdField_a_of_type_ArrayOfLong != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ArrayOfLong.length > 0) {
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < this.jdField_a_of_type_ArrayOfLong.length)
      {
        if (this.jdField_a_of_type_ArrayOfLong[i] == paramLong) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean a(TroopTopicDetailInfo paramTroopTopicDetailInfo)
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopTopicDetailInfoManager.a(paramTroopTopicDetailInfo);
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0)
      {
        bool1 = bool2;
        if (TextUtils.isEmpty(paramString)) {}
      }
    }
    for (;;)
    {
      try
      {
        paramString = new URL(paramString.toLowerCase()).getHost();
        bool1 = bool2;
        if (!TextUtils.isEmpty(paramString))
        {
          i = 0;
          bool1 = bool2;
          if (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
          {
            bool1 = paramString.endsWith(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
            if (!bool1) {
              continue;
            }
            bool1 = true;
          }
        }
      }
      catch (MalformedURLException paramString)
      {
        int i;
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(".troop.troop_topic.TroopTopicMgr", 2, "isDomainInWhiteList exception: " + paramString.getMessage());
      }
      return bool1;
      i += 1;
    }
    return false;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    paramString = (Long)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(a(paramString, paramLong));
    return (paramString == null) || (paramString.longValue() < NetConnInfoCenter.getServerTime() - 900L);
  }
  
  public void b(String paramString)
  {
    int j = 0;
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_Int = paramString.optInt("version");
      JSONArray localJSONArray1 = paramString.optJSONArray("appid");
      JSONArray localJSONArray2 = paramString.optJSONArray("domain");
      JSONArray localJSONArray3 = paramString.optJSONArray("sender");
      int i;
      if ((localJSONArray1 != null) && (localJSONArray1.length() > 0))
      {
        this.jdField_a_of_type_ArrayOfLong = new long[localJSONArray1.length()];
        i = 0;
        while (i < localJSONArray1.length())
        {
          this.jdField_a_of_type_ArrayOfLong[i] = Long.parseLong(localJSONArray1.getString(i));
          i += 1;
        }
      }
      if ((localJSONArray2 != null) && (localJSONArray2.length() > 0))
      {
        this.jdField_a_of_type_ArrayOfJavaLangString = new String[localJSONArray2.length()];
        i = 0;
        while (i < localJSONArray2.length())
        {
          this.jdField_a_of_type_ArrayOfJavaLangString[i] = localJSONArray2.getString(i).toLowerCase();
          i += 1;
        }
      }
      if ((localJSONArray3 != null) && (localJSONArray3.length() > 0))
      {
        this.jdField_b_of_type_ArrayOfLong = new long[localJSONArray3.length()];
        i = j;
        while (i < localJSONArray3.length())
        {
          this.jdField_b_of_type_ArrayOfLong[i] = Long.parseLong(localJSONArray3.getString(i));
          i += 1;
        }
      }
      this.jdField_a_of_type_Boolean = paramString.optBoolean("disable", false);
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(".troop.troop_topic.TroopTopicMgr", 2, "loadWhiteList exception: " + paramString.getMessage());
      return;
    }
    catch (NumberFormatException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d(".troop.troop_topic.TroopTopicMgr", 2, "loadWhiteList exception: " + paramString.getStackTrace());
    }
  }
  
  public boolean b(long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (this.jdField_b_of_type_ArrayOfLong != null)
    {
      bool1 = bool2;
      if (this.jdField_b_of_type_ArrayOfLong.length > 0) {
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < this.jdField_b_of_type_ArrayOfLong.length)
      {
        if (this.jdField_b_of_type_ArrayOfLong[i] == paramLong) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean b(TroopTopicDetailInfo paramTroopTopicDetailInfo)
  {
    boolean bool = false;
    String str = a(paramTroopTopicDetailInfo.troopUin, paramTroopTopicDetailInfo.msgSeq);
    if (str != null)
    {
      TroopTopicDetailInfo localTroopTopicDetailInfo = (TroopTopicDetailInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      if ((localTroopTopicDetailInfo == null) || (paramTroopTopicDetailInfo.detailStructMsg == null)) {
        break label57;
      }
      localTroopTopicDetailInfo.pVersion = paramTroopTopicDetailInfo.pVersion;
    }
    for (;;)
    {
      bool = true;
      return bool;
      label57:
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramTroopTopicDetailInfo);
    }
  }
  
  public void onDestroy()
  {
    a();
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopTopicMgr
 * JD-Core Version:    0.7.0.1
 */