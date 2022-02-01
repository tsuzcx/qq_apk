package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class MessageForReplyText
  extends ChatMessage
  implements HasSourceMessage
{
  public static final String KEY_BARRAGE_SOURCE_MSG_TYPE = "barrage_source_msg_type";
  public static final String KEY_BARRAGE_TIME_LOCATION = "barrage_time_location";
  public String action;
  public int barrageSourceMsgType;
  public long barrageTimeLocation;
  public boolean isBarrageMsg;
  public boolean mHasPullHistorySourceMsg = false;
  public MessageForReplyText.SourceMsgInfo mSourceMsgInfo;
  public int msgVia;
  public CharSequence sb;
  @notColumn
  private MessageRecord sourceMessage;
  
  public static QQAppInterface getAppInterface()
  {
    if (BaseApplicationImpl.getApplication() != null)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        return (QQAppInterface)localAppRuntime;
      }
    }
    return null;
  }
  
  public static boolean needHideLocate(MessageForReplyText paramMessageForReplyText)
  {
    if (paramMessageForReplyText == null) {}
    while ((UinTypeUtil.b(paramMessageForReplyText.istroop)) && (paramMessageForReplyText.mSourceMsgInfo != null) && ((paramMessageForReplyText.mSourceMsgInfo.origUid == 0L) || (paramMessageForReplyText.mSourceMsgInfo.origUid == -1L))) {
      return true;
    }
    return false;
  }
  
  public static void reportReplyMsg(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, ChatMessage paramChatMessage)
  {
    if (paramSessionInfo.jdField_a_of_type_Int == 0)
    {
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X80095E8", "0X80095E8", 0, 0, "", "", "", "");
      return;
    }
    reportReplyMsg(paramQQAppInterface, "Msg_menu", "clk_replyMsg", paramSessionInfo.jdField_a_of_type_JavaLangString, paramChatMessage);
  }
  
  public static void reportReplyMsg(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, ChatMessage paramChatMessage)
  {
    int i;
    Object localObject;
    if (paramChatMessage != null)
    {
      i = 0;
      switch (paramChatMessage.msgtype)
      {
      default: 
        localObject = "";
      }
    }
    for (;;)
    {
      String str1;
      if (paramChatMessage.istroop == 3000)
      {
        str1 = "Grp_Dis_replyMsg";
        label99:
        String str2 = i + "";
        if (!AnonymousChatHelper.a(paramChatMessage)) {
          break label281;
        }
        paramChatMessage = "1";
        label133:
        ReportController.b(paramQQAppInterface, "P_CliOper", str1, "", paramString1, paramString2, 0, 0, paramString3, str2, paramChatMessage, (String)localObject);
        return;
        i = 0;
        localObject = "";
        continue;
        if (!(paramChatMessage instanceof MessageForStructing)) {
          break label317;
        }
        localObject = (MessageForStructing)paramChatMessage;
        if (((MessageForStructing)localObject).structingMsg == null) {
          break label310;
        }
      }
      label281:
      label310:
      for (localObject = ((MessageForStructing)localObject).structingMsg.mMsgServiceID + "";; localObject = "")
      {
        i = 10;
        break;
        i = 5;
        localObject = "";
        break;
        i = 2;
        localObject = "";
        break;
        i = 3;
        localObject = "";
        break;
        i = 4;
        localObject = "";
        break;
        i = 7;
        localObject = "";
        break;
        str1 = "Grp_replyMsg";
        break label99;
        paramChatMessage = "0";
        break label133;
        ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_replyMsg", "", paramString1, paramString2, 0, 0, paramString3, "", "", "");
        return;
      }
      label317:
      localObject = "";
      i = 10;
    }
  }
  
  public void deepCopySourceMsg(MessageForReplyText paramMessageForReplyText)
  {
    if (paramMessageForReplyText == null)
    {
      QLog.d("Q.msg.", 1, "originMsg is null");
      return;
    }
    this.mSourceMsgInfo = new MessageForReplyText.SourceMsgInfo(paramMessageForReplyText.mSourceMsgInfo);
    paramMessageForReplyText = paramMessageForReplyText.sourceMessage;
    if (paramMessageForReplyText != null) {
      if (paramMessageForReplyText.msgtype == -1037) {
        paramMessageForReplyText = ((MessageForLongMsg)paramMessageForReplyText).rebuildLongMsg(true);
      }
    }
    for (;;)
    {
      if ((paramMessageForReplyText == null) && (QLog.isColorLevel())) {
        QLog.d("Q.msg.", 2, "MessageForReplyText deepCopySourceMsg is null");
      }
      this.sourceMessage = paramMessageForReplyText;
      return;
      if (paramMessageForReplyText.msgtype == -1036)
      {
        paramMessageForReplyText = (MessageForMixedMsg)((MessageForLongMsg)paramMessageForReplyText).rebuildLongMsg();
      }
      else if (paramMessageForReplyText.msgtype == -1035)
      {
        paramMessageForReplyText = ((MessageForMixedMsg)paramMessageForReplyText).rebuildMixedMsg();
      }
      else if (paramMessageForReplyText.msgtype == -2011)
      {
        paramMessageForReplyText = new MessageForStructing(paramMessageForReplyText);
      }
      else
      {
        paramMessageForReplyText = (MessageRecord)paramMessageForReplyText.deepCopyByReflect();
        continue;
        paramMessageForReplyText = null;
      }
    }
  }
  
  /* Error */
  protected void doParse()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 194	com/tencent/mobileqq/data/MessageForReplyText:msg	Ljava/lang/String;
    //   4: ifnonnull +166 -> 170
    //   7: ldc 81
    //   9: astore_2
    //   10: aload_0
    //   11: ldc 196
    //   13: invokevirtual 200	com/tencent/mobileqq/data/MessageForReplyText:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   16: astore_3
    //   17: aload_3
    //   18: invokestatic 206	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifne +162 -> 183
    //   24: aload_3
    //   25: invokestatic 212	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   28: istore_1
    //   29: iload_1
    //   30: ifeq +379 -> 409
    //   33: getstatic 218	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   36: instanceof 220
    //   39: ifne +12 -> 51
    //   42: getstatic 218	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   45: instanceof 222
    //   48: ifeq +361 -> 409
    //   51: iconst_0
    //   52: istore_1
    //   53: aload_0
    //   54: ldc 224
    //   56: invokevirtual 200	com/tencent/mobileqq/data/MessageForReplyText:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   59: astore_3
    //   60: aload_3
    //   61: invokestatic 206	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifne +47 -> 111
    //   67: aload_0
    //   68: getfield 63	com/tencent/mobileqq/data/MessageForReplyText:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   71: ifnonnull +40 -> 111
    //   74: aload_0
    //   75: aload_3
    //   76: invokestatic 230	com/tencent/mobileqq/utils/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   79: invokestatic 235	com/tencent/mobileqq/app/utils/MessagePkgUtils:a	([B)Ljava/lang/Object;
    //   82: checkcast 65	com/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo
    //   85: putfield 63	com/tencent/mobileqq/data/MessageForReplyText:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   88: aload_0
    //   89: getfield 63	com/tencent/mobileqq/data/MessageForReplyText:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   92: ifnull +19 -> 111
    //   95: invokestatic 237	com/tencent/mobileqq/data/MessageForReplyText:getAppInterface	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   98: astore_3
    //   99: aload_0
    //   100: aload_0
    //   101: getfield 63	com/tencent/mobileqq/data/MessageForReplyText:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   104: aload_3
    //   105: invokevirtual 241	com/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo:unPackSourceMsg	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/data/MessageRecord;
    //   108: invokevirtual 244	com/tencent/mobileqq/data/MessageForReplyText:setSourceMessageRecord	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   111: aload_0
    //   112: getstatic 249	com/tencent/mobileqq/service/message/MessageConstants:i	Ljava/lang/String;
    //   115: invokevirtual 200	com/tencent/mobileqq/data/MessageForReplyText:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   118: astore_3
    //   119: aload_3
    //   120: invokestatic 206	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   123: ifne +24 -> 147
    //   126: aload_3
    //   127: invokestatic 255	com/tencent/mobileqq/data/MessageForText:getTroopMemberInfoFromExtrJson	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   130: astore_3
    //   131: aload_3
    //   132: ifnull +15 -> 147
    //   135: aload_3
    //   136: invokevirtual 261	java/util/ArrayList:size	()I
    //   139: ifle +8 -> 147
    //   142: aload_0
    //   143: aload_3
    //   144: putfield 265	com/tencent/mobileqq/data/MessageForReplyText:atInfoList	Ljava/util/ArrayList;
    //   147: aload_0
    //   148: new 267	com/tencent/mobileqq/text/QQText
    //   151: dup
    //   152: aload_2
    //   153: bipush 13
    //   155: invokestatic 271	com/tencent/mobileqq/activity/ChatTextSizeSettingActivity:a	()I
    //   158: aload_0
    //   159: invokespecial 274	com/tencent/mobileqq/text/QQText:<init>	(Ljava/lang/CharSequence;IILjava/lang/Object;)V
    //   162: putfield 276	com/tencent/mobileqq/data/MessageForReplyText:sb	Ljava/lang/CharSequence;
    //   165: iload_1
    //   166: ifne +100 -> 266
    //   169: return
    //   170: aload_0
    //   171: getfield 194	com/tencent/mobileqq/data/MessageForReplyText:msg	Ljava/lang/String;
    //   174: astore_2
    //   175: goto -165 -> 10
    //   178: astore_3
    //   179: aload_3
    //   180: invokevirtual 279	java/lang/Exception:printStackTrace	()V
    //   183: iconst_1
    //   184: istore_1
    //   185: goto -156 -> 29
    //   188: astore_3
    //   189: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq -81 -> 111
    //   195: ldc 145
    //   197: iconst_2
    //   198: new 105	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   205: ldc_w 281
    //   208: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload_3
    //   212: invokevirtual 284	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   215: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: goto -113 -> 111
    //   227: astore_3
    //   228: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   231: ifeq -84 -> 147
    //   234: ldc 145
    //   236: iconst_2
    //   237: new 105	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   244: ldc_w 281
    //   247: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload_3
    //   251: invokevirtual 284	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   254: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: goto -116 -> 147
    //   266: aload_0
    //   267: ldc_w 286
    //   270: invokevirtual 200	com/tencent/mobileqq/data/MessageForReplyText:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   273: astore_3
    //   274: aload_3
    //   275: invokestatic 206	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   278: ifne +70 -> 348
    //   281: aload_0
    //   282: ldc_w 288
    //   285: invokevirtual 200	com/tencent/mobileqq/data/MessageForReplyText:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   288: astore 4
    //   290: aload 4
    //   292: invokestatic 206	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   295: ifne +109 -> 404
    //   298: aload 4
    //   300: ldc 124
    //   302: invokevirtual 293	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   305: ifeq +99 -> 404
    //   308: iconst_1
    //   309: istore_1
    //   310: iload_1
    //   311: ifne +11 -> 322
    //   314: aload_0
    //   315: ldc_w 295
    //   318: aload_2
    //   319: invokevirtual 299	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   322: new 301	java/util/concurrent/CopyOnWriteArrayList
    //   325: dup
    //   326: invokespecial 302	java/util/concurrent/CopyOnWriteArrayList:<init>	()V
    //   329: astore_2
    //   330: aload_2
    //   331: aload_0
    //   332: invokeinterface 308 2 0
    //   337: pop
    //   338: aload_0
    //   339: aload_2
    //   340: iload_1
    //   341: aload_3
    //   342: invokestatic 230	com/tencent/mobileqq/utils/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   345: invokestatic 313	com/tencent/mqp/app/sec/MQPSensitiveMsgUtil:a	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/util/List;Z[B)V
    //   348: aload_0
    //   349: ldc 13
    //   351: invokevirtual 200	com/tencent/mobileqq/data/MessageForReplyText:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   354: astore_2
    //   355: aload_2
    //   356: invokestatic 206	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   359: ifne -190 -> 169
    //   362: aload_0
    //   363: iconst_1
    //   364: putfield 315	com/tencent/mobileqq/data/MessageForReplyText:isBarrageMsg	Z
    //   367: aload_0
    //   368: aload_2
    //   369: invokestatic 321	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   372: invokevirtual 325	java/lang/Long:longValue	()J
    //   375: putfield 327	com/tencent/mobileqq/data/MessageForReplyText:barrageTimeLocation	J
    //   378: aload_0
    //   379: ldc 10
    //   381: invokevirtual 200	com/tencent/mobileqq/data/MessageForReplyText:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   384: astore_2
    //   385: aload_2
    //   386: invokestatic 206	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   389: ifne -220 -> 169
    //   392: aload_0
    //   393: aload_2
    //   394: invokestatic 332	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   397: invokevirtual 335	java/lang/Integer:intValue	()I
    //   400: putfield 337	com/tencent/mobileqq/data/MessageForReplyText:barrageSourceMsgType	I
    //   403: return
    //   404: iconst_0
    //   405: istore_1
    //   406: goto -96 -> 310
    //   409: goto -356 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	412	0	this	MessageForReplyText
    //   28	378	1	bool	boolean
    //   9	385	2	localObject1	Object
    //   16	128	3	localObject2	Object
    //   178	2	3	localException1	Exception
    //   188	24	3	localException2	Exception
    //   227	24	3	localException3	Exception
    //   273	69	3	str1	String
    //   288	11	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   24	29	178	java/lang/Exception
    //   53	111	188	java/lang/Exception
    //   111	131	227	java/lang/Exception
    //   135	147	227	java/lang/Exception
  }
  
  public boolean getHasPulledSourceMsg()
  {
    return this.mHasPullHistorySourceMsg;
  }
  
  public MessageRecord getSourceMessage()
  {
    return this.sourceMessage;
  }
  
  public MessageForReplyText.SourceMsgInfo getSourceMsgInfo()
  {
    return this.mSourceMsgInfo;
  }
  
  public String getSummaryMsg()
  {
    return this.sb.toString();
  }
  
  public boolean isSupportFTS()
  {
    return MsgProxyUtils.m(this.istroop);
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public void postRead()
  {
    super.postRead();
    parse();
  }
  
  public void prewrite()
  {
    serial();
  }
  
  public void serial()
  {
    String str = getExtInfoFromExtStr("sens_msg_original_text");
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = this.msg;
    }
    this.msg = ((String)localObject);
    if (this.msg == null) {}
    for (str = "";; str = this.msg)
    {
      this.msg = str;
      this.msgData = ((String)localObject).getBytes();
      try
      {
        localObject = getAppInterface();
        if ((this.sourceMessage != null) && (localObject != null)) {
          this.mSourceMsgInfo.packSourceMsg((QQAppInterface)localObject, this.sourceMessage);
        }
        saveExtInfoToExtStr("sens_msg_source_msg_info", HexUtil.bytes2HexStr(MessagePkgUtils.a(this.mSourceMsgInfo)));
        if (this.isBarrageMsg)
        {
          saveExtInfoToExtStr("barrage_time_location", String.valueOf(this.barrageTimeLocation));
          saveExtInfoToExtStr("barrage_source_msg_type", String.valueOf(this.barrageSourceMsgType));
        }
        this.extLong |= 0x1;
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("Q.msg.", 2, "prewrite MessageForReplyText exception:" + localException.getMessage());
      }
    }
  }
  
  public void setPulledSourceMsg()
  {
    this.mHasPullHistorySourceMsg = true;
  }
  
  public void setSourceMessageRecord(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    do
    {
      return;
      this.sourceMessage = paramMessageRecord;
      this.sourceMessage.isReplySource = true;
      this.sourceMessage.isMultiMsg = this.isMultiMsg;
      this.sourceMessage.isReMultiMsg = this.isReMultiMsg;
      if ((paramMessageRecord instanceof MessageForMixedMsg))
      {
        Object localObject = (MessageForMixedMsg)paramMessageRecord;
        if (((MessageForMixedMsg)localObject).msgElemList != null)
        {
          localObject = ((MessageForMixedMsg)localObject).msgElemList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
            if (localMessageRecord != null) {
              localMessageRecord.isReplySource = true;
            }
          }
        }
      }
    } while (this.mSourceMsgInfo == null);
    this.mSourceMsgInfo.setUniSeq(paramMessageRecord.uniseq, false);
    paramMessageRecord.uniseq = this.mSourceMsgInfo.getUniSeq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForReplyText
 * JD-Core Version:    0.7.0.1
 */