import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.data.UserScore;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class nfo
  extends nhc
{
  AVGameAppInterface jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  private ngw jdField_a_of_type_Ngw;
  private ngy jdField_a_of_type_Ngy;
  private nha<nfv> jdField_a_of_type_Nha;
  private nhb jdField_a_of_type_Nhb;
  
  public nfo(AVGameAppInterface paramAVGameAppInterface, ngy paramngy, ngw paramngw, nhb paramnhb, nha paramnha)
  {
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    this.jdField_a_of_type_Ngy = paramngy;
    this.jdField_a_of_type_Ngw = paramngw;
    this.jdField_a_of_type_Nhb = paramnhb;
    this.jdField_a_of_type_Nha = paramnha;
    paramAVGameAppInterface.addObserver(this, false);
  }
  
  private boolean a(long paramLong1, String paramString1, long paramLong2, String paramString2)
  {
    nfv localnfv = (nfv)this.jdField_a_of_type_Nha.a();
    if ((paramLong1 == 0L) || (paramLong1 != localnfv.a()) || (TextUtils.isEmpty(paramString1)) || (!paramString1.equalsIgnoreCase(localnfv.b())))
    {
      QLog.d("avgame_logic.GameController", 1, String.format("%s bValidSession=false [seq,rId,gId]=[%d,%d,%s]", new Object[] { paramString2, Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString1 }));
      return false;
    }
    return true;
  }
  
  private boolean a(long paramLong1, String paramString1, long paramLong2, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramBoolean = this.jdField_a_of_type_Nhb.a(paramLong2, paramLong1); !paramBoolean; paramBoolean = this.jdField_a_of_type_Nhb.a(paramLong2, paramLong1, false))
    {
      QLog.d("avgame_logic.GameController", 1, String.format("%s bValidSeq=false [seq,rId,gId]=[%d,%d,%s]", new Object[] { paramString2, Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString1 }));
      return false;
    }
    return true;
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    if (!a(paramLong2, paramString, paramLong1, "onGameOverPush")) {}
    do
    {
      do
      {
        return;
      } while (!a(paramLong2, paramString, paramLong1, "onGameOverPush", true));
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameController", 2, String.format("onGameOverPush [seq,rId,gId]=[%d,%d,%s]", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString }));
      }
      paramString = (nfv)this.jdField_a_of_type_Nha.a();
      if (paramString.b()) {
        this.jdField_a_of_type_Ngy.a(paramString, true);
      }
      if (paramString.e()) {
        nfc.a().a(paramString.a(), nfc.a().a().getAccount(), 1, 2);
      }
    } while (Build.VERSION.SDK_INT < 16);
    lfm.a().a("");
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, int paramInt1, int paramInt2, nfh paramnfh, Player paramPlayer, long paramLong3)
  {
    if (!a(paramLong2, paramString, paramLong1, "onAnswerRightPush")) {}
    do
    {
      do
      {
        return;
      } while (!a(paramLong2, paramString, paramLong1, "onAnswerRightPush", true));
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameController", 2, String.format("onAnswerRightPush [seq,rId,gId]=[%d,%d,%s] score=%d, player=%s, topic=%s, actorScore=%d, combo=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, Integer.valueOf(paramInt1), paramPlayer, paramnfh, Integer.valueOf(paramInt2), Long.valueOf(paramLong3) }));
      }
      paramString = (nfv)this.jdField_a_of_type_Nha.a();
    } while (!paramString.a(paramnfh, paramInt1, paramPlayer, paramLong3, paramInt2));
    this.jdField_a_of_type_Ngy.b(paramString, paramInt1);
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString1, long paramLong3, int paramInt, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameController", 2, String.format("onReceiveTranlationResultInfo [uin,translationTime,playGameId,answer]=[%d,%d,%s,%s] ", new Object[] { Long.valueOf(paramLong3), Integer.valueOf(paramInt), paramString2, paramString3 }));
    }
    this.jdField_a_of_type_Ngy.a(paramLong3, paramInt, paramString2, paramString3);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, String paramString2, Player paramPlayer)
  {
    if (!a(paramLong2, paramString1, paramLong1, "onNextPlayerTipPush")) {}
    do
    {
      do
      {
        return;
      } while (!a(paramLong2, paramString1, paramLong1, "onNextPlayerTipPush", true));
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameController", 2, String.format("onNextPlayerTipPush [seq,rId,gId]=[%d,%d,%s] tips=%s, player=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString1, paramString2, paramPlayer }));
      }
      paramString1 = (nfv)this.jdField_a_of_type_Nha.a();
    } while (!paramString1.a(paramPlayer));
    this.jdField_a_of_type_Ngy.d(paramString2, paramString1);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, String paramString2, nfh paramnfh)
  {
    if (!a(paramLong2, paramString1, paramLong1, "onAnswerExposurePush")) {}
    do
    {
      do
      {
        return;
      } while (!a(paramLong2, paramString1, paramLong1, "onAnswerExposurePush", true));
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameController", 2, String.format("onAnswerExposurePush [seq,rId,gId]=[%d,%d,%s] tips=%s topic=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString1, paramString2, paramnfh }));
      }
      paramString1 = (nfv)this.jdField_a_of_type_Nha.a();
    } while (!paramString1.d(paramnfh));
    this.jdField_a_of_type_Ngy.e(paramString2, paramString1);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, nfh paramnfh)
  {
    if (!a(paramLong2, paramString, paramLong1, "onAnswerTimeoutPush")) {}
    do
    {
      do
      {
        return;
      } while (!a(paramLong2, paramString, paramLong1, "onAnswerTimeoutPush", true));
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameController", 2, String.format("onAnswerTimeoutPush [seq,rId,gId]=[%d,%d,%s] topic=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, paramnfh }));
      }
      paramString = (nfv)this.jdField_a_of_type_Nha.a();
    } while (!paramString.c(paramnfh));
    this.jdField_a_of_type_Ngy.h(paramString);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, nfh paramnfh, Player paramPlayer)
  {
    if (!a(paramLong2, paramString, paramLong1, "onPlayerChangePush")) {}
    do
    {
      do
      {
        return;
      } while (!a(paramLong2, paramString, paramLong1, "onPlayerChangePush", true));
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameController", 2, String.format("onPlayerChangePush [seq,rId,gId]=[%d,%d,%s] player=%s, topic=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, paramPlayer, paramnfh }));
      }
      paramString = (nfv)this.jdField_a_of_type_Nha.a();
    } while (!paramString.a(paramPlayer, paramnfh));
    this.jdField_a_of_type_Ngy.g(paramString);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, nfh paramnfh, String paramString2)
  {
    if (!a(paramLong2, paramString1, paramLong1, "onTopicChangePush")) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!a(paramLong2, paramString1, paramLong1, "onTopicChangePush", true));
        if (QLog.isColorLevel()) {
          QLog.i("avgame_logic.GameController", 2, String.format("onTopicChangePush [seq,rId,gId]=[%d,%d,%s] switcherUin=%s topic=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString1, paramString2, paramnfh }));
        }
        paramString1 = (nfv)this.jdField_a_of_type_Nha.a();
      } while (!paramString1.a(paramnfh));
      this.jdField_a_of_type_Ngy.a(paramString1, paramString2);
    } while ((!nff.b(paramString1.c())) || (paramString1.a().size() != 0));
    b(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), paramString1.a(), paramString1.b());
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, nfz paramnfz, Player paramPlayer, nfh paramnfh)
  {
    nfv localnfv = (nfv)this.jdField_a_of_type_Nha.a();
    if ((paramLong2 == 0L) || (localnfv.a() != paramLong2)) {
      QLog.d("avgame_logic.GameController", 1, String.format("onGameStartPush bValidSession=false seq=%d roomId=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    do
    {
      do
      {
        return;
      } while (!a(paramLong2, paramString, paramLong1, "onGameStartPush", true));
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameController", 2, String.format("onGameStartPush [seq,rId,gId]=[%d,%d,%s] gInfo=%s, player=%s, topic=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, paramnfz, paramPlayer, paramnfh }));
      }
      localnfv.a(nfw.a(paramLong2, paramString, paramnfz, paramPlayer, paramnfh));
      this.jdField_a_of_type_Ngy.f(localnfv);
    } while (!nff.b(localnfv.c()));
    b(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), localnfv.a(), localnfv.b());
  }
  
  public void a(long paramLong1, String paramString, long paramLong2, nfh paramnfh)
  {
    if (!a(paramLong1, paramString, paramLong2, "onSwitchTopicSuc")) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!a(paramLong1, paramString, paramLong2, "onSwitchTopicSuc", false));
        if (QLog.isColorLevel()) {
          QLog.i("avgame_logic.GameController", 2, String.format("onSwitchTopicSuc [seq,rId,gId]=[%d,%d,%s] topic=%s", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString, paramnfh }));
        }
        paramString = (nfv)this.jdField_a_of_type_Nha.a();
      } while (!paramString.a(paramnfh));
      this.jdField_a_of_type_Ngy.d(paramString);
    } while ((!nff.b(paramString.c())) || (paramString.a().size() != 0));
    b(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), paramString.a(), paramString.b());
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    QLog.i("avgame_logic.GameController", 1, String.format("onSwitchTopicFail rId=%d gId=%s msg=%s", new Object[] { Long.valueOf(paramLong), paramString1, paramString2 }));
    this.jdField_a_of_type_Ngy.a(paramLong, paramString1, paramString2);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, long paramLong, String paramString3)
  {
    ((ngt)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(3)).a(paramString1, paramInt, paramString2, paramLong, paramString3);
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, RoomInfo paramRoomInfo, List<Long> paramList)
  {
    QLog.d("avgame_logic.GameController", 1, String.format("onStartGameFail uin=%s roomId=%d gameType=%d errCode=%d, errMsg=%s", new Object[] { paramString1, Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 }));
    if ((paramRoomInfo != null) && (paramInt2 == 405)) {
      ((nfv)this.jdField_a_of_type_Nha.a()).a(paramRoomInfo, false);
    }
    if (paramInt2 == 406)
    {
      paramString2 = "";
      RoomInfo localRoomInfo = ((nfv)this.jdField_a_of_type_Nha.a()).a();
      String str = paramString2;
      if (paramList != null)
      {
        str = paramString2;
        if (paramList.size() > 0)
        {
          str = paramString2;
          if (paramRoomInfo != null)
          {
            Iterator localIterator = paramList.iterator();
            for (;;)
            {
              str = paramString2;
              if (!localIterator.hasNext()) {
                break;
              }
              paramList = localRoomInfo.getNick(((Long)localIterator.next()).toString());
              if ((paramList == null) || (paramList.length() <= 0)) {
                break label288;
              }
              paramRoomInfo = paramList;
              if (paramString2.length() > 0) {
                paramRoomInfo = paramString2 + "、" + paramList;
              }
              paramString2 = paramRoomInfo;
            }
          }
        }
      }
      paramString2 = String.format(BaseApplicationImpl.getContext().getResources().getString(2131690317), new Object[] { str });
    }
    for (;;)
    {
      this.jdField_a_of_type_Ngy.a(paramString1, paramLong, paramInt1, paramInt2, paramString2);
      return;
      label288:
      paramRoomInfo = paramString2;
      break;
    }
  }
  
  public void a(String paramString1, long paramLong1, int paramInt, long paramLong2, String paramString2, nfz paramnfz, Player paramPlayer, nfh paramnfh)
  {
    if ((!this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin().equals(paramString1)) || (paramLong1 == 0L) || (paramLong1 != ((nfv)this.jdField_a_of_type_Nha.a()).a()) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.d("avgame_logic.GameController", 1, String.format("onStartGameSuc bValidSession=false uin=%s gameType=%d [seq,rId,gId]=[%d,%d,%s]", new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString2 }));
      this.jdField_a_of_type_Ngy.a(paramString1, paramLong1, paramInt, -1, BaseApplicationImpl.getContext().getResources().getString(2131690443));
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_Nhb.a(paramLong2, paramLong1, false))
      {
        QLog.d("avgame_logic.GameController", 1, String.format("onStartGameSuc bValidSeq=false uin=%s gameType=%d [seq,rId,gId]=[%d,%d,%s]", new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString2 }));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameController", 2, String.format("onStartGameSuc uin=%s type=%d [seq,rId,gId]=[%d,%d,%s], gInfo=%s player=%s topic=%s", new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString2, paramnfz, paramPlayer, paramnfh }));
      }
      paramString1 = nfw.a(paramLong1, paramString2, paramnfz, paramPlayer, paramnfh);
      paramString2 = (nfv)this.jdField_a_of_type_Nha.a();
      paramString2.a(paramString1);
      this.jdField_a_of_type_Ngy.c(paramString2);
    } while (!nff.b(paramString2.c()));
    b(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), paramString2.a(), paramString2.b());
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, String paramString2, int paramInt2)
  {
    ((ngt)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(3)).a(paramString1, paramLong, paramInt1, paramString2, paramInt2);
  }
  
  public void a(String paramString1, long paramLong, String paramString2)
  {
    ((ngt)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(3)).a(paramString1, paramLong, paramString2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    ((ngt)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(3)).a(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    QLog.i("avgame_logic.GameController", 1, String.format("onGetGameRankingListFail gId=%s msg=%s", new Object[] { paramString2, paramString3 }));
    this.jdField_a_of_type_Ngw.a(paramString1, paramString2, paramString3);
  }
  
  public void a(String paramString1, String paramString2, List<UserScore> paramList)
  {
    QLog.i("avgame_logic.GameController", 1, String.format("onGetGameRankingListSuc gId=%s scoreListSize=%d", new Object[] { paramString2, Integer.valueOf(paramList.size()) }));
    paramString1 = (nfv)this.jdField_a_of_type_Nha.a();
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase(paramString1.b()))) {}
    while (!paramString1.a(paramList)) {
      return;
    }
    this.jdField_a_of_type_Ngw.i(paramString1);
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isDebugVersion()) {
      QLog.i("avgame_logic.GameController", 1, String.format("onUploadResourceResult isSucc=%b gId=%s filetype=%d url=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString1, Integer.valueOf(paramInt), paramString2 }));
    }
    this.jdField_a_of_type_Ngw.a(paramBoolean, paramString1, paramInt, paramString2);
  }
  
  public void b(long paramLong1, String paramString, long paramLong2, nfh paramnfh)
  {
    if (!a(paramLong1, paramString, paramLong2, "onSwitchTopicSuc")) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameController", 2, String.format("onPullTopicsSuc [seq,rId,gId]=[%d,%d,%s] topic=%s", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString, paramnfh }));
    }
    nfv localnfv = (nfv)this.jdField_a_of_type_Nha.a();
    if (localnfv.b(paramnfh))
    {
      this.jdField_a_of_type_Ngy.e(localnfv);
      return;
    }
    this.jdField_a_of_type_Ngy.b(paramLong1, paramString, "");
  }
  
  public void b(long paramLong, String paramString1, String paramString2)
  {
    QLog.i("avgame_logic.GameController", 1, String.format("onPullTopicsFail rId=%d gId=%s msg=%s", new Object[] { Long.valueOf(paramLong), paramString1, paramString2 }));
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = BaseApplicationImpl.getContext().getResources().getString(2131690417);
    }
    this.jdField_a_of_type_Ngy.b(paramLong, paramString1, str);
  }
  
  public void b(String paramString1, long paramLong, String paramString2)
  {
    ((ngt)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(3)).a(paramString1, paramLong, paramString2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nfo
 * JD-Core Version:    0.7.0.1
 */