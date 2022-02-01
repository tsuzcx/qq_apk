import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.GameEngine.1;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
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

public class myk
  implements naf, nag, nah, naj<mze>
{
  private AVGameAppInterface jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  private List<nag> jdField_a_of_type_JavaUtilList;
  protected mxw a;
  private myw jdField_a_of_type_Myw;
  private myx jdField_a_of_type_Myx;
  private myz jdField_a_of_type_Myz;
  private mzb jdField_a_of_type_Mzb;
  private mzc jdField_a_of_type_Mzc;
  private mze jdField_a_of_type_Mze;
  private List<nah> b;
  private List<naf> c;
  
  private myk()
  {
    this.jdField_a_of_type_Mxw = new myl(this);
  }
  
  public static myk a()
  {
    return mym.a;
  }
  
  public static boolean a(mze parammze)
  {
    return a().a().getAccount().equals(parammze.a().a.uin);
  }
  
  private void b(AVGameAppInterface paramAVGameAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    this.jdField_a_of_type_Mze = new mze();
    this.jdField_a_of_type_Mzc = new mzc(paramAVGameAppInterface);
    this.jdField_a_of_type_Myz = new myz(paramAVGameAppInterface, this, this.jdField_a_of_type_Mzc, this);
    this.jdField_a_of_type_Myw = new myw(paramAVGameAppInterface, this, this, this.jdField_a_of_type_Mzc, this);
    this.jdField_a_of_type_Myx = new myx(paramAVGameAppInterface, this.jdField_a_of_type_Mzc, this, this);
    this.jdField_a_of_type_Mzb = new mzb(paramAVGameAppInterface, this.jdField_a_of_type_Myx, this.jdField_a_of_type_Mzc, this, this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList(4);
    this.b = new ArrayList(4);
    this.c = new ArrayList(1);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Myx.a();
    this.jdField_a_of_type_Myz.b();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.b.clear();
    this.c.clear();
    this.jdField_a_of_type_Mzc.a();
    this.jdField_a_of_type_Mzb.a();
    nfm.b().b(this.jdField_a_of_type_Mxw);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Mze.a().getPlayers().size();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Mze.d();
  }
  
  public AVGameAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  }
  
  public mze a()
  {
    return this.jdField_a_of_type_Mze;
  }
  
  public void a()
  {
    nfm.b().a(this.jdField_a_of_type_Mxw);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Myx.a(paramInt);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, mze parammze)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nag)localIterator.next()).a(paramInt, paramString1, paramString2, parammze);
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameEngine", 4, "getGameRoomList roomId = " + paramLong);
    }
    this.jdField_a_of_type_Myz.b(paramLong);
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((nah)localIterator.next()).a(paramLong, paramInt, paramString1, paramString2);
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong3)
  {
    QLog.d("avgame_logic.GameEngine", 1, "getGameShareLink  roomId: " + paramLong1 + " shareUin: " + paramLong2 + " shareName: " + paramString1 + " shareType: " + paramInt1 + " gameId: " + paramString2 + " gameType: " + paramInt2 + " pbMark" + paramLong3);
    this.jdField_a_of_type_Myz.a(paramLong1, paramLong2, paramString1, paramInt1, paramString2, paramInt2, paramLong3);
  }
  
  public void a(long paramLong, String paramString)
  {
    this.jdField_a_of_type_Myx.a(paramLong, paramString);
  }
  
  public void a(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameEngine", 4, "changeUserStatus roomId = " + paramLong + " userUin =" + paramString + " userStatus =" + paramInt1 + " from = " + paramInt2);
    }
    this.jdField_a_of_type_Myz.b(paramLong, paramString, paramInt1, paramInt2);
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((nah)localIterator.next()).a(paramLong, paramString1, paramString2);
    }
  }
  
  public void a(long paramLong, String paramString1, boolean paramBoolean, String paramString2, int paramInt)
  {
    if (paramBoolean) {}
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nag)localIterator.next()).a(paramLong, paramString1, paramBoolean, paramString2, paramInt);
    }
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameEngine", 4, "getGameRoomInfo roomId = " + paramLong + " uin = " + paramString + " fromSync=" + paramBoolean2 + " fromEnter=" + paramBoolean2);
    }
    this.jdField_a_of_type_Myz.a(paramLong, paramString, paramBoolean1, paramBoolean2);
  }
  
  public void a(AVGameAppInterface paramAVGameAppInterface)
  {
    b(paramAVGameAppInterface);
  }
  
  public void a(RoomInfo paramRoomInfo)
  {
    this.jdField_a_of_type_Myz.a(paramRoomInfo, true);
  }
  
  public void a(String paramString)
  {
    if (!this.jdField_a_of_type_Mze.a()) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a().b(paramString);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((naf)localIterator.next()).a(paramString, paramInt1, paramInt2);
    }
    localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nag)localIterator.next()).a(paramString, paramInt1, paramInt2);
    }
  }
  
  public void a(String paramString, int paramInt, mze parammze)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((naf)localIterator.next()).a(paramString, paramInt, parammze);
    }
    localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nag)localIterator.next()).a(paramString, paramInt, parammze);
    }
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((nah)localIterator.next()).a(paramString1, paramLong, paramInt1, paramInt2, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!this.jdField_a_of_type_Mze.a()) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a().a(this.jdField_a_of_type_Mze.b(), paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((naf)localIterator.next()).a(paramString1, paramString2, paramString3);
    }
  }
  
  public void a(String paramString, mze parammze)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nag)localIterator.next()).a(paramString, parammze);
    }
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nag)localIterator.next()).a(paramHashMap);
    }
  }
  
  public void a(mze parammze)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nag)localIterator.next()).a(parammze);
    }
  }
  
  public void a(mze parammze, int paramInt)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((naf)localIterator.next()).a(parammze, paramInt);
    }
    localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nag)localIterator.next()).a(parammze, paramInt);
    }
  }
  
  public void a(mze parammze, String paramString)
  {
    this.jdField_a_of_type_Mzb.a(parammze, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((nah)localIterator.next()).a(parammze, paramString);
    }
  }
  
  public void a(mze parammze, boolean paramBoolean)
  {
    this.jdField_a_of_type_Mzb.a(parammze, false);
    if (this.jdField_a_of_type_Mzb.a()) {
      QLog.d("avgame_logic.GameEngine", 1, "onGameOverPush NotPlayedYet return.");
    }
    for (;;)
    {
      if (parammze.c() == 4)
      {
        QLog.d("avgame_logic.GameEngine", 1, "onGameOverPush disable aec mode");
        ((ngc)bkdd.a().a()).a(0);
      }
      mzt.a().c();
      AVGameNodeReportUtil.d();
      return;
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((nah)localIterator.next()).a(parammze, paramBoolean);
      }
    }
  }
  
  public void a(naf paramnaf)
  {
    this.c.add(paramnaf);
  }
  
  public void a(nag paramnag)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramnag)) {
      this.jdField_a_of_type_JavaUtilList.add(paramnag);
    }
  }
  
  public void a(nah paramnah)
  {
    if (!this.b.contains(paramnah)) {
      this.b.add(paramnah);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    ProcessMonitor.a().b("exitGameRoom");
    if (nfm.b() != null) {
      nfm.b().e();
    }
    a(paramInt);
    this.jdField_a_of_type_Mzc.a();
    this.jdField_a_of_type_Mzb.a();
    this.jdField_a_of_type_Myz.a();
    long l = this.jdField_a_of_type_Mze.a();
    if ((l != 0L) && (!paramBoolean)) {
      b(l, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
    }
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a().a(0, String.valueOf(l));
    this.jdField_a_of_type_Mze.a();
    QLog.i("avgame_logic.GameEngine", 1, "exitGameRoom svrAlreadyExit = " + paramBoolean + " exitType =" + paramInt + " roomId:" + l, new Throwable("not crash, print stack"));
    if (l != 0L) {
      if ((paramInt == 2) || (paramInt == 4) || (paramInt == 5) || (paramInt == 6) || (paramInt == 7) || (paramInt == 9) || (paramInt == 10) || (paramInt == 11)) {
        if (7 != paramInt) {
          break label276;
        }
      }
    }
    label276:
    for (String str = "0X800B046";; str = "0X800B045")
    {
      bdll.b(null, "dc00898", "", "", str, str, 0, 0, "" + paramInt, "", "", "");
      AVGameNodeReportUtil.b(AVGameNodeReportUtil.a(paramInt));
      mys.a();
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((naf)localIterator.next()).a(paramBoolean, paramString1, paramInt, paramString2);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Mze.e(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
  }
  
  public boolean a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Mze.a() == 0L) {
      return false;
    }
    this.jdField_a_of_type_Myw.a(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getAccount(), this.jdField_a_of_type_Mze.a(), paramInt, paramString);
    return true;
  }
  
  public boolean a(int paramInt, String paramString, mze parammze)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      nag localnag = (nag)localIterator.next();
      if ((bool) || (localnag.a(paramInt, paramString, parammze))) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    QLog.i("avgame_logic.GameEngine", 1, "onRoomSelfExit exitType:" + paramInt + " exitRoomTip:" + paramString + " handled:" + bool);
    if (!bool) {
      a(mzz.a().a(paramInt, paramString, parammze), paramInt);
    }
    return bool;
  }
  
  public boolean a(mzj parammzj)
  {
    boolean bool = true;
    if (myn.b(parammzj)) {
      return false;
    }
    parammzj = this.jdField_a_of_type_Mze.a();
    List localList = parammzj.getPlayers();
    int i = 0;
    if (i < localList.size()) {
      if ((localList.get(i) == null) || (((Player)localList.get(i)).status != 0)) {}
    }
    for (i = 0;; i = 1)
    {
      if ((a()) && (parammzj.getPlayers().size() > 1) && (i != 0)) {}
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
    e();
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameEngine", 4, "selectGame gameType = " + paramInt);
    }
    this.jdField_a_of_type_Myz.a(a().getCurrentAccountUin(), this.jdField_a_of_type_Mze.a(), paramInt);
  }
  
  public void b(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameEngine", 4, "leaveGameRoomByUser roomId = " + paramLong + " userUin =" + paramString);
    }
    this.jdField_a_of_type_Myz.a(paramLong, paramString, a());
  }
  
  public void b(long paramLong, String paramString1, String paramString2)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((nah)localIterator.next()).b(paramLong, paramString1, paramString2);
    }
  }
  
  public void b(String paramString, mze parammze)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nag)localIterator.next()).b(paramString, parammze);
    }
  }
  
  public void b(mze parammze)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nag)localIterator.next()).b(parammze);
    }
  }
  
  public void b(mze parammze, int paramInt)
  {
    this.jdField_a_of_type_Mzb.a(parammze, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((nah)localIterator.next()).b(parammze, paramInt);
    }
  }
  
  public void b(naf paramnaf)
  {
    this.c.remove(paramnaf);
  }
  
  public void b(nag paramnag)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramnag);
  }
  
  public void b(nah paramnah)
  {
    this.b.remove(paramnah);
  }
  
  public boolean b()
  {
    if (!this.jdField_a_of_type_Mze.a()) {
      return false;
    }
    this.jdField_a_of_type_Myw.a(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Mze.a(), this.jdField_a_of_type_Mze.b());
    return true;
  }
  
  public boolean b(mzj parammzj)
  {
    boolean bool = true;
    if (myn.b(parammzj)) {
      return false;
    }
    parammzj = this.jdField_a_of_type_Mze.a();
    List localList = parammzj.getPlayers();
    int i = 0;
    if (i < localList.size()) {
      if ((localList.get(i) == null) || (((Player)localList.get(i)).status != 0)) {}
    }
    for (i = 0;; i = 1)
    {
      if ((parammzj.getPlayers().size() > 1) && (i != 0)) {}
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
    if (!this.jdField_a_of_type_Mze.a()) {
      return;
    }
    if (QLog.isDebugVersion()) {
      QLog.i("avgame_logic.GameEngine_GameRC", 1, String.format("onclick share:playId[%s]", new Object[] { this.jdField_a_of_type_Mze.b() }));
    }
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a().a(this.jdField_a_of_type_Mze.b());
  }
  
  public void c(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameEngine", 4, "kickGameRoomUserByOwner roomId = " + paramLong + " ownerUin =" + paramString1 + " kickedUserUin =" + paramString2);
    }
    this.jdField_a_of_type_Myz.a(paramLong, paramString1, paramString2);
  }
  
  public void c(String paramString, mze parammze)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((nah)localIterator.next()).c(paramString, parammze);
    }
  }
  
  public void c(mze parammze)
  {
    this.jdField_a_of_type_Mzb.a(parammze, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((nah)localIterator.next()).c(parammze);
    }
    if (parammze.c() == 4)
    {
      QLog.d("avgame_logic.GameEngine", 1, "onGameStartSuc enable aec mode");
      ((ngc)bkdd.a().a()).a(1);
    }
    mzt.a().a(parammze.a(), "countdown");
    if (this.jdField_a_of_type_Mze.a() != null) {
      mzt.a().d(this.jdField_a_of_type_Mze.a().a());
    }
    AVGameNodeReportUtil.a(parammze.c(), parammze.a().players.size());
  }
  
  public void c(mze parammze, int paramInt)
  {
    this.jdField_a_of_type_Mzb.a(parammze, true);
    int i = parammze.a();
    int j = parammze.b();
    Iterator localIterator;
    if ((i == 10) && (j == 0))
    {
      localIterator = this.b.iterator();
      if (localIterator.hasNext())
      {
        nah localnah = (nah)localIterator.next();
        if (paramInt != 1) {}
        for (boolean bool = true;; bool = false)
        {
          localnah.a(parammze, bool);
          break;
        }
      }
      mzt.a().c();
    }
    for (;;)
    {
      return;
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((nag)localIterator.next()).c(parammze, paramInt);
      }
    }
  }
  
  public boolean c()
  {
    if (!this.jdField_a_of_type_Mze.a()) {}
    while (this.jdField_a_of_type_Mze.b() == null) {
      return false;
    }
    this.jdField_a_of_type_Myw.a(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getAccount(), this.jdField_a_of_type_Mze.b());
    return true;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Mze.b();
  }
  
  public void d(String paramString, mze parammze)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((nah)localIterator.next()).d(paramString, parammze);
    }
  }
  
  public void d(mze parammze)
  {
    this.jdField_a_of_type_Mzb.a(parammze, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((nah)localIterator.next()).d(parammze);
    }
  }
  
  public void e(mze parammze)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((nah)localIterator.next()).e(parammze);
    }
    ThreadManager.getSubThreadHandler().post(new GameEngine.1(this, parammze));
  }
  
  public void f(mze parammze)
  {
    this.jdField_a_of_type_Mzb.a(parammze, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((nah)localIterator.next()).f(parammze);
    }
    if (parammze.c() == 4)
    {
      QLog.d("avgame_logic.GameEngine", 1, "onGameStartPush enable aec mode");
      ((ngc)bkdd.a().a()).a(1);
    }
    mzt.a().a(parammze.a(), "countdown");
    if (this.jdField_a_of_type_Mze.a() != null) {
      mzt.a().d(this.jdField_a_of_type_Mze.a().a());
    }
    AVGameNodeReportUtil.a(parammze.c(), parammze.a().players.size());
  }
  
  public void g()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nag)localIterator.next()).g();
    }
  }
  
  public void g(mze parammze)
  {
    this.jdField_a_of_type_Mzb.a(parammze, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((nah)localIterator.next()).g(parammze);
    }
    mzt.a().a(parammze.a(), "countdown");
    SecurityPolicyChecker.a().a(parammze, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
  }
  
  public void h()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nag)localIterator.next()).h();
    }
  }
  
  public void h(mze parammze)
  {
    this.jdField_a_of_type_Mzb.a(parammze, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((nah)localIterator.next()).h(parammze);
    }
  }
  
  public void i()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nag)localIterator.next()).i();
    }
  }
  
  public void i(mze parammze)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((naf)localIterator.next()).i(parammze);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     myk
 * JD-Core Version:    0.7.0.1
 */