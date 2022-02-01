package com.tencent.mobileqq.profilecard.bussiness.anonymous.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.bean.AnonymousQuestion;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0xec9.oidb_0xec9.ReqBody;
import tencent.im.oidb.cmd0xec9.oidb_0xec9.RspBody;
import tencent.im.oidb.cmd0xecf.oidb_0xecf.Quest;
import tencent.im.oidb.cmd0xecf.oidb_0xecf.ReqBody;
import tencent.im.oidb.cmd0xecf.oidb_0xecf.RspBody;
import tencent.im.oidb.cmd0xee5.oidb_0xee5.QuestTimes;
import tencent.im.oidb.cmd0xee5.oidb_0xee5.ReqBody;
import tencent.im.oidb.cmd0xee5.oidb_0xee5.RspBody;
import tencent.im.oidb.oidb_0xf15.oidb_0xf15.AddReply;
import tencent.im.oidb.oidb_0xf15.oidb_0xf15.AddRequest;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class AnonymousHandler
  extends BusinessHandler
{
  private static final int ACTION_TYPE_CANCEL = 2;
  private static final int ACTION_TYPE_LIKE = 1;
  public static final String CMD_BROWSE_ASK_ANONYMOUSLY_REPORT = "OidbSvc.0xee5";
  public static final String CMD_GET_LATEST_ANONYMOUS_INFO = "OidbSvc.0xecf";
  public static final String CMD_LIKE_ANONYMOUS_ANSWER = "OidbSvc.0xec9";
  public static final String CMD_REPLY_TROOP_ASK_ANONYMOUSLY = "OidbSvc.0xf15";
  private static final String TAG = "AnonymousHandler";
  
  protected AnonymousHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void handleBrowseAskAnonymouslyReport(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() != 0) {
          break label134;
        }
        i = 1;
        if (i != 0)
        {
          new oidb_0xee5.RspBody().mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          bool = true;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("AnonymousHandler", 1, "handleBrowseAskAnonymouslyReport fail.", paramToServiceMsg);
      }
      boolean bool = false;
      if (QLog.isColorLevel()) {
        QLog.d("AnonymousHandler", 2, String.format("handleBrowseAskAnonymouslyReport success=%s", new Object[] { Boolean.valueOf(bool) }));
      }
      notifyUI(2, bool, null);
      return;
      label134:
      int i = 0;
    }
  }
  
  private void handleGetLatestAnonymousInfo(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() != 0) {
          break label378;
        }
        i = 1;
        if (i != 0)
        {
          paramFromServiceMsg = new oidb_0xecf.RspBody();
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          try
          {
            paramToServiceMsg = (oidb_0xecf.Quest)paramFromServiceMsg.msg_quest.get();
            paramFromServiceMsg = paramToServiceMsg.str_id.get();
            bool = paramToServiceMsg.uint64_praise_num.has();
            long l3 = 0L;
            if (!bool) {
              break label384;
            }
            l1 = paramToServiceMsg.uint64_praise_num.get();
            if ((!paramToServiceMsg.uint64_been_praised.has()) || (paramToServiceMsg.uint64_been_praised.get() != 1L)) {
              break label390;
            }
            bool = true;
            if (!paramToServiceMsg.uint64_comment_num.has()) {
              break label396;
            }
            l2 = paramToServiceMsg.uint64_comment_num.get();
            if (paramToServiceMsg.uint64_show_times.has()) {
              l3 = paramToServiceMsg.uint64_show_times.get();
            }
            if (QLog.isColorLevel()) {
              QLog.d("AnonymousHandler", 2, String.format("handleGetLatestAnonymousInfo result data:questId=%s, praiseNum=%s, praised=%s, commentNum=%s, showTimes=%s:", new Object[] { paramFromServiceMsg, Long.valueOf(l1), Boolean.valueOf(bool), Long.valueOf(l2), Long.valueOf(l3) }));
            }
            notifyUI(3, true, new Object[] { paramFromServiceMsg, Long.valueOf(l1), Boolean.valueOf(bool), Long.valueOf(l2), Long.valueOf(l3) });
            bool = true;
          }
          catch (Exception paramToServiceMsg)
          {
            bool = true;
            continue;
          }
        }
        else
        {
          notifyUI(3, false, null);
        }
      }
      catch (Exception paramToServiceMsg)
      {
        bool = false;
        QLog.e("AnonymousHandler", 1, "handleGetLatestAnonymousInfo fail.", paramToServiceMsg);
        break label348;
      }
      notifyUI(3, false, null);
      boolean bool = false;
      label348:
      if (QLog.isColorLevel()) {
        QLog.d("AnonymousHandler", 2, String.format("handleGetLatestAnonymousInfo success=%s", new Object[] { Boolean.valueOf(bool) }));
      }
      return;
      label378:
      int i = 0;
      continue;
      label384:
      long l1 = 0L;
      continue;
      label390:
      bool = false;
      continue;
      label396:
      long l2 = 0L;
    }
  }
  
  private void handleLikeAnonymousAnswer(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() != 0) {
          break label134;
        }
        i = 1;
        if (i != 0)
        {
          new oidb_0xec9.RspBody().mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          bool = true;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("AnonymousHandler", 1, "handleGetOneWayFriendFlag fail.", paramToServiceMsg);
      }
      boolean bool = false;
      if (QLog.isColorLevel()) {
        QLog.d("AnonymousHandler", 2, String.format("handleLikeAnonymousAnswer success=%s", new Object[] { Boolean.valueOf(bool) }));
      }
      notifyUI(1, bool, null);
      return;
      label134:
      int i = 0;
    }
  }
  
  public void browseAskAnonymouslyReport(AnonymousQuestion paramAnonymousQuestion)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousHandler", 2, String.format("browserAskAnonymouslyReport question=%s", new Object[] { paramAnonymousQuestion }));
    }
    if (paramAnonymousQuestion != null)
    {
      ArrayList localArrayList = new ArrayList();
      oidb_0xee5.QuestTimes localQuestTimes = new oidb_0xee5.QuestTimes();
      localQuestTimes.str_quest_id.set(paramAnonymousQuestion.mId);
      localQuestTimes.uint64_quest_time.set(paramAnonymousQuestion.mQuestTime);
      localQuestTimes.uint64_show_times.set(0L);
      localQuestTimes.uint64_uin.set(paramAnonymousQuestion.mOwnerUin);
      localArrayList.add(localQuestTimes);
      paramAnonymousQuestion = new oidb_0xee5.ReqBody();
      paramAnonymousQuestion.rpt_quest.set(localArrayList);
      sendPbReq(makeOIDBPkg("OidbSvc.0xee5", 3813, 2, paramAnonymousQuestion.toByteArray()));
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0xec9");
      this.allowCmdSet.add("OidbSvc.0xee5");
      this.allowCmdSet.add("OidbSvc.0xecf");
      this.allowCmdSet.add("OidbSvc.0xf15");
    }
    return this.allowCmdSet;
  }
  
  public void getLatestAnonymousInfo(AnonymousQuestion paramAnonymousQuestion)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousHandler", 2, String.format("getLatestAnonymousInfo question=%s", new Object[] { paramAnonymousQuestion }));
    }
    if (paramAnonymousQuestion != null)
    {
      oidb_0xecf.ReqBody localReqBody = new oidb_0xecf.ReqBody();
      localReqBody.str_quest_id.set(paramAnonymousQuestion.mId);
      localReqBody.uint64_comment_num.set(0L);
      localReqBody.uint64_no_cache.set(0L);
      localReqBody.uint64_quest_time.set(paramAnonymousQuestion.mQuestTime);
      localReqBody.uint64_uin.set(paramAnonymousQuestion.mOwnerUin);
      sendPbReq(makeOIDBPkg("OidbSvc.0xecf", 3791, 3, localReqBody.toByteArray()));
    }
  }
  
  public void handleReplyTroopAskAnonymously(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() != 0) {
          break label204;
        }
        i = 1;
        if (i != 0)
        {
          paramFromServiceMsg = new oidb_0xf15.AddReply();
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          try
          {
            long l = paramFromServiceMsg.answer_id.get();
            if (QLog.isColorLevel()) {
              QLog.d("AnonymousHandler", 2, "handleReplyTroopAskAnonymously result");
            }
            notifyUI(4, true, Long.valueOf(l));
            bool = true;
          }
          catch (Exception paramToServiceMsg)
          {
            bool = true;
            continue;
          }
        }
        else
        {
          QLog.e("AnonymousHandler", 1, "handleReplyTroopAskAnonymously result = pkg.uint32_result.get().");
          notifyUI(4, false, null);
        }
      }
      catch (Exception paramToServiceMsg)
      {
        bool = false;
        QLog.e("AnonymousHandler", 1, "handleReplyTroopAskAnonymously fail.", paramToServiceMsg);
        break label173;
      }
      notifyUI(4, false, null);
      boolean bool = false;
      label173:
      if (QLog.isColorLevel()) {
        QLog.d("AnonymousHandler", 2, String.format("handleReplyTroopAskAnonymously success=%s", new Object[] { Boolean.valueOf(bool) }));
      }
      return;
      label204:
      int i = 0;
    }
  }
  
  public void likeAnonymousAnswer(AnonymousQuestion paramAnonymousQuestion, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousHandler", 2, String.format("likeAnonymousAnswer question=%s like=%s", new Object[] { paramAnonymousQuestion, Boolean.valueOf(paramBoolean) }));
    }
    if (paramAnonymousQuestion != null)
    {
      oidb_0xec9.ReqBody localReqBody = new oidb_0xec9.ReqBody();
      localReqBody.uint64_uin.set(paramAnonymousQuestion.mOwnerUin);
      localReqBody.str_quest_id.set(paramAnonymousQuestion.mId);
      localReqBody.str_like_key.set(paramAnonymousQuestion.mPraiseKey);
      PBUInt64Field localPBUInt64Field = localReqBody.uint64_act_type;
      long l;
      if (paramBoolean) {
        l = 1L;
      } else {
        l = 2L;
      }
      localPBUInt64Field.set(l);
      localReqBody.uint64_quest_time.set(paramAnonymousQuestion.mQuestTime);
      sendPbReq(makeOIDBPkg("OidbSvc.0xec9", 3785, 1, localReqBody.toByteArray()));
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return AnonymousObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if ("OidbSvc.0xec9".equals(str))
    {
      handleLikeAnonymousAnswer(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xee5".equals(str))
    {
      handleBrowseAskAnonymouslyReport(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xecf".equals(str))
    {
      handleGetLatestAnonymousInfo(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xf15".equals(str)) {
      handleReplyTroopAskAnonymously(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void replyTroopAskAnonymously(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousHandler", 2, String.format("replyTroopAskAnonymously groupCode=%s questId=%s reply=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString }));
    }
    oidb_0xf15.AddRequest localAddRequest = new oidb_0xf15.AddRequest();
    localAddRequest.group_code.set(paramLong1);
    localAddRequest.question_id.set(paramLong2);
    localAddRequest.reply.set(paramString);
    sendPbReq(makeOIDBPkg("OidbSvc.0xf15", 3861, 1, localAddRequest.toByteArray()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousHandler
 * JD-Core Version:    0.7.0.1
 */