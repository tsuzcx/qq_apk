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

public class mxl
  implements mzc, mzd, mze, mzg<myc>
{
  private AVGameAppInterface jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  private List<mzd> jdField_a_of_type_JavaUtilList;
  protected mwx a;
  private mxu jdField_a_of_type_Mxu;
  private mxv jdField_a_of_type_Mxv;
  private mxx jdField_a_of_type_Mxx;
  private mxz jdField_a_of_type_Mxz;
  private mya jdField_a_of_type_Mya;
  private myc jdField_a_of_type_Myc;
  private List<mze> b;
  private List<mzc> c;
  
  private mxl()
  {
    this.jdField_a_of_type_Mwx = new mxm(this);
  }
  
  public static mxl a()
  {
    return mxn.a;
  }
  
  public static boolean a(myc parammyc)
  {
    return a().a().getAccount().equals(parammyc.a().a.uin);
  }
  
  private void b(AVGameAppInterface paramAVGameAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    this.jdField_a_of_type_Myc = new myc();
    this.jdField_a_of_type_Mya = new mya(paramAVGameAppInterface);
    this.jdField_a_of_type_Mxx = new mxx(paramAVGameAppInterface, this, this.jdField_a_of_type_Mya, this);
    this.jdField_a_of_type_Mxu = new mxu(paramAVGameAppInterface, this, this, this.jdField_a_of_type_Mya, this);
    this.jdField_a_of_type_Mxv = new mxv(paramAVGameAppInterface, this.jdField_a_of_type_Mya, this, this);
    this.jdField_a_of_type_Mxz = new mxz(paramAVGameAppInterface, this.jdField_a_of_type_Mxv, this.jdField_a_of_type_Mya, this, this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList(4);
    this.b = new ArrayList(4);
    this.c = new ArrayList(1);
  }
  
  private void e()
  {
    this.jdField_a_of_type_Mxv.a();
    this.jdField_a_of_type_Mxx.b();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.b.clear();
    this.c.clear();
    this.jdField_a_of_type_Mya.a();
    this.jdField_a_of_type_Mxz.a();
    ndt.b().b(this.jdField_a_of_type_Mwx);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Myc.a().getPlayers().size();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Myc.d();
  }
  
  public AVGameAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  }
  
  public myc a()
  {
    return this.jdField_a_of_type_Myc;
  }
  
  public void a()
  {
    ndt.b().a(this.jdField_a_of_type_Mwx);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Mxv.a(paramInt);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, myc parammyc)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((mzd)localIterator.next()).a(paramInt, paramString1, paramString2, parammyc);
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameEngine", 4, "getGameRoomList roomId = " + paramLong);
    }
    this.jdField_a_of_type_Mxx.b(paramLong);
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((mze)localIterator.next()).a(paramLong, paramInt, paramString1, paramString2);
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong3)
  {
    QLog.d("avgame_logic.GameEngine", 1, "getGameShareLink  roomId: " + paramLong1 + " shareUin: " + paramLong2 + " shareName: " + paramString1 + " shareType: " + paramInt1 + " gameId: " + paramString2 + " gameType: " + paramInt2 + " pbMark" + paramLong3);
    this.jdField_a_of_type_Mxx.a(paramLong1, paramLong2, paramString1, paramInt1, paramString2, paramInt2, paramLong3);
  }
  
  public void a(long paramLong, String paramString)
  {
    this.jdField_a_of_type_Mxv.a(paramLong, paramString);
  }
  
  public void a(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameEngine", 4, "changeUserStatus roomId = " + paramLong + " userUin =" + paramString + " userStatus =" + paramInt1 + " from = " + paramInt2);
    }
    this.jdField_a_of_type_Mxx.b(paramLong, paramString, paramInt1, paramInt2);
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((mze)localIterator.next()).a(paramLong, paramString1, paramString2);
    }
  }
  
  public void a(long paramLong, String paramString1, boolean paramBoolean, String paramString2, int paramInt)
  {
    if (paramBoolean) {}
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((mzd)localIterator.next()).a(paramLong, paramString1, paramBoolean, paramString2, paramInt);
    }
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameEngine", 4, "getGameRoomInfo roomId = " + paramLong + " uin = " + paramString + " fromSync=" + paramBoolean2 + " fromEnter=" + paramBoolean2);
    }
    this.jdField_a_of_type_Mxx.a(paramLong, paramString, paramBoolean1, paramBoolean2);
  }
  
  public void a(AVGameAppInterface paramAVGameAppInterface)
  {
    b(paramAVGameAppInterface);
  }
  
  public void a(RoomInfo paramRoomInfo)
  {
    this.jdField_a_of_type_Mxx.a(paramRoomInfo, true);
  }
  
  public void a(String paramString)
  {
    if (!this.jdField_a_of_type_Myc.a()) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a().b(paramString);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((mzc)localIterator.next()).a(paramString, paramInt1, paramInt2);
    }
    localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((mzd)localIterator.next()).a(paramString, paramInt1, paramInt2);
    }
  }
  
  public void a(String paramString, int paramInt, myc parammyc)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((mzc)localIterator.next()).a(paramString, paramInt, parammyc);
    }
    localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((mzd)localIterator.next()).a(paramString, paramInt, parammyc);
    }
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((mze)localIterator.next()).a(paramString1, paramLong, paramInt1, paramInt2, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!this.jdField_a_of_type_Myc.a()) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a().a(this.jdField_a_of_type_Myc.b(), paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((mzc)localIterator.next()).a(paramString1, paramString2, paramString3);
    }
  }
  
  public void a(String paramString, myc parammyc)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((mzd)localIterator.next()).a(paramString, parammyc);
    }
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((mzd)localIterator.next()).a(paramHashMap);
    }
  }
  
  public void a(myc parammyc)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((mzd)localIterator.next()).a(parammyc);
    }
  }
  
  public void a(myc parammyc, int paramInt)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((mzc)localIterator.next()).a(parammyc, paramInt);
    }
    localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((mzd)localIterator.next()).a(parammyc, paramInt);
    }
  }
  
  public void a(myc parammyc, String paramString)
  {
    this.jdField_a_of_type_Mxz.a(parammyc, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((mze)localIterator.next()).a(parammyc, paramString);
    }
  }
  
  public void a(myc parammyc, boolean paramBoolean)
  {
    this.jdField_a_of_type_Mxz.a(parammyc, false);
    if (this.jdField_a_of_type_Mxz.a()) {
      QLog.d("avgame_logic.GameEngine", 1, "onGameOverPush NotPlayedYet return.");
    }
    for (;;)
    {
      if (parammyc.c() == 4)
      {
        QLog.d("avgame_logic.GameEngine", 1, "onGameOverPush disable aec mode");
        ((nej)bjce.a().a()).a(0);
      }
      myq.a().c();
      AVGameNodeReportUtil.d();
      return;
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((mze)localIterator.next()).a(parammyc, paramBoolean);
      }
    }
  }
  
  public void a(mzc parammzc)
  {
    this.c.add(parammzc);
  }
  
  public void a(mzd parammzd)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(parammzd)) {
      this.jdField_a_of_type_JavaUtilList.add(parammzd);
    }
  }
  
  public void a(mze parammze)
  {
    if (!this.b.contains(parammze)) {
      this.b.add(parammze);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    ProcessMonitor.a().b("exitGameRoom");
    if (ndt.b() != null) {
      ndt.b().e();
    }
    a(paramInt);
    this.jdField_a_of_type_Mya.a();
    this.jdField_a_of_type_Mxz.a();
    this.jdField_a_of_type_Mxx.a();
    long l = this.jdField_a_of_type_Myc.a();
    if ((l != 0L) && (!paramBoolean)) {
      b(l, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
    }
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a().a(0, String.valueOf(l));
    this.jdField_a_of_type_Myc.a();
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
      bcst.b(null, "dc00898", "", "", str, str, 0, 0, "" + paramInt, "", "", "");
      AVGameNodeReportUtil.b(AVGameNodeReportUtil.a(paramInt));
      mxt.a();
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((mzc)localIterator.next()).a(paramBoolean, paramString1, paramInt, paramString2);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Myc.e(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
  }
  
  public boolean a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Myc.a() == 0L) {
      return false;
    }
    this.jdField_a_of_type_Mxu.a(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getAccount(), this.jdField_a_of_type_Myc.a(), paramInt, paramString);
    return true;
  }
  
  public boolean a(int paramInt, String paramString, myc parammyc)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      mzd localmzd = (mzd)localIterator.next();
      if ((bool) || (localmzd.a(paramInt, paramString, parammyc))) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    QLog.i("avgame_logic.GameEngine", 1, "onRoomSelfExit exitType:" + paramInt + " exitRoomTip:" + paramString + " handled:" + bool);
    if (!bool) {
      a(myw.a().a(paramInt, paramString, parammyc), paramInt);
    }
    return bool;
  }
  
  public boolean a(myg parammyg)
  {
    boolean bool = true;
    if (mxo.b(parammyg)) {
      return false;
    }
    parammyg = this.jdField_a_of_type_Myc.a();
    List localList = parammyg.getPlayers();
    int i = 0;
    if (i < localList.size()) {
      if ((localList.get(i) == null) || (((Player)localList.get(i)).status != 0)) {}
    }
    for (i = 0;; i = 1)
    {
      if ((a()) && (parammyg.getPlayers().size() > 1) && (i != 0)) {}
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
    this.jdField_a_of_type_Mxx.a(a().getCurrentAccountUin(), this.jdField_a_of_type_Myc.a(), paramInt);
  }
  
  public void b(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameEngine", 4, "leaveGameRoomByUser roomId = " + paramLong + " userUin =" + paramString);
    }
    this.jdField_a_of_type_Mxx.a(paramLong, paramString, a());
  }
  
  public void b(long paramLong, String paramString1, String paramString2)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((mze)localIterator.next()).b(paramLong, paramString1, paramString2);
    }
  }
  
  public void b(String paramString, myc parammyc)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((mzd)localIterator.next()).b(paramString, parammyc);
    }
  }
  
  public void b(myc parammyc)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((mzd)localIterator.next()).b(parammyc);
    }
  }
  
  public void b(myc parammyc, int paramInt)
  {
    this.jdField_a_of_type_Mxz.a(parammyc, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((mze)localIterator.next()).b(parammyc, paramInt);
    }
  }
  
  public void b(mzc parammzc)
  {
    this.c.remove(parammzc);
  }
  
  public void b(mzd parammzd)
  {
    this.jdField_a_of_type_JavaUtilList.remove(parammzd);
  }
  
  public void b(mze parammze)
  {
    this.b.remove(parammze);
  }
  
  public boolean b()
  {
    if (!this.jdField_a_of_type_Myc.a()) {
      return false;
    }
    this.jdField_a_of_type_Mxu.a(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Myc.a(), this.jdField_a_of_type_Myc.b());
    return true;
  }
  
  public boolean b(myg parammyg)
  {
    boolean bool = true;
    if (mxo.b(parammyg)) {
      return false;
    }
    parammyg = this.jdField_a_of_type_Myc.a();
    List localList = parammyg.getPlayers();
    int i = 0;
    if (i < localList.size()) {
      if ((localList.get(i) == null) || (((Player)localList.get(i)).status != 0)) {}
    }
    for (i = 0;; i = 1)
    {
      if ((parammyg.getPlayers().size() > 1) && (i != 0)) {}
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
    if (!this.jdField_a_of_type_Myc.a()) {
      return;
    }
    if (QLog.isDebugVersion()) {
      QLog.i("avgame_logic.GameEngine_GameRC", 1, String.format("onclick share:playId[%s]", new Object[] { this.jdField_a_of_type_Myc.b() }));
    }
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a().a(this.jdField_a_of_type_Myc.b());
  }
  
  public void c(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameEngine", 4, "kickGameRoomUserByOwner roomId = " + paramLong + " ownerUin =" + paramString1 + " kickedUserUin =" + paramString2);
    }
    this.jdField_a_of_type_Mxx.a(paramLong, paramString1, paramString2);
  }
  
  public void c(String paramString, myc parammyc)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((mze)localIterator.next()).c(paramString, parammyc);
    }
  }
  
  public void c(myc parammyc)
  {
    this.jdField_a_of_type_Mxz.a(parammyc, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((mze)localIterator.next()).c(parammyc);
    }
    if (parammyc.c() == 4)
    {
      QLog.d("avgame_logic.GameEngine", 1, "onGameStartSuc enable aec mode");
      ((nej)bjce.a().a()).a(1);
    }
    myq.a().a(parammyc.a(), "countdown");
    if (this.jdField_a_of_type_Myc.a() != null) {
      myq.a().d(this.jdField_a_of_type_Myc.a().a());
    }
    AVGameNodeReportUtil.a(parammyc.c(), parammyc.a().players.size());
  }
  
  public void c(myc parammyc, int paramInt)
  {
    this.jdField_a_of_type_Mxz.a(parammyc, true);
    int i = parammyc.a();
    int j = parammyc.b();
    Iterator localIterator;
    if ((i == 10) && (j == 0))
    {
      localIterator = this.b.iterator();
      if (localIterator.hasNext())
      {
        mze localmze = (mze)localIterator.next();
        if (paramInt != 1) {}
        for (boolean bool = true;; bool = false)
        {
          localmze.a(parammyc, bool);
          break;
        }
      }
      myq.a().c();
    }
    for (;;)
    {
      return;
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((mzd)localIterator.next()).c(parammyc, paramInt);
      }
    }
  }
  
  public boolean c()
  {
    if (!this.jdField_a_of_type_Myc.a()) {}
    while (this.jdField_a_of_type_Myc.b() == null) {
      return false;
    }
    this.jdField_a_of_type_Mxu.a(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getAccount(), this.jdField_a_of_type_Myc.b());
    return true;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Myc.b();
  }
  
  public void d(String paramString, myc parammyc)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((mze)localIterator.next()).d(paramString, parammyc);
    }
  }
  
  public void d(myc parammyc)
  {
    this.jdField_a_of_type_Mxz.a(parammyc, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((mze)localIterator.next()).d(parammyc);
    }
  }
  
  public void e(myc parammyc)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((mze)localIterator.next()).e(parammyc);
    }
    ThreadManager.getSubThreadHandler().post(new GameEngine.1(this, parammyc));
  }
  
  public void f(myc parammyc)
  {
    this.jdField_a_of_type_Mxz.a(parammyc, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((mze)localIterator.next()).f(parammyc);
    }
    if (parammyc.c() == 4)
    {
      QLog.d("avgame_logic.GameEngine", 1, "onGameStartPush enable aec mode");
      ((nej)bjce.a().a()).a(1);
    }
    myq.a().a(parammyc.a(), "countdown");
    if (this.jdField_a_of_type_Myc.a() != null) {
      myq.a().d(this.jdField_a_of_type_Myc.a().a());
    }
    AVGameNodeReportUtil.a(parammyc.c(), parammyc.a().players.size());
  }
  
  public void g()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((mzd)localIterator.next()).g();
    }
  }
  
  public void g(myc parammyc)
  {
    this.jdField_a_of_type_Mxz.a(parammyc, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((mze)localIterator.next()).g(parammyc);
    }
    myq.a().a(parammyc.a(), "countdown");
    SecurityPolicyChecker.a().a(parammyc, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
  }
  
  public void h()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((mzd)localIterator.next()).h();
    }
  }
  
  public void h(myc parammyc)
  {
    this.jdField_a_of_type_Mxz.a(parammyc, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((mze)localIterator.next()).h(parammyc);
    }
  }
  
  public void i()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((mzd)localIterator.next()).i();
    }
  }
  
  public void i(myc parammyc)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((mzc)localIterator.next()).i(parammyc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mxl
 * JD-Core Version:    0.7.0.1
 */