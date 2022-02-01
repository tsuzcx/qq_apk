import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.DelayNotifyRunnable;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.data.UserScore;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class naa
  extends nbn
  implements mzk
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AVGameAppInterface jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  List<DelayNotifyRunnable> jdField_a_of_type_JavaUtilList = new ArrayList();
  private myf jdField_a_of_type_Myf = new nab(this);
  private nbe jdField_a_of_type_Nbe;
  private nbh jdField_a_of_type_Nbh;
  private nbk<naf> jdField_a_of_type_Nbk;
  private nbl jdField_a_of_type_Nbl;
  private boolean jdField_a_of_type_Boolean;
  
  public naa(AVGameAppInterface paramAVGameAppInterface, nbh paramnbh, nbl paramnbl, nbk<naf> paramnbk)
  {
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    this.jdField_a_of_type_Nbh = paramnbh;
    this.jdField_a_of_type_Nbl = paramnbl;
    this.jdField_a_of_type_Nbk = paramnbk;
    this.jdField_a_of_type_Nbe = ((nbe)paramAVGameAppInterface.a(1));
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.addObserver(this, false);
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.addObserver(this.jdField_a_of_type_Myf, false);
  }
  
  private void a(HashMap<String, String> paramHashMap)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (i > 0)
    {
      i -= 1;
      while (i >= 0)
      {
        DelayNotifyRunnable localDelayNotifyRunnable = (DelayNotifyRunnable)this.jdField_a_of_type_JavaUtilList.get(i);
        String str = (String)localDelayNotifyRunnable.a();
        if ((str != null) && (paramHashMap.containsKey(str)))
        {
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(localDelayNotifyRunnable);
          this.jdField_a_of_type_JavaUtilList.remove(i);
          localDelayNotifyRunnable.a((String)paramHashMap.get(str));
        }
        i -= 1;
      }
    }
  }
  
  private void a(naf paramnaf)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("updateNicks when roomInfo update %s", new Object[] { paramnaf.a() }));
    }
    paramnaf.a(((mxz)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(2)).a(paramnaf.a().getUins()));
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    if (!this.jdField_a_of_type_Nbl.a(paramLong1, paramLong2, false))
    {
      QLog.d("avgame_logic.GameRoomController", 1, String.format(" bValidSeq=false seq=%d, roomId=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
      return false;
    }
    return true;
  }
  
  private boolean a(long paramLong, String paramString)
  {
    naf localnaf = (naf)this.jdField_a_of_type_Nbk.a();
    if ((paramLong == 0L) || (paramLong != localnaf.a()))
    {
      QLog.d("avgame_logic.GameRoomController", 1, String.format("%s bValidSession=false [svrRId,locRId]=[%d,%d]", new Object[] { paramString, Long.valueOf(paramLong), Long.valueOf(localnaf.a()) }));
      return false;
    }
    return true;
  }
  
  private boolean a(String paramString, RoomInfo paramRoomInfo)
  {
    if (paramRoomInfo.getPlayer(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getAccount()) == null)
    {
      this.jdField_a_of_type_Nbh.a(6, BaseApplicationImpl.getApplication().getString(2131690295), (naf)this.jdField_a_of_type_Nbk.a());
      return false;
    }
    paramRoomInfo = (naf)this.jdField_a_of_type_Nbk.a();
    int i = paramRoomInfo.a();
    int j = paramRoomInfo.b();
    if ((j == 1) && (i == 10)) {
      paramRoomInfo.a(paramString, j);
    }
    return true;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject;
    int i;
    if (paramInt == 0)
    {
      localObject = (Object[])paramObject;
      paramObject = (String)localObject[0];
      i = ((Integer)localObject[1]).intValue();
      localObject = (String)localObject[2];
      if (1 != i) {
        break label146;
      }
      paramObject = String.format(BaseApplicationImpl.getApplication().getString(2131690289), new Object[] { ContactUtils.getFitString(paramObject, 8.0F) });
    }
    for (;;)
    {
      localStringBuilder.append(paramObject);
      this.jdField_a_of_type_Nbh.b(paramObject, (naf)this.jdField_a_of_type_Nbk.a());
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomController", 2, String.format("onDelayNotifyDone nt=%d result=%s", new Object[] { Integer.valueOf(paramInt), localStringBuilder.toString() }));
      }
      return;
      label146:
      if (2 == i) {
        paramObject = String.format(BaseApplicationImpl.getApplication().getString(2131690290), new Object[] { ContactUtils.getFitString(paramObject, 5.0F), ContactUtils.getFitString((String)localObject, 5.0F) });
      } else {
        paramObject = "";
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onGetGameListFailed() roomId=" + paramLong);
    }
    if (!a(paramLong, "onGetGameListSuccess()")) {
      return;
    }
    this.jdField_a_of_type_Nbh.g();
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onGetGameRoomInfoFailed() roomId = " + paramLong + " data =" + this.jdField_a_of_type_Nbk.a());
    }
    if (paramLong == ((naf)this.jdField_a_of_type_Nbk.a()).a()) {
      this.jdField_a_of_type_Nbh.a(paramInt, BaseApplicationImpl.getApplication().getString(2131690295), (naf)this.jdField_a_of_type_Nbk.a());
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString, RoomInfo paramRoomInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onLeaveGameRoomSuccess() leaveType =" + paramInt + " kickUin = " + paramString);
    }
    if (2 == paramInt)
    {
      if (!a(paramLong, "onLeaveGameRoomSuccess(kick)")) {
        return;
      }
      a(paramRoomInfo, false);
      this.jdField_a_of_type_Nbh.a(2, paramString, null, (naf)this.jdField_a_of_type_Nbk.a());
      bcef.b(null, "dc00898", "", "", "0X800B02E", "0X800B02E", 0, 0, paramString, "" + paramLong, "", "");
      return;
    }
    this.jdField_a_of_type_Nbh.a(paramInt, null, (naf)this.jdField_a_of_type_Nbk.a());
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 2)
    {
      bcef.b(null, "dc00898", "", "", "0X800B030", "0X800B030", paramInt, 0, "", "" + paramLong, "", "");
      this.jdField_a_of_type_Boolean = false;
      return;
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onLeaveGameRoomFailed() leaveType =" + paramInt + " kickUin = " + paramString1 + " errorMsg = " + paramString2);
    }
    if (2 == paramInt)
    {
      if (!a(paramLong, "onLeaveGameRoomFailed(kick)")) {
        return;
      }
      this.jdField_a_of_type_Nbh.a(-2, paramString1, BaseApplicationImpl.getApplication().getString(2131690319), (naf)this.jdField_a_of_type_Nbk.a());
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_Nbh.a(paramInt, null, (naf)this.jdField_a_of_type_Nbk.a());
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onSelectGameSuccess roomId=" + paramLong2);
    }
    if (!a(paramLong2, "onSelectGameSuccess()")) {
      return;
    }
    if (!a(paramLong1, paramLong2))
    {
      QLog.i("avgame_logic.GameRoomController", 2, "onSelectGameSuccess() seq is invalid just return");
      return;
    }
    this.jdField_a_of_type_Nbh.h();
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    if (!a(paramLong2, "pushOnGameChange()")) {
      return;
    }
    if (!a(paramLong1, paramLong2))
    {
      QLog.i("avgame_logic.GameRoomController", 2, "pushOnGameChange() seq is invalid just return");
      return;
    }
    naf localnaf = (naf)this.jdField_a_of_type_Nbk.a();
    localnaf.a(paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "pushOnGameChange() newIndex = " + localnaf.a);
    }
    this.jdField_a_of_type_Nbh.b(localnaf);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt, String paramString1, String paramString2, RoomInfo paramRoomInfo)
  {
    if (!a(paramLong2, "pushOnRoomEnter()")) {
      return;
    }
    if (!a(paramLong1, paramLong2))
    {
      QLog.i("avgame_logic.GameRoomController", 2, "pushOnRoomEnter() seq is invalid just return");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("pushOnRoomEnter seq=%d rId=%d enterType=%d enterUin=%s inviterUin=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(paramInt), paramString1, paramString2 }));
    }
    a(paramRoomInfo, false);
    if (!this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin().equals(paramString1))
    {
      paramRoomInfo = ((naf)this.jdField_a_of_type_Nbk.a()).a().getNick(paramString1);
      paramString2 = ((naf)this.jdField_a_of_type_Nbk.a()).a().getNick(paramString2);
      if ((paramRoomInfo != null) && (!paramRoomInfo.equalsIgnoreCase(paramString1))) {}
      for (int i = 1;; i = 0)
      {
        paramString1 = new DelayNotifyRunnable(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface, 0, this, new Object[] { paramString1, Integer.valueOf(paramInt), paramString2 });
        if (i == 0) {
          break;
        }
        paramString1.a(paramRoomInfo);
        return;
      }
      this.jdField_a_of_type_JavaUtilList.add(paramString1);
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramString1, 1500L);
      return;
    }
    this.jdField_a_of_type_Nbh.b("", (naf)this.jdField_a_of_type_Nbk.a());
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, String paramString1, String paramString2, RoomInfo paramRoomInfo, int paramInt2, int paramInt3, String paramString3, String paramString4)
  {
    if (!a(paramLong2, "pushOnRoomExit()")) {
      return;
    }
    if (!a(paramLong1, paramLong2))
    {
      QLog.i("avgame_logic.GameRoomController", 2, "pushOnRoomExit seq is invalid just return");
      return;
    }
    String str = this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin();
    boolean bool;
    if (paramInt1 == 0) {
      if (paramInt3 == 1) {
        if (paramString1.equals(str))
        {
          bool = true;
          if (!paramString1.equals(String.valueOf(paramRoomInfo.owner))) {
            break label725;
          }
          paramInt2 = 1;
        }
      }
    }
    for (;;)
    {
      if (paramInt2 != 0) {
        mzl.a().f();
      }
      a(paramRoomInfo, false);
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomController", 2, "pushOnRoomExit() isMine = " + bool + " tips = " + paramString4);
      }
      if (bool)
      {
        this.jdField_a_of_type_Nbh.a(3, paramString4, (naf)this.jdField_a_of_type_Nbk.a());
        if (paramInt3 != 1) {
          break;
        }
        if (paramInt2 != 0)
        {
          bcef.b(null, "dc00898", "", "", "0X800B35A", "0X800B35A", 0, 0, "", "", "", "");
          return;
          if (!str.equals(String.valueOf(paramRoomInfo.owner))) {
            break label711;
          }
          paramString4 = paramString3.replace("#", ((naf)this.jdField_a_of_type_Nbk.a()).a().getNick(paramString1));
          bool = false;
          paramInt2 = 0;
          continue;
          if ((paramInt2 != 1) || (!paramString1.equals(str))) {
            break label711;
          }
          if (NetworkUtil.isNetworkAvailable()) {}
          for (paramInt2 = 2131690295;; paramInt2 = 2131690350)
          {
            paramString4 = BaseApplicationImpl.getApplication().getString(paramInt2);
            bool = true;
            paramInt2 = 0;
            break;
          }
          if (1 == paramInt1)
          {
            if ((paramInt3 == 1) && (paramString1.equals(str)))
            {
              bool = true;
              paramInt2 = 1;
              continue;
            }
            if ((paramInt2 == 1) && (paramString1.equals(str)))
            {
              if (NetworkUtil.isNetworkAvailable()) {}
              for (paramInt2 = 2131690295;; paramInt2 = 2131690350)
              {
                paramString4 = BaseApplicationImpl.getApplication().getString(paramInt2);
                bool = true;
                paramInt2 = 0;
                break;
              }
            }
            paramString4 = String.format(BaseApplicationImpl.getApplication().getString(2131690347), new Object[] { ((naf)this.jdField_a_of_type_Nbk.a()).a().getNick(paramString2, 8) });
            bool = false;
            paramInt2 = 0;
            continue;
          }
          if (2 != paramInt1) {
            break label711;
          }
          if (paramString1.equals(str))
          {
            paramString4 = BaseApplicationImpl.getApplication().getString(2131690320);
            bool = true;
            paramInt2 = 0;
            continue;
          }
          paramString4 = String.format(BaseApplicationImpl.getApplication().getString(2131690321), new Object[] { ((naf)this.jdField_a_of_type_Nbk.a()).a().getNick(paramString1, 8) });
          bool = false;
          paramInt2 = 0;
          continue;
        }
        bcef.b(null, "dc00898", "", "", "0X800B35C", "0X800B35C", 0, 0, "", "", "", "");
        return;
      }
      if ((paramInt1 != 1) && (paramInt3 == 1) && (str.equals(String.valueOf(paramRoomInfo.owner))) && (!paramString1.equals(str)))
      {
        this.jdField_a_of_type_Nbh.a(3, paramString1, paramString4, (naf)this.jdField_a_of_type_Nbk.a());
        bcef.b(null, "dc00898", "", "", "0X800B35B", "0X800B35B", 0, 0, "", "", "", "");
        return;
      }
      this.jdField_a_of_type_Nbh.a(1, paramString1, paramString4, (naf)this.jdField_a_of_type_Nbk.a());
      return;
      label711:
      paramString4 = "";
      bool = false;
      paramInt2 = 0;
      continue;
      label725:
      paramInt2 = 0;
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, int paramInt, RoomInfo paramRoomInfo)
  {
    if (!a(paramLong2, "pushOnChangeUserStatus()")) {
      return;
    }
    if (!a(paramLong1, paramLong2))
    {
      QLog.i("avgame_logic.GameRoomController", 2, "pushOnChangeUserStatus() seq is invalid just return");
      return;
    }
    a(paramRoomInfo, false);
    ((naf)this.jdField_a_of_type_Nbk.a()).a(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "pushOnChangeUserStatus() uin = " + paramString + " userStatusType =" + paramInt);
    }
    paramRoomInfo = (naf)this.jdField_a_of_type_Nbk.a();
    this.jdField_a_of_type_Nbh.a(paramString, paramInt, paramRoomInfo);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong3)
  {
    QLog.d("avgame_logic.GameRoomController", 1, "getGameShareLink  roomId: " + paramLong1 + " shareUin: " + paramLong2 + " shareName: " + paramString1 + " shareType: " + paramInt1 + " gameId: " + paramString2 + " gameType: " + paramInt2 + " pbMark" + paramLong3);
    this.jdField_a_of_type_Nbe.a(paramLong1, paramLong2, paramString1, paramInt1, paramString2, paramInt2, paramLong3);
  }
  
  public void a(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onChangeUserStatusFailed() errorMsg =" + paramString + "errorCode = " + paramInt1 + " from = " + paramInt2);
    }
    if (!a(paramLong, "onChangeUserStatusFailed()")) {
      return;
    }
    this.jdField_a_of_type_Nbh.a(paramString, paramInt1, paramInt2);
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "kickGameRoomUserByOwner roomId = " + paramLong + " ownerUin =" + paramString1 + " kickedUserUin =" + paramString2 + " isHostUser =" + ((naf)this.jdField_a_of_type_Nbk.a()).e(paramString1));
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (!((naf)this.jdField_a_of_type_Nbk.a()).e(paramString1))) {
      return;
    }
    this.jdField_a_of_type_Nbe.a(paramLong, 2, paramString1, paramString2);
  }
  
  public void a(long paramLong, String paramString1, List<nal> paramList, String paramString2, String paramString3)
  {
    if (!a(paramLong, "onGetGameQuestionClass()")) {
      return;
    }
    ((naf)this.jdField_a_of_type_Nbk.a()).a(paramList, paramString2, paramString3);
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "leaveGameRoomByUser roomId = " + paramLong + " userUin =" + paramString);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Nbe.a(paramLong, 1, paramString, paramString);
  }
  
  public void a(long paramLong, String paramString1, boolean paramBoolean, int paramInt1, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onGetGameRoomInfoFailed() uin = " + paramString1 + " isFromSync =" + paramBoolean + " fromType=" + paramInt1);
    }
    if (!a(paramLong, "onGetGameRoomInfoFailed()")) {
      return;
    }
    if (((paramInt2 == 106) || (paramInt2 == 111)) && (paramLong == ((naf)this.jdField_a_of_type_Nbk.a()).a()))
    {
      this.jdField_a_of_type_Nbh.a(6, BaseApplicationImpl.getApplication().getString(2131690295), (naf)this.jdField_a_of_type_Nbk.a());
      return;
    }
    this.jdField_a_of_type_Nbh.a(paramLong, paramString1, paramBoolean, paramString2, paramInt2);
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "getGameRoomInfo roomId = " + paramLong + " uin = " + paramString + " fromSync=" + paramBoolean2 + " fromEnter=" + paramBoolean2);
    }
    this.jdField_a_of_type_Nbe.a(paramLong, paramString, paramBoolean1, 1);
  }
  
  public void a(RoomInfo paramRoomInfo, int paramInt)
  {
    if (paramRoomInfo == null) {}
    for (long l = 0L; !a(l, "onChangeUserStatusSuccess()"); l = paramRoomInfo.id) {
      return;
    }
    if (!a(paramRoomInfo.seq, paramRoomInfo.id))
    {
      QLog.i("avgame_logic.GameRoomController", 2, "onChangeUserStatusSuccess() seq is invalid just return");
      return;
    }
    a(paramRoomInfo, false);
    if ((paramInt == 4) || (paramInt == 2)) {
      ((naf)this.jdField_a_of_type_Nbk.a()).a(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), 1);
    }
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onChangeUserStatusSuccess() and from = " + paramInt);
    }
    paramRoomInfo = (naf)this.jdField_a_of_type_Nbk.a();
    this.jdField_a_of_type_Nbh.a(paramRoomInfo, paramInt);
  }
  
  public void a(RoomInfo paramRoomInfo, nag paramnag, List<UserScore> paramList, List<nak> paramList1, int paramInt, String paramString1, String paramString2)
  {
    paramString1 = (naf)this.jdField_a_of_type_Nbk.a();
    paramnag.a(paramString1.a());
    paramString1.a(paramRoomInfo, false);
    paramString1.a(paramList1, paramInt);
    paramString1.a(paramnag);
    paramString1.a(paramList);
    if ((mzo.b(paramString1.c())) && (paramString1.a().size() == 0) && (paramString1.a() >= 0) && (paramString1.a() <= 10)) {
      ((nbd)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(3)).a(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), paramString1.a(), paramString1.b(), false);
    }
    if (paramRoomInfo != null) {
      a(paramString1);
    }
  }
  
  public void a(RoomInfo paramRoomInfo, boolean paramBoolean)
  {
    if (paramRoomInfo == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_Nbl.a();
      this.jdField_a_of_type_Nbl.a(paramRoomInfo.seq, paramRoomInfo.id, false);
    }
    naf localnaf = (naf)this.jdField_a_of_type_Nbk.a();
    localnaf.a(paramRoomInfo, paramBoolean);
    a(localnaf);
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "selectGame roomId = " + paramLong + " uin = " + paramString + " isHost =" + ((naf)this.jdField_a_of_type_Nbk.a()).e(paramString));
    }
    if ((TextUtils.isEmpty(paramString)) || (!((naf)this.jdField_a_of_type_Nbk.a()).e(paramString))) {
      return;
    }
    this.jdField_a_of_type_Nbe.a(paramString, paramLong, paramInt);
  }
  
  public void a(String paramString1, boolean paramBoolean, int paramInt1, RoomInfo paramRoomInfo, mzp parammzp, List<UserScore> paramList, List<nak> paramList1, int paramInt2, String paramString2, String paramString3)
  {
    long l1 = paramRoomInfo.seq;
    long l2 = paramRoomInfo.id;
    if (!a(l2, "onGetGameRoomInfoSuccess()")) {}
    do
    {
      return;
      if (!this.jdField_a_of_type_Nbl.a(l1, l2, paramBoolean))
      {
        QLog.i("avgame_logic.GameRoomController", 2, "onGetGameRoomInfoSuccess() seq is invalid just return");
        return;
      }
      if (!paramBoolean) {
        break;
      }
      a(paramRoomInfo, (nag)parammzp, paramList, paramList1, paramInt2, paramString2, paramString3);
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomController", 2, String.format("onGetSnapshotSuc() fromEnter=%b curGameIndex=%d roomInfo=[%s] game=[%s] scores=[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramRoomInfo, parammzp, Arrays.toString(paramList.toArray()) }));
      }
    } while (!a(paramString1, paramRoomInfo));
    this.jdField_a_of_type_Nbh.c((naf)this.jdField_a_of_type_Nbk.a(), paramInt1);
    return;
    a(paramRoomInfo, false);
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onGetGameRoomInfoSuccess() roomInfo=[%s]", new Object[] { paramRoomInfo }));
    }
    this.jdField_a_of_type_Nbh.a(paramString1, (naf)this.jdField_a_of_type_Nbk.a());
  }
  
  public void a(List<nak> paramList, int paramInt, String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onGetGameListSuccess() curGameIndex = " + paramInt + " resUrl =" + paramString1 + " resMd5 =" + paramString2);
    }
    if (!a(paramLong, "onGetGameListSuccess()")) {}
    do
    {
      return;
      paramString1 = (naf)this.jdField_a_of_type_Nbk.a();
      paramString1.a(paramList, paramInt);
      this.jdField_a_of_type_Nbh.a(paramString1);
    } while ((paramList == null) || (paramList.size() <= 0));
    paramString1 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramString1.add(Integer.valueOf(((nak)paramList.next()).a));
    }
    this.jdField_a_of_type_Nbe.a(paramLong, paramString1);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onStartStrangerMatch isSuc=" + paramBoolean + " roomId=" + paramLong + " shareId=" + paramInt1 + " errCod=" + paramInt2 + " errMsg=" + paramString);
    }
    if (paramBoolean)
    {
      ((naf)this.jdField_a_of_type_Nbk.a()).a(paramLong, 1);
      ((naf)this.jdField_a_of_type_Nbk.a()).b(paramLong, paramInt1);
    }
    this.jdField_a_of_type_Nbh.a(paramBoolean, paramLong, paramInt1, paramInt2, paramString);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onStopStrangerMatch isSuc=" + paramBoolean + " roomId=" + paramLong + " errCod=" + paramInt + " errMsg=" + paramString);
    }
    if (paramBoolean)
    {
      naf localnaf = (naf)this.jdField_a_of_type_Nbk.a();
      localnaf.b(paramLong, 0);
      localnaf.a(paramLong, 0);
    }
    this.jdField_a_of_type_Nbh.a(paramBoolean, paramLong, paramInt, paramString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.removeObserver(this);
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.removeObserver(this.jdField_a_of_type_Myf);
    a();
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "destroy() ");
    }
  }
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "getGameRoomList roomId = " + paramLong);
    }
    this.jdField_a_of_type_Nbe.a(paramLong);
  }
  
  protected void b(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onRoomMatchStatusChange roomId=" + paramLong + " matchStatus=" + paramInt);
    }
    if (!a(paramLong, "onRoomMatchStatusChange()")) {
      return;
    }
    naf localnaf = (naf)this.jdField_a_of_type_Nbk.a();
    localnaf.a(paramLong, paramInt);
    this.jdField_a_of_type_Nbh.a(paramLong, localnaf.a(localnaf.e(mzl.a().a().getCurrentAccountUin())));
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onSelectGameFailed() Failed");
    }
    if (!a(paramLong2, "onSelectGameFailed()")) {
      return;
    }
    if (!a(paramLong1, paramLong2))
    {
      QLog.i("avgame_logic.GameRoomController", 2, "onSelectGameFailed() seq is invalid just return");
      return;
    }
    this.jdField_a_of_type_Nbh.i();
  }
  
  public void b(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "changeUserStatus roomId = " + paramLong + " userUin =" + paramString + " userStatus =" + paramInt1);
    }
    this.jdField_a_of_type_Nbe.a(paramLong, paramString, paramInt1, paramInt2);
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "pushOnRoomDestroy()");
    }
    if (!a(paramLong2, "pushOnRoomDestroy()")) {
      return;
    }
    this.jdField_a_of_type_Nbh.a(7, BaseApplicationImpl.getApplication().getString(2131690377), (naf)this.jdField_a_of_type_Nbk.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     naa
 * JD-Core Version:    0.7.0.1
 */