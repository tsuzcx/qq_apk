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
import com.tencent.avgame.session.AVGameSession;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.avgame.ui.AVGameActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class nbk
  implements Handler.Callback, nag, nah, nbp
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  protected Context a;
  protected DialogInterface.OnClickListener a;
  public Handler a;
  public Runnable a;
  protected mxw a;
  protected nbn a;
  public nbq a;
  protected ncg a;
  protected nci a;
  protected nco a;
  public nda a;
  protected ndb a;
  protected nev a;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  
  public nbk(nbq paramnbq)
  {
    this.jdField_a_of_type_Mxw = new nbl(this);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new nbm(this);
    this.jdField_a_of_type_JavaLangRunnable = new GameRoomPresenterImp.3(this);
    this.jdField_a_of_type_Nbq = paramnbq;
  }
  
  private void a(int paramInt1, int paramInt2, mze parammze)
  {
    Object localObject1;
    if ((paramInt1 != 0) && (paramInt1 != 10) && (paramInt2 == 3))
    {
      localObject1 = parammze.a();
      if ((localObject1 == null) || (!(localObject1 instanceof mzq))) {}
    }
    for (mzq localmzq = (mzq)localObject1;; localmzq = null)
    {
      Object localObject2 = null;
      boolean bool2 = false;
      boolean bool1 = false;
      nfw localnfw = nfm.b().a();
      long l1;
      if ((localmzq != null) && (!TextUtils.isEmpty(localmzq.a.jdField_a_of_type_JavaLangString)))
      {
        bool2 = bool1;
        localObject1 = localObject2;
        if (localnfw != null)
        {
          localObject1 = localmzq.a.jdField_a_of_type_JavaLangString;
          localnfw.a(false);
          if ((paramInt1 == 3) || (paramInt1 == 4)) {
            break label342;
          }
          long l2 = parammze.a().d();
          l1 = l2;
          if (l2 > localmzq.a.jdField_a_of_type_Int * 1000) {
            l1 = 0L;
          }
          if ((localnfw.a()) && (TextUtils.equals((CharSequence)localObject1, localnfw.a()))) {
            break label268;
          }
          if (l1 <= 500L) {
            break label257;
          }
          localnfw.b((String)localObject1, l1);
          bool2 = bool1;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("GameRoomPresenterImp", 2, "playStarGuessVideo topic:" + localmzq + " url:" + (String)localObject1 + " stop:" + bool2 + " gameStatus:" + paramInt1);
        }
        return;
        label257:
        localnfw.b((String)localObject1, 0L);
        break;
        label268:
        if (l1 - localnfw.a() <= 500L) {
          break;
        }
        break;
        bool1 = bool2;
        if (localnfw != null)
        {
          localnfw.b();
          localnfw.c();
          bool1 = true;
        }
        bool2 = bool1;
        localObject1 = localObject2;
        if (paramInt2 == 3)
        {
          this.jdField_a_of_type_Nev.a(false);
          bool2 = bool1;
          localObject1 = localObject2;
          continue;
          label342:
          bool2 = bool1;
        }
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2, mze parammze)
  {
    Object localObject2 = null;
    boolean bool2 = false;
    if ((paramInt1 != 0) && (paramInt1 != 10) && (paramInt2 == 4))
    {
      localObject1 = parammze.a();
      if ((localObject1 == null) || (!(localObject1 instanceof mzr))) {}
    }
    for (Object localObject1 = (mzr)localObject1;; localObject1 = null)
    {
      nfw localnfw = nfm.b().a();
      if ((localObject1 != null) && (!TextUtils.isEmpty(((mzr)localObject1).a.jdField_a_of_type_JavaLangString)))
      {
        bool1 = bool2;
        String str;
        long l1;
        if (localnfw != null)
        {
          str = ((mzr)localObject1).a.jdField_a_of_type_JavaLangString;
          localnfw.a(false);
          localObject2 = str;
          bool1 = bool2;
          if (paramInt1 != 3)
          {
            localObject2 = str;
            bool1 = bool2;
            if (paramInt1 != 4)
            {
              long l2 = parammze.a().d();
              l1 = l2;
              if (l2 > ((mzr)localObject1).a.jdField_a_of_type_Int * 1000) {
                l1 = 0L;
              }
              if ((localnfw.a()) && (TextUtils.equals(str, localnfw.a()))) {
                break label289;
              }
              if (l1 <= 500L) {
                break label270;
              }
              localnfw.a(str, l1);
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
          localnfw.a(str, 0L);
          localObject2 = str;
          bool1 = bool2;
          continue;
          label289:
          localObject2 = str;
          bool1 = bool2;
          if (l1 - localnfw.a() > 500L)
          {
            localObject2 = str;
            bool1 = bool2;
          }
        }
      }
      if (localnfw != null)
      {
        localnfw.b();
        localnfw.c();
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramInt2 == 4) {}
        break;
      }
    }
  }
  
  private void c(int paramInt1, int paramInt2, mze parammze)
  {
    Object localObject1 = null;
    if ((paramInt1 != 0) && (paramInt1 != 10) && (paramInt2 == 3))
    {
      localObject1 = parammze.a();
      if ((localObject1 != null) && ((localObject1 instanceof mzq)))
      {
        localObject1 = (mzq)localObject1;
        parammze = parammze.b();
      }
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      nfw localnfw = nfm.b().a();
      if ((localObject1 != null) && (localnfw != null))
      {
        nfv localnfv = new nfv();
        localnfv.jdField_a_of_type_JavaLangString = ((mzq)localObject1).a.jdField_a_of_type_JavaLangString;
        localnfv.jdField_a_of_type_Long = (((mzq)localObject1).a.jdField_a_of_type_Int * 1000);
        localnfv.b = ((mzq)localObject1).a.b;
        localArrayList.add(localnfv);
        if ((parammze != null) && (!parammze.isEmpty()))
        {
          paramInt1 = 0;
          while (paramInt1 < parammze.size())
          {
            Object localObject2 = (myp)parammze.get(paramInt1);
            if ((localObject2 != null) && ((localObject2 instanceof mzq)))
            {
              localnfv = new nfv();
              localObject2 = (mzq)localObject2;
              localnfv.jdField_a_of_type_JavaLangString = ((mzq)localObject2).a.jdField_a_of_type_JavaLangString;
              localnfv.b = ((mzq)localObject2).a.b;
              localnfv.jdField_a_of_type_Long = (((mzq)localObject2).a.jdField_a_of_type_Int * 1000);
              localArrayList.add(localnfv);
            }
            paramInt1 += 1;
          }
        }
        localnfw.a(localArrayList);
      }
      if (QLog.isColorLevel()) {
        QLog.i("GameRoomPresenterImp", 2, "onNeedCheckAndPreloadAudioVideo  PreloadVideo videoTopic:" + localObject1 + " files:" + localArrayList);
      }
      return;
      localObject1 = null;
      break;
      localArrayList = null;
      parammze = (mze)localObject1;
      localObject1 = localArrayList;
    }
  }
  
  private void d(int paramInt1, int paramInt2, mze parammze)
  {
    Object localObject1 = null;
    if ((paramInt1 != 0) && (paramInt1 != 10) && (paramInt2 == 4))
    {
      localObject1 = parammze.a();
      if ((localObject1 != null) && ((localObject1 instanceof mzr)))
      {
        localObject1 = (mzr)localObject1;
        parammze = parammze.b();
      }
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      nfw localnfw = nfm.b().a();
      if ((localObject1 != null) && (localnfw != null))
      {
        nfv localnfv = new nfv();
        localnfv.jdField_a_of_type_JavaLangString = ((mzr)localObject1).a.jdField_a_of_type_JavaLangString;
        localnfv.jdField_a_of_type_Long = (((mzr)localObject1).a.jdField_a_of_type_Int * 1000);
        localArrayList.add(localnfv);
        if ((parammze != null) && (!parammze.isEmpty()))
        {
          paramInt1 = 0;
          while (paramInt1 < parammze.size())
          {
            Object localObject2 = (myp)parammze.get(paramInt1);
            if ((localObject2 != null) && ((localObject2 instanceof mzr)))
            {
              localnfv = new nfv();
              localObject2 = (mzr)localObject2;
              localnfv.jdField_a_of_type_JavaLangString = ((mzr)localObject2).a.jdField_a_of_type_JavaLangString;
              localnfv.jdField_a_of_type_Long = (((mzr)localObject2).a.jdField_a_of_type_Int * 1000);
              localArrayList.add(localnfv);
            }
            paramInt1 += 1;
          }
        }
        localnfw.a(localArrayList);
      }
      if (QLog.isColorLevel()) {
        QLog.i("GameRoomPresenterImp", 2, "onNeedCheckAndPreloadAudioVideo PreloadAudio videoTopic:" + localObject1 + " files:" + localArrayList);
      }
      return;
      localObject1 = null;
      break;
      localArrayList = null;
      parammze = (mze)localObject1;
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
    Object localObject1 = myk.a().a();
    int i = ((mze)localObject1).a();
    boolean bool1 = ((mze)localObject1).c();
    Player localPlayer = ((mze)localObject1).a();
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
      localObject1 = ((mze)localObject1).b();
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
      localObject2 = nfm.b().a();
      bool6 = bool1;
      if (localObject2 != null) {
        bool6 = ((AVGameSession)localObject2).e;
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
          a(1, this.jdField_a_of_type_AndroidContentContext.getString(2131690224));
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
        a(1, this.jdField_a_of_type_AndroidContentContext.getString(2131690225));
        continue;
        label659:
        if ((bool6) && (!this.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_Boolean = true;
          a(this.jdField_a_of_type_AndroidContentContext.getString(2131690221), 3000);
          bool1 = bool7;
        }
        else if ((bool6) && (!this.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_Boolean = true;
          a(this.jdField_a_of_type_AndroidContentContext.getString(2131690221));
          bool1 = bool7;
        }
        else if ((bool4) && (this.jdField_b_of_type_Long != localAVGameUserInfo2.mUin))
        {
          this.jdField_b_of_type_Long = localAVGameUserInfo2.mUin;
          a(this.jdField_a_of_type_AndroidContentContext.getString(2131690222));
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
              a(this.jdField_a_of_type_AndroidContentContext.getString(2131690223));
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
    long l = myk.a().a();
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "startRefreshGameListRunnable() nextRefreshTimeInterval = " + l);
    }
    if (l != 9223372036854775807L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameRoomPresenterImp", 2, "startRefreshGameListRunnable() postRunnable and nextRefreshTimeInterval = " + l);
      }
      bkdz.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, l * 1000L + 2000L);
    }
  }
  
  private void k()
  {
    bkdz.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private void n(mze parammze)
  {
    Player localPlayer;
    int i;
    if ((parammze.c() == 1) && (System.currentTimeMillis() - this.jdField_a_of_type_Long > 3000L))
    {
      localPlayer = parammze.a();
      parammze = parammze.b();
      if ((localPlayer == null) || (parammze == null) || (!TextUtils.equals(localPlayer.uin, parammze.uin))) {
        break label177;
      }
      i = 1;
      if (localPlayer == null) {
        break label182;
      }
    }
    label177:
    label182:
    for (parammze = a(localPlayer.uin);; parammze = null)
    {
      if ((i != 0) && (parammze != null))
      {
        if (!parammze.hasVideo()) {
          bdll.b(null, "dc00898", "", "", "0X800B03E", "0X800B03E", 0, 0, "", "", "", "");
        }
        parammze = nfm.b().a();
        if ((parammze != null) && (parammze.e)) {
          bdll.b(null, "dc00898", "", "", "0X800B03F", "0X800B03F", 0, 0, "", "", "", "");
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
    return this.jdField_a_of_type_Nbq.a();
  }
  
  public RectF a()
  {
    return this.jdField_a_of_type_Nco.a();
  }
  
  public AVGameUserInfo a(String paramString)
  {
    AVGameSession localAVGameSession = nfm.b().a();
    if (localAVGameSession != null) {
      return localAVGameSession.a(Long.valueOf(paramString).longValue());
    }
    return null;
  }
  
  public String a()
  {
    String str = "";
    mzj localmzj = myk.a().a().a();
    if (localmzj != null) {
      str = localmzj.e;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "getGamePrepareTransparentBgURL = " + str);
    }
    return str;
  }
  
  public List<nbr> a()
  {
    List localList = b();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_Nco.b();
    if (localObject1 != null) {
      localArrayList.addAll((Collection)localObject1);
    }
    RectF localRectF = this.jdField_a_of_type_Nda.a();
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
        localObject2 = (nbr)localArrayList.get(i);
        if (((nbr)localObject2).jdField_b_of_type_Boolean)
        {
          ((nbr)localObject2).jdField_a_of_type_Int = Math.round(localRectF.left);
          ((nbr)localObject2).jdField_b_of_type_Int = Math.round(localRectF.top);
          ((nbr)localObject2).jdField_c_of_type_Int = Math.round(localRectF.width());
          ((nbr)localObject2).d = Math.round(localRectF.height());
          localObject1 = localObject2;
        }
        if (((nbr)localObject2).jdField_c_of_type_Boolean)
        {
          ((nbr)localObject2).f = Math.round(localRectF.left);
          ((nbr)localObject2).g = Math.round(localRectF.top);
          ((nbr)localObject2).h = Math.round(localRectF.width());
          ((nbr)localObject2).i = Math.round(localRectF.height());
        }
        i += 1;
      }
    }
    QLog.i("GameRoomPresenterImp", 1, "getMemberVideoDisplayInfoList bigVideoInfo:" + localObject2 + "  playingRect:" + localRectF + " displayList:" + localArrayList + " aVList:" + localList);
    return localArrayList;
  }
  
  public nbq a()
  {
    return this.jdField_a_of_type_Nbq;
  }
  
  public nci a()
  {
    return this.jdField_a_of_type_Nci;
  }
  
  public nco a()
  {
    return this.jdField_a_of_type_Nco;
  }
  
  public ndb a()
  {
    return this.jdField_a_of_type_Ndb;
  }
  
  public void a()
  {
    mze localmze = myk.a().a();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, 1000L);
    m(localmze);
    k(localmze);
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
    this.jdField_a_of_type_Nbq.a(a());
    this.jdField_a_of_type_Nda.b(myk.a().a());
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Nbq.b(paramInt, paramString);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, mze parammze)
  {
    QLog.i("GameRoomPresenterImp", 1, "onRoomOtherMemberExit exitType:" + paramInt + " kickUin:" + paramString1 + " exitRoomTip:" + paramString2 + " engineData:" + parammze);
    if (3 == paramInt) {
      this.jdField_a_of_type_Nbq.a(paramString2, null);
    }
    for (;;)
    {
      i(parammze);
      a(-1);
      return;
      a(paramString2);
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Nbq != null) {
      this.jdField_a_of_type_Nbq.a(paramLong, paramInt, paramString1, paramString2);
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Nbq.a(paramLong1, paramLong2);
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Nbq.a(1, paramString2);
  }
  
  public void a(long paramLong, String paramString1, boolean paramBoolean, String paramString2, int paramInt)
  {
    i(myk.a().a());
  }
  
  public void a(Context paramContext, ncg paramncg, nda paramnda, nco paramnco, nci paramnci, nev paramnev, ndb paramndb)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Ncg = paramncg;
    this.jdField_a_of_type_Nda = paramnda;
    this.jdField_a_of_type_Nco = paramnco;
    this.jdField_a_of_type_Nci = paramnci;
    this.jdField_a_of_type_Nev = paramnev;
    this.jdField_a_of_type_Ndb = paramndb;
    myk.a().a(this);
    myk.a().a(this);
    nfm.b().a(this.jdField_a_of_type_Mxw);
    if (this.jdField_a_of_type_Nbn == null)
    {
      this.jdField_a_of_type_Nbn = new nbn(this.jdField_a_of_type_AndroidOsHandler);
      mxt.a().a(this.jdField_a_of_type_Nbn, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "init");
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Nbq.a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Nbq.a(paramString, paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 3) && ((paramInt1 == 113) || (paramInt1 == 109)))
    {
      paramString = a().getResources().getString(2131690377);
      this.jdField_a_of_type_Nbq.a(1, paramString);
    }
  }
  
  public void a(String paramString, int paramInt, mze parammze)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "pushOnChangeUserStatus uin = " + paramString);
    }
    if ((paramString.equals(myk.a().a().getAccount())) && (paramInt == 1)) {
      this.jdField_a_of_type_Nbq.d();
    }
    i(parammze);
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "onGameStartFail uin:" + paramString1 + " gameType:" + paramInt1 + " roomId:" + paramLong + " errorCode " + paramInt2 + " errMsg:" + paramString2);
    }
    if (paramInt2 == 404)
    {
      paramString1 = a().getResources().getString(2131690260);
      this.jdField_a_of_type_Nbq.a(paramString1, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_Nda.a(myk.a().a());
      return;
      if (paramInt2 == 405)
      {
        paramString1 = a().getResources().getString(2131690370);
        this.jdField_a_of_type_Nbq.a(1, paramString1);
        i(myk.a().a());
      }
      else if ((paramInt2 == 406) && (paramString2 != null) && (paramString2.length() > 0))
      {
        this.jdField_a_of_type_Nbq.a(paramString2, null);
      }
      else
      {
        this.jdField_a_of_type_Nbq.a(1, "开始游戏失败");
      }
    }
  }
  
  public void a(String paramString, mze parammze)
  {
    i(parammze);
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    this.jdField_a_of_type_Nco.a(myk.a().a());
  }
  
  public void a(mze parammze)
  {
    this.jdField_a_of_type_Ncg.a(parammze);
    nhp.a().a("param_StepGameReady", 0);
    if (this.jdField_a_of_type_Ncg.a()) {
      nhp.a().a("param_StepGameCanStart");
    }
    j();
  }
  
  public void a(mze parammze, int paramInt)
  {
    if (paramInt == 4) {
      this.jdField_a_of_type_Nbq.d();
    }
    i(parammze);
  }
  
  public void a(mze parammze, String paramString)
  {
    this.jdField_a_of_type_Nda.a(parammze);
    this.jdField_a_of_type_Nda.a(paramString);
  }
  
  public void a(mze parammze, boolean paramBoolean)
  {
    GameRoomPresenterImp.4 local4 = new GameRoomPresenterImp.4(this);
    if (paramBoolean)
    {
      bkdz.a().postDelayed(local4, 1560L);
      i(parammze);
    }
    for (;;)
    {
      e();
      k(parammze);
      l(parammze);
      return;
      local4.run();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Player localPlayer = myk.a().a().a();
    bdll.b(null, "dc00898", "", "", "0X800B035", "0X800B035", mya.a().a(localPlayer) + 1, 0, "1", "", "", "");
    mya.a().a(a(), paramBoolean, false);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "exitGameRoom svrAlreadyExit:" + paramBoolean);
    }
    this.jdField_a_of_type_Nbq.f();
    myk.a().a(paramBoolean, paramInt);
  }
  
  public boolean a(int paramInt, String paramString, mze parammze)
  {
    QLog.i("GameRoomPresenterImp", 1, "onRoomSelfExit exitType:" + paramInt + " exitRoomTip:" + paramString + " engineData:" + parammze);
    switch (paramInt)
    {
    case 0: 
    default: 
      a(true, paramInt);
      this.jdField_a_of_type_Nbq.e();
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
      this.jdField_a_of_type_Nbq.a(paramString, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      return true;
    case 5: 
    case 9: 
    case 10: 
    case 11: 
      a(false, paramInt);
      this.jdField_a_of_type_Nbq.a(paramString, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      return true;
    }
    a(false, paramInt);
    this.jdField_a_of_type_Nbq.e();
    return true;
  }
  
  public String b()
  {
    String str = "";
    mzj localmzj = myk.a().a().a();
    if (localmzj != null) {
      str = localmzj.d;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "getGamePrepareBgURL = " + str);
    }
    return str;
  }
  
  public List<AVGameUserInfo> b()
  {
    AVGameSession localAVGameSession = nfm.b().a();
    ArrayList localArrayList = new ArrayList();
    if (localAVGameSession != null) {
      localAVGameSession.b(localArrayList);
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
    this.jdField_a_of_type_Nbq.b(paramInt);
  }
  
  public void b(long paramLong, String paramString1, String paramString2) {}
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Nbq.b(paramString);
  }
  
  public void b(String paramString, mze parammze)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "pushOnRoomEnter roomEnterTip = " + paramString);
    }
    a().h();
    a(paramString);
    i(parammze);
  }
  
  public void b(mze parammze)
  {
    if (!myk.a().a()) {
      this.jdField_a_of_type_Ncg.a(parammze);
    }
  }
  
  public void b(mze parammze, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "onAnswerRightPush scoreThisTime = " + paramInt);
    }
    this.jdField_a_of_type_Nda.a(parammze);
    this.jdField_a_of_type_Nco.a(parammze);
  }
  
  public void b(boolean paramBoolean)
  {
    e();
  }
  
  public List<Player> c()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(myk.a().a().a().getPlayers());
    return localArrayList;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "destroy");
    }
    this.jdField_a_of_type_Nco.b();
    this.jdField_a_of_type_Nda.c();
    nfm.b().b(this.jdField_a_of_type_Mxw);
    myk.a().b(this);
    myk.a().b(this);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Nbn != null)
    {
      mxt.a().b(this.jdField_a_of_type_Nbn);
      this.jdField_a_of_type_Nbn = null;
    }
  }
  
  public void c(String paramString, mze parammze)
  {
    this.jdField_a_of_type_Nda.a(paramString, parammze);
  }
  
  public void c(mze parammze)
  {
    this.jdField_a_of_type_Nbq.b();
    i(parammze);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    e();
    n(parammze);
  }
  
  public void c(mze parammze, int paramInt)
  {
    i(parammze);
  }
  
  public void c(boolean paramBoolean)
  {
    e();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Nbq.g();
  }
  
  public void d(String paramString, mze parammze)
  {
    this.jdField_a_of_type_Nda.b(paramString, parammze);
  }
  
  public void d(mze parammze)
  {
    this.jdField_a_of_type_Nda.a(parammze);
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Nbq.a(paramBoolean);
  }
  
  public void e(mze parammze)
  {
    m(parammze);
  }
  
  public void f(mze parammze)
  {
    this.jdField_a_of_type_Nbq.b();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    i(parammze);
    e();
    ngk.a().a().post(new GameRoomPresenterImp.5(this));
    n(parammze);
  }
  
  public void g()
  {
    this.jdField_a_of_type_Ncg.a(myk.a().a());
  }
  
  public void g(mze parammze)
  {
    i(parammze);
    e();
    n(parammze);
  }
  
  public void h()
  {
    if (!myk.a().a()) {
      this.jdField_a_of_type_Ncg.a(myk.a().a());
    }
  }
  
  public void h(mze parammze)
  {
    this.jdField_a_of_type_Nda.a(parammze);
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
          this.jdField_a_of_type_Nco.a(myk.a().a());
          return true;
          this.jdField_a_of_type_Nda.a(myk.a().a());
          return true;
          this.jdField_a_of_type_Ncg.a(myk.a().a());
          return true;
          this.jdField_a_of_type_Ncg.a(myk.a().a());
          this.jdField_a_of_type_Nco.a(myk.a().a());
          this.jdField_a_of_type_Nda.a(myk.a().a());
          return true;
          f();
          return true;
          j(myk.a().a());
          a(0);
          f();
          return true;
        } while (lev.b() == 1);
        a(this.jdField_a_of_type_AndroidContentContext.getString(2131690308));
        bdll.b(null, "dc00898", "", "", "0X800B040", "0X800B040", 0, 0, "", "", "", "");
        return true;
      } while ((this.jdField_a_of_type_AndroidContentContext == null) || (!(this.jdField_a_of_type_AndroidContentContext instanceof AVGameActivity)));
      paramMessage = (AVGameActivity)this.jdField_a_of_type_AndroidContentContext;
    } while (paramMessage.c());
    for (;;)
    {
      int j;
      try
      {
        if ((paramMessage.c()) || (nfm.b().a() != 1)) {
          break label349;
        }
        i = 1;
        j = k;
        if (nfm.b().a() != 0) {
          break label354;
        }
        j = k;
        if (nfm.b().b()) {
          break label354;
        }
        j = 1;
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
        return true;
      }
      a(this.jdField_a_of_type_AndroidContentContext.getString(2131690219));
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
    if (!myk.a().a()) {
      this.jdField_a_of_type_Ncg.a(myk.a().a());
    }
  }
  
  public void i(mze parammze)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "refreshAll engineData:" + parammze);
    }
    this.jdField_a_of_type_Nco.a(parammze);
    this.jdField_a_of_type_Ncg.a(parammze);
    this.jdField_a_of_type_Nda.a(parammze);
    j(parammze);
    a(50);
  }
  
  public void j(mze parammze)
  {
    Object localObject2 = null;
    int i = parammze.a();
    Player localPlayer1;
    Object localObject1;
    if ((i != 0) && (i != 10))
    {
      Player localPlayer2 = parammze.b();
      localPlayer1 = localPlayer2;
      localObject1 = localObject2;
      if (localPlayer2 != null)
      {
        localPlayer1 = localPlayer2;
        localObject1 = localObject2;
        if (parammze.b(localPlayer2.uin))
        {
          localObject1 = localPlayer2.uin;
          localPlayer1 = localPlayer2;
        }
      }
    }
    for (;;)
    {
      QLog.i("GameRoomPresenterImp", 1, "playerBigVideoChanged player:" + localPlayer1 + "  gameStatus:" + i + "  gameType:" + parammze.c());
      this.jdField_a_of_type_Nev.a((String)localObject1);
      return;
      localPlayer1 = null;
      localObject1 = localObject2;
    }
  }
  
  public void k(mze parammze)
  {
    int i = parammze.a();
    int j = parammze.c();
    if (j == 3) {
      a(i, j, parammze);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameRoomPresenterImp", 2, "onNeedCheckAndPlayAudioVideo gameStatus:" + i + " gameType:" + j);
      }
      return;
      if (j == 4) {
        b(i, j, parammze);
      }
    }
  }
  
  public void l(mze parammze)
  {
    parammze = nfm.b().a();
    if (parammze != null) {
      parammze.a();
    }
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "onNeedCheckAndReleaseAudioVideo");
    }
  }
  
  public void m(mze parammze)
  {
    int i = parammze.a();
    int j = parammze.c();
    if ((i != 0) && (i != 10)) {
      if (j == 3) {
        c(i, j, parammze);
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (j != 4);
      d(i, j, parammze);
      return;
    }
    QLog.i("GameRoomPresenterImp", 2, "onNeedCheckAndPreloadAudioVideo gameStatus:" + i + " gameType:" + j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nbk
 * JD-Core Version:    0.7.0.1
 */