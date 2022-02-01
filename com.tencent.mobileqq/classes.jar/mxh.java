import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.wtogether.WTogetherObserverImpl.1;
import com.tencent.av.wtogether.WTogetherObserverImpl.2;
import com.tencent.av.wtogether.data.ReqVideoAction;
import com.tencent.av.wtogether.media.WatchTogetherMediaPlayCtrl;
import com.tencent.qphone.base.util.QLog;

public abstract class mxh
  extends mxg
  implements Handler.Callback
{
  private long jdField_a_of_type_Long;
  protected final Handler a;
  public final VideoAppInterface a;
  private String jdField_a_of_type_JavaLangString;
  
  protected mxh(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  protected lfe a()
  {
    return lbz.a().a();
  }
  
  protected mxd a()
  {
    mxd localmxd = null;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null) {
      localmxd = (mxd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(15);
    }
    return localmxd;
  }
  
  protected myw a()
  {
    Object localObject = a();
    mxd localmxd = a();
    if (localmxd != null)
    {
      localObject = localmxd.b((lfe)localObject);
      if (localObject != null) {}
    }
    else
    {
      return null;
    }
    return ((myx)localObject).a;
  }
  
  protected abstract void a();
  
  protected void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new WTogetherObserverImpl.1(this, paramInt));
  }
  
  protected void a(myv parammyv, int paramInt, boolean paramBoolean)
  {
    if ((parammyv == null) || (!paramBoolean)) {}
    for (;;)
    {
      return;
      WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = VideoController.a().a();
      if (localWatchTogetherMediaPlayCtrl != null)
      {
        boolean bool = localWatchTogetherMediaPlayCtrl.i();
        long l = parammyv.a();
        float f = parammyv.a();
        switch (parammyv.jdField_a_of_type_Int)
        {
        }
        while (QLog.isColorLevel())
        {
          QLog.d("WTogether.ObserverImpl", 2, "updatePlayState playInfo[" + parammyv + "], forceFromAdmin[" + paramBoolean + "], isAdmin[" + bool + "], action[" + paramInt + "], curPlayTimeMs[" + l + "], curPlayRate[" + f + "]");
          return;
          localWatchTogetherMediaPlayCtrl.a();
          localWatchTogetherMediaPlayCtrl.a(f);
          continue;
          WTogetherObserverImpl.2 local2 = new WTogetherObserverImpl.2(this, localWatchTogetherMediaPlayCtrl, l, f);
          if (localWatchTogetherMediaPlayCtrl.e())
          {
            localWatchTogetherMediaPlayCtrl.a(local2);
            if (QLog.isColorLevel()) {
              QLog.d("WTogether.ObserverImpl", 2, "updatePlayState playInfo with delay task");
            }
          }
          else
          {
            if (!localWatchTogetherMediaPlayCtrl.a()) {
              localWatchTogetherMediaPlayCtrl.c();
            }
            if (localWatchTogetherMediaPlayCtrl.c())
            {
              localWatchTogetherMediaPlayCtrl.a(local2);
            }
            else
            {
              local2.run();
              continue;
              localWatchTogetherMediaPlayCtrl.f();
            }
          }
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString) {}
  
  protected void a(boolean paramBoolean, ReqVideoAction paramReqVideoAction)
  {
    QLog.d("WTogether.ObserverImpl", 1, "onAdminUpdatePlayStateResult isSuccess：=" + paramBoolean + ";action:=" + paramReqVideoAction.toString());
  }
  
  protected void a(boolean paramBoolean, myo parammyo)
  {
    if (!paramBoolean)
    {
      if (parammyo.b != 1019) {
        break label29;
      }
      a(2131695750);
    }
    for (;;)
    {
      b(paramBoolean, true, "onStartWTogetherRet");
      return;
      label29:
      if (parammyo.b == 1020) {
        a(2131695740);
      } else if (parammyo.b == 1021) {
        a(2131695741);
      } else {
        a(2131695755);
      }
    }
  }
  
  protected void a(boolean paramBoolean, mys parammys)
  {
    myw localmyw;
    boolean bool1;
    if (paramBoolean)
    {
      localmyw = a();
      if (localmyw == null) {
        break label129;
      }
      parammys = localmyw.a;
      bool1 = localmyw.e();
      paramBoolean = localmyw.b();
    }
    for (;;)
    {
      boolean bool2;
      if ((parammys != null) && (parammys.jdField_a_of_type_Myu != null))
      {
        bool2 = true;
        a(bool1, parammys);
      }
      for (bool1 = bool2;; bool1 = false)
      {
        mxd localmxd = a();
        if ((localmxd != null) && (parammys != null)) {
          localmxd.a(a(), parammys.jdField_a_of_type_Myu, bool1);
        }
        if (paramBoolean) {
          localmyw.b(false, "onReqVideoUrlResult");
        }
        return;
        parammys = a();
        if (parammys != null) {
          parammys.a(a(), null, false);
        }
        a(2131695726);
        return;
      }
      label129:
      parammys = null;
      paramBoolean = false;
      bool1 = false;
    }
  }
  
  protected void a(boolean paramBoolean, myv parammyv)
  {
    if ((parammyv == null) || (parammyv.jdField_a_of_type_Myu == null)) {}
    long l;
    String str;
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl;
    do
    {
      do
      {
        return;
        l = SystemClock.elapsedRealtime();
        str = parammyv.jdField_a_of_type_Myu.a();
        if ((!TextUtils.equals(str, this.jdField_a_of_type_JavaLangString)) || (Math.abs(l - this.jdField_a_of_type_Long) >= 500L)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("WTogether.ObserverImpl", 2, "startPlay, too frequency play same video. [" + parammyv + "]");
      return;
      localWatchTogetherMediaPlayCtrl = VideoController.a().a();
    } while (localWatchTogetherMediaPlayCtrl == null);
    this.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_JavaLangString = str;
    localWatchTogetherMediaPlayCtrl.a(parammyv, (int)parammyv.jdField_a_of_type_Long);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl = VideoController.a().a();
    if (localWatchTogetherMediaPlayCtrl != null) {
      localWatchTogetherMediaPlayCtrl.a();
    }
  }
  
  protected abstract void a(boolean paramBoolean1, boolean paramBoolean2, String paramString);
  
  protected void b(boolean paramBoolean, myo parammyo)
  {
    b(false, true, "onCloseWTogetherRet");
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    QLog.d("WTogether.ObserverImpl", 1, "onWatchTogetherModeChange, [ start:=" + paramBoolean1 + ",isAdmin:=" + paramBoolean2 + "], from[" + paramString + "]");
    WatchTogetherMediaPlayCtrl localWatchTogetherMediaPlayCtrl;
    if (paramBoolean1)
    {
      localWatchTogetherMediaPlayCtrl = VideoController.a().a();
      if ((localWatchTogetherMediaPlayCtrl != null) && (!localWatchTogetherMediaPlayCtrl.h())) {
        localWatchTogetherMediaPlayCtrl.a(true, paramBoolean2);
      }
    }
    for (;;)
    {
      a(paramBoolean1, paramBoolean2, paramString);
      return;
      if ((localWatchTogetherMediaPlayCtrl != null) && (localWatchTogetherMediaPlayCtrl.i() != paramBoolean2))
      {
        localWatchTogetherMediaPlayCtrl.a(paramBoolean2, "onWatchTogetherModeChange");
        continue;
        localWatchTogetherMediaPlayCtrl = VideoController.a().a();
        if ((localWatchTogetherMediaPlayCtrl != null) && (localWatchTogetherMediaPlayCtrl.h())) {
          localWatchTogetherMediaPlayCtrl.a(false, paramBoolean2);
        } else if ((localWatchTogetherMediaPlayCtrl != null) && (localWatchTogetherMediaPlayCtrl.i() != paramBoolean2)) {
          localWatchTogetherMediaPlayCtrl.a(paramBoolean2, "onWatchTogetherModeChange");
        }
      }
    }
  }
  
  protected void c(boolean paramBoolean, myo parammyo)
  {
    myw localmyw = a();
    myv localmyv;
    int i;
    if (paramBoolean) {
      if (localmyw == null)
      {
        localmyv = null;
        if ((localmyw != null) && (localmyw.b()))
        {
          a(true, localmyw.e());
          localmyw.b(false, "onQueryRoomInfoRet");
        }
        if ((localmyv != null) && (localmyw.a()))
        {
          if (parammyo.jdField_a_of_type_ComTencentAvWtogetherDataReqVideoAction != null) {
            break label125;
          }
          i = -1;
          label72:
          a(localmyv, i, localmyw.a());
          localmyw.a(false, "onQueryRoomInfoRet");
        }
      }
    }
    for (;;)
    {
      if ((!parammyo.jdField_a_of_type_Boolean) && (parammyo.b == 1009)) {
        a();
      }
      return;
      localmyv = localmyw.a;
      break;
      label125:
      i = parammyo.jdField_a_of_type_ComTencentAvWtogetherDataReqVideoAction.jdField_a_of_type_Int;
      break label72;
      if ((localmyw == null) || (localmyw.a == null) || (!localmyw.a.b())) {
        a(2131695726);
      }
    }
  }
  
  protected void d(boolean paramBoolean, myo parammyo)
  {
    a(paramBoolean, parammyo.jdField_a_of_type_ComTencentAvWtogetherDataReqVideoAction);
    if (!paramBoolean) {
      a(2131695742);
    }
  }
  
  protected void e(boolean paramBoolean, myo parammyo)
  {
    boolean bool = true;
    myw localmyw = a();
    if (paramBoolean)
    {
      if ((localmyw != null) && (localmyw.a != null) && (!localmyw.a.a())) {
        a(true, localmyw.e());
      }
      return;
    }
    if ((localmyw != null) && (localmyw.e())) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      a(false, paramBoolean);
      if (parammyo.b != 1020) {
        break;
      }
      a(2131695740);
      return;
    }
    if (parammyo.b == 1021)
    {
      a(2131695741);
      return;
    }
    a(2131695726);
  }
  
  protected void f(boolean paramBoolean, myo parammyo)
  {
    myw localmyw;
    if (paramBoolean)
    {
      localmyw = a();
      if (localmyw != null) {
        break label71;
      }
    }
    label71:
    for (myv localmyv = null;; localmyv = localmyw.a)
    {
      if ((localmyv != null) && (localmyw.a()))
      {
        a(localmyv, -1, localmyw.a());
        localmyw.a(false, "onSyncPlayInfoRet");
      }
      if ((!parammyo.jdField_a_of_type_Boolean) && (parammyo.b == 1009)) {
        a();
      }
      return;
    }
  }
  
  protected void g(boolean paramBoolean, myo parammyo)
  {
    b(false, false, "onQuitRoomRet");
  }
  
  protected void h(boolean paramBoolean, myo parammyo)
  {
    if ((!paramBoolean) && (parammyo.b != 1009)) {
      a(2131695732);
    }
    b(paramBoolean, false, "onEnterRoomRet");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mxh
 * JD-Core Version:    0.7.0.1
 */