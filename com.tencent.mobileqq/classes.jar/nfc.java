import android.os.Build.VERSION;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.GameEngine.1;
import com.tencent.avgame.gamelogic.controller.RoomController;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.avgame.ipc.ProcessMonitor;
import com.tencent.avgame.qav.SecurityPolicyChecker;
import com.tencent.avgame.util.AVGameNodeReportUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class nfc
  implements lfq, ngw, ngx, ngy, nha<nfv>
{
  private AVGameAppInterface jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  private RoomController jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController;
  private List<ngx> jdField_a_of_type_JavaUtilList;
  protected ndt a;
  private nfo jdField_a_of_type_Nfo;
  private nfp jdField_a_of_type_Nfp;
  private nfs jdField_a_of_type_Nfs;
  private nft jdField_a_of_type_Nft;
  private nfv jdField_a_of_type_Nfv;
  private List<ngy> b;
  private List<ngw> c;
  
  private nfc()
  {
    this.jdField_a_of_type_Ndt = new nfd(this);
  }
  
  public static nfc a()
  {
    return nfe.a;
  }
  
  public static boolean a(nfv paramnfv)
  {
    return a().a().getAccount().equals(paramnfv.a().a.uin);
  }
  
  private void b(AVGameAppInterface paramAVGameAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    this.jdField_a_of_type_Nfv = new nfv();
    this.jdField_a_of_type_Nft = new nft(paramAVGameAppInterface);
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController = new RoomController(paramAVGameAppInterface, this, this.jdField_a_of_type_Nft, this);
    this.jdField_a_of_type_Nfo = new nfo(paramAVGameAppInterface, this, this, this.jdField_a_of_type_Nft, this);
    this.jdField_a_of_type_Nfp = new nfp(paramAVGameAppInterface, this.jdField_a_of_type_Nft, this, this);
    this.jdField_a_of_type_Nfs = new nfs(paramAVGameAppInterface, this.jdField_a_of_type_Nfp, this.jdField_a_of_type_Nft, this, this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList(4);
    this.b = new ArrayList(4);
    this.c = new ArrayList(1);
  }
  
  private void n()
  {
    this.jdField_a_of_type_Nfp.a();
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController.c();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.b.clear();
    this.c.clear();
    this.jdField_a_of_type_Nft.a();
    this.jdField_a_of_type_Nfs.a();
    nnm.b().b(this.jdField_a_of_type_Ndt);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Nfv.a().getPlayers().size();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Nfv.d();
  }
  
  public AVGameAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  }
  
  public nfv a()
  {
    return this.jdField_a_of_type_Nfv;
  }
  
  public void a()
  {
    nnm.b().a(this.jdField_a_of_type_Ndt);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Nfp.a(paramInt);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, nfv paramnfv)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ngx)localIterator.next()).a(paramInt, paramString1, paramString2, paramnfv);
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameEngine", 4, "getGameRoomList roomId = " + paramLong);
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController.b(paramLong);
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((ngy)localIterator.next()).a(paramLong, paramInt, paramString1, paramString2);
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong3)
  {
    QLog.d("avgame_logic.GameEngine", 1, "getGameShareLink  roomId: " + paramLong1 + " shareUin: " + paramLong2 + " shareName: " + paramString1 + " shareType: " + paramInt1 + " gameId: " + paramString2 + " gameType: " + paramInt2 + " pbMark" + paramLong3);
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController.a(paramLong1, paramLong2, paramString1, paramInt1, paramString2, paramInt2, paramLong3);
  }
  
  public void a(long paramLong, String paramString)
  {
    this.jdField_a_of_type_Nfp.a(paramLong, paramString);
  }
  
  public void a(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameEngine", 4, "changeUserStatus roomId = " + paramLong + " userUin =" + paramString + " userStatus =" + paramInt1 + " from = " + paramInt2);
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController.b(paramLong, paramString, paramInt1, paramInt2);
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((ngy)localIterator.next()).a(paramLong, paramString1, paramString2);
    }
  }
  
  public void a(long paramLong, String paramString1, boolean paramBoolean, String paramString2, int paramInt)
  {
    if (paramBoolean) {}
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ngx)localIterator.next()).a(paramLong, paramString1, paramBoolean, paramString2, paramInt);
    }
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameEngine", 4, "getGameRoomInfo roomId = " + paramLong + " uin = " + paramString + " fromSync=" + paramBoolean2 + " fromEnter=" + paramBoolean2);
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController.a(paramLong, paramString, paramBoolean1, paramBoolean2);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ngx)localIterator.next()).a(paramLong, paramBoolean);
    }
  }
  
  public void a(AVGameAppInterface paramAVGameAppInterface)
  {
    b(paramAVGameAppInterface);
  }
  
  public void a(RoomInfo paramRoomInfo)
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController.a(paramRoomInfo, true);
  }
  
  public void a(String paramString)
  {
    if (!this.jdField_a_of_type_Nfv.a()) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a().b(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    a(paramString, paramInt);
    nqc localnqc = nqc.a();
    if (a().a().a() != null) {}
    for (String str = a().a().a().a();; str = "")
    {
      localnqc.a(true, paramString, str, paramInt, a().b(), a().getCurrentAccountUin(), nqc.a().a(), a().a());
      return;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((ngw)localIterator.next()).a(paramString, paramInt1, paramInt2);
    }
    localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ngx)localIterator.next()).a(paramString, paramInt1, paramInt2);
    }
  }
  
  public void a(String paramString, int paramInt, nfv paramnfv)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((ngw)localIterator.next()).a(paramString, paramInt, paramnfv);
    }
    localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ngx)localIterator.next()).a(paramString, paramInt, paramnfv);
    }
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((ngy)localIterator.next()).a(paramString1, paramLong, paramInt1, paramInt2, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!this.jdField_a_of_type_Nfv.a()) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a().a(this.jdField_a_of_type_Nfv.b(), paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((ngw)localIterator.next()).a(paramString1, paramString2, paramString3);
    }
  }
  
  public void a(String paramString, nfv paramnfv)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ngx)localIterator.next()).a(paramString, paramnfv);
    }
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ngx)localIterator.next()).a(paramHashMap);
    }
  }
  
  public void a(nfv paramnfv)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ngx)localIterator.next()).a(paramnfv);
    }
  }
  
  public void a(nfv paramnfv, int paramInt)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((ngw)localIterator.next()).a(paramnfv, paramInt);
    }
    localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ngx)localIterator.next()).a(paramnfv, paramInt);
    }
  }
  
  public void a(nfv paramnfv, String paramString)
  {
    this.jdField_a_of_type_Nfs.a(paramnfv, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((ngy)localIterator.next()).a(paramnfv, paramString);
    }
  }
  
  public void a(nfv paramnfv, boolean paramBoolean)
  {
    this.jdField_a_of_type_Nfs.a(paramnfv, false);
    if (this.jdField_a_of_type_Nfs.a()) {
      QLog.d("avgame_logic.GameEngine", 1, "onGameOverPush NotPlayedYet return.");
    }
    for (;;)
    {
      if (paramnfv.c() == 4)
      {
        QLog.d("avgame_logic.GameEngine", 1, "onGameOverPush disable aec mode");
        ((noc)bjtp.a().a()).a(0);
      }
      ngk.a().c();
      AVGameNodeReportUtil.d();
      return;
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((ngy)localIterator.next()).a(paramnfv, paramBoolean);
      }
    }
  }
  
  public void a(ngw paramngw)
  {
    this.c.add(paramngw);
  }
  
  public void a(ngx paramngx)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramngx)) {
      this.jdField_a_of_type_JavaUtilList.add(paramngx);
    }
  }
  
  public void a(ngy paramngy)
  {
    if (!this.b.contains(paramngy)) {
      this.b.add(paramngy);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    ProcessMonitor.a().b("exitGameRoom");
    if (nnm.b() != null) {
      nnm.b().e();
    }
    a(paramInt);
    this.jdField_a_of_type_Nft.a();
    this.jdField_a_of_type_Nfs.a();
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController.a();
    long l = this.jdField_a_of_type_Nfv.a();
    if ((l != 0L) && (!paramBoolean)) {
      b(l, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
    }
    if (this.jdField_a_of_type_Nfv.e()) {
      a().l();
    }
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a().a(0, String.valueOf(l));
    this.jdField_a_of_type_Nfv.a();
    QLog.i("avgame_logic.GameEngine", 1, "exitGameRoom svrAlreadyExit = " + paramBoolean + " exitType =" + paramInt + " roomId:" + l, new Throwable("not crash, print stack"));
    if (l != 0L) {
      if ((paramInt == 2) || (paramInt == 4) || (paramInt == 5) || (paramInt == 6) || (paramInt == 7) || (paramInt == 9) || (paramInt == 10) || (paramInt == 11)) {
        if (7 != paramInt) {
          break label292;
        }
      }
    }
    label292:
    for (String str = "0X800B046";; str = "0X800B045")
    {
      bdla.b(null, "dc00898", "", "", str, str, 0, 0, "" + paramInt, "", "", "");
      AVGameNodeReportUtil.b(AVGameNodeReportUtil.a(paramInt));
      nfk.a();
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ngx)localIterator.next()).a(paramBoolean, paramInt, paramString);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ngx)localIterator.next()).a(paramBoolean, paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong);
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, SurvivalPkResultInfo paramSurvivalPkResultInfo)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ngx)localIterator.next()).a(paramBoolean1, paramInt, paramBoolean2, paramSurvivalPkResultInfo);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ngx)localIterator.next()).a(paramBoolean, paramLong, paramInt1, paramInt2, paramString);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ngx)localIterator.next()).a(paramBoolean, paramLong, paramInt, paramString);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((ngw)localIterator.next()).a(paramBoolean, paramString1, paramInt, paramString2);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Nfv.e(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
  }
  
  public boolean a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Nfv.a() == 0L) {
      return false;
    }
    this.jdField_a_of_type_Nfo.a(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getAccount(), this.jdField_a_of_type_Nfv.a(), paramInt, paramString, this.jdField_a_of_type_Nfv.j());
    return true;
  }
  
  public boolean a(int paramInt, String paramString, nfv paramnfv)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      ngx localngx = (ngx)localIterator.next();
      if ((bool) || (localngx.a(paramInt, paramString, paramnfv))) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    QLog.i("avgame_logic.GameEngine", 1, "onRoomSelfExit exitType:" + paramInt + " exitRoomTip:" + paramString + " handled:" + bool);
    if (!bool) {
      a(ngq.a().a(paramInt, paramString, paramnfv), paramInt);
    }
    return bool;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if (!this.jdField_a_of_type_Nfv.a()) {
      return false;
    }
    this.jdField_a_of_type_Nfo.a(paramString, paramInt, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Nfv.a(), this.jdField_a_of_type_Nfv.b());
    return true;
  }
  
  public boolean a(nga paramnga)
  {
    boolean bool = true;
    if (nff.b(paramnga)) {
      return false;
    }
    paramnga = this.jdField_a_of_type_Nfv.a();
    List localList = paramnga.getPlayers();
    int i = 0;
    if (i < localList.size()) {
      if ((localList.get(i) == null) || (((Player)localList.get(i)).status != 0)) {}
    }
    for (i = 0;; i = 1)
    {
      if ((a()) && (paramnga.getPlayers().size() > 1) && (i != 0)) {}
      for (;;)
      {
        return bool;
        i += 1;
        break;
        bool = false;
      }
    }
  }
  
  public void b()
  {
    n();
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameEngine", 4, "selectGame gameType = " + paramInt);
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController.a(a().getCurrentAccountUin(), this.jdField_a_of_type_Nfv.a(), paramInt);
  }
  
  public void b(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameEngine", 4, "leaveGameRoomByUser roomId = " + paramLong + " userUin =" + paramString);
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController.a(paramLong, paramString, a());
  }
  
  public void b(long paramLong, String paramString1, String paramString2)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((ngy)localIterator.next()).b(paramLong, paramString1, paramString2);
    }
  }
  
  public void b(String paramString, nfv paramnfv)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ngx)localIterator.next()).b(paramString, paramnfv);
    }
  }
  
  public void b(nfv paramnfv)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ngx)localIterator.next()).b(paramnfv);
    }
  }
  
  public void b(nfv paramnfv, int paramInt)
  {
    this.jdField_a_of_type_Nfs.a(paramnfv, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((ngy)localIterator.next()).b(paramnfv, paramInt);
    }
  }
  
  public void b(ngw paramngw)
  {
    this.c.remove(paramngw);
  }
  
  public void b(ngx paramngx)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramngx);
  }
  
  public void b(ngy paramngy)
  {
    this.b.remove(paramngy);
  }
  
  public void b(boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ngx)localIterator.next()).b(paramBoolean);
    }
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    ProcessMonitor.a().b("exitGameRoom");
    a(paramInt);
    this.jdField_a_of_type_Nft.a();
    this.jdField_a_of_type_Nfs.a();
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController.b();
    long l = this.jdField_a_of_type_Nfv.a();
    if ((l != 0L) && (!paramBoolean)) {
      b(l, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
    }
    if (nnm.b() != null) {
      nnm.b().e();
    }
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a().a(3, String.valueOf(l));
    this.jdField_a_of_type_Nfv.b();
    QLog.i("avgame_logic.GameEngine", 1, "exitGameRoomForPk svrAlreadyExit = " + paramBoolean + " exitType =" + paramInt + " roomId:" + l, new Throwable("not crash, print stack"));
  }
  
  public void b(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ngx)localIterator.next()).b(paramBoolean, paramInt, paramString, paramRoomInfo, paramArrayOfByte, paramLong);
    }
  }
  
  public boolean b()
  {
    if (!this.jdField_a_of_type_Nfv.a()) {
      return false;
    }
    this.jdField_a_of_type_Nfo.a(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Nfv.a(), this.jdField_a_of_type_Nfv.b());
    return true;
  }
  
  public boolean b(nga paramnga)
  {
    boolean bool = true;
    if (nff.b(paramnga)) {
      return false;
    }
    paramnga = this.jdField_a_of_type_Nfv.a();
    List localList = paramnga.getPlayers();
    int i = 0;
    if (i < localList.size()) {
      if ((localList.get(i) == null) || (((Player)localList.get(i)).status != 0)) {}
    }
    for (i = 0;; i = 1)
    {
      if ((paramnga.getPlayers().size() > 1) && (i != 0)) {}
      for (;;)
      {
        return bool;
        i += 1;
        break;
        bool = false;
      }
    }
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_Nfv.a()) {
      return;
    }
    if (QLog.isDebugVersion()) {
      QLog.i("avgame_logic.GameEngine_GameRC", 1, String.format("onclick share:playId[%s]", new Object[] { this.jdField_a_of_type_Nfv.b() }));
    }
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a().a(this.jdField_a_of_type_Nfv.b());
  }
  
  public void c(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameEngine", 4, "kickGameRoomUserByOwner roomId = " + paramLong + " ownerUin =" + paramString1 + " kickedUserUin =" + paramString2);
    }
    this.jdField_a_of_type_ComTencentAvgameGamelogicControllerRoomController.a(paramLong, paramString1, paramString2);
  }
  
  public void c(String paramString, nfv paramnfv)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ngx)localIterator.next()).c(paramString, paramnfv);
    }
  }
  
  public void c(nfv paramnfv)
  {
    this.jdField_a_of_type_Nfs.a(paramnfv, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((ngy)localIterator.next()).c(paramnfv);
    }
    if (paramnfv.c() == 4)
    {
      QLog.d("avgame_logic.GameEngine", 1, "onGameStartSuc enable aec mode");
      ((noc)bjtp.a().a()).a(1);
    }
    ngk.a().a(paramnfv.a(), "countdown");
    if (this.jdField_a_of_type_Nfv.a() != null) {
      ngk.a().d(this.jdField_a_of_type_Nfv.a().a());
    }
    AVGameNodeReportUtil.a(paramnfv.c(), paramnfv.a().players.size());
  }
  
  public void c(nfv paramnfv, int paramInt)
  {
    this.jdField_a_of_type_Nfs.a(paramnfv, true);
    int i = paramnfv.a();
    int j = paramnfv.b();
    Iterator localIterator;
    if ((i == 10) && (j == 0))
    {
      localIterator = this.b.iterator();
      if (localIterator.hasNext())
      {
        ngy localngy = (ngy)localIterator.next();
        if (paramInt != 1) {}
        for (boolean bool = true;; bool = false)
        {
          localngy.a(paramnfv, bool);
          break;
        }
      }
      ngk.a().c();
    }
    for (;;)
    {
      return;
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((ngx)localIterator.next()).c(paramnfv, paramInt);
      }
    }
  }
  
  public boolean c()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return lfm.a().a(this);
    }
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Nfv.d();
  }
  
  public void d(String paramString, nfv paramnfv)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((ngy)localIterator.next()).d(paramString, paramnfv);
    }
  }
  
  public void d(nfv paramnfv)
  {
    this.jdField_a_of_type_Nfs.a(paramnfv, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((ngy)localIterator.next()).d(paramnfv);
    }
  }
  
  public boolean d()
  {
    if (!this.jdField_a_of_type_Nfv.a()) {}
    while (this.jdField_a_of_type_Nfv.b() == null) {
      return false;
    }
    this.jdField_a_of_type_Nfo.a(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getAccount(), this.jdField_a_of_type_Nfv.b());
    return true;
  }
  
  public void e()
  {
    ((ngu)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(1)).a(a().a(), a().a().owner);
  }
  
  public void e(String paramString, nfv paramnfv)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((ngy)localIterator.next()).e(paramString, paramnfv);
    }
  }
  
  public void e(nfv paramnfv)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((ngy)localIterator.next()).e(paramnfv);
    }
    ThreadManager.getSubThreadHandler().post(new GameEngine.1(this, paramnfv));
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Nfv.a(a());
  }
  
  public void f()
  {
    if ((e()) && (a()))
    {
      ((ngu)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(1)).a(a().a(), a().i(), a().a().owner);
      return;
    }
    QLog.d("avgame_logic.GameEngine", 2, "stopGameMatch no need");
  }
  
  public void f(nfv paramnfv)
  {
    this.jdField_a_of_type_Nfs.a(paramnfv, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((ngy)localIterator.next()).f(paramnfv);
    }
    if (paramnfv.c() == 4)
    {
      QLog.d("avgame_logic.GameEngine", 1, "onGameStartPush enable aec mode");
      ((noc)bjtp.a().a()).a(1);
    }
    ngk.a().a(paramnfv.a(), "countdown");
    if (this.jdField_a_of_type_Nfv.a() != null) {
      ngk.a().d(this.jdField_a_of_type_Nfv.a().a());
    }
    AVGameNodeReportUtil.a(paramnfv.c(), paramnfv.a().players.size());
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Nfv.e();
  }
  
  public void g()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ngx)localIterator.next()).g();
    }
  }
  
  public void g(nfv paramnfv)
  {
    this.jdField_a_of_type_Nfs.a(paramnfv, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((ngy)localIterator.next()).g(paramnfv);
    }
    ngk.a().a(paramnfv.a(), "countdown");
    SecurityPolicyChecker.a().a(paramnfv, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
  }
  
  public void h()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ngx)localIterator.next()).h();
    }
  }
  
  public void h(nfv paramnfv)
  {
    this.jdField_a_of_type_Nfs.a(paramnfv, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((ngy)localIterator.next()).h(paramnfv);
    }
  }
  
  public void i()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ngx)localIterator.next()).i();
    }
  }
  
  public void i(nfv paramnfv)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((ngw)localIterator.next()).i(paramnfv);
    }
  }
  
  public void j()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((ngx)localIterator.next()).j();
    }
  }
  
  public void k()
  {
    boolean bool = true;
    int i = a().j();
    ngu localngu = (ngu)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(1);
    if (i == 0) {}
    for (;;)
    {
      localngu.a(bool, a().k(), i, a().o());
      return;
      bool = false;
    }
  }
  
  public void l()
  {
    int i = a().j();
    if (i > 0) {
      ((ngu)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(1)).a(i);
    }
  }
  
  public void m()
  {
    int i = a().j();
    if (i > 0) {
      ((ngu)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(1)).a(a().k(), i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nfc
 * JD-Core Version:    0.7.0.1
 */