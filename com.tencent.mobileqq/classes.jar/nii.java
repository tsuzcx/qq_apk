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
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.avgame.gameroom.GameRoomPresenterImp.3;
import com.tencent.avgame.gameroom.GameRoomPresenterImp.4;
import com.tencent.avgame.gameroom.GameRoomPresenterImp.6;
import com.tencent.avgame.gameroom.GameRoomPresenterImp.7;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.avgame.ui.AVGameActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class nii
  implements Handler.Callback, ngx, ngy, nio
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  protected Context a;
  protected DialogInterface.OnClickListener a;
  public Handler a;
  public Runnable a;
  protected ndt a;
  protected nim a;
  public nip a;
  protected njj a;
  protected njl a;
  protected njs a;
  protected nju a;
  public nky a;
  protected nkz a;
  protected nmu a;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  
  public nii(nip paramnip)
  {
    this.jdField_a_of_type_Ndt = new nij(this);
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = new nik(this);
    this.jdField_a_of_type_JavaLangRunnable = new GameRoomPresenterImp.3(this);
    this.jdField_a_of_type_Nip = paramnip;
  }
  
  private void a(int paramInt1, int paramInt2, nfv paramnfv)
  {
    Object localObject1;
    if ((paramInt1 != 0) && (paramInt1 != 10) && (paramInt2 == 3))
    {
      localObject1 = paramnfv.a();
      if ((localObject1 == null) || (!(localObject1 instanceof ngh))) {}
    }
    for (ngh localngh = (ngh)localObject1;; localngh = null)
    {
      Object localObject2 = null;
      boolean bool2 = false;
      boolean bool1 = false;
      nnw localnnw = nnm.b().a();
      long l1;
      if ((localngh != null) && (!TextUtils.isEmpty(localngh.a.jdField_a_of_type_JavaLangString)))
      {
        bool2 = bool1;
        localObject1 = localObject2;
        if (localnnw != null)
        {
          localObject1 = localngh.a.jdField_a_of_type_JavaLangString;
          localnnw.a(false);
          if ((paramInt1 == 3) || (paramInt1 == 4)) {
            break label342;
          }
          long l2 = paramnfv.a().d();
          l1 = l2;
          if (l2 > localngh.a.jdField_a_of_type_Int * 1000) {
            l1 = 0L;
          }
          if ((localnnw.a()) && (TextUtils.equals((CharSequence)localObject1, localnnw.a()))) {
            break label268;
          }
          if (l1 <= 500L) {
            break label257;
          }
          localnnw.b((String)localObject1, l1);
          bool2 = bool1;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("GameRoomPresenterImp", 2, "playStarGuessVideo topic:" + localngh + " url:" + (String)localObject1 + " stop:" + bool2 + " gameStatus:" + paramInt1);
        }
        return;
        label257:
        localnnw.b((String)localObject1, 0L);
        break;
        label268:
        if (l1 - localnnw.a() <= 500L) {
          break;
        }
        break;
        bool1 = bool2;
        if (localnnw != null)
        {
          localnnw.b();
          localnnw.c();
          bool1 = true;
        }
        bool2 = bool1;
        localObject1 = localObject2;
        if (paramInt2 == 3)
        {
          this.jdField_a_of_type_Nmu.a(false);
          bool2 = bool1;
          localObject1 = localObject2;
          continue;
          label342:
          bool2 = bool1;
        }
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2, nfv paramnfv)
  {
    Object localObject2 = null;
    boolean bool2 = false;
    if ((paramInt1 != 0) && (paramInt1 != 10) && (paramInt2 == 4))
    {
      localObject1 = paramnfv.a();
      if ((localObject1 == null) || (!(localObject1 instanceof ngi))) {}
    }
    for (Object localObject1 = (ngi)localObject1;; localObject1 = null)
    {
      nnw localnnw = nnm.b().a();
      if ((localObject1 != null) && (!TextUtils.isEmpty(((ngi)localObject1).a.jdField_a_of_type_JavaLangString)))
      {
        bool1 = bool2;
        String str;
        long l1;
        if (localnnw != null)
        {
          str = ((ngi)localObject1).a.jdField_a_of_type_JavaLangString;
          localnnw.a(false);
          localObject2 = str;
          bool1 = bool2;
          if (paramInt1 != 3)
          {
            localObject2 = str;
            bool1 = bool2;
            if (paramInt1 != 4)
            {
              long l2 = paramnfv.a().d();
              l1 = l2;
              if (l2 > ((ngi)localObject1).a.jdField_a_of_type_Int * 1000) {
                l1 = 0L;
              }
              if ((localnnw.a()) && (TextUtils.equals(str, localnnw.a()))) {
                break label289;
              }
              if (l1 <= 500L) {
                break label270;
              }
              localnnw.a(str, l1);
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
          localnnw.a(str, 0L);
          localObject2 = str;
          bool1 = bool2;
          continue;
          label289:
          localObject2 = str;
          bool1 = bool2;
          if (l1 - localnnw.a() > 500L)
          {
            localObject2 = str;
            bool1 = bool2;
          }
        }
      }
      if (localnnw != null)
      {
        localnnw.b();
        localnnw.c();
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramInt2 == 4) {}
        break;
      }
    }
  }
  
  private void c(int paramInt1, int paramInt2, nfv paramnfv)
  {
    Object localObject1 = null;
    if ((paramInt1 != 0) && (paramInt1 != 10) && (paramInt2 == 3))
    {
      localObject1 = paramnfv.a();
      if ((localObject1 != null) && ((localObject1 instanceof ngh)))
      {
        localObject1 = (ngh)localObject1;
        paramnfv = paramnfv.b();
      }
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      nnw localnnw = nnm.b().a();
      if ((localObject1 != null) && (localnnw != null))
      {
        nnv localnnv = new nnv();
        localnnv.jdField_a_of_type_JavaLangString = ((ngh)localObject1).a.jdField_a_of_type_JavaLangString;
        localnnv.jdField_a_of_type_Long = (((ngh)localObject1).a.jdField_a_of_type_Int * 1000);
        localnnv.b = ((ngh)localObject1).a.b;
        localArrayList.add(localnnv);
        if ((paramnfv != null) && (!paramnfv.isEmpty()))
        {
          paramInt1 = 0;
          while (paramInt1 < paramnfv.size())
          {
            Object localObject2 = (nfh)paramnfv.get(paramInt1);
            if ((localObject2 != null) && ((localObject2 instanceof ngh)))
            {
              localnnv = new nnv();
              localObject2 = (ngh)localObject2;
              localnnv.jdField_a_of_type_JavaLangString = ((ngh)localObject2).a.jdField_a_of_type_JavaLangString;
              localnnv.b = ((ngh)localObject2).a.b;
              localnnv.jdField_a_of_type_Long = (((ngh)localObject2).a.jdField_a_of_type_Int * 1000);
              localArrayList.add(localnnv);
            }
            paramInt1 += 1;
          }
        }
        localnnw.a(localArrayList);
      }
      if (QLog.isColorLevel()) {
        QLog.i("GameRoomPresenterImp", 2, "onNeedCheckAndPreloadAudioVideo  PreloadVideo videoTopic:" + localObject1 + " files:" + localArrayList);
      }
      return;
      localObject1 = null;
      break;
      localArrayList = null;
      paramnfv = (nfv)localObject1;
      localObject1 = localArrayList;
    }
  }
  
  private void d(int paramInt1, int paramInt2, nfv paramnfv)
  {
    Object localObject1 = null;
    if ((paramInt1 != 0) && (paramInt1 != 10) && (paramInt2 == 4))
    {
      localObject1 = paramnfv.a();
      if ((localObject1 != null) && ((localObject1 instanceof ngi)))
      {
        localObject1 = (ngi)localObject1;
        paramnfv = paramnfv.b();
      }
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      nnw localnnw = nnm.b().a();
      if ((localObject1 != null) && (localnnw != null))
      {
        nnv localnnv = new nnv();
        localnnv.jdField_a_of_type_JavaLangString = ((ngi)localObject1).a.jdField_a_of_type_JavaLangString;
        localnnv.jdField_a_of_type_Long = (((ngi)localObject1).a.jdField_a_of_type_Int * 1000);
        localArrayList.add(localnnv);
        if ((paramnfv != null) && (!paramnfv.isEmpty()))
        {
          paramInt1 = 0;
          while (paramInt1 < paramnfv.size())
          {
            Object localObject2 = (nfh)paramnfv.get(paramInt1);
            if ((localObject2 != null) && ((localObject2 instanceof ngi)))
            {
              localnnv = new nnv();
              localObject2 = (ngi)localObject2;
              localnnv.jdField_a_of_type_JavaLangString = ((ngi)localObject2).a.jdField_a_of_type_JavaLangString;
              localnnv.jdField_a_of_type_Long = (((ngi)localObject2).a.jdField_a_of_type_Int * 1000);
              localArrayList.add(localnnv);
            }
            paramInt1 += 1;
          }
        }
        localnnw.a(localArrayList);
      }
      if (QLog.isColorLevel()) {
        QLog.i("GameRoomPresenterImp", 2, "onNeedCheckAndPreloadAudioVideo PreloadAudio videoTopic:" + localObject1 + " files:" + localArrayList);
      }
      return;
      localObject1 = null;
      break;
      localArrayList = null;
      paramnfv = (nfv)localObject1;
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
    Object localObject1 = nfc.a().a();
    int i = ((nfv)localObject1).a();
    boolean bool1 = ((nfv)localObject1).c();
    Player localPlayer = ((nfv)localObject1).a();
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
      localObject1 = ((nfv)localObject1).b();
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
      localObject2 = nnm.b().a();
      bool6 = bool1;
      if (localObject2 != null) {
        bool6 = ((nof)localObject2).e;
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
          a(1, this.jdField_a_of_type_AndroidContentContext.getString(2131690287));
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
        a(1, this.jdField_a_of_type_AndroidContentContext.getString(2131690288));
        continue;
        label659:
        if ((bool6) && (!this.jdField_b_of_type_Boolean))
        {
          this.jdField_a_of_type_Boolean = true;
          a(this.jdField_a_of_type_AndroidContentContext.getString(2131690284), 3000);
          bool1 = bool7;
        }
        else if ((bool6) && (!this.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_Boolean = true;
          a(this.jdField_a_of_type_AndroidContentContext.getString(2131690284));
          bool1 = bool7;
        }
        else if ((bool4) && (this.jdField_b_of_type_Long != localAVGameUserInfo2.mUin))
        {
          this.jdField_b_of_type_Long = localAVGameUserInfo2.mUin;
          a(this.jdField_a_of_type_AndroidContentContext.getString(2131690285));
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
              a(this.jdField_a_of_type_AndroidContentContext.getString(2131690286));
              bool1 = bool7;
            }
          }
        }
      }
    }
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "startRefreshGameListRunnable()");
    }
    l();
    long l = nfc.a().a();
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "startRefreshGameListRunnable() nextRefreshTimeInterval = " + l);
    }
    if (l != 9223372036854775807L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameRoomPresenterImp", 2, "startRefreshGameListRunnable() postRunnable and nextRefreshTimeInterval = " + l);
      }
      bjum.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, l * 1000L + 2000L);
    }
  }
  
  private void l()
  {
    bjum.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private void m()
  {
    nfc.a().f();
  }
  
  private void n(nfv paramnfv)
  {
    Object localObject = paramnfv.a().d;
    if (localObject == null) {}
    while (nfc.a().a().getCurrentAccountUin().equals(((Player)localObject).uin)) {
      return;
    }
    boolean bool = nqc.a();
    nqc localnqc = nqc.a();
    String str1 = paramnfv.a().a().a();
    String str2 = paramnfv.b();
    String str3 = ((Player)localObject).uin;
    if (bool) {}
    for (localObject = nqc.a().a();; localObject = "")
    {
      localnqc.a(bool, "others", str1, 0L, str2, str3, (String)localObject, paramnfv.a());
      return;
    }
  }
  
  private void o(nfv paramnfv)
  {
    Player localPlayer;
    int i;
    if ((paramnfv.c() == 1) && (System.currentTimeMillis() - this.jdField_a_of_type_Long > 3000L))
    {
      localPlayer = paramnfv.a();
      paramnfv = paramnfv.b();
      if ((localPlayer == null) || (paramnfv == null) || (!TextUtils.equals(localPlayer.uin, paramnfv.uin))) {
        break label177;
      }
      i = 1;
      if (localPlayer == null) {
        break label182;
      }
    }
    label177:
    label182:
    for (paramnfv = a(localPlayer.uin);; paramnfv = null)
    {
      if ((i != 0) && (paramnfv != null))
      {
        if (!paramnfv.hasVideo()) {
          bdla.b(null, "dc00898", "", "", "0X800B03E", "0X800B03E", 0, 0, "", "", "", "");
        }
        paramnfv = nnm.b().a();
        if ((paramnfv != null) && (paramnfv.e)) {
          bdla.b(null, "dc00898", "", "", "0X800B03F", "0X800B03F", 0, 0, "", "", "", "");
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
    return this.jdField_a_of_type_Nip.a();
  }
  
  public RectF a()
  {
    return this.jdField_a_of_type_Nju.a();
  }
  
  public AVGameUserInfo a(String paramString)
  {
    nof localnof = nnm.b().a();
    if (localnof != null) {
      return localnof.a(Long.valueOf(paramString).longValue());
    }
    return null;
  }
  
  public String a()
  {
    String str = "";
    nga localnga = nfc.a().a().a();
    if (localnga != null) {
      str = localnga.e;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "getGamePrepareTransparentBgURL = " + str);
    }
    return str;
  }
  
  public List<niq> a()
  {
    List localList = b();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.jdField_a_of_type_Nju.b();
    if (localObject1 != null) {
      localArrayList.addAll((Collection)localObject1);
    }
    RectF localRectF = this.jdField_a_of_type_Nky.a();
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
        localObject2 = (niq)localArrayList.get(i);
        if (((niq)localObject2).jdField_b_of_type_Boolean)
        {
          ((niq)localObject2).jdField_a_of_type_Int = Math.round(localRectF.left);
          ((niq)localObject2).jdField_b_of_type_Int = Math.round(localRectF.top);
          ((niq)localObject2).jdField_c_of_type_Int = Math.round(localRectF.width());
          ((niq)localObject2).d = Math.round(localRectF.height());
          localObject1 = localObject2;
        }
        if (((niq)localObject2).jdField_c_of_type_Boolean)
        {
          ((niq)localObject2).f = Math.round(localRectF.left);
          ((niq)localObject2).g = Math.round(localRectF.top);
          ((niq)localObject2).h = Math.round(localRectF.width());
          ((niq)localObject2).i = Math.round(localRectF.height());
        }
        i += 1;
      }
    }
    QLog.i("GameRoomPresenterImp", 1, "getMemberVideoDisplayInfoList bigVideoInfo:" + localObject2 + "  playingRect:" + localRectF + " displayList:" + localArrayList + " aVList:" + localList);
    return localArrayList;
  }
  
  public nip a()
  {
    return this.jdField_a_of_type_Nip;
  }
  
  public njl a()
  {
    return this.jdField_a_of_type_Njl;
  }
  
  public nju a()
  {
    return this.jdField_a_of_type_Nju;
  }
  
  public nkz a()
  {
    return this.jdField_a_of_type_Nkz;
  }
  
  public void a()
  {
    nfv localnfv = nfc.a().a();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(6);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(7, 1000L);
    m(localnfv);
    k(localnfv);
    k();
    QLog.i("GameRoomPresenterImp", 1, "onFragmentStart");
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 0L);
      return;
    }
    this.jdField_a_of_type_Nip.a(a());
    this.jdField_a_of_type_Nky.b(nfc.a().a());
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Nip.b(paramInt, paramString);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, nfv paramnfv)
  {
    QLog.i("GameRoomPresenterImp", 1, "onRoomOtherMemberExit exitType:" + paramInt + " kickUin:" + paramString1 + " exitRoomTip:" + paramString2 + " engineData:" + paramnfv);
    if (3 == paramInt) {
      this.jdField_a_of_type_Nip.a(paramString2, null);
    }
    for (;;)
    {
      i(paramnfv);
      a(-1);
      return;
      a(paramString2);
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Nip != null) {
      this.jdField_a_of_type_Nip.a(paramLong, paramInt, paramString1, paramString2);
    }
    nfv localnfv = nfc.a().a();
    String str3 = "";
    String str2 = "";
    Object localObject1 = str2;
    if (paramString2 != null) {
      localObject1 = str2;
    }
    for (;;)
    {
      try
      {
        int i = paramString2.lastIndexOf("]");
        Object localObject2 = str2;
        str1 = str3;
        if (i >= 0)
        {
          localObject1 = str2;
          str2 = paramString2.substring(i + 2);
          localObject1 = str2;
          str1 = paramString2.substring(0, i + 1);
          localObject1 = str2;
          i = str1.indexOf("[");
          localObject1 = str2;
          int j = str1.indexOf("]");
          localObject2 = str2;
          str1 = str3;
          if (i >= 0)
          {
            localObject2 = str2;
            str1 = str3;
            if (j >= 0)
            {
              localObject2 = str2;
              str1 = str3;
              if (i < j)
              {
                localObject1 = str2;
                paramString2 = paramString2.substring(i + 1, j);
                localObject2 = str2;
                str1 = str3;
                if (paramString2 != null)
                {
                  localObject1 = str2;
                  paramString2 = paramString2.split("\\|");
                  localObject2 = str2;
                  str1 = str3;
                  if (paramString2 != null)
                  {
                    localObject2 = str2;
                    str1 = str3;
                    localObject1 = str2;
                    if (paramString2.length > 0)
                    {
                      str1 = paramString2[0];
                      localObject2 = str2;
                    }
                  }
                }
              }
            }
          }
        }
        paramString2 = (String)localObject2;
        localObject1 = str1;
        localObject2 = nqc.a();
        if (localnfv.a().a() == null) {
          break label345;
        }
        str1 = localnfv.a().a().a();
        ((nqc)localObject2).a(false, paramString2, str1, paramInt, paramString1, String.valueOf(paramLong), (String)localObject1, localnfv.a());
        return;
      }
      catch (Exception paramString2)
      {
        paramString2.printStackTrace();
      }
      paramString2 = (String)localObject1;
      localObject1 = "";
      continue;
      label345:
      String str1 = "";
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Nip.a(paramLong1, paramLong2);
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Nip.a(1, paramString2);
  }
  
  public void a(long paramLong, String paramString1, boolean paramBoolean, String paramString2, int paramInt)
  {
    i(nfc.a().a());
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    nfv localnfv = nfc.a().a();
    this.jdField_a_of_type_Njj.a(localnfv);
    this.jdField_a_of_type_Nju.a(localnfv);
  }
  
  public void a(Context paramContext, njj paramnjj, nky paramnky, nju paramnju, njl paramnjl, nmu paramnmu, nkz paramnkz, njs paramnjs)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Njj = paramnjj;
    this.jdField_a_of_type_Nky = paramnky;
    this.jdField_a_of_type_Nju = paramnju;
    this.jdField_a_of_type_Njl = paramnjl;
    this.jdField_a_of_type_Nmu = paramnmu;
    this.jdField_a_of_type_Nkz = paramnkz;
    this.jdField_a_of_type_Njs = paramnjs;
    nfc.a().a(this);
    nfc.a().a(this);
    nnm.b().a(this.jdField_a_of_type_Ndt);
    if (this.jdField_a_of_type_Nim == null)
    {
      this.jdField_a_of_type_Nim = new nim(this.jdField_a_of_type_AndroidOsHandler);
      ndq.a().a(this.jdField_a_of_type_Nim, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "init");
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Nip.a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Nip.a(paramString, paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 3) && ((paramInt1 == 113) || (paramInt1 == 109)))
    {
      paramString = a().getResources().getString(2131690489);
      this.jdField_a_of_type_Nip.a(1, paramString);
    }
  }
  
  public void a(String paramString, int paramInt, nfv paramnfv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "pushOnChangeUserStatus uin = " + paramString);
    }
    if ((paramString.equals(nfc.a().a().getAccount())) && (paramInt == 1))
    {
      this.jdField_a_of_type_Nip.d();
      this.jdField_a_of_type_Nmu.b(false);
    }
    i(paramnfv);
  }
  
  public void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "onGameStartFail uin:" + paramString1 + " gameType:" + paramInt1 + " roomId:" + paramLong + " errorCode " + paramInt2 + " errMsg:" + paramString2);
    }
    if (paramInt2 == 404)
    {
      paramString1 = a().getResources().getString(2131690323);
      this.jdField_a_of_type_Nip.a(paramString1, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_Nky.a(nfc.a().a());
      return;
      if (paramInt2 == 405)
      {
        paramString1 = a().getResources().getString(2131690482);
        this.jdField_a_of_type_Nip.a(1, paramString1);
        i(nfc.a().a());
      }
      else if ((paramInt2 == 406) && (paramString2 != null) && (paramString2.length() > 0))
      {
        this.jdField_a_of_type_Nip.a(paramString2, null);
      }
      else
      {
        this.jdField_a_of_type_Nip.a(1, "开始游戏失败");
      }
    }
  }
  
  public void a(String paramString, nfv paramnfv)
  {
    i(paramnfv);
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    this.jdField_a_of_type_Nju.a(nfc.a().a());
  }
  
  public void a(nfv paramnfv)
  {
    this.jdField_a_of_type_Njj.a(paramnfv);
    nqc.a().a("param_StepGameReady", 0);
    if (this.jdField_a_of_type_Njj.a()) {
      nqc.a().a("param_StepGameCanStart");
    }
    k();
  }
  
  public void a(nfv paramnfv, int paramInt)
  {
    if (paramInt == 4)
    {
      this.jdField_a_of_type_Nip.d();
      this.jdField_a_of_type_Nmu.b(false);
    }
    i(paramnfv);
    QLog.d("GameRoomPresenterImp", 2, "onChangeUserStatusSuccess");
    ThreadManager.excute(new GameRoomPresenterImp.4(this), 16, null, false);
  }
  
  public void a(nfv paramnfv, String paramString)
  {
    this.jdField_a_of_type_Nky.a(paramnfv);
    this.jdField_a_of_type_Nky.a(paramString, paramnfv.c());
  }
  
  public void a(nfv paramnfv, boolean paramBoolean)
  {
    nqc.a().a(false, paramnfv.a());
    if (paramnfv.e())
    {
      e(false);
      k(paramnfv);
      l(paramnfv);
      return;
    }
    GameRoomPresenterImp.6 local6 = new GameRoomPresenterImp.6(this);
    if (paramBoolean)
    {
      bjum.a().postDelayed(local6, 1560L);
      i(paramnfv);
    }
    for (;;)
    {
      e();
      k(paramnfv);
      l(paramnfv);
      return;
      local6.run();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Player localPlayer = nfc.a().a().a();
    bdla.b(null, "dc00898", "", "", "0X800B035", "0X800B035", ndx.a().a(localPlayer) + 1, 0, "1", "", "", "");
    ndx.a().a(a(), paramBoolean, false);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "exitGameRoom svrAlreadyExit:" + paramBoolean);
    }
    if (paramInt != 3) {
      m();
    }
    this.jdField_a_of_type_Nip.f();
    nfc.a().a(paramBoolean, paramInt);
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Nmu.b(false);
      this.jdField_a_of_type_Njs.a(nfc.a().a());
      return;
    }
    String str = paramString;
    if (paramInt != 650) {
      if (paramInt != 651) {
        break label95;
      }
    }
    label95:
    for (str = paramString;; str = null)
    {
      paramString = str;
      if (TextUtils.isEmpty(str)) {
        paramString = this.jdField_a_of_type_AndroidContentContext.getString(2131690333);
      }
      nfc.a().a(false, 1);
      this.jdField_a_of_type_Nip.a(paramString, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong)
  {
    this.jdField_a_of_type_Nju.a(nfc.a().a());
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, SurvivalPkResultInfo paramSurvivalPkResultInfo)
  {
    paramSurvivalPkResultInfo = nfc.a().a();
    this.jdField_a_of_type_Nju.a(paramSurvivalPkResultInfo);
    this.jdField_a_of_type_Nky.a(paramSurvivalPkResultInfo);
    this.jdField_a_of_type_Njs.a(paramSurvivalPkResultInfo);
    paramInt = paramSurvivalPkResultInfo.n();
    if ((paramInt == 6) || (paramInt == 7)) {
      this.jdField_a_of_type_Nip.c();
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    if (paramBoolean)
    {
      paramString = nfc.a().a();
      this.jdField_a_of_type_Njj.a(paramString);
      this.jdField_a_of_type_Nju.a(paramString);
      return;
    }
    if (paramInt2 == 601) {}
    for (;;)
    {
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = this.jdField_a_of_type_AndroidContentContext.getString(2131690444);
      }
      this.jdField_a_of_type_Nip.a(str, null);
      return;
      paramString = null;
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString)
  {
    paramString = nfc.a().a();
    this.jdField_a_of_type_Njj.a(paramString);
    this.jdField_a_of_type_Nju.a(paramString);
  }
  
  public boolean a(int paramInt, String paramString, nfv paramnfv)
  {
    QLog.i("GameRoomPresenterImp", 1, "onRoomSelfExit exitType:" + paramInt + " exitRoomTip:" + paramString + " engineData:" + paramnfv);
    switch (paramInt)
    {
    case 0: 
    case 12: 
    default: 
      a(true, paramInt);
      this.jdField_a_of_type_Nip.e();
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
      this.jdField_a_of_type_Nip.a(paramString, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      return true;
    case 5: 
    case 9: 
    case 10: 
    case 11: 
      a(false, paramInt);
      this.jdField_a_of_type_Nip.a(paramString, this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener);
      return true;
    case 8: 
      a(false, paramInt);
      this.jdField_a_of_type_Nip.e();
      return true;
    }
    paramnfv = paramString;
    if (paramString == null) {
      paramnfv = this.jdField_a_of_type_AndroidContentContext.getString(2131690405);
    }
    this.jdField_a_of_type_Nip.a(paramnfv, new nil(this));
    return true;
  }
  
  public String b()
  {
    String str = "";
    nga localnga = nfc.a().a().a();
    if (localnga != null) {
      str = localnga.d;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "getGamePrepareBgURL = " + str);
    }
    return str;
  }
  
  public List<AVGameUserInfo> b()
  {
    nof localnof = nnm.b().a();
    ArrayList localArrayList = new ArrayList();
    if (localnof != null) {
      localnof.b(localArrayList);
    }
    return localArrayList;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(7);
    l();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Nip.b(paramInt);
  }
  
  public void b(long paramLong, String paramString1, String paramString2) {}
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Nip.b(paramString);
  }
  
  public void b(String paramString, nfv paramnfv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "pushOnRoomEnter roomEnterTip = " + paramString);
    }
    a().h();
    a(paramString);
    i(paramnfv);
    if ((paramnfv.d()) && (paramnfv.a(paramnfv.e(nfc.a().a().getCurrentAccountUin()))))
    {
      m();
      a(a().getResources().getString(2131690380));
    }
  }
  
  public void b(nfv paramnfv)
  {
    if (!nfc.a().a()) {
      this.jdField_a_of_type_Njj.a(paramnfv);
    }
  }
  
  public void b(nfv paramnfv, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "onAnswerRightPush scoreThisTime = " + paramInt);
    }
    this.jdField_a_of_type_Nky.a(paramnfv);
    this.jdField_a_of_type_Nju.a(paramnfv);
    n(paramnfv);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_Njs != null) {
        this.jdField_a_of_type_Njs.a(nfc.a().a());
      }
      this.jdField_a_of_type_Nju.a(nfc.a().a());
    }
  }
  
  public void b(boolean paramBoolean, int paramInt, String paramString, RoomInfo paramRoomInfo, byte[] paramArrayOfByte, long paramLong)
  {
    this.jdField_a_of_type_Nju.a(nfc.a().a());
  }
  
  public List<Player> c()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(nfc.a().a().a().getPlayers());
    return localArrayList;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "destroy");
    }
    this.jdField_a_of_type_Nju.b();
    this.jdField_a_of_type_Nky.c();
    nnm.b().b(this.jdField_a_of_type_Ndt);
    nfc.a().b(this);
    nfc.a().b(this);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Nim != null)
    {
      ndq.a().b(this.jdField_a_of_type_Nim);
      this.jdField_a_of_type_Nim = null;
    }
  }
  
  public void c(String paramString, nfv paramnfv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "onPushMemberEnterForPk  " + paramString);
    }
    String str = nfc.a().a().getCurrentAccountUin();
    if ((paramnfv.e(str)) && (!str.equals(paramString)))
    {
      boolean bool = nnm.b().c();
      paramString = this.jdField_a_of_type_AndroidOsHandler;
      if (!bool) {
        break label102;
      }
    }
    label102:
    for (long l = 1000L;; l = 2000L)
    {
      paramString.sendEmptyMessageDelayed(10, l);
      this.jdField_a_of_type_Nju.a(paramnfv);
      return;
    }
  }
  
  public void c(nfv paramnfv)
  {
    this.jdField_a_of_type_Nip.b();
    i(paramnfv);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    m();
    e();
    o(paramnfv);
    this.jdField_a_of_type_Nmu.b(true);
    nqc.a().a(true, paramnfv.a());
  }
  
  public void c(nfv paramnfv, int paramInt)
  {
    i(paramnfv);
  }
  
  public void c(boolean paramBoolean)
  {
    e();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Nip.g();
  }
  
  public void d(String paramString, nfv paramnfv)
  {
    this.jdField_a_of_type_Nky.a(paramString, paramnfv);
  }
  
  public void d(nfv paramnfv)
  {
    this.jdField_a_of_type_Nky.a(paramnfv);
  }
  
  public void d(boolean paramBoolean)
  {
    e();
  }
  
  public void e(String paramString, nfv paramnfv)
  {
    this.jdField_a_of_type_Nky.b(paramString, paramnfv);
  }
  
  public void e(nfv paramnfv)
  {
    m(paramnfv);
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_Nip.a(paramBoolean);
  }
  
  public void f(nfv paramnfv)
  {
    this.jdField_a_of_type_Nip.b();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
    i(paramnfv);
    e();
    nom.a().a().post(new GameRoomPresenterImp.7(this));
    o(paramnfv);
    this.jdField_a_of_type_Nmu.b(true);
    m();
    nqc.a().a(true, paramnfv.a());
  }
  
  public void g()
  {
    this.jdField_a_of_type_Njj.a(nfc.a().a());
  }
  
  public void g(nfv paramnfv)
  {
    i(paramnfv);
    e();
    o(paramnfv);
  }
  
  public void h()
  {
    if (!nfc.a().a()) {
      this.jdField_a_of_type_Njj.a(nfc.a().a());
    }
  }
  
  public void h(nfv paramnfv)
  {
    this.jdField_a_of_type_Nky.a(paramnfv);
    boolean bool = nqc.a();
    nqc localnqc = nqc.a();
    String str2 = paramnfv.a().a().a();
    String str3 = paramnfv.b();
    String str4 = nfc.a().a().getCurrentAccountUin();
    if (bool) {}
    for (String str1 = nqc.a().a();; str1 = "")
    {
      localnqc.a(bool, "timeout", str2, 0L, str3, str4, str1, paramnfv.a());
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int k = 0;
    QLog.d("lgx", 2, "GameRoomPresenterImp handleMessage " + paramMessage.what);
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
      do
      {
        do
        {
          do
          {
            return true;
            a(-1);
            return true;
            this.jdField_a_of_type_Nju.a(nfc.a().a());
            return true;
            this.jdField_a_of_type_Nky.a(nfc.a().a());
            return true;
            this.jdField_a_of_type_Njj.a(nfc.a().a());
            return true;
            this.jdField_a_of_type_Njj.a(nfc.a().a());
            this.jdField_a_of_type_Nju.a(nfc.a().a());
            this.jdField_a_of_type_Nky.a(nfc.a().a());
            return true;
            f();
            return true;
            j(nfc.a().a());
            a(0);
            f();
            return true;
          } while (leu.b() == 1);
          a(this.jdField_a_of_type_AndroidContentContext.getString(2131690386));
          bdla.b(null, "dc00898", "", "", "0X800B040", "0X800B040", 0, 0, "", "", "", "");
          return true;
        } while ((this.jdField_a_of_type_AndroidContentContext == null) || (!(this.jdField_a_of_type_AndroidContentContext instanceof AVGameActivity)));
        paramMessage = (AVGameActivity)this.jdField_a_of_type_AndroidContentContext;
      } while (paramMessage.c());
    }
    for (;;)
    {
      int j;
      try
      {
        if ((paramMessage.c()) || (nnm.b().a() != 1)) {
          break label385;
        }
        i = 1;
        j = k;
        if (nnm.b().a() != 0) {
          break label401;
        }
        j = k;
        if (nnm.b().b()) {
          break label401;
        }
        j = 1;
      }
      catch (Exception paramMessage)
      {
        paramMessage.printStackTrace();
        return true;
      }
      a(this.jdField_a_of_type_AndroidContentContext.getString(2131690282));
      return true;
      label385:
      int i = 0;
      continue;
      nfc.a().a(0, null);
      return true;
      label401:
      if (i == 0) {
        if (j == 0) {
          break;
        }
      }
    }
  }
  
  public void i()
  {
    if (!nfc.a().a()) {
      this.jdField_a_of_type_Njj.a(nfc.a().a());
    }
  }
  
  public void i(nfv paramnfv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomPresenterImp", 2, "refreshAll engineData:" + paramnfv);
    }
    this.jdField_a_of_type_Nju.a(paramnfv);
    this.jdField_a_of_type_Njj.a(paramnfv);
    if (this.jdField_a_of_type_Nky != null) {
      this.jdField_a_of_type_Nky.a(paramnfv);
    }
    if (this.jdField_a_of_type_Njs != null) {
      this.jdField_a_of_type_Njs.a(paramnfv);
    }
    j(paramnfv);
    a(50);
  }
  
  public void j()
  {
    QLog.d("GameRoomPresenterImp", 2, "onPkMatchTimeout");
    this.jdField_a_of_type_Nip.a(this.jdField_a_of_type_AndroidContentContext.getString(2131690406), null);
  }
  
  public void j(nfv paramnfv)
  {
    Object localObject2 = null;
    int i = paramnfv.a();
    Player localPlayer1;
    Object localObject1;
    if ((i != 0) && (i != 10))
    {
      Player localPlayer2 = paramnfv.b();
      localPlayer1 = localPlayer2;
      localObject1 = localObject2;
      if (localPlayer2 != null)
      {
        localPlayer1 = localPlayer2;
        localObject1 = localObject2;
        if (paramnfv.b(localPlayer2.uin))
        {
          localObject1 = localPlayer2.uin;
          localPlayer1 = localPlayer2;
        }
      }
    }
    for (;;)
    {
      QLog.i("GameRoomPresenterImp", 1, "playerBigVideoChanged player:" + localPlayer1 + "  gameStatus:" + i + "  gameType:" + paramnfv.c());
      this.jdField_a_of_type_Nmu.a((String)localObject1);
      return;
      localPlayer1 = null;
      localObject1 = localObject2;
    }
  }
  
  public void k(nfv paramnfv)
  {
    int i = paramnfv.a();
    int j = paramnfv.c();
    if (j == 3) {
      a(i, j, paramnfv);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GameRoomPresenterImp", 2, "onNeedCheckAndPlayAudioVideo gameStatus:" + i + " gameType:" + j);
      }
      return;
      if (j == 4) {
        b(i, j, paramnfv);
      }
    }
  }
  
  public void l(nfv paramnfv)
  {
    paramnfv = nnm.b().a();
    if (paramnfv != null) {
      paramnfv.a();
    }
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomPresenterImp", 2, "onNeedCheckAndReleaseAudioVideo");
    }
  }
  
  public void m(nfv paramnfv)
  {
    int i = paramnfv.a();
    int j = paramnfv.c();
    if ((i != 0) && (i != 10)) {
      if (j == 3) {
        c(i, j, paramnfv);
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (j != 4);
      d(i, j, paramnfv);
      return;
    }
    QLog.i("GameRoomPresenterImp", 2, "onNeedCheckAndPreloadAudioVideo gameStatus:" + i + " gameType:" + j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nii
 * JD-Core Version:    0.7.0.1
 */