import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.DelayNotifyRunnable;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.data.UserScore;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class mxx
  extends mzj
  implements mxk
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AVGameAppInterface jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  List<DelayNotifyRunnable> jdField_a_of_type_JavaUtilList = new ArrayList();
  private mwv jdField_a_of_type_Mwv = new mxy(this);
  private mza jdField_a_of_type_Mza;
  private mzd jdField_a_of_type_Mzd;
  private mzg<myc> jdField_a_of_type_Mzg;
  private mzh jdField_a_of_type_Mzh;
  private boolean jdField_a_of_type_Boolean;
  
  public mxx(AVGameAppInterface paramAVGameAppInterface, mzd parammzd, mzh parammzh, mzg<myc> parammzg)
  {
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    this.jdField_a_of_type_Mzd = parammzd;
    this.jdField_a_of_type_Mzh = parammzh;
    this.jdField_a_of_type_Mzg = parammzg;
    this.jdField_a_of_type_Mza = ((mza)paramAVGameAppInterface.a(1));
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.addObserver(this, false);
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.addObserver(this.jdField_a_of_type_Mwv, false);
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
  
  private void a(myc parammyc)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("updateNicks when roomInfo update %s", new Object[] { parammyc.a() }));
    }
    parammyc.a(((mwp)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(2)).a(parammyc.a().getUins()));
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    if (!this.jdField_a_of_type_Mzh.a(paramLong1, paramLong2, false))
    {
      QLog.d("avgame_logic.GameRoomController", 1, String.format(" bValidSeq=false seq=%d, roomId=%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
      return false;
    }
    return true;
  }
  
  private boolean a(long paramLong, String paramString)
  {
    myc localmyc = (myc)this.jdField_a_of_type_Mzg.a();
    if ((paramLong == 0L) || (paramLong != localmyc.a()))
    {
      QLog.d("avgame_logic.GameRoomController", 1, String.format("%s bValidSession=false [svrRId,locRId]=[%d,%d]", new Object[] { paramString, Long.valueOf(paramLong), Long.valueOf(localmyc.a()) }));
      return false;
    }
    return true;
  }
  
  private boolean a(String paramString, RoomInfo paramRoomInfo)
  {
    if (paramRoomInfo.getPlayer(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getAccount()) == null)
    {
      this.jdField_a_of_type_Mzd.a(6, BaseApplicationImpl.getApplication().getString(2131690264), (myc)this.jdField_a_of_type_Mzg.a());
      return false;
    }
    paramRoomInfo = (myc)this.jdField_a_of_type_Mzg.a();
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
      paramObject = String.format(BaseApplicationImpl.getApplication().getString(2131690256), new Object[] { bglf.a(paramObject, 8.0F) });
    }
    for (;;)
    {
      localStringBuilder.append(paramObject);
      this.jdField_a_of_type_Mzd.b(paramObject, (myc)this.jdField_a_of_type_Mzg.a());
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomController", 2, String.format("onDelayNotifyDone nt=%d result=%s", new Object[] { Integer.valueOf(paramInt), localStringBuilder.toString() }));
      }
      return;
      label146:
      if (2 == i) {
        paramObject = String.format(BaseApplicationImpl.getApplication().getString(2131690257), new Object[] { bglf.a(paramObject, 5.0F), bglf.a((String)localObject, 5.0F) });
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
    this.jdField_a_of_type_Mzd.g();
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onGetGameRoomInfoFailed() roomId = " + paramLong + " data =" + this.jdField_a_of_type_Mzg.a());
    }
    if (paramLong == ((myc)this.jdField_a_of_type_Mzg.a()).a()) {
      this.jdField_a_of_type_Mzd.a(paramInt, BaseApplicationImpl.getApplication().getString(2131690264), (myc)this.jdField_a_of_type_Mzg.a());
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
      this.jdField_a_of_type_Mzd.a(2, paramString, null, (myc)this.jdField_a_of_type_Mzg.a());
      bcst.b(null, "dc00898", "", "", "0X800B02E", "0X800B02E", 0, 0, paramString, "" + paramLong, "", "");
      return;
    }
    this.jdField_a_of_type_Mzd.a(paramInt, null, (myc)this.jdField_a_of_type_Mzg.a());
    if (this.jdField_a_of_type_Boolean) {}
    for (paramInt = 1;; paramInt = 2)
    {
      bcst.b(null, "dc00898", "", "", "0X800B030", "0X800B030", paramInt, 0, "", "" + paramLong, "", "");
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
      this.jdField_a_of_type_Mzd.a(-2, paramString1, BaseApplicationImpl.getApplication().getString(2131690291), (myc)this.jdField_a_of_type_Mzg.a());
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
      this.jdField_a_of_type_Mzd.a(paramInt, null, (myc)this.jdField_a_of_type_Mzg.a());
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
    this.jdField_a_of_type_Mzd.h();
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
    myc localmyc = (myc)this.jdField_a_of_type_Mzg.a();
    localmyc.a(paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "pushOnGameChange() newIndex = " + localmyc.a);
    }
    this.jdField_a_of_type_Mzd.b(localmyc);
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
      paramRoomInfo = ((myc)this.jdField_a_of_type_Mzg.a()).a().getNick(paramString1);
      paramString2 = ((myc)this.jdField_a_of_type_Mzg.a()).a().getNick(paramString2);
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
    this.jdField_a_of_type_Mzd.b("", (myc)this.jdField_a_of_type_Mzg.a());
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, String paramString1, String paramString2, RoomInfo paramRoomInfo, int paramInt2)
  {
    if (!a(paramLong2, "pushOnRoomExit()")) {
      return;
    }
    if (!a(paramLong1, paramLong2))
    {
      QLog.i("avgame_logic.GameRoomController", 2, "pushOnRoomExit seq is invalid just return");
      return;
    }
    boolean bool;
    if (paramInt1 == 0)
    {
      if ((paramInt2 != 1) || (!paramString1.equals(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin()))) {
        break label394;
      }
      if (bgnt.a())
      {
        paramInt1 = 2131690264;
        paramString2 = BaseApplicationImpl.getApplication().getString(paramInt1);
        bool = true;
      }
    }
    for (;;)
    {
      a(paramRoomInfo, false);
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomController", 2, "pushOnRoomExit() isMine = " + bool + " tips = " + paramString2);
      }
      if (bool)
      {
        this.jdField_a_of_type_Mzd.a(3, paramString2, (myc)this.jdField_a_of_type_Mzg.a());
        return;
        paramInt1 = 2131690307;
        break;
        if (1 == paramInt1)
        {
          if ((paramInt2 == 1) && (paramString1.equals(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin())))
          {
            if (bgnt.a()) {}
            for (paramInt1 = 2131690264;; paramInt1 = 2131690307)
            {
              paramString2 = BaseApplicationImpl.getApplication().getString(paramInt1);
              bool = true;
              break;
            }
          }
          paramString2 = String.format(BaseApplicationImpl.getApplication().getString(2131690305), new Object[] { ((myc)this.jdField_a_of_type_Mzg.a()).a().getNick(paramString2, 8) });
          bool = false;
          continue;
        }
        if (2 != paramInt1) {
          break label394;
        }
        if (paramString1.equals(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin()))
        {
          paramString2 = BaseApplicationImpl.getApplication().getString(2131690292);
          bool = true;
          continue;
        }
        paramString2 = String.format(BaseApplicationImpl.getApplication().getString(2131690293), new Object[] { ((myc)this.jdField_a_of_type_Mzg.a()).a().getNick(paramString1, 8) });
        bool = false;
        continue;
      }
      this.jdField_a_of_type_Mzd.a(1, paramString1, paramString2, (myc)this.jdField_a_of_type_Mzg.a());
      return;
      label394:
      paramString2 = "";
      bool = false;
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
    ((myc)this.jdField_a_of_type_Mzg.a()).a(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "pushOnChangeUserStatus() uin = " + paramString + " userStatusType =" + paramInt);
    }
    paramRoomInfo = (myc)this.jdField_a_of_type_Mzg.a();
    this.jdField_a_of_type_Mzd.a(paramString, paramInt, paramRoomInfo);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong3)
  {
    QLog.d("avgame_logic.GameRoomController", 1, "getGameShareLink  roomId: " + paramLong1 + " shareUin: " + paramLong2 + " shareName: " + paramString1 + " shareType: " + paramInt1 + " gameId: " + paramString2 + " gameType: " + paramInt2 + " pbMark" + paramLong3);
    this.jdField_a_of_type_Mza.a(paramLong1, paramLong2, paramString1, paramInt1, paramString2, paramInt2, paramLong3);
  }
  
  public void a(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onChangeUserStatusFailed() errorMsg =" + paramString + "errorCode = " + paramInt1 + " from = " + paramInt2);
    }
    if (!a(paramLong, "onChangeUserStatusFailed()")) {
      return;
    }
    this.jdField_a_of_type_Mzd.a(paramString, paramInt1, paramInt2);
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "kickGameRoomUserByOwner roomId = " + paramLong + " ownerUin =" + paramString1 + " kickedUserUin =" + paramString2 + " isHostUser =" + ((myc)this.jdField_a_of_type_Mzg.a()).e(paramString1));
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (!((myc)this.jdField_a_of_type_Mzg.a()).e(paramString1))) {
      return;
    }
    this.jdField_a_of_type_Mza.a(paramLong, 2, paramString1, paramString2);
  }
  
  public void a(long paramLong, String paramString1, List<myh> paramList, String paramString2, String paramString3)
  {
    if (!a(paramLong, "onGetGameQuestionClass()")) {
      return;
    }
    ((myc)this.jdField_a_of_type_Mzg.a()).a(paramList, paramString2, paramString3);
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "leaveGameRoomByUser roomId = " + paramLong + " userUin =" + paramString);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Mza.a(paramLong, 1, paramString, paramString);
  }
  
  public void a(long paramLong, String paramString1, boolean paramBoolean, int paramInt1, String paramString2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onGetGameRoomInfoFailed() uin = " + paramString1 + " isFromSync =" + paramBoolean + " fromType=" + paramInt1);
    }
    if (!a(paramLong, "onGetGameRoomInfoFailed()")) {
      return;
    }
    if (((paramInt2 == 106) || (paramInt2 == 111)) && (paramLong == ((myc)this.jdField_a_of_type_Mzg.a()).a()))
    {
      this.jdField_a_of_type_Mzd.a(6, BaseApplicationImpl.getApplication().getString(2131690264), (myc)this.jdField_a_of_type_Mzg.a());
      return;
    }
    this.jdField_a_of_type_Mzd.a(paramLong, paramString1, paramBoolean, paramString2, paramInt2);
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "getGameRoomInfo roomId = " + paramLong + " uin = " + paramString + " fromSync=" + paramBoolean2 + " fromEnter=" + paramBoolean2);
    }
    this.jdField_a_of_type_Mza.a(paramLong, paramString, paramBoolean1, 1);
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
      ((myc)this.jdField_a_of_type_Mzg.a()).a(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), 1);
    }
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onChangeUserStatusSuccess() and from = " + paramInt);
    }
    paramRoomInfo = (myc)this.jdField_a_of_type_Mzg.a();
    this.jdField_a_of_type_Mzd.a(paramRoomInfo, paramInt);
  }
  
  public void a(RoomInfo paramRoomInfo, myd parammyd, List<UserScore> paramList, List<myg> paramList1, int paramInt, String paramString1, String paramString2)
  {
    paramString1 = (myc)this.jdField_a_of_type_Mzg.a();
    parammyd.a(paramString1.a());
    paramString1.a(paramRoomInfo, false);
    paramString1.a(paramList1, paramInt);
    paramString1.a(parammyd);
    paramString1.a(paramList);
    if ((mxo.b(paramString1.c())) && (paramString1.a().size() == 0) && (paramString1.a() >= 0) && (paramString1.a() <= 10)) {
      ((myz)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(3)).a(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), paramString1.a(), paramString1.b(), false);
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
      this.jdField_a_of_type_Mzh.a();
      this.jdField_a_of_type_Mzh.a(paramRoomInfo.seq, paramRoomInfo.id, false);
    }
    myc localmyc = (myc)this.jdField_a_of_type_Mzg.a();
    localmyc.a(paramRoomInfo, paramBoolean);
    a(localmyc);
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "selectGame roomId = " + paramLong + " uin = " + paramString + " isHost =" + ((myc)this.jdField_a_of_type_Mzg.a()).e(paramString));
    }
    if ((TextUtils.isEmpty(paramString)) || (!((myc)this.jdField_a_of_type_Mzg.a()).e(paramString))) {
      return;
    }
    this.jdField_a_of_type_Mza.a(paramString, paramLong, paramInt);
  }
  
  public void a(String paramString1, boolean paramBoolean, int paramInt1, RoomInfo paramRoomInfo, mxp parammxp, List<UserScore> paramList, List<myg> paramList1, int paramInt2, String paramString2, String paramString3)
  {
    long l1 = paramRoomInfo.seq;
    long l2 = paramRoomInfo.id;
    if (!a(l2, "onGetGameRoomInfoSuccess()")) {}
    do
    {
      return;
      if (!this.jdField_a_of_type_Mzh.a(l1, l2, paramBoolean))
      {
        QLog.i("avgame_logic.GameRoomController", 2, "onGetGameRoomInfoSuccess() seq is invalid just return");
        return;
      }
      if (!paramBoolean) {
        break;
      }
      a(paramRoomInfo, (myd)parammxp, paramList, paramList1, paramInt2, paramString2, paramString3);
      if (QLog.isColorLevel()) {
        QLog.i("avgame_logic.GameRoomController", 2, String.format("onGetSnapshotSuc() fromEnter=%b curGameIndex=%d roomInfo=[%s] game=[%s] scores=[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramRoomInfo, parammxp, Arrays.toString(paramList.toArray()) }));
      }
    } while (!a(paramString1, paramRoomInfo));
    this.jdField_a_of_type_Mzd.c((myc)this.jdField_a_of_type_Mzg.a(), paramInt1);
    return;
    a(paramRoomInfo, false);
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, String.format("onGetGameRoomInfoSuccess() roomInfo=[%s]", new Object[] { paramRoomInfo }));
    }
    this.jdField_a_of_type_Mzd.a(paramString1, (myc)this.jdField_a_of_type_Mzg.a());
  }
  
  public void a(List<myg> paramList, int paramInt, String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "onGetGameListSuccess() curGameIndex = " + paramInt + " resUrl =" + paramString1 + " resMd5 =" + paramString2);
    }
    if (!a(paramLong, "onGetGameListSuccess()")) {}
    do
    {
      return;
      paramString1 = (myc)this.jdField_a_of_type_Mzg.a();
      paramString1.a(paramList, paramInt);
      this.jdField_a_of_type_Mzd.a(paramString1);
    } while ((paramList == null) || (paramList.size() <= 0));
    paramString1 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramString1.add(Integer.valueOf(((myg)paramList.next()).a));
    }
    this.jdField_a_of_type_Mza.a(paramLong, paramString1);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.removeObserver(this);
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.removeObserver(this.jdField_a_of_type_Mwv);
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
    this.jdField_a_of_type_Mza.a(paramLong);
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
    this.jdField_a_of_type_Mzd.i();
  }
  
  public void b(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "changeUserStatus roomId = " + paramLong + " userUin =" + paramString + " userStatus =" + paramInt1);
    }
    this.jdField_a_of_type_Mza.a(paramLong, paramString, paramInt1, paramInt2);
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameRoomController", 2, "pushOnRoomDestroy()");
    }
    if (!a(paramLong2, "pushOnRoomDestroy()")) {
      return;
    }
    this.jdField_a_of_type_Mzd.a(7, BaseApplicationImpl.getApplication().getString(2131690334), (myc)this.jdField_a_of_type_Mzg.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mxx
 * JD-Core Version:    0.7.0.1
 */