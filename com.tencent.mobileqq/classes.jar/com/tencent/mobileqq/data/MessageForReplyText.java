package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr.GroupPostElemInfo;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageForReplyText
  extends ChatMessage
{
  public static final String KEY_IS_PLAYED_PIC_GIF = "reply_msg_is_played_pic_gif";
  public String action;
  public TroopTopicMgr.GroupPostElemInfo mGroupPostElemInfo;
  public boolean mHasPullHistorySourceMsg;
  public boolean mIsPlayedPicCommentAnimate;
  public MessageForReplyText.SourceMsgInfo mSourceMsgInfo;
  public int msgVia;
  public CharSequence sb;
  
  public static final String parseMsgToJsonText(ChatMessage paramChatMessage, String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("emoji_id", paramString);
        if ((paramChatMessage instanceof MessageForMixedMsg))
        {
          localJSONObject.put("msg_type", 1);
          localJSONObject.put("submsg_index", paramInt);
          return localJSONObject.toString();
        }
        if ((paramChatMessage instanceof MessageForTroopFile)) {
          localJSONObject.put("msg_type", 2);
        } else {
          localJSONObject.put("msg_type", 0);
        }
      }
      catch (JSONException paramChatMessage)
      {
        if (QLog.isColorLevel()) {
          QLog.e("zivonchen", 2, "MessageForReplyText parseMsgToJsonText error = " + QLog.getStackTraceString(paramChatMessage));
        }
        return null;
      }
    }
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
  
  /* Error */
  protected void doParse()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 131	com/tencent/mobileqq/data/MessageForReplyText:msg	Ljava/lang/String;
    //   6: astore 4
    //   8: aload_0
    //   9: new 133	com/tencent/mobileqq/text/QQText
    //   12: dup
    //   13: aload 4
    //   15: bipush 13
    //   17: bipush 32
    //   19: aload_0
    //   20: invokespecial 136	com/tencent/mobileqq/text/QQText:<init>	(Ljava/lang/CharSequence;IILcom/tencent/mobileqq/data/MessageRecord;)V
    //   23: putfield 138	com/tencent/mobileqq/data/MessageForReplyText:sb	Ljava/lang/CharSequence;
    //   26: aload_0
    //   27: ldc 140
    //   29: invokevirtual 144	com/tencent/mobileqq/data/MessageForReplyText:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore_3
    //   33: aload_3
    //   34: invokestatic 150	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   37: ifne +170 -> 207
    //   40: aload_3
    //   41: invokestatic 156	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   44: istore_1
    //   45: aload_0
    //   46: ldc 8
    //   48: invokevirtual 144	com/tencent/mobileqq/data/MessageForReplyText:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   51: astore_3
    //   52: aload_0
    //   53: iconst_0
    //   54: putfield 158	com/tencent/mobileqq/data/MessageForReplyText:mIsPlayedPicCommentAnimate	Z
    //   57: aload_3
    //   58: invokestatic 150	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   61: ifne +11 -> 72
    //   64: aload_0
    //   65: aload_3
    //   66: invokestatic 156	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   69: putfield 158	com/tencent/mobileqq/data/MessageForReplyText:mIsPlayedPicCommentAnimate	Z
    //   72: iload_1
    //   73: ifeq +323 -> 396
    //   76: getstatic 164	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   79: instanceof 166
    //   82: ifne +12 -> 94
    //   85: getstatic 164	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   88: instanceof 168
    //   91: ifeq +305 -> 396
    //   94: iconst_0
    //   95: istore_1
    //   96: aload_0
    //   97: ldc 170
    //   99: invokevirtual 144	com/tencent/mobileqq/data/MessageForReplyText:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   102: astore_3
    //   103: aload_3
    //   104: invokestatic 150	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   107: ifne +17 -> 124
    //   110: aload_0
    //   111: aload_3
    //   112: invokestatic 175	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)[B
    //   115: invokestatic 180	com/tencent/mobileqq/app/utils/MessagePkgUtils:a	([B)Ljava/lang/Object;
    //   118: checkcast 182	com/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo
    //   121: putfield 184	com/tencent/mobileqq/data/MessageForReplyText:mSourceMsgInfo	Lcom/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo;
    //   124: aload_0
    //   125: ldc 186
    //   127: invokevirtual 144	com/tencent/mobileqq/data/MessageForReplyText:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   130: astore_3
    //   131: aload_3
    //   132: invokestatic 150	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   135: ifne +62 -> 197
    //   138: aload_0
    //   139: aload_3
    //   140: invokestatic 175	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)[B
    //   143: invokestatic 180	com/tencent/mobileqq/app/utils/MessagePkgUtils:a	([B)Ljava/lang/Object;
    //   146: checkcast 188	com/tencent/mobileqq/troop/utils/TroopTopicMgr$GroupPostElemInfo
    //   149: putfield 190	com/tencent/mobileqq/data/MessageForReplyText:mGroupPostElemInfo	Lcom/tencent/mobileqq/troop/utils/TroopTopicMgr$GroupPostElemInfo;
    //   152: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq +42 -> 197
    //   158: new 63	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   165: ldc 192
    //   167: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: astore 5
    //   172: aload_0
    //   173: getfield 190	com/tencent/mobileqq/data/MessageForReplyText:mGroupPostElemInfo	Lcom/tencent/mobileqq/troop/utils/TroopTopicMgr$GroupPostElemInfo;
    //   176: ifnonnull +82 -> 258
    //   179: ldc 194
    //   181: astore_3
    //   182: ldc 196
    //   184: iconst_2
    //   185: aload 5
    //   187: aload_3
    //   188: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: iload_1
    //   198: ifne +109 -> 307
    //   201: return
    //   202: astore_3
    //   203: aload_3
    //   204: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   207: iconst_1
    //   208: istore_1
    //   209: goto -164 -> 45
    //   212: astore_3
    //   213: aload_3
    //   214: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   217: goto -145 -> 72
    //   220: astore_3
    //   221: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   224: ifeq -100 -> 124
    //   227: ldc 196
    //   229: iconst_2
    //   230: new 63	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   237: ldc 204
    //   239: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload_3
    //   243: invokevirtual 207	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   246: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   255: goto -131 -> 124
    //   258: aload_0
    //   259: getfield 190	com/tencent/mobileqq/data/MessageForReplyText:mGroupPostElemInfo	Lcom/tencent/mobileqq/troop/utils/TroopTopicMgr$GroupPostElemInfo;
    //   262: invokevirtual 208	com/tencent/mobileqq/troop/utils/TroopTopicMgr$GroupPostElemInfo:toString	()Ljava/lang/String;
    //   265: astore_3
    //   266: goto -84 -> 182
    //   269: astore_3
    //   270: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   273: ifeq -76 -> 197
    //   276: ldc 196
    //   278: iconst_2
    //   279: new 63	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   286: ldc 204
    //   288: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload_3
    //   292: invokevirtual 207	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   295: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   304: goto -107 -> 197
    //   307: aload_0
    //   308: ldc 210
    //   310: invokevirtual 144	com/tencent/mobileqq/data/MessageForReplyText:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   313: astore_3
    //   314: aload_3
    //   315: invokestatic 150	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   318: ifne -117 -> 201
    //   321: aload_0
    //   322: ldc 212
    //   324: invokevirtual 144	com/tencent/mobileqq/data/MessageForReplyText:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   327: astore 5
    //   329: aload 5
    //   331: invokestatic 150	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   334: ifne +57 -> 391
    //   337: aload 5
    //   339: ldc 102
    //   341: invokevirtual 217	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   344: ifeq +47 -> 391
    //   347: iload_2
    //   348: istore_1
    //   349: iload_1
    //   350: ifne +11 -> 361
    //   353: aload_0
    //   354: ldc 219
    //   356: aload 4
    //   358: invokevirtual 223	com/tencent/mobileqq/data/MessageForReplyText:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: new 225	java/util/concurrent/CopyOnWriteArrayList
    //   364: dup
    //   365: invokespecial 226	java/util/concurrent/CopyOnWriteArrayList:<init>	()V
    //   368: astore 4
    //   370: aload 4
    //   372: aload_0
    //   373: invokeinterface 232 2 0
    //   378: pop
    //   379: aload_0
    //   380: aload 4
    //   382: iload_1
    //   383: aload_3
    //   384: invokestatic 175	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)[B
    //   387: invokestatic 237	com/tencent/mqp/app/sec/MQPSensitiveMsgUtil:a	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/util/List;Z[B)V
    //   390: return
    //   391: iconst_0
    //   392: istore_1
    //   393: goto -44 -> 349
    //   396: goto -300 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	399	0	this	MessageForReplyText
    //   44	349	1	bool1	boolean
    //   1	347	2	bool2	boolean
    //   32	156	3	str1	String
    //   202	2	3	localException1	Exception
    //   212	2	3	localException2	Exception
    //   220	23	3	localException3	Exception
    //   265	1	3	str2	String
    //   269	23	3	localException4	Exception
    //   313	71	3	str3	String
    //   6	375	4	localObject1	Object
    //   170	168	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   40	45	202	java/lang/Exception
    //   64	72	212	java/lang/Exception
    //   96	124	220	java/lang/Exception
    //   124	179	269	java/lang/Exception
    //   182	197	269	java/lang/Exception
    //   258	266	269	java/lang/Exception
  }
  
  public String getSummaryMsg()
  {
    return this.sb.toString();
  }
  
  public boolean isSupportFTS()
  {
    return MsgProxyUtils.v(this.istroop);
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  protected void postRead()
  {
    super.postRead();
    parse();
  }
  
  protected void prewrite()
  {
    String str2 = getExtInfoFromExtStr("sens_msg_original_text");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.msg;
    }
    this.msg = str1;
    this.msgData = str1.getBytes();
    try
    {
      saveExtInfoToExtStr("sens_msg_source_msg_info", HexUtil.a(MessagePkgUtils.a(this.mSourceMsgInfo)));
      saveExtInfoToExtStr("sens_msg_source_msg_troop_topic_info", HexUtil.a(MessagePkgUtils.a(this.mGroupPostElemInfo)));
      if (this.mIsPlayedPicCommentAnimate) {}
      for (str1 = "true";; str1 = "false")
      {
        saveExtInfoToExtStr("reply_msg_is_played_pic_gif", str1);
        this.extLong |= 0x1;
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.", 2, "prewrite MessageForReplyText exception:" + localException.getMessage());
      }
    }
  }
  
  public void setAnimationPlayed(QQAppInterface paramQQAppInterface)
  {
    if (!this.mIsPlayedPicCommentAnimate)
    {
      this.mIsPlayedPicCommentAnimate = true;
      prewrite();
      paramQQAppInterface.a().a(this.frienduin, this.istroop, this.uniseq, "extStr", this.extStr);
      paramQQAppInterface.a().a(this.frienduin, this.istroop, this.uniseq, "extLong", Integer.valueOf(this.extLong));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForReplyText
 * JD-Core Version:    0.7.0.1
 */