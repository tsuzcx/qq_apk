package com.tencent.mobileqq.profilecard.bussiness.anonymous.handler;

import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
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
import tencent.im.oidb.cmd0xecf.oidb_0xecf.ReqBody;
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
  protected static final int NOTIFY_BROWSE_ASK_ANONYMOUSLY_REPORT = 2;
  protected static final int NOTIFY_GET_LATEST_ANONYMOUS_INFO = 3;
  protected static final int NOTIFY_LIKE_ANONYMOUS_ANSWER = 1;
  protected static final int NOTIFY_REPLY_TROOP_ASK_ANONYMOUSLY = 4;
  private static final String TAG = "AnonymousHandler";
  
  protected AnonymousHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
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
        int i;
        if (paramToServiceMsg.uint32_result.get() == 0)
        {
          i = 1;
          if (i != 0)
          {
            new oidb_0xee5.RspBody().mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
            bool = true;
            if (QLog.isColorLevel()) {
              QLog.d("AnonymousHandler", 2, String.format("handleBrowseAskAnonymouslyReport success=%s", new Object[] { Boolean.valueOf(bool) }));
            }
            notifyUI(2, bool, null);
          }
        }
        else
        {
          i = 0;
          continue;
        }
        boolean bool = false;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("AnonymousHandler", 1, "handleBrowseAskAnonymouslyReport fail.", paramToServiceMsg);
      }
    }
  }
  
  /* Error */
  private void handleGetLatestAnonymousInfo(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 5
    //   6: aload_1
    //   7: ifnull +369 -> 376
    //   10: aload_2
    //   11: ifnull +365 -> 376
    //   14: aload_2
    //   15: invokevirtual 47	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   18: ifeq +358 -> 376
    //   21: new 49	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   24: dup
    //   25: invokespecial 52	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   28: astore_1
    //   29: aload_1
    //   30: aload_3
    //   31: checkcast 54	[B
    //   34: checkcast 54	[B
    //   37: invokevirtual 58	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   40: pop
    //   41: aload_1
    //   42: getfield 62	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   45: invokevirtual 68	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   48: ifne +271 -> 319
    //   51: iconst_1
    //   52: istore 4
    //   54: iload 4
    //   56: ifeq +293 -> 349
    //   59: new 125	tencent/im/oidb/cmd0xecf/oidb_0xecf$RspBody
    //   62: dup
    //   63: invokespecial 126	tencent/im/oidb/cmd0xecf/oidb_0xecf$RspBody:<init>	()V
    //   66: astore_2
    //   67: aload_2
    //   68: aload_1
    //   69: getfield 75	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   72: invokevirtual 80	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   75: invokevirtual 86	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   78: invokevirtual 127	tencent/im/oidb/cmd0xecf/oidb_0xecf$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   81: pop
    //   82: aload_2
    //   83: getfield 131	tencent/im/oidb/cmd0xecf/oidb_0xecf$RspBody:msg_quest	Ltencent/im/oidb/cmd0xecf/oidb_0xecf$Quest;
    //   86: invokevirtual 136	tencent/im/oidb/cmd0xecf/oidb_0xecf$Quest:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   89: checkcast 133	tencent/im/oidb/cmd0xecf/oidb_0xecf$Quest
    //   92: astore_1
    //   93: aload_1
    //   94: getfield 140	tencent/im/oidb/cmd0xecf/oidb_0xecf$Quest:str_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   97: invokevirtual 145	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   100: astore_2
    //   101: aload_1
    //   102: getfield 149	tencent/im/oidb/cmd0xecf/oidb_0xecf$Quest:uint64_praise_num	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   105: invokevirtual 154	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   108: ifeq +217 -> 325
    //   111: aload_1
    //   112: getfield 149	tencent/im/oidb/cmd0xecf/oidb_0xecf$Quest:uint64_praise_num	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   115: invokevirtual 157	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   118: lstore 7
    //   120: aload_1
    //   121: getfield 160	tencent/im/oidb/cmd0xecf/oidb_0xecf$Quest:uint64_been_praised	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   124: invokevirtual 154	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   127: ifeq +204 -> 331
    //   130: aload_1
    //   131: getfield 160	tencent/im/oidb/cmd0xecf/oidb_0xecf$Quest:uint64_been_praised	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   134: invokevirtual 157	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   137: lconst_1
    //   138: lcmp
    //   139: ifne +192 -> 331
    //   142: iconst_1
    //   143: istore 5
    //   145: aload_1
    //   146: getfield 163	tencent/im/oidb/cmd0xecf/oidb_0xecf$Quest:uint64_comment_num	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   149: invokevirtual 154	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   152: ifeq +185 -> 337
    //   155: aload_1
    //   156: getfield 163	tencent/im/oidb/cmd0xecf/oidb_0xecf$Quest:uint64_comment_num	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   159: invokevirtual 157	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   162: lstore 9
    //   164: aload_1
    //   165: getfield 166	tencent/im/oidb/cmd0xecf/oidb_0xecf$Quest:uint64_show_times	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   168: invokevirtual 154	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   171: ifeq +172 -> 343
    //   174: aload_1
    //   175: getfield 166	tencent/im/oidb/cmd0xecf/oidb_0xecf$Quest:uint64_show_times	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   178: invokevirtual 157	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   181: lstore 11
    //   183: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   186: ifeq +54 -> 240
    //   189: ldc 31
    //   191: iconst_2
    //   192: ldc 168
    //   194: iconst_5
    //   195: anewarray 96	java/lang/Object
    //   198: dup
    //   199: iconst_0
    //   200: aload_2
    //   201: aastore
    //   202: dup
    //   203: iconst_1
    //   204: lload 7
    //   206: invokestatic 173	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   209: aastore
    //   210: dup
    //   211: iconst_2
    //   212: iload 5
    //   214: invokestatic 102	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   217: aastore
    //   218: dup
    //   219: iconst_3
    //   220: lload 9
    //   222: invokestatic 173	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   225: aastore
    //   226: dup
    //   227: iconst_4
    //   228: lload 11
    //   230: invokestatic 173	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   233: aastore
    //   234: invokestatic 108	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   237: invokestatic 112	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: aload_0
    //   241: iconst_3
    //   242: iconst_1
    //   243: iconst_5
    //   244: anewarray 96	java/lang/Object
    //   247: dup
    //   248: iconst_0
    //   249: aload_2
    //   250: aastore
    //   251: dup
    //   252: iconst_1
    //   253: lload 7
    //   255: invokestatic 173	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   258: aastore
    //   259: dup
    //   260: iconst_2
    //   261: iload 5
    //   263: invokestatic 102	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   266: aastore
    //   267: dup
    //   268: iconst_3
    //   269: lload 9
    //   271: invokestatic 173	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   274: aastore
    //   275: dup
    //   276: iconst_4
    //   277: lload 11
    //   279: invokestatic 173	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   282: aastore
    //   283: invokevirtual 116	com/tencent/mobileqq/profilecard/bussiness/anonymous/handler/AnonymousHandler:notifyUI	(IZLjava/lang/Object;)V
    //   286: iconst_1
    //   287: istore 5
    //   289: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   292: ifeq +26 -> 318
    //   295: ldc 31
    //   297: iconst_2
    //   298: ldc 175
    //   300: iconst_1
    //   301: anewarray 96	java/lang/Object
    //   304: dup
    //   305: iconst_0
    //   306: iload 5
    //   308: invokestatic 102	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   311: aastore
    //   312: invokestatic 108	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   315: invokestatic 112	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: return
    //   319: iconst_0
    //   320: istore 4
    //   322: goto -268 -> 54
    //   325: lconst_0
    //   326: lstore 7
    //   328: goto -208 -> 120
    //   331: iconst_0
    //   332: istore 5
    //   334: goto -189 -> 145
    //   337: lconst_0
    //   338: lstore 9
    //   340: goto -176 -> 164
    //   343: lconst_0
    //   344: lstore 11
    //   346: goto -163 -> 183
    //   349: aload_0
    //   350: iconst_3
    //   351: iconst_0
    //   352: aconst_null
    //   353: invokevirtual 116	com/tencent/mobileqq/profilecard/bussiness/anonymous/handler/AnonymousHandler:notifyUI	(IZLjava/lang/Object;)V
    //   356: goto -67 -> 289
    //   359: astore_1
    //   360: iload 6
    //   362: istore 5
    //   364: ldc 31
    //   366: iconst_1
    //   367: ldc 177
    //   369: aload_1
    //   370: invokestatic 122	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   373: goto -84 -> 289
    //   376: aload_0
    //   377: iconst_3
    //   378: iconst_0
    //   379: aconst_null
    //   380: invokevirtual 116	com/tencent/mobileqq/profilecard/bussiness/anonymous/handler/AnonymousHandler:notifyUI	(IZLjava/lang/Object;)V
    //   383: goto -94 -> 289
    //   386: astore_1
    //   387: iconst_1
    //   388: istore 5
    //   390: goto -26 -> 364
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	393	0	this	AnonymousHandler
    //   0	393	1	paramToServiceMsg	ToServiceMsg
    //   0	393	2	paramFromServiceMsg	FromServiceMsg
    //   0	393	3	paramObject	Object
    //   52	269	4	i	int
    //   4	385	5	bool1	boolean
    //   1	360	6	bool2	boolean
    //   118	209	7	l1	long
    //   162	177	9	l2	long
    //   181	164	11	l3	long
    // Exception table:
    //   from	to	target	type
    //   21	51	359	java/lang/Exception
    //   59	82	359	java/lang/Exception
    //   349	356	359	java/lang/Exception
    //   82	120	386	java/lang/Exception
    //   120	142	386	java/lang/Exception
    //   145	164	386	java/lang/Exception
    //   164	183	386	java/lang/Exception
    //   183	240	386	java/lang/Exception
    //   240	286	386	java/lang/Exception
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
        int i;
        if (paramToServiceMsg.uint32_result.get() == 0)
        {
          i = 1;
          if (i != 0)
          {
            new oidb_0xec9.RspBody().mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
            bool = true;
            if (QLog.isColorLevel()) {
              QLog.d("AnonymousHandler", 2, String.format("handleLikeAnonymousAnswer success=%s", new Object[] { Boolean.valueOf(bool) }));
            }
            notifyUI(1, bool, null);
          }
        }
        else
        {
          i = 0;
          continue;
        }
        boolean bool = false;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("AnonymousHandler", 1, "handleGetOneWayFriendFlag fail.", paramToServiceMsg);
      }
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
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
      for (;;)
      {
        try
        {
          paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          if (paramToServiceMsg.uint32_result.get() == 0)
          {
            i = 1;
            if (i == 0) {
              continue;
            }
            paramFromServiceMsg = new oidb_0xf15.AddReply();
            paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          }
        }
        catch (Exception paramToServiceMsg)
        {
          int i;
          long l;
          bool = false;
        }
        try
        {
          l = paramFromServiceMsg.answer_id.get();
          if (QLog.isColorLevel()) {
            QLog.d("AnonymousHandler", 2, "handleReplyTroopAskAnonymously result");
          }
          notifyUI(4, true, Long.valueOf(l));
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.d("AnonymousHandler", 2, String.format("handleReplyTroopAskAnonymously success=%s", new Object[] { Boolean.valueOf(bool) }));
          }
          return;
        }
        catch (Exception paramToServiceMsg)
        {
          for (;;)
          {
            bool = true;
          }
        }
        i = 0;
        continue;
        QLog.e("AnonymousHandler", 1, "handleReplyTroopAskAnonymously result = pkg.uint32_result.get().");
        notifyUI(4, false, null);
      }
    }
    for (;;)
    {
      bool = false;
      break;
      QLog.e("AnonymousHandler", 1, "handleReplyTroopAskAnonymously fail.", paramToServiceMsg);
      break;
      notifyUI(4, false, null);
    }
  }
  
  public void likeAnonymousAnswer(AnonymousQuestion paramAnonymousQuestion, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousHandler", 2, String.format("likeAnonymousAnswer question=%s like=%s", new Object[] { paramAnonymousQuestion, Boolean.valueOf(paramBoolean) }));
    }
    oidb_0xec9.ReqBody localReqBody;
    PBUInt64Field localPBUInt64Field;
    if (paramAnonymousQuestion != null)
    {
      localReqBody = new oidb_0xec9.ReqBody();
      localReqBody.uint64_uin.set(paramAnonymousQuestion.mOwnerUin);
      localReqBody.str_quest_id.set(paramAnonymousQuestion.mId);
      localReqBody.str_like_key.set(paramAnonymousQuestion.mPraiseKey);
      localPBUInt64Field = localReqBody.uint64_act_type;
      if (!paramBoolean) {
        break label133;
      }
    }
    label133:
    for (long l = 1L;; l = 2L)
    {
      localPBUInt64Field.set(l);
      localReqBody.uint64_quest_time.set(paramAnonymousQuestion.mQuestTime);
      sendPbReq(makeOIDBPkg("OidbSvc.0xec9", 3785, 1, localReqBody.toByteArray()));
      return;
    }
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return AnonymousObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if ("OidbSvc.0xec9".equals(str)) {
      handleLikeAnonymousAnswer(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
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
    } while (!"OidbSvc.0xf15".equals(str));
    handleReplyTroopAskAnonymously(paramToServiceMsg, paramFromServiceMsg, paramObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.handler.AnonymousHandler
 * JD-Core Version:    0.7.0.1
 */