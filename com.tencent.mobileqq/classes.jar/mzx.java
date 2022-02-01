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

public class mzx
  extends nbm
{
  AVGameAppInterface jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  private nbg jdField_a_of_type_Nbg;
  private nbi jdField_a_of_type_Nbi;
  private nbk<naf> jdField_a_of_type_Nbk;
  private nbl jdField_a_of_type_Nbl;
  
  public mzx(AVGameAppInterface paramAVGameAppInterface, nbi paramnbi, nbg paramnbg, nbl paramnbl, nbk paramnbk)
  {
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    this.jdField_a_of_type_Nbi = paramnbi;
    this.jdField_a_of_type_Nbg = paramnbg;
    this.jdField_a_of_type_Nbl = paramnbl;
    this.jdField_a_of_type_Nbk = paramnbk;
    paramAVGameAppInterface.addObserver(this, false);
  }
  
  private boolean a(long paramLong1, String paramString1, long paramLong2, String paramString2)
  {
    naf localnaf = (naf)this.jdField_a_of_type_Nbk.a();
    if ((paramLong1 == 0L) || (paramLong1 != localnaf.a()) || (TextUtils.isEmpty(paramString1)) || (!paramString1.equalsIgnoreCase(localnaf.b())))
    {
      QLog.d("avgame_logic.GameController", 1, String.format("%s bValidSession=false [seq,rId,gId]=[%d,%d,%s]", new Object[] { paramString2, Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString1 }));
      return false;
    }
    return true;
  }
  
  private boolean a(long paramLong1, String paramString1, long paramLong2, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramBoolean = this.jdField_a_of_type_Nbl.a(paramLong2, paramLong1); !paramBoolean; paramBoolean = this.jdField_a_of_type_Nbl.a(paramLong2, paramLong1, false))
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
      paramString = (naf)this.jdField_a_of_type_Nbk.a();
      if (paramString.b()) {
        this.jdField_a_of_type_Nbi.a(paramString, true);
      }
    } while (Build.VERSION.SDK_INT < 16);
    mxh.a().a("");
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, int paramInt1, int paramInt2, mzq parammzq, Player paramPlayer, long paramLong3)
  {
    if (!a(paramLong2, paramString, paramLong1, "onAnswerRightPush")) {}
    do
    {
      do
      {
        return;
      } while (!a(paramLong2, paramString, paramLong1, "onAnswerRightPush", true));
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameController", 2, String.format("onAnswerRightPush [seq,rId,gId]=[%d,%d,%s] score=%d, player=%s, topic=%s, actorScore=%d, combo=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, Integer.valueOf(paramInt1), paramPlayer, parammzq, Integer.valueOf(paramInt2), Long.valueOf(paramLong3) }));
      }
      paramString = (naf)this.jdField_a_of_type_Nbk.a();
    } while (!paramString.a(parammzq, paramInt1, paramPlayer, paramLong3, paramInt2));
    this.jdField_a_of_type_Nbi.b(paramString, paramInt1);
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString1, long paramLong3, int paramInt, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameController", 2, String.format("onReceiveTranlationResultInfo [uin,translationTime,playGameId,answer]=[%d,%d,%s,%s] ", new Object[] { Long.valueOf(paramLong3), Integer.valueOf(paramInt), paramString2, paramString3 }));
    }
    this.jdField_a_of_type_Nbi.a(paramLong3, paramInt, paramString2, paramString3);
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
      paramString1 = (naf)this.jdField_a_of_type_Nbk.a();
    } while (!paramString1.a(paramPlayer));
    this.jdField_a_of_type_Nbi.c(paramString2, paramString1);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, String paramString2, mzq parammzq)
  {
    if (!a(paramLong2, paramString1, paramLong1, "onAnswerExposurePush")) {}
    do
    {
      do
      {
        return;
      } while (!a(paramLong2, paramString1, paramLong1, "onAnswerExposurePush", true));
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameController", 2, String.format("onAnswerExposurePush [seq,rId,gId]=[%d,%d,%s] tips=%s topic=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString1, paramString2, parammzq }));
      }
      paramString1 = (naf)this.jdField_a_of_type_Nbk.a();
    } while (!paramString1.d(parammzq));
    this.jdField_a_of_type_Nbi.d(paramString2, paramString1);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, mzq parammzq)
  {
    if (!a(paramLong2, paramString, paramLong1, "onAnswerTimeoutPush")) {}
    do
    {
      do
      {
        return;
      } while (!a(paramLong2, paramString, paramLong1, "onAnswerTimeoutPush", true));
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameController", 2, String.format("onAnswerTimeoutPush [seq,rId,gId]=[%d,%d,%s] topic=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, parammzq }));
      }
      paramString = (naf)this.jdField_a_of_type_Nbk.a();
    } while (!paramString.c(parammzq));
    this.jdField_a_of_type_Nbi.h(paramString);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, mzq parammzq, Player paramPlayer)
  {
    if (!a(paramLong2, paramString, paramLong1, "onPlayerChangePush")) {}
    do
    {
      do
      {
        return;
      } while (!a(paramLong2, paramString, paramLong1, "onPlayerChangePush", true));
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameController", 2, String.format("onPlayerChangePush [seq,rId,gId]=[%d,%d,%s] player=%s, topic=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, paramPlayer, parammzq }));
      }
      paramString = (naf)this.jdField_a_of_type_Nbk.a();
    } while (!paramString.a(paramPlayer, parammzq));
    this.jdField_a_of_type_Nbi.g(paramString);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, mzq parammzq, String paramString2)
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
          QLog.i("avgame_logic.GameController", 2, String.format("onTopicChangePush [seq,rId,gId]=[%d,%d,%s] switcherUin=%s topic=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString1, paramString2, parammzq }));
        }
        paramString1 = (naf)this.jdField_a_of_type_Nbk.a();
      } while (!paramString1.a(parammzq));
      this.jdField_a_of_type_Nbi.a(paramString1, paramString2);
    } while ((!mzo.b(paramString1.c())) || (paramString1.a().size() != 0));
    b(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), paramString1.a(), paramString1.b());
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, naj paramnaj, Player paramPlayer, mzq parammzq)
  {
    naf localnaf = (naf)this.jdField_a_of_type_Nbk.a();
    if ((paramLong2 == 0L) || (localnaf.a() != paramLong2)) {
      QLog.d("avgame_logic.GameController", 1, String.format("onGameStartPush bValidSession=false seq=%d roomId=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    do
    {
      do
      {
        return;
      } while (!a(paramLong2, paramString, paramLong1, "onGameStartPush", true));
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameController", 2, String.format("onGameStartPush [seq,rId,gId]=[%d,%d,%s] gInfo=%s, player=%s, topic=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, paramnaj, paramPlayer, parammzq }));
      }
      localnaf.a(nag.a(paramLong2, paramString, paramnaj, paramPlayer, parammzq));
      this.jdField_a_of_type_Nbi.f(localnaf);
    } while (!mzo.b(localnaf.c()));
    b(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), localnaf.a(), localnaf.b());
  }
  
  public void a(long paramLong1, String paramString, long paramLong2, mzq parammzq)
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
          QLog.i("avgame_logic.GameController", 2, String.format("onSwitchTopicSuc [seq,rId,gId]=[%d,%d,%s] topic=%s", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString, parammzq }));
        }
        paramString = (naf)this.jdField_a_of_type_Nbk.a();
      } while (!paramString.a(parammzq));
      this.jdField_a_of_type_Nbi.d(paramString);
    } while ((!mzo.b(paramString.c())) || (paramString.a().size() != 0));
    b(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), paramString.a(), paramString.b());
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    QLog.i("avgame_logic.GameController", 1, String.format("onSwitchTopicFail rId=%d gId=%s msg=%s", new Object[] { Long.valueOf(paramLong), paramString1, paramString2 }));
    this.jdField_a_of_type_Nbi.a(paramLong, paramString1, paramString2);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, long paramLong, String paramString3)
  {
    ((nbd)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(3)).a(paramString1, paramInt, paramString2, paramLong, paramString3);
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, RoomInfo paramRoomInfo, List<Long> paramList)
  {
    QLog.d("avgame_logic.GameController", 1, String.format("onStartGameFail uin=%s roomId=%d gameType=%d errCode=%d, errMsg=%s", new Object[] { paramString1, Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 }));
    if ((paramRoomInfo != null) && (paramInt2 == 405)) {
      ((naf)this.jdField_a_of_type_Nbk.a()).a(paramRoomInfo, false);
    }
    if (paramInt2 == 406)
    {
      paramString2 = "";
      RoomInfo localRoomInfo = ((naf)this.jdField_a_of_type_Nbk.a()).a();
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
      paramString2 = String.format(BaseApplicationImpl.getContext().getResources().getString(2131690279), new Object[] { str });
    }
    for (;;)
    {
      this.jdField_a_of_type_Nbi.a(paramString1, paramLong, paramInt1, paramInt2, paramString2);
      return;
      label288:
      paramRoomInfo = paramString2;
      break;
    }
  }
  
  public void a(String paramString1, long paramLong1, int paramInt, long paramLong2, String paramString2, naj paramnaj, Player paramPlayer, mzq parammzq)
  {
    if ((!this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin().equals(paramString1)) || (paramLong1 == 0L) || (paramLong1 != ((naf)this.jdField_a_of_type_Nbk.a()).a()) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.d("avgame_logic.GameController", 1, String.format("onStartGameSuc bValidSession=false uin=%s gameType=%d [seq,rId,gId]=[%d,%d,%s]", new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString2 }));
      this.jdField_a_of_type_Nbi.a(paramString1, paramLong1, paramInt, -1, BaseApplicationImpl.getContext().getResources().getString(2131690386));
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_Nbl.a(paramLong2, paramLong1, false))
      {
        QLog.d("avgame_logic.GameController", 1, String.format("onStartGameSuc bValidSeq=false uin=%s gameType=%d [seq,rId,gId]=[%d,%d,%s]", new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString2 }));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameController", 2, String.format("onStartGameSuc uin=%s type=%d [seq,rId,gId]=[%d,%d,%s], gInfo=%s player=%s topic=%s", new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString2, paramnaj, paramPlayer, parammzq }));
      }
      paramString1 = nag.a(paramLong1, paramString2, paramnaj, paramPlayer, parammzq);
      paramString2 = (naf)this.jdField_a_of_type_Nbk.a();
      paramString2.a(paramString1);
      this.jdField_a_of_type_Nbi.c(paramString2);
    } while (!mzo.b(paramString2.c()));
    b(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), paramString2.a(), paramString2.b());
  }
  
  public void a(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    ((nbd)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(3)).a(paramString1, paramLong, paramInt, paramString2);
  }
  
  public void a(String paramString1, long paramLong, String paramString2)
  {
    ((nbd)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(3)).a(paramString1, paramLong, paramString2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    ((nbd)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(3)).a(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    QLog.i("avgame_logic.GameController", 1, String.format("onGetGameRankingListFail gId=%s msg=%s", new Object[] { paramString2, paramString3 }));
    this.jdField_a_of_type_Nbg.a(paramString1, paramString2, paramString3);
  }
  
  public void a(String paramString1, String paramString2, List<UserScore> paramList)
  {
    QLog.i("avgame_logic.GameController", 1, String.format("onGetGameRankingListSuc gId=%s scoreListSize=%d", new Object[] { paramString2, Integer.valueOf(paramList.size()) }));
    paramString1 = (naf)this.jdField_a_of_type_Nbk.a();
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase(paramString1.b()))) {}
    while (!paramString1.a(paramList)) {
      return;
    }
    this.jdField_a_of_type_Nbg.i(paramString1);
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isDebugVersion()) {
      QLog.i("avgame_logic.GameController", 1, String.format("onUploadResourceResult isSucc=%b gId=%s filetype=%d url=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString1, Integer.valueOf(paramInt), paramString2 }));
    }
    this.jdField_a_of_type_Nbg.a(paramBoolean, paramString1, paramInt, paramString2);
  }
  
  public void b(long paramLong1, String paramString, long paramLong2, mzq parammzq)
  {
    if (!a(paramLong1, paramString, paramLong2, "onSwitchTopicSuc")) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameController", 2, String.format("onPullTopicsSuc [seq,rId,gId]=[%d,%d,%s] topic=%s", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString, parammzq }));
    }
    naf localnaf = (naf)this.jdField_a_of_type_Nbk.a();
    if (localnaf.b(parammzq))
    {
      this.jdField_a_of_type_Nbi.e(localnaf);
      return;
    }
    this.jdField_a_of_type_Nbi.b(paramLong1, paramString, "");
  }
  
  public void b(long paramLong, String paramString1, String paramString2)
  {
    QLog.i("avgame_logic.GameController", 1, String.format("onPullTopicsFail rId=%d gId=%s msg=%s", new Object[] { Long.valueOf(paramLong), paramString1, paramString2 }));
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = BaseApplicationImpl.getContext().getResources().getString(2131690365);
    }
    this.jdField_a_of_type_Nbi.b(paramLong, paramString1, str);
  }
  
  public void b(String paramString1, long paramLong, String paramString2)
  {
    ((nbd)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(3)).a(paramString1, paramLong, paramString2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mzx
 * JD-Core Version:    0.7.0.1
 */