package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.content.Context;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.SourceMessagePulledCallBack;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

final class GuildReplyTextItemBuilder$3
  implements Runnable
{
  GuildReplyTextItemBuilder$3(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, ReplyTextItemBuilder.SourceMessagePulledCallBack paramSourceMessagePulledCallBack, Context paramContext, ChatThumbView paramChatThumbView) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/GuildReplyTextItemBuilder$3:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   4: astore 4
    //   6: aload 4
    //   8: instanceof 37
    //   11: istore_3
    //   12: aconst_null
    //   13: astore 6
    //   15: iconst_0
    //   16: istore_1
    //   17: iload_3
    //   18: ifeq +30 -> 48
    //   21: aload 4
    //   23: checkcast 37	com/tencent/mobileqq/data/HasSourceMessage
    //   26: astore 4
    //   28: aload 4
    //   30: invokeinterface 41 1 0
    //   35: astore 5
    //   37: aload 4
    //   39: invokeinterface 45 1 0
    //   44: istore_3
    //   45: goto +8 -> 53
    //   48: aconst_null
    //   49: astore 5
    //   51: iconst_0
    //   52: istore_3
    //   53: aload 5
    //   55: ifnonnull +4 -> 59
    //   58: return
    //   59: aload_0
    //   60: getfield 22	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/GuildReplyTextItemBuilder$3:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   63: invokevirtual 51	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   66: aload_0
    //   67: getfield 20	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/GuildReplyTextItemBuilder$3:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   70: getfield 57	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   73: aload_0
    //   74: getfield 20	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/GuildReplyTextItemBuilder$3:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   77: getfield 61	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   80: aload 5
    //   82: getfield 67	com/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo:mSourceMsgSeq	J
    //   85: invokevirtual 72	com/tencent/imcore/message/QQMessageFacade:c	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   88: astore 7
    //   90: aload 7
    //   92: astore 4
    //   94: aload 7
    //   96: ifnonnull +317 -> 413
    //   99: aload 7
    //   101: astore 4
    //   103: iload_3
    //   104: ifne +309 -> 413
    //   107: aload 7
    //   109: astore 4
    //   111: aload_0
    //   112: getfield 20	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/GuildReplyTextItemBuilder$3:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   115: getfield 57	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   118: ifnull +295 -> 413
    //   121: aload_0
    //   122: getfield 20	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/GuildReplyTextItemBuilder$3:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   125: astore 4
    //   127: aload 4
    //   129: instanceof 37
    //   132: ifeq +13 -> 145
    //   135: aload 4
    //   137: checkcast 37	com/tencent/mobileqq/data/HasSourceMessage
    //   140: invokeinterface 75 1 0
    //   145: new 77	android/os/Bundle
    //   148: dup
    //   149: invokespecial 78	android/os/Bundle:<init>	()V
    //   152: astore 4
    //   154: aload_0
    //   155: getfield 22	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/GuildReplyTextItemBuilder$3:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   158: invokevirtual 51	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   161: astore 9
    //   163: new 80	java/util/ArrayList
    //   166: dup
    //   167: invokespecial 81	java/util/ArrayList:<init>	()V
    //   170: astore 8
    //   172: aload 9
    //   174: getfield 85	com/tencent/imcore/message/QQMessageFacade:f	Ljava/util/concurrent/atomic/AtomicInteger;
    //   177: iconst_1
    //   178: invokevirtual 91	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
    //   181: istore_2
    //   182: aload 4
    //   184: ldc 93
    //   186: iload_2
    //   187: invokevirtual 97	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   190: aload 4
    //   192: ldc 99
    //   194: iconst_0
    //   195: invokevirtual 103	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   198: aload 9
    //   200: getfield 107	com/tencent/imcore/message/QQMessageFacade:g	Ljava/util/concurrent/ConcurrentHashMap;
    //   203: iload_2
    //   204: invokestatic 113	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   207: aload 8
    //   209: invokevirtual 119	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   212: pop
    //   213: aload_0
    //   214: getfield 22	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/GuildReplyTextItemBuilder$3:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   217: ldc 121
    //   219: invokestatic 127	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   222: checkcast 121	com/tencent/mobileqq/guild/api/IGuildHandlerNameApi
    //   225: invokeinterface 131 1 0
    //   230: invokevirtual 135	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   233: checkcast 137	com/tencent/mobileqq/guild/message/api/IGuildRoamMessageHandler
    //   236: aload_0
    //   237: getfield 20	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/GuildReplyTextItemBuilder$3:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   240: getfield 57	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   243: aload 5
    //   245: getfield 67	com/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo:mSourceMsgSeq	J
    //   248: aload 5
    //   250: getfield 67	com/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo:mSourceMsgSeq	J
    //   253: aload 4
    //   255: invokeinterface 141 7 0
    //   260: pop
    //   261: aload 9
    //   263: getfield 144	com/tencent/imcore/message/QQMessageFacade:h	Ljava/util/concurrent/ConcurrentHashMap;
    //   266: aload_0
    //   267: getfield 20	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/GuildReplyTextItemBuilder$3:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   270: getfield 57	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   273: aload_0
    //   274: getfield 20	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/GuildReplyTextItemBuilder$3:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   277: getfield 61	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   280: invokestatic 149	com/tencent/imcore/message/UinTypeUtil:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   283: iconst_0
    //   284: invokestatic 154	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   287: invokevirtual 119	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   290: pop
    //   291: invokestatic 160	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   294: invokestatic 166	com/tencent/mobileqq/utils/NetworkUtil:isNetworkAvailable	(Landroid/content/Context;)Z
    //   297: ifeq +41 -> 338
    //   300: aload 8
    //   302: monitorenter
    //   303: aload 8
    //   305: ldc2_w 167
    //   308: invokevirtual 172	java/lang/Object:wait	(J)V
    //   311: goto +15 -> 326
    //   314: astore 4
    //   316: goto +16 -> 332
    //   319: astore 4
    //   321: aload 4
    //   323: invokevirtual 175	java/lang/InterruptedException:printStackTrace	()V
    //   326: aload 8
    //   328: monitorexit
    //   329: goto +9 -> 338
    //   332: aload 8
    //   334: monitorexit
    //   335: aload 4
    //   337: athrow
    //   338: aload 7
    //   340: astore 4
    //   342: aload 8
    //   344: invokeinterface 181 1 0
    //   349: ifle +64 -> 413
    //   352: aload 7
    //   354: astore 4
    //   356: iload_1
    //   357: aload 8
    //   359: invokeinterface 181 1 0
    //   364: if_icmpge +49 -> 413
    //   367: aload 8
    //   369: iload_1
    //   370: invokeinterface 185 2 0
    //   375: checkcast 53	com/tencent/mobileqq/data/MessageRecord
    //   378: getfield 188	com/tencent/mobileqq/data/MessageRecord:shmsgseq	J
    //   381: aload 5
    //   383: getfield 67	com/tencent/mobileqq/data/MessageForReplyText$SourceMsgInfo:mSourceMsgSeq	J
    //   386: lcmp
    //   387: ifne +19 -> 406
    //   390: aload 8
    //   392: iload_1
    //   393: invokeinterface 185 2 0
    //   398: checkcast 53	com/tencent/mobileqq/data/MessageRecord
    //   401: astore 4
    //   403: goto +10 -> 413
    //   406: iload_1
    //   407: iconst_1
    //   408: iadd
    //   409: istore_1
    //   410: goto -58 -> 352
    //   413: aload_0
    //   414: getfield 20	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/GuildReplyTextItemBuilder$3:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   417: getfield 61	com/tencent/mobileqq/data/MessageRecord:istroop	I
    //   420: ifeq +76 -> 496
    //   423: aload 4
    //   425: instanceof 190
    //   428: ifne +11 -> 439
    //   431: aload 4
    //   433: instanceof 192
    //   436: ifeq +60 -> 496
    //   439: aload 4
    //   441: invokevirtual 195	com/tencent/mobileqq/data/MessageRecord:isLongMsg	()Z
    //   444: ifeq +52 -> 496
    //   447: new 197	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   454: astore 7
    //   456: aload_0
    //   457: getfield 22	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/GuildReplyTextItemBuilder$3:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   460: aload_0
    //   461: getfield 20	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/GuildReplyTextItemBuilder$3:a	Lcom/tencent/mobileqq/data/MessageRecord;
    //   464: aload 4
    //   466: aload 7
    //   468: invokestatic 203	com/tencent/mobileqq/activity/aio/item/ReplyTextItemBuilder:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/StringBuilder;)Lcom/tencent/mobileqq/data/MessageRecord;
    //   471: astore 5
    //   473: aload 5
    //   475: ifnull +21 -> 496
    //   478: aload 7
    //   480: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: astore 6
    //   485: aload 5
    //   487: astore 4
    //   489: aload 6
    //   491: astore 5
    //   493: goto +7 -> 500
    //   496: aload 6
    //   498: astore 5
    //   500: invokestatic 212	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   503: new 214	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/GuildReplyTextItemBuilder$3$1
    //   506: dup
    //   507: aload_0
    //   508: aload 4
    //   510: aload 5
    //   512: invokespecial 217	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/GuildReplyTextItemBuilder$3$1:<init>	(Lcom/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/GuildReplyTextItemBuilder$3;Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   515: invokevirtual 223	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   518: pop
    //   519: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	520	0	this	3
    //   16	394	1	i	int
    //   181	23	2	j	int
    //   11	93	3	bool	boolean
    //   4	250	4	localObject1	Object
    //   314	1	4	localObject2	Object
    //   319	17	4	localInterruptedException	java.lang.InterruptedException
    //   340	169	4	localObject3	Object
    //   35	476	5	localObject4	Object
    //   13	484	6	str	java.lang.String
    //   88	391	7	localObject5	Object
    //   170	221	8	localArrayList	java.util.ArrayList
    //   161	101	9	localQQMessageFacade	com.tencent.imcore.message.QQMessageFacade
    // Exception table:
    //   from	to	target	type
    //   303	311	314	finally
    //   321	326	314	finally
    //   326	329	314	finally
    //   332	335	314	finally
    //   303	311	319	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildReplyTextItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */