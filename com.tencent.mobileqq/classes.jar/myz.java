import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import trpc.qq_vgame.common.AvGameCommon.GameInfo;
import trpc.qq_vgame.common.AvGameCommon.GameQuestionInfo;
import trpc.qq_vgame.common.AvGameCommon.Result;
import trpc.qq_vgame.common.AvGameCommon.RoomUserInfo;
import trpc.qq_vgame.game_ranking.AvGameRanking.GetRankingListReq;
import trpc.qq_vgame.game_ranking.AvGameRanking.GetRankingListRsp;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyActorGiveOutAnswerS2CReq;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyAnswerRightS2CReq;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyChangeActorS2CReq;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyChangeQuestionS2CReq;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyGameOverS2CReq;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyMsg;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyNextActorTipsS2CReq;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyQuestionTimeoutS2CReq;
import trpc.qq_vgame.nofity.AvGameNotify.NotifyTranslateInfoS2CReq;
import trpc.qq_vgame.nofity.AvGameNotify.RoomOwnerStartGameS2CReq;
import trpc.qq_vgame.playgame.AvGamePlay.StartGameReq;
import trpc.qq_vgame.playgame.AvGamePlay.StartGameRsp;
import trpc.qq_vgame.question.AvGameQuestionInfo.CmdGetQuestionReq;
import trpc.qq_vgame.question.AvGameQuestionInfo.CmdGetQuestionRsp;

public class myz
  extends mwm
{
  public myz(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  @NotNull
  private String a()
  {
    return BaseApplicationImpl.getContext().getResources().getString(2131690233);
  }
  
  private String a(int paramInt)
  {
    return BaseApplicationImpl.getContext().getResources().getString(paramInt);
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, AvGameNotify.NotifyActorGiveOutAnswerS2CReq paramNotifyActorGiveOutAnswerS2CReq, long paramLong3)
  {
    String str = paramNotifyActorGiveOutAnswerS2CReq.tips.get();
    paramNotifyActorGiveOutAnswerS2CReq = mxo.b((AvGameCommon.GameQuestionInfo)paramNotifyActorGiveOutAnswerS2CReq.question_info.get(), false);
    mwu.a().b(mzi.class, 9, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, str, paramNotifyActorGiveOutAnswerS2CReq, Long.valueOf(paramLong3) });
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, AvGameNotify.NotifyAnswerRightS2CReq paramNotifyAnswerRightS2CReq, long paramLong3)
  {
    mxq localmxq = mxo.b((AvGameCommon.GameQuestionInfo)paramNotifyAnswerRightS2CReq.question_info.get(), false);
    AvGameCommon.RoomUserInfo localRoomUserInfo = paramNotifyAnswerRightS2CReq.actor_info;
    Player localPlayer = new Player();
    localPlayer.parseFrom(localRoomUserInfo);
    int i = paramNotifyAnswerRightS2CReq.score.get();
    mwu.a().b(mzi.class, 7, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, Integer.valueOf(i), localmxq, localPlayer, Long.valueOf(paramLong3) });
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, AvGameNotify.NotifyChangeActorS2CReq paramNotifyChangeActorS2CReq, long paramLong3)
  {
    mxq localmxq = mxo.b((AvGameCommon.GameQuestionInfo)paramNotifyChangeActorS2CReq.question_info.get(), false);
    paramNotifyChangeActorS2CReq = paramNotifyChangeActorS2CReq.actor_info;
    Player localPlayer = new Player();
    localPlayer.parseFrom(paramNotifyChangeActorS2CReq);
    mwu.a().b(mzi.class, 4, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, localmxq, localPlayer, Long.valueOf(paramLong3) });
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, AvGameNotify.NotifyChangeQuestionS2CReq paramNotifyChangeQuestionS2CReq, long paramLong3)
  {
    mxq localmxq = mxo.b((AvGameCommon.GameQuestionInfo)paramNotifyChangeQuestionS2CReq.question_info.get(), false);
    long l = paramNotifyChangeQuestionS2CReq.switcher_uin.get();
    Object localObject = null;
    paramNotifyChangeQuestionS2CReq = localObject;
    if (l > 0L) {}
    try
    {
      paramNotifyChangeQuestionS2CReq = Long.toString(l);
      mwu.a().b(mzi.class, 5, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, localmxq, paramNotifyChangeQuestionS2CReq, Long.valueOf(paramLong3) });
      return;
    }
    catch (Exception paramNotifyChangeQuestionS2CReq)
    {
      for (;;)
      {
        paramNotifyChangeQuestionS2CReq = localObject;
      }
    }
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, AvGameNotify.NotifyGameOverS2CReq paramNotifyGameOverS2CReq, long paramLong3)
  {
    mwu.a().b(mzi.class, 3, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, Long.valueOf(paramLong3) });
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, AvGameNotify.NotifyNextActorTipsS2CReq paramNotifyNextActorTipsS2CReq, long paramLong3)
  {
    String str = paramNotifyNextActorTipsS2CReq.tips.get();
    paramNotifyNextActorTipsS2CReq = paramNotifyNextActorTipsS2CReq.actor_info;
    Player localPlayer = new Player();
    localPlayer.parseFrom(paramNotifyNextActorTipsS2CReq);
    mwu.a().b(mzi.class, 6, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, str, localPlayer, Long.valueOf(paramLong3) });
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, AvGameNotify.NotifyQuestionTimeoutS2CReq paramNotifyQuestionTimeoutS2CReq, long paramLong3)
  {
    paramNotifyQuestionTimeoutS2CReq = mxo.b((AvGameCommon.GameQuestionInfo)paramNotifyQuestionTimeoutS2CReq.question_info.get(), false);
    mwu.a().b(mzi.class, 8, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, paramNotifyQuestionTimeoutS2CReq, Long.valueOf(paramLong3) });
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, AvGameNotify.NotifyTranslateInfoS2CReq paramNotifyTranslateInfoS2CReq, long paramLong3)
  {
    long l = paramNotifyTranslateInfoS2CReq.uin.get();
    int i = paramNotifyTranslateInfoS2CReq.trans_cost_time.get();
    String str = paramNotifyTranslateInfoS2CReq.play_game_id.get();
    paramNotifyTranslateInfoS2CReq = paramNotifyTranslateInfoS2CReq.answer.get();
    mwu.a().a(mzi.class, 12, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, Long.valueOf(l), Integer.valueOf(i), str, paramNotifyTranslateInfoS2CReq, Long.valueOf(paramLong3) });
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, AvGameNotify.RoomOwnerStartGameS2CReq paramRoomOwnerStartGameS2CReq, long paramLong3)
  {
    Object localObject1 = (AvGameCommon.RoomUserInfo)paramRoomOwnerStartGameS2CReq.actor_info.get();
    Object localObject2 = (AvGameCommon.GameQuestionInfo)paramRoomOwnerStartGameS2CReq.question_info.get();
    AvGameCommon.GameInfo localGameInfo = (AvGameCommon.GameInfo)paramRoomOwnerStartGameS2CReq.game_info.get();
    localObject2 = mxo.b((AvGameCommon.GameQuestionInfo)localObject2, false);
    if (localObject2 == null)
    {
      QLog.d("avgame_logic.GamePlayHandler", 1, "handleGameStartPush topic=null return");
      return;
    }
    Player localPlayer = new Player();
    localPlayer.parseFrom((AvGameCommon.RoomUserInfo)localObject1);
    localObject1 = new myf();
    ((myf)localObject1).a(localGameInfo);
    if (paramRoomOwnerStartGameS2CReq.question_class.has()) {
      ((myf)localObject1).a = paramRoomOwnerStartGameS2CReq.question_class.get();
    }
    mwu.a().b(mzi.class, 2, true, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, localObject1, localPlayer, localObject2, Long.valueOf(paramLong3) });
  }
  
  /* Error */
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 209	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc 210
    //   6: ldc 212
    //   8: invokevirtual 217	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   11: astore 13
    //   13: aload_1
    //   14: getfield 209	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   17: ldc 219
    //   19: invokevirtual 223	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   22: lstore 7
    //   24: aload_1
    //   25: getfield 209	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   28: ldc 225
    //   30: invokevirtual 229	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   33: istore 6
    //   35: aload_1
    //   36: getfield 209	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   39: ldc 231
    //   41: ldc 212
    //   43: invokevirtual 217	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   46: astore 15
    //   48: ldc 232
    //   50: istore 5
    //   52: ldc 212
    //   54: astore 11
    //   56: new 234	com/tencent/avgame/gamelogic/data/RoomInfo
    //   59: dup
    //   60: invokespecial 235	com/tencent/avgame/gamelogic/data/RoomInfo:<init>	()V
    //   63: astore 14
    //   65: aload_2
    //   66: invokevirtual 240	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   69: ifeq +505 -> 574
    //   72: new 242	trpc/qq_vgame/playgame/AvGamePlay$StartGameRsp
    //   75: dup
    //   76: invokespecial 243	trpc/qq_vgame/playgame/AvGamePlay$StartGameRsp:<init>	()V
    //   79: astore 16
    //   81: aload 16
    //   83: aload_3
    //   84: checkcast 245	[B
    //   87: checkcast 245	[B
    //   90: invokevirtual 249	trpc/qq_vgame/playgame/AvGamePlay$StartGameRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   93: pop
    //   94: aload 16
    //   96: getfield 253	trpc/qq_vgame/playgame/AvGamePlay$StartGameRsp:res	Ltrpc/qq_vgame/common/AvGameCommon$Result;
    //   99: invokevirtual 256	trpc/qq_vgame/common/AvGameCommon$Result:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   102: checkcast 255	trpc/qq_vgame/common/AvGameCommon$Result
    //   105: getfield 259	trpc/qq_vgame/common/AvGameCommon$Result:errcode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   108: invokevirtual 103	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   111: istore 4
    //   113: aload 16
    //   115: getfield 253	trpc/qq_vgame/playgame/AvGamePlay$StartGameRsp:res	Ltrpc/qq_vgame/common/AvGameCommon$Result;
    //   118: invokevirtual 256	trpc/qq_vgame/common/AvGameCommon$Result:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   121: checkcast 255	trpc/qq_vgame/common/AvGameCommon$Result
    //   124: getfield 263	trpc/qq_vgame/common/AvGameCommon$Result:errmsg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   127: invokevirtual 268	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   130: invokevirtual 273	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   133: astore_1
    //   134: aload 14
    //   136: aload 16
    //   138: getfield 277	trpc/qq_vgame/playgame/AvGamePlay$StartGameRsp:room_info	Ltrpc/qq_vgame/common/AvGameCommon$RoomInfo;
    //   141: invokevirtual 280	com/tencent/avgame/gamelogic/data/RoomInfo:parseFrom	(Ltrpc/qq_vgame/common/AvGameCommon$RoomInfo;)V
    //   144: aload 16
    //   146: getfield 284	trpc/qq_vgame/playgame/AvGamePlay$StartGameRsp:low_version_users	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   149: invokevirtual 287	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   152: ifeq +417 -> 569
    //   155: aload 16
    //   157: getfield 284	trpc/qq_vgame/playgame/AvGamePlay$StartGameRsp:low_version_users	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   160: invokevirtual 290	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   163: astore 11
    //   165: new 292	java/util/ArrayList
    //   168: dup
    //   169: aload 11
    //   171: invokeinterface 297 1 0
    //   176: invokespecial 300	java/util/ArrayList:<init>	(I)V
    //   179: astore_3
    //   180: aload 11
    //   182: invokeinterface 304 1 0
    //   187: astore 11
    //   189: aload 11
    //   191: invokeinterface 309 1 0
    //   196: ifeq +268 -> 464
    //   199: aload_3
    //   200: aload 11
    //   202: invokeinterface 313 1 0
    //   207: checkcast 165	trpc/qq_vgame/common/AvGameCommon$RoomUserInfo
    //   210: getfield 314	trpc/qq_vgame/common/AvGameCommon$RoomUserInfo:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   213: invokevirtual 128	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   216: invokestatic 74	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   219: invokeinterface 318 2 0
    //   224: pop
    //   225: goto -36 -> 189
    //   228: astore 11
    //   230: aload_3
    //   231: astore 12
    //   233: aload_1
    //   234: astore_3
    //   235: aload 12
    //   237: astore_1
    //   238: ldc 176
    //   240: iconst_1
    //   241: new 320	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 321	java/lang/StringBuilder:<init>	()V
    //   248: ldc_w 323
    //   251: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload 11
    //   256: invokevirtual 330	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 332	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 335	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: aload_1
    //   266: astore 11
    //   268: aload_3
    //   269: astore_1
    //   270: aload 11
    //   272: astore_3
    //   273: ldc 176
    //   275: ldc_w 337
    //   278: aconst_null
    //   279: iconst_1
    //   280: anewarray 339	com/tencent/mobileqq/pb/MessageMicro
    //   283: dup
    //   284: iconst_0
    //   285: aload 16
    //   287: aastore
    //   288: invokestatic 342	mxo:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;[Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   291: iload 4
    //   293: ifne +270 -> 563
    //   296: aload_0
    //   297: aload 13
    //   299: lload 7
    //   301: iload 6
    //   303: aload 15
    //   305: aload 16
    //   307: invokespecial 345	myz:a	(Ljava/lang/String;JILjava/lang/String;Ltrpc/qq_vgame/playgame/AvGamePlay$StartGameRsp;)Z
    //   310: istore 9
    //   312: iload 9
    //   314: istore 10
    //   316: iload 4
    //   318: istore 5
    //   320: iload 9
    //   322: ifne +86 -> 408
    //   325: aload_1
    //   326: astore 11
    //   328: aload_1
    //   329: invokestatic 351	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   332: ifeq +9 -> 341
    //   335: aload_0
    //   336: invokespecial 353	myz:a	()Ljava/lang/String;
    //   339: astore 11
    //   341: invokestatic 64	mwu:a	()Lmwu;
    //   344: ldc 66
    //   346: iconst_0
    //   347: iconst_0
    //   348: bipush 7
    //   350: anewarray 68	java/lang/Object
    //   353: dup
    //   354: iconst_0
    //   355: aload 13
    //   357: aastore
    //   358: dup
    //   359: iconst_1
    //   360: lload 7
    //   362: invokestatic 74	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   365: aastore
    //   366: dup
    //   367: iconst_2
    //   368: iload 6
    //   370: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   373: aastore
    //   374: dup
    //   375: iconst_3
    //   376: iload 4
    //   378: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   381: aastore
    //   382: dup
    //   383: iconst_4
    //   384: aload 11
    //   386: aastore
    //   387: dup
    //   388: iconst_5
    //   389: aload 14
    //   391: aastore
    //   392: dup
    //   393: bipush 6
    //   395: aload_3
    //   396: aastore
    //   397: invokevirtual 77	mwu:b	(Ljava/lang/Class;IZLjava/lang/Object;)V
    //   400: iload 4
    //   402: istore 5
    //   404: iload 9
    //   406: istore 10
    //   408: ldc 176
    //   410: iconst_1
    //   411: bipush 6
    //   413: anewarray 68	java/lang/Object
    //   416: dup
    //   417: iconst_0
    //   418: ldc_w 355
    //   421: aastore
    //   422: dup
    //   423: iconst_1
    //   424: iload 10
    //   426: invokestatic 360	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   429: aastore
    //   430: dup
    //   431: iconst_2
    //   432: ldc_w 362
    //   435: aastore
    //   436: dup
    //   437: iconst_3
    //   438: aload_2
    //   439: invokevirtual 240	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   442: invokestatic 360	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   445: aastore
    //   446: dup
    //   447: iconst_4
    //   448: ldc_w 364
    //   451: aastore
    //   452: dup
    //   453: iconst_5
    //   454: iload 5
    //   456: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   459: aastore
    //   460: invokestatic 367	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   463: return
    //   464: goto -191 -> 273
    //   467: astore_1
    //   468: aconst_null
    //   469: astore_1
    //   470: ldc 232
    //   472: istore 4
    //   474: aload 11
    //   476: astore_3
    //   477: aload_3
    //   478: astore 11
    //   480: aload_1
    //   481: astore_3
    //   482: aload 11
    //   484: astore_1
    //   485: goto -212 -> 273
    //   488: astore_1
    //   489: aconst_null
    //   490: astore_1
    //   491: aload 11
    //   493: astore_3
    //   494: goto -17 -> 477
    //   497: astore_3
    //   498: aconst_null
    //   499: astore 11
    //   501: aload_1
    //   502: astore_3
    //   503: aload 11
    //   505: astore_1
    //   506: goto -29 -> 477
    //   509: astore 11
    //   511: aload_1
    //   512: astore 11
    //   514: aload_3
    //   515: astore_1
    //   516: aload 11
    //   518: astore_3
    //   519: goto -42 -> 477
    //   522: astore 12
    //   524: aconst_null
    //   525: astore_1
    //   526: ldc 232
    //   528: istore 4
    //   530: aload 11
    //   532: astore_3
    //   533: aload 12
    //   535: astore 11
    //   537: goto -299 -> 238
    //   540: astore 12
    //   542: aconst_null
    //   543: astore_1
    //   544: aload 11
    //   546: astore_3
    //   547: aload 12
    //   549: astore 11
    //   551: goto -313 -> 238
    //   554: astore 11
    //   556: aload_1
    //   557: astore_3
    //   558: aconst_null
    //   559: astore_1
    //   560: goto -322 -> 238
    //   563: iconst_0
    //   564: istore 9
    //   566: goto -254 -> 312
    //   569: aconst_null
    //   570: astore_3
    //   571: goto -107 -> 464
    //   574: iconst_0
    //   575: istore 10
    //   577: goto -169 -> 408
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	580	0	this	myz
    //   0	580	1	paramToServiceMsg	ToServiceMsg
    //   0	580	2	paramFromServiceMsg	FromServiceMsg
    //   0	580	3	paramObject	Object
    //   111	418	4	i	int
    //   50	405	5	j	int
    //   33	336	6	k	int
    //   22	339	7	l	long
    //   310	255	9	bool1	boolean
    //   314	262	10	bool2	boolean
    //   54	147	11	localObject1	Object
    //   228	27	11	localInvalidProtocolBufferMicroException1	InvalidProtocolBufferMicroException
    //   266	238	11	localObject2	Object
    //   509	1	11	localException	Exception
    //   512	38	11	localObject3	Object
    //   554	1	11	localInvalidProtocolBufferMicroException2	InvalidProtocolBufferMicroException
    //   231	5	12	localObject4	Object
    //   522	12	12	localInvalidProtocolBufferMicroException3	InvalidProtocolBufferMicroException
    //   540	8	12	localInvalidProtocolBufferMicroException4	InvalidProtocolBufferMicroException
    //   11	345	13	str1	String
    //   63	327	14	localRoomInfo	com.tencent.avgame.gamelogic.data.RoomInfo
    //   46	258	15	str2	String
    //   79	227	16	localStartGameRsp	AvGamePlay.StartGameRsp
    // Exception table:
    //   from	to	target	type
    //   180	189	228	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   189	225	228	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   81	113	467	java/lang/Exception
    //   113	134	488	java/lang/Exception
    //   134	180	497	java/lang/Exception
    //   180	189	509	java/lang/Exception
    //   189	225	509	java/lang/Exception
    //   81	113	522	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   113	134	540	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   134	180	554	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    String str = paramToServiceMsg.extraData.getString("gameId");
    long l1 = paramToServiceMsg.extraData.getLong("roomId");
    boolean bool = false;
    int i = -2147483648;
    paramToServiceMsg = "";
    ToServiceMsg localToServiceMsg = paramToServiceMsg;
    int j = i;
    int k;
    if (paramFromServiceMsg.isSuccess())
    {
      AvGameQuestionInfo.CmdGetQuestionRsp localCmdGetQuestionRsp = new AvGameQuestionInfo.CmdGetQuestionRsp();
      j = i;
      k = i;
      try
      {
        localCmdGetQuestionRsp.mergeFrom(paramArrayOfByte);
        j = i;
        k = i;
        i = ((AvGameCommon.Result)localCmdGetQuestionRsp.res.get()).errcode.get();
        j = i;
        k = i;
        paramArrayOfByte = ((AvGameCommon.Result)localCmdGetQuestionRsp.res.get()).errmsg.get().toStringUtf8();
        paramToServiceMsg = paramArrayOfByte;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        for (;;)
        {
          long l2;
          QLog.e("avgame_logic.GamePlayHandler", 1, paramString + ":" + paramArrayOfByte);
          i = j;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          i = k;
          continue;
          bool = false;
          continue;
          paramToServiceMsg = a(2131690350);
          continue;
          bool = false;
        }
      }
      mxo.a("avgame_logic.GamePlayHandler", paramString, new String[] { "rsp" }, new MessageMicro[] { localCmdGetQuestionRsp });
      localToServiceMsg = paramToServiceMsg;
      j = i;
      if (i == 0) {
        if (paramInt == 13)
        {
          bool = true;
          paramArrayOfByte = mxo.b((AvGameCommon.GameQuestionInfo)localCmdGetQuestionRsp.question_info.get(), bool);
          l2 = localCmdGetQuestionRsp.seq.get();
          if (paramArrayOfByte == null) {
            break label496;
          }
          bool = true;
          mwu.a().b(mzi.class, paramInt, true, new Object[] { Long.valueOf(l1), str, Long.valueOf(l2), paramArrayOfByte });
          if (QLog.isColorLevel()) {
            QLog.i("avgame_logic.GamePlayHandler", 2, String.format("%s topic=%s", new Object[] { paramString, paramArrayOfByte }));
          }
        }
      }
    }
    for (;;)
    {
      if (!bool)
      {
        if (paramInt == 1)
        {
          if (i == 202) {
            paramToServiceMsg = a(2131690351);
          }
        }
        else {
          mwu.a().b(mzi.class, paramInt, false, new Object[] { Long.valueOf(l1), str, paramToServiceMsg });
        }
      }
      else
      {
        QLog.d("avgame_logic.GamePlayHandler", 1, new Object[] { paramString, " suc=", Boolean.valueOf(bool), " rspResult=", Boolean.valueOf(paramFromServiceMsg.isSuccess()), " errCode=", Integer.valueOf(i), " roomId=", Long.valueOf(l1), " gameId=", str });
        return;
      }
      label496:
      paramToServiceMsg = localToServiceMsg;
      i = j;
    }
  }
  
  private void a(String paramString1, long paramLong, String paramString2, int paramInt, String paramString3)
  {
    AvGameQuestionInfo.CmdGetQuestionReq localCmdGetQuestionReq = new AvGameQuestionInfo.CmdGetQuestionReq();
    localCmdGetQuestionReq.play_game_id.set(paramString2);
    localCmdGetQuestionReq.uin.set(Long.parseLong(paramString1));
    localCmdGetQuestionReq.req_src.set(0);
    localCmdGetQuestionReq.req_type.set(paramInt);
    paramString1 = createToServiceMsg("qqvgame.QuestionManager-GetQuestion");
    paramString1.extraData.putString("gameId", paramString2);
    paramString1.extraData.putLong("roomId", paramLong);
    paramString1.extraData.putInt("reqType", paramInt);
    paramString1.putWupBuffer(localCmdGetQuestionReq.toByteArray());
    sendPbReq(paramString1);
    QLog.d("avgame_logic.GamePlayHandler", 1, String.format("%s reqType=%d roomId=%d gameId=%s", new Object[] { paramString3, Integer.valueOf(paramInt), Long.valueOf(paramLong), paramString2 }));
  }
  
  private boolean a(String paramString1, long paramLong, int paramInt, String paramString2, AvGamePlay.StartGameRsp paramStartGameRsp)
  {
    long l = paramStartGameRsp.seq.get();
    String str = paramStartGameRsp.play_game_id.get();
    Object localObject = (AvGameCommon.RoomUserInfo)paramStartGameRsp.actor_info.get();
    AvGameCommon.GameInfo localGameInfo = (AvGameCommon.GameInfo)paramStartGameRsp.game_info.get();
    AvGameCommon.GameQuestionInfo localGameQuestionInfo = (AvGameCommon.GameQuestionInfo)paramStartGameRsp.question_info.get();
    paramStartGameRsp = new Player();
    paramStartGameRsp.parseFrom((AvGameCommon.RoomUserInfo)localObject);
    localObject = new myf();
    ((myf)localObject).a(localGameInfo);
    ((myf)localObject).a = paramString2;
    paramString2 = mxo.b(localGameQuestionInfo, false);
    if (paramString2 == null)
    {
      QLog.d("avgame_logic.GamePlayHandler", 1, "onHandleStartGameReq topic=null return");
      return false;
    }
    mwu.a().b(mzi.class, 0, true, new Object[] { paramString1, Long.valueOf(paramLong), Integer.valueOf(paramInt), Long.valueOf(l), str, localObject, paramStartGameRsp, paramString2 });
    return true;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str1 = paramToServiceMsg.extraData.getString("gameId");
    String str2 = paramToServiceMsg.extraData.getString("uin");
    int k = -2147483648;
    int i;
    int j;
    boolean bool;
    if (paramFromServiceMsg.isSuccess())
    {
      AvGameRanking.GetRankingListRsp localGetRankingListRsp = new AvGameRanking.GetRankingListRsp();
      i = k;
      j = k;
      try
      {
        localGetRankingListRsp.mergeFrom((byte[])paramObject);
        i = k;
        j = k;
        k = ((AvGameCommon.Result)localGetRankingListRsp.res.get()).errcode.get();
        i = k;
        j = k;
        paramToServiceMsg = ((AvGameCommon.Result)localGetRankingListRsp.res.get()).errmsg.get().toStringUtf8();
        i = k;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;)
        {
          QLog.e("avgame_logic.GamePlayHandler", 1, "handleGetRankingListReq:" + paramToServiceMsg);
          paramToServiceMsg = "";
        }
      }
      catch (Exception paramToServiceMsg)
      {
        for (;;)
        {
          i = j;
          paramToServiceMsg = "";
          continue;
          bool = false;
        }
      }
      mxo.a("avgame_logic.GamePlayHandler", "handleGetRankingListReq", new String[] { "rsp" }, new MessageMicro[] { localGetRankingListRsp });
      if (i == 0)
      {
        bool = true;
        paramObject = mxo.a(localGetRankingListRsp);
        mwu.a().b(mzi.class, 10, true, new Object[] { str2, str1, paramObject });
      }
    }
    for (;;)
    {
      if (!bool)
      {
        paramObject = paramToServiceMsg;
        if (TextUtils.isEmpty(paramToServiceMsg)) {
          paramObject = a();
        }
        mwu.a().b(mzi.class, 10, false, new Object[] { str2, str1, paramObject });
      }
      QLog.d("avgame_logic.GamePlayHandler", 1, new Object[] { "handleGetRankingListReq suc=", Boolean.valueOf(bool), " rspResult=", Boolean.valueOf(paramFromServiceMsg.isSuccess()), " errCode=", Integer.valueOf(i), " gameId=", str1 });
      return;
      paramToServiceMsg = "";
      i = -2147483648;
      bool = false;
    }
  }
  
  public void a(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    AvGamePlay.StartGameReq localStartGameReq = new AvGamePlay.StartGameReq();
    localStartGameReq.uin.set(Long.valueOf(paramString1).longValue());
    localStartGameReq.roomid.set(paramLong);
    localStartGameReq.type.set(paramInt);
    if (paramString2 != null) {
      localStartGameReq.question_class.set(paramString2);
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.GameManager-StartGame");
    localToServiceMsg.extraData.putString("uin", paramString1);
    localToServiceMsg.extraData.putLong("roomId", paramLong);
    localToServiceMsg.extraData.putInt("gameType", paramInt);
    if (paramString2 != null) {
      localToServiceMsg.extraData.putString("questionClass", paramString2);
    }
    localToServiceMsg.putWupBuffer(localStartGameReq.toByteArray());
    sendPbReq(localToServiceMsg);
    QLog.d("avgame_logic.GamePlayHandler", 1, new Object[] { "startGameReq roomId=", Long.valueOf(paramLong), " hostUin=", paramString1 });
  }
  
  public void a(String paramString1, long paramLong, String paramString2)
  {
    a(paramString1, paramLong, paramString2, 0, "switchTopicReq()");
  }
  
  public void a(String paramString1, long paramLong, String paramString2, boolean paramBoolean)
  {
    a(paramString1, paramLong, paramString2, 1, "pullTopics() fromStart=" + paramBoolean);
  }
  
  public void a(String paramString1, String paramString2)
  {
    AvGameRanking.GetRankingListReq localGetRankingListReq = new AvGameRanking.GetRankingListReq();
    localGetRankingListReq.play_game_id.set(paramString2);
    localGetRankingListReq.uin.set(Long.parseLong(paramString1));
    ToServiceMsg localToServiceMsg = createToServiceMsg("qqvgame.GameRanking-GetRankingList");
    localToServiceMsg.extraData.putString("uin", paramString1);
    localToServiceMsg.extraData.putString("gameId", paramString2);
    localToServiceMsg.putWupBuffer(localGetRankingListReq.toByteArray());
    sendPbReq(localToServiceMsg);
    QLog.d("avgame_logic.GamePlayHandler", 1, String.format("getRankingListReq gameId=%s", new Object[] { paramString2 }));
  }
  
  public void a(AvGameNotify.NotifyMsg paramNotifyMsg)
  {
    int i = paramNotifyMsg.type.get();
    long l1 = paramNotifyMsg.seq.get();
    long l2 = paramNotifyMsg.roomid.get();
    String str = paramNotifyMsg.play_game_id.get();
    long l3 = SystemClock.elapsedRealtime();
    QLog.d("avgame_logic.GamePlayHandler", 1, String.format("handleOnlinePush type=%d [%s] seq=%d roomId=%d gameId=%s", new Object[] { Integer.valueOf(i), mxo.a(i), Long.valueOf(l1), Long.valueOf(l2), str }));
    switch (i)
    {
    default: 
      return;
    case 102: 
      paramNotifyMsg = (AvGameNotify.RoomOwnerStartGameS2CReq)paramNotifyMsg.start_game_req.get();
      mxo.a("avgame_logic.GamePlayHandler", "NT_GAME_START", null, new MessageMicro[] { paramNotifyMsg });
      a(l1, l2, str, paramNotifyMsg, l3);
      return;
    case 110: 
      paramNotifyMsg = (AvGameNotify.NotifyGameOverS2CReq)paramNotifyMsg.game_over_req.get();
      mxo.a("avgame_logic.GamePlayHandler", "NT_GAME_OVER", null, new MessageMicro[] { paramNotifyMsg });
      a(l1, l2, str, paramNotifyMsg, l3);
      return;
    case 105: 
      paramNotifyMsg = (AvGameNotify.NotifyChangeQuestionS2CReq)paramNotifyMsg.change_question_req.get();
      mxo.a("avgame_logic.GamePlayHandler", "NT_TOPIC_CHANGE", null, new MessageMicro[] { paramNotifyMsg });
      a(l1, l2, str, paramNotifyMsg, l3);
      return;
    case 106: 
      paramNotifyMsg = (AvGameNotify.NotifyNextActorTipsS2CReq)paramNotifyMsg.next_actor_tips_req.get();
      mxo.a("avgame_logic.GamePlayHandler", "NT_NEXT_ACTOR_TIPS", null, new MessageMicro[] { paramNotifyMsg });
      a(l1, l2, str, paramNotifyMsg, l3);
      return;
    case 107: 
      paramNotifyMsg = (AvGameNotify.NotifyChangeActorS2CReq)paramNotifyMsg.change_actor_req.get();
      mxo.a("avgame_logic.GamePlayHandler", "NT_ACTOR_CHANGE", null, new MessageMicro[] { paramNotifyMsg });
      a(l1, l2, str, paramNotifyMsg, l3);
      return;
    case 103: 
      paramNotifyMsg = (AvGameNotify.NotifyAnswerRightS2CReq)paramNotifyMsg.answer_right_req.get();
      mxo.a("avgame_logic.GamePlayHandler", "NT_ANSWER_RIGHT", null, new MessageMicro[] { paramNotifyMsg });
      a(l1, l2, str, paramNotifyMsg, l3);
      return;
    case 104: 
      paramNotifyMsg = (AvGameNotify.NotifyQuestionTimeoutS2CReq)paramNotifyMsg.question_timeout_req.get();
      mxo.a("avgame_logic.GamePlayHandler", "NT_TOPIC_TIMEOUT", null, new MessageMicro[] { paramNotifyMsg });
      a(l1, l2, str, paramNotifyMsg, l3);
      return;
    case 108: 
      paramNotifyMsg = (AvGameNotify.NotifyActorGiveOutAnswerS2CReq)paramNotifyMsg.actor_giveout_answer_req.get();
      mxo.a("avgame_logic.GamePlayHandler", "NT_ACTOR_GIVEOUT_ANSWER", null, new MessageMicro[] { paramNotifyMsg });
      a(l1, l2, str, paramNotifyMsg, l3);
      return;
    }
    paramNotifyMsg = (AvGameNotify.NotifyTranslateInfoS2CReq)paramNotifyMsg.translate_info_req.get();
    mxo.a("avgame_logic.GamePlayHandler", "NT_TRANSLATE_INFO", null, new MessageMicro[] { paramNotifyMsg });
    a(l1, l2, str, paramNotifyMsg, l3);
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("qqvgame.GameManager-StartGame");
      this.allowCmdSet.add("qqvgame.QuestionManager-GetQuestion");
      this.allowCmdSet.add("qqvgame.GameRanking-GetRankingList");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends anil> observerClass()
  {
    return mzi.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("qqvgame.GameManager-StartGame".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      int i;
      do
      {
        return;
        if (!"qqvgame.QuestionManager-GetQuestion".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
          break;
        }
        i = paramToServiceMsg.extraData.getInt("reqType");
        if (i == 0)
        {
          a(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject, "handleSwitchTopicReq()", 1);
          return;
        }
      } while (i != 1);
      a(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject, "handlePullTopics()", 13);
      return;
    } while (!"qqvgame.GameRanking-GetRankingList".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()));
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     myz
 * JD-Core Version:    0.7.0.1
 */