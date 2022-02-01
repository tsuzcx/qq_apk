import android.os.Build.VERSION;
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

public class mzl
  implements mxl, nbg, nbh, nbi, nbk<naf>
{
  private AVGameAppInterface jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  private List<nbh> jdField_a_of_type_JavaUtilList;
  protected myh a;
  private mzx jdField_a_of_type_Mzx;
  private mzy jdField_a_of_type_Mzy;
  private naa jdField_a_of_type_Naa;
  private nac jdField_a_of_type_Nac;
  private nad jdField_a_of_type_Nad;
  private naf jdField_a_of_type_Naf;
  private List<nbi> b;
  private List<nbg> c;
  
  private mzl()
  {
    this.jdField_a_of_type_Myh = new mzm(this);
  }
  
  public static mzl a()
  {
    return mzn.a;
  }
  
  public static boolean a(naf paramnaf)
  {
    return a().a().getAccount().equals(paramnaf.a().a.uin);
  }
  
  private void b(AVGameAppInterface paramAVGameAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface = paramAVGameAppInterface;
    this.jdField_a_of_type_Naf = new naf();
    this.jdField_a_of_type_Nad = new nad(paramAVGameAppInterface);
    this.jdField_a_of_type_Naa = new naa(paramAVGameAppInterface, this, this.jdField_a_of_type_Nad, this);
    this.jdField_a_of_type_Mzx = new mzx(paramAVGameAppInterface, this, this, this.jdField_a_of_type_Nad, this);
    this.jdField_a_of_type_Mzy = new mzy(paramAVGameAppInterface, this.jdField_a_of_type_Nad, this, this);
    this.jdField_a_of_type_Nac = new nac(paramAVGameAppInterface, this.jdField_a_of_type_Mzy, this.jdField_a_of_type_Nad, this, this);
    this.jdField_a_of_type_JavaUtilList = new ArrayList(4);
    this.b = new ArrayList(4);
    this.c = new ArrayList(1);
  }
  
  private void j()
  {
    this.jdField_a_of_type_Mzy.a();
    this.jdField_a_of_type_Naa.b();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.b.clear();
    this.c.clear();
    this.jdField_a_of_type_Nad.a();
    this.jdField_a_of_type_Nac.a();
    ngu.b().b(this.jdField_a_of_type_Myh);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Naf.a().getPlayers().size();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Naf.d();
  }
  
  public AVGameAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface;
  }
  
  public naf a()
  {
    return this.jdField_a_of_type_Naf;
  }
  
  public void a()
  {
    ngu.b().a(this.jdField_a_of_type_Myh);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Mzy.a(paramInt);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, naf paramnaf)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nbh)localIterator.next()).a(paramInt, paramString1, paramString2, paramnaf);
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameEngine", 4, "getGameRoomList roomId = " + paramLong);
    }
    this.jdField_a_of_type_Naa.b(paramLong);
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((nbi)localIterator.next()).a(paramLong, paramInt, paramString1, paramString2);
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong3)
  {
    QLog.d("avgame_logic.GameEngine", 1, "getGameShareLink  roomId: " + paramLong1 + " shareUin: " + paramLong2 + " shareName: " + paramString1 + " shareType: " + paramInt1 + " gameId: " + paramString2 + " gameType: " + paramInt2 + " pbMark" + paramLong3);
    this.jdField_a_of_type_Naa.a(paramLong1, paramLong2, paramString1, paramInt1, paramString2, paramInt2, paramLong3);
  }
  
  public void a(long paramLong, String paramString)
  {
    this.jdField_a_of_type_Mzy.a(paramLong, paramString);
  }
  
  public void a(long paramLong, String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameEngine", 4, "changeUserStatus roomId = " + paramLong + " userUin =" + paramString + " userStatus =" + paramInt1 + " from = " + paramInt2);
    }
    this.jdField_a_of_type_Naa.b(paramLong, paramString, paramInt1, paramInt2);
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((nbi)localIterator.next()).a(paramLong, paramString1, paramString2);
    }
  }
  
  public void a(long paramLong, String paramString1, boolean paramBoolean, String paramString2, int paramInt)
  {
    if (paramBoolean) {}
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nbh)localIterator.next()).a(paramLong, paramString1, paramBoolean, paramString2, paramInt);
    }
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameEngine", 4, "getGameRoomInfo roomId = " + paramLong + " uin = " + paramString + " fromSync=" + paramBoolean2 + " fromEnter=" + paramBoolean2);
    }
    this.jdField_a_of_type_Naa.a(paramLong, paramString, paramBoolean1, paramBoolean2);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nbh)localIterator.next()).a(paramLong, paramBoolean);
    }
  }
  
  public void a(AVGameAppInterface paramAVGameAppInterface)
  {
    b(paramAVGameAppInterface);
  }
  
  public void a(RoomInfo paramRoomInfo)
  {
    this.jdField_a_of_type_Naa.a(paramRoomInfo, true);
  }
  
  public void a(String paramString)
  {
    if (!this.jdField_a_of_type_Naf.a()) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a().b(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    a(paramString, paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((nbg)localIterator.next()).a(paramString, paramInt1, paramInt2);
    }
    localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nbh)localIterator.next()).a(paramString, paramInt1, paramInt2);
    }
  }
  
  public void a(String paramString, int paramInt, naf paramnaf)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((nbg)localIterator.next()).a(paramString, paramInt, paramnaf);
    }
    localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nbh)localIterator.next()).a(paramString, paramInt, paramnaf);
    }
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((nbi)localIterator.next()).a(paramString1, paramLong, paramInt1, paramInt2, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!this.jdField_a_of_type_Naf.a()) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a().a(this.jdField_a_of_type_Naf.b(), paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((nbg)localIterator.next()).a(paramString1, paramString2, paramString3);
    }
  }
  
  public void a(String paramString, naf paramnaf)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nbh)localIterator.next()).a(paramString, paramnaf);
    }
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nbh)localIterator.next()).a(paramHashMap);
    }
  }
  
  public void a(naf paramnaf)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nbh)localIterator.next()).a(paramnaf);
    }
  }
  
  public void a(naf paramnaf, int paramInt)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((nbg)localIterator.next()).a(paramnaf, paramInt);
    }
    localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nbh)localIterator.next()).a(paramnaf, paramInt);
    }
  }
  
  public void a(naf paramnaf, String paramString)
  {
    this.jdField_a_of_type_Nac.a(paramnaf, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((nbi)localIterator.next()).a(paramnaf, paramString);
    }
  }
  
  public void a(naf paramnaf, boolean paramBoolean)
  {
    this.jdField_a_of_type_Nac.a(paramnaf, false);
    if (this.jdField_a_of_type_Nac.a()) {
      QLog.d("avgame_logic.GameEngine", 1, "onGameOverPush NotPlayedYet return.");
    }
    for (;;)
    {
      if (paramnaf.c() == 4)
      {
        QLog.d("avgame_logic.GameEngine", 1, "onGameOverPush disable aec mode");
        ((nhk)biin.a().a()).a(0);
      }
      nau.a().c();
      AVGameNodeReportUtil.d();
      return;
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((nbi)localIterator.next()).a(paramnaf, paramBoolean);
      }
    }
  }
  
  public void a(nbg paramnbg)
  {
    this.c.add(paramnbg);
  }
  
  public void a(nbh paramnbh)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramnbh)) {
      this.jdField_a_of_type_JavaUtilList.add(paramnbh);
    }
  }
  
  public void a(nbi paramnbi)
  {
    if (!this.b.contains(paramnbi)) {
      this.b.add(paramnbi);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    ProcessMonitor.a().b("exitGameRoom");
    if (ngu.b() != null) {
      ngu.b().e();
    }
    a(paramInt);
    this.jdField_a_of_type_Nad.a();
    this.jdField_a_of_type_Nac.a();
    this.jdField_a_of_type_Naa.a();
    long l = this.jdField_a_of_type_Naf.a();
    if ((l != 0L) && (!paramBoolean)) {
      b(l, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
    }
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a().a(0, String.valueOf(l));
    this.jdField_a_of_type_Naf.a();
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
      bcef.b(null, "dc00898", "", "", str, str, 0, 0, "" + paramInt, "", "", "");
      AVGameNodeReportUtil.b(AVGameNodeReportUtil.a(paramInt));
      mzt.a();
      return;
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nbh)localIterator.next()).a(paramBoolean, paramLong, paramInt1, paramInt2, paramString);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nbh)localIterator.next()).a(paramBoolean, paramLong, paramInt, paramString);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((nbg)localIterator.next()).a(paramBoolean, paramString1, paramInt, paramString2);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Naf.e(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
  }
  
  public boolean a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Naf.a() == 0L) {
      return false;
    }
    this.jdField_a_of_type_Mzx.a(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getAccount(), this.jdField_a_of_type_Naf.a(), paramInt, paramString);
    return true;
  }
  
  public boolean a(int paramInt, String paramString, naf paramnaf)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      nbh localnbh = (nbh)localIterator.next();
      if ((bool) || (localnbh.a(paramInt, paramString, paramnaf))) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    QLog.i("avgame_logic.GameEngine", 1, "onRoomSelfExit exitType:" + paramInt + " exitRoomTip:" + paramString + " handled:" + bool);
    if (!bool) {
      a(nba.a().a(paramInt, paramString, paramnaf), paramInt);
    }
    return bool;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if (!this.jdField_a_of_type_Naf.a()) {
      return false;
    }
    this.jdField_a_of_type_Mzx.a(paramString, paramInt, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Naf.a(), this.jdField_a_of_type_Naf.b());
    return true;
  }
  
  public boolean a(nak paramnak)
  {
    boolean bool = true;
    if (mzo.b(paramnak)) {
      return false;
    }
    paramnak = this.jdField_a_of_type_Naf.a();
    List localList = paramnak.getPlayers();
    int i = 0;
    if (i < localList.size()) {
      if ((localList.get(i) == null) || (((Player)localList.get(i)).status != 0)) {}
    }
    for (i = 0;; i = 1)
    {
      if ((a()) && (paramnak.getPlayers().size() > 1) && (i != 0)) {}
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
    j();
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameEngine", 4, "selectGame gameType = " + paramInt);
    }
    this.jdField_a_of_type_Naa.a(a().getCurrentAccountUin(), this.jdField_a_of_type_Naf.a(), paramInt);
  }
  
  public void b(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameEngine", 4, "leaveGameRoomByUser roomId = " + paramLong + " userUin =" + paramString);
    }
    this.jdField_a_of_type_Naa.a(paramLong, paramString, a());
  }
  
  public void b(long paramLong, String paramString1, String paramString2)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((nbi)localIterator.next()).b(paramLong, paramString1, paramString2);
    }
  }
  
  public void b(String paramString, naf paramnaf)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nbh)localIterator.next()).b(paramString, paramnaf);
    }
  }
  
  public void b(naf paramnaf)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nbh)localIterator.next()).b(paramnaf);
    }
  }
  
  public void b(naf paramnaf, int paramInt)
  {
    this.jdField_a_of_type_Nac.a(paramnaf, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((nbi)localIterator.next()).b(paramnaf, paramInt);
    }
  }
  
  public void b(nbg paramnbg)
  {
    this.c.remove(paramnbg);
  }
  
  public void b(nbh paramnbh)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramnbh);
  }
  
  public void b(nbi paramnbi)
  {
    this.b.remove(paramnbi);
  }
  
  public boolean b()
  {
    if (!this.jdField_a_of_type_Naf.a()) {
      return false;
    }
    this.jdField_a_of_type_Mzx.a(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_Naf.a(), this.jdField_a_of_type_Naf.b());
    return true;
  }
  
  public boolean b(nak paramnak)
  {
    boolean bool = true;
    if (mzo.b(paramnak)) {
      return false;
    }
    paramnak = this.jdField_a_of_type_Naf.a();
    List localList = paramnak.getPlayers();
    int i = 0;
    if (i < localList.size()) {
      if ((localList.get(i) == null) || (((Player)localList.get(i)).status != 0)) {}
    }
    for (i = 0;; i = 1)
    {
      if ((paramnak.getPlayers().size() > 1) && (i != 0)) {}
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
    if (!this.jdField_a_of_type_Naf.a()) {
      return;
    }
    if (QLog.isDebugVersion()) {
      QLog.i("avgame_logic.GameEngine_GameRC", 1, String.format("onclick share:playId[%s]", new Object[] { this.jdField_a_of_type_Naf.b() }));
    }
    this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a().a(this.jdField_a_of_type_Naf.b());
  }
  
  public void c(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("avgame_logic.GameEngine", 4, "kickGameRoomUserByOwner roomId = " + paramLong + " ownerUin =" + paramString1 + " kickedUserUin =" + paramString2);
    }
    this.jdField_a_of_type_Naa.a(paramLong, paramString1, paramString2);
  }
  
  public void c(String paramString, naf paramnaf)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((nbi)localIterator.next()).c(paramString, paramnaf);
    }
  }
  
  public void c(naf paramnaf)
  {
    this.jdField_a_of_type_Nac.a(paramnaf, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((nbi)localIterator.next()).c(paramnaf);
    }
    if (paramnaf.c() == 4)
    {
      QLog.d("avgame_logic.GameEngine", 1, "onGameStartSuc enable aec mode");
      ((nhk)biin.a().a()).a(1);
    }
    nau.a().a(paramnaf.a(), "countdown");
    if (this.jdField_a_of_type_Naf.a() != null) {
      nau.a().d(this.jdField_a_of_type_Naf.a().a());
    }
    AVGameNodeReportUtil.a(paramnaf.c(), paramnaf.a().players.size());
  }
  
  public void c(naf paramnaf, int paramInt)
  {
    this.jdField_a_of_type_Nac.a(paramnaf, true);
    int i = paramnaf.a();
    int j = paramnaf.b();
    Iterator localIterator;
    if ((i == 10) && (j == 0))
    {
      localIterator = this.b.iterator();
      if (localIterator.hasNext())
      {
        nbi localnbi = (nbi)localIterator.next();
        if (paramInt != 1) {}
        for (boolean bool = true;; bool = false)
        {
          localnbi.a(paramnaf, bool);
          break;
        }
      }
      nau.a().c();
    }
    for (;;)
    {
      return;
      localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        ((nbh)localIterator.next()).c(paramnaf, paramInt);
      }
    }
  }
  
  public boolean c()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return mxh.a().a(this);
    }
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Naf.b();
  }
  
  public void d(String paramString, naf paramnaf)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((nbi)localIterator.next()).d(paramString, paramnaf);
    }
  }
  
  public void d(naf paramnaf)
  {
    this.jdField_a_of_type_Nac.a(paramnaf, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((nbi)localIterator.next()).d(paramnaf);
    }
  }
  
  public boolean d()
  {
    if (!this.jdField_a_of_type_Naf.a()) {}
    while (this.jdField_a_of_type_Naf.b() == null) {
      return false;
    }
    this.jdField_a_of_type_Mzx.a(this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getAccount(), this.jdField_a_of_type_Naf.b());
    return true;
  }
  
  public void e()
  {
    ((nbe)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(1)).a(a().a(), a().a().owner);
  }
  
  public void e(naf paramnaf)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((nbi)localIterator.next()).e(paramnaf);
    }
    ThreadManager.getSubThreadHandler().post(new GameEngine.1(this, paramnaf));
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Naf.a(a());
  }
  
  public void f()
  {
    if ((e()) && (a()))
    {
      ((nbe)this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.a(1)).a(a().a(), a().i(), a().a().owner);
      return;
    }
    QLog.d("avgame_logic.GameEngine", 2, "stopGameMatch no need");
  }
  
  public void f(naf paramnaf)
  {
    this.jdField_a_of_type_Nac.a(paramnaf, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((nbi)localIterator.next()).f(paramnaf);
    }
    if (paramnaf.c() == 4)
    {
      QLog.d("avgame_logic.GameEngine", 1, "onGameStartPush enable aec mode");
      ((nhk)biin.a().a()).a(1);
    }
    nau.a().a(paramnaf.a(), "countdown");
    if (this.jdField_a_of_type_Naf.a() != null) {
      nau.a().d(this.jdField_a_of_type_Naf.a().a());
    }
    AVGameNodeReportUtil.a(paramnaf.c(), paramnaf.a().players.size());
  }
  
  public void g()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nbh)localIterator.next()).g();
    }
  }
  
  public void g(naf paramnaf)
  {
    this.jdField_a_of_type_Nac.a(paramnaf, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((nbi)localIterator.next()).g(paramnaf);
    }
    nau.a().a(paramnaf.a(), "countdown");
    SecurityPolicyChecker.a().a(paramnaf, this.jdField_a_of_type_ComTencentAvgameAppAVGameAppInterface.getCurrentAccountUin());
  }
  
  public void h()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nbh)localIterator.next()).h();
    }
  }
  
  public void h(naf paramnaf)
  {
    this.jdField_a_of_type_Nac.a(paramnaf, false);
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((nbi)localIterator.next()).h(paramnaf);
    }
  }
  
  public void i()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((nbh)localIterator.next()).i();
    }
  }
  
  public void i(naf paramnaf)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((nbg)localIterator.next()).i(paramnaf);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mzl
 * JD-Core Version:    0.7.0.1
 */