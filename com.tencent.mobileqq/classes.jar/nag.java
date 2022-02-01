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

public class nag
  implements Handler.Callback, mzd, mze, nal
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  protected Context a;
  protected DialogInterface.OnClickListener a;
  public Handler a;
  public Runnable a;
  protected mwx a;
  protected naj a;
  public nam a;
  protected nat a;
  protected nav a;
  protected nbb a;
  public nbn a;
  protected nbo a;
  protected ndc a;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  
  public nag(nam paramnam)
  {
    this.jdField_a_of_type_Mwx = new nah(this);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new nai(this);
    this.jdField_a_of_type_JavaLangRunnable = new GameRoomPresenterImp.3(this);
    this.jdField_a_of_type_Nam = paramnam;
  }
  
  private void a(int paramInt1, int paramInt2, myc parammyc)
  {
    Object localObject1;
    if ((paramInt1 != 0) && (paramInt1 != 10) && (paramInt2 == 3))
    {
      localObject1 = parammyc.a();
      if ((localObject1 == null) || (!(localObject1 instanceof myn))) {}
    }
    for (myn localmyn = (myn)localObject1;; localmyn = null)
    {
      Object localObject2 = null;
      boolean bool2 = false;
      boolean bool1 = false;
      ned localned = ndt.b().a();
      long l1;
      if ((localmyn != null) && (!TextUtils.isEmpty(localmyn.a.jdField_a_of_type_JavaLangString)))
      {
        bool2 = bool1;
        localObject1 = localObject2;
        if (localned != null)
        {
          localObject1 = localmyn.a.jdField_a_of_type_JavaLangString;
          localned.a(false);
          if ((paramInt1 == 3) || (paramInt1 == 4)) {
            break label342;
          }
          long l2 = parammyc.a().d();
          l1 = l2;
          if (l2 > localmyn.a.jdField_a_of_type_Int * 1000) {
            l1 = 0L;
          }
          if ((localned.a()) && (TextUtils.equals((CharSequence)localObject1, localned.a()))) {
            break label268;
          }
          if (l1 <= 500L) {
            break label257;
          }
          localned.b((String)localObject1, l1);
          bool2 = bool1;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("GameRoomPresenterImp", 2, "playStarGuessVideo topic:" + localmyn + " url:" + (String)localObject1 + " stop:" + bool2 + " gameStatus:" + paramInt1);
        }
        return;
        label257:
        localned.b((String)localObject1, 0L);
        break;
        label268:
        if (l1 - localned.a() <= 500L) {
          break;
        }
        break;
        bool1 = bool2;
        if (localned != null)
        {
          localned.b();
          localned.c();
          bool1 = true;
        }
        bool2 = bool1;
        localObject1 = localObject2;
        if (paramInt2 == 3)
        {
          this.jdField_a_of_type_Ndc.a(false);
          bool2 = bool1;
          localObject1 = localObject2;
          continue;
          label342:
          bool2 = bool1;
        }
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2, myc parammyc)
  {
    Object localObject2 = null;
    boolean bool2 = false;
    if ((paramInt1 != 0) && (paramInt1 != 10) && (paramInt2 == 4))
    {
      localObject1 = parammyc.a();
      if ((localObject1 == null) || (!(localObject1 instanceof myo))) {}
    }
    for (Object localObject1 = (myo)localObject1;; localObject1 = null)
    {
      ned localned = ndt.b().a();
      if ((localObject1 != null) && (!TextUtils.isEmpty(((myo)localObject1).a.jdField_a_of_type_JavaLangString)))
      {
        bool1 = bool2;
        String str;
        long l1;
        if (localned != null)
        {
          str = ((myo)localObject1).a.jdField_a_of_type_JavaLangString;
          localned.a(false);
          localObject2 = str;
          bool1 = bool2;
          if (paramInt1 != 3)
          {
            localObject2 = str;
            bool1 = bool2;
            if (paramInt1 != 4)
            {
              long l2 = parammyc.a().d();
              l1 = l2;
              if (l2 > ((myo)localObject1).a.jdField_a_of_type_Int * 1000) {
                l1 = 0L;
              }
              if ((localned.a()) && (TextUtils.equals(str, localned.a()))) {
                break label289;
              }
              if (l1 <= 500L) {
                break label270;
              }
              localned.a(str, l1);
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
          localned.a(str, 0L);
          localObject2 = str;
          bool1 = bool2;
          continue;
          label289:
          localObject2 = str;
          bool1 = bool2;
          if (l1 - localned.a() > 500L)
          {
            localObject2 = str;
            bool1 = bool2;
          }
        }
      }
      if (localned != null)
      {
        localned.b();
        localned.c();
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramInt2 == 4) {}
        break;
      }
    }
  }
  
  private void c(int paramInt1, int paramInt2, myc parammyc)
  {
    Object localObject1 = null;
    if ((paramInt1 != 0) && (paramInt1 != 10) && (paramInt2 == 3))
    {
      localObject1 = parammyc.a();
      if ((localObject1 != null) && ((localObject1 instanceof myn)))
      {
        localObject1 = (myn)localObject1;
        parammyc = parammyc.b();
      }
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      ned localned = ndt.b().a();
      if ((localObject1 != null) && (localned != null))
      {
        nec localnec = new nec();
        localnec.jdField_a_of_type_JavaLangString = ((myn)localObject1).a.jdField_a_of_type_JavaLangString;
        localnec.jdField_a_of_type_Long = (((myn)localObject1).a.jdField_a_of_type_Int * 1000);
        localnec.b = ((myn)localObject1).a.b;
        localArrayList.add(localnec);
        if ((parammyc != null) && (!parammyc.isEmpty()))
        {
          paramInt1 = 0;
          while (paramInt1 < parammyc.size())
          {
            Object localObject2 = (mxq)parammyc.get(paramInt1);
            if ((localObject2 != null) && ((localObject2 instanceof myn)))
            {
              localnec = new nec();
              localObject2 = (myn)localObject2;
              localnec.jdField_a_of_type_JavaLangString = ((myn)localObject2).a.jdField_a_of_type_JavaLangString;
              localnec.b = ((myn)localObject2).a.b;
              localnec.jdField_a_of_type_Long = (((myn)localObject2).a.jdField_a_of_type_Int * 1000);
              localArrayList.add(localnec);
            }
            paramInt1 += 1;
          }
        }
        localned.a(localArrayList);
      }
      if (QLog.isColorLevel()) {
        QLog.i("GameRoomPresenterImp", 2, "onNeedCheckAndPreloadAudioVideo  PreloadVideo videoTopic:" + localObject1 + " files:" + localArrayList);
      }
      return;
      localObject1 = null;
      break;
      localArrayList = null;
      parammyc = (myc)localObject1;
      localObject1 = localArrayList;
    }
  }
  
  private void d(int paramInt1, int paramInt2, myc parammyc)
  {
    Object localObject1 = null;
    if ((paramInt1 != 0) && (paramInt1 != 10) && (paramInt2 == 4))
    {
      localObject1 = parammyc.a();
      if ((localObject1 != null) && ((localObject1 instanceof myo)))
      {
        localObject1 = (myo)localObject1;
        parammyc = parammyc.b();
      }
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      ned localned = ndt.b().a();
      if ((localObject1 != null) && (localned != null))
      {
        nec localnec = new nec();
        localnec.jdField_a_of_type_JavaLangString = ((myo)localObject1).a.jdField_a_of_type_JavaLangString;
        localnec.jdField_a_of_type_Long = (((myo)localObject1).a.jdField_a_of_type_Int * 1000);
        localArrayList.add(localnec);
        if ((parammyc != null) && (!parammyc.isEmpty()))
        {
          paramInt1 = 0;
          while (paramInt1 < parammyc.size())
          {
            Object localObject2 = (mxq)parammyc.get(paramInt1);
            if ((localObject2 != null) && ((localObject2 instanceof myo)))
            {
              localnec = new nec();
              localObject2 = (myo)localObject2;
              localnec.jdField_a_of_type_JavaLangString = ((myo)localObject2).a.jdField_a_of_type_JavaLangString;
              localnec.jdField_a_of_type_Long = (((myo)localObject2).a.jdField_a_of_type_Int * 1000);
              localArrayList.add(localnec);
            }
            paramInt1 += 1;
          }
        }
        localned.a(localArrayList);
      }
      if (QLog.isColorLevel()) {
        QLog.i("GameRoomPresenterImp", 2, "onNeedCheckAndPreloadAudioVideo PreloadAudio videoTopic:" + localObject1 + " files:" + localArrayList);
      }
      return;
      localObject1 = null;
      break;
      localArrayList = null;
      parammyc = (myc)localObject1;
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
    Object localObject1 = mxl.a().a();
    int i = ((myc)localObject1).a();
    boolean bool1 = ((myc)localObject1).c();
    Player localPlayer = ((myc)localObject1).a();
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
      localObject1 = ((myc)localObject1).b();
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
      localObject2 = ndt.b().a();
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
          a(1, this.jdField_a_of_type_AndroidContentContext.getString(2131690214));
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
        a(1, this.jdField_a_of_type_AndroidContentContext.getString(2131690215));
        continue;
        label659:
        if ((bool6) && (!this.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_Boolean = true;
          a(this.jdField_a_of_type_AndroidContentContext.getString(2131690211), 3000);
          bool1 = bool7;
        }
        else if ((bool6) && (!this.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_Boolean = true;
          a(this.jdField_a_of_type_AndroidContentContext.getString(2131690211));
          bool1 = bool7;
        }
        else if ((bool4) && (this.jdField_b_of_type_Long != localAVGameUserInfo2.mUin))
        {
          this.jdField_b_of_type_Long = localAVGameUserInfo2.mUin;
          a(this.jdField_a_of_type_AndroidContentContext.getString(2131690212));
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
              a(this.jdField_a_of_type_AndroidContentContext.getString(2131690213));
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
    long l = mxl.a().a();
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "startRefreshGameListRunnable() nextRefreshTimeInterval = " + l);
    }
    if (l != 9223372036854775807L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameRoomPresenterImp", 2, "startRefreshGameListRunnable() postRunnable and nextRefreshTimeInterval = " + l);
      }
      bjda.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, l * 1000L + 2000L);
    }
  }
  
  private void k()
  {
    bjda.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private void n(myc parammyc)
  {
    Player localPlayer;
    int i;
    if ((parammyc.c() == 1) && (System.currentTimeMillis() - this.jdField_a_of_type_Long > 3000L))
    {
      localPlayer = parammyc.a();
      parammyc = parammyc.b();
      if ((localPlayer == null) || (parammyc == null) || (!TextUtils.equals(localPlayer.uin, parammyc.uin))) {
        break label177;
      }
      i = 1;
      if (localPlayer == null) {
        break label182;
      }
    }
    label177:
    label182:
    for (parammyc = a(localPlayer.uin);; parammyc = null)
    {
      if ((i != 0) && (parammyc != null))
      {
        if (!parammyc.hasVideo()) {
          bcst.b(null, "dc00898", "", "", "0X800B03E", "0X800B03E", 0, 0, "", "", "", "");
        }
        parammyc = ndt.b().a();
        if ((parammyc != null) && (parammyc.e)) {
          bcst.b(null, "dc00898", "", "", "0X800B03F", "0X800B03F", 0, 0, "", "", "", "");
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
    return this.jdField_a_of_type_Nam.a();
  }
  
  public AVGameUserInfo a(String paramString)
  {
    AVGameSession localAVGameSession = ndt.b().a();
    if (localAVGameSession != null) {
      return localAVGameSession.a(Long.valueOf(paramString).longValue());
    }
    return null;
  }
  
  public String a()
  {
    String str = "";
    myg localmyg = mxl.a().a().a();
    if (localmyg != null) {
      str = localmyg.e;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "getGamePrepareTransparentBgURL = " + str);
    }
    return str;
  }
  
  public List<nan> a()
  {
    List localList = b();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_Nbb.b();
    if (localObject1 != null) {
      localArrayList.addAll((Collection)localObject1);
    }
    RectF localRectF = this.jdField_a_of_type_Nbn.a();
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
        localObject2 = (nan)localArrayList.get(i);
        if (((nan)localObject2).jdField_b_of_type_Boolean)
        {
          ((nan)localObject2).jdField_a_of_type_Int = Math.round(localRectF.left);
          ((nan)localObject2).jdField_b_of_type_Int = Math.round(localRectF.top);
          ((nan)localObject2).jdField_c_of_type_Int = Math.round(localRectF.width());
          ((nan)localObject2).d = Math.round(localRectF.height());
          localObject1 = localObject2;
        }
        if (((nan)localObject2).jdField_c_of_type_Boolean)
        {
          ((nan)localObject2).f = Math.round(localRectF.left);
          ((nan)localObject2).g = Math.round(localRectF.top);
          ((nan)localObject2).h = Math.round(localRectF.width());
          ((nan)localObject2).i = Math.round(localRectF.height());
        }
        i += 1;
      }
    }
    QLog.i("GameRoomPresenterImp", 1, "getMemberVideoDisplayInfoList bigVideoInfo:" + localObject2 + "  playingRect:" + localRectF + " displayList:" + localArrayList + " aVList:" + localList);
    return localArrayList;
  }
  
  public nam a()
  {
    return this.jdField_a_of_type_Nam;
  }
  
  public nat a()
  {
    return this.jdField_a_of_type_Nat;
  }
  
  public nav a()
  {
    return this.jdField_a_of_type_Nav;
  }
  
  public nbb a()
  {
    return this.jdField_a_of_type_Nbb;
  }
  
  public nbo a()
  {
    return this.jdField_a_of_type_Nbo;
  }
  
  public void a()
  {
    myc localmyc = mxl.a().a();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, 1000L);
    m(localmyc);
    k(localmyc);
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
    this.jdField_a_of_type_Nam.a(a());
    this.jdField_a_of_type_Nbn.b(mxl.a().a());
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Nam.b(paramInt, paramString);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, myc parammyc)
  {
    QLog.i("GameRoomPresenterImp", 1, "onRoomOtherMemberExit exitType:" + paramInt + " kickUin:" + paramString1 + " exitRoomTip:" + paramString2 + " engineData:" + parammyc);
    a(paramString2);
    i(parammyc);
    a(-1);
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Nam != null) {
      this.jdField_a_of_type_Nam.a(paramLong, paramInt, paramString1, paramString2);
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Nam.a(paramLong1, paramLong2);
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Nam.a(1, paramString2);
  }
  
  public void a(long paramLong, String paramString1, boolean paramBoolean, String paramString2, int paramInt)
  {
    i(mxl.a().a());
  }
  
  public void a(Context paramContext, nat paramnat, nbn paramnbn, nbb paramnbb, nav paramnav, ndc paramndc, nbo paramnbo)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Nat = paramnat;
    this.jdField_a_of_type_Nbn = paramnbn;
    this.jdField_a_of_type_Nbb = paramnbb;
    this.jdField_a_of_type_Nav = paramnav;
    this.jdField_a_of_type_Ndc = paramndc;
    this.jdField_a_of_type_Nbo = paramnbo;
    mxl.a().a(this);
    mxl.a().a(this);
    ndt.b().a(this.jdField_a_of_type_Mwx);
    if (this.jdField_a_of_type_Naj == null)
    {
      this.jdField_a_of_type_Naj = new naj(this.jdField_a_of_type_AndroidOsHandler);
      mwu.a().a(this.jdField_a_of_type_Naj, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "init");
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Nam.a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Nam.a(paramString, paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 3) && ((paramInt1 == 113) || (paramInt1 == 109)))
    {
      paramString = a().getResources().getString(2131690380);
      this.jdField_a_of_type_Nam.a(1, paramString);
    }
  }
  
  public void a(String paramString, int paramInt, myc parammyc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "pushOnChangeUserStatus uin = " + paramString);
    }
    if ((paramString.equals(mxl.a().a().getAccount())) && (paramInt == 1)) {
      this.jdField_a_of_type_Nam.d();
    }
    i(parammyc);
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "onGameStartFail uin:" + paramString1 + " gameType:" + paramInt1 + " roomId:" + paramLong + " errorCode " + paramInt2 + " errMsg:" + paramString2);
    }
    if (paramInt2 == 404)
    {
      paramString1 = a().getResources().getString(2131690252);
      this.jdField_a_of_type_Nam.a(paramString1, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_Nbn.a(mxl.a().a());
      return;
      if (paramInt2 == 405)
      {
        paramString1 = a().getResources().getString(2131690372);
        this.jdField_a_of_type_Nam.a(1, paramString1);
        i(mxl.a().a());
      }
      else if ((paramInt2 == 406) && (paramString2 != null) && (paramString2.length() > 0))
      {
        this.jdField_a_of_type_Nam.a(paramString2, null);
      }
      else
      {
        this.jdField_a_of_type_Nam.a(1, "开始游戏失败");
      }
    }
  }
  
  public void a(String paramString, myc parammyc)
  {
    i(parammyc);
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    this.jdField_a_of_type_Nbb.a(mxl.a().a());
  }
  
  public void a(myc parammyc)
  {
    this.jdField_a_of_type_Nat.a(parammyc);
    nfu.a().a("param_StepGameReady", 0);
    if (this.jdField_a_of_type_Nat.a()) {
      nfu.a().a("param_StepGameCanStart");
    }
    j();
  }
  
  public void a(myc parammyc, int paramInt)
  {
    if (paramInt == 4) {
      this.jdField_a_of_type_Nam.d();
    }
    i(parammyc);
  }
  
  public void a(myc parammyc, String paramString)
  {
    this.jdField_a_of_type_Nbn.a(parammyc);
    this.jdField_a_of_type_Nbn.a(paramString);
  }
  
  public void a(myc parammyc, boolean paramBoolean)
  {
    GameRoomPresenterImp.4 local4 = new GameRoomPresenterImp.4(this);
    if (paramBoolean)
    {
      bjda.a().postDelayed(local4, 1560L);
      i(parammyc);
    }
    for (;;)
    {
      e();
      k(parammyc);
      l(parammyc);
      return;
      local4.run();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Player localPlayer = mxl.a().a().a();
    bcst.b(null, "dc00898", "", "", "0X800B035", "0X800B035", mxb.a().a(localPlayer) + 1, 0, "1", "", "", "");
    mxb.a().a(a(), paramBoolean, false);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "exitGameRoom svrAlreadyExit:" + paramBoolean);
    }
    this.jdField_a_of_type_Nam.f();
    mxl.a().a(paramBoolean, paramInt);
  }
  
  public boolean a(int paramInt, String paramString, myc parammyc)
  {
    QLog.i("GameRoomPresenterImp", 1, "onRoomSelfExit exitType:" + paramInt + " exitRoomTip:" + paramString + " engineData:" + parammyc);
    switch (paramInt)
    {
    case 0: 
    default: 
      a(true, paramInt);
      this.jdField_a_of_type_Nam.e();
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
      this.jdField_a_of_type_Nam.a(paramString, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      return true;
    case 5: 
    case 9: 
    case 10: 
    case 11: 
      a(false, paramInt);
      this.jdField_a_of_type_Nam.a(paramString, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      return true;
    }
    a(false, paramInt);
    this.jdField_a_of_type_Nam.e();
    return true;
  }
  
  public String b()
  {
    String str = "";
    myg localmyg = mxl.a().a().a();
    if (localmyg != null) {
      str = localmyg.d;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "getGamePrepareBgURL = " + str);
    }
    return str;
  }
  
  public List<AVGameUserInfo> b()
  {
    AVGameSession localAVGameSession = ndt.b().a();
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
    this.jdField_a_of_type_Nam.b(paramInt);
  }
  
  public void b(long paramLong, String paramString1, String paramString2) {}
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Nam.b(paramString);
  }
  
  public void b(String paramString, myc parammyc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "pushOnRoomEnter roomEnterTip = " + paramString);
    }
    a().h();
    a(paramString);
    i(parammyc);
  }
  
  public void b(myc parammyc)
  {
    if (!mxl.a().a()) {
      this.jdField_a_of_type_Nat.a(parammyc);
    }
  }
  
  public void b(myc parammyc, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "onAnswerRightPush scoreThisTime = " + paramInt);
    }
    this.jdField_a_of_type_Nbn.a(parammyc);
    this.jdField_a_of_type_Nbb.a(parammyc);
  }
  
  public void b(boolean paramBoolean)
  {
    e();
  }
  
  public List<Player> c()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(mxl.a().a().a().getPlayers());
    return localArrayList;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "destroy");
    }
    this.jdField_a_of_type_Nbb.b();
    this.jdField_a_of_type_Nbn.c();
    ndt.b().b(this.jdField_a_of_type_Mwx);
    mxl.a().b(this);
    mxl.a().b(this);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Naj != null)
    {
      mwu.a().b(this.jdField_a_of_type_Naj);
      this.jdField_a_of_type_Naj = null;
    }
  }
  
  public void c(String paramString, myc parammyc)
  {
    this.jdField_a_of_type_Nbn.a(paramString, parammyc);
  }
  
  public void c(myc parammyc)
  {
    this.jdField_a_of_type_Nam.b();
    i(parammyc);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    e();
    n(parammyc);
  }
  
  public void c(myc parammyc, int paramInt)
  {
    i(parammyc);
  }
  
  public void c(boolean paramBoolean)
  {
    e();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Nam.g();
  }
  
  public void d(String paramString, myc parammyc)
  {
    this.jdField_a_of_type_Nbn.b(paramString, parammyc);
  }
  
  public void d(myc parammyc)
  {
    this.jdField_a_of_type_Nbn.a(parammyc);
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_Nam.a(paramBoolean);
  }
  
  public void e(myc parammyc)
  {
    m(parammyc);
  }
  
  public void f(myc parammyc)
  {
    this.jdField_a_of_type_Nam.b();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    i(parammyc);
    e();
    neq.a().a().post(new GameRoomPresenterImp.5(this));
    n(parammyc);
  }
  
  public void g()
  {
    this.jdField_a_of_type_Nat.a(mxl.a().a());
  }
  
  public void g(myc parammyc)
  {
    i(parammyc);
    e();
    n(parammyc);
  }
  
  public void h()
  {
    if (!mxl.a().a()) {
      this.jdField_a_of_type_Nat.a(mxl.a().a());
    }
  }
  
  public void h(myc parammyc)
  {
    this.jdField_a_of_type_Nbn.a(parammyc);
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
          this.jdField_a_of_type_Nbb.a(mxl.a().a());
          return true;
          this.jdField_a_of_type_Nbn.a(mxl.a().a());
          return true;
          this.jdField_a_of_type_Nat.a(mxl.a().a());
          return true;
          this.jdField_a_of_type_Nat.a(mxl.a().a());
          this.jdField_a_of_type_Nbb.a(mxl.a().a());
          this.jdField_a_of_type_Nbn.a(mxl.a().a());
          return true;
          f();
          return true;
          j(mxl.a().a());
          a(0);
          f();
          return true;
        } while (leo.b() == 1);
        a(this.jdField_a_of_type_AndroidContentContext.getString(2131690304));
        bcst.b(null, "dc00898", "", "", "0X800B040", "0X800B040", 0, 0, "", "", "", "");
        return true;
      } while ((this.jdField_a_of_type_AndroidContentContext == null) || (!(this.jdField_a_of_type_AndroidContentContext instanceof AVGameActivity)));
      paramMessage = (AVGameActivity)this.jdField_a_of_type_AndroidContentContext;
    } while (paramMessage.c());
    for (;;)
    {
      int j;
      try
      {
        if ((paramMessage.c()) || (ndt.b().a() != 1)) {
          break label349;
        }
        i = 1;
        j = k;
        if (ndt.b().a() != 0) {
          break label354;
        }
        j = k;
        if (ndt.b().b()) {
          break label354;
        }
        j = 1;
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
        return true;
      }
      a(this.jdField_a_of_type_AndroidContentContext.getString(2131690209));
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
    if (!mxl.a().a()) {
      this.jdField_a_of_type_Nat.a(mxl.a().a());
    }
  }
  
  public void i(myc parammyc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "refreshAll engineData:" + parammyc);
    }
    this.jdField_a_of_type_Nbb.a(parammyc);
    this.jdField_a_of_type_Nat.a(parammyc);
    this.jdField_a_of_type_Nbn.a(parammyc);
    j(parammyc);
    a(50);
  }
  
  public void j(myc parammyc)
  {
    Object localObject2 = null;
    int i = parammyc.a();
    Player localPlayer1;
    Object localObject1;
    if ((i != 0) && (i != 10))
    {
      Player localPlayer2 = parammyc.b();
      localPlayer1 = localPlayer2;
      localObject1 = localObject2;
      if (localPlayer2 != null)
      {
        localPlayer1 = localPlayer2;
        localObject1 = localObject2;
        if (parammyc.b(localPlayer2.uin))
        {
          localObject1 = localPlayer2.uin;
          localPlayer1 = localPlayer2;
        }
      }
    }
    for (;;)
    {
      QLog.i("GameRoomPresenterImp", 1, "playerBigVideoChanged player:" + localPlayer1 + "  gameStatus:" + i + "  gameType:" + parammyc.c());
      this.jdField_a_of_type_Ndc.a((String)localObject1);
      return;
      localPlayer1 = null;
      localObject1 = localObject2;
    }
  }
  
  public void k(myc parammyc)
  {
    int i = parammyc.a();
    int j = parammyc.c();
    if (j == 3) {
      a(i, j, parammyc);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameRoomPresenterImp", 2, "onNeedCheckAndPlayAudioVideo gameStatus:" + i + " gameType:" + j);
      }
      return;
      if (j == 4) {
        b(i, j, parammyc);
      }
    }
  }
  
  public void l(myc parammyc)
  {
    parammyc = ndt.b().a();
    if (parammyc != null) {
      parammyc.a();
    }
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "onNeedCheckAndReleaseAudioVideo");
    }
  }
  
  public void m(myc parammyc)
  {
    int i = parammyc.a();
    int j = parammyc.c();
    if ((i != 0) && (i != 10)) {
      if (j == 3) {
        c(i, j, parammyc);
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (j != 4);
      d(i, j, parammyc);
      return;
    }
    QLog.i("GameRoomPresenterImp", 2, "onNeedCheckAndPreloadAudioVideo gameStatus:" + i + " gameType:" + j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nag
 * JD-Core Version:    0.7.0.1
 */