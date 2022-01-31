import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.AVC2CDataHandler.C2CDataHandler;
import com.tencent.av.redpacket.AVRedPacketHandler;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.ui.redbag.RedBagUtil;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.avredpacket.AVRedPacketGameSyncInfo.C2CGameInfo;
import com.tencent.qphone.base.util.QLog;

public class jne
  implements AVC2CDataHandler.C2CDataHandler
{
  public jne(AVRedPacketHandler paramAVRedPacketHandler) {}
  
  public boolean a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    bool2 = false;
    String str = RedBagUtil.a();
    if ((paramArrayOfByte == null) || (TextUtils.isEmpty(str)) || (paramInt1 != 9))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketHandler", 2, "onC2CDataCome error return, msgType=" + paramInt1);
      }
      return false;
    }
    localAVRedPacketManager = (AVRedPacketManager)this.a.a.a(6);
    localC2CGameInfo = new AVRedPacketGameSyncInfo.C2CGameInfo();
    try
    {
      localC2CGameInfo.mergeFrom(paramArrayOfByte);
      bool1 = true;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        boolean bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.e("AVRedPacketHandler", 2, "onC2CDataCome,", paramArrayOfByte);
          bool1 = bool2;
          continue;
          if ((paramInt2 == 2) || (paramInt2 == 3)) {
            localAVRedPacketManager.b(paramInt2);
          } else if (paramInt2 == 4) {
            localAVRedPacketManager.c(localC2CGameInfo.exceptionType.get());
          }
        }
      }
    }
    if (paramInt2 == 1)
    {
      paramArrayOfByte = new Bundle();
      paramArrayOfByte.putString("key", localC2CGameInfo.key.get());
      paramArrayOfByte.putInt("gameState", localC2CGameInfo.state.get());
      paramArrayOfByte.putString("peerUin", str);
      paramArrayOfByte.putInt("fromWho", localC2CGameInfo.fromWho.get());
      paramArrayOfByte.putString("money", localC2CGameInfo.money.get());
      paramArrayOfByte.putInt("resultCode", localC2CGameInfo.resultCode.get());
      paramArrayOfByte.putString("resultState", localC2CGameInfo.resultState.get());
      paramArrayOfByte.putInt("musicId", localC2CGameInfo.musicId.get());
      paramArrayOfByte.putInt("hitScore", localC2CGameInfo.scores.get());
      paramArrayOfByte.putInt("enterType", localC2CGameInfo.enterType.get());
      paramArrayOfByte.putInt("maxScore", localC2CGameInfo.maxScore.get());
      paramArrayOfByte.putInt("totalEmojiNum", localC2CGameInfo.totalEmojiNum.get());
      localAVRedPacketManager.a(bool1, paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketHandler", 2, "onC2CDataCome, isSucc: " + bool1 + ", subType=" + paramInt2);
      }
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jne
 * JD-Core Version:    0.7.0.1
 */