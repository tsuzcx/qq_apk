import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gameroom.GameRoomPresenterImp.3;
import com.tencent.avgame.gameroom.GameRoomPresenterImp.4;
import com.tencent.avgame.gameroom.GameRoomPresenterImp.5;
import com.tencent.avgame.gameroom.GameRoomPresenterImp.6;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.avgame.ui.AVGameActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class ncl
  implements Handler.Callback, nbh, nbi, ncq
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  protected Context a;
  protected DialogInterface.OnClickListener a;
  public Handler a;
  public Runnable a;
  protected myh a;
  protected nco a;
  public ncr a;
  protected ndl a;
  protected ndn a;
  protected ndt a;
  public neg a;
  protected neh a;
  protected ngc a;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  
  public ncl(ncr paramncr)
  {
    this.jdField_a_of_type_Myh = new ncm(this);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new ncn(this);
    this.jdField_a_of_type_JavaLangRunnable = new GameRoomPresenterImp.3(this);
    this.jdField_a_of_type_Ncr = paramncr;
  }
  
  private void a(int paramInt1, int paramInt2, naf paramnaf)
  {
    Object localObject1;
    if ((paramInt1 != 0) && (paramInt1 != 10) && (paramInt2 == 3))
    {
      localObject1 = paramnaf.a();
      if ((localObject1 == null) || (!(localObject1 instanceof nar))) {}
    }
    for (nar localnar = (nar)localObject1;; localnar = null)
    {
      Object localObject2 = null;
      boolean bool2 = false;
      boolean bool1 = false;
      nhe localnhe = ngu.b().a();
      long l1;
      if ((localnar != null) && (!TextUtils.isEmpty(localnar.a.jdField_a_of_type_JavaLangString)))
      {
        bool2 = bool1;
        localObject1 = localObject2;
        if (localnhe != null)
        {
          localObject1 = localnar.a.jdField_a_of_type_JavaLangString;
          localnhe.a(false);
          if ((paramInt1 == 3) || (paramInt1 == 4)) {
            break label342;
          }
          long l2 = paramnaf.a().d();
          l1 = l2;
          if (l2 > localnar.a.jdField_a_of_type_Int * 1000) {
            l1 = 0L;
          }
          if ((localnhe.a()) && (TextUtils.equals((CharSequence)localObject1, localnhe.a()))) {
            break label268;
          }
          if (l1 <= 500L) {
            break label257;
          }
          localnhe.b((String)localObject1, l1);
          bool2 = bool1;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("GameRoomPresenterImp", 2, "playStarGuessVideo topic:" + localnar + " url:" + (String)localObject1 + " stop:" + bool2 + " gameStatus:" + paramInt1);
        }
        return;
        label257:
        localnhe.b((String)localObject1, 0L);
        break;
        label268:
        if (l1 - localnhe.a() <= 500L) {
          break;
        }
        break;
        bool1 = bool2;
        if (localnhe != null)
        {
          localnhe.b();
          localnhe.c();
          bool1 = true;
        }
        bool2 = bool1;
        localObject1 = localObject2;
        if (paramInt2 == 3)
        {
          this.jdField_a_of_type_Ngc.a(false);
          bool2 = bool1;
          localObject1 = localObject2;
          continue;
          label342:
          bool2 = bool1;
        }
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2, naf paramnaf)
  {
    Object localObject2 = null;
    boolean bool2 = false;
    if ((paramInt1 != 0) && (paramInt1 != 10) && (paramInt2 == 4))
    {
      localObject1 = paramnaf.a();
      if ((localObject1 == null) || (!(localObject1 instanceof nas))) {}
    }
    for (Object localObject1 = (nas)localObject1;; localObject1 = null)
    {
      nhe localnhe = ngu.b().a();
      if ((localObject1 != null) && (!TextUtils.isEmpty(((nas)localObject1).a.jdField_a_of_type_JavaLangString)))
      {
        bool1 = bool2;
        String str;
        long l1;
        if (localnhe != null)
        {
          str = ((nas)localObject1).a.jdField_a_of_type_JavaLangString;
          localnhe.a(false);
          localObject2 = str;
          bool1 = bool2;
          if (paramInt1 != 3)
          {
            localObject2 = str;
            bool1 = bool2;
            if (paramInt1 != 4)
            {
              long l2 = paramnaf.a().d();
              l1 = l2;
              if (l2 > ((nas)localObject1).a.jdField_a_of_type_Int * 1000) {
                l1 = 0L;
              }
              if ((localnhe.a()) && (TextUtils.equals(str, localnhe.a()))) {
                break label289;
              }
              if (l1 <= 500L) {
                break label270;
              }
              localnhe.a(str, l1);
              bool1 = bool2;
              localObject2 = str;
            }
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("GameRoomPresenterImp", 2, "playStarGuessVideo topic:" + localObject1 + " url:" + localObject2 + " stop:" + bool1 + " gameStatus:" + paramInt1);
          }
          return;
          label270:
          localnhe.a(str, 0L);
          localObject2 = str;
          bool1 = bool2;
          continue;
          label289:
          localObject2 = str;
          bool1 = bool2;
          if (l1 - localnhe.a() > 500L)
          {
            localObject2 = str;
            bool1 = bool2;
          }
        }
      }
      if (localnhe != null)
      {
        localnhe.b();
        localnhe.c();
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramInt2 == 4) {}
        break;
      }
    }
  }
  
  private void c(int paramInt1, int paramInt2, naf paramnaf)
  {
    Object localObject1 = null;
    if ((paramInt1 != 0) && (paramInt1 != 10) && (paramInt2 == 3))
    {
      localObject1 = paramnaf.a();
      if ((localObject1 != null) && ((localObject1 instanceof nar)))
      {
        localObject1 = (nar)localObject1;
        paramnaf = paramnaf.b();
      }
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      nhe localnhe = ngu.b().a();
      if ((localObject1 != null) && (localnhe != null))
      {
        nhd localnhd = new nhd();
        localnhd.jdField_a_of_type_JavaLangString = ((nar)localObject1).a.jdField_a_of_type_JavaLangString;
        localnhd.jdField_a_of_type_Long = (((nar)localObject1).a.jdField_a_of_type_Int * 1000);
        localnhd.b = ((nar)localObject1).a.b;
        localArrayList.add(localnhd);
        if ((paramnaf != null) && (!paramnaf.isEmpty()))
        {
          paramInt1 = 0;
          while (paramInt1 < paramnaf.size())
          {
            Object localObject2 = (mzq)paramnaf.get(paramInt1);
            if ((localObject2 != null) && ((localObject2 instanceof nar)))
            {
              localnhd = new nhd();
              localObject2 = (nar)localObject2;
              localnhd.jdField_a_of_type_JavaLangString = ((nar)localObject2).a.jdField_a_of_type_JavaLangString;
              localnhd.b = ((nar)localObject2).a.b;
              localnhd.jdField_a_of_type_Long = (((nar)localObject2).a.jdField_a_of_type_Int * 1000);
              localArrayList.add(localnhd);
            }
            paramInt1 += 1;
          }
        }
        localnhe.a(localArrayList);
      }
      if (QLog.isColorLevel()) {
        QLog.i("GameRoomPresenterImp", 2, "onNeedCheckAndPreloadAudioVideo  PreloadVideo videoTopic:" + localObject1 + " files:" + localArrayList);
      }
      return;
      localObject1 = null;
      break;
      localArrayList = null;
      paramnaf = (naf)localObject1;
      localObject1 = localArrayList;
    }
  }
  
  private void d(int paramInt1, int paramInt2, naf paramnaf)
  {
    Object localObject1 = null;
    if ((paramInt1 != 0) && (paramInt1 != 10) && (paramInt2 == 4))
    {
      localObject1 = paramnaf.a();
      if ((localObject1 != null) && ((localObject1 instanceof nas)))
      {
        localObject1 = (nas)localObject1;
        paramnaf = paramnaf.b();
      }
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      nhe localnhe = ngu.b().a();
      if ((localObject1 != null) && (localnhe != null))
      {
        nhd localnhd = new nhd();
        localnhd.jdField_a_of_type_JavaLangString = ((nas)localObject1).a.jdField_a_of_type_JavaLangString;
        localnhd.jdField_a_of_type_Long = (((nas)localObject1).a.jdField_a_of_type_Int * 1000);
        localArrayList.add(localnhd);
        if ((paramnaf != null) && (!paramnaf.isEmpty()))
        {
          paramInt1 = 0;
          while (paramInt1 < paramnaf.size())
          {
            Object localObject2 = (mzq)paramnaf.get(paramInt1);
            if ((localObject2 != null) && ((localObject2 instanceof nas)))
            {
              localnhd = new nhd();
              localObject2 = (nas)localObject2;
              localnhd.jdField_a_of_type_JavaLangString = ((nas)localObject2).a.jdField_a_of_type_JavaLangString;
              localnhd.jdField_a_of_type_Long = (((nas)localObject2).a.jdField_a_of_type_Int * 1000);
              localArrayList.add(localnhd);
            }
            paramInt1 += 1;
          }
        }
        localnhe.a(localArrayList);
      }
      if (QLog.isColorLevel()) {
        QLog.i("GameRoomPresenterImp", 2, "onNeedCheckAndPreloadAudioVideo PreloadAudio videoTopic:" + localObject1 + " files:" + localArrayList);
      }
      return;
      localObject1 = null;
      break;
      localArrayList = null;
      paramnaf = (naf)localObject1;
      localObject1 = localArrayList;
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(6, 1000L);
  }
  
  private void f()
  {
    Object localObject1 = mzl.a().a();
    int i = ((naf)localObject1).a();
    boolean bool1 = ((naf)localObject1).c();
    Player localPlayer = ((naf)localObject1).a();
    boolean bool2;
    label66:
    AVGameUserInfo localAVGameUserInfo1;
    label82:
    AVGameUserInfo localAVGameUserInfo2;
    label98:
    label113:
    boolean bool3;
    label129:
    boolean bool4;
    label145:
    boolean bool5;
    label161:
    boolean bool7;
    boolean bool8;
    boolean bool9;
    long l;
    Object localObject2;
    boolean bool6;
    if (bool1)
    {
      localObject1 = ((naf)localObject1).b();
      if ((localPlayer == null) || (localObject1 == null) || (!TextUtils.equals(localPlayer.uin, ((Player)localObject1).uin))) {
        break label591;
      }
      bool2 = true;
      if (localPlayer == null) {
        break label596;
      }
      localAVGameUserInfo1 = a(localPlayer.uin);
      if (localObject1 == null) {
        break label602;
      }
      localAVGameUserInfo2 = a(((Player)localObject1).uin);
      if ((localAVGameUserInfo1 == null) || (localAVGameUserInfo1.mMicOn)) {
        break label608;
      }
      bool1 = true;
      if ((localAVGameUserInfo1 == null) || (localAVGameUserInfo1.hasCameraVideo())) {
        break label613;
      }
      bool3 = true;
      if ((localAVGameUserInfo2 == null) || (localAVGameUserInfo2.mMicOn)) {
        break label619;
      }
      bool4 = true;
      if ((localAVGameUserInfo2 == null) || (localAVGameUserInfo2.hasCameraVideo())) {
        break label625;
      }
      bool5 = true;
      bool7 = true;
      bool8 = this.jdField_b_of_type_Boolean;
      bool9 = this.jdField_a_of_type_Boolean;
      l = this.jdField_b_of_type_Long;
      localObject2 = ngu.b().a();
      bool6 = bool1;
      if (localObject2 != null) {
        bool6 = ((nhn)localObject2).e;
      }
      bool1 = bool7;
      if (i != 0)
      {
        bool1 = bool7;
        if (i != 10)
        {
          if (!bool2) {
            break label659;
          }
          if (!bool6) {
            break label631;
          }
          bool1 = false;
          a(1, this.jdField_a_of_type_AndroidContentContext.getString(2131690249));
        }
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = bool6;
      if (bool1) {
        b(1);
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuffer();
        ((StringBuffer)localObject2).append("gameStatus:").append(i).append("\n");
        ((StringBuffer)localObject2).append("self:").append(localPlayer).append("\n");
        ((StringBuffer)localObject2).append("player:").append(localObject1).append("\n");
        ((StringBuffer)localObject2).append("isSelfPlaying:").append(bool2).append("\n");
        ((StringBuffer)localObject2).append("selfAV:").append(localAVGameUserInfo1).append("\n");
        ((StringBuffer)localObject2).append("playerAV:").append(localAVGameUserInfo2).append("\n");
        ((StringBuffer)localObject2).append("isSelfNoOpenAudio:").append(bool6).append("\n");
        ((StringBuffer)localObject2).append("isSelfNoOpenCamera:").append(bool3).append("\n");
        ((StringBuffer)localObject2).append("isPlayerNoOpenAudio:").append(bool4).append("\n");
        ((StringBuffer)localObject2).append("isPlayerNoOpenCamera:").append(bool5).append("\n");
        ((StringBuffer)localObject2).append("noPermanentTip:").append(bool1).append("\n");
        ((StringBuffer)localObject2).append("selfAudioTipShowed:").append(bool9).append("\n");
        ((StringBuffer)localObject2).append("lastIsSelfAudioNoOpen:").append(bool8).append("\n");
        ((StringBuffer)localObject2).append("lastOtherAVPlayingTipUin:").append(l).append("\n");
        QLog.d("GameRoomPresenterImp", 2, "checkAndShowAVStatusTips|" + ((StringBuffer)localObject2).toString());
      }
      return;
      localObject1 = null;
      break;
      label591:
      bool2 = false;
      break label66;
      label596:
      localAVGameUserInfo1 = null;
      break label82;
      label602:
      localAVGameUserInfo2 = null;
      break label98;
      label608:
      bool1 = false;
      break label113;
      label613:
      bool3 = false;
      break label129;
      label619:
      bool4 = false;
      break label145;
      label625:
      bool5 = false;
      break label161;
      label631:
      bool1 = bool7;
      if (bool3)
      {
        bool1 = false;
        a(1, this.jdField_a_of_type_AndroidContentContext.getString(2131690250));
        continue;
        label659:
        if ((bool6) && (!this.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_Boolean = true;
          a(this.jdField_a_of_type_AndroidContentContext.getString(2131690246), 3000);
          bool1 = bool7;
        }
        else if ((bool6) && (!this.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_Boolean = true;
          a(this.jdField_a_of_type_AndroidContentContext.getString(2131690246));
          bool1 = bool7;
        }
        else if ((bool4) && (this.jdField_b_of_type_Long != localAVGameUserInfo2.mUin))
        {
          this.jdField_b_of_type_Long = localAVGameUserInfo2.mUin;
          a(this.jdField_a_of_type_AndroidContentContext.getString(2131690247));
          bool1 = bool7;
        }
        else
        {
          bool1 = bool7;
          if (bool5)
          {
            bool1 = bool7;
            if (this.jdField_b_of_type_Long != localAVGameUserInfo2.mUin)
            {
              this.jdField_b_of_type_Long = localAVGameUserInfo2.mUin;
              a(this.jdField_a_of_type_AndroidContentContext.getString(2131690248));
              bool1 = bool7;
            }
          }
        }
      }
    }
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "startRefreshGameListRunnable()");
    }
    k();
    long l = mzl.a().a();
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "startRefreshGameListRunnable() nextRefreshTimeInterval = " + l);
    }
    if (l != 9223372036854775807L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameRoomPresenterImp", 2, "startRefreshGameListRunnable() postRunnable and nextRefreshTimeInterval = " + l);
      }
      bijk.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, l * 1000L + 2000L);
    }
  }
  
  private void k()
  {
    bijk.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private void l()
  {
    mzl.a().f();
  }
  
  private void n(naf paramnaf)
  {
    Player localPlayer;
    int i;
    if ((paramnaf.c() == 1) && (System.currentTimeMillis() - this.jdField_a_of_type_Long > 3000L))
    {
      localPlayer = paramnaf.a();
      paramnaf = paramnaf.b();
      if ((localPlayer == null) || (paramnaf == null) || (!TextUtils.equals(localPlayer.uin, paramnaf.uin))) {
        break label177;
      }
      i = 1;
      if (localPlayer == null) {
        break label182;
      }
    }
    label177:
    label182:
    for (paramnaf = a(localPlayer.uin);; paramnaf = null)
    {
      if ((i != 0) && (paramnaf != null))
      {
        if (!paramnaf.hasVideo()) {
          bcef.b(null, "dc00898", "", "", "0X800B03E", "0X800B03E", 0, 0, "", "", "", "");
        }
        paramnaf = ngu.b().a();
        if ((paramnaf != null) && (paramnaf.e)) {
          bcef.b(null, "dc00898", "", "", "0X800B03F", "0X800B03F", 0, 0, "", "", "", "");
        }
      }
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
      i = 0;
      break;
    }
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_Ncr.a();
  }
  
  public RectF a()
  {
    return this.jdField_a_of_type_Ndt.a();
  }
  
  public AVGameUserInfo a(String paramString)
  {
    nhn localnhn = ngu.b().a();
    if (localnhn != null) {
      return localnhn.a(Long.valueOf(paramString).longValue());
    }
    return null;
  }
  
  public String a()
  {
    String str = "";
    nak localnak = mzl.a().a().a();
    if (localnak != null) {
      str = localnak.e;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "getGamePrepareTransparentBgURL = " + str);
    }
    return str;
  }
  
  public List<ncs> a()
  {
    List localList = b();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_Ndt.b();
    if (localObject1 != null) {
      localArrayList.addAll((Collection)localObject1);
    }
    RectF localRectF = this.jdField_a_of_type_Neg.a();
    Object localObject2 = null;
    localObject1 = null;
    if (localRectF != null)
    {
      int i = 0;
      for (;;)
      {
        localObject2 = localObject1;
        if (i >= localArrayList.size()) {
          break;
        }
        localObject2 = (ncs)localArrayList.get(i);
        if (((ncs)localObject2).jdField_b_of_type_Boolean)
        {
          ((ncs)localObject2).jdField_a_of_type_Int = Math.round(localRectF.left);
          ((ncs)localObject2).jdField_b_of_type_Int = Math.round(localRectF.top);
          ((ncs)localObject2).jdField_c_of_type_Int = Math.round(localRectF.width());
          ((ncs)localObject2).d = Math.round(localRectF.height());
          localObject1 = localObject2;
        }
        if (((ncs)localObject2).jdField_c_of_type_Boolean)
        {
          ((ncs)localObject2).f = Math.round(localRectF.left);
          ((ncs)localObject2).g = Math.round(localRectF.top);
          ((ncs)localObject2).h = Math.round(localRectF.width());
          ((ncs)localObject2).i = Math.round(localRectF.height());
        }
        i += 1;
      }
    }
    QLog.i("GameRoomPresenterImp", 1, "getMemberVideoDisplayInfoList bigVideoInfo:" + localObject2 + "  playingRect:" + localRectF + " displayList:" + localArrayList + " aVList:" + localList);
    return localArrayList;
  }
  
  public ncr a()
  {
    return this.jdField_a_of_type_Ncr;
  }
  
  public ndn a()
  {
    return this.jdField_a_of_type_Ndn;
  }
  
  public ndt a()
  {
    return this.jdField_a_of_type_Ndt;
  }
  
  public neh a()
  {
    return this.jdField_a_of_type_Neh;
  }
  
  public void a()
  {
    naf localnaf = mzl.a().a();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, 1000L);
    m(localnaf);
    k(localnaf);
    j();
    QLog.i("GameRoomPresenterImp", 1, "onFragmentStart");
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 0L);
      return;
    }
    this.jdField_a_of_type_Ncr.a(a());
    this.jdField_a_of_type_Neg.b(mzl.a().a());
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Ncr.b(paramInt, paramString);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, naf paramnaf)
  {
    QLog.i("GameRoomPresenterImp", 1, "onRoomOtherMemberExit exitType:" + paramInt + " kickUin:" + paramString1 + " exitRoomTip:" + paramString2 + " engineData:" + paramnaf);
    if (3 == paramInt) {
      this.jdField_a_of_type_Ncr.a(paramString2, null);
    }
    for (;;)
    {
      i(paramnaf);
      a(-1);
      return;
      a(paramString2);
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Ncr != null) {
      this.jdField_a_of_type_Ncr.a(paramLong, paramInt, paramString1, paramString2);
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Ncr.a(paramLong1, paramLong2);
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Ncr.a(1, paramString2);
  }
  
  public void a(long paramLong, String paramString1, boolean paramBoolean, String paramString2, int paramInt)
  {
    i(mzl.a().a());
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    naf localnaf = mzl.a().a();
    this.jdField_a_of_type_Ndl.a(localnaf);
    this.jdField_a_of_type_Ndt.a(localnaf);
  }
  
  public void a(Context paramContext, ndl paramndl, neg paramneg, ndt paramndt, ndn paramndn, ngc paramngc, neh paramneh)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Ndl = paramndl;
    this.jdField_a_of_type_Neg = paramneg;
    this.jdField_a_of_type_Ndt = paramndt;
    this.jdField_a_of_type_Ndn = paramndn;
    this.jdField_a_of_type_Ngc = paramngc;
    this.jdField_a_of_type_Neh = paramneh;
    mzl.a().a(this);
    mzl.a().a(this);
    ngu.b().a(this.jdField_a_of_type_Myh);
    if (this.jdField_a_of_type_Nco == null)
    {
      this.jdField_a_of_type_Nco = new nco(this.jdField_a_of_type_AndroidOsHandler);
      mye.a().a(this.jdField_a_of_type_Nco, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "init");
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Ncr.a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Ncr.a(paramString, paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 3) && ((paramInt1 == 113) || (paramInt1 == 109)))
    {
      paramString = a().getResources().getString(2131690417);
      this.jdField_a_of_type_Ncr.a(1, paramString);
    }
  }
  
  public void a(String paramString, int paramInt, naf paramnaf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "pushOnChangeUserStatus uin = " + paramString);
    }
    if ((paramString.equals(mzl.a().a().getAccount())) && (paramInt == 1))
    {
      this.jdField_a_of_type_Ncr.d();
      this.jdField_a_of_type_Ngc.b(false);
    }
    i(paramnaf);
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "onGameStartFail uin:" + paramString1 + " gameType:" + paramInt1 + " roomId:" + paramLong + " errorCode " + paramInt2 + " errMsg:" + paramString2);
    }
    if (paramInt2 == 404)
    {
      paramString1 = a().getResources().getString(2131690285);
      this.jdField_a_of_type_Ncr.a(paramString1, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_Neg.a(mzl.a().a());
      return;
      if (paramInt2 == 405)
      {
        paramString1 = a().getResources().getString(2131690410);
        this.jdField_a_of_type_Ncr.a(1, paramString1);
        i(mzl.a().a());
      }
      else if ((paramInt2 == 406) && (paramString2 != null) && (paramString2.length() > 0))
      {
        this.jdField_a_of_type_Ncr.a(paramString2, null);
      }
      else
      {
        this.jdField_a_of_type_Ncr.a(1, "开始游戏失败");
      }
    }
  }
  
  public void a(String paramString, naf paramnaf)
  {
    i(paramnaf);
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    this.jdField_a_of_type_Ndt.a(mzl.a().a());
  }
  
  public void a(naf paramnaf)
  {
    this.jdField_a_of_type_Ndl.a(paramnaf);
    nje.a().a("param_StepGameReady", 0);
    if (this.jdField_a_of_type_Ndl.a()) {
      nje.a().a("param_StepGameCanStart");
    }
    j();
  }
  
  public void a(naf paramnaf, int paramInt)
  {
    if (paramInt == 4)
    {
      this.jdField_a_of_type_Ncr.d();
      this.jdField_a_of_type_Ngc.b(false);
    }
    i(paramnaf);
    QLog.d("GameRoomPresenterImp", 1, "onChangeUserStatusSuccess");
    ThreadManager.excute(new GameRoomPresenterImp.4(this), 16, null, false);
  }
  
  public void a(naf paramnaf, String paramString)
  {
    this.jdField_a_of_type_Neg.a(paramnaf);
    this.jdField_a_of_type_Neg.a(paramString, paramnaf.c());
  }
  
  public void a(naf paramnaf, boolean paramBoolean)
  {
    GameRoomPresenterImp.5 local5 = new GameRoomPresenterImp.5(this);
    if (paramBoolean)
    {
      bijk.a().postDelayed(local5, 1560L);
      i(paramnaf);
    }
    for (;;)
    {
      e();
      k(paramnaf);
      l(paramnaf);
      return;
      local5.run();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Player localPlayer = mzl.a().a().a();
    bcef.b(null, "dc00898", "", "", "0X800B035", "0X800B035", myl.a().a(localPlayer) + 1, 0, "1", "", "", "");
    myl.a().a(a(), paramBoolean, false);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "exitGameRoom svrAlreadyExit:" + paramBoolean);
    }
    if (paramInt != 3) {
      l();
    }
    this.jdField_a_of_type_Ncr.f();
    mzl.a().a(paramBoolean, paramInt);
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    if (paramBoolean)
    {
      paramString = mzl.a().a();
      this.jdField_a_of_type_Ndl.a(paramString);
      this.jdField_a_of_type_Ndt.a(paramString);
      return;
    }
    if (paramInt2 == 601) {}
    for (;;)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = this.jdField_a_of_type_AndroidContentContext.getString(2131690387);
      }
      this.jdField_a_of_type_Ncr.a(str, null);
      return;
      paramString = null;
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString)
  {
    paramString = mzl.a().a();
    this.jdField_a_of_type_Ndl.a(paramString);
    this.jdField_a_of_type_Ndt.a(paramString);
  }
  
  public boolean a(int paramInt, String paramString, naf paramnaf)
  {
    QLog.i("GameRoomPresenterImp", 1, "onRoomSelfExit exitType:" + paramInt + " exitRoomTip:" + paramString + " engineData:" + paramnaf);
    switch (paramInt)
    {
    case 0: 
    default: 
      a(true, paramInt);
      this.jdField_a_of_type_Ncr.e();
    case -2: 
    case -1: 
    case 1: 
    case 2: 
      return true;
    case 3: 
    case 4: 
    case 6: 
    case 7: 
      a(true, paramInt);
      this.jdField_a_of_type_Ncr.a(paramString, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      return true;
    case 5: 
    case 9: 
    case 10: 
    case 11: 
      a(false, paramInt);
      this.jdField_a_of_type_Ncr.a(paramString, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      return true;
    }
    a(false, paramInt);
    this.jdField_a_of_type_Ncr.e();
    return true;
  }
  
  public String b()
  {
    String str = "";
    nak localnak = mzl.a().a().a();
    if (localnak != null) {
      str = localnak.d;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "getGamePrepareBgURL = " + str);
    }
    return str;
  }
  
  public List<AVGameUserInfo> b()
  {
    nhn localnhn = ngu.b().a();
    ArrayList localArrayList = new ArrayList();
    if (localnhn != null) {
      localnhn.b(localArrayList);
    }
    return localArrayList;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
    k();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Ncr.b(paramInt);
  }
  
  public void b(long paramLong, String paramString1, String paramString2) {}
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Ncr.b(paramString);
  }
  
  public void b(String paramString, naf paramnaf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "pushOnRoomEnter roomEnterTip = " + paramString);
    }
    a().h();
    a(paramString);
    i(paramnaf);
    if ((paramnaf.d()) && (paramnaf.a(paramnaf.e(mzl.a().a().getCurrentAccountUin()))))
    {
      l();
      a(a().getResources().getString(2131690340));
    }
  }
  
  public void b(naf paramnaf)
  {
    if (!mzl.a().a()) {
      this.jdField_a_of_type_Ndl.a(paramnaf);
    }
  }
  
  public void b(naf paramnaf, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "onAnswerRightPush scoreThisTime = " + paramInt);
    }
    this.jdField_a_of_type_Neg.a(paramnaf);
    this.jdField_a_of_type_Ndt.a(paramnaf);
  }
  
  public void b(boolean paramBoolean)
  {
    e();
  }
  
  public List<Player> c()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(mzl.a().a().a().getPlayers());
    return localArrayList;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "destroy");
    }
    this.jdField_a_of_type_Ndt.b();
    this.jdField_a_of_type_Neg.c();
    ngu.b().b(this.jdField_a_of_type_Myh);
    mzl.a().b(this);
    mzl.a().b(this);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Nco != null)
    {
      mye.a().b(this.jdField_a_of_type_Nco);
      this.jdField_a_of_type_Nco = null;
    }
  }
  
  public void c(String paramString, naf paramnaf)
  {
    this.jdField_a_of_type_Neg.a(paramString, paramnaf);
  }
  
  public void c(naf paramnaf)
  {
    this.jdField_a_of_type_Ncr.b();
    i(paramnaf);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    l();
    e();
    n(paramnaf);
    this.jdField_a_of_type_Ngc.b(true);
  }
  
  public void c(naf paramnaf, int paramInt)
  {
    i(paramnaf);
  }
  
  public void c(boolean paramBoolean)
  {
    e();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Ncr.g();
  }
  
  public void d(String paramString, naf paramnaf)
  {
    this.jdField_a_of_type_Neg.b(paramString, paramnaf);
  }
  
  public void d(naf paramnaf)
  {
    this.jdField_a_of_type_Neg.a(paramnaf);
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Ncr.a(paramBoolean);
  }
  
  public void e(naf paramnaf)
  {
    m(paramnaf);
  }
  
  public void f(naf paramnaf)
  {
    this.jdField_a_of_type_Ncr.b();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    i(paramnaf);
    e();
    nht.a().a().post(new GameRoomPresenterImp.6(this));
    n(paramnaf);
    this.jdField_a_of_type_Ngc.b(true);
    l();
  }
  
  public void g()
  {
    this.jdField_a_of_type_Ndl.a(mzl.a().a());
  }
  
  public void g(naf paramnaf)
  {
    i(paramnaf);
    e();
    n(paramnaf);
  }
  
  public void h()
  {
    if (!mzl.a().a()) {
      this.jdField_a_of_type_Ndl.a(mzl.a().a());
    }
  }
  
  public void h(naf paramnaf)
  {
    this.jdField_a_of_type_Neg.a(paramnaf);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int k = 0;
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          return true;
          a(-1);
          return true;
          this.jdField_a_of_type_Ndt.a(mzl.a().a());
          return true;
          this.jdField_a_of_type_Neg.a(mzl.a().a());
          return true;
          this.jdField_a_of_type_Ndl.a(mzl.a().a());
          return true;
          this.jdField_a_of_type_Ndl.a(mzl.a().a());
          this.jdField_a_of_type_Ndt.a(mzl.a().a());
          this.jdField_a_of_type_Neg.a(mzl.a().a());
          return true;
          f();
          return true;
          j(mzl.a().a());
          a(0);
          f();
          return true;
        } while (lep.b() == 1);
        a(this.jdField_a_of_type_AndroidContentContext.getString(2131690346));
        bcef.b(null, "dc00898", "", "", "0X800B040", "0X800B040", 0, 0, "", "", "", "");
        return true;
      } while ((this.jdField_a_of_type_AndroidContentContext == null) || (!(this.jdField_a_of_type_AndroidContentContext instanceof AVGameActivity)));
      paramMessage = (AVGameActivity)this.jdField_a_of_type_AndroidContentContext;
    } while (paramMessage.c());
    for (;;)
    {
      int j;
      try
      {
        if ((paramMessage.c()) || (ngu.b().a() != 1)) {
          break label349;
        }
        i = 1;
        j = k;
        if (ngu.b().a() != 0) {
          break label354;
        }
        j = k;
        if (ngu.b().b()) {
          break label354;
        }
        j = 1;
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
        return true;
      }
      a(this.jdField_a_of_type_AndroidContentContext.getString(2131690244));
      return true;
      label349:
      int i = 0;
      continue;
      label354:
      if (i == 0) {
        if (j == 0) {
          break;
        }
      }
    }
  }
  
  public void i()
  {
    if (!mzl.a().a()) {
      this.jdField_a_of_type_Ndl.a(mzl.a().a());
    }
  }
  
  public void i(naf paramnaf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "refreshAll engineData:" + paramnaf);
    }
    this.jdField_a_of_type_Ndt.a(paramnaf);
    this.jdField_a_of_type_Ndl.a(paramnaf);
    this.jdField_a_of_type_Neg.a(paramnaf);
    j(paramnaf);
    a(50);
  }
  
  public void j(naf paramnaf)
  {
    Object localObject2 = null;
    int i = paramnaf.a();
    Player localPlayer1;
    Object localObject1;
    if ((i != 0) && (i != 10))
    {
      Player localPlayer2 = paramnaf.b();
      localPlayer1 = localPlayer2;
      localObject1 = localObject2;
      if (localPlayer2 != null)
      {
        localPlayer1 = localPlayer2;
        localObject1 = localObject2;
        if (paramnaf.b(localPlayer2.uin))
        {
          localObject1 = localPlayer2.uin;
          localPlayer1 = localPlayer2;
        }
      }
    }
    for (;;)
    {
      QLog.i("GameRoomPresenterImp", 1, "playerBigVideoChanged player:" + localPlayer1 + "  gameStatus:" + i + "  gameType:" + paramnaf.c());
      this.jdField_a_of_type_Ngc.a((String)localObject1);
      return;
      localPlayer1 = null;
      localObject1 = localObject2;
    }
  }
  
  public void k(naf paramnaf)
  {
    int i = paramnaf.a();
    int j = paramnaf.c();
    if (j == 3) {
      a(i, j, paramnaf);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameRoomPresenterImp", 2, "onNeedCheckAndPlayAudioVideo gameStatus:" + i + " gameType:" + j);
      }
      return;
      if (j == 4) {
        b(i, j, paramnaf);
      }
    }
  }
  
  public void l(naf paramnaf)
  {
    paramnaf = ngu.b().a();
    if (paramnaf != null) {
      paramnaf.a();
    }
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "onNeedCheckAndReleaseAudioVideo");
    }
  }
  
  public void m(naf paramnaf)
  {
    int i = paramnaf.a();
    int j = paramnaf.c();
    if ((i != 0) && (i != 10)) {
      if (j == 3) {
        c(i, j, paramnaf);
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (j != 4);
      d(i, j, paramnaf);
      return;
    }
    QLog.i("GameRoomPresenterImp", 2, "onNeedCheckAndPreloadAudioVideo gameStatus:" + i + " gameType:" + j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ncl
 * JD-Core Version:    0.7.0.1
 */