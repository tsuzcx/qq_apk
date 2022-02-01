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

public class mxu
  extends mzi
{
  AVGameAppInterface jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  private mzc jdField_a_of_type_Mzc;
  private mze jdField_a_of_type_Mze;
  private mzg<myc> jdField_a_of_type_Mzg;
  private mzh jdField_a_of_type_Mzh;
  
  public mxu(AVGameAppInterface paramAVGameAppInterface, mze parammze, mzc parammzc, mzh parammzh, mzg parammzg)
  {
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    this.jdField_a_of_type_Mze = parammze;
    this.jdField_a_of_type_Mzc = parammzc;
    this.jdField_a_of_type_Mzh = parammzh;
    this.jdField_a_of_type_Mzg = parammzg;
    paramAVGameAppInterface.addObserver(this, false);
  }
  
  private boolean a(long paramLong1, String paramString1, long paramLong2, String paramString2)
  {
    myc localmyc = (myc)this.jdField_a_of_type_Mzg.a();
    if ((paramLong1 == 0L) || (paramLong1 != localmyc.a()) || (TextUtils.isEmpty(paramString1)) || (!paramString1.equalsIgnoreCase(localmyc.b())))
    {
      QLog.d("avgame_logic.GameController", 1, String.format("%s bValidSession=false [seq,rId,gId]=[%d,%d,%s]", new Object[] { paramString2, Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString1 }));
      return false;
    }
    return true;
  }
  
  private boolean a(long paramLong1, String paramString1, long paramLong2, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramBoolean = this.jdField_a_of_type_Mzh.a(paramLong2, paramLong1); !paramBoolean; paramBoolean = this.jdField_a_of_type_Mzh.a(paramLong2, paramLong1, false))
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
      paramString = (myc)this.jdField_a_of_type_Mzg.a();
    } while (!paramString.b());
    this.jdField_a_of_type_Mze.a(paramString, true);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, int paramInt, mxq parammxq, Player paramPlayer)
  {
    if (!a(paramLong2, paramString, paramLong1, "onAnswerRightPush")) {}
    do
    {
      do
      {
        return;
      } while (!a(paramLong2, paramString, paramLong1, "onAnswerRightPush", true));
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameController", 2, String.format("onAnswerRightPush [seq,rId,gId]=[%d,%d,%s] score=%d, player=%s, topic=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, Integer.valueOf(paramInt), paramPlayer, parammxq }));
      }
      paramString = (myc)this.jdField_a_of_type_Mzg.a();
    } while (!paramString.a(parammxq, paramInt, paramPlayer));
    this.jdField_a_of_type_Mze.b(paramString, paramInt);
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString1, long paramLong3, int paramInt, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameController", 2, String.format("onReceiveTranlationResultInfo [uin,translationTime,playGameId,answer]=[%d,%d,%s,%s] ", new Object[] { Long.valueOf(paramLong3), Integer.valueOf(paramInt), paramString2, paramString3 }));
    }
    this.jdField_a_of_type_Mze.a(paramLong3, paramInt, paramString2, paramString3);
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
      paramString1 = (myc)this.jdField_a_of_type_Mzg.a();
    } while (!paramString1.a(paramPlayer));
    this.jdField_a_of_type_Mze.c(paramString2, paramString1);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, String paramString2, mxq parammxq)
  {
    if (!a(paramLong2, paramString1, paramLong1, "onAnswerExposurePush")) {}
    do
    {
      do
      {
        return;
      } while (!a(paramLong2, paramString1, paramLong1, "onAnswerExposurePush", true));
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameController", 2, String.format("onAnswerExposurePush [seq,rId,gId]=[%d,%d,%s] tips=%s topic=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString1, paramString2, parammxq }));
      }
      paramString1 = (myc)this.jdField_a_of_type_Mzg.a();
    } while (!paramString1.d(parammxq));
    this.jdField_a_of_type_Mze.d(paramString2, paramString1);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, mxq parammxq)
  {
    if (!a(paramLong2, paramString, paramLong1, "onAnswerTimeoutPush")) {}
    do
    {
      do
      {
        return;
      } while (!a(paramLong2, paramString, paramLong1, "onAnswerTimeoutPush", true));
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameController", 2, String.format("onAnswerTimeoutPush [seq,rId,gId]=[%d,%d,%s] topic=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, parammxq }));
      }
      paramString = (myc)this.jdField_a_of_type_Mzg.a();
    } while (!paramString.c(parammxq));
    this.jdField_a_of_type_Mze.h(paramString);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, mxq parammxq, Player paramPlayer)
  {
    if (!a(paramLong2, paramString, paramLong1, "onPlayerChangePush")) {}
    do
    {
      do
      {
        return;
      } while (!a(paramLong2, paramString, paramLong1, "onPlayerChangePush", true));
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameController", 2, String.format("onPlayerChangePush [seq,rId,gId]=[%d,%d,%s] player=%s, topic=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, paramPlayer, parammxq }));
      }
      paramString = (myc)this.jdField_a_of_type_Mzg.a();
    } while (!paramString.a(paramPlayer, parammxq));
    this.jdField_a_of_type_Mze.g(paramString);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, mxq parammxq, String paramString2)
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
          QLog.i("avgame_logic.GameController", 2, String.format("onTopicChangePush [seq,rId,gId]=[%d,%d,%s] switcherUin=%s topic=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString1, paramString2, parammxq }));
        }
        paramString1 = (myc)this.jdField_a_of_type_Mzg.a();
      } while (!paramString1.a(parammxq));
      this.jdField_a_of_type_Mze.a(paramString1, paramString2);
    } while ((!mxo.b(paramString1.c())) || (paramString1.a().size() != 0));
    b(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), paramString1.a(), paramString1.b());
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, myf parammyf, Player paramPlayer, mxq parammxq)
  {
    myc localmyc = (myc)this.jdField_a_of_type_Mzg.a();
    if ((paramLong2 == 0L) || (localmyc.a() != paramLong2)) {
      QLog.d("avgame_logic.GameController", 1, String.format("onGameStartPush bValidSession=false seq=%d roomId=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    do
    {
      do
      {
        return;
      } while (!a(paramLong2, paramString, paramLong1, "onGameStartPush", true));
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameController", 2, String.format("onGameStartPush [seq,rId,gId]=[%d,%d,%s] gInfo=%s, player=%s, topic=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, parammyf, paramPlayer, parammxq }));
      }
      localmyc.a(myd.a(paramLong2, paramString, parammyf, paramPlayer, parammxq));
      this.jdField_a_of_type_Mze.f(localmyc);
    } while (!mxo.b(localmyc.c()));
    b(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), localmyc.a(), localmyc.b());
  }
  
  public void a(long paramLong1, String paramString, long paramLong2, mxq parammxq)
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
          QLog.i("avgame_logic.GameController", 2, String.format("onSwitchTopicSuc [seq,rId,gId]=[%d,%d,%s] topic=%s", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString, parammxq }));
        }
        paramString = (myc)this.jdField_a_of_type_Mzg.a();
      } while (!paramString.a(parammxq));
      this.jdField_a_of_type_Mze.d(paramString);
    } while ((!mxo.b(paramString.c())) || (paramString.a().size() != 0));
    b(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), paramString.a(), paramString.b());
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    QLog.i("avgame_logic.GameController", 1, String.format("onSwitchTopicFail rId=%d gId=%s msg=%s", new Object[] { Long.valueOf(paramLong), paramString1, paramString2 }));
    this.jdField_a_of_type_Mze.a(paramLong, paramString1, paramString2);
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2, RoomInfo paramRoomInfo, List<Long> paramList)
  {
    QLog.d("avgame_logic.GameController", 1, String.format("onStartGameFail uin=%s roomId=%d gameType=%d errCode=%d, errMsg=%s", new Object[] { paramString1, Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 }));
    if ((paramRoomInfo != null) && (paramInt2 == 405)) {
      ((myc)this.jdField_a_of_type_Mzg.a()).a(paramRoomInfo, false);
    }
    if (paramInt2 == 406)
    {
      paramString2 = "";
      RoomInfo localRoomInfo = ((myc)this.jdField_a_of_type_Mzg.a()).a();
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
      paramString2 = String.format(BaseApplicationImpl.getContext().getResources().getString(2131690246), new Object[] { str });
    }
    for (;;)
    {
      this.jdField_a_of_type_Mze.a(paramString1, paramLong, paramInt1, paramInt2, paramString2);
      return;
      label287:
      paramRoomInfo = paramString2;
      break;
    }
  }
  
  public void a(String paramString1, long paramLong1, int paramInt, long paramLong2, String paramString2, myf parammyf, Player paramPlayer, mxq parammxq)
  {
    if ((!this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin().equals(paramString1)) || (paramLong1 == 0L) || (paramLong1 != ((myc)this.jdField_a_of_type_Mzg.a()).a()) || (TextUtils.isEmpty(paramString2)))
    {
      QLog.d("avgame_logic.GameController", 1, String.format("onStartGameSuc bValidSession=false uin=%s gameType=%d [seq,rId,gId]=[%d,%d,%s]", new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString2 }));
      this.jdField_a_of_type_Mze.a(paramString1, paramLong1, paramInt, -1, BaseApplicationImpl.getContext().getResources().getString(2131690347));
    }
    do
    {
      return;
      if (!this.jdField_a_of_type_Mzh.a(paramLong2, paramLong1, false))
      {
        QLog.d("avgame_logic.GameController", 1, String.format("onStartGameSuc bValidSeq=false uin=%s gameType=%d [seq,rId,gId]=[%d,%d,%s]", new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString2 }));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameController", 2, String.format("onStartGameSuc uin=%s type=%d [seq,rId,gId]=[%d,%d,%s], gInfo=%s player=%s topic=%s", new Object[] { paramString1, Integer.valueOf(paramInt), Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString2, parammyf, paramPlayer, parammxq }));
      }
      paramString1 = myd.a(paramLong1, paramString2, parammyf, paramPlayer, parammxq);
      paramString2 = (myc)this.jdField_a_of_type_Mzg.a();
      paramString2.a(paramString1);
      this.jdField_a_of_type_Mze.c(paramString2);
    } while (!mxo.b(paramString2.c()));
    b(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), paramString2.a(), paramString2.b());
  }
  
  public void a(String paramString1, long paramLong, int paramInt, String paramString2)
  {
    ((myz)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(3)).a(paramString1, paramLong, paramInt, paramString2);
  }
  
  public void a(String paramString1, long paramLong, String paramString2)
  {
    ((myz)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(3)).a(paramString1, paramLong, paramString2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    ((myz)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(3)).a(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    QLog.i("avgame_logic.GameController", 1, String.format("onGetGameRankingListFail gId=%s msg=%s", new Object[] { paramString2, paramString3 }));
    this.jdField_a_of_type_Mzc.a(paramString1, paramString2, paramString3);
  }
  
  public void a(String paramString1, String paramString2, List<UserScore> paramList)
  {
    QLog.i("avgame_logic.GameController", 1, String.format("onGetGameRankingListSuc gId=%s scoreListSize=%d", new Object[] { paramString2, Integer.valueOf(paramList.size()) }));
    paramString1 = (myc)this.jdField_a_of_type_Mzg.a();
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase(paramString1.b()))) {}
    while (!paramString1.a(paramList)) {
      return;
    }
    this.jdField_a_of_type_Mzc.i(paramString1);
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isDebugVersion()) {
      QLog.i("avgame_logic.GameController", 1, String.format("onUploadResourceResult isSucc=%b gId=%s filetype=%d url=%s", new Object[] { Boolean.valueOf(paramBoolean), paramString1, Integer.valueOf(paramInt), paramString2 }));
    }
    this.jdField_a_of_type_Mzc.a(paramBoolean, paramString1, paramInt, paramString2);
  }
  
  public void b(long paramLong1, String paramString, long paramLong2, mxq parammxq)
  {
    if (!a(paramLong1, paramString, paramLong2, "onSwitchTopicSuc")) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameController", 2, String.format("onPullTopicsSuc [seq,rId,gId]=[%d,%d,%s] topic=%s", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1), paramString, parammxq }));
    }
    myc localmyc = (myc)this.jdField_a_of_type_Mzg.a();
    if (localmyc.b(parammxq))
    {
      this.jdField_a_of_type_Mze.e(localmyc);
      return;
    }
    this.jdField_a_of_type_Mze.b(paramLong1, paramString, "");
  }
  
  public void b(long paramLong, String paramString1, String paramString2)
  {
    QLog.i("avgame_logic.GameController", 1, String.format("onPullTopicsFail rId=%d gId=%s msg=%s", new Object[] { Long.valueOf(paramLong), paramString1, paramString2 }));
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      str = BaseApplicationImpl.getContext().getResources().getString(2131690321);
    }
    this.jdField_a_of_type_Mze.b(paramLong, paramString1, str);
  }
  
  public void b(String paramString1, long paramLong, String paramString2)
  {
    ((myz)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(3)).a(paramString1, paramLong, paramString2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mxu
 * JD-Core Version:    0.7.0.1
 */