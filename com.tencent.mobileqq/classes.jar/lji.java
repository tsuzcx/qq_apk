import android.os.Bundle;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.redpacket.AVRedPacketManager.GameInfoFromBusiServer;
import com.tencent.av.redpacket.AVRedPacketManager.LocalEmojiInfo;
import com.tencent.av.redpacket.AVRedPacketManager.LocalFrameSyncInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.protofile.avredpacket.AVRedPacketGameSyncInfo.C2CGameInfo;
import com.tencent.protofile.avredpacket.AVRedPacketGameSyncInfo.Emoji;
import com.tencent.protofile.avredpacket.AVRedPacketGameSyncInfo.FocusInfo;
import com.tencent.protofile.avredpacket.AVRedPacketGameSyncInfo.FrameSyncInfo;
import com.tencent.protofile.avredpacket.AVRedPacketGameSyncInfo.HitInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0xa75.oidb_0xa75.ReqBody;
import tencent.im.oidb.cmd0xa75.oidb_0xa75.RspBody;

public class lji
  extends ajfb
{
  public VideoAppInterface a;
  kwc jdField_a_of_type_Kwc = new ljj(this);
  kwe jdField_a_of_type_Kwe = new ljk(this);
  public boolean a;
  public boolean b;
  
  public lji(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    c();
  }
  
  private AVRedPacketManager.GameInfoFromBusiServer a(ToServiceMsg paramToServiceMsg, oidb_0xa75.RspBody paramRspBody)
  {
    paramToServiceMsg = new AVRedPacketManager.GameInfoFromBusiServer();
    if (paramRspBody.rpt_uint32_emoji_id.has()) {
      paramToServiceMsg.emojiIds = paramRspBody.rpt_uint32_emoji_id.get();
    }
    if (paramRspBody.uint32_start_time.has()) {
      paramToServiceMsg.gameStartTime = paramRspBody.uint32_start_time.get();
    }
    if (paramRspBody.uint32_rest_time.has()) {
      paramToServiceMsg.gameRestTime = paramRspBody.uint32_rest_time.get();
    }
    if (paramRspBody.uint32_status.has()) {
      paramToServiceMsg.gameStatus = paramRspBody.uint32_status.get();
    }
    if (paramRspBody.uint32_score_max.has()) {
      paramToServiceMsg.maxScore = paramRspBody.uint32_score_max.get();
    }
    if (paramRspBody.uint32_red_packet_win.has()) {
      paramToServiceMsg.winMoney = paramRspBody.uint32_red_packet_win.get();
    }
    if (paramRspBody.bytes_authkey.has()) {
      paramToServiceMsg.authKey = paramRspBody.bytes_authkey.get().toStringUtf8();
    }
    return paramToServiceMsg;
  }
  
  private AVRedPacketManager.LocalFrameSyncInfo a(AVRedPacketGameSyncInfo.FrameSyncInfo paramFrameSyncInfo)
  {
    AVRedPacketManager.LocalFrameSyncInfo localLocalFrameSyncInfo = new AVRedPacketManager.LocalFrameSyncInfo();
    localLocalFrameSyncInfo.curScore = paramFrameSyncInfo.currScores.get();
    if (paramFrameSyncInfo.emojis.has())
    {
      int i = 0;
      while (i < paramFrameSyncInfo.emojis.size())
      {
        AVRedPacketGameSyncInfo.Emoji localEmoji = (AVRedPacketGameSyncInfo.Emoji)((AVRedPacketGameSyncInfo.Emoji)paramFrameSyncInfo.emojis.get(i)).get();
        AVRedPacketManager.LocalEmojiInfo localLocalEmojiInfo = new AVRedPacketManager.LocalEmojiInfo();
        localLocalEmojiInfo.emojiId = localEmoji.id.get();
        localLocalEmojiInfo.emojiType = AVRedPacketManager.a(localEmoji.emojiTypeId.get());
        localLocalEmojiInfo.startTime = localEmoji.startTime.get();
        localLocalEmojiInfo.trackNum = localEmoji.trackNum.get();
        localLocalEmojiInfo.isBigEmoji = localEmoji.isBigEmoji.get();
        localLocalEmojiInfo.fallDownDuration = localEmoji.fallDownDuration.get();
        localLocalFrameSyncInfo.localEmojiInfos.add(localLocalEmojiInfo);
        i += 1;
      }
    }
    if (paramFrameSyncInfo.focusInfo.has()) {
      localLocalFrameSyncInfo.localFocusInfo.emojiId = paramFrameSyncInfo.focusInfo.id.get();
    }
    if (paramFrameSyncInfo.hitInfo.has())
    {
      localLocalFrameSyncInfo.localHitInfo.emojiId = paramFrameSyncInfo.hitInfo.id.get();
      localLocalFrameSyncInfo.localHitInfo.topWordTipType = paramFrameSyncInfo.hitInfo.topWordTipType.get();
      localLocalFrameSyncInfo.localHitInfo.comboCnt = paramFrameSyncInfo.hitInfo.comboCnt.get();
      localLocalFrameSyncInfo.localHitInfo.newAddScore = paramFrameSyncInfo.hitInfo.newAddScore.get();
      localLocalFrameSyncInfo.localHitInfo.hitStartTime = paramFrameSyncInfo.hitInfo.startTime.get();
    }
    if (paramFrameSyncInfo.frameSyncGameState.has()) {
      localLocalFrameSyncInfo.frameSyncGameState = paramFrameSyncInfo.frameSyncGameState.get();
    }
    if (paramFrameSyncInfo.seq.has()) {
      localLocalFrameSyncInfo.seq = paramFrameSyncInfo.seq.get();
    }
    return localLocalFrameSyncInfo;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    paramBundle = new oidb_0xa75.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramBundle);
    int j = paramToServiceMsg.extraData.getInt("actionType", -1);
    paramFromServiceMsg = null;
    boolean bool;
    if (i == 0)
    {
      paramFromServiceMsg = a(paramToServiceMsg, paramBundle);
      bool = true;
      if (paramFromServiceMsg != null) {
        break label204;
      }
      paramFromServiceMsg = new AVRedPacketManager.GameInfoFromBusiServer();
    }
    label204:
    for (;;)
    {
      paramFromServiceMsg.key = paramToServiceMsg.extraData.getString("key", "");
      paramFromServiceMsg.sendRedPacketUin = paramToServiceMsg.extraData.getString("fromUin", "");
      paramFromServiceMsg.receiveRedPacketUin = paramToServiceMsg.extraData.getString("toUin", "");
      paramFromServiceMsg.currScores = paramToServiceMsg.extraData.getInt("currScores", 0);
      QLog.d("AVRedPacketHandler", 2, "handleSyncGameInfoForBusiServer, isSuc=" + bool + ",result=" + i + ",actionType=" + j);
      ((AVRedPacketManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(6)).a(bool, j, paramFromServiceMsg);
      return;
      bool = false;
      break;
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketHandler", 2, "registerC2CHandler, hasRegisterC2CHandler: " + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    kwb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(9, this.jdField_a_of_type_Kwc);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketHandler", 2, "registerC2CHandler, hasRegisterFrameHandler: " + this.b);
    }
    if (this.b) {
      return;
    }
    this.b = kwb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(5, this.jdField_a_of_type_Kwe);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketHandler", 2, "syncGameInfoToBusiServer, actionType=" + paramInt);
    }
    try
    {
      Object localObject = new oidb_0xa75.ReqBody();
      ((oidb_0xa75.ReqBody)localObject).uint32_action.set(paramInt);
      ((oidb_0xa75.ReqBody)localObject).bytes_red_packet_id.set(ByteStringMicro.copyFrom(paramBundle.getString("key", "").getBytes()));
      ((oidb_0xa75.ReqBody)localObject).uint64_from_uin.set(Long.parseLong(paramBundle.getString("fromUin", "0")));
      ((oidb_0xa75.ReqBody)localObject).uint64_to_uin.set(Long.parseLong(paramBundle.getString("toUin", "0")));
      ((oidb_0xa75.ReqBody)localObject).uint32_cur_score.set(paramBundle.getInt("currScores", 0));
      ((oidb_0xa75.ReqBody)localObject).uint32_red_packet_total.set(0);
      localObject = makeOIDBPkg("OidbSvc.0xa75", 2677, 0, ((oidb_0xa75.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putInt("actionType", paramInt);
      ((ToServiceMsg)localObject).extraData.putString("key", paramBundle.getString("key", ""));
      ((ToServiceMsg)localObject).extraData.putString("fromUin", paramBundle.getString("fromUin", ""));
      ((ToServiceMsg)localObject).extraData.putString("toUin", paramBundle.getString("toUin", ""));
      ((ToServiceMsg)localObject).extraData.putInt("currScores", paramBundle.getInt("currScores", 0));
      if ((paramInt == 1) || (paramInt == 3)) {
        ((ToServiceMsg)localObject).setTimeout(15000L);
      }
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AVRedPacketHandler", 2, paramBundle, new Object[0]);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketHandler", 2, "unRegisterFrameHandler, hasRegisterFrameHandler: " + this.b);
    }
    kwb localkwb = kwb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    if (localkwb != null) {
      localkwb.b(5, this.jdField_a_of_type_Kwe);
    }
    this.b = false;
  }
  
  public void b(int paramInt, Bundle paramBundle)
  {
    Object localObject2 = null;
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketHandler", 2, "sendC2CMsg_StartGame, subType: " + paramInt + ",bundle=" + paramBundle);
    }
    c();
    Object localObject1;
    if ((paramInt == 1) && (paramBundle != null))
    {
      localObject1 = new AVRedPacketGameSyncInfo.C2CGameInfo();
      ((AVRedPacketGameSyncInfo.C2CGameInfo)localObject1).key.set(paramBundle.getString("key", ""));
      ((AVRedPacketGameSyncInfo.C2CGameInfo)localObject1).state.set(paramBundle.getInt("gameState", 0));
      ((AVRedPacketGameSyncInfo.C2CGameInfo)localObject1).fromWho.set(paramBundle.getInt("fromWho", 0));
      ((AVRedPacketGameSyncInfo.C2CGameInfo)localObject1).money.set(paramBundle.getString("money", "0.00"));
      ((AVRedPacketGameSyncInfo.C2CGameInfo)localObject1).resultCode.set(paramBundle.getInt("resultCode", 0));
      ((AVRedPacketGameSyncInfo.C2CGameInfo)localObject1).resultState.set(paramBundle.getString("resultState", ""));
      ((AVRedPacketGameSyncInfo.C2CGameInfo)localObject1).scores.set(paramBundle.getInt("hitScore", 0));
      ((AVRedPacketGameSyncInfo.C2CGameInfo)localObject1).musicId.set(paramBundle.getInt("musicId", 0));
      ((AVRedPacketGameSyncInfo.C2CGameInfo)localObject1).enterType.set(paramBundle.getInt("enterType", 0));
      ((AVRedPacketGameSyncInfo.C2CGameInfo)localObject1).maxScore.set(paramBundle.getInt("maxScore", 0));
      ((AVRedPacketGameSyncInfo.C2CGameInfo)localObject1).totalEmojiNum.set(paramBundle.getInt("totalEmojiNum", 0));
      localObject1 = ((AVRedPacketGameSyncInfo.C2CGameInfo)localObject1).toByteArray();
    }
    for (;;)
    {
      kwb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(9, paramInt, (byte[])localObject1);
      return;
      localObject1 = localObject2;
      if (paramInt != 2)
      {
        localObject1 = localObject2;
        if (paramInt != 3)
        {
          localObject1 = localObject2;
          if (paramInt == 4)
          {
            localObject1 = localObject2;
            if (paramBundle != null)
            {
              new AVRedPacketGameSyncInfo.C2CGameInfo().exceptionType.set(paramBundle.getInt("alertExceptionType", 0));
              localObject1 = localObject2;
            }
          }
        }
      }
    }
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0xa75");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends ajfe> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject2 = paramToServiceMsg.extraData.getString("friendUin");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramFromServiceMsg.getUin();
    }
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {}
    do
    {
      return;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("uin", (String)localObject1);
    } while (!"OidbSvc.0xa75".equals(paramFromServiceMsg.getServiceCmd()));
    a(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lji
 * JD-Core Version:    0.7.0.1
 */