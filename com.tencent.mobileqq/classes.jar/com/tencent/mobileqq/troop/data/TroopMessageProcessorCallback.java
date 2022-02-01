package com.tencent.mobileqq.troop.data;

import PushNotifyPack.GroupMsgReadedNotify;
import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.handler.PreDownloadMsg;
import com.tencent.mobileqq.app.message.MessageStatisticHelper;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.emosm.favroaming.IEmoticonFromGroupManager;
import com.tencent.mobileqq.model.CommercialDrainageManagerConstants;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.mobileqq.statistics.FightMsgReporter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppHandler;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import msf.msgsvc.msg_svc.PbGetGroupMsgResp;

public class TroopMessageProcessorCallback
  implements TroopMessageProcessor.Callback
{
  private void a(long paramLong1, long paramLong2, String paramString, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    if ((paramLong1 == 10000L) && ((paramMessageRecord instanceof MessageForStructing)))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      if ((paramMessageRecord != null) && (paramMessageRecord.structingMsg != null) && (paramMessageRecord.structingMsg.mMsgServiceID == 60))
      {
        Object localObject = (TroopManager)paramAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        paramMessageRecord = null;
        String str = String.valueOf(paramLong2);
        int i = 0;
        if (localObject != null)
        {
          localObject = ((TroopManager)localObject).b(paramString);
          paramMessageRecord = (MessageRecord)localObject;
          if (localObject != null)
          {
            if ((TextUtils.isEmpty(((TroopInfo)localObject).troopowneruin)) && (TextUtils.isEmpty(((TroopInfo)localObject).Administrator)))
            {
              paramMessageRecord = (MessageRecord)localObject;
              break label202;
            }
            if ((!TextUtils.isEmpty(((TroopInfo)localObject).troopowneruin)) && (((TroopInfo)localObject).troopowneruin.equalsIgnoreCase(str)))
            {
              paramMessageRecord = (MessageRecord)localObject;
              break label202;
            }
            paramMessageRecord = (MessageRecord)localObject;
            if (!TextUtils.isEmpty(((TroopInfo)localObject).Administrator))
            {
              paramMessageRecord = (MessageRecord)localObject;
              if (((TroopInfo)localObject).Administrator.contains(str))
              {
                i = 1;
                paramMessageRecord = (MessageRecord)localObject;
                break label202;
              }
            }
          }
        }
        i = 2;
        label202:
        if ((i != 2) || (paramMessageRecord == null)) {
          ((ITroopAppHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_APP_HANDLER)).b(Long.parseLong(paramString));
        }
      }
    }
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, PBDecodeContext paramPBDecodeContext, ArrayList<MessageRecord> paramArrayList, MessageRecord paramMessageRecord, TroopMessageProcessor paramTroopMessageProcessor)
  {
    AppInterface localAppInterface = paramTroopMessageProcessor.a();
    a(paramLong1, paramLong2, paramString, paramMessageRecord, localAppInterface);
    if ((paramMessageRecord instanceof MessageForMarketFace)) {
      CommercialDrainageManagerConstants.a(localAppInterface, (MessageForMarketFace)paramMessageRecord);
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("<---handleMsgPush_PB_Group : after analysis :");
      ((StringBuilder)localObject).append(" mr.senderuin:");
      ((StringBuilder)localObject).append(paramMessageRecord.senderuin);
      ((StringBuilder)localObject).append(" mr.msgtype:");
      ((StringBuilder)localObject).append(paramMessageRecord.msgtype);
      ((StringBuilder)localObject).append(" mr.frienduin:");
      ((StringBuilder)localObject).append(paramMessageRecord.frienduin);
      ((StringBuilder)localObject).append(" mr.shmsgseq:");
      ((StringBuilder)localObject).append(paramMessageRecord.shmsgseq);
      ((StringBuilder)localObject).append(" mr.time:");
      ((StringBuilder)localObject).append(paramMessageRecord.time);
      ((StringBuilder)localObject).append(" mr.msg:");
      ((StringBuilder)localObject).append(paramMessageRecord.getLogColorContent());
      QLog.d("Q.msg.TroopMessageProcessor", 2, ((StringBuilder)localObject).toString());
    }
    if (((paramMessageRecord.senderuin != null) && (paramMessageRecord.senderuin.equalsIgnoreCase(localAppInterface.getCurrentAccountUin()))) || ((AnonymousChatHelper.a(paramMessageRecord)) && (AnonymousChatHelper.b(paramMessageRecord))))
    {
      if (AnonymousChatHelper.a(paramMessageRecord))
      {
        paramMessageRecord.senderuin = localAppInterface.getCurrentAccountUin();
        localObject = AnonymousChatHelper.a(paramMessageRecord);
        AnonymousChatHelper.a().a(String.valueOf(paramPBDecodeContext.g), paramMessageRecord.vipBubbleID, ((AnonymousChatHelper.AnonymousExtInfo)localObject).jdField_b_of_type_Int, ((AnonymousChatHelper.AnonymousExtInfo)localObject).jdField_b_of_type_JavaLangString, ((AnonymousChatHelper.AnonymousExtInfo)localObject).jdField_c_of_type_Int, ((AnonymousChatHelper.AnonymousExtInfo)localObject).a, ((AnonymousChatHelper.AnonymousExtInfo)localObject).jdField_c_of_type_JavaLangString);
      }
      paramPBDecodeContext = ((IMessageFacade)localAppInterface.getRuntimeService(IMessageFacade.class, "")).getSendingTroopMsgItem(paramMessageRecord.frienduin, 1, paramMessageRecord);
      if (paramPBDecodeContext != null)
      {
        a(paramString, paramMessageRecord, paramPBDecodeContext, paramTroopMessageProcessor);
        return;
      }
      paramMessageRecord.isread = true;
      paramMessageRecord.issend = 2;
      ((IMessageFacade)localAppInterface.getRuntimeService(IMessageFacade.class, "")).setReadFrom(paramMessageRecord.frienduin, 1, paramMessageRecord.shmsgseq);
    }
    paramArrayList.add(paramMessageRecord);
    if ((paramMessageRecord instanceof MessageForTroopFile)) {
      ((AIOMessageSpreadManager)localAppInterface.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER)).a((ChatMessage)paramMessageRecord);
    }
  }
  
  /* Error */
  private void a(String paramString, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, TroopMessageProcessor paramTroopMessageProcessor)
  {
    // Byte code:
    //   0: aload 4
    //   2: invokevirtual 98	com/tencent/mobileqq/troop/data/TroopMessageProcessor:a	()Lcom/tencent/common/app/AppInterface;
    //   5: astore 11
    //   7: aload_2
    //   8: instanceof 263
    //   11: ifeq +84 -> 95
    //   14: aload_3
    //   15: instanceof 263
    //   18: ifeq +77 -> 95
    //   21: aload_2
    //   22: invokevirtual 267	com/tencent/mobileqq/data/MessageRecord:getRepeatCount	()I
    //   25: ifle +56 -> 81
    //   28: aload_3
    //   29: aload_2
    //   30: invokevirtual 267	com/tencent/mobileqq/data/MessageRecord:getRepeatCount	()I
    //   33: invokevirtual 271	com/tencent/mobileqq/data/MessageRecord:setRepeatCount	(I)V
    //   36: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +42 -> 81
    //   42: new 115	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 272	java/lang/StringBuilder:<init>	()V
    //   49: astore 9
    //   51: aload 9
    //   53: ldc_w 274
    //   56: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 9
    //   62: aload_3
    //   63: invokevirtual 267	com/tencent/mobileqq/data/MessageRecord:getRepeatCount	()I
    //   66: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: ldc 166
    //   72: iconst_2
    //   73: aload 9
    //   75: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload_3
    //   82: ldc_w 276
    //   85: aload_2
    //   86: ldc_w 276
    //   89: invokevirtual 280	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   92: invokevirtual 284	com/tencent/mobileqq/data/MessageRecord:saveExtInfoToExtStr	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: aload_3
    //   96: getfield 150	com/tencent/mobileqq/data/MessageRecord:shmsgseq	J
    //   99: lstore 5
    //   101: aload 11
    //   103: getstatic 287	com/tencent/mobileqq/app/BusinessHandlerFactory:MESSAGE_HANDLER	Ljava/lang/String;
    //   106: invokevirtual 81	com/tencent/common/app/AppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   109: checkcast 289	com/tencent/mobileqq/app/BaseMessageHandler
    //   112: astore 12
    //   114: aload 12
    //   116: aload_2
    //   117: getfield 144	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   120: iconst_1
    //   121: aload_3
    //   122: getfield 292	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   125: aload_2
    //   126: getfield 150	com/tencent/mobileqq/data/MessageRecord:shmsgseq	J
    //   129: aload_2
    //   130: getfield 158	com/tencent/mobileqq/data/MessageRecord:time	J
    //   133: invokevirtual 295	com/tencent/mobileqq/app/BaseMessageHandler:a	(Ljava/lang/String;IJJJ)V
    //   136: aload_2
    //   137: getfield 136	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   140: sipush -2011
    //   143: if_icmpne +223 -> 366
    //   146: aload 11
    //   148: checkcast 297	com/tencent/mobileqq/app/QQAppInterface
    //   151: astore 10
    //   153: aload 10
    //   155: iconst_1
    //   156: invokevirtual 301	com/tencent/mobileqq/app/QQAppInterface:getMessageProxy	(I)Lcom/tencent/imcore/message/BaseMsgProxy;
    //   159: pop
    //   160: aload 10
    //   162: invokevirtual 305	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   165: aload_2
    //   166: getfield 144	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   169: iconst_1
    //   170: aload_2
    //   171: getfield 150	com/tencent/mobileqq/data/MessageRecord:shmsgseq	J
    //   174: sipush -5020
    //   177: invokevirtual 310	com/tencent/imcore/message/QQMessageFacade:a	(Ljava/lang/String;IJI)Lcom/tencent/mobileqq/data/MessageRecord;
    //   180: astore 9
    //   182: aload 9
    //   184: instanceof 312
    //   187: ifeq +489 -> 676
    //   190: aload 9
    //   192: checkcast 312	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   195: astore 13
    //   197: aload 13
    //   199: getfield 316	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   202: ifnull +474 -> 676
    //   205: aload 13
    //   207: getfield 316	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   210: getfield 319	com/tencent/mobileqq/graytip/UniteGrayTipParam:jdField_b_of_type_Int	I
    //   213: ldc_w 320
    //   216: if_icmpne +460 -> 676
    //   219: aload 10
    //   221: invokevirtual 305	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   224: aload_2
    //   225: getfield 144	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   228: iconst_1
    //   229: aload 9
    //   231: getfield 292	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   234: invokevirtual 324	com/tencent/imcore/message/QQMessageFacade:f	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   237: pop
    //   238: aload 10
    //   240: invokevirtual 305	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   243: aload_2
    //   244: getfield 144	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   247: iconst_1
    //   248: aload 9
    //   250: invokevirtual 327	com/tencent/imcore/message/QQMessageFacade:a	(Ljava/lang/String;ILcom/tencent/mobileqq/data/MessageRecord;)V
    //   253: new 115	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 272	java/lang/StringBuilder:<init>	()V
    //   260: astore 10
    //   262: aload 10
    //   264: ldc 166
    //   266: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload 10
    //   272: getstatic 332	com/tencent/mobileqq/teamwork/TeamWorkConstants:i	Ljava/lang/String;
    //   275: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload 10
    //   281: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: astore 10
    //   286: new 115	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 272	java/lang/StringBuilder:<init>	()V
    //   293: astore 13
    //   295: aload 13
    //   297: ldc_w 334
    //   300: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload 13
    //   306: aload_2
    //   307: getfield 150	com/tencent/mobileqq/data/MessageRecord:shmsgseq	J
    //   310: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 13
    //   316: ldc_w 336
    //   319: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload 13
    //   325: sipush -5020
    //   328: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload 13
    //   334: ldc_w 338
    //   337: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload 13
    //   343: aload 9
    //   345: getfield 292	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   348: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload 10
    //   354: iconst_1
    //   355: aload 13
    //   357: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 340	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: goto +313 -> 676
    //   366: aload_2
    //   367: getfield 136	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   370: sipush -2000
    //   373: if_icmpne +303 -> 676
    //   376: aload 11
    //   378: checkcast 297	com/tencent/mobileqq/app/QQAppInterface
    //   381: invokevirtual 305	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   384: aload_2
    //   385: getfield 144	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   388: iconst_1
    //   389: lload 5
    //   391: sipush -5040
    //   394: invokevirtual 343	com/tencent/imcore/message/QQMessageFacade:c	(Ljava/lang/String;IJI)Ljava/util/List;
    //   397: astore 13
    //   399: aconst_null
    //   400: astore 10
    //   402: aload 10
    //   404: astore 9
    //   406: aload 13
    //   408: ifnull +90 -> 498
    //   411: aload 10
    //   413: astore 9
    //   415: aload 13
    //   417: invokeinterface 348 1 0
    //   422: ifle +76 -> 498
    //   425: aload 13
    //   427: aload 13
    //   429: invokeinterface 348 1 0
    //   434: iconst_1
    //   435: isub
    //   436: invokeinterface 352 2 0
    //   441: checkcast 128	com/tencent/mobileqq/data/MessageRecord
    //   444: astore 10
    //   446: aload 10
    //   448: astore 9
    //   450: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   453: ifeq +45 -> 498
    //   456: new 115	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 272	java/lang/StringBuilder:<init>	()V
    //   463: astore 9
    //   465: aload 9
    //   467: ldc_w 354
    //   470: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: pop
    //   474: aload 9
    //   476: aload 10
    //   478: invokevirtual 357	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: ldc_w 359
    //   485: iconst_2
    //   486: aload 9
    //   488: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: invokestatic 340	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   494: aload 10
    //   496: astore 9
    //   498: aload 9
    //   500: instanceof 312
    //   503: ifeq +173 -> 676
    //   506: aload 9
    //   508: checkcast 312	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   511: getfield 316	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   514: ifnull +162 -> 676
    //   517: aload 9
    //   519: checkcast 312	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   522: getfield 316	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:tipParam	Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;
    //   525: getfield 319	com/tencent/mobileqq/graytip/UniteGrayTipParam:jdField_b_of_type_Int	I
    //   528: ldc_w 360
    //   531: if_icmpne +145 -> 676
    //   534: aload 9
    //   536: ldc_w 362
    //   539: invokevirtual 280	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   542: invokestatic 89	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   545: lstore 5
    //   547: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   550: ifeq +41 -> 591
    //   553: new 115	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 272	java/lang/StringBuilder:<init>	()V
    //   560: astore 10
    //   562: aload 10
    //   564: ldc_w 364
    //   567: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: pop
    //   571: aload 10
    //   573: lload 5
    //   575: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   578: pop
    //   579: ldc_w 359
    //   582: iconst_2
    //   583: aload 10
    //   585: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: invokestatic 340	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   591: lload 5
    //   593: aload_3
    //   594: getfield 292	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   597: lcmp
    //   598: ifne +78 -> 676
    //   601: aload 11
    //   603: checkcast 297	com/tencent/mobileqq/app/QQAppInterface
    //   606: invokevirtual 305	com/tencent/mobileqq/app/QQAppInterface:getMessageFacade	()Lcom/tencent/imcore/message/QQMessageFacade;
    //   609: astore 10
    //   611: aload_2
    //   612: getfield 144	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   615: astore 13
    //   617: aload 9
    //   619: getfield 292	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   622: lstore 5
    //   624: aload_2
    //   625: getfield 150	com/tencent/mobileqq/data/MessageRecord:shmsgseq	J
    //   628: lstore 7
    //   630: aload 10
    //   632: aload 13
    //   634: iconst_1
    //   635: lload 5
    //   637: lload 7
    //   639: aload_2
    //   640: getfield 158	com/tencent/mobileqq/data/MessageRecord:time	J
    //   643: invokevirtual 365	com/tencent/imcore/message/QQMessageFacade:a	(Ljava/lang/String;IJJJ)V
    //   646: goto +30 -> 676
    //   649: astore 9
    //   651: goto +10 -> 661
    //   654: astore 9
    //   656: goto +5 -> 661
    //   659: astore 9
    //   661: ldc_w 359
    //   664: iconst_1
    //   665: ldc_w 367
    //   668: aload 9
    //   670: invokestatic 370	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   673: goto +3 -> 676
    //   676: aload_3
    //   677: astore 9
    //   679: aload 9
    //   681: getfield 136	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   684: sipush -2017
    //   687: if_icmpne +57 -> 744
    //   690: aload 9
    //   692: aload_2
    //   693: invokestatic 373	com/tencent/mobileqq/troop/data/TroopMessageProcessorCallback:a	(Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/data/MessageRecord;)[B
    //   696: astore_3
    //   697: aload 11
    //   699: ldc 215
    //   701: ldc 217
    //   703: invokevirtual 221	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   706: checkcast 215	com/tencent/mobileqq/msg/api/IMessageFacade
    //   709: aload_2
    //   710: getfield 144	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   713: iconst_1
    //   714: aload 9
    //   716: getfield 292	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   719: aload_3
    //   720: invokeinterface 377 6 0
    //   725: invokestatic 382	com/tencent/mobileqq/activity/aio/forward/ForwardOrderManager:a	()Lcom/tencent/mobileqq/activity/aio/forward/ForwardOrderManager;
    //   728: aload 11
    //   730: checkcast 297	com/tencent/mobileqq/app/QQAppInterface
    //   733: aload 9
    //   735: getfield 292	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   738: invokevirtual 385	com/tencent/mobileqq/activity/aio/forward/ForwardOrderManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;J)V
    //   741: goto +299 -> 1040
    //   744: aload_3
    //   745: invokestatic 388	com/tencent/mobileqq/structmsg/StructMsgHelper:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   748: ifne +141 -> 889
    //   751: aload 9
    //   753: getfield 136	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   756: sipush -2048
    //   759: if_icmpne +6 -> 765
    //   762: goto +127 -> 889
    //   765: aload 9
    //   767: getfield 136	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   770: sipush -1049
    //   773: if_icmpne -32 -> 741
    //   776: aload 9
    //   778: checkcast 390	com/tencent/mobileqq/data/MessageForReplyText
    //   781: astore_3
    //   782: aload_2
    //   783: checkcast 390	com/tencent/mobileqq/data/MessageForReplyText
    //   786: aload_3
    //   787: getfield 393	com/tencent/mobileqq/data/MessageForReplyText:extStr	Ljava/lang/String;
    //   790: putfield 393	com/tencent/mobileqq/data/MessageForReplyText:extStr	Ljava/lang/String;
    //   793: aload 11
    //   795: invokevirtual 397	com/tencent/common/app/AppInterface:getMsgCache	()Ljava/lang/Object;
    //   798: checkcast 399	com/tencent/mobileqq/service/message/MessageCache
    //   801: aload_2
    //   802: getfield 144	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   805: iconst_1
    //   806: aload 9
    //   808: getfield 292	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   811: invokevirtual 402	com/tencent/mobileqq/service/message/MessageCache:a	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/service/message/MessageCache$MsgSendingInfo;
    //   814: pop
    //   815: aload 11
    //   817: ldc 215
    //   819: ldc 217
    //   821: invokevirtual 221	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   824: checkcast 215	com/tencent/mobileqq/msg/api/IMessageFacade
    //   827: aload_2
    //   828: getfield 144	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   831: iconst_1
    //   832: aload 9
    //   834: getfield 292	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   837: ldc_w 403
    //   840: aload_2
    //   841: getfield 404	com/tencent/mobileqq/data/MessageRecord:extStr	Ljava/lang/String;
    //   844: invokeinterface 408 7 0
    //   849: aload 11
    //   851: ldc 215
    //   853: ldc 217
    //   855: invokevirtual 221	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   858: checkcast 215	com/tencent/mobileqq/msg/api/IMessageFacade
    //   861: aload_2
    //   862: getfield 144	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   865: iconst_1
    //   866: aload 9
    //   868: getfield 292	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   871: ldc_w 410
    //   874: aload_2
    //   875: getfield 412	com/tencent/mobileqq/data/MessageRecord:extLong	I
    //   878: invokestatic 417	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   881: invokeinterface 408 7 0
    //   886: goto -145 -> 741
    //   889: aload_2
    //   890: getfield 136	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   893: sipush -2048
    //   896: if_icmpne +78 -> 974
    //   899: aload_2
    //   900: checkcast 419	com/tencent/mobileqq/data/MessageForTroopReward
    //   903: astore_3
    //   904: aload_3
    //   905: aload 9
    //   907: checkcast 419	com/tencent/mobileqq/data/MessageForTroopReward
    //   910: getfield 422	com/tencent/mobileqq/data/MessageForTroopReward:mediaPath	Ljava/lang/String;
    //   913: putfield 422	com/tencent/mobileqq/data/MessageForTroopReward:mediaPath	Ljava/lang/String;
    //   916: aload_3
    //   917: invokevirtual 425	com/tencent/mobileqq/data/MessageForTroopReward:prewrite	()V
    //   920: aload_2
    //   921: aload_3
    //   922: getfield 429	com/tencent/mobileqq/data/MessageForTroopReward:msgData	[B
    //   925: putfield 430	com/tencent/mobileqq/data/MessageRecord:msgData	[B
    //   928: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   931: ifeq +43 -> 974
    //   934: new 115	java/lang/StringBuilder
    //   937: dup
    //   938: invokespecial 272	java/lang/StringBuilder:<init>	()V
    //   941: astore 10
    //   943: aload 10
    //   945: ldc_w 432
    //   948: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   951: pop
    //   952: aload 10
    //   954: aload_3
    //   955: getfield 435	com/tencent/mobileqq/data/MessageForTroopReward:rewardId	Ljava/lang/String;
    //   958: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: pop
    //   962: ldc_w 437
    //   965: iconst_2
    //   966: aload 10
    //   968: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   971: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   974: aload 11
    //   976: invokevirtual 397	com/tencent/common/app/AppInterface:getMsgCache	()Ljava/lang/Object;
    //   979: checkcast 399	com/tencent/mobileqq/service/message/MessageCache
    //   982: aload_2
    //   983: getfield 144	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   986: iconst_1
    //   987: aload 9
    //   989: getfield 292	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   992: invokevirtual 402	com/tencent/mobileqq/service/message/MessageCache:a	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/service/message/MessageCache$MsgSendingInfo;
    //   995: pop
    //   996: aload 11
    //   998: ldc 215
    //   1000: ldc 217
    //   1002: invokevirtual 221	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   1005: checkcast 215	com/tencent/mobileqq/msg/api/IMessageFacade
    //   1008: aload_2
    //   1009: getfield 144	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1012: iconst_1
    //   1013: aload 9
    //   1015: getfield 292	com/tencent/mobileqq/data/MessageRecord:uniseq	J
    //   1018: aload_2
    //   1019: getfield 430	com/tencent/mobileqq/data/MessageRecord:msgData	[B
    //   1022: invokeinterface 377 6 0
    //   1027: aload 4
    //   1029: sipush 999
    //   1032: iconst_1
    //   1033: aload_2
    //   1034: getfield 144	com/tencent/mobileqq/data/MessageRecord:frienduin	Ljava/lang/String;
    //   1037: invokevirtual 440	com/tencent/mobileqq/troop/data/TroopMessageProcessor:a	(IZLjava/lang/Object;)V
    //   1040: aload 11
    //   1042: invokevirtual 397	com/tencent/common/app/AppInterface:getMsgCache	()Ljava/lang/Object;
    //   1045: checkcast 399	com/tencent/mobileqq/service/message/MessageCache
    //   1048: aload 9
    //   1050: invokevirtual 441	com/tencent/mobileqq/service/message/MessageCache:b	(Lcom/tencent/mobileqq/data/MessageRecord;)Z
    //   1053: ifeq +13 -> 1066
    //   1056: aload 4
    //   1058: aload 9
    //   1060: invokevirtual 444	com/tencent/mobileqq/troop/data/TroopMessageProcessor:a	(Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   1063: goto +11 -> 1074
    //   1066: aload 12
    //   1068: aload_2
    //   1069: aload 9
    //   1071: invokevirtual 447	com/tencent/mobileqq/app/BaseMessageHandler:a	(Lcom/tencent/mobileqq/data/MessageRecord;Lcom/tencent/mobileqq/data/MessageRecord;)V
    //   1074: invokestatic 453	cooperation/vip/tianshu/TianShuManager:getInstance	()Lcooperation/vip/tianshu/TianShuManager;
    //   1077: aload 9
    //   1079: ldc_w 455
    //   1082: invokevirtual 280	com/tencent/mobileqq/data/MessageRecord:getExtInfoFromExtStr	(Ljava/lang/String;)Ljava/lang/String;
    //   1085: invokevirtual 458	cooperation/vip/tianshu/TianShuManager:cacheTraceInfo	(Ljava/lang/String;)V
    //   1088: aload 11
    //   1090: invokevirtual 397	com/tencent/common/app/AppInterface:getMsgCache	()Ljava/lang/Object;
    //   1093: checkcast 399	com/tencent/mobileqq/service/message/MessageCache
    //   1096: aload_1
    //   1097: aload_2
    //   1098: getfield 150	com/tencent/mobileqq/data/MessageRecord:shmsgseq	J
    //   1101: invokevirtual 461	com/tencent/mobileqq/service/message/MessageCache:a	(Ljava/lang/String;J)V
    //   1104: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1105	0	this	TroopMessageProcessorCallback
    //   0	1105	1	paramString	String
    //   0	1105	2	paramMessageRecord1	MessageRecord
    //   0	1105	3	paramMessageRecord2	MessageRecord
    //   0	1105	4	paramTroopMessageProcessor	TroopMessageProcessor
    //   99	537	5	l1	long
    //   628	10	7	l2	long
    //   49	569	9	localObject1	Object
    //   649	1	9	localException1	java.lang.Exception
    //   654	1	9	localException2	java.lang.Exception
    //   659	10	9	localException3	java.lang.Exception
    //   677	401	9	localMessageRecord	MessageRecord
    //   151	816	10	localObject2	Object
    //   5	1084	11	localAppInterface	AppInterface
    //   112	955	12	localBaseMessageHandler	com.tencent.mobileqq.app.BaseMessageHandler
    //   195	438	13	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   630	646	649	java/lang/Exception
    //   591	630	654	java/lang/Exception
    //   376	399	659	java/lang/Exception
    //   415	446	659	java/lang/Exception
    //   450	494	659	java/lang/Exception
    //   498	591	659	java/lang/Exception
  }
  
  public static byte[] a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)MessageRecordFactory.a(-2017);
    MessageRecord.copyMessageRecordBaseField(localMessageForTroopFile, paramMessageRecord1);
    localMessageForTroopFile.doParse();
    paramMessageRecord1 = (MessageForTroopFile)MessageRecordFactory.a(-2017);
    MessageRecord.copyMessageRecordBaseField(paramMessageRecord1, paramMessageRecord2);
    paramMessageRecord1.doParse();
    localMessageForTroopFile.bisID = paramMessageRecord1.bisID;
    localMessageForTroopFile.dspFileName = paramMessageRecord1.dspFileName;
    localMessageForTroopFile.dspFileSize = paramMessageRecord1.dspFileSize;
    localMessageForTroopFile.fileSize = paramMessageRecord1.fileSize;
    localMessageForTroopFile.fileName = paramMessageRecord1.fileName;
    localMessageForTroopFile.md5 = paramMessageRecord1.md5;
    localMessageForTroopFile.url = paramMessageRecord1.url;
    if ((paramMessageRecord1.width != 0) && (paramMessageRecord1.height != 0))
    {
      localMessageForTroopFile.width = paramMessageRecord1.width;
      localMessageForTroopFile.height = paramMessageRecord1.height;
    }
    if (paramMessageRecord1.duration != 0) {
      localMessageForTroopFile.duration = paramMessageRecord1.duration;
    }
    localMessageForTroopFile.serial();
    return localMessageForTroopFile.msgData;
  }
  
  public BaseMessageManagerForTroopAndDisc a(TroopMessageProcessor paramTroopMessageProcessor)
  {
    return (BaseMessageManagerForTroopAndDisc)((QQAppInterface)paramTroopMessageProcessor.a()).getMessageFacade().a(1);
  }
  
  public void a(int paramInt, TroopMessageProcessor paramTroopMessageProcessor)
  {
    ((QQAppInterface)paramTroopMessageProcessor.a()).userActiveStatus = paramInt;
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, ArrayList<MessageRecord> paramArrayList1, PBDecodeContext paramPBDecodeContext, MessageInfo paramMessageInfo, ArrayList<MessageRecord> paramArrayList2, TroopMessageProcessor paramTroopMessageProcessor)
  {
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0))
    {
      int j = paramArrayList1.size();
      int i = 0;
      while (i < j)
      {
        a(paramLong1, paramLong2, paramString, paramPBDecodeContext, paramArrayList2, (MessageRecord)paramArrayList1.get(i), paramTroopMessageProcessor);
        i += 1;
      }
    }
    ((TroopInfoManager)paramTroopMessageProcessor.a().getManager(QQManagerFactory.TROOPINFO_MANAGER)).a(paramString, paramMessageInfo);
  }
  
  public void a(long paramLong, MessageRecord paramMessageRecord, TroopMessageProcessor paramTroopMessageProcessor)
  {
    if ((paramMessageRecord instanceof MessageForMarketFace)) {
      CommercialDrainageManagerConstants.a(paramTroopMessageProcessor.a(), (MessageForMarketFace)paramMessageRecord);
    }
  }
  
  public void a(long paramLong, ArrayList<MessageRecord> paramArrayList1, String paramString, ArrayList<MessageRecord> paramArrayList2, TroopMessageProcessor paramTroopMessageProcessor)
  {
    FightMsgReporter.a(0, 1, 1, paramArrayList2.size());
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0))
    {
      paramArrayList1 = (MessageRecord)paramArrayList1.get(0);
      ((TroopRobotManager)paramTroopMessageProcessor.a().getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).b(paramArrayList1);
    }
  }
  
  public void a(long paramLong, ArrayList<MessageRecord> paramArrayList1, ArrayList<MessageRecord> paramArrayList2, TroopMessageProcessor paramTroopMessageProcessor)
  {
    paramTroopMessageProcessor = paramTroopMessageProcessor.a();
    PreDownloadMsg.a(paramArrayList2, true, paramTroopMessageProcessor);
    ((VasExtensionManager)paramTroopMessageProcessor.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a.a(paramArrayList1);
    paramLong = System.currentTimeMillis() - paramLong;
    if (QLog.isColorLevel())
    {
      paramArrayList2 = new StringBuilder();
      paramArrayList2.append("decodecMsg costTime = [");
      paramArrayList2.append(paramLong);
      paramArrayList2.append("]");
      QLog.d("Q.msg.TroopMessageProcessor", 2, paramArrayList2.toString());
    }
    MessageStatisticHelper.a("actGroupDecodeCost", paramLong);
    if (paramArrayList1.size() > 0) {
      MessageStatisticHelper.a((MessageRecord)paramArrayList1.get(0), paramTroopMessageProcessor);
    }
  }
  
  public void a(GroupMsgReadedNotify paramGroupMsgReadedNotify, TroopMessageProcessor paramTroopMessageProcessor)
  {
    paramGroupMsgReadedNotify = String.valueOf(paramGroupMsgReadedNotify.lGroupCode);
    paramTroopMessageProcessor = (TroopBindPublicAccountMgr)paramTroopMessageProcessor.a().getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER);
    if (paramTroopMessageProcessor.b(paramGroupMsgReadedNotify))
    {
      paramTroopMessageProcessor.d(paramGroupMsgReadedNotify);
      if (!paramTroopMessageProcessor.a(paramGroupMsgReadedNotify)) {
        paramTroopMessageProcessor.b(paramGroupMsgReadedNotify);
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, TroopMessageProcessor paramTroopMessageProcessor)
  {
    if (AnonymousChatHelper.a(paramMessageRecord))
    {
      paramMessageRecord.senderuin = paramTroopMessageProcessor.a().getCurrentAccountUin();
      paramTroopMessageProcessor = AnonymousChatHelper.a(paramMessageRecord);
      AnonymousChatHelper.a().a(paramMessageRecord.frienduin, paramMessageRecord.vipBubbleID, paramTroopMessageProcessor.jdField_b_of_type_Int, paramTroopMessageProcessor.jdField_b_of_type_JavaLangString, paramTroopMessageProcessor.jdField_c_of_type_Int, paramTroopMessageProcessor.a, paramTroopMessageProcessor.jdField_c_of_type_JavaLangString);
    }
  }
  
  public void a(MessageInfo paramMessageInfo, String paramString, TroopMessageProcessor paramTroopMessageProcessor)
  {
    ((TroopInfoManager)paramTroopMessageProcessor.a().getManager(QQManagerFactory.TROOPINFO_MANAGER)).a(paramString, paramMessageInfo);
  }
  
  public void a(String paramString, TroopMessageProcessor paramTroopMessageProcessor)
  {
    ((TroopManager)paramTroopMessageProcessor.a().getManager(QQManagerFactory.TROOP_MANAGER)).e(paramString);
  }
  
  public void a(String paramString, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, int paramInt, TroopMessageProcessor paramTroopMessageProcessor)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doSomeAfterGetPullTroopMsg doSome:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" troopUin:");
      localStringBuilder.append(paramString);
      QLog.d("Q.msg.TroopMessageProcessor", 2, localStringBuilder.toString());
    }
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 3) && (paramInt != 4)) {
      return;
    }
    ((HotChatManager)paramTroopMessageProcessor.a().getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramString, paramPbGetGroupMsgResp, paramInt);
  }
  
  public void a(ArrayList<TroopMemberInfo> paramArrayList, TroopMessageProcessor paramTroopMessageProcessor)
  {
    ((TroopManager)paramTroopMessageProcessor.a().getManager(QQManagerFactory.TROOP_MANAGER)).a(paramArrayList);
  }
  
  public void a(ArrayList<MessageRecord> paramArrayList1, ArrayList<MessageRecord> paramArrayList2, TroopMessageProcessor paramTroopMessageProcessor)
  {
    paramTroopMessageProcessor = paramTroopMessageProcessor.a();
    PreDownloadMsg.a(paramArrayList2, true, paramTroopMessageProcessor);
    ((VasExtensionManager)paramTroopMessageProcessor.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a.a(paramArrayList1);
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord instanceof MessageForText;
  }
  
  public boolean a(MessageRecord paramMessageRecord, TroopMessageProcessor paramTroopMessageProcessor)
  {
    return ((paramMessageRecord.senderuin != null) && (paramMessageRecord.senderuin.equals(paramTroopMessageProcessor.a().getCurrentAccountUin()))) || ((AnonymousChatHelper.a(paramMessageRecord)) && (AnonymousChatHelper.b(paramMessageRecord)));
  }
  
  public boolean a(TroopMessageProcessor paramTroopMessageProcessor)
  {
    return ((QQAppInterface)paramTroopMessageProcessor.a()).mAutomator.a();
  }
  
  public boolean a(ArrayList<MessageRecord> paramArrayList)
  {
    return MessageHandlerUtils.b(paramArrayList);
  }
  
  public void b(ArrayList<MessageRecord> paramArrayList, TroopMessageProcessor paramTroopMessageProcessor)
  {
    paramTroopMessageProcessor = paramTroopMessageProcessor.a();
    PreDownloadMsg.a(paramArrayList, true, paramTroopMessageProcessor);
    ((VasExtensionManager)paramTroopMessageProcessor.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a.a(paramArrayList);
    if (paramArrayList.size() > 0) {
      MessageStatisticHelper.a((MessageRecord)paramArrayList.get(0), paramTroopMessageProcessor);
    }
  }
  
  public boolean b(TroopMessageProcessor paramTroopMessageProcessor)
  {
    return ((QQAppInterface)paramTroopMessageProcessor.a()).mAutomator.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopMessageProcessorCallback
 * JD-Core Version:    0.7.0.1
 */