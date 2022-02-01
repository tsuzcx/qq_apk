import android.content.res.Resources;
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

public class myw
  extends nal
{
  AVGameAppInterface jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  private naf jdField_a_of_type_Naf;
  private nah jdField_a_of_type_Nah;
  private naj<mze> jdField_a_of_type_Naj;
  private nak jdField_a_of_type_Nak;
  
  public myw(AVGameAppInterface paramAVGameAppInterface, nah paramnah, naf paramnaf, nak paramnak, naj paramnaj)
  {
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    this.jdField_a_of_type_Nah = paramnah;
    this.jdField_a_of_type_Naf = paramnaf;
    this.jdField_a_of_type_Nak = paramnak;
    this.jdField_a_of_type_Naj = paramnaj;
    paramAVGameAppInterface.addObserver(this, false);
  }
  
  private boolean a(long paramLong1, String paramString1, long paramLong2, String paramString2)
  {
    mze localmze = (mze)this.jdField_a_of_type_Naj.a();
    if ((paramLong1 == 0L) || (paramLong1 != localmze.a()) || (TextUtils.isEmpty(paramString1)) || (!paramString1.equalsIgnoreCase(localmze.b())))
    {
      QLog.d("avgame_logic.GameController", 1, String.format("%s bValidSession=false [seq,rId,gId]=[%d,%d,%s]", new Object[] { paramString2, Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString1 }));
      return false;
    }
    return true;
  }
  
  private boolean a(long paramLong1, String paramString1, long paramLong2, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramBoolean = this.jdField_a_of_type_Nak.a(paramLong2, paramLong1); !paramBoolean; paramBoolean = this.jdField_a_of_type_Nak.a(paramLong2, paramLong1, false))
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
      paramString = (mze)this.jdField_a_of_type_Naj.a();
    } while (!paramString.b());
    this.jdField_a_of_type_Nah.a(paramString, true);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, int paramInt1, int paramInt2, myp parammyp, Player paramPlayer, long paramLong3)
  {
    if (!a(paramLong2, paramString, paramLong1, "onAnswerRightPush")) {}
    do
    {
      do
      {
        return;
      } while (!a(paramLong2, paramString, paramLong1, "onAnswerRightPush", true));
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameController", 2, String.format("onAnswerRightPush [seq,rId,gId]=[%d,%d,%s] score=%d, player=%s, topic=%s, actorScore=%d, combo=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, Integer.valueOf(paramInt1), paramPlayer, parammyp, Integer.valueOf(paramInt2), Long.valueOf(paramLong3) }));
      }
      paramString = (mze)this.jdField_a_of_type_Naj.a();
    } while (!paramString.a(parammyp, paramInt1, paramPlayer, paramLong3, paramInt2));
    this.jdField_a_of_type_Nah.b(paramString, paramInt1);
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString1, long paramLong3, int paramInt, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameController", 2, String.format("onReceiveTranlationResultInfo [uin,translationTime,playGameId,answer]=[%d,%d,%s,%s] ", new Object[] { Long.valueOf(paramLong3), Integer.valueOf(paramInt), paramString2, paramString3 }));
    }
    this.jdField_a_of_type_Nah.a(paramLong3, paramInt, paramString2, paramString3);
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
      paramString1 = (mze)this.jdField_a_of_type_Naj.a();
    } while (!paramString1.a(paramPlayer));
    this.jdField_a_of_type_Nah.c(paramString2, paramString1);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, String paramString2, myp parammyp)
  {
    if (!a(paramLong2, paramString1, paramLong1, "onAnswerExposurePush")) {}
    do
    {
      do
      {
        return;
      } while (!a(paramLong2, paramString1, paramLong1, "onAnswerExposurePush", true));
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameController", 2, String.format("onAnswerExposurePush [seq,rId,gId]=[%d,%d,%s] tips=%s topic=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString1, paramString2, parammyp }));
      }
      paramString1 = (mze)this.jdField_a_of_type_Naj.a();
    } while (!paramString1.d(parammyp));
    this.jdField_a_of_type_Nah.d(paramString2, paramString1);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, myp parammyp)
  {
    if (!a(paramLong2, paramString, paramLong1, "onAnswerTimeoutPush")) {}
    do
    {
      do
      {
        return;
      } while (!a(paramLong2, paramString, paramLong1, "onAnswerTimeoutPush", true));
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameController", 2, String.format("onAnswerTimeoutPush [seq,rId,gId]=[%d,%d,%s] topic=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, parammyp }));
      }
      paramString = (mze)this.jdField_a_of_type_Naj.a();
    } while (!paramString.c(parammyp));
    this.jdField_a_of_type_Nah.h(paramString);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, myp parammyp, Player paramPlayer)
  {
    if (!a(paramLong2, paramString, paramLong1, "onPlayerChangePush")) {}
    do
    {
      do
      {
        return;
      } while (!a(paramLong2, paramString, paramLong1, "onPlayerChangePush", true));
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameController", 2, String.format("onPlayerChangePush [seq,rId,gId]=[%d,%d,%s] player=%s, topic=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, paramPlayer, parammyp }));
      }
      paramString = (mze)this.jdField_a_of_type_Naj.a();
    } while (!paramString.a(paramPlayer, parammyp));
    this.jdField_a_of_type_Nah.g(paramString);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, myp parammyp, String paramString2)
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
          QLog.i("avgame_logic.GameController", 2, String.format("onTopicChangePush [seq,rId,gId]=[%d,%d,%s] switcherUin=%s topic=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString1, paramString2, parammyp }));
        }
        paramString1 = (mze)this.jdField_a_of_type_Naj.a();
      } while (!paramString1.a(parammyp));
      this.jdField_a_of_type_Nah.a(paramString1, paramString2);
    } while ((!myn.b(paramString1.c())) || (paramString1.a().size() != 0));
    b(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), paramString1.a(), paramString1.b());
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, mzi parammzi, Player paramPlayer, myp parammyp)
  {
    mze localmze = (mze)this.jdField_a_of_type_Naj.a();
    if ((paramLong2 == 0L) || (localmze.a() != paramLong2)) {
      QLog.d("avgame_logic.GameController", 1, String.format("onGameStartPush bValidSession=false seq=%d roomId=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    do
    {
      do
      {
        return;
      } while (!a(paramLong2, paramString, paramLong1, "onGameStartPush", true));
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameController", 2, String.format("onGameStartPush [seq,rId,gId]=[%d,%d,%s] gInfo=%s, player=%s, topic=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, parammzi, paramPlayer, parammyp }));
      }
      localmze.a(mzf.a(paramLong2, paramString, parammzi, paramPlayer, parammyp));
      this.jdField_a_of_type_Nah.f(localmze);
    } while (!myn.b(localmze.c()));
    b(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), localmze.a(), localmze.b());
  }
  
  public void a(long paramLong1, String paramString, long paramLong2, myp parammyp)
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
          QLog.i("avgame_logic.GameController", 2, String.format("onSwitchTopicSuc [seq,rId,gId]=[%d,%d,%s] topic=%s", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString, parammyp }));
        }
        paramString = (mze)this.jdField_a_of_type_Naj.a();
      } while (!paramString.a(parammyp));
      this.jdField_a_of_type_Nah.d(paramString);
    } while ((!myn.b(paramString.c())) || (paramString.a().size() != 0));
    b(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), paramString.a(), paramString.b());
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    QLog.i("avgame_logic.GameController", 1, String.format("onSwitchTopicFail rId=%d gId=%s msg=%s", new Object[] { Long.valueOf(paramLong), paramString1, paramString2 }));
    this.jdField_a_of_type_Nah.a(paramLong, paramString1, paramString2);
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, RoomInfo paramRoomInfo, List<Long> paramList)
  {
    QLog.d("avgame_logic.GameController", 1, String.format("onStartGameFail uin=%s roomId=%d gameType=%d errCode=%d, errMsg=%s", new Object[] { paramString1, Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 }));
    if ((paramRoomInfo != null) && (paramInt2 == 405)) {
      ((mze)this.jdField_a_of_type_Naj.a()).a(paramRoomInfo, false);
    }
    if (paramInt2 == 406)
    {
      paramString2 = "";
      RoomInfo localRoomInfo = ((mze)this.jdField_a_of_type_Naj.a()).a();
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
                break label287;
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
      paramString2 = String.format(BaseApplicationImpl.getContext().getResources().getString(2131690254), new Object[] { str });
    }
    for (;;)
    {
      this.jdField_a_of_type_Nah.a(paramString1, paramLong, paramInt1, paramInt2, paramString2);
      return;
      label287:
      paramRoomInfo = paramString2;
      break;
    }
  }
  
  public void a(String paramString1, long paramLong1, int paramInt, long paramLong2, String paramString2, mzi parammzi, Player paramPlayer, myp parammyp)
  {
    if ((!this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin().equals(paramString1)) || (paramLong1 == 0L) || (paramLong1 != ((mze)this.jdField_a_of_type_Naj.a()).a()) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.d("avgame_logic.GameController", 1, String.format("onStartGameSuc bValidSession=false uin=%s gameType=%d [seq,rId,gId]=[%d,%d,%s]", new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString2 }));
      this.jdField_a_of_type_Nah.a(paramString1, paramLong1, paramInt, -1, BaseApplicationImpl.getContext().getResources().getString(2131690347));
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_Nak.a(paramLong2, paramLong1, false))
      {
        QLog.d("avgame_logic.GameController", 1, String.format("onStartGameSuc bValidSeq=false uin=%s gameType=%d [seq,rId,gId]=[%d,%d,%s]", new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString2 }));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameController", 2, String.format("onStartGameSuc uin=%s type=%d [seq,rId,gId]=[%d,%d,%s], gInfo=%s player=%s topic=%s", new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString2, parammzi, paramPlayer, parammyp }));
      }
      paramString1 = mzf.a(paramLong1, paramString2, parammzi, paramPlayer, parammyp);
      paramString2 = (mze)this.jdField_a_of_type_Naj.a();
      paramString2.a(paramString1);
      this.jdField_a_of_type_Nah.c(paramString2);
    } while (!myn.b(paramString2.c()));
    b(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), paramString2.a(), paramString2.b());
  }
  
  public void a(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    ((nac)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(3)).a(paramString1, paramLong, paramInt, paramString2);
  }
  
  public void a(String paramString1, long paramLong, String paramString2)
  {
    ((nac)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(3)).a(paramString1, paramLong, paramString2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    ((nac)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(3)).a(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    QLog.i("avgame_logic.GameController", 1, String.format("onGetGameRankingListFail gId=%s msg=%s", new Object[] { paramString2, paramString3 }));
    this.jdField_a_of_type_Naf.a(paramString1, paramString2, paramString3);
  }
  
  public void a(String paramString1, String paramString2, List<UserScore> paramList)
  {
    QLog.i("avgame_logic.GameController", 1, String.format("onGetGameRankingListSuc gId=%s scoreListSize=%d", new Object[] { paramString2, Integer.valueOf(paramList.size()) }));
    paramString1 = (mze)this.jdField_a_of_type_Naj.a();
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase(paramString1.b()))) {}
    while (!paramString1.a(paramList)) {
      return;
    }
    this.jdField_a_of_type_Naf.i(paramString1);
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isDebugVersion()) {
      QLog.i("avgame_logic.GameController", 1, String.format("onUploadResourceResult isSucc=%b gId=%s filetype=%d url=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString1, Integer.valueOf(paramInt), paramString2 }));
    }
    this.jdField_a_of_type_Naf.a(paramBoolean, paramString1, paramInt, paramString2);
  }
  
  public void b(long paramLong1, String paramString, long paramLong2, myp parammyp)
  {
    if (!a(paramLong1, paramString, paramLong2, "onSwitchTopicSuc")) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameController", 2, String.format("onPullTopicsSuc [seq,rId,gId]=[%d,%d,%s] topic=%s", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString, parammyp }));
    }
    mze localmze = (mze)this.jdField_a_of_type_Naj.a();
    if (localmze.b(parammyp))
    {
      this.jdField_a_of_type_Nah.e(localmze);
      return;
    }
    this.jdField_a_of_type_Nah.b(paramLong1, paramString, "");
  }
  
  public void b(long paramLong, String paramString1, String paramString2)
  {
    QLog.i("avgame_logic.GameController", 1, String.format("onPullTopicsFail rId=%d gId=%s msg=%s", new Object[] { Long.valueOf(paramLong), paramString1, paramString2 }));
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = BaseApplicationImpl.getContext().getResources().getString(2131690326);
    }
    this.jdField_a_of_type_Nah.b(paramLong, paramString1, str);
  }
  
  public void b(String paramString1, long paramLong, String paramString2)
  {
    ((nac)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(3)).a(paramString1, paramLong, paramString2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     myw
 * JD-Core Version:    0.7.0.1
 */